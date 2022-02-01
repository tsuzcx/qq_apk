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
  private static final int adj = 2131492910;
  private boolean VG;
  private final h YO;
  private o.a adD;
  ViewTreeObserver adE;
  private PopupWindow.OnDismissListener adF;
  private final int adl;
  private final int adm;
  private final boolean adn;
  final ViewTreeObserver.OnGlobalLayoutListener adr = new ViewTreeObserver.OnGlobalLayoutListener()
  {
    public final void onGlobalLayout()
    {
      if ((t.this.isShowing()) && (!t.this.aff.apv))
      {
        View localView = t.this.adw;
        if ((localView == null) || (!localView.isShown())) {
          t.this.dismiss();
        }
      }
      else
      {
        return;
      }
      t.this.aff.show();
    }
  };
  private final View.OnAttachStateChangeListener ads = new View.OnAttachStateChangeListener()
  {
    public final void onViewAttachedToWindow(View paramAnonymousView) {}
    
    public final void onViewDetachedFromWindow(View paramAnonymousView)
    {
      if (t.this.adE != null)
      {
        if (!t.this.adE.isAlive()) {
          t.this.adE = paramAnonymousView.getViewTreeObserver();
        }
        t.this.adE.removeGlobalOnLayoutListener(t.this.adr);
      }
      paramAnonymousView.removeOnAttachStateChangeListener(this);
    }
  };
  private int adv = 0;
  View adw;
  private final g afd;
  private final int afe;
  final ah aff;
  private boolean afg;
  private boolean afh;
  private int afi;
  private final Context mContext;
  private View oP;
  
  public t(Context paramContext, h paramh, View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.YO = paramh;
    this.adn = paramBoolean;
    this.afd = new g(paramh, LayoutInflater.from(paramContext), this.adn, adj);
    this.adl = paramInt1;
    this.adm = paramInt2;
    Resources localResources = paramContext.getResources();
    this.afe = Math.max(localResources.getDisplayMetrics().widthPixels / 2, localResources.getDimensionPixelSize(2131165655));
    this.oP = paramView;
    this.aff = new ah(this.mContext, this.adl, this.adm);
    paramh.a(this, paramContext);
  }
  
  public final void a(h paramh, boolean paramBoolean)
  {
    if (paramh != this.YO) {}
    do
    {
      return;
      dismiss();
    } while (this.adD == null);
    this.adD.a(paramh, paramBoolean);
  }
  
  public final void a(o.a parama)
  {
    this.adD = parama;
  }
  
  public final boolean a(u paramu)
  {
    if (paramu.hasVisibleItems())
    {
      n localn = new n(this.mContext, paramu, this.adw, this.adn, this.adl, this.adm);
      localn.c(this.adD);
      localn.setForceShowIcon(m.h(paramu));
      localn.adF = this.adF;
      this.adF = null;
      this.YO.ab(false);
      int j = this.aff.apa;
      int k = this.aff.getVerticalOffset();
      int i = j;
      if ((Gravity.getAbsoluteGravity(this.adv, android.support.v4.view.t.Y(this.oP)) & 0x7) == 5) {
        i = j + this.oP.getWidth();
      }
      if (localn.isShowing()) {
        i = 1;
      }
      while (i != 0)
      {
        if (this.adD != null) {
          this.adD.d(paramu);
        }
        return true;
        if (localn.oP == null)
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
  
  public final boolean bo()
  {
    return false;
  }
  
  public final void dismiss()
  {
    if (isShowing()) {
      this.aff.dismiss();
    }
  }
  
  public final void f(h paramh) {}
  
  public final ListView getListView()
  {
    return this.aff.aoY;
  }
  
  public final boolean isShowing()
  {
    return (!this.afg) && (this.aff.apw.isShowing());
  }
  
  public final void onDismiss()
  {
    this.afg = true;
    this.YO.close();
    if (this.adE != null)
    {
      if (!this.adE.isAlive()) {
        this.adE = this.adw.getViewTreeObserver();
      }
      this.adE.removeGlobalOnLayoutListener(this.adr);
      this.adE = null;
    }
    this.adw.removeOnAttachStateChangeListener(this.ads);
    if (this.adF != null) {
      this.adF.onDismiss();
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
    this.afh = false;
    if (this.afd != null) {
      this.afd.notifyDataSetChanged();
    }
  }
  
  public final void setAnchorView(View paramView)
  {
    this.oP = paramView;
  }
  
  public final void setForceShowIcon(boolean paramBoolean)
  {
    this.afd.adC = paramBoolean;
  }
  
  public final void setGravity(int paramInt)
  {
    this.adv = paramInt;
  }
  
  public final void setHorizontalOffset(int paramInt)
  {
    this.aff.apa = paramInt;
  }
  
  public final void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.adF = paramOnDismissListener;
  }
  
  public final void setShowTitle(boolean paramBoolean)
  {
    this.VG = paramBoolean;
  }
  
  public final void setVerticalOffset(int paramInt)
  {
    this.aff.setVerticalOffset(paramInt);
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
      if ((this.afg) || (this.oP == null))
      {
        i = 0;
      }
      else
      {
        this.adw = this.oP;
        this.aff.setOnDismissListener(this);
        this.aff.apn = this;
        this.aff.setModal(true);
        Object localObject = this.adw;
        if (this.adE == null) {}
        for (i = 1;; i = 0)
        {
          this.adE = ((View)localObject).getViewTreeObserver();
          if (i != 0) {
            this.adE.addOnGlobalLayoutListener(this.adr);
          }
          ((View)localObject).addOnAttachStateChangeListener(this.ads);
          this.aff.apl = ((View)localObject);
          this.aff.adv = this.adv;
          if (!this.afh)
          {
            this.afi = a(this.afd, null, this.mContext, this.afe);
            this.afh = true;
          }
          this.aff.setContentWidth(this.afi);
          this.aff.kg();
          this.aff.aeZ = this.aeZ;
          this.aff.show();
          localObject = this.aff.aoY;
          ((ListView)localObject).setOnKeyListener(this);
          if ((this.VG) && (this.YO.aeu != null))
          {
            FrameLayout localFrameLayout = (FrameLayout)LayoutInflater.from(this.mContext).inflate(2131492909, (ViewGroup)localObject, false);
            TextView localTextView = (TextView)localFrameLayout.findViewById(16908310);
            if (localTextView != null) {
              localTextView.setText(this.YO.aeu);
            }
            localFrameLayout.setEnabled(false);
            ((ListView)localObject).addHeaderView(localFrameLayout, null, false);
          }
          this.aff.setAdapter(this.afd);
          this.aff.show();
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