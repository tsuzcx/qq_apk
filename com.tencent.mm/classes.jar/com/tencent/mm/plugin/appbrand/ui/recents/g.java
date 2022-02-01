package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

public final class g
{
  public final View asD;
  private ThreeDotsLoadingView mkI;
  View mkJ;
  private View mkK;
  
  public g(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(49140);
    this.asD = LayoutInflater.from(paramContext).inflate(2131493035, paramViewGroup, false);
    this.mkI = ((ThreeDotsLoadingView)this.asD.findViewById(2131301514));
    this.mkJ = this.asD.findViewById(2131300215);
    this.mkK = this.asD.findViewById(2131299491);
    AppMethodBeat.o(49140);
  }
  
  public final boolean bwE()
  {
    AppMethodBeat.i(187059);
    if ((this.mkI != null) && (this.mkI.isShown()))
    {
      AppMethodBeat.o(187059);
      return true;
    }
    AppMethodBeat.o(187059);
    return false;
  }
  
  public final void bwF()
  {
    AppMethodBeat.i(49141);
    if (this.mkJ != null) {
      this.mkJ.setBackgroundResource(2131101053);
    }
    AppMethodBeat.o(49141);
  }
  
  public final View bwp()
  {
    return this.asD;
  }
  
  public final void hE(boolean paramBoolean)
  {
    AppMethodBeat.i(49139);
    if (paramBoolean)
    {
      if (this.mkI != null)
      {
        this.mkI.setVisibility(0);
        this.mkI.fuW();
      }
      if (this.mkK != null)
      {
        this.mkK.setVisibility(8);
        AppMethodBeat.o(49139);
      }
    }
    else
    {
      if (this.mkI != null)
      {
        this.mkI.fuX();
        this.mkI.setVisibility(8);
      }
      if (this.mkK != null) {
        this.mkK.setVisibility(0);
      }
    }
    AppMethodBeat.o(49139);
  }
  
  public final void onDetached()
  {
    this.mkI = null;
    this.mkK = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.g
 * JD-Core Version:    0.7.0.1
 */