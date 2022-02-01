package com.tencent.mm.plugin.kidswatch.ui.reg;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.platformtools.ad;
import com.tencent.mm.plugin.kidswatch.b.a;
import com.tencent.mm.plugin.kidswatch.b.b;
import com.tencent.mm.plugin.kidswatch.b.c;
import com.tencent.mm.plugin.kidswatch.b.e;
import com.tencent.mm.plugin.kidswatch.b.f;
import com.tencent.mm.plugin.kidswatch.b.h;
import com.tencent.mm.plugin.kidswatch.model.c;
import com.tencent.mm.plugin.kidswatch.model.c.d;
import com.tencent.mm.plugin.kidswatch.model.d;
import com.tencent.mm.plugin.kidswatch.ui.login.KidsWatchHeadComponent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.c.a;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.x;

@com.tencent.mm.ui.base.a(35)
@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegMobileVerifyUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/ui/widget/InputPanelHelper$OnInputPanelChange;", "()V", "hasSetAvatar", "", "headImgAesKey", "", "headImgFileID", "loginUrl", "mobile", "nickName", "openid", "plusCountryCode", "proDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "regSessionId", "verifyTimer", "Lcom/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegMobileVerifyUI$VerifyTimer;", "finish", "", "getForceOrientation", "", "getLayoutId", "gotoRebindUI", "lastNickname", "lastHeadImgUrl", "gotoRegSuccessUI", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onInputPanelChange", "isKeyboardShow", "keyboardHeight", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "requestSms", "startExtReg", "startSms", "startSmsListener", "stopSmsListener", "Companion", "VerifyTimer", "plugin-kidswatch_release"})
public final class KidsWatchRegMobileVerifyUI
  extends MMActivity
  implements i, c.a
{
  public static final KidsWatchRegMobileVerifyUI.a EcT;
  private String EcQ;
  private String EcR;
  private b EcS;
  private HashMap _$_findViewCache;
  private String fLC;
  private String fTQ;
  private s mUN;
  private String nfm;
  private final String nhJ = "+86";
  private boolean nhv;
  private String nickName;
  private String openid;
  
  static
  {
    AppMethodBeat.i(251776);
    EcT = new KidsWatchRegMobileVerifyUI.a((byte)0);
    AppMethodBeat.o(251776);
  }
  
  private final void cgH()
  {
    AppMethodBeat.i(251756);
    Log.i("MicroMsg.KidsWatchRegMobileVerifyUI", "stopSmsListener");
    if (this.EcS != null)
    {
      b localb = this.EcS;
      if (localb != null)
      {
        localb.cancel();
        AppMethodBeat.o(251756);
        return;
      }
    }
    AppMethodBeat.o(251756);
  }
  
  private final void eKY()
  {
    AppMethodBeat.i(251759);
    Log.i("MicroMsg.KidsWatchRegMobileVerifyUI", "startSmsListener");
    Object localObject1;
    if (this.EcS != null)
    {
      localObject1 = this.EcS;
      if (localObject1 != null) {
        ((b)localObject1).cancel();
      }
    }
    for (;;)
    {
      localObject1 = (Button)_$_findCachedViewById(b.e.Ebd);
      p.j(localObject1, "resendVerifyCodeBtn");
      ((Button)localObject1).setEnabled(false);
      localObject1 = (Button)_$_findCachedViewById(b.e.Ebd);
      Object localObject2 = getContext();
      p.j(localObject2, "context");
      ((Button)localObject1).setTextColor(((AppCompatActivity)localObject2).getResources().getColor(b.b.Eao));
      localObject1 = this.EcS;
      if (localObject1 != null) {
        ((b)localObject1).start();
      }
      Log.i("MicroMsg.KidsWatchRegMobileVerifyUI", "requestSms, opCode:23");
      com.tencent.mm.kernel.h.aGY().a(145, (i)this);
      localObject1 = (Context)this;
      getString(b.h.app_tip);
      this.mUN = com.tencent.mm.ui.base.h.a((Context)localObject1, getString(b.h.regbyfacebook_reg_setpwd_exiting), true, (DialogInterface.OnCancelListener)KidsWatchRegMobileVerifyUI.g.EcV);
      localObject1 = new com.tencent.mm.modelfriend.a(this.nhJ + this.fLC, 23, "", 0, "", 0);
      ((com.tencent.mm.modelfriend.a)localObject1).VH(this.nfm);
      localObject2 = this.fTQ;
      if (localObject2 == null) {
        p.bGy("loginUrl");
      }
      ((com.tencent.mm.modelfriend.a)localObject1).VG((String)localObject2);
      com.tencent.mm.kernel.h.aGY().b((com.tencent.mm.an.q)localObject1);
      AppMethodBeat.o(251759);
      return;
      this.EcS = new b();
    }
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(251790);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(251790);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(251789);
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
    AppMethodBeat.o(251789);
    return localView1;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(251753);
    super.finish();
    overridePendingTransition(b.a.anim_not_change, b.a.push_down_out);
    AppMethodBeat.o(251753);
  }
  
  public final int getForceOrientation()
  {
    return 1;
  }
  
  public final int getLayoutId()
  {
    return b.f.Ebo;
  }
  
  public final void h(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(251773);
    Log.i("MicroMsg.KidsWatchRegMobileVerifyUI", "keyboard show %s, keyboardHeight %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (paramBoolean)
    {
      localObject1 = (LinearLayout)_$_findCachedViewById(b.e.EaI);
      p.j(localObject1, "imgLL");
      ((LinearLayout)localObject1).setVisibility(8);
      localObject1 = (LinearLayout)_$_findCachedViewById(b.e.Eav);
      p.j(localObject1, "bottomLL");
      localObject1 = ((LinearLayout)localObject1).getLayoutParams();
      if (localObject1 == null)
      {
        localObject1 = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(251773);
        throw ((Throwable)localObject1);
      }
      localObject1 = (ViewGroup.MarginLayoutParams)localObject1;
      ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin = getResources().getDimensionPixelSize(b.c.Edge_3A);
      ((ViewGroup.MarginLayoutParams)localObject1).topMargin = getResources().getDimensionPixelSize(b.c.Edge_4A);
      localObject2 = (LinearLayout)_$_findCachedViewById(b.e.Eav);
      p.j(localObject2, "bottomLL");
      ((LinearLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = (InputPanelLinearLayout)_$_findCachedViewById(b.e.EaJ);
      localObject2 = (InputPanelLinearLayout)_$_findCachedViewById(b.e.EaJ);
      p.j(localObject2, "inputContainer");
      i = ((InputPanelLinearLayout)localObject2).getPaddingLeft();
      localObject2 = (InputPanelLinearLayout)_$_findCachedViewById(b.e.EaJ);
      p.j(localObject2, "inputContainer");
      int j = ((InputPanelLinearLayout)localObject2).getPaddingTop();
      localObject2 = (InputPanelLinearLayout)_$_findCachedViewById(b.e.EaJ);
      p.j(localObject2, "inputContainer");
      ((InputPanelLinearLayout)localObject1).setPadding(i, j, ((InputPanelLinearLayout)localObject2).getPaddingRight(), paramInt);
      ((InputPanelLinearLayout)_$_findCachedViewById(b.e.EaJ)).requestLayout();
      AppMethodBeat.o(251773);
      return;
    }
    Object localObject1 = (LinearLayout)_$_findCachedViewById(b.e.EaI);
    p.j(localObject1, "imgLL");
    ((LinearLayout)localObject1).setVisibility(0);
    localObject1 = (LinearLayout)_$_findCachedViewById(b.e.Eav);
    p.j(localObject1, "bottomLL");
    localObject1 = ((LinearLayout)localObject1).getLayoutParams();
    if (localObject1 == null)
    {
      localObject1 = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(251773);
      throw ((Throwable)localObject1);
    }
    localObject1 = (ViewGroup.MarginLayoutParams)localObject1;
    ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin = getResources().getDimensionPixelSize(b.c.Edge_12A);
    ((ViewGroup.MarginLayoutParams)localObject1).topMargin = 0;
    Object localObject2 = (LinearLayout)_$_findCachedViewById(b.e.Eav);
    p.j(localObject2, "bottomLL");
    ((LinearLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = (InputPanelLinearLayout)_$_findCachedViewById(b.e.EaJ);
    localObject2 = (InputPanelLinearLayout)_$_findCachedViewById(b.e.EaJ);
    p.j(localObject2, "inputContainer");
    paramInt = ((InputPanelLinearLayout)localObject2).getPaddingLeft();
    localObject2 = (InputPanelLinearLayout)_$_findCachedViewById(b.e.EaJ);
    p.j(localObject2, "inputContainer");
    int i = ((InputPanelLinearLayout)localObject2).getPaddingTop();
    localObject2 = (InputPanelLinearLayout)_$_findCachedViewById(b.e.EaJ);
    p.j(localObject2, "inputContainer");
    ((InputPanelLinearLayout)localObject1).setPadding(paramInt, i, ((InputPanelLinearLayout)localObject2).getPaddingRight(), 0);
    AppMethodBeat.o(251773);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(251763);
    setMMTitle("");
    Object localObject = (KidsWatchHeadComponent)_$_findCachedViewById(b.e.EaG);
    String str = getString(b.h.Eby);
    p.j(str, "getString(R.string.kids_…ogin_enter_loading_title)");
    ((KidsWatchHeadComponent)localObject).setTitle(str);
    ((KidsWatchHeadComponent)_$_findCachedViewById(b.e.EaG)).setCloseBtnCallBack((kotlin.g.a.a)new c(this));
    ((InputPanelLinearLayout)_$_findCachedViewById(b.e.EaJ)).setExternalListener((c.a)this);
    localObject = getIntent().getStringExtra("intent.key.login.url");
    p.j(localObject, "intent.getStringExtra(Co…tch.INTENT_KEY_LOGIN_URL)");
    this.fTQ = ((String)localObject);
    this.fLC = getIntent().getStringExtra("intent.key.reg.mobile");
    localObject = getIntent().getStringExtra("intent.key.reg.nickname");
    p.j(localObject, "intent.getStringExtra(Co….INTENT_KEY_REG_NICKNAME)");
    this.nickName = ((String)localObject);
    this.nfm = getIntent().getStringExtra("intent.key.reg.session.id");
    this.nhv = getIntent().getBooleanExtra("intent.key.hasSetAvatar", false);
    localObject = getIntent().getStringExtra("intent.key.reg.head_img.file.id");
    p.j(localObject, "intent.getStringExtra(Co…KEY_REG_HEAD_IMG_FILE_ID)");
    this.EcQ = ((String)localObject);
    localObject = getIntent().getStringExtra("intent.key.reg.head_img.aes.key");
    p.j(localObject, "intent.getStringExtra(Co…KEY_REG_HEAD_IMG_AES_KEY)");
    this.EcR = ((String)localObject);
    eKY();
    ((Button)_$_findCachedViewById(b.e.Ebd)).setOnClickListener((View.OnClickListener)new d(this));
    ((MMClearEditText)_$_findCachedViewById(b.e.EaK)).addTextChangedListener((TextWatcher)new e(this));
    localObject = (Button)_$_findCachedViewById(b.e.EaE);
    p.j(localObject, "finishBtn");
    ((Button)localObject).setEnabled(false);
    ((Button)_$_findCachedViewById(b.e.EaE)).setOnClickListener((View.OnClickListener)new f(this));
    localObject = (TextView)_$_findCachedViewById(b.e.EaW);
    p.j(localObject, "mobileTV");
    ((TextView)localObject).setText((CharSequence)this.fLC);
    localObject = com.tencent.mm.plugin.kidswatch.b.a.Edb;
    localObject = getContext();
    p.j(localObject, "context");
    com.tencent.mm.plugin.kidswatch.b.a.a((Context)localObject, (LinearLayout)_$_findCachedViewById(b.e.EaU), (LinearLayout)_$_findCachedViewById(b.e.Eav));
    AppMethodBeat.o(251763);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(251740);
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
    AppMethodBeat.o(251740);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(251750);
    super.onDestroy();
    cgH();
    AppMethodBeat.o(251750);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(251748);
    super.onPause();
    ((InputPanelLinearLayout)_$_findCachedViewById(b.e.EaJ)).setExternalListener(null);
    cgH();
    AppMethodBeat.o(251748);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(251745);
    super.onResume();
    ((InputPanelLinearLayout)_$_findCachedViewById(b.e.EaJ)).setExternalListener((c.a)this);
    AppMethodBeat.o(251745);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(251770);
    Log.i("MicroMsg.KidsWatchRegMobileVerifyUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    Object localObject = this.mUN;
    if (localObject != null) {
      ((s)localObject).dismiss();
    }
    if ((paramq instanceof com.tencent.mm.modelfriend.a))
    {
      com.tencent.mm.kernel.h.aGY().b(145, (i)this);
      int i = ((com.tencent.mm.modelfriend.a)paramq).ZB();
      Log.i("MicroMsg.KidsWatchRegMobileVerifyUI", "NetSceneBindMobileForReg, opCode:".concat(String.valueOf(i)));
      if (i == 23)
      {
        if (paramInt2 != 0)
        {
          if (paramInt2 == -41)
          {
            com.tencent.mm.ui.base.h.p((Context)this, b.h.regbymobile_reg_mobile_format_err_msg, b.h.regbymobile_reg_mobile_format_err_title);
            AppMethodBeat.o(251770);
            return;
          }
          if (paramInt2 == -34)
          {
            com.tencent.mm.ui.base.h.af((Context)this, getString(b.h.bind_mcontact_err_freq_limit), "");
            AppMethodBeat.o(251770);
            return;
          }
          paramq = new ad(paramInt1, paramInt2, paramString);
          if (new com.tencent.mm.platformtools.b().a((Activity)this, paramq))
          {
            AppMethodBeat.o(251770);
            return;
          }
          if (com.tencent.mm.plugin.account.sdk.a.mIH.a((Context)this, paramInt1, paramInt2, paramString))
          {
            AppMethodBeat.o(251770);
            return;
          }
          AppMethodBeat.o(251770);
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
            paramString = new ad(paramInt1, paramInt2, paramString);
            if (new com.tencent.mm.platformtools.b().a((Activity)this, paramString))
            {
              AppMethodBeat.o(251770);
              return;
            }
            break;
          case 0: 
            paramString = new StringBuilder("startExtReg, ");
            paramq = this.nickName;
            if (paramq == null) {
              p.bGy("nickName");
            }
            Log.i("MicroMsg.KidsWatchRegMobileVerifyUI", paramq + ", " + this.nhv + ", " + this.nfm + ", 4");
            com.tencent.mm.kernel.h.aGY().a(5888, (i)this);
            paramString = this.nickName;
            if (paramString == null) {
              p.bGy("nickName");
            }
            paramq = this.nhJ + this.fLC;
            boolean bool = this.nhv;
            localObject = this.fTQ;
            if (localObject == null) {
              p.bGy("loginUrl");
            }
            str1 = this.EcQ;
            if (str1 == null) {
              p.bGy("headImgFileID");
            }
            str2 = this.EcR;
            if (str2 == null) {
              p.bGy("headImgAesKey");
            }
            paramString = new d(paramString, paramq, bool, (String)localObject, str1, str2);
            paramString.WZ(this.nfm);
            com.tencent.mm.kernel.h.aGY().b((com.tencent.mm.an.q)paramString);
            paramq = (Context)this;
            getString(b.h.app_tip);
            this.mUN = com.tencent.mm.ui.base.h.a(paramq, getString(b.h.EbJ), true, (DialogInterface.OnCancelListener)new h(this, paramString));
            AppMethodBeat.o(251770);
            return;
          case -35: 
            AppMethodBeat.o(251770);
            return;
          case -212: 
            localObject = ((com.tencent.mm.modelfriend.a)paramq).blj();
            paramq = ((com.tencent.mm.modelfriend.a)paramq).bli();
            if (Util.isNullOrNil((String)localObject)) {
              Log.e("MicroMsg.KidsWatchRegMobileVerifyUI", "rebind but last nickname is empty");
            }
            str1 = this.nfm;
            if (str1 == null) {
              p.iCn();
            }
            Log.i("MicroMsg.KidsWatchRegMobileVerifyUI", "gotoRebindUI, regSessionId:" + str1 + ", lastNickName:" + (String)localObject + ", lastHeadImgUrl:" + paramq);
            finish();
            paramString = new Intent((Context)this, KidsWatchRegRebindUI.class);
            str2 = this.fTQ;
            if (str2 == null) {
              p.bGy("loginUrl");
            }
            paramString.putExtra("intent.key.login.url", str2);
            str2 = this.nickName;
            if (str2 == null) {
              p.bGy("nickName");
            }
            paramString.putExtra("intent.key.reg.nickname", str2);
            paramString.putExtra("intent.key.reg.last.nickname", (String)localObject);
            paramString.putExtra("intent.key.reg.last.head.img.url", paramq);
            paramString.putExtra("intent.key.reg.mobile", this.fLC);
            paramString.putExtra("intent.key.reg.session.id", str1);
            paramString.putExtra("intent.key.hasSetAvatar", this.nhv);
            paramq = this.EcQ;
            if (paramq == null) {
              p.bGy("headImgFileID");
            }
            paramString.putExtra("intent.key.reg.head_img.file.id", paramq);
            paramq = this.EcR;
            if (paramq == null) {
              p.bGy("headImgAesKey");
            }
            paramString.putExtra("intent.key.reg.head_img.aes.key", paramq);
            paramString = new com.tencent.mm.hellhoundlib.b.a().bm(paramString);
            com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aFh(), "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegMobileVerifyUI", "gotoRebindUI", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)paramString.sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegMobileVerifyUI", "gotoRebindUI", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(251770);
            return;
          }
          paramString = getString(b.h.EbE, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
          p.j(paramString, "getString(R.string.kids_…or_tip, errType, errCode)");
          com.tencent.mm.ui.base.h.af((Context)getContext(), paramString, "");
        }
        AppMethodBeat.o(251770);
      }
    }
    else if ((paramq instanceof d))
    {
      Log.i("MicroMsg.KidsWatchRegMobileVerifyUI", "NetSceneExtReg");
      com.tencent.mm.kernel.h.aGY().b(5888, (i)this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject = ((d)paramq).getUsername();
        this.openid = ((d)paramq).getOpenId();
        paramString = c.EbU;
        paramString = (String)localObject;
        if (localObject == null) {
          paramString = "";
        }
        c.a(paramString, c.d.Ech, 0);
        paramString = new StringBuilder("gotoRegSuccessUI, nickName:");
        paramq = this.nickName;
        if (paramq == null) {
          p.bGy("nickName");
        }
        Log.i("MicroMsg.KidsWatchRegMobileVerifyUI", paramq + ", openId:" + this.openid);
        finish();
        paramString = new Intent((Context)this, KidsWatchRegSuccessUI.class);
        paramq = this.fTQ;
        if (paramq == null) {
          p.bGy("loginUrl");
        }
        paramString.putExtra("intent.key.login.url", paramq);
        paramq = this.nickName;
        if (paramq == null) {
          p.bGy("nickName");
        }
        paramString.putExtra("intent.key.reg.nickname", paramq);
        paramString.putExtra("intent.key.reg.openid", this.openid);
        paramString = new com.tencent.mm.hellhoundlib.b.a().bm(paramString);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aFh(), "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegMobileVerifyUI", "gotoRegSuccessUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegMobileVerifyUI", "gotoRegSuccessUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(251770);
        return;
      }
      paramq = c.EbU;
      c.a("", c.d.Eci, paramInt2);
      paramq = new ad(paramInt1, paramInt2, paramString);
      if (new com.tencent.mm.platformtools.b().a((Activity)this, paramq))
      {
        AppMethodBeat.o(251770);
        return;
      }
      paramString = com.tencent.mm.h.a.Kb(paramString);
      if (paramString != null)
      {
        paramString.a((Context)this, null, null);
        AppMethodBeat.o(251770);
        return;
      }
      paramString = (Context)getContext();
      paramq = af.aaBG;
      paramq = String.format("注册失败，错误码(%s, %s)", Arrays.copyOf(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }, 2));
      p.j(paramq, "java.lang.String.format(format, *args)");
      com.tencent.mm.ui.base.h.af(paramString, paramq, "");
    }
    AppMethodBeat.o(251770);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegMobileVerifyUI$VerifyTimer;", "Landroid/os/CountDownTimer;", "millisInFuture", "", "countDownInterval", "(Lcom/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegMobileVerifyUI;JJ)V", "onFinish", "", "onTick", "millisUntilFinished", "plugin-kidswatch_release"})
  public final class b
    extends CountDownTimer
  {
    public b()
    {
      super(1000L);
    }
    
    public final void onFinish()
    {
      AppMethodBeat.i(251810);
      Button localButton = (Button)this.EcU._$_findCachedViewById(b.e.Ebd);
      p.j(localButton, "resendVerifyCodeBtn");
      localButton.setEnabled(true);
      localButton = (Button)this.EcU._$_findCachedViewById(b.e.Ebd);
      p.j(localButton, "resendVerifyCodeBtn");
      localButton.setText((CharSequence)this.EcU.getString(b.h.EbI));
      localButton = (Button)this.EcU._$_findCachedViewById(b.e.Ebd);
      AppCompatActivity localAppCompatActivity = this.EcU.getContext();
      p.j(localAppCompatActivity, "context");
      localButton.setTextColor(localAppCompatActivity.getResources().getColor(b.b.Eaq));
      AppMethodBeat.o(251810);
    }
    
    public final void onTick(long paramLong)
    {
      AppMethodBeat.i(251808);
      Button localButton = (Button)this.EcU._$_findCachedViewById(b.e.Ebd);
      p.j(localButton, "resendVerifyCodeBtn");
      localButton.setText((CharSequence)this.EcU.getString(b.h.EbH, new Object[] { paramLong / 1000L }));
      AppMethodBeat.o(251808);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    c(KidsWatchRegMobileVerifyUI paramKidsWatchRegMobileVerifyUI)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(KidsWatchRegMobileVerifyUI paramKidsWatchRegMobileVerifyUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(252185);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegMobileVerifyUI$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      KidsWatchRegMobileVerifyUI.a(this.EcU);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegMobileVerifyUI$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(252185);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegMobileVerifyUI$initView$3", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-kidswatch_release"})
  public static final class e
    implements TextWatcher
  {
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(252266);
      p.k(paramEditable, "s");
      Button localButton = (Button)this.EcU._$_findCachedViewById(b.e.EaE);
      p.j(localButton, "finishBtn");
      if (!Util.isNullOrNil(paramEditable.toString())) {}
      for (boolean bool = true;; bool = false)
      {
        localButton.setEnabled(bool);
        AppMethodBeat.o(252266);
        return;
      }
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(252264);
      p.k(paramCharSequence, "s");
      AppMethodBeat.o(252264);
    }
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(252265);
      p.k(paramCharSequence, "s");
      AppMethodBeat.o(252265);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(KidsWatchRegMobileVerifyUI paramKidsWatchRegMobileVerifyUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(251396);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegMobileVerifyUI$initView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      Log.i("MicroMsg.KidsWatchRegMobileVerifyUI", "click finish button, code:24");
      this.EcU.hideVKB();
      paramView = this.EcU;
      localObject = (Context)this.EcU;
      this.EcU.getString(b.h.app_tip);
      KidsWatchRegMobileVerifyUI.a(paramView, com.tencent.mm.ui.base.h.a((Context)localObject, this.EcU.getString(b.h.app_waiting), true, null));
      paramView = (MMClearEditText)this.EcU._$_findCachedViewById(b.e.EaK);
      p.j(paramView, "inputVerifyCodeET");
      paramView = paramView.getText().toString();
      com.tencent.mm.kernel.h.aGY().a(145, (i)this.EcU);
      paramView = new com.tencent.mm.modelfriend.a(KidsWatchRegMobileVerifyUI.b(this.EcU), 24, paramView, 0, "");
      paramView.VH(KidsWatchRegMobileVerifyUI.c(this.EcU));
      paramView.VG(KidsWatchRegMobileVerifyUI.d(this.EcU));
      com.tencent.mm.kernel.h.aGY().b((com.tencent.mm.an.q)paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegMobileVerifyUI$initView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(251396);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class h
    implements DialogInterface.OnCancelListener
  {
    h(KidsWatchRegMobileVerifyUI paramKidsWatchRegMobileVerifyUI, d paramd) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(252064);
      com.tencent.mm.kernel.h.aGY().a((com.tencent.mm.an.q)paramString);
      com.tencent.mm.kernel.h.aGY().b(5888, (i)this.EcU);
      AppMethodBeat.o(252064);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.ui.reg.KidsWatchRegMobileVerifyUI
 * JD-Core Version:    0.7.0.1
 */