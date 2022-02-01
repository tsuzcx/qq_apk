package com.tencent.kinda.framework.widget.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.kinda.framework.widget.tools.ColorUtil;
import com.tencent.kinda.framework.widget.tools.MMKViewUtil;
import com.tencent.kinda.gen.ClearButtonMode;
import com.tencent.kinda.gen.DynamicColor;
import com.tencent.kinda.gen.KSecureEditText;
import com.tencent.kinda.gen.KSecureEditTextOnTextChangedCallback;
import com.tencent.kinda.gen.KeyboardType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.ui.ao;
import com.tencent.mm.wallet_core.ui.e;
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
  private int m_maxLength = 2147483647;
  private KSecureEditTextOnTextChangedCallback onTextChangedCallback;
  
  public LinearLayout createView(Context paramContext)
  {
    AppMethodBeat.i(18949);
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setGravity(16);
    this.editText = new TenpaySecureEditText(paramContext);
    this.editText.setSingleLine();
    this.editText.setBackground(null);
    this.editText.setTextSize(16.0F);
    TenpaySecureEditText.setSalt(e.fAR());
    this.editText.setPadding(0, 0, 0, 0);
    this.editText.setCursorStyle(2131232606);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -2);
    localLayoutParams.weight = 1.0F;
    localLinearLayout.addView(this.editText, localLayoutParams);
    if ((paramContext instanceof BaseFrActivity))
    {
      this.mContext = ((BaseFrActivity)paramContext);
      this.mContext.setEditFocusListener(this.editText, 0, false);
      this.editText.setTag(this);
    }
    if (ColorUtil.ifCompatKindaDarkModeDefaultColor())
    {
      this.editText.setHintTextColor(paramContext.getResources().getColor(2131100490));
      this.editText.setTextColor(paramContext.getResources().getColor(2131100711));
    }
    this.iconImageView = new WalletIconImageView(paramContext);
    this.iconImageView.setClearBtnDrawableId$255f295(paramContext.getResources().getColor(2131099982));
    this.iconImageView.setToClearState(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(18946);
        KindaSecureEditTextImpl.this.editText.setText("");
        AppMethodBeat.o(18946);
      }
    });
    this.iconImageView.setVisibility(4);
    localLayoutParams = new LinearLayout.LayoutParams(ao.fromDPToPix(paramContext, 16), ao.fromDPToPix(paramContext, 16));
    localLayoutParams.setMargins(0, 0, ao.fromDPToPix(paramContext, 4), 0);
    localLinearLayout.addView(this.iconImageView, localLayoutParams);
    this.editText.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(18948);
        if ((KindaSecureEditTextImpl.this.onTextChangedCallback != null) && (paramAnonymousEditable != null)) {
          KindaSecureEditTextImpl.this.onTextChangedCallback.onTextChanged(paramAnonymousEditable.toString());
        }
        AppMethodBeat.o(18948);
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(18947);
        if (KindaSecureEditTextImpl.this.clearButtonMode == ClearButtonMode.NEVER)
        {
          AppMethodBeat.o(18947);
          return;
        }
        if ((paramAnonymousCharSequence.length() > 0) && (KindaSecureEditTextImpl.this.clearButtonMode == ClearButtonMode.WHILEEDITING))
        {
          KindaSecureEditTextImpl.this.iconImageView.setVisibility(0);
          AppMethodBeat.o(18947);
          return;
        }
        KindaSecureEditTextImpl.this.iconImageView.setVisibility(4);
        AppMethodBeat.o(18947);
      }
    });
    AppMethodBeat.o(18949);
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
    AppMethodBeat.i(18962);
    boolean bool = this.editText.isEnabled();
    AppMethodBeat.o(18962);
    return bool;
  }
  
  public boolean getFocus()
  {
    AppMethodBeat.i(18955);
    boolean bool = this.editText.isFocused();
    AppMethodBeat.o(18955);
    return bool;
  }
  
  public String getHint()
  {
    AppMethodBeat.i(18953);
    String str = this.editText.getHint().toString();
    AppMethodBeat.o(18953);
    return str;
  }
  
  public KeyboardType getKeyboardType()
  {
    return this.mKeyboardType;
  }
  
  public int getMaxLength()
  {
    return this.m_maxLength;
  }
  
  public String getText()
  {
    AppMethodBeat.i(18951);
    String str = this.editText.get3DesEncrptData();
    AppMethodBeat.o(18951);
    return str;
  }
  
  public DynamicColor getTextColor()
  {
    AppMethodBeat.i(18958);
    DynamicColor localDynamicColor = new DynamicColor(this.editText.getCurrentTextColor(), 0L);
    AppMethodBeat.o(18958);
    return localDynamicColor;
  }
  
  public DynamicColor getTintColor()
  {
    return null;
  }
  
  public boolean isCardFromatValid(int paramInt)
  {
    AppMethodBeat.i(18960);
    boolean bool = this.editText.isAreaIDCardNum(paramInt);
    AppMethodBeat.o(18960);
    return bool;
  }
  
  public void setClearButtonMode(ClearButtonMode paramClearButtonMode)
  {
    AppMethodBeat.i(18956);
    this.clearButtonMode = paramClearButtonMode;
    if (paramClearButtonMode == ClearButtonMode.NEVER)
    {
      this.iconImageView.setVisibility(8);
      AppMethodBeat.o(18956);
      return;
    }
    if ((paramClearButtonMode != ClearButtonMode.WHILEEDITING) && (paramClearButtonMode != ClearButtonMode.UNLESSEDITING))
    {
      if (paramClearButtonMode == ClearButtonMode.ALWAYS)
      {
        this.iconImageView.setVisibility(0);
        AppMethodBeat.o(18956);
        return;
      }
      this.iconImageView.setVisibility(4);
    }
    AppMethodBeat.o(18956);
  }
  
  public void setDefaultValue(String paramString) {}
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(18961);
    this.editText.setEnabled(paramBoolean);
    AppMethodBeat.o(18961);
  }
  
  public void setFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(18954);
    if (paramBoolean)
    {
      this.editText.requestFocus();
      AppMethodBeat.o(18954);
      return;
    }
    this.editText.clearFocus();
    AppMethodBeat.o(18954);
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(18952);
    this.editText.setHint(paramString);
    AppMethodBeat.o(18952);
  }
  
  public void setKeyboardType(KeyboardType paramKeyboardType)
  {
    AppMethodBeat.i(18959);
    this.mKeyboardType = paramKeyboardType;
    if ((paramKeyboardType == KeyboardType.ID) || (paramKeyboardType == KeyboardType.CRETAIL))
    {
      this.mContext.setEditFocusListener(this.editText, 1, false);
      AppMethodBeat.o(18959);
      return;
    }
    if (paramKeyboardType == KeyboardType.NORMAL) {
      this.mContext.setEditFocusListener(this.editText, 0, true);
    }
    AppMethodBeat.o(18959);
  }
  
  public void setMaxLength(int paramInt)
  {
    AppMethodBeat.i(18963);
    this.m_maxLength = paramInt;
    this.editText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
    AppMethodBeat.o(18963);
  }
  
  public void setOnTextChangedCallback(KSecureEditTextOnTextChangedCallback paramKSecureEditTextOnTextChangedCallback)
  {
    this.onTextChangedCallback = paramKSecureEditTextOnTextChangedCallback;
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(18950);
    this.editText.setText(paramString);
    AppMethodBeat.o(18950);
  }
  
  public void setTextColor(DynamicColor paramDynamicColor)
  {
    AppMethodBeat.i(18957);
    this.editText.setTextColor((int)ColorUtil.getColorByMode(paramDynamicColor));
    AppMethodBeat.o(18957);
  }
  
  public void setTintColor(DynamicColor paramDynamicColor) {}
  
  @SuppressLint({"ResourceType"})
  public void setViewId(String paramString)
  {
    AppMethodBeat.i(207404);
    super.setViewId(paramString);
    if (this.iconImageView != null) {
      MMKViewUtil.setId4KindaImplView(this.mContext, paramString + "_btn", this.iconImageView);
    }
    AppMethodBeat.o(207404);
  }
  
  public void setVisibleClearIcon(boolean paramBoolean)
  {
    AppMethodBeat.i(170117);
    if (paramBoolean)
    {
      this.iconImageView.setVisibility(0);
      AppMethodBeat.o(170117);
      return;
    }
    this.iconImageView.setVisibility(4);
    AppMethodBeat.o(170117);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KindaSecureEditTextImpl
 * JD-Core Version:    0.7.0.1
 */