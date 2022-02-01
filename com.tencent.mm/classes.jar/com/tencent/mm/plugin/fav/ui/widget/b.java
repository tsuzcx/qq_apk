package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.fav.ui.q.a;
import com.tencent.mm.plugin.fav.ui.q.e;
import com.tencent.mm.plugin.fav.ui.q.i;

public final class b
{
  private boolean Apo = false;
  private View App;
  private ImageButton Apt;
  private ImageButton Apu;
  private ImageButton Apv;
  private View Apw;
  private View Apx;
  private View Apy;
  public a Apz;
  
  public final void fj(View paramView)
  {
    this.Apo = false;
    this.App = paramView;
  }
  
  public final void hH(boolean paramBoolean)
  {
    AppMethodBeat.i(107519);
    if (!this.Apo)
    {
      AppMethodBeat.o(107519);
      return;
    }
    this.Apt.setEnabled(paramBoolean);
    this.Apu.setEnabled(paramBoolean);
    this.Apv.setEnabled(paramBoolean);
    AppMethodBeat.o(107519);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(107518);
    if (!this.Apo)
    {
      AppMethodBeat.o(107518);
      return;
    }
    if (this.App.getVisibility() != 8)
    {
      this.App.setVisibility(8);
      this.App.startAnimation(AnimationUtils.loadAnimation(this.App.getContext(), q.a.fast_faded_out));
    }
    AppMethodBeat.o(107518);
  }
  
  public final void pw(boolean paramBoolean)
  {
    AppMethodBeat.i(107517);
    if (!this.Apo)
    {
      if (this.App == null)
      {
        AppMethodBeat.o(107517);
        return;
      }
      if ((this.App instanceof ViewStub)) {
        this.App = ((ViewStub)this.App).inflate();
      }
      this.Apw = this.App.findViewById(q.e.fav_space_1);
      this.Apx = this.App.findViewById(q.e.fav_space_2);
      this.Apy = this.App.findViewById(q.e.fav_space_3);
      this.Apt = ((ImageButton)this.App.findViewById(q.e.fav_edit_forward));
      this.Apt.setEnabled(false);
      this.Apt.setContentDescription(this.Apt.getContext().getString(q.i.transmit_btn));
      this.Apt.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107514);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          a.c("com/tencent/mm/plugin/fav/ui/widget/FavEditFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (b.this.Apz == null)
          {
            a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavEditFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107514);
            return;
          }
          b.this.Apz.dRO();
          a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavEditFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(107514);
        }
      });
      this.Apu = ((ImageButton)this.App.findViewById(q.e.fav_edit_addtag));
      this.Apu.setEnabled(false);
      this.Apu.setContentDescription(this.Apu.getContext().getString(q.i.edit_label_btn));
      this.Apu.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107515);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          a.c("com/tencent/mm/plugin/fav/ui/widget/FavEditFooter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (b.this.Apz == null)
          {
            a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavEditFooter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107515);
            return;
          }
          b.this.Apz.dRP();
          a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavEditFooter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(107515);
        }
      });
      if (paramBoolean)
      {
        this.Apx.setVisibility(8);
        this.Apu.setVisibility(8);
      }
      this.Apv = ((ImageButton)this.App.findViewById(q.e.fav_edit_delete));
      this.Apv.setEnabled(false);
      this.Apv.setContentDescription(this.Apv.getContext().getString(q.i.delete_Imgbtn));
      this.Apv.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107516);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          a.c("com/tencent/mm/plugin/fav/ui/widget/FavEditFooter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (b.this.Apz == null)
          {
            a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavEditFooter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107516);
            return;
          }
          b.this.Apz.dRB();
          a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavEditFooter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(107516);
        }
      });
      this.Apo = true;
    }
    if (this.App.getVisibility() != 0)
    {
      this.App.setVisibility(0);
      this.App.startAnimation(AnimationUtils.loadAnimation(this.App.getContext(), q.a.fast_faded_in));
    }
    AppMethodBeat.o(107517);
  }
  
  public static abstract interface a
  {
    public abstract void dRB();
    
    public abstract void dRO();
    
    public abstract void dRP();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.b
 * JD-Core Version:    0.7.0.1
 */