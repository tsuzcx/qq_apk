package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v4.view.d;
import android.support.v4.view.q;
import android.support.v7.a.a.j;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

public class LinearLayoutCompat
  extends ViewGroup
{
  private int An = 8388659;
  private boolean adK = true;
  private int adL = -1;
  private int adM = 0;
  private int adN;
  private int adO;
  private float adP;
  private boolean adQ;
  private int[] adR;
  private int[] adS;
  private Drawable adT;
  private int adU;
  private int adV;
  private int adW;
  private int adX;
  
  public LinearLayoutCompat(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LinearLayoutCompat(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = ax.a(paramContext, paramAttributeSet, a.j.LinearLayoutCompat, paramInt, 0);
    paramInt = paramContext.getInt(a.j.LinearLayoutCompat_android_orientation, -1);
    if (paramInt >= 0) {
      setOrientation(paramInt);
    }
    paramInt = paramContext.getInt(a.j.LinearLayoutCompat_android_gravity, -1);
    if (paramInt >= 0) {
      setGravity(paramInt);
    }
    boolean bool = paramContext.getBoolean(a.j.LinearLayoutCompat_android_baselineAligned, true);
    if (!bool) {
      setBaselineAligned(bool);
    }
    this.adP = paramContext.getFloat(a.j.LinearLayoutCompat_android_weightSum, -1.0F);
    this.adL = paramContext.getInt(a.j.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
    this.adQ = paramContext.getBoolean(a.j.LinearLayoutCompat_measureWithLargestChild, false);
    setDividerDrawable(paramContext.getDrawable(a.j.LinearLayoutCompat_divider));
    this.adW = paramContext.getInt(a.j.LinearLayoutCompat_showDividers, 0);
    this.adX = paramContext.getDimensionPixelSize(a.j.LinearLayoutCompat_dividerPadding, 0);
    paramContext.alZ.recycle();
  }
  
  private void V(int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
    int i = 0;
    while (i < paramInt1)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() != 8)
      {
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (localLayoutParams.width == -1)
        {
          int k = localLayoutParams.height;
          localLayoutParams.height = localView.getMeasuredHeight();
          measureChildWithMargins(localView, j, 0, paramInt2, 0);
          localLayoutParams.height = k;
        }
      }
      i += 1;
    }
  }
  
  private void W(int paramInt1, int paramInt2)
  {
    this.adO = 0;
    int m = 0;
    int j = 0;
    int i1 = 0;
    int i2 = 0;
    int k = 1;
    float f1 = 0.0F;
    int i10 = getVirtualChildCount();
    int i12 = View.MeasureSpec.getMode(paramInt1);
    int i11 = View.MeasureSpec.getMode(paramInt2);
    int n = 0;
    int i3 = 0;
    if ((this.adR == null) || (this.adS == null))
    {
      this.adR = new int[4];
      this.adS = new int[4];
    }
    Object localObject1 = this.adR;
    Object localObject2 = this.adS;
    localObject1[3] = -1;
    localObject1[2] = -1;
    localObject1[1] = -1;
    localObject1[0] = -1;
    localObject2[3] = -1;
    localObject2[2] = -1;
    localObject2[1] = -1;
    localObject2[0] = -1;
    boolean bool1 = this.adK;
    boolean bool2 = this.adQ;
    if (i12 == 1073741824) {}
    int i;
    int i4;
    Object localObject3;
    int i5;
    for (int i6 = 1;; i6 = 0)
    {
      i = 0;
      for (i4 = 0;; i4 = i5)
      {
        if (i4 >= i10) {
          break label865;
        }
        localObject3 = getChildAt(i4);
        if (localObject3 != null) {
          break;
        }
        this.adO += 0;
        i5 = i4;
        i4 = m;
        m = i2;
        i5 += 1;
        i2 = m;
        m = i4;
      }
    }
    LayoutParams localLayoutParams;
    label323:
    label344:
    int i7;
    label369:
    int i8;
    int i9;
    if (((View)localObject3).getVisibility() != 8)
    {
      if (bB(i4)) {
        this.adO += this.adU;
      }
      localLayoutParams = (LayoutParams)((View)localObject3).getLayoutParams();
      f1 += localLayoutParams.weight;
      if ((i12 == 1073741824) && (localLayoutParams.width == 0) && (localLayoutParams.weight > 0.0F)) {
        if (i6 != 0)
        {
          this.adO += localLayoutParams.leftMargin + localLayoutParams.rightMargin;
          if (!bool1) {
            break label622;
          }
          i5 = View.MeasureSpec.makeMeasureSpec(0, 0);
          ((View)localObject3).measure(i5, i5);
          i7 = 0;
          if ((i11 == 1073741824) || (localLayoutParams.height != -1)) {
            break label2250;
          }
          i5 = 1;
          n = 1;
          i7 = localLayoutParams.topMargin + localLayoutParams.bottomMargin;
          i8 = ((View)localObject3).getMeasuredHeight() + i7;
          j = View.combineMeasuredStates(j, ((View)localObject3).getMeasuredState());
          if (bool1)
          {
            int i13 = ((View)localObject3).getBaseline();
            if (i13 != -1)
            {
              if (localLayoutParams.gravity >= 0) {
                break label802;
              }
              i9 = this.An;
              label436:
              i9 = ((i9 & 0x70) >> 4 & 0xFFFFFFFE) >> 1;
              localObject1[i9] = Math.max(localObject1[i9], i13);
              localObject2[i9] = Math.max(localObject2[i9], i8 - i13);
            }
          }
          i9 = Math.max(m, i8);
          if ((k == 0) || (localLayoutParams.height != -1)) {
            break label812;
          }
          m = 1;
          label509:
          if (localLayoutParams.weight <= 0.0F) {
            break label825;
          }
          if (n == 0) {
            break label818;
          }
          label524:
          k = Math.max(i2, i7);
          n = i3;
          i2 = i9;
          i3 = m;
        }
      }
    }
    for (;;)
    {
      i8 = i4 + 0;
      m = n;
      n = i5;
      i4 = i3;
      i7 = k;
      i5 = i8;
      i3 = m;
      k = i4;
      m = i7;
      i4 = i2;
      break;
      i5 = this.adO;
      this.adO = Math.max(i5, localLayoutParams.leftMargin + i5 + localLayoutParams.rightMargin);
      break label323;
      label622:
      i3 = 1;
      break label344;
      i7 = -2147483648;
      i5 = i7;
      if (localLayoutParams.width == 0)
      {
        i5 = i7;
        if (localLayoutParams.weight > 0.0F)
        {
          i5 = 0;
          localLayoutParams.width = -2;
        }
      }
      if (f1 == 0.0F)
      {
        i7 = this.adO;
        label680:
        f((View)localObject3, paramInt1, i7, paramInt2, 0);
        if (i5 != -2147483648) {
          localLayoutParams.width = i5;
        }
        i5 = ((View)localObject3).getMeasuredWidth();
        if (i6 == 0) {
          break label765;
        }
        this.adO += localLayoutParams.leftMargin + i5 + localLayoutParams.rightMargin + 0;
      }
      for (;;)
      {
        if (bool2)
        {
          i = Math.max(i5, i);
          break;
          i7 = 0;
          break label680;
          label765:
          i7 = this.adO;
          this.adO = Math.max(i7, i7 + i5 + localLayoutParams.leftMargin + localLayoutParams.rightMargin + 0);
          continue;
          label802:
          i9 = localLayoutParams.gravity;
          break label436;
          label812:
          m = 0;
          break label509;
          label818:
          i7 = i8;
          break label524;
          label825:
          if (n != 0) {}
          for (;;)
          {
            i1 = Math.max(i1, i7);
            n = i3;
            k = i2;
            i3 = m;
            i2 = i9;
            break;
            i7 = i8;
          }
          label865:
          if ((this.adO > 0) && (bB(i10))) {
            this.adO += this.adU;
          }
          if ((localObject1[1] != -1) || (localObject1[0] != -1) || (localObject1[2] != -1) || (localObject1[3] != -1)) {}
          for (i4 = Math.max(m, Math.max(localObject1[3], Math.max(localObject1[0], Math.max(localObject1[1], localObject1[2]))) + Math.max(localObject2[3], Math.max(localObject2[0], Math.max(localObject2[1], localObject2[2]))));; i4 = m)
          {
            if ((bool2) && ((i12 == -2147483648) || (i12 == 0)))
            {
              this.adO = 0;
              m = 0;
              if (m < i10)
              {
                localObject3 = getChildAt(m);
                if (localObject3 == null) {
                  this.adO += 0;
                }
                for (;;)
                {
                  m += 1;
                  break;
                  if (((View)localObject3).getVisibility() == 8)
                  {
                    m += 0;
                  }
                  else
                  {
                    localObject3 = (LayoutParams)((View)localObject3).getLayoutParams();
                    if (i6 != 0)
                    {
                      i5 = this.adO;
                      i7 = ((LayoutParams)localObject3).leftMargin;
                      this.adO = (((LayoutParams)localObject3).rightMargin + (i7 + i) + 0 + i5);
                    }
                    else
                    {
                      i5 = this.adO;
                      i7 = ((LayoutParams)localObject3).leftMargin;
                      this.adO = Math.max(i5, ((LayoutParams)localObject3).rightMargin + (i5 + i + i7) + 0);
                    }
                  }
                }
              }
            }
            this.adO += getPaddingLeft() + getPaddingRight();
            i8 = View.resolveSizeAndState(Math.max(this.adO, getSuggestedMinimumWidth()), paramInt1, 0);
            i5 = (0xFFFFFF & i8) - this.adO;
            if ((i3 != 0) || ((i5 != 0) && (f1 > 0.0F)))
            {
              if (this.adP > 0.0F) {
                f1 = this.adP;
              }
              localObject1[3] = -1;
              localObject1[2] = -1;
              localObject1[1] = -1;
              localObject1[0] = -1;
              localObject2[3] = -1;
              localObject2[2] = -1;
              localObject2[1] = -1;
              localObject2[0] = -1;
              m = -1;
              this.adO = 0;
              i2 = 0;
              i3 = k;
              i = i1;
              k = m;
              m = j;
              j = i3;
              i1 = i5;
              if (i2 < i10)
              {
                localObject3 = getChildAt(i2);
                if ((localObject3 == null) || (((View)localObject3).getVisibility() == 8)) {
                  break label2224;
                }
                localLayoutParams = (LayoutParams)((View)localObject3).getLayoutParams();
                float f2 = localLayoutParams.weight;
                if (f2 <= 0.0F) {
                  break label2221;
                }
                i4 = (int)(i1 * f2 / f1);
                f1 -= f2;
                i3 = i1 - i4;
                i5 = getChildMeasureSpec(paramInt2, getPaddingTop() + getPaddingBottom() + localLayoutParams.topMargin + localLayoutParams.bottomMargin, localLayoutParams.height);
                if ((localLayoutParams.width != 0) || (i12 != 1073741824))
                {
                  i4 += ((View)localObject3).getMeasuredWidth();
                  i1 = i4;
                  if (i4 < 0) {
                    i1 = 0;
                  }
                  label1458:
                  ((View)localObject3).measure(View.MeasureSpec.makeMeasureSpec(i1, 1073741824), i5);
                  m = View.combineMeasuredStates(m, ((View)localObject3).getMeasuredState() & 0xFF000000);
                  i1 = i3;
                  label1492:
                  if (i6 == 0) {
                    break label1753;
                  }
                  this.adO += ((View)localObject3).getMeasuredWidth() + localLayoutParams.leftMargin + localLayoutParams.rightMargin + 0;
                  label1525:
                  if ((i11 == 1073741824) || (localLayoutParams.height != -1)) {
                    break label1793;
                  }
                  i3 = 1;
                  label1544:
                  i7 = localLayoutParams.topMargin + localLayoutParams.bottomMargin;
                  i5 = ((View)localObject3).getMeasuredHeight() + i7;
                  i4 = Math.max(k, i5);
                  if (i3 == 0) {
                    break label1799;
                  }
                  k = i7;
                  label1585:
                  i3 = Math.max(i, k);
                  if ((j == 0) || (localLayoutParams.height != -1)) {
                    break label1806;
                  }
                  i = 1;
                  label1611:
                  if (bool1)
                  {
                    k = ((View)localObject3).getBaseline();
                    if (k != -1)
                    {
                      if (localLayoutParams.gravity >= 0) {
                        break label1812;
                      }
                      j = this.An;
                      label1643:
                      j = ((j & 0x70) >> 4 & 0xFFFFFFFE) >> 1;
                      localObject1[j] = Math.max(localObject1[j], k);
                      localObject2[j] = Math.max(localObject2[j], i5 - k);
                    }
                  }
                  k = i;
                  j = i3;
                  i = i4;
                }
              }
            }
            for (;;)
            {
              i4 = i2 + 1;
              i2 = k;
              i3 = j;
              k = i;
              j = i2;
              i = i3;
              i2 = i4;
              break;
              if (i4 > 0)
              {
                i1 = i4;
                break label1458;
              }
              i1 = 0;
              break label1458;
              label1753:
              i3 = this.adO;
              this.adO = Math.max(i3, ((View)localObject3).getMeasuredWidth() + i3 + localLayoutParams.leftMargin + localLayoutParams.rightMargin + 0);
              break label1525;
              label1793:
              i3 = 0;
              break label1544;
              label1799:
              k = i5;
              break label1585;
              label1806:
              i = 0;
              break label1611;
              label1812:
              j = localLayoutParams.gravity;
              break label1643;
              this.adO += getPaddingLeft() + getPaddingRight();
              if ((localObject1[1] == -1) && (localObject1[0] == -1) && (localObject1[2] == -1))
              {
                i1 = k;
                if (localObject1[3] == -1) {}
              }
              else
              {
                i1 = Math.max(k, Math.max(localObject1[3], Math.max(localObject1[0], Math.max(localObject1[1], localObject1[2]))) + Math.max(localObject2[3], Math.max(localObject2[0], Math.max(localObject2[1], localObject2[2]))));
              }
              k = j;
              j = m;
              for (m = i1;; m = i4)
              {
                if ((k == 0) && (i11 != 1073741824)) {}
                for (;;)
                {
                  setMeasuredDimension(0xFF000000 & j | i8, View.resolveSizeAndState(Math.max(i + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), paramInt2, j << 16));
                  if (n != 0)
                  {
                    i = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
                    paramInt2 = 0;
                    while (paramInt2 < i10)
                    {
                      localObject1 = getChildAt(paramInt2);
                      if (((View)localObject1).getVisibility() != 8)
                      {
                        localObject2 = (LayoutParams)((View)localObject1).getLayoutParams();
                        if (((LayoutParams)localObject2).height == -1)
                        {
                          j = ((LayoutParams)localObject2).width;
                          ((LayoutParams)localObject2).width = ((View)localObject1).getMeasuredWidth();
                          measureChildWithMargins((View)localObject1, paramInt1, 0, i, 0);
                          ((LayoutParams)localObject2).width = j;
                        }
                      }
                      paramInt2 += 1;
                      continue;
                      i1 = Math.max(i1, i2);
                      if ((!bool2) || (i12 == 1073741824)) {
                        break label2210;
                      }
                      m = 0;
                      while (m < i10)
                      {
                        localObject1 = getChildAt(m);
                        if ((localObject1 != null) && (((View)localObject1).getVisibility() != 8) && (((LayoutParams)((View)localObject1).getLayoutParams()).weight > 0.0F)) {
                          ((View)localObject1).measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(((View)localObject1).getMeasuredHeight(), 1073741824));
                        }
                        m += 1;
                      }
                    }
                  }
                  return;
                  i = m;
                }
                label2210:
                i = i1;
              }
              label2221:
              break label1492;
              label2224:
              i3 = i;
              i = k;
              k = j;
              j = i3;
            }
          }
          label2250:
          i5 = n;
          n = i7;
          break label369;
        }
      }
      break label344;
      i7 = i3;
      i3 = k;
      k = i2;
      i5 = n;
      n = i7;
      i2 = m;
    }
  }
  
  private void b(Canvas paramCanvas, int paramInt)
  {
    this.adT.setBounds(getPaddingLeft() + this.adX, paramInt, getWidth() - getPaddingRight() - this.adX, this.adV + paramInt);
    this.adT.draw(paramCanvas);
  }
  
  private void c(Canvas paramCanvas, int paramInt)
  {
    this.adT.setBounds(paramInt, getPaddingTop() + this.adX, this.adU + paramInt, getHeight() - getPaddingBottom() - this.adX);
    this.adT.draw(paramCanvas);
  }
  
  private void f(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    measureChildWithMargins(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  private static void g(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramView.layout(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
  }
  
  private static int getChildrenSkipCount$5359dca7()
  {
    return 0;
  }
  
  private static int getLocationOffset$3c7ec8d0()
  {
    return 0;
  }
  
  private static int getNextLocationOffset$3c7ec8d0()
  {
    return 0;
  }
  
  protected final boolean bB(int paramInt)
  {
    if (paramInt == 0) {
      if ((this.adW & 0x1) == 0) {}
    }
    do
    {
      return true;
      return false;
      if (paramInt != getChildCount()) {
        break;
      }
    } while ((this.adW & 0x4) != 0);
    return false;
    if ((this.adW & 0x2) != 0)
    {
      paramInt -= 1;
      for (;;)
      {
        if (paramInt < 0) {
          break label75;
        }
        if (getChildAt(paramInt).getVisibility() != 8) {
          break;
        }
        paramInt -= 1;
      }
    }
    return false;
    label75:
    return false;
  }
  
  protected LayoutParams c(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new LayoutParams(paramLayoutParams);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public LayoutParams d(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected LayoutParams fN()
  {
    if (this.adN == 0) {
      return new LayoutParams(-2, -2);
    }
    if (this.adN == 1) {
      return new LayoutParams(-1, -2);
    }
    return null;
  }
  
  public int getBaseline()
  {
    int i = -1;
    if (this.adL < 0) {
      i = super.getBaseline();
    }
    View localView;
    int j;
    do
    {
      return i;
      if (getChildCount() <= this.adL) {
        throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
      }
      localView = getChildAt(this.adL);
      j = localView.getBaseline();
      if (j != -1) {
        break;
      }
    } while (this.adL == 0);
    throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
    i = this.adM;
    if (this.adN == 1)
    {
      int k = this.An & 0x70;
      if (k != 48) {
        switch (k)
        {
        }
      }
    }
    for (;;)
    {
      return ((LayoutParams)localView.getLayoutParams()).topMargin + i + j;
      i = getBottom() - getTop() - getPaddingBottom() - this.adO;
      continue;
      i += (getBottom() - getTop() - getPaddingTop() - getPaddingBottom() - this.adO) / 2;
    }
  }
  
  public int getBaselineAlignedChildIndex()
  {
    return this.adL;
  }
  
  public Drawable getDividerDrawable()
  {
    return this.adT;
  }
  
  public int getDividerPadding()
  {
    return this.adX;
  }
  
  public int getDividerWidth()
  {
    return this.adU;
  }
  
  public int getGravity()
  {
    return this.An;
  }
  
  public int getOrientation()
  {
    return this.adN;
  }
  
  public int getShowDividers()
  {
    return this.adW;
  }
  
  int getVirtualChildCount()
  {
    return getChildCount();
  }
  
  public float getWeightSum()
  {
    return this.adP;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.adT == null) {}
    int i;
    LayoutParams localLayoutParams;
    int k;
    boolean bool;
    label259:
    do
    {
      int j;
      do
      {
        return;
        if (this.adN != 1) {
          break;
        }
        j = getVirtualChildCount();
        i = 0;
        while (i < j)
        {
          localView = getChildAt(i);
          if ((localView != null) && (localView.getVisibility() != 8) && (bB(i)))
          {
            localLayoutParams = (LayoutParams)localView.getLayoutParams();
            b(paramCanvas, localView.getTop() - localLayoutParams.topMargin - this.adV);
          }
          i += 1;
        }
      } while (!bB(j));
      localView = getChildAt(j - 1);
      if (localView == null) {}
      for (i = getHeight() - getPaddingBottom() - this.adV;; i = localLayoutParams.bottomMargin + i)
      {
        b(paramCanvas, i);
        return;
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        i = localView.getBottom();
      }
      k = getVirtualChildCount();
      bool = bf.bF(this);
      i = 0;
      if (i < k)
      {
        localView = getChildAt(i);
        if ((localView != null) && (localView.getVisibility() != 8) && (bB(i)))
        {
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          if (!bool) {
            break label259;
          }
          j = localView.getRight();
        }
        for (j = localLayoutParams.rightMargin + j;; j = localView.getLeft() - localLayoutParams.leftMargin - this.adU)
        {
          c(paramCanvas, j);
          i += 1;
          break;
        }
      }
    } while (!bB(k));
    View localView = getChildAt(k - 1);
    if (localView == null) {
      if (bool) {
        i = getPaddingLeft();
      }
    }
    for (;;)
    {
      c(paramCanvas, i);
      return;
      i = getWidth() - getPaddingRight() - this.adU;
      continue;
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if (bool)
      {
        i = localView.getLeft() - localLayoutParams.leftMargin - this.adU;
      }
      else
      {
        i = localView.getRight();
        i = localLayoutParams.rightMargin + i;
      }
    }
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(LinearLayoutCompat.class.getName());
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(LinearLayoutCompat.class.getName());
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i;
    int j;
    int k;
    int m;
    int n;
    int i1;
    label93:
    Object localObject1;
    if (this.adN == 1)
    {
      i = getPaddingLeft();
      j = paramInt3 - paramInt1;
      k = getPaddingRight();
      m = getPaddingRight();
      n = getVirtualChildCount();
      paramInt1 = this.An;
      i1 = this.An;
      switch (paramInt1 & 0x70)
      {
      default: 
        paramInt1 = getPaddingTop();
        paramInt3 = 0;
        paramInt2 = paramInt1;
        paramInt1 = paramInt3;
        if (paramInt1 < n)
        {
          localObject1 = getChildAt(paramInt1);
          if (localObject1 == null) {
            paramInt2 += 0;
          }
        }
        break;
      }
    }
    for (;;)
    {
      paramInt1 += 1;
      break label93;
      paramInt1 = getPaddingTop() + paramInt4 - paramInt2 - this.adO;
      break;
      paramInt1 = getPaddingTop() + (paramInt4 - paramInt2 - this.adO) / 2;
      break;
      if (((View)localObject1).getVisibility() != 8)
      {
        int i2 = ((View)localObject1).getMeasuredWidth();
        int i3 = ((View)localObject1).getMeasuredHeight();
        Object localObject2 = (LayoutParams)((View)localObject1).getLayoutParams();
        paramInt4 = ((LayoutParams)localObject2).gravity;
        paramInt3 = paramInt4;
        if (paramInt4 < 0) {
          paramInt3 = 0x800007 & i1;
        }
        switch (d.getAbsoluteGravity(paramInt3, q.Q(this)) & 0x7)
        {
        default: 
          paramInt3 = ((LayoutParams)localObject2).leftMargin + i;
        }
        for (;;)
        {
          paramInt4 = paramInt2;
          if (bB(paramInt1)) {
            paramInt4 = paramInt2 + this.adV;
          }
          paramInt2 = paramInt4 + ((LayoutParams)localObject2).topMargin;
          g((View)localObject1, paramInt3, paramInt2 + 0, i2, i3);
          paramInt2 += ((LayoutParams)localObject2).bottomMargin + i3 + 0;
          paramInt1 += 0;
          break;
          paramInt3 = (j - i - m - i2) / 2 + i + ((LayoutParams)localObject2).leftMargin - ((LayoutParams)localObject2).rightMargin;
          continue;
          paramInt3 = j - k - i2 - ((LayoutParams)localObject2).rightMargin;
        }
        paramBoolean = bf.bF(this);
        k = getPaddingTop();
        n = paramInt4 - paramInt2;
        i1 = getPaddingBottom();
        i2 = getPaddingBottom();
        i3 = getVirtualChildCount();
        paramInt2 = this.An;
        int i4 = this.An;
        boolean bool = this.adK;
        localObject1 = this.adR;
        localObject2 = this.adS;
        switch (d.getAbsoluteGravity(paramInt2 & 0x800007, q.Q(this)))
        {
        default: 
          paramInt1 = getPaddingLeft();
          i = 0;
          if (paramBoolean) {
            i = i3 - 1;
          }
          break;
        }
        for (paramInt4 = -1;; paramInt4 = 1)
        {
          paramInt2 = 0;
          paramInt3 = paramInt1;
          label510:
          int i7;
          View localView;
          if (paramInt2 < i3)
          {
            i7 = i + paramInt4 * paramInt2;
            localView = getChildAt(i7);
            if (localView == null)
            {
              paramInt3 += 0;
              paramInt1 = paramInt2;
            }
          }
          for (;;)
          {
            paramInt2 = paramInt1 + 1;
            break label510;
            paramInt1 = getPaddingLeft() + paramInt3 - paramInt1 - this.adO;
            break;
            paramInt1 = getPaddingLeft() + (paramInt3 - paramInt1 - this.adO) / 2;
            break;
            if (localView.getVisibility() != 8)
            {
              int i5 = localView.getMeasuredWidth();
              int i6 = localView.getMeasuredHeight();
              paramInt1 = -1;
              LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
              j = paramInt1;
              if (bool)
              {
                j = paramInt1;
                if (localLayoutParams.height != -1) {
                  j = localView.getBaseline();
                }
              }
              m = localLayoutParams.gravity;
              paramInt1 = m;
              if (m < 0) {
                paramInt1 = i4 & 0x70;
              }
              switch (paramInt1 & 0x70)
              {
              default: 
                paramInt1 = k;
              }
              label715:
              label895:
              for (;;)
              {
                if (bB(i7)) {
                  paramInt3 = this.adU + paramInt3;
                }
                for (;;)
                {
                  paramInt3 += localLayoutParams.leftMargin;
                  g(localView, paramInt3 + 0, paramInt1, i5, i6);
                  paramInt3 += localLayoutParams.rightMargin + i5 + 0;
                  paramInt1 = paramInt2 + 0;
                  break;
                  m = localLayoutParams.topMargin + k;
                  paramInt1 = m;
                  if (j == -1) {
                    break label895;
                  }
                  paramInt1 = localObject1[1] - j + m;
                  break label715;
                  paramInt1 = (n - k - i2 - i6) / 2 + k + localLayoutParams.topMargin - localLayoutParams.bottomMargin;
                  break label715;
                  m = n - i1 - i6 - localLayoutParams.bottomMargin;
                  paramInt1 = m;
                  if (j == -1) {
                    break label895;
                  }
                  paramInt1 = localView.getMeasuredHeight();
                  paramInt1 = m - (localObject2[2] - (paramInt1 - j));
                  break label715;
                  return;
                }
              }
            }
            paramInt1 = paramInt2;
          }
        }
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j;
    int i;
    int i1;
    int i2;
    int k;
    float f1;
    int i9;
    int i10;
    int i11;
    int n;
    int i3;
    boolean bool;
    int m;
    int i4;
    Object localObject;
    int i5;
    LayoutParams localLayoutParams;
    label242:
    int i6;
    label458:
    int i7;
    int i8;
    if (this.adN == 1)
    {
      this.adO = 0;
      j = 0;
      i = 0;
      i1 = 0;
      i2 = 0;
      k = 1;
      f1 = 0.0F;
      i9 = getVirtualChildCount();
      i10 = View.MeasureSpec.getMode(paramInt1);
      i11 = View.MeasureSpec.getMode(paramInt2);
      n = 0;
      i3 = 0;
      int i12 = this.adL;
      bool = this.adQ;
      m = 0;
      i4 = 0;
      for (;;)
      {
        if (i4 < i9)
        {
          localObject = getChildAt(i4);
          if (localObject == null)
          {
            this.adO += 0;
            i5 = i4;
            i4 = j;
            j = i2;
            i5 += 1;
            i2 = j;
            j = i4;
            i4 = i5;
          }
          else
          {
            if (((View)localObject).getVisibility() == 8) {
              break label1618;
            }
            if (bB(i4)) {
              this.adO += this.adV;
            }
            localLayoutParams = (LayoutParams)((View)localObject).getLayoutParams();
            f1 += localLayoutParams.weight;
            if ((i11 == 1073741824) && (localLayoutParams.height == 0) && (localLayoutParams.weight > 0.0F))
            {
              i3 = this.adO;
              this.adO = Math.max(i3, localLayoutParams.topMargin + i3 + localLayoutParams.bottomMargin);
              i3 = 1;
              if ((i12 >= 0) && (i12 == i4 + 1)) {
                this.adM = this.adO;
              }
              if ((i4 < i12) && (localLayoutParams.weight > 0.0F)) {
                throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
              }
            }
            else
            {
              i6 = -2147483648;
              i5 = i6;
              if (localLayoutParams.height == 0)
              {
                i5 = i6;
                if (localLayoutParams.weight > 0.0F)
                {
                  i5 = 0;
                  localLayoutParams.height = -2;
                }
              }
              if (f1 == 0.0F) {}
              for (i6 = this.adO;; i6 = 0)
              {
                f((View)localObject, paramInt1, 0, paramInt2, i6);
                if (i5 != -2147483648) {
                  localLayoutParams.height = i5;
                }
                i5 = ((View)localObject).getMeasuredHeight();
                i6 = this.adO;
                this.adO = Math.max(i6, i6 + i5 + localLayoutParams.topMargin + localLayoutParams.bottomMargin + 0);
                if (!bool) {
                  break label1615;
                }
                m = Math.max(i5, m);
                break;
              }
            }
            i6 = 0;
            if ((i10 == 1073741824) || (localLayoutParams.width != -1)) {
              break label1604;
            }
            i5 = 1;
            n = 1;
            i6 = localLayoutParams.leftMargin + localLayoutParams.rightMargin;
            i7 = ((View)localObject).getMeasuredWidth() + i6;
            i8 = Math.max(j, i7);
            i = View.combineMeasuredStates(i, ((View)localObject).getMeasuredState());
            if ((k != 0) && (localLayoutParams.width == -1))
            {
              j = 1;
              label519:
              if (localLayoutParams.weight <= 0.0F) {
                break label625;
              }
              if (n == 0) {
                break label618;
              }
              label534:
              i6 = Math.max(i2, i6);
              k = m;
              n = i3;
              i2 = i8;
              m = i6;
              i3 = j;
            }
          }
        }
      }
    }
    for (;;)
    {
      i7 = i4 + 0;
      j = n;
      n = i5;
      i4 = i3;
      i6 = m;
      i5 = i7;
      m = k;
      i3 = j;
      k = i4;
      j = i6;
      i4 = i2;
      break;
      j = 0;
      break label519;
      label618:
      i6 = i7;
      break label534;
      label625:
      if (n != 0) {}
      for (;;)
      {
        i1 = Math.max(i1, i6);
        k = m;
        n = i3;
        m = i2;
        i3 = j;
        i2 = i8;
        break;
        i6 = i7;
      }
      if ((this.adO > 0) && (bB(i9))) {
        this.adO += this.adV;
      }
      if ((bool) && ((i11 == -2147483648) || (i11 == 0)))
      {
        this.adO = 0;
        i4 = 0;
        if (i4 < i9)
        {
          localObject = getChildAt(i4);
          if (localObject == null) {
            this.adO += 0;
          }
          for (;;)
          {
            i4 += 1;
            break;
            if (((View)localObject).getVisibility() == 8)
            {
              i4 += 0;
            }
            else
            {
              localObject = (LayoutParams)((View)localObject).getLayoutParams();
              i5 = this.adO;
              i6 = ((LayoutParams)localObject).topMargin;
              this.adO = Math.max(i5, ((LayoutParams)localObject).bottomMargin + (i5 + m + i6) + 0);
            }
          }
        }
      }
      this.adO += getPaddingTop() + getPaddingBottom();
      i6 = View.resolveSizeAndState(Math.max(this.adO, getSuggestedMinimumHeight()), paramInt2, 0);
      i4 = (0xFFFFFF & i6) - this.adO;
      if ((i3 != 0) || ((i4 != 0) && (f1 > 0.0F)))
      {
        if (this.adP > 0.0F) {
          f1 = this.adP;
        }
        this.adO = 0;
        i3 = 0;
        m = k;
        i2 = i1;
        i1 = i;
        k = j;
        i = i2;
        j = m;
        m = i1;
        i2 = i4;
        if (i3 < i9)
        {
          localObject = getChildAt(i3);
          if (((View)localObject).getVisibility() == 8) {
            break label1581;
          }
          localLayoutParams = (LayoutParams)((View)localObject).getLayoutParams();
          float f2 = localLayoutParams.weight;
          if (f2 <= 0.0F) {
            break label1574;
          }
          i4 = (int)(i2 * f2 / f1);
          i7 = getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + localLayoutParams.leftMargin + localLayoutParams.rightMargin, localLayoutParams.width);
          if ((localLayoutParams.height != 0) || (i11 != 1073741824))
          {
            i5 = i4 + ((View)localObject).getMeasuredHeight();
            i1 = i5;
            if (i5 < 0) {
              i1 = 0;
            }
            label1079:
            ((View)localObject).measure(i7, View.MeasureSpec.makeMeasureSpec(i1, 1073741824));
            m = View.combineMeasuredStates(m, ((View)localObject).getMeasuredState() & 0xFFFFFF00);
            f1 -= f2;
            i1 = i2 - i4;
            label1121:
            i4 = localLayoutParams.leftMargin + localLayoutParams.rightMargin;
            i5 = ((View)localObject).getMeasuredWidth() + i4;
            i2 = Math.max(k, i5);
            if ((i10 == 1073741824) || (localLayoutParams.width != -1)) {
              break label1319;
            }
            k = 1;
            label1172:
            if (k == 0) {
              break label1325;
            }
            k = i4;
            label1181:
            i4 = Math.max(i, k);
            if ((j == 0) || (localLayoutParams.width != -1)) {
              break label1332;
            }
            i = 1;
            label1207:
            j = this.adO;
            k = ((View)localObject).getMeasuredHeight();
            i5 = localLayoutParams.topMargin;
            this.adO = Math.max(j, localLayoutParams.bottomMargin + (k + j + i5) + 0);
            k = i;
            j = i4;
          }
        }
      }
      for (i = i2;; i = i4)
      {
        i5 = i3 + 1;
        i3 = j;
        i4 = i;
        i2 = i1;
        j = k;
        i = i3;
        k = i4;
        i3 = i5;
        break;
        if (i4 > 0)
        {
          i1 = i4;
          break label1079;
        }
        i1 = 0;
        break label1079;
        label1319:
        k = 0;
        break label1172;
        label1325:
        k = i5;
        break label1181;
        label1332:
        i = 0;
        break label1207;
        this.adO += getPaddingTop() + getPaddingBottom();
        i1 = m;
        m = k;
        k = i1;
        i1 = j;
        j = i;
        for (;;)
        {
          if ((i1 == 0) && (i10 != 1073741824)) {}
          for (;;)
          {
            setMeasuredDimension(View.resolveSizeAndState(Math.max(j + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), paramInt1, k), i6);
            if (n != 0) {
              V(i9, paramInt2);
            }
            return;
            i2 = Math.max(i1, i2);
            if ((!bool) || (i11 == 1073741824)) {
              break;
            }
            i1 = 0;
            while (i1 < i9)
            {
              localObject = getChildAt(i1);
              if ((localObject != null) && (((View)localObject).getVisibility() != 8) && (((LayoutParams)((View)localObject).getLayoutParams()).weight > 0.0F)) {
                ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(((View)localObject).getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(m, 1073741824));
              }
              i1 += 1;
            }
            W(paramInt1, paramInt2);
            return;
            j = m;
          }
          m = i2;
          i1 = j;
          j = m;
          m = i1;
          i1 = k;
          k = i;
        }
        label1574:
        i1 = i2;
        break label1121;
        label1581:
        i4 = k;
        k = j;
        i1 = i2;
        j = i;
      }
      label1604:
      i5 = n;
      n = i6;
      break label458;
      label1615:
      break label242;
      label1618:
      i5 = m;
      m = i3;
      i3 = k;
      k = i5;
      i5 = n;
      n = m;
      m = i2;
      i2 = j;
    }
  }
  
  public void setBaselineAligned(boolean paramBoolean)
  {
    this.adK = paramBoolean;
  }
  
  public void setBaselineAlignedChildIndex(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= getChildCount())) {
      throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }
    this.adL = paramInt;
  }
  
  public void setDividerDrawable(Drawable paramDrawable)
  {
    boolean bool = false;
    if (paramDrawable == this.adT) {
      return;
    }
    this.adT = paramDrawable;
    if (paramDrawable != null) {
      this.adU = paramDrawable.getIntrinsicWidth();
    }
    for (this.adV = paramDrawable.getIntrinsicHeight();; this.adV = 0)
    {
      if (paramDrawable == null) {
        bool = true;
      }
      setWillNotDraw(bool);
      requestLayout();
      return;
      this.adU = 0;
    }
  }
  
  public void setDividerPadding(int paramInt)
  {
    this.adX = paramInt;
  }
  
  public void setGravity(int paramInt)
  {
    if (this.An != paramInt)
    {
      if ((0x800007 & paramInt) != 0) {
        break label46;
      }
      paramInt = 0x800003 | paramInt;
    }
    label46:
    for (;;)
    {
      int i = paramInt;
      if ((paramInt & 0x70) == 0) {
        i = paramInt | 0x30;
      }
      this.An = i;
      requestLayout();
      return;
    }
  }
  
  public void setHorizontalGravity(int paramInt)
  {
    paramInt &= 0x800007;
    if ((this.An & 0x800007) != paramInt)
    {
      this.An = (paramInt | this.An & 0xFF7FFFF8);
      requestLayout();
    }
  }
  
  public void setMeasureWithLargestChildEnabled(boolean paramBoolean)
  {
    this.adQ = paramBoolean;
  }
  
  public void setOrientation(int paramInt)
  {
    if (this.adN != paramInt)
    {
      this.adN = paramInt;
      requestLayout();
    }
  }
  
  public void setShowDividers(int paramInt)
  {
    if (paramInt != this.adW) {
      requestLayout();
    }
    this.adW = paramInt;
  }
  
  public void setVerticalGravity(int paramInt)
  {
    paramInt &= 0x70;
    if ((this.An & 0x70) != paramInt)
    {
      this.An = (paramInt | this.An & 0xFFFFFF8F);
      requestLayout();
    }
  }
  
  public void setWeightSum(float paramFloat)
  {
    this.adP = Math.max(0.0F, paramFloat);
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    public int gravity = -1;
    public float weight;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
      this.weight = 0.0F;
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.j.LinearLayoutCompat_Layout);
      this.weight = paramContext.getFloat(a.j.LinearLayoutCompat_Layout_android_layout_weight, 0.0F);
      this.gravity = paramContext.getInt(a.j.LinearLayoutCompat_Layout_android_layout_gravity, -1);
      paramContext.recycle();
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.LinearLayoutCompat
 * JD-Core Version:    0.7.0.1
 */