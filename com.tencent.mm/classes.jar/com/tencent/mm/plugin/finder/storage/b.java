package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.ae;
import com.tencent.mm.plugin.finder.convert.bz;
import com.tencent.mm.plugin.finder.convert.z;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.viewmodel.atfeed.a;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.g;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FinderAtFeedManagerLayoutConfig;", "Lcom/tencent/mm/plugin/finder/storage/FinderProfileGridLayoutConfig;", "spanCount", "", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "isSelfFlag", "", "username", "", "atFeedState", "Lcom/tencent/mm/plugin/finder/viewmodel/atfeed/AtFeedState;", "(ILcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;ZLjava/lang/String;Lcom/tencent/mm/plugin/finder/viewmodel/atfeed/AtFeedState;)V", "getItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "extraMap", "Lkotlin/Function1;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends ai
{
  final boolean ALI;
  final a ALJ;
  private final BaseFinderFeedLoader FAr;
  private final int spanCount;
  final String username;
  
  public b(BaseFinderFeedLoader paramBaseFinderFeedLoader, boolean paramBoolean, String paramString, a parama)
  {
    super(paramBaseFinderFeedLoader, paramBoolean, paramString);
    AppMethodBeat.i(339179);
    this.spanCount = 3;
    this.FAr = paramBaseFinderFeedLoader;
    this.ALI = paramBoolean;
    this.username = paramString;
    this.ALJ = parama;
    AppMethodBeat.o(339179);
  }
  
  public final g au(final kotlin.g.a.b<? super Integer, ? extends f<?>> paramb)
  {
    AppMethodBeat.i(339186);
    paramb = (g)new a(this, paramb);
    AppMethodBeat.o(339186);
    return paramb;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/storage/FinderAtFeedManagerLayoutConfig$getItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements g
  {
    a(b paramb, kotlin.g.a.b<? super Integer, ? extends f<?>> paramb1) {}
    
    public final f<?> yF(int paramInt)
    {
      AppMethodBeat.i(338941);
      switch (paramInt)
      {
      default: 
        localObject = paramb;
        if (localObject != null) {
          break;
        }
      }
      for (Object localObject = null; localObject == null; localObject = (f)((kotlin.g.a.b)localObject).invoke(Integer.valueOf(paramInt)))
      {
        localObject = b.Ts(paramInt);
        AppMethodBeat.o(338941);
        return localObject;
        localObject = (f)new bz(this.FAs.ALH, this.FAs.username, this.FAs.ALI, this.FAs.ALJ);
        AppMethodBeat.o(338941);
        return localObject;
        localObject = (f)new bz(this.FAs.ALH, this.FAs.username, this.FAs.ALI, this.FAs.ALJ);
        AppMethodBeat.o(338941);
        return localObject;
        localObject = (f)new ae();
        AppMethodBeat.o(338941);
        return localObject;
        localObject = (f)new z();
        AppMethodBeat.o(338941);
        return localObject;
      }
      AppMethodBeat.o(338941);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.b
 * JD-Core Version:    0.7.0.1
 */