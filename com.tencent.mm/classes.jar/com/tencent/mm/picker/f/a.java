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
  boolean cMS;
  private Context context;
  protected ViewGroup iLP;
  ViewGroup iLQ;
  private ViewGroup iLR;
  boolean iLS;
  private Animation iLT;
  private Animation iLU;
  protected int iLV;
  private boolean iLW;
  private View.OnKeyListener iLX;
  private final View.OnTouchListener iLY;
  protected com.tencent.mm.picker.c.a iLi;
  private Dialog mDialog;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(175337);
    this.iLV = 80;
    this.iLW = true;
    this.iLX = new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(175335);
        if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 0))
        {
          paramAnonymousView = a.this;
          if ((!paramAnonymousView.aQb()) && ((paramAnonymousView.iLQ.getParent() != null) || (paramAnonymousView.cMS))) {}
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
    this.iLY = new View.OnTouchListener()
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
  
  protected final void aPX()
  {
    AppMethodBeat.i(175338);
    Object localObject = new FrameLayout.LayoutParams(-1, -2, 80);
    this.iLQ = ((ViewGroup)LayoutInflater.from(this.context).inflate(2131494555, this.iLi.Zi, false));
    this.iLQ.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    if (this.iLi.iLL != -1) {
      this.iLQ.setBackgroundColor(this.iLi.iLL);
    }
    this.iLP = ((ViewGroup)this.iLQ.findViewById(2131298752));
    this.iLP.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (aQb()) {}
    for (localObject = this.iLR;; localObject = this.iLQ)
    {
      ((ViewGroup)localObject).setFocusable(true);
      ((ViewGroup)localObject).setFocusableInTouchMode(true);
      ((ViewGroup)localObject).setOnKeyListener(this.iLX);
      AppMethodBeat.o(175338);
      return;
    }
  }
  
  protected final void aPY()
  {
    AppMethodBeat.i(175339);
    int i = com.tencent.mm.picker.e.a.E(this.iLV, true);
    this.iLU = AnimationUtils.loadAnimation(this.context, i);
    i = com.tencent.mm.picker.e.a.E(this.iLV, false);
    this.iLT = AnimationUtils.loadAnimation(this.context, i);
    AppMethodBeat.o(175339);
  }
  
  public final void aPZ()
  {
    AppMethodBeat.i(175341);
    this.iLi.Zi.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(175334);
        a.this.iLi.Zi.removeView(a.this.iLQ);
        a.this.cMS = false;
        a.this.iLS = false;
        AppMethodBeat.o(175334);
      }
    });
    AppMethodBeat.o(175341);
  }
  
  public final void aQa()
  {
    AppMethodBeat.i(175343);
    if (this.mDialog != null) {
      this.mDialog.setCancelable(this.iLi.ov);
    }
    AppMethodBeat.o(175343);
  }
  
  public boolean aQb()
  {
    return false;
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(175340);
    if (aQb())
    {
      if (this.mDialog != null) {
        this.mDialog.dismiss();
      }
      AppMethodBeat.o(175340);
      return;
    }
    if (this.iLS)
    {
      AppMethodBeat.o(175340);
      return;
    }
    if (this.iLW)
    {
      this.iLT.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(175333);
          a.this.aPZ();
          AppMethodBeat.o(175333);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      this.iLP.startAnimation(this.iLT);
    }
    for (;;)
    {
      this.iLS = true;
      AppMethodBeat.o(175340);
      return;
      aPZ();
    }
  }
  
  public final View findViewById(int paramInt)
  {
    AppMethodBeat.i(175344);
    View localView = this.iLP.findViewById(paramInt);
    AppMethodBeat.o(175344);
    return localView;
  }
  
  protected final a fk(boolean paramBoolean)
  {
    AppMethodBeat.i(175342);
    View localView;
    if (this.iLQ != null)
    {
      localView = this.iLQ.findViewById(2131303115);
      if (!paramBoolean) {
        break label41;
      }
      localView.setOnTouchListener(this.iLY);
    }
    for (;;)
    {
      AppMethodBeat.o(175342);
      return this;
      label41:
      localView.setOnTouchListener(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.picker.f.a
 * JD-Core Version:    0.7.0.1
 */