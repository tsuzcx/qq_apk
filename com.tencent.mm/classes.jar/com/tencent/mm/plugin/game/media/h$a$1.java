package com.tencent.mm.plugin.game.media;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.c.h;
import com.tencent.mm.av.a.d.b;
import com.tencent.mm.sdk.platformtools.ae;

final class h$a$1
  implements h
{
  h$a$1(h.a parama) {}
  
  public final Bitmap a(String paramString, View paramView, b paramb)
  {
    return null;
  }
  
  public final void b(String paramString, View paramView) {}
  
  public final void b(String paramString, View paramView, b paramb)
  {
    AppMethodBeat.i(40977);
    if ((paramb != null) && (paramb.bitmap != null)) {
      ae.i("MicroMsg.GameHaowanRecycleView", "load thumb:%s, from:%d", new Object[] { paramString, Integer.valueOf(paramb.from) });
    }
    AppMethodBeat.o(40977);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.h.a.1
 * JD-Core Version:    0.7.0.1
 */