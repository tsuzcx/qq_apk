package com.tencent.mm.media.i;

import android.graphics.Bitmap;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/remuxer/IMediaCodecRemuxer;", "", "remux", "", "setVideoBlendBitmap", "", "bitmap", "Landroid/graphics/Bitmap;", "setVideoBlendBitmapProvider", "blendBitmapProvider", "Lkotlin/Function1;", "", "setVideoBlurBgProvider", "blurBgProvider", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface b
{
  public abstract void E(kotlin.g.a.b<? super Long, Bitmap> paramb);
  
  public abstract void F(kotlin.g.a.b<? super Long, Bitmap> paramb);
  
  public abstract int bpE();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.i.b
 * JD-Core Version:    0.7.0.1
 */