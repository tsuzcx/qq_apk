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
  private ViewTreeObserver acK;
  public View jGG;
  private Dialog kBi;
  private BottomSheetBehavior kBl;
  private boolean kBm;
  private int kBn;
  private boolean kBp;
  private boolean kBq;
  private Context mContext;
  private View nO;
  private boolean qVs;
  private boolean qVt;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(178057);
    this.kBm = false;
    this.qVt = false;
    this.kBp = false;
    this.kBq = false;
    this.mContext = paramContext;
    if ((this.mContext instanceof Activity)) {
      this.nO = ((ViewGroup)((Activity)this.mContext).getWindow().getDecorView()).findViewById(16908290);
    }
    paramContext = this.mContext;
    if (this.kBq) {}
    for (this.kBi = new b(paramContext);; this.kBi = new a(paramContext, 2131820788))
    {
      this.jGG = View.inflate(paramContext, 2131494069, null);
      this.kBm = aov();
      this.kBi.setContentView(this.jGG);
      this.kBl = BottomSheetBehavior.l((View)this.jGG.getParent());
      this.kBl.setState(3);
      this.kBl.lq = new BottomSheetBehavior.a()
      {
        public final void N(int paramAnonymousInt) {}
        
        public final void h(float paramAnonymousFloat) {}
      };
      this.kBi.setOnDismissListener(new DialogInterface.OnDismissListener()
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
  
  private boolean aov()
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
    if ((this.kBi != null) && (this.kBi.isShowing()))
    {
      AppMethodBeat.o(178063);
      return true;
    }
    AppMethodBeat.o(178063);
    return false;
  }
  
  public final c Do(int paramInt)
  {
    AppMethodBeat.i(190861);
    LinearLayout localLinearLayout = (LinearLayout)this.jGG.findViewById(2131297461);
    LayoutInflater.from(this.jGG.getContext()).inflate(paramInt, localLinearLayout, true);
    AppMethodBeat.o(190861);
    return this;
  }
  
  public final void bfo()
  {
    AppMethodBeat.i(178062);
    if (this.kBi != null)
    {
      if ((!(this.mContext instanceof Activity)) || ((this.mContext != null) && (!((Activity)this.mContext).isFinishing()) && (!((Activity)this.mContext).isDestroyed()))) {
        this.kBi.dismiss();
      }
      if (this.kBl != null) {
        this.kBl.lh = true;
      }
    }
    AppMethodBeat.o(178062);
  }
  
  public final void csG()
  {
    AppMethodBeat.i(178061);
    this.kBm = aov();
    this.kBn = getRotation();
    if (this.kBi != null)
    {
      ((ViewGroup)this.jGG.getParent()).setVisibility(0);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jGG.getLayoutParams();
      if ((this.kBm) && (this.nO != null))
      {
        Rect localRect = new Rect();
        this.nO.getWindowVisibleDisplayFrame(localRect);
        localLayoutParams.width = localRect.right;
      }
      this.jGG.setLayoutParams(localLayoutParams);
      if (Build.VERSION.SDK_INT >= 21) {
        this.kBi.getWindow().addFlags(-2147483648);
      }
      if ((this.qVs) && (Build.VERSION.SDK_INT >= 23) && (this.kBi != null))
      {
        this.kBi.getWindow().getDecorView().setSystemUiVisibility(9216);
        this.kBi.getWindow().setStatusBarColor(0);
      }
      if (!this.kBp) {
        break label308;
      }
      this.kBi.getWindow().setFlags(8, 8);
      this.kBi.getWindow().addFlags(131200);
      this.kBi.getWindow().getDecorView().setSystemUiVisibility(6);
      if (this.nO != null) {
        if (this.acK != null) {
          break label363;
        }
      }
    }
    label308:
    label363:
    for (int i = 1;; i = 0)
    {
      this.acK = this.nO.getViewTreeObserver();
      if (i != 0) {
        this.acK.addOnGlobalLayoutListener(this);
      }
      if (((this.mContext instanceof Activity)) && (!((Activity)this.mContext).isFinishing())) {
        this.kBi.show();
      }
      if (this.kBl != null) {
        this.kBl.lh = false;
      }
      AppMethodBeat.o(178061);
      return;
      this.kBi.getWindow().clearFlags(8);
      this.kBi.getWindow().clearFlags(131072);
      this.kBi.getWindow().clearFlags(128);
      this.kBi.getWindow().getDecorView().setSystemUiVisibility(0);
      break;
    }
  }
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(178058);
    if (isShowing())
    {
      View localView = this.nO;
      if ((localView == null) || ((!localView.isShown()) && (localView.getVisibility() != 0)))
      {
        bfo();
        AppMethodBeat.o(178058);
        return;
      }
      if ((isShowing()) && ((this.kBm != aov()) || (this.kBn != getRotation()))) {
        bfo();
      }
    }
    AppMethodBeat.o(178058);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.c
 * JD-Core Version:    0.7.0.1
 */