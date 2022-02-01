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
import com.tencent.mm.plugin.luckymoney.model.j;
import com.tencent.mm.plugin.luckymoney.model.k;
import com.tencent.mm.plugin.luckymoney.model.z;
import com.tencent.mm.sdk.platformtools.bs;
import com.tenpay.android.wechat.TenpaySecureEditText;

public class LuckyMoneyNumInputView
  extends LinearLayout
  implements c
{
  private TextWatcher auC;
  private TextView lfN;
  private g ugV;
  private j ugW;
  private TenpaySecureEditText uwB;
  private TextView uwC;
  private int uwD;
  private int uwE;
  private int uwF;
  
  public LuckyMoneyNumInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(65767);
    this.uwD = 1;
    this.uwE = 2147483647;
    this.uwF = 1;
    this.auC = new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(65765);
        if (LuckyMoneyNumInputView.a(LuckyMoneyNumInputView.this) != null)
        {
          paramAnonymousEditable = LuckyMoneyNumInputView.a(LuckyMoneyNumInputView.this);
          LuckyMoneyNumInputView.this.getInputViewId();
          paramAnonymousEditable.cYF();
        }
        AppMethodBeat.o(65765);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    };
    paramContext = LayoutInflater.from(paramContext).inflate(2131494653, this, true);
    this.lfN = ((TextView)paramContext.findViewById(2131301892));
    this.uwB = ((TenpaySecureEditText)paramContext.findViewById(2131301810));
    this.uwC = ((TextView)paramContext.findViewById(2131301893));
    this.uwB.setText(this.uwD);
    this.uwB.addTextChangedListener(this.auC);
    AppMethodBeat.o(65767);
  }
  
  private boolean dae()
  {
    AppMethodBeat.i(65775);
    if ((this.ugW != null) && (!bs.isNullOrNil(this.ugW.uls)))
    {
      AppMethodBeat.o(65775);
      return true;
    }
    AppMethodBeat.o(65775);
    return false;
  }
  
  public final String HD(int paramInt)
  {
    AppMethodBeat.i(65776);
    a.cYv();
    this.ugW = a.cYw().cYZ();
    String str;
    if (paramInt == 1)
    {
      if (dae())
      {
        str = getContext().getString(2131760915, new Object[] { Integer.valueOf(this.uwE), this.ugW.uls });
        AppMethodBeat.o(65776);
        return str;
      }
      str = getContext().getString(2131760914, new Object[] { Integer.valueOf(this.uwE) });
      AppMethodBeat.o(65776);
      return str;
    }
    if (paramInt == 2)
    {
      if (dae())
      {
        str = getContext().getString(2131760913, new Object[] { Integer.valueOf(this.uwF), this.ugW.uls });
        AppMethodBeat.o(65776);
        return str;
      }
      str = getContext().getString(2131760912);
      AppMethodBeat.o(65776);
      return str;
    }
    AppMethodBeat.o(65776);
    return null;
  }
  
  public final int cYE()
  {
    AppMethodBeat.i(65771);
    if (bs.isNullOrNil(this.uwB.getText().toString()))
    {
      AppMethodBeat.o(65771);
      return 0;
    }
    int i = bs.getInt(this.uwB.getText().toString(), -1);
    if (i < 0)
    {
      AppMethodBeat.o(65771);
      return 3;
    }
    if ((i > this.uwE) && (this.uwE > 0))
    {
      AppMethodBeat.o(65771);
      return 1;
    }
    if ((i < this.uwF) && (this.uwF > 0))
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
      int i = Integer.parseInt(this.uwB.getText().toString(), 10);
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
    this.lfN.setTextColor(z.fC(getContext()));
    this.uwB.setTextColor(z.fC(getContext()));
    this.uwC.setTextColor(z.fC(getContext()));
    AppMethodBeat.o(65773);
  }
  
  public final void restore()
  {
    AppMethodBeat.i(65772);
    this.lfN.setTextColor(getContext().getResources().getColor(2131100711));
    this.uwB.setTextColor(getContext().getResources().getColor(2131100711));
    this.uwC.setTextColor(getContext().getResources().getColor(2131100711));
    AppMethodBeat.o(65772);
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(65766);
    this.uwB.setHint(paramString);
    AppMethodBeat.o(65766);
  }
  
  public void setMaxNum(int paramInt)
  {
    int j = 3;
    AppMethodBeat.i(65768);
    this.uwE = paramInt;
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
      this.uwB.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
      AppMethodBeat.o(65768);
      return;
    }
  }
  
  public void setMinNum(int paramInt)
  {
    this.uwF = paramInt;
  }
  
  public void setNum(String paramString)
  {
    AppMethodBeat.i(65770);
    this.uwB.setText(paramString);
    this.uwB.setSelection(this.uwB.getText().length());
    this.uwD = bs.getInt(paramString, 0);
    AppMethodBeat.o(65770);
  }
  
  public void setOnInputValidChangerListener(g paramg)
  {
    this.ugV = paramg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNumInputView
 * JD-Core Version:    0.7.0.1
 */