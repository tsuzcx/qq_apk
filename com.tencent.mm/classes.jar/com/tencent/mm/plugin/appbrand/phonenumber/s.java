package com.tencent.mm.plugin.appbrand.phonenumber;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import com.tencent.luggage.m.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.q;
import com.tencent.mm.protocal.protobuf.acd;
import com.tencent.mm.protocal.protobuf.eyg;
import com.tencent.mm.protocal.protobuf.fsk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.a.e.a;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberAddLogic;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberAddLogic;", "mContext", "Landroid/content/Context;", "mAppId", "", "onDone", "Lkotlin/Function0;", "", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "mPhoneNumberAddView", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberAddView;", "getView", "Landroid/view/View;", "init", "sendSms", "mobile", "sendSmsInner", "showErrorTips", "errMsg", "uninit", "verifyCode", "isCheck", "", "code", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class s
  implements l
{
  private static final String TAG;
  public static final s.a tGS;
  private final String mAppId;
  private final Context mContext;
  private final a<ah> tGT;
  private m tGU;
  
  static
  {
    AppMethodBeat.i(148104);
    tGS = new s.a((byte)0);
    TAG = "PhoneNumberAddLogic";
    AppMethodBeat.o(148104);
  }
  
  public s(Context paramContext, String paramString, a<ah> parama)
  {
    AppMethodBeat.i(148103);
    this.mContext = paramContext;
    this.mAppId = paramString;
    this.tGT = parama;
    AppMethodBeat.o(148103);
  }
  
  private static final void a(s params, String paramString, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(318895);
    kotlin.g.b.s.u(params, "this$0");
    kotlin.g.b.s.u(paramString, "$mobile");
    Log.i(TAG, "sendSms appId:" + params.mAppId + ", mobile:" + paramString);
    paramDialogInterface = params.tGU;
    if (paramDialogInterface != null) {
      paramDialogInterface.cHv();
    }
    final com.tencent.mm.ui.widget.a.m localm = com.tencent.mm.ui.widget.a.m.b(params.mContext, (CharSequence)params.mContext.getString(a.g.appbrand_phone_number_verify_code_sending), true);
    y localy = z.tIm.afD(params.mAppId);
    if (localy != null)
    {
      paramDialogInterface = z.tIm.afD(params.mAppId);
      if (paramDialogInterface != null) {
        break label172;
      }
    }
    label172:
    for (paramDialogInterface = null;; paramDialogInterface = Long.valueOf(paramDialogInterface.tHX))
    {
      kotlin.g.b.s.checkNotNull(paramDialogInterface);
      localy.tHX = (paramDialogInterface.longValue() + 1L);
      new e(params.mAppId, paramString).Z((kotlin.g.a.b)new b(params, localm));
      AppMethodBeat.o(318895);
      return;
    }
  }
  
  private final void afy(String paramString)
  {
    AppMethodBeat.i(318886);
    q.b(this.mContext, paramString, this.mContext.getString(a.g.app_brand_get_phone_number_ok), s..ExternalSyntheticLambda1.INSTANCE);
    AppMethodBeat.o(318886);
  }
  
  private static final void f(DialogInterface paramDialogInterface, int paramInt) {}
  
  private static final void g(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(318915);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(318915);
  }
  
  public final void afv(String paramString)
  {
    AppMethodBeat.i(148100);
    kotlin.g.b.s.u(paramString, "mobile");
    if (!Util.isNullOrNil(paramString))
    {
      Context localContext = this.mContext;
      String str1 = kotlin.g.b.s.X(this.mContext.getString(a.g.app_brand_get_phone_number_verify_sms_msg), paramString);
      String str2 = this.mContext.getString(a.g.app_brand_get_phone_number_verify_sms_confirm_phone);
      String str3 = this.mContext.getString(a.g.appbrand_request_accept);
      String str4 = this.mContext.getString(a.g.appbrand_request_reject);
      paramString = new s..ExternalSyntheticLambda0(this, paramString);
      s..ExternalSyntheticLambda2 localExternalSyntheticLambda2 = s..ExternalSyntheticLambda2.INSTANCE;
      new e.a(localContext).bDv(str2).bDw(str1).bDC(str3).c(paramString).bDD(str4).d(localExternalSyntheticLambda2).jHH().show();
      AppMethodBeat.o(148100);
      return;
    }
    paramString = this.mContext.getString(a.g.appbrand_phone_number_format_err_title);
    kotlin.g.b.s.s(paramString, "mContext.getString(R.str…_number_format_err_title)");
    afy(paramString);
    AppMethodBeat.o(148100);
  }
  
  public final void b(final boolean paramBoolean, final String paramString1, String paramString2)
  {
    y localy2 = null;
    y localy1 = null;
    AppMethodBeat.i(148101);
    kotlin.g.b.s.u(paramString1, "mobile");
    kotlin.g.b.s.u(paramString2, "code");
    y localy3 = z.tIm.afD(this.mAppId);
    if (localy3 != null)
    {
      localObject = z.tIm.afD(this.mAppId);
      if (localObject == null)
      {
        localObject = null;
        kotlin.g.b.s.checkNotNull(localObject);
        localy3.tIa = (((Long)localObject).longValue() + 1L);
      }
    }
    else
    {
      if (!paramBoolean) {
        break label270;
      }
      localy2 = z.tIm.afD(this.mAppId);
      if (localy2 != null)
      {
        localObject = z.tIm.afD(this.mAppId);
        if (localObject != null) {
          break label257;
        }
        localObject = localy1;
        label121:
        kotlin.g.b.s.checkNotNull(localObject);
        localy2.tId = (((Long)localObject).longValue() + 1L);
      }
    }
    label257:
    label270:
    do
    {
      Log.i(TAG, "verifyCode mAppId:" + this.mAppId + ", mobile:" + paramString1 + " code:" + paramString2);
      localObject = com.tencent.mm.ui.widget.a.m.b(this.mContext, (CharSequence)this.mContext.getString(a.g.appbrand_phone_number_verify_code_verifying), true);
      new b(this.mAppId, paramString1, paramString2).Z((kotlin.g.a.b)new c(this, paramBoolean, paramString1, (ProgressDialog)localObject));
      AppMethodBeat.o(148101);
      return;
      localObject = Long.valueOf(((y)localObject).tIa);
      break;
      localObject = Long.valueOf(((y)localObject).tId);
      break label121;
      localy1 = z.tIm.afD(this.mAppId);
    } while (localy1 == null);
    Object localObject = z.tIm.afD(this.mAppId);
    if (localObject == null) {}
    for (localObject = localy2;; localObject = Long.valueOf(((y)localObject).tIe))
    {
      kotlin.g.b.s.checkNotNull(localObject);
      localy1.tIe = (((Long)localObject).longValue() + 1L);
      break;
    }
  }
  
  public final View getView()
  {
    AppMethodBeat.i(148099);
    Object localObject = this.tGU;
    if (localObject == null)
    {
      AppMethodBeat.o(148099);
      return null;
    }
    localObject = ((m)localObject).getView();
    AppMethodBeat.o(148099);
    return localObject;
  }
  
  public final void init()
  {
    AppMethodBeat.i(148098);
    this.tGU = ((m)new t(this.mContext, (l)this));
    z.tIm.afC(this.mAppId);
    AppMethodBeat.o(148098);
  }
  
  public final void uninit()
  {
    AppMethodBeat.i(148102);
    m localm = this.tGU;
    if (localm != null) {
      localm.reset();
    }
    z.tIm.afB(this.mAppId);
    AppMethodBeat.o(148102);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/SendVerifyCodeResp;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<eyg, ah>
  {
    b(s params, ProgressDialog paramProgressDialog)
    {
      super();
    }
    
    private static final void a(eyg parameyg, s params)
    {
      Object localObject1 = null;
      y localy1 = null;
      y localy2 = null;
      Object localObject2 = null;
      AppMethodBeat.i(318983);
      kotlin.g.b.s.u(params, "this$0");
      int i = parameyg.status;
      parameyg = h.tGf;
      if (i == h.cHl())
      {
        localy1 = z.tIm.afD(s.a(params));
        if (localy1 != null)
        {
          parameyg = z.tIm.afD(s.a(params));
          if (parameyg == null) {}
          for (parameyg = localObject2;; parameyg = Long.valueOf(parameyg.tHY))
          {
            kotlin.g.b.s.checkNotNull(parameyg);
            localy1.tHY = (parameyg.longValue() + 1L);
            AppMethodBeat.o(318983);
            return;
          }
        }
      }
      else
      {
        parameyg = h.tGf;
        if (i == h.cHm())
        {
          localy1 = z.tIm.afD(s.a(params));
          if (localy1 != null)
          {
            parameyg = z.tIm.afD(s.a(params));
            if (parameyg != null) {
              break label188;
            }
          }
          label188:
          for (parameyg = localObject1;; parameyg = Long.valueOf(parameyg.tHZ))
          {
            kotlin.g.b.s.checkNotNull(parameyg);
            localy1.tHZ = (parameyg.longValue() + 1L);
            parameyg = s.b(params).getString(a.g.app_brand_get_phone_number_send_verify_code_fail);
            kotlin.g.b.s.s(parameyg, "mContext.getString(R.str…er_send_verify_code_fail)");
            s.a(params, parameyg);
            AppMethodBeat.o(318983);
            return;
          }
        }
        parameyg = h.tGf;
        if (i == h.cHn())
        {
          localy2 = z.tIm.afD(s.a(params));
          if (localy2 != null)
          {
            parameyg = z.tIm.afD(s.a(params));
            if (parameyg != null) {
              break label287;
            }
          }
          label287:
          for (parameyg = localy1;; parameyg = Long.valueOf(parameyg.tHZ))
          {
            kotlin.g.b.s.checkNotNull(parameyg);
            localy2.tHZ = (parameyg.longValue() + 1L);
            parameyg = s.b(params).getString(a.g.app_brand_get_phone_number_send_verify_code_frequent);
            kotlin.g.b.s.s(parameyg, "mContext.getString(R.str…end_verify_code_frequent)");
            s.a(params, parameyg);
            AppMethodBeat.o(318983);
            return;
          }
        }
        localy1 = z.tIm.afD(s.a(params));
        if (localy1 != null)
        {
          parameyg = z.tIm.afD(s.a(params));
          if (parameyg != null) {
            break label373;
          }
        }
      }
      label373:
      for (parameyg = localy2;; parameyg = Long.valueOf(parameyg.tHZ))
      {
        kotlin.g.b.s.checkNotNull(parameyg);
        localy1.tHZ = (parameyg.longValue() + 1L);
        parameyg = s.b(params).getString(a.g.app_brand_get_phone_number_send_verify_code_fail);
        kotlin.g.b.s.s(parameyg, "mContext.getString(R.str…er_send_verify_code_fail)");
        s.a(params, parameyg);
        AppMethodBeat.o(318983);
        return;
      }
    }
    
    private static final void c(ProgressDialog paramProgressDialog)
    {
      AppMethodBeat.i(318994);
      paramProgressDialog.dismiss();
      AppMethodBeat.o(318994);
    }
    
    private static final void d(s params)
    {
      AppMethodBeat.i(318990);
      kotlin.g.b.s.u(params, "this$0");
      y localy = z.tIm.afD(s.a(params));
      if (localy != null)
      {
        localObject = z.tIm.afD(s.a(params));
        if (localObject != null) {
          break label85;
        }
      }
      label85:
      for (Object localObject = null;; localObject = Long.valueOf(((y)localObject).tHZ))
      {
        kotlin.g.b.s.checkNotNull(localObject);
        localy.tHZ = (((Long)localObject).longValue() + 1L);
        localObject = s.b(params).getString(a.g.app_brand_get_phone_number_send_verify_code_fail);
        kotlin.g.b.s.s(localObject, "mContext.getString(R.str…er_send_verify_code_fail)");
        s.a(params, (String)localObject);
        AppMethodBeat.o(318990);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/CheckVerifyCodeResp;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<acd, ah>
  {
    c(s params, boolean paramBoolean, String paramString, ProgressDialog paramProgressDialog)
    {
      super();
    }
    
    private static final void a(final acd paramacd, final s params, boolean paramBoolean, String paramString)
    {
      final String str1 = null;
      Object localObject1 = null;
      Object localObject2 = null;
      final String str2 = null;
      AppMethodBeat.i(318987);
      kotlin.g.b.s.u(params, "this$0");
      kotlin.g.b.s.u(paramString, "$mobile");
      int i = paramacd.status;
      Object localObject3 = h.tGf;
      if (i == h.cHo())
      {
        localObject2 = z.tIm.afD(s.a(params));
        if (localObject2 != null)
        {
          localObject1 = z.tIm.afD(s.a(params));
          if (localObject1 != null) {
            break label204;
          }
        }
        label204:
        for (localObject1 = str2;; localObject1 = Long.valueOf(((y)localObject1).tIb))
        {
          kotlin.g.b.s.checkNotNull(localObject1);
          ((y)localObject2).tIb = (((Long)localObject1).longValue() + 1L);
          str1 = paramacd.tGK;
          str2 = paramacd.dbg;
          localObject3 = paramacd.ZkD;
          localObject2 = paramacd.tGL;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localObject2 = paramacd.data;
          paramacd = (acd)localObject2;
          if (localObject2 == null) {
            paramacd = "";
          }
          if (!paramBoolean) {
            break;
          }
          new g(s.a(params), paramString, 0).Z((kotlin.g.a.b)new a(paramString, (String)localObject3, str1, str2, (String)localObject1, paramacd, params));
          AppMethodBeat.o(318987);
          return;
        }
        localObject2 = r.tGQ;
        kotlin.g.b.s.s(localObject3, "showMobile");
        kotlin.g.b.s.s(str1, "encryptedData");
        kotlin.g.b.s.s(str2, "iv");
        r.d(new PhoneItem(paramString, (String)localObject3, str1, str2, (String)localObject1, paramacd));
        s.c(params).invoke();
        AppMethodBeat.o(318987);
        return;
      }
      paramacd = h.tGf;
      if (i == h.cHp())
      {
        paramString = z.tIm.afD(s.a(params));
        if (paramString != null)
        {
          paramacd = z.tIm.afD(s.a(params));
          if (paramacd != null) {
            break label366;
          }
        }
        label366:
        for (paramacd = str1;; paramacd = Long.valueOf(paramacd.tIc))
        {
          kotlin.g.b.s.checkNotNull(paramacd);
          paramString.tIc = (paramacd.longValue() + 1L);
          paramacd = s.b(params).getString(a.g.app_brand_get_phone_number_send_verify_code_frequent);
          kotlin.g.b.s.s(paramacd, "mContext.getString(R.str…end_verify_code_frequent)");
          s.a(params, paramacd);
          AppMethodBeat.o(318987);
          return;
        }
      }
      paramacd = h.tGf;
      if (i == h.cHq())
      {
        paramString = z.tIm.afD(s.a(params));
        if (paramString != null)
        {
          paramacd = z.tIm.afD(s.a(params));
          if (paramacd != null) {
            break label464;
          }
        }
        label464:
        for (paramacd = (acd)localObject1;; paramacd = Long.valueOf(paramacd.tIc))
        {
          kotlin.g.b.s.checkNotNull(paramacd);
          paramString.tIc = (paramacd.longValue() + 1L);
          paramacd = s.b(params).getString(a.g.app_brand_get_phone_number_verify_code_error);
          kotlin.g.b.s.s(paramacd, "mContext.getString(R.str…number_verify_code_error)");
          s.a(params, paramacd);
          AppMethodBeat.o(318987);
          return;
        }
      }
      paramString = z.tIm.afD(s.a(params));
      if (paramString != null)
      {
        paramacd = z.tIm.afD(s.a(params));
        if (paramacd != null) {
          break label550;
        }
      }
      label550:
      for (paramacd = (acd)localObject2;; paramacd = Long.valueOf(paramacd.tIc))
      {
        kotlin.g.b.s.checkNotNull(paramacd);
        paramString.tIc = (paramacd.longValue() + 1L);
        paramacd = s.b(params).getString(a.g.app_brand_get_phone_number_verify_code_fail);
        kotlin.g.b.s.s(paramacd, "mContext.getString(R.str…_number_verify_code_fail)");
        s.a(params, paramacd);
        AppMethodBeat.o(318987);
        return;
      }
    }
    
    private static final void c(ProgressDialog paramProgressDialog)
    {
      AppMethodBeat.i(318995);
      paramProgressDialog.dismiss();
      AppMethodBeat.o(318995);
    }
    
    private static final void d(s params)
    {
      AppMethodBeat.i(318992);
      kotlin.g.b.s.u(params, "this$0");
      y localy = z.tIm.afD(s.a(params));
      if (localy != null)
      {
        localObject = z.tIm.afD(s.a(params));
        if (localObject != null) {
          break label85;
        }
      }
      label85:
      for (Object localObject = null;; localObject = Long.valueOf(((y)localObject).tIc))
      {
        kotlin.g.b.s.checkNotNull(localObject);
        localy.tIc = (((Long)localObject).longValue() + 1L);
        localObject = s.b(params).getString(a.g.app_brand_get_phone_number_verify_code_fail);
        kotlin.g.b.s.s(localObject, "mContext.getString(R.str…_number_verify_code_fail)");
        s.a(params, (String)localObject);
        AppMethodBeat.o(318992);
        return;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "resp", "Lcom/tencent/mm/protocal/protobuf/UpdateUserPhoneResp;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.b<fsk, ah>
    {
      a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, s params)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.s
 * JD-Core Version:    0.7.0.1
 */