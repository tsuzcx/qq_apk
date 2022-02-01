package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.h;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.ba.e;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.g;
import com.tencent.mm.plugin.appbrand.utils.x;
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import com.tencent.mm.protocal.protobuf.epg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.tools.o;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandProfileRelievedBuyHalfScreenComponent;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "descLinkTextView", "Landroid/widget/TextView;", "descTextView", "doNothingClickListener", "Landroid/view/View$OnClickListener;", "halfScreenDialog", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/HalfScreenDialog;", "isShowing", "", "()Z", "lastAttachedRelievedBuyInfo", "Lcom/tencent/mm/protocal/protobuf/RelievedBuyInfo;", "myTag", "", "subInfoAdapter", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandProfileRelievedBuyHalfScreenComponent$Companion$SubInfoAdapter;", "subInfoRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "titleFullArea", "Landroid/widget/LinearLayout;", "titleFullImageView", "Landroid/widget/ImageView;", "titleFullTextView", "titleLiteTextView", "adjustDialogHeightConfig", "", "attachRelievedBuyInfo", "relievedBuyInfo", "hide", "isLandscape", "jump2WebView", "url", "show", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
{
  public static final l.a uce;
  private final Context context;
  private final String djQ;
  final m ucf;
  private final LinearLayout ucg;
  private final ImageView uch;
  private final TextView uci;
  private final TextView ucj;
  private final TextView uck;
  private final TextView ucl;
  private final RecyclerView ucm;
  private final l.a.c ucn;
  private final View.OnClickListener uco;
  private epg ucp;
  
  static
  {
    AppMethodBeat.i(322258);
    uce = new l.a((byte)0);
    AppMethodBeat.o(322258);
  }
  
  public l(Context paramContext)
  {
    AppMethodBeat.i(322239);
    this.context = paramContext;
    this.djQ = s.X("MicroMsg.AppBrand.AppBrandProfileRelievedBuyHalfScreenComponent#", Integer.valueOf(hashCode()));
    this.ucf = new m(this.context);
    this.uco = l..ExternalSyntheticLambda2.INSTANCE;
    this.ucf.setCanceledOnTouchOutside(true);
    this.ucf.setContentView(ba.g.app_brand_profile_relieved_buy_half_screen_layout);
    int j = this.context.getResources().getDisplayMetrics().heightPixels;
    int i;
    float f;
    if (2 == this.context.getResources().getConfiguration().orientation)
    {
      i = 1;
      if (i == 0) {
        break label614;
      }
      f = 1.0F;
      label116:
      i = (int)(f * j);
      Log.i(this.djQ, "adjustDialogHeightConfig, screenHeight: " + j + ", peekHeight: " + i + ", maxHeight: " + i);
      paramContext = this.ucf;
      Log.i("MicroMsg.AppBrand.HalfScreenDialog", s.X("setPeekHeight, peekHeight: ", Integer.valueOf(i)));
      paramContext.dqv = i;
      paramContext.uDh.setPeekHeight(i);
      Object localObject1 = this.ucf;
      Log.i("MicroMsg.AppBrand.HalfScreenDialog", s.X("setMaxHeight, maxHeight: ", Integer.valueOf(i)));
      ((m)localObject1).maxHeight = i;
      paramContext = ((m)localObject1).uDf;
      localObject1 = ((m)localObject1).uDf.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).height = i;
      Object localObject2 = ah.aiuX;
      paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      paramContext = (FrameLayout)this.ucf.findViewById(ba.f.close_layout);
      if (paramContext != null) {
        paramContext.setOnClickListener(this.uco);
      }
      paramContext = (FrameLayout)this.ucf.findViewById(ba.f.close_img);
      if (paramContext != null)
      {
        paramContext.setOnClickListener(new l..ExternalSyntheticLambda0(this));
        o.F((View)paramContext, 0.7F);
      }
      this.ucg = ((LinearLayout)this.ucf.findViewById(ba.f.title_full_area));
      this.uch = ((ImageView)this.ucf.findViewById(ba.f.title_full_icon));
      this.uci = ((TextView)this.ucf.findViewById(ba.f.title_full_icon_desc));
      this.ucj = ((TextView)this.ucf.findViewById(ba.f.title_lite));
      paramContext = (LinearLayout)this.ucf.findViewById(ba.f.title_layout);
      if (paramContext != null) {
        paramContext.setOnClickListener(this.uco);
      }
      this.uck = ((TextView)this.ucf.findViewById(ba.f.desc_text));
      this.ucl = ((TextView)this.ucf.findViewById(ba.f.desc_link));
      this.ucm = ((RecyclerView)this.ucf.findViewById(ba.f.sub_info_list));
      paramContext = this.ucm;
      if (paramContext != null) {
        paramContext.setOnClickListener(this.uco);
      }
      paramContext = this.ucm;
      if (paramContext != null) {
        paramContext.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
      }
      localObject2 = androidx.core.content.a.m(this.context, ba.e.app_brand_profile_relieved_buy_sub_info_divider);
      if (localObject2 == null) {
        break label621;
      }
      paramContext = this.ucm;
      if (paramContext != null)
      {
        localObject1 = new h(this.context, 1);
        ((h)localObject1).w((Drawable)localObject2);
        localObject2 = ah.aiuX;
        paramContext.a((RecyclerView.h)localObject1);
      }
    }
    for (;;)
    {
      this.ucn = new l.a.c(this.context);
      paramContext = this.ucm;
      if (paramContext != null) {
        paramContext.setAdapter((RecyclerView.a)this.ucn);
      }
      AppMethodBeat.o(322239);
      return;
      i = 0;
      break;
      label614:
      f = 0.75F;
      break label116;
      label621:
      Log.w(this.djQ, "<init>, dividerDrawable is null");
    }
  }
  
  private static final void a(l paraml, View paramView)
  {
    AppMethodBeat.i(322250);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paraml);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ui/AppBrandProfileRelievedBuyHalfScreenComponent", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paraml, "this$0");
    Log.i(paraml.djQ, "close");
    paraml.ucf.dismiss();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileRelievedBuyHalfScreenComponent", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(322250);
  }
  
  private static final void a(l paraml, epg paramepg, View paramView)
  {
    AppMethodBeat.i(322253);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paraml);
    localb.cH(paramepg);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ui/AppBrandProfileRelievedBuyHalfScreenComponent", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paraml, "this$0");
    s.u(paramepg, "$relievedBuyInfo");
    paramepg = paramepg.abtv;
    s.s(paramepg, "relievedBuyInfo.click_url");
    Log.i("MicroMsg.AppBrand.AppBrandProfileRelievedBuyHalfScreenComponent", s.X("jump2WebView, url: ", paramepg));
    c.b(paraml.context, "webview", ".ui.tools.WebViewUI", new Intent().putExtra("rawUrl", paramepg).putExtra("forceHideShare", true));
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileRelievedBuyHalfScreenComponent", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(322253);
  }
  
  private static final void dJ(View paramView)
  {
    AppMethodBeat.i(322245);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ui/AppBrandProfileRelievedBuyHalfScreenComponent", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileRelievedBuyHalfScreenComponent", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(322245);
  }
  
  public final void a(epg paramepg)
  {
    Object localObject2 = null;
    AppMethodBeat.i(322275);
    s.u(paramepg, "relievedBuyInfo");
    Log.i(this.djQ, "attachRelievedBuyInfo");
    if (s.p(this.ucp, paramepg))
    {
      Log.i(this.djQ, "attachRelievedBuyInfo, already attached");
      AppMethodBeat.o(322275);
      return;
    }
    this.ucp = paramepg;
    Object localObject1;
    label211:
    int i;
    if (1 == paramepg.abts)
    {
      localObject1 = this.ucg;
      if (localObject1 != null) {
        ((LinearLayout)localObject1).setVisibility(0);
      }
      localObject1 = this.ucj;
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(8);
      }
      Object localObject3 = this.uch;
      if (localObject3 != null)
      {
        if ((paramepg.icon_width > 0) && (paramepg.icon_height > 0))
        {
          localObject1 = ((ImageView)localObject3).getLayoutParams();
          ((ViewGroup.LayoutParams)localObject1).width = ((int)(paramepg.icon_width / paramepg.icon_height * ((ViewGroup.LayoutParams)localObject1).height));
          Object localObject4 = ah.aiuX;
          ((ImageView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject1);
          localObject4 = new StringBuilder("attachRelievedBuyInfo, width: ");
          localObject1 = ((ImageView)localObject3).getLayoutParams();
          if (localObject1 == null)
          {
            localObject1 = null;
            localObject4 = ((StringBuilder)localObject4).append(localObject1).append(", height: ");
            localObject1 = ((ImageView)localObject3).getLayoutParams();
            if (localObject1 != null) {
              break label475;
            }
            localObject1 = localObject2;
            Log.i("MicroMsg.AppBrand.AppBrandProfileRelievedBuyHalfScreenComponent", localObject1);
          }
        }
        else
        {
          x.c((ImageView)localObject3, paramepg.icon_url);
        }
      }
      else
      {
        localObject1 = this.uci;
        if (localObject1 != null)
        {
          localObject2 = paramepg.abtw;
          localObject3 = (CharSequence)localObject2;
          if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
            break label486;
          }
          i = 1;
          label274:
          if (i != 0) {
            break label491;
          }
          ((TextView)localObject1).setVisibility(0);
          ((TextView)localObject1).setText((CharSequence)localObject2);
        }
        label292:
        localObject1 = this.uck;
        if (localObject1 != null) {
          ((TextView)localObject1).setText((CharSequence)paramepg.igN);
        }
        localObject1 = paramepg.abtu;
        localObject2 = (CharSequence)localObject1;
        if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
          break label532;
        }
        i = 1;
        label340:
        if (i != 0) {
          break label537;
        }
        localObject2 = this.ucl;
        if (localObject2 != null) {
          ((TextView)localObject2).setVisibility(0);
        }
        localObject2 = this.ucl;
        if (localObject2 != null) {
          ((TextView)localObject2).setText((CharSequence)localObject1);
        }
        o.F((View)this.ucl, 0.7F);
        localObject1 = this.ucl;
        if (localObject1 != null) {
          ((TextView)localObject1).setOnClickListener(new l..ExternalSyntheticLambda1(this, paramepg));
        }
      }
    }
    for (;;)
    {
      localObject1 = this.ucn;
      paramepg = paramepg.abtt;
      s.s(paramepg, "relievedBuyInfo.sub_info");
      paramepg = (List)paramepg;
      s.u(paramepg, "subInfoList");
      ((l.a.c)localObject1).ucq = paramepg;
      ((RecyclerView.a)localObject1).bZE.notifyChanged();
      AppMethodBeat.o(322275);
      return;
      localObject1 = Integer.valueOf(((ViewGroup.LayoutParams)localObject1).width);
      break;
      label475:
      localObject1 = Integer.valueOf(((ViewGroup.LayoutParams)localObject1).height);
      break label211;
      label486:
      i = 0;
      break label274;
      label491:
      ((TextView)localObject1).setVisibility(8);
      break label292;
      localObject1 = this.ucg;
      if (localObject1 != null) {
        ((LinearLayout)localObject1).setVisibility(8);
      }
      localObject1 = this.ucj;
      if (localObject1 == null) {
        break label292;
      }
      ((TextView)localObject1).setVisibility(0);
      break label292;
      label532:
      i = 0;
      break label340;
      label537:
      localObject1 = this.ucl;
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(8);
      }
    }
  }
  
  public final void hide()
  {
    AppMethodBeat.i(322284);
    Log.i(this.djQ, "hide");
    this.ucf.dismiss();
    AppMethodBeat.o(322284);
  }
  
  public final void show()
  {
    AppMethodBeat.i(322280);
    Log.i(this.djQ, "show");
    this.ucf.show();
    AppMethodBeat.o(322280);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.l
 * JD-Core Version:    0.7.0.1
 */