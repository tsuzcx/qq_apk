package com.tencent.mm.aq;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.w;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;
import java.util.LinkedList;

final class b$1
  implements ap.a
{
  b$1(b paramb) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(16444);
    ab.i("MicroMsg.GetChatroomMsgFetcher", "timeoutHandler onTimerExpired");
    if (b.a(this.fCD) != null)
    {
      w.a(b.a(this.fCD));
      b.b(this.fCD);
    }
    b.a(this.fCD, new LinkedList());
    AppMethodBeat.o(16444);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.aq.b.1
 * JD-Core Version:    0.7.0.1
 */