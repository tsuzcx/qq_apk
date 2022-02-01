package com.tencent.mm.plugin.finder.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.aqn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import d.g.b.p;
import d.l;
import d.v;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/preload/FinderPreloadTransform;", "", "()V", "TAG", "", "buildPreloadInfo", "Lcom/tencent/mm/protocal/protobuf/FinderPreloadInfo;", "info", "transform", "", "list", "", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "print", "plugin-finder_release"})
public final class a
{
  public static final a skH;
  
  static
  {
    AppMethodBeat.i(203008);
    skH = new a();
    AppMethodBeat.o(203008);
  }
  
  public static void a(aqn paramaqn, List<? extends FinderObject> paramList)
  {
    int i = 1;
    AppMethodBeat.i(203007);
    p.h(paramList, "list");
    Object localObject2 = new StringBuilder("[transform] info=");
    if (paramaqn != null) {
      p.h(paramaqn, "$this$print");
    }
    for (Object localObject1 = "[preloadId=" + paramaqn.slp + " hotFeed=" + paramaqn.GoG.size() + ']';; localObject1 = null)
    {
      ad.i("Finder.PreloadTransform", (String)localObject1 + " list=" + paramList.size());
      localObject2 = ((PluginFinder)g.ad(PluginFinder.class)).getMediaPreloadModel();
      localObject1 = paramaqn;
      if (paramaqn != null) {
        break label238;
      }
      paramaqn = g.ajC();
      p.g(paramaqn, "MMKernel.storage()");
      paramaqn = paramaqn.ajl().get(al.a.IHv, "");
      if (paramaqn != null) {
        break;
      }
      paramaqn = new v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(203007);
      throw paramaqn;
    }
    paramaqn = bt.aRa((String)paramaqn);
    localObject1 = new StringBuilder("[buildPreloadInfo] buffer isEmpty? ");
    p.g(paramaqn, "buffer");
    boolean bool;
    if (paramaqn.length == 0)
    {
      bool = true;
      ad.i("Finder.PreloadTransform", bool);
      if (paramaqn.length != 0) {
        break label316;
      }
      label225:
      if (i == 0) {
        break label321;
      }
      localObject1 = new aqn();
    }
    for (;;)
    {
      label238:
      paramaqn = new HashMap();
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext())
      {
        FinderObject localFinderObject = (FinderObject)paramList.next();
        if (localFinderObject.objectDesc.mediaType == 4) {
          ((Map)paramaqn).put(Long.valueOf(localFinderObject.id), localFinderObject);
        }
      }
      bool = false;
      break;
      label316:
      i = 0;
      break label225;
      label321:
      localObject1 = new aqn();
      ((aqn)localObject1).parseFrom(paramaqn);
    }
    ((com.tencent.mm.plugin.finder.preload.model.a)localObject2).a((aqn)localObject1, paramaqn);
    AppMethodBeat.o(203007);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.a
 * JD-Core Version:    0.7.0.1
 */