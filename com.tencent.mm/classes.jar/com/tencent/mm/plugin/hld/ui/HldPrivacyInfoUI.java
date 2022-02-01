package com.tencent.mm.plugin.hld.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.ce.d;
import com.tencent.mm.plugin.hld.a.a;
import com.tencent.mm.plugin.hld.a.c;
import com.tencent.mm.plugin.hld.a.f;
import com.tencent.mm.plugin.hld.a.h;
import com.tencent.mm.plugin.hld.a.j;
import com.tencent.mm.plugin.hld.b.e;
import com.tencent.mm.plugin.hld.b.e.a;
import com.tencent.mm.plugin.hld.f.l;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.CustomScrollView;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/ui/HldPrivacyInfoUI;", "Lcom/tencent/mm/ui/MMActivity;", "Landroid/view/View$OnClickListener;", "()V", "continueBt", "Landroid/widget/LinearLayout;", "getContinueBt", "()Landroid/widget/LinearLayout;", "continueBt$delegate", "Lkotlin/Lazy;", "finishBt", "Landroid/widget/Button;", "getFinishBt", "()Landroid/widget/Button;", "finishBt$delegate", "scrollView", "Lcom/tencent/mm/ui/base/CustomScrollView;", "getScrollView", "()Lcom/tencent/mm/ui/base/CustomScrollView;", "scrollView$delegate", "getLayoutId", "", "initView", "", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class HldPrivacyInfoUI
  extends MMActivity
  implements View.OnClickListener
{
  public static final HldPrivacyInfoUI.a JxP;
  private final j ETc;
  private final j Jst;
  private final j JxQ;
  
  static
  {
    AppMethodBeat.i(312267);
    JxP = new HldPrivacyInfoUI.a((byte)0);
    AppMethodBeat.o(312267);
  }
  
  public HldPrivacyInfoUI()
  {
    AppMethodBeat.i(312229);
    this.ETc = kotlin.k.cm((kotlin.g.a.a)new e(this));
    this.Jst = kotlin.k.cm((kotlin.g.a.a)new c(this));
    this.JxQ = kotlin.k.cm((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(312229);
  }
  
  private static final void a(HldPrivacyInfoUI paramHldPrivacyInfoUI, ScrollView paramScrollView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(312262);
    s.u(paramHldPrivacyInfoUI, "this$0");
    paramInt1 = paramScrollView.getChildAt(paramScrollView.getChildCount() - 1).getBottom() - (paramScrollView.getHeight() + paramScrollView.getScrollY());
    Log.d("WxIme.HldPrivacyInfoUI", s.X("diff:", Integer.valueOf(paramInt1)));
    if (paramInt1 == 0)
    {
      paramHldPrivacyInfoUI.getFinishBt().setVisibility(0);
      paramHldPrivacyInfoUI.fNB().setVisibility(8);
    }
    AppMethodBeat.o(312262);
  }
  
  private static final boolean a(HldPrivacyInfoUI paramHldPrivacyInfoUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(312251);
    s.u(paramHldPrivacyInfoUI, "this$0");
    paramHldPrivacyInfoUI.finish();
    AppMethodBeat.o(312251);
    return true;
  }
  
  private final CustomScrollView fNA()
  {
    AppMethodBeat.i(312235);
    Object localObject = this.ETc.getValue();
    s.s(localObject, "<get-scrollView>(...)");
    localObject = (CustomScrollView)localObject;
    AppMethodBeat.o(312235);
    return localObject;
  }
  
  private final LinearLayout fNB()
  {
    AppMethodBeat.i(312246);
    Object localObject = this.JxQ.getValue();
    s.s(localObject, "<get-continueBt>(...)");
    localObject = (LinearLayout)localObject;
    AppMethodBeat.o(312246);
    return localObject;
  }
  
  private final Button getFinishBt()
  {
    AppMethodBeat.i(312241);
    Object localObject = this.Jst.getValue();
    s.s(localObject, "<get-finishBt>(...)");
    localObject = (Button)localObject;
    AppMethodBeat.o(312241);
    return localObject;
  }
  
  public final int getLayoutId()
  {
    return a.h.ime_privacy_info_ui;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(312311);
    super.initView();
    setMMTitle(a.j.ime_privacy_info_title);
    hideActionbarLine();
    setActionbarColor(getResources().getColor(a.c.BW_93));
    setBackGroundColorResource(a.c.BW_93);
    setBackBtn(new HldPrivacyInfoUI..ExternalSyntheticLambda0(this));
    Object localObject = getResources();
    if ((localObject instanceof d)) {}
    for (localObject = ((d)localObject).mResources.getText(a.j.ime_privacy_info_detail);; localObject = ((Resources)localObject).getText(a.j.ime_privacy_info_detail))
    {
      s.s(localObject, "if(resources is MMResour….ime_privacy_info_detail)");
      String str = getString(a.j.ime_privacy_info_url);
      s.s(str, "getString(R.string.ime_privacy_info_url)");
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder((CharSequence)localObject);
      int i = n.a((CharSequence)localObject, str, 0, false, 6);
      localSpannableStringBuilder.setSpan(new d(this), i, localSpannableStringBuilder.length(), 34);
      localObject = (TextView)findViewById(a.f.detail_tv);
      ((TextView)localObject).setMovementMethod(LinkMovementMethod.getInstance());
      ((TextView)localObject).setHighlightColor(0);
      ((TextView)localObject).setText((CharSequence)localSpannableStringBuilder);
      ((CustomScrollView)findViewById(a.f.body_sv)).setOnScrollChangeListener(new HldPrivacyInfoUI..ExternalSyntheticLambda1(this));
      getFinishBt().setOnClickListener((View.OnClickListener)this);
      fNB().setOnClickListener((View.OnClickListener)this);
      AppMethodBeat.o(312311);
      return;
    }
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(312323);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/hld/ui/HldPrivacyInfoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    int i;
    if (paramView == null)
    {
      paramView = null;
      i = a.f.finish_bt;
      if (paramView != null) {
        break label95;
      }
      label53:
      i = a.f.continue_bt;
      if (paramView != null) {
        break label167;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/hld/ui/HldPrivacyInfoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(312323);
      return;
      paramView = Integer.valueOf(paramView.getId());
      break;
      label95:
      if (paramView.intValue() != i) {
        break label53;
      }
      paramView = com.tencent.mm.plugin.hld.model.k.JvH;
      com.tencent.mm.plugin.hld.model.k.jp(8, getContext().getIntent().getIntExtra("ime_enter_scene", 6));
      paramView = l.JyV;
      l.fOU();
      paramView = e.JoK;
      e.a.a(com.tencent.mm.plugin.hld.model.b.Jup, 0L, null, 6);
      setResult(-1, new Intent());
      finish();
      continue;
      label167:
      if (paramView.intValue() == i) {
        fNA().smoothScrollBy(0, fNA().getHeight());
      }
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(312296);
    super.onCreate(paramBundle);
    initView();
    overridePendingTransition(a.a.slide_right_in, a.a.slide_left_out);
    AppMethodBeat.o(312296);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<LinearLayout>
  {
    b(HldPrivacyInfoUI paramHldPrivacyInfoUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/Button;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<Button>
  {
    c(HldPrivacyInfoUI paramHldPrivacyInfoUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/hld/ui/HldPrivacyInfoUI$initView$2", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends ClickableSpan
  {
    d(HldPrivacyInfoUI paramHldPrivacyInfoUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(312330);
      s.u(paramView, "widget");
      paramView = new Intent();
      String str = MMApplicationContext.getResources().getString(a.j.license_read_url, new Object[] { LocaleUtil.getCurrentLanguage((Context)this.JxR.getContext()), LocaleUtil.getCurrentCountryCode(), "setting", Integer.valueOf(0), Integer.valueOf(0) });
      s.s(str, "getResources().getString…yCode(), \"setting\", 0, 0)");
      paramView.putExtra("rawUrl", str);
      paramView.putExtra("forceHideShare", true);
      c.b((Context)this.JxR.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
      AppMethodBeat.o(312330);
    }
    
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(312339);
      s.u(paramTextPaint, "ds");
      paramTextPaint.setColor(this.JxR.getContext().getResources().getColor(a.c.link_color));
      AppMethodBeat.o(312339);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/base/CustomScrollView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<CustomScrollView>
  {
    e(HldPrivacyInfoUI paramHldPrivacyInfoUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.ui.HldPrivacyInfoUI
 * JD-Core Version:    0.7.0.1
 */