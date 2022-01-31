package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.graphics.Typeface;
import android.os.IBinder;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.framework.widget.tools.MMKViewUtil;
import com.tencent.kinda.gen.ClearButtonMode;
import com.tencent.kinda.gen.KEditText;
import com.tencent.kinda.gen.KEditTextOnTextBeginChangeCallback;
import com.tencent.kinda.gen.KEditTextOnTextChangedCallback;
import com.tencent.kinda.gen.KeyboardType;
import com.tencent.kinda.gen.TextAlign;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cb;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tenpay.android.wechat.ISecureEncrypt;
import com.tenpay.android.wechat.TenpaySecureEditText;
import com.tenpay.android.wechat.TenpaySecureEncrypt;

public class MMKEditText
  extends MMKView<LinearLayout>
  implements KEditText
{
  private ClearButtonMode clearButtonMode = ClearButtonMode.WHILEEDITING;
  protected TenpaySecureEditText editText;
  private long hintColor;
  private WalletIconImageView iconImageView;
  private KeyboardType keyboardType = KeyboardType.NORMAL;
  protected BaseFrActivity mBaseFrActivity = null;
  private int maxLength = -1;
  protected KEditTextOnTextBeginChangeCallback onTextBeginChangeCallback;
  protected KEditTextOnTextChangedCallback onTextChangedCallback;
  private TextAlign textAlign;
  private long textColor;
  private String textFontName;
  private float textSize;
  
  public LinearLayout createView(Context paramContext)
  {
    AppMethodBeat.i(144869);
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setGravity(16);
    this.editText = new TenpaySecureEditText(paramContext);
    this.editText.setSingleLine();
    this.editText.setBackground(null);
    this.editText.setUseOfKinda(true);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -1);
    localLayoutParams.weight = 1.0F;
    localLinearLayout.addView(this.editText, localLayoutParams);
    this.iconImageView = new WalletIconImageView(paramContext);
    this.iconImageView.setToClearState(new MMKEditText.1(this));
    this.iconImageView.setVisibility(8);
    localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLinearLayout.addView(this.iconImageView, localLayoutParams);
    if ((paramContext instanceof BaseFrActivity)) {
      this.mBaseFrActivity = ((BaseFrActivity)paramContext);
    }
    this.editText.addTextChangedListener(new MMKEditText.2(this));
    AppMethodBeat.o(144869);
    return localLinearLayout;
  }
  
  public String encryptWith3Des()
  {
    AppMethodBeat.i(144886);
    String str = new TenpaySecureEncrypt().desedeVerifyCode(this.editText.getText().toString(), Long.toString(cb.abp() / 1000L));
    AppMethodBeat.o(144886);
    return str;
  }
  
  public ClearButtonMode getClearButtonMode()
  {
    return this.clearButtonMode;
  }
  
  public boolean getEnabled()
  {
    AppMethodBeat.i(144888);
    boolean bool = this.editText.isEnabled();
    AppMethodBeat.o(144888);
    return bool;
  }
  
  public boolean getFocus()
  {
    AppMethodBeat.i(144884);
    boolean bool = this.editText.isFocused();
    AppMethodBeat.o(144884);
    return bool;
  }
  
  public String getHint()
  {
    AppMethodBeat.i(144877);
    Object localObject = this.editText.getHint();
    if (localObject != null)
    {
      localObject = ((CharSequence)localObject).toString();
      AppMethodBeat.o(144877);
      return localObject;
    }
    AppMethodBeat.o(144877);
    return null;
  }
  
  public long getHintColor()
  {
    return this.hintColor;
  }
  
  public KeyboardType getKeyboardType()
  {
    return this.keyboardType;
  }
  
  public int getMaxLength()
  {
    return this.maxLength;
  }
  
  public int getSelection()
  {
    AppMethodBeat.i(144882);
    int i = this.editText.getSelectionStart();
    AppMethodBeat.o(144882);
    return i;
  }
  
  public String getText()
  {
    AppMethodBeat.i(144871);
    ab.d("base_MMKView", "MMKLabelView getText ");
    Object localObject = this.editText.getText();
    if (localObject != null)
    {
      localObject = ((CharSequence)localObject).toString();
      AppMethodBeat.o(144871);
      return localObject;
    }
    AppMethodBeat.o(144871);
    return null;
  }
  
  public TextAlign getTextAlign()
  {
    return this.textAlign;
  }
  
  public long getTextColor()
  {
    return this.textColor;
  }
  
  public String getTextFont()
  {
    return this.textFontName;
  }
  
  public float getTextSize()
  {
    return this.textSize;
  }
  
  public long getTintColor()
  {
    return 0L;
  }
  
  public void setClearButtonMode(ClearButtonMode paramClearButtonMode)
  {
    AppMethodBeat.i(144885);
    this.clearButtonMode = paramClearButtonMode;
    if (paramClearButtonMode == ClearButtonMode.NEVER)
    {
      this.iconImageView.setVisibility(8);
      AppMethodBeat.o(144885);
      return;
    }
    if ((paramClearButtonMode != ClearButtonMode.WHILEEDITING) && (paramClearButtonMode != ClearButtonMode.UNLESSEDITING))
    {
      if (paramClearButtonMode == ClearButtonMode.ALWAYS)
      {
        this.iconImageView.setVisibility(0);
        AppMethodBeat.o(144885);
        return;
      }
      this.iconImageView.setVisibility(4);
    }
    AppMethodBeat.o(144885);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(144887);
    this.editText.setEnabled(paramBoolean);
    AppMethodBeat.o(144887);
  }
  
  public void setFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(144883);
    InputMethodManager localInputMethodManager;
    IBinder localIBinder;
    if (paramBoolean)
    {
      this.editText.requestFocus();
      if ((this.keyboardType != KeyboardType.ID) && (this.keyboardType != KeyboardType.CRETAIL))
      {
        localInputMethodManager = (InputMethodManager)KindaContext.get().getSystemService("input_method");
        localIBinder = this.editText.getWindowToken();
        if (!paramBoolean) {
          break label89;
        }
      }
    }
    label89:
    for (int i = 2;; i = 0)
    {
      localInputMethodManager.hideSoftInputFromWindow(localIBinder, i);
      AppMethodBeat.o(144883);
      return;
      this.editText.clearFocus();
      break;
    }
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(144876);
    this.editText.setHint(paramString);
    notifyChanged();
    AppMethodBeat.o(144876);
  }
  
  public void setHintColor(long paramLong)
  {
    AppMethodBeat.i(144878);
    this.hintColor = paramLong;
    this.editText.setHintTextColor(MMKViewUtil.argbColor(this.hintColor));
    AppMethodBeat.o(144878);
  }
  
  public void setKeyboardType(KeyboardType paramKeyboardType)
  {
    AppMethodBeat.i(144880);
    this.keyboardType = paramKeyboardType;
    switch (MMKEditText.4.$SwitchMap$com$tencent$kinda$gen$KeyboardType[paramKeyboardType.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(144880);
      return;
      this.editText.setInputType(0);
      AppMethodBeat.o(144880);
      return;
      this.editText.setInputType(2);
      AppMethodBeat.o(144880);
      return;
      this.editText.setInputType(128);
      AppMethodBeat.o(144880);
      return;
      this.editText.setInputType(32);
      AppMethodBeat.o(144880);
      return;
      this.editText.setInputType(3);
      AppMethodBeat.o(144880);
      return;
      if (this.mBaseFrActivity != null)
      {
        this.mBaseFrActivity.setEditFocusListener(this.editText, 1, false);
        this.mBaseFrActivity.setTenpayKBStateListener(new MMKEditText.3(this));
      }
    }
  }
  
  public void setMaxLength(int paramInt)
  {
    AppMethodBeat.i(144879);
    if (paramInt >= 0)
    {
      this.maxLength = paramInt;
      this.editText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.maxLength) });
    }
    AppMethodBeat.o(144879);
  }
  
  public void setOnTextBeginChangeCallback(KEditTextOnTextBeginChangeCallback paramKEditTextOnTextBeginChangeCallback)
  {
    this.onTextBeginChangeCallback = paramKEditTextOnTextBeginChangeCallback;
  }
  
  public void setOnTextChangedCallback(KEditTextOnTextChangedCallback paramKEditTextOnTextChangedCallback)
  {
    this.onTextChangedCallback = paramKEditTextOnTextChangedCallback;
  }
  
  public void setSelection(int paramInt)
  {
    AppMethodBeat.i(144881);
    this.editText.setSelection(paramInt);
    AppMethodBeat.o(144881);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(144870);
    ab.d("base_MMKView", "MMKLabelView setText ".concat(String.valueOf(paramString)));
    if (paramString != null) {
      this.editText.setText(paramString);
    }
    AppMethodBeat.o(144870);
  }
  
  public void setTextAlign(TextAlign paramTextAlign)
  {
    AppMethodBeat.i(144875);
    if (paramTextAlign != null)
    {
      this.textAlign = paramTextAlign;
      switch (MMKEditText.4.$SwitchMap$com$tencent$kinda$gen$TextAlign[this.textAlign.ordinal()])
      {
      }
    }
    for (;;)
    {
      notifyChanged();
      AppMethodBeat.o(144875);
      return;
      ((LinearLayout)getView()).setGravity(3);
      continue;
      ((LinearLayout)getView()).setGravity(1);
      continue;
      ((LinearLayout)getView()).setGravity(5);
    }
  }
  
  public void setTextColor(long paramLong)
  {
    AppMethodBeat.i(144873);
    this.textColor = paramLong;
    this.editText.setTextColor(MMKViewUtil.argbColor(paramLong));
    AppMethodBeat.o(144873);
  }
  
  public void setTextFont(String paramString)
  {
    AppMethodBeat.i(144874);
    if (paramString != null)
    {
      this.textFontName = paramString;
      this.editText.setTypeface(Typeface.createFromAsset(ah.getContext().getAssets(), paramString));
      notifyChanged();
    }
    AppMethodBeat.o(144874);
  }
  
  public void setTextSize(float paramFloat)
  {
    AppMethodBeat.i(144872);
    if (paramFloat > 0.0F)
    {
      this.textSize = paramFloat;
      this.editText.setTextSize(0, MMKViewUtil.dpToPx(ah.getContext(), paramFloat));
      notifyChanged();
    }
    AppMethodBeat.o(144872);
  }
  
  public void setTintColor(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKEditText
 * JD-Core Version:    0.7.0.1
 */