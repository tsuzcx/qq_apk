package com.tencent.mm.plugin.collect.reward.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.ExportFileUtil;
import com.tencent.mm.plugin.collect.reward.a.b;
import com.tencent.mm.plugin.wallet_core.ui.s.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.tools.t;
import com.tencent.mm.protocal.protobuf.dus;
import com.tencent.mm.protocal.protobuf.eme;
import com.tencent.mm.protocal.protobuf.xv;
import com.tencent.mm.protocal.protobuf.yp;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.wallet_core.ui.WcPayBannerView;
import com.tencent.mm.wallet_core.ui.i;
import com.tencent.mm.wallet_core.ui.k;
import java.util.Map;

public class QrRewardMainUI
  extends QrRewardBaseUI
{
  private String desc;
  private int iconWidth;
  private String igz;
  private boolean mIsOpen;
  private dus pGr;
  private TextView pJi;
  private WcPayBannerView pLM;
  private String rRV;
  private String username;
  private final int xaG;
  private RelativeLayout xaH;
  private Button xaI;
  private ViewGroup xaJ;
  private ViewGroup xaK;
  private RelativeLayout xaL;
  private CdnImageView xaM;
  private ImageView xaN;
  private ImageView xaO;
  private MMEditText xaP;
  private TextView xaQ;
  private TextView xaR;
  private TextView xaS;
  private ScrollView xaT;
  private String xaU;
  private String xaV;
  private String xaW;
  private int xaX;
  private boolean xaY;
  private boolean xaZ;
  
  public QrRewardMainUI()
  {
    AppMethodBeat.i(63961);
    this.xaG = com.tencent.mm.cd.a.fromDPToPix(getContext(), 200);
    this.mIsOpen = false;
    AppMethodBeat.o(63961);
  }
  
  private void dsc()
  {
    AppMethodBeat.i(63969);
    if (com.tencent.mm.plugin.collect.reward.b.a.drW().drX())
    {
      this.xaM.aW(com.tencent.mm.plugin.collect.reward.b.a.drW().drZ(), this.xaG, this.xaG);
      this.xaL.setVisibility(0);
      AppMethodBeat.o(63969);
      return;
    }
    this.xaL.setVisibility(4);
    AppMethodBeat.o(63969);
  }
  
  private void dsd()
  {
    AppMethodBeat.i(63970);
    int j = Math.round(this.xaG * (this.iconWidth * 1.0F / this.xaX));
    int i = j;
    if (j <= 0) {
      i = 248;
    }
    ViewGroup.LayoutParams localLayoutParams = this.xaO.getLayoutParams();
    localLayoutParams.width = i;
    localLayoutParams.height = i;
    this.xaO.setLayoutParams(localLayoutParams);
    localLayoutParams = this.xaN.getLayoutParams();
    localLayoutParams.width = i;
    localLayoutParams.height = i;
    this.xaN.setLayoutParams(localLayoutParams);
    localLayoutParams = this.xaP.getLayoutParams();
    localLayoutParams.width = (i - 30);
    localLayoutParams.height = (i - 30);
    this.xaP.setLayoutParams(localLayoutParams);
    this.xaP.setTextSize(0, i * 2 / 3);
    this.xaK.requestLayout();
    AppMethodBeat.o(63970);
  }
  
  private void dse()
  {
    AppMethodBeat.i(63971);
    if (!Util.isNullOrNil(this.desc))
    {
      this.pJi.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this, getString(a.i.qr_reward_wrap_text, new Object[] { this.desc }), this.pJi.getTextSize()));
      AppMethodBeat.o(63971);
      return;
    }
    this.pJi.setText("");
    AppMethodBeat.o(63971);
  }
  
  private void dsf()
  {
    AppMethodBeat.i(63972);
    dsd();
    dse();
    nv(Util.isNullOrNil(this.xaU));
    AppMethodBeat.o(63972);
  }
  
  private void dsg()
  {
    AppMethodBeat.i(63973);
    if (!Util.isNullOrNil(this.xaV))
    {
      this.xaR.setClickable(true);
      this.xaR.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.s(this));
      com.tencent.mm.plugin.wallet_core.ui.s locals = new com.tencent.mm.plugin.wallet_core.ui.s(new s.a()
      {
        public final void eS(View paramAnonymousView)
        {
          AppMethodBeat.i(63949);
          Log.d("MicroMsg.QrRewardMainUI", "go to: %s", new Object[] { QrRewardMainUI.s(QrRewardMainUI.this) });
          i.o(QrRewardMainUI.this.getContext(), QrRewardMainUI.s(QrRewardMainUI.this), false);
          com.tencent.mm.plugin.report.service.h.OAn.b(14721, new Object[] { Integer.valueOf(1), Integer.valueOf(6) });
          AppMethodBeat.o(63949);
        }
      });
      SpannableString localSpannableString = new SpannableString(this.xaV);
      localSpannableString.setSpan(locals, 0, localSpannableString.length(), 18);
      this.xaR.setText(localSpannableString);
      this.xaR.setVisibility(0);
      AppMethodBeat.o(63973);
      return;
    }
    this.xaR.setVisibility(8);
    AppMethodBeat.o(63973);
  }
  
  private void dsh()
  {
    AppMethodBeat.i(63975);
    if (!Util.isNullOrNil(this.xaU))
    {
      this.xaP.setText(com.tencent.mm.pluginsdk.ui.span.p.b(getContext(), this.xaU, this.xaP.getTextSize()));
      this.xaP.setSelection(this.xaU.length());
    }
    AppMethodBeat.o(63975);
  }
  
  private void dsi()
  {
    AppMethodBeat.i(63976);
    Log.i("MicroMsg.QrRewardMainUI", "do set photo word");
    com.tencent.mm.plugin.collect.reward.a.h localh = new com.tencent.mm.plugin.collect.reward.a.h(this.xaU);
    localh.C(this);
    doSceneProgress(localh, true);
    AppMethodBeat.o(63976);
  }
  
  private void nv(boolean paramBoolean)
  {
    AppMethodBeat.i(63974);
    Log.i("MicroMsg.QrRewardMainUI", "switch mode: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.xaN.setVisibility(0);
      this.xaP.setVisibility(4);
      a.b.a(this.xaN, this.username, 0.03F, true);
      AppMethodBeat.o(63974);
      return;
    }
    this.xaN.setVisibility(4);
    this.xaP.setVisibility(0);
    AppMethodBeat.o(63974);
  }
  
  private void r(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(63968);
    if ((this.rRV != null) && (this.rRV.equals(paramString1))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = com.tencent.mm.plugin.collect.reward.b.a.drW().drX();
      Log.i("MicroMsg.QrRewardMainUI", "do download photo: %s, same url: %s, pic exist: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((paramBoolean) || (!bool1) || (!bool2)) {
        com.tencent.mm.plugin.collect.reward.b.a.drW().a(paramString1, paramString2, new com.tencent.mm.plugin.collect.reward.b.a.a()
        {
          public final void ae(String paramAnonymousString, int paramAnonymousInt1, int paramAnonymousInt2)
          {
            AppMethodBeat.i(63948);
            Log.i("MicroMsg.QrRewardMainUI", "callback ret: %s, %s, %s", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
            if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0)) {
              MMHandlerThread.postToMainThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(63947);
                  QrRewardMainUI.r(QrRewardMainUI.this);
                  AppMethodBeat.o(63947);
                }
              });
            }
            AppMethodBeat.o(63948);
          }
        });
      }
      AppMethodBeat.o(63968);
      return;
    }
  }
  
  public int getLayoutId()
  {
    return a.g.qr_reward_main_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(63963);
    this.xaH = ((RelativeLayout)findViewById(a.f.root_rl));
    this.xaI = ((Button)findViewById(a.f.qrmu_open_reward_btn));
    this.xaJ = ((ViewGroup)findViewById(a.f.qrmu_no_code_layout));
    this.xaK = ((ViewGroup)findViewById(a.f.qrmu_main_layout));
    this.xaM = ((CdnImageView)findViewById(a.f.qrmu_code_iv));
    this.pJi = ((TextView)findViewById(a.f.qrmu_desc_tv));
    this.xaN = ((ImageView)findViewById(a.f.qrmu_code_avatar_iv));
    this.xaO = ((ImageView)findViewById(a.f.qrmu_code_avatar_border_iv));
    this.xaL = ((RelativeLayout)findViewById(a.f.qrmu_code_layout));
    this.xaP = ((MMEditText)findViewById(a.f.qrmu_code_word_et));
    this.xaQ = ((TextView)findViewById(a.f.qrmu_save_code_tv));
    this.xaS = ((TextView)findViewById(a.f.qrmu_set_code_tv));
    this.xaR = ((TextView)findViewById(a.f.qrmu_bottom_tv));
    this.pLM = ((WcPayBannerView)findViewById(a.f.wc_pay_banner_layout));
    this.pLM.jPz();
    a.b.a(this.xaN, this.username, 0.03F, true);
    try
    {
      this.xaP.setText(com.tencent.mm.pluginsdk.ui.span.p.b(getContext(), this.xaU, this.xaP.getTextSize()));
      this.xaP.setSelection(this.xaU.length());
      this.xaP.addTextChangedListener(new QrRewardMainUI.1(this));
      this.xaP.setOnEditorActionListener(new TextView.OnEditorActionListener()
      {
        public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(63952);
          Log.i("MicroMsg.QrRewardMainUI", "action: %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
          QrRewardMainUI.a(QrRewardMainUI.this, QrRewardMainUI.a(QrRewardMainUI.this).getText().toString());
          QrRewardMainUI.b(QrRewardMainUI.this);
          if (Util.isNullOrNil(QrRewardMainUI.c(QrRewardMainUI.this))) {
            QrRewardMainUI.a(QrRewardMainUI.this, true);
          }
          QrRewardMainUI.this.hideVKB();
          AppMethodBeat.o(63952);
          return false;
        }
      });
      this.xaO.setOnClickListener(new k()
      {
        public final void dr(View paramAnonymousView)
        {
          AppMethodBeat.i(293675);
          Log.d("MicroMsg.QrRewardMainUI", "click avatar");
          QrRewardMainUI.this.hideVKB();
          QrRewardMainUI.d(QrRewardMainUI.this);
          AppMethodBeat.o(293675);
        }
      });
      this.xaQ.setClickable(true);
      this.xaQ.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.s(this));
      com.tencent.mm.plugin.wallet_core.ui.s locals = new com.tencent.mm.plugin.wallet_core.ui.s(new s.a()
      {
        public final void eS(View paramAnonymousView)
        {
          AppMethodBeat.i(63954);
          Log.i("MicroMsg.QrRewardMainUI", "click save code");
          ExportFileUtil.a(QrRewardMainUI.this, new Runnable()new Runnable
          {
            public final void run()
            {
              AppMethodBeat.i(293697);
              QrRewardMainUI.e(QrRewardMainUI.this);
              com.tencent.mm.plugin.report.service.h.OAn.b(14721, new Object[] { Integer.valueOf(1), Integer.valueOf(5) });
              AppMethodBeat.o(293697);
            }
          }, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(293698);
              Toast.makeText(QrRewardMainUI.this, a.i.save_image_err, 1).show();
              AppMethodBeat.o(293698);
            }
          });
          AppMethodBeat.o(63954);
        }
      });
      SpannableString localSpannableString = new SpannableString(getString(a.i.qr_reward_save_code_btn_text));
      localSpannableString.setSpan(locals, 0, localSpannableString.length(), 18);
      this.xaQ.setText(localSpannableString);
      this.xaS.setClickable(true);
      this.xaS.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.s(this));
      locals = new com.tencent.mm.plugin.wallet_core.ui.s(new s.a()
      {
        public final void eS(View paramAnonymousView)
        {
          AppMethodBeat.i(63955);
          Log.i("MicroMsg.QrRewardMainUI", "click set code, %s", new Object[] { Boolean.valueOf(QrRewardMainUI.f(QrRewardMainUI.this)) });
          QrRewardMainUI.b(QrRewardMainUI.this, false);
          AppMethodBeat.o(63955);
        }
      });
      localSpannableString = new SpannableString(getString(a.i.qr_reward_set_money_title));
      localSpannableString.setSpan(locals, 0, localSpannableString.length(), 18);
      this.xaS.setText(localSpannableString);
      dsc();
      dsf();
      dsh();
      dsg();
      AppMethodBeat.o(63963);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.QrRewardMainUI", localException, "", new Object[0]);
      }
    }
  }
  
  public boolean needExecuteBackListener()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(63966);
    if (paramInt1 == 1)
    {
      if (paramInt2 == -1)
      {
        this.desc = paramIntent.getStringExtra("key_desc");
        this.xaX = paramIntent.getIntExtra("key_photo_width", 900);
        this.iconWidth = paramIntent.getIntExtra("key_icon_width", 343);
        boolean bool = paramIntent.getBooleanExtra("key_return_from_first", true);
        Log.i("MicroMsg.QrRewardMainUI", "return from first: %s", new Object[] { Boolean.valueOf(bool) });
        if (bool)
        {
          this.xaK.setVisibility(0);
          this.xaJ.setVisibility(8);
        }
        this.xaZ = true;
        dsf();
        String str = paramIntent.getStringExtra("key_photo_url");
        r(str, paramIntent.getStringExtra("key_photo_aeskey"), true);
        this.rRV = str;
        AppMethodBeat.o(63966);
      }
    }
    else {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    AppMethodBeat.o(63966);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(63962);
    super.onCreate(paramBundle);
    paramBundle = getWindow().getAttributes();
    if (paramBundle.screenBrightness < 0.85F)
    {
      paramBundle.screenBrightness = 0.85F;
      getWindow().setAttributes(paramBundle);
    }
    addSceneEndListener(1323);
    addSceneEndListener(1649);
    this.xaX = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acTZ, Integer.valueOf(900))).intValue();
    this.iconWidth = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acUa, Integer.valueOf(343))).intValue();
    this.desc = ((String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acUc, ""));
    this.xaU = ((String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acUb, ""));
    this.xaV = ((String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acUg, ""));
    this.xaW = ((String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acUh, ""));
    this.rRV = ((String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acUi, ""));
    if (!Util.isNullOrNil((String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acUf, ""))) {
      this.xaZ = true;
    }
    this.username = z.bAM();
    setMMTitle(a.i.qr_reward_main_title);
    initView();
    if ((com.tencent.mm.plugin.collect.reward.b.a.drW().drX()) && (this.xaZ)) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.QrRewardMainUI", "do get code: %s", new Object[] { Boolean.valueOf(bool) });
      paramBundle = new b(bool);
      paramBundle.C(this);
      if (!bool) {
        break;
      }
      doSceneProgress(paramBundle, false);
      AppMethodBeat.o(63962);
      return;
    }
    doSceneProgress(paramBundle, true);
    AppMethodBeat.o(63962);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(63967);
    super.onDestroy();
    removeSceneEndListener(1323);
    removeSceneEndListener(1649);
    com.tencent.mm.plugin.collect.reward.b.a locala = com.tencent.mm.plugin.collect.reward.b.a.drW();
    Log.d("MicroMsg.QrRewardCdnDownloadHelper", "do clear callback");
    if (locala.vcA != null)
    {
      Log.i("MicroMsg.QrRewardCdnDownloadHelper", "callback size: %s", new Object[] { Integer.valueOf(locala.vcA.size()) });
      locala.vcA.clear();
    }
    AppMethodBeat.o(63967);
  }
  
  public void onKeyboardStateChanged()
  {
    AppMethodBeat.i(63965);
    super.onKeyboardStateChanged();
    Log.i("MicroMsg.QrRewardMainUI", "key board changed: %s", new Object[] { Integer.valueOf(keyboardState()) });
    if (keyboardState() == 2)
    {
      this.xaU = this.xaP.getText().toString();
      dsi();
      if (Util.isNullOrNil(this.xaU)) {
        nv(true);
      }
    }
    AppMethodBeat.o(63965);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(63964);
    if ((paramp instanceof b))
    {
      paramString = (b)paramp;
      paramString.a(new com.tencent.mm.plugin.collect.reward.a.a.a()
      {
        public final void g(com.tencent.mm.am.p paramAnonymousp)
        {
          AppMethodBeat.i(63959);
          QrRewardMainUI.a(QrRewardMainUI.this, paramString.wZT.vFa);
          QrRewardMainUI.a(QrRewardMainUI.this, paramString.wZT.ZgK);
          QrRewardMainUI.b(QrRewardMainUI.this, paramString.wZT.ZgG);
          QrRewardMainUI.b(QrRewardMainUI.this, paramString.wZT.desc);
          QrRewardMainUI.c(QrRewardMainUI.this, paramString.wZT.VBL);
          paramAnonymousp = QrRewardMainUI.this;
          boolean bool;
          if (!paramString.wZT.ZgE)
          {
            bool = true;
            QrRewardMainUI.c(paramAnonymousp, bool);
            QrRewardMainUI.d(QrRewardMainUI.this, paramString.wZT.wul);
            QrRewardMainUI.e(QrRewardMainUI.this, paramString.wZT.ZgI);
            QrRewardMainUI.a(QrRewardMainUI.this, paramString.wZT.ign);
            QrRewardMainUI.h(QrRewardMainUI.this);
            QrRewardMainUI.i(QrRewardMainUI.this);
            QrRewardMainUI.j(QrRewardMainUI.this);
            if (QrRewardMainUI.k(QrRewardMainUI.this)) {
              break label267;
            }
            QrRewardMainUI.l(QrRewardMainUI.this);
          }
          for (;;)
          {
            QrRewardMainUI.f(QrRewardMainUI.this, paramString.wZT.OhN);
            QrRewardMainUI.dsj();
            Log.d("MicroMsg.QrRewardMainUI", "url: %s", new Object[] { QrRewardMainUI.o(QrRewardMainUI.this) });
            AppMethodBeat.o(63959);
            return;
            bool = false;
            break;
            label267:
            QrRewardMainUI.a(QrRewardMainUI.this, paramString.wZT.OhN, paramString.wZT.ZgF);
            QrRewardMainUI.m(QrRewardMainUI.this);
            QrRewardMainUI.n(QrRewardMainUI.this);
          }
        }
      }).b(new com.tencent.mm.plugin.collect.reward.a.a.a()
      {
        public final void g(com.tencent.mm.am.p paramAnonymousp)
        {
          boolean bool = true;
          AppMethodBeat.i(63958);
          Log.e("MicroMsg.QrRewardMainUI", "get code error: %s, %s", new Object[] { Integer.valueOf(paramString.wZT.hAV), paramString.wZT.wYI });
          if (paramString.wZT.hAV == 416)
          {
            if (paramString.wZT.Zgn == null) {}
            for (;;)
            {
              Log.d("MicroMsg.QrRewardMainUI", "realNameInfo:%s", new Object[] { Boolean.valueOf(bool) });
              QrRewardMainUI.g(QrRewardMainUI.this).setVisibility(4);
              paramAnonymousp = new Bundle();
              paramAnonymousp.putString("realname_verify_process_jump_activity", ".reward.ui.CollectMainUI");
              paramAnonymousp.putString("realname_verify_process_jump_plugin", "collect");
              QrRewardMainUI localQrRewardMainUI = QrRewardMainUI.this;
              int i = paramString.wZT.hAV;
              eme localeme = paramString.wZT.Zgn;
              new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(63957);
                  Log.i("MicroMsg.QrRewardMainUI", "RealnameVerifyUtil cancel");
                  AppMethodBeat.o(63957);
                }
              };
              com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(localQrRewardMainUI, i, localeme, paramAnonymousp, 1011);
              AppMethodBeat.o(63958);
              return;
              bool = false;
            }
          }
          if (!Util.isNullOrNil(paramString.wZT.wYI)) {
            Toast.makeText(QrRewardMainUI.this, paramString.wZT.wYI, 0).show();
          }
          if (!paramString.qmM) {
            QrRewardMainUI.b(QrRewardMainUI.this, false);
          }
          AppMethodBeat.o(63958);
        }
      }).c(new com.tencent.mm.plugin.collect.reward.a.a.a()
      {
        public final void g(com.tencent.mm.am.p paramAnonymousp)
        {
          AppMethodBeat.i(63956);
          Log.e("MicroMsg.QrRewardMainUI", "net error: %s", new Object[] { paramAnonymousp });
          if (!paramString.qmM) {
            QrRewardMainUI.b(QrRewardMainUI.this, false);
          }
          AppMethodBeat.o(63956);
        }
      });
      AppMethodBeat.o(63964);
      return true;
    }
    if ((paramp instanceof com.tencent.mm.plugin.collect.reward.a.h))
    {
      paramString = (com.tencent.mm.plugin.collect.reward.a.h)paramp;
      paramString.a(new com.tencent.mm.plugin.collect.reward.a.a.a()
      {
        public final void g(com.tencent.mm.am.p paramAnonymousp)
        {
          AppMethodBeat.i(63944);
          Log.i("MicroMsg.QrRewardMainUI", "set succ: %s, %s", new Object[] { paramString.vFa, QrRewardMainUI.a(QrRewardMainUI.this).getText() });
          if (paramString.vFa.equals(QrRewardMainUI.c(QrRewardMainUI.this)))
          {
            com.tencent.mm.kernel.h.baE().ban().set(at.a.acUb, QrRewardMainUI.c(QrRewardMainUI.this));
            QrRewardMainUI.n(QrRewardMainUI.this);
          }
          AppMethodBeat.o(63944);
        }
      }).b(new com.tencent.mm.plugin.collect.reward.a.a.a()
      {
        public final void g(com.tencent.mm.am.p paramAnonymousp)
        {
          AppMethodBeat.i(63943);
          Log.e("MicroMsg.QrRewardMainUI", "set word error: %s, %s", new Object[] { Integer.valueOf(paramString.wZZ.hAV), paramString.wZZ.wYI });
          QrRewardMainUI.a(QrRewardMainUI.this, (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acUb, ""));
          QrRewardMainUI.a(QrRewardMainUI.this, QrRewardMainUI.p(QrRewardMainUI.this));
          QrRewardMainUI.a(QrRewardMainUI.this).setText("");
          QrRewardMainUI.n(QrRewardMainUI.this);
          if (!Util.isNullOrNil(paramString.wZZ.wYI)) {
            Toast.makeText(QrRewardMainUI.this, paramString.wZZ.wYI, 0).show();
          }
          AppMethodBeat.o(63943);
        }
      }).c(new com.tencent.mm.plugin.collect.reward.a.a.a()
      {
        public final void g(com.tencent.mm.am.p paramAnonymousp)
        {
          AppMethodBeat.i(63960);
          Log.e("MicroMsg.QrRewardMainUI", "net error: %s", new Object[] { paramAnonymousp });
          QrRewardMainUI.a(QrRewardMainUI.this, (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acUb, ""));
          QrRewardMainUI.a(QrRewardMainUI.this, QrRewardMainUI.p(QrRewardMainUI.this));
          QrRewardMainUI.a(QrRewardMainUI.this).setText("");
          QrRewardMainUI.n(QrRewardMainUI.this);
          AppMethodBeat.o(63960);
        }
      });
      this.xaP.clearFocus();
      this.xaP.setCursorVisible(false);
    }
    AppMethodBeat.o(63964);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI
 * JD-Core Version:    0.7.0.1
 */