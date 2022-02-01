package com.tencent.mm.plugin.kidswatch.ui.reg;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aq.f;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.i.g;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.plugin.account.ui.r.j;
import com.tencent.mm.plugin.kidswatch.b.a;
import com.tencent.mm.plugin.kidswatch.b.c;
import com.tencent.mm.plugin.kidswatch.b.e;
import com.tencent.mm.plugin.kidswatch.b.f;
import com.tencent.mm.plugin.kidswatch.b.h;
import com.tencent.mm.plugin.kidswatch.ui.login.KidsWatchHeadComponent;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.RoundCornerImageView;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.n.n;

@com.tencent.mm.ui.base.a(35)
@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegGetInfoUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/ui/widget/InputPanelHelper$OnInputPanelChange;", "Lcom/tencent/mm/plugin/kidswatch/model/KidsWatchHeadImageUploader$IImgUploadCallback;", "()V", "adjustedMobile", "", "avatarBitmap", "Landroid/graphics/Bitmap;", "hasSetAvatar", "", "inputMobileRetrys", "", "lastInputMobile", "loginUrl", "mMobile", "needShowAgreements", "permissionCheckHelper", "Lcom/tencent/mm/platformtools/PermissionCheckHelper;", "plusCountryCode", "proDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "regSessionId", "changeAvatar", "", "checkMobileState", "mNumber", "checkMobileStateFun", "finish", "getForceOrientation", "getLayoutId", "gotoLawLink", "gotoMobileVerifyCodePage", "fileId", "aesKey", "initView", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onError", "errType", "errCode", "errMsg", "onInputPanelChange", "isKeyboardShow", "keyboardHeight", "onKeyBoardHidden", "onPause", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onSceneEnd", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSuccess", "fileID", "uploadHeadImg", "Companion", "plugin-kidswatch_release"})
public final class KidsWatchRegGetInfoUI
  extends MMActivity
  implements com.tencent.mm.an.i, com.tencent.mm.plugin.kidswatch.model.b.b, com.tencent.mm.ui.widget.c.a
{
  public static final KidsWatchRegGetInfoUI.a EcJ;
  private HashMap _$_findViewCache;
  private String fTQ;
  private s mUN;
  private final com.tencent.mm.platformtools.x nex;
  private String nfH;
  private String nfe;
  private String nff;
  private int nfg;
  private String nfm;
  private final String nhJ;
  private Bitmap nhP;
  private boolean nhV;
  private boolean nhv;
  
  static
  {
    AppMethodBeat.i(251534);
    EcJ = new KidsWatchRegGetInfoUI.a((byte)0);
    AppMethodBeat.o(251534);
  }
  
  public KidsWatchRegGetInfoUI()
  {
    AppMethodBeat.i(251532);
    this.nhJ = "+86";
    this.nhV = true;
    this.nex = new com.tencent.mm.platformtools.x();
    AppMethodBeat.o(251532);
  }
  
  private final void abb(final String paramString)
  {
    AppMethodBeat.i(251517);
    this.nex.b((Activity)this, (Runnable)new b(this, paramString));
    AppMethodBeat.o(251517);
  }
  
  private final void eKW()
  {
    AppMethodBeat.i(251519);
    if (!this.nhv)
    {
      Log.i("MicroMsg.KidsWatchRegGetInfoUI", "uploadHeadImg, gotoMobileVerifyCodePage, " + this.nhv);
      iE("", "");
      AppMethodBeat.o(251519);
      return;
    }
    Object localObject = (Context)this;
    getString(b.h.app_tip);
    this.mUN = com.tencent.mm.ui.base.h.a((Context)localObject, getString(b.h.app_waiting), true, null);
    localObject = new com.tencent.mm.plugin.kidswatch.model.b(com.tencent.mm.loader.j.b.aST() + "temp.avatar", (com.tencent.mm.plugin.kidswatch.model.b.b)this);
    g localg = new g();
    localg.taskName = "task_KidsWatchHeadImageUpload";
    localg.iUG = ((com.tencent.mm.plugin.kidswatch.model.b)localObject).lPx;
    localg.field_mediaId = ((com.tencent.mm.plugin.kidswatch.model.b)localObject).mediaId;
    localg.field_fullpath = ((com.tencent.mm.plugin.kidswatch.model.b)localObject).fKH;
    localg.field_thumbpath = "";
    localg.field_fileType = com.tencent.mm.plugin.kidswatch.model.b.mJz;
    localg.field_talker = "";
    localg.field_priority = com.tencent.mm.i.a.iTU;
    localg.field_needStorage = false;
    localg.field_isStreamMedia = false;
    localg.field_appType = 1;
    localg.field_bzScene = 0;
    localg.hDp = 5;
    localg.field_trysafecdn = true;
    localg.field_enable_hitcheck = false;
    if (!f.bkg().f(localg)) {
      Log.e("MicroMsg.KidsWatch.KidsWatchHeadImageUploader", "cdntra addSendTask failed. mediaId:%s", new Object[] { ((com.tencent.mm.plugin.kidswatch.model.b)localObject).mediaId });
    }
    AppMethodBeat.o(251519);
  }
  
  private final void eKX()
  {
    AppMethodBeat.i(251527);
    Object localObject1 = (LinearLayout)_$_findCachedViewById(b.e.EaI);
    p.j(localObject1, "imgLL");
    ((LinearLayout)localObject1).setVisibility(0);
    localObject1 = (LinearLayout)_$_findCachedViewById(b.e.Eav);
    p.j(localObject1, "bottomLL");
    localObject1 = ((LinearLayout)localObject1).getLayoutParams();
    if (localObject1 == null)
    {
      localObject1 = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(251527);
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
    int i = ((InputPanelLinearLayout)localObject2).getPaddingLeft();
    localObject2 = (InputPanelLinearLayout)_$_findCachedViewById(b.e.EaJ);
    p.j(localObject2, "inputContainer");
    int j = ((InputPanelLinearLayout)localObject2).getPaddingTop();
    localObject2 = (InputPanelLinearLayout)_$_findCachedViewById(b.e.EaJ);
    p.j(localObject2, "inputContainer");
    ((InputPanelLinearLayout)localObject1).setPadding(i, j, ((InputPanelLinearLayout)localObject2).getPaddingRight(), 0);
    ((ScrollView)_$_findCachedViewById(b.e.scrollView)).scrollBy(0, 0);
    AppMethodBeat.o(251527);
  }
  
  private final void iE(String paramString1, String paramString2)
  {
    AppMethodBeat.i(251520);
    Intent localIntent = new Intent((Context)this, KidsWatchRegMobileVerifyUI.class);
    Object localObject = this.fTQ;
    if (localObject == null) {
      p.bGy("loginUrl");
    }
    localIntent.putExtra("intent.key.login.url", (String)localObject);
    localObject = (MMClearEditText)_$_findCachedViewById(b.e.EaX);
    p.j(localObject, "nickFIV");
    localIntent.putExtra("intent.key.reg.nickname", ((MMClearEditText)localObject).getText().toString());
    localObject = (MMClearEditText)_$_findCachedViewById(b.e.EaV);
    p.j(localObject, "mobileFIV");
    localIntent.putExtra("intent.key.reg.mobile", ((MMClearEditText)localObject).getText().toString());
    localIntent.putExtra("intent.key.reg.session.id", this.nfm);
    localIntent.putExtra("intent.key.hasSetAvatar", this.nhv);
    localIntent.putExtra("intent.key.reg.head_img.file.id", paramString1);
    localIntent.putExtra("intent.key.reg.head_img.aes.key", paramString2);
    Log.i("MicroMsg.KidsWatchRegGetInfoUI", "get info page:(fileId:" + paramString1 + ") , (aesKey:" + paramString2 + ')');
    paramString1 = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(this, paramString1.aFh(), "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegGetInfoUI", "gotoMobileVerifyCodePage", "(Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramString1.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegGetInfoUI", "gotoMobileVerifyCodePage", "(Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(251520);
  }
  
  public final void R(String paramString1, String paramString2)
  {
    AppMethodBeat.i(251528);
    p.k(paramString1, "fileID");
    p.k(paramString2, "aesKey");
    com.tencent.e.h.ZvG.bc((Runnable)new m(this));
    Log.i("MicroMsg.KidsWatchRegGetInfoUI", "IImgUploadCallback, ok, fileId:" + paramString1 + ", aesKey:" + paramString2);
    iE(paramString1, paramString2);
    AppMethodBeat.o(251528);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(251555);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(251555);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(251554);
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
    AppMethodBeat.o(251554);
    return localView1;
  }
  
  public final void aMM(String paramString)
  {
    AppMethodBeat.i(251530);
    com.tencent.e.h.ZvG.bc((Runnable)new k(this));
    Log.e("MicroMsg.KidsWatchRegGetInfoUI", "upload head fail, errType:%s, errCode:%s, errMsg:%s", new Object[] { Integer.valueOf(3), Integer.valueOf(-1), paramString });
    iE("", "");
    AppMethodBeat.o(251530);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(251515);
    super.finish();
    overridePendingTransition(b.a.anim_not_change, b.a.push_down_out);
    AppMethodBeat.o(251515);
  }
  
  public final int getForceOrientation()
  {
    return 1;
  }
  
  public final int getLayoutId()
  {
    return b.f.Ebm;
  }
  
  public final void h(boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(251525);
    Log.i("MicroMsg.KidsWatchRegGetInfoUI", "keyboard show %s, keyboardHeight %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (paramBoolean)
    {
      Object localObject1 = (LinearLayout)_$_findCachedViewById(b.e.EaI);
      p.j(localObject1, "imgLL");
      ((LinearLayout)localObject1).setVisibility(8);
      localObject1 = (LinearLayout)_$_findCachedViewById(b.e.Eav);
      p.j(localObject1, "bottomLL");
      localObject1 = ((LinearLayout)localObject1).getLayoutParams();
      if (localObject1 == null)
      {
        localObject1 = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(251525);
        throw ((Throwable)localObject1);
      }
      localObject1 = (ViewGroup.MarginLayoutParams)localObject1;
      ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin = getResources().getDimensionPixelSize(b.c.Edge_3A);
      ((ViewGroup.MarginLayoutParams)localObject1).topMargin = getResources().getDimensionPixelSize(b.c.Edge_4A);
      Object localObject2 = (LinearLayout)_$_findCachedViewById(b.e.Eav);
      p.j(localObject2, "bottomLL");
      ((LinearLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = (InputPanelLinearLayout)_$_findCachedViewById(b.e.EaJ);
      localObject2 = (InputPanelLinearLayout)_$_findCachedViewById(b.e.EaJ);
      p.j(localObject2, "inputContainer");
      int i = ((InputPanelLinearLayout)localObject2).getPaddingLeft();
      localObject2 = (InputPanelLinearLayout)_$_findCachedViewById(b.e.EaJ);
      p.j(localObject2, "inputContainer");
      int j = ((InputPanelLinearLayout)localObject2).getPaddingTop();
      localObject2 = (InputPanelLinearLayout)_$_findCachedViewById(b.e.EaJ);
      p.j(localObject2, "inputContainer");
      ((InputPanelLinearLayout)localObject1).setPadding(i, j, ((InputPanelLinearLayout)localObject2).getPaddingRight(), paramInt);
      localObject1 = (ScrollView)_$_findCachedViewById(b.e.scrollView);
      p.j(localObject1, "scrollView");
      paramInt = ((ScrollView)localObject1).getHeight();
      ((InputPanelLinearLayout)_$_findCachedViewById(b.e.EaJ)).requestLayout();
      ((InputPanelLinearLayout)_$_findCachedViewById(b.e.EaJ)).post((Runnable)new l(this, paramInt));
      AppMethodBeat.o(251525);
      return;
    }
    eKX();
    AppMethodBeat.o(251525);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(251518);
    setMMTitle("");
    hideActionbarLine();
    Object localObject1 = (KidsWatchHeadComponent)_$_findCachedViewById(b.e.EaG);
    Object localObject2 = getString(b.h.Eby);
    p.j(localObject2, "getString(R.string.kids_…ogin_enter_loading_title)");
    ((KidsWatchHeadComponent)localObject1).setTitle((String)localObject2);
    ((KidsWatchHeadComponent)_$_findCachedViewById(b.e.EaG)).eKU();
    ((KidsWatchHeadComponent)_$_findCachedViewById(b.e.EaG)).setCloseBtnCallBack((kotlin.g.a.a)new c(this));
    ((InputPanelLinearLayout)_$_findCachedViewById(b.e.EaJ)).setExternalListener((com.tencent.mm.ui.widget.c.a)this);
    ((RelativeLayout)_$_findCachedViewById(b.e.Eaz)).setOnClickListener((View.OnClickListener)new d(this));
    localObject1 = (ImageView)_$_findCachedViewById(b.e.Eat);
    p.j(localObject1, "addAvatarIV");
    ((ImageView)localObject1).setVisibility(0);
    localObject1 = (RoundCornerImageView)_$_findCachedViewById(b.e.dsd);
    p.j(localObject1, "avatarIV");
    ((RoundCornerImageView)localObject1).setVisibility(8);
    ((RoundCornerImageView)_$_findCachedViewById(b.e.dsd)).mQ(com.tencent.mm.ci.a.fromDPToPix((Context)getContext(), 22), com.tencent.mm.ci.a.fromDPToPix((Context)getContext(), 22));
    ((MMClearEditText)_$_findCachedViewById(b.e.EaX)).addTextChangedListener((TextWatcher)new e(this));
    ((MMClearEditText)_$_findCachedViewById(b.e.EaV)).addTextChangedListener((TextWatcher)new f(this));
    com.tencent.mm.kernel.h.aHJ().postAtFrontOfWorker((MMHandlerThread.IWaitWorkThread)new g(this));
    Util.expandViewTouchArea((CheckBox)_$_findCachedViewById(b.e.EaN), 250, 250, 250, 250);
    localObject1 = (Button)_$_findCachedViewById(b.e.Ebb);
    p.j(localObject1, "regBtn");
    ((Button)localObject1).setEnabled(false);
    ((CheckBox)_$_findCachedViewById(b.e.EaN)).setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)new h(this));
    localObject1 = getString(b.h.EbF);
    p.j(localObject1, "getString(R.string.kids_…eg_intro_get_info_cb_tip)");
    localObject2 = getString(b.h.EbG);
    p.j(localObject2, "getString(R.string.kids_…tro_get_info_cb_tip_link)");
    int i = n.g((CharSequence)localObject1, (String)localObject2);
    if (i < 0)
    {
      AppMethodBeat.o(251518);
      return;
    }
    int j = ((String)localObject2).length();
    localObject1 = new SpannableStringBuilder((CharSequence)localObject1);
    ((SpannableStringBuilder)localObject1).setSpan(new i(this), i, j + i, 18);
    ((TextView)_$_findCachedViewById(b.e.EaO)).setOnTouchListener((View.OnTouchListener)new o((Context)this));
    localObject2 = (TextView)_$_findCachedViewById(b.e.EaO);
    p.j(localObject2, "lawDetailTV");
    ((TextView)localObject2).setClickable(true);
    localObject2 = (TextView)_$_findCachedViewById(b.e.EaO);
    p.j(localObject2, "lawDetailTV");
    ((TextView)localObject2).setText((CharSequence)localObject1);
    localObject1 = getIntent().getStringExtra("intent.key.login.url");
    p.j(localObject1, "intent.getStringExtra(Co…tch.INTENT_KEY_LOGIN_URL)");
    this.fTQ = ((String)localObject1);
    ((Button)_$_findCachedViewById(b.e.Ebb)).setOnClickListener((View.OnClickListener)new j(this));
    localObject1 = com.tencent.mm.plugin.kidswatch.b.a.Edb;
    localObject1 = getContext();
    p.j(localObject1, "context");
    com.tencent.mm.plugin.kidswatch.b.a.a((Context)localObject1, (LinearLayout)_$_findCachedViewById(b.e.Eax), (LinearLayout)_$_findCachedViewById(b.e.Eav));
    AppMethodBeat.o(251518);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(251521);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Log.i("MicroMsg.KidsWatchRegGetInfoUI", "onActivityResult, requestCode:" + paramInt1 + ", resultCode: " + paramInt2);
    if (paramInt1 == 30846)
    {
      if (paramInt2 == -1)
      {
        if (paramIntent != null) {
          localObject1 = paramIntent.getBundleExtra("result_data");
        }
        if ((localObject1 != null) && (p.h(((Bundle)localObject1).getString("go_next", ""), "get_reg_verify_code")))
        {
          eKW();
          AppMethodBeat.o(251521);
        }
      }
    }
    else if (paramInt1 == 30847)
    {
      localObject1 = localObject2;
      if (paramIntent != null) {
        localObject1 = paramIntent.getBundleExtra("result_data");
      }
      if ((localObject1 != null) && (p.h(((Bundle)localObject1).getString("go_next", ""), "agree_privacy")))
      {
        this.nhV = false;
        abb(this.nhJ + this.nfH);
        AppMethodBeat.o(251521);
      }
    }
    else
    {
      this.nhP = com.tencent.mm.plugin.account.sdk.a.mIH.b((Activity)this, paramInt1, paramInt2, paramIntent);
      if (this.nhP != null)
      {
        ((RoundCornerImageView)_$_findCachedViewById(b.e.dsd)).setImageBitmap(this.nhP);
        this.nhv = true;
        paramIntent = (RoundCornerImageView)_$_findCachedViewById(b.e.dsd);
        p.j(paramIntent, "avatarIV");
        paramIntent.setVisibility(0);
        paramIntent = (ImageView)_$_findCachedViewById(b.e.Eat);
        p.j(paramIntent, "addAvatarIV");
        paramIntent.setVisibility(8);
      }
    }
    AppMethodBeat.o(251521);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(251512);
    super.onCreate(paramBundle);
    paramBundle = getSupportActionBar();
    if (paramBundle == null) {
      p.iCn();
    }
    paramBundle.hide();
    setSelfNavigationBarVisible(8);
    paramBundle = getContext();
    p.j(paramBundle, "context");
    setActionbarColor(paramBundle.getResources().getColor(com.tencent.mm.plugin.kidswatch.b.b.Eap));
    paramBundle = getContext();
    p.j(paramBundle, "context");
    setNavigationbarColor(paramBundle.getResources().getColor(com.tencent.mm.plugin.kidswatch.b.b.Eap));
    initView();
    overridePendingTransition(b.a.push_up_in, b.a.anim_not_change);
    AppMethodBeat.o(251512);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(251514);
    super.onPause();
    ((InputPanelLinearLayout)_$_findCachedViewById(b.e.EaJ)).setExternalListener(null);
    AppMethodBeat.o(251514);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int i = 1;
    AppMethodBeat.i(251516);
    p.k(paramArrayOfString, "permissions");
    p.k(paramArrayOfInt, "grantResults");
    if (paramInt == 34)
    {
      if (paramArrayOfInt.length == 0)
      {
        paramInt = 1;
        if (paramInt != 0) {
          break label86;
        }
      }
      label86:
      for (paramInt = i;; paramInt = 0)
      {
        if ((paramInt == 0) || (paramArrayOfInt[0] != 0)) {
          break label106;
        }
        Log.i("MicroMsg.KidsWatchRegGetInfoUI", "PERMISSION_GRANTED");
        com.tencent.mm.plugin.account.sdk.a.mIH.r((Activity)this);
        AppMethodBeat.o(251516);
        return;
        paramInt = 0;
        break;
      }
    }
    this.nex.a((Activity)this, paramInt, paramArrayOfString, paramArrayOfInt);
    label106:
    AppMethodBeat.o(251516);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(251513);
    super.onResume();
    ((InputPanelLinearLayout)_$_findCachedViewById(b.e.EaJ)).setExternalListener((com.tencent.mm.ui.widget.c.a)this);
    eKX();
    AppMethodBeat.o(251513);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(251524);
    s locals = this.mUN;
    if (locals != null) {
      locals.dismiss();
    }
    if (paramInt2 == -75)
    {
      com.tencent.mm.ui.base.h.p((Context)this, r.j.alpha_version_tip_reg, r.j.reg_username_exist_title);
      AppMethodBeat.o(251524);
      return;
    }
    if ((paramq instanceof com.tencent.mm.modelfriend.a))
    {
      Log.i("MicroMsg.KidsWatchRegGetInfoUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
      com.tencent.mm.kernel.h.aGY().b(145, (com.tencent.mm.an.i)this);
      int i = ((com.tencent.mm.modelfriend.a)paramq).ZB();
      this.nfm = ((com.tencent.mm.modelfriend.a)paramq).blk();
      if (i == 22)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          eKW();
          AppMethodBeat.o(251524);
          return;
        }
        if ((paramInt2 == -41) || (paramInt2 == -59))
        {
          paramString = com.tencent.mm.h.a.Kb(paramString);
          if (paramString != null)
          {
            paramString.a((Context)this, null, null);
            AppMethodBeat.o(251524);
            return;
          }
          com.tencent.mm.ui.base.h.p((Context)this, b.h.regbymobile_reg_mobile_format_err_msg, b.h.regbymobile_reg_mobile_format_err_title);
          AppMethodBeat.o(251524);
          return;
        }
        this.nfH = PhoneFormater.pureNumber(this.nfH);
        this.nff = (this.nhJ + this.nfH);
        this.nfm = ((com.tencent.mm.modelfriend.a)paramq).blk();
        if ((paramInt2 == -36) || (paramInt2 == -35) || (paramInt2 == -3))
        {
          paramq = ((com.tencent.mm.modelfriend.a)paramq).bkY();
          if (!Util.isNullOrNil(paramq))
          {
            p.j(paramq, "pureMobile");
            paramq = (CharSequence)paramq;
            i = paramq.length() - 1;
            int k = 0;
            int j = 0;
            while (j <= i)
            {
              int m;
              if (k == 0)
              {
                m = j;
                label355:
                if (paramq.charAt(m) > ' ') {
                  break label395;
                }
                m = 1;
              }
              for (;;)
              {
                if (k == 0)
                {
                  if (m == 0)
                  {
                    k = 1;
                    break;
                    m = i;
                    break label355;
                    label395:
                    m = 0;
                    continue;
                  }
                  j += 1;
                  break;
                }
              }
              if (m == 0) {
                break;
              }
              i -= 1;
            }
            this.nfH = paramq.subSequence(j, i + 1).toString();
          }
          if (paramInt2 == -36)
          {
            eKW();
            AppMethodBeat.o(251524);
            return;
          }
          paramString = com.tencent.mm.h.a.Kb(paramString);
          if (paramString != null)
          {
            paramString.a((Context)getContext(), null, null);
            AppMethodBeat.o(251524);
            return;
          }
          com.tencent.mm.ui.base.h.af((Context)this, getString(b.h.bind_mcontact_verify_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), "");
          AppMethodBeat.o(251524);
          return;
        }
        if (paramInt2 == -355)
        {
          Log.i("MicroMsg.KidsWatchRegGetInfoUI", "showBlockBySpam");
          y.f((Context)this, paramString, 30846);
          AppMethodBeat.o(251524);
          return;
        }
        if (paramInt2 == -34)
        {
          com.tencent.mm.ui.base.h.af((Context)this, getString(b.h.bind_mcontact_err_freq_limit), "");
          AppMethodBeat.o(251524);
          return;
        }
        if (com.tencent.mm.plugin.account.sdk.a.mIH.a((Context)this, paramInt1, paramInt2, paramString))
        {
          AppMethodBeat.o(251524);
          return;
        }
      }
    }
    AppMethodBeat.o(251524);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(KidsWatchRegGetInfoUI paramKidsWatchRegGetInfoUI, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(251587);
      KidsWatchRegGetInfoUI.a(this.EcK, paramString);
      AppMethodBeat.o(251587);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<kotlin.x>
  {
    c(KidsWatchRegGetInfoUI paramKidsWatchRegGetInfoUI)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(KidsWatchRegGetInfoUI paramKidsWatchRegGetInfoUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(251461);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegGetInfoUI$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      KidsWatchRegGetInfoUI.a(this.EcK);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegGetInfoUI$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(251461);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegGetInfoUI$initView$3", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-kidswatch_release"})
  public static final class e
    implements TextWatcher
  {
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(252261);
      p.k(paramEditable, "s");
      Button localButton = (Button)this.EcK._$_findCachedViewById(b.e.Ebb);
      p.j(localButton, "regBtn");
      if (!Util.isNullOrNil(paramEditable.toString()))
      {
        paramEditable = (MMClearEditText)this.EcK._$_findCachedViewById(b.e.EaV);
        p.j(paramEditable, "mobileFIV");
        if (!Util.isNullOrNil((CharSequence)paramEditable.getText()))
        {
          paramEditable = (CheckBox)this.EcK._$_findCachedViewById(b.e.EaN);
          p.j(paramEditable, "lawDetailCB");
          if (!paramEditable.isChecked()) {}
        }
      }
      for (boolean bool = true;; bool = false)
      {
        localButton.setEnabled(bool);
        AppMethodBeat.o(252261);
        return;
      }
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(252258);
      p.k(paramCharSequence, "s");
      AppMethodBeat.o(252258);
    }
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(252260);
      p.k(paramCharSequence, "s");
      AppMethodBeat.o(252260);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegGetInfoUI$initView$4", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-kidswatch_release"})
  public static final class f
    implements TextWatcher
  {
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(252057);
      p.k(paramEditable, "s");
      Button localButton = (Button)this.EcK._$_findCachedViewById(b.e.Ebb);
      p.j(localButton, "regBtn");
      if (!Util.isNullOrNil(paramEditable.toString()))
      {
        paramEditable = (MMClearEditText)this.EcK._$_findCachedViewById(b.e.EaX);
        p.j(paramEditable, "nickFIV");
        if (!Util.isNullOrNil((CharSequence)paramEditable.getText()))
        {
          paramEditable = (CheckBox)this.EcK._$_findCachedViewById(b.e.EaN);
          p.j(paramEditable, "lawDetailCB");
          if (!paramEditable.isChecked()) {}
        }
      }
      for (boolean bool = true;; bool = false)
      {
        localButton.setEnabled(bool);
        AppMethodBeat.o(252057);
        return;
      }
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(252054);
      p.k(paramCharSequence, "s");
      AppMethodBeat.o(252054);
    }
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(252056);
      p.k(paramCharSequence, "s");
      AppMethodBeat.o(252056);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegGetInfoUI$initView$5", "Lcom/tencent/mm/sdk/platformtools/MMHandlerThread$IWaitWorkThread;", "nickname", "", "getNickname", "()Ljava/lang/String;", "setNickname", "(Ljava/lang/String;)V", "doInBackground", "", "onPostExecute", "toString", "plugin-kidswatch_release"})
  public static final class g
    implements MMHandlerThread.IWaitWorkThread
  {
    private String nickname;
    
    public final boolean doInBackground()
    {
      return true;
    }
    
    public final boolean onPostExecute()
    {
      AppMethodBeat.i(251434);
      Object localObject;
      if (!Util.isNullOrNil(this.nickname))
      {
        localObject = new StringBuilder();
        MMClearEditText localMMClearEditText = (MMClearEditText)this.EcK._$_findCachedViewById(b.e.EaX);
        p.j(localMMClearEditText, "nickFIV");
        localObject = (CharSequence)localMMClearEditText.getText();
        int i = ((CharSequence)localObject).length() - 1;
        int k = 0;
        int j = 0;
        while (j <= i)
        {
          int m;
          if (k == 0)
          {
            m = j;
            label90:
            if (((CharSequence)localObject).charAt(m) > ' ') {
              break label127;
            }
            m = 1;
          }
          for (;;)
          {
            if (k == 0)
            {
              if (m == 0)
              {
                k = 1;
                break;
                m = i;
                break label90;
                label127:
                m = 0;
                continue;
              }
              j += 1;
              break;
            }
          }
          if (m == 0) {
            break;
          }
          i -= 1;
        }
        if (Util.isNullOrNil(((CharSequence)localObject).subSequence(j, i + 1).toString())) {
          ((MMClearEditText)this.EcK._$_findCachedViewById(b.e.EaX)).setText((CharSequence)this.nickname);
        }
      }
      if (!e.avA())
      {
        Log.e("MicroMsg.KidsWatchRegGetInfoUI", "SDcard is not available");
        AppMethodBeat.o(251434);
        return false;
      }
      if (KidsWatchRegGetInfoUI.b(this.EcK) != null)
      {
        localObject = KidsWatchRegGetInfoUI.b(this.EcK);
        if (localObject == null) {
          p.iCn();
        }
        if ((!((Bitmap)localObject).isRecycled()) && (!KidsWatchRegGetInfoUI.c(this.EcK)))
        {
          ((RoundCornerImageView)this.EcK._$_findCachedViewById(b.e.dsd)).setImageBitmap(KidsWatchRegGetInfoUI.b(this.EcK));
          localObject = (RoundCornerImageView)this.EcK._$_findCachedViewById(b.e.dsd);
          p.j(localObject, "avatarIV");
          ((RoundCornerImageView)localObject).setVisibility(0);
          localObject = (ImageView)this.EcK._$_findCachedViewById(b.e.Eat);
          p.j(localObject, "addAvatarIV");
          ((ImageView)localObject).setVisibility(8);
          KidsWatchRegGetInfoUI.d(this.EcK);
        }
      }
      AppMethodBeat.o(251434);
      return true;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(251437);
      String str = super.toString() + "|initView2";
      AppMethodBeat.o(251437);
      return str;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "isChecked", "", "onCheckedChanged"})
  static final class h
    implements CompoundButton.OnCheckedChangeListener
  {
    h(KidsWatchRegGetInfoUI paramKidsWatchRegGetInfoUI) {}
    
    public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      AppMethodBeat.i(251817);
      paramCompoundButton = (MMClearEditText)this.EcK._$_findCachedViewById(b.e.EaX);
      p.j(paramCompoundButton, "nickFIV");
      if (!Util.isNullOrNil(paramCompoundButton.getText().toString()))
      {
        paramCompoundButton = (MMClearEditText)this.EcK._$_findCachedViewById(b.e.EaV);
        p.j(paramCompoundButton, "mobileFIV");
        if ((!Util.isNullOrNil(paramCompoundButton.getText().toString())) && (paramBoolean))
        {
          paramCompoundButton = (Button)this.EcK._$_findCachedViewById(b.e.Ebb);
          p.j(paramCompoundButton, "regBtn");
          paramCompoundButton.setEnabled(paramBoolean);
        }
      }
      if (!paramBoolean)
      {
        paramCompoundButton = (Button)this.EcK._$_findCachedViewById(b.e.Ebb);
        p.j(paramCompoundButton, "regBtn");
        paramCompoundButton.setEnabled(paramBoolean);
      }
      AppMethodBeat.o(251817);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegGetInfoUI$initView$7", "Lcom/tencent/mm/plugin/kidswatch/model/KidsWatchAvoidDuplicatedPressableSpan;", "onClickImp", "", "widget", "Landroid/view/View;", "plugin-kidswatch_release"})
  public static final class i
    extends com.tencent.mm.plugin.kidswatch.model.a
  {
    public final void eKQ()
    {
      AppMethodBeat.i(251589);
      KidsWatchRegGetInfoUI.e(this.EcK);
      AppMethodBeat.o(251589);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(KidsWatchRegGetInfoUI paramKidsWatchRegGetInfoUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(251570);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegGetInfoUI$initView$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      Log.i("MicroMsg.KidsWatchRegGetInfoUI", "click reg button");
      paramView = this.EcK;
      localObject = (Context)this.EcK;
      this.EcK.getString(b.h.app_tip);
      KidsWatchRegGetInfoUI.a(paramView, com.tencent.mm.ui.base.h.a((Context)localObject, this.EcK.getString(b.h.app_waiting), true, null));
      c.i((MMClearEditText)this.EcK._$_findCachedViewById(b.e.EaX)).mM(1, 32).Hh(true).a((com.tencent.mm.ui.tools.b.c.a)new com.tencent.mm.ui.tools.b.c.a()
      {
        public final void abc(String paramAnonymousString)
        {
          AppMethodBeat.i(252275);
          p.k(paramAnonymousString, "text");
          paramAnonymousString = this.EcM.EcK;
          MMClearEditText localMMClearEditText = (MMClearEditText)this.EcM.EcK._$_findCachedViewById(b.e.EaV);
          p.j(localMMClearEditText, "mobileFIV");
          KidsWatchRegGetInfoUI.b(paramAnonymousString, PhoneFormater.pureNumber(localMMClearEditText.getText().toString()));
          paramAnonymousString = KidsWatchRegGetInfoUI.h(this.EcM.EcK) + KidsWatchRegGetInfoUI.g(this.EcM.EcK);
          this.EcM.EcK.hideVKB();
          if (KidsWatchRegGetInfoUI.i(this.EcM.EcK))
          {
            paramAnonymousString = KidsWatchRegGetInfoUI.f(this.EcM.EcK);
            if (paramAnonymousString != null) {
              paramAnonymousString.dismiss();
            }
            paramAnonymousString = this.EcM.EcK.getString(b.h.license_read_url, new Object[] { LocaleUtil.getApplicationLanguage(), "CN", "kidswatchreg", Integer.valueOf(1), Integer.valueOf(0) });
            p.j(paramAnonymousString, "getString(R.string.licen…N\", \"kidswatchreg\", 1, 0)");
            com.tencent.mm.plugin.account.sdk.b.a.b((Context)this.EcM.EcK.getContext(), paramAnonymousString, 30847, false);
            AppMethodBeat.o(252275);
            return;
          }
          KidsWatchRegGetInfoUI.c(this.EcM.EcK, paramAnonymousString);
          AppMethodBeat.o(252275);
        }
        
        public final void abd(String paramAnonymousString)
        {
          AppMethodBeat.i(252276);
          p.k(paramAnonymousString, "text");
          paramAnonymousString = KidsWatchRegGetInfoUI.f(this.EcM.EcK);
          if (paramAnonymousString != null) {
            paramAnonymousString.dismiss();
          }
          com.tencent.mm.ui.base.h.p((Context)this.EcM.EcK.getContext(), b.h.settings_modify_name_invalid_less, b.h.settings_modify_name_title);
          AppMethodBeat.o(252276);
        }
        
        public final void dN(String paramAnonymousString)
        {
          AppMethodBeat.i(252278);
          p.k(paramAnonymousString, "text");
          paramAnonymousString = KidsWatchRegGetInfoUI.f(this.EcM.EcK);
          if (paramAnonymousString != null) {
            paramAnonymousString.dismiss();
          }
          com.tencent.mm.ui.base.h.p((Context)this.EcM.EcK.getContext(), b.h.settings_modify_name_invalid_more, b.h.settings_modify_name_title);
          AppMethodBeat.o(252278);
        }
      });
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegGetInfoUI$initView$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(251570);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class k
    implements Runnable
  {
    k(KidsWatchRegGetInfoUI paramKidsWatchRegGetInfoUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(252236);
      s locals = KidsWatchRegGetInfoUI.f(this.EcK);
      if (locals != null)
      {
        locals.dismiss();
        AppMethodBeat.o(252236);
        return;
      }
      AppMethodBeat.o(252236);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class l
    implements Runnable
  {
    l(KidsWatchRegGetInfoUI paramKidsWatchRegGetInfoUI, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(252187);
      Object localObject = (InputPanelLinearLayout)this.EcK._$_findCachedViewById(b.e.EaJ);
      p.j(localObject, "inputContainer");
      Log.i("MicroMsg.KidsWatchRegGetInfoUI", "inputContainer.height: %d, screenHeight: %d", new Object[] { Integer.valueOf(((InputPanelLinearLayout)localObject).getHeight()), Integer.valueOf(paramInt) });
      localObject = (InputPanelLinearLayout)this.EcK._$_findCachedViewById(b.e.EaJ);
      p.j(localObject, "inputContainer");
      if (((InputPanelLinearLayout)localObject).getHeight() > paramInt)
      {
        localObject = (ScrollView)this.EcK._$_findCachedViewById(b.e.scrollView);
        InputPanelLinearLayout localInputPanelLinearLayout = (InputPanelLinearLayout)this.EcK._$_findCachedViewById(b.e.EaJ);
        p.j(localInputPanelLinearLayout, "inputContainer");
        ((ScrollView)localObject).scrollBy(0, localInputPanelLinearLayout.getHeight() - paramInt);
      }
      AppMethodBeat.o(252187);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class m
    implements Runnable
  {
    m(KidsWatchRegGetInfoUI paramKidsWatchRegGetInfoUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(252089);
      s locals = KidsWatchRegGetInfoUI.f(this.EcK);
      if (locals != null)
      {
        locals.dismiss();
        AppMethodBeat.o(252089);
        return;
      }
      AppMethodBeat.o(252089);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.ui.reg.KidsWatchRegGetInfoUI
 * JD-Core Version:    0.7.0.1
 */