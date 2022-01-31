package com.tencent.mm.plugin.emoji.a;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class i$a
  implements com.tencent.mm.at.a.c.i
{
  i leI;
  
  public final void a(String paramString, View paramView, Bitmap paramBitmap, Object... paramVarArgs)
  {
    AppMethodBeat.i(52764);
    ab.i("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "onImageLoadComplete url:%s", new Object[] { paramString });
    al.d(new i.a.1(this));
    AppMethodBeat.o(52764);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.i.a
 * JD-Core Version:    0.7.0.1
 */