package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.a.a;
import com.tencent.mm.loader.g.a.g;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.cgi.o;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/upload/action/FollowActionMgr;", "", "()V", "actionQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/finder/upload/action/FollowActionTask;", "feedMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/upload/action/FollowAction;", "queue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "tryTask", "Ljava/lang/Runnable;", "doFollow", "", "finderUser", "opType", "", "feedId", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "isPrivate", "", "enterType", "doPost", "action", "isFollow", "isWaiting", "removeFollowCache", "removeUnuseAction", "tryNext", "Companion", "plugin-finder_release"})
public final class i
{
  private static final i ABZ;
  public static final a ACa;
  private static final String TAG = "Finder.FollowActionMgr";
  private final ConcurrentHashMap<String, h> ABA;
  private final ConcurrentLinkedQueue<e> ABz;
  private com.tencent.mm.loader.g.d<j> Azm;
  private final Runnable Azn;
  
  static
  {
    AppMethodBeat.i(276532);
    ACa = new a((byte)0);
    TAG = "Finder.FollowActionMgr";
    ABZ = new i();
    AppMethodBeat.o(276532);
  }
  
  public i()
  {
    AppMethodBeat.i(276530);
    this.Azm = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new a(100), new g(1, (byte)0), 1, "finder_action_follow_post_quene"));
    this.ABz = new ConcurrentLinkedQueue();
    this.ABA = new ConcurrentHashMap();
    this.Azn = ((Runnable)new c(this));
    AppMethodBeat.o(276530);
  }
  
  private final void a(final e parame)
  {
    AppMethodBeat.i(276528);
    this.Azm.a((com.tencent.mm.loader.g.c)new j(parame), (com.tencent.mm.loader.g.f)new b(this, parame));
    AppMethodBeat.o(276528);
  }
  
  public final void a(h paramh)
  {
    AppMethodBeat.i(276522);
    p.k(paramh, "action");
    h localh = (h)this.ABA.get(paramh.fGm);
    if (localh != null)
    {
      String str;
      StringBuilder localStringBuilder;
      if (BuildInfo.DEBUG)
      {
        str = TAG;
        localStringBuilder = new StringBuilder("removeFollowCache ").append(paramh).append(" result ");
        if (paramh.ABL < localh.ABL) {
          break label124;
        }
      }
      label124:
      for (boolean bool = true;; bool = false)
      {
        Log.i(str, bool);
        if (paramh.ABL >= localh.ABL) {
          this.ABA.remove(paramh.fGm);
        }
        AppMethodBeat.o(276522);
        return;
      }
    }
    AppMethodBeat.o(276522);
  }
  
  public final boolean aAN(String paramString)
  {
    AppMethodBeat.i(276520);
    if ((paramString == null) || (p.h(paramString, "")))
    {
      AppMethodBeat.o(276520);
      return false;
    }
    Object localObject1 = com.tencent.mm.plugin.finder.api.d.wZQ;
    boolean bool = d.a.aAN(paramString);
    localObject1 = (h)this.ABA.get(paramString);
    Object localObject2;
    Object localObject3;
    if (localObject1 != null)
    {
      int i = ((h)localObject1).opType;
      localObject2 = o.xaR;
      if ((i == o.dnA()) && (!((h)localObject1).ABX))
      {
        bool = true;
        if (BuildInfo.DEBUG)
        {
          localObject2 = TAG;
          localObject3 = new StringBuilder("isFollow test ").append(paramString).append(" optype:");
          localObject1 = (h)this.ABA.get(paramString);
          if (localObject1 == null) {
            break label208;
          }
        }
      }
    }
    label208:
    for (localObject1 = Integer.valueOf(((h)localObject1).opType);; localObject1 = null)
    {
      localObject1 = ((StringBuilder)localObject3).append(localObject1).append(" followFlag:");
      localObject3 = com.tencent.mm.plugin.finder.api.d.wZQ;
      Log.i((String)localObject2, d.a.aAN(paramString) + " result:" + bool);
      AppMethodBeat.o(276520);
      return bool;
      bool = false;
      break;
      break;
    }
  }
  
  public final boolean aAO(String paramString)
  {
    AppMethodBeat.i(276521);
    if ((paramString == null) || (p.h(paramString, "")))
    {
      AppMethodBeat.o(276521);
      return false;
    }
    Object localObject1 = com.tencent.mm.plugin.finder.api.d.wZQ;
    boolean bool = d.a.aAO(paramString);
    localObject1 = (h)this.ABA.get(paramString);
    Object localObject2;
    Object localObject3;
    if (localObject1 != null)
    {
      int i = ((h)localObject1).opType;
      localObject2 = o.xaR;
      if ((i == o.dnA()) && (((h)localObject1).ABX))
      {
        bool = true;
        if (BuildInfo.DEBUG)
        {
          localObject2 = TAG;
          localObject3 = new StringBuilder("isWaiting test ").append(paramString).append(" optype:");
          localObject1 = (h)this.ABA.get(paramString);
          if (localObject1 == null) {
            break label208;
          }
        }
      }
    }
    label208:
    for (localObject1 = Integer.valueOf(((h)localObject1).opType);; localObject1 = null)
    {
      localObject1 = ((StringBuilder)localObject3).append(localObject1).append(" waitingFlag:");
      localObject3 = com.tencent.mm.plugin.finder.api.d.wZQ;
      Log.i((String)localObject2, d.a.aAO(paramString) + " result:" + bool);
      AppMethodBeat.o(276521);
      return bool;
      bool = false;
      break;
      break;
    }
  }
  
  public final void ebY()
  {
    AppMethodBeat.i(276523);
    e locale;
    boolean bool;
    do
    {
      if (this.ABz.size() <= 0)
      {
        AppMethodBeat.o(276523);
        return;
      }
      locale = (e)this.ABz.poll();
      bool = locale.isValid();
      Log.i(TAG, "tryNext isValid:" + bool + " action:" + locale + " size:" + this.ABz.size());
    } while (!bool);
    p.j(locale, "action");
    a(locale);
    AppMethodBeat.o(276523);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/upload/action/FollowActionMgr$Companion;", "", "()V", "INSTANCE", "Lcom/tencent/mm/plugin/finder/upload/action/FollowActionMgr;", "getINSTANCE", "()Lcom/tencent/mm/plugin/finder/upload/action/FollowActionMgr;", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/upload/action/FollowActionMgr$doPost$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/finder/upload/action/FollowActionTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"})
  public static final class b
    implements com.tencent.mm.loader.g.f<j>
  {
    b(e parame) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(i parami) {}
    
    public final void run()
    {
      AppMethodBeat.i(291608);
      this.ACb.ebY();
      AppMethodBeat.o(291608);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.i
 * JD-Core Version:    0.7.0.1
 */