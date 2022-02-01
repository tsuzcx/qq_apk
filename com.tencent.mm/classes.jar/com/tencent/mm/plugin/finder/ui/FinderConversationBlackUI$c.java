package com.tencent.mm.plugin.finder.ui;

import androidx.paging.m;
import androidx.paging.m.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderConversationBlackUI$ContactDataSourceFactory;", "Landroidx/paging/DataSource$Factory;", "Lcom/tencent/mm/plugin/finder/ui/FinderConversationBlackUI$PageParam;", "Lcom/tencent/mm/plugin/finder/ui/FinderConversationBlackUI$ContactItem;", "talkerType", "", "(I)V", "create", "Landroidx/paging/DataSource;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderConversationBlackUI$c
  extends m.c<Object, FinderConversationBlackUI.e>
{
  private final int FOR;
  
  public FinderConversationBlackUI$c(int paramInt)
  {
    this.FOR = paramInt;
  }
  
  public final m<Object, FinderConversationBlackUI.e> HH()
  {
    AppMethodBeat.i(346651);
    m localm = (m)new FinderConversationBlackUI.b(this.FOR);
    AppMethodBeat.o(346651);
    return localm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderConversationBlackUI.c
 * JD-Core Version:    0.7.0.1
 */