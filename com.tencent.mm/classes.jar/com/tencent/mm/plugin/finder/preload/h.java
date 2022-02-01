package com.tencent.mm.plugin.finder.preload;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.findersdk.storage.config.base.b;
import com.tencent.mm.protocal.protobuf.bua;
import com.tencent.mm.protocal.protobuf.bub;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/preload/PreloadGlobalInfoFetcher;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "()V", "isRequesting", "Ljava/util/concurrent/atomic/AtomicBoolean;", "lastGlobalPreloadTimeStampMs", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "detach", "", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "callback", "fetch", "getType", "onGYNetEnd", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "onSceneEnd", "scene", "updateLastGlobalPreloadTimeStamp", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends p
  implements com.tencent.mm.am.h, m
{
  public static final a EUX;
  private static int EVa;
  public long EUY;
  private AtomicBoolean EUZ;
  private c rr;
  
  static
  {
    AppMethodBeat.i(346253);
    EUX = new a((byte)0);
    EVa = 180000;
    AppMethodBeat.o(346253);
  }
  
  public h()
  {
    AppMethodBeat.i(346244);
    this.EUY = SystemClock.uptimeMillis();
    this.EUZ = new AtomicBoolean(false);
    AppMethodBeat.o(346244);
  }
  
  public final void aXc()
  {
    AppMethodBeat.i(346263);
    Object localObject1 = d.FAy;
    if (((Number)d.eYw().bmg()).intValue() == 0)
    {
      Log.w("PreloadGlobalInfoFetcher", "fetch return for disable");
      AppMethodBeat.o(346263);
      return;
    }
    long l = SystemClock.uptimeMillis() - this.EUY;
    if (l < EVa)
    {
      Log.w("PreloadGlobalInfoFetcher", "fetch return for invalid interval:" + l + " < " + EVa);
      AppMethodBeat.o(346263);
      return;
    }
    if (this.EUZ.get())
    {
      Log.w("PreloadGlobalInfoFetcher", "fetch return for isRequesting");
      AppMethodBeat.o(346263);
      return;
    }
    Log.i("PreloadGlobalInfoFetcher", "fetch start");
    localObject1 = new c.a();
    bua localbua = new bua();
    Object localObject2 = bi.ABn;
    localbua.aabS = bi.dVu();
    localObject2 = bi.ABn;
    localbua.ZDQ = bi.bTZ();
    localObject2 = ah.aiuX;
    ((c.a)localObject1).otE = ((com.tencent.mm.bx.a)localbua);
    ((c.a)localObject1).otF = ((com.tencent.mm.bx.a)new bub());
    ((c.a)localObject1).uri = "/cgi-bin/micromsg-bin/finderrefreshpreloadinfo";
    ((c.a)localObject1).funcId = 389;
    this.rr = ((c.a)localObject1).bEF();
    com.tencent.mm.kernel.h.aZW().a(389, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.aZW().a((p)this, 0);
    this.EUZ.set(true);
    AppMethodBeat.o(346263);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(346279);
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (m)this);
    AppMethodBeat.o(346279);
    return i;
  }
  
  public final int getType()
  {
    return 389;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(346283);
    setHasCallbackToQueue(true);
    onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    AppMethodBeat.o(346283);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(346269);
    this.EUZ.set(false);
    com.tencent.mm.kernel.h.aZW().b(389, (com.tencent.mm.am.h)this);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = this.rr;
      kotlin.g.b.s.checkNotNull(paramString);
      paramString = c.c.b(paramString.otC);
      if (paramString == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderRefreshPreloadInfoResponse");
        AppMethodBeat.o(346269);
        throw paramString;
      }
      paramString = (bub)paramString;
      if (paramString.aabT > 0) {
        EVa = paramString.aabT * 1000;
      }
      Log.i("PreloadGlobalInfoFetcher", kotlin.g.b.s.X("onSceneEnd min_refresh_interval:", Integer.valueOf(paramString.aabT)));
      paramp = a.EUs;
      a.a(paramString.ZDZ, (List)new LinkedList(), 389);
      AppMethodBeat.o(346269);
      return;
    }
    Log.e("PreloadGlobalInfoFetcher", "onSceneEnd handle MMFinderFunc_FinderRefreshPreloadInfo error");
    AppMethodBeat.o(346269);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/preload/PreloadGlobalInfoFetcher$Companion;", "", "()V", "TAG", "", "updatePreloadInfoIntervalMs", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.h
 * JD-Core Version:    0.7.0.1
 */