package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.ui.b.c;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class b
  extends e
{
  public TextView jXA;
  public View jXB;
  public View jXC;
  public TextView jXD;
  private View.OnClickListener jXE;
  public View jXr;
  public View jXs;
  public View jXt;
  public MMNeat7extView jXu;
  public TextView jXv;
  public View jXw;
  public ImageView jXx;
  public ImageView jXy;
  public View jXz;
  private Context mContext;
  
  public b(com.tencent.mm.plugin.brandservice.ui.timeline.a parama, Context paramContext)
  {
    AppMethodBeat.i(14239);
    this.jXE = new b.2(this);
    super.b(paramContext, parama);
    this.mContext = paramContext;
    AppMethodBeat.o(14239);
  }
  
  private static void P(View paramView, int paramInt)
  {
    AppMethodBeat.i(14241);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    localLayoutParams.width = paramInt;
    localLayoutParams.height = paramInt;
    paramView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(14241);
  }
  
  public final void a(ImageView paramImageView, com.tencent.mm.storage.q paramq, int paramInt, String paramString)
  {
    AppMethodBeat.i(14242);
    ((com.tencent.mm.plugin.brandservice.a.a)g.E(com.tencent.mm.plugin.brandservice.a.a.class)).a(paramImageView, paramq.field_msgId, paramString, paramq.field_content, paramInt);
    paramImageView.setOnClickListener(this.jXE);
    AppMethodBeat.o(14242);
  }
  
  public final void a(com.tencent.mm.af.q paramq, com.tencent.mm.storage.q paramq1, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(14240);
    if (paramq.type == 5)
    {
      this.jXy.setVisibility(0);
      this.jXy.setImageResource(2130837973);
      this.jXy.setOnClickListener(new b.1(this));
    }
    for (;;)
    {
      paramInt = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 28);
      if (paramq.type == 7) {
        paramInt = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 48);
      }
      P(this.jXy, paramInt);
      AppMethodBeat.o(14240);
      return;
      if (paramq.type == 6)
      {
        this.jXy.setVisibility(0);
        if (paramBoolean) {
          if ((paramq1.field_msgId + "_" + paramInt).equals(c.aZX())) {
            this.jXy.setImageResource(2130838314);
          }
        }
        for (;;)
        {
          a(this.jXy, paramq1, paramInt, paramq.fjJ);
          break;
          this.jXy.setImageResource(2130838315);
          continue;
          if ((paramq1.field_msgId + "_" + paramInt).equals(c.aZX())) {
            this.jXy.setImageResource(2131231112);
          } else {
            this.jXy.setImageResource(2131231115);
          }
        }
      }
      if (paramq.type == 7)
      {
        this.jXy.setVisibility(0);
        Drawable localDrawable = this.jXy.getDrawable();
        if (((localDrawable instanceof AnimationDrawable)) && (((AnimationDrawable)localDrawable).isRunning())) {
          ((AnimationDrawable)localDrawable).stop();
        }
        if ((paramq1.field_msgId + "_" + paramInt).equals(c.aZX()))
        {
          this.jXy.setImageResource(2130837975);
          if ((this.jXy.getDrawable() instanceof AnimationDrawable)) {
            ((AnimationDrawable)this.jXy.getDrawable()).start();
          }
        }
        for (;;)
        {
          a(this.jXy, paramq1, paramInt, paramq.fjJ);
          break;
          this.jXy.setImageResource(2130837974);
        }
      }
      this.jXy.setVisibility(8);
    }
  }
  
  public final void a(com.tencent.mm.af.q paramq, boolean paramBoolean)
  {
    AppMethodBeat.i(152629);
    if (paramq.type == 8)
    {
      this.jXB.setVisibility(0);
      if (paramq.fjZ > 1)
      {
        this.jXD.setVisibility(0);
        this.jXD.setText(String.valueOf(paramq.fjZ));
      }
      while (paramBoolean)
      {
        this.jXC.setBackgroundResource(2130837982);
        AppMethodBeat.o(152629);
        return;
        this.jXD.setVisibility(8);
      }
      this.jXC.setBackgroundResource(2130839676);
      AppMethodBeat.o(152629);
      return;
    }
    this.jXB.setVisibility(8);
    AppMethodBeat.o(152629);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.b
 * JD-Core Version:    0.7.0.1
 */