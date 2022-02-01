package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.api.LiveConfig.a;
import com.tencent.mm.plugin.finder.live.model.FinderLiveConfig;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s.j;
import com.tencent.mm.plugin.finder.report.live.s.p;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.plugin.i.a.ad;
import com.tencent.mm.plugin.i.a.ad.a;
import com.tencent.mm.plugin.multitask.b.c;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.taskbar.api.c.a;
import com.tencent.mm.plugin.teenmode.a.b;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.aws;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveMultiTaskHelper;", "Lcom/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper;", "context", "Landroid/content/Context;", "pageAdapter", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;)V", "getContext", "()Landroid/content/Context;", "Companion", "plugin-finder_release"})
public final class h
  extends c
{
  private static final b uzG;
  public static final a uzH;
  private final Context context;
  
  static
  {
    AppMethodBeat.i(247539);
    uzH = new a((byte)0);
    uzG = new b();
    AppMethodBeat.o(247539);
  }
  
  public h(Context paramContext, com.tencent.mm.plugin.multitask.a.a parama)
  {
    super(parama);
    AppMethodBeat.i(247538);
    this.context = paramContext;
    AppMethodBeat.o(247538);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveMultiTaskHelper$Companion;", "", "()V", "KEY_MULTI_TASK_INFO", "", "TAG", "taskBarEventListener", "com/tencent/mm/plugin/finder/live/view/FinderLiveMultiTaskHelper$Companion$taskBarEventListener$1", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveMultiTaskHelper$Companion$taskBarEventListener$1;", "startListeningTaskBarEvent", "", "stopListeningTaskBarEvent", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/view/FinderLiveMultiTaskHelper$Companion$taskBarEventListener$1", "Lcom/tencent/mm/plugin/taskbar/api/ITaskBarViewService$ITaskBarEventListener;", "onTaskBarItemClicked", "", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "onTaskBarItemExposed", "onTaskBarItemRemoved", "plugin-finder_release"})
  public static final class b
    implements c.a
  {
    public final void a(MultiTaskInfo paramMultiTaskInfo)
    {
      AppMethodBeat.i(247535);
      p.h(paramMultiTaskInfo, "multiTaskInfo");
      AppMethodBeat.o(247535);
    }
    
    public final void b(MultiTaskInfo paramMultiTaskInfo)
    {
      AppMethodBeat.i(247536);
      p.h(paramMultiTaskInfo, "multiTaskInfo");
      aws localaws = new aws();
      try
      {
        localaws.parseFrom(paramMultiTaskInfo.field_data);
        localaws.key = paramMultiTaskInfo.field_id;
        paramMultiTaskInfo = new ArrayList();
        Object localObject1 = localaws.LHu;
        p.g(localObject1, "data.allHistoryFinderObjectList");
        if (!((Collection)localObject1).isEmpty())
        {
          i = 1;
          if (i == 0) {
            break label307;
          }
          localObject1 = localaws.LHu;
          p.g(localObject1, "data.allHistoryFinderObjectList");
          Object localObject3 = (Iterable)localObject1;
          localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
          localObject3 = ((Iterable)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            FinderObject localFinderObject = (FinderObject)((Iterator)localObject3).next();
            m localm = m.vVH;
            p.g(localFinderObject, "it");
            ((Collection)localObject1).add(m.q(localFinderObject));
          }
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Log.e("FinderLiveMultiTaskHelper", "MegaVideoFloatBallInfo parse fail", new Object[] { localThrowable });
          continue;
          int i = 0;
        }
        paramMultiTaskInfo.addAll((Collection)localThrowable);
      }
      for (;;)
      {
        Object localObject2 = new FinderLiveConfig();
        if (localaws.LHu.size() > 0) {
          ((FinderLiveConfig)localObject2).uis = android.support.v4.b.a.clamp(localaws.LHt, 0, localaws.LHu.size() - 1);
        }
        ((FinderLiveConfig)localObject2).ac(paramMultiTaskInfo);
        ((FinderLiveConfig)localObject2).dLS = 1010;
        ((ad)g.af(ad.class)).a(MMApplicationContext.getContext(), localaws.hwd, (ad.a)new a(localaws, (FinderLiveConfig)localObject2));
        AppMethodBeat.o(247536);
        return;
        label307:
        localObject2 = new LiveConfig.a().qo(LiveConfig.hvU).zt(localaws.liveId).Gd(localaws.hwg).zu(localaws.hwe).Gg(localaws.hwd).Gh(localaws.desc).Gl(localaws.sessionBuffer).aBR();
        p.g(localObject2, "builder.toWhere(LiveConf…                 .build()");
        paramMultiTaskInfo.add(localObject2);
      }
    }
    
    public final void c(MultiTaskInfo paramMultiTaskInfo)
    {
      AppMethodBeat.i(247537);
      p.h(paramMultiTaskInfo, "multiTaskInfo");
      AppMethodBeat.o(247537);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "onDone"})
    static final class a
      implements ad.a
    {
      a(aws paramaws, FinderLiveConfig paramFinderLiveConfig) {}
      
      public final void mM(boolean paramBoolean)
      {
        AppMethodBeat.i(247534);
        if (!paramBoolean)
        {
          ((b)g.af(b.class)).hr(MMApplicationContext.getContext());
          AppMethodBeat.o(247534);
          return;
        }
        Object localObject1 = this.uzI.tuO;
        int i;
        k localk;
        if (localObject1 != null)
        {
          localObject1 = ((FinderObject)localObject1).liveInfo;
          if (localObject1 != null)
          {
            i = ((awe)localObject1).uBn;
            localk = k.vkd;
            localObject1 = this.uzI.tuO;
            if (localObject1 == null) {
              break label232;
            }
          }
        }
        label232:
        for (long l1 = ((FinderObject)localObject1).id;; l1 = this.uzI.hwe)
        {
          long l2 = this.uzI.liveId;
          localObject1 = this.uzI.tuO;
          if (localObject1 != null)
          {
            localObject2 = ((FinderObject)localObject1).username;
            localObject1 = localObject2;
            if (localObject2 != null) {}
          }
          else
          {
            localObject1 = this.uzI.hwd;
          }
          localk.a(l1, l2, (String)localObject1, this.uzI.LHt, i, s.p.voF, s.j.voa.scene);
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("KEY_MULTI_TASK_INFO", this.uzI.toByteArray());
          Object localObject2 = com.tencent.mm.plugin.finder.utils.a.vUU;
          localObject2 = MMApplicationContext.getContext();
          p.g(localObject2, "MMApplicationContext.getContext()");
          com.tencent.mm.plugin.finder.utils.a.a((Context)localObject2, this.uzJ, null, null, (Intent)localObject1, 12);
          AppMethodBeat.o(247534);
          return;
          i = 0;
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.h
 * JD-Core Version:    0.7.0.1
 */