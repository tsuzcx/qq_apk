package com.tencent.mm.plugin.finder.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.findersdk.a.ab;
import com.tencent.mm.plugin.findersdk.a.af;
import com.tencent.mm.plugin.findersdk.a.ah;
import com.tencent.mm.plugin.findersdk.a.bu;
import com.tencent.mm.plugin.findersdk.a.cc;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.l;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/MMFinderFeedDetailUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "superImportUIComponents", "", "set", "Ljava/util/HashSet;", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class MMFinderFeedDetailUI
  extends MMFinderUI
{
  public void _$_clearFindViewByIdCache() {}
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    s.u(paramHashSet, "set");
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(l.a(kotlin.g.b.ai.cz(bu.class)));
    paramHashSet.add(l.a(kotlin.g.b.ai.cz(ab.class)));
    paramHashSet.add(l.a(kotlin.g.b.ai.cz(af.class)));
    paramHashSet.add(l.a(kotlin.g.b.ai.cz(cc.class)));
    paramHashSet.add(l.a(kotlin.g.b.ai.cz(com.tencent.mm.plugin.findersdk.a.ai.class)));
    paramHashSet.add(l.a(kotlin.g.b.ai.cz(ah.class)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.MMFinderFeedDetailUI
 * JD-Core Version:    0.7.0.1
 */