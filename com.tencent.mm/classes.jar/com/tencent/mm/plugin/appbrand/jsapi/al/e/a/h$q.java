package com.tencent.mm.plugin.appbrand.jsapi.al.e.a;

import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
final class h$q
  extends u
  implements a<ah>
{
  h$q(h paramh)
  {
    super(0);
  }
  
  private static final void t(h paramh)
  {
    Object localObject = null;
    AppMethodBeat.i(327252);
    s.u(paramh, "this$0");
    g localg = h.i(paramh);
    paramh = localg;
    if (localg == null)
    {
      s.bIx("selectDeviceBottomSheet");
      paramh = null;
    }
    if ((paramh.isShowing()) && (paramh.sRs != null))
    {
      paramh = paramh.sRt;
      if (paramh != null) {
        break label74;
      }
      s.bIx("recycleViewAdapter");
      paramh = localObject;
    }
    label74:
    for (;;)
    {
      paramh.bZE.notifyChanged();
      AppMethodBeat.o(327252);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.al.e.a.h.q
 * JD-Core Version:    0.7.0.1
 */