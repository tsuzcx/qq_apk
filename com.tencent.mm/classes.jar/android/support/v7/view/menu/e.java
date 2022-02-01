package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.view.d;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.ag;
import android.support.v7.widget.ah;
import android.support.v7.widget.y;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class e
  extends m
  implements o, View.OnKeyListener, PopupWindow.OnDismissListener
{
  private static final int afn = 2131492919;
  private boolean XI;
  View afA;
  private int afB;
  private boolean afC;
  private boolean afD;
  private int afE;
  private int afF;
  private boolean afG;
  private o.a afH;
  ViewTreeObserver afI;
  private PopupWindow.OnDismissListener afJ;
  boolean afK;
  private final int afo;
  private final int afp;
  private final int afq;
  private final boolean afr;
  final Handler afs;
  private final List<h> aft = new ArrayList();
  final List<a> afu = new ArrayList();
  final ViewTreeObserver.OnGlobalLayoutListener afv = new ViewTreeObserver.OnGlobalLayoutListener()
  {
    public final void onGlobalLayout()
    {
      Object localObject;
      if ((e.this.isShowing()) && (e.this.afu.size() > 0) && (!((e.a)e.this.afu.get(0)).afQ.arz))
      {
        localObject = e.this.afA;
        if ((localObject != null) && (((View)localObject).isShown())) {
          break label77;
        }
        e.this.dismiss();
      }
      for (;;)
      {
        return;
        label77:
        localObject = e.this.afu.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((e.a)((Iterator)localObject).next()).afQ.show();
        }
      }
    }
  };
  private final View.OnAttachStateChangeListener afw = new View.OnAttachStateChangeListener()
  {
    public final void onViewAttachedToWindow(View paramAnonymousView) {}
    
    public final void onViewDetachedFromWindow(View paramAnonymousView)
    {
      if (e.this.afI != null)
      {
        if (!e.this.afI.isAlive()) {
          e.this.afI = paramAnonymousView.getViewTreeObserver();
        }
        e.this.afI.removeGlobalOnLayoutListener(e.this.afv);
      }
      paramAnonymousView.removeOnAttachStateChangeListener(this);
    }
  };
  private final ag afx = new ag()
  {
    public final void b(h paramAnonymoush, MenuItem paramAnonymousMenuItem)
    {
      e.this.afs.removeCallbacksAndMessages(paramAnonymoush);
    }
    
    public final void c(final h paramAnonymoush, final MenuItem paramAnonymousMenuItem)
    {
      e.this.afs.removeCallbacksAndMessages(null);
      int i = 0;
      int j = e.this.afu.size();
      if (i < j) {
        if (paramAnonymoush != ((e.a)e.this.afu.get(i)).kE) {}
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
        if (i < e.this.afu.size()) {}
        for (final e.a locala = (e.a)e.this.afu.get(i);; locala = null)
        {
          paramAnonymousMenuItem = new Runnable()
          {
            public final void run()
            {
              if (locala != null)
              {
                e.this.afK = true;
                locala.kE.aa(false);
                e.this.afK = false;
              }
              if ((paramAnonymousMenuItem.isEnabled()) && (paramAnonymousMenuItem.hasSubMenu())) {
                paramAnonymoush.a(paramAnonymousMenuItem, null, 4);
              }
            }
          };
          long l = SystemClock.uptimeMillis();
          e.this.afs.postAtTime(paramAnonymousMenuItem, paramAnonymoush, l + 200L);
          return;
        }
        i = -1;
      }
    }
  };
  private int afy = 0;
  private int afz = 0;
  private final Context mContext;
  private View qK;
  
  public e(Context paramContext, View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.qK = paramView;
    this.afp = paramInt1;
    this.afq = paramInt2;
    this.afr = paramBoolean;
    this.afG = false;
    this.afB = hR();
    paramContext = paramContext.getResources();
    this.afo = Math.max(paramContext.getDisplayMetrics().widthPixels / 2, paramContext.getDimensionPixelSize(2131165673));
    this.afs = new Handler();
  }
  
  private static MenuItem a(h paramh1, h paramh2)
  {
    int j = paramh1.size();
    int i = 0;
    while (i < j)
    {
      MenuItem localMenuItem = paramh1.getItem(i);
      if ((localMenuItem.hasSubMenu()) && (paramh2 == localMenuItem.getSubMenu())) {
        return localMenuItem;
      }
      i += 1;
    }
    return null;
  }
  
  private static View a(a parama, h paramh)
  {
    int i = 0;
    paramh = a(parama.kE, paramh);
    if (paramh == null) {
      return null;
    }
    y localy = parama.afQ.arc;
    parama = localy.getAdapter();
    int j;
    if ((parama instanceof HeaderViewListAdapter))
    {
      parama = (HeaderViewListAdapter)parama;
      j = parama.getHeadersCount();
      parama = (g)parama.getWrappedAdapter();
      int k = parama.getCount();
      label63:
      if (i >= k) {
        break label134;
      }
      if (paramh != parama.bv(i)) {
        break label95;
      }
    }
    for (;;)
    {
      if (i == -1)
      {
        return null;
        parama = (g)parama;
        j = 0;
        break;
        label95:
        i += 1;
        break label63;
      }
      i = i + j - localy.getFirstVisiblePosition();
      if ((i < 0) || (i >= localy.getChildCount())) {
        return null;
      }
      return localy.getChildAt(i);
      label134:
      i = -1;
    }
  }
  
  private int bu(int paramInt)
  {
    y localy = ((a)this.afu.get(this.afu.size() - 1)).afQ.arc;
    int[] arrayOfInt = new int[2];
    localy.getLocationOnScreen(arrayOfInt);
    Rect localRect = new Rect();
    this.afA.getWindowVisibleDisplayFrame(localRect);
    if (this.afB == 1)
    {
      int i = arrayOfInt[0];
      if (localy.getWidth() + i + paramInt > localRect.right) {
        return 0;
      }
      return 1;
    }
    if (arrayOfInt[0] - paramInt < 0) {
      return 1;
    }
    return 0;
  }
  
  private void g(h paramh)
  {
    Object localObject3 = LayoutInflater.from(this.mContext);
    Object localObject1 = new g(paramh, (LayoutInflater)localObject3, this.afr, afn);
    int m;
    ah localah;
    Object localObject2;
    label138:
    int j;
    int i;
    label167:
    int k;
    if ((!isShowing()) && (this.afG))
    {
      ((g)localObject1).afG = true;
      m = a((ListAdapter)localObject1, null, this.mContext, this.afo);
      localah = hQ();
      localah.setAdapter((ListAdapter)localObject1);
      localah.setContentWidth(m);
      localah.afz = this.afz;
      if (this.afu.size() <= 0) {
        break label372;
      }
      localObject1 = (a)this.afu.get(this.afu.size() - 1);
      localObject2 = a((a)localObject1, paramh);
      if (localObject2 == null) {
        break label514;
      }
      localah.kF();
      localah.kE();
      j = bu(m);
      if (j != 1) {
        break label381;
      }
      i = 1;
      this.afB = j;
      if (Build.VERSION.SDK_INT < 26) {
        break label386;
      }
      localah.arp = ((View)localObject2);
      j = 0;
      k = 0;
      label192:
      if ((this.afz & 0x5) != 5) {
        break label489;
      }
      if (i == 0) {
        break label477;
      }
      i = k + m;
      label212:
      localah.are = i;
      localah.kD();
      localah.setVerticalOffset(j);
    }
    for (;;)
    {
      localObject2 = new a(localah, paramh, this.afB);
      this.afu.add(localObject2);
      localah.show();
      localObject2 = localah.arc;
      ((ListView)localObject2).setOnKeyListener(this);
      if ((localObject1 == null) && (this.XI) && (paramh.agy != null))
      {
        localObject1 = (FrameLayout)((LayoutInflater)localObject3).inflate(2131492926, (ViewGroup)localObject2, false);
        localObject3 = (TextView)((FrameLayout)localObject1).findViewById(16908310);
        ((FrameLayout)localObject1).setEnabled(false);
        ((TextView)localObject3).setText(paramh.agy);
        ((ListView)localObject2).addHeaderView((View)localObject1, null, false);
        localah.show();
      }
      return;
      if (!isShowing()) {
        break;
      }
      ((g)localObject1).afG = m.h(paramh);
      break;
      label372:
      localObject2 = null;
      localObject1 = null;
      break label138;
      label381:
      i = 0;
      break label167;
      label386:
      int[] arrayOfInt1 = new int[2];
      this.qK.getLocationOnScreen(arrayOfInt1);
      int[] arrayOfInt2 = new int[2];
      ((View)localObject2).getLocationOnScreen(arrayOfInt2);
      if ((this.afz & 0x7) == 5)
      {
        arrayOfInt1[0] += this.qK.getWidth();
        arrayOfInt2[0] += ((View)localObject2).getWidth();
      }
      k = arrayOfInt2[0] - arrayOfInt1[0];
      j = arrayOfInt2[1] - arrayOfInt1[1];
      break label192;
      label477:
      i = k - ((View)localObject2).getWidth();
      break label212;
      label489:
      if (i != 0)
      {
        i = ((View)localObject2).getWidth() + k;
        break label212;
      }
      i = k - m;
      break label212;
      label514:
      if (this.afC) {
        localah.are = this.afE;
      }
      if (this.afD) {
        localah.setVerticalOffset(this.afF);
      }
      localah.ahd = this.ahd;
    }
  }
  
  private ah hQ()
  {
    ah localah = new ah(this.mContext, this.afp, this.afq);
    localah.arD = this.afx;
    localah.ars = this;
    localah.setOnDismissListener(this);
    localah.arp = this.qK;
    localah.afz = this.afz;
    localah.setModal(true);
    localah.kC();
    return localah;
  }
  
  private int hR()
  {
    int i = 1;
    if (android.support.v4.view.u.Z(this.qK) == 1) {
      i = 0;
    }
    return i;
  }
  
  public final void a(h paramh, boolean paramBoolean)
  {
    int j = this.afu.size();
    int i = 0;
    if (i < j) {
      if (paramh == ((a)this.afu.get(i)).kE) {
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
      if (j < this.afu.size()) {
        ((a)this.afu.get(j)).kE.aa(false);
      }
      a locala = (a)this.afu.remove(i);
      locala.kE.b(this);
      if (this.afK)
      {
        ah localah = locala.afQ;
        if (Build.VERSION.SDK_INT >= 23) {
          localah.arA.setExitTransition(null);
        }
        locala.afQ.setAnimationStyle(0);
      }
      locala.afQ.dismiss();
      i = this.afu.size();
      if (i > 0) {}
      for (this.afB = ((a)this.afu.get(i - 1)).position; i == 0; this.afB = hR())
      {
        dismiss();
        if (this.afH != null) {
          this.afH.a(paramh, true);
        }
        if (this.afI != null)
        {
          if (this.afI.isAlive()) {
            this.afI.removeGlobalOnLayoutListener(this.afv);
          }
          this.afI = null;
        }
        this.afA.removeOnAttachStateChangeListener(this.afw);
        this.afJ.onDismiss();
        return;
      }
    } while (!paramBoolean);
    ((a)this.afu.get(0)).kE.aa(false);
  }
  
  public final void a(o.a parama)
  {
    this.afH = parama;
  }
  
  public final boolean a(u paramu)
  {
    Iterator localIterator = this.afu.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (paramu == locala.kE)
      {
        locala.afQ.arc.requestFocus();
        return true;
      }
    }
    if (paramu.hasVisibleItems())
    {
      f(paramu);
      if (this.afH != null) {
        this.afH.d(paramu);
      }
      return true;
    }
    return false;
  }
  
  public final boolean bF()
  {
    return false;
  }
  
  public final void dismiss()
  {
    int i = this.afu.size();
    if (i > 0)
    {
      a[] arrayOfa = (a[])this.afu.toArray(new a[i]);
      i -= 1;
      while (i >= 0)
      {
        a locala = arrayOfa[i];
        if (locala.afQ.arA.isShowing()) {
          locala.afQ.dismiss();
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
    this.aft.add(paramh);
  }
  
  public final ListView getListView()
  {
    if (this.afu.isEmpty()) {
      return null;
    }
    return ((a)this.afu.get(this.afu.size() - 1)).afQ.arc;
  }
  
  protected final boolean hS()
  {
    return false;
  }
  
  public final boolean isShowing()
  {
    return (this.afu.size() > 0) && (((a)this.afu.get(0)).afQ.arA.isShowing());
  }
  
  public final void onDismiss()
  {
    int j = this.afu.size();
    int i = 0;
    a locala;
    if (i < j)
    {
      locala = (a)this.afu.get(i);
      if (locala.afQ.arA.isShowing()) {}
    }
    for (;;)
    {
      if (locala != null) {
        locala.kE.aa(false);
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
  
  public final void p(boolean paramBoolean)
  {
    Iterator localIterator = this.afu.iterator();
    while (localIterator.hasNext()) {
      a(((a)localIterator.next()).afQ.arc.getAdapter()).notifyDataSetChanged();
    }
  }
  
  public final void setAnchorView(View paramView)
  {
    if (this.qK != paramView)
    {
      this.qK = paramView;
      this.afz = d.getAbsoluteGravity(this.afy, android.support.v4.view.u.Z(this.qK));
    }
  }
  
  public final void setForceShowIcon(boolean paramBoolean)
  {
    this.afG = paramBoolean;
  }
  
  public final void setGravity(int paramInt)
  {
    if (this.afy != paramInt)
    {
      this.afy = paramInt;
      this.afz = d.getAbsoluteGravity(paramInt, android.support.v4.view.u.Z(this.qK));
    }
  }
  
  public final void setHorizontalOffset(int paramInt)
  {
    this.afC = true;
    this.afE = paramInt;
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
    this.afD = true;
    this.afF = paramInt;
  }
  
  public final void show()
  {
    if (isShowing()) {}
    do
    {
      return;
      Iterator localIterator = this.aft.iterator();
      while (localIterator.hasNext()) {
        g((h)localIterator.next());
      }
      this.aft.clear();
      this.afA = this.qK;
    } while (this.afA == null);
    if (this.afI == null) {}
    for (int i = 1;; i = 0)
    {
      this.afI = this.afA.getViewTreeObserver();
      if (i != 0) {
        this.afI.addOnGlobalLayoutListener(this.afv);
      }
      this.afA.addOnAttachStateChangeListener(this.afw);
      return;
    }
  }
  
  static final class a
  {
    public final ah afQ;
    public final h kE;
    public final int position;
    
    public a(ah paramah, h paramh, int paramInt)
    {
      this.afQ = paramah;
      this.kE = paramh;
      this.position = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.e
 * JD-Core Version:    0.7.0.1
 */