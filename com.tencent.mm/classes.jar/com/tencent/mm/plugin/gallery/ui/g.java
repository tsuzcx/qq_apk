package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.af;
import android.util.DisplayMetrics;

public final class g
  extends LinearLayoutManager
{
  public final void a(RecyclerView paramRecyclerView, int paramInt)
  {
    paramRecyclerView = new af(paramRecyclerView.getContext())
    {
      protected final float a(DisplayMetrics paramAnonymousDisplayMetrics)
      {
        return 50.0F / paramAnonymousDisplayMetrics.densityDpi;
      }
      
      public final PointF bD(int paramAnonymousInt)
      {
        return g.this.bD(paramAnonymousInt);
      }
    };
    paramRecyclerView.ahA = paramInt;
    a(paramRecyclerView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.g
 * JD-Core Version:    0.7.0.1
 */