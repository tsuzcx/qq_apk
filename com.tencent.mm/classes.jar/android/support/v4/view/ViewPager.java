package android.support.v4.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v4.content.b;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import java.lang.annotation.Annotation;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ViewPager
  extends ViewGroup
{
  static final int[] Gr = { 16842931 };
  private static final Comparator<b> Gt = new ViewPager.1();
  private static final Interpolator Gu = new ViewPager.2();
  private static final i Hn = new i();
  private float FH;
  private float FI;
  private ClassLoader GA = null;
  private Scroller GB;
  private boolean GC;
  private ViewPager.g GD;
  private int GE;
  private Drawable GF;
  private int GG;
  private int GH;
  private float GI = -3.402824E+038F;
  private float GJ = 3.4028235E+38F;
  private int GK;
  private int GL;
  private boolean GM;
  private boolean GN;
  private int GO = 1;
  private boolean GP;
  private int GQ;
  private int GR;
  private float GS;
  private float GT;
  private int GU;
  private int GV;
  private int GW;
  private int GX;
  private boolean GY;
  private EdgeEffect GZ;
  private int Gs;
  private final b Gv = new b();
  n Gw;
  int Gx;
  private int Gy = -1;
  private Parcelable Gz = null;
  private EdgeEffect Ha;
  private boolean Hb = true;
  private boolean Hc = false;
  private boolean Hd;
  private int He;
  public List<ViewPager.e> Hf;
  private ViewPager.e Hg;
  private ViewPager.e Hh;
  private List<ViewPager.d> Hi;
  private ViewPager.f Hj;
  private int Hk;
  private int Hl;
  private ArrayList<View> Hm;
  private final Runnable Ho = new ViewPager.3(this);
  private final ArrayList<b> dU = new ArrayList();
  private final Rect ec = new Rect();
  private VelocityTracker fB;
  private int fC = -1;
  private boolean iZ;
  private int jb;
  private int lf = 0;
  private boolean mInLayout;
  
  public ViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setWillNotDraw(false);
    setDescendantFocusability(262144);
    setFocusable(true);
    paramContext = getContext();
    this.GB = new Scroller(paramContext, Gu);
    paramAttributeSet = ViewConfiguration.get(paramContext);
    float f = paramContext.getResources().getDisplayMetrics().density;
    this.jb = paramAttributeSet.getScaledPagingTouchSlop();
    this.GU = ((int)(400.0F * f));
    this.GV = paramAttributeSet.getScaledMaximumFlingVelocity();
    this.GZ = new EdgeEffect(paramContext);
    this.Ha = new EdgeEffect(paramContext);
    this.GW = ((int)(25.0F * f));
    this.GX = ((int)(2.0F * f));
    this.GQ = ((int)(16.0F * f));
    q.a(this, new ViewPager.c(this));
    if (q.P(this) == 0) {
      q.n(this, 1);
    }
    q.a(this, new ViewPager.4(this));
  }
  
  private void G(boolean paramBoolean)
  {
    int i;
    if (this.lf == 2)
    {
      i = 1;
      if (i != 0)
      {
        setScrollingCacheEnabled(false);
        if (this.GB.isFinished()) {
          break label170;
        }
      }
    }
    label170:
    for (int j = 1;; j = 0)
    {
      if (j != 0)
      {
        this.GB.abortAnimation();
        j = getScrollX();
        k = getScrollY();
        int m = this.GB.getCurrX();
        int n = this.GB.getCurrY();
        if ((j != m) || (k != n))
        {
          scrollTo(m, n);
          if (m != j) {
            aA(m);
          }
        }
      }
      this.GN = false;
      int k = 0;
      j = i;
      i = k;
      while (i < this.dU.size())
      {
        b localb = (b)this.dU.get(i);
        if (localb.Hq)
        {
          localb.Hq = false;
          j = 1;
        }
        i += 1;
      }
      i = 0;
      break;
    }
    if (j != 0)
    {
      if (paramBoolean) {
        q.b(this, this.Ho);
      }
    }
    else {
      return;
    }
    this.Ho.run();
  }
  
  private Rect a(Rect paramRect, View paramView)
  {
    if (paramRect == null) {
      paramRect = new Rect();
    }
    for (;;)
    {
      if (paramView == null)
      {
        paramRect.set(0, 0, 0, 0);
        return paramRect;
      }
      paramRect.left = paramView.getLeft();
      paramRect.right = paramView.getRight();
      paramRect.top = paramView.getTop();
      paramRect.bottom = paramView.getBottom();
      for (paramView = paramView.getParent(); ((paramView instanceof ViewGroup)) && (paramView != this); paramView = paramView.getParent())
      {
        paramView = (ViewGroup)paramView;
        paramRect.left += paramView.getLeft();
        paramRect.right += paramView.getRight();
        paramRect.top += paramView.getTop();
        paramRect.bottom += paramView.getBottom();
      }
      return paramRect;
    }
  }
  
  private void a(int paramInt1, float paramFloat, int paramInt2)
  {
    int i;
    int k;
    int i2;
    int m;
    Object localObject;
    int j;
    label120:
    int n;
    if (this.He > 0)
    {
      int i1 = getScrollX();
      i = getPaddingLeft();
      k = getPaddingRight();
      i2 = getWidth();
      int i3 = getChildCount();
      m = 0;
      if (m < i3)
      {
        localObject = getChildAt(m);
        LayoutParams localLayoutParams = (LayoutParams)((View)localObject).getLayoutParams();
        if (!localLayoutParams.Ht) {
          break label438;
        }
        switch (localLayoutParams.gravity & 0x7)
        {
        case 2: 
        case 4: 
        default: 
          j = i;
          int i4 = j + i1 - ((View)localObject).getLeft();
          n = k;
          j = i;
          if (i4 != 0)
          {
            ((View)localObject).offsetLeftAndRight(i4);
            j = i;
            n = k;
          }
          break;
        }
      }
    }
    for (;;)
    {
      m += 1;
      i = j;
      k = n;
      break;
      n = i + ((View)localObject).getWidth();
      j = i;
      i = n;
      break label120;
      j = Math.max((i2 - ((View)localObject).getMeasuredWidth()) / 2, i);
      break label120;
      j = i2 - k - ((View)localObject).getMeasuredWidth();
      k += ((View)localObject).getMeasuredWidth();
      break label120;
      if (this.Hg != null) {
        this.Hg.a(paramInt1, paramFloat, paramInt2);
      }
      if (this.Hf != null)
      {
        j = this.Hf.size();
        i = 0;
        while (i < j)
        {
          localObject = (ViewPager.e)this.Hf.get(i);
          if (localObject != null) {
            ((ViewPager.e)localObject).a(paramInt1, paramFloat, paramInt2);
          }
          i += 1;
        }
      }
      if (this.Hh != null) {
        this.Hh.a(paramInt1, paramFloat, paramInt2);
      }
      if (this.Hj != null)
      {
        paramInt2 = getScrollX();
        i = getChildCount();
        paramInt1 = 0;
        while (paramInt1 < i)
        {
          localObject = getChildAt(paramInt1);
          if (!((LayoutParams)((View)localObject).getLayoutParams()).Ht)
          {
            paramFloat = (((View)localObject).getLeft() - paramInt2) / getClientWidth();
            this.Hj.j((View)localObject, paramFloat);
          }
          paramInt1 += 1;
        }
      }
      this.Hd = true;
      return;
      label438:
      n = k;
      j = i;
    }
  }
  
  private void a(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    b localb = az(paramInt1);
    if (localb != null) {}
    for (int j = (int)(getClientWidth() * Math.max(this.GI, Math.min(localb.Hs, this.GJ)));; j = 0)
    {
      if (paramBoolean1)
      {
        if (getChildCount() == 0)
        {
          setScrollingCacheEnabled(false);
          if (paramBoolean2) {
            aB(paramInt1);
          }
          return;
        }
        int i;
        if ((this.GB != null) && (!this.GB.isFinished()))
        {
          i = 1;
          label87:
          if (i == 0) {
            break label184;
          }
          if (!this.GC) {
            break label172;
          }
          i = this.GB.getCurrX();
          label108:
          this.GB.abortAnimation();
          setScrollingCacheEnabled(false);
        }
        int k;
        int m;
        for (;;)
        {
          k = getScrollY();
          j -= i;
          m = 0 - k;
          if ((j != 0) || (m != 0)) {
            break label193;
          }
          G(false);
          dm();
          setScrollState(0);
          break;
          i = 0;
          break label87;
          label172:
          i = this.GB.getStartX();
          break label108;
          label184:
          i = getScrollX();
        }
        label193:
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int n = getClientWidth();
        int i1 = n / 2;
        float f3 = Math.min(1.0F, 1.0F * Math.abs(j) / n);
        float f1 = i1;
        float f2 = i1;
        f3 = (float)Math.sin((f3 - 0.5F) * 0.4712389F);
        paramInt2 = Math.abs(paramInt2);
        if (paramInt2 > 0) {}
        for (paramInt2 = Math.round(1000.0F * Math.abs((f2 * f3 + f1) / paramInt2)) * 4;; paramInt2 = (int)((Math.abs(j) / (f1 * f2 + this.GE) + 1.0F) * 100.0F))
        {
          paramInt2 = Math.min(paramInt2, 600);
          this.GC = false;
          this.GB.startScroll(i, k, j, m, paramInt2);
          q.O(this);
          break;
          f1 = n;
          f2 = this.Gw.ax(this.Gx);
        }
      }
      if (paramBoolean2) {
        aB(paramInt1);
      }
      G(false);
      scrollTo(j, 0);
      aA(j);
      return;
    }
  }
  
  private void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramInt, paramBoolean1, paramBoolean2, 0);
  }
  
  private void a(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    boolean bool = false;
    if ((this.Gw == null) || (this.Gw.getCount() <= 0))
    {
      setScrollingCacheEnabled(false);
      return;
    }
    if ((!paramBoolean2) && (this.Gx == paramInt1) && (this.dU.size() != 0))
    {
      setScrollingCacheEnabled(false);
      return;
    }
    int i;
    if (paramInt1 < 0) {
      i = 0;
    }
    for (;;)
    {
      paramInt1 = this.GO;
      if ((i <= this.Gx + paramInt1) && (i >= this.Gx - paramInt1)) {
        break;
      }
      paramInt1 = 0;
      while (paramInt1 < this.dU.size())
      {
        ((b)this.dU.get(paramInt1)).Hq = true;
        paramInt1 += 1;
      }
      i = paramInt1;
      if (paramInt1 >= this.Gw.getCount()) {
        i = this.Gw.getCount() - 1;
      }
    }
    paramBoolean2 = bool;
    if (this.Gx != i) {
      paramBoolean2 = true;
    }
    if (this.Hb)
    {
      this.Gx = i;
      if (paramBoolean2) {
        aB(i);
      }
      requestLayout();
      return;
    }
    ay(i);
    a(i, paramBoolean1, paramInt2, paramBoolean2);
  }
  
  private void a(b paramb1, int paramInt, b paramb2)
  {
    int m = this.Gw.getCount();
    int i = getClientWidth();
    float f2;
    if (i > 0)
    {
      f2 = this.GE / i;
      if (paramb2 == null) {
        break label409;
      }
      i = paramb2.position;
      if (i < paramb1.position)
      {
        f1 = paramb2.Hs + paramb2.Hr + f2;
        i += 1;
        j = 0;
      }
    }
    else
    {
      for (;;)
      {
        if ((i > paramb1.position) || (j >= this.dU.size())) {
          break label409;
        }
        for (paramb2 = (b)this.dU.get(j);; paramb2 = (b)this.dU.get(j))
        {
          k = i;
          f3 = f1;
          if (i <= paramb2.position) {
            break;
          }
          k = i;
          f3 = f1;
          if (j >= this.dU.size() - 1) {
            break;
          }
          j += 1;
        }
        f2 = 0.0F;
        break;
        while (k < paramb2.position)
        {
          f3 += this.Gw.ax(k) + f2;
          k += 1;
        }
        paramb2.Hs = f3;
        f1 = f3 + (paramb2.Hr + f2);
        i = k + 1;
      }
    }
    if (i > paramb1.position)
    {
      j = this.dU.size() - 1;
      f1 = paramb2.Hs;
      i -= 1;
      while ((i >= paramb1.position) && (j >= 0))
      {
        for (paramb2 = (b)this.dU.get(j);; paramb2 = (b)this.dU.get(j))
        {
          k = i;
          f3 = f1;
          if (i >= paramb2.position) {
            break;
          }
          k = i;
          f3 = f1;
          if (j <= 0) {
            break;
          }
          j -= 1;
        }
        while (k > paramb2.position)
        {
          f3 -= this.Gw.ax(k) + f2;
          k -= 1;
        }
        f1 = f3 - (paramb2.Hr + f2);
        paramb2.Hs = f1;
        i = k - 1;
      }
    }
    label409:
    int k = this.dU.size();
    float f3 = paramb1.Hs;
    i = paramb1.position - 1;
    if (paramb1.position == 0)
    {
      f1 = paramb1.Hs;
      this.GI = f1;
      if (paramb1.position != m - 1) {
        break label550;
      }
      f1 = paramb1.Hs + paramb1.Hr - 1.0F;
      label475:
      this.GJ = f1;
      j = paramInt - 1;
      f1 = f3;
    }
    for (;;)
    {
      if (j < 0) {
        break label603;
      }
      paramb2 = (b)this.dU.get(j);
      for (;;)
      {
        if (i > paramb2.position)
        {
          f1 -= this.Gw.ax(i) + f2;
          i -= 1;
          continue;
          f1 = -3.402824E+038F;
          break;
          label550:
          f1 = 3.4028235E+38F;
          break label475;
        }
      }
      f1 -= paramb2.Hr + f2;
      paramb2.Hs = f1;
      if (paramb2.position == 0) {
        this.GI = f1;
      }
      i -= 1;
      j -= 1;
    }
    label603:
    float f1 = paramb1.Hs + paramb1.Hr + f2;
    int j = paramb1.position + 1;
    i = paramInt + 1;
    paramInt = j;
    while (i < k)
    {
      paramb1 = (b)this.dU.get(i);
      while (paramInt < paramb1.position)
      {
        f1 += this.Gw.ax(paramInt) + f2;
        paramInt += 1;
      }
      if (paramb1.position == m - 1) {
        this.GJ = (paramb1.Hr + f1 - 1.0F);
      }
      paramb1.Hs = f1;
      f1 += paramb1.Hr + f2;
      paramInt += 1;
      i += 1;
    }
    this.Hc = false;
  }
  
  private boolean a(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    int i;
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int j = paramView.getScrollX();
      int k = paramView.getScrollY();
      i = localViewGroup.getChildCount() - 1;
      if (i >= 0)
      {
        localView = localViewGroup.getChildAt(i);
        if ((paramInt2 + j < localView.getLeft()) || (paramInt2 + j >= localView.getRight()) || (paramInt3 + k < localView.getTop()) || (paramInt3 + k >= localView.getBottom()) || (!a(localView, true, paramInt1, paramInt2 + j - localView.getLeft(), paramInt3 + k - localView.getTop()))) {}
      }
    }
    while ((paramBoolean) && (paramView.canScrollHorizontally(-paramInt1)))
    {
      View localView;
      return true;
      i -= 1;
      break;
    }
    return false;
  }
  
  private boolean aA(int paramInt)
  {
    if (this.dU.size() == 0)
    {
      if (this.Hb) {}
      do
      {
        return false;
        this.Hd = false;
        a(0, 0.0F, 0);
      } while (this.Hd);
      throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }
    b localb = dq();
    int j = getClientWidth();
    int k = this.GE;
    float f = this.GE / j;
    int i = localb.position;
    f = (paramInt / j - localb.Hs) / (localb.Hr + f);
    paramInt = (int)((k + j) * f);
    this.Hd = false;
    a(i, f, paramInt);
    if (!this.Hd) {
      throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }
    return true;
  }
  
  private void aB(int paramInt)
  {
    if (this.Hg != null) {
      this.Hg.R(paramInt);
    }
    if (this.Hf != null)
    {
      int j = this.Hf.size();
      int i = 0;
      while (i < j)
      {
        ViewPager.e locale = (ViewPager.e)this.Hf.get(i);
        if (locale != null) {
          locale.R(paramInt);
        }
        i += 1;
      }
    }
    if (this.Hh != null) {
      this.Hh.R(paramInt);
    }
  }
  
  private boolean arrowScroll(int paramInt)
  {
    View localView = findFocus();
    Object localObject;
    int j;
    boolean bool;
    if (localView == this)
    {
      localObject = null;
      localView = FocusFinder.getInstance().findNextFocus(this, (View)localObject, paramInt);
      if ((localView == null) || (localView == localObject)) {
        break label308;
      }
      if (paramInt != 17) {
        break label254;
      }
      i = a(this.ec, localView).left;
      j = a(this.ec, (View)localObject).left;
      if ((localObject != null) && (i >= j))
      {
        bool = dr();
        label89:
        if (bool) {
          playSoundEffect(SoundEffectConstants.getContantForFocusDirection(paramInt));
        }
        return bool;
      }
    }
    else
    {
      if (localView == null) {
        break label354;
      }
      localObject = localView.getParent();
      if (!(localObject instanceof ViewGroup)) {
        break label361;
      }
      if (localObject != this) {}
    }
    label308:
    label348:
    label354:
    label361:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localView.getClass().getSimpleName());
        localObject = localView.getParent();
        for (;;)
        {
          if ((localObject instanceof ViewGroup))
          {
            localStringBuilder.append(" => ").append(localObject.getClass().getSimpleName());
            localObject = ((ViewParent)localObject).getParent();
            continue;
            localObject = ((ViewParent)localObject).getParent();
            break;
          }
        }
        new StringBuilder("arrowScroll tried to find focus based on non-child current focused view ").append(localStringBuilder.toString());
        localObject = null;
        break;
        bool = localView.requestFocus();
        break label89;
        label254:
        if (paramInt == 66)
        {
          i = a(this.ec, localView).left;
          j = a(this.ec, (View)localObject).left;
          if ((localObject == null) || (i > j))
          {
            bool = localView.requestFocus();
            break label89;
            if ((paramInt == 17) || (paramInt == 1))
            {
              bool = dr();
              break label89;
            }
            if ((paramInt != 66) && (paramInt != 2)) {
              break label348;
            }
          }
          bool = ds();
          break label89;
        }
        bool = false;
        break label89;
      }
      localObject = localView;
      break;
    }
  }
  
  private b as(View paramView)
  {
    int i = 0;
    while (i < this.dU.size())
    {
      b localb = (b)this.dU.get(i);
      if (this.Gw.a(paramView, localb.object)) {
        return localb;
      }
      i += 1;
    }
    return null;
  }
  
  private b at(View paramView)
  {
    for (;;)
    {
      ViewParent localViewParent = paramView.getParent();
      if (localViewParent == this) {
        break;
      }
      if ((localViewParent == null) || (!(localViewParent instanceof View))) {
        return null;
      }
      paramView = (View)localViewParent;
    }
    return as(paramView);
  }
  
  private void ay(int paramInt)
  {
    Object localObject2;
    if (this.Gx != paramInt)
    {
      localObject2 = az(this.Gx);
      this.Gx = paramInt;
    }
    for (;;)
    {
      if (this.Gw == null) {
        dn();
      }
      do
      {
        return;
        if (this.GN)
        {
          dn();
          return;
        }
      } while (getWindowToken() == null);
      this.Gw.e(this);
      paramInt = this.GO;
      int i1 = Math.max(0, this.Gx - paramInt);
      int m = this.Gw.getCount();
      int n = Math.min(m - 1, paramInt + this.Gx);
      Object localObject1;
      if (m != this.Gs) {
        try
        {
          String str = getResources().getResourceName(getId());
          throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.Gs + ", found: " + m + " Pager id: " + str + " Pager class: " + getClass() + " Problematic adapter: " + this.Gw.getClass());
        }
        catch (Resources.NotFoundException localNotFoundException)
        {
          for (;;)
          {
            localObject1 = Integer.toHexString(getId());
          }
        }
      }
      paramInt = 0;
      label220:
      if (paramInt < this.dU.size())
      {
        localObject1 = (b)this.dU.get(paramInt);
        if (((b)localObject1).position >= this.Gx) {
          if (((b)localObject1).position != this.Gx) {
            break label1190;
          }
        }
      }
      label641:
      label653:
      label799:
      label1190:
      for (;;)
      {
        if ((localObject1 == null) && (m > 0)) {}
        label433:
        label826:
        for (Object localObject3 = s(this.Gx, paramInt);; localObject3 = localObject1)
        {
          float f1;
          int k;
          label320:
          int i2;
          float f2;
          label333:
          int j;
          int i;
          if (localObject3 != null)
          {
            f1 = 0.0F;
            k = paramInt - 1;
            if (k >= 0)
            {
              localObject1 = (b)this.dU.get(k);
              i2 = getClientWidth();
              if (i2 > 0) {
                break label461;
              }
              f2 = 0.0F;
              j = this.Gx - 1;
              i = paramInt;
              paramInt = k;
              label347:
              if (j < 0) {
                break label588;
              }
              if ((f1 < f2) || (j >= i1)) {
                break label488;
              }
              if (localObject1 == null) {
                break label588;
              }
              if ((j != ((b)localObject1).position) || (((b)localObject1).Hq)) {
                break label1180;
              }
              this.dU.remove(paramInt);
              this.Gw.a(this, j, ((b)localObject1).object);
              paramInt -= 1;
              if (paramInt < 0) {
                break label482;
              }
              localObject1 = (b)this.dU.get(paramInt);
              i -= 1;
            }
          }
          label588:
          for (;;)
          {
            j -= 1;
            break label347;
            paramInt += 1;
            break label220;
            localObject1 = null;
            break label320;
            label461:
            f2 = 2.0F - ((b)localObject3).Hr + getPaddingLeft() / i2;
            break label333;
            label482:
            localObject1 = null;
            break label433;
            label488:
            if ((localObject1 != null) && (j == ((b)localObject1).position))
            {
              f1 += ((b)localObject1).Hr;
              paramInt -= 1;
              if (paramInt >= 0) {
                localObject1 = (b)this.dU.get(paramInt);
              } else {
                localObject1 = null;
              }
            }
            else
            {
              f1 += s(j, paramInt + 1).Hr;
              i += 1;
              if (paramInt >= 0) {}
              for (localObject1 = (b)this.dU.get(paramInt);; localObject1 = null) {
                break;
              }
              float f3 = ((b)localObject3).Hr;
              k = i + 1;
              if (f3 < 2.0F)
              {
                Object localObject4;
                if (k < this.dU.size())
                {
                  localObject1 = (b)this.dU.get(k);
                  if (i2 > 0) {
                    break label799;
                  }
                  f2 = 0.0F;
                  j = this.Gx + 1;
                  localObject4 = localObject1;
                  if (j >= m) {
                    break label945;
                  }
                  if ((f3 < f2) || (j <= n)) {
                    break label826;
                  }
                  if (localObject4 == null) {
                    break label945;
                  }
                  localObject1 = localObject4;
                  f1 = f3;
                  paramInt = k;
                  if (j == localObject4.position)
                  {
                    localObject1 = localObject4;
                    f1 = f3;
                    paramInt = k;
                    if (!localObject4.Hq)
                    {
                      this.dU.remove(k);
                      this.Gw.a(this, j, localObject4.object);
                      if (k >= this.dU.size()) {
                        break label814;
                      }
                      localObject1 = (b)this.dU.get(k);
                      paramInt = k;
                      f1 = f3;
                    }
                  }
                }
                for (;;)
                {
                  j += 1;
                  localObject4 = localObject1;
                  f3 = f1;
                  k = paramInt;
                  break label653;
                  localObject1 = null;
                  break;
                  f2 = getPaddingRight() / i2 + 2.0F;
                  break label641;
                  localObject1 = null;
                  f1 = f3;
                  paramInt = k;
                  continue;
                  if ((localObject4 != null) && (j == localObject4.position))
                  {
                    f1 = f3 + localObject4.Hr;
                    paramInt = k + 1;
                    if (paramInt < this.dU.size()) {
                      localObject1 = (b)this.dU.get(paramInt);
                    } else {
                      localObject1 = null;
                    }
                  }
                  else
                  {
                    localObject1 = s(j, k);
                    paramInt = k + 1;
                    f1 = f3 + ((b)localObject1).Hr;
                    if (paramInt < this.dU.size()) {
                      localObject1 = (b)this.dU.get(paramInt);
                    } else {
                      localObject1 = null;
                    }
                  }
                }
              }
              a((b)localObject3, i, (b)localObject2);
              this.Gw.j(((b)localObject3).object);
              this.Gw.cc();
              i = getChildCount();
              paramInt = 0;
              while (paramInt < i)
              {
                localObject2 = getChildAt(paramInt);
                localObject1 = (LayoutParams)((View)localObject2).getLayoutParams();
                ((LayoutParams)localObject1).Hv = paramInt;
                if ((!((LayoutParams)localObject1).Ht) && (((LayoutParams)localObject1).Hr == 0.0F))
                {
                  localObject2 = as((View)localObject2);
                  if (localObject2 != null)
                  {
                    ((LayoutParams)localObject1).Hr = ((b)localObject2).Hr;
                    ((LayoutParams)localObject1).position = ((b)localObject2).position;
                  }
                }
                paramInt += 1;
              }
              dn();
              if (!hasFocus()) {
                break;
              }
              localObject1 = findFocus();
              if (localObject1 != null) {}
              for (localObject1 = at((View)localObject1);; localObject1 = null)
              {
                if ((localObject1 != null) && (((b)localObject1).position == this.Gx)) {
                  break label1178;
                }
                paramInt = 0;
                for (;;)
                {
                  if (paramInt >= getChildCount()) {
                    break label1172;
                  }
                  localObject1 = getChildAt(paramInt);
                  localObject2 = as((View)localObject1);
                  if ((localObject2 != null) && (((b)localObject2).position == this.Gx) && (((View)localObject1).requestFocus(2))) {
                    break;
                  }
                  paramInt += 1;
                }
                break;
              }
              break;
            }
          }
        }
        label814:
        label945:
        localObject1 = null;
      }
      label1172:
      label1178:
      label1180:
      localObject2 = null;
    }
  }
  
  private b az(int paramInt)
  {
    int i = 0;
    while (i < this.dU.size())
    {
      b localb = (b)this.dU.get(i);
      if (localb.position == paramInt) {
        return localb;
      }
      i += 1;
    }
    return null;
  }
  
  private void d(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i) == this.fC) {
      if (i != 0) {
        break label56;
      }
    }
    label56:
    for (i = 1;; i = 0)
    {
      this.GS = paramMotionEvent.getX(i);
      this.fC = paramMotionEvent.getPointerId(i);
      if (this.fB != null) {
        this.fB.clear();
      }
      return;
    }
  }
  
  private void dn()
  {
    if (this.Hl != 0)
    {
      if (this.Hm == null) {
        this.Hm = new ArrayList();
      }
      for (;;)
      {
        int j = getChildCount();
        int i = 0;
        while (i < j)
        {
          View localView = getChildAt(i);
          this.Hm.add(localView);
          i += 1;
        }
        this.Hm.clear();
      }
      Collections.sort(this.Hm, Hn);
    }
  }
  
  private boolean jdMethod_do()
  {
    boolean bool = false;
    this.fC = -1;
    this.iZ = false;
    this.GP = false;
    if (this.fB != null)
    {
      this.fB.recycle();
      this.fB = null;
    }
    this.GZ.onRelease();
    this.Ha.onRelease();
    if ((this.GZ.isFinished()) || (this.Ha.isFinished())) {
      bool = true;
    }
    return bool;
  }
  
  private void dp()
  {
    ViewParent localViewParent = getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(true);
    }
  }
  
  private b dq()
  {
    int i = getClientWidth();
    float f1;
    float f2;
    label36:
    int k;
    int j;
    Object localObject1;
    float f3;
    float f4;
    label53:
    Object localObject2;
    b localb;
    if (i > 0)
    {
      f1 = getScrollX() / i;
      if (i <= 0) {
        break label215;
      }
      f2 = this.GE / i;
      k = -1;
      j = 1;
      i = 0;
      localObject1 = null;
      f3 = 0.0F;
      f4 = 0.0F;
      localObject2 = localObject1;
      if (i < this.dU.size())
      {
        localb = (b)this.dU.get(i);
        if ((j != 0) || (localb.position == k + 1)) {
          break label249;
        }
        localb = this.Gv;
        localb.Hs = (f4 + f3 + f2);
        localb.position = (k + 1);
        localb.Hr = this.Gw.ax(localb.position);
        i -= 1;
      }
    }
    label215:
    label220:
    label249:
    for (;;)
    {
      f4 = localb.Hs;
      f3 = localb.Hr;
      if (j == 0)
      {
        localObject2 = localObject1;
        if (f1 < f4) {}
      }
      else
      {
        if ((f1 >= f3 + f4 + f2) && (i != this.dU.size() - 1)) {
          break label220;
        }
        localObject2 = localb;
      }
      return localObject2;
      f1 = 0.0F;
      break;
      f2 = 0.0F;
      break label36;
      k = localb.position;
      f3 = localb.Hr;
      i += 1;
      j = 0;
      localObject1 = localb;
      break label53;
    }
  }
  
  private boolean dr()
  {
    if (this.Gx > 0)
    {
      m(this.Gx - 1, true);
      return true;
    }
    return false;
  }
  
  private boolean ds()
  {
    if ((this.Gw != null) && (this.Gx < this.Gw.getCount() - 1))
    {
      m(this.Gx + 1, true);
      return true;
    }
    return false;
  }
  
  private void e(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt2 > 0) && (!this.dU.isEmpty()))
    {
      if (!this.GB.isFinished())
      {
        this.GB.setFinalX(getCurrentItem() * getClientWidth());
        return;
      }
      int i = getPaddingLeft();
      int j = getPaddingRight();
      int k = getPaddingLeft();
      int m = getPaddingRight();
      f = getScrollX() / (paramInt2 - k - m + paramInt4);
      scrollTo((int)((paramInt1 - i - j + paramInt3) * f), getScrollY());
      return;
    }
    b localb = az(this.Gx);
    if (localb != null) {}
    for (float f = Math.min(localb.Hs, this.GJ);; f = 0.0F)
    {
      paramInt1 = (int)(f * (paramInt1 - getPaddingLeft() - getPaddingRight()));
      if (paramInt1 == getScrollX()) {
        break;
      }
      G(false);
      scrollTo(paramInt1, getScrollY());
      return;
    }
  }
  
  private int getClientWidth()
  {
    return getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
  }
  
  private boolean r(float paramFloat)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    float f1 = this.GS;
    this.GS = paramFloat;
    float f2 = getScrollX() + (f1 - paramFloat);
    int k = getClientWidth();
    paramFloat = k * this.GI;
    f1 = k;
    float f3 = this.GJ;
    b localb1 = (b)this.dU.get(0);
    b localb2 = (b)this.dU.get(this.dU.size() - 1);
    if (localb1.position != 0)
    {
      paramFloat = localb1.Hs;
      paramFloat = k * paramFloat;
    }
    for (int i = 0;; i = 1)
    {
      int j;
      if (localb2.position != this.Gw.getCount() - 1)
      {
        f1 = localb2.Hs * k;
        j = 0;
      }
      for (;;)
      {
        if (f2 < paramFloat)
        {
          if (i == 0) {
            break label251;
          }
          this.GZ.onPull(Math.abs(paramFloat - f2) / k);
        }
        for (;;)
        {
          this.GS += paramFloat - (int)paramFloat;
          scrollTo((int)paramFloat, getScrollY());
          aA((int)paramFloat);
          return bool1;
          if (f2 > f1)
          {
            if (j != 0) {
              this.Ha.onPull(Math.abs(f2 - f1) / k);
            }
            for (bool1 = bool2;; bool1 = false)
            {
              paramFloat = f1;
              break;
            }
          }
          bool1 = false;
          paramFloat = f2;
          continue;
          label251:
          bool1 = false;
        }
        j = 1;
        f1 *= f3;
      }
    }
  }
  
  private b s(int paramInt1, int paramInt2)
  {
    b localb = new b();
    localb.position = paramInt1;
    localb.object = this.Gw.b(this, paramInt1);
    localb.Hr = this.Gw.ax(paramInt1);
    if ((paramInt2 < 0) || (paramInt2 >= this.dU.size()))
    {
      this.dU.add(localb);
      return localb;
    }
    this.dU.add(paramInt2, localb);
    return localb;
  }
  
  private void setScrollingCacheEnabled(boolean paramBoolean)
  {
    if (this.GM != paramBoolean) {
      this.GM = paramBoolean;
    }
  }
  
  public final void a(ViewPager.d paramd)
  {
    if (this.Hi == null) {
      this.Hi = new ArrayList();
    }
    this.Hi.add(paramd);
  }
  
  public final void a(ViewPager.e parame)
  {
    if (this.Hf == null) {
      this.Hf = new ArrayList();
    }
    this.Hf.add(parame);
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    int j = paramArrayList.size();
    int k = getDescendantFocusability();
    if (k != 393216)
    {
      int i = 0;
      while (i < getChildCount())
      {
        View localView = getChildAt(i);
        if (localView.getVisibility() == 0)
        {
          b localb = as(localView);
          if ((localb != null) && (localb.position == this.Gx)) {
            localView.addFocusables(paramArrayList, paramInt1, paramInt2);
          }
        }
        i += 1;
      }
    }
    if (((k == 262144) && (j != paramArrayList.size())) || (!isFocusable())) {}
    while ((((paramInt2 & 0x1) == 1) && (isInTouchMode()) && (!isFocusableInTouchMode())) || (paramArrayList == null)) {
      return;
    }
    paramArrayList.add(this);
  }
  
  public void addTouchables(ArrayList<View> paramArrayList)
  {
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 0)
      {
        b localb = as(localView);
        if ((localb != null) && (localb.position == this.Gx)) {
          localView.addTouchables(paramArrayList);
        }
      }
      i += 1;
    }
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (!checkLayoutParams(paramLayoutParams)) {
      paramLayoutParams = generateLayoutParams(paramLayoutParams);
    }
    for (;;)
    {
      LayoutParams localLayoutParams = (LayoutParams)paramLayoutParams;
      boolean bool2 = localLayoutParams.Ht;
      if (paramView.getClass().getAnnotation(a.class) != null) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        localLayoutParams.Ht = (bool1 | bool2);
        if (!this.mInLayout) {
          break label104;
        }
        if ((localLayoutParams == null) || (!localLayoutParams.Ht)) {
          break;
        }
        throw new IllegalStateException("Cannot add pager decor view during layout");
      }
      localLayoutParams.Hu = true;
      addViewInLayout(paramView, paramInt, paramLayoutParams);
      return;
      label104:
      super.addView(paramView, paramInt, paramLayoutParams);
      return;
    }
  }
  
  final ViewPager.e b(ViewPager.e parame)
  {
    ViewPager.e locale = this.Hh;
    this.Hh = parame;
    return locale;
  }
  
  public final void b(ViewPager.d paramd)
  {
    if (this.Hi != null) {
      this.Hi.remove(paramd);
    }
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    if (this.Gw == null) {}
    int i;
    int j;
    do
    {
      do
      {
        return false;
        i = getClientWidth();
        j = getScrollX();
        if (paramInt >= 0) {
          break;
        }
      } while (j <= (int)(i * this.GI));
      return true;
    } while ((paramInt <= 0) || (j >= (int)(i * this.GJ)));
    return true;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof LayoutParams)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  public void computeScroll()
  {
    this.GC = true;
    if ((!this.GB.isFinished()) && (this.GB.computeScrollOffset()))
    {
      int i = getScrollX();
      int j = getScrollY();
      int k = this.GB.getCurrX();
      int m = this.GB.getCurrY();
      if ((i != k) || (j != m))
      {
        scrollTo(k, m);
        if (!aA(k))
        {
          this.GB.abortAnimation();
          scrollTo(0, m);
        }
      }
      q.O(this);
      return;
    }
    G(true);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    boolean bool2 = false;
    boolean bool1;
    if (!super.dispatchKeyEvent(paramKeyEvent))
    {
      if (paramKeyEvent.getAction() == 0) {}
      switch (paramKeyEvent.getKeyCode())
      {
      default: 
        bool1 = false;
      }
    }
    for (;;)
    {
      if (bool1) {
        bool2 = true;
      }
      return bool2;
      if (paramKeyEvent.hasModifiers(2))
      {
        bool1 = dr();
      }
      else
      {
        bool1 = arrowScroll(17);
        continue;
        if (paramKeyEvent.hasModifiers(2))
        {
          bool1 = ds();
        }
        else
        {
          bool1 = arrowScroll(66);
          continue;
          if (paramKeyEvent.hasNoModifiers())
          {
            bool1 = arrowScroll(2);
          }
          else
          {
            if (!paramKeyEvent.hasModifiers(1)) {
              break;
            }
            bool1 = arrowScroll(1);
          }
        }
      }
    }
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramAccessibilityEvent.getEventType() == 4096)
    {
      bool1 = super.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
      return bool1;
    }
    int j = getChildCount();
    int i = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i >= j) {
        break;
      }
      View localView = getChildAt(i);
      if (localView.getVisibility() == 0)
      {
        b localb = as(localView);
        if ((localb != null) && (localb.position == this.Gx) && (localView.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent))) {
          return true;
        }
      }
      i += 1;
    }
  }
  
  final void dl()
  {
    int i5 = this.Gw.getCount();
    this.Gs = i5;
    int i;
    int j;
    int n;
    int k;
    int i3;
    label60:
    Object localObject;
    int i4;
    int i2;
    int i1;
    int m;
    if ((this.dU.size() < this.GO * 2 + 1) && (this.dU.size() < i5))
    {
      i = 1;
      j = this.Gx;
      n = 0;
      k = 0;
      i3 = i;
      if (n >= this.dU.size()) {
        break label296;
      }
      localObject = (b)this.dU.get(n);
      i4 = this.Gw.F(((b)localObject).object);
      i2 = n;
      i1 = k;
      m = j;
      i = i3;
      if (i4 != -1)
      {
        if (i4 != -2) {
          break label236;
        }
        this.dU.remove(n);
        i2 = n - 1;
        n = k;
        if (k == 0)
        {
          this.Gw.e(this);
          n = 1;
        }
        this.Gw.a(this, ((b)localObject).position, ((b)localObject).object);
        if (this.Gx != ((b)localObject).position) {
          break label380;
        }
        m = Math.max(0, Math.min(this.Gx, i5 - 1));
        i = 1;
        i1 = n;
      }
    }
    for (;;)
    {
      n = i2 + 1;
      k = i1;
      j = m;
      i3 = i;
      break label60;
      i = 0;
      break;
      label236:
      i2 = n;
      i1 = k;
      m = j;
      i = i3;
      if (((b)localObject).position != i4)
      {
        if (((b)localObject).position == this.Gx) {
          j = i4;
        }
        ((b)localObject).position = i4;
        i = 1;
        i2 = n;
        i1 = k;
        m = j;
        continue;
        label296:
        if (k != 0) {
          this.Gw.cc();
        }
        Collections.sort(this.dU, Gt);
        if (i3 != 0)
        {
          k = getChildCount();
          i = 0;
          while (i < k)
          {
            localObject = (LayoutParams)getChildAt(i).getLayoutParams();
            if (!((LayoutParams)localObject).Ht) {
              ((LayoutParams)localObject).Hr = 0.0F;
            }
            i += 1;
          }
          a(j, false, true);
          requestLayout();
        }
        return;
        label380:
        i = 1;
        i1 = n;
        m = j;
      }
    }
  }
  
  final void dm()
  {
    ay(this.Gx);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int k = 0;
    int i = 0;
    int m = getOverScrollMode();
    boolean bool;
    if ((m == 0) || ((m == 1) && (this.Gw != null) && (this.Gw.getCount() > 1)))
    {
      int j;
      if (!this.GZ.isFinished())
      {
        k = paramCanvas.save();
        i = getHeight() - getPaddingTop() - getPaddingBottom();
        m = getWidth();
        paramCanvas.rotate(270.0F);
        paramCanvas.translate(-i + getPaddingTop(), this.GI * m);
        this.GZ.setSize(i, m);
        j = this.GZ.draw(paramCanvas) | false;
        paramCanvas.restoreToCount(k);
      }
      k = j;
      if (!this.Ha.isFinished())
      {
        m = paramCanvas.save();
        k = getWidth();
        int n = getHeight();
        int i1 = getPaddingTop();
        int i2 = getPaddingBottom();
        paramCanvas.rotate(90.0F);
        paramCanvas.translate(-getPaddingTop(), -(this.GJ + 1.0F) * k);
        this.Ha.setSize(n - i1 - i2, k);
        bool = j | this.Ha.draw(paramCanvas);
        paramCanvas.restoreToCount(m);
      }
    }
    for (;;)
    {
      if (bool) {
        q.O(this);
      }
      return;
      this.GZ.finish();
      this.Ha.finish();
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    Drawable localDrawable = this.GF;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      localDrawable.setState(getDrawableState());
    }
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return generateDefaultLayoutParams();
  }
  
  public n getAdapter()
  {
    return this.Gw;
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (this.Hl == 2) {
      i = paramInt1 - 1 - paramInt2;
    }
    return ((LayoutParams)((View)this.Hm.get(i)).getLayoutParams()).Hv;
  }
  
  public int getCurrentItem()
  {
    return this.Gx;
  }
  
  public int getOffscreenPageLimit()
  {
    return this.GO;
  }
  
  public int getPageMargin()
  {
    return this.GE;
  }
  
  public final void m(int paramInt, boolean paramBoolean)
  {
    this.GN = false;
    a(paramInt, paramBoolean, false);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.Hb = true;
  }
  
  protected void onDetachedFromWindow()
  {
    removeCallbacks(this.Ho);
    if ((this.GB != null) && (!this.GB.isFinished())) {
      this.GB.abortAnimation();
    }
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.GE > 0) && (this.GF != null) && (this.dU.size() > 0) && (this.Gw != null))
    {
      int k = getScrollX();
      int m = getWidth();
      float f3 = this.GE / m;
      Object localObject = (b)this.dU.get(0);
      float f1 = ((b)localObject).Hs;
      int n = this.dU.size();
      int i = ((b)localObject).position;
      int i1 = ((b)this.dU.get(n - 1)).position;
      int j = 0;
      if (i < i1)
      {
        while ((i > ((b)localObject).position) && (j < n))
        {
          localObject = this.dU;
          j += 1;
          localObject = (b)((ArrayList)localObject).get(j);
        }
        float f2;
        if (i == ((b)localObject).position) {
          f2 = (((b)localObject).Hs + ((b)localObject).Hr) * m;
        }
        float f4;
        for (f1 = ((b)localObject).Hs + ((b)localObject).Hr + f3;; f1 += f4 + f3)
        {
          if (this.GE + f2 > k)
          {
            this.GF.setBounds(Math.round(f2), this.GG, Math.round(this.GE + f2), this.GH);
            this.GF.draw(paramCanvas);
          }
          if (f2 > k + m) {
            return;
          }
          i += 1;
          break;
          f4 = this.Gw.ax(i);
          f2 = (f1 + f4) * m;
        }
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    if ((i == 3) || (i == 1)) {
      jdMethod_do();
    }
    do
    {
      return false;
      if (i == 0) {
        break;
      }
      if (this.iZ) {
        return true;
      }
    } while (this.GP);
    switch (i)
    {
    }
    for (;;)
    {
      if (this.fB == null) {
        this.fB = VelocityTracker.obtain();
      }
      this.fB.addMovement(paramMotionEvent);
      return this.iZ;
      i = this.fC;
      if (i != -1)
      {
        i = paramMotionEvent.findPointerIndex(i);
        float f2 = paramMotionEvent.getX(i);
        float f1 = f2 - this.GS;
        float f4 = Math.abs(f1);
        float f3 = paramMotionEvent.getY(i);
        float f5 = Math.abs(f3 - this.FI);
        if (f1 != 0.0F)
        {
          float f6 = this.GS;
          if (((f6 < this.GR) && (f1 > 0.0F)) || ((f6 > getWidth() - this.GR) && (f1 < 0.0F))) {}
          for (i = 1; (i == 0) && (a(this, false, (int)f1, (int)f2, (int)f3)); i = 0)
          {
            this.GS = f2;
            this.GT = f3;
            this.GP = true;
            return false;
          }
        }
        if ((f4 > this.jb) && (0.5F * f4 > f5))
        {
          this.iZ = true;
          dp();
          setScrollState(1);
          if (f1 > 0.0F)
          {
            f1 = this.FH + this.jb;
            label328:
            this.GS = f1;
            this.GT = f3;
            setScrollingCacheEnabled(true);
          }
        }
        while ((this.iZ) && (r(f2)))
        {
          q.O(this);
          break;
          f1 = this.FH - this.jb;
          break label328;
          if (f5 > this.jb) {
            this.GP = true;
          }
        }
        f1 = paramMotionEvent.getX();
        this.FH = f1;
        this.GS = f1;
        f1 = paramMotionEvent.getY();
        this.FI = f1;
        this.GT = f1;
        this.fC = paramMotionEvent.getPointerId(0);
        this.GP = false;
        this.GC = true;
        this.GB.computeScrollOffset();
        if ((this.lf == 2) && (Math.abs(this.GB.getFinalX() - this.GB.getCurrX()) > this.GX))
        {
          this.GB.abortAnimation();
          this.GN = false;
          dm();
          this.iZ = true;
          dp();
          setScrollState(1);
        }
        else
        {
          G(false);
          this.iZ = false;
          continue;
          d(paramMotionEvent);
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = getChildCount();
    int i3 = paramInt3 - paramInt1;
    int i2 = paramInt4 - paramInt2;
    paramInt1 = getPaddingLeft();
    paramInt2 = getPaddingTop();
    paramInt3 = getPaddingRight();
    int j = getPaddingBottom();
    int i4 = getScrollX();
    int k = 0;
    int m = 0;
    View localView;
    LayoutParams localLayoutParams;
    int n;
    int i;
    if (m < i1)
    {
      localView = getChildAt(m);
      if (localView.getVisibility() == 8) {
        break label636;
      }
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if (!localLayoutParams.Ht) {
        break label636;
      }
      paramInt4 = localLayoutParams.gravity;
      n = localLayoutParams.gravity;
      switch (paramInt4 & 0x7)
      {
      case 2: 
      case 4: 
      default: 
        paramInt4 = paramInt1;
        i = paramInt3;
        paramInt3 = paramInt1;
        paramInt1 = i;
        label161:
        switch (n & 0x70)
        {
        default: 
          i = paramInt2;
          label203:
          paramInt4 += i4;
          localView.layout(paramInt4, i, localView.getMeasuredWidth() + paramInt4, localView.getMeasuredHeight() + i);
          paramInt4 = k + 1;
        }
        break;
      }
    }
    for (;;)
    {
      m += 1;
      i = paramInt1;
      paramInt1 = paramInt3;
      paramInt3 = i;
      k = paramInt4;
      break;
      i = paramInt1 + localView.getMeasuredWidth();
      paramInt4 = paramInt1;
      paramInt1 = paramInt3;
      paramInt3 = i;
      break label161;
      i = Math.max((i3 - localView.getMeasuredWidth()) / 2, paramInt1);
      paramInt4 = paramInt1;
      paramInt1 = paramInt3;
      paramInt3 = paramInt4;
      paramInt4 = i;
      break label161;
      paramInt4 = localView.getMeasuredWidth();
      i = localView.getMeasuredWidth();
      paramInt4 = i3 - paramInt3 - paramInt4;
      i = paramInt3 + i;
      paramInt3 = paramInt1;
      paramInt1 = i;
      break label161;
      n = paramInt2 + localView.getMeasuredHeight();
      i = paramInt2;
      paramInt2 = n;
      break label203;
      i = Math.max((i2 - localView.getMeasuredHeight()) / 2, paramInt2);
      break label203;
      i = i2 - j - localView.getMeasuredHeight();
      j += localView.getMeasuredHeight();
      break label203;
      paramInt4 = i3 - paramInt1 - paramInt3;
      paramInt3 = 0;
      while (paramInt3 < i1)
      {
        localView = getChildAt(paramInt3);
        if (localView.getVisibility() != 8)
        {
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          if (!localLayoutParams.Ht)
          {
            b localb = as(localView);
            if (localb != null)
            {
              float f = paramInt4;
              i = (int)(localb.Hs * f) + paramInt1;
              if (localLayoutParams.Hu)
              {
                localLayoutParams.Hu = false;
                f = paramInt4;
                localView.measure(View.MeasureSpec.makeMeasureSpec((int)(localLayoutParams.Hr * f), 1073741824), View.MeasureSpec.makeMeasureSpec(i2 - paramInt2 - j, 1073741824));
              }
              localView.layout(i, paramInt2, localView.getMeasuredWidth() + i, localView.getMeasuredHeight() + paramInt2);
            }
          }
        }
        paramInt3 += 1;
      }
      this.GG = paramInt2;
      this.GH = (i2 - j);
      this.He = k;
      if (this.Hb) {
        a(this.Gx, false, 0, false);
      }
      this.Hb = false;
      return;
      label636:
      paramInt4 = k;
      i = paramInt1;
      paramInt1 = paramInt3;
      paramInt3 = i;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(getDefaultSize(0, paramInt1), getDefaultSize(0, paramInt2));
    paramInt1 = getMeasuredWidth();
    this.GR = Math.min(paramInt1 / 10, this.GQ);
    paramInt1 = paramInt1 - getPaddingLeft() - getPaddingRight();
    paramInt2 = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
    int i4 = getChildCount();
    int k = 0;
    View localView;
    int i;
    int j;
    LayoutParams localLayoutParams;
    int m;
    int i1;
    label183:
    int n;
    if (k < i4)
    {
      localView = getChildAt(k);
      i = paramInt1;
      j = paramInt2;
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        i = paramInt1;
        j = paramInt2;
        if (localLayoutParams != null)
        {
          i = paramInt1;
          j = paramInt2;
          if (localLayoutParams.Ht)
          {
            i = localLayoutParams.gravity & 0x7;
            m = localLayoutParams.gravity & 0x70;
            i1 = -2147483648;
            j = -2147483648;
            if ((m != 48) && (m != 80)) {
              break label333;
            }
            m = 1;
            if ((i != 3) && (i != 5)) {
              break label339;
            }
            n = 1;
            label198:
            if (m == 0) {
              break label345;
            }
            i = 1073741824;
            label208:
            if (localLayoutParams.width == -2) {
              break label528;
            }
            i1 = 1073741824;
            if (localLayoutParams.width == -1) {
              break label522;
            }
            i = localLayoutParams.width;
          }
        }
      }
    }
    for (;;)
    {
      int i3;
      if (localLayoutParams.height != -2)
      {
        i2 = 1073741824;
        j = i2;
        if (localLayoutParams.height != -1)
        {
          i3 = localLayoutParams.height;
          j = i2;
        }
      }
      for (int i2 = i3;; i2 = paramInt2)
      {
        localView.measure(View.MeasureSpec.makeMeasureSpec(i, i1), View.MeasureSpec.makeMeasureSpec(i2, j));
        if (m != 0)
        {
          j = paramInt2 - localView.getMeasuredHeight();
          i = paramInt1;
        }
        for (;;)
        {
          k += 1;
          paramInt1 = i;
          paramInt2 = j;
          break;
          label333:
          m = 0;
          break label183;
          label339:
          n = 0;
          break label198;
          label345:
          i = i1;
          if (n == 0) {
            break label208;
          }
          j = 1073741824;
          i = i1;
          break label208;
          i = paramInt1;
          j = paramInt2;
          if (n != 0)
          {
            i = paramInt1 - localView.getMeasuredWidth();
            j = paramInt2;
          }
        }
        this.GK = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
        this.GL = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
        this.mInLayout = true;
        dm();
        this.mInLayout = false;
        i = getChildCount();
        paramInt2 = 0;
        while (paramInt2 < i)
        {
          localView = getChildAt(paramInt2);
          if (localView.getVisibility() != 8)
          {
            localLayoutParams = (LayoutParams)localView.getLayoutParams();
            if ((localLayoutParams == null) || (!localLayoutParams.Ht))
            {
              float f = paramInt1;
              localView.measure(View.MeasureSpec.makeMeasureSpec((int)(localLayoutParams.Hr * f), 1073741824), this.GL);
            }
          }
          paramInt2 += 1;
        }
        return;
      }
      label522:
      i = paramInt1;
      continue;
      label528:
      i1 = paramInt1;
      i2 = i;
      i = i1;
      i1 = i2;
    }
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    int j = getChildCount();
    int k;
    int i;
    if ((paramInt & 0x2) != 0)
    {
      k = 1;
      i = 0;
    }
    while (i != j)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 0)
      {
        b localb = as(localView);
        if ((localb != null) && (localb.position == this.Gx) && (localView.requestFocus(paramInt, paramRect)))
        {
          return true;
          i = j - 1;
          j = -1;
          k = -1;
          continue;
        }
      }
      i += k;
    }
    return false;
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof ViewPager.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (ViewPager.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.EA);
    if (this.Gw != null)
    {
      this.Gw.a(paramParcelable.Hw, paramParcelable.Hx);
      a(paramParcelable.position, false, true);
      return;
    }
    this.Gy = paramParcelable.position;
    this.Gz = paramParcelable.Hw;
    this.GA = paramParcelable.Hx;
  }
  
  public Parcelable onSaveInstanceState()
  {
    ViewPager.SavedState localSavedState = new ViewPager.SavedState(super.onSaveInstanceState());
    localSavedState.position = this.Gx;
    if (this.Gw != null) {
      localSavedState.Hw = this.Gw.cd();
    }
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3) {
      e(paramInt1, paramInt3, this.GE, this.GE);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    if (this.GY) {
      return true;
    }
    if ((paramMotionEvent.getAction() == 0) && (paramMotionEvent.getEdgeFlags() != 0)) {
      return false;
    }
    if ((this.Gw == null) || (this.Gw.getCount() == 0)) {
      return false;
    }
    if (this.fB == null) {
      this.fB = VelocityTracker.obtain();
    }
    this.fB.addMovement(paramMotionEvent);
    boolean bool1 = bool2;
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      bool1 = bool2;
    }
    for (;;)
    {
      if (bool1) {
        q.O(this);
      }
      return true;
      this.GB.abortAnimation();
      this.GN = false;
      dm();
      float f1 = paramMotionEvent.getX();
      this.FH = f1;
      this.GS = f1;
      f1 = paramMotionEvent.getY();
      this.FI = f1;
      this.GT = f1;
      this.fC = paramMotionEvent.getPointerId(0);
      bool1 = bool2;
      continue;
      int i;
      float f2;
      if (!this.iZ)
      {
        i = paramMotionEvent.findPointerIndex(this.fC);
        if (i == -1)
        {
          bool1 = jdMethod_do();
          continue;
        }
        f1 = paramMotionEvent.getX(i);
        float f3 = Math.abs(f1 - this.GS);
        f2 = paramMotionEvent.getY(i);
        float f4 = Math.abs(f2 - this.GT);
        if ((f3 > this.jb) && (f3 > f4))
        {
          this.iZ = true;
          dp();
          if (f1 - this.FH <= 0.0F) {
            break label392;
          }
        }
      }
      Object localObject;
      label392:
      for (f1 = this.FH + this.jb;; f1 = this.FH - this.jb)
      {
        this.GS = f1;
        this.GT = f2;
        setScrollState(1);
        setScrollingCacheEnabled(true);
        localObject = getParent();
        if (localObject != null) {
          ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
        }
        bool1 = bool2;
        if (!this.iZ) {
          break;
        }
        bool1 = r(paramMotionEvent.getX(paramMotionEvent.findPointerIndex(this.fC))) | false;
        break;
      }
      bool1 = bool2;
      if (this.iZ)
      {
        localObject = this.fB;
        ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.GV);
        int k = (int)((VelocityTracker)localObject).getXVelocity(this.fC);
        this.GN = true;
        int j = getClientWidth();
        int m = getScrollX();
        localObject = dq();
        f1 = this.GE / j;
        i = ((b)localObject).position;
        f2 = (m / j - ((b)localObject).Hs) / (((b)localObject).Hr + f1);
        if ((Math.abs((int)(paramMotionEvent.getX(paramMotionEvent.findPointerIndex(this.fC)) - this.FH)) > this.GW) && (Math.abs(k) > this.GU))
        {
          if (k > 0) {}
          for (;;)
          {
            j = i;
            if (this.dU.size() > 0)
            {
              paramMotionEvent = (b)this.dU.get(0);
              localObject = (b)this.dU.get(this.dU.size() - 1);
              j = Math.max(paramMotionEvent.position, Math.min(i, ((b)localObject).position));
            }
            a(j, true, true, k);
            bool1 = jdMethod_do();
            break;
            i += 1;
          }
        }
        if (i >= this.Gx) {}
        for (f1 = 0.4F;; f1 = 0.6F)
        {
          i += (int)(f1 + f2);
          break;
        }
        bool1 = bool2;
        if (this.iZ)
        {
          a(this.Gx, true, 0, false);
          bool1 = jdMethod_do();
          continue;
          i = paramMotionEvent.getActionIndex();
          this.GS = paramMotionEvent.getX(i);
          this.fC = paramMotionEvent.getPointerId(i);
          bool1 = bool2;
          continue;
          d(paramMotionEvent);
          this.GS = paramMotionEvent.getX(paramMotionEvent.findPointerIndex(this.fC));
          bool1 = bool2;
        }
      }
    }
  }
  
  public void removeView(View paramView)
  {
    if (this.mInLayout)
    {
      removeViewInLayout(paramView);
      return;
    }
    super.removeView(paramView);
  }
  
  public void setAdapter(n paramn)
  {
    int k = 0;
    int i;
    int j;
    if (this.Gw != null)
    {
      this.Gw.a(null);
      this.Gw.e(this);
      i = 0;
      while (i < this.dU.size())
      {
        localObject = (b)this.dU.get(i);
        this.Gw.a(this, ((b)localObject).position, ((b)localObject).object);
        i += 1;
      }
      this.Gw.cc();
      this.dU.clear();
      for (i = 0; i < getChildCount(); i = j + 1)
      {
        j = i;
        if (!((LayoutParams)getChildAt(i).getLayoutParams()).Ht)
        {
          removeViewAt(i);
          j = i - 1;
        }
      }
      this.Gx = 0;
      scrollTo(0, 0);
    }
    Object localObject = this.Gw;
    this.Gw = paramn;
    this.Gs = 0;
    boolean bool;
    if (this.Gw != null)
    {
      if (this.GD == null) {
        this.GD = new ViewPager.g(this);
      }
      this.Gw.a(this.GD);
      this.GN = false;
      bool = this.Hb;
      this.Hb = true;
      this.Gs = this.Gw.getCount();
      if (this.Gy < 0) {
        break label340;
      }
      this.Gw.a(this.Gz, this.GA);
      a(this.Gy, false, true);
      this.Gy = -1;
      this.Gz = null;
      this.GA = null;
    }
    while ((this.Hi != null) && (!this.Hi.isEmpty()))
    {
      j = this.Hi.size();
      i = k;
      while (i < j)
      {
        ((ViewPager.d)this.Hi.get(i)).a(this, (n)localObject, paramn);
        i += 1;
      }
      label340:
      if (!bool) {
        dm();
      } else {
        requestLayout();
      }
    }
  }
  
  public void setCurrentItem(int paramInt)
  {
    this.GN = false;
    if (!this.Hb) {}
    for (boolean bool = true;; bool = false)
    {
      a(paramInt, bool, false);
      return;
    }
  }
  
  public void setOffscreenPageLimit(int paramInt)
  {
    int i = paramInt;
    if (paramInt <= 0)
    {
      new StringBuilder("Requested offscreen page limit ").append(paramInt).append(" too small; defaulting to 1");
      i = 1;
    }
    if (i != this.GO)
    {
      this.GO = i;
      dm();
    }
  }
  
  @Deprecated
  public void setOnPageChangeListener(ViewPager.e parame)
  {
    this.Hg = parame;
  }
  
  public void setPageMargin(int paramInt)
  {
    int i = this.GE;
    this.GE = paramInt;
    int j = getWidth();
    e(j, j, paramInt, i);
    requestLayout();
  }
  
  public void setPageMarginDrawable(int paramInt)
  {
    setPageMarginDrawable(b.g(getContext(), paramInt));
  }
  
  public void setPageMarginDrawable(Drawable paramDrawable)
  {
    this.GF = paramDrawable;
    if (paramDrawable != null) {
      refreshDrawableState();
    }
    if (paramDrawable == null) {}
    for (boolean bool = true;; bool = false)
    {
      setWillNotDraw(bool);
      invalidate();
      return;
    }
  }
  
  void setScrollState(int paramInt)
  {
    int m = 0;
    if (this.lf == paramInt) {}
    label38:
    label77:
    label83:
    do
    {
      return;
      this.lf = paramInt;
      int i;
      int j;
      if (this.Hj != null)
      {
        if (paramInt != 0)
        {
          i = 1;
          int n = getChildCount();
          j = 0;
          if (j >= n) {
            break label83;
          }
          if (i == 0) {
            break label77;
          }
        }
        for (int k = this.Hk;; k = 0)
        {
          getChildAt(j).setLayerType(k, null);
          j += 1;
          break label38;
          i = 0;
          break;
        }
      }
      if (this.Hg != null) {
        this.Hg.Q(paramInt);
      }
      if (this.Hf != null)
      {
        j = this.Hf.size();
        i = m;
        while (i < j)
        {
          ViewPager.e locale = (ViewPager.e)this.Hf.get(i);
          if (locale != null) {
            locale.Q(paramInt);
          }
          i += 1;
        }
      }
    } while (this.Hh == null);
    this.Hh.Q(paramInt);
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.GF);
  }
  
  public static class LayoutParams
    extends ViewGroup.LayoutParams
  {
    float Hr = 0.0F;
    public boolean Ht;
    boolean Hu;
    int Hv;
    public int gravity;
    int position;
    
    public LayoutParams()
    {
      super(-1);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, ViewPager.Gr);
      this.gravity = paramContext.getInteger(0, 48);
      paramContext.recycle();
    }
  }
  
  @Inherited
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.TYPE})
  public static @interface a {}
  
  static final class b
  {
    boolean Hq;
    float Hr;
    float Hs;
    Object object;
    int position;
  }
  
  public static class h
    implements ViewPager.e
  {
    public void Q(int paramInt) {}
    
    public void R(int paramInt) {}
    
    public void a(int paramInt1, float paramFloat, int paramInt2) {}
  }
  
  static final class i
    implements Comparator<View>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.view.ViewPager
 * JD-Core Version:    0.7.0.1
 */