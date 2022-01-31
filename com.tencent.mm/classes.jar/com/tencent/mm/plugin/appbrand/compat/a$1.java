package com.tencent.mm.plugin.appbrand.compat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w.a;
import com.tencent.mm.plugin.appbrand.compat.a.a.a;
import com.tencent.mm.protocal.protobuf.asl;

final class a$1
  implements w.a
{
  a$1(a parama, a.a parama1) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    boolean bool2 = true;
    AppMethodBeat.i(17015);
    if (paramm.getType() != 1926)
    {
      AppMethodBeat.o(17015);
      return 0;
    }
    boolean bool1;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (asl)paramb.fsW.fta;
      if ((paramString != null) && (paramString.xhD)) {
        bool1 = true;
      }
    }
    for (;;)
    {
      if (this.hgJ != null) {
        this.hgJ.q(bool2, bool1);
      }
      AppMethodBeat.o(17015);
      return 0;
      bool1 = false;
      continue;
      bool1 = false;
      bool2 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.compat.a.1
 * JD-Core Version:    0.7.0.1
 */