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
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.wallet_core.ui.e;
import com.tenpay.android.wechat.TenpaySecureEditText;

public class WxaLuckyMoneyMoneyInputView
  extends LinearLayout
  implements c
{
  private TextWatcher auC;
  private TextView lfN;
  private TenpaySecureEditText ugS;
  private TextView ugT;
  private View ugU;
  private g ugV;
  private j ugW;
  private double ugX;
  private double ugY;
  public h.a ugZ;
  
  public WxaLuckyMoneyMoneyInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(64893);
    this.auC = new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(64891);
        if (WxaLuckyMoneyMoneyInputView.a(WxaLuckyMoneyMoneyInputView.this) != null)
        {
          paramAnonymousEditable = WxaLuckyMoneyMoneyInputView.a(WxaLuckyMoneyMoneyInputView.this);
          WxaLuckyMoneyMoneyInputView.this.getInputViewId();
          paramAnonymousEditable.cYF();
        }
        AppMethodBeat.o(64891);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    };
    a.cYv();
    this.ugW = a.cYw().cYZ();
    paramContext = LayoutInflater.from(paramContext).inflate(2131496118, this, true);
    this.ugS = ((TenpaySecureEditText)paramContext.findViewById(2131301810));
    this.ugS.addTextChangedListener(this.auC);
    this.lfN = ((TextView)paramContext.findViewById(2131301837));
    this.ugU = paramContext.findViewById(2131301836);
    this.ugT = ((TextView)paramContext.findViewById(2131301716));
    AppMethodBeat.o(64893);
  }
  
  public final String HD(int paramInt)
  {
    AppMethodBeat.i(64903);
    a.cYv();
    this.ugW = a.cYw().cYZ();
    String str;
    if (paramInt == 1)
    {
      if (this.ugZ == h.a.ugB)
      {
        str = getContext().getString(2131760977, new Object[] { Math.round(this.ugX), bs.bG(this.ugW.ugy, "") });
        AppMethodBeat.o(64903);
        return str;
      }
      str = getContext().getString(2131760826, new Object[] { Math.round(this.ugX), bs.bG(this.ugW.ugy, "") });
      AppMethodBeat.o(64903);
      return str;
    }
    if (paramInt == 2)
    {
      str = getContext().getString(2131760828, new Object[] { e.C(this.ugY), bs.bG(this.ugW.ugy, "") });
      AppMethodBeat.o(64903);
      return str;
    }
    AppMethodBeat.o(64903);
    return null;
  }
  
  public final int cYE()
  {
    AppMethodBeat.i(64899);
    if (bs.isNullOrNil(this.ugS.getText().toString()))
    {
      AppMethodBeat.o(64899);
      return 0;
    }
    double d = bs.getDouble(this.ugS.getText().toString(), -1.0D);
    if (d < 0.0D)
    {
      AppMethodBeat.o(64899);
      return 3;
    }
    if ((d > this.ugX) && (this.ugX > 0.0D))
    {
      AppMethodBeat.o(64899);
      return 1;
    }
    if ((d < this.ugY) && (d > 0.0D))
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
    double d = bs.getDouble(this.ugS.getText().toString(), 0.0D);
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
    this.lfN.setTextColor(z.fC(getContext()));
    this.ugS.setTextColor(z.fC(getContext()));
    this.ugT.setTextColor(z.fC(getContext()));
    AppMethodBeat.o(64901);
  }
  
  public final void restore()
  {
    AppMethodBeat.i(64900);
    this.lfN.setTextColor(getContext().getResources().getColor(2131100711));
    this.ugS.setTextColor(getContext().getResources().getColor(2131100711));
    this.ugT.setTextColor(getContext().getResources().getColor(2131100711));
    AppMethodBeat.o(64900);
  }
  
  public void setAmount(String paramString)
  {
    AppMethodBeat.i(64898);
    this.ugS.setText(paramString);
    AppMethodBeat.o(64898);
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(64892);
    this.ugS.setHint(paramString);
    AppMethodBeat.o(64892);
  }
  
  public void setMaxAmount(double paramDouble)
  {
    this.ugX = paramDouble;
  }
  
  public void setMaxLen(int paramInt)
  {
    AppMethodBeat.i(64897);
    this.ugS.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
    AppMethodBeat.o(64897);
  }
  
  public void setMinAmount(double paramDouble)
  {
    this.ugY = paramDouble;
  }
  
  public void setOnInputValidChangerListener(g paramg)
  {
    this.ugV = paramg;
  }
  
  public void setShowGroupIcon(boolean paramBoolean)
  {
    AppMethodBeat.i(64896);
    if (paramBoolean)
    {
      this.ugU.setVisibility(0);
      AppMethodBeat.o(64896);
      return;
    }
    this.ugU.setVisibility(8);
    AppMethodBeat.o(64896);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(64895);
    this.lfN.setText(paramString);
    AppMethodBeat.o(64895);
  }
  
  public void setType(h.a parama)
  {
    this.ugZ = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyMoneyInputView
 * JD-Core Version:    0.7.0.1
 */