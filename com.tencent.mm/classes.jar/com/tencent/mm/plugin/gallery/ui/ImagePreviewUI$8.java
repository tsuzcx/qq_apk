package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;

final class ImagePreviewUI$8
  extends RecyclerView.h
{
  ImagePreviewUI$8(ImagePreviewUI paramImagePreviewUI) {}
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(150881);
    int i = (int)ah.getContext().getResources().getDimension(2131427772);
    paramRect.left = (i / 2);
    paramRect.bottom = i;
    paramRect.top = i;
    paramRect.right = (i / 2);
    AppMethodBeat.o(150881);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.ImagePreviewUI.8
 * JD-Core Version:    0.7.0.1
 */