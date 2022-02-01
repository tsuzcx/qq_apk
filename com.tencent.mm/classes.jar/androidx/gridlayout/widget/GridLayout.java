package androidx.gridlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.LogPrinter;
import android.util.Pair;
import android.util.Printer;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.core.g.ab;
import androidx.core.g.z;
import androidx.gridlayout.a.a;
import androidx.gridlayout.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Landroidx.gridlayout.widget.GridLayout.b;>;
import java.util.Map;

public class GridLayout
  extends ViewGroup
{
  public static final a bFA;
  public static final a bFB;
  static final Printer bFb;
  static final Printer bFc;
  private static final int bFd;
  private static final int bFe;
  private static final int bFf;
  private static final int bFg;
  private static final int bFh;
  private static final int bFi;
  private static final int bFj;
  static final a bFq;
  private static final a bFr;
  private static final a bFs;
  public static final a bFt;
  public static final a bFu;
  public static final a bFv;
  public static final a bFw;
  public static final a bFx;
  public static final a bFy;
  public static final a bFz;
  final d bFk;
  final d bFl;
  boolean bFm;
  int bFn;
  int bFo;
  int bFp;
  int mOrientation;
  Printer mPrinter;
  
  static
  {
    AppMethodBeat.i(192773);
    bFb = new LogPrinter(3, GridLayout.class.getName());
    bFc = new Printer()
    {
      public final void println(String paramAnonymousString) {}
    };
    bFd = a.b.GridLayout_orientation;
    bFe = a.b.GridLayout_rowCount;
    bFf = a.b.GridLayout_columnCount;
    bFg = a.b.GridLayout_useDefaultMargins;
    bFh = a.b.GridLayout_alignmentMode;
    bFi = a.b.GridLayout_rowOrderPreserved;
    bFj = a.b.GridLayout_columnOrderPreserved;
    bFq = new a()
    {
      final int F(View paramAnonymousView, int paramAnonymousInt)
      {
        return -2147483648;
      }
      
      final String GR()
      {
        return "UNDEFINED";
      }
      
      public final int h(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        return -2147483648;
      }
    };
    bFr = new a()
    {
      final int F(View paramAnonymousView, int paramAnonymousInt)
      {
        return 0;
      }
      
      final String GR()
      {
        return "LEADING";
      }
      
      public final int h(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        return 0;
      }
    };
    bFs = new a()
    {
      final int F(View paramAnonymousView, int paramAnonymousInt)
      {
        return paramAnonymousInt;
      }
      
      final String GR()
      {
        return "TRAILING";
      }
      
      public final int h(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        return paramAnonymousInt1;
      }
    };
    bFt = bFr;
    bFu = bFs;
    bFv = bFr;
    bFw = bFs;
    bFx = a(bFv, bFw);
    bFy = a(bFw, bFv);
    bFz = new a()
    {
      final int F(View paramAnonymousView, int paramAnonymousInt)
      {
        return paramAnonymousInt >> 1;
      }
      
      final String GR()
      {
        return "CENTER";
      }
      
      public final int h(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        return paramAnonymousInt1 >> 1;
      }
    };
    bFA = new a()
    {
      final int F(View paramAnonymousView, int paramAnonymousInt)
      {
        return 0;
      }
      
      final String GR()
      {
        return "BASELINE";
      }
      
      public final GridLayout.e GS()
      {
        AppMethodBeat.i(192613);
        GridLayout.e local1 = new GridLayout.e()
        {
          private int size;
          
          protected final int a(GridLayout paramAnonymous2GridLayout, View paramAnonymous2View, GridLayout.a paramAnonymous2a, int paramAnonymous2Int, boolean paramAnonymous2Boolean)
          {
            AppMethodBeat.i(192531);
            paramAnonymous2Int = Math.max(0, super.a(paramAnonymous2GridLayout, paramAnonymous2View, paramAnonymous2a, paramAnonymous2Int, paramAnonymous2Boolean));
            AppMethodBeat.o(192531);
            return paramAnonymous2Int;
          }
          
          protected final void aL(int paramAnonymous2Int1, int paramAnonymous2Int2)
          {
            AppMethodBeat.i(192510);
            super.aL(paramAnonymous2Int1, paramAnonymous2Int2);
            this.size = Math.max(this.size, paramAnonymous2Int1 + paramAnonymous2Int2);
            AppMethodBeat.o(192510);
          }
          
          protected final int aR(boolean paramAnonymous2Boolean)
          {
            AppMethodBeat.i(192519);
            int i = Math.max(super.aR(paramAnonymous2Boolean), this.size);
            AppMethodBeat.o(192519);
            return i;
          }
          
          protected final void reset()
          {
            AppMethodBeat.i(192499);
            super.reset();
            this.size = -2147483648;
            AppMethodBeat.o(192499);
          }
        };
        AppMethodBeat.o(192613);
        return local1;
      }
      
      public final int h(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(192606);
        if (paramAnonymousView.getVisibility() == 8)
        {
          AppMethodBeat.o(192606);
          return 0;
        }
        paramAnonymousInt1 = paramAnonymousView.getBaseline();
        if (paramAnonymousInt1 == -1)
        {
          AppMethodBeat.o(192606);
          return -2147483648;
        }
        AppMethodBeat.o(192606);
        return paramAnonymousInt1;
      }
    };
    bFB = new a()
    {
      final int F(View paramAnonymousView, int paramAnonymousInt)
      {
        return 0;
      }
      
      final String GR()
      {
        return "FILL";
      }
      
      public final int aM(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        return paramAnonymousInt2;
      }
      
      public final int h(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        return -2147483648;
      }
    };
    AppMethodBeat.o(192773);
  }
  
  public GridLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public GridLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(192491);
    this.bFk = new d(true);
    this.bFl = new d(false);
    this.mOrientation = 0;
    this.bFm = false;
    this.bFn = 1;
    this.bFp = 0;
    this.mPrinter = bFb;
    this.bFo = paramContext.getResources().getDimensionPixelOffset(a.a.default_gap);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.b.GridLayout);
    try
    {
      setRowCount(paramContext.getInt(bFe, -2147483648));
      setColumnCount(paramContext.getInt(bFf, -2147483648));
      setOrientation(paramContext.getInt(bFd, 0));
      setUseDefaultMargins(paramContext.getBoolean(bFg, false));
      setAlignmentMode(paramContext.getInt(bFh, 1));
      setRowOrderPreserved(paramContext.getBoolean(bFi, true));
      setColumnOrderPreserved(paramContext.getBoolean(bFj, true));
      return;
    }
    finally
    {
      paramContext.recycle();
      AppMethodBeat.o(192491);
    }
  }
  
  private boolean GL()
  {
    AppMethodBeat.i(192563);
    if (z.U(this) == 1)
    {
      AppMethodBeat.o(192563);
      return true;
    }
    AppMethodBeat.o(192563);
    return false;
  }
  
  private void GM()
  {
    AppMethodBeat.i(192596);
    this.bFp = 0;
    if (this.bFk != null) {
      this.bFk.GM();
    }
    if (this.bFl != null) {
      this.bFl.GM();
    }
    GN();
    AppMethodBeat.o(192596);
  }
  
  private void GN()
  {
    AppMethodBeat.i(192602);
    if ((this.bFk != null) && (this.bFl != null))
    {
      this.bFk.GN();
      this.bFl.GN();
    }
    AppMethodBeat.o(192602);
  }
  
  private int GO()
  {
    AppMethodBeat.i(192649);
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
      AppMethodBeat.o(192649);
      return i;
    }
  }
  
  private void GP()
  {
    AppMethodBeat.i(192658);
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
    if (this.bFp == 0) {
      if (this.mOrientation == 0)
      {
        i2 = 1;
        if (i2 == 0) {
          break label266;
        }
        localObject = this.bFk;
        if (((d)localObject).bFL == -2147483648) {
          break label275;
        }
        i3 = ((d)localObject).bFL;
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
        localObject = localLayoutParams.bGF;
        localf = ((i)localObject).bFF;
        bool1 = ((i)localObject).bGJ;
        i7 = localf.size();
        if (bool1) {
          i = localf.min;
        }
        if (i2 == 0) {
          break label291;
        }
        localObject = localLayoutParams.bGG;
        localf = ((i)localObject).bFF;
        bool2 = ((i)localObject).bGJ;
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
              localObject = this.bFl;
              break label34;
              label275:
              i3 = 0;
              break label51;
              label281:
              localObject = localLayoutParams.bGG;
              break label103;
              label291:
              localObject = localLayoutParams.bGF;
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
      this.bFp = GO();
      AppMethodBeat.o(192658);
      return;
      if (this.bFp != GO())
      {
        this.mPrinter.println("The fields of some layout parameters were modified in between layout operations. Check the javadoc for GridLayout.LayoutParams#rowSpec.");
        GM();
        break;
      }
      AppMethodBeat.o(192658);
      return;
    }
  }
  
  public static i GQ()
  {
    AppMethodBeat.i(192735);
    i locali = a(-2147483648, 1, bFq, 0.0F);
    AppMethodBeat.o(192735);
    return locali;
  }
  
  private static a a(a parama1, final a parama2)
  {
    AppMethodBeat.i(192750);
    parama1 = new a()
    {
      final int F(View paramAnonymousView, int paramAnonymousInt)
      {
        int i = 1;
        AppMethodBeat.i(192611);
        if (z.U(paramAnonymousView) == 1) {
          if (i != 0) {
            break label45;
          }
        }
        label45:
        for (GridLayout.a locala = this.bFC;; locala = parama2)
        {
          paramAnonymousInt = locala.F(paramAnonymousView, paramAnonymousInt);
          AppMethodBeat.o(192611);
          return paramAnonymousInt;
          i = 0;
          break;
        }
      }
      
      final String GR()
      {
        AppMethodBeat.i(192638);
        String str = "SWITCHING[L:" + this.bFC.GR() + ", R:" + parama2.GR() + "]";
        AppMethodBeat.o(192638);
        return str;
      }
      
      public final int h(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        int i = 1;
        AppMethodBeat.i(192624);
        if (z.U(paramAnonymousView) == 1) {
          if (i != 0) {
            break label49;
          }
        }
        label49:
        for (GridLayout.a locala = this.bFC;; locala = parama2)
        {
          paramAnonymousInt1 = locala.h(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(192624);
          return paramAnonymousInt1;
          i = 0;
          break;
        }
      }
    };
    AppMethodBeat.o(192750);
    return parama1;
  }
  
  public static i a(int paramInt1, int paramInt2, a parama, float paramFloat)
  {
    AppMethodBeat.i(192723);
    if (paramInt1 != -2147483648) {}
    for (boolean bool = true;; bool = false)
    {
      parama = new i(bool, paramInt1, paramInt2, parama, paramFloat);
      AppMethodBeat.o(192723);
      return parama;
    }
  }
  
  private static void a(LayoutParams paramLayoutParams, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(192586);
    f localf = new f(paramInt1, paramInt1 + paramInt2);
    paramLayoutParams.bGF = paramLayoutParams.bGF.a(localf);
    localf = new f(paramInt3, paramInt3 + paramInt4);
    paramLayoutParams.bGG = paramLayoutParams.bGG.a(localf);
    AppMethodBeat.o(192586);
  }
  
  private void a(LayoutParams paramLayoutParams, boolean paramBoolean)
  {
    AppMethodBeat.i(192635);
    String str;
    label24:
    f localf;
    if (paramBoolean)
    {
      str = "column";
      if (!paramBoolean) {
        break label195;
      }
      paramLayoutParams = paramLayoutParams.bGG;
      localf = paramLayoutParams.bFF;
      if ((localf.min != -2147483648) && (localf.min < 0)) {
        aJ(str + " indices must be positive");
      }
      if (!paramBoolean) {
        break label203;
      }
    }
    label195:
    label203:
    for (paramLayoutParams = this.bFk;; paramLayoutParams = this.bFl)
    {
      int i = paramLayoutParams.bFL;
      if (i != -2147483648)
      {
        if (localf.max > i) {
          aJ(str + " indices (start + span) mustn't exceed the " + str + " count");
        }
        if (localf.size() > i) {
          aJ(str + " span mustn't exceed the " + str + " count");
        }
      }
      AppMethodBeat.o(192635);
      return;
      str = "row";
      break;
      paramLayoutParams = paramLayoutParams.bGF;
      break label24;
    }
  }
  
  static <T> T[] a(T[] paramArrayOfT1, T[] paramArrayOfT2)
  {
    AppMethodBeat.i(192536);
    Object[] arrayOfObject = (Object[])Array.newInstance(paramArrayOfT1.getClass().getComponentType(), paramArrayOfT1.length + paramArrayOfT2.length);
    System.arraycopy(paramArrayOfT1, 0, arrayOfObject, 0, paramArrayOfT1.length);
    System.arraycopy(paramArrayOfT2, 0, arrayOfObject, paramArrayOfT1.length, paramArrayOfT2.length);
    AppMethodBeat.o(192536);
    return arrayOfObject;
  }
  
  static void aJ(String paramString)
  {
    AppMethodBeat.i(192619);
    paramString = new IllegalArgumentException(paramString + ". ");
    AppMethodBeat.o(192619);
    throw paramString;
  }
  
  private static int aK(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(192693);
    paramInt1 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt1 + paramInt2), View.MeasureSpec.getMode(paramInt1));
    AppMethodBeat.o(192693);
    return paramInt1;
  }
  
  private int b(View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(192578);
    if (this.bFn == 1)
    {
      i = a(paramView, paramBoolean1, paramBoolean2);
      AppMethodBeat.o(192578);
      return i;
    }
    Object localObject;
    if (paramBoolean1)
    {
      localObject = this.bFk;
      if (!paramBoolean2) {
        break label150;
      }
      if (((d)localObject).bFT == null) {
        ((d)localObject).bFT = new int[((d)localObject).getCount() + 1];
      }
      if (!((d)localObject).bFU)
      {
        ((d)localObject).aU(true);
        ((d)localObject).bFU = true;
      }
      localObject = ((d)localObject).bFT;
      label95:
      paramView = (LayoutParams)paramView.getLayoutParams();
      if (!paramBoolean1) {
        break label202;
      }
      paramView = paramView.bGG;
      label112:
      if (!paramBoolean2) {
        break label210;
      }
    }
    label150:
    label202:
    label210:
    for (int i = paramView.bFF.min;; i = paramView.bFF.max)
    {
      i = localObject[i];
      AppMethodBeat.o(192578);
      return i;
      localObject = this.bFl;
      break;
      if (((d)localObject).bFV == null) {
        ((d)localObject).bFV = new int[((d)localObject).getCount() + 1];
      }
      if (!((d)localObject).bFW)
      {
        ((d)localObject).aU(false);
        ((d)localObject).bFW = true;
      }
      localObject = ((d)localObject).bFV;
      break label95;
      paramView = paramView.bGF;
      break label112;
    }
  }
  
  static LayoutParams bd(View paramView)
  {
    AppMethodBeat.i(369497);
    paramView = (LayoutParams)paramView.getLayoutParams();
    AppMethodBeat.o(369497);
    return paramView;
  }
  
  static boolean eV(int paramInt)
  {
    return (paramInt & 0x2) != 0;
  }
  
  static int f(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(192706);
    if (paramBoolean)
    {
      i = paramView.getMeasuredWidth();
      AppMethodBeat.o(192706);
      return i;
    }
    int i = paramView.getMeasuredHeight();
    AppMethodBeat.o(192706);
    return i;
  }
  
  private void f(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(192681);
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
          localObject = localLayoutParams.bGG;
          if (((i)localObject).aV(bool) != bFB) {
            break label206;
          }
          localf = ((i)localObject).bFF;
          if (!bool) {
            break label208;
          }
        }
        int k;
        label198:
        label206:
        label208:
        for (Object localObject = this.bFk;; localObject = this.bFl)
        {
          localObject = ((d)localObject).Hd();
          k = localObject[localf.max] - localObject[localf.min] - e(localView, bool);
          if (!bool) {
            break label217;
          }
          i(localView, paramInt1, paramInt2, k, localLayoutParams.height);
          break;
          bool = false;
          break label91;
          localObject = localLayoutParams.bGF;
          break label103;
          break;
        }
        label217:
        i(localView, paramInt1, paramInt2, localLayoutParams.width, k);
      }
    }
    AppMethodBeat.o(192681);
  }
  
  private void i(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(192668);
    paramView.measure(getChildMeasureSpec(paramInt1, e(paramView, true), paramInt3), getChildMeasureSpec(paramInt2, e(paramView, false), paramInt4));
    AppMethodBeat.o(192668);
  }
  
  static int j(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(192515);
    int j = -1;
    int i = 0;
    int k = paramArrayOfInt.length;
    while (i < k)
    {
      j = Math.max(j, paramArrayOfInt[i]);
      i += 1;
    }
    AppMethodBeat.o(192515);
    return j;
  }
  
  static a u(int paramInt, boolean paramBoolean)
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
        return bFq;
        i = 112;
        break label7;
      }
    }
    if (paramBoolean) {
      return bFx;
    }
    return bFt;
    if (paramBoolean) {
      return bFy;
    }
    return bFu;
    return bFB;
    return bFz;
    return bFv;
    return bFw;
  }
  
  final int a(View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(192916);
    Object localObject = (LayoutParams)paramView.getLayoutParams();
    int i;
    if (paramBoolean1) {
      if (paramBoolean2) {
        i = ((LayoutParams)localObject).leftMargin;
      }
    }
    while (i == -2147483648) {
      if (!this.bFm)
      {
        AppMethodBeat.o(192916);
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
          localObject = ((LayoutParams)localObject).bGG;
          if (!paramBoolean1) {
            break label189;
          }
          locald = this.bFk;
          localObject = ((i)localObject).bFF;
          bool = paramBoolean2;
          if (paramBoolean1)
          {
            bool = paramBoolean2;
            if (GL())
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
          AppMethodBeat.o(192916);
          return 0;
          localObject = ((LayoutParams)localObject).bGF;
          break;
          label189:
          locald = this.bFl;
          break label107;
          label198:
          bool = false;
          break label138;
          label204:
          locald.getCount();
        }
        label213:
        i = this.bFo / 2;
        AppMethodBeat.o(192916);
        return i;
      }
    }
    AppMethodBeat.o(192916);
    return i;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(192938);
    if (!(paramLayoutParams instanceof LayoutParams))
    {
      AppMethodBeat.o(192938);
      return false;
    }
    paramLayoutParams = (LayoutParams)paramLayoutParams;
    a(paramLayoutParams, true);
    a(paramLayoutParams, false);
    AppMethodBeat.o(192938);
    return true;
  }
  
  final int e(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(192928);
    int i = b(paramView, paramBoolean, true);
    int j = b(paramView, paramBoolean, false);
    AppMethodBeat.o(192928);
    return i + j;
  }
  
  public int getAlignmentMode()
  {
    return this.bFn;
  }
  
  public int getColumnCount()
  {
    AppMethodBeat.i(192828);
    int i = this.bFk.getCount();
    AppMethodBeat.o(192828);
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
    AppMethodBeat.i(192808);
    int i = this.bFl.getCount();
    AppMethodBeat.o(192808);
    return i;
  }
  
  public boolean getUseDefaultMargins()
  {
    return this.bFm;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(192969);
    GP();
    paramInt3 -= paramInt1;
    int i = getPaddingLeft();
    int j = getPaddingTop();
    int k = getPaddingRight();
    paramInt1 = getPaddingBottom();
    this.bFk.eX(paramInt3 - i - k);
    this.bFl.eX(paramInt4 - paramInt2 - j - paramInt1);
    int[] arrayOfInt1 = this.bFk.Hd();
    int[] arrayOfInt2 = this.bFl.Hd();
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
        Object localObject1 = ((LayoutParams)localObject2).bGG;
        localObject2 = ((LayoutParams)localObject2).bGF;
        Object localObject3 = ((i)localObject1).bFF;
        Object localObject4 = ((i)localObject2).bFF;
        paramInt2 = arrayOfInt1[localObject3.min];
        m = arrayOfInt2[localObject4.min];
        i1 = arrayOfInt1[localObject3.max];
        n = arrayOfInt2[localObject4.max];
        i5 = i1 - paramInt2;
        i7 = n - m;
        int i10 = f(localView, true);
        int i8 = f(localView, false);
        localObject1 = ((i)localObject1).aV(true);
        localObject2 = ((i)localObject2).aV(false);
        localObject3 = (e)this.bFk.GX().eZ(paramInt1);
        localObject4 = (e)this.bFl.GX().eZ(paramInt1);
        int i6 = ((a)localObject1).F(localView, i5 - ((e)localObject3).aR(true));
        n = ((a)localObject2).F(localView, i7 - ((e)localObject4).aR(true));
        int i3 = b(localView, true, true);
        i1 = b(localView, false, true);
        i4 = b(localView, true, false);
        i2 = b(localView, false, false);
        int i11 = i3 + i4;
        int i12 = i1 + i2;
        int i9 = ((e)localObject3).a(this, localView, (a)localObject1, i10 + i11, true);
        i2 = ((e)localObject4).a(this, localView, (a)localObject2, i8 + i12, false);
        i5 = ((a)localObject1).aM(i10, i5 - i11);
        i7 = ((a)localObject2).aM(i8, i7 - i12);
        paramInt2 = i9 + (paramInt2 + i6);
        if (GL()) {
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
    AppMethodBeat.o(192969);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(192947);
    GP();
    GN();
    int m = getPaddingLeft() + getPaddingRight();
    int k = getPaddingTop() + getPaddingBottom();
    int n = aK(paramInt1, -m);
    int i1 = aK(paramInt2, -k);
    f(n, i1, true);
    int j;
    int i;
    if (this.mOrientation == 0)
    {
      j = this.bFk.eW(n);
      f(n, i1, false);
      i = this.bFl.eW(i1);
    }
    for (;;)
    {
      j = Math.max(j + m, getSuggestedMinimumWidth());
      i = Math.max(i + k, getSuggestedMinimumHeight());
      setMeasuredDimension(View.resolveSizeAndState(j, paramInt1, 0), View.resolveSizeAndState(i, paramInt2, 0));
      AppMethodBeat.o(192947);
      return;
      i = this.bFl.eW(i1);
      f(n, i1, false);
      j = this.bFk.eW(n);
    }
  }
  
  public void requestLayout()
  {
    AppMethodBeat.i(192956);
    super.requestLayout();
    GM();
    AppMethodBeat.o(192956);
  }
  
  public void setAlignmentMode(int paramInt)
  {
    AppMethodBeat.i(192872);
    this.bFn = paramInt;
    requestLayout();
    AppMethodBeat.o(192872);
  }
  
  public void setColumnCount(int paramInt)
  {
    AppMethodBeat.i(192838);
    this.bFk.setCount(paramInt);
    GM();
    requestLayout();
    AppMethodBeat.o(192838);
  }
  
  public void setColumnOrderPreserved(boolean paramBoolean)
  {
    AppMethodBeat.i(192889);
    this.bFk.aS(paramBoolean);
    GM();
    requestLayout();
    AppMethodBeat.o(192889);
  }
  
  public void setOrientation(int paramInt)
  {
    AppMethodBeat.i(192794);
    if (this.mOrientation != paramInt)
    {
      this.mOrientation = paramInt;
      GM();
      requestLayout();
    }
    AppMethodBeat.o(192794);
  }
  
  public void setPrinter(Printer paramPrinter)
  {
    Printer localPrinter = paramPrinter;
    if (paramPrinter == null) {
      localPrinter = bFc;
    }
    this.mPrinter = localPrinter;
  }
  
  public void setRowCount(int paramInt)
  {
    AppMethodBeat.i(192818);
    this.bFl.setCount(paramInt);
    GM();
    requestLayout();
    AppMethodBeat.o(192818);
  }
  
  public void setRowOrderPreserved(boolean paramBoolean)
  {
    AppMethodBeat.i(192880);
    this.bFl.aS(paramBoolean);
    GM();
    requestLayout();
    AppMethodBeat.o(192880);
  }
  
  public void setUseDefaultMargins(boolean paramBoolean)
  {
    AppMethodBeat.i(192855);
    this.bFm = paramBoolean;
    requestLayout();
    AppMethodBeat.o(192855);
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    private static final int bGA;
    private static final int bGB;
    private static final int bGC;
    private static final int bGD;
    private static final int bGE;
    private static final GridLayout.f bGr;
    private static final int bGs;
    private static final int bGt;
    private static final int bGu;
    private static final int bGv;
    private static final int bGw;
    private static final int bGx;
    private static final int bGy;
    private static final int bGz;
    public GridLayout.i bGF;
    public GridLayout.i bGG;
    
    static
    {
      AppMethodBeat.i(192641);
      GridLayout.f localf = new GridLayout.f(-2147483648, -2147483647);
      bGr = localf;
      bGs = localf.size();
      bGt = a.b.GridLayout_Layout_android_layout_margin;
      bGu = a.b.GridLayout_Layout_android_layout_marginLeft;
      bGv = a.b.GridLayout_Layout_android_layout_marginTop;
      bGw = a.b.GridLayout_Layout_android_layout_marginRight;
      bGx = a.b.GridLayout_Layout_android_layout_marginBottom;
      bGy = a.b.GridLayout_Layout_layout_column;
      bGz = a.b.GridLayout_Layout_layout_columnSpan;
      bGA = a.b.GridLayout_Layout_layout_columnWeight;
      bGB = a.b.GridLayout_Layout_layout_row;
      bGC = a.b.GridLayout_Layout_layout_rowSpan;
      bGD = a.b.GridLayout_Layout_layout_rowWeight;
      bGE = a.b.GridLayout_Layout_layout_gravity;
      AppMethodBeat.o(192641);
    }
    
    public LayoutParams()
    {
      this(locali, locali, (byte)0);
      AppMethodBeat.i(192593);
      AppMethodBeat.o(192593);
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
      //   12: getstatic 122	androidx/gridlayout/widget/GridLayout$i:bGI	Landroidx/gridlayout/widget/GridLayout$i;
      //   15: putfield 132	androidx/gridlayout/widget/GridLayout$LayoutParams:bGF	Landroidx/gridlayout/widget/GridLayout$i;
      //   18: aload_0
      //   19: getstatic 122	androidx/gridlayout/widget/GridLayout$i:bGI	Landroidx/gridlayout/widget/GridLayout$i;
      //   22: putfield 134	androidx/gridlayout/widget/GridLayout$LayoutParams:bGG	Landroidx/gridlayout/widget/GridLayout$i;
      //   25: aload_1
      //   26: aload_2
      //   27: getstatic 138	androidx/gridlayout/a$b:GridLayout_Layout	[I
      //   30: invokevirtual 144	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;
      //   33: astore 7
      //   35: aload 7
      //   37: getstatic 58	androidx/gridlayout/widget/GridLayout$LayoutParams:bGt	I
      //   40: ldc 38
      //   42: invokevirtual 150	android/content/res/TypedArray:getDimensionPixelSize	(II)I
      //   45: istore 4
      //   47: aload_0
      //   48: aload 7
      //   50: getstatic 63	androidx/gridlayout/widget/GridLayout$LayoutParams:bGu	I
      //   53: iload 4
      //   55: invokevirtual 150	android/content/res/TypedArray:getDimensionPixelSize	(II)I
      //   58: putfield 153	androidx/gridlayout/widget/GridLayout$LayoutParams:leftMargin	I
      //   61: aload_0
      //   62: aload 7
      //   64: getstatic 68	androidx/gridlayout/widget/GridLayout$LayoutParams:bGv	I
      //   67: iload 4
      //   69: invokevirtual 150	android/content/res/TypedArray:getDimensionPixelSize	(II)I
      //   72: putfield 156	androidx/gridlayout/widget/GridLayout$LayoutParams:topMargin	I
      //   75: aload_0
      //   76: aload 7
      //   78: getstatic 73	androidx/gridlayout/widget/GridLayout$LayoutParams:bGw	I
      //   81: iload 4
      //   83: invokevirtual 150	android/content/res/TypedArray:getDimensionPixelSize	(II)I
      //   86: putfield 159	androidx/gridlayout/widget/GridLayout$LayoutParams:rightMargin	I
      //   89: aload_0
      //   90: aload 7
      //   92: getstatic 78	androidx/gridlayout/widget/GridLayout$LayoutParams:bGx	I
      //   95: iload 4
      //   97: invokevirtual 150	android/content/res/TypedArray:getDimensionPixelSize	(II)I
      //   100: putfield 162	androidx/gridlayout/widget/GridLayout$LayoutParams:bottomMargin	I
      //   103: aload 7
      //   105: invokevirtual 165	android/content/res/TypedArray:recycle	()V
      //   108: aload_1
      //   109: aload_2
      //   110: getstatic 138	androidx/gridlayout/a$b:GridLayout_Layout	[I
      //   113: invokevirtual 144	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;
      //   116: astore_1
      //   117: aload_1
      //   118: getstatic 113	androidx/gridlayout/widget/GridLayout$LayoutParams:bGE	I
      //   121: iconst_0
      //   122: invokevirtual 168	android/content/res/TypedArray:getInt	(II)I
      //   125: istore 4
      //   127: aload_1
      //   128: getstatic 83	androidx/gridlayout/widget/GridLayout$LayoutParams:bGy	I
      //   131: ldc 38
      //   133: invokevirtual 168	android/content/res/TypedArray:getInt	(II)I
      //   136: istore 5
      //   138: aload_1
      //   139: getstatic 88	androidx/gridlayout/widget/GridLayout$LayoutParams:bGz	I
      //   142: getstatic 51	androidx/gridlayout/widget/GridLayout$LayoutParams:bGs	I
      //   145: invokevirtual 168	android/content/res/TypedArray:getInt	(II)I
      //   148: istore 6
      //   150: aload_1
      //   151: getstatic 93	androidx/gridlayout/widget/GridLayout$LayoutParams:bGA	I
      //   154: fconst_0
      //   155: invokevirtual 172	android/content/res/TypedArray:getFloat	(IF)F
      //   158: fstore_3
      //   159: aload_0
      //   160: iload 5
      //   162: iload 6
      //   164: iload 4
      //   166: iconst_1
      //   167: invokestatic 176	androidx/gridlayout/widget/GridLayout:u	(IZ)Landroidx/gridlayout/widget/GridLayout$a;
      //   170: fload_3
      //   171: invokestatic 180	androidx/gridlayout/widget/GridLayout:a	(IILandroidx/gridlayout/widget/GridLayout$a;F)Landroidx/gridlayout/widget/GridLayout$i;
      //   174: putfield 134	androidx/gridlayout/widget/GridLayout$LayoutParams:bGG	Landroidx/gridlayout/widget/GridLayout$i;
      //   177: aload_1
      //   178: getstatic 98	androidx/gridlayout/widget/GridLayout$LayoutParams:bGB	I
      //   181: ldc 38
      //   183: invokevirtual 168	android/content/res/TypedArray:getInt	(II)I
      //   186: istore 5
      //   188: aload_1
      //   189: getstatic 103	androidx/gridlayout/widget/GridLayout$LayoutParams:bGC	I
      //   192: getstatic 51	androidx/gridlayout/widget/GridLayout$LayoutParams:bGs	I
      //   195: invokevirtual 168	android/content/res/TypedArray:getInt	(II)I
      //   198: istore 6
      //   200: aload_1
      //   201: getstatic 108	androidx/gridlayout/widget/GridLayout$LayoutParams:bGD	I
      //   204: fconst_0
      //   205: invokevirtual 172	android/content/res/TypedArray:getFloat	(IF)F
      //   208: fstore_3
      //   209: aload_0
      //   210: iload 5
      //   212: iload 6
      //   214: iload 4
      //   216: iconst_0
      //   217: invokestatic 176	androidx/gridlayout/widget/GridLayout:u	(IZ)Landroidx/gridlayout/widget/GridLayout$a;
      //   220: fload_3
      //   221: invokestatic 180	androidx/gridlayout/widget/GridLayout:a	(IILandroidx/gridlayout/widget/GridLayout$a;F)Landroidx/gridlayout/widget/GridLayout$i;
      //   224: putfield 132	androidx/gridlayout/widget/GridLayout$LayoutParams:bGF	Landroidx/gridlayout/widget/GridLayout$i;
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
      this.bGF = GridLayout.i.bGI;
      this.bGG = GridLayout.i.bGI;
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
      this.bGF = GridLayout.i.bGI;
      this.bGG = GridLayout.i.bGI;
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      this.bGF = GridLayout.i.bGI;
      this.bGG = GridLayout.i.bGI;
      this.bGF = paramLayoutParams.bGF;
      this.bGG = paramLayoutParams.bGG;
    }
    
    private LayoutParams(GridLayout.i parami1, GridLayout.i parami2)
    {
      super(-2);
      AppMethodBeat.i(192576);
      this.bGF = GridLayout.i.bGI;
      this.bGG = GridLayout.i.bGI;
      setMargins(-2147483648, -2147483648, -2147483648, -2147483648);
      this.bGF = parami1;
      this.bGG = parami2;
      AppMethodBeat.o(192576);
    }
    
    private LayoutParams(GridLayout.i parami1, GridLayout.i parami2, byte paramByte)
    {
      this(parami1, parami2);
    }
    
    public boolean equals(Object paramObject)
    {
      AppMethodBeat.i(192661);
      if (this == paramObject)
      {
        AppMethodBeat.o(192661);
        return true;
      }
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
      {
        AppMethodBeat.o(192661);
        return false;
      }
      paramObject = (LayoutParams)paramObject;
      if (!this.bGG.equals(paramObject.bGG))
      {
        AppMethodBeat.o(192661);
        return false;
      }
      if (!this.bGF.equals(paramObject.bGF))
      {
        AppMethodBeat.o(192661);
        return false;
      }
      AppMethodBeat.o(192661);
      return true;
    }
    
    public int hashCode()
    {
      AppMethodBeat.i(192670);
      int i = this.bGF.hashCode();
      int j = this.bGG.hashCode();
      AppMethodBeat.o(192670);
      return i * 31 + j;
    }
    
    protected void setBaseAttributes(TypedArray paramTypedArray, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(192651);
      this.width = paramTypedArray.getLayoutDimension(paramInt1, -2);
      this.height = paramTypedArray.getLayoutDimension(paramInt2, -2);
      AppMethodBeat.o(192651);
    }
  }
  
  public static abstract class a
  {
    abstract int F(View paramView, int paramInt);
    
    abstract String GR();
    
    GridLayout.e GS()
    {
      return new GridLayout.e();
    }
    
    int aM(int paramInt1, int paramInt2)
    {
      return paramInt1;
    }
    
    abstract int h(View paramView, int paramInt1, int paramInt2);
    
    public String toString()
    {
      return "Alignment:" + GR();
    }
  }
  
  static final class b
  {
    public final GridLayout.f bFF;
    public final GridLayout.g bFG;
    public boolean bFH = true;
    
    public b(GridLayout.f paramf, GridLayout.g paramg)
    {
      this.bFF = paramf;
      this.bFG = paramg;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(192504);
      StringBuilder localStringBuilder = new StringBuilder().append(this.bFF).append(" ");
      if (!this.bFH) {}
      for (String str = "+>";; str = "->")
      {
        str = str + " " + this.bFG;
        AppMethodBeat.o(192504);
        return str;
      }
    }
  }
  
  static final class c<K, V>
    extends ArrayList<Pair<K, V>>
  {
    private final Class<K> bFI;
    private final Class<V> bFJ;
    
    private c(Class<K> paramClass, Class<V> paramClass1)
    {
      this.bFI = paramClass;
      this.bFJ = paramClass1;
    }
    
    public static <K, V> c<K, V> a(Class<K> paramClass, Class<V> paramClass1)
    {
      AppMethodBeat.i(192506);
      paramClass = new c(paramClass, paramClass1);
      AppMethodBeat.o(192506);
      return paramClass;
    }
    
    public final GridLayout.h<K, V> GT()
    {
      AppMethodBeat.i(192533);
      int j = size();
      Object localObject = (Object[])Array.newInstance(this.bFI, j);
      Object[] arrayOfObject = (Object[])Array.newInstance(this.bFJ, j);
      int i = 0;
      while (i < j)
      {
        localObject[i] = ((Pair)get(i)).first;
        arrayOfObject[i] = ((Pair)get(i)).second;
        i += 1;
      }
      localObject = new GridLayout.h((Object[])localObject, arrayOfObject);
      AppMethodBeat.o(192533);
      return localObject;
    }
    
    public final void m(K paramK, V paramV)
    {
      AppMethodBeat.i(192517);
      add(Pair.create(paramK, paramV));
      AppMethodBeat.o(192517);
    }
  }
  
  final class d
  {
    public final boolean bFK;
    public int bFL;
    private int bFM;
    GridLayout.h<GridLayout.i, GridLayout.e> bFN;
    public boolean bFO;
    GridLayout.h<GridLayout.f, GridLayout.g> bFP;
    public boolean bFQ;
    GridLayout.h<GridLayout.f, GridLayout.g> bFR;
    public boolean bFS;
    public int[] bFT;
    public boolean bFU;
    public int[] bFV;
    public boolean bFW;
    public GridLayout.b[] bFX;
    public boolean bFY;
    public int[] bFZ;
    public boolean bGa;
    public boolean bGb;
    public boolean bGc;
    public int[] bGd;
    boolean bGe;
    private GridLayout.g bGf;
    private GridLayout.g bGg;
    
    static
    {
      AppMethodBeat.i(192747);
      if (!GridLayout.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(192747);
        return;
      }
    }
    
    d(boolean paramBoolean)
    {
      AppMethodBeat.i(192524);
      this.bFL = -2147483648;
      this.bFM = -2147483648;
      this.bFO = false;
      this.bFQ = false;
      this.bFS = false;
      this.bFU = false;
      this.bFW = false;
      this.bFY = false;
      this.bGa = false;
      this.bGc = false;
      this.bGe = true;
      this.bGf = new GridLayout.g(0);
      this.bGg = new GridLayout.g(-100000);
      this.bFK = paramBoolean;
      AppMethodBeat.o(192524);
    }
    
    private int GU()
    {
      AppMethodBeat.i(192537);
      int i;
      if (this.bFM == -2147483648)
      {
        int k = GridLayout.this.getChildCount();
        int j = 0;
        i = -1;
        if (j < k)
        {
          Object localObject = GridLayout.bd(GridLayout.this.getChildAt(j));
          if (this.bFK) {}
          for (localObject = ((GridLayout.LayoutParams)localObject).bGG;; localObject = ((GridLayout.LayoutParams)localObject).bGF)
          {
            localObject = ((GridLayout.i)localObject).bFF;
            i = Math.max(Math.max(Math.max(i, ((GridLayout.f)localObject).min), ((GridLayout.f)localObject).max), ((GridLayout.f)localObject).size());
            j += 1;
            break;
          }
        }
        if (i != -1) {
          break label137;
        }
        i = -2147483648;
      }
      label137:
      for (;;)
      {
        this.bFM = Math.max(0, i);
        i = this.bFM;
        AppMethodBeat.o(192537);
        return i;
      }
    }
    
    private GridLayout.h<GridLayout.i, GridLayout.e> GV()
    {
      AppMethodBeat.i(192547);
      GridLayout.c localc = GridLayout.c.a(GridLayout.i.class, GridLayout.e.class);
      int j = GridLayout.this.getChildCount();
      int i = 0;
      if (i < j)
      {
        localObject = GridLayout.bd(GridLayout.this.getChildAt(i));
        if (this.bFK) {}
        for (localObject = ((GridLayout.LayoutParams)localObject).bGG;; localObject = ((GridLayout.LayoutParams)localObject).bGF)
        {
          localc.m(localObject, ((GridLayout.i)localObject).aV(this.bFK).GS());
          i += 1;
          break;
        }
      }
      Object localObject = localc.GT();
      AppMethodBeat.o(192547);
      return localObject;
    }
    
    private void GW()
    {
      AppMethodBeat.i(192557);
      Object localObject = (GridLayout.e[])this.bFN.aqm;
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
        localObject = GridLayout.bd(localView);
        label88:
        GridLayout localGridLayout;
        boolean bool;
        int j;
        if (this.bFK)
        {
          localObject = ((GridLayout.LayoutParams)localObject).bGG;
          localGridLayout = GridLayout.this;
          bool = this.bFK;
          if (localView.getVisibility() != 8) {
            break label167;
          }
          j = 0;
          label112:
          if (((GridLayout.i)localObject).qL != 0.0F) {
            break label190;
          }
        }
        label167:
        label190:
        for (int k = 0;; k = Hc()[i])
        {
          ((GridLayout.e)this.bFN.eZ(i)).a(GridLayout.this, localView, (GridLayout.i)localObject, this, j + k);
          i += 1;
          break;
          localObject = ((GridLayout.LayoutParams)localObject).bGF;
          break label88;
          j = GridLayout.f(localView, bool);
          j = localGridLayout.e(localView, bool) + j;
          break label112;
        }
      }
      AppMethodBeat.o(192557);
    }
    
    private GridLayout.h<GridLayout.f, GridLayout.g> GY()
    {
      AppMethodBeat.i(192587);
      if (this.bFP == null) {
        this.bFP = aT(true);
      }
      if (!this.bFQ)
      {
        a(this.bFP, true);
        this.bFQ = true;
      }
      GridLayout.h localh = this.bFP;
      AppMethodBeat.o(192587);
      return localh;
    }
    
    private GridLayout.h<GridLayout.f, GridLayout.g> GZ()
    {
      AppMethodBeat.i(192594);
      if (this.bFR == null) {
        this.bFR = aT(false);
      }
      if (!this.bFS)
      {
        a(this.bFR, false);
        this.bFS = true;
      }
      GridLayout.h localh = this.bFR;
      AppMethodBeat.o(192594);
      return localh;
    }
    
    private void Ha()
    {
      AppMethodBeat.i(192633);
      GY();
      GZ();
      AppMethodBeat.o(192633);
    }
    
    private GridLayout.b[] Hb()
    {
      AppMethodBeat.i(192646);
      if (this.bFX == null)
      {
        localObject = new ArrayList();
        ArrayList localArrayList = new ArrayList();
        a((List)localObject, GY());
        a(localArrayList, GZ());
        if (this.bGe)
        {
          i = 0;
          while (i < getCount())
          {
            a((List)localObject, new GridLayout.f(i, i + 1), new GridLayout.g(0));
            i += 1;
          }
        }
        int i = getCount();
        a((List)localObject, new GridLayout.f(0, i), this.bGf, false);
        a(localArrayList, new GridLayout.f(i, 0), this.bGg, false);
        this.bFX = ((GridLayout.b[])GridLayout.a(Z((List)localObject), Z(localArrayList)));
      }
      if (!this.bFY)
      {
        Ha();
        this.bFY = true;
      }
      Object localObject = this.bFX;
      AppMethodBeat.o(192646);
      return localObject;
    }
    
    private int[] Hc()
    {
      AppMethodBeat.i(192692);
      if (this.bGd == null) {
        this.bGd = new int[GridLayout.this.getChildCount()];
      }
      int[] arrayOfInt = this.bGd;
      AppMethodBeat.o(192692);
      return arrayOfInt;
    }
    
    private GridLayout.b[] Z(List<GridLayout.b> paramList)
    {
      AppMethodBeat.i(192612);
      paramList = new Object()
      {
        GridLayout.b[] bGi;
        int bGj;
        GridLayout.b[][] bGk;
        int[] bGl;
        
        static
        {
          AppMethodBeat.i(192592);
          if (!GridLayout.class.desiredAssertionStatus()) {}
          for (boolean bool = true;; bool = false)
          {
            $assertionsDisabled = bool;
            AppMethodBeat.o(192592);
            return;
          }
        }
        
        final void eY(int paramAnonymousInt)
        {
          AppMethodBeat.i(192599);
          switch (this.bGl[paramAnonymousInt])
          {
          }
          do
          {
            AppMethodBeat.o(192599);
            return;
            this.bGl[paramAnonymousInt] = 1;
            localObject1 = this.bGk[paramAnonymousInt];
            int j = localObject1.length;
            int i = 0;
            while (i < j)
            {
              Object localObject2 = localObject1[i];
              eY(localObject2.bFF.max);
              GridLayout.b[] arrayOfb = this.bGi;
              int k = this.bGj;
              this.bGj = (k - 1);
              arrayOfb[k] = localObject2;
              i += 1;
            }
            this.bGl[paramAnonymousInt] = 2;
            AppMethodBeat.o(192599);
            return;
          } while ($assertionsDisabled);
          Object localObject1 = new AssertionError();
          AppMethodBeat.o(192599);
          throw ((Throwable)localObject1);
        }
      };
      int i = 0;
      int j = paramList.bGk.length;
      while (i < j)
      {
        paramList.eY(i);
        i += 1;
      }
      if ((!1.$assertionsDisabled) && (paramList.bGj != -1))
      {
        paramList = new AssertionError();
        AppMethodBeat.o(192612);
        throw paramList;
      }
      paramList = paramList.bGi;
      AppMethodBeat.o(192612);
      return paramList;
    }
    
    private void a(GridLayout.h<GridLayout.f, GridLayout.g> paramh, boolean paramBoolean)
    {
      int j = 0;
      AppMethodBeat.i(192581);
      Object localObject = (GridLayout.g[])paramh.aqm;
      int i = 0;
      while (i < localObject.length)
      {
        localObject[i].value = -2147483648;
        i += 1;
      }
      localObject = (GridLayout.e[])GX().aqm;
      i = j;
      if (i < localObject.length)
      {
        j = localObject[i].aR(paramBoolean);
        GridLayout.g localg = (GridLayout.g)paramh.eZ(i);
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
      AppMethodBeat.o(192581);
    }
    
    private static void a(List<GridLayout.b> paramList, GridLayout.f paramf, GridLayout.g paramg)
    {
      AppMethodBeat.i(192604);
      a(paramList, paramf, paramg, true);
      AppMethodBeat.o(192604);
    }
    
    private static void a(List<GridLayout.b> paramList, GridLayout.f paramf, GridLayout.g paramg, boolean paramBoolean)
    {
      AppMethodBeat.i(192600);
      if (paramf.size() == 0)
      {
        AppMethodBeat.o(192600);
        return;
      }
      if (paramBoolean)
      {
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext()) {
          if (((GridLayout.b)localIterator.next()).bFF.equals(paramf))
          {
            AppMethodBeat.o(192600);
            return;
          }
        }
      }
      paramList.add(new GridLayout.b(paramf, paramg));
      AppMethodBeat.o(192600);
    }
    
    private static void a(List<GridLayout.b> paramList, GridLayout.h<GridLayout.f, GridLayout.g> paramh)
    {
      AppMethodBeat.i(192622);
      int i = 0;
      while (i < ((GridLayout.f[])paramh.aqk).length)
      {
        a(paramList, ((GridLayout.f[])paramh.aqk)[i], ((GridLayout.g[])paramh.aqm)[i], false);
        i += 1;
      }
      AppMethodBeat.o(192622);
    }
    
    private static boolean a(int[] paramArrayOfInt, GridLayout.b paramb)
    {
      if (!paramb.bFH) {}
      int j;
      int i;
      do
      {
        return false;
        GridLayout.f localf = paramb.bFF;
        j = localf.min;
        i = localf.max;
        int k = paramb.bFG.value;
        j = paramArrayOfInt[j] + k;
      } while (j <= paramArrayOfInt[i]);
      paramArrayOfInt[i] = j;
      return true;
    }
    
    private boolean a(GridLayout.b[] paramArrayOfb, int[] paramArrayOfInt, boolean paramBoolean)
    {
      AppMethodBeat.i(192676);
      String str;
      int n;
      Object localObject1;
      int i;
      int j;
      if (this.bFK)
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
            break label267;
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
                if (!localb.bFH) {
                  ((List)localObject2).add(localb);
                }
                i += 1;
              }
              GridLayout.this.mPrinter.println(str + " constraints: " + aa(paramArrayOfInt) + " are inconsistent; permanently removing: " + aa((List)localObject2) + ". ");
            }
            AppMethodBeat.o(192676);
            return true;
          }
          j += 1;
        }
        label267:
        if (!paramBoolean)
        {
          AppMethodBeat.o(192676);
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
              if (localb.bFF.min >= localb.bFF.max) {
                localb.bFH = false;
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
      AppMethodBeat.o(192676);
      return true;
    }
    
    private void aN(int paramInt1, int paramInt2)
    {
      this.bGf.value = paramInt1;
      this.bGg.value = (-paramInt2);
      this.bGa = false;
    }
    
    private int aO(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(192737);
      aN(paramInt1, paramInt2);
      paramInt1 = Hd()[getCount()];
      AppMethodBeat.o(192737);
      return paramInt1;
    }
    
    private GridLayout.h<GridLayout.f, GridLayout.g> aT(boolean paramBoolean)
    {
      AppMethodBeat.i(192572);
      GridLayout.c localc = GridLayout.c.a(GridLayout.f.class, GridLayout.g.class);
      GridLayout.i[] arrayOfi = (GridLayout.i[])GX().aqk;
      int j = arrayOfi.length;
      int i = 0;
      if (i < j)
      {
        if (paramBoolean) {}
        for (localObject = arrayOfi[i].bFF;; localObject = new GridLayout.f(((GridLayout.f)localObject).max, ((GridLayout.f)localObject).min))
        {
          localc.m(localObject, new GridLayout.g());
          i += 1;
          break;
          localObject = arrayOfi[i].bFF;
        }
      }
      Object localObject = localc.GT();
      AppMethodBeat.o(192572);
      return localObject;
    }
    
    private String aa(List<GridLayout.b> paramList)
    {
      AppMethodBeat.i(192665);
      String str;
      label40:
      label68:
      int j;
      int k;
      int m;
      if (this.bFK)
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
        j = ((GridLayout.b)localObject).bFF.min;
        k = ((GridLayout.b)localObject).bFF.max;
        m = ((GridLayout.b)localObject).bFG.value;
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
      AppMethodBeat.o(192665);
      return paramList;
    }
    
    private void g(int paramInt, float paramFloat)
    {
      AppMethodBeat.i(192704);
      Arrays.fill(this.bGd, 0);
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
        localObject = GridLayout.bd((View)localObject);
        if (this.bFK)
        {
          localObject = ((GridLayout.LayoutParams)localObject).bGG;
          label79:
          float f = ((GridLayout.i)localObject).qL;
          if (f == 0.0F) {
            break label146;
          }
          j = Math.round(i * f / paramFloat);
          this.bGd[paramInt] = j;
          i -= j;
          paramFloat -= f;
        }
      }
      label146:
      for (;;)
      {
        paramInt += 1;
        break;
        localObject = ((GridLayout.LayoutParams)localObject).bGF;
        break label79;
        AppMethodBeat.o(192704);
        return;
      }
    }
    
    private boolean k(int[] paramArrayOfInt)
    {
      AppMethodBeat.i(192682);
      boolean bool = a(Hb(), paramArrayOfInt, true);
      AppMethodBeat.o(192682);
      return bool;
    }
    
    private void l(int[] paramArrayOfInt)
    {
      float f = 0.0F;
      boolean bool2 = true;
      int n = 0;
      AppMethodBeat.i(192718);
      int j;
      int i;
      Object localObject;
      label79:
      boolean bool1;
      if (!this.bGc)
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
        localObject = GridLayout.bd((View)localObject);
        if (this.bFK)
        {
          localObject = ((GridLayout.LayoutParams)localObject).bGG;
          if (((GridLayout.i)localObject).qL == 0.0F) {
            break label167;
          }
          bool1 = true;
          label92:
          this.bGb = bool1;
          this.bGc = true;
        }
      }
      else
      {
        if (this.bGb) {
          break label180;
        }
        k(paramArrayOfInt);
      }
      label116:
      int k;
      for (;;)
      {
        if (!this.bGe)
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
              localObject = ((GridLayout.LayoutParams)localObject).bGF;
              break label79;
              label167:
              i += 1;
              break;
              label174:
              bool1 = false;
              break label92;
              label180:
              Arrays.fill(Hc(), 0);
              k(paramArrayOfInt);
              j = this.bGf.value * GridLayout.this.getChildCount() + 1;
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
                localObject = GridLayout.bd((View)localObject);
                if (this.bFK)
                {
                  localObject = ((GridLayout.LayoutParams)localObject).bGG;
                  f = ((GridLayout.i)localObject).qL + f;
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
        localObject = ((GridLayout.LayoutParams)localObject).bGF;
        break label277;
        int m = -1;
        k = 0;
        i = j;
        bool1 = bool2;
        j = m;
        while (k < i)
        {
          m = (int)((k + i) / 2L);
          GN();
          g(m, f);
          bool1 = a(Hb(), paramArrayOfInt, false);
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
        GN();
        g(j, f);
        k(paramArrayOfInt);
        break;
        AppMethodBeat.o(192718);
        return;
      }
    }
    
    public final void GM()
    {
      AppMethodBeat.i(192842);
      this.bFM = -2147483648;
      this.bFN = null;
      this.bFP = null;
      this.bFR = null;
      this.bFT = null;
      this.bFV = null;
      this.bFX = null;
      this.bFZ = null;
      this.bGd = null;
      this.bGc = false;
      GN();
      AppMethodBeat.o(192842);
    }
    
    public final void GN()
    {
      this.bFO = false;
      this.bFQ = false;
      this.bFS = false;
      this.bFU = false;
      this.bFW = false;
      this.bFY = false;
      this.bGa = false;
    }
    
    public final GridLayout.h<GridLayout.i, GridLayout.e> GX()
    {
      AppMethodBeat.i(192784);
      if (this.bFN == null) {
        this.bFN = GV();
      }
      if (!this.bFO)
      {
        GW();
        this.bFO = true;
      }
      GridLayout.h localh = this.bFN;
      AppMethodBeat.o(192784);
      return localh;
    }
    
    public final int[] Hd()
    {
      AppMethodBeat.i(192814);
      if (this.bFZ == null) {
        this.bFZ = new int[getCount() + 1];
      }
      if (!this.bGa)
      {
        l(this.bFZ);
        this.bGa = true;
      }
      int[] arrayOfInt = this.bFZ;
      AppMethodBeat.o(192814);
      return arrayOfInt;
    }
    
    final GridLayout.b[][] a(GridLayout.b[] paramArrayOfb)
    {
      int j = 0;
      AppMethodBeat.i(192796);
      int k = getCount() + 1;
      GridLayout.b[][] arrayOfb; = new GridLayout.b[k][];
      int[] arrayOfInt = new int[k];
      int m = paramArrayOfb.length;
      int i = 0;
      while (i < m)
      {
        int n = paramArrayOfb[i].bFF.min;
        arrayOfInt[n] += 1;
        i += 1;
      }
      i = 0;
      while (i < k)
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
        j = localb.bFF.min;
        [Landroidx.gridlayout.widget.GridLayout.b localb; = arrayOfb;[j];
        m = arrayOfInt[j];
        arrayOfInt[j] = (m + 1);
        localb;[m] = localb;
        i += 1;
      }
      AppMethodBeat.o(192796);
      return arrayOfb;;
    }
    
    public final void aS(boolean paramBoolean)
    {
      AppMethodBeat.i(192776);
      this.bGe = paramBoolean;
      GM();
      AppMethodBeat.o(192776);
    }
    
    final void aU(boolean paramBoolean)
    {
      AppMethodBeat.i(192804);
      int[] arrayOfInt;
      int i;
      label27:
      View localView;
      Object localObject;
      if (paramBoolean)
      {
        arrayOfInt = this.bFT;
        int k = GridLayout.this.getChildCount();
        i = 0;
        if (i >= k) {
          break label151;
        }
        localView = GridLayout.this.getChildAt(i);
        if (localView.getVisibility() != 8)
        {
          localObject = GridLayout.bd(localView);
          if (!this.bFK) {
            break label132;
          }
          localObject = ((GridLayout.LayoutParams)localObject).bGG;
          label74:
          localObject = ((GridLayout.i)localObject).bFF;
          if (!paramBoolean) {
            break label142;
          }
        }
      }
      label132:
      label142:
      for (int j = ((GridLayout.f)localObject).min;; j = ((GridLayout.f)localObject).max)
      {
        arrayOfInt[j] = Math.max(arrayOfInt[j], GridLayout.this.a(localView, this.bFK, paramBoolean));
        i += 1;
        break label27;
        arrayOfInt = this.bFV;
        break;
        localObject = ((GridLayout.LayoutParams)localObject).bGF;
        break label74;
      }
      label151:
      AppMethodBeat.o(192804);
    }
    
    public final int eW(int paramInt)
    {
      AppMethodBeat.i(192824);
      int i = View.MeasureSpec.getMode(paramInt);
      paramInt = View.MeasureSpec.getSize(paramInt);
      switch (i)
      {
      default: 
        if (!$assertionsDisabled)
        {
          AssertionError localAssertionError = new AssertionError();
          AppMethodBeat.o(192824);
          throw localAssertionError;
        }
        break;
      case 0: 
        paramInt = aO(0, 100000);
        AppMethodBeat.o(192824);
        return paramInt;
      case 1073741824: 
        paramInt = aO(paramInt, paramInt);
        AppMethodBeat.o(192824);
        return paramInt;
      case -2147483648: 
        paramInt = aO(0, paramInt);
        AppMethodBeat.o(192824);
        return paramInt;
      }
      AppMethodBeat.o(192824);
      return 0;
    }
    
    public final void eX(int paramInt)
    {
      AppMethodBeat.i(192833);
      aN(paramInt, paramInt);
      Hd();
      AppMethodBeat.o(192833);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(192757);
      int i = Math.max(this.bFL, GU());
      AppMethodBeat.o(192757);
      return i;
    }
    
    public final void setCount(int paramInt)
    {
      AppMethodBeat.i(192766);
      StringBuilder localStringBuilder;
      if ((paramInt != -2147483648) && (paramInt < GU()))
      {
        localStringBuilder = new StringBuilder();
        if (!this.bFK) {
          break label68;
        }
      }
      label68:
      for (String str = "column";; str = "row")
      {
        GridLayout.aJ(str + "Count must be greater than or equal to the maximum of all grid indices (and spans) defined in the LayoutParams of each child");
        this.bFL = paramInt;
        AppMethodBeat.o(192766);
        return;
      }
    }
  }
  
  static class e
  {
    public int bGo;
    public int bGp;
    public int bGq;
    
    e()
    {
      AppMethodBeat.i(192495);
      reset();
      AppMethodBeat.o(192495);
    }
    
    protected int a(GridLayout paramGridLayout, View paramView, GridLayout.a parama, int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(192546);
      int i = this.bGo;
      paramInt = parama.h(paramView, paramInt, ab.c(paramGridLayout));
      AppMethodBeat.o(192546);
      return i - paramInt;
    }
    
    protected final void a(GridLayout paramGridLayout, View paramView, GridLayout.i parami, GridLayout.d paramd, int paramInt)
    {
      AppMethodBeat.i(192558);
      int j = this.bGq;
      if ((parami.bGK == GridLayout.bFq) && (parami.qL == 0.0F)) {}
      for (int i = 0;; i = 2)
      {
        this.bGq = (i & j);
        i = parami.aV(paramd.bFK).h(paramView, paramInt, ab.c(paramGridLayout));
        aL(i, paramInt - i);
        AppMethodBeat.o(192558);
        return;
      }
    }
    
    protected void aL(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(192518);
      this.bGo = Math.max(this.bGo, paramInt1);
      this.bGp = Math.max(this.bGp, paramInt2);
      AppMethodBeat.o(192518);
    }
    
    protected int aR(boolean paramBoolean)
    {
      AppMethodBeat.i(192534);
      if ((!paramBoolean) && (GridLayout.eV(this.bGq)))
      {
        AppMethodBeat.o(192534);
        return 100000;
      }
      int i = this.bGo;
      int j = this.bGp;
      AppMethodBeat.o(192534);
      return i + j;
    }
    
    protected void reset()
    {
      this.bGo = -2147483648;
      this.bGp = -2147483648;
      this.bGq = 2;
    }
    
    public String toString()
    {
      AppMethodBeat.i(192573);
      String str = "Bounds{before=" + this.bGo + ", after=" + this.bGp + '}';
      AppMethodBeat.o(192573);
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
      AppMethodBeat.i(192569);
      if (this == paramObject)
      {
        AppMethodBeat.o(192569);
        return true;
      }
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
      {
        AppMethodBeat.o(192569);
        return false;
      }
      paramObject = (f)paramObject;
      if (this.max != paramObject.max)
      {
        AppMethodBeat.o(192569);
        return false;
      }
      if (this.min != paramObject.min)
      {
        AppMethodBeat.o(192569);
        return false;
      }
      AppMethodBeat.o(192569);
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
      AppMethodBeat.i(192588);
      String str = "[" + this.min + ", " + this.max + "]";
      AppMethodBeat.o(192588);
      return str;
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
      AppMethodBeat.i(192560);
      String str = Integer.toString(this.value);
      AppMethodBeat.o(192560);
      return str;
    }
  }
  
  static final class h<K, V>
  {
    public final K[] aqk;
    public final V[] aqm;
    public final int[] bGH;
    
    h(K[] paramArrayOfK, V[] paramArrayOfV)
    {
      AppMethodBeat.i(192523);
      this.bGH = f(paramArrayOfK);
      this.aqk = a(paramArrayOfK, this.bGH);
      this.aqm = a(paramArrayOfV, this.bGH);
      AppMethodBeat.o(192523);
    }
    
    private static <K> K[] a(K[] paramArrayOfK, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(192545);
      int j = paramArrayOfK.length;
      Object[] arrayOfObject = (Object[])Array.newInstance(paramArrayOfK.getClass().getComponentType(), GridLayout.j(paramArrayOfInt) + 1);
      int i = 0;
      while (i < j)
      {
        arrayOfObject[paramArrayOfInt[i]] = paramArrayOfK[i];
        i += 1;
      }
      AppMethodBeat.o(192545);
      return arrayOfObject;
    }
    
    private static <K> int[] f(K[] paramArrayOfK)
    {
      AppMethodBeat.i(192535);
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
      AppMethodBeat.o(192535);
      return arrayOfInt;
    }
    
    public final V eZ(int paramInt)
    {
      return this.aqm[this.bGH[paramInt]];
    }
  }
  
  public static class i
  {
    static final i bGI;
    final GridLayout.f bFF;
    final boolean bGJ;
    final GridLayout.a bGK;
    final float qL;
    
    static
    {
      AppMethodBeat.i(192574);
      bGI = GridLayout.GQ();
      AppMethodBeat.o(192574);
    }
    
    i(boolean paramBoolean, int paramInt1, int paramInt2, GridLayout.a parama, float paramFloat)
    {
      this(paramBoolean, new GridLayout.f(paramInt1, paramInt1 + paramInt2), parama, paramFloat);
      AppMethodBeat.i(192561);
      AppMethodBeat.o(192561);
    }
    
    private i(boolean paramBoolean, GridLayout.f paramf, GridLayout.a parama, float paramFloat)
    {
      this.bGJ = paramBoolean;
      this.bFF = paramf;
      this.bGK = parama;
      this.qL = paramFloat;
    }
    
    final i a(GridLayout.f paramf)
    {
      AppMethodBeat.i(192591);
      paramf = new i(this.bGJ, paramf, this.bGK, this.qL);
      AppMethodBeat.o(192591);
      return paramf;
    }
    
    public final GridLayout.a aV(boolean paramBoolean)
    {
      if (this.bGK != GridLayout.bFq) {
        return this.bGK;
      }
      if (this.qL == 0.0F)
      {
        if (paramBoolean) {
          return GridLayout.bFv;
        }
        return GridLayout.bFA;
      }
      return GridLayout.bFB;
    }
    
    public boolean equals(Object paramObject)
    {
      AppMethodBeat.i(192598);
      if (this == paramObject)
      {
        AppMethodBeat.o(192598);
        return true;
      }
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
      {
        AppMethodBeat.o(192598);
        return false;
      }
      paramObject = (i)paramObject;
      if (!this.bGK.equals(paramObject.bGK))
      {
        AppMethodBeat.o(192598);
        return false;
      }
      if (!this.bFF.equals(paramObject.bFF))
      {
        AppMethodBeat.o(192598);
        return false;
      }
      AppMethodBeat.o(192598);
      return true;
    }
    
    public int hashCode()
    {
      AppMethodBeat.i(192603);
      int i = this.bFF.hashCode();
      int j = this.bGK.hashCode();
      AppMethodBeat.o(192603);
      return i * 31 + j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.gridlayout.widget.GridLayout
 * JD-Core Version:    0.7.0.1
 */