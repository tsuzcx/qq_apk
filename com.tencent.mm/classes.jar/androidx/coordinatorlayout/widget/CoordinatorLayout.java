package androidx.coordinatorlayout.widget;

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
import androidx.b.g;
import androidx.coordinatorlayout.a.a;
import androidx.coordinatorlayout.a.b;
import androidx.coordinatorlayout.a.c;
import androidx.core.f.d;
import androidx.core.f.f.a;
import androidx.core.f.f.c;
import androidx.core.g.ae;
import androidx.core.g.ae.e;
import androidx.core.g.e;
import androidx.core.g.p;
import androidx.core.g.r;
import androidx.core.g.s;
import androidx.core.g.w;
import androidx.core.graphics.c;
import androidx.customview.view.AbsSavedState;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
  implements p
{
  static final String GT;
  static final Class<?>[] GU;
  static final ThreadLocal<Map<String, Constructor<Behavior>>> GV;
  static final Comparator<View> GW;
  private static final f.a<Rect> GX;
  private final List<View> GY;
  private final a<View> GZ;
  private final List<View> Ha;
  private final List<View> Hb;
  private final int[] Hc;
  private boolean Hd;
  private int[] He;
  private View Hf;
  private View Hg;
  private e Hh;
  private boolean Hi;
  ae Hj;
  boolean Hk;
  private Drawable Hl;
  ViewGroup.OnHierarchyChangeListener Hm;
  private s Hn;
  private final r Ho;
  private boolean mIsAttachedToWindow;
  
  static
  {
    AppMethodBeat.i(263437);
    Object localObject = CoordinatorLayout.class.getPackage();
    if (localObject != null)
    {
      localObject = ((Package)localObject).getName();
      GT = (String)localObject;
      if (Build.VERSION.SDK_INT < 21) {
        break label92;
      }
    }
    label92:
    for (GW = new CoordinatorLayout.f();; GW = null)
    {
      GU = new Class[] { Context.class, AttributeSet.class };
      GV = new ThreadLocal();
      GX = new f.c(12);
      AppMethodBeat.o(263437);
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
    AppMethodBeat.i(263355);
    this.GY = new ArrayList();
    this.GZ = new a();
    this.Ha = new ArrayList();
    this.Hb = new ArrayList();
    this.Hc = new int[2];
    this.Ho = new r();
    if (paramInt == 0) {}
    for (paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.c.CoordinatorLayout, 0, a.b.Widget_Support_CoordinatorLayout);; paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.c.CoordinatorLayout, paramInt, 0))
    {
      paramInt = paramAttributeSet.getResourceId(a.c.CoordinatorLayout_keylines, 0);
      if (paramInt == 0) {
        break;
      }
      paramContext = paramContext.getResources();
      this.He = paramContext.getIntArray(paramInt);
      float f = paramContext.getDisplayMetrics().density;
      int j = this.He.length;
      paramInt = i;
      while (paramInt < j)
      {
        paramContext = this.He;
        paramContext[paramInt] = ((int)(paramContext[paramInt] * f));
        paramInt += 1;
      }
    }
    this.Hl = paramAttributeSet.getDrawable(a.c.CoordinatorLayout_statusBarBackground);
    paramAttributeSet.recycle();
    ge();
    super.setOnHierarchyChangeListener(new c());
    AppMethodBeat.o(263355);
  }
  
  private void V(boolean paramBoolean)
  {
    AppMethodBeat.i(263367);
    int j = getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = getChildAt(i);
      Behavior localBehavior = ((d)localView.getLayoutParams()).Hq;
      MotionEvent localMotionEvent;
      if (localBehavior != null)
      {
        long l = SystemClock.uptimeMillis();
        localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        if (!paramBoolean) {
          break label87;
        }
        localBehavior.a(this, localView, localMotionEvent);
      }
      for (;;)
      {
        localMotionEvent.recycle();
        i += 1;
        break;
        label87:
        localBehavior.b(this, localView, localMotionEvent);
      }
    }
    i = 0;
    while (i < j)
    {
      ((d)getChildAt(i).getLayoutParams()).Hz = false;
      i += 1;
    }
    this.Hf = null;
    this.Hd = false;
    AppMethodBeat.o(263367);
  }
  
  static Behavior a(Context paramContext, AttributeSet paramAttributeSet, String paramString)
  {
    AppMethodBeat.i(263377);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(263377);
      return null;
    }
    String str;
    if (paramString.startsWith(".")) {
      str = paramContext.getPackageName() + paramString;
    }
    label243:
    for (;;)
    {
      try
      {
        paramString = (Map)GV.get();
        if (paramString != null) {
          break label243;
        }
        paramString = new HashMap();
        GV.set(paramString);
        Constructor localConstructor2 = (Constructor)paramString.get(str);
        Constructor localConstructor1 = localConstructor2;
        if (localConstructor2 == null)
        {
          localConstructor1 = paramContext.getClassLoader().loadClass(str).getConstructor(GU);
          localConstructor1.setAccessible(true);
          paramString.put(str, localConstructor1);
        }
        paramContext = (Behavior)localConstructor1.newInstance(new Object[] { paramContext, paramAttributeSet });
        AppMethodBeat.o(263377);
        return paramContext;
      }
      catch (Exception paramContext)
      {
        paramContext = new RuntimeException("Could not inflate Behavior subclass ".concat(String.valueOf(str)), paramContext);
        AppMethodBeat.o(263377);
        throw paramContext;
      }
      str = paramString;
      if (paramString.indexOf('.') < 0)
      {
        str = paramString;
        if (!TextUtils.isEmpty(GT)) {
          str = GT + '.' + paramString;
        }
      }
    }
  }
  
  private static void a(int paramInt1, Rect paramRect1, Rect paramRect2, d paramd, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(263396);
    int j = paramd.ek;
    int i = j;
    if (j == 0) {
      i = 17;
    }
    int k = e.D(i, paramInt1);
    i = e.D(bj(paramd.anchorGravity), paramInt1);
    switch (i & 0x7)
    {
    default: 
      paramInt1 = paramRect1.left;
      switch (i & 0x70)
      {
      default: 
        i = paramRect1.top;
        label118:
        j = paramInt1;
        switch (k & 0x7)
        {
        default: 
          j = paramInt1 - paramInt2;
        case 5: 
          label158:
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
      AppMethodBeat.o(263396);
      return;
      paramInt1 = paramRect1.right;
      break;
      paramInt1 = paramRect1.left;
      paramInt1 = paramRect1.width() / 2 + paramInt1;
      break;
      i = paramRect1.bottom;
      break label118;
      i = paramRect1.top + paramRect1.height() / 2;
      break label118;
      j = paramInt1 - paramInt2 / 2;
      break label158;
    }
  }
  
  private void a(View paramView, int paramInt, Rect paramRect1, Rect paramRect2)
  {
    AppMethodBeat.i(263398);
    d locald = (d)paramView.getLayoutParams();
    int i = paramView.getMeasuredWidth();
    int j = paramView.getMeasuredHeight();
    a(paramInt, paramRect1, paramRect2, locald, i, j);
    a(locald, paramRect2, i, j);
    AppMethodBeat.o(263398);
  }
  
  private void a(View paramView1, View paramView2, int paramInt)
  {
    AppMethodBeat.i(263399);
    Rect localRect1 = gc();
    Rect localRect2 = gc();
    try
    {
      b.a(this, paramView2, localRect1);
      a(paramView1, paramInt, localRect1, localRect2);
      paramView1.layout(localRect2.left, localRect2.top, localRect2.right, localRect2.bottom);
      return;
    }
    finally
    {
      d(localRect1);
      d(localRect2);
      AppMethodBeat.o(263399);
    }
  }
  
  private void a(View paramView, boolean paramBoolean, Rect paramRect)
  {
    AppMethodBeat.i(263394);
    if ((paramView.isLayoutRequested()) || (paramView.getVisibility() == 8))
    {
      paramRect.setEmpty();
      AppMethodBeat.o(263394);
      return;
    }
    if (paramBoolean)
    {
      b.a(this, paramView, paramRect);
      AppMethodBeat.o(263394);
      return;
    }
    paramRect.set(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
    AppMethodBeat.o(263394);
  }
  
  private void a(d paramd, Rect paramRect, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(263397);
    int j = getWidth();
    int i = getHeight();
    j = Math.max(getPaddingLeft() + paramd.leftMargin, Math.min(paramRect.left, j - getPaddingRight() - paramInt1 - paramd.rightMargin));
    i = Math.max(getPaddingTop() + paramd.topMargin, Math.min(paramRect.top, i - getPaddingBottom() - paramInt2 - paramd.bottomMargin));
    paramRect.set(j, i, j + paramInt1, i + paramInt2);
    AppMethodBeat.o(263397);
  }
  
  private boolean b(MotionEvent paramMotionEvent, int paramInt)
  {
    AppMethodBeat.i(263371);
    boolean bool1 = false;
    int k = 0;
    int m = paramMotionEvent.getActionMasked();
    List localList = this.Ha;
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
    if (GW != null) {
      Collections.sort(localList, GW);
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
      localBehavior = locald.Hq;
      if (((bool1) || (i != 0)) && (m != 0))
      {
        if (localBehavior == null) {
          break label466;
        }
        if (localMotionEvent != null) {
          break label463;
        }
        long l = SystemClock.uptimeMillis();
        localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        label205:
        switch (paramInt)
        {
        }
      }
    }
    label308:
    label438:
    label447:
    label463:
    label466:
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
          this.Hf = localView;
          bool2 = bool1;
        }
        bool1 = bool2;
        if (locald.Hq == null) {
          locald.Hz = false;
        }
        boolean bool3 = locald.Hz;
        if (locald.Hz)
        {
          bool2 = true;
          label363:
          if ((!bool2) || (bool3)) {
            break label438;
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
            break label447;
          }
        }
        break;
        bool1 = localBehavior.a(this, localView, paramMotionEvent);
        break label308;
        bool1 = localBehavior.b(this, localView, paramMotionEvent);
        break label308;
        bool2 = locald.Hz | false;
        locald.Hz = bool2;
        break label363;
      }
      bool2 = bool1;
      localList.clear();
      AppMethodBeat.o(263371);
      return bool2;
      break label205;
    }
  }
  
  private int bi(int paramInt)
  {
    AppMethodBeat.i(263376);
    if (this.He == null)
    {
      new StringBuilder("No keylines defined for ").append(this).append(" - attempted index lookup ").append(paramInt);
      AppMethodBeat.o(263376);
      return 0;
    }
    if ((paramInt < 0) || (paramInt >= this.He.length))
    {
      new StringBuilder("Keyline index ").append(paramInt).append(" out of range for ").append(this);
      AppMethodBeat.o(263376);
      return 0;
    }
    paramInt = this.He[paramInt];
    AppMethodBeat.o(263376);
    return paramInt;
  }
  
  private static int bj(int paramInt)
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
  
  private static int bk(int paramInt)
  {
    int i = paramInt;
    if (paramInt == 0) {
      i = 8388661;
    }
    return i;
  }
  
  private void c(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(263400);
    d locald = (d)paramView.getLayoutParams();
    int i1 = e.D(bk(locald.ek), paramInt2);
    int n = getWidth();
    int m = getHeight();
    int j = paramView.getMeasuredWidth();
    int k = paramView.getMeasuredHeight();
    int i = paramInt1;
    if (paramInt2 == 1) {
      i = n - paramInt1;
    }
    paramInt1 = bi(i) - j;
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
      AppMethodBeat.o(263400);
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
  
  private static void d(Rect paramRect)
  {
    AppMethodBeat.i(263354);
    paramRect.setEmpty();
    GX.release(paramRect);
    AppMethodBeat.o(263354);
  }
  
  private static Rect gc()
  {
    AppMethodBeat.i(263353);
    Rect localRect2 = (Rect)GX.acquire();
    Rect localRect1 = localRect2;
    if (localRect2 == null) {
      localRect1 = new Rect();
    }
    AppMethodBeat.o(263353);
    return localRect1;
  }
  
  private void gd()
  {
    AppMethodBeat.i(263382);
    this.GY.clear();
    Object localObject1 = this.GZ;
    int j = ((a)localObject1).HH.size();
    int i = 0;
    Object localObject2;
    while (i < j)
    {
      localObject2 = (ArrayList)((a)localObject1).HH.aM(i);
      if (localObject2 != null)
      {
        ((ArrayList)localObject2).clear();
        ((a)localObject1).HG.release(localObject2);
      }
      i += 1;
    }
    ((a)localObject1).HH.clear();
    int m = getChildCount();
    j = 0;
    while (j < m)
    {
      View localView1 = getChildAt(j);
      d locald = v(localView1);
      if (locald.Ht == -1)
      {
        locald.Hy = null;
        locald.lJ = null;
        this.GZ.v(localView1);
        i = 0;
      }
      for (;;)
      {
        if (i >= m) {
          break label818;
        }
        if (i != j)
        {
          View localView2 = getChildAt(i);
          int k;
          if (localView2 != locald.Hy)
          {
            k = w.I(this);
            int n = e.D(((d)localView2.getLayoutParams()).Hu, k);
            if ((n != 0) && ((e.D(locald.Hv, k) & n) == n))
            {
              k = 1;
              label223:
              if ((k == 0) && ((locald.Hq == null) || (!locald.Hq.a(this, localView1, localView2)))) {
                break label728;
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
              if (!this.GZ.HH.containsKey(localView2)) {
                this.GZ.v(localView2);
              }
              a locala = this.GZ;
              if ((!locala.HH.containsKey(localView2)) || (!locala.HH.containsKey(localView1)))
              {
                localObject1 = new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
                AppMethodBeat.o(263382);
                throw ((Throwable)localObject1);
                if (locald.lJ != null)
                {
                  if (locald.lJ.getId() == locald.Ht) {
                    break label417;
                  }
                  i = 0;
                }
                for (;;)
                {
                  if (i != 0) {
                    break label506;
                  }
                  locald.lJ = findViewById(locald.Ht);
                  if (locald.lJ == null) {
                    break label644;
                  }
                  if (locald.lJ != this) {
                    break label529;
                  }
                  if (!isInEditMode()) {
                    break label508;
                  }
                  locald.Hy = null;
                  locald.lJ = null;
                  break;
                  label417:
                  localObject2 = locald.lJ;
                  for (localObject1 = locald.lJ.getParent();; localObject1 = ((ViewParent)localObject1).getParent())
                  {
                    if (localObject1 == this) {
                      break label496;
                    }
                    if ((localObject1 == null) || (localObject1 == localView1))
                    {
                      locald.Hy = null;
                      locald.lJ = null;
                      i = 0;
                      break;
                    }
                    if ((localObject1 instanceof View)) {
                      localObject2 = (View)localObject1;
                    }
                  }
                  label496:
                  locald.Hy = ((View)localObject2);
                  i = 1;
                }
                label506:
                break;
                label508:
                localObject1 = new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                AppMethodBeat.o(263382);
                throw ((Throwable)localObject1);
                label529:
                localObject2 = locald.lJ;
                for (localObject1 = locald.lJ.getParent();; localObject1 = ((ViewParent)localObject1).getParent())
                {
                  if ((localObject1 == this) || (localObject1 == null)) {
                    break label634;
                  }
                  if (localObject1 == localView1)
                  {
                    if (isInEditMode())
                    {
                      locald.Hy = null;
                      locald.lJ = null;
                      break;
                    }
                    localObject1 = new IllegalStateException("Anchor must not be a descendant of the anchored view");
                    AppMethodBeat.o(263382);
                    throw ((Throwable)localObject1);
                  }
                  if ((localObject1 instanceof View)) {
                    localObject2 = (View)localObject1;
                  }
                }
                label634:
                locald.Hy = ((View)localObject2);
                break;
                label644:
                if (isInEditMode())
                {
                  locald.Hy = null;
                  locald.lJ = null;
                  break;
                }
                localObject1 = new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + getResources().getResourceName(locald.Ht) + " to anchor view " + localView1);
                AppMethodBeat.o(263382);
                throw ((Throwable)localObject1);
                k = 0;
                break label223;
                label728:
                k = 0;
                continue;
              }
              localObject2 = (ArrayList)locala.HH.get(localView2);
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                localObject2 = (ArrayList)locala.HG.acquire();
                localObject1 = localObject2;
                if (localObject2 == null) {
                  localObject1 = new ArrayList();
                }
                locala.HH.put(localView2, localObject1);
              }
              ((ArrayList)localObject1).add(localView1);
            }
          }
        }
        i += 1;
      }
      label818:
      j += 1;
    }
    this.GY.addAll(this.GZ.gh());
    Collections.reverse(this.GY);
    AppMethodBeat.o(263382);
  }
  
  private void ge()
  {
    AppMethodBeat.i(263432);
    if (Build.VERSION.SDK_INT < 21)
    {
      AppMethodBeat.o(263432);
      return;
    }
    if (w.Z(this))
    {
      if (this.Hn == null) {
        this.Hn = new s()
        {
          public final ae a(View paramAnonymousView, ae paramAnonymousae)
          {
            boolean bool2 = true;
            int i = 0;
            AppMethodBeat.i(263323);
            CoordinatorLayout localCoordinatorLayout = CoordinatorLayout.this;
            if (!d.equals(localCoordinatorLayout.Hj, paramAnonymousae))
            {
              localCoordinatorLayout.Hj = paramAnonymousae;
              if ((paramAnonymousae != null) && (paramAnonymousae.Oa.hp().top > 0))
              {
                bool1 = true;
                localCoordinatorLayout.Hk = bool1;
                if ((localCoordinatorLayout.Hk) || (localCoordinatorLayout.getBackground() != null)) {
                  break label172;
                }
              }
              label172:
              for (boolean bool1 = bool2;; bool1 = false)
              {
                localCoordinatorLayout.setWillNotDraw(bool1);
                if (paramAnonymousae.Oa.hk()) {
                  break label193;
                }
                int j = localCoordinatorLayout.getChildCount();
                paramAnonymousView = paramAnonymousae;
                while (i < j)
                {
                  paramAnonymousae = localCoordinatorLayout.getChildAt(i);
                  if ((!w.Z(paramAnonymousae)) || (((CoordinatorLayout.d)paramAnonymousae.getLayoutParams()).Hq == null)) {
                    break label190;
                  }
                  paramAnonymousae = CoordinatorLayout.Behavior.a(paramAnonymousView);
                  paramAnonymousView = paramAnonymousae;
                  if (paramAnonymousae.Oa.hk()) {
                    break;
                  }
                  paramAnonymousView = paramAnonymousae;
                  i += 1;
                }
                bool1 = false;
                break;
              }
              label178:
              localCoordinatorLayout.requestLayout();
            }
            for (;;)
            {
              AppMethodBeat.o(263323);
              return paramAnonymousView;
              label190:
              break;
              label193:
              paramAnonymousView = paramAnonymousae;
              break label178;
              paramAnonymousView = paramAnonymousae;
            }
          }
        };
      }
      w.a(this, this.Hn);
      setSystemUiVisibility(1280);
      AppMethodBeat.o(263432);
      return;
    }
    w.a(this, null);
    AppMethodBeat.o(263432);
  }
  
  private void i(View paramView, int paramInt)
  {
    AppMethodBeat.i(263401);
    d locald = (d)paramView.getLayoutParams();
    Rect localRect1 = gc();
    localRect1.set(getPaddingLeft() + locald.leftMargin, getPaddingTop() + locald.topMargin, getWidth() - getPaddingRight() - locald.rightMargin, getHeight() - getPaddingBottom() - locald.bottomMargin);
    if ((this.Hj != null) && (w.Z(this)) && (!w.Z(paramView)))
    {
      localRect1.left += this.Hj.Oa.hp().left;
      localRect1.top += this.Hj.Oa.hp().top;
      localRect1.right -= this.Hj.Oa.hp().right;
      localRect1.bottom -= this.Hj.Oa.hp().bottom;
    }
    Rect localRect2 = gc();
    e.a(bj(locald.ek), paramView.getMeasuredWidth(), paramView.getMeasuredHeight(), localRect1, localRect2, paramInt);
    paramView.layout(localRect2.left, localRect2.top, localRect2.right, localRect2.bottom);
    d(localRect1);
    d(localRect2);
    AppMethodBeat.o(263401);
  }
  
  private static void j(View paramView, int paramInt)
  {
    AppMethodBeat.i(263405);
    d locald = (d)paramView.getLayoutParams();
    if (locald.Hw != paramInt)
    {
      w.u(paramView, paramInt - locald.Hw);
      locald.Hw = paramInt;
    }
    AppMethodBeat.o(263405);
  }
  
  private static void k(View paramView, int paramInt)
  {
    AppMethodBeat.i(263406);
    d locald = (d)paramView.getLayoutParams();
    if (locald.Hx != paramInt)
    {
      w.s(paramView, paramInt - locald.Hx);
      locald.Hx = paramInt;
    }
    AppMethodBeat.o(263406);
  }
  
  private static d v(View paramView)
  {
    AppMethodBeat.i(263379);
    d locald = (d)paramView.getLayoutParams();
    if (!locald.Hr)
    {
      if (!(paramView instanceof CoordinatorLayout.a)) {
        break label54;
      }
      locald.a(((CoordinatorLayout.a)paramView).getBehavior());
      locald.Hr = true;
    }
    for (;;)
    {
      AppMethodBeat.o(263379);
      return locald;
      label54:
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
        locald.a((Behavior)localView.gf().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        locald.Hr = true;
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          new StringBuilder("Default behavior class ").append(localView.gf().getName()).append(" could not be instantiated. Did you forget a default constructor?");
        }
      }
    }
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(263421);
    int k = getChildCount();
    int i = 0;
    int j = 0;
    if (j < k)
    {
      View localView = getChildAt(j);
      if (localView.getVisibility() == 8) {
        break label121;
      }
      Object localObject = (d)localView.getLayoutParams();
      if (!((d)localObject).bm(paramInt5)) {
        break label121;
      }
      localObject = ((d)localObject).Hq;
      if (localObject == null) {
        break label121;
      }
      ((Behavior)localObject).a(this, localView, paramView, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
      i = 1;
    }
    label121:
    for (;;)
    {
      j += 1;
      break;
      if (i != 0) {
        bl(1);
      }
      AppMethodBeat.o(263421);
      return;
    }
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    AppMethodBeat.i(263424);
    int j = 0;
    int i = 0;
    int k = 0;
    int i2 = getChildCount();
    int m = 0;
    label133:
    label150:
    int n;
    if (m < i2)
    {
      View localView = getChildAt(m);
      if (localView.getVisibility() == 8) {
        break label251;
      }
      Object localObject = (d)localView.getLayoutParams();
      if (!((d)localObject).bm(paramInt3)) {
        break label251;
      }
      localObject = ((d)localObject).Hq;
      if (localObject == null) {
        break label251;
      }
      int[] arrayOfInt = this.Hc;
      this.Hc[1] = 0;
      arrayOfInt[0] = 0;
      ((Behavior)localObject).a(this, localView, paramView, paramInt1, paramInt2, this.Hc, paramInt3);
      if (paramInt1 > 0)
      {
        j = Math.max(j, this.Hc[0]);
        if (paramInt2 <= 0) {
          break label206;
        }
        k = Math.max(i, this.Hc[1]);
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
      j = Math.min(j, this.Hc[0]);
      break label133;
      label206:
      k = Math.min(i, this.Hc[1]);
      break label150;
      paramArrayOfInt[0] = j;
      paramArrayOfInt[1] = i;
      if (k != 0) {
        bl(1);
      }
      AppMethodBeat.o(263424);
      return;
      label251:
      n = i;
      i = j;
      j = n;
      n = k;
    }
  }
  
  public final boolean a(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(263414);
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
        Behavior localBehavior = locald.Hq;
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
    AppMethodBeat.o(263414);
    return bool1;
  }
  
  public final void b(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(263416);
    this.Ho.F(paramInt1, paramInt2);
    this.Hg = paramView2;
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      Object localObject = (d)localView.getLayoutParams();
      if (((d)localObject).bm(paramInt2))
      {
        localObject = ((d)localObject).Hq;
        if (localObject != null) {
          ((Behavior)localObject).b(this, localView, paramView1, paramView2, paramInt1, paramInt2);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(263416);
  }
  
  final void bl(int paramInt)
  {
    AppMethodBeat.i(263404);
    int m = w.I(this);
    int n = this.GY.size();
    Object localObject1 = gc();
    Rect localRect1 = gc();
    Rect localRect2 = gc();
    int j = 0;
    View localView;
    Object localObject2;
    int i;
    Object localObject3;
    Object localObject4;
    if (j < n)
    {
      localView = (View)this.GY.get(j);
      localObject2 = (d)localView.getLayoutParams();
      if ((paramInt != 0) || (localView.getVisibility() != 8))
      {
        i = 0;
        int i1;
        int i2;
        int k;
        if (i < j)
        {
          localObject3 = (View)this.GY.get(i);
          Rect localRect4;
          if (((d)localObject2).Hy == localObject3)
          {
            localObject3 = (d)localView.getLayoutParams();
            if (((d)localObject3).lJ != null)
            {
              localObject4 = gc();
              localRect3 = gc();
              localRect4 = gc();
              b.a(this, ((d)localObject3).lJ, (Rect)localObject4);
              a(localView, false, localRect3);
              i1 = localView.getMeasuredWidth();
              i2 = localView.getMeasuredHeight();
              a(m, (Rect)localObject4, localRect4, (d)localObject3, i1, i2);
              if ((localRect4.left == localRect3.left) && (localRect4.top == localRect3.top)) {
                break label343;
              }
            }
          }
          label343:
          for (k = 1;; k = 0)
          {
            a((d)localObject3, localRect4, i1, i2);
            i1 = localRect4.left - localRect3.left;
            i2 = localRect4.top - localRect3.top;
            if (i1 != 0) {
              w.u(localView, i1);
            }
            if (i2 != 0) {
              w.s(localView, i2);
            }
            if (k != 0)
            {
              Behavior localBehavior = ((d)localObject3).Hq;
              if (localBehavior != null) {
                localBehavior.b(this, localView, ((d)localObject3).lJ);
              }
            }
            d((Rect)localObject4);
            d(localRect3);
            d(localRect4);
            i += 1;
            break;
          }
        }
        a(localView, true, localRect1);
        if ((((d)localObject2).Hu != 0) && (!localRect1.isEmpty()))
        {
          i = e.D(((d)localObject2).Hu, m);
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
          if ((((d)localObject2).Hv != 0) && (localView.getVisibility() == 0) && (w.ah(localView)) && (localView.getWidth() > 0) && (localView.getHeight() > 0)) {
            break label714;
          }
          label488:
          if (paramInt != 2)
          {
            localRect2.set(((d)localView.getLayoutParams()).HD);
            if (localRect2.equals(localRect1)) {
              break label1221;
            }
            ((d)localView.getLayoutParams()).HD.set(localRect1);
          }
          i = j + 1;
          for (;;)
          {
            if (i >= n) {
              break label1221;
            }
            localObject2 = (View)this.GY.get(i);
            localObject3 = (d)((View)localObject2).getLayoutParams();
            localObject4 = ((d)localObject3).Hq;
            if ((localObject4 != null) && (((Behavior)localObject4).a(this, (View)localObject2, localView)))
            {
              if ((paramInt != 0) || (!((d)localObject3).HC)) {
                break;
              }
              ((d)localObject3).HC = false;
            }
            i += 1;
          }
          ((Rect)localObject1).top = Math.max(((Rect)localObject1).top, localRect1.bottom);
          break;
          ((Rect)localObject1).bottom = Math.max(((Rect)localObject1).bottom, getHeight() - localRect1.top);
          break;
          ((Rect)localObject1).left = Math.max(((Rect)localObject1).left, localRect1.right);
          continue;
          ((Rect)localObject1).right = Math.max(((Rect)localObject1).right, getWidth() - localRect1.left);
        }
        label714:
        localObject2 = (d)localView.getLayoutParams();
        localObject3 = ((d)localObject2).Hq;
        localObject4 = gc();
        Rect localRect3 = gc();
        localRect3.set(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
        if ((localObject3 != null) && (((Behavior)localObject3).a(this, localView, (Rect)localObject4)))
        {
          if (!localRect3.contains((Rect)localObject4))
          {
            localObject1 = new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + ((Rect)localObject4).toShortString() + " | Bounds:" + localRect3.toShortString());
            AppMethodBeat.o(263404);
            throw ((Throwable)localObject1);
          }
        }
        else {
          ((Rect)localObject4).set(localRect3);
        }
        d(localRect3);
        if (!((Rect)localObject4).isEmpty())
        {
          i1 = e.D(((d)localObject2).Hv, m);
          k = 0;
          i = k;
          if ((i1 & 0x30) == 48)
          {
            i2 = ((Rect)localObject4).top - ((d)localObject2).topMargin - ((d)localObject2).Hx;
            i = k;
            if (i2 < ((Rect)localObject1).top)
            {
              k(localView, ((Rect)localObject1).top - i2);
              i = 1;
            }
          }
          k = i;
          if ((i1 & 0x50) == 80)
          {
            i2 = getHeight() - ((Rect)localObject4).bottom - ((d)localObject2).bottomMargin + ((d)localObject2).Hx;
            k = i;
            if (i2 < ((Rect)localObject1).bottom)
            {
              k(localView, i2 - ((Rect)localObject1).bottom);
              k = 1;
            }
          }
          if (k == 0) {
            k(localView, 0);
          }
          k = 0;
          i = k;
          if ((i1 & 0x3) == 3)
          {
            i2 = ((Rect)localObject4).left - ((d)localObject2).leftMargin - ((d)localObject2).Hw;
            i = k;
            if (i2 < ((Rect)localObject1).left)
            {
              j(localView, ((Rect)localObject1).left - i2);
              i = 1;
            }
          }
          if ((i1 & 0x5) != 5) {
            break label1250;
          }
          k = getWidth();
          i1 = ((Rect)localObject4).right;
          i2 = ((d)localObject2).rightMargin;
          k = ((d)localObject2).Hw + (k - i1 - i2);
          if (k >= ((Rect)localObject1).right) {
            break label1250;
          }
          j(localView, k - ((Rect)localObject1).right);
          i = 1;
        }
      }
    }
    label1221:
    label1250:
    for (;;)
    {
      if (i == 0) {
        j(localView, 0);
      }
      d((Rect)localObject4);
      break label488;
      switch (paramInt)
      {
      }
      for (boolean bool = ((Behavior)localObject4).b(this, (View)localObject2, localView); paramInt == 1; bool = true)
      {
        ((d)localObject3).HC = bool;
        break;
      }
      j += 1;
      break;
      d((Rect)localObject1);
      d(localRect1);
      d(localRect2);
      AppMethodBeat.o(263404);
      return;
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(263412);
    if (((paramLayoutParams instanceof d)) && (super.checkLayoutParams(paramLayoutParams)))
    {
      AppMethodBeat.o(263412);
      return true;
    }
    AppMethodBeat.o(263412);
    return false;
  }
  
  public final boolean d(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(263411);
    Rect localRect = gc();
    b.a(this, paramView, localRect);
    try
    {
      boolean bool = localRect.contains(paramInt1, paramInt2);
      return bool;
    }
    finally
    {
      d(localRect);
      AppMethodBeat.o(263411);
    }
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    AppMethodBeat.i(263403);
    paramView.getLayoutParams();
    boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
    AppMethodBeat.o(263403);
    return bool;
  }
  
  protected void drawableStateChanged()
  {
    AppMethodBeat.i(263360);
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    boolean bool2 = false;
    Drawable localDrawable = this.Hl;
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
    AppMethodBeat.o(263360);
  }
  
  public final void e(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(263385);
    measureChildWithMargins(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(263385);
  }
  
  final List<View> getDependencySortedChildren()
  {
    AppMethodBeat.i(263410);
    gd();
    List localList = Collections.unmodifiableList(this.GY);
    AppMethodBeat.o(263410);
    return localList;
  }
  
  public final ae getLastWindowInsets()
  {
    return this.Hj;
  }
  
  public int getNestedScrollAxes()
  {
    AppMethodBeat.i(263427);
    int i = this.Ho.getNestedScrollAxes();
    AppMethodBeat.o(263427);
    return i;
  }
  
  public Drawable getStatusBarBackground()
  {
    return this.Hl;
  }
  
  protected int getSuggestedMinimumHeight()
  {
    AppMethodBeat.i(263384);
    int i = Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    AppMethodBeat.o(263384);
    return i;
  }
  
  protected int getSuggestedMinimumWidth()
  {
    AppMethodBeat.i(263383);
    int i = Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    AppMethodBeat.o(263383);
    return i;
  }
  
  public final void h(View paramView, int paramInt)
  {
    AppMethodBeat.i(263389);
    d locald = (d)paramView.getLayoutParams();
    if (locald.gg())
    {
      paramView = new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
      AppMethodBeat.o(263389);
      throw paramView;
    }
    if (locald.lJ != null)
    {
      a(paramView, locald.lJ, paramInt);
      AppMethodBeat.o(263389);
      return;
    }
    if (locald.Hs >= 0)
    {
      c(paramView, locald.Hs, paramInt);
      AppMethodBeat.o(263389);
      return;
    }
    i(paramView, paramInt);
    AppMethodBeat.o(263389);
  }
  
  public final void l(View paramView, int paramInt)
  {
    AppMethodBeat.i(263419);
    this.Ho.bz(paramInt);
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      d locald = (d)localView.getLayoutParams();
      if (locald.bm(paramInt))
      {
        Behavior localBehavior = locald.Hq;
        if (localBehavior != null) {
          localBehavior.a(this, localView, paramView, paramInt);
        }
        locald.d(paramInt, false);
        locald.HC = false;
      }
      i += 1;
    }
    this.Hg = null;
    AppMethodBeat.o(263419);
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(263356);
    super.onAttachedToWindow();
    V(false);
    if (this.Hi)
    {
      if (this.Hh == null) {
        this.Hh = new e();
      }
      getViewTreeObserver().addOnPreDrawListener(this.Hh);
    }
    if ((this.Hj == null) && (w.Z(this))) {
      w.Y(this);
    }
    this.mIsAttachedToWindow = true;
    AppMethodBeat.o(263356);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(263357);
    super.onDetachedFromWindow();
    V(false);
    if ((this.Hi) && (this.Hh != null)) {
      getViewTreeObserver().removeOnPreDrawListener(this.Hh);
    }
    if (this.Hg != null) {
      onStopNestedScroll(this.Hg);
    }
    this.mIsAttachedToWindow = false;
    AppMethodBeat.o(263357);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(263391);
    super.onDraw(paramCanvas);
    if ((this.Hk) && (this.Hl != null)) {
      if (this.Hj == null) {
        break label79;
      }
    }
    label79:
    for (int i = this.Hj.Oa.hp().top;; i = 0)
    {
      if (i > 0)
      {
        this.Hl.setBounds(0, 0, getWidth(), i);
        this.Hl.draw(paramCanvas);
      }
      AppMethodBeat.o(263391);
      return;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(263372);
    int i = paramMotionEvent.getActionMasked();
    if (i == 0) {
      V(true);
    }
    boolean bool = b(paramMotionEvent, 0);
    if ((i == 1) || (i == 3)) {
      V(true);
    }
    AppMethodBeat.o(263372);
    return bool;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(263390);
    paramInt2 = w.I(this);
    paramInt3 = this.GY.size();
    paramInt1 = 0;
    while (paramInt1 < paramInt3)
    {
      View localView = (View)this.GY.get(paramInt1);
      if (localView.getVisibility() != 8)
      {
        Behavior localBehavior = ((d)localView.getLayoutParams()).Hq;
        if ((localBehavior == null) || (!localBehavior.a(this, localView, paramInt2))) {
          h(localView, paramInt2);
        }
      }
      paramInt1 += 1;
    }
    AppMethodBeat.o(263390);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(263387);
    gd();
    int k = getChildCount();
    int i = 0;
    View localView;
    Object localObject1;
    int m;
    int j;
    label50:
    Object localObject2;
    if (i < k)
    {
      localView = getChildAt(i);
      localObject1 = this.GZ;
      m = ((a)localObject1).HH.size();
      j = 0;
      if (j < m)
      {
        localObject2 = (ArrayList)((a)localObject1).HH.aM(j);
        if ((localObject2 != null) && (((ArrayList)localObject2).contains(localView)))
        {
          j = 1;
          label90:
          if (j == 0) {
            break label648;
          }
        }
      }
    }
    for (int i17 = 1;; i17 = 0)
    {
      label154:
      int i5;
      int n;
      label193:
      int i1;
      label248:
      int i2;
      label262:
      int i3;
      int i4;
      int i15;
      if (i17 != this.Hi)
      {
        if (i17 != 0)
        {
          if (this.mIsAttachedToWindow)
          {
            if (this.Hh == null) {
              this.Hh = new e();
            }
            getViewTreeObserver().addOnPreDrawListener(this.Hh);
          }
          this.Hi = true;
        }
      }
      else
      {
        i5 = getPaddingLeft();
        int i6 = getPaddingTop();
        int i7 = getPaddingRight();
        int i8 = getPaddingBottom();
        int i9 = w.I(this);
        if (i9 != 1) {
          break label688;
        }
        n = 1;
        int i10 = View.MeasureSpec.getMode(paramInt1);
        int i11 = View.MeasureSpec.getSize(paramInt1);
        int i12 = View.MeasureSpec.getMode(paramInt2);
        int i13 = View.MeasureSpec.getSize(paramInt2);
        k = getSuggestedMinimumWidth();
        j = getSuggestedMinimumHeight();
        i = 0;
        if ((this.Hj == null) || (!w.Z(this))) {
          break label694;
        }
        i1 = 1;
        int i14 = this.GY.size();
        i2 = 0;
        if (i2 >= i14) {
          break label744;
        }
        localView = (View)this.GY.get(i2);
        if (localView.getVisibility() == 8) {
          break label785;
        }
        localObject1 = (d)localView.getLayoutParams();
        i3 = 0;
        m = i3;
        if (((d)localObject1).Hs >= 0)
        {
          m = i3;
          if (i10 != 0)
          {
            i4 = bi(((d)localObject1).Hs);
            i15 = e.D(bk(((d)localObject1).ek), i9) & 0x7;
            if (((i15 != 3) || (n != 0)) && ((i15 != 5) || (n == 0))) {
              break label700;
            }
            m = Math.max(0, i11 - i7 - i4);
          }
        }
        label394:
        if ((i1 == 0) || (w.Z(localView))) {
          break label776;
        }
        i3 = this.Hj.Oa.hp().left;
        int i16 = this.Hj.Oa.hp().right;
        i4 = this.Hj.Oa.hp().top;
        i15 = this.Hj.Oa.hp().bottom;
        i3 = View.MeasureSpec.makeMeasureSpec(i11 - (i3 + i16), i10);
        i4 = View.MeasureSpec.makeMeasureSpec(i13 - (i4 + i15), i12);
        label497:
        localObject2 = ((d)localObject1).Hq;
        if ((localObject2 == null) || (!((Behavior)localObject2).a(this, localView, i3, m, i4, 0))) {
          e(localView, i3, m, i4, 0);
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
        break label262;
        j += 1;
        break label50;
        j = 0;
        break label90;
        label648:
        i += 1;
        break;
        if ((this.mIsAttachedToWindow) && (this.Hh != null)) {
          getViewTreeObserver().removeOnPreDrawListener(this.Hh);
        }
        this.Hi = false;
        break label154;
        label688:
        n = 0;
        break label193;
        label694:
        i1 = 0;
        break label248;
        label700:
        if ((i15 != 5) || (n != 0))
        {
          m = i3;
          if (i15 != 3) {
            break label394;
          }
          m = i3;
          if (n == 0) {
            break label394;
          }
        }
        m = Math.max(0, i4 - i5);
        break label394;
        label744:
        setMeasuredDimension(View.resolveSizeAndState(k, paramInt1, 0xFF000000 & i), View.resolveSizeAndState(j, paramInt2, i << 16));
        AppMethodBeat.o(263387);
        return;
        label776:
        i4 = paramInt2;
        i3 = paramInt1;
        break label497;
        label785:
        m = k;
        k = i;
      }
    }
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(263425);
    boolean bool = false;
    int j = getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 8) {
        break label120;
      }
      Object localObject = (d)localView.getLayoutParams();
      if (!((d)localObject).bm(0)) {
        break label120;
      }
      localObject = ((d)localObject).Hq;
      if (localObject == null) {
        break label120;
      }
      bool = ((Behavior)localObject).a(this, localView, paramView, paramFloat1, paramFloat2, paramBoolean) | bool;
    }
    label120:
    for (;;)
    {
      i += 1;
      break;
      if (bool) {
        bl(1);
      }
      AppMethodBeat.o(263425);
      return bool;
    }
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(263426);
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
      if (!((d)localObject).bm(0)) {
        break label108;
      }
      localObject = ((d)localObject).Hq;
      if (localObject == null) {
        break label108;
      }
      bool = ((Behavior)localObject).a(this, localView, paramView, paramFloat1, paramFloat2) | bool;
    }
    label108:
    for (;;)
    {
      i += 1;
      break;
      AppMethodBeat.o(263426);
      return bool;
    }
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(263423);
    a(paramView, paramInt1, paramInt2, paramArrayOfInt, 0);
    AppMethodBeat.o(263423);
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(263420);
    a(paramView, paramInt1, paramInt2, paramInt3, paramInt4, 0);
    AppMethodBeat.o(263420);
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    AppMethodBeat.i(263415);
    b(paramView1, paramView2, paramInt, 0);
    AppMethodBeat.o(263415);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(263429);
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      AppMethodBeat.o(263429);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.Rb);
    paramParcelable = paramParcelable.HF;
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      int k = localView.getId();
      Behavior localBehavior = v(localView).Hq;
      if ((k != -1) && (localBehavior != null))
      {
        Parcelable localParcelable = (Parcelable)paramParcelable.get(k);
        if (localParcelable != null) {
          localBehavior.a(this, localView, localParcelable);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(263429);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(263430);
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    SparseArray localSparseArray = new SparseArray();
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = getChildAt(i);
      int k = ((View)localObject).getId();
      Behavior localBehavior = ((d)((View)localObject).getLayoutParams()).Hq;
      if ((k != -1) && (localBehavior != null))
      {
        localObject = localBehavior.a(this, (View)localObject);
        if (localObject != null) {
          localSparseArray.append(k, localObject);
        }
      }
      i += 1;
    }
    localSavedState.HF = localSparseArray;
    AppMethodBeat.o(263430);
    return localSavedState;
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    AppMethodBeat.i(263413);
    boolean bool = a(paramView1, paramView2, paramInt, 0);
    AppMethodBeat.o(263413);
    return bool;
  }
  
  public void onStopNestedScroll(View paramView)
  {
    AppMethodBeat.i(263417);
    l(paramView, 0);
    AppMethodBeat.o(263417);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(263374);
    int i = paramMotionEvent.getActionMasked();
    boolean bool2;
    if (this.Hf == null)
    {
      bool2 = b(paramMotionEvent, 1);
      if (!bool2) {}
    }
    for (;;)
    {
      Behavior localBehavior = ((d)this.Hf.getLayoutParams()).Hq;
      boolean bool1;
      if (localBehavior != null) {
        bool1 = localBehavior.b(this, this.Hf, paramMotionEvent);
      }
      for (;;)
      {
        if (this.Hf == null)
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
            V(false);
          }
          AppMethodBeat.o(263374);
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
    AppMethodBeat.i(263431);
    Behavior localBehavior = ((d)paramView.getLayoutParams()).Hq;
    if ((localBehavior != null) && (localBehavior.a(this, paramView, paramRect, paramBoolean)))
    {
      AppMethodBeat.o(263431);
      return true;
    }
    paramBoolean = super.requestChildRectangleOnScreen(paramView, paramRect, paramBoolean);
    AppMethodBeat.o(263431);
    return paramBoolean;
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    AppMethodBeat.i(263375);
    super.requestDisallowInterceptTouchEvent(paramBoolean);
    if ((paramBoolean) && (!this.Hd))
    {
      V(false);
      this.Hd = true;
    }
    AppMethodBeat.o(263375);
  }
  
  public void setFitsSystemWindows(boolean paramBoolean)
  {
    AppMethodBeat.i(263392);
    super.setFitsSystemWindows(paramBoolean);
    ge();
    AppMethodBeat.o(263392);
  }
  
  public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener paramOnHierarchyChangeListener)
  {
    this.Hm = paramOnHierarchyChangeListener;
  }
  
  public void setStatusBarBackground(Drawable paramDrawable)
  {
    Drawable localDrawable = null;
    AppMethodBeat.i(263358);
    if (this.Hl != paramDrawable)
    {
      if (this.Hl != null) {
        this.Hl.setCallback(null);
      }
      if (paramDrawable != null) {
        localDrawable = paramDrawable.mutate();
      }
      this.Hl = localDrawable;
      if (this.Hl != null)
      {
        if (this.Hl.isStateful()) {
          this.Hl.setState(getDrawableState());
        }
        androidx.core.graphics.drawable.a.b(this.Hl, w.I(this));
        paramDrawable = this.Hl;
        if (getVisibility() != 0) {
          break label126;
        }
      }
    }
    label126:
    for (boolean bool = true;; bool = false)
    {
      paramDrawable.setVisible(bool, false);
      this.Hl.setCallback(this);
      w.G(this);
      AppMethodBeat.o(263358);
      return;
    }
  }
  
  public void setStatusBarBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(263365);
    setStatusBarBackground(new ColorDrawable(paramInt));
    AppMethodBeat.o(263365);
  }
  
  public void setStatusBarBackgroundResource(int paramInt)
  {
    AppMethodBeat.i(263364);
    if (paramInt != 0) {}
    for (Drawable localDrawable = androidx.core.content.a.m(getContext(), paramInt);; localDrawable = null)
    {
      setStatusBarBackground(localDrawable);
      AppMethodBeat.o(263364);
      return;
    }
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(263363);
    super.setVisibility(paramInt);
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      if ((this.Hl != null) && (this.Hl.isVisible() != bool)) {
        this.Hl.setVisible(bool, false);
      }
      AppMethodBeat.o(263363);
      return;
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(263361);
    if ((super.verifyDrawable(paramDrawable)) || (paramDrawable == this.Hl))
    {
      AppMethodBeat.o(263361);
      return true;
    }
    AppMethodBeat.o(263361);
    return false;
  }
  
  public final void w(View paramView)
  {
    AppMethodBeat.i(263407);
    List localList = this.GZ.w(paramView);
    if ((localList != null) && (!localList.isEmpty()))
    {
      int i = 0;
      while (i < localList.size())
      {
        View localView = (View)localList.get(i);
        Behavior localBehavior = ((d)localView.getLayoutParams()).Hq;
        if (localBehavior != null) {
          localBehavior.b(this, localView, paramView);
        }
        i += 1;
      }
    }
    AppMethodBeat.o(263407);
  }
  
  public final List<View> x(View paramView)
  {
    AppMethodBeat.i(263408);
    a locala = this.GZ;
    Object localObject1 = null;
    int j = locala.HH.size();
    int i = 0;
    Object localObject2;
    if (i < j)
    {
      ArrayList localArrayList = (ArrayList)locala.HH.aM(i);
      localObject2 = localObject1;
      if (localArrayList != null)
      {
        localObject2 = localObject1;
        if (localArrayList.contains(paramView))
        {
          if (localObject1 != null) {
            break label150;
          }
          localObject1 = new ArrayList();
        }
      }
    }
    label150:
    for (;;)
    {
      ((ArrayList)localObject1).add(locala.HH.aO(i));
      localObject2 = localObject1;
      i += 1;
      localObject1 = localObject2;
      break;
      this.Hb.clear();
      if (localObject1 != null) {
        this.Hb.addAll((Collection)localObject1);
      }
      paramView = this.Hb;
      AppMethodBeat.o(263408);
      return paramView;
    }
  }
  
  public final List<View> y(View paramView)
  {
    AppMethodBeat.i(263409);
    paramView = this.GZ.w(paramView);
    this.Hb.clear();
    if (paramView != null) {
      this.Hb.addAll(paramView);
    }
    paramView = this.Hb;
    AppMethodBeat.o(263409);
    return paramView;
  }
  
  public static abstract class Behavior<V extends View>
  {
    public Behavior() {}
    
    public Behavior(Context paramContext, AttributeSet paramAttributeSet) {}
    
    public static ae a(ae paramae)
    {
      return paramae;
    }
    
    @Deprecated
    public boolean C(int paramInt)
    {
      return false;
    }
    
    public Parcelable a(CoordinatorLayout paramCoordinatorLayout, V paramV)
    {
      return View.BaseSavedState.EMPTY_STATE;
    }
    
    @Deprecated
    public void a(V paramV, View paramView) {}
    
    @Deprecated
    public void a(V paramV, View paramView, int paramInt, int[] paramArrayOfInt) {}
    
    public void a(CoordinatorLayout.d paramd) {}
    
    public void a(CoordinatorLayout paramCoordinatorLayout, V paramV, Parcelable paramParcelable) {}
    
    public void a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, int paramInt)
    {
      if (paramInt == 0) {
        a(paramV, paramView);
      }
    }
    
    public void a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      if (paramInt5 == 0) {
        m(paramV, paramInt2);
      }
    }
    
    public void a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
    {
      if (paramInt3 == 0) {
        a(paramV, paramView, paramInt2, paramArrayOfInt);
      }
    }
    
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
        return C(paramInt1);
      }
      return false;
    }
    
    public void b(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView1, View paramView2, int paramInt1, int paramInt2) {}
    
    public boolean b(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
    {
      return false;
    }
    
    public boolean b(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView)
    {
      return false;
    }
    
    @Deprecated
    public void m(V paramV, int paramInt) {}
  }
  
  protected static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    SparseArray<Parcelable> HF;
    
    static
    {
      AppMethodBeat.i(263340);
      CREATOR = new Parcelable.ClassLoaderCreator() {};
      AppMethodBeat.o(263340);
    }
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      AppMethodBeat.i(263338);
      int j = paramParcel.readInt();
      int[] arrayOfInt = new int[j];
      paramParcel.readIntArray(arrayOfInt);
      paramParcel = paramParcel.readParcelableArray(paramClassLoader);
      this.HF = new SparseArray(j);
      int i = 0;
      while (i < j)
      {
        this.HF.append(arrayOfInt[i], paramParcel[i]);
        i += 1;
      }
      AppMethodBeat.o(263338);
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int j = 0;
      AppMethodBeat.i(263339);
      super.writeToParcel(paramParcel, paramInt);
      if (this.HF != null) {}
      int[] arrayOfInt;
      Parcelable[] arrayOfParcelable;
      for (int i = this.HF.size();; i = 0)
      {
        paramParcel.writeInt(i);
        arrayOfInt = new int[i];
        arrayOfParcelable = new Parcelable[i];
        while (j < i)
        {
          arrayOfInt[j] = this.HF.keyAt(j);
          arrayOfParcelable[j] = ((Parcelable)this.HF.valueAt(j));
          j += 1;
        }
      }
      paramParcel.writeIntArray(arrayOfInt);
      paramParcel.writeParcelableArray(arrayOfParcelable, paramInt);
      AppMethodBeat.o(263339);
    }
  }
  
  final class c
    implements ViewGroup.OnHierarchyChangeListener
  {
    c() {}
    
    public final void onChildViewAdded(View paramView1, View paramView2)
    {
      AppMethodBeat.i(263325);
      if (CoordinatorLayout.this.Hm != null) {
        CoordinatorLayout.this.Hm.onChildViewAdded(paramView1, paramView2);
      }
      AppMethodBeat.o(263325);
    }
    
    public final void onChildViewRemoved(View paramView1, View paramView2)
    {
      AppMethodBeat.i(263326);
      CoordinatorLayout.this.bl(2);
      if (CoordinatorLayout.this.Hm != null) {
        CoordinatorLayout.this.Hm.onChildViewRemoved(paramView1, paramView2);
      }
      AppMethodBeat.o(263326);
    }
  }
  
  public static final class d
    extends ViewGroup.MarginLayoutParams
  {
    private boolean HA;
    private boolean HB;
    boolean HC;
    final Rect HD;
    Object HE;
    public CoordinatorLayout.Behavior Hq;
    boolean Hr;
    public int Hs;
    public int Ht;
    public int Hu;
    public int Hv;
    int Hw;
    int Hx;
    View Hy;
    boolean Hz;
    public int anchorGravity;
    public int ek;
    View lJ;
    
    public d(int paramInt1, int paramInt2)
    {
      super(paramInt2);
      AppMethodBeat.i(263327);
      this.Hr = false;
      this.ek = 0;
      this.anchorGravity = 0;
      this.Hs = -1;
      this.Ht = -1;
      this.Hu = 0;
      this.Hv = 0;
      this.HD = new Rect();
      AppMethodBeat.o(263327);
    }
    
    d(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      AppMethodBeat.i(263328);
      this.Hr = false;
      this.ek = 0;
      this.anchorGravity = 0;
      this.Hs = -1;
      this.Ht = -1;
      this.Hu = 0;
      this.Hv = 0;
      this.HD = new Rect();
      TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, a.c.CoordinatorLayout_Layout);
      this.ek = localTypedArray.getInteger(a.c.CoordinatorLayout_Layout_android_layout_gravity, 0);
      this.Ht = localTypedArray.getResourceId(a.c.CoordinatorLayout_Layout_layout_anchor, -1);
      this.anchorGravity = localTypedArray.getInteger(a.c.CoordinatorLayout_Layout_layout_anchorGravity, 0);
      this.Hs = localTypedArray.getInteger(a.c.CoordinatorLayout_Layout_layout_keyline, -1);
      this.Hu = localTypedArray.getInt(a.c.CoordinatorLayout_Layout_layout_insetEdge, 0);
      this.Hv = localTypedArray.getInt(a.c.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
      this.Hr = localTypedArray.hasValue(a.c.CoordinatorLayout_Layout_layout_behavior);
      if (this.Hr) {
        this.Hq = CoordinatorLayout.a(paramContext, paramAttributeSet, localTypedArray.getString(a.c.CoordinatorLayout_Layout_layout_behavior));
      }
      localTypedArray.recycle();
      if (this.Hq != null) {
        this.Hq.a(this);
      }
      AppMethodBeat.o(263328);
    }
    
    public d(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
      AppMethodBeat.i(263332);
      this.Hr = false;
      this.ek = 0;
      this.anchorGravity = 0;
      this.Hs = -1;
      this.Ht = -1;
      this.Hu = 0;
      this.Hv = 0;
      this.HD = new Rect();
      AppMethodBeat.o(263332);
    }
    
    public d(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
      AppMethodBeat.i(263330);
      this.Hr = false;
      this.ek = 0;
      this.anchorGravity = 0;
      this.Hs = -1;
      this.Ht = -1;
      this.Hu = 0;
      this.Hv = 0;
      this.HD = new Rect();
      AppMethodBeat.o(263330);
    }
    
    public d(d paramd)
    {
      super();
      AppMethodBeat.i(263329);
      this.Hr = false;
      this.ek = 0;
      this.anchorGravity = 0;
      this.Hs = -1;
      this.Ht = -1;
      this.Hu = 0;
      this.Hv = 0;
      this.HD = new Rect();
      AppMethodBeat.o(263329);
    }
    
    public final void a(CoordinatorLayout.Behavior paramBehavior)
    {
      AppMethodBeat.i(263333);
      if (this.Hq != paramBehavior)
      {
        this.Hq = paramBehavior;
        this.HE = null;
        this.Hr = true;
        if (paramBehavior != null) {
          paramBehavior.a(this);
        }
      }
      AppMethodBeat.o(263333);
    }
    
    final boolean bm(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return false;
      case 0: 
        return this.HA;
      }
      return this.HB;
    }
    
    final void d(int paramInt, boolean paramBoolean)
    {
      switch (paramInt)
      {
      default: 
        return;
      case 0: 
        this.HA = paramBoolean;
        return;
      }
      this.HB = paramBoolean;
    }
    
    final boolean gg()
    {
      return (this.lJ == null) && (this.Ht != -1);
    }
  }
  
  final class e
    implements ViewTreeObserver.OnPreDrawListener
  {
    e() {}
    
    public final boolean onPreDraw()
    {
      AppMethodBeat.i(263334);
      CoordinatorLayout.this.bl(0);
      AppMethodBeat.o(263334);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.coordinatorlayout.widget.CoordinatorLayout
 * JD-Core Version:    0.7.0.1
 */