package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a.a;
import com.tencent.mm.cm.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.bmu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.vending.c.a;
import d.g.b.p;
import d.l;
import d.v;
import java.util.concurrent.TimeUnit;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/appusage/FetchStarListLogic;", "", "()V", "Companion", "IFetchStartListCallback", "plugin-appbrand-integration_release"})
public final class ag
{
  private static final long jSN;
  public static final a jTj;
  
  static
  {
    AppMethodBeat.i(50295);
    jTj = new a((byte)0);
    jSN = TimeUnit.DAYS.toSeconds(1L);
    AppMethodBeat.o(50295);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/appusage/FetchStarListLogic$Companion;", "", "()V", "FETCH_FREQUENCY", "", "TAG", "", "fetchListFromServer", "", "reason", "", "prescene", "callback", "Lcom/tencent/mm/plugin/appbrand/appusage/FetchStarListLogic$IFetchStartListCallback;", "plugin-appbrand-integration_release"})
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
          Object localObject = g.ajR();
          p.g(localObject, "MMKernel.storage()");
          localObject = ((e)localObject).ajA().get(am.a.IPM, Long.valueOf(0L));
          if (localObject == null)
          {
            localObject = new v("null cannot be cast to non-null type kotlin.Long");
            AppMethodBeat.o(50293);
            throw ((Throwable)localObject);
          }
        }
        catch (Exception localException)
        {
          ae.e("MicroMsg.AppBrandCollectionModifyQueue[collection].FetchStarListLogic", "fetchListFromServer checkFrequency by configStg fail, e=".concat(String.valueOf(localException)));
          l = 0L;
        }
      }
      for (;;)
      {
        if (l > bu.aRi())
        {
          ae.d("MicroMsg.AppBrandCollectionModifyQueue[collection].FetchStarListLogic", "daily fetch blocked by frequency");
          if (paramb != null)
          {
            paramb.bcp();
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
      e locale = g.ajR();
      p.g(locale, "MMKernel.storage()");
      locale.ajA().set(am.a.IPM, Long.valueOf(bu.aRi() + ag.bdf()));
      label190:
      ae.i("MicroMsg.AppBrandCollectionModifyQueue[collection].FetchStarListLogic", "fetchList reason=" + paramInt1 + ", prescene=" + paramInt2);
      final long l = bu.fpO();
      new aa(paramInt1, paramInt2, 2, 2147483647, 0).aET().j((a)new a(paramb, paramInt1, l));
      AppMethodBeat.o(50293);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetWxaUsageRecordResponse;", "kotlin.jvm.PlatformType", "back", "call"})
    static final class a<_Ret, _Var>
      implements a<_Ret, _Var>
    {
      a(ag.b paramb, int paramInt, long paramLong) {}
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/appusage/FetchStarListLogic$IFetchStartListCallback;", "", "onCgiBack", "", "back", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetWxaUsageRecordResponse;", "onHitFrequencyLimit", "plugin-appbrand-integration_release"})
  public static abstract interface b
  {
    public abstract void bcp();
    
    public abstract void c(a.a<bmu> parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.ag
 * JD-Core Version:    0.7.0.1
 */