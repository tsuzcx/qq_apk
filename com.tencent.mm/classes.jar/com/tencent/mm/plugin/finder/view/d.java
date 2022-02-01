package com.tencent.mm.plugin.finder.view;

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
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout.d;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ck.a.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.widget.a.l;
import com.tencent.mm.w.a.a.a.b;
import com.tencent.mm.w.a.a.a.j;
import java.util.LinkedList;

@Deprecated
public class d
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private boolean GwR;
  public boolean GwS;
  public b GwT;
  private LinearLayout GwU;
  View GwV;
  private TextView GwW;
  private a GwX;
  protected int GwY;
  protected boolean GwZ;
  ViewGroup Gxa;
  private ViewGroup Gxb;
  private LinkedList<Object> Gxc;
  private n Gxd;
  protected int bO;
  protected Context mContext;
  protected View mF;
  private ViewTreeObserver mP;
  private int muY;
  public View rootView;
  private boolean sRA;
  protected Dialog sRs;
  protected BottomSheetBehavior sRv;
  private boolean sRw;
  private int sRx;
  private boolean sRz;
  
  public d(Context paramContext)
  {
    this(paramContext, (byte)0);
    AppMethodBeat.i(178057);
    AppMethodBeat.o(178057);
  }
  
  private d(Context paramContext, byte paramByte)
  {
    this(paramContext, (short)0);
  }
  
  public d(Context paramContext, char paramChar)
  {
    this(paramContext, 0, true);
  }
  
  private d(Context paramContext, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(344760);
    this.sRw = false;
    this.GwS = false;
    this.sRz = false;
    this.sRA = false;
    this.GwT = null;
    this.GwY = a.j.BottomSheetDialog;
    this.Gxc = new LinkedList();
    this.Gxd = new n();
    this.mContext = paramContext;
    this.sRA = false;
    if ((this.mContext instanceof Activity)) {
      this.mF = ((ViewGroup)((Activity)this.mContext).getWindow().getDecorView()).findViewById(16908290);
    }
    this.bO = 0;
    L(this.mContext, paramBoolean);
    AppMethodBeat.o(344760);
  }
  
  private d(Context paramContext, short paramShort)
  {
    this(paramContext, 0, false);
  }
  
  private void fkg()
  {
    AppMethodBeat.i(344773);
    if (this.sRv != null)
    {
      if (this.bO > 0)
      {
        this.sRv.setState(4);
        this.sRv.setPeekHeight(this.bO);
        AppMethodBeat.o(344773);
        return;
      }
      this.sRv.setState(3);
    }
    AppMethodBeat.o(344773);
  }
  
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
  
  protected void L(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(344839);
    if (this.sRA) {
      this.sRs = new g(paramContext);
    }
    for (;;)
    {
      this.rootView = View.inflate(paramContext, com.tencent.mm.w.a.a.a.f.finder_mm_bottom_sheet, null);
      this.Gxa = ((ViewGroup)this.rootView.findViewById(com.tencent.mm.w.a.a.a.e.bottom_sheet_content_container));
      this.Gxb = ((ViewGroup)this.rootView.findViewById(com.tencent.mm.w.a.a.a.e.bottom_sheet_page_container));
      this.GwU = ((LinearLayout)this.rootView.findViewById(com.tencent.mm.ck.a.f.bottom_sheet_cancel));
      this.GwV = this.rootView.findViewById(com.tencent.mm.ck.a.f.cancel_space);
      this.GwW = ((TextView)this.rootView.findViewById(com.tencent.mm.ck.a.f.cancel_text));
      this.GwU.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(345336);
          b localb = new b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderBottomSheet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          d.this.cyW();
          if (d.a(d.this) != null) {
            d.a(d.this);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderBottomSheet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(345336);
        }
      });
      this.sRw = isLandscape();
      this.sRs.requestWindowFeature(1);
      this.sRs.setContentView(this.rootView);
      if ((!this.sRA) && (!paramBoolean))
      {
        this.sRv = BottomSheetBehavior.cC((View)this.rootView.getParent());
        fkg();
      }
      this.sRs.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(178056);
          if (d.b(d.this) != null)
          {
            if (!d.b(d.this).isAlive()) {
              d.a(d.this, d.this.mF.getViewTreeObserver());
            }
            d.b(d.this).removeGlobalOnLayoutListener(d.this);
            d.a(d.this, null);
          }
          if (!d.c(d.this)) {
            d.this.sRs = null;
          }
          if (d.d(d.this) != null) {
            d.d(d.this).onDismiss();
          }
          d.e(d.this).removeAllViews();
          d.f(d.this).clear();
          AppMethodBeat.o(178056);
        }
      });
      AppMethodBeat.o(344839);
      return;
      if (paramBoolean) {
        this.sRs = new l(paramContext, a.j.CustomSheetStyle);
      } else {
        this.sRs = new com.google.android.material.bottomsheet.a(paramContext, this.GwY);
      }
    }
  }
  
  public final d UD(int paramInt)
  {
    AppMethodBeat.i(344844);
    LayoutInflater.from(this.rootView.getContext()).inflate(paramInt, this.Gxa, true);
    AppMethodBeat.o(344844);
    return this;
  }
  
  public final void UE(int paramInt)
  {
    AppMethodBeat.i(344895);
    if (this.GwW != null) {
      this.GwW.setTextColor(paramInt);
    }
    AppMethodBeat.o(344895);
  }
  
  public final d a(View paramView, FrameLayout.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(344854);
    this.Gxa.addView(paramView, 0, paramLayoutParams);
    AppMethodBeat.o(344854);
    return this;
  }
  
  public final void cyW()
  {
    AppMethodBeat.i(178062);
    if (this.sRs != null)
    {
      if ((!(this.mContext instanceof Activity)) || ((this.mContext != null) && (!((Activity)this.mContext).isFinishing()) && (!((Activity)this.mContext).isDestroyed()))) {
        this.sRs.dismiss();
      }
      if (this.sRv != null) {
        this.sRv.dqC = true;
      }
    }
    AppMethodBeat.o(178062);
  }
  
  public void dDn()
  {
    AppMethodBeat.i(178061);
    this.sRw = isLandscape();
    this.sRx = getRotation();
    if (this.sRs != null)
    {
      ((ViewGroup)this.rootView.getParent()).setVisibility(0);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.rootView.getLayoutParams();
      if ((!this.sRA) && (this.sRw) && (this.mF != null))
      {
        Object localObject = new Rect();
        this.mF.getWindowVisibleDisplayFrame((Rect)localObject);
        localLayoutParams.width = Math.min(((Rect)localObject).right, ((Rect)localObject).bottom);
        localLayoutParams.gravity = 1;
        localObject = this.rootView.getParent();
        if ((localObject instanceof View)) {
          ((View)localObject).setOnTouchListener(new d.3(this, (ViewParent)localObject));
        }
        if (((localObject instanceof ViewGroup)) && ((((ViewGroup)localObject).getLayoutParams() instanceof CoordinatorLayout.d)))
        {
          localObject = (CoordinatorLayout.d)((ViewGroup)localObject).getLayoutParams();
          BottomSheetBehavior local4 = new BottomSheetBehavior() {};
          ((CoordinatorLayout.d)localObject).a(local4);
          this.sRv = local4;
          fkg();
        }
      }
      this.rootView.setLayoutParams(localLayoutParams);
      if (Build.VERSION.SDK_INT >= 21) {
        this.sRs.getWindow().addFlags(-2147483648);
      }
      if ((this.GwR) && (Build.VERSION.SDK_INT >= 23) && (this.sRs != null))
      {
        this.sRs.getWindow().getDecorView().setSystemUiVisibility(9216);
        this.sRs.getWindow().setStatusBarColor(0);
      }
      if (!this.sRz) {
        break label420;
      }
      this.sRs.getWindow().setFlags(8, 8);
      this.sRs.getWindow().addFlags(131200);
      this.sRs.getWindow().getDecorView().setSystemUiVisibility(6);
      if (this.mF != null) {
        if (this.mP != null) {
          break label475;
        }
      }
    }
    label420:
    label475:
    for (int i = 1;; i = 0)
    {
      this.mP = this.mF.getViewTreeObserver();
      if (i != 0) {
        this.mP.addOnGlobalLayoutListener(this);
      }
      if (((this.mContext instanceof Activity)) && (!((Activity)this.mContext).isFinishing())) {
        this.sRs.show();
      }
      if (this.sRv != null) {
        this.sRv.dqC = this.GwZ;
      }
      AppMethodBeat.o(178061);
      return;
      this.sRs.getWindow().clearFlags(8);
      this.sRs.getWindow().clearFlags(131072);
      this.sRs.getWindow().clearFlags(128);
      this.sRs.getWindow().getDecorView().setSystemUiVisibility(0);
      break;
    }
  }
  
  public final void fkh()
  {
    AppMethodBeat.i(344850);
    this.Gxa.setBackgroundColor(this.mContext.getResources().getColor(a.b.transparent));
    AppMethodBeat.o(344850);
  }
  
  public final d fki()
  {
    AppMethodBeat.i(344888);
    if (this.rootView != null)
    {
      this.Gxa.setBackgroundResource(com.tencent.mm.ck.a.e.up_corner_dark_bg);
      this.GwV.setBackgroundColor(this.mContext.getResources().getColor(a.c.Dark_1));
      this.GwW.setTextColor(this.mContext.getResources().getColor(a.c.BW_100_Alpha_0_8));
      this.GwW.setBackgroundResource(com.tencent.mm.ck.a.e.dark_list_item_selector);
    }
    AppMethodBeat.o(344888);
    return this;
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(178063);
    if ((this.sRs != null) && (this.sRs.isShowing()))
    {
      AppMethodBeat.o(178063);
      return true;
    }
    AppMethodBeat.o(178063);
    return false;
  }
  
  public void onGlobalLayout()
  {
    AppMethodBeat.i(178058);
    if (isShowing())
    {
      Object localObject = this.mF;
      if ((localObject == null) || ((!((View)localObject).isShown()) && (((View)localObject).getVisibility() != 0)))
      {
        cyW();
        AppMethodBeat.o(178058);
        return;
      }
      if (isShowing())
      {
        if ((this.sRw != isLandscape()) || (this.sRx != getRotation()))
        {
          cyW();
          AppMethodBeat.o(178058);
          return;
        }
        if (this.muY != this.Gxa.getHeight())
        {
          this.muY = this.Gxa.getHeight();
          int i = this.Gxa.getWidth();
          localObject = (FrameLayout.LayoutParams)this.Gxb.getLayoutParams();
          ((FrameLayout.LayoutParams)localObject).height = this.muY;
          ((FrameLayout.LayoutParams)localObject).width = i;
          ((FrameLayout.LayoutParams)localObject).gravity = 85;
          this.Gxb.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
    }
    AppMethodBeat.o(178058);
  }
  
  public final void uR(boolean paramBoolean)
  {
    AppMethodBeat.i(344881);
    if (this.GwU == null)
    {
      AppMethodBeat.o(344881);
      return;
    }
    if (paramBoolean)
    {
      this.GwU.setVisibility(8);
      AppMethodBeat.o(344881);
      return;
    }
    this.GwU.setVisibility(0);
    AppMethodBeat.o(344881);
  }
  
  public static abstract interface a {}
  
  public static abstract interface b
  {
    public abstract void onDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.d
 * JD-Core Version:    0.7.0.1
 */