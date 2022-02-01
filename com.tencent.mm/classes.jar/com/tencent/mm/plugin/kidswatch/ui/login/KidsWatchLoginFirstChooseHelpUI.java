package com.tencent.mm.plugin.kidswatch.ui.login;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.kidswatch.b.a;
import com.tencent.mm.plugin.kidswatch.b.b;
import com.tencent.mm.plugin.kidswatch.b.d;
import com.tencent.mm.plugin.kidswatch.b.e;
import com.tencent.mm.plugin.kidswatch.b.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@com.tencent.mm.ui.base.a(35)
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirstChooseHelpUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "finish", "", "getForceOrientation", "", "getLayoutId", "initView", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-kidswatch_release"})
public final class KidsWatchLoginFirstChooseHelpUI
  extends MMActivity
{
  public static final a EcG;
  private HashMap _$_findViewCache;
  
  static
  {
    AppMethodBeat.i(251634);
    EcG = new a((byte)0);
    AppMethodBeat.o(251634);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(251636);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(251636);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(251635);
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
    AppMethodBeat.o(251635);
    return localView1;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(251628);
    super.finish();
    overridePendingTransition(b.a.anim_not_change, b.a.push_down_out);
    AppMethodBeat.o(251628);
  }
  
  public final int getForceOrientation()
  {
    return 1;
  }
  
  public final int getLayoutId()
  {
    return b.f.Ebk;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(251631);
    ((KidsWatchHeadComponent)_$_findCachedViewById(b.e.EaG)).setCloseIconResId(b.d.actionbar_icon_dark_back);
    ((KidsWatchHeadComponent)_$_findCachedViewById(b.e.EaG)).setCloseBtnCallBack((kotlin.g.a.a)new b(this));
    Object localObject = com.tencent.mm.plugin.kidswatch.b.a.Edb;
    localObject = getContext();
    p.j(localObject, "context");
    com.tencent.mm.plugin.kidswatch.b.a.a((Context)localObject, (LinearLayout)_$_findCachedViewById(b.e.Eax), null);
    AppMethodBeat.o(251631);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(251629);
    finish();
    super.onBackPressed();
    AppMethodBeat.o(251629);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(251624);
    super.onCreate(paramBundle);
    paramBundle = getSupportActionBar();
    if (paramBundle == null) {
      p.iCn();
    }
    paramBundle.hide();
    setSelfNavigationBarVisible(8);
    paramBundle = getContext();
    p.j(paramBundle, "context");
    setActionbarColor(paramBundle.getResources().getColor(b.b.Eap));
    paramBundle = getContext();
    p.j(paramBundle, "context");
    setNavigationbarColor(paramBundle.getResources().getColor(b.b.Eap));
    initView();
    overridePendingTransition(b.a.push_up_in, b.a.anim_not_change);
    Log.i("MicroMsg.KidsWatchLoginChooseHelpUI", "Enter KidsWatch Login Help UI");
    AppMethodBeat.o(251624);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirstChooseHelpUI$Companion;", "", "()V", "TAG", "", "plugin-kidswatch_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(KidsWatchLoginFirstChooseHelpUI paramKidsWatchLoginFirstChooseHelpUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.ui.login.KidsWatchLoginFirstChooseHelpUI
 * JD-Core Version:    0.7.0.1
 */