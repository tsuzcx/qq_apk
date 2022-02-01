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
  private ViewTreeObserver afI;
  public View lJI;
  private Context mContext;
  private Dialog mLH;
  private BottomSheetBehavior mLK;
  private boolean mLL;
  private int mLM;
  private boolean mLO;
  private boolean mLP;
  private View qK;
  private boolean wjM;
  private boolean wjN;
  private a wjO;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(178057);
    this.mLL = false;
    this.wjN = false;
    this.mLO = false;
    this.mLP = false;
    this.wjO = null;
    this.mContext = paramContext;
    if ((this.mContext instanceof Activity)) {
      this.qK = ((ViewGroup)((Activity)this.mContext).getWindow().getDecorView()).findViewById(16908290);
    }
    paramContext = this.mContext;
    if (this.mLP) {}
    for (this.mLH = new b(paramContext);; this.mLH = new a(paramContext, 2131820791))
    {
      this.lJI = View.inflate(paramContext, 2131494515, null);
      this.mLL = isLandscape();
      this.mLH.setContentView(this.lJI);
      this.mLK = BottomSheetBehavior.l((View)this.lJI.getParent());
      this.mLK.setState(3);
      this.mLK.ok = new BottomSheetBehavior.a()
      {
        public final void f(View paramAnonymousView, int paramAnonymousInt) {}
        
        public final void m(View paramAnonymousView) {}
      };
      this.mLH.setOnDismissListener(new DialogInterface.OnDismissListener()
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
          if (d.e(d.this) != null) {
            d.e(d.this).onDismiss();
          }
          AppMethodBeat.o(178056);
        }
      });
      AppMethodBeat.o(178057);
      return;
    }
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
  
  private boolean isLandscape()
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
  
  private boolean isShowing()
  {
    AppMethodBeat.i(178063);
    if ((this.mLH != null) && (this.mLH.isShowing()))
    {
      AppMethodBeat.o(178063);
      return true;
    }
    AppMethodBeat.o(178063);
    return false;
  }
  
  public final d Ml(int paramInt)
  {
    AppMethodBeat.i(241821);
    LinearLayout localLinearLayout = (LinearLayout)this.lJI.findViewById(2131297695);
    LayoutInflater.from(this.lJI.getContext()).inflate(paramInt, localLinearLayout, true);
    AppMethodBeat.o(241821);
    return this;
  }
  
  public final void a(a parama)
  {
    this.wjO = parama;
  }
  
  public final void bMo()
  {
    AppMethodBeat.i(178062);
    if (this.mLH != null)
    {
      if ((!(this.mContext instanceof Activity)) || ((this.mContext != null) && (!((Activity)this.mContext).isFinishing()) && (!((Activity)this.mContext).isDestroyed()))) {
        this.mLH.dismiss();
      }
      if (this.mLK != null) {
        this.mLK.ob = true;
      }
    }
    AppMethodBeat.o(178062);
  }
  
  public final void dGm()
  {
    AppMethodBeat.i(178061);
    this.mLL = isLandscape();
    this.mLM = getRotation();
    if (this.mLH != null)
    {
      ((ViewGroup)this.lJI.getParent()).setVisibility(0);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.lJI.getLayoutParams();
      if ((this.mLL) && (this.qK != null))
      {
        Rect localRect = new Rect();
        this.qK.getWindowVisibleDisplayFrame(localRect);
        localLayoutParams.width = localRect.right;
      }
      this.lJI.setLayoutParams(localLayoutParams);
      if (Build.VERSION.SDK_INT >= 21) {
        this.mLH.getWindow().addFlags(-2147483648);
      }
      if ((this.wjM) && (Build.VERSION.SDK_INT >= 23) && (this.mLH != null))
      {
        this.mLH.getWindow().getDecorView().setSystemUiVisibility(9216);
        this.mLH.getWindow().setStatusBarColor(0);
      }
      if (!this.mLO) {
        break label308;
      }
      this.mLH.getWindow().setFlags(8, 8);
      this.mLH.getWindow().addFlags(131200);
      this.mLH.getWindow().getDecorView().setSystemUiVisibility(6);
      if (this.qK != null) {
        if (this.afI != null) {
          break label363;
        }
      }
    }
    label308:
    label363:
    for (int i = 1;; i = 0)
    {
      this.afI = this.qK.getViewTreeObserver();
      if (i != 0) {
        this.afI.addOnGlobalLayoutListener(this);
      }
      if (((this.mContext instanceof Activity)) && (!((Activity)this.mContext).isFinishing())) {
        this.mLH.show();
      }
      if (this.mLK != null) {
        this.mLK.ob = false;
      }
      AppMethodBeat.o(178061);
      return;
      this.mLH.getWindow().clearFlags(8);
      this.mLH.getWindow().clearFlags(131072);
      this.mLH.getWindow().clearFlags(128);
      this.mLH.getWindow().getDecorView().setSystemUiVisibility(0);
      break;
    }
  }
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(178058);
    if (isShowing())
    {
      View localView = this.qK;
      if ((localView == null) || ((!localView.isShown()) && (localView.getVisibility() != 0)))
      {
        bMo();
        AppMethodBeat.o(178058);
        return;
      }
      if ((isShowing()) && ((this.mLL != isLandscape()) || (this.mLM != getRotation()))) {
        bMo();
      }
    }
    AppMethodBeat.o(178058);
  }
  
  public static abstract interface a
  {
    public abstract void onDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.d
 * JD-Core Version:    0.7.0.1
 */