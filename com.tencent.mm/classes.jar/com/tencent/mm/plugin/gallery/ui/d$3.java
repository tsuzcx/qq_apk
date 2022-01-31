package com.tencent.mm.plugin.gallery.ui;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mm.a.f;
import com.tencent.mm.plugin.gallery.model.j;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

final class d$3
  implements av.a
{
  private Bitmap kJz = null;
  
  d$3(d paramd, String paramString) {}
  
  public final boolean JS()
  {
    if ((this.kJy.kJw == null) || (TextUtils.isEmpty(this.kJA))) {
      return false;
    }
    String str = this.kJA;
    long l = bk.UZ();
    Bitmap localBitmap = j.Er(str);
    y.v("MicroMsg.ImageAdapter", "test decode: %d filePath:%s", new Object[] { Long.valueOf(bk.cp(l)), str });
    this.kJz = localBitmap;
    return true;
  }
  
  public final boolean JT()
  {
    this.kJy.kJx = false;
    int i;
    if (this.kJy.kJq.containsKey(this.kJA))
    {
      i = ((Integer)this.kJy.kJq.get(this.kJA)).intValue();
      if (this.kJy.aXR()) {
        break label103;
      }
      this.kJy.kJs.put(i, this.kJz);
    }
    for (;;)
    {
      this.kJy.kJt.f(this.kJA, this.kJz);
      this.kJz = null;
      this.kJy.ahX();
      return false;
      label103:
      d.a(this.kJy, i, this.kJz);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.d.3
 * JD-Core Version:    0.7.0.1
 */