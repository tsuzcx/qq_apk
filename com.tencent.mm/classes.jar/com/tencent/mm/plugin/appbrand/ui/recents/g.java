package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

public final class g
{
  public final View aus;
  private ThreeDotsLoadingView odq;
  View odr;
  private View ods;
  
  public g(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(49140);
    this.aus = LayoutInflater.from(paramContext).inflate(2131493074, paramViewGroup, false);
    this.odq = ((ThreeDotsLoadingView)this.aus.findViewById(2131303719));
    this.odr = this.aus.findViewById(2131301684);
    this.ods = this.aus.findViewById(2131300127);
    AppMethodBeat.o(49140);
  }
  
  public final boolean bYD()
  {
    AppMethodBeat.i(227733);
    if ((this.odq != null) && (this.odq.isShown()))
    {
      AppMethodBeat.o(227733);
      return true;
    }
    AppMethodBeat.o(227733);
    return false;
  }
  
  public final void bYE()
  {
    AppMethodBeat.i(49141);
    if (this.odr != null) {
      this.odr.setBackgroundResource(2131101287);
    }
    AppMethodBeat.o(49141);
  }
  
  public final View bYp()
  {
    return this.aus;
  }
  
  public final void iT(boolean paramBoolean)
  {
    AppMethodBeat.i(49139);
    if (paramBoolean)
    {
      if (this.odq != null)
      {
        this.odq.setVisibility(0);
        this.odq.gZh();
      }
      if (this.ods != null)
      {
        this.ods.setVisibility(8);
        AppMethodBeat.o(49139);
      }
    }
    else
    {
      if (this.odq != null)
      {
        this.odq.gZi();
        this.odq.setVisibility(8);
      }
      if (this.ods != null) {
        this.ods.setVisibility(0);
      }
    }
    AppMethodBeat.o(49139);
  }
  
  public final void onDetached()
  {
    this.odq = null;
    this.ods = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.g
 * JD-Core Version:    0.7.0.1
 */