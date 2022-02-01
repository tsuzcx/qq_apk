package com.tencent.mm.plugin.fav.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.sdk.platformtools.aq;

final class o$6
  implements Runnable
{
  o$6(String paramString, int paramInt1, int paramInt2, com.tencent.mm.plugin.fav.a.g paramg, afy paramafy, boolean paramBoolean, ImageView paramImageView) {}
  
  public final void run()
  {
    AppMethodBeat.i(106971);
    final Bitmap localBitmap = o.d(this.val$path, this.qfV, this.qfW, false);
    if (localBitmap == null)
    {
      o.c(this.pZt, this.qft, this.qfU);
      AppMethodBeat.o(106971);
      return;
    }
    String str = (String)this.oXU.getTag();
    if ((str != null) && (str.equals(this.val$path)))
    {
      com.tencent.mm.kernel.g.afE();
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(106970);
          o.6.this.oXU.setImageBitmap(localBitmap);
          AppMethodBeat.o(106970);
        }
      });
    }
    AppMethodBeat.o(106971);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.o.6
 * JD-Core Version:    0.7.0.1
 */