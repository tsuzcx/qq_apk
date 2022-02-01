package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.a.a;
import com.tencent.mm.loader.g.a.g;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.j;
import d.g.b.p;
import d.l;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/upload/action/FavActionMgr;", "", "()V", "actionQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/finder/upload/action/FavActionTask;", "feedMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/upload/action/FavAction;", "queue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "tryTask", "Ljava/lang/Runnable;", "doFav", "", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "like", "", "scene", "", "callback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "doPost", "action", "favCount", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "isFav", "isWxScene", "removeLikeCache", "removeUnuseAction", "tryNext", "Companion", "KeyData", "plugin-finder_release"})
public final class c
{
  private static final String TAG = "Finder.FavActionMgr";
  private static final c sVe;
  public static final a sVf;
  private com.tencent.mm.loader.g.d<d> sTM;
  private final Runnable sTN;
  private final ConcurrentLinkedQueue<e> sVc;
  private final ConcurrentHashMap<Long, b> sVd;
  
  static
  {
    AppMethodBeat.i(204983);
    sVf = new a((byte)0);
    TAG = "Finder.FavActionMgr";
    sVe = new c();
    AppMethodBeat.o(204983);
  }
  
  public c()
  {
    AppMethodBeat.i(204982);
    this.sTM = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new a(100), new g(1, (byte)0), 1, "finder_action_fav_post_quene"));
    this.sVc = new ConcurrentLinkedQueue();
    this.sVd = new ConcurrentHashMap();
    this.sTN = ((Runnable)new c(this));
    AppMethodBeat.o(204982);
  }
  
  private final void a(final e parame)
  {
    AppMethodBeat.i(204981);
    this.sTM.a((com.tencent.mm.loader.g.c)new d(parame), (com.tencent.mm.loader.g.f)new b(this, parame));
    AppMethodBeat.o(204981);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(204978);
    p.h(paramb, "action");
    b localb = (b)this.sVd.get(Long.valueOf(paramb.duw));
    if (localb != null)
    {
      String str;
      StringBuilder localStringBuilder;
      if (j.DEBUG)
      {
        str = TAG;
        localStringBuilder = new StringBuilder("removeLikeCache ").append(paramb).append(" result ");
        if (paramb.sVn < localb.sVn) {
          break label130;
        }
      }
      label130:
      for (boolean bool = true;; bool = false)
      {
        ae.i(str, bool);
        if (paramb.sVn >= localb.sVn) {
          this.sVd.remove(Long.valueOf(paramb.duw));
        }
        AppMethodBeat.o(204978);
        return;
      }
    }
    AppMethodBeat.o(204978);
  }
  
  public final void cNf()
  {
    AppMethodBeat.i(204979);
    e locale;
    boolean bool;
    do
    {
      if (this.sVc.size() <= 0)
      {
        AppMethodBeat.o(204979);
        return;
      }
      locale = (e)this.sVc.poll();
      bool = locale.isValid();
      ae.i(TAG, "tryNext isValid:" + bool + " action:" + locale + " size:" + this.sVc.size());
    } while (!bool);
    p.g(locale, "action");
    a(locale);
    AppMethodBeat.o(204979);
  }
  
  public final boolean i(FinderObject paramFinderObject)
  {
    boolean bool = false;
    AppMethodBeat.i(204976);
    p.h(paramFinderObject, "feed");
    if (paramFinderObject.id == 0L)
    {
      if (paramFinderObject.favFlag == 1)
      {
        AppMethodBeat.o(204976);
        return true;
      }
      AppMethodBeat.o(204976);
      return false;
    }
    if (paramFinderObject.favFlag == 1) {
      bool = true;
    }
    Object localObject = (b)this.sVd.get(Long.valueOf(paramFinderObject.id));
    if (localObject != null) {
      bool = ((b)localObject).sUZ;
    }
    String str;
    StringBuilder localStringBuilder;
    if (j.DEBUG)
    {
      str = TAG;
      localStringBuilder = new StringBuilder("isLike test ").append(paramFinderObject.id).append(" isLike:");
      localObject = (b)this.sVd.get(Long.valueOf(paramFinderObject.id));
      if (localObject == null) {
        break label195;
      }
    }
    label195:
    for (localObject = Boolean.valueOf(((b)localObject).sUZ);; localObject = null)
    {
      ae.i(str, localObject + " favFlag:" + paramFinderObject.favFlag + " result:" + bool);
      AppMethodBeat.o(204976);
      return bool;
    }
  }
  
  public final int j(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(204977);
    p.h(paramFinderObject, "feed");
    if (paramFinderObject.id == 0L)
    {
      i = paramFinderObject.favCount;
      AppMethodBeat.o(204977);
      return i;
    }
    boolean bool1;
    b localb;
    if (paramFinderObject.favFlag == 1)
    {
      bool1 = true;
      localb = (b)this.sVd.get(Long.valueOf(paramFinderObject.id));
      if (localb == null) {
        break label105;
      }
    }
    label105:
    for (boolean bool2 = localb.sUZ;; bool2 = bool1)
    {
      if ((!bool1) || (true == bool2)) {
        break label111;
      }
      i = paramFinderObject.favCount;
      AppMethodBeat.o(204977);
      return i - 1;
      bool1 = false;
      break;
    }
    label111:
    if ((!bool1) && (bool2))
    {
      i = paramFinderObject.favCount;
      AppMethodBeat.o(204977);
      return i + 1;
    }
    int i = paramFinderObject.favCount;
    AppMethodBeat.o(204977);
    return i;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/upload/action/FavActionMgr$Companion;", "", "()V", "INSTANCE", "Lcom/tencent/mm/plugin/finder/upload/action/FavActionMgr;", "getINSTANCE", "()Lcom/tencent/mm/plugin/finder/upload/action/FavActionMgr;", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/upload/action/FavActionMgr$doPost$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/finder/upload/action/FavActionTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"})
  public static final class b
    implements com.tencent.mm.loader.g.f<d>
  {
    b(e parame) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(204975);
      this.sVg.cNf();
      AppMethodBeat.o(204975);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.c
 * JD-Core Version:    0.7.0.1
 */