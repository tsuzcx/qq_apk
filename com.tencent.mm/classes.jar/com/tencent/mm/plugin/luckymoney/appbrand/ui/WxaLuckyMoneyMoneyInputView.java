package com.tencent.mm.plugin.luckymoney.appbrand.ui;

import android.content.Context;
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
import com.tencent.mm.plugin.luckymoney.model.i;
import com.tencent.mm.plugin.luckymoney.model.j;
import com.tencent.mm.plugin.luckymoney.model.x;
import com.tencent.mm.plugin.luckymoney.ui.c;
import com.tencent.mm.plugin.luckymoney.ui.g;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.e;
import com.tenpay.android.wechat.TenpaySecureEditText;

public class WxaLuckyMoneyMoneyInputView
  extends LinearLayout
  implements c
{
  private TextWatcher ami;
  private TextView iJG;
  private TenpaySecureEditText oiR;
  private TextView oiS;
  private View oiT;
  private g oiU;
  private i oiV;
  private double oiW;
  private double oiX;
  public h.a oiY;
  
  public WxaLuckyMoneyMoneyInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(42005);
    this.ami = new WxaLuckyMoneyMoneyInputView.1(this);
    a.bMG();
    this.oiV = a.bMH().bNk();
    paramContext = LayoutInflater.from(paramContext).inflate(2130971335, this, true);
    this.oiR = ((TenpaySecureEditText)paramContext.findViewById(2131825700));
    this.oiR.addTextChangedListener(this.ami);
    this.iJG = ((TextView)paramContext.findViewById(2131825699));
    this.oiT = paramContext.findViewById(2131825698);
    this.oiS = ((TextView)paramContext.findViewById(2131825701));
    AppMethodBeat.o(42005);
  }
  
  public final int bMP()
  {
    AppMethodBeat.i(42011);
    if (bo.isNullOrNil(this.oiR.getText().toString()))
    {
      AppMethodBeat.o(42011);
      return 0;
    }
    double d = bo.getDouble(this.oiR.getText().toString(), -1.0D);
    if (d < 0.0D)
    {
      AppMethodBeat.o(42011);
      return 3;
    }
    if ((d > this.oiW) && (this.oiW > 0.0D))
    {
      AppMethodBeat.o(42011);
      return 1;
    }
    if ((d < this.oiX) && (d > 0.0D))
    {
      AppMethodBeat.o(42011);
      return 2;
    }
    AppMethodBeat.o(42011);
    return 0;
  }
  
  public double getInput()
  {
    AppMethodBeat.i(42006);
    double d = bo.getDouble(this.oiR.getText().toString(), 0.0D);
    AppMethodBeat.o(42006);
    return d;
  }
  
  public int getInputViewId()
  {
    AppMethodBeat.i(42014);
    int i = getId();
    AppMethodBeat.o(42014);
    return i;
  }
  
  public final void onError()
  {
    AppMethodBeat.i(42013);
    this.iJG.setTextColor(x.eu(getContext()));
    this.oiR.setTextColor(x.eu(getContext()));
    this.oiS.setTextColor(x.eu(getContext()));
    AppMethodBeat.o(42013);
  }
  
  public final void restore()
  {
    AppMethodBeat.i(42012);
    this.iJG.setTextColor(-16777216);
    this.oiR.setTextColor(-16777216);
    this.oiS.setTextColor(-16777216);
    AppMethodBeat.o(42012);
  }
  
  public void setAmount(String paramString)
  {
    AppMethodBeat.i(42010);
    this.oiR.setText(paramString);
    AppMethodBeat.o(42010);
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(42004);
    this.oiR.setHint(paramString);
    AppMethodBeat.o(42004);
  }
  
  public void setMaxAmount(double paramDouble)
  {
    this.oiW = paramDouble;
  }
  
  public void setMaxLen(int paramInt)
  {
    AppMethodBeat.i(42009);
    this.oiR.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
    AppMethodBeat.o(42009);
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
    AppMethodBeat.i(42008);
    if (paramBoolean)
    {
      this.oiT.setVisibility(0);
      AppMethodBeat.o(42008);
      return;
    }
    this.oiT.setVisibility(8);
    AppMethodBeat.o(42008);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(42007);
    this.iJG.setText(paramString);
    AppMethodBeat.o(42007);
  }
  
  public void setType(h.a parama)
  {
    this.oiY = parama;
  }
  
  public final String yf(int paramInt)
  {
    AppMethodBeat.i(42015);
    a.bMG();
    this.oiV = a.bMH().bNk();
    String str;
    if (paramInt == 1)
    {
      if (this.oiY == h.a.oiA)
      {
        str = getContext().getString(2131301332, new Object[] { Math.round(this.oiW), bo.bf(this.oiV.oix, "") });
        AppMethodBeat.o(42015);
        return str;
      }
      str = getContext().getString(2131301192, new Object[] { Math.round(this.oiW), bo.bf(this.oiV.oix, "") });
      AppMethodBeat.o(42015);
      return str;
    }
    if (paramInt == 2)
    {
      str = getContext().getString(2131301194, new Object[] { e.E(this.oiX), bo.bf(this.oiV.oix, "") });
      AppMethodBeat.o(42015);
      return str;
    }
    AppMethodBeat.o(42015);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyMoneyInputView
 * JD-Core Version:    0.7.0.1
 */