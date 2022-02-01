package com.tencent.mm.plugin.luckymoney.appbrand.ui;

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
import com.tencent.mm.plugin.luckymoney.appbrand.a.h.a;
import com.tencent.mm.plugin.luckymoney.b.a;
import com.tencent.mm.plugin.luckymoney.model.j;
import com.tencent.mm.plugin.luckymoney.model.k;
import com.tencent.mm.plugin.luckymoney.model.z;
import com.tencent.mm.plugin.luckymoney.ui.c;
import com.tencent.mm.plugin.luckymoney.ui.g;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.ui.e;
import com.tenpay.android.wechat.TenpaySecureEditText;

public class WxaLuckyMoneyMoneyInputView
  extends LinearLayout
  implements c
{
  private TextWatcher awu;
  private TextView lCL;
  private TenpaySecureEditText vjC;
  private TextView vjD;
  private View vjE;
  private g vjF;
  private j vjG;
  private double vjH;
  private double vjI;
  public h.a vjJ;
  
  public WxaLuckyMoneyMoneyInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(64893);
    this.awu = new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(64891);
        if (WxaLuckyMoneyMoneyInputView.a(WxaLuckyMoneyMoneyInputView.this) != null)
        {
          paramAnonymousEditable = WxaLuckyMoneyMoneyInputView.a(WxaLuckyMoneyMoneyInputView.this);
          WxaLuckyMoneyMoneyInputView.this.getInputViewId();
          paramAnonymousEditable.dhR();
        }
        AppMethodBeat.o(64891);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    };
    a.dhH();
    this.vjG = a.dhI().dil();
    paramContext = LayoutInflater.from(paramContext).inflate(2131496118, this, true);
    this.vjC = ((TenpaySecureEditText)paramContext.findViewById(2131301810));
    this.vjC.addTextChangedListener(this.awu);
    this.lCL = ((TextView)paramContext.findViewById(2131301837));
    this.vjE = paramContext.findViewById(2131301836);
    this.vjD = ((TextView)paramContext.findViewById(2131301716));
    AppMethodBeat.o(64893);
  }
  
  public final String IZ(int paramInt)
  {
    AppMethodBeat.i(64903);
    a.dhH();
    this.vjG = a.dhI().dil();
    String str;
    if (paramInt == 1)
    {
      if (this.vjJ == h.a.vjl)
      {
        str = getContext().getString(2131760977, new Object[] { Math.round(this.vjH), bt.bI(this.vjG.vji, "") });
        AppMethodBeat.o(64903);
        return str;
      }
      str = getContext().getString(2131760826, new Object[] { Math.round(this.vjH), bt.bI(this.vjG.vji, "") });
      AppMethodBeat.o(64903);
      return str;
    }
    if (paramInt == 2)
    {
      str = getContext().getString(2131760828, new Object[] { e.C(this.vjI), bt.bI(this.vjG.vji, "") });
      AppMethodBeat.o(64903);
      return str;
    }
    AppMethodBeat.o(64903);
    return null;
  }
  
  public final int dhQ()
  {
    AppMethodBeat.i(64899);
    if (bt.isNullOrNil(this.vjC.getText().toString()))
    {
      AppMethodBeat.o(64899);
      return 0;
    }
    double d = bt.getDouble(this.vjC.getText().toString(), -1.0D);
    if (d < 0.0D)
    {
      AppMethodBeat.o(64899);
      return 3;
    }
    if ((d > this.vjH) && (this.vjH > 0.0D))
    {
      AppMethodBeat.o(64899);
      return 1;
    }
    if ((d < this.vjI) && (d > 0.0D))
    {
      AppMethodBeat.o(64899);
      return 2;
    }
    AppMethodBeat.o(64899);
    return 0;
  }
  
  public double getInput()
  {
    AppMethodBeat.i(64894);
    double d = bt.getDouble(this.vjC.getText().toString(), 0.0D);
    AppMethodBeat.o(64894);
    return d;
  }
  
  public int getInputViewId()
  {
    AppMethodBeat.i(64902);
    int i = getId();
    AppMethodBeat.o(64902);
    return i;
  }
  
  public final void onError()
  {
    AppMethodBeat.i(64901);
    this.lCL.setTextColor(z.fH(getContext()));
    this.vjC.setTextColor(z.fH(getContext()));
    this.vjD.setTextColor(z.fH(getContext()));
    AppMethodBeat.o(64901);
  }
  
  public final void restore()
  {
    AppMethodBeat.i(64900);
    this.lCL.setTextColor(getContext().getResources().getColor(2131100711));
    this.vjC.setTextColor(getContext().getResources().getColor(2131100711));
    this.vjD.setTextColor(getContext().getResources().getColor(2131100711));
    AppMethodBeat.o(64900);
  }
  
  public void setAmount(String paramString)
  {
    AppMethodBeat.i(64898);
    this.vjC.setText(paramString);
    AppMethodBeat.o(64898);
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(64892);
    this.vjC.setHint(paramString);
    AppMethodBeat.o(64892);
  }
  
  public void setMaxAmount(double paramDouble)
  {
    this.vjH = paramDouble;
  }
  
  public void setMaxLen(int paramInt)
  {
    AppMethodBeat.i(64897);
    this.vjC.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
    AppMethodBeat.o(64897);
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
    AppMethodBeat.i(64896);
    if (paramBoolean)
    {
      this.vjE.setVisibility(0);
      AppMethodBeat.o(64896);
      return;
    }
    this.vjE.setVisibility(8);
    AppMethodBeat.o(64896);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(64895);
    this.lCL.setText(paramString);
    AppMethodBeat.o(64895);
  }
  
  public void setType(h.a parama)
  {
    this.vjJ = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyMoneyInputView
 * JD-Core Version:    0.7.0.1
 */