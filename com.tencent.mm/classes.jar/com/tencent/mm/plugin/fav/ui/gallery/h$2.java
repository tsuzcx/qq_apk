package com.tencent.mm.plugin.fav.ui.gallery;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class h$2
  extends RecyclerView.h
{
  h$2(h paramh, Context paramContext) {}
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(107424);
    int i = (int)this.val$context.getResources().getDimension(2131165537);
    paramRect.bottom = i;
    paramRect.top = i;
    paramRect.left = i;
    paramRect.right = i;
    AppMethodBeat.o(107424);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.h.2
 * JD-Core Version:    0.7.0.1
 */