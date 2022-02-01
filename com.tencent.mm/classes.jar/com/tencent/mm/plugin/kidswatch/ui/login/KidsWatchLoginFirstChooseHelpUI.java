package com.tencent.mm.plugin.kidswatch.ui.login;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.LinearLayout;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.kidswatch.b.a;
import com.tencent.mm.plugin.kidswatch.b.b;
import com.tencent.mm.plugin.kidswatch.b.d;
import com.tencent.mm.plugin.kidswatch.b.e;
import com.tencent.mm.plugin.kidswatch.b.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@com.tencent.mm.ui.base.a(35)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirstChooseHelpUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "finish", "", "getForceOrientation", "", "getLayoutId", "initView", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-kidswatch_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class KidsWatchLoginFirstChooseHelpUI
  extends MMActivity
{
  public static final KidsWatchLoginFirstChooseHelpUI.a JTG;
  
  static
  {
    AppMethodBeat.i(262187);
    JTG = new KidsWatchLoginFirstChooseHelpUI.a((byte)0);
    AppMethodBeat.o(262187);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final void finish()
  {
    AppMethodBeat.i(262213);
    super.finish();
    overridePendingTransition(b.a.anim_not_change, b.a.push_down_out);
    AppMethodBeat.o(262213);
  }
  
  public final int getForceOrientation()
  {
    return 1;
  }
  
  public final int getLayoutId()
  {
    return b.f.JSs;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(262230);
    ((KidsWatchHeadComponent)findViewById(b.e.JRO)).setCloseIconResId(b.d.actionbar_icon_dark_back);
    ((KidsWatchHeadComponent)findViewById(b.e.JRO)).setCloseBtnCallBack((kotlin.g.a.a)new b(this));
    Object localObject = com.tencent.mm.plugin.kidswatch.b.a.JTW;
    localObject = getContext();
    s.s(localObject, "context");
    com.tencent.mm.plugin.kidswatch.b.a.a((Context)localObject, (LinearLayout)findViewById(b.e.JRF), null);
    AppMethodBeat.o(262230);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(262222);
    finish();
    super.onBackPressed();
    AppMethodBeat.o(262222);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(262201);
    super.onCreate(paramBundle);
    paramBundle = getSupportActionBar();
    s.checkNotNull(paramBundle);
    paramBundle.hide();
    setSelfNavigationBarVisible(8);
    setActionbarColor(getContext().getResources().getColor(b.b.JRx));
    setNavigationbarColor(getContext().getResources().getColor(b.b.JRx));
    initView();
    overridePendingTransition(b.a.push_up_in, b.a.anim_not_change);
    Log.i("MicroMsg.KidsWatchLoginChooseHelpUI", "Enter KidsWatch Login Help UI");
    AppMethodBeat.o(262201);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(KidsWatchLoginFirstChooseHelpUI paramKidsWatchLoginFirstChooseHelpUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.ui.login.KidsWatchLoginFirstChooseHelpUI
 * JD-Core Version:    0.7.0.1
 */