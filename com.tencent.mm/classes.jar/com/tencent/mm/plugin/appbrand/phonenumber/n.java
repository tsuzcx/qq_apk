package com.tencent.mm.plugin.appbrand.phonenumber;

import a.f.a.r;
import a.l;
import a.v;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.bn;
import com.tencent.mm.plugin.appbrand.widget.sms.EditVerifyCodeView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog;", "", "context", "Landroid/content/Context;", "appId", "", "report", "Lcom/tencent/mm/autogen/mmdata/rpt/WAPhoneAuthActionLogStruct;", "ext_desc", "phoneItem", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "onVerifyCallback", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$OnVerifyCallback;", "(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mm/autogen/mmdata/rpt/WAPhoneAuthActionLogStruct;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$OnVerifyCallback;)V", "INTERVAL_UPDATE_TIME", "", "MAX_WAIT_TIME", "getAppId", "()Ljava/lang/String;", "getContext", "()Landroid/content/Context;", "getExt_desc", "mobileTV", "Landroid/widget/TextView;", "getOnVerifyCallback", "()Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$OnVerifyCallback;", "getPhoneItem", "()Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "getReport", "()Lcom/tencent/mm/autogen/mmdata/rpt/WAPhoneAuthActionLogStruct;", "setReport", "(Lcom/tencent/mm/autogen/mmdata/rpt/WAPhoneAuthActionLogStruct;)V", "sendCodeTV", "smsEditView", "Lcom/tencent/mm/plugin/appbrand/widget/sms/EditVerifyCodeView;", "verifyCodeView", "Landroid/view/View;", "verifyTime", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$VertifyTimer;", "doFailCallback", "", "errMsg", "doSendVerifyCode", "isFirst", "", "doSuccessCallback", "encryptedData", "iv", "doVerifyCode", "code", "handleCheckVerifyCodeStatus", "status", "handleSendVerifyCodeStatus", "hideVKB", "showErrorTips", "showVKB", "showVerifyMobileDialog", "startSmsListener", "stopSmsListener", "tryShow", "updateSendText", "Companion", "OnVerifyCallback", "VertifyTimer", "plugin-appbrand-integration_release"})
public final class n
{
  public static final n.a iED;
  private final String appId;
  final Context context;
  private TextView gut;
  private final String iEA;
  final PhoneItem iEB;
  private final n.b iEC;
  private View iEt;
  private EditVerifyCodeView iEu;
  private TextView iEv;
  private n.c iEw;
  private final int iEx;
  private final int iEy;
  bn iEz;
  
  static
  {
    AppMethodBeat.i(134924);
    iED = new n.a((byte)0);
    AppMethodBeat.o(134924);
  }
  
  public n(Context paramContext, String paramString1, bn parambn, String paramString2, PhoneItem paramPhoneItem, n.b paramb)
  {
    AppMethodBeat.i(134923);
    this.context = paramContext;
    this.appId = paramString1;
    this.iEz = parambn;
    this.iEA = paramString2;
    this.iEB = paramPhoneItem;
    this.iEC = paramb;
    this.iEx = 60000;
    this.iEy = 1000;
    paramContext = this.context.getSystemService("layout_inflater");
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.view.LayoutInflater");
      AppMethodBeat.o(134923);
      throw paramContext;
    }
    this.iEt = ((LayoutInflater)paramContext).inflate(2130968746, null);
    paramContext = this.iEt;
    if (paramContext != null)
    {
      paramContext = (EditVerifyCodeView)paramContext.findViewById(2131821434);
      this.iEu = paramContext;
      paramContext = this.iEt;
      if (paramContext == null) {
        break label209;
      }
      paramContext = (TextView)paramContext.findViewById(2131821433);
      label169:
      this.gut = paramContext;
      paramContext = this.iEt;
      if (paramContext == null) {
        break label214;
      }
    }
    label209:
    label214:
    for (paramContext = (TextView)paramContext.findViewById(2131821435);; paramContext = null)
    {
      this.iEv = paramContext;
      AppMethodBeat.o(134923);
      return;
      paramContext = null;
      break;
      paramContext = null;
      break label169;
    }
  }
  
  private final void EC(String paramString)
  {
    AppMethodBeat.i(134922);
    aKR();
    h.a(this.context, paramString, "", false, (DialogInterface.OnClickListener)new n.j(this));
    AppMethodBeat.o(134922);
  }
  
  private final void aKQ()
  {
    AppMethodBeat.i(134918);
    Object localObject2 = this.context.getString(2131296663);
    String str = this.context.getString(2131296665);
    Object localObject1 = new SpannableStringBuilder();
    ((SpannableStringBuilder)localObject1).append((CharSequence)localObject2);
    ((SpannableStringBuilder)localObject1).append((CharSequence)str);
    int i = ((String)localObject2).length();
    int j = str.length();
    ((SpannableStringBuilder)localObject1).setSpan(new n.o(this), i, i + j, 17);
    ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(this.context.getResources().getColor(2131690214)), i, j + i, 17);
    localObject2 = this.iEv;
    if (localObject2 != null) {
      ((TextView)localObject2).setText((CharSequence)localObject1);
    }
    localObject1 = this.iEv;
    if (localObject1 != null)
    {
      ((TextView)localObject1).setMovementMethod(LinkMovementMethod.getInstance());
      AppMethodBeat.o(134918);
      return;
    }
    AppMethodBeat.o(134918);
  }
  
  private final void aKR()
  {
    AppMethodBeat.i(134919);
    ab.i("MicroMsg.PhoneNumberVerifyCodeDialog", "stopSmsListener");
    n.c localc = this.iEw;
    if (localc != null)
    {
      localc.cancel();
      AppMethodBeat.o(134919);
      return;
    }
    AppMethodBeat.o(134919);
  }
  
  public final void eK(boolean paramBoolean)
  {
    AppMethodBeat.i(134920);
    ab.i("MicroMsg.PhoneNumberVerifyCodeDialog", "doSendVerifyCode");
    Object localObject = this.context;
    this.context.getString(2131297087);
    localObject = h.b((Context)localObject, this.context.getString(2131297180), true, null);
    if (this.iEB.iDs)
    {
      new f(this.appId, this.iEB.czF).a((r)new n.d(this, (p)localObject, paramBoolean));
      AppMethodBeat.o(134920);
      return;
    }
    new e(this.appId, this.iEB.czF).a((r)new n.e(this, (p)localObject, paramBoolean));
    AppMethodBeat.o(134920);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
  static final class i
    implements Runnable
  {
    i(n paramn) {}
    
    public final void run()
    {
      AppMethodBeat.i(134911);
      Object localObject = this.iEE.context;
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(134911);
        throw ((Throwable)localObject);
      }
      ((MMActivity)localObject).hideVKB();
      AppMethodBeat.o(134911);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.n
 * JD-Core Version:    0.7.0.1
 */