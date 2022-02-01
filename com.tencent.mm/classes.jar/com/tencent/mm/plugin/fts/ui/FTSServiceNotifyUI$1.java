package com.tencent.mm.plugin.fts.ui;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;

final class FTSServiceNotifyUI$1
  extends RecyclerView.h
{
  final int Hzl;
  final int Hzm;
  Paint paint;
  
  FTSServiceNotifyUI$1(FTSServiceNotifyUI paramFTSServiceNotifyUI)
  {
    AppMethodBeat.i(265638);
    this.Hzl = a.fromDPToPix(this.Hzn.getContext(), 37);
    this.Hzm = a.fromDPToPix(this.Hzn.getContext(), 18);
    this.paint = new Paint(1);
    AppMethodBeat.o(265638);
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(265652);
    super.a(paramCanvas, paramRecyclerView, params);
    this.paint.setColor(-2434342);
    this.paint.setStrokeWidth(1.0F);
    this.paint.setStyle(Paint.Style.FILL);
    int j = paramRecyclerView.getChildCount();
    int i = 0;
    while (i < j)
    {
      params = paramRecyclerView.getChildAt(i);
      if (i == 0) {
        paramCanvas.drawLine(params.getRight() + this.Hzl, params.getTop(), params.getRight() + this.Hzl, params.getBottom(), this.paint);
      }
      i += 1;
    }
    AppMethodBeat.o(265652);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(265643);
    super.a(paramRect, paramView, paramRecyclerView, params);
    paramRect.set(this.Hzl, this.Hzm, this.Hzl, this.Hzm);
    AppMethodBeat.o(265643);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSServiceNotifyUI.1
 * JD-Core Version:    0.7.0.1
 */