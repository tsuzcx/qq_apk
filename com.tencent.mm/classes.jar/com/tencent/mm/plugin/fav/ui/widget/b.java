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
  private View rEA;
  public a rEB;
  private boolean rEq = false;
  private View rEr;
  private ImageButton rEv;
  private ImageButton rEw;
  private ImageButton rEx;
  private View rEy;
  private View rEz;
  
  public final void dY(View paramView)
  {
    this.rEq = false;
    this.rEr = paramView;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(107518);
    if (!this.rEq)
    {
      AppMethodBeat.o(107518);
      return;
    }
    if (this.rEr.getVisibility() != 8)
    {
      this.rEr.setVisibility(8);
      this.rEr.startAnimation(AnimationUtils.loadAnimation(this.rEr.getContext(), 2130772048));
    }
    AppMethodBeat.o(107518);
  }
  
  public final void lF(boolean paramBoolean)
  {
    AppMethodBeat.i(107517);
    if (!this.rEq)
    {
      if (this.rEr == null)
      {
        AppMethodBeat.o(107517);
        return;
      }
      if ((this.rEr instanceof ViewStub)) {
        this.rEr = ((ViewStub)this.rEr).inflate();
      }
      this.rEy = this.rEr.findViewById(2131299826);
      this.rEz = this.rEr.findViewById(2131299827);
      this.rEA = this.rEr.findViewById(2131299828);
      this.rEv = ((ImageButton)this.rEr.findViewById(2131299787));
      this.rEv.setEnabled(false);
      this.rEv.setContentDescription(this.rEv.getContext().getString(2131764539));
      this.rEv.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107514);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          a.b("com/tencent/mm/plugin/fav/ui/widget/FavEditFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (b.this.rEB == null)
          {
            a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavEditFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107514);
            return;
          }
          b.this.rEB.cwn();
          a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavEditFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(107514);
        }
      });
      this.rEw = ((ImageButton)this.rEr.findViewById(2131299784));
      this.rEw.setEnabled(false);
      this.rEw.setContentDescription(this.rEw.getContext().getString(2131758179));
      this.rEw.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107515);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          a.b("com/tencent/mm/plugin/fav/ui/widget/FavEditFooter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (b.this.rEB == null)
          {
            a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavEditFooter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107515);
            return;
          }
          b.this.rEB.cwo();
          a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavEditFooter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(107515);
        }
      });
      if (paramBoolean)
      {
        this.rEz.setVisibility(8);
        this.rEw.setVisibility(8);
      }
      this.rEx = ((ImageButton)this.rEr.findViewById(2131299785));
      this.rEx.setEnabled(false);
      this.rEx.setContentDescription(this.rEx.getContext().getString(2131758030));
      this.rEx.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107516);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          a.b("com/tencent/mm/plugin/fav/ui/widget/FavEditFooter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (b.this.rEB == null)
          {
            a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavEditFooter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107516);
            return;
          }
          b.this.rEB.cwa();
          a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavEditFooter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(107516);
        }
      });
      this.rEq = true;
    }
    if (this.rEr.getVisibility() != 0)
    {
      this.rEr.setVisibility(0);
      this.rEr.startAnimation(AnimationUtils.loadAnimation(this.rEr.getContext(), 2130772047));
    }
    AppMethodBeat.o(107517);
  }
  
  public final void lG(boolean paramBoolean)
  {
    AppMethodBeat.i(107519);
    if (!this.rEq)
    {
      AppMethodBeat.o(107519);
      return;
    }
    this.rEv.setEnabled(paramBoolean);
    this.rEw.setEnabled(paramBoolean);
    this.rEx.setEnabled(paramBoolean);
    AppMethodBeat.o(107519);
  }
  
  public static abstract interface a
  {
    public abstract void cwa();
    
    public abstract void cwn();
    
    public abstract void cwo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.b
 * JD-Core Version:    0.7.0.1
 */