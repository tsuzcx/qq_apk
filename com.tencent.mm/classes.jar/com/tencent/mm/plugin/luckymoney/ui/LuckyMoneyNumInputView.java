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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.app.a;
import com.tencent.mm.plugin.luckymoney.model.ag;
import com.tencent.mm.plugin.luckymoney.model.ah;
import com.tencent.mm.plugin.luckymoney.model.o;
import com.tencent.mm.plugin.luckymoney.model.p;
import com.tencent.mm.plugin.luckymoney.model.v;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Util;
import com.tenpay.android.wechat.TenpaySecureEditText;

public class LuckyMoneyNumInputView
  extends LinearLayout
  implements d
{
  private int KDn;
  private TenpaySecureEditText KFJ;
  private TextView KFK;
  private ImageView KFL;
  private int KFM;
  private int KFN;
  private int KFO;
  private int KFP;
  private h KmE;
  private o KmF;
  private TextView sUt;
  private TextWatcher vU;
  
  public LuckyMoneyNumInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(65767);
    this.KFM = 1;
    this.KFN = 2147483647;
    this.KFO = 1;
    this.KDn = 0;
    this.KFP = 0;
    this.vU = new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(65765);
        if (LuckyMoneyNumInputView.a(LuckyMoneyNumInputView.this) != null)
        {
          paramAnonymousEditable = LuckyMoneyNumInputView.a(LuckyMoneyNumInputView.this);
          LuckyMoneyNumInputView.this.getInputViewId();
          paramAnonymousEditable.fWx();
        }
        AppMethodBeat.o(65765);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    };
    paramContext = LayoutInflater.from(paramContext).inflate(a.g.lucky_money_num_input_view, this, true);
    this.sUt = ((TextView)paramContext.findViewById(a.f.lucky_money_num_input_title));
    this.KFJ = ((TenpaySecureEditText)paramContext.findViewById(a.f.lucky_money_et));
    this.KFK = ((TextView)paramContext.findViewById(a.f.lucky_money_num_unit));
    this.KFJ.setText(this.KFM);
    this.KFL = ((ImageView)paramContext.findViewById(a.f.lucky_money_money_num_icon));
    this.KFL.setVisibility(0);
    this.KFJ.addTextChangedListener(this.vU);
    AppMethodBeat.o(65767);
  }
  
  private boolean fYu()
  {
    AppMethodBeat.i(65775);
    if ((this.KmF != null) && (!Util.isNullOrNil(this.KmF.KrF)))
    {
      AppMethodBeat.o(65775);
      return true;
    }
    AppMethodBeat.o(65775);
    return false;
  }
  
  public final String ZF(int paramInt)
  {
    AppMethodBeat.i(65776);
    if (this.KDn == 1)
    {
      a.fWk();
      this.KmF = a.fWm().fWW();
    }
    String str;
    while (paramInt == 1) {
      if (fYu())
      {
        str = getContext().getString(a.i.lucky_money_num_max_limit_tips_format, new Object[] { Integer.valueOf(this.KFN), this.KmF.KrF });
        AppMethodBeat.o(65776);
        return str;
        if (this.KDn == 2)
        {
          a.fWk();
          this.KmF = a.fWn().fWW();
        }
        else
        {
          a.fWk();
          this.KmF = a.fWl().fWW();
        }
      }
      else
      {
        str = getContext().getString(a.i.lucky_money_num_max_limit_tips, new Object[] { Integer.valueOf(this.KFN) });
        AppMethodBeat.o(65776);
        return str;
      }
    }
    if (paramInt == 2)
    {
      if (fYu())
      {
        str = getContext().getString(a.i.lucky_money_num_luck_min_limit_tips_format, new Object[] { Integer.valueOf(this.KFO), this.KmF.KrF });
        AppMethodBeat.o(65776);
        return str;
      }
      str = getContext().getString(a.i.lucky_money_num_luck_min_limit_tips);
      AppMethodBeat.o(65776);
      return str;
    }
    if ((paramInt == 4) || (paramInt == 3))
    {
      str = getContext().getString(a.i.lucky_money_prepare_item_error_accessibility_text, new Object[] { this.sUt.getText() });
      AppMethodBeat.o(65776);
      return str;
    }
    if (paramInt == 5)
    {
      if (fYu())
      {
        str = getContext().getString(a.i.lucky_money_num_exceed_group_number_tips1, new Object[] { this.KmF.KrF });
        AppMethodBeat.o(65776);
        return str;
      }
      str = getContext().getString(a.i.lucky_money_num_exceed_group_number_tips);
      AppMethodBeat.o(65776);
      return str;
    }
    AppMethodBeat.o(65776);
    return null;
  }
  
  public final void atR()
  {
    AppMethodBeat.i(65773);
    this.sUt.setTextColor(ah.iM(getContext()));
    this.KFJ.setTextColor(ah.iM(getContext()));
    this.KFK.setTextColor(ah.iM(getContext()));
    AppMethodBeat.o(65773);
  }
  
  public final int fWv()
  {
    AppMethodBeat.i(65771);
    if (Util.isNullOrNil(this.KFJ.getText().toString()))
    {
      AppMethodBeat.o(65771);
      return 0;
    }
    int i = Util.getInt(this.KFJ.getText().toString(), -1);
    if (i < 0)
    {
      AppMethodBeat.o(65771);
      return 3;
    }
    if ((i > this.KFN) && (this.KFN > 0))
    {
      AppMethodBeat.o(65771);
      return 1;
    }
    if ((i > this.KFP) && (this.KFP > 0))
    {
      AppMethodBeat.o(65771);
      return 5;
    }
    if ((i < this.KFO) && (this.KFO > 0))
    {
      AppMethodBeat.o(65771);
      return 2;
    }
    AppMethodBeat.o(65771);
    return 0;
  }
  
  public final int fWw()
  {
    AppMethodBeat.i(284146);
    if (Util.isNullOrNil(this.KFJ.getText().toString()))
    {
      AppMethodBeat.o(284146);
      return 4;
    }
    int i = Util.getInt(this.KFJ.getText().toString(), -1);
    if (i <= 0)
    {
      AppMethodBeat.o(284146);
      return 3;
    }
    if ((i > this.KFN) && (this.KFN > 0))
    {
      AppMethodBeat.o(284146);
      return 1;
    }
    if ((i > this.KFP) && (this.KFP > 0))
    {
      AppMethodBeat.o(284146);
      return 5;
    }
    if ((i < this.KFO) && (this.KFO > 0))
    {
      AppMethodBeat.o(284146);
      return 2;
    }
    AppMethodBeat.o(284146);
    return 0;
  }
  
  public EditText getEditText()
  {
    return this.KFJ;
  }
  
  public int getInput()
  {
    AppMethodBeat.i(65769);
    try
    {
      int i = Integer.parseInt(this.KFJ.getText().toString(), 10);
      AppMethodBeat.o(65769);
      return i;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(65769);
    }
    return 0;
  }
  
  public int getInputViewId()
  {
    AppMethodBeat.i(65774);
    int i = getId();
    AppMethodBeat.o(65774);
    return i;
  }
  
  public final void restore()
  {
    AppMethodBeat.i(65772);
    this.sUt.setTextColor(getContext().getResources().getColor(a.c.normal_text_color));
    this.KFJ.setTextColor(getContext().getResources().getColor(a.c.normal_text_color));
    this.KFK.setTextColor(getContext().getResources().getColor(a.c.normal_text_color));
    AppMethodBeat.o(65772);
  }
  
  public void setGroupChatNumber(int paramInt)
  {
    this.KFP = paramInt;
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(65766);
    this.KFJ.setHint(paramString);
    AppMethodBeat.o(65766);
  }
  
  public void setMaxNum(int paramInt)
  {
    int j = 3;
    AppMethodBeat.i(65768);
    this.KFN = paramInt;
    int k = 0;
    int i = paramInt;
    paramInt = k;
    while (i > 0)
    {
      paramInt += 1;
      i /= 10;
    }
    if (paramInt <= 3) {
      paramInt = j;
    }
    for (;;)
    {
      this.KFJ.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
      AppMethodBeat.o(65768);
      return;
    }
  }
  
  public void setMinNum(int paramInt)
  {
    this.KFO = paramInt;
  }
  
  public void setNum(String paramString)
  {
    AppMethodBeat.i(65770);
    this.KFJ.setText(paramString);
    this.KFJ.setSelection(this.KFJ.getText().length());
    this.KFM = Util.getInt(paramString, 0);
    AppMethodBeat.o(65770);
  }
  
  public void setOnInputValidChangerListener(h paramh)
  {
    this.KmE = paramh;
  }
  
  public void setRtxLuckyMoney(int paramInt)
  {
    this.KDn = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNumInputView
 * JD-Core Version:    0.7.0.1
 */