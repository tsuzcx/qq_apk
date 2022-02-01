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
  public View kFh;
  private Dialog lDY;
  private BottomSheetBehavior lEb;
  private boolean lEc;
  private int lEd;
  private boolean lEf;
  private boolean lEg;
  private Context mContext;
  private View qI;
  private boolean tds;
  private boolean tdt;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(178057);
    this.lEc = false;
    this.tdt = false;
    this.lEf = false;
    this.lEg = false;
    this.mContext = paramContext;
    if ((this.mContext instanceof Activity)) {
      this.qI = ((ViewGroup)((Activity)this.mContext).getWindow().getDecorView()).findViewById(16908290);
    }
    paramContext = this.mContext;
    if (this.lEg) {}
    for (this.lDY = new b(paramContext);; this.lDY = new a(paramContext, 2131820788))
    {
      this.kFh = View.inflate(paramContext, 2131494069, null);
      this.lEc = aoA();
      this.lDY.setContentView(this.kFh);
      this.lEb = BottomSheetBehavior.l((View)this.kFh.getParent());
      this.lEb.setState(3);
      this.lEb.oi = new BottomSheetBehavior.a()
      {
        public final void M(int paramAnonymousInt) {}
      };
      this.lDY.setOnDismissListener(new DialogInterface.OnDismissListener()
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
  
  private boolean aoA()
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
    if ((this.lDY != null) && (this.lDY.isShowing()))
    {
      AppMethodBeat.o(178063);
      return true;
    }
    AppMethodBeat.o(178063);
    return false;
  }
  
  public final d GC(int paramInt)
  {
    AppMethodBeat.i(201350);
    LinearLayout localLinearLayout = (LinearLayout)this.kFh.findViewById(2131297461);
    LayoutInflater.from(this.kFh.getContext()).inflate(paramInt, localLinearLayout, true);
    AppMethodBeat.o(201350);
    return this;
  }
  
  public final void bqD()
  {
    AppMethodBeat.i(178062);
    if (this.lDY != null)
    {
      if ((!(this.mContext instanceof Activity)) || ((this.mContext != null) && (!((Activity)this.mContext).isFinishing()) && (!((Activity)this.mContext).isDestroyed()))) {
        this.lDY.dismiss();
      }
      if (this.lEb != null) {
        this.lEb.nZ = true;
      }
    }
    AppMethodBeat.o(178062);
  }
  
  public final void cPF()
  {
    AppMethodBeat.i(178061);
    this.lEc = aoA();
    this.lEd = getRotation();
    if (this.lDY != null)
    {
      ((ViewGroup)this.kFh.getParent()).setVisibility(0);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.kFh.getLayoutParams();
      if ((this.lEc) && (this.qI != null))
      {
        Rect localRect = new Rect();
        this.qI.getWindowVisibleDisplayFrame(localRect);
        localLayoutParams.width = localRect.right;
      }
      this.kFh.setLayoutParams(localLayoutParams);
      if (Build.VERSION.SDK_INT >= 21) {
        this.lDY.getWindow().addFlags(-2147483648);
      }
      if ((this.tds) && (Build.VERSION.SDK_INT >= 23) && (this.lDY != null))
      {
        this.lDY.getWindow().getDecorView().setSystemUiVisibility(9216);
        this.lDY.getWindow().setStatusBarColor(0);
      }
      if (!this.lEf) {
        break label308;
      }
      this.lDY.getWindow().setFlags(8, 8);
      this.lDY.getWindow().addFlags(131200);
      this.lDY.getWindow().getDecorView().setSystemUiVisibility(6);
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
        this.lDY.show();
      }
      if (this.lEb != null) {
        this.lEb.nZ = false;
      }
      AppMethodBeat.o(178061);
      return;
      this.lDY.getWindow().clearFlags(8);
      this.lDY.getWindow().clearFlags(131072);
      this.lDY.getWindow().clearFlags(128);
      this.lDY.getWindow().getDecorView().setSystemUiVisibility(0);
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
        bqD();
        AppMethodBeat.o(178058);
        return;
      }
      if ((isShowing()) && ((this.lEc != aoA()) || (this.lEd != getRotation()))) {
        bqD();
      }
    }
    AppMethodBeat.o(178058);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.d
 * JD-Core Version:    0.7.0.1
 */