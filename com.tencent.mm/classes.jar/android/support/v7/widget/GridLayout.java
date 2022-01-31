package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v4.view.t;
import android.support.v7.e.a.a;
import android.util.AttributeSet;
import android.util.LogPrinter;
import android.util.Printer;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GridLayout
  extends ViewGroup
{
  private static final int ORIENTATION = 0;
  static final Printer adZ = new LogPrinter(3, GridLayout.class.getName());
  static final Printer aea = new GridLayout.1();
  private static final int aeb = 1;
  private static final int aec = 2;
  private static final int aed = 3;
  private static final int aee = 4;
  private static final int aef = 5;
  private static final int aeg = 6;
  static final GridLayout.a aen = new GridLayout.2();
  private static final GridLayout.a aeo = new GridLayout.3();
  private static final GridLayout.a aep = new GridLayout.a()
  {
    final String hP()
    {
      return "TRAILING";
    }
    
    public final int l(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      return paramAnonymousInt1;
    }
    
    final int z(View paramAnonymousView, int paramAnonymousInt)
    {
      return paramAnonymousInt;
    }
  };
  public static final GridLayout.a aeq = aeo;
  public static final GridLayout.a aer = aep;
  public static final GridLayout.a aes = aeo;
  public static final GridLayout.a aet = aep;
  public static final GridLayout.a aeu = a(aes, aet);
  public static final GridLayout.a aev = a(aet, aes);
  public static final GridLayout.a aew = new GridLayout.a()
  {
    final String hP()
    {
      return "CENTER";
    }
    
    public final int l(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      return paramAnonymousInt1 >> 1;
    }
    
    final int z(View paramAnonymousView, int paramAnonymousInt)
    {
      return paramAnonymousInt >> 1;
    }
  };
  public static final GridLayout.a aex = new GridLayout.7();
  public static final GridLayout.a aey = new GridLayout.8();
  final GridLayout.d aeh = new GridLayout.d(this, true);
  final GridLayout.d aei = new GridLayout.d(this, false);
  boolean aej = false;
  int aek = 1;
  int ael;
  int aem = 0;
  int mOrientation = 0;
  Printer mPrinter = adZ;
  
  public GridLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public GridLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.ael = paramContext.getResources().getDimensionPixelOffset(2131428271);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.GridLayout);
    try
    {
      setRowCount(paramContext.getInt(aeb, -2147483648));
      setColumnCount(paramContext.getInt(aec, -2147483648));
      setOrientation(paramContext.getInt(ORIENTATION, 0));
      setUseDefaultMargins(paramContext.getBoolean(aed, false));
      setAlignmentMode(paramContext.getInt(aee, 1));
      setRowOrderPreserved(paramContext.getBoolean(aef, true));
      setColumnOrderPreserved(paramContext.getBoolean(aeg, true));
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  private static int Q(int paramInt1, int paramInt2)
  {
    return View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt1 + paramInt2), View.MeasureSpec.getMode(paramInt1));
  }
  
  static void R(String paramString)
  {
    throw new IllegalArgumentException(paramString + ". ");
  }
  
  private static GridLayout.a a(GridLayout.a parama1, GridLayout.a parama2)
  {
    return new GridLayout.5(parama1, parama2);
  }
  
  public static GridLayout.i a(int paramInt1, int paramInt2, GridLayout.a parama, float paramFloat)
  {
    if (paramInt1 != -2147483648) {}
    for (boolean bool = true;; bool = false) {
      return new GridLayout.i(bool, paramInt1, paramInt2, parama, paramFloat);
    }
  }
  
  private static void a(GridLayout.LayoutParams paramLayoutParams, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    GridLayout.f localf = new GridLayout.f(paramInt1, paramInt1 + paramInt2);
    paramLayoutParams.afx = paramLayoutParams.afx.a(localf);
    localf = new GridLayout.f(paramInt3, paramInt3 + paramInt4);
    paramLayoutParams.afy = paramLayoutParams.afy.a(localf);
  }
  
  private void a(GridLayout.LayoutParams paramLayoutParams, boolean paramBoolean)
  {
    String str;
    label18:
    GridLayout.f localf;
    if (paramBoolean)
    {
      str = "column";
      if (!paramBoolean) {
        break label183;
      }
      paramLayoutParams = paramLayoutParams.afy;
      localf = paramLayoutParams.aeC;
      if ((localf.min != -2147483648) && (localf.min < 0)) {
        R(str + " indices must be positive");
      }
      if (!paramBoolean) {
        break label191;
      }
    }
    label183:
    label191:
    for (paramLayoutParams = this.aeh;; paramLayoutParams = this.aei)
    {
      int i = paramLayoutParams.aeI;
      if (i != -2147483648)
      {
        if (localf.max > i) {
          R(str + " indices (start + span) mustn't exceed the " + str + " count");
        }
        if (localf.size() > i) {
          R(str + " span mustn't exceed the " + str + " count");
        }
      }
      return;
      str = "row";
      break;
      paramLayoutParams = paramLayoutParams.afx;
      break label18;
    }
  }
  
  static <T> T[] a(T[] paramArrayOfT1, T[] paramArrayOfT2)
  {
    Object[] arrayOfObject = (Object[])Array.newInstance(paramArrayOfT1.getClass().getComponentType(), paramArrayOfT1.length + paramArrayOfT2.length);
    System.arraycopy(paramArrayOfT1, 0, arrayOfObject, 0, paramArrayOfT1.length);
    System.arraycopy(paramArrayOfT2, 0, arrayOfObject, paramArrayOfT1.length, paramArrayOfT2.length);
    return arrayOfObject;
  }
  
  private int b(View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.aek == 1) {
      return a(paramView, paramBoolean1, paramBoolean2);
    }
    Object localObject;
    if (paramBoolean1)
    {
      localObject = this.aeh;
      if (!paramBoolean2) {
        break label124;
      }
      if (((GridLayout.d)localObject).aeQ == null) {
        ((GridLayout.d)localObject).aeQ = new int[((GridLayout.d)localObject).getCount() + 1];
      }
      if (!((GridLayout.d)localObject).aeR)
      {
        ((GridLayout.d)localObject).ag(true);
        ((GridLayout.d)localObject).aeR = true;
      }
      localObject = ((GridLayout.d)localObject).aeQ;
      label79:
      paramView = (GridLayout.LayoutParams)paramView.getLayoutParams();
      if (!paramBoolean1) {
        break label176;
      }
      paramView = paramView.afy;
      label96:
      if (!paramBoolean2) {
        break label184;
      }
    }
    label176:
    label184:
    for (int i = paramView.aeC.min;; i = paramView.aeC.max)
    {
      return localObject[i];
      localObject = this.aei;
      break;
      label124:
      if (((GridLayout.d)localObject).aeS == null) {
        ((GridLayout.d)localObject).aeS = new int[((GridLayout.d)localObject).getCount() + 1];
      }
      if (!((GridLayout.d)localObject).aeT)
      {
        ((GridLayout.d)localObject).ag(false);
        ((GridLayout.d)localObject).aeT = true;
      }
      localObject = ((GridLayout.d)localObject).aeS;
      break label79;
      paramView = paramView.afx;
      break label96;
    }
  }
  
  static GridLayout.LayoutParams be(View paramView)
  {
    return (GridLayout.LayoutParams)paramView.getLayoutParams();
  }
  
  static boolean by(int paramInt)
  {
    return (paramInt & 0x2) != 0;
  }
  
  private void d(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int j = getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = getChildAt(i);
      GridLayout.LayoutParams localLayoutParams;
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (GridLayout.LayoutParams)localView.getLayoutParams();
        if (!paramBoolean) {
          break label75;
        }
        g(localView, paramInt1, paramInt2, localLayoutParams.width, localLayoutParams.height);
      }
      for (;;)
      {
        i += 1;
        break;
        label75:
        boolean bool;
        label85:
        label97:
        GridLayout.f localf;
        if (this.mOrientation == 0)
        {
          bool = true;
          if (!bool) {
            break label192;
          }
          localObject = localLayoutParams.afy;
          if (((GridLayout.i)localObject).ah(bool) != aey) {
            break label200;
          }
          localf = ((GridLayout.i)localObject).aeC;
          if (!bool) {
            break label202;
          }
        }
        int k;
        label192:
        label200:
        label202:
        for (Object localObject = this.aeh;; localObject = this.aei)
        {
          localObject = ((GridLayout.d)localObject).ib();
          k = localObject[localf.max] - localObject[localf.min] - g(localView, bool);
          if (!bool) {
            break label211;
          }
          g(localView, paramInt1, paramInt2, k, localLayoutParams.height);
          break;
          bool = false;
          break label85;
          localObject = localLayoutParams.afx;
          break label97;
          break;
        }
        label211:
        g(localView, paramInt1, paramInt2, localLayoutParams.width, k);
      }
    }
  }
  
  private void g(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramView.measure(getChildMeasureSpec(paramInt1, g(paramView, true), paramInt3), getChildMeasureSpec(paramInt2, g(paramView, false), paramInt4));
  }
  
  static int h(View paramView, boolean paramBoolean)
  {
    if (paramBoolean) {
      return paramView.getMeasuredWidth();
    }
    return paramView.getMeasuredHeight();
  }
  
  private boolean hJ()
  {
    return t.T(this) == 1;
  }
  
  private void hK()
  {
    this.aem = 0;
    if (this.aeh != null) {
      this.aeh.hK();
    }
    if (this.aei != null) {
      this.aei.hK();
    }
    hL();
  }
  
  private void hL()
  {
    if ((this.aeh != null) && (this.aei != null))
    {
      this.aeh.hL();
      this.aei.hL();
    }
  }
  
  private int hM()
  {
    int i = 1;
    int k = getChildCount();
    int j = 0;
    if (j < k)
    {
      View localView = getChildAt(j);
      if (localView.getVisibility() == 8) {
        break label57;
      }
      i = ((GridLayout.LayoutParams)localView.getLayoutParams()).hashCode() + i * 31;
    }
    label57:
    for (;;)
    {
      j += 1;
      break;
      return i;
    }
  }
  
  private void hN()
  {
    int i2;
    Object localObject;
    label28:
    int i3;
    label45:
    int i;
    int j;
    int[] arrayOfInt;
    int i4;
    GridLayout.LayoutParams localLayoutParams;
    label97:
    GridLayout.f localf;
    boolean bool1;
    int i7;
    label141:
    boolean bool2;
    int i5;
    if (this.aem == 0) {
      if (this.mOrientation == 0)
      {
        i2 = 1;
        if (i2 == 0) {
          break label260;
        }
        localObject = this.aeh;
        if (((GridLayout.d)localObject).aeI == -2147483648) {
          break label269;
        }
        i3 = ((GridLayout.d)localObject).aeI;
        i = 0;
        j = 0;
        arrayOfInt = new int[i3];
        int i6 = getChildCount();
        i4 = 0;
        if (i4 >= i6) {
          break label471;
        }
        localLayoutParams = (GridLayout.LayoutParams)getChildAt(i4).getLayoutParams();
        if (i2 == 0) {
          break label275;
        }
        localObject = localLayoutParams.afx;
        localf = ((GridLayout.i)localObject).aeC;
        bool1 = ((GridLayout.i)localObject).afD;
        i7 = localf.size();
        if (bool1) {
          i = localf.min;
        }
        if (i2 == 0) {
          break label285;
        }
        localObject = localLayoutParams.afy;
        localf = ((GridLayout.i)localObject).aeC;
        bool2 = ((GridLayout.i)localObject).afD;
        i5 = localf.size();
        if (i3 != 0) {
          break label295;
        }
        if (!bool2) {
          break label510;
        }
      }
    }
    label215:
    label358:
    label363:
    label510:
    for (int k = localf.min;; k = j)
    {
      int n = k;
      int i1 = i;
      if (i3 != 0)
      {
        j = k;
        int m = i;
        if (bool1)
        {
          n = k;
          i1 = i;
          if (!bool2)
          {
            m = i;
            j = k;
          }
        }
        else
        {
          for (;;)
          {
            k = j + i5;
            if (k > arrayOfInt.length) {
              i = 0;
            }
            for (;;)
            {
              n = j;
              i1 = m;
              if (i != 0) {
                break label390;
              }
              if (!bool2) {
                break label363;
              }
              m += 1;
              break label215;
              i2 = 0;
              break;
              localObject = this.aei;
              break label28;
              i3 = 0;
              break label45;
              localObject = localLayoutParams.afy;
              break label97;
              localObject = localLayoutParams.afx;
              break label141;
              if (bool2) {}
              for (k = Math.min(localf.min, i3);; k = 0)
              {
                i5 = Math.min(i5, i3 - k);
                break;
              }
              i = j;
              for (;;)
              {
                if (i >= k) {
                  break label358;
                }
                if (arrayOfInt[i] > m)
                {
                  i = 0;
                  break;
                }
                i += 1;
              }
              i = 1;
            }
            if (j + i5 <= i3)
            {
              j += 1;
            }
            else
            {
              j = 0;
              m += 1;
            }
          }
        }
        i = arrayOfInt.length;
        Arrays.fill(arrayOfInt, Math.min(n, i), Math.min(n + i5, i), i1 + i7);
      }
      if (i2 != 0) {
        a(localLayoutParams, i1, i7, n, i5);
      }
      for (;;)
      {
        j = n + i5;
        i4 += 1;
        i = i1;
        break;
        a(localLayoutParams, n, i5, i1, i7);
      }
      this.aem = hM();
      do
      {
        return;
      } while (this.aem == hM());
      this.mPrinter.println("The fields of some layout parameters were modified in between layout operations. Check the javadoc for GridLayout.LayoutParams#rowSpec.");
      hK();
      break;
    }
  }
  
  public static GridLayout.i hO()
  {
    return a(-2147483648, 1, aen, 0.0F);
  }
  
  static int j(int[] paramArrayOfInt)
  {
    int j = -1;
    int i = 0;
    int k = paramArrayOfInt.length;
    while (i < k)
    {
      j = Math.max(j, paramArrayOfInt[i]);
      i += 1;
    }
    return j;
  }
  
  static GridLayout.a j(int paramInt, boolean paramBoolean)
  {
    int i;
    if (paramBoolean)
    {
      i = 7;
      label7:
      if (!paramBoolean) {
        break label86;
      }
    }
    label86:
    for (int j = 0;; j = 4) {
      switch ((i & paramInt) >> j)
      {
      default: 
        return aen;
        i = 112;
        break label7;
      }
    }
    if (paramBoolean) {
      return aeu;
    }
    return aeq;
    if (paramBoolean) {
      return aev;
    }
    return aer;
    return aey;
    return aew;
    return aes;
    return aet;
  }
  
  final int a(View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = (GridLayout.LayoutParams)paramView.getLayoutParams();
    int i;
    if (paramBoolean1) {
      if (paramBoolean2) {
        i = ((GridLayout.LayoutParams)localObject).leftMargin;
      }
    }
    while (i == -2147483648) {
      if (!this.aej)
      {
        return 0;
        i = ((GridLayout.LayoutParams)localObject).rightMargin;
        continue;
        if (paramBoolean2) {
          i = ((GridLayout.LayoutParams)localObject).topMargin;
        } else {
          i = ((GridLayout.LayoutParams)localObject).bottomMargin;
        }
      }
      else
      {
        GridLayout.d locald;
        label95:
        boolean bool;
        if (paramBoolean1)
        {
          localObject = ((GridLayout.LayoutParams)localObject).afy;
          if (!paramBoolean1) {
            break label171;
          }
          locald = this.aeh;
          localObject = ((GridLayout.i)localObject).aeC;
          bool = paramBoolean2;
          if (paramBoolean1)
          {
            bool = paramBoolean2;
            if (hJ())
            {
              if (paramBoolean2) {
                break label180;
              }
              bool = true;
            }
          }
          label126:
          if (!bool) {
            break label186;
          }
          if (((GridLayout.f)localObject).min == 0) {}
        }
        for (;;)
        {
          if ((paramView.getClass() != android.support.v4.widget.Space.class) && (paramView.getClass() != android.widget.Space.class)) {
            break label195;
          }
          return 0;
          localObject = ((GridLayout.LayoutParams)localObject).afx;
          break;
          label171:
          locald = this.aei;
          break label95;
          label180:
          bool = false;
          break label126;
          label186:
          locald.getCount();
        }
        label195:
        return this.ael / 2;
      }
    }
    return i;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if (!(paramLayoutParams instanceof GridLayout.LayoutParams)) {
      return false;
    }
    paramLayoutParams = (GridLayout.LayoutParams)paramLayoutParams;
    a(paramLayoutParams, true);
    a(paramLayoutParams, false);
    return true;
  }
  
  final int g(View paramView, boolean paramBoolean)
  {
    return b(paramView, paramBoolean, true) + b(paramView, paramBoolean, false);
  }
  
  public int getAlignmentMode()
  {
    return this.aek;
  }
  
  public int getColumnCount()
  {
    return this.aeh.getCount();
  }
  
  public int getOrientation()
  {
    return this.mOrientation;
  }
  
  public Printer getPrinter()
  {
    return this.mPrinter;
  }
  
  public int getRowCount()
  {
    return this.aei.getCount();
  }
  
  public boolean getUseDefaultMargins()
  {
    return this.aej;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    hN();
    paramInt3 -= paramInt1;
    int i = getPaddingLeft();
    int j = getPaddingTop();
    int k = getPaddingRight();
    paramInt1 = getPaddingBottom();
    this.aeh.bA(paramInt3 - i - k);
    this.aei.bA(paramInt4 - paramInt2 - j - paramInt1);
    int[] arrayOfInt1 = this.aeh.ib();
    int[] arrayOfInt2 = this.aei.ib();
    paramInt4 = getChildCount();
    paramInt1 = 0;
    if (paramInt1 < paramInt4)
    {
      View localView = getChildAt(paramInt1);
      int m;
      int i1;
      int n;
      int i5;
      int i7;
      int i4;
      int i2;
      if (localView.getVisibility() != 8)
      {
        Object localObject2 = (GridLayout.LayoutParams)localView.getLayoutParams();
        Object localObject1 = ((GridLayout.LayoutParams)localObject2).afy;
        localObject2 = ((GridLayout.LayoutParams)localObject2).afx;
        Object localObject3 = ((GridLayout.i)localObject1).aeC;
        Object localObject4 = ((GridLayout.i)localObject2).aeC;
        paramInt2 = arrayOfInt1[localObject3.min];
        m = arrayOfInt2[localObject4.min];
        i1 = arrayOfInt1[localObject3.max];
        n = arrayOfInt2[localObject4.max];
        i5 = i1 - paramInt2;
        i7 = n - m;
        int i10 = h(localView, true);
        int i8 = h(localView, false);
        localObject1 = ((GridLayout.i)localObject1).ah(true);
        localObject2 = ((GridLayout.i)localObject2).ah(false);
        localObject3 = (GridLayout.e)this.aeh.hV().bC(paramInt1);
        localObject4 = (GridLayout.e)this.aei.hV().bC(paramInt1);
        int i6 = ((GridLayout.a)localObject1).z(localView, i5 - ((GridLayout.e)localObject3).ad(true));
        n = ((GridLayout.a)localObject2).z(localView, i7 - ((GridLayout.e)localObject4).ad(true));
        int i3 = b(localView, true, true);
        i1 = b(localView, false, true);
        i4 = b(localView, true, false);
        i2 = b(localView, false, false);
        int i11 = i3 + i4;
        int i12 = i1 + i2;
        int i9 = ((GridLayout.e)localObject3).a(this, localView, (GridLayout.a)localObject1, i10 + i11, true);
        i2 = ((GridLayout.e)localObject4).a(this, localView, (GridLayout.a)localObject2, i8 + i12, false);
        i5 = ((GridLayout.a)localObject1).S(i10, i5 - i11);
        i7 = ((GridLayout.a)localObject2).S(i8, i7 - i12);
        paramInt2 = i9 + (paramInt2 + i6);
        if (hJ()) {
          break label525;
        }
        paramInt2 += i + i3;
      }
      for (;;)
      {
        m = i2 + (j + m + n) + i1;
        if ((i5 != localView.getMeasuredWidth()) || (i7 != localView.getMeasuredHeight())) {
          localView.measure(View.MeasureSpec.makeMeasureSpec(i5, 1073741824), View.MeasureSpec.makeMeasureSpec(i7, 1073741824));
        }
        localView.layout(paramInt2, m, i5 + paramInt2, i7 + m);
        paramInt1 += 1;
        break;
        label525:
        paramInt2 = paramInt3 - i5 - k - i4 - paramInt2;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    hN();
    hL();
    int m = getPaddingLeft() + getPaddingRight();
    int k = getPaddingTop() + getPaddingBottom();
    int n = Q(paramInt1, -m);
    int i1 = Q(paramInt2, -k);
    d(n, i1, true);
    int j;
    int i;
    if (this.mOrientation == 0)
    {
      j = this.aeh.bz(n);
      d(n, i1, false);
      i = this.aei.bz(i1);
    }
    for (;;)
    {
      j = Math.max(j + m, getSuggestedMinimumWidth());
      i = Math.max(i + k, getSuggestedMinimumHeight());
      setMeasuredDimension(View.resolveSizeAndState(j, paramInt1, 0), View.resolveSizeAndState(i, paramInt2, 0));
      return;
      i = this.aei.bz(i1);
      d(n, i1, false);
      j = this.aeh.bz(n);
    }
  }
  
  public void requestLayout()
  {
    super.requestLayout();
    hK();
  }
  
  public void setAlignmentMode(int paramInt)
  {
    this.aek = paramInt;
    requestLayout();
  }
  
  public void setColumnCount(int paramInt)
  {
    this.aeh.setCount(paramInt);
    hK();
    requestLayout();
  }
  
  public void setColumnOrderPreserved(boolean paramBoolean)
  {
    this.aeh.ae(paramBoolean);
    hK();
    requestLayout();
  }
  
  public void setOrientation(int paramInt)
  {
    if (this.mOrientation != paramInt)
    {
      this.mOrientation = paramInt;
      hK();
      requestLayout();
    }
  }
  
  public void setPrinter(Printer paramPrinter)
  {
    Printer localPrinter = paramPrinter;
    if (paramPrinter == null) {
      localPrinter = aea;
    }
    this.mPrinter = localPrinter;
  }
  
  public void setRowCount(int paramInt)
  {
    this.aei.setCount(paramInt);
    hK();
    requestLayout();
  }
  
  public void setRowOrderPreserved(boolean paramBoolean)
  {
    this.aei.ae(paramBoolean);
    hK();
    requestLayout();
  }
  
  public void setUseDefaultMargins(boolean paramBoolean)
  {
    this.aej = paramBoolean;
    requestLayout();
  }
  
  static final class h<K, V>
  {
    public final K[] afA;
    public final V[] afB;
    public final int[] afz;
    
    h(K[] paramArrayOfK, V[] paramArrayOfV)
    {
      this.afz = c(paramArrayOfK);
      this.afA = a(paramArrayOfK, this.afz);
      this.afB = a(paramArrayOfV, this.afz);
    }
    
    private static <K> K[] a(K[] paramArrayOfK, int[] paramArrayOfInt)
    {
      int j = paramArrayOfK.length;
      Object[] arrayOfObject = (Object[])Array.newInstance(paramArrayOfK.getClass().getComponentType(), GridLayout.j(paramArrayOfInt) + 1);
      int i = 0;
      while (i < j)
      {
        arrayOfObject[paramArrayOfInt[i]] = paramArrayOfK[i];
        i += 1;
      }
      return arrayOfObject;
    }
    
    private static <K> int[] c(K[] paramArrayOfK)
    {
      int j = paramArrayOfK.length;
      int[] arrayOfInt = new int[j];
      HashMap localHashMap = new HashMap();
      int i = 0;
      while (i < j)
      {
        K ? = paramArrayOfK[i];
        Integer localInteger2 = (Integer)localHashMap.get(?);
        Integer localInteger1 = localInteger2;
        if (localInteger2 == null)
        {
          localInteger1 = Integer.valueOf(localHashMap.size());
          localHashMap.put(?, localInteger1);
        }
        arrayOfInt[i] = localInteger1.intValue();
        i += 1;
      }
      return arrayOfInt;
    }
    
    public final V bC(int paramInt)
    {
      return this.afB[this.afz[paramInt]];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.v7.widget.GridLayout
 * JD-Core Version:    0.7.0.1
 */