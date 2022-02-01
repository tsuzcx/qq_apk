package com.tencent.mm.plugin.honey_pay.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.plugin.wallet_core.ui.q.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.a;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class HoneyPayGiveCardUI
  extends HoneyPayBaseUI
{
  private String kGt;
  private String mTrueName;
  private ImageView nVN;
  private String oyz;
  private long svZ = 100000L;
  private TextView swA;
  private TextView swB;
  private CdnImageView swC;
  private MMEditText swD;
  private long swa = 0L;
  private String swm;
  private int swo;
  private ScrollView swv;
  private WalletFormView sww;
  private TextView swx;
  private TextView swy;
  private TextView swz;
  
  private void cFR()
  {
    AppMethodBeat.i(64759);
    this.swB.setVisibility(0);
    this.swD.setVisibility(8);
    this.swD.setText(this.swm);
    this.swD.setSelection(this.swm.length());
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    String str = getString(2131760289);
    SpannableString localSpannableString = k.b(getContext(), this.swm, this.swB.getTextSize());
    localSpannableStringBuilder.append(localSpannableString);
    localSpannableStringBuilder.append(" ");
    localSpannableStringBuilder.append(str);
    localSpannableStringBuilder.setSpan(new q(1, new q.a()
    {
      public final void dI(View paramAnonymousView)
      {
        AppMethodBeat.i(64756);
        HoneyPayGiveCardUI.this.hideTenpayKB();
        HoneyPayGiveCardUI.k(HoneyPayGiveCardUI.this).setVisibility(8);
        HoneyPayGiveCardUI.e(HoneyPayGiveCardUI.this).setVisibility(0);
        HoneyPayGiveCardUI.e(HoneyPayGiveCardUI.this).requestFocus();
        HoneyPayGiveCardUI.this.showVKB();
        AppMethodBeat.o(64756);
      }
    }), localSpannableString.length() + 1, localSpannableStringBuilder.length(), 34);
    this.swB.setText(localSpannableStringBuilder);
    AppMethodBeat.o(64759);
  }
  
  private void mf(boolean paramBoolean)
  {
    AppMethodBeat.i(64762);
    if ((paramBoolean) && (!this.swy.isShown()))
    {
      String str = ah.fkg() + e.b(new StringBuilder().append(this.swa).toString(), "100", RoundingMode.HALF_UP);
      this.swy.setText(getString(2131760286, new Object[] { str }));
      this.swy.startAnimation(AnimationUtils.loadAnimation(this, 2130772068));
      this.swy.setVisibility(0);
      AppMethodBeat.o(64762);
      return;
    }
    if ((!paramBoolean) && (this.swy.isShown()))
    {
      this.swy.startAnimation(AnimationUtils.loadAnimation(this, 2130772088));
      this.swy.setVisibility(8);
    }
    AppMethodBeat.o(64762);
  }
  
  private void mg(boolean paramBoolean)
  {
    AppMethodBeat.i(64763);
    if ((paramBoolean) && (!this.swy.isShown()))
    {
      String str = ah.fkg() + e.a(new StringBuilder().append(this.svZ).toString(), "100", 2, RoundingMode.HALF_UP).toString();
      this.swy.setText(getString(2131760282, new Object[] { str }));
      this.swy.startAnimation(AnimationUtils.loadAnimation(this, 2130772068));
      this.swy.setVisibility(0);
      AppMethodBeat.o(64763);
      return;
    }
    if ((!paramBoolean) && (this.swy.isShown()))
    {
      this.swy.startAnimation(AnimationUtils.loadAnimation(this, 2130772088));
      this.swy.setVisibility(8);
    }
    AppMethodBeat.o(64763);
  }
  
  private void mh(boolean paramBoolean)
  {
    AppMethodBeat.i(64764);
    this.swz.setEnabled(paramBoolean);
    AppMethodBeat.o(64764);
  }
  
  public int getLayoutId()
  {
    return 2131494447;
  }
  
  public void initView()
  {
    AppMethodBeat.i(64758);
    this.swv = ((ScrollView)findViewById(2131300829));
    this.sww = ((WalletFormView)findViewById(2131300827));
    this.swx = ((TextView)findViewById(2131300823));
    this.swy = ((TextView)findViewById(2131300830));
    this.nVN = ((ImageView)findViewById(2131300821));
    this.swz = ((TextView)findViewById(2131300824));
    this.swA = ((TextView)findViewById(2131300825));
    this.swB = ((TextView)findViewById(2131300832));
    this.swD = ((MMEditText)findViewById(2131300831));
    a.b.a(this.nVN, this.kGt, 0.06F, false);
    String str2 = e.go(this.kGt, 10);
    String str1 = str2;
    if (!bt.isNullOrNil(this.mTrueName)) {
      str1 = String.format("%s(%s)", new Object[] { str2, this.mTrueName });
    }
    this.swx.setText(k.b(getContext(), str1, this.swx.getTextSize()));
    this.sww.setContentPadding$3b4dfe4b(0);
    this.sww.getTitleTv().setText(ah.fkg());
    this.sww.a(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(64748);
        if (paramAnonymousEditable.toString().startsWith(".")) {
          paramAnonymousEditable.insert(0, "0");
        }
        String str = paramAnonymousEditable.toString();
        int i = str.indexOf(".");
        int j = str.length();
        if ((i >= 0) && (j - i > 2)) {
          paramAnonymousEditable.delete(i + 3, j);
        }
        HoneyPayGiveCardUI.a(HoneyPayGiveCardUI.this);
        AppMethodBeat.o(64748);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.sww.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64749);
        HoneyPayGiveCardUI.b(HoneyPayGiveCardUI.this).d(HoneyPayGiveCardUI.this);
        AppMethodBeat.o(64749);
      }
    });
    this.swA.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64750);
        HoneyPayGiveCardUI.c(HoneyPayGiveCardUI.this).setVisibility(8);
        HoneyPayGiveCardUI.b(HoneyPayGiveCardUI.this).setVisibility(0);
        HoneyPayGiveCardUI.b(HoneyPayGiveCardUI.this).d(HoneyPayGiveCardUI.this);
        AppMethodBeat.o(64750);
      }
    });
    this.swz.setClickable(true);
    this.swz.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64751);
        ad.d(HoneyPayGiveCardUI.this.TAG, "click give btn");
        if (HoneyPayGiveCardUI.a(HoneyPayGiveCardUI.this))
        {
          HoneyPayGiveCardUI.this.hideTenpayKB();
          HoneyPayGiveCardUI.d(HoneyPayGiveCardUI.this);
          AppMethodBeat.o(64751);
          return;
        }
        ad.w(HoneyPayGiveCardUI.this.TAG, "over limit when click");
        AppMethodBeat.o(64751);
      }
    });
    this.swB.setClickable(true);
    this.swB.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(this));
    this.swD.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(64752);
        if ((paramAnonymousInt == 6) || (paramAnonymousInt == 5))
        {
          HoneyPayGiveCardUI.a(HoneyPayGiveCardUI.this, HoneyPayGiveCardUI.e(HoneyPayGiveCardUI.this).getText().toString());
          HoneyPayGiveCardUI.this.hideVKB();
          HoneyPayGiveCardUI.f(HoneyPayGiveCardUI.this);
        }
        AppMethodBeat.o(64752);
        return false;
      }
    });
    this.swD.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(64753);
        if (!paramAnonymousBoolean)
        {
          HoneyPayGiveCardUI.a(HoneyPayGiveCardUI.this, HoneyPayGiveCardUI.e(HoneyPayGiveCardUI.this).getText().toString());
          HoneyPayGiveCardUI.f(HoneyPayGiveCardUI.this);
        }
        AppMethodBeat.o(64753);
      }
    });
    cFR();
    setTenpayKBStateListener(new a()
    {
      public final void onVisibleStateChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(64754);
        if (paramAnonymousBoolean)
        {
          HoneyPayGiveCardUI.a(HoneyPayGiveCardUI.this, HoneyPayGiveCardUI.g(HoneyPayGiveCardUI.this), HoneyPayGiveCardUI.h(HoneyPayGiveCardUI.this));
          AppMethodBeat.o(64754);
          return;
        }
        HoneyPayGiveCardUI.g(HoneyPayGiveCardUI.this).scrollTo(0, 0);
        HoneyPayGiveCardUI.b(HoneyPayGiveCardUI.this).dfZ();
        if (bt.isNullOrNil(HoneyPayGiveCardUI.b(HoneyPayGiveCardUI.this).getText()))
        {
          HoneyPayGiveCardUI.b(HoneyPayGiveCardUI.this).setVisibility(8);
          HoneyPayGiveCardUI.c(HoneyPayGiveCardUI.this).setVisibility(0);
          HoneyPayGiveCardUI.i(HoneyPayGiveCardUI.this);
          HoneyPayGiveCardUI.j(HoneyPayGiveCardUI.this);
        }
        AppMethodBeat.o(64754);
      }
    });
    setEditFocusListener(this.sww, 2, false);
    this.sww.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(64755);
        HoneyPayGiveCardUI.b(HoneyPayGiveCardUI.this).d(HoneyPayGiveCardUI.this);
        AppMethodBeat.o(64755);
      }
    }, 100L);
    this.swC = ((CdnImageView)findViewById(2131300828));
    if (!bt.isNullOrNil(this.oyz))
    {
      this.swC.fz(this.oyz, c.cFL());
      AppMethodBeat.o(64758);
      return;
    }
    this.swC.setImageResource(c.cFL());
    AppMethodBeat.o(64758);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(64761);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(64761);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64757);
    this.svd = 2131100492;
    super.onCreate(paramBundle);
    getWindow().setBackgroundDrawableResource(2131101179);
    this.svZ = getIntent().getLongExtra("key_max_credit_line", 0L);
    this.swa = getIntent().getLongExtra("key_min_credit_line", 0L);
    this.mTrueName = getIntent().getStringExtra("key_true_name");
    this.kGt = getIntent().getStringExtra("key_username");
    this.swm = getIntent().getStringExtra("key_wishing");
    this.oyz = getIntent().getStringExtra("key_icon_url");
    this.swo = getIntent().getIntExtra("key_cardtype", 0);
    if (this.swo == 0)
    {
      ad.w(this.TAG, "error card type!!");
      finish();
    }
    initView();
    setMMTitle(2131760270);
    AppMethodBeat.o(64757);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64760);
    super.onDestroy();
    AppMethodBeat.o(64760);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayGiveCardUI
 * JD-Core Version:    0.7.0.1
 */