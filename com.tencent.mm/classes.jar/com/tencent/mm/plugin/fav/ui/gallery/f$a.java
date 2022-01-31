package com.tencent.mm.plugin.fav.ui.gallery;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f$a
  extends RecyclerView.v
{
  TextView gpp;
  ProgressBar progressBar;
  
  public f$a(f paramf, View paramView)
  {
    super(paramView);
    AppMethodBeat.i(74566);
    this.gpp = ((TextView)paramView.findViewById(2131824015));
    this.progressBar = ((ProgressBar)paramView.findViewById(2131824014));
    AppMethodBeat.o(74566);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.f.a
 * JD-Core Version:    0.7.0.1
 */