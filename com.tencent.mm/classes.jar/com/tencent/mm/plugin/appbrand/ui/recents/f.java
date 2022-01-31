package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.appbrand.ui.l;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.plugin.appbrand.y.h;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

public final class f
{
  public final View aie;
  private ThreeDotsLoadingView him;
  private View hin;
  private View hio;
  
  public f(Context paramContext, ViewGroup paramViewGroup)
  {
    this.aie = LayoutInflater.from(paramContext).inflate(y.h.app_brand_recents_list_footer, paramViewGroup, false);
    this.him = ((ThreeDotsLoadingView)this.aie.findViewById(y.g.loading_view));
    this.hin = this.aie.findViewById(y.g.footer_top_divider);
    this.hio = this.aie.findViewById(y.g.end_tip);
  }
  
  public final boolean apS()
  {
    return (this.him != null) && (this.him.isShown());
  }
  
  public final void dH(boolean paramBoolean)
  {
    View localView = this.hin;
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      l.A(localView, i);
      return;
    }
  }
  
  public final void onDetached()
  {
    this.him = null;
    this.hio = null;
  }
  
  public final void setLoading(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.him != null)
      {
        this.him.setVisibility(0);
        this.him.cKb();
      }
      if (this.hio != null) {
        this.hio.setVisibility(8);
      }
    }
    do
    {
      return;
      if (this.him != null)
      {
        this.him.cKc();
        this.him.setVisibility(8);
      }
    } while (this.hio == null);
    this.hio.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.f
 * JD-Core Version:    0.7.0.1
 */