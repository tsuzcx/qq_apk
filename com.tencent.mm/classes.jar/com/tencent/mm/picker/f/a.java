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
import com.tencent.mm.hellhoundlib.b.b;

public class a
{
  private Context context;
  boolean ddZ;
  protected com.tencent.mm.picker.c.a jKP;
  boolean jLA;
  private Animation jLB;
  private Animation jLC;
  protected int jLD;
  private boolean jLE;
  private View.OnKeyListener jLF;
  private final View.OnTouchListener jLG;
  protected ViewGroup jLx;
  ViewGroup jLy;
  private ViewGroup jLz;
  private Dialog mDialog;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(175337);
    this.jLD = 80;
    this.jLE = true;
    this.jLF = new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(175335);
        b localb = new b();
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.bm(paramAnonymousKeyEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/picker/view/BasePickerView$3", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.axR());
        if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 0))
        {
          paramAnonymousView = a.this;
          if ((!paramAnonymousView.blf()) && ((paramAnonymousView.jLy.getParent() != null) || (paramAnonymousView.ddZ))) {}
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
    this.jLG = new View.OnTouchListener()
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
  
  protected final void blb()
  {
    AppMethodBeat.i(175338);
    Object localObject = new FrameLayout.LayoutParams(-1, -2, 80);
    this.jLy = ((ViewGroup)LayoutInflater.from(this.context).inflate(2131495165, this.jKP.Zv, false));
    this.jLy.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    if (this.jKP.jLt != -1) {
      this.jLy.setBackgroundColor(this.jKP.jLt);
    }
    this.jLx = ((ViewGroup)this.jLy.findViewById(2131299195));
    this.jLx.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (blf()) {}
    for (localObject = this.jLz;; localObject = this.jLy)
    {
      ((ViewGroup)localObject).setFocusable(true);
      ((ViewGroup)localObject).setFocusableInTouchMode(true);
      ((ViewGroup)localObject).setOnKeyListener(this.jLF);
      AppMethodBeat.o(175338);
      return;
    }
  }
  
  protected final void blc()
  {
    AppMethodBeat.i(175339);
    int i = com.tencent.mm.picker.e.a.I(this.jLD, true);
    this.jLC = AnimationUtils.loadAnimation(this.context, i);
    i = com.tencent.mm.picker.e.a.I(this.jLD, false);
    this.jLB = AnimationUtils.loadAnimation(this.context, i);
    AppMethodBeat.o(175339);
  }
  
  public final void bld()
  {
    AppMethodBeat.i(175341);
    this.jKP.Zv.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(175334);
        a.this.jKP.Zv.removeView(a.this.jLy);
        a.this.ddZ = false;
        a.this.jLA = false;
        AppMethodBeat.o(175334);
      }
    });
    AppMethodBeat.o(175341);
  }
  
  public final void ble()
  {
    AppMethodBeat.i(175343);
    if (this.mDialog != null) {
      this.mDialog.setCancelable(this.jKP.ox);
    }
    AppMethodBeat.o(175343);
  }
  
  public boolean blf()
  {
    return false;
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(175340);
    if (blf())
    {
      if (this.mDialog != null) {
        this.mDialog.dismiss();
      }
      AppMethodBeat.o(175340);
      return;
    }
    if (this.jLA)
    {
      AppMethodBeat.o(175340);
      return;
    }
    if (this.jLE)
    {
      this.jLB.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(175333);
          a.this.bld();
          AppMethodBeat.o(175333);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      this.jLx.startAnimation(this.jLB);
    }
    for (;;)
    {
      this.jLA = true;
      AppMethodBeat.o(175340);
      return;
      bld();
    }
  }
  
  public final View findViewById(int paramInt)
  {
    AppMethodBeat.i(175344);
    View localView = this.jLx.findViewById(paramInt);
    AppMethodBeat.o(175344);
    return localView;
  }
  
  protected final a gd(boolean paramBoolean)
  {
    AppMethodBeat.i(175342);
    View localView;
    if (this.jLy != null)
    {
      localView = this.jLy.findViewById(2131305747);
      if (!paramBoolean) {
        break label41;
      }
      localView.setOnTouchListener(this.jLG);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.picker.f.a
 * JD-Core Version:    0.7.0.1
 */