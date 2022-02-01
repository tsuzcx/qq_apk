package com.tencent.mm.plugin.aa.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.aa.model.cgi.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.z;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.List;
import java.util.Map;

public final class l
  implements com.tencent.mm.ak.g
{
  public static String izM = "title";
  public static String izN = "totalPayAmount";
  public static String izO = "totalUserNumber";
  public static String izP = "perAmount";
  public static String izQ = "chatRoomName";
  public static String izR = "launchScene";
  public static String izS = "payerlist";
  public static String izT = "timestamp";
  public static String izU = "pic_cdn_url";
  public static String izV = "pic_cdn_thumb_url";
  public static String izW = "pf_order_no";
  private static int izX = 131100026;
  private com.tencent.mm.vending.g.b hvn;
  private boolean izY = false;
  private Map<String, Object> izZ;
  private int mode = 0;
  
  public final boolean b(int paramInt, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(63363);
    this.hvn = com.tencent.mm.vending.g.g.fxn();
    if (this.izY)
    {
      ac.e("MicroMsg.LaunchAALogic", "launchAA, isLaunching!!! ignore it");
      this.hvn.eb(Boolean.FALSE);
      AppMethodBeat.o(63363);
      return false;
    }
    if ((paramMap == null) || (paramMap.size() == 0))
    {
      this.hvn.eb(Boolean.FALSE);
      AppMethodBeat.o(63363);
      return false;
    }
    ac.i("MicroMsg.LaunchAALogic", "launchAAByMoney, data.keySet: %s", new Object[] { paramMap.keySet() });
    this.izY = true;
    this.izZ = paramMap;
    this.mode = paramInt;
    long l1;
    Object localObject;
    long l2;
    if (paramInt == a.iyM)
    {
      if ((this.izZ.containsKey(izM)) && (this.izZ.containsKey(izP)) && (this.izZ.containsKey(izO)) && (this.izZ.containsKey(izR)) && (this.izZ.containsKey(izQ)) && (this.izZ.containsKey(izT))) {
        try
        {
          paramMap = (String)this.izZ.get(izM);
          l1 = ((Long)this.izZ.get(izP)).longValue();
          paramInt = ((Integer)this.izZ.get(izO)).intValue();
          int i = ((Integer)this.izZ.get(izR)).intValue();
          localObject = (String)this.izZ.get(izQ);
          l2 = ((Long)this.izZ.get(izT)).longValue();
          ac.i("MicroMsg.LaunchAALogic", "launchAAByMoney");
          com.tencent.mm.kernel.g.agS();
          com.tencent.mm.kernel.g.agQ().ghe.a(new f(l1, paramMap, paramInt, i, l2, (String)localObject), 0);
          if ((paramInt > 0) && (paramInt <= 10)) {
            paramInt = 13;
          }
          for (;;)
          {
            h.wUl.idkeyStat(407L, paramInt, 1L, false);
            this.hvn.fxm();
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
          this.hvn.eb(Boolean.FALSE);
        }
        catch (Exception paramMap)
        {
          ac.e("MicroMsg.LaunchAALogic", "launchAAByMoney, without specific user error: %s", new Object[] { paramMap.getMessage() });
          this.hvn.eb(Boolean.FALSE);
          this.izY = false;
          AppMethodBeat.o(63363);
          return false;
        }
      }
      this.izY = false;
      AppMethodBeat.o(63363);
      return false;
    }
    if (paramInt == a.iyN)
    {
      if ((this.izZ.containsKey(izM)) && (this.izZ.containsKey(izP)) && (this.izZ.containsKey(izS)) && (this.izZ.containsKey(izR)) && (this.izZ.containsKey(izQ)) && (this.izZ.containsKey(izT))) {
        try
        {
          paramMap = (String)this.izZ.get(izM);
          l1 = ((Long)this.izZ.get(izP)).longValue();
          localObject = (List)this.izZ.get(izS);
          paramInt = ((Integer)this.izZ.get(izR)).intValue();
          String str1 = (String)this.izZ.get(izQ);
          l2 = ((Long)this.izZ.get(izT)).longValue();
          String str2 = (String)this.izZ.get(izU);
          String str3 = (String)this.izZ.get(izV);
          String str4 = (String)this.izZ.get(izW);
          com.tencent.mm.kernel.g.agS();
          com.tencent.mm.kernel.g.agQ().ghe.a(new f(l1, paramMap, (List)localObject, paramInt, l2, str1, str2, str3, str4), 0);
          paramInt = ((List)localObject).size();
          if ((paramInt > 0) && (paramInt <= 10)) {
            paramInt = 13;
          }
          for (;;)
          {
            h.wUl.idkeyStat(407L, paramInt, 1L, false);
            this.hvn.fxm();
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
          this.hvn.eb(Boolean.FALSE);
        }
        catch (Exception paramMap)
        {
          ac.e("MicroMsg.LaunchAALogic", "launchAAByMoney, specific user error: %", new Object[] { paramMap.getMessage() });
          this.hvn.eb(Boolean.FALSE);
          this.izY = false;
          AppMethodBeat.o(63363);
          return false;
        }
      }
      this.izY = false;
      AppMethodBeat.o(63363);
      return false;
    }
    AppMethodBeat.o(63363);
    return false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(63365);
    ac.d("MicroMsg.LaunchAALogic", "onSceneEnd, errType: %s, errCode: %s, scene: %s, mode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramn, Integer.valueOf(this.mode) });
    String str;
    boolean bool;
    if (paramn.getType() == 1624)
    {
      this.izY = false;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramn = (f)paramn;
        paramString = paramn.iAh;
        paramInt1 = paramString.dae;
        str = paramString.oxf;
        if (paramString.DKC == null)
        {
          bool = true;
          ac.i("MicroMsg.LaunchAALogic", "launchAAByMoney, onSceneEnd, retCode: %s, retmsg: %s, msgXml==null: %s, billNo: %s", new Object[] { Integer.valueOf(paramInt1), str, Boolean.valueOf(bool), paramString.DKA });
          if (paramString.dae != 0) {
            break label250;
          }
          if (paramString.DKC == null) {
            break label221;
          }
          i.v(paramString.DKA, paramn.chatroomName, paramString.DKC);
          com.tencent.mm.vending.g.g.a(this.hvn, new Object[] { Boolean.TRUE });
        }
        for (;;)
        {
          i.FP(paramn.chatroomName);
          h.wUl.idkeyStat(407L, 0L, 1L, false);
          AppMethodBeat.o(63365);
          return;
          bool = false;
          break;
          label221:
          i.a(paramString.DKA, false, 0L);
          com.tencent.mm.vending.g.g.a(this.hvn, new Object[] { Boolean.TRUE });
        }
        label250:
        if (this.hvn != null)
        {
          if (paramString.dae <= 0) {
            break label441;
          }
          paramn = paramString.DKL;
          if ((paramn == null) || (paramn.DLr <= 0)) {
            break label314;
          }
          this.hvn.eb(paramn);
        }
        label441:
        for (;;)
        {
          h.wUl.idkeyStat(407L, 2L, 1L, false);
          AppMethodBeat.o(63365);
          return;
          label314:
          if ((paramString.DKM != null) && (paramString.DKM.drx == 1) && (!bs.isNullOrNil(paramString.DKM.oxl)) && (!bs.isNullOrNil(paramString.DKM.unW)) && (!bs.isNullOrNil(paramString.DKM.unX)) && (!bs.isNullOrNil(paramString.DKM.dlQ)))
          {
            this.hvn.eb(paramString.DKM);
          }
          else if (!bs.isNullOrNil(paramString.oxf))
          {
            this.hvn.eb(paramString.oxf);
          }
          else
          {
            this.hvn.eb(Boolean.FALSE);
            continue;
            this.hvn.eb(Boolean.FALSE);
          }
        }
      }
      if (this.hvn != null) {
        this.hvn.eb(Boolean.FALSE);
      }
      h.wUl.idkeyStat(407L, 1L, 1L, false);
      AppMethodBeat.o(63365);
      return;
    }
    if (paramn.getType() == 1655)
    {
      this.izY = false;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramn = (com.tencent.mm.plugin.aa.model.cgi.g)paramn;
        paramString = paramn.iAj;
        paramInt1 = paramString.dae;
        str = paramString.oxf;
        if (paramString.DKC == null)
        {
          bool = true;
          ac.i("MicroMsg.LaunchAALogic", "launchAAByPerson, onSceneEnd, retCode: %s, retmsg: %s, msgxml==null: %s", new Object[] { Integer.valueOf(paramInt1), str, Boolean.valueOf(bool) });
          ac.d("MicroMsg.LaunchAALogic", "launchAAByPerson, onSceneEnd, retMsg: %s, billNo: %s", new Object[] { paramString.oxf, paramString.DKA });
          if (paramString.dae != 0) {
            break label733;
          }
          if (paramString.DKC == null) {
            break label697;
          }
          i.v(paramString.DKA, paramn.chatroomName, paramString.DKC);
          com.tencent.mm.vending.g.g.a(this.hvn, new Object[] { Boolean.TRUE, paramString.DKA });
        }
        for (;;)
        {
          i.FP(paramn.chatroomName);
          h.wUl.idkeyStat(407L, 3L, 1L, false);
          AppMethodBeat.o(63365);
          return;
          bool = false;
          break;
          label697:
          i.a(paramString.DKA, false, 0L);
          com.tencent.mm.vending.g.g.a(this.hvn, new Object[] { Boolean.TRUE, paramString.DKA });
        }
        label733:
        if (paramString.dae > 0)
        {
          paramn = paramString.DKL;
          if ((paramn != null) && (paramn.DLr > 0)) {
            this.hvn.eb(paramn);
          }
        }
        for (;;)
        {
          h.wUl.idkeyStat(407L, 5L, 1L, false);
          AppMethodBeat.o(63365);
          return;
          if ((paramString.DKM != null) && (paramString.DKM.drx == 1) && (!bs.isNullOrNil(paramString.DKM.oxl)) && (!bs.isNullOrNil(paramString.DKM.unW)) && (!bs.isNullOrNil(paramString.DKM.unX)) && (!bs.isNullOrNil(paramString.DKM.dlQ)))
          {
            this.hvn.eb(paramString.DKM);
          }
          else if (!bs.isNullOrNil(paramString.oxf))
          {
            this.hvn.eb(paramString.oxf);
          }
          else
          {
            this.hvn.eb(Boolean.FALSE);
            continue;
            this.hvn.eb(Boolean.FALSE);
          }
        }
      }
      if (this.hvn != null) {
        this.hvn.eb(Boolean.FALSE);
      }
      h.wUl.idkeyStat(407L, 4L, 1L, false);
    }
    AppMethodBeat.o(63365);
  }
  
  public final boolean w(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(63364);
    this.hvn = com.tencent.mm.vending.g.g.fxn();
    ac.i("MicroMsg.LaunchAALogic", "launchAAByPerson");
    if (this.izY)
    {
      ac.e("MicroMsg.LaunchAALogic", "launchAA, isLaunching!!! ignore it");
      this.hvn.eb(Boolean.FALSE);
      AppMethodBeat.o(63364);
      return false;
    }
    if ((paramMap == null) || (paramMap.size() == 0))
    {
      this.hvn.eb(Boolean.FALSE);
      AppMethodBeat.o(63364);
      return false;
    }
    this.izY = true;
    this.izZ = paramMap;
    this.mode = a.iyO;
    if (this.mode != a.iyO)
    {
      this.hvn.eb(Boolean.FALSE);
      AppMethodBeat.o(63364);
      return false;
    }
    if ((this.izZ.containsKey(izM)) && (this.izZ.containsKey(izN)) && (this.izZ.containsKey(izS)) && (this.izZ.containsKey(izR)) && (this.izZ.containsKey(izQ)) && (this.izZ.containsKey(izT))) {
      try
      {
        paramMap = (String)this.izZ.get(izM);
        long l1 = ((Long)this.izZ.get(izN)).longValue();
        List localList = (List)this.izZ.get(izS);
        int i = ((Integer)this.izZ.get(izR)).intValue();
        String str1 = (String)this.izZ.get(izQ);
        long l2 = ((Long)this.izZ.get(izT)).longValue();
        String str2 = (String)this.izZ.get(izU);
        String str3 = (String)this.izZ.get(izV);
        String str4 = (String)this.izZ.get(izW);
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agQ().ghe.a(new com.tencent.mm.plugin.aa.model.cgi.g(paramMap, l1, localList, i, str1, l2, str2, str3, str4), 0);
        i = localList.size();
        if ((i > 0) && (i <= 10)) {
          i = 17;
        }
        for (;;)
        {
          h.wUl.idkeyStat(407L, i, 1L, false);
          this.hvn.fxm();
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
        this.hvn.eb(Boolean.FALSE);
      }
      catch (Exception paramMap)
      {
        ac.e("MicroMsg.LaunchAALogic", "launchAAByPerson error: %s", new Object[] { paramMap.getMessage() });
      }
    }
    this.izY = false;
    AppMethodBeat.o(63364);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.l
 * JD-Core Version:    0.7.0.1
 */