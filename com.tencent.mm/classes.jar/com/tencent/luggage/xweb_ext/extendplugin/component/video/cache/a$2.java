package com.tencent.luggage.xweb_ext.extendplugin.component.video.cache;

import com.google.android.exoplayer2.h.a.b;
import com.google.android.exoplayer2.h.g;
import com.google.android.exoplayer2.h.g.a;
import com.google.android.exoplayer2.h.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;

public final class a$2
  implements g.a
{
  public a$2(a parama) {}
  
  public final g qn()
  {
    AppMethodBeat.i(139877);
    Object localObject = com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a.c.ax(ah.getContext());
    localObject = new com.google.android.exoplayer2.h.a.c(a.a(this.bHX), ((g.a)localObject).qn(), new q(), new b(a.a(this.bHX)), new a.2.1(this));
    AppMethodBeat.o(139877);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.cache.a.2
 * JD-Core Version:    0.7.0.1
 */