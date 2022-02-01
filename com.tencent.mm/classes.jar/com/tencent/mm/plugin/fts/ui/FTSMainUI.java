package com.tencent.mm.plugin.fts.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.ui.hotsearch.uic.b;
import com.tencent.mm.plugin.fts.ui.hotsearch.uic.c;
import com.tencent.mm.plugin.fts.ui.hotsearch.uic.d;
import com.tencent.mm.plugin.fts.ui.hotsearch.uic.e;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/fts/ui/FTSMainUI;", "Lcom/tencent/mm/plugin/fts/ui/FTSBaseMainUI;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "superImportUIComponents", "set", "Ljava/util/HashSet;", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lkotlin/collections/HashSet;", "ui-fts_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FTSMainUI
  extends FTSBaseMainUI
{
  public FTSMainUI()
  {
    AppMethodBeat.i(111977);
    AppMethodBeat.o(111977);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(111978);
    super.onCreate(paramBundle);
    AppMethodBeat.o(111978);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(265538);
    s.u(paramHashSet, "set");
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(b.class);
    paramHashSet.add(c.class);
    paramHashSet.add(d.class);
    paramHashSet.add(e.class);
    AppMethodBeat.o(265538);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSMainUI
 * JD-Core Version:    0.7.0.1
 */