package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  private boolean qlA = false;
  private View qlB;
  private ImageButton qlF;
  private ImageButton qlG;
  private ImageButton qlH;
  private View qlI;
  private View qlJ;
  private View qlK;
  public a qlL;
  
  public final void dP(View paramView)
  {
    this.qlA = false;
    this.qlB = paramView;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(107518);
    if (!this.qlA)
    {
      AppMethodBeat.o(107518);
      return;
    }
    if (this.qlB.getVisibility() != 8)
    {
      this.qlB.setVisibility(8);
      this.qlB.startAnimation(AnimationUtils.loadAnimation(this.qlB.getContext(), 2130772048));
    }
    AppMethodBeat.o(107518);
  }
  
  public final void kI(boolean paramBoolean)
  {
    AppMethodBeat.i(107517);
    if (!this.qlA)
    {
      if (this.qlB == null)
      {
        AppMethodBeat.o(107517);
        return;
      }
      if ((this.qlB instanceof ViewStub)) {
        this.qlB = ((ViewStub)this.qlB).inflate();
      }
      this.qlI = this.qlB.findViewById(2131299826);
      this.qlJ = this.qlB.findViewById(2131299827);
      this.qlK = this.qlB.findViewById(2131299828);
      this.qlF = ((ImageButton)this.qlB.findViewById(2131299787));
      this.qlF.setEnabled(false);
      this.qlF.setContentDescription(this.qlF.getContext().getString(2131764539));
      this.qlF.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107514);
          if (b.this.qlL == null)
          {
            AppMethodBeat.o(107514);
            return;
          }
          b.this.qlL.ciW();
          AppMethodBeat.o(107514);
        }
      });
      this.qlG = ((ImageButton)this.qlB.findViewById(2131299784));
      this.qlG.setEnabled(false);
      this.qlG.setContentDescription(this.qlG.getContext().getString(2131758179));
      this.qlG.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107515);
          if (b.this.qlL == null)
          {
            AppMethodBeat.o(107515);
            return;
          }
          b.this.qlL.ciX();
          AppMethodBeat.o(107515);
        }
      });
      if (paramBoolean)
      {
        this.qlJ.setVisibility(8);
        this.qlG.setVisibility(8);
      }
      this.qlH = ((ImageButton)this.qlB.findViewById(2131299785));
      this.qlH.setEnabled(false);
      this.qlH.setContentDescription(this.qlH.getContext().getString(2131758030));
      this.qlH.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107516);
          if (b.this.qlL == null)
          {
            AppMethodBeat.o(107516);
            return;
          }
          b.this.qlL.ciO();
          AppMethodBeat.o(107516);
        }
      });
      this.qlA = true;
    }
    if (this.qlB.getVisibility() != 0)
    {
      this.qlB.setVisibility(0);
      this.qlB.startAnimation(AnimationUtils.loadAnimation(this.qlB.getContext(), 2130772047));
    }
    AppMethodBeat.o(107517);
  }
  
  public final void kJ(boolean paramBoolean)
  {
    AppMethodBeat.i(107519);
    if (!this.qlA)
    {
      AppMethodBeat.o(107519);
      return;
    }
    this.qlF.setEnabled(paramBoolean);
    this.qlG.setEnabled(paramBoolean);
    this.qlH.setEnabled(paramBoolean);
    AppMethodBeat.o(107519);
  }
  
  public static abstract interface a
  {
    public abstract void ciO();
    
    public abstract void ciW();
    
    public abstract void ciX();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.b
 * JD-Core Version:    0.7.0.1
 */