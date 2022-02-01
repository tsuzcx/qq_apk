package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.report.j;
import com.tencent.mm.plugin.finder.live.report.q.a;
import com.tencent.mm.plugin.finder.live.report.q.bk;
import com.tencent.mm.plugin.finder.live.viewmodel.k.f;
import com.tencent.mm.ui.MMActivity;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.g.b.am;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePostLicenseWidget;", "", "activity", "Lcom/tencent/mm/ui/MMActivity;", "licenseContainer", "Landroid/view/ViewGroup;", "callback", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$WidgetStatusCallback;", "(Lcom/tencent/mm/ui/MMActivity;Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$WidgetStatusCallback;)V", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$WidgetStatusCallback;", "checkBox", "Landroid/widget/CheckBox;", "getCheckBox", "()Landroid/widget/CheckBox;", "setCheckBox", "(Landroid/widget/CheckBox;)V", "container", "Landroid/view/View;", "getContainer", "()Landroid/view/View;", "setContainer", "(Landroid/view/View;)V", "lastAction", "", "getLicenseContainer", "()Landroid/view/ViewGroup;", "licenseState", "getLicenseState", "()I", "setLicenseState", "(I)V", "licenseTxt", "Landroid/widget/TextView;", "getLicenseTxt", "()Landroid/widget/TextView;", "setLicenseTxt", "(Landroid/widget/TextView;)V", "checkLicenseState", "", "isReady", "", "reportOnClick", "saveLicenseState", "setLicenseText", "tv", "shakeIt", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class av
{
  public int Dma;
  private final k.f Elx;
  private final ViewGroup EqD;
  private TextView EqJ;
  private int EsN;
  final MMActivity activity;
  public CheckBox checkBox;
  public View hDw;
  
  public av(MMActivity paramMMActivity, ViewGroup paramViewGroup, k.f paramf)
  {
    AppMethodBeat.i(361494);
    this.activity = paramMMActivity;
    this.EqD = paramViewGroup;
    this.Elx = paramf;
    paramMMActivity = com.tencent.d.a.a.a.a.a.ahiX;
    this.Dma = com.tencent.d.a.a.a.a.a.jTo();
    this.hDw = ((View)this.EqD);
    this.hDw.setOnClickListener(new av..ExternalSyntheticLambda0(this));
    paramMMActivity = this.hDw.findViewById(p.e.BZn);
    s.s(paramMMActivity, "container.findViewById(R.id.post_license_checkbox)");
    paramMMActivity = (CheckBox)paramMMActivity;
    s.u(paramMMActivity, "<set-?>");
    this.checkBox = paramMMActivity;
    getCheckBox().setOnCheckedChangeListener(new av..ExternalSyntheticLambda1(this));
    paramMMActivity = this.hDw.findViewById(p.e.BZp);
    s.s(paramMMActivity, "container.findViewById(R.id.post_license_tv)");
    this.EqJ = ((TextView)paramMMActivity);
    paramMMActivity = this.EqJ;
    paramViewGroup = paramMMActivity.getContext().getResources().getString(p.h.Cid);
    s.s(paramViewGroup, "tv.context.resources.get…inder_live_anchor_iterms)");
    paramf = paramMMActivity.getContext().getResources().getString(p.h.Ciq);
    s.s(paramf, "tv.context.resources.get…der_live_anchor_standard)");
    Object localObject = am.aixg;
    localObject = paramMMActivity.getContext().getResources().getString(p.h.ChS);
    s.s(localObject, "tv.context.resources.get…ng.finder_live_agree_new)");
    localObject = String.format((String)localObject, Arrays.copyOf(new Object[] { paramViewGroup, paramf }, 2));
    s.s(localObject, "java.lang.String.format(format, *args)");
    int i = n.a((CharSequence)localObject, paramViewGroup, 0, false, 6);
    int j = paramViewGroup.length();
    int k = n.a((CharSequence)localObject, paramf, 0, false, 6);
    int m = paramf.length();
    paramViewGroup = new SpannableString((CharSequence)localObject);
    paramf = new a(this);
    localObject = new b(this);
    paramViewGroup.setSpan(paramf, i, i + j, 33);
    paramViewGroup.setSpan(localObject, k, k + m, 33);
    paramMMActivity.setHighlightColor(paramMMActivity.getContext().getResources().getColor(17170445));
    paramMMActivity.setMovementMethod(LinkMovementMethod.getInstance());
    paramMMActivity.setText((CharSequence)paramViewGroup);
    this.EsN = q.bk.DBo.action;
    AppMethodBeat.o(361494);
  }
  
  private static final void a(av paramav, View paramView)
  {
    int i = 1;
    AppMethodBeat.i(361524);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramav);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLivePostLicenseWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramav, "this$0");
    paramView = paramav.getCheckBox();
    boolean bool;
    if (!paramav.getCheckBox().isChecked())
    {
      bool = true;
      paramView.setChecked(bool);
      if (!paramav.getCheckBox().isChecked()) {
        break label151;
      }
    }
    for (;;)
    {
      paramav.Dma = i;
      paramav.Elx.onChange();
      paramav.eBn();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLivePostLicenseWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(361524);
      return;
      bool = false;
      break;
      label151:
      i = 0;
    }
  }
  
  private static final void a(av paramav, CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    AppMethodBeat.i(361534);
    s.u(paramav, "this$0");
    if (paramav.getCheckBox().isChecked()) {}
    for (int i = 1;; i = 0)
    {
      paramav.Dma = i;
      paramav.Elx.onChange();
      paramav.eBn();
      AppMethodBeat.o(361534);
      return;
    }
  }
  
  private final void eBn()
  {
    AppMethodBeat.i(361513);
    if (this.Dma == 1) {}
    for (int i = q.bk.DBn.action;; i = q.bk.DBo.action)
    {
      if (this.EsN != i)
      {
        j.Dob.C(q.a.DqM.mwI, String.valueOf(i));
        j localj = j.Dob;
        j.Pj(i);
        this.EsN = i;
      }
      AppMethodBeat.o(361513);
      return;
    }
  }
  
  private CheckBox getCheckBox()
  {
    AppMethodBeat.i(361504);
    CheckBox localCheckBox = this.checkBox;
    if (localCheckBox != null)
    {
      AppMethodBeat.o(361504);
      return localCheckBox;
    }
    s.bIx("checkBox");
    AppMethodBeat.o(361504);
    return null;
  }
  
  public final void eAR()
  {
    AppMethodBeat.i(361556);
    com.tencent.d.a.a.a.a.a locala = com.tencent.d.a.a.a.a.a.ahiX;
    com.tencent.d.a.a.a.a.a.aGT(this.Dma);
    AppMethodBeat.o(361556);
  }
  
  public final boolean isReady()
  {
    return this.Dma == 1;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/widget/FinderLivePostLicenseWidget$setLicenseText$firstClickSpan$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends ClickableSpan
  {
    a(av paramav) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(362089);
      s.u(paramView, "widget");
      paramView = new Intent();
      paramView.putExtra("rawUrl", "https://weixin.qq.com/cgi-bin/readtemplate?t=finder_live_privacy");
      c.b((Context)this.EsO.activity, "webview", ".ui.tools.WebViewUI", paramView);
      AppMethodBeat.o(362089);
    }
    
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(362097);
      s.u(paramTextPaint, "ds");
      paramTextPaint.setColor(Color.parseColor("#7D90A9"));
      paramTextPaint.setUnderlineText(false);
      paramTextPaint.clearShadowLayer();
      AppMethodBeat.o(362097);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/widget/FinderLivePostLicenseWidget$setLicenseText$secondClickSpan$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends ClickableSpan
  {
    b(av paramav) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(362094);
      s.u(paramView, "widget");
      paramView = new Intent();
      paramView.putExtra("rawUrl", "https://weixin.qq.com/cgi-bin/readtemplate?t=finder_live_up_privacy");
      c.b((Context)this.EsO.activity, "webview", ".ui.tools.WebViewUI", paramView);
      AppMethodBeat.o(362094);
    }
    
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(362099);
      s.u(paramTextPaint, "ds");
      paramTextPaint.setColor(Color.parseColor("#7D90A9"));
      paramTextPaint.setUnderlineText(false);
      paramTextPaint.clearShadowLayer();
      AppMethodBeat.o(362099);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.av
 * JD-Core Version:    0.7.0.1
 */