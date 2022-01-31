package com.tencent.mm.plugin.fts;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.c.a;

final class c$3$1
  implements Runnable
{
  c$3$1(c.3 param3, String paramString, Bitmap paramBitmap) {}
  
  public final void run()
  {
    AppMethodBeat.i(136523);
    if (this.cbQ.equals(this.mPx.mPw.getTag())) {
      c.a.a(this.mPx.val$context.getResources(), this.val$bitmap, this.mPx.mPw);
    }
    AppMethodBeat.o(136523);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.c.3.1
 * JD-Core Version:    0.7.0.1
 */