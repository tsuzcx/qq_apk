package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.d;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.eer;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.widget.a.j;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderPoiClaimPanel;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bottomDialog", "Lcom/tencent/mm/ui/widget/dialog/MMHalfBottomDialog;", "check", "", "checkBox", "Landroid/widget/CheckBox;", "checkContainer", "Landroid/widget/LinearLayout;", "close", "guideImg", "Landroid/widget/ImageView;", "licenseContent", "Landroid/widget/TextView;", "poiPrepare", "Lcom/tencent/mm/protocal/protobuf/PoiPrepare;", "checkNextDestination", "", "init", "setPoiPrepare", "poi", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends FrameLayout
{
  public static final a GBv;
  private eer BhI;
  private TextView Bqr;
  private LinearLayout Bqs;
  private j DMg;
  private FrameLayout GBw;
  private ImageView GBx;
  private CheckBox checkBox;
  private boolean plZ;
  
  static
  {
    AppMethodBeat.i(344300);
    GBv = new a((byte)0);
    AppMethodBeat.o(344300);
  }
  
  public k(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(344260);
    View localView = View.inflate(paramContext, e.f.finder_poi_claim_panel_layout, (ViewGroup)this);
    Object localObject1 = localView.findViewById(e.e.fl_poi_panel_close_img);
    s.s(localObject1, "root.findViewById<FrameL…d.fl_poi_panel_close_img)");
    this.GBw = ((FrameLayout)localObject1);
    Object localObject3 = this.GBw;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("close");
      localObject1 = null;
    }
    ((FrameLayout)localObject1).setOnClickListener(new k..ExternalSyntheticLambda1(this));
    localObject1 = localView.findViewById(e.e.iv_poi_guide);
    s.s(localObject1, "root.findViewById<ImageView>(R.id.iv_poi_guide)");
    this.GBx = ((ImageView)localObject1);
    localObject1 = localView.findViewById(e.e.cb_poi_license_checkbox);
    s.s(localObject1, "root.findViewById(R.id.cb_poi_license_checkbox)");
    this.checkBox = ((CheckBox)localObject1);
    localObject1 = findViewById(e.e.ll_check_container);
    s.s(localObject1, "findViewById(R.id.ll_check_container)");
    this.Bqs = ((LinearLayout)localObject1);
    localObject3 = this.Bqs;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("checkContainer");
      localObject1 = null;
    }
    ((LinearLayout)localObject1).setOnClickListener(new k..ExternalSyntheticLambda2(this, paramContext));
    localObject1 = localView.findViewById(e.e.tv_poi_license_content);
    s.s(localObject1, "root.findViewById(R.id.tv_poi_license_content)");
    this.Bqr = ((TextView)localObject1);
    localObject3 = this.Bqr;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("licenseContent");
      localObject1 = null;
    }
    ((TextView)localObject1).setOnClickListener(new k..ExternalSyntheticLambda0(paramContext));
    int i;
    if (!LocaleUtil.isChineseAppLang())
    {
      i = 1;
      if (i == 0) {
        break label571;
      }
      localObject3 = this.GBx;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("guideImg");
        localObject1 = null;
      }
      ((ImageView)localObject1).setImageDrawable(getResources().getDrawable(e.d.finder_poi_guide_en));
      label293:
      if (aw.isDarkMode())
      {
        if (i == 0) {
          break label609;
        }
        localObject3 = this.GBx;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("guideImg");
          localObject1 = null;
        }
        ((ImageView)localObject1).setImageDrawable(getResources().getDrawable(e.d.finder_poi_guide_night_en));
      }
      label338:
      this.DMg = new j(paramContext, 2, 0);
      localObject3 = this.DMg;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("bottomDialog");
        localObject1 = null;
      }
      ((j)localObject1).aFe(1);
      localObject1 = this.DMg;
      if (localObject1 != null) {
        break label647;
      }
      s.bIx("bottomDialog");
      localObject1 = null;
      label394:
      ((j)localObject1).au((CharSequence)getResources().getString(e.h.finder_live_post_precheck_next_btn));
      localObject3 = this.DMg;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("bottomDialog");
        localObject1 = null;
      }
      ((j)localObject1).aFc(getResources().getColor(e.b.BW_0_Alpha_0_2));
      localObject3 = this.DMg;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("bottomDialog");
        localObject1 = null;
      }
      ((j)localObject1).agfR = new k..ExternalSyntheticLambda3(this, paramContext);
      localObject1 = this.DMg;
      if (localObject1 != null) {
        break label650;
      }
      s.bIx("bottomDialog");
      localObject1 = null;
      label496:
      ((j)localObject1).setCustomView((View)this);
      localObject3 = this.DMg;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("bottomDialog");
        localObject1 = null;
      }
      ((j)localObject1).dDn();
      localObject1 = z.FrZ;
      localObject1 = as.GSQ;
      paramContext = as.a.hu(paramContext);
      if (paramContext != null) {
        break label653;
      }
    }
    label647:
    label650:
    label653:
    for (paramContext = localObject2;; paramContext = paramContext.fou())
    {
      z.b(0, "poi_channelclaim_page", "", paramContext);
      AppMethodBeat.o(344260);
      return;
      i = 0;
      break;
      label571:
      localObject3 = this.GBx;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("guideImg");
        localObject1 = null;
      }
      ((ImageView)localObject1).setImageDrawable(getResources().getDrawable(e.d.finder_poi_guide));
      break label293;
      label609:
      localObject3 = this.GBx;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("guideImg");
        localObject1 = null;
      }
      ((ImageView)localObject1).setImageDrawable(getResources().getDrawable(e.d.finder_poi_guide_night));
      break label338;
      break label394;
      break label496;
    }
  }
  
  private static final void a(k paramk, Context paramContext)
  {
    Object localObject2 = null;
    AppMethodBeat.i(344295);
    s.u(paramk, "this$0");
    s.u(paramContext, "$context");
    Object localObject1;
    if (paramk.plZ)
    {
      eer localeer = paramk.BhI;
      if (localeer != null)
      {
        if ((localeer.abkj != 0) && (localeer.aahn != 0) && (localeer.aaho != 1))
        {
          localObject1 = z.FrZ;
          localObject1 = as.GSQ;
          localObject1 = paramk.getContext();
          s.s(localObject1, "context");
          localObject1 = as.a.hu((Context)localObject1);
          if (localObject1 != null) {
            break label240;
          }
          localObject1 = null;
          z.b(0, "poi_channelclaim_submitbutton", "", (bui)localObject1);
        }
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("rawUrl", localeer.abkk);
        c.b(paramk.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
      }
      localObject1 = paramk.DMg;
      paramk = (k)localObject1;
      if (localObject1 == null)
      {
        s.bIx("bottomDialog");
        paramk = null;
      }
      paramk.cyW();
      paramk = new JSONObject();
      paramk.put("click_option", "nextstep");
      localObject1 = z.FrZ;
      paramk = paramk.toString();
      s.s(paramk, "kvJson.toString()");
      localObject1 = n.bV(paramk, ",", ";");
      paramk = as.GSQ;
      paramk = as.a.hu(paramContext);
      if (paramk != null) {
        break label248;
      }
    }
    label240:
    label248:
    for (paramk = localObject2;; paramk = paramk.fou())
    {
      z.b(1, "poi_channelclaim_page", (String)localObject1, paramk);
      AppMethodBeat.o(344295);
      return;
      localObject1 = ((as)localObject1).fou();
      break;
    }
  }
  
  private static final void a(k paramk, Context paramContext, View paramView)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    AppMethodBeat.i(344277);
    Object localObject1 = new Object();
    Object localObject4 = new b();
    ((b)localObject4).cH(paramk);
    ((b)localObject4).cH(paramContext);
    ((b)localObject4).cH(paramView);
    a.c("com/tencent/mm/plugin/finder/view/FinderPoiClaimPanel", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((b)localObject4).aYj());
    s.u(paramk, "this$0");
    s.u(paramContext, "$context");
    localObject1 = paramk.checkBox;
    paramView = (View)localObject1;
    if (localObject1 == null)
    {
      s.bIx("checkBox");
      paramView = null;
    }
    localObject4 = paramk.checkBox;
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
      localObject1 = paramk.checkBox;
      paramView = (View)localObject1;
      if (localObject1 == null)
      {
        s.bIx("checkBox");
        paramView = null;
      }
      paramk.plZ = paramView.isChecked();
      if (!paramk.plZ) {
        break label318;
      }
      paramView = paramk.DMg;
      paramk = paramView;
      if (paramView == null)
      {
        s.bIx("bottomDialog");
        paramk = null;
      }
      paramk.aFe(0);
      paramk = new JSONObject();
      paramk.put("click_option", "agree");
      paramView = z.FrZ;
      paramk = paramk.toString();
      s.s(paramk, "kvJson.toString()");
      paramView = n.bV(paramk, ",", ";");
      paramk = as.GSQ;
      paramk = as.a.hu(paramContext);
      if (paramk != null) {
        break label310;
      }
    }
    label310:
    for (paramk = localObject2;; paramk = paramk.fou())
    {
      z.b(1, "poi_channelclaim_page", paramView, paramk);
      a.a(new Object(), "com/tencent/mm/plugin/finder/view/FinderPoiClaimPanel", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(344277);
      return;
      bool = false;
      break;
    }
    label318:
    paramView = paramk.DMg;
    paramContext = paramView;
    if (paramView == null)
    {
      s.bIx("bottomDialog");
      paramContext = null;
    }
    paramContext.aFe(1);
    paramContext = paramk.DMg;
    if (paramContext == null)
    {
      s.bIx("bottomDialog");
      paramContext = localObject3;
    }
    for (;;)
    {
      paramContext.aFc(paramk.getResources().getColor(e.b.BW_0_Alpha_0_2));
      break;
    }
  }
  
  private static final void a(k paramk, View paramView)
  {
    AppMethodBeat.i(344267);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramk);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/view/FinderPoiClaimPanel", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramk, "this$0");
    paramView = paramk.DMg;
    paramk = paramView;
    if (paramView == null)
    {
      s.bIx("bottomDialog");
      paramk = null;
    }
    paramk.cyW();
    a.a(new Object(), "com/tencent/mm/plugin/finder/view/FinderPoiClaimPanel", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(344267);
  }
  
  private static final void f(Context paramContext, View paramView)
  {
    AppMethodBeat.i(344286);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramContext);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/view/FinderPoiClaimPanel", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramContext, "$context");
    paramView = new Intent();
    paramView.putExtra("rawUrl", "https://weixin.qq.com/cgi-bin/readtemplate?t=poi_claim_portal");
    c.b(paramContext, "webview", ".ui.tools.WebViewUI", paramView);
    a.a(new Object(), "com/tencent/mm/plugin/finder/view/FinderPoiClaimPanel", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(344286);
  }
  
  public final void setPoiPrepare(eer parameer)
  {
    this.BhI = parameer;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderPoiClaimPanel$Companion;", "", "()V", "TAG", "", "url", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.k
 * JD-Core Version:    0.7.0.1
 */