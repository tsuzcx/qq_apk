package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.app.a;
import com.tencent.mm.plugin.luckymoney.model.ag;
import com.tencent.mm.plugin.luckymoney.model.ah;
import com.tencent.mm.plugin.luckymoney.model.o;
import com.tencent.mm.plugin.luckymoney.model.p;
import com.tencent.mm.plugin.luckymoney.model.v;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.i;

public class LuckyMoneyMoneyInputView
  extends LinearLayout
  implements d
{
  private FixedAlignRightLabelEditText KDm;
  private int KDn;
  private h KmE;
  private o KmF;
  private double KmG;
  private double KmH;
  private ImageView Knb;
  public int mType;
  private TextView sUt;
  private TextWatcher vU;
  private String xdm;
  
  public LuckyMoneyMoneyInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(65618);
    this.KDn = 0;
    this.vU = new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(65616);
        if (!Util.isNullOrNil(paramAnonymousEditable.toString())) {
          LuckyMoneyMoneyInputView.b(LuckyMoneyMoneyInputView.this).setFixedLabelText(LuckyMoneyMoneyInputView.a(LuckyMoneyMoneyInputView.this));
        }
        for (;;)
        {
          if (LuckyMoneyMoneyInputView.c(LuckyMoneyMoneyInputView.this) != null)
          {
            paramAnonymousEditable = LuckyMoneyMoneyInputView.c(LuckyMoneyMoneyInputView.this);
            LuckyMoneyMoneyInputView.this.getInputViewId();
            paramAnonymousEditable.fWx();
          }
          AppMethodBeat.o(65616);
          return;
          LuckyMoneyMoneyInputView.b(LuckyMoneyMoneyInputView.this).setFixedLabelText("");
        }
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    };
    if (this.KDn == 1)
    {
      a.fWk();
      this.KmF = a.fWm().fWW();
    }
    for (;;)
    {
      paramAttributeSet = LayoutInflater.from(paramContext).inflate(a.g.lucky_money_money_input_view, this, true);
      this.KDm = ((FixedAlignRightLabelEditText)paramAttributeSet.findViewById(a.f.lucky_money_et));
      this.KDm.setTypeface(i.bE(paramContext, 7));
      this.KDm.addTextChangedListener(this.vU);
      this.sUt = ((TextView)paramAttributeSet.findViewById(a.f.lucky_money_money_input_title));
      this.Knb = ((ImageView)paramAttributeSet.findViewById(a.f.lucky_money_money_input_group_icon));
      AppMethodBeat.o(65618);
      return;
      if (this.KDn == 2)
      {
        a.fWk();
        this.KmF = a.fWn().fWW();
      }
      else
      {
        a.fWk();
        this.KmF = a.fWl().fWW();
      }
    }
  }
  
  private boolean fYu()
  {
    AppMethodBeat.i(65629);
    if ((this.KmF != null) && (!Util.isNullOrNil(this.KmF.KrF)))
    {
      AppMethodBeat.o(65629);
      return true;
    }
    AppMethodBeat.o(65629);
    return false;
  }
  
  public final String ZF(int paramInt)
  {
    AppMethodBeat.i(65630);
    if (this.KDn == 1)
    {
      a.fWk();
      this.KmF = a.fWm().fWW();
    }
    String str;
    while (paramInt == 1) {
      if (this.mType == 1)
      {
        str = getContext().getString(a.i.lucky_money_total_amount_max_limit_tips, new Object[] { Math.round(this.KmG), Util.nullAs(this.KmF.Kmh, "") });
        AppMethodBeat.o(65630);
        return str;
        if (this.KDn == 2)
        {
          a.fWk();
          this.KmF = a.fWn().fWW();
        }
        else
        {
          a.fWk();
          this.KmF = a.fWl().fWW();
        }
      }
      else
      {
        if (fYu())
        {
          str = getContext().getString(a.i.lucky_money_amount_max_limit_tips_format, new Object[] { this.KmF.KrF, Math.round(this.KmG), Util.nullAs(this.KmF.Kmh, "") });
          AppMethodBeat.o(65630);
          return str;
        }
        str = getContext().getString(a.i.lucky_money_amount_max_limit_tips, new Object[] { Math.round(this.KmG), Util.nullAs(this.KmF.Kmh, "") });
        AppMethodBeat.o(65630);
        return str;
      }
    }
    if (paramInt == 2)
    {
      if (fYu())
      {
        str = getContext().getString(a.i.lucky_money_amount_min_limit_tips_format, new Object[] { this.KmF.KrF, i.formatMoney2f(this.KmH), Util.nullAs(this.KmF.Kmh, "") });
        AppMethodBeat.o(65630);
        return str;
      }
      str = getContext().getString(a.i.lucky_money_amount_min_limit_tips, new Object[] { i.formatMoney2f(this.KmH), Util.nullAs(this.KmF.Kmh, "") });
      AppMethodBeat.o(65630);
      return str;
    }
    if ((paramInt == 4) || (paramInt == 3))
    {
      str = getContext().getString(a.i.lucky_money_prepare_item_error_accessibility_text, new Object[] { this.sUt.getText() });
      AppMethodBeat.o(65630);
      return str;
    }
    AppMethodBeat.o(65630);
    return null;
  }
  
  public final void atR()
  {
    AppMethodBeat.i(65627);
    this.sUt.setTextColor(ah.iM(getContext()));
    this.KDm.setTextColor(ah.iM(getContext()));
    AppMethodBeat.o(65627);
  }
  
  public final int fWv()
  {
    AppMethodBeat.i(65625);
    if (Util.isNullOrNil(this.KDm.getText().toString()))
    {
      AppMethodBeat.o(65625);
      return 0;
    }
    double d = getInput();
    if (d < 0.0D)
    {
      AppMethodBeat.o(65625);
      return 3;
    }
    if ((d > this.KmG) && (this.KmG > 0.0D))
    {
      AppMethodBeat.o(65625);
      return 1;
    }
    if ((d < this.KmH) && (d > 0.0D))
    {
      AppMethodBeat.o(65625);
      return 2;
    }
    AppMethodBeat.o(65625);
    return 0;
  }
  
  public final int fWw()
  {
    AppMethodBeat.i(284218);
    if (Util.isNullOrNil(this.KDm.getText().toString()))
    {
      AppMethodBeat.o(284218);
      return 4;
    }
    double d = Util.getDouble(this.KDm.getText().toString(), -1.0D);
    if (d <= 0.0D)
    {
      AppMethodBeat.o(284218);
      return 3;
    }
    if ((d > this.KmG) && (this.KmG > 0.0D))
    {
      AppMethodBeat.o(284218);
      return 1;
    }
    if ((d < this.KmH) && (d > 0.0D))
    {
      AppMethodBeat.o(284218);
      return 2;
    }
    AppMethodBeat.o(284218);
    return 0;
  }
  
  public EditText getEditText()
  {
    return this.KDm;
  }
  
  public double getInput()
  {
    AppMethodBeat.i(65619);
    double d = Util.getDouble(this.KDm.getText().toString(), 0.0D);
    AppMethodBeat.o(65619);
    return d;
  }
  
  public int getInputViewId()
  {
    AppMethodBeat.i(65628);
    int i = getId();
    AppMethodBeat.o(65628);
    return i;
  }
  
  public final void restore()
  {
    AppMethodBeat.i(65626);
    this.sUt.setTextColor(getContext().getResources().getColor(a.c.normal_text_color));
    this.KDm.setTextColor(getContext().getResources().getColor(a.c.normal_text_color));
    AppMethodBeat.o(65626);
  }
  
  public void setAmount(String paramString)
  {
    AppMethodBeat.i(65624);
    this.KDm.setText(paramString);
    this.KDm.setSelection(paramString.length());
    AppMethodBeat.o(65624);
  }
  
  public void setCurrencyUnitPrefix(String paramString)
  {
    AppMethodBeat.i(284178);
    this.xdm = paramString;
    this.KDm.setFixedLabelText(paramString);
    AppMethodBeat.o(284178);
  }
  
  public void setGroupIconIv(int paramInt)
  {
    AppMethodBeat.i(65622);
    this.Knb.setImageResource(paramInt);
    AppMethodBeat.o(65622);
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(65617);
    this.KDm.setHint(paramString);
    AppMethodBeat.o(65617);
  }
  
  public void setMaxAmount(double paramDouble)
  {
    this.KmG = paramDouble;
  }
  
  public void setMaxLen(int paramInt)
  {
    AppMethodBeat.i(65623);
    this.KDm.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
    AppMethodBeat.o(65623);
  }
  
  public void setMinAmount(double paramDouble)
  {
    this.KmH = paramDouble;
  }
  
  public void setOnInputValidChangerListener(h paramh)
  {
    this.KmE = paramh;
  }
  
  public void setRtxLuckyMoney(int paramInt)
  {
    this.KDn = paramInt;
  }
  
  public void setShowGroupIcon(boolean paramBoolean)
  {
    AppMethodBeat.i(65621);
    if (paramBoolean)
    {
      this.Knb.setVisibility(0);
      AppMethodBeat.o(65621);
      return;
    }
    this.Knb.setVisibility(8);
    AppMethodBeat.o(65621);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(65620);
    this.sUt.setText(paramString);
    AppMethodBeat.o(65620);
  }
  
  public void setType(int paramInt)
  {
    this.mType = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMoneyInputView
 * JD-Core Version:    0.7.0.1
 */