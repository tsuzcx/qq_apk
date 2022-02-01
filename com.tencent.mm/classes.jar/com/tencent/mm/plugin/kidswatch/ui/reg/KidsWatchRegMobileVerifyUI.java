package com.tencent.mm.plugin.kidswatch.ui.reg;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.kidswatch.b.a;
import com.tencent.mm.plugin.kidswatch.b.b;
import com.tencent.mm.plugin.kidswatch.b.c;
import com.tencent.mm.plugin.kidswatch.b.e;
import com.tencent.mm.plugin.kidswatch.b.f;
import com.tencent.mm.plugin.kidswatch.b.h;
import com.tencent.mm.plugin.kidswatch.model.b.d;
import com.tencent.mm.plugin.kidswatch.model.c;
import com.tencent.mm.plugin.kidswatch.ui.login.KidsWatchHeadComponent;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.c.a;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.am;
import kotlin.g.b.u;

@com.tencent.mm.ui.base.a(35)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegMobileVerifyUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/ui/widget/InputPanelHelper$OnInputPanelChange;", "()V", "hasSetAvatar", "", "headImgAesKey", "", "headImgFileID", "loginUrl", "mobile", "nickName", "openid", "plusCountryCode", "proDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "regSessionId", "verifyTimer", "Lcom/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegMobileVerifyUI$VerifyTimer;", "finish", "", "getForceOrientation", "", "getLayoutId", "gotoRebindUI", "lastNickname", "lastHeadImgUrl", "gotoRegSuccessUI", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onInputPanelChange", "isKeyboardShow", "keyboardHeight", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "requestSms", "startExtReg", "startSms", "startSmsListener", "stopSmsListener", "Companion", "VerifyTimer", "plugin-kidswatch_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class KidsWatchRegMobileVerifyUI
  extends MMActivity
  implements com.tencent.mm.am.h, c.a
{
  public static final KidsWatchRegMobileVerifyUI.a JTN;
  private String JTO;
  private String JTP;
  private b JTQ;
  private String hRk;
  private String hZO;
  private String nickName;
  private String openid;
  private w pRu;
  private String qcu;
  private boolean qeQ;
  private final String qfe = "+86";
  
  static
  {
    AppMethodBeat.i(262209);
    JTN = new KidsWatchRegMobileVerifyUI.a((byte)0);
    AppMethodBeat.o(262209);
  }
  
  private static final void a(c paramc, KidsWatchRegMobileVerifyUI paramKidsWatchRegMobileVerifyUI, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(262180);
    kotlin.g.b.s.u(paramc, "$regScene");
    kotlin.g.b.s.u(paramKidsWatchRegMobileVerifyUI, "this$0");
    com.tencent.mm.kernel.h.aZW().a((p)paramc);
    com.tencent.mm.kernel.h.aZW().b(5888, (com.tencent.mm.am.h)paramKidsWatchRegMobileVerifyUI);
    AppMethodBeat.o(262180);
  }
  
  private static final void a(KidsWatchRegMobileVerifyUI paramKidsWatchRegMobileVerifyUI, View paramView)
  {
    AppMethodBeat.i(262188);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramKidsWatchRegMobileVerifyUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegMobileVerifyUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramKidsWatchRegMobileVerifyUI, "this$0");
    paramKidsWatchRegMobileVerifyUI.fSV();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegMobileVerifyUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(262188);
  }
  
  private static final void b(KidsWatchRegMobileVerifyUI paramKidsWatchRegMobileVerifyUI, View paramView)
  {
    AppMethodBeat.i(262204);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramKidsWatchRegMobileVerifyUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegMobileVerifyUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramKidsWatchRegMobileVerifyUI, "this$0");
    Log.i("MicroMsg.KidsWatchRegMobileVerifyUI", "click finish button, code:24");
    paramKidsWatchRegMobileVerifyUI.hideVKB();
    paramView = (Context)paramKidsWatchRegMobileVerifyUI;
    paramKidsWatchRegMobileVerifyUI.getString(b.h.app_tip);
    paramKidsWatchRegMobileVerifyUI.pRu = k.a(paramView, paramKidsWatchRegMobileVerifyUI.getString(b.h.app_waiting), true, null);
    paramView = ((MMClearEditText)paramKidsWatchRegMobileVerifyUI.findViewById(b.e.JRS)).getText().toString();
    com.tencent.mm.kernel.h.aZW().a(145, (com.tencent.mm.am.h)paramKidsWatchRegMobileVerifyUI);
    localObject = new com.tencent.mm.modelfriend.a(paramKidsWatchRegMobileVerifyUI.hRk, 24, paramView, 0, "");
    ((com.tencent.mm.modelfriend.a)localObject).NH(paramKidsWatchRegMobileVerifyUI.qcu);
    paramView = paramKidsWatchRegMobileVerifyUI.hZO;
    paramKidsWatchRegMobileVerifyUI = paramView;
    if (paramView == null)
    {
      kotlin.g.b.s.bIx("loginUrl");
      paramKidsWatchRegMobileVerifyUI = null;
    }
    ((com.tencent.mm.modelfriend.a)localObject).NG(paramKidsWatchRegMobileVerifyUI);
    com.tencent.mm.kernel.h.aZW().a((p)localObject, 0);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegMobileVerifyUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(262204);
  }
  
  private final void cHF()
  {
    AppMethodBeat.i(262158);
    Log.i("MicroMsg.KidsWatchRegMobileVerifyUI", "stopSmsListener");
    if (this.JTQ != null)
    {
      b localb = this.JTQ;
      if (localb != null) {
        localb.cancel();
      }
    }
    AppMethodBeat.o(262158);
  }
  
  private final void fSV()
  {
    AppMethodBeat.i(262169);
    Log.i("MicroMsg.KidsWatchRegMobileVerifyUI", "startSmsListener");
    Object localObject;
    if (this.JTQ != null)
    {
      localObject = this.JTQ;
      if (localObject != null) {
        ((b)localObject).cancel();
      }
    }
    for (;;)
    {
      ((Button)findViewById(b.e.JSl)).setEnabled(false);
      ((Button)findViewById(b.e.JSl)).setTextColor(getContext().getResources().getColor(b.b.JRw));
      localObject = this.JTQ;
      if (localObject != null) {
        ((b)localObject).start();
      }
      Log.i("MicroMsg.KidsWatchRegMobileVerifyUI", "requestSms, opCode:23");
      com.tencent.mm.kernel.h.aZW().a(145, (com.tencent.mm.am.h)this);
      localObject = (Context)this;
      getString(b.h.app_tip);
      this.pRu = k.a((Context)localObject, getString(b.h.regbyfacebook_reg_setpwd_exiting), true, KidsWatchRegMobileVerifyUI..ExternalSyntheticLambda1.INSTANCE);
      com.tencent.mm.modelfriend.a locala = new com.tencent.mm.modelfriend.a(kotlin.g.b.s.X(this.qfe, this.hRk), 23, "", 0, "", 0);
      locala.NH(this.qcu);
      String str = this.hZO;
      localObject = str;
      if (str == null)
      {
        kotlin.g.b.s.bIx("loginUrl");
        localObject = null;
      }
      locala.NG((String)localObject);
      com.tencent.mm.kernel.h.aZW().a((p)locala, 0);
      AppMethodBeat.o(262169);
      return;
      this.JTQ = new b();
    }
  }
  
  private static final void y(DialogInterface paramDialogInterface) {}
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final void finish()
  {
    AppMethodBeat.i(262273);
    super.finish();
    overridePendingTransition(b.a.anim_not_change, b.a.push_down_out);
    AppMethodBeat.o(262273);
  }
  
  public final int getForceOrientation()
  {
    return 1;
  }
  
  public final int getLayoutId()
  {
    return b.f.JSw;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(262293);
    setMMTitle("");
    Object localObject = (KidsWatchHeadComponent)findViewById(b.e.JRO);
    String str = getString(b.h.JSG);
    kotlin.g.b.s.s(str, "getString(R.string.kids_…ogin_enter_loading_title)");
    ((KidsWatchHeadComponent)localObject).setTitle(str);
    ((KidsWatchHeadComponent)findViewById(b.e.JRO)).setCloseBtnCallBack((kotlin.g.a.a)new c(this));
    ((InputPanelLinearLayout)findViewById(b.e.JRR)).setExternalListener((c.a)this);
    localObject = getIntent().getStringExtra("intent.key.login.url");
    kotlin.g.b.s.checkNotNull(localObject);
    kotlin.g.b.s.s(localObject, "intent.getStringExtra(Co…h.INTENT_KEY_LOGIN_URL)!!");
    this.hZO = ((String)localObject);
    this.hRk = getIntent().getStringExtra("intent.key.reg.mobile");
    localObject = getIntent().getStringExtra("intent.key.reg.nickname");
    kotlin.g.b.s.checkNotNull(localObject);
    kotlin.g.b.s.s(localObject, "intent.getStringExtra(Co…NTENT_KEY_REG_NICKNAME)!!");
    this.nickName = ((String)localObject);
    this.qcu = getIntent().getStringExtra("intent.key.reg.session.id");
    this.qeQ = getIntent().getBooleanExtra("intent.key.hasSetAvatar", false);
    localObject = getIntent().getStringExtra("intent.key.reg.head_img.file.id");
    kotlin.g.b.s.checkNotNull(localObject);
    kotlin.g.b.s.s(localObject, "intent.getStringExtra(Co…Y_REG_HEAD_IMG_FILE_ID)!!");
    this.JTO = ((String)localObject);
    localObject = getIntent().getStringExtra("intent.key.reg.head_img.aes.key");
    kotlin.g.b.s.checkNotNull(localObject);
    kotlin.g.b.s.s(localObject, "intent.getStringExtra(Co…Y_REG_HEAD_IMG_AES_KEY)!!");
    this.JTP = ((String)localObject);
    fSV();
    ((Button)findViewById(b.e.JSl)).setOnClickListener(new KidsWatchRegMobileVerifyUI..ExternalSyntheticLambda3(this));
    ((MMClearEditText)findViewById(b.e.JRS)).addTextChangedListener((TextWatcher)new d(this));
    ((Button)findViewById(b.e.JRM)).setEnabled(false);
    ((Button)findViewById(b.e.JRM)).setOnClickListener(new KidsWatchRegMobileVerifyUI..ExternalSyntheticLambda2(this));
    ((TextView)findViewById(b.e.JSe)).setText((CharSequence)this.hRk);
    localObject = com.tencent.mm.plugin.kidswatch.b.a.JTW;
    localObject = getContext();
    kotlin.g.b.s.s(localObject, "context");
    com.tencent.mm.plugin.kidswatch.b.a.a((Context)localObject, (LinearLayout)findViewById(b.e.JSc), (LinearLayout)findViewById(b.e.JRD));
    AppMethodBeat.o(262293);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(262241);
    super.onCreate(paramBundle);
    paramBundle = getSupportActionBar();
    kotlin.g.b.s.checkNotNull(paramBundle);
    paramBundle.hide();
    setSelfNavigationBarVisible(8);
    setActionbarColor(getContext().getResources().getColor(b.b.JRx));
    setNavigationbarColor(getContext().getResources().getColor(b.b.JRx));
    initView();
    overridePendingTransition(b.a.push_up_in, b.a.anim_not_change);
    AppMethodBeat.o(262241);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(262265);
    super.onDestroy();
    cHF();
    AppMethodBeat.o(262265);
  }
  
  public final void onInputPanelChange(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(262338);
    Log.i("MicroMsg.KidsWatchRegMobileVerifyUI", "keyboard show %s, keyboardHeight %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (paramBoolean)
    {
      ((LinearLayout)findViewById(b.e.JRQ)).setVisibility(8);
      localObject = ((LinearLayout)findViewById(b.e.JRD)).getLayoutParams();
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(262338);
        throw ((Throwable)localObject);
      }
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = getResources().getDimensionPixelSize(b.c.Edge_3A);
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = getResources().getDimensionPixelSize(b.c.Edge_4A);
      ((LinearLayout)findViewById(b.e.JRD)).setLayoutParams((ViewGroup.LayoutParams)localObject);
      ((InputPanelLinearLayout)findViewById(b.e.JRR)).setPadding(((InputPanelLinearLayout)findViewById(b.e.JRR)).getPaddingLeft(), ((InputPanelLinearLayout)findViewById(b.e.JRR)).getPaddingTop(), ((InputPanelLinearLayout)findViewById(b.e.JRR)).getPaddingRight(), paramInt);
      ((InputPanelLinearLayout)findViewById(b.e.JRR)).requestLayout();
      AppMethodBeat.o(262338);
      return;
    }
    ((LinearLayout)findViewById(b.e.JRQ)).setVisibility(0);
    Object localObject = ((LinearLayout)findViewById(b.e.JRD)).getLayoutParams();
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(262338);
      throw ((Throwable)localObject);
    }
    localObject = (ViewGroup.MarginLayoutParams)localObject;
    ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = getResources().getDimensionPixelSize(b.c.Edge_12A);
    ((ViewGroup.MarginLayoutParams)localObject).topMargin = 0;
    ((LinearLayout)findViewById(b.e.JRD)).setLayoutParams((ViewGroup.LayoutParams)localObject);
    ((InputPanelLinearLayout)findViewById(b.e.JRR)).setPadding(((InputPanelLinearLayout)findViewById(b.e.JRR)).getPaddingLeft(), ((InputPanelLinearLayout)findViewById(b.e.JRR)).getPaddingTop(), ((InputPanelLinearLayout)findViewById(b.e.JRR)).getPaddingRight(), 0);
    AppMethodBeat.o(262338);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(262257);
    super.onPause();
    ((InputPanelLinearLayout)findViewById(b.e.JRR)).setExternalListener(null);
    cHF();
    AppMethodBeat.o(262257);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(262249);
    super.onResume();
    ((InputPanelLinearLayout)findViewById(b.e.JRR)).setExternalListener((c.a)this);
    AppMethodBeat.o(262249);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    Object localObject1 = null;
    String str1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(262326);
    Log.i("MicroMsg.KidsWatchRegMobileVerifyUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    Object localObject3 = this.pRu;
    if (localObject3 != null) {
      ((w)localObject3).dismiss();
    }
    if ((paramp instanceof com.tencent.mm.modelfriend.a))
    {
      com.tencent.mm.kernel.h.aZW().b(145, (com.tencent.mm.am.h)this);
      int i = ((com.tencent.mm.modelfriend.a)paramp).bIO();
      Log.i("MicroMsg.KidsWatchRegMobileVerifyUI", kotlin.g.b.s.X("NetSceneBindMobileForReg, opCode:", Integer.valueOf(i)));
      switch (i)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(262326);
        return;
        if (paramInt2 == 0) {
          break;
        }
        if (paramInt2 == -41)
        {
          k.s((Context)this, b.h.regbymobile_reg_mobile_format_err_msg, b.h.regbymobile_reg_mobile_format_err_title);
          AppMethodBeat.o(262326);
          return;
        }
        if (paramInt2 == -34)
        {
          k.c((Context)this, getString(b.h.bind_mcontact_err_freq_limit), "", true);
          AppMethodBeat.o(262326);
          return;
        }
        paramp = new aa(paramInt1, paramInt2, paramString);
        if (new com.tencent.mm.platformtools.b().a((Activity)this, paramp))
        {
          AppMethodBeat.o(262326);
          return;
        }
        if (com.tencent.mm.plugin.account.sdk.a.pFo.a((Context)this, paramInt1, paramInt2, paramString))
        {
          AppMethodBeat.o(262326);
          return;
        }
        AppMethodBeat.o(262326);
        return;
        switch (paramInt2)
        {
        default: 
          paramString = new aa(paramInt1, paramInt2, paramString);
          if (new com.tencent.mm.platformtools.b().a((Activity)this, paramString))
          {
            AppMethodBeat.o(262326);
            return;
          }
          break;
        case 0: 
          localObject1 = new StringBuilder("startExtReg, ");
          paramp = this.nickName;
          paramString = paramp;
          if (paramp == null)
          {
            kotlin.g.b.s.bIx("nickName");
            paramString = null;
          }
          Log.i("MicroMsg.KidsWatchRegMobileVerifyUI", paramString + ", " + this.qeQ + ", " + this.qcu + ", 4");
          com.tencent.mm.kernel.h.aZW().a(5888, (com.tencent.mm.am.h)this);
          paramp = this.nickName;
          paramString = paramp;
          if (paramp == null)
          {
            kotlin.g.b.s.bIx("nickName");
            paramString = null;
          }
          localObject3 = kotlin.g.b.s.X(this.qfe, this.hRk);
          boolean bool = this.qeQ;
          localObject1 = this.hZO;
          paramp = (p)localObject1;
          if (localObject1 == null)
          {
            kotlin.g.b.s.bIx("loginUrl");
            paramp = null;
          }
          str1 = this.JTO;
          localObject1 = str1;
          if (str1 == null)
          {
            kotlin.g.b.s.bIx("headImgFileID");
            localObject1 = null;
          }
          str1 = this.JTP;
          if (str1 == null) {
            kotlin.g.b.s.bIx("headImgAesKey");
          }
          for (;;)
          {
            paramString = new c(paramString, (String)localObject3, bool, paramp, (String)localObject1, (String)localObject2);
            paramString.OZ(this.qcu);
            com.tencent.mm.kernel.h.aZW().a((p)paramString, 0);
            paramp = (Context)this;
            getString(b.h.app_tip);
            this.pRu = k.a(paramp, getString(b.h.JSR), true, new KidsWatchRegMobileVerifyUI..ExternalSyntheticLambda0(paramString, this));
            AppMethodBeat.o(262326);
            return;
            localObject2 = str1;
          }
        case -35: 
          AppMethodBeat.o(262326);
          return;
        case -212: 
          str1 = ((com.tencent.mm.modelfriend.a)paramp).bJd();
          localObject3 = ((com.tencent.mm.modelfriend.a)paramp).bJc();
          if (Util.isNullOrNil(str1)) {
            Log.e("MicroMsg.KidsWatchRegMobileVerifyUI", "rebind but last nickname is empty");
          }
          String str2 = this.qcu;
          kotlin.g.b.s.checkNotNull(str2);
          Log.i("MicroMsg.KidsWatchRegMobileVerifyUI", "gotoRebindUI, regSessionId:" + str2 + ", lastNickName:" + str1 + ", lastHeadImgUrl:" + localObject3);
          finish();
          localObject2 = new Intent((Context)this, KidsWatchRegRebindUI.class);
          paramp = this.hZO;
          paramString = paramp;
          if (paramp == null)
          {
            kotlin.g.b.s.bIx("loginUrl");
            paramString = null;
          }
          ((Intent)localObject2).putExtra("intent.key.login.url", paramString);
          paramp = this.nickName;
          paramString = paramp;
          if (paramp == null)
          {
            kotlin.g.b.s.bIx("nickName");
            paramString = null;
          }
          ((Intent)localObject2).putExtra("intent.key.reg.nickname", paramString);
          ((Intent)localObject2).putExtra("intent.key.reg.last.nickname", str1);
          ((Intent)localObject2).putExtra("intent.key.reg.last.head.img.url", (String)localObject3);
          ((Intent)localObject2).putExtra("intent.key.reg.mobile", this.hRk);
          ((Intent)localObject2).putExtra("intent.key.reg.session.id", str2);
          ((Intent)localObject2).putExtra("intent.key.hasSetAvatar", this.qeQ);
          paramp = this.JTO;
          paramString = paramp;
          if (paramp == null)
          {
            kotlin.g.b.s.bIx("headImgFileID");
            paramString = null;
          }
          ((Intent)localObject2).putExtra("intent.key.reg.head_img.file.id", paramString);
          paramString = this.JTP;
          if (paramString == null)
          {
            kotlin.g.b.s.bIx("headImgAesKey");
            paramString = (String)localObject1;
          }
          for (;;)
          {
            ((Intent)localObject2).putExtra("intent.key.reg.head_img.aes.key", paramString);
            paramString = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
            com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aYi(), "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegMobileVerifyUI", "gotoRebindUI", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)paramString.sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegMobileVerifyUI", "gotoRebindUI", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(262326);
            return;
          }
        }
        paramString = getString(b.h.JSM, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        kotlin.g.b.s.s(paramString, "getString(R.string.kids_…or_tip, errType, errCode)");
        k.c((Context)getContext(), paramString, "", true);
      }
    }
    if ((paramp instanceof c))
    {
      Log.i("MicroMsg.KidsWatchRegMobileVerifyUI", "NetSceneExtReg");
      com.tencent.mm.kernel.h.aZW().b(5888, (com.tencent.mm.am.h)this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject1 = ((c)paramp).getUsername();
        this.openid = ((c)paramp).getOpenId();
        paramString = com.tencent.mm.plugin.kidswatch.model.b.JSY;
        paramString = (String)localObject1;
        if (localObject1 == null) {
          paramString = "";
        }
        com.tencent.mm.plugin.kidswatch.model.b.a(paramString, b.d.JTl, 0);
        localObject1 = new StringBuilder("gotoRegSuccessUI, nickName:");
        paramp = this.nickName;
        paramString = paramp;
        if (paramp == null)
        {
          kotlin.g.b.s.bIx("nickName");
          paramString = null;
        }
        Log.i("MicroMsg.KidsWatchRegMobileVerifyUI", paramString + ", openId:" + this.openid);
        finish();
        localObject1 = new Intent((Context)this, KidsWatchRegSuccessUI.class);
        paramp = this.hZO;
        paramString = paramp;
        if (paramp == null)
        {
          kotlin.g.b.s.bIx("loginUrl");
          paramString = null;
        }
        ((Intent)localObject1).putExtra("intent.key.login.url", paramString);
        paramString = this.nickName;
        if (paramString == null)
        {
          kotlin.g.b.s.bIx("nickName");
          paramString = str1;
        }
        for (;;)
        {
          ((Intent)localObject1).putExtra("intent.key.reg.nickname", paramString);
          ((Intent)localObject1).putExtra("intent.key.reg.openid", this.openid);
          paramString = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
          com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aYi(), "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegMobileVerifyUI", "gotoRegSuccessUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramString.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegMobileVerifyUI", "gotoRegSuccessUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(262326);
          return;
        }
      }
      paramp = com.tencent.mm.plugin.kidswatch.model.b.JSY;
      com.tencent.mm.plugin.kidswatch.model.b.a("", b.d.JTm, paramInt2);
      paramp = new aa(paramInt1, paramInt2, paramString);
      if (new com.tencent.mm.platformtools.b().a((Activity)this, paramp))
      {
        AppMethodBeat.o(262326);
        return;
      }
      paramString = com.tencent.mm.broadcast.a.CH(paramString);
      if (paramString != null)
      {
        paramString.a((Context)this, null, null);
        AppMethodBeat.o(262326);
        return;
      }
      paramString = (Context)getContext();
      paramp = am.aixg;
      paramp = String.format("注册失败，错误码(%s, %s)", Arrays.copyOf(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }, 2));
      kotlin.g.b.s.s(paramp, "java.lang.String.format(format, *args)");
      k.c(paramString, paramp, "", true);
    }
    AppMethodBeat.o(262326);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegMobileVerifyUI$VerifyTimer;", "Landroid/os/CountDownTimer;", "millisInFuture", "", "countDownInterval", "(Lcom/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegMobileVerifyUI;JJ)V", "onFinish", "", "onTick", "millisUntilFinished", "plugin-kidswatch_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends CountDownTimer
  {
    public b()
    {
      super(1000L);
      AppMethodBeat.i(262107);
      AppMethodBeat.o(262107);
    }
    
    public final void onFinish()
    {
      AppMethodBeat.i(262121);
      ((Button)this.JTR.findViewById(b.e.JSl)).setEnabled(true);
      ((Button)this.JTR.findViewById(b.e.JSl)).setText((CharSequence)this.JTR.getString(b.h.JSQ));
      ((Button)this.JTR.findViewById(b.e.JSl)).setTextColor(this.JTR.getContext().getResources().getColor(b.b.JRy));
      AppMethodBeat.o(262121);
    }
    
    public final void onTick(long paramLong)
    {
      AppMethodBeat.i(262116);
      ((Button)this.JTR.findViewById(b.e.JSl)).setText((CharSequence)this.JTR.getString(b.h.JSP, new Object[] { kotlin.g.b.s.X("", Long.valueOf(paramLong / 1000L)) }));
      AppMethodBeat.o(262116);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(KidsWatchRegMobileVerifyUI paramKidsWatchRegMobileVerifyUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegMobileVerifyUI$initView$3", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-kidswatch_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements TextWatcher
  {
    d(KidsWatchRegMobileVerifyUI paramKidsWatchRegMobileVerifyUI) {}
    
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(262115);
      kotlin.g.b.s.u(paramEditable, "s");
      Button localButton = (Button)this.JTR.findViewById(b.e.JRM);
      if (!Util.isNullOrNil(paramEditable.toString())) {}
      for (boolean bool = true;; bool = false)
      {
        localButton.setEnabled(bool);
        AppMethodBeat.o(262115);
        return;
      }
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(262103);
      kotlin.g.b.s.u(paramCharSequence, "s");
      AppMethodBeat.o(262103);
    }
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(262108);
      kotlin.g.b.s.u(paramCharSequence, "s");
      AppMethodBeat.o(262108);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.ui.reg.KidsWatchRegMobileVerifyUI
 * JD-Core Version:    0.7.0.1
 */