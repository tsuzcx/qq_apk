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
  private static final int adj = 2131492902;
  private boolean VG;
  private int adA;
  private int adB;
  private boolean adC;
  private o.a adD;
  ViewTreeObserver adE;
  private PopupWindow.OnDismissListener adF;
  boolean adG;
  private final int adk;
  private final int adl;
  private final int adm;
  private final boolean adn;
  final Handler ado;
  private final List<h> adp = new ArrayList();
  final List<a> adq = new ArrayList();
  final ViewTreeObserver.OnGlobalLayoutListener adr = new ViewTreeObserver.OnGlobalLayoutListener()
  {
    public final void onGlobalLayout()
    {
      Object localObject;
      if ((e.this.isShowing()) && (e.this.adq.size() > 0) && (!((e.a)e.this.adq.get(0)).adM.apv))
      {
        localObject = e.this.adw;
        if ((localObject != null) && (((View)localObject).isShown())) {
          break label77;
        }
        e.this.dismiss();
      }
      for (;;)
      {
        return;
        label77:
        localObject = e.this.adq.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((e.a)((Iterator)localObject).next()).adM.show();
        }
      }
    }
  };
  private final View.OnAttachStateChangeListener ads = new View.OnAttachStateChangeListener()
  {
    public final void onViewAttachedToWindow(View paramAnonymousView) {}
    
    public final void onViewDetachedFromWindow(View paramAnonymousView)
    {
      if (e.this.adE != null)
      {
        if (!e.this.adE.isAlive()) {
          e.this.adE = paramAnonymousView.getViewTreeObserver();
        }
        e.this.adE.removeGlobalOnLayoutListener(e.this.adr);
      }
      paramAnonymousView.removeOnAttachStateChangeListener(this);
    }
  };
  private final ag adt = new ag()
  {
    public final void b(h paramAnonymoush, MenuItem paramAnonymousMenuItem)
    {
      e.this.ado.removeCallbacksAndMessages(paramAnonymoush);
    }
    
    public final void c(final h paramAnonymoush, final MenuItem paramAnonymousMenuItem)
    {
      e.this.ado.removeCallbacksAndMessages(null);
      int i = 0;
      int j = e.this.adq.size();
      if (i < j) {
        if (paramAnonymoush != ((e.a)e.this.adq.get(i)).iL) {}
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
        if (i < e.this.adq.size()) {}
        for (final e.a locala = (e.a)e.this.adq.get(i);; locala = null)
        {
          paramAnonymousMenuItem = new Runnable()
          {
            public final void run()
            {
              if (locala != null)
              {
                e.this.adG = true;
                locala.iL.ab(false);
                e.this.adG = false;
              }
              if ((paramAnonymousMenuItem.isEnabled()) && (paramAnonymousMenuItem.hasSubMenu())) {
                paramAnonymoush.a(paramAnonymousMenuItem, null, 4);
              }
            }
          };
          long l = SystemClock.uptimeMillis();
          e.this.ado.postAtTime(paramAnonymousMenuItem, paramAnonymoush, l + 200L);
          return;
        }
        i = -1;
      }
    }
  };
  private int adu = 0;
  private int adv = 0;
  View adw;
  private int adx;
  private boolean ady;
  private boolean adz;
  private final Context mContext;
  private View oP;
  
  public e(Context paramContext, View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.oP = paramView;
    this.adl = paramInt1;
    this.adm = paramInt2;
    this.adn = paramBoolean;
    this.adC = false;
    this.adx = hs();
    paramContext = paramContext.getResources();
    this.adk = Math.max(paramContext.getDisplayMetrics().widthPixels / 2, paramContext.getDimensionPixelSize(2131165655));
    this.ado = new Handler();
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
    paramh = a(parama.iL, paramh);
    if (paramh == null) {
      return null;
    }
    y localy = parama.adM.aoY;
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
    y localy = ((a)this.adq.get(this.adq.size() - 1)).adM.aoY;
    int[] arrayOfInt = new int[2];
    localy.getLocationOnScreen(arrayOfInt);
    Rect localRect = new Rect();
    this.adw.getWindowVisibleDisplayFrame(localRect);
    if (this.adx == 1)
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
    Object localObject1 = new g(paramh, (LayoutInflater)localObject3, this.adn, adj);
    int m;
    ah localah;
    Object localObject2;
    label138:
    int j;
    int i;
    label167:
    int k;
    if ((!isShowing()) && (this.adC))
    {
      ((g)localObject1).adC = true;
      m = a((ListAdapter)localObject1, null, this.mContext, this.adk);
      localah = hr();
      localah.setAdapter((ListAdapter)localObject1);
      localah.setContentWidth(m);
      localah.adv = this.adv;
      if (this.adq.size() <= 0) {
        break label372;
      }
      localObject1 = (a)this.adq.get(this.adq.size() - 1);
      localObject2 = a((a)localObject1, paramh);
      if (localObject2 == null) {
        break label514;
      }
      localah.kj();
      localah.ki();
      j = bt(m);
      if (j != 1) {
        break label381;
      }
      i = 1;
      this.adx = j;
      if (Build.VERSION.SDK_INT < 26) {
        break label386;
      }
      localah.apl = ((View)localObject2);
      j = 0;
      k = 0;
      label192:
      if ((this.adv & 0x5) != 5) {
        break label489;
      }
      if (i == 0) {
        break label477;
      }
      i = k + m;
      label212:
      localah.apa = i;
      localah.kh();
      localah.setVerticalOffset(j);
    }
    for (;;)
    {
      localObject2 = new a(localah, paramh, this.adx);
      this.adq.add(localObject2);
      localah.show();
      localObject2 = localah.aoY;
      ((ListView)localObject2).setOnKeyListener(this);
      if ((localObject1 == null) && (this.VG) && (paramh.aeu != null))
      {
        localObject1 = (FrameLayout)((LayoutInflater)localObject3).inflate(2131492909, (ViewGroup)localObject2, false);
        localObject3 = (TextView)((FrameLayout)localObject1).findViewById(16908310);
        ((FrameLayout)localObject1).setEnabled(false);
        ((TextView)localObject3).setText(paramh.aeu);
        ((ListView)localObject2).addHeaderView((View)localObject1, null, false);
        localah.show();
      }
      return;
      if (!isShowing()) {
        break;
      }
      ((g)localObject1).adC = m.h(paramh);
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
      this.oP.getLocationOnScreen(arrayOfInt1);
      int[] arrayOfInt2 = new int[2];
      ((View)localObject2).getLocationOnScreen(arrayOfInt2);
      if ((this.adv & 0x7) == 5)
      {
        arrayOfInt1[0] += this.oP.getWidth();
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
      if (this.ady) {
        localah.apa = this.adA;
      }
      if (this.adz) {
        localah.setVerticalOffset(this.adB);
      }
      localah.aeZ = this.aeZ;
    }
  }
  
  private ah hr()
  {
    ah localah = new ah(this.mContext, this.adl, this.adm);
    localah.apz = this.adt;
    localah.apn = this;
    localah.setOnDismissListener(this);
    localah.apl = this.oP;
    localah.adv = this.adv;
    localah.setModal(true);
    localah.kg();
    return localah;
  }
  
  private int hs()
  {
    int i = 1;
    if (t.Y(this.oP) == 1) {
      i = 0;
    }
    return i;
  }
  
  public final void a(h paramh, boolean paramBoolean)
  {
    int j = this.adq.size();
    int i = 0;
    if (i < j) {
      if (paramh == ((a)this.adq.get(i)).iL) {
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
      if (j < this.adq.size()) {
        ((a)this.adq.get(j)).iL.ab(false);
      }
      a locala = (a)this.adq.remove(i);
      locala.iL.b(this);
      if (this.adG)
      {
        ah localah = locala.adM;
        if (Build.VERSION.SDK_INT >= 23) {
          localah.apw.setExitTransition(null);
        }
        locala.adM.setAnimationStyle(0);
      }
      locala.adM.dismiss();
      i = this.adq.size();
      if (i > 0) {}
      for (this.adx = ((a)this.adq.get(i - 1)).position; i == 0; this.adx = hs())
      {
        dismiss();
        if (this.adD != null) {
          this.adD.a(paramh, true);
        }
        if (this.adE != null)
        {
          if (this.adE.isAlive()) {
            this.adE.removeGlobalOnLayoutListener(this.adr);
          }
          this.adE = null;
        }
        this.adw.removeOnAttachStateChangeListener(this.ads);
        this.adF.onDismiss();
        return;
      }
    } while (!paramBoolean);
    ((a)this.adq.get(0)).iL.ab(false);
  }
  
  public final void a(o.a parama)
  {
    this.adD = parama;
  }
  
  public final boolean a(u paramu)
  {
    Iterator localIterator = this.adq.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (paramu == locala.iL)
      {
        locala.adM.aoY.requestFocus();
        return true;
      }
    }
    if (paramu.hasVisibleItems())
    {
      f(paramu);
      if (this.adD != null) {
        this.adD.d(paramu);
      }
      return true;
    }
    return false;
  }
  
  public final boolean bo()
  {
    return false;
  }
  
  public final void dismiss()
  {
    int i = this.adq.size();
    if (i > 0)
    {
      a[] arrayOfa = (a[])this.adq.toArray(new a[i]);
      i -= 1;
      while (i >= 0)
      {
        a locala = arrayOfa[i];
        if (locala.adM.apw.isShowing()) {
          locala.adM.dismiss();
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
    this.adp.add(paramh);
  }
  
  public final ListView getListView()
  {
    if (this.adq.isEmpty()) {
      return null;
    }
    return ((a)this.adq.get(this.adq.size() - 1)).adM.aoY;
  }
  
  protected final boolean ht()
  {
    return false;
  }
  
  public final boolean isShowing()
  {
    return (this.adq.size() > 0) && (((a)this.adq.get(0)).adM.apw.isShowing());
  }
  
  public final void onDismiss()
  {
    int j = this.adq.size();
    int i = 0;
    a locala;
    if (i < j)
    {
      locala = (a)this.adq.get(i);
      if (locala.adM.apw.isShowing()) {}
    }
    for (;;)
    {
      if (locala != null) {
        locala.iL.ab(false);
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
    Iterator localIterator = this.adq.iterator();
    while (localIterator.hasNext()) {
      a(((a)localIterator.next()).adM.aoY.getAdapter()).notifyDataSetChanged();
    }
  }
  
  public final void setAnchorView(View paramView)
  {
    if (this.oP != paramView)
    {
      this.oP = paramView;
      this.adv = d.getAbsoluteGravity(this.adu, t.Y(this.oP));
    }
  }
  
  public final void setForceShowIcon(boolean paramBoolean)
  {
    this.adC = paramBoolean;
  }
  
  public final void setGravity(int paramInt)
  {
    if (this.adu != paramInt)
    {
      this.adu = paramInt;
      this.adv = d.getAbsoluteGravity(paramInt, t.Y(this.oP));
    }
  }
  
  public final void setHorizontalOffset(int paramInt)
  {
    this.ady = true;
    this.adA = paramInt;
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
    this.adz = true;
    this.adB = paramInt;
  }
  
  public final void show()
  {
    if (isShowing()) {}
    do
    {
      return;
      Iterator localIterator = this.adp.iterator();
      while (localIterator.hasNext()) {
        g((h)localIterator.next());
      }
      this.adp.clear();
      this.adw = this.oP;
    } while (this.adw == null);
    if (this.adE == null) {}
    for (int i = 1;; i = 0)
    {
      this.adE = this.adw.getViewTreeObserver();
      if (i != 0) {
        this.adE.addOnGlobalLayoutListener(this.adr);
      }
      this.adw.addOnAttachStateChangeListener(this.ads);
      return;
    }
  }
  
  static final class a
  {
    public final ah adM;
    public final h iL;
    public final int position;
    
    public a(ah paramah, h paramh, int paramInt)
    {
      this.adM = paramah;
      this.iL = paramh;
      this.position = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.e
 * JD-Core Version:    0.7.0.1
 */