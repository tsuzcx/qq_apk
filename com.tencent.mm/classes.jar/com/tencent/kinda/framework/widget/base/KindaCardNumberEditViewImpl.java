package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import com.tencent.kinda.gen.KCardNumberEditView;
import com.tencent.kinda.gen.KCardNumberEditViewOnTextChangedCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.b;
import com.tenpay.android.wechat.TenpaySecureEditText;

public class KindaCardNumberEditViewImpl
  extends MMKView<TenpaySecureEditText>
  implements KCardNumberEditView
{
  private TenpaySecureEditText cardNumberView = null;
  private KCardNumberEditViewOnTextChangedCallback m_callback;
  
  public TenpaySecureEditText createView(Context paramContext)
  {
    AppMethodBeat.i(144740);
    this.cardNumberView = new TenpaySecureEditText(paramContext);
    this.cardNumberView.setIsBankcardFormat(true);
    this.cardNumberView.setBackground(null);
    this.cardNumberView.setSingleLine();
    this.cardNumberView.setClearBtnDrawableId(2130839272);
    this.cardNumberView.addTextChangedListener(new KindaCardNumberEditViewImpl.1(this));
    if ((paramContext instanceof BaseFrActivity)) {
      ((BaseFrActivity)paramContext).setEditFocusListener(this.cardNumberView, 0, false);
    }
    paramContext = this.cardNumberView;
    AppMethodBeat.o(144740);
    return paramContext;
  }
  
  public boolean getFocus()
  {
    AppMethodBeat.i(144744);
    boolean bool = this.cardNumberView.isFocused();
    AppMethodBeat.o(144744);
    return bool;
  }
  
  public String getHint()
  {
    AppMethodBeat.i(144746);
    String str = this.cardNumberView.getHint().toString();
    AppMethodBeat.o(144746);
    return str;
  }
  
  public long getHintColor()
  {
    AppMethodBeat.i(144748);
    long l = this.cardNumberView.getCurrentHintTextColor();
    AppMethodBeat.o(144748);
    return l;
  }
  
  public String getValue()
  {
    AppMethodBeat.i(144741);
    Object localObject = this.cardNumberView;
    b.dRI();
    localObject = ((TenpaySecureEditText)localObject).getEncryptDataWithHash(false, b.dRJ());
    AppMethodBeat.o(144741);
    return localObject;
  }
  
  public boolean isBankCardNumber()
  {
    AppMethodBeat.i(144742);
    boolean bool = this.cardNumberView.isBankcardNum();
    AppMethodBeat.o(144742);
    return bool;
  }
  
  public void setFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(144743);
    if (paramBoolean)
    {
      this.cardNumberView.requestFocus();
      AppMethodBeat.o(144743);
      return;
    }
    this.cardNumberView.clearFocus();
    AppMethodBeat.o(144743);
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(144745);
    this.cardNumberView.setHint(paramString);
    AppMethodBeat.o(144745);
  }
  
  public void setHintColor(long paramLong)
  {
    AppMethodBeat.i(144747);
    this.cardNumberView.setHintTextColor((int)paramLong);
    AppMethodBeat.o(144747);
  }
  
  public void setOnTextChangedCallback(KCardNumberEditViewOnTextChangedCallback paramKCardNumberEditViewOnTextChangedCallback)
  {
    this.m_callback = paramKCardNumberEditViewOnTextChangedCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KindaCardNumberEditViewImpl
 * JD-Core Version:    0.7.0.1
 */