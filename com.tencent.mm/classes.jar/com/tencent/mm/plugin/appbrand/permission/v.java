package com.tencent.mm.plugin.appbrand.permission;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.f;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.widget.dialog.n;
import com.tencent.mm.plugin.appbrand.widget.dialog.r;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.AvailabilityAlertSupplier;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import java.io.Reader;
import java.io.StringReader;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.f.d;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/permission/WeChatBrandsApiInvokeInterceptor;", "", "()V", "ERR_MSG_BANNED", "", "PAY_API_CHECK_ISSUED_TEXT", "PAY_API_CHECK_LIST", "Ljava/util/LinkedList;", "shouldInterceptInvoke", "", "env", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;", "api", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "interceptHandler", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent$InterceptHandler;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class v
{
  public static final v tEV;
  private static final String tEW;
  private static final LinkedList<String> tEX;
  
  static
  {
    AppMethodBeat.i(318742);
    tEV = new v();
    tEW = "requestPayment\nrequestPaymentToBank\nsendBizRedPacket\nrequestVirtualPayment\nopenOfflinePayView\nopenWCPayCardList\nrequestMallPayment\nopenWCPayLQTDetail\nopenWCPayLQTSave\nopenWCPayLQTDepositPlan\nopenWCPayLQTDepositPlanAdd\nsetCurrentPaySpeech\nloadPaySpeechDialectConfig\nopenWCPayOverseaPaymentReceive\nhandleWCPayOverseaWalletBuffer\nrequestH5Transaction\nrequestJointPayment\ngetWCPayOverseaPrepayRequest\nrequestVerifyUserIdentity\nopenSelectPayment\nrequestEntrustAuthorization\nrequestPayCardVerify\nrequestBizSplitBillPayment\nrequestQueryCashier\n\nsendRedPacket\nopenRedPacket\nopenWCCardHomePage\nopenWCCertHomePage\nhandleWCPayOverseaWalletBuffer\ngetWCPayOverseaPrepayRequest\nrequestMidasFriendPayment\nrequestFacetoFacePayment";
    tEX = new LinkedList();
    d.a((Reader)new StringReader(tEW), (kotlin.g.a.b)v.1.tEY);
    AppMethodBeat.o(318742);
  }
  
  private static final void a(f.b paramb, p paramp, k paramk, WeChatBrands.Business.AvailabilityAlertSupplier paramAvailabilityAlertSupplier)
  {
    AppMethodBeat.i(318737);
    s.u(paramp, "$api");
    s.u(paramk, "$env");
    if (paramb != null) {
      paramb.ZJ(paramp.a("fail limited use", a.f.rVK, null));
    }
    paramk.V(new v..ExternalSyntheticLambda2(paramk, paramAvailabilityAlertSupplier));
    AppMethodBeat.o(318737);
  }
  
  private static final void a(k paramk, WeChatBrands.Business.AvailabilityAlertSupplier paramAvailabilityAlertSupplier)
  {
    AppMethodBeat.i(318733);
    s.u(paramk, "$env");
    Object localObject = paramk.getContext();
    if ((localObject != null) && (paramk.getDialogContainer() != null))
    {
      localObject = new com.tencent.mm.plugin.appbrand.widget.dialog.b((Context)localObject);
      ((com.tencent.mm.plugin.appbrand.widget.dialog.b)localObject).setTitle((CharSequence)paramAvailabilityAlertSupplier.getTilte());
      ((com.tencent.mm.plugin.appbrand.widget.dialog.b)localObject).setMessage((CharSequence)paramAvailabilityAlertSupplier.getBody());
      CharSequence localCharSequence = (CharSequence)paramAvailabilityAlertSupplier.getNegativeBtnText();
      if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
        break label163;
      }
    }
    label163:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        ((com.tencent.mm.plugin.appbrand.widget.dialog.b)localObject).b((CharSequence)paramAvailabilityAlertSupplier.getNegativeBtnText(), true, paramAvailabilityAlertSupplier.getOnNegativeClickListener());
      }
      ((com.tencent.mm.plugin.appbrand.widget.dialog.b)localObject).a((CharSequence)paramAvailabilityAlertSupplier.getPositiveBtnText(), true, paramAvailabilityAlertSupplier.getOnPositiveClickListener());
      ((com.tencent.mm.plugin.appbrand.widget.dialog.b)localObject).setOnDismissListener(new v..ExternalSyntheticLambda0(paramAvailabilityAlertSupplier));
      paramk = paramk.getDialogContainer();
      s.checkNotNull(paramk);
      paramk.b((n)localObject);
      AppMethodBeat.o(318733);
      return;
    }
  }
  
  private static final void a(WeChatBrands.Business.AvailabilityAlertSupplier paramAvailabilityAlertSupplier, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(318729);
    if (paramAvailabilityAlertSupplier.getOnDismissListener() != null) {
      paramAvailabilityAlertSupplier.getOnDismissListener().onClick(paramDialogInterface, -2);
    }
    AppMethodBeat.o(318729);
  }
  
  public static final boolean a(k paramk, p paramp, f.b paramb)
  {
    AppMethodBeat.i(318726);
    s.u(paramk, "env");
    s.u(paramp, "api");
    if (tEX.contains(paramp.getName()))
    {
      if (!WeChatBrands.Business.Entries.PaymentAppbrandJsb.checkAvailableSlient(paramk.getContext(), new v..ExternalSyntheticLambda1(paramb, paramp, paramk)))
      {
        AppMethodBeat.o(318726);
        return true;
      }
      AppMethodBeat.o(318726);
      return false;
    }
    AppMethodBeat.o(318726);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.v
 * JD-Core Version:    0.7.0.1
 */