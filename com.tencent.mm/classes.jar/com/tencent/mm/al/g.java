package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.bl;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.cac;
import com.tencent.mm.protocal.protobuf.ecn;
import com.tencent.mm.protocal.protobuf.no;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.r;
import java.util.ArrayList;
import java.util.List;

public final class g
{
  public static boolean En(String paramString)
  {
    AppMethodBeat.i(124044);
    paramString = eX(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(124044);
      return false;
    }
    if (paramString.Ks())
    {
      AppMethodBeat.o(124044);
      return true;
    }
    AppMethodBeat.o(124044);
    return false;
  }
  
  public static boolean Eo(String paramString)
  {
    AppMethodBeat.i(124045);
    paramString = eX(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(124045);
      return false;
    }
    if (paramString.Ks())
    {
      AppMethodBeat.o(124045);
      return true;
    }
    if (paramString.Kt())
    {
      AppMethodBeat.o(124045);
      return true;
    }
    AppMethodBeat.o(124045);
    return false;
  }
  
  public static boolean Ep(String paramString)
  {
    AppMethodBeat.i(124046);
    paramString = eX(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(124046);
      return false;
    }
    boolean bool = paramString.Kt();
    AppMethodBeat.o(124046);
    return bool;
  }
  
  public static boolean Eq(String paramString)
  {
    AppMethodBeat.i(124047);
    paramString = eX(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(124047);
      return false;
    }
    if (paramString.Ku())
    {
      AppMethodBeat.o(124047);
      return true;
    }
    AppMethodBeat.o(124047);
    return false;
  }
  
  public static boolean Er(String paramString)
  {
    AppMethodBeat.i(124048);
    paramString = eX(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(124048);
      return false;
    }
    if (paramString.Kw())
    {
      AppMethodBeat.o(124048);
      return true;
    }
    AppMethodBeat.o(124048);
    return false;
  }
  
  public static boolean Es(String paramString)
  {
    AppMethodBeat.i(124049);
    if (paramString == null)
    {
      AppMethodBeat.o(124049);
      return false;
    }
    paramString = eX(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(124049);
      return false;
    }
    if (paramString.Kv())
    {
      AppMethodBeat.o(124049);
      return true;
    }
    AppMethodBeat.o(124049);
    return false;
  }
  
  public static boolean Et(String paramString)
  {
    AppMethodBeat.i(124051);
    paramString = eX(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(124051);
      return false;
    }
    if (paramString.Ky())
    {
      AppMethodBeat.o(124051);
      return true;
    }
    AppMethodBeat.o(124051);
    return false;
  }
  
  public static boolean Eu(String paramString)
  {
    AppMethodBeat.i(124052);
    paramString = eX(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(124052);
      return false;
    }
    boolean bool = paramString.Kn();
    AppMethodBeat.o(124052);
    return bool;
  }
  
  public static void Ev(String paramString)
  {
    AppMethodBeat.i(124068);
    ag.aGp();
    Object localObject = f.Ej(paramString);
    if (localObject != null) {
      ((q)com.tencent.mm.kernel.g.ab(q.class)).azJ().arj((String)localObject);
    }
    ((l)com.tencent.mm.kernel.g.ab(l.class)).azL().aUY(paramString);
    localObject = eX(paramString);
    if (localObject == null)
    {
      ag.aGy().Dc(paramString);
      AppMethodBeat.o(124068);
      return;
    }
    if (((com.tencent.mm.api.c)localObject).Kv())
    {
      ((l)com.tencent.mm.kernel.g.ab(l.class)).azL().aVr(paramString);
      ag.aGp();
      List localList = f.Ei(paramString);
      bl.aj(localList);
      int i = 0;
      while (i < localList.size())
      {
        String str = (String)localList.get(i);
        if (vz(str)) {
          com.tencent.mm.al.a.e.N(str, true);
        }
        ag.aGp().delete(str);
        i += 1;
      }
    }
    if (((com.tencent.mm.api.c)localObject).Kx()) {
      com.tencent.mm.al.a.e.N(paramString, true);
    }
    ag.aGp().e((com.tencent.mm.api.c)localObject);
    ag.aGy().Dc(paramString);
    AppMethodBeat.o(124068);
  }
  
  public static List<ecn> Ew(String paramString)
  {
    AppMethodBeat.i(188870);
    try
    {
      paramString = ag.aGy().Ea(paramString);
      no localno = new no();
      localno.parseFrom(paramString.field_raw_attrs);
      paramString = localno.Gag;
      AppMethodBeat.o(188870);
      return paramString;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(188870);
    }
    return null;
  }
  
  public static List<String> Ex(String paramString)
  {
    AppMethodBeat.i(188874);
    try
    {
      paramString = ag.aGy().Ea(paramString);
      no localno = new no();
      localno.parseFrom(paramString.field_raw_attrs);
      paramString = localno.Gai;
      AppMethodBeat.o(188874);
      return paramString;
    }
    catch (Throwable paramString)
    {
      paramString = new ArrayList(0);
      AppMethodBeat.o(188874);
    }
    return paramString;
  }
  
  public static boolean aFP()
  {
    AppMethodBeat.i(124057);
    if (ag.aGp().pa(1) > 0)
    {
      AppMethodBeat.o(124057);
      return true;
    }
    AppMethodBeat.o(124057);
    return false;
  }
  
  public static boolean aFQ()
  {
    AppMethodBeat.i(124058);
    if (ag.aGp().pa(4) > 0)
    {
      AppMethodBeat.o(124058);
      return true;
    }
    AppMethodBeat.o(124058);
    return false;
  }
  
  public static boolean aFR()
  {
    AppMethodBeat.i(124059);
    if (ag.aGp().pa(8) > 0)
    {
      AppMethodBeat.o(124059);
      return true;
    }
    AppMethodBeat.o(124059);
    return false;
  }
  
  public static boolean aFS()
  {
    AppMethodBeat.i(124060);
    if (ag.aGp().pa(16) > 0)
    {
      AppMethodBeat.o(124060);
      return true;
    }
    AppMethodBeat.o(124060);
    return false;
  }
  
  public static boolean aFT()
  {
    AppMethodBeat.i(124061);
    if (ag.aGp().pa(64) > 0)
    {
      AppMethodBeat.o(124061);
      return true;
    }
    AppMethodBeat.o(124061);
    return false;
  }
  
  public static List<String> aFU()
  {
    AppMethodBeat.i(124062);
    List localList = ag.aGp().oZ(128);
    AppMethodBeat.o(124062);
    return localList;
  }
  
  public static boolean aFV()
  {
    AppMethodBeat.i(124063);
    if (ag.aGp().pa(128) > 0)
    {
      AppMethodBeat.o(124063);
      return true;
    }
    AppMethodBeat.o(124063);
    return false;
  }
  
  public static List<String> aFW()
  {
    AppMethodBeat.i(124064);
    List localList = ag.aGp().oZ(256);
    AppMethodBeat.o(124064);
    return localList;
  }
  
  public static boolean aFX()
  {
    AppMethodBeat.i(124065);
    if (ag.aGp().pa(256) > 0)
    {
      AppMethodBeat.o(124065);
      return true;
    }
    AppMethodBeat.o(124065);
    return false;
  }
  
  public static List<String> aFY()
  {
    AppMethodBeat.i(124066);
    List localList = ag.aGp().oZ(512);
    AppMethodBeat.o(124066);
    return localList;
  }
  
  public static boolean aFZ()
  {
    AppMethodBeat.i(124067);
    if (ag.aGp().pa(512) > 0)
    {
      AppMethodBeat.o(124067);
      return true;
    }
    AppMethodBeat.o(124067);
    return false;
  }
  
  public static boolean eT(String paramString)
  {
    AppMethodBeat.i(188871);
    try
    {
      boolean bool = ag.aGy().Ea(paramString).field_hide_colleage_invite;
      AppMethodBeat.o(188871);
      return bool;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(188871);
    }
    return true;
  }
  
  public static String eU(String paramString)
  {
    AppMethodBeat.i(188872);
    try
    {
      paramString = ag.aGy().Ea(paramString);
      no localno = new no();
      localno.parseFrom(paramString.field_raw_attrs);
      paramString = localno.Gaj;
      AppMethodBeat.o(188872);
      return paramString;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(188872);
    }
    return "";
  }
  
  public static String eV(String paramString)
  {
    AppMethodBeat.i(188873);
    try
    {
      paramString = ag.aGy().Ea(paramString);
      no localno = new no();
      localno.parseFrom(paramString.field_raw_attrs);
      paramString = localno.Gak;
      AppMethodBeat.o(188873);
      return paramString;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(188873);
    }
    return "";
  }
  
  public static com.tencent.mm.api.c eX(String paramString)
  {
    AppMethodBeat.i(124043);
    paramString = ag.aGp().Ef(paramString);
    if (paramString.field_updateTime > 0L)
    {
      AppMethodBeat.o(124043);
      return paramString;
    }
    AppMethodBeat.o(124043);
    return null;
  }
  
  public static void h(com.tencent.mm.api.c paramc)
  {
    AppMethodBeat.i(124053);
    if (paramc == null)
    {
      ae.e("MicroMsg.BizInfoStorageLogic", "updateBrandFlagForTempSession bizInfo is Null");
      AppMethodBeat.o(124053);
      return;
    }
    cac localcac = new cac();
    localcac.jgj = paramc.field_brandFlag;
    localcac.nIJ = paramc.field_username;
    an localan = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().aUL(paramc.field_username);
    if ((localan != null) && (com.tencent.mm.contact.c.lO(localan.field_type))) {
      ((l)com.tencent.mm.kernel.g.ab(l.class)).azE().d(new k.a(47, localcac));
    }
    for (;;)
    {
      ae.i("MicroMsg.BizInfoStorageLogic", "updateBrandFlagForTempSession ret = %b, BrandFlag = %b", new Object[] { Boolean.valueOf(ag.aGp().update(paramc, new String[0])), Integer.valueOf(paramc.field_brandFlag) });
      AppMethodBeat.o(124053);
      return;
      ((l)com.tencent.mm.kernel.g.ab(l.class)).azE().d(new k.a(58, localcac));
    }
  }
  
  public static void i(com.tencent.mm.api.c paramc)
  {
    AppMethodBeat.i(124054);
    if (paramc != null)
    {
      cac localcac = new cac();
      localcac.jgj = paramc.field_brandFlag;
      localcac.nIJ = paramc.field_username;
      ((l)com.tencent.mm.kernel.g.ab(l.class)).azE().d(new k.a(47, localcac));
      ag.aGp().update(paramc, new String[0]);
    }
    AppMethodBeat.o(124054);
  }
  
  public static void j(com.tencent.mm.api.c paramc)
  {
    AppMethodBeat.i(124055);
    if (paramc != null)
    {
      paramc.field_brandFlag |= 0x8;
      i(paramc);
    }
    AppMethodBeat.o(124055);
  }
  
  public static void k(com.tencent.mm.api.c paramc)
  {
    AppMethodBeat.i(124056);
    if (paramc != null)
    {
      paramc.field_brandFlag &= 0xFFFFFFF7;
      i(paramc);
    }
    AppMethodBeat.o(124056);
  }
  
  public static boolean vz(String paramString)
  {
    AppMethodBeat.i(124050);
    paramString = eX(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(124050);
      return false;
    }
    if (paramString.Kx())
    {
      AppMethodBeat.o(124050);
      return true;
    }
    AppMethodBeat.o(124050);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.al.g
 * JD-Core Version:    0.7.0.1
 */