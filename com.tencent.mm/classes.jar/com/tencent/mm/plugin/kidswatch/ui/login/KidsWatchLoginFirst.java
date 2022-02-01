package com.tencent.mm.plugin.kidswatch.ui.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.kidswatch.a.c;
import com.tencent.mm.plugin.kidswatch.model.c;
import com.tencent.mm.plugin.kidswatch.model.c.a;
import com.tencent.mm.plugin.kidswatch.model.c.b;
import com.tencent.mm.plugin.kidswatch.model.c.c;
import com.tencent.mm.plugin.kidswatch.ui.reg.KidsWatchRegGetInfoUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@com.tencent.mm.ui.base.a(35)
@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirst;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "deviceName", "", "isShowRegBtn", "", "kidsCount", "", "loginUrl", "okSessionList", "scene", "Lcom/tencent/mm/plugin/kidswatch/ConstantsKidsWatch$LoginFirstChooseScene;", "finish", "", "getForceOrientation", "getLayoutId", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onWindowFocusChanged", "hasFocus", "Companion", "plugin-kidswatch_release"})
public final class KidsWatchLoginFirst
  extends MMActivity
{
  public static final KidsWatchLoginFirst.a yBo;
  private HashMap _$_findViewCache;
  private String dZW;
  private String deviceName;
  private String yBa;
  private boolean yBg;
  private int yBh;
  private a.c yBn = a.c.yAt;
  
  static
  {
    AppMethodBeat.i(256255);
    yBo = new KidsWatchLoginFirst.a((byte)0);
    AppMethodBeat.o(256255);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(256258);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(256258);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(256257);
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
    AppMethodBeat.o(256257);
    return localView1;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(256254);
    super.finish();
    overridePendingTransition(2130771986, 2130772130);
    AppMethodBeat.o(256254);
  }
  
  public final int getForceOrientation()
  {
    return 1;
  }
  
  public final int getLayoutId()
  {
    return 2131495133;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(256253);
    Log.i("MicroMsg.KidsWatchLoginFirst", "initView");
    setMMTitle("");
    Object localObject = getIntent().getStringExtra("intent.key.login.url");
    p.g(localObject, "intent.getStringExtra(Co…tch.INTENT_KEY_LOGIN_URL)");
    this.dZW = ((String)localObject);
    this.yBh = getIntent().getIntExtra("intent.key.kids.cnt", 0);
    this.deviceName = getIntent().getStringExtra("intent.key.device.name");
    this.yBa = getIntent().getStringExtra("intent.key.ok.session.list");
    this.yBg = getIntent().getBooleanExtra("intent.key.ok.reg.btn", false);
    ((KidsWatchHeadComponent)_$_findCachedViewById(2131302263)).setCloseBtnCallBack((kotlin.g.a.a)new b(this));
    ((KidsWatchHeadComponent)_$_findCachedViewById(2131302263)).ebW();
    localObject = (Button)_$_findCachedViewById(2131303771);
    if (localObject == null) {
      p.hyc();
    }
    ((Button)localObject).setOnClickListener((View.OnClickListener)new c(this));
    localObject = (LinearLayout)_$_findCachedViewById(2131306783);
    if (localObject != null) {
      if (!this.yBg) {
        break label226;
      }
    }
    label226:
    for (int i = 0;; i = 4)
    {
      ((LinearLayout)localObject).setVisibility(i);
      localObject = (Button)_$_findCachedViewById(2131306785);
      if (localObject == null) {
        p.hyc();
      }
      ((Button)localObject).setOnClickListener((View.OnClickListener)new d(this));
      AppMethodBeat.o(256253);
      return;
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(256251);
    super.onCreate(paramBundle);
    paramBundle = getSupportActionBar();
    if (paramBundle == null) {
      p.hyc();
    }
    paramBundle.hide();
    initView();
    overridePendingTransition(2130772132, 2130771986);
    AppMethodBeat.o(256251);
  }
  
  public final void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(256252);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean)
    {
      com.tencent.mm.plugin.kidswatch.b.a locala = com.tencent.mm.plugin.kidswatch.b.a.yBL;
      com.tencent.mm.plugin.kidswatch.b.a.aq((Activity)this);
    }
    AppMethodBeat.o(256252);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(KidsWatchLoginFirst paramKidsWatchLoginFirst)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(KidsWatchLoginFirst paramKidsWatchLoginFirst) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(256249);
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirst$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
      Log.i("MicroMsg.KidsWatchLoginFirst", "login button clicked");
      KidsWatchLoginFirst.a(this.yBp, a.c.yAt);
      localObject = new Intent();
      ((Intent)localObject).putExtra("intent.key.login.url", KidsWatchLoginFirst.b(this.yBp));
      ((Intent)localObject).putExtra("intent.key.device.name", KidsWatchLoginFirst.d(this.yBp));
      ((Intent)localObject).putExtra("intent.key.ok.session.list", KidsWatchLoginFirst.e(this.yBp));
      ((Intent)localObject).putExtra("intent.key.kids.cnt", KidsWatchLoginFirst.c(this.yBp));
      ((Intent)localObject).setFlags(268435456);
      ((Intent)localObject).setClass((Context)this.yBp, KidsWatchLoginFirstChooseSceneUI.class);
      paramView = MMApplicationContext.getContext();
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirst$initView$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirst$initView$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirst$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(256249);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(KidsWatchLoginFirst paramKidsWatchLoginFirst) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(256250);
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirst$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
      Log.i("MicroMsg.KidsWatchLoginFirst", "reg button clicked, isShowRegBtn:" + KidsWatchLoginFirst.f(this.yBp));
      localObject = new Intent();
      ((Intent)localObject).putExtra("intent.key.login.url", KidsWatchLoginFirst.b(this.yBp));
      ((Intent)localObject).putExtra("intent.key.device.name", KidsWatchLoginFirst.d(this.yBp));
      ((Intent)localObject).setFlags(268435456);
      ((Intent)localObject).setClass((Context)this.yBp, KidsWatchRegGetInfoUI.class);
      paramView = MMApplicationContext.getContext();
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirst$initView$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirst$initView$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      KidsWatchLoginFirst.a(this.yBp, a.c.yAu);
      paramView = c.yAF;
      c.a(c.a.yAG, KidsWatchLoginFirst.b(this.yBp), c.c.yAO, c.b.yAK, KidsWatchLoginFirst.c(this.yBp), 0);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirst$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(256250);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.ui.login.KidsWatchLoginFirst
 * JD-Core Version:    0.7.0.1
 */