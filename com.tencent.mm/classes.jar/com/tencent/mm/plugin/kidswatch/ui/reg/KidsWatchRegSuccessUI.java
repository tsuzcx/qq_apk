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
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.kidswatch.ui.login.KidsWatchHeadComponent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@com.tencent.mm.ui.base.a(35)
@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegSuccessUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "loginUrl", "", "nickname", "openId", "finish", "", "getForceOrientation", "", "getLayoutId", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-kidswatch_release"})
public final class KidsWatchRegSuccessUI
  extends MMActivity
{
  public static final a yBJ;
  private HashMap _$_findViewCache;
  private String dZW;
  private String nickname;
  private String openId;
  
  static
  {
    AppMethodBeat.i(256378);
    yBJ = new a((byte)0);
    AppMethodBeat.o(256378);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(256382);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(256382);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(256381);
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
    AppMethodBeat.o(256381);
    return localView1;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(256376);
    super.finish();
    overridePendingTransition(2130771986, 2130772130);
    AppMethodBeat.o(256376);
  }
  
  public final int getForceOrientation()
  {
    return 1;
  }
  
  public final int getLayoutId()
  {
    return 2131495140;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(256377);
    setMMTitle("");
    Object localObject1 = (KidsWatchHeadComponent)_$_findCachedViewById(2131302263);
    Object localObject2 = getString(2131762070);
    p.g(localObject2, "getString(R.string.kids_…ogin_enter_loading_title)");
    ((KidsWatchHeadComponent)localObject1).setTitle((String)localObject2);
    ((KidsWatchHeadComponent)_$_findCachedViewById(2131302263)).setCloseBtnCallBack((kotlin.g.a.a)new b(this));
    localObject1 = getIntent().getStringExtra("intent.key.login.url");
    p.g(localObject1, "intent.getStringExtra(Co…tch.INTENT_KEY_LOGIN_URL)");
    this.dZW = ((String)localObject1);
    localObject1 = getIntent().getStringExtra("intent.key.reg.nickname");
    p.g(localObject1, "intent.getStringExtra(Co….INTENT_KEY_REG_NICKNAME)");
    this.nickname = ((String)localObject1);
    localObject1 = getIntent().getStringExtra("intent.key.reg.openid");
    p.g(localObject1, "intent.getStringExtra(Co…h.INTENT_KEY_REG_OPEN_ID)");
    this.openId = ((String)localObject1);
    localObject1 = this.nickname;
    if (localObject1 == null) {
      p.btv("nickname");
    }
    localObject1 = getString(2131762110, new Object[] { localObject1 });
    p.g(localObject1, "getString(R.string.kids_…t_content_desc, nickname)");
    localObject2 = (TextView)_$_findCachedViewById(2131299496);
    p.g(localObject2, "descTV");
    ((TextView)localObject2).setText((CharSequence)localObject1);
    ((Button)_$_findCachedViewById(2131302144)).setOnClickListener((View.OnClickListener)new c(this));
    localObject1 = com.tencent.mm.plugin.kidswatch.b.a.yBL;
    localObject1 = getContext();
    p.g(localObject1, "context");
    com.tencent.mm.plugin.kidswatch.b.a.a((Context)localObject1, (LinearLayout)_$_findCachedViewById(2131304319), (LinearLayout)_$_findCachedViewById(2131297654));
    AppMethodBeat.o(256377);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(256375);
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
    AppMethodBeat.o(256375);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegSuccessUI$Companion;", "", "()V", "TAG", "", "plugin-kidswatch_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(KidsWatchRegSuccessUI paramKidsWatchRegSuccessUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(KidsWatchRegSuccessUI paramKidsWatchRegSuccessUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(256374);
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegSuccessUI$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
      paramView = ae.SYK;
      paramView = String.format("/pages/home/home.html?scene=register&openid=%s", Arrays.copyOf(new Object[] { KidsWatchRegSuccessUI.b(this.yBK) }, 1));
      p.g(paramView, "java.lang.String.format(format, *args)");
      Log.i("MicroMsg.KidsWatchRegSuccessUI", "goWebUIBtn, path:".concat(String.valueOf(paramView)));
      localObject = com.tencent.mm.plugin.kidswatch.b.a.yBL;
      localObject = this.yBK.getContext();
      p.g(localObject, "context");
      com.tencent.mm.plugin.kidswatch.b.a.h((Context)localObject, "", true);
      localObject = com.tencent.mm.plugin.kidswatch.b.a.yBL;
      localObject = this.yBK.getContext();
      p.g(localObject, "context");
      com.tencent.mm.plugin.kidswatch.b.a.f((Context)localObject, "wxaaff6b96fc2cd3c6", paramView, "2");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegSuccessUI$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(256374);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.ui.reg.KidsWatchRegSuccessUI
 * JD-Core Version:    0.7.0.1
 */