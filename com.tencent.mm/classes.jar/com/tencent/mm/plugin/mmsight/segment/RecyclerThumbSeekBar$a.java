package com.tencent.mm.plugin.mmsight.segment;

import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class RecyclerThumbSeekBar$a
  implements Runnable
{
  private RecyclerThumbSeekBar.b Fek;
  private Bitmap bitmap;
  private ImageView fDJ;
  
  RecyclerThumbSeekBar$a(RecyclerThumbSeekBar paramRecyclerThumbSeekBar, Bitmap paramBitmap, ImageView paramImageView, RecyclerThumbSeekBar.b paramb)
  {
    this.bitmap = paramBitmap;
    this.fDJ = paramImageView;
    this.Fek = paramb;
  }
  
  public final void run()
  {
    boolean bool = true;
    AppMethodBeat.i(94416);
    if ((this.bitmap == null) || (this.bitmap.isRecycled()))
    {
      if (this.bitmap == null) {}
      for (;;)
      {
        Log.i("RecyclerThumbSeekBar", "bitmap is null %b in DrawBitmapOnViewTask", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(94416);
        return;
        bool = false;
      }
    }
    if ((this.Fek == null) || (this.Fek.lTb) || (this.fDJ == null))
    {
      Log.i("RecyclerThumbSeekBar", "bitmap in DrawBitmapOnViewTask");
      AppMethodBeat.o(94416);
      return;
    }
    ImageView localImageView = this.fDJ;
    localImageView.setTag(null);
    ObjectAnimator.ofInt(localImageView, "imageAlpha", new int[] { 50, 255 }).setDuration(200L).start();
    localImageView.setImageBitmap(this.bitmap);
    AppMethodBeat.o(94416);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar.a
 * JD-Core Version:    0.7.0.1
 */