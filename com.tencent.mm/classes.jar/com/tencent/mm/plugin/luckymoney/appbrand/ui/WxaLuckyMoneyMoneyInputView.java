package com.tencent.mm.plugin.luckymoney.appbrand.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.app.a;
import com.tencent.mm.plugin.luckymoney.appbrand.a.h.a;
import com.tencent.mm.plugin.luckymoney.model.ah;
import com.tencent.mm.plugin.luckymoney.model.o;
import com.tencent.mm.plugin.luckymoney.model.p;
import com.tencent.mm.plugin.luckymoney.ui.d;
import com.tencent.mm.plugin.luckymoney.ui.h;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.i;
import com.tenpay.android.wechat.TenpaySecureEditText;

public class WxaLuckyMoneyMoneyInputView
  extends LinearLayout
  implements d
{
  private TenpaySecureEditText KmB;
  private TextView KmC;
  private View KmD;
  private h KmE;
  private o KmF;
  private double KmG;
  private double KmH;
  public h.a KmI;
  private TextView sUt;
  private TextWatcher vU;
  
  public WxaLuckyMoneyMoneyInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(64893);
    this.vU = new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(64891);
        if (WxaLuckyMoneyMoneyInputView.a(WxaLuckyMoneyMoneyInputView.this) != null)
        {
          paramAnonymousEditable = WxaLuckyMoneyMoneyInputView.a(WxaLuckyMoneyMoneyInputView.this);
          WxaLuckyMoneyMoneyInputView.this.getInputViewId();
          paramAnonymousEditable.fWx();
        }
        AppMethodBeat.o(64891);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    };
    a.fWk();
    this.KmF = a.fWl().fWW();
    paramContext = LayoutInflater.from(paramContext).inflate(a.g.wxa_lucky_money_money_input_view, this, true);
    this.KmB = ((TenpaySecureEditText)paramContext.findViewById(a.f.lucky_money_et));
    this.KmB.addTextChangedListener(this.vU);
    this.sUt = ((TextView)paramContext.findViewById(a.f.lucky_money_money_input_title));
    this.KmD = paramContext.findViewById(a.f.lucky_money_money_input_group_icon);
    this.KmC = ((TextView)paramContext.findViewById(a.f.lucky_money_amount_unit_title));
    AppMethodBeat.o(64893);
  }
  
  public final String ZF(int paramInt)
  {
    AppMethodBeat.i(64903);
    a.fWk();
    this.KmF = a.fWl().fWW();
    String str;
    if (paramInt == 1)
    {
      if (this.KmI == h.a.Kmk)
      {
        str = getContext().getString(a.i.lucky_money_total_amount_max_limit_tips, new Object[] { Math.round(this.KmG), Util.nullAs(this.KmF.Kmh, "") });
        AppMethodBeat.o(64903);
        return str;
      }
      str = getContext().getString(a.i.lucky_money_amount_max_limit_tips, new Object[] { Math.round(this.KmG), Util.nullAs(this.KmF.Kmh, "") });
      AppMethodBeat.o(64903);
      return str;
    }
    if (paramInt == 2)
    {
      str = getContext().getString(a.i.lucky_money_amount_min_limit_tips, new Object[] { i.formatMoney2f(this.KmH), Util.nullAs(this.KmF.Kmh, "") });
      AppMethodBeat.o(64903);
      return str;
    }
    AppMethodBeat.o(64903);
    return null;
  }
  
  public final void atR()
  {
    AppMethodBeat.i(64901);
    this.sUt.setTextColor(ah.iM(getContext()));
    this.KmB.setTextColor(ah.iM(getContext()));
    this.KmC.setTextColor(ah.iM(getContext()));
    AppMethodBeat.o(64901);
  }
  
  public final int fWv()
  {
    AppMethodBeat.i(64899);
    if (Util.isNullOrNil(this.KmB.getText().toString()))
    {
      AppMethodBeat.o(64899);
      return 0;
    }
    double d = Util.getDouble(this.KmB.getText().toString(), -1.0D);
    if (d < 0.0D)
    {
      AppMethodBeat.o(64899);
      return 3;
    }
    if ((d > this.KmG) && (this.KmG > 0.0D))
    {
      AppMethodBeat.o(64899);
      return 1;
    }
    if ((d < this.KmH) && (d > 0.0D))
    {
      AppMethodBeat.o(64899);
      return 2;
    }
    AppMethodBeat.o(64899);
    return 0;
  }
  
  public final int fWw()
  {
    AppMethodBeat.i(284055);
    int i = fWv();
    AppMethodBeat.o(284055);
    return i;
  }
  
  public double getInput()
  {
    AppMethodBeat.i(64894);
    double d = Util.getDouble(this.KmB.getText().toString(), 0.0D);
    AppMethodBeat.o(64894);
    return d;
  }
  
  public int getInputViewId()
  {
    AppMethodBeat.i(64902);
    int i = getId();
    AppMethodBeat.o(64902);
    return i;
  }
  
  public final void restore()
  {
    AppMethodBeat.i(64900);
    this.sUt.setTextColor(getContext().getResources().getColor(a.c.normal_text_color));
    this.KmB.setTextColor(getContext().getResources().getColor(a.c.normal_text_color));
    this.KmC.setTextColor(getContext().getResources().getColor(a.c.normal_text_color));
    AppMethodBeat.o(64900);
  }
  
  public void setAmount(String paramString)
  {
    AppMethodBeat.i(64898);
    this.KmB.setText(paramString);
    AppMethodBeat.o(64898);
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(64892);
    this.KmB.setHint(paramString);
    AppMethodBeat.o(64892);
  }
  
  public void setMaxAmount(double paramDouble)
  {
    this.KmG = paramDouble;
  }
  
  public void setMaxLen(int paramInt)
  {
    AppMethodBeat.i(64897);
    this.KmB.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
    AppMethodBeat.o(64897);
  }
  
  public void setMinAmount(double paramDouble)
  {
    this.KmH = paramDouble;
  }
  
  public void setOnInputValidChangerListener(h paramh)
  {
    this.KmE = paramh;
  }
  
  public void setShowGroupIcon(boolean paramBoolean)
  {
    AppMethodBeat.i(64896);
    if (paramBoolean)
    {
      this.KmD.setVisibility(0);
      AppMethodBeat.o(64896);
      return;
    }
    this.KmD.setVisibility(8);
    AppMethodBeat.o(64896);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(64895);
    this.sUt.setText(paramString);
    AppMethodBeat.o(64895);
  }
  
  public void setType(h.a parama)
  {
    this.KmI = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyMoneyInputView
 * JD-Core Version:    0.7.0.1
 */