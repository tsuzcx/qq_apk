package com.tencent.mm.model.gdpr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.protocal.protobuf.akt;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.protocal.protobuf.dag;
import com.tencent.mm.sdk.platformtools.ab;

final class c$2$1
  implements b.a
{
  c$2$1(c.2 param2, com.tencent.mm.vending.g.b paramb) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.b paramb)
  {
    AppMethodBeat.i(1490);
    bvk localbvk = (bvk)paramb.fsW.fta;
    int i;
    if ((paramInt1 == 0) && (paramInt2 == 0) && (localbvk != null)) {
      i = 1;
    }
    while (i != 0)
    {
      paramString = (akt)paramb.fsW.fta;
      if (paramString.xbQ == null)
      {
        paramString.xbQ = new dag();
        paramString.xbQ.csV = -1;
      }
      ab.i("MicroMsg.MPGdprPolicyUtil", "onGetAuthCgiBack, business(%s), appId(%s), back(%d %d)", new Object[] { this.foH.foF.foB, this.foH.val$appId, Integer.valueOf(paramString.xbQ.csV), Integer.valueOf(paramString.state) });
      if (paramString.xbQ.csV != 0)
      {
        this.foH.foE.kK(0);
        this.bDR.cK(Boolean.FALSE);
        AppMethodBeat.o(1490);
        return;
        i = 0;
      }
      else
      {
        if (paramString.state <= 0)
        {
          this.bDR.C(new Object[] { Boolean.TRUE });
          AppMethodBeat.o(1490);
          return;
        }
        this.foH.foE.kK(0);
        this.bDR.cK(Boolean.FALSE);
        AppMethodBeat.o(1490);
        return;
      }
    }
    ab.e("MicroMsg.MPGdprPolicyUtil", "onGetAuthCgiBack, business(%s), appId(%s), back(%d %d %s)", new Object[] { this.foH.foF.foB, this.foH.val$appId, Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString });
    this.foH.foE.kK(0);
    this.bDR.cK(Boolean.FALSE);
    AppMethodBeat.o(1490);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.model.gdpr.c.2.1
 * JD-Core Version:    0.7.0.1
 */