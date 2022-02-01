package com.tencent.mm.plugin.finder.ui;

import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.accessibility.r;
import com.tencent.mm.plugin.finder.post.g;
import com.tencent.mm.plugin.finder.viewmodel.component.at;
import com.tencent.mm.plugin.finder.viewmodel.teenmode.b;
import com.tencent.mm.plugin.findersdk.a.av;
import com.tencent.mm.plugin.findersdk.a.ax;
import com.tencent.mm.plugin.findersdk.a.bo;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.l;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.g.b.ai;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderSelfUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderSelfUI;", "()V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderSelfUI
  extends MMFinderUI
  implements bo
{
  public static final a FTZ;
  
  static
  {
    AppMethodBeat.i(347268);
    FTZ = new a((byte)0);
    AppMethodBeat.o(347268);
  }
  
  private static final boolean a(FinderSelfUI paramFinderSelfUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(347264);
    s.u(paramFinderSelfUI, "this$0");
    paramFinderSelfUI.onBackPressed();
    AppMethodBeat.o(347264);
    return true;
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(347283);
    Set localSet = ar.setOf(new Class[] { at.class, l.a(ai.cz(av.class)), l.a(ai.cz(ax.class)), g.class, b.class, r.class });
    AppMethodBeat.o(347283);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167589);
    super.onCreate(paramBundle);
    setMMTitle("");
    setBackBtn(new FinderSelfUI..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(167589);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderSelfUI$Companion;", "", "()V", "ENTER_FAV_UI_REQ_CODE", "", "ENTER_LIKE_UI_REQ_CODE", "INNER_ITEM_COUNT", "", "KEY_AUTO_SHOW_POST_BOTTOM_SHEET", "KEY_FROM_SNS_POST", "KEY_IS_FROM_DISCOVERY", "KEY_NEED_DONE_POST_ACTION", "RED_DOT_EXIST_ON_ENTER", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSelfUI
 * JD-Core Version:    0.7.0.1
 */