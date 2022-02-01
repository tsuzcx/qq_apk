package com.tencent.kinda.framework.widget.base;

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
import com.tencent.kinda.framework.R.color;
import com.tencent.kinda.framework.R.drawable;
import com.tencent.kinda.framework.R.raw;
import com.tencent.kinda.framework.widget.tools.ColorUtil;
import com.tencent.kinda.framework.widget.tools.MMKViewUtil;
import com.tencent.kinda.gen.ClearButtonMode;
import com.tencent.kinda.gen.DynamicColor;
import com.tencent.kinda.gen.KSecureEditText;
import com.tencent.kinda.gen.KSecureEditTextOnTextChangedCallback;
import com.tencent.kinda.gen.KeyboardType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.bd;
import com.tencent.mm.wallet_core.ui.i;
import com.tenpay.android.wechat.TenpaySecureEditText;

public class KindaSecureEditTextImpl
  extends MMKView<LinearLayout>
  implements KSecureEditText
{
  private ClearButtonMode clearButtonMode = ClearButtonMode.WHILEEDITING;
  private String defaultValue;
  private TenpaySecureEditText editText;
  private float expandSize = 24.0F;
  private boolean iconHadShow = false;
  private WalletIconImageView iconImageView;
  private BaseFrActivity mContext;
  private KeyboardType mKeyboardType;
  private int m_maxLength = 2147483647;
  private KSecureEditTextOnTextChangedCallback onTextChangedCallback;
  
  private void setIconVisibility(int paramInt)
  {
    AppMethodBeat.i(226636);
    this.iconImageView.setVisibility(paramInt);
    if ((!this.iconHadShow) && (paramInt == 0))
    {
      MMKViewUtil.setExpandSize(this.iconImageView, this.expandSize, this.expandSize);
      this.iconHadShow = true;
    }
    AppMethodBeat.o(226636);
  }
  
  private void setregExFilterInput(KeyboardType paramKeyboardType)
  {
    AppMethodBeat.i(226633);
    if ((paramKeyboardType == KeyboardType.ID) || (paramKeyboardType == KeyboardType.CRETAIL))
    {
      this.editText.setregExFilterInput("[^a-zA-Z0-9]");
      AppMethodBeat.o(226633);
      return;
    }
    if (paramKeyboardType == KeyboardType.NUMBER) {
      this.editText.setregExFilterInput("[^0-9]");
    }
    AppMethodBeat.o(226633);
  }
  
  public LinearLayout createView(Context paramContext)
  {
    AppMethodBeat.i(18949);
    final LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setGravity(16);
    this.editText = new TenpaySecureEditText(paramContext);
    this.editText.setSingleLine(true);
    this.editText.setBackground(null);
    this.editText.setTextSize(1, 17.0F * MMKViewUtil.getScaleSize(paramContext));
    TenpaySecureEditText.setSalt(i.jPu());
    this.editText.setPadding(0, 0, 0, 0);
    this.editText.setCursorStyle(R.drawable.green_cursor);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -2);
    localLayoutParams.weight = 1.0F;
    localLinearLayout.addView(this.editText, localLayoutParams);
    localLinearLayout.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(226648);
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)KindaSecureEditTextImpl.this.editText.getLayoutParams();
        localLayoutParams.height = localLinearLayout.getHeight();
        KindaSecureEditTextImpl.this.editText.setLayoutParams(localLayoutParams);
        AppMethodBeat.o(226648);
      }
    });
    if ((paramContext instanceof BaseFrActivity))
    {
      this.mContext = ((BaseFrActivity)paramContext);
      this.mContext.setEditFocusListener(this.editText, 0, false);
      this.editText.setTag(this);
    }
    if (ColorUtil.ifCompatKindaDarkModeDefaultColor())
    {
      this.editText.setHintTextColor(paramContext.getResources().getColor(R.color.hint_text_color));
      this.editText.setTextColor(paramContext.getResources().getColor(R.color.normal_text_color));
    }
    this.iconImageView = new WalletIconImageView(paramContext);
    this.iconImageView.setClearBtnDrawableId(R.raw.icons_filled_close2, paramContext.getResources().getColor(R.color.arrow_color));
    this.iconImageView.setToClearState(new View.OnClickListener()
    {
      private byte _hellAccFlag_;
      
      public void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(226647);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/kinda/framework/widget/base/KindaSecureEditTextImpl$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (KindaSecureEditTextImpl.this.iconImageView.getVisibility() == 0) {
          KindaSecureEditTextImpl.this.editText.setText("");
        }
        a.a(this, "com/tencent/kinda/framework/widget/base/KindaSecureEditTextImpl$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(226647);
      }
    });
    setIconVisibility(4);
    localLayoutParams = new LinearLayout.LayoutParams(bd.fromDPToPix(paramContext, 16), bd.fromDPToPix(paramContext, 16));
    localLayoutParams.setMargins(0, 0, bd.fromDPToPix(paramContext, 4), 0);
    localLinearLayout.addView(this.iconImageView, localLayoutParams);
    this.editText.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(226653);
        if ((KindaSecureEditTextImpl.this.onTextChangedCallback != null) && (paramAnonymousEditable != null)) {
          KindaSecureEditTextImpl.this.onTextChangedCallback.onTextChanged(paramAnonymousEditable.toString());
        }
        AppMethodBeat.o(226653);
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(226650);
        if (KindaSecureEditTextImpl.this.clearButtonMode == ClearButtonMode.NEVER)
        {
          AppMethodBeat.o(226650);
          return;
        }
        if ((paramAnonymousCharSequence.length() > 0) && (KindaSecureEditTextImpl.this.clearButtonMode == ClearButtonMode.WHILEEDITING))
        {
          KindaSecureEditTextImpl.access$300(KindaSecureEditTextImpl.this, 0);
          AppMethodBeat.o(226650);
          return;
        }
        KindaSecureEditTextImpl.access$300(KindaSecureEditTextImpl.this, 4);
        AppMethodBeat.o(226650);
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
    AppMethodBeat.i(226670);
    if (!Util.isNullOrNil(this.defaultValue))
    {
      String str = this.defaultValue;
      AppMethodBeat.o(226670);
      return str;
    }
    AppMethodBeat.o(226670);
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
      setIconVisibility(8);
      AppMethodBeat.o(18956);
      return;
    }
    if ((paramClearButtonMode != ClearButtonMode.WHILEEDITING) && (paramClearButtonMode != ClearButtonMode.UNLESSEDITING))
    {
      if (paramClearButtonMode == ClearButtonMode.ALWAYS)
      {
        setIconVisibility(0);
        AppMethodBeat.o(18956);
        return;
      }
      setIconVisibility(4);
    }
    AppMethodBeat.o(18956);
  }
  
  public void setDefaultValue(String paramString)
  {
    AppMethodBeat.i(226667);
    this.defaultValue = paramString;
    this.editText.setText(paramString);
    AppMethodBeat.o(226667);
  }
  
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
    if ((paramKeyboardType == KeyboardType.ID) || (paramKeyboardType == KeyboardType.CRETAIL)) {
      this.mContext.setEditFocusListener(this.editText, 1, false);
    }
    for (;;)
    {
      setregExFilterInput(paramKeyboardType);
      AppMethodBeat.o(18959);
      return;
      if (paramKeyboardType == KeyboardType.NORMAL) {
        this.mContext.setEditFocusListener(this.editText, 0, true);
      }
    }
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
  
  public void setTextSize(float paramFloat)
  {
    AppMethodBeat.i(226652);
    if (paramFloat > 0.0F)
    {
      float f = 1.0F;
      if (getSupportDynamicSize()) {
        f = MMKViewUtil.getScaleSize(MMApplicationContext.getContext());
      }
      this.editText.setTextSize(1, f * paramFloat);
      notifyChanged();
    }
    AppMethodBeat.o(226652);
  }
  
  public void setTintColor(DynamicColor paramDynamicColor) {}
  
  public void setViewId(String paramString)
  {
    AppMethodBeat.i(226676);
    super.setViewId(paramString);
    if (this.iconImageView != null) {
      MMKViewUtil.setId4KindaImplView(this.mContext, paramString + "_btn", this.iconImageView);
    }
    AppMethodBeat.o(226676);
  }
  
  public void setVisibleClearIcon(boolean paramBoolean)
  {
    AppMethodBeat.i(170117);
    if (paramBoolean)
    {
      setIconVisibility(0);
      AppMethodBeat.o(170117);
      return;
    }
    setIconVisibility(4);
    AppMethodBeat.o(170117);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KindaSecureEditTextImpl
 * JD-Core Version:    0.7.0.1
 */