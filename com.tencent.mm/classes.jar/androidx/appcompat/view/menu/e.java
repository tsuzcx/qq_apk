package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
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
import androidx.appcompat.a.d;
import androidx.appcompat.a.g;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.appcompat.widget.p;
import androidx.appcompat.widget.s;
import androidx.appcompat.widget.t;
import androidx.core.g.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class e
  extends m
  implements View.OnKeyListener, PopupWindow.OnDismissListener
{
  private static final int lw = a.g.abc_cascading_menu_item_layout;
  private boolean eX;
  private final boolean lA;
  final Handler lB;
  private final List<h> lC;
  final List<a> lD;
  final ViewTreeObserver.OnGlobalLayoutListener lE;
  private final View.OnAttachStateChangeListener lF;
  private final s lG;
  private int lH;
  private int lI;
  private View lJ;
  View lK;
  private int lL;
  private boolean lM;
  private boolean lN;
  private int lO;
  private int lP;
  private boolean lQ;
  private o.a lR;
  ViewTreeObserver lS;
  private PopupWindow.OnDismissListener lT;
  boolean lU;
  private final int lx;
  private final int ly;
  private final int lz;
  private final Context mContext;
  
  public e(Context paramContext, View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(239184);
    this.lC = new ArrayList();
    this.lD = new ArrayList();
    this.lE = new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(239151);
        if ((e.this.isShowing()) && (e.this.lD.size() > 0) && (!((e.a)e.this.lD.get(0)).ma.tx))
        {
          Object localObject = e.this.lK;
          if ((localObject == null) || (!((View)localObject).isShown()))
          {
            e.this.dismiss();
            AppMethodBeat.o(239151);
            return;
          }
          localObject = e.this.lD.iterator();
          while (((Iterator)localObject).hasNext()) {
            ((e.a)((Iterator)localObject).next()).ma.show();
          }
        }
        AppMethodBeat.o(239151);
      }
    };
    this.lF = new View.OnAttachStateChangeListener()
    {
      public final void onViewAttachedToWindow(View paramAnonymousView) {}
      
      public final void onViewDetachedFromWindow(View paramAnonymousView)
      {
        AppMethodBeat.i(239155);
        if (e.this.lS != null)
        {
          if (!e.this.lS.isAlive()) {
            e.this.lS = paramAnonymousView.getViewTreeObserver();
          }
          e.this.lS.removeGlobalOnLayoutListener(e.this.lE);
        }
        paramAnonymousView.removeOnAttachStateChangeListener(this);
        AppMethodBeat.o(239155);
      }
    };
    this.lG = new s()
    {
      public final void b(h paramAnonymoush, MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(239166);
        e.this.lB.removeCallbacksAndMessages(paramAnonymoush);
        AppMethodBeat.o(239166);
      }
      
      public final void c(final h paramAnonymoush, final MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(239170);
        e.this.lB.removeCallbacksAndMessages(null);
        int i = 0;
        int j = e.this.lD.size();
        if (i < j) {
          if (paramAnonymoush != ((e.a)e.this.lD.get(i)).gU) {}
        }
        for (;;)
        {
          if (i == -1)
          {
            AppMethodBeat.o(239170);
            return;
            i += 1;
            break;
          }
          i += 1;
          if (i < e.this.lD.size()) {}
          for (final e.a locala = (e.a)e.this.lD.get(i);; locala = null)
          {
            paramAnonymousMenuItem = new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(239156);
                if (locala != null)
                {
                  e.this.lU = true;
                  locala.gU.G(false);
                  e.this.lU = false;
                }
                if ((paramAnonymousMenuItem.isEnabled()) && (paramAnonymousMenuItem.hasSubMenu())) {
                  paramAnonymoush.a(paramAnonymousMenuItem, null, 4);
                }
                AppMethodBeat.o(239156);
              }
            };
            long l = SystemClock.uptimeMillis();
            e.this.lB.postAtTime(paramAnonymousMenuItem, paramAnonymoush, l + 200L);
            AppMethodBeat.o(239170);
            return;
          }
          i = -1;
        }
      }
    };
    this.lH = 0;
    this.lI = 0;
    this.mContext = paramContext;
    this.lJ = paramView;
    this.ly = paramInt1;
    this.lz = paramInt2;
    this.lA = paramBoolean;
    this.lQ = false;
    this.lL = bV();
    paramContext = paramContext.getResources();
    this.lx = Math.max(paramContext.getDisplayMetrics().widthPixels / 2, paramContext.getDimensionPixelSize(a.d.abc_config_prefDialogWidth));
    this.lB = new Handler();
    AppMethodBeat.o(239184);
  }
  
  private static MenuItem a(h paramh1, h paramh2)
  {
    AppMethodBeat.i(239206);
    int j = paramh1.size();
    int i = 0;
    while (i < j)
    {
      MenuItem localMenuItem = paramh1.getItem(i);
      if ((localMenuItem.hasSubMenu()) && (paramh2 == localMenuItem.getSubMenu()))
      {
        AppMethodBeat.o(239206);
        return localMenuItem;
      }
      i += 1;
    }
    AppMethodBeat.o(239206);
    return null;
  }
  
  private static View a(a parama, h paramh)
  {
    int i = 0;
    AppMethodBeat.i(239208);
    paramh = a(parama.gU, paramh);
    if (paramh == null)
    {
      AppMethodBeat.o(239208);
      return null;
    }
    p localp = parama.ma.sY;
    parama = localp.getAdapter();
    int j;
    if ((parama instanceof HeaderViewListAdapter))
    {
      parama = (HeaderViewListAdapter)parama;
      j = parama.getHeadersCount();
      parama = (g)parama.getWrappedAdapter();
      int k = parama.getCount();
      label73:
      if (i >= k) {
        break label161;
      }
      if (paramh != parama.ai(i)) {
        break label110;
      }
    }
    for (;;)
    {
      if (i == -1)
      {
        AppMethodBeat.o(239208);
        return null;
        parama = (g)parama;
        j = 0;
        break;
        label110:
        i += 1;
        break label73;
      }
      i = i + j - localp.getFirstVisiblePosition();
      if ((i < 0) || (i >= localp.getChildCount()))
      {
        AppMethodBeat.o(239208);
        return null;
      }
      parama = localp.getChildAt(i);
      AppMethodBeat.o(239208);
      return parama;
      label161:
      i = -1;
    }
  }
  
  private int ad(int paramInt)
  {
    AppMethodBeat.i(239199);
    p localp = ((a)this.lD.get(this.lD.size() - 1)).ma.sY;
    int[] arrayOfInt = new int[2];
    localp.getLocationOnScreen(arrayOfInt);
    Rect localRect = new Rect();
    this.lK.getWindowVisibleDisplayFrame(localRect);
    if (this.lL == 1)
    {
      int i = arrayOfInt[0];
      if (localp.getWidth() + i + paramInt > localRect.right)
      {
        AppMethodBeat.o(239199);
        return 0;
      }
      AppMethodBeat.o(239199);
      return 1;
    }
    if (arrayOfInt[0] - paramInt < 0)
    {
      AppMethodBeat.o(239199);
      return 1;
    }
    AppMethodBeat.o(239199);
    return 0;
  }
  
  private t bU()
  {
    AppMethodBeat.i(239187);
    t localt = new t(this.mContext, this.ly, this.lz);
    localt.tB = this.lG;
    localt.tp = this;
    localt.setOnDismissListener(this);
    localt.tl = this.lJ;
    localt.lI = this.lI;
    localt.P(true);
    localt.dN();
    AppMethodBeat.o(239187);
    return localt;
  }
  
  private int bV()
  {
    AppMethodBeat.i(239197);
    if (w.I(this.lJ) == 1)
    {
      AppMethodBeat.o(239197);
      return 0;
    }
    AppMethodBeat.o(239197);
    return 1;
  }
  
  private void f(h paramh)
  {
    AppMethodBeat.i(239205);
    Object localObject3 = LayoutInflater.from(this.mContext);
    Object localObject1 = new g(paramh, (LayoutInflater)localObject3, this.lA, lw);
    int m;
    t localt;
    Object localObject2;
    label144:
    int j;
    int i;
    label173:
    int k;
    if ((!isShowing()) && (this.lQ))
    {
      ((g)localObject1).lQ = true;
      m = a((ListAdapter)localObject1, null, this.mContext, this.lx);
      localt = bU();
      localt.setAdapter((ListAdapter)localObject1);
      localt.setContentWidth(m);
      localt.lI = this.lI;
      if (this.lD.size() <= 0) {
        break label384;
      }
      localObject1 = (a)this.lD.get(this.lD.size() - 1);
      localObject2 = a((a)localObject1, paramh);
      if (localObject2 == null) {
        break label526;
      }
      localt.dS();
      localt.dR();
      j = ad(m);
      if (j != 1) {
        break label393;
      }
      i = 1;
      this.lL = j;
      if (Build.VERSION.SDK_INT < 26) {
        break label398;
      }
      localt.tl = ((View)localObject2);
      j = 0;
      k = 0;
      label198:
      if ((this.lI & 0x5) != 5) {
        break label501;
      }
      if (i == 0) {
        break label489;
      }
      i = k + m;
      label218:
      localt.ta = i;
      localt.dQ();
      localt.ah(j);
    }
    for (;;)
    {
      localObject2 = new a(localt, paramh, this.lL);
      this.lD.add(localObject2);
      localt.show();
      localObject2 = localt.sY;
      ((ListView)localObject2).setOnKeyListener(this);
      if ((localObject1 == null) && (this.eX) && (paramh.mJ != null))
      {
        localObject1 = (FrameLayout)((LayoutInflater)localObject3).inflate(a.g.abc_popup_menu_header_item_layout, (ViewGroup)localObject2, false);
        localObject3 = (TextView)((FrameLayout)localObject1).findViewById(16908310);
        ((FrameLayout)localObject1).setEnabled(false);
        ((TextView)localObject3).setText(paramh.mJ);
        ((ListView)localObject2).addHeaderView((View)localObject1, null, false);
        localt.show();
      }
      AppMethodBeat.o(239205);
      return;
      if (!isShowing()) {
        break;
      }
      ((g)localObject1).lQ = m.h(paramh);
      break;
      label384:
      localObject2 = null;
      localObject1 = null;
      break label144;
      label393:
      i = 0;
      break label173;
      label398:
      int[] arrayOfInt1 = new int[2];
      this.lJ.getLocationOnScreen(arrayOfInt1);
      int[] arrayOfInt2 = new int[2];
      ((View)localObject2).getLocationOnScreen(arrayOfInt2);
      if ((this.lI & 0x7) == 5)
      {
        arrayOfInt1[0] += this.lJ.getWidth();
        arrayOfInt2[0] += ((View)localObject2).getWidth();
      }
      k = arrayOfInt2[0] - arrayOfInt1[0];
      j = arrayOfInt2[1] - arrayOfInt1[1];
      break label198;
      label489:
      i = k - ((View)localObject2).getWidth();
      break label218;
      label501:
      if (i != 0)
      {
        i = ((View)localObject2).getWidth() + k;
        break label218;
      }
      i = k - m;
      break label218;
      label526:
      if (this.lM) {
        localt.ta = this.lO;
      }
      if (this.lN) {
        localt.ah(this.lP);
      }
      localt.nq = this.nq;
    }
  }
  
  public final void F(boolean paramBoolean)
  {
    AppMethodBeat.i(239212);
    Iterator localIterator = this.lD.iterator();
    while (localIterator.hasNext()) {
      a(((a)localIterator.next()).ma.sY.getAdapter()).notifyDataSetChanged();
    }
    AppMethodBeat.o(239212);
  }
  
  public final void a(h paramh, boolean paramBoolean)
  {
    AppMethodBeat.i(239216);
    int j = this.lD.size();
    int i = 0;
    if (i < j) {
      if (paramh != ((a)this.lD.get(i)).gU) {}
    }
    for (;;)
    {
      if (i >= 0) {
        break label68;
      }
      AppMethodBeat.o(239216);
      return;
      i += 1;
      break;
      i = -1;
    }
    label68:
    j = i + 1;
    if (j < this.lD.size()) {
      ((a)this.lD.get(j)).gU.G(false);
    }
    a locala = (a)this.lD.remove(i);
    locala.gU.b(this);
    if (this.lU)
    {
      t localt = locala.ma;
      if (Build.VERSION.SDK_INT >= 23) {
        localt.ty.setExitTransition(null);
      }
      locala.ma.ax(0);
    }
    locala.ma.dismiss();
    i = this.lD.size();
    if (i > 0) {}
    for (this.lL = ((a)this.lD.get(i - 1)).position; i == 0; this.lL = bV())
    {
      dismiss();
      if (this.lR != null) {
        this.lR.a(paramh, true);
      }
      if (this.lS != null)
      {
        if (this.lS.isAlive()) {
          this.lS.removeGlobalOnLayoutListener(this.lE);
        }
        this.lS = null;
      }
      this.lK.removeOnAttachStateChangeListener(this.lF);
      this.lT.onDismiss();
      AppMethodBeat.o(239216);
      return;
    }
    if (paramBoolean) {
      ((a)this.lD.get(0)).gU.G(false);
    }
    AppMethodBeat.o(239216);
  }
  
  public final boolean a(u paramu)
  {
    AppMethodBeat.i(239214);
    Iterator localIterator = this.lD.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (paramu == locala.gU)
      {
        locala.ma.sY.requestFocus();
        AppMethodBeat.o(239214);
        return true;
      }
    }
    if (paramu.hasVisibleItems())
    {
      e(paramu);
      if (this.lR != null) {
        this.lR.c(paramu);
      }
      AppMethodBeat.o(239214);
      return true;
    }
    AppMethodBeat.o(239214);
    return false;
  }
  
  public final void ag(int paramInt)
  {
    this.lM = true;
    this.lO = paramInt;
  }
  
  public final void ah(int paramInt)
  {
    this.lN = true;
    this.lP = paramInt;
  }
  
  public final void b(o.a parama)
  {
    this.lR = parama;
  }
  
  public final boolean bS()
  {
    return false;
  }
  
  protected final boolean bW()
  {
    return false;
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(239192);
    int i = this.lD.size();
    if (i > 0)
    {
      a[] arrayOfa = (a[])this.lD.toArray(new a[i]);
      i -= 1;
      while (i >= 0)
      {
        a locala = arrayOfa[i];
        if (locala.ma.ty.isShowing()) {
          locala.ma.dismiss();
        }
        i -= 1;
      }
    }
    AppMethodBeat.o(239192);
  }
  
  public final void e(h paramh)
  {
    AppMethodBeat.i(239200);
    paramh.a(this, this.mContext);
    if (isShowing())
    {
      f(paramh);
      AppMethodBeat.o(239200);
      return;
    }
    this.lC.add(paramh);
    AppMethodBeat.o(239200);
  }
  
  public final ListView getListView()
  {
    AppMethodBeat.i(239222);
    if (this.lD.isEmpty())
    {
      AppMethodBeat.o(239222);
      return null;
    }
    p localp = ((a)this.lD.get(this.lD.size() - 1)).ma.sY;
    AppMethodBeat.o(239222);
    return localp;
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(239209);
    if ((this.lD.size() > 0) && (((a)this.lD.get(0)).ma.ty.isShowing()))
    {
      AppMethodBeat.o(239209);
      return true;
    }
    AppMethodBeat.o(239209);
    return false;
  }
  
  public final void onDismiss()
  {
    AppMethodBeat.i(239210);
    int j = this.lD.size();
    int i = 0;
    a locala;
    if (i < j)
    {
      locala = (a)this.lD.get(i);
      if (locala.ma.ty.isShowing()) {}
    }
    for (;;)
    {
      if (locala != null) {
        locala.gU.G(false);
      }
      AppMethodBeat.o(239210);
      return;
      i += 1;
      break;
      locala = null;
    }
  }
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(239195);
    if ((paramKeyEvent.getAction() == 1) && (paramInt == 82))
    {
      dismiss();
      AppMethodBeat.o(239195);
      return true;
    }
    AppMethodBeat.o(239195);
    return false;
  }
  
  public final void onRestoreInstanceState(Parcelable paramParcelable) {}
  
  public final Parcelable onSaveInstanceState()
  {
    return null;
  }
  
  public final void setAnchorView(View paramView)
  {
    AppMethodBeat.i(239219);
    if (this.lJ != paramView)
    {
      this.lJ = paramView;
      this.lI = androidx.core.g.e.D(this.lH, w.I(this.lJ));
    }
    AppMethodBeat.o(239219);
  }
  
  public final void setForceShowIcon(boolean paramBoolean)
  {
    this.lQ = paramBoolean;
  }
  
  public final void setGravity(int paramInt)
  {
    AppMethodBeat.i(239218);
    if (this.lH != paramInt)
    {
      this.lH = paramInt;
      this.lI = androidx.core.g.e.D(paramInt, w.I(this.lJ));
    }
    AppMethodBeat.o(239218);
  }
  
  public final void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.lT = paramOnDismissListener;
  }
  
  public final void setShowTitle(boolean paramBoolean)
  {
    this.eX = paramBoolean;
  }
  
  public final void show()
  {
    AppMethodBeat.i(239189);
    if (isShowing())
    {
      AppMethodBeat.o(239189);
      return;
    }
    Iterator localIterator = this.lC.iterator();
    while (localIterator.hasNext()) {
      f((h)localIterator.next());
    }
    this.lC.clear();
    this.lK = this.lJ;
    if (this.lK != null) {
      if (this.lS != null) {
        break label132;
      }
    }
    label132:
    for (int i = 1;; i = 0)
    {
      this.lS = this.lK.getViewTreeObserver();
      if (i != 0) {
        this.lS.addOnGlobalLayoutListener(this.lE);
      }
      this.lK.addOnAttachStateChangeListener(this.lF);
      AppMethodBeat.o(239189);
      return;
    }
  }
  
  static final class a
  {
    public final h gU;
    public final t ma;
    public final int position;
    
    public a(t paramt, h paramh, int paramInt)
    {
      this.ma = paramt;
      this.gU = paramh;
      this.position = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.view.menu.e
 * JD-Core Version:    0.7.0.1
 */