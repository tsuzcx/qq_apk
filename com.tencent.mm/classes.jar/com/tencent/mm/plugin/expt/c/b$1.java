package com.tencent.mm.plugin.expt.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.lh;
import com.tencent.mm.hellhoundlib.a.b;
import com.tencent.mm.sdk.event.EventCenter;

final class b$1
  implements b
{
  public final void a(String paramString1, String paramString2, String paramString3, Object paramObject)
  {
    AppMethodBeat.i(220261);
    paramString1 = new lh();
    paramString1.dQy.action = 1;
    EventCenter.instance.publish(paramString1);
    AppMethodBeat.o(220261);
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, String paramString4, Object paramObject, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(220260);
    paramString1 = new lh();
    paramString1.dQy.action = 0;
    EventCenter.instance.publish(paramString1);
    AppMethodBeat.o(220260);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.c.b.1
 * JD-Core Version:    0.7.0.1
 */