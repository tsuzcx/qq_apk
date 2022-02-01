package com.tencent.mm.plugin.appbrand.dynamic.b;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.canvas.e.a;
import com.tencent.mm.plugin.appbrand.dynamic.f.a;
import com.tencent.mm.plugin.appbrand.dynamic.i;

final class c$1
  implements b.k
{
  c$1(c paramc, e.a parama, d paramd, String paramString1, String paramString2) {}
  
  public final String BM()
  {
    return "WxaWidgetIcon";
  }
  
  public final void E(Bitmap paramBitmap)
  {
    AppMethodBeat.i(121252);
    if ((this.kfQ == null) || (paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(121252);
      return;
    }
    this.kfQ.a(this.kfR);
    AppMethodBeat.o(121252);
  }
  
  public final void aEd() {}
  
  public final void ox()
  {
    AppMethodBeat.i(121253);
    Bundle localBundle = new Bundle();
    localBundle.putString("id", this.val$id);
    localBundle.putInt("widgetState", 2103);
    h.a(i.bfK().Ou(this.val$id), localBundle, f.a.class, null);
    AppMethodBeat.o(121253);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.b.c.1
 * JD-Core Version:    0.7.0.1
 */