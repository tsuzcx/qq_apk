package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v4.view.t;
import android.support.v4.view.v;
import android.support.v7.e.a.a;
import android.util.AttributeSet;
import android.util.LogPrinter;
import android.util.Pair;
import android.util.Printer;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Landroid.support.v7.widget.GridLayout.b;>;
import java.util.Map;

public class GridLayout
  extends ViewGroup
{
  private static final int ORIENTATION;
  public static final a alA = alw;
  public static final a alB = a(alz, alA);
  public static final a alC = a(alA, alz);
  public static final a alD = new a()
  {
    final int B(View paramAnonymousView, int paramAnonymousInt)
    {
      return paramAnonymousInt >> 1;
    }
    
    final String jl()
    {
      return "CENTER";
    }
    
    public final int k(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      return paramAnonymousInt1 >> 1;
    }
  };
  public static final a alE = new a()
  {
    final int B(View paramAnonymousView, int paramAnonymousInt)
    {
      return 0;
    }
    
    final String jl()
    {
      return "BASELINE";
    }
    
    public final GridLayout.e jm()
    {
      new GridLayout.e()
      {
        private int size;
        
        protected final void T(int paramAnonymous2Int1, int paramAnonymous2Int2)
        {
          super.T(paramAnonymous2Int1, paramAnonymous2Int2);
          this.size = Math.max(this.size, paramAnonymous2Int1 + paramAnonymous2Int2);
        }
        
        protected final int a(GridLayout paramAnonymous2GridLayout, View paramAnonymous2View, GridLayout.a paramAnonymous2a, int paramAnonymous2Int, boolean paramAnonymous2Boolean)
        {
          return Math.max(0, super.a(paramAnonymous2GridLayout, paramAnonymous2View, paramAnonymous2a, paramAnonymous2Int, paramAnonymous2Boolean));
        }
        
        protected final int aj(boolean paramAnonymous2Boolean)
        {
          return Math.max(super.aj(paramAnonymous2Boolean), this.size);
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
  public static final a alF = new a()
  {
    final int B(View paramAnonymousView, int paramAnonymousInt)
    {
      return 0;
    }
    
    public final int U(int paramAnonymousInt1, int paramAnonymousInt2)
    {
      return paramAnonymousInt2;
    }
    
    final String jl()
    {
      return "FILL";
    }
    
    public final int k(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      return -2147483648;
    }
  };
  static final Printer alg = new LogPrinter(3, GridLayout.class.getName());
  static final Printer alh = new GridLayout.1();
  private static final int ali;
  private static final int alj;
  private static final int alk;
  private static final int all;
  private static final int alm;
  private static final int aln;
  static final a alu;
  private static final a alv;
  private static final a alw;
  public static final a alx;
  public static final a aly;
  public static final a alz;
  final d alo = new d(true);
  final d alp = new d(false);
  boolean alq = false;
  int alr = 1;
  int als;
  int alt = 0;
  int mOrientation = 0;
  Printer mPrinter = alg;
  
  static
  {
    ORIENTATION = 3;
    ali = 4;
    alj = 1;
    alk = 6;
    all = 0;
    alm = 5;
    aln = 2;
    alu = new a()
    {
      final int B(View paramAnonymousView, int paramAnonymousInt)
      {
        return -2147483648;
      }
      
      final String jl()
      {
        return "UNDEFINED";
      }
      
      public final int k(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        return -2147483648;
      }
    };
    alv = new a()
    {
      final int B(View paramAnonymousView, int paramAnonymousInt)
      {
        return 0;
      }
      
      final String jl()
      {
        return "LEADING";
      }
      
      public final int k(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        return 0;
      }
    };
    alw = new a()
    {
      final int B(View paramAnonymousView, int paramAnonymousInt)
      {
        return paramAnonymousInt;
      }
      
      final String jl()
      {
        return "TRAILING";
      }
      
      public final int k(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        return paramAnonymousInt1;
      }
    };
    alx = alv;
    aly = alw;
    alz = alv;
  }
  
  public GridLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public GridLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.als = paramContext.getResources().getDimensionPixelOffset(2131166086);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.GridLayout);
    try
    {
      setRowCount(paramContext.getInt(ali, -2147483648));
      setColumnCount(paramContext.getInt(alj, -2147483648));
      setOrientation(paramContext.getInt(ORIENTATION, 0));
      setUseDefaultMargins(paramContext.getBoolean(alk, false));
      setAlignmentMode(paramContext.getInt(all, 1));
      setRowOrderPreserved(paramContext.getBoolean(alm, true));
      setColumnOrderPreserved(paramContext.getBoolean(aln, true));
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  static void D(String paramString)
  {
    throw new IllegalArgumentException(paramString + ". ");
  }
  
  private static int S(int paramInt1, int paramInt2)
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
        if (t.Y(paramAnonymousView) == 1) {
          if (i != 0) {
            break label33;
          }
        }
        label33:
        for (GridLayout.a locala = this.alG;; locala = parama2)
        {
          return locala.B(paramAnonymousView, paramAnonymousInt);
          i = 0;
          break;
        }
      }
      
      final String jl()
      {
        return "SWITCHING[L:" + this.alG.jl() + ", R:" + parama2.jl() + "]";
      }
      
      public final int k(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        int i = 1;
        if (t.Y(paramAnonymousView) == 1) {
          if (i != 0) {
            break label37;
          }
        }
        label37:
        for (GridLayout.a locala = this.alG;; locala = parama2)
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
    paramLayoutParams.amE = paramLayoutParams.amE.a(localf);
    localf = new f(paramInt3, paramInt3 + paramInt4);
    paramLayoutParams.amF = paramLayoutParams.amF.a(localf);
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
      paramLayoutParams = paramLayoutParams.amF;
      localf = paramLayoutParams.alJ;
      if ((localf.min != -2147483648) && (localf.min < 0)) {
        D(str + " indices must be positive");
      }
      if (!paramBoolean) {
        break label191;
      }
    }
    label183:
    label191:
    for (paramLayoutParams = this.alo;; paramLayoutParams = this.alp)
    {
      int i = paramLayoutParams.alP;
      if (i != -2147483648)
      {
        if (localf.max > i) {
          D(str + " indices (start + span) mustn't exceed the " + str + " count");
        }
        if (localf.size() > i) {
          D(str + " span mustn't exceed the " + str + " count");
        }
      }
      return;
      str = "row";
      break;
      paramLayoutParams = paramLayoutParams.amE;
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
    if (this.alr == 1) {
      return a(paramView, paramBoolean1, paramBoolean2);
    }
    Object localObject;
    if (paramBoolean1)
    {
      localObject = this.alo;
      if (!paramBoolean2) {
        break label124;
      }
      if (((d)localObject).alX == null) {
        ((d)localObject).alX = new int[((d)localObject).getCount() + 1];
      }
      if (!((d)localObject).alY)
      {
        ((d)localObject).am(true);
        ((d)localObject).alY = true;
      }
      localObject = ((d)localObject).alX;
      label79:
      paramView = (LayoutParams)paramView.getLayoutParams();
      if (!paramBoolean1) {
        break label176;
      }
      paramView = paramView.amF;
      label96:
      if (!paramBoolean2) {
        break label184;
      }
    }
    label176:
    label184:
    for (int i = paramView.alJ.min;; i = paramView.alJ.max)
    {
      return localObject[i];
      localObject = this.alp;
      break;
      label124:
      if (((d)localObject).alZ == null) {
        ((d)localObject).alZ = new int[((d)localObject).getCount() + 1];
      }
      if (!((d)localObject).ama)
      {
        ((d)localObject).am(false);
        ((d)localObject).ama = true;
      }
      localObject = ((d)localObject).alZ;
      break label79;
      paramView = paramView.amE;
      break label96;
    }
  }
  
  static boolean bP(int paramInt)
  {
    return (paramInt & 0x2) != 0;
  }
  
  static LayoutParams bk(View paramView)
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
          localObject = localLayoutParams.amF;
          if (((i)localObject).an(bool) != alF) {
            break label200;
          }
          localf = ((i)localObject).alJ;
          if (!bool) {
            break label202;
          }
        }
        int k;
        label192:
        label200:
        label202:
        for (Object localObject = this.alo;; localObject = this.alp)
        {
          localObject = ((d)localObject).jx();
          k = localObject[localf.max] - localObject[localf.min] - g(localView, bool);
          if (!bool) {
            break label211;
          }
          g(localView, paramInt1, paramInt2, k, localLayoutParams.height);
          break;
          bool = false;
          break label85;
          localObject = localLayoutParams.amE;
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
  
  static a i(int paramInt, boolean paramBoolean)
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
        return alu;
        i = 112;
        break label7;
      }
    }
    if (paramBoolean) {
      return alB;
    }
    return alx;
    if (paramBoolean) {
      return alC;
    }
    return aly;
    return alF;
    return alD;
    return alz;
    return alA;
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
  
  private boolean jf()
  {
    return t.Y(this) == 1;
  }
  
  private void jg()
  {
    this.alt = 0;
    if (this.alo != null) {
      this.alo.jg();
    }
    if (this.alp != null) {
      this.alp.jg();
    }
    jh();
  }
  
  private void jh()
  {
    if ((this.alo != null) && (this.alp != null))
    {
      this.alo.jh();
      this.alp.jh();
    }
  }
  
  private int ji()
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
  
  private void jj()
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
    if (this.alt == 0) {
      if (this.mOrientation == 0)
      {
        i2 = 1;
        if (i2 == 0) {
          break label260;
        }
        localObject = this.alo;
        if (((d)localObject).alP == -2147483648) {
          break label269;
        }
        i3 = ((d)localObject).alP;
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
        localObject = localLayoutParams.amE;
        localf = ((i)localObject).alJ;
        bool1 = ((i)localObject).amK;
        i7 = localf.size();
        if (bool1) {
          i = localf.min;
        }
        if (i2 == 0) {
          break label285;
        }
        localObject = localLayoutParams.amF;
        localf = ((i)localObject).alJ;
        bool2 = ((i)localObject).amK;
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
              localObject = this.alp;
              break label28;
              i3 = 0;
              break label45;
              localObject = localLayoutParams.amF;
              break label97;
              localObject = localLayoutParams.amE;
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
      this.alt = ji();
      do
      {
        return;
      } while (this.alt == ji());
      this.mPrinter.println("The fields of some layout parameters were modified in between layout operations. Check the javadoc for GridLayout.LayoutParams#rowSpec.");
      jg();
      break;
    }
  }
  
  public static i jk()
  {
    return a(-2147483648, 1, alu, 0.0F);
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
      if (!this.alq)
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
          localObject = ((LayoutParams)localObject).amF;
          if (!paramBoolean1) {
            break label171;
          }
          locald = this.alo;
          localObject = ((i)localObject).alJ;
          bool = paramBoolean2;
          if (paramBoolean1)
          {
            bool = paramBoolean2;
            if (jf())
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
          localObject = ((LayoutParams)localObject).amE;
          break;
          label171:
          locald = this.alp;
          break label95;
          label180:
          bool = false;
          break label126;
          label186:
          locald.getCount();
        }
        label195:
        return this.als / 2;
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
    return this.alr;
  }
  
  public int getColumnCount()
  {
    return this.alo.getCount();
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
    return this.alp.getCount();
  }
  
  public boolean getUseDefaultMargins()
  {
    return this.alq;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    jj();
    paramInt3 -= paramInt1;
    int i = getPaddingLeft();
    int j = getPaddingTop();
    int k = getPaddingRight();
    paramInt1 = getPaddingBottom();
    this.alo.bR(paramInt3 - i - k);
    this.alp.bR(paramInt4 - paramInt2 - j - paramInt1);
    int[] arrayOfInt1 = this.alo.jx();
    int[] arrayOfInt2 = this.alp.jx();
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
        Object localObject1 = ((LayoutParams)localObject2).amF;
        localObject2 = ((LayoutParams)localObject2).amE;
        Object localObject3 = ((i)localObject1).alJ;
        Object localObject4 = ((i)localObject2).alJ;
        paramInt2 = arrayOfInt1[localObject3.min];
        m = arrayOfInt2[localObject4.min];
        i1 = arrayOfInt1[localObject3.max];
        n = arrayOfInt2[localObject4.max];
        i5 = i1 - paramInt2;
        i7 = n - m;
        int i10 = h(localView, true);
        int i8 = h(localView, false);
        localObject1 = ((i)localObject1).an(true);
        localObject2 = ((i)localObject2).an(false);
        localObject3 = (e)this.alo.jr().bT(paramInt1);
        localObject4 = (e)this.alp.jr().bT(paramInt1);
        int i6 = ((a)localObject1).B(localView, i5 - ((e)localObject3).aj(true));
        n = ((a)localObject2).B(localView, i7 - ((e)localObject4).aj(true));
        int i3 = b(localView, true, true);
        i1 = b(localView, false, true);
        i4 = b(localView, true, false);
        i2 = b(localView, false, false);
        int i11 = i3 + i4;
        int i12 = i1 + i2;
        int i9 = ((e)localObject3).a(this, localView, (a)localObject1, i10 + i11, true);
        i2 = ((e)localObject4).a(this, localView, (a)localObject2, i8 + i12, false);
        i5 = ((a)localObject1).U(i10, i5 - i11);
        i7 = ((a)localObject2).U(i8, i7 - i12);
        paramInt2 = i9 + (paramInt2 + i6);
        if (jf()) {
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
    jj();
    jh();
    int m = getPaddingLeft() + getPaddingRight();
    int k = getPaddingTop() + getPaddingBottom();
    int n = S(paramInt1, -m);
    int i1 = S(paramInt2, -k);
    d(n, i1, true);
    int j;
    int i;
    if (this.mOrientation == 0)
    {
      j = this.alo.bQ(n);
      d(n, i1, false);
      i = this.alp.bQ(i1);
    }
    for (;;)
    {
      j = Math.max(j + m, getSuggestedMinimumWidth());
      i = Math.max(i + k, getSuggestedMinimumHeight());
      setMeasuredDimension(View.resolveSizeAndState(j, paramInt1, 0), View.resolveSizeAndState(i, paramInt2, 0));
      return;
      i = this.alp.bQ(i1);
      d(n, i1, false);
      j = this.alo.bQ(n);
    }
  }
  
  public void requestLayout()
  {
    super.requestLayout();
    jg();
  }
  
  public void setAlignmentMode(int paramInt)
  {
    this.alr = paramInt;
    requestLayout();
  }
  
  public void setColumnCount(int paramInt)
  {
    this.alo.setCount(paramInt);
    jg();
    requestLayout();
  }
  
  public void setColumnOrderPreserved(boolean paramBoolean)
  {
    this.alo.ak(paramBoolean);
    jg();
    requestLayout();
  }
  
  public void setOrientation(int paramInt)
  {
    if (this.mOrientation != paramInt)
    {
      this.mOrientation = paramInt;
      jg();
      requestLayout();
    }
  }
  
  public void setPrinter(Printer paramPrinter)
  {
    Printer localPrinter = paramPrinter;
    if (paramPrinter == null) {
      localPrinter = alh;
    }
    this.mPrinter = localPrinter;
  }
  
  public void setRowCount(int paramInt)
  {
    this.alp.setCount(paramInt);
    jg();
    requestLayout();
  }
  
  public void setRowOrderPreserved(boolean paramBoolean)
  {
    this.alp.ak(paramBoolean);
    jg();
    requestLayout();
  }
  
  public void setUseDefaultMargins(boolean paramBoolean)
  {
    this.alq = paramBoolean;
    requestLayout();
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    private static final int BOTTOM_MARGIN;
    private static final int LEFT_MARGIN;
    private static final int MARGIN;
    private static final int RIGHT_MARGIN;
    private static final int TOP_MARGIN;
    private static final int amA = 11;
    private static final int amB = 12;
    private static final int amC = 13;
    private static final int amD = 10;
    private static final GridLayout.f amv;
    private static final int amw;
    private static final int amx;
    private static final int amy;
    private static final int amz;
    public GridLayout.i amE = GridLayout.i.amJ;
    public GridLayout.i amF = GridLayout.i.amJ;
    
    static
    {
      GridLayout.f localf = new GridLayout.f(-2147483648, -2147483647);
      amv = localf;
      amw = localf.size();
      MARGIN = 2;
      LEFT_MARGIN = 3;
      TOP_MARGIN = 4;
      RIGHT_MARGIN = 5;
      BOTTOM_MARGIN = 6;
      amx = 7;
      amy = 8;
      amz = 9;
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
      //   7: getstatic 74	android/support/v7/widget/GridLayout$i:amJ	Landroid/support/v7/widget/GridLayout$i;
      //   10: putfield 82	android/support/v7/widget/GridLayout$LayoutParams:amE	Landroid/support/v7/widget/GridLayout$i;
      //   13: aload_0
      //   14: getstatic 74	android/support/v7/widget/GridLayout$i:amJ	Landroid/support/v7/widget/GridLayout$i;
      //   17: putfield 84	android/support/v7/widget/GridLayout$LayoutParams:amF	Landroid/support/v7/widget/GridLayout$i;
      //   20: aload_1
      //   21: aload_2
      //   22: getstatic 90	android/support/v7/e/a$a:GridLayout_Layout	[I
      //   25: invokevirtual 96	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;
      //   28: astore 7
      //   30: aload 7
      //   32: getstatic 46	android/support/v7/widget/GridLayout$LayoutParams:MARGIN	I
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
      //   113: getstatic 68	android/support/v7/widget/GridLayout$LayoutParams:amD	I
      //   116: iconst_0
      //   117: invokevirtual 120	android/content/res/TypedArray:getInt	(II)I
      //   120: istore 4
      //   122: aload_1
      //   123: getstatic 56	android/support/v7/widget/GridLayout$LayoutParams:amx	I
      //   126: ldc 31
      //   128: invokevirtual 120	android/content/res/TypedArray:getInt	(II)I
      //   131: istore 5
      //   133: aload_1
      //   134: getstatic 58	android/support/v7/widget/GridLayout$LayoutParams:amy	I
      //   137: getstatic 44	android/support/v7/widget/GridLayout$LayoutParams:amw	I
      //   140: invokevirtual 120	android/content/res/TypedArray:getInt	(II)I
      //   143: istore 6
      //   145: aload_1
      //   146: getstatic 60	android/support/v7/widget/GridLayout$LayoutParams:amz	I
      //   149: fconst_0
      //   150: invokevirtual 124	android/content/res/TypedArray:getFloat	(IF)F
      //   153: fstore_3
      //   154: aload_0
      //   155: iload 5
      //   157: iload 6
      //   159: iload 4
      //   161: iconst_1
      //   162: invokestatic 128	android/support/v7/widget/GridLayout:i	(IZ)Landroid/support/v7/widget/GridLayout$a;
      //   165: fload_3
      //   166: invokestatic 132	android/support/v7/widget/GridLayout:a	(IILandroid/support/v7/widget/GridLayout$a;F)Landroid/support/v7/widget/GridLayout$i;
      //   169: putfield 84	android/support/v7/widget/GridLayout$LayoutParams:amF	Landroid/support/v7/widget/GridLayout$i;
      //   172: aload_1
      //   173: getstatic 62	android/support/v7/widget/GridLayout$LayoutParams:amA	I
      //   176: ldc 31
      //   178: invokevirtual 120	android/content/res/TypedArray:getInt	(II)I
      //   181: istore 5
      //   183: aload_1
      //   184: getstatic 64	android/support/v7/widget/GridLayout$LayoutParams:amB	I
      //   187: getstatic 44	android/support/v7/widget/GridLayout$LayoutParams:amw	I
      //   190: invokevirtual 120	android/content/res/TypedArray:getInt	(II)I
      //   193: istore 6
      //   195: aload_1
      //   196: getstatic 66	android/support/v7/widget/GridLayout$LayoutParams:amC	I
      //   199: fconst_0
      //   200: invokevirtual 124	android/content/res/TypedArray:getFloat	(IF)F
      //   203: fstore_3
      //   204: aload_0
      //   205: iload 5
      //   207: iload 6
      //   209: iload 4
      //   211: iconst_0
      //   212: invokestatic 128	android/support/v7/widget/GridLayout:i	(IZ)Landroid/support/v7/widget/GridLayout$a;
      //   215: fload_3
      //   216: invokestatic 132	android/support/v7/widget/GridLayout:a	(IILandroid/support/v7/widget/GridLayout$a;F)Landroid/support/v7/widget/GridLayout$i;
      //   219: putfield 82	android/support/v7/widget/GridLayout$LayoutParams:amE	Landroid/support/v7/widget/GridLayout$i;
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
      this.amE = paramLayoutParams.amE;
      this.amF = paramLayoutParams.amF;
    }
    
    private LayoutParams(GridLayout.i parami1, GridLayout.i parami2)
    {
      super(-2);
      setMargins(-2147483648, -2147483648, -2147483648, -2147483648);
      this.amE = parami1;
      this.amF = parami2;
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
        if (!this.amF.equals(paramObject.amF)) {
          return false;
        }
      } while (this.amE.equals(paramObject.amE));
      return false;
    }
    
    public int hashCode()
    {
      return this.amE.hashCode() * 31 + this.amF.hashCode();
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
    
    int U(int paramInt1, int paramInt2)
    {
      return paramInt1;
    }
    
    abstract String jl();
    
    GridLayout.e jm()
    {
      return new GridLayout.e();
    }
    
    abstract int k(View paramView, int paramInt1, int paramInt2);
    
    public String toString()
    {
      return "Alignment:" + jl();
    }
  }
  
  static final class b
  {
    public final GridLayout.f alJ;
    public final GridLayout.g alK;
    public boolean alL = true;
    
    public b(GridLayout.f paramf, GridLayout.g paramg)
    {
      this.alJ = paramf;
      this.alK = paramg;
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder().append(this.alJ).append(" ");
      if (!this.alL) {}
      for (String str = "+>";; str = "->") {
        return str + " " + this.alK;
      }
    }
  }
  
  static final class c<K, V>
    extends ArrayList<Pair<K, V>>
  {
    private final Class<K> alM;
    private final Class<V> alN;
    
    private c(Class<K> paramClass, Class<V> paramClass1)
    {
      this.alM = paramClass;
      this.alN = paramClass1;
    }
    
    public static <K, V> c<K, V> a(Class<K> paramClass, Class<V> paramClass1)
    {
      return new c(paramClass, paramClass1);
    }
    
    public final void c(K paramK, V paramV)
    {
      add(Pair.create(paramK, paramV));
    }
    
    public final GridLayout.h<K, V> jn()
    {
      int j = size();
      Object[] arrayOfObject1 = (Object[])Array.newInstance(this.alM, j);
      Object[] arrayOfObject2 = (Object[])Array.newInstance(this.alN, j);
      int i = 0;
      while (i < j)
      {
        arrayOfObject1[i] = ((Pair)get(i)).first;
        arrayOfObject2[i] = ((Pair)get(i)).second;
        i += 1;
      }
      return new GridLayout.h(arrayOfObject1, arrayOfObject2);
    }
  }
  
  final class d
  {
    public final boolean alO;
    public int alP = -2147483648;
    private int alQ = -2147483648;
    GridLayout.h<GridLayout.i, GridLayout.e> alR;
    public boolean alS = false;
    GridLayout.h<GridLayout.f, GridLayout.g> alT;
    public boolean alU = false;
    GridLayout.h<GridLayout.f, GridLayout.g> alV;
    public boolean alW = false;
    public int[] alX;
    public boolean alY = false;
    public int[] alZ;
    public boolean ama = false;
    public GridLayout.b[] amb;
    public boolean amc = false;
    public int[] amd;
    public boolean ame = false;
    public boolean amf;
    public boolean amg = false;
    public int[] amh;
    boolean ami = true;
    private GridLayout.g amj = new GridLayout.g(0);
    private GridLayout.g amk = new GridLayout.g(-100000);
    
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
      this.alO = paramBoolean;
    }
    
    private void V(int paramInt1, int paramInt2)
    {
      this.amj.value = paramInt1;
      this.amk.value = (-paramInt2);
      this.ame = false;
    }
    
    private int W(int paramInt1, int paramInt2)
    {
      V(paramInt1, paramInt2);
      return jx()[getCount()];
    }
    
    private void a(GridLayout.h<GridLayout.f, GridLayout.g> paramh, boolean paramBoolean)
    {
      int j = 0;
      Object localObject = (GridLayout.g[])paramh.amI;
      int i = 0;
      while (i < localObject.length)
      {
        localObject[i].value = -2147483648;
        i += 1;
      }
      localObject = (GridLayout.e[])jr().amI;
      i = j;
      if (i < localObject.length)
      {
        j = localObject[i].aj(paramBoolean);
        GridLayout.g localg = (GridLayout.g)paramh.bT(i);
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
          if (((GridLayout.b)localIterator.next()).alJ.equals(paramf)) {
            return;
          }
        }
      }
      paramList.add(new GridLayout.b(paramf, paramg));
    }
    
    private static void a(List<GridLayout.b> paramList, GridLayout.h<GridLayout.f, GridLayout.g> paramh)
    {
      int i = 0;
      while (i < ((GridLayout.f[])paramh.amH).length)
      {
        a(paramList, ((GridLayout.f[])paramh.amH)[i], ((GridLayout.g[])paramh.amI)[i], false);
        i += 1;
      }
    }
    
    private static boolean a(int[] paramArrayOfInt, GridLayout.b paramb)
    {
      if (!paramb.alL) {}
      int j;
      int i;
      do
      {
        return false;
        GridLayout.f localf = paramb.alJ;
        j = localf.min;
        i = localf.max;
        int k = paramb.alK.value;
        j = paramArrayOfInt[j] + k;
      } while (j <= paramArrayOfInt[i]);
      paramArrayOfInt[i] = j;
      return true;
    }
    
    private boolean a(GridLayout.b[] paramArrayOfb, int[] paramArrayOfInt, boolean paramBoolean)
    {
      boolean bool3 = false;
      int n = 0;
      if (this.alO) {}
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
            if (!localb.alL) {
              ((List)localObject2).add(localb);
            }
            i += 1;
          }
          GridLayout.this.mPrinter.println(str + " constraints: " + q(paramArrayOfInt) + " are inconsistent; permanently removing: " + q((List)localObject2) + ". ");
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
            if (localb.alJ.min >= localb.alJ.max) {
              localb.alL = false;
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
    
    private GridLayout.h<GridLayout.f, GridLayout.g> al(boolean paramBoolean)
    {
      GridLayout.c localc = GridLayout.c.a(GridLayout.f.class, GridLayout.g.class);
      GridLayout.i[] arrayOfi = (GridLayout.i[])jr().amH;
      int j = arrayOfi.length;
      int i = 0;
      if (i < j)
      {
        if (paramBoolean) {}
        for (GridLayout.f localf = arrayOfi[i].alJ;; localf = new GridLayout.f(localf.max, localf.min))
        {
          localc.c(localf, new GridLayout.g());
          i += 1;
          break;
          localf = arrayOfi[i].alJ;
        }
      }
      return localc.jn();
    }
    
    private void f(int paramInt, float paramFloat)
    {
      Arrays.fill(this.amh, 0);
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
        localObject = GridLayout.bk((View)localObject);
        if (this.alO)
        {
          localObject = ((GridLayout.LayoutParams)localObject).amF;
          label73:
          float f = ((GridLayout.i)localObject).weight;
          if (f == 0.0F) {
            break label134;
          }
          j = Math.round(i * f / paramFloat);
          this.amh[paramInt] = j;
          i -= j;
          paramFloat -= f;
        }
      }
      label134:
      for (;;)
      {
        paramInt += 1;
        break;
        localObject = ((GridLayout.LayoutParams)localObject).amE;
        break label73;
        return;
      }
    }
    
    private int jo()
    {
      int i;
      if (this.alQ == -2147483648)
      {
        int k = GridLayout.this.getChildCount();
        int j = 0;
        i = -1;
        if (j < k)
        {
          Object localObject = GridLayout.bk(GridLayout.this.getChildAt(j));
          if (this.alO) {}
          for (localObject = ((GridLayout.LayoutParams)localObject).amF;; localObject = ((GridLayout.LayoutParams)localObject).amE)
          {
            localObject = ((GridLayout.i)localObject).alJ;
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
        this.alQ = Math.max(0, i);
        return this.alQ;
      }
    }
    
    private GridLayout.h<GridLayout.i, GridLayout.e> jp()
    {
      GridLayout.c localc = GridLayout.c.a(GridLayout.i.class, GridLayout.e.class);
      int j = GridLayout.this.getChildCount();
      int i = 0;
      if (i < j)
      {
        Object localObject = GridLayout.bk(GridLayout.this.getChildAt(i));
        if (this.alO) {}
        for (localObject = ((GridLayout.LayoutParams)localObject).amF;; localObject = ((GridLayout.LayoutParams)localObject).amE)
        {
          localc.c(localObject, ((GridLayout.i)localObject).an(this.alO).jm());
          i += 1;
          break;
        }
      }
      return localc.jn();
    }
    
    private void jq()
    {
      Object localObject = (GridLayout.e[])this.alR.amI;
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
        localObject = GridLayout.bk(localView);
        label83:
        GridLayout localGridLayout;
        boolean bool;
        int j;
        if (this.alO)
        {
          localObject = ((GridLayout.LayoutParams)localObject).amF;
          localGridLayout = GridLayout.this;
          bool = this.alO;
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
        for (int k = 0;; k = jw()[i])
        {
          ((GridLayout.e)this.alR.bT(i)).a(GridLayout.this, localView, (GridLayout.i)localObject, this, j + k);
          i += 1;
          break;
          localObject = ((GridLayout.LayoutParams)localObject).amE;
          break label83;
          j = GridLayout.h(localView, bool);
          j = localGridLayout.g(localView, bool) + j;
          break label107;
        }
      }
    }
    
    private GridLayout.h<GridLayout.f, GridLayout.g> js()
    {
      if (this.alT == null) {
        this.alT = al(true);
      }
      if (!this.alU)
      {
        a(this.alT, true);
        this.alU = true;
      }
      return this.alT;
    }
    
    private GridLayout.h<GridLayout.f, GridLayout.g> jt()
    {
      if (this.alV == null) {
        this.alV = al(false);
      }
      if (!this.alW)
      {
        a(this.alV, false);
        this.alW = true;
      }
      return this.alV;
    }
    
    private void ju()
    {
      js();
      jt();
    }
    
    private GridLayout.b[] jv()
    {
      if (this.amb == null)
      {
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        a(localArrayList1, js());
        a(localArrayList2, jt());
        if (this.ami)
        {
          i = 0;
          while (i < getCount())
          {
            a(localArrayList1, new GridLayout.f(i, i + 1), new GridLayout.g(0));
            i += 1;
          }
        }
        int i = getCount();
        a(localArrayList1, new GridLayout.f(0, i), this.amj, false);
        a(localArrayList2, new GridLayout.f(i, 0), this.amk, false);
        this.amb = ((GridLayout.b[])GridLayout.a(p(localArrayList1), p(localArrayList2)));
      }
      if (!this.amc)
      {
        ju();
        this.amc = true;
      }
      return this.amb;
    }
    
    private int[] jw()
    {
      if (this.amh == null) {
        this.amh = new int[GridLayout.this.getChildCount()];
      }
      return this.amh;
    }
    
    private boolean k(int[] paramArrayOfInt)
    {
      return a(jv(), paramArrayOfInt, true);
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
      if (!this.amg)
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
        localObject = GridLayout.bk((View)localObject);
        if (this.alO)
        {
          localObject = ((GridLayout.LayoutParams)localObject).amF;
          if (((GridLayout.i)localObject).weight == 0.0F) {
            break label161;
          }
          bool1 = true;
          label86:
          this.amf = bool1;
          this.amg = true;
        }
      }
      else
      {
        if (this.amf) {
          break label174;
        }
        k(paramArrayOfInt);
      }
      label110:
      int k;
      for (;;)
      {
        if (!this.ami)
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
              localObject = ((GridLayout.LayoutParams)localObject).amE;
              break label73;
              label161:
              i += 1;
              break;
              label168:
              bool1 = false;
              break label86;
              label174:
              Arrays.fill(jw(), 0);
              k(paramArrayOfInt);
              j = this.amj.value * GridLayout.this.getChildCount() + 1;
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
                localObject = GridLayout.bk((View)localObject);
                if (this.alO)
                {
                  localObject = ((GridLayout.LayoutParams)localObject).amF;
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
        localObject = ((GridLayout.LayoutParams)localObject).amE;
        break label271;
        int m = -1;
        k = 0;
        i = j;
        bool1 = bool2;
        j = m;
        while (k < i)
        {
          m = (int)((k + i) / 2L);
          jh();
          f(m, f);
          bool1 = a(jv(), paramArrayOfInt, false);
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
        jh();
        f(j, f);
        k(paramArrayOfInt);
        break;
        return;
      }
    }
    
    private GridLayout.b[] p(List<GridLayout.b> paramList)
    {
      paramList = new Object()
      {
        GridLayout.b[] amm = new GridLayout.b[this.amq.length];
        int amn = this.amm.length - 1;
        GridLayout.b[][] amo = GridLayout.d.this.a(this.amq);
        int[] amp = new int[GridLayout.d.this.getCount() + 1];
        
        static
        {
          if (!GridLayout.class.desiredAssertionStatus()) {}
          for (boolean bool = true;; bool = false)
          {
            $assertionsDisabled = bool;
            return;
          }
        }
        
        final void bS(int paramAnonymousInt)
        {
          switch (this.amp[paramAnonymousInt])
          {
          }
          do
          {
            return;
            this.amp[paramAnonymousInt] = 1;
            GridLayout.b[] arrayOfb1 = this.amo[paramAnonymousInt];
            int j = arrayOfb1.length;
            int i = 0;
            while (i < j)
            {
              GridLayout.b localb = arrayOfb1[i];
              bS(localb.alJ.max);
              GridLayout.b[] arrayOfb2 = this.amm;
              int k = this.amn;
              this.amn = (k - 1);
              arrayOfb2[k] = localb;
              i += 1;
            }
            this.amp[paramAnonymousInt] = 2;
            return;
          } while ($assertionsDisabled);
          throw new AssertionError();
        }
      };
      int i = 0;
      int j = paramList.amo.length;
      while (i < j)
      {
        paramList.bS(i);
        i += 1;
      }
      if ((!1.$assertionsDisabled) && (paramList.amn != -1)) {
        throw new AssertionError();
      }
      return paramList.amm;
    }
    
    private String q(List<GridLayout.b> paramList)
    {
      String str;
      label34:
      label62:
      int j;
      int k;
      int m;
      if (this.alO)
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
        j = ((GridLayout.b)localObject).alJ.min;
        k = ((GridLayout.b)localObject).alJ.max;
        m = ((GridLayout.b)localObject).alK.value;
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
        m = paramArrayOfb[i].alJ.min;
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
        j = localb.alJ.min;
        [Landroid.support.v7.widget.GridLayout.b localb; = arrayOfb;[j];
        m = arrayOfInt[j];
        arrayOfInt[j] = (m + 1);
        localb;[m] = localb;
        i += 1;
      }
      return arrayOfb;;
    }
    
    public final void ak(boolean paramBoolean)
    {
      this.ami = paramBoolean;
      jg();
    }
    
    final void am(boolean paramBoolean)
    {
      int[] arrayOfInt;
      int i;
      label21:
      View localView;
      Object localObject;
      if (paramBoolean)
      {
        arrayOfInt = this.alX;
        int k = GridLayout.this.getChildCount();
        i = 0;
        if (i >= k) {
          return;
        }
        localView = GridLayout.this.getChildAt(i);
        if (localView.getVisibility() != 8)
        {
          localObject = GridLayout.bk(localView);
          if (!this.alO) {
            break label126;
          }
          localObject = ((GridLayout.LayoutParams)localObject).amF;
          label68:
          localObject = ((GridLayout.i)localObject).alJ;
          if (!paramBoolean) {
            break label136;
          }
        }
      }
      label136:
      for (int j = ((GridLayout.f)localObject).min;; j = ((GridLayout.f)localObject).max)
      {
        arrayOfInt[j] = Math.max(arrayOfInt[j], GridLayout.this.a(localView, this.alO, paramBoolean));
        i += 1;
        break label21;
        arrayOfInt = this.alZ;
        break;
        label126:
        localObject = ((GridLayout.LayoutParams)localObject).amE;
        break label68;
      }
    }
    
    public final int bQ(int paramInt)
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
        paramInt = W(0, 100000);
        return paramInt;
      case 1073741824: 
        return W(paramInt, paramInt);
      }
      return W(0, paramInt);
    }
    
    public final void bR(int paramInt)
    {
      V(paramInt, paramInt);
      jx();
    }
    
    public final int getCount()
    {
      return Math.max(this.alP, jo());
    }
    
    public final void jg()
    {
      this.alQ = -2147483648;
      this.alR = null;
      this.alT = null;
      this.alV = null;
      this.alX = null;
      this.alZ = null;
      this.amb = null;
      this.amd = null;
      this.amh = null;
      this.amg = false;
      jh();
    }
    
    public final void jh()
    {
      this.alS = false;
      this.alU = false;
      this.alW = false;
      this.alY = false;
      this.ama = false;
      this.amc = false;
      this.ame = false;
    }
    
    public final GridLayout.h<GridLayout.i, GridLayout.e> jr()
    {
      if (this.alR == null) {
        this.alR = jp();
      }
      if (!this.alS)
      {
        jq();
        this.alS = true;
      }
      return this.alR;
    }
    
    public final int[] jx()
    {
      if (this.amd == null) {
        this.amd = new int[getCount() + 1];
      }
      if (!this.ame)
      {
        l(this.amd);
        this.ame = true;
      }
      return this.amd;
    }
    
    public final void setCount(int paramInt)
    {
      StringBuilder localStringBuilder;
      if ((paramInt != -2147483648) && (paramInt < jo()))
      {
        localStringBuilder = new StringBuilder();
        if (!this.alO) {
          break label56;
        }
      }
      label56:
      for (String str = "column";; str = "row")
      {
        GridLayout.D(str + "Count must be greater than or equal to the maximum of all grid indices (and spans) defined in the LayoutParams of each child");
        this.alP = paramInt;
        return;
      }
    }
  }
  
  static class e
  {
    public int ams;
    public int amt;
    public int amu;
    
    e()
    {
      reset();
    }
    
    protected void T(int paramInt1, int paramInt2)
    {
      this.ams = Math.max(this.ams, paramInt1);
      this.amt = Math.max(this.amt, paramInt2);
    }
    
    protected int a(GridLayout paramGridLayout, View paramView, GridLayout.a parama, int paramInt, boolean paramBoolean)
    {
      return this.ams - parama.k(paramView, paramInt, v.b(paramGridLayout));
    }
    
    protected final void a(GridLayout paramGridLayout, View paramView, GridLayout.i parami, GridLayout.d paramd, int paramInt)
    {
      int j = this.amu;
      if ((parami.amL == GridLayout.alu) && (parami.weight == 0.0F)) {}
      for (int i = 0;; i = 2)
      {
        this.amu = (i & j);
        i = parami.an(paramd.alO).k(paramView, paramInt, v.b(paramGridLayout));
        T(i, paramInt - i);
        return;
      }
    }
    
    protected int aj(boolean paramBoolean)
    {
      if ((!paramBoolean) && (GridLayout.bP(this.amu))) {
        return 100000;
      }
      return this.ams + this.amt;
    }
    
    protected void reset()
    {
      this.ams = -2147483648;
      this.amt = -2147483648;
      this.amu = 2;
    }
    
    public String toString()
    {
      return "Bounds{before=" + this.ams + ", after=" + this.amt + '}';
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
  
  static final class h<K, V>
  {
    public final int[] amG;
    public final K[] amH;
    public final V[] amI;
    
    h(K[] paramArrayOfK, V[] paramArrayOfV)
    {
      this.amG = c(paramArrayOfK);
      this.amH = a(paramArrayOfK, this.amG);
      this.amI = a(paramArrayOfV, this.amG);
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
    
    public final V bT(int paramInt)
    {
      return this.amI[this.amG[paramInt]];
    }
  }
  
  public static class i
  {
    static final i amJ = ;
    final GridLayout.f alJ;
    final boolean amK;
    final GridLayout.a amL;
    final float weight;
    
    i(boolean paramBoolean, int paramInt1, int paramInt2, GridLayout.a parama, float paramFloat)
    {
      this(paramBoolean, new GridLayout.f(paramInt1, paramInt1 + paramInt2), parama, paramFloat);
    }
    
    private i(boolean paramBoolean, GridLayout.f paramf, GridLayout.a parama, float paramFloat)
    {
      this.amK = paramBoolean;
      this.alJ = paramf;
      this.amL = parama;
      this.weight = paramFloat;
    }
    
    final i a(GridLayout.f paramf)
    {
      return new i(this.amK, paramf, this.amL, this.weight);
    }
    
    public final GridLayout.a an(boolean paramBoolean)
    {
      if (this.amL != GridLayout.alu) {
        return this.amL;
      }
      if (this.weight == 0.0F)
      {
        if (paramBoolean) {
          return GridLayout.alz;
        }
        return GridLayout.alE;
      }
      return GridLayout.alF;
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
        if (!this.amL.equals(paramObject.amL)) {
          return false;
        }
      } while (this.alJ.equals(paramObject.alJ));
      return false;
    }
    
    public int hashCode()
    {
      return this.alJ.hashCode() * 31 + this.amL.hashCode();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v7.widget.GridLayout
 * JD-Core Version:    0.7.0.1
 */