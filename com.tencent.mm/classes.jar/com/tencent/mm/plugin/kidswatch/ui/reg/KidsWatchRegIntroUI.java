package com.tencent.mm.plugin.kidswatch.ui.reg;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.kidswatch.ui.login.KidsWatchHeadComponent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@com.tencent.mm.ui.base.a(35)
@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegIntroUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "loginUrl", "", "finish", "", "getForceOrientation", "", "getLayoutId", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-kidswatch_release"})
public final class KidsWatchRegIntroUI
  extends MMActivity
{
  public static final a yBy;
  private HashMap _$_findViewCache;
  private String dZW;
  
  static
  {
    AppMethodBeat.i(256332);
    yBy = new a((byte)0);
    AppMethodBeat.o(256332);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(256334);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(256334);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(256333);
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
    AppMethodBeat.o(256333);
    return localView1;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(256330);
    super.finish();
    overridePendingTransition(2130771986, 2130772130);
    AppMethodBeat.o(256330);
  }
  
  public final int getForceOrientation()
  {
    return 1;
  }
  
  public final int getLayoutId()
  {
    return 2131495137;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(256331);
    setMMTitle("");
    Object localObject = (KidsWatchHeadComponent)_$_findCachedViewById(2131302263);
    String str = getString(2131762070);
    p.g(str, "getString(R.string.kids_…ogin_enter_loading_title)");
    ((KidsWatchHeadComponent)localObject).setTitle(str);
    ((KidsWatchHeadComponent)_$_findCachedViewById(2131302263)).setCloseBtnCallBack((kotlin.g.a.a)new b(this));
    this.dZW = getIntent().getStringExtra("intent.key.login.url");
    ((Button)_$_findCachedViewById(2131299228)).setOnClickListener((View.OnClickListener)new c(this));
    ((Button)_$_findCachedViewById(2131297159)).setOnClickListener((View.OnClickListener)new d(this));
    localObject = com.tencent.mm.plugin.kidswatch.b.a.yBL;
    localObject = getContext();
    p.g(localObject, "context");
    com.tencent.mm.plugin.kidswatch.b.a.a((Context)localObject, (LinearLayout)_$_findCachedViewById(2131298013), (LinearLayout)_$_findCachedViewById(2131297654));
    AppMethodBeat.o(256331);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(256329);
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
    AppMethodBeat.o(256329);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegIntroUI$Companion;", "", "()V", "TAG", "", "plugin-kidswatch_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(KidsWatchRegIntroUI paramKidsWatchRegIntroUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(KidsWatchRegIntroUI paramKidsWatchRegIntroUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(256327);
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegIntroUI$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
      Log.i("MicroMsg.KidsWatchRegIntroUI", "continue reg button clicked");
      localObject = new Intent((Context)this.yBz, KidsWatchRegGetInfoUI.class);
      ((Intent)localObject).putExtra("intent.key.login.url", KidsWatchRegIntroUI.a(this.yBz));
      paramView = this.yBz;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegIntroUI$initView$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegIntroUI$initView$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegIntroUI$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(256327);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(KidsWatchRegIntroUI paramKidsWatchRegIntroUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(256328);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegIntroUI$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.yBz.finish();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegIntroUI$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(256328);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.ui.reg.KidsWatchRegIntroUI
 * JD-Core Version:    0.7.0.1
 */