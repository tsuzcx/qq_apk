package com.tencent.mm.plugin.finder.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.view.convert.a;
import com.tencent.mm.plugin.finder.utils.j;
import com.tencent.mm.protocal.protobuf.FinderObject;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/FinderLiveMediaSource;", "", "tag", "", "feed", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "getFeed", "()Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getTag", "()Ljava/lang/String;", "isTheSame", "", "mediaSource", "isValid", "toString", "plugin-finder_release"})
public final class g
{
  private final String tag;
  public final FinderObject xVl;
  
  public g(String paramString, FinderObject paramFinderObject)
  {
    AppMethodBeat.i(280448);
    this.tag = paramString;
    this.xVl = paramFinderObject;
    AppMethodBeat.o(280448);
  }
  
  public final boolean a(g paramg)
  {
    AppMethodBeat.i(280447);
    p.k(paramg, "mediaSource");
    Object localObject = a.zaD;
    localObject = a.g(this.xVl);
    a locala = a.zaD;
    if (p.h(localObject, a.g(paramg.xVl)))
    {
      localObject = a.zaD;
      long l = a.h(this.xVl);
      localObject = a.zaD;
      if (l == a.h(paramg.xVl))
      {
        AppMethodBeat.o(280447);
        return true;
      }
    }
    AppMethodBeat.o(280447);
    return false;
  }
  
  public final boolean isValid()
  {
    AppMethodBeat.i(280446);
    a locala = a.zaD;
    if (((CharSequence)a.g(this.xVl)).length() > 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      locala = a.zaD;
      if (a.h(this.xVl) == 0L) {
        break;
      }
      AppMethodBeat.o(280446);
      return true;
    }
    AppMethodBeat.o(280446);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(280445);
    Object localObject = new StringBuilder("tag:").append(this.tag).append(", liveId:");
    a locala = a.zaD;
    localObject = ((StringBuilder)localObject).append(a.h(this.xVl)).append(", valid url:");
    locala = a.zaD;
    if (((CharSequence)a.g(this.xVl)).length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = bool + ", nickName:" + j.aFz(this.xVl.nickname);
      AppMethodBeat.o(280445);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.g
 * JD-Core Version:    0.7.0.1
 */