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

final class FTSChattingConvUI$1
  extends RecyclerView.h
{
  Paint gaZ = new Paint(1);
  final int offset = (int)this.kBg.getResources().getDimension(n.b.BigPadding);
  
  FTSChattingConvUI$1(FTSChattingConvUI paramFTSChattingConvUI) {}
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    super.a(paramCanvas, paramRecyclerView, params);
    this.gaZ.setColor(-2434342);
    this.gaZ.setStrokeWidth(1.0F);
    this.gaZ.setStyle(Paint.Style.FILL);
    int j = paramRecyclerView.getChildCount();
    int i = 0;
    if (i < j)
    {
      if ((i == 1) || (i == 4))
      {
        params = paramRecyclerView.getChildAt(i);
        if (!FTSChattingConvUI.a(this.kBg)) {
          break label126;
        }
        paramCanvas.drawLine(params.getLeft() - this.offset, params.getTop(), params.getLeft() - this.offset, params.getBottom(), this.gaZ);
      }
      for (;;)
      {
        i += 1;
        break;
        label126:
        paramCanvas.drawLine(params.getLeft() - this.offset, params.getTop(), params.getLeft() - this.offset, params.getBottom(), this.gaZ);
        paramCanvas.drawLine(params.getRight() + this.offset, params.getTop(), params.getRight() + this.offset, params.getBottom(), this.gaZ);
      }
    }
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    super.a(paramRect, paramView, paramRecyclerView, params);
    paramRect.set(this.offset, this.offset, this.offset, this.offset);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSChattingConvUI.1
 * JD-Core Version:    0.7.0.1
 */