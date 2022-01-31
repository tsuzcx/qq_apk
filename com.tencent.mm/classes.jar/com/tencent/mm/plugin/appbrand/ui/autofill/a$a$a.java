package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.y.g;

public final class a$a$a
  extends RecyclerView.v
{
  public TextView fdt;
  public TextView hfc;
  
  public a$a$a(View paramView)
  {
    super(paramView);
    this.fdt = ((TextView)paramView.findViewById(y.g.app_brand_idcard_show_item_name));
    this.hfc = ((TextView)paramView.findViewById(y.g.app_brand_idcard_show_item_value));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.autofill.a.a.a
 * JD-Core Version:    0.7.0.1
 */