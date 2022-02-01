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
import com.tencent.mm.plugin.luckymoney.model.j;
import com.tencent.mm.plugin.luckymoney.model.k;
import com.tencent.mm.plugin.luckymoney.model.z;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.ui.e;
import com.tenpay.android.wechat.TenpaySecureEditText;

public class LuckyMoneyMoneyInputView
  extends LinearLayout
  implements c
{
  private TextWatcher awu;
  private TextView lCL;
  public int mType;
  private TenpaySecureEditText vjC;
  private TextView vjD;
  private g vjF;
  private j vjG;
  private double vjH;
  private double vjI;
  private ImageView vkc;
  
  public LuckyMoneyMoneyInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(65618);
    this.awu = new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(65616);
        if (LuckyMoneyMoneyInputView.a(LuckyMoneyMoneyInputView.this) != null)
        {
          paramAnonymousEditable = LuckyMoneyMoneyInputView.a(LuckyMoneyMoneyInputView.this);
          LuckyMoneyMoneyInputView.this.getInputViewId();
          paramAnonymousEditable.dhR();
        }
        AppMethodBeat.o(65616);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    };
    a.dhH();
    this.vjG = a.dhI().dil();
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(2131494646, this, true);
    this.vjC = ((TenpaySecureEditText)paramAttributeSet.findViewById(2131301810));
    this.vjC.setTypeface(e.aR(paramContext, 3));
    this.vjC.addTextChangedListener(this.awu);
    this.lCL = ((TextView)paramAttributeSet.findViewById(2131301837));
    this.vkc = ((ImageView)paramAttributeSet.findViewById(2131301836));
    this.vjD = ((TextView)paramAttributeSet.findViewById(2131301716));
    AppMethodBeat.o(65618);
  }
  
  private boolean djr()
  {
    AppMethodBeat.i(65629);
    if ((this.vjG != null) && (!bt.isNullOrNil(this.vjG.vnY)))
    {
      AppMethodBeat.o(65629);
      return true;
    }
    AppMethodBeat.o(65629);
    return false;
  }
  
  public final String IZ(int paramInt)
  {
    AppMethodBeat.i(65630);
    a.dhH();
    this.vjG = a.dhI().dil();
    String str;
    if (paramInt == 1)
    {
      if (this.mType == 1)
      {
        str = getContext().getString(2131760977, new Object[] { Math.round(this.vjH), bt.bI(this.vjG.vji, "") });
        AppMethodBeat.o(65630);
        return str;
      }
      if (djr())
      {
        str = getContext().getString(2131760827, new Object[] { this.vjG.vnY, Math.round(this.vjH), bt.bI(this.vjG.vji, "") });
        AppMethodBeat.o(65630);
        return str;
      }
      str = getContext().getString(2131760826, new Object[] { Math.round(this.vjH), bt.bI(this.vjG.vji, "") });
      AppMethodBeat.o(65630);
      return str;
    }
    if (paramInt == 2)
    {
      if (djr())
      {
        str = getContext().getString(2131760829, new Object[] { this.vjG.vnY, e.C(this.vjI), bt.bI(this.vjG.vji, "") });
        AppMethodBeat.o(65630);
        return str;
      }
      str = getContext().getString(2131760828, new Object[] { e.C(this.vjI), bt.bI(this.vjG.vji, "") });
      AppMethodBeat.o(65630);
      return str;
    }
    AppMethodBeat.o(65630);
    return null;
  }
  
  public final int dhQ()
  {
    AppMethodBeat.i(65625);
    if (bt.isNullOrNil(this.vjC.getText().toString()))
    {
      AppMethodBeat.o(65625);
      return 0;
    }
    double d = bt.getDouble(this.vjC.getText().toString(), -1.0D);
    if (d < 0.0D)
    {
      AppMethodBeat.o(65625);
      return 3;
    }
    if ((d > this.vjH) && (this.vjH > 0.0D))
    {
      AppMethodBeat.o(65625);
      return 1;
    }
    if ((d < this.vjI) && (d > 0.0D))
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
    double d = bt.getDouble(this.vjC.getText().toString(), 0.0D);
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
    this.lCL.setTextColor(z.fH(getContext()));
    this.vjC.setTextColor(z.fH(getContext()));
    this.vjD.setTextColor(z.fH(getContext()));
    AppMethodBeat.o(65627);
  }
  
  public final void restore()
  {
    AppMethodBeat.i(65626);
    this.lCL.setTextColor(getContext().getResources().getColor(2131100711));
    this.vjC.setTextColor(getContext().getResources().getColor(2131100711));
    this.vjD.setTextColor(getContext().getResources().getColor(2131100711));
    AppMethodBeat.o(65626);
  }
  
  public void setAmount(String paramString)
  {
    AppMethodBeat.i(65624);
    this.vjC.setText(paramString);
    AppMethodBeat.o(65624);
  }
  
  public void setGroupIconIv(int paramInt)
  {
    AppMethodBeat.i(65622);
    this.vkc.setImageResource(paramInt);
    AppMethodBeat.o(65622);
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(65617);
    this.vjC.setHint(paramString);
    AppMethodBeat.o(65617);
  }
  
  public void setMaxAmount(double paramDouble)
  {
    this.vjH = paramDouble;
  }
  
  public void setMaxLen(int paramInt)
  {
    AppMethodBeat.i(65623);
    this.vjC.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
    AppMethodBeat.o(65623);
  }
  
  public void setMinAmount(double paramDouble)
  {
    this.vjI = paramDouble;
  }
  
  public void setOnInputValidChangerListener(g paramg)
  {
    this.vjF = paramg;
  }
  
  public void setShowGroupIcon(boolean paramBoolean)
  {
    AppMethodBeat.i(65621);
    if (paramBoolean)
    {
      this.vkc.setVisibility(0);
      AppMethodBeat.o(65621);
      return;
    }
    this.vkc.setVisibility(8);
    AppMethodBeat.o(65621);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(65620);
    this.lCL.setText(paramString);
    AppMethodBeat.o(65620);
  }
  
  public void setType(int paramInt)
  {
    this.mType = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMoneyInputView
 * JD-Core Version:    0.7.0.1
 */