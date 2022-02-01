package com.tencent.mm.modelgetchatroommsg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.cc;
import java.util.List;

final class b$1
  implements b.b
{
  b$1(b paramb) {}
  
  public final void q(int paramInt, List<cc> paramList)
  {
    AppMethodBeat.i(231769);
    Log.w("MicroMsg.GetChatroomMsgFetcher", "[onFinish] ret:" + paramInt + " addSize:" + paramList.size());
    AppMethodBeat.o(231769);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelgetchatroommsg.b.1
 * JD-Core Version:    0.7.0.1
 */