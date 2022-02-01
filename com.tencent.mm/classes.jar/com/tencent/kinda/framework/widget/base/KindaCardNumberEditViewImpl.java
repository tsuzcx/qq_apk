package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import com.tencent.kinda.framework.R.drawable;
import com.tencent.kinda.framework.R.id;
import com.tencent.kinda.framework.R.raw;
import com.tencent.kinda.framework.widget.tools.ColorUtil;
import com.tencent.kinda.framework.widget.tools.MMKViewUtil;
import com.tencent.kinda.gen.DynamicColor;
import com.tencent.kinda.gen.KCardNumberEditView;
import com.tencent.kinda.gen.KCardNumberEditViewOnTextChangedCallback;
import com.tencent.kinda.gen.KViewOnClickCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.aw;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.ui.g;
import com.tenpay.android.wechat.TenpaySecureEditText;
import com.tenpay.android.wechat.TenpaySecureEditText.IKindaEditTextCallBackListener;

public class KindaCardNumberEditViewImpl
  extends MMKView<TenpaySecureEditText>
  implements KCardNumberEditView
{
  private TenpaySecureEditText cardNumberView;
  private DynamicColor hintColor;
  private KCardNumberEditViewOnTextChangedCallback m_callback;
  private DynamicColor normalColor;
  
  public KindaCardNumberEditViewImpl()
  {
    AppMethodBeat.i(18874);
    this.cardNumberView = null;
    this.normalColor = new DynamicColor(-1L, 0L);
    this.hintColor = new DynamicColor(-1L, 0L);
    AppMethodBeat.o(18874);
  }
  
  public TenpaySecureEditText createView(Context paramContext)
  {
    AppMethodBeat.i(18875);
    this.cardNumberView = new TenpaySecureEditText(paramContext);
    this.cardNumberView.setIsBankcardFormat(true);
    this.cardNumberView.setBackground(null);
    this.cardNumberView.setInputType(131072);
    this.cardNumberView.setSingleLine(false);
    this.cardNumberView.setTextSize(0, MMKViewUtil.dpToPx(MMApplicationContext.getContext(), 17.0F));
    this.cardNumberView.setPadding(0, 0, aw.fromDPToPix(paramContext, 4), 0);
    this.cardNumberView.setCursorStyle(R.drawable.green_cursor);
    this.cardNumberView.setregExFilterInput("[^0-9]");
    if (ColorUtil.ifCompatKindaDarkModeDefaultColor()) {
      this.cardNumberView.setClearBtnDrawableId(R.raw.kinda_actionbar_icon_light_clear, 0, 16, 16);
    }
    for (;;)
    {
      TenpaySecureEditText.setSalt(g.ijw());
      this.cardNumberView.setFilters(new InputFilter[] { new InputFilter.LengthFilter(24) });
      this.cardNumberView.addTextChangedListener(new TextWatcher()
      {
        public void afterTextChanged(Editable paramAnonymousEditable) {}
        
        public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(18873);
          if (KindaCardNumberEditViewImpl.this.m_callback != null)
          {
            paramAnonymousCharSequence = KindaCardNumberEditViewImpl.this.m_callback;
            TenpaySecureEditText localTenpaySecureEditText = KindaCardNumberEditViewImpl.this.cardNumberView;
            b.iie();
            paramAnonymousCharSequence.onTextChanged(localTenpaySecureEditText.getEncryptDataWithHash(false, b.iif()));
          }
          AppMethodBeat.o(18873);
        }
      });
      if ((paramContext instanceof BaseFrActivity)) {
        ((BaseFrActivity)paramContext).setEditFocusListener(this.cardNumberView, 0, false);
      }
      this.cardNumberView.setId(R.id.kinda_bank_card_input);
      this.cardNumberView.setKindaEditTextCallBackListener(new TenpaySecureEditText.IKindaEditTextCallBackListener()
      {
        public void onCallBackKinda()
        {
          AppMethodBeat.i(264908);
          KViewOnClickCallback localKViewOnClickCallback = KindaCardNumberEditViewImpl.this.getOnClickCallback();
          if (localKViewOnClickCallback != null) {
            localKViewOnClickCallback.onClick(KindaCardNumberEditViewImpl.this);
          }
          AppMethodBeat.o(264908);
        }
      });
      paramContext = this.cardNumberView;
      AppMethodBeat.o(18875);
      return paramContext;
      this.cardNumberView.setClearBtnDrawableId(R.raw.kinda_actionbar_icon_dark_clear, 0, 16, 16);
    }
  }
  
  public boolean getFocus()
  {
    AppMethodBeat.i(18882);
    boolean bool = this.cardNumberView.isFocused();
    AppMethodBeat.o(18882);
    return bool;
  }
  
  public String getHint()
  {
    AppMethodBeat.i(18884);
    String str = this.cardNumberView.getHint().toString();
    AppMethodBeat.o(18884);
    return str;
  }
  
  public DynamicColor getHintColor()
  {
    return this.hintColor;
  }
  
  public int getInputTextLength()
  {
    AppMethodBeat.i(18878);
    int i = this.cardNumberView.getInputLength();
    AppMethodBeat.o(18878);
    return i;
  }
  
  public DynamicColor getTextColor()
  {
    return this.normalColor;
  }
  
  public String getValue()
  {
    AppMethodBeat.i(18876);
    Object localObject = this.cardNumberView;
    b.iie();
    localObject = ((TenpaySecureEditText)localObject).getEncryptDataWithHash(false, b.iif());
    AppMethodBeat.o(18876);
    return localObject;
  }
  
  public boolean isBankCardNumber()
  {
    AppMethodBeat.i(18877);
    boolean bool = this.cardNumberView.isBankcardNum();
    AppMethodBeat.o(18877);
    return bool;
  }
  
  public void setFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(18881);
    if ((paramBoolean) && (this.cardNumberView.isFocused())) {
      this.cardNumberView.clearFocus();
    }
    if (paramBoolean)
    {
      this.cardNumberView.requestFocus();
      AppMethodBeat.o(18881);
      return;
    }
    this.cardNumberView.clearFocus();
    AppMethodBeat.o(18881);
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(18883);
    this.cardNumberView.setHint(paramString);
    AppMethodBeat.o(18883);
  }
  
  public void setHintColor(DynamicColor paramDynamicColor)
  {
    AppMethodBeat.i(18885);
    if (ColorUtil.getColorByModeNoCompat(this.hintColor) != ColorUtil.getColorByMode(paramDynamicColor)) {
      this.hintColor = paramDynamicColor;
    }
    this.cardNumberView.setHintTextColor((int)ColorUtil.getColorByModeNoCompat(this.hintColor));
    AppMethodBeat.o(18885);
  }
  
  public void setOnTextChangedCallback(KCardNumberEditViewOnTextChangedCallback paramKCardNumberEditViewOnTextChangedCallback)
  {
    this.m_callback = paramKCardNumberEditViewOnTextChangedCallback;
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(18879);
    this.cardNumberView.setText(paramString);
    this.cardNumberView.setSelection(this.cardNumberView.getText().toString().length());
    this.cardNumberView.clearFocus();
    AppMethodBeat.o(18879);
  }
  
  public void setTextColor(DynamicColor paramDynamicColor)
  {
    AppMethodBeat.i(18880);
    if (ColorUtil.getColorByModeNoCompat(this.normalColor) != ColorUtil.getColorByMode(paramDynamicColor)) {
      this.normalColor = paramDynamicColor;
    }
    this.cardNumberView.setTextColor((int)ColorUtil.getColorByModeNoCompat(this.normalColor));
    AppMethodBeat.o(18880);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KindaCardNumberEditViewImpl
 * JD-Core Version:    0.7.0.1
 */