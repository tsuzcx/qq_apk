package com.tencent.mm.plugin.fts.ui;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FTSChattingConvUI$1
  extends RecyclerView.h
{
  final int offset;
  Paint paint;
  
  FTSChattingConvUI$1(FTSChattingConvUI paramFTSChattingConvUI)
  {
    AppMethodBeat.i(111883);
    this.offset = ((int)this.sCG.getResources().getDimension(2131165191));
    this.paint = new Paint(1);
    AppMethodBeat.o(111883);
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.t paramt)
  {
    AppMethodBeat.i(111885);
    super.a(paramCanvas, paramRecyclerView, paramt);
    this.paint.setColor(-2434342);
    this.paint.setStrokeWidth(1.0F);
    this.paint.setStyle(Paint.Style.FILL);
    int j = paramRecyclerView.getChildCount();
    int i = 0;
    if (i < j)
    {
      paramt = paramRecyclerView.getChildAt(i);
      if ((i == 1) || (i == 4))
      {
        paramCanvas.drawLine(paramt.getLeft() - this.offset, paramt.getTop(), paramt.getLeft() - this.offset, paramt.getBottom(), this.paint);
        paramCanvas.drawLine(paramt.getRight() + this.offset, paramt.getTop(), paramt.getRight() + this.offset, paramt.getBottom(), this.paint);
      }
      for (;;)
      {
        i += 1;
        break;
        if (i == 7) {
          paramCanvas.drawLine(paramt.getLeft() - this.offset, paramt.getTop(), paramt.getLeft() - this.offset, paramt.getBottom(), this.paint);
        }
      }
    }
    AppMethodBeat.o(111885);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.t paramt)
  {
    AppMethodBeat.i(111884);
    super.a(paramRect, paramView, paramRecyclerView, paramt);
    paramRect.set(this.offset, this.offset, this.offset, this.offset);
    AppMethodBeat.o(111884);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSChattingConvUI.1
 * JD-Core Version:    0.7.0.1
 */