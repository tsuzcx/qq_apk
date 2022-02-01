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
  boolean cNB;
  private Context context;
  protected ViewGroup iOI;
  ViewGroup iOJ;
  private ViewGroup iOK;
  boolean iOL;
  private Animation iOM;
  private Animation iON;
  protected int iOO;
  private boolean iOP;
  private View.OnKeyListener iOQ;
  private final View.OnTouchListener iOR;
  protected com.tencent.mm.picker.c.a iOb;
  private Dialog mDialog;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(175337);
    this.iOO = 80;
    this.iOP = true;
    this.iOQ = new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(175335);
        if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 0))
        {
          paramAnonymousView = a.this;
          if ((!paramAnonymousView.aQA()) && ((paramAnonymousView.iOJ.getParent() != null) || (paramAnonymousView.cNB))) {}
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
    this.iOR = new View.OnTouchListener()
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
  
  public boolean aQA()
  {
    return false;
  }
  
  protected final void aQw()
  {
    AppMethodBeat.i(175338);
    Object localObject = new FrameLayout.LayoutParams(-1, -2, 80);
    this.iOJ = ((ViewGroup)LayoutInflater.from(this.context).inflate(2131494555, this.iOb.Zi, false));
    this.iOJ.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    if (this.iOb.iOE != -1) {
      this.iOJ.setBackgroundColor(this.iOb.iOE);
    }
    this.iOI = ((ViewGroup)this.iOJ.findViewById(2131298752));
    this.iOI.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (aQA()) {}
    for (localObject = this.iOK;; localObject = this.iOJ)
    {
      ((ViewGroup)localObject).setFocusable(true);
      ((ViewGroup)localObject).setFocusableInTouchMode(true);
      ((ViewGroup)localObject).setOnKeyListener(this.iOQ);
      AppMethodBeat.o(175338);
      return;
    }
  }
  
  protected final void aQx()
  {
    AppMethodBeat.i(175339);
    int i = com.tencent.mm.picker.e.a.E(this.iOO, true);
    this.iON = AnimationUtils.loadAnimation(this.context, i);
    i = com.tencent.mm.picker.e.a.E(this.iOO, false);
    this.iOM = AnimationUtils.loadAnimation(this.context, i);
    AppMethodBeat.o(175339);
  }
  
  public final void aQy()
  {
    AppMethodBeat.i(175341);
    this.iOb.Zi.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(175334);
        a.this.iOb.Zi.removeView(a.this.iOJ);
        a.this.cNB = false;
        a.this.iOL = false;
        AppMethodBeat.o(175334);
      }
    });
    AppMethodBeat.o(175341);
  }
  
  public final void aQz()
  {
    AppMethodBeat.i(175343);
    if (this.mDialog != null) {
      this.mDialog.setCancelable(this.iOb.ov);
    }
    AppMethodBeat.o(175343);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(175340);
    if (aQA())
    {
      if (this.mDialog != null) {
        this.mDialog.dismiss();
      }
      AppMethodBeat.o(175340);
      return;
    }
    if (this.iOL)
    {
      AppMethodBeat.o(175340);
      return;
    }
    if (this.iOP)
    {
      this.iOM.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(175333);
          a.this.aQy();
          AppMethodBeat.o(175333);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      this.iOI.startAnimation(this.iOM);
    }
    for (;;)
    {
      this.iOL = true;
      AppMethodBeat.o(175340);
      return;
      aQy();
    }
  }
  
  public final View findViewById(int paramInt)
  {
    AppMethodBeat.i(175344);
    View localView = this.iOI.findViewById(paramInt);
    AppMethodBeat.o(175344);
    return localView;
  }
  
  protected final a fl(boolean paramBoolean)
  {
    AppMethodBeat.i(175342);
    View localView;
    if (this.iOJ != null)
    {
      localView = this.iOJ.findViewById(2131303115);
      if (!paramBoolean) {
        break label41;
      }
      localView.setOnTouchListener(this.iOR);
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