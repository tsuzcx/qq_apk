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
  private boolean tmn = false;
  private View tmo;
  private ImageButton tms;
  private ImageButton tmt;
  private ImageButton tmu;
  private View tmv;
  private View tmw;
  private View tmx;
  public a tmy;
  
  public final void dQ(View paramView)
  {
    this.tmn = false;
    this.tmo = paramView;
  }
  
  public final void gf(boolean paramBoolean)
  {
    AppMethodBeat.i(107519);
    if (!this.tmn)
    {
      AppMethodBeat.o(107519);
      return;
    }
    this.tms.setEnabled(paramBoolean);
    this.tmt.setEnabled(paramBoolean);
    this.tmu.setEnabled(paramBoolean);
    AppMethodBeat.o(107519);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(107518);
    if (!this.tmn)
    {
      AppMethodBeat.o(107518);
      return;
    }
    if (this.tmo.getVisibility() != 8)
    {
      this.tmo.setVisibility(8);
      this.tmo.startAnimation(AnimationUtils.loadAnimation(this.tmo.getContext(), 2130772060));
    }
    AppMethodBeat.o(107518);
  }
  
  public final void mI(boolean paramBoolean)
  {
    AppMethodBeat.i(107517);
    if (!this.tmn)
    {
      if (this.tmo == null)
      {
        AppMethodBeat.o(107517);
        return;
      }
      if ((this.tmo instanceof ViewStub)) {
        this.tmo = ((ViewStub)this.tmo).inflate();
      }
      this.tmv = this.tmo.findViewById(2131300504);
      this.tmw = this.tmo.findViewById(2131300505);
      this.tmx = this.tmo.findViewById(2131300506);
      this.tms = ((ImageButton)this.tmo.findViewById(2131300460));
      this.tms.setEnabled(false);
      this.tms.setContentDescription(this.tms.getContext().getString(2131766884));
      this.tms.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107514);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          a.b("com/tencent/mm/plugin/fav/ui/widget/FavEditFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (b.this.tmy == null)
          {
            a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavEditFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107514);
            return;
          }
          b.this.tmy.cVS();
          a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavEditFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(107514);
        }
      });
      this.tmt = ((ImageButton)this.tmo.findViewById(2131300457));
      this.tmt.setEnabled(false);
      this.tmt.setContentDescription(this.tmt.getContext().getString(2131758457));
      this.tmt.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107515);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          a.b("com/tencent/mm/plugin/fav/ui/widget/FavEditFooter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (b.this.tmy == null)
          {
            a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavEditFooter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107515);
            return;
          }
          b.this.tmy.cVT();
          a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavEditFooter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(107515);
        }
      });
      if (paramBoolean)
      {
        this.tmw.setVisibility(8);
        this.tmt.setVisibility(8);
      }
      this.tmu = ((ImageButton)this.tmo.findViewById(2131300458));
      this.tmu.setEnabled(false);
      this.tmu.setContentDescription(this.tmu.getContext().getString(2131758282));
      this.tmu.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107516);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          a.b("com/tencent/mm/plugin/fav/ui/widget/FavEditFooter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (b.this.tmy == null)
          {
            a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavEditFooter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107516);
            return;
          }
          b.this.tmy.cVF();
          a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavEditFooter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(107516);
        }
      });
      this.tmn = true;
    }
    if (this.tmo.getVisibility() != 0)
    {
      this.tmo.setVisibility(0);
      this.tmo.startAnimation(AnimationUtils.loadAnimation(this.tmo.getContext(), 2130772059));
    }
    AppMethodBeat.o(107517);
  }
  
  public static abstract interface a
  {
    public abstract void cVF();
    
    public abstract void cVS();
    
    public abstract void cVT();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.b
 * JD-Core Version:    0.7.0.1
 */