package com.tencent.mm.plugin.kidswatch.ui.login;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@com.tencent.mm.ui.base.a(35)
@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirstChooseHelpUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "finish", "", "getForceOrientation", "", "getLayoutId", "initView", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-kidswatch_release"})
public final class KidsWatchLoginFirstChooseHelpUI
  extends MMActivity
{
  public static final a yBq;
  private HashMap _$_findViewCache;
  
  static
  {
    AppMethodBeat.i(256264);
    yBq = new a((byte)0);
    AppMethodBeat.o(256264);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(256266);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(256266);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(256265);
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
    AppMethodBeat.o(256265);
    return localView1;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(256261);
    super.finish();
    overridePendingTransition(2130771986, 2130772130);
    AppMethodBeat.o(256261);
  }
  
  public final int getForceOrientation()
  {
    return 1;
  }
  
  public final int getLayoutId()
  {
    return 2131495134;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(256263);
    ((KidsWatchHeadComponent)_$_findCachedViewById(2131302263)).setCloseIconResId(2131230855);
    ((KidsWatchHeadComponent)_$_findCachedViewById(2131302263)).setCloseBtnCallBack((kotlin.g.a.a)new b(this));
    Object localObject = com.tencent.mm.plugin.kidswatch.b.a.yBL;
    localObject = getContext();
    p.g(localObject, "context");
    com.tencent.mm.plugin.kidswatch.b.a.a((Context)localObject, (LinearLayout)_$_findCachedViewById(2131298013), null);
    AppMethodBeat.o(256263);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(256262);
    finish();
    super.onBackPressed();
    AppMethodBeat.o(256262);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(256260);
    super.onCreate(paramBundle);
    paramBundle = getSupportActionBar();
    if (paramBundle == null) {
      p.hyc();
    }
    paramBundle.hide();
    setSelfNavigationBarVisible(8);
    paramBundle = getContext();
    p.g(paramBundle, "context");
    setActionbarColor(paramBundle.getResources().getColor(2131099846));
    paramBundle = getContext();
    p.g(paramBundle, "context");
    setNavigationbarColor(paramBundle.getResources().getColor(2131099846));
    initView();
    overridePendingTransition(2130772132, 2130771986);
    Log.i("MicroMsg.KidsWatchLoginChooseHelpUI", "Enter KidsWatch Login Help UI");
    AppMethodBeat.o(256260);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirstChooseHelpUI$Companion;", "", "()V", "TAG", "", "plugin-kidswatch_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.ui.login.KidsWatchLoginFirstChooseHelpUI
 * JD-Core Version:    0.7.0.1
 */