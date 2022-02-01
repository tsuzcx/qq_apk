package com.tencent.mm.plugin.appbrand.phonenumber;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
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
import com.tencent.mm.protocal.protobuf.cpu;
import com.tencent.mm.protocal.protobuf.vz;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.a.b;
import d.v;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog;", "", "context", "Landroid/content/Context;", "appId", "", "report", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReportAction;", "ext_desc", "phoneItem", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "onVerifyCallback", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$OnVerifyCallback;", "(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReportAction;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$OnVerifyCallback;)V", "INTERVAL_UPDATE_TIME", "", "MAX_WAIT_TIME", "getAppId", "()Ljava/lang/String;", "getContext", "()Landroid/content/Context;", "getExt_desc", "mobileTV", "Landroid/widget/TextView;", "getOnVerifyCallback", "()Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$OnVerifyCallback;", "getPhoneItem", "()Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "getReport", "()Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReportAction;", "setReport", "(Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReportAction;)V", "sendCodeTV", "smsEditView", "Lcom/tencent/mm/plugin/appbrand/widget/sms/EditVerifyCodeView;", "verifyCodeView", "Landroid/view/View;", "verifyTime", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$VertifyTimer;", "doFailCallback", "", "errMsg", "doSendVerifyCode", "isFirst", "", "doSuccessCallback", "encryptedData", "iv", "cloudId", "doVerifyCode", "code", "handleCheckVerifyCodeStatus", "status", "handleSendVerifyCodeStatus", "hideVKB", "showErrorTips", "showVKB", "showVerifyMobileDialog", "startSmsListener", "stopSmsListener", "tryShow", "updateSendText", "Companion", "OnVerifyCallback", "VertifyTimer", "luggage-wechat-full-sdk_release"})
public final class aa
{
  public static final aa.a lme;
  private final int MAX_WAIT_TIME;
  private final String appId;
  final Context context;
  private TextView iht;
  private View llU;
  private EditVerifyCodeView llV;
  private TextView llW;
  private c llX;
  private final int llZ;
  y lma;
  private final String lmb;
  final PhoneItem lmc;
  private final aa.b lmd;
  
  static
  {
    AppMethodBeat.i(148199);
    lme = new aa.a((byte)0);
    AppMethodBeat.o(148199);
  }
  
  public aa(Context paramContext, String paramString1, y paramy, String paramString2, PhoneItem paramPhoneItem, aa.b paramb)
  {
    AppMethodBeat.i(169657);
    this.context = paramContext;
    this.appId = paramString1;
    this.lma = paramy;
    this.lmb = paramString2;
    this.lmc = paramPhoneItem;
    this.lmd = paramb;
    this.MAX_WAIT_TIME = 60000;
    this.llZ = 1000;
    paramContext = this.context.getSystemService("layout_inflater");
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.view.LayoutInflater");
      AppMethodBeat.o(169657);
      throw paramContext;
    }
    this.llU = ((LayoutInflater)paramContext).inflate(2131493071, null);
    paramContext = this.llU;
    if (paramContext != null)
    {
      paramContext = (EditVerifyCodeView)paramContext.findViewById(2131296839);
      this.llV = paramContext;
      paramContext = this.llU;
      if (paramContext == null) {
        break label209;
      }
      paramContext = (TextView)paramContext.findViewById(2131296840);
      label169:
      this.iht = paramContext;
      paramContext = this.llU;
      if (paramContext == null) {
        break label214;
      }
    }
    label209:
    label214:
    for (paramContext = (TextView)paramContext.findViewById(2131296832);; paramContext = null)
    {
      this.llW = paramContext;
      AppMethodBeat.o(169657);
      return;
      paramContext = null;
      break;
      paramContext = null;
      break label169;
    }
  }
  
  private final void Mp(String paramString)
  {
    AppMethodBeat.i(148197);
    blH();
    com.tencent.mm.plugin.appbrand.utils.k.b(this.context, paramString, "", (DialogInterface.OnClickListener)new aa.j(this));
    AppMethodBeat.o(148197);
  }
  
  private final void blG()
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
    localObject2 = this.llW;
    if (localObject2 != null) {
      ((TextView)localObject2).setText((CharSequence)localObject1);
    }
    localObject1 = this.llW;
    if (localObject1 != null)
    {
      ((TextView)localObject1).setMovementMethod(LinkMovementMethod.getInstance());
      AppMethodBeat.o(148193);
      return;
    }
    AppMethodBeat.o(148193);
  }
  
  private final void blH()
  {
    AppMethodBeat.i(148194);
    ad.i("MicroMsg.PhoneNumberVerifyCodeDialog", "stopSmsListener");
    c localc = this.llX;
    if (localc != null)
    {
      localc.cancel();
      AppMethodBeat.o(148194);
      return;
    }
    AppMethodBeat.o(148194);
  }
  
  final void gS(final boolean paramBoolean)
  {
    AppMethodBeat.i(148195);
    ad.i("MicroMsg.PhoneNumberVerifyCodeDialog", "doSendVerifyCode");
    final ProgressDialog localProgressDialog = com.tencent.mm.plugin.appbrand.utils.k.b(this.context, (CharSequence)this.context.getString(2131756031));
    if (this.lmc.lkh)
    {
      new f(this.appId, this.lmc.dpO).t((b)new d(this, localProgressDialog, paramBoolean));
      AppMethodBeat.o(148195);
      return;
    }
    new e(this.appId, this.lmc.dpO).t((b)new e(this, localProgressDialog, paramBoolean));
    AppMethodBeat.o(148195);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$VertifyTimer;", "Landroid/os/CountDownTimer;", "millisInFuture", "", "countDownInterval", "(Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog;JJ)V", "onFinish", "", "onTick", "millisUntilFinished", "luggage-wechat-full-sdk_release"})
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
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "resp", "Lcom/tencent/mm/protocal/protobuf/SendVerifyCodeResp;", "invoke"})
  static final class d
    extends d.g.b.l
    implements b<cpu, d.y>
  {
    d(aa paramaa, ProgressDialog paramProgressDialog, boolean paramBoolean)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "resp", "Lcom/tencent/mm/protocal/protobuf/SendVerifyCodeResp;", "invoke"})
  static final class e
    extends d.g.b.l
    implements b<cpu, d.y>
  {
    e(aa paramaa, ProgressDialog paramProgressDialog, boolean paramBoolean)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "resp", "Lcom/tencent/mm/protocal/protobuf/CheckVerifyCodeResp;", "invoke"})
  static final class f
    extends d.g.b.l
    implements b<vz, d.y>
  {
    f(aa paramaa, ProgressDialog paramProgressDialog)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "resp", "Lcom/tencent/mm/protocal/protobuf/CheckVerifyCodeResp;", "invoke"})
  static final class g
    extends d.g.b.l
    implements b<vz, d.y>
  {
    g(aa paramaa, ProgressDialog paramProgressDialog)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class i
    implements Runnable
  {
    i(aa paramaa) {}
    
    public final void run()
    {
      AppMethodBeat.i(148182);
      u localu = u.lkN;
      u.blE().dh(this.lmf.context);
      AppMethodBeat.o(148182);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class k
    implements Runnable
  {
    k(aa paramaa) {}
    
    public final void run()
    {
      AppMethodBeat.i(148184);
      u localu = u.lkN;
      u.blE().di(this.lmf.context);
      AppMethodBeat.o(148184);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$updateSendText$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "arg0", "Landroid/view/View;", "luggage-wechat-full-sdk_release"})
  public static final class o
    extends ClickableSpan
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(148192);
      d.g.b.k.h(paramView, "arg0");
      ad.i("MicroMsg.PhoneNumberVerifyCodeDialog", "click the resend spanBuilder, do resend sms");
      if (this.lmf.lmc.lkg)
      {
        aa.a(this.lmf);
        AppMethodBeat.o(148192);
        return;
      }
      ad.e("MicroMsg.PhoneNumberVerifyCodeDialog", "allow_send_sms is false, show send_verify_code_frequent error");
      paramView = this.lmf;
      String str = this.lmf.context.getString(2131755446);
      d.g.b.k.g(str, "context.getString(R.stri…end_verify_code_frequent)");
      aa.c(paramView, str);
      AppMethodBeat.o(148192);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.aa
 * JD-Core Version:    0.7.0.1
 */