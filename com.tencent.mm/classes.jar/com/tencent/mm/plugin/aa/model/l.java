package com.tencent.mm.plugin.aa.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.aa.model.cgi.f;
import com.tencent.mm.protocal.protobuf.ac;
import com.tencent.mm.protocal.protobuf.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.g.b;
import java.util.List;
import java.util.Map;

public final class l
  implements com.tencent.mm.an.i
{
  public static String mJW = "title";
  public static String mJX = "totalPayAmount";
  public static String mJY = "totalUserNumber";
  public static String mJZ = "perAmount";
  public static String mKa = "chatRoomName";
  public static String mKb = "launchScene";
  public static String mKc = "payerlist";
  public static String mKd = "timestamp";
  public static String mKe = "pic_cdn_url";
  public static String mKf = "pic_cdn_thumb_url";
  public static String mKg = "pf_order_no";
  public static String mKh = "pic_cdn_md5";
  private static int mKi = 131100026;
  private b mJR;
  private boolean mKj = false;
  private Map<String, Object> mKk;
  private int mode = 0;
  
  public final boolean c(int paramInt, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(63363);
    this.mJR = com.tencent.mm.vending.g.g.ieE();
    if (this.mKj)
    {
      Log.e("MicroMsg.LaunchAALogic", "launchAA, isLaunching!!! ignore it");
      this.mJR.eo(Boolean.FALSE);
      AppMethodBeat.o(63363);
      return false;
    }
    if ((paramMap == null) || (paramMap.size() == 0))
    {
      this.mJR.eo(Boolean.FALSE);
      AppMethodBeat.o(63363);
      return false;
    }
    Log.i("MicroMsg.LaunchAALogic", "launchAAByMoney, data.keySet: %s", new Object[] { paramMap.keySet() });
    this.mKj = true;
    this.mKk = paramMap;
    this.mode = paramInt;
    long l1;
    Object localObject;
    long l2;
    if (paramInt == a.mIV)
    {
      if ((this.mKk.containsKey(mJW)) && (this.mKk.containsKey(mJZ)) && (this.mKk.containsKey(mJY)) && (this.mKk.containsKey(mKb)) && (this.mKk.containsKey(mKa)) && (this.mKk.containsKey(mKd))) {
        try
        {
          paramMap = (String)this.mKk.get(mJW);
          l1 = ((Long)this.mKk.get(mJZ)).longValue();
          paramInt = ((Integer)this.mKk.get(mJY)).intValue();
          int i = ((Integer)this.mKk.get(mKb)).intValue();
          localObject = (String)this.mKk.get(mKa);
          l2 = ((Long)this.mKk.get(mKd)).longValue();
          Log.i("MicroMsg.LaunchAALogic", "launchAAByMoney");
          com.tencent.mm.kernel.h.aHH();
          com.tencent.mm.kernel.h.aHF().kcd.a(new f(l1, paramMap, paramInt, i, l2, (String)localObject), 0);
          if ((paramInt > 0) && (paramInt <= 10)) {
            paramInt = 13;
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(407L, paramInt, 1L, false);
            this.mJR.ieD();
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
          this.mJR.eo(Boolean.FALSE);
        }
        catch (Exception paramMap)
        {
          Log.e("MicroMsg.LaunchAALogic", "launchAAByMoney, without specific user error: %s", new Object[] { paramMap.getMessage() });
          this.mJR.eo(Boolean.FALSE);
          this.mKj = false;
          AppMethodBeat.o(63363);
          return false;
        }
      }
      this.mKj = false;
      AppMethodBeat.o(63363);
      return false;
    }
    if (paramInt == a.mIW)
    {
      if ((this.mKk.containsKey(mJW)) && (this.mKk.containsKey(mJZ)) && (this.mKk.containsKey(mKc)) && (this.mKk.containsKey(mKb)) && (this.mKk.containsKey(mKa)) && (this.mKk.containsKey(mKd))) {
        try
        {
          paramMap = (String)this.mKk.get(mJW);
          l1 = ((Long)this.mKk.get(mJZ)).longValue();
          localObject = (List)this.mKk.get(mKc);
          paramInt = ((Integer)this.mKk.get(mKb)).intValue();
          String str1 = (String)this.mKk.get(mKa);
          l2 = ((Long)this.mKk.get(mKd)).longValue();
          String str2 = (String)this.mKk.get(mKe);
          String str3 = (String)this.mKk.get(mKf);
          String str4 = (String)this.mKk.get(mKg);
          String str5 = (String)this.mKk.get(mKh);
          com.tencent.mm.kernel.h.aHH();
          com.tencent.mm.kernel.h.aHF().kcd.a(new f(l1, paramMap, (List)localObject, paramInt, l2, str1, str2, str3, str4, str5), 0);
          paramInt = ((List)localObject).size();
          if ((paramInt > 0) && (paramInt <= 10)) {
            paramInt = 13;
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(407L, paramInt, 1L, false);
            this.mJR.ieD();
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
          this.mJR.eo(Boolean.FALSE);
        }
        catch (Exception paramMap)
        {
          Log.e("MicroMsg.LaunchAALogic", "launchAAByMoney, specific user error: %", new Object[] { paramMap.getMessage() });
          this.mJR.eo(Boolean.FALSE);
          this.mKj = false;
          AppMethodBeat.o(63363);
          return false;
        }
      }
      this.mKj = false;
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
      this.mKj = false;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramq = (f)paramq;
        paramString = paramq.mKt;
        paramInt1 = paramString.fwx;
        str = paramString.tVo;
        if (paramString.RDk == null)
        {
          bool = true;
          Log.i("MicroMsg.LaunchAALogic", "launchAAByMoney, onSceneEnd, retCode: %s, retmsg: %s, msgXml==null: %s, billNo: %s", new Object[] { Integer.valueOf(paramInt1), str, Boolean.valueOf(bool), paramString.RDi });
          if (paramString.fwx != 0) {
            break label250;
          }
          if (paramString.RDk == null) {
            break label221;
          }
          i.x(paramString.RDi, paramq.chatroomName, paramString.RDk);
          com.tencent.mm.vending.g.g.a(this.mJR, new Object[] { Boolean.TRUE });
        }
        for (;;)
        {
          i.aah(paramq.chatroomName);
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(407L, 0L, 1L, false);
          AppMethodBeat.o(63365);
          return;
          bool = false;
          break;
          label221:
          i.a(paramString.RDi, false, 0L);
          com.tencent.mm.vending.g.g.a(this.mJR, new Object[] { Boolean.TRUE });
        }
        label250:
        if (this.mJR != null)
        {
          if (paramString.fwx <= 0) {
            break label441;
          }
          paramq = paramString.RDu;
          if ((paramq == null) || (paramq.REc <= 0)) {
            break label314;
          }
          this.mJR.eo(paramq);
        }
        label441:
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(407L, 2L, 1L, false);
          AppMethodBeat.o(63365);
          return;
          label314:
          if ((paramString.RDv != null) && (paramString.RDv.cUP == 1) && (!Util.isNullOrNil(paramString.RDv.tVu)) && (!Util.isNullOrNil(paramString.RDv.oDJ)) && (!Util.isNullOrNil(paramString.RDv.oDK)) && (!Util.isNullOrNil(paramString.RDv.wording)))
          {
            this.mJR.eo(paramString.RDv);
          }
          else if (!Util.isNullOrNil(paramString.tVo))
          {
            this.mJR.eo(paramString.tVo);
          }
          else
          {
            this.mJR.eo(Boolean.FALSE);
            continue;
            this.mJR.eo(Boolean.FALSE);
          }
        }
      }
      if (this.mJR != null) {
        this.mJR.eo(Boolean.FALSE);
      }
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(407L, 1L, 1L, false);
      AppMethodBeat.o(63365);
      return;
    }
    if (paramq.getType() == 1655)
    {
      this.mKj = false;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramq = (com.tencent.mm.plugin.aa.model.cgi.g)paramq;
        paramString = paramq.mKv;
        paramInt1 = paramString.fwx;
        str = paramString.tVo;
        if (paramString.RDk == null)
        {
          bool = true;
          Log.i("MicroMsg.LaunchAALogic", "launchAAByPerson, onSceneEnd, retCode: %s, retmsg: %s, msgxml==null: %s", new Object[] { Integer.valueOf(paramInt1), str, Boolean.valueOf(bool) });
          Log.d("MicroMsg.LaunchAALogic", "launchAAByPerson, onSceneEnd, retMsg: %s, billNo: %s", new Object[] { paramString.tVo, paramString.RDi });
          if (paramString.fwx != 0) {
            break label733;
          }
          if (paramString.RDk == null) {
            break label697;
          }
          i.x(paramString.RDi, paramq.chatroomName, paramString.RDk);
          com.tencent.mm.vending.g.g.a(this.mJR, new Object[] { Boolean.TRUE, paramString.RDi });
        }
        for (;;)
        {
          i.aah(paramq.chatroomName);
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(407L, 3L, 1L, false);
          AppMethodBeat.o(63365);
          return;
          bool = false;
          break;
          label697:
          i.a(paramString.RDi, false, 0L);
          com.tencent.mm.vending.g.g.a(this.mJR, new Object[] { Boolean.TRUE, paramString.RDi });
        }
        label733:
        if (paramString.fwx > 0)
        {
          paramq = paramString.RDu;
          if ((paramq != null) && (paramq.REc > 0)) {
            this.mJR.eo(paramq);
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(407L, 5L, 1L, false);
          AppMethodBeat.o(63365);
          return;
          if ((paramString.RDv != null) && (paramString.RDv.cUP == 1) && (!Util.isNullOrNil(paramString.RDv.tVu)) && (!Util.isNullOrNil(paramString.RDv.oDJ)) && (!Util.isNullOrNil(paramString.RDv.oDK)) && (!Util.isNullOrNil(paramString.RDv.wording)))
          {
            this.mJR.eo(paramString.RDv);
          }
          else if (!Util.isNullOrNil(paramString.tVo))
          {
            this.mJR.eo(paramString.tVo);
          }
          else
          {
            this.mJR.eo(Boolean.FALSE);
            continue;
            this.mJR.eo(Boolean.FALSE);
          }
        }
      }
      if (this.mJR != null) {
        this.mJR.eo(Boolean.FALSE);
      }
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(407L, 4L, 1L, false);
      AppMethodBeat.o(63365);
      return;
    }
    if (paramq.getType() == 2831)
    {
      this.mKj = false;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramq = (com.tencent.mm.plugin.aa.model.cgi.h)paramq;
        paramString = paramq.mKx;
        paramInt1 = paramString.fwx;
        str = paramString.tVo;
        if (paramString.RDk == null)
        {
          bool = true;
          Log.i("MicroMsg.LaunchAALogic", "launchAAByPersonCustomize, onSceneEnd, retCode: %s, retmsg: %s, msgxml==null: %s", new Object[] { Integer.valueOf(paramInt1), str, Boolean.valueOf(bool) });
          Log.i("MicroMsg.LaunchAALogic", "launchAAByPersonCustomize, onSceneEnd, retMsg: %s, billNo: %s", new Object[] { paramString.tVo, paramString.RDi });
          if (paramString.fwx != 0) {
            break label1211;
          }
          if (paramString.RDk == null) {
            break label1175;
          }
          i.x(paramString.RDi, paramq.chatroomName, paramString.RDk);
          com.tencent.mm.vending.g.g.a(this.mJR, new Object[] { Boolean.TRUE, paramString.RDi });
        }
        for (;;)
        {
          i.aah(paramq.chatroomName);
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(407L, 3L, 1L, false);
          AppMethodBeat.o(63365);
          return;
          bool = false;
          break;
          label1175:
          i.a(paramString.RDi, false, 0L);
          com.tencent.mm.vending.g.g.a(this.mJR, new Object[] { Boolean.TRUE, paramString.RDi });
        }
        label1211:
        if (paramString.fwx > 0)
        {
          paramq = paramString.RDu;
          if ((paramq != null) && (paramq.REc > 0)) {
            this.mJR.eo(paramq);
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(407L, 5L, 1L, false);
          AppMethodBeat.o(63365);
          return;
          if ((paramString.RDv != null) && (paramString.RDv.cUP == 1) && (!Util.isNullOrNil(paramString.RDv.tVu)) && (!Util.isNullOrNil(paramString.RDv.oDJ)) && (!Util.isNullOrNil(paramString.RDv.oDK)) && (!Util.isNullOrNil(paramString.RDv.wording)))
          {
            this.mJR.eo(paramString.RDv);
          }
          else if (!Util.isNullOrNil(paramString.tVo))
          {
            this.mJR.eo(paramString.tVo);
          }
          else
          {
            this.mJR.eo(Boolean.FALSE);
            continue;
            this.mJR.eo(Boolean.FALSE);
          }
        }
      }
      if (this.mJR != null) {
        this.mJR.eo(Boolean.FALSE);
      }
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(407L, 4L, 1L, false);
    }
    AppMethodBeat.o(63365);
  }
  
  public final boolean y(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(63364);
    this.mJR = com.tencent.mm.vending.g.g.ieE();
    Log.i("MicroMsg.LaunchAALogic", "launchAAByPerson");
    if (this.mKj)
    {
      Log.e("MicroMsg.LaunchAALogic", "launchAA, isLaunching!!! ignore it");
      this.mJR.eo(Boolean.FALSE);
      AppMethodBeat.o(63364);
      return false;
    }
    if ((paramMap == null) || (paramMap.size() == 0))
    {
      this.mJR.eo(Boolean.FALSE);
      AppMethodBeat.o(63364);
      return false;
    }
    this.mKj = true;
    this.mKk = paramMap;
    this.mode = a.mIX;
    if (this.mode != a.mIX)
    {
      this.mJR.eo(Boolean.FALSE);
      AppMethodBeat.o(63364);
      return false;
    }
    if ((this.mKk.containsKey(mJW)) && (this.mKk.containsKey(mJX)) && (this.mKk.containsKey(mKc)) && (this.mKk.containsKey(mKb)) && (this.mKk.containsKey(mKa)) && (this.mKk.containsKey(mKd))) {
      try
      {
        paramMap = (String)this.mKk.get(mJW);
        long l1 = ((Long)this.mKk.get(mJX)).longValue();
        List localList = (List)this.mKk.get(mKc);
        int i = ((Integer)this.mKk.get(mKb)).intValue();
        String str1 = (String)this.mKk.get(mKa);
        long l2 = ((Long)this.mKk.get(mKd)).longValue();
        String str2 = (String)this.mKk.get(mKe);
        String str3 = (String)this.mKk.get(mKf);
        String str4 = (String)this.mKk.get(mKg);
        String str5 = (String)this.mKk.get(mKh);
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHF().kcd.a(new com.tencent.mm.plugin.aa.model.cgi.g(paramMap, l1, localList, i, str1, l2, str2, str3, str4, str5), 0);
        i = localList.size();
        if ((i > 0) && (i <= 10)) {
          i = 17;
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(407L, i, 1L, false);
          this.mJR.ieD();
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
        this.mJR.eo(Boolean.FALSE);
      }
      catch (Exception paramMap)
      {
        Log.e("MicroMsg.LaunchAALogic", "launchAAByPerson error: %s", new Object[] { paramMap.getMessage() });
      }
    }
    this.mKj = false;
    AppMethodBeat.o(63364);
    return false;
  }
  
  public final boolean z(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(270396);
    this.mJR = com.tencent.mm.vending.g.g.ieE();
    Log.i("MicroMsg.LaunchAALogic", "launchAAByPersonCustomize");
    if (this.mKj)
    {
      Log.e("MicroMsg.LaunchAALogic", "launchAA, isLaunching!!! ignore it");
      this.mJR.eo(Boolean.FALSE);
      AppMethodBeat.o(270396);
      return false;
    }
    if ((paramMap == null) || (paramMap.size() == 0))
    {
      this.mJR.eo(Boolean.FALSE);
      AppMethodBeat.o(270396);
      return false;
    }
    this.mKj = true;
    this.mKk = paramMap;
    this.mode = a.mIX;
    if (this.mode != a.mIX)
    {
      this.mJR.eo(Boolean.FALSE);
      AppMethodBeat.o(270396);
      return false;
    }
    if ((this.mKk.containsKey(mJW)) && (this.mKk.containsKey(mKb)) && (this.mKk.containsKey(mKa)) && (this.mKk.containsKey(mKd))) {
      try
      {
        paramMap = (String)this.mKk.get(mJW);
        int i = ((Integer)this.mKk.get(mKb)).intValue();
        String str1 = (String)this.mKk.get(mKa);
        long l = ((Long)this.mKk.get(mKd)).longValue();
        String str2 = (String)this.mKk.get(mKe);
        String str3 = (String)this.mKk.get(mKf);
        String str4 = (String)this.mKk.get(mKg);
        String str5 = (String)this.mKk.get(mKh);
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHF().kcd.a(new com.tencent.mm.plugin.aa.model.cgi.h(paramMap, i, str1, l, str2, str3, str4, str5), 0);
        this.mJR.ieD();
        AppMethodBeat.o(270396);
        return true;
      }
      catch (Exception paramMap)
      {
        Log.e("MicroMsg.LaunchAALogic", "launchAAByPersonCustomize error: %s", new Object[] { paramMap.getMessage() });
        this.mJR.eo(Boolean.FALSE);
        this.mKj = false;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(270396);
      return false;
      Log.i("MicroMsg.LaunchAALogic", "launchAAByPersonCustomize interrupt");
      this.mJR.eo(Boolean.FALSE);
      this.mKj = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.l
 * JD-Core Version:    0.7.0.1
 */