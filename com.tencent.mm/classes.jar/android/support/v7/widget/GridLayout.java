package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v4.view.u;
import android.support.v4.view.w;
import android.support.v7.e.a.a;
import android.util.AttributeSet;
import android.util.LogPrinter;
import android.util.Printer;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.List<Landroid.support.v7.widget.GridLayout.b;>;

public class GridLayout
  extends ViewGroup
{
  private static final int ORIENTATION;
  public static final a aoA = new a()
  {
    final int B(View paramAnonymousView, int paramAnonymousInt)
    {
      return paramAnonymousInt >> 1;
    }
    
    final String jS()
    {
      return "CENTER";
    }
    
    public final int k(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      return paramAnonymousInt1 >> 1;
    }
  };
  public static final a aoB = new a()
  {
    final int B(View paramAnonymousView, int paramAnonymousInt)
    {
      return 0;
    }
    
    final String jS()
    {
      return "BASELINE";
    }
    
    public final GridLayout.e jT()
    {
      new GridLayout.e()
      {
        private int size;
        
        protected final void U(int paramAnonymous2Int1, int paramAnonymous2Int2)
        {
          super.U(paramAnonymous2Int1, paramAnonymous2Int2);
          this.size = Math.max(this.size, paramAnonymous2Int1 + paramAnonymous2Int2);
        }
        
        protected final int a(GridLayout paramAnonymous2GridLayout, View paramAnonymous2View, GridLayout.a paramAnonymous2a, int paramAnonymous2Int, boolean paramAnonymous2Boolean)
        {
          return Math.max(0, super.a(paramAnonymous2GridLayout, paramAnonymous2View, paramAnonymous2a, paramAnonymous2Int, paramAnonymous2Boolean));
        }
        
        protected final int ai(boolean paramAnonymous2Boolean)
        {
          return Math.max(super.ai(paramAnonymous2Boolean), this.size);
        }
        
        protected final void reset()
        {
          super.reset();
          this.size = -2147483648;
        }
      };
    }
    
    public final int k(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      if (paramAnonymousView.getVisibility() == 8) {
        paramAnonymousInt1 = 0;
      }
      do
      {
        return paramAnonymousInt1;
        paramAnonymousInt2 = paramAnonymousView.getBaseline();
        paramAnonymousInt1 = paramAnonymousInt2;
      } while (paramAnonymousInt2 != -1);
      return -2147483648;
    }
  };
  public static final a aoC = new a()
  {
    final int B(View paramAnonymousView, int paramAnonymousInt)
    {
      return 0;
    }
    
    public final int V(int paramAnonymousInt1, int paramAnonymousInt2)
    {
      return paramAnonymousInt2;
    }
    
    final String jS()
    {
      return "FILL";
    }
    
    public final int k(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      return -2147483648;
    }
  };
  static final Printer aod = new LogPrinter(3, GridLayout.class.getName());
  static final Printer aoe = new Printer()
  {
    public final void println(String paramAnonymousString) {}
  };
  private static final int aof;
  private static final int aog;
  private static final int aoh;
  private static final int aoi;
  private static final int aoj;
  private static final int aok;
  static final a aor;
  private static final a aos;
  private static final a aot;
  public static final a aou;
  public static final a aov;
  public static final a aow;
  public static final a aox;
  public static final a aoy;
  public static final a aoz;
  final d aol = new d(true);
  final d aom = new d(false);
  boolean aon = false;
  int aoo = 1;
  int aop;
  int aoq = 0;
  int mOrientation = 0;
  Printer mPrinter = aod;
  
  static
  {
    ORIENTATION = 3;
    aof = 4;
    aog = 1;
    aoh = 6;
    aoi = 0;
    aoj = 5;
    aok = 2;
    aor = new a()
    {
      final int B(View paramAnonymousView, int paramAnonymousInt)
      {
        return -2147483648;
      }
      
      final String jS()
      {
        return "UNDEFINED";
      }
      
      public final int k(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        return -2147483648;
      }
    };
    aos = new a()
    {
      final int B(View paramAnonymousView, int paramAnonymousInt)
      {
        return 0;
      }
      
      final String jS()
      {
        return "LEADING";
      }
      
      public final int k(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        return 0;
      }
    };
    aot = new a()
    {
      final int B(View paramAnonymousView, int paramAnonymousInt)
      {
        return paramAnonymousInt;
      }
      
      final String jS()
      {
        return "TRAILING";
      }
      
      public final int k(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        return paramAnonymousInt1;
      }
    };
    aou = aos;
    aov = aot;
    aow = aos;
    aox = aot;
    aoy = a(aow, aox);
    aoz = a(aox, aow);
  }
  
  public GridLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public GridLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.aop = paramContext.getResources().getDimensionPixelOffset(2131166127);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.GridLayout);
    try
    {
      setRowCount(paramContext.getInt(aof, -2147483648));
      setColumnCount(paramContext.getInt(aog, -2147483648));
      setOrientation(paramContext.getInt(ORIENTATION, 0));
      setUseDefaultMargins(paramContext.getBoolean(aoh, false));
      setAlignmentMode(paramContext.getInt(aoi, 1));
      setRowOrderPreserved(paramContext.getBoolean(aoj, true));
      setColumnOrderPreserved(paramContext.getBoolean(aok, true));
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  static void F(String paramString)
  {
    throw new IllegalArgumentException(paramString + ". ");
  }
  
  private static int T(int paramInt1, int paramInt2)
  {
    return View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt1 + paramInt2), View.MeasureSpec.getMode(paramInt1));
  }
  
  private static a a(a parama1, final a parama2)
  {
    new a()
    {
      final int B(View paramAnonymousView, int paramAnonymousInt)
      {
        int i = 1;
        if (u.Z(paramAnonymousView) == 1) {
          if (i != 0) {
            break label33;
          }
        }
        label33:
        for (GridLayout.a locala = this.aoD;; locala = parama2)
        {
          return locala.B(paramAnonymousView, paramAnonymousInt);
          i = 0;
          break;
        }
      }
      
      final String jS()
      {
        return "SWITCHING[L:" + this.aoD.jS() + ", R:" + parama2.jS() + "]";
      }
      
      public final int k(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        int i = 1;
        if (u.Z(paramAnonymousView) == 1) {
          if (i != 0) {
            break label37;
          }
        }
        label37:
        for (GridLayout.a locala = this.aoD;; locala = parama2)
        {
          return locala.k(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
          i = 0;
          break;
        }
      }
    };
  }
  
  public static i a(int paramInt1, int paramInt2, a parama, float paramFloat)
  {
    if (paramInt1 != -2147483648) {}
    for (boolean bool = true;; bool = false) {
      return new i(bool, paramInt1, paramInt2, parama, paramFloat);
    }
  }
  
  private static void a(LayoutParams paramLayoutParams, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    f localf = new f(paramInt1, paramInt1 + paramInt2);
    paramLayoutParams.apD = paramLayoutParams.apD.a(localf);
    localf = new f(paramInt3, paramInt3 + paramInt4);
    paramLayoutParams.apE = paramLayoutParams.apE.a(localf);
  }
  
  private void a(LayoutParams paramLayoutParams, boolean paramBoolean)
  {
    String str;
    label18:
    f localf;
    if (paramBoolean)
    {
      str = "column";
      if (!paramBoolean) {
        break label183;
      }
      paramLayoutParams = paramLayoutParams.apE;
      localf = paramLayoutParams.aoG;
      if ((localf.min != -2147483648) && (localf.min < 0)) {
        F(str + " indices must be positive");
      }
      if (!paramBoolean) {
        break label191;
      }
    }
    label183:
    label191:
    for (paramLayoutParams = this.aol;; paramLayoutParams = this.aom)
    {
      int i = paramLayoutParams.aoM;
      if (i != -2147483648)
      {
        if (localf.max > i) {
          F(str + " indices (start + span) mustn't exceed the " + str + " count");
        }
        if (localf.size() > i) {
          F(str + " span mustn't exceed the " + str + " count");
        }
      }
      return;
      str = "row";
      break;
      paramLayoutParams = paramLayoutParams.apD;
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
    if (this.aoo == 1) {
      return a(paramView, paramBoolean1, paramBoolean2);
    }
    Object localObject;
    if (paramBoolean1)
    {
      localObject = this.aol;
      if (!paramBoolean2) {
        break label124;
      }
      if (((d)localObject).aoU == null) {
        ((d)localObject).aoU = new int[((d)localObject).getCount() + 1];
      }
      if (!((d)localObject).aoV)
      {
        ((d)localObject).al(true);
        ((d)localObject).aoV = true;
      }
      localObject = ((d)localObject).aoU;
      label79:
      paramView = (LayoutParams)paramView.getLayoutParams();
      if (!paramBoolean1) {
        break label176;
      }
      paramView = paramView.apE;
      label96:
      if (!paramBoolean2) {
        break label184;
      }
    }
    label176:
    label184:
    for (int i = paramView.aoG.min;; i = paramView.aoG.max)
    {
      return localObject[i];
      localObject = this.aom;
      break;
      label124:
      if (((d)localObject).aoW == null) {
        ((d)localObject).aoW = new int[((d)localObject).getCount() + 1];
      }
      if (!((d)localObject).aoX)
      {
        ((d)localObject).al(false);
        ((d)localObject).aoX = true;
      }
      localObject = ((d)localObject).aoW;
      break label79;
      paramView = paramView.apD;
      break label96;
    }
  }
  
  static boolean bQ(int paramInt)
  {
    return (paramInt & 0x2) != 0;
  }
  
  static LayoutParams bl(View paramView)
  {
    return (LayoutParams)paramView.getLayoutParams();
  }
  
  private void d(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int j = getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = getChildAt(i);
      LayoutParams localLayoutParams;
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
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
        f localf;
        if (this.mOrientation == 0)
        {
          bool = true;
          if (!bool) {
            break label192;
          }
          localObject = localLayoutParams.apE;
          if (((i)localObject).am(bool) != aoC) {
            break label200;
          }
          localf = ((i)localObject).aoG;
          if (!bool) {
            break label202;
          }
        }
        int k;
        label192:
        label200:
        label202:
        for (Object localObject = this.aol;; localObject = this.aom)
        {
          localObject = ((d)localObject).ke();
          k = localObject[localf.max] - localObject[localf.min] - g(localView, bool);
          if (!bool) {
            break label211;
          }
          g(localView, paramInt1, paramInt2, k, localLayoutParams.height);
          break;
          bool = false;
          break label85;
          localObject = localLayoutParams.apD;
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
  
  static a j(int paramInt, boolean paramBoolean)
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
        return aor;
        i = 112;
        break label7;
      }
    }
    if (paramBoolean) {
      return aoy;
    }
    return aou;
    if (paramBoolean) {
      return aoz;
    }
    return aov;
    return aoC;
    return aoA;
    return aow;
    return aox;
  }
  
  private boolean jM()
  {
    return u.Z(this) == 1;
  }
  
  private void jN()
  {
    this.aoq = 0;
    if (this.aol != null) {
      this.aol.jN();
    }
    if (this.aom != null) {
      this.aom.jN();
    }
    jO();
  }
  
  private void jO()
  {
    if ((this.aol != null) && (this.aom != null))
    {
      this.aol.jO();
      this.aom.jO();
    }
  }
  
  private int jP()
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
      i = ((LayoutParams)localView.getLayoutParams()).hashCode() + i * 31;
    }
    label57:
    for (;;)
    {
      j += 1;
      break;
      return i;
    }
  }
  
  private void jQ()
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
    LayoutParams localLayoutParams;
    label97:
    f localf;
    boolean bool1;
    int i7;
    label141:
    boolean bool2;
    int i5;
    if (this.aoq == 0) {
      if (this.mOrientation == 0)
      {
        i2 = 1;
        if (i2 == 0) {
          break label260;
        }
        localObject = this.aol;
        if (((d)localObject).aoM == -2147483648) {
          break label269;
        }
        i3 = ((d)localObject).aoM;
        i = 0;
        j = 0;
        arrayOfInt = new int[i3];
        int i6 = getChildCount();
        i4 = 0;
        if (i4 >= i6) {
          break label471;
        }
        localLayoutParams = (LayoutParams)getChildAt(i4).getLayoutParams();
        if (i2 == 0) {
          break label275;
        }
        localObject = localLayoutParams.apD;
        localf = ((i)localObject).aoG;
        bool1 = ((i)localObject).apJ;
        i7 = localf.size();
        if (bool1) {
          i = localf.min;
        }
        if (i2 == 0) {
          break label285;
        }
        localObject = localLayoutParams.apE;
        localf = ((i)localObject).aoG;
        bool2 = ((i)localObject).apJ;
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
              localObject = this.aom;
              break label28;
              i3 = 0;
              break label45;
              localObject = localLayoutParams.apE;
              break label97;
              localObject = localLayoutParams.apD;
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
      this.aoq = jP();
      do
      {
        return;
      } while (this.aoq == jP());
      this.mPrinter.println("The fields of some layout parameters were modified in between layout operations. Check the javadoc for GridLayout.LayoutParams#rowSpec.");
      jN();
      break;
    }
  }
  
  public static i jR()
  {
    return a(-2147483648, 1, aor, 0.0F);
  }
  
  final int a(View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = (LayoutParams)paramView.getLayoutParams();
    int i;
    if (paramBoolean1) {
      if (paramBoolean2) {
        i = ((LayoutParams)localObject).leftMargin;
      }
    }
    while (i == -2147483648) {
      if (!this.aon)
      {
        return 0;
        i = ((LayoutParams)localObject).rightMargin;
        continue;
        if (paramBoolean2) {
          i = ((LayoutParams)localObject).topMargin;
        } else {
          i = ((LayoutParams)localObject).bottomMargin;
        }
      }
      else
      {
        d locald;
        label95:
        boolean bool;
        if (paramBoolean1)
        {
          localObject = ((LayoutParams)localObject).apE;
          if (!paramBoolean1) {
            break label171;
          }
          locald = this.aol;
          localObject = ((i)localObject).aoG;
          bool = paramBoolean2;
          if (paramBoolean1)
          {
            bool = paramBoolean2;
            if (jM())
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
          if (((f)localObject).min == 0) {}
        }
        for (;;)
        {
          if ((paramView.getClass() != android.support.v4.widget.Space.class) && (paramView.getClass() != android.widget.Space.class)) {
            break label195;
          }
          return 0;
          localObject = ((LayoutParams)localObject).apD;
          break;
          label171:
          locald = this.aom;
          break label95;
          label180:
          bool = false;
          break label126;
          label186:
          locald.getCount();
        }
        label195:
        return this.aop / 2;
      }
    }
    return i;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if (!(paramLayoutParams instanceof LayoutParams)) {
      return false;
    }
    paramLayoutParams = (LayoutParams)paramLayoutParams;
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
    return this.aoo;
  }
  
  public int getColumnCount()
  {
    return this.aol.getCount();
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
    return this.aom.getCount();
  }
  
  public boolean getUseDefaultMargins()
  {
    return this.aon;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    jQ();
    paramInt3 -= paramInt1;
    int i = getPaddingLeft();
    int j = getPaddingTop();
    int k = getPaddingRight();
    paramInt1 = getPaddingBottom();
    this.aol.bS(paramInt3 - i - k);
    this.aom.bS(paramInt4 - paramInt2 - j - paramInt1);
    int[] arrayOfInt1 = this.aol.ke();
    int[] arrayOfInt2 = this.aom.ke();
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
        Object localObject2 = (LayoutParams)localView.getLayoutParams();
        Object localObject1 = ((LayoutParams)localObject2).apE;
        localObject2 = ((LayoutParams)localObject2).apD;
        Object localObject3 = ((i)localObject1).aoG;
        Object localObject4 = ((i)localObject2).aoG;
        paramInt2 = arrayOfInt1[localObject3.min];
        m = arrayOfInt2[localObject4.min];
        i1 = arrayOfInt1[localObject3.max];
        n = arrayOfInt2[localObject4.max];
        i5 = i1 - paramInt2;
        i7 = n - m;
        int i10 = h(localView, true);
        int i8 = h(localView, false);
        localObject1 = ((i)localObject1).am(true);
        localObject2 = ((i)localObject2).am(false);
        localObject3 = (e)this.aol.jY().bU(paramInt1);
        localObject4 = (e)this.aom.jY().bU(paramInt1);
        int i6 = ((a)localObject1).B(localView, i5 - ((e)localObject3).ai(true));
        n = ((a)localObject2).B(localView, i7 - ((e)localObject4).ai(true));
        int i3 = b(localView, true, true);
        i1 = b(localView, false, true);
        i4 = b(localView, true, false);
        i2 = b(localView, false, false);
        int i11 = i3 + i4;
        int i12 = i1 + i2;
        int i9 = ((e)localObject3).a(this, localView, (a)localObject1, i10 + i11, true);
        i2 = ((e)localObject4).a(this, localView, (a)localObject2, i8 + i12, false);
        i5 = ((a)localObject1).V(i10, i5 - i11);
        i7 = ((a)localObject2).V(i8, i7 - i12);
        paramInt2 = i9 + (paramInt2 + i6);
        if (jM()) {
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
    jQ();
    jO();
    int m = getPaddingLeft() + getPaddingRight();
    int k = getPaddingTop() + getPaddingBottom();
    int n = T(paramInt1, -m);
    int i1 = T(paramInt2, -k);
    d(n, i1, true);
    int j;
    int i;
    if (this.mOrientation == 0)
    {
      j = this.aol.bR(n);
      d(n, i1, false);
      i = this.aom.bR(i1);
    }
    for (;;)
    {
      j = Math.max(j + m, getSuggestedMinimumWidth());
      i = Math.max(i + k, getSuggestedMinimumHeight());
      setMeasuredDimension(View.resolveSizeAndState(j, paramInt1, 0), View.resolveSizeAndState(i, paramInt2, 0));
      return;
      i = this.aom.bR(i1);
      d(n, i1, false);
      j = this.aol.bR(n);
    }
  }
  
  public void requestLayout()
  {
    super.requestLayout();
    jN();
  }
  
  public void setAlignmentMode(int paramInt)
  {
    this.aoo = paramInt;
    requestLayout();
  }
  
  public void setColumnCount(int paramInt)
  {
    this.aol.setCount(paramInt);
    jN();
    requestLayout();
  }
  
  public void setColumnOrderPreserved(boolean paramBoolean)
  {
    this.aol.aj(paramBoolean);
    jN();
    requestLayout();
  }
  
  public void setOrientation(int paramInt)
  {
    if (this.mOrientation != paramInt)
    {
      this.mOrientation = paramInt;
      jN();
      requestLayout();
    }
  }
  
  public void setPrinter(Printer paramPrinter)
  {
    Printer localPrinter = paramPrinter;
    if (paramPrinter == null) {
      localPrinter = aoe;
    }
    this.mPrinter = localPrinter;
  }
  
  public void setRowCount(int paramInt)
  {
    this.aom.setCount(paramInt);
    jN();
    requestLayout();
  }
  
  public void setRowOrderPreserved(boolean paramBoolean)
  {
    this.aom.aj(paramBoolean);
    jN();
    requestLayout();
  }
  
  public void setUseDefaultMargins(boolean paramBoolean)
  {
    this.aon = paramBoolean;
    requestLayout();
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    private static final int BOTTOM_MARGIN;
    private static final int LEFT_MARGIN;
    private static final int RIGHT_MARGIN;
    private static final int TOP_MARGIN;
    private static final int apA = 12;
    private static final int apB = 13;
    private static final int apC = 10;
    private static final GridLayout.f apt;
    private static final int apu;
    private static final int apv;
    private static final int apw;
    private static final int apx;
    private static final int apy;
    private static final int apz;
    public GridLayout.i apD = GridLayout.i.apI;
    public GridLayout.i apE = GridLayout.i.apI;
    
    static
    {
      GridLayout.f localf = new GridLayout.f(-2147483648, -2147483647);
      apt = localf;
      apu = localf.size();
      apv = 2;
      LEFT_MARGIN = 3;
      TOP_MARGIN = 4;
      RIGHT_MARGIN = 5;
      BOTTOM_MARGIN = 6;
      apw = 7;
      apx = 8;
      apy = 9;
      apz = 11;
    }
    
    public LayoutParams()
    {
      this(locali, locali, (byte)0);
    }
    
    /* Error */
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_1
      //   2: aload_2
      //   3: invokespecial 80	android/view/ViewGroup$MarginLayoutParams:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;)V
      //   6: aload_0
      //   7: getstatic 74	android/support/v7/widget/GridLayout$i:apI	Landroid/support/v7/widget/GridLayout$i;
      //   10: putfield 82	android/support/v7/widget/GridLayout$LayoutParams:apD	Landroid/support/v7/widget/GridLayout$i;
      //   13: aload_0
      //   14: getstatic 74	android/support/v7/widget/GridLayout$i:apI	Landroid/support/v7/widget/GridLayout$i;
      //   17: putfield 84	android/support/v7/widget/GridLayout$LayoutParams:apE	Landroid/support/v7/widget/GridLayout$i;
      //   20: aload_1
      //   21: aload_2
      //   22: getstatic 90	android/support/v7/e/a$a:GridLayout_Layout	[I
      //   25: invokevirtual 96	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;
      //   28: astore 7
      //   30: aload 7
      //   32: getstatic 46	android/support/v7/widget/GridLayout$LayoutParams:apv	I
      //   35: ldc 31
      //   37: invokevirtual 102	android/content/res/TypedArray:getDimensionPixelSize	(II)I
      //   40: istore 4
      //   42: aload_0
      //   43: aload 7
      //   45: getstatic 48	android/support/v7/widget/GridLayout$LayoutParams:LEFT_MARGIN	I
      //   48: iload 4
      //   50: invokevirtual 102	android/content/res/TypedArray:getDimensionPixelSize	(II)I
      //   53: putfield 105	android/support/v7/widget/GridLayout$LayoutParams:leftMargin	I
      //   56: aload_0
      //   57: aload 7
      //   59: getstatic 50	android/support/v7/widget/GridLayout$LayoutParams:TOP_MARGIN	I
      //   62: iload 4
      //   64: invokevirtual 102	android/content/res/TypedArray:getDimensionPixelSize	(II)I
      //   67: putfield 108	android/support/v7/widget/GridLayout$LayoutParams:topMargin	I
      //   70: aload_0
      //   71: aload 7
      //   73: getstatic 52	android/support/v7/widget/GridLayout$LayoutParams:RIGHT_MARGIN	I
      //   76: iload 4
      //   78: invokevirtual 102	android/content/res/TypedArray:getDimensionPixelSize	(II)I
      //   81: putfield 111	android/support/v7/widget/GridLayout$LayoutParams:rightMargin	I
      //   84: aload_0
      //   85: aload 7
      //   87: getstatic 54	android/support/v7/widget/GridLayout$LayoutParams:BOTTOM_MARGIN	I
      //   90: iload 4
      //   92: invokevirtual 102	android/content/res/TypedArray:getDimensionPixelSize	(II)I
      //   95: putfield 114	android/support/v7/widget/GridLayout$LayoutParams:bottomMargin	I
      //   98: aload 7
      //   100: invokevirtual 117	android/content/res/TypedArray:recycle	()V
      //   103: aload_1
      //   104: aload_2
      //   105: getstatic 90	android/support/v7/e/a$a:GridLayout_Layout	[I
      //   108: invokevirtual 96	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;
      //   111: astore_1
      //   112: aload_1
      //   113: getstatic 68	android/support/v7/widget/GridLayout$LayoutParams:apC	I
      //   116: iconst_0
      //   117: invokevirtual 120	android/content/res/TypedArray:getInt	(II)I
      //   120: istore 4
      //   122: aload_1
      //   123: getstatic 56	android/support/v7/widget/GridLayout$LayoutParams:apw	I
      //   126: ldc 31
      //   128: invokevirtual 120	android/content/res/TypedArray:getInt	(II)I
      //   131: istore 5
      //   133: aload_1
      //   134: getstatic 58	android/support/v7/widget/GridLayout$LayoutParams:apx	I
      //   137: getstatic 44	android/support/v7/widget/GridLayout$LayoutParams:apu	I
      //   140: invokevirtual 120	android/content/res/TypedArray:getInt	(II)I
      //   143: istore 6
      //   145: aload_1
      //   146: getstatic 60	android/support/v7/widget/GridLayout$LayoutParams:apy	I
      //   149: fconst_0
      //   150: invokevirtual 124	android/content/res/TypedArray:getFloat	(IF)F
      //   153: fstore_3
      //   154: aload_0
      //   155: iload 5
      //   157: iload 6
      //   159: iload 4
      //   161: iconst_1
      //   162: invokestatic 128	android/support/v7/widget/GridLayout:j	(IZ)Landroid/support/v7/widget/GridLayout$a;
      //   165: fload_3
      //   166: invokestatic 132	android/support/v7/widget/GridLayout:a	(IILandroid/support/v7/widget/GridLayout$a;F)Landroid/support/v7/widget/GridLayout$i;
      //   169: putfield 84	android/support/v7/widget/GridLayout$LayoutParams:apE	Landroid/support/v7/widget/GridLayout$i;
      //   172: aload_1
      //   173: getstatic 62	android/support/v7/widget/GridLayout$LayoutParams:apz	I
      //   176: ldc 31
      //   178: invokevirtual 120	android/content/res/TypedArray:getInt	(II)I
      //   181: istore 5
      //   183: aload_1
      //   184: getstatic 64	android/support/v7/widget/GridLayout$LayoutParams:apA	I
      //   187: getstatic 44	android/support/v7/widget/GridLayout$LayoutParams:apu	I
      //   190: invokevirtual 120	android/content/res/TypedArray:getInt	(II)I
      //   193: istore 6
      //   195: aload_1
      //   196: getstatic 66	android/support/v7/widget/GridLayout$LayoutParams:apB	I
      //   199: fconst_0
      //   200: invokevirtual 124	android/content/res/TypedArray:getFloat	(IF)F
      //   203: fstore_3
      //   204: aload_0
      //   205: iload 5
      //   207: iload 6
      //   209: iload 4
      //   211: iconst_0
      //   212: invokestatic 128	android/support/v7/widget/GridLayout:j	(IZ)Landroid/support/v7/widget/GridLayout$a;
      //   215: fload_3
      //   216: invokestatic 132	android/support/v7/widget/GridLayout:a	(IILandroid/support/v7/widget/GridLayout$a;F)Landroid/support/v7/widget/GridLayout$i;
      //   219: putfield 82	android/support/v7/widget/GridLayout$LayoutParams:apD	Landroid/support/v7/widget/GridLayout$i;
      //   222: aload_1
      //   223: invokevirtual 117	android/content/res/TypedArray:recycle	()V
      //   226: return
      //   227: astore_1
      //   228: aload 7
      //   230: invokevirtual 117	android/content/res/TypedArray:recycle	()V
      //   233: aload_1
      //   234: athrow
      //   235: astore_2
      //   236: aload_1
      //   237: invokevirtual 117	android/content/res/TypedArray:recycle	()V
      //   240: aload_2
      //   241: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	242	0	this	LayoutParams
      //   0	242	1	paramContext	Context
      //   0	242	2	paramAttributeSet	AttributeSet
      //   153	63	3	f	float
      //   40	170	4	i	int
      //   131	75	5	j	int
      //   143	65	6	k	int
      //   28	201	7	localTypedArray	TypedArray
      // Exception table:
      //   from	to	target	type
      //   30	98	227	finally
      //   112	222	235	finally
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      this.apD = paramLayoutParams.apD;
      this.apE = paramLayoutParams.apE;
    }
    
    private LayoutParams(GridLayout.i parami1, GridLayout.i parami2)
    {
      super(-2);
      setMargins(-2147483648, -2147483648, -2147483648, -2147483648);
      this.apD = parami1;
      this.apE = parami2;
    }
    
    private LayoutParams(GridLayout.i parami1, GridLayout.i parami2, byte paramByte)
    {
      this(parami1, parami2);
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass())) {
          return false;
        }
        paramObject = (LayoutParams)paramObject;
        if (!this.apE.equals(paramObject.apE)) {
          return false;
        }
      } while (this.apD.equals(paramObject.apD));
      return false;
    }
    
    public int hashCode()
    {
      return this.apD.hashCode() * 31 + this.apE.hashCode();
    }
    
    protected void setBaseAttributes(TypedArray paramTypedArray, int paramInt1, int paramInt2)
    {
      this.width = paramTypedArray.getLayoutDimension(paramInt1, -2);
      this.height = paramTypedArray.getLayoutDimension(paramInt2, -2);
    }
  }
  
  public static abstract class a
  {
    abstract int B(View paramView, int paramInt);
    
    int V(int paramInt1, int paramInt2)
    {
      return paramInt1;
    }
    
    abstract String jS();
    
    GridLayout.e jT()
    {
      return new GridLayout.e();
    }
    
    abstract int k(View paramView, int paramInt1, int paramInt2);
    
    public String toString()
    {
      return "Alignment:" + jS();
    }
  }
  
  static final class b
  {
    public final GridLayout.f aoG;
    public final GridLayout.g aoH;
    public boolean aoI = true;
    
    public b(GridLayout.f paramf, GridLayout.g paramg)
    {
      this.aoG = paramf;
      this.aoH = paramg;
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder().append(this.aoG).append(" ");
      if (!this.aoI) {}
      for (String str = "+>";; str = "->") {
        return str + " " + this.aoH;
      }
    }
  }
  
  final class d
  {
    public final boolean aoL;
    public int aoM = -2147483648;
    private int aoN = -2147483648;
    GridLayout.h<GridLayout.i, GridLayout.e> aoO;
    public boolean aoP = false;
    GridLayout.h<GridLayout.f, GridLayout.g> aoQ;
    public boolean aoR = false;
    GridLayout.h<GridLayout.f, GridLayout.g> aoS;
    public boolean aoT = false;
    public int[] aoU;
    public boolean aoV = false;
    public int[] aoW;
    public boolean aoX = false;
    public GridLayout.b[] aoY;
    public boolean aoZ = false;
    public int[] apa;
    public boolean apb = false;
    public boolean apc;
    public boolean apd = false;
    public int[] ape;
    boolean apf = true;
    private GridLayout.g apg = new GridLayout.g(0);
    private GridLayout.g aph = new GridLayout.g(-100000);
    
    static
    {
      if (!GridLayout.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        return;
      }
    }
    
    d(boolean paramBoolean)
    {
      this.aoL = paramBoolean;
    }
    
    private void W(int paramInt1, int paramInt2)
    {
      this.apg.value = paramInt1;
      this.aph.value = (-paramInt2);
      this.apb = false;
    }
    
    private int X(int paramInt1, int paramInt2)
    {
      W(paramInt1, paramInt2);
      return ke()[getCount()];
    }
    
    private void a(GridLayout.h<GridLayout.f, GridLayout.g> paramh, boolean paramBoolean)
    {
      int j = 0;
      Object localObject = (GridLayout.g[])paramh.apH;
      int i = 0;
      while (i < localObject.length)
      {
        localObject[i].value = -2147483648;
        i += 1;
      }
      localObject = (GridLayout.e[])jY().apH;
      i = j;
      if (i < localObject.length)
      {
        j = localObject[i].ai(paramBoolean);
        GridLayout.g localg = (GridLayout.g)paramh.bU(i);
        int k = localg.value;
        if (paramBoolean) {}
        for (;;)
        {
          localg.value = Math.max(k, j);
          i += 1;
          break;
          j = -j;
        }
      }
    }
    
    private static void a(List<GridLayout.b> paramList, GridLayout.f paramf, GridLayout.g paramg)
    {
      a(paramList, paramf, paramg, true);
    }
    
    private static void a(List<GridLayout.b> paramList, GridLayout.f paramf, GridLayout.g paramg, boolean paramBoolean)
    {
      if (paramf.size() == 0) {
        return;
      }
      if (paramBoolean)
      {
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext()) {
          if (((GridLayout.b)localIterator.next()).aoG.equals(paramf)) {
            return;
          }
        }
      }
      paramList.add(new GridLayout.b(paramf, paramg));
    }
    
    private static void a(List<GridLayout.b> paramList, GridLayout.h<GridLayout.f, GridLayout.g> paramh)
    {
      int i = 0;
      while (i < ((GridLayout.f[])paramh.apG).length)
      {
        a(paramList, ((GridLayout.f[])paramh.apG)[i], ((GridLayout.g[])paramh.apH)[i], false);
        i += 1;
      }
    }
    
    private static boolean a(int[] paramArrayOfInt, GridLayout.b paramb)
    {
      if (!paramb.aoI) {}
      int j;
      int i;
      do
      {
        return false;
        GridLayout.f localf = paramb.aoG;
        j = localf.min;
        i = localf.max;
        int k = paramb.aoH.value;
        j = paramArrayOfInt[j] + k;
      } while (j <= paramArrayOfInt[i]);
      paramArrayOfInt[i] = j;
      return true;
    }
    
    private boolean a(GridLayout.b[] paramArrayOfb, int[] paramArrayOfInt, boolean paramBoolean)
    {
      boolean bool3 = false;
      int n = 0;
      if (this.aoL) {}
      int i1;
      Object localObject1;
      int i;
      int k;
      boolean bool1;
      for (String str = "horizontal";; str = "vertical")
      {
        i1 = getCount() + 1;
        localObject1 = null;
        i = 0;
        if (i >= paramArrayOfb.length) {
          break label412;
        }
        Arrays.fill(paramArrayOfInt, 0);
        j = 0;
        if (j >= i1) {
          break label261;
        }
        int i2 = paramArrayOfb.length;
        k = 0;
        bool1 = false;
        while (k < i2)
        {
          bool1 |= a(paramArrayOfInt, paramArrayOfb[k]);
          k += 1;
        }
      }
      GridLayout.b localb;
      boolean bool2;
      if (!bool1)
      {
        if (localObject1 != null)
        {
          paramArrayOfInt = new ArrayList();
          localObject2 = new ArrayList();
          i = n;
          while (i < paramArrayOfb.length)
          {
            localb = paramArrayOfb[i];
            if (localObject1[i] != 0) {
              paramArrayOfInt.add(localb);
            }
            if (!localb.aoI) {
              ((List)localObject2).add(localb);
            }
            i += 1;
          }
          GridLayout.this.mPrinter.println(str + " constraints: " + p(paramArrayOfInt) + " are inconsistent; permanently removing: " + p((List)localObject2) + ". ");
        }
        bool2 = true;
      }
      label261:
      do
      {
        return bool2;
        j += 1;
        break;
        bool2 = bool3;
      } while (!paramBoolean);
      Object localObject2 = new boolean[paramArrayOfb.length];
      int j = 0;
      while (j < i1)
      {
        int m = paramArrayOfb.length;
        k = 0;
        while (k < m)
        {
          localObject2[k] |= a(paramArrayOfInt, paramArrayOfb[k]);
          k += 1;
        }
        j += 1;
      }
      if (i == 0) {
        localObject1 = localObject2;
      }
      j = 0;
      for (;;)
      {
        if (j < paramArrayOfb.length)
        {
          if (localObject2[j] != 0)
          {
            localb = paramArrayOfb[j];
            if (localb.aoG.min >= localb.aoG.max) {
              localb.aoI = false;
            }
          }
        }
        else
        {
          i += 1;
          break;
        }
        j += 1;
      }
      label412:
      return true;
    }
    
    private GridLayout.h<GridLayout.f, GridLayout.g> ak(boolean paramBoolean)
    {
      GridLayout.c localc = GridLayout.c.a(GridLayout.f.class, GridLayout.g.class);
      GridLayout.i[] arrayOfi = (GridLayout.i[])jY().apG;
      int j = arrayOfi.length;
      int i = 0;
      if (i < j)
      {
        if (paramBoolean) {}
        for (GridLayout.f localf = arrayOfi[i].aoG;; localf = new GridLayout.f(localf.max, localf.min))
        {
          localc.f(localf, new GridLayout.g());
          i += 1;
          break;
          localf = arrayOfi[i].aoG;
        }
      }
      return localc.jU();
    }
    
    private void f(int paramInt, float paramFloat)
    {
      Arrays.fill(this.ape, 0);
      int k = GridLayout.this.getChildCount();
      int j = 0;
      int i = paramInt;
      paramInt = j;
      Object localObject;
      if (paramInt < k)
      {
        localObject = GridLayout.this.getChildAt(paramInt);
        if (((View)localObject).getVisibility() == 8) {
          break label134;
        }
        localObject = GridLayout.bl((View)localObject);
        if (this.aoL)
        {
          localObject = ((GridLayout.LayoutParams)localObject).apE;
          label73:
          float f = ((GridLayout.i)localObject).weight;
          if (f == 0.0F) {
            break label134;
          }
          j = Math.round(i * f / paramFloat);
          this.ape[paramInt] = j;
          i -= j;
          paramFloat -= f;
        }
      }
      label134:
      for (;;)
      {
        paramInt += 1;
        break;
        localObject = ((GridLayout.LayoutParams)localObject).apD;
        break label73;
        return;
      }
    }
    
    private int jV()
    {
      int i;
      if (this.aoN == -2147483648)
      {
        int k = GridLayout.this.getChildCount();
        int j = 0;
        i = -1;
        if (j < k)
        {
          Object localObject = GridLayout.bl(GridLayout.this.getChildAt(j));
          if (this.aoL) {}
          for (localObject = ((GridLayout.LayoutParams)localObject).apE;; localObject = ((GridLayout.LayoutParams)localObject).apD)
          {
            localObject = ((GridLayout.i)localObject).aoG;
            i = Math.max(Math.max(Math.max(i, ((GridLayout.f)localObject).min), ((GridLayout.f)localObject).max), ((GridLayout.f)localObject).size());
            j += 1;
            break;
          }
        }
        if (i != -1) {
          break label125;
        }
        i = -2147483648;
      }
      label125:
      for (;;)
      {
        this.aoN = Math.max(0, i);
        return this.aoN;
      }
    }
    
    private GridLayout.h<GridLayout.i, GridLayout.e> jW()
    {
      GridLayout.c localc = GridLayout.c.a(GridLayout.i.class, GridLayout.e.class);
      int j = GridLayout.this.getChildCount();
      int i = 0;
      if (i < j)
      {
        Object localObject = GridLayout.bl(GridLayout.this.getChildAt(i));
        if (this.aoL) {}
        for (localObject = ((GridLayout.LayoutParams)localObject).apE;; localObject = ((GridLayout.LayoutParams)localObject).apD)
        {
          localc.f(localObject, ((GridLayout.i)localObject).am(this.aoL).jT());
          i += 1;
          break;
        }
      }
      return localc.jU();
    }
    
    private void jX()
    {
      Object localObject = (GridLayout.e[])this.aoO.apH;
      int i = 0;
      while (i < localObject.length)
      {
        localObject[i].reset();
        i += 1;
      }
      int m = GridLayout.this.getChildCount();
      i = 0;
      if (i < m)
      {
        View localView = GridLayout.this.getChildAt(i);
        localObject = GridLayout.bl(localView);
        label83:
        GridLayout localGridLayout;
        boolean bool;
        int j;
        if (this.aoL)
        {
          localObject = ((GridLayout.LayoutParams)localObject).apE;
          localGridLayout = GridLayout.this;
          bool = this.aoL;
          if (localView.getVisibility() != 8) {
            break label162;
          }
          j = 0;
          label107:
          if (((GridLayout.i)localObject).weight != 0.0F) {
            break label185;
          }
        }
        label162:
        label185:
        for (int k = 0;; k = kd()[i])
        {
          ((GridLayout.e)this.aoO.bU(i)).a(GridLayout.this, localView, (GridLayout.i)localObject, this, j + k);
          i += 1;
          break;
          localObject = ((GridLayout.LayoutParams)localObject).apD;
          break label83;
          j = GridLayout.h(localView, bool);
          j = localGridLayout.g(localView, bool) + j;
          break label107;
        }
      }
    }
    
    private GridLayout.h<GridLayout.f, GridLayout.g> jZ()
    {
      if (this.aoQ == null) {
        this.aoQ = ak(true);
      }
      if (!this.aoR)
      {
        a(this.aoQ, true);
        this.aoR = true;
      }
      return this.aoQ;
    }
    
    private boolean k(int[] paramArrayOfInt)
    {
      return a(kc(), paramArrayOfInt, true);
    }
    
    private GridLayout.h<GridLayout.f, GridLayout.g> ka()
    {
      if (this.aoS == null) {
        this.aoS = ak(false);
      }
      if (!this.aoT)
      {
        a(this.aoS, false);
        this.aoT = true;
      }
      return this.aoS;
    }
    
    private void kb()
    {
      jZ();
      ka();
    }
    
    private GridLayout.b[] kc()
    {
      if (this.aoY == null)
      {
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        a(localArrayList1, jZ());
        a(localArrayList2, ka());
        if (this.apf)
        {
          i = 0;
          while (i < getCount())
          {
            a(localArrayList1, new GridLayout.f(i, i + 1), new GridLayout.g(0));
            i += 1;
          }
        }
        int i = getCount();
        a(localArrayList1, new GridLayout.f(0, i), this.apg, false);
        a(localArrayList2, new GridLayout.f(i, 0), this.aph, false);
        this.aoY = ((GridLayout.b[])GridLayout.a(o(localArrayList1), o(localArrayList2)));
      }
      if (!this.aoZ)
      {
        kb();
        this.aoZ = true;
      }
      return this.aoY;
    }
    
    private int[] kd()
    {
      if (this.ape == null) {
        this.ape = new int[GridLayout.this.getChildCount()];
      }
      return this.ape;
    }
    
    private void l(int[] paramArrayOfInt)
    {
      float f = 0.0F;
      boolean bool2 = true;
      int n = 0;
      int j;
      int i;
      Object localObject;
      label73:
      boolean bool1;
      if (!this.apd)
      {
        j = GridLayout.this.getChildCount();
        i = 0;
        if (i >= j) {
          break label168;
        }
        localObject = GridLayout.this.getChildAt(i);
        if (((View)localObject).getVisibility() == 8) {
          break label161;
        }
        localObject = GridLayout.bl((View)localObject);
        if (this.aoL)
        {
          localObject = ((GridLayout.LayoutParams)localObject).apE;
          if (((GridLayout.i)localObject).weight == 0.0F) {
            break label161;
          }
          bool1 = true;
          label86:
          this.apc = bool1;
          this.apd = true;
        }
      }
      else
      {
        if (this.apc) {
          break label174;
        }
        k(paramArrayOfInt);
      }
      label110:
      int k;
      for (;;)
      {
        if (!this.apf)
        {
          j = paramArrayOfInt[0];
          k = paramArrayOfInt.length;
          i = n;
          for (;;)
          {
            label271:
            if (i < k)
            {
              paramArrayOfInt[i] -= j;
              i += 1;
              continue;
              localObject = ((GridLayout.LayoutParams)localObject).apD;
              break label73;
              label161:
              i += 1;
              break;
              label168:
              bool1 = false;
              break label86;
              label174:
              Arrays.fill(kd(), 0);
              k(paramArrayOfInt);
              j = this.apg.value * GridLayout.this.getChildCount() + 1;
              if (j < 2) {
                break label110;
              }
              k = GridLayout.this.getChildCount();
              i = 0;
              label224:
              if (i < k)
              {
                localObject = GridLayout.this.getChildAt(i);
                if (((View)localObject).getVisibility() == 8) {
                  break label410;
                }
                localObject = GridLayout.bl((View)localObject);
                if (this.aoL)
                {
                  localObject = ((GridLayout.LayoutParams)localObject).apE;
                  f = ((GridLayout.i)localObject).weight + f;
                }
              }
            }
          }
        }
      }
      label410:
      for (;;)
      {
        i += 1;
        break label224;
        localObject = ((GridLayout.LayoutParams)localObject).apD;
        break label271;
        int m = -1;
        k = 0;
        i = j;
        bool1 = bool2;
        j = m;
        while (k < i)
        {
          m = (int)((k + i) / 2L);
          jO();
          f(m, f);
          bool1 = a(kc(), paramArrayOfInt, false);
          if (bool1)
          {
            k = m + 1;
            j = m;
          }
          else
          {
            i = m;
          }
        }
        if ((j <= 0) || (bool1)) {
          break;
        }
        jO();
        f(j, f);
        k(paramArrayOfInt);
        break;
        return;
      }
    }
    
    private GridLayout.b[] o(List<GridLayout.b> paramList)
    {
      paramList = new Object()
      {
        GridLayout.b[] apj = new GridLayout.b[this.apn.length];
        int apk = this.apj.length - 1;
        GridLayout.b[][] apl = GridLayout.d.this.a(this.apn);
        int[] apm = new int[GridLayout.d.this.getCount() + 1];
        
        static
        {
          if (!GridLayout.class.desiredAssertionStatus()) {}
          for (boolean bool = true;; bool = false)
          {
            $assertionsDisabled = bool;
            return;
          }
        }
        
        final void bT(int paramAnonymousInt)
        {
          switch (this.apm[paramAnonymousInt])
          {
          }
          do
          {
            return;
            this.apm[paramAnonymousInt] = 1;
            GridLayout.b[] arrayOfb1 = this.apl[paramAnonymousInt];
            int j = arrayOfb1.length;
            int i = 0;
            while (i < j)
            {
              GridLayout.b localb = arrayOfb1[i];
              bT(localb.aoG.max);
              GridLayout.b[] arrayOfb2 = this.apj;
              int k = this.apk;
              this.apk = (k - 1);
              arrayOfb2[k] = localb;
              i += 1;
            }
            this.apm[paramAnonymousInt] = 2;
            return;
          } while ($assertionsDisabled);
          throw new AssertionError();
        }
      };
      int i = 0;
      int j = paramList.apl.length;
      while (i < j)
      {
        paramList.bT(i);
        i += 1;
      }
      if ((!1.$assertionsDisabled) && (paramList.apk != -1)) {
        throw new AssertionError();
      }
      return paramList.apj;
    }
    
    private String p(List<GridLayout.b> paramList)
    {
      String str;
      label34:
      label62:
      int j;
      int k;
      int m;
      if (this.aoL)
      {
        str = "x";
        localObject = new StringBuilder();
        Iterator localIterator = paramList.iterator();
        int i = 1;
        paramList = (List<GridLayout.b>)localObject;
        if (!localIterator.hasNext()) {
          break label226;
        }
        localObject = (GridLayout.b)localIterator.next();
        if (i == 0) {
          break label163;
        }
        i = 0;
        j = ((GridLayout.b)localObject).aoG.min;
        k = ((GridLayout.b)localObject).aoG.max;
        m = ((GridLayout.b)localObject).aoH.value;
        if (j >= k) {
          break label174;
        }
      }
      label163:
      label174:
      for (Object localObject = str + k + "-" + str + j + ">=" + m;; localObject = str + j + "-" + str + k + "<=" + -m)
      {
        paramList.append((String)localObject);
        break label34;
        str = "y";
        break;
        paramList = paramList.append(", ");
        break label62;
      }
      label226:
      return paramList.toString();
    }
    
    final GridLayout.b[][] a(GridLayout.b[] paramArrayOfb)
    {
      int j = 0;
      int i = getCount() + 1;
      GridLayout.b[][] arrayOfb; = new GridLayout.b[i][];
      int[] arrayOfInt = new int[i];
      int k = paramArrayOfb.length;
      i = 0;
      int m;
      while (i < k)
      {
        m = paramArrayOfb[i].aoG.min;
        arrayOfInt[m] += 1;
        i += 1;
      }
      i = 0;
      while (i < arrayOfInt.length)
      {
        arrayOfb;[i] = new GridLayout.b[arrayOfInt[i]];
        i += 1;
      }
      Arrays.fill(arrayOfInt, 0);
      k = paramArrayOfb.length;
      i = j;
      while (i < k)
      {
        GridLayout.b localb = paramArrayOfb[i];
        j = localb.aoG.min;
        [Landroid.support.v7.widget.GridLayout.b localb; = arrayOfb;[j];
        m = arrayOfInt[j];
        arrayOfInt[j] = (m + 1);
        localb;[m] = localb;
        i += 1;
      }
      return arrayOfb;;
    }
    
    public final void aj(boolean paramBoolean)
    {
      this.apf = paramBoolean;
      jN();
    }
    
    final void al(boolean paramBoolean)
    {
      int[] arrayOfInt;
      int i;
      label21:
      View localView;
      Object localObject;
      if (paramBoolean)
      {
        arrayOfInt = this.aoU;
        int k = GridLayout.this.getChildCount();
        i = 0;
        if (i >= k) {
          return;
        }
        localView = GridLayout.this.getChildAt(i);
        if (localView.getVisibility() != 8)
        {
          localObject = GridLayout.bl(localView);
          if (!this.aoL) {
            break label126;
          }
          localObject = ((GridLayout.LayoutParams)localObject).apE;
          label68:
          localObject = ((GridLayout.i)localObject).aoG;
          if (!paramBoolean) {
            break label136;
          }
        }
      }
      label136:
      for (int j = ((GridLayout.f)localObject).min;; j = ((GridLayout.f)localObject).max)
      {
        arrayOfInt[j] = Math.max(arrayOfInt[j], GridLayout.this.a(localView, this.aoL, paramBoolean));
        i += 1;
        break label21;
        arrayOfInt = this.aoW;
        break;
        label126:
        localObject = ((GridLayout.LayoutParams)localObject).apD;
        break label68;
      }
    }
    
    public final int bR(int paramInt)
    {
      int i = 0;
      int j = View.MeasureSpec.getMode(paramInt);
      paramInt = View.MeasureSpec.getSize(paramInt);
      switch (j)
      {
      default: 
        paramInt = i;
        if (!$assertionsDisabled) {
          throw new AssertionError();
        }
      case 0: 
        paramInt = X(0, 100000);
        return paramInt;
      case 1073741824: 
        return X(paramInt, paramInt);
      }
      return X(0, paramInt);
    }
    
    public final void bS(int paramInt)
    {
      W(paramInt, paramInt);
      ke();
    }
    
    public final int getCount()
    {
      return Math.max(this.aoM, jV());
    }
    
    public final void jN()
    {
      this.aoN = -2147483648;
      this.aoO = null;
      this.aoQ = null;
      this.aoS = null;
      this.aoU = null;
      this.aoW = null;
      this.aoY = null;
      this.apa = null;
      this.ape = null;
      this.apd = false;
      jO();
    }
    
    public final void jO()
    {
      this.aoP = false;
      this.aoR = false;
      this.aoT = false;
      this.aoV = false;
      this.aoX = false;
      this.aoZ = false;
      this.apb = false;
    }
    
    public final GridLayout.h<GridLayout.i, GridLayout.e> jY()
    {
      if (this.aoO == null) {
        this.aoO = jW();
      }
      if (!this.aoP)
      {
        jX();
        this.aoP = true;
      }
      return this.aoO;
    }
    
    public final int[] ke()
    {
      if (this.apa == null) {
        this.apa = new int[getCount() + 1];
      }
      if (!this.apb)
      {
        l(this.apa);
        this.apb = true;
      }
      return this.apa;
    }
    
    public final void setCount(int paramInt)
    {
      StringBuilder localStringBuilder;
      if ((paramInt != -2147483648) && (paramInt < jV()))
      {
        localStringBuilder = new StringBuilder();
        if (!this.aoL) {
          break label56;
        }
      }
      label56:
      for (String str = "column";; str = "row")
      {
        GridLayout.F(str + "Count must be greater than or equal to the maximum of all grid indices (and spans) defined in the LayoutParams of each child");
        this.aoM = paramInt;
        return;
      }
    }
  }
  
  static class e
  {
    public int apq;
    public int apr;
    public int aps;
    
    e()
    {
      reset();
    }
    
    protected void U(int paramInt1, int paramInt2)
    {
      this.apq = Math.max(this.apq, paramInt1);
      this.apr = Math.max(this.apr, paramInt2);
    }
    
    protected int a(GridLayout paramGridLayout, View paramView, GridLayout.a parama, int paramInt, boolean paramBoolean)
    {
      return this.apq - parama.k(paramView, paramInt, w.b(paramGridLayout));
    }
    
    protected final void a(GridLayout paramGridLayout, View paramView, GridLayout.i parami, GridLayout.d paramd, int paramInt)
    {
      int j = this.aps;
      if ((parami.apK == GridLayout.aor) && (parami.weight == 0.0F)) {}
      for (int i = 0;; i = 2)
      {
        this.aps = (i & j);
        i = parami.am(paramd.aoL).k(paramView, paramInt, w.b(paramGridLayout));
        U(i, paramInt - i);
        return;
      }
    }
    
    protected int ai(boolean paramBoolean)
    {
      if ((!paramBoolean) && (GridLayout.bQ(this.aps))) {
        return 100000;
      }
      return this.apq + this.apr;
    }
    
    protected void reset()
    {
      this.apq = -2147483648;
      this.apr = -2147483648;
      this.aps = 2;
    }
    
    public String toString()
    {
      return "Bounds{before=" + this.apq + ", after=" + this.apr + '}';
    }
  }
  
  static final class f
  {
    public final int max;
    public final int min;
    
    public f(int paramInt1, int paramInt2)
    {
      this.min = paramInt1;
      this.max = paramInt2;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass())) {
          return false;
        }
        paramObject = (f)paramObject;
        if (this.max != paramObject.max) {
          return false;
        }
      } while (this.min == paramObject.min);
      return false;
    }
    
    public final int hashCode()
    {
      return this.min * 31 + this.max;
    }
    
    final int size()
    {
      return this.max - this.min;
    }
    
    public final String toString()
    {
      return "[" + this.min + ", " + this.max + "]";
    }
  }
  
  static final class g
  {
    public int value;
    
    public g()
    {
      this.value = -2147483648;
    }
    
    public g(int paramInt)
    {
      this.value = paramInt;
    }
    
    public final String toString()
    {
      return Integer.toString(this.value);
    }
  }
  
  public static class i
  {
    static final i apI = ;
    final GridLayout.f aoG;
    final boolean apJ;
    final GridLayout.a apK;
    final float weight;
    
    i(boolean paramBoolean, int paramInt1, int paramInt2, GridLayout.a parama, float paramFloat)
    {
      this(paramBoolean, new GridLayout.f(paramInt1, paramInt1 + paramInt2), parama, paramFloat);
    }
    
    private i(boolean paramBoolean, GridLayout.f paramf, GridLayout.a parama, float paramFloat)
    {
      this.apJ = paramBoolean;
      this.aoG = paramf;
      this.apK = parama;
      this.weight = paramFloat;
    }
    
    final i a(GridLayout.f paramf)
    {
      return new i(this.apJ, paramf, this.apK, this.weight);
    }
    
    public final GridLayout.a am(boolean paramBoolean)
    {
      if (this.apK != GridLayout.aor) {
        return this.apK;
      }
      if (this.weight == 0.0F)
      {
        if (paramBoolean) {
          return GridLayout.aow;
        }
        return GridLayout.aoB;
      }
      return GridLayout.aoC;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass())) {
          return false;
        }
        paramObject = (i)paramObject;
        if (!this.apK.equals(paramObject.apK)) {
          return false;
        }
      } while (this.aoG.equals(paramObject.aoG));
      return false;
    }
    
    public int hashCode()
    {
      return this.aoG.hashCode() * 31 + this.apK.hashCode();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     android.support.v7.widget.GridLayout
 * JD-Core Version:    0.7.0.1
 */