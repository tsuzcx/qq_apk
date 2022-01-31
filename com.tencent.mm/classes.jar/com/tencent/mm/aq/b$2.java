package com.tencent.mm.aq;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import java.util.List;

final class b$2
  implements b.b
{
  b$2(b paramb) {}
  
  public final void b(int paramInt, List<bi> paramList)
  {
    AppMethodBeat.i(16445);
    ab.w("MicroMsg.GetChatroomMsgFetcher", "[onFinish] ret:" + paramInt + " addSize:" + paramList.size());
    AppMethodBeat.o(16445);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.aq.b.2
 * JD-Core Version:    0.7.0.1
 */