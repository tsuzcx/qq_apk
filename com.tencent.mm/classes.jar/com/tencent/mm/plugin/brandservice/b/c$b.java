package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.a.b.b;
import com.tencent.mm.protocal.protobuf.bak;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "comReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
final class c$b
  implements x.a
{
  c$b(b.b paramb) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.b paramb, n paramn)
  {
    AppMethodBeat.i(175464);
    ac.i("MicroMsg.BizVideoChannelStrategy", "alvinluo getNotifyAndChannelFeeds callback errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      k.g(paramb, "comReqResp");
      paramString = paramb.aBD();
      if (paramString != null)
      {
        if (paramString == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetNotifyAndChannelFeedsResp");
          AppMethodBeat.o(175464);
          throw paramString;
        }
        paramString = ((bak)paramString).ERp;
        if (paramString != null) {
          break label174;
        }
        paramString = "";
      }
    }
    label174:
    for (;;)
    {
      ac.d("MicroMsg.BizVideoChannelStrategy", "alvinuo getNotifyAndChannelFeeds channelFeeds: %s", new Object[] { paramString });
      ((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).Tl(paramString);
      paramb = this.nvd;
      if (paramb != null) {
        paramb.onSuccess(paramString);
      }
      for (;;)
      {
        AppMethodBeat.o(175464);
        return 0;
        paramb = this.nvd;
        if (paramb != null) {
          paramb.p(paramInt1, paramInt2, paramString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.c.b
 * JD-Core Version:    0.7.0.1
 */