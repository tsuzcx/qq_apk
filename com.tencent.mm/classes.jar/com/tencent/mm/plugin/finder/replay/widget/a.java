package com.tencent.mm.plugin.finder.replay.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.ui.widget.a.h;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/replay/widget/FinderLiveChargeLicenseWidget;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "isAnchor", "", "(Landroid/content/Context;Z)V", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMCustomHalfBottomDialog;", "getBottomSheet", "()Lcom/tencent/mm/ui/widget/dialog/MMCustomHalfBottomDialog;", "setBottomSheet", "(Lcom/tencent/mm/ui/widget/dialog/MMCustomHalfBottomDialog;)V", "cancelBtn", "Landroid/widget/Button;", "getCancelBtn", "()Landroid/widget/Button;", "setCancelBtn", "(Landroid/widget/Button;)V", "confirmBtn", "getConfirmBtn", "setConfirmBtn", "()Z", "licenseDesc", "Landroid/widget/TextView;", "getLicenseDesc", "()Landroid/widget/TextView;", "setLicenseDesc", "(Landroid/widget/TextView;)V", "root", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "setRoot", "(Landroid/view/View;)V", "initView", "", "licenseDescStr", "", "licenseContentStr", "callback", "Lkotlin/Function0;", "setLicenseText", "tv", "show", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends FrameLayout
{
  public static final a FmV;
  private h Epc;
  private TextView FmW;
  final boolean hKC;
  private View lBX;
  private Button njI;
  private Button ugK;
  
  static
  {
    AppMethodBeat.i(332877);
    FmV = new a((byte)0);
    AppMethodBeat.o(332877);
  }
  
  public a(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(332836);
    this.hKC = paramBoolean;
    AppMethodBeat.o(332836);
  }
  
  private static final void a(a parama, View paramView)
  {
    AppMethodBeat.i(332859);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/replay/widget/FinderLiveChargeLicenseWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    parama = parama.getBottomSheet();
    if (parama != null) {
      parama.cyW();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/replay/widget/FinderLiveChargeLicenseWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(332859);
  }
  
  private static final void a(a parama, kotlin.g.a.a parama1, View paramView)
  {
    AppMethodBeat.i(332870);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(parama);
    localb.cH(parama1);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/replay/widget/FinderLiveChargeLicenseWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    s.u(parama1, "$callback");
    paramView = aw.Gjk;
    if (aw.isFastClick())
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/replay/widget/FinderLiveChargeLicenseWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(332870);
      return;
    }
    parama = parama.getBottomSheet();
    if (parama != null) {
      parama.cyW();
    }
    parama1.invoke();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/replay/widget/FinderLiveChargeLicenseWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(332870);
  }
  
  private final void b(TextView paramTextView, String paramString1, String paramString2)
  {
    AppMethodBeat.i(332851);
    int i = n.a((CharSequence)paramString1, paramString2, 0, false, 6);
    int j = paramString2.length();
    paramString1 = new SpannableString((CharSequence)paramString1);
    paramString1.setSpan(new b(this), i, i + j, 33);
    paramTextView.setHighlightColor(getContext().getResources().getColor(17170445));
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText((CharSequence)paramString1);
    AppMethodBeat.o(332851);
  }
  
  private final void c(String paramString1, String paramString2, kotlin.g.a.a<ah> parama)
  {
    Object localObject2 = null;
    AppMethodBeat.i(332844);
    this.lBX = LayoutInflater.from(getContext()).inflate(p.f.Cdq, (ViewGroup)this, false);
    Object localObject1 = this.lBX;
    if (localObject1 == null)
    {
      localObject1 = null;
      this.FmW = ((TextView)localObject1);
      localObject1 = this.FmW;
      if (localObject1 != null) {
        b((TextView)localObject1, paramString1, paramString2);
      }
      paramString1 = this.lBX;
      if (paramString1 != null) {
        break label167;
      }
      paramString1 = null;
      label80:
      this.njI = paramString1;
      paramString1 = this.njI;
      if (paramString1 != null) {
        paramString1.setOnClickListener(new a..ExternalSyntheticLambda0(this));
      }
      paramString1 = this.lBX;
      if (paramString1 != null) {
        break label181;
      }
    }
    label167:
    label181:
    for (paramString1 = localObject2;; paramString1 = (Button)paramString1.findViewById(p.e.BCg))
    {
      this.ugK = paramString1;
      paramString1 = this.ugK;
      if (paramString1 != null) {
        paramString1.setOnClickListener(new a..ExternalSyntheticLambda1(this, parama));
      }
      AppMethodBeat.o(332844);
      return;
      localObject1 = (TextView)((View)localObject1).findViewById(p.e.BCh);
      break;
      paramString1 = (Button)paramString1.findViewById(p.e.BCf);
      break label80;
    }
  }
  
  public final void b(String paramString1, String paramString2, kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(332947);
    s.u(paramString1, "licenseDescStr");
    s.u(paramString2, "licenseContentStr");
    s.u(parama, "callback");
    h localh = new h(getContext());
    c(paramString1, paramString2, parama);
    localh.mh(getRoot());
    localh.jHO();
    localh.dDn();
    paramString1 = ah.aiuX;
    this.Epc = localh;
    AppMethodBeat.o(332947);
  }
  
  public final h getBottomSheet()
  {
    return this.Epc;
  }
  
  public final Button getCancelBtn()
  {
    return this.njI;
  }
  
  public final Button getConfirmBtn()
  {
    return this.ugK;
  }
  
  public final TextView getLicenseDesc()
  {
    return this.FmW;
  }
  
  public final View getRoot()
  {
    return this.lBX;
  }
  
  public final void setBottomSheet(h paramh)
  {
    this.Epc = paramh;
  }
  
  public final void setCancelBtn(Button paramButton)
  {
    this.njI = paramButton;
  }
  
  public final void setConfirmBtn(Button paramButton)
  {
    this.ugK = paramButton;
  }
  
  public final void setLicenseDesc(TextView paramTextView)
  {
    this.FmW = paramTextView;
  }
  
  public final void setRoot(View paramView)
  {
    this.lBX = paramView;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/replay/widget/FinderLiveChargeLicenseWidget$Companion;", "", "()V", "ANCHOR_URL", "", "CUSTOMER_URL", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/replay/widget/FinderLiveChargeLicenseWidget$setLicenseText$firstClickSpan$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends ClickableSpan
  {
    b(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(332846);
      s.u(paramView, "widget");
      Intent localIntent = new Intent();
      if (this.FmX.hKC) {}
      for (paramView = "https://support.weixin.qq.com/cgi-bin/mmsupportacctnodeweb-bin/pages/BsB5Jid0M6gtMOz8";; paramView = "https://support.weixin.qq.com/cgi-bin/mmsupportacctnodeweb-bin/pages/JsWXJcUX5dlJhfUW")
      {
        localIntent.putExtra("rawUrl", paramView);
        c.b(this.FmX.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
        AppMethodBeat.o(332846);
        return;
      }
    }
    
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(332853);
      s.u(paramTextPaint, "ds");
      paramTextPaint.setColor(Color.parseColor("#7D90A9"));
      paramTextPaint.setUnderlineText(false);
      paramTextPaint.clearShadowLayer();
      AppMethodBeat.o(332853);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.replay.widget.a
 * JD-Core Version:    0.7.0.1
 */