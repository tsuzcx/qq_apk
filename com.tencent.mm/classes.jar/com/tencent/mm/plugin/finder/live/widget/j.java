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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.live.viewmodel.FinderLivePostUIC.e;
import com.tencent.mm.plugin.finder.report.live.s.ai;
import com.tencent.mm.ui.MMActivity;
import java.util.Arrays;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePostLicenseWidget;", "", "activity", "Lcom/tencent/mm/ui/MMActivity;", "licenseContainer", "Landroid/view/ViewGroup;", "callback", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$WidgetStatusCallback;", "(Lcom/tencent/mm/ui/MMActivity;Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$WidgetStatusCallback;)V", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$WidgetStatusCallback;", "checkBox", "Landroid/widget/CheckBox;", "getCheckBox", "()Landroid/widget/CheckBox;", "setCheckBox", "(Landroid/widget/CheckBox;)V", "container", "Landroid/view/View;", "getContainer", "()Landroid/view/View;", "setContainer", "(Landroid/view/View;)V", "lastAction", "", "getLicenseContainer", "()Landroid/view/ViewGroup;", "licenseState", "getLicenseState", "()I", "setLicenseState", "(I)V", "licenseTxt", "Landroid/widget/TextView;", "getLicenseTxt", "()Landroid/widget/TextView;", "setLicenseTxt", "(Landroid/widget/TextView;)V", "checkLicenseState", "", "isReady", "", "reportOnClick", "saveLicenseState", "setLicenseText", "tv", "shakeIt", "plugin-finder_release"})
public final class j
{
  final MMActivity activity;
  public CheckBox checkBox;
  public View jxm;
  private final ViewGroup uGC;
  public final FinderLivePostUIC.e uGJ;
  private TextView uGX;
  private int uGY;
  public int uvm;
  
  public j(MMActivity paramMMActivity, ViewGroup paramViewGroup, FinderLivePostUIC.e parame)
  {
    AppMethodBeat.i(248123);
    this.activity = paramMMActivity;
    this.uGC = paramViewGroup;
    this.uGJ = parame;
    paramMMActivity = com.tencent.mm.plugin.finder.storage.c.vCb;
    this.uvm = com.tencent.mm.plugin.finder.storage.c.duQ();
    this.jxm = ((View)this.uGC);
    this.jxm.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        int i = 1;
        AppMethodBeat.i(248115);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/finder/live/widget/FinderLivePostLicenseWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = this.uGZ.getCheckBox();
        boolean bool;
        if (!this.uGZ.getCheckBox().isChecked())
        {
          bool = true;
          paramAnonymousView.setChecked(bool);
          paramAnonymousView = this.uGZ;
          if (!this.uGZ.getCheckBox().isChecked()) {
            break label132;
          }
        }
        for (;;)
        {
          paramAnonymousView.uvm = i;
          this.uGZ.uGJ.onChange();
          j.a(this.uGZ);
          a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLivePostLicenseWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(248115);
          return;
          bool = false;
          break;
          label132:
          i = 0;
        }
      }
    });
    paramMMActivity = this.jxm.findViewById(2131306066);
    p.g(paramMMActivity, "container.findViewById(R.id.post_license_checkbox)");
    this.checkBox = ((CheckBox)paramMMActivity);
    paramMMActivity = this.checkBox;
    if (paramMMActivity == null) {
      p.btv("checkBox");
    }
    paramMMActivity.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(248116);
        paramAnonymousCompoundButton = this.uGZ;
        if (this.uGZ.getCheckBox().isChecked()) {}
        for (int i = 1;; i = 0)
        {
          paramAnonymousCompoundButton.uvm = i;
          this.uGZ.uGJ.onChange();
          j.a(this.uGZ);
          AppMethodBeat.o(248116);
          return;
        }
      }
    });
    paramMMActivity = this.jxm.findViewById(2131306068);
    p.g(paramMMActivity, "container.findViewById(R.id.post_license_tv)");
    this.uGX = ((TextView)paramMMActivity);
    paramMMActivity = this.uGX;
    paramViewGroup = paramMMActivity.getContext();
    p.g(paramViewGroup, "tv.context");
    paramViewGroup = paramViewGroup.getResources().getString(2131759872);
    p.g(paramViewGroup, "tv.context.resources.get…inder_live_anchor_iterms)");
    parame = paramMMActivity.getContext();
    p.g(parame, "tv.context");
    parame = parame.getResources().getString(2131759876);
    p.g(parame, "tv.context.resources.get…der_live_anchor_standard)");
    Object localObject = ae.SYK;
    localObject = paramMMActivity.getContext();
    p.g(localObject, "tv.context");
    localObject = ((Context)localObject).getResources().getString(2131759864);
    p.g(localObject, "tv.context.resources.get…ng.finder_live_agree_new)");
    localObject = String.format((String)localObject, Arrays.copyOf(new Object[] { paramViewGroup, parame }, 2));
    p.g(localObject, "java.lang.String.format(format, *args)");
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
    p.g(parame, "tv.context");
    paramMMActivity.setHighlightColor(parame.getResources().getColor(17170445));
    paramMMActivity.setMovementMethod(LinkMovementMethod.getInstance());
    paramMMActivity.setText((CharSequence)paramViewGroup);
    this.uGY = s.ai.vqB.action;
    AppMethodBeat.o(248123);
  }
  
  public final void djL()
  {
    AppMethodBeat.i(248122);
    com.tencent.mm.plugin.finder.storage.c localc = com.tencent.mm.plugin.finder.storage.c.vCb;
    com.tencent.mm.plugin.finder.storage.c.KW(this.uvm);
    AppMethodBeat.o(248122);
  }
  
  public final CheckBox getCheckBox()
  {
    AppMethodBeat.i(248121);
    CheckBox localCheckBox = this.checkBox;
    if (localCheckBox == null) {
      p.btv("checkBox");
    }
    AppMethodBeat.o(248121);
    return localCheckBox;
  }
  
  public final boolean isReady()
  {
    return this.uvm == 1;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/widget/FinderLivePostLicenseWidget$setLicenseText$firstClickSpan$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "plugin-finder_release"})
  public static final class a
    extends ClickableSpan
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(248117);
      p.h(paramView, "widget");
      paramView = new Intent();
      paramView.putExtra("rawUrl", "https://weixin.qq.com/cgi-bin/readtemplate?t=finder_live_privacy");
      com.tencent.mm.br.c.b((Context)this.uGZ.activity, "webview", ".ui.tools.WebViewUI", paramView);
      AppMethodBeat.o(248117);
    }
    
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(248118);
      p.h(paramTextPaint, "ds");
      paramTextPaint.setColor(Color.parseColor("#7D90A9"));
      paramTextPaint.setUnderlineText(false);
      paramTextPaint.clearShadowLayer();
      AppMethodBeat.o(248118);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/widget/FinderLivePostLicenseWidget$setLicenseText$secondClickSpan$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "plugin-finder_release"})
  public static final class b
    extends ClickableSpan
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(248119);
      p.h(paramView, "widget");
      paramView = new Intent();
      paramView.putExtra("rawUrl", "https://weixin.qq.com/cgi-bin/readtemplate?t=finder_live_up_privacy");
      com.tencent.mm.br.c.b((Context)this.uGZ.activity, "webview", ".ui.tools.WebViewUI", paramView);
      AppMethodBeat.o(248119);
    }
    
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(248120);
      p.h(paramTextPaint, "ds");
      paramTextPaint.setColor(Color.parseColor("#7D90A9"));
      paramTextPaint.setUnderlineText(false);
      paramTextPaint.clearShadowLayer();
      AppMethodBeat.o(248120);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.j
 * JD-Core Version:    0.7.0.1
 */