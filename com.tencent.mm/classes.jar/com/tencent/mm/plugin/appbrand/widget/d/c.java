package com.tencent.mm.plugin.appbrand.widget.d;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

public final class c
  extends LinearLayout
{
  public static final int hzp = Color.parseColor("#000000");
  public static final int hzq = Color.parseColor("#000000");
  private TextView fcy;
  
  public c(Context paramContext)
  {
    super(paramContext);
    setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    setOrientation(1);
    setGravity(17);
    this.fcy = new TextView(paramContext);
    this.fcy.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    addView(this.fcy);
  }
  
  public final void p(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    setPadding(paramInt2, paramInt2, paramInt2, paramInt2);
    b localb = new b();
    localb.hzm = paramInt1;
    localb.gaZ.setColor(paramInt4);
    localb.borderWidth = paramInt2;
    localb.hzo = (paramInt2 / 3 + localb.hzn);
    localb.hzj.setColor(paramInt3);
    setBackgroundDrawable(localb);
  }
  
  public final void setGravity(String paramString)
  {
    if (paramString.equals("left"))
    {
      this.fcy.setGravity(3);
      return;
    }
    if (paramString.equals("right"))
    {
      this.fcy.setGravity(5);
      return;
    }
    paramString.equals("center");
    this.fcy.setGravity(17);
  }
  
  public final void setText(String paramString)
  {
    this.fcy.setText(paramString);
  }
  
  public final void setTextColor(int paramInt)
  {
    this.fcy.setTextColor(paramInt);
  }
  
  public final void setTextSize(int paramInt)
  {
    this.fcy.setTextSize(paramInt);
  }
  
  public final void setTitlePadding(int paramInt)
  {
    this.fcy.setPadding(paramInt, paramInt, paramInt, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.d.c
 * JD-Core Version:    0.7.0.1
 */