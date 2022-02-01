package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.h.a;
import android.support.v7.view.menu.h.b;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.o.a;
import android.support.v7.view.menu.p;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;

public class ActionMenuView
  extends LinearLayoutCompat
  implements h.b, p
{
  h XT;
  private Context aet;
  private int afF;
  private int afU;
  ActionMenuPresenter afV;
  private o.a afW;
  h.a afX;
  private boolean afY;
  private int afZ;
  boolean afw;
  private int aga;
  d agb;
  
  public ActionMenuView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setBaselineAligned(false);
    float f = paramContext.getResources().getDisplayMetrics().density;
    this.afF = ((int)(56.0F * f));
    this.aga = ((int)(f * 4.0F));
    this.aet = paramContext;
    this.afU = 0;
  }
  
  protected static LayoutParams b(ViewGroup.LayoutParams paramLayoutParams)
  {
    if (paramLayoutParams != null)
    {
      if ((paramLayoutParams instanceof LayoutParams)) {}
      for (paramLayoutParams = new LayoutParams((LayoutParams)paramLayoutParams);; paramLayoutParams = new LayoutParams(paramLayoutParams))
      {
        if (paramLayoutParams.gravity <= 0) {
          paramLayoutParams.gravity = 16;
        }
        return paramLayoutParams;
      }
    }
    return ia();
  }
  
  private boolean bw(int paramInt)
  {
    boolean bool2 = false;
    if (paramInt == 0) {
      return false;
    }
    View localView1 = getChildAt(paramInt - 1);
    View localView2 = getChildAt(paramInt);
    boolean bool1 = bool2;
    if (paramInt < getChildCount())
    {
      bool1 = bool2;
      if ((localView1 instanceof a)) {
        bool1 = ((a)localView1).hg() | false;
      }
    }
    if ((paramInt > 0) && ((localView2 instanceof a))) {
      return ((a)localView2).hf() | bool1;
    }
    return bool1;
  }
  
  private LayoutParams e(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  static int f(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool2 = false;
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int i = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt3) - paramInt4, View.MeasureSpec.getMode(paramInt3));
    ActionMenuItemView localActionMenuItemView;
    if ((paramView instanceof ActionMenuItemView))
    {
      localActionMenuItemView = (ActionMenuItemView)paramView;
      if ((localActionMenuItemView == null) || (!localActionMenuItemView.hasText())) {
        break label184;
      }
      paramInt4 = 1;
      label57:
      if ((paramInt2 <= 0) || ((paramInt4 != 0) && (paramInt2 < 2))) {
        break label190;
      }
      paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt1 * paramInt2, -2147483648), i);
      int j = paramView.getMeasuredWidth();
      paramInt3 = j / paramInt1;
      paramInt2 = paramInt3;
      if (j % paramInt1 != 0) {
        paramInt2 = paramInt3 + 1;
      }
      paramInt3 = paramInt2;
      if (paramInt4 != 0)
      {
        paramInt3 = paramInt2;
        if (paramInt2 >= 2) {}
      }
    }
    label184:
    label190:
    for (paramInt3 = 2;; paramInt3 = 0)
    {
      boolean bool1 = bool2;
      if (!localLayoutParams.agc)
      {
        bool1 = bool2;
        if (paramInt4 != 0) {
          bool1 = true;
        }
      }
      localLayoutParams.agf = bool1;
      localLayoutParams.agd = paramInt3;
      paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt3 * paramInt1, 1073741824), i);
      return paramInt3;
      localActionMenuItemView = null;
      break;
      paramInt4 = 0;
      break label57;
    }
  }
  
  private static LayoutParams ia()
  {
    LayoutParams localLayoutParams = new LayoutParams();
    localLayoutParams.gravity = 16;
    return localLayoutParams;
  }
  
  public static LayoutParams ib()
  {
    LayoutParams localLayoutParams = ia();
    localLayoutParams.agc = true;
    return localLayoutParams;
  }
  
  public final void a(h paramh)
  {
    this.XT = paramh;
  }
  
  public final void a(o.a parama, h.a parama1)
  {
    this.afW = parama;
    this.afX = parama1;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return (paramLayoutParams != null) && ((paramLayoutParams instanceof LayoutParams));
  }
  
  public final void dismissPopupMenus()
  {
    if (this.afV != null) {
      this.afV.hX();
    }
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    return false;
  }
  
  public final boolean f(j paramj)
  {
    return this.XT.a(paramj, null, 0);
  }
  
  public Menu getMenu()
  {
    ActionMenuPresenter localActionMenuPresenter;
    if (this.XT == null)
    {
      localObject = getContext();
      this.XT = new h((Context)localObject);
      this.XT.a(new c());
      this.afV = new ActionMenuPresenter((Context)localObject);
      this.afV.hW();
      localActionMenuPresenter = this.afV;
      if (this.afW == null) {
        break label108;
      }
    }
    label108:
    for (Object localObject = this.afW;; localObject = new b())
    {
      localActionMenuPresenter.aci = ((o.a)localObject);
      this.XT.a(this.afV, this.aet);
      this.afV.a(this);
      return this.XT;
    }
  }
  
  public Drawable getOverflowIcon()
  {
    getMenu();
    ActionMenuPresenter localActionMenuPresenter = this.afV;
    if (localActionMenuPresenter.aft != null) {
      return localActionMenuPresenter.aft.getDrawable();
    }
    if (localActionMenuPresenter.afv) {
      return localActionMenuPresenter.afu;
    }
    return null;
  }
  
  public int getPopupTheme()
  {
    return this.afU;
  }
  
  public int getWindowAnimations()
  {
    return 0;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.afV != null)
    {
      this.afV.p(false);
      if (this.afV.isOverflowMenuShowing())
      {
        this.afV.hideOverflowMenu();
        this.afV.showOverflowMenu();
      }
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    dismissPopupMenus();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!this.afY)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    int i1 = getChildCount();
    int n = (paramInt4 - paramInt2) / 2;
    int i2 = getDividerWidth();
    int i = 0;
    paramInt4 = paramInt3 - paramInt1 - getPaddingRight() - getPaddingLeft();
    paramInt2 = 0;
    paramBoolean = bh.d(this);
    int j = 0;
    label68:
    View localView;
    LayoutParams localLayoutParams;
    int k;
    int m;
    if (j < i1)
    {
      localView = getChildAt(j);
      if (localView.getVisibility() == 8) {
        break label636;
      }
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if (localLayoutParams.agc)
      {
        k = localView.getMeasuredWidth();
        paramInt2 = k;
        if (bw(j)) {
          paramInt2 = k + i2;
        }
        int i3 = localView.getMeasuredHeight();
        if (paramBoolean)
        {
          m = getPaddingLeft() + localLayoutParams.leftMargin;
          k = m + paramInt2;
          label165:
          int i4 = n - i3 / 2;
          localView.layout(m, i4, k, i3 + i4);
          k = 1;
          paramInt4 -= paramInt2;
          paramInt2 = k;
        }
      }
    }
    label356:
    label370:
    label630:
    label633:
    label636:
    for (;;)
    {
      j += 1;
      break label68;
      k = getWidth() - getPaddingRight() - localLayoutParams.rightMargin;
      m = k - paramInt2;
      break label165;
      k = localView.getMeasuredWidth();
      m = localLayoutParams.leftMargin;
      paramInt4 -= localLayoutParams.rightMargin + (k + m);
      bw(j);
      i += 1;
      continue;
      if ((i1 == 1) && (paramInt2 == 0))
      {
        localView = getChildAt(0);
        paramInt2 = localView.getMeasuredWidth();
        paramInt4 = localView.getMeasuredHeight();
        paramInt1 = (paramInt3 - paramInt1) / 2 - paramInt2 / 2;
        paramInt3 = n - paramInt4 / 2;
        localView.layout(paramInt1, paramInt3, paramInt2 + paramInt1, paramInt4 + paramInt3);
        return;
      }
      if (paramInt2 != 0)
      {
        paramInt1 = 0;
        paramInt1 = i - paramInt1;
        if (paramInt1 <= 0) {
          break label508;
        }
        paramInt1 = paramInt4 / paramInt1;
        paramInt3 = Math.max(0, paramInt1);
        if (!paramBoolean) {
          break label513;
        }
        paramInt1 = getWidth() - getPaddingRight();
        paramInt2 = 0;
        if (paramInt2 < i1)
        {
          localView = getChildAt(paramInt2);
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          if ((localView.getVisibility() == 8) || (localLayoutParams.agc)) {
            break label633;
          }
          paramInt1 -= localLayoutParams.rightMargin;
          paramInt4 = localView.getMeasuredWidth();
          i = localView.getMeasuredHeight();
          j = n - i / 2;
          localView.layout(paramInt1 - paramInt4, j, paramInt1, i + j);
          paramInt1 -= localLayoutParams.leftMargin + paramInt4 + paramInt3;
        }
      }
      for (;;)
      {
        paramInt2 += 1;
        break label393;
        break;
        paramInt1 = 1;
        break label356;
        label508:
        paramInt1 = 0;
        break label370;
        paramInt1 = getPaddingLeft();
        paramInt2 = 0;
        if (paramInt2 < i1)
        {
          localView = getChildAt(paramInt2);
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          if ((localView.getVisibility() == 8) || (localLayoutParams.agc)) {
            break label630;
          }
          paramInt1 += localLayoutParams.leftMargin;
          paramInt4 = localView.getMeasuredWidth();
          i = localView.getMeasuredHeight();
          j = n - i / 2;
          localView.layout(paramInt1, j, paramInt1 + paramInt4, i + j);
          paramInt1 = localLayoutParams.rightMargin + paramInt4 + paramInt3 + paramInt1;
        }
        for (;;)
        {
          paramInt2 += 1;
          break label520;
          break;
        }
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    boolean bool2 = this.afY;
    if (View.MeasureSpec.getMode(paramInt1) == 1073741824) {}
    int i;
    int i6;
    int i5;
    int i3;
    int i7;
    int i8;
    for (boolean bool1 = true;; bool1 = false)
    {
      this.afY = bool1;
      if (bool2 != this.afY) {
        this.afZ = 0;
      }
      i = View.MeasureSpec.getSize(paramInt1);
      if ((this.afY) && (this.XT != null) && (i != this.afZ))
      {
        this.afZ = i;
        this.XT.r(true);
      }
      j = getChildCount();
      if ((!this.afY) || (j <= 0)) {
        break label1234;
      }
      i6 = View.MeasureSpec.getMode(paramInt2);
      paramInt1 = View.MeasureSpec.getSize(paramInt1);
      i5 = View.MeasureSpec.getSize(paramInt2);
      i = getPaddingLeft();
      j = getPaddingRight();
      i3 = getPaddingTop() + getPaddingBottom();
      i7 = getChildMeasureSpec(paramInt2, i3, -2);
      i8 = paramInt1 - (i + j);
      paramInt1 = i8 / this.afF;
      paramInt2 = this.afF;
      if (paramInt1 != 0) {
        break;
      }
      setMeasuredDimension(i8, 0);
      return;
    }
    int i9 = this.afF + i8 % paramInt2 / paramInt1;
    int j = 0;
    int i1 = 0;
    int k = 0;
    int m = 0;
    paramInt2 = 0;
    long l1 = 0L;
    int i10 = getChildCount();
    int n = 0;
    Object localObject;
    LayoutParams localLayoutParams;
    label351:
    label369:
    int i4;
    label407:
    label417:
    int i2;
    if (n < i10)
    {
      localObject = getChildAt(n);
      if (((View)localObject).getVisibility() == 8) {
        break label1329;
      }
      bool1 = localObject instanceof ActionMenuItemView;
      m += 1;
      if (bool1) {
        ((View)localObject).setPadding(this.aga, 0, this.aga, 0);
      }
      localLayoutParams = (LayoutParams)((View)localObject).getLayoutParams();
      localLayoutParams.gX = false;
      localLayoutParams.age = 0;
      localLayoutParams.agd = 0;
      localLayoutParams.agf = false;
      localLayoutParams.leftMargin = 0;
      localLayoutParams.rightMargin = 0;
      if ((bool1) && (((ActionMenuItemView)localObject).hasText()))
      {
        bool1 = true;
        localLayoutParams.agg = bool1;
        if (!localLayoutParams.agc) {
          break label483;
        }
        i = 1;
        i4 = f((View)localObject, i9, i, i7, i3);
        i1 = Math.max(i1, i4);
        if (!localLayoutParams.agf) {
          break label1322;
        }
        i = k + 1;
        if (!localLayoutParams.agc) {
          break label1319;
        }
        paramInt2 = 1;
        i2 = paramInt1 - i4;
        j = Math.max(j, ((View)localObject).getMeasuredHeight());
        if (i4 != 1) {
          break label1305;
        }
        l1 = 1 << n | l1;
        k = i;
        i = i2;
        paramInt1 = m;
      }
    }
    for (;;)
    {
      n += 1;
      m = paramInt1;
      paramInt1 = i;
      break;
      bool1 = false;
      break label351;
      label483:
      i = paramInt1;
      break label369;
      long l3;
      long l2;
      if ((paramInt2 != 0) && (m == 2))
      {
        i2 = 1;
        i = 0;
        n = paramInt1;
        paramInt1 = i;
        l3 = l1;
        if (k <= 0) {
          break label807;
        }
        l3 = l1;
        if (n <= 0) {
          break label807;
        }
        i3 = 2147483647;
        l2 = 0L;
        i = 0;
        i4 = 0;
        label543:
        if (i4 >= i10) {
          break label641;
        }
        localObject = (LayoutParams)getChildAt(i4).getLayoutParams();
        if (!((LayoutParams)localObject).agf) {
          break label1302;
        }
        if (((LayoutParams)localObject).agd >= i3) {
          break label613;
        }
        i3 = ((LayoutParams)localObject).agd;
        l2 = 1L << i4;
        i = 1;
      }
      label641:
      label665:
      label807:
      label968:
      label971:
      label1234:
      for (;;)
      {
        i4 += 1;
        break label543;
        i2 = 0;
        break;
        label613:
        if (((LayoutParams)localObject).agd == i3)
        {
          l2 |= 1L << i4;
          i += 1;
          continue;
          l1 |= l2;
          l3 = l1;
          if (i <= n)
          {
            i = 0;
            paramInt1 = n;
            if (i < i10)
            {
              localObject = getChildAt(i);
              localLayoutParams = (LayoutParams)((View)localObject).getLayoutParams();
              if ((1 << i & l2) == 0L)
              {
                if (localLayoutParams.agd != i3 + 1) {
                  break label1299;
                }
                l1 |= 1 << i;
              }
            }
          }
          for (;;)
          {
            i += 1;
            break label665;
            if ((i2 != 0) && (localLayoutParams.agg) && (paramInt1 == 1)) {
              ((View)localObject).setPadding(this.aga + i9, 0, this.aga, 0);
            }
            localLayoutParams.agd += 1;
            localLayoutParams.gX = true;
            paramInt1 -= 1;
            continue;
            i = 1;
            n = paramInt1;
            paramInt1 = i;
            break;
            float f2;
            float f1;
            if ((paramInt2 == 0) && (m == 1))
            {
              paramInt2 = 1;
              if ((n <= 0) || (l3 == 0L) || ((n >= m - 1) && (paramInt2 == 0) && (i1 <= 1))) {
                break label1142;
              }
              float f3 = Long.bitCount(l3);
              f2 = f3;
              if (paramInt2 != 0) {
                break label1293;
              }
              f1 = f3;
              if ((1L & l3) != 0L)
              {
                f1 = f3;
                if (!((LayoutParams)getChildAt(0).getLayoutParams()).agg) {
                  f1 = f3 - 0.5F;
                }
              }
              f2 = f1;
              if ((1 << i10 - 1 & l3) == 0L) {
                break label1293;
              }
              f2 = f1;
              if (((LayoutParams)getChildAt(i10 - 1).getLayoutParams()).agg) {
                break label1293;
              }
            }
            for (f1 -= 0.5F;; f1 = f2)
            {
              if (f1 > 0.0F)
              {
                paramInt2 = (int)(n * i9 / f1);
                i = 0;
                k = paramInt1;
                if (i >= i10) {
                  break label1145;
                }
                if ((1 << i & l3) == 0L) {
                  break label1139;
                }
                localObject = getChildAt(i);
                localLayoutParams = (LayoutParams)((View)localObject).getLayoutParams();
                if (!(localObject instanceof ActionMenuItemView)) {
                  break label1075;
                }
                localLayoutParams.age = paramInt2;
                localLayoutParams.gX = true;
                if ((i == 0) && (!localLayoutParams.agg)) {
                  localLayoutParams.leftMargin = (-paramInt2 / 2);
                }
                paramInt1 = 1;
              }
              label1139:
              for (;;)
              {
                i += 1;
                break label971;
                paramInt2 = 0;
                break;
                paramInt2 = 0;
                break label968;
                if (localLayoutParams.agc)
                {
                  localLayoutParams.age = paramInt2;
                  localLayoutParams.gX = true;
                  localLayoutParams.rightMargin = (-paramInt2 / 2);
                  paramInt1 = 1;
                }
                else
                {
                  if (i != 0) {
                    localLayoutParams.leftMargin = (paramInt2 / 2);
                  }
                  if (i != i10 - 1) {
                    localLayoutParams.rightMargin = (paramInt2 / 2);
                  }
                }
              }
              label1142:
              k = paramInt1;
              label1145:
              if (k != 0)
              {
                paramInt1 = 0;
                while (paramInt1 < i10)
                {
                  localObject = getChildAt(paramInt1);
                  localLayoutParams = (LayoutParams)((View)localObject).getLayoutParams();
                  if (localLayoutParams.gX)
                  {
                    paramInt2 = localLayoutParams.agd;
                    ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(localLayoutParams.age + paramInt2 * i9, 1073741824), i7);
                  }
                  paramInt1 += 1;
                }
              }
              if (i6 != 1073741824) {}
              for (;;)
              {
                setMeasuredDimension(i8, j);
                return;
                i = 0;
                while (i < j)
                {
                  localObject = (LayoutParams)getChildAt(i).getLayoutParams();
                  ((LayoutParams)localObject).rightMargin = 0;
                  ((LayoutParams)localObject).leftMargin = 0;
                  i += 1;
                }
                super.onMeasure(paramInt1, paramInt2);
                return;
                j = i5;
              }
            }
          }
        }
      }
      label1075:
      k = i;
      label1293:
      label1299:
      label1302:
      label1305:
      paramInt1 = m;
      i = i2;
      continue;
      label1319:
      break label417;
      label1322:
      i = k;
      break label407;
      label1329:
      i = paramInt1;
      paramInt1 = m;
    }
  }
  
  public void setExpandedActionViewsExclusive(boolean paramBoolean)
  {
    this.afV.afE = paramBoolean;
  }
  
  public void setOnMenuItemClickListener(d paramd)
  {
    this.agb = paramd;
  }
  
  public void setOverflowIcon(Drawable paramDrawable)
  {
    getMenu();
    ActionMenuPresenter localActionMenuPresenter = this.afV;
    if (localActionMenuPresenter.aft != null)
    {
      localActionMenuPresenter.aft.setImageDrawable(paramDrawable);
      return;
    }
    localActionMenuPresenter.afv = true;
    localActionMenuPresenter.afu = paramDrawable;
  }
  
  public void setOverflowReserved(boolean paramBoolean)
  {
    this.afw = paramBoolean;
  }
  
  public void setPopupTheme(int paramInt)
  {
    if (this.afU != paramInt)
    {
      this.afU = paramInt;
      if (paramInt == 0) {
        this.aet = getContext();
      }
    }
    else
    {
      return;
    }
    this.aet = new ContextThemeWrapper(getContext(), paramInt);
  }
  
  public void setPresenter(ActionMenuPresenter paramActionMenuPresenter)
  {
    this.afV = paramActionMenuPresenter;
    this.afV.a(this);
  }
  
  public static class LayoutParams
    extends LinearLayoutCompat.LayoutParams
  {
    @ViewDebug.ExportedProperty
    public boolean agc;
    @ViewDebug.ExportedProperty
    public int agd;
    @ViewDebug.ExportedProperty
    public int age;
    @ViewDebug.ExportedProperty
    public boolean agf;
    @ViewDebug.ExportedProperty
    public boolean agg;
    boolean gX;
    
    public LayoutParams()
    {
      super(-2);
      this.agc = false;
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      this.agc = paramLayoutParams.agc;
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean hf();
    
    public abstract boolean hg();
  }
  
  static final class b
    implements o.a
  {
    public final void a(h paramh, boolean paramBoolean) {}
    
    public final boolean d(h paramh)
    {
      return false;
    }
  }
  
  final class c
    implements h.a
  {
    c() {}
    
    public final boolean a(h paramh, MenuItem paramMenuItem)
    {
      return (ActionMenuView.this.agb != null) && (ActionMenuView.this.agb.onMenuItemClick(paramMenuItem));
    }
    
    public final void b(h paramh)
    {
      if (ActionMenuView.this.afX != null) {
        ActionMenuView.this.afX.b(paramh);
      }
    }
  }
  
  public static abstract interface d
  {
    public abstract boolean onMenuItemClick(MenuItem paramMenuItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.ActionMenuView
 * JD-Core Version:    0.7.0.1
 */