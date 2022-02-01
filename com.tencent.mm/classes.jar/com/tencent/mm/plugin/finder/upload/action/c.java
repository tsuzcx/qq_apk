package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.a.a;
import com.tencent.mm.loader.g.a.g;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.i;
import d.g.b.p;
import d.l;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/upload/action/FavActionMgr;", "", "()V", "actionQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/finder/upload/action/FavActionTask;", "feedMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/upload/action/FavAction;", "queue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "tryTask", "Ljava/lang/Runnable;", "doFav", "", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "like", "", "scene", "", "callback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "doPost", "action", "favCount", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "isFav", "isWxScene", "removeLikeCache", "removeUnuseAction", "tryNext", "Companion", "KeyData", "plugin-finder_release"})
public final class c
{
  private static final String TAG = "Finder.FavActionMgr";
  private static final c sJR;
  public static final a sJS;
  private com.tencent.mm.loader.g.d<d> sIA;
  private final Runnable sIB;
  private final ConcurrentLinkedQueue<e> sJP;
  private final ConcurrentHashMap<Long, b> sJQ;
  
  static
  {
    AppMethodBeat.i(204365);
    sJS = new a((byte)0);
    TAG = "Finder.FavActionMgr";
    sJR = new c();
    AppMethodBeat.o(204365);
  }
  
  public c()
  {
    AppMethodBeat.i(204364);
    this.sIA = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new a(100), new g(1, (byte)0), 1, "finder_action_fav_post_quene"));
    this.sJP = new ConcurrentLinkedQueue();
    this.sJQ = new ConcurrentHashMap();
    this.sIB = ((Runnable)new c(this));
    AppMethodBeat.o(204364);
  }
  
  private final void a(final e parame)
  {
    AppMethodBeat.i(204363);
    this.sIA.a((com.tencent.mm.loader.g.c)new d(parame), (com.tencent.mm.loader.g.f)new b(this, parame));
    AppMethodBeat.o(204363);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(204360);
    p.h(paramb, "action");
    b localb = (b)this.sJQ.get(Long.valueOf(paramb.dtq));
    if (localb != null)
    {
      String str;
      StringBuilder localStringBuilder;
      if (i.DEBUG)
      {
        str = TAG;
        localStringBuilder = new StringBuilder("removeLikeCache ").append(paramb).append(" result ");
        if (paramb.sKa < localb.sKa) {
          break label130;
        }
      }
      label130:
      for (boolean bool = true;; bool = false)
      {
        ad.i(str, bool);
        if (paramb.sKa >= localb.sKa) {
          this.sJQ.remove(Long.valueOf(paramb.dtq));
        }
        AppMethodBeat.o(204360);
        return;
      }
    }
    AppMethodBeat.o(204360);
  }
  
  public final void cKB()
  {
    AppMethodBeat.i(204361);
    e locale;
    boolean bool;
    do
    {
      if (this.sJP.size() <= 0)
      {
        AppMethodBeat.o(204361);
        return;
      }
      locale = (e)this.sJP.poll();
      bool = locale.isValid();
      ad.i(TAG, "tryNext isValid:" + bool + " action:" + locale + " size:" + this.sJP.size());
    } while (!bool);
    p.g(locale, "action");
    a(locale);
    AppMethodBeat.o(204361);
  }
  
  public final boolean i(FinderObject paramFinderObject)
  {
    boolean bool = false;
    AppMethodBeat.i(204358);
    p.h(paramFinderObject, "feed");
    if (paramFinderObject.id == 0L)
    {
      if (paramFinderObject.favFlag == 1)
      {
        AppMethodBeat.o(204358);
        return true;
      }
      AppMethodBeat.o(204358);
      return false;
    }
    if (paramFinderObject.favFlag == 1) {
      bool = true;
    }
    Object localObject = (b)this.sJQ.get(Long.valueOf(paramFinderObject.id));
    if (localObject != null) {
      bool = ((b)localObject).sJM;
    }
    String str;
    StringBuilder localStringBuilder;
    if (i.DEBUG)
    {
      str = TAG;
      localStringBuilder = new StringBuilder("isLike test ").append(paramFinderObject.id).append(" isLike:");
      localObject = (b)this.sJQ.get(Long.valueOf(paramFinderObject.id));
      if (localObject == null) {
        break label195;
      }
    }
    label195:
    for (localObject = Boolean.valueOf(((b)localObject).sJM);; localObject = null)
    {
      ad.i(str, localObject + " favFlag:" + paramFinderObject.favFlag + " result:" + bool);
      AppMethodBeat.o(204358);
      return bool;
    }
  }
  
  public final int j(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(204359);
    p.h(paramFinderObject, "feed");
    if (paramFinderObject.id == 0L)
    {
      i = paramFinderObject.favCount;
      AppMethodBeat.o(204359);
      return i;
    }
    boolean bool1;
    b localb;
    if (paramFinderObject.favFlag == 1)
    {
      bool1 = true;
      localb = (b)this.sJQ.get(Long.valueOf(paramFinderObject.id));
      if (localb == null) {
        break label105;
      }
    }
    label105:
    for (boolean bool2 = localb.sJM;; bool2 = bool1)
    {
      if ((!bool1) || (true == bool2)) {
        break label111;
      }
      i = paramFinderObject.favCount;
      AppMethodBeat.o(204359);
      return i - 1;
      bool1 = false;
      break;
    }
    label111:
    if ((!bool1) && (bool2))
    {
      i = paramFinderObject.favCount;
      AppMethodBeat.o(204359);
      return i + 1;
    }
    int i = paramFinderObject.favCount;
    AppMethodBeat.o(204359);
    return i;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/upload/action/FavActionMgr$Companion;", "", "()V", "INSTANCE", "Lcom/tencent/mm/plugin/finder/upload/action/FavActionMgr;", "getINSTANCE", "()Lcom/tencent/mm/plugin/finder/upload/action/FavActionMgr;", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/upload/action/FavActionMgr$doPost$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/finder/upload/action/FavActionTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"})
  public static final class b
    implements com.tencent.mm.loader.g.f<d>
  {
    b(e parame) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(204357);
      this.sJT.cKB();
      AppMethodBeat.o(204357);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.c
 * JD-Core Version:    0.7.0.1
 */