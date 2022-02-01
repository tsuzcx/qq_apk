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

public final class d
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private ViewTreeObserver afv;
  public View kBS;
  private Dialog lzA;
  private BottomSheetBehavior lzD;
  private boolean lzE;
  private int lzF;
  private boolean lzH;
  private boolean lzI;
  private Context mContext;
  private View qI;
  private boolean sSh;
  private boolean sSi;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(178057);
    this.lzE = false;
    this.sSi = false;
    this.lzH = false;
    this.lzI = false;
    this.mContext = paramContext;
    if ((this.mContext instanceof Activity)) {
      this.qI = ((ViewGroup)((Activity)this.mContext).getWindow().getDecorView()).findViewById(16908290);
    }
    paramContext = this.mContext;
    if (this.lzI) {}
    for (this.lzA = new b(paramContext);; this.lzA = new a(paramContext, 2131820788))
    {
      this.kBS = View.inflate(paramContext, 2131494069, null);
      this.lzE = aol();
      this.lzA.setContentView(this.kBS);
      this.lzD = BottomSheetBehavior.l((View)this.kBS.getParent());
      this.lzD.setState(3);
      this.lzD.oi = new BottomSheetBehavior.a()
      {
        public final void M(int paramAnonymousInt) {}
      };
      this.lzA.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(178056);
          if (d.a(d.this) != null)
          {
            if (!d.a(d.this).isAlive()) {
              d.a(d.this, d.b(d.this).getViewTreeObserver());
            }
            d.a(d.this).removeGlobalOnLayoutListener(d.this);
            d.a(d.this, null);
          }
          if (!d.c(d.this)) {
            d.d(d.this);
          }
          AppMethodBeat.o(178056);
        }
      });
      AppMethodBeat.o(178057);
      return;
    }
  }
  
  private boolean aol()
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
    if ((this.lzA != null) && (this.lzA.isShowing()))
    {
      AppMethodBeat.o(178063);
      return true;
    }
    AppMethodBeat.o(178063);
    return false;
  }
  
  public final d Gc(int paramInt)
  {
    AppMethodBeat.i(200928);
    LinearLayout localLinearLayout = (LinearLayout)this.kBS.findViewById(2131297461);
    LayoutInflater.from(this.kBS.getContext()).inflate(paramInt, localLinearLayout, true);
    AppMethodBeat.o(200928);
    return this;
  }
  
  public final void bpT()
  {
    AppMethodBeat.i(178062);
    if (this.lzA != null)
    {
      if ((!(this.mContext instanceof Activity)) || ((this.mContext != null) && (!((Activity)this.mContext).isFinishing()) && (!((Activity)this.mContext).isDestroyed()))) {
        this.lzA.dismiss();
      }
      if (this.lzD != null) {
        this.lzD.nZ = true;
      }
    }
    AppMethodBeat.o(178062);
  }
  
  public final void cMW()
  {
    AppMethodBeat.i(178061);
    this.lzE = aol();
    this.lzF = getRotation();
    if (this.lzA != null)
    {
      ((ViewGroup)this.kBS.getParent()).setVisibility(0);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.kBS.getLayoutParams();
      if ((this.lzE) && (this.qI != null))
      {
        Rect localRect = new Rect();
        this.qI.getWindowVisibleDisplayFrame(localRect);
        localLayoutParams.width = localRect.right;
      }
      this.kBS.setLayoutParams(localLayoutParams);
      if (Build.VERSION.SDK_INT >= 21) {
        this.lzA.getWindow().addFlags(-2147483648);
      }
      if ((this.sSh) && (Build.VERSION.SDK_INT >= 23) && (this.lzA != null))
      {
        this.lzA.getWindow().getDecorView().setSystemUiVisibility(9216);
        this.lzA.getWindow().setStatusBarColor(0);
      }
      if (!this.lzH) {
        break label308;
      }
      this.lzA.getWindow().setFlags(8, 8);
      this.lzA.getWindow().addFlags(131200);
      this.lzA.getWindow().getDecorView().setSystemUiVisibility(6);
      if (this.qI != null) {
        if (this.afv != null) {
          break label363;
        }
      }
    }
    label308:
    label363:
    for (int i = 1;; i = 0)
    {
      this.afv = this.qI.getViewTreeObserver();
      if (i != 0) {
        this.afv.addOnGlobalLayoutListener(this);
      }
      if (((this.mContext instanceof Activity)) && (!((Activity)this.mContext).isFinishing())) {
        this.lzA.show();
      }
      if (this.lzD != null) {
        this.lzD.nZ = false;
      }
      AppMethodBeat.o(178061);
      return;
      this.lzA.getWindow().clearFlags(8);
      this.lzA.getWindow().clearFlags(131072);
      this.lzA.getWindow().clearFlags(128);
      this.lzA.getWindow().getDecorView().setSystemUiVisibility(0);
      break;
    }
  }
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(178058);
    if (isShowing())
    {
      View localView = this.qI;
      if ((localView == null) || ((!localView.isShown()) && (localView.getVisibility() != 0)))
      {
        bpT();
        AppMethodBeat.o(178058);
        return;
      }
      if ((isShowing()) && ((this.lzE != aol()) || (this.lzF != getRotation()))) {
        bpT();
      }
    }
    AppMethodBeat.o(178058);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.d
 * JD-Core Version:    0.7.0.1
 */