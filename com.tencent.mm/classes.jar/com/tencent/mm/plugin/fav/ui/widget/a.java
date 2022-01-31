package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.sdk.platformtools.aa;

public final class a
{
  public Button gBJ;
  public TextView kIf;
  public long mDN;
  public boolean mDP;
  public View mDQ;
  public a.a mDR;
  
  public a()
  {
    AppMethodBeat.i(74666);
    this.mDP = false;
    this.mDN = b.bvZ();
    AppMethodBeat.o(74666);
  }
  
  public final void byq()
  {
    AppMethodBeat.i(74669);
    this.kIf.setText(this.kIf.getContext().getString(2131299662, new Object[] { b.jS(this.mDN) }));
    this.gBJ.setEnabled(false);
    AppMethodBeat.o(74669);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(74668);
    if (!this.mDP)
    {
      AppMethodBeat.o(74668);
      return;
    }
    if (this.mDQ.getVisibility() != 8)
    {
      this.mDQ.setVisibility(8);
      this.mDQ.startAnimation(AnimationUtils.loadAnimation(this.mDQ.getContext(), 2131034182));
    }
    AppMethodBeat.o(74668);
  }
  
  public final void show()
  {
    AppMethodBeat.i(74667);
    if (!this.mDP)
    {
      if (this.mDQ == null)
      {
        AppMethodBeat.o(74667);
        return;
      }
      if ((this.mDQ instanceof ViewStub)) {
        this.mDQ = ((ViewStub)this.mDQ).inflate();
      }
      this.kIf = ((TextView)this.mDQ.findViewById(2131823996));
      if (!aa.dsC()) {
        this.kIf.setTextSize(1, 14.0F);
      }
      this.gBJ = ((Button)this.mDQ.findViewById(2131823997));
      byq();
      this.gBJ.setOnClickListener(new a.1(this));
      this.mDP = true;
    }
    if (this.mDQ.getVisibility() != 0)
    {
      this.mDQ.setVisibility(0);
      this.mDQ.startAnimation(AnimationUtils.loadAnimation(this.mDQ.getContext(), 2131034181));
    }
    AppMethodBeat.o(74667);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.a
 * JD-Core Version:    0.7.0.1
 */