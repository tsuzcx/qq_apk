package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

final class j$b
  extends TextView
{
  private String mTitle;
  private String mValue;
  
  public j$b(j paramj, Context paramContext)
  {
    super(paramContext);
    setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    setTextSize(1, 12.0F);
    setTextColor(-419430401);
  }
  
  private void update()
  {
    setText(String.format("%s: %s", new Object[] { this.mTitle, this.mValue }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.j.b
 * JD-Core Version:    0.7.0.1
 */