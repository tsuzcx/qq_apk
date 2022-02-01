package com.tencent.mm.plugin.appbrand.permission;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.support.v4.e.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.AvailabilityAlertSupplier;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import java.io.Reader;
import java.io.StringReader;
import java.util.LinkedList;
import kotlin.f.d;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/permission/WeChatBrandsApiInvokeInterceptor;", "", "()V", "ERR_MSG_BANNED", "", "PAY_API_CHECK_ISSUED_TEXT", "PAY_API_CHECK_LIST", "Ljava/util/LinkedList;", "shouldInterceptInvoke", "", "env", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;", "api", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "interceptHandler", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent$InterceptHandler;", "plugin-appbrand-integration_release"})
public final class s
{
  private static final String nxN;
  private static final LinkedList<String> nxO;
  public static final s nxP;
  
  static
  {
    AppMethodBeat.i(229261);
    nxP = new s();
    nxN = "requestPayment\nrequestPaymentToBank\nsendBizRedPacket\nrequestVirtualPayment\nopenOfflinePayView\nopenWCPayCardList\nrequestMallPayment\nopenWCPayLQTDetail\nopenWCPayLQTSave\nopenWCPayLQTDepositPlan\nopenWCPayLQTDepositPlanAdd\nsetCurrentPaySpeech\nloadPaySpeechDialectConfig\nopenWCPayOverseaPaymentReceive\nhandleWCPayOverseaWalletBuffer\nrequestH5Transaction\nrequestJointPayment\ngetWCPayOverseaPrepayRequest\nrequestVerifyUserIdentity\nopenSelectPayment\nrequestEntrustAuthorization\nrequestPayCardVerify\nrequestBizSplitBillPayment\nrequestQueryCashier\n\nsendRedPacket\nopenRedPacket\nopenWCCardHomePage\nopenWCCertHomePage\nhandleWCPayOverseaWalletBuffer\ngetWCPayOverseaPrepayRequest\nrequestMidasFriendPayment\nrequestFacetoFacePayment";
    nxO = new LinkedList();
    d.a((Reader)new StringReader(nxN), (kotlin.g.a.b)s.1.nxQ);
    AppMethodBeat.o(229261);
  }
  
  public static final boolean a(final com.tencent.mm.plugin.appbrand.jsapi.k paramk, final com.tencent.mm.plugin.appbrand.jsapi.p paramp, f.a parama)
  {
    AppMethodBeat.i(229260);
    kotlin.g.b.p.h(paramk, "env");
    kotlin.g.b.p.h(paramp, "api");
    if (nxO.contains(paramp.getName()))
    {
      if (!WeChatBrands.Business.Entries.PaymentAppbrandJsb.checkAvailableSlient(paramk.getContext(), (c)new a(parama, paramp, paramk)))
      {
        AppMethodBeat.o(229260);
        return true;
      }
      AppMethodBeat.o(229260);
      return false;
    }
    AppMethodBeat.o(229260);
    return false;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "supplier", "Lcom/tencent/mm/sdk/platformtools/WeChatBrands$Business$AvailabilityAlertSupplier;", "kotlin.jvm.PlatformType", "accept"})
  static final class a<T>
    implements c<WeChatBrands.Business.AvailabilityAlertSupplier>
  {
    a(f.a parama, com.tencent.mm.plugin.appbrand.jsapi.p paramp, com.tencent.mm.plugin.appbrand.jsapi.k paramk) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.s
 * JD-Core Version:    0.7.0.1
 */