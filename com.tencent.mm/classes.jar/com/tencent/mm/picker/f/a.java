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
import com.tencent.mm.cr.a.f;
import com.tencent.mm.cr.a.g;
import com.tencent.mm.hellhoundlib.b.b;

public class a
{
  private Context context;
  boolean dic;
  protected com.tencent.mm.picker.c.a mBU;
  protected ViewGroup mCB;
  ViewGroup mCC;
  private ViewGroup mCD;
  boolean mCE;
  private Animation mCF;
  private Animation mCG;
  protected int mCH;
  private boolean mCI;
  private View.OnKeyListener mCJ;
  private final View.OnTouchListener mCK;
  private Dialog mDialog;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(175337);
    this.mCH = 80;
    this.mCI = true;
    this.mCJ = new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(175335);
        b localb = new b();
        localb.bn(paramAnonymousView);
        localb.sg(paramAnonymousInt);
        localb.bn(paramAnonymousKeyEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/picker/view/BasePickerView$3", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.aFi());
        if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 0))
        {
          paramAnonymousView = a.this;
          if ((!paramAnonymousView.buU()) && ((paramAnonymousView.mCC.getParent() != null) || (paramAnonymousView.dic))) {}
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
    this.mCK = new View.OnTouchListener()
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
  
  protected final void buQ()
  {
    AppMethodBeat.i(175338);
    Object localObject = new FrameLayout.LayoutParams(-1, -2, 80);
    this.mCC = ((ViewGroup)LayoutInflater.from(this.context).inflate(a.g.layout_basepickerview, this.mBU.gR, false));
    this.mCC.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    if (this.mBU.mCx != -1) {
      this.mCC.setBackgroundColor(this.mBU.mCx);
    }
    this.mCB = ((ViewGroup)this.mCC.findViewById(a.f.content_container));
    this.mCB.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (buU()) {}
    for (localObject = this.mCD;; localObject = this.mCC)
    {
      ((ViewGroup)localObject).setFocusable(true);
      ((ViewGroup)localObject).setFocusableInTouchMode(true);
      ((ViewGroup)localObject).setOnKeyListener(this.mCJ);
      AppMethodBeat.o(175338);
      return;
    }
  }
  
  protected final void buR()
  {
    AppMethodBeat.i(175339);
    int i = com.tencent.mm.picker.e.a.K(this.mCH, true);
    this.mCG = AnimationUtils.loadAnimation(this.context, i);
    i = com.tencent.mm.picker.e.a.K(this.mCH, false);
    this.mCF = AnimationUtils.loadAnimation(this.context, i);
    AppMethodBeat.o(175339);
  }
  
  public final void buS()
  {
    AppMethodBeat.i(175341);
    this.mBU.gR.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(175334);
        a.this.mBU.gR.removeView(a.this.mCC);
        a.this.dic = false;
        a.this.mCE = false;
        AppMethodBeat.o(175334);
      }
    });
    AppMethodBeat.o(175341);
  }
  
  public final void buT()
  {
    AppMethodBeat.i(175343);
    if (this.mDialog != null) {
      this.mDialog.setCancelable(this.mBU.bxO);
    }
    AppMethodBeat.o(175343);
  }
  
  public boolean buU()
  {
    return false;
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(175340);
    if (buU())
    {
      if (this.mDialog != null) {
        this.mDialog.dismiss();
      }
      AppMethodBeat.o(175340);
      return;
    }
    if (this.mCE)
    {
      AppMethodBeat.o(175340);
      return;
    }
    if (this.mCI)
    {
      this.mCF.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(175333);
          a.this.buS();
          AppMethodBeat.o(175333);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      this.mCB.startAnimation(this.mCF);
    }
    for (;;)
    {
      this.mCE = true;
      AppMethodBeat.o(175340);
      return;
      buS();
    }
  }
  
  public final View findViewById(int paramInt)
  {
    AppMethodBeat.i(175344);
    View localView = this.mCB.findViewById(paramInt);
    AppMethodBeat.o(175344);
    return localView;
  }
  
  protected final a gP(boolean paramBoolean)
  {
    AppMethodBeat.i(175342);
    View localView;
    if (this.mCC != null)
    {
      localView = this.mCC.findViewById(a.f.outmost_container);
      if (!paramBoolean) {
        break label42;
      }
      localView.setOnTouchListener(this.mCK);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.picker.f.a
 * JD-Core Version:    0.7.0.1
 */