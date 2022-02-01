package com.tencent.mm.plugin.appbrand.phonenumber;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dbh;
import com.tencent.mm.protocal.protobuf.dsn;
import com.tencent.mm.protocal.protobuf.yl;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberAddLogic;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberAddLogic;", "mContext", "Landroid/content/Context;", "mAppId", "", "onDone", "Lkotlin/Function0;", "", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "mPhoneNumberAddView", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberAddView;", "getView", "Landroid/view/View;", "init", "sendSms", "mobile", "sendSmsInner", "showErrorTips", "errMsg", "uninit", "verifyCode", "isCheck", "", "code", "Companion", "luggage-wechat-full-sdk_release"})
public final class s
  implements l
{
  private static final String TAG = "PhoneNumberAddLogic";
  public static final s.a moT;
  private final String mAppId;
  private final Context mContext;
  private m moR;
  private final a<d.z> moS;
  
  static
  {
    AppMethodBeat.i(148104);
    moT = new s.a((byte)0);
    TAG = "PhoneNumberAddLogic";
    AppMethodBeat.o(148104);
  }
  
  public s(Context paramContext, String paramString, a<d.z> parama)
  {
    AppMethodBeat.i(148103);
    this.mContext = paramContext;
    this.mAppId = paramString;
    this.moS = parama;
    AppMethodBeat.o(148103);
  }
  
  private final void UG(String paramString)
  {
    AppMethodBeat.i(221007);
    com.tencent.mm.plugin.appbrand.utils.l.a(this.mContext, paramString, this.mContext.getString(2131755442), (DialogInterface.OnClickListener)s.e.mpa);
    AppMethodBeat.o(221007);
  }
  
  public final void UE(final String paramString)
  {
    AppMethodBeat.i(148100);
    p.h(paramString, "mobile");
    if (!bu.isNullOrNil(paramString))
    {
      com.tencent.mm.plugin.appbrand.utils.l.a(this.mContext, this.mContext.getString(2131755454) + paramString, this.mContext.getString(2131755453), this.mContext.getString(2131756036), this.mContext.getString(2131756037), (DialogInterface.OnClickListener)new b(this, paramString), (DialogInterface.OnClickListener)s.c.moW);
      AppMethodBeat.o(148100);
      return;
    }
    paramString = this.mContext.getString(2131756021);
    p.g(paramString, "mContext.getString(R.str…_number_format_err_title)");
    UG(paramString);
    AppMethodBeat.o(148100);
  }
  
  public final void b(final boolean paramBoolean, final String paramString1, String paramString2)
  {
    y localy2 = null;
    y localy1 = null;
    AppMethodBeat.i(148101);
    p.h(paramString1, "mobile");
    p.h(paramString2, "code");
    y localy3 = z.mqu.UJ(this.mAppId);
    Object localObject;
    if (localy3 != null)
    {
      localObject = z.mqu.UJ(this.mAppId);
      if (localObject != null)
      {
        localObject = Long.valueOf(((y)localObject).mqg);
        if (localObject == null) {
          p.gkB();
        }
        localy3.mqg = (((Long)localObject).longValue() + 1L);
      }
    }
    else
    {
      if (!paramBoolean) {
        break label272;
      }
      localy2 = z.mqu.UJ(this.mAppId);
      if (localy2 != null)
      {
        localy3 = z.mqu.UJ(this.mAppId);
        localObject = localy1;
        if (localy3 != null) {
          localObject = Long.valueOf(localy3.mqj);
        }
        if (localObject == null) {
          p.gkB();
        }
        localy2.mqj = (((Long)localObject).longValue() + 1L);
      }
    }
    for (;;)
    {
      ae.i(TAG, "verifyCode mAppId:" + this.mAppId + ", mobile:" + paramString1 + " code:" + paramString2);
      localObject = com.tencent.mm.plugin.appbrand.utils.l.b(this.mContext, (CharSequence)this.mContext.getString(2131756033));
      new b(this.mAppId, paramString1, paramString2).y((d.g.a.b)new f(this, paramBoolean, paramString1, (ProgressDialog)localObject));
      AppMethodBeat.o(148101);
      return;
      localObject = null;
      break;
      label272:
      localy1 = z.mqu.UJ(this.mAppId);
      if (localy1 != null)
      {
        localy3 = z.mqu.UJ(this.mAppId);
        localObject = localy2;
        if (localy3 != null) {
          localObject = Long.valueOf(localy3.mqk);
        }
        if (localObject == null) {
          p.gkB();
        }
        localy1.mqk = (((Long)localObject).longValue() + 1L);
      }
    }
  }
  
  public final View getView()
  {
    AppMethodBeat.i(148099);
    Object localObject = this.moR;
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
    this.moR = ((m)new t(this.mContext, (l)this));
    z.mqu.UI(this.mAppId);
    AppMethodBeat.o(148098);
  }
  
  public final void uninit()
  {
    AppMethodBeat.i(148102);
    m localm = this.moR;
    if (localm != null) {
      localm.reset();
    }
    z.mqu.UH(this.mAppId);
    AppMethodBeat.o(148102);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class b
    implements DialogInterface.OnClickListener
  {
    b(s params, String paramString) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(148085);
      s.a(this.moU, paramString);
      AppMethodBeat.o(148085);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/SendVerifyCodeResp;", "invoke"})
  static final class d
    extends q
    implements d.g.a.b<dbh, d.z>
  {
    d(s params, ProgressDialog paramProgressDialog)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/CheckVerifyCodeResp;", "invoke"})
  static final class f
    extends q
    implements d.g.a.b<yl, d.z>
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