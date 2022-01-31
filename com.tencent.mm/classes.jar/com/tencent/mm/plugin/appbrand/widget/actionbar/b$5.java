package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.graphics.Bitmap;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.AppBrandActionBarCustomImageView;

final class b$5
  implements Runnable
{
  b$5(b paramb, Bitmap paramBitmap, View.OnClickListener paramOnClickListener) {}
  
  public final void run()
  {
    AppMethodBeat.i(141716);
    b.c(this.jbs).setVisibility(0);
    b.c(this.jbs).setImageBitmap(this.val$bitmap);
    b.c(this.jbs).setClickable(true);
    b.c(this.jbs).setOnClickListener(this.val$listener);
    AppMethodBeat.o(141716);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.b.5
 * JD-Core Version:    0.7.0.1
 */