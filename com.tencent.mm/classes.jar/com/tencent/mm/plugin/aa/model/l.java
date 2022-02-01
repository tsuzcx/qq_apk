package com.tencent.mm.plugin.aa.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.protocal.protobuf.z;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.List;
import java.util.Map;

public final class l
  implements com.tencent.mm.ak.f
{
  public static String iVP = "title";
  public static String iVQ = "totalPayAmount";
  public static String iVR = "totalUserNumber";
  public static String iVS = "perAmount";
  public static String iVT = "chatRoomName";
  public static String iVU = "launchScene";
  public static String iVV = "payerlist";
  public static String iVW = "timestamp";
  public static String iVX = "pic_cdn_url";
  public static String iVY = "pic_cdn_thumb_url";
  public static String iVZ = "pf_order_no";
  private static int iWa = 131100026;
  private com.tencent.mm.vending.g.b iVK;
  private boolean iWb = false;
  private Map<String, Object> iWc;
  private int mode = 0;
  
  public final boolean D(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(63364);
    this.iVK = com.tencent.mm.vending.g.g.fSv();
    ae.i("MicroMsg.LaunchAALogic", "launchAAByPerson");
    if (this.iWb)
    {
      ae.e("MicroMsg.LaunchAALogic", "launchAA, isLaunching!!! ignore it");
      this.iVK.ef(Boolean.FALSE);
      AppMethodBeat.o(63364);
      return false;
    }
    if ((paramMap == null) || (paramMap.size() == 0))
    {
      this.iVK.ef(Boolean.FALSE);
      AppMethodBeat.o(63364);
      return false;
    }
    this.iWb = true;
    this.iWc = paramMap;
    this.mode = a.iUQ;
    if (this.mode != a.iUQ)
    {
      this.iVK.ef(Boolean.FALSE);
      AppMethodBeat.o(63364);
      return false;
    }
    if ((this.iWc.containsKey(iVP)) && (this.iWc.containsKey(iVQ)) && (this.iWc.containsKey(iVV)) && (this.iWc.containsKey(iVU)) && (this.iWc.containsKey(iVT)) && (this.iWc.containsKey(iVW))) {
      try
      {
        paramMap = (String)this.iWc.get(iVP);
        long l1 = ((Long)this.iWc.get(iVQ)).longValue();
        List localList = (List)this.iWc.get(iVV);
        int i = ((Integer)this.iWc.get(iVU)).intValue();
        String str1 = (String)this.iWc.get(iVT);
        long l2 = ((Long)this.iWc.get(iVW)).longValue();
        String str2 = (String)this.iWc.get(iVX);
        String str3 = (String)this.iWc.get(iVY);
        String str4 = (String)this.iWc.get(iVZ);
        com.tencent.mm.kernel.g.ajS();
        com.tencent.mm.kernel.g.ajQ().gDv.a(new com.tencent.mm.plugin.aa.model.cgi.g(paramMap, l1, localList, i, str1, l2, str2, str3, str4), 0);
        i = localList.size();
        if ((i > 0) && (i <= 10)) {
          i = 17;
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(407L, i, 1L, false);
          this.iVK.fSu();
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
        this.iVK.ef(Boolean.FALSE);
      }
      catch (Exception paramMap)
      {
        ae.e("MicroMsg.LaunchAALogic", "launchAAByPerson error: %s", new Object[] { paramMap.getMessage() });
      }
    }
    this.iWb = false;
    AppMethodBeat.o(63364);
    return false;
  }
  
  public final boolean c(int paramInt, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(63363);
    this.iVK = com.tencent.mm.vending.g.g.fSv();
    if (this.iWb)
    {
      ae.e("MicroMsg.LaunchAALogic", "launchAA, isLaunching!!! ignore it");
      this.iVK.ef(Boolean.FALSE);
      AppMethodBeat.o(63363);
      return false;
    }
    if ((paramMap == null) || (paramMap.size() == 0))
    {
      this.iVK.ef(Boolean.FALSE);
      AppMethodBeat.o(63363);
      return false;
    }
    ae.i("MicroMsg.LaunchAALogic", "launchAAByMoney, data.keySet: %s", new Object[] { paramMap.keySet() });
    this.iWb = true;
    this.iWc = paramMap;
    this.mode = paramInt;
    long l1;
    Object localObject;
    long l2;
    if (paramInt == a.iUO)
    {
      if ((this.iWc.containsKey(iVP)) && (this.iWc.containsKey(iVS)) && (this.iWc.containsKey(iVR)) && (this.iWc.containsKey(iVU)) && (this.iWc.containsKey(iVT)) && (this.iWc.containsKey(iVW))) {
        try
        {
          paramMap = (String)this.iWc.get(iVP);
          l1 = ((Long)this.iWc.get(iVS)).longValue();
          paramInt = ((Integer)this.iWc.get(iVR)).intValue();
          int i = ((Integer)this.iWc.get(iVU)).intValue();
          localObject = (String)this.iWc.get(iVT);
          l2 = ((Long)this.iWc.get(iVW)).longValue();
          ae.i("MicroMsg.LaunchAALogic", "launchAAByMoney");
          com.tencent.mm.kernel.g.ajS();
          com.tencent.mm.kernel.g.ajQ().gDv.a(new com.tencent.mm.plugin.aa.model.cgi.f(l1, paramMap, paramInt, i, l2, (String)localObject), 0);
          if ((paramInt > 0) && (paramInt <= 10)) {
            paramInt = 13;
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(407L, paramInt, 1L, false);
            this.iVK.fSu();
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
          this.iVK.ef(Boolean.FALSE);
        }
        catch (Exception paramMap)
        {
          ae.e("MicroMsg.LaunchAALogic", "launchAAByMoney, without specific user error: %s", new Object[] { paramMap.getMessage() });
          this.iVK.ef(Boolean.FALSE);
          this.iWb = false;
          AppMethodBeat.o(63363);
          return false;
        }
      }
      this.iWb = false;
      AppMethodBeat.o(63363);
      return false;
    }
    if (paramInt == a.iUP)
    {
      if ((this.iWc.containsKey(iVP)) && (this.iWc.containsKey(iVS)) && (this.iWc.containsKey(iVV)) && (this.iWc.containsKey(iVU)) && (this.iWc.containsKey(iVT)) && (this.iWc.containsKey(iVW))) {
        try
        {
          paramMap = (String)this.iWc.get(iVP);
          l1 = ((Long)this.iWc.get(iVS)).longValue();
          localObject = (List)this.iWc.get(iVV);
          paramInt = ((Integer)this.iWc.get(iVU)).intValue();
          String str1 = (String)this.iWc.get(iVT);
          l2 = ((Long)this.iWc.get(iVW)).longValue();
          String str2 = (String)this.iWc.get(iVX);
          String str3 = (String)this.iWc.get(iVY);
          String str4 = (String)this.iWc.get(iVZ);
          com.tencent.mm.kernel.g.ajS();
          com.tencent.mm.kernel.g.ajQ().gDv.a(new com.tencent.mm.plugin.aa.model.cgi.f(l1, paramMap, (List)localObject, paramInt, l2, str1, str2, str3, str4), 0);
          paramInt = ((List)localObject).size();
          if ((paramInt > 0) && (paramInt <= 10)) {
            paramInt = 13;
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(407L, paramInt, 1L, false);
            this.iVK.fSu();
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
          this.iVK.ef(Boolean.FALSE);
        }
        catch (Exception paramMap)
        {
          ae.e("MicroMsg.LaunchAALogic", "launchAAByMoney, specific user error: %", new Object[] { paramMap.getMessage() });
          this.iVK.ef(Boolean.FALSE);
          this.iWb = false;
          AppMethodBeat.o(63363);
          return false;
        }
      }
      this.iWb = false;
      AppMethodBeat.o(63363);
      return false;
    }
    AppMethodBeat.o(63363);
    return false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(63365);
    ae.d("MicroMsg.LaunchAALogic", "onSceneEnd, errType: %s, errCode: %s, scene: %s, mode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramn, Integer.valueOf(this.mode) });
    String str;
    boolean bool;
    if (paramn.getType() == 1624)
    {
      this.iWb = false;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramn = (com.tencent.mm.plugin.aa.model.cgi.f)paramn;
        paramString = paramn.iWk;
        paramInt1 = paramString.dmy;
        str = paramString.phe;
        if (paramString.FIg == null)
        {
          bool = true;
          ae.i("MicroMsg.LaunchAALogic", "launchAAByMoney, onSceneEnd, retCode: %s, retmsg: %s, msgXml==null: %s, billNo: %s", new Object[] { Integer.valueOf(paramInt1), str, Boolean.valueOf(bool), paramString.FIe });
          if (paramString.dmy != 0) {
            break label253;
          }
          if (paramString.FIg == null) {
            break label224;
          }
          i.u(paramString.FIe, paramn.chatroomName, paramString.FIg);
          com.tencent.mm.vending.g.g.a(this.iVK, new Object[] { Boolean.TRUE });
        }
        for (;;)
        {
          i.JD(paramn.chatroomName);
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(407L, 0L, 1L, false);
          AppMethodBeat.o(63365);
          return;
          bool = false;
          break;
          label224:
          i.a(paramString.FIe, false, 0L);
          com.tencent.mm.vending.g.g.a(this.iVK, new Object[] { Boolean.TRUE });
        }
        label253:
        if (this.iVK != null)
        {
          if (paramString.dmy <= 0) {
            break label445;
          }
          paramn = paramString.FIp;
          if ((paramn == null) || (paramn.FIU <= 0)) {
            break label318;
          }
          this.iVK.ef(paramn);
        }
        label445:
        for (;;)
        {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(407L, 2L, 1L, false);
          AppMethodBeat.o(63365);
          return;
          label318:
          if ((paramString.FIq != null) && (paramString.FIq.dEu == 1) && (!bu.isNullOrNil(paramString.FIq.phk)) && (!bu.isNullOrNil(paramString.FIq.kCZ)) && (!bu.isNullOrNil(paramString.FIq.kDa)) && (!bu.isNullOrNil(paramString.FIq.dyI)))
          {
            this.iVK.ef(paramString.FIq);
          }
          else if (!bu.isNullOrNil(paramString.phe))
          {
            this.iVK.ef(paramString.phe);
          }
          else
          {
            this.iVK.ef(Boolean.FALSE);
            continue;
            this.iVK.ef(Boolean.FALSE);
          }
        }
      }
      if (this.iVK != null) {
        this.iVK.ef(Boolean.FALSE);
      }
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(407L, 1L, 1L, false);
      AppMethodBeat.o(63365);
      return;
    }
    if (paramn.getType() == 1655)
    {
      this.iWb = false;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramn = (com.tencent.mm.plugin.aa.model.cgi.g)paramn;
        paramString = paramn.iWm;
        paramInt1 = paramString.dmy;
        str = paramString.phe;
        if (paramString.FIg == null)
        {
          bool = true;
          ae.i("MicroMsg.LaunchAALogic", "launchAAByPerson, onSceneEnd, retCode: %s, retmsg: %s, msgxml==null: %s", new Object[] { Integer.valueOf(paramInt1), str, Boolean.valueOf(bool) });
          ae.d("MicroMsg.LaunchAALogic", "launchAAByPerson, onSceneEnd, retMsg: %s, billNo: %s", new Object[] { paramString.phe, paramString.FIe });
          if (paramString.dmy != 0) {
            break label739;
          }
          if (paramString.FIg == null) {
            break label703;
          }
          i.u(paramString.FIe, paramn.chatroomName, paramString.FIg);
          com.tencent.mm.vending.g.g.a(this.iVK, new Object[] { Boolean.TRUE, paramString.FIe });
        }
        for (;;)
        {
          i.JD(paramn.chatroomName);
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(407L, 3L, 1L, false);
          AppMethodBeat.o(63365);
          return;
          bool = false;
          break;
          label703:
          i.a(paramString.FIe, false, 0L);
          com.tencent.mm.vending.g.g.a(this.iVK, new Object[] { Boolean.TRUE, paramString.FIe });
        }
        label739:
        if (paramString.dmy > 0)
        {
          paramn = paramString.FIp;
          if ((paramn != null) && (paramn.FIU > 0)) {
            this.iVK.ef(paramn);
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(407L, 5L, 1L, false);
          AppMethodBeat.o(63365);
          return;
          if ((paramString.FIq != null) && (paramString.FIq.dEu == 1) && (!bu.isNullOrNil(paramString.FIq.phk)) && (!bu.isNullOrNil(paramString.FIq.kCZ)) && (!bu.isNullOrNil(paramString.FIq.kDa)) && (!bu.isNullOrNil(paramString.FIq.dyI)))
          {
            this.iVK.ef(paramString.FIq);
          }
          else if (!bu.isNullOrNil(paramString.phe))
          {
            this.iVK.ef(paramString.phe);
          }
          else
          {
            this.iVK.ef(Boolean.FALSE);
            continue;
            this.iVK.ef(Boolean.FALSE);
          }
        }
      }
      if (this.iVK != null) {
        this.iVK.ef(Boolean.FALSE);
      }
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(407L, 4L, 1L, false);
    }
    AppMethodBeat.o(63365);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.l
 * JD-Core Version:    0.7.0.1
 */