package com.tencent.mm.plugin.aa.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.plugin.aa.model.cgi.f;
import com.tencent.mm.protocal.protobuf.ab;
import com.tencent.mm.protocal.protobuf.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;
import java.util.Map;

public final class l
  implements com.tencent.mm.ak.i
{
  public static String jSJ = "title";
  public static String jSK = "totalPayAmount";
  public static String jSL = "totalUserNumber";
  public static String jSM = "perAmount";
  public static String jSN = "chatRoomName";
  public static String jSO = "launchScene";
  public static String jSP = "payerlist";
  public static String jSQ = "timestamp";
  public static String jSR = "pic_cdn_url";
  public static String jSS = "pic_cdn_thumb_url";
  public static String jST = "pf_order_no";
  private static int jSU = 131100026;
  private com.tencent.mm.vending.g.b jSE;
  private boolean jSV = false;
  private Map<String, Object> jSW;
  private int mode = 0;
  
  public final boolean F(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(63364);
    this.jSE = com.tencent.mm.vending.g.g.hdx();
    Log.i("MicroMsg.LaunchAALogic", "launchAAByPerson");
    if (this.jSV)
    {
      Log.e("MicroMsg.LaunchAALogic", "launchAA, isLaunching!!! ignore it");
      this.jSE.ej(Boolean.FALSE);
      AppMethodBeat.o(63364);
      return false;
    }
    if ((paramMap == null) || (paramMap.size() == 0))
    {
      this.jSE.ej(Boolean.FALSE);
      AppMethodBeat.o(63364);
      return false;
    }
    this.jSV = true;
    this.jSW = paramMap;
    this.mode = a.jRK;
    if (this.mode != a.jRK)
    {
      this.jSE.ej(Boolean.FALSE);
      AppMethodBeat.o(63364);
      return false;
    }
    if ((this.jSW.containsKey(jSJ)) && (this.jSW.containsKey(jSK)) && (this.jSW.containsKey(jSP)) && (this.jSW.containsKey(jSO)) && (this.jSW.containsKey(jSN)) && (this.jSW.containsKey(jSQ))) {
      try
      {
        paramMap = (String)this.jSW.get(jSJ);
        long l1 = ((Long)this.jSW.get(jSK)).longValue();
        List localList = (List)this.jSW.get(jSP);
        int i = ((Integer)this.jSW.get(jSO)).intValue();
        String str1 = (String)this.jSW.get(jSN);
        long l2 = ((Long)this.jSW.get(jSQ)).longValue();
        String str2 = (String)this.jSW.get(jSR);
        String str3 = (String)this.jSW.get(jSS);
        String str4 = (String)this.jSW.get(jST);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.a(new com.tencent.mm.plugin.aa.model.cgi.g(paramMap, l1, localList, i, str1, l2, str2, str3, str4), 0);
        i = localList.size();
        if ((i > 0) && (i <= 10)) {
          i = 17;
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(407L, i, 1L, false);
          this.jSE.hdw();
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
        this.jSE.ej(Boolean.FALSE);
      }
      catch (Exception paramMap)
      {
        Log.e("MicroMsg.LaunchAALogic", "launchAAByPerson error: %s", new Object[] { paramMap.getMessage() });
      }
    }
    this.jSV = false;
    AppMethodBeat.o(63364);
    return false;
  }
  
  public final boolean G(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(212943);
    this.jSE = com.tencent.mm.vending.g.g.hdx();
    Log.i("MicroMsg.LaunchAALogic", "launchAAByPersonCustomize");
    if (this.jSV)
    {
      Log.e("MicroMsg.LaunchAALogic", "launchAA, isLaunching!!! ignore it");
      this.jSE.ej(Boolean.FALSE);
      AppMethodBeat.o(212943);
      return false;
    }
    if ((paramMap == null) || (paramMap.size() == 0))
    {
      this.jSE.ej(Boolean.FALSE);
      AppMethodBeat.o(212943);
      return false;
    }
    this.jSV = true;
    this.jSW = paramMap;
    this.mode = a.jRK;
    if (this.mode != a.jRK)
    {
      this.jSE.ej(Boolean.FALSE);
      AppMethodBeat.o(212943);
      return false;
    }
    if ((this.jSW.containsKey(jSJ)) && (this.jSW.containsKey(jSO)) && (this.jSW.containsKey(jSN)) && (this.jSW.containsKey(jSQ))) {
      try
      {
        paramMap = (String)this.jSW.get(jSJ);
        int i = ((Integer)this.jSW.get(jSO)).intValue();
        String str1 = (String)this.jSW.get(jSN);
        long l = ((Long)this.jSW.get(jSQ)).longValue();
        String str2 = (String)this.jSW.get(jSR);
        String str3 = (String)this.jSW.get(jSS);
        String str4 = (String)this.jSW.get(jST);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.a(new com.tencent.mm.plugin.aa.model.cgi.h(paramMap, i, str1, l, str2, str3, str4), 0);
        this.jSE.hdw();
        AppMethodBeat.o(212943);
        return true;
      }
      catch (Exception paramMap)
      {
        Log.e("MicroMsg.LaunchAALogic", "launchAAByPersonCustomize error: %s", new Object[] { paramMap.getMessage() });
        this.jSE.ej(Boolean.FALSE);
        this.jSV = false;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(212943);
      return false;
      Log.i("MicroMsg.LaunchAALogic", "launchAAByPersonCustomize interrupt");
      this.jSE.ej(Boolean.FALSE);
      this.jSV = false;
    }
  }
  
  public final boolean d(int paramInt, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(63363);
    this.jSE = com.tencent.mm.vending.g.g.hdx();
    if (this.jSV)
    {
      Log.e("MicroMsg.LaunchAALogic", "launchAA, isLaunching!!! ignore it");
      this.jSE.ej(Boolean.FALSE);
      AppMethodBeat.o(63363);
      return false;
    }
    if ((paramMap == null) || (paramMap.size() == 0))
    {
      this.jSE.ej(Boolean.FALSE);
      AppMethodBeat.o(63363);
      return false;
    }
    Log.i("MicroMsg.LaunchAALogic", "launchAAByMoney, data.keySet: %s", new Object[] { paramMap.keySet() });
    this.jSV = true;
    this.jSW = paramMap;
    this.mode = paramInt;
    long l1;
    Object localObject;
    long l2;
    if (paramInt == a.jRI)
    {
      if ((this.jSW.containsKey(jSJ)) && (this.jSW.containsKey(jSM)) && (this.jSW.containsKey(jSL)) && (this.jSW.containsKey(jSO)) && (this.jSW.containsKey(jSN)) && (this.jSW.containsKey(jSQ))) {
        try
        {
          paramMap = (String)this.jSW.get(jSJ);
          l1 = ((Long)this.jSW.get(jSM)).longValue();
          paramInt = ((Integer)this.jSW.get(jSL)).intValue();
          int i = ((Integer)this.jSW.get(jSO)).intValue();
          localObject = (String)this.jSW.get(jSN);
          l2 = ((Long)this.jSW.get(jSQ)).longValue();
          Log.i("MicroMsg.LaunchAALogic", "launchAAByMoney");
          com.tencent.mm.kernel.g.aAi();
          com.tencent.mm.kernel.g.aAg().hqi.a(new f(l1, paramMap, paramInt, i, l2, (String)localObject), 0);
          if ((paramInt > 0) && (paramInt <= 10)) {
            paramInt = 13;
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(407L, paramInt, 1L, false);
            this.jSE.hdw();
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
          this.jSE.ej(Boolean.FALSE);
        }
        catch (Exception paramMap)
        {
          Log.e("MicroMsg.LaunchAALogic", "launchAAByMoney, without specific user error: %s", new Object[] { paramMap.getMessage() });
          this.jSE.ej(Boolean.FALSE);
          this.jSV = false;
          AppMethodBeat.o(63363);
          return false;
        }
      }
      this.jSV = false;
      AppMethodBeat.o(63363);
      return false;
    }
    if (paramInt == a.jRJ)
    {
      if ((this.jSW.containsKey(jSJ)) && (this.jSW.containsKey(jSM)) && (this.jSW.containsKey(jSP)) && (this.jSW.containsKey(jSO)) && (this.jSW.containsKey(jSN)) && (this.jSW.containsKey(jSQ))) {
        try
        {
          paramMap = (String)this.jSW.get(jSJ);
          l1 = ((Long)this.jSW.get(jSM)).longValue();
          localObject = (List)this.jSW.get(jSP);
          paramInt = ((Integer)this.jSW.get(jSO)).intValue();
          String str1 = (String)this.jSW.get(jSN);
          l2 = ((Long)this.jSW.get(jSQ)).longValue();
          String str2 = (String)this.jSW.get(jSR);
          String str3 = (String)this.jSW.get(jSS);
          String str4 = (String)this.jSW.get(jST);
          com.tencent.mm.kernel.g.aAi();
          com.tencent.mm.kernel.g.aAg().hqi.a(new f(l1, paramMap, (List)localObject, paramInt, l2, str1, str2, str3, str4), 0);
          paramInt = ((List)localObject).size();
          if ((paramInt > 0) && (paramInt <= 10)) {
            paramInt = 13;
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(407L, paramInt, 1L, false);
            this.jSE.hdw();
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
          this.jSE.ej(Boolean.FALSE);
        }
        catch (Exception paramMap)
        {
          Log.e("MicroMsg.LaunchAALogic", "launchAAByMoney, specific user error: %", new Object[] { paramMap.getMessage() });
          this.jSE.ej(Boolean.FALSE);
          this.jSV = false;
          AppMethodBeat.o(63363);
          return false;
        }
      }
      this.jSV = false;
      AppMethodBeat.o(63363);
      return false;
    }
    AppMethodBeat.o(63363);
    return false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(63365);
    Log.i("MicroMsg.LaunchAALogic", "onSceneEnd, errType: %s, errCode: %s, scene: %s, mode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramq, Integer.valueOf(this.mode) });
    String str;
    boolean bool;
    if (paramq.getType() == 1624)
    {
      this.jSV = false;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramq = (f)paramq;
        paramString = paramq.jTf;
        paramInt1 = paramString.dDN;
        str = paramString.qwn;
        if (paramString.KBu == null)
        {
          bool = true;
          Log.i("MicroMsg.LaunchAALogic", "launchAAByMoney, onSceneEnd, retCode: %s, retmsg: %s, msgXml==null: %s, billNo: %s", new Object[] { Integer.valueOf(paramInt1), str, Boolean.valueOf(bool), paramString.KBs });
          if (paramString.dDN != 0) {
            break label253;
          }
          if (paramString.KBu == null) {
            break label224;
          }
          i.u(paramString.KBs, paramq.chatroomName, paramString.KBu);
          com.tencent.mm.vending.g.g.a(this.jSE, new Object[] { Boolean.TRUE });
        }
        for (;;)
        {
          i.SB(paramq.chatroomName);
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(407L, 0L, 1L, false);
          AppMethodBeat.o(63365);
          return;
          bool = false;
          break;
          label224:
          i.a(paramString.KBs, false, 0L);
          com.tencent.mm.vending.g.g.a(this.jSE, new Object[] { Boolean.TRUE });
        }
        label253:
        if (this.jSE != null)
        {
          if (paramString.dDN <= 0) {
            break label445;
          }
          paramq = paramString.KBD;
          if ((paramq == null) || (paramq.KCl <= 0)) {
            break label318;
          }
          this.jSE.ej(paramq);
        }
        label445:
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(407L, 2L, 1L, false);
          AppMethodBeat.o(63365);
          return;
          label318:
          if ((paramString.KBE != null) && (paramString.KBE.cSx == 1) && (!Util.isNullOrNil(paramString.KBE.qwt)) && (!Util.isNullOrNil(paramString.KBE.lHA)) && (!Util.isNullOrNil(paramString.KBE.lHB)) && (!Util.isNullOrNil(paramString.KBE.dQx)))
          {
            this.jSE.ej(paramString.KBE);
          }
          else if (!Util.isNullOrNil(paramString.qwn))
          {
            this.jSE.ej(paramString.qwn);
          }
          else
          {
            this.jSE.ej(Boolean.FALSE);
            continue;
            this.jSE.ej(Boolean.FALSE);
          }
        }
      }
      if (this.jSE != null) {
        this.jSE.ej(Boolean.FALSE);
      }
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(407L, 1L, 1L, false);
      AppMethodBeat.o(63365);
      return;
    }
    if (paramq.getType() == 1655)
    {
      this.jSV = false;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramq = (com.tencent.mm.plugin.aa.model.cgi.g)paramq;
        paramString = paramq.jTh;
        paramInt1 = paramString.dDN;
        str = paramString.qwn;
        if (paramString.KBu == null)
        {
          bool = true;
          Log.i("MicroMsg.LaunchAALogic", "launchAAByPerson, onSceneEnd, retCode: %s, retmsg: %s, msgxml==null: %s", new Object[] { Integer.valueOf(paramInt1), str, Boolean.valueOf(bool) });
          Log.d("MicroMsg.LaunchAALogic", "launchAAByPerson, onSceneEnd, retMsg: %s, billNo: %s", new Object[] { paramString.qwn, paramString.KBs });
          if (paramString.dDN != 0) {
            break label739;
          }
          if (paramString.KBu == null) {
            break label703;
          }
          i.u(paramString.KBs, paramq.chatroomName, paramString.KBu);
          com.tencent.mm.vending.g.g.a(this.jSE, new Object[] { Boolean.TRUE, paramString.KBs });
        }
        for (;;)
        {
          i.SB(paramq.chatroomName);
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(407L, 3L, 1L, false);
          AppMethodBeat.o(63365);
          return;
          bool = false;
          break;
          label703:
          i.a(paramString.KBs, false, 0L);
          com.tencent.mm.vending.g.g.a(this.jSE, new Object[] { Boolean.TRUE, paramString.KBs });
        }
        label739:
        if (paramString.dDN > 0)
        {
          paramq = paramString.KBD;
          if ((paramq != null) && (paramq.KCl > 0)) {
            this.jSE.ej(paramq);
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(407L, 5L, 1L, false);
          AppMethodBeat.o(63365);
          return;
          if ((paramString.KBE != null) && (paramString.KBE.cSx == 1) && (!Util.isNullOrNil(paramString.KBE.qwt)) && (!Util.isNullOrNil(paramString.KBE.lHA)) && (!Util.isNullOrNil(paramString.KBE.lHB)) && (!Util.isNullOrNil(paramString.KBE.dQx)))
          {
            this.jSE.ej(paramString.KBE);
          }
          else if (!Util.isNullOrNil(paramString.qwn))
          {
            this.jSE.ej(paramString.qwn);
          }
          else
          {
            this.jSE.ej(Boolean.FALSE);
            continue;
            this.jSE.ej(Boolean.FALSE);
          }
        }
      }
      if (this.jSE != null) {
        this.jSE.ej(Boolean.FALSE);
      }
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(407L, 4L, 1L, false);
      AppMethodBeat.o(63365);
      return;
    }
    if (paramq.getType() == 2831)
    {
      this.jSV = false;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramq = (com.tencent.mm.plugin.aa.model.cgi.h)paramq;
        paramString = paramq.jTj;
        paramInt1 = paramString.dDN;
        str = paramString.qwn;
        if (paramString.KBu == null)
        {
          bool = true;
          Log.i("MicroMsg.LaunchAALogic", "launchAAByPersonCustomize, onSceneEnd, retCode: %s, retmsg: %s, msgxml==null: %s", new Object[] { Integer.valueOf(paramInt1), str, Boolean.valueOf(bool) });
          Log.i("MicroMsg.LaunchAALogic", "launchAAByPersonCustomize, onSceneEnd, retMsg: %s, billNo: %s", new Object[] { paramString.qwn, paramString.KBs });
          if (paramString.dDN != 0) {
            break label1220;
          }
          if (paramString.KBu == null) {
            break label1184;
          }
          i.u(paramString.KBs, paramq.chatroomName, paramString.KBu);
          com.tencent.mm.vending.g.g.a(this.jSE, new Object[] { Boolean.TRUE, paramString.KBs });
        }
        for (;;)
        {
          i.SB(paramq.chatroomName);
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(407L, 3L, 1L, false);
          AppMethodBeat.o(63365);
          return;
          bool = false;
          break;
          label1184:
          i.a(paramString.KBs, false, 0L);
          com.tencent.mm.vending.g.g.a(this.jSE, new Object[] { Boolean.TRUE, paramString.KBs });
        }
        label1220:
        if (paramString.dDN > 0)
        {
          paramq = paramString.KBD;
          if ((paramq != null) && (paramq.KCl > 0)) {
            this.jSE.ej(paramq);
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(407L, 5L, 1L, false);
          AppMethodBeat.o(63365);
          return;
          if ((paramString.KBE != null) && (paramString.KBE.cSx == 1) && (!Util.isNullOrNil(paramString.KBE.qwt)) && (!Util.isNullOrNil(paramString.KBE.lHA)) && (!Util.isNullOrNil(paramString.KBE.lHB)) && (!Util.isNullOrNil(paramString.KBE.dQx)))
          {
            this.jSE.ej(paramString.KBE);
          }
          else if (!Util.isNullOrNil(paramString.qwn))
          {
            this.jSE.ej(paramString.qwn);
          }
          else
          {
            this.jSE.ej(Boolean.FALSE);
            continue;
            this.jSE.ej(Boolean.FALSE);
          }
        }
      }
      if (this.jSE != null) {
        this.jSE.ej(Boolean.FALSE);
      }
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(407L, 4L, 1L, false);
    }
    AppMethodBeat.o(63365);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.l
 * JD-Core Version:    0.7.0.1
 */