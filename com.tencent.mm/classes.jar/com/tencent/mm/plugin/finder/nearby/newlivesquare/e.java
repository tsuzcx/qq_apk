package com.tencent.mm.plugin.finder.nearby.newlivesquare;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.finder.nearby.live.square.tab.c;
import com.tencent.mm.protocal.protobuf.bad;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/LiveEntranceFragmentUICMoreIcon;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "netSceneFetchSquareTabs", "Lcom/tencent/mm/plugin/finder/nearby/live/square/tab/NetSceneFetchSquareTabs;", "fetchTabs", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends UIComponent
  implements com.tencent.mm.am.h
{
  public static final a EMF;
  c EMe;
  
  static
  {
    AppMethodBeat.i(340248);
    EMF = new a((byte)0);
    AppMethodBeat.o(340248);
  }
  
  public e(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(340242);
    AppMethodBeat.o(340242);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(340253);
    super.onCreate(paramBundle);
    AppMethodBeat.o(340253);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(370464);
    super.onDestroy();
    com.tencent.mm.kernel.h.aZW().b(4210, (com.tencent.mm.am.h)this);
    c localc = this.EMe;
    int i;
    if (localc != null)
    {
      if (localc.isCanceled()) {
        break label64;
      }
      i = 1;
      if (i == 0) {
        break label69;
      }
    }
    for (;;)
    {
      if (localc != null) {
        com.tencent.mm.kernel.h.aZW().a((p)localc);
      }
      AppMethodBeat.o(370464);
      return;
      label64:
      i = 0;
      break;
      label69:
      localc = null;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(340260);
    kotlin.g.b.s.u(paramp, "scene");
    com.tencent.mm.kernel.h.aZW().b(4210, (com.tencent.mm.am.h)this);
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      d.uiThread((a)new b(this, ((c)paramp).eFE()));
    }
    AppMethodBeat.o(340260);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/LiveEntranceFragmentUICMoreIcon$Companion;", "", "()V", "TAG", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<ah>
  {
    b(e parame, bad parambad)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.newlivesquare.e
 * JD-Core Version:    0.7.0.1
 */