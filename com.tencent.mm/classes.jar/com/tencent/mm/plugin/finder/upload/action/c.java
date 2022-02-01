package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.a.a;
import com.tencent.mm.loader.g.a.g;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/upload/action/FavActionMgr;", "", "()V", "actionQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/finder/upload/action/FavActionTask;", "feedMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/upload/action/FavAction;", "megaVideoMap", "queue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "tryTask", "Ljava/lang/Runnable;", "doFav", "", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "like", "", "scene", "", "callback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "isLongVideo", "doPost", "action", "favCount", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "favMegaVideoCount", "megaVideo", "Lcom/tencent/mm/protocal/protobuf/MegaVideo;", "isFav", "isMegaVideoFav", "isWxScene", "removeLikeCache", "removeLongVideoLikeCache", "removeUnuseAction", "tryNext", "Companion", "KeyData", "plugin-finder_release"})
public final class c
{
  private static final c ABC;
  public static final a ABD;
  private static final String TAG = "Finder.FavActionMgr";
  private final ConcurrentHashMap<Long, b> ABA;
  private final ConcurrentHashMap<Long, b> ABB;
  private final ConcurrentLinkedQueue<e> ABz;
  private com.tencent.mm.loader.g.d<d> Azm;
  private final Runnable Azn;
  
  static
  {
    AppMethodBeat.i(285311);
    ABD = new a((byte)0);
    TAG = "Finder.FavActionMgr";
    ABC = new c();
    AppMethodBeat.o(285311);
  }
  
  public c()
  {
    AppMethodBeat.i(285310);
    this.Azm = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new a(100), new g(1, (byte)0), 1, "finder_action_fav_post_quene"));
    this.ABz = new ConcurrentLinkedQueue();
    this.ABA = new ConcurrentHashMap();
    this.ABB = new ConcurrentHashMap();
    this.Azn = ((Runnable)new c(this));
    AppMethodBeat.o(285310);
  }
  
  private final void a(final e parame)
  {
    AppMethodBeat.i(285309);
    this.Azm.a((com.tencent.mm.loader.g.c)new d(parame), (com.tencent.mm.loader.g.f)new b(this, parame));
    AppMethodBeat.o(285309);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(285305);
    p.k(paramb, "action");
    b localb = (b)this.ABA.get(Long.valueOf(paramb.feedId));
    if (localb != null)
    {
      String str;
      StringBuilder localStringBuilder;
      if (BuildInfo.DEBUG)
      {
        str = TAG;
        localStringBuilder = new StringBuilder("removeLikeCache ").append(paramb).append(" result ");
        if (paramb.ABL < localb.ABL) {
          break label130;
        }
      }
      label130:
      for (boolean bool = true;; bool = false)
      {
        Log.i(str, bool);
        if (paramb.ABL >= localb.ABL) {
          this.ABA.remove(Long.valueOf(paramb.feedId));
        }
        AppMethodBeat.o(285305);
        return;
      }
    }
    AppMethodBeat.o(285305);
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(285306);
    p.k(paramb, "action");
    b localb = (b)this.ABB.get(Long.valueOf(paramb.feedId));
    if (localb != null)
    {
      String str;
      StringBuilder localStringBuilder;
      if (BuildInfo.DEBUG)
      {
        str = TAG;
        localStringBuilder = new StringBuilder("removeLikeCache ").append(paramb).append(" result ");
        if (paramb.ABL < localb.ABL) {
          break label130;
        }
      }
      label130:
      for (boolean bool = true;; bool = false)
      {
        Log.i(str, bool);
        if (paramb.ABL >= localb.ABL) {
          this.ABB.remove(Long.valueOf(paramb.feedId));
        }
        AppMethodBeat.o(285306);
        return;
      }
    }
    AppMethodBeat.o(285306);
  }
  
  public final void ebY()
  {
    AppMethodBeat.i(285307);
    e locale;
    boolean bool;
    do
    {
      if (this.ABz.size() <= 0)
      {
        AppMethodBeat.o(285307);
        return;
      }
      locale = (e)this.ABz.poll();
      bool = locale.isValid();
      Log.i(TAG, "tryNext isValid:" + bool + " action:" + locale + " size:" + this.ABz.size());
    } while (!bool);
    p.j(locale, "action");
    a(locale);
    AppMethodBeat.o(285307);
  }
  
  public final boolean p(FinderObject paramFinderObject)
  {
    boolean bool = false;
    AppMethodBeat.i(285303);
    p.k(paramFinderObject, "feed");
    if (paramFinderObject.id == 0L)
    {
      if (paramFinderObject.favFlag == 1)
      {
        AppMethodBeat.o(285303);
        return true;
      }
      AppMethodBeat.o(285303);
      return false;
    }
    if (paramFinderObject.favFlag == 1) {
      bool = true;
    }
    Object localObject = (b)this.ABA.get(Long.valueOf(paramFinderObject.id));
    if (localObject != null) {
      bool = ((b)localObject).ABw;
    }
    String str;
    StringBuilder localStringBuilder;
    if (BuildInfo.DEBUG)
    {
      str = TAG;
      localStringBuilder = new StringBuilder("isLike test ").append(paramFinderObject.id).append(" isLike:");
      localObject = (b)this.ABA.get(Long.valueOf(paramFinderObject.id));
      if (localObject == null) {
        break label195;
      }
    }
    label195:
    for (localObject = Boolean.valueOf(((b)localObject).ABw);; localObject = null)
    {
      Log.i(str, localObject + " favFlag:" + paramFinderObject.favFlag + " result:" + bool);
      AppMethodBeat.o(285303);
      return bool;
    }
  }
  
  public final int q(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(285304);
    p.k(paramFinderObject, "feed");
    if (paramFinderObject.id == 0L)
    {
      i = paramFinderObject.favCount;
      AppMethodBeat.o(285304);
      return i;
    }
    boolean bool1;
    b localb;
    if (paramFinderObject.favFlag == 1)
    {
      bool1 = true;
      localb = (b)this.ABA.get(Long.valueOf(paramFinderObject.id));
      if (localb == null) {
        break label105;
      }
    }
    label105:
    for (boolean bool2 = localb.ABw;; bool2 = bool1)
    {
      if ((!bool1) || (true == bool2)) {
        break label111;
      }
      i = paramFinderObject.favCount;
      AppMethodBeat.o(285304);
      return i - 1;
      bool1 = false;
      break;
    }
    label111:
    if ((!bool1) && (bool2))
    {
      i = paramFinderObject.favCount;
      AppMethodBeat.o(285304);
      return i + 1;
    }
    int i = paramFinderObject.favCount;
    AppMethodBeat.o(285304);
    return i;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/upload/action/FavActionMgr$Companion;", "", "()V", "INSTANCE", "Lcom/tencent/mm/plugin/finder/upload/action/FavActionMgr;", "getINSTANCE", "()Lcom/tencent/mm/plugin/finder/upload/action/FavActionMgr;", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/upload/action/FavActionMgr$doPost$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/finder/upload/action/FavActionTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"})
  public static final class b
    implements com.tencent.mm.loader.g.f<d>
  {
    b(e parame) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(274881);
      this.ABE.ebY();
      AppMethodBeat.o(274881);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.c
 * JD-Core Version:    0.7.0.1
 */