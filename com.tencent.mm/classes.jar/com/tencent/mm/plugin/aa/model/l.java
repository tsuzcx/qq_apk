package com.tencent.mm.plugin.aa.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.aa.model.cgi.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.z;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.List;
import java.util.Map;

public final class l
  implements com.tencent.mm.al.g
{
  public static String hZI = "title";
  public static String hZJ = "totalPayAmount";
  public static String hZK = "totalUserNumber";
  public static String hZL = "perAmount";
  public static String hZM = "chatRoomName";
  public static String hZN = "launchScene";
  public static String hZO = "payerlist";
  public static String hZP = "timestamp";
  public static String hZQ = "pic_cdn_url";
  public static String hZR = "pic_cdn_thumb_url";
  public static String hZS = "pf_order_no";
  private static int hZT = 131100026;
  private com.tencent.mm.vending.g.b gUO;
  private boolean hZU = false;
  private Map<String, Object> hZV;
  private int mode = 0;
  
  public final boolean b(int paramInt, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(63363);
    this.gUO = com.tencent.mm.vending.g.g.fhl();
    if (this.hZU)
    {
      ad.e("MicroMsg.LaunchAALogic", "launchAA, isLaunching!!! ignore it");
      this.gUO.ea(Boolean.FALSE);
      AppMethodBeat.o(63363);
      return false;
    }
    if ((paramMap == null) || (paramMap.size() == 0))
    {
      this.gUO.ea(Boolean.FALSE);
      AppMethodBeat.o(63363);
      return false;
    }
    ad.i("MicroMsg.LaunchAALogic", "launchAAByMoney, data.keySet: %s", new Object[] { paramMap.keySet() });
    this.hZU = true;
    this.hZV = paramMap;
    this.mode = paramInt;
    long l1;
    Object localObject;
    long l2;
    if (paramInt == a.hYI)
    {
      if ((this.hZV.containsKey(hZI)) && (this.hZV.containsKey(hZL)) && (this.hZV.containsKey(hZK)) && (this.hZV.containsKey(hZN)) && (this.hZV.containsKey(hZM)) && (this.hZV.containsKey(hZP))) {
        try
        {
          paramMap = (String)this.hZV.get(hZI);
          l1 = ((Long)this.hZV.get(hZL)).longValue();
          paramInt = ((Integer)this.hZV.get(hZK)).intValue();
          int i = ((Integer)this.hZV.get(hZN)).intValue();
          localObject = (String)this.hZV.get(hZM);
          l2 = ((Long)this.hZV.get(hZP)).longValue();
          ad.i("MicroMsg.LaunchAALogic", "launchAAByMoney");
          com.tencent.mm.kernel.g.afC();
          com.tencent.mm.kernel.g.afA().gcy.a(new f(l1, paramMap, paramInt, i, l2, (String)localObject), 0);
          if ((paramInt > 0) && (paramInt <= 10)) {
            paramInt = 13;
          }
          for (;;)
          {
            h.vKh.idkeyStat(407L, paramInt, 1L, false);
            this.gUO.fhk();
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
          this.gUO.ea(Boolean.FALSE);
        }
        catch (Exception paramMap)
        {
          ad.e("MicroMsg.LaunchAALogic", "launchAAByMoney, without specific user error: %s", new Object[] { paramMap.getMessage() });
          this.gUO.ea(Boolean.FALSE);
          this.hZU = false;
          AppMethodBeat.o(63363);
          return false;
        }
      }
      this.hZU = false;
      AppMethodBeat.o(63363);
      return false;
    }
    if (paramInt == a.hYJ)
    {
      if ((this.hZV.containsKey(hZI)) && (this.hZV.containsKey(hZL)) && (this.hZV.containsKey(hZO)) && (this.hZV.containsKey(hZN)) && (this.hZV.containsKey(hZM)) && (this.hZV.containsKey(hZP))) {
        try
        {
          paramMap = (String)this.hZV.get(hZI);
          l1 = ((Long)this.hZV.get(hZL)).longValue();
          localObject = (List)this.hZV.get(hZO);
          paramInt = ((Integer)this.hZV.get(hZN)).intValue();
          String str1 = (String)this.hZV.get(hZM);
          l2 = ((Long)this.hZV.get(hZP)).longValue();
          String str2 = (String)this.hZV.get(hZQ);
          String str3 = (String)this.hZV.get(hZR);
          String str4 = (String)this.hZV.get(hZS);
          com.tencent.mm.kernel.g.afC();
          com.tencent.mm.kernel.g.afA().gcy.a(new f(l1, paramMap, (List)localObject, paramInt, l2, str1, str2, str3, str4), 0);
          paramInt = ((List)localObject).size();
          if ((paramInt > 0) && (paramInt <= 10)) {
            paramInt = 13;
          }
          for (;;)
          {
            h.vKh.idkeyStat(407L, paramInt, 1L, false);
            this.gUO.fhk();
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
          this.gUO.ea(Boolean.FALSE);
        }
        catch (Exception paramMap)
        {
          ad.e("MicroMsg.LaunchAALogic", "launchAAByMoney, specific user error: %", new Object[] { paramMap.getMessage() });
          this.gUO.ea(Boolean.FALSE);
          this.hZU = false;
          AppMethodBeat.o(63363);
          return false;
        }
      }
      this.hZU = false;
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
      this.hZU = false;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramn = (f)paramn;
        paramString = paramn.iae;
        paramInt1 = paramString.dcG;
        str = paramString.nTK;
        if (paramString.Csk == null)
        {
          bool = true;
          ad.i("MicroMsg.LaunchAALogic", "launchAAByMoney, onSceneEnd, retCode: %s, retmsg: %s, msgXml==null: %s, billNo: %s", new Object[] { Integer.valueOf(paramInt1), str, Boolean.valueOf(bool), paramString.Csi });
          if (paramString.dcG != 0) {
            break label250;
          }
          if (paramString.Csk == null) {
            break label221;
          }
          i.v(paramString.Csi, paramn.chatroomName, paramString.Csk);
          com.tencent.mm.vending.g.g.a(this.gUO, new Object[] { Boolean.TRUE });
        }
        for (;;)
        {
          i.BM(paramn.chatroomName);
          h.vKh.idkeyStat(407L, 0L, 1L, false);
          AppMethodBeat.o(63365);
          return;
          bool = false;
          break;
          label221:
          i.a(paramString.Csi, false, 0L);
          com.tencent.mm.vending.g.g.a(this.gUO, new Object[] { Boolean.TRUE });
        }
        label250:
        if (this.gUO != null)
        {
          if (paramString.dcG <= 0) {
            break label441;
          }
          paramn = paramString.Cst;
          if ((paramn == null) || (paramn.Cta <= 0)) {
            break label314;
          }
          this.gUO.ea(paramn);
        }
        label441:
        for (;;)
        {
          h.vKh.idkeyStat(407L, 2L, 1L, false);
          AppMethodBeat.o(63365);
          return;
          label314:
          if ((paramString.Csu != null) && (paramString.Csu.dtM == 1) && (!bt.isNullOrNil(paramString.Csu.nTQ)) && (!bt.isNullOrNil(paramString.Csu.tfH)) && (!bt.isNullOrNil(paramString.Csu.tfI)) && (!bt.isNullOrNil(paramString.Csu.doh)))
          {
            this.gUO.ea(paramString.Csu);
          }
          else if (!bt.isNullOrNil(paramString.nTK))
          {
            this.gUO.ea(paramString.nTK);
          }
          else
          {
            this.gUO.ea(Boolean.FALSE);
            continue;
            this.gUO.ea(Boolean.FALSE);
          }
        }
      }
      if (this.gUO != null) {
        this.gUO.ea(Boolean.FALSE);
      }
      h.vKh.idkeyStat(407L, 1L, 1L, false);
      AppMethodBeat.o(63365);
      return;
    }
    if (paramn.getType() == 1655)
    {
      this.hZU = false;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramn = (com.tencent.mm.plugin.aa.model.cgi.g)paramn;
        paramString = paramn.iag;
        paramInt1 = paramString.dcG;
        str = paramString.nTK;
        if (paramString.Csk == null)
        {
          bool = true;
          ad.i("MicroMsg.LaunchAALogic", "launchAAByPerson, onSceneEnd, retCode: %s, retmsg: %s, msgxml==null: %s", new Object[] { Integer.valueOf(paramInt1), str, Boolean.valueOf(bool) });
          ad.d("MicroMsg.LaunchAALogic", "launchAAByPerson, onSceneEnd, retMsg: %s, billNo: %s", new Object[] { paramString.nTK, paramString.Csi });
          if (paramString.dcG != 0) {
            break label733;
          }
          if (paramString.Csk == null) {
            break label697;
          }
          i.v(paramString.Csi, paramn.chatroomName, paramString.Csk);
          com.tencent.mm.vending.g.g.a(this.gUO, new Object[] { Boolean.TRUE, paramString.Csi });
        }
        for (;;)
        {
          i.BM(paramn.chatroomName);
          h.vKh.idkeyStat(407L, 3L, 1L, false);
          AppMethodBeat.o(63365);
          return;
          bool = false;
          break;
          label697:
          i.a(paramString.Csi, false, 0L);
          com.tencent.mm.vending.g.g.a(this.gUO, new Object[] { Boolean.TRUE, paramString.Csi });
        }
        label733:
        if (paramString.dcG > 0)
        {
          paramn = paramString.Cst;
          if ((paramn != null) && (paramn.Cta > 0)) {
            this.gUO.ea(paramn);
          }
        }
        for (;;)
        {
          h.vKh.idkeyStat(407L, 5L, 1L, false);
          AppMethodBeat.o(63365);
          return;
          if ((paramString.Csu != null) && (paramString.Csu.dtM == 1) && (!bt.isNullOrNil(paramString.Csu.nTQ)) && (!bt.isNullOrNil(paramString.Csu.tfH)) && (!bt.isNullOrNil(paramString.Csu.tfI)) && (!bt.isNullOrNil(paramString.Csu.doh)))
          {
            this.gUO.ea(paramString.Csu);
          }
          else if (!bt.isNullOrNil(paramString.nTK))
          {
            this.gUO.ea(paramString.nTK);
          }
          else
          {
            this.gUO.ea(Boolean.FALSE);
            continue;
            this.gUO.ea(Boolean.FALSE);
          }
        }
      }
      if (this.gUO != null) {
        this.gUO.ea(Boolean.FALSE);
      }
      h.vKh.idkeyStat(407L, 4L, 1L, false);
    }
    AppMethodBeat.o(63365);
  }
  
  public final boolean x(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(63364);
    this.gUO = com.tencent.mm.vending.g.g.fhl();
    ad.i("MicroMsg.LaunchAALogic", "launchAAByPerson");
    if (this.hZU)
    {
      ad.e("MicroMsg.LaunchAALogic", "launchAA, isLaunching!!! ignore it");
      this.gUO.ea(Boolean.FALSE);
      AppMethodBeat.o(63364);
      return false;
    }
    if ((paramMap == null) || (paramMap.size() == 0))
    {
      this.gUO.ea(Boolean.FALSE);
      AppMethodBeat.o(63364);
      return false;
    }
    this.hZU = true;
    this.hZV = paramMap;
    this.mode = a.hYK;
    if (this.mode != a.hYK)
    {
      this.gUO.ea(Boolean.FALSE);
      AppMethodBeat.o(63364);
      return false;
    }
    if ((this.hZV.containsKey(hZI)) && (this.hZV.containsKey(hZJ)) && (this.hZV.containsKey(hZO)) && (this.hZV.containsKey(hZN)) && (this.hZV.containsKey(hZM)) && (this.hZV.containsKey(hZP))) {
      try
      {
        paramMap = (String)this.hZV.get(hZI);
        long l1 = ((Long)this.hZV.get(hZJ)).longValue();
        List localList = (List)this.hZV.get(hZO);
        int i = ((Integer)this.hZV.get(hZN)).intValue();
        String str1 = (String)this.hZV.get(hZM);
        long l2 = ((Long)this.hZV.get(hZP)).longValue();
        String str2 = (String)this.hZV.get(hZQ);
        String str3 = (String)this.hZV.get(hZR);
        String str4 = (String)this.hZV.get(hZS);
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afA().gcy.a(new com.tencent.mm.plugin.aa.model.cgi.g(paramMap, l1, localList, i, str1, l2, str2, str3, str4), 0);
        i = localList.size();
        if ((i > 0) && (i <= 10)) {
          i = 17;
        }
        for (;;)
        {
          h.vKh.idkeyStat(407L, i, 1L, false);
          this.gUO.fhk();
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
        this.gUO.ea(Boolean.FALSE);
      }
      catch (Exception paramMap)
      {
        ad.e("MicroMsg.LaunchAALogic", "launchAAByPerson error: %s", new Object[] { paramMap.getMessage() });
      }
    }
    this.hZU = false;
    AppMethodBeat.o(63364);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.l
 * JD-Core Version:    0.7.0.1
 */