package com.tencent.mm.aq;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.g;
import java.util.Map;
import java.util.Queue;

final class b$9
  implements Runnable
{
  b$9(b paramb, g paramg) {}
  
  public final void run()
  {
    AppMethodBeat.i(150402);
    b.f(this.lIb).add(this.lIf.field_mediaId);
    b.g(this.lIb).put(this.lIf.field_mediaId, this.lIf);
    this.lIb.go(false);
    AppMethodBeat.o(150402);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(205184);
    String str = super.toString() + "|addSendTask";
    AppMethodBeat.o(205184);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.aq.b.9
 * JD-Core Version:    0.7.0.1
 */