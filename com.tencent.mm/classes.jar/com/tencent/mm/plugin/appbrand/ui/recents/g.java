package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

public final class g
{
  public final View auu;
  private ThreeDotsLoadingView mQm;
  View mQn;
  private View mQo;
  
  public g(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(49140);
    this.auu = LayoutInflater.from(paramContext).inflate(2131493035, paramViewGroup, false);
    this.mQm = ((ThreeDotsLoadingView)this.auu.findViewById(2131301514));
    this.mQn = this.auu.findViewById(2131300215);
    this.mQo = this.auu.findViewById(2131299491);
    AppMethodBeat.o(49140);
  }
  
  public final boolean bBE()
  {
    AppMethodBeat.i(223171);
    if ((this.mQm != null) && (this.mQm.isShown()))
    {
      AppMethodBeat.o(223171);
      return true;
    }
    AppMethodBeat.o(223171);
    return false;
  }
  
  public final void bBF()
  {
    AppMethodBeat.i(49141);
    if (this.mQn != null) {
      this.mQn.setBackgroundResource(2131101053);
    }
    AppMethodBeat.o(49141);
  }
  
  public final View bBp()
  {
    return this.auu;
  }
  
  public final void hO(boolean paramBoolean)
  {
    AppMethodBeat.i(49139);
    if (paramBoolean)
    {
      if (this.mQm != null)
      {
        this.mQm.setVisibility(0);
        this.mQm.fQd();
      }
      if (this.mQo != null)
      {
        this.mQo.setVisibility(8);
        AppMethodBeat.o(49139);
      }
    }
    else
    {
      if (this.mQm != null)
      {
        this.mQm.fQe();
        this.mQm.setVisibility(8);
      }
      if (this.mQo != null) {
        this.mQo.setVisibility(0);
      }
    }
    AppMethodBeat.o(49139);
  }
  
  public final void onDetached()
  {
    this.mQm = null;
    this.mQo = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.g
 * JD-Core Version:    0.7.0.1
 */