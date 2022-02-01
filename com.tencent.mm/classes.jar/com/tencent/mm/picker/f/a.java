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
import com.tencent.mm.ck.a.f;
import com.tencent.mm.ck.a.g;

public class a
{
  private Context context;
  boolean fhR;
  private Dialog mDialog;
  protected com.tencent.mm.picker.c.a pyC;
  protected ViewGroup pzi;
  ViewGroup pzj;
  private ViewGroup pzk;
  com.tencent.mm.picker.d.b pzl;
  boolean pzm;
  private Animation pzn;
  private Animation pzo;
  protected int pzp;
  private boolean pzq;
  private View.OnKeyListener pzr;
  private final View.OnTouchListener pzs;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(175337);
    this.pzp = 80;
    this.pzq = true;
    this.pzr = new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(175335);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.cH(paramAnonymousKeyEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/picker/view/BasePickerView$3", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.aYj());
        if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 0))
        {
          paramAnonymousView = a.this;
          if ((!paramAnonymousView.bTd()) && ((paramAnonymousView.pzj.getParent() != null) || (paramAnonymousView.fhR))) {}
          for (paramAnonymousInt = 1; paramAnonymousInt != 0; paramAnonymousInt = 0)
          {
            a.this.dismiss();
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/picker/view/BasePickerView$3", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(175335);
            return true;
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/picker/view/BasePickerView$3", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
        AppMethodBeat.o(175335);
        return false;
      }
    };
    this.pzs = new View.OnTouchListener()
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
  
  protected final void bSZ()
  {
    AppMethodBeat.i(175338);
    Object localObject = new FrameLayout.LayoutParams(-1, -2, 80);
    this.pzj = ((ViewGroup)LayoutInflater.from(this.context).inflate(a.g.layout_basepickerview, this.pyC.hM, false));
    this.pzj.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    if (this.pyC.pzf != -1) {
      this.pzj.setBackgroundColor(this.pyC.pzf);
    }
    this.pzi = ((ViewGroup)this.pzj.findViewById(a.f.content_container));
    this.pzi.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (bTd()) {}
    for (localObject = this.pzk;; localObject = this.pzj)
    {
      ((ViewGroup)localObject).setFocusable(true);
      ((ViewGroup)localObject).setFocusableInTouchMode(true);
      ((ViewGroup)localObject).setOnKeyListener(this.pzr);
      AppMethodBeat.o(175338);
      return;
    }
  }
  
  protected final void bTa()
  {
    AppMethodBeat.i(175339);
    int i = com.tencent.mm.picker.e.a.Z(this.pzp, true);
    this.pzo = AnimationUtils.loadAnimation(this.context, i);
    i = com.tencent.mm.picker.e.a.Z(this.pzp, false);
    this.pzn = AnimationUtils.loadAnimation(this.context, i);
    AppMethodBeat.o(175339);
  }
  
  public final void bTb()
  {
    AppMethodBeat.i(175341);
    this.pyC.hM.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(175334);
        a.this.pyC.hM.removeView(a.this.pzj);
        a.this.fhR = false;
        a.this.pzm = false;
        if (a.this.pzl != null) {
          a.this.pzl.onDismiss(a.this);
        }
        AppMethodBeat.o(175334);
      }
    });
    AppMethodBeat.o(175341);
  }
  
  public final void bTc()
  {
    AppMethodBeat.i(175343);
    if (this.mDialog != null) {
      this.mDialog.setCancelable(this.pyC.dqR);
    }
    AppMethodBeat.o(175343);
  }
  
  public boolean bTd()
  {
    return false;
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(175340);
    if (bTd())
    {
      if (this.mDialog != null) {
        this.mDialog.dismiss();
      }
      AppMethodBeat.o(175340);
      return;
    }
    if (this.pzm)
    {
      AppMethodBeat.o(175340);
      return;
    }
    if (this.pzq)
    {
      this.pzn.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(175333);
          a.this.bTb();
          AppMethodBeat.o(175333);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      this.pzi.startAnimation(this.pzn);
    }
    for (;;)
    {
      this.pzm = true;
      AppMethodBeat.o(175340);
      return;
      bTb();
    }
  }
  
  public final View findViewById(int paramInt)
  {
    AppMethodBeat.i(175344);
    View localView = this.pzi.findViewById(paramInt);
    AppMethodBeat.o(175344);
    return localView;
  }
  
  protected final a hE(boolean paramBoolean)
  {
    AppMethodBeat.i(175342);
    View localView;
    if (this.pzj != null)
    {
      localView = this.pzj.findViewById(a.f.outmost_container);
      if (!paramBoolean) {
        break label42;
      }
      localView.setOnTouchListener(this.pzs);
    }
    for (;;)
    {
      AppMethodBeat.o(175342);
      return this;
      label42:
      localView.setOnTouchListener(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.picker.f.a
 * JD-Core Version:    0.7.0.1
 */