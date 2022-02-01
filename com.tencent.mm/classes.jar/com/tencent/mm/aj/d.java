package com.tencent.mm.aj;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.av;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.model.u;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ble;
import com.tencent.mm.protocal.protobuf.bva;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bd.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bj;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public final class d
  implements com.tencent.mm.ak.g
{
  boolean htJ;
  Set<String> htK;
  com.tencent.mm.b.f<String, d> htL;
  Stack<i> htM;
  private bd htN;
  private bd htO;
  String htP;
  com.tencent.mm.b.f<String, String> htQ;
  au htR;
  
  public d()
  {
    AppMethodBeat.i(150226);
    this.htJ = false;
    this.htK = Collections.synchronizedSet(new HashSet());
    this.htL = new com.tencent.mm.memory.a.c(400);
    this.htM = new Stack();
    this.htN = null;
    this.htO = null;
    this.htP = null;
    this.htQ = new com.tencent.mm.memory.a.c(200);
    this.htR = new au(Looper.getMainLooper(), new au.a()
    {
      private long htU = 0L;
      
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(150217);
        long l = System.currentTimeMillis();
        if ((d.this.htJ) && (l - this.htU > 60000L))
        {
          ac.w("MicroMsg.AvatarService", "do scene TIMEOUT: %d", new Object[] { Long.valueOf(l - this.htU) });
          d.this.htJ = false;
        }
        if (d.this.htJ)
        {
          d.this.htR.au(1000L, 1000L);
          AppMethodBeat.o(150217);
          return false;
        }
        this.htU = l;
        d.this.htJ = true;
        LinkedList localLinkedList = new LinkedList();
        int i = 0;
        while ((i < 5) && (d.this.htM.size() > 0))
        {
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(138L, 42L, 1L, true);
          localLinkedList.add(new crm().aJV(bs.nullAsNil(((i)d.this.htM.pop()).getUsername())));
          i += 1;
        }
        com.tencent.mm.kernel.g.agi().a(new k(localLinkedList), 0);
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(138L, 44L, 1L, true);
        AppMethodBeat.o(150217);
        return false;
      }
    }, false);
    com.tencent.mm.kernel.g.agi().a(123, this);
    this.htJ = false;
    this.htP = u.axw();
    AppMethodBeat.o(150226);
  }
  
  static e aBh()
  {
    AppMethodBeat.i(150234);
    if (com.tencent.mm.kernel.g.agP().afY())
    {
      e locale = p.aBh();
      AppMethodBeat.o(150234);
      return locale;
    }
    AppMethodBeat.o(150234);
    return null;
  }
  
  static i zX(String paramString)
  {
    AppMethodBeat.i(150230);
    Object localObject1 = p.aBw().Ak(paramString);
    if ((localObject1 != null) && (((i)localObject1).getUsername().equals(paramString)))
    {
      ac.i("MicroMsg.AvatarService", "[isFlagNeed] getSmallUrl:%s username:%s", new Object[] { ((i)localObject1).aBp(), paramString });
      AppMethodBeat.o(150230);
      return localObject1;
    }
    localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramString);
    if (((av)localObject1).exK == 4)
    {
      c.ag(paramString, ((av)localObject1).exK);
      ac.d("MicroMsg.AvatarService", "ct imgFlag :%s", new Object[] { Integer.valueOf(((av)localObject1).exK) });
      AppMethodBeat.o(150230);
      return null;
    }
    localObject1 = new i();
    ((i)localObject1).username = paramString;
    ((i)localObject1).exK = 3;
    Object localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNy(paramString);
    if (bs.cv((byte[])localObject2))
    {
      ac.i("MicroMsg.AvatarService", "[isFlagNeed] cmdBuf is null! username:%s", new Object[] { paramString });
      AppMethodBeat.o(150230);
      return localObject1;
    }
    try
    {
      localObject2 = c.a(paramString, (bva)new bva().parseFrom((byte[])localObject2));
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.e("MicroMsg.AvatarService", "exception:%s", new Object[] { bs.m(localException) });
      }
    }
    ac.i("MicroMsg.AvatarService", "[isFlagNeed] finally! getSmallUrl:%s getBigUrl:%s username:%s", new Object[] { ((i)localObject1).aBp(), ((i)localObject1).aBo(), paramString });
    AppMethodBeat.o(150230);
    return localObject1;
  }
  
  final int a(final bd.a parama)
  {
    AppMethodBeat.i(150232);
    com.tencent.e.h.JZN.aS(new com.tencent.e.i.h()
    {
      public final String getKey()
      {
        return "AvatarService#putAsyncTask";
      }
      
      public final void run()
      {
        AppMethodBeat.i(150216);
        parama.aBj();
        parama.aBk();
        AppMethodBeat.o(150216);
      }
    });
    AppMethodBeat.o(150232);
    return 1;
  }
  
  public final Bitmap b(String paramString, boolean paramBoolean, int paramInt, b paramb)
  {
    AppMethodBeat.i(192603);
    e locale = aBh();
    Bitmap localBitmap2;
    if (locale != null) {
      if ((paramInt >= 0) && (paramInt > 5))
      {
        localBitmap2 = e.zZ(String.format("%s$$%d", new Object[] { paramString, Integer.valueOf(paramInt) }));
        if (localBitmap2 != null)
        {
          ac.i("MicroMsg.AvatarService", "find custom corner avatar, custom corner %d", new Object[] { Integer.valueOf(paramInt) });
          AppMethodBeat.o(192603);
          return localBitmap2;
        }
        ac.i("MicroMsg.AvatarService", "can not find custom corner avatar, custom corner %d", new Object[] { Integer.valueOf(paramInt) });
        localBitmap1 = localBitmap2;
        if (localBitmap2 != null) {}
      }
    }
    for (Bitmap localBitmap1 = e.zZ(paramString);; localBitmap1 = null)
    {
      if (localBitmap1 != null)
      {
        paramb = localBitmap1;
        if (paramInt >= 0)
        {
          paramb = localBitmap1;
          if (paramInt > 5)
          {
            ac.i("MicroMsg.AvatarService", "create custom corner avatar, custom corner %d", new Object[] { Integer.valueOf(paramInt) });
            paramb = com.tencent.mm.sdk.platformtools.f.a(localBitmap1, false, paramInt);
            locale.d(String.format("%s$$%d", new Object[] { paramString, Integer.valueOf(paramInt) }), paramb);
          }
        }
        AppMethodBeat.o(192603);
        return paramb;
      }
      if (paramBoolean)
      {
        AppMethodBeat.o(192603);
        return null;
      }
      ac.v("MicroMsg.AvatarService", "get bitmap from cache failed, try to load :%s", new Object[] { paramString });
      if (this.htK.contains(paramString))
      {
        AppMethodBeat.o(192603);
        return null;
      }
      this.htK.add(paramString);
      a(new c(paramString, paramb));
      AppMethodBeat.o(192603);
      return null;
      localBitmap2 = null;
      break;
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(150231);
    while (this.htM.size() > 0) {
      this.htK.remove(this.htM.pop());
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
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(138L, 12L, 1L, true);
    }
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(138L, 45L, 1L, true);
    Object localObject;
    ble localble;
    try
    {
      paramn = (k)paramn;
      paramString = new HashSet();
      if (paramn.huK != null)
      {
        localObject = paramn.huK.iterator();
        for (;;)
        {
          if (((Iterator)localObject).hasNext())
          {
            localble = (ble)((Iterator)localObject).next();
            if ((localble == null) || (localble.FaM == null))
            {
              ac.i("MicroMsg.AvatarService", "error p is null or username is null %s", new Object[] { localble });
              continue;
              this.htJ = false;
            }
          }
        }
      }
    }
    catch (NullPointerException paramString)
    {
      ac.e("MicroMsg.AvatarService", "[onSceneEnd] NullPointerException:%s", new Object[] { paramString });
    }
    for (;;)
    {
      if (this.htM.size() > 0) {
        this.htR.au(0L, 0L);
      }
      AppMethodBeat.o(150233);
      return;
      String str = localble.FaM.FEm;
      if ((localble.DPX == null) || (localble.DPX.getBuffer() == null) || (localble.DPX.getBuffer().xy == null))
      {
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(138L, 11L, 1L, true);
        break;
      }
      paramString.add(str);
      i locali = new i();
      locali.username = str;
      locali.exK = 3;
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(138L, 43L, 1L, true);
      a(new e(locali, localble.DPX.getBuffer().xy));
      break;
      if (paramn.huJ != null)
      {
        paramn = paramn.huJ.iterator();
        while (paramn.hasNext())
        {
          localObject = (crm)paramn.next();
          if (localObject != null)
          {
            localObject = ((crm)localObject).FEm;
            if (!paramString.contains(localObject)) {
              this.htK.remove(localObject);
            }
          }
        }
      }
    }
  }
  
  public final void zV(String paramString)
  {
    AppMethodBeat.i(150228);
    a(new c(paramString));
    AppMethodBeat.o(150228);
  }
  
  public final void zW(final String paramString)
  {
    AppMethodBeat.i(150229);
    com.tencent.e.h.JZN.aS(new com.tencent.e.i.j()
    {
      public final boolean aev()
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
        if (bs.isNullOrNil(paramString))
        {
          AppMethodBeat.o(150214);
          return;
        }
        if (paramString.equals(d.this.htP))
        {
          AppMethodBeat.o(150214);
          return;
        }
        Object localObject = d.aBi();
        if (localObject == null)
        {
          AppMethodBeat.o(150214);
          return;
        }
        localObject = ((j)localObject).Ak(paramString);
        if ((localObject == null) || (!((i)localObject).getUsername().equals(paramString)))
        {
          AppMethodBeat.o(150214);
          return;
        }
        if (bs.aNx() - ((i)localObject).huH * 60L > 86400L) {}
        for (int i = 1; i == 0; i = 0)
        {
          AppMethodBeat.o(150214);
          return;
        }
        if (bs.isNullOrNil(((i)localObject).aBp()))
        {
          ac.w("MicroMsg.AvatarService", "dkhurl user has no url [%s]", new Object[] { paramString });
          AppMethodBeat.o(150214);
          return;
        }
        if (d.aBh() == null)
        {
          AppMethodBeat.o(150214);
          return;
        }
        e.L(paramString, false);
        e.L(paramString, true);
        d.this.zV(paramString);
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
  
  public final String zY(String paramString)
  {
    AppMethodBeat.i(150235);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150235);
      return "";
    }
    try
    {
      String str1 = String.format("%s%x_%s", new Object[] { "ammURL_", Integer.valueOf(paramString.hashCode()), paramString.substring(paramString.length() - 24, paramString.length() - 4) });
      this.htQ.put(str1, paramString);
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
  
  final class a
    implements bd.a
  {
    boolean bvV;
    i htV;
    byte[] htW;
    byte[] htX;
    
    public a(i parami, byte[] paramArrayOfByte, boolean paramBoolean)
    {
      this.htV = parami;
      this.htW = paramArrayOfByte;
      this.bvV = paramBoolean;
    }
    
    public final boolean aBj()
    {
      AppMethodBeat.i(150218);
      byte[] arrayOfByte;
      if (this.bvV)
      {
        ac.i("MicroMsg.AvatarService", "DecryptAvatar: decrypt");
        com.tencent.mm.plugin.report.service.h.wUl.dB(138, 51);
        arrayOfByte = UtilsJni.DecryptAvatar(this.htW);
        if (bs.cv(arrayOfByte))
        {
          com.tencent.mm.plugin.report.service.h.wUl.dB(138, 52);
          ac.i("MicroMsg.AvatarService", "DecryptAvatar: decrypt output empty");
          AppMethodBeat.o(150218);
          return false;
        }
      }
      else
      {
        arrayOfByte = this.htW;
      }
      for (;;)
      {
        if (s.co(arrayOfByte))
        {
          ac.i("MicroMsg.AvatarService", "DecryptAvatar: hevc to pic");
          com.tencent.mm.plugin.report.service.h.wUl.dB(138, 53);
          this.htX = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).aU(arrayOfByte);
          if (bs.cv(this.htX))
          {
            com.tencent.mm.plugin.report.service.h.wUl.dB(138, 54);
            ac.i("MicroMsg.AvatarService", "DecryptAvatar: output is empty");
            AppMethodBeat.o(150218);
            return false;
          }
        }
        else
        {
          this.htX = arrayOfByte;
        }
        AppMethodBeat.o(150218);
        return true;
      }
    }
    
    public final boolean aBk()
    {
      AppMethodBeat.i(150219);
      if (!bs.cv(this.htX))
      {
        ac.i("MicroMsg.AvatarService", "DecryptAvatar: post to save length is %s", new Object[] { Integer.valueOf(this.htX.length) });
        d.this.a(new d.e(d.this, this.htV, this.htX));
        AppMethodBeat.o(150219);
        return true;
      }
      ac.i("MicroMsg.AvatarService", "DecryptAvatar: onPostExecute output is empty");
      AppMethodBeat.o(150219);
      return false;
    }
  }
  
  final class c
    implements bd.a
  {
    Bitmap hua = null;
    b hub = null;
    String username = null;
    
    public c(String paramString)
    {
      this.username = paramString;
    }
    
    public c(String paramString, b paramb)
    {
      this.username = paramString;
      this.hub = paramb;
    }
    
    public final boolean aBj()
    {
      Context localContext = null;
      Object localObject1 = null;
      int i = 0;
      AppMethodBeat.i(150222);
      if (bs.isNullOrNil(this.username))
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
          str2 = (String)d.this.htQ.get(str1);
          if (!bs.isNullOrNil(str2))
          {
            localObject2 = p.aBw().Ak(str1);
            if ((localObject2 == null) || (!str1.equals(((i)localObject2).getUsername())))
            {
              localObject2 = p.aBw();
              String str3 = "select img_flag.username,img_flag.imgflag,img_flag.lastupdatetime,img_flag.reserved1,img_flag.reserved2,img_flag.reserved3,img_flag.reserved4 from img_flag where img_flag.reserved2=\"" + bs.aLh(str2) + "\"";
              localObject2 = ((j)localObject2).hpA.a(str3, null, 2);
              if (localObject2 != null) {
                break label263;
              }
            }
          }
        }
      }
      for (;;)
      {
        if ((localObject1 != null) && (!bs.isNullOrNil(((i)localObject1).getUsername()))) {
          com.tencent.mm.vfs.i.lZ(c.zT(((i)localObject1).getUsername()), c.zT(str1));
        }
        localObject1 = new i();
        ((i)localObject1).username = str1;
        ((i)localObject1).exK = 3;
        ((i)localObject1).huE = str2;
        ((i)localObject1).huF = str2;
        ((i)localObject1).drx = 3;
        ((i)localObject1).ez(true);
        ((i)localObject1).drx = 31;
        p.aBw().b((i)localObject1);
        localObject1 = d.aBh();
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
      if (e.hue.containsKey(this.username)) {
        i = ((Integer)e.hue.get(this.username)).intValue();
      }
      if (i != 0)
      {
        p.aBv();
        localContext = p.getContext();
        if (localContext != null) {
          ((e)localObject1).e(this.username, com.tencent.mm.compatible.e.a.decodeResource(localContext.getResources(), i));
        }
      }
      this.hua = e.Ab(this.username);
      AppMethodBeat.o(150222);
      return true;
    }
    
    public final boolean aBk()
    {
      AppMethodBeat.i(150223);
      if (this.hua == null)
      {
        d locald = d.this;
        String str = this.username;
        b localb = this.hub;
        ac.d("MicroMsg.AvatarService", "avatar service push: %s", new Object[] { str });
        if (bs.isNullOrNil(str))
        {
          localObject = null;
          if (localObject != null) {
            break label481;
          }
          locald.htK.remove(str);
        }
        for (;;)
        {
          AppMethodBeat.o(150223);
          return false;
          if ((str.equals(locald.htP + "@bottle")) && (!bs.a((Boolean)com.tencent.mm.kernel.g.agR().agA().get(60, null), false)))
          {
            localObject = null;
            break;
          }
          if ((str.equals(locald.htP)) && (!bs.a((Boolean)com.tencent.mm.kernel.g.agR().agA().get(59, null), false)))
          {
            ac.w("MicroMsg.AvatarService", "ConstantsStorage.USERINFO_HAS_HEADIMG false");
            localObject = null;
            break;
          }
          long l = bs.aNx();
          d.d locald1 = (d.d)locald.htL.aJ(str);
          if ((locald1 != null) && (locald1.gLY >= 5) && (l - locald1.gLX < 600L))
          {
            ac.w("MicroMsg.AvatarService", "checkUser block by recentdown: %s", new Object[] { str });
            localObject = null;
            break;
          }
          localObject = d.zX(str);
          if (localObject == null)
          {
            ac.w("MicroMsg.AvatarService", "checkUser block local no need: %s", new Object[] { str });
            localObject = new d.d((byte)0);
            ((d.d)localObject).gLY = 5;
            ((d.d)localObject).gLX = l;
            locald.htL.o(str, localObject);
            localObject = null;
            break;
          }
          if ((locald1 == null) || (l - locald1.gLX > 600L))
          {
            ac.i("MicroMsg.AvatarService", "new user: %s", new Object[] { str });
            locald1 = new d.d((byte)0);
            locald1.gLY = 1;
            locald1.gLX = l;
            locald.htL.o(str, locald1);
          }
          for (;;)
          {
            break;
            if (locald1.gLY < 5)
            {
              ac.i("MicroMsg.AvatarService", "checkUser: %s tryCount: %d time: %d", new Object[] { str, Integer.valueOf(locald1.gLY), Long.valueOf(l - locald1.gLX) });
              locald1.gLY += 1;
              locald1.gLX = l;
              locald.htL.o(str, locald1);
            }
          }
          label481:
          if (!bs.isNullOrNil(((i)localObject).aBp()))
          {
            locald.a(new d.b(locald, (i)localObject));
          }
          else
          {
            ac.w("MicroMsg.AvatarService", "dkhurl [%s] has NO URL flag:%d !", new Object[] { str, Integer.valueOf(((i)localObject).exK) });
            if (4 == ((i)localObject).exK)
            {
              ac.w("MicroMsg.AvatarService", "no avatar, do not batch get head image");
            }
            else if ((localb != null) && (!localb.htG))
            {
              ac.w("MicroMsg.AvatarService", "avatar push username %s can not get avatar by username", new Object[] { str });
              locald.htK.remove(str);
            }
            else
            {
              locald.htM.push(localObject);
              if (locald.htM.size() > 5) {
                locald.htR.au(0L, 0L);
              } else {
                locald.htR.au(1000L, 1000L);
              }
            }
          }
        }
      }
      Object localObject = d.aBh();
      if (localObject != null) {
        ((e)localObject).d(this.username, this.hua);
      }
      d.this.htK.remove(this.username);
      AppMethodBeat.o(150223);
      return false;
    }
  }
  
  static final class d
  {
    public long gLX = 0L;
    public int gLY = 0;
  }
  
  final class e
    implements bd.a
  {
    Bitmap bitmap = null;
    byte[] buf;
    i htV = null;
    
    public e(i parami, byte[] paramArrayOfByte)
    {
      this.htV = parami;
      this.buf = paramArrayOfByte;
    }
    
    public final boolean aBj()
    {
      AppMethodBeat.i(150224);
      if ((this.htV == null) || (bs.isNullOrNil(this.htV.getUsername())))
      {
        ac.e("MicroMsg.AvatarService", "SaveAvatar imgFlag info is null");
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(138L, 13L, 1L, true);
        AppMethodBeat.o(150224);
        return false;
      }
      if (d.aBh() != null)
      {
        this.bitmap = e.g(this.htV.getUsername(), this.buf);
        if (this.bitmap == null) {
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(138L, 14L, 1L, true);
        }
      }
      j localj = d.aBi();
      if (localj != null)
      {
        this.htV.drx = -1;
        this.htV.aBq();
        localj.b(this.htV);
      }
      AppMethodBeat.o(150224);
      return true;
    }
    
    public final boolean aBk()
    {
      AppMethodBeat.i(150225);
      if (bs.isNullOrNil(this.htV.getUsername()))
      {
        AppMethodBeat.o(150225);
        return false;
      }
      e locale = d.aBh();
      if ((locale != null) && (this.bitmap != null)) {
        locale.d(this.htV.getUsername(), this.bitmap);
      }
      d.this.htK.remove(this.htV.getUsername());
      AppMethodBeat.o(150225);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aj.d
 * JD-Core Version:    0.7.0.1
 */