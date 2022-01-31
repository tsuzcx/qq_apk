package com.tencent.mm.ipcinvoker.wx_extension;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.wx_extension.service.IPCRunCgiRespWrapper;

final class b$b$1
  implements w.a
{
  b$b$1(b.b paramb, c paramc) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    if (this.dGE != null)
    {
      paramm = new IPCRunCgiRespWrapper();
      paramm.errType = paramInt1;
      paramm.errCode = paramInt2;
      paramm.aox = paramString;
      paramm.dmK = paramb;
      this.dGE.U(paramm);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.wx_extension.b.b.1
 * JD-Core Version:    0.7.0.1
 */