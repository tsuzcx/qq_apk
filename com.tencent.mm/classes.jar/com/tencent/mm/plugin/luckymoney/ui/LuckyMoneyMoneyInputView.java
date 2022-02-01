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
import com.tencent.mm.plugin.luckymoney.model.ae;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.plugin.luckymoney.model.o;
import com.tencent.mm.plugin.luckymoney.model.p;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.f;
import com.tenpay.android.wechat.TenpaySecureEditText;

public class LuckyMoneyMoneyInputView
  extends LinearLayout
  implements d
{
  private TextWatcher aws;
  private TextView mPa;
  public int mType;
  private TenpaySecureEditText yPV;
  private TextView yPW;
  private h yPY;
  private o yPZ;
  private double yQa;
  private double yQb;
  private ImageView yQv;
  private boolean zeD;
  
  public LuckyMoneyMoneyInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(65618);
    this.zeD = false;
    this.aws = new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(65616);
        if (LuckyMoneyMoneyInputView.a(LuckyMoneyMoneyInputView.this) != null)
        {
          paramAnonymousEditable = LuckyMoneyMoneyInputView.a(LuckyMoneyMoneyInputView.this);
          LuckyMoneyMoneyInputView.this.getInputViewId();
          paramAnonymousEditable.eeI();
        }
        AppMethodBeat.o(65616);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    };
    if (this.zeD) {
      a.eex();
    }
    for (this.yPZ = a.eez().efe();; this.yPZ = a.eey().efe())
    {
      paramAttributeSet = LayoutInflater.from(paramContext).inflate(2131495369, this, true);
      this.yPV = ((TenpaySecureEditText)paramAttributeSet.findViewById(2131304116));
      this.yPV.setTypeface(f.aS(paramContext, 3));
      this.yPV.addTextChangedListener(this.aws);
      this.mPa = ((TextView)paramAttributeSet.findViewById(2131304155));
      this.yQv = ((ImageView)paramAttributeSet.findViewById(2131304154));
      this.yPW = ((TextView)paramAttributeSet.findViewById(2131304016));
      AppMethodBeat.o(65618);
      return;
      a.eex();
    }
  }
  
  private boolean egl()
  {
    AppMethodBeat.i(65629);
    if ((this.yPZ != null) && (!Util.isNullOrNil(this.yPZ.yUV)))
    {
      AppMethodBeat.o(65629);
      return true;
    }
    AppMethodBeat.o(65629);
    return false;
  }
  
  public final String PA(int paramInt)
  {
    AppMethodBeat.i(65630);
    if (this.zeD)
    {
      a.eex();
      this.yPZ = a.eez().efe();
    }
    String str;
    while (paramInt == 1) {
      if (this.mType == 1)
      {
        str = getContext().getString(2131762752, new Object[] { Math.round(this.yQa), Util.nullAs(this.yPZ.yPB, "") });
        AppMethodBeat.o(65630);
        return str;
        a.eex();
        this.yPZ = a.eey().efe();
      }
      else
      {
        if (egl())
        {
          str = getContext().getString(2131762581, new Object[] { this.yPZ.yUV, Math.round(this.yQa), Util.nullAs(this.yPZ.yPB, "") });
          AppMethodBeat.o(65630);
          return str;
        }
        str = getContext().getString(2131762580, new Object[] { Math.round(this.yQa), Util.nullAs(this.yPZ.yPB, "") });
        AppMethodBeat.o(65630);
        return str;
      }
    }
    if (paramInt == 2)
    {
      if (egl())
      {
        str = getContext().getString(2131762583, new Object[] { this.yPZ.yUV, f.formatMoney2f(this.yQb), Util.nullAs(this.yPZ.yPB, "") });
        AppMethodBeat.o(65630);
        return str;
      }
      str = getContext().getString(2131762582, new Object[] { f.formatMoney2f(this.yQb), Util.nullAs(this.yPZ.yPB, "") });
      AppMethodBeat.o(65630);
      return str;
    }
    AppMethodBeat.o(65630);
    return null;
  }
  
  public final int eeH()
  {
    AppMethodBeat.i(65625);
    if (Util.isNullOrNil(this.yPV.getText().toString()))
    {
      AppMethodBeat.o(65625);
      return 0;
    }
    double d = Util.getDouble(this.yPV.getText().toString(), -1.0D);
    if (d < 0.0D)
    {
      AppMethodBeat.o(65625);
      return 3;
    }
    if ((d > this.yQa) && (this.yQa > 0.0D))
    {
      AppMethodBeat.o(65625);
      return 1;
    }
    if ((d < this.yQb) && (d > 0.0D))
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
    double d = Util.getDouble(this.yPV.getText().toString(), 0.0D);
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
    this.mPa.setTextColor(af.gt(getContext()));
    this.yPV.setTextColor(af.gt(getContext()));
    this.yPW.setTextColor(af.gt(getContext()));
    AppMethodBeat.o(65627);
  }
  
  public final void restore()
  {
    AppMethodBeat.i(65626);
    this.mPa.setTextColor(getContext().getResources().getColor(2131100904));
    this.yPV.setTextColor(getContext().getResources().getColor(2131100904));
    this.yPW.setTextColor(getContext().getResources().getColor(2131100904));
    AppMethodBeat.o(65626);
  }
  
  public void setAmount(String paramString)
  {
    AppMethodBeat.i(65624);
    this.yPV.setText(paramString);
    this.yPV.setSelection(paramString.length());
    AppMethodBeat.o(65624);
  }
  
  public void setGroupIconIv(int paramInt)
  {
    AppMethodBeat.i(65622);
    this.yQv.setImageResource(paramInt);
    AppMethodBeat.o(65622);
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(65617);
    this.yPV.setHint(paramString);
    AppMethodBeat.o(65617);
  }
  
  public void setMaxAmount(double paramDouble)
  {
    this.yQa = paramDouble;
  }
  
  public void setMaxLen(int paramInt)
  {
    AppMethodBeat.i(65623);
    this.yPV.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
    AppMethodBeat.o(65623);
  }
  
  public void setMinAmount(double paramDouble)
  {
    this.yQb = paramDouble;
  }
  
  public void setOnInputValidChangerListener(h paramh)
  {
    this.yPY = paramh;
  }
  
  public void setRtxLuckyMoney(boolean paramBoolean)
  {
    this.zeD = paramBoolean;
  }
  
  public void setShowGroupIcon(boolean paramBoolean)
  {
    AppMethodBeat.i(65621);
    if (paramBoolean)
    {
      this.yQv.setVisibility(0);
      AppMethodBeat.o(65621);
      return;
    }
    this.yQv.setVisibility(8);
    AppMethodBeat.o(65621);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(65620);
    this.mPa.setText(paramString);
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