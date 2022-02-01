package com.tencent.mm.plugin.appbrand.permission;

import androidx.core.f.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e.b;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.AvailabilityAlertSupplier;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import java.io.Reader;
import java.io.StringReader;
import java.util.LinkedList;
import kotlin.f.d;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/permission/WeChatBrandsApiInvokeInterceptor;", "", "()V", "ERR_MSG_BANNED", "", "PAY_API_CHECK_ISSUED_TEXT", "PAY_API_CHECK_LIST", "Ljava/util/LinkedList;", "shouldInterceptInvoke", "", "env", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;", "api", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "interceptHandler", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent$InterceptHandler;", "plugin-appbrand-integration_release"})
public final class s
{
  private static final String qzR;
  private static final LinkedList<String> qzS;
  public static final s qzT;
  
  static
  {
    AppMethodBeat.i(281841);
    qzT = new s();
    qzR = "requestPayment\nrequestPaymentToBank\nsendBizRedPacket\nrequestVirtualPayment\nopenOfflinePayView\nopenWCPayCardList\nrequestMallPayment\nopenWCPayLQTDetail\nopenWCPayLQTSave\nopenWCPayLQTDepositPlan\nopenWCPayLQTDepositPlanAdd\nsetCurrentPaySpeech\nloadPaySpeechDialectConfig\nopenWCPayOverseaPaymentReceive\nhandleWCPayOverseaWalletBuffer\nrequestH5Transaction\nrequestJointPayment\ngetWCPayOverseaPrepayRequest\nrequestVerifyUserIdentity\nopenSelectPayment\nrequestEntrustAuthorization\nrequestPayCardVerify\nrequestBizSplitBillPayment\nrequestQueryCashier\n\nsendRedPacket\nopenRedPacket\nopenWCCardHomePage\nopenWCCertHomePage\nhandleWCPayOverseaWalletBuffer\ngetWCPayOverseaPrepayRequest\nrequestMidasFriendPayment\nrequestFacetoFacePayment";
    qzS = new LinkedList();
    d.a((Reader)new StringReader(qzR), (b)1.qzU);
    AppMethodBeat.o(281841);
  }
  
  public static final boolean a(final j paramj, final o paramo, e.b paramb)
  {
    AppMethodBeat.i(281840);
    p.k(paramj, "env");
    p.k(paramo, "api");
    if (qzS.contains(paramo.getName()))
    {
      if (!WeChatBrands.Business.Entries.PaymentAppbrandJsb.checkAvailableSlient(paramj.getContext(), (a)new a(paramb, paramo, paramj)))
      {
        AppMethodBeat.o(281840);
        return true;
      }
      AppMethodBeat.o(281840);
      return false;
    }
    AppMethodBeat.o(281840);
    return false;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "supplier", "Lcom/tencent/mm/sdk/platformtools/WeChatBrands$Business$AvailabilityAlertSupplier;", "kotlin.jvm.PlatformType", "accept"})
  static final class a<T>
    implements a<WeChatBrands.Business.AvailabilityAlertSupplier>
  {
    a(e.b paramb, o paramo, j paramj) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.s
 * JD-Core Version:    0.7.0.1
 */