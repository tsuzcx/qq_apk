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
import com.tencent.mm.sdk.platformtools.bt;
import com.tenpay.android.wechat.TenpaySecureEditText;

public class LuckyMoneyNumInputView
  extends LinearLayout
  implements c
{
  private TextWatcher awu;
  private TextView lCL;
  private g vjF;
  private j vjG;
  private TenpaySecureEditText vze;
  private TextView vzf;
  private int vzg;
  private int vzh;
  private int vzi;
  
  public LuckyMoneyNumInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(65767);
    this.vzg = 1;
    this.vzh = 2147483647;
    this.vzi = 1;
    this.awu = new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(65765);
        if (LuckyMoneyNumInputView.a(LuckyMoneyNumInputView.this) != null)
        {
          paramAnonymousEditable = LuckyMoneyNumInputView.a(LuckyMoneyNumInputView.this);
          LuckyMoneyNumInputView.this.getInputViewId();
          paramAnonymousEditable.dhR();
        }
        AppMethodBeat.o(65765);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    };
    paramContext = LayoutInflater.from(paramContext).inflate(2131494653, this, true);
    this.lCL = ((TextView)paramContext.findViewById(2131301892));
    this.vze = ((TenpaySecureEditText)paramContext.findViewById(2131301810));
    this.vzf = ((TextView)paramContext.findViewById(2131301893));
    this.vze.setText(this.vzg);
    this.vze.addTextChangedListener(this.awu);
    AppMethodBeat.o(65767);
  }
  
  private boolean djr()
  {
    AppMethodBeat.i(65775);
    if ((this.vjG != null) && (!bt.isNullOrNil(this.vjG.vnY)))
    {
      AppMethodBeat.o(65775);
      return true;
    }
    AppMethodBeat.o(65775);
    return false;
  }
  
  public final String IZ(int paramInt)
  {
    AppMethodBeat.i(65776);
    a.dhH();
    this.vjG = a.dhI().dil();
    String str;
    if (paramInt == 1)
    {
      if (djr())
      {
        str = getContext().getString(2131760915, new Object[] { Integer.valueOf(this.vzh), this.vjG.vnY });
        AppMethodBeat.o(65776);
        return str;
      }
      str = getContext().getString(2131760914, new Object[] { Integer.valueOf(this.vzh) });
      AppMethodBeat.o(65776);
      return str;
    }
    if (paramInt == 2)
    {
      if (djr())
      {
        str = getContext().getString(2131760913, new Object[] { Integer.valueOf(this.vzi), this.vjG.vnY });
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
  
  public final int dhQ()
  {
    AppMethodBeat.i(65771);
    if (bt.isNullOrNil(this.vze.getText().toString()))
    {
      AppMethodBeat.o(65771);
      return 0;
    }
    int i = bt.getInt(this.vze.getText().toString(), -1);
    if (i < 0)
    {
      AppMethodBeat.o(65771);
      return 3;
    }
    if ((i > this.vzh) && (this.vzh > 0))
    {
      AppMethodBeat.o(65771);
      return 1;
    }
    if ((i < this.vzi) && (this.vzi > 0))
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
      int i = Integer.parseInt(this.vze.getText().toString(), 10);
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
    this.lCL.setTextColor(z.fH(getContext()));
    this.vze.setTextColor(z.fH(getContext()));
    this.vzf.setTextColor(z.fH(getContext()));
    AppMethodBeat.o(65773);
  }
  
  public final void restore()
  {
    AppMethodBeat.i(65772);
    this.lCL.setTextColor(getContext().getResources().getColor(2131100711));
    this.vze.setTextColor(getContext().getResources().getColor(2131100711));
    this.vzf.setTextColor(getContext().getResources().getColor(2131100711));
    AppMethodBeat.o(65772);
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(65766);
    this.vze.setHint(paramString);
    AppMethodBeat.o(65766);
  }
  
  public void setMaxNum(int paramInt)
  {
    int j = 3;
    AppMethodBeat.i(65768);
    this.vzh = paramInt;
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
      this.vze.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
      AppMethodBeat.o(65768);
      return;
    }
  }
  
  public void setMinNum(int paramInt)
  {
    this.vzi = paramInt;
  }
  
  public void setNum(String paramString)
  {
    AppMethodBeat.i(65770);
    this.vze.setText(paramString);
    this.vze.setSelection(this.vze.getText().length());
    this.vzg = bt.getInt(paramString, 0);
    AppMethodBeat.o(65770);
  }
  
  public void setOnInputValidChangerListener(g paramg)
  {
    this.vjF = paramg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNumInputView
 * JD-Core Version:    0.7.0.1
 */