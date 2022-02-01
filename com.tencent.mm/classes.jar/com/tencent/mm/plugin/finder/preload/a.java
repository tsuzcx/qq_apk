package com.tencent.mm.plugin.finder.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.arc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import d.g.b.p;
import d.l;
import d.v;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/preload/FinderPreloadTransform;", "", "()V", "TAG", "", "buildPreloadInfo", "Lcom/tencent/mm/protocal/protobuf/FinderPreloadInfo;", "info", "transform", "", "list", "", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "source", "", "print", "plugin-finder_release"})
public final class a
{
  public static final a stE;
  
  static
  {
    AppMethodBeat.i(203493);
    stE = new a();
    AppMethodBeat.o(203493);
  }
  
  public static arc a(arc paramarc)
  {
    int i = 1;
    AppMethodBeat.i(203492);
    Object localObject = paramarc;
    if (paramarc == null)
    {
      paramarc = g.ajR();
      p.g(paramarc, "MMKernel.storage()");
      paramarc = paramarc.ajA().get(am.a.JbY, "");
      if (paramarc == null)
      {
        paramarc = new v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(203492);
        throw paramarc;
      }
      paramarc = bu.aSx((String)paramarc);
      localObject = new StringBuilder("[buildPreloadInfo] buffer isEmpty? ");
      p.g(paramarc, "buffer");
      boolean bool;
      if (paramarc.length == 0)
      {
        bool = true;
        ae.i("Finder.PreloadTransform", bool);
        if (paramarc.length != 0) {
          break label130;
        }
      }
      for (;;)
      {
        if (i == 0) {
          break label135;
        }
        paramarc = new arc();
        AppMethodBeat.o(203492);
        return paramarc;
        bool = false;
        break;
        label130:
        i = 0;
      }
      label135:
      localObject = new arc();
      ((arc)localObject).parseFrom(paramarc);
    }
    AppMethodBeat.o(203492);
    return localObject;
  }
  
  public static void a(arc paramarc, List<? extends FinderObject> paramList, int paramInt)
  {
    AppMethodBeat.i(203491);
    p.h(paramList, "list");
    Object localObject2 = new StringBuilder("[transform] info=");
    if (paramarc != null) {
      p.h(paramarc, "$this$print");
    }
    for (Object localObject1 = "[preloadId=" + paramarc.sun + " hotFeed=" + paramarc.GHW.size() + ']';; localObject1 = null)
    {
      ae.i("Finder.PreloadTransform", (String)localObject1 + " list=" + paramList.size() + " source=" + paramInt);
      localObject1 = ((PluginFinder)g.ad(PluginFinder.class)).getMediaPreloadModel();
      paramarc = a(paramarc);
      localObject2 = new HashMap();
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext())
      {
        FinderObject localFinderObject = (FinderObject)paramList.next();
        FinderObjectDesc localFinderObjectDesc = localFinderObject.objectDesc;
        if ((localFinderObjectDesc != null) && (localFinderObjectDesc.mediaType == 4)) {
          ((Map)localObject2).put(Long.valueOf(localFinderObject.id), localFinderObject);
        }
      }
    }
    ((com.tencent.mm.plugin.finder.preload.model.a)localObject1).a(paramarc, (HashMap)localObject2);
    AppMethodBeat.o(203491);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.a
 * JD-Core Version:    0.7.0.1
 */