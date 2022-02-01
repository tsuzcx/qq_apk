package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.ArrayMap;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.accessibility.v;
import com.tencent.mm.plugin.finder.accessibility.w;
import com.tencent.mm.plugin.finder.accessibility.x;
import com.tencent.mm.plugin.finder.accessibility.y;
import com.tencent.mm.plugin.finder.cgi.ec;
import com.tencent.mm.plugin.finder.report.j.a;
import com.tencent.mm.plugin.findersdk.a.bh;
import com.tencent.mm.plugin.findersdk.a.bn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.ScreenShotUtil;
import com.tencent.mm.sdk.platformtools.ScreenShotUtil.ScreenShotCallback;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.component.l;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.SwipeBackLayout.a;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ai;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "activeFinish", "", "callOnce", "needChangeOrientation", "getNeedChangeOrientation", "()Z", "setNeedChangeOrientation", "(Z)V", "screenShotCallback", "com/tencent/mm/plugin/finder/ui/MMFinderUI$screenShotCallback$1", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI$screenShotCallback$1;", "simpleLifecycle", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI$SimpleLifecycleCallback;", "getSimpleLifecycle", "()Lcom/tencent/mm/plugin/finder/ui/MMFinderUI$SimpleLifecycleCallback;", "setSimpleLifecycle", "(Lcom/tencent/mm/plugin/finder/ui/MMFinderUI$SimpleLifecycleCallback;)V", "unInitTask", "Ljava/lang/Runnable;", "finish", "", "getCommentScene", "", "getLayoutId", "getReportTag", "", "getReportType", "getUIComponents", "", "Lcom/tencent/mm/ui/component/UIComponent;", "importAccessibility", "set", "Ljava/util/HashSet;", "Ljava/lang/Class;", "initBusiness", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "intent", "Landroid/content/Intent;", "onPause", "onResume", "onStart", "onStop", "onSwipeStartDrag", "edgeFlags", "setMMOrientation", "setRequestedOrientation", "requestedOrientation", "superImportUIComponents", "uninitBusiness", "uninitBusinessCheck", "Companion", "SimpleLifecycleCallback", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class MMFinderUI
  extends MMActivity
{
  public static final a FVG = new a((byte)0);
  private static final String TAG = "Finder.MMFinderUI";
  private Runnable CxA;
  private boolean Cxz;
  public boolean FVH;
  public b FVI;
  private final e FVJ = new e(this);
  private boolean callOnce;
  
  private final void ehS()
  {
    if (this.callOnce) {
      return;
    }
    this.callOnce = true;
  }
  
  private static final void f(MMFinderUI paramMMFinderUI)
  {
    kotlin.g.b.s.u(paramMMFinderUI, "this$0");
    paramMMFinderUI.ehS();
  }
  
  public void TH(int paramInt) {}
  
  public void _$_clearFindViewByIdCache() {}
  
  public int edC()
  {
    return 0;
  }
  
  public String efe()
  {
    String str = getClass().getSimpleName();
    kotlin.g.b.s.s(str, "this.javaClass.simpleName");
    return str;
  }
  
  public final Set<UIComponent> fcj()
  {
    return (Set)getUiComponents();
  }
  
  public void finish()
  {
    super.finish();
    Log.i(TAG, "finish " + getClass().getSimpleName() + ", " + hashCode() + ", " + getTaskId() + ", " + isPaused());
    if (!isPaused()) {
      this.CxA = new MMFinderUI..ExternalSyntheticLambda0(this);
    }
    this.Cxz = true;
  }
  
  public int getCommentScene()
  {
    return 0;
  }
  
  public int getLayoutId()
  {
    return 0;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Object localObject = com.tencent.mm.plugin.finder.report.j.Fpm;
    localObject = efe();
    int i = hashCode();
    kotlin.g.b.s.u(localObject, "tag");
    j.a locala = com.tencent.mm.plugin.finder.report.j.aJ(i, true);
    if (locala != null)
    {
      kotlin.g.b.s.u(localObject, "<set-?>");
      locala.tag = ((String)localObject);
      locala.EQt = com.tencent.mm.plugin.finder.report.j.AxK;
      locala.Fpo = cn.bDw();
    }
    super.onCreate(paramBundle);
    Log.i(TAG, "onCreate " + getClass().getSimpleName() + ", " + hashCode() + ", " + getTaskId() + '}');
    paramBundle = (com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
    if (paramBundle != null) {
      paramBundle.onEnterFinder(this);
    }
    com.tencent.mm.ae.d.a(0L, (kotlin.g.a.a)new c(this));
    paramBundle = this.FVI;
    if (paramBundle != null) {
      paramBundle.azK("onCreate");
    }
    if (isSupportNavigationSwipeBack())
    {
      paramBundle = getSwipeBackLayout();
      if (paramBundle != null) {
        paramBundle.setDragListener((SwipeBackLayout.a)new d(this));
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.FVI;
    if (localObject != null) {
      ((b)localObject).azK("onDestroy");
    }
    Log.i(TAG, "onDestroy " + getClass().getSimpleName() + ", " + hashCode() + ", " + getTaskId() + ", " + this.Cxz);
    if (!this.Cxz) {
      ehS();
    }
    localObject = com.tencent.mm.plugin.finder.report.j.Fpm;
    com.tencent.mm.plugin.finder.report.j.b(hashCode(), (Activity)this);
    localObject = (com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
    if (localObject != null) {
      ((com.tencent.mm.plugin.h)localObject).onExitFinder(this);
    }
    this.FVI = null;
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    b localb = this.FVI;
    if (localb != null) {
      localb.azK("onNewIntent");
    }
    super.onNewIntent(paramIntent);
  }
  
  public void onPause()
  {
    super.onPause();
    Object localObject = com.tencent.mm.plugin.finder.utils.j.Gge;
    com.tencent.mm.plugin.finder.utils.j.aM((Activity)this);
    localObject = this.FVI;
    if (localObject != null) {
      ((b)localObject).azK("onPause");
    }
    localObject = (com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.h)localObject).getFinderSyncExtension();
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.api.j)localObject).d(this);
      }
    }
    Log.i(TAG, "onPause " + getClass().getSimpleName() + ", " + hashCode() + ", " + getTaskId() + ", " + this.CxA);
    localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eTq().bmg()).intValue() == 1)
    {
      Log.i(TAG, "REPORT_WHEN_SCREEN_SHOT remove");
      ScreenShotUtil.setScreenShotCallback((Context)this, null);
    }
    localObject = this.CxA;
    if (localObject != null) {
      ((Runnable)localObject).run();
    }
    this.CxA = null;
    if (isFinishing())
    {
      localObject = com.tencent.mm.plugin.finder.report.j.Fpm;
      com.tencent.mm.plugin.finder.report.j.b(hashCode(), (Activity)this);
    }
    int i;
    do
    {
      return;
      localObject = com.tencent.mm.plugin.finder.report.j.Fpm;
      i = hashCode();
      localObject = com.tencent.mm.plugin.finder.report.j.Sg(i);
    } while ((localObject == null) || (((j.a)localObject).Fpq != 0L) || (((j.a)localObject).Fpr != 0L));
    Log.i("FinderEnterCostReporter", kotlin.g.b.s.X("notifyOnPause: abandon useless data ", localObject));
    com.tencent.mm.plugin.finder.report.j.Fpn.remove(Integer.valueOf(i));
  }
  
  public void onResume()
  {
    Object localObject = com.tencent.mm.plugin.finder.report.j.Fpm;
    localObject = com.tencent.mm.plugin.finder.report.j.Sg(hashCode());
    int i;
    if (localObject != null) {
      if (((j.a)localObject).Fpp == 0L)
      {
        i = 1;
        if (i == 0) {
          break label318;
        }
      }
    }
    for (;;)
    {
      if (localObject != null) {
        ((j.a)localObject).Fpp = cn.bDw();
      }
      localObject = this.FVI;
      if (localObject != null) {
        ((b)localObject).azK("onResume");
      }
      super.onResume();
      localObject = com.tencent.mm.plugin.finder.utils.j.Gge;
      com.tencent.mm.plugin.finder.utils.j.aL((Activity)this);
      localObject = (com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.h)localObject).getFinderSyncExtension();
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.api.j)localObject).c(this);
        }
      }
      Log.i(TAG, "onResume " + getClass().getSimpleName() + ", " + hashCode() + ", " + getTaskId());
      localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Boolean)com.tencent.mm.plugin.finder.storage.d.eSX().bmg()).booleanValue())
      {
        localObject = new Intent((Context)this, Class.forName("com.tencent.testcrash"));
        localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/finder/ui/MMFinderUI", "onResume", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/finder/ui/MMFinderUI", "onResume", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eTq().bmg()).intValue() == 1)
      {
        Log.i(TAG, "REPORT_WHEN_SCREEN_SHOT register");
        ScreenShotUtil.setScreenShotCallback((Context)this, (ScreenShotUtil.ScreenShotCallback)this.FVJ);
      }
      return;
      i = 0;
      break;
      label318:
      localObject = null;
    }
  }
  
  public void onStart()
  {
    ((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).a(this);
    b localb = this.FVI;
    if (localb != null) {
      localb.azK("onStart");
    }
    super.onStart();
  }
  
  public void onStop()
  {
    b localb = this.FVI;
    if (localb != null) {
      localb.azK("onStop");
    }
    super.onStop();
    ((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).b(this);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void setMMOrientation()
  {
    if (!this.FVH) {
      super.setMMOrientation();
    }
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    Log.i(TAG, "setRequestedOrientation: requestedOrientation = " + paramInt + ", needChangeOrientation = " + this.FVH + ", this=" + efe());
    if (!this.FVH)
    {
      super.setRequestedOrientation(1);
      return;
    }
    super.setRequestedOrientation(paramInt);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    kotlin.g.b.s.u(paramHashSet, "set");
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(l.a(ai.cz(bn.class)));
    paramHashSet.add(l.a(ai.cz(bh.class)));
    paramHashSet.add(com.tencent.mm.plugin.secdata.ui.a.class);
    paramHashSet.add(l.a(ai.cz(x.class)));
    paramHashSet.add(l.a(ai.cz(w.class)));
    paramHashSet.add(l.a(ai.cz(v.class)));
    paramHashSet.add(l.a(ai.cz(y.class)));
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/MMFinderUI$Companion;", "", "()V", "TAG", "", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/MMFinderUI$SimpleLifecycleCallback;", "", "reportLifeCycle", "", "lifecycle", "", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void azK(String paramString);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(MMFinderUI paramMMFinderUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/MMFinderUI$onCreate$2", "Lcom/tencent/mm/ui/widget/SwipeBackLayout$DragListener;", "onSettleReset", "", "onStartDrag", "edgeFlags", "", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements SwipeBackLayout.a
  {
    d(MMFinderUI paramMMFinderUI) {}
    
    private static final void a(SwipeBackLayout paramSwipeBackLayout, MMFinderUI paramMMFinderUI)
    {
      AppMethodBeat.i(346927);
      kotlin.g.b.s.u(paramSwipeBackLayout, "$it");
      kotlin.g.b.s.u(paramMMFinderUI, "this$0");
      paramSwipeBackLayout.setNeedRequestActivityTranslucent(true);
      paramSwipeBackLayout.Nl(false);
      com.tencent.mm.ui.base.b.bZ((Activity)paramMMFinderUI);
      AppMethodBeat.o(346927);
    }
    
    public final void TJ(int paramInt)
    {
      AppMethodBeat.i(346935);
      this.FVK.TH(paramInt);
      AppMethodBeat.o(346935);
    }
    
    public final void fck()
    {
      AppMethodBeat.i(346944);
      SwipeBackLayout localSwipeBackLayout = this.FVK.getSwipeBackLayout();
      if (localSwipeBackLayout != null) {
        localSwipeBackLayout.post(new MMFinderUI.d..ExternalSyntheticLambda0(localSwipeBackLayout, this.FVK));
      }
      AppMethodBeat.o(346944);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/MMFinderUI$screenShotCallback$1", "Lcom/tencent/mm/sdk/platformtools/ScreenShotUtil$ScreenShotCallback;", "onScreenShot", "", "path", "", "dateAdded", "", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements ScreenShotUtil.ScreenShotCallback
  {
    e(MMFinderUI paramMMFinderUI) {}
    
    public final void onScreenShot(String paramString, long paramLong)
    {
      AppMethodBeat.i(346945);
      List localList;
      int i;
      try
      {
        paramString = k.aeZF;
        localList = ((bn)k.d((AppCompatActivity)this.FVK).cq(bn.class)).foB();
        if (((Collection)localList).isEmpty()) {
          break label146;
        }
        i = 1;
      }
      finally
      {
        Log.printErrStackTrace(MMFinderUI.access$getTAG$cp(), paramString, "onScreenShot", new Object[0]);
        AppMethodBeat.o(346945);
        return;
      }
      if (paramString == null)
      {
        Log.i(MMFinderUI.access$getTAG$cp(), "[onScreenShot] extStats is empty");
        AppMethodBeat.o(346945);
        return;
      }
      label129:
      label146:
      label155:
      for (;;)
      {
        paramString = new ec(localList);
        boolean bool = com.tencent.mm.kernel.h.aZW().a((p)paramString, 0);
        paramString = Boolean.valueOf(bool);
        break;
        AppMethodBeat.o(346945);
        return;
        if (i != 0) {}
        for (paramString = localList;; paramString = null)
        {
          if (paramString != null) {
            break label155;
          }
          paramString = null;
          break;
          i = 0;
          break label129;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.MMFinderUI
 * JD-Core Version:    0.7.0.1
 */