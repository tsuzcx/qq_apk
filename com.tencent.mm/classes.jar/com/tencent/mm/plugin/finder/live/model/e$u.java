package com.tencent.mm.plugin.finder.live.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import com.tencent.mm.plugin.finder.live.model.cgi.ai.a;
import com.tencent.mm.plugin.finder.live.plugin.be.a;
import com.tencent.mm.plugin.finder.live.plugin.be.a.a;
import com.tencent.mm.plugin.finder.live.plugin.be.a.b;
import com.tencent.mm.plugin.finder.utils.ar;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bce;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$doPostGift$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveReward$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRewardResponse;", "plugin-finder_release"})
public final class e$u
  implements ai.a
{
  e$u(int paramInt1, be.a parama, String paramString1, Context paramContext, String paramString2, int paramInt2, String paramString3) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, bce parambce)
  {
    AppMethodBeat.i(266973);
    p.k(parambce, "resp");
    Log.i(this.ydI.TAG, "doPostGift errType:" + paramInt1 + ", errCode:" + paramInt2 + ",errMsg:" + paramString);
    Object localObject = ar.AIS;
    ar.Rq(this.ydV);
    if ((paramInt2 != 0) && (paramInt2 != -200042))
    {
      parambce = this.ydW;
      if (parambce != null) {
        be.a.a.a(parambce, false, paramInt2, be.a.b.ysy, null, null, 0, null, paramString, 16);
      }
      h.IzE.a(22129, new Object[] { Integer.valueOf(1), this.ydX, "", Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(paramInt2), paramString });
      paramString = ar.AIS;
      ar.egg();
      AppMethodBeat.o(266973);
      return;
    }
    localObject = this.ydI;
    Context localContext = this.$context;
    String str = this.ydX;
    paramString = parambce.SNH;
    if (paramString != null) {}
    for (paramString = paramString.toByteArray();; paramString = null)
    {
      e.a((e)localObject, localContext, str, paramString, (com.tencent.mm.plugin.wallet.wecoin.a.e)new a(this));
      AppMethodBeat.o(266973);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$doPostGift$1$onCgiBack$1", "Lcom/tencent/mm/plugin/wallet/wecoin/api/WeCoinCommonCallback;", "", "onFailed", "", "errorType", "", "errorCode", "msg", "", "onSuccess", "data", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.plugin.wallet.wecoin.a.e<Long>
  {
    public final void p(int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(278901);
      Log.i(this.yeb.ydI.TAG, "[WeCoin] consumeGift onFailed errorType:" + paramInt1 + ",errorCode:" + paramInt2 + ",msg:" + paramString);
      paramString = this.yeb.ydW;
      if (paramString != null) {
        be.a.a.a(paramString, false, paramInt2, be.a.b.ysz, this.yeb.ydY, null, this.yeb.ydZ, this.yeb.yea, null, 144);
      }
      paramString = ar.AIS;
      ar.egh();
      AppMethodBeat.o(278901);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.e.u
 * JD-Core Version:    0.7.0.1
 */