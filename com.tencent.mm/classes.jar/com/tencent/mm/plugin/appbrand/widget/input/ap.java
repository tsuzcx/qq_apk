package com.tencent.mm.plugin.appbrand.widget.input;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.LinearLayout;
import androidx.lifecycle.h;
import androidx.lifecycle.k;
import androidx.lifecycle.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.sdk.platformtools.Log;

final class ap
{
  private Activity activity;
  private boolean dic;
  ao rxZ;
  View rya;
  private Rect ryb;
  Rect ryc;
  View ryd;
  private k rye;
  private ViewTreeObserver.OnGlobalLayoutListener ryf;
  private ViewTreeObserver.OnGlobalLayoutListener ryg;
  private boolean ryh;
  private int ryi;
  private int ryj;
  private int ryk;
  private int ryl;
  
  ap(Activity paramActivity)
  {
    AppMethodBeat.i(230069);
    this.ryb = new Rect();
    this.ryc = new Rect();
    this.dic = false;
    this.ryh = true;
    this.activity = paramActivity;
    cpj();
    this.ryd = paramActivity.findViewById(16908290);
    this.ryf = new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(230743);
        if (ap.this.rya != null) {
          ap.a(ap.this);
        }
        AppMethodBeat.o(230743);
      }
    };
    this.ryg = new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(230951);
        if (ap.this.rya != null)
        {
          int i = ap.this.ryc.bottom;
          ap.this.ryd.getWindowVisibleDisplayFrame(ap.this.ryc);
          if (ap.this.ryc.bottom != i)
          {
            Log.i("MicroMsg.KeyboardHeightProvider", "onGlobalLayout: %s, %s", new Object[] { Integer.valueOf(i), ap.this.ryc.toShortString() });
            ap.a(ap.this);
          }
        }
        AppMethodBeat.o(230951);
      }
    };
    int i = Resources.getSystem().getIdentifier("navigation_bar_height", "dimen", "android");
    if (i > 0) {
      this.ryk = Resources.getSystem().getDimensionPixelSize(i);
    }
    this.ryl = a.fromDPToPix(paramActivity, 96);
    AppMethodBeat.o(230069);
  }
  
  private void cpj()
  {
    AppMethodBeat.i(230076);
    if ((this.activity.getWindow().getAttributes().softInputMode & 0xF0) != 48)
    {
      Log.w("MicroMsg.KeyboardHeightProvider", "activity soft input should be adjust nothing");
      this.ryh = false;
      AppMethodBeat.o(230076);
      return;
    }
    this.ryh = true;
    AppMethodBeat.o(230076);
  }
  
  public final void close()
  {
    AppMethodBeat.i(230073);
    Log.i("MicroMsg.KeyboardHeightProvider", "close: ");
    this.ryd.getViewTreeObserver().removeOnGlobalLayoutListener(this.ryg);
    if ((this.dic) && (this.rya != null)) {
      this.rya.getViewTreeObserver().removeOnGlobalLayoutListener(this.ryf);
    }
    try
    {
      this.activity.getWindowManager().removeView(this.rya);
      this.rya = null;
      this.dic = false;
      AppMethodBeat.o(230073);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.KeyboardHeightProvider", localException, "", new Object[0]);
      }
    }
  }
  
  final void cpk()
  {
    AppMethodBeat.i(230081);
    if ((this.activity instanceof l))
    {
      h localh = ((l)this.activity).getLifecycle();
      KeyboardHeightProvider.3 local3 = new KeyboardHeightProvider.3(this);
      this.rye = local3;
      localh.a(local3);
    }
    AppMethodBeat.o(230081);
  }
  
  final void cpl()
  {
    AppMethodBeat.i(230082);
    if ((this.rye != null) && ((this.activity instanceof l))) {
      ((l)this.activity).getLifecycle().b(this.rye);
    }
    AppMethodBeat.o(230082);
  }
  
  public final void start()
  {
    AppMethodBeat.i(230071);
    cpj();
    if (this.ryd != null)
    {
      Log.i("MicroMsg.KeyboardHeightProvider", "start: %s, %s", new Object[] { Boolean.valueOf(this.dic), this.ryd.getWindowToken() });
      if ((!this.dic) && (this.ryd.getWindowToken() != null) && (!this.activity.isFinishing()))
      {
        this.dic = true;
        this.rya = new LinearLayout(this.activity);
        this.rya.setBackgroundColor(0);
        WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams(1003, 131096, 1);
        localLayoutParams.width = 0;
        localLayoutParams.height = -1;
        localLayoutParams.gravity = 8388659;
        localLayoutParams.softInputMode = 16;
        localLayoutParams.setTitle("KeyboardWindow@" + hashCode());
        try
        {
          this.activity.getWindowManager().addView(this.rya, localLayoutParams);
          if (this.dic)
          {
            this.rya.getViewTreeObserver().addOnGlobalLayoutListener(this.ryf);
            this.ryd.getViewTreeObserver().addOnGlobalLayoutListener(this.ryg);
          }
          this.ryi = 0;
          this.ryj = 0;
          if ((this.activity.getWindow().getAttributes().softInputMode & 0xF0) != 48)
          {
            Log.w("MicroMsg.KeyboardHeightProvider", "start: activity soft input should be adjust nothing");
            this.ryh = false;
            AppMethodBeat.o(230071);
            return;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.KeyboardHeightProvider", localException, "", new Object[0]);
            this.dic = false;
            this.rya = null;
          }
          this.ryh = true;
        }
      }
    }
    AppMethodBeat.o(230071);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.ap
 * JD-Core Version:    0.7.0.1
 */