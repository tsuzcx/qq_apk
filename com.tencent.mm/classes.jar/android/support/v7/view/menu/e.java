package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.view.d;
import android.support.v4.view.t;
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
  private static final int afa = 2131492902;
  private boolean Xv;
  private final int afb;
  private final int afc;
  private final int afd;
  private final boolean afe;
  final Handler aff;
  private final List<h> afg = new ArrayList();
  final List<a> afh = new ArrayList();
  final ViewTreeObserver.OnGlobalLayoutListener afi = new ViewTreeObserver.OnGlobalLayoutListener()
  {
    public final void onGlobalLayout()
    {
      Object localObject;
      if ((e.this.isShowing()) && (e.this.afh.size() > 0) && (!((e.a)e.this.afh.get(0)).afD.arm))
      {
        localObject = e.this.afn;
        if ((localObject != null) && (((View)localObject).isShown())) {
          break label77;
        }
        e.this.dismiss();
      }
      for (;;)
      {
        return;
        label77:
        localObject = e.this.afh.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((e.a)((Iterator)localObject).next()).afD.show();
        }
      }
    }
  };
  private final View.OnAttachStateChangeListener afj = new View.OnAttachStateChangeListener()
  {
    public final void onViewAttachedToWindow(View paramAnonymousView) {}
    
    public final void onViewDetachedFromWindow(View paramAnonymousView)
    {
      if (e.this.afv != null)
      {
        if (!e.this.afv.isAlive()) {
          e.this.afv = paramAnonymousView.getViewTreeObserver();
        }
        e.this.afv.removeGlobalOnLayoutListener(e.this.afi);
      }
      paramAnonymousView.removeOnAttachStateChangeListener(this);
    }
  };
  private final ag afk = new ag()
  {
    public final void b(h paramAnonymoush, MenuItem paramAnonymousMenuItem)
    {
      e.this.aff.removeCallbacksAndMessages(paramAnonymoush);
    }
    
    public final void c(final h paramAnonymoush, final MenuItem paramAnonymousMenuItem)
    {
      e.this.aff.removeCallbacksAndMessages(null);
      int i = 0;
      int j = e.this.afh.size();
      if (i < j) {
        if (paramAnonymoush != ((e.a)e.this.afh.get(i)).kC) {}
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
        if (i < e.this.afh.size()) {}
        for (final e.a locala = (e.a)e.this.afh.get(i);; locala = null)
        {
          paramAnonymousMenuItem = new Runnable()
          {
            public final void run()
            {
              if (locala != null)
              {
                e.this.afx = true;
                locala.kC.ab(false);
                e.this.afx = false;
              }
              if ((paramAnonymousMenuItem.isEnabled()) && (paramAnonymousMenuItem.hasSubMenu())) {
                paramAnonymoush.a(paramAnonymousMenuItem, null, 4);
              }
            }
          };
          long l = SystemClock.uptimeMillis();
          e.this.aff.postAtTime(paramAnonymousMenuItem, paramAnonymoush, l + 200L);
          return;
        }
        i = -1;
      }
    }
  };
  private int afl = 0;
  private int afm = 0;
  View afn;
  private int afo;
  private boolean afp;
  private boolean afq;
  private int afr;
  private int afs;
  private boolean aft;
  private o.a afu;
  ViewTreeObserver afv;
  private PopupWindow.OnDismissListener afw;
  boolean afx;
  private final Context mContext;
  private View qI;
  
  public e(Context paramContext, View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.qI = paramView;
    this.afc = paramInt1;
    this.afd = paramInt2;
    this.afe = paramBoolean;
    this.aft = false;
    this.afo = hI();
    paramContext = paramContext.getResources();
    this.afb = Math.max(paramContext.getDisplayMetrics().widthPixels / 2, paramContext.getDimensionPixelSize(2131165655));
    this.aff = new Handler();
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
    paramh = a(parama.kC, paramh);
    if (paramh == null) {
      return null;
    }
    y localy = parama.afD.aqQ;
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
      if (paramh != parama.bu(i)) {
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
  
  private int bt(int paramInt)
  {
    y localy = ((a)this.afh.get(this.afh.size() - 1)).afD.aqQ;
    int[] arrayOfInt = new int[2];
    localy.getLocationOnScreen(arrayOfInt);
    Rect localRect = new Rect();
    this.afn.getWindowVisibleDisplayFrame(localRect);
    if (this.afo == 1)
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
    Object localObject1 = new g(paramh, (LayoutInflater)localObject3, this.afe, afa);
    int m;
    ah localah;
    Object localObject2;
    label138:
    int j;
    int i;
    label167:
    int k;
    if ((!isShowing()) && (this.aft))
    {
      ((g)localObject1).aft = true;
      m = a((ListAdapter)localObject1, null, this.mContext, this.afb);
      localah = hH();
      localah.setAdapter((ListAdapter)localObject1);
      localah.setContentWidth(m);
      localah.afm = this.afm;
      if (this.afh.size() <= 0) {
        break label372;
      }
      localObject1 = (a)this.afh.get(this.afh.size() - 1);
      localObject2 = a((a)localObject1, paramh);
      if (localObject2 == null) {
        break label514;
      }
      localah.kz();
      localah.ky();
      j = bt(m);
      if (j != 1) {
        break label381;
      }
      i = 1;
      this.afo = j;
      if (Build.VERSION.SDK_INT < 26) {
        break label386;
      }
      localah.ard = ((View)localObject2);
      j = 0;
      k = 0;
      label192:
      if ((this.afm & 0x5) != 5) {
        break label489;
      }
      if (i == 0) {
        break label477;
      }
      i = k + m;
      label212:
      localah.aqS = i;
      localah.kx();
      localah.setVerticalOffset(j);
    }
    for (;;)
    {
      localObject2 = new a(localah, paramh, this.afo);
      this.afh.add(localObject2);
      localah.show();
      localObject2 = localah.aqQ;
      ((ListView)localObject2).setOnKeyListener(this);
      if ((localObject1 == null) && (this.Xv) && (paramh.agl != null))
      {
        localObject1 = (FrameLayout)((LayoutInflater)localObject3).inflate(2131492909, (ViewGroup)localObject2, false);
        localObject3 = (TextView)((FrameLayout)localObject1).findViewById(16908310);
        ((FrameLayout)localObject1).setEnabled(false);
        ((TextView)localObject3).setText(paramh.agl);
        ((ListView)localObject2).addHeaderView((View)localObject1, null, false);
        localah.show();
      }
      return;
      if (!isShowing()) {
        break;
      }
      ((g)localObject1).aft = m.h(paramh);
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
      this.qI.getLocationOnScreen(arrayOfInt1);
      int[] arrayOfInt2 = new int[2];
      ((View)localObject2).getLocationOnScreen(arrayOfInt2);
      if ((this.afm & 0x7) == 5)
      {
        arrayOfInt1[0] += this.qI.getWidth();
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
      if (this.afp) {
        localah.aqS = this.afr;
      }
      if (this.afq) {
        localah.setVerticalOffset(this.afs);
      }
      localah.agQ = this.agQ;
    }
  }
  
  private ah hH()
  {
    ah localah = new ah(this.mContext, this.afc, this.afd);
    localah.arq = this.afk;
    localah.arf = this;
    localah.setOnDismissListener(this);
    localah.ard = this.qI;
    localah.afm = this.afm;
    localah.setModal(true);
    localah.kw();
    return localah;
  }
  
  private int hI()
  {
    int i = 1;
    if (t.Y(this.qI) == 1) {
      i = 0;
    }
    return i;
  }
  
  public final void a(h paramh, boolean paramBoolean)
  {
    int j = this.afh.size();
    int i = 0;
    if (i < j) {
      if (paramh == ((a)this.afh.get(i)).kC) {
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
      if (j < this.afh.size()) {
        ((a)this.afh.get(j)).kC.ab(false);
      }
      a locala = (a)this.afh.remove(i);
      locala.kC.b(this);
      if (this.afx)
      {
        ah localah = locala.afD;
        if (Build.VERSION.SDK_INT >= 23) {
          localah.arn.setExitTransition(null);
        }
        locala.afD.setAnimationStyle(0);
      }
      locala.afD.dismiss();
      i = this.afh.size();
      if (i > 0) {}
      for (this.afo = ((a)this.afh.get(i - 1)).position; i == 0; this.afo = hI())
      {
        dismiss();
        if (this.afu != null) {
          this.afu.a(paramh, true);
        }
        if (this.afv != null)
        {
          if (this.afv.isAlive()) {
            this.afv.removeGlobalOnLayoutListener(this.afi);
          }
          this.afv = null;
        }
        this.afn.removeOnAttachStateChangeListener(this.afj);
        this.afw.onDismiss();
        return;
      }
    } while (!paramBoolean);
    ((a)this.afh.get(0)).kC.ab(false);
  }
  
  public final void a(o.a parama)
  {
    this.afu = parama;
  }
  
  public final boolean a(u paramu)
  {
    Iterator localIterator = this.afh.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (paramu == locala.kC)
      {
        locala.afD.aqQ.requestFocus();
        return true;
      }
    }
    if (paramu.hasVisibleItems())
    {
      f(paramu);
      if (this.afu != null) {
        this.afu.d(paramu);
      }
      return true;
    }
    return false;
  }
  
  public final boolean bD()
  {
    return false;
  }
  
  public final void dismiss()
  {
    int i = this.afh.size();
    if (i > 0)
    {
      a[] arrayOfa = (a[])this.afh.toArray(new a[i]);
      i -= 1;
      while (i >= 0)
      {
        a locala = arrayOfa[i];
        if (locala.afD.arn.isShowing()) {
          locala.afD.dismiss();
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
    this.afg.add(paramh);
  }
  
  public final ListView getListView()
  {
    if (this.afh.isEmpty()) {
      return null;
    }
    return ((a)this.afh.get(this.afh.size() - 1)).afD.aqQ;
  }
  
  protected final boolean hJ()
  {
    return false;
  }
  
  public final boolean isShowing()
  {
    return (this.afh.size() > 0) && (((a)this.afh.get(0)).afD.arn.isShowing());
  }
  
  public final void onDismiss()
  {
    int j = this.afh.size();
    int i = 0;
    a locala;
    if (i < j)
    {
      locala = (a)this.afh.get(i);
      if (locala.afD.arn.isShowing()) {}
    }
    for (;;)
    {
      if (locala != null) {
        locala.kC.ab(false);
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
    Iterator localIterator = this.afh.iterator();
    while (localIterator.hasNext()) {
      a(((a)localIterator.next()).afD.aqQ.getAdapter()).notifyDataSetChanged();
    }
  }
  
  public final void setAnchorView(View paramView)
  {
    if (this.qI != paramView)
    {
      this.qI = paramView;
      this.afm = d.getAbsoluteGravity(this.afl, t.Y(this.qI));
    }
  }
  
  public final void setForceShowIcon(boolean paramBoolean)
  {
    this.aft = paramBoolean;
  }
  
  public final void setGravity(int paramInt)
  {
    if (this.afl != paramInt)
    {
      this.afl = paramInt;
      this.afm = d.getAbsoluteGravity(paramInt, t.Y(this.qI));
    }
  }
  
  public final void setHorizontalOffset(int paramInt)
  {
    this.afp = true;
    this.afr = paramInt;
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
    this.afq = true;
    this.afs = paramInt;
  }
  
  public final void show()
  {
    if (isShowing()) {}
    do
    {
      return;
      Iterator localIterator = this.afg.iterator();
      while (localIterator.hasNext()) {
        g((h)localIterator.next());
      }
      this.afg.clear();
      this.afn = this.qI;
    } while (this.afn == null);
    if (this.afv == null) {}
    for (int i = 1;; i = 0)
    {
      this.afv = this.afn.getViewTreeObserver();
      if (i != 0) {
        this.afv.addOnGlobalLayoutListener(this.afi);
      }
      this.afn.addOnAttachStateChangeListener(this.afj);
      return;
    }
  }
  
  static final class a
  {
    public final ah afD;
    public final h kC;
    public final int position;
    
    public a(ah paramah, h paramh, int paramInt)
    {
      this.afD = paramah;
      this.kC = paramh;
      this.position = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.e
 * JD-Core Version:    0.7.0.1
 */