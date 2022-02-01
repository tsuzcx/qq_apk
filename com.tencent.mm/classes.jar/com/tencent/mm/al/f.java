package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.n.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.protocal.protobuf.but;
import com.tencent.mm.protocal.protobuf.dvc;
import com.tencent.mm.protocal.protobuf.mv;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
import java.util.ArrayList;
import java.util.List;

public final class f
{
  public static boolean AM(String paramString)
  {
    AppMethodBeat.i(124044);
    paramString = dX(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(124044);
      return false;
    }
    if (paramString.IK())
    {
      AppMethodBeat.o(124044);
      return true;
    }
    AppMethodBeat.o(124044);
    return false;
  }
  
  public static boolean AN(String paramString)
  {
    AppMethodBeat.i(124045);
    paramString = dX(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(124045);
      return false;
    }
    if (paramString.IK())
    {
      AppMethodBeat.o(124045);
      return true;
    }
    if (paramString.IL())
    {
      AppMethodBeat.o(124045);
      return true;
    }
    AppMethodBeat.o(124045);
    return false;
  }
  
  public static boolean AO(String paramString)
  {
    AppMethodBeat.i(124046);
    paramString = dX(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(124046);
      return false;
    }
    boolean bool = paramString.IL();
    AppMethodBeat.o(124046);
    return bool;
  }
  
  public static boolean AP(String paramString)
  {
    AppMethodBeat.i(124047);
    paramString = dX(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(124047);
      return false;
    }
    if (paramString.IM())
    {
      AppMethodBeat.o(124047);
      return true;
    }
    AppMethodBeat.o(124047);
    return false;
  }
  
  public static boolean AQ(String paramString)
  {
    AppMethodBeat.i(124048);
    paramString = dX(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(124048);
      return false;
    }
    if (paramString.IO())
    {
      AppMethodBeat.o(124048);
      return true;
    }
    AppMethodBeat.o(124048);
    return false;
  }
  
  public static boolean AR(String paramString)
  {
    AppMethodBeat.i(124049);
    if (paramString == null)
    {
      AppMethodBeat.o(124049);
      return false;
    }
    paramString = dX(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(124049);
      return false;
    }
    if (paramString.IN())
    {
      AppMethodBeat.o(124049);
      return true;
    }
    AppMethodBeat.o(124049);
    return false;
  }
  
  public static boolean AS(String paramString)
  {
    AppMethodBeat.i(124051);
    paramString = dX(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(124051);
      return false;
    }
    if (paramString.IQ())
    {
      AppMethodBeat.o(124051);
      return true;
    }
    AppMethodBeat.o(124051);
    return false;
  }
  
  public static boolean AT(String paramString)
  {
    AppMethodBeat.i(124052);
    paramString = dX(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(124052);
      return false;
    }
    boolean bool = paramString.IF();
    AppMethodBeat.o(124052);
    return bool;
  }
  
  public static void AU(String paramString)
  {
    AppMethodBeat.i(124068);
    af.aCW();
    Object localObject = e.AI(paramString);
    if (localObject != null) {
      ((p)g.ab(p.class)).awE().alq((String)localObject);
    }
    ((k)g.ab(k.class)).awG().aNG(paramString);
    localObject = dX(paramString);
    if (localObject == null)
    {
      af.aDf().zB(paramString);
      AppMethodBeat.o(124068);
      return;
    }
    if (((com.tencent.mm.api.c)localObject).IN())
    {
      ((k)g.ab(k.class)).awG().aNZ(paramString);
      af.aCW();
      List localList = e.AH(paramString);
      bi.ai(localList);
      int i = 0;
      while (i < localList.size())
      {
        String str = (String)localList.get(i);
        if (so(str)) {
          com.tencent.mm.al.a.e.N(str, true);
        }
        af.aCW().delete(str);
        i += 1;
      }
    }
    if (((com.tencent.mm.api.c)localObject).IP()) {
      com.tencent.mm.al.a.e.N(paramString, true);
    }
    af.aCW().e((com.tencent.mm.api.c)localObject);
    af.aDf().zB(paramString);
    AppMethodBeat.o(124068);
  }
  
  public static List<dvc> AV(String paramString)
  {
    AppMethodBeat.i(209523);
    try
    {
      paramString = af.aDf().Az(paramString);
      mv localmv = new mv();
      localmv.parseFrom(paramString.field_raw_attrs);
      paramString = localmv.EbY;
      AppMethodBeat.o(209523);
      return paramString;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(209523);
    }
    return null;
  }
  
  public static List<String> AW(String paramString)
  {
    AppMethodBeat.i(209527);
    try
    {
      paramString = af.aDf().Az(paramString);
      mv localmv = new mv();
      localmv.parseFrom(paramString.field_raw_attrs);
      paramString = localmv.Eca;
      AppMethodBeat.o(209527);
      return paramString;
    }
    catch (Throwable paramString)
    {
      paramString = new ArrayList(0);
      AppMethodBeat.o(209527);
    }
    return paramString;
  }
  
  public static boolean aCA()
  {
    AppMethodBeat.i(124061);
    if (af.aCW().ow(64) > 0)
    {
      AppMethodBeat.o(124061);
      return true;
    }
    AppMethodBeat.o(124061);
    return false;
  }
  
  public static List<String> aCB()
  {
    AppMethodBeat.i(124062);
    List localList = af.aCW().ov(128);
    AppMethodBeat.o(124062);
    return localList;
  }
  
  public static boolean aCC()
  {
    AppMethodBeat.i(124063);
    if (af.aCW().ow(128) > 0)
    {
      AppMethodBeat.o(124063);
      return true;
    }
    AppMethodBeat.o(124063);
    return false;
  }
  
  public static List<String> aCD()
  {
    AppMethodBeat.i(124064);
    List localList = af.aCW().ov(256);
    AppMethodBeat.o(124064);
    return localList;
  }
  
  public static boolean aCE()
  {
    AppMethodBeat.i(124065);
    if (af.aCW().ow(256) > 0)
    {
      AppMethodBeat.o(124065);
      return true;
    }
    AppMethodBeat.o(124065);
    return false;
  }
  
  public static List<String> aCF()
  {
    AppMethodBeat.i(124066);
    List localList = af.aCW().ov(512);
    AppMethodBeat.o(124066);
    return localList;
  }
  
  public static boolean aCG()
  {
    AppMethodBeat.i(124067);
    if (af.aCW().ow(512) > 0)
    {
      AppMethodBeat.o(124067);
      return true;
    }
    AppMethodBeat.o(124067);
    return false;
  }
  
  public static boolean aCw()
  {
    AppMethodBeat.i(124057);
    if (af.aCW().ow(1) > 0)
    {
      AppMethodBeat.o(124057);
      return true;
    }
    AppMethodBeat.o(124057);
    return false;
  }
  
  public static boolean aCx()
  {
    AppMethodBeat.i(124058);
    if (af.aCW().ow(4) > 0)
    {
      AppMethodBeat.o(124058);
      return true;
    }
    AppMethodBeat.o(124058);
    return false;
  }
  
  public static boolean aCy()
  {
    AppMethodBeat.i(124059);
    if (af.aCW().ow(8) > 0)
    {
      AppMethodBeat.o(124059);
      return true;
    }
    AppMethodBeat.o(124059);
    return false;
  }
  
  public static boolean aCz()
  {
    AppMethodBeat.i(124060);
    if (af.aCW().ow(16) > 0)
    {
      AppMethodBeat.o(124060);
      return true;
    }
    AppMethodBeat.o(124060);
    return false;
  }
  
  public static boolean dT(String paramString)
  {
    AppMethodBeat.i(209524);
    try
    {
      boolean bool = af.aDf().Az(paramString).field_hide_colleage_invite;
      AppMethodBeat.o(209524);
      return bool;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(209524);
    }
    return true;
  }
  
  public static String dU(String paramString)
  {
    AppMethodBeat.i(209525);
    try
    {
      paramString = af.aDf().Az(paramString);
      mv localmv = new mv();
      localmv.parseFrom(paramString.field_raw_attrs);
      paramString = localmv.Ecb;
      AppMethodBeat.o(209525);
      return paramString;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(209525);
    }
    return "";
  }
  
  public static String dV(String paramString)
  {
    AppMethodBeat.i(209526);
    try
    {
      paramString = af.aDf().Az(paramString);
      mv localmv = new mv();
      localmv.parseFrom(paramString.field_raw_attrs);
      paramString = localmv.Ecc;
      AppMethodBeat.o(209526);
      return paramString;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(209526);
    }
    return "";
  }
  
  public static com.tencent.mm.api.c dX(String paramString)
  {
    AppMethodBeat.i(124043);
    paramString = af.aCW().AE(paramString);
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
      ac.e("MicroMsg.BizInfoStorageLogic", "updateBrandFlagForTempSession bizInfo is Null");
      AppMethodBeat.o(124053);
      return;
    }
    but localbut = new but();
    localbut.iKh = paramc.field_brandFlag;
    localbut.ncR = paramc.field_username;
    ai localai = ((k)g.ab(k.class)).awB().aNs(paramc.field_username);
    if ((localai != null) && (b.ln(localai.field_type))) {
      ((k)g.ab(k.class)).awA().c(new j.a(47, localbut));
    }
    for (;;)
    {
      ac.i("MicroMsg.BizInfoStorageLogic", "updateBrandFlagForTempSession ret = %b, BrandFlag = %b", new Object[] { Boolean.valueOf(af.aCW().update(paramc, new String[0])), Integer.valueOf(paramc.field_brandFlag) });
      AppMethodBeat.o(124053);
      return;
      ((k)g.ab(k.class)).awA().c(new j.a(58, localbut));
    }
  }
  
  public static void i(com.tencent.mm.api.c paramc)
  {
    AppMethodBeat.i(124054);
    if (paramc != null)
    {
      but localbut = new but();
      localbut.iKh = paramc.field_brandFlag;
      localbut.ncR = paramc.field_username;
      ((k)g.ab(k.class)).awA().c(new j.a(47, localbut));
      af.aCW().update(paramc, new String[0]);
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
  
  public static boolean so(String paramString)
  {
    AppMethodBeat.i(124050);
    paramString = dX(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(124050);
      return false;
    }
    if (paramString.IP())
    {
      AppMethodBeat.o(124050);
      return true;
    }
    AppMethodBeat.o(124050);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.al.f
 * JD-Core Version:    0.7.0.1
 */