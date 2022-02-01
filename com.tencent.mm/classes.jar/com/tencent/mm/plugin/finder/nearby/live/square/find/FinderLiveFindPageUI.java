package com.tencent.mm.plugin.finder.nearby.live.square.find;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.e;
import com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.a;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.nearby.f.a;
import com.tencent.mm.plugin.finder.nearby.f.d;
import com.tencent.mm.plugin.finder.nearby.f.e;
import com.tencent.mm.plugin.finder.nearby.f.h;
import com.tencent.mm.plugin.finder.nearby.report.g;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.findersdk.a.ap;
import com.tencent.mm.plugin.findersdk.a.by;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.component.l;
import com.tencent.mm.ui.y;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.g.b.ai;
import kotlin.g.b.s;

@com.tencent.mm.ui.widget.pulldown.c(0)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/square/find/FinderLiveFindPageUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "finderLiveFindPageFragment", "Lcom/tencent/mm/plugin/finder/nearby/live/square/find/FinderLiveFindPageFragment;", "finishEvent", "", "isForceNightMode", "livePostHelper", "Lcom/tencent/mm/plugin/finder/live/ui/livepost/FinderLivePostForNearby;", "adapteNightMode", "", "finish", "getLayoutId", "", "getReportTag", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "initNewUI", "initOldUI", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "onPause", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "showNearbyLiveSquareFragment", "Companion", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveFindPageUI
  extends MMFinderUI
{
  public static final a ELO;
  private final boolean ALp;
  private boolean Bpk;
  private com.tencent.mm.plugin.finder.live.ui.livepost.b ELF;
  private final FinderLiveFindPageFragment ELP;
  
  static
  {
    AppMethodBeat.i(341152);
    ELO = new a((byte)0);
    AppMethodBeat.o(341152);
  }
  
  public FinderLiveFindPageUI()
  {
    AppMethodBeat.i(341135);
    this.ELP = new FinderLiveFindPageFragment();
    com.tencent.mm.plugin.finder.nearby.abtest.a locala = com.tencent.mm.plugin.finder.nearby.abtest.a.EHr;
    this.ALp = com.tencent.mm.plugin.finder.nearby.abtest.a.eEi();
    AppMethodBeat.o(341135);
  }
  
  private static final void a(FinderLiveFindPageUI paramFinderLiveFindPageUI, View paramView)
  {
    AppMethodBeat.i(341141);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderLiveFindPageUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/nearby/live/square/find/FinderLiveFindPageUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderLiveFindPageUI, "this$0");
    paramFinderLiveFindPageUI.onBackPressed();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/nearby/live/square/find/FinderLiveFindPageUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(341141);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final String efe()
  {
    return "FinderLiveFindPageUI";
  }
  
  public final void finish()
  {
    AppMethodBeat.i(341212);
    this.Bpk = true;
    g localg = g.ERj;
    g.eGO();
    super.finish();
    AppMethodBeat.o(341212);
  }
  
  public final int getLayoutId()
  {
    if (this.ALp) {
      return f.e.EGI;
    }
    return f.e.EGH;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(341187);
    Set localSet = ar.setOf(new Class[] { com.tencent.mm.plugin.finder.nearby.b.class, l.a(ai.cz(by.class)), com.tencent.mm.plugin.finder.nearby.accessibility.a.class, l.a(ai.cz(ap.class)) });
    AppMethodBeat.o(341187);
    return localSet;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(341247);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.tencent.mm.plugin.finder.live.ui.livepost.b localb = this.ELF;
    if (localb != null) {
      localb.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    AppMethodBeat.o(341247);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(341206);
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 21)
    {
      getWindow().setNavigationBarColor(0);
      getWindow().addFlags(134217728);
    }
    this.ELF = new com.tencent.mm.plugin.finder.live.ui.livepost.b((Activity)this);
    paramBundle = getSupportActionBar();
    if (paramBundle != null) {
      paramBundle.hide();
    }
    if (this.ALp)
    {
      getController().setActionbarColor(getContext().getResources().getColor(f.a.Dark_0));
      setBackGroundColorResource(f.a.Dark_0);
    }
    findViewById(f.d.EFG).setOnClickListener(new FinderLiveFindPageUI..ExternalSyntheticLambda0(this));
    paramBundle = (TextView)findViewById(f.d.EFS);
    float f = com.tencent.mm.cd.a.bs((Context)getContext(), a.e.ActionBarTextSize);
    paramBundle.setTextSize(0, com.tencent.mm.cd.a.jO((Context)getContext()) * f);
    paramBundle = com.tencent.d.a.a.a.a.a.ahiX;
    int i = ((Number)com.tencent.d.a.a.a.a.a.jUc().bmg()).intValue();
    if (i == 1)
    {
      paramBundle = findViewById(f.d.searchEntrance);
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
      paramBundle = (TextView)findViewById(f.d.EFS);
      if (paramBundle != null) {
        paramBundle.setText((CharSequence)getContext().getResources().getString(f.h.nearby_more_live));
      }
      paramBundle = findViewById(f.d.EFR);
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
      s.X("useNewUI:", Integer.valueOf(i));
      com.tencent.e.f.h.jXD();
      FinderLiveFindPageFragment localFinderLiveFindPageFragment = this.ELP;
      paramBundle = getIntent();
      if (paramBundle != null) {
        break label511;
      }
      paramBundle = null;
      label281:
      localFinderLiveFindPageFragment.setArguments(paramBundle);
      paramBundle = this.ELP.getArguments();
      if (paramBundle != null) {
        if (!this.ALp) {
          break label519;
        }
      }
    }
    label519:
    for (i = 1;; i = 0)
    {
      paramBundle.putInt("key_use_dark_style", i);
      getSupportFragmentManager().beginTransaction().a(f.d.EFU, (Fragment)this.ELP).c((Fragment)this.ELP).FX();
      this.ELP.aG((Activity)this);
      paramBundle = k.aeZF;
      ((com.tencent.mm.plugin.finder.nearby.b)k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.finder.nearby.b.class)).eEa();
      paramBundle = com.tencent.d.a.a.a.a.a.ahiX;
      if (((Number)com.tencent.d.a.a.a.a.a.jUc().bmg()).intValue() == 0) {
        ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().TL("FinderLiveEntrance");
      }
      this.Bpk = false;
      paramBundle = com.tencent.mm.plugin.finder.nearby.report.b.EQs;
      com.tencent.mm.plugin.finder.nearby.report.b.eGI();
      AppMethodBeat.o(341206);
      return;
      paramBundle = findViewById(f.d.searchEntrance);
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
      paramBundle = (TextView)findViewById(f.d.EFS);
      if (paramBundle != null) {
        paramBundle.setText((CharSequence)getContext().getResources().getString(f.h.finder_live_find_page));
      }
      paramBundle = findViewById(f.d.EFR);
      if (paramBundle == null) {
        break;
      }
      paramBundle.setVisibility(8);
      break;
      label511:
      paramBundle = paramBundle.getExtras();
      break label281;
    }
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(341179);
    super.onNewIntent(paramIntent);
    FinderLiveFindPageFragment localFinderLiveFindPageFragment = this.ELP;
    if (paramIntent == null) {}
    for (paramIntent = null;; paramIntent = paramIntent.getExtras())
    {
      localFinderLiveFindPageFragment.setArguments(paramIntent);
      AppMethodBeat.o(341179);
      return;
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(341230);
    super.onPause();
    if (this.Bpk)
    {
      localObject = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
      com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.oQ(false);
    }
    Object localObject = this.ELF;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.ui.livepost.b)localObject).reset();
    }
    AppMethodBeat.o(341230);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(341250);
    s.u(paramArrayOfString, "permissions");
    s.u(paramArrayOfInt, "grantResults");
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    com.tencent.mm.plugin.finder.live.ui.livepost.b localb = this.ELF;
    if (localb != null) {
      localb.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    }
    AppMethodBeat.o(341250);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(341222);
    c.a locala = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
    com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.oQ(true);
    super.onResume();
    AppMethodBeat.o(341222);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/square/find/FinderLiveFindPageUI$Companion;", "", "()V", "TAG", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.square.find.FinderLiveFindPageUI
 * JD-Core Version:    0.7.0.1
 */