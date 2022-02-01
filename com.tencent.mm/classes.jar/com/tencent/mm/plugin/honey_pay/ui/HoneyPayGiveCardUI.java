package com.tencent.mm.plugin.honey_pay.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.accessibility.type.ViewType;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.wallet_core.ui.s.a;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.dus;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.wallet_core.model.ai;
import com.tencent.mm.wallet_core.ui.WcPayBannerView;
import com.tencent.mm.wallet_core.ui.a;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.k;
import com.tencent.threadpool.h;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import kotlin.g.a.b;

public class HoneyPayGiveCardUI
  extends HoneyPayBaseUI
{
  private long JBN = 100000L;
  private long JBO = 0L;
  private String JCe;
  private WalletFormView JCm;
  private TextView JCn;
  private TextView JCo;
  private TextView JCp;
  private TextView JCq;
  private TextView JCr;
  private CdnImageView JCs;
  private MMEditText JCt;
  private WcPayBannerView JCu;
  private String mTrueName;
  private ScrollView pJa;
  private String sWX;
  private int wIT;
  private String xOn;
  private dus xaB;
  private ImageView xaN;
  
  private void fPD()
  {
    AppMethodBeat.i(64759);
    this.JCr.setVisibility(0);
    this.JCt.setVisibility(8);
    this.JCt.setText(this.JCe);
    this.JCt.setSelection(this.JCe.length());
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    String str = getString(a.i.honey_pay_modify_word_text);
    SpannableString localSpannableString = com.tencent.mm.pluginsdk.ui.span.p.b(getContext(), this.JCe, this.JCr.getTextSize());
    localSpannableStringBuilder.append(localSpannableString);
    localSpannableStringBuilder.append(" ");
    localSpannableStringBuilder.append(str);
    localSpannableStringBuilder.setSpan(new com.tencent.mm.plugin.wallet_core.ui.s(1, new s.a()
    {
      public final void eS(View paramAnonymousView)
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
    this.JCr.setText(localSpannableStringBuilder);
    AppMethodBeat.o(64759);
  }
  
  private void xs(boolean paramBoolean)
  {
    AppMethodBeat.i(64762);
    if ((paramBoolean) && (!this.JCo.isShown()))
    {
      String str = ai.jOX() + com.tencent.mm.wallet_core.ui.i.a(new StringBuilder().append(this.JBO).toString(), "100", 2, RoundingMode.HALF_UP);
      this.JCo.setText(getString(a.i.honey_pay_min_quota_alert_text, new Object[] { str }));
      this.JCo.startAnimation(AnimationUtils.loadAnimation(this, a.a.in_from_up));
      this.JCo.setVisibility(0);
      ((a)component(a.class)).fPE();
      AppMethodBeat.o(64762);
      return;
    }
    if ((!paramBoolean) && (this.JCo.isShown()))
    {
      this.JCo.startAnimation(AnimationUtils.loadAnimation(this, a.a.out_to_up));
      this.JCo.setVisibility(8);
    }
    AppMethodBeat.o(64762);
  }
  
  private void xt(boolean paramBoolean)
  {
    AppMethodBeat.i(64763);
    if ((paramBoolean) && (!this.JCo.isShown()))
    {
      String str = ai.jOX() + com.tencent.mm.wallet_core.ui.i.b(new StringBuilder().append(this.JBN).toString(), "100", 2, RoundingMode.HALF_UP).toString();
      this.JCo.setText(getString(a.i.honey_pay_max_quota_alert_text, new Object[] { str }));
      this.JCo.startAnimation(AnimationUtils.loadAnimation(this, a.a.in_from_up));
      this.JCo.setVisibility(0);
      ((a)component(a.class)).fPE();
      AppMethodBeat.o(64763);
      return;
    }
    if ((!paramBoolean) && (this.JCo.isShown()))
    {
      this.JCo.startAnimation(AnimationUtils.loadAnimation(this, a.a.out_to_up));
      this.JCo.setVisibility(8);
    }
    AppMethodBeat.o(64763);
  }
  
  private void xu(boolean paramBoolean)
  {
    AppMethodBeat.i(64764);
    this.JCp.setEnabled(paramBoolean);
    AppMethodBeat.o(64764);
  }
  
  public int getLayoutId()
  {
    return a.g.honey_pay_give_card_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(64758);
    this.pJa = ((ScrollView)findViewById(a.f.hpgc_scroll_view));
    this.JCm = ((WalletFormView)findViewById(a.f.hpgc_max_limit_et));
    this.JCn = ((TextView)findViewById(a.f.hpgc_display_name_tv));
    this.JCo = ((TextView)findViewById(a.f.hpgc_top_alert_tv));
    this.xaN = ((ImageView)findViewById(a.f.hpgc_avatar_iv));
    this.JCp = ((TextView)findViewById(a.f.hpgc_give_btn));
    this.JCq = ((TextView)findViewById(a.f.hpgc_limit_hint_tv));
    this.JCr = ((TextView)findViewById(a.f.hpgc_wishing_tv));
    this.JCt = ((MMEditText)findViewById(a.f.hpgc_wishing_et));
    this.JCu = ((WcPayBannerView)findViewById(a.f.wc_pay_banner_layout));
    a.b.a(this.xaN, this.sWX, 0.06F, false);
    String str2 = com.tencent.mm.wallet_core.ui.i.jp(this.sWX, 10);
    String str1 = str2;
    if (!Util.isNullOrNil(this.mTrueName)) {
      str1 = String.format("%s(%s)", new Object[] { str2, this.mTrueName });
    }
    this.JCn.setText(com.tencent.mm.pluginsdk.ui.span.p.b(getContext(), str1, this.JCn.getTextSize()));
    this.JCm.aGD(0);
    this.JCm.getTitleTv().setText(ai.jOX());
    this.JCm.a(new TextWatcher()
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
    this.JCm.setOnClickListener(new k()
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(267335);
        HoneyPayGiveCardUI.b(HoneyPayGiveCardUI.this).d(HoneyPayGiveCardUI.this);
        AppMethodBeat.o(267335);
      }
    });
    this.JCq.setOnClickListener(new k()
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(267336);
        HoneyPayGiveCardUI.c(HoneyPayGiveCardUI.this).setVisibility(8);
        HoneyPayGiveCardUI.b(HoneyPayGiveCardUI.this).setVisibility(0);
        HoneyPayGiveCardUI.b(HoneyPayGiveCardUI.this).d(HoneyPayGiveCardUI.this);
        AppMethodBeat.o(267336);
      }
    });
    this.JCp.setClickable(true);
    this.JCp.setOnClickListener(new k()
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(267337);
        Log.d(HoneyPayGiveCardUI.this.TAG, "click give btn");
        if (HoneyPayGiveCardUI.a(HoneyPayGiveCardUI.this))
        {
          HoneyPayGiveCardUI.this.hideTenpayKB();
          HoneyPayGiveCardUI.d(HoneyPayGiveCardUI.this);
          AppMethodBeat.o(267337);
          return;
        }
        Log.w(HoneyPayGiveCardUI.this.TAG, "over limit when click");
        AppMethodBeat.o(267337);
      }
    });
    this.JCr.setClickable(true);
    this.JCr.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.s(this));
    this.JCt.setOnEditorActionListener(new TextView.OnEditorActionListener()
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
    this.JCt.setOnFocusChangeListener(new View.OnFocusChangeListener()
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
    fPD();
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
        HoneyPayGiveCardUI.b(HoneyPayGiveCardUI.this).gGc();
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
    setEditFocusListener(this.JCm, 2, false);
    this.JCm.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(64755);
        HoneyPayGiveCardUI.b(HoneyPayGiveCardUI.this).d(HoneyPayGiveCardUI.this);
        AppMethodBeat.o(64755);
      }
    }, 100L);
    this.JCs = ((CdnImageView)findViewById(a.f.hpgc_quota_logo_2_iv));
    if (!Util.isNullOrNil(this.xOn)) {
      this.JCs.iz(this.xOn, c.fPw());
    }
    for (;;)
    {
      this.JCu.setBannerData(this.xaB);
      this.JCu.setBgColor(getResources().getColor(a.c.Orange));
      this.JCu.setTextColor(getResources().getColor(a.c.White));
      AppMethodBeat.o(64758);
      return;
      this.JCs.setImageResource(c.fPw());
    }
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
    this.GRg = a.c.honey_pay_grey_bg_1;
    super.onCreate(paramBundle);
    getWindow().setBackgroundDrawableResource(a.c.white);
    setActionbarColor(getResources().getColor(a.c.BG_2));
    this.JBN = getIntent().getLongExtra("key_max_credit_line", 0L);
    this.JBO = getIntent().getLongExtra("key_min_credit_line", 0L);
    this.mTrueName = getIntent().getStringExtra("key_true_name");
    this.sWX = getIntent().getStringExtra("key_username");
    this.JCe = getIntent().getStringExtra("key_wishing");
    this.xOn = getIntent().getStringExtra("key_icon_url");
    this.wIT = getIntent().getIntExtra("key_cardtype", 0);
    paramBundle = getIntent().getStringExtra("key_notice_item");
    if (!Util.isNullOrNil(paramBundle)) {}
    try
    {
      dus localdus = new dus();
      localdus.parseFrom(Base64.decode(paramBundle, 2));
      this.xaB = localdus;
      if (this.wIT == 0)
      {
        Log.w(this.TAG, "error card type!!");
        finish();
      }
      initView();
      setMMTitle(a.i.honey_pay_give_card_title);
      AppMethodBeat.o(64757);
      return;
    }
    catch (IOException paramBundle)
    {
      for (;;)
      {
        Log.printErrStackTrace(this.TAG, paramBundle, "", new Object[0]);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64760);
    super.onDestroy();
    AppMethodBeat.o(64760);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(267347);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(a.class);
    AppMethodBeat.o(267347);
  }
  
  public static class a
    extends MMBaseAccessibilityConfig
  {
    public a(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
    
    public final void fPE()
    {
      AppMethodBeat.i(267331);
      TextView localTextView = (TextView)findViewById(a.f.hpgc_top_alert_tv);
      localTextView.announceForAccessibility(localTextView.getText());
      AppMethodBeat.o(267331);
    }
    
    public void initConfig()
    {
      AppMethodBeat.i(267330);
      root(a.f.hpgc_scroll_view).view(a.f.hpgc_give_btn).desc(a.i.honey_pay_give_card_btn_text).type(ViewType.Button);
      root(a.f.hpgc_scroll_view).view(a.f.hpgc_top_alert_tv).talkOn(new b() {});
      root(a.f.hpgc_scroll_view).view(a.f.wallet_title).disable();
      h.ahAA.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(267351);
          TextView localTextView = (TextView)HoneyPayGiveCardUI.a.this.findViewById(a.f.hpgc_limit_title_tv);
          if (localTextView != null) {
            localTextView.sendAccessibilityEvent(8);
          }
          AppMethodBeat.o(267351);
        }
      }, 300L);
      AppMethodBeat.o(267330);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayGiveCardUI
 * JD-Core Version:    0.7.0.1
 */