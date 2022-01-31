package com.tencent.mm.ipcinvoker.wx_extension;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w.a;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.wx_extension.service.IPCRunCgiRespWrapper;

final class b$b$1
  implements w.a
{
  b$b$1(b.b paramb, c paramc) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    AppMethodBeat.i(126198);
    if (this.eEg != null)
    {
      paramm = new IPCRunCgiRespWrapper();
      paramm.errType = paramInt1;
      paramm.errCode = paramInt2;
      paramm.errMsg = paramString;
      paramm.rr = paramb;
      this.eEg.ad(paramm);
    }
    AppMethodBeat.o(126198);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.wx_extension.b.b.1
 * JD-Core Version:    0.7.0.1
 */