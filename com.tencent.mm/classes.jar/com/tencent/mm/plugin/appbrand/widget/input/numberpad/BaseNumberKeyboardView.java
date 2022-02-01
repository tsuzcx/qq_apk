package com.tencent.mm.plugin.appbrand.widget.input.numberpad;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

public class BaseNumberKeyboardView
  extends LinearLayout
{
  public View jBN;
  private Context mContext;
  private EditText mInputEditText;
  public Button mKey0;
  public Button mKey1;
  public Button mKey2;
  public Button mKey3;
  public Button mKey4;
  public Button mKey5;
  public Button mKey6;
  public Button mKey7;
  public Button mKey8;
  public Button mKey9;
  public Button mKeyX;
  private int mXMode;
  public boolean orS;
  public ImageButton owM;
  
  public BaseNumberKeyboardView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(136679);
    this.mXMode = 0;
    init(paramContext);
    AppMethodBeat.o(136679);
  }
  
  public BaseNumberKeyboardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(136680);
    this.mXMode = 0;
    init(paramContext);
    AppMethodBeat.o(136680);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(136681);
    this.mContext = paramContext.getApplicationContext();
    this.jBN = LayoutInflater.from(paramContext).inflate(2131493144, this, true);
    this.mKey1 = ((Button)this.jBN.findViewById(getId("tenpay_keyboard_1")));
    this.mKey2 = ((Button)this.jBN.findViewById(getId("tenpay_keyboard_2")));
    this.mKey3 = ((Button)this.jBN.findViewById(getId("tenpay_keyboard_3")));
    this.mKey4 = ((Button)this.jBN.findViewById(getId("tenpay_keyboard_4")));
    this.mKey5 = ((Button)this.jBN.findViewById(getId("tenpay_keyboard_5")));
    this.mKey6 = ((Button)this.jBN.findViewById(getId("tenpay_keyboard_6")));
    this.mKey7 = ((Button)this.jBN.findViewById(getId("tenpay_keyboard_7")));
    this.mKey8 = ((Button)this.jBN.findViewById(getId("tenpay_keyboard_8")));
    this.mKey9 = ((Button)this.jBN.findViewById(getId("tenpay_keyboard_9")));
    this.mKeyX = ((Button)this.jBN.findViewById(getId("tenpay_keyboard_x")));
    this.mKey0 = ((Button)this.jBN.findViewById(getId("tenpay_keyboard_0")));
    this.owM = ((ImageButton)this.jBN.findViewById(getId("tenpay_keyboard_d")));
    paramContext = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(136678);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/appbrand/widget/input/numberpad/BaseNumberKeyboardView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (BaseNumberKeyboardView.a(BaseNumberKeyboardView.this) == null)
        {
          a.a(this, "com/tencent/mm/plugin/appbrand/widget/input/numberpad/BaseNumberKeyboardView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(136678);
          return;
        }
        if (paramAnonymousView.getId() == BaseNumberKeyboardView.this.getId("tenpay_keyboard_x"))
        {
          switch (BaseNumberKeyboardView.b(BaseNumberKeyboardView.this))
          {
          }
          for (;;)
          {
            a.a(this, "com/tencent/mm/plugin/appbrand/widget/input/numberpad/BaseNumberKeyboardView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(136678);
            return;
            BaseNumberKeyboardView.a(BaseNumberKeyboardView.this).dispatchKeyEvent(new KeyEvent(0, 59));
            BaseNumberKeyboardView.a(BaseNumberKeyboardView.this).dispatchKeyEvent(new KeyEvent(0, 52));
            BaseNumberKeyboardView.a(BaseNumberKeyboardView.this).dispatchKeyEvent(new KeyEvent(1, 59));
            continue;
            BaseNumberKeyboardView.a(BaseNumberKeyboardView.this).dispatchKeyEvent(new KeyEvent(0, 56));
          }
        }
        int i;
        if (paramAnonymousView.getId() == BaseNumberKeyboardView.this.getId("tenpay_keyboard_1")) {
          i = 8;
        }
        for (;;)
        {
          BaseNumberKeyboardView.a(BaseNumberKeyboardView.this).dispatchKeyEvent(new KeyEvent(0, i));
          BaseNumberKeyboardView.a(BaseNumberKeyboardView.this).dispatchKeyEvent(new KeyEvent(1, i));
          a.a(this, "com/tencent/mm/plugin/appbrand/widget/input/numberpad/BaseNumberKeyboardView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(136678);
          return;
          if (paramAnonymousView.getId() == BaseNumberKeyboardView.this.getId("tenpay_keyboard_2")) {
            i = 9;
          } else if (paramAnonymousView.getId() == BaseNumberKeyboardView.this.getId("tenpay_keyboard_3")) {
            i = 10;
          } else if (paramAnonymousView.getId() == BaseNumberKeyboardView.this.getId("tenpay_keyboard_4")) {
            i = 11;
          } else if (paramAnonymousView.getId() == BaseNumberKeyboardView.this.getId("tenpay_keyboard_5")) {
            i = 12;
          } else if (paramAnonymousView.getId() == BaseNumberKeyboardView.this.getId("tenpay_keyboard_6")) {
            i = 13;
          } else if (paramAnonymousView.getId() == BaseNumberKeyboardView.this.getId("tenpay_keyboard_7")) {
            i = 14;
          } else if (paramAnonymousView.getId() == BaseNumberKeyboardView.this.getId("tenpay_keyboard_8")) {
            i = 15;
          } else if (paramAnonymousView.getId() == BaseNumberKeyboardView.this.getId("tenpay_keyboard_9")) {
            i = 16;
          } else if (paramAnonymousView.getId() == BaseNumberKeyboardView.this.getId("tenpay_keyboard_0")) {
            i = 7;
          } else if (paramAnonymousView.getId() == BaseNumberKeyboardView.this.getId("tenpay_keyboard_d")) {
            i = 67;
          } else {
            i = 0;
          }
        }
      }
    };
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
      this.owM.setContentDescription("删除");
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
    this.owM.setOnClickListener(paramContext);
    AppMethodBeat.o(136681);
  }
  
  public final int getId(String paramString)
  {
    AppMethodBeat.i(136685);
    int i = this.mContext.getResources().getIdentifier(paramString, "id", this.mContext.getPackageName());
    AppMethodBeat.o(136685);
    return i;
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(136686);
    super.onDetachedFromWindow();
    AppMethodBeat.o(136686);
  }
  
  public void setInputEditText(EditText paramEditText)
  {
    AppMethodBeat.i(136683);
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
      AppMethodBeat.o(136683);
      return;
      this.mXMode = 0;
      if (TextUtils.isEmpty(paramEditText)) {
        this.mKeyX.setText("");
      }
    }
  }
  
  public void setSecureAccessibility(View.AccessibilityDelegate paramAccessibilityDelegate)
  {
    AppMethodBeat.i(136682);
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
    this.owM.setAccessibilityDelegate(paramAccessibilityDelegate);
    AppMethodBeat.o(136682);
  }
  
  public void setXMode(int paramInt)
  {
    AppMethodBeat.i(136684);
    this.mXMode = paramInt;
    switch (paramInt)
    {
    default: 
      this.mXMode = 0;
      AppMethodBeat.o(136684);
      return;
    case 0: 
      this.mKeyX.setText("");
      if (this.orS)
      {
        this.mKeyX.setBackgroundResource(2131100000);
        AppMethodBeat.o(136684);
        return;
      }
      this.mKeyX.setBackgroundResource(2131099997);
      AppMethodBeat.o(136684);
      return;
    case 1: 
      this.mKeyX.setText("X");
      if (this.orS)
      {
        this.mKeyX.setBackgroundResource(2131235232);
        AppMethodBeat.o(136684);
        return;
      }
      this.mKeyX.setBackgroundResource(2131235231);
      AppMethodBeat.o(136684);
      return;
    }
    this.mKeyX.setText(".");
    if (this.orS)
    {
      this.mKeyX.setBackgroundResource(2131235232);
      AppMethodBeat.o(136684);
      return;
    }
    this.mKeyX.setBackgroundResource(2131235231);
    AppMethodBeat.o(136684);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.numberpad.BaseNumberKeyboardView
 * JD-Core Version:    0.7.0.1
 */