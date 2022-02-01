package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.sdk.platformtools.ac;

public final class a
{
  public Button ipd;
  public TextView nOI;
  public boolean qlA;
  public View qlB;
  public a qlC;
  public long qly;
  
  public a()
  {
    AppMethodBeat.i(107507);
    this.qlA = false;
    this.qly = b.chr();
    AppMethodBeat.o(107507);
  }
  
  public final void cjT()
  {
    AppMethodBeat.i(107510);
    this.nOI.setText(this.nOI.getContext().getString(2131758821, new Object[] { b.pJ(this.qly) }));
    this.ipd.setEnabled(false);
    AppMethodBeat.o(107510);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(107509);
    if (!this.qlA)
    {
      AppMethodBeat.o(107509);
      return;
    }
    if (this.qlB.getVisibility() != 8)
    {
      this.qlB.setVisibility(8);
      this.qlB.startAnimation(AnimationUtils.loadAnimation(this.qlB.getContext(), 2130772048));
    }
    AppMethodBeat.o(107509);
  }
  
  public final void show()
  {
    AppMethodBeat.i(107508);
    if (!this.qlA)
    {
      if (this.qlB == null)
      {
        AppMethodBeat.o(107508);
        return;
      }
      if ((this.qlB instanceof ViewStub)) {
        this.qlB = ((ViewStub)this.qlB).inflate();
      }
      this.nOI = ((TextView)this.qlB.findViewById(2131299773));
      if (!ac.eFq()) {
        this.nOI.setTextSize(1, 14.0F);
      }
      this.ipd = ((Button)this.qlB.findViewById(2131299772));
      cjT();
      this.ipd.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107506);
          if (a.this.qlC == null)
          {
            AppMethodBeat.o(107506);
            return;
          }
          a.this.qlC.ciO();
          AppMethodBeat.o(107506);
        }
      });
      this.qlA = true;
    }
    if (this.qlB.getVisibility() != 0)
    {
      this.qlB.setVisibility(0);
      this.qlB.startAnimation(AnimationUtils.loadAnimation(this.qlB.getContext(), 2130772047));
    }
    AppMethodBeat.o(107508);
  }
  
  public static abstract interface a
  {
    public abstract void ciO();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.a
 * JD-Core Version:    0.7.0.1
 */