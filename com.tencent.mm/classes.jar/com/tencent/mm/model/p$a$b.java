package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.aa.a;
import com.tencent.mm.an.d;
import com.tencent.mm.an.q;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "errCode", "<anonymous parameter 2>", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "<anonymous parameter 4>", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
public final class p$a$b
  implements aa.a
{
  public static final b lrO;
  
  static
  {
    AppMethodBeat.i(207424);
    lrO = new b();
    AppMethodBeat.o(207424);
  }
  
  public final int a(int paramInt1, int paramInt2, String paramString, d paramd, q paramq)
  {
    AppMethodBeat.i(207423);
    p.k(paramd, "rr");
    p.k(paramq, "<anonymous parameter 4>");
    Log.i("Micromsg.BizTLRecFeedsDataUtil", "recommendCardFeedback callback " + paramInt1 + ", " + paramInt2);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(207423);
      return 0;
    }
    AppMethodBeat.o(207423);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.p.a.b
 * JD-Core Version:    0.7.0.1
 */