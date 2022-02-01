package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

public final class a
{
  public Button jis;
  public TextView oVg;
  public long rEo;
  public boolean rEq;
  public View rEr;
  public a rEs;
  
  public a()
  {
    AppMethodBeat.i(107507);
    this.rEq = false;
    this.rEo = com.tencent.mm.plugin.fav.a.b.cuD();
    AppMethodBeat.o(107507);
  }
  
  public final void cxm()
  {
    AppMethodBeat.i(107510);
    this.oVg.setText(this.oVg.getContext().getString(2131758821, new Object[] { com.tencent.mm.plugin.fav.a.b.vv(this.rEo) }));
    this.jis.setEnabled(false);
    AppMethodBeat.o(107510);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(107509);
    if (!this.rEq)
    {
      AppMethodBeat.o(107509);
      return;
    }
    if (this.rEr.getVisibility() != 8)
    {
      this.rEr.setVisibility(8);
      this.rEr.startAnimation(AnimationUtils.loadAnimation(this.rEr.getContext(), 2130772048));
    }
    AppMethodBeat.o(107509);
  }
  
  public final void show()
  {
    AppMethodBeat.i(107508);
    if (!this.rEq)
    {
      if (this.rEr == null)
      {
        AppMethodBeat.o(107508);
        return;
      }
      if ((this.rEr instanceof ViewStub)) {
        this.rEr = ((ViewStub)this.rEr).inflate();
      }
      this.oVg = ((TextView)this.rEr.findViewById(2131299773));
      if (!ac.fko()) {
        this.oVg.setTextSize(1, 14.0F);
      }
      this.jis = ((Button)this.rEr.findViewById(2131299772));
      cxm();
      this.jis.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107506);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/widget/FavCleanFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (a.this.rEs == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavCleanFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107506);
            return;
          }
          a.this.rEs.cwa();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavCleanFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(107506);
        }
      });
      this.rEq = true;
    }
    if (this.rEr.getVisibility() != 0)
    {
      this.rEr.setVisibility(0);
      this.rEr.startAnimation(AnimationUtils.loadAnimation(this.rEr.getContext(), 2130772047));
    }
    AppMethodBeat.o(107508);
  }
  
  public static abstract interface a
  {
    public abstract void cwa();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.a
 * JD-Core Version:    0.7.0.1
 */