package com.tencent.mm.plugin.appbrand.widget.input.numberpad;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class BaseNumberKeyboardView
  extends LinearLayout
{
  private Context mContext;
  private EditText mInputEditText;
  private Button mKey0;
  private Button mKey1;
  private Button mKey2;
  private Button mKey3;
  private Button mKey4;
  private Button mKey5;
  private Button mKey6;
  private Button mKey7;
  private Button mKey8;
  private Button mKey9;
  private ImageButton mKeyD;
  private Button mKeyX;
  private int mXMode;
  
  public BaseNumberKeyboardView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(123938);
    this.mXMode = 0;
    init(paramContext);
    AppMethodBeat.o(123938);
  }
  
  public BaseNumberKeyboardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(123939);
    this.mXMode = 0;
    init(paramContext);
    AppMethodBeat.o(123939);
  }
  
  private int getDrawableId(String paramString)
  {
    AppMethodBeat.i(123945);
    int i = this.mContext.getResources().getIdentifier(paramString, "drawable", this.mContext.getPackageName());
    AppMethodBeat.o(123945);
    return i;
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(123940);
    this.mContext = paramContext.getApplicationContext();
    paramContext = LayoutInflater.from(paramContext).inflate(2130968773, this, true);
    this.mKey1 = ((Button)paramContext.findViewById(getId("tenpay_keyboard_1")));
    this.mKey2 = ((Button)paramContext.findViewById(getId("tenpay_keyboard_2")));
    this.mKey3 = ((Button)paramContext.findViewById(getId("tenpay_keyboard_3")));
    this.mKey4 = ((Button)paramContext.findViewById(getId("tenpay_keyboard_4")));
    this.mKey5 = ((Button)paramContext.findViewById(getId("tenpay_keyboard_5")));
    this.mKey6 = ((Button)paramContext.findViewById(getId("tenpay_keyboard_6")));
    this.mKey7 = ((Button)paramContext.findViewById(getId("tenpay_keyboard_7")));
    this.mKey8 = ((Button)paramContext.findViewById(getId("tenpay_keyboard_8")));
    this.mKey9 = ((Button)paramContext.findViewById(getId("tenpay_keyboard_9")));
    this.mKeyX = ((Button)paramContext.findViewById(getId("tenpay_keyboard_x")));
    this.mKey0 = ((Button)paramContext.findViewById(getId("tenpay_keyboard_0")));
    this.mKeyD = ((ImageButton)paramContext.findViewById(getId("tenpay_keyboard_d")));
    paramContext = new BaseNumberKeyboardView.1(this);
    if (Build.VERSION.SDK_INT >= 14)
    {
      this.mKey1.setContentDescription("1");
      this.mKey2.setContentDescription("2");
      this.mKey3.setContentDescription("3");
      this.mKey4.setContentDescription("4");
      this.mKey5.setContentDescription("5");
      this.mKey6.setContentDescription("6");
      this.mKey7.setContentDescription("7");
      this.mKey8.setContentDescription("8");
      this.mKey9.setContentDescription("9");
      this.mKey0.setContentDescription("0");
      this.mKeyX.setContentDescription("字母X");
      this.mKeyD.setContentDescription("删除");
    }
    this.mKey1.setOnClickListener(paramContext);
    this.mKey2.setOnClickListener(paramContext);
    this.mKey3.setOnClickListener(paramContext);
    this.mKey4.setOnClickListener(paramContext);
    this.mKey5.setOnClickListener(paramContext);
    this.mKey6.setOnClickListener(paramContext);
    this.mKey7.setOnClickListener(paramContext);
    this.mKey8.setOnClickListener(paramContext);
    this.mKey9.setOnClickListener(paramContext);
    this.mKeyX.setOnClickListener(paramContext);
    this.mKey0.setOnClickListener(paramContext);
    this.mKeyD.setOnClickListener(paramContext);
    AppMethodBeat.o(123940);
  }
  
  public final int getId(String paramString)
  {
    AppMethodBeat.i(123944);
    int i = this.mContext.getResources().getIdentifier(paramString, "id", this.mContext.getPackageName());
    AppMethodBeat.o(123944);
    return i;
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(123946);
    super.onDetachedFromWindow();
    AppMethodBeat.o(123946);
  }
  
  public void setInputEditText(EditText paramEditText)
  {
    AppMethodBeat.i(123942);
    if (paramEditText != null)
    {
      this.mInputEditText = paramEditText;
      int i = this.mInputEditText.getImeOptions();
      paramEditText = this.mInputEditText.getImeActionLabel();
      if (!TextUtils.isEmpty(paramEditText)) {
        this.mKeyX.setText(paramEditText);
      }
      switch (i)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(123942);
      return;
      this.mXMode = 0;
      if (TextUtils.isEmpty(paramEditText)) {
        this.mKeyX.setText("");
      }
    }
  }
  
  public void setSecureAccessibility(View.AccessibilityDelegate paramAccessibilityDelegate)
  {
    AppMethodBeat.i(123941);
    this.mKey0.setAccessibilityDelegate(paramAccessibilityDelegate);
    this.mKey1.setAccessibilityDelegate(paramAccessibilityDelegate);
    this.mKey2.setAccessibilityDelegate(paramAccessibilityDelegate);
    this.mKey3.setAccessibilityDelegate(paramAccessibilityDelegate);
    this.mKey4.setAccessibilityDelegate(paramAccessibilityDelegate);
    this.mKey5.setAccessibilityDelegate(paramAccessibilityDelegate);
    this.mKey6.setAccessibilityDelegate(paramAccessibilityDelegate);
    this.mKey7.setAccessibilityDelegate(paramAccessibilityDelegate);
    this.mKey8.setAccessibilityDelegate(paramAccessibilityDelegate);
    this.mKey9.setAccessibilityDelegate(paramAccessibilityDelegate);
    this.mKeyX.setAccessibilityDelegate(paramAccessibilityDelegate);
    this.mKeyD.setAccessibilityDelegate(paramAccessibilityDelegate);
    AppMethodBeat.o(123941);
  }
  
  public void setXMode(int paramInt)
  {
    AppMethodBeat.i(123943);
    this.mXMode = paramInt;
    switch (paramInt)
    {
    default: 
      this.mXMode = 0;
      AppMethodBeat.o(123943);
      return;
    case 0: 
      this.mKeyX.setText("");
      this.mKeyX.setBackgroundResource(getDrawableId("tenpay_keyitem_bottom"));
      AppMethodBeat.o(123943);
      return;
    case 1: 
      this.mKeyX.setText("X");
      this.mKeyX.setBackgroundResource(getDrawableId("tenpay_keybtn_bottom"));
      AppMethodBeat.o(123943);
      return;
    }
    this.mKeyX.setText(".");
    this.mKeyX.setBackgroundResource(getDrawableId("tenpay_keybtn_bottom"));
    AppMethodBeat.o(123943);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.numberpad.BaseNumberKeyboardView
 * JD-Core Version:    0.7.0.1
 */