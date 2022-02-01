package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.luggage.sdk.config.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.bt;

public class AppBrandMenuHeader
  extends LinearLayout
{
  private View jCI;
  
  public AppBrandMenuHeader(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(47775);
    aM(paramContext);
    AppMethodBeat.o(47775);
  }
  
  public AppBrandMenuHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(47776);
    aM(paramContext);
    AppMethodBeat.o(47776);
  }
  
  private void aM(Context paramContext)
  {
    AppMethodBeat.i(47777);
    this.jCI = LayoutInflater.from(paramContext).inflate(2131493012, this);
    AppMethodBeat.o(47777);
  }
  
  public void setPage(final ae paramae)
  {
    AppMethodBeat.i(47778);
    Object localObject4 = paramae.getRuntime();
    Object localObject2 = (ImageView)this.jCI.findViewById(2131300874);
    TextView localTextView1 = (TextView)this.jCI.findViewById(2131302654);
    Object localObject1 = (TextView)this.jCI.findViewById(2131298942);
    ImageView localImageView1 = (ImageView)this.jCI.findViewById(2131303092);
    Object localObject3 = (ImageView)this.jCI.findViewById(2131306057);
    ImageView localImageView2 = (ImageView)this.jCI.findViewById(2131308168);
    label179:
    final TextView localTextView3;
    TextView localTextView2;
    if ((c.gA(paramae.getRuntime().aXb().jXI)) && (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qFD, 0) == 1))
    {
      ((ImageView)localObject3).setVisibility(0);
      if ((!c.gz(paramae.getRuntime().aXb().jXJ)) || (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qHW, 0) != 1)) {
        break label417;
      }
      localImageView2.setVisibility(0);
      localTextView3 = (TextView)this.jCI.findViewById(2131304348);
      localObject3 = this.jCI.findViewById(2131305204);
      localImageView2 = (ImageView)this.jCI.findViewById(2131305201);
      localTextView2 = (TextView)this.jCI.findViewById(2131305199);
      View localView = this.jCI.findViewById(2131302659);
      localObject4 = i.ad((AppBrandRuntime)localObject4);
      final Runnable localRunnable = ((i)localObject4).c(paramae);
      com.tencent.mm.modelappbrand.a.b.aDV().a((ImageView)localObject2, ((i)localObject4).btP(), com.tencent.mm.modelappbrand.a.a.aDU(), new com.tencent.mm.modelappbrand.a.g());
      ((ImageView)localObject2).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(47771);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/page/AppBrandMenuHeader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          localRunnable.run();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/page/AppBrandMenuHeader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(47771);
        }
      });
      localView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(47772);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/page/AppBrandMenuHeader$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          localRunnable.run();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/page/AppBrandMenuHeader$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(47772);
        }
      });
      localTextView1.getPaint().setFakeBoldText(true);
      localTextView1.setText(((i)localObject4).btQ());
      localObject2 = ((i)localObject4).btR();
      if (!bt.isNullOrNil((String)localObject2)) {
        break label427;
      }
      ((TextView)localObject1).setVisibility(8);
      label352:
      if (!((i)localObject4).btS()) {
        break label441;
      }
      localImageView1.setVisibility(0);
    }
    for (;;)
    {
      ((i)localObject4).a(new i.a()
      {
        public final void Tc(String paramAnonymousString)
        {
          AppMethodBeat.i(47773);
          if (bt.isNullOrNil(paramAnonymousString))
          {
            localTextView3.setVisibility(8);
            AppMethodBeat.o(47773);
            return;
          }
          localTextView3.setText(paramAnonymousString);
          localTextView3.setVisibility(0);
          AppMethodBeat.o(47773);
        }
      });
      localObject1 = ((i)localObject4).uL(paramae.mca);
      if (localObject1 != null) {
        break label450;
      }
      ((View)localObject3).setVisibility(8);
      AppMethodBeat.o(47778);
      return;
      ((ImageView)localObject3).setVisibility(8);
      break;
      label417:
      localImageView2.setVisibility(8);
      break label179;
      label427:
      ((TextView)localObject1).setText((CharSequence)localObject2);
      ((TextView)localObject1).setVisibility(0);
      break label352;
      label441:
      localImageView1.setVisibility(8);
    }
    label450:
    ((View)localObject3).setBackgroundResource(((i.b)localObject1).lZs);
    localImageView2.setImageResource(((i.b)localObject1).lZt);
    localTextView2.setText(((i.b)localObject1).desc);
    ((View)localObject3).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(47774);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/page/AppBrandMenuHeader$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        new i.6(this.lZg, paramae).run();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/page/AppBrandMenuHeader$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(47774);
      }
    });
    ((View)localObject3).setVisibility(0);
    AppMethodBeat.o(47778);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.AppBrandMenuHeader
 * JD-Core Version:    0.7.0.1
 */