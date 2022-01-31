package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.af;
import android.util.DisplayMetrics;

public final class p
  extends af
{
  private final LinearLayoutManager hjT;
  private final int hjU;
  private final int hjV;
  
  public p(Context paramContext, LinearLayoutManager paramLinearLayoutManager)
  {
    super(paramContext);
    this.hjT = paramLinearLayoutManager;
    this.hjU = 3000;
    this.hjV = Math.round(paramContext.getResources().getDisplayMetrics().heightPixels * 0.75F);
  }
  
  public final PointF bD(int paramInt)
  {
    return this.hjT.bD(paramInt);
  }
  
  protected final int bH(int paramInt)
  {
    paramInt = Math.min(this.hjU, paramInt);
    return super.bH(Math.max(this.hjV, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.p
 * JD-Core Version:    0.7.0.1
 */