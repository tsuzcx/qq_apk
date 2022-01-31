package com.tencent.mm.plugin.collect.reward.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.collect.reward.a.a.a;
import com.tencent.mm.plugin.collect.reward.a.b;
import com.tencent.mm.plugin.collect.reward.a.h;
import com.tencent.mm.plugin.wallet_core.ui.o;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.protobuf.qr;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.Map;

public class QrRewardMainUI
  extends QrRewardBaseUI
{
  private int cDA;
  private String cLS;
  private String desc;
  private String hJS;
  private MMEditText kPA;
  private TextView kPB;
  private TextView kPC;
  private TextView kPD;
  private TextView kPE;
  private ScrollView kPF;
  private String kPG;
  private String kPH;
  private String kPI;
  private int kPJ;
  private boolean kPK;
  private boolean kPL;
  private final int kPr;
  private RelativeLayout kPs;
  private Button kPt;
  private ViewGroup kPu;
  private ViewGroup kPv;
  private RelativeLayout kPw;
  private CdnImageView kPx;
  private ImageView kPy;
  private ImageView kPz;
  private boolean mIsOpen;
  private String username;
  
  public QrRewardMainUI()
  {
    AppMethodBeat.i(41102);
    this.kPr = com.tencent.mm.cb.a.fromDPToPix(getContext(), 200);
    this.mIsOpen = false;
    AppMethodBeat.o(41102);
  }
  
  private void bhY()
  {
    AppMethodBeat.i(41110);
    if (com.tencent.mm.plugin.collect.reward.b.a.bhT().bhU())
    {
      this.kPx.ax(com.tencent.mm.plugin.collect.reward.b.a.bhT().bhW(), this.kPr, this.kPr);
      this.kPw.setVisibility(0);
      AppMethodBeat.o(41110);
      return;
    }
    this.kPw.setVisibility(4);
    AppMethodBeat.o(41110);
  }
  
  private void bhZ()
  {
    AppMethodBeat.i(41111);
    int j = Math.round(this.kPr * (this.cDA * 1.0F / this.kPJ));
    int i = j;
    if (j <= 0) {
      i = 248;
    }
    ViewGroup.LayoutParams localLayoutParams = this.kPz.getLayoutParams();
    localLayoutParams.width = i;
    localLayoutParams.height = i;
    this.kPz.setLayoutParams(localLayoutParams);
    localLayoutParams = this.kPy.getLayoutParams();
    localLayoutParams.width = i;
    localLayoutParams.height = i;
    this.kPy.setLayoutParams(localLayoutParams);
    localLayoutParams = this.kPA.getLayoutParams();
    localLayoutParams.width = (i - 30);
    localLayoutParams.height = (i - 30);
    this.kPA.setLayoutParams(localLayoutParams);
    this.kPA.setTextSize(0, i * 2 / 3);
    this.kPv.requestLayout();
    AppMethodBeat.o(41111);
  }
  
  private void bia()
  {
    AppMethodBeat.i(41112);
    if (!bo.isNullOrNil(this.desc))
    {
      this.kPB.setText(j.b(this, getString(2131302235, new Object[] { this.desc }), this.kPB.getTextSize()));
      AppMethodBeat.o(41112);
      return;
    }
    this.kPB.setText("");
    AppMethodBeat.o(41112);
  }
  
  private void bib()
  {
    AppMethodBeat.i(41113);
    bhZ();
    bia();
    gm(bo.isNullOrNil(this.kPG));
    AppMethodBeat.o(41113);
  }
  
  private void bic()
  {
    AppMethodBeat.i(41114);
    if (!bo.isNullOrNil(this.kPH))
    {
      this.kPD.setClickable(true);
      this.kPD.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m(this));
      o localo = new o(new QrRewardMainUI.7(this));
      SpannableString localSpannableString = new SpannableString(this.kPH);
      localSpannableString.setSpan(localo, 0, localSpannableString.length(), 18);
      this.kPD.setText(localSpannableString);
      this.kPD.setVisibility(0);
      AppMethodBeat.o(41114);
      return;
    }
    this.kPD.setVisibility(8);
    AppMethodBeat.o(41114);
  }
  
  private void bid()
  {
    AppMethodBeat.i(41116);
    if (!bo.isNullOrNil(this.kPG))
    {
      this.kPA.setText(j.b(getContext(), this.kPG, this.kPA.getTextSize()));
      this.kPA.setSelection(this.kPG.length());
    }
    AppMethodBeat.o(41116);
  }
  
  private void bie()
  {
    AppMethodBeat.i(41117);
    ab.i("MicroMsg.QrRewardMainUI", "do set photo word");
    h localh = new h(this.kPG);
    localh.z(this);
    doSceneProgress(localh, true);
    AppMethodBeat.o(41117);
  }
  
  private void gm(boolean paramBoolean)
  {
    AppMethodBeat.i(41115);
    ab.i("MicroMsg.QrRewardMainUI", "switch mode: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.kPy.setVisibility(0);
      this.kPA.setVisibility(4);
      a.b.a(this.kPy, this.username, 0.03F, true);
      AppMethodBeat.o(41115);
      return;
    }
    this.kPy.setVisibility(4);
    this.kPA.setVisibility(0);
    AppMethodBeat.o(41115);
  }
  
  private void n(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(41109);
    if ((this.hJS != null) && (this.hJS.equals(paramString1))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = com.tencent.mm.plugin.collect.reward.b.a.bhT().bhU();
      ab.i("MicroMsg.QrRewardMainUI", "do download photo: %s, same url: %s, pic exist: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((paramBoolean) || (!bool1) || (!bool2)) {
        com.tencent.mm.plugin.collect.reward.b.a.bhT().a(paramString1, paramString2, new QrRewardMainUI.6(this));
      }
      AppMethodBeat.o(41109);
      return;
    }
  }
  
  public int getLayoutId()
  {
    return 2130970489;
  }
  
  public void initView()
  {
    AppMethodBeat.i(41104);
    this.kPs = ((RelativeLayout)findViewById(2131826937));
    this.kPt = ((Button)findViewById(2131826940));
    this.kPu = ((ViewGroup)findViewById(2131826939));
    this.kPv = ((ViewGroup)findViewById(2131826941));
    this.kPx = ((CdnImageView)findViewById(2131826943));
    this.kPB = ((TextView)findViewById(2131826947));
    this.kPy = ((ImageView)findViewById(2131826944));
    this.kPz = ((ImageView)findViewById(2131826946));
    this.kPw = ((RelativeLayout)findViewById(2131826942));
    this.kPA = ((MMEditText)findViewById(2131826945));
    this.kPC = ((TextView)findViewById(2131826949));
    this.kPE = ((TextView)findViewById(2131826950));
    this.kPD = ((TextView)findViewById(2131826951));
    a.b.a(this.kPy, this.username, 0.03F, true);
    try
    {
      this.kPA.setText(j.b(getContext(), this.kPG, this.kPA.getTextSize()));
      this.kPA.setSelection(this.kPG.length());
      this.kPA.addTextChangedListener(new QrRewardMainUI.1(this));
      this.kPA.setOnEditorActionListener(new QrRewardMainUI.10(this));
      this.kPz.setOnClickListener(new QrRewardMainUI.11(this));
      this.kPC.setClickable(true);
      this.kPC.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m(this));
      o localo = new o(new QrRewardMainUI.12(this));
      SpannableString localSpannableString = new SpannableString(getString(2131302222));
      localSpannableString.setSpan(localo, 0, localSpannableString.length(), 18);
      this.kPC.setText(localSpannableString);
      this.kPE.setClickable(true);
      this.kPE.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m(this));
      localo = new o(new QrRewardMainUI.13(this));
      localSpannableString = new SpannableString(getString(2131302232));
      localSpannableString.setSpan(localo, 0, localSpannableString.length(), 18);
      this.kPE.setText(localSpannableString);
      bhY();
      bib();
      bid();
      bic();
      AppMethodBeat.o(41104);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.QrRewardMainUI", localException, "", new Object[0]);
      }
    }
  }
  
  public boolean needExecuteBackListener()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(41107);
    if (paramInt1 == 1)
    {
      if (paramInt2 == -1)
      {
        this.desc = paramIntent.getStringExtra("key_desc");
        this.kPJ = paramIntent.getIntExtra("key_photo_width", 900);
        this.cDA = paramIntent.getIntExtra("key_icon_width", 343);
        boolean bool = paramIntent.getBooleanExtra("key_return_from_first", true);
        ab.i("MicroMsg.QrRewardMainUI", "return from first: %s", new Object[] { Boolean.valueOf(bool) });
        if (bool)
        {
          this.kPv.setVisibility(0);
          this.kPu.setVisibility(8);
        }
        this.kPL = true;
        bib();
        String str = paramIntent.getStringExtra("key_photo_url");
        n(str, paramIntent.getStringExtra("key_photo_aeskey"), true);
        this.hJS = str;
        AppMethodBeat.o(41107);
      }
    }
    else {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    AppMethodBeat.o(41107);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(41103);
    super.onCreate(paramBundle);
    paramBundle = getWindow().getAttributes();
    if (paramBundle.screenBrightness < 0.85F)
    {
      paramBundle.screenBrightness = 0.85F;
      getWindow().setAttributes(paramBundle);
    }
    addSceneEndListener(1323);
    addSceneEndListener(1649);
    this.kPJ = ((Integer)g.RL().Ru().get(ac.a.yIl, Integer.valueOf(900))).intValue();
    this.cDA = ((Integer)g.RL().Ru().get(ac.a.yIm, Integer.valueOf(343))).intValue();
    this.desc = ((String)g.RL().Ru().get(ac.a.yIo, ""));
    this.kPG = ((String)g.RL().Ru().get(ac.a.yIn, ""));
    this.kPH = ((String)g.RL().Ru().get(ac.a.yIs, ""));
    this.kPI = ((String)g.RL().Ru().get(ac.a.yIt, ""));
    this.hJS = ((String)g.RL().Ru().get(ac.a.yIu, ""));
    if (!bo.isNullOrNil((String)g.RL().Ru().get(ac.a.yIr, ""))) {
      this.kPL = true;
    }
    this.username = r.Zn();
    setMMTitle(2131302217);
    initView();
    if ((com.tencent.mm.plugin.collect.reward.b.a.bhT().bhU()) && (this.kPL)) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.QrRewardMainUI", "do get code: %s", new Object[] { Boolean.valueOf(bool) });
      paramBundle = new b(bool);
      paramBundle.z(this);
      if (!bool) {
        break;
      }
      doSceneProgress(paramBundle, false);
      AppMethodBeat.o(41103);
      return;
    }
    doSceneProgress(paramBundle, true);
    AppMethodBeat.o(41103);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(41108);
    super.onDestroy();
    removeSceneEndListener(1323);
    removeSceneEndListener(1649);
    com.tencent.mm.plugin.collect.reward.b.a locala = com.tencent.mm.plugin.collect.reward.b.a.bhT();
    ab.d("MicroMsg.QrRewardCdnDownloadHelper", "do clear callback");
    if (locala.jFd != null)
    {
      ab.i("MicroMsg.QrRewardCdnDownloadHelper", "callback size: %s", new Object[] { Integer.valueOf(locala.jFd.size()) });
      locala.jFd.clear();
    }
    AppMethodBeat.o(41108);
  }
  
  public void onKeyboardStateChanged()
  {
    AppMethodBeat.i(41106);
    super.onKeyboardStateChanged();
    ab.i("MicroMsg.QrRewardMainUI", "key board changed: %s", new Object[] { Integer.valueOf(keyboardState()) });
    if (keyboardState() == 2)
    {
      this.kPG = this.kPA.getText().toString();
      bie();
      if (bo.isNullOrNil(this.kPG)) {
        gm(true);
      }
    }
    AppMethodBeat.o(41106);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(41105);
    if ((paramm instanceof b))
    {
      paramString = (b)paramm;
      paramString.a(new QrRewardMainUI.16(this, paramString)).b(new QrRewardMainUI.15(this, paramString)).c(new QrRewardMainUI.14(this, paramString));
      AppMethodBeat.o(41105);
      return true;
    }
    if ((paramm instanceof h))
    {
      paramString = (h)paramm;
      paramString.a(new QrRewardMainUI.3(this, paramString)).b(new a.a()
      {
        public final void h(com.tencent.mm.ai.m paramAnonymousm)
        {
          AppMethodBeat.i(41084);
          ab.e("MicroMsg.QrRewardMainUI", "set word error: %s, %s", new Object[] { Integer.valueOf(paramString.kOM.cnK), paramString.kOM.kNv });
          QrRewardMainUI.a(QrRewardMainUI.this, (String)g.RL().Ru().get(ac.a.yIn, ""));
          QrRewardMainUI.a(QrRewardMainUI.this, QrRewardMainUI.o(QrRewardMainUI.this));
          QrRewardMainUI.a(QrRewardMainUI.this).setText("");
          QrRewardMainUI.m(QrRewardMainUI.this);
          if (!bo.isNullOrNil(paramString.kOM.kNv)) {
            Toast.makeText(QrRewardMainUI.this, paramString.kOM.kNv, 0).show();
          }
          AppMethodBeat.o(41084);
        }
      }).c(new QrRewardMainUI.17(this));
      this.kPA.clearFocus();
      this.kPA.setCursorVisible(false);
    }
    AppMethodBeat.o(41105);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI
 * JD-Core Version:    0.7.0.1
 */