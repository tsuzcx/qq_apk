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
import android.support.v4.view.ac;
import android.support.v4.view.d;
import android.support.v4.view.o;
import android.support.v4.view.p;
import android.support.v4.widget.h;
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
  static final String qe;
  static final Class<?>[] qf;
  static final ThreadLocal<Map<String, Constructor<Behavior>>> qg;
  static final Comparator<View> qh;
  private static final l.a<Rect> qi;
  private boolean mIsAttachedToWindow;
  private final o qA = new o(this);
  private final List<View> qj = new ArrayList();
  private final h<View> qk = new h();
  private final List<View> ql = new ArrayList();
  private final List<View> qm = new ArrayList();
  private final int[] qn = new int[2];
  private boolean qo;
  private int[] qp;
  private View qr;
  private View qs;
  private e qt;
  private boolean qu;
  ac qv;
  boolean qw;
  private Drawable qx;
  ViewGroup.OnHierarchyChangeListener qy;
  private p qz;
  
  static
  {
    Object localObject = CoordinatorLayout.class.getPackage();
    if (localObject != null)
    {
      localObject = ((Package)localObject).getName();
      qe = (String)localObject;
      if (Build.VERSION.SDK_INT < 21) {
        break label82;
      }
    }
    label82:
    for (qh = new f();; qh = null)
    {
      qf = new Class[] { Context.class, AttributeSet.class };
      qg = new ThreadLocal();
      qi = new l.c(12);
      return;
      localObject = null;
      break;
    }
  }
  
  public CoordinatorLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130968907);
  }
  
  public CoordinatorLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (paramInt == 0) {}
    for (paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.CoordinatorLayout, 0, 2131821728);; paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.CoordinatorLayout, paramInt, 0))
    {
      paramInt = paramAttributeSet.getResourceId(0, 0);
      if (paramInt == 0) {
        break;
      }
      paramContext = paramContext.getResources();
      this.qp = paramContext.getIntArray(paramInt);
      float f = paramContext.getDisplayMetrics().density;
      int j = this.qp.length;
      paramInt = i;
      while (paramInt < j)
      {
        paramContext = this.qp;
        paramContext[paramInt] = ((int)(paramContext[paramInt] * f));
        paramInt += 1;
      }
    }
    this.qx = paramAttributeSet.getDrawable(1);
    paramAttributeSet.recycle();
    cx();
    super.setOnHierarchyChangeListener(new c());
  }
  
  private int R(int paramInt)
  {
    if (this.qp == null)
    {
      new StringBuilder("No keylines defined for ").append(this).append(" - attempted index lookup ").append(paramInt);
      return 0;
    }
    if ((paramInt < 0) || (paramInt >= this.qp.length))
    {
      new StringBuilder("Keyline index ").append(paramInt).append(" out of range for ").append(this);
      return 0;
    }
    return this.qp[paramInt];
  }
  
  private static int S(int paramInt)
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
  
  private static int T(int paramInt)
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
        paramString = (Map)qg.get();
        if (paramString != null) {
          break label216;
        }
        paramString = new HashMap();
        qg.set(paramString);
        Constructor localConstructor2 = (Constructor)paramString.get(str);
        Constructor localConstructor1 = localConstructor2;
        if (localConstructor2 == null)
        {
          localConstructor1 = paramContext.getClassLoader().loadClass(str).getConstructor(qf);
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
        if (!TextUtils.isEmpty(qe)) {
          str = qe + '.' + paramString;
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
    i = d.getAbsoluteGravity(S(paramd.anchorGravity), paramInt1);
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
    qi.release(paramRect);
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
    Rect localRect1 = cv();
    Rect localRect2 = cv();
    try
    {
      android.support.v4.widget.u.a(this, paramView2, localRect1);
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
      android.support.v4.widget.u.a(this, paramView, paramRect);
      return;
    }
    paramRect.set(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
  }
  
  private boolean a(MotionEvent paramMotionEvent, int paramInt)
  {
    boolean bool1 = false;
    int k = 0;
    int m = paramMotionEvent.getActionMasked();
    List localList = this.ql;
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
    if (qh != null) {
      Collections.sort(localList, qh);
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
      localBehavior = locald.qC;
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
          this.qr = localView;
          bool2 = bool1;
        }
        bool1 = bool2;
        if (locald.qC == null) {
          locald.qM = false;
        }
        boolean bool3 = locald.qM;
        if (locald.qM)
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
        bool2 = locald.qM | false;
        locald.qM = bool2;
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
    int i1 = d.getAbsoluteGravity(T(locald.gravity), paramInt2);
    int n = getWidth();
    int m = getHeight();
    int j = paramView.getMeasuredWidth();
    int k = paramView.getMeasuredHeight();
    int i = paramInt1;
    if (paramInt2 == 1) {
      i = n - paramInt1;
    }
    paramInt1 = R(i) - j;
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
  
  private static Rect cv()
  {
    Rect localRect2 = (Rect)qi.acquire();
    Rect localRect1 = localRect2;
    if (localRect2 == null) {
      localRect1 = new Rect();
    }
    return localRect1;
  }
  
  private void cw()
  {
    this.qj.clear();
    Object localObject1 = this.qk;
    int j = ((h)localObject1).Tx.size();
    int i = 0;
    Object localObject2;
    while (i < j)
    {
      localObject2 = (ArrayList)((h)localObject1).Tx.valueAt(i);
      if (localObject2 != null)
      {
        ((ArrayList)localObject2).clear();
        ((h)localObject1).Tw.release(localObject2);
      }
      i += 1;
    }
    ((h)localObject1).Tx.clear();
    int m = getChildCount();
    j = 0;
    while (j < m)
    {
      View localView1 = getChildAt(j);
      d locald = r(localView1);
      if (locald.qF == -1)
      {
        locald.qL = null;
        locald.qK = null;
        this.qk.I(localView1);
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
          if (localView2 != locald.qL)
          {
            k = android.support.v4.view.u.Z(this);
            int n = d.getAbsoluteGravity(((d)localView2.getLayoutParams()).qG, k);
            if ((n != 0) && ((d.getAbsoluteGravity(locald.qH, k) & n) == n))
            {
              k = 1;
              label217:
              if ((k == 0) && ((locald.qC == null) || (!locald.qC.a(localView1, localView2)))) {
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
              if (!this.qk.Tx.containsKey(localView2)) {
                this.qk.I(localView2);
              }
              h localh = this.qk;
              if ((!localh.Tx.containsKey(localView2)) || (!localh.Tx.containsKey(localView1)))
              {
                throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
                if (locald.qK != null)
                {
                  if (locald.qK.getId() == locald.qF) {
                    break label400;
                  }
                  i = 0;
                }
                for (;;)
                {
                  if (i != 0) {
                    break label489;
                  }
                  locald.qK = findViewById(locald.qF);
                  if (locald.qK == null) {
                    break label607;
                  }
                  if (locald.qK != this) {
                    break label502;
                  }
                  if (!isInEditMode()) {
                    break label491;
                  }
                  locald.qL = null;
                  locald.qK = null;
                  break;
                  label400:
                  localObject2 = locald.qK;
                  for (localObject1 = locald.qK.getParent();; localObject1 = ((ViewParent)localObject1).getParent())
                  {
                    if (localObject1 == this) {
                      break label479;
                    }
                    if ((localObject1 == null) || (localObject1 == localView1))
                    {
                      locald.qL = null;
                      locald.qK = null;
                      i = 0;
                      break;
                    }
                    if ((localObject1 instanceof View)) {
                      localObject2 = (View)localObject1;
                    }
                  }
                  label479:
                  locald.qL = ((View)localObject2);
                  i = 1;
                }
                label489:
                break;
                label491:
                throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                label502:
                localObject2 = locald.qK;
                for (localObject1 = locald.qK.getParent();; localObject1 = ((ViewParent)localObject1).getParent())
                {
                  if ((localObject1 == this) || (localObject1 == null)) {
                    break label597;
                  }
                  if (localObject1 == localView1)
                  {
                    if (isInEditMode())
                    {
                      locald.qL = null;
                      locald.qK = null;
                      break;
                    }
                    throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                  }
                  if ((localObject1 instanceof View)) {
                    localObject2 = (View)localObject1;
                  }
                }
                label597:
                locald.qL = ((View)localObject2);
                break;
                label607:
                if (isInEditMode())
                {
                  locald.qL = null;
                  locald.qK = null;
                  break;
                }
                throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + getResources().getResourceName(locald.qF) + " to anchor view " + localView1);
                k = 0;
                break label217;
                label681:
                k = 0;
                continue;
              }
              localObject2 = (ArrayList)localh.Tx.get(localView2);
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                localObject2 = (ArrayList)localh.Tw.acquire();
                localObject1 = localObject2;
                if (localObject2 == null) {
                  localObject1 = new ArrayList();
                }
                localh.Tx.put(localView2, localObject1);
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
    this.qj.addAll(this.qk.fT());
    Collections.reverse(this.qj);
  }
  
  private void cx()
  {
    if (Build.VERSION.SDK_INT < 21) {
      return;
    }
    if (android.support.v4.view.u.aq(this))
    {
      if (this.qz == null) {
        this.qz = new p()
        {
          public final ac a(View paramAnonymousView, ac paramAnonymousac)
          {
            boolean bool2 = true;
            int i = 0;
            CoordinatorLayout localCoordinatorLayout = CoordinatorLayout.this;
            if (!j.equals(localCoordinatorLayout.qv, paramAnonymousac))
            {
              localCoordinatorLayout.qv = paramAnonymousac;
              if ((paramAnonymousac != null) && (paramAnonymousac.getSystemWindowInsetTop() > 0))
              {
                bool1 = true;
                localCoordinatorLayout.qw = bool1;
                if ((localCoordinatorLayout.qw) || (localCoordinatorLayout.getBackground() != null)) {
                  break label155;
                }
              }
              label155:
              for (boolean bool1 = bool2;; bool1 = false)
              {
                localCoordinatorLayout.setWillNotDraw(bool1);
                if (paramAnonymousac.isConsumed()) {
                  break label171;
                }
                int j = localCoordinatorLayout.getChildCount();
                paramAnonymousView = paramAnonymousac;
                while (i < j)
                {
                  paramAnonymousac = localCoordinatorLayout.getChildAt(i);
                  if ((!android.support.v4.view.u.aq(paramAnonymousac)) || (((CoordinatorLayout.d)paramAnonymousac.getLayoutParams()).qC == null)) {
                    break label168;
                  }
                  paramAnonymousac = CoordinatorLayout.Behavior.b(paramAnonymousView);
                  paramAnonymousView = paramAnonymousac;
                  if (paramAnonymousac.isConsumed()) {
                    break;
                  }
                  paramAnonymousView = paramAnonymousac;
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
                paramAnonymousView = paramAnonymousac;
              }
            }
            return paramAnonymousac;
          }
        };
      }
      android.support.v4.view.u.a(this, this.qz);
      setSystemUiVisibility(1280);
      return;
    }
    android.support.v4.view.u.a(this, null);
  }
  
  private void h(View paramView, int paramInt)
  {
    d locald = (d)paramView.getLayoutParams();
    Rect localRect1 = cv();
    localRect1.set(getPaddingLeft() + locald.leftMargin, getPaddingTop() + locald.topMargin, getWidth() - getPaddingRight() - locald.rightMargin, getHeight() - getPaddingBottom() - locald.bottomMargin);
    if ((this.qv != null) && (android.support.v4.view.u.aq(this)) && (!android.support.v4.view.u.aq(paramView)))
    {
      localRect1.left += this.qv.getSystemWindowInsetLeft();
      localRect1.top += this.qv.getSystemWindowInsetTop();
      localRect1.right -= this.qv.getSystemWindowInsetRight();
      localRect1.bottom -= this.qv.getSystemWindowInsetBottom();
    }
    Rect localRect2 = cv();
    d.apply(S(locald.gravity), paramView.getMeasuredWidth(), paramView.getMeasuredHeight(), localRect1, localRect2, paramInt);
    paramView.layout(localRect2.left, localRect2.top, localRect2.right, localRect2.bottom);
    a(localRect1);
    a(localRect2);
  }
  
  private static void i(View paramView, int paramInt)
  {
    d locald = (d)paramView.getLayoutParams();
    if (locald.qI != paramInt)
    {
      android.support.v4.view.u.u(paramView, paramInt - locald.qI);
      locald.qI = paramInt;
    }
  }
  
  private static void j(View paramView, int paramInt)
  {
    d locald = (d)paramView.getLayoutParams();
    if (locald.qJ != paramInt)
    {
      android.support.v4.view.u.s(paramView, paramInt - locald.qJ);
      locald.qJ = paramInt;
    }
  }
  
  private static d r(View paramView)
  {
    d locald = (d)paramView.getLayoutParams();
    if (!locald.qD)
    {
      if ((paramView instanceof a))
      {
        locald.a(((a)paramView).getBehavior());
        locald.qD = true;
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
      locald.qD = true;
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
      Behavior localBehavior = ((d)localView.getLayoutParams()).qC;
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
      ((d)getChildAt(i).getLayoutParams()).qM = false;
      i += 1;
    }
    this.qr = null;
    this.qo = false;
  }
  
  final void U(int paramInt)
  {
    int m = android.support.v4.view.u.Z(this);
    int n = this.qj.size();
    Rect localRect1 = cv();
    Rect localRect2 = cv();
    Rect localRect3 = cv();
    int j = 0;
    View localView;
    Object localObject1;
    int i;
    Object localObject2;
    Object localObject3;
    if (j < n)
    {
      localView = (View)this.qj.get(j);
      localObject1 = (d)localView.getLayoutParams();
      if ((paramInt != 0) || (localView.getVisibility() != 8))
      {
        i = 0;
        int i1;
        int i2;
        int k;
        if (i < j)
        {
          localObject2 = (View)this.qj.get(i);
          Rect localRect5;
          if (((d)localObject1).qL == localObject2)
          {
            localObject2 = (d)localView.getLayoutParams();
            if (((d)localObject2).qK != null)
            {
              localObject3 = cv();
              localRect4 = cv();
              localRect5 = cv();
              android.support.v4.widget.u.a(this, ((d)localObject2).qK, (Rect)localObject3);
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
              android.support.v4.view.u.u(localView, i1);
            }
            if (i2 != 0) {
              android.support.v4.view.u.s(localView, i2);
            }
            if (k != 0)
            {
              Behavior localBehavior = ((d)localObject2).qC;
              if (localBehavior != null) {
                localBehavior.a(this, localView, ((d)localObject2).qK);
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
        if ((((d)localObject1).qG != 0) && (!localRect2.isEmpty()))
        {
          i = d.getAbsoluteGravity(((d)localObject1).qG, m);
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
          if ((((d)localObject1).qH != 0) && (localView.getVisibility() == 0) && (android.support.v4.view.u.az(localView)) && (localView.getWidth() > 0) && (localView.getHeight() > 0)) {
            break label705;
          }
          label480:
          if (paramInt != 2)
          {
            localRect3.set(((d)localView.getLayoutParams()).qQ);
            if (localRect3.equals(localRect2)) {
              break label1201;
            }
            ((d)localView.getLayoutParams()).qQ.set(localRect2);
          }
          i = j + 1;
          for (;;)
          {
            if (i >= n) {
              break label1201;
            }
            localObject1 = (View)this.qj.get(i);
            localObject2 = (d)((View)localObject1).getLayoutParams();
            localObject3 = ((d)localObject2).qC;
            if ((localObject3 != null) && (((Behavior)localObject3).a((View)localObject1, localView)))
            {
              if ((paramInt != 0) || (!((d)localObject2).qP)) {
                break;
              }
              ((d)localObject2).qP = false;
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
        localObject2 = ((d)localObject1).qC;
        localObject3 = cv();
        Rect localRect4 = cv();
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
          i1 = d.getAbsoluteGravity(((d)localObject1).qH, m);
          k = 0;
          i = k;
          if ((i1 & 0x30) == 48)
          {
            i2 = ((Rect)localObject3).top - ((d)localObject1).topMargin - ((d)localObject1).qJ;
            i = k;
            if (i2 < localRect1.top)
            {
              j(localView, localRect1.top - i2);
              i = 1;
            }
          }
          k = i;
          if ((i1 & 0x50) == 80)
          {
            i2 = getHeight() - ((Rect)localObject3).bottom - ((d)localObject1).bottomMargin + ((d)localObject1).qJ;
            k = i;
            if (i2 < localRect1.bottom)
            {
              j(localView, i2 - localRect1.bottom);
              k = 1;
            }
          }
          if (k == 0) {
            j(localView, 0);
          }
          k = 0;
          i = k;
          if ((i1 & 0x3) == 3)
          {
            i2 = ((Rect)localObject3).left - ((d)localObject1).leftMargin - ((d)localObject1).qI;
            i = k;
            if (i2 < localRect1.left)
            {
              i(localView, localRect1.left - i2);
              i = 1;
            }
          }
          if ((i1 & 0x5) != 5) {
            break label1224;
          }
          k = getWidth();
          i1 = ((Rect)localObject3).right;
          i2 = ((d)localObject1).rightMargin;
          k = ((d)localObject1).qI + (k - i1 - i2);
          if (k >= localRect1.right) {
            break label1224;
          }
          i(localView, k - localRect1.right);
          i = 1;
        }
      }
    }
    label1201:
    label1224:
    for (;;)
    {
      if (i == 0) {
        i(localView, 0);
      }
      a((Rect)localObject3);
      break label480;
      switch (paramInt)
      {
      }
      for (boolean bool = ((Behavior)localObject3).a(this, (View)localObject1, localView); paramInt == 1; bool = true)
      {
        ((d)localObject2).qP = bool;
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
      if (!((d)localObject).V(paramInt5)) {
        break label109;
      }
      localObject = ((d)localObject).qC;
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
        U(1);
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
      if (!((d)localObject).V(paramInt3)) {
        break label239;
      }
      localObject = ((d)localObject).qC;
      if (localObject == null) {
        break label239;
      }
      int[] arrayOfInt = this.qn;
      this.qn[1] = 0;
      arrayOfInt[0] = 0;
      ((Behavior)localObject).a(this, localView, paramView, paramInt1, paramInt2, this.qn, paramInt3);
      if (paramInt1 > 0)
      {
        j = Math.max(j, this.qn[0]);
        if (paramInt2 <= 0) {
          break label200;
        }
        k = Math.max(i, this.qn[1]);
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
      j = Math.min(j, this.qn[0]);
      break label127;
      label200:
      k = Math.min(i, this.qn[1]);
      break label144;
      paramArrayOfInt[0] = j;
      paramArrayOfInt[1] = i;
      if (k != 0) {
        U(1);
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
        Behavior localBehavior = locald.qC;
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
    this.qA.Qb = paramInt1;
    this.qs = paramView2;
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
    Rect localRect = cv();
    android.support.v4.widget.u.a(this, paramView, localRect);
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
    Drawable localDrawable = this.qx;
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
  
  public final void g(View paramView, int paramInt)
  {
    d locald = (d)paramView.getLayoutParams();
    if (locald.cy()) {
      throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
    }
    if (locald.qK != null)
    {
      a(paramView, locald.qK, paramInt);
      return;
    }
    if (locald.qE >= 0)
    {
      c(paramView, locald.qE, paramInt);
      return;
    }
    h(paramView, paramInt);
  }
  
  final List<View> getDependencySortedChildren()
  {
    cw();
    return Collections.unmodifiableList(this.qj);
  }
  
  public final ac getLastWindowInsets()
  {
    return this.qv;
  }
  
  public int getNestedScrollAxes()
  {
    return this.qA.Qb;
  }
  
  public Drawable getStatusBarBackground()
  {
    return this.qx;
  }
  
  protected int getSuggestedMinimumHeight()
  {
    return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
  }
  
  protected int getSuggestedMinimumWidth()
  {
    return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
  }
  
  public final void k(View paramView, int paramInt)
  {
    this.qA.Qb = 0;
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      d locald = (d)localView.getLayoutParams();
      if (locald.V(paramInt))
      {
        Behavior localBehavior = locald.qC;
        if (localBehavior != null) {
          localBehavior.a(this, localView, paramView, paramInt);
        }
        locald.d(paramInt, false);
        locald.qP = false;
      }
      i += 1;
    }
    this.qs = null;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    w(false);
    if (this.qu)
    {
      if (this.qt == null) {
        this.qt = new e();
      }
      getViewTreeObserver().addOnPreDrawListener(this.qt);
    }
    if ((this.qv == null) && (android.support.v4.view.u.aq(this))) {
      android.support.v4.view.u.ap(this);
    }
    this.mIsAttachedToWindow = true;
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    w(false);
    if ((this.qu) && (this.qt != null)) {
      getViewTreeObserver().removeOnPreDrawListener(this.qt);
    }
    if (this.qs != null) {
      onStopNestedScroll(this.qs);
    }
    this.mIsAttachedToWindow = false;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.qw) && (this.qx != null)) {
      if (this.qv == null) {
        break label61;
      }
    }
    label61:
    for (int i = this.qv.getSystemWindowInsetTop();; i = 0)
    {
      if (i > 0)
      {
        this.qx.setBounds(0, 0, getWidth(), i);
        this.qx.draw(paramCanvas);
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
    paramInt2 = android.support.v4.view.u.Z(this);
    paramInt3 = this.qj.size();
    paramInt1 = 0;
    while (paramInt1 < paramInt3)
    {
      View localView = (View)this.qj.get(paramInt1);
      if (localView.getVisibility() != 8)
      {
        Behavior localBehavior = ((d)localView.getLayoutParams()).qC;
        if ((localBehavior == null) || (!localBehavior.a(this, localView, paramInt2))) {
          g(localView, paramInt2);
        }
      }
      paramInt1 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    cw();
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
      localObject1 = this.qk;
      m = ((h)localObject1).Tx.size();
      j = 0;
      if (j < m)
      {
        localObject2 = (ArrayList)((h)localObject1).Tx.valueAt(j);
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
      if (i17 != this.qu)
      {
        if (i17 != 0)
        {
          if (this.mIsAttachedToWindow)
          {
            if (this.qt == null) {
              this.qt = new e();
            }
            getViewTreeObserver().addOnPreDrawListener(this.qt);
          }
          this.qu = true;
        }
      }
      else
      {
        i5 = getPaddingLeft();
        int i6 = getPaddingTop();
        int i7 = getPaddingRight();
        int i8 = getPaddingBottom();
        int i9 = android.support.v4.view.u.Z(this);
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
        if ((this.qv == null) || (!android.support.v4.view.u.aq(this))) {
          break label664;
        }
        i1 = 1;
        int i14 = this.qj.size();
        i2 = 0;
        if (i2 >= i14) {
          break label714;
        }
        localView = (View)this.qj.get(i2);
        if (localView.getVisibility() == 8) {
          break label749;
        }
        localObject1 = (d)localView.getLayoutParams();
        i3 = 0;
        m = i3;
        if (((d)localObject1).qE >= 0)
        {
          m = i3;
          if (i10 != 0)
          {
            i4 = R(((d)localObject1).qE);
            i15 = d.getAbsoluteGravity(T(((d)localObject1).gravity), i9) & 0x7;
            if (((i15 != 3) || (n != 0)) && ((i15 != 5) || (n == 0))) {
              break label670;
            }
            m = Math.max(0, i11 - i7 - i4);
          }
        }
        label388:
        if ((i1 == 0) || (android.support.v4.view.u.aq(localView))) {
          break label740;
        }
        i3 = this.qv.getSystemWindowInsetLeft();
        int i16 = this.qv.getSystemWindowInsetRight();
        i4 = this.qv.getSystemWindowInsetTop();
        i15 = this.qv.getSystemWindowInsetBottom();
        i3 = View.MeasureSpec.makeMeasureSpec(i11 - (i3 + i16), i10);
        i4 = View.MeasureSpec.makeMeasureSpec(i13 - (i4 + i15), i12);
        label467:
        localObject2 = ((d)localObject1).qC;
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
        if ((this.mIsAttachedToWindow) && (this.qt != null)) {
          getViewTreeObserver().removeOnPreDrawListener(this.qt);
        }
        this.qu = false;
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
      if (!((d)localObject).V(0)) {
        break label108;
      }
      localObject = ((d)localObject).qC;
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
        U(1);
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
      if (!((d)localObject).V(0)) {
        break label96;
      }
      localObject = ((d)localObject).qC;
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
      super.onRestoreInstanceState(paramParcelable.Pm);
      paramParcelable = paramParcelable.qS;
      int j = getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = getChildAt(i);
        int k = localView.getId();
        Behavior localBehavior = r(localView).qC;
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
      Behavior localBehavior = ((d)((View)localObject).getLayoutParams()).qC;
      if ((k != -1) && (localBehavior != null))
      {
        localObject = localBehavior.b(this, (View)localObject);
        if (localObject != null) {
          localSparseArray.append(k, localObject);
        }
      }
      i += 1;
    }
    localSavedState.qS = localSparseArray;
    return localSavedState;
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    return a(paramView1, paramView2, paramInt, 0);
  }
  
  public void onStopNestedScroll(View paramView)
  {
    k(paramView, 0);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    boolean bool2;
    if (this.qr == null)
    {
      bool2 = a(paramMotionEvent, 1);
      if (!bool2) {}
    }
    for (;;)
    {
      Behavior localBehavior = ((d)this.qr.getLayoutParams()).qC;
      boolean bool1;
      if (localBehavior != null) {
        bool1 = localBehavior.a(this, this.qr, paramMotionEvent);
      }
      for (;;)
      {
        if (this.qr == null)
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
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    Behavior localBehavior = ((d)paramView.getLayoutParams()).qC;
    if ((localBehavior != null) && (localBehavior.a(this, paramView, paramRect, paramBoolean))) {
      return true;
    }
    return super.requestChildRectangleOnScreen(paramView, paramRect, paramBoolean);
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    super.requestDisallowInterceptTouchEvent(paramBoolean);
    if ((paramBoolean) && (!this.qo))
    {
      w(false);
      this.qo = true;
    }
  }
  
  public final void s(View paramView)
  {
    List localList = this.qk.J(paramView);
    if ((localList != null) && (!localList.isEmpty()))
    {
      int i = 0;
      while (i < localList.size())
      {
        View localView = (View)localList.get(i);
        Behavior localBehavior = ((d)localView.getLayoutParams()).qC;
        if (localBehavior != null) {
          localBehavior.a(this, localView, paramView);
        }
        i += 1;
      }
    }
  }
  
  public void setFitsSystemWindows(boolean paramBoolean)
  {
    super.setFitsSystemWindows(paramBoolean);
    cx();
  }
  
  public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener paramOnHierarchyChangeListener)
  {
    this.qy = paramOnHierarchyChangeListener;
  }
  
  public void setStatusBarBackground(Drawable paramDrawable)
  {
    Drawable localDrawable = null;
    if (this.qx != paramDrawable)
    {
      if (this.qx != null) {
        this.qx.setCallback(null);
      }
      if (paramDrawable != null) {
        localDrawable = paramDrawable.mutate();
      }
      this.qx = localDrawable;
      if (this.qx != null)
      {
        if (this.qx.isStateful()) {
          this.qx.setState(getDrawableState());
        }
        a.b(this.qx, android.support.v4.view.u.Z(this));
        paramDrawable = this.qx;
        if (getVisibility() != 0) {
          break label114;
        }
      }
    }
    label114:
    for (boolean bool = true;; bool = false)
    {
      paramDrawable.setVisible(bool, false);
      this.qx.setCallback(this);
      android.support.v4.view.u.X(this);
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
      if ((this.qx != null) && (this.qx.isVisible() != bool)) {
        this.qx.setVisible(bool, false);
      }
      return;
    }
  }
  
  public final List<View> t(View paramView)
  {
    paramView = this.qk.K(paramView);
    this.qm.clear();
    if (paramView != null) {
      this.qm.addAll(paramView);
    }
    return this.qm;
  }
  
  public final List<View> u(View paramView)
  {
    paramView = this.qk.J(paramView);
    this.qm.clear();
    if (paramView != null) {
      this.qm.addAll(paramView);
    }
    return this.qm;
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.qx);
  }
  
  public static abstract class Behavior<V extends View>
  {
    public Behavior() {}
    
    public Behavior(Context paramContext, AttributeSet paramAttributeSet) {}
    
    public static ac b(ac paramac)
    {
      return paramac;
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
    SparseArray<Parcelable> qS;
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      int j = paramParcel.readInt();
      int[] arrayOfInt = new int[j];
      paramParcel.readIntArray(arrayOfInt);
      paramParcel = paramParcel.readParcelableArray(paramClassLoader);
      this.qS = new SparseArray(j);
      int i = 0;
      while (i < j)
      {
        this.qS.append(arrayOfInt[i], paramParcel[i]);
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
      if (this.qS != null) {}
      int[] arrayOfInt;
      Parcelable[] arrayOfParcelable;
      for (int i = this.qS.size();; i = 0)
      {
        paramParcel.writeInt(i);
        arrayOfInt = new int[i];
        arrayOfParcelable = new Parcelable[i];
        while (j < i)
        {
          arrayOfInt[j] = this.qS.keyAt(j);
          arrayOfParcelable[j] = ((Parcelable)this.qS.valueAt(j));
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
      if (CoordinatorLayout.this.qy != null) {
        CoordinatorLayout.this.qy.onChildViewAdded(paramView1, paramView2);
      }
    }
    
    public final void onChildViewRemoved(View paramView1, View paramView2)
    {
      CoordinatorLayout.this.U(2);
      if (CoordinatorLayout.this.qy != null) {
        CoordinatorLayout.this.qy.onChildViewRemoved(paramView1, paramView2);
      }
    }
  }
  
  public static final class d
    extends ViewGroup.MarginLayoutParams
  {
    public int anchorGravity = 0;
    public int gravity = 0;
    public CoordinatorLayout.Behavior qC;
    boolean qD = false;
    public int qE = -1;
    int qF = -1;
    public int qG = 0;
    public int qH = 0;
    int qI;
    int qJ;
    View qK;
    View qL;
    boolean qM;
    private boolean qN;
    private boolean qO;
    boolean qP;
    final Rect qQ = new Rect();
    Object qR;
    
    public d(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    d(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.CoordinatorLayout_Layout);
      this.gravity = localTypedArray.getInteger(0, 0);
      this.qF = localTypedArray.getResourceId(1, -1);
      this.anchorGravity = localTypedArray.getInteger(2, 0);
      this.qE = localTypedArray.getInteger(6, -1);
      this.qG = localTypedArray.getInt(5, 0);
      this.qH = localTypedArray.getInt(4, 0);
      this.qD = localTypedArray.hasValue(3);
      if (this.qD) {
        this.qC = CoordinatorLayout.a(paramContext, paramAttributeSet, localTypedArray.getString(3));
      }
      localTypedArray.recycle();
      if (this.qC != null) {
        this.qC.a(this);
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
    
    final boolean V(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return false;
      case 0: 
        return this.qN;
      }
      return this.qO;
    }
    
    public final void a(CoordinatorLayout.Behavior paramBehavior)
    {
      if (this.qC != paramBehavior)
      {
        this.qC = paramBehavior;
        this.qR = null;
        this.qD = true;
        if (paramBehavior != null) {
          paramBehavior.a(this);
        }
      }
    }
    
    final boolean cy()
    {
      return (this.qK == null) && (this.qF != -1);
    }
    
    final void d(int paramInt, boolean paramBoolean)
    {
      switch (paramInt)
      {
      default: 
        return;
      case 0: 
        this.qN = paramBoolean;
        return;
      }
      this.qO = paramBoolean;
    }
  }
  
  final class e
    implements ViewTreeObserver.OnPreDrawListener
  {
    e() {}
    
    public final boolean onPreDraw()
    {
      CoordinatorLayout.this.U(0);
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