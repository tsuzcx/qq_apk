package com.tencent.mm.chatroom.ui;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class DayPickerView$1
  extends RecyclerView.m
{
  DayPickerView$1(DayPickerView paramDayPickerView) {}
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(104079);
    super.a(paramRecyclerView, paramInt1, paramInt2);
    if ((c)paramRecyclerView.getChildAt(0) == null)
    {
      AppMethodBeat.o(104079);
      return;
    }
    this.egf.egb = paramInt2;
    this.egf.mb = this.egf.ega;
    AppMethodBeat.o(104079);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.DayPickerView.1
 * JD-Core Version:    0.7.0.1
 */