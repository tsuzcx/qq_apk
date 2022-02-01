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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class HoneyPayGiveCardUI
  extends HoneyPayBaseUI
{
  private String lJm;
  private String mTrueName;
  private String pMn;
  private ImageView pjj;
  private ScrollView uSG;
  private WalletFormView uSH;
  private TextView uSI;
  private TextView uSJ;
  private TextView uSK;
  private TextView uSL;
  private TextView uSM;
  private CdnImageView uSN;
  private MMEditText uSO;
  private long uSk = 100000L;
  private long uSl = 0L;
  private String uSx;
  private int uSz;
  
  private void dfa()
  {
    AppMethodBeat.i(64759);
    this.uSM.setVisibility(0);
    this.uSO.setVisibility(8);
    this.uSO.setText(this.uSx);
    this.uSO.setSelection(this.uSx.length());
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    String str = getString(2131760289);
    SpannableString localSpannableString = k.b(getContext(), this.uSx, this.uSM.getTextSize());
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
    this.uSM.setText(localSpannableStringBuilder);
    AppMethodBeat.o(64759);
  }
  
  private void nw(boolean paramBoolean)
  {
    AppMethodBeat.i(64762);
    if ((paramBoolean) && (!this.uSJ.isShown()))
    {
      String str = ah.fWc() + f.a(new StringBuilder().append(this.uSl).toString(), "100", 2, RoundingMode.HALF_UP);
      this.uSJ.setText(getString(2131760286, new Object[] { str }));
      this.uSJ.startAnimation(AnimationUtils.loadAnimation(this, 2130772068));
      this.uSJ.setVisibility(0);
      AppMethodBeat.o(64762);
      return;
    }
    if ((!paramBoolean) && (this.uSJ.isShown()))
    {
      this.uSJ.startAnimation(AnimationUtils.loadAnimation(this, 2130772088));
      this.uSJ.setVisibility(8);
    }
    AppMethodBeat.o(64762);
  }
  
  private void nx(boolean paramBoolean)
  {
    AppMethodBeat.i(64763);
    if ((paramBoolean) && (!this.uSJ.isShown()))
    {
      String str = ah.fWc() + f.b(new StringBuilder().append(this.uSk).toString(), "100", 2, RoundingMode.HALF_UP).toString();
      this.uSJ.setText(getString(2131760282, new Object[] { str }));
      this.uSJ.startAnimation(AnimationUtils.loadAnimation(this, 2130772068));
      this.uSJ.setVisibility(0);
      AppMethodBeat.o(64763);
      return;
    }
    if ((!paramBoolean) && (this.uSJ.isShown()))
    {
      this.uSJ.startAnimation(AnimationUtils.loadAnimation(this, 2130772088));
      this.uSJ.setVisibility(8);
    }
    AppMethodBeat.o(64763);
  }
  
  private void ny(boolean paramBoolean)
  {
    AppMethodBeat.i(64764);
    this.uSK.setEnabled(paramBoolean);
    AppMethodBeat.o(64764);
  }
  
  public int getLayoutId()
  {
    return 2131494447;
  }
  
  public void initView()
  {
    AppMethodBeat.i(64758);
    this.uSG = ((ScrollView)findViewById(2131300829));
    this.uSH = ((WalletFormView)findViewById(2131300827));
    this.uSI = ((TextView)findViewById(2131300823));
    this.uSJ = ((TextView)findViewById(2131300830));
    this.pjj = ((ImageView)findViewById(2131300821));
    this.uSK = ((TextView)findViewById(2131300824));
    this.uSL = ((TextView)findViewById(2131300825));
    this.uSM = ((TextView)findViewById(2131300832));
    this.uSO = ((MMEditText)findViewById(2131300831));
    a.b.a(this.pjj, this.lJm, 0.06F, false);
    String str2 = f.gY(this.lJm, 10);
    String str1 = str2;
    if (!bu.isNullOrNil(this.mTrueName)) {
      str1 = String.format("%s(%s)", new Object[] { str2, this.mTrueName });
    }
    this.uSI.setText(k.b(getContext(), str1, this.uSI.getTextSize()));
    this.uSH.setContentPadding$3b4dfe4b(0);
    this.uSH.getTitleTv().setText(ah.fWc());
    this.uSH.a(new TextWatcher()
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
    this.uSH.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64749);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/honey_pay/ui/HoneyPayGiveCardUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        HoneyPayGiveCardUI.b(HoneyPayGiveCardUI.this).d(HoneyPayGiveCardUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/honey_pay/ui/HoneyPayGiveCardUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(64749);
      }
    });
    this.uSL.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64750);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/honey_pay/ui/HoneyPayGiveCardUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        HoneyPayGiveCardUI.c(HoneyPayGiveCardUI.this).setVisibility(8);
        HoneyPayGiveCardUI.b(HoneyPayGiveCardUI.this).setVisibility(0);
        HoneyPayGiveCardUI.b(HoneyPayGiveCardUI.this).d(HoneyPayGiveCardUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/honey_pay/ui/HoneyPayGiveCardUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(64750);
      }
    });
    this.uSK.setClickable(true);
    this.uSK.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64751);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/honey_pay/ui/HoneyPayGiveCardUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ae.d(HoneyPayGiveCardUI.this.TAG, "click give btn");
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
          ae.w(HoneyPayGiveCardUI.this.TAG, "over limit when click");
        }
      }
    });
    this.uSM.setClickable(true);
    this.uSM.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(this));
    this.uSO.setOnEditorActionListener(new TextView.OnEditorActionListener()
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
    this.uSO.setOnFocusChangeListener(new View.OnFocusChangeListener()
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
    dfa();
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
        HoneyPayGiveCardUI.b(HoneyPayGiveCardUI.this).dHu();
        if (bu.isNullOrNil(HoneyPayGiveCardUI.b(HoneyPayGiveCardUI.this).getText()))
        {
          HoneyPayGiveCardUI.b(HoneyPayGiveCardUI.this).setVisibility(8);
          HoneyPayGiveCardUI.c(HoneyPayGiveCardUI.this).setVisibility(0);
          HoneyPayGiveCardUI.i(HoneyPayGiveCardUI.this);
          HoneyPayGiveCardUI.j(HoneyPayGiveCardUI.this);
        }
        AppMethodBeat.o(64754);
      }
    });
    setEditFocusListener(this.uSH, 2, false);
    this.uSH.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(64755);
        HoneyPayGiveCardUI.b(HoneyPayGiveCardUI.this).d(HoneyPayGiveCardUI.this);
        AppMethodBeat.o(64755);
      }
    }, 100L);
    this.uSN = ((CdnImageView)findViewById(2131300828));
    if (!bu.isNullOrNil(this.pMn))
    {
      this.uSN.gk(this.pMn, c.deU());
      AppMethodBeat.o(64758);
      return;
    }
    this.uSN.setImageResource(c.deU());
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
    this.uRo = 2131100492;
    super.onCreate(paramBundle);
    getWindow().setBackgroundDrawableResource(2131101179);
    this.uSk = getIntent().getLongExtra("key_max_credit_line", 0L);
    this.uSl = getIntent().getLongExtra("key_min_credit_line", 0L);
    this.mTrueName = getIntent().getStringExtra("key_true_name");
    this.lJm = getIntent().getStringExtra("key_username");
    this.uSx = getIntent().getStringExtra("key_wishing");
    this.pMn = getIntent().getStringExtra("key_icon_url");
    this.uSz = getIntent().getIntExtra("key_cardtype", 0);
    if (this.uSz == 0)
    {
      ae.w(this.TAG, "error card type!!");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayGiveCardUI
 * JD-Core Version:    0.7.0.1
 */