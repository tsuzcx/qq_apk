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
  private SparseArray<List<a>> jAB = new SparseArray();
  
  public abstract void a(a parama, e parame);
  
  public abstract a azV();
  
  public final boolean e(com.tencent.mm.danmaku.b.a parama)
  {
    return parama instanceof e;
  }
  
  public static class a
  {
    protected final View jAC;
    private RectF jAD;
    private Paint jAE;
    
    public a(View paramView)
    {
      AppMethodBeat.i(266294);
      this.jAD = new RectF();
      this.jAE = new Paint();
      if (paramView == null)
      {
        paramView = new IllegalArgumentException("itemView may not be null");
        AppMethodBeat.o(266294);
        throw paramView;
      }
      this.jAC = paramView;
      AppMethodBeat.o(266294);
    }
    
    private View d(View paramView, float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(266306);
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
            AppMethodBeat.o(266306);
            return localView2;
          }
        }
      }
      if ((i != 0) && (localView1 == null))
      {
        AppMethodBeat.o(266306);
        return paramView;
      }
      AppMethodBeat.o(266306);
      return localView1;
    }
    
    public final int azW()
    {
      AppMethodBeat.i(266297);
      int i = this.jAC.getMeasuredWidth();
      AppMethodBeat.o(266297);
      return i;
    }
    
    public final int azX()
    {
      AppMethodBeat.i(266299);
      int i = this.jAC.getMeasuredHeight();
      AppMethodBeat.o(266299);
      return i;
    }
    
    public final View c(com.tencent.mm.danmaku.d.h paramh)
    {
      AppMethodBeat.i(266304);
      paramh = d(this.jAC, paramh.mPoint.x - paramh.jAZ, paramh.mPoint.y - paramh.jBa);
      AppMethodBeat.o(266304);
      return paramh;
    }
    
    public final void cO(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(266296);
      this.jAC.measure(paramInt1, paramInt2);
      AppMethodBeat.o(266296);
    }
    
    public final void cP(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(266301);
      this.jAC.layout(0, 0, paramInt1, paramInt2);
      AppMethodBeat.o(266301);
    }
    
    public final void draw(Canvas paramCanvas)
    {
      AppMethodBeat.i(266302);
      this.jAD.set(0.0F, 0.0F, this.jAC.getMeasuredWidth(), this.jAC.getMeasuredHeight());
      this.jAE.setAlpha((int)(this.jAC.getAlpha() * 255.0F));
      int i = paramCanvas.saveLayer(this.jAD, this.jAE, 31);
      this.jAC.draw(paramCanvas);
      paramCanvas.restoreToCount(i);
      AppMethodBeat.o(266302);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.danmaku.render.h
 * JD-Core Version:    0.7.0.1
 */