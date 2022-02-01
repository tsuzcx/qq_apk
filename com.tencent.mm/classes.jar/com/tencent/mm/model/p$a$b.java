package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errType", "errCode", "<anonymous parameter 2>", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "<anonymous parameter 4>", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
public final class p$a$b
  implements aa.a
{
  public static final b iCe;
  
  static
  {
    AppMethodBeat.i(212384);
    iCe = new b();
    AppMethodBeat.o(212384);
  }
  
  public final int a(int paramInt1, int paramInt2, String paramString, d paramd, q paramq)
  {
    AppMethodBeat.i(212383);
    p.h(paramd, "rr");
    p.h(paramq, "<anonymous parameter 4>");
    Log.i("Micromsg.BizTLRecFeedsDataUtil", "recommendCardFeedback callback " + paramInt1 + ", " + paramInt2);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(212383);
      return 0;
    }
    AppMethodBeat.o(212383);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.p.a.b
 * JD-Core Version:    0.7.0.1
 */