package com.tencent.mm.plugin.kidswatch.ui.reg;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.kidswatch.b.a;
import com.tencent.mm.plugin.kidswatch.b.b;
import com.tencent.mm.plugin.kidswatch.b.e;
import com.tencent.mm.plugin.kidswatch.b.f;
import com.tencent.mm.plugin.kidswatch.b.h;
import com.tencent.mm.plugin.kidswatch.ui.login.KidsWatchHeadComponent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@com.tencent.mm.ui.base.a(35)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegIntroUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "loginUrl", "", "finish", "", "getForceOrientation", "", "getLayoutId", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-kidswatch_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class KidsWatchRegIntroUI
  extends MMActivity
{
  public static final KidsWatchRegIntroUI.a JTL;
  private String hZO;
  
  static
  {
    AppMethodBeat.i(262171);
    JTL = new KidsWatchRegIntroUI.a((byte)0);
    AppMethodBeat.o(262171);
  }
  
  private static final void a(KidsWatchRegIntroUI paramKidsWatchRegIntroUI, View paramView)
  {
    AppMethodBeat.i(262156);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramKidsWatchRegIntroUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegIntroUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramKidsWatchRegIntroUI, "this$0");
    Log.i("MicroMsg.KidsWatchRegIntroUI", "continue reg button clicked");
    paramView = new Intent((Context)paramKidsWatchRegIntroUI, KidsWatchRegGetInfoUI.class);
    paramView.putExtra("intent.key.login.url", paramKidsWatchRegIntroUI.hZO);
    paramView = new com.tencent.mm.hellhoundlib.b.a().cG(paramView);
    com.tencent.mm.hellhoundlib.a.a.b(paramKidsWatchRegIntroUI, paramView.aYi(), "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegIntroUI", "initView$lambda-0", "(Lcom/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegIntroUI;Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramKidsWatchRegIntroUI.startActivity((Intent)paramView.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramKidsWatchRegIntroUI, "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegIntroUI", "initView$lambda-0", "(Lcom/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegIntroUI;Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegIntroUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(262156);
  }
  
  private static final void b(KidsWatchRegIntroUI paramKidsWatchRegIntroUI, View paramView)
  {
    AppMethodBeat.i(262165);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramKidsWatchRegIntroUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegIntroUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramKidsWatchRegIntroUI, "this$0");
    paramKidsWatchRegIntroUI.finish();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegIntroUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(262165);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final void finish()
  {
    AppMethodBeat.i(262211);
    super.finish();
    overridePendingTransition(b.a.anim_not_change, b.a.push_down_out);
    AppMethodBeat.o(262211);
  }
  
  public final int getForceOrientation()
  {
    return 1;
  }
  
  public final int getLayoutId()
  {
    return b.f.JSv;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(262223);
    setMMTitle("");
    Object localObject = (KidsWatchHeadComponent)findViewById(b.e.JRO);
    String str = getString(b.h.JSG);
    s.s(str, "getString(R.string.kids_…ogin_enter_loading_title)");
    ((KidsWatchHeadComponent)localObject).setTitle(str);
    ((KidsWatchHeadComponent)findViewById(b.e.JRO)).setCloseBtnCallBack((kotlin.g.a.a)new b(this));
    this.hZO = getIntent().getStringExtra("intent.key.login.url");
    ((Button)findViewById(b.e.JRJ)).setOnClickListener(new KidsWatchRegIntroUI..ExternalSyntheticLambda0(this));
    ((Button)findViewById(b.e.JRC)).setOnClickListener(new KidsWatchRegIntroUI..ExternalSyntheticLambda1(this));
    localObject = com.tencent.mm.plugin.kidswatch.b.a.JTW;
    localObject = getContext();
    s.s(localObject, "context");
    com.tencent.mm.plugin.kidswatch.b.a.a((Context)localObject, (LinearLayout)findViewById(b.e.JRF), (LinearLayout)findViewById(b.e.JRD));
    AppMethodBeat.o(262223);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(262189);
    super.onCreate(paramBundle);
    paramBundle = getSupportActionBar();
    s.checkNotNull(paramBundle);
    paramBundle.hide();
    setSelfNavigationBarVisible(8);
    setActionbarColor(getContext().getResources().getColor(b.b.JRx));
    setNavigationbarColor(getContext().getResources().getColor(b.b.JRx));
    initView();
    overridePendingTransition(b.a.push_up_in, b.a.anim_not_change);
    AppMethodBeat.o(262189);
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
    b(KidsWatchRegIntroUI paramKidsWatchRegIntroUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.ui.reg.KidsWatchRegIntroUI
 * JD-Core Version:    0.7.0.1
 */