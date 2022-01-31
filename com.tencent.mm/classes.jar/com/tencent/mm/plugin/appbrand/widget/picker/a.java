package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import com.tencent.luggage.c.a.a.a;
import com.tencent.luggage.c.a.a.c;

public final class a
  extends d
{
  private static final int gdr = a.c.app_brand_picker_panel;
  
  public a(Context paramContext)
  {
    super(paramContext);
    super.setId(gdr);
    setBackgroundResource(a.a.half_alpha_black);
    setOnClickListener(new a.1(this));
  }
  
  public static a cu(View paramView)
  {
    return (a)paramView.getRootView().findViewById(gdr);
  }
  
  public final void hide()
  {
    super.hide();
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    if (isShown())
    {
      if ((getParent() != null) && ((getParent() instanceof ViewGroup))) {}
      for (int i = ((ViewGroup)getParent()).getMeasuredHeight(); i > 0; i = 0)
      {
        cl(paramInt1, View.MeasureSpec.makeMeasureSpec(i, 1073741824));
        return;
      }
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public final void setId(int paramInt) {}
  
  public final void show()
  {
    super.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.a
 * JD-Core Version:    0.7.0.1
 */