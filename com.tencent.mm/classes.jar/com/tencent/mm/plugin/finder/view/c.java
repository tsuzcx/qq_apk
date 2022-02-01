package com.tencent.mm.plugin.finder.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetBehavior.a;
import android.support.design.widget.a;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.a.b;

public final class c
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private ViewTreeObserver adE;
  public View khe;
  private Dialog lcA;
  private BottomSheetBehavior lcD;
  private boolean lcE;
  private int lcF;
  private boolean lcH;
  private boolean lcI;
  private Context mContext;
  private View oP;
  private boolean rVy;
  private boolean rVz;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(178057);
    this.lcE = false;
    this.rVz = false;
    this.lcH = false;
    this.lcI = false;
    this.mContext = paramContext;
    if ((this.mContext instanceof Activity)) {
      this.oP = ((ViewGroup)((Activity)this.mContext).getWindow().getDecorView()).findViewById(16908290);
    }
    paramContext = this.mContext;
    if (this.lcI) {}
    for (this.lcA = new b(paramContext);; this.lcA = new a(paramContext, 2131820788))
    {
      this.khe = View.inflate(paramContext, 2131494069, null);
      this.lcE = aly();
      this.lcA.setContentView(this.khe);
      this.lcD = BottomSheetBehavior.l((View)this.khe.getParent());
      this.lcD.setState(3);
      this.lcD.mp = new BottomSheetBehavior.a()
      {
        public final void N(int paramAnonymousInt) {}
        
        public final void l(float paramAnonymousFloat) {}
      };
      this.lcA.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(178056);
          if (c.a(c.this) != null)
          {
            if (!c.a(c.this).isAlive()) {
              c.a(c.this, c.b(c.this).getViewTreeObserver());
            }
            c.a(c.this).removeGlobalOnLayoutListener(c.this);
            c.a(c.this, null);
          }
          if (!c.c(c.this)) {
            c.d(c.this);
          }
          AppMethodBeat.o(178056);
        }
      });
      AppMethodBeat.o(178057);
      return;
    }
  }
  
  private boolean aly()
  {
    AppMethodBeat.i(178064);
    if (this.mContext.getResources().getConfiguration().orientation == 2)
    {
      AppMethodBeat.o(178064);
      return true;
    }
    AppMethodBeat.o(178064);
    return false;
  }
  
  @SuppressLint({"WrongConstant"})
  private int getRotation()
  {
    AppMethodBeat.i(178059);
    int i = 0;
    if ((this.mContext instanceof Activity)) {
      i = ((Activity)this.mContext).getWindow().getWindowManager().getDefaultDisplay().getRotation();
    }
    AppMethodBeat.o(178059);
    return i;
  }
  
  private boolean isShowing()
  {
    AppMethodBeat.i(178063);
    if ((this.lcA != null) && (this.lcA.isShowing()))
    {
      AppMethodBeat.o(178063);
      return true;
    }
    AppMethodBeat.o(178063);
    return false;
  }
  
  public final c EP(int paramInt)
  {
    AppMethodBeat.i(201080);
    LinearLayout localLinearLayout = (LinearLayout)this.khe.findViewById(2131297461);
    LayoutInflater.from(this.khe.getContext()).inflate(paramInt, localLinearLayout, true);
    AppMethodBeat.o(201080);
    return this;
  }
  
  public final void bmi()
  {
    AppMethodBeat.i(178062);
    if (this.lcA != null)
    {
      if ((!(this.mContext instanceof Activity)) || ((this.mContext != null) && (!((Activity)this.mContext).isFinishing()) && (!((Activity)this.mContext).isDestroyed()))) {
        this.lcA.dismiss();
      }
      if (this.lcD != null) {
        this.lcD.mg = true;
      }
    }
    AppMethodBeat.o(178062);
  }
  
  public final void cED()
  {
    AppMethodBeat.i(178061);
    this.lcE = aly();
    this.lcF = getRotation();
    if (this.lcA != null)
    {
      ((ViewGroup)this.khe.getParent()).setVisibility(0);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.khe.getLayoutParams();
      if ((this.lcE) && (this.oP != null))
      {
        Rect localRect = new Rect();
        this.oP.getWindowVisibleDisplayFrame(localRect);
        localLayoutParams.width = localRect.right;
      }
      this.khe.setLayoutParams(localLayoutParams);
      if (Build.VERSION.SDK_INT >= 21) {
        this.lcA.getWindow().addFlags(-2147483648);
      }
      if ((this.rVy) && (Build.VERSION.SDK_INT >= 23) && (this.lcA != null))
      {
        this.lcA.getWindow().getDecorView().setSystemUiVisibility(9216);
        this.lcA.getWindow().setStatusBarColor(0);
      }
      if (!this.lcH) {
        break label308;
      }
      this.lcA.getWindow().setFlags(8, 8);
      this.lcA.getWindow().addFlags(131200);
      this.lcA.getWindow().getDecorView().setSystemUiVisibility(6);
      if (this.oP != null) {
        if (this.adE != null) {
          break label363;
        }
      }
    }
    label308:
    label363:
    for (int i = 1;; i = 0)
    {
      this.adE = this.oP.getViewTreeObserver();
      if (i != 0) {
        this.adE.addOnGlobalLayoutListener(this);
      }
      if (((this.mContext instanceof Activity)) && (!((Activity)this.mContext).isFinishing())) {
        this.lcA.show();
      }
      if (this.lcD != null) {
        this.lcD.mg = false;
      }
      AppMethodBeat.o(178061);
      return;
      this.lcA.getWindow().clearFlags(8);
      this.lcA.getWindow().clearFlags(131072);
      this.lcA.getWindow().clearFlags(128);
      this.lcA.getWindow().getDecorView().setSystemUiVisibility(0);
      break;
    }
  }
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(178058);
    if (isShowing())
    {
      View localView = this.oP;
      if ((localView == null) || ((!localView.isShown()) && (localView.getVisibility() != 0)))
      {
        bmi();
        AppMethodBeat.o(178058);
        return;
      }
      if ((isShowing()) && ((this.lcE != aly()) || (this.lcF != getRotation()))) {
        bmi();
      }
    }
    AppMethodBeat.o(178058);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.c
 * JD-Core Version:    0.7.0.1
 */