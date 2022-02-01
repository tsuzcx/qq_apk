package com.tencent.mm.as;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import java.util.List;

final class b$1
  implements b.b
{
  b$1(b paramb) {}
  
  public final void b(int paramInt, List<ca> paramList)
  {
    AppMethodBeat.i(231540);
    Log.w("MicroMsg.GetChatroomMsgFetcher", "[onFinish] ret:" + paramInt + " addSize:" + paramList.size());
    AppMethodBeat.o(231540);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.as.b.1
 * JD-Core Version:    0.7.0.1
 */