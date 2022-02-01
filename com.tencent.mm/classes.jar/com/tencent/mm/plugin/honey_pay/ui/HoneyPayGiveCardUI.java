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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
  private String lhM;
  private String mTrueName;
  private ImageView ozi;
  private String pbZ;
  private long tDO = 100000L;
  private long tDP = 0L;
  private String tEb;
  private int tEd;
  private ScrollView tEk;
  private WalletFormView tEl;
  private TextView tEm;
  private TextView tEn;
  private TextView tEo;
  private TextView tEp;
  private TextView tEq;
  private CdnImageView tEr;
  private MMEditText tEs;
  
  private void cTb()
  {
    AppMethodBeat.i(64759);
    this.tEq.setVisibility(0);
    this.tEs.setVisibility(8);
    this.tEs.setText(this.tEb);
    this.tEs.setSelection(this.tEb.length());
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    String str = getString(2131760289);
    SpannableString localSpannableString = k.b(getContext(), this.tEb, this.tEq.getTextSize());
    localSpannableStringBuilder.append(localSpannableString);
    localSpannableStringBuilder.append(" ");
    localSpannableStringBuilder.append(str);
    localSpannableStringBuilder.setSpan(new q(1, new q.a()
    {
      public final void dK(View paramAnonymousView)
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
    this.tEq.setText(localSpannableStringBuilder);
    AppMethodBeat.o(64759);
  }
  
  private void mY(boolean paramBoolean)
  {
    AppMethodBeat.i(64762);
    if ((paramBoolean) && (!this.tEn.isShown()))
    {
      String str = ah.fAw() + e.b(new StringBuilder().append(this.tDP).toString(), "100", RoundingMode.HALF_UP);
      this.tEn.setText(getString(2131760286, new Object[] { str }));
      this.tEn.startAnimation(AnimationUtils.loadAnimation(this, 2130772068));
      this.tEn.setVisibility(0);
      AppMethodBeat.o(64762);
      return;
    }
    if ((!paramBoolean) && (this.tEn.isShown()))
    {
      this.tEn.startAnimation(AnimationUtils.loadAnimation(this, 2130772088));
      this.tEn.setVisibility(8);
    }
    AppMethodBeat.o(64762);
  }
  
  private void mZ(boolean paramBoolean)
  {
    AppMethodBeat.i(64763);
    if ((paramBoolean) && (!this.tEn.isShown()))
    {
      String str = ah.fAw() + e.a(new StringBuilder().append(this.tDO).toString(), "100", 2, RoundingMode.HALF_UP).toString();
      this.tEn.setText(getString(2131760282, new Object[] { str }));
      this.tEn.startAnimation(AnimationUtils.loadAnimation(this, 2130772068));
      this.tEn.setVisibility(0);
      AppMethodBeat.o(64763);
      return;
    }
    if ((!paramBoolean) && (this.tEn.isShown()))
    {
      this.tEn.startAnimation(AnimationUtils.loadAnimation(this, 2130772088));
      this.tEn.setVisibility(8);
    }
    AppMethodBeat.o(64763);
  }
  
  private void na(boolean paramBoolean)
  {
    AppMethodBeat.i(64764);
    this.tEo.setEnabled(paramBoolean);
    AppMethodBeat.o(64764);
  }
  
  public int getLayoutId()
  {
    return 2131494447;
  }
  
  public void initView()
  {
    AppMethodBeat.i(64758);
    this.tEk = ((ScrollView)findViewById(2131300829));
    this.tEl = ((WalletFormView)findViewById(2131300827));
    this.tEm = ((TextView)findViewById(2131300823));
    this.tEn = ((TextView)findViewById(2131300830));
    this.ozi = ((ImageView)findViewById(2131300821));
    this.tEo = ((TextView)findViewById(2131300824));
    this.tEp = ((TextView)findViewById(2131300825));
    this.tEq = ((TextView)findViewById(2131300832));
    this.tEs = ((MMEditText)findViewById(2131300831));
    a.b.a(this.ozi, this.lhM, 0.06F, false);
    String str2 = e.gs(this.lhM, 10);
    String str1 = str2;
    if (!bs.isNullOrNil(this.mTrueName)) {
      str1 = String.format("%s(%s)", new Object[] { str2, this.mTrueName });
    }
    this.tEm.setText(k.b(getContext(), str1, this.tEm.getTextSize()));
    this.tEl.setContentPadding$3b4dfe4b(0);
    this.tEl.getTitleTv().setText(ah.fAw());
    this.tEl.a(new TextWatcher()
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
    this.tEl.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64749);
        HoneyPayGiveCardUI.b(HoneyPayGiveCardUI.this).d(HoneyPayGiveCardUI.this);
        AppMethodBeat.o(64749);
      }
    });
    this.tEp.setOnClickListener(new View.OnClickListener()
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
    this.tEo.setClickable(true);
    this.tEo.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64751);
        ac.d(HoneyPayGiveCardUI.this.TAG, "click give btn");
        if (HoneyPayGiveCardUI.a(HoneyPayGiveCardUI.this))
        {
          HoneyPayGiveCardUI.this.hideTenpayKB();
          HoneyPayGiveCardUI.d(HoneyPayGiveCardUI.this);
          AppMethodBeat.o(64751);
          return;
        }
        ac.w(HoneyPayGiveCardUI.this.TAG, "over limit when click");
        AppMethodBeat.o(64751);
      }
    });
    this.tEq.setClickable(true);
    this.tEq.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(this));
    this.tEs.setOnEditorActionListener(new TextView.OnEditorActionListener()
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
    this.tEs.setOnFocusChangeListener(new View.OnFocusChangeListener()
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
    cTb();
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
        HoneyPayGiveCardUI.b(HoneyPayGiveCardUI.this).dtG();
        if (bs.isNullOrNil(HoneyPayGiveCardUI.b(HoneyPayGiveCardUI.this).getText()))
        {
          HoneyPayGiveCardUI.b(HoneyPayGiveCardUI.this).setVisibility(8);
          HoneyPayGiveCardUI.c(HoneyPayGiveCardUI.this).setVisibility(0);
          HoneyPayGiveCardUI.i(HoneyPayGiveCardUI.this);
          HoneyPayGiveCardUI.j(HoneyPayGiveCardUI.this);
        }
        AppMethodBeat.o(64754);
      }
    });
    setEditFocusListener(this.tEl, 2, false);
    this.tEl.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(64755);
        HoneyPayGiveCardUI.b(HoneyPayGiveCardUI.this).d(HoneyPayGiveCardUI.this);
        AppMethodBeat.o(64755);
      }
    }, 100L);
    this.tEr = ((CdnImageView)findViewById(2131300828));
    if (!bs.isNullOrNil(this.pbZ))
    {
      this.tEr.fE(this.pbZ, c.cSV());
      AppMethodBeat.o(64758);
      return;
    }
    this.tEr.setImageResource(c.cSV());
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
    this.tCS = 2131100492;
    super.onCreate(paramBundle);
    getWindow().setBackgroundDrawableResource(2131101179);
    this.tDO = getIntent().getLongExtra("key_max_credit_line", 0L);
    this.tDP = getIntent().getLongExtra("key_min_credit_line", 0L);
    this.mTrueName = getIntent().getStringExtra("key_true_name");
    this.lhM = getIntent().getStringExtra("key_username");
    this.tEb = getIntent().getStringExtra("key_wishing");
    this.pbZ = getIntent().getStringExtra("key_icon_url");
    this.tEd = getIntent().getIntExtra("key_cardtype", 0);
    if (this.tEd == 0)
    {
      ac.w(this.TAG, "error card type!!");
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
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