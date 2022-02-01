package com.tencent.mm.plugin.gallery.ui;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.plugin.gallery.model.o;

final class a$c
  extends RecyclerView.v
{
  private TextView xnG;
  
  a$c(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(111394);
    this.xnG = ((TextView)paramView.findViewById(2131304573));
    if ((e.dQK().xjo == 2) || (e.dQK().mcq == 13))
    {
      this.xnG.setText(2131761150);
      AppMethodBeat.o(111394);
      return;
    }
    if (e.dQK().xjo == 1) {
      this.xnG.setText(2131761149);
    }
    AppMethodBeat.o(111394);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.a.c
 * JD-Core Version:    0.7.0.1
 */