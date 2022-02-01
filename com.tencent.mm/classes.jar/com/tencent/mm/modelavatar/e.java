package com.tencent.mm.modelavatar;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.b.f;
import com.tencent.mm.compatible.f.a;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.dcb;
import com.tencent.mm.protocal.protobuf.dph;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.i;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public final class e
  implements com.tencent.mm.am.h
{
  private boolean orH;
  private Set<String> orI;
  private f<String, d> orJ;
  private Stack<j> orK;
  private QueueWorkerThread orL;
  private QueueWorkerThread orM;
  private volatile String orN;
  f<String, String> orO;
  private MTimerHandler orP;
  
  public e()
  {
    AppMethodBeat.i(150226);
    this.orH = false;
    this.orI = Collections.synchronizedSet(new HashSet());
    this.orJ = new com.tencent.mm.memory.a.c(400);
    this.orK = new Stack();
    this.orL = null;
    this.orM = null;
    this.orO = new com.tencent.mm.memory.a.c(200);
    this.orP = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      private long orS = 0L;
      
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(231369);
        long l = System.currentTimeMillis();
        if ((e.c(e.this)) && (l - this.orS > 60000L))
        {
          Log.w("MicroMsg.AvatarService", "do scene TIMEOUT: %d", new Object[] { Long.valueOf(l - this.orS) });
          e.a(e.this, false);
        }
        if (e.c(e.this))
        {
          e.d(e.this).startTimer(1000L);
          AppMethodBeat.o(231369);
          return false;
        }
        this.orS = l;
        e.a(e.this, true);
        LinkedList localLinkedList = new LinkedList();
        int i = 0;
        while ((i < 5) && (e.e(e.this).size() > 0))
        {
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(138L, 42L, 1L, true);
          localLinkedList.add(new etl().btH(Util.nullAsNil(((j)e.e(e.this).pop()).getUsername())));
          i += 1;
        }
        com.tencent.mm.kernel.h.aZW().a(new l(localLinkedList), 0);
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(138L, 44L, 1L, true);
        AppMethodBeat.o(231369);
        return false;
      }
    }, false);
    com.tencent.mm.kernel.h.aZW().a(123, this);
    this.orH = false;
    this.orN = z.bAM();
    AppMethodBeat.o(150226);
  }
  
  private void LD(final String paramString)
  {
    AppMethodBeat.i(231365);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(231365);
      return;
    }
    try
    {
      int i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yUH, 1);
      if (i != 1)
      {
        AppMethodBeat.o(231365);
        return;
      }
      boolean bool = this.orJ.keySet().contains(paramString);
      if (!bool)
      {
        AppMethodBeat.o(231365);
        return;
      }
      com.tencent.threadpool.h.ahAA.bm(new com.tencent.threadpool.i.j()
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
          e.d locald = (e.d)e.b(e.this).ct(paramString);
          if ((locald != null) && (Util.nowSecond() - locald.mJI > 21600L))
          {
            q.bFp();
            if (!y.ZC(AvatarStorage.Q(paramString, false)))
            {
              Log.i("MicroMsg.AvatarService", "checkAvatarUpdateExpire refresh username:%s, lastTime:%s, retryCount:%s", new Object[] { Util.nullAs(paramString, ""), Long.valueOf(locald.mJI), Integer.valueOf(locald.nrQ) });
              e.b(e.this).remove(paramString);
              e.this.LB(paramString);
            }
          }
          AppMethodBeat.o(150216);
        }
        
        public final String toString()
        {
          AppMethodBeat.i(231368);
          String str = super.toString() + "|checkAvatarUpdateExpire";
          AppMethodBeat.o(231368);
          return str;
        }
      });
      AppMethodBeat.o(231365);
      return;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.AvatarService", "checkAvatarUpdateExpire %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(231365);
    }
  }
  
  private static j LE(String paramString)
  {
    AppMethodBeat.i(150230);
    Object localObject1 = q.bFE().LS(paramString);
    if ((localObject1 != null) && (((j)localObject1).getUsername().equals(paramString)))
    {
      Log.i("MicroMsg.AvatarService", "[isFlagNeed] getSmallUrl:%s username:%s", new Object[] { ((j)localObject1).bFx(), paramString });
      AppMethodBeat.o(150230);
      return localObject1;
    }
    Object localObject2 = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramString);
    if (((az)localObject2).jZY == 4)
    {
      d.aS(paramString, ((az)localObject2).jZY);
      Log.d("MicroMsg.AvatarService", "ct imgFlag :%s", new Object[] { Integer.valueOf(((az)localObject2).jZY) });
      AppMethodBeat.o(150230);
      return null;
    }
    localObject1 = new j();
    ((j)localObject1).username = paramString;
    ((j)localObject1).jZY = 3;
    byte[] arrayOfByte = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().bxA(paramString);
    if (Util.isNullOrNil(arrayOfByte))
    {
      Log.i("MicroMsg.AvatarService", "[isFlagNeed] cmdBuf is null! username:%s", new Object[] { paramString });
      AppMethodBeat.o(150230);
      return localObject1;
    }
    try
    {
      localObject2 = d.a(paramString, (dph)new dph().parseFrom(arrayOfByte), (au)localObject2);
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.AvatarService", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      }
    }
    Log.i("MicroMsg.AvatarService", "[isFlagNeed] finally! getSmallUrl:%s getBigUrl:%s username:%s", new Object[] { ((j)localObject1).bFx(), ((j)localObject1).bFw(), paramString });
    AppMethodBeat.o(150230);
    return localObject1;
  }
  
  public static boolean LG(String paramString)
  {
    AppMethodBeat.i(231374);
    if (paramString == null)
    {
      AppMethodBeat.o(231374);
      return false;
    }
    boolean bool = paramString.startsWith("ammURL_");
    AppMethodBeat.o(231374);
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
    com.tencent.threadpool.h.ahAA.bm(new com.tencent.threadpool.i.h()
    {
      public final String getKey()
      {
        return "AvatarService#putAsyncTask";
      }
      
      public final void run()
      {
        AppMethodBeat.i(231363);
        paramThreadObject.doInBackground();
        paramThreadObject.onPostExecute();
        AppMethodBeat.o(231363);
      }
    });
    AppMethodBeat.o(150232);
    return 1;
  }
  
  private static AvatarStorage bFp()
  {
    AppMethodBeat.i(150234);
    if (com.tencent.mm.kernel.h.baC().aZN())
    {
      AvatarStorage localAvatarStorage = q.bFp();
      AppMethodBeat.o(150234);
      return localAvatarStorage;
    }
    AppMethodBeat.o(150234);
    return null;
  }
  
  public final void LB(String paramString)
  {
    AppMethodBeat.i(150228);
    a(new c(paramString));
    AppMethodBeat.o(150228);
  }
  
  public final void LC(final String paramString)
  {
    AppMethodBeat.i(150229);
    com.tencent.threadpool.h.ahAA.bm(new com.tencent.threadpool.i.j()
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
        Object localObject = e.bFq();
        if (localObject == null)
        {
          Log.i("MicroMsg.AvatarService", "istg is null!!");
          AppMethodBeat.o(150214);
          return;
        }
        localObject = ((k)localObject).LS(paramString);
        if ((localObject == null) || (!((j)localObject).getUsername().equals(paramString)))
        {
          Log.i("MicroMsg.AvatarService", "imgFlag is null or username not equal");
          AppMethodBeat.o(150214);
          return;
        }
        if (Util.nowSecond() - ((j)localObject).osP * 60L > 86400L) {}
        for (int i = 1; i == 0; i = 0)
        {
          Log.i("MicroMsg.AvatarService", "imgFlag is expired!!");
          AppMethodBeat.o(150214);
          return;
        }
        if (Util.isNullOrNil(((j)localObject).bFx()))
        {
          Log.w("MicroMsg.AvatarService", "dkhurl user has no url [%s]", new Object[] { paramString });
          AppMethodBeat.o(150214);
          return;
        }
        e.this.LB(paramString);
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
  
  public final String LF(String paramString)
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
      this.orO.put(str1, paramString);
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
    AppMethodBeat.i(231385);
    AvatarStorage localAvatarStorage = bFp();
    Bitmap localBitmap2;
    if (localAvatarStorage != null) {
      if ((paramInt >= 0) && (paramInt > 5))
      {
        localBitmap2 = AvatarStorage.LH(String.format("%s$$%d", new Object[] { paramString, Integer.valueOf(paramInt) }));
        if (localBitmap2 != null)
        {
          Log.i("MicroMsg.AvatarService", "find custom corner avatar, custom corner %d", new Object[] { Integer.valueOf(paramInt) });
          LD(paramString);
          AppMethodBeat.o(231385);
          return localBitmap2;
        }
        Log.i("MicroMsg.AvatarService", "can not find custom corner avatar, custom corner %d", new Object[] { Integer.valueOf(paramInt) });
        localBitmap1 = localBitmap2;
        if (localBitmap2 != null) {}
      }
    }
    for (Bitmap localBitmap1 = AvatarStorage.LH(paramString);; localBitmap1 = null)
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
            localAvatarStorage.d(String.format("%s$$%d", new Object[] { paramString, Integer.valueOf(paramInt) }), paramc);
          }
        }
        LD(paramString);
        AppMethodBeat.o(231385);
        return paramc;
      }
      if (paramBoolean)
      {
        LD(paramString);
        AppMethodBeat.o(231385);
        return null;
      }
      Log.v("MicroMsg.AvatarService", "get bitmap from cache failed, try to load :%s", new Object[] { paramString });
      if (this.orI.contains(paramString))
      {
        LD(paramString);
        AppMethodBeat.o(231385);
        return null;
      }
      this.orI.add(paramString);
      a(new c(paramString, paramc));
      AppMethodBeat.o(231385);
      return null;
      localBitmap2 = null;
      break;
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(150231);
    while (this.orK.size() > 0) {
      this.orI.remove(this.orK.pop());
    }
    AppMethodBeat.o(150231);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(150233);
    if (paramp == null)
    {
      AppMethodBeat.o(150233);
      return;
    }
    if (paramp.getType() != 123)
    {
      AppMethodBeat.o(150233);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(138L, 12L, 1L, true);
    }
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(138L, 45L, 1L, true);
    Object localObject;
    dcb localdcb;
    try
    {
      paramp = (l)paramp;
      paramString = new HashSet();
      if (paramp.osS != null)
      {
        localObject = paramp.osS.iterator();
        for (;;)
        {
          if (((Iterator)localObject).hasNext())
          {
            localdcb = (dcb)((Iterator)localObject).next();
            if ((localdcb == null) || (localdcb.aaHP == null))
            {
              Log.i("MicroMsg.AvatarService", "error p is null or username is null %s", new Object[] { localdcb });
              continue;
              this.orH = false;
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
      if (this.orK.size() > 0) {
        this.orP.startTimer(0L);
      }
      AppMethodBeat.o(150233);
      return;
      String str = localdcb.aaHP.abwM;
      if ((localdcb.YFI == null) || (localdcb.YFI.aaxD == null) || (localdcb.YFI.aaxD.Op == null))
      {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(138L, 11L, 1L, true);
        break;
      }
      paramString.add(str);
      j localj = new j();
      localj.username = str;
      localj.jZY = 3;
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(138L, 43L, 1L, true);
      a(new e(localj, localdcb.YFI.aaxD.Op));
      break;
      if (paramp.osR != null)
      {
        paramp = paramp.osR.iterator();
        while (paramp.hasNext())
        {
          localObject = (etl)paramp.next();
          if (localObject != null)
          {
            localObject = ((etl)localObject).abwM;
            if (!paramString.contains(localObject)) {
              this.orI.remove(localObject);
            }
          }
        }
      }
    }
  }
  
  final class a
    implements QueueWorkerThread.ThreadObject
  {
    boolean djI;
    j orT;
    byte[] orU;
    byte[] orV;
    
    public a(j paramj, byte[] paramArrayOfByte, boolean paramBoolean)
    {
      this.orT = paramj;
      this.orU = paramArrayOfByte;
      this.djI = paramBoolean;
    }
    
    public final boolean doInBackground()
    {
      AppMethodBeat.i(150218);
      byte[] arrayOfByte;
      if (this.djI)
      {
        Log.i("MicroMsg.AvatarService", "DecryptAvatar: decrypt");
        com.tencent.mm.plugin.report.service.h.OAn.kJ(138, 51);
        arrayOfByte = UtilsJni.DecryptAvatar(this.orU);
        if (Util.isNullOrNil(arrayOfByte))
        {
          com.tencent.mm.plugin.report.service.h.OAn.kJ(138, 52);
          Log.i("MicroMsg.AvatarService", "DecryptAvatar: decrypt output empty");
          AppMethodBeat.o(150218);
          return false;
        }
      }
      else
      {
        arrayOfByte = this.orU;
      }
      for (;;)
      {
        if (ImgUtil.isWXGF(arrayOfByte))
        {
          Log.i("MicroMsg.AvatarService", "DecryptAvatar: hevc to pic");
          com.tencent.mm.plugin.report.service.h.OAn.kJ(138, 53);
          this.orV = ((com.tencent.mm.plugin.emoji.c.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.emoji.c.c.class)).bA(arrayOfByte);
          if (Util.isNullOrNil(this.orV))
          {
            com.tencent.mm.plugin.report.service.h.OAn.kJ(138, 54);
            Log.i("MicroMsg.AvatarService", "DecryptAvatar: output is empty");
            AppMethodBeat.o(150218);
            return false;
          }
        }
        else
        {
          this.orV = arrayOfByte;
        }
        AppMethodBeat.o(150218);
        return true;
      }
    }
    
    public final boolean onPostExecute()
    {
      AppMethodBeat.i(150219);
      if (!Util.isNullOrNil(this.orV))
      {
        Log.i("MicroMsg.AvatarService", "DecryptAvatar: post to save length is %s", new Object[] { Integer.valueOf(this.orV.length) });
        e.a(e.this, new e.e(e.this, this.orT, this.orV));
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
    Bitmap orY = null;
    c orZ = null;
    String username = null;
    
    public c(String paramString)
    {
      this.username = paramString;
    }
    
    public c(String paramString, c paramc)
    {
      this.username = paramString;
      this.orZ = paramc;
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
      if (e.LG(str1))
      {
        str2 = (String)e.this.orO.get(str1);
        if (!Util.isNullOrNil(str2))
        {
          localObject2 = q.bFE().LS(str1);
          if ((localObject2 == null) || (!str1.equals(((j)localObject2).getUsername())))
          {
            localObject2 = q.bFE();
            String str3 = "select img_flag.username,img_flag.imgflag,img_flag.lastupdatetime,img_flag.reserved1,img_flag.reserved2,img_flag.reserved3,img_flag.reserved4 from img_flag where img_flag.reserved2=\"" + Util.escapeSqlValue(str2) + "\"";
            localObject2 = ((k)localObject2).omV.rawQuery(str3, null, 2);
            if (localObject2 != null) {
              break label249;
            }
          }
        }
      }
      for (;;)
      {
        if ((localObject1 != null) && (!Util.isNullOrNil(((j)localObject1).getUsername()))) {
          y.O(d.Lz(((j)localObject1).getUsername()), d.Lz(str1), false);
        }
        localObject1 = new j();
        ((j)localObject1).username = str1;
        ((j)localObject1).jZY = 3;
        ((j)localObject1).osM = str2;
        ((j)localObject1).osN = str2;
        ((j)localObject1).eQp = 3;
        ((j)localObject1).gX(true);
        ((j)localObject1).eQp = 31;
        q.bFE().b((j)localObject1);
        localObject1 = e.bFr();
        if (localObject1 != null) {
          break;
        }
        AppMethodBeat.o(150222);
        return false;
        label249:
        localObject1 = localContext;
        if (((Cursor)localObject2).moveToFirst())
        {
          ((Cursor)localObject2).moveToFirst();
          localObject1 = new j();
          ((j)localObject1).convertFrom((Cursor)localObject2);
        }
        ((Cursor)localObject2).close();
      }
      if (AvatarStorage.osc.containsKey(this.username)) {
        i = ((Integer)AvatarStorage.osc.get(this.username)).intValue();
      }
      if (i != 0)
      {
        q.bFD();
        localContext = q.getContext();
        if (localContext != null) {
          ((AvatarStorage)localObject1).e(this.username, a.decodeResource(localContext.getResources(), i));
        }
      }
      this.orY = AvatarStorage.LI(this.username);
      AppMethodBeat.o(150222);
      return true;
    }
    
    public final boolean onPostExecute()
    {
      AppMethodBeat.i(150223);
      if (this.orY == null)
      {
        e.a(e.this, this.username, this.orZ);
        AppMethodBeat.o(150223);
        return false;
      }
      AvatarStorage localAvatarStorage = e.bFr();
      if (localAvatarStorage != null) {
        localAvatarStorage.d(this.username, this.orY);
      }
      e.f(e.this).remove(this.username);
      AppMethodBeat.o(150223);
      return false;
    }
  }
  
  static final class d
  {
    public long mJI = 0L;
    public int nrQ = 0;
  }
  
  final class e
    implements QueueWorkerThread.ThreadObject
  {
    Bitmap bitmap = null;
    byte[] buf;
    j orT = null;
    
    public e(j paramj, byte[] paramArrayOfByte)
    {
      this.orT = paramj;
      this.buf = paramArrayOfByte;
    }
    
    public final boolean doInBackground()
    {
      AppMethodBeat.i(150224);
      if ((this.orT == null) || (Util.isNullOrNil(this.orT.getUsername())))
      {
        Log.e("MicroMsg.AvatarService", "SaveAvatar imgFlag info is null");
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(138L, 13L, 1L, true);
        AppMethodBeat.o(150224);
        return false;
      }
      if (e.bFr() != null)
      {
        AvatarStorage.T(this.orT.getUsername(), false);
        AvatarStorage.T(this.orT.getUsername(), true);
        this.bitmap = AvatarStorage.i(this.orT.getUsername(), this.buf);
        if (this.bitmap == null) {
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(138L, 14L, 1L, true);
        }
      }
      for (;;)
      {
        k localk = e.bFq();
        if (localk != null)
        {
          this.orT.eQp = -1;
          this.orT.bFy();
          localk.b(this.orT);
        }
        AppMethodBeat.o(150224);
        return true;
        Log.i("MicroMsg.AvatarService", "astg is null!!");
      }
    }
    
    public final boolean onPostExecute()
    {
      AppMethodBeat.i(150225);
      if (Util.isNullOrNil(this.orT.getUsername()))
      {
        AppMethodBeat.o(150225);
        return false;
      }
      AvatarStorage localAvatarStorage = e.bFr();
      if ((localAvatarStorage != null) && (this.bitmap != null)) {
        localAvatarStorage.d(this.orT.getUsername(), this.bitmap);
      }
      e.f(e.this).remove(this.orT.getUsername());
      try
      {
        if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yUH, 1) == 1) {
          e.b(e.this).remove(this.orT.getUsername());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelavatar.e
 * JD-Core Version:    0.7.0.1
 */