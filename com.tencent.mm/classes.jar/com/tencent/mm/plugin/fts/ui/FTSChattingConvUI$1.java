package com.tencent.mm.plugin.fts.ui;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FTSChattingConvUI$1
  extends RecyclerView.h
{
  final int offset;
  Paint paint;
  
  FTSChattingConvUI$1(FTSChattingConvUI paramFTSChattingConvUI)
  {
    AppMethodBeat.i(61790);
    this.offset = ((int)this.mWY.getResources().getDimension(2131427500));
    this.paint = new Paint(1);
    AppMethodBeat.o(61790);
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(61792);
    super.a(paramCanvas, paramRecyclerView, params);
    this.paint.setColor(-2434342);
    this.paint.setStrokeWidth(1.0F);
    this.paint.setStyle(Paint.Style.FILL);
    int j = paramRecyclerView.getChildCount();
    int i = 0;
    if (i < j)
    {
      params = paramRecyclerView.getChildAt(i);
      if ((i == 1) || (i == 4))
      {
        paramCanvas.drawLine(params.getLeft() - this.offset, params.getTop(), params.getLeft() - this.offset, params.getBottom(), this.paint);
        paramCanvas.drawLine(params.getRight() + this.offset, params.getTop(), params.getRight() + this.offset, params.getBottom(), this.paint);
      }
      for (;;)
      {
        i += 1;
        break;
        if (i == 7) {
          paramCanvas.drawLine(params.getLeft() - this.offset, params.getTop(), params.getLeft() - this.offset, params.getBottom(), this.paint);
        }
      }
    }
    AppMethodBeat.o(61792);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(61791);
    super.a(paramRect, paramView, paramRecyclerView, params);
    paramRect.set(this.offset, this.offset, this.offset, this.offset);
    AppMethodBeat.o(61791);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSChattingConvUI.1
 * JD-Core Version:    0.7.0.1
 */