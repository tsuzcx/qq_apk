package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;

public final class ManagerRoomByWeworkUI$b
  extends RecyclerView.h
{
  private Paint jat;
  private int jau;
  private Paint jbC;
  private int jbD;
  
  public ManagerRoomByWeworkUI$b(Context paramContext, float paramFloat)
  {
    AppMethodBeat.i(193198);
    this.jau = a.fromDPToPix(paramContext, 0.5F);
    this.jbD = a.fromDPToPix(paramContext, paramFloat);
    this.jat = new Paint();
    this.jat.setColor(paramContext.getResources().getColor(a.b.BW_0_Alpha_0_1));
    this.jbC = new Paint();
    this.jbC.setColor(paramContext.getResources().getColor(a.b.BW_93));
    AppMethodBeat.o(193198);
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(193209);
    super.a(paramCanvas, paramRecyclerView, params);
    int j = paramRecyclerView.getChildCount();
    int k = paramRecyclerView.getPaddingLeft();
    int m = this.jbD;
    int n = paramRecyclerView.getWidth() - paramRecyclerView.getPaddingRight();
    int i = 0;
    if (i < j)
    {
      params = paramRecyclerView.getChildAt(i);
      float f1 = params.getBottom();
      float f2 = params.getBottom() + this.jau;
      if (i == j - 1) {
        paramCanvas.drawRect(k, f1, n, f2, this.jbC);
      }
      for (;;)
      {
        i += 1;
        break;
        paramCanvas.drawRect(k + m, f1, n, f2, this.jat);
      }
    }
    AppMethodBeat.o(193209);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(193213);
    super.a(paramRect, paramView, paramRecyclerView, params);
    paramRect.bottom = this.jau;
    AppMethodBeat.o(193213);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ManagerRoomByWeworkUI.b
 * JD-Core Version:    0.7.0.1
 */