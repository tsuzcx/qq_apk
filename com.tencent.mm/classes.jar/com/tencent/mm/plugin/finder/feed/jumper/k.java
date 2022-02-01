package com.tencent.mm.plugin.finder.feed.jumper;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.protocal.protobuf.FinderJumpInfo;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/jumper/FinderJumpInfoEx;", "", "jumpInfo", "Lcom/tencent/mm/protocal/protobuf/FinderJumpInfo;", "(Lcom/tencent/mm/protocal/protobuf/FinderJumpInfo;)V", "cache", "Lcom/tencent/mm/plugin/finder/feed/jumper/FinderJumpInfoCache;", "getCache", "()Lcom/tencent/mm/plugin/finder/feed/jumper/FinderJumpInfoCache;", "setCache", "(Lcom/tencent/mm/plugin/finder/feed/jumper/FinderJumpInfoCache;)V", "contact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "getContact", "()Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "setContact", "(Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;)V", "extra", "", "getExtra", "()Ljava/lang/String;", "setExtra", "(Ljava/lang/String;)V", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "setFeed", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "getJumpInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderJumpInfo;", "reportType", "", "getReportType", "()I", "setReportType", "(I)V", "sceneNote", "getSceneNote", "setSceneNote", "source", "getSource", "setSource", "weAppOpenBundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "getWeAppOpenBundle", "()Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "setWeAppOpenBundle", "(Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;)V", "component1", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
{
  public BaseFinderFeed AUZ;
  public j Bea;
  public g Beb;
  public m contact;
  String extra;
  public final FinderJumpInfo hVf;
  int hYb;
  public String hzx;
  public String source;
  
  public k(FinderJumpInfo paramFinderJumpInfo)
  {
    AppMethodBeat.i(364182);
    this.hVf = paramFinderJumpInfo;
    AppMethodBeat.o(364182);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(364201);
    if (this == paramObject)
    {
      AppMethodBeat.o(364201);
      return true;
    }
    if (!(paramObject instanceof k))
    {
      AppMethodBeat.o(364201);
      return false;
    }
    paramObject = (k)paramObject;
    if (!s.p(this.hVf, paramObject.hVf))
    {
      AppMethodBeat.o(364201);
      return false;
    }
    AppMethodBeat.o(364201);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(364192);
    int i = this.hVf.hashCode();
    AppMethodBeat.o(364192);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(364186);
    String str = "FinderJumpInfoEx(jumpInfo=" + this.hVf + ')';
    AppMethodBeat.o(364186);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.jumper.k
 * JD-Core Version:    0.7.0.1
 */