package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.ad;
import com.tencent.mm.plugin.finder.convert.ai;
import com.tencent.mm.plugin.finder.convert.cb;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.viewmodel.atfeed.a;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.f;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/FinderAtFeedManagerLayoutConfig;", "Lcom/tencent/mm/plugin/finder/storage/FinderProfileGridLayoutConfig;", "spanCount", "", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "isSelfFlag", "", "username", "", "atFeedState", "Lcom/tencent/mm/plugin/finder/viewmodel/atfeed/AtFeedState;", "(ILcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;ZLjava/lang/String;Lcom/tencent/mm/plugin/finder/viewmodel/atfeed/AtFeedState;)V", "getItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "extraMap", "Lkotlin/Function1;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "plugin-finder_release"})
public final class b
  extends ae
{
  private final BaseFinderFeedLoader AdQ;
  private final int spanCount;
  final String username;
  final boolean xnY;
  final a xnZ;
  
  public b(BaseFinderFeedLoader paramBaseFinderFeedLoader, boolean paramBoolean, String paramString, a parama)
  {
    super(paramBaseFinderFeedLoader, paramBoolean, paramString);
    AppMethodBeat.i(287701);
    this.spanCount = 3;
    this.AdQ = paramBaseFinderFeedLoader;
    this.xnY = paramBoolean;
    this.username = paramString;
    this.xnZ = parama;
    AppMethodBeat.o(287701);
  }
  
  public final f O(final kotlin.g.a.b<? super Integer, ? extends e<?>> paramb)
  {
    AppMethodBeat.i(287700);
    paramb = (f)new a(this, paramb);
    AppMethodBeat.o(287700);
    return paramb;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/storage/FinderAtFeedManagerLayoutConfig$getItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements f
  {
    a(kotlin.g.a.b paramb) {}
    
    public final e<?> yx(int paramInt)
    {
      AppMethodBeat.i(265848);
      switch (paramInt)
      {
      default: 
        localObject = paramb;
        if (localObject != null)
        {
          e locale = (e)((kotlin.g.a.b)localObject).invoke(Integer.valueOf(paramInt));
          localObject = locale;
          if (locale != null) {}
        }
        else
        {
          localObject = b.Qk(paramInt);
        }
        AppMethodBeat.o(265848);
        return localObject;
      case 4: 
      case 3002: 
        localObject = (e)new cb(this.AdR.xnX, this.AdR.username, this.AdR.xnY, this.AdR.xnZ);
        AppMethodBeat.o(265848);
        return localObject;
      case 2: 
      case 3001: 
        localObject = (e)new cb(this.AdR.xnX, this.AdR.username, this.AdR.xnY, this.AdR.xnZ);
        AppMethodBeat.o(265848);
        return localObject;
      case -3: 
        localObject = (e)new ai();
        AppMethodBeat.o(265848);
        return localObject;
      }
      Object localObject = (e)new ad();
      AppMethodBeat.o(265848);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.b
 * JD-Core Version:    0.7.0.1
 */