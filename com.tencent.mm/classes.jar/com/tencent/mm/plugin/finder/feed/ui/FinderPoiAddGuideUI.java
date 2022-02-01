package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.d;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderPoiAddGuideUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "addButton", "Landroid/widget/Button;", "check", "", "checkBox", "Landroid/widget/CheckBox;", "checkContainer", "Landroid/widget/LinearLayout;", "licenseContent", "Landroid/widget/TextView;", "poiGuide", "Landroid/widget/ImageView;", "getLayoutId", "", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderPoiAddGuideUI
  extends MMFinderUI
{
  public static final a Bqq;
  private TextView Bqr;
  private LinearLayout Bqs;
  private ImageView Bqt;
  private CheckBox checkBox;
  private boolean plZ;
  private Button xUX;
  
  static
  {
    AppMethodBeat.i(364960);
    Bqq = new a((byte)0);
    AppMethodBeat.o(364960);
  }
  
  private static final void a(FinderPoiAddGuideUI paramFinderPoiAddGuideUI, View paramView)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    AppMethodBeat.i(364935);
    Object localObject1 = new Object();
    Object localObject4 = new b();
    ((b)localObject4).cH(paramFinderPoiAddGuideUI);
    ((b)localObject4).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderPoiAddGuideUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((b)localObject4).aYj());
    s.u(paramFinderPoiAddGuideUI, "this$0");
    localObject1 = paramFinderPoiAddGuideUI.checkBox;
    paramView = (View)localObject1;
    if (localObject1 == null)
    {
      s.bIx("checkBox");
      paramView = null;
    }
    localObject4 = paramFinderPoiAddGuideUI.checkBox;
    localObject1 = localObject4;
    if (localObject4 == null)
    {
      s.bIx("checkBox");
      localObject1 = null;
    }
    boolean bool;
    if (!((CheckBox)localObject1).isChecked())
    {
      bool = true;
      paramView.setChecked(bool);
      localObject1 = paramFinderPoiAddGuideUI.checkBox;
      paramView = (View)localObject1;
      if (localObject1 == null)
      {
        s.bIx("checkBox");
        paramView = null;
      }
      paramFinderPoiAddGuideUI.plZ = paramView.isChecked();
      if (!paramFinderPoiAddGuideUI.plZ) {
        break label236;
      }
      localObject1 = paramFinderPoiAddGuideUI.xUX;
      paramView = (View)localObject1;
      if (localObject1 == null)
      {
        s.bIx("addButton");
        paramView = null;
      }
      paramView.setBackgroundResource(e.d.btn_solid_green);
      paramView = paramFinderPoiAddGuideUI.xUX;
      if (paramView != null) {
        break label233;
      }
      s.bIx("addButton");
      paramView = localObject2;
    }
    label233:
    for (;;)
    {
      paramView.setTextColor(paramFinderPoiAddGuideUI.getResources().getColor(17170443));
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/feed/ui/FinderPoiAddGuideUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(364935);
      return;
      bool = false;
      break;
    }
    label236:
    localObject1 = paramFinderPoiAddGuideUI.xUX;
    paramView = (View)localObject1;
    if (localObject1 == null)
    {
      s.bIx("addButton");
      paramView = null;
    }
    paramView.setBackgroundResource(e.d.btn_solid_grey);
    paramView = paramFinderPoiAddGuideUI.xUX;
    if (paramView == null)
    {
      s.bIx("addButton");
      paramView = localObject3;
    }
    for (;;)
    {
      paramView.setTextColor(paramFinderPoiAddGuideUI.getResources().getColor(e.b.BW_0_Alpha_0_2));
      break;
    }
  }
  
  private static final boolean a(FinderPoiAddGuideUI paramFinderPoiAddGuideUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(364923);
    s.u(paramFinderPoiAddGuideUI, "this$0");
    paramFinderPoiAddGuideUI.finish();
    AppMethodBeat.o(364923);
    return true;
  }
  
  private static final void b(FinderPoiAddGuideUI paramFinderPoiAddGuideUI, View paramView)
  {
    AppMethodBeat.i(364944);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramFinderPoiAddGuideUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderPoiAddGuideUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderPoiAddGuideUI, "this$0");
    paramView = new Intent();
    paramView.putExtra("rawUrl", "https://weixin.qq.com/cgi-bin/readtemplate?t=poi_claim_portal");
    c.b((Context)paramFinderPoiAddGuideUI.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/feed/ui/FinderPoiAddGuideUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(364944);
  }
  
  private static final void c(FinderPoiAddGuideUI paramFinderPoiAddGuideUI, View paramView)
  {
    AppMethodBeat.i(364951);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramFinderPoiAddGuideUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderPoiAddGuideUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderPoiAddGuideUI, "this$0");
    if (paramFinderPoiAddGuideUI.plZ)
    {
      paramView = com.tencent.mm.plugin.finder.utils.a.GfO;
      com.tencent.mm.plugin.finder.utils.a.h((Activity)paramFinderPoiAddGuideUI, 0);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/feed/ui/FinderPoiAddGuideUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(364951);
      return;
      Log.i("Finder.FinderPoiAddGuideUI", "licence is not check");
    }
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return e.f.finder_poi_add_guide_layout;
  }
  
  public final void initView()
  {
    Object localObject2 = null;
    AppMethodBeat.i(365011);
    Object localObject1 = findViewById(e.e.cb_poi_license_checkbox);
    s.s(localObject1, "findViewById(R.id.cb_poi_license_checkbox)");
    this.checkBox = ((CheckBox)localObject1);
    localObject1 = findViewById(e.e.tv_poi_license_content);
    s.s(localObject1, "findViewById(R.id.tv_poi_license_content)");
    this.Bqr = ((TextView)localObject1);
    localObject1 = findViewById(e.e.btn_poi_add);
    s.s(localObject1, "findViewById(R.id.btn_poi_add)");
    this.xUX = ((Button)localObject1);
    localObject1 = findViewById(e.e.ll_check_container);
    s.s(localObject1, "findViewById(R.id.ll_check_container)");
    this.Bqs = ((LinearLayout)localObject1);
    localObject1 = findViewById(e.e.iv_poi_guide);
    s.s(localObject1, "findViewById(R.id.iv_poi_guide)");
    this.Bqt = ((ImageView)localObject1);
    int i;
    Object localObject3;
    if (!LocaleUtil.isChineseAppLang())
    {
      i = 1;
      if (i == 0) {
        break label322;
      }
      localObject3 = this.Bqt;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("poiGuide");
        localObject1 = null;
      }
      ((ImageView)localObject1).setImageDrawable(getResources().getDrawable(e.d.finder_poi_guide_en));
      label169:
      if (aw.isDarkMode())
      {
        if (i == 0) {
          break label361;
        }
        localObject3 = this.Bqt;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("poiGuide");
          localObject1 = null;
        }
        ((ImageView)localObject1).setImageDrawable(getResources().getDrawable(e.d.finder_poi_guide_night_en));
      }
      label215:
      localObject3 = this.Bqs;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("checkContainer");
        localObject1 = null;
      }
      ((LinearLayout)localObject1).setOnClickListener(new FinderPoiAddGuideUI..ExternalSyntheticLambda3(this));
      localObject3 = this.Bqr;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("licenseContent");
        localObject1 = null;
      }
      ((TextView)localObject1).setOnClickListener(new FinderPoiAddGuideUI..ExternalSyntheticLambda1(this));
      localObject1 = this.xUX;
      if (localObject1 != null) {
        break label400;
      }
      s.bIx("addButton");
      localObject1 = localObject2;
    }
    label400:
    for (;;)
    {
      ((Button)localObject1).setOnClickListener(new FinderPoiAddGuideUI..ExternalSyntheticLambda2(this));
      AppMethodBeat.o(365011);
      return;
      i = 0;
      break;
      label322:
      localObject3 = this.Bqt;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("poiGuide");
        localObject1 = null;
      }
      ((ImageView)localObject1).setImageDrawable(getResources().getDrawable(e.d.finder_poi_guide));
      break label169;
      label361:
      localObject3 = this.Bqt;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("poiGuide");
        localObject1 = null;
      }
      ((ImageView)localObject1).setImageDrawable(getResources().getDrawable(e.d.finder_poi_guide_night));
      break label215;
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(365004);
    super.onCreate(paramBundle);
    setBackBtn(new FinderPoiAddGuideUI..ExternalSyntheticLambda0(this));
    setActionbarColor(getResources().getColor(e.b.BG_2));
    setMMTitle("");
    hideActionbarLine();
    initView();
    AppMethodBeat.o(365004);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderPoiAddGuideUI$Companion;", "", "()V", "TAG", "", "url", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderPoiAddGuideUI
 * JD-Core Version:    0.7.0.1
 */