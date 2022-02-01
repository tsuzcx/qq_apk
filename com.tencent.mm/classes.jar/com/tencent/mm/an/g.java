package com.tencent.mm.an;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.c;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.br;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.doz;
import com.tencent.mm.protocal.protobuf.gdt;
import com.tencent.mm.protocal.protobuf.pd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.t;
import java.util.ArrayList;
import java.util.List;

public final class g
{
  public static boolean Dn(String paramString)
  {
    AppMethodBeat.i(124050);
    paramString = hU(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(124050);
      return false;
    }
    if (paramString.aAR())
    {
      AppMethodBeat.o(124050);
      return true;
    }
    AppMethodBeat.o(124050);
    return false;
  }
  
  public static boolean MA(String paramString)
  {
    AppMethodBeat.i(124048);
    paramString = hU(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(124048);
      return false;
    }
    if (paramString.aAQ())
    {
      AppMethodBeat.o(124048);
      return true;
    }
    AppMethodBeat.o(124048);
    return false;
  }
  
  public static boolean MB(String paramString)
  {
    AppMethodBeat.i(124049);
    if (paramString == null)
    {
      AppMethodBeat.o(124049);
      return false;
    }
    paramString = hU(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(124049);
      return false;
    }
    if (paramString.aAP())
    {
      AppMethodBeat.o(124049);
      return true;
    }
    AppMethodBeat.o(124049);
    return false;
  }
  
  public static boolean MC(String paramString)
  {
    AppMethodBeat.i(124051);
    paramString = hU(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(124051);
      return false;
    }
    if (paramString.aAS())
    {
      AppMethodBeat.o(124051);
      return true;
    }
    AppMethodBeat.o(124051);
    return false;
  }
  
  public static boolean MD(String paramString)
  {
    AppMethodBeat.i(124052);
    paramString = hU(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(124052);
      return false;
    }
    boolean bool = paramString.aAH();
    AppMethodBeat.o(124052);
    return bool;
  }
  
  public static void ME(String paramString)
  {
    AppMethodBeat.i(124068);
    af.bHf();
    Object localObject = f.Ms(paramString);
    if (localObject != null) {
      ((q)h.ax(q.class)).bzE().aLO((String)localObject);
    }
    ((n)h.ax(n.class)).bzG().bxK(paramString);
    localObject = hU(paramString);
    if (localObject == null)
    {
      af.bHq().iP(paramString);
      AppMethodBeat.o(124068);
      return;
    }
    if (((c)localObject).aAP())
    {
      ((n)h.ax(n.class)).bzG().byh(paramString);
      af.bHf();
      List localList = f.Mr(paramString);
      br.bV(localList);
      int i = 0;
      while (i < localList.size())
      {
        String str = (String)localList.get(i);
        if (Dn(str)) {
          com.tencent.mm.an.a.e.V(str, true);
        }
        af.bHf().Mo(str);
        i += 1;
      }
    }
    if (((c)localObject).aAR()) {
      com.tencent.mm.an.a.e.V(paramString, true);
    }
    af.bHf().f((c)localObject);
    af.bHq().iP(paramString);
    AppMethodBeat.o(124068);
  }
  
  public static List<gdt> MF(String paramString)
  {
    AppMethodBeat.i(239482);
    try
    {
      paramString = af.bHq().Mi(paramString);
      pd localpd = new pd();
      localpd.parseFrom(paramString.field_raw_attrs);
      paramString = localpd.YSw;
      return paramString;
    }
    finally
    {
      AppMethodBeat.o(239482);
    }
    return null;
  }
  
  public static List<String> MG(String paramString)
  {
    AppMethodBeat.i(239497);
    try
    {
      paramString = af.bHq().Mi(paramString);
      pd localpd = new pd();
      localpd.parseFrom(paramString.field_raw_attrs);
      paramString = localpd.YSy;
      AppMethodBeat.o(239497);
      return paramString;
    }
    finally
    {
      paramString = new ArrayList(0);
      AppMethodBeat.o(239497);
    }
    return paramString;
  }
  
  public static boolean Mw(String paramString)
  {
    AppMethodBeat.i(124044);
    paramString = hU(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(124044);
      return false;
    }
    if (paramString.aAM())
    {
      AppMethodBeat.o(124044);
      return true;
    }
    AppMethodBeat.o(124044);
    return false;
  }
  
  public static boolean Mx(String paramString)
  {
    AppMethodBeat.i(124045);
    paramString = hU(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(124045);
      return false;
    }
    if (paramString.aAM())
    {
      AppMethodBeat.o(124045);
      return true;
    }
    if (paramString.aAN())
    {
      AppMethodBeat.o(124045);
      return true;
    }
    AppMethodBeat.o(124045);
    return false;
  }
  
  public static boolean My(String paramString)
  {
    AppMethodBeat.i(124046);
    paramString = hU(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(124046);
      return false;
    }
    boolean bool = paramString.aAN();
    AppMethodBeat.o(124046);
    return bool;
  }
  
  public static boolean Mz(String paramString)
  {
    AppMethodBeat.i(124047);
    paramString = hU(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(124047);
      return false;
    }
    if (paramString.aAO())
    {
      AppMethodBeat.o(124047);
      return true;
    }
    AppMethodBeat.o(124047);
    return false;
  }
  
  public static boolean bGH()
  {
    AppMethodBeat.i(124057);
    if (af.bHf().vQ(1) > 0)
    {
      AppMethodBeat.o(124057);
      return true;
    }
    AppMethodBeat.o(124057);
    return false;
  }
  
  public static boolean bGI()
  {
    AppMethodBeat.i(124058);
    if (af.bHf().vQ(4) > 0)
    {
      AppMethodBeat.o(124058);
      return true;
    }
    AppMethodBeat.o(124058);
    return false;
  }
  
  public static boolean bGJ()
  {
    AppMethodBeat.i(124059);
    if (af.bHf().vQ(8) > 0)
    {
      AppMethodBeat.o(124059);
      return true;
    }
    AppMethodBeat.o(124059);
    return false;
  }
  
  public static boolean bGK()
  {
    AppMethodBeat.i(124060);
    if (af.bHf().vQ(16) > 0)
    {
      AppMethodBeat.o(124060);
      return true;
    }
    AppMethodBeat.o(124060);
    return false;
  }
  
  public static boolean bGL()
  {
    AppMethodBeat.i(124061);
    if (af.bHf().vQ(64) > 0)
    {
      AppMethodBeat.o(124061);
      return true;
    }
    AppMethodBeat.o(124061);
    return false;
  }
  
  public static List<String> bGM()
  {
    AppMethodBeat.i(124062);
    List localList = af.bHf().vP(128);
    AppMethodBeat.o(124062);
    return localList;
  }
  
  public static boolean bGN()
  {
    AppMethodBeat.i(124063);
    if (af.bHf().vQ(128) > 0)
    {
      AppMethodBeat.o(124063);
      return true;
    }
    AppMethodBeat.o(124063);
    return false;
  }
  
  public static List<String> bGO()
  {
    AppMethodBeat.i(124064);
    List localList = af.bHf().vP(256);
    AppMethodBeat.o(124064);
    return localList;
  }
  
  public static boolean bGP()
  {
    AppMethodBeat.i(124065);
    if (af.bHf().vQ(256) > 0)
    {
      AppMethodBeat.o(124065);
      return true;
    }
    AppMethodBeat.o(124065);
    return false;
  }
  
  public static List<String> bGQ()
  {
    AppMethodBeat.i(124066);
    List localList = af.bHf().vP(512);
    AppMethodBeat.o(124066);
    return localList;
  }
  
  public static boolean bGR()
  {
    AppMethodBeat.i(124067);
    if (af.bHf().vQ(512) > 0)
    {
      AppMethodBeat.o(124067);
      return true;
    }
    AppMethodBeat.o(124067);
    return false;
  }
  
  public static boolean hQ(String paramString)
  {
    AppMethodBeat.i(239486);
    try
    {
      boolean bool = af.bHq().Mi(paramString).field_hide_colleage_invite;
      return bool;
    }
    finally
    {
      AppMethodBeat.o(239486);
    }
    return true;
  }
  
  public static String hR(String paramString)
  {
    AppMethodBeat.i(239488);
    try
    {
      paramString = af.bHq().Mi(paramString);
      pd localpd = new pd();
      localpd.parseFrom(paramString.field_raw_attrs);
      paramString = localpd.YSz;
      return paramString;
    }
    finally
    {
      AppMethodBeat.o(239488);
    }
    return "";
  }
  
  public static String hS(String paramString)
  {
    AppMethodBeat.i(239491);
    try
    {
      paramString = af.bHq().Mi(paramString);
      pd localpd = new pd();
      localpd.parseFrom(paramString.field_raw_attrs);
      paramString = localpd.YSA;
      return paramString;
    }
    finally
    {
      AppMethodBeat.o(239491);
    }
    return "";
  }
  
  public static c hU(String paramString)
  {
    AppMethodBeat.i(124043);
    paramString = af.bHf().Mn(paramString);
    if ((paramString != null) && (paramString.field_updateTime > 0L))
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
    doz localdoz = new doz();
    localdoz.pSt = paramc.field_brandFlag;
    localdoz.UserName = paramc.field_username;
    au localau = ((n)h.ax(n.class)).bzA().bxv(paramc.field_username);
    if ((localau != null) && (com.tencent.mm.contact.d.rs(localau.field_type))) {
      ((n)h.ax(n.class)).bzz().d(new k.a(47, localdoz));
    }
    for (;;)
    {
      Log.i("MicroMsg.BizInfoStorageLogic", "updateBrandFlagForTempSession ret = %b, BrandFlag = %b", new Object[] { Boolean.valueOf(af.bHf().update(paramc, new String[0])), Integer.valueOf(paramc.field_brandFlag) });
      AppMethodBeat.o(124053);
      return;
      ((n)h.ax(n.class)).bzz().d(new k.a(58, localdoz));
    }
  }
  
  public static void j(c paramc)
  {
    AppMethodBeat.i(124054);
    if (paramc != null)
    {
      doz localdoz = new doz();
      localdoz.pSt = paramc.field_brandFlag;
      localdoz.UserName = paramc.field_username;
      ((n)h.ax(n.class)).bzz().d(new k.a(47, localdoz));
      af.bHf().update(paramc, new String[0]);
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
 * Qualified Name:     com.tencent.mm.an.g
 * JD-Core Version:    0.7.0.1
 */