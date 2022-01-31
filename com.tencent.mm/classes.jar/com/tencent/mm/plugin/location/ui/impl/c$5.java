package com.tencent.mm.plugin.location.ui.impl;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

final class c$5
  implements AdapterView.OnItemClickListener
{
  c$5(c paramc) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramView = null;
    paramAdapterView = paramView;
    if (paramInt >= 0)
    {
      paramAdapterView = paramView;
      if (paramInt < c.v(this.lJp).getCount()) {
        paramAdapterView = c.v(this.lJp).tc(paramInt);
      }
    }
    c.b(this.lJp, paramAdapterView);
    c.a(this.lJp, paramAdapterView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.c.5
 * JD-Core Version:    0.7.0.1
 */