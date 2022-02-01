package com.tencent.mm.plugin.finder.live.model.context;

import androidx.lifecycle.ah;
import androidx.lifecycle.ah.b;
import androidx.lifecycle.ak;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.f;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext$Companion;", "", "()V", "value", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "LivingBuContext", "getLivingBuContext", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "setLivingBuContext", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "of", "Landroidx/lifecycle/ViewModelProvider;", "owner", "Lcom/tencent/mm/ui/component/IModel;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$a
{
  public static ah a(f paramf)
  {
    AppMethodBeat.i(359735);
    s.u(paramf, "owner");
    paramf = new ah((ak)paramf, (ah.b)new a.a.a(paramf));
    AppMethodBeat.o(359735);
    return paramf;
  }
  
  public static void j(a parama)
  {
    AppMethodBeat.i(359729);
    a.i(parama);
    Log.i("LivingBuContext", "LivingBuContext set value " + parama + ' ' + "");
    AppMethodBeat.o(359729);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.context.a.a
 * JD-Core Version:    0.7.0.1
 */