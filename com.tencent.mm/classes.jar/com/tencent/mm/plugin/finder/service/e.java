package com.tencent.mm.plugin.finder.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.cp.f;
import com.tencent.mm.plugin.finder.cgi.az;
import com.tencent.mm.plugin.finder.preload.g;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.findersdk.a.ag;
import com.tencent.mm.plugin.findersdk.a.bk;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ayl;
import com.tencent.mm.protocal.protobuf.bui;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/service/FinderFeedDetailService;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderFeedDetailService;", "()V", "cache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "createFinderPreloadVideoService", "Lcom/tencent/mm/plugin/findersdk/api/IFinderPreloadVideoService;", "getObjectByEncryptedId", "", "commentScene", "", "encryptedObjectId", "isUseCache", "", "call", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "feed", "Companion", "FinderPreloadVideoService", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements ag
{
  public static final a FyX;
  private final ConcurrentHashMap<String, FinderObject> BvD;
  
  static
  {
    AppMethodBeat.i(330062);
    FyX = new a((byte)0);
    AppMethodBeat.o(330062);
  }
  
  public e()
  {
    AppMethodBeat.i(330041);
    this.BvD = new ConcurrentHashMap();
    AppMethodBeat.o(330041);
  }
  
  private static final ah a(e parame, String paramString, m paramm, b.a parama)
  {
    AppMethodBeat.i(330052);
    s.u(parame, "this$0");
    s.u(paramString, "$encryptedObjectId");
    s.u(paramm, "$call");
    Object localObject = ((ayl)parama.ott).feedObject;
    if (localObject == null) {}
    for (long l = 0L;; l = ((FinderObject)localObject).id)
    {
      if ((parama.errCode == 0) && (parama.errType == 0) && (l != 0L))
      {
        localObject = ((ayl)parama.ott).feedObject;
        s.checkNotNull(localObject);
        s.s(localObject, "it.resp.feedObject!!");
        ((Map)parame.BvD).put(paramString, localObject);
        parame = com.tencent.mm.plugin.finder.storage.data.e.FMN;
        parame = FinderItem.Companion;
        parame = FinderItem.a.e((FinderObject)localObject, 0);
        parame.setReplaceLongVideoToNormal(true);
        localObject = ah.aiuX;
        com.tencent.mm.plugin.finder.storage.data.e.a.s(parame);
      }
      paramm.invoke(paramString, ((ayl)parama.ott).feedObject);
      parame = ah.aiuX;
      AppMethodBeat.o(330052);
      return parame;
    }
  }
  
  public final bk ePv()
  {
    AppMethodBeat.i(330084);
    bk localbk = (bk)new e.b();
    AppMethodBeat.o(330084);
    return localbk;
  }
  
  public final void f(String paramString, m<? super String, ? super FinderObject, ah> paramm)
  {
    AppMethodBeat.i(330078);
    s.u(paramString, "encryptedObjectId");
    s.u(paramm, "call");
    Object localObject = (FinderObject)this.BvD.get(paramString);
    if (localObject == null)
    {
      localObject = new bui();
      ((bui)localObject).AJo = 42;
      ah localah = ah.aiuX;
      new az(0L, "", 0, 2, "", true, null, null, 0L, null, false, false, paramString, (bui)localObject, 0, null, 53184).bFJ().j(new e..ExternalSyntheticLambda0(this, paramString, paramm));
      AppMethodBeat.o(330078);
      return;
    }
    paramm.invoke(paramString, localObject);
    AppMethodBeat.o(330078);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/service/FinderFeedDetailService$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "com/tencent/mm/plugin/finder/service/FinderFeedDetailService$FinderPreloadVideoService$preloadVideoWorker$2$1"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b$a
    extends u
    implements a<1>
  {
    b$a(e.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.service.e
 * JD-Core Version:    0.7.0.1
 */