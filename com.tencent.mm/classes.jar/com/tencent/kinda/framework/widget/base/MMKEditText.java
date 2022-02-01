package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.kinda.framework.R.color;
import com.tencent.kinda.framework.R.drawable;
import com.tencent.kinda.framework.R.id;
import com.tencent.kinda.framework.R.raw;
import com.tencent.kinda.framework.R.string;
import com.tencent.kinda.framework.widget.tools.ColorUtil;
import com.tencent.kinda.framework.widget.tools.KindaWcKeyboardHelpr;
import com.tencent.kinda.framework.widget.tools.MMKViewUtil;
import com.tencent.kinda.gen.ClearButtonMode;
import com.tencent.kinda.gen.DynamicColor;
import com.tencent.kinda.gen.EditTextRestrictType;
import com.tencent.kinda.gen.KEditText;
import com.tencent.kinda.gen.KEditTextOnEditorActionCallback;
import com.tencent.kinda.gen.KEditTextOnTextBeginChangeCallback;
import com.tencent.kinda.gen.KEditTextOnTextChangedCallback;
import com.tencent.kinda.gen.KEditTextOnTextEndEditingCallback;
import com.tencent.kinda.gen.KViewOnClickCallback;
import com.tencent.kinda.gen.KeyboardType;
import com.tencent.kinda.gen.TextAlign;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.framework.app.UIPageFragmentActivity;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.cn;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.bd;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.i;
import com.tenpay.android.wechat.ISecureEncrypt;
import com.tenpay.android.wechat.TenpaySecureEditText;
import com.tenpay.android.wechat.TenpaySecureEncrypt;

public class MMKEditText
  extends MMKView<LinearLayout>
  implements KEditText
{
  private ClearButtonMode clearButtonMode;
  protected TenpaySecureEditText editText;
  private float expandSize;
  private DynamicColor hintColor;
  private String hintText;
  private boolean iconHadShow;
  private WalletIconImageView iconImageView;
  private KeyboardType keyboardType;
  protected BaseFrActivity mBaseFrActivity;
  protected KEditTextOnEditorActionCallback mKEditTextOnEditorActionCallback;
  protected KEditTextOnTextEndEditingCallback mKEditTextOnTextEndEditingCallback;
  private EditTextRestrictType mRestriceType;
  private int maxLength;
  protected KEditTextOnTextBeginChangeCallback onTextBeginChangeCallback;
  protected KEditTextOnTextChangedCallback onTextChangedCallback;
  private TextAlign textAlign;
  private DynamicColor textColor;
  private String textFontName;
  private float textSize;
  private WcPayKeyboard wcPayKeyboard;
  
  public MMKEditText()
  {
    AppMethodBeat.i(19021);
    this.textColor = new DynamicColor(0L, 0L);
    this.hintColor = new DynamicColor(0L, 0L);
    this.maxLength = -1;
    this.keyboardType = KeyboardType.NORMAL;
    this.clearButtonMode = ClearButtonMode.WHILEEDITING;
    this.mBaseFrActivity = null;
    this.iconHadShow = false;
    this.expandSize = 24.0F;
    AppMethodBeat.o(19021);
  }
  
  private void setIconVisibility(int paramInt)
  {
    AppMethodBeat.i(226594);
    this.iconImageView.setVisibility(paramInt);
    if ((!this.iconHadShow) && (paramInt == 0))
    {
      MMKViewUtil.setExpandSize(this.iconImageView, this.expandSize, this.expandSize);
      this.iconHadShow = true;
    }
    AppMethodBeat.o(226594);
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
    this.editText.setSingleLine(false);
    this.editText.setMaxLines(2);
    this.editText.setBackground(null);
    this.editText.setTextSize(1, 17.0F * MMKViewUtil.getScaleSize(paramContext));
    this.editText.setTag(this);
    this.editText.setCursorStyle(R.drawable.green_cursor);
    this.editText.setPadding(0, 0, 0, 0);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -2);
    localLayoutParams.weight = 1.0F;
    localLinearLayout.addView(this.editText, localLayoutParams);
    this.iconImageView = new WalletIconImageView(paramContext);
    this.iconImageView.setClearBtnDrawableId(R.raw.icons_filled_close2, paramContext.getResources().getColor(R.color.arrow_color));
    this.iconImageView.setToClearState(new View.OnClickListener()
    {
      private byte _hellAccFlag_;
      
      public void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(19015);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/kinda/framework/widget/base/MMKEditText$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (MMKEditText.this.iconImageView.getVisibility() == 0) {
          MMKEditText.this.editText.setText("");
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/kinda/framework/widget/base/MMKEditText$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(19015);
      }
    });
    setIconVisibility(8);
    localLayoutParams = new LinearLayout.LayoutParams(bd.fromDPToPix(paramContext, 16), bd.fromDPToPix(paramContext, 16));
    localLayoutParams.setMargins(16, 0, bd.fromDPToPix(paramContext, 4), 0);
    localLinearLayout.addView(this.iconImageView, localLayoutParams);
    localLinearLayout.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(226563);
        if (MMKEditText.this.clearButtonMode != ClearButtonMode.NEVER)
        {
          MMKEditText.access$200(MMKEditText.this, 4);
          MMKEditText.this.notifyChanged();
        }
        AppMethodBeat.o(226563);
      }
    });
    if ((paramContext instanceof BaseFrActivity)) {
      this.mBaseFrActivity = ((BaseFrActivity)paramContext);
    }
    this.editText.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(226568);
        if ((MMKEditText.this.onTextChangedCallback != null) && (paramAnonymousEditable != null)) {
          MMKEditText.this.onTextChangedCallback.onTextChanged(paramAnonymousEditable.toString());
        }
        if ((paramAnonymousEditable != null) && (!TextUtils.isEmpty(paramAnonymousEditable.toString()))) {
          MMKEditText.this.editText.setHint("");
        }
        for (;;)
        {
          MMKEditText.this.notifyChanged();
          AppMethodBeat.o(226568);
          return;
          MMKEditText.this.editText.setHint(MMKEditText.this.hintText);
        }
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(226564);
        if ((MMKEditText.this.onTextBeginChangeCallback != null) && (paramAnonymousCharSequence != null)) {
          MMKEditText.this.onTextBeginChangeCallback.onTextBeginChange(paramAnonymousCharSequence.toString());
        }
        AppMethodBeat.o(226564);
      }
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(226567);
        if (MMKEditText.this.clearButtonMode == ClearButtonMode.NEVER)
        {
          MMKEditText.access$200(MMKEditText.this, 8);
          AppMethodBeat.o(226567);
          return;
        }
        if ((paramAnonymousCharSequence != null) && (paramAnonymousCharSequence.length() > 0) && (MMKEditText.this.clearButtonMode == ClearButtonMode.WHILEEDITING))
        {
          MMKEditText.access$200(MMKEditText.this, 0);
          AppMethodBeat.o(226567);
          return;
        }
        MMKEditText.access$200(MMKEditText.this, 4);
        AppMethodBeat.o(226567);
      }
    });
    this.editText.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(226566);
        if ((MMKEditText.this.clearButtonMode == ClearButtonMode.WHILEEDITING) || (MMKEditText.this.clearButtonMode == ClearButtonMode.ALWAYS) || (MMKEditText.this.clearButtonMode == ClearButtonMode.UNLESSEDITING)) {}
        for (int i = 1; (paramAnonymousBoolean) && (MMKEditText.this.editText.getText().length() > 0) && (i != 0); i = 0)
        {
          MMKEditText.access$200(MMKEditText.this, 0);
          AppMethodBeat.o(226566);
          return;
        }
        MMKEditText.access$200(MMKEditText.this, 4);
        AppMethodBeat.o(226566);
      }
    });
    if (ColorUtil.ifCompatKindaDarkModeDefaultColor())
    {
      this.editText.setHintTextColor(paramContext.getResources().getColor(R.color.hint_text_color));
      this.editText.setTextColor(paramContext.getResources().getColor(R.color.normal_text_color));
    }
    this.editText.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(226570);
        if (MMKEditText.this.editText.isFocused())
        {
          AppMethodBeat.o(226570);
          return false;
        }
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          paramAnonymousView = MMKEditText.this.getOnClickCallback();
          if (paramAnonymousView != null)
          {
            paramAnonymousView.onClick(MMKEditText.this);
            AppMethodBeat.o(226570);
            return true;
          }
          AppMethodBeat.o(226570);
          return false;
        }
        AppMethodBeat.o(226570);
        return false;
      }
    });
    this.editText.setId(R.id.kinda_edit_text_input);
    localLinearLayout.setFocusableInTouchMode(true);
    localLinearLayout.setFocusable(true);
    AppMethodBeat.o(19022);
    return localLinearLayout;
  }
  
  public void enableConfirmBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(226663);
    if (this.wcPayKeyboard != null) {
      this.wcPayKeyboard.Oi(paramBoolean);
    }
    AppMethodBeat.o(226663);
  }
  
  public String encryptWith3Des()
  {
    AppMethodBeat.i(19039);
    String str = new TenpaySecureEncrypt().desedeVerifyCode(this.editText.getText().toString(), Long.toString(cn.bDu() / 1000L));
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
    if (this.hintText != null)
    {
      localObject = this.hintText;
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
  
  public EditTextRestrictType getRestrictType()
  {
    return this.mRestriceType;
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
    Log.d("base_MMKView", "MMKLabelView getText ");
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
      setIconVisibility(8);
      AppMethodBeat.o(19038);
      return;
    }
    if ((paramClearButtonMode != ClearButtonMode.WHILEEDITING) && (paramClearButtonMode != ClearButtonMode.UNLESSEDITING))
    {
      if (paramClearButtonMode == ClearButtonMode.ALWAYS)
      {
        setIconVisibility(0);
        AppMethodBeat.o(19038);
        return;
      }
      setIconVisibility(4);
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
          AppMethodBeat.i(226578);
          MMKEditText.this.editText.requestFocus();
          if ((MMKEditText.this.keyboardType != KeyboardType.ID) && (MMKEditText.this.keyboardType != KeyboardType.CRETAIL) && (MMKEditText.this.keyboardType != KeyboardType.DIGIT)) {
            ((InputMethodManager)MMKEditText.this.mContext.getSystemService("input_method")).showSoftInput(MMKEditText.this.editText, 0);
          }
          AppMethodBeat.o(226578);
        }
      }, 50L);
      AppMethodBeat.o(19036);
      return;
    }
    this.editText.clearFocus();
    if ((this.keyboardType != KeyboardType.ID) && (this.keyboardType != KeyboardType.CRETAIL) && (this.keyboardType != KeyboardType.DIGIT)) {
      ((InputMethodManager)this.mContext.getSystemService("input_method")).hideSoftInputFromWindow(this.editText.getWindowToken(), 0);
    }
    AppMethodBeat.o(19036);
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(19029);
    this.hintText = paramString;
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
    switch (10.$SwitchMap$com$tencent$kinda$gen$KeyboardType[paramKeyboardType.ordinal()])
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
        this.mBaseFrActivity.setTenpayKBStateListener(new com.tencent.mm.wallet_core.ui.a()
        {
          public void onVisibleStateChange(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(226575);
            if ((!paramAnonymousBoolean) && (MMKEditText.this.editText.isFocused())) {
              MMKEditText.this.editText.clearFocus();
            }
            AppMethodBeat.o(226575);
          }
        });
        AppMethodBeat.o(19033);
        return;
        this.editText.setImeOptions(6);
        this.editText.setInputType(524289);
        this.wcPayKeyboard = KindaWcKeyboardHelpr.bind((UIPageFragmentActivity)this.mBaseFrActivity, this.editText, MMApplicationContext.getContext().getString(R.string.app_ok), this.mBaseFrActivity.mTenpayKBStateCallBackListener);
        this.editText.setOnEditorActionListener(new TextView.OnEditorActionListener()
        {
          public boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, android.view.KeyEvent paramAnonymousKeyEvent)
          {
            AppMethodBeat.i(226574);
            Log.d("MMKEditText", "on eidtor action: %s", new Object[] { paramAnonymousKeyEvent });
            if ((paramAnonymousKeyEvent.getAction() == 1) && (paramAnonymousKeyEvent.getKeyCode() == 66))
            {
              MMKEditText.this.editText.clearFocus();
              if (MMKEditText.this.mKEditTextOnEditorActionCallback != null)
              {
                paramAnonymousTextView = com.tencent.kinda.gen.KeyEvent.ENTER;
                MMKEditText.this.mKEditTextOnEditorActionCallback.onEditorAction(paramAnonymousTextView);
              }
            }
            AppMethodBeat.o(226574);
            return true;
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
  
  public void setOnEditorActionCallback(KEditTextOnEditorActionCallback paramKEditTextOnEditorActionCallback)
  {
    this.mKEditTextOnEditorActionCallback = paramKEditTextOnEditorActionCallback;
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
  
  public void setRestrictType(EditTextRestrictType paramEditTextRestrictType)
  {
    AppMethodBeat.i(226659);
    this.mRestriceType = paramEditTextRestrictType;
    if (this.mRestriceType == EditTextRestrictType.MONEY) {
      this.editText.addTextChangedListener(new TextWatcher()
      {
        public void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(226581);
          if (paramAnonymousEditable.toString().startsWith(".")) {
            paramAnonymousEditable.insert(0, "0");
          }
          paramAnonymousEditable = paramAnonymousEditable.toString();
          int i = paramAnonymousEditable.indexOf(".");
          int j = paramAnonymousEditable.length();
          if ((i >= 0) && (j - i > 3))
          {
            WalletFormView.a(MMKEditText.this.editText, paramAnonymousEditable, i + 3, j);
            AppMethodBeat.o(226581);
            return;
          }
          if (i > 12)
          {
            WalletFormView.a(MMKEditText.this.editText, paramAnonymousEditable, 12, i);
            AppMethodBeat.o(226581);
            return;
          }
          if ((i == -1) && (j > 10))
          {
            WalletFormView.a(MMKEditText.this.editText, paramAnonymousEditable, 10, j);
            AppMethodBeat.o(226581);
            return;
          }
          if (!MMKEditText.this.editText.isMoneyAmount())
          {
            WalletFormView.a(MMKEditText.this.editText, paramAnonymousEditable, paramAnonymousEditable.length() - 1, paramAnonymousEditable.length());
            AppMethodBeat.o(226581);
            return;
          }
          if ((paramAnonymousEditable.length() > 1) && (paramAnonymousEditable.startsWith("0")) && (i == -1)) {
            WalletFormView.a(MMKEditText.this.editText, paramAnonymousEditable, 0, 1);
          }
          AppMethodBeat.o(226581);
        }
        
        public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
    }
    AppMethodBeat.o(226659);
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
    Log.d("base_MMKView", "MMKLabelView setText ".concat(String.valueOf(paramString)));
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
      switch (10.$SwitchMap$com$tencent$kinda$gen$TextAlign[this.textAlign.ordinal()])
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
    int i;
    if (!Util.isNullOrNil(paramString)) {
      if (paramString.equalsIgnoreCase("WeChat-Sans-SS-Light")) {
        i = 2;
      }
    }
    for (;;)
    {
      if (i != -1)
      {
        paramString = i.aGy(i);
        try
        {
          this.editText.setTypeface(Typeface.createFromAsset(MMApplicationContext.getContext().getAssets(), paramString));
          notifyChanged();
          AppMethodBeat.o(19027);
          return;
        }
        catch (Exception paramString)
        {
          Log.e("base_MMKView", "setTypeface() Exception:%s %s", new Object[] { paramString.getClass().getSimpleName(), paramString.getMessage() });
        }
        if (paramString.equalsIgnoreCase("WeChat-Sans-SS-Medium"))
        {
          i = 0;
          continue;
        }
        if (paramString.equalsIgnoreCase("WeChat-Sans-SS-Regular"))
        {
          i = 3;
          continue;
        }
        if (!paramString.equalsIgnoreCase("WeChat-Sans-SS-Bold")) {
          break label146;
        }
        i = 1;
        continue;
      }
      AppMethodBeat.o(19027);
      return;
      label146:
      i = -1;
    }
  }
  
  public void setTextSize(float paramFloat)
  {
    AppMethodBeat.i(19025);
    if (paramFloat > 0.0F)
    {
      float f = 1.0F;
      if (getSupportDynamicSize()) {
        f = MMKViewUtil.getScaleSize(MMApplicationContext.getContext());
      }
      this.textSize = (f * paramFloat);
      this.editText.setTextSize(1, this.textSize);
      notifyChanged();
    }
    AppMethodBeat.o(19025);
  }
  
  public void setTintColor(DynamicColor paramDynamicColor) {}
  
  public void setViewId(String paramString)
  {
    AppMethodBeat.i(226615);
    super.setViewId(paramString);
    if (this.iconImageView != null) {
      MMKViewUtil.setId4KindaImplView(this.mContext, paramString + "_btn", this.iconImageView);
    }
    AppMethodBeat.o(226615);
  }
  
  public void setVisibleClearIcon(boolean paramBoolean)
  {
    AppMethodBeat.i(170125);
    if ((paramBoolean) && (this.editText.getText().length() > 0))
    {
      setIconVisibility(0);
      AppMethodBeat.o(170125);
      return;
    }
    setIconVisibility(4);
    AppMethodBeat.o(170125);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKEditText
 * JD-Core Version:    0.7.0.1
 */