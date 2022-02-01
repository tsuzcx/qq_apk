package com.tencent.mm.plugin.finder.profile;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.ui.sample.FinderSampleTabUI.b;
import com.tencent.mm.ui.component.UIComponent;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/FinderProfileLongFeedFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "()V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderProfileLongFeedFragment
  extends FinderHomeTabFragment
{
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(348145);
    Set localSet = ar.setOf(FinderSampleTabUI.b.class);
    AppMethodBeat.o(348145);
    return localSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.FinderProfileLongFeedFragment
 * JD-Core Version:    0.7.0.1
 */