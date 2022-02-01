package com.tencent.mm.ao;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.c;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bq;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.cxu;
import com.tencent.mm.protocal.protobuf.fhh;
import com.tencent.mm.protocal.protobuf.nx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.t;
import java.util.ArrayList;
import java.util.List;

public final class g
{
  public static boolean KI(String paramString)
  {
    AppMethodBeat.i(124050);
    paramString = gu(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(124050);
      return false;
    }
    if (paramString.YZ())
    {
      AppMethodBeat.o(124050);
      return true;
    }
    AppMethodBeat.o(124050);
    return false;
  }
  
  public static boolean UA(String paramString)
  {
    AppMethodBeat.i(124047);
    paramString = gu(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(124047);
      return false;
    }
    if (paramString.YW())
    {
      AppMethodBeat.o(124047);
      return true;
    }
    AppMethodBeat.o(124047);
    return false;
  }
  
  public static boolean UB(String paramString)
  {
    AppMethodBeat.i(124048);
    paramString = gu(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(124048);
      return false;
    }
    if (paramString.YY())
    {
      AppMethodBeat.o(124048);
      return true;
    }
    AppMethodBeat.o(124048);
    return false;
  }
  
  public static boolean UC(String paramString)
  {
    AppMethodBeat.i(124049);
    if (paramString == null)
    {
      AppMethodBeat.o(124049);
      return false;
    }
    paramString = gu(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(124049);
      return false;
    }
    if (paramString.YX())
    {
      AppMethodBeat.o(124049);
      return true;
    }
    AppMethodBeat.o(124049);
    return false;
  }
  
  public static boolean UD(String paramString)
  {
    AppMethodBeat.i(124051);
    paramString = gu(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(124051);
      return false;
    }
    if (paramString.Za())
    {
      AppMethodBeat.o(124051);
      return true;
    }
    AppMethodBeat.o(124051);
    return false;
  }
  
  public static boolean UE(String paramString)
  {
    AppMethodBeat.i(124052);
    paramString = gu(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(124052);
      return false;
    }
    boolean bool = paramString.YP();
    AppMethodBeat.o(124052);
    return bool;
  }
  
  public static void UF(String paramString)
  {
    AppMethodBeat.i(124068);
    af.bjv();
    Object localObject = f.Ut(paramString);
    if (localObject != null) {
      ((q)h.ae(q.class)).bbP().aOO((String)localObject);
    }
    ((n)h.ae(n.class)).bbR().bwv(paramString);
    localObject = gu(paramString);
    if (localObject == null)
    {
      af.bjF().ho(paramString);
      AppMethodBeat.o(124068);
      return;
    }
    if (((c)localObject).YX())
    {
      ((n)h.ae(n.class)).bbR().bwO(paramString);
      af.bjv();
      List localList = f.Us(paramString);
      bq.aq(localList);
      int i = 0;
      while (i < localList.size())
      {
        String str = (String)localList.get(i);
        if (KI(str)) {
          com.tencent.mm.ao.a.e.R(str, true);
        }
        af.bjv().Up(str);
        i += 1;
      }
    }
    if (((c)localObject).YZ()) {
      com.tencent.mm.ao.a.e.R(paramString, true);
    }
    af.bjv().f((c)localObject);
    af.bjF().ho(paramString);
    AppMethodBeat.o(124068);
  }
  
  public static List<fhh> UG(String paramString)
  {
    AppMethodBeat.i(205819);
    try
    {
      paramString = af.bjF().Uj(paramString);
      nx localnx = new nx();
      localnx.parseFrom(paramString.field_raw_attrs);
      paramString = localnx.RUY;
      AppMethodBeat.o(205819);
      return paramString;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(205819);
    }
    return null;
  }
  
  public static List<String> UH(String paramString)
  {
    AppMethodBeat.i(205823);
    try
    {
      paramString = af.bjF().Uj(paramString);
      nx localnx = new nx();
      localnx.parseFrom(paramString.field_raw_attrs);
      paramString = localnx.RVa;
      AppMethodBeat.o(205823);
      return paramString;
    }
    catch (Throwable paramString)
    {
      paramString = new ArrayList(0);
      AppMethodBeat.o(205823);
    }
    return paramString;
  }
  
  public static boolean Ux(String paramString)
  {
    AppMethodBeat.i(124044);
    paramString = gu(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(124044);
      return false;
    }
    if (paramString.YU())
    {
      AppMethodBeat.o(124044);
      return true;
    }
    AppMethodBeat.o(124044);
    return false;
  }
  
  public static boolean Uy(String paramString)
  {
    AppMethodBeat.i(124045);
    paramString = gu(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(124045);
      return false;
    }
    if (paramString.YU())
    {
      AppMethodBeat.o(124045);
      return true;
    }
    if (paramString.YV())
    {
      AppMethodBeat.o(124045);
      return true;
    }
    AppMethodBeat.o(124045);
    return false;
  }
  
  public static boolean Uz(String paramString)
  {
    AppMethodBeat.i(124046);
    paramString = gu(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(124046);
      return false;
    }
    boolean bool = paramString.YV();
    AppMethodBeat.o(124046);
    return bool;
  }
  
  public static boolean biX()
  {
    AppMethodBeat.i(124057);
    if (af.bjv().vL(1) > 0)
    {
      AppMethodBeat.o(124057);
      return true;
    }
    AppMethodBeat.o(124057);
    return false;
  }
  
  public static boolean biY()
  {
    AppMethodBeat.i(124058);
    if (af.bjv().vL(4) > 0)
    {
      AppMethodBeat.o(124058);
      return true;
    }
    AppMethodBeat.o(124058);
    return false;
  }
  
  public static boolean biZ()
  {
    AppMethodBeat.i(124059);
    if (af.bjv().vL(8) > 0)
    {
      AppMethodBeat.o(124059);
      return true;
    }
    AppMethodBeat.o(124059);
    return false;
  }
  
  public static boolean bja()
  {
    AppMethodBeat.i(124060);
    if (af.bjv().vL(16) > 0)
    {
      AppMethodBeat.o(124060);
      return true;
    }
    AppMethodBeat.o(124060);
    return false;
  }
  
  public static boolean bjb()
  {
    AppMethodBeat.i(124061);
    if (af.bjv().vL(64) > 0)
    {
      AppMethodBeat.o(124061);
      return true;
    }
    AppMethodBeat.o(124061);
    return false;
  }
  
  public static List<String> bjc()
  {
    AppMethodBeat.i(124062);
    List localList = af.bjv().vK(128);
    AppMethodBeat.o(124062);
    return localList;
  }
  
  public static boolean bjd()
  {
    AppMethodBeat.i(124063);
    if (af.bjv().vL(128) > 0)
    {
      AppMethodBeat.o(124063);
      return true;
    }
    AppMethodBeat.o(124063);
    return false;
  }
  
  public static List<String> bje()
  {
    AppMethodBeat.i(124064);
    List localList = af.bjv().vK(256);
    AppMethodBeat.o(124064);
    return localList;
  }
  
  public static boolean bjf()
  {
    AppMethodBeat.i(124065);
    if (af.bjv().vL(256) > 0)
    {
      AppMethodBeat.o(124065);
      return true;
    }
    AppMethodBeat.o(124065);
    return false;
  }
  
  public static List<String> bjg()
  {
    AppMethodBeat.i(124066);
    List localList = af.bjv().vK(512);
    AppMethodBeat.o(124066);
    return localList;
  }
  
  public static boolean bjh()
  {
    AppMethodBeat.i(124067);
    if (af.bjv().vL(512) > 0)
    {
      AppMethodBeat.o(124067);
      return true;
    }
    AppMethodBeat.o(124067);
    return false;
  }
  
  public static boolean gq(String paramString)
  {
    AppMethodBeat.i(205820);
    try
    {
      boolean bool = af.bjF().Uj(paramString).field_hide_colleage_invite;
      AppMethodBeat.o(205820);
      return bool;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(205820);
    }
    return true;
  }
  
  public static String gr(String paramString)
  {
    AppMethodBeat.i(205821);
    try
    {
      paramString = af.bjF().Uj(paramString);
      nx localnx = new nx();
      localnx.parseFrom(paramString.field_raw_attrs);
      paramString = localnx.RVb;
      AppMethodBeat.o(205821);
      return paramString;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(205821);
    }
    return "";
  }
  
  public static String gs(String paramString)
  {
    AppMethodBeat.i(205822);
    try
    {
      paramString = af.bjF().Uj(paramString);
      nx localnx = new nx();
      localnx.parseFrom(paramString.field_raw_attrs);
      paramString = localnx.RVc;
      AppMethodBeat.o(205822);
      return paramString;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(205822);
    }
    return "";
  }
  
  public static c gu(String paramString)
  {
    AppMethodBeat.i(124043);
    paramString = af.bjv().Uo(paramString);
    if (paramString.field_updateTime > 0L)
    {
      AppMethodBeat.o(124043);
      return paramString;
    }
    AppMethodBeat.o(124043);
    return null;
  }
  
  public static void i(c paramc)
  {
    AppMethodBeat.i(124053);
    if (paramc == null)
    {
      Log.e("MicroMsg.BizInfoStorageLogic", "updateBrandFlagForTempSession bizInfo is Null");
      AppMethodBeat.o(124053);
      return;
    }
    cxu localcxu = new cxu();
    localcxu.mVM = paramc.field_brandFlag;
    localcxu.UserName = paramc.field_username;
    as localas = ((n)h.ae(n.class)).bbL().bwh(paramc.field_username);
    if ((localas != null) && (com.tencent.mm.contact.d.rk(localas.field_type))) {
      ((n)h.ae(n.class)).bbK().d(new k.a(47, localcxu));
    }
    for (;;)
    {
      Log.i("MicroMsg.BizInfoStorageLogic", "updateBrandFlagForTempSession ret = %b, BrandFlag = %b", new Object[] { Boolean.valueOf(af.bjv().update(paramc, new String[0])), Integer.valueOf(paramc.field_brandFlag) });
      AppMethodBeat.o(124053);
      return;
      ((n)h.ae(n.class)).bbK().d(new k.a(58, localcxu));
    }
  }
  
  public static void j(c paramc)
  {
    AppMethodBeat.i(124054);
    if (paramc != null)
    {
      cxu localcxu = new cxu();
      localcxu.mVM = paramc.field_brandFlag;
      localcxu.UserName = paramc.field_username;
      ((n)h.ae(n.class)).bbK().d(new k.a(47, localcxu));
      af.bjv().update(paramc, new String[0]);
    }
    AppMethodBeat.o(124054);
  }
  
  public static void k(c paramc)
  {
    AppMethodBeat.i(124055);
    if (paramc != null)
    {
      paramc.field_brandFlag |= 0x8;
      j(paramc);
    }
    AppMethodBeat.o(124055);
  }
  
  public static void l(c paramc)
  {
    AppMethodBeat.i(124056);
    if (paramc != null)
    {
      paramc.field_brandFlag &= 0xFFFFFFF7;
      j(paramc);
    }
    AppMethodBeat.o(124056);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ao.g
 * JD-Core Version:    0.7.0.1
 */