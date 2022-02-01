package com.tencent.mm.plugin.fav.ui.gallery;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.sdk.f.b;

final class FavMediaGalleryUI$10
  implements p.a
{
  FavMediaGalleryUI$10(FavMediaGalleryUI paramFavMediaGalleryUI) {}
  
  public final void bF(String paramString1, String paramString2)
  {
    AppMethodBeat.i(218802);
    Toast.makeText(this.rCb, this.rCb.getString(2131757969, new Object[] { b.ffp() }), 1).show();
    AppMethodBeat.o(218802);
  }
  
  public final void bG(String paramString1, String paramString2)
  {
    AppMethodBeat.i(218803);
    Toast.makeText(this.rCb, this.rCb.getString(2131758993), 1).show();
    AppMethodBeat.o(218803);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.FavMediaGalleryUI.10
 * JD-Core Version:    0.7.0.1
 */