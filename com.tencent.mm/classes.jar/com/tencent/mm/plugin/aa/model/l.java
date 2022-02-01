package com.tencent.mm.plugin.aa.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.protocal.protobuf.z;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.List;
import java.util.Map;

public final class l
  implements com.tencent.mm.al.f
{
  public static String iSW = "title";
  public static String iSX = "totalPayAmount";
  public static String iSY = "totalUserNumber";
  public static String iSZ = "perAmount";
  public static String iTa = "chatRoomName";
  public static String iTb = "launchScene";
  public static String iTc = "payerlist";
  public static String iTd = "timestamp";
  public static String iTe = "pic_cdn_url";
  public static String iTf = "pic_cdn_thumb_url";
  public static String iTg = "pf_order_no";
  private static int iTh = 131100026;
  private com.tencent.mm.vending.g.b iSR;
  private boolean iTi = false;
  private Map<String, Object> iTj;
  private int mode = 0;
  
  public final boolean b(int paramInt, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(63363);
    this.iSR = com.tencent.mm.vending.g.g.fOa();
    if (this.iTi)
    {
      ad.e("MicroMsg.LaunchAALogic", "launchAA, isLaunching!!! ignore it");
      this.iSR.ee(Boolean.FALSE);
      AppMethodBeat.o(63363);
      return false;
    }
    if ((paramMap == null) || (paramMap.size() == 0))
    {
      this.iSR.ee(Boolean.FALSE);
      AppMethodBeat.o(63363);
      return false;
    }
    ad.i("MicroMsg.LaunchAALogic", "launchAAByMoney, data.keySet: %s", new Object[] { paramMap.keySet() });
    this.iTi = true;
    this.iTj = paramMap;
    this.mode = paramInt;
    long l1;
    Object localObject;
    long l2;
    if (paramInt == a.iRV)
    {
      if ((this.iTj.containsKey(iSW)) && (this.iTj.containsKey(iSZ)) && (this.iTj.containsKey(iSY)) && (this.iTj.containsKey(iTb)) && (this.iTj.containsKey(iTa)) && (this.iTj.containsKey(iTd))) {
        try
        {
          paramMap = (String)this.iTj.get(iSW);
          l1 = ((Long)this.iTj.get(iSZ)).longValue();
          paramInt = ((Integer)this.iTj.get(iSY)).intValue();
          int i = ((Integer)this.iTj.get(iTb)).intValue();
          localObject = (String)this.iTj.get(iTa);
          l2 = ((Long)this.iTj.get(iTd)).longValue();
          ad.i("MicroMsg.LaunchAALogic", "launchAAByMoney");
          com.tencent.mm.kernel.g.ajD();
          com.tencent.mm.kernel.g.ajB().gAO.a(new com.tencent.mm.plugin.aa.model.cgi.f(l1, paramMap, paramInt, i, l2, (String)localObject), 0);
          if ((paramInt > 0) && (paramInt <= 10)) {
            paramInt = 13;
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(407L, paramInt, 1L, false);
            this.iSR.fNZ();
            AppMethodBeat.o(63363);
            return true;
            if ((paramInt > 10) && (paramInt <= 20)) {
              paramInt = 14;
            } else if ((paramInt > 20) && (paramInt <= 50)) {
              paramInt = 15;
            } else {
              paramInt = 16;
            }
          }
          this.iSR.ee(Boolean.FALSE);
        }
        catch (Exception paramMap)
        {
          ad.e("MicroMsg.LaunchAALogic", "launchAAByMoney, without specific user error: %s", new Object[] { paramMap.getMessage() });
          this.iSR.ee(Boolean.FALSE);
          this.iTi = false;
          AppMethodBeat.o(63363);
          return false;
        }
      }
      this.iTi = false;
      AppMethodBeat.o(63363);
      return false;
    }
    if (paramInt == a.iRW)
    {
      if ((this.iTj.containsKey(iSW)) && (this.iTj.containsKey(iSZ)) && (this.iTj.containsKey(iTc)) && (this.iTj.containsKey(iTb)) && (this.iTj.containsKey(iTa)) && (this.iTj.containsKey(iTd))) {
        try
        {
          paramMap = (String)this.iTj.get(iSW);
          l1 = ((Long)this.iTj.get(iSZ)).longValue();
          localObject = (List)this.iTj.get(iTc);
          paramInt = ((Integer)this.iTj.get(iTb)).intValue();
          String str1 = (String)this.iTj.get(iTa);
          l2 = ((Long)this.iTj.get(iTd)).longValue();
          String str2 = (String)this.iTj.get(iTe);
          String str3 = (String)this.iTj.get(iTf);
          String str4 = (String)this.iTj.get(iTg);
          com.tencent.mm.kernel.g.ajD();
          com.tencent.mm.kernel.g.ajB().gAO.a(new com.tencent.mm.plugin.aa.model.cgi.f(l1, paramMap, (List)localObject, paramInt, l2, str1, str2, str3, str4), 0);
          paramInt = ((List)localObject).size();
          if ((paramInt > 0) && (paramInt <= 10)) {
            paramInt = 13;
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(407L, paramInt, 1L, false);
            this.iSR.fNZ();
            AppMethodBeat.o(63363);
            return true;
            if ((paramInt > 10) && (paramInt <= 20)) {
              paramInt = 14;
            } else if ((paramInt > 20) && (paramInt <= 50)) {
              paramInt = 15;
            } else {
              paramInt = 16;
            }
          }
          this.iSR.ee(Boolean.FALSE);
        }
        catch (Exception paramMap)
        {
          ad.e("MicroMsg.LaunchAALogic", "launchAAByMoney, specific user error: %", new Object[] { paramMap.getMessage() });
          this.iSR.ee(Boolean.FALSE);
          this.iTi = false;
          AppMethodBeat.o(63363);
          return false;
        }
      }
      this.iTi = false;
      AppMethodBeat.o(63363);
      return false;
    }
    AppMethodBeat.o(63363);
    return false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(63365);
    ad.d("MicroMsg.LaunchAALogic", "onSceneEnd, errType: %s, errCode: %s, scene: %s, mode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramn, Integer.valueOf(this.mode) });
    String str;
    boolean bool;
    if (paramn.getType() == 1624)
    {
      this.iTi = false;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramn = (com.tencent.mm.plugin.aa.model.cgi.f)paramn;
        paramString = paramn.iTr;
        paramInt1 = paramString.dlw;
        str = paramString.paA;
        if (paramString.FpI == null)
        {
          bool = true;
          ad.i("MicroMsg.LaunchAALogic", "launchAAByMoney, onSceneEnd, retCode: %s, retmsg: %s, msgXml==null: %s, billNo: %s", new Object[] { Integer.valueOf(paramInt1), str, Boolean.valueOf(bool), paramString.FpG });
          if (paramString.dlw != 0) {
            break label250;
          }
          if (paramString.FpI == null) {
            break label221;
          }
          i.u(paramString.FpG, paramn.chatroomName, paramString.FpI);
          com.tencent.mm.vending.g.g.a(this.iSR, new Object[] { Boolean.TRUE });
        }
        for (;;)
        {
          i.Je(paramn.chatroomName);
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(407L, 0L, 1L, false);
          AppMethodBeat.o(63365);
          return;
          bool = false;
          break;
          label221:
          i.a(paramString.FpG, false, 0L);
          com.tencent.mm.vending.g.g.a(this.iSR, new Object[] { Boolean.TRUE });
        }
        label250:
        if (this.iSR != null)
        {
          if (paramString.dlw <= 0) {
            break label441;
          }
          paramn = paramString.FpR;
          if ((paramn == null) || (paramn.Fqw <= 0)) {
            break label314;
          }
          this.iSR.ee(paramn);
        }
        label441:
        for (;;)
        {
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(407L, 2L, 1L, false);
          AppMethodBeat.o(63365);
          return;
          label314:
          if ((paramString.FpS != null) && (paramString.FpS.dDp == 1) && (!bt.isNullOrNil(paramString.FpS.paG)) && (!bt.isNullOrNil(paramString.FpS.kzK)) && (!bt.isNullOrNil(paramString.FpS.kzL)) && (!bt.isNullOrNil(paramString.FpS.dxD)))
          {
            this.iSR.ee(paramString.FpS);
          }
          else if (!bt.isNullOrNil(paramString.paA))
          {
            this.iSR.ee(paramString.paA);
          }
          else
          {
            this.iSR.ee(Boolean.FALSE);
            continue;
            this.iSR.ee(Boolean.FALSE);
          }
        }
      }
      if (this.iSR != null) {
        this.iSR.ee(Boolean.FALSE);
      }
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(407L, 1L, 1L, false);
      AppMethodBeat.o(63365);
      return;
    }
    if (paramn.getType() == 1655)
    {
      this.iTi = false;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramn = (com.tencent.mm.plugin.aa.model.cgi.g)paramn;
        paramString = paramn.iTt;
        paramInt1 = paramString.dlw;
        str = paramString.paA;
        if (paramString.FpI == null)
        {
          bool = true;
          ad.i("MicroMsg.LaunchAALogic", "launchAAByPerson, onSceneEnd, retCode: %s, retmsg: %s, msgxml==null: %s", new Object[] { Integer.valueOf(paramInt1), str, Boolean.valueOf(bool) });
          ad.d("MicroMsg.LaunchAALogic", "launchAAByPerson, onSceneEnd, retMsg: %s, billNo: %s", new Object[] { paramString.paA, paramString.FpG });
          if (paramString.dlw != 0) {
            break label733;
          }
          if (paramString.FpI == null) {
            break label697;
          }
          i.u(paramString.FpG, paramn.chatroomName, paramString.FpI);
          com.tencent.mm.vending.g.g.a(this.iSR, new Object[] { Boolean.TRUE, paramString.FpG });
        }
        for (;;)
        {
          i.Je(paramn.chatroomName);
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(407L, 3L, 1L, false);
          AppMethodBeat.o(63365);
          return;
          bool = false;
          break;
          label697:
          i.a(paramString.FpG, false, 0L);
          com.tencent.mm.vending.g.g.a(this.iSR, new Object[] { Boolean.TRUE, paramString.FpG });
        }
        label733:
        if (paramString.dlw > 0)
        {
          paramn = paramString.FpR;
          if ((paramn != null) && (paramn.Fqw > 0)) {
            this.iSR.ee(paramn);
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(407L, 5L, 1L, false);
          AppMethodBeat.o(63365);
          return;
          if ((paramString.FpS != null) && (paramString.FpS.dDp == 1) && (!bt.isNullOrNil(paramString.FpS.paG)) && (!bt.isNullOrNil(paramString.FpS.kzK)) && (!bt.isNullOrNil(paramString.FpS.kzL)) && (!bt.isNullOrNil(paramString.FpS.dxD)))
          {
            this.iSR.ee(paramString.FpS);
          }
          else if (!bt.isNullOrNil(paramString.paA))
          {
            this.iSR.ee(paramString.paA);
          }
          else
          {
            this.iSR.ee(Boolean.FALSE);
            continue;
            this.iSR.ee(Boolean.FALSE);
          }
        }
      }
      if (this.iSR != null) {
        this.iSR.ee(Boolean.FALSE);
      }
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(407L, 4L, 1L, false);
    }
    AppMethodBeat.o(63365);
  }
  
  public final boolean w(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(63364);
    this.iSR = com.tencent.mm.vending.g.g.fOa();
    ad.i("MicroMsg.LaunchAALogic", "launchAAByPerson");
    if (this.iTi)
    {
      ad.e("MicroMsg.LaunchAALogic", "launchAA, isLaunching!!! ignore it");
      this.iSR.ee(Boolean.FALSE);
      AppMethodBeat.o(63364);
      return false;
    }
    if ((paramMap == null) || (paramMap.size() == 0))
    {
      this.iSR.ee(Boolean.FALSE);
      AppMethodBeat.o(63364);
      return false;
    }
    this.iTi = true;
    this.iTj = paramMap;
    this.mode = a.iRX;
    if (this.mode != a.iRX)
    {
      this.iSR.ee(Boolean.FALSE);
      AppMethodBeat.o(63364);
      return false;
    }
    if ((this.iTj.containsKey(iSW)) && (this.iTj.containsKey(iSX)) && (this.iTj.containsKey(iTc)) && (this.iTj.containsKey(iTb)) && (this.iTj.containsKey(iTa)) && (this.iTj.containsKey(iTd))) {
      try
      {
        paramMap = (String)this.iTj.get(iSW);
        long l1 = ((Long)this.iTj.get(iSX)).longValue();
        List localList = (List)this.iTj.get(iTc);
        int i = ((Integer)this.iTj.get(iTb)).intValue();
        String str1 = (String)this.iTj.get(iTa);
        long l2 = ((Long)this.iTj.get(iTd)).longValue();
        String str2 = (String)this.iTj.get(iTe);
        String str3 = (String)this.iTj.get(iTf);
        String str4 = (String)this.iTj.get(iTg);
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.kernel.g.ajB().gAO.a(new com.tencent.mm.plugin.aa.model.cgi.g(paramMap, l1, localList, i, str1, l2, str2, str3, str4), 0);
        i = localList.size();
        if ((i > 0) && (i <= 10)) {
          i = 17;
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(407L, i, 1L, false);
          this.iSR.fNZ();
          AppMethodBeat.o(63364);
          return true;
          if ((i > 10) && (i <= 20)) {
            i = 18;
          } else if ((i > 20) && (i <= 50)) {
            i = 19;
          } else {
            i = 20;
          }
        }
        this.iSR.ee(Boolean.FALSE);
      }
      catch (Exception paramMap)
      {
        ad.e("MicroMsg.LaunchAALogic", "launchAAByPerson error: %s", new Object[] { paramMap.getMessage() });
      }
    }
    this.iTi = false;
    AppMethodBeat.o(63364);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.l
 * JD-Core Version:    0.7.0.1
 */