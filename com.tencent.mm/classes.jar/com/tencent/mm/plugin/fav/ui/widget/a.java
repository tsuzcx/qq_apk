package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
{
  public Button jll;
  public TextView pbJ;
  public boolean rMB;
  public View rMC;
  public a rMD;
  public long rMz;
  
  public a()
  {
    AppMethodBeat.i(107507);
    this.rMB = false;
    this.rMz = com.tencent.mm.plugin.fav.a.b.cwe();
    AppMethodBeat.o(107507);
  }
  
  public final void cyN()
  {
    AppMethodBeat.i(107510);
    this.pbJ.setText(this.pbJ.getContext().getString(2131758821, new Object[] { com.tencent.mm.plugin.fav.a.b.vL(this.rMz) }));
    this.jll.setEnabled(false);
    AppMethodBeat.o(107510);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(107509);
    if (!this.rMB)
    {
      AppMethodBeat.o(107509);
      return;
    }
    if (this.rMC.getVisibility() != 8)
    {
      this.rMC.setVisibility(8);
      this.rMC.startAnimation(AnimationUtils.loadAnimation(this.rMC.getContext(), 2130772048));
    }
    AppMethodBeat.o(107509);
  }
  
  public final void show()
  {
    AppMethodBeat.i(107508);
    if (!this.rMB)
    {
      if (this.rMC == null)
      {
        AppMethodBeat.o(107508);
        return;
      }
      if ((this.rMC instanceof ViewStub)) {
        this.rMC = ((ViewStub)this.rMC).inflate();
      }
      this.pbJ = ((TextView)this.rMC.findViewById(2131299773));
      if (!ad.foi()) {
        this.pbJ.setTextSize(1, 14.0F);
      }
      this.jll = ((Button)this.rMC.findViewById(2131299772));
      cyN();
      this.jll.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107506);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/widget/FavCleanFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (a.this.rMD == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavCleanFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107506);
            return;
          }
          a.this.rMD.cxB();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavCleanFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(107506);
        }
      });
      this.rMB = true;
    }
    if (this.rMC.getVisibility() != 0)
    {
      this.rMC.setVisibility(0);
      this.rMC.startAnimation(AnimationUtils.loadAnimation(this.rMC.getContext(), 2130772047));
    }
    AppMethodBeat.o(107508);
  }
  
  public static abstract interface a
  {
    public abstract void cxB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.a
 * JD-Core Version:    0.7.0.1
 */