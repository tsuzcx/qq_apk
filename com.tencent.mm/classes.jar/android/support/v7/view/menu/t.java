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
  private static final int Vk = 2130968603;
  private boolean NG;
  private o.a VE;
  ViewTreeObserver VF;
  private PopupWindow.OnDismissListener VG;
  private final int Vm;
  private final int Vn;
  private final boolean Vo;
  final ViewTreeObserver.OnGlobalLayoutListener Vs = new ViewTreeObserver.OnGlobalLayoutListener()
  {
    public final void onGlobalLayout()
    {
      if ((t.this.isShowing()) && (!t.this.Xg.ahs))
      {
        View localView = t.this.Vx;
        if ((localView == null) || (!localView.isShown())) {
          t.this.dismiss();
        }
      }
      else
      {
        return;
      }
      t.this.Xg.show();
    }
  };
  private final View.OnAttachStateChangeListener Vt = new View.OnAttachStateChangeListener()
  {
    public final void onViewAttachedToWindow(View paramAnonymousView) {}
    
    public final void onViewDetachedFromWindow(View paramAnonymousView)
    {
      if (t.this.VF != null)
      {
        if (!t.this.VF.isAlive()) {
          t.this.VF = paramAnonymousView.getViewTreeObserver();
        }
        t.this.VF.removeGlobalOnLayoutListener(t.this.Vs);
      }
      paramAnonymousView.removeOnAttachStateChangeListener(this);
    }
  };
  private int Vw = 0;
  View Vx;
  private final g Xe;
  private final int Xf;
  final ah Xg;
  private boolean Xh;
  private boolean Xi;
  private int Xj;
  private final h eq;
  private View iU;
  private final Context mContext;
  
  public t(Context paramContext, h paramh, View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.eq = paramh;
    this.Vo = paramBoolean;
    this.Xe = new g(paramh, LayoutInflater.from(paramContext), this.Vo, Vk);
    this.Vm = paramInt1;
    this.Vn = paramInt2;
    Resources localResources = paramContext.getResources();
    this.Xf = Math.max(localResources.getDisplayMetrics().widthPixels / 2, localResources.getDimensionPixelSize(2131427360));
    this.iU = paramView;
    this.Xg = new ah(this.mContext, this.Vm, this.Vn);
    paramh.a(this, paramContext);
  }
  
  public final void a(h paramh, boolean paramBoolean)
  {
    if (paramh != this.eq) {}
    do
    {
      return;
      dismiss();
    } while (this.VE == null);
    this.VE.a(paramh, paramBoolean);
  }
  
  public final void a(o.a parama)
  {
    this.VE = parama;
  }
  
  public final boolean a(u paramu)
  {
    if (paramu.hasVisibleItems())
    {
      n localn = new n(this.mContext, paramu, this.Vx, this.Vo, this.Vm, this.Vn);
      localn.c(this.VE);
      localn.setForceShowIcon(m.h(paramu));
      localn.VG = this.VG;
      this.VG = null;
      this.eq.V(false);
      int j = this.Xg.agY;
      int k = this.Xg.getVerticalOffset();
      int i = j;
      if ((Gravity.getAbsoluteGravity(this.Vw, android.support.v4.view.t.T(this.iU)) & 0x7) == 5) {
        i = j + this.iU.getWidth();
      }
      if (localn.isShowing()) {
        i = 1;
      }
      while (i != 0)
      {
        if (this.VE != null) {
          this.VE.d(paramu);
        }
        return true;
        if (localn.iU == null)
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
  
  public final boolean aG()
  {
    return false;
  }
  
  public final void dismiss()
  {
    if (isShowing()) {
      this.Xg.dismiss();
    }
  }
  
  public final void f(h paramh) {}
  
  public final ListView getListView()
  {
    return this.Xg.agW;
  }
  
  public final boolean isShowing()
  {
    return (!this.Xh) && (this.Xg.aht.isShowing());
  }
  
  public final void n(boolean paramBoolean)
  {
    this.Xi = false;
    if (this.Xe != null) {
      this.Xe.notifyDataSetChanged();
    }
  }
  
  public final void onDismiss()
  {
    this.Xh = true;
    this.eq.close();
    if (this.VF != null)
    {
      if (!this.VF.isAlive()) {
        this.VF = this.Vx.getViewTreeObserver();
      }
      this.VF.removeGlobalOnLayoutListener(this.Vs);
      this.VF = null;
    }
    this.Vx.removeOnAttachStateChangeListener(this.Vt);
    if (this.VG != null) {
      this.VG.onDismiss();
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
  
  public final void setAnchorView(View paramView)
  {
    this.iU = paramView;
  }
  
  public final void setForceShowIcon(boolean paramBoolean)
  {
    this.Xe.VD = paramBoolean;
  }
  
  public final void setGravity(int paramInt)
  {
    this.Vw = paramInt;
  }
  
  public final void setHorizontalOffset(int paramInt)
  {
    this.Xg.agY = paramInt;
  }
  
  public final void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.VG = paramOnDismissListener;
  }
  
  public final void setShowTitle(boolean paramBoolean)
  {
    this.NG = paramBoolean;
  }
  
  public final void setVerticalOffset(int paramInt)
  {
    this.Xg.setVerticalOffset(paramInt);
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
      if ((this.Xh) || (this.iU == null))
      {
        i = 0;
      }
      else
      {
        this.Vx = this.iU;
        this.Xg.setOnDismissListener(this);
        this.Xg.ahl = this;
        this.Xg.setModal(true);
        Object localObject = this.Vx;
        if (this.VF == null) {}
        for (i = 1;; i = 0)
        {
          this.VF = ((View)localObject).getViewTreeObserver();
          if (i != 0) {
            this.VF.addOnGlobalLayoutListener(this.Vs);
          }
          ((View)localObject).addOnAttachStateChangeListener(this.Vt);
          this.Xg.ahj = ((View)localObject);
          this.Xg.Vw = this.Vw;
          if (!this.Xi)
          {
            this.Xj = a(this.Xe, null, this.mContext, this.Xf);
            this.Xi = true;
          }
          this.Xg.setContentWidth(this.Xj);
          this.Xg.iD();
          this.Xg.Xa = this.Xa;
          this.Xg.show();
          localObject = this.Xg.agW;
          ((ListView)localObject).setOnKeyListener(this);
          if ((this.NG) && (this.eq.Wu != null))
          {
            FrameLayout localFrameLayout = (FrameLayout)LayoutInflater.from(this.mContext).inflate(2130968602, (ViewGroup)localObject, false);
            TextView localTextView = (TextView)localFrameLayout.findViewById(16908310);
            if (localTextView != null) {
              localTextView.setText(this.eq.Wu);
            }
            localFrameLayout.setEnabled(false);
            ((ListView)localObject).addHeaderView(localFrameLayout, null, false);
          }
          this.Xg.setAdapter(this.Xe);
          this.Xg.show();
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