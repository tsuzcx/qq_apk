package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.ah;
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

final class t
  extends m
  implements o, View.OnKeyListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener
{
  private static final int afn = 2131492927;
  private boolean XI;
  private final h aaQ;
  View afA;
  private o.a afH;
  ViewTreeObserver afI;
  private PopupWindow.OnDismissListener afJ;
  private final int afp;
  private final int afq;
  private final boolean afr;
  final ViewTreeObserver.OnGlobalLayoutListener afv = new ViewTreeObserver.OnGlobalLayoutListener()
  {
    public final void onGlobalLayout()
    {
      if ((t.this.isShowing()) && (!t.this.ahj.arz))
      {
        View localView = t.this.afA;
        if ((localView == null) || (!localView.isShown())) {
          t.this.dismiss();
        }
      }
      else
      {
        return;
      }
      t.this.ahj.show();
    }
  };
  private final View.OnAttachStateChangeListener afw = new View.OnAttachStateChangeListener()
  {
    public final void onViewAttachedToWindow(View paramAnonymousView) {}
    
    public final void onViewDetachedFromWindow(View paramAnonymousView)
    {
      if (t.this.afI != null)
      {
        if (!t.this.afI.isAlive()) {
          t.this.afI = paramAnonymousView.getViewTreeObserver();
        }
        t.this.afI.removeGlobalOnLayoutListener(t.this.afv);
      }
      paramAnonymousView.removeOnAttachStateChangeListener(this);
    }
  };
  private int afz = 0;
  private final g ahh;
  private final int ahi;
  final ah ahj;
  private boolean ahk;
  private boolean ahl;
  private int ahm;
  private final Context mContext;
  private View qK;
  
  public t(Context paramContext, h paramh, View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.aaQ = paramh;
    this.afr = paramBoolean;
    this.ahh = new g(paramh, LayoutInflater.from(paramContext), this.afr, afn);
    this.afp = paramInt1;
    this.afq = paramInt2;
    Resources localResources = paramContext.getResources();
    this.ahi = Math.max(localResources.getDisplayMetrics().widthPixels / 2, localResources.getDimensionPixelSize(2131165673));
    this.qK = paramView;
    this.ahj = new ah(this.mContext, this.afp, this.afq);
    paramh.a(this, paramContext);
  }
  
  public final void a(h paramh, boolean paramBoolean)
  {
    if (paramh != this.aaQ) {}
    do
    {
      return;
      dismiss();
    } while (this.afH == null);
    this.afH.a(paramh, paramBoolean);
  }
  
  public final void a(o.a parama)
  {
    this.afH = parama;
  }
  
  public final boolean a(u paramu)
  {
    if (paramu.hasVisibleItems())
    {
      n localn = new n(this.mContext, paramu, this.afA, this.afr, this.afp, this.afq);
      localn.c(this.afH);
      localn.setForceShowIcon(m.h(paramu));
      localn.afJ = this.afJ;
      this.afJ = null;
      this.aaQ.aa(false);
      int j = this.ahj.are;
      int k = this.ahj.getVerticalOffset();
      int i = j;
      if ((Gravity.getAbsoluteGravity(this.afz, android.support.v4.view.u.Z(this.qK)) & 0x7) == 5) {
        i = j + this.qK.getWidth();
      }
      if (localn.isShowing()) {
        i = 1;
      }
      while (i != 0)
      {
        if (this.afH != null) {
          this.afH.d(paramu);
        }
        return true;
        if (localn.qK == null)
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
    return false;
  }
  
  public final boolean bF()
  {
    return false;
  }
  
  public final void dismiss()
  {
    if (isShowing()) {
      this.ahj.dismiss();
    }
  }
  
  public final void f(h paramh) {}
  
  public final ListView getListView()
  {
    return this.ahj.arc;
  }
  
  public final boolean isShowing()
  {
    return (!this.ahk) && (this.ahj.arA.isShowing());
  }
  
  public final void onDismiss()
  {
    this.ahk = true;
    this.aaQ.close();
    if (this.afI != null)
    {
      if (!this.afI.isAlive()) {
        this.afI = this.afA.getViewTreeObserver();
      }
      this.afI.removeGlobalOnLayoutListener(this.afv);
      this.afI = null;
    }
    this.afA.removeOnAttachStateChangeListener(this.afw);
    if (this.afJ != null) {
      this.afJ.onDismiss();
    }
  }
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getAction() == 1) && (paramInt == 82))
    {
      dismiss();
      return true;
    }
    return false;
  }
  
  public final void onRestoreInstanceState(Parcelable paramParcelable) {}
  
  public final Parcelable onSaveInstanceState()
  {
    return null;
  }
  
  public final void p(boolean paramBoolean)
  {
    this.ahl = false;
    if (this.ahh != null) {
      this.ahh.notifyDataSetChanged();
    }
  }
  
  public final void setAnchorView(View paramView)
  {
    this.qK = paramView;
  }
  
  public final void setForceShowIcon(boolean paramBoolean)
  {
    this.ahh.afG = paramBoolean;
  }
  
  public final void setGravity(int paramInt)
  {
    this.afz = paramInt;
  }
  
  public final void setHorizontalOffset(int paramInt)
  {
    this.ahj.are = paramInt;
  }
  
  public final void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.afJ = paramOnDismissListener;
  }
  
  public final void setShowTitle(boolean paramBoolean)
  {
    this.XI = paramBoolean;
  }
  
  public final void setVerticalOffset(int paramInt)
  {
    this.ahj.setVerticalOffset(paramInt);
  }
  
  public final void show()
  {
    int j = 1;
    int i;
    if (isShowing()) {
      i = j;
    }
    while (i == 0)
    {
      throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
      if ((this.ahk) || (this.qK == null))
      {
        i = 0;
      }
      else
      {
        this.afA = this.qK;
        this.ahj.setOnDismissListener(this);
        this.ahj.ars = this;
        this.ahj.setModal(true);
        Object localObject = this.afA;
        if (this.afI == null) {}
        for (i = 1;; i = 0)
        {
          this.afI = ((View)localObject).getViewTreeObserver();
          if (i != 0) {
            this.afI.addOnGlobalLayoutListener(this.afv);
          }
          ((View)localObject).addOnAttachStateChangeListener(this.afw);
          this.ahj.arp = ((View)localObject);
          this.ahj.afz = this.afz;
          if (!this.ahl)
          {
            this.ahm = a(this.ahh, null, this.mContext, this.ahi);
            this.ahl = true;
          }
          this.ahj.setContentWidth(this.ahm);
          this.ahj.kC();
          this.ahj.ahd = this.ahd;
          this.ahj.show();
          localObject = this.ahj.arc;
          ((ListView)localObject).setOnKeyListener(this);
          if ((this.XI) && (this.aaQ.agy != null))
          {
            FrameLayout localFrameLayout = (FrameLayout)LayoutInflater.from(this.mContext).inflate(2131492926, (ViewGroup)localObject, false);
            TextView localTextView = (TextView)localFrameLayout.findViewById(16908310);
            if (localTextView != null) {
              localTextView.setText(this.aaQ.agy);
            }
            localFrameLayout.setEnabled(false);
            ((ListView)localObject).addHeaderView(localFrameLayout, null, false);
          }
          this.ahj.setAdapter(this.ahh);
          this.ahj.show();
          i = j;
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.t
 * JD-Core Version:    0.7.0.1
 */