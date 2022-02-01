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
import com.tencent.mm.plugin.luckymoney.model.ae;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.plugin.luckymoney.model.o;
import com.tencent.mm.plugin.luckymoney.model.p;
import com.tencent.mm.sdk.platformtools.Util;
import com.tenpay.android.wechat.TenpaySecureEditText;

public class LuckyMoneyNumInputView
  extends LinearLayout
  implements d
{
  private TextWatcher aws;
  private TextView mPa;
  private h yPY;
  private o yPZ;
  private boolean zeD;
  private TenpaySecureEditText zgm;
  private TextView zgn;
  private int zgo;
  private int zgp;
  private int zgq;
  
  public LuckyMoneyNumInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(65767);
    this.zgo = 1;
    this.zgp = 2147483647;
    this.zgq = 1;
    this.zeD = false;
    this.aws = new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(65765);
        if (LuckyMoneyNumInputView.a(LuckyMoneyNumInputView.this) != null)
        {
          paramAnonymousEditable = LuckyMoneyNumInputView.a(LuckyMoneyNumInputView.this);
          LuckyMoneyNumInputView.this.getInputViewId();
          paramAnonymousEditable.eeI();
        }
        AppMethodBeat.o(65765);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    };
    paramContext = LayoutInflater.from(paramContext).inflate(2131495376, this, true);
    this.mPa = ((TextView)paramContext.findViewById(2131304211));
    this.zgm = ((TenpaySecureEditText)paramContext.findViewById(2131304116));
    this.zgn = ((TextView)paramContext.findViewById(2131304212));
    this.zgm.setText(this.zgo);
    this.zgm.addTextChangedListener(this.aws);
    AppMethodBeat.o(65767);
  }
  
  private boolean egl()
  {
    AppMethodBeat.i(65775);
    if ((this.yPZ != null) && (!Util.isNullOrNil(this.yPZ.yUV)))
    {
      AppMethodBeat.o(65775);
      return true;
    }
    AppMethodBeat.o(65775);
    return false;
  }
  
  public final String PA(int paramInt)
  {
    AppMethodBeat.i(65776);
    if (this.zeD)
    {
      a.eex();
      this.yPZ = a.eez().efe();
    }
    String str;
    while (paramInt == 1) {
      if (egl())
      {
        str = getContext().getString(2131762689, new Object[] { Integer.valueOf(this.zgp), this.yPZ.yUV });
        AppMethodBeat.o(65776);
        return str;
        a.eex();
        this.yPZ = a.eey().efe();
      }
      else
      {
        str = getContext().getString(2131762688, new Object[] { Integer.valueOf(this.zgp) });
        AppMethodBeat.o(65776);
        return str;
      }
    }
    if (paramInt == 2)
    {
      if (egl())
      {
        str = getContext().getString(2131762687, new Object[] { Integer.valueOf(this.zgq), this.yPZ.yUV });
        AppMethodBeat.o(65776);
        return str;
      }
      str = getContext().getString(2131762686);
      AppMethodBeat.o(65776);
      return str;
    }
    AppMethodBeat.o(65776);
    return null;
  }
  
  public final int eeH()
  {
    AppMethodBeat.i(65771);
    if (Util.isNullOrNil(this.zgm.getText().toString()))
    {
      AppMethodBeat.o(65771);
      return 0;
    }
    int i = Util.getInt(this.zgm.getText().toString(), -1);
    if (i < 0)
    {
      AppMethodBeat.o(65771);
      return 3;
    }
    if ((i > this.zgp) && (this.zgp > 0))
    {
      AppMethodBeat.o(65771);
      return 1;
    }
    if ((i < this.zgq) && (this.zgq > 0))
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
      int i = Integer.parseInt(this.zgm.getText().toString(), 10);
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
    this.mPa.setTextColor(af.gt(getContext()));
    this.zgm.setTextColor(af.gt(getContext()));
    this.zgn.setTextColor(af.gt(getContext()));
    AppMethodBeat.o(65773);
  }
  
  public final void restore()
  {
    AppMethodBeat.i(65772);
    this.mPa.setTextColor(getContext().getResources().getColor(2131100904));
    this.zgm.setTextColor(getContext().getResources().getColor(2131100904));
    this.zgn.setTextColor(getContext().getResources().getColor(2131100904));
    AppMethodBeat.o(65772);
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(65766);
    this.zgm.setHint(paramString);
    AppMethodBeat.o(65766);
  }
  
  public void setMaxNum(int paramInt)
  {
    int j = 3;
    AppMethodBeat.i(65768);
    this.zgp = paramInt;
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
      this.zgm.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
      AppMethodBeat.o(65768);
      return;
    }
  }
  
  public void setMinNum(int paramInt)
  {
    this.zgq = paramInt;
  }
  
  public void setNum(String paramString)
  {
    AppMethodBeat.i(65770);
    this.zgm.setText(paramString);
    this.zgm.setSelection(this.zgm.getText().length());
    this.zgo = Util.getInt(paramString, 0);
    AppMethodBeat.o(65770);
  }
  
  public void setOnInputValidChangerListener(h paramh)
  {
    this.yPY = paramh;
  }
  
  public void setRtxLuckyMoney(boolean paramBoolean)
  {
    this.zeD = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNumInputView
 * JD-Core Version:    0.7.0.1
 */