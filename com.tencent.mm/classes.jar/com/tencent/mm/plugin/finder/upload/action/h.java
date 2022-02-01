package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.a.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/upload/action/FavActionMgr;", "", "()V", "actionQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/finder/upload/action/FavActionTask;", "feedMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/upload/action/FavAction;", "queue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "tryTask", "Ljava/lang/Runnable;", "doFav", "", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "like", "", "scene", "", "callback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "doPost", "action", "favCount", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "isFav", "isWxScene", "removeLikeCache", "removeUnuseAction", "tryNext", "Companion", "KeyData", "plugin-finder_release"})
public final class h
{
  private static final h Lam;
  public static final a Lan;
  private static final String TAG = "Finder.FavActionMgr";
  private com.tencent.mm.loader.g.d<i> qQA;
  private final Runnable qQB;
  private final ConcurrentLinkedQueue<b> qRN;
  private final ConcurrentHashMap<Long, g> qRO;
  
  static
  {
    AppMethodBeat.i(199550);
    Lan = new a((byte)0);
    TAG = "Finder.FavActionMgr";
    Lam = new h();
    AppMethodBeat.o(199550);
  }
  
  public h()
  {
    AppMethodBeat.i(199549);
    this.qQA = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new a(100), new com.tencent.mm.loader.g.a.g(1, (byte)0), 1, "finder_action_fav_post_quene"));
    this.qRN = new ConcurrentLinkedQueue();
    this.qRO = new ConcurrentHashMap();
    this.qQB = ((Runnable)new c(this));
    AppMethodBeat.o(199549);
  }
  
  private final void a(final b paramb)
  {
    AppMethodBeat.i(199548);
    this.qQA.a((com.tencent.mm.loader.g.c)new i(paramb), (com.tencent.mm.loader.g.f)new b(this, paramb));
    AppMethodBeat.o(199548);
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(199545);
    k.h(paramg, "action");
    g localg = (g)this.qRO.get(Long.valueOf(paramg.feedId));
    if (localg != null)
    {
      String str;
      StringBuilder localStringBuilder;
      if (com.tencent.mm.sdk.platformtools.h.DEBUG)
      {
        str = TAG;
        localStringBuilder = new StringBuilder("removeLikeCache ").append(paramg).append(" result ");
        if (paramg.qRH < localg.qRH) {
          break label130;
        }
      }
      label130:
      for (boolean bool = true;; bool = false)
      {
        ad.i(str, bool);
        if (paramg.qRH >= localg.qRH) {
          this.qRO.remove(Long.valueOf(paramg.feedId));
        }
        AppMethodBeat.o(199545);
        return;
      }
    }
    AppMethodBeat.o(199545);
  }
  
  public final void crw()
  {
    AppMethodBeat.i(199546);
    b localb;
    boolean bool;
    do
    {
      if (this.qRN.size() <= 0)
      {
        AppMethodBeat.o(199546);
        return;
      }
      localb = (b)this.qRN.poll();
      bool = localb.isValid();
      ad.i(TAG, "tryNext isValid:" + bool + " action:" + localb + " size:" + this.qRN.size());
    } while (!bool);
    k.g(localb, "action");
    a(localb);
    AppMethodBeat.o(199546);
  }
  
  public final boolean l(FinderObject paramFinderObject)
  {
    boolean bool = false;
    AppMethodBeat.i(199543);
    k.h(paramFinderObject, "feed");
    if (paramFinderObject.id == 0L)
    {
      if (paramFinderObject.favFlag == 1)
      {
        AppMethodBeat.o(199543);
        return true;
      }
      AppMethodBeat.o(199543);
      return false;
    }
    if (paramFinderObject.favFlag == 1) {
      bool = true;
    }
    Object localObject = (g)this.qRO.get(Long.valueOf(paramFinderObject.id));
    if (localObject != null) {
      bool = ((g)localObject).Lak;
    }
    String str;
    StringBuilder localStringBuilder;
    if (com.tencent.mm.sdk.platformtools.h.DEBUG)
    {
      str = TAG;
      localStringBuilder = new StringBuilder("isLike test ").append(paramFinderObject.id).append(" isLike:");
      localObject = (g)this.qRO.get(Long.valueOf(paramFinderObject.id));
      if (localObject == null) {
        break label195;
      }
    }
    label195:
    for (localObject = Boolean.valueOf(((g)localObject).Lak);; localObject = null)
    {
      ad.i(str, localObject + " favFlag:" + paramFinderObject.favFlag + " result:" + bool);
      AppMethodBeat.o(199543);
      return bool;
    }
  }
  
  public final int m(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(199544);
    k.h(paramFinderObject, "feed");
    if (paramFinderObject.id == 0L)
    {
      i = paramFinderObject.favCount;
      AppMethodBeat.o(199544);
      return i;
    }
    boolean bool1;
    g localg;
    if (paramFinderObject.favFlag == 1)
    {
      bool1 = true;
      localg = (g)this.qRO.get(Long.valueOf(paramFinderObject.id));
      if (localg == null) {
        break label105;
      }
    }
    label105:
    for (boolean bool2 = localg.Lak;; bool2 = bool1)
    {
      if ((!bool1) || (true == bool2)) {
        break label111;
      }
      i = paramFinderObject.favCount;
      AppMethodBeat.o(199544);
      return i - 1;
      bool1 = false;
      break;
    }
    label111:
    if ((!bool1) && (bool2))
    {
      i = paramFinderObject.favCount;
      AppMethodBeat.o(199544);
      return i + 1;
    }
    int i = paramFinderObject.favCount;
    AppMethodBeat.o(199544);
    return i;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/upload/action/FavActionMgr$Companion;", "", "()V", "INSTANCE", "Lcom/tencent/mm/plugin/finder/upload/action/FavActionMgr;", "getINSTANCE", "()Lcom/tencent/mm/plugin/finder/upload/action/FavActionMgr;", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/upload/action/FavActionMgr$doPost$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/finder/upload/action/FavActionTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"})
  public static final class b
    implements com.tencent.mm.loader.g.f<i>
  {
    b(b paramb) {}
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(h paramh) {}
    
    public final void run()
    {
      AppMethodBeat.i(199542);
      this.Lao.crw();
      AppMethodBeat.o(199542);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.h
 * JD-Core Version:    0.7.0.1
 */