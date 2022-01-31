package com.tencent.mm.plugin.collect.ui;

import android.graphics.Bitmap;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.sdk.platformtools.y;

final class CollectMainUI$12
  implements x.a
{
  CollectMainUI$12(CollectMainUI paramCollectMainUI) {}
  
  public final void l(String paramString, Bitmap paramBitmap)
  {
    if ((paramString == null) || (CollectMainUI.a(this.iLP) == null)) {}
    while (!paramString.equals(CollectMainUI.a(this.iLP))) {
      return;
    }
    y.i("MicroMsg.CollectMainUI", "cdnImageDownloadListener mchPhoto = %s notifyKey = %s", new Object[] { CollectMainUI.a(this.iLP), paramString });
    this.iLP.aFc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectMainUI.12
 * JD-Core Version:    0.7.0.1
 */