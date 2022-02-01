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
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.modelavatar.i.b;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.plugin.account.ui.r.j;
import com.tencent.mm.plugin.kidswatch.b.a;
import com.tencent.mm.plugin.kidswatch.b.b;
import com.tencent.mm.plugin.kidswatch.b.c;
import com.tencent.mm.plugin.kidswatch.b.e;
import com.tencent.mm.plugin.kidswatch.b.f;
import com.tencent.mm.plugin.kidswatch.b.h;
import com.tencent.mm.plugin.kidswatch.ui.login.KidsWatchHeadComponent;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.eou;
import com.tencent.mm.protocal.protobuf.gdd;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.RoundCornerImageView;
import java.io.IOException;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.n.n;

@com.tencent.mm.ui.base.a(35)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegGetInfoUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/ui/widget/InputPanelHelper$OnInputPanelChange;", "Lcom/tencent/mm/modelavatar/HeadImageUploader$IImgUploadCallback;", "()V", "adjustedMobile", "", "avatarBitmap", "Landroid/graphics/Bitmap;", "hasSetAvatar", "", "inputMobileRetrys", "", "lastInputMobile", "loginUrl", "mMobile", "needShowAgreements", "permissionCheckHelper", "Lcom/tencent/mm/platformtools/PermissionCheckHelper;", "plusCountryCode", "proDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "regSessionId", "changeAvatar", "", "checkMobileState", "mNumber", "checkMobileStateFun", "finish", "getForceOrientation", "getLayoutId", "gotoLawLink", "gotoMobileVerifyCodePage", "fileId", "aesKey", "initView", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onError", "errType", "errCode", "errMsg", "onInputPanelChange", "isKeyboardShow", "keyboardHeight", "onKeyBoardHidden", "onPause", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onSceneEnd", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSuccess", "fileID", "uploadHeadImg", "Companion", "plugin-kidswatch_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class KidsWatchRegGetInfoUI
  extends MMActivity
  implements com.tencent.mm.am.h, i.b, com.tencent.mm.ui.widget.c.a
{
  public static final KidsWatchRegGetInfoUI.a JTJ;
  private String hZO;
  private w pRu;
  private final com.tencent.mm.platformtools.u qbk;
  private String qcQ;
  private String qcm;
  private String qcn;
  private int qco;
  private String qcu;
  private boolean qeQ;
  private final String qfe;
  private Bitmap qfk;
  private boolean qfp;
  
  static
  {
    AppMethodBeat.i(262269);
    JTJ = new KidsWatchRegGetInfoUI.a((byte)0);
    AppMethodBeat.o(262269);
  }
  
  public KidsWatchRegGetInfoUI()
  {
    AppMethodBeat.i(262110);
    this.qfe = "+86";
    this.qfp = true;
    this.qbk = new com.tencent.mm.platformtools.u();
    AppMethodBeat.o(262110);
  }
  
  private final void Tv(String paramString)
  {
    AppMethodBeat.i(262117);
    this.qbk.b((Activity)this, new KidsWatchRegGetInfoUI..ExternalSyntheticLambda6(this, paramString));
    AppMethodBeat.o(262117);
  }
  
  private static final void a(KidsWatchRegGetInfoUI paramKidsWatchRegGetInfoUI)
  {
    AppMethodBeat.i(262192);
    kotlin.g.b.s.u(paramKidsWatchRegGetInfoUI, "this$0");
    paramKidsWatchRegGetInfoUI = paramKidsWatchRegGetInfoUI.pRu;
    if (paramKidsWatchRegGetInfoUI != null) {
      paramKidsWatchRegGetInfoUI.dismiss();
    }
    AppMethodBeat.o(262192);
  }
  
  private static final void a(KidsWatchRegGetInfoUI paramKidsWatchRegGetInfoUI, int paramInt)
  {
    AppMethodBeat.i(262183);
    kotlin.g.b.s.u(paramKidsWatchRegGetInfoUI, "this$0");
    Log.i("MicroMsg.KidsWatchRegGetInfoUI", "inputContainer.height: %d, screenHeight: %d", new Object[] { Integer.valueOf(((InputPanelLinearLayout)paramKidsWatchRegGetInfoUI.findViewById(b.e.JRR)).getHeight()), Integer.valueOf(paramInt) });
    if (((InputPanelLinearLayout)paramKidsWatchRegGetInfoUI.findViewById(b.e.JRR)).getHeight() > paramInt) {
      ((ScrollView)paramKidsWatchRegGetInfoUI.findViewById(b.e.scrollView)).scrollBy(0, ((InputPanelLinearLayout)paramKidsWatchRegGetInfoUI.findViewById(b.e.JRR)).getHeight() - paramInt);
    }
    AppMethodBeat.o(262183);
  }
  
  private static final void a(KidsWatchRegGetInfoUI paramKidsWatchRegGetInfoUI, View paramView)
  {
    AppMethodBeat.i(262162);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramKidsWatchRegGetInfoUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegGetInfoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramKidsWatchRegGetInfoUI, "this$0");
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a((Activity)paramKidsWatchRegGetInfoUI, "android.permission.WRITE_EXTERNAL_STORAGE", 34, "");
    Log.i("MicroMsg.KidsWatchRegGetInfoUI", kotlin.g.b.s.X("changeAvatar, checkStorage:", Boolean.valueOf(bool)));
    if (bool) {
      com.tencent.mm.plugin.account.sdk.a.pFo.t((Activity)paramKidsWatchRegGetInfoUI);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegGetInfoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(262162);
  }
  
  private static final void a(KidsWatchRegGetInfoUI paramKidsWatchRegGetInfoUI, CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    AppMethodBeat.i(262170);
    kotlin.g.b.s.u(paramKidsWatchRegGetInfoUI, "this$0");
    if ((!Util.isNullOrNil(((MMClearEditText)paramKidsWatchRegGetInfoUI.findViewById(b.e.JSf)).getText().toString())) && (!Util.isNullOrNil(((MMClearEditText)paramKidsWatchRegGetInfoUI.findViewById(b.e.JSd)).getText().toString())) && (paramBoolean)) {
      ((Button)paramKidsWatchRegGetInfoUI.findViewById(b.e.JSj)).setEnabled(paramBoolean);
    }
    if (!paramBoolean) {
      ((Button)paramKidsWatchRegGetInfoUI.findViewById(b.e.JSj)).setEnabled(paramBoolean);
    }
    AppMethodBeat.o(262170);
  }
  
  private static final void a(KidsWatchRegGetInfoUI paramKidsWatchRegGetInfoUI, String paramString)
  {
    AppMethodBeat.i(262154);
    kotlin.g.b.s.u(paramKidsWatchRegGetInfoUI, "this$0");
    kotlin.g.b.s.u(paramString, "$mNumber");
    com.tencent.mm.kernel.h.aZW().a(145, (com.tencent.mm.am.h)paramKidsWatchRegGetInfoUI);
    Object localObject = (CharSequence)((MMClearEditText)paramKidsWatchRegGetInfoUI.findViewById(b.e.JSd)).getText().toString();
    int i = ((CharSequence)localObject).length() - 1;
    int k = 0;
    int j = 0;
    int m;
    while (j <= i)
    {
      if (k == 0)
      {
        m = j;
        label81:
        if (kotlin.g.b.s.compare(((CharSequence)localObject).charAt(m), 32) > 0) {
          break label123;
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
            break label81;
            label123:
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
    localObject = PhoneFormater.pureNumber(((CharSequence)localObject).subSequence(j, i + 1).toString());
    if ((paramKidsWatchRegGetInfoUI.qcm != null) && (paramKidsWatchRegGetInfoUI.qcn != null) && (!kotlin.g.b.s.p(localObject, paramKidsWatchRegGetInfoUI.qcm)) && (kotlin.g.b.s.p(localObject, paramKidsWatchRegGetInfoUI.qcn))) {
      i = 1;
    }
    for (;;)
    {
      Log.i("MicroMsg.KidsWatchRegGetInfoUI", "checkMobileStateFun, adJust:" + i + ", opCode:22, " + paramKidsWatchRegGetInfoUI.qco);
      com.tencent.mm.modelfriend.a locala = new com.tencent.mm.modelfriend.a(paramString, 22, "", 0, "");
      locala.wd(paramKidsWatchRegGetInfoUI.qco);
      locala.we(i);
      if (d.MtP.aQk("ie_reg")) {
        d.MtP.aQj("ie_reg");
      }
      localObject = new eou();
      ((eou)localObject).vhX = ((MMClearEditText)paramKidsWatchRegGetInfoUI.findViewById(b.e.JSf)).getText().toString();
      if ((paramKidsWatchRegGetInfoUI.qeQ) && (paramKidsWatchRegGetInfoUI.qfk != null))
      {
        Bitmap localBitmap = paramKidsWatchRegGetInfoUI.qfk;
        kotlin.g.b.s.checkNotNull(localBitmap);
        if (!localBitmap.isRecycled()) {
          ((eou)localObject).aaVQ = MD5Util.getMD5String(BitmapUtil.Bitmap2Bytes(paramKidsWatchRegGetInfoUI.qfk));
        }
      }
      ((eou)localObject).absX = paramString;
      ((eou)localObject).ytr = Util.getTimeZoneOffset();
      ((eou)localObject).absY = TimeZone.getDefault().getID();
      Log.i("MicroMsg.KidsWatchRegGetInfoUI", "%s,%s", new Object[] { ((eou)localObject).ytr, ((eou)localObject).absY });
      paramString = new gdd();
      paramString.acaV = new gol().df(d.MtP.aQl("ie_reg"));
      paramString.acaW = new gol().df(d.MtP.aQo("ce_reg"));
      paramString.acaX = new gol().df(d.MtP.aeP(16));
      paramString.acbb = new gol().df(d.MtP.gtH());
      try
      {
        paramString.acaY = new gol().df(((eou)localObject).toByteArray());
        locala.a(paramString);
        localObject = paramKidsWatchRegGetInfoUI.hZO;
        paramString = (String)localObject;
        if (localObject == null)
        {
          kotlin.g.b.s.bIx("loginUrl");
          paramString = null;
        }
        locala.NG(paramString);
        com.tencent.mm.kernel.h.aZW().a((p)locala, 0);
        paramString = (CharSequence)((MMClearEditText)paramKidsWatchRegGetInfoUI.findViewById(b.e.JSd)).getText().toString();
        i = paramString.length() - 1;
        j = 0;
        k = 0;
        for (;;)
        {
          if (j <= i) {
            if (k == 0)
            {
              m = j;
              if (kotlin.g.b.s.compare(paramString.charAt(m), 32) > 0) {
                break label758;
              }
              m = 1;
              if (k != 0) {
                break label771;
              }
              if (m != 0) {
                break label764;
              }
              k = 1;
              continue;
              if ((paramKidsWatchRegGetInfoUI.qcm != null) && (paramKidsWatchRegGetInfoUI.qcn != null) && (!kotlin.g.b.s.p(paramKidsWatchRegGetInfoUI.qcn, paramKidsWatchRegGetInfoUI.qcm)) && (!kotlin.g.b.s.p(localObject, paramKidsWatchRegGetInfoUI.qcn)))
              {
                i = 2;
                break;
              }
              i = 0;
            }
          }
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.KidsWatchRegGetInfoUI", (Throwable)localIOException, "convert to byte error ! %s", new Object[] { localIOException.getMessage() });
          continue;
          m = i;
          continue;
          label758:
          m = 0;
          continue;
          label764:
          j += 1;
          continue;
          label771:
          if (m == 0) {
            break;
          }
          i -= 1;
        }
        paramKidsWatchRegGetInfoUI.qcm = PhoneFormater.pureNumber(paramString.subSequence(j, i + 1).toString());
        paramKidsWatchRegGetInfoUI.qco += 1;
        AppMethodBeat.o(262154);
      }
    }
  }
  
  private static final void b(KidsWatchRegGetInfoUI paramKidsWatchRegGetInfoUI)
  {
    AppMethodBeat.i(262200);
    kotlin.g.b.s.u(paramKidsWatchRegGetInfoUI, "this$0");
    paramKidsWatchRegGetInfoUI = paramKidsWatchRegGetInfoUI.pRu;
    if (paramKidsWatchRegGetInfoUI != null) {
      paramKidsWatchRegGetInfoUI.dismiss();
    }
    AppMethodBeat.o(262200);
  }
  
  private static final void b(KidsWatchRegGetInfoUI paramKidsWatchRegGetInfoUI, View paramView)
  {
    AppMethodBeat.i(262176);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramKidsWatchRegGetInfoUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegGetInfoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramKidsWatchRegGetInfoUI, "this$0");
    Log.i("MicroMsg.KidsWatchRegGetInfoUI", "click reg button");
    paramView = (Context)paramKidsWatchRegGetInfoUI;
    paramKidsWatchRegGetInfoUI.getString(b.h.app_tip);
    paramKidsWatchRegGetInfoUI.pRu = k.a(paramView, paramKidsWatchRegGetInfoUI.getString(b.h.app_waiting), true, null);
    c.i((EditText)paramKidsWatchRegGetInfoUI.findViewById(b.e.JSf)).oF(1, 32).Nc(true).a((com.tencent.mm.ui.tools.b.c.a)new g(paramKidsWatchRegGetInfoUI));
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegGetInfoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(262176);
  }
  
  private final void fST()
  {
    AppMethodBeat.i(262123);
    if (!this.qeQ)
    {
      Log.i("MicroMsg.KidsWatchRegGetInfoUI", kotlin.g.b.s.X("uploadHeadImg, gotoMobileVerifyCodePage, ", Boolean.valueOf(this.qeQ)));
      jO("", "");
      AppMethodBeat.o(262123);
      return;
    }
    Context localContext = (Context)this;
    getString(b.h.app_tip);
    this.pRu = k.a(localContext, getString(b.h.app_waiting), true, null);
    new com.tencent.mm.modelavatar.i(kotlin.g.b.s.X(com.tencent.mm.loader.i.b.bmH(), "temp.avatar"), (i.b)this).bFu();
    AppMethodBeat.o(262123);
  }
  
  private final void fSU()
  {
    AppMethodBeat.i(262143);
    ((LinearLayout)findViewById(b.e.JRQ)).setVisibility(0);
    Object localObject = ((LinearLayout)findViewById(b.e.JRD)).getLayoutParams();
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(262143);
      throw ((Throwable)localObject);
    }
    localObject = (ViewGroup.MarginLayoutParams)localObject;
    ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = getResources().getDimensionPixelSize(b.c.Edge_12A);
    ((ViewGroup.MarginLayoutParams)localObject).topMargin = 0;
    ((LinearLayout)findViewById(b.e.JRD)).setLayoutParams((ViewGroup.LayoutParams)localObject);
    ((InputPanelLinearLayout)findViewById(b.e.JRR)).setPadding(((InputPanelLinearLayout)findViewById(b.e.JRR)).getPaddingLeft(), ((InputPanelLinearLayout)findViewById(b.e.JRR)).getPaddingTop(), ((InputPanelLinearLayout)findViewById(b.e.JRR)).getPaddingRight(), 0);
    ((ScrollView)findViewById(b.e.scrollView)).scrollBy(0, 0);
    AppMethodBeat.o(262143);
  }
  
  private final void jO(String paramString1, String paramString2)
  {
    AppMethodBeat.i(262134);
    Intent localIntent = new Intent((Context)this, KidsWatchRegMobileVerifyUI.class);
    String str2 = this.hZO;
    String str1 = str2;
    if (str2 == null)
    {
      kotlin.g.b.s.bIx("loginUrl");
      str1 = null;
    }
    localIntent.putExtra("intent.key.login.url", str1);
    localIntent.putExtra("intent.key.reg.nickname", ((MMClearEditText)findViewById(b.e.JSf)).getText().toString());
    localIntent.putExtra("intent.key.reg.mobile", ((MMClearEditText)findViewById(b.e.JSd)).getText().toString());
    localIntent.putExtra("intent.key.reg.session.id", this.qcu);
    localIntent.putExtra("intent.key.hasSetAvatar", this.qeQ);
    localIntent.putExtra("intent.key.reg.head_img.file.id", paramString1);
    localIntent.putExtra("intent.key.reg.head_img.aes.key", paramString2);
    Log.i("MicroMsg.KidsWatchRegGetInfoUI", "get info page:(fileId:" + paramString1 + ") , (aesKey:" + paramString2 + ')');
    paramString1 = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(this, paramString1.aYi(), "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegGetInfoUI", "gotoMobileVerifyCodePage", "(Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramString1.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegGetInfoUI", "gotoMobileVerifyCodePage", "(Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(262134);
  }
  
  public final void LR(String paramString)
  {
    AppMethodBeat.i(262385);
    com.tencent.threadpool.h.ahAA.bk(new KidsWatchRegGetInfoUI..ExternalSyntheticLambda3(this));
    Log.e("MicroMsg.KidsWatchRegGetInfoUI", "upload head fail, errType:%s, errCode:%s, errMsg:%s", new Object[] { Integer.valueOf(3), Integer.valueOf(-1), paramString });
    jO("", "");
    AppMethodBeat.o(262385);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final void br(String paramString1, String paramString2)
  {
    AppMethodBeat.i(262382);
    kotlin.g.b.s.u(paramString1, "fileID");
    kotlin.g.b.s.u(paramString2, "aesKey");
    com.tencent.threadpool.h.ahAA.bk(new KidsWatchRegGetInfoUI..ExternalSyntheticLambda4(this));
    Log.i("MicroMsg.KidsWatchRegGetInfoUI", "IImgUploadCallback, ok, fileId:" + paramString1 + ", aesKey:" + paramString2);
    jO(paramString1, paramString2);
    AppMethodBeat.o(262382);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(262351);
    super.finish();
    overridePendingTransition(b.a.anim_not_change, b.a.push_down_out);
    AppMethodBeat.o(262351);
  }
  
  public final int getForceOrientation()
  {
    return 1;
  }
  
  public final int getLayoutId()
  {
    return b.f.JSu;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(262362);
    setMMTitle("");
    hideActionbarLine();
    Object localObject = (KidsWatchHeadComponent)findViewById(b.e.JRO);
    String str = getString(b.h.JSG);
    kotlin.g.b.s.s(str, "getString(R.string.kids_…ogin_enter_loading_title)");
    ((KidsWatchHeadComponent)localObject).setTitle(str);
    ((KidsWatchHeadComponent)findViewById(b.e.JRO)).fSR();
    ((KidsWatchHeadComponent)findViewById(b.e.JRO)).setCloseBtnCallBack((kotlin.g.a.a)new b(this));
    ((InputPanelLinearLayout)findViewById(b.e.JRR)).setExternalListener((com.tencent.mm.ui.widget.c.a)this);
    ((RelativeLayout)findViewById(b.e.JRH)).setOnClickListener(new KidsWatchRegGetInfoUI..ExternalSyntheticLambda0(this));
    ((ImageView)findViewById(b.e.JRB)).setVisibility(0);
    ((RoundCornerImageView)findViewById(b.e.avatarIV)).setVisibility(8);
    ((RoundCornerImageView)findViewById(b.e.avatarIV)).oJ(com.tencent.mm.cd.a.fromDPToPix((Context)getContext(), 22), com.tencent.mm.cd.a.fromDPToPix((Context)getContext(), 22));
    ((MMClearEditText)findViewById(b.e.JSf)).addTextChangedListener((TextWatcher)new c(this));
    ((MMClearEditText)findViewById(b.e.JSd)).addTextChangedListener((TextWatcher)new d(this));
    com.tencent.mm.kernel.h.baH().postAtFrontOfWorker((MMHandlerThread.IWaitWorkThread)new e(this));
    Util.expandViewTouchArea((View)findViewById(b.e.JRV), 250, 250, 250, 250);
    ((Button)findViewById(b.e.JSj)).setEnabled(false);
    ((CheckBox)findViewById(b.e.JRV)).setOnCheckedChangeListener(new KidsWatchRegGetInfoUI..ExternalSyntheticLambda2(this));
    localObject = getString(b.h.JSN);
    kotlin.g.b.s.s(localObject, "getString(R.string.kids_…eg_intro_get_info_cb_tip)");
    str = getString(b.h.JSO);
    kotlin.g.b.s.s(str, "getString(R.string.kids_…tro_get_info_cb_tip_link)");
    int i = n.g((CharSequence)localObject, str);
    if (i < 0)
    {
      AppMethodBeat.o(262362);
      return;
    }
    int j = str.length();
    localObject = new SpannableStringBuilder((CharSequence)localObject);
    ((SpannableStringBuilder)localObject).setSpan(new f(this), i, j + i, 18);
    ((TextView)findViewById(b.e.JRW)).setOnTouchListener((View.OnTouchListener)new com.tencent.mm.pluginsdk.ui.span.s((Context)this));
    ((TextView)findViewById(b.e.JRW)).setClickable(true);
    ((TextView)findViewById(b.e.JRW)).setText((CharSequence)localObject);
    localObject = getIntent().getStringExtra("intent.key.login.url");
    kotlin.g.b.s.checkNotNull(localObject);
    kotlin.g.b.s.s(localObject, "intent.getStringExtra(Co…h.INTENT_KEY_LOGIN_URL)!!");
    this.hZO = ((String)localObject);
    ((Button)findViewById(b.e.JSj)).setOnClickListener(new KidsWatchRegGetInfoUI..ExternalSyntheticLambda1(this));
    localObject = com.tencent.mm.plugin.kidswatch.b.a.JTW;
    localObject = getContext();
    kotlin.g.b.s.s(localObject, "context");
    com.tencent.mm.plugin.kidswatch.b.a.a((Context)localObject, (LinearLayout)findViewById(b.e.JRF), (LinearLayout)findViewById(b.e.JRD));
    AppMethodBeat.o(262362);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(262366);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Log.i("MicroMsg.KidsWatchRegGetInfoUI", "onActivityResult, requestCode:" + paramInt1 + ", resultCode: " + paramInt2);
    switch (paramInt1)
    {
    default: 
      this.qfk = com.tencent.mm.plugin.account.sdk.a.pFo.b((Activity)this, paramInt1, paramInt2, paramIntent);
      if (this.qfk != null)
      {
        ((RoundCornerImageView)findViewById(b.e.avatarIV)).setImageBitmap(this.qfk);
        this.qeQ = true;
        ((RoundCornerImageView)findViewById(b.e.avatarIV)).setVisibility(0);
        ((ImageView)findViewById(b.e.JRB)).setVisibility(8);
      }
      break;
    }
    do
    {
      do
      {
        do
        {
          AppMethodBeat.o(262366);
          return;
        } while (paramInt2 != -1);
        if (paramIntent != null) {
          localObject1 = paramIntent.getBundleExtra("result_data");
        }
      } while ((localObject1 == null) || (!kotlin.g.b.s.p(((Bundle)localObject1).getString("go_next", ""), "get_reg_verify_code")));
      fST();
      AppMethodBeat.o(262366);
      return;
      localObject1 = localObject2;
      if (paramIntent != null) {
        localObject1 = paramIntent.getBundleExtra("result_data");
      }
    } while ((localObject1 == null) || (!kotlin.g.b.s.p(((Bundle)localObject1).getString("go_next", ""), "agree_privacy")));
    this.qfp = false;
    Tv(kotlin.g.b.s.X(this.qfe, this.qcQ));
    AppMethodBeat.o(262366);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(262324);
    super.onCreate(paramBundle);
    paramBundle = getSupportActionBar();
    kotlin.g.b.s.checkNotNull(paramBundle);
    paramBundle.hide();
    setSelfNavigationBarVisible(8);
    setActionbarColor(getContext().getResources().getColor(b.b.JRx));
    setNavigationbarColor(getContext().getResources().getColor(b.b.JRx));
    initView();
    overridePendingTransition(b.a.push_up_in, b.a.anim_not_change);
    AppMethodBeat.o(262324);
  }
  
  public final void onInputPanelChange(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(262378);
    Log.i("MicroMsg.KidsWatchRegGetInfoUI", "keyboard show %s, keyboardHeight %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (paramBoolean)
    {
      ((LinearLayout)findViewById(b.e.JRQ)).setVisibility(8);
      Object localObject = ((LinearLayout)findViewById(b.e.JRD)).getLayoutParams();
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(262378);
        throw ((Throwable)localObject);
      }
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = getResources().getDimensionPixelSize(b.c.Edge_3A);
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = getResources().getDimensionPixelSize(b.c.Edge_4A);
      ((LinearLayout)findViewById(b.e.JRD)).setLayoutParams((ViewGroup.LayoutParams)localObject);
      ((InputPanelLinearLayout)findViewById(b.e.JRR)).setPadding(((InputPanelLinearLayout)findViewById(b.e.JRR)).getPaddingLeft(), ((InputPanelLinearLayout)findViewById(b.e.JRR)).getPaddingTop(), ((InputPanelLinearLayout)findViewById(b.e.JRR)).getPaddingRight(), paramInt);
      paramInt = ((ScrollView)findViewById(b.e.scrollView)).getHeight();
      ((InputPanelLinearLayout)findViewById(b.e.JRR)).requestLayout();
      ((InputPanelLinearLayout)findViewById(b.e.JRR)).post(new KidsWatchRegGetInfoUI..ExternalSyntheticLambda5(this, paramInt));
      AppMethodBeat.o(262378);
      return;
    }
    fSU();
    AppMethodBeat.o(262378);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(262347);
    super.onPause();
    ((InputPanelLinearLayout)findViewById(b.e.JRR)).setExternalListener(null);
    AppMethodBeat.o(262347);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int i = 1;
    AppMethodBeat.i(262355);
    kotlin.g.b.s.u(paramArrayOfString, "permissions");
    kotlin.g.b.s.u(paramArrayOfInt, "grantResults");
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
        com.tencent.mm.plugin.account.sdk.a.pFo.t((Activity)this);
        AppMethodBeat.o(262355);
        return;
        paramInt = 0;
        break;
      }
    }
    this.qbk.a((Activity)this, paramInt, paramArrayOfString, paramArrayOfInt);
    label106:
    AppMethodBeat.o(262355);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(262342);
    super.onResume();
    ((InputPanelLinearLayout)findViewById(b.e.JRR)).setExternalListener((com.tencent.mm.ui.widget.c.a)this);
    fSU();
    AppMethodBeat.o(262342);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    Object localObject = null;
    AppMethodBeat.i(262375);
    w localw = this.pRu;
    if (localw != null) {
      localw.dismiss();
    }
    if (paramInt2 == -75)
    {
      k.s((Context)this, r.j.alpha_version_tip_reg, r.j.reg_username_exist_title);
      AppMethodBeat.o(262375);
      return;
    }
    if ((paramp instanceof com.tencent.mm.modelfriend.a))
    {
      Log.i("MicroMsg.KidsWatchRegGetInfoUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
      com.tencent.mm.kernel.h.aZW().b(145, (com.tencent.mm.am.h)this);
      int i = ((com.tencent.mm.modelfriend.a)paramp).bIO();
      this.qcu = ((com.tencent.mm.modelfriend.a)paramp).bJe();
      if (i == 22)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          fST();
          AppMethodBeat.o(262375);
          return;
        }
        switch (paramInt2)
        {
        default: 
          this.qcQ = PhoneFormater.pureNumber(this.qcQ);
          this.qcn = kotlin.g.b.s.X(this.qfe, this.qcQ);
          this.qcu = ((com.tencent.mm.modelfriend.a)paramp).bJe();
          switch (paramInt2)
          {
          default: 
            if (paramInt2 == -355)
            {
              Log.i("MicroMsg.KidsWatchRegGetInfoUI", "showBlockBySpam");
              v.f((Context)this, paramString, 30846);
              AppMethodBeat.o(262375);
              return;
            }
            break;
          }
        case -59: 
        case -41: 
          paramString = com.tencent.mm.broadcast.a.CH(paramString);
          if (paramString == null) {}
          for (paramString = localObject;; paramString = Boolean.valueOf(paramString.a((Context)this, null, null)))
          {
            if (paramString == null) {
              k.s((Context)this, b.h.regbymobile_reg_mobile_format_err_msg, b.h.regbymobile_reg_mobile_format_err_title);
            }
            AppMethodBeat.o(262375);
            return;
          }
          paramp = ((com.tencent.mm.modelfriend.a)paramp).bIS();
          if (!Util.isNullOrNil(paramp))
          {
            kotlin.g.b.s.s(paramp, "pureMobile");
            paramp = (CharSequence)paramp;
            i = paramp.length() - 1;
            int k = 0;
            int j = 0;
            while (j <= i)
            {
              int m;
              if (k == 0)
              {
                m = j;
                label417:
                if (kotlin.g.b.s.compare(paramp.charAt(m), 32) > 0) {
                  break label460;
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
                    break label417;
                    label460:
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
            this.qcQ = paramp.subSequence(j, i + 1).toString();
          }
          if (paramInt2 == -36)
          {
            fST();
            AppMethodBeat.o(262375);
            return;
          }
          paramString = com.tencent.mm.broadcast.a.CH(paramString);
          if (paramString == null) {}
          for (paramString = null;; paramString = Boolean.valueOf(paramString.a((Context)getContext(), null, null)))
          {
            if (paramString == null) {
              k.c((Context)this, getString(b.h.bind_mcontact_verify_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), "", true);
            }
            AppMethodBeat.o(262375);
            return;
          }
        }
        if (paramInt2 == -34)
        {
          k.c((Context)this, getString(b.h.bind_mcontact_err_freq_limit), "", true);
          AppMethodBeat.o(262375);
          return;
        }
        if (com.tencent.mm.plugin.account.sdk.a.pFo.a((Context)this, paramInt1, paramInt2, paramString))
        {
          AppMethodBeat.o(262375);
          return;
        }
      }
    }
    AppMethodBeat.o(262375);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    b(KidsWatchRegGetInfoUI paramKidsWatchRegGetInfoUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegGetInfoUI$initView$3", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-kidswatch_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements TextWatcher
  {
    c(KidsWatchRegGetInfoUI paramKidsWatchRegGetInfoUI) {}
    
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(262144);
      kotlin.g.b.s.u(paramEditable, "s");
      Button localButton = (Button)this.JTK.findViewById(b.e.JSj);
      if ((!Util.isNullOrNil(paramEditable.toString())) && (!Util.isNullOrNil((CharSequence)((MMClearEditText)this.JTK.findViewById(b.e.JSd)).getText())) && (((CheckBox)this.JTK.findViewById(b.e.JRV)).isChecked())) {}
      for (boolean bool = true;; bool = false)
      {
        localButton.setEnabled(bool);
        AppMethodBeat.o(262144);
        return;
      }
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(262131);
      kotlin.g.b.s.u(paramCharSequence, "s");
      AppMethodBeat.o(262131);
    }
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(262139);
      kotlin.g.b.s.u(paramCharSequence, "s");
      AppMethodBeat.o(262139);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegGetInfoUI$initView$4", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-kidswatch_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements TextWatcher
  {
    d(KidsWatchRegGetInfoUI paramKidsWatchRegGetInfoUI) {}
    
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(262127);
      kotlin.g.b.s.u(paramEditable, "s");
      Button localButton = (Button)this.JTK.findViewById(b.e.JSj);
      if ((!Util.isNullOrNil(paramEditable.toString())) && (!Util.isNullOrNil((CharSequence)((MMClearEditText)this.JTK.findViewById(b.e.JSf)).getText())) && (((CheckBox)this.JTK.findViewById(b.e.JRV)).isChecked())) {}
      for (boolean bool = true;; bool = false)
      {
        localButton.setEnabled(bool);
        AppMethodBeat.o(262127);
        return;
      }
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(262114);
      kotlin.g.b.s.u(paramCharSequence, "s");
      AppMethodBeat.o(262114);
    }
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(262120);
      kotlin.g.b.s.u(paramCharSequence, "s");
      AppMethodBeat.o(262120);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegGetInfoUI$initView$5", "Lcom/tencent/mm/sdk/platformtools/MMHandlerThread$IWaitWorkThread;", "nickname", "", "getNickname", "()Ljava/lang/String;", "setNickname", "(Ljava/lang/String;)V", "doInBackground", "", "onPostExecute", "toString", "plugin-kidswatch_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements MMHandlerThread.IWaitWorkThread
  {
    private String nickname;
    
    e(KidsWatchRegGetInfoUI paramKidsWatchRegGetInfoUI) {}
    
    public final boolean doInBackground()
    {
      return true;
    }
    
    public final boolean onPostExecute()
    {
      AppMethodBeat.i(262126);
      Object localObject;
      if (!Util.isNullOrNil(this.nickname))
      {
        localObject = (CharSequence)kotlin.g.b.s.X("", ((MMClearEditText)this.JTK.findViewById(b.e.JSf)).getText());
        int i = ((CharSequence)localObject).length() - 1;
        int k = 0;
        int j = 0;
        while (j <= i)
        {
          int m;
          if (k == 0)
          {
            m = j;
            label67:
            if (kotlin.g.b.s.compare(((CharSequence)localObject).charAt(m), 32) > 0) {
              break label107;
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
                break label67;
                label107:
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
          ((MMClearEditText)this.JTK.findViewById(b.e.JSf)).setText((CharSequence)this.nickname);
        }
      }
      if (!e.aPU())
      {
        Log.e("MicroMsg.KidsWatchRegGetInfoUI", "SDcard is not available");
        AppMethodBeat.o(262126);
        return false;
      }
      if (KidsWatchRegGetInfoUI.c(this.JTK) != null)
      {
        localObject = KidsWatchRegGetInfoUI.c(this.JTK);
        kotlin.g.b.s.checkNotNull(localObject);
        if ((!((Bitmap)localObject).isRecycled()) && (!KidsWatchRegGetInfoUI.d(this.JTK)))
        {
          ((RoundCornerImageView)this.JTK.findViewById(b.e.avatarIV)).setImageBitmap(KidsWatchRegGetInfoUI.c(this.JTK));
          ((RoundCornerImageView)this.JTK.findViewById(b.e.avatarIV)).setVisibility(0);
          ((ImageView)this.JTK.findViewById(b.e.JRB)).setVisibility(8);
          KidsWatchRegGetInfoUI.e(this.JTK);
        }
      }
      AppMethodBeat.o(262126);
      return true;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(262138);
      String str = kotlin.g.b.s.X(super.toString(), "|initView2");
      AppMethodBeat.o(262138);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegGetInfoUI$initView$7", "Lcom/tencent/mm/plugin/kidswatch/model/KidsWatchAvoidDuplicatedPressableSpan;", "onClickImp", "", "widget", "Landroid/view/View;", "plugin-kidswatch_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    extends com.tencent.mm.plugin.kidswatch.model.a
  {
    f(KidsWatchRegGetInfoUI paramKidsWatchRegGetInfoUI) {}
    
    public final void fSP()
    {
      AppMethodBeat.i(262105);
      KidsWatchRegGetInfoUI.f(this.JTK);
      AppMethodBeat.o(262105);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegGetInfoUI$initView$8$1", "Lcom/tencent/mm/ui/tools/legalchecker/InputTextBoundaryCheck$DoAfterCheck;", "doWhenLess", "", "text", "", "doWhenMore", "doWhenOK", "plugin-kidswatch_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements com.tencent.mm.ui.tools.b.c.a
  {
    g(KidsWatchRegGetInfoUI paramKidsWatchRegGetInfoUI) {}
    
    public final void Tw(String paramString)
    {
      AppMethodBeat.i(262118);
      kotlin.g.b.s.u(paramString, "text");
      KidsWatchRegGetInfoUI.b(this.JTK, PhoneFormater.pureNumber(((MMClearEditText)this.JTK.findViewById(b.e.JSd)).getText().toString()));
      paramString = kotlin.g.b.s.X(KidsWatchRegGetInfoUI.g(this.JTK), KidsWatchRegGetInfoUI.h(this.JTK));
      this.JTK.hideVKB();
      if (KidsWatchRegGetInfoUI.i(this.JTK))
      {
        paramString = KidsWatchRegGetInfoUI.j(this.JTK);
        if (paramString != null) {
          paramString.dismiss();
        }
        paramString = this.JTK.getString(b.h.license_read_url, new Object[] { LocaleUtil.getApplicationLanguage(), "CN", "kidswatchreg", Integer.valueOf(1), Integer.valueOf(0) });
        kotlin.g.b.s.s(paramString, "getString(R.string.licen…N\", \"kidswatchreg\", 1, 0)");
        com.tencent.mm.plugin.account.sdk.c.a.b((Context)this.JTK.getContext(), paramString, 30847, false);
        AppMethodBeat.o(262118);
        return;
      }
      KidsWatchRegGetInfoUI.c(this.JTK, paramString);
      AppMethodBeat.o(262118);
    }
    
    public final void Tx(String paramString)
    {
      AppMethodBeat.i(262122);
      kotlin.g.b.s.u(paramString, "text");
      paramString = KidsWatchRegGetInfoUI.j(this.JTK);
      if (paramString != null) {
        paramString.dismiss();
      }
      k.s((Context)this.JTK.getContext(), b.h.settings_modify_name_invalid_less, b.h.settings_modify_name_title);
      AppMethodBeat.o(262122);
    }
    
    public final void eY(String paramString)
    {
      AppMethodBeat.i(262128);
      kotlin.g.b.s.u(paramString, "text");
      paramString = KidsWatchRegGetInfoUI.j(this.JTK);
      if (paramString != null) {
        paramString.dismiss();
      }
      k.s((Context)this.JTK.getContext(), b.h.settings_modify_name_invalid_more, b.h.settings_modify_name_title);
      AppMethodBeat.o(262128);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.ui.reg.KidsWatchRegGetInfoUI
 * JD-Core Version:    0.7.0.1
 */