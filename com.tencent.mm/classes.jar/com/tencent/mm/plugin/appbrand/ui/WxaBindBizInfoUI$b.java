package com.tencent.mm.plugin.appbrand.ui;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.y.g;

final class WxaBindBizInfoUI$b
  extends RecyclerView.v
{
  TextView eXr;
  View eYp;
  ImageView heN;
  
  public WxaBindBizInfoUI$b(View paramView)
  {
    super(paramView);
    this.heN = ((ImageView)paramView.findViewById(y.g.icon));
    this.eXr = ((TextView)paramView.findViewById(y.g.primary_text));
    this.eYp = paramView.findViewById(y.g.divider);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.WxaBindBizInfoUI.b
 * JD-Core Version:    0.7.0.1
 */