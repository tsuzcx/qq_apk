package com.tencent.mm.plugin.emoji.ui;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.c.k;
import com.tencent.mm.sdk.platformtools.ac;
import java.lang.ref.WeakReference;

final class EmojiStoreDetailUI$d
  implements k
{
  WeakReference<EmojiStoreDetailUI> cnv;
  
  public final void a(String paramString, View paramView, Bitmap paramBitmap, Object... paramVarArgs)
  {
    AppMethodBeat.i(176195);
    ac.d("MicroMsg.emoji.EmojiStoreDetailUI", "[cpan] on image load complete url:%s", new Object[] { paramString });
    if (this.cnv == null)
    {
      AppMethodBeat.o(176195);
      return;
    }
    paramString = (EmojiStoreDetailUI)this.cnv.get();
    if (paramString == null)
    {
      AppMethodBeat.o(176195);
      return;
    }
    if (paramBitmap != null) {
      paramString.Bv(1006);
    }
    AppMethodBeat.o(176195);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.d
 * JD-Core Version:    0.7.0.1
 */