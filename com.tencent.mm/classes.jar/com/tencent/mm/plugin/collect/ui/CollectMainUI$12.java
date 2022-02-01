package com.tencent.mm.plugin.collect.ui;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.sdk.platformtools.Log;

final class CollectMainUI$12
  implements u.a
{
  CollectMainUI$12(CollectMainUI paramCollectMainUI) {}
  
  public final void k(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(64125);
    if ((paramString == null) || (CollectMainUI.a(this.uaM) == null))
    {
      AppMethodBeat.o(64125);
      return;
    }
    if (paramString.equals(CollectMainUI.a(this.uaM)))
    {
      Log.i("MicroMsg.CollectMainUI", "cdnImageDownloadListener mchPhoto = %s notifyKey = %s", new Object[] { CollectMainUI.a(this.uaM), paramString });
      this.uaM.cOQ();
    }
    AppMethodBeat.o(64125);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectMainUI.12
 * JD-Core Version:    0.7.0.1
 */