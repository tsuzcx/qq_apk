package com.tencent.mm.plugin.finder.conv;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.f;
import java.util.List;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/conv/FinderConversationDataSource;", "", "storage", "Lcom/tencent/mm/plugin/finder/storage/FinderConversationStorage;", "type", "", "scene", "callback", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationDataSource$onQueryBackListener;", "(Lcom/tencent/mm/plugin/finder/storage/FinderConversationStorage;IILcom/tencent/mm/plugin/finder/conv/FinderConversationDataSource$onQueryBackListener;)V", "getAllItem", "", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "count", "getItemFromDb", "sessionId", "", "loadAfter", "", "loadInitial", "loadPartData", "offset", "loadTopPlaceCount", "loadUnReadCount", "Companion", "onQueryBackListener", "plugin-finder_release"})
public final class g
{
  public static final a xgs;
  public final int scene;
  public final int type;
  public final f xgq;
  public b xgr;
  
  static
  {
    AppMethodBeat.i(229077);
    xgs = new a((byte)0);
    AppMethodBeat.o(229077);
  }
  
  public g(f paramf, int paramInt1, int paramInt2, b paramb)
  {
    AppMethodBeat.i(229074);
    this.xgq = paramf;
    this.type = paramInt1;
    this.scene = paramInt2;
    this.xgr = paramb;
    AppMethodBeat.o(229074);
  }
  
  public final List<d> gy(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(229072);
    Object localObject = this.xgq;
    int i = this.scene;
    localObject = ((f)localObject).a(0, paramInt1, new int[] { paramInt2 }, i);
    AppMethodBeat.o(229072);
    return localObject;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/conv/FinderConversationDataSource$Companion;", "", "()V", "SCENE_FINDER", "", "SCENE_WX", "TYPE_ALIAS", "TYPE_HELLO", "TYPE_NORMAL", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/conv/FinderConversationDataSource$onQueryBackListener;", "", "loadAfter", "", "data", "", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "loadInitial", "plugin-finder_release"})
  public static abstract interface b
  {
    public abstract void ea(List<d> paramList);
    
    public abstract void eb(List<d> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.conv.g
 * JD-Core Version:    0.7.0.1
 */