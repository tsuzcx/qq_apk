package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.c.a;
import com.tencent.mm.co.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.bec;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.vending.c.a;
import d.g.b.k;
import d.l;
import d.v;
import java.util.concurrent.TimeUnit;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/appusage/FetchStarListLogic;", "", "()V", "Companion", "IFetchStartListCallback", "plugin-appbrand-integration_release"})
public final class ag
{
  public static final a iVH;
  private static final long iVl;
  
  static
  {
    AppMethodBeat.i(50295);
    iVH = new a((byte)0);
    iVl = TimeUnit.DAYS.toSeconds(1L);
    AppMethodBeat.o(50295);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/appusage/FetchStarListLogic$Companion;", "", "()V", "FETCH_FREQUENCY", "", "TAG", "", "fetchListFromServer", "", "reason", "", "prescene", "callback", "Lcom/tencent/mm/plugin/appbrand/appusage/FetchStarListLogic$IFetchStartListCallback;", "plugin-appbrand-integration_release"})
  public static final class a
  {
    private static void a(final int paramInt1, int paramInt2, ag.b paramb)
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
          Object localObject = g.afB();
          k.g(localObject, "MMKernel.storage()");
          localObject = ((e)localObject).afk().get(ae.a.Flh, Long.valueOf(0L));
          if (localObject == null)
          {
            localObject = new v("null cannot be cast to non-null type kotlin.Long");
            AppMethodBeat.o(50293);
            throw ((Throwable)localObject);
          }
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.AppBrandCollectionModifyQueue[collection].FetchStarListLogic", "fetchListFromServer checkFrequency by configStg fail, e=".concat(String.valueOf(localException)));
          l = 0L;
        }
      }
      for (;;)
      {
        if (l > bt.aGK())
        {
          ad.d("MicroMsg.AppBrandCollectionModifyQueue[collection].FetchStarListLogic", "daily fetch blocked by frequency");
          if (paramb != null)
          {
            paramb.aRs();
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
      e locale = g.afB();
      k.g(locale, "MMKernel.storage()");
      locale.afk().set(ae.a.Flh, Long.valueOf(bt.aGK() + ag.aSf()));
      label190:
      ad.i("MicroMsg.AppBrandCollectionModifyQueue[collection].FetchStarListLogic", "fetchList reason=" + paramInt1 + ", prescene=" + paramInt2);
      final long l = bt.eGO();
      new aa(paramInt1, paramInt2, 2, 2147483647, 0).auK().j((a)new a(paramb, paramInt1, l));
      AppMethodBeat.o(50293);
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetWxaUsageRecordResponse;", "kotlin.jvm.PlatformType", "back", "call"})
    static final class a<_Ret, _Var>
      implements a<_Ret, _Var>
    {
      a(ag.b paramb, int paramInt, long paramLong) {}
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/appusage/FetchStarListLogic$IFetchStartListCallback;", "", "onCgiBack", "", "back", "Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetWxaUsageRecordResponse;", "onHitFrequencyLimit", "plugin-appbrand-integration_release"})
  public static abstract interface b
  {
    public abstract void aRs();
    
    public abstract void c(c.a<bec> parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.ag
 * JD-Core Version:    0.7.0.1
 */