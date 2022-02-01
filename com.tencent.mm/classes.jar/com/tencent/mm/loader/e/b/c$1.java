package com.tencent.mm.loader.e.b;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.loader.h.a.d;

final class c$1
  implements View.OnLayoutChangeListener
{
  c$1(c paramc, Object paramObject, ImageView paramImageView) {}
  
  public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    paramView = ((d)this.iap).D(paramView.getWidth(), paramView.getHeight());
    if (paramView != null)
    {
      this.iaq.setScaleType(ImageView.ScaleType.MATRIX);
      this.iaq.setImageMatrix(paramView);
    }
    this.iaq.removeOnLayoutChangeListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.e.b.c.1
 * JD-Core Version:    0.7.0.1
 */