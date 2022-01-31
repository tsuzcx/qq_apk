package com.tencent.mm.plugin.gallery.ui;

import android.graphics.Bitmap;
import android.os.SystemClock;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;

final class h$b
  implements Runnable
{
  final WeakReference<ImageView> nho;
  
  h$b(ImageView paramImageView)
  {
    AppMethodBeat.i(138612);
    this.nho = new WeakReference(paramImageView);
    AppMethodBeat.o(138612);
  }
  
  public final void run()
  {
    AppMethodBeat.i(21606);
    Object localObject = (ImageView)this.nho.get();
    if (localObject == null) {}
    for (localObject = null; (localObject == null) || (!(localObject instanceof h)); localObject = ((ImageView)localObject).getDrawable())
    {
      ab.w("MicroMsg.ThumbDrawable", "[tomys] ownerView is null or not a ThumbDrawable, ignore this task.");
      AppMethodBeat.o(21606);
      return;
    }
    ab.v("MicroMsg.ThumbDrawable", "invalidateSelf");
    localObject = (h)localObject;
    h.a((h)localObject, e.bDP().Pz(((h)localObject).mFilePath));
    if ((((h)localObject).nhk != null) && (h.a((h)localObject) != null) && (!h.a((h)localObject).isRecycled())) {
      ((h)localObject).nhk.bEo();
    }
    if ((h.a((h)localObject) == null) || (h.a((h)localObject).isRecycled()))
    {
      e.bDP().b(((h)localObject).mFilePath, ((h)localObject).cth, ((h)localObject).ncH, ((h)localObject).ncI);
      ab.v("MicroMsg.ThumbDrawable", "invalidateSelf! mBitmap is null! path:%s", new Object[] { ((h)localObject).mFilePath });
    }
    ((h)localObject).nhl = SystemClock.uptimeMillis();
    ((h)localObject).invalidateSelf();
    AppMethodBeat.o(21606);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.h.b
 * JD-Core Version:    0.7.0.1
 */