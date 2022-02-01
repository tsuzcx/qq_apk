package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.c.a.a;
import android.support.v4.content.b;
import android.support.v4.e.j;
import android.support.v4.e.l.a;
import android.support.v4.e.l.c;
import android.support.v4.graphics.drawable.a;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.ab;
import android.support.v4.view.d;
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
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoordinatorLayout
  extends ViewGroup
  implements android.support.v4.view.n
{
  static final String oh;
  static final Class<?>[] oi;
  static final ThreadLocal<Map<String, Constructor<Behavior>>> oj;
  static final Comparator<View> ok;
  private static final l.a<Rect> ol;
  ab oA;
  boolean oB;
  private Drawable oC;
  ViewGroup.OnHierarchyChangeListener oD;
  private p oE;
  private final o oF = new o(this);
  private final List<View> om = new ArrayList();
  private final h<View> oo = new h();
  private final List<View> oq = new ArrayList();
  private final List<View> or = new ArrayList();
  private final int[] os = new int[2];
  private boolean ot;
  private boolean ou;
  private int[] ov;
  private View ow;
  private View ox;
  private e oy;
  private boolean oz;
  
  static
  {
    Object localObject = CoordinatorLayout.class.getPackage();
    if (localObject != null)
    {
      localObject = ((Package)localObject).getName();
      oh = (String)localObject;
      if (Build.VERSION.SDK_INT < 21) {
        break label82;
      }
    }
    label82:
    for (ok = new f();; ok = null)
    {
      oi = new Class[] { Context.class, AttributeSet.class };
      oj = new ThreadLocal();
      ol = new l.c(12);
      return;
      localObject = null;
      break;
    }
  }
  
  public CoordinatorLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130968890);
  }
  
  public CoordinatorLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (paramInt == 0) {}
    for (paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.CoordinatorLayout, 0, 2131821680);; paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.CoordinatorLayout, paramInt, 0))
    {
      paramInt = paramAttributeSet.getResourceId(0, 0);
      if (paramInt == 0) {
        break;
      }
      paramContext = paramContext.getResources();
      this.ov = paramContext.getIntArray(paramInt);
      float f = paramContext.getDisplayMetrics().density;
      int j = this.ov.length;
      paramInt = i;
      while (paramInt < j)
      {
        paramContext = this.ov;
        paramContext[paramInt] = ((int)(paramContext[paramInt] * f));
        paramInt += 1;
      }
    }
    this.oC = paramAttributeSet.getDrawable(1);
    paramAttributeSet.recycle();
    cf();
    super.setOnHierarchyChangeListener(new c());
  }
  
  private int T(int paramInt)
  {
    if (this.ov == null)
    {
      new StringBuilder("No keylines defined for ").append(this).append(" - attempted index lookup ").append(paramInt);
      return 0;
    }
    if ((paramInt < 0) || (paramInt >= this.ov.length))
    {
      new StringBuilder("Keyline index ").append(paramInt).append(" out of range for ").append(this);
      return 0;
    }
    return this.ov[paramInt];
  }
  
  private static int U(int paramInt)
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
  
  private static int V(int paramInt)
  {
    int i = paramInt;
    if (paramInt == 0) {
      i = 8388661;
    }
    return i;
  }
  
  static Behavior a(Context paramContext, AttributeSet paramAttributeSet, String paramString)
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
        paramString = (Map)oj.get();
        if (paramString != null) {
          break label216;
        }
        paramString = new HashMap();
        oj.set(paramString);
        Constructor localConstructor2 = (Constructor)paramString.get(str);
        Constructor localConstructor1 = localConstructor2;
        if (localConstructor2 == null)
        {
          localConstructor1 = paramContext.getClassLoader().loadClass(str).getConstructor(oi);
          localConstructor1.setAccessible(true);
          paramString.put(str, localConstructor1);
        }
        paramContext = (Behavior)localConstructor1.newInstance(new Object[] { paramContext, paramAttributeSet });
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
        if (!TextUtils.isEmpty(oh)) {
          str = oh + '.' + paramString;
        }
      }
    }
  }
  
  private static void a(int paramInt1, Rect paramRect1, Rect paramRect2, d paramd, int paramInt2, int paramInt3)
  {
    int j = paramd.gravity;
    int i = j;
    if (j == 0) {
      i = 17;
    }
    int k = d.getAbsoluteGravity(i, paramInt1);
    i = d.getAbsoluteGravity(U(paramd.anchorGravity), paramInt1);
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
  
  private static void a(Rect paramRect)
  {
    paramRect.setEmpty();
    ol.release(paramRect);
  }
  
  private void a(d paramd, Rect paramRect, int paramInt1, int paramInt2)
  {
    int j = getWidth();
    int i = getHeight();
    j = Math.max(getPaddingLeft() + paramd.leftMargin, Math.min(paramRect.left, j - getPaddingRight() - paramInt1 - paramd.rightMargin));
    i = Math.max(getPaddingTop() + paramd.topMargin, Math.min(paramRect.top, i - getPaddingBottom() - paramInt2 - paramd.bottomMargin));
    paramRect.set(j, i, j + paramInt1, i + paramInt2);
  }
  
  private void a(View paramView, int paramInt, Rect paramRect1, Rect paramRect2)
  {
    d locald = (d)paramView.getLayoutParams();
    int i = paramView.getMeasuredWidth();
    int j = paramView.getMeasuredHeight();
    a(paramInt, paramRect1, paramRect2, locald, i, j);
    a(locald, paramRect2, i, j);
  }
  
  private void a(View paramView1, View paramView2, int paramInt)
  {
    Rect localRect1 = cd();
    Rect localRect2 = cd();
    try
    {
      u.a(this, paramView2, localRect1);
      a(paramView1, paramInt, localRect1, localRect2);
      paramView1.layout(localRect2.left, localRect2.top, localRect2.right, localRect2.bottom);
      return;
    }
    finally
    {
      a(localRect1);
      a(localRect2);
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
    List localList = this.oq;
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
    if (ok != null) {
      Collections.sort(localList, ok);
    }
    n = localList.size();
    int j = 0;
    MotionEvent localMotionEvent = null;
    i = k;
    View localView;
    d locald;
    Behavior localBehavior;
    if (j < n)
    {
      localView = (View)localList.get(j);
      locald = (d)localView.getLayoutParams();
      localBehavior = locald.oH;
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
      localBehavior.b(this, localView, localMotionEvent);
      continue;
      localBehavior.a(this, localView, localMotionEvent);
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
          this.ow = localView;
          bool2 = bool1;
        }
        bool1 = bool2;
        if (locald.oH == null) {
          locald.oR = false;
        }
        boolean bool3 = locald.oR;
        if (locald.oR)
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
        bool1 = localBehavior.b(this, localView, paramMotionEvent);
        break label304;
        bool1 = localBehavior.a(this, localView, paramMotionEvent);
        break label304;
        bool2 = locald.oR | false;
        locald.oR = bool2;
        break label359;
      }
      bool2 = bool1;
      localList.clear();
      return bool2;
      break label199;
    }
  }
  
  private void c(View paramView, int paramInt1, int paramInt2)
  {
    d locald = (d)paramView.getLayoutParams();
    int i1 = d.getAbsoluteGravity(V(locald.gravity), paramInt2);
    int n = getWidth();
    int m = getHeight();
    int j = paramView.getMeasuredWidth();
    int k = paramView.getMeasuredHeight();
    int i = paramInt1;
    if (paramInt2 == 1) {
      i = n - paramInt1;
    }
    paramInt1 = T(i) - j;
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
  
  private static Rect cd()
  {
    Rect localRect2 = (Rect)ol.acquire();
    Rect localRect1 = localRect2;
    if (localRect2 == null) {
      localRect1 = new Rect();
    }
    return localRect1;
  }
  
  private void ce()
  {
    this.om.clear();
    Object localObject1 = this.oo;
    int j = ((h)localObject1).Rw.size();
    int i = 0;
    Object localObject2;
    while (i < j)
    {
      localObject2 = (ArrayList)((h)localObject1).Rw.valueAt(i);
      if (localObject2 != null)
      {
        ((ArrayList)localObject2).clear();
        ((h)localObject1).Rv.release(localObject2);
      }
      i += 1;
    }
    ((h)localObject1).Rw.clear();
    int m = getChildCount();
    j = 0;
    while (j < m)
    {
      View localView1 = getChildAt(j);
      d locald = q(localView1);
      if (locald.oK == -1)
      {
        locald.oQ = null;
        locald.oP = null;
        this.oo.H(localView1);
        i = 0;
      }
      for (;;)
      {
        if (i >= m) {
          break label771;
        }
        if (i != j)
        {
          View localView2 = getChildAt(i);
          int k;
          if (localView2 != locald.oQ)
          {
            k = t.Y(this);
            int n = d.getAbsoluteGravity(((d)localView2.getLayoutParams()).oL, k);
            if ((n != 0) && ((d.getAbsoluteGravity(locald.oM, k) & n) == n))
            {
              k = 1;
              label217:
              if ((k == 0) && ((locald.oH == null) || (!locald.oH.a(localView1, localView2)))) {
                break label681;
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
              if (!this.oo.Rw.containsKey(localView2)) {
                this.oo.H(localView2);
              }
              h localh = this.oo;
              if ((!localh.Rw.containsKey(localView2)) || (!localh.Rw.containsKey(localView1)))
              {
                throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
                if (locald.oP != null)
                {
                  if (locald.oP.getId() == locald.oK) {
                    break label400;
                  }
                  i = 0;
                }
                for (;;)
                {
                  if (i != 0) {
                    break label489;
                  }
                  locald.oP = findViewById(locald.oK);
                  if (locald.oP == null) {
                    break label607;
                  }
                  if (locald.oP != this) {
                    break label502;
                  }
                  if (!isInEditMode()) {
                    break label491;
                  }
                  locald.oQ = null;
                  locald.oP = null;
                  break;
                  label400:
                  localObject2 = locald.oP;
                  for (localObject1 = locald.oP.getParent();; localObject1 = ((ViewParent)localObject1).getParent())
                  {
                    if (localObject1 == this) {
                      break label479;
                    }
                    if ((localObject1 == null) || (localObject1 == localView1))
                    {
                      locald.oQ = null;
                      locald.oP = null;
                      i = 0;
                      break;
                    }
                    if ((localObject1 instanceof View)) {
                      localObject2 = (View)localObject1;
                    }
                  }
                  label479:
                  locald.oQ = ((View)localObject2);
                  i = 1;
                }
                label489:
                break;
                label491:
                throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                label502:
                localObject2 = locald.oP;
                for (localObject1 = locald.oP.getParent();; localObject1 = ((ViewParent)localObject1).getParent())
                {
                  if ((localObject1 == this) || (localObject1 == null)) {
                    break label597;
                  }
                  if (localObject1 == localView1)
                  {
                    if (isInEditMode())
                    {
                      locald.oQ = null;
                      locald.oP = null;
                      break;
                    }
                    throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                  }
                  if ((localObject1 instanceof View)) {
                    localObject2 = (View)localObject1;
                  }
                }
                label597:
                locald.oQ = ((View)localObject2);
                break;
                label607:
                if (isInEditMode())
                {
                  locald.oQ = null;
                  locald.oP = null;
                  break;
                }
                throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + getResources().getResourceName(locald.oK) + " to anchor view " + localView1);
                k = 0;
                break label217;
                label681:
                k = 0;
                continue;
              }
              localObject2 = (ArrayList)localh.Rw.get(localView2);
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                localObject2 = (ArrayList)localh.Rv.acquire();
                localObject1 = localObject2;
                if (localObject2 == null) {
                  localObject1 = new ArrayList();
                }
                localh.Rw.put(localView2, localObject1);
              }
              ((ArrayList)localObject1).add(localView1);
            }
          }
        }
        i += 1;
      }
      label771:
      j += 1;
    }
    this.om.addAll(this.oo.fv());
    Collections.reverse(this.om);
  }
  
  private void cf()
  {
    if (Build.VERSION.SDK_INT < 21) {
      return;
    }
    if (t.aq(this))
    {
      if (this.oE == null) {
        this.oE = new p()
        {
          public final ab a(View paramAnonymousView, ab paramAnonymousab)
          {
            boolean bool2 = true;
            int i = 0;
            CoordinatorLayout localCoordinatorLayout = CoordinatorLayout.this;
            if (!j.equals(localCoordinatorLayout.oA, paramAnonymousab))
            {
              localCoordinatorLayout.oA = paramAnonymousab;
              if ((paramAnonymousab != null) && (paramAnonymousab.getSystemWindowInsetTop() > 0))
              {
                bool1 = true;
                localCoordinatorLayout.oB = bool1;
                if ((localCoordinatorLayout.oB) || (localCoordinatorLayout.getBackground() != null)) {
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
                  if ((!t.aq(paramAnonymousab)) || (((CoordinatorLayout.d)paramAnonymousab.getLayoutParams()).oH == null)) {
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
      t.a(this, this.oE);
      setSystemUiVisibility(1280);
      return;
    }
    t.a(this, null);
  }
  
  private void g(View paramView, int paramInt)
  {
    d locald = (d)paramView.getLayoutParams();
    Rect localRect1 = cd();
    localRect1.set(getPaddingLeft() + locald.leftMargin, getPaddingTop() + locald.topMargin, getWidth() - getPaddingRight() - locald.rightMargin, getHeight() - getPaddingBottom() - locald.bottomMargin);
    if ((this.oA != null) && (t.aq(this)) && (!t.aq(paramView)))
    {
      localRect1.left += this.oA.getSystemWindowInsetLeft();
      localRect1.top += this.oA.getSystemWindowInsetTop();
      localRect1.right -= this.oA.getSystemWindowInsetRight();
      localRect1.bottom -= this.oA.getSystemWindowInsetBottom();
    }
    Rect localRect2 = cd();
    d.apply(U(locald.gravity), paramView.getMeasuredWidth(), paramView.getMeasuredHeight(), localRect1, localRect2, paramInt);
    paramView.layout(localRect2.left, localRect2.top, localRect2.right, localRect2.bottom);
    a(localRect1);
    a(localRect2);
  }
  
  private static void h(View paramView, int paramInt)
  {
    d locald = (d)paramView.getLayoutParams();
    if (locald.oN != paramInt)
    {
      t.u(paramView, paramInt - locald.oN);
      locald.oN = paramInt;
    }
  }
  
  private static void i(View paramView, int paramInt)
  {
    d locald = (d)paramView.getLayoutParams();
    if (locald.oO != paramInt)
    {
      t.s(paramView, paramInt - locald.oO);
      locald.oO = paramInt;
    }
  }
  
  private static d q(View paramView)
  {
    d locald = (d)paramView.getLayoutParams();
    if (!locald.oI)
    {
      if ((paramView instanceof a))
      {
        locald.a(((a)paramView).getBehavior());
        locald.oI = true;
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
      paramView = (b)localClass.getAnnotation(b.class);
      localView = paramView;
      if (paramView != null) {
        break;
      }
      localClass = localClass.getSuperclass();
    }
    if (localView != null) {}
    try
    {
      locald.a((Behavior)localView.value().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
      locald.oI = true;
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
  
  private void w(boolean paramBoolean)
  {
    int j = getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = getChildAt(i);
      Behavior localBehavior = ((d)localView.getLayoutParams()).oH;
      MotionEvent localMotionEvent;
      if (localBehavior != null)
      {
        long l = SystemClock.uptimeMillis();
        localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        if (!paramBoolean) {
          break label82;
        }
        localBehavior.b(this, localView, localMotionEvent);
      }
      for (;;)
      {
        localMotionEvent.recycle();
        i += 1;
        break;
        label82:
        localBehavior.a(this, localView, localMotionEvent);
      }
    }
    i = 0;
    while (i < j)
    {
      ((d)getChildAt(i).getLayoutParams()).oR = false;
      i += 1;
    }
    this.ow = null;
    this.ot = false;
  }
  
  final void W(int paramInt)
  {
    int m = t.Y(this);
    int n = this.om.size();
    Rect localRect1 = cd();
    Rect localRect2 = cd();
    Rect localRect3 = cd();
    int j = 0;
    View localView;
    Object localObject1;
    int i;
    Object localObject2;
    Object localObject3;
    if (j < n)
    {
      localView = (View)this.om.get(j);
      localObject1 = (d)localView.getLayoutParams();
      if ((paramInt != 0) || (localView.getVisibility() != 8))
      {
        i = 0;
        int i1;
        int i2;
        int k;
        if (i < j)
        {
          localObject2 = (View)this.om.get(i);
          Rect localRect5;
          if (((d)localObject1).oQ == localObject2)
          {
            localObject2 = (d)localView.getLayoutParams();
            if (((d)localObject2).oP != null)
            {
              localObject3 = cd();
              localRect4 = cd();
              localRect5 = cd();
              u.a(this, ((d)localObject2).oP, (Rect)localObject3);
              a(localView, false, localRect4);
              i1 = localView.getMeasuredWidth();
              i2 = localView.getMeasuredHeight();
              a(m, (Rect)localObject3, localRect5, (d)localObject2, i1, i2);
              if ((localRect5.left == localRect4.left) && (localRect5.top == localRect4.top)) {
                break label337;
              }
            }
          }
          label337:
          for (k = 1;; k = 0)
          {
            a((d)localObject2, localRect5, i1, i2);
            i1 = localRect5.left - localRect4.left;
            i2 = localRect5.top - localRect4.top;
            if (i1 != 0) {
              t.u(localView, i1);
            }
            if (i2 != 0) {
              t.s(localView, i2);
            }
            if (k != 0)
            {
              Behavior localBehavior = ((d)localObject2).oH;
              if (localBehavior != null) {
                localBehavior.a(this, localView, ((d)localObject2).oP);
              }
            }
            a((Rect)localObject3);
            a(localRect4);
            a(localRect5);
            i += 1;
            break;
          }
        }
        a(localView, true, localRect2);
        if ((((d)localObject1).oL != 0) && (!localRect2.isEmpty()))
        {
          i = d.getAbsoluteGravity(((d)localObject1).oL, m);
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
          if ((((d)localObject1).oM != 0) && (localView.getVisibility() == 0) && (t.ay(localView)) && (localView.getWidth() > 0) && (localView.getHeight() > 0)) {
            break label705;
          }
          label480:
          if (paramInt != 2)
          {
            localRect3.set(((d)localView.getLayoutParams()).oV);
            if (localRect3.equals(localRect2)) {
              break label1201;
            }
            ((d)localView.getLayoutParams()).oV.set(localRect2);
          }
          i = j + 1;
          for (;;)
          {
            if (i >= n) {
              break label1201;
            }
            localObject1 = (View)this.om.get(i);
            localObject2 = (d)((View)localObject1).getLayoutParams();
            localObject3 = ((d)localObject2).oH;
            if ((localObject3 != null) && (((Behavior)localObject3).a((View)localObject1, localView)))
            {
              if ((paramInt != 0) || (!((d)localObject2).oU)) {
                break;
              }
              ((d)localObject2).oU = false;
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
        label705:
        localObject1 = (d)localView.getLayoutParams();
        localObject2 = ((d)localObject1).oH;
        localObject3 = cd();
        Rect localRect4 = cd();
        localRect4.set(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
        if ((localObject2 != null) && (((Behavior)localObject2).a(this, localView, (Rect)localObject3)))
        {
          if (!localRect4.contains((Rect)localObject3)) {
            throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + ((Rect)localObject3).toShortString() + " | Bounds:" + localRect4.toShortString());
          }
        }
        else {
          ((Rect)localObject3).set(localRect4);
        }
        a(localRect4);
        if (!((Rect)localObject3).isEmpty())
        {
          i1 = d.getAbsoluteGravity(((d)localObject1).oM, m);
          k = 0;
          i = k;
          if ((i1 & 0x30) == 48)
          {
            i2 = ((Rect)localObject3).top - ((d)localObject1).topMargin - ((d)localObject1).oO;
            i = k;
            if (i2 < localRect1.top)
            {
              i(localView, localRect1.top - i2);
              i = 1;
            }
          }
          k = i;
          if ((i1 & 0x50) == 80)
          {
            i2 = getHeight() - ((Rect)localObject3).bottom - ((d)localObject1).bottomMargin + ((d)localObject1).oO;
            k = i;
            if (i2 < localRect1.bottom)
            {
              i(localView, i2 - localRect1.bottom);
              k = 1;
            }
          }
          if (k == 0) {
            i(localView, 0);
          }
          k = 0;
          i = k;
          if ((i1 & 0x3) == 3)
          {
            i2 = ((Rect)localObject3).left - ((d)localObject1).leftMargin - ((d)localObject1).oN;
            i = k;
            if (i2 < localRect1.left)
            {
              h(localView, localRect1.left - i2);
              i = 1;
            }
          }
          if ((i1 & 0x5) != 5) {
            break label1224;
          }
          k = getWidth();
          i1 = ((Rect)localObject3).right;
          i2 = ((d)localObject1).rightMargin;
          k = ((d)localObject1).oN + (k - i1 - i2);
          if (k >= localRect1.right) {
            break label1224;
          }
          h(localView, k - localRect1.right);
          i = 1;
        }
      }
    }
    label1201:
    label1224:
    for (;;)
    {
      if (i == 0) {
        h(localView, 0);
      }
      a((Rect)localObject3);
      break label480;
      switch (paramInt)
      {
      }
      for (boolean bool = ((Behavior)localObject3).a(this, (View)localObject1, localView); paramInt == 1; bool = true)
      {
        ((d)localObject2).oU = bool;
        break;
      }
      j += 1;
      break;
      a(localRect1);
      a(localRect2);
      a(localRect3);
      return;
    }
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    measureChildWithMargins(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int k = getChildCount();
    int i = 0;
    int j = 0;
    if (j < k)
    {
      View localView = getChildAt(j);
      if (localView.getVisibility() == 8) {
        break label109;
      }
      Object localObject = (d)localView.getLayoutParams();
      if (!((d)localObject).X(paramInt5)) {
        break label109;
      }
      localObject = ((d)localObject).oH;
      if (localObject == null) {
        break label109;
      }
      ((Behavior)localObject).a(this, localView, paramView, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
      i = 1;
    }
    label109:
    for (;;)
    {
      j += 1;
      break;
      if (i != 0) {
        W(1);
      }
      return;
    }
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    int j = 0;
    int i = 0;
    int k = 0;
    int i2 = getChildCount();
    int m = 0;
    label127:
    int n;
    if (m < i2)
    {
      View localView = getChildAt(m);
      if (localView.getVisibility() == 8) {
        break label239;
      }
      Object localObject = (d)localView.getLayoutParams();
      if (!((d)localObject).X(paramInt3)) {
        break label239;
      }
      localObject = ((d)localObject).oH;
      if (localObject == null) {
        break label239;
      }
      int[] arrayOfInt = this.os;
      this.os[1] = 0;
      arrayOfInt[0] = 0;
      ((Behavior)localObject).a(this, localView, paramView, paramInt1, paramInt2, this.os, paramInt3);
      if (paramInt1 > 0)
      {
        j = Math.max(j, this.os[0]);
        if (paramInt2 <= 0) {
          break label200;
        }
        k = Math.max(i, this.os[1]);
        label144:
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
      j = Math.min(j, this.os[0]);
      break label127;
      label200:
      k = Math.min(i, this.os[1]);
      break label144;
      paramArrayOfInt[0] = j;
      paramArrayOfInt[1] = i;
      if (k != 0) {
        W(1);
      }
      return;
      label239:
      n = i;
      i = j;
      j = n;
      n = k;
    }
  }
  
  public final boolean a(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    boolean bool1 = false;
    int j = getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = getChildAt(i);
      d locald;
      if (localView.getVisibility() != 8)
      {
        locald = (d)localView.getLayoutParams();
        Behavior localBehavior = locald.oH;
        if (localBehavior != null)
        {
          boolean bool2 = localBehavior.a(this, localView, paramView1, paramView2, paramInt1, paramInt2);
          bool1 |= bool2;
          locald.d(paramInt2, bool2);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        locald.d(paramInt2, false);
      }
    }
    return bool1;
  }
  
  public final void b(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    this.oF.NY = paramInt1;
    this.ox = paramView2;
    paramInt2 = getChildCount();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      getChildAt(paramInt1).getLayoutParams();
      paramInt1 += 1;
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof d)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  public final boolean d(View paramView, int paramInt1, int paramInt2)
  {
    Rect localRect = cd();
    u.a(this, paramView, localRect);
    try
    {
      boolean bool = localRect.contains(paramInt1, paramInt2);
      return bool;
    }
    finally
    {
      a(localRect);
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
    Drawable localDrawable = this.oC;
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
  
  public final void f(View paramView, int paramInt)
  {
    d locald = (d)paramView.getLayoutParams();
    if (locald.cg()) {
      throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
    }
    if (locald.oP != null)
    {
      a(paramView, locald.oP, paramInt);
      return;
    }
    if (locald.oJ >= 0)
    {
      c(paramView, locald.oJ, paramInt);
      return;
    }
    g(paramView, paramInt);
  }
  
  final List<View> getDependencySortedChildren()
  {
    ce();
    return Collections.unmodifiableList(this.om);
  }
  
  public final ab getLastWindowInsets()
  {
    return this.oA;
  }
  
  public int getNestedScrollAxes()
  {
    return this.oF.NY;
  }
  
  public Drawable getStatusBarBackground()
  {
    return this.oC;
  }
  
  protected int getSuggestedMinimumHeight()
  {
    return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
  }
  
  protected int getSuggestedMinimumWidth()
  {
    return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
  }
  
  public final void j(View paramView, int paramInt)
  {
    this.oF.NY = 0;
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      d locald = (d)localView.getLayoutParams();
      if (locald.X(paramInt))
      {
        Behavior localBehavior = locald.oH;
        if (localBehavior != null) {
          localBehavior.a(this, localView, paramView, paramInt);
        }
        locald.d(paramInt, false);
        locald.oU = false;
      }
      i += 1;
    }
    this.ox = null;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    w(false);
    if (this.oz)
    {
      if (this.oy == null) {
        this.oy = new e();
      }
      getViewTreeObserver().addOnPreDrawListener(this.oy);
    }
    if ((this.oA == null) && (t.aq(this))) {
      t.ap(this);
    }
    this.ou = true;
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    w(false);
    if ((this.oz) && (this.oy != null)) {
      getViewTreeObserver().removeOnPreDrawListener(this.oy);
    }
    if (this.ox != null) {
      onStopNestedScroll(this.ox);
    }
    this.ou = false;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.oB) && (this.oC != null)) {
      if (this.oA == null) {
        break label61;
      }
    }
    label61:
    for (int i = this.oA.getSystemWindowInsetTop();; i = 0)
    {
      if (i > 0)
      {
        this.oC.setBounds(0, 0, getWidth(), i);
        this.oC.draw(paramCanvas);
      }
      return;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i == 0) {
      w(true);
    }
    boolean bool = a(paramMotionEvent, 0);
    if ((i == 1) || (i == 3)) {
      w(true);
    }
    return bool;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = t.Y(this);
    paramInt3 = this.om.size();
    paramInt1 = 0;
    while (paramInt1 < paramInt3)
    {
      View localView = (View)this.om.get(paramInt1);
      if (localView.getVisibility() != 8)
      {
        Behavior localBehavior = ((d)localView.getLayoutParams()).oH;
        if ((localBehavior == null) || (!localBehavior.a(this, localView, paramInt2))) {
          f(localView, paramInt2);
        }
      }
      paramInt1 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    ce();
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
      localObject1 = this.oo;
      m = ((h)localObject1).Rw.size();
      j = 0;
      if (j < m)
      {
        localObject2 = (ArrayList)((h)localObject1).Rw.valueAt(j);
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
      if (i17 != this.oz)
      {
        if (i17 != 0)
        {
          if (this.ou)
          {
            if (this.oy == null) {
              this.oy = new e();
            }
            getViewTreeObserver().addOnPreDrawListener(this.oy);
          }
          this.oz = true;
        }
      }
      else
      {
        i5 = getPaddingLeft();
        int i6 = getPaddingTop();
        int i7 = getPaddingRight();
        int i8 = getPaddingBottom();
        int i9 = t.Y(this);
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
        if ((this.oA == null) || (!t.aq(this))) {
          break label664;
        }
        i1 = 1;
        int i14 = this.om.size();
        i2 = 0;
        if (i2 >= i14) {
          break label714;
        }
        localView = (View)this.om.get(i2);
        if (localView.getVisibility() == 8) {
          break label749;
        }
        localObject1 = (d)localView.getLayoutParams();
        i3 = 0;
        m = i3;
        if (((d)localObject1).oJ >= 0)
        {
          m = i3;
          if (i10 != 0)
          {
            i4 = T(((d)localObject1).oJ);
            i15 = d.getAbsoluteGravity(V(((d)localObject1).gravity), i9) & 0x7;
            if (((i15 != 3) || (n != 0)) && ((i15 != 5) || (n == 0))) {
              break label670;
            }
            m = Math.max(0, i11 - i7 - i4);
          }
        }
        label388:
        if ((i1 == 0) || (t.aq(localView))) {
          break label740;
        }
        i3 = this.oA.getSystemWindowInsetLeft();
        int i16 = this.oA.getSystemWindowInsetRight();
        i4 = this.oA.getSystemWindowInsetTop();
        i15 = this.oA.getSystemWindowInsetBottom();
        i3 = View.MeasureSpec.makeMeasureSpec(i11 - (i3 + i16), i10);
        i4 = View.MeasureSpec.makeMeasureSpec(i13 - (i4 + i15), i12);
        label467:
        localObject2 = ((d)localObject1).oH;
        if ((localObject2 == null) || (!((Behavior)localObject2).a(this, localView, i3, m, i4, 0))) {
          a(localView, i3, m, i4, 0);
        }
        m = Math.max(k, localView.getMeasuredWidth() + (i5 + i7) + ((d)localObject1).leftMargin + ((d)localObject1).rightMargin);
        j = Math.max(j, localView.getMeasuredHeight() + (i6 + i8) + ((d)localObject1).topMargin + ((d)localObject1).bottomMargin);
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
        if ((this.ou) && (this.oy != null)) {
          getViewTreeObserver().removeOnPreDrawListener(this.oy);
        }
        this.oz = false;
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
    boolean bool = false;
    if (i < j)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 8) {
        break label108;
      }
      Object localObject = (d)localView.getLayoutParams();
      if (!((d)localObject).X(0)) {
        break label108;
      }
      localObject = ((d)localObject).oH;
      if (localObject == null) {
        break label108;
      }
      bool = ((Behavior)localObject).a(this, localView, paramView, paramFloat1, paramFloat2, paramBoolean) | bool;
    }
    label108:
    for (;;)
    {
      i += 1;
      break;
      if (bool) {
        W(1);
      }
      return bool;
    }
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
      Object localObject = (d)localView.getLayoutParams();
      if (!((d)localObject).X(0)) {
        break label96;
      }
      localObject = ((d)localObject).oH;
      if (localObject == null) {
        break label96;
      }
      bool = ((Behavior)localObject).a(this, localView, paramView, paramFloat1, paramFloat2) | bool;
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
    a(paramView, paramInt1, paramInt2, paramInt3, paramInt4, 0);
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    b(paramView1, paramView2, paramInt, 0);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState)) {
      super.onRestoreInstanceState(paramParcelable);
    }
    for (;;)
    {
      return;
      paramParcelable = (SavedState)paramParcelable;
      super.onRestoreInstanceState(paramParcelable.Nj);
      paramParcelable = paramParcelable.oX;
      int j = getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = getChildAt(i);
        int k = localView.getId();
        Behavior localBehavior = q(localView).oH;
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
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    SparseArray localSparseArray = new SparseArray();
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = getChildAt(i);
      int k = ((View)localObject).getId();
      Behavior localBehavior = ((d)((View)localObject).getLayoutParams()).oH;
      if ((k != -1) && (localBehavior != null))
      {
        localObject = localBehavior.b(this, (View)localObject);
        if (localObject != null) {
          localSparseArray.append(k, localObject);
        }
      }
      i += 1;
    }
    localSavedState.oX = localSparseArray;
    return localSavedState;
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    return a(paramView1, paramView2, paramInt, 0);
  }
  
  public void onStopNestedScroll(View paramView)
  {
    j(paramView, 0);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    boolean bool2;
    if (this.ow == null)
    {
      bool2 = a(paramMotionEvent, 1);
      if (!bool2) {}
    }
    for (;;)
    {
      Behavior localBehavior = ((d)this.ow.getLayoutParams()).oH;
      boolean bool1;
      if (localBehavior != null) {
        bool1 = localBehavior.a(this, this.ow, paramMotionEvent);
      }
      for (;;)
      {
        if (this.ow == null)
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
            w(false);
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
  
  public final void r(View paramView)
  {
    List localList = this.oo.I(paramView);
    if ((localList != null) && (!localList.isEmpty()))
    {
      int i = 0;
      while (i < localList.size())
      {
        View localView = (View)localList.get(i);
        Behavior localBehavior = ((d)localView.getLayoutParams()).oH;
        if (localBehavior != null) {
          localBehavior.a(this, localView, paramView);
        }
        i += 1;
      }
    }
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    Behavior localBehavior = ((d)paramView.getLayoutParams()).oH;
    if ((localBehavior != null) && (localBehavior.a(this, paramView, paramRect, paramBoolean))) {
      return true;
    }
    return super.requestChildRectangleOnScreen(paramView, paramRect, paramBoolean);
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    super.requestDisallowInterceptTouchEvent(paramBoolean);
    if ((paramBoolean) && (!this.ot))
    {
      w(false);
      this.ot = true;
    }
  }
  
  public final List<View> s(View paramView)
  {
    paramView = this.oo.J(paramView);
    this.or.clear();
    if (paramView != null) {
      this.or.addAll(paramView);
    }
    return this.or;
  }
  
  public void setFitsSystemWindows(boolean paramBoolean)
  {
    super.setFitsSystemWindows(paramBoolean);
    cf();
  }
  
  public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener paramOnHierarchyChangeListener)
  {
    this.oD = paramOnHierarchyChangeListener;
  }
  
  public void setStatusBarBackground(Drawable paramDrawable)
  {
    Drawable localDrawable = null;
    if (this.oC != paramDrawable)
    {
      if (this.oC != null) {
        this.oC.setCallback(null);
      }
      if (paramDrawable != null) {
        localDrawable = paramDrawable.mutate();
      }
      this.oC = localDrawable;
      if (this.oC != null)
      {
        if (this.oC.isStateful()) {
          this.oC.setState(getDrawableState());
        }
        a.b(this.oC, t.Y(this));
        paramDrawable = this.oC;
        if (getVisibility() != 0) {
          break label114;
        }
      }
    }
    label114:
    for (boolean bool = true;; bool = false)
    {
      paramDrawable.setVisible(bool, false);
      this.oC.setCallback(this);
      t.W(this);
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
    for (Drawable localDrawable = b.l(getContext(), paramInt);; localDrawable = null)
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
      if ((this.oC != null) && (this.oC.isVisible() != bool)) {
        this.oC.setVisible(bool, false);
      }
      return;
    }
  }
  
  public final List<View> t(View paramView)
  {
    paramView = this.oo.I(paramView);
    this.or.clear();
    if (paramView != null) {
      this.or.addAll(paramView);
    }
    return this.or;
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.oC);
  }
  
  public static abstract class Behavior<V extends View>
  {
    public Behavior() {}
    
    public Behavior(Context paramContext, AttributeSet paramAttributeSet) {}
    
    public static ab b(ab paramab)
    {
      return paramab;
    }
    
    @Deprecated
    public boolean B(int paramInt)
    {
      return false;
    }
    
    public void a(CoordinatorLayout.d paramd) {}
    
    public void a(CoordinatorLayout paramCoordinatorLayout, V paramV, Parcelable paramParcelable) {}
    
    public void a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, int paramInt)
    {
      if (paramInt == 0) {
        b(paramV, paramView);
      }
    }
    
    public void a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      if (paramInt5 == 0) {
        a(paramV, paramInt2);
      }
    }
    
    public void a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
    {
      if (paramInt3 == 0) {
        a(paramV, paramView, paramInt2, paramArrayOfInt);
      }
    }
    
    @Deprecated
    public void a(V paramV, int paramInt) {}
    
    @Deprecated
    public void a(V paramV, View paramView, int paramInt, int[] paramArrayOfInt) {}
    
    public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
    {
      return false;
    }
    
    public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      return false;
    }
    
    public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, Rect paramRect)
    {
      return false;
    }
    
    public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, Rect paramRect, boolean paramBoolean)
    {
      return false;
    }
    
    public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
    {
      return false;
    }
    
    public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView)
    {
      return false;
    }
    
    public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, float paramFloat1, float paramFloat2)
    {
      return false;
    }
    
    public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
    {
      return false;
    }
    
    public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView1, View paramView2, int paramInt1, int paramInt2)
    {
      if (paramInt2 == 0) {
        return B(paramInt1);
      }
      return false;
    }
    
    public boolean a(V paramV, View paramView)
    {
      return false;
    }
    
    public Parcelable b(CoordinatorLayout paramCoordinatorLayout, V paramV)
    {
      return View.BaseSavedState.EMPTY_STATE;
    }
    
    @Deprecated
    public void b(V paramV, View paramView) {}
    
    public boolean b(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
    {
      return false;
    }
  }
  
  protected static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator() {};
    SparseArray<Parcelable> oX;
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      int j = paramParcel.readInt();
      int[] arrayOfInt = new int[j];
      paramParcel.readIntArray(arrayOfInt);
      paramParcel = paramParcel.readParcelableArray(paramClassLoader);
      this.oX = new SparseArray(j);
      int i = 0;
      while (i < j)
      {
        this.oX.append(arrayOfInt[i], paramParcel[i]);
        i += 1;
      }
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int j = 0;
      super.writeToParcel(paramParcel, paramInt);
      if (this.oX != null) {}
      int[] arrayOfInt;
      Parcelable[] arrayOfParcelable;
      for (int i = this.oX.size();; i = 0)
      {
        paramParcel.writeInt(i);
        arrayOfInt = new int[i];
        arrayOfParcelable = new Parcelable[i];
        while (j < i)
        {
          arrayOfInt[j] = this.oX.keyAt(j);
          arrayOfParcelable[j] = ((Parcelable)this.oX.valueAt(j));
          j += 1;
        }
      }
      paramParcel.writeIntArray(arrayOfInt);
      paramParcel.writeParcelableArray(arrayOfParcelable, paramInt);
    }
  }
  
  public static abstract interface a
  {
    public abstract CoordinatorLayout.Behavior getBehavior();
  }
  
  @Deprecated
  @Retention(RetentionPolicy.RUNTIME)
  public static @interface b
  {
    Class<? extends CoordinatorLayout.Behavior> value();
  }
  
  final class c
    implements ViewGroup.OnHierarchyChangeListener
  {
    c() {}
    
    public final void onChildViewAdded(View paramView1, View paramView2)
    {
      if (CoordinatorLayout.this.oD != null) {
        CoordinatorLayout.this.oD.onChildViewAdded(paramView1, paramView2);
      }
    }
    
    public final void onChildViewRemoved(View paramView1, View paramView2)
    {
      CoordinatorLayout.this.W(2);
      if (CoordinatorLayout.this.oD != null) {
        CoordinatorLayout.this.oD.onChildViewRemoved(paramView1, paramView2);
      }
    }
  }
  
  public static final class d
    extends ViewGroup.MarginLayoutParams
  {
    public int anchorGravity = 0;
    public int gravity = 0;
    public CoordinatorLayout.Behavior oH;
    boolean oI = false;
    public int oJ = -1;
    int oK = -1;
    public int oL = 0;
    public int oM = 0;
    int oN;
    int oO;
    View oP;
    View oQ;
    boolean oR;
    private boolean oS;
    private boolean oT;
    boolean oU;
    final Rect oV = new Rect();
    Object oW;
    
    public d()
    {
      super(-2);
    }
    
    d(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.CoordinatorLayout_Layout);
      this.gravity = localTypedArray.getInteger(0, 0);
      this.oK = localTypedArray.getResourceId(1, -1);
      this.anchorGravity = localTypedArray.getInteger(2, 0);
      this.oJ = localTypedArray.getInteger(6, -1);
      this.oL = localTypedArray.getInt(5, 0);
      this.oM = localTypedArray.getInt(4, 0);
      this.oI = localTypedArray.hasValue(3);
      if (this.oI) {
        this.oH = CoordinatorLayout.a(paramContext, paramAttributeSet, localTypedArray.getString(3));
      }
      localTypedArray.recycle();
      if (this.oH != null) {
        this.oH.a(this);
      }
    }
    
    public d(d paramd)
    {
      super();
    }
    
    public d(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public d(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
    
    final boolean X(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return false;
      case 0: 
        return this.oS;
      }
      return this.oT;
    }
    
    public final void a(CoordinatorLayout.Behavior paramBehavior)
    {
      if (this.oH != paramBehavior)
      {
        this.oH = paramBehavior;
        this.oW = null;
        this.oI = true;
        if (paramBehavior != null) {
          paramBehavior.a(this);
        }
      }
    }
    
    final boolean cg()
    {
      return (this.oP == null) && (this.oK != -1);
    }
    
    final void d(int paramInt, boolean paramBoolean)
    {
      switch (paramInt)
      {
      default: 
        return;
      case 0: 
        this.oS = paramBoolean;
        return;
      }
      this.oT = paramBoolean;
    }
  }
  
  final class e
    implements ViewTreeObserver.OnPreDrawListener
  {
    e() {}
    
    public final boolean onPreDraw()
    {
      CoordinatorLayout.this.W(0);
      return true;
    }
  }
  
  static final class f
    implements Comparator<View>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.design.widget.CoordinatorLayout
 * JD-Core Version:    0.7.0.1
 */