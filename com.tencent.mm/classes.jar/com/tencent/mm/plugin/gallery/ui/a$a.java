package com.tencent.mm.plugin.gallery.ui;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView.v;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.ui.widget.MMNumberCheckbox;

final class a$a
  extends RecyclerView.v
{
  ImageView xdY;
  ImageView xnA;
  TextView xnB;
  MMNumberCheckbox xnC;
  View xnD;
  ImageView xnz;
  
  a$a(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(111391);
    this.xdY = ((ImageView)paramView.findViewById(2131304573));
    this.xnz = ((ImageView)paramView.findViewById(2131304563));
    this.xnA = ((ImageView)paramView.findViewById(2131309563));
    this.xnB = ((TextView)paramView.findViewById(2131309564));
    this.xnC = ((MMNumberCheckbox)paramView.findViewById(2131304550));
    this.xnD = paramView.findViewById(2131309562);
    AppMethodBeat.o(111391);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.a.a
 * JD-Core Version:    0.7.0.1
 */