package com.tencent.mm.plugin.finder.nearby;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.core.core.f.a.a;
import com.tencent.mm.plugin.finder.model.ay;
import com.tencent.mm.plugin.finder.nearby.report.g;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.findersdk.a.ap;
import com.tencent.mm.plugin.findersdk.a.by;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.l;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.g.b.ai;

@com.tencent.mm.ui.widget.pulldown.c(0)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/NearbyUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "finish", "", "getReportTag", "", "getReportType", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "intent", "Landroid/content/Intent;", "Companion", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class NearbyUI
  extends MMFinderUI
{
  public static final a EFB;
  
  static
  {
    AppMethodBeat.i(339791);
    EFB = new a((byte)0);
    AppMethodBeat.o(339791);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int edC()
  {
    return 3;
  }
  
  public final String efe()
  {
    return "NearbyUI";
  }
  
  public final void finish()
  {
    AppMethodBeat.i(339813);
    g localg = g.ERj;
    g.eGO();
    super.finish();
    AppMethodBeat.o(339813);
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(339798);
    Set localSet = ar.setOf(new Class[] { e.class, c.class, b.class, l.a(ai.cz(by.class)), com.tencent.mm.plugin.finder.nearby.accessibility.a.class, l.a(ai.cz(ap.class)) });
    AppMethodBeat.o(339798);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(339807);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.plugin.finder.nearby.report.b.EQs;
    com.tencent.mm.plugin.finder.nearby.report.b.eGI();
    paramBundle = ay.EDk;
    ay.startTimer();
    AppMethodBeat.o(339807);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(339821);
    super.onDestroy();
    Object localObject = ay.EDk;
    ay.stopTimer();
    localObject = com.tencent.mm.plugin.finder.nearby.report.e.EQU;
    com.tencent.mm.plugin.finder.nearby.report.e.clear();
    if (!com.tencent.mm.n.a.q(null, false))
    {
      localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      com.tencent.mm.plugin.finder.live.utils.a.ad(true, true);
      localObject = com.tencent.mm.live.core.core.f.a.mUf;
      a.a.clear();
    }
    ((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).cancelCirculationFillingActivityIconOfSourceType(1);
    AppMethodBeat.o(339821);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(339803);
    super.onNewIntent(paramIntent);
    AppMethodBeat.o(339803);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/NearbyUI$Companion;", "", "()V", "TAG", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.NearbyUI
 * JD-Core Version:    0.7.0.1
 */