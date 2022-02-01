package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.cpe;
import com.tencent.mm.protocal.protobuf.ewv;
import com.tencent.mm.protocal.protobuf.oh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.t;
import java.util.ArrayList;
import java.util.List;

public final class g
{
  public static boolean DQ(String paramString)
  {
    AppMethodBeat.i(124050);
    paramString = fJ(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(124050);
      return false;
    }
    if (paramString.UH())
    {
      AppMethodBeat.o(124050);
      return true;
    }
    AppMethodBeat.o(124050);
    return false;
  }
  
  public static boolean Nb(String paramString)
  {
    AppMethodBeat.i(124044);
    paramString = fJ(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(124044);
      return false;
    }
    if (paramString.UC())
    {
      AppMethodBeat.o(124044);
      return true;
    }
    AppMethodBeat.o(124044);
    return false;
  }
  
  public static boolean Nc(String paramString)
  {
    AppMethodBeat.i(124045);
    paramString = fJ(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(124045);
      return false;
    }
    if (paramString.UC())
    {
      AppMethodBeat.o(124045);
      return true;
    }
    if (paramString.UD())
    {
      AppMethodBeat.o(124045);
      return true;
    }
    AppMethodBeat.o(124045);
    return false;
  }
  
  public static boolean Nd(String paramString)
  {
    AppMethodBeat.i(124046);
    paramString = fJ(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(124046);
      return false;
    }
    boolean bool = paramString.UD();
    AppMethodBeat.o(124046);
    return bool;
  }
  
  public static boolean Ne(String paramString)
  {
    AppMethodBeat.i(124047);
    paramString = fJ(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(124047);
      return false;
    }
    if (paramString.UE())
    {
      AppMethodBeat.o(124047);
      return true;
    }
    AppMethodBeat.o(124047);
    return false;
  }
  
  public static boolean Nf(String paramString)
  {
    AppMethodBeat.i(124048);
    paramString = fJ(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(124048);
      return false;
    }
    if (paramString.UG())
    {
      AppMethodBeat.o(124048);
      return true;
    }
    AppMethodBeat.o(124048);
    return false;
  }
  
  public static boolean Ng(String paramString)
  {
    AppMethodBeat.i(124049);
    if (paramString == null)
    {
      AppMethodBeat.o(124049);
      return false;
    }
    paramString = fJ(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(124049);
      return false;
    }
    if (paramString.UF())
    {
      AppMethodBeat.o(124049);
      return true;
    }
    AppMethodBeat.o(124049);
    return false;
  }
  
  public static boolean Nh(String paramString)
  {
    AppMethodBeat.i(124051);
    paramString = fJ(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(124051);
      return false;
    }
    if (paramString.UI())
    {
      AppMethodBeat.o(124051);
      return true;
    }
    AppMethodBeat.o(124051);
    return false;
  }
  
  public static boolean Ni(String paramString)
  {
    AppMethodBeat.i(124052);
    paramString = fJ(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(124052);
      return false;
    }
    boolean bool = paramString.Ux();
    AppMethodBeat.o(124052);
    return bool;
  }
  
  public static void Nj(String paramString)
  {
    AppMethodBeat.i(124068);
    ag.bah();
    Object localObject = f.MX(paramString);
    if (localObject != null) {
      ((q)com.tencent.mm.kernel.g.af(q.class)).aSR().aEE((String)localObject);
    }
    ((l)com.tencent.mm.kernel.g.af(l.class)).aST().bjW(paramString);
    localObject = fJ(paramString);
    if (localObject == null)
    {
      ag.bar().gC(paramString);
      AppMethodBeat.o(124068);
      return;
    }
    if (((com.tencent.mm.api.c)localObject).UF())
    {
      ((l)com.tencent.mm.kernel.g.af(l.class)).aST().bkp(paramString);
      ag.bah();
      List localList = f.MW(paramString);
      bp.as(localList);
      int i = 0;
      while (i < localList.size())
      {
        String str = (String)localList.get(i);
        if (DQ(str)) {
          com.tencent.mm.al.a.e.P(str, true);
        }
        ag.bah().delete(str);
        i += 1;
      }
    }
    if (((com.tencent.mm.api.c)localObject).UH()) {
      com.tencent.mm.al.a.e.P(paramString, true);
    }
    ag.bah().f((com.tencent.mm.api.c)localObject);
    ag.bar().gC(paramString);
    AppMethodBeat.o(124068);
  }
  
  public static List<ewv> Nk(String paramString)
  {
    AppMethodBeat.i(212161);
    try
    {
      paramString = ag.bar().MO(paramString);
      oh localoh = new oh();
      localoh.parseFrom(paramString.field_raw_attrs);
      paramString = localoh.KUa;
      AppMethodBeat.o(212161);
      return paramString;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(212161);
    }
    return null;
  }
  
  public static List<String> Nl(String paramString)
  {
    AppMethodBeat.i(212165);
    try
    {
      paramString = ag.bar().MO(paramString);
      oh localoh = new oh();
      localoh.parseFrom(paramString.field_raw_attrs);
      paramString = localoh.KUc;
      AppMethodBeat.o(212165);
      return paramString;
    }
    catch (Throwable paramString)
    {
      paramString = new ArrayList(0);
      AppMethodBeat.o(212165);
    }
    return paramString;
  }
  
  public static boolean aZH()
  {
    AppMethodBeat.i(124057);
    if (ag.bah().sO(1) > 0)
    {
      AppMethodBeat.o(124057);
      return true;
    }
    AppMethodBeat.o(124057);
    return false;
  }
  
  public static boolean aZI()
  {
    AppMethodBeat.i(124058);
    if (ag.bah().sO(4) > 0)
    {
      AppMethodBeat.o(124058);
      return true;
    }
    AppMethodBeat.o(124058);
    return false;
  }
  
  public static boolean aZJ()
  {
    AppMethodBeat.i(124059);
    if (ag.bah().sO(8) > 0)
    {
      AppMethodBeat.o(124059);
      return true;
    }
    AppMethodBeat.o(124059);
    return false;
  }
  
  public static boolean aZK()
  {
    AppMethodBeat.i(124060);
    if (ag.bah().sO(16) > 0)
    {
      AppMethodBeat.o(124060);
      return true;
    }
    AppMethodBeat.o(124060);
    return false;
  }
  
  public static boolean aZL()
  {
    AppMethodBeat.i(124061);
    if (ag.bah().sO(64) > 0)
    {
      AppMethodBeat.o(124061);
      return true;
    }
    AppMethodBeat.o(124061);
    return false;
  }
  
  public static List<String> aZM()
  {
    AppMethodBeat.i(124062);
    List localList = ag.bah().sN(128);
    AppMethodBeat.o(124062);
    return localList;
  }
  
  public static boolean aZN()
  {
    AppMethodBeat.i(124063);
    if (ag.bah().sO(128) > 0)
    {
      AppMethodBeat.o(124063);
      return true;
    }
    AppMethodBeat.o(124063);
    return false;
  }
  
  public static List<String> aZO()
  {
    AppMethodBeat.i(124064);
    List localList = ag.bah().sN(256);
    AppMethodBeat.o(124064);
    return localList;
  }
  
  public static boolean aZP()
  {
    AppMethodBeat.i(124065);
    if (ag.bah().sO(256) > 0)
    {
      AppMethodBeat.o(124065);
      return true;
    }
    AppMethodBeat.o(124065);
    return false;
  }
  
  public static List<String> aZQ()
  {
    AppMethodBeat.i(124066);
    List localList = ag.bah().sN(512);
    AppMethodBeat.o(124066);
    return localList;
  }
  
  public static boolean aZR()
  {
    AppMethodBeat.i(124067);
    if (ag.bah().sO(512) > 0)
    {
      AppMethodBeat.o(124067);
      return true;
    }
    AppMethodBeat.o(124067);
    return false;
  }
  
  public static boolean fF(String paramString)
  {
    AppMethodBeat.i(212162);
    try
    {
      boolean bool = ag.bar().MO(paramString).field_hide_colleage_invite;
      AppMethodBeat.o(212162);
      return bool;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(212162);
    }
    return true;
  }
  
  public static String fG(String paramString)
  {
    AppMethodBeat.i(212163);
    try
    {
      paramString = ag.bar().MO(paramString);
      oh localoh = new oh();
      localoh.parseFrom(paramString.field_raw_attrs);
      paramString = localoh.KUd;
      AppMethodBeat.o(212163);
      return paramString;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(212163);
    }
    return "";
  }
  
  public static String fH(String paramString)
  {
    AppMethodBeat.i(212164);
    try
    {
      paramString = ag.bar().MO(paramString);
      oh localoh = new oh();
      localoh.parseFrom(paramString.field_raw_attrs);
      paramString = localoh.KUe;
      AppMethodBeat.o(212164);
      return paramString;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(212164);
    }
    return "";
  }
  
  public static com.tencent.mm.api.c fJ(String paramString)
  {
    AppMethodBeat.i(124043);
    paramString = ag.bah().MT(paramString);
    if (paramString.field_updateTime > 0L)
    {
      AppMethodBeat.o(124043);
      return paramString;
    }
    AppMethodBeat.o(124043);
    return null;
  }
  
  public static void i(com.tencent.mm.api.c paramc)
  {
    AppMethodBeat.i(124053);
    if (paramc == null)
    {
      Log.e("MicroMsg.BizInfoStorageLogic", "updateBrandFlagForTempSession bizInfo is Null");
      AppMethodBeat.o(124053);
      return;
    }
    cpe localcpe = new cpe();
    localcpe.kem = paramc.field_brandFlag;
    localcpe.UserName = paramc.field_username;
    as localas = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().bjK(paramc.field_username);
    if ((localas != null) && (com.tencent.mm.contact.c.oR(localas.field_type))) {
      ((l)com.tencent.mm.kernel.g.af(l.class)).aSM().d(new k.a(47, localcpe));
    }
    for (;;)
    {
      Log.i("MicroMsg.BizInfoStorageLogic", "updateBrandFlagForTempSession ret = %b, BrandFlag = %b", new Object[] { Boolean.valueOf(ag.bah().update(paramc, new String[0])), Integer.valueOf(paramc.field_brandFlag) });
      AppMethodBeat.o(124053);
      return;
      ((l)com.tencent.mm.kernel.g.af(l.class)).aSM().d(new k.a(58, localcpe));
    }
  }
  
  public static void j(com.tencent.mm.api.c paramc)
  {
    AppMethodBeat.i(124054);
    if (paramc != null)
    {
      cpe localcpe = new cpe();
      localcpe.kem = paramc.field_brandFlag;
      localcpe.UserName = paramc.field_username;
      ((l)com.tencent.mm.kernel.g.af(l.class)).aSM().d(new k.a(47, localcpe));
      ag.bah().update(paramc, new String[0]);
    }
    AppMethodBeat.o(124054);
  }
  
  public static void k(com.tencent.mm.api.c paramc)
  {
    AppMethodBeat.i(124055);
    if (paramc != null)
    {
      paramc.field_brandFlag |= 0x8;
      j(paramc);
    }
    AppMethodBeat.o(124055);
  }
  
  public static void l(com.tencent.mm.api.c paramc)
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
 * Qualified Name:     com.tencent.mm.al.g
 * JD-Core Version:    0.7.0.1
 */