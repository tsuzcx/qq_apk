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
import androidx.core.g.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class e
  extends m
  implements View.OnKeyListener, PopupWindow.OnDismissListener
{
  private static final int ms = a.g.abc_cascading_menu_item_layout;
  private boolean fZ;
  final ViewTreeObserver.OnGlobalLayoutListener mA;
  private final View.OnAttachStateChangeListener mB;
  private final s mC;
  private final Context mContext;
  private int mD;
  private int mE;
  private View mF;
  View mG;
  private int mI;
  private boolean mJ;
  private boolean mK;
  private int mL;
  private int mM;
  private boolean mN;
  private o.a mO;
  ViewTreeObserver mP;
  private PopupWindow.OnDismissListener mQ;
  boolean mR;
  private final int mt;
  private final int mu;
  private final int mv;
  private final boolean mw;
  final Handler mx;
  private final List<h> my;
  final List<a> mz;
  
  public e(Context paramContext, View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(200959);
    this.my = new ArrayList();
    this.mz = new ArrayList();
    this.mA = new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(200998);
        if ((e.this.isShowing()) && (e.this.mz.size() > 0) && (!((e.a)e.this.mz.get(0)).mZ.uw))
        {
          Object localObject = e.this.mG;
          if ((localObject == null) || (!((View)localObject).isShown()))
          {
            e.this.dismiss();
            AppMethodBeat.o(200998);
            return;
          }
          localObject = e.this.mz.iterator();
          while (((Iterator)localObject).hasNext()) {
            ((e.a)((Iterator)localObject).next()).mZ.show();
          }
        }
        AppMethodBeat.o(200998);
      }
    };
    this.mB = new View.OnAttachStateChangeListener()
    {
      public final void onViewAttachedToWindow(View paramAnonymousView) {}
      
      public final void onViewDetachedFromWindow(View paramAnonymousView)
      {
        AppMethodBeat.i(200923);
        if (e.this.mP != null)
        {
          if (!e.this.mP.isAlive()) {
            e.this.mP = paramAnonymousView.getViewTreeObserver();
          }
          e.this.mP.removeGlobalOnLayoutListener(e.this.mA);
        }
        paramAnonymousView.removeOnAttachStateChangeListener(this);
        AppMethodBeat.o(200923);
      }
    };
    this.mC = new s()
    {
      public final void b(h paramAnonymoush, MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(200926);
        e.this.mx.removeCallbacksAndMessages(paramAnonymoush);
        AppMethodBeat.o(200926);
      }
      
      public final void c(final h paramAnonymoush, final MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(200938);
        e.this.mx.removeCallbacksAndMessages(null);
        int i = 0;
        int j = e.this.mz.size();
        if (i < j) {
          if (paramAnonymoush != ((e.a)e.this.mz.get(i)).hP) {}
        }
        for (;;)
        {
          if (i == -1)
          {
            AppMethodBeat.o(200938);
            return;
            i += 1;
            break;
          }
          i += 1;
          if (i < e.this.mz.size()) {}
          for (final e.a locala = (e.a)e.this.mz.get(i);; locala = null)
          {
            paramAnonymousMenuItem = new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(200873);
                if (locala != null)
                {
                  e.this.mR = true;
                  locala.hP.K(false);
                  e.this.mR = false;
                }
                if ((paramAnonymousMenuItem.isEnabled()) && (paramAnonymousMenuItem.hasSubMenu())) {
                  paramAnonymoush.a(paramAnonymousMenuItem, null, 4);
                }
                AppMethodBeat.o(200873);
              }
            };
            long l = SystemClock.uptimeMillis();
            e.this.mx.postAtTime(paramAnonymousMenuItem, paramAnonymoush, l + 200L);
            AppMethodBeat.o(200938);
            return;
          }
          i = -1;
        }
      }
    };
    this.mD = 0;
    this.mE = 0;
    this.mContext = paramContext;
    this.mF = paramView;
    this.mu = paramInt1;
    this.mv = paramInt2;
    this.mw = paramBoolean;
    this.mN = false;
    this.mI = cO();
    paramContext = paramContext.getResources();
    this.mt = Math.max(paramContext.getDisplayMetrics().widthPixels / 2, paramContext.getDimensionPixelSize(a.d.abc_config_prefDialogWidth));
    this.mx = new Handler();
    AppMethodBeat.o(200959);
  }
  
  private static MenuItem a(h paramh1, h paramh2)
  {
    AppMethodBeat.i(201064);
    int j = paramh1.size();
    int i = 0;
    while (i < j)
    {
      MenuItem localMenuItem = paramh1.getItem(i);
      if ((localMenuItem.hasSubMenu()) && (paramh2 == localMenuItem.getSubMenu()))
      {
        AppMethodBeat.o(201064);
        return localMenuItem;
      }
      i += 1;
    }
    AppMethodBeat.o(201064);
    return null;
  }
  
  private static View a(a parama, h paramh)
  {
    int i = 0;
    AppMethodBeat.i(201074);
    paramh = a(parama.hP, paramh);
    if (paramh == null)
    {
      AppMethodBeat.o(201074);
      return null;
    }
    p localp = parama.mZ.tX;
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
      if (paramh != parama.ag(i)) {
        break label110;
      }
    }
    for (;;)
    {
      if (i == -1)
      {
        AppMethodBeat.o(201074);
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
        AppMethodBeat.o(201074);
        return null;
      }
      parama = localp.getChildAt(i);
      AppMethodBeat.o(201074);
      return parama;
      label161:
      i = -1;
    }
  }
  
  private int ab(int paramInt)
  {
    AppMethodBeat.i(201024);
    p localp = ((a)this.mz.get(this.mz.size() - 1)).mZ.tX;
    int[] arrayOfInt = new int[2];
    localp.getLocationOnScreen(arrayOfInt);
    Rect localRect = new Rect();
    this.mG.getWindowVisibleDisplayFrame(localRect);
    if (this.mI == 1)
    {
      int i = arrayOfInt[0];
      if (localp.getWidth() + i + paramInt > localRect.right)
      {
        AppMethodBeat.o(201024);
        return 0;
      }
      AppMethodBeat.o(201024);
      return 1;
    }
    if (arrayOfInt[0] - paramInt < 0)
    {
      AppMethodBeat.o(201024);
      return 1;
    }
    AppMethodBeat.o(201024);
    return 0;
  }
  
  private t cN()
  {
    AppMethodBeat.i(200978);
    t localt = new t(this.mContext, this.mu, this.mv);
    localt.uA = this.mC;
    localt.un = this;
    localt.setOnDismissListener(this);
    localt.ul = this.mF;
    localt.mE = this.mE;
    localt.eK();
    localt.eN();
    AppMethodBeat.o(200978);
    return localt;
  }
  
  private int cO()
  {
    AppMethodBeat.i(200991);
    if (z.U(this.mF) == 1)
    {
      AppMethodBeat.o(200991);
      return 0;
    }
    AppMethodBeat.o(200991);
    return 1;
  }
  
  private void f(h paramh)
  {
    AppMethodBeat.i(201049);
    Object localObject3 = LayoutInflater.from(this.mContext);
    Object localObject1 = new g(paramh, (LayoutInflater)localObject3, this.mw, ms);
    int m;
    t localt;
    Object localObject2;
    label144:
    int j;
    int i;
    label173:
    int k;
    if ((!isShowing()) && (this.mN))
    {
      ((g)localObject1).mN = true;
      m = a((ListAdapter)localObject1, null, this.mContext, this.mt);
      localt = cN();
      localt.setAdapter((ListAdapter)localObject1);
      localt.setContentWidth(m);
      localt.mE = this.mE;
      if (this.mz.size() <= 0) {
        break label384;
      }
      localObject1 = (a)this.mz.get(this.mz.size() - 1);
      localObject2 = a((a)localObject1, paramh);
      if (localObject2 == null) {
        break label526;
      }
      localt.eS();
      localt.eR();
      j = ab(m);
      if (j != 1) {
        break label393;
      }
      i = 1;
      this.mI = j;
      if (Build.VERSION.SDK_INT < 26) {
        break label398;
      }
      localt.ul = ((View)localObject2);
      j = 0;
      k = 0;
      label198:
      if ((this.mE & 0x5) != 5) {
        break label501;
      }
      if (i == 0) {
        break label489;
      }
      i = k + m;
      label218:
      localt.tZ = i;
      localt.eQ();
      localt.ad(j);
    }
    for (;;)
    {
      localObject2 = new a(localt, paramh, this.mI);
      this.mz.add(localObject2);
      localt.show();
      localObject2 = localt.tX;
      ((ListView)localObject2).setOnKeyListener(this);
      if ((localObject1 == null) && (this.fZ) && (paramh.nH != null))
      {
        localObject1 = (FrameLayout)((LayoutInflater)localObject3).inflate(a.g.abc_popup_menu_header_item_layout, (ViewGroup)localObject2, false);
        localObject3 = (TextView)((FrameLayout)localObject1).findViewById(16908310);
        ((FrameLayout)localObject1).setEnabled(false);
        ((TextView)localObject3).setText(paramh.nH);
        ((ListView)localObject2).addHeaderView((View)localObject1, null, false);
        localt.show();
      }
      AppMethodBeat.o(201049);
      return;
      if (!isShowing()) {
        break;
      }
      ((g)localObject1).mN = m.h(paramh);
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
      this.mF.getLocationOnScreen(arrayOfInt1);
      int[] arrayOfInt2 = new int[2];
      ((View)localObject2).getLocationOnScreen(arrayOfInt2);
      if ((this.mE & 0x7) == 5)
      {
        arrayOfInt1[0] += this.mF.getWidth();
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
      if (this.mJ) {
        localt.tZ = this.mL;
      }
      if (this.mK) {
        localt.ad(this.mM);
      }
      localt.om = this.om;
    }
  }
  
  public final void J(boolean paramBoolean)
  {
    AppMethodBeat.i(201176);
    Iterator localIterator = this.mz.iterator();
    while (localIterator.hasNext()) {
      a(((a)localIterator.next()).mZ.tX.getAdapter()).notifyDataSetChanged();
    }
    AppMethodBeat.o(201176);
  }
  
  public final void a(h paramh, boolean paramBoolean)
  {
    AppMethodBeat.i(201223);
    int j = this.mz.size();
    int i = 0;
    if (i < j) {
      if (paramh != ((a)this.mz.get(i)).hP) {}
    }
    for (;;)
    {
      if (i >= 0) {
        break label68;
      }
      AppMethodBeat.o(201223);
      return;
      i += 1;
      break;
      i = -1;
    }
    label68:
    j = i + 1;
    if (j < this.mz.size()) {
      ((a)this.mz.get(j)).hP.K(false);
    }
    a locala = (a)this.mz.remove(i);
    locala.hP.b(this);
    if (this.mR)
    {
      t localt = locala.mZ;
      if (Build.VERSION.SDK_INT >= 23) {
        localt.ux.setExitTransition(null);
      }
      locala.mZ.ux.setAnimationStyle(0);
    }
    locala.mZ.dismiss();
    i = this.mz.size();
    if (i > 0) {}
    for (this.mI = ((a)this.mz.get(i - 1)).position; i == 0; this.mI = cO())
    {
      dismiss();
      if (this.mO != null) {
        this.mO.a(paramh, true);
      }
      if (this.mP != null)
      {
        if (this.mP.isAlive()) {
          this.mP.removeGlobalOnLayoutListener(this.mA);
        }
        this.mP = null;
      }
      this.mG.removeOnAttachStateChangeListener(this.mB);
      this.mQ.onDismiss();
      AppMethodBeat.o(201223);
      return;
    }
    if (paramBoolean) {
      ((a)this.mz.get(0)).hP.K(false);
    }
    AppMethodBeat.o(201223);
  }
  
  public final boolean a(u paramu)
  {
    AppMethodBeat.i(201204);
    Iterator localIterator = this.mz.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (paramu == locala.hP)
      {
        locala.mZ.tX.requestFocus();
        AppMethodBeat.o(201204);
        return true;
      }
    }
    if (paramu.hasVisibleItems())
    {
      e(paramu);
      if (this.mO != null) {
        this.mO.c(paramu);
      }
      AppMethodBeat.o(201204);
      return true;
    }
    AppMethodBeat.o(201204);
    return false;
  }
  
  public final void ac(int paramInt)
  {
    this.mJ = true;
    this.mL = paramInt;
  }
  
  public final void ad(int paramInt)
  {
    this.mK = true;
    this.mM = paramInt;
  }
  
  public final void b(o.a parama)
  {
    this.mO = parama;
  }
  
  public final boolean cL()
  {
    return false;
  }
  
  protected final boolean cP()
  {
    return false;
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(201112);
    int i = this.mz.size();
    if (i > 0)
    {
      a[] arrayOfa = (a[])this.mz.toArray(new a[i]);
      i -= 1;
      while (i >= 0)
      {
        a locala = arrayOfa[i];
        if (locala.mZ.ux.isShowing()) {
          locala.mZ.dismiss();
        }
        i -= 1;
      }
    }
    AppMethodBeat.o(201112);
  }
  
  public final void e(h paramh)
  {
    AppMethodBeat.i(201139);
    paramh.a(this, this.mContext);
    if (isShowing())
    {
      f(paramh);
      AppMethodBeat.o(201139);
      return;
    }
    this.my.add(paramh);
    AppMethodBeat.o(201139);
  }
  
  public final ListView getListView()
  {
    AppMethodBeat.i(201315);
    if (this.mz.isEmpty())
    {
      AppMethodBeat.o(201315);
      return null;
    }
    p localp = ((a)this.mz.get(this.mz.size() - 1)).mZ.tX;
    AppMethodBeat.o(201315);
    return localp;
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(201150);
    if ((this.mz.size() > 0) && (((a)this.mz.get(0)).mZ.ux.isShowing()))
    {
      AppMethodBeat.o(201150);
      return true;
    }
    AppMethodBeat.o(201150);
    return false;
  }
  
  public final void onDismiss()
  {
    AppMethodBeat.i(201165);
    int j = this.mz.size();
    int i = 0;
    a locala;
    if (i < j)
    {
      locala = (a)this.mz.get(i);
      if (locala.mZ.ux.isShowing()) {}
    }
    for (;;)
    {
      if (locala != null) {
        locala.hP.K(false);
      }
      AppMethodBeat.o(201165);
      return;
      i += 1;
      break;
      locala = null;
    }
  }
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(201125);
    if ((paramKeyEvent.getAction() == 1) && (paramInt == 82))
    {
      dismiss();
      AppMethodBeat.o(201125);
      return true;
    }
    AppMethodBeat.o(201125);
    return false;
  }
  
  public final void onRestoreInstanceState(Parcelable paramParcelable) {}
  
  public final Parcelable onSaveInstanceState()
  {
    return null;
  }
  
  public final void setAnchorView(View paramView)
  {
    AppMethodBeat.i(201291);
    if (this.mF != paramView)
    {
      this.mF = paramView;
      this.mE = androidx.core.g.e.ay(this.mD, z.U(this.mF));
    }
    AppMethodBeat.o(201291);
  }
  
  public final void setForceShowIcon(boolean paramBoolean)
  {
    this.mN = paramBoolean;
  }
  
  public final void setGravity(int paramInt)
  {
    AppMethodBeat.i(201274);
    if (this.mD != paramInt)
    {
      this.mD = paramInt;
      this.mE = androidx.core.g.e.ay(paramInt, z.U(this.mF));
    }
    AppMethodBeat.o(201274);
  }
  
  public final void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.mQ = paramOnDismissListener;
  }
  
  public final void setShowTitle(boolean paramBoolean)
  {
    this.fZ = paramBoolean;
  }
  
  public final void show()
  {
    AppMethodBeat.i(201099);
    if (isShowing())
    {
      AppMethodBeat.o(201099);
      return;
    }
    Iterator localIterator = this.my.iterator();
    while (localIterator.hasNext()) {
      f((h)localIterator.next());
    }
    this.my.clear();
    this.mG = this.mF;
    if (this.mG != null) {
      if (this.mP != null) {
        break label132;
      }
    }
    label132:
    for (int i = 1;; i = 0)
    {
      this.mP = this.mG.getViewTreeObserver();
      if (i != 0) {
        this.mP.addOnGlobalLayoutListener(this.mA);
      }
      this.mG.addOnAttachStateChangeListener(this.mB);
      AppMethodBeat.o(201099);
      return;
    }
  }
  
  static final class a
  {
    public final h hP;
    public final t mZ;
    public final int position;
    
    public a(t paramt, h paramh, int paramInt)
    {
      this.mZ = paramt;
      this.hP = paramh;
      this.position = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.view.menu.e
 * JD-Core Version:    0.7.0.1
 */