package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SpeedyLinearLayoutManager
  extends LinearLayoutManager
{
  public float HQN = 50.0F;
  
  public SpeedyLinearLayoutManager() {}
  
  public SpeedyLinearLayoutManager(byte paramByte)
  {
    super(0, false);
  }
  
  public SpeedyLinearLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  public void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.s params, int paramInt)
  {
    AppMethodBeat.i(289578);
    paramRecyclerView = new o(paramRecyclerView.getContext())
    {
      public final float c(DisplayMetrics paramAnonymousDisplayMetrics)
      {
        AppMethodBeat.i(289481);
        float f = SpeedyLinearLayoutManager.a(SpeedyLinearLayoutManager.this) / paramAnonymousDisplayMetrics.densityDpi;
        AppMethodBeat.o(289481);
        return f;
      }
      
      public final PointF fM(int paramAnonymousInt)
      {
        AppMethodBeat.i(111712);
        PointF localPointF = SpeedyLinearLayoutManager.this.fM(paramAnonymousInt);
        AppMethodBeat.o(111712);
        return localPointF;
      }
    };
    paramRecyclerView.cag = paramInt;
    startSmoothScroll(paramRecyclerView);
    AppMethodBeat.o(289578);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.SpeedyLinearLayoutManager
 * JD-Core Version:    0.7.0.1
 */