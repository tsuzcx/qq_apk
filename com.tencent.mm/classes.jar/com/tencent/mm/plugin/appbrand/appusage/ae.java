package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.am.c;
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.cxg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appusage/FetchStarListLogic;", "", "()V", "Companion", "IFetchStartListCallback", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ae
{
  private static final long qPB;
  public static final a qPW;
  
  static
  {
    AppMethodBeat.i(50295);
    qPW = new a((byte)0);
    qPB = TimeUnit.DAYS.toSeconds(1L);
    AppMethodBeat.o(50295);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appusage/FetchStarListLogic$Companion;", "", "()V", "FETCH_FREQUENCY", "", "TAG", "", "fetchListFromServer", "", "reason", "", "prescene", "callback", "Lcom/tencent/mm/plugin/appbrand/appusage/FetchStarListLogic$IFetchStartListCallback;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private static final b.a a(ae.b paramb, int paramInt, long paramLong, b.a parama)
    {
      c localc = null;
      AppMethodBeat.i(319315);
      if (paramb != null) {
        paramb.b(parama);
      }
      if (parama == null)
      {
        AppMethodBeat.o(319315);
        return null;
      }
      int i = parama.errType;
      int j = parama.errCode;
      String str = parama.errMsg;
      paramb = parama.hEi;
      if (paramb == null) {}
      for (paramb = null;; paramb = paramb.getReqResp())
      {
        if ((paramb instanceof c)) {
          localc = (c)paramb;
        }
        u.a(paramInt, i, j, str, localc, Long.valueOf(paramLong));
        AppMethodBeat.o(319315);
        return parama;
      }
    }
    
    private static void a(int paramInt1, int paramInt2, ae.b paramb)
    {
      AppMethodBeat.i(50293);
      int i;
      if ((paramInt1 == 2) || (paramInt1 == 7) || (paramInt1 == 8))
      {
        i = 1;
        if (i == 0) {
          break label159;
        }
        try
        {
          Object localObject = h.baE().ban().get(at.a.acNi, Long.valueOf(0L));
          if (localObject == null)
          {
            localObject = new NullPointerException("null cannot be cast to non-null type kotlin.Long");
            AppMethodBeat.o(50293);
            throw ((Throwable)localObject);
          }
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.AppBrandCollectionModifyQueue[collection].FetchStarListLogic", s.X("fetchListFromServer checkFrequency by configStg fail, e=", localException));
          l = 0L;
        }
      }
      for (;;)
      {
        if (l <= Util.nowSecond()) {
          break label137;
        }
        Log.d("MicroMsg.AppBrandCollectionModifyQueue[collection].FetchStarListLogic", "daily fetch blocked by frequency");
        if (paramb != null) {
          paramb.ciy();
        }
        AppMethodBeat.o(50293);
        return;
        i = 0;
        break;
        l = ((Long)localException).longValue();
      }
      label137:
      h.baE().ban().set(at.a.acNi, Long.valueOf(Util.nowSecond() + ae.cjl()));
      label159:
      Log.i("MicroMsg.AppBrandCollectionModifyQueue[collection].FetchStarListLogic", "fetchList reason=" + paramInt1 + ", prescene=" + paramInt2);
      long l = Util.nowMilliSecond();
      new y(paramInt1, paramInt2, 2, 2147483647, 0).bFJ().j(new ae.a..ExternalSyntheticLambda0(paramb, paramInt1, l));
      AppMethodBeat.o(50293);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appusage/FetchStarListLogic$IFetchStartListCallback;", "", "onCgiBack", "", "back", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetWxaUsageRecordResponse;", "onHitFrequencyLimit", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void b(b.a<cxg> parama);
    
    public abstract void ciy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.ae
 * JD-Core Version:    0.7.0.1
 */