package com.tencent.mm.plugin.finder.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.post.b;
import com.tencent.mm.plugin.finder.post.e;
import com.tencent.mm.plugin.finder.post.f;
import com.tencent.mm.plugin.finder.post.g;
import com.tencent.mm.plugin.finder.post.h;
import com.tencent.mm.plugin.finder.post.i;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.component.UIComponent;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;

@a(17)
@com.tencent.mm.ui.widget.pulldown.c(0)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderPostUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public class FinderPostUI
  extends MMFinderUI
{
  public static final FinderPostUI.a FTe;
  
  static
  {
    AppMethodBeat.i(346758);
    FTe = new FinderPostUI.a((byte)0);
    AppMethodBeat.o(346758);
  }
  
  public FinderPostUI()
  {
    AppMethodBeat.i(167543);
    AppMethodBeat.o(167543);
  }
  
  public void _$_clearFindViewByIdCache() {}
  
  public Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(346768);
    Set localSet = ar.setOf(new Class[] { i.class, b.class, h.class, e.class, f.class, g.class, com.tencent.mm.plugin.finder.c.class });
    AppMethodBeat.o(346768);
    return localSet;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167528);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    AppMethodBeat.o(167528);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderPostUI
 * JD-Core Version:    0.7.0.1
 */