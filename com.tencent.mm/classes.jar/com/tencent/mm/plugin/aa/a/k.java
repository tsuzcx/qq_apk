package com.tencent.mm.plugin.aa.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.protocal.protobuf.i;
import com.tencent.mm.protocal.protobuf.y;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;
import java.util.Map;

public final class k
  implements com.tencent.mm.ai.f
{
  public static String gnZ = "title";
  public static String goa = "totalPayAmount";
  public static String gob = "totalUserNumber";
  public static String goc = "perAmount";
  public static String god = "chatRoomName";
  public static String goe = "launchScene";
  public static String gof = "payerlist";
  public static String gog = "timestamp";
  private static int goh = 131100026;
  private com.tencent.mm.vending.g.b fsR;
  private boolean goi = false;
  private Map<String, Object> goj;
  private int mode = 0;
  
  public final boolean c(int paramInt, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(40632);
    this.fsR = com.tencent.mm.vending.g.f.dQn();
    if (this.goi)
    {
      ab.e("MicroMsg.LaunchAALogic", "launchAA, isLaunching!!! ignore it");
      this.fsR.cK(Boolean.FALSE);
      AppMethodBeat.o(40632);
      return false;
    }
    if ((paramMap == null) || (paramMap.size() == 0))
    {
      this.fsR.cK(Boolean.FALSE);
      AppMethodBeat.o(40632);
      return false;
    }
    ab.i("MicroMsg.LaunchAALogic", "launchAAByMoney, data.keySet: %s", new Object[] { paramMap.keySet() });
    this.goi = true;
    this.goj = paramMap;
    this.mode = paramInt;
    long l1;
    Object localObject;
    long l2;
    if (paramInt == a.gnd)
    {
      if ((this.goj.containsKey(gnZ)) && (this.goj.containsKey(goc)) && (this.goj.containsKey(gob)) && (this.goj.containsKey(goe)) && (this.goj.containsKey(god)) && (this.goj.containsKey(gog))) {
        try
        {
          paramMap = (String)this.goj.get(gnZ);
          l1 = ((Long)this.goj.get(goc)).longValue();
          paramInt = ((Integer)this.goj.get(gob)).intValue();
          int i = ((Integer)this.goj.get(goe)).intValue();
          localObject = (String)this.goj.get(god);
          l2 = ((Long)this.goj.get(gog)).longValue();
          ab.i("MicroMsg.LaunchAALogic", "launchAAByMoney");
          com.tencent.mm.kernel.g.RM();
          com.tencent.mm.kernel.g.RK().eHt.a(new com.tencent.mm.plugin.aa.a.a.f(l1, paramMap, paramInt, i, l2, (String)localObject), 0);
          if ((paramInt > 0) && (paramInt <= 10)) {
            paramInt = 13;
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(407L, paramInt, 1L, false);
            this.fsR.dQm();
            AppMethodBeat.o(40632);
            return true;
            if ((paramInt > 10) && (paramInt <= 20)) {
              paramInt = 14;
            } else if ((paramInt > 20) && (paramInt <= 50)) {
              paramInt = 15;
            } else {
              paramInt = 16;
            }
          }
          this.fsR.cK(Boolean.FALSE);
        }
        catch (Exception paramMap)
        {
          ab.e("MicroMsg.LaunchAALogic", "launchAAByMoney, without specific user error: %s", new Object[] { paramMap.getMessage() });
          this.fsR.cK(Boolean.FALSE);
          this.goi = false;
          AppMethodBeat.o(40632);
          return false;
        }
      }
      this.goi = false;
      AppMethodBeat.o(40632);
      return false;
    }
    if (paramInt == a.gne)
    {
      if ((this.goj.containsKey(gnZ)) && (this.goj.containsKey(goc)) && (this.goj.containsKey(gof)) && (this.goj.containsKey(goe)) && (this.goj.containsKey(god)) && (this.goj.containsKey(gog))) {
        try
        {
          paramMap = (String)this.goj.get(gnZ);
          l1 = ((Long)this.goj.get(goc)).longValue();
          localObject = (List)this.goj.get(gof);
          paramInt = ((Integer)this.goj.get(goe)).intValue();
          String str = (String)this.goj.get(god);
          l2 = ((Long)this.goj.get(gog)).longValue();
          com.tencent.mm.kernel.g.RM();
          com.tencent.mm.kernel.g.RK().eHt.a(new com.tencent.mm.plugin.aa.a.a.f(l1, paramMap, (List)localObject, paramInt, l2, str), 0);
          paramInt = ((List)localObject).size();
          if ((paramInt > 0) && (paramInt <= 10)) {
            paramInt = 13;
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(407L, paramInt, 1L, false);
            this.fsR.dQm();
            AppMethodBeat.o(40632);
            return true;
            if ((paramInt > 10) && (paramInt <= 20)) {
              paramInt = 14;
            } else if ((paramInt > 20) && (paramInt <= 50)) {
              paramInt = 15;
            } else {
              paramInt = 16;
            }
          }
          this.fsR.cK(Boolean.FALSE);
        }
        catch (Exception paramMap)
        {
          ab.e("MicroMsg.LaunchAALogic", "launchAAByMoney, specific user error: %", new Object[] { paramMap.getMessage() });
          this.fsR.cK(Boolean.FALSE);
          this.goi = false;
          AppMethodBeat.o(40632);
          return false;
        }
      }
      this.goi = false;
      AppMethodBeat.o(40632);
      return false;
    }
    AppMethodBeat.o(40632);
    return false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(40634);
    ab.d("MicroMsg.LaunchAALogic", "onSceneEnd, errType: %s, errCode: %s, scene: %s, mode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramm, Integer.valueOf(this.mode) });
    String str;
    boolean bool;
    if (paramm.getType() == 1624)
    {
      this.goi = false;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramm = (com.tencent.mm.plugin.aa.a.a.f)paramm;
        paramString = paramm.got;
        paramInt1 = paramString.cnK;
        str = paramString.kNv;
        if (paramString.wjY == null)
        {
          bool = true;
          ab.i("MicroMsg.LaunchAALogic", "launchAAByMoney, onSceneEnd, retCode: %s, retmsg: %s, msgXml==null: %s, billNo: %s", new Object[] { Integer.valueOf(paramInt1), str, Boolean.valueOf(bool), paramString.wjW });
          if (paramString.cnK != 0) {
            break label250;
          }
          if (paramString.wjY == null) {
            break label221;
          }
          h.w(paramString.wjW, paramm.chatroomName, paramString.wjY);
          com.tencent.mm.vending.g.f.a(this.fsR, new Object[] { Boolean.TRUE });
        }
        for (;;)
        {
          h.wH(paramm.chatroomName);
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(407L, 0L, 1L, false);
          AppMethodBeat.o(40634);
          return;
          bool = false;
          break;
          label221:
          h.a(paramString.wjW, false, 0L);
          com.tencent.mm.vending.g.f.a(this.fsR, new Object[] { Boolean.TRUE });
        }
        label250:
        if (this.fsR != null)
        {
          if (paramString.cnK <= 0) {
            break label355;
          }
          paramm = paramString.wke;
          if ((paramm == null) || (paramm.wkQ <= 0)) {
            break label314;
          }
          this.fsR.cK(paramm);
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(407L, 2L, 1L, false);
          AppMethodBeat.o(40634);
          return;
          label314:
          if (!bo.isNullOrNil(paramString.kNv))
          {
            this.fsR.cK(paramString.kNv);
          }
          else
          {
            this.fsR.cK(Boolean.FALSE);
            continue;
            label355:
            this.fsR.cK(Boolean.FALSE);
          }
        }
      }
      if (this.fsR != null) {
        this.fsR.cK(Boolean.FALSE);
      }
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(407L, 1L, 1L, false);
      AppMethodBeat.o(40634);
      return;
    }
    if (paramm.getType() == 1655)
    {
      this.goi = false;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramm = (com.tencent.mm.plugin.aa.a.a.g)paramm;
        paramString = paramm.gov;
        paramInt1 = paramString.cnK;
        str = paramString.kNv;
        if (paramString.wjY == null)
        {
          bool = true;
          ab.i("MicroMsg.LaunchAALogic", "launchAAByPerson, onSceneEnd, retCode: %s, retmsg: %s, msgxml==null: %s", new Object[] { Integer.valueOf(paramInt1), str, Boolean.valueOf(bool) });
          ab.d("MicroMsg.LaunchAALogic", "launchAAByPerson, onSceneEnd, retMsg: %s, billNo: %s", new Object[] { paramString.kNv, paramString.wjW });
          if (paramString.cnK != 0) {
            break label647;
          }
          if (paramString.wjY == null) {
            break label611;
          }
          h.w(paramString.wjW, paramm.chatroomName, paramString.wjY);
          com.tencent.mm.vending.g.f.a(this.fsR, new Object[] { Boolean.TRUE, paramString.wjW });
        }
        for (;;)
        {
          h.wH(paramm.chatroomName);
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(407L, 3L, 1L, false);
          AppMethodBeat.o(40634);
          return;
          bool = false;
          break;
          label611:
          h.a(paramString.wjW, false, 0L);
          com.tencent.mm.vending.g.f.a(this.fsR, new Object[] { Boolean.TRUE, paramString.wjW });
        }
        label647:
        if (paramString.cnK > 0)
        {
          paramm = paramString.wke;
          if ((paramm != null) && (paramm.wkQ > 0)) {
            this.fsR.cK(paramm);
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(407L, 5L, 1L, false);
          AppMethodBeat.o(40634);
          return;
          if (!bo.isNullOrNil(paramString.kNv))
          {
            this.fsR.cK(paramString.kNv);
          }
          else
          {
            this.fsR.cK(Boolean.FALSE);
            continue;
            this.fsR.cK(Boolean.FALSE);
          }
        }
      }
      if (this.fsR != null) {
        this.fsR.cK(Boolean.FALSE);
      }
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(407L, 4L, 1L, false);
    }
    AppMethodBeat.o(40634);
  }
  
  public final boolean s(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(40633);
    this.fsR = com.tencent.mm.vending.g.f.dQn();
    ab.i("MicroMsg.LaunchAALogic", "launchAAByPerson");
    if (this.goi)
    {
      ab.e("MicroMsg.LaunchAALogic", "launchAA, isLaunching!!! ignore it");
      this.fsR.cK(Boolean.FALSE);
      AppMethodBeat.o(40633);
      return false;
    }
    if ((paramMap == null) || (paramMap.size() == 0))
    {
      this.fsR.cK(Boolean.FALSE);
      AppMethodBeat.o(40633);
      return false;
    }
    this.goi = true;
    this.goj = paramMap;
    this.mode = a.gnf;
    if (this.mode != a.gnf)
    {
      this.fsR.cK(Boolean.FALSE);
      AppMethodBeat.o(40633);
      return false;
    }
    if ((this.goj.containsKey(gnZ)) && (this.goj.containsKey(goa)) && (this.goj.containsKey(gof)) && (this.goj.containsKey(goe)) && (this.goj.containsKey(god)) && (this.goj.containsKey(gog))) {
      try
      {
        paramMap = (String)this.goj.get(gnZ);
        long l1 = ((Long)this.goj.get(goa)).longValue();
        List localList = (List)this.goj.get(gof);
        int i = ((Integer)this.goj.get(goe)).intValue();
        String str = (String)this.goj.get(god);
        long l2 = ((Long)this.goj.get(gog)).longValue();
        com.tencent.mm.kernel.g.RM();
        com.tencent.mm.kernel.g.RK().eHt.a(new com.tencent.mm.plugin.aa.a.a.g(paramMap, l1, localList, i, str, l2), 0);
        i = localList.size();
        if ((i > 0) && (i <= 10)) {
          i = 17;
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(407L, i, 1L, false);
          this.fsR.dQm();
          AppMethodBeat.o(40633);
          return true;
          if ((i > 10) && (i <= 20)) {
            i = 18;
          } else if ((i > 20) && (i <= 50)) {
            i = 19;
          } else {
            i = 20;
          }
        }
        this.fsR.cK(Boolean.FALSE);
      }
      catch (Exception paramMap)
      {
        ab.e("MicroMsg.LaunchAALogic", "launchAAByPerson error: %s", new Object[] { paramMap.getMessage() });
      }
    }
    this.goi = false;
    AppMethodBeat.o(40633);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.a.k
 * JD-Core Version:    0.7.0.1
 */