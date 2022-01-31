package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.support.v7.a.a.d;
import android.support.v7.a.a.g;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.ah;
import android.util.DisplayMetrics;
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
  private boolean NS;
  private final int UA;
  private final boolean UB;
  private final ViewTreeObserver.OnGlobalLayoutListener UF = new ViewTreeObserver.OnGlobalLayoutListener()
  {
    public final void onGlobalLayout()
    {
      if ((t.this.isShowing()) && (!t.this.Wt.afd))
      {
        View localView = t.this.UK;
        if ((localView == null) || (!localView.isShown())) {
          t.this.dismiss();
        }
      }
      else
      {
        return;
      }
      t.this.Wt.show();
    }
  };
  private final View.OnAttachStateChangeListener UG = new View.OnAttachStateChangeListener()
  {
    public final void onViewAttachedToWindow(View paramAnonymousView) {}
    
    public final void onViewDetachedFromWindow(View paramAnonymousView)
    {
      if (t.a(t.this) != null)
      {
        if (!t.a(t.this).isAlive()) {
          t.a(t.this, paramAnonymousView.getViewTreeObserver());
        }
        t.a(t.this).removeGlobalOnLayoutListener(t.b(t.this));
      }
      paramAnonymousView.removeOnAttachStateChangeListener(this);
    }
  };
  private int UJ = 0;
  View UK;
  private o.a UR;
  private ViewTreeObserver US;
  private PopupWindow.OnDismissListener UT;
  private final int Uz;
  private final g Wr;
  private final int Ws;
  final ah Wt;
  private boolean Wu;
  private boolean Wv;
  private int Ww;
  private final h dm;
  private View hX;
  private final Context mContext;
  
  public t(Context paramContext, h paramh, View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.dm = paramh;
    this.UB = paramBoolean;
    this.Wr = new g(paramh, LayoutInflater.from(paramContext), this.UB);
    this.Uz = paramInt1;
    this.UA = paramInt2;
    Resources localResources = paramContext.getResources();
    this.Ws = Math.max(localResources.getDisplayMetrics().widthPixels / 2, localResources.getDimensionPixelSize(a.d.abc_config_prefDialogWidth));
    this.hX = paramView;
    this.Wt = new ah(this.mContext, this.Uz, this.UA);
    paramh.a(this, paramContext);
  }
  
  public final boolean V()
  {
    return false;
  }
  
  public final void a(h paramh, boolean paramBoolean)
  {
    if (paramh != this.dm) {}
    do
    {
      return;
      dismiss();
    } while (this.UR == null);
    this.UR.a(paramh, paramBoolean);
  }
  
  public final void a(o.a parama)
  {
    this.UR = parama;
  }
  
  public final boolean a(u paramu)
  {
    if (paramu.hasVisibleItems())
    {
      n localn = new n(this.mContext, paramu, this.UK, this.UB, this.Uz, this.UA);
      localn.b(this.UR);
      localn.setForceShowIcon(m.h(paramu));
      localn.UJ = this.UJ;
      localn.UT = this.UT;
      this.UT = null;
      this.dm.T(false);
      int i = this.Wt.aeJ;
      int j = this.Wt.getVerticalOffset();
      if (localn.isShowing()) {
        i = 1;
      }
      while (i != 0)
      {
        if (this.UR != null) {
          this.UR.d(paramu);
        }
        return true;
        if (localn.hX == null)
        {
          i = 0;
        }
        else
        {
          localn.b(i, j, true, true);
          i = 1;
        }
      }
    }
    return false;
  }
  
  public final void dismiss()
  {
    if (isShowing()) {
      this.Wt.dismiss();
    }
  }
  
  public final void f(h paramh) {}
  
  public final ListView getListView()
  {
    return this.Wt.aeH;
  }
  
  public final boolean isShowing()
  {
    return (!this.Wu) && (this.Wt.afe.isShowing());
  }
  
  public final void o(boolean paramBoolean)
  {
    this.Wv = false;
    if (this.Wr != null) {
      this.Wr.notifyDataSetChanged();
    }
  }
  
  public final void onDismiss()
  {
    this.Wu = true;
    this.dm.close();
    if (this.US != null)
    {
      if (!this.US.isAlive()) {
        this.US = this.UK.getViewTreeObserver();
      }
      this.US.removeGlobalOnLayoutListener(this.UF);
      this.US = null;
    }
    this.UK.removeOnAttachStateChangeListener(this.UG);
    if (this.UT != null) {
      this.UT.onDismiss();
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
    this.hX = paramView;
  }
  
  public final void setForceShowIcon(boolean paramBoolean)
  {
    this.Wr.UQ = paramBoolean;
  }
  
  public final void setGravity(int paramInt)
  {
    this.UJ = paramInt;
  }
  
  public final void setHorizontalOffset(int paramInt)
  {
    this.Wt.aeJ = paramInt;
  }
  
  public final void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.UT = paramOnDismissListener;
  }
  
  public final void setShowTitle(boolean paramBoolean)
  {
    this.NS = paramBoolean;
  }
  
  public final void setVerticalOffset(int paramInt)
  {
    this.Wt.setVerticalOffset(paramInt);
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
      if ((this.Wu) || (this.hX == null))
      {
        i = 0;
      }
      else
      {
        this.UK = this.hX;
        this.Wt.setOnDismissListener(this);
        this.Wt.aeW = this;
        this.Wt.setModal(true);
        Object localObject = this.UK;
        if (this.US == null) {}
        for (i = 1;; i = 0)
        {
          this.US = ((View)localObject).getViewTreeObserver();
          if (i != 0) {
            this.US.addOnGlobalLayoutListener(this.UF);
          }
          ((View)localObject).addOnAttachStateChangeListener(this.UG);
          this.Wt.aeU = ((View)localObject);
          this.Wt.UJ = this.UJ;
          if (!this.Wv)
          {
            this.Ww = a(this.Wr, null, this.mContext, this.Ws);
            this.Wv = true;
          }
          this.Wt.setContentWidth(this.Ww);
          this.Wt.hf();
          this.Wt.Wn = this.Wn;
          this.Wt.show();
          localObject = this.Wt.aeH;
          ((ListView)localObject).setOnKeyListener(this);
          if ((this.NS) && (this.dm.VF != null))
          {
            FrameLayout localFrameLayout = (FrameLayout)LayoutInflater.from(this.mContext).inflate(a.g.abc_popup_menu_header_item_layout, (ViewGroup)localObject, false);
            TextView localTextView = (TextView)localFrameLayout.findViewById(16908310);
            if (localTextView != null) {
              localTextView.setText(this.dm.VF);
            }
            localFrameLayout.setEnabled(false);
            ((ListView)localObject).addHeaderView(localFrameLayout, null, false);
          }
          this.Wt.setAdapter(this.Wr);
          this.Wt.show();
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