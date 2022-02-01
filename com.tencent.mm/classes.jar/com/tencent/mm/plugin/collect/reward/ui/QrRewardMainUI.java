package com.tencent.mm.plugin.collect.reward.ui;

import android.app.Activity;
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
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.plugin.collect.reward.a.b;
import com.tencent.mm.plugin.wallet_core.ui.q.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.protocal.protobuf.dju;
import com.tencent.mm.protocal.protobuf.wb;
import com.tencent.mm.protocal.protobuf.wt;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.wallet_core.ui.f;
import java.util.Map;

public class QrRewardMainUI
  extends QrRewardBaseUI
{
  private String desc;
  private String ega;
  private int iconWidth;
  private TextView jVn;
  private String lRD;
  private boolean mIsOpen;
  private ScrollView qyA;
  private String qyB;
  private String qyC;
  private String qyD;
  private int qyE;
  private boolean qyF;
  private boolean qyG;
  private final int qyn;
  private RelativeLayout qyo;
  private Button qyp;
  private ViewGroup qyq;
  private ViewGroup qyr;
  private RelativeLayout qys;
  private CdnImageView qyt;
  private ImageView qyu;
  private ImageView qyv;
  private MMEditText qyw;
  private TextView qyx;
  private TextView qyy;
  private TextView qyz;
  private String username;
  
  public QrRewardMainUI()
  {
    AppMethodBeat.i(63961);
    this.qyn = com.tencent.mm.cb.a.fromDPToPix(getContext(), 200);
    this.mIsOpen = false;
    AppMethodBeat.o(63961);
  }
  
  private void cAa()
  {
    AppMethodBeat.i(63972);
    czY();
    czZ();
    kO(Util.isNullOrNil(this.qyB));
    AppMethodBeat.o(63972);
  }
  
  private void cAb()
  {
    AppMethodBeat.i(63973);
    if (!Util.isNullOrNil(this.qyC))
    {
      this.qyy.setClickable(true);
      this.qyy.setOnTouchListener(new o(this));
      com.tencent.mm.plugin.wallet_core.ui.q localq = new com.tencent.mm.plugin.wallet_core.ui.q(new q.a()
      {
        public final void dF(View paramAnonymousView)
        {
          AppMethodBeat.i(63949);
          Log.d("MicroMsg.QrRewardMainUI", "go to: %s", new Object[] { QrRewardMainUI.r(QrRewardMainUI.this) });
          f.o(QrRewardMainUI.this.getContext(), QrRewardMainUI.r(QrRewardMainUI.this), false);
          com.tencent.mm.plugin.report.service.h.CyF.a(14721, new Object[] { Integer.valueOf(1), Integer.valueOf(6) });
          AppMethodBeat.o(63949);
        }
      });
      SpannableString localSpannableString = new SpannableString(this.qyC);
      localSpannableString.setSpan(localq, 0, localSpannableString.length(), 18);
      this.qyy.setText(localSpannableString);
      this.qyy.setVisibility(0);
      AppMethodBeat.o(63973);
      return;
    }
    this.qyy.setVisibility(8);
    AppMethodBeat.o(63973);
  }
  
  private void cAc()
  {
    AppMethodBeat.i(63975);
    if (!Util.isNullOrNil(this.qyB))
    {
      this.qyw.setText(l.b(getContext(), this.qyB, this.qyw.getTextSize()));
      this.qyw.setSelection(this.qyB.length());
    }
    AppMethodBeat.o(63975);
  }
  
  private void cAd()
  {
    AppMethodBeat.i(63976);
    Log.i("MicroMsg.QrRewardMainUI", "do set photo word");
    com.tencent.mm.plugin.collect.reward.a.h localh = new com.tencent.mm.plugin.collect.reward.a.h(this.qyB);
    localh.M(this);
    doSceneProgress(localh, true);
    AppMethodBeat.o(63976);
  }
  
  private void czX()
  {
    AppMethodBeat.i(63969);
    if (com.tencent.mm.plugin.collect.reward.b.a.czR().czS())
    {
      this.qyt.aM(com.tencent.mm.plugin.collect.reward.b.a.czR().czU(), this.qyn, this.qyn);
      this.qys.setVisibility(0);
      AppMethodBeat.o(63969);
      return;
    }
    this.qys.setVisibility(4);
    AppMethodBeat.o(63969);
  }
  
  private void czY()
  {
    AppMethodBeat.i(63970);
    int j = Math.round(this.qyn * (this.iconWidth * 1.0F / this.qyE));
    int i = j;
    if (j <= 0) {
      i = 248;
    }
    ViewGroup.LayoutParams localLayoutParams = this.qyv.getLayoutParams();
    localLayoutParams.width = i;
    localLayoutParams.height = i;
    this.qyv.setLayoutParams(localLayoutParams);
    localLayoutParams = this.qyu.getLayoutParams();
    localLayoutParams.width = i;
    localLayoutParams.height = i;
    this.qyu.setLayoutParams(localLayoutParams);
    localLayoutParams = this.qyw.getLayoutParams();
    localLayoutParams.width = (i - 30);
    localLayoutParams.height = (i - 30);
    this.qyw.setLayoutParams(localLayoutParams);
    this.qyw.setTextSize(0, i * 2 / 3);
    this.qyr.requestLayout();
    AppMethodBeat.o(63970);
  }
  
  private void czZ()
  {
    AppMethodBeat.i(63971);
    if (!Util.isNullOrNil(this.desc))
    {
      this.jVn.setText(l.b(this, getString(2131764135, new Object[] { this.desc }), this.jVn.getTextSize()));
      AppMethodBeat.o(63971);
      return;
    }
    this.jVn.setText("");
    AppMethodBeat.o(63971);
  }
  
  private void kO(boolean paramBoolean)
  {
    AppMethodBeat.i(63974);
    Log.i("MicroMsg.QrRewardMainUI", "switch mode: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.qyu.setVisibility(0);
      this.qyw.setVisibility(4);
      a.b.a(this.qyu, this.username, 0.03F, true);
      AppMethodBeat.o(63974);
      return;
    }
    this.qyu.setVisibility(4);
    this.qyw.setVisibility(0);
    AppMethodBeat.o(63974);
  }
  
  private void n(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(63968);
    if ((this.lRD != null) && (this.lRD.equals(paramString1))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = com.tencent.mm.plugin.collect.reward.b.a.czR().czS();
      Log.i("MicroMsg.QrRewardMainUI", "do download photo: %s, same url: %s, pic exist: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((paramBoolean) || (!bool1) || (!bool2)) {
        com.tencent.mm.plugin.collect.reward.b.a.czR().a(paramString1, paramString2, new com.tencent.mm.plugin.collect.reward.b.a.a()
        {
          public final void Y(String paramAnonymousString, int paramAnonymousInt1, int paramAnonymousInt2)
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
    return 2131496005;
  }
  
  public void initView()
  {
    AppMethodBeat.i(63963);
    this.qyo = ((RelativeLayout)findViewById(2131307168));
    this.qyp = ((Button)findViewById(2131306425));
    this.qyq = ((ViewGroup)findViewById(2131306424));
    this.qyr = ((ViewGroup)findViewById(2131306423));
    this.qyt = ((CdnImageView)findViewById(2131306418));
    this.jVn = ((TextView)findViewById(2131306422));
    this.qyu = ((ImageView)findViewById(2131306417));
    this.qyv = ((ImageView)findViewById(2131306416));
    this.qys = ((RelativeLayout)findViewById(2131306419));
    this.qyw = ((MMEditText)findViewById(2131306420));
    this.qyx = ((TextView)findViewById(2131306427));
    this.qyz = ((TextView)findViewById(2131306430));
    this.qyy = ((TextView)findViewById(2131306415));
    a.b.a(this.qyu, this.username, 0.03F, true);
    try
    {
      this.qyw.setText(l.b(getContext(), this.qyB, this.qyw.getTextSize()));
      this.qyw.setSelection(this.qyB.length());
      this.qyw.addTextChangedListener(new QrRewardMainUI.1(this));
      this.qyw.setOnEditorActionListener(new TextView.OnEditorActionListener()
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
      this.qyv.setOnClickListener(new QrRewardMainUI.11(this));
      this.qyx.setClickable(true);
      this.qyx.setOnTouchListener(new o(this));
      com.tencent.mm.plugin.wallet_core.ui.q localq = new com.tencent.mm.plugin.wallet_core.ui.q(new q.a()
      {
        public final void dF(View paramAnonymousView)
        {
          AppMethodBeat.i(63954);
          Log.i("MicroMsg.QrRewardMainUI", "click save code");
          p.a(QrRewardMainUI.this, new Runnable()new Runnable
          {
            public final void run()
            {
              AppMethodBeat.i(213160);
              QrRewardMainUI.e(QrRewardMainUI.this);
              com.tencent.mm.plugin.report.service.h.CyF.a(14721, new Object[] { Integer.valueOf(1), Integer.valueOf(5) });
              AppMethodBeat.o(213160);
            }
          }, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(213161);
              Toast.makeText(QrRewardMainUI.this, 2131764864, 1).show();
              AppMethodBeat.o(213161);
            }
          });
          AppMethodBeat.o(63954);
        }
      });
      SpannableString localSpannableString = new SpannableString(getString(2131764122));
      localSpannableString.setSpan(localq, 0, localSpannableString.length(), 18);
      this.qyx.setText(localSpannableString);
      this.qyz.setClickable(true);
      this.qyz.setOnTouchListener(new o(this));
      localq = new com.tencent.mm.plugin.wallet_core.ui.q(new QrRewardMainUI.13(this));
      localSpannableString = new SpannableString(getString(2131764132));
      localSpannableString.setSpan(localq, 0, localSpannableString.length(), 18);
      this.qyz.setText(localSpannableString);
      czX();
      cAa();
      cAc();
      cAb();
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
        this.qyE = paramIntent.getIntExtra("key_photo_width", 900);
        this.iconWidth = paramIntent.getIntExtra("key_icon_width", 343);
        boolean bool = paramIntent.getBooleanExtra("key_return_from_first", true);
        Log.i("MicroMsg.QrRewardMainUI", "return from first: %s", new Object[] { Boolean.valueOf(bool) });
        if (bool)
        {
          this.qyr.setVisibility(0);
          this.qyq.setVisibility(8);
        }
        this.qyG = true;
        cAa();
        String str = paramIntent.getStringExtra("key_photo_url");
        n(str, paramIntent.getStringExtra("key_photo_aeskey"), true);
        this.lRD = str;
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
    this.qyE = ((Integer)g.aAh().azQ().get(ar.a.Oej, Integer.valueOf(900))).intValue();
    this.iconWidth = ((Integer)g.aAh().azQ().get(ar.a.Oek, Integer.valueOf(343))).intValue();
    this.desc = ((String)g.aAh().azQ().get(ar.a.Oem, ""));
    this.qyB = ((String)g.aAh().azQ().get(ar.a.Oel, ""));
    this.qyC = ((String)g.aAh().azQ().get(ar.a.Oeq, ""));
    this.qyD = ((String)g.aAh().azQ().get(ar.a.Oer, ""));
    this.lRD = ((String)g.aAh().azQ().get(ar.a.Oes, ""));
    if (!Util.isNullOrNil((String)g.aAh().azQ().get(ar.a.Oep, ""))) {
      this.qyG = true;
    }
    this.username = z.aTY();
    setMMTitle(2131764117);
    initView();
    if ((com.tencent.mm.plugin.collect.reward.b.a.czR().czS()) && (this.qyG)) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.QrRewardMainUI", "do get code: %s", new Object[] { Boolean.valueOf(bool) });
      paramBundle = new b(bool);
      paramBundle.M(this);
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
    com.tencent.mm.plugin.collect.reward.b.a locala = com.tencent.mm.plugin.collect.reward.b.a.czR();
    Log.d("MicroMsg.QrRewardCdnDownloadHelper", "do clear callback");
    if (locala.oPn != null)
    {
      Log.i("MicroMsg.QrRewardCdnDownloadHelper", "callback size: %s", new Object[] { Integer.valueOf(locala.oPn.size()) });
      locala.oPn.clear();
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
      this.qyB = this.qyw.getText().toString();
      cAd();
      if (Util.isNullOrNil(this.qyB)) {
        kO(true);
      }
    }
    AppMethodBeat.o(63965);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(63964);
    if ((paramq instanceof b))
    {
      paramString = (b)paramq;
      paramString.a(new com.tencent.mm.plugin.collect.reward.a.a.a()
      {
        public final void g(com.tencent.mm.ak.q paramAnonymousq)
        {
          AppMethodBeat.i(63959);
          QrRewardMainUI.a(QrRewardMainUI.this, paramString.qxA.pqv);
          QrRewardMainUI.a(QrRewardMainUI.this, paramString.qxA.Lhq);
          QrRewardMainUI.b(QrRewardMainUI.this, paramString.qxA.Lhm);
          QrRewardMainUI.b(QrRewardMainUI.this, paramString.qxA.desc);
          QrRewardMainUI.c(QrRewardMainUI.this, paramString.qxA.HTZ);
          paramAnonymousq = QrRewardMainUI.this;
          boolean bool;
          if (!paramString.qxA.Lhk)
          {
            bool = true;
            QrRewardMainUI.c(paramAnonymousq, bool);
            QrRewardMainUI.d(QrRewardMainUI.this, paramString.qxA.pTK);
            QrRewardMainUI.e(QrRewardMainUI.this, paramString.qxA.Lho);
            QrRewardMainUI.h(QrRewardMainUI.this);
            QrRewardMainUI.i(QrRewardMainUI.this);
            if (QrRewardMainUI.j(QrRewardMainUI.this)) {
              break label242;
            }
            QrRewardMainUI.k(QrRewardMainUI.this);
          }
          for (;;)
          {
            QrRewardMainUI.f(QrRewardMainUI.this, paramString.qxA.Cog);
            QrRewardMainUI.cAe();
            Log.d("MicroMsg.QrRewardMainUI", "url: %s", new Object[] { QrRewardMainUI.n(QrRewardMainUI.this) });
            AppMethodBeat.o(63959);
            return;
            bool = false;
            break;
            label242:
            QrRewardMainUI.a(QrRewardMainUI.this, paramString.qxA.Cog, paramString.qxA.Lhl);
            QrRewardMainUI.l(QrRewardMainUI.this);
            QrRewardMainUI.m(QrRewardMainUI.this);
          }
        }
      }).b(new com.tencent.mm.plugin.collect.reward.a.a.a()
      {
        public final void g(com.tencent.mm.ak.q paramAnonymousq)
        {
          boolean bool = true;
          AppMethodBeat.i(63958);
          Log.e("MicroMsg.QrRewardMainUI", "get code error: %s, %s", new Object[] { Integer.valueOf(paramString.qxA.dDN), paramString.qxA.qwn });
          if (paramString.qxA.dDN == 416)
          {
            if (paramString.qxA.LgT == null) {}
            for (;;)
            {
              Log.d("MicroMsg.QrRewardMainUI", "realNameInfo:%s", new Object[] { Boolean.valueOf(bool) });
              QrRewardMainUI.g(QrRewardMainUI.this).setVisibility(4);
              paramAnonymousq = new Bundle();
              paramAnonymousq.putString("realname_verify_process_jump_activity", ".reward.ui.CollectMainUI");
              paramAnonymousq.putString("realname_verify_process_jump_plugin", "collect");
              QrRewardMainUI localQrRewardMainUI = QrRewardMainUI.this;
              int i = paramString.qxA.dDN;
              dju localdju = paramString.qxA.LgT;
              new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(63957);
                  Log.i("MicroMsg.QrRewardMainUI", "RealnameVerifyUtil cancel");
                  AppMethodBeat.o(63957);
                }
              };
              com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(localQrRewardMainUI, i, localdju, paramAnonymousq, 1011);
              AppMethodBeat.o(63958);
              return;
              bool = false;
            }
          }
          if (!Util.isNullOrNil(paramString.qxA.qwn)) {
            Toast.makeText(QrRewardMainUI.this, paramString.qxA.qwn, 0).show();
          }
          if (!paramString.qxB) {
            QrRewardMainUI.b(QrRewardMainUI.this, false);
          }
          AppMethodBeat.o(63958);
        }
      }).c(new com.tencent.mm.plugin.collect.reward.a.a.a()
      {
        public final void g(com.tencent.mm.ak.q paramAnonymousq)
        {
          AppMethodBeat.i(63956);
          Log.e("MicroMsg.QrRewardMainUI", "net error: %s", new Object[] { paramAnonymousq });
          if (!paramString.qxB) {
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
        public final void g(com.tencent.mm.ak.q paramAnonymousq)
        {
          AppMethodBeat.i(63944);
          Log.i("MicroMsg.QrRewardMainUI", "set succ: %s, %s", new Object[] { paramString.pqv, QrRewardMainUI.a(QrRewardMainUI.this).getText() });
          if (paramString.pqv.equals(QrRewardMainUI.c(QrRewardMainUI.this)))
          {
            g.aAh().azQ().set(ar.a.Oel, QrRewardMainUI.c(QrRewardMainUI.this));
            QrRewardMainUI.m(QrRewardMainUI.this);
          }
          AppMethodBeat.o(63944);
        }
      }).b(new com.tencent.mm.plugin.collect.reward.a.a.a()
      {
        public final void g(com.tencent.mm.ak.q paramAnonymousq)
        {
          AppMethodBeat.i(63943);
          Log.e("MicroMsg.QrRewardMainUI", "set word error: %s, %s", new Object[] { Integer.valueOf(paramString.qxH.dDN), paramString.qxH.qwn });
          QrRewardMainUI.a(QrRewardMainUI.this, (String)g.aAh().azQ().get(ar.a.Oel, ""));
          QrRewardMainUI.a(QrRewardMainUI.this, QrRewardMainUI.o(QrRewardMainUI.this));
          QrRewardMainUI.a(QrRewardMainUI.this).setText("");
          QrRewardMainUI.m(QrRewardMainUI.this);
          if (!Util.isNullOrNil(paramString.qxH.qwn)) {
            Toast.makeText(QrRewardMainUI.this, paramString.qxH.qwn, 0).show();
          }
          AppMethodBeat.o(63943);
        }
      }).c(new com.tencent.mm.plugin.collect.reward.a.a.a()
      {
        public final void g(com.tencent.mm.ak.q paramAnonymousq)
        {
          AppMethodBeat.i(63960);
          Log.e("MicroMsg.QrRewardMainUI", "net error: %s", new Object[] { paramAnonymousq });
          QrRewardMainUI.a(QrRewardMainUI.this, (String)g.aAh().azQ().get(ar.a.Oel, ""));
          QrRewardMainUI.a(QrRewardMainUI.this, QrRewardMainUI.o(QrRewardMainUI.this));
          QrRewardMainUI.a(QrRewardMainUI.this).setText("");
          QrRewardMainUI.m(QrRewardMainUI.this);
          AppMethodBeat.o(63960);
        }
      });
      this.qyw.clearFocus();
      this.qyw.setCursorVisible(false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI
 * JD-Core Version:    0.7.0.1
 */