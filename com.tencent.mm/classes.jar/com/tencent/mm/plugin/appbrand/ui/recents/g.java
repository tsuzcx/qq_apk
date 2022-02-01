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
  private ThreeDotsLoadingView mLk;
  View mLl;
  private View mLm;
  
  public g(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(49140);
    this.auu = LayoutInflater.from(paramContext).inflate(2131493035, paramViewGroup, false);
    this.mLk = ((ThreeDotsLoadingView)this.auu.findViewById(2131301514));
    this.mLl = this.auu.findViewById(2131300215);
    this.mLm = this.auu.findViewById(2131299491);
    AppMethodBeat.o(49140);
  }
  
  public final boolean bAK()
  {
    AppMethodBeat.i(188938);
    if ((this.mLk != null) && (this.mLk.isShown()))
    {
      AppMethodBeat.o(188938);
      return true;
    }
    AppMethodBeat.o(188938);
    return false;
  }
  
  public final void bAL()
  {
    AppMethodBeat.i(49141);
    if (this.mLl != null) {
      this.mLl.setBackgroundResource(2131101053);
    }
    AppMethodBeat.o(49141);
  }
  
  public final View bAv()
  {
    return this.auu;
  }
  
  public final void hO(boolean paramBoolean)
  {
    AppMethodBeat.i(49139);
    if (paramBoolean)
    {
      if (this.mLk != null)
      {
        this.mLk.setVisibility(0);
        this.mLk.fLJ();
      }
      if (this.mLm != null)
      {
        this.mLm.setVisibility(8);
        AppMethodBeat.o(49139);
      }
    }
    else
    {
      if (this.mLk != null)
      {
        this.mLk.fLK();
        this.mLk.setVisibility(8);
      }
      if (this.mLm != null) {
        this.mLm.setVisibility(0);
      }
    }
    AppMethodBeat.o(49139);
  }
  
  public final void onDetached()
  {
    this.mLk = null;
    this.mLm = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.g
 * JD-Core Version:    0.7.0.1
 */