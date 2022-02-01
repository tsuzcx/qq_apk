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
  private static final int afa = 2131492910;
  private boolean Xv;
  private final h aaD;
  private final int afc;
  private final int afd;
  private final boolean afe;
  final ViewTreeObserver.OnGlobalLayoutListener afi = new ViewTreeObserver.OnGlobalLayoutListener()
  {
    public final void onGlobalLayout()
    {
      if ((t.this.isShowing()) && (!t.this.agW.arm))
      {
        View localView = t.this.afn;
        if ((localView == null) || (!localView.isShown())) {
          t.this.dismiss();
        }
      }
      else
      {
        return;
      }
      t.this.agW.show();
    }
  };
  private final View.OnAttachStateChangeListener afj = new View.OnAttachStateChangeListener()
  {
    public final void onViewAttachedToWindow(View paramAnonymousView) {}
    
    public final void onViewDetachedFromWindow(View paramAnonymousView)
    {
      if (t.this.afv != null)
      {
        if (!t.this.afv.isAlive()) {
          t.this.afv = paramAnonymousView.getViewTreeObserver();
        }
        t.this.afv.removeGlobalOnLayoutListener(t.this.afi);
      }
      paramAnonymousView.removeOnAttachStateChangeListener(this);
    }
  };
  private int afm = 0;
  View afn;
  private o.a afu;
  ViewTreeObserver afv;
  private PopupWindow.OnDismissListener afw;
  private final g agU;
  private final int agV;
  final ah agW;
  private boolean agX;
  private boolean agY;
  private int agZ;
  private final Context mContext;
  private View qI;
  
  public t(Context paramContext, h paramh, View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.aaD = paramh;
    this.afe = paramBoolean;
    this.agU = new g(paramh, LayoutInflater.from(paramContext), this.afe, afa);
    this.afc = paramInt1;
    this.afd = paramInt2;
    Resources localResources = paramContext.getResources();
    this.agV = Math.max(localResources.getDisplayMetrics().widthPixels / 2, localResources.getDimensionPixelSize(2131165655));
    this.qI = paramView;
    this.agW = new ah(this.mContext, this.afc, this.afd);
    paramh.a(this, paramContext);
  }
  
  public final void a(h paramh, boolean paramBoolean)
  {
    if (paramh != this.aaD) {}
    do
    {
      return;
      dismiss();
    } while (this.afu == null);
    this.afu.a(paramh, paramBoolean);
  }
  
  public final void a(o.a parama)
  {
    this.afu = parama;
  }
  
  public final boolean a(u paramu)
  {
    if (paramu.hasVisibleItems())
    {
      n localn = new n(this.mContext, paramu, this.afn, this.afe, this.afc, this.afd);
      localn.c(this.afu);
      localn.setForceShowIcon(m.h(paramu));
      localn.afw = this.afw;
      this.afw = null;
      this.aaD.ab(false);
      int j = this.agW.aqS;
      int k = this.agW.getVerticalOffset();
      int i = j;
      if ((Gravity.getAbsoluteGravity(this.afm, android.support.v4.view.t.Y(this.qI)) & 0x7) == 5) {
        i = j + this.qI.getWidth();
      }
      if (localn.isShowing()) {
        i = 1;
      }
      while (i != 0)
      {
        if (this.afu != null) {
          this.afu.d(paramu);
        }
        return true;
        if (localn.qI == null)
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
  
  public final boolean bD()
  {
    return false;
  }
  
  public final void dismiss()
  {
    if (isShowing()) {
      this.agW.dismiss();
    }
  }
  
  public final void f(h paramh) {}
  
  public final ListView getListView()
  {
    return this.agW.aqQ;
  }
  
  public final boolean isShowing()
  {
    return (!this.agX) && (this.agW.arn.isShowing());
  }
  
  public final void onDismiss()
  {
    this.agX = true;
    this.aaD.close();
    if (this.afv != null)
    {
      if (!this.afv.isAlive()) {
        this.afv = this.afn.getViewTreeObserver();
      }
      this.afv.removeGlobalOnLayoutListener(this.afi);
      this.afv = null;
    }
    this.afn.removeOnAttachStateChangeListener(this.afj);
    if (this.afw != null) {
      this.afw.onDismiss();
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
    this.agY = false;
    if (this.agU != null) {
      this.agU.notifyDataSetChanged();
    }
  }
  
  public final void setAnchorView(View paramView)
  {
    this.qI = paramView;
  }
  
  public final void setForceShowIcon(boolean paramBoolean)
  {
    this.agU.aft = paramBoolean;
  }
  
  public final void setGravity(int paramInt)
  {
    this.afm = paramInt;
  }
  
  public final void setHorizontalOffset(int paramInt)
  {
    this.agW.aqS = paramInt;
  }
  
  public final void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.afw = paramOnDismissListener;
  }
  
  public final void setShowTitle(boolean paramBoolean)
  {
    this.Xv = paramBoolean;
  }
  
  public final void setVerticalOffset(int paramInt)
  {
    this.agW.setVerticalOffset(paramInt);
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
      if ((this.agX) || (this.qI == null))
      {
        i = 0;
      }
      else
      {
        this.afn = this.qI;
        this.agW.setOnDismissListener(this);
        this.agW.arf = this;
        this.agW.setModal(true);
        Object localObject = this.afn;
        if (this.afv == null) {}
        for (i = 1;; i = 0)
        {
          this.afv = ((View)localObject).getViewTreeObserver();
          if (i != 0) {
            this.afv.addOnGlobalLayoutListener(this.afi);
          }
          ((View)localObject).addOnAttachStateChangeListener(this.afj);
          this.agW.ard = ((View)localObject);
          this.agW.afm = this.afm;
          if (!this.agY)
          {
            this.agZ = a(this.agU, null, this.mContext, this.agV);
            this.agY = true;
          }
          this.agW.setContentWidth(this.agZ);
          this.agW.kw();
          this.agW.agQ = this.agQ;
          this.agW.show();
          localObject = this.agW.aqQ;
          ((ListView)localObject).setOnKeyListener(this);
          if ((this.Xv) && (this.aaD.agl != null))
          {
            FrameLayout localFrameLayout = (FrameLayout)LayoutInflater.from(this.mContext).inflate(2131492909, (ViewGroup)localObject, false);
            TextView localTextView = (TextView)localFrameLayout.findViewById(16908310);
            if (localTextView != null) {
              localTextView.setText(this.aaD.agl);
            }
            localFrameLayout.setEnabled(false);
            ((ListView)localObject).addHeaderView(localFrameLayout, null, false);
          }
          this.agW.setAdapter(this.agU);
          this.agW.show();
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