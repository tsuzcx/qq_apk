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
import com.tencent.mm.plugin.wallet_core.ui.q.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class HoneyPayGiveCardUI
  extends HoneyPayBaseUI
{
  private ScrollView jVf;
  private String mRa;
  private String mTrueName;
  private int qjx;
  private ImageView qyu;
  private String rcG;
  private long ykN = 100000L;
  private long ykO = 0L;
  private String yla;
  private WalletFormView yli;
  private TextView ylj;
  private TextView ylk;
  private TextView yll;
  private TextView ylm;
  private TextView yln;
  private CdnImageView ylo;
  private MMEditText ylp;
  
  private void dYU()
  {
    AppMethodBeat.i(64759);
    this.yln.setVisibility(0);
    this.ylp.setVisibility(8);
    this.ylp.setText(this.yla);
    this.ylp.setSelection(this.yla.length());
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    String str = getString(2131761675);
    SpannableString localSpannableString = l.b(getContext(), this.yla, this.yln.getTextSize());
    localSpannableStringBuilder.append(localSpannableString);
    localSpannableStringBuilder.append(" ");
    localSpannableStringBuilder.append(str);
    localSpannableStringBuilder.setSpan(new com.tencent.mm.plugin.wallet_core.ui.q(1, new q.a()
    {
      public final void dF(View paramAnonymousView)
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
    this.yln.setText(localSpannableStringBuilder);
    AppMethodBeat.o(64759);
  }
  
  private void qf(boolean paramBoolean)
  {
    AppMethodBeat.i(64762);
    if ((paramBoolean) && (!this.ylk.isShown()))
    {
      String str = ah.hhz() + f.a(new StringBuilder().append(this.ykO).toString(), "100", 2, RoundingMode.HALF_UP);
      this.ylk.setText(getString(2131761672, new Object[] { str }));
      this.ylk.startAnimation(AnimationUtils.loadAnimation(this, 2130772081));
      this.ylk.setVisibility(0);
      AppMethodBeat.o(64762);
      return;
    }
    if ((!paramBoolean) && (this.ylk.isShown()))
    {
      this.ylk.startAnimation(AnimationUtils.loadAnimation(this, 2130772110));
      this.ylk.setVisibility(8);
    }
    AppMethodBeat.o(64762);
  }
  
  private void qg(boolean paramBoolean)
  {
    AppMethodBeat.i(64763);
    if ((paramBoolean) && (!this.ylk.isShown()))
    {
      String str = ah.hhz() + f.b(new StringBuilder().append(this.ykN).toString(), "100", 2, RoundingMode.HALF_UP).toString();
      this.ylk.setText(getString(2131761668, new Object[] { str }));
      this.ylk.startAnimation(AnimationUtils.loadAnimation(this, 2130772081));
      this.ylk.setVisibility(0);
      AppMethodBeat.o(64763);
      return;
    }
    if ((!paramBoolean) && (this.ylk.isShown()))
    {
      this.ylk.startAnimation(AnimationUtils.loadAnimation(this, 2130772110));
      this.ylk.setVisibility(8);
    }
    AppMethodBeat.o(64763);
  }
  
  private void qh(boolean paramBoolean)
  {
    AppMethodBeat.i(64764);
    this.yll.setEnabled(paramBoolean);
    AppMethodBeat.o(64764);
  }
  
  public int getLayoutId()
  {
    return 2131495025;
  }
  
  public void initView()
  {
    AppMethodBeat.i(64758);
    this.jVf = ((ScrollView)findViewById(2131302423));
    this.yli = ((WalletFormView)findViewById(2131302421));
    this.ylj = ((TextView)findViewById(2131302417));
    this.ylk = ((TextView)findViewById(2131302424));
    this.qyu = ((ImageView)findViewById(2131302415));
    this.yll = ((TextView)findViewById(2131302418));
    this.ylm = ((TextView)findViewById(2131302419));
    this.yln = ((TextView)findViewById(2131302426));
    this.ylp = ((MMEditText)findViewById(2131302425));
    a.b.a(this.qyu, this.mRa, 0.06F, false);
    String str2 = f.ht(this.mRa, 10);
    String str1 = str2;
    if (!Util.isNullOrNil(this.mTrueName)) {
      str1 = String.format("%s(%s)", new Object[] { str2, this.mTrueName });
    }
    this.ylj.setText(l.b(getContext(), str1, this.ylj.getTextSize()));
    this.yli.setContentPadding$3b4dfe4b(0);
    this.yli.getTitleTv().setText(ah.hhz());
    this.yli.a(new TextWatcher()
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
    this.yli.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64749);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/honey_pay/ui/HoneyPayGiveCardUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        HoneyPayGiveCardUI.b(HoneyPayGiveCardUI.this).d(HoneyPayGiveCardUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/honey_pay/ui/HoneyPayGiveCardUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(64749);
      }
    });
    this.ylm.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64750);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/honey_pay/ui/HoneyPayGiveCardUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        HoneyPayGiveCardUI.c(HoneyPayGiveCardUI.this).setVisibility(8);
        HoneyPayGiveCardUI.b(HoneyPayGiveCardUI.this).setVisibility(0);
        HoneyPayGiveCardUI.b(HoneyPayGiveCardUI.this).d(HoneyPayGiveCardUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/honey_pay/ui/HoneyPayGiveCardUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(64750);
      }
    });
    this.yll.setClickable(true);
    this.yll.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64751);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/honey_pay/ui/HoneyPayGiveCardUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        Log.d(HoneyPayGiveCardUI.this.TAG, "click give btn");
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
          Log.w(HoneyPayGiveCardUI.this.TAG, "over limit when click");
        }
      }
    });
    this.yln.setClickable(true);
    this.yln.setOnTouchListener(new o(this));
    this.ylp.setOnEditorActionListener(new TextView.OnEditorActionListener()
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
    this.ylp.setOnFocusChangeListener(new View.OnFocusChangeListener()
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
    dYU();
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
        HoneyPayGiveCardUI.b(HoneyPayGiveCardUI.this).eIi();
        if (Util.isNullOrNil(HoneyPayGiveCardUI.b(HoneyPayGiveCardUI.this).getText()))
        {
          HoneyPayGiveCardUI.b(HoneyPayGiveCardUI.this).setVisibility(8);
          HoneyPayGiveCardUI.c(HoneyPayGiveCardUI.this).setVisibility(0);
          HoneyPayGiveCardUI.i(HoneyPayGiveCardUI.this);
          HoneyPayGiveCardUI.j(HoneyPayGiveCardUI.this);
        }
        AppMethodBeat.o(64754);
      }
    });
    setEditFocusListener(this.yli, 2, false);
    this.yli.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(64755);
        HoneyPayGiveCardUI.b(HoneyPayGiveCardUI.this).d(HoneyPayGiveCardUI.this);
        AppMethodBeat.o(64755);
      }
    }, 100L);
    this.ylo = ((CdnImageView)findViewById(2131302422));
    if (!Util.isNullOrNil(this.rcG))
    {
      this.ylo.gI(this.rcG, c.dYO());
      AppMethodBeat.o(64758);
      return;
    }
    this.ylo.setImageResource(c.dYO());
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
    this.wwG = 2131100596;
    super.onCreate(paramBundle);
    getWindow().setBackgroundDrawableResource(2131101424);
    this.ykN = getIntent().getLongExtra("key_max_credit_line", 0L);
    this.ykO = getIntent().getLongExtra("key_min_credit_line", 0L);
    this.mTrueName = getIntent().getStringExtra("key_true_name");
    this.mRa = getIntent().getStringExtra("key_username");
    this.yla = getIntent().getStringExtra("key_wishing");
    this.rcG = getIntent().getStringExtra("key_icon_url");
    this.qjx = getIntent().getIntExtra("key_cardtype", 0);
    if (this.qjx == 0)
    {
      Log.w(this.TAG, "error card type!!");
      finish();
    }
    initView();
    setMMTitle(2131761656);
    AppMethodBeat.o(64757);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64760);
    super.onDestroy();
    AppMethodBeat.o(64760);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
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