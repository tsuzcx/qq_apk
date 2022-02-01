package com.tencent.mm.plugin.finder.megavideo.multitask;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.feed.ui.FinderLongVideoTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLongVideoTimelineUI.a;
import com.tencent.mm.plugin.finder.megavideo.ui.f;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.ai;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.plugin.findersdk.a.ae;
import com.tencent.mm.plugin.findersdk.a.ae.a;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.taskbar.api.b.a;
import com.tencent.mm.plugin.teenmode.a.b;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aco;
import com.tencent.mm.protocal.protobuf.apw;
import com.tencent.mm.protocal.protobuf.apx;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.blj;
import com.tencent.mm.protocal.protobuf.cvy;
import com.tencent.mm.protocal.protobuf.cwj;
import com.tencent.mm.protocal.protobuf.cwl;
import com.tencent.mm.protocal.protobuf.dal;
import com.tencent.mm.protocal.protobuf.daq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/megavideo/multitask/MegaVideoMultiTaskHelper;", "Lcom/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper;", "context", "Landroid/content/Context;", "pageAdapter", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;)V", "getContext", "()Landroid/content/Context;", "isSupportExitToMultiTask", "", "()Z", "isSupportMultiTaskFBMenu", "isSupportSwipeToMultiTask", "value", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter;", "presenter", "getPresenter", "()Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter;)V", "addOrUpdateCurrentHistoryTaskInfo", "", "fillMultiTaskInfo", "hasCurrentTaskBarInfo", "isSupportSwipeToHome", "onClose", "way", "", "ended", "onMenuMultiTaskSelected", "enterMultiTask", "onSwipePageAddToMultiTask", "reportAddToMultiTask", "isFromSwipe", "Companion", "plugin-finder_release"})
public final class a
  extends com.tencent.mm.plugin.multitask.b.c
{
  private static final b zwW;
  public static final a zwX;
  private final Context context;
  public f zvV;
  
  static
  {
    AppMethodBeat.i(221999);
    zwX = new a((byte)0);
    zwW = new b();
    AppMethodBeat.o(221999);
  }
  
  public a(Context paramContext, com.tencent.mm.plugin.multitask.a.a parama)
  {
    super(parama);
    AppMethodBeat.i(221998);
    this.context = paramContext;
    AppMethodBeat.o(221998);
  }
  
  private final void pO(boolean paramBoolean)
  {
    long l2 = 0L;
    i = 1;
    AppMethodBeat.i(221997);
    localObject3 = new cwl();
    for (;;)
    {
      try
      {
        localObject1 = this.FHd;
        if (localObject1 == null) {
          continue;
        }
        localObject1 = ((MultiTaskInfo)localObject1).field_data;
        ((cwl)localObject3).parseFrom((byte[])localObject1);
      }
      catch (Throwable localThrowable)
      {
        Object localObject1;
        Object localObject4;
        long l3;
        String str2;
        Object localObject5;
        String str1;
        Log.e("MegaVideoFloatBallHelper", "handleBallInfoClicked", new Object[] { localThrowable });
        continue;
        Object localObject2 = null;
        continue;
        localObject3 = null;
        continue;
        i = 3;
        continue;
        long l1 = 0L;
        continue;
      }
      localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
      localObject1 = aj.a.fZ(this.context);
      if (localObject1 == null) {
        continue;
      }
      localObject1 = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject1).ekY();
      localObject4 = ((cwl)localObject3).TFk;
      p.j(localObject4, "floatBallInfo.cacheNewVideoList");
      localObject3 = (FinderObject)j.M((List)localObject4, ((cwl)localObject3).TFh);
      if (localObject3 == null) {
        continue;
      }
      localObject3 = ((FinderObject)localObject3).attachmentList;
      if (localObject3 == null) {
        continue;
      }
      localObject3 = ((apx)localObject3).SDm;
      if (localObject3 == null) {
        continue;
      }
      localObject3 = (apw)j.lp((List)localObject3);
      if (localObject3 == null) {
        continue;
      }
      localObject3 = ((apw)localObject3).SDl;
      if (localObject3 == null) {
        continue;
      }
      localObject3 = ((blj)localObject3).SPm;
      localObject4 = ai.zZt;
      l3 = cm.bfE();
      if (!paramBoolean) {
        continue;
      }
      if (localObject3 == null) {
        continue;
      }
      l1 = ((cvy)localObject3).id;
      str2 = d.Fw(l1);
      if (localObject1 != null)
      {
        localObject5 = ((bid)localObject1).sessionId;
        localObject4 = localObject5;
        if (localObject5 != null) {}
      }
      else
      {
        localObject4 = "";
      }
      if (localObject1 != null)
      {
        str1 = ((bid)localObject1).wmL;
        localObject5 = str1;
        if (str1 != null) {}
      }
      else
      {
        localObject5 = "";
      }
      if (localObject1 != null)
      {
        str1 = ((bid)localObject1).wmz;
        localObject1 = str1;
        if (str1 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      l1 = l2;
      if (localObject3 != null)
      {
        localObject3 = ((cvy)localObject3).TEO;
        l1 = l2;
        if (localObject3 != null) {
          l1 = ((cwj)localObject3).xbk;
        }
      }
      ai.a(l3, i, 0, str2, "", (String)localObject4, (String)localObject5, (String)localObject1, d.Fw(l1));
      AppMethodBeat.o(221997);
      return;
      localObject1 = null;
    }
  }
  
  public final boolean Q(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(221984);
    paramBoolean = super.Q(paramInt, paramBoolean);
    AppMethodBeat.o(221984);
    return paramBoolean;
  }
  
  public final boolean cbG()
  {
    return true;
  }
  
  public final boolean cbH()
  {
    return true;
  }
  
  public final boolean cbJ()
  {
    return true;
  }
  
  public final void cbL()
  {
    AppMethodBeat.i(221978);
    f localf = this.zvV;
    if (localf != null)
    {
      localf.X(true, true);
      AppMethodBeat.o(221978);
      return;
    }
    AppMethodBeat.o(221978);
  }
  
  public final boolean dJN()
  {
    return true;
  }
  
  public final void dJO()
  {
    AppMethodBeat.i(221987);
    com.tencent.e.h.ZvG.bf((Runnable)new c(this));
    AppMethodBeat.o(221987);
  }
  
  public final void dJP()
  {
    AppMethodBeat.i(221992);
    pO(true);
    AppMethodBeat.o(221992);
  }
  
  public final void iW(boolean paramBoolean)
  {
    AppMethodBeat.i(221990);
    super.iW(paramBoolean);
    if (paramBoolean) {
      pO(false);
    }
    AppMethodBeat.o(221990);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/megavideo/multitask/MegaVideoMultiTaskHelper$Companion;", "", "()V", "TAG", "", "taskBarEventListener", "com/tencent/mm/plugin/finder/megavideo/multitask/MegaVideoMultiTaskHelper$Companion$taskBarEventListener$1", "Lcom/tencent/mm/plugin/finder/megavideo/multitask/MegaVideoMultiTaskHelper$Companion$taskBarEventListener$1;", "handleClickMultiTask", "", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "animateData", "Lcom/tencent/mm/protocal/protobuf/MultiTaskAnimData;", "isFromMultiTask", "", "activity", "Landroid/app/Activity;", "startListeningTaskBarEvent", "stopListeningTaskBarEvent", "plugin-finder_release"})
  public static final class a
  {
    public static void a(final MultiTaskInfo paramMultiTaskInfo, final dal paramdal, boolean paramBoolean, final Activity paramActivity)
    {
      AppMethodBeat.i(269114);
      p.k(paramMultiTaskInfo, "multiTaskInfo");
      final cwl localcwl = new cwl();
      final Intent localIntent;
      Object localObject3;
      Object localObject4;
      Object localObject5;
      Object localObject2;
      try
      {
        localcwl.parseFrom(paramMultiTaskInfo.field_data);
        localIntent = new Intent();
        Object localObject1 = localcwl.TFk;
        p.j(localObject1, "data.cacheNewVideoList");
        if (j.M((List)localObject1, localcwl.TFh) == null)
        {
          Log.e("MegaVideoMultiTaskHelper", "onTaskBarItemClicked: currVideoPos item is null pos = " + localcwl.TFh);
          localcwl.TFh = 0;
        }
        localcwl.key = paramMultiTaskInfo.field_id;
        localObject1 = localcwl.TFk;
        p.j(localObject1, "data.cacheNewVideoList");
        localObject3 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (FinderObject)((Iterator)localObject3).next();
          localObject5 = FinderItem.Companion;
          p.j(localObject4, "it");
          localObject4 = FinderItem.a.b((FinderObject)localObject4, 1);
          localObject5 = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
          ((Collection)localObject1).add(c.a.a((FinderItem)localObject4));
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Log.e("MegaVideoMultiTaskHelper", "MegaVideoFloatBallInfo parse fail", new Object[] { localThrowable });
        }
        localObject2 = (BaseFinderFeed)j.M((List)localThrowable, localcwl.TFh);
        if (localObject2 != null)
        {
          localObject3 = j.listOf(localObject2);
          localObject2 = localObject3;
          if (localObject3 != null) {}
        }
        else
        {
          localObject2 = (List)new LinkedList();
        }
        localObject4 = (ae)com.tencent.mm.kernel.h.ae(ae.class);
        localObject5 = MMApplicationContext.getContext();
        localObject3 = (BaseFinderFeed)j.lp((List)localObject2);
        if (localObject3 != null)
        {
          localObject3 = ((BaseFinderFeed)localObject3).feedObject;
          if (localObject3 != null)
          {
            localObject3 = ((FinderItem)localObject3).getUserName();
            if (localObject3 != null) {
              break label388;
            }
          }
        }
        localObject3 = "";
      }
      label388:
      for (;;)
      {
        ((ae)localObject4).a((Context)localObject5, (String)localObject3, (ae.a)new a(paramBoolean, (List)localObject2, localcwl, localIntent, paramMultiTaskInfo, paramdal, paramActivity));
        AppMethodBeat.o(269114);
        return;
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "onDone"})
    static final class a
      implements ae.a
    {
      a(boolean paramBoolean, List paramList, cwl paramcwl, Intent paramIntent, MultiTaskInfo paramMultiTaskInfo, dal paramdal, Activity paramActivity) {}
      
      public final void oa(boolean paramBoolean)
      {
        boolean bool = true;
        AppMethodBeat.i(284853);
        if (!paramBoolean)
        {
          if (this.zwY) {
            d.a(2000L, (kotlin.g.a.a)1.zxc);
          }
          ((b)com.tencent.mm.kernel.h.ae(b.class)).ir(MMApplicationContext.getContext());
          AppMethodBeat.o(284853);
          return;
        }
        Object localObject1 = (BaseFinderFeed)j.lp(this.xiE);
        if (localObject1 != null)
        {
          if (localcwl.TFl > System.currentTimeMillis())
          {
            localObject2 = com.tencent.mm.plugin.finder.utils.aj.AGc;
            com.tencent.mm.plugin.finder.utils.aj.a(localcwl.TFh, this.xiE, localcwl.lastBuffer, localIntent);
          }
          localIntent.putExtra("KEY_CACHE_OBJECT_ID", ((BaseFinderFeed)localObject1).feedObject.getId());
          localIntent.putExtra("KEY_CACHE_OBJECT_NONCE_ID", ((BaseFinderFeed)localObject1).feedObject.getObjectNonceId());
        }
        localIntent.putExtra("KEY_ROUTER_UI", 0);
        localIntent.putExtra("KEY_FLOAT_BALL_INFO", localcwl.toByteArray());
        localIntent.putExtra("KEY_VIDEO_START_PLAY_TIME_MS", localcwl.TFi * 1000L);
        localObject1 = localIntent;
        Object localObject2 = com.tencent.mm.plugin.multitask.h.FFb;
        ((Intent)localObject1).putExtra("KEY_VIDEO_THUMB_LOCAL_PATH", com.tencent.mm.plugin.multitask.h.g(paramMultiTaskInfo));
        if (paramdal != null)
        {
          localObject2 = new aco();
          ((aco)localObject2).Soh = paramdal;
          if (this.zwY) {
            break label508;
          }
          paramBoolean = true;
          ((aco)localObject2).Soi = paramBoolean;
          localObject1 = paramActivity;
          if (localObject1 != null)
          {
            com.tencent.mm.plugin.secdata.ui.a.a locala = com.tencent.mm.plugin.secdata.ui.a.JbV;
            localObject1 = com.tencent.mm.plugin.secdata.ui.a.a.hU((Context)localObject1);
            if (localObject1 == null) {
              break label513;
            }
            localObject1 = (daq)((com.tencent.mm.plugin.secdata.ui.a)localObject1).aef(5);
            label308:
            if (localObject1 == null) {
              break label519;
            }
            localObject1 = ((daq)localObject1).wmL;
            label320:
            ((aco)localObject2).wmL = ((String)localObject1);
          }
          if (localIntent.putExtra("key_multi_task_common_info", ((aco)localObject2).toByteArray()) != null) {}
        }
        else
        {
          localObject1 = a.zwX;
          localObject1 = new aco();
          if (this.zwY) {
            break label525;
          }
          paramBoolean = bool;
          label368:
          ((aco)localObject1).Soi = paramBoolean;
          localIntent.putExtra("key_multi_task_common_info", ((aco)localObject1).toByteArray());
        }
        localIntent.addFlags(536870912);
        localObject1 = FinderLongVideoTimelineUI.xQK;
        int j = FinderLongVideoTimelineUI.a.MP(0);
        localObject1 = (ak)com.tencent.mm.kernel.h.ag(ak.class);
        int i;
        if (this.zwY)
        {
          i = 18;
          label430:
          ((ak)localObject1).fillContextIdToIntent(i, 2, j, localIntent);
          localObject1 = com.tencent.mm.plugin.finder.utils.a.ACH;
          localObject1 = paramActivity;
          if (localObject1 == null) {
            break label536;
          }
          localObject1 = (Context)localObject1;
        }
        for (;;)
        {
          com.tencent.mm.plugin.finder.utils.a.an((Context)localObject1, localIntent);
          if (!this.zwY) {
            break label552;
          }
          localObject1 = paramActivity;
          if (localObject1 == null) {
            break label552;
          }
          ((Activity)localObject1).overridePendingTransition(0, 0);
          AppMethodBeat.o(284853);
          return;
          label508:
          paramBoolean = false;
          break;
          label513:
          localObject1 = null;
          break label308;
          label519:
          localObject1 = null;
          break label320;
          label525:
          paramBoolean = false;
          break label368;
          i = 17;
          break label430;
          label536:
          localObject1 = MMApplicationContext.getContext();
          p.j(localObject1, "MMApplicationContext.getContext()");
        }
        label552:
        AppMethodBeat.o(284853);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/megavideo/multitask/MegaVideoMultiTaskHelper$Companion$taskBarEventListener$1", "Lcom/tencent/mm/plugin/taskbar/api/ITaskBarViewService$ITaskBarEventListener;", "onTaskBarItemClicked", "", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "onTaskBarItemExposed", "onTaskBarItemRemoved", "plugin-finder_release"})
  public static final class b
    implements b.a
  {
    public final void a(MultiTaskInfo paramMultiTaskInfo)
    {
      AppMethodBeat.i(288548);
      p.k(paramMultiTaskInfo, "multiTaskInfo");
      AppMethodBeat.o(288548);
    }
    
    public final void b(MultiTaskInfo paramMultiTaskInfo)
    {
      AppMethodBeat.i(288549);
      p.k(paramMultiTaskInfo, "multiTaskInfo");
      a.a locala = a.zwX;
      a.a.a(paramMultiTaskInfo, null, false, null);
      AppMethodBeat.o(288549);
    }
    
    public final void c(MultiTaskInfo paramMultiTaskInfo)
    {
      AppMethodBeat.i(288550);
      p.k(paramMultiTaskInfo, "multiTaskInfo");
      AppMethodBeat.o(288550);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(274319);
      a locala1 = this.zxd;
      a locala2 = this.zxd;
      Object localObject = a.a(this.zxd);
      if (localObject != null) {}
      for (localObject = ((com.tencent.mm.plugin.multitask.a.a)localObject).getBitmap();; localObject = null)
      {
        locala1.ag(locala2.ae((Bitmap)localObject));
        AppMethodBeat.o(274319);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.multitask.a
 * JD-Core Version:    0.7.0.1
 */