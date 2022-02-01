package com.tencent.mm.plugin.gallery.ui;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView.v;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.ui.widget.MMNumberCheckbox;

final class a$a
  extends RecyclerView.v
{
  ImageView rHf;
  ImageView rHg;
  TextView rHh;
  MMNumberCheckbox rHi;
  View rHj;
  ImageView rww;
  
  a$a(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(111391);
    this.rww = ((ImageView)paramView.findViewById(2131302221));
    this.rHf = ((ImageView)paramView.findViewById(2131302212));
    this.rHg = ((ImageView)paramView.findViewById(2131306177));
    this.rHh = ((TextView)paramView.findViewById(2131306178));
    this.rHi = ((MMNumberCheckbox)paramView.findViewById(2131302204));
    this.rHj = paramView.findViewById(2131306176);
    AppMethodBeat.o(111391);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.a.a
 * JD-Core Version:    0.7.0.1
 */