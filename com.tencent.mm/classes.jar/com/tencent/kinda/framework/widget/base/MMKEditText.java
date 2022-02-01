package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.kinda.framework.widget.tools.ColorUtil;
import com.tencent.kinda.framework.widget.tools.MMKViewUtil;
import com.tencent.kinda.gen.ClearButtonMode;
import com.tencent.kinda.gen.DynamicColor;
import com.tencent.kinda.gen.KEditText;
import com.tencent.kinda.gen.KEditTextOnTextBeginChangeCallback;
import com.tencent.kinda.gen.KEditTextOnTextChangedCallback;
import com.tencent.kinda.gen.KEditTextOnTextEndEditingCallback;
import com.tencent.kinda.gen.KViewOnClickCallback;
import com.tencent.kinda.gen.KeyboardType;
import com.tencent.kinda.gen.TextAlign;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ce;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.ao;
import com.tencent.mm.wallet_core.ui.a;
import com.tenpay.android.wechat.ISecureEncrypt;
import com.tenpay.android.wechat.TenpaySecureEditText;
import com.tenpay.android.wechat.TenpaySecureEncrypt;

public class MMKEditText
  extends MMKView<LinearLayout>
  implements KEditText
{
  private ClearButtonMode clearButtonMode;
  protected TenpaySecureEditText editText;
  private DynamicColor hintColor;
  private WalletIconImageView iconImageView;
  private KeyboardType keyboardType;
  protected BaseFrActivity mBaseFrActivity;
  protected KEditTextOnTextEndEditingCallback mKEditTextOnTextEndEditingCallback;
  private int maxLength;
  protected KEditTextOnTextBeginChangeCallback onTextBeginChangeCallback;
  protected KEditTextOnTextChangedCallback onTextChangedCallback;
  private TextAlign textAlign;
  private DynamicColor textColor;
  private String textFontName;
  private float textSize;
  
  public MMKEditText()
  {
    AppMethodBeat.i(19021);
    this.textColor = new DynamicColor(0L, 0L);
    this.hintColor = new DynamicColor(0L, 0L);
    this.maxLength = -1;
    this.keyboardType = KeyboardType.NORMAL;
    this.clearButtonMode = ClearButtonMode.WHILEEDITING;
    this.mBaseFrActivity = null;
    AppMethodBeat.o(19021);
  }
  
  public void callBackKindaTextEndEditing()
  {
    AppMethodBeat.i(178777);
    if (this.mKEditTextOnTextEndEditingCallback != null) {
      this.mKEditTextOnTextEndEditingCallback.onTextEndEditing(this.editText.getText().toString());
    }
    AppMethodBeat.o(178777);
  }
  
  public LinearLayout createView(Context paramContext)
  {
    AppMethodBeat.i(19022);
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setGravity(16);
    this.editText = new TenpaySecureEditText(paramContext);
    this.editText.setSingleLine();
    this.editText.setBackground(null);
    this.editText.setTextSize(16.0F);
    this.editText.setTag(this);
    this.editText.setCursorStyle(2131232606);
    this.editText.setPadding(0, 0, 0, 0);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -2);
    localLayoutParams.weight = 1.0F;
    localLinearLayout.addView(this.editText, localLayoutParams);
    this.iconImageView = new WalletIconImageView(paramContext);
    this.iconImageView.setClearBtnDrawableId$255f295(paramContext.getResources().getColor(2131099982));
    this.iconImageView.setToClearState(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(19015);
        MMKEditText.this.editText.setText("");
        AppMethodBeat.o(19015);
      }
    });
    this.iconImageView.setVisibility(8);
    localLayoutParams = new LinearLayout.LayoutParams(ao.fromDPToPix(paramContext, 16), ao.fromDPToPix(paramContext, 16));
    localLayoutParams.setMargins(0, 0, ao.fromDPToPix(paramContext, 4), 0);
    localLinearLayout.addView(this.iconImageView, localLayoutParams);
    if ((paramContext instanceof BaseFrActivity)) {
      this.mBaseFrActivity = ((BaseFrActivity)paramContext);
    }
    this.editText.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(19018);
        if ((MMKEditText.this.onTextChangedCallback != null) && (paramAnonymousEditable != null)) {
          MMKEditText.this.onTextChangedCallback.onTextChanged(paramAnonymousEditable.toString());
        }
        AppMethodBeat.o(19018);
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(19016);
        if ((MMKEditText.this.onTextBeginChangeCallback != null) && (paramAnonymousCharSequence != null)) {
          MMKEditText.this.onTextBeginChangeCallback.onTextBeginChange(paramAnonymousCharSequence.toString());
        }
        AppMethodBeat.o(19016);
      }
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(19017);
        if (MMKEditText.this.clearButtonMode == ClearButtonMode.NEVER)
        {
          MMKEditText.this.iconImageView.setVisibility(8);
          AppMethodBeat.o(19017);
          return;
        }
        if ((paramAnonymousCharSequence != null) && (paramAnonymousCharSequence.length() > 0) && (MMKEditText.this.clearButtonMode == ClearButtonMode.WHILEEDITING))
        {
          MMKEditText.this.iconImageView.setVisibility(0);
          AppMethodBeat.o(19017);
          return;
        }
        MMKEditText.this.iconImageView.setVisibility(4);
        AppMethodBeat.o(19017);
      }
    });
    this.editText.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(170122);
        if ((paramAnonymousBoolean) && (MMKEditText.this.editText.getText().length() > 0))
        {
          MMKEditText.this.iconImageView.setVisibility(0);
          AppMethodBeat.o(170122);
          return;
        }
        MMKEditText.this.iconImageView.setVisibility(4);
        AppMethodBeat.o(170122);
      }
    });
    if (ColorUtil.ifCompatKindaDarkModeDefaultColor())
    {
      this.editText.setHintTextColor(paramContext.getResources().getColor(2131100490));
      this.editText.setTextColor(paramContext.getResources().getColor(2131100711));
    }
    this.editText.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(184745);
        if (MMKEditText.this.editText.isFocused())
        {
          AppMethodBeat.o(184745);
          return false;
        }
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          paramAnonymousView = MMKEditText.this.getOnClickCallback();
          if (paramAnonymousView != null)
          {
            paramAnonymousView.onClick(MMKEditText.this);
            AppMethodBeat.o(184745);
            return true;
          }
          AppMethodBeat.o(184745);
          return false;
        }
        AppMethodBeat.o(184745);
        return false;
      }
    });
    this.editText.setId(2131301271);
    AppMethodBeat.o(19022);
    return localLinearLayout;
  }
  
  public String encryptWith3Des()
  {
    AppMethodBeat.i(19039);
    String str = new TenpaySecureEncrypt().desedeVerifyCode(this.editText.getText().toString(), Long.toString(ce.asQ() / 1000L));
    AppMethodBeat.o(19039);
    return str;
  }
  
  public ClearButtonMode getClearButtonMode()
  {
    return this.clearButtonMode;
  }
  
  public boolean getEnabled()
  {
    AppMethodBeat.i(19041);
    boolean bool = this.editText.isEnabled();
    AppMethodBeat.o(19041);
    return bool;
  }
  
  public boolean getFocus()
  {
    AppMethodBeat.i(19037);
    boolean bool = this.editText.isFocused();
    AppMethodBeat.o(19037);
    return bool;
  }
  
  public String getHint()
  {
    AppMethodBeat.i(19030);
    Object localObject = this.editText.getHint();
    if (localObject != null)
    {
      localObject = ((CharSequence)localObject).toString();
      AppMethodBeat.o(19030);
      return localObject;
    }
    AppMethodBeat.o(19030);
    return null;
  }
  
  public DynamicColor getHintColor()
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
    AppMethodBeat.i(19035);
    int i = this.editText.getSelectionStart();
    AppMethodBeat.o(19035);
    return i;
  }
  
  public String getText()
  {
    AppMethodBeat.i(19024);
    ad.d("base_MMKView", "MMKLabelView getText ");
    Object localObject = this.editText.getText();
    if (localObject != null)
    {
      localObject = ((CharSequence)localObject).toString();
      AppMethodBeat.o(19024);
      return localObject;
    }
    AppMethodBeat.o(19024);
    return null;
  }
  
  public TextAlign getTextAlign()
  {
    return this.textAlign;
  }
  
  public DynamicColor getTextColor()
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
  
  public DynamicColor getTintColor()
  {
    return null;
  }
  
  public void setClearButtonMode(ClearButtonMode paramClearButtonMode)
  {
    AppMethodBeat.i(19038);
    this.clearButtonMode = paramClearButtonMode;
    if (paramClearButtonMode == ClearButtonMode.NEVER)
    {
      this.iconImageView.setVisibility(8);
      AppMethodBeat.o(19038);
      return;
    }
    if ((paramClearButtonMode != ClearButtonMode.WHILEEDITING) && (paramClearButtonMode != ClearButtonMode.UNLESSEDITING))
    {
      if (paramClearButtonMode == ClearButtonMode.ALWAYS)
      {
        this.iconImageView.setVisibility(0);
        AppMethodBeat.o(19038);
        return;
      }
      this.iconImageView.setVisibility(4);
    }
    AppMethodBeat.o(19038);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(19040);
    this.editText.setEnabled(paramBoolean);
    AppMethodBeat.o(19040);
  }
  
  public void setFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(19036);
    if (paramBoolean)
    {
      if (this.editText.hasFocus()) {
        this.editText.clearFocus();
      }
      this.editText.postDelayed(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(184747);
          MMKEditText.this.editText.requestFocus();
          if ((MMKEditText.this.keyboardType != KeyboardType.ID) && (MMKEditText.this.keyboardType != KeyboardType.CRETAIL)) {
            ((InputMethodManager)MMKEditText.this.mContext.getSystemService("input_method")).showSoftInput(MMKEditText.this.editText, 0);
          }
          AppMethodBeat.o(184747);
        }
      }, 50L);
      AppMethodBeat.o(19036);
      return;
    }
    this.editText.clearFocus();
    if ((this.keyboardType != KeyboardType.ID) && (this.keyboardType != KeyboardType.CRETAIL)) {
      ((InputMethodManager)this.mContext.getSystemService("input_method")).hideSoftInputFromWindow(this.editText.getWindowToken(), 0);
    }
    AppMethodBeat.o(19036);
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(19029);
    this.editText.setHint(paramString);
    notifyChanged();
    AppMethodBeat.o(19029);
  }
  
  public void setHintColor(DynamicColor paramDynamicColor)
  {
    AppMethodBeat.i(19031);
    this.hintColor = paramDynamicColor;
    this.editText.setHintTextColor(MMKViewUtil.argbColor(ColorUtil.getColorByMode(this.hintColor)));
    AppMethodBeat.o(19031);
  }
  
  public void setKeyboardType(KeyboardType paramKeyboardType)
  {
    AppMethodBeat.i(19033);
    this.keyboardType = paramKeyboardType;
    switch (7.$SwitchMap$com$tencent$kinda$gen$KeyboardType[paramKeyboardType.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(19033);
      return;
      this.editText.setInputType(0);
      AppMethodBeat.o(19033);
      return;
      this.editText.setInputType(2);
      AppMethodBeat.o(19033);
      return;
      this.editText.setInputType(128);
      AppMethodBeat.o(19033);
      return;
      this.editText.setInputType(32);
      AppMethodBeat.o(19033);
      return;
      this.editText.setInputType(3);
      AppMethodBeat.o(19033);
      return;
      if (this.mBaseFrActivity != null)
      {
        this.mBaseFrActivity.setEditFocusListener(this.editText, 1, false);
        this.mBaseFrActivity.setTenpayKBStateListener(new a()
        {
          public void onVisibleStateChange(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(184746);
            if ((!paramAnonymousBoolean) && (MMKEditText.this.editText.isFocused())) {
              MMKEditText.this.editText.clearFocus();
            }
            AppMethodBeat.o(184746);
          }
        });
      }
    }
  }
  
  public void setMaxLength(int paramInt)
  {
    AppMethodBeat.i(19032);
    if (paramInt >= 0)
    {
      this.maxLength = paramInt;
      this.editText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.maxLength) });
    }
    AppMethodBeat.o(19032);
  }
  
  public void setOnTextBeginChangeCallback(KEditTextOnTextBeginChangeCallback paramKEditTextOnTextBeginChangeCallback)
  {
    this.onTextBeginChangeCallback = paramKEditTextOnTextBeginChangeCallback;
  }
  
  public void setOnTextChangedCallback(KEditTextOnTextChangedCallback paramKEditTextOnTextChangedCallback)
  {
    this.onTextChangedCallback = paramKEditTextOnTextChangedCallback;
  }
  
  public void setOnTextEndEditingCallback(KEditTextOnTextEndEditingCallback paramKEditTextOnTextEndEditingCallback)
  {
    this.mKEditTextOnTextEndEditingCallback = paramKEditTextOnTextEndEditingCallback;
  }
  
  public void setSelection(int paramInt)
  {
    AppMethodBeat.i(19034);
    this.editText.setSelection(paramInt);
    AppMethodBeat.o(19034);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(19023);
    ad.d("base_MMKView", "MMKLabelView setText ".concat(String.valueOf(paramString)));
    if ((paramString != null) && (!getText().equals(paramString))) {
      this.editText.setText(paramString);
    }
    AppMethodBeat.o(19023);
  }
  
  public void setTextAlign(TextAlign paramTextAlign)
  {
    AppMethodBeat.i(19028);
    if (paramTextAlign != null)
    {
      this.textAlign = paramTextAlign;
      switch (7.$SwitchMap$com$tencent$kinda$gen$TextAlign[this.textAlign.ordinal()])
      {
      }
    }
    for (;;)
    {
      notifyChanged();
      AppMethodBeat.o(19028);
      return;
      ((LinearLayout)getView()).setGravity(3);
      continue;
      ((LinearLayout)getView()).setGravity(1);
      continue;
      ((LinearLayout)getView()).setGravity(5);
    }
  }
  
  public void setTextColor(DynamicColor paramDynamicColor)
  {
    AppMethodBeat.i(19026);
    this.textColor = paramDynamicColor;
    this.editText.setTextColor(MMKViewUtil.argbColor(ColorUtil.getColorByMode(paramDynamicColor)));
    AppMethodBeat.o(19026);
  }
  
  public void setTextFont(String paramString)
  {
    AppMethodBeat.i(19027);
    if (paramString != null)
    {
      this.textFontName = paramString;
      this.editText.setTypeface(Typeface.createFromAsset(aj.getContext().getAssets(), paramString));
      notifyChanged();
    }
    AppMethodBeat.o(19027);
  }
  
  public void setTextSize(float paramFloat)
  {
    AppMethodBeat.i(19025);
    if (paramFloat > 0.0F)
    {
      this.textSize = paramFloat;
      this.editText.setTextSize(0, MMKViewUtil.dpToPx(aj.getContext(), paramFloat));
      notifyChanged();
    }
    AppMethodBeat.o(19025);
  }
  
  public void setTintColor(DynamicColor paramDynamicColor) {}
  
  public void setViewId(String paramString)
  {
    AppMethodBeat.i(186444);
    super.setViewId(paramString);
    if (this.iconImageView != null)
    {
      paramString = paramString + "_btn";
      int i = this.mContext.getResources().getIdentifier(paramString, "id", this.mContext.getPackageName());
      if (i > 0)
      {
        this.iconImageView.setId(i);
        ad.d("base_MMKView", "setViewId has set rid: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(186444);
        return;
      }
      ad.d("base_MMKView", "setViewId has not set rid: " + paramString + ", because no found res.");
    }
    AppMethodBeat.o(186444);
  }
  
  public void setVisibleClearIcon(boolean paramBoolean)
  {
    AppMethodBeat.i(170125);
    if ((paramBoolean) && (this.editText.getText().length() > 0))
    {
      this.iconImageView.setVisibility(0);
      AppMethodBeat.o(170125);
      return;
    }
    this.iconImageView.setVisibility(4);
    AppMethodBeat.o(170125);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKEditText
 * JD-Core Version:    0.7.0.1
 */