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
import android.support.v4.content.b;
import android.support.v4.e.i;
import android.support.v4.e.k.a;
import android.support.v4.e.k.c;
import android.support.v4.e.m;
import android.support.v4.graphics.drawable.a;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.ab;
import android.support.v4.view.d;
import android.support.v4.view.n;
import android.support.v4.view.o;
import android.support.v4.view.p;
import android.support.v4.view.t;
import android.support.v4.widget.h;
import android.support.v4.widget.u;
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
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoordinatorLayout
  extends ViewGroup
  implements n
{
  static final String im;
  static final Class<?>[] io;
  static final ThreadLocal<Map<String, Constructor<CoordinatorLayout.Behavior>>> iq;
  static final Comparator<View> ir;
  private static final k.a<Rect> is;
  ab fu;
  private boolean iA;
  private int[] iB;
  private View iC;
  private View iD;
  private CoordinatorLayout.e iE;
  private boolean iF;
  boolean iG;
  private Drawable iH;
  ViewGroup.OnHierarchyChangeListener iI;
  private p iJ;
  private final o iK = new o(this);
  private final List<View> it = new ArrayList();
  final h<View> iu = new h();
  private final List<View> iw = new ArrayList();
  final List<View> ix = new ArrayList();
  private final int[] iy = new int[2];
  private boolean iz;
  
  static
  {
    Object localObject = CoordinatorLayout.class.getPackage();
    if (localObject != null)
    {
      localObject = ((Package)localObject).getName();
      im = (String)localObject;
      if (Build.VERSION.SDK_INT < 21) {
        break label82;
      }
    }
    label82:
    for (ir = new CoordinatorLayout.f();; ir = null)
    {
      io = new Class[] { Context.class, AttributeSet.class };
      iq = new ThreadLocal();
      is = new k.c(12);
      return;
      localObject = null;
      break;
    }
  }
  
  public CoordinatorLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130771981);
  }
  
  public CoordinatorLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (paramInt == 0) {}
    for (paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.CoordinatorLayout, 0, 2131493845);; paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.CoordinatorLayout, paramInt, 0))
    {
      paramInt = paramAttributeSet.getResourceId(0, 0);
      if (paramInt == 0) {
        break;
      }
      paramContext = paramContext.getResources();
      this.iB = paramContext.getIntArray(paramInt);
      float f = paramContext.getDisplayMetrics().density;
      int j = this.iB.length;
      paramInt = i;
      while (paramInt < j)
      {
        paramContext = this.iB;
        paramContext[paramInt] = ((int)(paramContext[paramInt] * f));
        paramInt += 1;
      }
    }
    this.iH = paramAttributeSet.getDrawable(1);
    paramAttributeSet.recycle();
    bo();
    super.setOnHierarchyChangeListener(new CoordinatorLayout.c(this));
  }
  
  private int D(int paramInt)
  {
    if (this.iB == null)
    {
      new StringBuilder("No keylines defined for ").append(this).append(" - attempted index lookup ").append(paramInt);
      return 0;
    }
    if ((paramInt < 0) || (paramInt >= this.iB.length))
    {
      new StringBuilder("Keyline index ").append(paramInt).append(" out of range for ").append(this);
      return 0;
    }
    return this.iB[paramInt];
  }
  
  private static int E(int paramInt)
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
  
  private static int F(int paramInt)
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
    label216:
    for (;;)
    {
      try
      {
        paramString = (Map)iq.get();
        if (paramString != null) {
          break label216;
        }
        paramString = new HashMap();
        iq.set(paramString);
        Constructor localConstructor2 = (Constructor)paramString.get(str);
        Constructor localConstructor1 = localConstructor2;
        if (localConstructor2 == null)
        {
          localConstructor1 = paramContext.getClassLoader().loadClass(str).getConstructor(io);
          localConstructor1.setAccessible(true);
          paramString.put(str, localConstructor1);
        }
        paramContext = (CoordinatorLayout.Behavior)localConstructor1.newInstance(new Object[] { paramContext, paramAttributeSet });
        return paramContext;
      }
      catch (Exception paramContext)
      {
        throw new RuntimeException("Could not inflate Behavior subclass ".concat(String.valueOf(str)), paramContext);
      }
      str = paramString;
      if (paramString.indexOf('.') < 0)
      {
        str = paramString;
        if (!TextUtils.isEmpty(im)) {
          str = im + '.' + paramString;
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
    i = d.getAbsoluteGravity(E(paramd.anchorGravity), paramInt1);
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
  
  private void a(View paramView, int paramInt, Rect paramRect1, Rect paramRect2)
  {
    CoordinatorLayout.d locald = (CoordinatorLayout.d)paramView.getLayoutParams();
    int i = paramView.getMeasuredWidth();
    int j = paramView.getMeasuredHeight();
    a(paramInt, paramRect1, paramRect2, locald, i, j);
    a(locald, paramRect2, i, j);
  }
  
  private void a(View paramView1, View paramView2, int paramInt)
  {
    Rect localRect1 = bm();
    Rect localRect2 = bm();
    try
    {
      u.a(this, paramView2, localRect1);
      a(paramView1, paramInt, localRect1, localRect2);
      paramView1.layout(localRect2.left, localRect2.top, localRect2.right, localRect2.bottom);
      return;
    }
    finally
    {
      c(localRect1);
      c(localRect2);
    }
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
      u.a(this, paramView, paramRect);
      return;
    }
    paramRect.set(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
  }
  
  private boolean a(MotionEvent paramMotionEvent, int paramInt)
  {
    boolean bool1 = false;
    int k = 0;
    int m = paramMotionEvent.getActionMasked();
    List localList = this.iw;
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
    if (ir != null) {
      Collections.sort(localList, ir);
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
      localBehavior = locald.iM;
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
          this.iC = localView;
          bool2 = bool1;
        }
        bool1 = bool2;
        if (locald.iM == null) {
          locald.iW = false;
        }
        boolean bool3 = locald.iW;
        if (locald.iW)
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
        bool2 = locald.iW | false;
        locald.iW = bool2;
        break label359;
      }
      bool2 = bool1;
      localList.clear();
      return bool2;
      break label199;
    }
  }
  
  private static Rect bm()
  {
    Rect localRect2 = (Rect)is.acquire();
    Rect localRect1 = localRect2;
    if (localRect2 == null) {
      localRect1 = new Rect();
    }
    return localRect1;
  }
  
  private void bn()
  {
    this.it.clear();
    Object localObject1 = this.iu;
    int j = ((h)localObject1).JB.size();
    int i = 0;
    Object localObject2;
    while (i < j)
    {
      localObject2 = (ArrayList)((h)localObject1).JB.valueAt(i);
      if (localObject2 != null)
      {
        ((ArrayList)localObject2).clear();
        ((h)localObject1).JA.release(localObject2);
      }
      i += 1;
    }
    ((h)localObject1).JB.clear();
    int m = getChildCount();
    j = 0;
    while (j < m)
    {
      View localView1 = getChildAt(j);
      CoordinatorLayout.d locald = n(localView1);
      if (locald.iP == -1)
      {
        locald.iV = null;
        locald.iU = null;
        this.iu.G(localView1);
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
          if (localView2 != locald.iV)
          {
            k = t.T(this);
            int n = d.getAbsoluteGravity(((CoordinatorLayout.d)localView2.getLayoutParams()).iQ, k);
            if ((n != 0) && ((d.getAbsoluteGravity(locald.iR, k) & n) == n))
            {
              k = 1;
              label217:
              if ((k == 0) && ((locald.iM == null) || (!locald.iM.d(localView2)))) {
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
              if (!this.iu.JB.containsKey(localView2)) {
                this.iu.G(localView2);
              }
              h localh = this.iu;
              if ((!localh.JB.containsKey(localView2)) || (!localh.JB.containsKey(localView1)))
              {
                throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
                if (locald.iU != null)
                {
                  if (locald.iU.getId() == locald.iP) {
                    break label398;
                  }
                  i = 0;
                }
                for (;;)
                {
                  if (i != 0) {
                    break label487;
                  }
                  locald.iU = findViewById(locald.iP);
                  if (locald.iU == null) {
                    break label605;
                  }
                  if (locald.iU != this) {
                    break label500;
                  }
                  if (!isInEditMode()) {
                    break label489;
                  }
                  locald.iV = null;
                  locald.iU = null;
                  break;
                  label398:
                  localObject2 = locald.iU;
                  for (localObject1 = locald.iU.getParent();; localObject1 = ((ViewParent)localObject1).getParent())
                  {
                    if (localObject1 == this) {
                      break label477;
                    }
                    if ((localObject1 == null) || (localObject1 == localView1))
                    {
                      locald.iV = null;
                      locald.iU = null;
                      i = 0;
                      break;
                    }
                    if ((localObject1 instanceof View)) {
                      localObject2 = (View)localObject1;
                    }
                  }
                  label477:
                  locald.iV = ((View)localObject2);
                  i = 1;
                }
                label487:
                break;
                label489:
                throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                label500:
                localObject2 = locald.iU;
                for (localObject1 = locald.iU.getParent();; localObject1 = ((ViewParent)localObject1).getParent())
                {
                  if ((localObject1 == this) || (localObject1 == null)) {
                    break label595;
                  }
                  if (localObject1 == localView1)
                  {
                    if (isInEditMode())
                    {
                      locald.iV = null;
                      locald.iU = null;
                      break;
                    }
                    throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                  }
                  if ((localObject1 instanceof View)) {
                    localObject2 = (View)localObject1;
                  }
                }
                label595:
                locald.iV = ((View)localObject2);
                break;
                label605:
                if (isInEditMode())
                {
                  locald.iV = null;
                  locald.iU = null;
                  break;
                }
                throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + getResources().getResourceName(locald.iP) + " to anchor view " + localView1);
                k = 0;
                break label217;
                label679:
                k = 0;
                continue;
              }
              localObject2 = (ArrayList)localh.JB.get(localView2);
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                localObject2 = (ArrayList)localh.JA.acquire();
                localObject1 = localObject2;
                if (localObject2 == null) {
                  localObject1 = new ArrayList();
                }
                localh.JB.put(localView2, localObject1);
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
    this.it.addAll(this.iu.dV());
    Collections.reverse(this.it);
  }
  
  private void bo()
  {
    if (Build.VERSION.SDK_INT < 21) {
      return;
    }
    if (t.al(this))
    {
      if (this.iJ == null) {
        this.iJ = new p()
        {
          public final ab a(View paramAnonymousView, ab paramAnonymousab)
          {
            boolean bool2 = true;
            int i = 0;
            CoordinatorLayout localCoordinatorLayout = CoordinatorLayout.this;
            if (!i.equals(localCoordinatorLayout.fu, paramAnonymousab))
            {
              localCoordinatorLayout.fu = paramAnonymousab;
              if ((paramAnonymousab != null) && (paramAnonymousab.getSystemWindowInsetTop() > 0))
              {
                bool1 = true;
                localCoordinatorLayout.iG = bool1;
                if ((localCoordinatorLayout.iG) || (localCoordinatorLayout.getBackground() != null)) {
                  break label155;
                }
              }
              label155:
              for (boolean bool1 = bool2;; bool1 = false)
              {
                localCoordinatorLayout.setWillNotDraw(bool1);
                if (paramAnonymousab.isConsumed()) {
                  break label171;
                }
                int j = localCoordinatorLayout.getChildCount();
                paramAnonymousView = paramAnonymousab;
                while (i < j)
                {
                  paramAnonymousab = localCoordinatorLayout.getChildAt(i);
                  if ((!t.al(paramAnonymousab)) || (((CoordinatorLayout.d)paramAnonymousab.getLayoutParams()).iM == null)) {
                    break label168;
                  }
                  paramAnonymousab = CoordinatorLayout.Behavior.b(paramAnonymousView);
                  paramAnonymousView = paramAnonymousab;
                  if (paramAnonymousab.isConsumed()) {
                    break;
                  }
                  paramAnonymousView = paramAnonymousab;
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
                paramAnonymousView = paramAnonymousab;
              }
            }
            return paramAnonymousab;
          }
        };
      }
      t.a(this, this.iJ);
      setSystemUiVisibility(1280);
      return;
    }
    t.a(this, null);
  }
  
  private static void c(Rect paramRect)
  {
    paramRect.setEmpty();
    is.release(paramRect);
  }
  
  private void c(View paramView, int paramInt1, int paramInt2)
  {
    CoordinatorLayout.d locald = (CoordinatorLayout.d)paramView.getLayoutParams();
    int i1 = d.getAbsoluteGravity(F(locald.gravity), paramInt2);
    int n = getWidth();
    int m = getHeight();
    int j = paramView.getMeasuredWidth();
    int k = paramView.getMeasuredHeight();
    int i = paramInt1;
    if (paramInt2 == 1) {
      i = n - paramInt1;
    }
    paramInt1 = D(i) - j;
    paramInt2 = 0;
    switch (i1 & 0x7)
    {
    default: 
      switch (i1 & 0x70)
      {
      }
      break;
    }
    for (;;)
    {
      paramInt1 = Math.max(getPaddingLeft() + locald.leftMargin, Math.min(paramInt1, n - getPaddingRight() - j - locald.rightMargin));
      paramInt2 = Math.max(getPaddingTop() + locald.topMargin, Math.min(paramInt2, m - getPaddingBottom() - k - locald.bottomMargin));
      paramView.layout(paramInt1, paramInt2, paramInt1 + j, paramInt2 + k);
      return;
      paramInt1 += j;
      break;
      paramInt1 += j / 2;
      break;
      paramInt2 = k + 0;
      continue;
      paramInt2 = k / 2 + 0;
    }
  }
  
  private void f(View paramView, int paramInt)
  {
    CoordinatorLayout.d locald = (CoordinatorLayout.d)paramView.getLayoutParams();
    Rect localRect1 = bm();
    localRect1.set(getPaddingLeft() + locald.leftMargin, getPaddingTop() + locald.topMargin, getWidth() - getPaddingRight() - locald.rightMargin, getHeight() - getPaddingBottom() - locald.bottomMargin);
    if ((this.fu != null) && (t.al(this)) && (!t.al(paramView)))
    {
      localRect1.left += this.fu.getSystemWindowInsetLeft();
      localRect1.top += this.fu.getSystemWindowInsetTop();
      localRect1.right -= this.fu.getSystemWindowInsetRight();
      localRect1.bottom -= this.fu.getSystemWindowInsetBottom();
    }
    Rect localRect2 = bm();
    d.apply(E(locald.gravity), paramView.getMeasuredWidth(), paramView.getMeasuredHeight(), localRect1, localRect2, paramInt);
    paramView.layout(localRect2.left, localRect2.top, localRect2.right, localRect2.bottom);
    c(localRect1);
    c(localRect2);
  }
  
  private static void g(View paramView, int paramInt)
  {
    CoordinatorLayout.d locald = (CoordinatorLayout.d)paramView.getLayoutParams();
    if (locald.iS != paramInt)
    {
      t.s(paramView, paramInt - locald.iS);
      locald.iS = paramInt;
    }
  }
  
  private static void h(View paramView, int paramInt)
  {
    CoordinatorLayout.d locald = (CoordinatorLayout.d)paramView.getLayoutParams();
    if (locald.iT != paramInt)
    {
      t.q(paramView, paramInt - locald.iT);
      locald.iT = paramInt;
    }
  }
  
  private static CoordinatorLayout.d n(View paramView)
  {
    CoordinatorLayout.d locald = (CoordinatorLayout.d)paramView.getLayoutParams();
    if (!locald.iN)
    {
      if ((paramView instanceof CoordinatorLayout.a))
      {
        locald.a(((CoordinatorLayout.a)paramView).bp());
        locald.iN = true;
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
      locald.iN = true;
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
  
  private void q(boolean paramBoolean)
  {
    int j = getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = getChildAt(i);
      CoordinatorLayout.Behavior localBehavior = ((CoordinatorLayout.d)localView.getLayoutParams()).iM;
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
      ((CoordinatorLayout.d)getChildAt(i).getLayoutParams()).iW = false;
      i += 1;
    }
    this.iC = null;
    this.iz = false;
  }
  
  final void G(int paramInt)
  {
    int m = t.T(this);
    int n = this.it.size();
    Rect localRect1 = bm();
    Rect localRect2 = bm();
    Rect localRect3 = bm();
    int j = 0;
    View localView;
    Object localObject1;
    int i;
    Object localObject2;
    Object localObject3;
    if (j < n)
    {
      localView = (View)this.it.get(j);
      localObject1 = (CoordinatorLayout.d)localView.getLayoutParams();
      if ((paramInt != 0) || (localView.getVisibility() != 8))
      {
        i = 0;
        int i1;
        int i2;
        int k;
        if (i < j)
        {
          localObject2 = (View)this.it.get(i);
          Rect localRect5;
          if (((CoordinatorLayout.d)localObject1).iV == localObject2)
          {
            localObject2 = (CoordinatorLayout.d)localView.getLayoutParams();
            if (((CoordinatorLayout.d)localObject2).iU != null)
            {
              localObject3 = bm();
              localRect4 = bm();
              localRect5 = bm();
              u.a(this, ((CoordinatorLayout.d)localObject2).iU, (Rect)localObject3);
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
              t.s(localView, i1);
            }
            if (i2 != 0) {
              t.q(localView, i2);
            }
            if (k != 0)
            {
              CoordinatorLayout.Behavior localBehavior = ((CoordinatorLayout.d)localObject2).iM;
              if (localBehavior != null) {
                localBehavior.a(this, localView, ((CoordinatorLayout.d)localObject2).iU);
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
        if ((((CoordinatorLayout.d)localObject1).iQ != 0) && (!localRect2.isEmpty()))
        {
          i = d.getAbsoluteGravity(((CoordinatorLayout.d)localObject1).iQ, m);
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
          if ((((CoordinatorLayout.d)localObject1).iR != 0) && (localView.getVisibility() == 0) && (t.as(localView)) && (localView.getWidth() > 0) && (localView.getHeight() > 0)) {
            break label703;
          }
          label480:
          if (paramInt != 2)
          {
            localRect3.set(((CoordinatorLayout.d)localView.getLayoutParams()).ja);
            if (localRect3.equals(localRect2)) {
              break label1197;
            }
            ((CoordinatorLayout.d)localView.getLayoutParams()).ja.set(localRect2);
          }
          i = j + 1;
          for (;;)
          {
            if (i >= n) {
              break label1197;
            }
            localObject1 = (View)this.it.get(i);
            localObject2 = (CoordinatorLayout.d)((View)localObject1).getLayoutParams();
            localObject3 = ((CoordinatorLayout.d)localObject2).iM;
            if ((localObject3 != null) && (((CoordinatorLayout.Behavior)localObject3).d(localView)))
            {
              if ((paramInt != 0) || (!((CoordinatorLayout.d)localObject2).iZ)) {
                break;
              }
              ((CoordinatorLayout.d)localObject2).iZ = false;
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
        localObject2 = ((CoordinatorLayout.d)localObject1).iM;
        localObject3 = bm();
        Rect localRect4 = bm();
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
          i1 = d.getAbsoluteGravity(((CoordinatorLayout.d)localObject1).iR, m);
          k = 0;
          i = k;
          if ((i1 & 0x30) == 48)
          {
            i2 = ((Rect)localObject3).top - ((CoordinatorLayout.d)localObject1).topMargin - ((CoordinatorLayout.d)localObject1).iT;
            i = k;
            if (i2 < localRect1.top)
            {
              h(localView, localRect1.top - i2);
              i = 1;
            }
          }
          k = i;
          if ((i1 & 0x50) == 80)
          {
            i2 = getHeight() - ((Rect)localObject3).bottom - ((CoordinatorLayout.d)localObject1).bottomMargin + ((CoordinatorLayout.d)localObject1).iT;
            k = i;
            if (i2 < localRect1.bottom)
            {
              h(localView, i2 - localRect1.bottom);
              k = 1;
            }
          }
          if (k == 0) {
            h(localView, 0);
          }
          k = 0;
          i = k;
          if ((i1 & 0x3) == 3)
          {
            i2 = ((Rect)localObject3).left - ((CoordinatorLayout.d)localObject1).leftMargin - ((CoordinatorLayout.d)localObject1).iS;
            i = k;
            if (i2 < localRect1.left)
            {
              g(localView, localRect1.left - i2);
              i = 1;
            }
          }
          if ((i1 & 0x5) != 5) {
            break label1220;
          }
          k = getWidth();
          i1 = ((Rect)localObject3).right;
          i2 = ((CoordinatorLayout.d)localObject1).rightMargin;
          k = ((CoordinatorLayout.d)localObject1).iS + (k - i1 - i2);
          if (k >= localRect1.right) {
            break label1220;
          }
          g(localView, k - localRect1.right);
          i = 1;
        }
      }
    }
    label1197:
    label1220:
    for (;;)
    {
      if (i == 0) {
        g(localView, 0);
      }
      c((Rect)localObject3);
      break label480;
      switch (paramInt)
      {
      }
      for (boolean bool = ((CoordinatorLayout.Behavior)localObject3).a(this, (View)localObject1, localView); paramInt == 1; bool = true)
      {
        ((CoordinatorLayout.d)localObject2).iZ = bool;
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
      if (!((CoordinatorLayout.d)localObject).H(paramInt3)) {
        break label238;
      }
      localObject = ((CoordinatorLayout.d)localObject).iM;
      if (localObject == null) {
        break label238;
      }
      int[] arrayOfInt = this.iy;
      this.iy[1] = 0;
      arrayOfInt[0] = 0;
      ((CoordinatorLayout.Behavior)localObject).a(this, localView, paramView, paramInt2, this.iy, paramInt3);
      if (paramInt1 > 0)
      {
        j = Math.max(j, this.iy[0]);
        if (paramInt2 <= 0) {
          break label199;
        }
        k = Math.max(i, this.iy[1]);
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
      j = Math.min(j, this.iy[0]);
      break label126;
      label199:
      k = Math.min(i, this.iy[1]);
      break label143;
      paramArrayOfInt[0] = j;
      paramArrayOfInt[1] = i;
      if (k != 0) {
        G(1);
      }
      return;
      label238:
      n = i;
      i = j;
      j = n;
      n = k;
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof CoordinatorLayout.d)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  public final boolean d(View paramView, int paramInt1, int paramInt2)
  {
    Rect localRect = bm();
    u.a(this, paramView, localRect);
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
    Drawable localDrawable = this.iH;
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
    CoordinatorLayout.d locald = (CoordinatorLayout.d)paramView.getLayoutParams();
    if (locald.bq()) {
      throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
    }
    if (locald.iU != null)
    {
      a(paramView, locald.iU, paramInt);
      return;
    }
    if (locald.iO >= 0)
    {
      c(paramView, locald.iO, paramInt);
      return;
    }
    f(paramView, paramInt);
  }
  
  public final boolean e(View paramView, int paramInt1, int paramInt2)
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
        CoordinatorLayout.Behavior localBehavior = locald.iM;
        if (localBehavior != null)
        {
          boolean bool2 = localBehavior.a(this, localView, paramView, paramInt1, paramInt2);
          bool1 |= bool2;
          locald.e(paramInt2, bool2);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        locald.e(paramInt2, false);
      }
    }
    return bool1;
  }
  
  public final void f(View paramView, int paramInt1, int paramInt2)
  {
    this.iK.Gd = paramInt1;
    this.iD = paramView;
    paramInt2 = getChildCount();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      getChildAt(paramInt1).getLayoutParams();
      paramInt1 += 1;
    }
  }
  
  final List<View> getDependencySortedChildren()
  {
    bn();
    return Collections.unmodifiableList(this.it);
  }
  
  public final ab getLastWindowInsets()
  {
    return this.fu;
  }
  
  public int getNestedScrollAxes()
  {
    return this.iK.Gd;
  }
  
  public Drawable getStatusBarBackground()
  {
    return this.iH;
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
      if (!((CoordinatorLayout.d)localObject).H(paramInt2)) {
        break label97;
      }
      localObject = ((CoordinatorLayout.d)localObject).iM;
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
        G(1);
      }
      return;
    }
  }
  
  public final void i(View paramView, int paramInt)
  {
    this.iK.Gd = 0;
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      CoordinatorLayout.d locald = (CoordinatorLayout.d)localView.getLayoutParams();
      if (locald.H(paramInt))
      {
        CoordinatorLayout.Behavior localBehavior = locald.iM;
        if (localBehavior != null) {
          localBehavior.a(this, localView, paramView, paramInt);
        }
        locald.e(paramInt, false);
        locald.iZ = false;
      }
      i += 1;
    }
    this.iD = null;
  }
  
  public final List<View> o(View paramView)
  {
    paramView = this.iu.I(paramView);
    this.ix.clear();
    if (paramView != null) {
      this.ix.addAll(paramView);
    }
    return this.ix;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    q(false);
    if (this.iF)
    {
      if (this.iE == null) {
        this.iE = new CoordinatorLayout.e(this);
      }
      getViewTreeObserver().addOnPreDrawListener(this.iE);
    }
    if ((this.fu == null) && (t.al(this))) {
      t.ak(this);
    }
    this.iA = true;
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    q(false);
    if ((this.iF) && (this.iE != null)) {
      getViewTreeObserver().removeOnPreDrawListener(this.iE);
    }
    if (this.iD != null) {
      onStopNestedScroll(this.iD);
    }
    this.iA = false;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.iG) && (this.iH != null)) {
      if (this.fu == null) {
        break label61;
      }
    }
    label61:
    for (int i = this.fu.getSystemWindowInsetTop();; i = 0)
    {
      if (i > 0)
      {
        this.iH.setBounds(0, 0, getWidth(), i);
        this.iH.draw(paramCanvas);
      }
      return;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i == 0) {
      q(true);
    }
    boolean bool = a(paramMotionEvent, 0);
    if ((i == 1) || (i == 3)) {
      q(true);
    }
    return bool;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = t.T(this);
    paramInt3 = this.it.size();
    paramInt1 = 0;
    while (paramInt1 < paramInt3)
    {
      View localView = (View)this.it.get(paramInt1);
      if (localView.getVisibility() != 8)
      {
        CoordinatorLayout.Behavior localBehavior = ((CoordinatorLayout.d)localView.getLayoutParams()).iM;
        if ((localBehavior == null) || (!localBehavior.a(this, localView, paramInt2))) {
          e(localView, paramInt2);
        }
      }
      paramInt1 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    bn();
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
      localObject1 = this.iu;
      m = ((h)localObject1).JB.size();
      j = 0;
      if (j < m)
      {
        localObject2 = (ArrayList)((h)localObject1).JB.valueAt(j);
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
      if (i17 != this.iF)
      {
        if (i17 != 0)
        {
          if (this.iA)
          {
            if (this.iE == null) {
              this.iE = new CoordinatorLayout.e(this);
            }
            getViewTreeObserver().addOnPreDrawListener(this.iE);
          }
          this.iF = true;
        }
      }
      else
      {
        i5 = getPaddingLeft();
        int i6 = getPaddingTop();
        int i7 = getPaddingRight();
        int i8 = getPaddingBottom();
        int i9 = t.T(this);
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
        if ((this.fu == null) || (!t.al(this))) {
          break label664;
        }
        i1 = 1;
        int i14 = this.it.size();
        i2 = 0;
        if (i2 >= i14) {
          break label714;
        }
        localView = (View)this.it.get(i2);
        if (localView.getVisibility() == 8) {
          break label749;
        }
        localObject1 = (CoordinatorLayout.d)localView.getLayoutParams();
        i3 = 0;
        m = i3;
        if (((CoordinatorLayout.d)localObject1).iO >= 0)
        {
          m = i3;
          if (i10 != 0)
          {
            i4 = D(((CoordinatorLayout.d)localObject1).iO);
            i15 = d.getAbsoluteGravity(F(((CoordinatorLayout.d)localObject1).gravity), i9) & 0x7;
            if (((i15 != 3) || (n != 0)) && ((i15 != 5) || (n == 0))) {
              break label670;
            }
            m = Math.max(0, i11 - i7 - i4);
          }
        }
        label388:
        if ((i1 == 0) || (t.al(localView))) {
          break label740;
        }
        i3 = this.fu.getSystemWindowInsetLeft();
        int i16 = this.fu.getSystemWindowInsetRight();
        i4 = this.fu.getSystemWindowInsetTop();
        i15 = this.fu.getSystemWindowInsetBottom();
        i3 = View.MeasureSpec.makeMeasureSpec(i11 - (i3 + i16), i10);
        i4 = View.MeasureSpec.makeMeasureSpec(i13 - (i4 + i15), i12);
        label467:
        localObject2 = ((CoordinatorLayout.d)localObject1).iM;
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
        if ((this.iA) && (this.iE != null)) {
          getViewTreeObserver().removeOnPreDrawListener(this.iE);
        }
        this.iF = false;
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
      if (!((CoordinatorLayout.d)localObject).H(0)) {
        break label96;
      }
      localObject = ((CoordinatorLayout.d)localObject).iM;
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
    f(paramView2, paramInt, 0);
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
      super.onRestoreInstanceState(paramParcelable.Fo);
      paramParcelable = paramParcelable.jc;
      int j = getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = getChildAt(i);
        int k = localView.getId();
        CoordinatorLayout.Behavior localBehavior = n(localView).iM;
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
      CoordinatorLayout.Behavior localBehavior = ((CoordinatorLayout.d)((View)localObject).getLayoutParams()).iM;
      if ((k != -1) && (localBehavior != null))
      {
        localObject = localBehavior.b(this, (View)localObject);
        if (localObject != null) {
          localSparseArray.append(k, localObject);
        }
      }
      i += 1;
    }
    localSavedState.jc = localSparseArray;
    return localSavedState;
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    return e(paramView1, paramInt, 0);
  }
  
  public void onStopNestedScroll(View paramView)
  {
    i(paramView, 0);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    boolean bool2;
    if (this.iC == null)
    {
      bool2 = a(paramMotionEvent, 1);
      if (!bool2) {}
    }
    for (;;)
    {
      CoordinatorLayout.Behavior localBehavior = ((CoordinatorLayout.d)this.iC.getLayoutParams()).iM;
      boolean bool1;
      if (localBehavior != null) {
        bool1 = localBehavior.b(this, this.iC, paramMotionEvent);
      }
      for (;;)
      {
        if (this.iC == null)
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
            q(false);
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
    CoordinatorLayout.Behavior localBehavior = ((CoordinatorLayout.d)paramView.getLayoutParams()).iM;
    if ((localBehavior != null) && (localBehavior.a(this, paramView, paramRect, paramBoolean))) {
      return true;
    }
    return super.requestChildRectangleOnScreen(paramView, paramRect, paramBoolean);
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    super.requestDisallowInterceptTouchEvent(paramBoolean);
    if ((paramBoolean) && (!this.iz))
    {
      q(false);
      this.iz = true;
    }
  }
  
  public void setFitsSystemWindows(boolean paramBoolean)
  {
    super.setFitsSystemWindows(paramBoolean);
    bo();
  }
  
  public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener paramOnHierarchyChangeListener)
  {
    this.iI = paramOnHierarchyChangeListener;
  }
  
  public void setStatusBarBackground(Drawable paramDrawable)
  {
    Drawable localDrawable = null;
    if (this.iH != paramDrawable)
    {
      if (this.iH != null) {
        this.iH.setCallback(null);
      }
      if (paramDrawable != null) {
        localDrawable = paramDrawable.mutate();
      }
      this.iH = localDrawable;
      if (this.iH != null)
      {
        if (this.iH.isStateful()) {
          this.iH.setState(getDrawableState());
        }
        a.b(this.iH, t.T(this));
        paramDrawable = this.iH;
        if (getVisibility() != 0) {
          break label114;
        }
      }
    }
    label114:
    for (boolean bool = true;; bool = false)
    {
      paramDrawable.setVisible(bool, false);
      this.iH.setCallback(this);
      t.R(this);
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
    for (Drawable localDrawable = b.k(getContext(), paramInt);; localDrawable = null)
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
      if ((this.iH != null) && (this.iH.isVisible() != bool)) {
        this.iH.setVisible(bool, false);
      }
      return;
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.iH);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.design.widget.CoordinatorLayout
 * JD-Core Version:    0.7.0.1
 */