package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.fav.ui.s.a;
import com.tencent.mm.plugin.fav.ui.s.e;
import com.tencent.mm.plugin.fav.ui.s.i;

public final class b
{
  private boolean wSL = false;
  private View wSM;
  private ImageButton wSQ;
  private ImageButton wSR;
  private ImageButton wSS;
  private View wST;
  private View wSU;
  private View wSV;
  public a wSW;
  
  public final void eo(View paramView)
  {
    this.wSL = false;
    this.wSM = paramView;
  }
  
  public final void gR(boolean paramBoolean)
  {
    AppMethodBeat.i(107519);
    if (!this.wSL)
    {
      AppMethodBeat.o(107519);
      return;
    }
    this.wSQ.setEnabled(paramBoolean);
    this.wSR.setEnabled(paramBoolean);
    this.wSS.setEnabled(paramBoolean);
    AppMethodBeat.o(107519);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(107518);
    if (!this.wSL)
    {
      AppMethodBeat.o(107518);
      return;
    }
    if (this.wSM.getVisibility() != 8)
    {
      this.wSM.setVisibility(8);
      this.wSM.startAnimation(AnimationUtils.loadAnimation(this.wSM.getContext(), s.a.fast_faded_out));
    }
    AppMethodBeat.o(107518);
  }
  
  public final void nW(boolean paramBoolean)
  {
    AppMethodBeat.i(107517);
    if (!this.wSL)
    {
      if (this.wSM == null)
      {
        AppMethodBeat.o(107517);
        return;
      }
      if ((this.wSM instanceof ViewStub)) {
        this.wSM = ((ViewStub)this.wSM).inflate();
      }
      this.wST = this.wSM.findViewById(s.e.fav_space_1);
      this.wSU = this.wSM.findViewById(s.e.fav_space_2);
      this.wSV = this.wSM.findViewById(s.e.fav_space_3);
      this.wSQ = ((ImageButton)this.wSM.findViewById(s.e.fav_edit_forward));
      this.wSQ.setEnabled(false);
      this.wSQ.setContentDescription(this.wSQ.getContext().getString(s.i.transmit_btn));
      this.wSQ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107514);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          a.c("com/tencent/mm/plugin/fav/ui/widget/FavEditFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (b.this.wSW == null)
          {
            a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavEditFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107514);
            return;
          }
          b.this.wSW.dkY();
          a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavEditFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(107514);
        }
      });
      this.wSR = ((ImageButton)this.wSM.findViewById(s.e.fav_edit_addtag));
      this.wSR.setEnabled(false);
      this.wSR.setContentDescription(this.wSR.getContext().getString(s.i.edit_label_btn));
      this.wSR.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107515);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          a.c("com/tencent/mm/plugin/fav/ui/widget/FavEditFooter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (b.this.wSW == null)
          {
            a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavEditFooter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107515);
            return;
          }
          b.this.wSW.dkZ();
          a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavEditFooter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(107515);
        }
      });
      if (paramBoolean)
      {
        this.wSU.setVisibility(8);
        this.wSR.setVisibility(8);
      }
      this.wSS = ((ImageButton)this.wSM.findViewById(s.e.fav_edit_delete));
      this.wSS.setEnabled(false);
      this.wSS.setContentDescription(this.wSS.getContext().getString(s.i.delete_Imgbtn));
      this.wSS.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107516);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          a.c("com/tencent/mm/plugin/fav/ui/widget/FavEditFooter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (b.this.wSW == null)
          {
            a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavEditFooter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107516);
            return;
          }
          b.this.wSW.dkL();
          a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavEditFooter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(107516);
        }
      });
      this.wSL = true;
    }
    if (this.wSM.getVisibility() != 0)
    {
      this.wSM.setVisibility(0);
      this.wSM.startAnimation(AnimationUtils.loadAnimation(this.wSM.getContext(), s.a.fast_faded_in));
    }
    AppMethodBeat.o(107517);
  }
  
  public static abstract interface a
  {
    public abstract void dkL();
    
    public abstract void dkY();
    
    public abstract void dkZ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.b
 * JD-Core Version:    0.7.0.1
 */