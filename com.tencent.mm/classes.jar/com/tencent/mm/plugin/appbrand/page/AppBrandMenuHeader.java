package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ad.e;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.g;
import com.tencent.mm.plugin.appbrand.ba.h;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.appbrand.page.capsulebar.a.a;
import com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI;
import com.tencent.mm.plugin.appbrand.ui.au;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.ui.aw;
import com.tencent.mm.view.d;
import java.util.ArrayList;
import java.util.List;

public class AppBrandMenuHeader
  extends LinearLayout
{
  View qAv;
  private final com.tencent.mm.vending.e.c<? extends com.tencent.mm.vending.e.a> ttX;
  
  public AppBrandMenuHeader(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(47775);
    this.ttX = new com.tencent.mm.vending.e.c();
    ci(paramContext);
    AppMethodBeat.o(47775);
  }
  
  public AppBrandMenuHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(47776);
    this.ttX = new com.tencent.mm.vending.e.c();
    ci(paramContext);
    AppMethodBeat.o(47776);
  }
  
  private void ci(Context paramContext)
  {
    AppMethodBeat.i(47777);
    this.qAv = LayoutInflater.from(paramContext).inflate(ba.g.app_brand_menu_header, this);
    AppMethodBeat.o(47777);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(325152);
    super.onDetachedFromWindow();
    this.ttX.dead();
    AppMethodBeat.o(325152);
  }
  
  public void setPage(final ah paramah)
  {
    AppMethodBeat.i(47778);
    Object localObject4 = paramah.getRuntime();
    Object localObject1 = (ImageView)this.qAv.findViewById(ba.f.icon);
    Object localObject2 = (TextView)this.qAv.findViewById(ba.f.name);
    aw.d(((TextView)localObject2).getPaint());
    TextView localTextView1 = (TextView)this.qAv.findViewById(ba.f.debug_type_desc);
    ImageView localImageView1 = (ImageView)this.qAv.findViewById(ba.f.original_label);
    Object localObject3 = (ImageView)this.qAv.findViewById(ba.f.trading_guarantee_icon);
    ImageView localImageView2 = (ImageView)this.qAv.findViewById(ba.f.official_icon);
    label201:
    TextView localTextView2;
    if ((com.tencent.luggage.sdk.config.g.da(paramah.getRuntime().ccM().nOX, 3)) && (((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.znj, 0) == 1))
    {
      ((ImageView)localObject3).setVisibility(0);
      au.a((ImageView)localObject3, ba.h.app_brand_relieved_buy_icon);
      if ((!com.tencent.luggage.sdk.config.g.mq(paramah.getRuntime().ccM().qYr)) || (((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zqA, 0) != 1)) {
        break label763;
      }
      localImageView2.setVisibility(0);
      TextView localTextView3 = (TextView)this.qAv.findViewById(ba.f.score);
      localObject3 = this.qAv.findViewById(ba.f.status_ll);
      localImageView2 = (ImageView)this.qAv.findViewById(ba.f.status_icon);
      localTextView2 = (TextView)this.qAv.findViewById(ba.f.status_desc);
      View localView = this.qAv.findViewById(ba.f.name_area);
      localObject4 = l.ar((AppBrandRuntime)localObject4);
      Runnable localRunnable = ((l)localObject4).c(paramah);
      com.tencent.mm.modelappbrand.a.b.bEY().a((ImageView)localObject1, ((l)localObject4).cDR(), com.tencent.mm.modelappbrand.a.a.bEX(), new com.tencent.mm.modelappbrand.a.g());
      ((ImageView)localObject1).setOnClickListener(new AppBrandMenuHeader.1(this, localRunnable));
      localView.setOnClickListener(new AppBrandMenuHeader.2(this, localRunnable));
      ((TextView)localObject2).getPaint().setFakeBoldText(true);
      ((TextView)localObject2).setText(((l)localObject4).cDS());
      localObject2 = ((l)localObject4).cDT();
      if (((!Util.isNullOrNil((String)localObject2)) || (BuildInfo.DEBUG) || (WeChatEnvironment.hasDebugger())) && (paramah.asU()))
      {
        localObject1 = "w";
        if (paramah.asU()) {
          localObject1 = "s";
        }
      }
      switch (com.tencent.luggage.h.c.asS())
      {
      default: 
        localObject1 = localObject2;
        label434:
        if (Util.isNullOrNil((String)localObject1))
        {
          localTextView1.setVisibility(8);
          label448:
          if (!((l)localObject4).cDU()) {
            break label893;
          }
          localImageView1.setVisibility(0);
          label462:
          ((l)localObject4).a(new AppBrandMenuHeader.3(this, localTextView3), this.ttX);
          localObject1 = ((l)localObject4).CC(a.a.av(paramah.getRuntime()).cGf());
          if (localObject1 != null) {
            break label903;
          }
          ((View)localObject3).setVisibility(8);
        }
        break;
      }
    }
    for (;;)
    {
      if (!e.eu(getContext()))
      {
        localObject1 = new ArrayList();
        localObject2 = com.tencent.mm.plugin.appbrand.k.a.a.G(paramah.getRuntime());
        if (localObject2 != null) {
          ((List)localObject1).add(new AppBrandMenuHeader.a.a(this.qAv.getContext().getResources().getString(ba.i.appbrand_menu_header_service_embed), Util.nullAsNil(((w)localObject2).getInitConfig().hEy), new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(324821);
              Object localObject = new com.tencent.mm.hellhoundlib.b.b();
              ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/page/AppBrandMenuHeader$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
              paramah.cFj();
              localObject = paramah.getRuntime().ccM();
              WxaExposedParams.a locala = new WxaExposedParams.a();
              locala.appId = ((AppBrandSysConfigWC)localObject).appId;
              locala.from = 3;
              if (paramah.tti == null) {}
              for (paramAnonymousView = "";; paramAnonymousView = paramah.cgR())
              {
                locala.hUf = paramAnonymousView;
                locala.qHO = ((AppBrandSysConfigWC)localObject).qYY.qHO;
                locala.pkgVersion = ((AppBrandSysConfigWC)localObject).qYY.pkgVersion;
                AppBrandProfileUI.a(paramah.getContext(), this.tud.getInitConfig().username, 12, "", false, locala.cll(), null, ActivityStarterIpcDelegate.bq(paramah.getContext()));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/page/AppBrandMenuHeader$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(324821);
                return;
              }
            }
          }));
        }
        if (e.d(paramah))
        {
          localObject2 = new com.tencent.mm.plugin.appbrand.ad.a.b();
          ((com.tencent.mm.plugin.appbrand.ad.a.b)localObject2).source = "menu";
          ((com.tencent.mm.plugin.appbrand.ad.a.b)localObject2).type = "menu";
          ((com.tencent.mm.plugin.appbrand.ad.a.b)localObject2).a(paramah.ccO());
          ((List)localObject1).add(new AppBrandMenuHeader.a.a(this.qAv.getContext().getResources().getString(ba.i.appbrand_menu_header_service_ad), Util.nullAsNil(e.UI(paramah.getAppId())), new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(324820);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.cH(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/page/AppBrandMenuHeader$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
              paramah.cFj();
              e.c(paramah);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/page/AppBrandMenuHeader$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(324820);
            }
          }));
        }
        localObject2 = (RecyclerView)this.qAv.findViewById(ba.f.services_recyclerview);
        if (((List)localObject1).size() > 0)
        {
          ((RecyclerView)localObject2).setVisibility(0);
          ((RecyclerView)localObject2).a(new RecyclerView.h()
          {
            public final void a(Rect paramAnonymousRect, View paramAnonymousView, RecyclerView paramAnonymousRecyclerView, RecyclerView.s paramAnonymouss)
            {
              AppMethodBeat.i(324828);
              super.a(paramAnonymousRect, paramAnonymousView, paramAnonymousRecyclerView, paramAnonymouss);
              if (((RecyclerView.LayoutParams)paramAnonymousView.getLayoutParams()).bXh.KI() == this.tue.size() - 1) {}
              for (int i = 0;; i = d.e(AppBrandMenuHeader.this.getContext(), 8.0F))
              {
                paramAnonymousRect.set(0, 0, 0, i);
                AppMethodBeat.o(324828);
                return;
              }
            }
          });
          ((RecyclerView)localObject2).setAdapter(new AppBrandMenuHeader.a((List)localObject1));
          paramah.getContext();
          ((RecyclerView)localObject2).setLayoutManager(new LinearLayoutManager(1, false));
          AppMethodBeat.o(47778);
          return;
          ((ImageView)localObject3).setVisibility(8);
          break;
          label763:
          localImageView2.setVisibility(8);
          break label201;
          localObject1 = (String)localObject2 + String.format("(w[%s])", new Object[] { localObject1 });
          break label434;
          localObject1 = (String)localObject2 + String.format("(st[%s])", new Object[] { localObject1 });
          break label434;
          localObject1 = (String)localObject2 + String.format("(ss[%s])", new Object[] { localObject1 });
          break label434;
          localTextView1.setText((CharSequence)localObject1);
          localTextView1.setVisibility(0);
          break label448;
          label893:
          localImageView1.setVisibility(8);
          break label462;
          label903:
          ((View)localObject3).setBackgroundResource(((l.b)localObject1).tur);
          localImageView2.setImageResource(((l.b)localObject1).tus);
          localTextView2.setText(((l.b)localObject1).desc);
          ((View)localObject3).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(47774);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.cH(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/page/AppBrandMenuHeader$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
              new l.6(this.tub, paramah).run();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/page/AppBrandMenuHeader$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(47774);
            }
          });
          ((View)localObject3).setVisibility(0);
          continue;
        }
        ((RecyclerView)localObject2).setVisibility(8);
      }
    }
    AppMethodBeat.o(47778);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.AppBrandMenuHeader
 * JD-Core Version:    0.7.0.1
 */