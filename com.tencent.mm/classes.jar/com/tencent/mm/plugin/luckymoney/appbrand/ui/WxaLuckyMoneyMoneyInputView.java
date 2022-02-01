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
  private TextWatcher atH;
  private TextView kEu;
  private TenpaySecureEditText sYE;
  private TextView sYF;
  private View sYG;
  private g sYH;
  private j sYI;
  private double sYJ;
  private double sYK;
  public h.a sYL;
  
  public WxaLuckyMoneyMoneyInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(64893);
    this.atH = new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(64891);
        if (WxaLuckyMoneyMoneyInputView.a(WxaLuckyMoneyMoneyInputView.this) != null)
        {
          paramAnonymousEditable = WxaLuckyMoneyMoneyInputView.a(WxaLuckyMoneyMoneyInputView.this);
          WxaLuckyMoneyMoneyInputView.this.getInputViewId();
          paramAnonymousEditable.cKZ();
        }
        AppMethodBeat.o(64891);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    };
    a.cKP();
    this.sYI = a.cKQ().cLt();
    paramContext = LayoutInflater.from(paramContext).inflate(2131496118, this, true);
    this.sYE = ((TenpaySecureEditText)paramContext.findViewById(2131301810));
    this.sYE.addTextChangedListener(this.atH);
    this.kEu = ((TextView)paramContext.findViewById(2131301837));
    this.sYG = paramContext.findViewById(2131301836);
    this.sYF = ((TextView)paramContext.findViewById(2131301716));
    AppMethodBeat.o(64893);
  }
  
  public final String FI(int paramInt)
  {
    AppMethodBeat.i(64903);
    a.cKP();
    this.sYI = a.cKQ().cLt();
    String str;
    if (paramInt == 1)
    {
      if (this.sYL == h.a.sYn)
      {
        str = getContext().getString(2131760977, new Object[] { Math.round(this.sYJ), bt.by(this.sYI.sYk, "") });
        AppMethodBeat.o(64903);
        return str;
      }
      str = getContext().getString(2131760826, new Object[] { Math.round(this.sYJ), bt.by(this.sYI.sYk, "") });
      AppMethodBeat.o(64903);
      return str;
    }
    if (paramInt == 2)
    {
      str = getContext().getString(2131760828, new Object[] { e.D(this.sYK), bt.by(this.sYI.sYk, "") });
      AppMethodBeat.o(64903);
      return str;
    }
    AppMethodBeat.o(64903);
    return null;
  }
  
  public final int cKY()
  {
    AppMethodBeat.i(64899);
    if (bt.isNullOrNil(this.sYE.getText().toString()))
    {
      AppMethodBeat.o(64899);
      return 0;
    }
    double d = bt.getDouble(this.sYE.getText().toString(), -1.0D);
    if (d < 0.0D)
    {
      AppMethodBeat.o(64899);
      return 3;
    }
    if ((d > this.sYJ) && (this.sYJ > 0.0D))
    {
      AppMethodBeat.o(64899);
      return 1;
    }
    if ((d < this.sYK) && (d > 0.0D))
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
    double d = bt.getDouble(this.sYE.getText().toString(), 0.0D);
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
    this.kEu.setTextColor(z.fq(getContext()));
    this.sYE.setTextColor(z.fq(getContext()));
    this.sYF.setTextColor(z.fq(getContext()));
    AppMethodBeat.o(64901);
  }
  
  public final void restore()
  {
    AppMethodBeat.i(64900);
    this.kEu.setTextColor(getContext().getResources().getColor(2131100711));
    this.sYE.setTextColor(getContext().getResources().getColor(2131100711));
    this.sYF.setTextColor(getContext().getResources().getColor(2131100711));
    AppMethodBeat.o(64900);
  }
  
  public void setAmount(String paramString)
  {
    AppMethodBeat.i(64898);
    this.sYE.setText(paramString);
    AppMethodBeat.o(64898);
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(64892);
    this.sYE.setHint(paramString);
    AppMethodBeat.o(64892);
  }
  
  public void setMaxAmount(double paramDouble)
  {
    this.sYJ = paramDouble;
  }
  
  public void setMaxLen(int paramInt)
  {
    AppMethodBeat.i(64897);
    this.sYE.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
    AppMethodBeat.o(64897);
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
    AppMethodBeat.i(64896);
    if (paramBoolean)
    {
      this.sYG.setVisibility(0);
      AppMethodBeat.o(64896);
      return;
    }
    this.sYG.setVisibility(8);
    AppMethodBeat.o(64896);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(64895);
    this.kEu.setText(paramString);
    AppMethodBeat.o(64895);
  }
  
  public void setType(h.a parama)
  {
    this.sYL = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyMoneyInputView
 * JD-Core Version:    0.7.0.1
 */