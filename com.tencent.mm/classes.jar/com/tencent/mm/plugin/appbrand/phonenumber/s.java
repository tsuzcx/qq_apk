package com.tencent.mm.plugin.appbrand.phonenumber;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.luggage.l.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.n;
import com.tencent.mm.protocal.protobuf.aad;
import com.tencent.mm.protocal.protobuf.eep;
import com.tencent.mm.protocal.protobuf.ewr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberAddLogic;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberAddLogic;", "mContext", "Landroid/content/Context;", "mAppId", "", "onDone", "Lkotlin/Function0;", "", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "mPhoneNumberAddView", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberAddView;", "getView", "Landroid/view/View;", "init", "sendSms", "mobile", "sendSmsInner", "showErrorTips", "errMsg", "uninit", "verifyCode", "isCheck", "", "code", "Companion", "luggage-wechat-full-sdk_release"})
public final class s
  implements l
{
  private static final String TAG = "PhoneNumberAddLogic";
  public static final s.a qBQ;
  private final String mAppId;
  private final Context mContext;
  private m qBO;
  private final a<x> qBP;
  
  static
  {
    AppMethodBeat.i(148104);
    qBQ = new s.a((byte)0);
    TAG = "PhoneNumberAddLogic";
    AppMethodBeat.o(148104);
  }
  
  public s(Context paramContext, String paramString, a<x> parama)
  {
    AppMethodBeat.i(148103);
    this.mContext = paramContext;
    this.mAppId = paramString;
    this.qBP = parama;
    AppMethodBeat.o(148103);
  }
  
  private final void amo(String paramString)
  {
    AppMethodBeat.i(246775);
    n.b(this.mContext, paramString, this.mContext.getString(a.g.app_brand_get_phone_number_ok), (DialogInterface.OnClickListener)s.e.qBX);
    AppMethodBeat.o(246775);
  }
  
  public final void amm(final String paramString)
  {
    AppMethodBeat.i(148100);
    p.k(paramString, "mobile");
    if (!Util.isNullOrNil(paramString))
    {
      n.a(this.mContext, this.mContext.getString(a.g.app_brand_get_phone_number_verify_sms_msg) + paramString, this.mContext.getString(a.g.app_brand_get_phone_number_verify_sms_confirm_phone), this.mContext.getString(a.g.appbrand_request_accept), this.mContext.getString(a.g.appbrand_request_reject), (DialogInterface.OnClickListener)new b(this, paramString), (DialogInterface.OnClickListener)s.c.qBT);
      AppMethodBeat.o(148100);
      return;
    }
    paramString = this.mContext.getString(a.g.appbrand_phone_number_format_err_title);
    p.j(paramString, "mContext.getString(R.str…_number_format_err_title)");
    amo(paramString);
    AppMethodBeat.o(148100);
  }
  
  public final void c(final boolean paramBoolean, final String paramString1, String paramString2)
  {
    y localy2 = null;
    y localy1 = null;
    AppMethodBeat.i(148101);
    p.k(paramString1, "mobile");
    p.k(paramString2, "code");
    y localy3 = z.qDr.amr(this.mAppId);
    Object localObject;
    if (localy3 != null)
    {
      localObject = z.qDr.amr(this.mAppId);
      if (localObject != null)
      {
        localObject = Long.valueOf(((y)localObject).qDd);
        if (localObject == null) {
          p.iCn();
        }
        localy3.qDd = (((Long)localObject).longValue() + 1L);
      }
    }
    else
    {
      if (!paramBoolean) {
        break label272;
      }
      localy2 = z.qDr.amr(this.mAppId);
      if (localy2 != null)
      {
        localy3 = z.qDr.amr(this.mAppId);
        localObject = localy1;
        if (localy3 != null) {
          localObject = Long.valueOf(localy3.qDg);
        }
        if (localObject == null) {
          p.iCn();
        }
        localy2.qDg = (((Long)localObject).longValue() + 1L);
      }
    }
    for (;;)
    {
      Log.i(TAG, "verifyCode mAppId:" + this.mAppId + ", mobile:" + paramString1 + " code:" + paramString2);
      localObject = n.b(this.mContext, (CharSequence)this.mContext.getString(a.g.appbrand_phone_number_verify_code_verifying));
      new b(this.mAppId, paramString1, paramString2).y((kotlin.g.a.b)new f(this, paramBoolean, paramString1, (ProgressDialog)localObject));
      AppMethodBeat.o(148101);
      return;
      localObject = null;
      break;
      label272:
      localy1 = z.qDr.amr(this.mAppId);
      if (localy1 != null)
      {
        localy3 = z.qDr.amr(this.mAppId);
        localObject = localy2;
        if (localy3 != null) {
          localObject = Long.valueOf(localy3.qDh);
        }
        if (localObject == null) {
          p.iCn();
        }
        localy1.qDh = (((Long)localObject).longValue() + 1L);
      }
    }
  }
  
  public final View getView()
  {
    AppMethodBeat.i(148099);
    Object localObject = this.qBO;
    if (localObject != null)
    {
      localObject = ((m)localObject).getView();
      AppMethodBeat.o(148099);
      return localObject;
    }
    AppMethodBeat.o(148099);
    return null;
  }
  
  public final void init()
  {
    AppMethodBeat.i(148098);
    this.qBO = ((m)new t(this.mContext, (l)this));
    z.qDr.amq(this.mAppId);
    AppMethodBeat.o(148098);
  }
  
  public final void uninit()
  {
    AppMethodBeat.i(148102);
    m localm = this.qBO;
    if (localm != null) {
      localm.reset();
    }
    z.qDr.amp(this.mAppId);
    AppMethodBeat.o(148102);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class b
    implements DialogInterface.OnClickListener
  {
    b(s params, String paramString) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(148085);
      s.a(this.qBR, paramString);
      AppMethodBeat.o(148085);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/SendVerifyCodeResp;", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.b<eep, x>
  {
    d(s params, ProgressDialog paramProgressDialog)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/CheckVerifyCodeResp;", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.b<aad, x>
  {
    f(s params, boolean paramBoolean, String paramString, ProgressDialog paramProgressDialog)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.s
 * JD-Core Version:    0.7.0.1
 */