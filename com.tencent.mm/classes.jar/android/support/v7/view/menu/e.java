package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.view.d;
import android.support.v4.view.q;
import android.support.v7.a.a.d;
import android.support.v7.a.a.g;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.ag;
import android.support.v7.widget.ah;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class e
  extends m
  implements o, View.OnKeyListener, PopupWindow.OnDismissListener
{
  private boolean NS;
  private final int UA;
  private final boolean UB;
  final Handler UC;
  private final List<h> UD = new ArrayList();
  final List<a> UE = new ArrayList();
  private final ViewTreeObserver.OnGlobalLayoutListener UF = new ViewTreeObserver.OnGlobalLayoutListener()
  {
    public final void onGlobalLayout()
    {
      Object localObject;
      if ((e.this.isShowing()) && (e.this.UE.size() > 0) && (!((e.a)e.this.UE.get(0)).Va.afd))
      {
        localObject = e.this.UK;
        if ((localObject != null) && (((View)localObject).isShown())) {
          break label77;
        }
        e.this.dismiss();
      }
      for (;;)
      {
        return;
        label77:
        localObject = e.this.UE.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((e.a)((Iterator)localObject).next()).Va.show();
        }
      }
    }
  };
  private final View.OnAttachStateChangeListener UG = new View.OnAttachStateChangeListener()
  {
    public final void onViewAttachedToWindow(View paramAnonymousView) {}
    
    public final void onViewDetachedFromWindow(View paramAnonymousView)
    {
      if (e.a(e.this) != null)
      {
        if (!e.a(e.this).isAlive()) {
          e.a(e.this, paramAnonymousView.getViewTreeObserver());
        }
        e.a(e.this).removeGlobalOnLayoutListener(e.b(e.this));
      }
      paramAnonymousView.removeOnAttachStateChangeListener(this);
    }
  };
  private final ag UH = new ag()
  {
    public final void b(h paramAnonymoush, MenuItem paramAnonymousMenuItem)
    {
      e.this.UC.removeCallbacksAndMessages(paramAnonymoush);
    }
    
    public final void c(final h paramAnonymoush, final MenuItem paramAnonymousMenuItem)
    {
      e.this.UC.removeCallbacksAndMessages(null);
      int i = 0;
      int j = e.this.UE.size();
      if (i < j) {
        if (paramAnonymoush != ((e.a)e.this.UE.get(i)).PQ) {}
      }
      for (;;)
      {
        if (i == -1)
        {
          return;
          i += 1;
          break;
        }
        i += 1;
        if (i < e.this.UE.size()) {}
        for (final e.a locala = (e.a)e.this.UE.get(i);; locala = null)
        {
          paramAnonymousMenuItem = new Runnable()
          {
            public final void run()
            {
              if (locala != null)
              {
                e.this.UU = true;
                locala.PQ.T(false);
                e.this.UU = false;
              }
              if ((paramAnonymousMenuItem.isEnabled()) && (paramAnonymousMenuItem.hasSubMenu())) {
                paramAnonymoush.a(paramAnonymousMenuItem, null, 4);
              }
            }
          };
          long l = SystemClock.uptimeMillis();
          e.this.UC.postAtTime(paramAnonymousMenuItem, paramAnonymoush, l + 200L);
          return;
        }
        i = -1;
      }
    }
  };
  private int UI = 0;
  private int UJ = 0;
  View UK;
  private int UL;
  private boolean UM;
  private boolean UN;
  private int UO;
  private int UP;
  private boolean UQ;
  private o.a UR;
  private ViewTreeObserver US;
  private PopupWindow.OnDismissListener UT;
  boolean UU;
  private final int Uy;
  private final int Uz;
  private View hX;
  private final Context mContext;
  
  public e(Context paramContext, View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.hX = paramView;
    this.Uz = paramInt1;
    this.UA = paramInt2;
    this.UB = paramBoolean;
    this.UQ = false;
    this.UL = eZ();
    paramContext = paramContext.getResources();
    this.Uy = Math.max(paramContext.getDisplayMetrics().widthPixels / 2, paramContext.getDimensionPixelSize(a.d.abc_config_prefDialogWidth));
    this.UC = new Handler();
  }
  
  private int eZ()
  {
    int i = 1;
    if (q.Q(this.hX) == 1) {
      i = 0;
    }
    return i;
  }
  
  private void g(h paramh)
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.mContext);
    Object localObject1 = new g(paramh, localLayoutInflater, this.UB);
    if ((!isShowing()) && (this.UQ)) {
      ((g)localObject1).UQ = true;
    }
    for (;;)
    {
      int m = a((ListAdapter)localObject1, null, this.mContext, this.Uy);
      ah localah = new ah(this.mContext, this.Uz, this.UA);
      localah.afh = this.UH;
      localah.aeW = this;
      localah.setOnDismissListener(this);
      localah.aeU = this.hX;
      localah.UJ = this.UJ;
      localah.setModal(true);
      localah.hf();
      localah.setAdapter((ListAdapter)localObject1);
      localah.setContentWidth(m);
      localah.UJ = this.UJ;
      Object localObject3;
      Object localObject2;
      int j;
      int i;
      label257:
      if (this.UE.size() > 0)
      {
        localObject3 = (a)this.UE.get(this.UE.size() - 1);
        localObject2 = ((a)localObject3).PQ;
        j = ((h)localObject2).size();
        i = 0;
        label207:
        if (i < j)
        {
          localObject1 = ((h)localObject2).getItem(i);
          if ((((MenuItem)localObject1).hasSubMenu()) && (paramh == ((MenuItem)localObject1).getSubMenu()))
          {
            label241:
            if (localObject1 != null) {
              break label634;
            }
            localObject1 = null;
            label249:
            localObject2 = localObject1;
            localObject1 = localObject3;
            if ((localObject2 != null) && (ah.afg == null)) {}
          }
        }
      }
      try
      {
        ah.afg.invoke(localah.afe, new Object[] { Boolean.valueOf(false) });
        if (Build.VERSION.SDK_INT >= 23) {
          localah.afe.setEnterTransition(null);
        }
        localObject3 = ((a)this.UE.get(this.UE.size() - 1)).Va.aeH;
        Object localObject4 = new int[2];
        ((ListView)localObject3).getLocationOnScreen((int[])localObject4);
        Rect localRect = new Rect();
        this.UK.getWindowVisibleDisplayFrame(localRect);
        label402:
        int k;
        if (this.UL == 1)
        {
          i = localObject4[0];
          if (((ListView)localObject3).getWidth() + i + m > localRect.right) {
            break label802;
          }
          i = 1;
          if (i != 1) {
            break label807;
          }
          k = 1;
          label410:
          this.UL = i;
          if (Build.VERSION.SDK_INT < 26) {
            break label813;
          }
          localah.aeU = ((View)localObject2);
          i = 0;
          j = 0;
          label434:
          if ((this.UJ & 0x5) != 5) {
            break label914;
          }
          if (k == 0) {
            break label903;
          }
          i += m;
          label454:
          localah.aeJ = i;
          localah.aeO = true;
          localah.ZW = true;
          localah.setVerticalOffset(j);
        }
        for (;;)
        {
          localObject2 = new a(localah, paramh, this.UL);
          this.UE.add(localObject2);
          localah.show();
          localObject2 = localah.aeH;
          ((ListView)localObject2).setOnKeyListener(this);
          if ((localObject1 == null) && (this.NS) && (paramh.VF != null))
          {
            localObject1 = (FrameLayout)localLayoutInflater.inflate(a.g.abc_popup_menu_header_item_layout, (ViewGroup)localObject2, false);
            localObject3 = (TextView)((FrameLayout)localObject1).findViewById(16908310);
            ((FrameLayout)localObject1).setEnabled(false);
            ((TextView)localObject3).setText(paramh.VF);
            ((ListView)localObject2).addHeaderView((View)localObject1, null, false);
            localah.show();
          }
          return;
          if (!isShowing()) {
            break;
          }
          ((g)localObject1).UQ = m.h(paramh);
          break;
          i += 1;
          break label207;
          localObject1 = null;
          break label241;
          label634:
          localObject4 = ((a)localObject3).Va.aeH;
          localObject2 = ((ListView)localObject4).getAdapter();
          if ((localObject2 instanceof HeaderViewListAdapter))
          {
            localObject2 = (HeaderViewListAdapter)localObject2;
            j = ((HeaderViewListAdapter)localObject2).getHeadersCount();
            localObject2 = (g)((HeaderViewListAdapter)localObject2).getWrappedAdapter();
            label682:
            i = 0;
            k = ((g)localObject2).getCount();
          }
          for (;;)
          {
            if (i >= k) {
              break label987;
            }
            if (localObject1 == ((g)localObject2).bd(i))
            {
              if (i != -1) {
                break label738;
              }
              localObject1 = null;
              break;
              j = 0;
              localObject2 = (g)localObject2;
              break label682;
            }
            i += 1;
          }
          label738:
          i = i + j - ((ListView)localObject4).getFirstVisiblePosition();
          if ((i < 0) || (i >= ((ListView)localObject4).getChildCount()))
          {
            localObject1 = null;
            break label249;
          }
          localObject1 = ((ListView)localObject4).getChildAt(i);
          break label249;
          localObject2 = null;
          localObject1 = null;
          break label257;
          if (localObject4[0] - m < 0)
          {
            i = 1;
            break label402;
          }
          label802:
          i = 0;
          break label402;
          label807:
          k = 0;
          break label410;
          label813:
          localObject3 = new int[2];
          this.hX.getLocationOnScreen((int[])localObject3);
          localObject4 = new int[2];
          ((View)localObject2).getLocationOnScreen((int[])localObject4);
          if ((this.UJ & 0x7) == 5)
          {
            localObject3[0] += this.hX.getWidth();
            localObject4[0] += ((View)localObject2).getWidth();
          }
          i = localObject4[0] - localObject3[0];
          j = localObject4[1] - localObject3[1];
          break label434;
          label903:
          i -= ((View)localObject2).getWidth();
          break label454;
          label914:
          if (k != 0)
          {
            i = ((View)localObject2).getWidth() + i;
            break label454;
          }
          i -= m;
          break label454;
          if (this.UM) {
            localah.aeJ = this.UO;
          }
          if (this.UN) {
            localah.setVerticalOffset(this.UP);
          }
          localah.Wn = this.Wn;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          continue;
          label987:
          i = -1;
        }
      }
    }
  }
  
  public final boolean V()
  {
    return false;
  }
  
  public final void a(h paramh, boolean paramBoolean)
  {
    int j = this.UE.size();
    int i = 0;
    if (i < j) {
      if (paramh == ((a)this.UE.get(i)).PQ) {
        label39:
        if (i >= 0) {
          break label56;
        }
      }
    }
    label56:
    do
    {
      return;
      i += 1;
      break;
      i = -1;
      break label39;
      j = i + 1;
      if (j < this.UE.size()) {
        ((a)this.UE.get(j)).PQ.T(false);
      }
      a locala = (a)this.UE.remove(i);
      locala.PQ.b(this);
      if (this.UU)
      {
        ah localah = locala.Va;
        if (Build.VERSION.SDK_INT >= 23) {
          localah.afe.setExitTransition(null);
        }
        locala.Va.setAnimationStyle(0);
      }
      locala.Va.dismiss();
      i = this.UE.size();
      if (i > 0) {}
      for (this.UL = ((a)this.UE.get(i - 1)).position; i == 0; this.UL = eZ())
      {
        dismiss();
        if (this.UR != null) {
          this.UR.a(paramh, true);
        }
        if (this.US != null)
        {
          if (this.US.isAlive()) {
            this.US.removeGlobalOnLayoutListener(this.UF);
          }
          this.US = null;
        }
        this.UK.removeOnAttachStateChangeListener(this.UG);
        this.UT.onDismiss();
        return;
      }
    } while (!paramBoolean);
    ((a)this.UE.get(0)).PQ.T(false);
  }
  
  public final void a(o.a parama)
  {
    this.UR = parama;
  }
  
  public final boolean a(u paramu)
  {
    Iterator localIterator = this.UE.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (paramu == locala.PQ)
      {
        locala.Va.aeH.requestFocus();
        return true;
      }
    }
    if (paramu.hasVisibleItems())
    {
      f(paramu);
      if (this.UR != null) {
        this.UR.d(paramu);
      }
      return true;
    }
    return false;
  }
  
  public final void dismiss()
  {
    int i = this.UE.size();
    if (i > 0)
    {
      a[] arrayOfa = (a[])this.UE.toArray(new a[i]);
      i -= 1;
      while (i >= 0)
      {
        a locala = arrayOfa[i];
        if (locala.Va.afe.isShowing()) {
          locala.Va.dismiss();
        }
        i -= 1;
      }
    }
  }
  
  public final void f(h paramh)
  {
    paramh.a(this, this.mContext);
    if (isShowing())
    {
      g(paramh);
      return;
    }
    this.UD.add(paramh);
  }
  
  protected final boolean fa()
  {
    return false;
  }
  
  public final ListView getListView()
  {
    if (this.UE.isEmpty()) {
      return null;
    }
    return ((a)this.UE.get(this.UE.size() - 1)).Va.aeH;
  }
  
  public final boolean isShowing()
  {
    return (this.UE.size() > 0) && (((a)this.UE.get(0)).Va.afe.isShowing());
  }
  
  public final void o(boolean paramBoolean)
  {
    Iterator localIterator = this.UE.iterator();
    while (localIterator.hasNext()) {
      a(((a)localIterator.next()).Va.aeH.getAdapter()).notifyDataSetChanged();
    }
  }
  
  public final void onDismiss()
  {
    int j = this.UE.size();
    int i = 0;
    a locala;
    if (i < j)
    {
      locala = (a)this.UE.get(i);
      if (locala.Va.afe.isShowing()) {}
    }
    for (;;)
    {
      if (locala != null) {
        locala.PQ.T(false);
      }
      return;
      i += 1;
      break;
      locala = null;
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
    if (this.hX != paramView)
    {
      this.hX = paramView;
      this.UJ = d.getAbsoluteGravity(this.UI, q.Q(this.hX));
    }
  }
  
  public final void setForceShowIcon(boolean paramBoolean)
  {
    this.UQ = paramBoolean;
  }
  
  public final void setGravity(int paramInt)
  {
    if (this.UI != paramInt)
    {
      this.UI = paramInt;
      this.UJ = d.getAbsoluteGravity(paramInt, q.Q(this.hX));
    }
  }
  
  public final void setHorizontalOffset(int paramInt)
  {
    this.UM = true;
    this.UO = paramInt;
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
    this.UN = true;
    this.UP = paramInt;
  }
  
  public final void show()
  {
    if (isShowing()) {}
    do
    {
      return;
      Iterator localIterator = this.UD.iterator();
      while (localIterator.hasNext()) {
        g((h)localIterator.next());
      }
      this.UD.clear();
      this.UK = this.hX;
    } while (this.UK == null);
    if (this.US == null) {}
    for (int i = 1;; i = 0)
    {
      this.US = this.UK.getViewTreeObserver();
      if (i != 0) {
        this.US.addOnGlobalLayoutListener(this.UF);
      }
      this.UK.addOnAttachStateChangeListener(this.UG);
      return;
    }
  }
  
  private static final class a
  {
    public final h PQ;
    public final ah Va;
    public final int position;
    
    public a(ah paramah, h paramh, int paramInt)
    {
      this.Va = paramah;
      this.PQ = paramh;
      this.position = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.e
 * JD-Core Version:    0.7.0.1
 */