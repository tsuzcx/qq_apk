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
  private static final int acp = 2131492902;
  private boolean UK;
  private int acA = 0;
  private int acB = 0;
  View acC;
  private int acD;
  private boolean acE;
  private boolean acF;
  private int acG;
  private int acH;
  private boolean acI;
  private o.a acJ;
  ViewTreeObserver acK;
  private PopupWindow.OnDismissListener acL;
  boolean acM;
  private final int acq;
  private final int acr;
  private final int acs;
  private final boolean act;
  final Handler acu;
  private final List<h> acv = new ArrayList();
  final List<a> acw = new ArrayList();
  final ViewTreeObserver.OnGlobalLayoutListener acx = new ViewTreeObserver.OnGlobalLayoutListener()
  {
    public final void onGlobalLayout()
    {
      Object localObject;
      if ((e.this.isShowing()) && (e.this.acw.size() > 0) && (!((e.a)e.this.acw.get(0)).acS.aoz))
      {
        localObject = e.this.acC;
        if ((localObject != null) && (((View)localObject).isShown())) {
          break label77;
        }
        e.this.dismiss();
      }
      for (;;)
      {
        return;
        label77:
        localObject = e.this.acw.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((e.a)((Iterator)localObject).next()).acS.show();
        }
      }
    }
  };
  private final View.OnAttachStateChangeListener acy = new View.OnAttachStateChangeListener()
  {
    public final void onViewAttachedToWindow(View paramAnonymousView) {}
    
    public final void onViewDetachedFromWindow(View paramAnonymousView)
    {
      if (e.this.acK != null)
      {
        if (!e.this.acK.isAlive()) {
          e.this.acK = paramAnonymousView.getViewTreeObserver();
        }
        e.this.acK.removeGlobalOnLayoutListener(e.this.acx);
      }
      paramAnonymousView.removeOnAttachStateChangeListener(this);
    }
  };
  private final ag acz = new ag()
  {
    public final void b(h paramAnonymoush, MenuItem paramAnonymousMenuItem)
    {
      e.this.acu.removeCallbacksAndMessages(paramAnonymoush);
    }
    
    public final void c(final h paramAnonymoush, final MenuItem paramAnonymousMenuItem)
    {
      e.this.acu.removeCallbacksAndMessages(null);
      int i = 0;
      int j = e.this.acw.size();
      if (i < j) {
        if (paramAnonymoush != ((e.a)e.this.acw.get(i)).hI) {}
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
        if (i < e.this.acw.size()) {}
        for (final e.a locala = (e.a)e.this.acw.get(i);; locala = null)
        {
          paramAnonymousMenuItem = new Runnable()
          {
            public final void run()
            {
              if (locala != null)
              {
                e.this.acM = true;
                locala.hI.ab(false);
                e.this.acM = false;
              }
              if ((paramAnonymousMenuItem.isEnabled()) && (paramAnonymousMenuItem.hasSubMenu())) {
                paramAnonymoush.a(paramAnonymousMenuItem, null, 4);
              }
            }
          };
          long l = SystemClock.uptimeMillis();
          e.this.acu.postAtTime(paramAnonymousMenuItem, paramAnonymoush, l + 200L);
          return;
        }
        i = -1;
      }
    }
  };
  private final Context mContext;
  private View nO;
  
  public e(Context paramContext, View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.nO = paramView;
    this.acr = paramInt1;
    this.acs = paramInt2;
    this.act = paramBoolean;
    this.acI = false;
    this.acD = hk();
    paramContext = paramContext.getResources();
    this.acq = Math.max(paramContext.getDisplayMetrics().widthPixels / 2, paramContext.getDimensionPixelSize(2131165655));
    this.acu = new Handler();
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
    paramh = a(parama.hI, paramh);
    if (paramh == null) {
      return null;
    }
    y localy = parama.acS.aod;
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
    y localy = ((a)this.acw.get(this.acw.size() - 1)).acS.aod;
    int[] arrayOfInt = new int[2];
    localy.getLocationOnScreen(arrayOfInt);
    Rect localRect = new Rect();
    this.acC.getWindowVisibleDisplayFrame(localRect);
    if (this.acD == 1)
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
    Object localObject1 = new g(paramh, (LayoutInflater)localObject3, this.act, acp);
    int m;
    ah localah;
    Object localObject2;
    label138:
    int j;
    int i;
    label167:
    int k;
    if ((!isShowing()) && (this.acI))
    {
      ((g)localObject1).acI = true;
      m = a((ListAdapter)localObject1, null, this.mContext, this.acq);
      localah = hj();
      localah.setAdapter((ListAdapter)localObject1);
      localah.setContentWidth(m);
      localah.acB = this.acB;
      if (this.acw.size() <= 0) {
        break label372;
      }
      localObject1 = (a)this.acw.get(this.acw.size() - 1);
      localObject2 = a((a)localObject1, paramh);
      if (localObject2 == null) {
        break label514;
      }
      localah.kb();
      localah.ka();
      j = bt(m);
      if (j != 1) {
        break label381;
      }
      i = 1;
      this.acD = j;
      if (Build.VERSION.SDK_INT < 26) {
        break label386;
      }
      localah.aoq = ((View)localObject2);
      j = 0;
      k = 0;
      label192:
      if ((this.acB & 0x5) != 5) {
        break label489;
      }
      if (i == 0) {
        break label477;
      }
      i = k + m;
      label212:
      localah.aof = i;
      localah.jZ();
      localah.setVerticalOffset(j);
    }
    for (;;)
    {
      localObject2 = new a(localah, paramh, this.acD);
      this.acw.add(localObject2);
      localah.show();
      localObject2 = localah.aod;
      ((ListView)localObject2).setOnKeyListener(this);
      if ((localObject1 == null) && (this.UK) && (paramh.adA != null))
      {
        localObject1 = (FrameLayout)((LayoutInflater)localObject3).inflate(2131492909, (ViewGroup)localObject2, false);
        localObject3 = (TextView)((FrameLayout)localObject1).findViewById(16908310);
        ((FrameLayout)localObject1).setEnabled(false);
        ((TextView)localObject3).setText(paramh.adA);
        ((ListView)localObject2).addHeaderView((View)localObject1, null, false);
        localah.show();
      }
      return;
      if (!isShowing()) {
        break;
      }
      ((g)localObject1).acI = m.h(paramh);
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
      this.nO.getLocationOnScreen(arrayOfInt1);
      int[] arrayOfInt2 = new int[2];
      ((View)localObject2).getLocationOnScreen(arrayOfInt2);
      if ((this.acB & 0x7) == 5)
      {
        arrayOfInt1[0] += this.nO.getWidth();
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
      if (this.acE) {
        localah.aof = this.acG;
      }
      if (this.acF) {
        localah.setVerticalOffset(this.acH);
      }
      localah.aef = this.aef;
    }
  }
  
  private ah hj()
  {
    ah localah = new ah(this.mContext, this.acr, this.acs);
    localah.aoD = this.acz;
    localah.aos = this;
    localah.setOnDismissListener(this);
    localah.aoq = this.nO;
    localah.acB = this.acB;
    localah.setModal(true);
    localah.jY();
    return localah;
  }
  
  private int hk()
  {
    int i = 1;
    if (t.Y(this.nO) == 1) {
      i = 0;
    }
    return i;
  }
  
  public final void a(h paramh, boolean paramBoolean)
  {
    int j = this.acw.size();
    int i = 0;
    if (i < j) {
      if (paramh == ((a)this.acw.get(i)).hI) {
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
      if (j < this.acw.size()) {
        ((a)this.acw.get(j)).hI.ab(false);
      }
      a locala = (a)this.acw.remove(i);
      locala.hI.b(this);
      if (this.acM)
      {
        ah localah = locala.acS;
        if (Build.VERSION.SDK_INT >= 23) {
          localah.aoA.setExitTransition(null);
        }
        locala.acS.setAnimationStyle(0);
      }
      locala.acS.dismiss();
      i = this.acw.size();
      if (i > 0) {}
      for (this.acD = ((a)this.acw.get(i - 1)).position; i == 0; this.acD = hk())
      {
        dismiss();
        if (this.acJ != null) {
          this.acJ.a(paramh, true);
        }
        if (this.acK != null)
        {
          if (this.acK.isAlive()) {
            this.acK.removeGlobalOnLayoutListener(this.acx);
          }
          this.acK = null;
        }
        this.acC.removeOnAttachStateChangeListener(this.acy);
        this.acL.onDismiss();
        return;
      }
    } while (!paramBoolean);
    ((a)this.acw.get(0)).hI.ab(false);
  }
  
  public final void a(o.a parama)
  {
    this.acJ = parama;
  }
  
  public final boolean a(u paramu)
  {
    Iterator localIterator = this.acw.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (paramu == locala.hI)
      {
        locala.acS.aod.requestFocus();
        return true;
      }
    }
    if (paramu.hasVisibleItems())
    {
      f(paramu);
      if (this.acJ != null) {
        this.acJ.d(paramu);
      }
      return true;
    }
    return false;
  }
  
  public final boolean bh()
  {
    return false;
  }
  
  public final void dismiss()
  {
    int i = this.acw.size();
    if (i > 0)
    {
      a[] arrayOfa = (a[])this.acw.toArray(new a[i]);
      i -= 1;
      while (i >= 0)
      {
        a locala = arrayOfa[i];
        if (locala.acS.aoA.isShowing()) {
          locala.acS.dismiss();
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
    this.acv.add(paramh);
  }
  
  public final ListView getListView()
  {
    if (this.acw.isEmpty()) {
      return null;
    }
    return ((a)this.acw.get(this.acw.size() - 1)).acS.aod;
  }
  
  protected final boolean hl()
  {
    return false;
  }
  
  public final boolean isShowing()
  {
    return (this.acw.size() > 0) && (((a)this.acw.get(0)).acS.aoA.isShowing());
  }
  
  public final void onDismiss()
  {
    int j = this.acw.size();
    int i = 0;
    a locala;
    if (i < j)
    {
      locala = (a)this.acw.get(i);
      if (locala.acS.aoA.isShowing()) {}
    }
    for (;;)
    {
      if (locala != null) {
        locala.hI.ab(false);
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
    Iterator localIterator = this.acw.iterator();
    while (localIterator.hasNext()) {
      a(((a)localIterator.next()).acS.aod.getAdapter()).notifyDataSetChanged();
    }
  }
  
  public final void setAnchorView(View paramView)
  {
    if (this.nO != paramView)
    {
      this.nO = paramView;
      this.acB = d.getAbsoluteGravity(this.acA, t.Y(this.nO));
    }
  }
  
  public final void setForceShowIcon(boolean paramBoolean)
  {
    this.acI = paramBoolean;
  }
  
  public final void setGravity(int paramInt)
  {
    if (this.acA != paramInt)
    {
      this.acA = paramInt;
      this.acB = d.getAbsoluteGravity(paramInt, t.Y(this.nO));
    }
  }
  
  public final void setHorizontalOffset(int paramInt)
  {
    this.acE = true;
    this.acG = paramInt;
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
    this.acF = true;
    this.acH = paramInt;
  }
  
  public final void show()
  {
    if (isShowing()) {}
    do
    {
      return;
      Iterator localIterator = this.acv.iterator();
      while (localIterator.hasNext()) {
        g((h)localIterator.next());
      }
      this.acv.clear();
      this.acC = this.nO;
    } while (this.acC == null);
    if (this.acK == null) {}
    for (int i = 1;; i = 0)
    {
      this.acK = this.acC.getViewTreeObserver();
      if (i != 0) {
        this.acK.addOnGlobalLayoutListener(this.acx);
      }
      this.acC.addOnAttachStateChangeListener(this.acy);
      return;
    }
  }
  
  static final class a
  {
    public final ah acS;
    public final h hI;
    public final int position;
    
    public a(ah paramah, h paramh, int paramInt)
    {
      this.acS = paramah;
      this.hI = paramh;
      this.position = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.e
 * JD-Core Version:    0.7.0.1
 */