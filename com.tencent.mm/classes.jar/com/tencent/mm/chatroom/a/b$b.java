package com.tencent.mm.chatroom.a;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.AbsListView.LayoutParams;
import com.tencent.mm.chatroom.ui.c;
import com.tencent.mm.chatroom.ui.c.a;

public final class b$b
  extends RecyclerView.v
{
  final c dmE;
  
  public b$b(View paramView, c.a parama)
  {
    super(paramView);
    this.dmE = ((c)paramView);
    this.dmE.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
    this.dmE.setClickable(true);
    this.dmE.setOnDayClickListener(parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.a.b.b
 * JD-Core Version:    0.7.0.1
 */