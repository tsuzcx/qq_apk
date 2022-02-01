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
import androidx.core.g.w;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class LinearLayoutCompat
  extends ViewGroup
{
  private int mOrientation;
  private boolean sH;
  private int sI;
  private int sJ;
  private int sK;
  private int sL;
  private float sM;
  private boolean sN;
  private int[] sO;
  private int[] sP;
  private Drawable sQ;
  private int sR;
  private int sS;
  private int sT;
  private int sU;
  
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
    AppMethodBeat.i(241319);
    this.sH = true;
    this.sI = -1;
    this.sJ = 0;
    this.sK = 8388659;
    paramContext = ac.a(paramContext, paramAttributeSet, a.j.LinearLayoutCompat, paramInt, 0);
    paramInt = paramContext.getInt(a.j.LinearLayoutCompat_android_orientation, -1);
    if (paramInt >= 0) {
      setOrientation(paramInt);
    }
    paramInt = paramContext.getInt(a.j.LinearLayoutCompat_android_gravity, -1);
    if (paramInt >= 0) {
      setGravity(paramInt);
    }
    boolean bool = paramContext.c(a.j.LinearLayoutCompat_android_baselineAligned, true);
    if (!bool) {
      setBaselineAligned(bool);
    }
    this.sM = paramContext.c(a.j.LinearLayoutCompat_android_weightSum, -1.0F);
    this.sI = paramContext.getInt(a.j.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
    this.sN = paramContext.c(a.j.LinearLayoutCompat_measureWithLargestChild, false);
    setDividerDrawable(paramContext.getDrawable(a.j.LinearLayoutCompat_divider));
    this.sT = paramContext.getInt(a.j.LinearLayoutCompat_showDividers, 0);
    this.sU = paramContext.p(a.j.LinearLayoutCompat_dividerPadding, 0);
    paramContext.wA.recycle();
    AppMethodBeat.o(241319);
  }
  
  private void a(Canvas paramCanvas, int paramInt)
  {
    AppMethodBeat.i(241329);
    this.sQ.setBounds(getPaddingLeft() + this.sU, paramInt, getWidth() - getPaddingRight() - this.sU, this.sS + paramInt);
    this.sQ.draw(paramCanvas);
    AppMethodBeat.o(241329);
  }
  
  private void b(Canvas paramCanvas, int paramInt)
  {
    AppMethodBeat.i(241330);
    this.sQ.setBounds(paramInt, getPaddingTop() + this.sU, this.sR + paramInt, getHeight() - getPaddingBottom() - this.sU);
    this.sQ.draw(paramCanvas);
    AppMethodBeat.o(241330);
  }
  
  private void b(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(241350);
    measureChildWithMargins(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(241350);
  }
  
  private static void c(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(241352);
    paramView.layout(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
    AppMethodBeat.o(241352);
  }
  
  private void i(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(241340);
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
    AppMethodBeat.o(241340);
  }
  
  private void j(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(241347);
    this.sL = 0;
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
    if ((this.sO == null) || (this.sP == null))
    {
      this.sO = new int[4];
      this.sP = new int[4];
    }
    Object localObject1 = this.sO;
    Object localObject2 = this.sP;
    localObject1[3] = -1;
    localObject1[2] = -1;
    localObject1[1] = -1;
    localObject1[0] = -1;
    localObject2[3] = -1;
    localObject2[2] = -1;
    localObject2[1] = -1;
    localObject2[0] = -1;
    boolean bool1 = this.sH;
    boolean bool2 = this.sN;
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
        this.sL += 0;
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
      if (aw(i4)) {
        this.sL += this.sR;
      }
      localLayoutParams = (LayoutParams)((View)localObject3).getLayoutParams();
      f1 += localLayoutParams.pO;
      if ((i12 == 1073741824) && (localLayoutParams.width == 0) && (localLayoutParams.pO > 0.0F)) {
        if (i6 != 0)
        {
          this.sL += localLayoutParams.leftMargin + localLayoutParams.rightMargin;
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
              if (localLayoutParams.ek >= 0) {
                break label809;
              }
              i9 = this.sK;
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
          if (localLayoutParams.pO <= 0.0F) {
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
      i5 = this.sL;
      this.sL = Math.max(i5, localLayoutParams.leftMargin + i5 + localLayoutParams.rightMargin);
      break label328;
      label627:
      i3 = 1;
      break label349;
      i7 = -2147483648;
      i5 = i7;
      if (localLayoutParams.width == 0)
      {
        i5 = i7;
        if (localLayoutParams.pO > 0.0F)
        {
          i5 = 0;
          localLayoutParams.width = -2;
        }
      }
      if (f1 == 0.0F)
      {
        i7 = this.sL;
        label686:
        b((View)localObject3, paramInt1, i7, paramInt2, 0);
        if (i5 != -2147483648) {
          localLayoutParams.width = i5;
        }
        i5 = ((View)localObject3).getMeasuredWidth();
        if (i6 == 0) {
          break label772;
        }
        this.sL += localLayoutParams.leftMargin + i5 + localLayoutParams.rightMargin + 0;
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
          i7 = this.sL;
          this.sL = Math.max(i7, i7 + i5 + localLayoutParams.leftMargin + localLayoutParams.rightMargin + 0);
          continue;
          label809:
          i9 = localLayoutParams.ek;
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
          if ((this.sL > 0) && (aw(i10))) {
            this.sL += this.sR;
          }
          if ((localObject1[1] != -1) || (localObject1[0] != -1) || (localObject1[2] != -1) || (localObject1[3] != -1)) {}
          for (i4 = Math.max(m, Math.max(localObject1[3], Math.max(localObject1[0], Math.max(localObject1[1], localObject1[2]))) + Math.max(localObject2[3], Math.max(localObject2[0], Math.max(localObject2[1], localObject2[2]))));; i4 = m)
          {
            if ((bool2) && ((i12 == -2147483648) || (i12 == 0)))
            {
              this.sL = 0;
              m = 0;
              if (m < i10)
              {
                localObject3 = getChildAt(m);
                if (localObject3 == null) {
                  this.sL += 0;
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
                      i5 = this.sL;
                      i7 = ((LayoutParams)localObject3).leftMargin;
                      this.sL = (((LayoutParams)localObject3).rightMargin + (i7 + i) + 0 + i5);
                    }
                    else
                    {
                      i5 = this.sL;
                      i7 = ((LayoutParams)localObject3).leftMargin;
                      this.sL = Math.max(i5, ((LayoutParams)localObject3).rightMargin + (i5 + i + i7) + 0);
                    }
                  }
                }
              }
            }
            this.sL += getPaddingLeft() + getPaddingRight();
            i8 = View.resolveSizeAndState(Math.max(this.sL, getSuggestedMinimumWidth()), paramInt1, 0);
            i5 = (0xFFFFFF & i8) - this.sL;
            if ((i3 != 0) || ((i5 != 0) && (f1 > 0.0F)))
            {
              if (this.sM > 0.0F) {
                f1 = this.sM;
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
              this.sL = 0;
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
                float f2 = localLayoutParams.pO;
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
                  this.sL += ((View)localObject3).getMeasuredWidth() + localLayoutParams.leftMargin + localLayoutParams.rightMargin + 0;
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
                      if (localLayoutParams.ek >= 0) {
                        break label1821;
                      }
                      j = this.sK;
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
              i3 = this.sL;
              this.sL = Math.max(i3, ((View)localObject3).getMeasuredWidth() + i3 + localLayoutParams.leftMargin + localLayoutParams.rightMargin + 0);
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
              j = localLayoutParams.ek;
              break label1652;
              this.sL += getPaddingLeft() + getPaddingRight();
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
                        if ((localObject1 != null) && (((View)localObject1).getVisibility() != 8) && (((LayoutParams)((View)localObject1).getLayoutParams()).pO > 0.0F)) {
                          ((View)localObject1).measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(((View)localObject1).getMeasuredHeight(), 1073741824));
                        }
                        m += 1;
                      }
                    }
                  }
                  AppMethodBeat.o(241347);
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
  
  protected final boolean aw(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(241338);
    if (paramInt == 0)
    {
      if ((this.sT & 0x1) != 0)
      {
        AppMethodBeat.o(241338);
        return true;
      }
      AppMethodBeat.o(241338);
      return false;
    }
    if (paramInt == getChildCount())
    {
      if ((this.sT & 0x4) != 0)
      {
        AppMethodBeat.o(241338);
        return true;
      }
      AppMethodBeat.o(241338);
      return false;
    }
    if ((this.sT & 0x2) != 0)
    {
      paramInt -= 1;
      if (paramInt < 0) {
        break label123;
      }
      if (getChildAt(paramInt).getVisibility() == 8) {}
    }
    for (;;)
    {
      AppMethodBeat.o(241338);
      return bool;
      paramInt -= 1;
      break;
      AppMethodBeat.o(241338);
      return false;
      label123:
      bool = false;
    }
  }
  
  protected LayoutParams b(ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(241360);
    paramLayoutParams = new LayoutParams(paramLayoutParams);
    AppMethodBeat.o(241360);
    return paramLayoutParams;
  }
  
  protected LayoutParams cV()
  {
    AppMethodBeat.i(241358);
    LayoutParams localLayoutParams;
    if (this.mOrientation == 0)
    {
      localLayoutParams = new LayoutParams(-2, -2);
      AppMethodBeat.o(241358);
      return localLayoutParams;
    }
    if (this.mOrientation == 1)
    {
      localLayoutParams = new LayoutParams(-1, -2);
      AppMethodBeat.o(241358);
      return localLayoutParams;
    }
    AppMethodBeat.o(241358);
    return null;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public LayoutParams e(AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(241357);
    paramAttributeSet = new LayoutParams(getContext(), paramAttributeSet);
    AppMethodBeat.o(241357);
    return paramAttributeSet;
  }
  
  public int getBaseline()
  {
    AppMethodBeat.i(241332);
    if (this.sI < 0)
    {
      i = super.getBaseline();
      AppMethodBeat.o(241332);
      return i;
    }
    if (getChildCount() <= this.sI)
    {
      localObject = new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
      AppMethodBeat.o(241332);
      throw ((Throwable)localObject);
    }
    Object localObject = getChildAt(this.sI);
    int j = ((View)localObject).getBaseline();
    if (j == -1)
    {
      if (this.sI == 0)
      {
        AppMethodBeat.o(241332);
        return -1;
      }
      localObject = new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
      AppMethodBeat.o(241332);
      throw ((Throwable)localObject);
    }
    int i = this.sJ;
    int k;
    if (this.mOrientation == 1)
    {
      k = this.sK & 0x70;
      if (k != 48) {
        switch (k)
        {
        }
      }
    }
    for (;;)
    {
      k = ((LayoutParams)((View)localObject).getLayoutParams()).topMargin;
      AppMethodBeat.o(241332);
      return k + i + j;
      i = getBottom() - getTop() - getPaddingBottom() - this.sL;
      continue;
      i += (getBottom() - getTop() - getPaddingTop() - getPaddingBottom() - this.sL) / 2;
    }
  }
  
  public int getBaselineAlignedChildIndex()
  {
    return this.sI;
  }
  
  public Drawable getDividerDrawable()
  {
    return this.sQ;
  }
  
  public int getDividerPadding()
  {
    return this.sU;
  }
  
  public int getDividerWidth()
  {
    return this.sR;
  }
  
  public int getGravity()
  {
    return this.sK;
  }
  
  public int getOrientation()
  {
    return this.mOrientation;
  }
  
  public int getShowDividers()
  {
    return this.sT;
  }
  
  int getVirtualChildCount()
  {
    AppMethodBeat.i(241334);
    int i = getChildCount();
    AppMethodBeat.o(241334);
    return i;
  }
  
  public float getWeightSum()
  {
    return this.sM;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(241326);
    if (this.sQ == null)
    {
      AppMethodBeat.o(241326);
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
        if ((localView != null) && (localView.getVisibility() != 8) && (aw(i)))
        {
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          a(paramCanvas, localView.getTop() - localLayoutParams.topMargin - this.sS);
        }
        i += 1;
      }
      if (aw(j))
      {
        localView = getChildAt(j - 1);
        if (localView != null) {
          break label158;
        }
      }
      for (i = getHeight() - getPaddingBottom() - this.sS;; i = localLayoutParams.bottomMargin + i)
      {
        a(paramCanvas, i);
        AppMethodBeat.o(241326);
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
      if ((localView != null) && (localView.getVisibility() != 8) && (aw(i)))
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (!bool) {
          break label277;
        }
        j = localView.getRight();
      }
      label277:
      for (j = localLayoutParams.rightMargin + j;; j = localView.getLeft() - localLayoutParams.leftMargin - this.sR)
      {
        b(paramCanvas, j);
        i += 1;
        break;
      }
    }
    if (aw(k))
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
      b(paramCanvas, i);
      AppMethodBeat.o(241326);
      return;
      label344:
      i = getWidth() - getPaddingRight() - this.sR;
      continue;
      label362:
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if (bool)
      {
        i = localView.getLeft() - localLayoutParams.leftMargin - this.sR;
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
    AppMethodBeat.i(241362);
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(LinearLayoutCompat.class.getName());
    AppMethodBeat.o(241362);
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    AppMethodBeat.i(241363);
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(LinearLayoutCompat.class.getName());
    AppMethodBeat.o(241363);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(241351);
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
      paramInt1 = this.sK;
      i1 = this.sK;
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
      paramInt1 = getPaddingTop() + paramInt4 - paramInt2 - this.sL;
      break;
      paramInt1 = getPaddingTop() + (paramInt4 - paramInt2 - this.sL) / 2;
      break;
      if (((View)localObject1).getVisibility() != 8)
      {
        int i2 = ((View)localObject1).getMeasuredWidth();
        int i3 = ((View)localObject1).getMeasuredHeight();
        Object localObject2 = (LayoutParams)((View)localObject1).getLayoutParams();
        paramInt4 = ((LayoutParams)localObject2).ek;
        paramInt3 = paramInt4;
        if (paramInt4 < 0) {
          paramInt3 = 0x800007 & i1;
        }
        switch (e.D(paramInt3, w.I(this)) & 0x7)
        {
        default: 
          paramInt3 = ((LayoutParams)localObject2).leftMargin + i;
        }
        for (;;)
        {
          paramInt4 = paramInt2;
          if (aw(paramInt1)) {
            paramInt4 = paramInt2 + this.sS;
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
        AppMethodBeat.o(241351);
        return;
        paramBoolean = ai.s(this);
        k = getPaddingTop();
        n = paramInt4 - paramInt2;
        i1 = getPaddingBottom();
        i2 = getPaddingBottom();
        i3 = getVirtualChildCount();
        paramInt2 = this.sK;
        int i4 = this.sK;
        boolean bool = this.sH;
        localObject1 = this.sO;
        localObject2 = this.sP;
        switch (e.D(paramInt2 & 0x800007, w.I(this)))
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
            paramInt1 = getPaddingLeft() + paramInt3 - paramInt1 - this.sL;
            break;
            paramInt1 = getPaddingLeft() + (paramInt3 - paramInt1 - this.sL) / 2;
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
              m = localLayoutParams.ek;
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
                if (aw(i7)) {
                  paramInt3 = this.sR + paramInt3;
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
                  AppMethodBeat.o(241351);
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
    AppMethodBeat.i(241337);
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
      this.sL = 0;
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
      int i12 = this.sI;
      bool = this.sN;
      m = 0;
      i4 = 0;
      for (;;)
      {
        if (i4 < i9)
        {
          localObject = getChildAt(i4);
          if (localObject == null)
          {
            this.sL += 0;
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
            if (aw(i4)) {
              this.sL += this.sS;
            }
            localLayoutParams = (LayoutParams)((View)localObject).getLayoutParams();
            f1 += localLayoutParams.pO;
            if ((i11 == 1073741824) && (localLayoutParams.height == 0) && (localLayoutParams.pO > 0.0F))
            {
              i3 = this.sL;
              this.sL = Math.max(i3, localLayoutParams.topMargin + i3 + localLayoutParams.bottomMargin);
              i3 = 1;
              if ((i12 >= 0) && (i12 == i4 + 1)) {
                this.sJ = this.sL;
              }
              if ((i4 < i12) && (localLayoutParams.pO > 0.0F))
              {
                localObject = new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                AppMethodBeat.o(241337);
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
                if (localLayoutParams.pO > 0.0F)
                {
                  i5 = 0;
                  localLayoutParams.height = -2;
                }
              }
              if (f1 == 0.0F) {}
              for (i6 = this.sL;; i6 = 0)
              {
                b((View)localObject, paramInt1, 0, paramInt2, i6);
                if (i5 != -2147483648) {
                  localLayoutParams.height = i5;
                }
                i5 = ((View)localObject).getMeasuredHeight();
                i6 = this.sL;
                this.sL = Math.max(i6, i6 + i5 + localLayoutParams.topMargin + localLayoutParams.bottomMargin + 0);
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
              if (localLayoutParams.pO <= 0.0F) {
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
      if ((this.sL > 0) && (aw(i9))) {
        this.sL += this.sS;
      }
      if ((bool) && ((i11 == -2147483648) || (i11 == 0)))
      {
        this.sL = 0;
        i4 = 0;
        if (i4 < i9)
        {
          localObject = getChildAt(i4);
          if (localObject == null) {
            this.sL += 0;
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
              i5 = this.sL;
              i6 = ((LayoutParams)localObject).topMargin;
              this.sL = Math.max(i5, ((LayoutParams)localObject).bottomMargin + (i5 + m + i6) + 0);
            }
          }
        }
      }
      this.sL += getPaddingTop() + getPaddingBottom();
      i6 = View.resolveSizeAndState(Math.max(this.sL, getSuggestedMinimumHeight()), paramInt2, 0);
      i4 = (0xFFFFFF & i6) - this.sL;
      if ((i3 != 0) || ((i4 != 0) && (f1 > 0.0F)))
      {
        if (this.sM > 0.0F) {
          f1 = this.sM;
        }
        this.sL = 0;
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
          float f2 = localLayoutParams.pO;
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
            j = this.sL;
            k = ((View)localObject).getMeasuredHeight();
            i5 = localLayoutParams.topMargin;
            this.sL = Math.max(j, localLayoutParams.bottomMargin + (k + j + i5) + 0);
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
        this.sL += getPaddingTop() + getPaddingBottom();
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
              i(i9, paramInt2);
            }
            AppMethodBeat.o(241337);
            return;
            i2 = Math.max(i1, i2);
            if ((!bool) || (i11 == 1073741824)) {
              break;
            }
            i1 = 0;
            while (i1 < i9)
            {
              localObject = getChildAt(i1);
              if ((localObject != null) && (((View)localObject).getVisibility() != 8) && (((LayoutParams)((View)localObject).getLayoutParams()).pO > 0.0F)) {
                ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(((View)localObject).getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(m, 1073741824));
              }
              i1 += 1;
            }
            j(paramInt1, paramInt2);
            AppMethodBeat.o(241337);
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
    this.sH = paramBoolean;
  }
  
  public void setBaselineAlignedChildIndex(int paramInt)
  {
    AppMethodBeat.i(241333);
    if ((paramInt < 0) || (paramInt >= getChildCount()))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
      AppMethodBeat.o(241333);
      throw localIllegalArgumentException;
    }
    this.sI = paramInt;
    AppMethodBeat.o(241333);
  }
  
  public void setDividerDrawable(Drawable paramDrawable)
  {
    boolean bool = false;
    AppMethodBeat.i(241323);
    if (paramDrawable == this.sQ)
    {
      AppMethodBeat.o(241323);
      return;
    }
    this.sQ = paramDrawable;
    if (paramDrawable != null) {
      this.sR = paramDrawable.getIntrinsicWidth();
    }
    for (this.sS = paramDrawable.getIntrinsicHeight();; this.sS = 0)
    {
      if (paramDrawable == null) {
        bool = true;
      }
      setWillNotDraw(bool);
      requestLayout();
      AppMethodBeat.o(241323);
      return;
      this.sR = 0;
    }
  }
  
  public void setDividerPadding(int paramInt)
  {
    this.sU = paramInt;
  }
  
  public void setGravity(int paramInt)
  {
    AppMethodBeat.i(241354);
    if (this.sK != paramInt)
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
      this.sK = i;
      requestLayout();
      AppMethodBeat.o(241354);
      return;
    }
  }
  
  public void setHorizontalGravity(int paramInt)
  {
    AppMethodBeat.i(241355);
    paramInt &= 0x800007;
    if ((this.sK & 0x800007) != paramInt)
    {
      this.sK = (paramInt | this.sK & 0xFF7FFFF8);
      requestLayout();
    }
    AppMethodBeat.o(241355);
  }
  
  public void setMeasureWithLargestChildEnabled(boolean paramBoolean)
  {
    this.sN = paramBoolean;
  }
  
  public void setOrientation(int paramInt)
  {
    AppMethodBeat.i(241353);
    if (this.mOrientation != paramInt)
    {
      this.mOrientation = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(241353);
  }
  
  public void setShowDividers(int paramInt)
  {
    AppMethodBeat.i(241320);
    if (paramInt != this.sT) {
      requestLayout();
    }
    this.sT = paramInt;
    AppMethodBeat.o(241320);
  }
  
  public void setVerticalGravity(int paramInt)
  {
    AppMethodBeat.i(241356);
    paramInt &= 0x70;
    if ((this.sK & 0x70) != paramInt)
    {
      this.sK = (paramInt | this.sK & 0xFFFFFF8F);
      requestLayout();
    }
    AppMethodBeat.o(241356);
  }
  
  public void setWeightSum(float paramFloat)
  {
    AppMethodBeat.i(241335);
    this.sM = Math.max(0.0F, paramFloat);
    AppMethodBeat.o(241335);
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    public int ek;
    public float pO;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
      this.ek = -1;
      this.pO = 0.0F;
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      AppMethodBeat.i(241313);
      this.ek = -1;
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.j.LinearLayoutCompat_Layout);
      this.pO = paramContext.getFloat(a.j.LinearLayoutCompat_Layout_android_layout_weight, 0.0F);
      this.ek = paramContext.getInt(a.j.LinearLayoutCompat_Layout_android_layout_gravity, -1);
      paramContext.recycle();
      AppMethodBeat.o(241313);
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
      this.ek = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.widget.LinearLayoutCompat
 * JD-Core Version:    0.7.0.1
 */