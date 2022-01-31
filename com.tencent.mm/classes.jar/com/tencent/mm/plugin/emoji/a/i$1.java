package com.tencent.mm.plugin.emoji.a;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

final class i$1
  implements com.tencent.mm.as.a.c.i
{
  i$1(i parami) {}
  
  public final void a(String paramString, View paramView, Bitmap paramBitmap, Object... paramVarArgs)
  {
    y.i("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "onImageLoadComplete url:%s", new Object[] { paramString });
    i.a(this.iVD).post(new i.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.i.1
 * JD-Core Version:    0.7.0.1
 */