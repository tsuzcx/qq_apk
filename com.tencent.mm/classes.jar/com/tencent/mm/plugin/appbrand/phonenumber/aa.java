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
import com.tencent.mm.protocal.protobuf.dbh;
import com.tencent.mm.protocal.protobuf.yl;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.a.b;
import d.g.b.p;
import d.g.b.q;
import d.v;
import d.z;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog;", "", "context", "Landroid/content/Context;", "appId", "", "report", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReportAction;", "ext_desc", "phoneItem", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "onVerifyCallback", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$OnVerifyCallback;", "(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReportAction;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$OnVerifyCallback;)V", "INTERVAL_UPDATE_TIME", "", "MAX_WAIT_TIME", "getAppId", "()Ljava/lang/String;", "getContext", "()Landroid/content/Context;", "getExt_desc", "mobileTV", "Landroid/widget/TextView;", "getOnVerifyCallback", "()Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$OnVerifyCallback;", "getPhoneItem", "()Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "getReport", "()Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReportAction;", "setReport", "(Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReportAction;)V", "sendCodeTV", "smsEditView", "Lcom/tencent/mm/plugin/appbrand/widget/sms/EditVerifyCodeView;", "verifyCodeView", "Landroid/view/View;", "verifyTime", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$VertifyTimer;", "doFailCallback", "", "errMsg", "doSendVerifyCode", "isFirst", "", "doSuccessCallback", "encryptedData", "iv", "cloudId", "doVerifyCode", "code", "handleCheckVerifyCodeStatus", "status", "handleSendVerifyCodeStatus", "hideVKB", "showErrorTips", "showVKB", "showVerifyMobileDialog", "startSmsListener", "stopSmsListener", "tryShow", "updateSendText", "Companion", "OnVerifyCallback", "VertifyTimer", "luggage-wechat-full-sdk_release"})
public final class aa
{
  public static final aa.a mqF;
  private final int MAX_WAIT_TIME;
  private final String appId;
  final Context context;
  private TextView jdD;
  private final int mqA;
  y mqB;
  private final String mqC;
  final PhoneItem mqD;
  private final aa.b mqE;
  private View mqw;
  private EditVerifyCodeView mqx;
  private TextView mqy;
  private c mqz;
  
  static
  {
    AppMethodBeat.i(148199);
    mqF = new aa.a((byte)0);
    AppMethodBeat.o(148199);
  }
  
  public aa(Context paramContext, String paramString1, y paramy, String paramString2, PhoneItem paramPhoneItem, aa.b paramb)
  {
    AppMethodBeat.i(169657);
    this.context = paramContext;
    this.appId = paramString1;
    this.mqB = paramy;
    this.mqC = paramString2;
    this.mqD = paramPhoneItem;
    this.mqE = paramb;
    this.MAX_WAIT_TIME = 60000;
    this.mqA = 1000;
    paramContext = this.context.getSystemService("layout_inflater");
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.view.LayoutInflater");
      AppMethodBeat.o(169657);
      throw paramContext;
    }
    this.mqw = ((LayoutInflater)paramContext).inflate(2131493071, null);
    paramContext = this.mqw;
    if (paramContext != null)
    {
      paramContext = (EditVerifyCodeView)paramContext.findViewById(2131296839);
      this.mqx = paramContext;
      paramContext = this.mqw;
      if (paramContext == null) {
        break label209;
      }
      paramContext = (TextView)paramContext.findViewById(2131296840);
      label169:
      this.jdD = paramContext;
      paramContext = this.mqw;
      if (paramContext == null) {
        break label214;
      }
    }
    label209:
    label214:
    for (paramContext = (TextView)paramContext.findViewById(2131296832);; paramContext = null)
    {
      this.mqy = paramContext;
      AppMethodBeat.o(169657);
      return;
      paramContext = null;
      break;
      paramContext = null;
      break label169;
    }
  }
  
  private final void UG(String paramString)
  {
    AppMethodBeat.i(148197);
    bxs();
    com.tencent.mm.plugin.appbrand.utils.l.b(this.context, paramString, "", (DialogInterface.OnClickListener)new j(this));
    AppMethodBeat.o(148197);
  }
  
  private final void bxr()
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
    localObject2 = this.mqy;
    if (localObject2 != null) {
      ((TextView)localObject2).setText((CharSequence)localObject1);
    }
    localObject1 = this.mqy;
    if (localObject1 != null)
    {
      ((TextView)localObject1).setMovementMethod(LinkMovementMethod.getInstance());
      AppMethodBeat.o(148193);
      return;
    }
    AppMethodBeat.o(148193);
  }
  
  private final void bxs()
  {
    AppMethodBeat.i(148194);
    ae.i("MicroMsg.PhoneNumberVerifyCodeDialog", "stopSmsListener");
    c localc = this.mqz;
    if (localc != null)
    {
      localc.cancel();
      AppMethodBeat.o(148194);
      return;
    }
    AppMethodBeat.o(148194);
  }
  
  final void hu(final boolean paramBoolean)
  {
    AppMethodBeat.i(148195);
    ae.i("MicroMsg.PhoneNumberVerifyCodeDialog", "doSendVerifyCode");
    final ProgressDialog localProgressDialog = com.tencent.mm.plugin.appbrand.utils.l.b(this.context, (CharSequence)this.context.getString(2131756031));
    if (this.mqD.moM)
    {
      new f(this.appId, this.mqD.dAs).y((b)new d(this, localProgressDialog, paramBoolean));
      AppMethodBeat.o(148195);
      return;
    }
    new e(this.appId, this.mqD.dAs).y((b)new e(this, localProgressDialog, paramBoolean));
    AppMethodBeat.o(148195);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$VertifyTimer;", "Landroid/os/CountDownTimer;", "millisInFuture", "", "countDownInterval", "(Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog;JJ)V", "onFinish", "", "onTick", "millisUntilFinished", "luggage-wechat-full-sdk_release"})
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
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "resp", "Lcom/tencent/mm/protocal/protobuf/SendVerifyCodeResp;", "invoke"})
  static final class d
    extends q
    implements b<dbh, z>
  {
    d(aa paramaa, ProgressDialog paramProgressDialog, boolean paramBoolean)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "resp", "Lcom/tencent/mm/protocal/protobuf/SendVerifyCodeResp;", "invoke"})
  static final class e
    extends q
    implements b<dbh, z>
  {
    e(aa paramaa, ProgressDialog paramProgressDialog, boolean paramBoolean)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "resp", "Lcom/tencent/mm/protocal/protobuf/CheckVerifyCodeResp;", "invoke"})
  static final class f
    extends q
    implements b<yl, z>
  {
    f(aa paramaa, ProgressDialog paramProgressDialog)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "resp", "Lcom/tencent/mm/protocal/protobuf/CheckVerifyCodeResp;", "invoke"})
  static final class g
    extends q
    implements b<yl, z>
  {
    g(aa paramaa, ProgressDialog paramProgressDialog)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class h
    implements DialogInterface.OnClickListener
  {
    h(aa paramaa) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(148181);
      paramDialogInterface.dismiss();
      ae.e("MicroMsg.PhoneNumberVerifyCodeDialog", "verify code is error, do send the right code");
      aa.g(this.mqG);
      AppMethodBeat.o(148181);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class i
    implements Runnable
  {
    i(aa paramaa) {}
    
    public final void run()
    {
      AppMethodBeat.i(148182);
      u localu = u.mps;
      u.bxp().dq(this.mqG.context);
      AppMethodBeat.o(148182);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class j
    implements DialogInterface.OnClickListener
  {
    j(aa paramaa) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(148183);
      paramDialogInterface.dismiss();
      aa.b(this.mqG, "fail");
      AppMethodBeat.o(148183);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class k
    implements Runnable
  {
    k(aa paramaa) {}
    
    public final void run()
    {
      AppMethodBeat.i(148184);
      u localu = u.mps;
      u.bxp().dr(this.mqG.context);
      AppMethodBeat.o(148184);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class l
    implements DialogInterface.OnDismissListener
  {
    l(aa paramaa) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(148185);
      ae.i("MicroMsg.PhoneNumberVerifyCodeDialog", "cancel to verify sms");
      aa.d(this.mqG);
      aa.e(this.mqG);
      AppMethodBeat.o(148185);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class m
    implements DialogInterface.OnClickListener
  {
    m(aa paramaa) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      EditVerifyCodeView localEditVerifyCodeView = null;
      Object localObject2 = null;
      AppMethodBeat.i(148190);
      Object localObject1 = aa.f(this.mqG);
      if (localObject1 != null) {}
      for (localObject1 = ((EditVerifyCodeView)localObject1).getText();; localObject1 = null)
      {
        ae.i("MicroMsg.PhoneNumberVerifyCodeDialog", "to verify sms %s", new Object[] { localObject1 });
        localObject1 = aa.f(this.mqG);
        if (localObject1 == null) {
          break;
        }
        localObject1 = ((EditVerifyCodeView)localObject1).getText();
        if ((localObject1 == null) || (((String)localObject1).length() != 6)) {
          break;
        }
        paramDialogInterface.dismiss();
        aa.d(this.mqG);
        aa.e(this.mqG);
        localObject1 = this.mqG;
        localEditVerifyCodeView = aa.f(this.mqG);
        paramDialogInterface = localObject2;
        if (localEditVerifyCodeView != null) {
          paramDialogInterface = localEditVerifyCodeView.getText();
        }
        aa.a((aa)localObject1, String.valueOf(paramDialogInterface));
        AppMethodBeat.o(148190);
        return;
      }
      paramDialogInterface = aa.f(this.mqG);
      if (paramDialogInterface != null)
      {
        paramDialogInterface = paramDialogInterface.getText();
        if (paramDialogInterface == null) {}
      }
      for (paramDialogInterface = Integer.valueOf(paramDialogInterface.length());; paramDialogInterface = null)
      {
        if (paramDialogInterface == null) {
          p.gkB();
        }
        if (paramDialogInterface.intValue() >= 6) {
          break;
        }
        ae.e("MicroMsg.PhoneNumberVerifyCodeDialog", "code is length is < 6");
        com.tencent.mm.plugin.appbrand.utils.l.a(this.mqG.context, this.mqG.context.getString(2131755450), this.mqG.context.getString(2131755442), (DialogInterface.OnClickListener)aa.m.1.mqP);
        AppMethodBeat.o(148190);
        return;
      }
      localObject1 = aa.f(this.mqG);
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
        p.gkB();
      }
      if (paramDialogInterface.intValue() == 0)
      {
        ae.e("MicroMsg.PhoneNumberVerifyCodeDialog", "code is empty");
        com.tencent.mm.plugin.appbrand.utils.l.a(this.mqG.context, this.mqG.context.getString(2131755449), this.mqG.context.getString(2131755442), (DialogInterface.OnClickListener)aa.m.2.mqQ);
      }
      AppMethodBeat.o(148190);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class n
    implements DialogInterface.OnClickListener
  {
    n(aa paramaa) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(148191);
      ae.i("MicroMsg.PhoneNumberVerifyCodeDialog", "cancel to verify sms");
      paramDialogInterface.dismiss();
      aa.d(this.mqG);
      aa.b(this.mqG, "user cancel");
      aa.e(this.mqG);
      AppMethodBeat.o(148191);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$updateSendText$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "arg0", "Landroid/view/View;", "luggage-wechat-full-sdk_release"})
  public static final class o
    extends ClickableSpan
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(148192);
      p.h(paramView, "arg0");
      ae.i("MicroMsg.PhoneNumberVerifyCodeDialog", "click the resend spanBuilder, do resend sms");
      if (this.mqG.mqD.moL)
      {
        aa.a(this.mqG);
        AppMethodBeat.o(148192);
        return;
      }
      ae.e("MicroMsg.PhoneNumberVerifyCodeDialog", "allow_send_sms is false, show send_verify_code_frequent error");
      paramView = this.mqG;
      String str = this.mqG.context.getString(2131755446);
      p.g(str, "context.getString(R.stri…end_verify_code_frequent)");
      aa.c(paramView, str);
      AppMethodBeat.o(148192);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.aa
 * JD-Core Version:    0.7.0.1
 */