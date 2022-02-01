package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import d.l;
import java.util.ArrayList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/ProfileInit;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitRequest;", "username", "", "limit", "", "initDone", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "oldDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "(Ljava/lang/String;ILcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;Ljava/util/ArrayList;)V", "getLimit", "()I", "getOldDataList", "()Ljava/util/ArrayList;", "getUsername", "()Ljava/lang/String;", "plugin-finder_release"})
public final class o
  extends h
{
  private final int limit;
  final ArrayList<BaseFinderFeed> oldDataList;
  final String username;
  
  public o(String paramString, int paramInt, g paramg, ArrayList<BaseFinderFeed> paramArrayList)
  {
    super(paramg);
    AppMethodBeat.i(166085);
    this.username = paramString;
    this.limit = paramInt;
    this.oldDataList = paramArrayList;
    AppMethodBeat.o(166085);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.o
 * JD-Core Version:    0.7.0.1
 */