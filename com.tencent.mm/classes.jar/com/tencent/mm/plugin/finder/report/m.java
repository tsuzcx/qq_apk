package com.tencent.mm.plugin.finder.report;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.qs;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/report/FinderReport21874;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "setContext", "pageInTimeStampMs", "", "actionPageIn", "", "commentScene", "", "clickTabContextId", "", "udfKv", "actionPageOut", "report", "eventCode", "stayTime", "Companion", "plugin-finder_release"})
public final class m
{
  public static final a zWz;
  private Context context;
  private long zWy;
  
  static
  {
    AppMethodBeat.i(287039);
    zWz = new a((byte)0);
    AppMethodBeat.o(287039);
  }
  
  public m(Context paramContext)
  {
    AppMethodBeat.i(287038);
    this.context = paramContext;
    AppMethodBeat.o(287038);
  }
  
  private void a(int paramInt1, int paramInt2, long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(287037);
    p.k(paramString1, "clickTabContextId");
    qs localqs = new qs();
    localqs.HC(((c)h.ae(c.class)).dbr());
    localqs.HE(String.valueOf(paramInt1));
    localqs.pk(paramInt2);
    localqs.HF(String.valueOf(System.currentTimeMillis()));
    localqs.HG(z.bdh());
    localqs.Es(paramLong);
    localqs.HI(paramString1);
    localqs.HH(paramString2);
    paramString1 = aj.Bnu;
    paramString1 = aj.a.fZ(this.context);
    if (paramString1 != null)
    {
      paramString1 = paramString1.ekY();
      if (paramString1 != null) {
        localqs.HD(paramString1.wmL);
      }
    }
    localqs.bpa();
    Log.i("Finder.Report21874", String.valueOf(localqs.agI()));
    AppMethodBeat.o(287037);
  }
  
  public final void A(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(287033);
    p.k(paramString1, "clickTabContextId");
    this.zWy = cm.bfE();
    a(paramInt, 0, 0L, paramString1, paramString2);
    AppMethodBeat.o(287033);
  }
  
  public final void B(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(287035);
    p.k(paramString1, "clickTabContextId");
    if (this.zWy <= 0L)
    {
      AppMethodBeat.o(287035);
      return;
    }
    a(paramInt, 1, cm.bfE() - this.zWy, paramString1, paramString2);
    this.zWy = 0L;
    AppMethodBeat.o(287035);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/report/FinderReport21874$Companion;", "", "()V", "FinderBackStep", "", "FinderDefaultStep", "FinderNextStep", "FinderPageIn", "FinderPageOut", "TAG", "", "FinderActionCode", "FinderEventCode", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.m
 * JD-Core Version:    0.7.0.1
 */