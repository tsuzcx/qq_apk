package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class ImagePreviewUI$6
  extends RecyclerView.h
{
  ImagePreviewUI$6(ImagePreviewUI paramImagePreviewUI) {}
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(111564);
    int i = (int)MMApplicationContext.getContext().getResources().getDimension(2131165498);
    paramRect.left = (i / 2);
    paramRect.bottom = i;
    paramRect.top = i;
    paramRect.right = (i / 2);
    AppMethodBeat.o(111564);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.ImagePreviewUI.6
 * JD-Core Version:    0.7.0.1
 */