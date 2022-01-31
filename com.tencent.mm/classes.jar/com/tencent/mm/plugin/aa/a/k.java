package com.tencent.mm.plugin.aa.a;

import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.protocal.c.i;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.List;
import java.util.Map;

public final class k
  implements com.tencent.mm.ah.f
{
  public static String eWc = "title";
  public static String eWd = "totalPayAmount";
  public static String eWe = "totalUserNumber";
  public static String eWf = "perAmount";
  public static String eWg = "chatRoomName";
  public static String eWh = "launchScene";
  public static String eWi = "payerlist";
  public static String eWj = "timestamp";
  private static int eWk = 131100026;
  private boolean eWl = false;
  private Map<String, Object> eWm;
  private com.tencent.mm.vending.g.b ecA;
  private int mode = 0;
  
  public final boolean c(int paramInt, Map<String, Object> paramMap)
  {
    this.ecA = com.tencent.mm.vending.g.f.cKX();
    if (this.eWl)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.LaunchAALogic", "launchAA, isLaunching!!! ignore it");
      this.ecA.cg(Boolean.valueOf(false));
      return false;
    }
    if ((paramMap == null) || (paramMap.size() == 0))
    {
      this.ecA.cg(Boolean.valueOf(false));
      return false;
    }
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.LaunchAALogic", "launchAAByMoney, data.keySet: %s", new Object[] { paramMap.keySet() });
    this.eWl = true;
    this.eWm = paramMap;
    this.mode = paramInt;
    long l1;
    Object localObject;
    long l2;
    if (paramInt == a.eVg)
    {
      if ((this.eWm.containsKey(eWc)) && (this.eWm.containsKey(eWf)) && (this.eWm.containsKey(eWe)) && (this.eWm.containsKey(eWh)) && (this.eWm.containsKey(eWg)) && (this.eWm.containsKey(eWj))) {
        try
        {
          paramMap = (String)this.eWm.get(eWc);
          l1 = ((Long)this.eWm.get(eWf)).longValue();
          paramInt = ((Integer)this.eWm.get(eWe)).intValue();
          int i = ((Integer)this.eWm.get(eWh)).intValue();
          localObject = (String)this.eWm.get(eWg);
          l2 = ((Long)this.eWm.get(eWj)).longValue();
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.LaunchAALogic", "launchAAByMoney");
          com.tencent.mm.kernel.g.DQ();
          com.tencent.mm.kernel.g.DO().dJT.a(new com.tencent.mm.plugin.aa.a.a.f(l1, paramMap, paramInt, i, l2, (String)localObject), 0);
          if ((paramInt > 0) && (paramInt <= 10)) {
            paramInt = 13;
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.nFQ.a(407L, paramInt, 1L, false);
            this.ecA.cKW();
            return true;
            if ((paramInt > 10) && (paramInt <= 20)) {
              paramInt = 14;
            } else if ((paramInt > 20) && (paramInt <= 50)) {
              paramInt = 15;
            } else {
              paramInt = 16;
            }
          }
          this.ecA.cg(Boolean.valueOf(false));
        }
        catch (Exception paramMap)
        {
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.LaunchAALogic", "launchAAByMoney, without specific user error: %s", new Object[] { paramMap.getMessage() });
          this.ecA.cg(Boolean.valueOf(false));
          this.eWl = false;
          return false;
        }
      }
      this.eWl = false;
      return false;
    }
    if (paramInt == a.eVh)
    {
      if ((this.eWm.containsKey(eWc)) && (this.eWm.containsKey(eWf)) && (this.eWm.containsKey(eWi)) && (this.eWm.containsKey(eWh)) && (this.eWm.containsKey(eWg)) && (this.eWm.containsKey(eWj))) {
        try
        {
          paramMap = (String)this.eWm.get(eWc);
          l1 = ((Long)this.eWm.get(eWf)).longValue();
          localObject = (List)this.eWm.get(eWi);
          paramInt = ((Integer)this.eWm.get(eWh)).intValue();
          String str = (String)this.eWm.get(eWg);
          l2 = ((Long)this.eWm.get(eWj)).longValue();
          com.tencent.mm.kernel.g.DQ();
          com.tencent.mm.kernel.g.DO().dJT.a(new com.tencent.mm.plugin.aa.a.a.f(l1, paramMap, (List)localObject, paramInt, l2, str), 0);
          paramInt = ((List)localObject).size();
          if ((paramInt > 0) && (paramInt <= 10)) {
            paramInt = 13;
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.nFQ.a(407L, paramInt, 1L, false);
            this.ecA.cKW();
            return true;
            if ((paramInt > 10) && (paramInt <= 20)) {
              paramInt = 14;
            } else if ((paramInt > 20) && (paramInt <= 50)) {
              paramInt = 15;
            } else {
              paramInt = 16;
            }
          }
          this.ecA.cg(Boolean.valueOf(false));
        }
        catch (Exception paramMap)
        {
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.LaunchAALogic", "launchAAByMoney, specific user error: %", new Object[] { paramMap.getMessage() });
          this.ecA.cg(Boolean.valueOf(false));
          this.eWl = false;
          return false;
        }
      }
      this.eWl = false;
      return false;
    }
    return false;
  }
  
  public final boolean n(Map<String, Object> paramMap)
  {
    this.ecA = com.tencent.mm.vending.g.f.cKX();
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.LaunchAALogic", "launchAAByPerson");
    if (this.eWl)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.LaunchAALogic", "launchAA, isLaunching!!! ignore it");
      this.ecA.cg(Boolean.valueOf(false));
      return false;
    }
    if ((paramMap == null) || (paramMap.size() == 0))
    {
      this.ecA.cg(Boolean.valueOf(false));
      return false;
    }
    this.eWl = true;
    this.eWm = paramMap;
    this.mode = a.eVi;
    if (this.mode != a.eVi)
    {
      this.ecA.cg(Boolean.valueOf(false));
      return false;
    }
    if ((this.eWm.containsKey(eWc)) && (this.eWm.containsKey(eWd)) && (this.eWm.containsKey(eWi)) && (this.eWm.containsKey(eWh)) && (this.eWm.containsKey(eWg)) && (this.eWm.containsKey(eWj))) {
      try
      {
        paramMap = (String)this.eWm.get(eWc);
        long l1 = ((Long)this.eWm.get(eWd)).longValue();
        List localList = (List)this.eWm.get(eWi);
        int i = ((Integer)this.eWm.get(eWh)).intValue();
        String str = (String)this.eWm.get(eWg);
        long l2 = ((Long)this.eWm.get(eWj)).longValue();
        com.tencent.mm.kernel.g.DQ();
        com.tencent.mm.kernel.g.DO().dJT.a(new com.tencent.mm.plugin.aa.a.a.g(paramMap, l1, localList, i, str, l2), 0);
        i = localList.size();
        if ((i > 0) && (i <= 10)) {
          i = 17;
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.nFQ.a(407L, i, 1L, false);
          this.ecA.cKW();
          return true;
          if ((i > 10) && (i <= 20)) {
            i = 18;
          } else if ((i > 20) && (i <= 50)) {
            i = 19;
          } else {
            i = 20;
          }
        }
        this.ecA.cg(Boolean.valueOf(false));
      }
      catch (Exception paramMap)
      {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.LaunchAALogic", "launchAAByPerson error: %s", new Object[] { paramMap.getMessage() });
      }
    }
    this.eWl = false;
    return false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.LaunchAALogic", "onSceneEnd, errType: %s, errCode: %s, scene: %s, mode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramm, Integer.valueOf(this.mode) });
    String str;
    boolean bool;
    if (paramm.getType() == 1624)
    {
      this.eWl = false;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramm = (com.tencent.mm.plugin.aa.a.a.f)paramm;
        paramString = paramm.eWv;
        paramInt1 = paramString.iHq;
        str = paramString.iHr;
        if (paramString.srs == null)
        {
          bool = true;
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.LaunchAALogic", "launchAAByMoney, onSceneEnd, retCode: %s, retmsg: %s, msgXml==null: %s, billNo: %s", new Object[] { Integer.valueOf(paramInt1), str, Boolean.valueOf(bool), paramString.srq });
          if (paramString.iHq != 0) {
            break label242;
          }
          if (paramString.srs == null) {
            break label212;
          }
          h.t(paramString.srq, paramm.chatroomName, paramString.srs);
          com.tencent.mm.vending.g.f.a(this.ecA, new Object[] { Boolean.valueOf(true) });
          h.pt(paramm.chatroomName);
          com.tencent.mm.plugin.report.service.h.nFQ.a(407L, 0L, 1L, false);
        }
      }
    }
    label212:
    label242:
    while (paramm.getType() != 1655)
    {
      for (;;)
      {
        return;
        bool = false;
        continue;
        h.a(paramString.srq, false, 0L);
        com.tencent.mm.vending.g.f.a(this.ecA, new Object[] { Boolean.valueOf(true) });
      }
      if (this.ecA != null)
      {
        if (paramString.iHq <= 0) {
          break label343;
        }
        paramm = paramString.sry;
        if ((paramm == null) || (paramm.ssk <= 0)) {
          break label301;
        }
        this.ecA.cg(paramm);
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.a(407L, 2L, 1L, false);
        return;
        if (!bk.bl(paramString.iHr))
        {
          this.ecA.cg(paramString.iHr);
        }
        else
        {
          this.ecA.cg(Boolean.valueOf(false));
          continue;
          this.ecA.cg(Boolean.valueOf(false));
        }
      }
      if (this.ecA != null) {
        this.ecA.cg(Boolean.valueOf(false));
      }
      com.tencent.mm.plugin.report.service.h.nFQ.a(407L, 1L, 1L, false);
      return;
    }
    label301:
    label343:
    this.eWl = false;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramm = (com.tencent.mm.plugin.aa.a.a.g)paramm;
      paramString = paramm.eWx;
      paramInt1 = paramString.iHq;
      str = paramString.iHr;
      if (paramString.srs == null)
      {
        bool = true;
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.LaunchAALogic", "launchAAByPerson, onSceneEnd, retCode: %s, retmsg: %s, msgxml==null: %s", new Object[] { Integer.valueOf(paramInt1), str, Boolean.valueOf(bool) });
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.LaunchAALogic", "launchAAByPerson, onSceneEnd, retMsg: %s, billNo: %s", new Object[] { paramString.iHr, paramString.srq });
        if (paramString.iHq != 0) {
          break label629;
        }
        if (paramString.srs == null) {
          break label592;
        }
        h.t(paramString.srq, paramm.chatroomName, paramString.srs);
        com.tencent.mm.vending.g.f.a(this.ecA, new Object[] { Boolean.valueOf(true), paramString.srq });
      }
      for (;;)
      {
        h.pt(paramm.chatroomName);
        com.tencent.mm.plugin.report.service.h.nFQ.a(407L, 3L, 1L, false);
        return;
        bool = false;
        break;
        label592:
        h.a(paramString.srq, false, 0L);
        com.tencent.mm.vending.g.f.a(this.ecA, new Object[] { Boolean.valueOf(true), paramString.srq });
      }
      label629:
      if (paramString.iHq > 0)
      {
        paramm = paramString.sry;
        if ((paramm != null) && (paramm.ssk > 0)) {
          this.ecA.cg(paramm);
        }
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.a(407L, 5L, 1L, false);
        return;
        if (!bk.bl(paramString.iHr))
        {
          this.ecA.cg(paramString.iHr);
        }
        else
        {
          this.ecA.cg(Boolean.valueOf(false));
          continue;
          this.ecA.cg(Boolean.valueOf(false));
        }
      }
    }
    if (this.ecA != null) {
      this.ecA.cg(Boolean.valueOf(false));
    }
    com.tencent.mm.plugin.report.service.h.nFQ.a(407L, 4L, 1L, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.a.k
 * JD-Core Version:    0.7.0.1
 */