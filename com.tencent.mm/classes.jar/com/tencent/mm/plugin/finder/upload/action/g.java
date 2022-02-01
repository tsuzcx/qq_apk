package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.a.a;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.cgi.bb;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/upload/action/FollowActionMgr;", "", "()V", "actionQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/finder/upload/action/FollowActionTask;", "feedMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/upload/action/FollowAction;", "queue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "tryTask", "Ljava/lang/Runnable;", "doFollow", "", "finderUser", "opType", "", "feedId", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "isPrivate", "", "doPost", "action", "isFollow", "isWaiting", "removeFollowCache", "removeUnuseAction", "tryNext", "Companion", "plugin-finder_release"})
public final class g
{
  public static final String TAG = "Finder.FollowActionMgr";
  private static final g vUm;
  public static final a vUn;
  private com.tencent.mm.loader.g.d<h> vRJ;
  private final Runnable vRK;
  private final ConcurrentLinkedQueue<e> vTW;
  public final ConcurrentHashMap<String, f> vTX;
  
  static
  {
    AppMethodBeat.i(253209);
    vUn = new a((byte)0);
    TAG = "Finder.FollowActionMgr";
    vUm = new g();
    AppMethodBeat.o(253209);
  }
  
  public g()
  {
    AppMethodBeat.i(253208);
    this.vRJ = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new a(100), new com.tencent.mm.loader.g.a.g(1, (byte)0), 1, "finder_action_follow_post_quene"));
    this.vTW = new ConcurrentLinkedQueue();
    this.vTX = new ConcurrentHashMap();
    this.vRK = ((Runnable)new c(this));
    AppMethodBeat.o(253208);
  }
  
  public final void a(final e parame)
  {
    AppMethodBeat.i(253207);
    this.vRJ.a((com.tencent.mm.loader.g.c)new h(parame), (com.tencent.mm.loader.g.f)new b(this, parame));
    AppMethodBeat.o(253207);
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(253205);
    p.h(paramf, "action");
    f localf = (f)this.vTX.get(paramf.dNc);
    if (localf != null)
    {
      String str;
      StringBuilder localStringBuilder;
      if (BuildInfo.DEBUG)
      {
        str = TAG;
        localStringBuilder = new StringBuilder("removeFollowCache ").append(paramf).append(" result ");
        if (paramf.vUi < localf.vUi) {
          break label119;
        }
      }
      label119:
      for (boolean bool = true;; bool = false)
      {
        Log.i(str, bool);
        if (paramf.vUi >= localf.vUi) {
          this.vTX.remove(paramf.dNc);
        }
        AppMethodBeat.o(253205);
        return;
      }
    }
    AppMethodBeat.o(253205);
  }
  
  public final boolean asJ(String paramString)
  {
    AppMethodBeat.i(253203);
    if ((paramString == null) || (p.j(paramString, "")))
    {
      AppMethodBeat.o(253203);
      return false;
    }
    Object localObject1 = com.tencent.mm.plugin.finder.api.c.tsp;
    boolean bool = c.a.asJ(paramString);
    localObject1 = (f)this.vTX.get(paramString);
    Object localObject2;
    Object localObject3;
    if (localObject1 != null)
    {
      int i = ((f)localObject1).opType;
      localObject2 = bb.tve;
      if ((i == bb.cYi()) && (!((f)localObject1).vUk))
      {
        bool = true;
        if (BuildInfo.DEBUG)
        {
          localObject2 = TAG;
          localObject3 = new StringBuilder("isFollow test ").append(paramString).append(" optype:");
          localObject1 = (f)this.vTX.get(paramString);
          if (localObject1 == null) {
            break label208;
          }
        }
      }
    }
    label208:
    for (localObject1 = Integer.valueOf(((f)localObject1).opType);; localObject1 = null)
    {
      localObject1 = ((StringBuilder)localObject3).append(localObject1).append(" followFlag:");
      localObject3 = com.tencent.mm.plugin.finder.api.c.tsp;
      Log.i((String)localObject2, c.a.asJ(paramString) + " result:" + bool);
      AppMethodBeat.o(253203);
      return bool;
      bool = false;
      break;
      break;
    }
  }
  
  public final boolean asK(String paramString)
  {
    AppMethodBeat.i(253204);
    if ((paramString == null) || (p.j(paramString, "")))
    {
      AppMethodBeat.o(253204);
      return false;
    }
    Object localObject1 = com.tencent.mm.plugin.finder.api.c.tsp;
    boolean bool = c.a.asK(paramString);
    localObject1 = (f)this.vTX.get(paramString);
    Object localObject2;
    Object localObject3;
    if (localObject1 != null)
    {
      int i = ((f)localObject1).opType;
      localObject2 = bb.tve;
      if ((i == bb.cYi()) && (((f)localObject1).vUk))
      {
        bool = true;
        if (BuildInfo.DEBUG)
        {
          localObject2 = TAG;
          localObject3 = new StringBuilder("isWaiting test ").append(paramString).append(" optype:");
          localObject1 = (f)this.vTX.get(paramString);
          if (localObject1 == null) {
            break label208;
          }
        }
      }
    }
    label208:
    for (localObject1 = Integer.valueOf(((f)localObject1).opType);; localObject1 = null)
    {
      localObject1 = ((StringBuilder)localObject3).append(localObject1).append(" waitingFlag:");
      localObject3 = com.tencent.mm.plugin.finder.api.c.tsp;
      Log.i((String)localObject2, c.a.asK(paramString) + " result:" + bool);
      AppMethodBeat.o(253204);
      return bool;
      bool = false;
      break;
      break;
    }
  }
  
  public final void dAP()
  {
    AppMethodBeat.i(253206);
    e locale;
    boolean bool;
    do
    {
      if (this.vTW.size() <= 0)
      {
        AppMethodBeat.o(253206);
        return;
      }
      locale = (e)this.vTW.poll();
      bool = locale.isValid();
      Log.i(TAG, "tryNext isValid:" + bool + " action:" + locale + " size:" + this.vTW.size());
    } while (!bool);
    p.g(locale, "action");
    a(locale);
    AppMethodBeat.o(253206);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/upload/action/FollowActionMgr$Companion;", "", "()V", "INSTANCE", "Lcom/tencent/mm/plugin/finder/upload/action/FollowActionMgr;", "getINSTANCE", "()Lcom/tencent/mm/plugin/finder/upload/action/FollowActionMgr;", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/upload/action/FollowActionMgr$doPost$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/finder/upload/action/FollowActionTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"})
  public static final class b
    implements com.tencent.mm.loader.g.f<h>
  {
    b(e parame) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(g paramg) {}
    
    public final void run()
    {
      AppMethodBeat.i(253202);
      this.vUo.dAP();
      AppMethodBeat.o(253202);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.g
 * JD-Core Version:    0.7.0.1
 */