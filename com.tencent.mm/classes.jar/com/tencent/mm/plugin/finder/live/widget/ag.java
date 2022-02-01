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
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.live.report.s.av;
import com.tencent.mm.plugin.finder.live.viewmodel.i.e;
import com.tencent.mm.ui.MMActivity;
import java.util.Arrays;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePostLicenseWidget;", "", "activity", "Lcom/tencent/mm/ui/MMActivity;", "licenseContainer", "Landroid/view/ViewGroup;", "callback", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$WidgetStatusCallback;", "(Lcom/tencent/mm/ui/MMActivity;Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$WidgetStatusCallback;)V", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$WidgetStatusCallback;", "checkBox", "Landroid/widget/CheckBox;", "getCheckBox", "()Landroid/widget/CheckBox;", "setCheckBox", "(Landroid/widget/CheckBox;)V", "container", "Landroid/view/View;", "getContainer", "()Landroid/view/View;", "setContainer", "(Landroid/view/View;)V", "lastAction", "", "getLicenseContainer", "()Landroid/view/ViewGroup;", "licenseState", "getLicenseState", "()I", "setLicenseState", "(I)V", "licenseTxt", "Landroid/widget/TextView;", "getLicenseTxt", "()Landroid/widget/TextView;", "setLicenseTxt", "(Landroid/widget/TextView;)V", "checkLicenseState", "", "isReady", "", "reportOnClick", "saveLicenseState", "setLicenseText", "tv", "shakeIt", "plugin-finder_release"})
public final class ag
{
  final MMActivity activity;
  public CheckBox checkBox;
  public View fyN;
  public int yzc;
  final i.e zlm;
  private final ViewGroup znZ;
  private TextView zoc;
  private int zqm;
  
  public ag(MMActivity paramMMActivity, ViewGroup paramViewGroup, i.e parame)
  {
    AppMethodBeat.i(276087);
    this.activity = paramMMActivity;
    this.znZ = paramViewGroup;
    this.zlm = parame;
    paramMMActivity = com.tencent.c.a.a.a.a.a.Zlt;
    this.yzc = com.tencent.c.a.a.a.a.a.imH();
    this.fyN = ((View)this.znZ);
    this.fyN.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        int i = 1;
        AppMethodBeat.i(279969);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLivePostLicenseWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = this.zqn.getCheckBox();
        boolean bool;
        if (!this.zqn.getCheckBox().isChecked())
        {
          bool = true;
          paramAnonymousView.setChecked(bool);
          paramAnonymousView = this.zqn;
          if (!this.zqn.getCheckBox().isChecked()) {
            break label132;
          }
        }
        for (;;)
        {
          paramAnonymousView.yzc = i;
          this.zqn.zlm.onChange();
          ag.a(this.zqn);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLivePostLicenseWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(279969);
          return;
          bool = false;
          break;
          label132:
          i = 0;
        }
      }
    });
    paramMMActivity = this.fyN.findViewById(b.f.post_license_checkbox);
    p.j(paramMMActivity, "container.findViewById(R.id.post_license_checkbox)");
    this.checkBox = ((CheckBox)paramMMActivity);
    paramMMActivity = this.checkBox;
    if (paramMMActivity == null) {
      p.bGy("checkBox");
    }
    paramMMActivity.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(283258);
        paramAnonymousCompoundButton = this.zqn;
        if (this.zqn.getCheckBox().isChecked()) {}
        for (int i = 1;; i = 0)
        {
          paramAnonymousCompoundButton.yzc = i;
          this.zqn.zlm.onChange();
          ag.a(this.zqn);
          AppMethodBeat.o(283258);
          return;
        }
      }
    });
    paramMMActivity = this.fyN.findViewById(b.f.post_license_tv);
    p.j(paramMMActivity, "container.findViewById(R.id.post_license_tv)");
    this.zoc = ((TextView)paramMMActivity);
    paramMMActivity = this.zoc;
    paramViewGroup = paramMMActivity.getContext();
    p.j(paramViewGroup, "tv.context");
    paramViewGroup = paramViewGroup.getResources().getString(b.j.finder_live_anchor_iterms);
    p.j(paramViewGroup, "tv.context.resources.get…inder_live_anchor_iterms)");
    parame = paramMMActivity.getContext();
    p.j(parame, "tv.context");
    parame = parame.getResources().getString(b.j.finder_live_anchor_standard);
    p.j(parame, "tv.context.resources.get…der_live_anchor_standard)");
    Object localObject = af.aaBG;
    localObject = paramMMActivity.getContext();
    p.j(localObject, "tv.context");
    localObject = ((Context)localObject).getResources().getString(b.j.finder_live_agree_new);
    p.j(localObject, "tv.context.resources.get…ng.finder_live_agree_new)");
    localObject = String.format((String)localObject, Arrays.copyOf(new Object[] { paramViewGroup, parame }, 2));
    p.j(localObject, "java.lang.String.format(format, *args)");
    int i = n.a((CharSequence)localObject, paramViewGroup, 0, false, 6);
    int j = paramViewGroup.length();
    int k = n.a((CharSequence)localObject, parame, 0, false, 6);
    int m = parame.length();
    paramViewGroup = new SpannableString((CharSequence)localObject);
    parame = new a(this);
    localObject = new b(this);
    paramViewGroup.setSpan(parame, i, i + j, 33);
    paramViewGroup.setSpan(localObject, k, k + m, 33);
    parame = paramMMActivity.getContext();
    p.j(parame, "tv.context");
    paramMMActivity.setHighlightColor(parame.getResources().getColor(17170445));
    paramMMActivity.setMovementMethod(LinkMovementMethod.getInstance());
    paramMMActivity.setText((CharSequence)paramViewGroup);
    this.zqm = s.av.yKf.action;
    AppMethodBeat.o(276087);
  }
  
  public final void dIm()
  {
    AppMethodBeat.i(276086);
    com.tencent.c.a.a.a.a.a locala = com.tencent.c.a.a.a.a.a.Zlt;
    com.tencent.c.a.a.a.a.a.aAh(this.yzc);
    AppMethodBeat.o(276086);
  }
  
  public final CheckBox getCheckBox()
  {
    AppMethodBeat.i(276085);
    CheckBox localCheckBox = this.checkBox;
    if (localCheckBox == null) {
      p.bGy("checkBox");
    }
    AppMethodBeat.o(276085);
    return localCheckBox;
  }
  
  public final boolean isReady()
  {
    return this.yzc == 1;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/widget/FinderLivePostLicenseWidget$setLicenseText$firstClickSpan$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "plugin-finder_release"})
  public static final class a
    extends ClickableSpan
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(290047);
      p.k(paramView, "widget");
      paramView = new Intent();
      paramView.putExtra("rawUrl", "https://weixin.qq.com/cgi-bin/readtemplate?t=finder_live_privacy");
      c.b((Context)this.zqn.activity, "webview", ".ui.tools.WebViewUI", paramView);
      AppMethodBeat.o(290047);
    }
    
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(290048);
      p.k(paramTextPaint, "ds");
      paramTextPaint.setColor(Color.parseColor("#7D90A9"));
      paramTextPaint.setUnderlineText(false);
      paramTextPaint.clearShadowLayer();
      AppMethodBeat.o(290048);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/widget/FinderLivePostLicenseWidget$setLicenseText$secondClickSpan$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "plugin-finder_release"})
  public static final class b
    extends ClickableSpan
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(282967);
      p.k(paramView, "widget");
      paramView = new Intent();
      paramView.putExtra("rawUrl", "https://weixin.qq.com/cgi-bin/readtemplate?t=finder_live_up_privacy");
      c.b((Context)this.zqn.activity, "webview", ".ui.tools.WebViewUI", paramView);
      AppMethodBeat.o(282967);
    }
    
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(282968);
      p.k(paramTextPaint, "ds");
      paramTextPaint.setColor(Color.parseColor("#7D90A9"));
      paramTextPaint.setUnderlineText(false);
      paramTextPaint.clearShadowLayer();
      AppMethodBeat.o(282968);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.ag
 * JD-Core Version:    0.7.0.1
 */