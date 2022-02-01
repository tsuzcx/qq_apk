package com.tencent.mm.am;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.compatible.f.a;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.clt;
import com.tencent.mm.protocal.protobuf.cyb;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.vfs.u;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public final class e
  implements com.tencent.mm.an.i
{
  private boolean lAg;
  private Set<String> lAh;
  private com.tencent.mm.b.f<String, d> lAi;
  private Stack<j> lAj;
  private QueueWorkerThread lAk;
  private QueueWorkerThread lAl;
  private volatile String lAm;
  com.tencent.mm.b.f<String, String> lAn;
  private MTimerHandler lAo;
  
  public e()
  {
    AppMethodBeat.i(150226);
    this.lAg = false;
    this.lAh = Collections.synchronizedSet(new HashSet());
    this.lAi = new com.tencent.mm.memory.a.c(400);
    this.lAj = new Stack();
    this.lAk = null;
    this.lAl = null;
    this.lAn = new com.tencent.mm.memory.a.c(200);
    this.lAo = new MTimerHandler(Looper.getMainLooper(), new e.4(this), false);
    com.tencent.mm.kernel.h.aGY().a(123, this);
    this.lAg = false;
    this.lAm = z.bcZ();
    AppMethodBeat.o(150226);
  }
  
  private static j TC(String paramString)
  {
    AppMethodBeat.i(150230);
    Object localObject1 = q.bhP().TS(paramString);
    if ((localObject1 != null) && (((j)localObject1).getUsername().equals(paramString)))
    {
      Log.i("MicroMsg.AvatarService", "[isFlagNeed] getSmallUrl:%s username:%s", new Object[] { ((j)localObject1).bhI(), paramString });
      AppMethodBeat.o(150230);
      return localObject1;
    }
    Object localObject2 = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramString);
    if (((ax)localObject2).hDc == 4)
    {
      d.aH(paramString, ((ax)localObject2).hDc);
      Log.d("MicroMsg.AvatarService", "ct imgFlag :%s", new Object[] { Integer.valueOf(((ax)localObject2).hDc) });
      AppMethodBeat.o(150230);
      return null;
    }
    localObject1 = new j();
    ((j)localObject1).username = paramString;
    ((j)localObject1).hDc = 3;
    byte[] arrayOfByte = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().bwn(paramString);
    if (Util.isNullOrNil(arrayOfByte))
    {
      Log.i("MicroMsg.AvatarService", "[isFlagNeed] cmdBuf is null! username:%s", new Object[] { paramString });
      AppMethodBeat.o(150230);
      return localObject1;
    }
    try
    {
      localObject2 = d.a(paramString, (cyb)new cyb().parseFrom(arrayOfByte), (as)localObject2);
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.AvatarService", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      }
    }
    Log.i("MicroMsg.AvatarService", "[isFlagNeed] finally! getSmallUrl:%s getBigUrl:%s username:%s", new Object[] { ((j)localObject1).bhI(), ((j)localObject1).bhH(), paramString });
    AppMethodBeat.o(150230);
    return localObject1;
  }
  
  public static boolean TE(String paramString)
  {
    AppMethodBeat.i(190789);
    if (paramString == null)
    {
      AppMethodBeat.o(190789);
      return false;
    }
    boolean bool = paramString.startsWith("ammURL_");
    AppMethodBeat.o(190789);
    return bool;
  }
  
  private int a(final QueueWorkerThread.ThreadObject paramThreadObject)
  {
    AppMethodBeat.i(150232);
    if (paramThreadObject == null)
    {
      AppMethodBeat.o(150232);
      return -1;
    }
    com.tencent.e.h.ZvG.be(new com.tencent.e.i.h()
    {
      public final String getKey()
      {
        return "AvatarService#putAsyncTask";
      }
      
      public final void run()
      {
        AppMethodBeat.i(292869);
        paramThreadObject.doInBackground();
        paramThreadObject.onPostExecute();
        AppMethodBeat.o(292869);
      }
    });
    AppMethodBeat.o(150232);
    return 1;
  }
  
  private void aqG(final String paramString)
  {
    AppMethodBeat.i(292728);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(292728);
      return;
    }
    try
    {
      int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vFj, 1);
      if (i != 1)
      {
        AppMethodBeat.o(292728);
        return;
      }
      boolean bool = this.lAi.keySet().contains(paramString);
      if (!bool)
      {
        AppMethodBeat.o(292728);
        return;
      }
      com.tencent.e.h.ZvG.be(new com.tencent.e.i.j()
      {
        public final String getKey()
        {
          return "AvatarService#checkAvatarUpdateExpire";
        }
        
        public final boolean isLogging()
        {
          return false;
        }
        
        public final void run()
        {
          AppMethodBeat.i(150216);
          if (paramString.equals(e.a(e.this)))
          {
            AppMethodBeat.o(150216);
            return;
          }
          e.d locald = (e.d)e.b(e.this).aX(paramString);
          if ((locald != null) && (Util.nowSecond() - locald.kje > 21600L))
          {
            q.bhz();
            if (!u.agG(f.N(paramString, false)))
            {
              Log.i("MicroMsg.AvatarService", "checkAvatarUpdateExpire refresh username:%s, lastTime:%s, retryCount:%s", new Object[] { Util.nullAs(paramString, ""), Long.valueOf(locald.kje), Integer.valueOf(locald.kQn) });
              e.b(e.this).remove(paramString);
              e.this.TB(paramString);
            }
          }
          AppMethodBeat.o(150216);
        }
        
        public final String toString()
        {
          AppMethodBeat.i(292870);
          String str = super.toString() + "|checkAvatarUpdateExpire";
          AppMethodBeat.o(292870);
          return str;
        }
      });
      AppMethodBeat.o(292728);
      return;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.AvatarService", "checkAvatarUpdateExpire %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(292728);
    }
  }
  
  private static f bhz()
  {
    AppMethodBeat.i(150234);
    if (com.tencent.mm.kernel.h.aHE().aGM())
    {
      f localf = q.bhz();
      AppMethodBeat.o(150234);
      return localf;
    }
    AppMethodBeat.o(150234);
    return null;
  }
  
  public final Bitmap M(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(190755);
    paramString = b(paramString, paramBoolean, 0, null);
    AppMethodBeat.o(190755);
    return paramString;
  }
  
  public final void Rv(final String paramString)
  {
    AppMethodBeat.i(150229);
    com.tencent.e.h.ZvG.be(new com.tencent.e.i.j()
    {
      public final String getKey()
      {
        return "AvatarService#checkAvatarExpire";
      }
      
      public final boolean isLogging()
      {
        return false;
      }
      
      public final void run()
      {
        AppMethodBeat.i(150214);
        if (Util.isNullOrNil(paramString))
        {
          AppMethodBeat.o(150214);
          return;
        }
        if (paramString.equals(e.a(e.this)))
        {
          Log.i("MicroMsg.AvatarService", "thisUser is empty!!");
          AppMethodBeat.o(150214);
          return;
        }
        Object localObject = e.bhA();
        if (localObject == null)
        {
          Log.i("MicroMsg.AvatarService", "istg is null!!");
          AppMethodBeat.o(150214);
          return;
        }
        localObject = ((k)localObject).TS(paramString);
        if ((localObject == null) || (!((j)localObject).getUsername().equals(paramString)))
        {
          Log.i("MicroMsg.AvatarService", "imgFlag is null or username not equal");
          AppMethodBeat.o(150214);
          return;
        }
        if (Util.nowSecond() - ((j)localObject).lBg * 60L > 86400L) {}
        for (int i = 1; i == 0; i = 0)
        {
          Log.i("MicroMsg.AvatarService", "imgFlag is expired!!");
          AppMethodBeat.o(150214);
          return;
        }
        if (Util.isNullOrNil(((j)localObject).bhI()))
        {
          Log.w("MicroMsg.AvatarService", "dkhurl user has no url [%s]", new Object[] { paramString });
          AppMethodBeat.o(150214);
          return;
        }
        e.this.TB(paramString);
        AppMethodBeat.o(150214);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(150215);
        String str = super.toString() + "|checkAvatarExpire";
        AppMethodBeat.o(150215);
        return str;
      }
    });
    AppMethodBeat.o(150229);
  }
  
  public final void TB(String paramString)
  {
    AppMethodBeat.i(150228);
    a(new c(paramString));
    AppMethodBeat.o(150228);
  }
  
  public final String TD(String paramString)
  {
    AppMethodBeat.i(150235);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150235);
      return "";
    }
    try
    {
      String str1 = String.format("%s%x_%s", new Object[] { "ammURL_", Integer.valueOf(paramString.hashCode()), paramString.substring(paramString.length() - 24, paramString.length() - 4) });
      this.lAn.put(str1, paramString);
      AppMethodBeat.o(150235);
      return str1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str2 = String.format("%s%x_", new Object[] { "ammURL_", Integer.valueOf(paramString.hashCode()) });
      }
    }
  }
  
  public final Bitmap b(String paramString, boolean paramBoolean, int paramInt, c paramc)
  {
    AppMethodBeat.i(190758);
    f localf = bhz();
    Bitmap localBitmap2;
    if (localf != null) {
      if ((paramInt >= 0) && (paramInt > 5))
      {
        localBitmap2 = f.TF(String.format("%s$$%d", new Object[] { paramString, Integer.valueOf(paramInt) }));
        if (localBitmap2 != null)
        {
          Log.i("MicroMsg.AvatarService", "find custom corner avatar, custom corner %d", new Object[] { Integer.valueOf(paramInt) });
          aqG(paramString);
          AppMethodBeat.o(190758);
          return localBitmap2;
        }
        Log.i("MicroMsg.AvatarService", "can not find custom corner avatar, custom corner %d", new Object[] { Integer.valueOf(paramInt) });
        localBitmap1 = localBitmap2;
        if (localBitmap2 != null) {}
      }
    }
    for (Bitmap localBitmap1 = f.TF(paramString);; localBitmap1 = null)
    {
      if (localBitmap1 != null)
      {
        paramc = localBitmap1;
        if (paramInt >= 0)
        {
          paramc = localBitmap1;
          if (paramInt > 5)
          {
            Log.i("MicroMsg.AvatarService", "create custom corner avatar, custom corner %d", new Object[] { Integer.valueOf(paramInt) });
            paramc = BitmapUtil.getRoundedCornerBitmap(localBitmap1, false, paramInt);
            localf.d(String.format("%s$$%d", new Object[] { paramString, Integer.valueOf(paramInt) }), paramc);
          }
        }
        aqG(paramString);
        AppMethodBeat.o(190758);
        return paramc;
      }
      if (paramBoolean)
      {
        aqG(paramString);
        AppMethodBeat.o(190758);
        return null;
      }
      Log.v("MicroMsg.AvatarService", "get bitmap from cache failed, try to load :%s", new Object[] { paramString });
      if (this.lAh.contains(paramString))
      {
        aqG(paramString);
        AppMethodBeat.o(190758);
        return null;
      }
      this.lAh.add(paramString);
      a(new c(paramString, paramc));
      AppMethodBeat.o(190758);
      return null;
      localBitmap2 = null;
      break;
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(150231);
    while (this.lAj.size() > 0) {
      this.lAh.remove(this.lAj.pop());
    }
    AppMethodBeat.o(150231);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(150233);
    if (paramq == null)
    {
      AppMethodBeat.o(150233);
      return;
    }
    if (paramq.getType() != 123)
    {
      AppMethodBeat.o(150233);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(138L, 12L, 1L, true);
    }
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(138L, 45L, 1L, true);
    Object localObject;
    clt localclt;
    try
    {
      paramq = (l)paramq;
      paramString = new HashSet();
      if (paramq.lBj != null)
      {
        localObject = paramq.lBj.iterator();
        for (;;)
        {
          if (((Iterator)localObject).hasNext())
          {
            localclt = (clt)((Iterator)localObject).next();
            if ((localclt == null) || (localclt.TtE == null))
            {
              Log.i("MicroMsg.AvatarService", "error p is null or username is null %s", new Object[] { localclt });
              continue;
              this.lAg = false;
            }
          }
        }
      }
    }
    catch (NullPointerException paramString)
    {
      Log.e("MicroMsg.AvatarService", "[onSceneEnd] NullPointerException:%s", new Object[] { paramString });
    }
    for (;;)
    {
      if (this.lAj.size() > 0) {
        this.lAo.startTimer(0L);
      }
      AppMethodBeat.o(150233);
      return;
      String str = localclt.TtE.Ufy;
      if ((localclt.RIH == null) || (localclt.RIH.Tkb == null) || (localclt.RIH.Tkb.UH == null))
      {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(138L, 11L, 1L, true);
        break;
      }
      paramString.add(str);
      j localj = new j();
      localj.username = str;
      localj.hDc = 3;
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(138L, 43L, 1L, true);
      a(new e(localj, localclt.RIH.Tkb.UH));
      break;
      if (paramq.lBi != null)
      {
        paramq = paramq.lBi.iterator();
        while (paramq.hasNext())
        {
          localObject = (eaf)paramq.next();
          if (localObject != null)
          {
            localObject = ((eaf)localObject).Ufy;
            if (!paramString.contains(localObject)) {
              this.lAh.remove(localObject);
            }
          }
        }
      }
    }
  }
  
  final class a
    implements QueueWorkerThread.ThreadObject
  {
    boolean bqe;
    j lAs;
    byte[] lAt;
    byte[] lAu;
    
    public a(j paramj, byte[] paramArrayOfByte, boolean paramBoolean)
    {
      this.lAs = paramj;
      this.lAt = paramArrayOfByte;
      this.bqe = paramBoolean;
    }
    
    public final boolean doInBackground()
    {
      AppMethodBeat.i(150218);
      byte[] arrayOfByte;
      if (this.bqe)
      {
        Log.i("MicroMsg.AvatarService", "DecryptAvatar: decrypt");
        com.tencent.mm.plugin.report.service.h.IzE.el(138, 51);
        arrayOfByte = UtilsJni.DecryptAvatar(this.lAt);
        if (Util.isNullOrNil(arrayOfByte))
        {
          com.tencent.mm.plugin.report.service.h.IzE.el(138, 52);
          Log.i("MicroMsg.AvatarService", "DecryptAvatar: decrypt output empty");
          AppMethodBeat.o(150218);
          return false;
        }
      }
      else
      {
        arrayOfByte = this.lAt;
      }
      for (;;)
      {
        if (ImgUtil.isWXGF(arrayOfByte))
        {
          Log.i("MicroMsg.AvatarService", "DecryptAvatar: hevc to pic");
          com.tencent.mm.plugin.report.service.h.IzE.el(138, 53);
          this.lAu = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.emoji.b.c.class)).bA(arrayOfByte);
          if (Util.isNullOrNil(this.lAu))
          {
            com.tencent.mm.plugin.report.service.h.IzE.el(138, 54);
            Log.i("MicroMsg.AvatarService", "DecryptAvatar: output is empty");
            AppMethodBeat.o(150218);
            return false;
          }
        }
        else
        {
          this.lAu = arrayOfByte;
        }
        AppMethodBeat.o(150218);
        return true;
      }
    }
    
    public final boolean onPostExecute()
    {
      AppMethodBeat.i(150219);
      if (!Util.isNullOrNil(this.lAu))
      {
        Log.i("MicroMsg.AvatarService", "DecryptAvatar: post to save length is %s", new Object[] { Integer.valueOf(this.lAu.length) });
        e.a(e.this, new e.e(e.this, this.lAs, this.lAu));
        AppMethodBeat.o(150219);
        return true;
      }
      Log.i("MicroMsg.AvatarService", "DecryptAvatar: onPostExecute output is empty");
      AppMethodBeat.o(150219);
      return false;
    }
  }
  
  final class c
    implements QueueWorkerThread.ThreadObject
  {
    Bitmap lAx = null;
    c lAy = null;
    String username = null;
    
    public c(String paramString)
    {
      this.username = paramString;
    }
    
    public c(String paramString, c paramc)
    {
      this.username = paramString;
      this.lAy = paramc;
    }
    
    public final boolean doInBackground()
    {
      Context localContext = null;
      Object localObject1 = null;
      int i = 0;
      AppMethodBeat.i(150222);
      if (Util.isNullOrNil(this.username))
      {
        AppMethodBeat.o(150222);
        return false;
      }
      String str1 = this.username;
      String str2;
      Object localObject2;
      if (e.TE(str1))
      {
        str2 = (String)e.this.lAn.get(str1);
        if (!Util.isNullOrNil(str2))
        {
          localObject2 = q.bhP().TS(str1);
          if ((localObject2 == null) || (!str1.equals(((j)localObject2).getUsername())))
          {
            localObject2 = q.bhP();
            String str3 = "select img_flag.username,img_flag.imgflag,img_flag.lastupdatetime,img_flag.reserved1,img_flag.reserved2,img_flag.reserved3,img_flag.reserved4 from img_flag where img_flag.reserved2=\"" + Util.escapeSqlValue(str2) + "\"";
            localObject2 = ((k)localObject2).lvy.rawQuery(str3, null, 2);
            if (localObject2 != null) {
              break label248;
            }
          }
        }
      }
      for (;;)
      {
        if ((localObject1 != null) && (!Util.isNullOrNil(((j)localObject1).getUsername()))) {
          u.on(d.Tz(((j)localObject1).getUsername()), d.Tz(str1));
        }
        localObject1 = new j();
        ((j)localObject1).username = str1;
        ((j)localObject1).hDc = 3;
        ((j)localObject1).lBd = str2;
        ((j)localObject1).lBe = str2;
        ((j)localObject1).cUP = 3;
        ((j)localObject1).gg(true);
        ((j)localObject1).cUP = 31;
        q.bhP().b((j)localObject1);
        localObject1 = e.bAl();
        if (localObject1 != null) {
          break;
        }
        AppMethodBeat.o(150222);
        return false;
        label248:
        localObject1 = localContext;
        if (((Cursor)localObject2).moveToFirst())
        {
          ((Cursor)localObject2).moveToFirst();
          localObject1 = new j();
          ((j)localObject1).convertFrom((Cursor)localObject2);
        }
        ((Cursor)localObject2).close();
      }
      if (f.lAB.containsKey(this.username)) {
        i = ((Integer)f.lAB.get(this.username)).intValue();
      }
      if (i != 0)
      {
        q.bhO();
        localContext = q.getContext();
        if (localContext != null) {
          ((f)localObject1).e(this.username, a.decodeResource(localContext.getResources(), i));
        }
      }
      this.lAx = f.TI(this.username);
      AppMethodBeat.o(150222);
      return true;
    }
    
    public final boolean onPostExecute()
    {
      AppMethodBeat.i(150223);
      if (this.lAx == null)
      {
        e.a(e.this, this.username, this.lAy);
        AppMethodBeat.o(150223);
        return false;
      }
      f localf = e.bAl();
      if (localf != null) {
        localf.d(this.username, this.lAx);
      }
      e.f(e.this).remove(this.username);
      AppMethodBeat.o(150223);
      return false;
    }
  }
  
  static final class d
  {
    public int kQn = 0;
    public long kje = 0L;
  }
  
  final class e
    implements QueueWorkerThread.ThreadObject
  {
    Bitmap bitmap = null;
    byte[] buf;
    j lAs = null;
    
    public e(j paramj, byte[] paramArrayOfByte)
    {
      this.lAs = paramj;
      this.buf = paramArrayOfByte;
    }
    
    public final boolean doInBackground()
    {
      AppMethodBeat.i(150224);
      if ((this.lAs == null) || (Util.isNullOrNil(this.lAs.getUsername())))
      {
        Log.e("MicroMsg.AvatarService", "SaveAvatar imgFlag info is null");
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(138L, 13L, 1L, true);
        AppMethodBeat.o(150224);
        return false;
      }
      if (e.bAl() != null)
      {
        f.P(this.lAs.getUsername(), false);
        f.P(this.lAs.getUsername(), true);
        this.bitmap = f.g(this.lAs.getUsername(), this.buf);
        if (this.bitmap == null) {
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(138L, 14L, 1L, true);
        }
      }
      for (;;)
      {
        k localk = e.bhA();
        if (localk != null)
        {
          this.lAs.cUP = -1;
          this.lAs.bhJ();
          localk.b(this.lAs);
        }
        AppMethodBeat.o(150224);
        return true;
        Log.i("MicroMsg.AvatarService", "astg is null!!");
      }
    }
    
    public final boolean onPostExecute()
    {
      AppMethodBeat.i(150225);
      if (Util.isNullOrNil(this.lAs.getUsername()))
      {
        AppMethodBeat.o(150225);
        return false;
      }
      f localf = e.bAl();
      if ((localf != null) && (this.bitmap != null)) {
        localf.d(this.lAs.getUsername(), this.bitmap);
      }
      e.f(e.this).remove(this.lAs.getUsername());
      try
      {
        if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vFj, 1) == 1) {
          e.b(e.this).remove(this.lAs.getUsername());
        }
        AppMethodBeat.o(150225);
        return false;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("MicroMsg.AvatarService", "SaveAvatar %s", new Object[] { localException.getMessage() });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.am.e
 * JD-Core Version:    0.7.0.1
 */