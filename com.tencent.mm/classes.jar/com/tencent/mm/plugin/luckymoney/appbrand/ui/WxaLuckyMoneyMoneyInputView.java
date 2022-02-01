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
import com.tencent.mm.plugin.luckymoney.appbrand.a.h.a;
import com.tencent.mm.plugin.luckymoney.b.a;
import com.tencent.mm.plugin.luckymoney.model.ag;
import com.tencent.mm.plugin.luckymoney.model.o;
import com.tencent.mm.plugin.luckymoney.model.p;
import com.tencent.mm.plugin.luckymoney.ui.d;
import com.tencent.mm.plugin.luckymoney.ui.h;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.g;
import com.tenpay.android.wechat.TenpaySecureEditText;

public class WxaLuckyMoneyMoneyInputView
  extends LinearLayout
  implements d
{
  private TenpaySecureEditText EtU;
  private TextView EtV;
  private View EtW;
  private h EtX;
  private o EtY;
  private double EtZ;
  private double Eua;
  public h.a Eub;
  private TextView pPT;
  private TextWatcher uY;
  
  public WxaLuckyMoneyMoneyInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(64893);
    this.uY = new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(64891);
        if (WxaLuckyMoneyMoneyInputView.a(WxaLuckyMoneyMoneyInputView.this) != null)
        {
          paramAnonymousEditable = WxaLuckyMoneyMoneyInputView.a(WxaLuckyMoneyMoneyInputView.this);
          WxaLuckyMoneyMoneyInputView.this.getInputViewId();
          paramAnonymousEditable.eOd();
        }
        AppMethodBeat.o(64891);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    };
    a.eNR();
    this.EtY = a.eNS().eOz();
    paramContext = LayoutInflater.from(paramContext).inflate(a.g.wxa_lucky_money_money_input_view, this, true);
    this.EtU = ((TenpaySecureEditText)paramContext.findViewById(a.f.lucky_money_et));
    this.EtU.addTextChangedListener(this.uY);
    this.pPT = ((TextView)paramContext.findViewById(a.f.lucky_money_money_input_title));
    this.EtW = paramContext.findViewById(a.f.lucky_money_money_input_group_icon);
    this.EtV = ((TextView)paramContext.findViewById(a.f.lucky_money_amount_unit_title));
    AppMethodBeat.o(64893);
  }
  
  public final String VJ(int paramInt)
  {
    AppMethodBeat.i(64903);
    a.eNR();
    this.EtY = a.eNS().eOz();
    String str;
    if (paramInt == 1)
    {
      if (this.Eub == h.a.EtD)
      {
        str = getContext().getString(a.i.lucky_money_total_amount_max_limit_tips, new Object[] { Math.round(this.EtZ), Util.nullAs(this.EtY.EtA, "") });
        AppMethodBeat.o(64903);
        return str;
      }
      str = getContext().getString(a.i.lucky_money_amount_max_limit_tips, new Object[] { Math.round(this.EtZ), Util.nullAs(this.EtY.EtA, "") });
      AppMethodBeat.o(64903);
      return str;
    }
    if (paramInt == 2)
    {
      str = getContext().getString(a.i.lucky_money_amount_min_limit_tips, new Object[] { g.formatMoney2f(this.Eua), Util.nullAs(this.EtY.EtA, "") });
      AppMethodBeat.o(64903);
      return str;
    }
    AppMethodBeat.o(64903);
    return null;
  }
  
  public final int eOc()
  {
    AppMethodBeat.i(64899);
    if (Util.isNullOrNil(this.EtU.getText().toString()))
    {
      AppMethodBeat.o(64899);
      return 0;
    }
    double d = Util.getDouble(this.EtU.getText().toString(), -1.0D);
    if (d < 0.0D)
    {
      AppMethodBeat.o(64899);
      return 3;
    }
    if ((d > this.EtZ) && (this.EtZ > 0.0D))
    {
      AppMethodBeat.o(64899);
      return 1;
    }
    if ((d < this.Eua) && (d > 0.0D))
    {
      AppMethodBeat.o(64899);
      return 2;
    }
    AppMethodBeat.o(64899);
    return 0;
  }
  
  public double getInput()
  {
    AppMethodBeat.i(64894);
    double d = Util.getDouble(this.EtU.getText().toString(), 0.0D);
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
  
  public final void onError()
  {
    AppMethodBeat.i(64901);
    this.pPT.setTextColor(ag.hr(getContext()));
    this.EtU.setTextColor(ag.hr(getContext()));
    this.EtV.setTextColor(ag.hr(getContext()));
    AppMethodBeat.o(64901);
  }
  
  public final void restore()
  {
    AppMethodBeat.i(64900);
    this.pPT.setTextColor(getContext().getResources().getColor(a.c.normal_text_color));
    this.EtU.setTextColor(getContext().getResources().getColor(a.c.normal_text_color));
    this.EtV.setTextColor(getContext().getResources().getColor(a.c.normal_text_color));
    AppMethodBeat.o(64900);
  }
  
  public void setAmount(String paramString)
  {
    AppMethodBeat.i(64898);
    this.EtU.setText(paramString);
    AppMethodBeat.o(64898);
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(64892);
    this.EtU.setHint(paramString);
    AppMethodBeat.o(64892);
  }
  
  public void setMaxAmount(double paramDouble)
  {
    this.EtZ = paramDouble;
  }
  
  public void setMaxLen(int paramInt)
  {
    AppMethodBeat.i(64897);
    this.EtU.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
    AppMethodBeat.o(64897);
  }
  
  public void setMinAmount(double paramDouble)
  {
    this.Eua = paramDouble;
  }
  
  public void setOnInputValidChangerListener(h paramh)
  {
    this.EtX = paramh;
  }
  
  public void setShowGroupIcon(boolean paramBoolean)
  {
    AppMethodBeat.i(64896);
    if (paramBoolean)
    {
      this.EtW.setVisibility(0);
      AppMethodBeat.o(64896);
      return;
    }
    this.EtW.setVisibility(8);
    AppMethodBeat.o(64896);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(64895);
    this.pPT.setText(paramString);
    AppMethodBeat.o(64895);
  }
  
  public void setType(h.a parama)
  {
    this.Eub = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyMoneyInputView
 * JD-Core Version:    0.7.0.1
 */