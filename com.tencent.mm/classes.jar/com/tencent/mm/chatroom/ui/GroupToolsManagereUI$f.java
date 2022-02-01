package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;

public final class GroupToolsManagereUI$f
  extends RecyclerView.h
{
  private int dividerHeight;
  private Paint gwh;
  
  public GroupToolsManagereUI$f(Context paramContext)
  {
    AppMethodBeat.i(182191);
    this.dividerHeight = a.fromDPToPix(paramContext, 8);
    this.gwh = new Paint();
    this.gwh.setColor(paramContext.getResources().getColor(2131099650));
    AppMethodBeat.o(182191);
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(182192);
    super.a(paramCanvas, paramRecyclerView, params);
    int j = paramRecyclerView.getChildCount();
    int k = paramRecyclerView.getPaddingLeft();
    int m = paramRecyclerView.getWidth();
    int n = paramRecyclerView.getPaddingRight();
    int i = 0;
    while (i < j)
    {
      params = paramRecyclerView.getChildAt(i);
      float f1 = params.getBottom();
      float f2 = params.getBottom() + this.dividerHeight;
      paramCanvas.drawRect(k, f1, m - n, f2, this.gwh);
      i += 1;
    }
    AppMethodBeat.o(182192);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(182193);
    super.a(paramRect, paramView, paramRecyclerView, params);
    paramRect.bottom = this.dividerHeight;
    AppMethodBeat.o(182193);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.GroupToolsManagereUI.f
 * JD-Core Version:    0.7.0.1
 */