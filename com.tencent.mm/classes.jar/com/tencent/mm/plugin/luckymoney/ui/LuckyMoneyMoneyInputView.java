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
  private TextWatcher atH;
  private TextView kEu;
  public int mType;
  private TenpaySecureEditText sYE;
  private TextView sYF;
  private g sYH;
  private j sYI;
  private double sYJ;
  private double sYK;
  private ImageView sZe;
  
  public LuckyMoneyMoneyInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(65618);
    this.atH = new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(65616);
        if (LuckyMoneyMoneyInputView.a(LuckyMoneyMoneyInputView.this) != null)
        {
          paramAnonymousEditable = LuckyMoneyMoneyInputView.a(LuckyMoneyMoneyInputView.this);
          LuckyMoneyMoneyInputView.this.getInputViewId();
          paramAnonymousEditable.cKZ();
        }
        AppMethodBeat.o(65616);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    };
    a.cKP();
    this.sYI = a.cKQ().cLt();
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(2131494646, this, true);
    this.sYE = ((TenpaySecureEditText)paramAttributeSet.findViewById(2131301810));
    this.sYE.setTypeface(e.aI(paramContext, 3));
    this.sYE.addTextChangedListener(this.atH);
    this.kEu = ((TextView)paramAttributeSet.findViewById(2131301837));
    this.sZe = ((ImageView)paramAttributeSet.findViewById(2131301836));
    this.sYF = ((TextView)paramAttributeSet.findViewById(2131301716));
    AppMethodBeat.o(65618);
  }
  
  private boolean cMy()
  {
    AppMethodBeat.i(65629);
    if ((this.sYI != null) && (!bt.isNullOrNil(this.sYI.tdd)))
    {
      AppMethodBeat.o(65629);
      return true;
    }
    AppMethodBeat.o(65629);
    return false;
  }
  
  public final String FI(int paramInt)
  {
    AppMethodBeat.i(65630);
    a.cKP();
    this.sYI = a.cKQ().cLt();
    String str;
    if (paramInt == 1)
    {
      if (this.mType == 1)
      {
        str = getContext().getString(2131760977, new Object[] { Math.round(this.sYJ), bt.by(this.sYI.sYk, "") });
        AppMethodBeat.o(65630);
        return str;
      }
      if (cMy())
      {
        str = getContext().getString(2131760827, new Object[] { this.sYI.tdd, Math.round(this.sYJ), bt.by(this.sYI.sYk, "") });
        AppMethodBeat.o(65630);
        return str;
      }
      str = getContext().getString(2131760826, new Object[] { Math.round(this.sYJ), bt.by(this.sYI.sYk, "") });
      AppMethodBeat.o(65630);
      return str;
    }
    if (paramInt == 2)
    {
      if (cMy())
      {
        str = getContext().getString(2131760829, new Object[] { this.sYI.tdd, e.D(this.sYK), bt.by(this.sYI.sYk, "") });
        AppMethodBeat.o(65630);
        return str;
      }
      str = getContext().getString(2131760828, new Object[] { e.D(this.sYK), bt.by(this.sYI.sYk, "") });
      AppMethodBeat.o(65630);
      return str;
    }
    AppMethodBeat.o(65630);
    return null;
  }
  
  public final int cKY()
  {
    AppMethodBeat.i(65625);
    if (bt.isNullOrNil(this.sYE.getText().toString()))
    {
      AppMethodBeat.o(65625);
      return 0;
    }
    double d = bt.getDouble(this.sYE.getText().toString(), -1.0D);
    if (d < 0.0D)
    {
      AppMethodBeat.o(65625);
      return 3;
    }
    if ((d > this.sYJ) && (this.sYJ > 0.0D))
    {
      AppMethodBeat.o(65625);
      return 1;
    }
    if ((d < this.sYK) && (d > 0.0D))
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
    double d = bt.getDouble(this.sYE.getText().toString(), 0.0D);
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
    this.kEu.setTextColor(z.fq(getContext()));
    this.sYE.setTextColor(z.fq(getContext()));
    this.sYF.setTextColor(z.fq(getContext()));
    AppMethodBeat.o(65627);
  }
  
  public final void restore()
  {
    AppMethodBeat.i(65626);
    this.kEu.setTextColor(getContext().getResources().getColor(2131100711));
    this.sYE.setTextColor(getContext().getResources().getColor(2131100711));
    this.sYF.setTextColor(getContext().getResources().getColor(2131100711));
    AppMethodBeat.o(65626);
  }
  
  public void setAmount(String paramString)
  {
    AppMethodBeat.i(65624);
    this.sYE.setText(paramString);
    AppMethodBeat.o(65624);
  }
  
  public void setGroupIconIv(int paramInt)
  {
    AppMethodBeat.i(65622);
    this.sZe.setImageResource(paramInt);
    AppMethodBeat.o(65622);
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(65617);
    this.sYE.setHint(paramString);
    AppMethodBeat.o(65617);
  }
  
  public void setMaxAmount(double paramDouble)
  {
    this.sYJ = paramDouble;
  }
  
  public void setMaxLen(int paramInt)
  {
    AppMethodBeat.i(65623);
    this.sYE.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
    AppMethodBeat.o(65623);
  }
  
  public void setMinAmount(double paramDouble)
  {
    this.sYK = paramDouble;
  }
  
  public void setOnInputValidChangerListener(g paramg)
  {
    this.sYH = paramg;
  }
  
  public void setShowGroupIcon(boolean paramBoolean)
  {
    AppMethodBeat.i(65621);
    if (paramBoolean)
    {
      this.sZe.setVisibility(0);
      AppMethodBeat.o(65621);
      return;
    }
    this.sZe.setVisibility(8);
    AppMethodBeat.o(65621);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(65620);
    this.kEu.setText(paramString);
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