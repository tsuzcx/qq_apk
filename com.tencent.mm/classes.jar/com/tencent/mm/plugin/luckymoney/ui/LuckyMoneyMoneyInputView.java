package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
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
import com.tencent.mm.plugin.luckymoney.model.i;
import com.tencent.mm.plugin.luckymoney.model.j;
import com.tencent.mm.plugin.luckymoney.model.x;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.e;
import com.tenpay.android.wechat.TenpaySecureEditText;

public class LuckyMoneyMoneyInputView
  extends LinearLayout
  implements c
{
  private TextWatcher ami;
  private TextView iJG;
  public int mType;
  private TenpaySecureEditText oiR;
  private TextView oiS;
  private g oiU;
  private i oiV;
  private double oiW;
  private double oiX;
  private ImageView ojr;
  
  public LuckyMoneyMoneyInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(42741);
    this.ami = new LuckyMoneyMoneyInputView.1(this);
    a.bMG();
    this.oiV = a.bMH().bNk();
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(2130970032, this, true);
    this.oiR = ((TenpaySecureEditText)paramAttributeSet.findViewById(2131825700));
    this.oiR.setTypeface(e.aD(paramContext, 3));
    this.oiR.addTextChangedListener(this.ami);
    this.iJG = ((TextView)paramAttributeSet.findViewById(2131825699));
    this.ojr = ((ImageView)paramAttributeSet.findViewById(2131825698));
    this.oiS = ((TextView)paramAttributeSet.findViewById(2131825701));
    AppMethodBeat.o(42741);
  }
  
  private boolean bOa()
  {
    AppMethodBeat.i(42752);
    if ((this.oiV != null) && (!bo.isNullOrNil(this.oiV.onn)))
    {
      AppMethodBeat.o(42752);
      return true;
    }
    AppMethodBeat.o(42752);
    return false;
  }
  
  public final int bMP()
  {
    AppMethodBeat.i(42748);
    if (bo.isNullOrNil(this.oiR.getText().toString()))
    {
      AppMethodBeat.o(42748);
      return 0;
    }
    double d = bo.getDouble(this.oiR.getText().toString(), -1.0D);
    if (d < 0.0D)
    {
      AppMethodBeat.o(42748);
      return 3;
    }
    if ((d > this.oiW) && (this.oiW > 0.0D))
    {
      AppMethodBeat.o(42748);
      return 1;
    }
    if ((d < this.oiX) && (d > 0.0D))
    {
      AppMethodBeat.o(42748);
      return 2;
    }
    AppMethodBeat.o(42748);
    return 0;
  }
  
  public double getInput()
  {
    AppMethodBeat.i(42742);
    double d = bo.getDouble(this.oiR.getText().toString(), 0.0D);
    AppMethodBeat.o(42742);
    return d;
  }
  
  public int getInputViewId()
  {
    AppMethodBeat.i(42751);
    int i = getId();
    AppMethodBeat.o(42751);
    return i;
  }
  
  public final void onError()
  {
    AppMethodBeat.i(42750);
    this.iJG.setTextColor(x.eu(getContext()));
    this.oiR.setTextColor(x.eu(getContext()));
    this.oiS.setTextColor(x.eu(getContext()));
    AppMethodBeat.o(42750);
  }
  
  public final void restore()
  {
    AppMethodBeat.i(42749);
    this.iJG.setTextColor(-16777216);
    this.oiR.setTextColor(-16777216);
    this.oiS.setTextColor(-16777216);
    AppMethodBeat.o(42749);
  }
  
  public void setAmount(String paramString)
  {
    AppMethodBeat.i(42747);
    this.oiR.setText(paramString);
    AppMethodBeat.o(42747);
  }
  
  public void setGroupIconIv(int paramInt)
  {
    AppMethodBeat.i(42745);
    this.ojr.setImageResource(paramInt);
    AppMethodBeat.o(42745);
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(42740);
    this.oiR.setHint(paramString);
    AppMethodBeat.o(42740);
  }
  
  public void setMaxAmount(double paramDouble)
  {
    this.oiW = paramDouble;
  }
  
  public void setMaxLen(int paramInt)
  {
    AppMethodBeat.i(42746);
    this.oiR.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
    AppMethodBeat.o(42746);
  }
  
  public void setMinAmount(double paramDouble)
  {
    this.oiX = paramDouble;
  }
  
  public void setOnInputValidChangerListener(g paramg)
  {
    this.oiU = paramg;
  }
  
  public void setShowGroupIcon(boolean paramBoolean)
  {
    AppMethodBeat.i(42744);
    if (paramBoolean)
    {
      this.ojr.setVisibility(0);
      AppMethodBeat.o(42744);
      return;
    }
    this.ojr.setVisibility(8);
    AppMethodBeat.o(42744);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(42743);
    this.iJG.setText(paramString);
    AppMethodBeat.o(42743);
  }
  
  public void setType(int paramInt)
  {
    this.mType = paramInt;
  }
  
  public final String yf(int paramInt)
  {
    AppMethodBeat.i(42753);
    a.bMG();
    this.oiV = a.bMH().bNk();
    String str;
    if (paramInt == 1)
    {
      if (this.mType == 1)
      {
        str = getContext().getString(2131301332, new Object[] { Math.round(this.oiW), bo.bf(this.oiV.oix, "") });
        AppMethodBeat.o(42753);
        return str;
      }
      if (bOa())
      {
        str = getContext().getString(2131301193, new Object[] { this.oiV.onn, Math.round(this.oiW), bo.bf(this.oiV.oix, "") });
        AppMethodBeat.o(42753);
        return str;
      }
      str = getContext().getString(2131301192, new Object[] { Math.round(this.oiW), bo.bf(this.oiV.oix, "") });
      AppMethodBeat.o(42753);
      return str;
    }
    if (paramInt == 2)
    {
      if (bOa())
      {
        str = getContext().getString(2131301195, new Object[] { this.oiV.onn, e.E(this.oiX), bo.bf(this.oiV.oix, "") });
        AppMethodBeat.o(42753);
        return str;
      }
      str = getContext().getString(2131301194, new Object[] { e.E(this.oiX), bo.bf(this.oiV.oix, "") });
      AppMethodBeat.o(42753);
      return str;
    }
    AppMethodBeat.o(42753);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMoneyInputView
 * JD-Core Version:    0.7.0.1
 */