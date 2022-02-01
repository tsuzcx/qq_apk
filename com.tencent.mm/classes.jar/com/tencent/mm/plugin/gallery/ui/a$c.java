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
  private TextView rHm;
  
  a$c(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(111394);
    this.rHm = ((TextView)paramView.findViewById(2131302221));
    if ((e.czh().rBG == 2) || (e.czh().jWF == 13))
    {
      this.rHm.setText(2131759820);
      AppMethodBeat.o(111394);
      return;
    }
    if (e.czh().rBG == 1) {
      this.rHm.setText(2131759819);
    }
    AppMethodBeat.o(111394);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.a.c
 * JD-Core Version:    0.7.0.1
 */