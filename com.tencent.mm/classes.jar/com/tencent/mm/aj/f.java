package com.tencent.mm.aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf.6;
import com.tencent.mm.n.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import java.util.List;

public final class f
{
  public static boolean aeO()
  {
    AppMethodBeat.i(11372);
    if (z.afi().lb(1) > 0)
    {
      AppMethodBeat.o(11372);
      return true;
    }
    AppMethodBeat.o(11372);
    return false;
  }
  
  public static boolean aeP()
  {
    AppMethodBeat.i(11373);
    if (z.afi().lb(4) > 0)
    {
      AppMethodBeat.o(11373);
      return true;
    }
    AppMethodBeat.o(11373);
    return false;
  }
  
  public static boolean aeQ()
  {
    AppMethodBeat.i(11374);
    if (z.afi().lb(8) > 0)
    {
      AppMethodBeat.o(11374);
      return true;
    }
    AppMethodBeat.o(11374);
    return false;
  }
  
  public static boolean aeR()
  {
    AppMethodBeat.i(11375);
    if (z.afi().lb(16) > 0)
    {
      AppMethodBeat.o(11375);
      return true;
    }
    AppMethodBeat.o(11375);
    return false;
  }
  
  public static boolean aeS()
  {
    AppMethodBeat.i(11376);
    if (z.afi().lb(64) > 0)
    {
      AppMethodBeat.o(11376);
      return true;
    }
    AppMethodBeat.o(11376);
    return false;
  }
  
  public static List<String> aeT()
  {
    AppMethodBeat.i(11377);
    List localList = z.afi().la(128);
    AppMethodBeat.o(11377);
    return localList;
  }
  
  public static boolean aeU()
  {
    AppMethodBeat.i(11378);
    if (z.afi().lb(128) > 0)
    {
      AppMethodBeat.o(11378);
      return true;
    }
    AppMethodBeat.o(11378);
    return false;
  }
  
  public static List<String> aeV()
  {
    AppMethodBeat.i(11379);
    List localList = z.afi().la(256);
    AppMethodBeat.o(11379);
    return localList;
  }
  
  public static boolean aeW()
  {
    AppMethodBeat.i(11380);
    if (z.afi().lb(256) > 0)
    {
      AppMethodBeat.o(11380);
      return true;
    }
    AppMethodBeat.o(11380);
    return false;
  }
  
  public static List<String> aeX()
  {
    AppMethodBeat.i(11381);
    List localList = z.afi().la(512);
    AppMethodBeat.o(11381);
    return localList;
  }
  
  public static boolean aeY()
  {
    AppMethodBeat.i(11382);
    if (z.afi().lb(512) > 0)
    {
      AppMethodBeat.o(11382);
      return true;
    }
    AppMethodBeat.o(11382);
    return false;
  }
  
  public static void f(d paramd)
  {
    AppMethodBeat.i(11368);
    if (paramd == null)
    {
      ab.e("MicroMsg.BizInfoStorageLogic", "updateBrandFlagForTempSession bizInfo is Null");
      AppMethodBeat.o(11368);
      return;
    }
    bdm localbdm = new bdm();
    localbdm.gxd = paramd.field_brandFlag;
    localbdm.jJA = paramd.field_username;
    ad localad = ((j)g.E(j.class)).YA().arv(paramd.field_username);
    if ((localad != null) && (a.je(localad.field_type))) {
      ((j)g.E(j.class)).Yz().c(new j.a(47, localbdm));
    }
    for (;;)
    {
      ab.i("MicroMsg.BizInfoStorageLogic", "updateBrandFlagForTempSession ret = %b, BrandFlag = %b", new Object[] { Boolean.valueOf(z.afi().update(paramd, new String[0])), Integer.valueOf(paramd.field_brandFlag) });
      AppMethodBeat.o(11368);
      return;
      ((j)g.E(j.class)).Yz().c(new j.a(58, localbdm));
    }
  }
  
  public static void g(d paramd)
  {
    AppMethodBeat.i(11369);
    if (paramd != null)
    {
      bdm localbdm = new bdm();
      localbdm.gxd = paramd.field_brandFlag;
      localbdm.jJA = paramd.field_username;
      ((j)g.E(j.class)).Yz().c(new j.a(47, localbdm));
      z.afi().update(paramd, new String[0]);
    }
    AppMethodBeat.o(11369);
  }
  
  public static void h(d paramd)
  {
    AppMethodBeat.i(11370);
    if (paramd != null)
    {
      paramd.field_brandFlag |= 0x8;
      g(paramd);
    }
    AppMethodBeat.o(11370);
  }
  
  public static void i(d paramd)
  {
    AppMethodBeat.i(11371);
    if (paramd != null)
    {
      paramd.field_brandFlag &= 0xFFFFFFF7;
      g(paramd);
    }
    AppMethodBeat.o(11371);
  }
  
  public static boolean lg(String paramString)
  {
    AppMethodBeat.i(11365);
    paramString = rS(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(11365);
      return false;
    }
    if (paramString.aei())
    {
      AppMethodBeat.o(11365);
      return true;
    }
    AppMethodBeat.o(11365);
    return false;
  }
  
  public static d rS(String paramString)
  {
    AppMethodBeat.i(11359);
    paramString = z.afi().rK(paramString);
    if (paramString.field_updateTime > 0L)
    {
      AppMethodBeat.o(11359);
      return paramString;
    }
    AppMethodBeat.o(11359);
    return null;
  }
  
  public static boolean rT(String paramString)
  {
    AppMethodBeat.i(11360);
    paramString = rS(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(11360);
      return false;
    }
    if (paramString.aed())
    {
      AppMethodBeat.o(11360);
      return true;
    }
    AppMethodBeat.o(11360);
    return false;
  }
  
  public static boolean rU(String paramString)
  {
    AppMethodBeat.i(11361);
    paramString = rS(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(11361);
      return false;
    }
    boolean bool = paramString.aee();
    AppMethodBeat.o(11361);
    return bool;
  }
  
  public static boolean rV(String paramString)
  {
    AppMethodBeat.i(11362);
    paramString = rS(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(11362);
      return false;
    }
    if (paramString.aef())
    {
      AppMethodBeat.o(11362);
      return true;
    }
    AppMethodBeat.o(11362);
    return false;
  }
  
  public static boolean rW(String paramString)
  {
    AppMethodBeat.i(11363);
    paramString = rS(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(11363);
      return false;
    }
    if (paramString.aeh())
    {
      AppMethodBeat.o(11363);
      return true;
    }
    AppMethodBeat.o(11363);
    return false;
  }
  
  public static boolean rX(String paramString)
  {
    AppMethodBeat.i(11364);
    if (paramString == null)
    {
      AppMethodBeat.o(11364);
      return false;
    }
    paramString = rS(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(11364);
      return false;
    }
    if (paramString.aeg())
    {
      AppMethodBeat.o(11364);
      return true;
    }
    AppMethodBeat.o(11364);
    return false;
  }
  
  public static boolean rY(String paramString)
  {
    AppMethodBeat.i(11366);
    paramString = rS(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(11366);
      return false;
    }
    if (paramString.aej())
    {
      AppMethodBeat.o(11366);
      return true;
    }
    AppMethodBeat.o(11366);
    return false;
  }
  
  public static boolean rZ(String paramString)
  {
    AppMethodBeat.i(11367);
    paramString = rS(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(11367);
      return false;
    }
    boolean bool = paramString.adY();
    AppMethodBeat.o(11367);
    return bool;
  }
  
  public static void sa(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(11383);
    z.afi();
    Object localObject = e.rO(paramString);
    if (localObject != null) {
      ((o)g.E(o.class)).YD().Ts((String)localObject);
    }
    ((j)g.E(j.class)).YF().arF(paramString);
    localObject = rS(paramString);
    if (localObject == null)
    {
      z.afr().qD(paramString);
      AppMethodBeat.o(11383);
      return;
    }
    if (((d)localObject).aeg())
    {
      ((j)g.E(j.class)).YF().arX(paramString);
      z.afi();
      List localList = e.rN(paramString);
      if ((localList == null) || (localList.size() <= 0)) {
        ab.d("MicroMsg.MsgInfoStorageLogic", "deleteMsgByTalkers, empty talkers");
      }
      while (i < localList.size())
      {
        String str = (String)localList.get(i);
        if (lg(str)) {
          com.tencent.mm.aj.a.e.H(str, true);
        }
        z.afi().delete(str);
        i += 1;
        continue;
        ab.i("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalkers stack[%s]", new Object[] { bo.dtY() });
        com.tencent.mm.sdk.g.d.post(new bf.6(localList), "deleteMsgByTalkers");
      }
    }
    if (((d)localObject).aei()) {
      com.tencent.mm.aj.a.e.H(paramString, true);
    }
    z.afi().c((d)localObject);
    z.afr().qD(paramString);
    AppMethodBeat.o(11383);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aj.f
 * JD-Core Version:    0.7.0.1
 */