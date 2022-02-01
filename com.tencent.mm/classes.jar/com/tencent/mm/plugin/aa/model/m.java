package com.tencent.mm.plugin.aa.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.aa.model.cgi.f;
import com.tencent.mm.protocal.protobuf.a;
import com.tencent.mm.protocal.protobuf.ac;
import com.tencent.mm.protocal.protobuf.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;
import java.util.Map;

public final class m
  implements com.tencent.mm.am.h
{
  public static String pGE = "title";
  public static String pGF = "totalPayAmount";
  public static String pGG = "totalUserNumber";
  public static String pGH = "perAmount";
  public static String pGI = "chatRoomName";
  public static String pGJ = "launchScene";
  public static String pGK = "payerlist";
  public static String pGL = "timestamp";
  public static String pGM = "pic_cdn_url";
  public static String pGN = "pic_cdn_thumb_url";
  public static String pGO = "pf_order_no";
  public static String pGP = "pic_cdn_md5";
  private static int pGQ = 131100026;
  private int mode = 0;
  private boolean pGR = false;
  private Map<String, Object> pGS;
  private com.tencent.mm.vending.g.b pGz;
  
  public final boolean F(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(63364);
    this.pGz = com.tencent.mm.vending.g.g.jJL();
    Log.i("MicroMsg.LaunchAALogic", "launchAAByPerson");
    if (this.pGR)
    {
      Log.e("MicroMsg.LaunchAALogic", "launchAA, isLaunching!!! ignore it");
      this.pGz.gM(Boolean.FALSE);
      AppMethodBeat.o(63364);
      return false;
    }
    if ((paramMap == null) || (paramMap.size() == 0))
    {
      this.pGz.gM(Boolean.FALSE);
      AppMethodBeat.o(63364);
      return false;
    }
    this.pGR = true;
    this.pGS = paramMap;
    this.mode = b.pFG;
    if (this.mode != b.pFG)
    {
      this.pGz.gM(Boolean.FALSE);
      AppMethodBeat.o(63364);
      return false;
    }
    if ((this.pGS.containsKey(pGE)) && (this.pGS.containsKey(pGF)) && (this.pGS.containsKey(pGK)) && (this.pGS.containsKey(pGJ)) && (this.pGS.containsKey(pGI)) && (this.pGS.containsKey(pGL))) {
      try
      {
        paramMap = (String)this.pGS.get(pGE);
        long l1 = ((Long)this.pGS.get(pGF)).longValue();
        List localList = (List)this.pGS.get(pGK);
        int i = ((Integer)this.pGS.get(pGJ)).intValue();
        String str1 = (String)this.pGS.get(pGI);
        long l2 = ((Long)this.pGS.get(pGL)).longValue();
        String str2 = (String)this.pGS.get(pGM);
        String str3 = (String)this.pGS.get(pGN);
        String str4 = (String)this.pGS.get(pGO);
        String str5 = (String)this.pGS.get(pGP);
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baD().mCm.a(new com.tencent.mm.plugin.aa.model.cgi.g(paramMap, l1, localList, i, str1, l2, str2, str3, str4, str5), 0);
        i = localList.size();
        if ((i > 0) && (i <= 10)) {
          i = 17;
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(407L, i, 1L, false);
          this.pGz.jJK();
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
        this.pGz.gM(Boolean.FALSE);
      }
      catch (Exception paramMap)
      {
        Log.e("MicroMsg.LaunchAALogic", "launchAAByPerson error: %s", new Object[] { paramMap.getMessage() });
      }
    }
    this.pGR = false;
    AppMethodBeat.o(63364);
    return false;
  }
  
  public final boolean G(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(268395);
    this.pGz = com.tencent.mm.vending.g.g.jJL();
    Log.i("MicroMsg.LaunchAALogic", "launchAAByPersonCustomize");
    if (this.pGR)
    {
      Log.e("MicroMsg.LaunchAALogic", "launchAA, isLaunching!!! ignore it");
      this.pGz.gM(Boolean.FALSE);
      AppMethodBeat.o(268395);
      return false;
    }
    if ((paramMap == null) || (paramMap.size() == 0))
    {
      this.pGz.gM(Boolean.FALSE);
      AppMethodBeat.o(268395);
      return false;
    }
    this.pGR = true;
    this.pGS = paramMap;
    this.mode = b.pFG;
    if (this.mode != b.pFG)
    {
      this.pGz.gM(Boolean.FALSE);
      AppMethodBeat.o(268395);
      return false;
    }
    if ((this.pGS.containsKey(pGE)) && (this.pGS.containsKey(pGJ)) && (this.pGS.containsKey(pGI)) && (this.pGS.containsKey(pGL))) {
      try
      {
        paramMap = (String)this.pGS.get(pGE);
        int i = ((Integer)this.pGS.get(pGJ)).intValue();
        String str1 = (String)this.pGS.get(pGI);
        long l = ((Long)this.pGS.get(pGL)).longValue();
        String str2 = (String)this.pGS.get(pGM);
        String str3 = (String)this.pGS.get(pGN);
        String str4 = (String)this.pGS.get(pGO);
        String str5 = (String)this.pGS.get(pGP);
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baD().mCm.a(new com.tencent.mm.plugin.aa.model.cgi.h(paramMap, i, str1, l, str2, str3, str4, str5), 0);
        this.pGz.jJK();
        AppMethodBeat.o(268395);
        return true;
      }
      catch (Exception paramMap)
      {
        Log.e("MicroMsg.LaunchAALogic", "launchAAByPersonCustomize error: %s", new Object[] { paramMap.getMessage() });
        this.pGz.gM(Boolean.FALSE);
        this.pGR = false;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(268395);
      return false;
      Log.i("MicroMsg.LaunchAALogic", "launchAAByPersonCustomize interrupt");
      this.pGz.gM(Boolean.FALSE);
      this.pGR = false;
    }
  }
  
  public final boolean b(int paramInt, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(63363);
    this.pGz = com.tencent.mm.vending.g.g.jJL();
    if (this.pGR)
    {
      Log.e("MicroMsg.LaunchAALogic", "launchAA, isLaunching!!! ignore it");
      this.pGz.gM(Boolean.FALSE);
      AppMethodBeat.o(63363);
      return false;
    }
    if ((paramMap == null) || (paramMap.size() == 0))
    {
      this.pGz.gM(Boolean.FALSE);
      AppMethodBeat.o(63363);
      return false;
    }
    Log.i("MicroMsg.LaunchAALogic", "launchAAByMoney, data.keySet: %s", new Object[] { paramMap.keySet() });
    this.pGR = true;
    this.pGS = paramMap;
    this.mode = paramInt;
    long l1;
    Object localObject;
    long l2;
    if (paramInt == b.pFE)
    {
      if ((this.pGS.containsKey(pGE)) && (this.pGS.containsKey(pGH)) && (this.pGS.containsKey(pGG)) && (this.pGS.containsKey(pGJ)) && (this.pGS.containsKey(pGI)) && (this.pGS.containsKey(pGL))) {
        try
        {
          paramMap = (String)this.pGS.get(pGE);
          l1 = ((Long)this.pGS.get(pGH)).longValue();
          paramInt = ((Integer)this.pGS.get(pGG)).intValue();
          int i = ((Integer)this.pGS.get(pGJ)).intValue();
          localObject = (String)this.pGS.get(pGI);
          l2 = ((Long)this.pGS.get(pGL)).longValue();
          Log.i("MicroMsg.LaunchAALogic", "launchAAByMoney");
          com.tencent.mm.kernel.h.baF();
          com.tencent.mm.kernel.h.baD().mCm.a(new f(l1, paramMap, paramInt, i, l2, (String)localObject), 0);
          if ((paramInt > 0) && (paramInt <= 10)) {
            paramInt = 13;
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(407L, paramInt, 1L, false);
            this.pGz.jJK();
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
          this.pGz.gM(Boolean.FALSE);
        }
        catch (Exception paramMap)
        {
          Log.e("MicroMsg.LaunchAALogic", "launchAAByMoney, without specific user error: %s", new Object[] { paramMap.getMessage() });
          this.pGz.gM(Boolean.FALSE);
          this.pGR = false;
          AppMethodBeat.o(63363);
          return false;
        }
      }
      this.pGR = false;
      AppMethodBeat.o(63363);
      return false;
    }
    if (paramInt == b.pFF)
    {
      if ((this.pGS.containsKey(pGE)) && (this.pGS.containsKey(pGH)) && (this.pGS.containsKey(pGK)) && (this.pGS.containsKey(pGJ)) && (this.pGS.containsKey(pGI)) && (this.pGS.containsKey(pGL))) {
        try
        {
          paramMap = (String)this.pGS.get(pGE);
          l1 = ((Long)this.pGS.get(pGH)).longValue();
          localObject = (List)this.pGS.get(pGK);
          paramInt = ((Integer)this.pGS.get(pGJ)).intValue();
          String str1 = (String)this.pGS.get(pGI);
          l2 = ((Long)this.pGS.get(pGL)).longValue();
          String str2 = (String)this.pGS.get(pGM);
          String str3 = (String)this.pGS.get(pGN);
          String str4 = (String)this.pGS.get(pGO);
          String str5 = (String)this.pGS.get(pGP);
          com.tencent.mm.kernel.h.baF();
          com.tencent.mm.kernel.h.baD().mCm.a(new f(l1, paramMap, (List)localObject, paramInt, l2, str1, str2, str3, str4, str5), 0);
          paramInt = ((List)localObject).size();
          if ((paramInt > 0) && (paramInt <= 10)) {
            paramInt = 13;
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(407L, paramInt, 1L, false);
            this.pGz.jJK();
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
          this.pGz.gM(Boolean.FALSE);
        }
        catch (Exception paramMap)
        {
          Log.e("MicroMsg.LaunchAALogic", "launchAAByMoney, specific user error: %", new Object[] { paramMap.getMessage() });
          this.pGz.gM(Boolean.FALSE);
          this.pGR = false;
          AppMethodBeat.o(63363);
          return false;
        }
      }
      this.pGR = false;
      AppMethodBeat.o(63363);
      return false;
    }
    AppMethodBeat.o(63363);
    return false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(63365);
    Log.i("MicroMsg.LaunchAALogic", "onSceneEnd, errType: %s, errCode: %s, scene: %s, mode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramp, Integer.valueOf(this.mode) });
    String str;
    boolean bool;
    if (paramp.getType() == 1624)
    {
      this.pGR = false;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramp = (f)paramp;
        paramString = paramp.pHb;
        paramInt1 = paramString.hAV;
        str = paramString.wYI;
        if (paramString.YzN == null)
        {
          bool = true;
          Log.i("MicroMsg.LaunchAALogic", "launchAAByMoney, onSceneEnd, retCode: %s, retmsg: %s, msgXml==null: %s, billNo: %s", new Object[] { Integer.valueOf(paramInt1), str, Boolean.valueOf(bool), paramString.YzL });
          if (paramString.hAV != 0) {
            break label253;
          }
          if (paramString.YzN == null) {
            break label224;
          }
          j.A(paramString.YzL, paramp.chatroomName, paramString.YzN);
          com.tencent.mm.vending.g.g.a(this.pGz, new Object[] { Boolean.TRUE });
        }
        for (;;)
        {
          j.SB(paramp.chatroomName);
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(407L, 0L, 1L, false);
          AppMethodBeat.o(63365);
          return;
          bool = false;
          break;
          label224:
          j.a(paramString.YzL, false, 0L);
          com.tencent.mm.vending.g.g.a(this.pGz, new Object[] { Boolean.TRUE });
        }
        label253:
        if (this.pGz != null)
        {
          if (paramString.hAV <= 0) {
            break label445;
          }
          paramp = paramString.YzX;
          if ((paramp == null) || (paramp.YAF <= 0)) {
            break label318;
          }
          this.pGz.gM(paramp);
        }
        label445:
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(407L, 2L, 1L, false);
          AppMethodBeat.o(63365);
          return;
          label318:
          if ((paramString.YzY != null) && (paramString.YzY.eQp == 1) && (!Util.isNullOrNil(paramString.YzY.wYO)) && (!Util.isNullOrNil(paramString.YzY.rGU)) && (!Util.isNullOrNil(paramString.YzY.right_button_wording)) && (!Util.isNullOrNil(paramString.YzY.wording)))
          {
            this.pGz.gM(paramString.YzY);
          }
          else if (!Util.isNullOrNil(paramString.wYI))
          {
            this.pGz.gM(paramString.wYI);
          }
          else
          {
            this.pGz.gM(Boolean.FALSE);
            continue;
            this.pGz.gM(Boolean.FALSE);
          }
        }
      }
      if (this.pGz != null) {
        this.pGz.gM(Boolean.FALSE);
      }
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(407L, 1L, 1L, false);
      AppMethodBeat.o(63365);
      return;
    }
    if (paramp.getType() == 1655)
    {
      this.pGR = false;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramp = (com.tencent.mm.plugin.aa.model.cgi.g)paramp;
        paramString = paramp.pHd;
        paramInt1 = paramString.hAV;
        str = paramString.wYI;
        if (paramString.YzN == null)
        {
          bool = true;
          Log.i("MicroMsg.LaunchAALogic", "launchAAByPerson, onSceneEnd, retCode: %s, retmsg: %s, msgxml==null: %s", new Object[] { Integer.valueOf(paramInt1), str, Boolean.valueOf(bool) });
          Log.d("MicroMsg.LaunchAALogic", "launchAAByPerson, onSceneEnd, retMsg: %s, billNo: %s", new Object[] { paramString.wYI, paramString.YzL });
          if (paramString.hAV != 0) {
            break label739;
          }
          if (paramString.YzN == null) {
            break label703;
          }
          j.A(paramString.YzL, paramp.chatroomName, paramString.YzN);
          com.tencent.mm.vending.g.g.a(this.pGz, new Object[] { Boolean.TRUE, paramString.YzL });
        }
        for (;;)
        {
          j.SB(paramp.chatroomName);
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(407L, 3L, 1L, false);
          AppMethodBeat.o(63365);
          return;
          bool = false;
          break;
          label703:
          j.a(paramString.YzL, false, 0L);
          com.tencent.mm.vending.g.g.a(this.pGz, new Object[] { Boolean.TRUE, paramString.YzL });
        }
        label739:
        if (paramString.hAV > 0)
        {
          paramp = paramString.YzX;
          if ((paramp != null) && (paramp.YAF > 0)) {
            this.pGz.gM(paramp);
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(407L, 5L, 1L, false);
          AppMethodBeat.o(63365);
          return;
          if ((paramString.YzY != null) && (paramString.YzY.eQp == 1) && (!Util.isNullOrNil(paramString.YzY.wYO)) && (!Util.isNullOrNil(paramString.YzY.rGU)) && (!Util.isNullOrNil(paramString.YzY.right_button_wording)) && (!Util.isNullOrNil(paramString.YzY.wording)))
          {
            this.pGz.gM(paramString.YzY);
          }
          else if (!Util.isNullOrNil(paramString.wYI))
          {
            this.pGz.gM(paramString.wYI);
          }
          else
          {
            this.pGz.gM(Boolean.FALSE);
            continue;
            this.pGz.gM(Boolean.FALSE);
          }
        }
      }
      if (this.pGz != null) {
        this.pGz.gM(Boolean.FALSE);
      }
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(407L, 4L, 1L, false);
      AppMethodBeat.o(63365);
      return;
    }
    if (paramp.getType() == 2831)
    {
      this.pGR = false;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramp = (com.tencent.mm.plugin.aa.model.cgi.h)paramp;
        paramString = paramp.pHf;
        paramInt1 = paramString.hAV;
        str = paramString.wYI;
        if (paramString.YzN == null)
        {
          bool = true;
          Log.i("MicroMsg.LaunchAALogic", "launchAAByPersonCustomize, onSceneEnd, retCode: %s, retmsg: %s, msgxml==null: %s", new Object[] { Integer.valueOf(paramInt1), str, Boolean.valueOf(bool) });
          Log.i("MicroMsg.LaunchAALogic", "launchAAByPersonCustomize, onSceneEnd, retMsg: %s, billNo: %s", new Object[] { paramString.wYI, paramString.YzL });
          if (paramString.hAV != 0) {
            break label1220;
          }
          if (paramString.YzN == null) {
            break label1184;
          }
          j.A(paramString.YzL, paramp.chatroomName, paramString.YzN);
          com.tencent.mm.vending.g.g.a(this.pGz, new Object[] { Boolean.TRUE, paramString.YzL });
        }
        for (;;)
        {
          j.SB(paramp.chatroomName);
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(407L, 3L, 1L, false);
          AppMethodBeat.o(63365);
          return;
          bool = false;
          break;
          label1184:
          j.a(paramString.YzL, false, 0L);
          com.tencent.mm.vending.g.g.a(this.pGz, new Object[] { Boolean.TRUE, paramString.YzL });
        }
        label1220:
        if (paramString.hAV > 0)
        {
          paramp = paramString.YzX;
          if ((paramp != null) && (paramp.YAF > 0)) {
            this.pGz.gM(paramp);
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(407L, 5L, 1L, false);
          AppMethodBeat.o(63365);
          return;
          if ((paramString.YzY != null) && (paramString.YzY.eQp == 1) && (!Util.isNullOrNil(paramString.YzY.wYO)) && (!Util.isNullOrNil(paramString.YzY.rGU)) && (!Util.isNullOrNil(paramString.YzY.right_button_wording)) && (!Util.isNullOrNil(paramString.YzY.wording)))
          {
            this.pGz.gM(paramString.YzY);
          }
          else if (!Util.isNullOrNil(paramString.wYI))
          {
            this.pGz.gM(paramString.wYI);
          }
          else
          {
            this.pGz.gM(Boolean.FALSE);
            continue;
            this.pGz.gM(Boolean.FALSE);
          }
        }
      }
      if (this.pGz != null) {
        this.pGz.gM(Boolean.FALSE);
      }
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(407L, 4L, 1L, false);
    }
    AppMethodBeat.o(63365);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.m
 * JD-Core Version:    0.7.0.1
 */