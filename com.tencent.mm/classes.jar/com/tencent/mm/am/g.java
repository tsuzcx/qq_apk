package com.tencent.mm.am;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.c;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.bj;
import com.tencent.mm.o.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.bzi;
import com.tencent.mm.protocal.protobuf.eaw;
import com.tencent.mm.protocal.protobuf.nm;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.r;
import java.util.ArrayList;
import java.util.List;

public final class g
{
  public static boolean DL(String paramString)
  {
    AppMethodBeat.i(124044);
    paramString = eS(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(124044);
      return false;
    }
    if (paramString.Kk())
    {
      AppMethodBeat.o(124044);
      return true;
    }
    AppMethodBeat.o(124044);
    return false;
  }
  
  public static boolean DM(String paramString)
  {
    AppMethodBeat.i(124045);
    paramString = eS(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(124045);
      return false;
    }
    if (paramString.Kk())
    {
      AppMethodBeat.o(124045);
      return true;
    }
    if (paramString.Kl())
    {
      AppMethodBeat.o(124045);
      return true;
    }
    AppMethodBeat.o(124045);
    return false;
  }
  
  public static boolean DN(String paramString)
  {
    AppMethodBeat.i(124046);
    paramString = eS(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(124046);
      return false;
    }
    boolean bool = paramString.Kl();
    AppMethodBeat.o(124046);
    return bool;
  }
  
  public static boolean DO(String paramString)
  {
    AppMethodBeat.i(124047);
    paramString = eS(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(124047);
      return false;
    }
    if (paramString.Km())
    {
      AppMethodBeat.o(124047);
      return true;
    }
    AppMethodBeat.o(124047);
    return false;
  }
  
  public static boolean DP(String paramString)
  {
    AppMethodBeat.i(124048);
    paramString = eS(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(124048);
      return false;
    }
    if (paramString.Ko())
    {
      AppMethodBeat.o(124048);
      return true;
    }
    AppMethodBeat.o(124048);
    return false;
  }
  
  public static boolean DQ(String paramString)
  {
    AppMethodBeat.i(124049);
    if (paramString == null)
    {
      AppMethodBeat.o(124049);
      return false;
    }
    paramString = eS(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(124049);
      return false;
    }
    if (paramString.Kn())
    {
      AppMethodBeat.o(124049);
      return true;
    }
    AppMethodBeat.o(124049);
    return false;
  }
  
  public static boolean DR(String paramString)
  {
    AppMethodBeat.i(124051);
    paramString = eS(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(124051);
      return false;
    }
    if (paramString.Kq())
    {
      AppMethodBeat.o(124051);
      return true;
    }
    AppMethodBeat.o(124051);
    return false;
  }
  
  public static boolean DS(String paramString)
  {
    AppMethodBeat.i(124052);
    paramString = eS(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(124052);
      return false;
    }
    boolean bool = paramString.Kf();
    AppMethodBeat.o(124052);
    return bool;
  }
  
  public static void DT(String paramString)
  {
    AppMethodBeat.i(124068);
    ag.aFZ();
    Object localObject = f.DH(paramString);
    if (localObject != null) {
      ((q)com.tencent.mm.kernel.g.ab(q.class)).azt().aqe((String)localObject);
    }
    ((l)com.tencent.mm.kernel.g.ab(l.class)).azv().aTx(paramString);
    localObject = eS(paramString);
    if (localObject == null)
    {
      ag.aGi().CA(paramString);
      AppMethodBeat.o(124068);
      return;
    }
    if (((c)localObject).Kn())
    {
      ((l)com.tencent.mm.kernel.g.ab(l.class)).azv().aTQ(paramString);
      ag.aFZ();
      List localList = f.DG(paramString);
      bj.aj(localList);
      int i = 0;
      while (i < localList.size())
      {
        String str = (String)localList.get(i);
        if (vd(str)) {
          com.tencent.mm.am.a.e.N(str, true);
        }
        ag.aFZ().delete(str);
        i += 1;
      }
    }
    if (((c)localObject).Kp()) {
      com.tencent.mm.am.a.e.N(paramString, true);
    }
    ag.aFZ().e((c)localObject);
    ag.aGi().CA(paramString);
    AppMethodBeat.o(124068);
  }
  
  public static List<eaw> DU(String paramString)
  {
    AppMethodBeat.i(207172);
    try
    {
      paramString = ag.aGi().Dy(paramString);
      nm localnm = new nm();
      localnm.parseFrom(paramString.field_raw_attrs);
      paramString = localnm.FHK;
      AppMethodBeat.o(207172);
      return paramString;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(207172);
    }
    return null;
  }
  
  public static List<String> DV(String paramString)
  {
    AppMethodBeat.i(207176);
    try
    {
      paramString = ag.aGi().Dy(paramString);
      nm localnm = new nm();
      localnm.parseFrom(paramString.field_raw_attrs);
      paramString = localnm.FHM;
      AppMethodBeat.o(207176);
      return paramString;
    }
    catch (Throwable paramString)
    {
      paramString = new ArrayList(0);
      AppMethodBeat.o(207176);
    }
    return paramString;
  }
  
  public static boolean aFA()
  {
    AppMethodBeat.i(124058);
    if (ag.aFZ().oX(4) > 0)
    {
      AppMethodBeat.o(124058);
      return true;
    }
    AppMethodBeat.o(124058);
    return false;
  }
  
  public static boolean aFB()
  {
    AppMethodBeat.i(124059);
    if (ag.aFZ().oX(8) > 0)
    {
      AppMethodBeat.o(124059);
      return true;
    }
    AppMethodBeat.o(124059);
    return false;
  }
  
  public static boolean aFC()
  {
    AppMethodBeat.i(124060);
    if (ag.aFZ().oX(16) > 0)
    {
      AppMethodBeat.o(124060);
      return true;
    }
    AppMethodBeat.o(124060);
    return false;
  }
  
  public static boolean aFD()
  {
    AppMethodBeat.i(124061);
    if (ag.aFZ().oX(64) > 0)
    {
      AppMethodBeat.o(124061);
      return true;
    }
    AppMethodBeat.o(124061);
    return false;
  }
  
  public static List<String> aFE()
  {
    AppMethodBeat.i(124062);
    List localList = ag.aFZ().oW(128);
    AppMethodBeat.o(124062);
    return localList;
  }
  
  public static boolean aFF()
  {
    AppMethodBeat.i(124063);
    if (ag.aFZ().oX(128) > 0)
    {
      AppMethodBeat.o(124063);
      return true;
    }
    AppMethodBeat.o(124063);
    return false;
  }
  
  public static List<String> aFG()
  {
    AppMethodBeat.i(124064);
    List localList = ag.aFZ().oW(256);
    AppMethodBeat.o(124064);
    return localList;
  }
  
  public static boolean aFH()
  {
    AppMethodBeat.i(124065);
    if (ag.aFZ().oX(256) > 0)
    {
      AppMethodBeat.o(124065);
      return true;
    }
    AppMethodBeat.o(124065);
    return false;
  }
  
  public static List<String> aFI()
  {
    AppMethodBeat.i(124066);
    List localList = ag.aFZ().oW(512);
    AppMethodBeat.o(124066);
    return localList;
  }
  
  public static boolean aFJ()
  {
    AppMethodBeat.i(124067);
    if (ag.aFZ().oX(512) > 0)
    {
      AppMethodBeat.o(124067);
      return true;
    }
    AppMethodBeat.o(124067);
    return false;
  }
  
  public static boolean aFz()
  {
    AppMethodBeat.i(124057);
    if (ag.aFZ().oX(1) > 0)
    {
      AppMethodBeat.o(124057);
      return true;
    }
    AppMethodBeat.o(124057);
    return false;
  }
  
  public static boolean eO(String paramString)
  {
    AppMethodBeat.i(207173);
    try
    {
      boolean bool = ag.aGi().Dy(paramString).field_hide_colleage_invite;
      AppMethodBeat.o(207173);
      return bool;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(207173);
    }
    return true;
  }
  
  public static String eP(String paramString)
  {
    AppMethodBeat.i(207174);
    try
    {
      paramString = ag.aGi().Dy(paramString);
      nm localnm = new nm();
      localnm.parseFrom(paramString.field_raw_attrs);
      paramString = localnm.FHN;
      AppMethodBeat.o(207174);
      return paramString;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(207174);
    }
    return "";
  }
  
  public static String eQ(String paramString)
  {
    AppMethodBeat.i(207175);
    try
    {
      paramString = ag.aGi().Dy(paramString);
      nm localnm = new nm();
      localnm.parseFrom(paramString.field_raw_attrs);
      paramString = localnm.FHO;
      AppMethodBeat.o(207175);
      return paramString;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(207175);
    }
    return "";
  }
  
  public static c eS(String paramString)
  {
    AppMethodBeat.i(124043);
    paramString = ag.aFZ().DD(paramString);
    if (paramString.field_updateTime > 0L)
    {
      AppMethodBeat.o(124043);
      return paramString;
    }
    AppMethodBeat.o(124043);
    return null;
  }
  
  public static void h(c paramc)
  {
    AppMethodBeat.i(124053);
    if (paramc == null)
    {
      ad.e("MicroMsg.BizInfoStorageLogic", "updateBrandFlagForTempSession bizInfo is Null");
      AppMethodBeat.o(124053);
      return;
    }
    bzi localbzi = new bzi();
    localbzi.jdq = paramc.field_brandFlag;
    localbzi.nDo = paramc.field_username;
    am localam = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().aTk(paramc.field_username);
    if ((localam != null) && (b.lM(localam.field_type))) {
      ((l)com.tencent.mm.kernel.g.ab(l.class)).azo().c(new k.a(47, localbzi));
    }
    for (;;)
    {
      ad.i("MicroMsg.BizInfoStorageLogic", "updateBrandFlagForTempSession ret = %b, BrandFlag = %b", new Object[] { Boolean.valueOf(ag.aFZ().update(paramc, new String[0])), Integer.valueOf(paramc.field_brandFlag) });
      AppMethodBeat.o(124053);
      return;
      ((l)com.tencent.mm.kernel.g.ab(l.class)).azo().c(new k.a(58, localbzi));
    }
  }
  
  public static void i(c paramc)
  {
    AppMethodBeat.i(124054);
    if (paramc != null)
    {
      bzi localbzi = new bzi();
      localbzi.jdq = paramc.field_brandFlag;
      localbzi.nDo = paramc.field_username;
      ((l)com.tencent.mm.kernel.g.ab(l.class)).azo().c(new k.a(47, localbzi));
      ag.aFZ().update(paramc, new String[0]);
    }
    AppMethodBeat.o(124054);
  }
  
  public static void j(c paramc)
  {
    AppMethodBeat.i(124055);
    if (paramc != null)
    {
      paramc.field_brandFlag |= 0x8;
      i(paramc);
    }
    AppMethodBeat.o(124055);
  }
  
  public static void k(c paramc)
  {
    AppMethodBeat.i(124056);
    if (paramc != null)
    {
      paramc.field_brandFlag &= 0xFFFFFFF7;
      i(paramc);
    }
    AppMethodBeat.o(124056);
  }
  
  public static boolean vd(String paramString)
  {
    AppMethodBeat.i(124050);
    paramString = eS(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(124050);
      return false;
    }
    if (paramString.Kp())
    {
      AppMethodBeat.o(124050);
      return true;
    }
    AppMethodBeat.o(124050);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.am.g
 * JD-Core Version:    0.7.0.1
 */