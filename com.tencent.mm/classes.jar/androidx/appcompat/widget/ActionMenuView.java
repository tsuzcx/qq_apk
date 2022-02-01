package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
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
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.h.a;
import androidx.appcompat.view.menu.h.b;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.o.a;
import androidx.appcompat.view.menu.p;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ActionMenuView
  extends LinearLayoutCompat
  implements h.b, p
{
  h is;
  private Context nE;
  boolean oM;
  private int oV;
  private int pl;
  ActionMenuPresenter pm;
  private o.a pn;
  h.a po;
  private boolean pp;
  private int pq;
  private int pr;
  d ps;
  
  public ActionMenuView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(240406);
    setBaselineAligned(false);
    float f = paramContext.getResources().getDisplayMetrics().density;
    this.oV = ((int)(56.0F * f));
    this.pr = ((int)(f * 4.0F));
    this.nE = paramContext;
    this.pl = 0;
    AppMethodBeat.o(240406);
  }
  
  static int a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool2 = false;
    AppMethodBeat.i(240411);
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int i = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt3) - paramInt4, View.MeasureSpec.getMode(paramInt3));
    ActionMenuItemView localActionMenuItemView;
    if ((paramView instanceof ActionMenuItemView))
    {
      localActionMenuItemView = (ActionMenuItemView)paramView;
      if ((localActionMenuItemView == null) || (!localActionMenuItemView.bN())) {
        break label194;
      }
      paramInt4 = 1;
      label62:
      if ((paramInt2 <= 0) || ((paramInt4 != 0) && (paramInt2 < 2))) {
        break label200;
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
    label194:
    label200:
    for (paramInt3 = 2;; paramInt3 = 0)
    {
      boolean bool1 = bool2;
      if (!localLayoutParams.pt)
      {
        bool1 = bool2;
        if (paramInt4 != 0) {
          bool1 = true;
        }
      }
      localLayoutParams.pw = bool1;
      localLayoutParams.pu = paramInt3;
      paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt3 * paramInt1, 1073741824), i);
      AppMethodBeat.o(240411);
      return paramInt3;
      localActionMenuItemView = null;
      break;
      paramInt4 = 0;
      break label62;
    }
  }
  
  protected static LayoutParams a(ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(240418);
    if (paramLayoutParams != null)
    {
      if ((paramLayoutParams instanceof LayoutParams)) {}
      for (paramLayoutParams = new LayoutParams((LayoutParams)paramLayoutParams);; paramLayoutParams = new LayoutParams(paramLayoutParams))
      {
        if (paramLayoutParams.ek <= 0) {
          paramLayoutParams.ek = 16;
        }
        AppMethodBeat.o(240418);
        return paramLayoutParams;
      }
    }
    paramLayoutParams = cS();
    AppMethodBeat.o(240418);
    return paramLayoutParams;
  }
  
  private boolean am(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(240423);
    if (paramInt == 0)
    {
      AppMethodBeat.o(240423);
      return false;
    }
    View localView1 = getChildAt(paramInt - 1);
    View localView2 = getChildAt(paramInt);
    boolean bool1 = bool2;
    if (paramInt < getChildCount())
    {
      bool1 = bool2;
      if ((localView1 instanceof a)) {
        bool1 = ((a)localView1).bP() | false;
      }
    }
    if ((paramInt > 0) && ((localView2 instanceof a))) {
      bool1 = ((a)localView2).bO() | bool1;
    }
    for (;;)
    {
      AppMethodBeat.o(240423);
      return bool1;
    }
  }
  
  private static LayoutParams cS()
  {
    AppMethodBeat.i(240416);
    LayoutParams localLayoutParams = new LayoutParams();
    localLayoutParams.ek = 16;
    AppMethodBeat.o(240416);
    return localLayoutParams;
  }
  
  public static LayoutParams cT()
  {
    AppMethodBeat.i(240419);
    LayoutParams localLayoutParams = cS();
    localLayoutParams.pt = true;
    AppMethodBeat.o(240419);
    return localLayoutParams;
  }
  
  private LayoutParams d(AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(240417);
    paramAttributeSet = new LayoutParams(getContext(), paramAttributeSet);
    AppMethodBeat.o(240417);
    return paramAttributeSet;
  }
  
  public final void a(o.a parama, h.a parama1)
  {
    this.pn = parama;
    this.po = parama1;
  }
  
  public final void cU()
  {
    AppMethodBeat.i(240422);
    if (this.pm != null) {
      this.pm.cP();
    }
    AppMethodBeat.o(240422);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return (paramLayoutParams != null) && ((paramLayoutParams instanceof LayoutParams));
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    return false;
  }
  
  public final boolean e(j paramj)
  {
    AppMethodBeat.i(240420);
    boolean bool = this.is.a(paramj, null, 0);
    AppMethodBeat.o(240420);
    return bool;
  }
  
  public final void g(h paramh)
  {
    this.is = paramh;
  }
  
  public Menu getMenu()
  {
    AppMethodBeat.i(240421);
    ActionMenuPresenter localActionMenuPresenter;
    if (this.is == null)
    {
      localObject = getContext();
      this.is = new h((Context)localObject);
      this.is.a(new c());
      this.pm = new ActionMenuPresenter((Context)localObject);
      this.pm.cO();
      localActionMenuPresenter = this.pm;
      if (this.pn == null) {
        break label120;
      }
    }
    label120:
    for (Object localObject = this.pn;; localObject = new b())
    {
      localActionMenuPresenter.lp = ((o.a)localObject);
      this.is.a(this.pm, this.nE);
      this.pm.a(this);
      localObject = this.is;
      AppMethodBeat.o(240421);
      return localObject;
    }
  }
  
  public Drawable getOverflowIcon()
  {
    AppMethodBeat.i(240415);
    getMenu();
    Object localObject = this.pm;
    if (((ActionMenuPresenter)localObject).oJ != null)
    {
      localObject = ((ActionMenuPresenter)localObject).oJ.getDrawable();
      AppMethodBeat.o(240415);
      return localObject;
    }
    if (((ActionMenuPresenter)localObject).oL)
    {
      localObject = ((ActionMenuPresenter)localObject).oK;
      AppMethodBeat.o(240415);
      return localObject;
    }
    AppMethodBeat.o(240415);
    return null;
  }
  
  public int getPopupTheme()
  {
    return this.pl;
  }
  
  public int getWindowAnimations()
  {
    return 0;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(240409);
    super.onConfigurationChanged(paramConfiguration);
    if (this.pm != null)
    {
      this.pm.F(false);
      if (this.pm.cJ())
      {
        this.pm.cL();
        this.pm.cC();
      }
    }
    AppMethodBeat.o(240409);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(240413);
    super.onDetachedFromWindow();
    cU();
    AppMethodBeat.o(240413);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(240412);
    if (!this.pp)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(240412);
      return;
    }
    int i1 = getChildCount();
    int n = (paramInt4 - paramInt2) / 2;
    int i2 = getDividerWidth();
    int i = 0;
    paramInt4 = paramInt3 - paramInt1 - getPaddingRight() - getPaddingLeft();
    paramInt2 = 0;
    paramBoolean = ai.s(this);
    int j = 0;
    View localView;
    LayoutParams localLayoutParams;
    int k;
    int m;
    if (j < i1)
    {
      localView = getChildAt(j);
      if (localView.getVisibility() == 8) {
        break label668;
      }
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if (localLayoutParams.pt)
      {
        k = localView.getMeasuredWidth();
        paramInt2 = k;
        if (am(j)) {
          paramInt2 = k + i2;
        }
        int i3 = localView.getMeasuredHeight();
        if (paramBoolean)
        {
          m = getPaddingLeft() + localLayoutParams.leftMargin;
          k = m + paramInt2;
          label177:
          int i4 = n - i3 / 2;
          localView.layout(m, i4, k, i3 + i4);
          k = 1;
          paramInt4 -= paramInt2;
          paramInt2 = k;
        }
      }
    }
    label388:
    label411:
    label668:
    for (;;)
    {
      j += 1;
      break;
      k = getWidth() - getPaddingRight() - localLayoutParams.rightMargin;
      m = k - paramInt2;
      break label177;
      k = localView.getMeasuredWidth();
      m = localLayoutParams.leftMargin;
      paramInt4 -= localLayoutParams.rightMargin + (k + m);
      am(j);
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
        AppMethodBeat.o(240412);
        return;
      }
      if (paramInt2 != 0)
      {
        paramInt1 = 0;
        paramInt1 = i - paramInt1;
        if (paramInt1 <= 0) {
          break label526;
        }
        paramInt1 = paramInt4 / paramInt1;
        paramInt3 = Math.max(0, paramInt1);
        if (!paramBoolean) {
          break label538;
        }
        paramInt1 = getWidth() - getPaddingRight();
        paramInt2 = 0;
        if (paramInt2 >= i1) {
          break label531;
        }
        localView = getChildAt(paramInt2);
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if ((localView.getVisibility() == 8) || (localLayoutParams.pt)) {
          break label665;
        }
        paramInt1 -= localLayoutParams.rightMargin;
        paramInt4 = localView.getMeasuredWidth();
        i = localView.getMeasuredHeight();
        j = n - i / 2;
        localView.layout(paramInt1 - paramInt4, j, paramInt1, i + j);
        paramInt1 -= localLayoutParams.leftMargin + paramInt4 + paramInt3;
      }
      for (;;)
      {
        paramInt2 += 1;
        break label411;
        paramInt1 = 1;
        break;
        paramInt1 = 0;
        break label388;
        AppMethodBeat.o(240412);
        return;
        paramInt1 = getPaddingLeft();
        paramInt2 = 0;
        if (paramInt2 < i1)
        {
          localView = getChildAt(paramInt2);
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          if ((localView.getVisibility() == 8) || (localLayoutParams.pt)) {
            break label662;
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
          break;
          AppMethodBeat.o(240412);
          return;
        }
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(240410);
    boolean bool2 = this.pp;
    if (View.MeasureSpec.getMode(paramInt1) == 1073741824) {}
    int i;
    int i6;
    int i5;
    int i3;
    int i7;
    int i8;
    for (boolean bool1 = true;; bool1 = false)
    {
      this.pp = bool1;
      if (bool2 != this.pp) {
        this.pq = 0;
      }
      i = View.MeasureSpec.getSize(paramInt1);
      if ((this.pp) && (this.is != null) && (i != this.pq))
      {
        this.pq = i;
        this.is.H(true);
      }
      j = getChildCount();
      if ((!this.pp) || (j <= 0)) {
        break label1252;
      }
      i6 = View.MeasureSpec.getMode(paramInt2);
      paramInt1 = View.MeasureSpec.getSize(paramInt1);
      i5 = View.MeasureSpec.getSize(paramInt2);
      i = getPaddingLeft();
      j = getPaddingRight();
      i3 = getPaddingTop() + getPaddingBottom();
      i7 = getChildMeasureSpec(paramInt2, i3, -2);
      i8 = paramInt1 - (i + j);
      paramInt1 = i8 / this.oV;
      paramInt2 = this.oV;
      if (paramInt1 != 0) {
        break;
      }
      setMeasuredDimension(i8, 0);
      AppMethodBeat.o(240410);
      return;
    }
    int i9 = this.oV + i8 % paramInt2 / paramInt1;
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
    label363:
    label381:
    int i4;
    label419:
    label429:
    int i2;
    if (n < i10)
    {
      localObject = getChildAt(n);
      if (((View)localObject).getVisibility() == 8) {
        break label1353;
      }
      bool1 = localObject instanceof ActionMenuItemView;
      m += 1;
      if (bool1) {
        ((View)localObject).setPadding(this.pr, 0, this.pr, 0);
      }
      localLayoutParams = (LayoutParams)((View)localObject).getLayoutParams();
      localLayoutParams.py = false;
      localLayoutParams.pv = 0;
      localLayoutParams.pu = 0;
      localLayoutParams.pw = false;
      localLayoutParams.leftMargin = 0;
      localLayoutParams.rightMargin = 0;
      if ((bool1) && (((ActionMenuItemView)localObject).bN()))
      {
        bool1 = true;
        localLayoutParams.px = bool1;
        if (!localLayoutParams.pt) {
          break label495;
        }
        i = 1;
        i4 = a((View)localObject, i9, i, i7, i3);
        i1 = Math.max(i1, i4);
        if (!localLayoutParams.pw) {
          break label1346;
        }
        i = k + 1;
        if (!localLayoutParams.pt) {
          break label1343;
        }
        paramInt2 = 1;
        i2 = paramInt1 - i4;
        j = Math.max(j, ((View)localObject).getMeasuredHeight());
        if (i4 != 1) {
          break label1329;
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
      break label363;
      label495:
      i = paramInt1;
      break label381;
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
          break label819;
        }
        l3 = l1;
        if (n <= 0) {
          break label819;
        }
        i3 = 2147483647;
        l2 = 0L;
        i = 0;
        i4 = 0;
        label555:
        if (i4 >= i10) {
          break label653;
        }
        localObject = (LayoutParams)getChildAt(i4).getLayoutParams();
        if (!((LayoutParams)localObject).pw) {
          break label1326;
        }
        if (((LayoutParams)localObject).pu >= i3) {
          break label625;
        }
        i3 = ((LayoutParams)localObject).pu;
        l2 = 1L << i4;
        i = 1;
      }
      label653:
      label677:
      label819:
      label980:
      label983:
      label1252:
      for (;;)
      {
        i4 += 1;
        break label555;
        i2 = 0;
        break;
        label625:
        if (((LayoutParams)localObject).pu == i3)
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
                if (localLayoutParams.pu != i3 + 1) {
                  break label1323;
                }
                l1 |= 1 << i;
              }
            }
          }
          for (;;)
          {
            i += 1;
            break label677;
            if ((i2 != 0) && (localLayoutParams.px) && (paramInt1 == 1)) {
              ((View)localObject).setPadding(this.pr + i9, 0, this.pr, 0);
            }
            localLayoutParams.pu += 1;
            localLayoutParams.py = true;
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
                break label1154;
              }
              float f3 = Long.bitCount(l3);
              f2 = f3;
              if (paramInt2 != 0) {
                break label1317;
              }
              f1 = f3;
              if ((1L & l3) != 0L)
              {
                f1 = f3;
                if (!((LayoutParams)getChildAt(0).getLayoutParams()).px) {
                  f1 = f3 - 0.5F;
                }
              }
              f2 = f1;
              if ((1 << i10 - 1 & l3) == 0L) {
                break label1317;
              }
              f2 = f1;
              if (((LayoutParams)getChildAt(i10 - 1).getLayoutParams()).px) {
                break label1317;
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
                  break label1157;
                }
                if ((1 << i & l3) == 0L) {
                  break label1151;
                }
                localObject = getChildAt(i);
                localLayoutParams = (LayoutParams)((View)localObject).getLayoutParams();
                if (!(localObject instanceof ActionMenuItemView)) {
                  break label1087;
                }
                localLayoutParams.pv = paramInt2;
                localLayoutParams.py = true;
                if ((i == 0) && (!localLayoutParams.px)) {
                  localLayoutParams.leftMargin = (-paramInt2 / 2);
                }
                paramInt1 = 1;
              }
              label1151:
              for (;;)
              {
                i += 1;
                break label983;
                paramInt2 = 0;
                break;
                paramInt2 = 0;
                break label980;
                if (localLayoutParams.pt)
                {
                  localLayoutParams.pv = paramInt2;
                  localLayoutParams.py = true;
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
              k = paramInt1;
              if (k != 0)
              {
                paramInt1 = 0;
                while (paramInt1 < i10)
                {
                  localObject = getChildAt(paramInt1);
                  localLayoutParams = (LayoutParams)((View)localObject).getLayoutParams();
                  if (localLayoutParams.py)
                  {
                    paramInt2 = localLayoutParams.pu;
                    ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(localLayoutParams.pv + paramInt2 * i9, 1073741824), i7);
                  }
                  paramInt1 += 1;
                }
              }
              if (i6 != 1073741824) {}
              for (;;)
              {
                setMeasuredDimension(i8, j);
                AppMethodBeat.o(240410);
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
                AppMethodBeat.o(240410);
                return;
                j = i5;
              }
            }
          }
        }
      }
      label1087:
      k = i;
      label1154:
      label1157:
      label1317:
      label1323:
      label1326:
      label1329:
      paramInt1 = m;
      i = i2;
      continue;
      label1343:
      break label429;
      label1346:
      i = k;
      break label419;
      label1353:
      i = paramInt1;
      paramInt1 = m;
    }
  }
  
  public void setExpandedActionViewsExclusive(boolean paramBoolean)
  {
    this.pm.oU = paramBoolean;
  }
  
  public void setOnMenuItemClickListener(d paramd)
  {
    this.ps = paramd;
  }
  
  public void setOverflowIcon(Drawable paramDrawable)
  {
    AppMethodBeat.i(240414);
    getMenu();
    ActionMenuPresenter localActionMenuPresenter = this.pm;
    if (localActionMenuPresenter.oJ != null)
    {
      localActionMenuPresenter.oJ.setImageDrawable(paramDrawable);
      AppMethodBeat.o(240414);
      return;
    }
    localActionMenuPresenter.oL = true;
    localActionMenuPresenter.oK = paramDrawable;
    AppMethodBeat.o(240414);
  }
  
  public void setOverflowReserved(boolean paramBoolean)
  {
    this.oM = paramBoolean;
  }
  
  public void setPopupTheme(int paramInt)
  {
    AppMethodBeat.i(240407);
    if (this.pl != paramInt)
    {
      this.pl = paramInt;
      if (paramInt == 0)
      {
        this.nE = getContext();
        AppMethodBeat.o(240407);
        return;
      }
      this.nE = new ContextThemeWrapper(getContext(), paramInt);
    }
    AppMethodBeat.o(240407);
  }
  
  public void setPresenter(ActionMenuPresenter paramActionMenuPresenter)
  {
    AppMethodBeat.i(240408);
    this.pm = paramActionMenuPresenter;
    this.pm.a(this);
    AppMethodBeat.o(240408);
  }
  
  public static class LayoutParams
    extends LinearLayoutCompat.LayoutParams
  {
    @ViewDebug.ExportedProperty
    public boolean pt;
    @ViewDebug.ExportedProperty
    public int pu;
    @ViewDebug.ExportedProperty
    public int pv;
    @ViewDebug.ExportedProperty
    public boolean pw;
    @ViewDebug.ExportedProperty
    public boolean px;
    boolean py;
    
    public LayoutParams()
    {
      super(-2);
      this.pt = false;
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      this.pt = paramLayoutParams.pt;
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean bO();
    
    public abstract boolean bP();
  }
  
  static final class b
    implements o.a
  {
    public final void a(h paramh, boolean paramBoolean) {}
    
    public final boolean c(h paramh)
    {
      return false;
    }
  }
  
  final class c
    implements h.a
  {
    c() {}
    
    public final void a(h paramh)
    {
      AppMethodBeat.i(240405);
      if (ActionMenuView.this.po != null) {
        ActionMenuView.this.po.a(paramh);
      }
      AppMethodBeat.o(240405);
    }
    
    public final boolean a(h paramh, MenuItem paramMenuItem)
    {
      AppMethodBeat.i(240404);
      if ((ActionMenuView.this.ps != null) && (ActionMenuView.this.ps.onMenuItemClick(paramMenuItem)))
      {
        AppMethodBeat.o(240404);
        return true;
      }
      AppMethodBeat.o(240404);
      return false;
    }
  }
  
  public static abstract interface d
  {
    public abstract boolean onMenuItemClick(MenuItem paramMenuItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.widget.ActionMenuView
 * JD-Core Version:    0.7.0.1
 */