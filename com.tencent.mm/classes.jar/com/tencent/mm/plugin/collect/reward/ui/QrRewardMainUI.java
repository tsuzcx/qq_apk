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
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.plugin.wallet_core.ui.q.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.cma;
import com.tencent.mm.protocal.protobuf.sx;
import com.tencent.mm.protocal.protobuf.to;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.Map;

public class QrRewardMainUI
  extends QrRewardBaseUI
{
  private String dAC;
  private String desc;
  private int drN;
  private String kow;
  private TextView lgw;
  private boolean mIsOpen;
  private final int ozb;
  private RelativeLayout ozc;
  private Button ozd;
  private ViewGroup oze;
  private ViewGroup ozf;
  private RelativeLayout ozg;
  private CdnImageView ozh;
  private ImageView ozi;
  private ImageView ozj;
  private MMEditText ozk;
  private TextView ozl;
  private TextView ozm;
  private TextView ozn;
  private ScrollView ozo;
  private String ozp;
  private String ozq;
  private String ozr;
  private int ozs;
  private boolean ozt;
  private boolean ozu;
  private String username;
  
  public QrRewardMainUI()
  {
    AppMethodBeat.i(63961);
    this.ozb = com.tencent.mm.cc.a.fromDPToPix(getContext(), 200);
    this.mIsOpen = false;
    AppMethodBeat.o(63961);
  }
  
  private void bWl()
  {
    AppMethodBeat.i(63969);
    if (com.tencent.mm.plugin.collect.reward.b.a.bWf().bWg())
    {
      this.ozh.aE(com.tencent.mm.plugin.collect.reward.b.a.bWf().bWi(), this.ozb, this.ozb);
      this.ozg.setVisibility(0);
      AppMethodBeat.o(63969);
      return;
    }
    this.ozg.setVisibility(4);
    AppMethodBeat.o(63969);
  }
  
  private void bWm()
  {
    AppMethodBeat.i(63970);
    int j = Math.round(this.ozb * (this.drN * 1.0F / this.ozs));
    int i = j;
    if (j <= 0) {
      i = 248;
    }
    ViewGroup.LayoutParams localLayoutParams = this.ozj.getLayoutParams();
    localLayoutParams.width = i;
    localLayoutParams.height = i;
    this.ozj.setLayoutParams(localLayoutParams);
    localLayoutParams = this.ozi.getLayoutParams();
    localLayoutParams.width = i;
    localLayoutParams.height = i;
    this.ozi.setLayoutParams(localLayoutParams);
    localLayoutParams = this.ozk.getLayoutParams();
    localLayoutParams.width = (i - 30);
    localLayoutParams.height = (i - 30);
    this.ozk.setLayoutParams(localLayoutParams);
    this.ozk.setTextSize(0, i * 2 / 3);
    this.ozf.requestLayout();
    AppMethodBeat.o(63970);
  }
  
  private void bWn()
  {
    AppMethodBeat.i(63971);
    if (!bs.isNullOrNil(this.desc))
    {
      this.lgw.setText(k.b(this, getString(2131762114, new Object[] { this.desc }), this.lgw.getTextSize()));
      AppMethodBeat.o(63971);
      return;
    }
    this.lgw.setText("");
    AppMethodBeat.o(63971);
  }
  
  private void bWo()
  {
    AppMethodBeat.i(63972);
    bWm();
    bWn();
    jB(bs.isNullOrNil(this.ozp));
    AppMethodBeat.o(63972);
  }
  
  private void bWp()
  {
    AppMethodBeat.i(63973);
    if (!bs.isNullOrNil(this.ozq))
    {
      this.ozm.setClickable(true);
      this.ozm.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(this));
      com.tencent.mm.plugin.wallet_core.ui.q localq = new com.tencent.mm.plugin.wallet_core.ui.q(new q.a()
      {
        public final void dK(View paramAnonymousView)
        {
          AppMethodBeat.i(63949);
          ac.d("MicroMsg.QrRewardMainUI", "go to: %s", new Object[] { QrRewardMainUI.r(QrRewardMainUI.this) });
          com.tencent.mm.wallet_core.ui.e.n(QrRewardMainUI.this.getContext(), QrRewardMainUI.r(QrRewardMainUI.this), false);
          com.tencent.mm.plugin.report.service.h.wUl.f(14721, new Object[] { Integer.valueOf(1), Integer.valueOf(6) });
          AppMethodBeat.o(63949);
        }
      });
      SpannableString localSpannableString = new SpannableString(this.ozq);
      localSpannableString.setSpan(localq, 0, localSpannableString.length(), 18);
      this.ozm.setText(localSpannableString);
      this.ozm.setVisibility(0);
      AppMethodBeat.o(63973);
      return;
    }
    this.ozm.setVisibility(8);
    AppMethodBeat.o(63973);
  }
  
  private void bWq()
  {
    AppMethodBeat.i(63975);
    if (!bs.isNullOrNil(this.ozp))
    {
      this.ozk.setText(k.b(getContext(), this.ozp, this.ozk.getTextSize()));
      this.ozk.setSelection(this.ozp.length());
    }
    AppMethodBeat.o(63975);
  }
  
  private void bWr()
  {
    AppMethodBeat.i(63976);
    ac.i("MicroMsg.QrRewardMainUI", "do set photo word");
    com.tencent.mm.plugin.collect.reward.a.h localh = new com.tencent.mm.plugin.collect.reward.a.h(this.ozp);
    localh.N(this);
    doSceneProgress(localh, true);
    AppMethodBeat.o(63976);
  }
  
  private void jB(boolean paramBoolean)
  {
    AppMethodBeat.i(63974);
    ac.i("MicroMsg.QrRewardMainUI", "switch mode: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.ozi.setVisibility(0);
      this.ozk.setVisibility(4);
      a.b.a(this.ozi, this.username, 0.03F, true);
      AppMethodBeat.o(63974);
      return;
    }
    this.ozi.setVisibility(4);
    this.ozk.setVisibility(0);
    AppMethodBeat.o(63974);
  }
  
  private void m(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(63968);
    if ((this.kow != null) && (this.kow.equals(paramString1))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = com.tencent.mm.plugin.collect.reward.b.a.bWf().bWg();
      ac.i("MicroMsg.QrRewardMainUI", "do download photo: %s, same url: %s, pic exist: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((paramBoolean) || (!bool1) || (!bool2)) {
        com.tencent.mm.plugin.collect.reward.b.a.bWf().a(paramString1, paramString2, new com.tencent.mm.plugin.collect.reward.b.a.a()
        {
          public final void V(String paramAnonymousString, int paramAnonymousInt1, int paramAnonymousInt2)
          {
            AppMethodBeat.i(63948);
            ac.i("MicroMsg.QrRewardMainUI", "callback ret: %s, %s, %s", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
            if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0)) {
              ap.f(new Runnable()
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
    return 2131495162;
  }
  
  public void initView()
  {
    AppMethodBeat.i(63963);
    this.ozc = ((RelativeLayout)findViewById(2131304248));
    this.ozd = ((Button)findViewById(2131303646));
    this.oze = ((ViewGroup)findViewById(2131303645));
    this.ozf = ((ViewGroup)findViewById(2131303644));
    this.ozh = ((CdnImageView)findViewById(2131303639));
    this.lgw = ((TextView)findViewById(2131303643));
    this.ozi = ((ImageView)findViewById(2131303638));
    this.ozj = ((ImageView)findViewById(2131303637));
    this.ozg = ((RelativeLayout)findViewById(2131303640));
    this.ozk = ((MMEditText)findViewById(2131303641));
    this.ozl = ((TextView)findViewById(2131303648));
    this.ozn = ((TextView)findViewById(2131303651));
    this.ozm = ((TextView)findViewById(2131303636));
    a.b.a(this.ozi, this.username, 0.03F, true);
    try
    {
      this.ozk.setText(k.b(getContext(), this.ozp, this.ozk.getTextSize()));
      this.ozk.setSelection(this.ozp.length());
      this.ozk.addTextChangedListener(new TextWatcher()
      {
        int ozv = 0;
        
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(63942);
          ac.d("MicroMsg.QrRewardMainUI", "s: %s, %s", new Object[] { paramAnonymousEditable.toString(), Integer.valueOf(paramAnonymousEditable.length()) });
          String str = paramAnonymousEditable.toString();
          if (bs.isNullOrNil(str)) {
            this.ozv = 0;
          }
          for (;;)
          {
            paramAnonymousEditable.delete(this.ozv, paramAnonymousEditable.length());
            AppMethodBeat.o(63942);
            return;
            if (this.ozv == 0) {
              if ((((com.tencent.mm.plugin.emoji.b.a)g.ab(com.tencent.mm.plugin.emoji.b.a.class)).J(str)) || (((com.tencent.mm.plugin.emoji.b.a)g.ab(com.tencent.mm.plugin.emoji.b.a.class)).K(str))) {
                this.ozv = paramAnonymousEditable.length();
              } else {
                this.ozv = 1;
              }
            }
          }
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.ozk.setOnEditorActionListener(new TextView.OnEditorActionListener()
      {
        public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(63952);
          ac.i("MicroMsg.QrRewardMainUI", "action: %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
          QrRewardMainUI.a(QrRewardMainUI.this, QrRewardMainUI.a(QrRewardMainUI.this).getText().toString());
          QrRewardMainUI.b(QrRewardMainUI.this);
          if (bs.isNullOrNil(QrRewardMainUI.c(QrRewardMainUI.this))) {
            QrRewardMainUI.a(QrRewardMainUI.this, true);
          }
          QrRewardMainUI.this.hideVKB();
          AppMethodBeat.o(63952);
          return false;
        }
      });
      this.ozj.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(63953);
          ac.d("MicroMsg.QrRewardMainUI", "click avatar");
          QrRewardMainUI.this.hideVKB();
          QrRewardMainUI.d(QrRewardMainUI.this);
          AppMethodBeat.o(63953);
        }
      });
      this.ozl.setClickable(true);
      this.ozl.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(this));
      com.tencent.mm.plugin.wallet_core.ui.q localq = new com.tencent.mm.plugin.wallet_core.ui.q(new q.a()
      {
        public final void dK(View paramAnonymousView)
        {
          AppMethodBeat.i(63954);
          ac.i("MicroMsg.QrRewardMainUI", "click save code");
          p.a(QrRewardMainUI.this, new Runnable()new Runnable
          {
            public final void run()
            {
              AppMethodBeat.i(207046);
              QrRewardMainUI.e(QrRewardMainUI.this);
              com.tencent.mm.plugin.report.service.h.wUl.f(14721, new Object[] { Integer.valueOf(1), Integer.valueOf(5) });
              AppMethodBeat.o(207046);
            }
          }, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(207047);
              Toast.makeText(QrRewardMainUI.this, 2131762779, 1).show();
              AppMethodBeat.o(207047);
            }
          });
          AppMethodBeat.o(63954);
        }
      });
      SpannableString localSpannableString = new SpannableString(getString(2131762101));
      localSpannableString.setSpan(localq, 0, localSpannableString.length(), 18);
      this.ozl.setText(localSpannableString);
      this.ozn.setClickable(true);
      this.ozn.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(this));
      localq = new com.tencent.mm.plugin.wallet_core.ui.q(new q.a()
      {
        public final void dK(View paramAnonymousView)
        {
          AppMethodBeat.i(63955);
          ac.i("MicroMsg.QrRewardMainUI", "click set code, %s", new Object[] { Boolean.valueOf(QrRewardMainUI.f(QrRewardMainUI.this)) });
          QrRewardMainUI.b(QrRewardMainUI.this, false);
          AppMethodBeat.o(63955);
        }
      });
      localSpannableString = new SpannableString(getString(2131762111));
      localSpannableString.setSpan(localq, 0, localSpannableString.length(), 18);
      this.ozn.setText(localSpannableString);
      bWl();
      bWo();
      bWq();
      bWp();
      AppMethodBeat.o(63963);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.QrRewardMainUI", localException, "", new Object[0]);
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
        this.ozs = paramIntent.getIntExtra("key_photo_width", 900);
        this.drN = paramIntent.getIntExtra("key_icon_width", 343);
        boolean bool = paramIntent.getBooleanExtra("key_return_from_first", true);
        ac.i("MicroMsg.QrRewardMainUI", "return from first: %s", new Object[] { Boolean.valueOf(bool) });
        if (bool)
        {
          this.ozf.setVisibility(0);
          this.oze.setVisibility(8);
        }
        this.ozu = true;
        bWo();
        String str = paramIntent.getStringExtra("key_photo_url");
        m(str, paramIntent.getStringExtra("key_photo_aeskey"), true);
        this.kow = str;
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
    this.ozs = ((Integer)g.agR().agA().get(ah.a.GOX, Integer.valueOf(900))).intValue();
    this.drN = ((Integer)g.agR().agA().get(ah.a.GOY, Integer.valueOf(343))).intValue();
    this.desc = ((String)g.agR().agA().get(ah.a.GPa, ""));
    this.ozp = ((String)g.agR().agA().get(ah.a.GOZ, ""));
    this.ozq = ((String)g.agR().agA().get(ah.a.GPe, ""));
    this.ozr = ((String)g.agR().agA().get(ah.a.GPf, ""));
    this.kow = ((String)g.agR().agA().get(ah.a.GPg, ""));
    if (!bs.isNullOrNil((String)g.agR().agA().get(ah.a.GPd, ""))) {
      this.ozu = true;
    }
    this.username = u.axw();
    setMMTitle(2131762096);
    initView();
    if ((com.tencent.mm.plugin.collect.reward.b.a.bWf().bWg()) && (this.ozu)) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i("MicroMsg.QrRewardMainUI", "do get code: %s", new Object[] { Boolean.valueOf(bool) });
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
    com.tencent.mm.plugin.collect.reward.b.a locala = com.tencent.mm.plugin.collect.reward.b.a.bWf();
    ac.d("MicroMsg.QrRewardCdnDownloadHelper", "do clear callback");
    if (locala.mYy != null)
    {
      ac.i("MicroMsg.QrRewardCdnDownloadHelper", "callback size: %s", new Object[] { Integer.valueOf(locala.mYy.size()) });
      locala.mYy.clear();
    }
    AppMethodBeat.o(63967);
  }
  
  public void onKeyboardStateChanged()
  {
    AppMethodBeat.i(63965);
    super.onKeyboardStateChanged();
    ac.i("MicroMsg.QrRewardMainUI", "key board changed: %s", new Object[] { Integer.valueOf(keyboardState()) });
    if (keyboardState() == 2)
    {
      this.ozp = this.ozk.getText().toString();
      bWr();
      if (bs.isNullOrNil(this.ozp)) {
        jB(true);
      }
    }
    AppMethodBeat.o(63965);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(63964);
    if ((paramn instanceof com.tencent.mm.plugin.collect.reward.a.b))
    {
      paramString = (com.tencent.mm.plugin.collect.reward.a.b)paramn;
      paramString.a(new com.tencent.mm.plugin.collect.reward.a.a.a()
      {
        public final void g(com.tencent.mm.ak.n paramAnonymousn)
        {
          AppMethodBeat.i(63959);
          QrRewardMainUI.a(QrRewardMainUI.this, paramString.oyo.nyq);
          QrRewardMainUI.a(QrRewardMainUI.this, paramString.oyo.Ene);
          QrRewardMainUI.b(QrRewardMainUI.this, paramString.oyo.Ena);
          QrRewardMainUI.b(QrRewardMainUI.this, paramString.oyo.desc);
          QrRewardMainUI.c(QrRewardMainUI.this, paramString.oyo.BsL);
          paramAnonymousn = QrRewardMainUI.this;
          boolean bool;
          if (!paramString.oyo.EmY)
          {
            bool = true;
            QrRewardMainUI.c(paramAnonymousn, bool);
            QrRewardMainUI.d(QrRewardMainUI.this, paramString.oyo.nWi);
            QrRewardMainUI.e(QrRewardMainUI.this, paramString.oyo.Enc);
            QrRewardMainUI.h(QrRewardMainUI.this);
            QrRewardMainUI.i(QrRewardMainUI.this);
            if (QrRewardMainUI.j(QrRewardMainUI.this)) {
              break label242;
            }
            QrRewardMainUI.k(QrRewardMainUI.this);
          }
          for (;;)
          {
            QrRewardMainUI.f(QrRewardMainUI.this, paramString.oyo.wJR);
            QrRewardMainUI.bWs();
            ac.d("MicroMsg.QrRewardMainUI", "url: %s", new Object[] { QrRewardMainUI.n(QrRewardMainUI.this) });
            AppMethodBeat.o(63959);
            return;
            bool = false;
            break;
            label242:
            QrRewardMainUI.a(QrRewardMainUI.this, paramString.oyo.wJR, paramString.oyo.EmZ);
            QrRewardMainUI.l(QrRewardMainUI.this);
            QrRewardMainUI.m(QrRewardMainUI.this);
          }
        }
      }).b(new com.tencent.mm.plugin.collect.reward.a.a.a()
      {
        public final void g(com.tencent.mm.ak.n paramAnonymousn)
        {
          boolean bool = true;
          AppMethodBeat.i(63958);
          ac.e("MicroMsg.QrRewardMainUI", "get code error: %s, %s", new Object[] { Integer.valueOf(paramString.oyo.dae), paramString.oyo.oxf });
          if (paramString.oyo.dae == 416)
          {
            if (paramString.oyo.EmH == null) {}
            for (;;)
            {
              ac.d("MicroMsg.QrRewardMainUI", "realNameInfo:%s", new Object[] { Boolean.valueOf(bool) });
              QrRewardMainUI.g(QrRewardMainUI.this).setVisibility(4);
              paramAnonymousn = new Bundle();
              paramAnonymousn.putString("realname_verify_process_jump_activity", ".reward.ui.CollectMainUI");
              paramAnonymousn.putString("realname_verify_process_jump_plugin", "collect");
              QrRewardMainUI localQrRewardMainUI = QrRewardMainUI.this;
              int i = paramString.oyo.dae;
              cma localcma = paramString.oyo.EmH;
              new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(63957);
                  ac.i("MicroMsg.QrRewardMainUI", "RealnameVerifyUtil cancel");
                  AppMethodBeat.o(63957);
                }
              };
              com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(localQrRewardMainUI, i, localcma, paramAnonymousn, 1011);
              AppMethodBeat.o(63958);
              return;
              bool = false;
            }
          }
          if (!bs.isNullOrNil(paramString.oyo.oxf)) {
            Toast.makeText(QrRewardMainUI.this, paramString.oyo.oxf, 0).show();
          }
          if (!paramString.oyp) {
            QrRewardMainUI.b(QrRewardMainUI.this, false);
          }
          AppMethodBeat.o(63958);
        }
      }).c(new com.tencent.mm.plugin.collect.reward.a.a.a()
      {
        public final void g(com.tencent.mm.ak.n paramAnonymousn)
        {
          AppMethodBeat.i(63956);
          ac.e("MicroMsg.QrRewardMainUI", "net error: %s", new Object[] { paramAnonymousn });
          if (!paramString.oyp) {
            QrRewardMainUI.b(QrRewardMainUI.this, false);
          }
          AppMethodBeat.o(63956);
        }
      });
      AppMethodBeat.o(63964);
      return true;
    }
    if ((paramn instanceof com.tencent.mm.plugin.collect.reward.a.h))
    {
      paramString = (com.tencent.mm.plugin.collect.reward.a.h)paramn;
      paramString.a(new com.tencent.mm.plugin.collect.reward.a.a.a()
      {
        public final void g(com.tencent.mm.ak.n paramAnonymousn)
        {
          AppMethodBeat.i(63944);
          ac.i("MicroMsg.QrRewardMainUI", "set succ: %s, %s", new Object[] { paramString.nyq, QrRewardMainUI.a(QrRewardMainUI.this).getText() });
          if (paramString.nyq.equals(QrRewardMainUI.c(QrRewardMainUI.this)))
          {
            g.agR().agA().set(ah.a.GOZ, QrRewardMainUI.c(QrRewardMainUI.this));
            QrRewardMainUI.m(QrRewardMainUI.this);
          }
          AppMethodBeat.o(63944);
        }
      }).b(new com.tencent.mm.plugin.collect.reward.a.a.a()
      {
        public final void g(com.tencent.mm.ak.n paramAnonymousn)
        {
          AppMethodBeat.i(63943);
          ac.e("MicroMsg.QrRewardMainUI", "set word error: %s, %s", new Object[] { Integer.valueOf(paramString.oyv.dae), paramString.oyv.oxf });
          QrRewardMainUI.a(QrRewardMainUI.this, (String)g.agR().agA().get(ah.a.GOZ, ""));
          QrRewardMainUI.a(QrRewardMainUI.this, QrRewardMainUI.o(QrRewardMainUI.this));
          QrRewardMainUI.a(QrRewardMainUI.this).setText("");
          QrRewardMainUI.m(QrRewardMainUI.this);
          if (!bs.isNullOrNil(paramString.oyv.oxf)) {
            Toast.makeText(QrRewardMainUI.this, paramString.oyv.oxf, 0).show();
          }
          AppMethodBeat.o(63943);
        }
      }).c(new com.tencent.mm.plugin.collect.reward.a.a.a()
      {
        public final void g(com.tencent.mm.ak.n paramAnonymousn)
        {
          AppMethodBeat.i(63960);
          ac.e("MicroMsg.QrRewardMainUI", "net error: %s", new Object[] { paramAnonymousn });
          QrRewardMainUI.a(QrRewardMainUI.this, (String)g.agR().agA().get(ah.a.GOZ, ""));
          QrRewardMainUI.a(QrRewardMainUI.this, QrRewardMainUI.o(QrRewardMainUI.this));
          QrRewardMainUI.a(QrRewardMainUI.this).setText("");
          QrRewardMainUI.m(QrRewardMainUI.this);
          AppMethodBeat.o(63960);
        }
      });
      this.ozk.clearFocus();
      this.ozk.setCursorVisible(false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI
 * JD-Core Version:    0.7.0.1
 */