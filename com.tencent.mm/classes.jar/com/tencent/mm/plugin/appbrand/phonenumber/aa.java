package com.tencent.mm.plugin.appbrand.phonenumber;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.CountDownTimer;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.luggage.m.a.a;
import com.tencent.luggage.m.a.d;
import com.tencent.luggage.m.a.e;
import com.tencent.luggage.m.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.q;
import com.tencent.mm.plugin.appbrand.widget.sms.EditVerifyCodeView;
import com.tencent.mm.protocal.protobuf.acd;
import com.tencent.mm.protocal.protobuf.eyg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.ui.widget.a.m;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog;", "", "context", "Landroid/content/Context;", "appId", "", "report", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReportAction;", "ext_desc", "phoneItem", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "onVerifyCallback", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$OnVerifyCallback;", "(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReportAction;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$OnVerifyCallback;)V", "INTERVAL_UPDATE_TIME", "", "MAX_WAIT_TIME", "getAppId", "()Ljava/lang/String;", "getContext", "()Landroid/content/Context;", "getExt_desc", "mobileTV", "Landroid/widget/TextView;", "getOnVerifyCallback", "()Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$OnVerifyCallback;", "getPhoneItem", "()Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "getReport", "()Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReportAction;", "setReport", "(Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReportAction;)V", "sendCodeTV", "smsEditView", "Lcom/tencent/mm/plugin/appbrand/widget/sms/EditVerifyCodeView;", "verifyCodeView", "Landroid/view/View;", "verifyTime", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$VertifyTimer;", "doFailCallback", "", "errMsg", "doSendVerifyCode", "isFirst", "", "doSuccessCallback", "encryptedData", "iv", "cloudId", "data", "doVerifyCode", "code", "handleCheckVerifyCodeStatus", "status", "handleSendVerifyCodeStatus", "hideVKB", "showErrorTips", "showVKB", "showVerifyMobileDialog", "startSmsListener", "stopSmsListener", "tryShow", "updateSendText", "Companion", "OnVerifyCallback", "VertifyTimer", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aa
{
  public static final aa.a tIq;
  private final int MAX_WAIT_TIME;
  private final String appId;
  final Context context;
  private TextView pPL;
  y tIr;
  private final String tIs;
  final PhoneItem tIt;
  private final aa.b tIu;
  private View tIv;
  private EditVerifyCodeView tIw;
  private TextView tIx;
  private c tIy;
  private final int tIz;
  
  static
  {
    AppMethodBeat.i(148199);
    tIq = new aa.a((byte)0);
    AppMethodBeat.o(148199);
  }
  
  public aa(Context paramContext, String paramString1, y paramy, String paramString2, PhoneItem paramPhoneItem, aa.b paramb)
  {
    AppMethodBeat.i(169657);
    this.context = paramContext;
    this.appId = paramString1;
    this.tIr = paramy;
    this.tIs = paramString2;
    this.tIt = paramPhoneItem;
    this.tIu = paramb;
    this.MAX_WAIT_TIME = 60000;
    this.tIz = 1000;
    paramContext = this.context.getSystemService("layout_inflater");
    if (paramContext == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type android.view.LayoutInflater");
      AppMethodBeat.o(169657);
      throw paramContext;
    }
    this.tIv = ((LayoutInflater)paramContext).inflate(a.e.app_brand_verify_sms_code, null);
    paramContext = this.tIv;
    if (paramContext == null)
    {
      paramContext = null;
      this.tIw = paramContext;
      paramContext = this.tIv;
      if (paramContext != null) {
        break label199;
      }
      paramContext = null;
      label157:
      this.pPL = paramContext;
      paramContext = this.tIv;
      if (paramContext != null) {
        break label213;
      }
    }
    label199:
    label213:
    for (paramContext = localObject;; paramContext = (TextView)paramContext.findViewById(a.d.app_brand_repeat_send))
    {
      this.tIx = paramContext;
      AppMethodBeat.o(169657);
      return;
      paramContext = (EditVerifyCodeView)paramContext.findViewById(a.d.app_brand_verify_code_view);
      break;
      paramContext = (TextView)paramContext.findViewById(a.d.app_brand_verify_mobile);
      break label157;
    }
  }
  
  private static final void a(aa paramaa, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(319067);
    s.u(paramaa, "this$0");
    Log.i("MicroMsg.PhoneNumberVerifyCodeDialog", "cancel to verify sms");
    paramaa.cHF();
    paramaa.hideVKB();
    AppMethodBeat.o(319067);
  }
  
  private static final void a(final aa paramaa, DialogInterface paramDialogInterface, int paramInt)
  {
    y localy = null;
    Object localObject2 = null;
    AppMethodBeat.i(319082);
    s.u(paramaa, "this$0");
    Object localObject1 = paramaa.tIw;
    if (localObject1 == null)
    {
      localObject1 = null;
      Log.i("MicroMsg.PhoneNumberVerifyCodeDialog", "to verify sms %s", new Object[] { localObject1 });
      localObject1 = paramaa.tIw;
      if (localObject1 == null) {
        break label238;
      }
      localObject1 = ((EditVerifyCodeView)localObject1).getText();
      if ((localObject1 == null) || (((String)localObject1).length() != 6)) {
        break label238;
      }
      paramInt = 1;
      label76:
      if (paramInt == 0) {
        break label303;
      }
      paramDialogInterface.dismiss();
      paramaa.cHF();
      paramaa.hideVKB();
      paramDialogInterface = paramaa.tIw;
      if (paramDialogInterface != null) {
        break label243;
      }
      paramDialogInterface = null;
      label105:
      localObject1 = String.valueOf(paramDialogInterface);
      Log.i("MicroMsg.PhoneNumberVerifyCodeDialog", "doVerifyCode");
      localy = paramaa.tIr;
      if (localy != null)
      {
        paramDialogInterface = paramaa.tIr;
        if (paramDialogInterface != null) {
          break label251;
        }
      }
    }
    label238:
    label243:
    label251:
    for (paramDialogInterface = localObject2;; paramDialogInterface = Long.valueOf(paramDialogInterface.tIj))
    {
      s.checkNotNull(paramDialogInterface);
      localy.tIj = (paramDialogInterface.longValue() + 1L);
      paramDialogInterface = m.b(paramaa.context, (CharSequence)paramaa.context.getString(a.g.appbrand_phone_number_verify_code_verifying), true);
      if (!paramaa.tIt.tGO) {
        break label262;
      }
      new c(paramaa.appId, paramaa.tIt.hRk, (String)localObject1).Z((kotlin.g.a.b)new f(paramDialogInterface, paramaa));
      AppMethodBeat.o(319082);
      return;
      localObject1 = ((EditVerifyCodeView)localObject1).getText();
      break;
      paramInt = 0;
      break label76;
      paramDialogInterface = paramDialogInterface.getText();
      break label105;
    }
    label262:
    new b(paramaa.appId, paramaa.tIt.hRk, (String)localObject1).Z((kotlin.g.a.b)new g(paramDialogInterface, paramaa));
    AppMethodBeat.o(319082);
    return;
    label303:
    paramDialogInterface = paramaa.tIw;
    if (paramDialogInterface == null) {
      paramDialogInterface = null;
    }
    for (;;)
    {
      s.checkNotNull(paramDialogInterface);
      if (paramDialogInterface.intValue() >= 6) {
        break;
      }
      Log.e("MicroMsg.PhoneNumberVerifyCodeDialog", "code is length is < 6");
      q.b(paramaa.context, paramaa.context.getString(a.g.app_brand_get_phone_number_verify_code_error_format), paramaa.context.getString(a.g.app_brand_get_phone_number_ok), aa..ExternalSyntheticLambda5.INSTANCE);
      AppMethodBeat.o(319082);
      return;
      paramDialogInterface = paramDialogInterface.getText();
      if (paramDialogInterface == null) {
        paramDialogInterface = null;
      } else {
        paramDialogInterface = Integer.valueOf(paramDialogInterface.length());
      }
    }
    paramDialogInterface = paramaa.tIw;
    if (paramDialogInterface == null) {
      paramDialogInterface = localy;
    }
    for (;;)
    {
      s.checkNotNull(paramDialogInterface);
      if (paramDialogInterface.intValue() == 0)
      {
        Log.e("MicroMsg.PhoneNumberVerifyCodeDialog", "code is empty");
        q.b(paramaa.context, paramaa.context.getString(a.g.app_brand_get_phone_number_verify_code_error_empty), paramaa.context.getString(a.g.app_brand_get_phone_number_ok), aa..ExternalSyntheticLambda4.INSTANCE);
      }
      AppMethodBeat.o(319082);
      return;
      localObject1 = paramDialogInterface.getText();
      paramDialogInterface = localy;
      if (localObject1 != null) {
        paramDialogInterface = Integer.valueOf(((String)localObject1).length());
      }
    }
  }
  
  private final void afF(String paramString)
  {
    AppMethodBeat.i(319038);
    HashMap localHashMap = new HashMap();
    ((Map)localHashMap).put("errMsg", paramString);
    paramString = this.tIu;
    if (paramString != null) {
      paramString.a(false, (Map)localHashMap);
    }
    AppMethodBeat.o(319038);
  }
  
  private final void afy(String paramString)
  {
    AppMethodBeat.i(148197);
    cHF();
    q.c(this.context, paramString, "", new aa..ExternalSyntheticLambda2(this));
    AppMethodBeat.o(148197);
  }
  
  private static final void b(aa paramaa)
  {
    AppMethodBeat.i(319085);
    s.u(paramaa, "this$0");
    u localu = u.tHm;
    u.cHB().eF(paramaa.context);
    AppMethodBeat.o(319085);
  }
  
  private static final void b(aa paramaa, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(319084);
    s.u(paramaa, "this$0");
    Log.i("MicroMsg.PhoneNumberVerifyCodeDialog", "cancel to verify sms");
    paramDialogInterface.dismiss();
    paramaa.cHF();
    paramaa.afF("user cancel");
    paramaa.hideVKB();
    AppMethodBeat.o(319084);
  }
  
  private static final void c(aa paramaa)
  {
    AppMethodBeat.i(319086);
    s.u(paramaa, "this$0");
    u localu = u.tHm;
    u.cHB().eE(paramaa.context);
    AppMethodBeat.o(319086);
  }
  
  private static final void c(aa paramaa, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(319087);
    s.u(paramaa, "this$0");
    paramDialogInterface.dismiss();
    paramaa.afF("fail");
    AppMethodBeat.o(319087);
  }
  
  private final void cHD()
  {
    AppMethodBeat.i(319045);
    Object localObject = this.tIw;
    if (localObject != null) {
      ((EditVerifyCodeView)localObject).setText("");
    }
    localObject = this.pPL;
    if (localObject != null) {
      ((TextView)localObject).setText((CharSequence)this.context.getString(a.g.app_brand_get_phone_number_verify_mobile, new Object[] { this.tIt.tGJ }));
    }
    cHE();
    if (this.tIv != null)
    {
      localObject = this.tIv;
      if (localObject == null)
      {
        localObject = null;
        if (!(localObject instanceof ViewGroup)) {
          break label152;
        }
        localObject = this.tIv;
        if (localObject != null) {
          break label133;
        }
      }
      label133:
      for (localObject = null;; localObject = ((View)localObject).getParent())
      {
        if (localObject != null) {
          break label141;
        }
        localObject = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(319045);
        throw ((Throwable)localObject);
        localObject = ((View)localObject).getParent();
        break;
      }
      label141:
      ((ViewGroup)localObject).removeView(this.tIv);
    }
    label152:
    localObject = new e.a(this.context).bDv(this.context.getString(a.g.app_brand_get_phone_number_verify_sms_title)).me(this.tIv).jHH();
    ((com.tencent.mm.ui.widget.a.e)localObject).setOnDismissListener(new aa..ExternalSyntheticLambda6(this));
    ((com.tencent.mm.ui.widget.a.e)localObject).a((CharSequence)this.context.getString(a.g.appbrand_request_accept), false, new aa..ExternalSyntheticLambda1(this));
    ((com.tencent.mm.ui.widget.a.e)localObject).b((CharSequence)this.context.getString(a.g.appbrand_request_reject), true, new aa..ExternalSyntheticLambda0(this));
    ((com.tencent.mm.ui.widget.a.e)localObject).show();
    localObject = this.tIv;
    if (localObject != null) {
      ((View)localObject).post(new aa..ExternalSyntheticLambda8(this));
    }
    AppMethodBeat.o(319045);
  }
  
  private final void cHE()
  {
    AppMethodBeat.i(148193);
    Object localObject2 = this.context.getString(a.g.app_brand_get_phone_number_not_receive_verify_code);
    s.s(localObject2, "context.getString(R.stri…_not_receive_verify_code)");
    String str = this.context.getString(a.g.app_brand_get_phone_number_resend_verify_code);
    s.s(str, "context.getString(R.stri…umber_resend_verify_code)");
    Object localObject1 = new SpannableStringBuilder();
    ((SpannableStringBuilder)localObject1).append((CharSequence)localObject2);
    ((SpannableStringBuilder)localObject1).append((CharSequence)str);
    int i = ((String)localObject2).length();
    int j = str.length();
    ((SpannableStringBuilder)localObject1).setSpan(new h(this), i, i + j, 17);
    ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(this.context.getResources().getColor(a.a.Link)), i, j + i, 17);
    localObject2 = this.tIx;
    if (localObject2 != null) {
      ((TextView)localObject2).setText((CharSequence)localObject1);
    }
    localObject1 = this.tIx;
    if (localObject1 != null) {
      ((TextView)localObject1).setMovementMethod(LinkMovementMethod.getInstance());
    }
    AppMethodBeat.o(148193);
  }
  
  private final void cHF()
  {
    AppMethodBeat.i(148194);
    Log.i("MicroMsg.PhoneNumberVerifyCodeDialog", "stopSmsListener");
    c localc = this.tIy;
    if (localc != null) {
      localc.cancel();
    }
    AppMethodBeat.o(148194);
  }
  
  private static final void d(aa paramaa, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(319088);
    s.u(paramaa, "this$0");
    paramDialogInterface.dismiss();
    Log.e("MicroMsg.PhoneNumberVerifyCodeDialog", "verify code is error, do send the right code");
    paramaa.cHD();
    AppMethodBeat.o(319088);
  }
  
  private static final void h(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(319070);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(319070);
  }
  
  private final void hideVKB()
  {
    AppMethodBeat.i(319046);
    View localView = this.tIv;
    if (localView != null) {
      localView.post(new aa..ExternalSyntheticLambda7(this));
    }
    AppMethodBeat.o(319046);
  }
  
  private static final void i(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(319074);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(319074);
  }
  
  final void kG(final boolean paramBoolean)
  {
    AppMethodBeat.i(148195);
    Log.i("MicroMsg.PhoneNumberVerifyCodeDialog", "doSendVerifyCode");
    final m localm = m.b(this.context, (CharSequence)this.context.getString(a.g.appbrand_phone_number_verify_code_sending), true);
    if (this.tIt.tGO)
    {
      new f(this.appId, this.tIt.hRk).Z((kotlin.g.a.b)new d(localm, this, paramBoolean));
      AppMethodBeat.o(148195);
      return;
    }
    new e(this.appId, this.tIt.hRk).Z((kotlin.g.a.b)new e(this, localm, paramBoolean));
    AppMethodBeat.o(148195);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$VertifyTimer;", "Landroid/os/CountDownTimer;", "millisInFuture", "", "countDownInterval", "(Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog;JJ)V", "onFinish", "", "onTick", "millisUntilFinished", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
    extends CountDownTimer
  {
    public c(long paramLong)
    {
      super(localObject);
      AppMethodBeat.i(318831);
      AppMethodBeat.o(318831);
    }
    
    public final void onFinish()
    {
      AppMethodBeat.i(148167);
      aa.e(aa.this);
      AppMethodBeat.o(148167);
    }
    
    public final void onTick(long paramLong)
    {
      AppMethodBeat.i(148166);
      TextView localTextView = aa.d(aa.this);
      if (localTextView != null) {
        localTextView.setText((CharSequence)aa.this.context.getString(a.g.app_brand_get_phone_number_repeat_send_after_second, new Object[] { s.X("", Long.valueOf(paramLong / 1000L)) }));
      }
      AppMethodBeat.o(148166);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "resp", "Lcom/tencent/mm/protocal/protobuf/SendVerifyCodeResp;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements kotlin.g.a.b<eyg, ah>
  {
    d(ProgressDialog paramProgressDialog, aa paramaa, boolean paramBoolean)
    {
      super();
    }
    
    private static final void a(boolean paramBoolean, aa paramaa, eyg parameyg)
    {
      AppMethodBeat.i(318842);
      s.u(paramaa, "this$0");
      s.u(parameyg, "$resp");
      if (paramBoolean) {
        aa.f(paramaa);
      }
      aa.a(paramaa, parameyg.status);
      AppMethodBeat.o(318842);
    }
    
    private static final void g(aa paramaa)
    {
      AppMethodBeat.i(318836);
      s.u(paramaa, "this$0");
      h localh = h.tGf;
      aa.a(paramaa, h.cHk());
      AppMethodBeat.o(318836);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "resp", "Lcom/tencent/mm/protocal/protobuf/SendVerifyCodeResp;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.g.b.u
    implements kotlin.g.a.b<eyg, ah>
  {
    e(aa paramaa, ProgressDialog paramProgressDialog, boolean paramBoolean)
    {
      super();
    }
    
    private static final void b(boolean paramBoolean, aa paramaa, eyg parameyg)
    {
      AppMethodBeat.i(318858);
      s.u(paramaa, "this$0");
      if (paramBoolean) {
        aa.f(paramaa);
      }
      aa.a(paramaa, parameyg.status);
      AppMethodBeat.o(318858);
    }
    
    private static final void d(ProgressDialog paramProgressDialog)
    {
      AppMethodBeat.i(318844);
      paramProgressDialog.dismiss();
      AppMethodBeat.o(318844);
    }
    
    private static final void h(aa paramaa)
    {
      AppMethodBeat.i(318852);
      s.u(paramaa, "this$0");
      h localh = h.tGf;
      aa.a(paramaa, h.cHk());
      AppMethodBeat.o(318852);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "resp", "Lcom/tencent/mm/protocal/protobuf/CheckVerifyCodeResp;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.g.b.u
    implements kotlin.g.a.b<acd, ah>
  {
    f(ProgressDialog paramProgressDialog, aa paramaa)
    {
      super();
    }
    
    private static final void a(aa paramaa, acd paramacd)
    {
      AppMethodBeat.i(318851);
      s.u(paramaa, "this$0");
      s.u(paramacd, "$resp");
      aa.a(paramaa, paramacd.status, paramacd.tGK, paramacd.dbg, paramacd.tGL, paramacd.data);
      AppMethodBeat.o(318851);
    }
    
    private static final void g(aa paramaa)
    {
      AppMethodBeat.i(318843);
      s.u(paramaa, "this$0");
      h localh = h.tGf;
      aa.a(paramaa, h.cHk(), "", "", "", "");
      AppMethodBeat.o(318843);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "resp", "Lcom/tencent/mm/protocal/protobuf/CheckVerifyCodeResp;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.g.b.u
    implements kotlin.g.a.b<acd, ah>
  {
    g(ProgressDialog paramProgressDialog, aa paramaa)
    {
      super();
    }
    
    private static final void a(aa paramaa, acd paramacd)
    {
      AppMethodBeat.i(318847);
      s.u(paramaa, "this$0");
      aa.a(paramaa, paramacd.status, paramacd.tGK, paramacd.dbg, paramacd.tGL, paramacd.data);
      AppMethodBeat.o(318847);
    }
    
    private static final void g(aa paramaa)
    {
      AppMethodBeat.i(318841);
      s.u(paramaa, "this$0");
      h localh = h.tGf;
      aa.a(paramaa, h.cHk(), "", "", "", "");
      AppMethodBeat.o(318841);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$updateSendText$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "arg0", "Landroid/view/View;", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    extends ClickableSpan
  {
    h(aa paramaa) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(148192);
      s.u(paramView, "arg0");
      Log.i("MicroMsg.PhoneNumberVerifyCodeDialog", "click the resend spanBuilder, do resend sms");
      if (this.tIA.tIt.tGN)
      {
        aa.a(this.tIA);
        AppMethodBeat.o(148192);
        return;
      }
      Log.e("MicroMsg.PhoneNumberVerifyCodeDialog", "allow_send_sms is false, show send_verify_code_frequent error");
      paramView = this.tIA;
      String str = this.tIA.context.getString(a.g.app_brand_get_phone_number_send_verify_code_frequent);
      s.s(str, "context.getString(R.stri…end_verify_code_frequent)");
      aa.a(paramView, str);
      AppMethodBeat.o(148192);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.aa
 * JD-Core Version:    0.7.0.1
 */