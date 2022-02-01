package com.tencent.mm.plugin.finder.conv;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.e;
import java.util.List;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/conv/FinderConversationDataSource;", "", "storage", "Lcom/tencent/mm/plugin/finder/storage/FinderConversationStorage;", "type", "", "scene", "callback", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationDataSource$onQueryBackListener;", "(Lcom/tencent/mm/plugin/finder/storage/FinderConversationStorage;IILcom/tencent/mm/plugin/finder/conv/FinderConversationDataSource$onQueryBackListener;)V", "getAllItem", "", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "count", "getItemFromDb", "sessionId", "", "loadAfter", "", "loadInitial", "loadPartData", "offset", "loadTopPlaceCount", "loadUnReadCount", "Companion", "onQueryBackListener", "plugin-finder_release"})
public final class f
{
  public static final a tyG;
  public final int scene;
  public final e tyE;
  public b tyF;
  public final int type;
  
  static
  {
    AppMethodBeat.i(242729);
    tyG = new a((byte)0);
    AppMethodBeat.o(242729);
  }
  
  public f(e parame, int paramInt1, int paramInt2, b paramb)
  {
    AppMethodBeat.i(242728);
    this.tyE = parame;
    this.type = paramInt1;
    this.scene = paramInt2;
    this.tyF = paramb;
    AppMethodBeat.o(242728);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/conv/FinderConversationDataSource$Companion;", "", "()V", "SCENE_FINDER", "", "SCENE_WX", "TYPE_HELLO", "TYPE_NORMAL", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/conv/FinderConversationDataSource$onQueryBackListener;", "", "loadAfter", "", "data", "", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "loadInitial", "plugin-finder_release"})
  public static abstract interface b
  {
    public abstract void dS(List<c> paramList);
    
    public abstract void dT(List<c> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.conv.f
 * JD-Core Version:    0.7.0.1
 */