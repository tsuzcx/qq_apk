package com.tencent.mm.plugin.kidswatch.ui.login;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.kidswatch.a.c;
import com.tencent.mm.plugin.kidswatch.b.a;
import com.tencent.mm.plugin.kidswatch.b.e;
import com.tencent.mm.plugin.kidswatch.b.f;
import com.tencent.mm.plugin.kidswatch.b.h;
import com.tencent.mm.plugin.kidswatch.model.c;
import com.tencent.mm.plugin.kidswatch.model.c.a;
import com.tencent.mm.plugin.kidswatch.model.c.b;
import com.tencent.mm.plugin.kidswatch.model.c.c;
import com.tencent.mm.plugin.kidswatch.ui.reg.KidsWatchRegGetInfoUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@com.tencent.mm.ui.base.a(35)
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirst;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "deviceName", "", "isShowRegBtn", "", "kidsCount", "", "loginUrl", "okSessionList", "scene", "Lcom/tencent/mm/plugin/kidswatch/ConstantsKidsWatch$LoginFirstChooseScene;", "finish", "", "getForceOrientation", "getLayoutId", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onWindowFocusChanged", "hasFocus", "Companion", "plugin-kidswatch_release"})
public final class KidsWatchLoginFirst
  extends MMActivity
{
  public static final KidsWatchLoginFirst.a EcD;
  private a.c EcC = a.c.Eal;
  private String Ecp;
  private boolean Ecv;
  private int Ecw;
  private HashMap _$_findViewCache;
  private String deviceName;
  private String fTQ;
  
  static
  {
    AppMethodBeat.i(251691);
    EcD = new KidsWatchLoginFirst.a((byte)0);
    AppMethodBeat.o(251691);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(251706);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(251706);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(251704);
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
    AppMethodBeat.o(251704);
    return localView1;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(251687);
    super.finish();
    overridePendingTransition(b.a.anim_not_change, b.a.push_down_out);
    AppMethodBeat.o(251687);
  }
  
  public final int getForceOrientation()
  {
    return 1;
  }
  
  public final int getLayoutId()
  {
    return b.f.Ebj;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(251684);
    Log.i("MicroMsg.KidsWatchLoginFirst", "initView");
    setMMTitle("");
    Object localObject = getIntent().getStringExtra("intent.key.login.url");
    p.j(localObject, "intent.getStringExtra(Co…tch.INTENT_KEY_LOGIN_URL)");
    this.fTQ = ((String)localObject);
    this.Ecw = getIntent().getIntExtra("intent.key.kids.cnt", 0);
    this.deviceName = getIntent().getStringExtra("intent.key.device.name");
    this.Ecp = getIntent().getStringExtra("intent.key.ok.session.list");
    this.Ecv = getIntent().getBooleanExtra("intent.key.ok.reg.btn", false);
    ((KidsWatchHeadComponent)_$_findCachedViewById(b.e.EaG)).setCloseBtnCallBack((kotlin.g.a.a)new b(this));
    ((KidsWatchHeadComponent)_$_findCachedViewById(b.e.EaG)).eKU();
    localObject = (Button)_$_findCachedViewById(b.e.EaQ);
    if (localObject == null) {
      p.iCn();
    }
    ((Button)localObject).setOnClickListener((View.OnClickListener)new c(this));
    localObject = (LinearLayout)_$_findCachedViewById(b.e.Eba);
    if (localObject != null) {
      if (!this.Ecv) {
        break label231;
      }
    }
    label231:
    for (int i = 0;; i = 4)
    {
      ((LinearLayout)localObject).setVisibility(i);
      localObject = (TextView)_$_findCachedViewById(b.e.Ebc);
      if (localObject == null) {
        p.iCn();
      }
      ((TextView)localObject).setOnClickListener((View.OnClickListener)new d(this));
      AppMethodBeat.o(251684);
      return;
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(251679);
    super.onCreate(paramBundle);
    paramBundle = getSupportActionBar();
    if (paramBundle == null) {
      p.iCn();
    }
    paramBundle.hide();
    initView();
    overridePendingTransition(b.a.push_up_in, b.a.anim_not_change);
    AppMethodBeat.o(251679);
  }
  
  public final void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(251681);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean)
    {
      com.tencent.mm.plugin.kidswatch.b.a locala = com.tencent.mm.plugin.kidswatch.b.a.Edb;
      com.tencent.mm.plugin.kidswatch.b.a.aw((Activity)this);
    }
    AppMethodBeat.o(251681);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(KidsWatchLoginFirst paramKidsWatchLoginFirst)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(KidsWatchLoginFirst paramKidsWatchLoginFirst) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(252080);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirst$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      Log.i("MicroMsg.KidsWatchLoginFirst", "login button clicked");
      KidsWatchLoginFirst.a(this.EcE, a.c.Eal);
      localObject = new Intent();
      ((Intent)localObject).putExtra("intent.key.login.url", KidsWatchLoginFirst.b(this.EcE));
      ((Intent)localObject).putExtra("intent.key.device.name", KidsWatchLoginFirst.d(this.EcE));
      ((Intent)localObject).putExtra("intent.key.ok.session.list", KidsWatchLoginFirst.e(this.EcE));
      ((Intent)localObject).putExtra("intent.key.kids.cnt", KidsWatchLoginFirst.c(this.EcE));
      ((Intent)localObject).setFlags(268435456);
      ((Intent)localObject).setClass((Context)this.EcE, KidsWatchLoginFirstChooseSceneUI.class);
      paramView = MMApplicationContext.getContext();
      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirst$initView$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirst$initView$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirst$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(252080);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(KidsWatchLoginFirst paramKidsWatchLoginFirst) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(252179);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirst$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      h.a((Context)this.EcE.getContext(), b.h.Ebr, b.h.Ebs, b.h.app_continue, b.h.app_cancel, (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(251577);
          Log.i("MicroMsg.KidsWatchLoginFirst", "reg button clicked, isShowRegBtn:" + KidsWatchLoginFirst.f(this.EcF.EcE));
          Object localObject = new Intent();
          ((Intent)localObject).putExtra("intent.key.login.url", KidsWatchLoginFirst.b(this.EcF.EcE));
          ((Intent)localObject).putExtra("intent.key.device.name", KidsWatchLoginFirst.d(this.EcF.EcE));
          ((Intent)localObject).setFlags(268435456);
          ((Intent)localObject).setClass((Context)this.EcF.EcE, KidsWatchRegGetInfoUI.class);
          paramAnonymousDialogInterface = MMApplicationContext.getContext();
          localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirst$initView$3$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousDialogInterface, "com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirst$initView$3$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          KidsWatchLoginFirst.a(this.EcF.EcE, a.c.Eam);
          paramAnonymousDialogInterface = c.EbU;
          c.a(c.a.EbV, KidsWatchLoginFirst.b(this.EcF.EcE), c.c.Ecd, c.b.EbZ, KidsWatchLoginFirst.c(this.EcF.EcE), 0);
          AppMethodBeat.o(251577);
        }
      }, null);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirst$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(252179);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.ui.login.KidsWatchLoginFirst
 * JD-Core Version:    0.7.0.1
 */