package com.tencent.mm.modelvoiceaddr.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b
  implements f
{
  public final void a(List<String> paramList, String paramString1, String paramString2)
  {
    AppMethodBeat.i(156615);
    paramList = new ArrayList(paramList);
    g.RO().ac(new b.2(this, paramList, paramString1, paramString2));
    AppMethodBeat.o(156615);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(116800);
    g.Rc().b(228, this);
    if ((paramm instanceof a)) {
      ab.i("MicroMsg.NewVoiceInputReportManager", "onSceneEnd errType = %s, errCode = %s, errMsg = %s ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    }
    AppMethodBeat.o(116800);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.b.b
 * JD-Core Version:    0.7.0.1
 */