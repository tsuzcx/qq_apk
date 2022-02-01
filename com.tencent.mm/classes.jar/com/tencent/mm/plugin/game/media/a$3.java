package com.tencent.mm.plugin.game.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.game.b.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

final class a$3
  implements IPCRunCgi.a
{
  a$3(a parama, int paramInt, IPCString paramIPCString) {}
  
  public final void a(int paramInt1, int paramInt2, String arg3, d paramd)
  {
    AppMethodBeat.i(40909);
    Log.i("MicroMsg.GameHaowanDataCenter", "checkNewVideo errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ??? = (b)paramd.iLL.iLR;
      paramd = Util.nullAsNil(???.desc);
      if (!paramd.contains("[count]")) {
        break label131;
      }
      paramInt1 = this.xAi;
      paramInt1 = ???.pRQ + paramInt1;
      if (paramInt1 > 0) {
        this.xAj.value = paramd.replace("[count]", String.valueOf(paramInt1));
      }
    }
    synchronized (a.j(this.xAh))
    {
      a.j(this.xAh).notifyAll();
      AppMethodBeat.o(40909);
      return;
      label131:
      this.xAj.value = paramd;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.a.3
 * JD-Core Version:    0.7.0.1
 */