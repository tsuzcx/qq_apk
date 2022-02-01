package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.f.a.a;
import com.tencent.mm.loader.f.a.f;
import com.tencent.mm.loader.f.a.g;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.cgi.p;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/action/FollowActionMgr;", "", "()V", "actionQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/finder/upload/action/FollowActionTask;", "feedMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/upload/action/FollowAction;", "queue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "tryTask", "Ljava/lang/Runnable;", "doFollow", "", "finderUser", "opType", "", "feedId", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "isPrivate", "", "enterType", "participantFinderUsername", "liveReportObj", "Lcom/tencent/mm/protocal/protobuf/FinderLiveReportBaseInfo;", "doPost", "action", "isFollow", "onlyCheckFinderFollow", "ignoreOneTimeFlag", "isWaiting", "removeFollowCache", "removeUnuseAction", "tryNext", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  public static final a Gde;
  private static final i Gdf;
  private static final String TAG;
  private com.tencent.mm.loader.f.d<j> Gag;
  private final Runnable Gai;
  private final ConcurrentLinkedQueue<e> Gap;
  private final ConcurrentHashMap<String, h> GcI;
  
  static
  {
    AppMethodBeat.i(343421);
    Gde = new a((byte)0);
    TAG = "Finder.FollowActionMgr";
    Gdf = new i();
    AppMethodBeat.o(343421);
  }
  
  public i()
  {
    AppMethodBeat.i(343338);
    this.Gag = new com.tencent.mm.loader.f.d((com.tencent.mm.loader.f.a.d)new f((com.tencent.mm.loader.f.a.c)new a(100), new g(1, (byte)0), 1, "finder_action_follow_post_quene"));
    this.Gap = new ConcurrentLinkedQueue();
    this.GcI = new ConcurrentHashMap();
    this.Gai = new i..ExternalSyntheticLambda0(this);
    AppMethodBeat.o(343338);
  }
  
  private final void a(final e parame)
  {
    AppMethodBeat.i(343377);
    this.Gag.a((com.tencent.mm.loader.f.c)new j(parame), (com.tencent.mm.loader.f.e)new b(this, parame));
    AppMethodBeat.o(343377);
  }
  
  private static final void a(i parami)
  {
    AppMethodBeat.i(343387);
    s.u(parami, "this$0");
    parami.fdz();
    AppMethodBeat.o(343387);
  }
  
  public final boolean St(String paramString)
  {
    AppMethodBeat.i(343437);
    if ((paramString == null) || (s.p(paramString, "")))
    {
      AppMethodBeat.o(343437);
      return false;
    }
    Object localObject1 = com.tencent.mm.plugin.finder.api.d.AwY;
    boolean bool = d.a.St(paramString);
    localObject1 = (h)this.GcI.get(paramString);
    Object localObject2;
    if (localObject1 != null)
    {
      int i = ((h)localObject1).opType;
      localObject2 = p.AyV;
      if ((i == p.dVd()) && (((h)localObject1).Gdb)) {
        bool = true;
      }
    }
    for (;;)
    {
      Object localObject3;
      if (BuildInfo.DEBUG)
      {
        localObject2 = TAG;
        localObject3 = new StringBuilder("isWaiting test ").append(paramString).append(" optype:");
        localObject1 = (h)this.GcI.get(paramString);
        if (localObject1 != null) {
          break label197;
        }
      }
      label197:
      for (localObject1 = null;; localObject1 = Integer.valueOf(((h)localObject1).opType))
      {
        localObject1 = ((StringBuilder)localObject3).append(localObject1).append(" waitingFlag:");
        localObject3 = com.tencent.mm.plugin.finder.api.d.AwY;
        Log.i((String)localObject2, d.a.St(paramString) + " result:" + bool);
        AppMethodBeat.o(343437);
        return bool;
        bool = false;
        break;
      }
    }
  }
  
  public final void a(h paramh)
  {
    AppMethodBeat.i(343443);
    s.u(paramh, "action");
    h localh = (h)this.GcI.get(paramh.hLI);
    String str;
    StringBuilder localStringBuilder;
    if (localh != null) {
      if (BuildInfo.DEBUG)
      {
        str = TAG;
        localStringBuilder = new StringBuilder("removeFollowCache ").append(paramh).append(" result ");
        if (paramh.Gae < localh.Gae) {
          break label124;
        }
      }
    }
    label124:
    for (boolean bool = true;; bool = false)
    {
      Log.i(str, bool);
      if (paramh.Gae >= localh.Gae) {
        this.GcI.remove(paramh.hLI);
      }
      AppMethodBeat.o(343443);
      return;
    }
  }
  
  public final void fdz()
  {
    AppMethodBeat.i(343448);
    e locale;
    boolean bool;
    do
    {
      if (this.Gap.size() <= 0)
      {
        AppMethodBeat.o(343448);
        return;
      }
      locale = (e)this.Gap.poll();
      bool = locale.isValid();
      Log.i(TAG, "tryNext isValid:" + bool + " action:" + locale + " size:" + this.Gap.size());
    } while (!bool);
    s.s(locale, "action");
    a(locale);
    AppMethodBeat.o(343448);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/action/FollowActionMgr$Companion;", "", "()V", "INSTANCE", "Lcom/tencent/mm/plugin/finder/upload/action/FollowActionMgr;", "getINSTANCE", "()Lcom/tencent/mm/plugin/finder/upload/action/FollowActionMgr;", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/upload/action/FollowActionMgr$doPost$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/finder/upload/action/FollowActionTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.loader.f.e<j>
  {
    b(i parami, e parame) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.i
 * JD-Core Version:    0.7.0.1
 */