package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.luggage.sdk.config.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.page.capsulebar.a.a;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Util;

public class AppBrandMenuHeader
  extends LinearLayout
{
  private View kHq;
  
  public AppBrandMenuHeader(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(47775);
    bh(paramContext);
    AppMethodBeat.o(47775);
  }
  
  public AppBrandMenuHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(47776);
    bh(paramContext);
    AppMethodBeat.o(47776);
  }
  
  private void bh(Context paramContext)
  {
    AppMethodBeat.i(47777);
    this.kHq = LayoutInflater.from(paramContext).inflate(2131493050, this);
    AppMethodBeat.o(47777);
  }
  
  public void setPage(ag paramag)
  {
    AppMethodBeat.i(47778);
    Object localObject4 = paramag.getRuntime();
    Object localObject2 = (ImageView)this.kHq.findViewById(2131302468);
    TextView localTextView1 = (TextView)this.kHq.findViewById(2131305208);
    Object localObject1 = (TextView)this.kHq.findViewById(2131299432);
    ImageView localImageView1 = (ImageView)this.kHq.findViewById(2131305709);
    Object localObject3 = (ImageView)this.kHq.findViewById(2131309387);
    ImageView localImageView2 = (ImageView)this.kHq.findViewById(2131305578);
    label179:
    TextView localTextView3;
    TextView localTextView2;
    if ((e.hP(paramag.getRuntime().bsB().leb)) && (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.ske, 0) == 1))
    {
      ((ImageView)localObject3).setVisibility(0);
      if ((!e.hO(paramag.getRuntime().bsB().lec)) || (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.smL, 0) != 1)) {
        break label425;
      }
      localImageView2.setVisibility(0);
      localTextView3 = (TextView)this.kHq.findViewById(2131307282);
      localObject3 = this.kHq.findViewById(2131308401);
      localImageView2 = (ImageView)this.kHq.findViewById(2131308398);
      localTextView2 = (TextView)this.kHq.findViewById(2131308396);
      View localView = this.kHq.findViewById(2131305213);
      localObject4 = k.ad((AppBrandRuntime)localObject4);
      Runnable localRunnable = ((k)localObject4).c(paramag);
      com.tencent.mm.modelappbrand.a.b.aXY().a((ImageView)localObject2, ((k)localObject4).bQA(), com.tencent.mm.modelappbrand.a.a.aXX(), new com.tencent.mm.modelappbrand.a.g());
      ((ImageView)localObject2).setOnClickListener(new AppBrandMenuHeader.1(this, localRunnable));
      localView.setOnClickListener(new AppBrandMenuHeader.2(this, localRunnable));
      localTextView1.getPaint().setFakeBoldText(true);
      localTextView1.setText(((k)localObject4).bQB());
      localObject2 = ((k)localObject4).bQC();
      if (!Util.isNullOrNil((String)localObject2)) {
        break label435;
      }
      ((TextView)localObject1).setVisibility(8);
      label352:
      if (!((k)localObject4).bQD()) {
        break label449;
      }
      localImageView1.setVisibility(0);
    }
    for (;;)
    {
      ((k)localObject4).a(new AppBrandMenuHeader.3(this, localTextView3));
      localObject1 = ((k)localObject4).yI(a.a.ah(paramag.getRuntime()).bSu());
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
    ((View)localObject3).setBackgroundResource(((k.b)localObject1).nod);
    localImageView2.setImageResource(((k.b)localObject1).noe);
    localTextView2.setText(((k.b)localObject1).desc);
    ((View)localObject3).setOnClickListener(new AppBrandMenuHeader.4(this, (k)localObject4, paramag));
    ((View)localObject3).setVisibility(0);
    AppMethodBeat.o(47778);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.AppBrandMenuHeader
 * JD-Core Version:    0.7.0.1
 */