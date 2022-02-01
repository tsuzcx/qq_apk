package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.cn.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.bhu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.vending.c.a;
import d.g.b.k;
import d.l;
import d.v;
import java.util.concurrent.TimeUnit;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/appusage/FetchStarListLogic;", "", "()V", "Companion", "IFetchStartListCallback", "plugin-appbrand-integration_release"})
public final class ag
{
  private static final long jvB;
  public static final a jvX;
  
  static
  {
    AppMethodBeat.i(50295);
    jvX = new a((byte)0);
    jvB = TimeUnit.DAYS.toSeconds(1L);
    AppMethodBeat.o(50295);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/appusage/FetchStarListLogic$Companion;", "", "()V", "FETCH_FREQUENCY", "", "TAG", "", "fetchListFromServer", "", "reason", "", "prescene", "callback", "Lcom/tencent/mm/plugin/appbrand/appusage/FetchStarListLogic$IFetchStartListCallback;", "plugin-appbrand-integration_release"})
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
          Object localObject = g.agR();
          k.g(localObject, "MMKernel.storage()");
          localObject = ((e)localObject).agA().get(ah.a.GIW, Long.valueOf(0L));
          if (localObject == null)
          {
            localObject = new v("null cannot be cast to non-null type kotlin.Long");
            AppMethodBeat.o(50293);
            throw ((Throwable)localObject);
          }
        }
        catch (Exception localException)
        {
          ac.e("MicroMsg.AppBrandCollectionModifyQueue[collection].FetchStarListLogic", "fetchListFromServer checkFrequency by configStg fail, e=".concat(String.valueOf(localException)));
          l = 0L;
        }
      }
      for (;;)
      {
        if (l > bs.aNx())
        {
          ac.d("MicroMsg.AppBrandCollectionModifyQueue[collection].FetchStarListLogic", "daily fetch blocked by frequency");
          if (paramb != null)
          {
            paramb.aYn();
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
      e locale = g.agR();
      k.g(locale, "MMKernel.storage()");
      locale.agA().set(ah.a.GIW, Long.valueOf(bs.aNx() + ag.aZc()));
      label190:
      ac.i("MicroMsg.AppBrandCollectionModifyQueue[collection].FetchStarListLogic", "fetchList reason=" + paramInt1 + ", prescene=" + paramInt2);
      final long l = bs.eWj();
      new aa(paramInt1, paramInt2, 2, 2147483647, 0).aBB().j((a)new a(paramb, paramInt1, l));
      AppMethodBeat.o(50293);
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetWxaUsageRecordResponse;", "kotlin.jvm.PlatformType", "back", "call"})
    static final class a<_Ret, _Var>
      implements a<_Ret, _Var>
    {
      a(ag.b paramb, int paramInt, long paramLong) {}
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/appusage/FetchStarListLogic$IFetchStartListCallback;", "", "onCgiBack", "", "back", "Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetWxaUsageRecordResponse;", "onHitFrequencyLimit", "plugin-appbrand-integration_release"})
  public static abstract interface b
  {
    public abstract void aYn();
    
    public abstract void c(c.a<bhu> parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.ag
 * JD-Core Version:    0.7.0.1
 */