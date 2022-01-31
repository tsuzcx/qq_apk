package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.af;
import android.util.DisplayMetrics;

final class f$1
  extends af
{
  f$1(f paramf, Context paramContext)
  {
    super(paramContext);
  }
  
  protected final float a(DisplayMetrics paramDisplayMetrics)
  {
    return 80.0F / paramDisplayMetrics.densityDpi;
  }
  
  public final PointF bD(int paramInt)
  {
    return ((LinearLayoutManager)this.ihO.ihL.getLayoutManager()).bD(paramInt);
  }
  
  protected final int bH(int paramInt)
  {
    return super.bH(paramInt);
  }
  
  protected final int he()
  {
    return -1;
  }
  
  protected final void onStop()
  {
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.f.1
 * JD-Core Version:    0.7.0.1
 */