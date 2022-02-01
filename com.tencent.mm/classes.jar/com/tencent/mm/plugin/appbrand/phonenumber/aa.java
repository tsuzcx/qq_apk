package com.tencent.mm.plugin.appbrand.phonenumber;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.k;
import com.tencent.mm.plugin.appbrand.widget.sms.EditVerifyCodeView;
import com.tencent.mm.protocal.protobuf.dan;
import com.tencent.mm.protocal.protobuf.yi;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.a.b;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.v;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog;", "", "context", "Landroid/content/Context;", "appId", "", "report", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReportAction;", "ext_desc", "phoneItem", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "onVerifyCallback", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$OnVerifyCallback;", "(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReportAction;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$OnVerifyCallback;)V", "INTERVAL_UPDATE_TIME", "", "MAX_WAIT_TIME", "getAppId", "()Ljava/lang/String;", "getContext", "()Landroid/content/Context;", "getExt_desc", "mobileTV", "Landroid/widget/TextView;", "getOnVerifyCallback", "()Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$OnVerifyCallback;", "getPhoneItem", "()Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "getReport", "()Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReportAction;", "setReport", "(Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReportAction;)V", "sendCodeTV", "smsEditView", "Lcom/tencent/mm/plugin/appbrand/widget/sms/EditVerifyCodeView;", "verifyCodeView", "Landroid/view/View;", "verifyTime", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$VertifyTimer;", "doFailCallback", "", "errMsg", "doSendVerifyCode", "isFirst", "", "doSuccessCallback", "encryptedData", "iv", "cloudId", "doVerifyCode", "code", "handleCheckVerifyCodeStatus", "status", "handleSendVerifyCodeStatus", "hideVKB", "showErrorTips", "showVKB", "showVerifyMobileDialog", "startSmsListener", "stopSmsListener", "tryShow", "updateSendText", "Companion", "OnVerifyCallback", "VertifyTimer", "luggage-wechat-full-sdk_release"})
public final class aa
{
  public static final aa.a mlI;
  private final int MAX_WAIT_TIME;
  private final String appId;
  final Context context;
  private TextView jaK;
  private EditVerifyCodeView mlA;
  private TextView mlB;
  private aa.c mlC;
  private final int mlD;
  y mlE;
  private final String mlF;
  final PhoneItem mlG;
  private final aa.b mlH;
  private View mlz;
  
  static
  {
    AppMethodBeat.i(148199);
    mlI = new aa.a((byte)0);
    AppMethodBeat.o(148199);
  }
  
  public aa(Context paramContext, String paramString1, y paramy, String paramString2, PhoneItem paramPhoneItem, aa.b paramb)
  {
    AppMethodBeat.i(169657);
    this.context = paramContext;
    this.appId = paramString1;
    this.mlE = paramy;
    this.mlF = paramString2;
    this.mlG = paramPhoneItem;
    this.mlH = paramb;
    this.MAX_WAIT_TIME = 60000;
    this.mlD = 1000;
    paramContext = this.context.getSystemService("layout_inflater");
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.view.LayoutInflater");
      AppMethodBeat.o(169657);
      throw paramContext;
    }
    this.mlz = ((LayoutInflater)paramContext).inflate(2131493071, null);
    paramContext = this.mlz;
    if (paramContext != null)
    {
      paramContext = (EditVerifyCodeView)paramContext.findViewById(2131296839);
      this.mlA = paramContext;
      paramContext = this.mlz;
      if (paramContext == null) {
        break label209;
      }
      paramContext = (TextView)paramContext.findViewById(2131296840);
      label169:
      this.jaK = paramContext;
      paramContext = this.mlz;
      if (paramContext == null) {
        break label214;
      }
    }
    label209:
    label214:
    for (paramContext = (TextView)paramContext.findViewById(2131296832);; paramContext = null)
    {
      this.mlB = paramContext;
      AppMethodBeat.o(169657);
      return;
      paramContext = null;
      break;
      paramContext = null;
      break label169;
    }
  }
  
  private final void TW(String paramString)
  {
    AppMethodBeat.i(148197);
    bwB();
    k.b(this.context, paramString, "", (DialogInterface.OnClickListener)new aa.j(this));
    AppMethodBeat.o(148197);
  }
  
  private final void bwA()
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
    localObject2 = this.mlB;
    if (localObject2 != null) {
      ((TextView)localObject2).setText((CharSequence)localObject1);
    }
    localObject1 = this.mlB;
    if (localObject1 != null)
    {
      ((TextView)localObject1).setMovementMethod(LinkMovementMethod.getInstance());
      AppMethodBeat.o(148193);
      return;
    }
    AppMethodBeat.o(148193);
  }
  
  private final void bwB()
  {
    AppMethodBeat.i(148194);
    ad.i("MicroMsg.PhoneNumberVerifyCodeDialog", "stopSmsListener");
    aa.c localc = this.mlC;
    if (localc != null)
    {
      localc.cancel();
      AppMethodBeat.o(148194);
      return;
    }
    AppMethodBeat.o(148194);
  }
  
  final void ht(final boolean paramBoolean)
  {
    AppMethodBeat.i(148195);
    ad.i("MicroMsg.PhoneNumberVerifyCodeDialog", "doSendVerifyCode");
    final ProgressDialog localProgressDialog = k.b(this.context, (CharSequence)this.context.getString(2131756031));
    if (this.mlG.mjP)
    {
      new f(this.appId, this.mlG.dzn).y((b)new d(this, localProgressDialog, paramBoolean));
      AppMethodBeat.o(148195);
      return;
    }
    new e(this.appId, this.mlG.dzn).y((b)new e(this, localProgressDialog, paramBoolean));
    AppMethodBeat.o(148195);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "resp", "Lcom/tencent/mm/protocal/protobuf/SendVerifyCodeResp;", "invoke"})
  static final class d
    extends q
    implements b<dan, z>
  {
    d(aa paramaa, ProgressDialog paramProgressDialog, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "resp", "Lcom/tencent/mm/protocal/protobuf/SendVerifyCodeResp;", "invoke"})
  static final class e
    extends q
    implements b<dan, z>
  {
    e(aa paramaa, ProgressDialog paramProgressDialog, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "resp", "Lcom/tencent/mm/protocal/protobuf/CheckVerifyCodeResp;", "invoke"})
  static final class f
    extends q
    implements b<yi, z>
  {
    f(aa paramaa, ProgressDialog paramProgressDialog)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "resp", "Lcom/tencent/mm/protocal/protobuf/CheckVerifyCodeResp;", "invoke"})
  static final class g
    extends q
    implements b<yi, z>
  {
    g(aa paramaa, ProgressDialog paramProgressDialog)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class i
    implements Runnable
  {
    i(aa paramaa) {}
    
    public final void run()
    {
      AppMethodBeat.i(148182);
      u localu = u.mkv;
      u.bwy().jdMethod_do(this.mlJ.context);
      AppMethodBeat.o(148182);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class k
    implements Runnable
  {
    k(aa paramaa) {}
    
    public final void run()
    {
      AppMethodBeat.i(148184);
      u localu = u.mkv;
      u.bwy().dp(this.mlJ.context);
      AppMethodBeat.o(148184);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$updateSendText$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "arg0", "Landroid/view/View;", "luggage-wechat-full-sdk_release"})
  public static final class o
    extends ClickableSpan
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(148192);
      p.h(paramView, "arg0");
      ad.i("MicroMsg.PhoneNumberVerifyCodeDialog", "click the resend spanBuilder, do resend sms");
      if (this.mlJ.mlG.mjO)
      {
        aa.a(this.mlJ);
        AppMethodBeat.o(148192);
        return;
      }
      ad.e("MicroMsg.PhoneNumberVerifyCodeDialog", "allow_send_sms is false, show send_verify_code_frequent error");
      paramView = this.mlJ;
      String str = this.mlJ.context.getString(2131755446);
      p.g(str, "context.getString(R.stri…end_verify_code_frequent)");
      aa.c(paramView, str);
      AppMethodBeat.o(148192);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.aa
 * JD-Core Version:    0.7.0.1
 */