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
import com.tencent.mm.an.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.wallet_core.ui.r;
import com.tencent.mm.plugin.wallet_core.ui.r.a;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.g;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class HoneyPayGiveCardUI
  extends HoneyPayBaseUI
{
  private long DKP = 100000L;
  private long DKQ = 0L;
  private String DLc;
  private WalletFormView DLk;
  private TextView DLl;
  private TextView DLm;
  private TextView DLn;
  private TextView DLo;
  private TextView DLp;
  private CdnImageView DLq;
  private MMEditText DLr;
  private ScrollView mMs;
  private String mTrueName;
  private String pRV;
  private int tFt;
  private ImageView tXu;
  private String uFL;
  
  private void eHR()
  {
    AppMethodBeat.i(64759);
    this.DLp.setVisibility(0);
    this.DLr.setVisibility(8);
    this.DLr.setText(this.DLc);
    this.DLr.setSelection(this.DLc.length());
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    String str = getString(a.i.honey_pay_modify_word_text);
    SpannableString localSpannableString = l.b(getContext(), this.DLc, this.DLp.getTextSize());
    localSpannableStringBuilder.append(localSpannableString);
    localSpannableStringBuilder.append(" ");
    localSpannableStringBuilder.append(str);
    localSpannableStringBuilder.setSpan(new r(1, new r.a()
    {
      public final void ed(View paramAnonymousView)
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
    this.DLp.setText(localSpannableStringBuilder);
    AppMethodBeat.o(64759);
  }
  
  private void th(boolean paramBoolean)
  {
    AppMethodBeat.i(64762);
    if ((paramBoolean) && (!this.DLm.isShown()))
    {
      String str = ah.ijb() + g.a(new StringBuilder().append(this.DKQ).toString(), "100", 2, RoundingMode.HALF_UP);
      this.DLm.setText(getString(a.i.honey_pay_min_quota_alert_text, new Object[] { str }));
      this.DLm.startAnimation(AnimationUtils.loadAnimation(this, a.a.in_from_up));
      this.DLm.setVisibility(0);
      AppMethodBeat.o(64762);
      return;
    }
    if ((!paramBoolean) && (this.DLm.isShown()))
    {
      this.DLm.startAnimation(AnimationUtils.loadAnimation(this, a.a.out_to_up));
      this.DLm.setVisibility(8);
    }
    AppMethodBeat.o(64762);
  }
  
  private void ti(boolean paramBoolean)
  {
    AppMethodBeat.i(64763);
    if ((paramBoolean) && (!this.DLm.isShown()))
    {
      String str = ah.ijb() + g.b(new StringBuilder().append(this.DKP).toString(), "100", 2, RoundingMode.HALF_UP).toString();
      this.DLm.setText(getString(a.i.honey_pay_max_quota_alert_text, new Object[] { str }));
      this.DLm.startAnimation(AnimationUtils.loadAnimation(this, a.a.in_from_up));
      this.DLm.setVisibility(0);
      AppMethodBeat.o(64763);
      return;
    }
    if ((!paramBoolean) && (this.DLm.isShown()))
    {
      this.DLm.startAnimation(AnimationUtils.loadAnimation(this, a.a.out_to_up));
      this.DLm.setVisibility(8);
    }
    AppMethodBeat.o(64763);
  }
  
  private void tj(boolean paramBoolean)
  {
    AppMethodBeat.i(64764);
    this.DLn.setEnabled(paramBoolean);
    AppMethodBeat.o(64764);
  }
  
  public int getLayoutId()
  {
    return a.g.honey_pay_give_card_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(64758);
    this.mMs = ((ScrollView)findViewById(a.f.hpgc_scroll_view));
    this.DLk = ((WalletFormView)findViewById(a.f.hpgc_max_limit_et));
    this.DLl = ((TextView)findViewById(a.f.hpgc_display_name_tv));
    this.DLm = ((TextView)findViewById(a.f.hpgc_top_alert_tv));
    this.tXu = ((ImageView)findViewById(a.f.hpgc_avatar_iv));
    this.DLn = ((TextView)findViewById(a.f.hpgc_give_btn));
    this.DLo = ((TextView)findViewById(a.f.hpgc_limit_hint_tv));
    this.DLp = ((TextView)findViewById(a.f.hpgc_wishing_tv));
    this.DLr = ((MMEditText)findViewById(a.f.hpgc_wishing_et));
    a.b.a(this.tXu, this.pRV, 0.06F, false);
    String str2 = g.id(this.pRV, 10);
    String str1 = str2;
    if (!Util.isNullOrNil(this.mTrueName)) {
      str1 = String.format("%s(%s)", new Object[] { str2, this.mTrueName });
    }
    this.DLl.setText(l.b(getContext(), str1, this.DLl.getTextSize()));
    this.DLk.azN(0);
    this.DLk.getTitleTv().setText(ah.ijb());
    this.DLk.a(new TextWatcher()
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
    this.DLk.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64749);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/honey_pay/ui/HoneyPayGiveCardUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        HoneyPayGiveCardUI.b(HoneyPayGiveCardUI.this).d(HoneyPayGiveCardUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/honey_pay/ui/HoneyPayGiveCardUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(64749);
      }
    });
    this.DLo.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64750);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/honey_pay/ui/HoneyPayGiveCardUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        HoneyPayGiveCardUI.c(HoneyPayGiveCardUI.this).setVisibility(8);
        HoneyPayGiveCardUI.b(HoneyPayGiveCardUI.this).setVisibility(0);
        HoneyPayGiveCardUI.b(HoneyPayGiveCardUI.this).d(HoneyPayGiveCardUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/honey_pay/ui/HoneyPayGiveCardUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(64750);
      }
    });
    this.DLn.setClickable(true);
    this.DLn.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64751);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/honey_pay/ui/HoneyPayGiveCardUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
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
    this.DLp.setClickable(true);
    this.DLp.setOnTouchListener(new o(this));
    this.DLr.setOnEditorActionListener(new TextView.OnEditorActionListener()
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
    this.DLr.setOnFocusChangeListener(new View.OnFocusChangeListener()
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
    eHR();
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
        HoneyPayGiveCardUI.b(HoneyPayGiveCardUI.this).fun();
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
    setEditFocusListener(this.DLk, 2, false);
    this.DLk.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(64755);
        HoneyPayGiveCardUI.b(HoneyPayGiveCardUI.this).d(HoneyPayGiveCardUI.this);
        AppMethodBeat.o(64755);
      }
    }, 100L);
    this.DLq = ((CdnImageView)findViewById(a.f.hpgc_quota_logo_2_iv));
    if (!Util.isNullOrNil(this.uFL))
    {
      this.DLq.hr(this.uFL, c.eHL());
      AppMethodBeat.o(64758);
      return;
    }
    this.DLq.setImageResource(c.eHL());
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
    this.BkW = a.c.honey_pay_grey_bg_1;
    super.onCreate(paramBundle);
    getWindow().setBackgroundDrawableResource(a.c.white);
    this.DKP = getIntent().getLongExtra("key_max_credit_line", 0L);
    this.DKQ = getIntent().getLongExtra("key_min_credit_line", 0L);
    this.mTrueName = getIntent().getStringExtra("key_true_name");
    this.pRV = getIntent().getStringExtra("key_username");
    this.DLc = getIntent().getStringExtra("key_wishing");
    this.uFL = getIntent().getStringExtra("key_icon_url");
    this.tFt = getIntent().getIntExtra("key_cardtype", 0);
    if (this.tFt == 0)
    {
      Log.w(this.TAG, "error card type!!");
      finish();
    }
    initView();
    setMMTitle(a.i.honey_pay_give_card_title);
    AppMethodBeat.o(64757);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64760);
    super.onDestroy();
    AppMethodBeat.o(64760);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
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