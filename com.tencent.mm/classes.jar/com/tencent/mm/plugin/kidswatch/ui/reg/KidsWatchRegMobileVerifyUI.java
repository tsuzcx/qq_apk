package com.tencent.mm.plugin.kidswatch.ui.reg;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.kidswatch.model.c;
import com.tencent.mm.plugin.kidswatch.model.c.d;
import com.tencent.mm.plugin.kidswatch.model.d;
import com.tencent.mm.plugin.kidswatch.ui.login.KidsWatchHeadComponent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.b.a;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.x;

@com.tencent.mm.ui.base.a(35)
@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegMobileVerifyUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/ui/widget/InputPanelHelper$OnInputPanelChange;", "()V", "hasSetAvatar", "", "headImgAesKey", "", "headImgFileID", "loginUrl", "mobile", "nickName", "openid", "plusCountryCode", "proDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "regSessionId", "verifyTimer", "Lcom/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegMobileVerifyUI$VerifyTimer;", "finish", "", "getForceOrientation", "", "getLayoutId", "gotoRebindUI", "lastNickname", "lastHeadImgUrl", "gotoRegSuccessUI", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onInputPanelChange", "isKeyboardShow", "keyboardHeight", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "requestSms", "startExtReg", "startSms", "startSmsListener", "stopSmsListener", "Companion", "VerifyTimer", "plugin-kidswatch_release"})
public final class KidsWatchRegMobileVerifyUI
  extends MMActivity
  implements i, b.a
{
  public static final KidsWatchRegMobileVerifyUI.a yBD;
  private HashMap _$_findViewCache;
  private String dSf;
  private String dZW;
  private com.tencent.mm.ui.base.q kdn;
  private String knu;
  private boolean kpI;
  private final String kpW = "+86";
  private String nickName;
  private String openid;
  private String yBA;
  private String yBB;
  private b yBC;
  
  static
  {
    AppMethodBeat.i(256355);
    yBD = new KidsWatchRegMobileVerifyUI.a((byte)0);
    AppMethodBeat.o(256355);
  }
  
  private final void bTC()
  {
    AppMethodBeat.i(256350);
    Log.i("MicroMsg.KidsWatchRegMobileVerifyUI", "stopSmsListener");
    if (this.yBC != null)
    {
      b localb = this.yBC;
      if (localb != null)
      {
        localb.cancel();
        AppMethodBeat.o(256350);
        return;
      }
    }
    AppMethodBeat.o(256350);
  }
  
  private final void eca()
  {
    AppMethodBeat.i(256351);
    Log.i("MicroMsg.KidsWatchRegMobileVerifyUI", "startSmsListener");
    Object localObject1;
    if (this.yBC != null)
    {
      localObject1 = this.yBC;
      if (localObject1 != null) {
        ((b)localObject1).cancel();
      }
    }
    for (;;)
    {
      localObject1 = (Button)_$_findCachedViewById(2131306975);
      p.g(localObject1, "resendVerifyCodeBtn");
      ((Button)localObject1).setEnabled(false);
      localObject1 = (Button)_$_findCachedViewById(2131306975);
      Object localObject2 = getContext();
      p.g(localObject2, "context");
      ((Button)localObject1).setTextColor(((AppCompatActivity)localObject2).getResources().getColor(2131099663));
      localObject1 = this.yBC;
      if (localObject1 != null) {
        ((b)localObject1).start();
      }
      Log.i("MicroMsg.KidsWatchRegMobileVerifyUI", "requestSms, opCode:23");
      g.azz().a(145, (i)this);
      localObject1 = (Context)this;
      getString(2131755998);
      this.kdn = h.a((Context)localObject1, getString(2131764376), true, (DialogInterface.OnCancelListener)KidsWatchRegMobileVerifyUI.g.yBF);
      localObject1 = new com.tencent.mm.modelfriend.a(this.kpW + this.dSf, 23, "", 0, "", 0);
      ((com.tencent.mm.modelfriend.a)localObject1).Ok(this.knu);
      localObject2 = this.dZW;
      if (localObject2 == null) {
        p.btv("loginUrl");
      }
      ((com.tencent.mm.modelfriend.a)localObject1).Oj((String)localObject2);
      g.azz().b((com.tencent.mm.ak.q)localObject1);
      AppMethodBeat.o(256351);
      return;
      this.yBC = new b();
    }
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(256359);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(256359);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(256358);
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
    AppMethodBeat.o(256358);
    return localView1;
  }
  
  public final void f(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(256354);
    Log.i("MicroMsg.KidsWatchRegMobileVerifyUI", "keyboard show %s, keyboardHeight %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (paramBoolean)
    {
      localObject1 = (LinearLayout)_$_findCachedViewById(2131302617);
      p.g(localObject1, "imgLL");
      ((LinearLayout)localObject1).setVisibility(8);
      localObject1 = (LinearLayout)_$_findCachedViewById(2131297654);
      p.g(localObject1, "bottomLL");
      localObject1 = ((LinearLayout)localObject1).getLayoutParams();
      if (localObject1 == null)
      {
        localObject1 = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(256354);
        throw ((Throwable)localObject1);
      }
      localObject1 = (ViewGroup.MarginLayoutParams)localObject1;
      ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin = getResources().getDimensionPixelSize(2131165299);
      ((ViewGroup.MarginLayoutParams)localObject1).topMargin = getResources().getDimensionPixelSize(2131165303);
      localObject2 = (LinearLayout)_$_findCachedViewById(2131297654);
      p.g(localObject2, "bottomLL");
      ((LinearLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = (InputPanelLinearLayout)_$_findCachedViewById(2131302669);
      localObject2 = (InputPanelLinearLayout)_$_findCachedViewById(2131302669);
      p.g(localObject2, "inputContainer");
      i = ((InputPanelLinearLayout)localObject2).getPaddingLeft();
      localObject2 = (InputPanelLinearLayout)_$_findCachedViewById(2131302669);
      p.g(localObject2, "inputContainer");
      int j = ((InputPanelLinearLayout)localObject2).getPaddingTop();
      localObject2 = (InputPanelLinearLayout)_$_findCachedViewById(2131302669);
      p.g(localObject2, "inputContainer");
      ((InputPanelLinearLayout)localObject1).setPadding(i, j, ((InputPanelLinearLayout)localObject2).getPaddingRight(), paramInt);
      ((InputPanelLinearLayout)_$_findCachedViewById(2131302669)).requestLayout();
      AppMethodBeat.o(256354);
      return;
    }
    Object localObject1 = (LinearLayout)_$_findCachedViewById(2131302617);
    p.g(localObject1, "imgLL");
    ((LinearLayout)localObject1).setVisibility(0);
    localObject1 = (LinearLayout)_$_findCachedViewById(2131297654);
    p.g(localObject1, "bottomLL");
    localObject1 = ((LinearLayout)localObject1).getLayoutParams();
    if (localObject1 == null)
    {
      localObject1 = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(256354);
      throw ((Throwable)localObject1);
    }
    localObject1 = (ViewGroup.MarginLayoutParams)localObject1;
    ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin = getResources().getDimensionPixelSize(2131165281);
    ((ViewGroup.MarginLayoutParams)localObject1).topMargin = 0;
    Object localObject2 = (LinearLayout)_$_findCachedViewById(2131297654);
    p.g(localObject2, "bottomLL");
    ((LinearLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = (InputPanelLinearLayout)_$_findCachedViewById(2131302669);
    localObject2 = (InputPanelLinearLayout)_$_findCachedViewById(2131302669);
    p.g(localObject2, "inputContainer");
    paramInt = ((InputPanelLinearLayout)localObject2).getPaddingLeft();
    localObject2 = (InputPanelLinearLayout)_$_findCachedViewById(2131302669);
    p.g(localObject2, "inputContainer");
    int i = ((InputPanelLinearLayout)localObject2).getPaddingTop();
    localObject2 = (InputPanelLinearLayout)_$_findCachedViewById(2131302669);
    p.g(localObject2, "inputContainer");
    ((InputPanelLinearLayout)localObject1).setPadding(paramInt, i, ((InputPanelLinearLayout)localObject2).getPaddingRight(), 0);
    AppMethodBeat.o(256354);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(256349);
    super.finish();
    overridePendingTransition(2130771986, 2130772130);
    AppMethodBeat.o(256349);
  }
  
  public final int getForceOrientation()
  {
    return 1;
  }
  
  public final int getLayoutId()
  {
    return 2131495138;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(256352);
    setMMTitle("");
    Object localObject = (KidsWatchHeadComponent)_$_findCachedViewById(2131302263);
    String str = getString(2131762070);
    p.g(str, "getString(R.string.kids_…ogin_enter_loading_title)");
    ((KidsWatchHeadComponent)localObject).setTitle(str);
    ((KidsWatchHeadComponent)_$_findCachedViewById(2131302263)).setCloseBtnCallBack((kotlin.g.a.a)new c(this));
    ((InputPanelLinearLayout)_$_findCachedViewById(2131302669)).setExternalListener((b.a)this);
    localObject = getIntent().getStringExtra("intent.key.login.url");
    p.g(localObject, "intent.getStringExtra(Co…tch.INTENT_KEY_LOGIN_URL)");
    this.dZW = ((String)localObject);
    this.dSf = getIntent().getStringExtra("intent.key.reg.mobile");
    localObject = getIntent().getStringExtra("intent.key.reg.nickname");
    p.g(localObject, "intent.getStringExtra(Co….INTENT_KEY_REG_NICKNAME)");
    this.nickName = ((String)localObject);
    this.knu = getIntent().getStringExtra("intent.key.reg.session.id");
    this.kpI = getIntent().getBooleanExtra("intent.key.hasSetAvatar", false);
    localObject = getIntent().getStringExtra("intent.key.reg.head_img.file.id");
    p.g(localObject, "intent.getStringExtra(Co…KEY_REG_HEAD_IMG_FILE_ID)");
    this.yBA = ((String)localObject);
    localObject = getIntent().getStringExtra("intent.key.reg.head_img.aes.key");
    p.g(localObject, "intent.getStringExtra(Co…KEY_REG_HEAD_IMG_AES_KEY)");
    this.yBB = ((String)localObject);
    eca();
    ((Button)_$_findCachedViewById(2131306975)).setOnClickListener((View.OnClickListener)new d(this));
    ((MMClearEditText)_$_findCachedViewById(2131302670)).addTextChangedListener((TextWatcher)new e(this));
    localObject = (Button)_$_findCachedViewById(2131301535);
    p.g(localObject, "finishBtn");
    ((Button)localObject).setEnabled(false);
    ((Button)_$_findCachedViewById(2131301535)).setOnClickListener((View.OnClickListener)new f(this));
    localObject = (TextView)_$_findCachedViewById(2131304741);
    p.g(localObject, "mobileTV");
    ((TextView)localObject).setText((CharSequence)this.dSf);
    localObject = com.tencent.mm.plugin.kidswatch.b.a.yBL;
    localObject = getContext();
    p.g(localObject, "context");
    com.tencent.mm.plugin.kidswatch.b.a.a((Context)localObject, (LinearLayout)_$_findCachedViewById(2131304319), (LinearLayout)_$_findCachedViewById(2131297654));
    AppMethodBeat.o(256352);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(256345);
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
    AppMethodBeat.o(256345);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(256348);
    super.onDestroy();
    bTC();
    AppMethodBeat.o(256348);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(256347);
    super.onPause();
    ((InputPanelLinearLayout)_$_findCachedViewById(2131302669)).setExternalListener(null);
    bTC();
    AppMethodBeat.o(256347);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(256346);
    super.onResume();
    ((InputPanelLinearLayout)_$_findCachedViewById(2131302669)).setExternalListener((b.a)this);
    AppMethodBeat.o(256346);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(256353);
    Log.i("MicroMsg.KidsWatchRegMobileVerifyUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    Object localObject = this.kdn;
    if (localObject != null) {
      ((com.tencent.mm.ui.base.q)localObject).dismiss();
    }
    if ((paramq instanceof com.tencent.mm.modelfriend.a))
    {
      g.azz().b(145, (i)this);
      int i = ((com.tencent.mm.modelfriend.a)paramq).Vj();
      Log.i("MicroMsg.KidsWatchRegMobileVerifyUI", "NetSceneBindMobileForReg, opCode:".concat(String.valueOf(i)));
      if (i == 23)
      {
        if (paramInt2 != 0)
        {
          if (paramInt2 == -41)
          {
            h.n((Context)this, 2131764394, 2131764395);
            AppMethodBeat.o(256353);
            return;
          }
          if (paramInt2 == -34)
          {
            h.X((Context)this, getString(2131756598), "");
            AppMethodBeat.o(256353);
            return;
          }
          paramq = new com.tencent.mm.platformtools.ae(paramInt1, paramInt2, paramString);
          if (new com.tencent.mm.platformtools.b().a((Activity)this, paramq))
          {
            AppMethodBeat.o(256353);
            return;
          }
          if (com.tencent.mm.plugin.account.a.a.jRu.a((Context)this, paramInt1, paramInt2, paramString))
          {
            AppMethodBeat.o(256353);
            return;
          }
          AppMethodBeat.o(256353);
        }
      }
      else
      {
        if (i == 24)
        {
          String str1;
          String str2;
          switch (paramInt2)
          {
          default: 
            paramString = new com.tencent.mm.platformtools.ae(paramInt1, paramInt2, paramString);
            if (new com.tencent.mm.platformtools.b().a((Activity)this, paramString))
            {
              AppMethodBeat.o(256353);
              return;
            }
            break;
          case 0: 
            paramString = new StringBuilder("startExtReg, ");
            paramq = this.nickName;
            if (paramq == null) {
              p.btv("nickName");
            }
            Log.i("MicroMsg.KidsWatchRegMobileVerifyUI", paramq + ", " + this.kpI + ", " + this.knu + ", 4");
            g.azz().a(5888, (i)this);
            paramString = this.nickName;
            if (paramString == null) {
              p.btv("nickName");
            }
            paramq = this.kpW + this.dSf;
            boolean bool = this.kpI;
            localObject = this.dZW;
            if (localObject == null) {
              p.btv("loginUrl");
            }
            str1 = this.yBA;
            if (str1 == null) {
              p.btv("headImgFileID");
            }
            str2 = this.yBB;
            if (str2 == null) {
              p.btv("headImgAesKey");
            }
            paramString = new d(paramString, paramq, bool, (String)localObject, str1, str2);
            paramString.PB(this.knu);
            g.azz().b((com.tencent.mm.ak.q)paramString);
            paramq = (Context)this;
            getString(2131755998);
            this.kdn = h.a(paramq, getString(2131762103), true, (DialogInterface.OnCancelListener)new KidsWatchRegMobileVerifyUI.h(this, paramString));
            AppMethodBeat.o(256353);
            return;
          case -35: 
            AppMethodBeat.o(256353);
            return;
          case -212: 
            localObject = ((com.tencent.mm.modelfriend.a)paramq).bbT();
            paramq = ((com.tencent.mm.modelfriend.a)paramq).bbS();
            if (Util.isNullOrNil((String)localObject)) {
              Log.e("MicroMsg.KidsWatchRegMobileVerifyUI", "rebind but last nickname is empty");
            }
            str1 = this.knu;
            if (str1 == null) {
              p.hyc();
            }
            Log.i("MicroMsg.KidsWatchRegMobileVerifyUI", "gotoRebindUI, regSessionId:" + str1 + ", lastNickName:" + (String)localObject + ", lastHeadImgUrl:" + paramq);
            finish();
            paramString = new Intent((Context)this, KidsWatchRegRebindUI.class);
            str2 = this.dZW;
            if (str2 == null) {
              p.btv("loginUrl");
            }
            paramString.putExtra("intent.key.login.url", str2);
            str2 = this.nickName;
            if (str2 == null) {
              p.btv("nickName");
            }
            paramString.putExtra("intent.key.reg.nickname", str2);
            paramString.putExtra("intent.key.reg.last.nickname", (String)localObject);
            paramString.putExtra("intent.key.reg.last.head.img.url", paramq);
            paramString.putExtra("intent.key.reg.mobile", this.dSf);
            paramString.putExtra("intent.key.reg.session.id", str1);
            paramString.putExtra("intent.key.hasSetAvatar", this.kpI);
            paramq = this.yBA;
            if (paramq == null) {
              p.btv("headImgFileID");
            }
            paramString.putExtra("intent.key.reg.head_img.file.id", paramq);
            paramq = this.yBB;
            if (paramq == null) {
              p.btv("headImgAesKey");
            }
            paramString.putExtra("intent.key.reg.head_img.aes.key", paramq);
            paramString = new com.tencent.mm.hellhoundlib.b.a().bl(paramString);
            com.tencent.mm.hellhoundlib.a.a.a(this, paramString.axQ(), "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegMobileVerifyUI", "gotoRebindUI", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)paramString.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegMobileVerifyUI", "gotoRebindUI", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(256353);
            return;
          }
          paramString = getString(2131762086, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
          p.g(paramString, "getString(R.string.kids_…or_tip, errType, errCode)");
          h.X((Context)getContext(), paramString, "");
        }
        AppMethodBeat.o(256353);
      }
    }
    else if ((paramq instanceof d))
    {
      Log.i("MicroMsg.KidsWatchRegMobileVerifyUI", "NetSceneExtReg");
      g.azz().b(5888, (i)this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject = ((d)paramq).getUsername();
        this.openid = ((d)paramq).getOpenId();
        paramString = c.yAF;
        paramString = (String)localObject;
        if (localObject == null) {
          paramString = "";
        }
        c.a(paramString, c.d.yAS, 0);
        paramString = new StringBuilder("gotoRegSuccessUI, nickName:");
        paramq = this.nickName;
        if (paramq == null) {
          p.btv("nickName");
        }
        Log.i("MicroMsg.KidsWatchRegMobileVerifyUI", paramq + ", openId:" + this.openid);
        finish();
        paramString = new Intent((Context)this, KidsWatchRegSuccessUI.class);
        paramq = this.dZW;
        if (paramq == null) {
          p.btv("loginUrl");
        }
        paramString.putExtra("intent.key.login.url", paramq);
        paramq = this.nickName;
        if (paramq == null) {
          p.btv("nickName");
        }
        paramString.putExtra("intent.key.reg.nickname", paramq);
        paramString.putExtra("intent.key.reg.openid", this.openid);
        paramString = new com.tencent.mm.hellhoundlib.b.a().bl(paramString);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramString.axQ(), "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegMobileVerifyUI", "gotoRegSuccessUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegMobileVerifyUI", "gotoRegSuccessUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(256353);
        return;
      }
      paramq = c.yAF;
      c.a("", c.d.yAT, paramInt2);
      paramq = new com.tencent.mm.platformtools.ae(paramInt1, paramInt2, paramString);
      if (new com.tencent.mm.platformtools.b().a((Activity)this, paramq))
      {
        AppMethodBeat.o(256353);
        return;
      }
      paramString = com.tencent.mm.h.a.Dk(paramString);
      if (paramString != null)
      {
        paramString.a((Context)this, null, null);
        AppMethodBeat.o(256353);
        return;
      }
      paramString = (Context)getContext();
      paramq = kotlin.g.b.ae.SYK;
      paramq = String.format("注册失败，错误码(%s, %s)", Arrays.copyOf(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }, 2));
      p.g(paramq, "java.lang.String.format(format, *args)");
      h.X(paramString, paramq, "");
    }
    AppMethodBeat.o(256353);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegMobileVerifyUI$VerifyTimer;", "Landroid/os/CountDownTimer;", "millisInFuture", "", "countDownInterval", "(Lcom/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegMobileVerifyUI;JJ)V", "onFinish", "", "onTick", "millisUntilFinished", "plugin-kidswatch_release"})
  public final class b
    extends CountDownTimer
  {
    public b()
    {
      super(1000L);
    }
    
    public final void onFinish()
    {
      AppMethodBeat.i(256336);
      Button localButton = (Button)KidsWatchRegMobileVerifyUI.this._$_findCachedViewById(2131306975);
      p.g(localButton, "resendVerifyCodeBtn");
      localButton.setEnabled(true);
      localButton = (Button)KidsWatchRegMobileVerifyUI.this._$_findCachedViewById(2131306975);
      p.g(localButton, "resendVerifyCodeBtn");
      localButton.setText((CharSequence)KidsWatchRegMobileVerifyUI.this.getString(2131762100));
      localButton = (Button)KidsWatchRegMobileVerifyUI.this._$_findCachedViewById(2131306975);
      AppCompatActivity localAppCompatActivity = KidsWatchRegMobileVerifyUI.this.getContext();
      p.g(localAppCompatActivity, "context");
      localButton.setTextColor(localAppCompatActivity.getResources().getColor(2131100107));
      AppMethodBeat.o(256336);
    }
    
    public final void onTick(long paramLong)
    {
      AppMethodBeat.i(256335);
      Button localButton = (Button)KidsWatchRegMobileVerifyUI.this._$_findCachedViewById(2131306975);
      p.g(localButton, "resendVerifyCodeBtn");
      localButton.setText((CharSequence)KidsWatchRegMobileVerifyUI.this.getString(2131762099, new Object[] { paramLong / 1000L }));
      AppMethodBeat.o(256335);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    c(KidsWatchRegMobileVerifyUI paramKidsWatchRegMobileVerifyUI)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(KidsWatchRegMobileVerifyUI paramKidsWatchRegMobileVerifyUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(256338);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegMobileVerifyUI$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      KidsWatchRegMobileVerifyUI.a(this.yBE);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegMobileVerifyUI$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(256338);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegMobileVerifyUI$initView$3", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-kidswatch_release"})
  public static final class e
    implements TextWatcher
  {
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(256341);
      p.h(paramEditable, "s");
      Button localButton = (Button)this.yBE._$_findCachedViewById(2131301535);
      p.g(localButton, "finishBtn");
      if (!Util.isNullOrNil(paramEditable.toString())) {}
      for (boolean bool = true;; bool = false)
      {
        localButton.setEnabled(bool);
        AppMethodBeat.o(256341);
        return;
      }
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(256339);
      p.h(paramCharSequence, "s");
      AppMethodBeat.o(256339);
    }
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(256340);
      p.h(paramCharSequence, "s");
      AppMethodBeat.o(256340);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(KidsWatchRegMobileVerifyUI paramKidsWatchRegMobileVerifyUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(256342);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegMobileVerifyUI$initView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      Log.i("MicroMsg.KidsWatchRegMobileVerifyUI", "click finish button, code:24");
      this.yBE.hideVKB();
      paramView = this.yBE;
      localObject = (Context)this.yBE;
      this.yBE.getString(2131755998);
      KidsWatchRegMobileVerifyUI.a(paramView, h.a((Context)localObject, this.yBE.getString(2131756029), true, null));
      paramView = (MMClearEditText)this.yBE._$_findCachedViewById(2131302670);
      p.g(paramView, "inputVerifyCodeET");
      paramView = paramView.getText().toString();
      g.azz().a(145, (i)this.yBE);
      paramView = new com.tencent.mm.modelfriend.a(KidsWatchRegMobileVerifyUI.b(this.yBE), 24, paramView, 0, "");
      paramView.Ok(KidsWatchRegMobileVerifyUI.c(this.yBE));
      paramView.Oj(KidsWatchRegMobileVerifyUI.d(this.yBE));
      g.azz().b((com.tencent.mm.ak.q)paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegMobileVerifyUI$initView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(256342);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.ui.reg.KidsWatchRegMobileVerifyUI
 * JD-Core Version:    0.7.0.1
 */