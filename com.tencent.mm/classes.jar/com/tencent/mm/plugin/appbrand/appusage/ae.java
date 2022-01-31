package com.tencent.mm.plugin.appbrand.appusage;

import a.f.b.j;
import a.l;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.vending.c.a;
import java.util.concurrent.TimeUnit;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/appusage/FetchStarListLogic;", "", "()V", "Companion", "plugin-appbrand-integration_release"})
public final class ae
{
  public static final a hcG;
  private static final long hcj;
  
  static
  {
    AppMethodBeat.i(134558);
    hcG = new a((byte)0);
    hcj = TimeUnit.DAYS.toSeconds(1L);
    AppMethodBeat.o(134558);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/appusage/FetchStarListLogic$Companion;", "", "()V", "FETCH_FREQUENCY", "", "TAG", "", "fetchListFromServer", "", "reason", "", "prescene", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public static void cU(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(134556);
      int i;
      if ((paramInt1 == 2) || (paramInt1 == 7) || (paramInt1 == 8))
      {
        i = 1;
        if (i == 0) {
          break label156;
        }
        try
        {
          Object localObject = g.RL();
          j.p(localObject, "MMKernel.storage()");
          localObject = ((e)localObject).Ru().get(ac.a.yCL, Long.valueOf(0L));
          if (localObject == null)
          {
            localObject = new v("null cannot be cast to non-null type kotlin.Long");
            AppMethodBeat.o(134556);
            throw ((Throwable)localObject);
          }
        }
        catch (Exception localException)
        {
          l = 0L;
        }
      }
      for (;;)
      {
        if (l <= bo.aox()) {
          break label123;
        }
        ab.d("MicroMsg.AppBrandCollectionModifyQueue[collection].FetchStarListLogic", "daily fetch blocked by frequency");
        AppMethodBeat.o(134556);
        return;
        i = 0;
        break;
        l = ((Long)localException).longValue();
      }
      label123:
      e locale = g.RL();
      j.p(locale, "MMKernel.storage()");
      locale.Ru().set(ac.a.yCL, Long.valueOf(bo.aox() + ae.axF()));
      label156:
      ab.i("MicroMsg.AppBrandCollectionModifyQueue[collection].FetchStarListLogic", "fetchList reason=" + paramInt1 + ", prescene=" + paramInt2);
      long l = bo.aoy();
      new y(paramInt1, paramInt2, 2, 2147483647, 0).adl().j((a)new ae.a.a(paramInt1, l));
      AppMethodBeat.o(134556);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.ae
 * JD-Core Version:    0.7.0.1
 */