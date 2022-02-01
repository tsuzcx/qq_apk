package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.e;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.expt.hellhound.ext.b.b.c;
import com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.a;
import com.tencent.mm.plugin.finder.nearby.f.a;
import com.tencent.mm.plugin.finder.nearby.f.d;
import com.tencent.mm.plugin.finder.nearby.f.e;
import com.tencent.mm.plugin.finder.nearby.live.square.operation.FinderLiveOperationFragment;
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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveOperationUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "finderLiveFindPageFragment", "Lcom/tencent/mm/plugin/finder/nearby/live/square/operation/FinderLiveOperationFragment;", "finishEvent", "", "isForceNightMode", "adapteNightMode", "", "finish", "getLayoutId", "", "getReportTag", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "onPause", "onResume", "showNearbyLiveSquareFragment", "Companion", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public class FinderLiveOperationUI
  extends MMFinderUI
{
  public static final a Bpi;
  private boolean ALp;
  private final FinderLiveOperationFragment Bpj;
  private boolean Bpk;
  
  static
  {
    AppMethodBeat.i(364587);
    Bpi = new a((byte)0);
    AppMethodBeat.o(364587);
  }
  
  public FinderLiveOperationUI()
  {
    AppMethodBeat.i(364570);
    this.Bpj = new FinderLiveOperationFragment();
    AppMethodBeat.o(364570);
  }
  
  private static final void a(FinderLiveOperationUI paramFinderLiveOperationUI, View paramView)
  {
    AppMethodBeat.i(364579);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramFinderLiveOperationUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderLiveOperationUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderLiveOperationUI, "this$0");
    paramFinderLiveOperationUI.onBackPressed();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/feed/ui/FinderLiveOperationUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(364579);
  }
  
  public void _$_clearFindViewByIdCache() {}
  
  public final String efe()
  {
    return "FinderLiveOperationUI";
  }
  
  public void finish()
  {
    AppMethodBeat.i(364638);
    this.Bpk = true;
    g localg = g.ERj;
    g.eGO();
    super.finish();
    AppMethodBeat.o(364638);
  }
  
  public int getLayoutId()
  {
    if (this.ALp) {
      return f.e.EGI;
    }
    return f.e.EGH;
  }
  
  public Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(364608);
    Set localSet = ar.setOf(l.a(ai.cz(by.class)));
    AppMethodBeat.o(364608);
    return localSet;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool = true;
    AppMethodBeat.i(364628);
    FinderLiveOperationFragment localFinderLiveOperationFragment;
    if (getIntent().getIntExtra("key_use_dark_style", 1) == 1)
    {
      this.ALp = bool;
      super.onCreate(paramBundle);
      paramBundle = getSupportActionBar();
      if (paramBundle != null) {
        paramBundle.hide();
      }
      if (this.ALp)
      {
        getController().setActionbarColor(getContext().getResources().getColor(f.a.Dark_0));
        setBackGroundColorResource(f.a.Dark_0);
      }
      findViewById(f.d.EFG).setOnClickListener(new FinderLiveOperationUI..ExternalSyntheticLambda0(this));
      paramBundle = (TextView)findViewById(f.d.EFS);
      float f = com.tencent.mm.cd.a.bs((Context)getContext(), a.e.ActionBarTextSize);
      paramBundle.setTextSize(0, com.tencent.mm.cd.a.jO((Context)getContext()) * f);
      paramBundle = getIntent().getStringExtra("key_page_title");
      if (!TextUtils.isEmpty((CharSequence)paramBundle)) {
        ((TextView)findViewById(f.d.EFS)).setText((CharSequence)paramBundle);
      }
      findViewById(f.d.searchEntrance).setVisibility(4);
      localFinderLiveOperationFragment = this.Bpj;
      paramBundle = getIntent();
      if (paramBundle != null) {
        break label261;
      }
    }
    label261:
    for (paramBundle = null;; paramBundle = paramBundle.getExtras())
    {
      localFinderLiveOperationFragment.setArguments(paramBundle);
      getSupportFragmentManager().beginTransaction().a(f.d.EFU, (Fragment)this.Bpj).c((Fragment)this.Bpj).FX();
      this.Bpk = false;
      AppMethodBeat.o(364628);
      return;
      bool = false;
      break;
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(364615);
    super.onNewIntent(paramIntent);
    FinderLiveOperationFragment localFinderLiveOperationFragment = this.Bpj;
    if (paramIntent == null) {}
    for (paramIntent = null;; paramIntent = paramIntent.getExtras())
    {
      localFinderLiveOperationFragment.setArguments(paramIntent);
      AppMethodBeat.o(364615);
      return;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(364650);
    super.onPause();
    if (this.Bpk)
    {
      c.a locala = c.zGj;
      c.oQ(false);
    }
    AppMethodBeat.o(364650);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(364643);
    c.a locala = c.zGj;
    c.oQ(true);
    super.onResume();
    AppMethodBeat.o(364643);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveOperationUI$Companion;", "", "()V", "TAG", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLiveOperationUI
 * JD-Core Version:    0.7.0.1
 */