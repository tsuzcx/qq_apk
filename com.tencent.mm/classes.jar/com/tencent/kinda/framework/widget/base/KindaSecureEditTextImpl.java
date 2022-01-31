package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.kinda.gen.ClearButtonMode;
import com.tencent.kinda.gen.KSecureEditText;
import com.tencent.kinda.gen.KSecureEditTextOnTextChangedCallback;
import com.tencent.kinda.gen.KeyboardType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tenpay.android.wechat.TenpaySecureEditText;

public class KindaSecureEditTextImpl
  extends MMKView<LinearLayout>
  implements KSecureEditText
{
  private ClearButtonMode clearButtonMode = ClearButtonMode.WHILEEDITING;
  private TenpaySecureEditText editText;
  private WalletIconImageView iconImageView;
  private BaseFrActivity mContext;
  private KeyboardType mKeyboardType;
  private KSecureEditTextOnTextChangedCallback onTextChangedCallback;
  
  public LinearLayout createView(Context paramContext)
  {
    AppMethodBeat.i(144803);
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setGravity(16);
    this.editText = new TenpaySecureEditText(paramContext);
    this.editText.setSingleLine();
    this.editText.setBackground(null);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -1);
    localLayoutParams.weight = 1.0F;
    localLinearLayout.addView(this.editText, localLayoutParams);
    if ((paramContext instanceof BaseFrActivity))
    {
      this.mContext = ((BaseFrActivity)paramContext);
      this.mContext.setEditFocusListener(this.editText, 0, false);
    }
    this.iconImageView = new WalletIconImageView(paramContext);
    this.iconImageView.setToClearState(new KindaSecureEditTextImpl.1(this));
    this.iconImageView.setVisibility(4);
    paramContext = new LinearLayout.LayoutParams(-2, -2);
    localLinearLayout.addView(this.iconImageView, paramContext);
    this.editText.addTextChangedListener(new KindaSecureEditTextImpl.2(this));
    AppMethodBeat.o(144803);
    return localLinearLayout;
  }
  
  public ClearButtonMode getClearButtonMode()
  {
    return this.clearButtonMode;
  }
  
  public String getDefaultValue()
  {
    return "";
  }
  
  public boolean getEnabled()
  {
    AppMethodBeat.i(144815);
    boolean bool = this.editText.isEnabled();
    AppMethodBeat.o(144815);
    return bool;
  }
  
  public boolean getFocus()
  {
    AppMethodBeat.i(144808);
    boolean bool = this.editText.isFocused();
    AppMethodBeat.o(144808);
    return bool;
  }
  
  public String getHint()
  {
    AppMethodBeat.i(144806);
    String str = this.editText.getHint().toString();
    AppMethodBeat.o(144806);
    return str;
  }
  
  public KeyboardType getKeyboardType()
  {
    return this.mKeyboardType;
  }
  
  public long getTextColor()
  {
    AppMethodBeat.i(144811);
    long l = this.editText.getCurrentTextColor();
    AppMethodBeat.o(144811);
    return l;
  }
  
  public long getTintColor()
  {
    return 0L;
  }
  
  public String gettext()
  {
    AppMethodBeat.i(144804);
    String str = this.editText.get3DesEncrptData();
    AppMethodBeat.o(144804);
    return str;
  }
  
  public boolean isCardFromatValid(int paramInt)
  {
    AppMethodBeat.i(144813);
    boolean bool = this.editText.isAreaIDCardNum(paramInt);
    AppMethodBeat.o(144813);
    return bool;
  }
  
  public void setClearButtonMode(ClearButtonMode paramClearButtonMode)
  {
    AppMethodBeat.i(144809);
    this.clearButtonMode = paramClearButtonMode;
    if (paramClearButtonMode == ClearButtonMode.NEVER)
    {
      this.iconImageView.setVisibility(8);
      AppMethodBeat.o(144809);
      return;
    }
    if ((paramClearButtonMode != ClearButtonMode.WHILEEDITING) && (paramClearButtonMode != ClearButtonMode.UNLESSEDITING))
    {
      if (paramClearButtonMode == ClearButtonMode.ALWAYS)
      {
        this.iconImageView.setVisibility(0);
        AppMethodBeat.o(144809);
        return;
      }
      this.iconImageView.setVisibility(4);
    }
    AppMethodBeat.o(144809);
  }
  
  public void setDefaultValue(String paramString) {}
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(144814);
    this.editText.setEnabled(paramBoolean);
    AppMethodBeat.o(144814);
  }
  
  public void setFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(144807);
    if (paramBoolean)
    {
      this.editText.requestFocus();
      AppMethodBeat.o(144807);
      return;
    }
    this.editText.clearFocus();
    AppMethodBeat.o(144807);
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(144805);
    this.editText.setHint(paramString);
    AppMethodBeat.o(144805);
  }
  
  public void setKeyboardType(KeyboardType paramKeyboardType)
  {
    AppMethodBeat.i(144812);
    this.mKeyboardType = paramKeyboardType;
    if ((paramKeyboardType == KeyboardType.ID) || (paramKeyboardType == KeyboardType.CRETAIL))
    {
      this.mContext.setEditFocusListener(this.editText, 1, false);
      AppMethodBeat.o(144812);
      return;
    }
    if (paramKeyboardType == KeyboardType.NORMAL) {
      this.mContext.setEditFocusListener(this.editText, 0, true);
    }
    AppMethodBeat.o(144812);
  }
  
  public void setOnTextChangedCallback(KSecureEditTextOnTextChangedCallback paramKSecureEditTextOnTextChangedCallback)
  {
    this.onTextChangedCallback = paramKSecureEditTextOnTextChangedCallback;
  }
  
  public void setTextColor(long paramLong)
  {
    AppMethodBeat.i(144810);
    this.editText.setTextColor((int)paramLong);
    AppMethodBeat.o(144810);
  }
  
  public void setTintColor(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KindaSecureEditTextImpl
 * JD-Core Version:    0.7.0.1
 */