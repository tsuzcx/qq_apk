package com.tencent.mm.plugin.card.c;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.sdk.platformtools.Log;

final class l$1
  implements r.a
{
  l$1(String paramString, ImageView paramImageView) {}
  
  public final void k(String paramString, final Bitmap paramBitmap)
  {
    AppMethodBeat.i(293744);
    StringBuilder localStringBuilder = new StringBuilder().append(paramString).append(", bitmap null = ");
    if (paramBitmap == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.CardUtil", bool);
      if ((this.val$url != null) && (paramBitmap != null) && (!paramBitmap.isRecycled())) {
        break;
      }
      AppMethodBeat.o(293744);
      return;
    }
    if (paramString.equals(this.val$url)) {
      this.cfy.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(293734);
          if (l.1.this.wKx)
          {
            l.1.this.cfy.setImageBitmap(l.b(paramBitmap, Math.min(paramBitmap.getWidth(), paramBitmap.getHeight()) / 2));
            AppMethodBeat.o(293734);
            return;
          }
          l.1.this.cfy.setImageBitmap(paramBitmap);
          AppMethodBeat.o(293734);
        }
      });
    }
    AppMethodBeat.o(293744);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.card.c.l.1
 * JD-Core Version:    0.7.0.1
 */