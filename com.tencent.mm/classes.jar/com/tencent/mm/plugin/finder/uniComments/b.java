package com.tencent.mm.plugin.finder.uniComments;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/uniComments/UniCache;", "", "()V", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  private static final Map<Long, com.tencent.mm.plugin.finder.uniComments.model.b> AwX;
  public static final a FYx;
  
  static
  {
    AppMethodBeat.i(341410);
    FYx = new a((byte)0);
    AwX = Collections.synchronizedMap((Map)new HashMap());
    AppMethodBeat.o(341410);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/uniComments/UniCache$Companion;", "", "()V", "TAG", "", "cacheItems", "", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/finder/uniComments/model/UniEntityItem;", "", "clean", "", "getById", "id", "putIfNotExist", "finder", "remove", "", "svrId", "update", "FeedData", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.uniComments.b
 * JD-Core Version:    0.7.0.1
 */