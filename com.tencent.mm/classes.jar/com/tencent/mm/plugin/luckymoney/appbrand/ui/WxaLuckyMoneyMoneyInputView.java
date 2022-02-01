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
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.plugin.luckymoney.model.o;
import com.tencent.mm.plugin.luckymoney.model.p;
import com.tencent.mm.plugin.luckymoney.ui.d;
import com.tencent.mm.plugin.luckymoney.ui.h;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.f;
import com.tenpay.android.wechat.TenpaySecureEditText;

public class WxaLuckyMoneyMoneyInputView
  extends LinearLayout
  implements d
{
  private TextWatcher aws;
  private TextView mPa;
  private TenpaySecureEditText yPV;
  private TextView yPW;
  private View yPX;
  private h yPY;
  private o yPZ;
  private double yQa;
  private double yQb;
  public h.a yQc;
  
  public WxaLuckyMoneyMoneyInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(64893);
    this.aws = new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(64891);
        if (WxaLuckyMoneyMoneyInputView.a(WxaLuckyMoneyMoneyInputView.this) != null)
        {
          paramAnonymousEditable = WxaLuckyMoneyMoneyInputView.a(WxaLuckyMoneyMoneyInputView.this);
          WxaLuckyMoneyMoneyInputView.this.getInputViewId();
          paramAnonymousEditable.eeI();
        }
        AppMethodBeat.o(64891);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    };
    a.eex();
    this.yPZ = a.eey().efe();
    paramContext = LayoutInflater.from(paramContext).inflate(2131497112, this, true);
    this.yPV = ((TenpaySecureEditText)paramContext.findViewById(2131304116));
    this.yPV.addTextChangedListener(this.aws);
    this.mPa = ((TextView)paramContext.findViewById(2131304155));
    this.yPX = paramContext.findViewById(2131304154);
    this.yPW = ((TextView)paramContext.findViewById(2131304016));
    AppMethodBeat.o(64893);
  }
  
  public final String PA(int paramInt)
  {
    AppMethodBeat.i(64903);
    a.eex();
    this.yPZ = a.eey().efe();
    String str;
    if (paramInt == 1)
    {
      if (this.yQc == h.a.yPE)
      {
        str = getContext().getString(2131762752, new Object[] { Math.round(this.yQa), Util.nullAs(this.yPZ.yPB, "") });
        AppMethodBeat.o(64903);
        return str;
      }
      str = getContext().getString(2131762580, new Object[] { Math.round(this.yQa), Util.nullAs(this.yPZ.yPB, "") });
      AppMethodBeat.o(64903);
      return str;
    }
    if (paramInt == 2)
    {
      str = getContext().getString(2131762582, new Object[] { f.formatMoney2f(this.yQb), Util.nullAs(this.yPZ.yPB, "") });
      AppMethodBeat.o(64903);
      return str;
    }
    AppMethodBeat.o(64903);
    return null;
  }
  
  public final int eeH()
  {
    AppMethodBeat.i(64899);
    if (Util.isNullOrNil(this.yPV.getText().toString()))
    {
      AppMethodBeat.o(64899);
      return 0;
    }
    double d = Util.getDouble(this.yPV.getText().toString(), -1.0D);
    if (d < 0.0D)
    {
      AppMethodBeat.o(64899);
      return 3;
    }
    if ((d > this.yQa) && (this.yQa > 0.0D))
    {
      AppMethodBeat.o(64899);
      return 1;
    }
    if ((d < this.yQb) && (d > 0.0D))
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
    double d = Util.getDouble(this.yPV.getText().toString(), 0.0D);
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
    this.mPa.setTextColor(af.gt(getContext()));
    this.yPV.setTextColor(af.gt(getContext()));
    this.yPW.setTextColor(af.gt(getContext()));
    AppMethodBeat.o(64901);
  }
  
  public final void restore()
  {
    AppMethodBeat.i(64900);
    this.mPa.setTextColor(getContext().getResources().getColor(2131100904));
    this.yPV.setTextColor(getContext().getResources().getColor(2131100904));
    this.yPW.setTextColor(getContext().getResources().getColor(2131100904));
    AppMethodBeat.o(64900);
  }
  
  public void setAmount(String paramString)
  {
    AppMethodBeat.i(64898);
    this.yPV.setText(paramString);
    AppMethodBeat.o(64898);
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(64892);
    this.yPV.setHint(paramString);
    AppMethodBeat.o(64892);
  }
  
  public void setMaxAmount(double paramDouble)
  {
    this.yQa = paramDouble;
  }
  
  public void setMaxLen(int paramInt)
  {
    AppMethodBeat.i(64897);
    this.yPV.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
    AppMethodBeat.o(64897);
  }
  
  public void setMinAmount(double paramDouble)
  {
    this.yQb = paramDouble;
  }
  
  public void setOnInputValidChangerListener(h paramh)
  {
    this.yPY = paramh;
  }
  
  public void setShowGroupIcon(boolean paramBoolean)
  {
    AppMethodBeat.i(64896);
    if (paramBoolean)
    {
      this.yPX.setVisibility(0);
      AppMethodBeat.o(64896);
      return;
    }
    this.yPX.setVisibility(8);
    AppMethodBeat.o(64896);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(64895);
    this.mPa.setText(paramString);
    AppMethodBeat.o(64895);
  }
  
  public void setType(h.a parama)
  {
    this.yQc = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyMoneyInputView
 * JD-Core Version:    0.7.0.1
 */