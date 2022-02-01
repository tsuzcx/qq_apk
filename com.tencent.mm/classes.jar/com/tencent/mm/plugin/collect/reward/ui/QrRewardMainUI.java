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
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.v;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.plugin.wallet_core.ui.q.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.cru;
import com.tencent.mm.protocal.protobuf.uu;
import com.tencent.mm.protocal.protobuf.vl;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.wallet_core.ui.f;
import java.util.Map;

public class QrRewardMainUI
  extends QrRewardBaseUI
{
  private String dOf;
  private String desc;
  private int iconWidth;
  private String kML;
  private TextView lHT;
  private boolean mIsOpen;
  private final int pjc;
  private RelativeLayout pjd;
  private Button pje;
  private ViewGroup pjf;
  private ViewGroup pjg;
  private RelativeLayout pjh;
  private CdnImageView pji;
  private ImageView pjj;
  private ImageView pjk;
  private MMEditText pjl;
  private TextView pjm;
  private TextView pjn;
  private TextView pjo;
  private ScrollView pjp;
  private String pjq;
  private String pjr;
  private String pjs;
  private int pjt;
  private boolean pju;
  private boolean pjv;
  private String username;
  
  public QrRewardMainUI()
  {
    AppMethodBeat.i(63961);
    this.pjc = com.tencent.mm.cb.a.fromDPToPix(getContext(), 200);
    this.mIsOpen = false;
    AppMethodBeat.o(63961);
  }
  
  private void ccd()
  {
    AppMethodBeat.i(63969);
    if (com.tencent.mm.plugin.collect.reward.b.a.cbX().cbY())
    {
      this.pji.aK(com.tencent.mm.plugin.collect.reward.b.a.cbX().cca(), this.pjc, this.pjc);
      this.pjh.setVisibility(0);
      AppMethodBeat.o(63969);
      return;
    }
    this.pjh.setVisibility(4);
    AppMethodBeat.o(63969);
  }
  
  private void cce()
  {
    AppMethodBeat.i(63970);
    int j = Math.round(this.pjc * (this.iconWidth * 1.0F / this.pjt));
    int i = j;
    if (j <= 0) {
      i = 248;
    }
    ViewGroup.LayoutParams localLayoutParams = this.pjk.getLayoutParams();
    localLayoutParams.width = i;
    localLayoutParams.height = i;
    this.pjk.setLayoutParams(localLayoutParams);
    localLayoutParams = this.pjj.getLayoutParams();
    localLayoutParams.width = i;
    localLayoutParams.height = i;
    this.pjj.setLayoutParams(localLayoutParams);
    localLayoutParams = this.pjl.getLayoutParams();
    localLayoutParams.width = (i - 30);
    localLayoutParams.height = (i - 30);
    this.pjl.setLayoutParams(localLayoutParams);
    this.pjl.setTextSize(0, i * 2 / 3);
    this.pjg.requestLayout();
    AppMethodBeat.o(63970);
  }
  
  private void ccf()
  {
    AppMethodBeat.i(63971);
    if (!bu.isNullOrNil(this.desc))
    {
      this.lHT.setText(k.b(this, getString(2131762114, new Object[] { this.desc }), this.lHT.getTextSize()));
      AppMethodBeat.o(63971);
      return;
    }
    this.lHT.setText("");
    AppMethodBeat.o(63971);
  }
  
  private void ccg()
  {
    AppMethodBeat.i(63972);
    cce();
    ccf();
    jL(bu.isNullOrNil(this.pjq));
    AppMethodBeat.o(63972);
  }
  
  private void cch()
  {
    AppMethodBeat.i(63973);
    if (!bu.isNullOrNil(this.pjr))
    {
      this.pjn.setClickable(true);
      this.pjn.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(this));
      com.tencent.mm.plugin.wallet_core.ui.q localq = new com.tencent.mm.plugin.wallet_core.ui.q(new q.a()
      {
        public final void dN(View paramAnonymousView)
        {
          AppMethodBeat.i(63949);
          ae.d("MicroMsg.QrRewardMainUI", "go to: %s", new Object[] { QrRewardMainUI.r(QrRewardMainUI.this) });
          f.o(QrRewardMainUI.this.getContext(), QrRewardMainUI.r(QrRewardMainUI.this), false);
          com.tencent.mm.plugin.report.service.g.yxI.f(14721, new Object[] { Integer.valueOf(1), Integer.valueOf(6) });
          AppMethodBeat.o(63949);
        }
      });
      SpannableString localSpannableString = new SpannableString(this.pjr);
      localSpannableString.setSpan(localq, 0, localSpannableString.length(), 18);
      this.pjn.setText(localSpannableString);
      this.pjn.setVisibility(0);
      AppMethodBeat.o(63973);
      return;
    }
    this.pjn.setVisibility(8);
    AppMethodBeat.o(63973);
  }
  
  private void cci()
  {
    AppMethodBeat.i(63975);
    if (!bu.isNullOrNil(this.pjq))
    {
      this.pjl.setText(k.b(getContext(), this.pjq, this.pjl.getTextSize()));
      this.pjl.setSelection(this.pjq.length());
    }
    AppMethodBeat.o(63975);
  }
  
  private void ccj()
  {
    AppMethodBeat.i(63976);
    ae.i("MicroMsg.QrRewardMainUI", "do set photo word");
    com.tencent.mm.plugin.collect.reward.a.h localh = new com.tencent.mm.plugin.collect.reward.a.h(this.pjq);
    localh.O(this);
    doSceneProgress(localh, true);
    AppMethodBeat.o(63976);
  }
  
  private void jL(boolean paramBoolean)
  {
    AppMethodBeat.i(63974);
    ae.i("MicroMsg.QrRewardMainUI", "switch mode: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.pjj.setVisibility(0);
      this.pjl.setVisibility(4);
      a.b.a(this.pjj, this.username, 0.03F, true);
      AppMethodBeat.o(63974);
      return;
    }
    this.pjj.setVisibility(4);
    this.pjl.setVisibility(0);
    AppMethodBeat.o(63974);
  }
  
  private void m(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(63968);
    if ((this.kML != null) && (this.kML.equals(paramString1))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = com.tencent.mm.plugin.collect.reward.b.a.cbX().cbY();
      ae.i("MicroMsg.QrRewardMainUI", "do download photo: %s, same url: %s, pic exist: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((paramBoolean) || (!bool1) || (!bool2)) {
        com.tencent.mm.plugin.collect.reward.b.a.cbX().a(paramString1, paramString2, new com.tencent.mm.plugin.collect.reward.b.a.a()
        {
          public final void X(String paramAnonymousString, int paramAnonymousInt1, int paramAnonymousInt2)
          {
            AppMethodBeat.i(63948);
            ae.i("MicroMsg.QrRewardMainUI", "callback ret: %s, %s, %s", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
            if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0)) {
              ar.f(new Runnable()
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
    this.pjd = ((RelativeLayout)findViewById(2131304248));
    this.pje = ((Button)findViewById(2131303646));
    this.pjf = ((ViewGroup)findViewById(2131303645));
    this.pjg = ((ViewGroup)findViewById(2131303644));
    this.pji = ((CdnImageView)findViewById(2131303639));
    this.lHT = ((TextView)findViewById(2131303643));
    this.pjj = ((ImageView)findViewById(2131303638));
    this.pjk = ((ImageView)findViewById(2131303637));
    this.pjh = ((RelativeLayout)findViewById(2131303640));
    this.pjl = ((MMEditText)findViewById(2131303641));
    this.pjm = ((TextView)findViewById(2131303648));
    this.pjo = ((TextView)findViewById(2131303651));
    this.pjn = ((TextView)findViewById(2131303636));
    a.b.a(this.pjj, this.username, 0.03F, true);
    try
    {
      this.pjl.setText(k.b(getContext(), this.pjq, this.pjl.getTextSize()));
      this.pjl.setSelection(this.pjq.length());
      this.pjl.addTextChangedListener(new TextWatcher()
      {
        int pjw = 0;
        
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(63942);
          ae.d("MicroMsg.QrRewardMainUI", "s: %s, %s", new Object[] { paramAnonymousEditable.toString(), Integer.valueOf(paramAnonymousEditable.length()) });
          String str = paramAnonymousEditable.toString();
          if (bu.isNullOrNil(str)) {
            this.pjw = 0;
          }
          for (;;)
          {
            paramAnonymousEditable.delete(this.pjw, paramAnonymousEditable.length());
            AppMethodBeat.o(63942);
            return;
            if (this.pjw == 0) {
              if ((((com.tencent.mm.plugin.emoji.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.a.class)).I(str)) || (((com.tencent.mm.plugin.emoji.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.a.class)).J(str))) {
                this.pjw = paramAnonymousEditable.length();
              } else {
                this.pjw = 1;
              }
            }
          }
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.pjl.setOnEditorActionListener(new TextView.OnEditorActionListener()
      {
        public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(63952);
          ae.i("MicroMsg.QrRewardMainUI", "action: %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
          QrRewardMainUI.a(QrRewardMainUI.this, QrRewardMainUI.a(QrRewardMainUI.this).getText().toString());
          QrRewardMainUI.b(QrRewardMainUI.this);
          if (bu.isNullOrNil(QrRewardMainUI.c(QrRewardMainUI.this))) {
            QrRewardMainUI.a(QrRewardMainUI.this, true);
          }
          QrRewardMainUI.this.hideVKB();
          AppMethodBeat.o(63952);
          return false;
        }
      });
      this.pjk.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(63953);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/collect/reward/ui/QrRewardMainUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          ae.d("MicroMsg.QrRewardMainUI", "click avatar");
          QrRewardMainUI.this.hideVKB();
          QrRewardMainUI.d(QrRewardMainUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/reward/ui/QrRewardMainUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(63953);
        }
      });
      this.pjm.setClickable(true);
      this.pjm.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(this));
      com.tencent.mm.plugin.wallet_core.ui.q localq = new com.tencent.mm.plugin.wallet_core.ui.q(new q.a()
      {
        public final void dN(View paramAnonymousView)
        {
          AppMethodBeat.i(63954);
          ae.i("MicroMsg.QrRewardMainUI", "click save code");
          p.a(QrRewardMainUI.this, new Runnable()new Runnable
          {
            public final void run()
            {
              AppMethodBeat.i(189784);
              QrRewardMainUI.e(QrRewardMainUI.this);
              com.tencent.mm.plugin.report.service.g.yxI.f(14721, new Object[] { Integer.valueOf(1), Integer.valueOf(5) });
              AppMethodBeat.o(189784);
            }
          }, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(189785);
              Toast.makeText(QrRewardMainUI.this, 2131762779, 1).show();
              AppMethodBeat.o(189785);
            }
          });
          AppMethodBeat.o(63954);
        }
      });
      SpannableString localSpannableString = new SpannableString(getString(2131762101));
      localSpannableString.setSpan(localq, 0, localSpannableString.length(), 18);
      this.pjm.setText(localSpannableString);
      this.pjo.setClickable(true);
      this.pjo.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(this));
      localq = new com.tencent.mm.plugin.wallet_core.ui.q(new q.a()
      {
        public final void dN(View paramAnonymousView)
        {
          AppMethodBeat.i(63955);
          ae.i("MicroMsg.QrRewardMainUI", "click set code, %s", new Object[] { Boolean.valueOf(QrRewardMainUI.f(QrRewardMainUI.this)) });
          QrRewardMainUI.b(QrRewardMainUI.this, false);
          AppMethodBeat.o(63955);
        }
      });
      localSpannableString = new SpannableString(getString(2131762111));
      localSpannableString.setSpan(localq, 0, localSpannableString.length(), 18);
      this.pjo.setText(localSpannableString);
      ccd();
      ccg();
      cci();
      cch();
      AppMethodBeat.o(63963);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.QrRewardMainUI", localException, "", new Object[0]);
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
        this.pjt = paramIntent.getIntExtra("key_photo_width", 900);
        this.iconWidth = paramIntent.getIntExtra("key_icon_width", 343);
        boolean bool = paramIntent.getBooleanExtra("key_return_from_first", true);
        ae.i("MicroMsg.QrRewardMainUI", "return from first: %s", new Object[] { Boolean.valueOf(bool) });
        if (bool)
        {
          this.pjg.setVisibility(0);
          this.pjf.setVisibility(8);
        }
        this.pjv = true;
        ccg();
        String str = paramIntent.getStringExtra("key_photo_url");
        m(str, paramIntent.getStringExtra("key_photo_aeskey"), true);
        this.kML = str;
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
    this.pjt = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IVR, Integer.valueOf(900))).intValue();
    this.iconWidth = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IVS, Integer.valueOf(343))).intValue();
    this.desc = ((String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IVU, ""));
    this.pjq = ((String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IVT, ""));
    this.pjr = ((String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IVY, ""));
    this.pjs = ((String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IVZ, ""));
    this.kML = ((String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IWa, ""));
    if (!bu.isNullOrNil((String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IVX, ""))) {
      this.pjv = true;
    }
    this.username = v.aAC();
    setMMTitle(2131762096);
    initView();
    if ((com.tencent.mm.plugin.collect.reward.b.a.cbX().cbY()) && (this.pjv)) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.QrRewardMainUI", "do get code: %s", new Object[] { Boolean.valueOf(bool) });
      paramBundle = new com.tencent.mm.plugin.collect.reward.a.b(bool);
      paramBundle.O(this);
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
    com.tencent.mm.plugin.collect.reward.b.a locala = com.tencent.mm.plugin.collect.reward.b.a.cbX();
    ae.d("MicroMsg.QrRewardCdnDownloadHelper", "do clear callback");
    if (locala.nEq != null)
    {
      ae.i("MicroMsg.QrRewardCdnDownloadHelper", "callback size: %s", new Object[] { Integer.valueOf(locala.nEq.size()) });
      locala.nEq.clear();
    }
    AppMethodBeat.o(63967);
  }
  
  public void onKeyboardStateChanged()
  {
    AppMethodBeat.i(63965);
    super.onKeyboardStateChanged();
    ae.i("MicroMsg.QrRewardMainUI", "key board changed: %s", new Object[] { Integer.valueOf(keyboardState()) });
    if (keyboardState() == 2)
    {
      this.pjq = this.pjl.getText().toString();
      ccj();
      if (bu.isNullOrNil(this.pjq)) {
        jL(true);
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
          QrRewardMainUI.a(QrRewardMainUI.this, paramString.pip.ofy);
          QrRewardMainUI.a(QrRewardMainUI.this, paramString.pip.GmM);
          QrRewardMainUI.b(QrRewardMainUI.this, paramString.pip.GmI);
          QrRewardMainUI.b(QrRewardMainUI.this, paramString.pip.desc);
          QrRewardMainUI.c(QrRewardMainUI.this, paramString.pip.DkG);
          paramAnonymousn = QrRewardMainUI.this;
          boolean bool;
          if (!paramString.pip.GmG)
          {
            bool = true;
            QrRewardMainUI.c(paramAnonymousn, bool);
            QrRewardMainUI.d(QrRewardMainUI.this, paramString.pip.oGe);
            QrRewardMainUI.e(QrRewardMainUI.this, paramString.pip.GmK);
            QrRewardMainUI.h(QrRewardMainUI.this);
            QrRewardMainUI.i(QrRewardMainUI.this);
            if (QrRewardMainUI.j(QrRewardMainUI.this)) {
              break label242;
            }
            QrRewardMainUI.k(QrRewardMainUI.this);
          }
          for (;;)
          {
            QrRewardMainUI.f(QrRewardMainUI.this, paramString.pip.ynq);
            QrRewardMainUI.cck();
            ae.d("MicroMsg.QrRewardMainUI", "url: %s", new Object[] { QrRewardMainUI.n(QrRewardMainUI.this) });
            AppMethodBeat.o(63959);
            return;
            bool = false;
            break;
            label242:
            QrRewardMainUI.a(QrRewardMainUI.this, paramString.pip.ynq, paramString.pip.GmH);
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
          ae.e("MicroMsg.QrRewardMainUI", "get code error: %s, %s", new Object[] { Integer.valueOf(paramString.pip.dmy), paramString.pip.phe });
          if (paramString.pip.dmy == 416)
          {
            if (paramString.pip.Gmp == null) {}
            for (;;)
            {
              ae.d("MicroMsg.QrRewardMainUI", "realNameInfo:%s", new Object[] { Boolean.valueOf(bool) });
              QrRewardMainUI.g(QrRewardMainUI.this).setVisibility(4);
              paramAnonymousn = new Bundle();
              paramAnonymousn.putString("realname_verify_process_jump_activity", ".reward.ui.CollectMainUI");
              paramAnonymousn.putString("realname_verify_process_jump_plugin", "collect");
              QrRewardMainUI localQrRewardMainUI = QrRewardMainUI.this;
              int i = paramString.pip.dmy;
              cru localcru = paramString.pip.Gmp;
              new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(63957);
                  ae.i("MicroMsg.QrRewardMainUI", "RealnameVerifyUtil cancel");
                  AppMethodBeat.o(63957);
                }
              };
              com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(localQrRewardMainUI, i, localcru, paramAnonymousn, 1011);
              AppMethodBeat.o(63958);
              return;
              bool = false;
            }
          }
          if (!bu.isNullOrNil(paramString.pip.phe)) {
            Toast.makeText(QrRewardMainUI.this, paramString.pip.phe, 0).show();
          }
          if (!paramString.piq) {
            QrRewardMainUI.b(QrRewardMainUI.this, false);
          }
          AppMethodBeat.o(63958);
        }
      }).c(new com.tencent.mm.plugin.collect.reward.a.a.a()
      {
        public final void g(com.tencent.mm.ak.n paramAnonymousn)
        {
          AppMethodBeat.i(63956);
          ae.e("MicroMsg.QrRewardMainUI", "net error: %s", new Object[] { paramAnonymousn });
          if (!paramString.piq) {
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
          ae.i("MicroMsg.QrRewardMainUI", "set succ: %s, %s", new Object[] { paramString.ofy, QrRewardMainUI.a(QrRewardMainUI.this).getText() });
          if (paramString.ofy.equals(QrRewardMainUI.c(QrRewardMainUI.this)))
          {
            com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IVT, QrRewardMainUI.c(QrRewardMainUI.this));
            QrRewardMainUI.m(QrRewardMainUI.this);
          }
          AppMethodBeat.o(63944);
        }
      }).b(new com.tencent.mm.plugin.collect.reward.a.a.a()
      {
        public final void g(com.tencent.mm.ak.n paramAnonymousn)
        {
          AppMethodBeat.i(63943);
          ae.e("MicroMsg.QrRewardMainUI", "set word error: %s, %s", new Object[] { Integer.valueOf(paramString.piw.dmy), paramString.piw.phe });
          QrRewardMainUI.a(QrRewardMainUI.this, (String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IVT, ""));
          QrRewardMainUI.a(QrRewardMainUI.this, QrRewardMainUI.o(QrRewardMainUI.this));
          QrRewardMainUI.a(QrRewardMainUI.this).setText("");
          QrRewardMainUI.m(QrRewardMainUI.this);
          if (!bu.isNullOrNil(paramString.piw.phe)) {
            Toast.makeText(QrRewardMainUI.this, paramString.piw.phe, 0).show();
          }
          AppMethodBeat.o(63943);
        }
      }).c(new com.tencent.mm.plugin.collect.reward.a.a.a()
      {
        public final void g(com.tencent.mm.ak.n paramAnonymousn)
        {
          AppMethodBeat.i(63960);
          ae.e("MicroMsg.QrRewardMainUI", "net error: %s", new Object[] { paramAnonymousn });
          QrRewardMainUI.a(QrRewardMainUI.this, (String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IVT, ""));
          QrRewardMainUI.a(QrRewardMainUI.this, QrRewardMainUI.o(QrRewardMainUI.this));
          QrRewardMainUI.a(QrRewardMainUI.this).setText("");
          QrRewardMainUI.m(QrRewardMainUI.this);
          AppMethodBeat.o(63960);
        }
      });
      this.pjl.clearFocus();
      this.pjl.setCursorVisible(false);
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