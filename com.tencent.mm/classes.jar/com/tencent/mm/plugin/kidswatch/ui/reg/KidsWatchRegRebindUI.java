package com.tencent.mm.plugin.kidswatch.ui.reg;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.kidswatch.b.a;
import com.tencent.mm.plugin.kidswatch.b.b;
import com.tencent.mm.plugin.kidswatch.b.e;
import com.tencent.mm.plugin.kidswatch.b.f;
import com.tencent.mm.plugin.kidswatch.b.h;
import com.tencent.mm.plugin.kidswatch.model.c;
import com.tencent.mm.plugin.kidswatch.ui.login.KidsWatchHeadComponent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.bd;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;

@com.tencent.mm.ui.base.a(35)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegRebindUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "hasSetAvatar", "", "headImgAesKey", "", "headImgFileID", "loginUrl", "mobile", "nickName", "openid", "proDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "regSessionId", "finish", "", "getForceOrientation", "", "getLayoutId", "goBackRegUI", "gotoRegSuccessUI", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "startExtReg", "Companion", "plugin-kidswatch_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class KidsWatchRegRebindUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  public static final KidsWatchRegRebindUI.a JTS;
  private String JTO;
  private String JTP;
  private String hRk;
  private String hZO;
  private String nickName;
  private String openid;
  private w pRu;
  private String qcu;
  private boolean qeQ;
  
  static
  {
    AppMethodBeat.i(262129);
    JTS = new KidsWatchRegRebindUI.a((byte)0);
    AppMethodBeat.o(262129);
  }
  
  private static final void a(c paramc, KidsWatchRegRebindUI paramKidsWatchRegRebindUI, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(262124);
    kotlin.g.b.s.u(paramc, "$regScene");
    kotlin.g.b.s.u(paramKidsWatchRegRebindUI, "this$0");
    com.tencent.mm.kernel.h.aZW().a((p)paramc);
    com.tencent.mm.kernel.h.aZW().b(5888, (com.tencent.mm.am.h)paramKidsWatchRegRebindUI);
    AppMethodBeat.o(262124);
  }
  
  private static final void a(KidsWatchRegRebindUI paramKidsWatchRegRebindUI, View paramView)
  {
    Object localObject4 = null;
    AppMethodBeat.i(262109);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramKidsWatchRegRebindUI);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegRebindUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(paramKidsWatchRegRebindUI, "this$0");
    localObject2 = new StringBuilder("startExtReg, ");
    localObject1 = paramKidsWatchRegRebindUI.nickName;
    paramView = (View)localObject1;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("nickName");
      paramView = null;
    }
    Log.i("MicroMsg.KidsWatchRegRebindUI", paramView + ", " + paramKidsWatchRegRebindUI.qeQ + ", " + paramKidsWatchRegRebindUI.qcu + ", 4");
    com.tencent.mm.kernel.h.aZW().a(5888, (com.tencent.mm.am.h)paramKidsWatchRegRebindUI);
    localObject1 = paramKidsWatchRegRebindUI.nickName;
    paramView = (View)localObject1;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("nickName");
      paramView = null;
    }
    localObject2 = paramKidsWatchRegRebindUI.hRk;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("mobile");
      localObject1 = null;
    }
    boolean bool = paramKidsWatchRegRebindUI.qeQ;
    Object localObject3 = paramKidsWatchRegRebindUI.hZO;
    localObject2 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("loginUrl");
      localObject2 = null;
    }
    String str = paramKidsWatchRegRebindUI.JTO;
    localObject3 = str;
    if (str == null)
    {
      kotlin.g.b.s.bIx("headImgFileID");
      localObject3 = null;
    }
    str = paramKidsWatchRegRebindUI.JTP;
    if (str == null) {
      kotlin.g.b.s.bIx("headImgAesKey");
    }
    for (;;)
    {
      paramView = new c(paramView, (String)localObject1, bool, (String)localObject2, (String)localObject3, (String)localObject4);
      paramView.OZ(paramKidsWatchRegRebindUI.qcu);
      com.tencent.mm.kernel.h.aZW().a((p)paramView, 0);
      localObject1 = (Context)paramKidsWatchRegRebindUI;
      paramKidsWatchRegRebindUI.getString(b.h.app_tip);
      paramKidsWatchRegRebindUI.pRu = k.a((Context)localObject1, paramKidsWatchRegRebindUI.getString(b.h.JSR), true, new KidsWatchRegRebindUI..ExternalSyntheticLambda0(paramView, paramKidsWatchRegRebindUI));
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegRebindUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(262109);
      return;
      localObject4 = str;
    }
  }
  
  private static final void b(KidsWatchRegRebindUI paramKidsWatchRegRebindUI, View paramView)
  {
    AppMethodBeat.i(262119);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramKidsWatchRegRebindUI);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegRebindUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(paramKidsWatchRegRebindUI, "this$0");
    localObject2 = new Intent((Context)paramKidsWatchRegRebindUI, KidsWatchRegGetInfoUI.class);
    localObject1 = paramKidsWatchRegRebindUI.hZO;
    paramView = (View)localObject1;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("loginUrl");
      paramView = null;
    }
    ((Intent)localObject2).putExtra("intent.key.login.url", paramView);
    paramView = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
    com.tencent.mm.hellhoundlib.a.a.b(paramKidsWatchRegRebindUI, paramView.aYi(), "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegRebindUI", "goBackRegUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramKidsWatchRegRebindUI.startActivity((Intent)paramView.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramKidsWatchRegRebindUI, "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegRebindUI", "goBackRegUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegRebindUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(262119);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final void finish()
  {
    AppMethodBeat.i(262161);
    super.finish();
    overridePendingTransition(b.a.anim_not_change, b.a.push_down_out);
    AppMethodBeat.o(262161);
  }
  
  public final int getForceOrientation()
  {
    return 1;
  }
  
  public final int getLayoutId()
  {
    return b.f.JSx;
  }
  
  public final void initView()
  {
    Object localObject2 = null;
    AppMethodBeat.i(262177);
    setMMTitle("");
    Object localObject1 = (KidsWatchHeadComponent)findViewById(b.e.JRO);
    Object localObject3 = getString(b.h.JSG);
    kotlin.g.b.s.s(localObject3, "getString(R.string.kids_…ogin_enter_loading_title)");
    ((KidsWatchHeadComponent)localObject1).setTitle((String)localObject3);
    ((KidsWatchHeadComponent)findViewById(b.e.JRO)).setCloseBtnCallBack((kotlin.g.a.a)new b(this));
    localObject1 = getIntent().getStringExtra("intent.key.reg.head_img.file.id");
    kotlin.g.b.s.checkNotNull(localObject1);
    kotlin.g.b.s.s(localObject1, "intent.getStringExtra(Co…Y_REG_HEAD_IMG_FILE_ID)!!");
    this.JTO = ((String)localObject1);
    localObject1 = getIntent().getStringExtra("intent.key.reg.head_img.aes.key");
    kotlin.g.b.s.checkNotNull(localObject1);
    kotlin.g.b.s.s(localObject1, "intent.getStringExtra(Co…Y_REG_HEAD_IMG_AES_KEY)!!");
    this.JTP = ((String)localObject1);
    localObject1 = getIntent().getStringExtra("intent.key.login.url");
    kotlin.g.b.s.checkNotNull(localObject1);
    kotlin.g.b.s.s(localObject1, "intent.getStringExtra(Co…h.INTENT_KEY_LOGIN_URL)!!");
    this.hZO = ((String)localObject1);
    localObject1 = getIntent().getStringExtra("intent.key.reg.mobile");
    kotlin.g.b.s.checkNotNull(localObject1);
    kotlin.g.b.s.s(localObject1, "intent.getStringExtra(Co….INTENT_KEY_REG_MOBILE)!!");
    this.hRk = ((String)localObject1);
    localObject1 = getIntent().getStringExtra("intent.key.reg.nickname");
    kotlin.g.b.s.checkNotNull(localObject1);
    kotlin.g.b.s.s(localObject1, "intent.getStringExtra(Co…NTENT_KEY_REG_NICKNAME)!!");
    this.nickName = ((String)localObject1);
    this.qcu = getIntent().getStringExtra("intent.key.reg.session.id");
    this.qeQ = getIntent().getBooleanExtra("intent.key.hasSetAvatar", false);
    String str1 = getIntent().getStringExtra("intent.key.reg.last.nickname");
    String str2 = getIntent().getStringExtra("intent.key.reg.last.head.img.url");
    localObject3 = (TextView)findViewById(b.e.JRU);
    if (Util.isNullOrNil(str1))
    {
      localObject1 = (CharSequence)"";
      ((TextView)localObject3).setText((CharSequence)localObject1);
      if (!Util.isNullOrNil(str2))
      {
        int i = bd.fromDPToPix((Context)getContext(), 16);
        localObject1 = new c.a();
        ((c.a)localObject1).oKB = com.tencent.mm.plugin.kidswatch.b.d.default_avatar;
        ((c.a)localObject1).oKI = i;
        ((c.a)localObject1).nrc = true;
        r.bKe().a(str2, (ImageView)findViewById(b.e.JRT), ((c.a)localObject1).bKx());
      }
      StringBuilder localStringBuilder = new StringBuilder("fileID:");
      localObject3 = this.JTO;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("headImgFileID");
        localObject1 = null;
      }
      localStringBuilder = localStringBuilder.append((String)localObject1).append(", aeskey:");
      localObject3 = this.JTP;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("headImgAesKey");
        localObject1 = null;
      }
      localStringBuilder = localStringBuilder.append((String)localObject1).append(", loginUrl:");
      localObject3 = this.hZO;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("loginUrl");
        localObject1 = null;
      }
      localObject3 = localStringBuilder.append((String)localObject1).append(", nickName:");
      localObject1 = this.nickName;
      if (localObject1 != null) {
        break label662;
      }
      kotlin.g.b.s.bIx("nickName");
      localObject1 = localObject2;
    }
    label662:
    for (;;)
    {
      Log.i("MicroMsg.KidsWatchRegRebindUI", (String)localObject1 + ", regSessionId:" + this.qcu + ", hasSetAvatar:" + this.qeQ + ", lastNickName:" + str1 + ", lastImgUrl:" + str2);
      ((Button)findViewById(b.e.JSh)).setOnClickListener(new KidsWatchRegRebindUI..ExternalSyntheticLambda2(this));
      ((Button)findViewById(b.e.JRG)).setOnClickListener(new KidsWatchRegRebindUI..ExternalSyntheticLambda1(this));
      localObject1 = com.tencent.mm.plugin.kidswatch.b.a.JTW;
      localObject1 = getContext();
      kotlin.g.b.s.s(localObject1, "context");
      com.tencent.mm.plugin.kidswatch.b.a.a((Context)localObject1, (LinearLayout)findViewById(b.e.JRF), (LinearLayout)findViewById(b.e.JRD));
      AppMethodBeat.o(262177);
      return;
      localObject1 = (CharSequence)str1;
      break;
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(262150);
    super.onCreate(paramBundle);
    paramBundle = getSupportActionBar();
    kotlin.g.b.s.checkNotNull(paramBundle);
    paramBundle.hide();
    setSelfNavigationBarVisible(8);
    setActionbarColor(getContext().getResources().getColor(b.b.JRx));
    setNavigationbarColor(getContext().getResources().getColor(b.b.JRx));
    initView();
    overridePendingTransition(b.a.push_up_in, b.a.anim_not_change);
    AppMethodBeat.o(262150);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    Object localObject1 = null;
    AppMethodBeat.i(262193);
    if ((paramp instanceof c))
    {
      Log.i("MicroMsg.KidsWatchRegRebindUI", "errType:" + paramInt1 + ", errCode:" + paramInt2 + ", errMsg:" + paramString);
      Object localObject2 = this.pRu;
      if (localObject2 != null) {
        ((w)localObject2).dismiss();
      }
      com.tencent.mm.kernel.h.aZW().b(5888, (com.tencent.mm.am.h)this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject2 = ((c)paramp).getUsername();
        this.openid = ((c)paramp).getOpenId();
        paramString = com.tencent.mm.plugin.kidswatch.model.b.JSY;
        paramString = (String)localObject2;
        if (localObject2 == null) {
          paramString = "";
        }
        com.tencent.mm.plugin.kidswatch.model.b.a(paramString, com.tencent.mm.plugin.kidswatch.model.b.d.JTl, 0);
        localObject2 = new StringBuilder("gotoRegSuccessUI, nickName:");
        paramp = this.nickName;
        paramString = paramp;
        if (paramp == null)
        {
          kotlin.g.b.s.bIx("nickName");
          paramString = null;
        }
        Log.i("MicroMsg.KidsWatchRegRebindUI", paramString + ", openId:" + this.openid);
        localObject2 = new Intent((Context)this, KidsWatchRegSuccessUI.class);
        paramp = this.hZO;
        paramString = paramp;
        if (paramp == null)
        {
          kotlin.g.b.s.bIx("loginUrl");
          paramString = null;
        }
        ((Intent)localObject2).putExtra("intent.key.login.url", paramString);
        paramString = this.nickName;
        if (paramString == null)
        {
          kotlin.g.b.s.bIx("nickName");
          paramString = localObject1;
        }
        for (;;)
        {
          ((Intent)localObject2).putExtra("intent.key.reg.nickname", paramString);
          ((Intent)localObject2).putExtra("intent.key.reg.openid", this.openid);
          paramString = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
          com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aYi(), "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegRebindUI", "gotoRegSuccessUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramString.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegRebindUI", "gotoRegSuccessUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(262193);
          return;
        }
      }
      paramp = com.tencent.mm.plugin.kidswatch.model.b.JSY;
      com.tencent.mm.plugin.kidswatch.model.b.a("", com.tencent.mm.plugin.kidswatch.model.b.d.JTm, paramInt2);
      paramp = new aa(paramInt1, paramInt2, paramString);
      if (new com.tencent.mm.platformtools.b().a((Activity)this, paramp))
      {
        AppMethodBeat.o(262193);
        return;
      }
      paramString = com.tencent.mm.broadcast.a.CH(paramString);
      if (paramString != null)
      {
        paramString.a((Context)this, null, null);
        AppMethodBeat.o(262193);
        return;
      }
      paramString = getString(b.h.JSM, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      kotlin.g.b.s.s(paramString, "getString(R.string.kids_…or_tip, errType, errCode)");
      k.c((Context)getContext(), paramString, "", true);
    }
    AppMethodBeat.o(262193);
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
    b(KidsWatchRegRebindUI paramKidsWatchRegRebindUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.ui.reg.KidsWatchRegRebindUI
 * JD-Core Version:    0.7.0.1
 */