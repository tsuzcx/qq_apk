package com.tencent.mm.plugin.downloader_app.ui;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b$a
  extends RecyclerView.v
{
  public View contentView;
  
  public b$a(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(136284);
    this.contentView = ((ViewGroup)paramView).getChildAt(0);
    AppMethodBeat.o(136284);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.b.a
 * JD-Core Version:    0.7.0.1
 */