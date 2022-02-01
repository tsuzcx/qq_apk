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
import com.tencent.luggage.wxa.b.a.c;
import com.tencent.luggage.wxa.b.a.d;
import com.tencent.luggage.wxa.b.a.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

public class BaseNumberKeyboardView
  extends LinearLayout
{
  private Context mContext;
  private EditText mInputEditText;
  private int mXMode;
  public View plc;
  public boolean uFg;
  public Button uKJ;
  public Button uKK;
  public Button uKL;
  public Button uKM;
  public Button uKN;
  public Button uKO;
  public Button uKP;
  public Button uKQ;
  public Button uKR;
  public Button uKS;
  public Button uKT;
  public ImageButton uKU;
  
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
    this.plc = LayoutInflater.from(paramContext).inflate(a.f.appbrand_number_keyboard, this, true);
    this.uKJ = ((Button)this.plc.findViewById(getId("tenpay_keyboard_1")));
    this.uKK = ((Button)this.plc.findViewById(getId("tenpay_keyboard_2")));
    this.uKL = ((Button)this.plc.findViewById(getId("tenpay_keyboard_3")));
    this.uKM = ((Button)this.plc.findViewById(getId("tenpay_keyboard_4")));
    this.uKN = ((Button)this.plc.findViewById(getId("tenpay_keyboard_5")));
    this.uKO = ((Button)this.plc.findViewById(getId("tenpay_keyboard_6")));
    this.uKP = ((Button)this.plc.findViewById(getId("tenpay_keyboard_7")));
    this.uKQ = ((Button)this.plc.findViewById(getId("tenpay_keyboard_8")));
    this.uKR = ((Button)this.plc.findViewById(getId("tenpay_keyboard_9")));
    this.uKS = ((Button)this.plc.findViewById(getId("tenpay_keyboard_x")));
    this.uKT = ((Button)this.plc.findViewById(getId("tenpay_keyboard_0")));
    this.uKU = ((ImageButton)this.plc.findViewById(getId("tenpay_keyboard_d")));
    paramContext = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(136678);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/appbrand/widget/input/numberpad/BaseNumberKeyboardView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
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
      this.uKJ.setContentDescription("1");
      this.uKK.setContentDescription("2");
      this.uKL.setContentDescription("3");
      this.uKM.setContentDescription("4");
      this.uKN.setContentDescription("5");
      this.uKO.setContentDescription("6");
      this.uKP.setContentDescription("7");
      this.uKQ.setContentDescription("8");
      this.uKR.setContentDescription("9");
      this.uKT.setContentDescription("0");
      this.uKS.setContentDescription("字母X");
      this.uKU.setContentDescription("删除");
    }
    this.uKJ.setOnClickListener(paramContext);
    this.uKK.setOnClickListener(paramContext);
    this.uKL.setOnClickListener(paramContext);
    this.uKM.setOnClickListener(paramContext);
    this.uKN.setOnClickListener(paramContext);
    this.uKO.setOnClickListener(paramContext);
    this.uKP.setOnClickListener(paramContext);
    this.uKQ.setOnClickListener(paramContext);
    this.uKR.setOnClickListener(paramContext);
    this.uKS.setOnClickListener(paramContext);
    this.uKT.setOnClickListener(paramContext);
    this.uKU.setOnClickListener(paramContext);
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
        this.uKS.setText(paramEditText);
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
        this.uKS.setText("");
      }
    }
  }
  
  public void setSecureAccessibility(View.AccessibilityDelegate paramAccessibilityDelegate)
  {
    AppMethodBeat.i(136682);
    this.uKT.setAccessibilityDelegate(paramAccessibilityDelegate);
    this.uKJ.setAccessibilityDelegate(paramAccessibilityDelegate);
    this.uKK.setAccessibilityDelegate(paramAccessibilityDelegate);
    this.uKL.setAccessibilityDelegate(paramAccessibilityDelegate);
    this.uKM.setAccessibilityDelegate(paramAccessibilityDelegate);
    this.uKN.setAccessibilityDelegate(paramAccessibilityDelegate);
    this.uKO.setAccessibilityDelegate(paramAccessibilityDelegate);
    this.uKP.setAccessibilityDelegate(paramAccessibilityDelegate);
    this.uKQ.setAccessibilityDelegate(paramAccessibilityDelegate);
    this.uKR.setAccessibilityDelegate(paramAccessibilityDelegate);
    this.uKS.setAccessibilityDelegate(paramAccessibilityDelegate);
    this.uKU.setAccessibilityDelegate(paramAccessibilityDelegate);
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
      this.uKS.setText("");
      if (this.uFg)
      {
        this.uKS.setBackgroundResource(a.c.appbrand_keyboard_bottom_left_right_light);
        AppMethodBeat.o(136684);
        return;
      }
      this.uKS.setBackgroundResource(a.c.appbrand_keyboard_bottom_left_right);
      AppMethodBeat.o(136684);
      return;
    case 1: 
      this.uKS.setText("X");
      if (this.uFg)
      {
        this.uKS.setBackgroundResource(a.d.tenpay_keybtn_bottom_left_right_force_light);
        AppMethodBeat.o(136684);
        return;
      }
      this.uKS.setBackgroundResource(a.d.tenpay_keybtn_bottom_left_right);
      AppMethodBeat.o(136684);
      return;
    }
    this.uKS.setText(".");
    if (this.uFg)
    {
      this.uKS.setBackgroundResource(a.d.tenpay_keybtn_bottom_left_right_force_light);
      AppMethodBeat.o(136684);
      return;
    }
    this.uKS.setBackgroundResource(a.d.tenpay_keybtn_bottom_left_right);
    AppMethodBeat.o(136684);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.numberpad.BaseNumberKeyboardView
 * JD-Core Version:    0.7.0.1
 */