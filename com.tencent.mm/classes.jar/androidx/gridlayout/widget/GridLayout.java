package androidx.gridlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.LogPrinter;
import android.util.Printer;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.core.g.w;
import androidx.core.g.y;
import androidx.gridlayout.a.a;
import androidx.gridlayout.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.List<Landroidx.gridlayout.widget.GridLayout.b;>;

public class GridLayout
  extends ViewGroup
{
  static final Printer XG;
  static final Printer XH;
  private static final int XI;
  private static final int XJ;
  private static final int XK;
  private static final int XL;
  private static final int XM;
  private static final int XN;
  private static final int XO;
  static final a XV;
  private static final a XW;
  private static final a XX;
  public static final a XY;
  public static final a XZ;
  public static final a Ya;
  public static final a Yb;
  public static final a Yc;
  public static final a Yd;
  public static final a Ye;
  public static final a Yf;
  public static final a Yg;
  final d XP;
  final d XQ;
  boolean XR;
  int XS;
  int XT;
  int XU;
  int mOrientation;
  Printer mPrinter;
  
  static
  {
    AppMethodBeat.i(255692);
    XG = new LogPrinter(3, GridLayout.class.getName());
    XH = new Printer()
    {
      public final void println(String paramAnonymousString) {}
    };
    XI = a.b.Xp;
    XJ = a.b.Xq;
    XK = a.b.Xn;
    XL = a.b.Xs;
    XM = a.b.Xm;
    XN = a.b.Xr;
    XO = a.b.Xo;
    XV = new a()
    {
      final int B(View paramAnonymousView, int paramAnonymousInt)
      {
        return -2147483648;
      }
      
      public final int h(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        return -2147483648;
      }
      
      final String iN()
      {
        return "UNDEFINED";
      }
    };
    XW = new a()
    {
      final int B(View paramAnonymousView, int paramAnonymousInt)
      {
        return 0;
      }
      
      public final int h(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        return 0;
      }
      
      final String iN()
      {
        return "LEADING";
      }
    };
    XX = new a()
    {
      final int B(View paramAnonymousView, int paramAnonymousInt)
      {
        return paramAnonymousInt;
      }
      
      public final int h(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        return paramAnonymousInt1;
      }
      
      final String iN()
      {
        return "TRAILING";
      }
    };
    XY = XW;
    XZ = XX;
    Ya = XW;
    Yb = XX;
    Yc = a(Ya, Yb);
    Yd = a(Yb, Ya);
    Ye = new a()
    {
      final int B(View paramAnonymousView, int paramAnonymousInt)
      {
        return paramAnonymousInt >> 1;
      }
      
      public final int h(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        return paramAnonymousInt1 >> 1;
      }
      
      final String iN()
      {
        return "CENTER";
      }
    };
    Yf = new a()
    {
      final int B(View paramAnonymousView, int paramAnonymousInt)
      {
        return 0;
      }
      
      public final int h(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(255428);
        if (paramAnonymousView.getVisibility() == 8)
        {
          AppMethodBeat.o(255428);
          return 0;
        }
        paramAnonymousInt1 = paramAnonymousView.getBaseline();
        if (paramAnonymousInt1 == -1)
        {
          AppMethodBeat.o(255428);
          return -2147483648;
        }
        AppMethodBeat.o(255428);
        return paramAnonymousInt1;
      }
      
      final String iN()
      {
        return "BASELINE";
      }
      
      public final GridLayout.e iO()
      {
        AppMethodBeat.i(255430);
        GridLayout.e local1 = new GridLayout.e()
        {
          private int size;
          
          protected final void Q(int paramAnonymous2Int1, int paramAnonymous2Int2)
          {
            AppMethodBeat.i(255416);
            super.Q(paramAnonymous2Int1, paramAnonymous2Int2);
            this.size = Math.max(this.size, paramAnonymous2Int1 + paramAnonymous2Int2);
            AppMethodBeat.o(255416);
          }
          
          protected final int a(GridLayout paramAnonymous2GridLayout, View paramAnonymous2View, GridLayout.a paramAnonymous2a, int paramAnonymous2Int, boolean paramAnonymous2Boolean)
          {
            AppMethodBeat.i(255419);
            paramAnonymous2Int = Math.max(0, super.a(paramAnonymous2GridLayout, paramAnonymous2View, paramAnonymous2a, paramAnonymous2Int, paramAnonymous2Boolean));
            AppMethodBeat.o(255419);
            return paramAnonymous2Int;
          }
          
          protected final int ai(boolean paramAnonymous2Boolean)
          {
            AppMethodBeat.i(255417);
            int i = Math.max(super.ai(paramAnonymous2Boolean), this.size);
            AppMethodBeat.o(255417);
            return i;
          }
          
          protected final void reset()
          {
            AppMethodBeat.i(255414);
            super.reset();
            this.size = -2147483648;
            AppMethodBeat.o(255414);
          }
        };
        AppMethodBeat.o(255430);
        return local1;
      }
    };
    Yg = new a()
    {
      final int B(View paramAnonymousView, int paramAnonymousInt)
      {
        return 0;
      }
      
      public final int R(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        return paramAnonymousInt2;
      }
      
      public final int h(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        return -2147483648;
      }
      
      final String iN()
      {
        return "FILL";
      }
    };
    AppMethodBeat.o(255692);
  }
  
  public GridLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public GridLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(255596);
    this.XP = new d(true);
    this.XQ = new d(false);
    this.mOrientation = 0;
    this.XR = false;
    this.XS = 1;
    this.XU = 0;
    this.mPrinter = XG;
    this.XT = paramContext.getResources().getDimensionPixelOffset(a.a.Xk);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.b.Xl);
    try
    {
      setRowCount(paramContext.getInt(XJ, -2147483648));
      setColumnCount(paramContext.getInt(XK, -2147483648));
      setOrientation(paramContext.getInt(XI, 0));
      setUseDefaultMargins(paramContext.getBoolean(XL, false));
      setAlignmentMode(paramContext.getInt(XM, 1));
      setRowOrderPreserved(paramContext.getBoolean(XN, true));
      setColumnOrderPreserved(paramContext.getBoolean(XO, true));
      return;
    }
    finally
    {
      paramContext.recycle();
      AppMethodBeat.o(255596);
    }
  }
  
  static void N(String paramString)
  {
    AppMethodBeat.i(255650);
    paramString = new IllegalArgumentException(paramString + ". ");
    AppMethodBeat.o(255650);
    throw paramString;
  }
  
  private static int P(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(255669);
    paramInt1 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt1 + paramInt2), View.MeasureSpec.getMode(paramInt1));
    AppMethodBeat.o(255669);
    return paramInt1;
  }
  
  private static a a(a parama1, final a parama2)
  {
    AppMethodBeat.i(255688);
    parama1 = new a()
    {
      final int B(View paramAnonymousView, int paramAnonymousInt)
      {
        int i = 1;
        AppMethodBeat.i(255406);
        if (w.I(paramAnonymousView) == 1) {
          if (i != 0) {
            break label45;
          }
        }
        label45:
        for (GridLayout.a locala = this.Yh;; locala = parama2)
        {
          paramAnonymousInt = locala.B(paramAnonymousView, paramAnonymousInt);
          AppMethodBeat.o(255406);
          return paramAnonymousInt;
          i = 0;
          break;
        }
      }
      
      public final int h(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        int i = 1;
        AppMethodBeat.i(255408);
        if (w.I(paramAnonymousView) == 1) {
          if (i != 0) {
            break label49;
          }
        }
        label49:
        for (GridLayout.a locala = this.Yh;; locala = parama2)
        {
          paramAnonymousInt1 = locala.h(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(255408);
          return paramAnonymousInt1;
          i = 0;
          break;
        }
      }
      
      final String iN()
      {
        AppMethodBeat.i(255409);
        String str = "SWITCHING[L:" + this.Yh.iN() + ", R:" + parama2.iN() + "]";
        AppMethodBeat.o(255409);
        return str;
      }
    };
    AppMethodBeat.o(255688);
    return parama1;
  }
  
  public static i a(int paramInt1, int paramInt2, a parama, float paramFloat)
  {
    AppMethodBeat.i(255682);
    if (paramInt1 != -2147483648) {}
    for (boolean bool = true;; bool = false)
    {
      parama = new i(bool, paramInt1, paramInt2, parama, paramFloat);
      AppMethodBeat.o(255682);
      return parama;
    }
  }
  
  private static void a(LayoutParams paramLayoutParams, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(255637);
    f localf = new f(paramInt1, paramInt1 + paramInt2);
    paramLayoutParams.Zk = paramLayoutParams.Zk.a(localf);
    localf = new f(paramInt3, paramInt3 + paramInt4);
    paramLayoutParams.Zl = paramLayoutParams.Zl.a(localf);
    AppMethodBeat.o(255637);
  }
  
  private void a(LayoutParams paramLayoutParams, boolean paramBoolean)
  {
    AppMethodBeat.i(255652);
    String str;
    label24:
    f localf;
    if (paramBoolean)
    {
      str = "column";
      if (!paramBoolean) {
        break label195;
      }
      paramLayoutParams = paramLayoutParams.Zl;
      localf = paramLayoutParams.Yk;
      if ((localf.min != -2147483648) && (localf.min < 0)) {
        N(str + " indices must be positive");
      }
      if (!paramBoolean) {
        break label203;
      }
    }
    label195:
    label203:
    for (paramLayoutParams = this.XP;; paramLayoutParams = this.XQ)
    {
      int i = paramLayoutParams.Yq;
      if (i != -2147483648)
      {
        if (localf.max > i) {
          N(str + " indices (start + span) mustn't exceed the " + str + " count");
        }
        if (localf.size() > i) {
          N(str + " span mustn't exceed the " + str + " count");
        }
      }
      AppMethodBeat.o(255652);
      return;
      str = "row";
      break;
      paramLayoutParams = paramLayoutParams.Zk;
      break label24;
    }
  }
  
  static <T> T[] a(T[] paramArrayOfT1, T[] paramArrayOfT2)
  {
    AppMethodBeat.i(255617);
    Object[] arrayOfObject = (Object[])Array.newInstance(paramArrayOfT1.getClass().getComponentType(), paramArrayOfT1.length + paramArrayOfT2.length);
    System.arraycopy(paramArrayOfT1, 0, arrayOfObject, 0, paramArrayOfT1.length);
    System.arraycopy(paramArrayOfT2, 0, arrayOfObject, paramArrayOfT1.length, paramArrayOfT2.length);
    AppMethodBeat.o(255617);
    return arrayOfObject;
  }
  
  static LayoutParams aL(View paramView)
  {
    AppMethodBeat.i(293081);
    paramView = (LayoutParams)paramView.getLayoutParams();
    AppMethodBeat.o(293081);
    return paramView;
  }
  
  private int b(View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(255632);
    if (this.XS == 1)
    {
      i = a(paramView, paramBoolean1, paramBoolean2);
      AppMethodBeat.o(255632);
      return i;
    }
    Object localObject;
    if (paramBoolean1)
    {
      localObject = this.XP;
      if (!paramBoolean2) {
        break label150;
      }
      if (((d)localObject).Yy == null) {
        ((d)localObject).Yy = new int[((d)localObject).getCount() + 1];
      }
      if (!((d)localObject).Yz)
      {
        ((d)localObject).al(true);
        ((d)localObject).Yz = true;
      }
      localObject = ((d)localObject).Yy;
      label95:
      paramView = (LayoutParams)paramView.getLayoutParams();
      if (!paramBoolean1) {
        break label202;
      }
      paramView = paramView.Zl;
      label112:
      if (!paramBoolean2) {
        break label210;
      }
    }
    label150:
    label202:
    label210:
    for (int i = paramView.Yk.min;; i = paramView.Yk.max)
    {
      i = localObject[i];
      AppMethodBeat.o(255632);
      return i;
      localObject = this.XQ;
      break;
      if (((d)localObject).YA == null) {
        ((d)localObject).YA = new int[((d)localObject).getCount() + 1];
      }
      if (!((d)localObject).YB)
      {
        ((d)localObject).al(false);
        ((d)localObject).YB = true;
      }
      localObject = ((d)localObject).YA;
      break label95;
      paramView = paramView.Zk;
      break label112;
    }
  }
  
  static boolean ca(int paramInt)
  {
    return (paramInt & 0x2) != 0;
  }
  
  private void d(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(255667);
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
          break label81;
        }
        i(localView, paramInt1, paramInt2, localLayoutParams.width, localLayoutParams.height);
      }
      for (;;)
      {
        i += 1;
        break;
        label81:
        boolean bool;
        label91:
        label103:
        f localf;
        if (this.mOrientation == 0)
        {
          bool = true;
          if (!bool) {
            break label198;
          }
          localObject = localLayoutParams.Zl;
          if (((i)localObject).am(bool) != Yg) {
            break label206;
          }
          localf = ((i)localObject).Yk;
          if (!bool) {
            break label208;
          }
        }
        int k;
        label198:
        label206:
        label208:
        for (Object localObject = this.XP;; localObject = this.XQ)
        {
          localObject = ((d)localObject).iZ();
          k = localObject[localf.max] - localObject[localf.min] - e(localView, bool);
          if (!bool) {
            break label217;
          }
          i(localView, paramInt1, paramInt2, k, localLayoutParams.height);
          break;
          bool = false;
          break label91;
          localObject = localLayoutParams.Zk;
          break label103;
          break;
        }
        label217:
        i(localView, paramInt1, paramInt2, localLayoutParams.width, k);
      }
    }
    AppMethodBeat.o(255667);
  }
  
  static int f(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(255674);
    if (paramBoolean)
    {
      i = paramView.getMeasuredWidth();
      AppMethodBeat.o(255674);
      return i;
    }
    int i = paramView.getMeasuredHeight();
    AppMethodBeat.o(255674);
    return i;
  }
  
  static int g(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(255615);
    int j = -1;
    int i = 0;
    int k = paramArrayOfInt.length;
    while (i < k)
    {
      j = Math.max(j, paramArrayOfInt[i]);
      i += 1;
    }
    AppMethodBeat.o(255615);
    return j;
  }
  
  static a g(int paramInt, boolean paramBoolean)
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
        return XV;
        i = 112;
        break label7;
      }
    }
    if (paramBoolean) {
      return Yc;
    }
    return XY;
    if (paramBoolean) {
      return Yd;
    }
    return XZ;
    return Yg;
    return Ye;
    return Ya;
    return Yb;
  }
  
  private void i(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(255663);
    paramView.measure(getChildMeasureSpec(paramInt1, e(paramView, true), paramInt3), getChildMeasureSpec(paramInt2, e(paramView, false), paramInt4));
    AppMethodBeat.o(255663);
  }
  
  private boolean iH()
  {
    AppMethodBeat.i(255628);
    if (w.I(this) == 1)
    {
      AppMethodBeat.o(255628);
      return true;
    }
    AppMethodBeat.o(255628);
    return false;
  }
  
  private void iI()
  {
    AppMethodBeat.i(255641);
    this.XU = 0;
    if (this.XP != null) {
      this.XP.iI();
    }
    if (this.XQ != null) {
      this.XQ.iI();
    }
    iJ();
    AppMethodBeat.o(255641);
  }
  
  private void iJ()
  {
    AppMethodBeat.i(255643);
    if ((this.XP != null) && (this.XQ != null))
    {
      this.XP.iJ();
      this.XQ.iJ();
    }
    AppMethodBeat.o(255643);
  }
  
  private int iK()
  {
    AppMethodBeat.i(255657);
    int i = 1;
    int k = getChildCount();
    int j = 0;
    if (j < k)
    {
      View localView = getChildAt(j);
      if (localView.getVisibility() == 8) {
        break label69;
      }
      i = ((LayoutParams)localView.getLayoutParams()).hashCode() + i * 31;
    }
    label69:
    for (;;)
    {
      j += 1;
      break;
      AppMethodBeat.o(255657);
      return i;
    }
  }
  
  private void iL()
  {
    AppMethodBeat.i(255662);
    int i2;
    Object localObject;
    label34:
    int i3;
    label51:
    int i;
    int j;
    int[] arrayOfInt;
    int i4;
    LayoutParams localLayoutParams;
    label103:
    f localf;
    boolean bool1;
    int i7;
    label147:
    boolean bool2;
    int i5;
    if (this.XU == 0) {
      if (this.mOrientation == 0)
      {
        i2 = 1;
        if (i2 == 0) {
          break label266;
        }
        localObject = this.XP;
        if (((d)localObject).Yq == -2147483648) {
          break label275;
        }
        i3 = ((d)localObject).Yq;
        i = 0;
        j = 0;
        arrayOfInt = new int[i3];
        int i6 = getChildCount();
        i4 = 0;
        if (i4 >= i6) {
          break label477;
        }
        localLayoutParams = (LayoutParams)getChildAt(i4).getLayoutParams();
        if (i2 == 0) {
          break label281;
        }
        localObject = localLayoutParams.Zk;
        localf = ((i)localObject).Yk;
        bool1 = ((i)localObject).Zq;
        i7 = localf.size();
        if (bool1) {
          i = localf.min;
        }
        if (i2 == 0) {
          break label291;
        }
        localObject = localLayoutParams.Zl;
        localf = ((i)localObject).Yk;
        bool2 = ((i)localObject).Zq;
        i5 = localf.size();
        if (i3 != 0) {
          break label301;
        }
        if (!bool2) {
          break label529;
        }
      }
    }
    label266:
    label396:
    label529:
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
            label221:
            k = j + i5;
            if (k > arrayOfInt.length) {
              i = 0;
            }
            for (;;)
            {
              n = j;
              i1 = m;
              if (i != 0) {
                break label396;
              }
              if (!bool2) {
                break label369;
              }
              m += 1;
              break label221;
              i2 = 0;
              break;
              localObject = this.XQ;
              break label34;
              label275:
              i3 = 0;
              break label51;
              label281:
              localObject = localLayoutParams.Zl;
              break label103;
              label291:
              localObject = localLayoutParams.Zk;
              break label147;
              label301:
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
                  break label364;
                }
                if (arrayOfInt[i] > m)
                {
                  i = 0;
                  break;
                }
                i += 1;
              }
              label364:
              i = 1;
            }
            label369:
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
      label477:
      this.XU = iK();
      AppMethodBeat.o(255662);
      return;
      if (this.XU != iK())
      {
        this.mPrinter.println("The fields of some layout parameters were modified in between layout operations. Check the javadoc for GridLayout.LayoutParams#rowSpec.");
        iI();
        break;
      }
      AppMethodBeat.o(255662);
      return;
    }
  }
  
  public static i iM()
  {
    AppMethodBeat.i(255684);
    i locali = a(-2147483648, 1, XV, 0.0F);
    AppMethodBeat.o(255684);
    return locali;
  }
  
  final int a(View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(255625);
    Object localObject = (LayoutParams)paramView.getLayoutParams();
    int i;
    if (paramBoolean1) {
      if (paramBoolean2) {
        i = ((LayoutParams)localObject).leftMargin;
      }
    }
    while (i == -2147483648) {
      if (!this.XR)
      {
        AppMethodBeat.o(255625);
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
        label107:
        boolean bool;
        if (paramBoolean1)
        {
          localObject = ((LayoutParams)localObject).Zl;
          if (!paramBoolean1) {
            break label189;
          }
          locald = this.XP;
          localObject = ((i)localObject).Yk;
          bool = paramBoolean2;
          if (paramBoolean1)
          {
            bool = paramBoolean2;
            if (iH())
            {
              if (paramBoolean2) {
                break label198;
              }
              bool = true;
            }
          }
          label138:
          if (!bool) {
            break label204;
          }
          if (((f)localObject).min == 0) {}
        }
        for (;;)
        {
          if ((paramView.getClass() != androidx.legacy.widget.Space.class) && (paramView.getClass() != android.widget.Space.class)) {
            break label213;
          }
          AppMethodBeat.o(255625);
          return 0;
          localObject = ((LayoutParams)localObject).Zk;
          break;
          label189:
          locald = this.XQ;
          break label107;
          label198:
          bool = false;
          break label138;
          label204:
          locald.getCount();
        }
        label213:
        i = this.XT / 2;
        AppMethodBeat.o(255625);
        return i;
      }
    }
    AppMethodBeat.o(255625);
    return i;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(255654);
    if (!(paramLayoutParams instanceof LayoutParams))
    {
      AppMethodBeat.o(255654);
      return false;
    }
    paramLayoutParams = (LayoutParams)paramLayoutParams;
    a(paramLayoutParams, true);
    a(paramLayoutParams, false);
    AppMethodBeat.o(255654);
    return true;
  }
  
  final int e(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(255635);
    int i = b(paramView, paramBoolean, true);
    int j = b(paramView, paramBoolean, false);
    AppMethodBeat.o(255635);
    return i + j;
  }
  
  public int getAlignmentMode()
  {
    return this.XS;
  }
  
  public int getColumnCount()
  {
    AppMethodBeat.i(255601);
    int i = this.XP.getCount();
    AppMethodBeat.o(255601);
    return i;
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
    AppMethodBeat.i(255598);
    int i = this.XQ.getCount();
    AppMethodBeat.o(255598);
    return i;
  }
  
  public boolean getUseDefaultMargins()
  {
    return this.XR;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(255680);
    iL();
    paramInt3 -= paramInt1;
    int i = getPaddingLeft();
    int j = getPaddingTop();
    int k = getPaddingRight();
    paramInt1 = getPaddingBottom();
    this.XP.cc(paramInt3 - i - k);
    this.XQ.cc(paramInt4 - paramInt2 - j - paramInt1);
    int[] arrayOfInt1 = this.XP.iZ();
    int[] arrayOfInt2 = this.XQ.iZ();
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
        Object localObject1 = ((LayoutParams)localObject2).Zl;
        localObject2 = ((LayoutParams)localObject2).Zk;
        Object localObject3 = ((i)localObject1).Yk;
        Object localObject4 = ((i)localObject2).Yk;
        paramInt2 = arrayOfInt1[localObject3.min];
        m = arrayOfInt2[localObject4.min];
        i1 = arrayOfInt1[localObject3.max];
        n = arrayOfInt2[localObject4.max];
        i5 = i1 - paramInt2;
        i7 = n - m;
        int i10 = f(localView, true);
        int i8 = f(localView, false);
        localObject1 = ((i)localObject1).am(true);
        localObject2 = ((i)localObject2).am(false);
        localObject3 = (e)this.XP.iT().ce(paramInt1);
        localObject4 = (e)this.XQ.iT().ce(paramInt1);
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
        i5 = ((a)localObject1).R(i10, i5 - i11);
        i7 = ((a)localObject2).R(i8, i7 - i12);
        paramInt2 = i9 + (paramInt2 + i6);
        if (iH()) {
          break label531;
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
        label531:
        paramInt2 = paramInt3 - i5 - k - i4 - paramInt2;
      }
    }
    AppMethodBeat.o(255680);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(255672);
    iL();
    iJ();
    int m = getPaddingLeft() + getPaddingRight();
    int k = getPaddingTop() + getPaddingBottom();
    int n = P(paramInt1, -m);
    int i1 = P(paramInt2, -k);
    d(n, i1, true);
    int j;
    int i;
    if (this.mOrientation == 0)
    {
      j = this.XP.cb(n);
      d(n, i1, false);
      i = this.XQ.cb(i1);
    }
    for (;;)
    {
      j = Math.max(j + m, getSuggestedMinimumWidth());
      i = Math.max(i + k, getSuggestedMinimumHeight());
      setMeasuredDimension(View.resolveSizeAndState(j, paramInt1, 0), View.resolveSizeAndState(i, paramInt2, 0));
      AppMethodBeat.o(255672);
      return;
      i = this.XQ.cb(i1);
      d(n, i1, false);
      j = this.XP.cb(n);
    }
  }
  
  public void requestLayout()
  {
    AppMethodBeat.i(255676);
    super.requestLayout();
    iI();
    AppMethodBeat.o(255676);
  }
  
  public void setAlignmentMode(int paramInt)
  {
    AppMethodBeat.i(255609);
    this.XS = paramInt;
    requestLayout();
    AppMethodBeat.o(255609);
  }
  
  public void setColumnCount(int paramInt)
  {
    AppMethodBeat.i(255603);
    this.XP.setCount(paramInt);
    iI();
    requestLayout();
    AppMethodBeat.o(255603);
  }
  
  public void setColumnOrderPreserved(boolean paramBoolean)
  {
    AppMethodBeat.i(255612);
    this.XP.aj(paramBoolean);
    iI();
    requestLayout();
    AppMethodBeat.o(255612);
  }
  
  public void setOrientation(int paramInt)
  {
    AppMethodBeat.i(255597);
    if (this.mOrientation != paramInt)
    {
      this.mOrientation = paramInt;
      iI();
      requestLayout();
    }
    AppMethodBeat.o(255597);
  }
  
  public void setPrinter(Printer paramPrinter)
  {
    Printer localPrinter = paramPrinter;
    if (paramPrinter == null) {
      localPrinter = XH;
    }
    this.mPrinter = localPrinter;
  }
  
  public void setRowCount(int paramInt)
  {
    AppMethodBeat.i(255600);
    this.XQ.setCount(paramInt);
    iI();
    requestLayout();
    AppMethodBeat.o(255600);
  }
  
  public void setRowOrderPreserved(boolean paramBoolean)
  {
    AppMethodBeat.i(255610);
    this.XQ.aj(paramBoolean);
    iI();
    requestLayout();
    AppMethodBeat.o(255610);
  }
  
  public void setUseDefaultMargins(boolean paramBoolean)
  {
    AppMethodBeat.i(255606);
    this.XR = paramBoolean;
    requestLayout();
    AppMethodBeat.o(255606);
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    private static final GridLayout.f YW;
    private static final int YX;
    private static final int YY;
    private static final int YZ;
    private static final int Za;
    private static final int Zb;
    private static final int Zc;
    private static final int Zd;
    private static final int Ze;
    private static final int Zf;
    private static final int Zg;
    private static final int Zh;
    private static final int Zi;
    private static final int Zj;
    public GridLayout.i Zk;
    public GridLayout.i Zl;
    
    static
    {
      AppMethodBeat.i(255574);
      GridLayout.f localf = new GridLayout.f(-2147483648, -2147483647);
      YW = localf;
      YX = localf.size();
      YY = a.b.Xu;
      YZ = a.b.Xv;
      Za = a.b.Xw;
      Zb = a.b.Xx;
      Zc = a.b.Xy;
      Zd = a.b.Xz;
      Ze = a.b.XA;
      Zf = a.b.XB;
      Zg = a.b.XD;
      Zh = a.b.XE;
      Zi = a.b.XF;
      Zj = a.b.XC;
      AppMethodBeat.o(255574);
    }
    
    public LayoutParams()
    {
      this(locali, locali, (byte)0);
      AppMethodBeat.i(255555);
      AppMethodBeat.o(255555);
    }
    
    /* Error */
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_1
      //   2: aload_2
      //   3: invokespecial 129	android/view/ViewGroup$MarginLayoutParams:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;)V
      //   6: ldc 130
      //   8: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   11: aload_0
      //   12: getstatic 122	androidx/gridlayout/widget/GridLayout$i:Zp	Landroidx/gridlayout/widget/GridLayout$i;
      //   15: putfield 132	androidx/gridlayout/widget/GridLayout$LayoutParams:Zk	Landroidx/gridlayout/widget/GridLayout$i;
      //   18: aload_0
      //   19: getstatic 122	androidx/gridlayout/widget/GridLayout$i:Zp	Landroidx/gridlayout/widget/GridLayout$i;
      //   22: putfield 134	androidx/gridlayout/widget/GridLayout$LayoutParams:Zl	Landroidx/gridlayout/widget/GridLayout$i;
      //   25: aload_1
      //   26: aload_2
      //   27: getstatic 138	androidx/gridlayout/a$b:Xt	[I
      //   30: invokevirtual 144	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;
      //   33: astore 7
      //   35: aload 7
      //   37: getstatic 58	androidx/gridlayout/widget/GridLayout$LayoutParams:YY	I
      //   40: ldc 38
      //   42: invokevirtual 150	android/content/res/TypedArray:getDimensionPixelSize	(II)I
      //   45: istore 4
      //   47: aload_0
      //   48: aload 7
      //   50: getstatic 63	androidx/gridlayout/widget/GridLayout$LayoutParams:YZ	I
      //   53: iload 4
      //   55: invokevirtual 150	android/content/res/TypedArray:getDimensionPixelSize	(II)I
      //   58: putfield 153	androidx/gridlayout/widget/GridLayout$LayoutParams:leftMargin	I
      //   61: aload_0
      //   62: aload 7
      //   64: getstatic 68	androidx/gridlayout/widget/GridLayout$LayoutParams:Za	I
      //   67: iload 4
      //   69: invokevirtual 150	android/content/res/TypedArray:getDimensionPixelSize	(II)I
      //   72: putfield 156	androidx/gridlayout/widget/GridLayout$LayoutParams:topMargin	I
      //   75: aload_0
      //   76: aload 7
      //   78: getstatic 73	androidx/gridlayout/widget/GridLayout$LayoutParams:Zb	I
      //   81: iload 4
      //   83: invokevirtual 150	android/content/res/TypedArray:getDimensionPixelSize	(II)I
      //   86: putfield 159	androidx/gridlayout/widget/GridLayout$LayoutParams:rightMargin	I
      //   89: aload_0
      //   90: aload 7
      //   92: getstatic 78	androidx/gridlayout/widget/GridLayout$LayoutParams:Zc	I
      //   95: iload 4
      //   97: invokevirtual 150	android/content/res/TypedArray:getDimensionPixelSize	(II)I
      //   100: putfield 162	androidx/gridlayout/widget/GridLayout$LayoutParams:bottomMargin	I
      //   103: aload 7
      //   105: invokevirtual 165	android/content/res/TypedArray:recycle	()V
      //   108: aload_1
      //   109: aload_2
      //   110: getstatic 138	androidx/gridlayout/a$b:Xt	[I
      //   113: invokevirtual 144	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;
      //   116: astore_1
      //   117: aload_1
      //   118: getstatic 113	androidx/gridlayout/widget/GridLayout$LayoutParams:Zj	I
      //   121: iconst_0
      //   122: invokevirtual 168	android/content/res/TypedArray:getInt	(II)I
      //   125: istore 4
      //   127: aload_1
      //   128: getstatic 83	androidx/gridlayout/widget/GridLayout$LayoutParams:Zd	I
      //   131: ldc 38
      //   133: invokevirtual 168	android/content/res/TypedArray:getInt	(II)I
      //   136: istore 5
      //   138: aload_1
      //   139: getstatic 88	androidx/gridlayout/widget/GridLayout$LayoutParams:Ze	I
      //   142: getstatic 51	androidx/gridlayout/widget/GridLayout$LayoutParams:YX	I
      //   145: invokevirtual 168	android/content/res/TypedArray:getInt	(II)I
      //   148: istore 6
      //   150: aload_1
      //   151: getstatic 93	androidx/gridlayout/widget/GridLayout$LayoutParams:Zf	I
      //   154: fconst_0
      //   155: invokevirtual 172	android/content/res/TypedArray:getFloat	(IF)F
      //   158: fstore_3
      //   159: aload_0
      //   160: iload 5
      //   162: iload 6
      //   164: iload 4
      //   166: iconst_1
      //   167: invokestatic 176	androidx/gridlayout/widget/GridLayout:g	(IZ)Landroidx/gridlayout/widget/GridLayout$a;
      //   170: fload_3
      //   171: invokestatic 180	androidx/gridlayout/widget/GridLayout:a	(IILandroidx/gridlayout/widget/GridLayout$a;F)Landroidx/gridlayout/widget/GridLayout$i;
      //   174: putfield 134	androidx/gridlayout/widget/GridLayout$LayoutParams:Zl	Landroidx/gridlayout/widget/GridLayout$i;
      //   177: aload_1
      //   178: getstatic 98	androidx/gridlayout/widget/GridLayout$LayoutParams:Zg	I
      //   181: ldc 38
      //   183: invokevirtual 168	android/content/res/TypedArray:getInt	(II)I
      //   186: istore 5
      //   188: aload_1
      //   189: getstatic 103	androidx/gridlayout/widget/GridLayout$LayoutParams:Zh	I
      //   192: getstatic 51	androidx/gridlayout/widget/GridLayout$LayoutParams:YX	I
      //   195: invokevirtual 168	android/content/res/TypedArray:getInt	(II)I
      //   198: istore 6
      //   200: aload_1
      //   201: getstatic 108	androidx/gridlayout/widget/GridLayout$LayoutParams:Zi	I
      //   204: fconst_0
      //   205: invokevirtual 172	android/content/res/TypedArray:getFloat	(IF)F
      //   208: fstore_3
      //   209: aload_0
      //   210: iload 5
      //   212: iload 6
      //   214: iload 4
      //   216: iconst_0
      //   217: invokestatic 176	androidx/gridlayout/widget/GridLayout:g	(IZ)Landroidx/gridlayout/widget/GridLayout$a;
      //   220: fload_3
      //   221: invokestatic 180	androidx/gridlayout/widget/GridLayout:a	(IILandroidx/gridlayout/widget/GridLayout$a;F)Landroidx/gridlayout/widget/GridLayout$i;
      //   224: putfield 132	androidx/gridlayout/widget/GridLayout$LayoutParams:Zk	Landroidx/gridlayout/widget/GridLayout$i;
      //   227: aload_1
      //   228: invokevirtual 165	android/content/res/TypedArray:recycle	()V
      //   231: ldc 130
      //   233: invokestatic 116	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   236: return
      //   237: astore_1
      //   238: aload 7
      //   240: invokevirtual 165	android/content/res/TypedArray:recycle	()V
      //   243: ldc 130
      //   245: invokestatic 116	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   248: aload_1
      //   249: athrow
      //   250: astore_2
      //   251: aload_1
      //   252: invokevirtual 165	android/content/res/TypedArray:recycle	()V
      //   255: ldc 130
      //   257: invokestatic 116	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   260: aload_2
      //   261: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	262	0	this	LayoutParams
      //   0	262	1	paramContext	Context
      //   0	262	2	paramAttributeSet	AttributeSet
      //   158	63	3	f	float
      //   45	170	4	i	int
      //   136	75	5	j	int
      //   148	65	6	k	int
      //   33	206	7	localTypedArray	TypedArray
      // Exception table:
      //   from	to	target	type
      //   35	103	237	finally
      //   117	227	250	finally
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
      this.Zk = GridLayout.i.Zp;
      this.Zl = GridLayout.i.Zp;
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
      this.Zk = GridLayout.i.Zp;
      this.Zl = GridLayout.i.Zp;
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      this.Zk = GridLayout.i.Zp;
      this.Zl = GridLayout.i.Zp;
      this.Zk = paramLayoutParams.Zk;
      this.Zl = paramLayoutParams.Zl;
    }
    
    private LayoutParams(GridLayout.i parami1, GridLayout.i parami2)
    {
      super(-2);
      AppMethodBeat.i(255553);
      this.Zk = GridLayout.i.Zp;
      this.Zl = GridLayout.i.Zp;
      setMargins(-2147483648, -2147483648, -2147483648, -2147483648);
      this.Zk = parami1;
      this.Zl = parami2;
      AppMethodBeat.o(255553);
    }
    
    private LayoutParams(GridLayout.i parami1, GridLayout.i parami2, byte paramByte)
    {
      this(parami1, parami2);
    }
    
    public boolean equals(Object paramObject)
    {
      AppMethodBeat.i(255569);
      if (this == paramObject)
      {
        AppMethodBeat.o(255569);
        return true;
      }
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
      {
        AppMethodBeat.o(255569);
        return false;
      }
      paramObject = (LayoutParams)paramObject;
      if (!this.Zl.equals(paramObject.Zl))
      {
        AppMethodBeat.o(255569);
        return false;
      }
      if (!this.Zk.equals(paramObject.Zk))
      {
        AppMethodBeat.o(255569);
        return false;
      }
      AppMethodBeat.o(255569);
      return true;
    }
    
    public int hashCode()
    {
      AppMethodBeat.i(255572);
      int i = this.Zk.hashCode();
      int j = this.Zl.hashCode();
      AppMethodBeat.o(255572);
      return i * 31 + j;
    }
    
    protected void setBaseAttributes(TypedArray paramTypedArray, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(255567);
      this.width = paramTypedArray.getLayoutDimension(paramInt1, -2);
      this.height = paramTypedArray.getLayoutDimension(paramInt2, -2);
      AppMethodBeat.o(255567);
    }
  }
  
  public static abstract class a
  {
    abstract int B(View paramView, int paramInt);
    
    int R(int paramInt1, int paramInt2)
    {
      return paramInt1;
    }
    
    abstract int h(View paramView, int paramInt1, int paramInt2);
    
    abstract String iN();
    
    GridLayout.e iO()
    {
      return new GridLayout.e();
    }
    
    public String toString()
    {
      return "Alignment:" + iN();
    }
  }
  
  final class d
  {
    public int[] YA;
    public boolean YB;
    public GridLayout.b[] YC;
    public boolean YD;
    public int[] YE;
    public boolean YF;
    public boolean YG;
    public boolean YH;
    public int[] YI;
    boolean YJ;
    private GridLayout.g YK;
    private GridLayout.g YL;
    public final boolean Yp;
    public int Yq;
    private int Yr;
    GridLayout.h<GridLayout.i, GridLayout.e> Ys;
    public boolean Yt;
    GridLayout.h<GridLayout.f, GridLayout.g> Yu;
    public boolean Yv;
    GridLayout.h<GridLayout.f, GridLayout.g> Yw;
    public boolean Yx;
    public int[] Yy;
    public boolean Yz;
    
    static
    {
      AppMethodBeat.i(255509);
      if (!GridLayout.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(255509);
        return;
      }
    }
    
    d(boolean paramBoolean)
    {
      AppMethodBeat.i(255461);
      this.Yq = -2147483648;
      this.Yr = -2147483648;
      this.Yt = false;
      this.Yv = false;
      this.Yx = false;
      this.Yz = false;
      this.YB = false;
      this.YD = false;
      this.YF = false;
      this.YH = false;
      this.YJ = true;
      this.YK = new GridLayout.g(0);
      this.YL = new GridLayout.g(-100000);
      this.Yp = paramBoolean;
      AppMethodBeat.o(255461);
    }
    
    private void S(int paramInt1, int paramInt2)
    {
      this.YK.value = paramInt1;
      this.YL.value = (-paramInt2);
      this.YF = false;
    }
    
    private int T(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(255502);
      S(paramInt1, paramInt2);
      paramInt1 = iZ()[getCount()];
      AppMethodBeat.o(255502);
      return paramInt1;
    }
    
    private void a(GridLayout.h<GridLayout.f, GridLayout.g> paramh, boolean paramBoolean)
    {
      int j = 0;
      AppMethodBeat.i(255471);
      Object localObject = (GridLayout.g[])paramh.Zo;
      int i = 0;
      while (i < localObject.length)
      {
        localObject[i].value = -2147483648;
        i += 1;
      }
      localObject = (GridLayout.e[])iT().Zo;
      i = j;
      if (i < localObject.length)
      {
        j = localObject[i].ai(paramBoolean);
        GridLayout.g localg = (GridLayout.g)paramh.ce(i);
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
      AppMethodBeat.o(255471);
    }
    
    private static void a(List<GridLayout.b> paramList, GridLayout.f paramf, GridLayout.g paramg)
    {
      AppMethodBeat.i(255476);
      a(paramList, paramf, paramg, true);
      AppMethodBeat.o(255476);
    }
    
    private static void a(List<GridLayout.b> paramList, GridLayout.f paramf, GridLayout.g paramg, boolean paramBoolean)
    {
      AppMethodBeat.i(255474);
      if (paramf.size() == 0)
      {
        AppMethodBeat.o(255474);
        return;
      }
      if (paramBoolean)
      {
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext()) {
          if (((GridLayout.b)localIterator.next()).Yk.equals(paramf))
          {
            AppMethodBeat.o(255474);
            return;
          }
        }
      }
      paramList.add(new GridLayout.b(paramf, paramg));
      AppMethodBeat.o(255474);
    }
    
    private static void a(List<GridLayout.b> paramList, GridLayout.h<GridLayout.f, GridLayout.g> paramh)
    {
      AppMethodBeat.i(255480);
      int i = 0;
      while (i < ((GridLayout.f[])paramh.Zn).length)
      {
        a(paramList, ((GridLayout.f[])paramh.Zn)[i], ((GridLayout.g[])paramh.Zo)[i], false);
        i += 1;
      }
      AppMethodBeat.o(255480);
    }
    
    private static boolean a(int[] paramArrayOfInt, GridLayout.b paramb)
    {
      if (!paramb.Ym) {}
      int j;
      int i;
      do
      {
        return false;
        GridLayout.f localf = paramb.Yk;
        j = localf.min;
        i = localf.max;
        int k = paramb.Yl.value;
        j = paramArrayOfInt[j] + k;
      } while (j <= paramArrayOfInt[i]);
      paramArrayOfInt[i] = j;
      return true;
    }
    
    private boolean a(GridLayout.b[] paramArrayOfb, int[] paramArrayOfInt, boolean paramBoolean)
    {
      AppMethodBeat.i(255491);
      String str;
      int n;
      Object localObject1;
      int i;
      int j;
      if (this.Yp)
      {
        str = "horizontal";
        n = getCount() + 1;
        localObject1 = null;
        i = 0;
        if (i < paramArrayOfb.length)
        {
          Arrays.fill(paramArrayOfInt, 0);
          j = 0;
        }
      }
      else
      {
        int k;
        GridLayout.b localb;
        for (;;)
        {
          if (j >= n) {
            break label262;
          }
          boolean bool = false;
          k = 0;
          int i1 = paramArrayOfb.length;
          for (;;)
          {
            if (k < i1)
            {
              bool |= a(paramArrayOfInt, paramArrayOfb[k]);
              k += 1;
              continue;
              str = "vertical";
              break;
            }
          }
          if (!bool)
          {
            if (localObject1 != null)
            {
              paramArrayOfInt = new ArrayList();
              localObject2 = new ArrayList();
              i = 0;
              while (i < paramArrayOfb.length)
              {
                localb = paramArrayOfb[i];
                if (localObject1[i] != 0) {
                  paramArrayOfInt.add(localb);
                }
                if (!localb.Ym) {
                  ((List)localObject2).add(localb);
                }
                i += 1;
              }
              GridLayout.this.mPrinter.println(str + " constraints: " + j(paramArrayOfInt) + " are inconsistent; permanently removing: " + j((List)localObject2) + ". ");
            }
            AppMethodBeat.o(255491);
            return true;
          }
          j += 1;
        }
        label262:
        if (!paramBoolean)
        {
          AppMethodBeat.o(255491);
          return false;
        }
        Object localObject2 = new boolean[paramArrayOfb.length];
        j = 0;
        while (j < n)
        {
          k = 0;
          int m = paramArrayOfb.length;
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
              if (localb.Yk.min >= localb.Yk.max) {
                localb.Ym = false;
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
      }
      AppMethodBeat.o(255491);
      return true;
    }
    
    private GridLayout.h<GridLayout.f, GridLayout.g> ak(boolean paramBoolean)
    {
      AppMethodBeat.i(255470);
      GridLayout.c localc = GridLayout.c.a(GridLayout.f.class, GridLayout.g.class);
      GridLayout.i[] arrayOfi = (GridLayout.i[])iT().Zn;
      int j = arrayOfi.length;
      int i = 0;
      if (i < j)
      {
        if (paramBoolean) {}
        for (localObject = arrayOfi[i].Yk;; localObject = new GridLayout.f(((GridLayout.f)localObject).max, ((GridLayout.f)localObject).min))
        {
          localc.e(localObject, new GridLayout.g());
          i += 1;
          break;
          localObject = arrayOfi[i].Yk;
        }
      }
      Object localObject = localc.iP();
      AppMethodBeat.o(255470);
      return localObject;
    }
    
    private void d(int paramInt, float paramFloat)
    {
      AppMethodBeat.i(255496);
      Arrays.fill(this.YI, 0);
      int k = GridLayout.this.getChildCount();
      int j = 0;
      int i = paramInt;
      paramInt = j;
      Object localObject;
      if (paramInt < k)
      {
        localObject = GridLayout.this.getChildAt(paramInt);
        if (((View)localObject).getVisibility() == 8) {
          break label146;
        }
        localObject = GridLayout.aL((View)localObject);
        if (this.Yp)
        {
          localObject = ((GridLayout.LayoutParams)localObject).Zl;
          label79:
          float f = ((GridLayout.i)localObject).pO;
          if (f == 0.0F) {
            break label146;
          }
          j = Math.round(i * f / paramFloat);
          this.YI[paramInt] = j;
          i -= j;
          paramFloat -= f;
        }
      }
      label146:
      for (;;)
      {
        paramInt += 1;
        break;
        localObject = ((GridLayout.LayoutParams)localObject).Zk;
        break label79;
        AppMethodBeat.o(255496);
        return;
      }
    }
    
    private boolean h(int[] paramArrayOfInt)
    {
      AppMethodBeat.i(255493);
      boolean bool = a(iX(), paramArrayOfInt, true);
      AppMethodBeat.o(255493);
      return bool;
    }
    
    private void i(int[] paramArrayOfInt)
    {
      float f = 0.0F;
      boolean bool2 = true;
      int n = 0;
      AppMethodBeat.i(255498);
      int j;
      int i;
      Object localObject;
      label79:
      boolean bool1;
      if (!this.YH)
      {
        j = GridLayout.this.getChildCount();
        i = 0;
        if (i >= j) {
          break label174;
        }
        localObject = GridLayout.this.getChildAt(i);
        if (((View)localObject).getVisibility() == 8) {
          break label167;
        }
        localObject = GridLayout.aL((View)localObject);
        if (this.Yp)
        {
          localObject = ((GridLayout.LayoutParams)localObject).Zl;
          if (((GridLayout.i)localObject).pO == 0.0F) {
            break label167;
          }
          bool1 = true;
          label92:
          this.YG = bool1;
          this.YH = true;
        }
      }
      else
      {
        if (this.YG) {
          break label180;
        }
        h(paramArrayOfInt);
      }
      label116:
      int k;
      for (;;)
      {
        if (!this.YJ)
        {
          j = paramArrayOfInt[0];
          k = paramArrayOfInt.length;
          i = n;
          for (;;)
          {
            label277:
            if (i < k)
            {
              paramArrayOfInt[i] -= j;
              i += 1;
              continue;
              localObject = ((GridLayout.LayoutParams)localObject).Zk;
              break label79;
              label167:
              i += 1;
              break;
              label174:
              bool1 = false;
              break label92;
              label180:
              Arrays.fill(iY(), 0);
              h(paramArrayOfInt);
              j = this.YK.value * GridLayout.this.getChildCount() + 1;
              if (j < 2) {
                break label116;
              }
              k = GridLayout.this.getChildCount();
              i = 0;
              label230:
              if (i < k)
              {
                localObject = GridLayout.this.getChildAt(i);
                if (((View)localObject).getVisibility() == 8) {
                  break label422;
                }
                localObject = GridLayout.aL((View)localObject);
                if (this.Yp)
                {
                  localObject = ((GridLayout.LayoutParams)localObject).Zl;
                  f = ((GridLayout.i)localObject).pO + f;
                }
              }
            }
          }
        }
      }
      label422:
      for (;;)
      {
        i += 1;
        break label230;
        localObject = ((GridLayout.LayoutParams)localObject).Zk;
        break label277;
        int m = -1;
        k = 0;
        i = j;
        bool1 = bool2;
        j = m;
        while (k < i)
        {
          m = (int)((k + i) / 2L);
          iJ();
          d(m, f);
          bool1 = a(iX(), paramArrayOfInt, false);
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
        iJ();
        d(j, f);
        h(paramArrayOfInt);
        break;
        AppMethodBeat.o(255498);
        return;
      }
    }
    
    private GridLayout.b[] i(List<GridLayout.b> paramList)
    {
      AppMethodBeat.i(255479);
      paramList = new Object()
      {
        GridLayout.b[] YN;
        int YO;
        GridLayout.b[][] YP;
        int[] YQ;
        
        static
        {
          AppMethodBeat.i(255457);
          if (!GridLayout.class.desiredAssertionStatus()) {}
          for (boolean bool = true;; bool = false)
          {
            $assertionsDisabled = bool;
            AppMethodBeat.o(255457);
            return;
          }
        }
        
        final void cd(int paramAnonymousInt)
        {
          AppMethodBeat.i(255455);
          switch (this.YQ[paramAnonymousInt])
          {
          }
          do
          {
            AppMethodBeat.o(255455);
            return;
            this.YQ[paramAnonymousInt] = 1;
            localObject1 = this.YP[paramAnonymousInt];
            int j = localObject1.length;
            int i = 0;
            while (i < j)
            {
              Object localObject2 = localObject1[i];
              cd(localObject2.Yk.max);
              GridLayout.b[] arrayOfb = this.YN;
              int k = this.YO;
              this.YO = (k - 1);
              arrayOfb[k] = localObject2;
              i += 1;
            }
            this.YQ[paramAnonymousInt] = 2;
            AppMethodBeat.o(255455);
            return;
          } while ($assertionsDisabled);
          Object localObject1 = new AssertionError();
          AppMethodBeat.o(255455);
          throw ((Throwable)localObject1);
        }
      };
      int i = 0;
      int j = paramList.YP.length;
      while (i < j)
      {
        paramList.cd(i);
        i += 1;
      }
      if ((!1.$assertionsDisabled) && (paramList.YO != -1))
      {
        paramList = new AssertionError();
        AppMethodBeat.o(255479);
        throw paramList;
      }
      paramList = paramList.YN;
      AppMethodBeat.o(255479);
      return paramList;
    }
    
    private int iQ()
    {
      AppMethodBeat.i(255462);
      int i;
      if (this.Yr == -2147483648)
      {
        int k = GridLayout.this.getChildCount();
        int j = 0;
        i = -1;
        if (j < k)
        {
          Object localObject = GridLayout.aL(GridLayout.this.getChildAt(j));
          if (this.Yp) {}
          for (localObject = ((GridLayout.LayoutParams)localObject).Zl;; localObject = ((GridLayout.LayoutParams)localObject).Zk)
          {
            localObject = ((GridLayout.i)localObject).Yk;
            i = Math.max(Math.max(Math.max(i, ((GridLayout.f)localObject).min), ((GridLayout.f)localObject).max), ((GridLayout.f)localObject).size());
            j += 1;
            break;
          }
        }
        if (i != -1) {
          break label139;
        }
        i = -2147483648;
      }
      label139:
      for (;;)
      {
        this.Yr = Math.max(0, i);
        i = this.Yr;
        AppMethodBeat.o(255462);
        return i;
      }
    }
    
    private GridLayout.h<GridLayout.i, GridLayout.e> iR()
    {
      AppMethodBeat.i(255467);
      GridLayout.c localc = GridLayout.c.a(GridLayout.i.class, GridLayout.e.class);
      int j = GridLayout.this.getChildCount();
      int i = 0;
      if (i < j)
      {
        localObject = GridLayout.aL(GridLayout.this.getChildAt(i));
        if (this.Yp) {}
        for (localObject = ((GridLayout.LayoutParams)localObject).Zl;; localObject = ((GridLayout.LayoutParams)localObject).Zk)
        {
          localc.e(localObject, ((GridLayout.i)localObject).am(this.Yp).iO());
          i += 1;
          break;
        }
      }
      Object localObject = localc.iP();
      AppMethodBeat.o(255467);
      return localObject;
    }
    
    private void iS()
    {
      AppMethodBeat.i(255468);
      Object localObject = (GridLayout.e[])this.Ys.Zo;
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
        localObject = GridLayout.aL(localView);
        label89:
        GridLayout localGridLayout;
        boolean bool;
        int j;
        if (this.Yp)
        {
          localObject = ((GridLayout.LayoutParams)localObject).Zl;
          localGridLayout = GridLayout.this;
          bool = this.Yp;
          if (localView.getVisibility() != 8) {
            break label168;
          }
          j = 0;
          label113:
          if (((GridLayout.i)localObject).pO != 0.0F) {
            break label191;
          }
        }
        label168:
        label191:
        for (int k = 0;; k = iY()[i])
        {
          ((GridLayout.e)this.Ys.ce(i)).a(GridLayout.this, localView, (GridLayout.i)localObject, this, j + k);
          i += 1;
          break;
          localObject = ((GridLayout.LayoutParams)localObject).Zk;
          break label89;
          j = GridLayout.f(localView, bool);
          j = localGridLayout.e(localView, bool) + j;
          break label113;
        }
      }
      AppMethodBeat.o(255468);
    }
    
    private GridLayout.h<GridLayout.f, GridLayout.g> iU()
    {
      AppMethodBeat.i(255472);
      if (this.Yu == null) {
        this.Yu = ak(true);
      }
      if (!this.Yv)
      {
        a(this.Yu, true);
        this.Yv = true;
      }
      GridLayout.h localh = this.Yu;
      AppMethodBeat.o(255472);
      return localh;
    }
    
    private GridLayout.h<GridLayout.f, GridLayout.g> iV()
    {
      AppMethodBeat.i(255473);
      if (this.Yw == null) {
        this.Yw = ak(false);
      }
      if (!this.Yx)
      {
        a(this.Yw, false);
        this.Yx = true;
      }
      GridLayout.h localh = this.Yw;
      AppMethodBeat.o(255473);
      return localh;
    }
    
    private void iW()
    {
      AppMethodBeat.i(255482);
      iU();
      iV();
      AppMethodBeat.o(255482);
    }
    
    private GridLayout.b[] iX()
    {
      AppMethodBeat.i(255485);
      if (this.YC == null)
      {
        localObject = new ArrayList();
        ArrayList localArrayList = new ArrayList();
        a((List)localObject, iU());
        a(localArrayList, iV());
        if (this.YJ)
        {
          i = 0;
          while (i < getCount())
          {
            a((List)localObject, new GridLayout.f(i, i + 1), new GridLayout.g(0));
            i += 1;
          }
        }
        int i = getCount();
        a((List)localObject, new GridLayout.f(0, i), this.YK, false);
        a(localArrayList, new GridLayout.f(i, 0), this.YL, false);
        this.YC = ((GridLayout.b[])GridLayout.a(i((List)localObject), i(localArrayList)));
      }
      if (!this.YD)
      {
        iW();
        this.YD = true;
      }
      Object localObject = this.YC;
      AppMethodBeat.o(255485);
      return localObject;
    }
    
    private int[] iY()
    {
      AppMethodBeat.i(255494);
      if (this.YI == null) {
        this.YI = new int[GridLayout.this.getChildCount()];
      }
      int[] arrayOfInt = this.YI;
      AppMethodBeat.o(255494);
      return arrayOfInt;
    }
    
    private String j(List<GridLayout.b> paramList)
    {
      AppMethodBeat.i(255489);
      String str;
      label40:
      label68:
      int j;
      int k;
      int m;
      if (this.Yp)
      {
        str = "x";
        localObject = new StringBuilder();
        Iterator localIterator = paramList.iterator();
        int i = 1;
        paramList = (List<GridLayout.b>)localObject;
        if (!localIterator.hasNext()) {
          break label232;
        }
        localObject = (GridLayout.b)localIterator.next();
        if (i == 0) {
          break label169;
        }
        i = 0;
        j = ((GridLayout.b)localObject).Yk.min;
        k = ((GridLayout.b)localObject).Yk.max;
        m = ((GridLayout.b)localObject).Yl.value;
        if (j >= k) {
          break label180;
        }
      }
      label169:
      label180:
      for (Object localObject = str + k + "-" + str + j + ">=" + m;; localObject = str + j + "-" + str + k + "<=" + -m)
      {
        paramList.append((String)localObject);
        break label40;
        str = "y";
        break;
        paramList = paramList.append(", ");
        break label68;
      }
      label232:
      paramList = paramList.toString();
      AppMethodBeat.o(255489);
      return paramList;
    }
    
    final GridLayout.b[][] a(GridLayout.b[] paramArrayOfb)
    {
      int j = 0;
      AppMethodBeat.i(255478);
      int i = getCount() + 1;
      GridLayout.b[][] arrayOfb; = new GridLayout.b[i][];
      int[] arrayOfInt = new int[i];
      int k = paramArrayOfb.length;
      i = 0;
      int m;
      while (i < k)
      {
        m = paramArrayOfb[i].Yk.min;
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
        j = localb.Yk.min;
        [Landroidx.gridlayout.widget.GridLayout.b localb; = arrayOfb;[j];
        m = arrayOfInt[j];
        arrayOfInt[j] = (m + 1);
        localb;[m] = localb;
        i += 1;
      }
      AppMethodBeat.o(255478);
      return arrayOfb;;
    }
    
    public final void aj(boolean paramBoolean)
    {
      AppMethodBeat.i(255466);
      this.YJ = paramBoolean;
      iI();
      AppMethodBeat.o(255466);
    }
    
    final void al(boolean paramBoolean)
    {
      AppMethodBeat.i(255492);
      int[] arrayOfInt;
      int i;
      label27:
      View localView;
      Object localObject;
      if (paramBoolean)
      {
        arrayOfInt = this.Yy;
        int k = GridLayout.this.getChildCount();
        i = 0;
        if (i >= k) {
          break label151;
        }
        localView = GridLayout.this.getChildAt(i);
        if (localView.getVisibility() != 8)
        {
          localObject = GridLayout.aL(localView);
          if (!this.Yp) {
            break label132;
          }
          localObject = ((GridLayout.LayoutParams)localObject).Zl;
          label74:
          localObject = ((GridLayout.i)localObject).Yk;
          if (!paramBoolean) {
            break label142;
          }
        }
      }
      label132:
      label142:
      for (int j = ((GridLayout.f)localObject).min;; j = ((GridLayout.f)localObject).max)
      {
        arrayOfInt[j] = Math.max(arrayOfInt[j], GridLayout.this.a(localView, this.Yp, paramBoolean));
        i += 1;
        break label27;
        arrayOfInt = this.YA;
        break;
        localObject = ((GridLayout.LayoutParams)localObject).Zk;
        break label74;
      }
      label151:
      AppMethodBeat.o(255492);
    }
    
    public final int cb(int paramInt)
    {
      AppMethodBeat.i(255505);
      int i = View.MeasureSpec.getMode(paramInt);
      paramInt = View.MeasureSpec.getSize(paramInt);
      switch (i)
      {
      default: 
        if (!$assertionsDisabled)
        {
          AssertionError localAssertionError = new AssertionError();
          AppMethodBeat.o(255505);
          throw localAssertionError;
        }
        break;
      case 0: 
        paramInt = T(0, 100000);
        AppMethodBeat.o(255505);
        return paramInt;
      case 1073741824: 
        paramInt = T(paramInt, paramInt);
        AppMethodBeat.o(255505);
        return paramInt;
      case -2147483648: 
        paramInt = T(0, paramInt);
        AppMethodBeat.o(255505);
        return paramInt;
      }
      AppMethodBeat.o(255505);
      return 0;
    }
    
    public final void cc(int paramInt)
    {
      AppMethodBeat.i(255506);
      S(paramInt, paramInt);
      iZ();
      AppMethodBeat.o(255506);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(255463);
      int i = Math.max(this.Yq, iQ());
      AppMethodBeat.o(255463);
      return i;
    }
    
    public final void iI()
    {
      AppMethodBeat.i(255508);
      this.Yr = -2147483648;
      this.Ys = null;
      this.Yu = null;
      this.Yw = null;
      this.Yy = null;
      this.YA = null;
      this.YC = null;
      this.YE = null;
      this.YI = null;
      this.YH = false;
      iJ();
      AppMethodBeat.o(255508);
    }
    
    public final void iJ()
    {
      this.Yt = false;
      this.Yv = false;
      this.Yx = false;
      this.Yz = false;
      this.YB = false;
      this.YD = false;
      this.YF = false;
    }
    
    public final GridLayout.h<GridLayout.i, GridLayout.e> iT()
    {
      AppMethodBeat.i(255469);
      if (this.Ys == null) {
        this.Ys = iR();
      }
      if (!this.Yt)
      {
        iS();
        this.Yt = true;
      }
      GridLayout.h localh = this.Ys;
      AppMethodBeat.o(255469);
      return localh;
    }
    
    public final int[] iZ()
    {
      AppMethodBeat.i(255500);
      if (this.YE == null) {
        this.YE = new int[getCount() + 1];
      }
      if (!this.YF)
      {
        i(this.YE);
        this.YF = true;
      }
      int[] arrayOfInt = this.YE;
      AppMethodBeat.o(255500);
      return arrayOfInt;
    }
    
    public final void setCount(int paramInt)
    {
      AppMethodBeat.i(255464);
      StringBuilder localStringBuilder;
      if ((paramInt != -2147483648) && (paramInt < iQ()))
      {
        localStringBuilder = new StringBuilder();
        if (!this.Yp) {
          break label68;
        }
      }
      label68:
      for (String str = "column";; str = "row")
      {
        GridLayout.N(str + "Count must be greater than or equal to the maximum of all grid indices (and spans) defined in the LayoutParams of each child");
        this.Yq = paramInt;
        AppMethodBeat.o(255464);
        return;
      }
    }
  }
  
  static class e
  {
    public int YT;
    public int YU;
    public int YV;
    
    e()
    {
      AppMethodBeat.i(255514);
      reset();
      AppMethodBeat.o(255514);
    }
    
    protected void Q(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(255518);
      this.YT = Math.max(this.YT, paramInt1);
      this.YU = Math.max(this.YU, paramInt2);
      AppMethodBeat.o(255518);
    }
    
    protected int a(GridLayout paramGridLayout, View paramView, GridLayout.a parama, int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(255522);
      int i = this.YT;
      paramInt = parama.h(paramView, paramInt, y.b(paramGridLayout));
      AppMethodBeat.o(255522);
      return i - paramInt;
    }
    
    protected final void a(GridLayout paramGridLayout, View paramView, GridLayout.i parami, GridLayout.d paramd, int paramInt)
    {
      AppMethodBeat.i(255524);
      int j = this.YV;
      if ((parami.Zr == GridLayout.XV) && (parami.pO == 0.0F)) {}
      for (int i = 0;; i = 2)
      {
        this.YV = (i & j);
        i = parami.am(paramd.Yp).h(paramView, paramInt, y.b(paramGridLayout));
        Q(i, paramInt - i);
        AppMethodBeat.o(255524);
        return;
      }
    }
    
    protected int ai(boolean paramBoolean)
    {
      AppMethodBeat.i(255520);
      if ((!paramBoolean) && (GridLayout.ca(this.YV)))
      {
        AppMethodBeat.o(255520);
        return 100000;
      }
      int i = this.YT;
      int j = this.YU;
      AppMethodBeat.o(255520);
      return i + j;
    }
    
    protected void reset()
    {
      this.YT = -2147483648;
      this.YU = -2147483648;
      this.YV = 2;
    }
    
    public String toString()
    {
      AppMethodBeat.i(255526);
      String str = "Bounds{before=" + this.YT + ", after=" + this.YU + '}';
      AppMethodBeat.o(255526);
      return str;
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
      AppMethodBeat.i(255535);
      if (this == paramObject)
      {
        AppMethodBeat.o(255535);
        return true;
      }
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
      {
        AppMethodBeat.o(255535);
        return false;
      }
      paramObject = (f)paramObject;
      if (this.max != paramObject.max)
      {
        AppMethodBeat.o(255535);
        return false;
      }
      if (this.min != paramObject.min)
      {
        AppMethodBeat.o(255535);
        return false;
      }
      AppMethodBeat.o(255535);
      return true;
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
      AppMethodBeat.i(255542);
      String str = "[" + this.min + ", " + this.max + "]";
      AppMethodBeat.o(255542);
      return str;
    }
  }
  
  public static class i
  {
    static final i Zp;
    final GridLayout.f Yk;
    final boolean Zq;
    final GridLayout.a Zr;
    final float pO;
    
    static
    {
      AppMethodBeat.i(255595);
      Zp = GridLayout.iM();
      AppMethodBeat.o(255595);
    }
    
    i(boolean paramBoolean, int paramInt1, int paramInt2, GridLayout.a parama, float paramFloat)
    {
      this(paramBoolean, new GridLayout.f(paramInt1, paramInt1 + paramInt2), parama, paramFloat);
      AppMethodBeat.i(255590);
      AppMethodBeat.o(255590);
    }
    
    private i(boolean paramBoolean, GridLayout.f paramf, GridLayout.a parama, float paramFloat)
    {
      this.Zq = paramBoolean;
      this.Yk = paramf;
      this.Zr = parama;
      this.pO = paramFloat;
    }
    
    final i a(GridLayout.f paramf)
    {
      AppMethodBeat.i(255592);
      paramf = new i(this.Zq, paramf, this.Zr, this.pO);
      AppMethodBeat.o(255592);
      return paramf;
    }
    
    public final GridLayout.a am(boolean paramBoolean)
    {
      if (this.Zr != GridLayout.XV) {
        return this.Zr;
      }
      if (this.pO == 0.0F)
      {
        if (paramBoolean) {
          return GridLayout.Ya;
        }
        return GridLayout.Yf;
      }
      return GridLayout.Yg;
    }
    
    public boolean equals(Object paramObject)
    {
      AppMethodBeat.i(255593);
      if (this == paramObject)
      {
        AppMethodBeat.o(255593);
        return true;
      }
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
      {
        AppMethodBeat.o(255593);
        return false;
      }
      paramObject = (i)paramObject;
      if (!this.Zr.equals(paramObject.Zr))
      {
        AppMethodBeat.o(255593);
        return false;
      }
      if (!this.Yk.equals(paramObject.Yk))
      {
        AppMethodBeat.o(255593);
        return false;
      }
      AppMethodBeat.o(255593);
      return true;
    }
    
    public int hashCode()
    {
      AppMethodBeat.i(255594);
      int i = this.Yk.hashCode();
      int j = this.Zr.hashCode();
      AppMethodBeat.o(255594);
      return i * 31 + j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.gridlayout.widget.GridLayout
 * JD-Core Version:    0.7.0.1
 */