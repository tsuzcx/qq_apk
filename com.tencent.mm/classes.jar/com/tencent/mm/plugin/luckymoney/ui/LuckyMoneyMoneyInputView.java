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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.b.a;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.plugin.luckymoney.model.ag;
import com.tencent.mm.plugin.luckymoney.model.o;
import com.tencent.mm.plugin.luckymoney.model.p;
import com.tencent.mm.plugin.luckymoney.model.w;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.g;
import com.tenpay.android.wechat.TenpaySecureEditText;

public class LuckyMoneyMoneyInputView
  extends LinearLayout
  implements d
{
  private int EJG;
  private TenpaySecureEditText EtU;
  private TextView EtV;
  private h EtX;
  private o EtY;
  private double EtZ;
  private double Eua;
  private ImageView Euu;
  public int mType;
  private TextView pPT;
  private TextWatcher uY;
  
  public LuckyMoneyMoneyInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(65618);
    this.EJG = 0;
    this.uY = new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(65616);
        if (LuckyMoneyMoneyInputView.a(LuckyMoneyMoneyInputView.this) != null)
        {
          paramAnonymousEditable = LuckyMoneyMoneyInputView.a(LuckyMoneyMoneyInputView.this);
          LuckyMoneyMoneyInputView.this.getInputViewId();
          paramAnonymousEditable.eOd();
        }
        AppMethodBeat.o(65616);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    };
    if (this.EJG == 1)
    {
      a.eNR();
      this.EtY = a.eNT().eOz();
    }
    for (;;)
    {
      paramAttributeSet = LayoutInflater.from(paramContext).inflate(a.g.lucky_money_money_input_view, this, true);
      this.EtU = ((TenpaySecureEditText)paramAttributeSet.findViewById(a.f.lucky_money_et));
      this.EtU.setTypeface(g.bl(paramContext, 3));
      this.EtU.addTextChangedListener(this.uY);
      this.pPT = ((TextView)paramAttributeSet.findViewById(a.f.lucky_money_money_input_title));
      this.Euu = ((ImageView)paramAttributeSet.findViewById(a.f.lucky_money_money_input_group_icon));
      this.EtV = ((TextView)paramAttributeSet.findViewById(a.f.lucky_money_amount_unit_title));
      AppMethodBeat.o(65618);
      return;
      if (this.EJG == 2)
      {
        a.eNR();
        this.EtY = a.eNU().eOz();
      }
      else
      {
        a.eNR();
        this.EtY = a.eNS().eOz();
      }
    }
  }
  
  private boolean ePO()
  {
    AppMethodBeat.i(65629);
    if ((this.EtY != null) && (!Util.isNullOrNil(this.EtY.EyS)))
    {
      AppMethodBeat.o(65629);
      return true;
    }
    AppMethodBeat.o(65629);
    return false;
  }
  
  public final String VJ(int paramInt)
  {
    AppMethodBeat.i(65630);
    if (this.EJG == 1)
    {
      a.eNR();
      this.EtY = a.eNT().eOz();
    }
    String str;
    while (paramInt == 1) {
      if (this.mType == 1)
      {
        str = getContext().getString(a.i.lucky_money_total_amount_max_limit_tips, new Object[] { Math.round(this.EtZ), Util.nullAs(this.EtY.EtA, "") });
        AppMethodBeat.o(65630);
        return str;
        if (this.EJG == 2)
        {
          a.eNR();
          this.EtY = a.eNU().eOz();
        }
        else
        {
          a.eNR();
          this.EtY = a.eNS().eOz();
        }
      }
      else
      {
        if (ePO())
        {
          str = getContext().getString(a.i.lucky_money_amount_max_limit_tips_format, new Object[] { this.EtY.EyS, Math.round(this.EtZ), Util.nullAs(this.EtY.EtA, "") });
          AppMethodBeat.o(65630);
          return str;
        }
        str = getContext().getString(a.i.lucky_money_amount_max_limit_tips, new Object[] { Math.round(this.EtZ), Util.nullAs(this.EtY.EtA, "") });
        AppMethodBeat.o(65630);
        return str;
      }
    }
    if (paramInt == 2)
    {
      if (ePO())
      {
        str = getContext().getString(a.i.lucky_money_amount_min_limit_tips_format, new Object[] { this.EtY.EyS, g.formatMoney2f(this.Eua), Util.nullAs(this.EtY.EtA, "") });
        AppMethodBeat.o(65630);
        return str;
      }
      str = getContext().getString(a.i.lucky_money_amount_min_limit_tips, new Object[] { g.formatMoney2f(this.Eua), Util.nullAs(this.EtY.EtA, "") });
      AppMethodBeat.o(65630);
      return str;
    }
    AppMethodBeat.o(65630);
    return null;
  }
  
  public final int eOc()
  {
    AppMethodBeat.i(65625);
    if (Util.isNullOrNil(this.EtU.getText().toString()))
    {
      AppMethodBeat.o(65625);
      return 0;
    }
    double d = Util.getDouble(this.EtU.getText().toString(), -1.0D);
    if (d < 0.0D)
    {
      AppMethodBeat.o(65625);
      return 3;
    }
    if ((d > this.EtZ) && (this.EtZ > 0.0D))
    {
      AppMethodBeat.o(65625);
      return 1;
    }
    if ((d < this.Eua) && (d > 0.0D))
    {
      AppMethodBeat.o(65625);
      return 2;
    }
    AppMethodBeat.o(65625);
    return 0;
  }
  
  public double getInput()
  {
    AppMethodBeat.i(65619);
    double d = Util.getDouble(this.EtU.getText().toString(), 0.0D);
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
  
  public final void onError()
  {
    AppMethodBeat.i(65627);
    this.pPT.setTextColor(ag.hr(getContext()));
    this.EtU.setTextColor(ag.hr(getContext()));
    this.EtV.setTextColor(ag.hr(getContext()));
    AppMethodBeat.o(65627);
  }
  
  public final void restore()
  {
    AppMethodBeat.i(65626);
    this.pPT.setTextColor(getContext().getResources().getColor(a.c.normal_text_color));
    this.EtU.setTextColor(getContext().getResources().getColor(a.c.normal_text_color));
    this.EtV.setTextColor(getContext().getResources().getColor(a.c.normal_text_color));
    AppMethodBeat.o(65626);
  }
  
  public void setAmount(String paramString)
  {
    AppMethodBeat.i(65624);
    this.EtU.setText(paramString);
    this.EtU.setSelection(paramString.length());
    AppMethodBeat.o(65624);
  }
  
  public void setGroupIconIv(int paramInt)
  {
    AppMethodBeat.i(65622);
    this.Euu.setImageResource(paramInt);
    AppMethodBeat.o(65622);
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(65617);
    this.EtU.setHint(paramString);
    AppMethodBeat.o(65617);
  }
  
  public void setMaxAmount(double paramDouble)
  {
    this.EtZ = paramDouble;
  }
  
  public void setMaxLen(int paramInt)
  {
    AppMethodBeat.i(65623);
    this.EtU.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
    AppMethodBeat.o(65623);
  }
  
  public void setMinAmount(double paramDouble)
  {
    this.Eua = paramDouble;
  }
  
  public void setOnInputValidChangerListener(h paramh)
  {
    this.EtX = paramh;
  }
  
  public void setRtxLuckyMoney(int paramInt)
  {
    this.EJG = paramInt;
  }
  
  public void setShowGroupIcon(boolean paramBoolean)
  {
    AppMethodBeat.i(65621);
    if (paramBoolean)
    {
      this.Euu.setVisibility(0);
      AppMethodBeat.o(65621);
      return;
    }
    this.Euu.setVisibility(8);
    AppMethodBeat.o(65621);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(65620);
    this.pPT.setText(paramString);
    AppMethodBeat.o(65620);
  }
  
  public void setType(int paramInt)
  {
    this.mType = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMoneyInputView
 * JD-Core Version:    0.7.0.1
 */