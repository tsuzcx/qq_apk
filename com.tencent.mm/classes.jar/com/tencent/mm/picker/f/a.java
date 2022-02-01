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
  boolean cBT;
  private Context context;
  protected ViewGroup isM;
  ViewGroup isN;
  private ViewGroup isO;
  boolean isP;
  private Animation isQ;
  private Animation isR;
  protected int isS;
  private boolean isT;
  private View.OnKeyListener isU;
  private final View.OnTouchListener isV;
  protected com.tencent.mm.picker.c.a isf;
  private Dialog mDialog;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(175337);
    this.isS = 80;
    this.isT = true;
    this.isU = new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(175335);
        if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 0))
        {
          paramAnonymousView = a.this;
          if ((!paramAnonymousView.aMQ()) && ((paramAnonymousView.isN.getParent() != null) || (paramAnonymousView.cBT))) {}
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
    this.isV = new View.OnTouchListener()
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
  
  protected final void aMM()
  {
    AppMethodBeat.i(175338);
    Object localObject = new FrameLayout.LayoutParams(-1, -2, 80);
    this.isN = ((ViewGroup)LayoutInflater.from(this.context).inflate(2131494555, this.isf.Xt, false));
    this.isN.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    if (this.isf.isI != -1) {
      this.isN.setBackgroundColor(this.isf.isI);
    }
    this.isM = ((ViewGroup)this.isN.findViewById(2131298752));
    this.isM.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (aMQ()) {}
    for (localObject = this.isO;; localObject = this.isN)
    {
      ((ViewGroup)localObject).setFocusable(true);
      ((ViewGroup)localObject).setFocusableInTouchMode(true);
      ((ViewGroup)localObject).setOnKeyListener(this.isU);
      AppMethodBeat.o(175338);
      return;
    }
  }
  
  protected final void aMN()
  {
    AppMethodBeat.i(175339);
    int i = com.tencent.mm.picker.e.a.E(this.isS, true);
    this.isR = AnimationUtils.loadAnimation(this.context, i);
    i = com.tencent.mm.picker.e.a.E(this.isS, false);
    this.isQ = AnimationUtils.loadAnimation(this.context, i);
    AppMethodBeat.o(175339);
  }
  
  public final void aMO()
  {
    AppMethodBeat.i(175341);
    this.isf.Xt.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(175334);
        a.this.isf.Xt.removeView(a.this.isN);
        a.this.cBT = false;
        a.this.isP = false;
        AppMethodBeat.o(175334);
      }
    });
    AppMethodBeat.o(175341);
  }
  
  public final void aMP()
  {
    AppMethodBeat.i(175343);
    if (this.mDialog != null) {
      this.mDialog.setCancelable(this.isf.mz);
    }
    AppMethodBeat.o(175343);
  }
  
  public boolean aMQ()
  {
    return false;
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(175340);
    if (aMQ())
    {
      if (this.mDialog != null) {
        this.mDialog.dismiss();
      }
      AppMethodBeat.o(175340);
      return;
    }
    if (this.isP)
    {
      AppMethodBeat.o(175340);
      return;
    }
    if (this.isT)
    {
      this.isQ.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(175333);
          a.this.aMO();
          AppMethodBeat.o(175333);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      this.isM.startAnimation(this.isQ);
    }
    for (;;)
    {
      this.isP = true;
      AppMethodBeat.o(175340);
      return;
      aMO();
    }
  }
  
  protected final a fg(boolean paramBoolean)
  {
    AppMethodBeat.i(175342);
    View localView;
    if (this.isN != null)
    {
      localView = this.isN.findViewById(2131303115);
      if (!paramBoolean) {
        break label41;
      }
      localView.setOnTouchListener(this.isV);
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
    View localView = this.isM.findViewById(paramInt);
    AppMethodBeat.o(175344);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.picker.f.a
 * JD-Core Version:    0.7.0.1
 */