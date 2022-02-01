package com.tencent.mm.plugin.kidswatch.ui.login;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.model.z;
import com.tencent.mm.modelavatar.AvatarStorage;
import com.tencent.mm.modelavatar.d;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.plugin.kidswatch.a.b;
import com.tencent.mm.plugin.kidswatch.b.d;
import com.tencent.mm.plugin.kidswatch.b.e;
import com.tencent.mm.plugin.kidswatch.b.f;
import com.tencent.mm.plugin.kidswatch.b.h;
import com.tencent.mm.plugin.kidswatch.model.b.c;
import com.tencent.mm.plugin.kidswatch.model.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.widget.RoundCornerImageView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;

@com.tencent.mm.ui.base.a(35)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirstChooseSceneUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "deviceName", "kidsCount", "", "loginUrl", "okSessionList", "option", "radius", "doLoginOK", "", "loginScene", "finish", "", "getForceOrientation", "getLayoutId", "initView", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "updateCB", "plugin-kidswatch_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class KidsWatchLoginFirstChooseSceneUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private int JTA;
  private String JTu;
  private final String TAG;
  private String deviceName;
  private String hZO;
  private int option;
  private final int radius;
  
  public KidsWatchLoginFirstChooseSceneUI()
  {
    AppMethodBeat.i(262198);
    this.TAG = "MicroMsg.KidsWatchLoginFirstChooseSceneUI";
    this.radius = bd.fromDPToPix((Context)getContext(), 16);
    AppMethodBeat.o(262198);
  }
  
  private static final void a(KidsWatchLoginFirstChooseSceneUI paramKidsWatchLoginFirstChooseSceneUI, View paramView)
  {
    AppMethodBeat.i(262225);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramKidsWatchLoginFirstChooseSceneUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirstChooseSceneUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramKidsWatchLoginFirstChooseSceneUI, "this$0");
    paramKidsWatchLoginFirstChooseSceneUI.option = 0;
    paramKidsWatchLoginFirstChooseSceneUI.fSS();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirstChooseSceneUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(262225);
  }
  
  private final boolean am(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(262216);
    Log.i(this.TAG, "doLoginOK, login:" + paramString1 + ", okSession:" + paramString2 + ", scene:" + paramInt);
    com.tencent.mm.kernel.h.aZW().a(972, (com.tencent.mm.am.h)this);
    paramString1 = new f(paramString1, paramString2, paramInt, null);
    com.tencent.mm.kernel.h.aZW().a((p)paramString1, 0);
    AppMethodBeat.o(262216);
    return true;
  }
  
  private static final void b(KidsWatchLoginFirstChooseSceneUI paramKidsWatchLoginFirstChooseSceneUI, View paramView)
  {
    AppMethodBeat.i(262231);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramKidsWatchLoginFirstChooseSceneUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirstChooseSceneUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramKidsWatchLoginFirstChooseSceneUI, "this$0");
    paramKidsWatchLoginFirstChooseSceneUI.option = 1;
    paramKidsWatchLoginFirstChooseSceneUI.fSS();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirstChooseSceneUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(262231);
  }
  
  private static final void c(KidsWatchLoginFirstChooseSceneUI paramKidsWatchLoginFirstChooseSceneUI, View paramView)
  {
    AppMethodBeat.i(262238);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramKidsWatchLoginFirstChooseSceneUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirstChooseSceneUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramKidsWatchLoginFirstChooseSceneUI, "this$0");
    paramView = new Intent((Context)paramKidsWatchLoginFirstChooseSceneUI, KidsWatchLoginFirstChooseHelpUI.class);
    paramView = new com.tencent.mm.hellhoundlib.b.a().cG(paramView);
    com.tencent.mm.hellhoundlib.a.a.b(paramKidsWatchLoginFirstChooseSceneUI, paramView.aYi(), "com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirstChooseSceneUI", "initView$lambda-2", "(Lcom/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirstChooseSceneUI;Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramKidsWatchLoginFirstChooseSceneUI.startActivity((Intent)paramView.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramKidsWatchLoginFirstChooseSceneUI, "com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirstChooseSceneUI", "initView$lambda-2", "(Lcom/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirstChooseSceneUI;Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirstChooseSceneUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(262238);
  }
  
  private static final void d(KidsWatchLoginFirstChooseSceneUI paramKidsWatchLoginFirstChooseSceneUI, View paramView)
  {
    AppMethodBeat.i(262243);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramKidsWatchLoginFirstChooseSceneUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirstChooseSceneUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramKidsWatchLoginFirstChooseSceneUI, "this$0");
    paramView = paramKidsWatchLoginFirstChooseSceneUI.hZO;
    kotlin.g.b.s.checkNotNull(paramView);
    paramKidsWatchLoginFirstChooseSceneUI.am(paramView, paramKidsWatchLoginFirstChooseSceneUI.JTu, paramKidsWatchLoginFirstChooseSceneUI.option);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirstChooseSceneUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(262243);
  }
  
  private final void fSS()
  {
    int j = 0;
    AppMethodBeat.i(262205);
    WeImageView localWeImageView = (WeImageView)findViewById(b.e.JRX);
    if (localWeImageView != null)
    {
      if (this.option == 0)
      {
        i = 0;
        localWeImageView.setVisibility(i);
      }
    }
    else
    {
      localWeImageView = (WeImageView)findViewById(b.e.JSb);
      if (localWeImageView != null) {
        if (this.option != 1) {
          break label80;
        }
      }
    }
    label80:
    for (int i = j;; i = 8)
    {
      localWeImageView.setVisibility(i);
      AppMethodBeat.o(262205);
      return;
      i = 8;
      break;
    }
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final void finish()
  {
    AppMethodBeat.i(262292);
    super.finish();
    overridePendingTransition(com.tencent.mm.plugin.kidswatch.b.a.anim_not_change, com.tencent.mm.plugin.kidswatch.b.a.push_down_out);
    AppMethodBeat.o(262292);
  }
  
  public final int getForceOrientation()
  {
    return 1;
  }
  
  public final int getLayoutId()
  {
    return b.f.JSt;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(262316);
    this.hZO = getIntent().getStringExtra("intent.key.login.url");
    this.JTA = getIntent().getIntExtra("intent.key.kids.cnt", 0);
    this.deviceName = getIntent().getStringExtra("intent.key.device.name");
    this.JTu = getIntent().getStringExtra("intent.key.ok.session.list");
    ((KidsWatchHeadComponent)findViewById(b.e.JRO)).setCloseIconResId(b.d.actionbar_icon_dark_back);
    ((KidsWatchHeadComponent)findViewById(b.e.JRO)).setCloseBtnCallBack((kotlin.g.a.a)new a(this));
    String str = z.bAM();
    ((RoundCornerImageView)findViewById(b.e.avatarIV)).oJ(this.radius, this.radius);
    Object localObject = d.a(str, false, -1, null);
    if (localObject == null)
    {
      q.bFp();
      localObject = AvatarStorage.LI(str);
    }
    for (;;)
    {
      if (localObject != null) {
        ((RoundCornerImageView)findViewById(b.e.avatarIV)).setImageBitmap((Bitmap)localObject);
      }
      localObject = (WeImageView)findViewById(b.e.JRX);
      if (localObject == null) {}
      for (localObject = null; localObject == null; localObject = ((WeImageView)localObject).getParent())
      {
        localObject = new NullPointerException("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(262316);
        throw ((Throwable)localObject);
      }
      ((View)localObject).setOnClickListener(new KidsWatchLoginFirstChooseSceneUI..ExternalSyntheticLambda0(this));
      localObject = (WeImageView)findViewById(b.e.JSb);
      if (localObject == null) {}
      for (localObject = null; localObject == null; localObject = ((WeImageView)localObject).getParent())
      {
        localObject = new NullPointerException("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(262316);
        throw ((Throwable)localObject);
      }
      ((View)localObject).setOnClickListener(new KidsWatchLoginFirstChooseSceneUI..ExternalSyntheticLambda2(this));
      fSS();
      localObject = (LinearLayout)findViewById(b.e.JRL);
      if (localObject != null) {
        ((LinearLayout)localObject).setOnClickListener(new KidsWatchLoginFirstChooseSceneUI..ExternalSyntheticLambda1(this));
      }
      ((Button)findViewById(b.e.JRY)).setOnClickListener(new KidsWatchLoginFirstChooseSceneUI..ExternalSyntheticLambda3(this));
      localObject = com.tencent.mm.plugin.kidswatch.b.a.JTW;
      localObject = getContext();
      kotlin.g.b.s.s(localObject, "context");
      com.tencent.mm.plugin.kidswatch.b.a.a((Context)localObject, (LinearLayout)findViewById(b.e.JRF), (LinearLayout)findViewById(b.e.JRD));
      AppMethodBeat.o(262316);
      return;
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(262330);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 30846)
    {
      Log.i(this.TAG, "onActivityResult, " + paramInt1 + ", " + paramInt2);
      if (paramInt2 == -1)
      {
        paramIntent = this.hZO;
        kotlin.g.b.s.checkNotNull(paramIntent);
        am(paramIntent, this.JTu, this.option);
      }
    }
    AppMethodBeat.o(262330);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(262300);
    super.onBackPressed();
    finish();
    AppMethodBeat.o(262300);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(262280);
    super.onCreate(paramBundle);
    paramBundle = getSupportActionBar();
    kotlin.g.b.s.checkNotNull(paramBundle);
    paramBundle.hide();
    setSelfNavigationBarVisible(8);
    setActionbarColor(getContext().getResources().getColor(com.tencent.mm.plugin.kidswatch.b.b.JRx));
    setNavigationbarColor(getContext().getResources().getColor(com.tencent.mm.plugin.kidswatch.b.b.JRx));
    setMMTitle("");
    initView();
    overridePendingTransition(com.tencent.mm.plugin.kidswatch.b.a.push_up_in, com.tencent.mm.plugin.kidswatch.b.a.anim_not_change);
    AppMethodBeat.o(262280);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(262341);
    Log.i(this.TAG, "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    com.tencent.mm.plugin.kidswatch.model.b.a locala;
    String str;
    if ((paramp instanceof f))
    {
      Log.i(this.TAG, "onSceneEnd type[%d]", new Object[] { Integer.valueOf(((f)paramp).getType()) });
      com.tencent.mm.kernel.h.aZW().b(972, (com.tencent.mm.am.h)this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramInt1 = b.h.JSK;
        if (this.option == 0)
        {
          Log.i(this.TAG, "top");
          paramString = com.tencent.mm.plugin.kidswatch.model.b.JSY;
          paramString = com.tencent.mm.plugin.kidswatch.model.b.a.JSZ;
          paramp = this.hZO;
          kotlin.g.b.s.checkNotNull(paramp);
          com.tencent.mm.plugin.kidswatch.model.b.a(paramString, paramp, b.c.JTi, com.tencent.mm.plugin.kidswatch.model.b.b.JTc, this.JTA, paramInt2);
        }
        for (;;)
        {
          paramString = getContext().getString(paramInt1);
          kotlin.g.b.s.s(paramString, "context.getString(toastTip)");
          Log.i(this.TAG, kotlin.g.b.s.X("Tips: ", paramString));
          aa.db((Context)getContext(), paramString);
          paramString = com.tencent.mm.plugin.kidswatch.b.a.JTW;
          paramString = getContext();
          kotlin.g.b.s.s(paramString, "context");
          com.tencent.mm.plugin.kidswatch.b.a.h((Context)paramString, "", true);
          AppMethodBeat.o(262341);
          return;
          paramInt1 = b.h.JSL;
          paramString = com.tencent.mm.plugin.kidswatch.model.b.JSY;
          paramString = com.tencent.mm.plugin.kidswatch.model.b.a.JSZ;
          paramp = this.hZO;
          kotlin.g.b.s.checkNotNull(paramp);
          com.tencent.mm.plugin.kidswatch.model.b.a(paramString, paramp, b.c.JTj, com.tencent.mm.plugin.kidswatch.model.b.b.JTc, this.JTA, paramInt2);
        }
      }
      if ((paramInt1 == 4) && (paramInt2 == a.b.JRr.value))
      {
        Log.i(this.TAG, "showBlockBySpam");
        v.f((Context)this, paramString, 30846);
        AppMethodBeat.o(262341);
        return;
      }
      paramp = com.tencent.mm.plugin.kidswatch.model.b.JSY;
      locala = com.tencent.mm.plugin.kidswatch.model.b.a.JSZ;
      str = this.hZO;
      kotlin.g.b.s.checkNotNull(str);
      if (this.option != 0) {
        break label411;
      }
    }
    label411:
    for (paramp = b.c.JTi;; paramp = b.c.JTj)
    {
      com.tencent.mm.plugin.kidswatch.model.b.a(locala, str, paramp, com.tencent.mm.plugin.kidswatch.model.b.b.JTf, this.JTA, paramInt2);
      paramp = com.tencent.mm.plugin.kidswatch.b.a.JTW;
      paramp = getContext();
      kotlin.g.b.s.s(paramp, "context");
      com.tencent.mm.plugin.kidswatch.b.a.i((Context)paramp, paramInt2, paramString);
      AppMethodBeat.o(262341);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(KidsWatchLoginFirstChooseSceneUI paramKidsWatchLoginFirstChooseSceneUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.ui.login.KidsWatchLoginFirstChooseSceneUI
 * JD-Core Version:    0.7.0.1
 */