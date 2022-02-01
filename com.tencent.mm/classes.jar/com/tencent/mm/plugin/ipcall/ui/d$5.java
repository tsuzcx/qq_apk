package com.tencent.mm.plugin.ipcall.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$5
  implements Runnable
{
  d$5(d paramd, ImageView paramImageView, String paramString, Bitmap paramBitmap) {}
  
  public final void run()
  {
    AppMethodBeat.i(25636);
    if ((this.kOW.getTag() != null) && (this.kOW.getTag().equals(this.val$key)) && (this.val$bitmap != null) && (!this.val$bitmap.isRecycled())) {
      this.kOW.setImageBitmap(this.val$bitmap);
    }
    AppMethodBeat.o(25636);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.d.5
 * JD-Core Version:    0.7.0.1
 */