package com.tencent.mm.plugin.finder.viewmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.protocal.protobuf.bxv;
import com.tencent.mm.ui.component.n;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTopicFeedCacheVM;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "()V", "caches", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderTopicFeedCacheVM$Cache;", "tagCaches", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "clearTagCache", "", "get", "keyWord", "getTagCache", "store", "lastDataList", "", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "topicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "storeTagCache", "Cache", "Companion", "TagCache", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends n<PluginFinder>
{
  public static final b GLw;
  private final ConcurrentHashMap<String, a> GKl;
  public ArrayList<BaseFinderFeed> GLx;
  
  static
  {
    AppMethodBeat.i(337154);
    GLw = new b((byte)0);
    AppMethodBeat.o(337154);
  }
  
  public k()
  {
    AppMethodBeat.i(337149);
    this.GKl = new ConcurrentHashMap();
    AppMethodBeat.o(337149);
  }
  
  public final a aCM(String paramString)
  {
    AppMethodBeat.i(337163);
    s.u(paramString, "keyWord");
    a locala = (a)this.GKl.get(paramString);
    if (locala == null)
    {
      locala = new a(paramString);
      ((Map)this.GKl).put(paramString, new a(paramString));
      AppMethodBeat.o(337163);
      return locala;
    }
    AppMethodBeat.o(337163);
    return locala;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTopicFeedCacheVM$Cache;", "", "keyWord", "", "(Ljava/lang/String;)V", "getKeyWord", "()Ljava/lang/String;", "lastDataList", "", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getLastDataList", "()Ljava/util/List;", "setLastDataList", "(Ljava/util/List;)V", "topicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "getTopicInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "setTopicInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;)V", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public List<? extends cc> GLv;
    public bxv hLt;
    private final String oQy;
    
    public a(String paramString)
    {
      AppMethodBeat.i(337370);
      this.oQy = paramString;
      this.GLv = ((List)new LinkedList());
      AppMethodBeat.o(337370);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(337400);
      if (this == paramObject)
      {
        AppMethodBeat.o(337400);
        return true;
      }
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(337400);
        return false;
      }
      paramObject = (a)paramObject;
      if (!s.p(this.oQy, paramObject.oQy))
      {
        AppMethodBeat.o(337400);
        return false;
      }
      AppMethodBeat.o(337400);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(337388);
      int i = this.oQy.hashCode();
      AppMethodBeat.o(337388);
      return i;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(337382);
      String str = "Cache(keyWord=" + this.oQy + ')';
      AppMethodBeat.o(337382);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTopicFeedCacheVM$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.k
 * JD-Core Version:    0.7.0.1
 */