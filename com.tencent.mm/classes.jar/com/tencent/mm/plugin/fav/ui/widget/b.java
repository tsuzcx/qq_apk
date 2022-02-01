package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;

public final class b
{
  private boolean rMB = false;
  private View rMC;
  private ImageButton rMG;
  private ImageButton rMH;
  private ImageButton rMI;
  private View rMJ;
  private View rMK;
  private View rML;
  public a rMM;
  
  public final void dY(View paramView)
  {
    this.rMB = false;
    this.rMC = paramView;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(107518);
    if (!this.rMB)
    {
      AppMethodBeat.o(107518);
      return;
    }
    if (this.rMC.getVisibility() != 8)
    {
      this.rMC.setVisibility(8);
      this.rMC.startAnimation(AnimationUtils.loadAnimation(this.rMC.getContext(), 2130772048));
    }
    AppMethodBeat.o(107518);
  }
  
  public final void lF(boolean paramBoolean)
  {
    AppMethodBeat.i(107517);
    if (!this.rMB)
    {
      if (this.rMC == null)
      {
        AppMethodBeat.o(107517);
        return;
      }
      if ((this.rMC instanceof ViewStub)) {
        this.rMC = ((ViewStub)this.rMC).inflate();
      }
      this.rMJ = this.rMC.findViewById(2131299826);
      this.rMK = this.rMC.findViewById(2131299827);
      this.rML = this.rMC.findViewById(2131299828);
      this.rMG = ((ImageButton)this.rMC.findViewById(2131299787));
      this.rMG.setEnabled(false);
      this.rMG.setContentDescription(this.rMG.getContext().getString(2131764539));
      this.rMG.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107514);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          a.b("com/tencent/mm/plugin/fav/ui/widget/FavEditFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (b.this.rMM == null)
          {
            a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavEditFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107514);
            return;
          }
          b.this.rMM.cxO();
          a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavEditFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(107514);
        }
      });
      this.rMH = ((ImageButton)this.rMC.findViewById(2131299784));
      this.rMH.setEnabled(false);
      this.rMH.setContentDescription(this.rMH.getContext().getString(2131758179));
      this.rMH.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107515);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          a.b("com/tencent/mm/plugin/fav/ui/widget/FavEditFooter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (b.this.rMM == null)
          {
            a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavEditFooter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107515);
            return;
          }
          b.this.rMM.cxP();
          a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavEditFooter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(107515);
        }
      });
      if (paramBoolean)
      {
        this.rMK.setVisibility(8);
        this.rMH.setVisibility(8);
      }
      this.rMI = ((ImageButton)this.rMC.findViewById(2131299785));
      this.rMI.setEnabled(false);
      this.rMI.setContentDescription(this.rMI.getContext().getString(2131758030));
      this.rMI.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107516);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          a.b("com/tencent/mm/plugin/fav/ui/widget/FavEditFooter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (b.this.rMM == null)
          {
            a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavEditFooter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107516);
            return;
          }
          b.this.rMM.cxB();
          a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavEditFooter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(107516);
        }
      });
      this.rMB = true;
    }
    if (this.rMC.getVisibility() != 0)
    {
      this.rMC.setVisibility(0);
      this.rMC.startAnimation(AnimationUtils.loadAnimation(this.rMC.getContext(), 2130772047));
    }
    AppMethodBeat.o(107517);
  }
  
  public final void lG(boolean paramBoolean)
  {
    AppMethodBeat.i(107519);
    if (!this.rMB)
    {
      AppMethodBeat.o(107519);
      return;
    }
    this.rMG.setEnabled(paramBoolean);
    this.rMH.setEnabled(paramBoolean);
    this.rMI.setEnabled(paramBoolean);
    AppMethodBeat.o(107519);
  }
  
  public static abstract interface a
  {
    public abstract void cxB();
    
    public abstract void cxO();
    
    public abstract void cxP();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.b
 * JD-Core Version:    0.7.0.1
 */