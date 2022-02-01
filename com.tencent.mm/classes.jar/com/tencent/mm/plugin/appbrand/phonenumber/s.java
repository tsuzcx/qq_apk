package com.tencent.mm.plugin.appbrand.phonenumber;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dul;
import com.tencent.mm.protocal.protobuf.eml;
import com.tencent.mm.protocal.protobuf.zz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberAddLogic;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberAddLogic;", "mContext", "Landroid/content/Context;", "mAppId", "", "onDone", "Lkotlin/Function0;", "", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "mPhoneNumberAddView", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberAddView;", "getView", "Landroid/view/View;", "init", "sendSms", "mobile", "sendSmsInner", "showErrorTips", "errMsg", "uninit", "verifyCode", "isCheck", "", "code", "Companion", "luggage-wechat-full-sdk_release"})
public final class s
  implements l
{
  private static final String TAG = "PhoneNumberAddLogic";
  public static final s.a nzF;
  private final String mAppId;
  private final Context mContext;
  private m nzD;
  private final a<x> nzE;
  
  static
  {
    AppMethodBeat.i(148104);
    nzF = new s.a((byte)0);
    TAG = "PhoneNumberAddLogic";
    AppMethodBeat.o(148104);
  }
  
  public s(Context paramContext, String paramString, a<x> parama)
  {
    AppMethodBeat.i(148103);
    this.mContext = paramContext;
    this.mAppId = paramString;
    this.nzE = parama;
    AppMethodBeat.o(148103);
  }
  
  private final void aeu(String paramString)
  {
    AppMethodBeat.i(230147);
    com.tencent.mm.plugin.appbrand.utils.l.b(this.mContext, paramString, this.mContext.getString(2131755480), (DialogInterface.OnClickListener)s.e.nzM);
    AppMethodBeat.o(230147);
  }
  
  public final void aes(final String paramString)
  {
    AppMethodBeat.i(148100);
    p.h(paramString, "mobile");
    if (!Util.isNullOrNil(paramString))
    {
      com.tencent.mm.plugin.appbrand.utils.l.a(this.mContext, this.mContext.getString(2131755492) + paramString, this.mContext.getString(2131755491), this.mContext.getString(2131756151), this.mContext.getString(2131756152), (DialogInterface.OnClickListener)new b(this, paramString), (DialogInterface.OnClickListener)s.c.nzI);
      AppMethodBeat.o(148100);
      return;
    }
    paramString = this.mContext.getString(2131756136);
    p.g(paramString, "mContext.getString(R.str…_number_format_err_title)");
    aeu(paramString);
    AppMethodBeat.o(148100);
  }
  
  public final void b(final boolean paramBoolean, final String paramString1, String paramString2)
  {
    y localy2 = null;
    y localy1 = null;
    AppMethodBeat.i(148101);
    p.h(paramString1, "mobile");
    p.h(paramString2, "code");
    y localy3 = z.nBg.aex(this.mAppId);
    Object localObject;
    if (localy3 != null)
    {
      localObject = z.nBg.aex(this.mAppId);
      if (localObject != null)
      {
        localObject = Long.valueOf(((y)localObject).nAS);
        if (localObject == null) {
          p.hyc();
        }
        localy3.nAS = (((Long)localObject).longValue() + 1L);
      }
    }
    else
    {
      if (!paramBoolean) {
        break label272;
      }
      localy2 = z.nBg.aex(this.mAppId);
      if (localy2 != null)
      {
        localy3 = z.nBg.aex(this.mAppId);
        localObject = localy1;
        if (localy3 != null) {
          localObject = Long.valueOf(localy3.nAV);
        }
        if (localObject == null) {
          p.hyc();
        }
        localy2.nAV = (((Long)localObject).longValue() + 1L);
      }
    }
    for (;;)
    {
      Log.i(TAG, "verifyCode mAppId:" + this.mAppId + ", mobile:" + paramString1 + " code:" + paramString2);
      localObject = com.tencent.mm.plugin.appbrand.utils.l.b(this.mContext, (CharSequence)this.mContext.getString(2131756148));
      new b(this.mAppId, paramString1, paramString2).y((kotlin.g.a.b)new f(this, paramBoolean, paramString1, (ProgressDialog)localObject));
      AppMethodBeat.o(148101);
      return;
      localObject = null;
      break;
      label272:
      localy1 = z.nBg.aex(this.mAppId);
      if (localy1 != null)
      {
        localy3 = z.nBg.aex(this.mAppId);
        localObject = localy2;
        if (localy3 != null) {
          localObject = Long.valueOf(localy3.nAW);
        }
        if (localObject == null) {
          p.hyc();
        }
        localy1.nAW = (((Long)localObject).longValue() + 1L);
      }
    }
  }
  
  public final View getView()
  {
    AppMethodBeat.i(148099);
    Object localObject = this.nzD;
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
    this.nzD = ((m)new t(this.mContext, (l)this));
    z.nBg.aew(this.mAppId);
    AppMethodBeat.o(148098);
  }
  
  public final void uninit()
  {
    AppMethodBeat.i(148102);
    m localm = this.nzD;
    if (localm != null) {
      localm.reset();
    }
    z.nBg.aev(this.mAppId);
    AppMethodBeat.o(148102);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class b
    implements DialogInterface.OnClickListener
  {
    b(s params, String paramString) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(148085);
      s.a(this.nzG, paramString);
      AppMethodBeat.o(148085);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/SendVerifyCodeResp;", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.b<dul, x>
  {
    d(s params, ProgressDialog paramProgressDialog)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/CheckVerifyCodeResp;", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.b<zz, x>
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