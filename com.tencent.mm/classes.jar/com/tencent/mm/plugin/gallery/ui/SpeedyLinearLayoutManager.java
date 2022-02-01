package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.p;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SpeedyLinearLayoutManager
  extends LinearLayoutManager
{
  private float CeJ = 50.0F;
  
  public SpeedyLinearLayoutManager() {}
  
  public SpeedyLinearLayoutManager(byte paramByte)
  {
    super(0, false);
  }
  
  public SpeedyLinearLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  public final void euV()
  {
    this.CeJ = 100.0F;
  }
  
  public void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.s params, int paramInt)
  {
    AppMethodBeat.i(240792);
    paramRecyclerView = new p(paramRecyclerView.getContext())
    {
      public final float a(DisplayMetrics paramAnonymousDisplayMetrics)
      {
        AppMethodBeat.i(243913);
        float f = SpeedyLinearLayoutManager.a(SpeedyLinearLayoutManager.this) / paramAnonymousDisplayMetrics.densityDpi;
        AppMethodBeat.o(243913);
        return f;
      }
      
      public final PointF cB(int paramAnonymousInt)
      {
        AppMethodBeat.i(111712);
        PointF localPointF = SpeedyLinearLayoutManager.this.cB(paramAnonymousInt);
        AppMethodBeat.o(111712);
        return localPointF;
      }
    };
    paramRecyclerView.alG = paramInt;
    startSmoothScroll(paramRecyclerView);
    AppMethodBeat.o(240792);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.SpeedyLinearLayoutManager
 * JD-Core Version:    0.7.0.1
 */