package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

public final class g
{
  public final View arI;
  ThreeDotsLoadingView lIL;
  View lIM;
  private View lIN;
  
  public g(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(49140);
    this.arI = LayoutInflater.from(paramContext).inflate(2131493035, paramViewGroup, false);
    this.lIL = ((ThreeDotsLoadingView)this.arI.findViewById(2131301514));
    this.lIM = this.arI.findViewById(2131300215);
    this.lIN = this.arI.findViewById(2131299491);
    AppMethodBeat.o(49140);
  }
  
  public final void bpI()
  {
    AppMethodBeat.i(49141);
    if (this.lIM != null) {
      this.lIM.setBackgroundResource(2131101053);
    }
    AppMethodBeat.o(49141);
  }
  
  public final View bpu()
  {
    return this.arI;
  }
  
  public final void hh(boolean paramBoolean)
  {
    AppMethodBeat.i(49139);
    if (paramBoolean)
    {
      if (this.lIL != null)
      {
        this.lIL.setVisibility(0);
        this.lIL.ffb();
      }
      if (this.lIN != null)
      {
        this.lIN.setVisibility(8);
        AppMethodBeat.o(49139);
      }
    }
    else
    {
      if (this.lIL != null)
      {
        this.lIL.ffc();
        this.lIL.setVisibility(8);
      }
      if (this.lIN != null) {
        this.lIN.setVisibility(0);
      }
    }
    AppMethodBeat.o(49139);
  }
  
  public final void onDetached()
  {
    this.lIL = null;
    this.lIN = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.g
 * JD-Core Version:    0.7.0.1
 */