package com.tencent.mm.plugin.finder.conv;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.d;
import d.l;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/conv/FinderConversationDataSource;", "", "storage", "Lcom/tencent/mm/plugin/finder/storage/FinderConversationStorage;", "type", "", "scene", "callback", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationDataSource$onQueryBackListener;", "(Lcom/tencent/mm/plugin/finder/storage/FinderConversationStorage;IILcom/tencent/mm/plugin/finder/conv/FinderConversationDataSource$onQueryBackListener;)V", "getAllItem", "", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "count", "getItemFromDb", "sessionId", "", "loadAfter", "", "loadInitial", "loadPartData", "offset", "loadTopPlaceCount", "loadUnReadCount", "Companion", "onQueryBackListener", "plugin-finder_release"})
public final class f
{
  public static final a rTO;
  public final d rTM;
  public b rTN;
  public final int scene;
  public final int type;
  
  static
  {
    AppMethodBeat.i(201707);
    rTO = new a((byte)0);
    AppMethodBeat.o(201707);
  }
  
  public f(d paramd, int paramInt1, int paramInt2, b paramb)
  {
    AppMethodBeat.i(201706);
    this.rTM = paramd;
    this.type = paramInt1;
    this.scene = paramInt2;
    this.rTN = paramb;
    AppMethodBeat.o(201706);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/conv/FinderConversationDataSource$Companion;", "", "()V", "SCENE_FINDER", "", "SCENE_WX", "TYPE_HELLO", "TYPE_NORMAL", "plugin-finder_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/conv/FinderConversationDataSource$onQueryBackListener;", "", "loadAfter", "", "data", "", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "loadInitial", "plugin-finder_release"})
  public static abstract interface b
  {
    public abstract void dD(List<c> paramList);
    
    public abstract void dE(List<c> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.conv.f
 * JD-Core Version:    0.7.0.1
 */