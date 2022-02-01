package com.tencent.mm.plugin.finder.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bhh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/preload/FinderPreloadTransform;", "", "()V", "TAG", "", "buildPreloadInfo", "Lcom/tencent/mm/protocal/protobuf/FinderPreloadInfo;", "info", "transform", "", "list", "", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "source", "", "print", "plugin-finder_release"})
public final class a
{
  public static final a zKe;
  
  static
  {
    AppMethodBeat.i(268471);
    zKe = new a();
    AppMethodBeat.o(268471);
  }
  
  public static bhh a(bhh parambhh)
  {
    int i = 1;
    AppMethodBeat.i(268470);
    Object localObject = parambhh;
    if (parambhh == null)
    {
      parambhh = h.aHG();
      p.j(parambhh, "MMKernel.storage()");
      parambhh = parambhh.aHp().get(ar.a.VzU, "");
      if (parambhh == null)
      {
        parambhh = new t("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(268470);
        throw parambhh;
      }
      parambhh = Util.decodeHexString((String)parambhh);
      localObject = new StringBuilder("[buildPreloadInfo] buffer isEmpty? ");
      p.j(parambhh, "buffer");
      boolean bool;
      if (parambhh.length == 0)
      {
        bool = true;
        Log.i("Finder.PreloadTransform", bool);
        if (parambhh.length != 0) {
          break label130;
        }
      }
      for (;;)
      {
        if (i == 0) {
          break label135;
        }
        parambhh = new bhh();
        AppMethodBeat.o(268470);
        return parambhh;
        bool = false;
        break;
        label130:
        i = 0;
      }
      label135:
      localObject = new bhh();
      ((bhh)localObject).parseFrom(parambhh);
    }
    AppMethodBeat.o(268470);
    return localObject;
  }
  
  public static void a(bhh parambhh, List<? extends FinderObject> paramList, int paramInt)
  {
    AppMethodBeat.i(268469);
    p.k(paramList, "list");
    Object localObject2 = new StringBuilder("[transform] info=");
    if (parambhh != null) {
      p.k(parambhh, "$this$print");
    }
    for (Object localObject1 = "[preloadId=" + parambhh.zKM + " hotFeed=" + parambhh.SRU.size() + ']';; localObject1 = null)
    {
      Log.i("Finder.PreloadTransform", (String)localObject1 + " list=" + paramList.size() + " source=" + paramInt);
      localObject1 = ((PluginFinder)h.ag(PluginFinder.class)).getMediaPreloadModel();
      parambhh = a(parambhh);
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
    ((com.tencent.mm.plugin.finder.preload.model.a)localObject1).a(parambhh, (HashMap)localObject2);
    AppMethodBeat.o(268469);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.a
 * JD-Core Version:    0.7.0.1
 */