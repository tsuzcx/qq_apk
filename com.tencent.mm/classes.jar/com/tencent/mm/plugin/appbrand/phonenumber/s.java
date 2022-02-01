package com.tencent.mm.plugin.appbrand.phonenumber;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cvb;
import com.tencent.mm.protocal.protobuf.dlz;
import com.tencent.mm.protocal.protobuf.wj;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.a.a;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberAddLogic;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberAddLogic;", "mContext", "Landroid/content/Context;", "mAppId", "", "onDone", "Lkotlin/Function0;", "", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "mPhoneNumberAddView", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberAddView;", "getView", "Landroid/view/View;", "init", "sendSms", "mobile", "sendSmsInner", "showErrorTips", "errMsg", "uninit", "verifyCode", "isCheck", "", "code", "Companion", "luggage-wechat-full-sdk_release"})
public final class s
  implements l
{
  private static final String TAG = "PhoneNumberAddLogic";
  public static final a lKg;
  private m lKe;
  private final a<d.y> lKf;
  private final String mAppId;
  private final Context mContext;
  
  static
  {
    AppMethodBeat.i(148104);
    lKg = new a((byte)0);
    TAG = "PhoneNumberAddLogic";
    AppMethodBeat.o(148104);
  }
  
  public s(Context paramContext, String paramString, a<d.y> parama)
  {
    AppMethodBeat.i(148103);
    this.mContext = paramContext;
    this.mAppId = paramString;
    this.lKf = parama;
    AppMethodBeat.o(148103);
  }
  
  private final void Qr(String paramString)
  {
    AppMethodBeat.i(206227);
    com.tencent.mm.plugin.appbrand.utils.k.a(this.mContext, paramString, this.mContext.getString(2131755442), (DialogInterface.OnClickListener)s.e.lKn);
    AppMethodBeat.o(206227);
  }
  
  public final void Qp(final String paramString)
  {
    AppMethodBeat.i(148100);
    d.g.b.k.h(paramString, "mobile");
    if (!bs.isNullOrNil(paramString))
    {
      com.tencent.mm.plugin.appbrand.utils.k.a(this.mContext, this.mContext.getString(2131755454) + paramString, this.mContext.getString(2131755453), this.mContext.getString(2131756036), this.mContext.getString(2131756037), (DialogInterface.OnClickListener)new b(this, paramString), (DialogInterface.OnClickListener)c.lKj);
      AppMethodBeat.o(148100);
      return;
    }
    paramString = this.mContext.getString(2131756021);
    d.g.b.k.g(paramString, "mContext.getString(R.str…_number_format_err_title)");
    Qr(paramString);
    AppMethodBeat.o(148100);
  }
  
  public final void a(final boolean paramBoolean, final String paramString1, String paramString2)
  {
    y localy2 = null;
    y localy1 = null;
    AppMethodBeat.i(148101);
    d.g.b.k.h(paramString1, "mobile");
    d.g.b.k.h(paramString2, "code");
    y localy3 = z.lLJ.Qu(this.mAppId);
    Object localObject;
    if (localy3 != null)
    {
      localObject = z.lLJ.Qu(this.mAppId);
      if (localObject != null)
      {
        localObject = Long.valueOf(((y)localObject).lLv);
        if (localObject == null) {
          d.g.b.k.fOy();
        }
        localy3.lLv = (((Long)localObject).longValue() + 1L);
      }
    }
    else
    {
      if (!paramBoolean) {
        break label272;
      }
      localy2 = z.lLJ.Qu(this.mAppId);
      if (localy2 != null)
      {
        localy3 = z.lLJ.Qu(this.mAppId);
        localObject = localy1;
        if (localy3 != null) {
          localObject = Long.valueOf(localy3.lLy);
        }
        if (localObject == null) {
          d.g.b.k.fOy();
        }
        localy2.lLy = (((Long)localObject).longValue() + 1L);
      }
    }
    for (;;)
    {
      ac.i(TAG, "verifyCode mAppId:" + this.mAppId + ", mobile:" + paramString1 + " code:" + paramString2);
      localObject = com.tencent.mm.plugin.appbrand.utils.k.b(this.mContext, (CharSequence)this.mContext.getString(2131756033));
      new b(this.mAppId, paramString1, paramString2).x((d.g.a.b)new f(this, paramBoolean, paramString1, (ProgressDialog)localObject));
      AppMethodBeat.o(148101);
      return;
      localObject = null;
      break;
      label272:
      localy1 = z.lLJ.Qu(this.mAppId);
      if (localy1 != null)
      {
        localy3 = z.lLJ.Qu(this.mAppId);
        localObject = localy2;
        if (localy3 != null) {
          localObject = Long.valueOf(localy3.lLz);
        }
        if (localObject == null) {
          d.g.b.k.fOy();
        }
        localy1.lLz = (((Long)localObject).longValue() + 1L);
      }
    }
  }
  
  public final View getView()
  {
    AppMethodBeat.i(148099);
    Object localObject = this.lKe;
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
    this.lKe = ((m)new t(this.mContext, (l)this));
    z.lLJ.Qt(this.mAppId);
    AppMethodBeat.o(148098);
  }
  
  public final void uninit()
  {
    AppMethodBeat.i(148102);
    m localm = this.lKe;
    if (localm != null) {
      localm.reset();
    }
    z.lLJ.Qs(this.mAppId);
    AppMethodBeat.o(148102);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberAddLogic$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "luggage-wechat-full-sdk_release"})
  public static final class a {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class b
    implements DialogInterface.OnClickListener
  {
    b(s params, String paramString) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(148085);
      s.a(this.lKh, paramString);
      AppMethodBeat.o(148085);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class c
    implements DialogInterface.OnClickListener
  {
    public static final c lKj;
    
    static
    {
      AppMethodBeat.i(148086);
      lKj = new c();
      AppMethodBeat.o(148086);
    }
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/SendVerifyCodeResp;", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.b<cvb, d.y>
  {
    d(s params, ProgressDialog paramProgressDialog)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/CheckVerifyCodeResp;", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.b<wj, d.y>
  {
    f(s params, boolean paramBoolean, String paramString, ProgressDialog paramProgressDialog)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.s
 * JD-Core Version:    0.7.0.1
 */