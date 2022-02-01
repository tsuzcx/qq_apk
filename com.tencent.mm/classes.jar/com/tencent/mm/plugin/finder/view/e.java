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
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetBehavior.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cr.a.c;
import com.tencent.mm.cr.a.e;
import com.tencent.mm.cr.a.f;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.k;

public final class e
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private boolean AUA;
  private boolean AUB;
  private b AUC;
  private LinearLayout AUD;
  private View AUE;
  private TextView AUF;
  private a AUG;
  protected int AUH;
  protected boolean AUI;
  protected int bO;
  protected View lJ;
  private ViewTreeObserver lS;
  protected Context mContext;
  public View oFW;
  protected BottomSheetBehavior pMC;
  private boolean pMD;
  private int pME;
  private boolean pMG;
  private boolean pMH;
  protected Dialog pMz;
  
  public e(Context paramContext)
  {
    this(paramContext, (byte)0);
    AppMethodBeat.i(178057);
    AppMethodBeat.o(178057);
  }
  
  private e(Context paramContext, byte paramByte)
  {
    AppMethodBeat.i(224947);
    this.pMD = false;
    this.AUB = false;
    this.pMG = false;
    this.pMH = false;
    this.AUC = null;
    this.AUH = b.k.BottomSheetDialog;
    this.mContext = paramContext;
    if ((this.mContext instanceof Activity)) {
      this.lJ = ((ViewGroup)((Activity)this.mContext).getWindow().getDecorView()).findViewById(16908290);
    }
    this.bO = 0;
    paramContext = this.mContext;
    if (this.pMH)
    {
      this.pMz = new com.tencent.mm.ui.widget.a.b(paramContext);
      this.oFW = View.inflate(paramContext, b.g.finder_mm_bottom_sheet, null);
      this.AUD = ((LinearLayout)this.oFW.findViewById(a.f.bottom_sheet_cancel));
      this.AUE = this.oFW.findViewById(a.f.cancel_space);
      this.AUF = ((TextView)this.oFW.findViewById(a.f.cancel_text));
      this.AUD.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(275968);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderBottomSheet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          e.this.bYF();
          if (e.a(e.this) != null) {
            e.a(e.this);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderBottomSheet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(275968);
        }
      });
      this.pMD = isLandscape();
      this.pMz.setContentView(this.oFW);
      this.pMC = BottomSheetBehavior.cg((View)this.oFW.getParent());
      if (this.bO <= 0) {
        break label302;
      }
      this.pMC.setState(4);
      this.pMC.D(this.bO);
    }
    for (;;)
    {
      this.pMC.bxG = new BottomSheetBehavior.a()
      {
        public final void ch(View paramAnonymousView) {}
        
        public final void e(View paramAnonymousView, int paramAnonymousInt)
        {
          AppMethodBeat.i(281010);
          if (paramAnonymousInt == 5) {
            e.this.pMz.cancel();
          }
          AppMethodBeat.o(281010);
        }
      };
      this.pMz.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(282052);
          if (e.b(e.this) != null)
          {
            if (!e.b(e.this).isAlive()) {
              e.a(e.this, e.this.lJ.getViewTreeObserver());
            }
            e.b(e.this).removeGlobalOnLayoutListener(e.this);
            e.a(e.this, null);
          }
          if (!e.c(e.this)) {
            e.this.pMz = null;
          }
          if (e.d(e.this) != null) {
            e.d(e.this).onDismiss();
          }
          AppMethodBeat.o(282052);
        }
      });
      AppMethodBeat.o(224947);
      return;
      this.pMz = new com.google.android.material.bottomsheet.a(paramContext, this.AUH);
      break;
      label302:
      this.pMC.setState(3);
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
  
  public final e RB(int paramInt)
  {
    AppMethodBeat.i(224950);
    LinearLayout localLinearLayout = (LinearLayout)this.oFW.findViewById(b.f.bottom_sheet_custom_layout);
    LayoutInflater.from(this.oFW.getContext()).inflate(paramInt, localLinearLayout, true);
    AppMethodBeat.o(224950);
    return this;
  }
  
  public final void a(b paramb)
  {
    this.AUC = paramb;
  }
  
  public final void bYF()
  {
    AppMethodBeat.i(178062);
    if (this.pMz != null)
    {
      if ((!(this.mContext instanceof Activity)) || ((this.mContext != null) && (!((Activity)this.mContext).isFinishing()) && (!((Activity)this.mContext).isDestroyed()))) {
        this.pMz.dismiss();
      }
      if (this.pMC != null) {
        this.pMC.bxz = true;
      }
    }
    AppMethodBeat.o(178062);
  }
  
  public final void eij()
  {
    AppMethodBeat.i(224952);
    this.oFW.setBackgroundResource(b.e.finder_bottom_corner_shape_dark);
    AppMethodBeat.o(224952);
  }
  
  public final void eik()
  {
    AppMethodBeat.i(178061);
    this.pMD = isLandscape();
    this.pME = getRotation();
    if (this.pMz != null)
    {
      ((ViewGroup)this.oFW.getParent()).setVisibility(0);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.oFW.getLayoutParams();
      if ((this.pMD) && (this.lJ != null))
      {
        Rect localRect = new Rect();
        this.lJ.getWindowVisibleDisplayFrame(localRect);
        localLayoutParams.width = localRect.right;
      }
      this.oFW.setLayoutParams(localLayoutParams);
      if (Build.VERSION.SDK_INT >= 21) {
        this.pMz.getWindow().addFlags(-2147483648);
      }
      if ((this.AUA) && (Build.VERSION.SDK_INT >= 23) && (this.pMz != null))
      {
        this.pMz.getWindow().getDecorView().setSystemUiVisibility(9216);
        this.pMz.getWindow().setStatusBarColor(0);
      }
      if (!this.pMG) {
        break label313;
      }
      this.pMz.getWindow().setFlags(8, 8);
      this.pMz.getWindow().addFlags(131200);
      this.pMz.getWindow().getDecorView().setSystemUiVisibility(6);
      if (this.lJ != null) {
        if (this.lS != null) {
          break label368;
        }
      }
    }
    label313:
    label368:
    for (int i = 1;; i = 0)
    {
      this.lS = this.lJ.getViewTreeObserver();
      if (i != 0) {
        this.lS.addOnGlobalLayoutListener(this);
      }
      if (((this.mContext instanceof Activity)) && (!((Activity)this.mContext).isFinishing())) {
        this.pMz.show();
      }
      if (this.pMC != null) {
        this.pMC.bxz = this.AUI;
      }
      AppMethodBeat.o(178061);
      return;
      this.pMz.getWindow().clearFlags(8);
      this.pMz.getWindow().clearFlags(131072);
      this.pMz.getWindow().clearFlags(128);
      this.pMz.getWindow().getDecorView().setSystemUiVisibility(0);
      break;
    }
  }
  
  public final void eil()
  {
    this.AUB = true;
  }
  
  public final e eim()
  {
    AppMethodBeat.i(224977);
    if (this.oFW != null)
    {
      this.oFW.setBackgroundResource(a.e.up_corner_dark_bg);
      this.AUE.setBackgroundColor(this.mContext.getResources().getColor(a.c.Dark_1));
      this.AUF.setTextColor(this.mContext.getResources().getColor(a.c.BW_100_Alpha_0_8));
      this.AUF.setBackgroundResource(a.e.dark_list_item_selector);
    }
    AppMethodBeat.o(224977);
    return this;
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(178063);
    if ((this.pMz != null) && (this.pMz.isShowing()))
    {
      AppMethodBeat.o(178063);
      return true;
    }
    AppMethodBeat.o(178063);
    return false;
  }
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(178058);
    if (isShowing())
    {
      View localView = this.lJ;
      if ((localView == null) || ((!localView.isShown()) && (localView.getVisibility() != 0)))
      {
        bYF();
        AppMethodBeat.o(178058);
        return;
      }
      if ((isShowing()) && ((this.pMD != isLandscape()) || (this.pME != getRotation()))) {
        bYF();
      }
    }
    AppMethodBeat.o(178058);
  }
  
  public final void rn(boolean paramBoolean)
  {
    AppMethodBeat.i(224973);
    if (this.AUD == null)
    {
      AppMethodBeat.o(224973);
      return;
    }
    if (paramBoolean)
    {
      this.AUD.setVisibility(8);
      AppMethodBeat.o(224973);
      return;
    }
    this.AUD.setVisibility(0);
    AppMethodBeat.o(224973);
  }
  
  public static abstract interface a {}
  
  public static abstract interface b
  {
    public abstract void onDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.e
 * JD-Core Version:    0.7.0.1
 */