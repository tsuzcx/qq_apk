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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.bs;

public class AppBrandMenuHeader
  extends LinearLayout
{
  private View jja;
  
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
    this.jja = LayoutInflater.from(paramContext).inflate(2131493012, this);
    AppMethodBeat.o(47777);
  }
  
  public void setPage(final ae paramae)
  {
    AppMethodBeat.i(47778);
    Object localObject4 = paramae.getRuntime();
    Object localObject3 = (ImageView)this.jja.findViewById(2131300874);
    TextView localTextView2 = (TextView)this.jja.findViewById(2131302654);
    Object localObject1 = (TextView)this.jja.findViewById(2131298942);
    ImageView localImageView1 = (ImageView)this.jja.findViewById(2131303092);
    Object localObject2 = (ImageView)this.jja.findViewById(2131306057);
    final TextView localTextView3;
    ImageView localImageView2;
    TextView localTextView1;
    if ((paramae.getRuntime().aTR().ccR == 1) && (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.qah, 0) == 1))
    {
      ((ImageView)localObject2).setVisibility(0);
      localTextView3 = (TextView)this.jja.findViewById(2131304348);
      localObject2 = this.jja.findViewById(2131305204);
      localImageView2 = (ImageView)this.jja.findViewById(2131305201);
      localTextView1 = (TextView)this.jja.findViewById(2131305199);
      View localView = this.jja.findViewById(2131302659);
      localObject4 = i.aj((AppBrandRuntime)localObject4);
      final Runnable localRunnable = ((i)localObject4).c(paramae);
      com.tencent.mm.modelappbrand.a.b.aAS().a((ImageView)localObject3, ((i)localObject4).bpP(), a.aAR(), new com.tencent.mm.modelappbrand.a.g());
      ((ImageView)localObject3).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(47771);
          localRunnable.run();
          AppMethodBeat.o(47771);
        }
      });
      localView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(47772);
          localRunnable.run();
          AppMethodBeat.o(47772);
        }
      });
      localTextView2.getPaint().setFakeBoldText(true);
      localTextView2.setText(((i)localObject4).bpQ());
      localObject3 = ((i)localObject4).bpR();
      if (!bs.isNullOrNil((String)localObject3)) {
        break label358;
      }
      ((TextView)localObject1).setVisibility(8);
      label293:
      if (!((i)localObject4).bpS()) {
        break label372;
      }
      localImageView1.setVisibility(0);
    }
    for (;;)
    {
      ((i)localObject4).a(new i.a()
      {
        public final void Pz(String paramAnonymousString)
        {
          AppMethodBeat.i(47773);
          if (bs.isNullOrNil(paramAnonymousString))
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
      localObject1 = ((i)localObject4).uh(paramae.lCz);
      if (localObject1 != null) {
        break label381;
      }
      ((View)localObject2).setVisibility(8);
      AppMethodBeat.o(47778);
      return;
      ((ImageView)localObject2).setVisibility(8);
      break;
      label358:
      ((TextView)localObject1).setText((CharSequence)localObject3);
      ((TextView)localObject1).setVisibility(0);
      break label293;
      label372:
      localImageView1.setVisibility(8);
    }
    label381:
    ((View)localObject2).setBackgroundResource(((i.b)localObject1).lzU);
    localImageView2.setImageResource(((i.b)localObject1).lzV);
    localTextView1.setText(((i.b)localObject1).desc);
    ((View)localObject2).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(47774);
        new i.6(this.lzI, paramae).run();
        AppMethodBeat.o(47774);
      }
    });
    ((View)localObject2).setVisibility(0);
    AppMethodBeat.o(47778);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.AppBrandMenuHeader
 * JD-Core Version:    0.7.0.1
 */