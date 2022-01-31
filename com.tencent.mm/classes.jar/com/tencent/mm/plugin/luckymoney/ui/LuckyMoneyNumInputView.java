package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
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
import com.tencent.mm.plugin.luckymoney.model.i;
import com.tencent.mm.plugin.luckymoney.model.j;
import com.tencent.mm.plugin.luckymoney.model.x;
import com.tencent.mm.sdk.platformtools.bo;
import com.tenpay.android.wechat.TenpaySecureEditText;

public class LuckyMoneyNumInputView
  extends LinearLayout
  implements c
{
  private TextWatcher ami;
  private TextView iJG;
  private int mNum;
  private g oiU;
  private i oiV;
  private TextView ovA;
  private int ovB;
  private int ovC;
  private TenpaySecureEditText ovz;
  
  public LuckyMoneyNumInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(42883);
    this.mNum = 1;
    this.ovB = 2147483647;
    this.ovC = 1;
    this.ami = new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(42881);
        if (LuckyMoneyNumInputView.a(LuckyMoneyNumInputView.this) != null)
        {
          paramAnonymousEditable = LuckyMoneyNumInputView.a(LuckyMoneyNumInputView.this);
          LuckyMoneyNumInputView.this.getInputViewId();
          paramAnonymousEditable.bMQ();
        }
        AppMethodBeat.o(42881);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    };
    paramContext = LayoutInflater.from(paramContext).inflate(2130970039, this, true);
    this.iJG = ((TextView)paramContext.findViewById(2131825761));
    this.ovz = ((TenpaySecureEditText)paramContext.findViewById(2131825700));
    this.ovA = ((TextView)paramContext.findViewById(2131825762));
    this.ovz.setText(this.mNum);
    this.ovz.addTextChangedListener(this.ami);
    AppMethodBeat.o(42883);
  }
  
  private boolean bOa()
  {
    AppMethodBeat.i(42891);
    if ((this.oiV != null) && (!bo.isNullOrNil(this.oiV.onn)))
    {
      AppMethodBeat.o(42891);
      return true;
    }
    AppMethodBeat.o(42891);
    return false;
  }
  
  public final int bMP()
  {
    AppMethodBeat.i(42887);
    if (bo.isNullOrNil(this.ovz.getText().toString()))
    {
      AppMethodBeat.o(42887);
      return 0;
    }
    int i = bo.getInt(this.ovz.getText().toString(), -1);
    if (i < 0)
    {
      AppMethodBeat.o(42887);
      return 3;
    }
    if ((i > this.ovB) && (this.ovB > 0))
    {
      AppMethodBeat.o(42887);
      return 1;
    }
    if ((i < this.ovC) && (this.ovC > 0))
    {
      AppMethodBeat.o(42887);
      return 2;
    }
    AppMethodBeat.o(42887);
    return 0;
  }
  
  public int getInput()
  {
    AppMethodBeat.i(42885);
    try
    {
      int i = Integer.parseInt(this.ovz.getText().toString(), 10);
      AppMethodBeat.o(42885);
      return i;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(42885);
    }
    return 0;
  }
  
  public int getInputViewId()
  {
    AppMethodBeat.i(42890);
    int i = getId();
    AppMethodBeat.o(42890);
    return i;
  }
  
  public final void onError()
  {
    AppMethodBeat.i(42889);
    this.iJG.setTextColor(x.eu(getContext()));
    this.ovz.setTextColor(x.eu(getContext()));
    this.ovA.setTextColor(x.eu(getContext()));
    AppMethodBeat.o(42889);
  }
  
  public final void restore()
  {
    AppMethodBeat.i(42888);
    this.iJG.setTextColor(-16777216);
    this.ovz.setTextColor(-16777216);
    this.ovA.setTextColor(-16777216);
    AppMethodBeat.o(42888);
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(42882);
    this.ovz.setHint(paramString);
    AppMethodBeat.o(42882);
  }
  
  public void setMaxNum(int paramInt)
  {
    int j = 3;
    AppMethodBeat.i(42884);
    this.ovB = paramInt;
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
      this.ovz.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
      AppMethodBeat.o(42884);
      return;
    }
  }
  
  public void setMinNum(int paramInt)
  {
    this.ovC = paramInt;
  }
  
  public void setNum(String paramString)
  {
    AppMethodBeat.i(42886);
    this.ovz.setText(paramString);
    this.ovz.setSelection(this.ovz.getText().length());
    this.mNum = bo.getInt(paramString, 0);
    AppMethodBeat.o(42886);
  }
  
  public void setOnInputValidChangerListener(g paramg)
  {
    this.oiU = paramg;
  }
  
  public final String yf(int paramInt)
  {
    AppMethodBeat.i(42892);
    a.bMG();
    this.oiV = a.bMH().bNk();
    String str;
    if (paramInt == 1)
    {
      if (bOa())
      {
        str = getContext().getString(2131301273, new Object[] { Integer.valueOf(this.ovB), this.oiV.onn });
        AppMethodBeat.o(42892);
        return str;
      }
      str = getContext().getString(2131301272, new Object[] { Integer.valueOf(this.ovB) });
      AppMethodBeat.o(42892);
      return str;
    }
    if (paramInt == 2)
    {
      if (bOa())
      {
        str = getContext().getString(2131301271, new Object[] { Integer.valueOf(this.ovC), this.oiV.onn });
        AppMethodBeat.o(42892);
        return str;
      }
      str = getContext().getString(2131301270, new Object[] { Integer.valueOf(this.ovC) });
      AppMethodBeat.o(42892);
      return str;
    }
    AppMethodBeat.o(42892);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNumInputView
 * JD-Core Version:    0.7.0.1
 */