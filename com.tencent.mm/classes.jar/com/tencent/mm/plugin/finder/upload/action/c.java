package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.f.a.a;
import com.tencent.mm.loader.f.a.f;
import com.tencent.mm.loader.f.a.g;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/action/FavActionMgr;", "", "()V", "actionQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/finder/upload/action/FavActionTask;", "feedMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/upload/action/FavAction;", "megaVideoMap", "queue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "tryTask", "Ljava/lang/Runnable;", "doFav", "", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "like", "", "scene", "", "callback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "isLongVideo", "source", "doPost", "action", "favCount", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "favMegaVideoCount", "megaVideo", "Lcom/tencent/mm/protocal/protobuf/MegaVideo;", "isFav", "isMegaVideoFav", "isWxScene", "removeLikeCache", "removeLongVideoLikeCache", "removeUnuseAction", "tryNext", "Companion", "KeyData", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final a GcH;
  private static final c GcK;
  private static final String TAG;
  private com.tencent.mm.loader.f.d<d> Gag;
  private final Runnable Gai;
  private final ConcurrentLinkedQueue<e> Gap;
  private final ConcurrentHashMap<Long, b> GcI;
  private final ConcurrentHashMap<Long, b> GcJ;
  
  static
  {
    AppMethodBeat.i(343389);
    GcH = new a((byte)0);
    TAG = "Finder.FavActionMgr";
    GcK = new c();
    AppMethodBeat.o(343389);
  }
  
  public c()
  {
    AppMethodBeat.i(343313);
    this.Gag = new com.tencent.mm.loader.f.d((com.tencent.mm.loader.f.a.d)new f((com.tencent.mm.loader.f.a.c)new a(100), new g(1, (byte)0), 1, "finder_action_fav_post_quene"));
    this.Gap = new ConcurrentLinkedQueue();
    this.GcI = new ConcurrentHashMap();
    this.GcJ = new ConcurrentHashMap();
    this.Gai = new c..ExternalSyntheticLambda0(this);
    AppMethodBeat.o(343313);
  }
  
  private static final void a(c paramc)
  {
    AppMethodBeat.i(343335);
    s.u(paramc, "this$0");
    paramc.fdz();
    AppMethodBeat.o(343335);
  }
  
  private final void a(final e parame)
  {
    AppMethodBeat.i(343328);
    this.Gag.a((com.tencent.mm.loader.f.c)new d(parame), (com.tencent.mm.loader.f.e)new b(this, parame));
    AppMethodBeat.o(343328);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(343416);
    s.u(paramb, "action");
    b localb = (b)this.GcI.get(Long.valueOf(paramb.feedId));
    String str;
    StringBuilder localStringBuilder;
    if (localb != null) {
      if (BuildInfo.DEBUG)
      {
        str = TAG;
        localStringBuilder = new StringBuilder("removeLikeCache ").append(paramb).append(" result ");
        if (paramb.Gae < localb.Gae) {
          break label130;
        }
      }
    }
    label130:
    for (boolean bool = true;; bool = false)
    {
      Log.i(str, bool);
      if (paramb.Gae >= localb.Gae) {
        this.GcI.remove(Long.valueOf(paramb.feedId));
      }
      AppMethodBeat.o(343416);
      return;
    }
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(343423);
    s.u(paramb, "action");
    b localb = (b)this.GcJ.get(Long.valueOf(paramb.feedId));
    String str;
    StringBuilder localStringBuilder;
    if (localb != null) {
      if (BuildInfo.DEBUG)
      {
        str = TAG;
        localStringBuilder = new StringBuilder("removeLikeCache ").append(paramb).append(" result ");
        if (paramb.Gae < localb.Gae) {
          break label130;
        }
      }
    }
    label130:
    for (boolean bool = true;; bool = false)
    {
      Log.i(str, bool);
      if (paramb.Gae >= localb.Gae) {
        this.GcJ.remove(Long.valueOf(paramb.feedId));
      }
      AppMethodBeat.o(343423);
      return;
    }
  }
  
  public final void fdz()
  {
    AppMethodBeat.i(343429);
    e locale;
    boolean bool;
    do
    {
      if (this.Gap.size() <= 0)
      {
        AppMethodBeat.o(343429);
        return;
      }
      locale = (e)this.Gap.poll();
      bool = locale.isValid();
      Log.i(TAG, "tryNext isValid:" + bool + " action:" + locale + " size:" + this.Gap.size());
    } while (!bool);
    s.s(locale, "action");
    a(locale);
    AppMethodBeat.o(343429);
  }
  
  public final boolean s(FinderObject paramFinderObject)
  {
    boolean bool = false;
    AppMethodBeat.i(343402);
    s.u(paramFinderObject, "feed");
    if (paramFinderObject.id == 0L)
    {
      if (paramFinderObject.favFlag == 1)
      {
        AppMethodBeat.o(343402);
        return true;
      }
      AppMethodBeat.o(343402);
      return false;
    }
    if (paramFinderObject.favFlag == 1) {
      bool = true;
    }
    Object localObject = (b)this.GcI.get(Long.valueOf(paramFinderObject.id));
    if (localObject != null) {
      bool = ((b)localObject).GcG;
    }
    String str;
    StringBuilder localStringBuilder;
    if (BuildInfo.DEBUG)
    {
      str = TAG;
      localStringBuilder = new StringBuilder("isLike test ").append(paramFinderObject.id).append(" isLike:");
      localObject = (b)this.GcI.get(Long.valueOf(paramFinderObject.id));
      if (localObject != null) {
        break label189;
      }
    }
    label189:
    for (localObject = null;; localObject = Boolean.valueOf(((b)localObject).GcG))
    {
      Log.i(str, localObject + " favFlag:" + paramFinderObject.favFlag + " result:" + bool);
      AppMethodBeat.o(343402);
      return bool;
    }
  }
  
  public final int t(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(343408);
    s.u(paramFinderObject, "feed");
    int i;
    if (paramFinderObject.id == 0L)
    {
      i = paramFinderObject.favCount;
      AppMethodBeat.o(343408);
      return i;
    }
    boolean bool1;
    b localb;
    if (paramFinderObject.favFlag == 1)
    {
      bool1 = true;
      localb = (b)this.GcI.get(Long.valueOf(paramFinderObject.id));
      if (localb == null) {
        break label142;
      }
    }
    label142:
    for (boolean bool2 = localb.GcG;; bool2 = bool1)
    {
      if ((bool1) && (true != bool2))
      {
        i = paramFinderObject.favCount;
        AppMethodBeat.o(343408);
        return i - 1;
        bool1 = false;
        break;
      }
      if ((!bool1) && (bool2))
      {
        i = paramFinderObject.favCount;
        AppMethodBeat.o(343408);
        return i + 1;
      }
      i = paramFinderObject.favCount;
      AppMethodBeat.o(343408);
      return i;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/action/FavActionMgr$Companion;", "", "()V", "INSTANCE", "Lcom/tencent/mm/plugin/finder/upload/action/FavActionMgr;", "getINSTANCE", "()Lcom/tencent/mm/plugin/finder/upload/action/FavActionMgr;", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/upload/action/FavActionMgr$doPost$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/finder/upload/action/FavActionTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.loader.f.e<d>
  {
    b(c paramc, e parame) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.c
 * JD-Core Version:    0.7.0.1
 */