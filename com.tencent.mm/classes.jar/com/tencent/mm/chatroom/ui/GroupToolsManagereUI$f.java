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
import com.tencent.mm.cd.a;

public final class GroupToolsManagereUI$f
  extends RecyclerView.h
{
  private Paint lCo;
  private int lCp;
  
  public GroupToolsManagereUI$f(Context paramContext)
  {
    AppMethodBeat.i(182191);
    this.lCp = a.fromDPToPix(paramContext, 8);
    this.lCo = new Paint();
    this.lCo.setColor(paramContext.getResources().getColor(a.b.BG_2));
    AppMethodBeat.o(182191);
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(241515);
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
      float f2 = params.getBottom() + this.lCp;
      paramCanvas.drawRect(k, f1, m - n, f2, this.lCo);
      i += 1;
    }
    AppMethodBeat.o(241515);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(241521);
    super.a(paramRect, paramView, paramRecyclerView, params);
    paramRect.bottom = this.lCp;
    AppMethodBeat.o(241521);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.GroupToolsManagereUI.f
 * JD-Core Version:    0.7.0.1
 */