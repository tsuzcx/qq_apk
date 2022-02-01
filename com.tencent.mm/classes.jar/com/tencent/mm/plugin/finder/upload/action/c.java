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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/upload/action/FavActionMgr;", "", "()V", "actionQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/finder/upload/action/FavActionTask;", "feedMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/upload/action/FavAction;", "megaVideoMap", "queue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "tryTask", "Ljava/lang/Runnable;", "doFav", "", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "like", "", "scene", "", "callback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "isLongVideo", "doPost", "action", "favCount", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "favMegaVideoCount", "megaVideo", "Lcom/tencent/mm/protocal/protobuf/MegaVideo;", "isFav", "isMegaVideoFav", "isWxScene", "removeLikeCache", "removeLongVideoLikeCache", "removeUnuseAction", "tryNext", "Companion", "KeyData", "plugin-finder_release"})
public final class c
{
  private static final String TAG = "Finder.FavActionMgr";
  private static final c vTZ;
  public static final a vUa;
  private com.tencent.mm.loader.g.d<d> vRJ;
  private final Runnable vRK;
  private final ConcurrentLinkedQueue<e> vTW;
  private final ConcurrentHashMap<Long, b> vTX;
  private final ConcurrentHashMap<Long, b> vTY;
  
  static
  {
    AppMethodBeat.i(253189);
    vUa = new a((byte)0);
    TAG = "Finder.FavActionMgr";
    vTZ = new c();
    AppMethodBeat.o(253189);
  }
  
  public c()
  {
    AppMethodBeat.i(253188);
    this.vRJ = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new a(100), new g(1, (byte)0), 1, "finder_action_fav_post_quene"));
    this.vTW = new ConcurrentLinkedQueue();
    this.vTX = new ConcurrentHashMap();
    this.vTY = new ConcurrentHashMap();
    this.vRK = ((Runnable)new c(this));
    AppMethodBeat.o(253188);
  }
  
  private final void a(final e parame)
  {
    AppMethodBeat.i(253187);
    this.vRJ.a((com.tencent.mm.loader.g.c)new d(parame), (com.tencent.mm.loader.g.f)new b(this, parame));
    AppMethodBeat.o(253187);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(253183);
    p.h(paramb, "action");
    b localb = (b)this.vTX.get(Long.valueOf(paramb.feedId));
    if (localb != null)
    {
      String str;
      StringBuilder localStringBuilder;
      if (BuildInfo.DEBUG)
      {
        str = TAG;
        localStringBuilder = new StringBuilder("removeLikeCache ").append(paramb).append(" result ");
        if (paramb.vUi < localb.vUi) {
          break label130;
        }
      }
      label130:
      for (boolean bool = true;; bool = false)
      {
        Log.i(str, bool);
        if (paramb.vUi >= localb.vUi) {
          this.vTX.remove(Long.valueOf(paramb.feedId));
        }
        AppMethodBeat.o(253183);
        return;
      }
    }
    AppMethodBeat.o(253183);
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(253184);
    p.h(paramb, "action");
    b localb = (b)this.vTY.get(Long.valueOf(paramb.feedId));
    if (localb != null)
    {
      String str;
      StringBuilder localStringBuilder;
      if (BuildInfo.DEBUG)
      {
        str = TAG;
        localStringBuilder = new StringBuilder("removeLikeCache ").append(paramb).append(" result ");
        if (paramb.vUi < localb.vUi) {
          break label130;
        }
      }
      label130:
      for (boolean bool = true;; bool = false)
      {
        Log.i(str, bool);
        if (paramb.vUi >= localb.vUi) {
          this.vTY.remove(Long.valueOf(paramb.feedId));
        }
        AppMethodBeat.o(253184);
        return;
      }
    }
    AppMethodBeat.o(253184);
  }
  
  public final void dAP()
  {
    AppMethodBeat.i(253185);
    e locale;
    boolean bool;
    do
    {
      if (this.vTW.size() <= 0)
      {
        AppMethodBeat.o(253185);
        return;
      }
      locale = (e)this.vTW.poll();
      bool = locale.isValid();
      Log.i(TAG, "tryNext isValid:" + bool + " action:" + locale + " size:" + this.vTW.size());
    } while (!bool);
    p.g(locale, "action");
    a(locale);
    AppMethodBeat.o(253185);
  }
  
  public final boolean k(FinderObject paramFinderObject)
  {
    boolean bool = false;
    AppMethodBeat.i(253181);
    p.h(paramFinderObject, "feed");
    if (paramFinderObject.id == 0L)
    {
      if (paramFinderObject.favFlag == 1)
      {
        AppMethodBeat.o(253181);
        return true;
      }
      AppMethodBeat.o(253181);
      return false;
    }
    if (paramFinderObject.favFlag == 1) {
      bool = true;
    }
    Object localObject = (b)this.vTX.get(Long.valueOf(paramFinderObject.id));
    if (localObject != null) {
      bool = ((b)localObject).vTT;
    }
    String str;
    StringBuilder localStringBuilder;
    if (BuildInfo.DEBUG)
    {
      str = TAG;
      localStringBuilder = new StringBuilder("isLike test ").append(paramFinderObject.id).append(" isLike:");
      localObject = (b)this.vTX.get(Long.valueOf(paramFinderObject.id));
      if (localObject == null) {
        break label195;
      }
    }
    label195:
    for (localObject = Boolean.valueOf(((b)localObject).vTT);; localObject = null)
    {
      Log.i(str, localObject + " favFlag:" + paramFinderObject.favFlag + " result:" + bool);
      AppMethodBeat.o(253181);
      return bool;
    }
  }
  
  public final int l(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(253182);
    p.h(paramFinderObject, "feed");
    if (paramFinderObject.id == 0L)
    {
      i = paramFinderObject.favCount;
      AppMethodBeat.o(253182);
      return i;
    }
    boolean bool1;
    b localb;
    if (paramFinderObject.favFlag == 1)
    {
      bool1 = true;
      localb = (b)this.vTX.get(Long.valueOf(paramFinderObject.id));
      if (localb == null) {
        break label105;
      }
    }
    label105:
    for (boolean bool2 = localb.vTT;; bool2 = bool1)
    {
      if ((!bool1) || (true == bool2)) {
        break label111;
      }
      i = paramFinderObject.favCount;
      AppMethodBeat.o(253182);
      return i - 1;
      bool1 = false;
      break;
    }
    label111:
    if ((!bool1) && (bool2))
    {
      i = paramFinderObject.favCount;
      AppMethodBeat.o(253182);
      return i + 1;
    }
    int i = paramFinderObject.favCount;
    AppMethodBeat.o(253182);
    return i;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/upload/action/FavActionMgr$Companion;", "", "()V", "INSTANCE", "Lcom/tencent/mm/plugin/finder/upload/action/FavActionMgr;", "getINSTANCE", "()Lcom/tencent/mm/plugin/finder/upload/action/FavActionMgr;", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/upload/action/FavActionMgr$doPost$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/finder/upload/action/FavActionTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"})
  public static final class b
    implements com.tencent.mm.loader.g.f<d>
  {
    b(e parame) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(253180);
      this.vUb.dAP();
      AppMethodBeat.o(253180);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.c
 * JD-Core Version:    0.7.0.1
 */