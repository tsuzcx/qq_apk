package com.tencent.mm.plugin.finder.service;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.AppTask;
import android.app.ActivityManager.RecentTaskInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.PowerManager;
import android.view.View;
import com.tencent.d.a.b.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.fd;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.e.a;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.report.ao;
import com.tencent.mm.plugin.finder.report.bb;
import com.tencent.mm.plugin.finder.report.t;
import com.tencent.mm.plugin.finder.report.t.a;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.ui.FinderHomeAffinityUI;
import com.tencent.mm.plugin.finder.ui.FinderHomeUI;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.l;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bf;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.ai;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k;
import kotlin.l.c;
import org.libpag.PAGFile;
import org.libpag.PAGView;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/service/FinderMultiTaskService;", "Lcom/tencent/mm/plugin/IFinderMultiTaskService;", "()V", "enterFinderActivity", "", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "kotlin.jvm.PlatformType", "", "exposeTimestamp", "", "foregroundFinderActivity", "getForegroundFinderActivity", "()Ljava/util/Set;", "hasBeenInFinder", "", "isExitFromBtn", "isHomeFromFinder", "isMainProcBackground", "isScreenOff", "needReenterFinder", "powerManager", "Landroid/os/PowerManager;", "getPowerManager", "()Landroid/os/PowerManager;", "powerManager$delegate", "Lkotlin/Lazy;", "withNaviAnimShown", "Ljava/lang/Boolean;", "withoutNaviAnimShown", "checkExitFinderActivity", "checkMoveBackFinderTask", "", "checkReenterFinderFromLauncherUI", "activity", "Landroid/app/Activity;", "checkShowMultiTaskDialog", "context", "Landroid/content/Context;", "enterType", "", "checkUIisFinderTask", "clearAllFinderTaskActivity", "forceClose", "getEnterFinderTaskUISize", "getTopForegroundActivity", "isFinderForeground", "isFinderTaskBackground", "isFinderTaskForeground", "isHomeFromFinderTask", "isMainTaskForeground", "onEnterFinder", "finder", "onExitFinder", "onFinderBackground", "onFinderForeground", "onLauncherUIPause", "onLauncherUIStart", "onMainProcBackground", "onMainProcForeground", "reportGuide", "isEnter", "exitType", "reportShowPush", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  implements l
{
  public static final a Fze;
  public boolean Fzf;
  private boolean Fzg;
  public boolean Fzh;
  private final kotlin.j Fzi;
  private boolean Fzj;
  private Boolean Fzk;
  private Boolean Fzl;
  private long Fzm;
  private boolean Fzn;
  private boolean fcK;
  private final Set<MMFinderUI> pFd;
  public final Set<MMFinderUI> pFe;
  
  static
  {
    AppMethodBeat.i(330124);
    Fze = new a((byte)0);
    AppMethodBeat.o(330124);
  }
  
  public g()
  {
    AppMethodBeat.i(330064);
    this.Fzi = k.cm((kotlin.g.a.a)d.Fzq);
    this.pFe = Collections.synchronizedSet((Set)new HashSet());
    this.pFd = Collections.synchronizedSet((Set)new HashSet());
    AppMethodBeat.o(330064);
  }
  
  private static final void a(com.tencent.mm.ui.widget.a.j paramj, g paramg)
  {
    AppMethodBeat.i(330086);
    s.u(paramj, "$dialog");
    s.u(paramg, "this$0");
    paramj.cyW();
    paramg.Fzn = true;
    AppMethodBeat.o(330086);
  }
  
  private static final void a(com.tencent.mm.ui.widget.a.j paramj, g paramg, int paramInt)
  {
    AppMethodBeat.i(330094);
    s.u(paramj, "$dialog");
    s.u(paramg, "this$0");
    paramj = (PAGView)paramj.rootView.findViewById(e.e.guide_pag_view);
    if (paramj != null) {
      paramj.stop();
    }
    if (paramg.Fzn) {}
    for (int i = 1;; i = 2)
    {
      paramg.k(false, paramInt, i);
      AppMethodBeat.o(330094);
      return;
    }
  }
  
  private final boolean ePy()
  {
    AppMethodBeat.i(330074);
    if ((this.pFe.size() == 0) && (this.pFd.size() > 0))
    {
      Object localObject = this.pFd;
      s.s(localObject, "enterFinderActivity");
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (s.p(((MMFinderUI)((Iterator)localObject).next()).getClass(), FinderHomeAffinityUI.class))
        {
          AppMethodBeat.o(330074);
          return true;
        }
      }
    }
    AppMethodBeat.o(330074);
    return false;
  }
  
  private final void k(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(330079);
    if (paramBoolean) {
      this.Fzm = cn.bDw();
    }
    fd localfd = new fd();
    localfd.iGH = paramInt1;
    if (!paramBoolean)
    {
      if (this.Fzm == 0L)
      {
        AppMethodBeat.o(330079);
        return;
      }
      localfd.iCW = (cn.bDw() - this.Fzm);
      localfd.iDn = paramInt2;
      this.Fzm = 0L;
    }
    localfd.bMH();
    z localz = z.FrZ;
    z.a((com.tencent.mm.plugin.report.a)localfd);
    AppMethodBeat.o(330079);
  }
  
  public final boolean D(Activity paramActivity)
  {
    AppMethodBeat.i(330201);
    s.u(paramActivity, "activity");
    if (!h.baz())
    {
      Log.e("FinderMultiTaskService", "isFinderTaskForeground: acc not ready");
      AppMethodBeat.o(330201);
      return false;
    }
    Object localObject = this.pFd;
    s.s(localObject, "enterFinderActivity");
    Iterator localIterator = ((Iterable)localObject).iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
    } while (!s.p(((MMFinderUI)localObject).getClass(), FinderHomeAffinityUI.class));
    for (;;)
    {
      localObject = (MMFinderUI)localObject;
      if (localObject != null) {
        break;
      }
      AppMethodBeat.o(330201);
      return false;
      localObject = null;
    }
    if (((MMFinderUI)localObject).getTaskId() == paramActivity.getTaskId())
    {
      AppMethodBeat.o(330201);
      return true;
    }
    AppMethodBeat.o(330201);
    return false;
  }
  
  public final boolean E(Activity paramActivity)
  {
    AppMethodBeat.i(330257);
    s.u(paramActivity, "activity");
    if (!h.baz())
    {
      Log.e("FinderMultiTaskService", "checkReenterFinderFromLauncherUI: acc not ready");
      AppMethodBeat.o(330257);
      return false;
    }
    Object localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (!com.tencent.mm.plugin.finder.storage.d.eXD())
    {
      Log.i("FinderMultiTaskService", "checkReenterFinderFromLauncherUI: finder multi task is close");
      AppMethodBeat.o(330257);
      return false;
    }
    if (!this.Fzg)
    {
      Log.i("FinderMultiTaskService", s.X("checkReenterFinderFromLauncherUI: failed needReenterFinder = ", Boolean.valueOf(this.Fzg)));
      AppMethodBeat.o(330257);
      return false;
    }
    this.Fzf = false;
    this.Fzg = false;
    if (!ePy())
    {
      Log.i("FinderMultiTaskService", "checkReenterFinderFromLauncherUI: failed is finder task forground");
      AppMethodBeat.o(330257);
      return false;
    }
    paramActivity.getIntent().putExtra("KEY_REENTER_FINDER", true);
    localObject = com.tencent.mm.plugin.finder.utils.a.GfO;
    localObject = (Context)paramActivity;
    Intent localIntent = new Intent();
    localIntent.putExtra("KEY_NEED_ANIM", true);
    ah localah = ah.aiuX;
    com.tencent.mm.plugin.finder.utils.a.az((Context)localObject, localIntent);
    paramActivity.overridePendingTransition(e.a.slide_right_in_quick, e.a.slide_left_out_quick);
    paramActivity = t.Fro;
    t.a(t.a.Frx);
    AppMethodBeat.o(330257);
    return true;
  }
  
  public final void R(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(330270);
    s.u(paramContext, "context");
    if (!h.baz())
    {
      Log.e("FinderMultiTaskService", "checkShowMultiTaskDialog: acc not ready");
      AppMethodBeat.o(330270);
      return;
    }
    if (!this.Fzj)
    {
      AppMethodBeat.o(330270);
      return;
    }
    Object localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (!com.tencent.mm.plugin.finder.storage.d.eXD())
    {
      AppMethodBeat.o(330270);
      return;
    }
    if ((paramContext instanceof Activity)) {}
    for (localObject = (Activity)paramContext; localObject != null; localObject = null)
    {
      localObject = ((Activity)localObject).getIntent();
      if ((localObject == null) || (!((Intent)localObject).getBooleanExtra("KEY_REENTER_FINDER", false))) {
        break;
      }
      ((Intent)localObject).removeExtra("KEY_REENTER_FINDER");
      AppMethodBeat.o(330270);
      return;
    }
    this.Fzj = false;
    if (this.Fzk == null) {
      ((g)this).Fzk = Boolean.valueOf(h.baE().ban().getBoolean(at.a.adeN, false));
    }
    if (this.Fzl == null) {
      ((g)this).Fzl = Boolean.valueOf(h.baE().ban().getBoolean(at.a.adeO, false));
    }
    if ((s.p(this.Fzk, Boolean.TRUE)) && (s.p(this.Fzl, Boolean.TRUE)))
    {
      AppMethodBeat.o(330270);
      return;
    }
    Log.i("FinderMultiTaskService", "checkShowMultiTaskDialog: withNaviAnimShown = " + this.Fzk + ", withNaviAnimShown = " + this.Fzk);
    int i = bf.bi(paramContext);
    int j = aw.bk(paramContext);
    if ((i > 0) && (j <= i))
    {
      i = 1;
      if (((i == 0) || (!s.p(this.Fzk, Boolean.TRUE))) && ((i != 0) || (!s.p(this.Fzl, Boolean.TRUE)))) {
        break label344;
      }
    }
    label344:
    for (j = 1;; j = 0)
    {
      if (j == 0) {
        break label350;
      }
      AppMethodBeat.o(330270);
      return;
      i = 0;
      break;
    }
    label350:
    localObject = new com.tencent.mm.ui.widget.a.j(paramContext, 2, 0, true);
    ((com.tencent.mm.ui.widget.a.j)localObject).aFe(1);
    ((com.tencent.mm.ui.widget.a.j)localObject).au((CharSequence)paramContext.getString(e.h.app_i_know));
    ((com.tencent.mm.ui.widget.a.j)localObject).agfR = new g..ExternalSyntheticLambda0((com.tencent.mm.ui.widget.a.j)localObject, this);
    ((com.tencent.mm.ui.widget.a.j)localObject).aFf(e.f.finder_multi_task_guide_layout);
    PAGView localPAGView = (PAGView)((com.tencent.mm.ui.widget.a.j)localObject).rootView.findViewById(e.e.guide_pag_view);
    AssetManager localAssetManager;
    if (localPAGView != null)
    {
      localAssetManager = paramContext.getAssets();
      if (i == 0) {
        break label538;
      }
    }
    label538:
    for (paramContext = "finder_multi_task_guide_with_navigation_bar.pag";; paramContext = "finder_multi_task_guide_without_navigation_bar.pag")
    {
      localPAGView.setFile(PAGFile.Load(localAssetManager, paramContext));
      localPAGView.setRepeatCount(0);
      localPAGView.play();
      ((com.tencent.mm.ui.widget.a.j)localObject).agfT = new g..ExternalSyntheticLambda1((com.tencent.mm.ui.widget.a.j)localObject, this, paramInt);
      ((com.tencent.mm.ui.widget.a.j)localObject).dDn();
      k(true, paramInt, 0);
      this.Fzm = cn.bDw();
      this.Fzn = false;
      if (i == 0) {
        break;
      }
      h.baE().ban().set(at.a.adeN, Boolean.TRUE);
      this.Fzk = Boolean.TRUE;
      AppMethodBeat.o(330270);
      return;
    }
    h.baE().ban().set(at.a.adeO, Boolean.TRUE);
    this.Fzl = Boolean.TRUE;
    AppMethodBeat.o(330270);
  }
  
  public final void a(MMFinderUI paramMMFinderUI)
  {
    AppMethodBeat.i(330165);
    s.u(paramMMFinderUI, "finder");
    if (this.pFe.contains(paramMMFinderUI))
    {
      AppMethodBeat.o(330165);
      return;
    }
    boolean bool1 = ((e)h.az(e.class)).isNearbyActivity((MMActivity)paramMMFinderUI);
    Object localObject;
    boolean bool2;
    com.tencent.mm.plugin.findersdk.e.a locala;
    if (!bool1)
    {
      localObject = t.Fro;
      bool2 = this.Fzh;
      boolean bool3 = this.fcK;
      s.u(paramMMFinderUI, "finder");
      localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (com.tencent.mm.plugin.finder.storage.d.eXD())
      {
        localObject = (l)h.ax(l.class);
        boolean bool4 = ((l)localObject).bUe();
        if (!bool4) {
          t.a(t.a.Frp);
        }
        if ((!bool4) && (((l)localObject).D((Activity)paramMMFinderUI)))
        {
          Log.i("FinderMultiTaskReporter", "onFinderForeground: isMainProcBackground=" + bool2 + ", isScreenOff = " + bool3);
          if (!bool3) {
            break label234;
          }
          t.a(t.a.Fru);
          t.a(t.a.Frq);
        }
        localObject = paramMMFinderUI.getClass();
        locala = com.tencent.mm.plugin.findersdk.e.a.HdV;
        if (!s.p(localObject, com.tencent.mm.plugin.findersdk.e.a.fsq())) {
          break label297;
        }
        t.a(t.a.Frw);
      }
    }
    for (;;)
    {
      this.fcK = false;
      if (!bool1) {
        break label328;
      }
      AppMethodBeat.o(330165);
      return;
      label234:
      if (bool2)
      {
        localObject = ao.FtO;
        s.u(paramMMFinderUI, "finderUi");
        ao.AxK = System.currentTimeMillis();
        ao.a(paramMMFinderUI, true);
        t.a(t.a.Frr);
        Log.i("FinderMultiTaskReporter", "onFinderForeground: enter finder task from system ui");
        break;
      }
      t.a(t.a.Frs);
      Log.i("FinderMultiTaskReporter", "onFinderForeground: enter finder task normally");
      break;
      label297:
      localObject = paramMMFinderUI.getClass();
      locala = com.tencent.mm.plugin.findersdk.e.a.HdV;
      if (s.p(localObject, com.tencent.mm.plugin.findersdk.e.a.fsr())) {
        t.a(t.a.Frv);
      }
    }
    label328:
    this.pFe.add(paramMMFinderUI);
    this.Fzf = false;
    this.Fzg = false;
    if (!this.Fzj) {
      this.Fzj = ep((Context)paramMMFinderUI);
    }
    AppMethodBeat.o(330165);
  }
  
  public final void b(MMFinderUI paramMMFinderUI)
  {
    int k = 0;
    AppMethodBeat.i(330179);
    s.u(paramMMFinderUI, "finder");
    this.pFe.remove(paramMMFinderUI);
    boolean bool1;
    Object localObject1;
    int i;
    if (this.pFe.size() == 0)
    {
      boolean bool2 = ePy();
      boolean bool3 = D((Activity)paramMMFinderUI);
      if ((!bool2) || (!bool3) || (paramMMFinderUI.isFinishing())) {
        break label295;
      }
      bool1 = true;
      this.Fzf = bool1;
      Log.i("FinderMultiTaskService", "onFinderBackground: isFinderTaskBackground = " + bool2 + ", checkUIisFinderTask = " + bool3 + ", finderIsFinishing = " + paramMMFinderUI.isFinishing() + ", isHomeFromFinder = " + this.Fzf);
      if (this.Fzf)
      {
        localObject1 = t.Fro;
        t.a(t.a.Frt);
      }
      localObject1 = ao.FtO;
      s.u(paramMMFinderUI, "finderUi");
      ao.a(paramMMFinderUI, false);
      paramMMFinderUI = h.baE().ban();
      localObject1 = at.a.adfe;
      int j;
      if (this.pFd.size() <= 1)
      {
        j = k;
        if (this.pFd.size() == 1)
        {
          Object localObject2 = this.pFd;
          s.s(localObject2, "enterFinderActivity");
          localObject2 = (MMFinderUI)p.f((Iterable)localObject2);
          if ((localObject2 == null) || (((MMFinderUI)localObject2).isFinishing())) {
            break label301;
          }
          i = 1;
          label259:
          j = k;
          if (i == 0) {}
        }
      }
      else
      {
        j = 1;
      }
      if (j == 0) {
        break label306;
      }
    }
    label295:
    label301:
    label306:
    for (long l = cn.bDw();; l = 0L)
    {
      paramMMFinderUI.set((at.a)localObject1, Long.valueOf(l));
      AppMethodBeat.o(330179);
      return;
      bool1 = false;
      break;
      i = 0;
      break label259;
    }
  }
  
  public final Activity bUR()
  {
    AppMethodBeat.i(330223);
    Object localObject = this.pFe;
    s.s(localObject, "foregroundFinderActivity");
    localObject = (Activity)p.h((Iterable)localObject);
    AppMethodBeat.o(330223);
    return localObject;
  }
  
  public final boolean bUS()
  {
    AppMethodBeat.i(330229);
    if ((this.Fzf) && (ePy()))
    {
      AppMethodBeat.o(330229);
      return true;
    }
    AppMethodBeat.o(330229);
    return false;
  }
  
  public final void bUT()
  {
    AppMethodBeat.i(330238);
    if (!h.baz())
    {
      Log.e("FinderMultiTaskService", "onLauncherUIStart: acc not ready");
      AppMethodBeat.o(330238);
      return;
    }
    Object localObject = this.pFe;
    s.s(localObject, "foregroundFinderActivity");
    localObject = (MMFinderUI)p.h((Iterable)localObject);
    if (localObject == null) {
      localObject = null;
    }
    for (;;)
    {
      if (localObject == null)
      {
        localObject = (g)this;
        Log.i("FinderMultiTaskService", s.X("onLauncherUIStart: isHomeFromFinder = ", Boolean.valueOf(((g)localObject).Fzf)));
        ((g)localObject).Fzg = ((g)localObject).Fzf;
      }
      AppMethodBeat.o(330238);
      return;
      int i;
      if (!((MMFinderUI)localObject).isFinishing())
      {
        i = 1;
        label109:
        if (i == 0) {
          break label127;
        }
      }
      for (;;)
      {
        if (localObject != null) {
          break label132;
        }
        localObject = null;
        break;
        i = 0;
        break label109;
        label127:
        localObject = null;
      }
      label132:
      Log.i("FinderMultiTaskService", "onLauncherUIStart: finder activity is still foreground");
      this.Fzg = true;
      localObject = ah.aiuX;
    }
  }
  
  public final void bUU()
  {
    AppMethodBeat.i(330247);
    if (!h.baz())
    {
      Log.e("FinderMultiTaskService", "onLauncherUIPause: acc not ready");
      AppMethodBeat.o(330247);
      return;
    }
    this.Fzg = false;
    this.Fzf = false;
    AppMethodBeat.o(330247);
  }
  
  public final void bUV()
  {
    AppMethodBeat.i(330260);
    com.tencent.mm.ae.d.a(0L, (kotlin.g.a.a)new b(this));
    AppMethodBeat.o(330260);
  }
  
  public final void bUW()
  {
    AppMethodBeat.i(330277);
    Object localObject1 = this.pFe;
    s.s(localObject1, "foregroundFinderActivity");
    localObject1 = (MMFinderUI)p.h((Iterable)localObject1);
    if (localObject1 != null)
    {
      if (!(localObject1 instanceof FinderHomeUI)) {
        break label81;
      }
      if (localObject1 != null)
      {
        Object localObject2 = bb.FuK;
        localObject2 = as.GSQ;
        localObject1 = as.a.hu((Context)localObject1);
        if (localObject1 != null) {
          break label86;
        }
      }
    }
    label81:
    label86:
    for (localObject1 = null;; localObject1 = ((as)localObject1).fou())
    {
      bb.a((bui)localObject1, "wechat_push_card", 0);
      AppMethodBeat.o(330277);
      return;
      localObject1 = null;
      break;
    }
  }
  
  public final boolean bUe()
  {
    AppMethodBeat.i(330160);
    if (this.pFe.size() > 0)
    {
      AppMethodBeat.o(330160);
      return true;
    }
    AppMethodBeat.o(330160);
    return false;
  }
  
  public final int ePx()
  {
    AppMethodBeat.i(330193);
    Object localObject1 = this.pFd;
    s.s(localObject1, "enterFinderActivity");
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      MMFinderUI localMMFinderUI = (MMFinderUI)localObject3;
      s.s(localMMFinderUI, "it");
      if (D((Activity)localMMFinderUI)) {
        ((Collection)localObject1).add(localObject3);
      }
    }
    int i = ((List)localObject1).size();
    AppMethodBeat.o(330193);
    return i;
  }
  
  public final boolean ep(Context paramContext)
  {
    boolean bool2 = false;
    AppMethodBeat.i(330188);
    s.u(paramContext, "context");
    if (!h.baz())
    {
      Log.e("FinderMultiTaskService", "isFinderTaskForeground: acc not ready");
      AppMethodBeat.o(330188);
      return false;
    }
    if (this.pFe.size() == 0)
    {
      AppMethodBeat.o(330188);
      return false;
    }
    Object localObject = this.pFd;
    s.s(localObject, "enterFinderActivity");
    localObject = (Iterable)localObject;
    if ((!(localObject instanceof Collection)) || (!((Collection)localObject).isEmpty()))
    {
      localObject = ((Iterable)localObject).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!s.p(((MMFinderUI)((Iterator)localObject).next()).getClass(), FinderHomeAffinityUI.class));
    }
    for (int i = 0; i != 0; i = 1)
    {
      AppMethodBeat.o(330188);
      return false;
    }
    paramContext = paramContext.getSystemService("activity");
    boolean bool1;
    if ((paramContext instanceof ActivityManager))
    {
      paramContext = (ActivityManager)paramContext;
      bool1 = bool2;
      if (paramContext != null)
      {
        paramContext = paramContext.getRunningTasks(1);
        bool1 = bool2;
        if (paramContext != null)
        {
          paramContext = (ActivityManager.RunningTaskInfo)p.oL(paramContext);
          bool1 = bool2;
          if (paramContext != null)
          {
            paramContext = paramContext.baseActivity;
            if (paramContext != null) {
              break label239;
            }
            bool1 = false;
          }
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(330188);
      return bool1;
      paramContext = null;
      break;
      label239:
      paramContext = paramContext.getClassName();
      if (paramContext == null) {
        bool1 = false;
      } else {
        bool1 = paramContext.equals(ai.cz(FinderHomeAffinityUI.class).klu());
      }
    }
  }
  
  public final void hG(boolean paramBoolean)
  {
    AppMethodBeat.i(330216);
    boolean bool1;
    try
    {
      localObject1 = this.pFd;
      s.s(localObject1, "enterFinderActivity");
      localObject4 = ((Iterable)localObject1).iterator();
      do
      {
        if (!((Iterator)localObject4).hasNext()) {
          break;
        }
        localObject1 = ((Iterator)localObject4).next();
      } while (!s.p(((MMFinderUI)localObject1).getClass(), FinderHomeAffinityUI.class));
      localObject1 = (MMFinderUI)localObject1;
      if (localObject1 == null) {
        break label349;
      }
      bool1 = true;
    }
    finally
    {
      Object localObject1;
      Object localObject4;
      label84:
      boolean bool2;
      label125:
      Log.e("FinderMultiTaskService", "clearAllFinderTaskActivity: error, ", new Object[] { localObject2 });
      label160:
      AppMethodBeat.o(330216);
      return;
    }
    bool2 = bool1;
    if (localObject1 == null)
    {
      bool2 = bool1;
      if (paramBoolean)
      {
        localObject1 = MMApplicationContext.getContext().getSystemService("activity");
        if (!(localObject1 instanceof ActivityManager)) {
          break label354;
        }
        localObject1 = (ActivityManager)localObject1;
        bool2 = bool1;
        if (localObject1 != null)
        {
          localObject1 = ((ActivityManager)localObject1).getAppTasks();
          bool2 = bool1;
          if (localObject1 != null) {
            localObject1 = ((Iterable)localObject1).iterator();
          }
        }
      }
    }
    label349:
    label352:
    label354:
    label360:
    label363:
    for (;;)
    {
      bool2 = bool1;
      if (((Iterator)localObject1).hasNext())
      {
        localObject4 = (ActivityManager.AppTask)((Iterator)localObject1).next();
        Object localObject5 = ((ActivityManager.AppTask)localObject4).getTaskInfo().baseIntent.getComponent();
        if (localObject5 == null) {
          break label360;
        }
        localObject5 = ((ComponentName)localObject5).getClassName();
        if ((localObject5 == null) || (((String)localObject5).equals(ai.cz(FinderHomeAffinityUI.class).klu()) != true)) {
          break label360;
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label363;
        }
        ((ActivityManager.AppTask)localObject4).finishAndRemoveTask();
        bool1 = true;
        break label160;
        for (;;)
        {
          ((MMFinderUI)localObject1).finishAndRemoveTask();
          localObject1 = ah.aiuX;
          break label84;
          Log.i("FinderMultiTaskService", "clearAllFinderTaskActivity: forceClose = " + paramBoolean + ", clearSuccess = " + bool2);
          AppMethodBeat.o(330216);
          return;
          for (;;)
          {
            if (localObject2 != null) {
              break label352;
            }
            localObject3 = null;
            break label84;
            localObject3 = null;
            break;
            bool1 = false;
          }
        }
        Object localObject3 = null;
        break label125;
      }
    }
  }
  
  public final void onEnterFinder(MMFinderUI paramMMFinderUI)
  {
    AppMethodBeat.i(330156);
    s.u(paramMMFinderUI, "finder");
    if (!this.pFd.contains(paramMMFinderUI))
    {
      this.pFd.add(paramMMFinderUI);
      t localt = t.Fro;
      t.e(paramMMFinderUI);
    }
    AppMethodBeat.o(330156);
  }
  
  public final void onExitFinder(MMFinderUI paramMMFinderUI)
  {
    AppMethodBeat.i(330149);
    s.u(paramMMFinderUI, "finder");
    this.pFd.remove(paramMMFinderUI);
    AppMethodBeat.o(330149);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/service/FinderMultiTaskService$Companion;", "", "()V", "GUIDE_WITHOUT_NAVI_BAR_PATH", "", "GUIDE_WITH_NAVI_BAR_PATH", "TAG", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(g paramg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    public c(g paramg, MMFinderUI paramMMFinderUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/os/PowerManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<PowerManager>
  {
    public static final d Fzq;
    
    static
    {
      AppMethodBeat.i(330043);
      Fzq = new d();
      AppMethodBeat.o(330043);
    }
    
    d()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.service.g
 * JD-Core Version:    0.7.0.1
 */