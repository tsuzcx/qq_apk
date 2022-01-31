package com.tencent.mm.plugin.mmsight.segment;

import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.y;

final class RecyclerThumbSeekBar$a
  implements Runnable
{
  private ImageView bNu;
  private Bitmap bitmap;
  private RecyclerThumbSeekBar.b mmk;
  
  RecyclerThumbSeekBar$a(RecyclerThumbSeekBar paramRecyclerThumbSeekBar, Bitmap paramBitmap, ImageView paramImageView, RecyclerThumbSeekBar.b paramb)
  {
    this.bitmap = paramBitmap;
    this.bNu = paramImageView;
    this.mmk = paramb;
  }
  
  public final void run()
  {
    boolean bool = true;
    if ((this.bitmap == null) || (this.bitmap.isRecycled()))
    {
      if (this.bitmap == null) {}
      for (;;)
      {
        y.i("RecyclerThumbSeekBar", "bitmap is null %b in DrawBitmapOnViewTask", new Object[] { Boolean.valueOf(bool) });
        return;
        bool = false;
      }
    }
    if ((this.mmk == null) || (this.mmk.esC) || (this.bNu == null))
    {
      y.i("RecyclerThumbSeekBar", "bitmap in DrawBitmapOnViewTask");
      return;
    }
    ImageView localImageView = this.bNu;
    localImageView.setTag(null);
    ObjectAnimator.ofInt(localImageView, "imageAlpha", new int[] { 50, 255 }).setDuration(200L).start();
    localImageView.setImageBitmap(this.bitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar.a
 * JD-Core Version:    0.7.0.1
 */