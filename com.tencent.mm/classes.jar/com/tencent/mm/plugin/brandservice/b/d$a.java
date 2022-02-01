package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.a.b.b;
import com.tencent.mm.protocal.protobuf.aws;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "comReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
final class d$a
  implements x.a
{
  d$a(b.b paramb) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.b paramb, n paramn)
  {
    AppMethodBeat.i(175464);
    ad.i("MicroMsg.BizVideoChannelStrategy", "alvinluo getNotifyAndChannelFeeds callback errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      k.g(paramb, "comReqResp");
      paramString = paramb.auM();
      if (paramString != null)
      {
        if (paramString == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetNotifyAndChannelFeedsResp");
          AppMethodBeat.o(175464);
          throw paramString;
        }
        paramString = ((aws)paramString).DvU;
        if (paramString != null) {
          break label174;
        }
        paramString = "";
      }
    }
    label174:
    for (;;)
    {
      ad.d("MicroMsg.BizVideoChannelStrategy", "alvinuo getNotifyAndChannelFeeds channelFeeds: %s", new Object[] { paramString });
      ((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).Pb(paramString);
      paramb = this.mSN;
      if (paramb != null) {
        paramb.onSuccess(paramString);
      }
      for (;;)
      {
        AppMethodBeat.o(175464);
        return 0;
        paramb = this.mSN;
        if (paramb != null) {
          paramb.p(paramInt1, paramInt2, paramString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.d.a
 * JD-Core Version:    0.7.0.1
 */