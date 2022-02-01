package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.api.LiveConfig.a;
import com.tencent.mm.live.core.core.e.b;
import com.tencent.mm.plugin.finder.live.model.FinderLiveBundle;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.s.l;
import com.tencent.mm.plugin.finder.live.report.s.t;
import com.tencent.mm.plugin.findersdk.a.ae;
import com.tencent.mm.plugin.findersdk.a.ae.a;
import com.tencent.mm.plugin.multitask.b.c;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.taskbar.api.b.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bbf;
import com.tencent.mm.protocal.protobuf.bch;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveMultiTaskHelper;", "Lcom/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper;", "context", "Landroid/content/Context;", "pageAdapter", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;)V", "getContext", "()Landroid/content/Context;", "Companion", "plugin-finder_release"})
public final class d
  extends c
{
  private static final b yVl;
  public static final a yVm;
  private final Context context;
  
  static
  {
    AppMethodBeat.i(291403);
    yVm = new a((byte)0);
    yVl = new b();
    AppMethodBeat.o(291403);
  }
  
  public d(Context paramContext, com.tencent.mm.plugin.multitask.a.a parama)
  {
    super(parama);
    AppMethodBeat.i(291402);
    this.context = paramContext;
    AppMethodBeat.o(291402);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveMultiTaskHelper$Companion;", "", "()V", "KEY_MULTI_TASK_INFO", "", "TAG", "taskBarEventListener", "com/tencent/mm/plugin/finder/live/view/FinderLiveMultiTaskHelper$Companion$taskBarEventListener$1", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveMultiTaskHelper$Companion$taskBarEventListener$1;", "startListeningTaskBarEvent", "", "stopListeningTaskBarEvent", "plugin-finder_release"})
  public static final class a
  {
    public static void dFh()
    {
      AppMethodBeat.i(276607);
      ((com.tencent.mm.plugin.taskbar.api.b)h.ae(com.tencent.mm.plugin.taskbar.api.b.class)).a(21, (b.a)d.dFg());
      AppMethodBeat.o(276607);
    }
    
    public static void dFi()
    {
      AppMethodBeat.i(276608);
      ((com.tencent.mm.plugin.taskbar.api.b)h.ae(com.tencent.mm.plugin.taskbar.api.b.class)).b(21, (b.a)d.dFg());
      AppMethodBeat.o(276608);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/view/FinderLiveMultiTaskHelper$Companion$taskBarEventListener$1", "Lcom/tencent/mm/plugin/taskbar/api/ITaskBarViewService$ITaskBarEventListener;", "onTaskBarItemClicked", "", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "onTaskBarItemExposed", "onTaskBarItemRemoved", "plugin-finder_release"})
  public static final class b
    implements b.a
  {
    public final void a(MultiTaskInfo paramMultiTaskInfo)
    {
      AppMethodBeat.i(288687);
      p.k(paramMultiTaskInfo, "multiTaskInfo");
      AppMethodBeat.o(288687);
    }
    
    public final void b(MultiTaskInfo paramMultiTaskInfo)
    {
      Object localObject2 = null;
      AppMethodBeat.i(288688);
      p.k(paramMultiTaskInfo, "multiTaskInfo");
      bbf localbbf = new bbf();
      ArrayList localArrayList;
      Object localObject1;
      Object localObject3;
      try
      {
        localbbf.parseFrom(paramMultiTaskInfo.field_data);
        localbbf.key = paramMultiTaskInfo.field_id;
        if (p.h(localbbf.key, "wedraw"))
        {
          AppMethodBeat.o(288688);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Log.e("FinderLiveMultiTaskHelper", "MegaVideoFloatBallInfo parse fail", new Object[] { localThrowable });
        }
        localArrayList = new ArrayList();
        paramMultiTaskInfo = localbbf.SMS;
        p.j(paramMultiTaskInfo, "data.allHistoryFinderObjectList");
        if (!((Collection)paramMultiTaskInfo).isEmpty()) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label400;
          }
          paramMultiTaskInfo = localbbf.SMS;
          p.j(paramMultiTaskInfo, "data.allHistoryFinderObjectList");
          localObject1 = (Iterable)paramMultiTaskInfo;
          paramMultiTaskInfo = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (FinderObject)((Iterator)localObject1).next();
            localObject3 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
            p.j(localObject2, "it");
            paramMultiTaskInfo.add(com.tencent.mm.plugin.finder.live.utils.a.a((FinderObject)localObject2, 0, false, 6));
          }
        }
        localArrayList.addAll((Collection)paramMultiTaskInfo);
      }
      localObject2 = new FinderLiveBundle();
      if (localbbf.SMS.size() > 0) {
        ((FinderLiveBundle)localObject2).yeA = androidx.core.b.a.clamp(localbbf.SMR, 0, localbbf.SMS.size() - 1);
      }
      ((FinderLiveBundle)localObject2).ae(localArrayList);
      ((FinderLiveBundle)localObject2).fEH = 1010;
      paramMultiTaskInfo = localbbf.xcx;
      if (paramMultiTaskInfo != null)
      {
        localObject1 = paramMultiTaskInfo.nickname;
        paramMultiTaskInfo = (MultiTaskInfo)localObject1;
        if (localObject1 != null) {}
      }
      else
      {
        paramMultiTaskInfo = "";
      }
      ((FinderLiveBundle)localObject2).aCa(paramMultiTaskInfo);
      paramMultiTaskInfo = localbbf.xcx;
      if (paramMultiTaskInfo != null)
      {
        paramMultiTaskInfo = paramMultiTaskInfo.liveInfo;
        if (paramMultiTaskInfo == null) {}
      }
      for (int i = paramMultiTaskInfo.SLO;; i = 0)
      {
        ((FinderLiveBundle)localObject2).extFlag = i;
        ((ae)h.ae(ae.class)).a(MMApplicationContext.getContext(), localbbf.kig, (ae.a)new a(localbbf, (FinderLiveBundle)localObject2));
        AppMethodBeat.o(288688);
        return;
        label400:
        localObject3 = new LiveConfig.a();
        paramMultiTaskInfo = localbbf.xcx;
        int j;
        label438:
        label478:
        StringBuilder localStringBuilder;
        if (paramMultiTaskInfo != null)
        {
          paramMultiTaskInfo = paramMultiTaskInfo.liveInfo;
          if ((paramMultiTaskInfo != null) && (paramMultiTaskInfo.liveStatus == 1))
          {
            j = 1;
            if (j != 0)
            {
              paramMultiTaskInfo = localbbf.xcx;
              if (paramMultiTaskInfo != null)
              {
                paramMultiTaskInfo = paramMultiTaskInfo.liveInfo;
                if (paramMultiTaskInfo != null)
                {
                  localObject1 = paramMultiTaskInfo.kih;
                  paramMultiTaskInfo = (MultiTaskInfo)localObject1;
                  if (localObject1 != null) {
                    break label478;
                  }
                }
              }
            }
            paramMultiTaskInfo = "";
            p.j(paramMultiTaskInfo, "if (living) (data.finder….streamUrl ?: \"\") else \"\"");
            if (j == 0) {
              break label731;
            }
            localObject1 = localbbf.xcx;
            if (localObject1 == null) {
              break label719;
            }
            localObject1 = ((FinderObject)localObject1).liveInfo;
            if (localObject1 == null) {
              break label719;
            }
            localObject1 = ((bac)localObject1).SLN;
            if (localObject1 == null) {
              break label719;
            }
            i = ((bch)localObject1).kmi;
            label530:
            if (j == 0)
            {
              localStringBuilder = new StringBuilder("onTaskBarItemClicked liveId:");
              localObject1 = localbbf.xcx.liveInfo;
              if (localObject1 == null) {
                break label736;
              }
            }
          }
        }
        label719:
        label731:
        label736:
        for (localObject1 = Long.valueOf(((bac)localObject1).liveId);; localObject1 = null)
        {
          localStringBuilder = localStringBuilder.append(localObject1).append(",liveStatus:");
          FinderContact localFinderContact = localbbf.xcx.contact;
          localObject1 = localObject2;
          if (localFinderContact != null) {
            localObject1 = Integer.valueOf(localFinderContact.liveStatus);
          }
          Log.i("FinderLiveMultiTaskHelper", localObject1);
          paramMultiTaskInfo = ((LiveConfig.a)localObject3).sP(LiveConfig.khX).Fx(localbbf.liveId).Nf(localbbf.nonceId).Fy(localbbf.kik).Nj(paramMultiTaskInfo).sQ(i).Ni(localbbf.kig).Nk(localbbf.desc).No(localbbf.sessionBuffer).aJw();
          p.j(paramMultiTaskInfo, "builder.toWhere(LiveConf…                 .build()");
          localArrayList.add(paramMultiTaskInfo);
          break;
          j = 0;
          break label438;
          localObject1 = e.b.kjz;
          i = e.b.aJK();
          break label530;
          i = 0;
          break label530;
        }
      }
    }
    
    public final void c(MultiTaskInfo paramMultiTaskInfo)
    {
      AppMethodBeat.i(288689);
      p.k(paramMultiTaskInfo, "multiTaskInfo");
      if (p.h(paramMultiTaskInfo.field_id, "wedraw"))
      {
        AppMethodBeat.o(288689);
        return;
      }
      AppMethodBeat.o(288689);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "onDone"})
    static final class a
      implements ae.a
    {
      a(bbf parambbf, FinderLiveBundle paramFinderLiveBundle) {}
      
      public final void oa(boolean paramBoolean)
      {
        AppMethodBeat.i(285932);
        if (!paramBoolean)
        {
          ((com.tencent.mm.plugin.teenmode.a.b)h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).ir(MMApplicationContext.getContext());
          AppMethodBeat.o(285932);
          return;
        }
        Object localObject1 = this.yVn.xcx;
        int i;
        k localk;
        if (localObject1 != null)
        {
          localObject1 = ((FinderObject)localObject1).liveInfo;
          if (localObject1 != null)
          {
            i = ((bac)localObject1).yYz;
            localk = k.yBj;
            localObject1 = this.yVn.xcx;
            if (localObject1 == null) {
              break label233;
            }
          }
        }
        label233:
        for (long l1 = ((FinderObject)localObject1).id;; l1 = this.yVn.kik)
        {
          long l2 = this.yVn.liveId;
          localObject1 = this.yVn.xcx;
          if (localObject1 != null)
          {
            localObject2 = ((FinderObject)localObject1).username;
            localObject1 = localObject2;
            if (localObject2 != null) {}
          }
          else
          {
            localObject1 = this.yVn.kig;
          }
          k.a(localk, l1, l2, (String)localObject1, this.yVn.SMR, i, s.t.yGS, s.l.yGc.scene);
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("KEY_MULTI_TASK_INFO", this.yVn.toByteArray());
          Object localObject2 = com.tencent.mm.plugin.finder.utils.a.ACH;
          localObject2 = MMApplicationContext.getContext();
          p.j(localObject2, "MMApplicationContext.getContext()");
          com.tencent.mm.plugin.finder.utils.a.a((Context)localObject2, this.yVo, null, null, (Intent)localObject1, 12);
          AppMethodBeat.o(285932);
          return;
          i = 0;
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.d
 * JD-Core Version:    0.7.0.1
 */