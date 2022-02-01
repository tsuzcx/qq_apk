package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import androidx.appcompat.a.d;
import androidx.appcompat.a.g;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.core.g.w;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class t
  extends m
  implements View.OnKeyListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener
{
  private static final int lw = a.g.abc_popup_menu_item_layout;
  private boolean eX;
  private final h is;
  private final boolean lA;
  final ViewTreeObserver.OnGlobalLayoutListener lE;
  private final View.OnAttachStateChangeListener lF;
  private int lI;
  private View lJ;
  View lK;
  private o.a lR;
  ViewTreeObserver lS;
  private PopupWindow.OnDismissListener lT;
  private final int ly;
  private final int lz;
  private final Context mContext;
  private final g nu;
  private final int nv;
  final androidx.appcompat.widget.t nw;
  private boolean nx;
  private boolean ny;
  private int nz;
  
  public t(Context paramContext, h paramh, View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(239850);
    this.lE = new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(239843);
        if ((t.this.isShowing()) && (!t.this.nw.tx))
        {
          View localView = t.this.lK;
          if ((localView == null) || (!localView.isShown()))
          {
            t.this.dismiss();
            AppMethodBeat.o(239843);
            return;
          }
          t.this.nw.show();
        }
        AppMethodBeat.o(239843);
      }
    };
    this.lF = new View.OnAttachStateChangeListener()
    {
      public final void onViewAttachedToWindow(View paramAnonymousView) {}
      
      public final void onViewDetachedFromWindow(View paramAnonymousView)
      {
        AppMethodBeat.i(239849);
        if (t.this.lS != null)
        {
          if (!t.this.lS.isAlive()) {
            t.this.lS = paramAnonymousView.getViewTreeObserver();
          }
          t.this.lS.removeGlobalOnLayoutListener(t.this.lE);
        }
        paramAnonymousView.removeOnAttachStateChangeListener(this);
        AppMethodBeat.o(239849);
      }
    };
    this.lI = 0;
    this.mContext = paramContext;
    this.is = paramh;
    this.lA = paramBoolean;
    this.nu = new g(paramh, LayoutInflater.from(paramContext), this.lA, lw);
    this.ly = paramInt1;
    this.lz = paramInt2;
    Resources localResources = paramContext.getResources();
    this.nv = Math.max(localResources.getDisplayMetrics().widthPixels / 2, localResources.getDimensionPixelSize(a.d.abc_config_prefDialogWidth));
    this.lJ = paramView;
    this.nw = new androidx.appcompat.widget.t(this.mContext, this.ly, this.lz);
    paramh.a(this, paramContext);
    AppMethodBeat.o(239850);
  }
  
  public final void F(boolean paramBoolean)
  {
    AppMethodBeat.i(239861);
    this.ny = false;
    if (this.nu != null) {
      this.nu.notifyDataSetChanged();
    }
    AppMethodBeat.o(239861);
  }
  
  public final void a(h paramh, boolean paramBoolean)
  {
    AppMethodBeat.i(239867);
    if (paramh != this.is)
    {
      AppMethodBeat.o(239867);
      return;
    }
    dismiss();
    if (this.lR != null) {
      this.lR.a(paramh, paramBoolean);
    }
    AppMethodBeat.o(239867);
  }
  
  public final boolean a(u paramu)
  {
    AppMethodBeat.i(239865);
    if (paramu.hasVisibleItems())
    {
      n localn = new n(this.mContext, paramu, this.lK, this.lA, this.ly, this.lz);
      localn.c(this.lR);
      localn.setForceShowIcon(m.h(paramu));
      localn.lT = this.lT;
      this.lT = null;
      this.is.G(false);
      int j = this.nw.ta;
      int k = this.nw.dL();
      int i = j;
      if ((Gravity.getAbsoluteGravity(this.lI, w.I(this.lJ)) & 0x7) == 5) {
        i = j + this.lJ.getWidth();
      }
      if (localn.isShowing()) {
        i = 1;
      }
      while (i != 0)
      {
        if (this.lR != null) {
          this.lR.c(paramu);
        }
        AppMethodBeat.o(239865);
        return true;
        if (localn.lJ == null)
        {
          i = 0;
        }
        else
        {
          localn.b(i, k, true, true);
          i = 1;
        }
      }
    }
    AppMethodBeat.o(239865);
    return false;
  }
  
  public final void ag(int paramInt)
  {
    this.nw.ta = paramInt;
  }
  
  public final void ah(int paramInt)
  {
    AppMethodBeat.i(239877);
    this.nw.ah(paramInt);
    AppMethodBeat.o(239877);
  }
  
  public final void b(o.a parama)
  {
    this.lR = parama;
  }
  
  public final boolean bS()
  {
    return false;
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(239852);
    if (isShowing()) {
      this.nw.dismiss();
    }
    AppMethodBeat.o(239852);
  }
  
  public final void e(h paramh) {}
  
  public final ListView getListView()
  {
    return this.nw.sY;
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(239855);
    if ((!this.nx) && (this.nw.ty.isShowing()))
    {
      AppMethodBeat.o(239855);
      return true;
    }
    AppMethodBeat.o(239855);
    return false;
  }
  
  public final void onDismiss()
  {
    AppMethodBeat.i(239859);
    this.nx = true;
    this.is.close();
    if (this.lS != null)
    {
      if (!this.lS.isAlive()) {
        this.lS = this.lK.getViewTreeObserver();
      }
      this.lS.removeGlobalOnLayoutListener(this.lE);
      this.lS = null;
    }
    this.lK.removeOnAttachStateChangeListener(this.lF);
    if (this.lT != null) {
      this.lT.onDismiss();
    }
    AppMethodBeat.o(239859);
  }
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(239871);
    if ((paramKeyEvent.getAction() == 1) && (paramInt == 82))
    {
      dismiss();
      AppMethodBeat.o(239871);
      return true;
    }
    AppMethodBeat.o(239871);
    return false;
  }
  
  public final void onRestoreInstanceState(Parcelable paramParcelable) {}
  
  public final Parcelable onSaveInstanceState()
  {
    return null;
  }
  
  public final void setAnchorView(View paramView)
  {
    this.lJ = paramView;
  }
  
  public final void setForceShowIcon(boolean paramBoolean)
  {
    this.nu.lQ = paramBoolean;
  }
  
  public final void setGravity(int paramInt)
  {
    this.lI = paramInt;
  }
  
  public final void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.lT = paramOnDismissListener;
  }
  
  public final void setShowTitle(boolean paramBoolean)
  {
    this.eX = paramBoolean;
  }
  
  public final void show()
  {
    int j = 1;
    AppMethodBeat.i(239851);
    int i;
    if (isShowing()) {
      i = j;
    }
    while (i == 0)
    {
      Object localObject = new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
      AppMethodBeat.o(239851);
      throw ((Throwable)localObject);
      if ((this.nx) || (this.lJ == null))
      {
        i = 0;
      }
      else
      {
        this.lK = this.lJ;
        this.nw.setOnDismissListener(this);
        this.nw.tp = this;
        this.nw.P(true);
        localObject = this.lK;
        if (this.lS == null) {}
        for (i = 1;; i = 0)
        {
          this.lS = ((View)localObject).getViewTreeObserver();
          if (i != 0) {
            this.lS.addOnGlobalLayoutListener(this.lE);
          }
          ((View)localObject).addOnAttachStateChangeListener(this.lF);
          this.nw.tl = ((View)localObject);
          this.nw.lI = this.lI;
          if (!this.ny)
          {
            this.nz = a(this.nu, null, this.mContext, this.nv);
            this.ny = true;
          }
          this.nw.setContentWidth(this.nz);
          this.nw.dN();
          this.nw.nq = this.nq;
          this.nw.show();
          localObject = this.nw.sY;
          ((ListView)localObject).setOnKeyListener(this);
          if ((this.eX) && (this.is.mJ != null))
          {
            FrameLayout localFrameLayout = (FrameLayout)LayoutInflater.from(this.mContext).inflate(a.g.abc_popup_menu_header_item_layout, (ViewGroup)localObject, false);
            TextView localTextView = (TextView)localFrameLayout.findViewById(16908310);
            if (localTextView != null) {
              localTextView.setText(this.is.mJ);
            }
            localFrameLayout.setEnabled(false);
            ((ListView)localObject).addHeaderView(localFrameLayout, null, false);
          }
          this.nw.setAdapter(this.nu);
          this.nw.show();
          i = j;
          break;
        }
      }
    }
    AppMethodBeat.o(239851);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.view.menu.t
 * JD-Core Version:    0.7.0.1
 */