package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.g;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

public final class f
{
  public final View caK;
  private ThreeDotsLoadingView uiD;
  public View une;
  private View unf;
  
  public f(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(49140);
    this.caK = LayoutInflater.from(paramContext).inflate(ba.g.app_brand_recents_list_footer, paramViewGroup, false);
    this.uiD = ((ThreeDotsLoadingView)this.caK.findViewById(ba.f.loading_view));
    this.une = this.caK.findViewById(ba.f.footer_top_divider);
    this.unf = this.caK.findViewById(ba.f.end_tip);
    AppMethodBeat.o(49140);
  }
  
  public final boolean cML()
  {
    AppMethodBeat.i(323101);
    if ((this.uiD != null) && (this.uiD.isShown()))
    {
      AppMethodBeat.o(323101);
      return true;
    }
    AppMethodBeat.o(323101);
    return false;
  }
  
  public final void iQ()
  {
    this.uiD = null;
    this.unf = null;
  }
  
  public final void setLoading(boolean paramBoolean)
  {
    AppMethodBeat.i(49139);
    if (paramBoolean)
    {
      if (this.uiD != null)
      {
        this.uiD.setVisibility(0);
        this.uiD.jFe();
      }
      if (this.unf != null)
      {
        this.unf.setVisibility(8);
        AppMethodBeat.o(49139);
      }
    }
    else
    {
      if (this.uiD != null)
      {
        this.uiD.jFf();
        this.uiD.setVisibility(8);
      }
      if (this.unf != null) {
        this.unf.setVisibility(0);
      }
    }
    AppMethodBeat.o(49139);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.f
 * JD-Core Version:    0.7.0.1
 */