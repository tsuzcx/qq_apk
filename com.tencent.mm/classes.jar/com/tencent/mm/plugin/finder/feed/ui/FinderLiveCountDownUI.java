package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.i;
import com.tencent.mm.plugin.finder.live.viewmodel.j;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.f.j.a;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.u;

@a(39)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveCountDownUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "landscapeType", "", "Ljava/lang/Integer;", "getForceOrientation", "getLayoutId", "getOrientation", "getReportTag", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onConfigurationChanged", "", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateBeforeSetContentView", "onDestroy", "publishEvent", "resetData", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveCountDownUI
  extends MMFinderUI
{
  public static final FinderLiveCountDownUI.a BoE;
  private Integer Bob;
  
  static
  {
    AppMethodBeat.i(364859);
    BoE = new FinderLiveCountDownUI.a((byte)0);
    AppMethodBeat.o(364859);
  }
  
  public FinderLiveCountDownUI()
  {
    AppMethodBeat.i(364830);
    Object localObject = getIntent();
    if (localObject == null) {}
    for (localObject = null;; localObject = Integer.valueOf(((Intent)localObject).getIntExtra("LANDSCAPE_TYPE", f.j.a.adwr.ordinal())))
    {
      this.Bob = ((Integer)localObject);
      AppMethodBeat.o(364830);
      return;
    }
  }
  
  private int getOrientation()
  {
    AppMethodBeat.i(364837);
    Object localObject = getIntent();
    int i;
    if (localObject == null)
    {
      localObject = null;
      this.Bob = ((Integer)localObject);
      localObject = this.Bob;
      i = f.j.a.adws.ordinal();
      if (localObject != null) {
        break label74;
      }
      label37:
      i = f.j.a.adwt.ordinal();
      if (localObject != null) {
        break label89;
      }
    }
    label74:
    label89:
    while (((Integer)localObject).intValue() != i)
    {
      AppMethodBeat.o(364837);
      return -1;
      localObject = Integer.valueOf(((Intent)localObject).getIntExtra("LANDSCAPE_TYPE", f.j.a.adwr.ordinal()));
      break;
      if (((Integer)localObject).intValue() != i) {
        break label37;
      }
      AppMethodBeat.o(364837);
      return 0;
    }
    AppMethodBeat.o(364837);
    return 8;
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final String efe()
  {
    return "Finder.FinderLiveCountDownUI";
  }
  
  public final int getForceOrientation()
  {
    AppMethodBeat.i(364881);
    int i = getOrientation();
    AppMethodBeat.o(364881);
    return i;
  }
  
  public final int getLayoutId()
  {
    return p.f.Cdv;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(364875);
    Set localSet = ar.setOf(j.class);
    AppMethodBeat.o(364875);
    return localSet;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(364899);
    kotlin.g.b.s.u(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    Log.i("Finder.FinderLiveCountDownUI", kotlin.g.b.s.X("onConfigurationChanged: orientation = ", Integer.valueOf(paramConfiguration.orientation)));
    AppMethodBeat.o(364899);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(364885);
    super.onCreate(paramBundle);
    setRequestedOrientation(getOrientation());
    paramBundle = k.aeZF;
    ((j)k.d((AppCompatActivity)this).q(j.class)).callback = ((b)new b(this));
    AppMethodBeat.o(364885);
  }
  
  public final void onCreateBeforeSetContentView()
  {
    AppMethodBeat.i(364869);
    super.onCreateBeforeSetContentView();
    this.FVH = true;
    setTheme(p.i.MMTheme_FinderNoTitleTranslucent);
    AppMethodBeat.o(364869);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(364889);
    super.onDestroy();
    k localk = k.aeZF;
    ((j)k.d((AppCompatActivity)this).q(j.class)).exf();
    localk = k.aeZF;
    ((j)k.d((AppCompatActivity)this).q(j.class)).callback = null;
    AppMethodBeat.o(364889);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "success", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<Boolean, ah>
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