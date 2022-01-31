package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;
import com.tencent.mm.R.f;
import com.tencent.mm.sdk.platformtools.ae;

final class ImagePreviewUI$7
  extends RecyclerView.h
{
  ImagePreviewUI$7(ImagePreviewUI paramImagePreviewUI) {}
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    int i = (int)ae.getContext().getResources().getDimension(R.f.LargePadding);
    paramRect.left = (i / 2);
    paramRect.bottom = i;
    paramRect.top = i;
    paramRect.right = (i / 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.ImagePreviewUI.7
 * JD-Core Version:    0.7.0.1
 */