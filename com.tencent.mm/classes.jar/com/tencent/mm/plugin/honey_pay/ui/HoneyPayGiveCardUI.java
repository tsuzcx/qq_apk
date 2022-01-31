package com.tencent.mm.plugin.honey_pay.ui;

import android.app.Activity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.wallet_core.ui.o;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.wallet_core.c.ae;
import com.tencent.mm.wallet_core.ui.a;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class HoneyPayGiveCardUI
  extends HoneyPayBaseUI
{
  private String ikj;
  private ImageView kPy;
  private String lix;
  private String mTrueName;
  private String nIF;
  private int nIH;
  private ScrollView nIO;
  private WalletFormView nIP;
  private TextView nIQ;
  private TextView nIR;
  private TextView nIS;
  private TextView nIT;
  private TextView nIU;
  private CdnImageView nIV;
  private MMEditText nIW;
  private long nIs = 100000L;
  private long nIt = 0L;
  
  private void bIa()
  {
    AppMethodBeat.i(41870);
    this.nIU.setVisibility(0);
    this.nIW.setVisibility(8);
    this.nIW.setText(this.nIF);
    this.nIW.setSelection(this.nIF.length());
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    String str = getString(2131300692);
    SpannableString localSpannableString = j.b(getContext(), this.nIF, this.nIU.getTextSize());
    localSpannableStringBuilder.append(localSpannableString);
    localSpannableStringBuilder.append(" ");
    localSpannableStringBuilder.append(str);
    localSpannableStringBuilder.setSpan(new o(new HoneyPayGiveCardUI.9(this)), localSpannableString.length() + 1, localSpannableStringBuilder.length(), 34);
    this.nIU.setText(localSpannableStringBuilder);
    AppMethodBeat.o(41870);
  }
  
  private void iq(boolean paramBoolean)
  {
    AppMethodBeat.i(41873);
    if ((paramBoolean) && (!this.nIR.isShown()))
    {
      String str = ae.dSz() + e.b(new StringBuilder().append(this.nIt).toString(), "100", RoundingMode.HALF_UP);
      this.nIR.setText(getString(2131300689, new Object[] { str }));
      this.nIR.startAnimation(AnimationUtils.loadAnimation(this, 2131034194));
      this.nIR.setVisibility(0);
      AppMethodBeat.o(41873);
      return;
    }
    if ((!paramBoolean) && (this.nIR.isShown()))
    {
      this.nIR.startAnimation(AnimationUtils.loadAnimation(this, 2131034214));
      this.nIR.setVisibility(8);
    }
    AppMethodBeat.o(41873);
  }
  
  private void ir(boolean paramBoolean)
  {
    AppMethodBeat.i(41874);
    if ((paramBoolean) && (!this.nIR.isShown()))
    {
      String str = ae.dSz() + e.a(new StringBuilder().append(this.nIs).toString(), "100", 2, RoundingMode.HALF_UP).toString();
      this.nIR.setText(getString(2131300685, new Object[] { str }));
      this.nIR.startAnimation(AnimationUtils.loadAnimation(this, 2131034194));
      this.nIR.setVisibility(0);
      AppMethodBeat.o(41874);
      return;
    }
    if ((!paramBoolean) && (this.nIR.isShown()))
    {
      this.nIR.startAnimation(AnimationUtils.loadAnimation(this, 2131034214));
      this.nIR.setVisibility(8);
    }
    AppMethodBeat.o(41874);
  }
  
  private void is(boolean paramBoolean)
  {
    AppMethodBeat.i(41875);
    this.nIS.setEnabled(paramBoolean);
    AppMethodBeat.o(41875);
  }
  
  public int getLayoutId()
  {
    return 2130969870;
  }
  
  public void initView()
  {
    AppMethodBeat.i(41869);
    this.nIO = ((ScrollView)findViewById(2131825035));
    this.nIP = ((WalletFormView)findViewById(2131825043));
    this.nIQ = ((TextView)findViewById(2131825038));
    this.nIR = ((TextView)findViewById(2131825046));
    this.kPy = ((ImageView)findViewById(2131825037));
    this.nIS = ((TextView)findViewById(2131825045));
    this.nIT = ((TextView)findViewById(2131825044));
    this.nIU = ((TextView)findViewById(2131825039));
    this.nIW = ((MMEditText)findViewById(2131825040));
    a.b.a(this.kPy, this.ikj, 0.06F, false);
    String str2 = e.fa(this.ikj, 10);
    String str1 = str2;
    if (!bo.isNullOrNil(this.mTrueName)) {
      str1 = String.format("%s(%s)", new Object[] { str2, this.mTrueName });
    }
    this.nIQ.setText(j.b(getContext(), str1, this.nIQ.getTextSize()));
    this.nIP.dSY();
    this.nIP.getTitleTv().setText(ae.dSz());
    this.nIP.a(new HoneyPayGiveCardUI.1(this));
    this.nIP.setOnClickListener(new HoneyPayGiveCardUI.2(this));
    this.nIT.setOnClickListener(new HoneyPayGiveCardUI.3(this));
    this.nIS.setClickable(true);
    this.nIS.setOnClickListener(new HoneyPayGiveCardUI.4(this));
    this.nIU.setClickable(true);
    this.nIU.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m(this));
    this.nIW.setOnEditorActionListener(new HoneyPayGiveCardUI.5(this));
    this.nIW.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(41864);
        if (!paramAnonymousBoolean)
        {
          HoneyPayGiveCardUI.a(HoneyPayGiveCardUI.this, HoneyPayGiveCardUI.e(HoneyPayGiveCardUI.this).getText().toString());
          HoneyPayGiveCardUI.f(HoneyPayGiveCardUI.this);
        }
        AppMethodBeat.o(41864);
      }
    });
    bIa();
    setTenpayKBStateListener(new a()
    {
      public final void onVisibleStateChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(41865);
        if (paramAnonymousBoolean)
        {
          HoneyPayGiveCardUI.a(HoneyPayGiveCardUI.this, HoneyPayGiveCardUI.g(HoneyPayGiveCardUI.this), HoneyPayGiveCardUI.h(HoneyPayGiveCardUI.this));
          AppMethodBeat.o(41865);
          return;
        }
        HoneyPayGiveCardUI.g(HoneyPayGiveCardUI.this).scrollTo(0, 0);
        HoneyPayGiveCardUI.b(HoneyPayGiveCardUI.this).cfJ();
        if (bo.isNullOrNil(HoneyPayGiveCardUI.b(HoneyPayGiveCardUI.this).getText()))
        {
          HoneyPayGiveCardUI.b(HoneyPayGiveCardUI.this).setVisibility(8);
          HoneyPayGiveCardUI.c(HoneyPayGiveCardUI.this).setVisibility(0);
          HoneyPayGiveCardUI.i(HoneyPayGiveCardUI.this);
          HoneyPayGiveCardUI.j(HoneyPayGiveCardUI.this);
        }
        AppMethodBeat.o(41865);
      }
    });
    setEditFocusListener(this.nIP, 2, false);
    this.nIP.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(41866);
        HoneyPayGiveCardUI.b(HoneyPayGiveCardUI.this).d(HoneyPayGiveCardUI.this);
        AppMethodBeat.o(41866);
      }
    }, 100L);
    this.nIV = ((CdnImageView)findViewById(2131825041));
    if (!bo.isNullOrNil(this.lix))
    {
      this.nIV.eq(this.lix, c.bHU());
      AppMethodBeat.o(41869);
      return;
    }
    this.nIV.setImageResource(c.bHU());
    AppMethodBeat.o(41869);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(41872);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(41872);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(41868);
    this.nHx = 2131690170;
    super.onCreate(paramBundle);
    getWindow().setBackgroundDrawableResource(2131690709);
    this.nIs = getIntent().getLongExtra("key_max_credit_line", 0L);
    this.nIt = getIntent().getLongExtra("key_min_credit_line", 0L);
    this.mTrueName = getIntent().getStringExtra("key_true_name");
    this.ikj = getIntent().getStringExtra("key_username");
    this.nIF = getIntent().getStringExtra("key_wishing");
    this.lix = getIntent().getStringExtra("key_icon_url");
    this.nIH = getIntent().getIntExtra("key_cardtype", 0);
    if (this.nIH == 0)
    {
      ab.w(this.TAG, "error card type!!");
      finish();
    }
    initView();
    setMMTitle(2131300673);
    AppMethodBeat.o(41868);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(41871);
    super.onDestroy();
    AppMethodBeat.o(41871);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
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