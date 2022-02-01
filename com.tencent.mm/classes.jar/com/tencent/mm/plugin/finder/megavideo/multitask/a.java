package com.tencent.mm.plugin.finder.megavideo.multitask;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.feed.ui.FinderLongVideoTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLongVideoTimelineUI.a;
import com.tencent.mm.plugin.finder.megavideo.ui.f;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.plugin.finder.report.af;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.i.a.ad;
import com.tencent.mm.plugin.i.a.ad.a;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.multitask.b.c;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC.a;
import com.tencent.mm.plugin.taskbar.api.c.a;
import com.tencent.mm.plugin.teenmode.a.b;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ach;
import com.tencent.mm.protocal.protobuf.aop;
import com.tencent.mm.protocal.protobuf.aoq;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bei;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.protocal.protobuf.cns;
import com.tencent.mm.protocal.protobuf.cnu;
import com.tencent.mm.protocal.protobuf.crq;
import com.tencent.mm.protocal.protobuf.crt;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/multitask/MegaVideoMultiTaskHelper;", "Lcom/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper;", "context", "Landroid/content/Context;", "pageAdapter", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;)V", "getContext", "()Landroid/content/Context;", "isSupportExitToMultiTask", "", "()Z", "isSupportMultiTaskFBMenu", "isSupportSwipeToMultiTask", "value", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter;", "presenter", "getPresenter", "()Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter;)V", "addOrUpdateCurrentHistoryTaskInfo", "", "fillMultiTaskInfo", "hasCurrentTaskBarInfo", "isSupportSwipeToHome", "onClose", "way", "", "ended", "onMenuMultiTaskSelected", "enterMultiTask", "onSwipePageAddToMultiTask", "reportAddToMultiTask", "isFromSwipe", "Companion", "plugin-finder_release"})
public final class a
  extends c
{
  private static final b uLv;
  public static final a uLw;
  private final Context context;
  public f uKk;
  
  static
  {
    AppMethodBeat.i(248458);
    uLw = new a((byte)0);
    uLv = new b();
    AppMethodBeat.o(248458);
  }
  
  public a(Context paramContext, com.tencent.mm.plugin.multitask.a.a parama)
  {
    super(parama);
    AppMethodBeat.i(248457);
    this.context = paramContext;
    AppMethodBeat.o(248457);
  }
  
  private final void nH(boolean paramBoolean)
  {
    long l2 = 0L;
    i = 1;
    AppMethodBeat.i(248456);
    localObject3 = new cnu();
    for (;;)
    {
      try
      {
        localObject1 = this.Abp;
        if (localObject1 == null) {
          continue;
        }
        localObject1 = ((MultiTaskInfo)localObject1).field_data;
        ((cnu)localObject3).parseFrom((byte[])localObject1);
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
      localObject1 = FinderReporterUIC.wzC;
      localObject1 = FinderReporterUIC.a.fH(this.context);
      if (localObject1 == null) {
        continue;
      }
      localObject1 = ((FinderReporterUIC)localObject1).dIx();
      localObject4 = ((cnu)localObject3).Muf;
      p.g(localObject4, "floatBallInfo.cacheNewVideoList");
      localObject3 = (FinderObject)j.L((List)localObject4, ((cnu)localObject3).Muc);
      if (localObject3 == null) {
        continue;
      }
      localObject3 = ((FinderObject)localObject3).attachmentList;
      if (localObject3 == null) {
        continue;
      }
      localObject3 = ((aoq)localObject3).LAM;
      if (localObject3 == null) {
        continue;
      }
      localObject3 = (aop)j.kt((List)localObject3);
      if (localObject3 == null) {
        continue;
      }
      localObject3 = ((aop)localObject3).LAL;
      if (localObject3 == null) {
        continue;
      }
      localObject3 = ((bei)localObject3).LIA;
      localObject4 = af.viA;
      l3 = cl.aWA();
      if (!paramBoolean) {
        continue;
      }
      if (localObject3 == null) {
        continue;
      }
      l1 = ((cng)localObject3).id;
      str2 = d.zs(l1);
      if (localObject1 != null)
      {
        localObject5 = ((bbn)localObject1).sessionId;
        localObject4 = localObject5;
        if (localObject5 != null) {}
      }
      else
      {
        localObject4 = "";
      }
      if (localObject1 != null)
      {
        str1 = ((bbn)localObject1).sGQ;
        localObject5 = str1;
        if (str1 != null) {}
      }
      else
      {
        localObject5 = "";
      }
      if (localObject1 != null)
      {
        str1 = ((bbn)localObject1).sGE;
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
        localObject3 = ((cng)localObject3).MtI;
        l1 = l2;
        if (localObject3 != null) {
          l1 = ((cns)localObject3).hFK;
        }
      }
      af.a(l3, i, 0, str2, "", (String)localObject4, (String)localObject5, (String)localObject1, d.zs(l1));
      AppMethodBeat.o(248456);
      return;
      localObject1 = null;
    }
  }
  
  public final boolean O(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(248452);
    paramBoolean = super.O(paramInt, paramBoolean);
    AppMethodBeat.o(248452);
    return paramBoolean;
  }
  
  public final boolean bPp()
  {
    return true;
  }
  
  public final boolean bPq()
  {
    return true;
  }
  
  public final boolean bPs()
  {
    return true;
  }
  
  public final void bPu()
  {
    AppMethodBeat.i(248451);
    f localf = this.uKk;
    if (localf != null)
    {
      localf.O(true, true);
      AppMethodBeat.o(248451);
      return;
    }
    AppMethodBeat.o(248451);
  }
  
  public final boolean dki()
  {
    return true;
  }
  
  public final void dkj()
  {
    AppMethodBeat.i(248453);
    com.tencent.f.h.RTc.aY((Runnable)new c(this));
    AppMethodBeat.o(248453);
  }
  
  public final void dkk()
  {
    AppMethodBeat.i(248455);
    nH(true);
    AppMethodBeat.o(248455);
  }
  
  public final void ic(boolean paramBoolean)
  {
    AppMethodBeat.i(248454);
    super.ic(paramBoolean);
    if (paramBoolean) {
      nH(false);
    }
    AppMethodBeat.o(248454);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/multitask/MegaVideoMultiTaskHelper$Companion;", "", "()V", "TAG", "", "taskBarEventListener", "com/tencent/mm/plugin/finder/megavideo/multitask/MegaVideoMultiTaskHelper$Companion$taskBarEventListener$1", "Lcom/tencent/mm/plugin/finder/megavideo/multitask/MegaVideoMultiTaskHelper$Companion$taskBarEventListener$1;", "handleClickMultiTask", "", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "animateData", "Lcom/tencent/mm/protocal/protobuf/MultiTaskAnimData;", "isFromMultiTask", "", "activity", "Landroid/app/Activity;", "startListeningTaskBarEvent", "stopListeningTaskBarEvent", "plugin-finder_release"})
  public static final class a
  {
    public static void a(final MultiTaskInfo paramMultiTaskInfo, final crq paramcrq, boolean paramBoolean, final Activity paramActivity)
    {
      AppMethodBeat.i(248449);
      p.h(paramMultiTaskInfo, "multiTaskInfo");
      final cnu localcnu = new cnu();
      final Intent localIntent;
      Object localObject3;
      Object localObject4;
      Object localObject2;
      Context localContext;
      try
      {
        localcnu.parseFrom(paramMultiTaskInfo.field_data);
        localIntent = new Intent();
        Object localObject1 = localcnu.Muf;
        p.g(localObject1, "data.cacheNewVideoList");
        if (j.L((List)localObject1, localcnu.Muc) == null)
        {
          Log.e("MegaVideoMultiTaskHelper", "onTaskBarItemClicked: currVideoPos item is null pos = " + localcnu.Muc);
          localcnu.Muc = 0;
        }
        localcnu.key = paramMultiTaskInfo.field_id;
        localObject1 = localcnu.Muf;
        p.g(localObject1, "data.cacheNewVideoList");
        localObject3 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (FinderObject)((Iterator)localObject3).next();
          p.g(localObject4, "it");
          ((Collection)localObject1).add(new bm((FinderObject)localObject4));
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Log.e("MegaVideoMultiTaskHelper", "MegaVideoFloatBallInfo parse fail", new Object[] { localThrowable });
        }
        localObject2 = (bm)j.L((List)localThrowable, localcnu.Muc);
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
        localObject4 = (ad)g.af(ad.class);
        localContext = MMApplicationContext.getContext();
        localObject3 = (bm)j.kt((List)localObject2);
        if (localObject3 != null)
        {
          localObject3 = ((bm)localObject3).getFeedObject();
          if (localObject3 != null)
          {
            localObject3 = ((FinderObject)localObject3).username;
            if (localObject3 != null) {
              break label374;
            }
          }
        }
        localObject3 = "";
      }
      label374:
      for (;;)
      {
        ((ad)localObject4).a(localContext, (String)localObject3, (ad.a)new a(paramBoolean, (List)localObject2, localcnu, localIntent, paramMultiTaskInfo, paramcrq, paramActivity));
        AppMethodBeat.o(248449);
        return;
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "onDone"})
    static final class a
      implements ad.a
    {
      a(boolean paramBoolean, List paramList, cnu paramcnu, Intent paramIntent, MultiTaskInfo paramMultiTaskInfo, crq paramcrq, Activity paramActivity) {}
      
      public final void mM(boolean paramBoolean)
      {
        AppMethodBeat.i(248445);
        if (!paramBoolean)
        {
          if (this.uLx) {
            d.a(2000L, (kotlin.g.a.a)1.uLB);
          }
          ((b)g.af(b.class)).hr(MMApplicationContext.getContext());
          AppMethodBeat.o(248445);
          return;
        }
        Object localObject1 = (bm)j.kt(this.tAU);
        if (localObject1 != null)
        {
          if (localcnu.Mug > System.currentTimeMillis())
          {
            localObject2 = y.vXH;
            y.a(localcnu.Muc, this.tAU, localcnu.lastBuffer, localIntent);
          }
          localIntent.putExtra("KEY_CACHE_OBJECT_ID", ((bm)localObject1).getFeedObject().id);
          localIntent.putExtra("KEY_CACHE_OBJECT_NONCE_ID", ((bm)localObject1).getFeedObject().objectNonceId);
        }
        localIntent.putExtra("KEY_ROUTER_UI", 0);
        localIntent.putExtra("KEY_FLOAT_BALL_INFO", localcnu.toByteArray());
        localIntent.putExtra("KEY_VIDEO_START_PLAY_TIME_MS", localcnu.Mud);
        localObject1 = localIntent;
        Object localObject2 = com.tencent.mm.plugin.multitask.h.zZn;
        ((Intent)localObject1).putExtra("KEY_VIDEO_THUMB_LOCAL_PATH", com.tencent.mm.plugin.multitask.h.g(paramMultiTaskInfo));
        if (paramcrq != null)
        {
          localObject2 = new ach();
          ((ach)localObject2).LmQ = paramcrq;
          if (this.uLx) {
            break label496;
          }
          paramBoolean = true;
          ((ach)localObject2).LmR = paramBoolean;
          localObject1 = paramActivity;
          if (localObject1 != null)
          {
            SecDataUIC.a locala = SecDataUIC.CWq;
            localObject1 = SecDataUIC.a.gU((Context)localObject1);
            if (localObject1 == null) {
              break label501;
            }
            localObject1 = (crt)((SecDataUIC)localObject1).Xh(5);
            label301:
            if (localObject1 == null) {
              break label507;
            }
            localObject1 = ((crt)localObject1).sGQ;
            label313:
            ((ach)localObject2).sGQ = ((String)localObject1);
          }
          if (localIntent.putExtra("key_multi_task_common_info", ((ach)localObject2).toByteArray()) != null) {}
        }
        else
        {
          localObject1 = a.uLw;
          localObject1 = new ach();
          if (this.uLx) {
            break label513;
          }
          paramBoolean = true;
          label360:
          ((ach)localObject1).LmR = paramBoolean;
          localIntent.putExtra("key_multi_task_common_info", ((ach)localObject1).toByteArray());
        }
        localIntent.addFlags(536870912);
        localObject1 = FinderLongVideoTimelineUI.ubS;
        int j = FinderLongVideoTimelineUI.a.IS(0);
        localObject1 = (aj)g.ah(aj.class);
        if (this.uLx) {}
        for (int i = 18;; i = 17)
        {
          ((aj)localObject1).fillContextIdToIntent(i, 2, j, localIntent);
          localObject1 = com.tencent.mm.plugin.finder.utils.a.vUU;
          localObject1 = MMApplicationContext.getContext();
          p.g(localObject1, "MMApplicationContext.getContext()");
          com.tencent.mm.plugin.finder.utils.a.d((Context)localObject1, localIntent, true);
          if (!this.uLx) {
            break label524;
          }
          localObject1 = paramActivity;
          if (localObject1 == null) {
            break label524;
          }
          ((Activity)localObject1).overridePendingTransition(0, 0);
          AppMethodBeat.o(248445);
          return;
          label496:
          paramBoolean = false;
          break;
          label501:
          localObject1 = null;
          break label301;
          label507:
          localObject1 = null;
          break label313;
          label513:
          paramBoolean = false;
          break label360;
        }
        label524:
        AppMethodBeat.o(248445);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/megavideo/multitask/MegaVideoMultiTaskHelper$Companion$taskBarEventListener$1", "Lcom/tencent/mm/plugin/taskbar/api/ITaskBarViewService$ITaskBarEventListener;", "onTaskBarItemClicked", "", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "onTaskBarItemExposed", "onTaskBarItemRemoved", "plugin-finder_release"})
  public static final class b
    implements c.a
  {
    public final void a(MultiTaskInfo paramMultiTaskInfo)
    {
      AppMethodBeat.i(248446);
      p.h(paramMultiTaskInfo, "multiTaskInfo");
      AppMethodBeat.o(248446);
    }
    
    public final void b(MultiTaskInfo paramMultiTaskInfo)
    {
      AppMethodBeat.i(248447);
      p.h(paramMultiTaskInfo, "multiTaskInfo");
      a.a locala = a.uLw;
      a.a.a(paramMultiTaskInfo, null, false, null);
      AppMethodBeat.o(248447);
    }
    
    public final void c(MultiTaskInfo paramMultiTaskInfo)
    {
      AppMethodBeat.i(248448);
      p.h(paramMultiTaskInfo, "multiTaskInfo");
      AppMethodBeat.o(248448);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(248450);
      a locala1 = this.uLC;
      a locala2 = this.uLC;
      Object localObject = a.a(this.uLC);
      if (localObject != null) {}
      for (localObject = ((com.tencent.mm.plugin.multitask.a.a)localObject).getBitmap();; localObject = null)
      {
        locala1.ai(locala2.aj((Bitmap)localObject));
        AppMethodBeat.o(248450);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.multitask.a
 * JD-Core Version:    0.7.0.1
 */