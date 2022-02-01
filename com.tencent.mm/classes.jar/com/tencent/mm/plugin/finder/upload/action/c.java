package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.a.a;
import com.tencent.mm.loader.g.a.g;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.h;
import d.g.b.k;
import d.l;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/upload/action/FavActionMgr;", "", "()V", "actionQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/finder/upload/action/FavActionTask;", "feedMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/upload/action/FavAction;", "queue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "tryTask", "Ljava/lang/Runnable;", "doFav", "", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "like", "", "scene", "", "callback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "doPost", "action", "favCount", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "isFav", "isWxScene", "removeLikeCache", "removeUnuseAction", "tryNext", "Companion", "KeyData", "plugin-finder_release"})
public final class c
{
  private static final String TAG = "Finder.FavActionMgr";
  private static final c rNM;
  public static final c.a rNN;
  private com.tencent.mm.loader.g.d<d> rMy;
  private final Runnable rMz;
  private final ConcurrentLinkedQueue<e> rNK;
  private final ConcurrentHashMap<Long, b> rNL;
  
  static
  {
    AppMethodBeat.i(203526);
    rNN = new c.a((byte)0);
    TAG = "Finder.FavActionMgr";
    rNM = new c();
    AppMethodBeat.o(203526);
  }
  
  public c()
  {
    AppMethodBeat.i(203525);
    this.rMy = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new a(100), new g(1, (byte)0), 1, "finder_action_fav_post_quene"));
    this.rNK = new ConcurrentLinkedQueue();
    this.rNL = new ConcurrentHashMap();
    this.rMz = ((Runnable)new c.c(this));
    AppMethodBeat.o(203525);
  }
  
  private final void a(e parame)
  {
    AppMethodBeat.i(203524);
    this.rMy.a((com.tencent.mm.loader.g.c)new d(parame), (com.tencent.mm.loader.g.f)new c.b(this, parame));
    AppMethodBeat.o(203524);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(203521);
    k.h(paramb, "action");
    b localb = (b)this.rNL.get(Long.valueOf(paramb.dig));
    if (localb != null)
    {
      String str;
      StringBuilder localStringBuilder;
      if (h.DEBUG)
      {
        str = TAG;
        localStringBuilder = new StringBuilder("removeLikeCache ").append(paramb).append(" result ");
        if (paramb.rNV < localb.rNV) {
          break label130;
        }
      }
      label130:
      for (boolean bool = true;; bool = false)
      {
        ac.i(str, bool);
        if (paramb.rNV >= localb.rNV) {
          this.rNL.remove(Long.valueOf(paramb.dig));
        }
        AppMethodBeat.o(203521);
        return;
      }
    }
    AppMethodBeat.o(203521);
  }
  
  public final void cCq()
  {
    AppMethodBeat.i(203522);
    e locale;
    boolean bool;
    do
    {
      if (this.rNK.size() <= 0)
      {
        AppMethodBeat.o(203522);
        return;
      }
      locale = (e)this.rNK.poll();
      bool = locale.isValid();
      ac.i(TAG, "tryNext isValid:" + bool + " action:" + locale + " size:" + this.rNK.size());
    } while (!bool);
    k.g(locale, "action");
    a(locale);
    AppMethodBeat.o(203522);
  }
  
  public final boolean h(FinderObject paramFinderObject)
  {
    boolean bool = false;
    AppMethodBeat.i(203519);
    k.h(paramFinderObject, "feed");
    if (paramFinderObject.id == 0L)
    {
      if (paramFinderObject.favFlag == 1)
      {
        AppMethodBeat.o(203519);
        return true;
      }
      AppMethodBeat.o(203519);
      return false;
    }
    if (paramFinderObject.favFlag == 1) {
      bool = true;
    }
    Object localObject = (b)this.rNL.get(Long.valueOf(paramFinderObject.id));
    if (localObject != null) {
      bool = ((b)localObject).rNH;
    }
    String str;
    StringBuilder localStringBuilder;
    if (h.DEBUG)
    {
      str = TAG;
      localStringBuilder = new StringBuilder("isLike test ").append(paramFinderObject.id).append(" isLike:");
      localObject = (b)this.rNL.get(Long.valueOf(paramFinderObject.id));
      if (localObject == null) {
        break label195;
      }
    }
    label195:
    for (localObject = Boolean.valueOf(((b)localObject).rNH);; localObject = null)
    {
      ac.i(str, localObject + " favFlag:" + paramFinderObject.favFlag + " result:" + bool);
      AppMethodBeat.o(203519);
      return bool;
    }
  }
  
  public final int i(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(203520);
    k.h(paramFinderObject, "feed");
    if (paramFinderObject.id == 0L)
    {
      i = paramFinderObject.favCount;
      AppMethodBeat.o(203520);
      return i;
    }
    boolean bool1;
    b localb;
    if (paramFinderObject.favFlag == 1)
    {
      bool1 = true;
      localb = (b)this.rNL.get(Long.valueOf(paramFinderObject.id));
      if (localb == null) {
        break label105;
      }
    }
    label105:
    for (boolean bool2 = localb.rNH;; bool2 = bool1)
    {
      if ((!bool1) || (true == bool2)) {
        break label111;
      }
      i = paramFinderObject.favCount;
      AppMethodBeat.o(203520);
      return i - 1;
      bool1 = false;
      break;
    }
    label111:
    if ((!bool1) && (bool2))
    {
      i = paramFinderObject.favCount;
      AppMethodBeat.o(203520);
      return i + 1;
    }
    int i = paramFinderObject.favCount;
    AppMethodBeat.o(203520);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.c
 * JD-Core Version:    0.7.0.1
 */