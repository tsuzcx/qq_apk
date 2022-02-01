package com.tencent.mm.plugin.finder.conv;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatting.BasePrivateMsgConvListFragment.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.g;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/conv/FinderConversationDataSource;", "Lcom/tencent/mm/chatting/BasePrivateMsgConvListFragment$IConversationDataSource;", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "type", "", "scene", "(II)V", "getAllItem", "", "count", "getConversationStorage", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "loadOnLoadMore", "offset", "loadOnPageEnter", "Companion", "onQueryBackListener", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements BasePrivateMsgConvListFragment.c<b>
{
  public static final a AFK;
  private final int scene;
  private final int type;
  
  static
  {
    AppMethodBeat.i(336026);
    AFK = new a((byte)0);
    AppMethodBeat.o(336026);
  }
  
  public e(int paramInt1, int paramInt2)
  {
    this.type = paramInt1;
    this.scene = paramInt2;
  }
  
  public final List<b> Nd(int paramInt)
  {
    AppMethodBeat.i(336060);
    Object localObject = (g)aNP();
    int i = this.scene;
    localObject = ((g)localObject).a(0, 1, new int[] { paramInt }, i);
    AppMethodBeat.o(336060);
    return localObject;
  }
  
  public final MAutoStorage<b> aNP()
  {
    AppMethodBeat.i(336034);
    MAutoStorage localMAutoStorage = (MAutoStorage)((PluginFinder)h.az(PluginFinder.class)).getConversationStorage();
    AppMethodBeat.o(336034);
    return localMAutoStorage;
  }
  
  public final List<b> aNQ()
  {
    AppMethodBeat.i(336045);
    g localg = (g)aNP();
    Object localObject;
    if (this.type == 1) {
      if (this.scene == 2)
      {
        localObject = new int[2];
        localObject[0] = 2;
        localObject[1] = 100;
      }
    }
    for (;;)
    {
      localObject = localg.a(0, 15, (int[])localObject, this.scene);
      AppMethodBeat.o(336045);
      return localObject;
      localObject = new int[2];
      localObject[0] = 2;
      localObject[1] = 200;
      continue;
      if (this.type == 3)
      {
        localObject = new int[1];
        localObject[0] = 3;
      }
      else
      {
        localObject = new int[1];
        localObject[0] = 1;
      }
    }
  }
  
  public final List<b> qH(int paramInt)
  {
    AppMethodBeat.i(336055);
    g localg = (g)aNP();
    Object localObject;
    if (this.type == 1) {
      if (this.scene == 2)
      {
        localObject = new int[2];
        localObject[0] = 2;
        localObject[1] = 100;
      }
    }
    for (;;)
    {
      localObject = localg.a(paramInt, 60, (int[])localObject, this.scene);
      AppMethodBeat.o(336055);
      return localObject;
      localObject = new int[1];
      localObject[0] = 2;
      continue;
      localObject = new int[1];
      localObject[0] = 1;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/conv/FinderConversationDataSource$Companion;", "", "()V", "SCENE_FINDER", "", "SCENE_WX", "TYPE_ALIAS", "TYPE_HELLO", "TYPE_NORMAL", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.conv.e
 * JD-Core Version:    0.7.0.1
 */