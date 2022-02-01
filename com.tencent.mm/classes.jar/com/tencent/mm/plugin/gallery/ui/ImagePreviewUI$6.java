package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.b.c;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class ImagePreviewUI$6
  extends RecyclerView.h
{
  ImagePreviewUI$6(ImagePreviewUI paramImagePreviewUI) {}
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(242564);
    int i = (int)MMApplicationContext.getContext().getResources().getDimension(b.c.LargePadding);
    paramRect.left = (i / 2);
    paramRect.bottom = i;
    paramRect.top = i;
    paramRect.right = (i / 2);
    AppMethodBeat.o(242564);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.ImagePreviewUI.6
 * JD-Core Version:    0.7.0.1
 */