package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputConnection;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.input.numberpad.BaseNumberKeyboardView;
import com.tencent.mm.plugin.appbrand.widget.input.numberpad.a;
import com.tencent.mm.sdk.platformtools.ac;

public final class AppBrandNumberKeyboardView
  extends BaseNumberKeyboardView
{
  private int mEH;
  private final SparseArray<String> mEI;
  InputConnection mEJ;
  a mEK;
  
  public AppBrandNumberKeyboardView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(136495);
    this.mEH = 0;
    this.mEI = new SparseArray() {};
    init();
    AppMethodBeat.o(136495);
  }
  
  public AppBrandNumberKeyboardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(136496);
    this.mEH = 0;
    this.mEI = new SparseArray() {};
    init();
    AppMethodBeat.o(136496);
  }
  
  private void init()
  {
    AppMethodBeat.i(136497);
    View.OnClickListener local2 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(136492);
        if (AppBrandNumberKeyboardView.a(AppBrandNumberKeyboardView.this) == null)
        {
          AppMethodBeat.o(136492);
          return;
        }
        String str1 = null;
        String str2;
        if (paramAnonymousView.getId() == AppBrandNumberKeyboardView.a(AppBrandNumberKeyboardView.this, "tenpay_keyboard_x")) {
          switch (AppBrandNumberKeyboardView.b(AppBrandNumberKeyboardView.this))
          {
          default: 
            AppMethodBeat.o(136492);
            return;
          case 1: 
            str2 = "X";
          }
        }
        int i;
        while (TextUtils.isEmpty(str2))
        {
          AppMethodBeat.o(136492);
          return;
          str2 = ".";
          continue;
          i = 0;
          str2 = str1;
          if (i < AppBrandNumberKeyboardView.c(AppBrandNumberKeyboardView.this).size())
          {
            int j = AppBrandNumberKeyboardView.b(AppBrandNumberKeyboardView.this, (String)AppBrandNumberKeyboardView.c(AppBrandNumberKeyboardView.this).valueAt(i));
            if (paramAnonymousView.getId() != j) {
              break label200;
            }
            str1 = String.valueOf(AppBrandNumberKeyboardView.c(AppBrandNumberKeyboardView.this).keyAt(i));
          }
        }
        label200:
        for (;;)
        {
          i += 1;
          break;
          AppBrandNumberKeyboardView.a(AppBrandNumberKeyboardView.this).commitText(str2, str2.length());
          AppMethodBeat.o(136492);
          return;
        }
      }
    };
    int i = 0;
    while (i < this.mEI.size())
    {
      findViewById(getId((String)this.mEI.valueAt(i))).setOnClickListener(local2);
      i += 1;
    }
    findViewById(getId("tenpay_keyboard_x")).setOnClickListener(local2);
    findViewById(getId("tenpay_keyboard_d")).setOnClickListener(null);
    findViewById(getId("tenpay_keyboard_d")).setOnTouchListener(new an()
    {
      protected final void bAw()
      {
        AppMethodBeat.i(136494);
        ac.d("MicroMsg.AppBrand.AppBrandNumberKeyboardView", "backspace onRepeat");
        AppBrandNumberKeyboardView.d(AppBrandNumberKeyboardView.this);
        AppMethodBeat.o(136494);
      }
      
      protected final void bjj()
      {
        AppMethodBeat.i(136493);
        ac.d("MicroMsg.AppBrand.AppBrandNumberKeyboardView", "backspace onSingleTap");
        AppBrandNumberKeyboardView.d(AppBrandNumberKeyboardView.this);
        AppMethodBeat.o(136493);
      }
    });
    AppMethodBeat.o(136497);
  }
  
  public final void onDetachedFromWindow()
  {
    AppMethodBeat.i(136499);
    super.onDetachedFromWindow();
    setInputEditText(null);
    AppMethodBeat.o(136499);
  }
  
  public final void setXMode(int paramInt)
  {
    AppMethodBeat.i(136498);
    super.setXMode(paramInt);
    this.mEH = paramInt;
    AppMethodBeat.o(136498);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.AppBrandNumberKeyboardView
 * JD-Core Version:    0.7.0.1
 */