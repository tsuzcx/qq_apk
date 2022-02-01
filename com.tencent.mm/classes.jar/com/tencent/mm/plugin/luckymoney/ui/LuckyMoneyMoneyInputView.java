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
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.wallet_core.ui.f;
import com.tenpay.android.wechat.TenpaySecureEditText;

public class LuckyMoneyMoneyInputView
  extends LinearLayout
  implements c
{
  private TextWatcher awu;
  private TextView lHk;
  public int mType;
  private TenpaySecureEditText vvH;
  private TextView vvI;
  private g vvK;
  private j vvL;
  private double vvM;
  private double vvN;
  private ImageView vwh;
  
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
          paramAnonymousEditable.dkQ();
        }
        AppMethodBeat.o(65616);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    };
    a.dkG();
    this.vvL = a.dkH().dlk();
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(2131494646, this, true);
    this.vvH = ((TenpaySecureEditText)paramAttributeSet.findViewById(2131301810));
    this.vvH.setTypeface(f.aR(paramContext, 3));
    this.vvH.addTextChangedListener(this.awu);
    this.lHk = ((TextView)paramAttributeSet.findViewById(2131301837));
    this.vwh = ((ImageView)paramAttributeSet.findViewById(2131301836));
    this.vvI = ((TextView)paramAttributeSet.findViewById(2131301716));
    AppMethodBeat.o(65618);
  }
  
  private boolean dmq()
  {
    AppMethodBeat.i(65629);
    if ((this.vvL != null) && (!bu.isNullOrNil(this.vvL.vAd)))
    {
      AppMethodBeat.o(65629);
      return true;
    }
    AppMethodBeat.o(65629);
    return false;
  }
  
  public final String Jy(int paramInt)
  {
    AppMethodBeat.i(65630);
    a.dkG();
    this.vvL = a.dkH().dlk();
    String str;
    if (paramInt == 1)
    {
      if (this.mType == 1)
      {
        str = getContext().getString(2131760977, new Object[] { Math.round(this.vvM), bu.bI(this.vvL.vvn, "") });
        AppMethodBeat.o(65630);
        return str;
      }
      if (dmq())
      {
        str = getContext().getString(2131760827, new Object[] { this.vvL.vAd, Math.round(this.vvM), bu.bI(this.vvL.vvn, "") });
        AppMethodBeat.o(65630);
        return str;
      }
      str = getContext().getString(2131760826, new Object[] { Math.round(this.vvM), bu.bI(this.vvL.vvn, "") });
      AppMethodBeat.o(65630);
      return str;
    }
    if (paramInt == 2)
    {
      if (dmq())
      {
        str = getContext().getString(2131760829, new Object[] { this.vvL.vAd, f.C(this.vvN), bu.bI(this.vvL.vvn, "") });
        AppMethodBeat.o(65630);
        return str;
      }
      str = getContext().getString(2131760828, new Object[] { f.C(this.vvN), bu.bI(this.vvL.vvn, "") });
      AppMethodBeat.o(65630);
      return str;
    }
    AppMethodBeat.o(65630);
    return null;
  }
  
  public final int dkP()
  {
    AppMethodBeat.i(65625);
    if (bu.isNullOrNil(this.vvH.getText().toString()))
    {
      AppMethodBeat.o(65625);
      return 0;
    }
    double d = bu.getDouble(this.vvH.getText().toString(), -1.0D);
    if (d < 0.0D)
    {
      AppMethodBeat.o(65625);
      return 3;
    }
    if ((d > this.vvM) && (this.vvM > 0.0D))
    {
      AppMethodBeat.o(65625);
      return 1;
    }
    if ((d < this.vvN) && (d > 0.0D))
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
    double d = bu.getDouble(this.vvH.getText().toString(), 0.0D);
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
    this.lHk.setTextColor(z.fN(getContext()));
    this.vvH.setTextColor(z.fN(getContext()));
    this.vvI.setTextColor(z.fN(getContext()));
    AppMethodBeat.o(65627);
  }
  
  public final void restore()
  {
    AppMethodBeat.i(65626);
    this.lHk.setTextColor(getContext().getResources().getColor(2131100711));
    this.vvH.setTextColor(getContext().getResources().getColor(2131100711));
    this.vvI.setTextColor(getContext().getResources().getColor(2131100711));
    AppMethodBeat.o(65626);
  }
  
  public void setAmount(String paramString)
  {
    AppMethodBeat.i(65624);
    this.vvH.setText(paramString);
    AppMethodBeat.o(65624);
  }
  
  public void setGroupIconIv(int paramInt)
  {
    AppMethodBeat.i(65622);
    this.vwh.setImageResource(paramInt);
    AppMethodBeat.o(65622);
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(65617);
    this.vvH.setHint(paramString);
    AppMethodBeat.o(65617);
  }
  
  public void setMaxAmount(double paramDouble)
  {
    this.vvM = paramDouble;
  }
  
  public void setMaxLen(int paramInt)
  {
    AppMethodBeat.i(65623);
    this.vvH.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
    AppMethodBeat.o(65623);
  }
  
  public void setMinAmount(double paramDouble)
  {
    this.vvN = paramDouble;
  }
  
  public void setOnInputValidChangerListener(g paramg)
  {
    this.vvK = paramg;
  }
  
  public void setShowGroupIcon(boolean paramBoolean)
  {
    AppMethodBeat.i(65621);
    if (paramBoolean)
    {
      this.vwh.setVisibility(0);
      AppMethodBeat.o(65621);
      return;
    }
    this.vwh.setVisibility(8);
    AppMethodBeat.o(65621);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(65620);
    this.lHk.setText(paramString);
    AppMethodBeat.o(65620);
  }
  
  public void setType(int paramInt)
  {
    this.mType = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMoneyInputView
 * JD-Core Version:    0.7.0.1
 */