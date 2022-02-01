package com.tencent.mm.plugin.kidswatch.ui.reg;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.an.f;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.plugin.kidswatch.model.b.b;
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
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.tools.b.c.a;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.RoundCornerImageView;
import com.tencent.mm.ui.widget.b.a;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.n.n;

@com.tencent.mm.ui.base.a(35)
@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegGetInfoUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/ui/widget/InputPanelHelper$OnInputPanelChange;", "Lcom/tencent/mm/plugin/kidswatch/model/KidsWatchHeadImageUploader$IImgUploadCallback;", "()V", "adjustedMobile", "", "avatarBitmap", "Landroid/graphics/Bitmap;", "hasSetAvatar", "", "inputMobileRetrys", "", "lastInputMobile", "loginUrl", "mMobile", "needShowAgreements", "permissionCheckHelper", "Lcom/tencent/mm/platformtools/PermissionCheckHelper;", "plusCountryCode", "proDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "regSessionId", "changeAvatar", "", "checkMobileState", "mNumber", "checkMobileStateFun", "finish", "getForceOrientation", "getLayoutId", "gotoLawLink", "gotoMobileVerifyCodePage", "fileId", "aesKey", "initView", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onError", "errType", "errCode", "errMsg", "onInputPanelChange", "isKeyboardShow", "keyboardHeight", "onKeyBoardHidden", "onPause", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onSceneEnd", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSuccess", "fileID", "uploadHeadImg", "Companion", "plugin-kidswatch_release"})
public final class KidsWatchRegGetInfoUI
  extends MMActivity
  implements i, b.b, b.a
{
  public static final KidsWatchRegGetInfoUI.a yBt;
  private HashMap _$_findViewCache;
  private String dZW;
  private com.tencent.mm.ui.base.q kdn;
  private final com.tencent.mm.platformtools.x kmF;
  private String knP;
  private String knm;
  private String knn;
  private int kno;
  private String knu;
  private boolean kpI;
  private final String kpW;
  private Bitmap kqc;
  private boolean kqi;
  
  static
  {
    AppMethodBeat.i(256319);
    yBt = new KidsWatchRegGetInfoUI.a((byte)0);
    AppMethodBeat.o(256319);
  }
  
  public KidsWatchRegGetInfoUI()
  {
    AppMethodBeat.i(256318);
    this.kpW = "+86";
    this.kqi = true;
    this.kmF = new com.tencent.mm.platformtools.x();
    AppMethodBeat.o(256318);
  }
  
  private final void Tv(final String paramString)
  {
    AppMethodBeat.i(256308);
    this.kmF.b((Activity)this, (Runnable)new b(this, paramString));
    AppMethodBeat.o(256308);
  }
  
  private final void ebY()
  {
    AppMethodBeat.i(256310);
    if (!this.kpI)
    {
      Log.i("MicroMsg.KidsWatchRegGetInfoUI", "uploadHeadImg, gotoMobileVerifyCodePage, " + this.kpI);
      ir("", "");
      AppMethodBeat.o(256310);
      return;
    }
    com.tencent.mm.plugin.kidswatch.model.b localb = new com.tencent.mm.plugin.kidswatch.model.b(com.tencent.mm.loader.j.b.aKR() + "temp.avatar", (b.b)this);
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.taskName = "task_KidsWatchHeadImageUpload";
    localg.gqy = localb.iZc;
    localg.field_mediaId = localb.mediaId;
    localg.field_fullpath = localb.dRr;
    localg.field_thumbpath = "";
    localg.field_fileType = com.tencent.mm.plugin.kidswatch.model.b.jSm;
    localg.field_talker = "";
    localg.field_priority = com.tencent.mm.i.a.gpM;
    localg.field_needStorage = false;
    localg.field_isStreamMedia = false;
    localg.field_appType = 1;
    localg.field_bzScene = 0;
    localg.fuQ = 5;
    localg.field_trysafecdn = true;
    localg.field_enable_hitcheck = false;
    if (!f.baQ().f(localg)) {
      Log.e("MicroMsg.KidsWatch.KidsWatchHeadImageUploader", "cdntra addSendTask failed. mediaId:%s", new Object[] { localb.mediaId });
    }
    AppMethodBeat.o(256310);
  }
  
  private final void ebZ()
  {
    AppMethodBeat.i(256315);
    Object localObject1 = (LinearLayout)_$_findCachedViewById(2131302617);
    p.g(localObject1, "imgLL");
    ((LinearLayout)localObject1).setVisibility(0);
    localObject1 = (LinearLayout)_$_findCachedViewById(2131297654);
    p.g(localObject1, "bottomLL");
    localObject1 = ((LinearLayout)localObject1).getLayoutParams();
    if (localObject1 == null)
    {
      localObject1 = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(256315);
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
    int i = ((InputPanelLinearLayout)localObject2).getPaddingLeft();
    localObject2 = (InputPanelLinearLayout)_$_findCachedViewById(2131302669);
    p.g(localObject2, "inputContainer");
    int j = ((InputPanelLinearLayout)localObject2).getPaddingTop();
    localObject2 = (InputPanelLinearLayout)_$_findCachedViewById(2131302669);
    p.g(localObject2, "inputContainer");
    ((InputPanelLinearLayout)localObject1).setPadding(i, j, ((InputPanelLinearLayout)localObject2).getPaddingRight(), 0);
    ((ScrollView)_$_findCachedViewById(2131307332)).scrollBy(0, 0);
    AppMethodBeat.o(256315);
  }
  
  private final void ir(String paramString1, String paramString2)
  {
    AppMethodBeat.i(256311);
    Intent localIntent = new Intent((Context)this, KidsWatchRegMobileVerifyUI.class);
    Object localObject = this.dZW;
    if (localObject == null) {
      p.btv("loginUrl");
    }
    localIntent.putExtra("intent.key.login.url", (String)localObject);
    localObject = (MMClearEditText)_$_findCachedViewById(2131305428);
    p.g(localObject, "nickFIV");
    localIntent.putExtra("intent.key.reg.nickname", ((MMClearEditText)localObject).getText().toString());
    localObject = (MMClearEditText)_$_findCachedViewById(2131304740);
    p.g(localObject, "mobileFIV");
    localIntent.putExtra("intent.key.reg.mobile", ((MMClearEditText)localObject).getText().toString());
    localIntent.putExtra("intent.key.reg.session.id", this.knu);
    localIntent.putExtra("intent.key.hasSetAvatar", this.kpI);
    localIntent.putExtra("intent.key.reg.head_img.file.id", paramString1);
    localIntent.putExtra("intent.key.reg.head_img.aes.key", paramString2);
    Log.i("MicroMsg.KidsWatchRegGetInfoUI", "get info page:(fileId:" + paramString1 + ") , (aesKey:" + paramString2 + ')');
    paramString1 = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(this, paramString1.axQ(), "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegGetInfoUI", "gotoMobileVerifyCodePage", "(Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramString1.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegGetInfoUI", "gotoMobileVerifyCodePage", "(Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(256311);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(256325);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(256325);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(256324);
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
    AppMethodBeat.o(256324);
    return localView1;
  }
  
  public final void aCF(String paramString)
  {
    AppMethodBeat.i(256317);
    Log.e("MicroMsg.KidsWatchRegGetInfoUI", "upload head fail, errType:%s, errCode:%s, errMsg:%s", new Object[] { Integer.valueOf(3), Integer.valueOf(-1), paramString });
    ir("", "");
    AppMethodBeat.o(256317);
  }
  
  public final void ds(String paramString1, String paramString2)
  {
    AppMethodBeat.i(256316);
    p.h(paramString1, "fileID");
    p.h(paramString2, "aesKey");
    Log.i("MicroMsg.KidsWatchRegGetInfoUI", "IImgUploadCallback, ok, fileId:" + paramString1 + ", aesKey:" + paramString2);
    ir(paramString1, paramString2);
    AppMethodBeat.o(256316);
  }
  
  public final void f(boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(256314);
    Log.i("MicroMsg.KidsWatchRegGetInfoUI", "keyboard show %s, keyboardHeight %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (paramBoolean)
    {
      Object localObject1 = (LinearLayout)_$_findCachedViewById(2131302617);
      p.g(localObject1, "imgLL");
      ((LinearLayout)localObject1).setVisibility(8);
      localObject1 = (LinearLayout)_$_findCachedViewById(2131297654);
      p.g(localObject1, "bottomLL");
      localObject1 = ((LinearLayout)localObject1).getLayoutParams();
      if (localObject1 == null)
      {
        localObject1 = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(256314);
        throw ((Throwable)localObject1);
      }
      localObject1 = (ViewGroup.MarginLayoutParams)localObject1;
      ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin = getResources().getDimensionPixelSize(2131165299);
      ((ViewGroup.MarginLayoutParams)localObject1).topMargin = getResources().getDimensionPixelSize(2131165303);
      Object localObject2 = (LinearLayout)_$_findCachedViewById(2131297654);
      p.g(localObject2, "bottomLL");
      ((LinearLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = (InputPanelLinearLayout)_$_findCachedViewById(2131302669);
      localObject2 = (InputPanelLinearLayout)_$_findCachedViewById(2131302669);
      p.g(localObject2, "inputContainer");
      int i = ((InputPanelLinearLayout)localObject2).getPaddingLeft();
      localObject2 = (InputPanelLinearLayout)_$_findCachedViewById(2131302669);
      p.g(localObject2, "inputContainer");
      int j = ((InputPanelLinearLayout)localObject2).getPaddingTop();
      localObject2 = (InputPanelLinearLayout)_$_findCachedViewById(2131302669);
      p.g(localObject2, "inputContainer");
      ((InputPanelLinearLayout)localObject1).setPadding(i, j, ((InputPanelLinearLayout)localObject2).getPaddingRight(), paramInt);
      localObject1 = (ScrollView)_$_findCachedViewById(2131307332);
      p.g(localObject1, "scrollView");
      paramInt = ((ScrollView)localObject1).getHeight();
      ((InputPanelLinearLayout)_$_findCachedViewById(2131302669)).requestLayout();
      ((InputPanelLinearLayout)_$_findCachedViewById(2131302669)).post((Runnable)new k(this, paramInt));
      AppMethodBeat.o(256314);
      return;
    }
    ebZ();
    AppMethodBeat.o(256314);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(256306);
    super.finish();
    overridePendingTransition(2130771986, 2130772130);
    AppMethodBeat.o(256306);
  }
  
  public final int getForceOrientation()
  {
    return 1;
  }
  
  public final int getLayoutId()
  {
    return 2131495136;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(256309);
    setMMTitle("");
    hideActionbarLine();
    Object localObject1 = (KidsWatchHeadComponent)_$_findCachedViewById(2131302263);
    Object localObject2 = getString(2131762070);
    p.g(localObject2, "getString(R.string.kids_…ogin_enter_loading_title)");
    ((KidsWatchHeadComponent)localObject1).setTitle((String)localObject2);
    ((KidsWatchHeadComponent)_$_findCachedViewById(2131302263)).ebW();
    ((KidsWatchHeadComponent)_$_findCachedViewById(2131302263)).setCloseBtnCallBack((kotlin.g.a.a)new c(this));
    ((InputPanelLinearLayout)_$_findCachedViewById(2131302669)).setExternalListener((b.a)this);
    ((RelativeLayout)_$_findCachedViewById(2131298652)).setOnClickListener((View.OnClickListener)new d(this));
    localObject1 = (ImageView)_$_findCachedViewById(2131296520);
    p.g(localObject1, "addAvatarIV");
    ((ImageView)localObject1).setVisibility(0);
    localObject1 = (RoundCornerImageView)_$_findCachedViewById(2131297120);
    p.g(localObject1, "avatarIV");
    ((RoundCornerImageView)localObject1).setVisibility(8);
    ((RoundCornerImageView)_$_findCachedViewById(2131297120)).ly(com.tencent.mm.cb.a.fromDPToPix((Context)getContext(), 22), com.tencent.mm.cb.a.fromDPToPix((Context)getContext(), 22));
    ((MMClearEditText)_$_findCachedViewById(2131305428)).addTextChangedListener((TextWatcher)new e(this));
    ((MMClearEditText)_$_findCachedViewById(2131304740)).addTextChangedListener((TextWatcher)new f(this));
    com.tencent.mm.kernel.g.aAk().postAtFrontOfWorker((MMHandlerThread.IWaitWorkThread)new g(this));
    Util.expandViewTouchArea((CheckBox)_$_findCachedViewById(2131303054), 250, 250, 250, 250);
    localObject1 = (Button)_$_findCachedViewById(2131306784);
    p.g(localObject1, "regBtn");
    ((Button)localObject1).setEnabled(false);
    ((CheckBox)_$_findCachedViewById(2131303054)).setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)new h(this));
    localObject1 = getString(2131762091);
    p.g(localObject1, "getString(R.string.kids_…eg_intro_get_info_cb_tip)");
    localObject2 = getString(2131762092);
    p.g(localObject2, "getString(R.string.kids_…tro_get_info_cb_tip_link)");
    int i = n.g((CharSequence)localObject1, (String)localObject2);
    if (i < 0)
    {
      AppMethodBeat.o(256309);
      return;
    }
    int j = ((String)localObject2).length();
    localObject1 = new SpannableStringBuilder((CharSequence)localObject1);
    ((SpannableStringBuilder)localObject1).setSpan(new i(this), i, j + i, 18);
    ((TextView)_$_findCachedViewById(2131303055)).setOnTouchListener((View.OnTouchListener)new o((Context)this));
    localObject2 = (TextView)_$_findCachedViewById(2131303055);
    p.g(localObject2, "lawDetailTV");
    ((TextView)localObject2).setClickable(true);
    localObject2 = (TextView)_$_findCachedViewById(2131303055);
    p.g(localObject2, "lawDetailTV");
    ((TextView)localObject2).setText((CharSequence)localObject1);
    localObject1 = getIntent().getStringExtra("intent.key.login.url");
    p.g(localObject1, "intent.getStringExtra(Co…tch.INTENT_KEY_LOGIN_URL)");
    this.dZW = ((String)localObject1);
    ((Button)_$_findCachedViewById(2131306784)).setOnClickListener((View.OnClickListener)new j(this));
    localObject1 = com.tencent.mm.plugin.kidswatch.b.a.yBL;
    localObject1 = getContext();
    p.g(localObject1, "context");
    com.tencent.mm.plugin.kidswatch.b.a.a((Context)localObject1, (LinearLayout)_$_findCachedViewById(2131298013), (LinearLayout)_$_findCachedViewById(2131297654));
    AppMethodBeat.o(256309);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(256312);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Log.i("MicroMsg.KidsWatchRegGetInfoUI", "onActivityResult, requestCode:" + paramInt1 + ", resultCode: " + paramInt2);
    if (paramInt1 == 30846)
    {
      if (paramInt2 == -1)
      {
        if (paramIntent != null) {
          localObject1 = paramIntent.getBundleExtra("result_data");
        }
        if ((localObject1 != null) && (p.j(((Bundle)localObject1).getString("go_next", ""), "get_reg_verify_code")))
        {
          ebY();
          AppMethodBeat.o(256312);
        }
      }
    }
    else if (paramInt1 == 30847)
    {
      localObject1 = localObject2;
      if (paramIntent != null) {
        localObject1 = paramIntent.getBundleExtra("result_data");
      }
      if ((localObject1 != null) && (p.j(((Bundle)localObject1).getString("go_next", ""), "agree_privacy")))
      {
        this.kqi = false;
        Tv(this.kpW + this.knP);
        AppMethodBeat.o(256312);
      }
    }
    else
    {
      this.kqc = com.tencent.mm.plugin.account.a.a.jRu.b((Activity)this, paramInt1, paramInt2, paramIntent);
      if (this.kqc != null)
      {
        ((RoundCornerImageView)_$_findCachedViewById(2131297120)).setImageBitmap(this.kqc);
        this.kpI = true;
        paramIntent = (RoundCornerImageView)_$_findCachedViewById(2131297120);
        p.g(paramIntent, "avatarIV");
        paramIntent.setVisibility(0);
        paramIntent = (ImageView)_$_findCachedViewById(2131296520);
        p.g(paramIntent, "addAvatarIV");
        paramIntent.setVisibility(8);
      }
    }
    AppMethodBeat.o(256312);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(256303);
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
    AppMethodBeat.o(256303);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(256305);
    super.onPause();
    ((InputPanelLinearLayout)_$_findCachedViewById(2131302669)).setExternalListener(null);
    AppMethodBeat.o(256305);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int i = 1;
    AppMethodBeat.i(256307);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
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
        com.tencent.mm.plugin.account.a.a.jRu.s((Activity)this);
        AppMethodBeat.o(256307);
        return;
        paramInt = 0;
        break;
      }
    }
    this.kmF.a((Activity)this, paramInt, paramArrayOfString, paramArrayOfInt);
    label106:
    AppMethodBeat.o(256307);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(256304);
    super.onResume();
    ((InputPanelLinearLayout)_$_findCachedViewById(2131302669)).setExternalListener((b.a)this);
    ebZ();
    AppMethodBeat.o(256304);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(256313);
    com.tencent.mm.ui.base.q localq = this.kdn;
    if (localq != null) {
      localq.dismiss();
    }
    if (paramInt2 == -75)
    {
      h.n((Context)this, 2131755301, 2131764341);
      AppMethodBeat.o(256313);
      return;
    }
    if ((paramq instanceof com.tencent.mm.modelfriend.a))
    {
      Log.i("MicroMsg.KidsWatchRegGetInfoUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
      com.tencent.mm.kernel.g.azz().b(145, (i)this);
      int i = ((com.tencent.mm.modelfriend.a)paramq).Vj();
      this.knu = ((com.tencent.mm.modelfriend.a)paramq).bbU();
      if (i == 22)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          ebY();
          AppMethodBeat.o(256313);
          return;
        }
        if ((paramInt2 == -41) || (paramInt2 == -59))
        {
          paramString = com.tencent.mm.h.a.Dk(paramString);
          if (paramString != null)
          {
            paramString.a((Context)this, null, null);
            AppMethodBeat.o(256313);
            return;
          }
          h.n((Context)this, 2131764394, 2131764395);
          AppMethodBeat.o(256313);
          return;
        }
        this.knP = PhoneFormater.pureNumber(this.knP);
        this.knn = (this.kpW + this.knP);
        this.knu = ((com.tencent.mm.modelfriend.a)paramq).bbU();
        if ((paramInt2 == -36) || (paramInt2 == -35) || (paramInt2 == -3))
        {
          paramq = ((com.tencent.mm.modelfriend.a)paramq).bbI();
          if (!Util.isNullOrNil(paramq))
          {
            p.g(paramq, "pureMobile");
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
            this.knP = paramq.subSequence(j, i + 1).toString();
          }
          if (paramInt2 == -36)
          {
            ebY();
            AppMethodBeat.o(256313);
            return;
          }
          paramString = com.tencent.mm.h.a.Dk(paramString);
          if (paramString != null)
          {
            paramString.a((Context)getContext(), null, null);
            AppMethodBeat.o(256313);
            return;
          }
          h.X((Context)this, getString(2131756643, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), "");
          AppMethodBeat.o(256313);
          return;
        }
        if (paramInt2 == -355)
        {
          Log.i("MicroMsg.KidsWatchRegGetInfoUI", "showBlockBySpam");
          y.g((Context)this, paramString, 30846);
          AppMethodBeat.o(256313);
          return;
        }
        if (paramInt2 == -34)
        {
          h.X((Context)this, getString(2131756598), "");
          AppMethodBeat.o(256313);
          return;
        }
        if (com.tencent.mm.plugin.account.a.a.jRu.a((Context)this, paramInt1, paramInt2, paramString))
        {
          AppMethodBeat.o(256313);
          return;
        }
      }
    }
    AppMethodBeat.o(256313);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(KidsWatchRegGetInfoUI paramKidsWatchRegGetInfoUI, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(256285);
      KidsWatchRegGetInfoUI.a(this.yBu, paramString);
      AppMethodBeat.o(256285);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<kotlin.x>
  {
    c(KidsWatchRegGetInfoUI paramKidsWatchRegGetInfoUI)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(KidsWatchRegGetInfoUI paramKidsWatchRegGetInfoUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(256287);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegGetInfoUI$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      KidsWatchRegGetInfoUI.a(this.yBu);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegGetInfoUI$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(256287);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegGetInfoUI$initView$3", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-kidswatch_release"})
  public static final class e
    implements TextWatcher
  {
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(256290);
      p.h(paramEditable, "s");
      Button localButton = (Button)this.yBu._$_findCachedViewById(2131306784);
      p.g(localButton, "regBtn");
      if (!Util.isNullOrNil(paramEditable.toString()))
      {
        paramEditable = (MMClearEditText)this.yBu._$_findCachedViewById(2131304740);
        p.g(paramEditable, "mobileFIV");
        if (!Util.isNullOrNil((CharSequence)paramEditable.getText()))
        {
          paramEditable = (CheckBox)this.yBu._$_findCachedViewById(2131303054);
          p.g(paramEditable, "lawDetailCB");
          if (!paramEditable.isChecked()) {}
        }
      }
      for (boolean bool = true;; bool = false)
      {
        localButton.setEnabled(bool);
        AppMethodBeat.o(256290);
        return;
      }
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(256288);
      p.h(paramCharSequence, "s");
      AppMethodBeat.o(256288);
    }
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(256289);
      p.h(paramCharSequence, "s");
      AppMethodBeat.o(256289);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegGetInfoUI$initView$4", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-kidswatch_release"})
  public static final class f
    implements TextWatcher
  {
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(256293);
      p.h(paramEditable, "s");
      Button localButton = (Button)this.yBu._$_findCachedViewById(2131306784);
      p.g(localButton, "regBtn");
      if (!Util.isNullOrNil(paramEditable.toString()))
      {
        paramEditable = (MMClearEditText)this.yBu._$_findCachedViewById(2131305428);
        p.g(paramEditable, "nickFIV");
        if (!Util.isNullOrNil((CharSequence)paramEditable.getText()))
        {
          paramEditable = (CheckBox)this.yBu._$_findCachedViewById(2131303054);
          p.g(paramEditable, "lawDetailCB");
          if (!paramEditable.isChecked()) {}
        }
      }
      for (boolean bool = true;; bool = false)
      {
        localButton.setEnabled(bool);
        AppMethodBeat.o(256293);
        return;
      }
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(256291);
      p.h(paramCharSequence, "s");
      AppMethodBeat.o(256291);
    }
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(256292);
      p.h(paramCharSequence, "s");
      AppMethodBeat.o(256292);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegGetInfoUI$initView$5", "Lcom/tencent/mm/sdk/platformtools/MMHandlerThread$IWaitWorkThread;", "nickname", "", "getNickname", "()Ljava/lang/String;", "setNickname", "(Ljava/lang/String;)V", "doInBackground", "", "onPostExecute", "toString", "plugin-kidswatch_release"})
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
      AppMethodBeat.i(256294);
      Object localObject;
      if (!Util.isNullOrNil(this.nickname))
      {
        localObject = new StringBuilder();
        MMClearEditText localMMClearEditText = (MMClearEditText)this.yBu._$_findCachedViewById(2131305428);
        p.g(localMMClearEditText, "nickFIV");
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
            label89:
            if (((CharSequence)localObject).charAt(m) > ' ') {
              break label126;
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
                break label89;
                label126:
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
          ((MMClearEditText)this.yBu._$_findCachedViewById(2131305428)).setText((CharSequence)this.nickname);
        }
      }
      if (!e.apn())
      {
        Log.e("MicroMsg.KidsWatchRegGetInfoUI", "SDcard is not available");
        AppMethodBeat.o(256294);
        return false;
      }
      if (KidsWatchRegGetInfoUI.b(this.yBu) != null)
      {
        localObject = KidsWatchRegGetInfoUI.b(this.yBu);
        if (localObject == null) {
          p.hyc();
        }
        if ((!((Bitmap)localObject).isRecycled()) && (!KidsWatchRegGetInfoUI.c(this.yBu)))
        {
          ((RoundCornerImageView)this.yBu._$_findCachedViewById(2131297120)).setImageBitmap(KidsWatchRegGetInfoUI.b(this.yBu));
          localObject = (RoundCornerImageView)this.yBu._$_findCachedViewById(2131297120);
          p.g(localObject, "avatarIV");
          ((RoundCornerImageView)localObject).setVisibility(0);
          localObject = (ImageView)this.yBu._$_findCachedViewById(2131296520);
          p.g(localObject, "addAvatarIV");
          ((ImageView)localObject).setVisibility(8);
          KidsWatchRegGetInfoUI.d(this.yBu);
        }
      }
      AppMethodBeat.o(256294);
      return true;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(256295);
      String str = super.toString() + "|initView2";
      AppMethodBeat.o(256295);
      return str;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "isChecked", "", "onCheckedChanged"})
  static final class h
    implements CompoundButton.OnCheckedChangeListener
  {
    h(KidsWatchRegGetInfoUI paramKidsWatchRegGetInfoUI) {}
    
    public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      AppMethodBeat.i(256296);
      paramCompoundButton = (MMClearEditText)this.yBu._$_findCachedViewById(2131305428);
      p.g(paramCompoundButton, "nickFIV");
      if (!Util.isNullOrNil(paramCompoundButton.getText().toString()))
      {
        paramCompoundButton = (MMClearEditText)this.yBu._$_findCachedViewById(2131304740);
        p.g(paramCompoundButton, "mobileFIV");
        if ((!Util.isNullOrNil(paramCompoundButton.getText().toString())) && (paramBoolean))
        {
          paramCompoundButton = (Button)this.yBu._$_findCachedViewById(2131306784);
          p.g(paramCompoundButton, "regBtn");
          paramCompoundButton.setEnabled(paramBoolean);
        }
      }
      if (!paramBoolean)
      {
        paramCompoundButton = (Button)this.yBu._$_findCachedViewById(2131306784);
        p.g(paramCompoundButton, "regBtn");
        paramCompoundButton.setEnabled(paramBoolean);
      }
      AppMethodBeat.o(256296);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegGetInfoUI$initView$7", "Lcom/tencent/mm/plugin/kidswatch/model/KidsWatchAvoidDuplicatedPressableSpan;", "onClickImp", "", "widget", "Landroid/view/View;", "plugin-kidswatch_release"})
  public static final class i
    extends com.tencent.mm.plugin.kidswatch.model.a
  {
    i(int paramInt) {}
    
    public final void ebS()
    {
      AppMethodBeat.i(256297);
      KidsWatchRegGetInfoUI.e(this.yBu);
      AppMethodBeat.o(256297);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(KidsWatchRegGetInfoUI paramKidsWatchRegGetInfoUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(256301);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegGetInfoUI$initView$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      Log.i("MicroMsg.KidsWatchRegGetInfoUI", "click reg button");
      paramView = this.yBu;
      localObject = (Context)this.yBu;
      this.yBu.getString(2131755998);
      KidsWatchRegGetInfoUI.a(paramView, h.a((Context)localObject, this.yBu.getString(2131756029), true, null));
      c.f((MMClearEditText)this.yBu._$_findCachedViewById(2131305428)).lv(1, 32).CN(true).a((c.a)new c.a()
      {
        public final void Tw(String paramAnonymousString)
        {
          AppMethodBeat.i(256298);
          p.h(paramAnonymousString, "text");
          paramAnonymousString = this.yBw.yBu;
          MMClearEditText localMMClearEditText = (MMClearEditText)this.yBw.yBu._$_findCachedViewById(2131304740);
          p.g(localMMClearEditText, "mobileFIV");
          KidsWatchRegGetInfoUI.b(paramAnonymousString, PhoneFormater.pureNumber(localMMClearEditText.getText().toString()));
          paramAnonymousString = KidsWatchRegGetInfoUI.h(this.yBw.yBu) + KidsWatchRegGetInfoUI.g(this.yBw.yBu);
          this.yBw.yBu.hideVKB();
          if (KidsWatchRegGetInfoUI.i(this.yBw.yBu))
          {
            paramAnonymousString = KidsWatchRegGetInfoUI.f(this.yBw.yBu);
            if (paramAnonymousString != null) {
              paramAnonymousString.dismiss();
            }
            paramAnonymousString = this.yBw.yBu.getString(2131762219, new Object[] { LocaleUtil.getApplicationLanguage(), "CN", "kidswatchreg", Integer.valueOf(1), Integer.valueOf(0) });
            p.g(paramAnonymousString, "getString(R.string.licen…N\", \"kidswatchreg\", 1, 0)");
            com.tencent.mm.plugin.account.a.b.a.b((Context)this.yBw.yBu.getContext(), paramAnonymousString, 30847, false);
            AppMethodBeat.o(256298);
            return;
          }
          KidsWatchRegGetInfoUI.c(this.yBw.yBu, paramAnonymousString);
          AppMethodBeat.o(256298);
        }
        
        public final void Tx(String paramAnonymousString)
        {
          AppMethodBeat.i(256299);
          p.h(paramAnonymousString, "text");
          paramAnonymousString = KidsWatchRegGetInfoUI.f(this.yBw.yBu);
          if (paramAnonymousString != null) {
            paramAnonymousString.dismiss();
          }
          h.n((Context)this.yBw.yBu.getContext(), 2131765471, 2131765474);
          AppMethodBeat.o(256299);
        }
        
        public final void dv(String paramAnonymousString)
        {
          AppMethodBeat.i(256300);
          p.h(paramAnonymousString, "text");
          paramAnonymousString = KidsWatchRegGetInfoUI.f(this.yBw.yBu);
          if (paramAnonymousString != null) {
            paramAnonymousString.dismiss();
          }
          h.n((Context)this.yBw.yBu.getContext(), 2131765472, 2131765474);
          AppMethodBeat.o(256300);
        }
      });
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegGetInfoUI$initView$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(256301);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class k
    implements Runnable
  {
    k(KidsWatchRegGetInfoUI paramKidsWatchRegGetInfoUI, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(256302);
      Object localObject = (InputPanelLinearLayout)this.yBu._$_findCachedViewById(2131302669);
      p.g(localObject, "inputContainer");
      Log.i("MicroMsg.KidsWatchRegGetInfoUI", "inputContainer.height: %d, screenHeight: %d", new Object[] { Integer.valueOf(((InputPanelLinearLayout)localObject).getHeight()), Integer.valueOf(paramInt) });
      localObject = (InputPanelLinearLayout)this.yBu._$_findCachedViewById(2131302669);
      p.g(localObject, "inputContainer");
      if (((InputPanelLinearLayout)localObject).getHeight() > paramInt)
      {
        localObject = (ScrollView)this.yBu._$_findCachedViewById(2131307332);
        InputPanelLinearLayout localInputPanelLinearLayout = (InputPanelLinearLayout)this.yBu._$_findCachedViewById(2131302669);
        p.g(localInputPanelLinearLayout, "inputContainer");
        ((ScrollView)localObject).scrollBy(0, localInputPanelLinearLayout.getHeight() - paramInt);
      }
      AppMethodBeat.o(256302);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.ui.reg.KidsWatchRegGetInfoUI
 * JD-Core Version:    0.7.0.1
 */