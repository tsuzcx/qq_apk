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
  private static final int Vk = 2130968595;
  private boolean NG;
  private boolean VA;
  private int VB;
  private int VC;
  private boolean VD;
  private o.a VE;
  ViewTreeObserver VF;
  private PopupWindow.OnDismissListener VG;
  boolean VH;
  private final int Vl;
  private final int Vm;
  private final int Vn;
  private final boolean Vo;
  final Handler Vp;
  private final List<h> Vq = new ArrayList();
  final List<a> Vr = new ArrayList();
  final ViewTreeObserver.OnGlobalLayoutListener Vs = new ViewTreeObserver.OnGlobalLayoutListener()
  {
    public final void onGlobalLayout()
    {
      Object localObject;
      if ((e.this.isShowing()) && (e.this.Vr.size() > 0) && (!((e.a)e.this.Vr.get(0)).VN.ahs))
      {
        localObject = e.this.Vx;
        if ((localObject != null) && (((View)localObject).isShown())) {
          break label77;
        }
        e.this.dismiss();
      }
      for (;;)
      {
        return;
        label77:
        localObject = e.this.Vr.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((e.a)((Iterator)localObject).next()).VN.show();
        }
      }
    }
  };
  private final View.OnAttachStateChangeListener Vt = new View.OnAttachStateChangeListener()
  {
    public final void onViewAttachedToWindow(View paramAnonymousView) {}
    
    public final void onViewDetachedFromWindow(View paramAnonymousView)
    {
      if (e.this.VF != null)
      {
        if (!e.this.VF.isAlive()) {
          e.this.VF = paramAnonymousView.getViewTreeObserver();
        }
        e.this.VF.removeGlobalOnLayoutListener(e.this.Vs);
      }
      paramAnonymousView.removeOnAttachStateChangeListener(this);
    }
  };
  private final ag Vu = new ag()
  {
    public final void b(h paramAnonymoush, MenuItem paramAnonymousMenuItem)
    {
      e.this.Vp.removeCallbacksAndMessages(paramAnonymoush);
    }
    
    public final void c(final h paramAnonymoush, final MenuItem paramAnonymousMenuItem)
    {
      e.this.Vp.removeCallbacksAndMessages(null);
      int i = 0;
      int j = e.this.Vr.size();
      if (i < j) {
        if (paramAnonymoush != ((e.a)e.this.Vr.get(i)).Pw) {}
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
        if (i < e.this.Vr.size()) {}
        for (final e.a locala = (e.a)e.this.Vr.get(i);; locala = null)
        {
          paramAnonymousMenuItem = new Runnable()
          {
            public final void run()
            {
              if (locala != null)
              {
                e.this.VH = true;
                locala.Pw.V(false);
                e.this.VH = false;
              }
              if ((paramAnonymousMenuItem.isEnabled()) && (paramAnonymousMenuItem.hasSubMenu())) {
                paramAnonymoush.a(paramAnonymousMenuItem, null, 4);
              }
            }
          };
          long l = SystemClock.uptimeMillis();
          e.this.Vp.postAtTime(paramAnonymousMenuItem, paramAnonymoush, l + 200L);
          return;
        }
        i = -1;
      }
    }
  };
  private int Vv = 0;
  private int Vw = 0;
  View Vx;
  private int Vy;
  private boolean Vz;
  private View iU;
  private final Context mContext;
  
  public e(Context paramContext, View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.iU = paramView;
    this.Vm = paramInt1;
    this.Vn = paramInt2;
    this.Vo = paramBoolean;
    this.VD = false;
    this.Vy = fO();
    paramContext = paramContext.getResources();
    this.Vl = Math.max(paramContext.getDisplayMetrics().widthPixels / 2, paramContext.getDimensionPixelSize(2131427360));
    this.Vp = new Handler();
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
    paramh = a(parama.Pw, paramh);
    if (paramh == null) {
      return null;
    }
    y localy = parama.VN.agW;
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
      if (paramh != parama.bb(i)) {
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
  
  private int ba(int paramInt)
  {
    y localy = ((a)this.Vr.get(this.Vr.size() - 1)).VN.agW;
    int[] arrayOfInt = new int[2];
    localy.getLocationOnScreen(arrayOfInt);
    Rect localRect = new Rect();
    this.Vx.getWindowVisibleDisplayFrame(localRect);
    if (this.Vy == 1)
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
  
  private ah fN()
  {
    ah localah = new ah(this.mContext, this.Vm, this.Vn);
    localah.ahw = this.Vu;
    localah.ahl = this;
    localah.setOnDismissListener(this);
    localah.ahj = this.iU;
    localah.Vw = this.Vw;
    localah.setModal(true);
    localah.iD();
    return localah;
  }
  
  private int fO()
  {
    int i = 1;
    if (t.T(this.iU) == 1) {
      i = 0;
    }
    return i;
  }
  
  private void g(h paramh)
  {
    Object localObject3 = LayoutInflater.from(this.mContext);
    Object localObject1 = new g(paramh, (LayoutInflater)localObject3, this.Vo, Vk);
    int m;
    ah localah;
    Object localObject2;
    label138:
    int j;
    int i;
    label167:
    int k;
    if ((!isShowing()) && (this.VD))
    {
      ((g)localObject1).VD = true;
      m = a((ListAdapter)localObject1, null, this.mContext, this.Vl);
      localah = fN();
      localah.setAdapter((ListAdapter)localObject1);
      localah.setContentWidth(m);
      localah.Vw = this.Vw;
      if (this.Vr.size() <= 0) {
        break label372;
      }
      localObject1 = (a)this.Vr.get(this.Vr.size() - 1);
      localObject2 = a((a)localObject1, paramh);
      if (localObject2 == null) {
        break label514;
      }
      localah.iG();
      localah.iF();
      j = ba(m);
      if (j != 1) {
        break label381;
      }
      i = 1;
      this.Vy = j;
      if (Build.VERSION.SDK_INT < 26) {
        break label386;
      }
      localah.ahj = ((View)localObject2);
      j = 0;
      k = 0;
      label192:
      if ((this.Vw & 0x5) != 5) {
        break label489;
      }
      if (i == 0) {
        break label477;
      }
      i = k + m;
      label212:
      localah.agY = i;
      localah.iE();
      localah.setVerticalOffset(j);
    }
    for (;;)
    {
      localObject2 = new a(localah, paramh, this.Vy);
      this.Vr.add(localObject2);
      localah.show();
      localObject2 = localah.agW;
      ((ListView)localObject2).setOnKeyListener(this);
      if ((localObject1 == null) && (this.NG) && (paramh.Wu != null))
      {
        localObject1 = (FrameLayout)((LayoutInflater)localObject3).inflate(2130968602, (ViewGroup)localObject2, false);
        localObject3 = (TextView)((FrameLayout)localObject1).findViewById(16908310);
        ((FrameLayout)localObject1).setEnabled(false);
        ((TextView)localObject3).setText(paramh.Wu);
        ((ListView)localObject2).addHeaderView((View)localObject1, null, false);
        localah.show();
      }
      return;
      if (!isShowing()) {
        break;
      }
      ((g)localObject1).VD = m.h(paramh);
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
      this.iU.getLocationOnScreen(arrayOfInt1);
      int[] arrayOfInt2 = new int[2];
      ((View)localObject2).getLocationOnScreen(arrayOfInt2);
      if ((this.Vw & 0x7) == 5)
      {
        arrayOfInt1[0] += this.iU.getWidth();
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
      if (this.Vz) {
        localah.agY = this.VB;
      }
      if (this.VA) {
        localah.setVerticalOffset(this.VC);
      }
      localah.Xa = this.Xa;
    }
  }
  
  public final void a(h paramh, boolean paramBoolean)
  {
    int j = this.Vr.size();
    int i = 0;
    if (i < j) {
      if (paramh == ((a)this.Vr.get(i)).Pw) {
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
      if (j < this.Vr.size()) {
        ((a)this.Vr.get(j)).Pw.V(false);
      }
      a locala = (a)this.Vr.remove(i);
      locala.Pw.b(this);
      if (this.VH)
      {
        ah localah = locala.VN;
        if (Build.VERSION.SDK_INT >= 23) {
          localah.aht.setExitTransition(null);
        }
        locala.VN.setAnimationStyle(0);
      }
      locala.VN.dismiss();
      i = this.Vr.size();
      if (i > 0) {}
      for (this.Vy = ((a)this.Vr.get(i - 1)).position; i == 0; this.Vy = fO())
      {
        dismiss();
        if (this.VE != null) {
          this.VE.a(paramh, true);
        }
        if (this.VF != null)
        {
          if (this.VF.isAlive()) {
            this.VF.removeGlobalOnLayoutListener(this.Vs);
          }
          this.VF = null;
        }
        this.Vx.removeOnAttachStateChangeListener(this.Vt);
        this.VG.onDismiss();
        return;
      }
    } while (!paramBoolean);
    ((a)this.Vr.get(0)).Pw.V(false);
  }
  
  public final void a(o.a parama)
  {
    this.VE = parama;
  }
  
  public final boolean a(u paramu)
  {
    Iterator localIterator = this.Vr.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (paramu == locala.Pw)
      {
        locala.VN.agW.requestFocus();
        return true;
      }
    }
    if (paramu.hasVisibleItems())
    {
      f(paramu);
      if (this.VE != null) {
        this.VE.d(paramu);
      }
      return true;
    }
    return false;
  }
  
  public final boolean aG()
  {
    return false;
  }
  
  public final void dismiss()
  {
    int i = this.Vr.size();
    if (i > 0)
    {
      a[] arrayOfa = (a[])this.Vr.toArray(new a[i]);
      i -= 1;
      while (i >= 0)
      {
        a locala = arrayOfa[i];
        if (locala.VN.aht.isShowing()) {
          locala.VN.dismiss();
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
    this.Vq.add(paramh);
  }
  
  protected final boolean fP()
  {
    return false;
  }
  
  public final ListView getListView()
  {
    if (this.Vr.isEmpty()) {
      return null;
    }
    return ((a)this.Vr.get(this.Vr.size() - 1)).VN.agW;
  }
  
  public final boolean isShowing()
  {
    return (this.Vr.size() > 0) && (((a)this.Vr.get(0)).VN.aht.isShowing());
  }
  
  public final void n(boolean paramBoolean)
  {
    Iterator localIterator = this.Vr.iterator();
    while (localIterator.hasNext()) {
      a(((a)localIterator.next()).VN.agW.getAdapter()).notifyDataSetChanged();
    }
  }
  
  public final void onDismiss()
  {
    int j = this.Vr.size();
    int i = 0;
    a locala;
    if (i < j)
    {
      locala = (a)this.Vr.get(i);
      if (locala.VN.aht.isShowing()) {}
    }
    for (;;)
    {
      if (locala != null) {
        locala.Pw.V(false);
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
    if (this.iU != paramView)
    {
      this.iU = paramView;
      this.Vw = d.getAbsoluteGravity(this.Vv, t.T(this.iU));
    }
  }
  
  public final void setForceShowIcon(boolean paramBoolean)
  {
    this.VD = paramBoolean;
  }
  
  public final void setGravity(int paramInt)
  {
    if (this.Vv != paramInt)
    {
      this.Vv = paramInt;
      this.Vw = d.getAbsoluteGravity(paramInt, t.T(this.iU));
    }
  }
  
  public final void setHorizontalOffset(int paramInt)
  {
    this.Vz = true;
    this.VB = paramInt;
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
    this.VA = true;
    this.VC = paramInt;
  }
  
  public final void show()
  {
    if (isShowing()) {}
    do
    {
      return;
      Iterator localIterator = this.Vq.iterator();
      while (localIterator.hasNext()) {
        g((h)localIterator.next());
      }
      this.Vq.clear();
      this.Vx = this.iU;
    } while (this.Vx == null);
    if (this.VF == null) {}
    for (int i = 1;; i = 0)
    {
      this.VF = this.Vx.getViewTreeObserver();
      if (i != 0) {
        this.VF.addOnGlobalLayoutListener(this.Vs);
      }
      this.Vx.addOnAttachStateChangeListener(this.Vt);
      return;
    }
  }
  
  static final class a
  {
    public final h Pw;
    public final ah VN;
    public final int position;
    
    public a(ah paramah, h paramh, int paramInt)
    {
      this.VN = paramah;
      this.Pw = paramh;
      this.position = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.e
 * JD-Core Version:    0.7.0.1
 */