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
import com.tencent.mm.cd.a;

public final class ManagerRoomByWeworkUI$b
  extends RecyclerView.h
{
  private int dividerHeight;
  private Paint fse;
  private Paint ftg;
  private int fth;
  
  public ManagerRoomByWeworkUI$b(Context paramContext, float paramFloat)
  {
    AppMethodBeat.i(196625);
    this.dividerHeight = a.g(paramContext, 0.5F);
    this.fth = a.g(paramContext, paramFloat);
    this.fse = new Paint();
    this.fse.setColor(paramContext.getResources().getColor(2131099656));
    this.ftg = new Paint();
    this.ftg.setColor(paramContext.getResources().getColor(2131099679));
    AppMethodBeat.o(196625);
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(196626);
    super.a(paramCanvas, paramRecyclerView, params);
    int j = paramRecyclerView.getChildCount();
    int k = paramRecyclerView.getPaddingLeft();
    int m = this.fth;
    int n = paramRecyclerView.getWidth() - paramRecyclerView.getPaddingRight();
    int i = 0;
    if (i < j)
    {
      params = paramRecyclerView.getChildAt(i);
      float f1 = params.getBottom();
      float f2 = params.getBottom() + this.dividerHeight;
      if (i == j - 1) {
        paramCanvas.drawRect(k, f1, n, f2, this.ftg);
      }
      for (;;)
      {
        i += 1;
        break;
        paramCanvas.drawRect(k + m, f1, n, f2, this.fse);
      }
    }
    AppMethodBeat.o(196626);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(196627);
    super.a(paramRect, paramView, paramRecyclerView, params);
    paramRect.bottom = this.dividerHeight;
    AppMethodBeat.o(196627);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ManagerRoomByWeworkUI.b
 * JD-Core Version:    0.7.0.1
 */