package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.luggage.sdk.config.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.page.capsulebar.a.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.bu;

public class AppBrandMenuHeader
  extends LinearLayout
{
  private View jFG;
  
  public AppBrandMenuHeader(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(47775);
    aN(paramContext);
    AppMethodBeat.o(47775);
  }
  
  public AppBrandMenuHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(47776);
    aN(paramContext);
    AppMethodBeat.o(47776);
  }
  
  private void aN(Context paramContext)
  {
    AppMethodBeat.i(47777);
    this.jFG = LayoutInflater.from(paramContext).inflate(2131493012, this);
    AppMethodBeat.o(47777);
  }
  
  public void setPage(ad paramad)
  {
    AppMethodBeat.i(47778);
    Object localObject4 = paramad.getRuntime();
    Object localObject2 = (ImageView)this.jFG.findViewById(2131300874);
    TextView localTextView1 = (TextView)this.jFG.findViewById(2131302654);
    Object localObject1 = (TextView)this.jFG.findViewById(2131298942);
    ImageView localImageView1 = (ImageView)this.jFG.findViewById(2131303092);
    Object localObject3 = (ImageView)this.jFG.findViewById(2131306057);
    ImageView localImageView2 = (ImageView)this.jFG.findViewById(2131308168);
    label179:
    final TextView localTextView3;
    TextView localTextView2;
    if ((c.gA(paramad.getRuntime().aXw().kaX)) && (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qNj, 0) == 1))
    {
      ((ImageView)localObject3).setVisibility(0);
      if ((!c.gz(paramad.getRuntime().aXw().kaY)) || (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qPC, 0) != 1)) {
        break label425;
      }
      localImageView2.setVisibility(0);
      localTextView3 = (TextView)this.jFG.findViewById(2131304348);
      localObject3 = this.jFG.findViewById(2131305204);
      localImageView2 = (ImageView)this.jFG.findViewById(2131305201);
      localTextView2 = (TextView)this.jFG.findViewById(2131305199);
      View localView = this.jFG.findViewById(2131302659);
      localObject4 = h.ac((AppBrandRuntime)localObject4);
      Runnable localRunnable = ((h)localObject4).c(paramad);
      com.tencent.mm.modelappbrand.a.b.aEl().a((ImageView)localObject2, ((h)localObject4).buA(), com.tencent.mm.modelappbrand.a.a.aEk(), new com.tencent.mm.modelappbrand.a.g());
      ((ImageView)localObject2).setOnClickListener(new AppBrandMenuHeader.1(this, localRunnable));
      localView.setOnClickListener(new AppBrandMenuHeader.2(this, localRunnable));
      localTextView1.getPaint().setFakeBoldText(true);
      localTextView1.setText(((h)localObject4).buB());
      localObject2 = ((h)localObject4).buC();
      if (!bu.isNullOrNil((String)localObject2)) {
        break label435;
      }
      ((TextView)localObject1).setVisibility(8);
      label352:
      if (!((h)localObject4).buD()) {
        break label449;
      }
      localImageView1.setVisibility(0);
    }
    for (;;)
    {
      ((h)localObject4).a(new h.a()
      {
        public final void TL(String paramAnonymousString)
        {
          AppMethodBeat.i(47773);
          if (bu.isNullOrNil(paramAnonymousString))
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
      localObject1 = ((h)localObject4).uQ(a.a.ag(paramad.getRuntime()).bwn());
      if (localObject1 != null) {
        break label458;
      }
      ((View)localObject3).setVisibility(8);
      AppMethodBeat.o(47778);
      return;
      ((ImageView)localObject3).setVisibility(8);
      break;
      label425:
      localImageView2.setVisibility(8);
      break label179;
      label435:
      ((TextView)localObject1).setText((CharSequence)localObject2);
      ((TextView)localObject1).setVisibility(0);
      break label352;
      label449:
      localImageView1.setVisibility(8);
    }
    label458:
    ((View)localObject3).setBackgroundResource(((h.b)localObject1).mdL);
    localImageView2.setImageResource(((h.b)localObject1).mdM);
    localTextView2.setText(((h.b)localObject1).desc);
    ((View)localObject3).setOnClickListener(new AppBrandMenuHeader.4(this, (h)localObject4, paramad));
    ((View)localObject3).setVisibility(0);
    AppMethodBeat.o(47778);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.AppBrandMenuHeader
 * JD-Core Version:    0.7.0.1
 */