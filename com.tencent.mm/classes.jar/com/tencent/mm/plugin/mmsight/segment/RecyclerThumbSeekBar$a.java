package com.tencent.mm.plugin.mmsight.segment;

import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class RecyclerThumbSeekBar$a
  implements Runnable
{
  private Bitmap bitmap;
  private ImageView cuM;
  private RecyclerThumbSeekBar.b oLr;
  
  RecyclerThumbSeekBar$a(RecyclerThumbSeekBar paramRecyclerThumbSeekBar, Bitmap paramBitmap, ImageView paramImageView, RecyclerThumbSeekBar.b paramb)
  {
    this.bitmap = paramBitmap;
    this.cuM = paramImageView;
    this.oLr = paramb;
  }
  
  public final void run()
  {
    boolean bool = true;
    AppMethodBeat.i(54985);
    if ((this.bitmap == null) || (this.bitmap.isRecycled()))
    {
      if (this.bitmap == null) {}
      for (;;)
      {
        ab.i("RecyclerThumbSeekBar", "bitmap is null %b in DrawBitmapOnViewTask", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(54985);
        return;
        bool = false;
      }
    }
    if ((this.oLr == null) || (this.oLr.fIp) || (this.cuM == null))
    {
      ab.i("RecyclerThumbSeekBar", "bitmap in DrawBitmapOnViewTask");
      AppMethodBeat.o(54985);
      return;
    }
    ImageView localImageView = this.cuM;
    localImageView.setTag(null);
    ObjectAnimator.ofInt(localImageView, "imageAlpha", new int[] { 50, 255 }).setDuration(200L).start();
    localImageView.setImageBitmap(this.bitmap);
    AppMethodBeat.o(54985);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar.a
 * JD-Core Version:    0.7.0.1
 */