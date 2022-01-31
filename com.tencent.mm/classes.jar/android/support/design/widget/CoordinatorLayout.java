package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.b.a.a;
import android.support.b.a.b;
import android.support.b.a.c;
import android.support.v4.a.a.a;
import android.support.v4.content.b;
import android.support.v4.f.i;
import android.support.v4.f.k.a;
import android.support.v4.f.k.c;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.d;
import android.support.v4.view.k;
import android.support.v4.view.l;
import android.support.v4.view.q;
import android.support.v4.view.y;
import android.support.v4.widget.h;
import android.support.v4.widget.s;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoordinatorLayout
  extends ViewGroup
  implements k
{
  static final String hs;
  static final Class<?>[] ht;
  static final ThreadLocal<Map<String, Constructor<CoordinatorLayout.Behavior>>> hu;
  static final Comparator<View> hv;
  private static final k.a<Rect> hw;
  y ev;
  final List<View> hA = new ArrayList();
  private final int[] hB = new int[2];
  private boolean hC;
  private boolean hD;
  private int[] hE;
  private View hF;
  private View hG;
  private CoordinatorLayout.e hH;
  private boolean hI;
  boolean hJ;
  private Drawable hK;
  ViewGroup.OnHierarchyChangeListener hL;
  private android.support.v4.view.m hM;
  private final l hN = new l(this);
  private final List<View> hx = new ArrayList();
  final h<View> hy = new h();
  private final List<View> hz = new ArrayList();
  
  static
  {
    Object localObject = CoordinatorLayout.class.getPackage();
    if (localObject != null)
    {
      localObject = ((Package)localObject).getName();
      hs = (String)localObject;
      if (Build.VERSION.SDK_INT < 21) {
        break label82;
      }
    }
    label82:
    for (hv = new CoordinatorLayout.f();; hv = null)
    {
      ht = new Class[] { Context.class, AttributeSet.class };
      hu = new ThreadLocal();
      hw = new k.c(12);
      return;
      localObject = null;
      break;
    }
  }
  
  public CoordinatorLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.a.coordinatorLayoutStyle);
  }
  
  public CoordinatorLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (paramInt == 0) {}
    for (paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.c.CoordinatorLayout, 0, a.b.Widget_Support_CoordinatorLayout);; paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.c.CoordinatorLayout, paramInt, 0))
    {
      paramInt = paramAttributeSet.getResourceId(a.c.CoordinatorLayout_keylines, 0);
      if (paramInt == 0) {
        break;
      }
      paramContext = paramContext.getResources();
      this.hE = paramContext.getIntArray(paramInt);
      float f = paramContext.getDisplayMetrics().density;
      int j = this.hE.length;
      paramInt = i;
      while (paramInt < j)
      {
        this.hE[paramInt] = ((int)(this.hE[paramInt] * f));
        paramInt += 1;
      }
    }
    this.hK = paramAttributeSet.getDrawable(a.c.CoordinatorLayout_statusBarBackground);
    paramAttributeSet.recycle();
    aG();
    super.setOnHierarchyChangeListener(new CoordinatorLayout.c(this));
  }
  
  private int E(int paramInt)
  {
    if (this.hE == null)
    {
      new StringBuilder("No keylines defined for ").append(this).append(" - attempted index lookup ").append(paramInt);
      return 0;
    }
    if ((paramInt < 0) || (paramInt >= this.hE.length))
    {
      new StringBuilder("Keyline index ").append(paramInt).append(" out of range for ").append(this);
      return 0;
    }
    return this.hE[paramInt];
  }
  
  private static int F(int paramInt)
  {
    if ((paramInt & 0x7) == 0) {
      paramInt = 0x800003 | paramInt;
    }
    for (;;)
    {
      int i = paramInt;
      if ((paramInt & 0x70) == 0) {
        i = paramInt | 0x30;
      }
      return i;
    }
  }
  
  private static int G(int paramInt)
  {
    int i = paramInt;
    if (paramInt == 0) {
      i = 8388661;
    }
    return i;
  }
  
  static CoordinatorLayout.Behavior a(Context paramContext, AttributeSet paramAttributeSet, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    String str;
    if (paramString.startsWith(".")) {
      str = paramContext.getPackageName() + paramString;
    }
    label223:
    for (;;)
    {
      try
      {
        paramString = (Map)hu.get();
        if (paramString != null) {
          break label223;
        }
        paramString = new HashMap();
        hu.set(paramString);
        Constructor localConstructor2 = (Constructor)paramString.get(str);
        Constructor localConstructor1 = localConstructor2;
        if (localConstructor2 == null)
        {
          localConstructor1 = paramContext.getClassLoader().loadClass(str).getConstructor(ht);
          localConstructor1.setAccessible(true);
          paramString.put(str, localConstructor1);
        }
        paramContext = (CoordinatorLayout.Behavior)localConstructor1.newInstance(new Object[] { paramContext, paramAttributeSet });
        return paramContext;
      }
      catch (Exception paramContext)
      {
        throw new RuntimeException("Could not inflate Behavior subclass " + str, paramContext);
      }
      str = paramString;
      if (paramString.indexOf('.') < 0)
      {
        str = paramString;
        if (!TextUtils.isEmpty(hs)) {
          str = hs + '.' + paramString;
        }
      }
    }
  }
  
  private static void a(int paramInt1, Rect paramRect1, Rect paramRect2, CoordinatorLayout.d paramd, int paramInt2, int paramInt3)
  {
    int j = paramd.gravity;
    int i = j;
    if (j == 0) {
      i = 17;
    }
    int k = d.getAbsoluteGravity(i, paramInt1);
    i = d.getAbsoluteGravity(F(paramd.anchorGravity), paramInt1);
    switch (i & 0x7)
    {
    default: 
      paramInt1 = paramRect1.left;
      switch (i & 0x70)
      {
      default: 
        i = paramRect1.top;
        label114:
        j = paramInt1;
        switch (k & 0x7)
        {
        default: 
          j = paramInt1 - paramInt2;
        case 5: 
          label154:
          paramInt1 = i;
          switch (k & 0x70)
          {
          }
          break;
        }
        break;
      }
      break;
    }
    for (paramInt1 = i - paramInt3;; paramInt1 = i - paramInt3 / 2)
    {
      paramRect2.set(j, paramInt1, j + paramInt2, paramInt1 + paramInt3);
      return;
      paramInt1 = paramRect1.right;
      break;
      paramInt1 = paramRect1.left;
      paramInt1 = paramRect1.width() / 2 + paramInt1;
      break;
      i = paramRect1.bottom;
      break label114;
      i = paramRect1.top + paramRect1.height() / 2;
      break label114;
      j = paramInt1 - paramInt2 / 2;
      break label154;
    }
  }
  
  private void a(CoordinatorLayout.d paramd, Rect paramRect, int paramInt1, int paramInt2)
  {
    int j = getWidth();
    int i = getHeight();
    j = Math.max(getPaddingLeft() + paramd.leftMargin, Math.min(paramRect.left, j - getPaddingRight() - paramInt1 - paramd.rightMargin));
    i = Math.max(getPaddingTop() + paramd.topMargin, Math.min(paramRect.top, i - getPaddingBottom() - paramInt2 - paramd.bottomMargin));
    paramRect.set(j, i, j + paramInt1, i + paramInt2);
  }
  
  private void a(View paramView, boolean paramBoolean, Rect paramRect)
  {
    if ((paramView.isLayoutRequested()) || (paramView.getVisibility() == 8))
    {
      paramRect.setEmpty();
      return;
    }
    if (paramBoolean)
    {
      s.a(this, paramView, paramRect);
      return;
    }
    paramRect.set(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
  }
  
  private boolean a(MotionEvent paramMotionEvent, int paramInt)
  {
    boolean bool1 = false;
    int k = 0;
    int m = paramMotionEvent.getActionMasked();
    List localList = this.hz;
    localList.clear();
    boolean bool2 = isChildrenDrawingOrderEnabled();
    int n = getChildCount();
    int i = n - 1;
    if (i >= 0)
    {
      if (bool2) {}
      for (j = getChildDrawingOrder(n, i);; j = i)
      {
        localList.add(getChildAt(j));
        i -= 1;
        break;
      }
    }
    if (hv != null) {
      Collections.sort(localList, hv);
    }
    n = localList.size();
    int j = 0;
    MotionEvent localMotionEvent = null;
    i = k;
    View localView;
    CoordinatorLayout.d locald;
    CoordinatorLayout.Behavior localBehavior;
    if (j < n)
    {
      localView = (View)localList.get(j);
      locald = (CoordinatorLayout.d)localView.getLayoutParams();
      localBehavior = locald.hP;
      if (((bool1) || (i != 0)) && (m != 0))
      {
        if (localBehavior == null) {
          break label456;
        }
        if (localMotionEvent != null) {
          break label453;
        }
        long l = SystemClock.uptimeMillis();
        localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        label199:
        switch (paramInt)
        {
        }
      }
    }
    label304:
    label434:
    label443:
    label453:
    label456:
    for (;;)
    {
      j += 1;
      break;
      localBehavior.a(this, localView, localMotionEvent);
      continue;
      localBehavior.b(this, localView, localMotionEvent);
      continue;
      bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (localBehavior == null) {}
      }
      switch (paramInt)
      {
      default: 
        bool2 = bool1;
        if (bool1)
        {
          this.hF = localView;
          bool2 = bool1;
        }
        bool1 = bool2;
        if (locald.hP == null) {
          locald.hZ = false;
        }
        boolean bool3 = locald.hZ;
        if (locald.hZ)
        {
          bool2 = true;
          label359:
          if ((!bool2) || (bool3)) {
            break label434;
          }
        }
        break;
      }
      for (i = 1;; i = 0)
      {
        if (bool2)
        {
          bool2 = bool1;
          if (i == 0) {
            break label443;
          }
        }
        break;
        bool1 = localBehavior.a(this, localView, paramMotionEvent);
        break label304;
        bool1 = localBehavior.b(this, localView, paramMotionEvent);
        break label304;
        bool2 = locald.hZ | false;
        locald.hZ = bool2;
        break label359;
      }
      bool2 = bool1;
      localList.clear();
      return bool2;
      break label199;
    }
  }
  
  private static Rect aE()
  {
    Rect localRect2 = (Rect)hw.de();
    Rect localRect1 = localRect2;
    if (localRect2 == null) {
      localRect1 = new Rect();
    }
    return localRect1;
  }
  
  private void aF()
  {
    this.hx.clear();
    Object localObject1 = this.hy;
    int j = ((h)localObject1).JV.size();
    int i = 0;
    Object localObject2;
    while (i < j)
    {
      localObject2 = (ArrayList)((h)localObject1).JV.valueAt(i);
      if (localObject2 != null)
      {
        ((ArrayList)localObject2).clear();
        ((h)localObject1).JU.D(localObject2);
      }
      i += 1;
    }
    ((h)localObject1).JV.clear();
    int m = getChildCount();
    j = 0;
    while (j < m)
    {
      View localView1 = getChildAt(j);
      CoordinatorLayout.d locald = m(localView1);
      if (locald.hS == -1)
      {
        locald.hY = null;
        locald.hX = null;
        this.hy.I(localView1);
        i = 0;
      }
      for (;;)
      {
        if (i >= m) {
          break label769;
        }
        if (i != j)
        {
          View localView2 = getChildAt(i);
          int k;
          if (localView2 != locald.hY)
          {
            k = q.Q(this);
            int n = d.getAbsoluteGravity(((CoordinatorLayout.d)localView2.getLayoutParams()).hT, k);
            if ((n != 0) && ((d.getAbsoluteGravity(locald.hU, k) & n) == n))
            {
              k = 1;
              label217:
              if ((k == 0) && ((locald.hP == null) || (!locald.hP.d(localView2)))) {
                break label679;
              }
            }
          }
          else
          {
            k = 1;
          }
          for (;;)
          {
            if (k != 0)
            {
              if (!this.hy.JV.containsKey(localView2)) {
                this.hy.I(localView2);
              }
              h localh = this.hy;
              if ((!localh.JV.containsKey(localView2)) || (!localh.JV.containsKey(localView1)))
              {
                throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
                if (locald.hX != null)
                {
                  if (locald.hX.getId() == locald.hS) {
                    break label398;
                  }
                  i = 0;
                }
                for (;;)
                {
                  if (i != 0) {
                    break label487;
                  }
                  locald.hX = findViewById(locald.hS);
                  if (locald.hX == null) {
                    break label605;
                  }
                  if (locald.hX != this) {
                    break label500;
                  }
                  if (!isInEditMode()) {
                    break label489;
                  }
                  locald.hY = null;
                  locald.hX = null;
                  break;
                  label398:
                  localObject2 = locald.hX;
                  for (localObject1 = locald.hX.getParent();; localObject1 = ((ViewParent)localObject1).getParent())
                  {
                    if (localObject1 == this) {
                      break label477;
                    }
                    if ((localObject1 == null) || (localObject1 == localView1))
                    {
                      locald.hY = null;
                      locald.hX = null;
                      i = 0;
                      break;
                    }
                    if ((localObject1 instanceof View)) {
                      localObject2 = (View)localObject1;
                    }
                  }
                  label477:
                  locald.hY = ((View)localObject2);
                  i = 1;
                }
                label487:
                break;
                label489:
                throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                label500:
                localObject2 = locald.hX;
                for (localObject1 = locald.hX.getParent();; localObject1 = ((ViewParent)localObject1).getParent())
                {
                  if ((localObject1 == this) || (localObject1 == null)) {
                    break label595;
                  }
                  if (localObject1 == localView1)
                  {
                    if (isInEditMode())
                    {
                      locald.hY = null;
                      locald.hX = null;
                      break;
                    }
                    throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                  }
                  if ((localObject1 instanceof View)) {
                    localObject2 = (View)localObject1;
                  }
                }
                label595:
                locald.hY = ((View)localObject2);
                break;
                label605:
                if (isInEditMode())
                {
                  locald.hY = null;
                  locald.hX = null;
                  break;
                }
                throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + getResources().getResourceName(locald.hS) + " to anchor view " + localView1);
                k = 0;
                break label217;
                label679:
                k = 0;
                continue;
              }
              localObject2 = (ArrayList)localh.JV.get(localView2);
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                localObject2 = (ArrayList)localh.JU.de();
                localObject1 = localObject2;
                if (localObject2 == null) {
                  localObject1 = new ArrayList();
                }
                localh.JV.put(localView2, localObject1);
              }
              ((ArrayList)localObject1).add(localView1);
            }
          }
        }
        i += 1;
      }
      label769:
      j += 1;
    }
    this.hx.addAll(this.hy.dE());
    Collections.reverse(this.hx);
  }
  
  private void aG()
  {
    if (Build.VERSION.SDK_INT < 21) {
      return;
    }
    if (q.ae(this))
    {
      if (this.hM == null) {
        this.hM = new android.support.v4.view.m()
        {
          public final y a(View paramAnonymousView, y paramAnonymousy)
          {
            boolean bool2 = true;
            int i = 0;
            CoordinatorLayout localCoordinatorLayout = CoordinatorLayout.this;
            if (!i.equals(localCoordinatorLayout.ev, paramAnonymousy))
            {
              localCoordinatorLayout.ev = paramAnonymousy;
              if ((paramAnonymousy != null) && (paramAnonymousy.getSystemWindowInsetTop() > 0))
              {
                bool1 = true;
                localCoordinatorLayout.hJ = bool1;
                if ((localCoordinatorLayout.hJ) || (localCoordinatorLayout.getBackground() != null)) {
                  break label155;
                }
              }
              label155:
              for (boolean bool1 = bool2;; bool1 = false)
              {
                localCoordinatorLayout.setWillNotDraw(bool1);
                if (paramAnonymousy.isConsumed()) {
                  break label171;
                }
                int j = localCoordinatorLayout.getChildCount();
                paramAnonymousView = paramAnonymousy;
                while (i < j)
                {
                  paramAnonymousy = localCoordinatorLayout.getChildAt(i);
                  if ((!q.ae(paramAnonymousy)) || (((CoordinatorLayout.d)paramAnonymousy.getLayoutParams()).hP == null)) {
                    break label168;
                  }
                  paramAnonymousy = CoordinatorLayout.Behavior.b(paramAnonymousView);
                  paramAnonymousView = paramAnonymousy;
                  if (paramAnonymousy.isConsumed()) {
                    break;
                  }
                  paramAnonymousView = paramAnonymousy;
                  i += 1;
                }
                bool1 = false;
                break;
              }
              for (;;)
              {
                localCoordinatorLayout.requestLayout();
                return paramAnonymousView;
                label168:
                break;
                label171:
                paramAnonymousView = paramAnonymousy;
              }
            }
            return paramAnonymousy;
          }
        };
      }
      q.a(this, this.hM);
      setSystemUiVisibility(1280);
      return;
    }
    q.a(this, null);
  }
  
  private static void c(Rect paramRect)
  {
    paramRect.setEmpty();
    hw.D(paramRect);
  }
  
  private static void f(View paramView, int paramInt)
  {
    CoordinatorLayout.d locald = (CoordinatorLayout.d)paramView.getLayoutParams();
    if (locald.hV != paramInt)
    {
      q.q(paramView, paramInt - locald.hV);
      locald.hV = paramInt;
    }
  }
  
  private static void g(View paramView, int paramInt)
  {
    CoordinatorLayout.d locald = (CoordinatorLayout.d)paramView.getLayoutParams();
    if (locald.hW != paramInt)
    {
      q.p(paramView, paramInt - locald.hW);
      locald.hW = paramInt;
    }
  }
  
  private static CoordinatorLayout.d m(View paramView)
  {
    CoordinatorLayout.d locald = (CoordinatorLayout.d)paramView.getLayoutParams();
    if (!locald.hQ)
    {
      if ((paramView instanceof CoordinatorLayout.a))
      {
        locald.a(((CoordinatorLayout.a)paramView).aH());
        locald.hQ = true;
      }
    }
    else {
      return locald;
    }
    Class localClass = paramView.getClass();
    paramView = null;
    View localView;
    for (;;)
    {
      localView = paramView;
      if (localClass == null) {
        break;
      }
      paramView = (CoordinatorLayout.b)localClass.getAnnotation(CoordinatorLayout.b.class);
      localView = paramView;
      if (paramView != null) {
        break;
      }
      localClass = localClass.getSuperclass();
    }
    if (localView != null) {}
    try
    {
      locald.a((CoordinatorLayout.Behavior)localView.value().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
      locald.hQ = true;
      return locald;
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        new StringBuilder("Default behavior class ").append(localView.value().getName()).append(" could not be instantiated. Did you forget a default constructor?");
      }
    }
  }
  
  private void r(boolean paramBoolean)
  {
    int j = getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = getChildAt(i);
      CoordinatorLayout.Behavior localBehavior = ((CoordinatorLayout.d)localView.getLayoutParams()).hP;
      MotionEvent localMotionEvent;
      if (localBehavior != null)
      {
        long l = SystemClock.uptimeMillis();
        localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        if (!paramBoolean) {
          break label82;
        }
        localBehavior.a(this, localView, localMotionEvent);
      }
      for (;;)
      {
        localMotionEvent.recycle();
        i += 1;
        break;
        label82:
        localBehavior.b(this, localView, localMotionEvent);
      }
    }
    i = 0;
    while (i < j)
    {
      ((CoordinatorLayout.d)getChildAt(i).getLayoutParams()).hZ = false;
      i += 1;
    }
    this.hF = null;
    this.hC = false;
  }
  
  final void H(int paramInt)
  {
    int m = q.Q(this);
    int n = this.hx.size();
    Rect localRect1 = aE();
    Rect localRect2 = aE();
    Rect localRect3 = aE();
    int j = 0;
    View localView;
    Object localObject1;
    int i;
    Object localObject2;
    Object localObject3;
    if (j < n)
    {
      localView = (View)this.hx.get(j);
      localObject1 = (CoordinatorLayout.d)localView.getLayoutParams();
      if ((paramInt != 0) || (localView.getVisibility() != 8))
      {
        i = 0;
        int i1;
        int i2;
        int k;
        if (i < j)
        {
          localObject2 = (View)this.hx.get(i);
          Rect localRect5;
          if (((CoordinatorLayout.d)localObject1).hY == localObject2)
          {
            localObject2 = (CoordinatorLayout.d)localView.getLayoutParams();
            if (((CoordinatorLayout.d)localObject2).hX != null)
            {
              localObject3 = aE();
              localRect4 = aE();
              localRect5 = aE();
              s.a(this, ((CoordinatorLayout.d)localObject2).hX, (Rect)localObject3);
              a(localView, false, localRect4);
              i1 = localView.getMeasuredWidth();
              i2 = localView.getMeasuredHeight();
              a(m, (Rect)localObject3, localRect5, (CoordinatorLayout.d)localObject2, i1, i2);
              if ((localRect5.left == localRect4.left) && (localRect5.top == localRect4.top)) {
                break label337;
              }
            }
          }
          label337:
          for (k = 1;; k = 0)
          {
            a((CoordinatorLayout.d)localObject2, localRect5, i1, i2);
            i1 = localRect5.left - localRect4.left;
            i2 = localRect5.top - localRect4.top;
            if (i1 != 0) {
              q.q(localView, i1);
            }
            if (i2 != 0) {
              q.p(localView, i2);
            }
            if (k != 0)
            {
              CoordinatorLayout.Behavior localBehavior = ((CoordinatorLayout.d)localObject2).hP;
              if (localBehavior != null) {
                localBehavior.a(this, localView, ((CoordinatorLayout.d)localObject2).hX);
              }
            }
            c((Rect)localObject3);
            c(localRect4);
            c(localRect5);
            i += 1;
            break;
          }
        }
        a(localView, true, localRect2);
        if ((((CoordinatorLayout.d)localObject1).hT != 0) && (!localRect2.isEmpty()))
        {
          i = d.getAbsoluteGravity(((CoordinatorLayout.d)localObject1).hT, m);
          switch (i & 0x70)
          {
          default: 
            switch (i & 0x7)
            {
            }
            break;
          }
        }
        for (;;)
        {
          if ((((CoordinatorLayout.d)localObject1).hU != 0) && (localView.getVisibility() == 0) && (q.al(localView)) && (localView.getWidth() > 0) && (localView.getHeight() > 0)) {
            break label703;
          }
          label480:
          if (paramInt != 2)
          {
            localRect3.set(((CoordinatorLayout.d)localView.getLayoutParams()).ie);
            if (localRect3.equals(localRect2)) {
              break label1197;
            }
            ((CoordinatorLayout.d)localView.getLayoutParams()).ie.set(localRect2);
          }
          i = j + 1;
          for (;;)
          {
            if (i >= n) {
              break label1197;
            }
            localObject1 = (View)this.hx.get(i);
            localObject2 = (CoordinatorLayout.d)((View)localObject1).getLayoutParams();
            localObject3 = ((CoordinatorLayout.d)localObject2).hP;
            if ((localObject3 != null) && (((CoordinatorLayout.Behavior)localObject3).d(localView)))
            {
              if ((paramInt != 0) || (!((CoordinatorLayout.d)localObject2).ic)) {
                break;
              }
              ((CoordinatorLayout.d)localObject2).ic = false;
            }
            i += 1;
          }
          localRect1.top = Math.max(localRect1.top, localRect2.bottom);
          break;
          localRect1.bottom = Math.max(localRect1.bottom, getHeight() - localRect2.top);
          break;
          localRect1.left = Math.max(localRect1.left, localRect2.right);
          continue;
          localRect1.right = Math.max(localRect1.right, getWidth() - localRect2.left);
        }
        label703:
        localObject1 = (CoordinatorLayout.d)localView.getLayoutParams();
        localObject2 = ((CoordinatorLayout.d)localObject1).hP;
        localObject3 = aE();
        Rect localRect4 = aE();
        localRect4.set(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
        if ((localObject2 != null) && (((CoordinatorLayout.Behavior)localObject2).a(localView, (Rect)localObject3)))
        {
          if (!localRect4.contains((Rect)localObject3)) {
            throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + ((Rect)localObject3).toShortString() + " | Bounds:" + localRect4.toShortString());
          }
        }
        else {
          ((Rect)localObject3).set(localRect4);
        }
        c(localRect4);
        if (!((Rect)localObject3).isEmpty())
        {
          i1 = d.getAbsoluteGravity(((CoordinatorLayout.d)localObject1).hU, m);
          k = 0;
          i = k;
          if ((i1 & 0x30) == 48)
          {
            i2 = ((Rect)localObject3).top - ((CoordinatorLayout.d)localObject1).topMargin - ((CoordinatorLayout.d)localObject1).hW;
            i = k;
            if (i2 < localRect1.top)
            {
              g(localView, localRect1.top - i2);
              i = 1;
            }
          }
          k = i;
          if ((i1 & 0x50) == 80)
          {
            i2 = getHeight() - ((Rect)localObject3).bottom - ((CoordinatorLayout.d)localObject1).bottomMargin + ((CoordinatorLayout.d)localObject1).hW;
            k = i;
            if (i2 < localRect1.bottom)
            {
              g(localView, i2 - localRect1.bottom);
              k = 1;
            }
          }
          if (k == 0) {
            g(localView, 0);
          }
          k = 0;
          i = k;
          if ((i1 & 0x3) == 3)
          {
            i2 = ((Rect)localObject3).left - ((CoordinatorLayout.d)localObject1).leftMargin - ((CoordinatorLayout.d)localObject1).hV;
            i = k;
            if (i2 < localRect1.left)
            {
              f(localView, localRect1.left - i2);
              i = 1;
            }
          }
          if ((i1 & 0x5) != 5) {
            break label1220;
          }
          k = getWidth();
          i1 = ((Rect)localObject3).right;
          i2 = ((CoordinatorLayout.d)localObject1).rightMargin;
          k = ((CoordinatorLayout.d)localObject1).hV + (k - i1 - i2);
          if (k >= localRect1.right) {
            break label1220;
          }
          f(localView, k - localRect1.right);
          i = 1;
        }
      }
    }
    label1197:
    label1220:
    for (;;)
    {
      if (i == 0) {
        f(localView, 0);
      }
      c((Rect)localObject3);
      break label480;
      switch (paramInt)
      {
      }
      for (boolean bool = ((CoordinatorLayout.Behavior)localObject3).a(this, (View)localObject1, localView); paramInt == 1; bool = true)
      {
        ((CoordinatorLayout.d)localObject2).ic = bool;
        break;
      }
      j += 1;
      break;
      c(localRect1);
      c(localRect2);
      c(localRect3);
      return;
    }
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    measureChildWithMargins(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    int j = 0;
    int i = 0;
    int k = 0;
    int i2 = getChildCount();
    int m = 0;
    label126:
    int n;
    if (m < i2)
    {
      View localView = getChildAt(m);
      if (localView.getVisibility() == 8) {
        break label238;
      }
      Object localObject = (CoordinatorLayout.d)localView.getLayoutParams();
      if (!((CoordinatorLayout.d)localObject).I(paramInt3)) {
        break label238;
      }
      localObject = ((CoordinatorLayout.d)localObject).hP;
      if (localObject == null) {
        break label238;
      }
      int[] arrayOfInt = this.hB;
      this.hB[1] = 0;
      arrayOfInt[0] = 0;
      ((CoordinatorLayout.Behavior)localObject).a(this, localView, paramView, paramInt2, this.hB, paramInt3);
      if (paramInt1 > 0)
      {
        j = Math.max(j, this.hB[0]);
        if (paramInt2 <= 0) {
          break label199;
        }
        k = Math.max(i, this.hB[1]);
        label143:
        n = 1;
        i = j;
        j = k;
      }
    }
    for (;;)
    {
      int i1 = m + 1;
      m = i;
      k = n;
      i = j;
      j = m;
      m = i1;
      break;
      j = Math.min(j, this.hB[0]);
      break label126;
      label199:
      k = Math.min(i, this.hB[1]);
      break label143;
      paramArrayOfInt[0] = j;
      paramArrayOfInt[1] = i;
      if (k != 0) {
        H(1);
      }
      return;
      label238:
      n = i;
      i = j;
      j = n;
      n = k;
    }
  }
  
  public final boolean b(View paramView, int paramInt1, int paramInt2)
  {
    Rect localRect = aE();
    s.a(this, paramView, localRect);
    try
    {
      boolean bool = localRect.contains(paramInt1, paramInt2);
      return bool;
    }
    finally
    {
      c(localRect);
    }
  }
  
  public final boolean c(View paramView, int paramInt1, int paramInt2)
  {
    int j = getChildCount();
    int i = 0;
    boolean bool1 = false;
    if (i < j)
    {
      View localView = getChildAt(i);
      CoordinatorLayout.d locald;
      if (localView.getVisibility() != 8)
      {
        locald = (CoordinatorLayout.d)localView.getLayoutParams();
        CoordinatorLayout.Behavior localBehavior = locald.hP;
        if (localBehavior != null)
        {
          boolean bool2 = localBehavior.a(this, localView, paramView, paramInt1, paramInt2);
          bool1 |= bool2;
          locald.i(paramInt2, bool2);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        locald.i(paramInt2, false);
      }
    }
    return bool1;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof CoordinatorLayout.d)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    paramView.getLayoutParams();
    return super.drawChild(paramCanvas, paramView, paramLong);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    boolean bool2 = false;
    Drawable localDrawable = this.hK;
    boolean bool1 = bool2;
    if (localDrawable != null)
    {
      bool1 = bool2;
      if (localDrawable.isStateful()) {
        bool1 = localDrawable.setState(arrayOfInt) | false;
      }
    }
    if (bool1) {
      invalidate();
    }
  }
  
  public final void e(View paramView, int paramInt)
  {
    Object localObject1 = (CoordinatorLayout.d)paramView.getLayoutParams();
    if ((((CoordinatorLayout.d)localObject1).hX == null) && (((CoordinatorLayout.d)localObject1).hS != -1)) {}
    for (int i = 1; i != 0; i = 0) {
      throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
    }
    int j;
    if (((CoordinatorLayout.d)localObject1).hX != null)
    {
      localObject2 = ((CoordinatorLayout.d)localObject1).hX;
      paramView.getLayoutParams();
      localObject1 = aE();
      localRect = aE();
      try
      {
        s.a(this, (View)localObject2, (Rect)localObject1);
        localObject2 = (CoordinatorLayout.d)paramView.getLayoutParams();
        i = paramView.getMeasuredWidth();
        j = paramView.getMeasuredHeight();
        a(paramInt, (Rect)localObject1, localRect, (CoordinatorLayout.d)localObject2, i, j);
        a((CoordinatorLayout.d)localObject2, localRect, i, j);
        paramView.layout(localRect.left, localRect.top, localRect.right, localRect.bottom);
        return;
      }
      finally
      {
        c((Rect)localObject1);
        c(localRect);
      }
    }
    if (((CoordinatorLayout.d)localObject1).hR >= 0)
    {
      j = ((CoordinatorLayout.d)localObject1).hR;
      localObject1 = (CoordinatorLayout.d)paramView.getLayoutParams();
      int i2 = d.getAbsoluteGravity(G(((CoordinatorLayout.d)localObject1).gravity), paramInt);
      int i1 = getWidth();
      int n = getHeight();
      int k = paramView.getMeasuredWidth();
      int m = paramView.getMeasuredHeight();
      i = j;
      if (paramInt == 1) {
        i = i1 - j;
      }
      paramInt = E(i) - k;
      switch (i2 & 0x7)
      {
      default: 
        switch (i2 & 0x70)
        {
        default: 
          i = 0;
        }
        break;
      }
      for (;;)
      {
        paramInt = Math.max(getPaddingLeft() + ((CoordinatorLayout.d)localObject1).leftMargin, Math.min(paramInt, i1 - getPaddingRight() - k - ((CoordinatorLayout.d)localObject1).rightMargin));
        i = Math.max(getPaddingTop() + ((CoordinatorLayout.d)localObject1).topMargin, Math.min(i, n - getPaddingBottom() - m - ((CoordinatorLayout.d)localObject1).bottomMargin));
        paramView.layout(paramInt, i, paramInt + k, i + m);
        return;
        paramInt += k;
        break;
        paramInt += k / 2;
        break;
        i = m + 0;
        continue;
        i = m / 2 + 0;
      }
    }
    localObject1 = (CoordinatorLayout.d)paramView.getLayoutParams();
    Rect localRect = aE();
    localRect.set(getPaddingLeft() + ((CoordinatorLayout.d)localObject1).leftMargin, getPaddingTop() + ((CoordinatorLayout.d)localObject1).topMargin, getWidth() - getPaddingRight() - ((CoordinatorLayout.d)localObject1).rightMargin, getHeight() - getPaddingBottom() - ((CoordinatorLayout.d)localObject1).bottomMargin);
    if ((this.ev != null) && (q.ae(this)) && (!q.ae(paramView)))
    {
      localRect.left += this.ev.getSystemWindowInsetLeft();
      localRect.top += this.ev.getSystemWindowInsetTop();
      localRect.right -= this.ev.getSystemWindowInsetRight();
      localRect.bottom -= this.ev.getSystemWindowInsetBottom();
    }
    Object localObject2 = aE();
    d.apply(F(((CoordinatorLayout.d)localObject1).gravity), paramView.getMeasuredWidth(), paramView.getMeasuredHeight(), localRect, (Rect)localObject2, paramInt);
    paramView.layout(((Rect)localObject2).left, ((Rect)localObject2).top, ((Rect)localObject2).right, ((Rect)localObject2).bottom);
    c(localRect);
    c((Rect)localObject2);
  }
  
  final List<View> getDependencySortedChildren()
  {
    aF();
    return Collections.unmodifiableList(this.hx);
  }
  
  public final y getLastWindowInsets()
  {
    return this.ev;
  }
  
  public int getNestedScrollAxes()
  {
    return this.hN.Fs;
  }
  
  public Drawable getStatusBarBackground()
  {
    return this.hK;
  }
  
  protected int getSuggestedMinimumHeight()
  {
    return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
  }
  
  protected int getSuggestedMinimumWidth()
  {
    return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
  }
  
  public final void h(int paramInt1, int paramInt2)
  {
    int k = getChildCount();
    int j = 0;
    int i = 0;
    if (j < k)
    {
      View localView = getChildAt(j);
      if (localView.getVisibility() == 8) {
        break label97;
      }
      Object localObject = (CoordinatorLayout.d)localView.getLayoutParams();
      if (!((CoordinatorLayout.d)localObject).I(paramInt2)) {
        break label97;
      }
      localObject = ((CoordinatorLayout.d)localObject).hP;
      if (localObject == null) {
        break label97;
      }
      ((CoordinatorLayout.Behavior)localObject).b(this, localView, paramInt1);
      i = 1;
    }
    label97:
    for (;;)
    {
      j += 1;
      break;
      if (i != 0) {
        H(1);
      }
      return;
    }
  }
  
  public final void h(View paramView, int paramInt)
  {
    this.hN.Fs = paramInt;
    this.hG = paramView;
    int i = getChildCount();
    paramInt = 0;
    while (paramInt < i)
    {
      getChildAt(paramInt).getLayoutParams();
      paramInt += 1;
    }
  }
  
  public final void i(View paramView, int paramInt)
  {
    this.hN.Fs = 0;
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      CoordinatorLayout.d locald = (CoordinatorLayout.d)localView.getLayoutParams();
      if (locald.I(paramInt))
      {
        CoordinatorLayout.Behavior localBehavior = locald.hP;
        if (localBehavior != null) {
          localBehavior.a(this, localView, paramView, paramInt);
        }
        locald.i(paramInt, false);
        locald.ic = false;
      }
      i += 1;
    }
    this.hG = null;
  }
  
  public final List<View> n(View paramView)
  {
    h localh = this.hy;
    Object localObject1 = null;
    int j = localh.JV.size();
    int i = 0;
    Object localObject2;
    if (i < j)
    {
      ArrayList localArrayList = (ArrayList)localh.JV.valueAt(i);
      localObject2 = localObject1;
      if (localArrayList != null)
      {
        localObject2 = localObject1;
        if (localArrayList.contains(paramView))
        {
          if (localObject1 != null) {
            break label136;
          }
          localObject1 = new ArrayList();
        }
      }
    }
    label136:
    for (;;)
    {
      ((ArrayList)localObject1).add(localh.JV.keyAt(i));
      localObject2 = localObject1;
      i += 1;
      localObject1 = localObject2;
      break;
      this.hA.clear();
      if (localObject1 != null) {
        this.hA.addAll((Collection)localObject1);
      }
      return this.hA;
    }
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    r(false);
    if (this.hI)
    {
      if (this.hH == null) {
        this.hH = new CoordinatorLayout.e(this);
      }
      getViewTreeObserver().addOnPreDrawListener(this.hH);
    }
    if ((this.ev == null) && (q.ae(this))) {
      q.ad(this);
    }
    this.hD = true;
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    r(false);
    if ((this.hI) && (this.hH != null)) {
      getViewTreeObserver().removeOnPreDrawListener(this.hH);
    }
    if (this.hG != null) {
      onStopNestedScroll(this.hG);
    }
    this.hD = false;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.hJ) && (this.hK != null)) {
      if (this.ev == null) {
        break label61;
      }
    }
    label61:
    for (int i = this.ev.getSystemWindowInsetTop();; i = 0)
    {
      if (i > 0)
      {
        this.hK.setBounds(0, 0, getWidth(), i);
        this.hK.draw(paramCanvas);
      }
      return;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i == 0) {
      r(true);
    }
    boolean bool = a(paramMotionEvent, 0);
    if ((i == 1) || (i == 3)) {
      r(true);
    }
    return bool;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = q.Q(this);
    paramInt3 = this.hx.size();
    paramInt1 = 0;
    while (paramInt1 < paramInt3)
    {
      View localView = (View)this.hx.get(paramInt1);
      if (localView.getVisibility() != 8)
      {
        CoordinatorLayout.Behavior localBehavior = ((CoordinatorLayout.d)localView.getLayoutParams()).hP;
        if ((localBehavior == null) || (!localBehavior.a(this, localView, paramInt2))) {
          e(localView, paramInt2);
        }
      }
      paramInt1 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    aF();
    int k = getChildCount();
    int i = 0;
    View localView;
    Object localObject1;
    int m;
    int j;
    label44:
    Object localObject2;
    if (i < k)
    {
      localView = getChildAt(i);
      localObject1 = this.hy;
      m = ((h)localObject1).JV.size();
      j = 0;
      if (j < m)
      {
        localObject2 = (ArrayList)((h)localObject1).JV.valueAt(j);
        if ((localObject2 != null) && (((ArrayList)localObject2).contains(localView)))
        {
          j = 1;
          label84:
          if (j == 0) {
            break label618;
          }
        }
      }
    }
    for (int i17 = 1;; i17 = 0)
    {
      label148:
      int i5;
      int n;
      label187:
      int i1;
      label242:
      int i2;
      label256:
      int i3;
      int i4;
      int i15;
      if (i17 != this.hI)
      {
        if (i17 != 0)
        {
          if (this.hD)
          {
            if (this.hH == null) {
              this.hH = new CoordinatorLayout.e(this);
            }
            getViewTreeObserver().addOnPreDrawListener(this.hH);
          }
          this.hI = true;
        }
      }
      else
      {
        i5 = getPaddingLeft();
        int i6 = getPaddingTop();
        int i7 = getPaddingRight();
        int i8 = getPaddingBottom();
        int i9 = q.Q(this);
        if (i9 != 1) {
          break label658;
        }
        n = 1;
        int i10 = View.MeasureSpec.getMode(paramInt1);
        int i11 = View.MeasureSpec.getSize(paramInt1);
        int i12 = View.MeasureSpec.getMode(paramInt2);
        int i13 = View.MeasureSpec.getSize(paramInt2);
        k = getSuggestedMinimumWidth();
        j = getSuggestedMinimumHeight();
        i = 0;
        if ((this.ev == null) || (!q.ae(this))) {
          break label664;
        }
        i1 = 1;
        int i14 = this.hx.size();
        i2 = 0;
        if (i2 >= i14) {
          break label714;
        }
        localView = (View)this.hx.get(i2);
        if (localView.getVisibility() == 8) {
          break label749;
        }
        localObject1 = (CoordinatorLayout.d)localView.getLayoutParams();
        i3 = 0;
        m = i3;
        if (((CoordinatorLayout.d)localObject1).hR >= 0)
        {
          m = i3;
          if (i10 != 0)
          {
            i4 = E(((CoordinatorLayout.d)localObject1).hR);
            i15 = d.getAbsoluteGravity(G(((CoordinatorLayout.d)localObject1).gravity), i9) & 0x7;
            if (((i15 != 3) || (n != 0)) && ((i15 != 5) || (n == 0))) {
              break label670;
            }
            m = Math.max(0, i11 - i7 - i4);
          }
        }
        label388:
        if ((i1 == 0) || (q.ae(localView))) {
          break label740;
        }
        i3 = this.ev.getSystemWindowInsetLeft();
        int i16 = this.ev.getSystemWindowInsetRight();
        i4 = this.ev.getSystemWindowInsetTop();
        i15 = this.ev.getSystemWindowInsetBottom();
        i3 = View.MeasureSpec.makeMeasureSpec(i11 - (i3 + i16), i10);
        i4 = View.MeasureSpec.makeMeasureSpec(i13 - (i4 + i15), i12);
        label467:
        localObject2 = ((CoordinatorLayout.d)localObject1).hP;
        if ((localObject2 == null) || (!((CoordinatorLayout.Behavior)localObject2).a(this, localView, i3, m, i4, 0))) {
          a(localView, i3, m, i4, 0);
        }
        m = Math.max(k, localView.getMeasuredWidth() + (i5 + i7) + ((CoordinatorLayout.d)localObject1).leftMargin + ((CoordinatorLayout.d)localObject1).rightMargin);
        j = Math.max(j, localView.getMeasuredHeight() + (i6 + i8) + ((CoordinatorLayout.d)localObject1).topMargin + ((CoordinatorLayout.d)localObject1).bottomMargin);
        k = View.combineMeasuredStates(i, localView.getMeasuredState());
      }
      for (i = m;; i = m)
      {
        i2 += 1;
        m = i;
        i = k;
        k = m;
        break label256;
        j += 1;
        break label44;
        j = 0;
        break label84;
        label618:
        i += 1;
        break;
        if ((this.hD) && (this.hH != null)) {
          getViewTreeObserver().removeOnPreDrawListener(this.hH);
        }
        this.hI = false;
        break label148;
        label658:
        n = 0;
        break label187;
        label664:
        i1 = 0;
        break label242;
        label670:
        if ((i15 != 5) || (n != 0))
        {
          m = i3;
          if (i15 != 3) {
            break label388;
          }
          m = i3;
          if (n == 0) {
            break label388;
          }
        }
        m = Math.max(0, i4 - i5);
        break label388;
        label714:
        setMeasuredDimension(View.resolveSizeAndState(k, paramInt1, 0xFF000000 & i), View.resolveSizeAndState(j, paramInt2, i << 16));
        return;
        label740:
        i4 = paramInt2;
        i3 = paramInt1;
        break label467;
        label749:
        m = k;
        k = i;
      }
    }
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      paramView = getChildAt(i);
      if (paramView.getVisibility() != 8) {
        paramView.getLayoutParams();
      }
      i += 1;
    }
    return false;
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    int j = getChildCount();
    int i = 0;
    boolean bool = false;
    if (i < j)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 8) {
        break label96;
      }
      Object localObject = (CoordinatorLayout.d)localView.getLayoutParams();
      if (!((CoordinatorLayout.d)localObject).I(0)) {
        break label96;
      }
      localObject = ((CoordinatorLayout.d)localObject).hP;
      if (localObject == null) {
        break label96;
      }
      bool = ((CoordinatorLayout.Behavior)localObject).a(this, localView, paramView, paramFloat1, paramFloat2) | bool;
    }
    label96:
    for (;;)
    {
      i += 1;
      break;
      return bool;
    }
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    a(paramView, paramInt1, paramInt2, paramArrayOfInt, 0);
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    h(paramInt4, 0);
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    h(paramView2, paramInt);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof CoordinatorLayout.SavedState)) {
      super.onRestoreInstanceState(paramParcelable);
    }
    for (;;)
    {
      return;
      paramParcelable = (CoordinatorLayout.SavedState)paramParcelable;
      super.onRestoreInstanceState(paramParcelable.EA);
      paramParcelable = paramParcelable.ig;
      int j = getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = getChildAt(i);
        int k = localView.getId();
        CoordinatorLayout.Behavior localBehavior = m(localView).hP;
        if ((k != -1) && (localBehavior != null))
        {
          Parcelable localParcelable = (Parcelable)paramParcelable.get(k);
          if (localParcelable != null) {
            localBehavior.a(this, localView, localParcelable);
          }
        }
        i += 1;
      }
    }
  }
  
  protected Parcelable onSaveInstanceState()
  {
    CoordinatorLayout.SavedState localSavedState = new CoordinatorLayout.SavedState(super.onSaveInstanceState());
    SparseArray localSparseArray = new SparseArray();
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = getChildAt(i);
      int k = ((View)localObject).getId();
      CoordinatorLayout.Behavior localBehavior = ((CoordinatorLayout.d)((View)localObject).getLayoutParams()).hP;
      if ((k != -1) && (localBehavior != null))
      {
        localObject = localBehavior.b(this, (View)localObject);
        if (localObject != null) {
          localSparseArray.append(k, localObject);
        }
      }
      i += 1;
    }
    localSavedState.ig = localSparseArray;
    return localSavedState;
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    return c(paramView1, paramInt, 0);
  }
  
  public void onStopNestedScroll(View paramView)
  {
    i(paramView, 0);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    boolean bool2;
    if (this.hF == null)
    {
      bool2 = a(paramMotionEvent, 1);
      if (!bool2) {}
    }
    for (;;)
    {
      CoordinatorLayout.Behavior localBehavior = ((CoordinatorLayout.d)this.hF.getLayoutParams()).hP;
      boolean bool1;
      if (localBehavior != null) {
        bool1 = localBehavior.b(this, this.hF, paramMotionEvent);
      }
      for (;;)
      {
        if (this.hF == null)
        {
          bool1 |= super.onTouchEvent(paramMotionEvent);
          paramMotionEvent = null;
        }
        for (;;)
        {
          if (paramMotionEvent != null) {
            paramMotionEvent.recycle();
          }
          if ((i == 1) || (i == 3)) {
            r(false);
          }
          return bool1;
          if (bool2)
          {
            long l = SystemClock.uptimeMillis();
            paramMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
            super.onTouchEvent(paramMotionEvent);
          }
          else
          {
            paramMotionEvent = null;
          }
        }
        bool1 = false;
        continue;
        bool1 = false;
      }
      bool2 = false;
    }
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    CoordinatorLayout.Behavior localBehavior = ((CoordinatorLayout.d)paramView.getLayoutParams()).hP;
    if ((localBehavior != null) && (localBehavior.a(this, paramView, paramRect, paramBoolean))) {
      return true;
    }
    return super.requestChildRectangleOnScreen(paramView, paramRect, paramBoolean);
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    super.requestDisallowInterceptTouchEvent(paramBoolean);
    if ((paramBoolean) && (!this.hC))
    {
      r(false);
      this.hC = true;
    }
  }
  
  public void setFitsSystemWindows(boolean paramBoolean)
  {
    super.setFitsSystemWindows(paramBoolean);
    aG();
  }
  
  public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener paramOnHierarchyChangeListener)
  {
    this.hL = paramOnHierarchyChangeListener;
  }
  
  public void setStatusBarBackground(Drawable paramDrawable)
  {
    Drawable localDrawable = null;
    if (this.hK != paramDrawable)
    {
      if (this.hK != null) {
        this.hK.setCallback(null);
      }
      if (paramDrawable != null) {
        localDrawable = paramDrawable.mutate();
      }
      this.hK = localDrawable;
      if (this.hK != null)
      {
        if (this.hK.isStateful()) {
          this.hK.setState(getDrawableState());
        }
        a.b(this.hK, q.Q(this));
        paramDrawable = this.hK;
        if (getVisibility() != 0) {
          break label114;
        }
      }
    }
    label114:
    for (boolean bool = true;; bool = false)
    {
      paramDrawable.setVisible(bool, false);
      this.hK.setCallback(this);
      q.O(this);
      return;
    }
  }
  
  public void setStatusBarBackgroundColor(int paramInt)
  {
    setStatusBarBackground(new ColorDrawable(paramInt));
  }
  
  public void setStatusBarBackgroundResource(int paramInt)
  {
    if (paramInt != 0) {}
    for (Drawable localDrawable = b.g(getContext(), paramInt);; localDrawable = null)
    {
      setStatusBarBackground(localDrawable);
      return;
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      if ((this.hK != null) && (this.hK.isVisible() != bool)) {
        this.hK.setVisible(bool, false);
      }
      return;
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.hK);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.design.widget.CoordinatorLayout
 * JD-Core Version:    0.7.0.1
 */