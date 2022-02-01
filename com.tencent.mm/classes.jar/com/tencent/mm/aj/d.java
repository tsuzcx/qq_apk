package com.tencent.mm.aj;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bqh;
import com.tencent.mm.protocal.protobuf.caj;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bf.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.bq;
import com.tencent.mm.vfs.o;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public final class d
  implements com.tencent.mm.ak.f
{
  boolean hOU;
  Set<String> hOV;
  com.tencent.mm.b.f<String, d> hOW;
  Stack<i> hOX;
  private bf hOY;
  private bf hOZ;
  String hPa;
  com.tencent.mm.b.f<String, String> hPb;
  com.tencent.mm.sdk.platformtools.aw hPc;
  
  public d()
  {
    AppMethodBeat.i(150226);
    this.hOU = false;
    this.hOV = Collections.synchronizedSet(new HashSet());
    this.hOW = new com.tencent.mm.memory.a.c(400);
    this.hOX = new Stack();
    this.hOY = null;
    this.hOZ = null;
    this.hPa = null;
    this.hPb = new com.tencent.mm.memory.a.c(200);
    this.hPc = new com.tencent.mm.sdk.platformtools.aw(Looper.getMainLooper(), new aw.a()
    {
      private long hPf = 0L;
      
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(150217);
        long l = System.currentTimeMillis();
        if ((d.this.hOU) && (l - this.hPf > 60000L))
        {
          ae.w("MicroMsg.AvatarService", "do scene TIMEOUT: %d", new Object[] { Long.valueOf(l - this.hPf) });
          d.this.hOU = false;
        }
        if (d.this.hOU)
        {
          d.this.hPc.ay(1000L, 1000L);
          AppMethodBeat.o(150217);
          return false;
        }
        this.hPf = l;
        d.this.hOU = true;
        LinkedList localLinkedList = new LinkedList();
        int i = 0;
        while ((i < 5) && (d.this.hOX.size() > 0))
        {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(138L, 42L, 1L, true);
          localLinkedList.add(new cxn().aQV(bu.nullAsNil(((i)d.this.hOX.pop()).getUsername())));
          i += 1;
        }
        com.tencent.mm.kernel.g.ajj().a(new k(localLinkedList), 0);
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(138L, 44L, 1L, true);
        AppMethodBeat.o(150217);
        return false;
      }
    }, false);
    com.tencent.mm.kernel.g.ajj().a(123, this);
    this.hOU = false;
    this.hPa = v.aAC();
    AppMethodBeat.o(150226);
  }
  
  static i Dy(String paramString)
  {
    AppMethodBeat.i(150230);
    Object localObject1 = p.aEN().DL(paramString);
    if ((localObject1 != null) && (((i)localObject1).getUsername().equals(paramString)))
    {
      ae.i("MicroMsg.AvatarService", "[isFlagNeed] getSmallUrl:%s username:%s", new Object[] { ((i)localObject1).aEH(), paramString });
      AppMethodBeat.o(150230);
      return localObject1;
    }
    localObject1 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(paramString);
    if (((com.tencent.mm.g.c.aw)localObject1).eQU == 4)
    {
      c.al(paramString, ((com.tencent.mm.g.c.aw)localObject1).eQU);
      ae.d("MicroMsg.AvatarService", "ct imgFlag :%s", new Object[] { Integer.valueOf(((com.tencent.mm.g.c.aw)localObject1).eQU) });
      AppMethodBeat.o(150230);
      return null;
    }
    localObject1 = new i();
    ((i)localObject1).username = paramString;
    ((i)localObject1).eQU = 3;
    Object localObject2 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().aUQ(paramString);
    if (bu.cF((byte[])localObject2))
    {
      ae.i("MicroMsg.AvatarService", "[isFlagNeed] cmdBuf is null! username:%s", new Object[] { paramString });
      AppMethodBeat.o(150230);
      return localObject1;
    }
    try
    {
      localObject2 = c.a(paramString, (caj)new caj().parseFrom((byte[])localObject2));
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.e("MicroMsg.AvatarService", "exception:%s", new Object[] { bu.o(localException) });
      }
    }
    ae.i("MicroMsg.AvatarService", "[isFlagNeed] finally! getSmallUrl:%s getBigUrl:%s username:%s", new Object[] { ((i)localObject1).aEH(), ((i)localObject1).aEG(), paramString });
    AppMethodBeat.o(150230);
    return localObject1;
  }
  
  static e aEA()
  {
    AppMethodBeat.i(150234);
    if (com.tencent.mm.kernel.g.ajP().aiZ())
    {
      e locale = p.aEA();
      AppMethodBeat.o(150234);
      return locale;
    }
    AppMethodBeat.o(150234);
    return null;
  }
  
  public final void Dw(String paramString)
  {
    AppMethodBeat.i(150228);
    a(new c(paramString));
    AppMethodBeat.o(150228);
  }
  
  public final void Dx(final String paramString)
  {
    AppMethodBeat.i(150229);
    com.tencent.e.h.MqF.aO(new com.tencent.e.i.j()
    {
      public final boolean ahw()
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
        if (bu.isNullOrNil(paramString))
        {
          AppMethodBeat.o(150214);
          return;
        }
        if (paramString.equals(d.this.hPa))
        {
          AppMethodBeat.o(150214);
          return;
        }
        Object localObject = d.aEB();
        if (localObject == null)
        {
          AppMethodBeat.o(150214);
          return;
        }
        localObject = ((j)localObject).DL(paramString);
        if ((localObject == null) || (!((i)localObject).getUsername().equals(paramString)))
        {
          AppMethodBeat.o(150214);
          return;
        }
        if (bu.aRi() - ((i)localObject).hPS * 60L > 86400L) {}
        for (int i = 1; i == 0; i = 0)
        {
          AppMethodBeat.o(150214);
          return;
        }
        if (bu.isNullOrNil(((i)localObject).aEH()))
        {
          ae.w("MicroMsg.AvatarService", "dkhurl user has no url [%s]", new Object[] { paramString });
          AppMethodBeat.o(150214);
          return;
        }
        if (d.aEA() == null)
        {
          AppMethodBeat.o(150214);
          return;
        }
        e.L(paramString, false);
        e.L(paramString, true);
        d.this.Dw(paramString);
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
  
  public final String Dz(String paramString)
  {
    AppMethodBeat.i(150235);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150235);
      return "";
    }
    try
    {
      String str1 = String.format("%s%x_%s", new Object[] { "ammURL_", Integer.valueOf(paramString.hashCode()), paramString.substring(paramString.length() - 24, paramString.length() - 4) });
      this.hPb.put(str1, paramString);
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
  
  final int a(final bf.a parama)
  {
    AppMethodBeat.i(150232);
    com.tencent.e.h.MqF.aO(new com.tencent.e.i.h()
    {
      public final String getKey()
      {
        return "AvatarService#putAsyncTask";
      }
      
      public final void run()
      {
        AppMethodBeat.i(150216);
        parama.aEC();
        parama.aED();
        AppMethodBeat.o(150216);
      }
    });
    AppMethodBeat.o(150232);
    return 1;
  }
  
  public final Bitmap b(String paramString, boolean paramBoolean, int paramInt, b paramb)
  {
    AppMethodBeat.i(218659);
    e locale = aEA();
    Bitmap localBitmap2;
    if (locale != null) {
      if ((paramInt >= 0) && (paramInt > 5))
      {
        localBitmap2 = e.DA(String.format("%s$$%d", new Object[] { paramString, Integer.valueOf(paramInt) }));
        if (localBitmap2 != null)
        {
          ae.i("MicroMsg.AvatarService", "find custom corner avatar, custom corner %d", new Object[] { Integer.valueOf(paramInt) });
          AppMethodBeat.o(218659);
          return localBitmap2;
        }
        ae.i("MicroMsg.AvatarService", "can not find custom corner avatar, custom corner %d", new Object[] { Integer.valueOf(paramInt) });
        localBitmap1 = localBitmap2;
        if (localBitmap2 != null) {}
      }
    }
    for (Bitmap localBitmap1 = e.DA(paramString);; localBitmap1 = null)
    {
      if (localBitmap1 != null)
      {
        paramb = localBitmap1;
        if (paramInt >= 0)
        {
          paramb = localBitmap1;
          if (paramInt > 5)
          {
            ae.i("MicroMsg.AvatarService", "create custom corner avatar, custom corner %d", new Object[] { Integer.valueOf(paramInt) });
            paramb = com.tencent.mm.sdk.platformtools.h.a(localBitmap1, false, paramInt);
            locale.d(String.format("%s$$%d", new Object[] { paramString, Integer.valueOf(paramInt) }), paramb);
          }
        }
        AppMethodBeat.o(218659);
        return paramb;
      }
      if (paramBoolean)
      {
        AppMethodBeat.o(218659);
        return null;
      }
      ae.v("MicroMsg.AvatarService", "get bitmap from cache failed, try to load :%s", new Object[] { paramString });
      if (this.hOV.contains(paramString))
      {
        AppMethodBeat.o(218659);
        return null;
      }
      this.hOV.add(paramString);
      a(new c(paramString, paramb));
      AppMethodBeat.o(218659);
      return null;
      localBitmap2 = null;
      break;
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(150231);
    while (this.hOX.size() > 0) {
      this.hOV.remove(this.hOX.pop());
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
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(138L, 12L, 1L, true);
    }
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(138L, 45L, 1L, true);
    Object localObject;
    bqh localbqh;
    try
    {
      paramn = (k)paramn;
      paramString = new HashSet();
      if (paramn.hPV != null)
      {
        localObject = paramn.hPV.iterator();
        for (;;)
        {
          if (((Iterator)localObject).hasNext())
          {
            localbqh = (bqh)((Iterator)localObject).next();
            if ((localbqh == null) || (localbqh.HdM == null))
            {
              ae.i("MicroMsg.AvatarService", "error p is null or username is null %s", new Object[] { localbqh });
              continue;
              this.hOU = false;
            }
          }
        }
      }
    }
    catch (NullPointerException paramString)
    {
      ae.e("MicroMsg.AvatarService", "[onSceneEnd] NullPointerException:%s", new Object[] { paramString });
    }
    for (;;)
    {
      if (this.hOX.size() > 0) {
        this.hPc.ay(0L, 0L);
      }
      AppMethodBeat.o(150233);
      return;
      String str = localbqh.HdM.HId;
      if ((localbqh.FNK == null) || (localbqh.FNK.getBuffer() == null) || (localbqh.FNK.getBuffer().zr == null))
      {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(138L, 11L, 1L, true);
        break;
      }
      paramString.add(str);
      i locali = new i();
      locali.username = str;
      locali.eQU = 3;
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(138L, 43L, 1L, true);
      a(new e(locali, localbqh.FNK.getBuffer().zr));
      break;
      if (paramn.hPU != null)
      {
        paramn = paramn.hPU.iterator();
        while (paramn.hasNext())
        {
          localObject = (cxn)paramn.next();
          if (localObject != null)
          {
            localObject = ((cxn)localObject).HId;
            if (!paramString.contains(localObject)) {
              this.hOV.remove(localObject);
            }
          }
        }
      }
    }
  }
  
  final class a
    implements bf.a
  {
    boolean bGj;
    i hPg;
    byte[] hPh;
    byte[] hPi;
    
    public a(i parami, byte[] paramArrayOfByte, boolean paramBoolean)
    {
      this.hPg = parami;
      this.hPh = paramArrayOfByte;
      this.bGj = paramBoolean;
    }
    
    public final boolean aEC()
    {
      AppMethodBeat.i(150218);
      byte[] arrayOfByte;
      if (this.bGj)
      {
        ae.i("MicroMsg.AvatarService", "DecryptAvatar: decrypt");
        com.tencent.mm.plugin.report.service.g.yxI.dD(138, 51);
        arrayOfByte = UtilsJni.DecryptAvatar(this.hPh);
        if (bu.cF(arrayOfByte))
        {
          com.tencent.mm.plugin.report.service.g.yxI.dD(138, 52);
          ae.i("MicroMsg.AvatarService", "DecryptAvatar: decrypt output empty");
          AppMethodBeat.o(150218);
          return false;
        }
      }
      else
      {
        arrayOfByte = this.hPh;
      }
      for (;;)
      {
        if (u.cy(arrayOfByte))
        {
          ae.i("MicroMsg.AvatarService", "DecryptAvatar: hevc to pic");
          com.tencent.mm.plugin.report.service.g.yxI.dD(138, 53);
          this.hPi = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).aW(arrayOfByte);
          if (bu.cF(this.hPi))
          {
            com.tencent.mm.plugin.report.service.g.yxI.dD(138, 54);
            ae.i("MicroMsg.AvatarService", "DecryptAvatar: output is empty");
            AppMethodBeat.o(150218);
            return false;
          }
        }
        else
        {
          this.hPi = arrayOfByte;
        }
        AppMethodBeat.o(150218);
        return true;
      }
    }
    
    public final boolean aED()
    {
      AppMethodBeat.i(150219);
      if (!bu.cF(this.hPi))
      {
        ae.i("MicroMsg.AvatarService", "DecryptAvatar: post to save length is %s", new Object[] { Integer.valueOf(this.hPi.length) });
        d.this.a(new d.e(d.this, this.hPg, this.hPi));
        AppMethodBeat.o(150219);
        return true;
      }
      ae.i("MicroMsg.AvatarService", "DecryptAvatar: onPostExecute output is empty");
      AppMethodBeat.o(150219);
      return false;
    }
  }
  
  final class c
    implements bf.a
  {
    Bitmap hPl = null;
    b hPm = null;
    String username = null;
    
    public c(String paramString)
    {
      this.username = paramString;
    }
    
    public c(String paramString, b paramb)
    {
      this.username = paramString;
      this.hPm = paramb;
    }
    
    public final boolean aEC()
    {
      Context localContext = null;
      Object localObject1 = null;
      int i = 0;
      AppMethodBeat.i(150222);
      if (bu.isNullOrNil(this.username))
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
          str2 = (String)d.this.hPb.get(str1);
          if (!bu.isNullOrNil(str2))
          {
            localObject2 = p.aEN().DL(str1);
            if ((localObject2 == null) || (!str1.equals(((i)localObject2).getUsername())))
            {
              localObject2 = p.aEN();
              String str3 = "select img_flag.username,img_flag.imgflag,img_flag.lastupdatetime,img_flag.reserved1,img_flag.reserved2,img_flag.reserved3,img_flag.reserved4 from img_flag where img_flag.reserved2=\"" + bu.aSk(str2) + "\"";
              localObject2 = ((j)localObject2).hKK.a(str3, null, 2);
              if (localObject2 != null) {
                break label263;
              }
            }
          }
        }
      }
      for (;;)
      {
        if ((localObject1 != null) && (!bu.isNullOrNil(((i)localObject1).getUsername()))) {
          o.mF(c.Du(((i)localObject1).getUsername()), c.Du(str1));
        }
        localObject1 = new i();
        ((i)localObject1).username = str1;
        ((i)localObject1).eQU = 3;
        ((i)localObject1).hPP = str2;
        ((i)localObject1).hPQ = str2;
        ((i)localObject1).dEu = 3;
        ((i)localObject1).eD(true);
        ((i)localObject1).dEu = 31;
        p.aEN().b((i)localObject1);
        localObject1 = d.aEA();
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
      if (e.hPp.containsKey(this.username)) {
        i = ((Integer)e.hPp.get(this.username)).intValue();
      }
      if (i != 0)
      {
        p.aEM();
        localContext = p.getContext();
        if (localContext != null) {
          ((e)localObject1).e(this.username, com.tencent.mm.compatible.e.a.decodeResource(localContext.getResources(), i));
        }
      }
      this.hPl = e.DC(this.username);
      AppMethodBeat.o(150222);
      return true;
    }
    
    public final boolean aED()
    {
      AppMethodBeat.i(150223);
      if (this.hPl == null)
      {
        d locald = d.this;
        String str = this.username;
        b localb = this.hPm;
        ae.d("MicroMsg.AvatarService", "avatar service push: %s", new Object[] { str });
        if (bu.isNullOrNil(str))
        {
          localObject = null;
          if (localObject != null) {
            break label481;
          }
          locald.hOV.remove(str);
        }
        for (;;)
        {
          AppMethodBeat.o(150223);
          return false;
          if ((str.equals(locald.hPa + "@bottle")) && (!bu.a((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(60, null), false)))
          {
            localObject = null;
            break;
          }
          if ((str.equals(locald.hPa)) && (!bu.a((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(59, null), false)))
          {
            ae.w("MicroMsg.AvatarService", "ConstantsStorage.USERINFO_HAS_HEADIMG false");
            localObject = null;
            break;
          }
          long l = bu.aRi();
          d.d locald1 = (d.d)locald.hOW.aL(str);
          if ((locald1 != null) && (locald1.hiJ >= 5) && (l - locald1.hiI < 600L))
          {
            ae.w("MicroMsg.AvatarService", "checkUser block by recentdown: %s", new Object[] { str });
            localObject = null;
            break;
          }
          localObject = d.Dy(str);
          if (localObject == null)
          {
            ae.w("MicroMsg.AvatarService", "checkUser block local no need: %s", new Object[] { str });
            localObject = new d.d((byte)0);
            ((d.d)localObject).hiJ = 5;
            ((d.d)localObject).hiI = l;
            locald.hOW.q(str, localObject);
            localObject = null;
            break;
          }
          if ((locald1 == null) || (l - locald1.hiI > 600L))
          {
            ae.i("MicroMsg.AvatarService", "new user: %s", new Object[] { str });
            locald1 = new d.d((byte)0);
            locald1.hiJ = 1;
            locald1.hiI = l;
            locald.hOW.q(str, locald1);
          }
          for (;;)
          {
            break;
            if (locald1.hiJ < 5)
            {
              ae.i("MicroMsg.AvatarService", "checkUser: %s tryCount: %d time: %d", new Object[] { str, Integer.valueOf(locald1.hiJ), Long.valueOf(l - locald1.hiI) });
              locald1.hiJ += 1;
              locald1.hiI = l;
              locald.hOW.q(str, locald1);
            }
          }
          label481:
          if (!bu.isNullOrNil(((i)localObject).aEH()))
          {
            locald.a(new d.b(locald, (i)localObject));
          }
          else
          {
            ae.w("MicroMsg.AvatarService", "dkhurl [%s] has NO URL flag:%d !", new Object[] { str, Integer.valueOf(((i)localObject).eQU) });
            if (4 == ((i)localObject).eQU)
            {
              ae.w("MicroMsg.AvatarService", "no avatar, do not batch get head image");
            }
            else if ((localb != null) && (!localb.hOR))
            {
              ae.w("MicroMsg.AvatarService", "avatar push username %s can not get avatar by username", new Object[] { str });
              locald.hOV.remove(str);
            }
            else
            {
              locald.hOX.push(localObject);
              if (locald.hOX.size() > 5) {
                locald.hPc.ay(0L, 0L);
              } else {
                locald.hPc.ay(1000L, 1000L);
              }
            }
          }
        }
      }
      Object localObject = d.aEA();
      if (localObject != null) {
        ((e)localObject).d(this.username, this.hPl);
      }
      d.this.hOV.remove(this.username);
      AppMethodBeat.o(150223);
      return false;
    }
  }
  
  static final class d
  {
    public long hiI = 0L;
    public int hiJ = 0;
  }
  
  final class e
    implements bf.a
  {
    Bitmap bitmap = null;
    byte[] buf;
    i hPg = null;
    
    public e(i parami, byte[] paramArrayOfByte)
    {
      this.hPg = parami;
      this.buf = paramArrayOfByte;
    }
    
    public final boolean aEC()
    {
      AppMethodBeat.i(150224);
      if ((this.hPg == null) || (bu.isNullOrNil(this.hPg.getUsername())))
      {
        ae.e("MicroMsg.AvatarService", "SaveAvatar imgFlag info is null");
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(138L, 13L, 1L, true);
        AppMethodBeat.o(150224);
        return false;
      }
      if (d.aEA() != null)
      {
        this.bitmap = e.g(this.hPg.getUsername(), this.buf);
        if (this.bitmap == null) {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(138L, 14L, 1L, true);
        }
      }
      j localj = d.aEB();
      if (localj != null)
      {
        this.hPg.dEu = -1;
        this.hPg.aEI();
        localj.b(this.hPg);
      }
      AppMethodBeat.o(150224);
      return true;
    }
    
    public final boolean aED()
    {
      AppMethodBeat.i(150225);
      if (bu.isNullOrNil(this.hPg.getUsername()))
      {
        AppMethodBeat.o(150225);
        return false;
      }
      e locale = d.aEA();
      if ((locale != null) && (this.bitmap != null)) {
        locale.d(this.hPg.getUsername(), this.bitmap);
      }
      d.this.hOV.remove(this.hPg.getUsername());
      AppMethodBeat.o(150225);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aj.d
 * JD-Core Version:    0.7.0.1
 */