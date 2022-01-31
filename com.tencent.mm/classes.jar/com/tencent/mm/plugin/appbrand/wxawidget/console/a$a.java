package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.wxawidget.b.b;

final class a$a
  extends RecyclerView.v
{
  TextView fuN;
  TextView hEe;
  
  public a$a(View paramView, int paramInt)
  {
    super(paramView);
    this.hEe = ((TextView)paramView.findViewById(b.b.level_tv));
    this.fuN = ((TextView)paramView.findViewById(b.b.content_tv));
    switch (paramInt)
    {
    default: 
      this.hEe.setText("L");
      this.fuN.setTextColor(-7829368);
      return;
    case 1: 
      this.hEe.setText("L");
      this.fuN.setTextColor(-7829368);
      return;
    case 2: 
      this.hEe.setText("I");
      this.fuN.setTextColor(-16777216);
      return;
    case 3: 
      this.hEe.setText("W");
      this.fuN.setTextColor(Color.rgb(0, 0, 204));
      return;
    }
    this.hEe.setText("E");
    this.fuN.setTextColor(-65536);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.a.a
 * JD-Core Version:    0.7.0.1
 */