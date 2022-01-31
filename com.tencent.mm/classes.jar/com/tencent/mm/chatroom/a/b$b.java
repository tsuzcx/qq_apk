package com.tencent.mm.chatroom.a;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.AbsListView.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.ui.c;
import com.tencent.mm.chatroom.ui.c.a;

public final class b$b
  extends RecyclerView.v
{
  final c eeh;
  
  public b$b(View paramView, c.a parama)
  {
    super(paramView);
    AppMethodBeat.i(103891);
    this.eeh = ((c)paramView);
    this.eeh.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
    this.eeh.setClickable(true);
    this.eeh.setOnDayClickListener(parama);
    AppMethodBeat.o(103891);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.a.b.b
 * JD-Core Version:    0.7.0.1
 */