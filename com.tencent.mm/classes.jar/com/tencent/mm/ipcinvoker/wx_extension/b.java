package com.tencent.mm.ipcinvoker.wx_extension;

import com.tencent.mm.ah.m;
import com.tencent.mm.ah.w;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.wx_extension.service.IPCRunCgiRespWrapper;
import com.tencent.mm.sdk.platformtools.ae;

public final class b
{
  public static void a(com.tencent.mm.ah.b paramb, b.a parama)
  {
    if (ae.cqV())
    {
      w.a(paramb, new w.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ah.b paramAnonymousb, m paramAnonymousm)
        {
          if (this.dHp != null) {
            this.dHp.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, paramAnonymousb);
          }
          return 0;
        }
      }, true);
      return;
    }
    XIPCInvoker.a("com.tencent.mm", paramb, b.b.class, new c() {});
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.wx_extension.b
 * JD-Core Version:    0.7.0.1
 */