package com.tencent.mm.plugin.collect.ui;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.sdk.platformtools.ab;

final class CollectMainUI$12
  implements x.a
{
  CollectMainUI$12(CollectMainUI paramCollectMainUI) {}
  
  public final void m(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(41264);
    if ((paramString == null) || (CollectMainUI.a(this.kSz) == null))
    {
      AppMethodBeat.o(41264);
      return;
    }
    if (paramString.equals(CollectMainUI.a(this.kSz)))
    {
      ab.i("MicroMsg.CollectMainUI", "cdnImageDownloadListener mchPhoto = %s notifyKey = %s", new Object[] { CollectMainUI.a(this.kSz), paramString });
      this.kSz.bir();
    }
    AppMethodBeat.o(41264);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectMainUI.12
 * JD-Core Version:    0.7.0.1
 */