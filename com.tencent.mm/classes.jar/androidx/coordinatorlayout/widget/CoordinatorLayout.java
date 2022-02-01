package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region.Op;
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
import androidx.core.f.c;
import androidx.core.f.e.a;
import androidx.core.f.e.c;
import androidx.core.g.ah;
import androidx.core.g.e;
import androidx.core.g.p;
import androidx.core.g.r;
import androidx.core.g.s;
import androidx.core.g.z;
import androidx.customview.view.AbsSavedState;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
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
  static final String bmT;
  static final Class<?>[] bmU;
  static final ThreadLocal<Map<String, Constructor<Behavior>>> bmV;
  static final Comparator<View> bmW;
  private static final e.a<Rect> bmX;
  private final List<View> bmY;
  private final a<View> bmZ;
  private final List<View> bna;
  private final List<View> bnb;
  private final int[] bnc;
  private Paint bnd;
  private boolean bne;
  private int[] bnf;
  private View bng;
  private View bnh;
  private e bni;
  private boolean bnj;
  ah bnk;
  boolean bnl;
  private Drawable bnm;
  ViewGroup.OnHierarchyChangeListener bnn;
  private s bno;
  private final r bnp;
  private boolean mIsAttachedToWindow;
  
  static
  {
    AppMethodBeat.i(193359);
    Object localObject = CoordinatorLayout.class.getPackage();
    if (localObject != null)
    {
      localObject = ((Package)localObject).getName();
      bmT = (String)localObject;
      if (Build.VERSION.SDK_INT < 21) {
        break label92;
      }
    }
    label92:
    for (bmW = new CoordinatorLayout.f();; bmW = null)
    {
      bmU = new Class[] { Context.class, AttributeSet.class };
      bmV = new ThreadLocal();
      bmX = new e.c(12);
      AppMethodBeat.o(193359);
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
    AppMethodBeat.i(193185);
    this.bmY = new ArrayList();
    this.bmZ = new a();
    this.bna = new ArrayList();
    this.bnb = new ArrayList();
    this.bnc = new int[2];
    this.bnp = new r();
    if (paramInt == 0) {}
    for (paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.c.CoordinatorLayout, 0, a.b.Widget_Support_CoordinatorLayout);; paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.c.CoordinatorLayout, paramInt, 0))
    {
      paramInt = paramAttributeSet.getResourceId(a.c.CoordinatorLayout_keylines, 0);
      if (paramInt == 0) {
        break;
      }
      paramContext = paramContext.getResources();
      this.bnf = paramContext.getIntArray(paramInt);
      float f = paramContext.getDisplayMetrics().density;
      int j = this.bnf.length;
      paramInt = i;
      while (paramInt < j)
      {
        paramContext = this.bnf;
        paramContext[paramInt] = ((int)(paramContext[paramInt] * f));
        paramInt += 1;
      }
    }
    this.bnm = paramAttributeSet.getDrawable(a.c.CoordinatorLayout_statusBarBackground);
    paramAttributeSet.recycle();
    Do();
    super.setOnHierarchyChangeListener(new c());
    AppMethodBeat.o(193185);
  }
  
  private static Rect Dm()
  {
    AppMethodBeat.i(193166);
    Rect localRect2 = (Rect)bmX.acquire();
    Rect localRect1 = localRect2;
    if (localRect2 == null) {
      localRect1 = new Rect();
    }
    AppMethodBeat.o(193166);
    return localRect1;
  }
  
  private void Dn()
  {
    AppMethodBeat.i(193256);
    this.bmY.clear();
    Object localObject1 = this.bmZ;
    int j = ((a)localObject1).bnI.size();
    int i = 0;
    Object localObject2;
    while (i < j)
    {
      localObject2 = (ArrayList)((a)localObject1).bnI.bl(i);
      if (localObject2 != null)
      {
        ((ArrayList)localObject2).clear();
        ((a)localObject1).bnH.release(localObject2);
      }
      i += 1;
    }
    ((a)localObject1).bnI.clear();
    int m = getChildCount();
    j = 0;
    while (j < m)
    {
      View localView1 = getChildAt(j);
      d locald = E(localView1);
      if (locald.bnu == -1)
      {
        locald.bnz = null;
        locald.mF = null;
        this.bmZ.au(localView1);
        i = 0;
      }
      for (;;)
      {
        if (i >= m) {
          break label813;
        }
        if (i != j)
        {
          View localView2 = getChildAt(i);
          int k;
          if (localView2 != locald.bnz)
          {
            k = z.U(this);
            int n = e.ay(((d)localView2.getLayoutParams()).bnv, k);
            if ((n != 0) && ((e.ay(locald.bnw, k) & n) == n))
            {
              k = 1;
              label222:
              if ((k == 0) && ((locald.bnr == null) || (!locald.bnr.a(this, localView1, localView2)))) {
                break label723;
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
              if (!this.bmZ.bnI.containsKey(localView2)) {
                this.bmZ.au(localView2);
              }
              a locala = this.bmZ;
              if ((!locala.bnI.containsKey(localView2)) || (!locala.bnI.containsKey(localView1)))
              {
                localObject1 = new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
                AppMethodBeat.o(193256);
                throw ((Throwable)localObject1);
                if (locald.mF != null)
                {
                  if (locald.mF.getId() == locald.bnu) {
                    break label415;
                  }
                  i = 0;
                }
                for (;;)
                {
                  if (i != 0) {
                    break label504;
                  }
                  locald.mF = findViewById(locald.bnu);
                  if (locald.mF == null) {
                    break label640;
                  }
                  if (locald.mF != this) {
                    break label526;
                  }
                  if (!isInEditMode()) {
                    break label506;
                  }
                  locald.bnz = null;
                  locald.mF = null;
                  break;
                  label415:
                  localObject2 = locald.mF;
                  for (localObject1 = locald.mF.getParent();; localObject1 = ((ViewParent)localObject1).getParent())
                  {
                    if (localObject1 == this) {
                      break label494;
                    }
                    if ((localObject1 == null) || (localObject1 == localView1))
                    {
                      locald.bnz = null;
                      locald.mF = null;
                      i = 0;
                      break;
                    }
                    if ((localObject1 instanceof View)) {
                      localObject2 = (View)localObject1;
                    }
                  }
                  label494:
                  locald.bnz = ((View)localObject2);
                  i = 1;
                }
                label504:
                break;
                label506:
                localObject1 = new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                AppMethodBeat.o(193256);
                throw ((Throwable)localObject1);
                label526:
                localObject2 = locald.mF;
                for (localObject1 = locald.mF.getParent();; localObject1 = ((ViewParent)localObject1).getParent())
                {
                  if ((localObject1 == this) || (localObject1 == null)) {
                    break label630;
                  }
                  if (localObject1 == localView1)
                  {
                    if (isInEditMode())
                    {
                      locald.bnz = null;
                      locald.mF = null;
                      break;
                    }
                    localObject1 = new IllegalStateException("Anchor must not be a descendant of the anchored view");
                    AppMethodBeat.o(193256);
                    throw ((Throwable)localObject1);
                  }
                  if ((localObject1 instanceof View)) {
                    localObject2 = (View)localObject1;
                  }
                }
                label630:
                locald.bnz = ((View)localObject2);
                break;
                label640:
                if (isInEditMode())
                {
                  locald.bnz = null;
                  locald.mF = null;
                  break;
                }
                localObject1 = new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + getResources().getResourceName(locald.bnu) + " to anchor view " + localView1);
                AppMethodBeat.o(193256);
                throw ((Throwable)localObject1);
                k = 0;
                break label222;
                label723:
                k = 0;
                continue;
              }
              localObject2 = (ArrayList)locala.bnI.get(localView2);
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                localObject2 = (ArrayList)locala.bnH.acquire();
                localObject1 = localObject2;
                if (localObject2 == null) {
                  localObject1 = new ArrayList();
                }
                locala.bnI.put(localView2, localObject1);
              }
              ((ArrayList)localObject1).add(localView1);
            }
          }
        }
        i += 1;
      }
      label813:
      j += 1;
    }
    this.bmY.addAll(this.bmZ.Dt());
    Collections.reverse(this.bmY);
    AppMethodBeat.o(193256);
  }
  
  private void Do()
  {
    AppMethodBeat.i(193350);
    if (Build.VERSION.SDK_INT < 21)
    {
      AppMethodBeat.o(193350);
      return;
    }
    if (z.al(this))
    {
      if (this.bno == null) {
        this.bno = new s()
        {
          public final ah a(View paramAnonymousView, ah paramAnonymousah)
          {
            boolean bool2 = true;
            int i = 0;
            AppMethodBeat.i(193146);
            CoordinatorLayout localCoordinatorLayout = CoordinatorLayout.this;
            if (!c.equals(localCoordinatorLayout.bnk, paramAnonymousah))
            {
              localCoordinatorLayout.bnk = paramAnonymousah;
              if ((paramAnonymousah != null) && (paramAnonymousah.En() > 0))
              {
                bool1 = true;
                localCoordinatorLayout.bnl = bool1;
                if ((localCoordinatorLayout.bnl) || (localCoordinatorLayout.getBackground() != null)) {
                  break label160;
                }
              }
              label160:
              for (boolean bool1 = bool2;; bool1 = false)
              {
                localCoordinatorLayout.setWillNotDraw(bool1);
                if (paramAnonymousah.Er()) {
                  break label181;
                }
                int j = localCoordinatorLayout.getChildCount();
                paramAnonymousView = paramAnonymousah;
                while (i < j)
                {
                  paramAnonymousah = localCoordinatorLayout.getChildAt(i);
                  if ((!z.al(paramAnonymousah)) || (((CoordinatorLayout.d)paramAnonymousah.getLayoutParams()).bnr == null)) {
                    break label178;
                  }
                  paramAnonymousah = CoordinatorLayout.Behavior.a(paramAnonymousView);
                  paramAnonymousView = paramAnonymousah;
                  if (paramAnonymousah.Er()) {
                    break;
                  }
                  paramAnonymousView = paramAnonymousah;
                  i += 1;
                }
                bool1 = false;
                break;
              }
              label166:
              localCoordinatorLayout.requestLayout();
            }
            for (;;)
            {
              AppMethodBeat.o(193146);
              return paramAnonymousView;
              label178:
              break;
              label181:
              paramAnonymousView = paramAnonymousah;
              break label166;
              paramAnonymousView = paramAnonymousah;
            }
          }
        };
      }
      z.a(this, this.bno);
      setSystemUiVisibility(1280);
      AppMethodBeat.o(193350);
      return;
    }
    z.a(this, null);
    AppMethodBeat.o(193350);
  }
  
  private static d E(View paramView)
  {
    AppMethodBeat.i(193236);
    d locald = (d)paramView.getLayoutParams();
    if (!locald.bns)
    {
      if (!(paramView instanceof CoordinatorLayout.a)) {
        break label54;
      }
      locald.a(((CoordinatorLayout.a)paramView).getBehavior());
      locald.bns = true;
    }
    for (;;)
    {
      AppMethodBeat.o(193236);
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
        locald.a((Behavior)localView.Dr().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        locald.bns = true;
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          new StringBuilder("Default behavior class ").append(localView.Dr().getName()).append(" could not be instantiated. Did you forget a default constructor?");
        }
      }
    }
  }
  
  static Behavior a(Context paramContext, AttributeSet paramAttributeSet, String paramString)
  {
    AppMethodBeat.i(193227);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(193227);
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
        paramString = (Map)bmV.get();
        if (paramString != null) {
          break label243;
        }
        paramString = new HashMap();
        bmV.set(paramString);
        Constructor localConstructor2 = (Constructor)paramString.get(str);
        Constructor localConstructor1 = localConstructor2;
        if (localConstructor2 == null)
        {
          localConstructor1 = paramContext.getClassLoader().loadClass(str).getConstructor(bmU);
          localConstructor1.setAccessible(true);
          paramString.put(str, localConstructor1);
        }
        paramContext = (Behavior)localConstructor1.newInstance(new Object[] { paramContext, paramAttributeSet });
        AppMethodBeat.o(193227);
        return paramContext;
      }
      catch (Exception paramContext)
      {
        paramContext = new RuntimeException("Could not inflate Behavior subclass ".concat(String.valueOf(str)), paramContext);
        AppMethodBeat.o(193227);
        throw paramContext;
      }
      str = paramString;
      if (paramString.indexOf('.') < 0)
      {
        str = paramString;
        if (!TextUtils.isEmpty(bmT)) {
          str = bmT + '.' + paramString;
        }
      }
    }
  }
  
  private static void a(int paramInt1, Rect paramRect1, Rect paramRect2, d paramd, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(193276);
    int j = paramd.fl;
    int i = j;
    if (j == 0) {
      i = 17;
    }
    int k = e.ay(i, paramInt1);
    i = e.ay(dX(paramd.anchorGravity), paramInt1);
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
      AppMethodBeat.o(193276);
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
    AppMethodBeat.i(193289);
    d locald = (d)paramView.getLayoutParams();
    int i = paramView.getMeasuredWidth();
    int j = paramView.getMeasuredHeight();
    a(paramInt, paramRect1, paramRect2, locald, i, j);
    a(locald, paramRect2, i, j);
    AppMethodBeat.o(193289);
  }
  
  private void a(View paramView1, View paramView2, int paramInt)
  {
    AppMethodBeat.i(193299);
    Rect localRect1 = Dm();
    Rect localRect2 = Dm();
    try
    {
      b.a(this, paramView2, localRect1);
      a(paramView1, paramInt, localRect1, localRect2);
      paramView1.layout(localRect2.left, localRect2.top, localRect2.right, localRect2.bottom);
      return;
    }
    finally
    {
      h(localRect1);
      h(localRect2);
      AppMethodBeat.o(193299);
    }
  }
  
  private void a(View paramView, boolean paramBoolean, Rect paramRect)
  {
    AppMethodBeat.i(193263);
    if ((paramView.isLayoutRequested()) || (paramView.getVisibility() == 8))
    {
      paramRect.setEmpty();
      AppMethodBeat.o(193263);
      return;
    }
    if (paramBoolean)
    {
      b.a(this, paramView, paramRect);
      AppMethodBeat.o(193263);
      return;
    }
    paramRect.set(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
    AppMethodBeat.o(193263);
  }
  
  private void a(d paramd, Rect paramRect, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(193283);
    int j = getWidth();
    int i = getHeight();
    j = Math.max(getPaddingLeft() + paramd.leftMargin, Math.min(paramRect.left, j - getPaddingRight() - paramInt1 - paramd.rightMargin));
    i = Math.max(getPaddingTop() + paramd.topMargin, Math.min(paramRect.top, i - getPaddingBottom() - paramInt2 - paramd.bottomMargin));
    paramRect.set(j, i, j + paramInt1, i + paramInt2);
    AppMethodBeat.o(193283);
  }
  
  private void aB(boolean paramBoolean)
  {
    AppMethodBeat.i(193195);
    int j = getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = getChildAt(i);
      Behavior localBehavior = ((d)localView.getLayoutParams()).bnr;
      MotionEvent localMotionEvent;
      if (localBehavior != null)
      {
        long l = SystemClock.uptimeMillis();
        localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        if (!paramBoolean) {
          break label88;
        }
        localBehavior.a(this, localView, localMotionEvent);
      }
      for (;;)
      {
        localMotionEvent.recycle();
        i += 1;
        break;
        label88:
        localBehavior.b(this, localView, localMotionEvent);
      }
    }
    i = 0;
    while (i < j)
    {
      ((d)getChildAt(i).getLayoutParams()).bnA = false;
      i += 1;
    }
    this.bng = null;
    this.bne = false;
    AppMethodBeat.o(193195);
  }
  
  private void c(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(193310);
    d locald = (d)paramView.getLayoutParams();
    int i1 = e.ay(dY(locald.fl), paramInt2);
    int n = getWidth();
    int m = getHeight();
    int j = paramView.getMeasuredWidth();
    int k = paramView.getMeasuredHeight();
    int i = paramInt1;
    if (paramInt2 == 1) {
      i = n - paramInt1;
    }
    paramInt1 = dW(i) - j;
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
      AppMethodBeat.o(193310);
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
  
  private boolean c(MotionEvent paramMotionEvent, int paramInt)
  {
    AppMethodBeat.i(193206);
    int i2 = 0;
    int m = 0;
    int n = paramMotionEvent.getActionMasked();
    List localList = this.bna;
    localList.clear();
    int i3 = isChildrenDrawingOrderEnabled();
    int i1 = getChildCount();
    int i = i1 - 1;
    if (i >= 0)
    {
      if (i3 != 0) {}
      for (k = getChildDrawingOrder(i1, i);; k = i)
      {
        localList.add(getChildAt(k));
        i -= 1;
        break;
      }
    }
    if (bmW != null) {
      Collections.sort(localList, bmW);
    }
    i1 = localList.size();
    int k = 0;
    MotionEvent localMotionEvent = null;
    i = m;
    View localView;
    d locald;
    Behavior localBehavior;
    if (k < i1)
    {
      localView = (View)localList.get(k);
      locald = (d)localView.getLayoutParams();
      localBehavior = locald.bnr;
      if (((i2 != 0) || (i != 0)) && (n != 0))
      {
        if (localBehavior == null) {
          break label498;
        }
        if (localMotionEvent != null) {
          break label495;
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
    label470:
    label479:
    label495:
    label498:
    for (;;)
    {
      k += 1;
      break;
      localBehavior.a(this, localView, localMotionEvent);
      continue;
      localBehavior.b(this, localView, localMotionEvent);
      continue;
      i3 = i2;
      if (i2 == 0)
      {
        i3 = i2;
        if (localBehavior == null) {}
      }
      switch (paramInt)
      {
      default: 
        i3 = i2;
        if (i2 != 0)
        {
          this.bng = localView;
          i3 = i2;
        }
        i2 = i3;
        if (locald.bnr == null) {
          locald.bnA = false;
        }
        boolean bool = locald.bnA;
        if (locald.bnA)
        {
          i3 = 1;
          if ((i3 == 0) || (bool)) {
            break label470;
          }
        }
        break;
      }
      int j;
      for (i = 1;; j = 0)
      {
        if (i3 != 0)
        {
          i3 = i2;
          if (i == 0) {
            break label479;
          }
        }
        break;
        i2 = localBehavior.a(this, localView, paramMotionEvent);
        break label308;
        i2 = localBehavior.b(this, localView, paramMotionEvent);
        break label308;
        i3 = locald.bnA;
        if (locald.bnr != null) {
          if (Behavior.Dq() > 0.0F) {
            i = 1;
          }
        }
        for (;;)
        {
          i3 = i | i3;
          locald.bnA = i3;
          break;
          j = 0;
          continue;
          j = 0;
        }
      }
      i3 = i2;
      localList.clear();
      AppMethodBeat.o(193206);
      return i3;
      break label205;
    }
  }
  
  private int dW(int paramInt)
  {
    AppMethodBeat.i(193216);
    if (this.bnf == null)
    {
      new StringBuilder("No keylines defined for ").append(this).append(" - attempted index lookup ").append(paramInt);
      AppMethodBeat.o(193216);
      return 0;
    }
    if ((paramInt < 0) || (paramInt >= this.bnf.length))
    {
      new StringBuilder("Keyline index ").append(paramInt).append(" out of range for ").append(this);
      AppMethodBeat.o(193216);
      return 0;
    }
    paramInt = this.bnf[paramInt];
    AppMethodBeat.o(193216);
    return paramInt;
  }
  
  private static int dX(int paramInt)
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
  
  private static int dY(int paramInt)
  {
    int i = paramInt;
    if (paramInt == 0) {
      i = 8388661;
    }
    return i;
  }
  
  private static void h(Rect paramRect)
  {
    AppMethodBeat.i(193168);
    paramRect.setEmpty();
    bmX.release(paramRect);
    AppMethodBeat.o(193168);
  }
  
  private void i(View paramView, int paramInt)
  {
    AppMethodBeat.i(193318);
    d locald = (d)paramView.getLayoutParams();
    Rect localRect1 = Dm();
    localRect1.set(getPaddingLeft() + locald.leftMargin, getPaddingTop() + locald.topMargin, getWidth() - getPaddingRight() - locald.rightMargin, getHeight() - getPaddingBottom() - locald.bottomMargin);
    if ((this.bnk != null) && (z.al(this)) && (!z.al(paramView)))
    {
      localRect1.left += this.bnk.Em();
      localRect1.top += this.bnk.En();
      localRect1.right -= this.bnk.Eo();
      localRect1.bottom -= this.bnk.Ep();
    }
    Rect localRect2 = Dm();
    e.a(dX(locald.fl), paramView.getMeasuredWidth(), paramView.getMeasuredHeight(), localRect1, localRect2, paramInt);
    paramView.layout(localRect2.left, localRect2.top, localRect2.right, localRect2.bottom);
    h(localRect1);
    h(localRect2);
    AppMethodBeat.o(193318);
  }
  
  private static void j(View paramView, int paramInt)
  {
    AppMethodBeat.i(193338);
    d locald = (d)paramView.getLayoutParams();
    if (locald.bnx != paramInt)
    {
      z.u(paramView, paramInt - locald.bnx);
      locald.bnx = paramInt;
    }
    AppMethodBeat.o(193338);
  }
  
  private static void k(View paramView, int paramInt)
  {
    AppMethodBeat.i(193344);
    d locald = (d)paramView.getLayoutParams();
    if (locald.bny != paramInt)
    {
      z.s(paramView, paramInt - locald.bny);
      locald.bny = paramInt;
    }
    AppMethodBeat.o(193344);
  }
  
  public final void F(View paramView)
  {
    AppMethodBeat.i(193561);
    List localList = this.bmZ.av(paramView);
    if ((localList != null) && (!localList.isEmpty()))
    {
      int i = 0;
      while (i < localList.size())
      {
        View localView = (View)localList.get(i);
        Behavior localBehavior = ((d)localView.getLayoutParams()).bnr;
        if (localBehavior != null) {
          localBehavior.b(this, localView, paramView);
        }
        i += 1;
      }
    }
    AppMethodBeat.o(193561);
  }
  
  public final List<View> G(View paramView)
  {
    AppMethodBeat.i(193569);
    a locala = this.bmZ;
    Object localObject1 = null;
    int j = locala.bnI.size();
    int i = 0;
    Object localObject2;
    if (i < j)
    {
      ArrayList localArrayList = (ArrayList)locala.bnI.bl(i);
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
      ((ArrayList)localObject1).add(locala.bnI.bn(i));
      localObject2 = localObject1;
      i += 1;
      localObject1 = localObject2;
      break;
      this.bnb.clear();
      if (localObject1 != null) {
        this.bnb.addAll((Collection)localObject1);
      }
      paramView = this.bnb;
      AppMethodBeat.o(193569);
      return paramView;
    }
  }
  
  public final List<View> H(View paramView)
  {
    AppMethodBeat.i(193578);
    paramView = this.bmZ.av(paramView);
    this.bnb.clear();
    if (paramView != null) {
      this.bnb.addAll(paramView);
    }
    paramView = this.bnb;
    AppMethodBeat.o(193578);
    return paramView;
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(193665);
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
      if (!((d)localObject).ea(paramInt5)) {
        break label121;
      }
      localObject = ((d)localObject).bnr;
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
        dZ(1);
      }
      AppMethodBeat.o(193665);
      return;
    }
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    AppMethodBeat.i(193680);
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
      if (!((d)localObject).ea(paramInt3)) {
        break label251;
      }
      localObject = ((d)localObject).bnr;
      if (localObject == null) {
        break label251;
      }
      int[] arrayOfInt = this.bnc;
      this.bnc[1] = 0;
      arrayOfInt[0] = 0;
      ((Behavior)localObject).a(this, localView, paramView, paramInt1, paramInt2, this.bnc, paramInt3);
      if (paramInt1 > 0)
      {
        j = Math.max(j, this.bnc[0]);
        if (paramInt2 <= 0) {
          break label206;
        }
        k = Math.max(i, this.bnc[1]);
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
      j = Math.min(j, this.bnc[0]);
      break label133;
      label206:
      k = Math.min(i, this.bnc[1]);
      break label150;
      paramArrayOfInt[0] = j;
      paramArrayOfInt[1] = i;
      if (k != 0) {
        dZ(1);
      }
      AppMethodBeat.o(193680);
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
    AppMethodBeat.i(193618);
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
        Behavior localBehavior = locald.bnr;
        if (localBehavior != null)
        {
          boolean bool2 = localBehavior.a(this, localView, paramView1, paramView2, paramInt1, paramInt2);
          bool1 |= bool2;
          locald.p(paramInt2, bool2);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        locald.p(paramInt2, false);
      }
    }
    AppMethodBeat.o(193618);
    return bool1;
  }
  
  public final void b(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(193636);
    this.bnp.aA(paramInt1, paramInt2);
    this.bnh = paramView2;
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      Object localObject = (d)localView.getLayoutParams();
      if (((d)localObject).ea(paramInt2))
      {
        localObject = ((d)localObject).bnr;
        if (localObject != null) {
          ((Behavior)localObject).b(this, localView, paramView1, paramView2, paramInt1, paramInt2);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(193636);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(193603);
    if (((paramLayoutParams instanceof d)) && (super.checkLayoutParams(paramLayoutParams)))
    {
      AppMethodBeat.o(193603);
      return true;
    }
    AppMethodBeat.o(193603);
    return false;
  }
  
  public final boolean d(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(193594);
    Rect localRect = Dm();
    b.a(this, paramView, localRect);
    try
    {
      boolean bool = localRect.contains(paramInt1, paramInt2);
      return bool;
    }
    finally
    {
      h(localRect);
      AppMethodBeat.o(193594);
    }
  }
  
  final void dZ(int paramInt)
  {
    AppMethodBeat.i(193549);
    int m = z.U(this);
    int n = this.bmY.size();
    Object localObject1 = Dm();
    Rect localRect1 = Dm();
    Rect localRect2 = Dm();
    int j = 0;
    View localView;
    Object localObject2;
    int i;
    Object localObject3;
    Object localObject4;
    if (j < n)
    {
      localView = (View)this.bmY.get(j);
      localObject2 = (d)localView.getLayoutParams();
      if ((paramInt != 0) || (localView.getVisibility() != 8))
      {
        i = 0;
        int i1;
        int i2;
        int k;
        if (i < j)
        {
          localObject3 = (View)this.bmY.get(i);
          Rect localRect4;
          if (((d)localObject2).bnz == localObject3)
          {
            localObject3 = (d)localView.getLayoutParams();
            if (((d)localObject3).mF != null)
            {
              localObject4 = Dm();
              localRect3 = Dm();
              localRect4 = Dm();
              b.a(this, ((d)localObject3).mF, (Rect)localObject4);
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
              z.u(localView, i1);
            }
            if (i2 != 0) {
              z.s(localView, i2);
            }
            if (k != 0)
            {
              Behavior localBehavior = ((d)localObject3).bnr;
              if (localBehavior != null) {
                localBehavior.b(this, localView, ((d)localObject3).mF);
              }
            }
            h((Rect)localObject4);
            h(localRect3);
            h(localRect4);
            i += 1;
            break;
          }
        }
        a(localView, true, localRect1);
        if ((((d)localObject2).bnv != 0) && (!localRect1.isEmpty()))
        {
          i = e.ay(((d)localObject2).bnv, m);
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
          if ((((d)localObject2).bnw != 0) && (localView.getVisibility() == 0) && (z.au(localView)) && (localView.getWidth() > 0) && (localView.getHeight() > 0)) {
            break label714;
          }
          label488:
          if (paramInt != 2)
          {
            localRect2.set(((d)localView.getLayoutParams()).bnE);
            if (localRect2.equals(localRect1)) {
              break label1221;
            }
            ((d)localView.getLayoutParams()).bnE.set(localRect1);
          }
          i = j + 1;
          for (;;)
          {
            if (i >= n) {
              break label1221;
            }
            localObject2 = (View)this.bmY.get(i);
            localObject3 = (d)((View)localObject2).getLayoutParams();
            localObject4 = ((d)localObject3).bnr;
            if ((localObject4 != null) && (((Behavior)localObject4).a(this, (View)localObject2, localView)))
            {
              if ((paramInt != 0) || (!((d)localObject3).bnD)) {
                break;
              }
              ((d)localObject3).bnD = false;
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
        localObject3 = ((d)localObject2).bnr;
        localObject4 = Dm();
        Rect localRect3 = Dm();
        localRect3.set(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
        if ((localObject3 != null) && (((Behavior)localObject3).a(this, localView, (Rect)localObject4)))
        {
          if (!localRect3.contains((Rect)localObject4))
          {
            localObject1 = new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + ((Rect)localObject4).toShortString() + " | Bounds:" + localRect3.toShortString());
            AppMethodBeat.o(193549);
            throw ((Throwable)localObject1);
          }
        }
        else {
          ((Rect)localObject4).set(localRect3);
        }
        h(localRect3);
        if (!((Rect)localObject4).isEmpty())
        {
          i1 = e.ay(((d)localObject2).bnw, m);
          k = 0;
          i = k;
          if ((i1 & 0x30) == 48)
          {
            i2 = ((Rect)localObject4).top - ((d)localObject2).topMargin - ((d)localObject2).bny;
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
            i2 = getHeight() - ((Rect)localObject4).bottom - ((d)localObject2).bottomMargin + ((d)localObject2).bny;
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
            i2 = ((Rect)localObject4).left - ((d)localObject2).leftMargin - ((d)localObject2).bnx;
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
          k = ((d)localObject2).bnx + (k - i1 - i2);
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
      h((Rect)localObject4);
      break label488;
      switch (paramInt)
      {
      }
      for (boolean bool = ((Behavior)localObject4).b(this, (View)localObject2, localView); paramInt == 1; bool = true)
      {
        ((d)localObject3).bnD = bool;
        break;
      }
      j += 1;
      break;
      h((Rect)localObject1);
      h(localRect1);
      h(localRect2);
      AppMethodBeat.o(193549);
      return;
    }
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    AppMethodBeat.i(193531);
    Paint localPaint;
    int j;
    int i;
    if (((d)paramView.getLayoutParams()).bnr != null)
    {
      float f = Behavior.Dq();
      if (f > 0.0F)
      {
        if (this.bnd == null) {
          this.bnd = new Paint();
        }
        this.bnd.setColor(Behavior.Dp());
        localPaint = this.bnd;
        j = Math.round(f * 255.0F);
        if (j >= 0) {
          break label194;
        }
        i = 0;
      }
    }
    for (;;)
    {
      localPaint.setAlpha(i);
      i = paramCanvas.save();
      if (paramView.isOpaque()) {
        paramCanvas.clipRect(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom(), Region.Op.DIFFERENCE);
      }
      paramCanvas.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), this.bnd);
      paramCanvas.restoreToCount(i);
      boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
      AppMethodBeat.o(193531);
      return bool;
      label194:
      i = j;
      if (j > 255) {
        i = 255;
      }
    }
  }
  
  protected void drawableStateChanged()
  {
    AppMethodBeat.i(193403);
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    boolean bool2 = false;
    Drawable localDrawable = this.bnm;
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
    AppMethodBeat.o(193403);
  }
  
  public final void e(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(193478);
    measureChildWithMargins(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(193478);
  }
  
  final List<View> getDependencySortedChildren()
  {
    AppMethodBeat.i(193585);
    Dn();
    List localList = Collections.unmodifiableList(this.bmY);
    AppMethodBeat.o(193585);
    return localList;
  }
  
  public final ah getLastWindowInsets()
  {
    return this.bnk;
  }
  
  public int getNestedScrollAxes()
  {
    AppMethodBeat.i(193700);
    int i = this.bnp.getNestedScrollAxes();
    AppMethodBeat.o(193700);
    return i;
  }
  
  public Drawable getStatusBarBackground()
  {
    return this.bnm;
  }
  
  protected int getSuggestedMinimumHeight()
  {
    AppMethodBeat.i(193472);
    int i = Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    AppMethodBeat.o(193472);
    return i;
  }
  
  protected int getSuggestedMinimumWidth()
  {
    AppMethodBeat.i(193467);
    int i = Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    AppMethodBeat.o(193467);
    return i;
  }
  
  public final void h(View paramView, int paramInt)
  {
    AppMethodBeat.i(193497);
    d locald = (d)paramView.getLayoutParams();
    if (locald.Ds())
    {
      paramView = new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
      AppMethodBeat.o(193497);
      throw paramView;
    }
    if (locald.mF != null)
    {
      a(paramView, locald.mF, paramInt);
      AppMethodBeat.o(193497);
      return;
    }
    if (locald.bnt >= 0)
    {
      c(paramView, locald.bnt, paramInt);
      AppMethodBeat.o(193497);
      return;
    }
    i(paramView, paramInt);
    AppMethodBeat.o(193497);
  }
  
  public final void l(View paramView, int paramInt)
  {
    AppMethodBeat.i(193647);
    this.bnp.eq(paramInt);
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      d locald = (d)localView.getLayoutParams();
      if (locald.ea(paramInt))
      {
        Behavior localBehavior = locald.bnr;
        if (localBehavior != null) {
          localBehavior.a(this, localView, paramView, paramInt);
        }
        locald.p(paramInt, false);
        locald.bnD = false;
      }
      i += 1;
    }
    this.bnh = null;
    AppMethodBeat.o(193647);
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(193370);
    super.onAttachedToWindow();
    aB(false);
    if (this.bnj)
    {
      if (this.bni == null) {
        this.bni = new e();
      }
      getViewTreeObserver().addOnPreDrawListener(this.bni);
    }
    if ((this.bnk == null) && (z.al(this))) {
      z.ak(this);
    }
    this.mIsAttachedToWindow = true;
    AppMethodBeat.o(193370);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(193377);
    super.onDetachedFromWindow();
    aB(false);
    if ((this.bnj) && (this.bni != null)) {
      getViewTreeObserver().removeOnPreDrawListener(this.bni);
    }
    if (this.bnh != null) {
      onStopNestedScroll(this.bnh);
    }
    this.mIsAttachedToWindow = false;
    AppMethodBeat.o(193377);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(193515);
    super.onDraw(paramCanvas);
    if ((this.bnl) && (this.bnm != null)) {
      if (this.bnk == null) {
        break label73;
      }
    }
    label73:
    for (int i = this.bnk.En();; i = 0)
    {
      if (i > 0)
      {
        this.bnm.setBounds(0, 0, getWidth(), i);
        this.bnm.draw(paramCanvas);
      }
      AppMethodBeat.o(193515);
      return;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(193443);
    int i = paramMotionEvent.getActionMasked();
    if (i == 0) {
      aB(true);
    }
    boolean bool = c(paramMotionEvent, 0);
    if ((i == 1) || (i == 3)) {
      aB(true);
    }
    AppMethodBeat.o(193443);
    return bool;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(193505);
    paramInt2 = z.U(this);
    paramInt3 = this.bmY.size();
    paramInt1 = 0;
    while (paramInt1 < paramInt3)
    {
      View localView = (View)this.bmY.get(paramInt1);
      if (localView.getVisibility() != 8)
      {
        Behavior localBehavior = ((d)localView.getLayoutParams()).bnr;
        if ((localBehavior == null) || (!localBehavior.a(this, localView, paramInt2))) {
          h(localView, paramInt2);
        }
      }
      paramInt1 += 1;
    }
    AppMethodBeat.o(193505);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(193492);
    Dn();
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
      localObject1 = this.bmZ;
      m = ((a)localObject1).bnI.size();
      j = 0;
      if (j < m)
      {
        localObject2 = (ArrayList)((a)localObject1).bnI.bl(j);
        if ((localObject2 != null) && (((ArrayList)localObject2).contains(localView)))
        {
          j = 1;
          label90:
          if (j == 0) {
            break label624;
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
      if (i17 != this.bnj)
      {
        if (i17 != 0)
        {
          if (this.mIsAttachedToWindow)
          {
            if (this.bni == null) {
              this.bni = new e();
            }
            getViewTreeObserver().addOnPreDrawListener(this.bni);
          }
          this.bnj = true;
        }
      }
      else
      {
        i5 = getPaddingLeft();
        int i6 = getPaddingTop();
        int i7 = getPaddingRight();
        int i8 = getPaddingBottom();
        int i9 = z.U(this);
        if (i9 != 1) {
          break label664;
        }
        n = 1;
        int i10 = View.MeasureSpec.getMode(paramInt1);
        int i11 = View.MeasureSpec.getSize(paramInt1);
        int i12 = View.MeasureSpec.getMode(paramInt2);
        int i13 = View.MeasureSpec.getSize(paramInt2);
        k = getSuggestedMinimumWidth();
        j = getSuggestedMinimumHeight();
        i = 0;
        if ((this.bnk == null) || (!z.al(this))) {
          break label670;
        }
        i1 = 1;
        int i14 = this.bmY.size();
        i2 = 0;
        if (i2 >= i14) {
          break label720;
        }
        localView = (View)this.bmY.get(i2);
        if (localView.getVisibility() == 8) {
          break label761;
        }
        localObject1 = (d)localView.getLayoutParams();
        i3 = 0;
        m = i3;
        if (((d)localObject1).bnt >= 0)
        {
          m = i3;
          if (i10 != 0)
          {
            i4 = dW(((d)localObject1).bnt);
            i15 = e.ay(dY(((d)localObject1).fl), i9) & 0x7;
            if (((i15 != 3) || (n != 0)) && ((i15 != 5) || (n == 0))) {
              break label676;
            }
            m = Math.max(0, i11 - i7 - i4);
          }
        }
        label394:
        if ((i1 == 0) || (z.al(localView))) {
          break label752;
        }
        i3 = this.bnk.Em();
        int i16 = this.bnk.Eo();
        i4 = this.bnk.En();
        i15 = this.bnk.Ep();
        i3 = View.MeasureSpec.makeMeasureSpec(i11 - (i3 + i16), i10);
        i4 = View.MeasureSpec.makeMeasureSpec(i13 - (i4 + i15), i12);
        label473:
        localObject2 = ((d)localObject1).bnr;
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
        label624:
        i += 1;
        break;
        if ((this.mIsAttachedToWindow) && (this.bni != null)) {
          getViewTreeObserver().removeOnPreDrawListener(this.bni);
        }
        this.bnj = false;
        break label154;
        label664:
        n = 0;
        break label193;
        label670:
        i1 = 0;
        break label248;
        label676:
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
        label720:
        setMeasuredDimension(View.resolveSizeAndState(k, paramInt1, 0xFF000000 & i), View.resolveSizeAndState(j, paramInt2, i << 16));
        AppMethodBeat.o(193492);
        return;
        label752:
        i4 = paramInt2;
        i3 = paramInt1;
        break label473;
        label761:
        m = k;
        k = i;
      }
    }
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(193686);
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
      if (!((d)localObject).ea(0)) {
        break label120;
      }
      localObject = ((d)localObject).bnr;
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
        dZ(1);
      }
      AppMethodBeat.o(193686);
      return bool;
    }
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(193694);
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
      if (!((d)localObject).ea(0)) {
        break label108;
      }
      localObject = ((d)localObject).bnr;
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
      AppMethodBeat.o(193694);
      return bool;
    }
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(193671);
    a(paramView, paramInt1, paramInt2, paramArrayOfInt, 0);
    AppMethodBeat.o(193671);
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(193657);
    a(paramView, paramInt1, paramInt2, paramInt3, paramInt4, 0);
    AppMethodBeat.o(193657);
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    AppMethodBeat.i(193629);
    b(paramView1, paramView2, paramInt, 0);
    AppMethodBeat.o(193629);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(193712);
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      AppMethodBeat.o(193712);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.bxs);
    paramParcelable = paramParcelable.bnG;
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      int k = localView.getId();
      Behavior localBehavior = E(localView).bnr;
      if ((k != -1) && (localBehavior != null))
      {
        Parcelable localParcelable = (Parcelable)paramParcelable.get(k);
        if (localParcelable != null) {
          localBehavior.a(this, localView, localParcelable);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(193712);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(193718);
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    SparseArray localSparseArray = new SparseArray();
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = getChildAt(i);
      int k = ((View)localObject).getId();
      Behavior localBehavior = ((d)((View)localObject).getLayoutParams()).bnr;
      if ((k != -1) && (localBehavior != null))
      {
        localObject = localBehavior.a(this, (View)localObject);
        if (localObject != null) {
          localSparseArray.append(k, localObject);
        }
      }
      i += 1;
    }
    localSavedState.bnG = localSparseArray;
    AppMethodBeat.o(193718);
    return localSavedState;
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    AppMethodBeat.i(193608);
    boolean bool = a(paramView1, paramView2, paramInt, 0);
    AppMethodBeat.o(193608);
    return bool;
  }
  
  public void onStopNestedScroll(View paramView)
  {
    AppMethodBeat.i(193641);
    l(paramView, 0);
    AppMethodBeat.o(193641);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(193450);
    int i = paramMotionEvent.getActionMasked();
    boolean bool2;
    if (this.bng == null)
    {
      bool2 = c(paramMotionEvent, 1);
      if (!bool2) {}
    }
    for (;;)
    {
      Behavior localBehavior = ((d)this.bng.getLayoutParams()).bnr;
      boolean bool1;
      if (localBehavior != null) {
        bool1 = localBehavior.b(this, this.bng, paramMotionEvent);
      }
      for (;;)
      {
        if (this.bng == null)
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
            aB(false);
          }
          AppMethodBeat.o(193450);
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
    AppMethodBeat.i(193726);
    Behavior localBehavior = ((d)paramView.getLayoutParams()).bnr;
    if ((localBehavior != null) && (localBehavior.a(this, paramView, paramRect, paramBoolean)))
    {
      AppMethodBeat.o(193726);
      return true;
    }
    paramBoolean = super.requestChildRectangleOnScreen(paramView, paramRect, paramBoolean);
    AppMethodBeat.o(193726);
    return paramBoolean;
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    AppMethodBeat.i(193461);
    super.requestDisallowInterceptTouchEvent(paramBoolean);
    if ((paramBoolean) && (!this.bne))
    {
      aB(false);
      this.bne = true;
    }
    AppMethodBeat.o(193461);
  }
  
  public void setFitsSystemWindows(boolean paramBoolean)
  {
    AppMethodBeat.i(193520);
    super.setFitsSystemWindows(paramBoolean);
    Do();
    AppMethodBeat.o(193520);
  }
  
  public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener paramOnHierarchyChangeListener)
  {
    this.bnn = paramOnHierarchyChangeListener;
  }
  
  public void setStatusBarBackground(Drawable paramDrawable)
  {
    Drawable localDrawable = null;
    AppMethodBeat.i(193388);
    if (this.bnm != paramDrawable)
    {
      if (this.bnm != null) {
        this.bnm.setCallback(null);
      }
      if (paramDrawable != null) {
        localDrawable = paramDrawable.mutate();
      }
      this.bnm = localDrawable;
      if (this.bnm != null)
      {
        if (this.bnm.isStateful()) {
          this.bnm.setState(getDrawableState());
        }
        androidx.core.graphics.drawable.a.b(this.bnm, z.U(this));
        paramDrawable = this.bnm;
        if (getVisibility() != 0) {
          break label126;
        }
      }
    }
    label126:
    for (boolean bool = true;; bool = false)
    {
      paramDrawable.setVisible(bool, false);
      this.bnm.setCallback(this);
      z.Q(this);
      AppMethodBeat.o(193388);
      return;
    }
  }
  
  public void setStatusBarBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(193432);
    setStatusBarBackground(new ColorDrawable(paramInt));
    AppMethodBeat.o(193432);
  }
  
  public void setStatusBarBackgroundResource(int paramInt)
  {
    AppMethodBeat.i(193422);
    if (paramInt != 0) {}
    for (Drawable localDrawable = androidx.core.content.a.m(getContext(), paramInt);; localDrawable = null)
    {
      setStatusBarBackground(localDrawable);
      AppMethodBeat.o(193422);
      return;
    }
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(193417);
    super.setVisibility(paramInt);
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      if ((this.bnm != null) && (this.bnm.isVisible() != bool)) {
        this.bnm.setVisible(bool, false);
      }
      AppMethodBeat.o(193417);
      return;
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(193411);
    if ((super.verifyDrawable(paramDrawable)) || (paramDrawable == this.bnm))
    {
      AppMethodBeat.o(193411);
      return true;
    }
    AppMethodBeat.o(193411);
    return false;
  }
  
  public static abstract class Behavior<V extends View>
  {
    public Behavior() {}
    
    public Behavior(Context paramContext, AttributeSet paramAttributeSet) {}
    
    public static int Dp()
    {
      return -16777216;
    }
    
    public static float Dq()
    {
      return 0.0F;
    }
    
    public static ah a(ah paramah)
    {
      return paramah;
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
    SparseArray<Parcelable> bnG;
    
    static
    {
      AppMethodBeat.i(193126);
      CREATOR = new Parcelable.ClassLoaderCreator() {};
      AppMethodBeat.o(193126);
    }
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      AppMethodBeat.i(193114);
      int j = paramParcel.readInt();
      int[] arrayOfInt = new int[j];
      paramParcel.readIntArray(arrayOfInt);
      paramParcel = paramParcel.readParcelableArray(paramClassLoader);
      this.bnG = new SparseArray(j);
      int i = 0;
      while (i < j)
      {
        this.bnG.append(arrayOfInt[i], paramParcel[i]);
        i += 1;
      }
      AppMethodBeat.o(193114);
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int j = 0;
      AppMethodBeat.i(193137);
      super.writeToParcel(paramParcel, paramInt);
      if (this.bnG != null) {}
      int[] arrayOfInt;
      Parcelable[] arrayOfParcelable;
      for (int i = this.bnG.size();; i = 0)
      {
        paramParcel.writeInt(i);
        arrayOfInt = new int[i];
        arrayOfParcelable = new Parcelable[i];
        while (j < i)
        {
          arrayOfInt[j] = this.bnG.keyAt(j);
          arrayOfParcelable[j] = ((Parcelable)this.bnG.valueAt(j));
          j += 1;
        }
      }
      paramParcel.writeIntArray(arrayOfInt);
      paramParcel.writeParcelableArray(arrayOfParcelable, paramInt);
      AppMethodBeat.o(193137);
    }
  }
  
  @Deprecated
  @Retention(RetentionPolicy.RUNTIME)
  public static @interface b
  {
    Class<? extends CoordinatorLayout.Behavior> Dr();
  }
  
  final class c
    implements ViewGroup.OnHierarchyChangeListener
  {
    c() {}
    
    public final void onChildViewAdded(View paramView1, View paramView2)
    {
      AppMethodBeat.i(193124);
      if (CoordinatorLayout.this.bnn != null) {
        CoordinatorLayout.this.bnn.onChildViewAdded(paramView1, paramView2);
      }
      AppMethodBeat.o(193124);
    }
    
    public final void onChildViewRemoved(View paramView1, View paramView2)
    {
      AppMethodBeat.i(193133);
      CoordinatorLayout.this.dZ(2);
      if (CoordinatorLayout.this.bnn != null) {
        CoordinatorLayout.this.bnn.onChildViewRemoved(paramView1, paramView2);
      }
      AppMethodBeat.o(193133);
    }
  }
  
  public static final class d
    extends ViewGroup.MarginLayoutParams
  {
    public int anchorGravity;
    boolean bnA;
    private boolean bnB;
    private boolean bnC;
    boolean bnD;
    final Rect bnE;
    Object bnF;
    public CoordinatorLayout.Behavior bnr;
    boolean bns;
    public int bnt;
    public int bnu;
    public int bnv;
    public int bnw;
    int bnx;
    int bny;
    View bnz;
    public int fl;
    View mF;
    
    public d(int paramInt1, int paramInt2)
    {
      super(paramInt2);
      AppMethodBeat.i(193117);
      this.bns = false;
      this.fl = 0;
      this.anchorGravity = 0;
      this.bnt = -1;
      this.bnu = -1;
      this.bnv = 0;
      this.bnw = 0;
      this.bnE = new Rect();
      AppMethodBeat.o(193117);
    }
    
    d(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      AppMethodBeat.i(193128);
      this.bns = false;
      this.fl = 0;
      this.anchorGravity = 0;
      this.bnt = -1;
      this.bnu = -1;
      this.bnv = 0;
      this.bnw = 0;
      this.bnE = new Rect();
      TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, a.c.CoordinatorLayout_Layout);
      this.fl = localTypedArray.getInteger(a.c.CoordinatorLayout_Layout_android_layout_gravity, 0);
      this.bnu = localTypedArray.getResourceId(a.c.CoordinatorLayout_Layout_layout_anchor, -1);
      this.anchorGravity = localTypedArray.getInteger(a.c.CoordinatorLayout_Layout_layout_anchorGravity, 0);
      this.bnt = localTypedArray.getInteger(a.c.CoordinatorLayout_Layout_layout_keyline, -1);
      this.bnv = localTypedArray.getInt(a.c.CoordinatorLayout_Layout_layout_insetEdge, 0);
      this.bnw = localTypedArray.getInt(a.c.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
      this.bns = localTypedArray.hasValue(a.c.CoordinatorLayout_Layout_layout_behavior);
      if (this.bns) {
        this.bnr = CoordinatorLayout.a(paramContext, paramAttributeSet, localTypedArray.getString(a.c.CoordinatorLayout_Layout_layout_behavior));
      }
      localTypedArray.recycle();
      if (this.bnr != null) {
        this.bnr.a(this);
      }
      AppMethodBeat.o(193128);
    }
    
    public d(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
      AppMethodBeat.i(193149);
      this.bns = false;
      this.fl = 0;
      this.anchorGravity = 0;
      this.bnt = -1;
      this.bnu = -1;
      this.bnv = 0;
      this.bnw = 0;
      this.bnE = new Rect();
      AppMethodBeat.o(193149);
    }
    
    public d(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
      AppMethodBeat.i(193144);
      this.bns = false;
      this.fl = 0;
      this.anchorGravity = 0;
      this.bnt = -1;
      this.bnu = -1;
      this.bnv = 0;
      this.bnw = 0;
      this.bnE = new Rect();
      AppMethodBeat.o(193144);
    }
    
    public d(d paramd)
    {
      super();
      AppMethodBeat.i(193139);
      this.bns = false;
      this.fl = 0;
      this.anchorGravity = 0;
      this.bnt = -1;
      this.bnu = -1;
      this.bnv = 0;
      this.bnw = 0;
      this.bnE = new Rect();
      AppMethodBeat.o(193139);
    }
    
    final boolean Ds()
    {
      return (this.mF == null) && (this.bnu != -1);
    }
    
    public final void a(CoordinatorLayout.Behavior paramBehavior)
    {
      AppMethodBeat.i(193152);
      if (this.bnr != paramBehavior)
      {
        this.bnr = paramBehavior;
        this.bnF = null;
        this.bns = true;
        if (paramBehavior != null) {
          paramBehavior.a(this);
        }
      }
      AppMethodBeat.o(193152);
    }
    
    final boolean ea(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return false;
      case 0: 
        return this.bnB;
      }
      return this.bnC;
    }
    
    final void p(int paramInt, boolean paramBoolean)
    {
      switch (paramInt)
      {
      default: 
        return;
      case 0: 
        this.bnB = paramBoolean;
        return;
      }
      this.bnC = paramBoolean;
    }
  }
  
  final class e
    implements ViewTreeObserver.OnPreDrawListener
  {
    e() {}
    
    public final boolean onPreDraw()
    {
      AppMethodBeat.i(193140);
      CoordinatorLayout.this.dZ(0);
      AppMethodBeat.o(193140);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.coordinatorlayout.widget.CoordinatorLayout
 * JD-Core Version:    0.7.0.1
 */