package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.chf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vending.c.a;
import java.util.concurrent.TimeUnit;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appusage/FetchStarListLogic;", "", "()V", "Companion", "IFetchStartListCallback", "plugin-appbrand-integration_release"})
public final class af
{
  private static final long nPK;
  public static final a nQe;
  
  static
  {
    AppMethodBeat.i(50295);
    nQe = new a((byte)0);
    nPK = TimeUnit.DAYS.toSeconds(1L);
    AppMethodBeat.o(50295);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appusage/FetchStarListLogic$Companion;", "", "()V", "FETCH_FREQUENCY", "", "TAG", "", "fetchListFromServer", "", "reason", "", "prescene", "callback", "Lcom/tencent/mm/plugin/appbrand/appusage/FetchStarListLogic$IFetchStartListCallback;", "plugin-appbrand-integration_release"})
  public static final class a
  {
    private static void a(final int paramInt1, int paramInt2, af.b paramb)
    {
      AppMethodBeat.i(50293);
      int i;
      if ((paramInt1 == 2) || (paramInt1 == 7) || (paramInt1 == 8))
      {
        i = 1;
        if (i == 0) {
          break label190;
        }
        try
        {
          Object localObject = h.aHG();
          p.j(localObject, "MMKernel.storage()");
          localObject = ((com.tencent.mm.kernel.f)localObject).aHp().get(ar.a.VlN, Long.valueOf(0L));
          if (localObject == null)
          {
            localObject = new t("null cannot be cast to non-null type kotlin.Long");
            AppMethodBeat.o(50293);
            throw ((Throwable)localObject);
          }
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.AppBrandCollectionModifyQueue[collection].FetchStarListLogic", "fetchListFromServer checkFrequency by configStg fail, e=".concat(String.valueOf(localException)));
          l = 0L;
        }
      }
      for (;;)
      {
        if (l > Util.nowSecond())
        {
          Log.d("MicroMsg.AppBrandCollectionModifyQueue[collection].FetchStarListLogic", "daily fetch blocked by frequency");
          if (paramb != null)
          {
            paramb.bIU();
            AppMethodBeat.o(50293);
            return;
            i = 0;
            break;
            l = ((Long)localException).longValue();
            continue;
          }
          AppMethodBeat.o(50293);
          return;
        }
      }
      com.tencent.mm.kernel.f localf = h.aHG();
      p.j(localf, "MMKernel.storage()");
      localf.aHp().set(ar.a.VlN, Long.valueOf(Util.nowSecond() + af.bJI()));
      label190:
      Log.i("MicroMsg.AppBrandCollectionModifyQueue[collection].FetchStarListLogic", "fetchList reason=" + paramInt1 + ", prescene=" + paramInt2);
      final long l = Util.nowMilliSecond();
      new z(paramInt1, paramInt2, 2, 2147483647, 0).bhW().j((a)new a(paramb, paramInt1, l));
      AppMethodBeat.o(50293);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetWxaUsageRecordResponse;", "kotlin.jvm.PlatformType", "back", "call"})
    static final class a<_Ret, _Var>
      implements a<_Ret, _Var>
    {
      a(af.b paramb, int paramInt, long paramLong) {}
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appusage/FetchStarListLogic$IFetchStartListCallback;", "", "onCgiBack", "", "back", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetWxaUsageRecordResponse;", "onHitFrequencyLimit", "plugin-appbrand-integration_release"})
  public static abstract interface b
  {
    public abstract void b(c.a<chf> parama);
    
    public abstract void bIU();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.af
 * JD-Core Version:    0.7.0.1
 */