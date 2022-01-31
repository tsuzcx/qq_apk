package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

public final class e
{
  public final View aku;
  ThreeDotsLoadingView iTR;
  View iTS;
  private View iTT;
  
  public e(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(133414);
    this.aku = LayoutInflater.from(paramContext).inflate(2130968715, paramViewGroup, false);
    this.iTR = ((ThreeDotsLoadingView)this.aku.findViewById(2131821346));
    this.iTS = this.aku.findViewById(2131821349);
    this.iTT = this.aku.findViewById(2131821347);
    AppMethodBeat.o(133414);
  }
  
  public final View aNe()
  {
    return this.aku;
  }
  
  public final void aNo()
  {
    AppMethodBeat.i(133415);
    if (this.iTS != null) {
      this.iTS.setBackgroundResource(2131690605);
    }
    AppMethodBeat.o(133415);
  }
  
  public final void eU(boolean paramBoolean)
  {
    AppMethodBeat.i(133413);
    if (paramBoolean)
    {
      if (this.iTR != null)
      {
        this.iTR.setVisibility(0);
        this.iTR.dOV();
      }
      if (this.iTT != null)
      {
        this.iTT.setVisibility(8);
        AppMethodBeat.o(133413);
      }
    }
    else
    {
      if (this.iTR != null)
      {
        this.iTR.dOW();
        this.iTR.setVisibility(8);
      }
      if (this.iTT != null) {
        this.iTT.setVisibility(0);
      }
    }
    AppMethodBeat.o(133413);
  }
  
  public final void onDetached()
  {
    this.iTR = null;
    this.iTT = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.e
 * JD-Core Version:    0.7.0.1
 */