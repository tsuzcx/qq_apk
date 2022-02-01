package com.tencent.mm.plugin.collect.reward.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
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
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.plugin.wallet_core.ui.r;
import com.tencent.mm.plugin.wallet_core.ui.r.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.dtj;
import com.tencent.mm.protocal.protobuf.wd;
import com.tencent.mm.protocal.protobuf.wx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.wallet_core.ui.g;
import java.util.Map;

public class QrRewardMainUI
  extends QrRewardBaseUI
{
  private String desc;
  private String gaq;
  private int iconWidth;
  private boolean mIsOpen;
  private TextView mMA;
  private String oOi;
  private ScrollView tXA;
  private String tXB;
  private String tXC;
  private String tXD;
  private int tXE;
  private boolean tXF;
  private boolean tXG;
  private final int tXn;
  private RelativeLayout tXo;
  private Button tXp;
  private ViewGroup tXq;
  private ViewGroup tXr;
  private RelativeLayout tXs;
  private CdnImageView tXt;
  private ImageView tXu;
  private ImageView tXv;
  private MMEditText tXw;
  private TextView tXx;
  private TextView tXy;
  private TextView tXz;
  private String username;
  
  public QrRewardMainUI()
  {
    AppMethodBeat.i(63961);
    this.tXn = com.tencent.mm.ci.a.fromDPToPix(getContext(), 200);
    this.mIsOpen = false;
    AppMethodBeat.o(63961);
  }
  
  private void cOA()
  {
    AppMethodBeat.i(63972);
    cOy();
    cOz();
    ma(Util.isNullOrNil(this.tXB));
    AppMethodBeat.o(63972);
  }
  
  private void cOB()
  {
    AppMethodBeat.i(63973);
    if (!Util.isNullOrNil(this.tXC))
    {
      this.tXy.setClickable(true);
      this.tXy.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.o(this));
      r localr = new r(new r.a()
      {
        public final void ed(View paramAnonymousView)
        {
          AppMethodBeat.i(63949);
          Log.d("MicroMsg.QrRewardMainUI", "go to: %s", new Object[] { QrRewardMainUI.r(QrRewardMainUI.this) });
          g.o(QrRewardMainUI.this.getContext(), QrRewardMainUI.r(QrRewardMainUI.this), false);
          com.tencent.mm.plugin.report.service.h.IzE.a(14721, new Object[] { Integer.valueOf(1), Integer.valueOf(6) });
          AppMethodBeat.o(63949);
        }
      });
      SpannableString localSpannableString = new SpannableString(this.tXC);
      localSpannableString.setSpan(localr, 0, localSpannableString.length(), 18);
      this.tXy.setText(localSpannableString);
      this.tXy.setVisibility(0);
      AppMethodBeat.o(63973);
      return;
    }
    this.tXy.setVisibility(8);
    AppMethodBeat.o(63973);
  }
  
  private void cOC()
  {
    AppMethodBeat.i(63975);
    if (!Util.isNullOrNil(this.tXB))
    {
      this.tXw.setText(l.b(getContext(), this.tXB, this.tXw.getTextSize()));
      this.tXw.setSelection(this.tXB.length());
    }
    AppMethodBeat.o(63975);
  }
  
  private void cOD()
  {
    AppMethodBeat.i(63976);
    Log.i("MicroMsg.QrRewardMainUI", "do set photo word");
    com.tencent.mm.plugin.collect.reward.a.h localh = new com.tencent.mm.plugin.collect.reward.a.h(this.tXB);
    localh.N(this);
    doSceneProgress(localh, true);
    AppMethodBeat.o(63976);
  }
  
  private void cOx()
  {
    AppMethodBeat.i(63969);
    if (com.tencent.mm.plugin.collect.reward.b.a.cOr().cOs())
    {
      this.tXt.aO(com.tencent.mm.plugin.collect.reward.b.a.cOr().cOu(), this.tXn, this.tXn);
      this.tXs.setVisibility(0);
      AppMethodBeat.o(63969);
      return;
    }
    this.tXs.setVisibility(4);
    AppMethodBeat.o(63969);
  }
  
  private void cOy()
  {
    AppMethodBeat.i(63970);
    int j = Math.round(this.tXn * (this.iconWidth * 1.0F / this.tXE));
    int i = j;
    if (j <= 0) {
      i = 248;
    }
    ViewGroup.LayoutParams localLayoutParams = this.tXv.getLayoutParams();
    localLayoutParams.width = i;
    localLayoutParams.height = i;
    this.tXv.setLayoutParams(localLayoutParams);
    localLayoutParams = this.tXu.getLayoutParams();
    localLayoutParams.width = i;
    localLayoutParams.height = i;
    this.tXu.setLayoutParams(localLayoutParams);
    localLayoutParams = this.tXw.getLayoutParams();
    localLayoutParams.width = (i - 30);
    localLayoutParams.height = (i - 30);
    this.tXw.setLayoutParams(localLayoutParams);
    this.tXw.setTextSize(0, i * 2 / 3);
    this.tXr.requestLayout();
    AppMethodBeat.o(63970);
  }
  
  private void cOz()
  {
    AppMethodBeat.i(63971);
    if (!Util.isNullOrNil(this.desc))
    {
      this.mMA.setText(l.b(this, getString(a.i.qr_reward_wrap_text, new Object[] { this.desc }), this.mMA.getTextSize()));
      AppMethodBeat.o(63971);
      return;
    }
    this.mMA.setText("");
    AppMethodBeat.o(63971);
  }
  
  private void ma(boolean paramBoolean)
  {
    AppMethodBeat.i(63974);
    Log.i("MicroMsg.QrRewardMainUI", "switch mode: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.tXu.setVisibility(0);
      this.tXw.setVisibility(4);
      a.b.a(this.tXu, this.username, 0.03F, true);
      AppMethodBeat.o(63974);
      return;
    }
    this.tXu.setVisibility(4);
    this.tXw.setVisibility(0);
    AppMethodBeat.o(63974);
  }
  
  private void o(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(63968);
    if ((this.oOi != null) && (this.oOi.equals(paramString1))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = com.tencent.mm.plugin.collect.reward.b.a.cOr().cOs();
      Log.i("MicroMsg.QrRewardMainUI", "do download photo: %s, same url: %s, pic exist: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((paramBoolean) || (!bool1) || (!bool2)) {
        com.tencent.mm.plugin.collect.reward.b.a.cOr().a(paramString1, paramString2, new com.tencent.mm.plugin.collect.reward.b.a.a()
        {
          public final void aa(String paramAnonymousString, int paramAnonymousInt1, int paramAnonymousInt2)
          {
            AppMethodBeat.i(63948);
            Log.i("MicroMsg.QrRewardMainUI", "callback ret: %s, %s, %s", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
            if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0)) {
              MMHandlerThread.postToMainThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(63947);
                  QrRewardMainUI.q(QrRewardMainUI.this);
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
    this.tXo = ((RelativeLayout)findViewById(a.f.root_rl));
    this.tXp = ((Button)findViewById(a.f.qrmu_open_reward_btn));
    this.tXq = ((ViewGroup)findViewById(a.f.qrmu_no_code_layout));
    this.tXr = ((ViewGroup)findViewById(a.f.qrmu_main_layout));
    this.tXt = ((CdnImageView)findViewById(a.f.qrmu_code_iv));
    this.mMA = ((TextView)findViewById(a.f.qrmu_desc_tv));
    this.tXu = ((ImageView)findViewById(a.f.qrmu_code_avatar_iv));
    this.tXv = ((ImageView)findViewById(a.f.qrmu_code_avatar_border_iv));
    this.tXs = ((RelativeLayout)findViewById(a.f.qrmu_code_layout));
    this.tXw = ((MMEditText)findViewById(a.f.qrmu_code_word_et));
    this.tXx = ((TextView)findViewById(a.f.qrmu_save_code_tv));
    this.tXz = ((TextView)findViewById(a.f.qrmu_set_code_tv));
    this.tXy = ((TextView)findViewById(a.f.qrmu_bottom_tv));
    a.b.a(this.tXu, this.username, 0.03F, true);
    try
    {
      this.tXw.setText(l.b(getContext(), this.tXB, this.tXw.getTextSize()));
      this.tXw.setSelection(this.tXB.length());
      this.tXw.addTextChangedListener(new TextWatcher()
      {
        int tXH = 0;
        
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(63942);
          Log.d("MicroMsg.QrRewardMainUI", "s: %s, %s", new Object[] { paramAnonymousEditable.toString(), Integer.valueOf(paramAnonymousEditable.length()) });
          String str = paramAnonymousEditable.toString();
          if (Util.isNullOrNil(str)) {
            this.tXH = 0;
          }
          for (;;)
          {
            paramAnonymousEditable.delete(this.tXH, paramAnonymousEditable.length());
            AppMethodBeat.o(63942);
            return;
            if (this.tXH == 0) {
              if ((((com.tencent.mm.plugin.emoji.b.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.emoji.b.a.class)).V(str)) || (((com.tencent.mm.plugin.emoji.b.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.emoji.b.a.class)).W(str))) {
                this.tXH = paramAnonymousEditable.length();
              } else {
                this.tXH = 1;
              }
            }
          }
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.tXw.setOnEditorActionListener(new TextView.OnEditorActionListener()
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
      this.tXv.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(63953);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/collect/reward/ui/QrRewardMainUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          Log.d("MicroMsg.QrRewardMainUI", "click avatar");
          QrRewardMainUI.this.hideVKB();
          QrRewardMainUI.d(QrRewardMainUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/reward/ui/QrRewardMainUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(63953);
        }
      });
      this.tXx.setClickable(true);
      this.tXx.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.o(this));
      r localr = new r(new r.a()
      {
        public final void ed(View paramAnonymousView)
        {
          AppMethodBeat.i(63954);
          Log.i("MicroMsg.QrRewardMainUI", "click save code");
          p.a(QrRewardMainUI.this, new Runnable()new Runnable
          {
            public final void run()
            {
              AppMethodBeat.i(187518);
              QrRewardMainUI.e(QrRewardMainUI.this);
              com.tencent.mm.plugin.report.service.h.IzE.a(14721, new Object[] { Integer.valueOf(1), Integer.valueOf(5) });
              AppMethodBeat.o(187518);
            }
          }, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(277408);
              Toast.makeText(QrRewardMainUI.this, a.i.save_image_err, 1).show();
              AppMethodBeat.o(277408);
            }
          });
          AppMethodBeat.o(63954);
        }
      });
      SpannableString localSpannableString = new SpannableString(getString(a.i.qr_reward_save_code_btn_text));
      localSpannableString.setSpan(localr, 0, localSpannableString.length(), 18);
      this.tXx.setText(localSpannableString);
      this.tXz.setClickable(true);
      this.tXz.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.o(this));
      localr = new r(new r.a()
      {
        public final void ed(View paramAnonymousView)
        {
          AppMethodBeat.i(63955);
          Log.i("MicroMsg.QrRewardMainUI", "click set code, %s", new Object[] { Boolean.valueOf(QrRewardMainUI.f(QrRewardMainUI.this)) });
          QrRewardMainUI.b(QrRewardMainUI.this, false);
          AppMethodBeat.o(63955);
        }
      });
      localSpannableString = new SpannableString(getString(a.i.qr_reward_set_money_title));
      localSpannableString.setSpan(localr, 0, localSpannableString.length(), 18);
      this.tXz.setText(localSpannableString);
      cOx();
      cOA();
      cOC();
      cOB();
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
        this.tXE = paramIntent.getIntExtra("key_photo_width", 900);
        this.iconWidth = paramIntent.getIntExtra("key_icon_width", 343);
        boolean bool = paramIntent.getBooleanExtra("key_return_from_first", true);
        Log.i("MicroMsg.QrRewardMainUI", "return from first: %s", new Object[] { Boolean.valueOf(bool) });
        if (bool)
        {
          this.tXr.setVisibility(0);
          this.tXq.setVisibility(8);
        }
        this.tXG = true;
        cOA();
        String str = paramIntent.getStringExtra("key_photo_url");
        o(str, paramIntent.getStringExtra("key_photo_aeskey"), true);
        this.oOi = str;
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
    this.tXE = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vsu, Integer.valueOf(900))).intValue();
    this.iconWidth = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vsv, Integer.valueOf(343))).intValue();
    this.desc = ((String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vsx, ""));
    this.tXB = ((String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vsw, ""));
    this.tXC = ((String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VsB, ""));
    this.tXD = ((String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VsC, ""));
    this.oOi = ((String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VsD, ""));
    if (!Util.isNullOrNil((String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VsA, ""))) {
      this.tXG = true;
    }
    this.username = z.bcZ();
    setMMTitle(a.i.qr_reward_main_title);
    initView();
    if ((com.tencent.mm.plugin.collect.reward.b.a.cOr().cOs()) && (this.tXG)) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.QrRewardMainUI", "do get code: %s", new Object[] { Boolean.valueOf(bool) });
      paramBundle = new com.tencent.mm.plugin.collect.reward.a.b(bool);
      paramBundle.N(this);
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
    com.tencent.mm.plugin.collect.reward.b.a locala = com.tencent.mm.plugin.collect.reward.b.a.cOr();
    Log.d("MicroMsg.QrRewardCdnDownloadHelper", "do clear callback");
    if (locala.rRk != null)
    {
      Log.i("MicroMsg.QrRewardCdnDownloadHelper", "callback size: %s", new Object[] { Integer.valueOf(locala.rRk.size()) });
      locala.rRk.clear();
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
      this.tXB = this.tXw.getText().toString();
      cOD();
      if (Util.isNullOrNil(this.tXB)) {
        ma(true);
      }
    }
    AppMethodBeat.o(63965);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, q paramq)
  {
    AppMethodBeat.i(63964);
    if ((paramq instanceof com.tencent.mm.plugin.collect.reward.a.b))
    {
      paramString = (com.tencent.mm.plugin.collect.reward.a.b)paramq;
      paramString.a(new com.tencent.mm.plugin.collect.reward.a.a.a()
      {
        public final void g(q paramAnonymousq)
        {
          AppMethodBeat.i(63959);
          QrRewardMainUI.a(QrRewardMainUI.this, paramString.tWA.szv);
          QrRewardMainUI.a(QrRewardMainUI.this, paramString.tWA.SiE);
          QrRewardMainUI.b(QrRewardMainUI.this, paramString.tWA.SiA);
          QrRewardMainUI.b(QrRewardMainUI.this, paramString.tWA.desc);
          QrRewardMainUI.c(QrRewardMainUI.this, paramString.tWA.OMa);
          paramAnonymousq = QrRewardMainUI.this;
          boolean bool;
          if (!paramString.tWA.Siy)
          {
            bool = true;
            QrRewardMainUI.c(paramAnonymousq, bool);
            QrRewardMainUI.d(QrRewardMainUI.this, paramString.tWA.tpM);
            QrRewardMainUI.e(QrRewardMainUI.this, paramString.tWA.SiC);
            QrRewardMainUI.h(QrRewardMainUI.this);
            QrRewardMainUI.i(QrRewardMainUI.this);
            if (QrRewardMainUI.j(QrRewardMainUI.this)) {
              break label242;
            }
            QrRewardMainUI.k(QrRewardMainUI.this);
          }
          for (;;)
          {
            QrRewardMainUI.f(QrRewardMainUI.this, paramString.tWA.IkZ);
            QrRewardMainUI.cOE();
            Log.d("MicroMsg.QrRewardMainUI", "url: %s", new Object[] { QrRewardMainUI.n(QrRewardMainUI.this) });
            AppMethodBeat.o(63959);
            return;
            bool = false;
            break;
            label242:
            QrRewardMainUI.a(QrRewardMainUI.this, paramString.tWA.IkZ, paramString.tWA.Siz);
            QrRewardMainUI.l(QrRewardMainUI.this);
            QrRewardMainUI.m(QrRewardMainUI.this);
          }
        }
      }).b(new com.tencent.mm.plugin.collect.reward.a.a.a()
      {
        public final void g(q paramAnonymousq)
        {
          boolean bool = true;
          AppMethodBeat.i(63958);
          Log.e("MicroMsg.QrRewardMainUI", "get code error: %s, %s", new Object[] { Integer.valueOf(paramString.tWA.fwx), paramString.tWA.tVo });
          if (paramString.tWA.fwx == 416)
          {
            if (paramString.tWA.Sih == null) {}
            for (;;)
            {
              Log.d("MicroMsg.QrRewardMainUI", "realNameInfo:%s", new Object[] { Boolean.valueOf(bool) });
              QrRewardMainUI.g(QrRewardMainUI.this).setVisibility(4);
              paramAnonymousq = new Bundle();
              paramAnonymousq.putString("realname_verify_process_jump_activity", ".reward.ui.CollectMainUI");
              paramAnonymousq.putString("realname_verify_process_jump_plugin", "collect");
              QrRewardMainUI localQrRewardMainUI = QrRewardMainUI.this;
              int i = paramString.tWA.fwx;
              dtj localdtj = paramString.tWA.Sih;
              new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(63957);
                  Log.i("MicroMsg.QrRewardMainUI", "RealnameVerifyUtil cancel");
                  AppMethodBeat.o(63957);
                }
              };
              com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(localQrRewardMainUI, i, localdtj, paramAnonymousq, 1011);
              AppMethodBeat.o(63958);
              return;
              bool = false;
            }
          }
          if (!Util.isNullOrNil(paramString.tWA.tVo)) {
            Toast.makeText(QrRewardMainUI.this, paramString.tWA.tVo, 0).show();
          }
          if (!paramString.tWB) {
            QrRewardMainUI.b(QrRewardMainUI.this, false);
          }
          AppMethodBeat.o(63958);
        }
      }).c(new com.tencent.mm.plugin.collect.reward.a.a.a()
      {
        public final void g(q paramAnonymousq)
        {
          AppMethodBeat.i(63956);
          Log.e("MicroMsg.QrRewardMainUI", "net error: %s", new Object[] { paramAnonymousq });
          if (!paramString.tWB) {
            QrRewardMainUI.b(QrRewardMainUI.this, false);
          }
          AppMethodBeat.o(63956);
        }
      });
      AppMethodBeat.o(63964);
      return true;
    }
    if ((paramq instanceof com.tencent.mm.plugin.collect.reward.a.h))
    {
      paramString = (com.tencent.mm.plugin.collect.reward.a.h)paramq;
      paramString.a(new com.tencent.mm.plugin.collect.reward.a.a.a()
      {
        public final void g(q paramAnonymousq)
        {
          AppMethodBeat.i(63944);
          Log.i("MicroMsg.QrRewardMainUI", "set succ: %s, %s", new Object[] { paramString.szv, QrRewardMainUI.a(QrRewardMainUI.this).getText() });
          if (paramString.szv.equals(QrRewardMainUI.c(QrRewardMainUI.this)))
          {
            com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vsw, QrRewardMainUI.c(QrRewardMainUI.this));
            QrRewardMainUI.m(QrRewardMainUI.this);
          }
          AppMethodBeat.o(63944);
        }
      }).b(new com.tencent.mm.plugin.collect.reward.a.a.a()
      {
        public final void g(q paramAnonymousq)
        {
          AppMethodBeat.i(63943);
          Log.e("MicroMsg.QrRewardMainUI", "set word error: %s, %s", new Object[] { Integer.valueOf(paramString.tWH.fwx), paramString.tWH.tVo });
          QrRewardMainUI.a(QrRewardMainUI.this, (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vsw, ""));
          QrRewardMainUI.a(QrRewardMainUI.this, QrRewardMainUI.o(QrRewardMainUI.this));
          QrRewardMainUI.a(QrRewardMainUI.this).setText("");
          QrRewardMainUI.m(QrRewardMainUI.this);
          if (!Util.isNullOrNil(paramString.tWH.tVo)) {
            Toast.makeText(QrRewardMainUI.this, paramString.tWH.tVo, 0).show();
          }
          AppMethodBeat.o(63943);
        }
      }).c(new com.tencent.mm.plugin.collect.reward.a.a.a()
      {
        public final void g(q paramAnonymousq)
        {
          AppMethodBeat.i(63960);
          Log.e("MicroMsg.QrRewardMainUI", "net error: %s", new Object[] { paramAnonymousq });
          QrRewardMainUI.a(QrRewardMainUI.this, (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vsw, ""));
          QrRewardMainUI.a(QrRewardMainUI.this, QrRewardMainUI.o(QrRewardMainUI.this));
          QrRewardMainUI.a(QrRewardMainUI.this).setText("");
          QrRewardMainUI.m(QrRewardMainUI.this);
          AppMethodBeat.o(63960);
        }
      });
      this.tXw.clearFocus();
      this.tXw.setCursorVisible(false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI
 * JD-Core Version:    0.7.0.1
 */