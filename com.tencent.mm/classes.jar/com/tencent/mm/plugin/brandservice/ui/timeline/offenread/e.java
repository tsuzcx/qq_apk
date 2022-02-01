package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.d.b;

public class e
  extends RecyclerView.h
{
  private int padding;
  Paint paint;
  
  public e(int paramInt, Context paramContext)
  {
    AppMethodBeat.i(266970);
    this.paint = new Paint();
    this.padding = paramInt;
    this.paint.setColor(paramContext.getResources().getColor(d.b.FG_3));
    this.paint.setStyle(Paint.Style.FILL);
    this.paint.setFlags(1);
    AppMethodBeat.o(266970);
  }
  
  public final void GS(int paramInt)
  {
    this.padding = paramInt;
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(266972);
    super.a(paramCanvas, paramRecyclerView, params);
    AppMethodBeat.o(266972);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    int k = 0;
    int j = 0;
    AppMethodBeat.i(266971);
    int m = RecyclerView.bi(paramView);
    paramRect.top = 0;
    paramRect.bottom = 0;
    if (((BizTimeLineHotListView)paramRecyclerView).sIU)
    {
      if ((m != 0) && (m != 1)) {}
      for (i = this.padding / 2;; i = 0)
      {
        paramRect.left = i;
        i = j;
        if (m != 0)
        {
          i = j;
          if (m != 1) {
            i = this.padding / 2;
          }
        }
        paramRect.right = i;
        AppMethodBeat.o(266971);
        return;
      }
    }
    if (m != 0) {}
    for (int i = this.padding / 2;; i = 0)
    {
      paramRect.left = i;
      i = k;
      if (m != 0) {
        i = this.padding / 2;
      }
      paramRect.right = i;
      AppMethodBeat.o(266971);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.e
 * JD-Core Version:    0.7.0.1
 */