package com.tencent.mm.plugin.fav.ui.gallery;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.plugin.fav.ui.n.e;

public final class f$a
  extends RecyclerView.v
{
  TextView eXs;
  ProgressBar frw;
  
  public f$a(f paramf, View paramView)
  {
    super(paramView);
    this.eXs = ((TextView)paramView.findViewById(n.e.date_info));
    this.frw = ((ProgressBar)paramView.findViewById(n.e.load_progress));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.f.a
 * JD-Core Version:    0.7.0.1
 */