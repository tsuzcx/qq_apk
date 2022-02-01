package com.tencent.mm.plugin.finder.cgi.interceptor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.aq.d;
import com.tencent.mm.plugin.finder.feed.model.d;
import com.tencent.mm.protocal.protobuf.bwk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/interceptor/FinderHomeTabTipBubbleInterceptor;", "Lcom/tencent/mm/plugin/finder/cgi/interceptor/IFinderStreamInterceptor;", "()V", "onIntercept", "", "resp", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "tabType", "", "onInterceptAfterStore", "loadedInfo", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "onInterceptBeforeStore", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements g
{
  public static final a AEY;
  
  static
  {
    AppMethodBeat.i(336707);
    AEY = new a((byte)0);
    AppMethodBeat.o(336707);
  }
  
  public final boolean a(aq.d paramd, int paramInt)
  {
    AppMethodBeat.i(336713);
    s.u(paramd, "resp");
    Object localObject;
    if (paramInt == 4)
    {
      localObject = paramd.aafm;
      if (localObject != null) {
        break label88;
      }
      localObject = null;
      Log.i("Finder.TipBubbleInterceptor", s.X("[onIntercept] show_reddot=", localObject));
      localObject = k.aeZF;
      localObject = k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.preload.tabPreload.c.class);
      s.s(localObject, "UICProvider.of(PluginFin…bPreloadCore::class.java)");
      localObject = (com.tencent.mm.plugin.finder.preload.tabPreload.c)localObject;
      paramd = paramd.aafm;
      if (paramd != null) {
        break label99;
      }
    }
    label88:
    label99:
    for (paramInt = 100;; paramInt = paramd.aaft)
    {
      ((com.tencent.mm.plugin.finder.preload.tabPreload.c)localObject).EVS = paramInt;
      AppMethodBeat.o(336713);
      return false;
      localObject = Integer.valueOf(((bwk)localObject).aaft);
      break;
    }
  }
  
  public final boolean a(d paramd)
  {
    AppMethodBeat.i(336721);
    s.u(paramd, "loadedInfo");
    AppMethodBeat.o(336721);
    return false;
  }
  
  public final boolean b(d paramd, int paramInt)
  {
    AppMethodBeat.i(336727);
    s.u(paramd, "loadedInfo");
    AppMethodBeat.o(336727);
    return false;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/interceptor/FinderHomeTabTipBubbleInterceptor$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.interceptor.c
 * JD-Core Version:    0.7.0.1
 */