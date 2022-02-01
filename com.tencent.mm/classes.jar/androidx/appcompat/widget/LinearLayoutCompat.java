package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.appcompat.a.j;
import androidx.core.g.e;
import androidx.core.g.z;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class LinearLayoutCompat
  extends ViewGroup
{
  private int mOrientation;
  private boolean tG;
  private int tH;
  private int tI;
  private int tJ;
  private int tK;
  private float tL;
  private boolean tM;
  private int[] tN;
  private int[] tO;
  private Drawable tP;
  private int tQ;
  private int tR;
  private int tS;
  private int tT;
  
  public LinearLayoutCompat(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public LinearLayoutCompat(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LinearLayoutCompat(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(200246);
    this.tG = true;
    this.tH = -1;
    this.tI = 0;
    this.tJ = 8388659;
    paramContext = ac.a(paramContext, paramAttributeSet, a.j.LinearLayoutCompat, paramInt, 0);
    paramInt = paramContext.getInt(a.j.LinearLayoutCompat_android_orientation, -1);
    if (paramInt >= 0) {
      setOrientation(paramInt);
    }
    paramInt = paramContext.getInt(a.j.LinearLayoutCompat_android_gravity, -1);
    if (paramInt >= 0) {
      setGravity(paramInt);
    }
    boolean bool = paramContext.m(a.j.LinearLayoutCompat_android_baselineAligned, true);
    if (!bool) {
      setBaselineAligned(bool);
    }
    this.tL = paramContext.d(a.j.LinearLayoutCompat_android_weightSum, -1.0F);
    this.tH = paramContext.getInt(a.j.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
    this.tM = paramContext.m(a.j.LinearLayoutCompat_measureWithLargestChild, false);
    setDividerDrawable(paramContext.getDrawable(a.j.LinearLayoutCompat_divider));
    this.tS = paramContext.getInt(a.j.LinearLayoutCompat_showDividers, 0);
    this.tT = paramContext.u(a.j.LinearLayoutCompat_dividerPadding, 0);
    paramContext.xv.recycle();
    AppMethodBeat.o(200246);
  }
  
  private void b(Canvas paramCanvas, int paramInt)
  {
    AppMethodBeat.i(200259);
    this.tP.setBounds(getPaddingLeft() + this.tT, paramInt, getWidth() - getPaddingRight() - this.tT, this.tR + paramInt);
    this.tP.draw(paramCanvas);
    AppMethodBeat.o(200259);
  }
  
  private void b(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(200310);
    measureChildWithMargins(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(200310);
  }
  
  private void c(Canvas paramCanvas, int paramInt)
  {
    AppMethodBeat.i(200271);
    this.tP.setBounds(paramInt, getPaddingTop() + this.tT, this.tQ + paramInt, getHeight() - getPaddingBottom() - this.tT);
    this.tP.draw(paramCanvas);
    AppMethodBeat.o(200271);
  }
  
  private static void c(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(200316);
    paramView.layout(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
    AppMethodBeat.o(200316);
  }
  
  private void n(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(200281);
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
    AppMethodBeat.o(200281);
  }
  
  private void o(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(200306);
    this.tK = 0;
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
    if ((this.tN == null) || (this.tO == null))
    {
      this.tN = new int[4];
      this.tO = new int[4];
    }
    Object localObject1 = this.tN;
    Object localObject2 = this.tO;
    localObject1[3] = -1;
    localObject1[2] = -1;
    localObject1[1] = -1;
    localObject1[0] = -1;
    localObject2[3] = -1;
    localObject2[2] = -1;
    localObject2[1] = -1;
    localObject2[0] = -1;
    boolean bool1 = this.tG;
    boolean bool2 = this.tM;
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
          break label872;
        }
        localObject3 = getChildAt(i4);
        if (localObject3 != null) {
          break;
        }
        this.tK += 0;
        i5 = i4;
        i4 = m;
        m = i2;
        i5 += 1;
        i2 = m;
        m = i4;
      }
    }
    LayoutParams localLayoutParams;
    label328:
    label349:
    int i7;
    label374:
    int i8;
    int i9;
    if (((View)localObject3).getVisibility() != 8)
    {
      if (au(i4)) {
        this.tK += this.tQ;
      }
      localLayoutParams = (LayoutParams)((View)localObject3).getLayoutParams();
      f1 += localLayoutParams.qL;
      if ((i12 == 1073741824) && (localLayoutParams.width == 0) && (localLayoutParams.qL > 0.0F)) {
        if (i6 != 0)
        {
          this.tK += localLayoutParams.leftMargin + localLayoutParams.rightMargin;
          if (!bool1) {
            break label627;
          }
          i5 = View.MeasureSpec.makeMeasureSpec(0, 0);
          ((View)localObject3).measure(i5, i5);
          i7 = 0;
          if ((i11 == 1073741824) || (localLayoutParams.height != -1)) {
            break label2264;
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
              if (localLayoutParams.fl >= 0) {
                break label809;
              }
              i9 = this.tJ;
              label441:
              i9 = ((i9 & 0x70) >> 4 & 0xFFFFFFFE) >> 1;
              localObject1[i9] = Math.max(localObject1[i9], i13);
              localObject2[i9] = Math.max(localObject2[i9], i8 - i13);
            }
          }
          i9 = Math.max(m, i8);
          if ((k == 0) || (localLayoutParams.height != -1)) {
            break label819;
          }
          m = 1;
          label514:
          if (localLayoutParams.qL <= 0.0F) {
            break label832;
          }
          if (n == 0) {
            break label825;
          }
          label529:
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
      i5 = this.tK;
      this.tK = Math.max(i5, localLayoutParams.leftMargin + i5 + localLayoutParams.rightMargin);
      break label328;
      label627:
      i3 = 1;
      break label349;
      i7 = -2147483648;
      i5 = i7;
      if (localLayoutParams.width == 0)
      {
        i5 = i7;
        if (localLayoutParams.qL > 0.0F)
        {
          i5 = 0;
          localLayoutParams.width = -2;
        }
      }
      if (f1 == 0.0F)
      {
        i7 = this.tK;
        label686:
        b((View)localObject3, paramInt1, i7, paramInt2, 0);
        if (i5 != -2147483648) {
          localLayoutParams.width = i5;
        }
        i5 = ((View)localObject3).getMeasuredWidth();
        if (i6 == 0) {
          break label772;
        }
        this.tK += localLayoutParams.leftMargin + i5 + localLayoutParams.rightMargin + 0;
      }
      for (;;)
      {
        if (bool2)
        {
          i = Math.max(i5, i);
          break;
          i7 = 0;
          break label686;
          label772:
          i7 = this.tK;
          this.tK = Math.max(i7, i7 + i5 + localLayoutParams.leftMargin + localLayoutParams.rightMargin + 0);
          continue;
          label809:
          i9 = localLayoutParams.fl;
          break label441;
          label819:
          m = 0;
          break label514;
          label825:
          i7 = i8;
          break label529;
          label832:
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
          label872:
          if ((this.tK > 0) && (au(i10))) {
            this.tK += this.tQ;
          }
          if ((localObject1[1] != -1) || (localObject1[0] != -1) || (localObject1[2] != -1) || (localObject1[3] != -1)) {}
          for (i4 = Math.max(m, Math.max(localObject1[3], Math.max(localObject1[0], Math.max(localObject1[1], localObject1[2]))) + Math.max(localObject2[3], Math.max(localObject2[0], Math.max(localObject2[1], localObject2[2]))));; i4 = m)
          {
            if ((bool2) && ((i12 == -2147483648) || (i12 == 0)))
            {
              this.tK = 0;
              m = 0;
              if (m < i10)
              {
                localObject3 = getChildAt(m);
                if (localObject3 == null) {
                  this.tK += 0;
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
                      i5 = this.tK;
                      i7 = ((LayoutParams)localObject3).leftMargin;
                      this.tK = (((LayoutParams)localObject3).rightMargin + (i7 + i) + 0 + i5);
                    }
                    else
                    {
                      i5 = this.tK;
                      i7 = ((LayoutParams)localObject3).leftMargin;
                      this.tK = Math.max(i5, ((LayoutParams)localObject3).rightMargin + (i5 + i + i7) + 0);
                    }
                  }
                }
              }
            }
            this.tK += getPaddingLeft() + getPaddingRight();
            i8 = View.resolveSizeAndState(Math.max(this.tK, getSuggestedMinimumWidth()), paramInt1, 0);
            i5 = (0xFFFFFF & i8) - this.tK;
            if ((i3 != 0) || ((i5 != 0) && (f1 > 0.0F)))
            {
              if (this.tL > 0.0F) {
                f1 = this.tL;
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
              this.tK = 0;
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
                  break label2238;
                }
                localLayoutParams = (LayoutParams)((View)localObject3).getLayoutParams();
                float f2 = localLayoutParams.qL;
                if (f2 <= 0.0F) {
                  break label2235;
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
                  label1467:
                  ((View)localObject3).measure(View.MeasureSpec.makeMeasureSpec(i1, 1073741824), i5);
                  m = View.combineMeasuredStates(m, ((View)localObject3).getMeasuredState() & 0xFF000000);
                  i1 = i3;
                  label1501:
                  if (i6 == 0) {
                    break label1762;
                  }
                  this.tK += ((View)localObject3).getMeasuredWidth() + localLayoutParams.leftMargin + localLayoutParams.rightMargin + 0;
                  label1534:
                  if ((i11 == 1073741824) || (localLayoutParams.height != -1)) {
                    break label1802;
                  }
                  i3 = 1;
                  label1553:
                  i7 = localLayoutParams.topMargin + localLayoutParams.bottomMargin;
                  i5 = ((View)localObject3).getMeasuredHeight() + i7;
                  i4 = Math.max(k, i5);
                  if (i3 == 0) {
                    break label1808;
                  }
                  k = i7;
                  label1594:
                  i3 = Math.max(i, k);
                  if ((j == 0) || (localLayoutParams.height != -1)) {
                    break label1815;
                  }
                  i = 1;
                  label1620:
                  if (bool1)
                  {
                    k = ((View)localObject3).getBaseline();
                    if (k != -1)
                    {
                      if (localLayoutParams.fl >= 0) {
                        break label1821;
                      }
                      j = this.tJ;
                      label1652:
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
                break label1467;
              }
              i1 = 0;
              break label1467;
              label1762:
              i3 = this.tK;
              this.tK = Math.max(i3, ((View)localObject3).getMeasuredWidth() + i3 + localLayoutParams.leftMargin + localLayoutParams.rightMargin + 0);
              break label1534;
              label1802:
              i3 = 0;
              break label1553;
              label1808:
              k = i5;
              break label1594;
              label1815:
              i = 0;
              break label1620;
              label1821:
              j = localLayoutParams.fl;
              break label1652;
              this.tK += getPaddingLeft() + getPaddingRight();
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
                        break label2224;
                      }
                      m = 0;
                      while (m < i10)
                      {
                        localObject1 = getChildAt(m);
                        if ((localObject1 != null) && (((View)localObject1).getVisibility() != 8) && (((LayoutParams)((View)localObject1).getLayoutParams()).qL > 0.0F)) {
                          ((View)localObject1).measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(((View)localObject1).getMeasuredHeight(), 1073741824));
                        }
                        m += 1;
                      }
                    }
                  }
                  AppMethodBeat.o(200306);
                  return;
                  i = m;
                }
                label2224:
                i = i1;
              }
              label2235:
              break label1501;
              label2238:
              i3 = i;
              i = k;
              k = j;
              j = i3;
            }
          }
          label2264:
          i5 = n;
          n = i7;
          break label374;
        }
      }
      break label349;
      i7 = i3;
      i3 = k;
      k = i2;
      i5 = n;
      n = i7;
      i2 = m;
    }
  }
  
  protected final boolean au(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(200569);
    if (paramInt == 0)
    {
      if ((this.tS & 0x1) != 0)
      {
        AppMethodBeat.o(200569);
        return true;
      }
      AppMethodBeat.o(200569);
      return false;
    }
    if (paramInt == getChildCount())
    {
      if ((this.tS & 0x4) != 0)
      {
        AppMethodBeat.o(200569);
        return true;
      }
      AppMethodBeat.o(200569);
      return false;
    }
    if ((this.tS & 0x2) != 0)
    {
      paramInt -= 1;
      if (paramInt < 0) {
        break label123;
      }
      if (getChildAt(paramInt).getVisibility() == 8) {}
    }
    for (;;)
    {
      AppMethodBeat.o(200569);
      return bool;
      paramInt -= 1;
      break;
      AppMethodBeat.o(200569);
      return false;
      label123:
      bool = false;
    }
  }
  
  protected LayoutParams b(ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(200718);
    paramLayoutParams = new LayoutParams(paramLayoutParams);
    AppMethodBeat.o(200718);
    return paramLayoutParams;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  protected LayoutParams dO()
  {
    AppMethodBeat.i(200707);
    LayoutParams localLayoutParams;
    if (this.mOrientation == 0)
    {
      localLayoutParams = new LayoutParams(-2, -2);
      AppMethodBeat.o(200707);
      return localLayoutParams;
    }
    if (this.mOrientation == 1)
    {
      localLayoutParams = new LayoutParams(-1, -2);
      AppMethodBeat.o(200707);
      return localLayoutParams;
    }
    AppMethodBeat.o(200707);
    return null;
  }
  
  public LayoutParams e(AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(200695);
    paramAttributeSet = new LayoutParams(getContext(), paramAttributeSet);
    AppMethodBeat.o(200695);
    return paramAttributeSet;
  }
  
  public int getBaseline()
  {
    AppMethodBeat.i(200462);
    if (this.tH < 0)
    {
      i = super.getBaseline();
      AppMethodBeat.o(200462);
      return i;
    }
    if (getChildCount() <= this.tH)
    {
      localObject = new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
      AppMethodBeat.o(200462);
      throw ((Throwable)localObject);
    }
    Object localObject = getChildAt(this.tH);
    int j = ((View)localObject).getBaseline();
    if (j == -1)
    {
      if (this.tH == 0)
      {
        AppMethodBeat.o(200462);
        return -1;
      }
      localObject = new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
      AppMethodBeat.o(200462);
      throw ((Throwable)localObject);
    }
    int i = this.tI;
    int k;
    if (this.mOrientation == 1)
    {
      k = this.tJ & 0x70;
      if (k != 48) {
        switch (k)
        {
        }
      }
    }
    for (;;)
    {
      k = ((LayoutParams)((View)localObject).getLayoutParams()).topMargin;
      AppMethodBeat.o(200462);
      return k + i + j;
      i = getBottom() - getTop() - getPaddingBottom() - this.tK;
      continue;
      i += (getBottom() - getTop() - getPaddingTop() - getPaddingBottom() - this.tK) / 2;
    }
  }
  
  public int getBaselineAlignedChildIndex()
  {
    return this.tH;
  }
  
  public Drawable getDividerDrawable()
  {
    return this.tP;
  }
  
  public int getDividerPadding()
  {
    return this.tT;
  }
  
  public int getDividerWidth()
  {
    return this.tQ;
  }
  
  public int getGravity()
  {
    return this.tJ;
  }
  
  public int getOrientation()
  {
    return this.mOrientation;
  }
  
  public int getShowDividers()
  {
    return this.tS;
  }
  
  int getVirtualChildCount()
  {
    AppMethodBeat.i(200496);
    int i = getChildCount();
    AppMethodBeat.o(200496);
    return i;
  }
  
  public float getWeightSum()
  {
    return this.tL;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(200419);
    if (this.tP == null)
    {
      AppMethodBeat.o(200419);
      return;
    }
    int j;
    View localView;
    LayoutParams localLayoutParams;
    if (this.mOrientation == 1)
    {
      j = getVirtualChildCount();
      i = 0;
      while (i < j)
      {
        localView = getChildAt(i);
        if ((localView != null) && (localView.getVisibility() != 8) && (au(i)))
        {
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          b(paramCanvas, localView.getTop() - localLayoutParams.topMargin - this.tR);
        }
        i += 1;
      }
      if (au(j))
      {
        localView = getChildAt(j - 1);
        if (localView != null) {
          break label158;
        }
      }
      for (i = getHeight() - getPaddingBottom() - this.tR;; i = localLayoutParams.bottomMargin + i)
      {
        b(paramCanvas, i);
        AppMethodBeat.o(200419);
        return;
        label158:
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        i = localView.getBottom();
      }
    }
    int k = getVirtualChildCount();
    boolean bool = ai.s(this);
    int i = 0;
    if (i < k)
    {
      localView = getChildAt(i);
      if ((localView != null) && (localView.getVisibility() != 8) && (au(i)))
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (!bool) {
          break label277;
        }
        j = localView.getRight();
      }
      label277:
      for (j = localLayoutParams.rightMargin + j;; j = localView.getLeft() - localLayoutParams.leftMargin - this.tQ)
      {
        c(paramCanvas, j);
        i += 1;
        break;
      }
    }
    if (au(k))
    {
      localView = getChildAt(k - 1);
      if (localView != null) {
        break label362;
      }
      if (!bool) {
        break label344;
      }
      i = getPaddingLeft();
    }
    for (;;)
    {
      c(paramCanvas, i);
      AppMethodBeat.o(200419);
      return;
      label344:
      i = getWidth() - getPaddingRight() - this.tQ;
      continue;
      label362:
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if (bool)
      {
        i = localView.getLeft() - localLayoutParams.leftMargin - this.tQ;
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
    AppMethodBeat.i(200750);
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(LinearLayoutCompat.class.getName());
    AppMethodBeat.o(200750);
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    AppMethodBeat.i(200767);
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(LinearLayoutCompat.class.getName());
    AppMethodBeat.o(200767);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(200607);
    int i;
    int j;
    int k;
    int m;
    int n;
    int i1;
    label97:
    Object localObject1;
    if (this.mOrientation == 1)
    {
      i = getPaddingLeft();
      j = paramInt3 - paramInt1;
      k = getPaddingRight();
      m = getPaddingRight();
      n = getVirtualChildCount();
      paramInt1 = this.tJ;
      i1 = this.tJ;
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
      break label97;
      paramInt1 = getPaddingTop() + paramInt4 - paramInt2 - this.tK;
      break;
      paramInt1 = getPaddingTop() + (paramInt4 - paramInt2 - this.tK) / 2;
      break;
      if (((View)localObject1).getVisibility() != 8)
      {
        int i2 = ((View)localObject1).getMeasuredWidth();
        int i3 = ((View)localObject1).getMeasuredHeight();
        Object localObject2 = (LayoutParams)((View)localObject1).getLayoutParams();
        paramInt4 = ((LayoutParams)localObject2).fl;
        paramInt3 = paramInt4;
        if (paramInt4 < 0) {
          paramInt3 = 0x800007 & i1;
        }
        switch (e.ay(paramInt3, z.U(this)) & 0x7)
        {
        default: 
          paramInt3 = ((LayoutParams)localObject2).leftMargin + i;
        }
        for (;;)
        {
          paramInt4 = paramInt2;
          if (au(paramInt1)) {
            paramInt4 = paramInt2 + this.tR;
          }
          paramInt2 = paramInt4 + ((LayoutParams)localObject2).topMargin;
          c((View)localObject1, paramInt3, paramInt2 + 0, i2, i3);
          paramInt2 += ((LayoutParams)localObject2).bottomMargin + i3 + 0;
          paramInt1 += 0;
          break;
          paramInt3 = (j - i - m - i2) / 2 + i + ((LayoutParams)localObject2).leftMargin - ((LayoutParams)localObject2).rightMargin;
          continue;
          paramInt3 = j - k - i2 - ((LayoutParams)localObject2).rightMargin;
        }
        AppMethodBeat.o(200607);
        return;
        paramBoolean = ai.s(this);
        k = getPaddingTop();
        n = paramInt4 - paramInt2;
        i1 = getPaddingBottom();
        i2 = getPaddingBottom();
        i3 = getVirtualChildCount();
        paramInt2 = this.tJ;
        int i4 = this.tJ;
        boolean bool = this.tG;
        localObject1 = this.tN;
        localObject2 = this.tO;
        switch (e.ay(paramInt2 & 0x800007, z.U(this)))
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
          label518:
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
            break label518;
            paramInt1 = getPaddingLeft() + paramInt3 - paramInt1 - this.tK;
            break;
            paramInt1 = getPaddingLeft() + (paramInt3 - paramInt1 - this.tK) / 2;
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
              m = localLayoutParams.fl;
              paramInt1 = m;
              if (m < 0) {
                paramInt1 = i4 & 0x70;
              }
              switch (paramInt1 & 0x70)
              {
              default: 
                paramInt1 = k;
              }
              label909:
              for (;;)
              {
                label723:
                if (au(i7)) {
                  paramInt3 = this.tQ + paramInt3;
                }
                for (;;)
                {
                  paramInt3 += localLayoutParams.leftMargin;
                  c(localView, paramInt3 + 0, paramInt1, i5, i6);
                  paramInt3 += localLayoutParams.rightMargin + i5 + 0;
                  paramInt1 = paramInt2 + 0;
                  break;
                  m = localLayoutParams.topMargin + k;
                  paramInt1 = m;
                  if (j == -1) {
                    break label909;
                  }
                  paramInt1 = localObject1[1] - j + m;
                  break label723;
                  paramInt1 = (n - k - i2 - i6) / 2 + k + localLayoutParams.topMargin - localLayoutParams.bottomMargin;
                  break label723;
                  m = n - i1 - i6 - localLayoutParams.bottomMargin;
                  paramInt1 = m;
                  if (j == -1) {
                    break label909;
                  }
                  paramInt1 = localView.getMeasuredHeight();
                  paramInt1 = m - (localObject2[2] - (paramInt1 - j));
                  break label723;
                  AppMethodBeat.o(200607);
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
    AppMethodBeat.i(200550);
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
    label248:
    int i6;
    label476:
    int i7;
    int i8;
    if (this.mOrientation == 1)
    {
      this.tK = 0;
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
      int i12 = this.tH;
      bool = this.tM;
      m = 0;
      i4 = 0;
      for (;;)
      {
        if (i4 < i9)
        {
          localObject = getChildAt(i4);
          if (localObject == null)
          {
            this.tK += 0;
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
              break label1650;
            }
            if (au(i4)) {
              this.tK += this.tR;
            }
            localLayoutParams = (LayoutParams)((View)localObject).getLayoutParams();
            f1 += localLayoutParams.qL;
            if ((i11 == 1073741824) && (localLayoutParams.height == 0) && (localLayoutParams.qL > 0.0F))
            {
              i3 = this.tK;
              this.tK = Math.max(i3, localLayoutParams.topMargin + i3 + localLayoutParams.bottomMargin);
              i3 = 1;
              if ((i12 >= 0) && (i12 == i4 + 1)) {
                this.tI = this.tK;
              }
              if ((i4 < i12) && (localLayoutParams.qL > 0.0F))
              {
                localObject = new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                AppMethodBeat.o(200550);
                throw ((Throwable)localObject);
              }
            }
            else
            {
              i6 = -2147483648;
              i5 = i6;
              if (localLayoutParams.height == 0)
              {
                i5 = i6;
                if (localLayoutParams.qL > 0.0F)
                {
                  i5 = 0;
                  localLayoutParams.height = -2;
                }
              }
              if (f1 == 0.0F) {}
              for (i6 = this.tK;; i6 = 0)
              {
                b((View)localObject, paramInt1, 0, paramInt2, i6);
                if (i5 != -2147483648) {
                  localLayoutParams.height = i5;
                }
                i5 = ((View)localObject).getMeasuredHeight();
                i6 = this.tK;
                this.tK = Math.max(i6, i6 + i5 + localLayoutParams.topMargin + localLayoutParams.bottomMargin + 0);
                if (!bool) {
                  break label1647;
                }
                m = Math.max(i5, m);
                break;
              }
            }
            i6 = 0;
            if ((i10 == 1073741824) || (localLayoutParams.width != -1)) {
              break label1636;
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
              label537:
              if (localLayoutParams.qL <= 0.0F) {
                break label643;
              }
              if (n == 0) {
                break label636;
              }
              label552:
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
      break label537;
      label636:
      i6 = i7;
      break label552;
      label643:
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
      if ((this.tK > 0) && (au(i9))) {
        this.tK += this.tR;
      }
      if ((bool) && ((i11 == -2147483648) || (i11 == 0)))
      {
        this.tK = 0;
        i4 = 0;
        if (i4 < i9)
        {
          localObject = getChildAt(i4);
          if (localObject == null) {
            this.tK += 0;
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
              i5 = this.tK;
              i6 = ((LayoutParams)localObject).topMargin;
              this.tK = Math.max(i5, ((LayoutParams)localObject).bottomMargin + (i5 + m + i6) + 0);
            }
          }
        }
      }
      this.tK += getPaddingTop() + getPaddingBottom();
      i6 = View.resolveSizeAndState(Math.max(this.tK, getSuggestedMinimumHeight()), paramInt2, 0);
      i4 = (0xFFFFFF & i6) - this.tK;
      if ((i3 != 0) || ((i4 != 0) && (f1 > 0.0F)))
      {
        if (this.tL > 0.0F) {
          f1 = this.tL;
        }
        this.tK = 0;
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
            break label1613;
          }
          localLayoutParams = (LayoutParams)((View)localObject).getLayoutParams();
          float f2 = localLayoutParams.qL;
          if (f2 <= 0.0F) {
            break label1606;
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
            label1099:
            ((View)localObject).measure(i7, View.MeasureSpec.makeMeasureSpec(i1, 1073741824));
            m = View.combineMeasuredStates(m, ((View)localObject).getMeasuredState() & 0xFFFFFF00);
            f1 -= f2;
            i1 = i2 - i4;
            label1141:
            i4 = localLayoutParams.leftMargin + localLayoutParams.rightMargin;
            i5 = ((View)localObject).getMeasuredWidth() + i4;
            i2 = Math.max(k, i5);
            if ((i10 == 1073741824) || (localLayoutParams.width != -1)) {
              break label1339;
            }
            k = 1;
            label1192:
            if (k == 0) {
              break label1345;
            }
            k = i4;
            label1201:
            i4 = Math.max(i, k);
            if ((j == 0) || (localLayoutParams.width != -1)) {
              break label1352;
            }
            i = 1;
            label1227:
            j = this.tK;
            k = ((View)localObject).getMeasuredHeight();
            i5 = localLayoutParams.topMargin;
            this.tK = Math.max(j, localLayoutParams.bottomMargin + (k + j + i5) + 0);
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
          break label1099;
        }
        i1 = 0;
        break label1099;
        label1339:
        k = 0;
        break label1192;
        label1345:
        k = i5;
        break label1201;
        label1352:
        i = 0;
        break label1227;
        this.tK += getPaddingTop() + getPaddingBottom();
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
              n(i9, paramInt2);
            }
            AppMethodBeat.o(200550);
            return;
            i2 = Math.max(i1, i2);
            if ((!bool) || (i11 == 1073741824)) {
              break;
            }
            i1 = 0;
            while (i1 < i9)
            {
              localObject = getChildAt(i1);
              if ((localObject != null) && (((View)localObject).getVisibility() != 8) && (((LayoutParams)((View)localObject).getLayoutParams()).qL > 0.0F)) {
                ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(((View)localObject).getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(m, 1073741824));
              }
              i1 += 1;
            }
            o(paramInt1, paramInt2);
            AppMethodBeat.o(200550);
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
        label1606:
        i1 = i2;
        break label1141;
        label1613:
        i4 = k;
        k = j;
        i1 = i2;
        j = i;
      }
      label1636:
      i5 = n;
      n = i6;
      break label476;
      label1647:
      break label248;
      label1650:
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
    this.tG = paramBoolean;
  }
  
  public void setBaselineAlignedChildIndex(int paramInt)
  {
    AppMethodBeat.i(200486);
    if ((paramInt < 0) || (paramInt >= getChildCount()))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
      AppMethodBeat.o(200486);
      throw localIllegalArgumentException;
    }
    this.tH = paramInt;
    AppMethodBeat.o(200486);
  }
  
  public void setDividerDrawable(Drawable paramDrawable)
  {
    boolean bool = false;
    AppMethodBeat.i(200367);
    if (paramDrawable == this.tP)
    {
      AppMethodBeat.o(200367);
      return;
    }
    this.tP = paramDrawable;
    if (paramDrawable != null) {
      this.tQ = paramDrawable.getIntrinsicWidth();
    }
    for (this.tR = paramDrawable.getIntrinsicHeight();; this.tR = 0)
    {
      if (paramDrawable == null) {
        bool = true;
      }
      setWillNotDraw(bool);
      requestLayout();
      AppMethodBeat.o(200367);
      return;
      this.tQ = 0;
    }
  }
  
  public void setDividerPadding(int paramInt)
  {
    this.tT = paramInt;
  }
  
  public void setGravity(int paramInt)
  {
    AppMethodBeat.i(200643);
    if (this.tJ != paramInt)
    {
      if ((0x800007 & paramInt) != 0) {
        break label58;
      }
      paramInt = 0x800003 | paramInt;
    }
    label58:
    for (;;)
    {
      int i = paramInt;
      if ((paramInt & 0x70) == 0) {
        i = paramInt | 0x30;
      }
      this.tJ = i;
      requestLayout();
      AppMethodBeat.o(200643);
      return;
    }
  }
  
  public void setHorizontalGravity(int paramInt)
  {
    AppMethodBeat.i(200666);
    paramInt &= 0x800007;
    if ((this.tJ & 0x800007) != paramInt)
    {
      this.tJ = (paramInt | this.tJ & 0xFF7FFFF8);
      requestLayout();
    }
    AppMethodBeat.o(200666);
  }
  
  public void setMeasureWithLargestChildEnabled(boolean paramBoolean)
  {
    this.tM = paramBoolean;
  }
  
  public void setOrientation(int paramInt)
  {
    AppMethodBeat.i(200617);
    if (this.mOrientation != paramInt)
    {
      this.mOrientation = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(200617);
  }
  
  public void setShowDividers(int paramInt)
  {
    AppMethodBeat.i(200325);
    if (paramInt != this.tS) {
      requestLayout();
    }
    this.tS = paramInt;
    AppMethodBeat.o(200325);
  }
  
  public void setVerticalGravity(int paramInt)
  {
    AppMethodBeat.i(200679);
    paramInt &= 0x70;
    if ((this.tJ & 0x70) != paramInt)
    {
      this.tJ = (paramInt | this.tJ & 0xFFFFFF8F);
      requestLayout();
    }
    AppMethodBeat.o(200679);
  }
  
  public void setWeightSum(float paramFloat)
  {
    AppMethodBeat.i(200517);
    this.tL = Math.max(0.0F, paramFloat);
    AppMethodBeat.o(200517);
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    public int fl;
    public float qL;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
      this.fl = -1;
      this.qL = 0.0F;
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      AppMethodBeat.i(200085);
      this.fl = -1;
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.j.LinearLayoutCompat_Layout);
      this.qL = paramContext.getFloat(a.j.LinearLayoutCompat_Layout_android_layout_weight, 0.0F);
      this.fl = paramContext.getInt(a.j.LinearLayoutCompat_Layout_android_layout_gravity, -1);
      paramContext.recycle();
      AppMethodBeat.o(200085);
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
      this.fl = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.widget.LinearLayoutCompat
 * JD-Core Version:    0.7.0.1
 */