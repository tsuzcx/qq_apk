package com.tencent.mm.ak;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bpo;
import com.tencent.mm.protocal.protobuf.bzp;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.be.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bp;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public final class d
  implements com.tencent.mm.al.f
{
  boolean hMb;
  Set<String> hMc;
  com.tencent.mm.b.f<String, d> hMd;
  Stack<i> hMe;
  private be hMf;
  private be hMg;
  String hMh;
  com.tencent.mm.b.f<String, String> hMi;
  av hMj;
  
  public d()
  {
    AppMethodBeat.i(150226);
    this.hMb = false;
    this.hMc = Collections.synchronizedSet(new HashSet());
    this.hMd = new com.tencent.mm.memory.a.c(400);
    this.hMe = new Stack();
    this.hMf = null;
    this.hMg = null;
    this.hMh = null;
    this.hMi = new com.tencent.mm.memory.a.c(200);
    this.hMj = new av(Looper.getMainLooper(), new av.a()
    {
      private long hMm = 0L;
      
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(150217);
        long l = System.currentTimeMillis();
        if ((d.this.hMb) && (l - this.hMm > 60000L))
        {
          ad.w("MicroMsg.AvatarService", "do scene TIMEOUT: %d", new Object[] { Long.valueOf(l - this.hMm) });
          d.this.hMb = false;
        }
        if (d.this.hMb)
        {
          d.this.hMj.az(1000L, 1000L);
          AppMethodBeat.o(150217);
          return false;
        }
        this.hMm = l;
        d.this.hMb = true;
        LinkedList localLinkedList = new LinkedList();
        int i = 0;
        while ((i < 5) && (d.this.hMe.size() > 0))
        {
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(138L, 42L, 1L, true);
          localLinkedList.add(new cwt().aPy(bt.nullAsNil(((i)d.this.hMe.pop()).getUsername())));
          i += 1;
        }
        com.tencent.mm.kernel.g.aiU().a(new k(localLinkedList), 0);
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(138L, 44L, 1L, true);
        AppMethodBeat.o(150217);
        return false;
      }
    }, false);
    com.tencent.mm.kernel.g.aiU().a(123, this);
    this.hMb = false;
    this.hMh = u.aAm();
    AppMethodBeat.o(150226);
  }
  
  static i CW(String paramString)
  {
    AppMethodBeat.i(150230);
    Object localObject1 = p.aEx().Dj(paramString);
    if ((localObject1 != null) && (((i)localObject1).getUsername().equals(paramString)))
    {
      ad.i("MicroMsg.AvatarService", "[isFlagNeed] getSmallUrl:%s username:%s", new Object[] { ((i)localObject1).aEr(), paramString });
      AppMethodBeat.o(150230);
      return localObject1;
    }
    localObject1 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(paramString);
    if (((aw)localObject1).ePj == 4)
    {
      c.ak(paramString, ((aw)localObject1).ePj);
      ad.d("MicroMsg.AvatarService", "ct imgFlag :%s", new Object[] { Integer.valueOf(((aw)localObject1).ePj) });
      AppMethodBeat.o(150230);
      return null;
    }
    localObject1 = new i();
    ((i)localObject1).username = paramString;
    ((i)localObject1).ePj = 3;
    Object localObject2 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().aTp(paramString);
    if (bt.cC((byte[])localObject2))
    {
      ad.i("MicroMsg.AvatarService", "[isFlagNeed] cmdBuf is null! username:%s", new Object[] { paramString });
      AppMethodBeat.o(150230);
      return localObject1;
    }
    try
    {
      localObject2 = c.a(paramString, (bzp)new bzp().parseFrom((byte[])localObject2));
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.AvatarService", "exception:%s", new Object[] { bt.n(localException) });
      }
    }
    ad.i("MicroMsg.AvatarService", "[isFlagNeed] finally! getSmallUrl:%s getBigUrl:%s username:%s", new Object[] { ((i)localObject1).aEr(), ((i)localObject1).aEq(), paramString });
    AppMethodBeat.o(150230);
    return localObject1;
  }
  
  static e aEk()
  {
    AppMethodBeat.i(150234);
    if (com.tencent.mm.kernel.g.ajA().aiK())
    {
      e locale = p.aEk();
      AppMethodBeat.o(150234);
      return locale;
    }
    AppMethodBeat.o(150234);
    return null;
  }
  
  public final void CU(String paramString)
  {
    AppMethodBeat.i(150228);
    a(new c(paramString));
    AppMethodBeat.o(150228);
  }
  
  public final void CV(final String paramString)
  {
    AppMethodBeat.i(150229);
    com.tencent.e.h.LTJ.aR(new com.tencent.e.i.j()
    {
      public final boolean ahh()
      {
        return false;
      }
      
      public final String getKey()
      {
        return "AvatarService#checkAvatarExpire";
      }
      
      public final void run()
      {
        AppMethodBeat.i(150214);
        if (bt.isNullOrNil(paramString))
        {
          AppMethodBeat.o(150214);
          return;
        }
        if (paramString.equals(d.this.hMh))
        {
          AppMethodBeat.o(150214);
          return;
        }
        Object localObject = d.aEl();
        if (localObject == null)
        {
          AppMethodBeat.o(150214);
          return;
        }
        localObject = ((j)localObject).Dj(paramString);
        if ((localObject == null) || (!((i)localObject).getUsername().equals(paramString)))
        {
          AppMethodBeat.o(150214);
          return;
        }
        if (bt.aQJ() - ((i)localObject).hMZ * 60L > 86400L) {}
        for (int i = 1; i == 0; i = 0)
        {
          AppMethodBeat.o(150214);
          return;
        }
        if (bt.isNullOrNil(((i)localObject).aEr()))
        {
          ad.w("MicroMsg.AvatarService", "dkhurl user has no url [%s]", new Object[] { paramString });
          AppMethodBeat.o(150214);
          return;
        }
        if (d.aEk() == null)
        {
          AppMethodBeat.o(150214);
          return;
        }
        e.L(paramString, false);
        e.L(paramString, true);
        d.this.CU(paramString);
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
  
  public final String CX(String paramString)
  {
    AppMethodBeat.i(150235);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150235);
      return "";
    }
    try
    {
      String str1 = String.format("%s%x_%s", new Object[] { "ammURL_", Integer.valueOf(paramString.hashCode()), paramString.substring(paramString.length() - 24, paramString.length() - 4) });
      this.hMi.put(str1, paramString);
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
  
  final int a(final be.a parama)
  {
    AppMethodBeat.i(150232);
    com.tencent.e.h.LTJ.aR(new com.tencent.e.i.h()
    {
      public final String getKey()
      {
        return "AvatarService#putAsyncTask";
      }
      
      public final void run()
      {
        AppMethodBeat.i(150216);
        parama.aEm();
        parama.aEn();
        AppMethodBeat.o(150216);
      }
    });
    AppMethodBeat.o(150232);
    return 1;
  }
  
  public final Bitmap b(String paramString, boolean paramBoolean, int paramInt, b paramb)
  {
    AppMethodBeat.i(195209);
    e locale = aEk();
    Bitmap localBitmap2;
    if (locale != null) {
      if ((paramInt >= 0) && (paramInt > 5))
      {
        localBitmap2 = e.CY(String.format("%s$$%d", new Object[] { paramString, Integer.valueOf(paramInt) }));
        if (localBitmap2 != null)
        {
          ad.i("MicroMsg.AvatarService", "find custom corner avatar, custom corner %d", new Object[] { Integer.valueOf(paramInt) });
          AppMethodBeat.o(195209);
          return localBitmap2;
        }
        ad.i("MicroMsg.AvatarService", "can not find custom corner avatar, custom corner %d", new Object[] { Integer.valueOf(paramInt) });
        localBitmap1 = localBitmap2;
        if (localBitmap2 != null) {}
      }
    }
    for (Bitmap localBitmap1 = e.CY(paramString);; localBitmap1 = null)
    {
      if (localBitmap1 != null)
      {
        paramb = localBitmap1;
        if (paramInt >= 0)
        {
          paramb = localBitmap1;
          if (paramInt > 5)
          {
            ad.i("MicroMsg.AvatarService", "create custom corner avatar, custom corner %d", new Object[] { Integer.valueOf(paramInt) });
            paramb = com.tencent.mm.sdk.platformtools.g.a(localBitmap1, false, paramInt);
            locale.d(String.format("%s$$%d", new Object[] { paramString, Integer.valueOf(paramInt) }), paramb);
          }
        }
        AppMethodBeat.o(195209);
        return paramb;
      }
      if (paramBoolean)
      {
        AppMethodBeat.o(195209);
        return null;
      }
      ad.v("MicroMsg.AvatarService", "get bitmap from cache failed, try to load :%s", new Object[] { paramString });
      if (this.hMc.contains(paramString))
      {
        AppMethodBeat.o(195209);
        return null;
      }
      this.hMc.add(paramString);
      a(new c(paramString, paramb));
      AppMethodBeat.o(195209);
      return null;
      localBitmap2 = null;
      break;
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(150231);
    while (this.hMe.size() > 0) {
      this.hMc.remove(this.hMe.pop());
    }
    AppMethodBeat.o(150231);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(150233);
    if (paramn == null)
    {
      AppMethodBeat.o(150233);
      return;
    }
    if (paramn.getType() != 123)
    {
      AppMethodBeat.o(150233);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(138L, 12L, 1L, true);
    }
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(138L, 45L, 1L, true);
    Object localObject;
    bpo localbpo;
    try
    {
      paramn = (k)paramn;
      paramString = new HashSet();
      if (paramn.hNc != null)
      {
        localObject = paramn.hNc.iterator();
        for (;;)
        {
          if (((Iterator)localObject).hasNext())
          {
            localbpo = (bpo)((Iterator)localObject).next();
            if ((localbpo == null) || (localbpo.GKl == null))
            {
              ad.i("MicroMsg.AvatarService", "error p is null or username is null %s", new Object[] { localbpo });
              continue;
              this.hMb = false;
            }
          }
        }
      }
    }
    catch (NullPointerException paramString)
    {
      ad.e("MicroMsg.AvatarService", "[onSceneEnd] NullPointerException:%s", new Object[] { paramString });
    }
    for (;;)
    {
      if (this.hMe.size() > 0) {
        this.hMj.az(0L, 0L);
      }
      AppMethodBeat.o(150233);
      return;
      String str = localbpo.GKl.HoB;
      if ((localbpo.Fvm == null) || (localbpo.Fvm.getBuffer() == null) || (localbpo.Fvm.getBuffer().zr == null))
      {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(138L, 11L, 1L, true);
        break;
      }
      paramString.add(str);
      i locali = new i();
      locali.username = str;
      locali.ePj = 3;
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(138L, 43L, 1L, true);
      a(new e(locali, localbpo.Fvm.getBuffer().zr));
      break;
      if (paramn.hNb != null)
      {
        paramn = paramn.hNb.iterator();
        while (paramn.hasNext())
        {
          localObject = (cwt)paramn.next();
          if (localObject != null)
          {
            localObject = ((cwt)localObject).HoB;
            if (!paramString.contains(localObject)) {
              this.hMc.remove(localObject);
            }
          }
        }
      }
    }
  }
  
  final class a
    implements be.a
  {
    boolean bGj;
    i hMn;
    byte[] hMo;
    byte[] hMp;
    
    public a(i parami, byte[] paramArrayOfByte, boolean paramBoolean)
    {
      this.hMn = parami;
      this.hMo = paramArrayOfByte;
      this.bGj = paramBoolean;
    }
    
    public final boolean aEm()
    {
      AppMethodBeat.i(150218);
      byte[] arrayOfByte;
      if (this.bGj)
      {
        ad.i("MicroMsg.AvatarService", "DecryptAvatar: decrypt");
        com.tencent.mm.plugin.report.service.g.yhR.dD(138, 51);
        arrayOfByte = UtilsJni.DecryptAvatar(this.hMo);
        if (bt.cC(arrayOfByte))
        {
          com.tencent.mm.plugin.report.service.g.yhR.dD(138, 52);
          ad.i("MicroMsg.AvatarService", "DecryptAvatar: decrypt output empty");
          AppMethodBeat.o(150218);
          return false;
        }
      }
      else
      {
        arrayOfByte = this.hMo;
      }
      for (;;)
      {
        if (t.cv(arrayOfByte))
        {
          ad.i("MicroMsg.AvatarService", "DecryptAvatar: hevc to pic");
          com.tencent.mm.plugin.report.service.g.yhR.dD(138, 53);
          this.hMp = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).aX(arrayOfByte);
          if (bt.cC(this.hMp))
          {
            com.tencent.mm.plugin.report.service.g.yhR.dD(138, 54);
            ad.i("MicroMsg.AvatarService", "DecryptAvatar: output is empty");
            AppMethodBeat.o(150218);
            return false;
          }
        }
        else
        {
          this.hMp = arrayOfByte;
        }
        AppMethodBeat.o(150218);
        return true;
      }
    }
    
    public final boolean aEn()
    {
      AppMethodBeat.i(150219);
      if (!bt.cC(this.hMp))
      {
        ad.i("MicroMsg.AvatarService", "DecryptAvatar: post to save length is %s", new Object[] { Integer.valueOf(this.hMp.length) });
        d.this.a(new d.e(d.this, this.hMn, this.hMp));
        AppMethodBeat.o(150219);
        return true;
      }
      ad.i("MicroMsg.AvatarService", "DecryptAvatar: onPostExecute output is empty");
      AppMethodBeat.o(150219);
      return false;
    }
  }
  
  final class c
    implements be.a
  {
    Bitmap hMs = null;
    b hMt = null;
    String username = null;
    
    public c(String paramString)
    {
      this.username = paramString;
    }
    
    public c(String paramString, b paramb)
    {
      this.username = paramString;
      this.hMt = paramb;
    }
    
    public final boolean aEm()
    {
      Context localContext = null;
      Object localObject1 = null;
      int i = 0;
      AppMethodBeat.i(150222);
      if (bt.isNullOrNil(this.username))
      {
        AppMethodBeat.o(150222);
        return false;
      }
      String str1 = this.username;
      boolean bool;
      String str2;
      Object localObject2;
      if (str1 == null)
      {
        bool = false;
        if (bool)
        {
          str2 = (String)d.this.hMi.get(str1);
          if (!bt.isNullOrNil(str2))
          {
            localObject2 = p.aEx().Dj(str1);
            if ((localObject2 == null) || (!str1.equals(((i)localObject2).getUsername())))
            {
              localObject2 = p.aEx();
              String str3 = "select img_flag.username,img_flag.imgflag,img_flag.lastupdatetime,img_flag.reserved1,img_flag.reserved2,img_flag.reserved3,img_flag.reserved4 from img_flag where img_flag.reserved2=\"" + bt.aQN(str2) + "\"";
              localObject2 = ((j)localObject2).hHS.a(str3, null, 2);
              if (localObject2 != null) {
                break label263;
              }
            }
          }
        }
      }
      for (;;)
      {
        if ((localObject1 != null) && (!bt.isNullOrNil(((i)localObject1).getUsername()))) {
          com.tencent.mm.vfs.i.mz(c.CS(((i)localObject1).getUsername()), c.CS(str1));
        }
        localObject1 = new i();
        ((i)localObject1).username = str1;
        ((i)localObject1).ePj = 3;
        ((i)localObject1).hMW = str2;
        ((i)localObject1).hMX = str2;
        ((i)localObject1).dDp = 3;
        ((i)localObject1).eB(true);
        ((i)localObject1).dDp = 31;
        p.aEx().b((i)localObject1);
        localObject1 = d.aEk();
        if (localObject1 != null) {
          break label308;
        }
        AppMethodBeat.o(150222);
        return false;
        bool = str1.startsWith("ammURL_");
        break;
        label263:
        localObject1 = localContext;
        if (((Cursor)localObject2).moveToFirst())
        {
          ((Cursor)localObject2).moveToFirst();
          localObject1 = new i();
          ((i)localObject1).convertFrom((Cursor)localObject2);
        }
        ((Cursor)localObject2).close();
      }
      label308:
      if (e.hMw.containsKey(this.username)) {
        i = ((Integer)e.hMw.get(this.username)).intValue();
      }
      if (i != 0)
      {
        p.aEw();
        localContext = p.getContext();
        if (localContext != null) {
          ((e)localObject1).e(this.username, com.tencent.mm.compatible.e.a.decodeResource(localContext.getResources(), i));
        }
      }
      this.hMs = e.Da(this.username);
      AppMethodBeat.o(150222);
      return true;
    }
    
    public final boolean aEn()
    {
      AppMethodBeat.i(150223);
      if (this.hMs == null)
      {
        d locald = d.this;
        String str = this.username;
        b localb = this.hMt;
        ad.d("MicroMsg.AvatarService", "avatar service push: %s", new Object[] { str });
        if (bt.isNullOrNil(str))
        {
          localObject = null;
          if (localObject != null) {
            break label481;
          }
          locald.hMc.remove(str);
        }
        for (;;)
        {
          AppMethodBeat.o(150223);
          return false;
          if ((str.equals(locald.hMh + "@bottle")) && (!bt.a((Boolean)com.tencent.mm.kernel.g.ajC().ajl().get(60, null), false)))
          {
            localObject = null;
            break;
          }
          if ((str.equals(locald.hMh)) && (!bt.a((Boolean)com.tencent.mm.kernel.g.ajC().ajl().get(59, null), false)))
          {
            ad.w("MicroMsg.AvatarService", "ConstantsStorage.USERINFO_HAS_HEADIMG false");
            localObject = null;
            break;
          }
          long l = bt.aQJ();
          d.d locald1 = (d.d)locald.hMd.aL(str);
          if ((locald1 != null) && (locald1.hfV >= 5) && (l - locald1.hfU < 600L))
          {
            ad.w("MicroMsg.AvatarService", "checkUser block by recentdown: %s", new Object[] { str });
            localObject = null;
            break;
          }
          localObject = d.CW(str);
          if (localObject == null)
          {
            ad.w("MicroMsg.AvatarService", "checkUser block local no need: %s", new Object[] { str });
            localObject = new d.d((byte)0);
            ((d.d)localObject).hfV = 5;
            ((d.d)localObject).hfU = l;
            locald.hMd.q(str, localObject);
            localObject = null;
            break;
          }
          if ((locald1 == null) || (l - locald1.hfU > 600L))
          {
            ad.i("MicroMsg.AvatarService", "new user: %s", new Object[] { str });
            locald1 = new d.d((byte)0);
            locald1.hfV = 1;
            locald1.hfU = l;
            locald.hMd.q(str, locald1);
          }
          for (;;)
          {
            break;
            if (locald1.hfV < 5)
            {
              ad.i("MicroMsg.AvatarService", "checkUser: %s tryCount: %d time: %d", new Object[] { str, Integer.valueOf(locald1.hfV), Long.valueOf(l - locald1.hfU) });
              locald1.hfV += 1;
              locald1.hfU = l;
              locald.hMd.q(str, locald1);
            }
          }
          label481:
          if (!bt.isNullOrNil(((i)localObject).aEr()))
          {
            locald.a(new d.b(locald, (i)localObject));
          }
          else
          {
            ad.w("MicroMsg.AvatarService", "dkhurl [%s] has NO URL flag:%d !", new Object[] { str, Integer.valueOf(((i)localObject).ePj) });
            if (4 == ((i)localObject).ePj)
            {
              ad.w("MicroMsg.AvatarService", "no avatar, do not batch get head image");
            }
            else if ((localb != null) && (!localb.hLY))
            {
              ad.w("MicroMsg.AvatarService", "avatar push username %s can not get avatar by username", new Object[] { str });
              locald.hMc.remove(str);
            }
            else
            {
              locald.hMe.push(localObject);
              if (locald.hMe.size() > 5) {
                locald.hMj.az(0L, 0L);
              } else {
                locald.hMj.az(1000L, 1000L);
              }
            }
          }
        }
      }
      Object localObject = d.aEk();
      if (localObject != null) {
        ((e)localObject).d(this.username, this.hMs);
      }
      d.this.hMc.remove(this.username);
      AppMethodBeat.o(150223);
      return false;
    }
  }
  
  static final class d
  {
    public long hfU = 0L;
    public int hfV = 0;
  }
  
  final class e
    implements be.a
  {
    Bitmap bitmap = null;
    byte[] buf;
    i hMn = null;
    
    public e(i parami, byte[] paramArrayOfByte)
    {
      this.hMn = parami;
      this.buf = paramArrayOfByte;
    }
    
    public final boolean aEm()
    {
      AppMethodBeat.i(150224);
      if ((this.hMn == null) || (bt.isNullOrNil(this.hMn.getUsername())))
      {
        ad.e("MicroMsg.AvatarService", "SaveAvatar imgFlag info is null");
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(138L, 13L, 1L, true);
        AppMethodBeat.o(150224);
        return false;
      }
      if (d.aEk() != null)
      {
        this.bitmap = e.g(this.hMn.getUsername(), this.buf);
        if (this.bitmap == null) {
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(138L, 14L, 1L, true);
        }
      }
      j localj = d.aEl();
      if (localj != null)
      {
        this.hMn.dDp = -1;
        this.hMn.aEs();
        localj.b(this.hMn);
      }
      AppMethodBeat.o(150224);
      return true;
    }
    
    public final boolean aEn()
    {
      AppMethodBeat.i(150225);
      if (bt.isNullOrNil(this.hMn.getUsername()))
      {
        AppMethodBeat.o(150225);
        return false;
      }
      e locale = d.aEk();
      if ((locale != null) && (this.bitmap != null)) {
        locale.d(this.hMn.getUsername(), this.bitmap);
      }
      d.this.hMc.remove(this.hMn.getUsername());
      AppMethodBeat.o(150225);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ak.d
 * JD-Core Version:    0.7.0.1
 */