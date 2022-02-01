package com.tencent.mm.plugin.collect.reward.ui;

import android.app.Activity;
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
import com.tencent.mm.plugin.collect.reward.a.b;
import com.tencent.mm.plugin.wallet_core.ui.q.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.cgx;
import com.tencent.mm.protocal.protobuf.sn;
import com.tencent.mm.protocal.protobuf.te;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.Map;

public class QrRewardMainUI
  extends QrRewardBaseUI
{
  private String dCQ;
  private String desc;
  private int duc;
  private String jNV;
  private TextView kFd;
  private boolean mIsOpen;
  private final int nVG;
  private RelativeLayout nVH;
  private Button nVI;
  private ViewGroup nVJ;
  private ViewGroup nVK;
  private RelativeLayout nVL;
  private CdnImageView nVM;
  private ImageView nVN;
  private ImageView nVO;
  private MMEditText nVP;
  private TextView nVQ;
  private TextView nVR;
  private TextView nVS;
  private ScrollView nVT;
  private String nVU;
  private String nVV;
  private String nVW;
  private int nVX;
  private boolean nVY;
  private boolean nVZ;
  private String username;
  
  public QrRewardMainUI()
  {
    AppMethodBeat.i(63961);
    this.nVG = com.tencent.mm.cd.a.fromDPToPix(getContext(), 200);
    this.mIsOpen = false;
    AppMethodBeat.o(63961);
  }
  
  private void bOV()
  {
    AppMethodBeat.i(63969);
    if (com.tencent.mm.plugin.collect.reward.b.a.bOP().bOQ())
    {
      this.nVM.aB(com.tencent.mm.plugin.collect.reward.b.a.bOP().bOS(), this.nVG, this.nVG);
      this.nVL.setVisibility(0);
      AppMethodBeat.o(63969);
      return;
    }
    this.nVL.setVisibility(4);
    AppMethodBeat.o(63969);
  }
  
  private void bOW()
  {
    AppMethodBeat.i(63970);
    int j = Math.round(this.nVG * (this.duc * 1.0F / this.nVX));
    int i = j;
    if (j <= 0) {
      i = 248;
    }
    ViewGroup.LayoutParams localLayoutParams = this.nVO.getLayoutParams();
    localLayoutParams.width = i;
    localLayoutParams.height = i;
    this.nVO.setLayoutParams(localLayoutParams);
    localLayoutParams = this.nVN.getLayoutParams();
    localLayoutParams.width = i;
    localLayoutParams.height = i;
    this.nVN.setLayoutParams(localLayoutParams);
    localLayoutParams = this.nVP.getLayoutParams();
    localLayoutParams.width = (i - 30);
    localLayoutParams.height = (i - 30);
    this.nVP.setLayoutParams(localLayoutParams);
    this.nVP.setTextSize(0, i * 2 / 3);
    this.nVK.requestLayout();
    AppMethodBeat.o(63970);
  }
  
  private void bOX()
  {
    AppMethodBeat.i(63971);
    if (!bt.isNullOrNil(this.desc))
    {
      this.kFd.setText(k.b(this, getString(2131762114, new Object[] { this.desc }), this.kFd.getTextSize()));
      AppMethodBeat.o(63971);
      return;
    }
    this.kFd.setText("");
    AppMethodBeat.o(63971);
  }
  
  private void bOY()
  {
    AppMethodBeat.i(63972);
    bOW();
    bOX();
    iY(bt.isNullOrNil(this.nVU));
    AppMethodBeat.o(63972);
  }
  
  private void bOZ()
  {
    AppMethodBeat.i(63973);
    if (!bt.isNullOrNil(this.nVV))
    {
      this.nVR.setClickable(true);
      this.nVR.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(this));
      com.tencent.mm.plugin.wallet_core.ui.q localq = new com.tencent.mm.plugin.wallet_core.ui.q(new q.a()
      {
        public final void dI(View paramAnonymousView)
        {
          AppMethodBeat.i(63949);
          ad.d("MicroMsg.QrRewardMainUI", "go to: %s", new Object[] { QrRewardMainUI.r(QrRewardMainUI.this) });
          com.tencent.mm.wallet_core.ui.e.o(QrRewardMainUI.this.getContext(), QrRewardMainUI.r(QrRewardMainUI.this), false);
          com.tencent.mm.plugin.report.service.h.vKh.f(14721, new Object[] { Integer.valueOf(1), Integer.valueOf(6) });
          AppMethodBeat.o(63949);
        }
      });
      SpannableString localSpannableString = new SpannableString(this.nVV);
      localSpannableString.setSpan(localq, 0, localSpannableString.length(), 18);
      this.nVR.setText(localSpannableString);
      this.nVR.setVisibility(0);
      AppMethodBeat.o(63973);
      return;
    }
    this.nVR.setVisibility(8);
    AppMethodBeat.o(63973);
  }
  
  private void bPa()
  {
    AppMethodBeat.i(63975);
    if (!bt.isNullOrNil(this.nVU))
    {
      this.nVP.setText(k.b(getContext(), this.nVU, this.nVP.getTextSize()));
      this.nVP.setSelection(this.nVU.length());
    }
    AppMethodBeat.o(63975);
  }
  
  private void bPb()
  {
    AppMethodBeat.i(63976);
    ad.i("MicroMsg.QrRewardMainUI", "do set photo word");
    com.tencent.mm.plugin.collect.reward.a.h localh = new com.tencent.mm.plugin.collect.reward.a.h(this.nVU);
    localh.N(this);
    doSceneProgress(localh, true);
    AppMethodBeat.o(63976);
  }
  
  private void iY(boolean paramBoolean)
  {
    AppMethodBeat.i(63974);
    ad.i("MicroMsg.QrRewardMainUI", "switch mode: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.nVN.setVisibility(0);
      this.nVP.setVisibility(4);
      a.b.a(this.nVN, this.username, 0.03F, true);
      AppMethodBeat.o(63974);
      return;
    }
    this.nVN.setVisibility(4);
    this.nVP.setVisibility(0);
    AppMethodBeat.o(63974);
  }
  
  private void m(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(63968);
    if ((this.jNV != null) && (this.jNV.equals(paramString1))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = com.tencent.mm.plugin.collect.reward.b.a.bOP().bOQ();
      ad.i("MicroMsg.QrRewardMainUI", "do download photo: %s, same url: %s, pic exist: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((paramBoolean) || (!bool1) || (!bool2)) {
        com.tencent.mm.plugin.collect.reward.b.a.bOP().a(paramString1, paramString2, new com.tencent.mm.plugin.collect.reward.b.a.a()
        {
          public final void W(String paramAnonymousString, int paramAnonymousInt1, int paramAnonymousInt2)
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
    this.nVH = ((RelativeLayout)findViewById(2131304248));
    this.nVI = ((Button)findViewById(2131303646));
    this.nVJ = ((ViewGroup)findViewById(2131303645));
    this.nVK = ((ViewGroup)findViewById(2131303644));
    this.nVM = ((CdnImageView)findViewById(2131303639));
    this.kFd = ((TextView)findViewById(2131303643));
    this.nVN = ((ImageView)findViewById(2131303638));
    this.nVO = ((ImageView)findViewById(2131303637));
    this.nVL = ((RelativeLayout)findViewById(2131303640));
    this.nVP = ((MMEditText)findViewById(2131303641));
    this.nVQ = ((TextView)findViewById(2131303648));
    this.nVS = ((TextView)findViewById(2131303651));
    this.nVR = ((TextView)findViewById(2131303636));
    a.b.a(this.nVN, this.username, 0.03F, true);
    try
    {
      this.nVP.setText(k.b(getContext(), this.nVU, this.nVP.getTextSize()));
      this.nVP.setSelection(this.nVU.length());
      this.nVP.addTextChangedListener(new TextWatcher()
      {
        int nWa = 0;
        
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(63942);
          ad.d("MicroMsg.QrRewardMainUI", "s: %s, %s", new Object[] { paramAnonymousEditable.toString(), Integer.valueOf(paramAnonymousEditable.length()) });
          String str = paramAnonymousEditable.toString();
          if (bt.isNullOrNil(str)) {
            this.nWa = 0;
          }
          for (;;)
          {
            paramAnonymousEditable.delete(this.nWa, paramAnonymousEditable.length());
            AppMethodBeat.o(63942);
            return;
            if (this.nWa == 0) {
              if ((((com.tencent.mm.plugin.emoji.b.a)g.ab(com.tencent.mm.plugin.emoji.b.a.class)).J(str)) || (((com.tencent.mm.plugin.emoji.b.a)g.ab(com.tencent.mm.plugin.emoji.b.a.class)).K(str))) {
                this.nWa = paramAnonymousEditable.length();
              } else {
                this.nWa = 1;
              }
            }
          }
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.nVP.setOnEditorActionListener(new TextView.OnEditorActionListener()
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
      this.nVO.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(63953);
          ad.d("MicroMsg.QrRewardMainUI", "click avatar");
          QrRewardMainUI.this.hideVKB();
          QrRewardMainUI.d(QrRewardMainUI.this);
          AppMethodBeat.o(63953);
        }
      });
      this.nVQ.setClickable(true);
      this.nVQ.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(this));
      com.tencent.mm.plugin.wallet_core.ui.q localq = new com.tencent.mm.plugin.wallet_core.ui.q(new q.a()
      {
        public final void dI(View paramAnonymousView)
        {
          AppMethodBeat.i(63954);
          ad.i("MicroMsg.QrRewardMainUI", "click save code");
          p.a(QrRewardMainUI.this, new Runnable()new Runnable
          {
            public final void run()
            {
              AppMethodBeat.i(186990);
              QrRewardMainUI.e(QrRewardMainUI.this);
              com.tencent.mm.plugin.report.service.h.vKh.f(14721, new Object[] { Integer.valueOf(1), Integer.valueOf(5) });
              AppMethodBeat.o(186990);
            }
          }, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(186991);
              Toast.makeText(QrRewardMainUI.this, 2131762779, 1).show();
              AppMethodBeat.o(186991);
            }
          });
          AppMethodBeat.o(63954);
        }
      });
      SpannableString localSpannableString = new SpannableString(getString(2131762101));
      localSpannableString.setSpan(localq, 0, localSpannableString.length(), 18);
      this.nVQ.setText(localSpannableString);
      this.nVS.setClickable(true);
      this.nVS.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(this));
      localq = new com.tencent.mm.plugin.wallet_core.ui.q(new q.a()
      {
        public final void dI(View paramAnonymousView)
        {
          AppMethodBeat.i(63955);
          ad.i("MicroMsg.QrRewardMainUI", "click set code, %s", new Object[] { Boolean.valueOf(QrRewardMainUI.f(QrRewardMainUI.this)) });
          QrRewardMainUI.b(QrRewardMainUI.this, false);
          AppMethodBeat.o(63955);
        }
      });
      localSpannableString = new SpannableString(getString(2131762111));
      localSpannableString.setSpan(localq, 0, localSpannableString.length(), 18);
      this.nVS.setText(localSpannableString);
      bOV();
      bOY();
      bPa();
      bOZ();
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
        this.nVX = paramIntent.getIntExtra("key_photo_width", 900);
        this.duc = paramIntent.getIntExtra("key_icon_width", 343);
        boolean bool = paramIntent.getBooleanExtra("key_return_from_first", true);
        ad.i("MicroMsg.QrRewardMainUI", "return from first: %s", new Object[] { Boolean.valueOf(bool) });
        if (bool)
        {
          this.nVK.setVisibility(0);
          this.nVJ.setVisibility(8);
        }
        this.nVZ = true;
        bOY();
        String str = paramIntent.getStringExtra("key_photo_url");
        m(str, paramIntent.getStringExtra("key_photo_aeskey"), true);
        this.jNV = str;
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
    this.nVX = ((Integer)g.afB().afk().get(ae.a.Frh, Integer.valueOf(900))).intValue();
    this.duc = ((Integer)g.afB().afk().get(ae.a.Fri, Integer.valueOf(343))).intValue();
    this.desc = ((String)g.afB().afk().get(ae.a.Frk, ""));
    this.nVU = ((String)g.afB().afk().get(ae.a.Frj, ""));
    this.nVV = ((String)g.afB().afk().get(ae.a.Fro, ""));
    this.nVW = ((String)g.afB().afk().get(ae.a.Frp, ""));
    this.jNV = ((String)g.afB().afk().get(ae.a.Frq, ""));
    if (!bt.isNullOrNil((String)g.afB().afk().get(ae.a.Frn, ""))) {
      this.nVZ = true;
    }
    this.username = u.aqG();
    setMMTitle(2131762096);
    initView();
    if ((com.tencent.mm.plugin.collect.reward.b.a.bOP().bOQ()) && (this.nVZ)) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.QrRewardMainUI", "do get code: %s", new Object[] { Boolean.valueOf(bool) });
      paramBundle = new b(bool);
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
    com.tencent.mm.plugin.collect.reward.b.a locala = com.tencent.mm.plugin.collect.reward.b.a.bOP();
    ad.d("MicroMsg.QrRewardCdnDownloadHelper", "do clear callback");
    if (locala.mwx != null)
    {
      ad.i("MicroMsg.QrRewardCdnDownloadHelper", "callback size: %s", new Object[] { Integer.valueOf(locala.mwx.size()) });
      locala.mwx.clear();
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
      this.nVU = this.nVP.getText().toString();
      bPb();
      if (bt.isNullOrNil(this.nVU)) {
        iY(true);
      }
    }
    AppMethodBeat.o(63965);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(63964);
    if ((paramn instanceof b))
    {
      paramString = (b)paramn;
      paramString.a(new com.tencent.mm.plugin.collect.reward.a.a.a()
      {
        public final void h(com.tencent.mm.al.n paramAnonymousn)
        {
          AppMethodBeat.i(63959);
          QrRewardMainUI.a(QrRewardMainUI.this, paramString.nUT.mVR);
          QrRewardMainUI.a(QrRewardMainUI.this, paramString.nUT.CUu);
          QrRewardMainUI.b(QrRewardMainUI.this, paramString.nUT.CUq);
          QrRewardMainUI.b(QrRewardMainUI.this, paramString.nUT.desc);
          QrRewardMainUI.c(QrRewardMainUI.this, paramString.nUT.Aar);
          paramAnonymousn = QrRewardMainUI.this;
          boolean bool;
          if (!paramString.nUT.CUo)
          {
            bool = true;
            QrRewardMainUI.c(paramAnonymousn, bool);
            QrRewardMainUI.d(QrRewardMainUI.this, paramString.nUT.nti);
            QrRewardMainUI.e(QrRewardMainUI.this, paramString.nUT.CUs);
            QrRewardMainUI.h(QrRewardMainUI.this);
            QrRewardMainUI.i(QrRewardMainUI.this);
            if (QrRewardMainUI.j(QrRewardMainUI.this)) {
              break label242;
            }
            QrRewardMainUI.k(QrRewardMainUI.this);
          }
          for (;;)
          {
            QrRewardMainUI.f(QrRewardMainUI.this, paramString.nUT.vzM);
            QrRewardMainUI.bPc();
            ad.d("MicroMsg.QrRewardMainUI", "url: %s", new Object[] { QrRewardMainUI.n(QrRewardMainUI.this) });
            AppMethodBeat.o(63959);
            return;
            bool = false;
            break;
            label242:
            QrRewardMainUI.a(QrRewardMainUI.this, paramString.nUT.vzM, paramString.nUT.CUp);
            QrRewardMainUI.l(QrRewardMainUI.this);
            QrRewardMainUI.m(QrRewardMainUI.this);
          }
        }
      }).b(new com.tencent.mm.plugin.collect.reward.a.a.a()
      {
        public final void h(com.tencent.mm.al.n paramAnonymousn)
        {
          boolean bool = true;
          AppMethodBeat.i(63958);
          ad.e("MicroMsg.QrRewardMainUI", "get code error: %s, %s", new Object[] { Integer.valueOf(paramString.nUT.dcG), paramString.nUT.nTK });
          if (paramString.nUT.dcG == 416)
          {
            if (paramString.nUT.CTW == null) {}
            for (;;)
            {
              ad.d("MicroMsg.QrRewardMainUI", "realNameInfo:%s", new Object[] { Boolean.valueOf(bool) });
              QrRewardMainUI.g(QrRewardMainUI.this).setVisibility(4);
              paramAnonymousn = new Bundle();
              paramAnonymousn.putString("realname_verify_process_jump_activity", ".reward.ui.CollectMainUI");
              paramAnonymousn.putString("realname_verify_process_jump_plugin", "collect");
              QrRewardMainUI localQrRewardMainUI = QrRewardMainUI.this;
              int i = paramString.nUT.dcG;
              cgx localcgx = paramString.nUT.CTW;
              new QrRewardMainUI.15.1(this);
              com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(localQrRewardMainUI, i, localcgx, paramAnonymousn, 1011);
              AppMethodBeat.o(63958);
              return;
              bool = false;
            }
          }
          if (!bt.isNullOrNil(paramString.nUT.nTK)) {
            Toast.makeText(QrRewardMainUI.this, paramString.nUT.nTK, 0).show();
          }
          if (!paramString.nUU) {
            QrRewardMainUI.b(QrRewardMainUI.this, false);
          }
          AppMethodBeat.o(63958);
        }
      }).c(new com.tencent.mm.plugin.collect.reward.a.a.a()
      {
        public final void h(com.tencent.mm.al.n paramAnonymousn)
        {
          AppMethodBeat.i(63956);
          ad.e("MicroMsg.QrRewardMainUI", "net error: %s", new Object[] { paramAnonymousn });
          if (!paramString.nUU) {
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
        public final void h(com.tencent.mm.al.n paramAnonymousn)
        {
          AppMethodBeat.i(63944);
          ad.i("MicroMsg.QrRewardMainUI", "set succ: %s, %s", new Object[] { paramString.mVR, QrRewardMainUI.a(QrRewardMainUI.this).getText() });
          if (paramString.mVR.equals(QrRewardMainUI.c(QrRewardMainUI.this)))
          {
            g.afB().afk().set(ae.a.Frj, QrRewardMainUI.c(QrRewardMainUI.this));
            QrRewardMainUI.m(QrRewardMainUI.this);
          }
          AppMethodBeat.o(63944);
        }
      }).b(new com.tencent.mm.plugin.collect.reward.a.a.a()
      {
        public final void h(com.tencent.mm.al.n paramAnonymousn)
        {
          AppMethodBeat.i(63943);
          ad.e("MicroMsg.QrRewardMainUI", "set word error: %s, %s", new Object[] { Integer.valueOf(paramString.nVa.dcG), paramString.nVa.nTK });
          QrRewardMainUI.a(QrRewardMainUI.this, (String)g.afB().afk().get(ae.a.Frj, ""));
          QrRewardMainUI.a(QrRewardMainUI.this, QrRewardMainUI.o(QrRewardMainUI.this));
          QrRewardMainUI.a(QrRewardMainUI.this).setText("");
          QrRewardMainUI.m(QrRewardMainUI.this);
          if (!bt.isNullOrNil(paramString.nVa.nTK)) {
            Toast.makeText(QrRewardMainUI.this, paramString.nVa.nTK, 0).show();
          }
          AppMethodBeat.o(63943);
        }
      }).c(new com.tencent.mm.plugin.collect.reward.a.a.a()
      {
        public final void h(com.tencent.mm.al.n paramAnonymousn)
        {
          AppMethodBeat.i(63960);
          ad.e("MicroMsg.QrRewardMainUI", "net error: %s", new Object[] { paramAnonymousn });
          QrRewardMainUI.a(QrRewardMainUI.this, (String)g.afB().afk().get(ae.a.Frj, ""));
          QrRewardMainUI.a(QrRewardMainUI.this, QrRewardMainUI.o(QrRewardMainUI.this));
          QrRewardMainUI.a(QrRewardMainUI.this).setText("");
          QrRewardMainUI.m(QrRewardMainUI.this);
          AppMethodBeat.o(63960);
        }
      });
      this.nVP.clearFocus();
      this.nVP.setCursorVisible(false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI
 * JD-Core Version:    0.7.0.1
 */