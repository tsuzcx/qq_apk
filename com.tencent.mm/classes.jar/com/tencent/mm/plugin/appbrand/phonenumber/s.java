package com.tencent.mm.plugin.appbrand.phonenumber;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cpu;
import com.tencent.mm.protocal.protobuf.dgk;
import com.tencent.mm.protocal.protobuf.vz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.a.a;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberAddLogic;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberAddLogic;", "mContext", "Landroid/content/Context;", "mAppId", "", "onDone", "Lkotlin/Function0;", "", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "mPhoneNumberAddView", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberAddView;", "getView", "Landroid/view/View;", "init", "sendSms", "mobile", "sendSmsInner", "showErrorTips", "errMsg", "uninit", "verifyCode", "isCheck", "", "code", "Companion", "luggage-wechat-full-sdk_release"})
public final class s
  implements l
{
  private static final String TAG = "PhoneNumberAddLogic";
  public static final s.a lko;
  private m lkm;
  private final a<d.y> lkn;
  private final String mAppId;
  private final Context mContext;
  
  static
  {
    AppMethodBeat.i(148104);
    lko = new s.a((byte)0);
    TAG = "PhoneNumberAddLogic";
    AppMethodBeat.o(148104);
  }
  
  public s(Context paramContext, String paramString, a<d.y> parama)
  {
    AppMethodBeat.i(148103);
    this.mContext = paramContext;
    this.mAppId = paramString;
    this.lkn = parama;
    AppMethodBeat.o(148103);
  }
  
  public final void Mj(String paramString)
  {
    AppMethodBeat.i(148100);
    d.g.b.k.h(paramString, "mobile");
    if (!bt.isNullOrNil(paramString))
    {
      com.tencent.mm.plugin.appbrand.utils.k.a(this.mContext, this.mContext.getString(2131755454) + paramString, this.mContext.getString(2131755453), this.mContext.getString(2131756036), this.mContext.getString(2131756037), (DialogInterface.OnClickListener)new s.b(this, paramString), (DialogInterface.OnClickListener)s.c.lkr);
      AppMethodBeat.o(148100);
      return;
    }
    com.tencent.mm.plugin.appbrand.utils.k.t(this.mContext, this.mContext.getString(2131756020), this.mContext.getString(2131756021));
    AppMethodBeat.o(148100);
  }
  
  public final void a(final boolean paramBoolean, final String paramString1, String paramString2)
  {
    y localy2 = null;
    y localy1 = null;
    AppMethodBeat.i(148101);
    d.g.b.k.h(paramString1, "mobile");
    d.g.b.k.h(paramString2, "code");
    y localy3 = z.llS.Mn(this.mAppId);
    Object localObject;
    if (localy3 != null)
    {
      localObject = z.llS.Mn(this.mAppId);
      if (localObject != null)
      {
        localObject = Long.valueOf(((y)localObject).llE);
        if (localObject == null) {
          d.g.b.k.fvU();
        }
        localy3.llE = (((Long)localObject).longValue() + 1L);
      }
    }
    else
    {
      if (!paramBoolean) {
        break label269;
      }
      localy2 = z.llS.Mn(this.mAppId);
      if (localy2 != null)
      {
        localy3 = z.llS.Mn(this.mAppId);
        localObject = localy1;
        if (localy3 != null) {
          localObject = Long.valueOf(localy3.llH);
        }
        if (localObject == null) {
          d.g.b.k.fvU();
        }
        localy2.llH = (((Long)localObject).longValue() + 1L);
      }
    }
    for (;;)
    {
      ad.i(TAG, "verifyCode mAppId:" + this.mAppId + ", mobile:" + paramString1 + " code:" + paramString2);
      localObject = com.tencent.mm.plugin.appbrand.utils.k.b(this.mContext, (CharSequence)this.mContext.getString(2131756033));
      new b(this.mAppId, paramString1, paramString2).t((d.g.a.b)new f(this, paramBoolean, paramString1, (ProgressDialog)localObject));
      AppMethodBeat.o(148101);
      return;
      localObject = null;
      break;
      label269:
      localy1 = z.llS.Mn(this.mAppId);
      if (localy1 != null)
      {
        localy3 = z.llS.Mn(this.mAppId);
        localObject = localy2;
        if (localy3 != null) {
          localObject = Long.valueOf(localy3.llI);
        }
        if (localObject == null) {
          d.g.b.k.fvU();
        }
        localy1.llI = (((Long)localObject).longValue() + 1L);
      }
    }
  }
  
  public final View getView()
  {
    AppMethodBeat.i(148099);
    Object localObject = this.lkm;
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
    this.lkm = ((m)new t(this.mContext, (l)this));
    z.llS.Mm(this.mAppId);
    AppMethodBeat.o(148098);
  }
  
  public final void uninit()
  {
    AppMethodBeat.i(148102);
    m localm = this.lkm;
    if (localm != null) {
      localm.reset();
    }
    z.llS.Ml(this.mAppId);
    AppMethodBeat.o(148102);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/SendVerifyCodeResp;", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.b<cpu, d.y>
  {
    d(s params, ProgressDialog paramProgressDialog)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/CheckVerifyCodeResp;", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.b<vz, d.y>
  {
    f(s params, boolean paramBoolean, String paramString, ProgressDialog paramProgressDialog)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.s
 * JD-Core Version:    0.7.0.1
 */