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
import com.tencent.mm.protocal.protobuf.dul;
import com.tencent.mm.protocal.protobuf.zz;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog;", "", "context", "Landroid/content/Context;", "appId", "", "report", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReportAction;", "ext_desc", "phoneItem", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "onVerifyCallback", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$OnVerifyCallback;", "(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReportAction;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$OnVerifyCallback;)V", "INTERVAL_UPDATE_TIME", "", "MAX_WAIT_TIME", "getAppId", "()Ljava/lang/String;", "getContext", "()Landroid/content/Context;", "getExt_desc", "mobileTV", "Landroid/widget/TextView;", "getOnVerifyCallback", "()Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$OnVerifyCallback;", "getPhoneItem", "()Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "getReport", "()Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReportAction;", "setReport", "(Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReportAction;)V", "sendCodeTV", "smsEditView", "Lcom/tencent/mm/plugin/appbrand/widget/sms/EditVerifyCodeView;", "verifyCodeView", "Landroid/view/View;", "verifyTime", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$VertifyTimer;", "doFailCallback", "", "errMsg", "doSendVerifyCode", "isFirst", "", "doSuccessCallback", "encryptedData", "iv", "cloudId", "doVerifyCode", "code", "handleCheckVerifyCodeStatus", "status", "handleSendVerifyCodeStatus", "hideVKB", "showErrorTips", "showVKB", "showVerifyMobileDialog", "startSmsListener", "stopSmsListener", "tryShow", "updateSendText", "Companion", "OnVerifyCallback", "VertifyTimer", "luggage-wechat-full-sdk_release"})
public final class aa
{
  public static final aa.a nBr;
  private final int MAX_WAIT_TIME;
  private final String appId;
  final Context context;
  private TextView kbG;
  private View nBi;
  private EditVerifyCodeView nBj;
  private TextView nBk;
  private c nBl;
  private final int nBm;
  y nBn;
  private final String nBo;
  final PhoneItem nBp;
  private final aa.b nBq;
  
  static
  {
    AppMethodBeat.i(148199);
    nBr = new aa.a((byte)0);
    AppMethodBeat.o(148199);
  }
  
  public aa(Context paramContext, String paramString1, y paramy, String paramString2, PhoneItem paramPhoneItem, aa.b paramb)
  {
    AppMethodBeat.i(169657);
    this.context = paramContext;
    this.appId = paramString1;
    this.nBn = paramy;
    this.nBo = paramString2;
    this.nBp = paramPhoneItem;
    this.nBq = paramb;
    this.MAX_WAIT_TIME = 60000;
    this.nBm = 1000;
    paramContext = this.context.getSystemService("layout_inflater");
    if (paramContext == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.view.LayoutInflater");
      AppMethodBeat.o(169657);
      throw paramContext;
    }
    this.nBi = ((LayoutInflater)paramContext).inflate(2131493111, null);
    paramContext = this.nBi;
    if (paramContext != null)
    {
      paramContext = (EditVerifyCodeView)paramContext.findViewById(2131296931);
      this.nBj = paramContext;
      paramContext = this.nBi;
      if (paramContext == null) {
        break label209;
      }
      paramContext = (TextView)paramContext.findViewById(2131296932);
      label169:
      this.kbG = paramContext;
      paramContext = this.nBi;
      if (paramContext == null) {
        break label214;
      }
    }
    label209:
    label214:
    for (paramContext = (TextView)paramContext.findViewById(2131296916);; paramContext = null)
    {
      this.nBk = paramContext;
      AppMethodBeat.o(169657);
      return;
      paramContext = null;
      break;
      paramContext = null;
      break label169;
    }
  }
  
  private final void aeu(String paramString)
  {
    AppMethodBeat.i(148197);
    bTC();
    com.tencent.mm.plugin.appbrand.utils.l.c(this.context, paramString, "", (DialogInterface.OnClickListener)new aa.j(this));
    AppMethodBeat.o(148197);
  }
  
  private final void bTB()
  {
    AppMethodBeat.i(148193);
    Object localObject2 = this.context.getString(2131755479);
    p.g(localObject2, "context.getString(R.stri…_not_receive_verify_code)");
    String str = this.context.getString(2131755482);
    p.g(str, "context.getString(R.stri…umber_resend_verify_code)");
    Object localObject1 = new SpannableStringBuilder();
    ((SpannableStringBuilder)localObject1).append((CharSequence)localObject2);
    ((SpannableStringBuilder)localObject1).append((CharSequence)str);
    int i = ((String)localObject2).length();
    int j = str.length();
    ((SpannableStringBuilder)localObject1).setSpan(new o(this), i, i + j, 17);
    ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(this.context.getResources().getColor(2131099783)), i, j + i, 17);
    localObject2 = this.nBk;
    if (localObject2 != null) {
      ((TextView)localObject2).setText((CharSequence)localObject1);
    }
    localObject1 = this.nBk;
    if (localObject1 != null)
    {
      ((TextView)localObject1).setMovementMethod(LinkMovementMethod.getInstance());
      AppMethodBeat.o(148193);
      return;
    }
    AppMethodBeat.o(148193);
  }
  
  private final void bTC()
  {
    AppMethodBeat.i(148194);
    Log.i("MicroMsg.PhoneNumberVerifyCodeDialog", "stopSmsListener");
    c localc = this.nBl;
    if (localc != null)
    {
      localc.cancel();
      AppMethodBeat.o(148194);
      return;
    }
    AppMethodBeat.o(148194);
  }
  
  final void iv(final boolean paramBoolean)
  {
    AppMethodBeat.i(148195);
    Log.i("MicroMsg.PhoneNumberVerifyCodeDialog", "doSendVerifyCode");
    final ProgressDialog localProgressDialog = com.tencent.mm.plugin.appbrand.utils.l.b(this.context, (CharSequence)this.context.getString(2131756146));
    if (this.nBp.nzy)
    {
      new f(this.appId, this.nBp.dSf).y((b)new d(this, localProgressDialog, paramBoolean));
      AppMethodBeat.o(148195);
      return;
    }
    new e(this.appId, this.nBp.dSf).y((b)new e(this, localProgressDialog, paramBoolean));
    AppMethodBeat.o(148195);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$VertifyTimer;", "Landroid/os/CountDownTimer;", "millisInFuture", "", "countDownInterval", "(Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog;JJ)V", "onFinish", "", "onTick", "millisUntilFinished", "luggage-wechat-full-sdk_release"})
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
        localTextView.setText((CharSequence)aa.this.context.getString(2131755481, new Object[] { paramLong / 1000L }));
        AppMethodBeat.o(148166);
        return;
      }
      AppMethodBeat.o(148166);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "resp", "Lcom/tencent/mm/protocal/protobuf/SendVerifyCodeResp;", "invoke"})
  static final class d
    extends q
    implements b<dul, x>
  {
    d(aa paramaa, ProgressDialog paramProgressDialog, boolean paramBoolean)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "resp", "Lcom/tencent/mm/protocal/protobuf/SendVerifyCodeResp;", "invoke"})
  static final class e
    extends q
    implements b<dul, x>
  {
    e(aa paramaa, ProgressDialog paramProgressDialog, boolean paramBoolean)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "resp", "Lcom/tencent/mm/protocal/protobuf/CheckVerifyCodeResp;", "invoke"})
  static final class f
    extends q
    implements b<zz, x>
  {
    f(aa paramaa, ProgressDialog paramProgressDialog)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "resp", "Lcom/tencent/mm/protocal/protobuf/CheckVerifyCodeResp;", "invoke"})
  static final class g
    extends q
    implements b<zz, x>
  {
    g(aa paramaa, ProgressDialog paramProgressDialog)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$updateSendText$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "arg0", "Landroid/view/View;", "luggage-wechat-full-sdk_release"})
  public static final class o
    extends ClickableSpan
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(148192);
      p.h(paramView, "arg0");
      Log.i("MicroMsg.PhoneNumberVerifyCodeDialog", "click the resend spanBuilder, do resend sms");
      if (this.nBs.nBp.nzx)
      {
        aa.a(this.nBs);
        AppMethodBeat.o(148192);
        return;
      }
      Log.e("MicroMsg.PhoneNumberVerifyCodeDialog", "allow_send_sms is false, show send_verify_code_frequent error");
      paramView = this.nBs;
      String str = this.nBs.context.getString(2131755484);
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