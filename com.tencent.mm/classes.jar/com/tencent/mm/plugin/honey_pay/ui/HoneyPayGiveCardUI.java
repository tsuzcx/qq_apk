package com.tencent.mm.plugin.honey_pay.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.ui.a;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class HoneyPayGiveCardUI
  extends HoneyPayBaseUI
{
  private String hcm;
  private ImageView iIS;
  private String iLj;
  private String iZG;
  private long lkW = 100000L;
  private long lkX = 0L;
  private MMEditText llA;
  private String llj;
  private int lll;
  private ScrollView lls;
  private WalletFormView llt;
  private TextView llu;
  private TextView llv;
  private TextView llw;
  private TextView llx;
  private TextView lly;
  private CdnImageView llz;
  
  private void baZ()
  {
    this.lly.setVisibility(0);
    this.llA.setVisibility(8);
    this.llA.setText(this.llj);
    this.llA.setSelection(this.llj.length());
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    String str = getString(a.i.honey_pay_modify_word_text);
    SpannableString localSpannableString = j.a(this.mController.uMN, this.llj, this.lly.getTextSize());
    localSpannableStringBuilder.append(localSpannableString);
    localSpannableStringBuilder.append(" ");
    localSpannableStringBuilder.append(str);
    localSpannableStringBuilder.setSpan(new com.tencent.mm.plugin.wallet_core.ui.m(new HoneyPayGiveCardUI.9(this)), localSpannableString.length() + 1, localSpannableStringBuilder.length(), 34);
    this.lly.setText(localSpannableStringBuilder);
  }
  
  private void gH(boolean paramBoolean)
  {
    if ((paramBoolean) && (!this.llv.isShown()))
    {
      str = ab.cML() + e.a(new StringBuilder().append(this.lkX).toString(), "100", RoundingMode.HALF_UP);
      this.llv.setText(getString(a.i.honey_pay_min_quota_alert_text, new Object[] { str }));
      this.llv.startAnimation(AnimationUtils.loadAnimation(this, a.a.in_from_up));
      this.llv.setVisibility(0);
    }
    while ((paramBoolean) || (!this.llv.isShown()))
    {
      String str;
      return;
    }
    this.llv.startAnimation(AnimationUtils.loadAnimation(this, a.a.out_to_up));
    this.llv.setVisibility(8);
  }
  
  private void gI(boolean paramBoolean)
  {
    if ((paramBoolean) && (!this.llv.isShown()))
    {
      str = ab.cML() + e.b(new StringBuilder().append(this.lkW).toString(), "100", RoundingMode.HALF_UP).toString();
      this.llv.setText(getString(a.i.honey_pay_max_quota_alert_text, new Object[] { str }));
      this.llv.startAnimation(AnimationUtils.loadAnimation(this, a.a.in_from_up));
      this.llv.setVisibility(0);
    }
    while ((paramBoolean) || (!this.llv.isShown()))
    {
      String str;
      return;
    }
    this.llv.startAnimation(AnimationUtils.loadAnimation(this, a.a.out_to_up));
    this.llv.setVisibility(8);
  }
  
  private void gJ(boolean paramBoolean)
  {
    this.llw.setEnabled(paramBoolean);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    return false;
  }
  
  protected final int getLayoutId()
  {
    return a.g.honey_pay_give_card_ui;
  }
  
  protected final void initView()
  {
    this.lls = ((ScrollView)findViewById(a.f.hpgc_scroll_view));
    this.llt = ((WalletFormView)findViewById(a.f.hpgc_max_limit_et));
    this.llu = ((TextView)findViewById(a.f.hpgc_display_name_tv));
    this.llv = ((TextView)findViewById(a.f.hpgc_top_alert_tv));
    this.iIS = ((ImageView)findViewById(a.f.hpgc_avatar_iv));
    this.llw = ((TextView)findViewById(a.f.hpgc_give_btn));
    this.llx = ((TextView)findViewById(a.f.hpgc_limit_hint_tv));
    this.lly = ((TextView)findViewById(a.f.hpgc_wishing_tv));
    this.llA = ((MMEditText)findViewById(a.f.hpgc_wishing_et));
    a.b.a(this.iIS, this.hcm, 0.06F, false);
    String str2 = e.dQ(this.hcm, 10);
    String str1 = str2;
    if (!bk.bl(this.iLj)) {
      str1 = String.format("%s(%s)", new Object[] { str2, this.iLj });
    }
    this.llu.setText(j.a(this.mController.uMN, str1, this.llu.getTextSize()));
    this.llt.cNu();
    this.llt.getTitleTv().setText(ab.cML());
    this.llt.a(new HoneyPayGiveCardUI.1(this));
    this.llt.setOnClickListener(new HoneyPayGiveCardUI.2(this));
    this.llx.setOnClickListener(new HoneyPayGiveCardUI.3(this));
    this.llw.setClickable(true);
    this.llw.setOnClickListener(new HoneyPayGiveCardUI.4(this));
    this.lly.setClickable(true);
    this.lly.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m(this));
    this.llA.setOnEditorActionListener(new HoneyPayGiveCardUI.5(this));
    this.llA.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (!paramAnonymousBoolean)
        {
          HoneyPayGiveCardUI.a(HoneyPayGiveCardUI.this, HoneyPayGiveCardUI.e(HoneyPayGiveCardUI.this).getText().toString());
          HoneyPayGiveCardUI.f(HoneyPayGiveCardUI.this);
        }
      }
    });
    baZ();
    this.lTH = new a()
    {
      public final void gK(boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean) {
          HoneyPayGiveCardUI.a(HoneyPayGiveCardUI.this, HoneyPayGiveCardUI.g(HoneyPayGiveCardUI.this), HoneyPayGiveCardUI.h(HoneyPayGiveCardUI.this));
        }
        do
        {
          return;
          HoneyPayGiveCardUI.g(HoneyPayGiveCardUI.this).scrollTo(0, 0);
          HoneyPayGiveCardUI.b(HoneyPayGiveCardUI.this).bvq();
        } while (!bk.bl(HoneyPayGiveCardUI.b(HoneyPayGiveCardUI.this).getText()));
        HoneyPayGiveCardUI.b(HoneyPayGiveCardUI.this).setVisibility(8);
        HoneyPayGiveCardUI.c(HoneyPayGiveCardUI.this).setVisibility(0);
        HoneyPayGiveCardUI.i(HoneyPayGiveCardUI.this);
        HoneyPayGiveCardUI.j(HoneyPayGiveCardUI.this);
      }
    };
    e(this.llt, 2, false);
    this.llt.postDelayed(new Runnable()
    {
      public final void run()
      {
        HoneyPayGiveCardUI.b(HoneyPayGiveCardUI.this).d(HoneyPayGiveCardUI.this);
      }
    }, 100L);
    this.llz = ((CdnImageView)findViewById(a.f.hpgc_quota_logo_2_iv));
    if (!bk.bl(this.iZG))
    {
      this.llz.dl(this.iZG, c.baT());
      return;
    }
    this.llz.setImageResource(c.baT());
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.lkb = a.c.honey_pay_grey_bg_1;
    super.onCreate(paramBundle);
    getWindow().setBackgroundDrawableResource(a.c.white);
    this.lkW = getIntent().getLongExtra("key_max_credit_line", 0L);
    this.lkX = getIntent().getLongExtra("key_min_credit_line", 0L);
    this.iLj = getIntent().getStringExtra("key_true_name");
    this.hcm = getIntent().getStringExtra("key_username");
    this.llj = getIntent().getStringExtra("key_wishing");
    this.iZG = getIntent().getStringExtra("key_icon_url");
    this.lll = getIntent().getIntExtra("key_cardtype", 0);
    if (this.lll == 0)
    {
      y.w(this.TAG, "error card type!!");
      finish();
    }
    initView();
    setMMTitle(a.i.honey_pay_give_card_title);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayGiveCardUI
 * JD-Core Version:    0.7.0.1
 */