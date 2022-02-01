package com.tencent.mm.picker.f;

import android.app.Dialog;
import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class a
{
  boolean cEL;
  private Context context;
  protected ViewGroup hSH;
  ViewGroup hSI;
  private ViewGroup hSJ;
  boolean hSK;
  private Animation hSL;
  private Animation hSM;
  protected int hSN;
  private boolean hSO;
  private View.OnKeyListener hSP;
  private final View.OnTouchListener hSQ;
  protected com.tencent.mm.picker.c.a hSa;
  private Dialog mDialog;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(175337);
    this.hSN = 80;
    this.hSO = true;
    this.hSP = new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(175335);
        if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 0))
        {
          paramAnonymousView = a.this;
          if ((!paramAnonymousView.aGd()) && ((paramAnonymousView.hSI.getParent() != null) || (paramAnonymousView.cEL))) {}
          for (paramAnonymousInt = 1; paramAnonymousInt != 0; paramAnonymousInt = 0)
          {
            a.this.dismiss();
            AppMethodBeat.o(175335);
            return true;
          }
        }
        AppMethodBeat.o(175335);
        return false;
      }
    };
    this.hSQ = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(175336);
        if (paramAnonymousMotionEvent.getAction() == 0) {
          a.this.dismiss();
        }
        AppMethodBeat.o(175336);
        return false;
      }
    };
    this.context = paramContext;
    AppMethodBeat.o(175337);
  }
  
  protected final void aFZ()
  {
    AppMethodBeat.i(175338);
    Object localObject = new FrameLayout.LayoutParams(-1, -2, 80);
    this.hSI = ((ViewGroup)LayoutInflater.from(this.context).inflate(2131494555, this.hSa.Wy, false));
    this.hSI.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    if (this.hSa.hSD != -1) {
      this.hSI.setBackgroundColor(this.hSa.hSD);
    }
    this.hSH = ((ViewGroup)this.hSI.findViewById(2131298752));
    this.hSH.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (aGd()) {}
    for (localObject = this.hSJ;; localObject = this.hSI)
    {
      ((ViewGroup)localObject).setFocusable(true);
      ((ViewGroup)localObject).setFocusableInTouchMode(true);
      ((ViewGroup)localObject).setOnKeyListener(this.hSP);
      AppMethodBeat.o(175338);
      return;
    }
  }
  
  protected final void aGa()
  {
    AppMethodBeat.i(175339);
    int i = com.tencent.mm.picker.e.a.E(this.hSN, true);
    this.hSM = AnimationUtils.loadAnimation(this.context, i);
    i = com.tencent.mm.picker.e.a.E(this.hSN, false);
    this.hSL = AnimationUtils.loadAnimation(this.context, i);
    AppMethodBeat.o(175339);
  }
  
  public final void aGb()
  {
    AppMethodBeat.i(175341);
    this.hSa.Wy.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(175334);
        a.this.hSa.Wy.removeView(a.this.hSI);
        a.this.cEL = false;
        a.this.hSK = false;
        AppMethodBeat.o(175334);
      }
    });
    AppMethodBeat.o(175341);
  }
  
  public final void aGc()
  {
    AppMethodBeat.i(175343);
    if (this.mDialog != null) {
      this.mDialog.setCancelable(this.hSa.lA);
    }
    AppMethodBeat.o(175343);
  }
  
  public boolean aGd()
  {
    return false;
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(175340);
    if (aGd())
    {
      if (this.mDialog != null) {
        this.mDialog.dismiss();
      }
      AppMethodBeat.o(175340);
      return;
    }
    if (this.hSK)
    {
      AppMethodBeat.o(175340);
      return;
    }
    if (this.hSO)
    {
      this.hSL.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(175333);
          a.this.aGb();
          AppMethodBeat.o(175333);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      this.hSH.startAnimation(this.hSL);
    }
    for (;;)
    {
      this.hSK = true;
      AppMethodBeat.o(175340);
      return;
      aGb();
    }
  }
  
  protected final a eM(boolean paramBoolean)
  {
    AppMethodBeat.i(175342);
    View localView;
    if (this.hSI != null)
    {
      localView = this.hSI.findViewById(2131303115);
      if (!paramBoolean) {
        break label41;
      }
      localView.setOnTouchListener(this.hSQ);
    }
    for (;;)
    {
      AppMethodBeat.o(175342);
      return this;
      label41:
      localView.setOnTouchListener(null);
    }
  }
  
  public final View findViewById(int paramInt)
  {
    AppMethodBeat.i(175344);
    View localView = this.hSH.findViewById(paramInt);
    AppMethodBeat.o(175344);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.picker.f.a
 * JD-Core Version:    0.7.0.1
 */