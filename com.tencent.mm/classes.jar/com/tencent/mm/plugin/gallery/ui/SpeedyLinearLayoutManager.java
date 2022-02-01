package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.ae;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SpeedyLinearLayoutManager
  extends LinearLayoutManager
{
  public SpeedyLinearLayoutManager() {}
  
  public SpeedyLinearLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  public final void a(RecyclerView paramRecyclerView, RecyclerView.s params, int paramInt)
  {
    AppMethodBeat.i(111713);
    paramRecyclerView = new ae(paramRecyclerView.getContext())
    {
      public final float a(DisplayMetrics paramAnonymousDisplayMetrics)
      {
        return 50.0F / paramAnonymousDisplayMetrics.densityDpi;
      }
      
      public final PointF bZ(int paramAnonymousInt)
      {
        AppMethodBeat.i(111712);
        PointF localPointF = SpeedyLinearLayoutManager.this.bZ(paramAnonymousInt);
        AppMethodBeat.o(111712);
        return localPointF;
      }
    };
    paramRecyclerView.ard = paramInt;
    a(paramRecyclerView);
    AppMethodBeat.o(111713);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.SpeedyLinearLayoutManager
 * JD-Core Version:    0.7.0.1
 */