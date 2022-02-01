package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.k;
import com.tencent.mm.plugin.finder.live.viewmodel.h;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.f.i.a;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.a.b;
import kotlin.g.a.s;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@a(39)
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveCountDownUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "landscapeType", "", "Ljava/lang/Integer;", "getForceOrientation", "getLayoutId", "getOrientation", "getReportTag", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onConfigurationChanged", "", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateBeforeSetContentView", "onDestroy", "publishEvent", "resetData", "Companion", "plugin-finder-live_release"})
public final class FinderLiveCountDownUI
  extends MMFinderUI
{
  public static final a xOH;
  private HashMap _$_findViewCache;
  private Integer xNY;
  
  static
  {
    AppMethodBeat.i(232535);
    xOH = new a((byte)0);
    AppMethodBeat.o(232535);
  }
  
  public FinderLiveCountDownUI()
  {
    AppMethodBeat.i(232534);
    Object localObject = getIntent();
    if (localObject != null) {}
    for (localObject = Integer.valueOf(((Intent)localObject).getIntExtra("LANDSCAPE_TYPE", f.i.a.VSj.ordinal()));; localObject = null)
    {
      this.xNY = ((Integer)localObject);
      AppMethodBeat.o(232534);
      return;
    }
  }
  
  private int getOrientation()
  {
    AppMethodBeat.i(232521);
    Object localObject = getIntent();
    int i;
    if (localObject != null)
    {
      localObject = Integer.valueOf(((Intent)localObject).getIntExtra("LANDSCAPE_TYPE", f.i.a.VSj.ordinal()));
      this.xNY = ((Integer)localObject);
      localObject = this.xNY;
      i = f.i.a.VSk.ordinal();
      if (localObject != null) {
        break label74;
      }
      label51:
      i = f.i.a.VSl.ordinal();
      if (localObject != null) {
        break label89;
      }
    }
    label74:
    label89:
    while (((Integer)localObject).intValue() != i)
    {
      AppMethodBeat.o(232521);
      return -1;
      localObject = null;
      break;
      if (((Integer)localObject).intValue() != i) {
        break label51;
      }
      AppMethodBeat.o(232521);
      return 0;
    }
    AppMethodBeat.o(232521);
    return 8;
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(232540);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(232540);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(232539);
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
    AppMethodBeat.o(232539);
    return localView1;
  }
  
  public final String dvl()
  {
    return "Finder.FinderLiveCountDownUI";
  }
  
  public final int getForceOrientation()
  {
    AppMethodBeat.i(232517);
    int i = getOrientation();
    AppMethodBeat.o(232517);
    return i;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_live_count_down_ui;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(232516);
    Set localSet = ak.setOf(h.class);
    AppMethodBeat.o(232516);
    return localSet;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(232532);
    p.k(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    Log.i("Finder.FinderLiveCountDownUI", "onConfigurationChanged: orientation = " + paramConfiguration.orientation);
    AppMethodBeat.o(232532);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(232524);
    super.onCreate(paramBundle);
    setRequestedOrientation(getOrientation());
    paramBundle = g.Xox;
    ((h)g.b((AppCompatActivity)this).i(h.class)).callback = ((b)new b(this));
    AppMethodBeat.o(232524);
  }
  
  public final void onCreateBeforeSetContentView()
  {
    AppMethodBeat.i(232514);
    super.onCreateBeforeSetContentView();
    this.AwU = true;
    setTheme(b.k.MMTheme_FinderNoTitleTranslucent);
    AppMethodBeat.o(232514);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(232527);
    super.onDestroy();
    g localg = g.Xox;
    ((h)g.b((AppCompatActivity)this).i(h.class)).dFU();
    AppMethodBeat.o(232527);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveCountDownUI$Companion;", "", "()V", "TAG", "", "plugin-finder-live_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "success", "", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderLiveCountDownUI$onCreate$1$1"})
  static final class b
    extends q
    implements b<Boolean, x>
  {
    b(FinderLiveCountDownUI paramFinderLiveCountDownUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLiveCountDownUI
 * JD-Core Version:    0.7.0.1
 */