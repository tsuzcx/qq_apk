package com.tencent.mm.plugin.choosemsgfile.b.c;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.choosemsgfile.b.b.a;
import com.tencent.mm.sdk.platformtools.ah;

public final class e$3
  extends RecyclerView.h
{
  int kFE;
  ColorDrawable kFF;
  int mSize;
  
  public e$3(e parame)
  {
    AppMethodBeat.i(54348);
    this.kFE = ah.getResources().getColor(2131690052);
    this.kFF = new ColorDrawable(this.kFE);
    this.mSize = ((int)ah.getResources().getDimension(2131427496));
    AppMethodBeat.o(54348);
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(54349);
    int j = paramRecyclerView.getPaddingLeft();
    int k = paramRecyclerView.getWidth();
    int m = paramRecyclerView.getPaddingRight();
    int n = paramRecyclerView.getChildCount();
    int i = 0;
    while (i < n)
    {
      params = paramRecyclerView.getChildAt(i);
      if (params.getTag() != null)
      {
        Object localObject = this.kFx.kFw.ty(((Integer)params.getTag()).intValue() + 1);
        if ((localObject == null) || (((a)localObject).getType() != 0))
        {
          localObject = (RecyclerView.LayoutParams)params.getLayoutParams();
          int i1 = params.getBottom();
          i1 = ((RecyclerView.LayoutParams)localObject).bottomMargin + i1;
          int i2 = this.mSize;
          this.kFF.setBounds(j, i1, k - m, i2 + i1);
          this.kFF.draw(paramCanvas);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(54349);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.c.e.3
 * JD-Core Version:    0.7.0.1
 */