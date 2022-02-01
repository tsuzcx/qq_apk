package com.tencent.mm.plugin.appbrand.jsapi.autofill.realname_auth;

import android.content.Context;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ba.d;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.g;
import com.tencent.mm.plugin.appbrand.utils.html.c;
import com.tencent.mm.plugin.appbrand.widget.dialog.n;
import com.tencent.mm.plugin.appbrand.widget.dialog.r;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/RealnameAuthExplainDialog;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "dialogContainer", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;", "title", "", "content", "context", "Landroid/content/Context;", "minHeight", "", "maxHeight", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "url", "", "(Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;IILkotlin/jvm/functions/Function1;)V", "backIv", "Landroid/widget/ImageView;", "containerV", "Landroid/view/View;", "getContent", "()Ljava/lang/String;", "contentTv", "Landroid/widget/TextView;", "contentV", "getContext", "()Landroid/content/Context;", "getHandler", "()Lkotlin/jvm/functions/Function1;", "getMaxHeight", "()I", "getMinHeight", "rootView", "getTitle", "titleTv", "cancel", "dismiss", "getContentView", "getPosition", "isCancelable", "", "isCanceledOnTouchOutside", "onBackPressedEvent", "onCancel", "onDismiss", "onScreenOrientationChanged", "rotation", "onShow", "dialogHelper", "onShown", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements n
{
  private final String content;
  private final Context context;
  private final int maxHeight;
  private final TextView noc;
  private final r rIV;
  private final int rIW;
  private final kotlin.g.a.b<String, ah> rIX;
  private final View rIY;
  private final View rIZ;
  private final ImageView rJa;
  private final View rootView;
  private final String title;
  private final TextView titleTv;
  
  public b(r paramr, String paramString1, String paramString2, Context paramContext, int paramInt1, int paramInt2, kotlin.g.a.b<? super String, ah> paramb)
  {
    AppMethodBeat.i(50482);
    this.rIV = paramr;
    this.title = paramString1;
    this.content = paramString2;
    this.context = paramContext;
    this.rIW = paramInt1;
    this.maxHeight = paramInt2;
    this.rIX = paramb;
    paramr = View.inflate(this.context, ba.g.app_brand_phone_number_explain_dialog, null);
    s.s(paramr, "inflate(context, R.layou…ber_explain_dialog, null)");
    this.rootView = paramr;
    paramr = this.rootView.findViewById(ba.f.phone_number_explain_container);
    s.s(paramr, "rootView.findViewById(R.…number_explain_container)");
    this.rIY = paramr;
    this.rIY.setMinimumHeight(this.rIW);
    paramr = this.rootView.findViewById(ba.f.phone_number_explain_content);
    s.s(paramr, "rootView.findViewById(R.…e_number_explain_content)");
    this.rIZ = paramr;
    this.rIZ.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
    this.rIZ.setMinimumHeight(this.rIW);
    this.rIZ.setPadding(0, 0, 0, com.tencent.mm.cd.a.bs(this.context, ba.d.LargePadding));
    this.rIZ.addOnLayoutChangeListener(new b..ExternalSyntheticLambda1(this));
    paramr = this.rootView.findViewById(ba.f.phone_number_explain_dialog_back);
    s.s(paramr, "rootView.findViewById(R.…mber_explain_dialog_back)");
    this.rJa = ((ImageView)paramr);
    paramr = this.rJa;
    if (paramr != null) {
      paramr.setOnClickListener(new b..ExternalSyntheticLambda0(this));
    }
    paramr = this.rootView.findViewById(ba.f.phone_number_explain_dialog_title);
    s.s(paramr, "rootView.findViewById(R.…ber_explain_dialog_title)");
    this.titleTv = ((TextView)paramr);
    this.titleTv.setText((CharSequence)this.title);
    paramr = this.rootView.findViewById(ba.f.phone_number_explain_dialog_content);
    s.s(paramr, "rootView.findViewById(R.…r_explain_dialog_content)");
    this.noc = ((TextView)paramr);
    this.noc.setText(c.a(this.content, false, new b..ExternalSyntheticLambda2(this)));
    if (Build.VERSION.SDK_INT >= 28) {
      this.noc.setLineHeight(com.tencent.mm.cd.a.fromDPToPix(this.context, 28));
    }
    for (;;)
    {
      this.noc.setMovementMethod(LinkMovementMethod.getInstance());
      this.noc.setLinkTextColor(Color.parseColor("#FF576B95"));
      AppMethodBeat.o(50482);
      return;
      this.noc.setLineSpacing(com.tencent.mm.cd.a.getDensity(this.context) * 12.5F, 1.0F);
    }
  }
  
  private static final void a(b paramb)
  {
    AppMethodBeat.i(326666);
    s.u(paramb, "this$0");
    paramb.rIZ.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, paramb.maxHeight));
    AppMethodBeat.o(326666);
  }
  
  private static final void a(b paramb, View paramView)
  {
    AppMethodBeat.i(326674);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/RealnameAuthExplainDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "this$0");
    paramView = paramb.rIV;
    if (paramView != null) {
      paramView.c((n)paramb);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/RealnameAuthExplainDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(326674);
  }
  
  private static final void a(b paramb, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    AppMethodBeat.i(326670);
    s.u(paramb, "this$0");
    if ((Math.abs(paramInt4 - paramInt2) > paramb.maxHeight) && (paramb.maxHeight >= paramb.rIW)) {
      paramb.rIZ.post(new b..ExternalSyntheticLambda3(paramb));
    }
    AppMethodBeat.o(326670);
  }
  
  private static final void a(b paramb, String paramString)
  {
    AppMethodBeat.i(326678);
    s.u(paramb, "this$0");
    paramb = paramb.rIX;
    s.s(paramString, "url");
    paramb.invoke(paramString);
    AppMethodBeat.o(326678);
  }
  
  public final void a(r paramr) {}
  
  public final boolean bQg()
  {
    return false;
  }
  
  public final void bQh() {}
  
  public final boolean bQi()
  {
    return true;
  }
  
  public final void cancel() {}
  
  public final void dismiss() {}
  
  public final View getContentView()
  {
    return this.rootView;
  }
  
  public final int getPosition()
  {
    return 2;
  }
  
  public final boolean isCancelable()
  {
    return true;
  }
  
  public final void onCancel() {}
  
  public final void xt(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.autofill.realname_auth.b
 * JD-Core Version:    0.7.0.1
 */