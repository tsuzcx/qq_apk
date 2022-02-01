package com.tencent.mm.plugin.kidswatch.ui.reg;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.kidswatch.b.a;
import com.tencent.mm.plugin.kidswatch.b.b;
import com.tencent.mm.plugin.kidswatch.b.e;
import com.tencent.mm.plugin.kidswatch.b.f;
import com.tencent.mm.plugin.kidswatch.b.h;
import com.tencent.mm.plugin.kidswatch.ui.login.KidsWatchHeadComponent;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@com.tencent.mm.ui.base.a(35)
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegSuccessUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "loginUrl", "", "nickname", "openId", "finish", "", "getForceOrientation", "", "getLayoutId", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-kidswatch_release"})
public final class KidsWatchRegSuccessUI
  extends MMActivity
{
  public static final a EcZ;
  private HashMap _$_findViewCache;
  private String fTQ;
  private String nickname;
  private String openId;
  
  static
  {
    AppMethodBeat.i(252128);
    EcZ = new a((byte)0);
    AppMethodBeat.o(252128);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(252137);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(252137);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(252135);
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
    AppMethodBeat.o(252135);
    return localView1;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(252120);
    super.finish();
    overridePendingTransition(b.a.anim_not_change, b.a.push_down_out);
    AppMethodBeat.o(252120);
  }
  
  public final int getForceOrientation()
  {
    return 1;
  }
  
  public final int getLayoutId()
  {
    return b.f.Ebq;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(252124);
    setMMTitle("");
    Object localObject1 = (KidsWatchHeadComponent)_$_findCachedViewById(b.e.EaG);
    Object localObject2 = getString(b.h.Eby);
    p.j(localObject2, "getString(R.string.kids_…ogin_enter_loading_title)");
    ((KidsWatchHeadComponent)localObject1).setTitle((String)localObject2);
    ((KidsWatchHeadComponent)_$_findCachedViewById(b.e.EaG)).setCloseBtnCallBack((kotlin.g.a.a)new KidsWatchRegSuccessUI.b(this));
    localObject1 = getIntent().getStringExtra("intent.key.login.url");
    p.j(localObject1, "intent.getStringExtra(Co…tch.INTENT_KEY_LOGIN_URL)");
    this.fTQ = ((String)localObject1);
    localObject1 = getIntent().getStringExtra("intent.key.reg.nickname");
    p.j(localObject1, "intent.getStringExtra(Co….INTENT_KEY_REG_NICKNAME)");
    this.nickname = ((String)localObject1);
    localObject1 = getIntent().getStringExtra("intent.key.reg.openid");
    p.j(localObject1, "intent.getStringExtra(Co…h.INTENT_KEY_REG_OPEN_ID)");
    this.openId = ((String)localObject1);
    int i = b.h.EbK;
    localObject1 = this.nickname;
    if (localObject1 == null) {
      p.bGy("nickname");
    }
    localObject1 = getString(i, new Object[] { localObject1 });
    p.j(localObject1, "getString(R.string.kids_…t_content_desc, nickname)");
    localObject2 = (TextView)_$_findCachedViewById(b.e.EaC);
    p.j(localObject2, "descTV");
    ((TextView)localObject2).setText((CharSequence)localObject1);
    ((Button)_$_findCachedViewById(b.e.EaF)).setOnClickListener((View.OnClickListener)new KidsWatchRegSuccessUI.c(this));
    localObject1 = com.tencent.mm.plugin.kidswatch.b.a.Edb;
    localObject1 = getContext();
    p.j(localObject1, "context");
    com.tencent.mm.plugin.kidswatch.b.a.a((Context)localObject1, (LinearLayout)_$_findCachedViewById(b.e.EaU), (LinearLayout)_$_findCachedViewById(b.e.Eav));
    AppMethodBeat.o(252124);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(252115);
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
    AppMethodBeat.o(252115);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegSuccessUI$Companion;", "", "()V", "TAG", "", "plugin-kidswatch_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.ui.reg.KidsWatchRegSuccessUI
 * JD-Core Version:    0.7.0.1
 */