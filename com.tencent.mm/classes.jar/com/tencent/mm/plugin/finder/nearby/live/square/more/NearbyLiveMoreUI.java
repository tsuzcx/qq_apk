package com.tencent.mm.plugin.finder.nearby.live.square.more;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.ext.b.b.c;
import com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.a;
import com.tencent.mm.plugin.finder.nearby.f.a;
import com.tencent.mm.plugin.finder.nearby.f.d;
import com.tencent.mm.plugin.finder.nearby.f.e;
import com.tencent.mm.plugin.finder.nearby.f.h;
import com.tencent.mm.plugin.finder.nearby.report.g;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.findersdk.a.by;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.l;
import com.tencent.mm.ui.y;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.g.b.ai;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/square/more/NearbyLiveMoreUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "finishEvent", "", "isForceNightMode", "nearbyLiveSquareMoreFragment", "Lcom/tencent/mm/plugin/finder/nearby/live/square/more/NearbyLiveSquareMoreFragment;", "adapteNightMode", "", "finish", "getLayoutId", "", "getReportTag", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "onPause", "onResume", "showNearbyLiveSquareFragment", "Companion", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public class NearbyLiveMoreUI
  extends MMFinderUI
{
  public static final a ELQ;
  private boolean ALp;
  private boolean Bpk;
  private final NearbyLiveSquareMoreFragment ELR;
  
  static
  {
    AppMethodBeat.i(341176);
    ELQ = new a((byte)0);
    AppMethodBeat.o(341176);
  }
  
  public NearbyLiveMoreUI()
  {
    AppMethodBeat.i(341164);
    this.ELR = new NearbyLiveSquareMoreFragment();
    this.ALp = true;
    AppMethodBeat.o(341164);
  }
  
  private static final boolean a(NearbyLiveMoreUI paramNearbyLiveMoreUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(341170);
    s.u(paramNearbyLiveMoreUI, "this$0");
    paramNearbyLiveMoreUI.finish();
    AppMethodBeat.o(341170);
    return true;
  }
  
  public void _$_clearFindViewByIdCache() {}
  
  public final String efe()
  {
    return "NearbyLiveMoreUI";
  }
  
  public void finish()
  {
    AppMethodBeat.i(341224);
    this.Bpk = true;
    g localg = g.ERj;
    g.eGO();
    super.finish();
    AppMethodBeat.o(341224);
  }
  
  public int getLayoutId()
  {
    return f.e.EHa;
  }
  
  public Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(341204);
    Set localSet = ar.setOf(l.a(ai.cz(by.class)));
    AppMethodBeat.o(341204);
    return localSet;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(341216);
    super.onCreate(paramBundle);
    setMMTitle(f.h.nearby_more_live);
    setBackBtn(new NearbyLiveMoreUI..ExternalSyntheticLambda0(this));
    if (this.ALp)
    {
      getController().setActionbarColor(getContext().getResources().getColor(f.a.Dark_0));
      setBackGroundColorResource(f.a.Dark_0);
      setActionbarColor(getContext().getResources().getColor(f.a.Dark_0));
      findViewById(f.d.root_scroll).setBackgroundColor(getResources().getColor(f.a.Dark_0));
    }
    NearbyLiveSquareMoreFragment localNearbyLiveSquareMoreFragment = this.ELR;
    paramBundle = getIntent();
    if (paramBundle == null)
    {
      paramBundle = null;
      localNearbyLiveSquareMoreFragment.setArguments(paramBundle);
      paramBundle = this.ELR.getArguments();
      if (paramBundle != null) {
        if (!this.ALp) {
          break label202;
        }
      }
    }
    label202:
    for (int i = 1;; i = 0)
    {
      paramBundle.putInt("key_use_dark_style", i);
      getSupportFragmentManager().beginTransaction().a(f.d.EFU, (Fragment)this.ELR).c((Fragment)this.ELR).FX();
      this.Bpk = false;
      AppMethodBeat.o(341216);
      return;
      paramBundle = paramBundle.getExtras();
      break;
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(341196);
    super.onNewIntent(paramIntent);
    NearbyLiveSquareMoreFragment localNearbyLiveSquareMoreFragment = this.ELR;
    if (paramIntent == null) {}
    for (paramIntent = null;; paramIntent = paramIntent.getExtras())
    {
      localNearbyLiveSquareMoreFragment.setArguments(paramIntent);
      AppMethodBeat.o(341196);
      return;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(341239);
    super.onPause();
    if (this.Bpk)
    {
      c.a locala = c.zGj;
      c.oQ(false);
    }
    AppMethodBeat.o(341239);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(341232);
    c.a locala = c.zGj;
    c.oQ(true);
    super.onResume();
    AppMethodBeat.o(341232);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/square/more/NearbyLiveMoreUI$Companion;", "", "()V", "TAG", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.square.more.NearbyLiveMoreUI
 * JD-Core Version:    0.7.0.1
 */