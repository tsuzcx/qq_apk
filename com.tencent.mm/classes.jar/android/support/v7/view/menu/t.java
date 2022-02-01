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
  private static final int acp = 2131492910;
  private boolean UK;
  private final h XT;
  private int acB = 0;
  View acC;
  private o.a acJ;
  ViewTreeObserver acK;
  private PopupWindow.OnDismissListener acL;
  private final int acr;
  private final int acs;
  private final boolean act;
  final ViewTreeObserver.OnGlobalLayoutListener acx = new ViewTreeObserver.OnGlobalLayoutListener()
  {
    public final void onGlobalLayout()
    {
      if ((t.this.isShowing()) && (!t.this.ael.aoz))
      {
        View localView = t.this.acC;
        if ((localView == null) || (!localView.isShown())) {
          t.this.dismiss();
        }
      }
      else
      {
        return;
      }
      t.this.ael.show();
    }
  };
  private final View.OnAttachStateChangeListener acy = new View.OnAttachStateChangeListener()
  {
    public final void onViewAttachedToWindow(View paramAnonymousView) {}
    
    public final void onViewDetachedFromWindow(View paramAnonymousView)
    {
      if (t.this.acK != null)
      {
        if (!t.this.acK.isAlive()) {
          t.this.acK = paramAnonymousView.getViewTreeObserver();
        }
        t.this.acK.removeGlobalOnLayoutListener(t.this.acx);
      }
      paramAnonymousView.removeOnAttachStateChangeListener(this);
    }
  };
  private final g aej;
  private final int aek;
  final ah ael;
  private boolean aem;
  private boolean aen;
  private int aeo;
  private final Context mContext;
  private View nO;
  
  public t(Context paramContext, h paramh, View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.XT = paramh;
    this.act = paramBoolean;
    this.aej = new g(paramh, LayoutInflater.from(paramContext), this.act, acp);
    this.acr = paramInt1;
    this.acs = paramInt2;
    Resources localResources = paramContext.getResources();
    this.aek = Math.max(localResources.getDisplayMetrics().widthPixels / 2, localResources.getDimensionPixelSize(2131165655));
    this.nO = paramView;
    this.ael = new ah(this.mContext, this.acr, this.acs);
    paramh.a(this, paramContext);
  }
  
  public final void a(h paramh, boolean paramBoolean)
  {
    if (paramh != this.XT) {}
    do
    {
      return;
      dismiss();
    } while (this.acJ == null);
    this.acJ.a(paramh, paramBoolean);
  }
  
  public final void a(o.a parama)
  {
    this.acJ = parama;
  }
  
  public final boolean a(u paramu)
  {
    if (paramu.hasVisibleItems())
    {
      n localn = new n(this.mContext, paramu, this.acC, this.act, this.acr, this.acs);
      localn.c(this.acJ);
      localn.setForceShowIcon(m.h(paramu));
      localn.acL = this.acL;
      this.acL = null;
      this.XT.ab(false);
      int j = this.ael.aof;
      int k = this.ael.getVerticalOffset();
      int i = j;
      if ((Gravity.getAbsoluteGravity(this.acB, android.support.v4.view.t.Y(this.nO)) & 0x7) == 5) {
        i = j + this.nO.getWidth();
      }
      if (localn.isShowing()) {
        i = 1;
      }
      while (i != 0)
      {
        if (this.acJ != null) {
          this.acJ.d(paramu);
        }
        return true;
        if (localn.nO == null)
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
  
  public final boolean bh()
  {
    return false;
  }
  
  public final void dismiss()
  {
    if (isShowing()) {
      this.ael.dismiss();
    }
  }
  
  public final void f(h paramh) {}
  
  public final ListView getListView()
  {
    return this.ael.aod;
  }
  
  public final boolean isShowing()
  {
    return (!this.aem) && (this.ael.aoA.isShowing());
  }
  
  public final void onDismiss()
  {
    this.aem = true;
    this.XT.close();
    if (this.acK != null)
    {
      if (!this.acK.isAlive()) {
        this.acK = this.acC.getViewTreeObserver();
      }
      this.acK.removeGlobalOnLayoutListener(this.acx);
      this.acK = null;
    }
    this.acC.removeOnAttachStateChangeListener(this.acy);
    if (this.acL != null) {
      this.acL.onDismiss();
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
    this.aen = false;
    if (this.aej != null) {
      this.aej.notifyDataSetChanged();
    }
  }
  
  public final void setAnchorView(View paramView)
  {
    this.nO = paramView;
  }
  
  public final void setForceShowIcon(boolean paramBoolean)
  {
    this.aej.acI = paramBoolean;
  }
  
  public final void setGravity(int paramInt)
  {
    this.acB = paramInt;
  }
  
  public final void setHorizontalOffset(int paramInt)
  {
    this.ael.aof = paramInt;
  }
  
  public final void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.acL = paramOnDismissListener;
  }
  
  public final void setShowTitle(boolean paramBoolean)
  {
    this.UK = paramBoolean;
  }
  
  public final void setVerticalOffset(int paramInt)
  {
    this.ael.setVerticalOffset(paramInt);
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
      if ((this.aem) || (this.nO == null))
      {
        i = 0;
      }
      else
      {
        this.acC = this.nO;
        this.ael.setOnDismissListener(this);
        this.ael.aos = this;
        this.ael.setModal(true);
        Object localObject = this.acC;
        if (this.acK == null) {}
        for (i = 1;; i = 0)
        {
          this.acK = ((View)localObject).getViewTreeObserver();
          if (i != 0) {
            this.acK.addOnGlobalLayoutListener(this.acx);
          }
          ((View)localObject).addOnAttachStateChangeListener(this.acy);
          this.ael.aoq = ((View)localObject);
          this.ael.acB = this.acB;
          if (!this.aen)
          {
            this.aeo = a(this.aej, null, this.mContext, this.aek);
            this.aen = true;
          }
          this.ael.setContentWidth(this.aeo);
          this.ael.jY();
          this.ael.aef = this.aef;
          this.ael.show();
          localObject = this.ael.aod;
          ((ListView)localObject).setOnKeyListener(this);
          if ((this.UK) && (this.XT.adA != null))
          {
            FrameLayout localFrameLayout = (FrameLayout)LayoutInflater.from(this.mContext).inflate(2131492909, (ViewGroup)localObject, false);
            TextView localTextView = (TextView)localFrameLayout.findViewById(16908310);
            if (localTextView != null) {
              localTextView.setText(this.XT.adA);
            }
            localFrameLayout.setEnabled(false);
            ((ListView)localObject).addHeaderView(localFrameLayout, null, false);
          }
          this.ael.setAdapter(this.aej);
          this.ael.show();
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