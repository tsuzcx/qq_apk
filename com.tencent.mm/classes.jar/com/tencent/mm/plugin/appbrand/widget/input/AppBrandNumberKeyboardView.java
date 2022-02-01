package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputConnection;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.widget.input.numberpad.BaseNumberKeyboardView;
import com.tencent.mm.sdk.platformtools.Log;

public final class AppBrandNumberKeyboardView
  extends BaseNumberKeyboardView
{
  private int rwg;
  private final SparseArray<String> rwh;
  InputConnection rwi;
  com.tencent.mm.plugin.appbrand.widget.input.numberpad.a rwj;
  
  public AppBrandNumberKeyboardView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(136495);
    this.rwg = 0;
    this.rwh = new SparseArray() {};
    init();
    AppMethodBeat.o(136495);
  }
  
  public AppBrandNumberKeyboardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(136496);
    this.rwg = 0;
    this.rwh = new SparseArray() {};
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
        Object localObject1 = new b();
        ((b)localObject1).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/widget/input/AppBrandNumberKeyboardView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).aFi());
        if (AppBrandNumberKeyboardView.a(AppBrandNumberKeyboardView.this) == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/input/AppBrandNumberKeyboardView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(136492);
          return;
        }
        localObject1 = null;
        Object localObject2;
        if (paramAnonymousView.getId() == AppBrandNumberKeyboardView.a(AppBrandNumberKeyboardView.this, "tenpay_keyboard_x")) {
          switch (AppBrandNumberKeyboardView.b(AppBrandNumberKeyboardView.this))
          {
          default: 
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/input/AppBrandNumberKeyboardView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(136492);
            return;
          case 1: 
            localObject2 = "X";
          }
        }
        int i;
        while (TextUtils.isEmpty((CharSequence)localObject2))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/input/AppBrandNumberKeyboardView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(136492);
          return;
          localObject2 = ".";
          continue;
          i = 0;
          localObject2 = localObject1;
          if (i < AppBrandNumberKeyboardView.c(AppBrandNumberKeyboardView.this).size())
          {
            int j = AppBrandNumberKeyboardView.b(AppBrandNumberKeyboardView.this, (String)AppBrandNumberKeyboardView.c(AppBrandNumberKeyboardView.this).valueAt(i));
            if (paramAnonymousView.getId() != j) {
              break label280;
            }
            localObject1 = String.valueOf(AppBrandNumberKeyboardView.c(AppBrandNumberKeyboardView.this).keyAt(i));
          }
        }
        label280:
        for (;;)
        {
          i += 1;
          break;
          AppBrandNumberKeyboardView.a(AppBrandNumberKeyboardView.this).commitText((CharSequence)localObject2, ((CharSequence)localObject2).length());
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/input/AppBrandNumberKeyboardView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(136492);
          return;
        }
      }
    };
    int i = 0;
    while (i < this.rwh.size())
    {
      findViewById(getId((String)this.rwh.valueAt(i))).setOnClickListener(local2);
      i += 1;
    }
    findViewById(getId("tenpay_keyboard_x")).setOnClickListener(local2);
    findViewById(getId("tenpay_keyboard_d")).setOnClickListener(null);
    findViewById(getId("tenpay_keyboard_d")).setOnTouchListener(new as()
    {
      protected final void bUS()
      {
        AppMethodBeat.i(136493);
        Log.d("MicroMsg.AppBrand.AppBrandNumberKeyboardView", "backspace onSingleTap");
        AppBrandNumberKeyboardView.d(AppBrandNumberKeyboardView.this);
        AppMethodBeat.o(136493);
      }
      
      protected final void coP()
      {
        AppMethodBeat.i(136494);
        Log.d("MicroMsg.AppBrand.AppBrandNumberKeyboardView", "backspace onRepeat");
        AppBrandNumberKeyboardView.d(AppBrandNumberKeyboardView.this);
        AppMethodBeat.o(136494);
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
    this.rwg = paramInt;
    AppMethodBeat.o(136498);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.AppBrandNumberKeyboardView
 * JD-Core Version:    0.7.0.1
 */