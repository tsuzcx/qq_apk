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
import com.tencent.mm.hellhoundlib.b.b;
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
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class HoneyPayGiveCardUI
  extends HoneyPayBaseUI
{
  private String lEN;
  private String mTrueName;
  private String pFJ;
  private ImageView pcD;
  private String uGK;
  private int uGM;
  private ScrollView uGT;
  private WalletFormView uGU;
  private TextView uGV;
  private TextView uGW;
  private TextView uGX;
  private TextView uGY;
  private TextView uGZ;
  private long uGx = 100000L;
  private long uGy = 0L;
  private CdnImageView uHa;
  private MMEditText uHb;
  
  private void dci()
  {
    AppMethodBeat.i(64759);
    this.uGZ.setVisibility(0);
    this.uHb.setVisibility(8);
    this.uHb.setText(this.uGK);
    this.uHb.setSelection(this.uGK.length());
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    String str = getString(2131760289);
    SpannableString localSpannableString = k.b(getContext(), this.uGK, this.uGZ.getTextSize());
    localSpannableStringBuilder.append(localSpannableString);
    localSpannableStringBuilder.append(" ");
    localSpannableStringBuilder.append(str);
    localSpannableStringBuilder.setSpan(new q(1, new q.a()
    {
      public final void dN(View paramAnonymousView)
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
    this.uGZ.setText(localSpannableStringBuilder);
    AppMethodBeat.o(64759);
  }
  
  private void ns(boolean paramBoolean)
  {
    AppMethodBeat.i(64762);
    if ((paramBoolean) && (!this.uGW.isShown()))
    {
      String str = ah.fRG() + e.a(new StringBuilder().append(this.uGy).toString(), "100", 2, RoundingMode.HALF_UP);
      this.uGW.setText(getString(2131760286, new Object[] { str }));
      this.uGW.startAnimation(AnimationUtils.loadAnimation(this, 2130772068));
      this.uGW.setVisibility(0);
      AppMethodBeat.o(64762);
      return;
    }
    if ((!paramBoolean) && (this.uGW.isShown()))
    {
      this.uGW.startAnimation(AnimationUtils.loadAnimation(this, 2130772088));
      this.uGW.setVisibility(8);
    }
    AppMethodBeat.o(64762);
  }
  
  private void nt(boolean paramBoolean)
  {
    AppMethodBeat.i(64763);
    if ((paramBoolean) && (!this.uGW.isShown()))
    {
      String str = ah.fRG() + e.b(new StringBuilder().append(this.uGx).toString(), "100", 2, RoundingMode.HALF_UP).toString();
      this.uGW.setText(getString(2131760282, new Object[] { str }));
      this.uGW.startAnimation(AnimationUtils.loadAnimation(this, 2130772068));
      this.uGW.setVisibility(0);
      AppMethodBeat.o(64763);
      return;
    }
    if ((!paramBoolean) && (this.uGW.isShown()))
    {
      this.uGW.startAnimation(AnimationUtils.loadAnimation(this, 2130772088));
      this.uGW.setVisibility(8);
    }
    AppMethodBeat.o(64763);
  }
  
  private void nu(boolean paramBoolean)
  {
    AppMethodBeat.i(64764);
    this.uGX.setEnabled(paramBoolean);
    AppMethodBeat.o(64764);
  }
  
  public int getLayoutId()
  {
    return 2131494447;
  }
  
  public void initView()
  {
    AppMethodBeat.i(64758);
    this.uGT = ((ScrollView)findViewById(2131300829));
    this.uGU = ((WalletFormView)findViewById(2131300827));
    this.uGV = ((TextView)findViewById(2131300823));
    this.uGW = ((TextView)findViewById(2131300830));
    this.pcD = ((ImageView)findViewById(2131300821));
    this.uGX = ((TextView)findViewById(2131300824));
    this.uGY = ((TextView)findViewById(2131300825));
    this.uGZ = ((TextView)findViewById(2131300832));
    this.uHb = ((MMEditText)findViewById(2131300831));
    a.b.a(this.pcD, this.lEN, 0.06F, false);
    String str2 = e.gP(this.lEN, 10);
    String str1 = str2;
    if (!bt.isNullOrNil(this.mTrueName)) {
      str1 = String.format("%s(%s)", new Object[] { str2, this.mTrueName });
    }
    this.uGV.setText(k.b(getContext(), str1, this.uGV.getTextSize()));
    this.uGU.setContentPadding$3b4dfe4b(0);
    this.uGU.getTitleTv().setText(ah.fRG());
    this.uGU.a(new TextWatcher()
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
    this.uGU.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64749);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/honey_pay/ui/HoneyPayGiveCardUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        HoneyPayGiveCardUI.b(HoneyPayGiveCardUI.this).d(HoneyPayGiveCardUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/honey_pay/ui/HoneyPayGiveCardUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(64749);
      }
    });
    this.uGY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64750);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/honey_pay/ui/HoneyPayGiveCardUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        HoneyPayGiveCardUI.c(HoneyPayGiveCardUI.this).setVisibility(8);
        HoneyPayGiveCardUI.b(HoneyPayGiveCardUI.this).setVisibility(0);
        HoneyPayGiveCardUI.b(HoneyPayGiveCardUI.this).d(HoneyPayGiveCardUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/honey_pay/ui/HoneyPayGiveCardUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(64750);
      }
    });
    this.uGX.setClickable(true);
    this.uGX.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64751);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/honey_pay/ui/HoneyPayGiveCardUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ad.d(HoneyPayGiveCardUI.this.TAG, "click give btn");
        if (HoneyPayGiveCardUI.a(HoneyPayGiveCardUI.this))
        {
          HoneyPayGiveCardUI.this.hideTenpayKB();
          HoneyPayGiveCardUI.d(HoneyPayGiveCardUI.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/honey_pay/ui/HoneyPayGiveCardUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(64751);
          return;
          ad.w(HoneyPayGiveCardUI.this.TAG, "over limit when click");
        }
      }
    });
    this.uGZ.setClickable(true);
    this.uGZ.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(this));
    this.uHb.setOnEditorActionListener(new TextView.OnEditorActionListener()
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
    this.uHb.setOnFocusChangeListener(new View.OnFocusChangeListener()
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
    dci();
    setTenpayKBStateListener(new com.tencent.mm.wallet_core.ui.a()
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
        HoneyPayGiveCardUI.b(HoneyPayGiveCardUI.this).dEd();
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
    setEditFocusListener(this.uGU, 2, false);
    this.uGU.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(64755);
        HoneyPayGiveCardUI.b(HoneyPayGiveCardUI.this).d(HoneyPayGiveCardUI.this);
        AppMethodBeat.o(64755);
      }
    }, 100L);
    this.uHa = ((CdnImageView)findViewById(2131300828));
    if (!bt.isNullOrNil(this.pFJ))
    {
      this.uHa.gb(this.pFJ, c.dcc());
      AppMethodBeat.o(64758);
      return;
    }
    this.uHa.setImageResource(c.dcc());
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
    this.uFB = 2131100492;
    super.onCreate(paramBundle);
    getWindow().setBackgroundDrawableResource(2131101179);
    this.uGx = getIntent().getLongExtra("key_max_credit_line", 0L);
    this.uGy = getIntent().getLongExtra("key_min_credit_line", 0L);
    this.mTrueName = getIntent().getStringExtra("key_true_name");
    this.lEN = getIntent().getStringExtra("key_username");
    this.uGK = getIntent().getStringExtra("key_wishing");
    this.pFJ = getIntent().getStringExtra("key_icon_url");
    this.uGM = getIntent().getIntExtra("key_cardtype", 0);
    if (this.uGM == 0)
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