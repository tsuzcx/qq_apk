package com.tencent.mm.plugin.kidswatch.ui.reg;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
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
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.am;
import kotlin.g.b.s;
import kotlin.g.b.u;

@com.tencent.mm.ui.base.a(35)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegSuccessUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "loginUrl", "", "nickname", "openId", "finish", "", "getForceOrientation", "", "getLayoutId", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-kidswatch_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class KidsWatchRegSuccessUI
  extends MMActivity
{
  public static final KidsWatchRegSuccessUI.a JTU;
  private String hZO;
  private String nickname;
  private String openId;
  
  static
  {
    AppMethodBeat.i(262167);
    JTU = new KidsWatchRegSuccessUI.a((byte)0);
    AppMethodBeat.o(262167);
  }
  
  private static final void a(KidsWatchRegSuccessUI paramKidsWatchRegSuccessUI, View paramView)
  {
    AppMethodBeat.i(262155);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramKidsWatchRegSuccessUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegSuccessUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramKidsWatchRegSuccessUI, "this$0");
    paramView = am.aixg;
    localObject = paramKidsWatchRegSuccessUI.openId;
    paramView = (View)localObject;
    if (localObject == null)
    {
      s.bIx("openId");
      paramView = null;
    }
    paramView = String.format("/pages/home/home.html?scene=register&openid=%s", Arrays.copyOf(new Object[] { paramView }, 1));
    s.s(paramView, "java.lang.String.format(format, *args)");
    Log.i("MicroMsg.KidsWatchRegSuccessUI", s.X("goWebUIBtn, path:", paramView));
    localObject = com.tencent.mm.plugin.kidswatch.b.a.JTW;
    localObject = paramKidsWatchRegSuccessUI.getContext();
    s.s(localObject, "context");
    com.tencent.mm.plugin.kidswatch.b.a.h((Context)localObject, "", true);
    localObject = com.tencent.mm.plugin.kidswatch.b.a.JTW;
    paramKidsWatchRegSuccessUI = paramKidsWatchRegSuccessUI.getContext();
    s.s(paramKidsWatchRegSuccessUI, "context");
    com.tencent.mm.plugin.kidswatch.b.a.i((Context)paramKidsWatchRegSuccessUI, "wxaaff6b96fc2cd3c6", paramView, "2");
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegSuccessUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(262155);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final void finish()
  {
    AppMethodBeat.i(262203);
    super.finish();
    overridePendingTransition(b.a.anim_not_change, b.a.push_down_out);
    AppMethodBeat.o(262203);
  }
  
  public final int getForceOrientation()
  {
    return 1;
  }
  
  public final int getLayoutId()
  {
    return b.f.JSy;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(262214);
    setMMTitle("");
    Object localObject = (KidsWatchHeadComponent)findViewById(b.e.JRO);
    String str = getString(b.h.JSG);
    s.s(str, "getString(R.string.kids_…ogin_enter_loading_title)");
    ((KidsWatchHeadComponent)localObject).setTitle(str);
    ((KidsWatchHeadComponent)findViewById(b.e.JRO)).setCloseBtnCallBack((kotlin.g.a.a)new b(this));
    localObject = getIntent().getStringExtra("intent.key.login.url");
    s.checkNotNull(localObject);
    s.s(localObject, "intent.getStringExtra(Co…h.INTENT_KEY_LOGIN_URL)!!");
    this.hZO = ((String)localObject);
    localObject = getIntent().getStringExtra("intent.key.reg.nickname");
    s.checkNotNull(localObject);
    s.s(localObject, "intent.getStringExtra(Co…NTENT_KEY_REG_NICKNAME)!!");
    this.nickname = ((String)localObject);
    localObject = getIntent().getStringExtra("intent.key.reg.openid");
    s.checkNotNull(localObject);
    s.s(localObject, "intent.getStringExtra(Co…INTENT_KEY_REG_OPEN_ID)!!");
    this.openId = ((String)localObject);
    int i = b.h.JSS;
    str = this.nickname;
    localObject = str;
    if (str == null)
    {
      s.bIx("nickname");
      localObject = null;
    }
    localObject = getString(i, new Object[] { localObject });
    s.s(localObject, "getString(R.string.kids_…t_content_desc, nickname)");
    ((TextView)findViewById(b.e.JRK)).setText((CharSequence)localObject);
    ((Button)findViewById(b.e.JRN)).setOnClickListener(new KidsWatchRegSuccessUI..ExternalSyntheticLambda0(this));
    localObject = com.tencent.mm.plugin.kidswatch.b.a.JTW;
    localObject = getContext();
    s.s(localObject, "context");
    com.tencent.mm.plugin.kidswatch.b.a.a((Context)localObject, (LinearLayout)findViewById(b.e.JSc), (LinearLayout)findViewById(b.e.JRD));
    AppMethodBeat.o(262214);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(262178);
    super.onCreate(paramBundle);
    paramBundle = getSupportActionBar();
    s.checkNotNull(paramBundle);
    paramBundle.hide();
    setSelfNavigationBarVisible(8);
    setActionbarColor(getContext().getResources().getColor(b.b.JRx));
    setNavigationbarColor(getContext().getResources().getColor(b.b.JRx));
    initView();
    overridePendingTransition(b.a.push_up_in, b.a.anim_not_change);
    AppMethodBeat.o(262178);
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
    b(KidsWatchRegSuccessUI paramKidsWatchRegSuccessUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.ui.reg.KidsWatchRegSuccessUI
 * JD-Core Version:    0.7.0.1
 */