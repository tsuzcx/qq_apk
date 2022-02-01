package com.tencent.mm.plugin.finder.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.baw;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/preload/FinderPreloadTransform;", "", "()V", "TAG", "", "buildPreloadInfo", "Lcom/tencent/mm/protocal/protobuf/FinderPreloadInfo;", "info", "transform", "", "list", "", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "source", "", "print", "plugin-finder_release"})
public final class a
{
  public static final a uTO;
  
  static
  {
    AppMethodBeat.i(249502);
    uTO = new a();
    AppMethodBeat.o(249502);
  }
  
  public static baw a(baw parambaw)
  {
    int i = 1;
    AppMethodBeat.i(249501);
    Object localObject = parambaw;
    if (parambaw == null)
    {
      parambaw = g.aAh();
      p.g(parambaw, "MMKernel.storage()");
      parambaw = parambaw.azQ().get(ar.a.OkZ, "");
      if (parambaw == null)
      {
        parambaw = new t("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(249501);
        throw parambaw;
      }
      parambaw = Util.decodeHexString((String)parambaw);
      localObject = new StringBuilder("[buildPreloadInfo] buffer isEmpty? ");
      p.g(parambaw, "buffer");
      boolean bool;
      if (parambaw.length == 0)
      {
        bool = true;
        Log.i("Finder.PreloadTransform", bool);
        if (parambaw.length != 0) {
          break label130;
        }
      }
      for (;;)
      {
        if (i == 0) {
          break label135;
        }
        parambaw = new baw();
        AppMethodBeat.o(249501);
        return parambaw;
        bool = false;
        break;
        label130:
        i = 0;
      }
      label135:
      localObject = new baw();
      ((baw)localObject).parseFrom(parambaw);
    }
    AppMethodBeat.o(249501);
    return localObject;
  }
  
  public static void a(baw parambaw, List<? extends FinderObject> paramList, int paramInt)
  {
    AppMethodBeat.i(249500);
    p.h(paramList, "list");
    Object localObject2 = new StringBuilder("[transform] info=");
    if (parambaw != null) {
      p.h(parambaw, "$this$print");
    }
    for (Object localObject1 = "[preloadId=" + parambaw.uUw + " hotFeed=" + parambaw.LKA.size() + ']';; localObject1 = null)
    {
      Log.i("Finder.PreloadTransform", (String)localObject1 + " list=" + paramList.size() + " source=" + paramInt);
      localObject1 = ((PluginFinder)g.ah(PluginFinder.class)).getMediaPreloadModel();
      parambaw = a(parambaw);
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
    ((com.tencent.mm.plugin.finder.preload.model.a)localObject1).a(parambaw, (HashMap)localObject2);
    AppMethodBeat.o(249500);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.a
 * JD-Core Version:    0.7.0.1
 */