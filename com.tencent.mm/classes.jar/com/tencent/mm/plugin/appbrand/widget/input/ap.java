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
import androidx.lifecycle.j;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.Log;

final class ap
{
  private Activity activity;
  private boolean fhR;
  ao uJd;
  View uJe;
  private Rect uJf;
  Rect uJg;
  View uJh;
  private p uJi;
  private ViewTreeObserver.OnGlobalLayoutListener uJj;
  private ViewTreeObserver.OnGlobalLayoutListener uJk;
  private boolean uJl;
  private int uJm;
  private int uJn;
  private int uJo;
  private int uJp;
  
  ap(Activity paramActivity)
  {
    AppMethodBeat.i(324444);
    this.uJf = new Rect();
    this.uJg = new Rect();
    this.fhR = false;
    this.uJl = true;
    this.activity = paramActivity;
    cRM();
    this.uJh = paramActivity.findViewById(16908290);
    this.uJj = new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(324395);
        if (ap.this.uJe != null) {
          ap.a(ap.this);
        }
        AppMethodBeat.o(324395);
      }
    };
    this.uJk = new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(324424);
        if (ap.this.uJe != null)
        {
          int i = ap.this.uJg.bottom;
          ap.this.uJh.getWindowVisibleDisplayFrame(ap.this.uJg);
          if (ap.this.uJg.bottom != i)
          {
            Log.i("MicroMsg.KeyboardHeightProvider", "onGlobalLayout: %s, %s", new Object[] { Integer.valueOf(i), ap.this.uJg.toShortString() });
            ap.a(ap.this);
          }
        }
        AppMethodBeat.o(324424);
      }
    };
    int i = Resources.getSystem().getIdentifier("navigation_bar_height", "dimen", "android");
    if (i > 0) {
      this.uJo = Resources.getSystem().getDimensionPixelSize(i);
    }
    this.uJp = a.fromDPToPix(paramActivity, 96);
    AppMethodBeat.o(324444);
  }
  
  private void cRM()
  {
    AppMethodBeat.i(324447);
    if ((this.activity.getWindow().getAttributes().softInputMode & 0xF0) != 48)
    {
      Log.w("MicroMsg.KeyboardHeightProvider", "activity soft input should be adjust nothing");
      this.uJl = false;
      AppMethodBeat.o(324447);
      return;
    }
    this.uJl = true;
    AppMethodBeat.o(324447);
  }
  
  final void cRN()
  {
    AppMethodBeat.i(324474);
    if ((this.activity instanceof q))
    {
      j localj = ((q)this.activity).getLifecycle();
      KeyboardHeightProvider.3 local3 = new KeyboardHeightProvider.3(this);
      this.uJi = local3;
      localj.addObserver(local3);
    }
    AppMethodBeat.o(324474);
  }
  
  final void cRO()
  {
    AppMethodBeat.i(324477);
    if ((this.uJi != null) && ((this.activity instanceof q))) {
      ((q)this.activity).getLifecycle().removeObserver(this.uJi);
    }
    AppMethodBeat.o(324477);
  }
  
  public final void close()
  {
    AppMethodBeat.i(324469);
    Log.i("MicroMsg.KeyboardHeightProvider", "close: ");
    this.uJh.getViewTreeObserver().removeOnGlobalLayoutListener(this.uJk);
    if ((this.fhR) && (this.uJe != null)) {
      this.uJe.getViewTreeObserver().removeOnGlobalLayoutListener(this.uJj);
    }
    try
    {
      this.activity.getWindowManager().removeView(this.uJe);
      this.uJe = null;
      this.fhR = false;
      AppMethodBeat.o(324469);
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
  
  public final void start()
  {
    AppMethodBeat.i(324464);
    cRM();
    if (this.uJh != null)
    {
      Log.i("MicroMsg.KeyboardHeightProvider", "start: %s, %s", new Object[] { Boolean.valueOf(this.fhR), this.uJh.getWindowToken() });
      if ((!this.fhR) && (this.uJh.getWindowToken() != null) && (!this.activity.isFinishing()))
      {
        this.fhR = true;
        this.uJe = new LinearLayout(this.activity);
        this.uJe.setBackgroundColor(0);
        WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams(1003, 131096, 1);
        localLayoutParams.width = 0;
        localLayoutParams.height = -1;
        localLayoutParams.gravity = 8388659;
        localLayoutParams.softInputMode = 16;
        localLayoutParams.setTitle("KeyboardWindow@" + hashCode());
        try
        {
          this.activity.getWindowManager().addView(this.uJe, localLayoutParams);
          if (this.fhR)
          {
            this.uJe.getViewTreeObserver().addOnGlobalLayoutListener(this.uJj);
            this.uJh.getViewTreeObserver().addOnGlobalLayoutListener(this.uJk);
          }
          this.uJm = 0;
          this.uJn = 0;
          if ((this.activity.getWindow().getAttributes().softInputMode & 0xF0) != 48)
          {
            Log.w("MicroMsg.KeyboardHeightProvider", "start: activity soft input should be adjust nothing");
            this.uJl = false;
            AppMethodBeat.o(324464);
            return;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.KeyboardHeightProvider", localException, "", new Object[0]);
            this.fhR = false;
            this.uJe = null;
          }
          this.uJl = true;
        }
      }
    }
    AppMethodBeat.o(324464);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.ap
 * JD-Core Version:    0.7.0.1
 */