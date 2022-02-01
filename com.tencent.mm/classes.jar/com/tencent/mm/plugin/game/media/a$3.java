package com.tencent.mm.plugin.game.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

final class a$3
  implements IPCRunCgi.a
{
  a$3(a parama, int paramInt, IPCString paramIPCString) {}
  
  public final void a(int paramInt1, int paramInt2, String arg3, com.tencent.mm.ak.b paramb)
  {
    AppMethodBeat.i(40909);
    ae.i("MicroMsg.GameHaowanDataCenter", "checkNewVideo errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ??? = (com.tencent.mm.plugin.game.b.b.b)paramb.hQE.hQJ;
      paramb = bu.nullAsNil(???.desc);
      if (!paramb.contains("[count]")) {
        break label131;
      }
      paramInt1 = this.uhO;
      paramInt1 = ???.oEh + paramInt1;
      if (paramInt1 > 0) {
        this.uhP.value = paramb.replace("[count]", String.valueOf(paramInt1));
      }
    }
    synchronized (a.j(this.uhN))
    {
      a.j(this.uhN).notifyAll();
      AppMethodBeat.o(40909);
      return;
      label131:
      this.uhP.value = paramb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.a.3
 * JD-Core Version:    0.7.0.1
 */