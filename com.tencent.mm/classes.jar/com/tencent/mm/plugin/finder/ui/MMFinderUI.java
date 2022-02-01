package com.tencent.mm.plugin.finder.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.ArrayMap;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.f.b.a.cx;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.cgi.dc;
import com.tencent.mm.plugin.finder.report.e;
import com.tencent.mm.plugin.finder.report.e.a;
import com.tencent.mm.plugin.findersdk.a.aa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.ScreenShotUtil;
import com.tencent.mm.sdk.platformtools.ScreenShotUtil.ScreenShotCallback;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g.a;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "activeFinish", "", "callOnce", "needChangeOrientation", "getNeedChangeOrientation", "()Z", "setNeedChangeOrientation", "(Z)V", "screenShotCallback", "com/tencent/mm/plugin/finder/ui/MMFinderUI$screenShotCallback$1", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI$screenShotCallback$1;", "unInitTask", "Ljava/lang/Runnable;", "finish", "", "getCommentScene", "", "getLayoutId", "getReportTag", "", "getReportType", "importUIComponents", "set", "Ljava/util/HashSet;", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "initBusiness", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "setRequestedOrientation", "requestedOrientation", "uninitBusiness", "uninitBusinessCheck", "Companion", "plugin-finder-base_release"})
public abstract class MMFinderUI
  extends MMActivity
{
  public static final a AwW = new a((byte)0);
  private static final String TAG = "Finder.MMFinderUI";
  public boolean AwU;
  private final d AwV = new d(this);
  private HashMap _$_findViewCache;
  private boolean xZp;
  private Runnable xZq;
  private boolean xZr;
  
  private final void dxl()
  {
    if (this.xZr) {
      return;
    }
    this.xZr = true;
  }
  
  public void _$_clearFindViewByIdCache()
  {
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
  }
  
  public View _$_findCachedViewById(int paramInt)
  {
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  public int duR()
  {
    return 0;
  }
  
  public String dvl()
  {
    String str = getClass().getSimpleName();
    p.j(str, "this.javaClass.simpleName");
    return str;
  }
  
  public void finish()
  {
    super.finish();
    Log.i(TAG, "finish " + getClass().getSimpleName() + ", " + hashCode() + ", " + getTaskId() + ", " + isPaused());
    if (!isPaused()) {
      this.xZq = ((Runnable)new b(this));
    }
    this.xZp = true;
  }
  
  public int getCommentScene()
  {
    return 0;
  }
  
  public int getLayoutId()
  {
    return 0;
  }
  
  public void importUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    p.k(paramHashSet, "set");
    super.importUIComponents(paramHashSet);
    p.k(aa.class, "$this$uicClass");
    Object localObject1 = com.tencent.mm.ui.component.g.Xox;
    Object localObject2 = com.tencent.mm.ui.component.g.hUc().get(aa.class.getName());
    localObject1 = localObject2;
    if (!(localObject2 instanceof Class)) {
      localObject1 = null;
    }
    localObject1 = (Class)localObject1;
    if (localObject1 == null) {
      throw ((Throwable)new RuntimeException(aa.class + " never import any instance."));
    }
    paramHashSet.add(localObject1);
    paramHashSet.add(com.tencent.mm.plugin.secdata.ui.a.class);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Object localObject = e.zUG;
    localObject = dvl();
    int i = hashCode();
    p.k(localObject, "tag");
    e.a locala = e.ap(i, true);
    if (locala != null)
    {
      p.k(localObject, "<set-?>");
      locala.tag = ((String)localObject);
      locala.zUH = e.zUF;
      locala.zUI = cm.bfE();
    }
    super.onCreate(paramBundle);
    Log.i(TAG, "onCreate " + getClass().getSimpleName() + ", " + hashCode() + ", " + getTaskId() + '}');
    ((com.tencent.mm.plugin.b)h.ae(com.tencent.mm.plugin.b.class)).onEnterFinder(this);
    com.tencent.mm.ae.d.a(0L, (kotlin.g.a.a)new c(this));
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Log.i(TAG, "onDestroy " + getClass().getSimpleName() + ", " + hashCode() + ", " + getTaskId() + ", " + this.xZp);
    if (!this.xZp) {
      dxl();
    }
    ((com.tencent.mm.plugin.b)h.ae(com.tencent.mm.plugin.b.class)).onExitFinder(this);
  }
  
  public void onPause()
  {
    super.onPause();
    ((com.tencent.mm.plugin.b)h.ae(com.tencent.mm.plugin.b.class)).getFinderSyncExtension().b(this);
    Log.i(TAG, "onPause " + getClass().getSimpleName() + ", " + hashCode() + ", " + getTaskId() + ", " + this.xZq);
    Object localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.dUR().aSr()).intValue() == 1)
    {
      Log.i(TAG, "REPORT_WHEN_SCREEN_SHOT remove");
      ScreenShotUtil.setScreenShotCallback((Context)this, null);
    }
    localObject1 = this.xZq;
    if (localObject1 != null) {
      ((Runnable)localObject1).run();
    }
    this.xZq = null;
    e.a locala;
    Object localObject2;
    int i;
    if (isFinishing())
    {
      localObject1 = e.zUG;
      int j = hashCode();
      localObject1 = (Activity)this;
      p.k(localObject1, "activity");
      locala = e.Pe(j);
      if (locala != null)
      {
        localObject2 = e.zUG;
        if ((locala.zUH > 0L) && (locala.zUI > 0L) && (locala.zUJ > 0L) && (locala.zUK >= 0L) && (locala.zUL > 0L) && (locala.zUL > locala.zUK) && (locala.zUJ > locala.zUI) && (locala.zUI > locala.zUH))
        {
          i = 1;
          if (i != 0) {
            break label377;
          }
          Log.w("FinderEnterCostReporter", "report21680: invalid data ".concat(String.valueOf(locala)));
          label305:
          e.zUE.remove(Integer.valueOf(j));
        }
      }
      else if (((com.tencent.mm.plugin.b)h.ae(com.tencent.mm.plugin.b.class)).dy((Context)localObject1))
      {
        Log.i("FinderEnterCostReporter", "notifyFinish: remain size " + e.zUE.size());
        e.zUE.clear();
      }
    }
    label377:
    do
    {
      return;
      i = 0;
      break;
      localObject2 = new cx();
      ((cx)localObject2).ahR();
      ((cx)localObject2).gK(4L);
      String str = e.a(locala).toString();
      p.j(str, "buildJson(data).toString()");
      ((cx)localObject2).nX(n.l(str, ",", ";", false));
      ((cx)localObject2).nY(locala.tag);
      ((cx)localObject2).nZ(String.valueOf(locala.zUL - locala.zUH));
      ((cx)localObject2).bpa();
      Log.i("FinderEnterCostReporter", "report21680 info:" + ((cx)localObject2).agI());
      break label305;
      localObject1 = e.zUG;
      i = hashCode();
      localObject1 = e.Pe(i);
    } while ((localObject1 == null) || (((e.a)localObject1).zUK != 0L) || (((e.a)localObject1).zUL != 0L));
    Log.i("FinderEnterCostReporter", "notifyOnPause: abandon useless data ".concat(String.valueOf(localObject1)));
    e.zUE.remove(Integer.valueOf(i));
  }
  
  public void onResume()
  {
    Object localObject = e.zUG;
    localObject = e.Pe(hashCode());
    int i;
    if (localObject != null)
    {
      if (((e.a)localObject).zUJ != 0L) {
        break label272;
      }
      i = 1;
      if (i == 0) {
        break label277;
      }
    }
    for (;;)
    {
      if (localObject != null) {
        ((e.a)localObject).zUJ = cm.bfE();
      }
      super.onResume();
      ((com.tencent.mm.plugin.b)h.ae(com.tencent.mm.plugin.b.class)).getFinderSyncExtension().a(this);
      Log.i(TAG, "onResume " + getClass().getSimpleName() + ", " + hashCode() + ", " + getTaskId());
      localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (((Boolean)com.tencent.mm.plugin.finder.storage.d.dUy().aSr()).booleanValue())
      {
        localObject = new Intent((Context)this, Class.forName("com.tencent.testcrash"));
        localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/finder/ui/MMFinderUI", "onResume", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/finder/ui/MMFinderUI", "onResume", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.dUR().aSr()).intValue() == 1)
      {
        Log.i(TAG, "REPORT_WHEN_SCREEN_SHOT register");
        ScreenShotUtil.setScreenShotCallback((Context)this, (ScreenShotUtil.ScreenShotCallback)this.AwV);
      }
      return;
      label272:
      i = 0;
      break;
      label277:
      localObject = null;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @SuppressLint({"SourceLockedOrientationActivity"})
  public void setRequestedOrientation(int paramInt)
  {
    if (!this.AwU)
    {
      super.setRequestedOrientation(1);
      return;
    }
    super.setRequestedOrientation(paramInt);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/MMFinderUI$Companion;", "", "()V", "TAG", "", "plugin-finder-base_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(MMFinderUI paramMMFinderUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(258517);
      MMFinderUI.c(this.AwX);
      AppMethodBeat.o(258517);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    c(MMFinderUI paramMMFinderUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/MMFinderUI$screenShotCallback$1", "Lcom/tencent/mm/sdk/platformtools/ScreenShotUtil$ScreenShotCallback;", "onScreenShot", "", "path", "", "dateAdded", "", "plugin-finder-base_release"})
  public static final class d
    implements ScreenShotUtil.ScreenShotCallback
  {
    public final void onScreenShot(String paramString, long paramLong)
    {
      AppMethodBeat.i(262593);
      for (;;)
      {
        List localList;
        int i;
        try
        {
          paramString = com.tencent.mm.ui.component.g.Xox;
          localList = ((aa)com.tencent.mm.ui.component.g.b((AppCompatActivity)this.AwX).bE(aa.class)).ekZ();
          if (((Collection)localList).isEmpty()) {
            break label129;
          }
          i = 1;
        }
        catch (Throwable paramString)
        {
          Log.printErrStackTrace(MMFinderUI.access$getTAG$cp(), paramString, "onScreenShot", new Object[0]);
          AppMethodBeat.o(262593);
          return;
        }
        if (paramString != null)
        {
          paramString = new dc(localList);
          h.aGY().b((com.tencent.mm.an.q)paramString);
          AppMethodBeat.o(262593);
          return;
        }
        Log.i(MMFinderUI.access$getTAG$cp(), "[onScreenShot] extStats is empty");
        AppMethodBeat.o(262593);
        return;
        for (;;)
        {
          if (i == 0) {
            break label135;
          }
          paramString = localList;
          break;
          label129:
          i = 0;
        }
        label135:
        paramString = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.MMFinderUI
 * JD-Core Version:    0.7.0.1
 */