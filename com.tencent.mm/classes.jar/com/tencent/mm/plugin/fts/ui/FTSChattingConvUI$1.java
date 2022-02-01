package com.tencent.mm.plugin.fts.ui;

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

final class FTSChattingConvUI$1
  extends RecyclerView.h
{
  final int offset;
  Paint paint;
  
  FTSChattingConvUI$1(FTSChattingConvUI paramFTSChattingConvUI)
  {
    AppMethodBeat.i(111883);
    this.offset = ((int)this.BNl.getResources().getDimension(o.b.BigPadding));
    this.paint = new Paint(1);
    AppMethodBeat.o(111883);
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(189491);
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
    AppMethodBeat.o(189491);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(189480);
    super.a(paramRect, paramView, paramRecyclerView, params);
    paramRect.set(this.offset, this.offset, this.offset, this.offset);
    AppMethodBeat.o(189480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSChattingConvUI.1
 * JD-Core Version:    0.7.0.1
 */