package com.tencent.mm.ipcinvoker.wx_extension;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w;
import com.tencent.mm.ai.w.a;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.wx_extension.service.IPCRunCgiRespWrapper;
import com.tencent.mm.sdk.platformtools.ah;

public final class b
{
  public static void a(com.tencent.mm.ai.b paramb, b.a parama)
  {
    AppMethodBeat.i(126200);
    if (ah.brt())
    {
      w.a(paramb, new w.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ai.b paramAnonymousb, m paramAnonymousm)
        {
          AppMethodBeat.i(126196);
          if (this.eES != null) {
            this.eES.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, paramAnonymousb);
          }
          AppMethodBeat.o(126196);
          return 0;
        }
      }, true);
      AppMethodBeat.o(126200);
      return;
    }
    XIPCInvoker.a("com.tencent.mm", paramb, b.b.class, new c() {});
    AppMethodBeat.o(126200);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.wx_extension.b
 * JD-Core Version:    0.7.0.1
 */