package com.tencent.mm.danmaku.render;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.danmaku.b.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class h
  extends a<e>
{
  private SparseArray<List<a>> gQi = new SparseArray();
  
  public abstract void a(a parama, e parame);
  
  public abstract a atg();
  
  public final boolean f(com.tencent.mm.danmaku.b.a parama)
  {
    return parama instanceof e;
  }
  
  public static class a
  {
    protected final View gQj;
    private RectF gQk;
    private Paint gQl;
    
    public a(View paramView)
    {
      AppMethodBeat.i(241731);
      this.gQk = new RectF();
      this.gQl = new Paint();
      if (paramView == null)
      {
        paramView = new IllegalArgumentException("itemView may not be null");
        AppMethodBeat.o(241731);
        throw paramView;
      }
      this.gQj = paramView;
      AppMethodBeat.o(241731);
    }
    
    private View d(View paramView, float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(241738);
      RectF localRectF = new RectF();
      int i = 0;
      Iterator localIterator = paramView.getTouchables().iterator();
      View localView1 = null;
      while (localIterator.hasNext())
      {
        View localView2 = (View)localIterator.next();
        float f1 = localView2.getX();
        float f2 = localView2.getY();
        localRectF.set(f1, f2, localView2.getMeasuredWidth() + f1, localView2.getMeasuredWidth() + f2);
        if (localRectF.contains(paramFloat1, paramFloat2)) {
          if (localView2.equals(paramView))
          {
            i = 1;
          }
          else if ((localView2 instanceof ViewGroup))
          {
            localView1 = d(paramView, paramFloat1 - f1, paramFloat2 - paramFloat1);
          }
          else
          {
            AppMethodBeat.o(241738);
            return localView2;
          }
        }
      }
      if ((i != 0) && (localView1 == null))
      {
        AppMethodBeat.o(241738);
        return paramView;
      }
      AppMethodBeat.o(241738);
      return localView1;
    }
    
    public final int ath()
    {
      AppMethodBeat.i(241733);
      int i = this.gQj.getMeasuredWidth();
      AppMethodBeat.o(241733);
      return i;
    }
    
    public final int ati()
    {
      AppMethodBeat.i(241734);
      int i = this.gQj.getMeasuredHeight();
      AppMethodBeat.o(241734);
      return i;
    }
    
    public final View c(com.tencent.mm.danmaku.d.h paramh)
    {
      AppMethodBeat.i(241737);
      paramh = d(this.gQj, paramh.mPoint.x - paramh.gQG, paramh.mPoint.y - paramh.gQH);
      AppMethodBeat.o(241737);
      return paramh;
    }
    
    public final void cw(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(241735);
      this.gQj.layout(0, 0, paramInt1, paramInt2);
      AppMethodBeat.o(241735);
    }
    
    public final void draw(Canvas paramCanvas)
    {
      AppMethodBeat.i(241736);
      this.gQk.set(0.0F, 0.0F, this.gQj.getMeasuredWidth(), this.gQj.getMeasuredHeight());
      this.gQl.setAlpha((int)(this.gQj.getAlpha() * 255.0F));
      int i = paramCanvas.saveLayer(this.gQk, this.gQl, 31);
      this.gQj.draw(paramCanvas);
      paramCanvas.restoreToCount(i);
      AppMethodBeat.o(241736);
    }
    
    public final void measure(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(241732);
      this.gQj.measure(paramInt1, paramInt2);
      AppMethodBeat.o(241732);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.danmaku.render.h
 * JD-Core Version:    0.7.0.1
 */