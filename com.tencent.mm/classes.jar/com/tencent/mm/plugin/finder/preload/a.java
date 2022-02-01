package com.tencent.mm.plugin.finder.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.preload.model.b;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.btc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/preload/FinderPreloadTransform;", "", "()V", "TAG", "", "buildPreloadInfo", "Lcom/tencent/mm/protocal/protobuf/FinderPreloadInfo;", "info", "transform", "", "list", "", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "source", "", "print", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a EUs;
  
  static
  {
    AppMethodBeat.i(346259);
    EUs = new a();
    AppMethodBeat.o(346259);
  }
  
  public static btc a(btc parambtc)
  {
    int i = 1;
    AppMethodBeat.i(346254);
    if (parambtc == null)
    {
      parambtc = h.baE().ban().get(at.a.adcj, "");
      if (parambtc == null)
      {
        parambtc = new NullPointerException("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(346254);
        throw parambtc;
      }
      parambtc = Util.decodeHexString((String)parambtc);
      s.s(parambtc, "buffer");
      boolean bool;
      if (parambtc.length == 0)
      {
        bool = true;
        Log.i("Finder.PreloadTransform", s.X("[buildPreloadInfo] buffer isEmpty? ", Boolean.valueOf(bool)));
        if (parambtc.length != 0) {
          break label111;
        }
      }
      for (;;)
      {
        if (i == 0) {
          break label116;
        }
        parambtc = new btc();
        AppMethodBeat.o(346254);
        return parambtc;
        bool = false;
        break;
        label111:
        i = 0;
      }
      label116:
      btc localbtc = new btc();
      localbtc.parseFrom(parambtc);
      AppMethodBeat.o(346254);
      return localbtc;
    }
    AppMethodBeat.o(346254);
    return parambtc;
  }
  
  public static void a(btc parambtc, List<? extends FinderObject> paramList, int paramInt)
  {
    AppMethodBeat.i(346243);
    s.u(paramList, "list");
    Object localObject2 = new StringBuilder("[transform] info=");
    Object localObject1;
    if (parambtc == null)
    {
      localObject1 = null;
      Log.i("Finder.PreloadTransform", localObject1 + " list=" + paramList.size() + " source=" + paramInt);
      localObject1 = ((PluginFinder)h.az(PluginFinder.class)).getMediaPreloadModel();
      parambtc = a(parambtc);
      localObject2 = new HashMap();
      paramList = ((Iterable)paramList).iterator();
    }
    label224:
    for (;;)
    {
      label101:
      if (!paramList.hasNext()) {
        break label226;
      }
      FinderObject localFinderObject = (FinderObject)paramList.next();
      FinderObjectDesc localFinderObjectDesc = localFinderObject.objectDesc;
      if ((localFinderObjectDesc != null) && (localFinderObjectDesc.mediaType == 4)) {}
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt == 0) {
          break label224;
        }
        ((Map)localObject2).put(Long.valueOf(localFinderObject.id), localFinderObject);
        break label101;
        s.u(parambtc, "<this>");
        localObject1 = "[preloadId=" + parambtc.EVt + " hotFeed=" + parambtc.aaaX.size() + ']';
        break;
      }
    }
    label226:
    paramList = ah.aiuX;
    ((b)localObject1).a(parambtc, (HashMap)localObject2);
    AppMethodBeat.o(346243);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.a
 * JD-Core Version:    0.7.0.1
 */