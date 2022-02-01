package com.tencent.mm.plugin.appbrand.phonenumber;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.os.CountDownTimer;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.sms.EditVerifyCodeView;
import com.tencent.mm.protocal.protobuf.cvb;
import com.tencent.mm.protocal.protobuf.wj;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.a.b;
import d.v;
import java.util.Map;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog;", "", "context", "Landroid/content/Context;", "appId", "", "report", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReportAction;", "ext_desc", "phoneItem", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "onVerifyCallback", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$OnVerifyCallback;", "(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReportAction;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$OnVerifyCallback;)V", "INTERVAL_UPDATE_TIME", "", "MAX_WAIT_TIME", "getAppId", "()Ljava/lang/String;", "getContext", "()Landroid/content/Context;", "getExt_desc", "mobileTV", "Landroid/widget/TextView;", "getOnVerifyCallback", "()Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$OnVerifyCallback;", "getPhoneItem", "()Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "getReport", "()Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReportAction;", "setReport", "(Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReportAction;)V", "sendCodeTV", "smsEditView", "Lcom/tencent/mm/plugin/appbrand/widget/sms/EditVerifyCodeView;", "verifyCodeView", "Landroid/view/View;", "verifyTime", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$VertifyTimer;", "doFailCallback", "", "errMsg", "doSendVerifyCode", "isFirst", "", "doSuccessCallback", "encryptedData", "iv", "cloudId", "doVerifyCode", "code", "handleCheckVerifyCodeStatus", "status", "handleSendVerifyCodeStatus", "hideVKB", "showErrorTips", "showVKB", "showVerifyMobileDialog", "startSmsListener", "stopSmsListener", "tryShow", "updateSendText", "Companion", "OnVerifyCallback", "VertifyTimer", "luggage-wechat-full-sdk_release"})
public final class aa
{
  public static final a lLU;
  private final int MAX_WAIT_TIME;
  private final String appId;
  final Context context;
  private TextView iHB;
  private View lLL;
  private EditVerifyCodeView lLM;
  private TextView lLN;
  private c lLO;
  private final int lLP;
  y lLQ;
  private final String lLR;
  final PhoneItem lLS;
  private final b lLT;
  
  static
  {
    AppMethodBeat.i(148199);
    lLU = new a((byte)0);
    AppMethodBeat.o(148199);
  }
  
  public aa(Context paramContext, String paramString1, y paramy, String paramString2, PhoneItem paramPhoneItem, b paramb)
  {
    AppMethodBeat.i(169657);
    this.context = paramContext;
    this.appId = paramString1;
    this.lLQ = paramy;
    this.lLR = paramString2;
    this.lLS = paramPhoneItem;
    this.lLT = paramb;
    this.MAX_WAIT_TIME = 60000;
    this.lLP = 1000;
    paramContext = this.context.getSystemService("layout_inflater");
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.view.LayoutInflater");
      AppMethodBeat.o(169657);
      throw paramContext;
    }
    this.lLL = ((LayoutInflater)paramContext).inflate(2131493071, null);
    paramContext = this.lLL;
    if (paramContext != null)
    {
      paramContext = (EditVerifyCodeView)paramContext.findViewById(2131296839);
      this.lLM = paramContext;
      paramContext = this.lLL;
      if (paramContext == null) {
        break label209;
      }
      paramContext = (TextView)paramContext.findViewById(2131296840);
      label169:
      this.iHB = paramContext;
      paramContext = this.lLL;
      if (paramContext == null) {
        break label214;
      }
    }
    label209:
    label214:
    for (paramContext = (TextView)paramContext.findViewById(2131296832);; paramContext = null)
    {
      this.lLN = paramContext;
      AppMethodBeat.o(169657);
      return;
      paramContext = null;
      break;
      paramContext = null;
      break label169;
    }
  }
  
  private final void Qr(String paramString)
  {
    AppMethodBeat.i(148197);
    bsw();
    com.tencent.mm.plugin.appbrand.utils.k.b(this.context, paramString, "", (DialogInterface.OnClickListener)new j(this));
    AppMethodBeat.o(148197);
  }
  
  private final void bsv()
  {
    AppMethodBeat.i(148193);
    Object localObject2 = this.context.getString(2131755441);
    String str = this.context.getString(2131755444);
    Object localObject1 = new SpannableStringBuilder();
    ((SpannableStringBuilder)localObject1).append((CharSequence)localObject2);
    ((SpannableStringBuilder)localObject1).append((CharSequence)str);
    int i = ((String)localObject2).length();
    int j = str.length();
    ((SpannableStringBuilder)localObject1).setSpan(new o(this), i, i + j, 17);
    ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(this.context.getResources().getColor(2131099769)), i, j + i, 17);
    localObject2 = this.lLN;
    if (localObject2 != null) {
      ((TextView)localObject2).setText((CharSequence)localObject1);
    }
    localObject1 = this.lLN;
    if (localObject1 != null)
    {
      ((TextView)localObject1).setMovementMethod(LinkMovementMethod.getInstance());
      AppMethodBeat.o(148193);
      return;
    }
    AppMethodBeat.o(148193);
  }
  
  private final void bsw()
  {
    AppMethodBeat.i(148194);
    ac.i("MicroMsg.PhoneNumberVerifyCodeDialog", "stopSmsListener");
    c localc = this.lLO;
    if (localc != null)
    {
      localc.cancel();
      AppMethodBeat.o(148194);
      return;
    }
    AppMethodBeat.o(148194);
  }
  
  final void hm(final boolean paramBoolean)
  {
    AppMethodBeat.i(148195);
    ac.i("MicroMsg.PhoneNumberVerifyCodeDialog", "doSendVerifyCode");
    final ProgressDialog localProgressDialog = com.tencent.mm.plugin.appbrand.utils.k.b(this.context, (CharSequence)this.context.getString(2131756031));
    if (this.lLS.lJZ)
    {
      new f(this.appId, this.lLS.dnz).x((b)new d(this, localProgressDialog, paramBoolean));
      AppMethodBeat.o(148195);
      return;
    }
    new e(this.appId, this.lLS.dnz).x((b)new e(this, localProgressDialog, paramBoolean));
    AppMethodBeat.o(148195);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$Companion;", "", "()V", "TAG", "", "luggage-wechat-full-sdk_release"})
  public static final class a {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$OnVerifyCallback;", "", "onVerifyCallback", "", "isSuccess", "", "result", "", "", "luggage-wechat-full-sdk_release"})
  public static abstract interface b
  {
    public abstract void a(boolean paramBoolean, Map<String, String> paramMap);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$VertifyTimer;", "Landroid/os/CountDownTimer;", "millisInFuture", "", "countDownInterval", "(Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog;JJ)V", "onFinish", "", "onTick", "millisUntilFinished", "luggage-wechat-full-sdk_release"})
  public final class c
    extends CountDownTimer
  {
    public c(long paramLong)
    {
      super(localObject);
    }
    
    public final void onFinish()
    {
      AppMethodBeat.i(148167);
      aa.c(aa.this);
      AppMethodBeat.o(148167);
    }
    
    public final void onTick(long paramLong)
    {
      AppMethodBeat.i(148166);
      TextView localTextView = aa.b(aa.this);
      if (localTextView != null)
      {
        localTextView.setText((CharSequence)aa.this.context.getString(2131755443, new Object[] { paramLong / 1000L }));
        AppMethodBeat.o(148166);
        return;
      }
      AppMethodBeat.o(148166);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "resp", "Lcom/tencent/mm/protocal/protobuf/SendVerifyCodeResp;", "invoke"})
  static final class d
    extends d.g.b.l
    implements b<cvb, d.y>
  {
    d(aa paramaa, ProgressDialog paramProgressDialog, boolean paramBoolean)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "resp", "Lcom/tencent/mm/protocal/protobuf/SendVerifyCodeResp;", "invoke"})
  static final class e
    extends d.g.b.l
    implements b<cvb, d.y>
  {
    e(aa paramaa, ProgressDialog paramProgressDialog, boolean paramBoolean)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "resp", "Lcom/tencent/mm/protocal/protobuf/CheckVerifyCodeResp;", "invoke"})
  static final class f
    extends d.g.b.l
    implements b<wj, d.y>
  {
    f(aa paramaa, ProgressDialog paramProgressDialog)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "resp", "Lcom/tencent/mm/protocal/protobuf/CheckVerifyCodeResp;", "invoke"})
  static final class g
    extends d.g.b.l
    implements b<wj, d.y>
  {
    g(aa paramaa, ProgressDialog paramProgressDialog)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class h
    implements DialogInterface.OnClickListener
  {
    h(aa paramaa) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(148181);
      paramDialogInterface.dismiss();
      ac.e("MicroMsg.PhoneNumberVerifyCodeDialog", "verify code is error, do send the right code");
      aa.g(this.lLV);
      AppMethodBeat.o(148181);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class i
    implements Runnable
  {
    i(aa paramaa) {}
    
    public final void run()
    {
      AppMethodBeat.i(148182);
      u localu = u.lKF;
      u.bst().dq(this.lLV.context);
      AppMethodBeat.o(148182);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class j
    implements DialogInterface.OnClickListener
  {
    j(aa paramaa) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(148183);
      paramDialogInterface.dismiss();
      aa.b(this.lLV, "fail");
      AppMethodBeat.o(148183);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class k
    implements Runnable
  {
    k(aa paramaa) {}
    
    public final void run()
    {
      AppMethodBeat.i(148184);
      u localu = u.lKF;
      u.bst().dr(this.lLV.context);
      AppMethodBeat.o(148184);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class l
    implements DialogInterface.OnDismissListener
  {
    l(aa paramaa) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(148185);
      ac.i("MicroMsg.PhoneNumberVerifyCodeDialog", "cancel to verify sms");
      aa.d(this.lLV);
      aa.e(this.lLV);
      AppMethodBeat.o(148185);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class m
    implements DialogInterface.OnClickListener
  {
    m(aa paramaa) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      EditVerifyCodeView localEditVerifyCodeView = null;
      Object localObject2 = null;
      AppMethodBeat.i(148190);
      Object localObject1 = aa.f(this.lLV);
      if (localObject1 != null) {}
      for (localObject1 = ((EditVerifyCodeView)localObject1).getText();; localObject1 = null)
      {
        ac.i("MicroMsg.PhoneNumberVerifyCodeDialog", "to verify sms %s", new Object[] { localObject1 });
        localObject1 = aa.f(this.lLV);
        if (localObject1 == null) {
          break;
        }
        localObject1 = ((EditVerifyCodeView)localObject1).getText();
        if ((localObject1 == null) || (((String)localObject1).length() != 6)) {
          break;
        }
        paramDialogInterface.dismiss();
        aa.d(this.lLV);
        aa.e(this.lLV);
        localObject1 = this.lLV;
        localEditVerifyCodeView = aa.f(this.lLV);
        paramDialogInterface = localObject2;
        if (localEditVerifyCodeView != null) {
          paramDialogInterface = localEditVerifyCodeView.getText();
        }
        aa.a((aa)localObject1, String.valueOf(paramDialogInterface));
        AppMethodBeat.o(148190);
        return;
      }
      paramDialogInterface = aa.f(this.lLV);
      if (paramDialogInterface != null)
      {
        paramDialogInterface = paramDialogInterface.getText();
        if (paramDialogInterface == null) {}
      }
      for (paramDialogInterface = Integer.valueOf(paramDialogInterface.length());; paramDialogInterface = null)
      {
        if (paramDialogInterface == null) {
          d.g.b.k.fOy();
        }
        if (paramDialogInterface.intValue() >= 6) {
          break;
        }
        ac.e("MicroMsg.PhoneNumberVerifyCodeDialog", "code is length is < 6");
        com.tencent.mm.plugin.appbrand.utils.k.a(this.lLV.context, this.lLV.context.getString(2131755450), this.lLV.context.getString(2131755442), (DialogInterface.OnClickListener)1.lMe);
        AppMethodBeat.o(148190);
        return;
      }
      localObject1 = aa.f(this.lLV);
      paramDialogInterface = localEditVerifyCodeView;
      if (localObject1 != null)
      {
        localObject1 = ((EditVerifyCodeView)localObject1).getText();
        paramDialogInterface = localEditVerifyCodeView;
        if (localObject1 != null) {
          paramDialogInterface = Integer.valueOf(((String)localObject1).length());
        }
      }
      if (paramDialogInterface == null) {
        d.g.b.k.fOy();
      }
      if (paramDialogInterface.intValue() == 0)
      {
        ac.e("MicroMsg.PhoneNumberVerifyCodeDialog", "code is empty");
        com.tencent.mm.plugin.appbrand.utils.k.a(this.lLV.context, this.lLV.context.getString(2131755449), this.lLV.context.getString(2131755442), (DialogInterface.OnClickListener)2.lMf);
      }
      AppMethodBeat.o(148190);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class n
    implements DialogInterface.OnClickListener
  {
    n(aa paramaa) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(148191);
      ac.i("MicroMsg.PhoneNumberVerifyCodeDialog", "cancel to verify sms");
      paramDialogInterface.dismiss();
      aa.d(this.lLV);
      aa.b(this.lLV, "user cancel");
      aa.e(this.lLV);
      AppMethodBeat.o(148191);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$updateSendText$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "arg0", "Landroid/view/View;", "luggage-wechat-full-sdk_release"})
  public static final class o
    extends ClickableSpan
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(148192);
      d.g.b.k.h(paramView, "arg0");
      ac.i("MicroMsg.PhoneNumberVerifyCodeDialog", "click the resend spanBuilder, do resend sms");
      if (this.lLV.lLS.lJY)
      {
        aa.a(this.lLV);
        AppMethodBeat.o(148192);
        return;
      }
      ac.e("MicroMsg.PhoneNumberVerifyCodeDialog", "allow_send_sms is false, show send_verify_code_frequent error");
      paramView = this.lLV;
      String str = this.lLV.context.getString(2131755446);
      d.g.b.k.g(str, "context.getString(R.stri…end_verify_code_frequent)");
      aa.c(paramView, str);
      AppMethodBeat.o(148192);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.aa
 * JD-Core Version:    0.7.0.1
 */