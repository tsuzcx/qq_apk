package com.tencent.mm.plugin.appbrand.ui;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.base.preference.IconPreference;

final class AppBrandAuthorizeUI$15
  implements b.k
{
  AppBrandAuthorizeUI$15(AppBrandAuthorizeUI paramAppBrandAuthorizeUI, IconPreference paramIconPreference) {}
  
  public final void I(final Bitmap paramBitmap)
  {
    AppMethodBeat.i(227575);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(227574);
        AppBrandAuthorizeUI.15.this.nRZ.aL(paramBitmap);
        AppBrandAuthorizeUI.15.this.nRZ.alH(0);
        AppMethodBeat.o(227574);
      }
    });
    AppMethodBeat.o(227575);
  }
  
  public final String Lb()
  {
    return null;
  }
  
  public final void aYg() {}
  
  public final void oD() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.15
 * JD-Core Version:    0.7.0.1
 */