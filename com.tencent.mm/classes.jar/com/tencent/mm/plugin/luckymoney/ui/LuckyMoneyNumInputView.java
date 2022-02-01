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
import com.tenpay.android.wechat.TenpaySecureEditText;

public class LuckyMoneyNumInputView
  extends LinearLayout
  implements d
{
  private int EJG;
  private TenpaySecureEditText ELt;
  private TextView ELu;
  private int ELv;
  private int ELw;
  private int ELx;
  private h EtX;
  private o EtY;
  private TextView pPT;
  private TextWatcher uY;
  
  public LuckyMoneyNumInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(65767);
    this.ELv = 1;
    this.ELw = 2147483647;
    this.ELx = 1;
    this.EJG = 0;
    this.uY = new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(65765);
        if (LuckyMoneyNumInputView.a(LuckyMoneyNumInputView.this) != null)
        {
          paramAnonymousEditable = LuckyMoneyNumInputView.a(LuckyMoneyNumInputView.this);
          LuckyMoneyNumInputView.this.getInputViewId();
          paramAnonymousEditable.eOd();
        }
        AppMethodBeat.o(65765);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    };
    paramContext = LayoutInflater.from(paramContext).inflate(a.g.lucky_money_num_input_view, this, true);
    this.pPT = ((TextView)paramContext.findViewById(a.f.lucky_money_num_input_title));
    this.ELt = ((TenpaySecureEditText)paramContext.findViewById(a.f.lucky_money_et));
    this.ELu = ((TextView)paramContext.findViewById(a.f.lucky_money_num_unit));
    this.ELt.setText(this.ELv);
    this.ELt.addTextChangedListener(this.uY);
    AppMethodBeat.o(65767);
  }
  
  private boolean ePO()
  {
    AppMethodBeat.i(65775);
    if ((this.EtY != null) && (!Util.isNullOrNil(this.EtY.EyS)))
    {
      AppMethodBeat.o(65775);
      return true;
    }
    AppMethodBeat.o(65775);
    return false;
  }
  
  public final String VJ(int paramInt)
  {
    AppMethodBeat.i(65776);
    if (this.EJG == 1)
    {
      a.eNR();
      this.EtY = a.eNT().eOz();
    }
    String str;
    while (paramInt == 1) {
      if (ePO())
      {
        str = getContext().getString(a.i.lucky_money_num_max_limit_tips_format, new Object[] { Integer.valueOf(this.ELw), this.EtY.EyS });
        AppMethodBeat.o(65776);
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
        str = getContext().getString(a.i.lucky_money_num_max_limit_tips, new Object[] { Integer.valueOf(this.ELw) });
        AppMethodBeat.o(65776);
        return str;
      }
    }
    if (paramInt == 2)
    {
      if (ePO())
      {
        str = getContext().getString(a.i.lucky_money_num_luck_min_limit_tips_format, new Object[] { Integer.valueOf(this.ELx), this.EtY.EyS });
        AppMethodBeat.o(65776);
        return str;
      }
      str = getContext().getString(a.i.lucky_money_num_luck_min_limit_tips);
      AppMethodBeat.o(65776);
      return str;
    }
    AppMethodBeat.o(65776);
    return null;
  }
  
  public final int eOc()
  {
    AppMethodBeat.i(65771);
    if (Util.isNullOrNil(this.ELt.getText().toString()))
    {
      AppMethodBeat.o(65771);
      return 0;
    }
    int i = Util.getInt(this.ELt.getText().toString(), -1);
    if (i < 0)
    {
      AppMethodBeat.o(65771);
      return 3;
    }
    if ((i > this.ELw) && (this.ELw > 0))
    {
      AppMethodBeat.o(65771);
      return 1;
    }
    if ((i < this.ELx) && (this.ELx > 0))
    {
      AppMethodBeat.o(65771);
      return 2;
    }
    AppMethodBeat.o(65771);
    return 0;
  }
  
  public int getInput()
  {
    AppMethodBeat.i(65769);
    try
    {
      int i = Integer.parseInt(this.ELt.getText().toString(), 10);
      AppMethodBeat.o(65769);
      return i;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(65769);
    }
    return 0;
  }
  
  public int getInputViewId()
  {
    AppMethodBeat.i(65774);
    int i = getId();
    AppMethodBeat.o(65774);
    return i;
  }
  
  public final void onError()
  {
    AppMethodBeat.i(65773);
    this.pPT.setTextColor(ag.hr(getContext()));
    this.ELt.setTextColor(ag.hr(getContext()));
    this.ELu.setTextColor(ag.hr(getContext()));
    AppMethodBeat.o(65773);
  }
  
  public final void restore()
  {
    AppMethodBeat.i(65772);
    this.pPT.setTextColor(getContext().getResources().getColor(a.c.normal_text_color));
    this.ELt.setTextColor(getContext().getResources().getColor(a.c.normal_text_color));
    this.ELu.setTextColor(getContext().getResources().getColor(a.c.normal_text_color));
    AppMethodBeat.o(65772);
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(65766);
    this.ELt.setHint(paramString);
    AppMethodBeat.o(65766);
  }
  
  public void setMaxNum(int paramInt)
  {
    int j = 3;
    AppMethodBeat.i(65768);
    this.ELw = paramInt;
    int k = 0;
    int i = paramInt;
    paramInt = k;
    while (i > 0)
    {
      paramInt += 1;
      i /= 10;
    }
    if (paramInt <= 3) {
      paramInt = j;
    }
    for (;;)
    {
      this.ELt.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
      AppMethodBeat.o(65768);
      return;
    }
  }
  
  public void setMinNum(int paramInt)
  {
    this.ELx = paramInt;
  }
  
  public void setNum(String paramString)
  {
    AppMethodBeat.i(65770);
    this.ELt.setText(paramString);
    this.ELt.setSelection(this.ELt.getText().length());
    this.ELv = Util.getInt(paramString, 0);
    AppMethodBeat.o(65770);
  }
  
  public void setOnInputValidChangerListener(h paramh)
  {
    this.EtX = paramh;
  }
  
  public void setRtxLuckyMoney(int paramInt)
  {
    this.EJG = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNumInputView
 * JD-Core Version:    0.7.0.1
 */