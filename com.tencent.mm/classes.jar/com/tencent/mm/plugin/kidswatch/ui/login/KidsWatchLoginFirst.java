package com.tencent.mm.plugin.kidswatch.ui.login;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.kidswatch.a.c;
import com.tencent.mm.plugin.kidswatch.b.e;
import com.tencent.mm.plugin.kidswatch.b.f;
import com.tencent.mm.plugin.kidswatch.b.h;
import com.tencent.mm.plugin.kidswatch.model.b.b;
import com.tencent.mm.plugin.kidswatch.model.b.c;
import com.tencent.mm.plugin.kidswatch.ui.reg.KidsWatchRegGetInfoUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@com.tencent.mm.ui.base.a(35)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirst;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "deviceName", "", "isShowRegBtn", "", "kidsCount", "", "loginUrl", "okSessionList", "scene", "Lcom/tencent/mm/plugin/kidswatch/ConstantsKidsWatch$LoginFirstChooseScene;", "finish", "", "getForceOrientation", "getLayoutId", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onWindowFocusChanged", "hasFocus", "Companion", "plugin-kidswatch_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class KidsWatchLoginFirst
  extends MMActivity
{
  public static final KidsWatchLoginFirst.a JTD;
  private int JTA;
  private a.c JTE = a.c.JRt;
  private String JTu;
  private boolean JTz;
  private String deviceName;
  private String hZO;
  
  static
  {
    AppMethodBeat.i(262301);
    JTD = new KidsWatchLoginFirst.a((byte)0);
    AppMethodBeat.o(262301);
  }
  
  private static final void a(KidsWatchLoginFirst paramKidsWatchLoginFirst, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(262264);
    s.u(paramKidsWatchLoginFirst, "this$0");
    Log.i("MicroMsg.KidsWatchLoginFirst", s.X("reg button clicked, isShowRegBtn:", Boolean.valueOf(paramKidsWatchLoginFirst.JTz)));
    Object localObject2 = new Intent();
    Object localObject1 = paramKidsWatchLoginFirst.hZO;
    paramDialogInterface = (DialogInterface)localObject1;
    if (localObject1 == null)
    {
      s.bIx("loginUrl");
      paramDialogInterface = null;
    }
    ((Intent)localObject2).putExtra("intent.key.login.url", paramDialogInterface);
    ((Intent)localObject2).putExtra("intent.key.device.name", paramKidsWatchLoginFirst.deviceName);
    ((Intent)localObject2).setFlags(268435456);
    ((Intent)localObject2).setClass((Context)paramKidsWatchLoginFirst, KidsWatchRegGetInfoUI.class);
    paramDialogInterface = MMApplicationContext.getContext();
    localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
    com.tencent.mm.hellhoundlib.a.a.b(paramDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirst", "initView$lambda-2$lambda-1", "(Lcom/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirst;Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramDialogInterface, "com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirst", "initView$lambda-2$lambda-1", "(Lcom/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirst;Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramKidsWatchLoginFirst.JTE = a.c.JRu;
    paramDialogInterface = com.tencent.mm.plugin.kidswatch.model.b.JSY;
    localObject2 = com.tencent.mm.plugin.kidswatch.model.b.a.JSZ;
    localObject1 = paramKidsWatchLoginFirst.hZO;
    paramDialogInterface = (DialogInterface)localObject1;
    if (localObject1 == null)
    {
      s.bIx("loginUrl");
      paramDialogInterface = null;
    }
    com.tencent.mm.plugin.kidswatch.model.b.a((com.tencent.mm.plugin.kidswatch.model.b.a)localObject2, paramDialogInterface, b.c.JTh, b.b.JTd, paramKidsWatchLoginFirst.JTA, 0);
    AppMethodBeat.o(262264);
  }
  
  private static final void a(KidsWatchLoginFirst paramKidsWatchLoginFirst, View paramView)
  {
    AppMethodBeat.i(262250);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramKidsWatchLoginFirst);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirst", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramKidsWatchLoginFirst, "this$0");
    Log.i("MicroMsg.KidsWatchLoginFirst", "login button clicked");
    paramKidsWatchLoginFirst.JTE = a.c.JRt;
    localObject2 = new Intent();
    localObject1 = paramKidsWatchLoginFirst.hZO;
    paramView = (View)localObject1;
    if (localObject1 == null)
    {
      s.bIx("loginUrl");
      paramView = null;
    }
    ((Intent)localObject2).putExtra("intent.key.login.url", paramView);
    ((Intent)localObject2).putExtra("intent.key.device.name", paramKidsWatchLoginFirst.deviceName);
    ((Intent)localObject2).putExtra("intent.key.ok.session.list", paramKidsWatchLoginFirst.JTu);
    ((Intent)localObject2).putExtra("intent.key.kids.cnt", paramKidsWatchLoginFirst.JTA);
    ((Intent)localObject2).setFlags(268435456);
    ((Intent)localObject2).setClass((Context)paramKidsWatchLoginFirst, KidsWatchLoginFirstChooseSceneUI.class);
    paramKidsWatchLoginFirst = MMApplicationContext.getContext();
    paramView = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
    com.tencent.mm.hellhoundlib.a.a.b(paramKidsWatchLoginFirst, paramView.aYi(), "com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirst", "initView$lambda-0", "(Lcom/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirst;Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramKidsWatchLoginFirst.startActivity((Intent)paramView.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramKidsWatchLoginFirst, "com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirst", "initView$lambda-0", "(Lcom/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirst;Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirst", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(262250);
  }
  
  private static final void b(KidsWatchLoginFirst paramKidsWatchLoginFirst, View paramView)
  {
    AppMethodBeat.i(262276);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramKidsWatchLoginFirst);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirst", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramKidsWatchLoginFirst, "this$0");
    k.a((Context)paramKidsWatchLoginFirst.getContext(), b.h.JSz, b.h.JSA, b.h.app_continue, b.h.app_cancel, new KidsWatchLoginFirst..ExternalSyntheticLambda0(paramKidsWatchLoginFirst), null);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirst", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(262276);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final void finish()
  {
    AppMethodBeat.i(262354);
    super.finish();
    overridePendingTransition(com.tencent.mm.plugin.kidswatch.b.a.anim_not_change, com.tencent.mm.plugin.kidswatch.b.a.push_down_out);
    AppMethodBeat.o(262354);
  }
  
  public final int getForceOrientation()
  {
    return 1;
  }
  
  public final int getLayoutId()
  {
    return b.f.JSr;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(262346);
    Log.i("MicroMsg.KidsWatchLoginFirst", "initView");
    setMMTitle("");
    Object localObject = getIntent().getStringExtra("intent.key.login.url");
    s.checkNotNull(localObject);
    s.s(localObject, "intent.getStringExtra(Co…h.INTENT_KEY_LOGIN_URL)!!");
    this.hZO = ((String)localObject);
    this.JTA = getIntent().getIntExtra("intent.key.kids.cnt", 0);
    this.deviceName = getIntent().getStringExtra("intent.key.device.name");
    this.JTu = getIntent().getStringExtra("intent.key.ok.session.list");
    this.JTz = getIntent().getBooleanExtra("intent.key.ok.reg.btn", false);
    ((KidsWatchHeadComponent)findViewById(b.e.JRO)).setCloseBtnCallBack((kotlin.g.a.a)new b(this));
    ((KidsWatchHeadComponent)findViewById(b.e.JRO)).fSR();
    localObject = (Button)findViewById(b.e.JRY);
    s.checkNotNull(localObject);
    ((Button)localObject).setOnClickListener(new KidsWatchLoginFirst..ExternalSyntheticLambda2(this));
    localObject = (LinearLayout)findViewById(b.e.JSi);
    if (localObject != null) {
      if (!this.JTz) {
        break label231;
      }
    }
    label231:
    for (int i = 0;; i = 4)
    {
      ((LinearLayout)localObject).setVisibility(i);
      localObject = (TextView)findViewById(b.e.JSk);
      s.checkNotNull(localObject);
      ((TextView)localObject).setOnClickListener(new KidsWatchLoginFirst..ExternalSyntheticLambda1(this));
      AppMethodBeat.o(262346);
      return;
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(262329);
    super.onCreate(paramBundle);
    paramBundle = getSupportActionBar();
    s.checkNotNull(paramBundle);
    paramBundle.hide();
    initView();
    overridePendingTransition(com.tencent.mm.plugin.kidswatch.b.a.push_up_in, com.tencent.mm.plugin.kidswatch.b.a.anim_not_change);
    AppMethodBeat.o(262329);
  }
  
  public final void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(262336);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean)
    {
      com.tencent.mm.plugin.kidswatch.b.a locala = com.tencent.mm.plugin.kidswatch.b.a.JTW;
      com.tencent.mm.plugin.kidswatch.b.a.aX((Activity)this);
    }
    AppMethodBeat.o(262336);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(KidsWatchLoginFirst paramKidsWatchLoginFirst)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.ui.login.KidsWatchLoginFirst
 * JD-Core Version:    0.7.0.1
 */