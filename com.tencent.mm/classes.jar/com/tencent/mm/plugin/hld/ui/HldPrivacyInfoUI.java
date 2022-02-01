package com.tencent.mm.plugin.hld.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.plugin.hld.a.a;
import com.tencent.mm.plugin.hld.a.c;
import com.tencent.mm.plugin.hld.a.f;
import com.tencent.mm.plugin.hld.a.h;
import com.tencent.mm.plugin.hld.a.j;
import com.tencent.mm.plugin.hld.b.e;
import com.tencent.mm.plugin.hld.b.e.a;
import com.tencent.mm.plugin.hld.model.k;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.CustomScrollView;
import com.tencent.mm.ui.base.CustomScrollView.a;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.n.n;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/ui/HldPrivacyInfoUI;", "Lcom/tencent/mm/ui/MMActivity;", "Landroid/view/View$OnClickListener;", "()V", "continueBt", "Landroid/widget/LinearLayout;", "getContinueBt", "()Landroid/widget/LinearLayout;", "continueBt$delegate", "Lkotlin/Lazy;", "finishBt", "Landroid/widget/Button;", "getFinishBt", "()Landroid/widget/Button;", "finishBt$delegate", "scrollView", "Lcom/tencent/mm/ui/base/CustomScrollView;", "getScrollView", "()Lcom/tencent/mm/ui/base/CustomScrollView;", "scrollView$delegate", "getLayoutId", "", "initView", "", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-hld_release"})
public final class HldPrivacyInfoUI
  extends MMActivity
  implements View.OnClickListener
{
  public static final a DGq;
  private final f DGp;
  private final f Dzq;
  private final f yOH;
  
  static
  {
    AppMethodBeat.i(215772);
    DGq = new a((byte)0);
    AppMethodBeat.o(215772);
  }
  
  public HldPrivacyInfoUI()
  {
    AppMethodBeat.i(215771);
    this.yOH = g.ar((kotlin.g.a.a)new g(this));
    this.Dzq = g.ar((kotlin.g.a.a)new c(this));
    this.DGp = g.ar((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(215771);
  }
  
  private final CustomScrollView eFG()
  {
    AppMethodBeat.i(215759);
    CustomScrollView localCustomScrollView = (CustomScrollView)this.yOH.getValue();
    AppMethodBeat.o(215759);
    return localCustomScrollView;
  }
  
  private final LinearLayout eFH()
  {
    AppMethodBeat.i(215763);
    LinearLayout localLinearLayout = (LinearLayout)this.DGp.getValue();
    AppMethodBeat.o(215763);
    return localLinearLayout;
  }
  
  private final Button getFinishBt()
  {
    AppMethodBeat.i(215761);
    Button localButton = (Button)this.Dzq.getValue();
    AppMethodBeat.o(215761);
    return localButton;
  }
  
  public final int getLayoutId()
  {
    return a.h.ime_privacy_info_ui;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(215767);
    super.initView();
    setMMTitle(a.j.ime_privacy_info_title);
    hideActionbarLine();
    setActionbarColor(getResources().getColor(a.c.BW_93));
    setBackGroundColorResource(a.c.BW_93);
    setBackBtn((MenuItem.OnMenuItemClickListener)new d(this));
    Object localObject = getResources();
    if ((localObject instanceof com.tencent.mm.cj.b)) {}
    for (localObject = ((com.tencent.mm.cj.b)localObject).hrw().getText(a.j.ime_privacy_info_detail);; localObject = ((Resources)localObject).getText(a.j.ime_privacy_info_detail))
    {
      p.j(localObject, "if(resources is MMResour….ime_privacy_info_detail)");
      String str = getString(a.j.ime_privacy_info_url);
      p.j(str, "getString(R.string.ime_privacy_info_url)");
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder((CharSequence)localObject);
      int i = n.a((CharSequence)localObject, str, 0, false, 6);
      localSpannableStringBuilder.setSpan(new e(this), i, localSpannableStringBuilder.length(), 34);
      localObject = (TextView)findViewById(a.f.detail_tv);
      ((TextView)localObject).setMovementMethod(LinkMovementMethod.getInstance());
      ((TextView)localObject).setHighlightColor(0);
      ((TextView)localObject).setText((CharSequence)localSpannableStringBuilder);
      ((CustomScrollView)findViewById(a.f.body_sv)).setOnScrollChangeListener((CustomScrollView.a)new f(this));
      getFinishBt().setOnClickListener((View.OnClickListener)this);
      eFH().setOnClickListener((View.OnClickListener)this);
      AppMethodBeat.o(215767);
      return;
    }
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(215770);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/hld/ui/HldPrivacyInfoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    int i;
    if (paramView != null)
    {
      paramView = Integer.valueOf(paramView.getId());
      i = a.f.finish_bt;
      if (paramView != null) {
        break label95;
      }
      label59:
      i = a.f.continue_bt;
      if (paramView != null) {
        break label176;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/hld/ui/HldPrivacyInfoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(215770);
      return;
      paramView = null;
      break;
      label95:
      if (paramView.intValue() != i) {
        break label59;
      }
      paramView = k.DDb;
      paramView = getContext();
      p.j(paramView, "context");
      k.hL(8, paramView.getIntent().getIntExtra("ime_enter_scene", 6));
      paramView = com.tencent.mm.plugin.hld.f.l.DHK;
      com.tencent.mm.plugin.hld.f.l.eHl();
      paramView = e.Dvq;
      e.a.a(com.tencent.mm.plugin.hld.model.b.DBq, 0L, null, 6);
      setResult(-1, new Intent());
      finish();
      continue;
      label176:
      if (paramView.intValue() == i) {
        eFG().smoothScrollBy(0, eFG().getHeight());
      }
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(215764);
    super.onCreate(paramBundle);
    initView();
    overridePendingTransition(a.a.slide_right_in, a.a.slide_left_out);
    AppMethodBeat.o(215764);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/ui/HldPrivacyInfoUI$Companion;", "", "()V", "TAG", "", "plugin-hld_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<LinearLayout>
  {
    b(HldPrivacyInfoUI paramHldPrivacyInfoUI)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<Button>
  {
    c(HldPrivacyInfoUI paramHldPrivacyInfoUI)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class d
    implements MenuItem.OnMenuItemClickListener
  {
    d(HldPrivacyInfoUI paramHldPrivacyInfoUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(213446);
      this.DGr.finish();
      AppMethodBeat.o(213446);
      return true;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/hld/ui/HldPrivacyInfoUI$initView$2", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "plugin-hld_release"})
  public static final class e
    extends ClickableSpan
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(217789);
      p.k(paramView, "widget");
      paramView = new Intent();
      String str = MMApplicationContext.getResources().getString(a.j.license_read_url, new Object[] { LocaleUtil.getCurrentLanguage((Context)this.DGr.getContext()), LocaleUtil.getCurrentCountryCode(), "setting", Integer.valueOf(0), Integer.valueOf(0) });
      p.j(str, "MMApplicationContext.get…yCode(), \"setting\", 0, 0)");
      paramView.putExtra("rawUrl", str);
      paramView.putExtra("forceHideShare", true);
      c.b((Context)this.DGr.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
      AppMethodBeat.o(217789);
    }
    
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(217791);
      p.k(paramTextPaint, "ds");
      AppCompatActivity localAppCompatActivity = this.DGr.getContext();
      p.j(localAppCompatActivity, "context");
      paramTextPaint.setColor(localAppCompatActivity.getResources().getColor(a.c.link_color));
      AppMethodBeat.o(217791);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "scrollView", "Landroid/widget/ScrollView;", "kotlin.jvm.PlatformType", "x", "", "y", "oldx", "oldy", "onScrollChange"})
  static final class f
    implements CustomScrollView.a
  {
    f(HldPrivacyInfoUI paramHldPrivacyInfoUI) {}
    
    public final void a(ScrollView paramScrollView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(217498);
      p.j(paramScrollView, "scrollView");
      View localView = paramScrollView.getChildAt(paramScrollView.getChildCount() - 1);
      p.j(localView, "view");
      paramInt1 = localView.getBottom() - (paramScrollView.getHeight() + paramScrollView.getScrollY());
      Log.d("WxIme.HldPrivacyInfoUI", "diff:".concat(String.valueOf(paramInt1)));
      if (paramInt1 == 0)
      {
        HldPrivacyInfoUI.a(this.DGr).setVisibility(0);
        HldPrivacyInfoUI.b(this.DGr).setVisibility(8);
      }
      AppMethodBeat.o(217498);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/ui/base/CustomScrollView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<CustomScrollView>
  {
    g(HldPrivacyInfoUI paramHldPrivacyInfoUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.ui.HldPrivacyInfoUI
 * JD-Core Version:    0.7.0.1
 */