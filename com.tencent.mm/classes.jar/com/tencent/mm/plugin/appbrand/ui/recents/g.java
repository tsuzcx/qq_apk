package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.au.f;
import com.tencent.mm.plugin.appbrand.au.g;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

public final class g
{
  public final View amk;
  private ThreeDotsLoadingView rfc;
  View rfd;
  private View rfe;
  
  public g(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(49140);
    this.amk = LayoutInflater.from(paramContext).inflate(au.g.app_brand_recents_list_footer, paramViewGroup, false);
    this.rfc = ((ThreeDotsLoadingView)this.amk.findViewById(au.f.loading_view));
    this.rfd = this.amk.findViewById(au.f.footer_top_divider);
    this.rfe = this.amk.findViewById(au.f.end_tip);
    AppMethodBeat.o(49140);
  }
  
  public final void CZ(int paramInt)
  {
    AppMethodBeat.i(267984);
    if (this.rfd != null) {
      this.rfd.setBackgroundResource(paramInt);
    }
    AppMethodBeat.o(267984);
  }
  
  public final void cfy()
  {
    this.rfc = null;
    this.rfe = null;
  }
  
  public final boolean clo()
  {
    AppMethodBeat.i(267980);
    if ((this.rfc != null) && (this.rfc.isShown()))
    {
      AppMethodBeat.o(267980);
      return true;
    }
    AppMethodBeat.o(267980);
    return false;
  }
  
  public final View getItemView()
  {
    return this.amk;
  }
  
  public final void jQ(boolean paramBoolean)
  {
    AppMethodBeat.i(49139);
    if (paramBoolean)
    {
      if (this.rfc != null)
      {
        this.rfc.setVisibility(0);
        this.rfc.hZX();
      }
      if (this.rfe != null)
      {
        this.rfe.setVisibility(8);
        AppMethodBeat.o(49139);
      }
    }
    else
    {
      if (this.rfc != null)
      {
        this.rfc.hZY();
        this.rfc.setVisibility(8);
      }
      if (this.rfe != null) {
        this.rfe.setVisibility(0);
      }
    }
    AppMethodBeat.o(49139);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.g
 * JD-Core Version:    0.7.0.1
 */