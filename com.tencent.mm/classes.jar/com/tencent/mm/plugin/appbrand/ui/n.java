package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cqc;
import com.tencent.mm.protocal.protobuf.epg;
import com.tencent.mm.protocal.protobuf.eph;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandProfileTestLogic;", "", "()V", "CMD", "", "SUB_CMD_EXPOSE_RELIEVED_BUY", "SUB_CMD_OVERRIDE_PROFILE_INFO", "TAG", "_isOverrideProfileInfo", "", "get_isOverrideProfileInfo$annotations", "exposeRelievedBuy", "getExposeRelievedBuy", "()Ljava/lang/Boolean;", "setExposeRelievedBuy", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "isOverrideProfileInfo", "()Z", "relievedBuySubInfoCount", "", "showEnterContactEntry", "showRelievedBuyEntry", "showRelievedBuyLink", "overrideProfileInfoIfNeed", "", "response", "Lcom/tencent/mm/protocal/protobuf/GetProfileInfoResponse;", "parseCmdVal", "args", "", "([Ljava/lang/String;)V", "parseSubCmdExposeRelievedBuyVal", "parseSubCmdOverrideProfileInfoVal", "provideAllRelievedBuySubInfo", "Lcom/tencent/mm/protocal/protobuf/RelievedBuySubInfo;", "()[Lcom/tencent/mm/protocal/protobuf/RelievedBuySubInfo;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
{
  public static final n ucG;
  private static boolean ucH;
  private static boolean ucI;
  private static boolean ucJ;
  private static boolean ucK;
  private static int ucL;
  private static Boolean ucM;
  
  static
  {
    AppMethodBeat.i(322233);
    ucG = new n();
    AppMethodBeat.o(322233);
  }
  
  public static final void b(cqc paramcqc)
  {
    int j = 0;
    AppMethodBeat.i(322229);
    s.u(paramcqc, "response");
    Log.i("MicroMsg.AppBrand.AppBrandProfileTestLogic", "overrideProfileInfoIfNeed");
    if (!ucH)
    {
      AppMethodBeat.o(322229);
      return;
    }
    epg localepg;
    label62:
    label95:
    Object localObject;
    eph localeph1;
    eph localeph2;
    eph localeph3;
    eph localeph4;
    eph localeph5;
    eph localeph6;
    int k;
    if (ucI)
    {
      i = 1;
      paramcqc.aawI = i;
      localepg = new epg();
      if (!ucJ) {
        break label489;
      }
      i = 1;
      localepg.abts = i;
      localepg.igN = "由微信提供购物保障服务";
      if (!ucK) {
        break label494;
      }
      localepg.abtu = "了解更多";
      localepg.abtv = "https://www.qq.com";
      localObject = new eph();
      ((eph)localObject).YZM = 1;
      ((eph)localObject).title = "资金保障";
      ((eph)localObject).desc = "商家已缴纳保障金，交易纠纷可赔付";
      ((eph)localObject).icon = "https://wximg.qq.com/cityservices/relieved_buy/consumer_protect.png";
      localeph1 = new eph();
      localeph1.YZM = 2;
      localeph1.title = "极速应答";
      localeph1.desc = "客服咨询有响应，更快解决问题";
      localeph1.icon = "https://wximg.qq.com/cityservices/relieved_buy/fast_answer.png";
      localeph2 = new eph();
      localeph2.YZM = 3;
      localeph2.title = "快速发货";
      localeph2.desc = "发货时效有监管，更快送达";
      localeph2.icon = "https://wximg.qq.com/cityservices/relieved_buy/fast_delivery.png";
      localeph3 = new eph();
      localeph3.YZM = 4;
      localeph3.title = "消费者权益保障";
      localeph3.desc = "消费者购物有保障，平台协助解决问题";
      localeph3.icon = "https://wximg.qq.com/cityservices/relieved_buy/fast_refund.png";
      localeph4 = new eph();
      localeph4.YZM = 5;
      localeph4.title = "上门取退";
      localeph4.desc = "预约上门取件，退货更方便";
      localeph4.icon = "https://wximg.qq.com/cityservices/relieved_buy/freight_insure.png";
      localeph5 = new eph();
      localeph5.YZM = 6;
      localeph5.title = "运费险";
      localeph5.desc = "商家已投保退货运费险，退货无忧";
      localeph5.icon = "https://wximg.qq.com/cityservices/relieved_buy/fund_guarantee.png";
      localeph6 = new eph();
      localeph6.YZM = 7;
      localeph6.title = "极速退款";
      localeph6.desc = "退货后支持极速退款到账";
      localeph6.icon = "https://wximg.qq.com/cityservices/relieved_buy/home_pickup.png";
      k = k.qv(ucL, 14);
      if (k <= 0) {}
    }
    for (int i = j;; i = j)
    {
      j = i + 1;
      localepg.abtt.add(new eph[] { localObject, localeph1, localeph2, localeph3, localeph4, localeph5, localeph6, localObject, localeph1, localeph2, localeph3, localeph4, localeph5, localeph6 }[i]);
      if (j >= k)
      {
        localObject = ah.aiuX;
        paramcqc.aawH = localepg;
        AppMethodBeat.o(322229);
        return;
        i = 0;
        break;
        label489:
        i = 0;
        break label62;
        label494:
        localepg.abtu = null;
        localepg.abtv = null;
        break label95;
      }
    }
  }
  
  public static boolean cLk()
  {
    return ucH;
  }
  
  public static Boolean cLl()
  {
    return ucM;
  }
  
  public static final void t(String[] paramArrayOfString)
  {
    int j = 0;
    AppMethodBeat.i(322217);
    s.u(paramArrayOfString, "args");
    String str = Arrays.toString(paramArrayOfString);
    s.s(str, "java.util.Arrays.toString(this)");
    Log.i("MicroMsg.AppBrand.AppBrandProfileTestLogic", s.X("parseCmdVal, args: ", str));
    if (paramArrayOfString.length == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(322217);
      return;
    }
    if ((!s.p("//appbrand_profile", paramArrayOfString[0])) || (2 > paramArrayOfString.length))
    {
      AppMethodBeat.o(322217);
      return;
    }
    str = paramArrayOfString[1];
    if (s.p(str, "overrideProfileInfo"))
    {
      if (6 <= paramArrayOfString.length)
      {
        ucH = true;
        ucI = s.p("1", paramArrayOfString[2]);
        ucJ = s.p("1", paramArrayOfString[3]);
        ucK = s.p("1", paramArrayOfString[4]);
        paramArrayOfString = kotlin.n.n.bJF(paramArrayOfString[5]);
        if (paramArrayOfString != null) {
          break label232;
        }
      }
      label232:
      for (i = j;; i = paramArrayOfString.intValue())
      {
        ucL = i;
        Log.i("MicroMsg.AppBrand.AppBrandProfileTestLogic", "parseSubCmdOverrideProfileInfoVal, isOverrideProfileInfo: " + ucH + ", showEnterContactEntry: " + ucI + ", showRelievedBuyEntry: " + ucJ + ", showRelievedBuyLink: " + ucK + ", relievedBuySubInfoCount: " + ucL);
        AppMethodBeat.o(322217);
        return;
      }
    }
    if ((s.p(str, "exposeRelievedBuy")) && (3 <= paramArrayOfString.length))
    {
      paramArrayOfString = paramArrayOfString[2];
      if (!s.p(paramArrayOfString, "0")) {
        break label298;
      }
      paramArrayOfString = Boolean.FALSE;
    }
    for (;;)
    {
      ucM = paramArrayOfString;
      Log.i("MicroMsg.AppBrand.AppBrandProfileTestLogic", s.X("parseSubCmdExposeRelievedBuyVal, exposeRelievedBuy: ", ucM));
      AppMethodBeat.o(322217);
      return;
      label298:
      if (s.p(paramArrayOfString, "1")) {
        paramArrayOfString = Boolean.TRUE;
      } else {
        paramArrayOfString = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.n
 * JD-Core Version:    0.7.0.1
 */