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
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.plugin.collect.reward.a.h;
import com.tencent.mm.plugin.wallet_core.ui.q.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.cra;
import com.tencent.mm.protocal.protobuf.us;
import com.tencent.mm.protocal.protobuf.vj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.Map;

public class QrRewardMainUI
  extends QrRewardBaseUI
{
  private String dMP;
  private String desc;
  private int iconWidth;
  private String kJw;
  private TextView lDu;
  private boolean mIsOpen;
  private ViewGroup pcA;
  private RelativeLayout pcB;
  private CdnImageView pcC;
  private ImageView pcD;
  private ImageView pcE;
  private MMEditText pcF;
  private TextView pcG;
  private TextView pcH;
  private TextView pcI;
  private ScrollView pcJ;
  private String pcK;
  private String pcL;
  private String pcM;
  private int pcN;
  private boolean pcO;
  private boolean pcP;
  private final int pcw;
  private RelativeLayout pcx;
  private Button pcy;
  private ViewGroup pcz;
  private String username;
  
  public QrRewardMainUI()
  {
    AppMethodBeat.i(63961);
    this.pcw = com.tencent.mm.cc.a.fromDPToPix(getContext(), 200);
    this.mIsOpen = false;
    AppMethodBeat.o(63961);
  }
  
  private void caO()
  {
    AppMethodBeat.i(63969);
    if (com.tencent.mm.plugin.collect.reward.b.a.caI().caJ())
    {
      this.pcC.aI(com.tencent.mm.plugin.collect.reward.b.a.caI().caL(), this.pcw, this.pcw);
      this.pcB.setVisibility(0);
      AppMethodBeat.o(63969);
      return;
    }
    this.pcB.setVisibility(4);
    AppMethodBeat.o(63969);
  }
  
  private void caP()
  {
    AppMethodBeat.i(63970);
    int j = Math.round(this.pcw * (this.iconWidth * 1.0F / this.pcN));
    int i = j;
    if (j <= 0) {
      i = 248;
    }
    ViewGroup.LayoutParams localLayoutParams = this.pcE.getLayoutParams();
    localLayoutParams.width = i;
    localLayoutParams.height = i;
    this.pcE.setLayoutParams(localLayoutParams);
    localLayoutParams = this.pcD.getLayoutParams();
    localLayoutParams.width = i;
    localLayoutParams.height = i;
    this.pcD.setLayoutParams(localLayoutParams);
    localLayoutParams = this.pcF.getLayoutParams();
    localLayoutParams.width = (i - 30);
    localLayoutParams.height = (i - 30);
    this.pcF.setLayoutParams(localLayoutParams);
    this.pcF.setTextSize(0, i * 2 / 3);
    this.pcA.requestLayout();
    AppMethodBeat.o(63970);
  }
  
  private void caQ()
  {
    AppMethodBeat.i(63971);
    if (!bt.isNullOrNil(this.desc))
    {
      this.lDu.setText(k.b(this, getString(2131762114, new Object[] { this.desc }), this.lDu.getTextSize()));
      AppMethodBeat.o(63971);
      return;
    }
    this.lDu.setText("");
    AppMethodBeat.o(63971);
  }
  
  private void caR()
  {
    AppMethodBeat.i(63972);
    caP();
    caQ();
    jM(bt.isNullOrNil(this.pcK));
    AppMethodBeat.o(63972);
  }
  
  private void caS()
  {
    AppMethodBeat.i(63973);
    if (!bt.isNullOrNil(this.pcL))
    {
      this.pcH.setClickable(true);
      this.pcH.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(this));
      com.tencent.mm.plugin.wallet_core.ui.q localq = new com.tencent.mm.plugin.wallet_core.ui.q(new q.a()
      {
        public final void dN(View paramAnonymousView)
        {
          AppMethodBeat.i(63949);
          ad.d("MicroMsg.QrRewardMainUI", "go to: %s", new Object[] { QrRewardMainUI.r(QrRewardMainUI.this) });
          com.tencent.mm.wallet_core.ui.e.n(QrRewardMainUI.this.getContext(), QrRewardMainUI.r(QrRewardMainUI.this), false);
          com.tencent.mm.plugin.report.service.g.yhR.f(14721, new Object[] { Integer.valueOf(1), Integer.valueOf(6) });
          AppMethodBeat.o(63949);
        }
      });
      SpannableString localSpannableString = new SpannableString(this.pcL);
      localSpannableString.setSpan(localq, 0, localSpannableString.length(), 18);
      this.pcH.setText(localSpannableString);
      this.pcH.setVisibility(0);
      AppMethodBeat.o(63973);
      return;
    }
    this.pcH.setVisibility(8);
    AppMethodBeat.o(63973);
  }
  
  private void caT()
  {
    AppMethodBeat.i(63975);
    if (!bt.isNullOrNil(this.pcK))
    {
      this.pcF.setText(k.b(getContext(), this.pcK, this.pcF.getTextSize()));
      this.pcF.setSelection(this.pcK.length());
    }
    AppMethodBeat.o(63975);
  }
  
  private void caU()
  {
    AppMethodBeat.i(63976);
    ad.i("MicroMsg.QrRewardMainUI", "do set photo word");
    h localh = new h(this.pcK);
    localh.N(this);
    doSceneProgress(localh, true);
    AppMethodBeat.o(63976);
  }
  
  private void jM(boolean paramBoolean)
  {
    AppMethodBeat.i(63974);
    ad.i("MicroMsg.QrRewardMainUI", "switch mode: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.pcD.setVisibility(0);
      this.pcF.setVisibility(4);
      a.b.a(this.pcD, this.username, 0.03F, true);
      AppMethodBeat.o(63974);
      return;
    }
    this.pcD.setVisibility(4);
    this.pcF.setVisibility(0);
    AppMethodBeat.o(63974);
  }
  
  private void m(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(63968);
    if ((this.kJw != null) && (this.kJw.equals(paramString1))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = com.tencent.mm.plugin.collect.reward.b.a.caI().caJ();
      ad.i("MicroMsg.QrRewardMainUI", "do download photo: %s, same url: %s, pic exist: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((paramBoolean) || (!bool1) || (!bool2)) {
        com.tencent.mm.plugin.collect.reward.b.a.caI().a(paramString1, paramString2, new com.tencent.mm.plugin.collect.reward.b.a.a()
        {
          public final void X(String paramAnonymousString, int paramAnonymousInt1, int paramAnonymousInt2)
          {
            AppMethodBeat.i(63948);
            ad.i("MicroMsg.QrRewardMainUI", "callback ret: %s, %s, %s", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
            if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0)) {
              aq.f(new Runnable()
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
    this.pcx = ((RelativeLayout)findViewById(2131304248));
    this.pcy = ((Button)findViewById(2131303646));
    this.pcz = ((ViewGroup)findViewById(2131303645));
    this.pcA = ((ViewGroup)findViewById(2131303644));
    this.pcC = ((CdnImageView)findViewById(2131303639));
    this.lDu = ((TextView)findViewById(2131303643));
    this.pcD = ((ImageView)findViewById(2131303638));
    this.pcE = ((ImageView)findViewById(2131303637));
    this.pcB = ((RelativeLayout)findViewById(2131303640));
    this.pcF = ((MMEditText)findViewById(2131303641));
    this.pcG = ((TextView)findViewById(2131303648));
    this.pcI = ((TextView)findViewById(2131303651));
    this.pcH = ((TextView)findViewById(2131303636));
    a.b.a(this.pcD, this.username, 0.03F, true);
    try
    {
      this.pcF.setText(k.b(getContext(), this.pcK, this.pcF.getTextSize()));
      this.pcF.setSelection(this.pcK.length());
      this.pcF.addTextChangedListener(new TextWatcher()
      {
        int pcQ = 0;
        
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(63942);
          ad.d("MicroMsg.QrRewardMainUI", "s: %s, %s", new Object[] { paramAnonymousEditable.toString(), Integer.valueOf(paramAnonymousEditable.length()) });
          String str = paramAnonymousEditable.toString();
          if (bt.isNullOrNil(str)) {
            this.pcQ = 0;
          }
          for (;;)
          {
            paramAnonymousEditable.delete(this.pcQ, paramAnonymousEditable.length());
            AppMethodBeat.o(63942);
            return;
            if (this.pcQ == 0) {
              if ((((com.tencent.mm.plugin.emoji.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.a.class)).J(str)) || (((com.tencent.mm.plugin.emoji.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.a.class)).K(str))) {
                this.pcQ = paramAnonymousEditable.length();
              } else {
                this.pcQ = 1;
              }
            }
          }
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.pcF.setOnEditorActionListener(new TextView.OnEditorActionListener()
      {
        public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(63952);
          ad.i("MicroMsg.QrRewardMainUI", "action: %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
          QrRewardMainUI.a(QrRewardMainUI.this, QrRewardMainUI.a(QrRewardMainUI.this).getText().toString());
          QrRewardMainUI.b(QrRewardMainUI.this);
          if (bt.isNullOrNil(QrRewardMainUI.c(QrRewardMainUI.this))) {
            QrRewardMainUI.a(QrRewardMainUI.this, true);
          }
          QrRewardMainUI.this.hideVKB();
          AppMethodBeat.o(63952);
          return false;
        }
      });
      this.pcE.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(63953);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/collect/reward/ui/QrRewardMainUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          ad.d("MicroMsg.QrRewardMainUI", "click avatar");
          QrRewardMainUI.this.hideVKB();
          QrRewardMainUI.d(QrRewardMainUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/reward/ui/QrRewardMainUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(63953);
        }
      });
      this.pcG.setClickable(true);
      this.pcG.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(this));
      com.tencent.mm.plugin.wallet_core.ui.q localq = new com.tencent.mm.plugin.wallet_core.ui.q(new q.a()
      {
        public final void dN(View paramAnonymousView)
        {
          AppMethodBeat.i(63954);
          ad.i("MicroMsg.QrRewardMainUI", "click save code");
          p.a(QrRewardMainUI.this, new Runnable()new Runnable
          {
            public final void run()
            {
              AppMethodBeat.i(198950);
              QrRewardMainUI.e(QrRewardMainUI.this);
              com.tencent.mm.plugin.report.service.g.yhR.f(14721, new Object[] { Integer.valueOf(1), Integer.valueOf(5) });
              AppMethodBeat.o(198950);
            }
          }, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(198951);
              Toast.makeText(QrRewardMainUI.this, 2131762779, 1).show();
              AppMethodBeat.o(198951);
            }
          });
          AppMethodBeat.o(63954);
        }
      });
      SpannableString localSpannableString = new SpannableString(getString(2131762101));
      localSpannableString.setSpan(localq, 0, localSpannableString.length(), 18);
      this.pcG.setText(localSpannableString);
      this.pcI.setClickable(true);
      this.pcI.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(this));
      localq = new com.tencent.mm.plugin.wallet_core.ui.q(new q.a()
      {
        public final void dN(View paramAnonymousView)
        {
          AppMethodBeat.i(63955);
          ad.i("MicroMsg.QrRewardMainUI", "click set code, %s", new Object[] { Boolean.valueOf(QrRewardMainUI.f(QrRewardMainUI.this)) });
          QrRewardMainUI.b(QrRewardMainUI.this, false);
          AppMethodBeat.o(63955);
        }
      });
      localSpannableString = new SpannableString(getString(2131762111));
      localSpannableString.setSpan(localq, 0, localSpannableString.length(), 18);
      this.pcI.setText(localSpannableString);
      caO();
      caR();
      caT();
      caS();
      AppMethodBeat.o(63963);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.QrRewardMainUI", localException, "", new Object[0]);
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
        this.pcN = paramIntent.getIntExtra("key_photo_width", 900);
        this.iconWidth = paramIntent.getIntExtra("key_icon_width", 343);
        boolean bool = paramIntent.getBooleanExtra("key_return_from_first", true);
        ad.i("MicroMsg.QrRewardMainUI", "return from first: %s", new Object[] { Boolean.valueOf(bool) });
        if (bool)
        {
          this.pcA.setVisibility(0);
          this.pcz.setVisibility(8);
        }
        this.pcP = true;
        caR();
        String str = paramIntent.getStringExtra("key_photo_url");
        m(str, paramIntent.getStringExtra("key_photo_aeskey"), true);
        this.kJw = str;
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
    this.pcN = ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IBs, Integer.valueOf(900))).intValue();
    this.iconWidth = ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IBt, Integer.valueOf(343))).intValue();
    this.desc = ((String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IBv, ""));
    this.pcK = ((String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IBu, ""));
    this.pcL = ((String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IBz, ""));
    this.pcM = ((String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IBA, ""));
    this.kJw = ((String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IBB, ""));
    if (!bt.isNullOrNil((String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IBy, ""))) {
      this.pcP = true;
    }
    this.username = u.aAm();
    setMMTitle(2131762096);
    initView();
    if ((com.tencent.mm.plugin.collect.reward.b.a.caI().caJ()) && (this.pcP)) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.QrRewardMainUI", "do get code: %s", new Object[] { Boolean.valueOf(bool) });
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
    com.tencent.mm.plugin.collect.reward.b.a locala = com.tencent.mm.plugin.collect.reward.b.a.caI();
    ad.d("MicroMsg.QrRewardCdnDownloadHelper", "do clear callback");
    if (locala.nyV != null)
    {
      ad.i("MicroMsg.QrRewardCdnDownloadHelper", "callback size: %s", new Object[] { Integer.valueOf(locala.nyV.size()) });
      locala.nyV.clear();
    }
    AppMethodBeat.o(63967);
  }
  
  public void onKeyboardStateChanged()
  {
    AppMethodBeat.i(63965);
    super.onKeyboardStateChanged();
    ad.i("MicroMsg.QrRewardMainUI", "key board changed: %s", new Object[] { Integer.valueOf(keyboardState()) });
    if (keyboardState() == 2)
    {
      this.pcK = this.pcF.getText().toString();
      caU();
      if (bt.isNullOrNil(this.pcK)) {
        jM(true);
      }
    }
    AppMethodBeat.o(63965);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(63964);
    if ((paramn instanceof com.tencent.mm.plugin.collect.reward.a.b))
    {
      paramString = (com.tencent.mm.plugin.collect.reward.a.b)paramn;
      paramString.a(new com.tencent.mm.plugin.collect.reward.a.a.a()
      {
        public final void g(com.tencent.mm.al.n paramAnonymousn)
        {
          AppMethodBeat.i(63959);
          QrRewardMainUI.a(QrRewardMainUI.this, paramString.pbJ.nZO);
          QrRewardMainUI.a(QrRewardMainUI.this, paramString.pbJ.FUn);
          QrRewardMainUI.b(QrRewardMainUI.this, paramString.pbJ.FUj);
          QrRewardMainUI.b(QrRewardMainUI.this, paramString.pbJ.desc);
          QrRewardMainUI.c(QrRewardMainUI.this, paramString.pbJ.CTa);
          paramAnonymousn = QrRewardMainUI.this;
          boolean bool;
          if (!paramString.pbJ.FUh)
          {
            bool = true;
            QrRewardMainUI.c(paramAnonymousn, bool);
            QrRewardMainUI.d(QrRewardMainUI.this, paramString.pbJ.ozC);
            QrRewardMainUI.e(QrRewardMainUI.this, paramString.pbJ.FUl);
            QrRewardMainUI.h(QrRewardMainUI.this);
            QrRewardMainUI.i(QrRewardMainUI.this);
            if (QrRewardMainUI.j(QrRewardMainUI.this)) {
              break label242;
            }
            QrRewardMainUI.k(QrRewardMainUI.this);
          }
          for (;;)
          {
            QrRewardMainUI.f(QrRewardMainUI.this, paramString.pbJ.xXy);
            QrRewardMainUI.caV();
            ad.d("MicroMsg.QrRewardMainUI", "url: %s", new Object[] { QrRewardMainUI.n(QrRewardMainUI.this) });
            AppMethodBeat.o(63959);
            return;
            bool = false;
            break;
            label242:
            QrRewardMainUI.a(QrRewardMainUI.this, paramString.pbJ.xXy, paramString.pbJ.FUi);
            QrRewardMainUI.l(QrRewardMainUI.this);
            QrRewardMainUI.m(QrRewardMainUI.this);
          }
        }
      }).b(new com.tencent.mm.plugin.collect.reward.a.a.a()
      {
        public final void g(com.tencent.mm.al.n paramAnonymousn)
        {
          boolean bool = true;
          AppMethodBeat.i(63958);
          ad.e("MicroMsg.QrRewardMainUI", "get code error: %s, %s", new Object[] { Integer.valueOf(paramString.pbJ.dlw), paramString.pbJ.paA });
          if (paramString.pbJ.dlw == 416)
          {
            if (paramString.pbJ.FTQ == null) {}
            for (;;)
            {
              ad.d("MicroMsg.QrRewardMainUI", "realNameInfo:%s", new Object[] { Boolean.valueOf(bool) });
              QrRewardMainUI.g(QrRewardMainUI.this).setVisibility(4);
              paramAnonymousn = new Bundle();
              paramAnonymousn.putString("realname_verify_process_jump_activity", ".reward.ui.CollectMainUI");
              paramAnonymousn.putString("realname_verify_process_jump_plugin", "collect");
              QrRewardMainUI localQrRewardMainUI = QrRewardMainUI.this;
              int i = paramString.pbJ.dlw;
              cra localcra = paramString.pbJ.FTQ;
              new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(63957);
                  ad.i("MicroMsg.QrRewardMainUI", "RealnameVerifyUtil cancel");
                  AppMethodBeat.o(63957);
                }
              };
              com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(localQrRewardMainUI, i, localcra, paramAnonymousn, 1011);
              AppMethodBeat.o(63958);
              return;
              bool = false;
            }
          }
          if (!bt.isNullOrNil(paramString.pbJ.paA)) {
            Toast.makeText(QrRewardMainUI.this, paramString.pbJ.paA, 0).show();
          }
          if (!paramString.pbK) {
            QrRewardMainUI.b(QrRewardMainUI.this, false);
          }
          AppMethodBeat.o(63958);
        }
      }).c(new com.tencent.mm.plugin.collect.reward.a.a.a()
      {
        public final void g(com.tencent.mm.al.n paramAnonymousn)
        {
          AppMethodBeat.i(63956);
          ad.e("MicroMsg.QrRewardMainUI", "net error: %s", new Object[] { paramAnonymousn });
          if (!paramString.pbK) {
            QrRewardMainUI.b(QrRewardMainUI.this, false);
          }
          AppMethodBeat.o(63956);
        }
      });
      AppMethodBeat.o(63964);
      return true;
    }
    if ((paramn instanceof h))
    {
      paramString = (h)paramn;
      paramString.a(new com.tencent.mm.plugin.collect.reward.a.a.a()
      {
        public final void g(com.tencent.mm.al.n paramAnonymousn)
        {
          AppMethodBeat.i(63944);
          ad.i("MicroMsg.QrRewardMainUI", "set succ: %s, %s", new Object[] { paramString.nZO, QrRewardMainUI.a(QrRewardMainUI.this).getText() });
          if (paramString.nZO.equals(QrRewardMainUI.c(QrRewardMainUI.this)))
          {
            com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IBu, QrRewardMainUI.c(QrRewardMainUI.this));
            QrRewardMainUI.m(QrRewardMainUI.this);
          }
          AppMethodBeat.o(63944);
        }
      }).b(new com.tencent.mm.plugin.collect.reward.a.a.a()
      {
        public final void g(com.tencent.mm.al.n paramAnonymousn)
        {
          AppMethodBeat.i(63943);
          ad.e("MicroMsg.QrRewardMainUI", "set word error: %s, %s", new Object[] { Integer.valueOf(paramString.pbQ.dlw), paramString.pbQ.paA });
          QrRewardMainUI.a(QrRewardMainUI.this, (String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IBu, ""));
          QrRewardMainUI.a(QrRewardMainUI.this, QrRewardMainUI.o(QrRewardMainUI.this));
          QrRewardMainUI.a(QrRewardMainUI.this).setText("");
          QrRewardMainUI.m(QrRewardMainUI.this);
          if (!bt.isNullOrNil(paramString.pbQ.paA)) {
            Toast.makeText(QrRewardMainUI.this, paramString.pbQ.paA, 0).show();
          }
          AppMethodBeat.o(63943);
        }
      }).c(new com.tencent.mm.plugin.collect.reward.a.a.a()
      {
        public final void g(com.tencent.mm.al.n paramAnonymousn)
        {
          AppMethodBeat.i(63960);
          ad.e("MicroMsg.QrRewardMainUI", "net error: %s", new Object[] { paramAnonymousn });
          QrRewardMainUI.a(QrRewardMainUI.this, (String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IBu, ""));
          QrRewardMainUI.a(QrRewardMainUI.this, QrRewardMainUI.o(QrRewardMainUI.this));
          QrRewardMainUI.a(QrRewardMainUI.this).setText("");
          QrRewardMainUI.m(QrRewardMainUI.this);
          AppMethodBeat.o(63960);
        }
      });
      this.pcF.clearFocus();
      this.pcF.setCursorVisible(false);
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