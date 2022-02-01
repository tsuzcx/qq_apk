package com.tencent.mm.ipcinvoker.wx_extension;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x.a;

final class IPCRunCgi$2
  implements x.a
{
  IPCRunCgi$2(IPCRunCgi.a parama) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, n paramn)
  {
    AppMethodBeat.i(187202);
    if (this.fZU != null) {
      this.fZU.a(paramInt1, paramInt2, paramString, paramb);
    }
    AppMethodBeat.o(187202);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.2
 * JD-Core Version:    0.7.0.1
 */