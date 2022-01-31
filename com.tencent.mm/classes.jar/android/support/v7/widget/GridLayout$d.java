package android.support.v7.widget;

import android.util.Printer;
import android.view.View;
import android.view.View.MeasureSpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.List<Landroid.support.v7.widget.GridLayout.b;>;

final class GridLayout$d
{
  public final boolean aeH;
  public int aeI = -2147483648;
  private int aeJ = -2147483648;
  GridLayout.h<GridLayout.i, GridLayout.e> aeK;
  public boolean aeL = false;
  GridLayout.h<GridLayout.f, GridLayout.g> aeM;
  public boolean aeN = false;
  GridLayout.h<GridLayout.f, GridLayout.g> aeO;
  public boolean aeP = false;
  public int[] aeQ;
  public boolean aeR = false;
  public int[] aeS;
  public boolean aeT = false;
  public GridLayout.b[] aeU;
  public boolean aeV = false;
  public int[] aeW;
  public boolean aeX = false;
  public boolean aeY;
  public boolean aeZ = false;
  public int[] afa;
  boolean afb = true;
  private GridLayout.g afc = new GridLayout.g(0);
  private GridLayout.g afd = new GridLayout.g(-100000);
  
  static
  {
    if (!GridLayout.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  GridLayout$d(GridLayout paramGridLayout, boolean paramBoolean)
  {
    this.aeH = paramBoolean;
  }
  
  private void T(int paramInt1, int paramInt2)
  {
    this.afc.value = paramInt1;
    this.afd.value = (-paramInt2);
    this.aeX = false;
  }
  
  private int U(int paramInt1, int paramInt2)
  {
    T(paramInt1, paramInt2);
    return ib()[getCount()];
  }
  
  private void a(GridLayout.h<GridLayout.f, GridLayout.g> paramh, boolean paramBoolean)
  {
    int j = 0;
    Object localObject = (GridLayout.g[])paramh.afB;
    int i = 0;
    while (i < localObject.length)
    {
      localObject[i].value = -2147483648;
      i += 1;
    }
    localObject = (GridLayout.e[])hV().afB;
    i = j;
    if (i < localObject.length)
    {
      j = localObject[i].ad(paramBoolean);
      GridLayout.g localg = (GridLayout.g)paramh.bC(i);
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
        if (((GridLayout.b)localIterator.next()).aeC.equals(paramf)) {
          return;
        }
      }
    }
    paramList.add(new GridLayout.b(paramf, paramg));
  }
  
  private static void a(List<GridLayout.b> paramList, GridLayout.h<GridLayout.f, GridLayout.g> paramh)
  {
    int i = 0;
    while (i < ((GridLayout.f[])paramh.afA).length)
    {
      a(paramList, ((GridLayout.f[])paramh.afA)[i], ((GridLayout.g[])paramh.afB)[i], false);
      i += 1;
    }
  }
  
  private static boolean a(int[] paramArrayOfInt, GridLayout.b paramb)
  {
    if (!paramb.aeE) {}
    int j;
    int i;
    do
    {
      return false;
      GridLayout.f localf = paramb.aeC;
      j = localf.min;
      i = localf.max;
      int k = paramb.aeD.value;
      j = paramArrayOfInt[j] + k;
    } while (j <= paramArrayOfInt[i]);
    paramArrayOfInt[i] = j;
    return true;
  }
  
  private boolean a(GridLayout.b[] paramArrayOfb, int[] paramArrayOfInt, boolean paramBoolean)
  {
    boolean bool3 = false;
    int n = 0;
    if (this.aeH) {}
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
          if (!localb.aeE) {
            ((List)localObject2).add(localb);
          }
          i += 1;
        }
        this.afe.mPrinter.println(str + " constraints: " + q(paramArrayOfInt) + " are inconsistent; permanently removing: " + q((List)localObject2) + ". ");
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
          if (localb.aeC.min >= localb.aeC.max) {
            localb.aeE = false;
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
  
  private GridLayout.h<GridLayout.f, GridLayout.g> af(boolean paramBoolean)
  {
    GridLayout.c localc = GridLayout.c.a(GridLayout.f.class, GridLayout.g.class);
    GridLayout.i[] arrayOfi = (GridLayout.i[])hV().afA;
    int j = arrayOfi.length;
    int i = 0;
    if (i < j)
    {
      if (paramBoolean) {}
      for (GridLayout.f localf = arrayOfi[i].aeC;; localf = new GridLayout.f(localf.max, localf.min))
      {
        localc.d(localf, new GridLayout.g());
        i += 1;
        break;
        localf = arrayOfi[i].aeC;
      }
    }
    return localc.hR();
  }
  
  private void f(int paramInt, float paramFloat)
  {
    Arrays.fill(this.afa, 0);
    int k = this.afe.getChildCount();
    int j = 0;
    int i = paramInt;
    paramInt = j;
    Object localObject;
    if (paramInt < k)
    {
      localObject = this.afe.getChildAt(paramInt);
      if (((View)localObject).getVisibility() == 8) {
        break label134;
      }
      localObject = GridLayout.be((View)localObject);
      if (this.aeH)
      {
        localObject = ((GridLayout.LayoutParams)localObject).afy;
        label73:
        float f = ((GridLayout.i)localObject).weight;
        if (f == 0.0F) {
          break label134;
        }
        j = Math.round(i * f / paramFloat);
        this.afa[paramInt] = j;
        i -= j;
        paramFloat -= f;
      }
    }
    label134:
    for (;;)
    {
      paramInt += 1;
      break;
      localObject = ((GridLayout.LayoutParams)localObject).afx;
      break label73;
      return;
    }
  }
  
  private int hS()
  {
    int i;
    if (this.aeJ == -2147483648)
    {
      int k = this.afe.getChildCount();
      int j = 0;
      i = -1;
      if (j < k)
      {
        Object localObject = GridLayout.be(this.afe.getChildAt(j));
        if (this.aeH) {}
        for (localObject = ((GridLayout.LayoutParams)localObject).afy;; localObject = ((GridLayout.LayoutParams)localObject).afx)
        {
          localObject = ((GridLayout.i)localObject).aeC;
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
      this.aeJ = Math.max(0, i);
      return this.aeJ;
    }
  }
  
  private GridLayout.h<GridLayout.i, GridLayout.e> hT()
  {
    GridLayout.c localc = GridLayout.c.a(GridLayout.i.class, GridLayout.e.class);
    int j = this.afe.getChildCount();
    int i = 0;
    if (i < j)
    {
      Object localObject = GridLayout.be(this.afe.getChildAt(i));
      if (this.aeH) {}
      for (localObject = ((GridLayout.LayoutParams)localObject).afy;; localObject = ((GridLayout.LayoutParams)localObject).afx)
      {
        localc.d(localObject, ((GridLayout.i)localObject).ah(this.aeH).hQ());
        i += 1;
        break;
      }
    }
    return localc.hR();
  }
  
  private void hU()
  {
    Object localObject = (GridLayout.e[])this.aeK.afB;
    int i = 0;
    while (i < localObject.length)
    {
      localObject[i].reset();
      i += 1;
    }
    int m = this.afe.getChildCount();
    i = 0;
    if (i < m)
    {
      View localView = this.afe.getChildAt(i);
      localObject = GridLayout.be(localView);
      label83:
      GridLayout localGridLayout;
      boolean bool;
      int j;
      if (this.aeH)
      {
        localObject = ((GridLayout.LayoutParams)localObject).afy;
        localGridLayout = this.afe;
        bool = this.aeH;
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
      for (int k = 0;; k = ia()[i])
      {
        ((GridLayout.e)this.aeK.bC(i)).a(this.afe, localView, (GridLayout.i)localObject, this, j + k);
        i += 1;
        break;
        localObject = ((GridLayout.LayoutParams)localObject).afx;
        break label83;
        j = GridLayout.h(localView, bool);
        j = localGridLayout.g(localView, bool) + j;
        break label107;
      }
    }
  }
  
  private GridLayout.h<GridLayout.f, GridLayout.g> hW()
  {
    if (this.aeM == null) {
      this.aeM = af(true);
    }
    if (!this.aeN)
    {
      a(this.aeM, true);
      this.aeN = true;
    }
    return this.aeM;
  }
  
  private GridLayout.h<GridLayout.f, GridLayout.g> hX()
  {
    if (this.aeO == null) {
      this.aeO = af(false);
    }
    if (!this.aeP)
    {
      a(this.aeO, false);
      this.aeP = true;
    }
    return this.aeO;
  }
  
  private void hY()
  {
    hW();
    hX();
  }
  
  private GridLayout.b[] hZ()
  {
    if (this.aeU == null)
    {
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      a(localArrayList1, hW());
      a(localArrayList2, hX());
      if (this.afb)
      {
        i = 0;
        while (i < getCount())
        {
          a(localArrayList1, new GridLayout.f(i, i + 1), new GridLayout.g(0));
          i += 1;
        }
      }
      int i = getCount();
      a(localArrayList1, new GridLayout.f(0, i), this.afc, false);
      a(localArrayList2, new GridLayout.f(i, 0), this.afd, false);
      this.aeU = ((GridLayout.b[])GridLayout.a(p(localArrayList1), p(localArrayList2)));
    }
    if (!this.aeV)
    {
      hY();
      this.aeV = true;
    }
    return this.aeU;
  }
  
  private int[] ia()
  {
    if (this.afa == null) {
      this.afa = new int[this.afe.getChildCount()];
    }
    return this.afa;
  }
  
  private boolean k(int[] paramArrayOfInt)
  {
    return a(hZ(), paramArrayOfInt, true);
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
    if (!this.aeZ)
    {
      j = this.afe.getChildCount();
      i = 0;
      if (i >= j) {
        break label168;
      }
      localObject = this.afe.getChildAt(i);
      if (((View)localObject).getVisibility() == 8) {
        break label161;
      }
      localObject = GridLayout.be((View)localObject);
      if (this.aeH)
      {
        localObject = ((GridLayout.LayoutParams)localObject).afy;
        if (((GridLayout.i)localObject).weight == 0.0F) {
          break label161;
        }
        bool1 = true;
        label86:
        this.aeY = bool1;
        this.aeZ = true;
      }
    }
    else
    {
      if (this.aeY) {
        break label174;
      }
      k(paramArrayOfInt);
    }
    label110:
    int k;
    for (;;)
    {
      if (!this.afb)
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
            localObject = ((GridLayout.LayoutParams)localObject).afx;
            break label73;
            label161:
            i += 1;
            break;
            label168:
            bool1 = false;
            break label86;
            label174:
            Arrays.fill(ia(), 0);
            k(paramArrayOfInt);
            j = this.afc.value * this.afe.getChildCount() + 1;
            if (j < 2) {
              break label110;
            }
            k = this.afe.getChildCount();
            i = 0;
            label224:
            if (i < k)
            {
              localObject = this.afe.getChildAt(i);
              if (((View)localObject).getVisibility() == 8) {
                break label410;
              }
              localObject = GridLayout.be((View)localObject);
              if (this.aeH)
              {
                localObject = ((GridLayout.LayoutParams)localObject).afy;
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
      localObject = ((GridLayout.LayoutParams)localObject).afx;
      break label271;
      int m = -1;
      k = 0;
      i = j;
      bool1 = bool2;
      j = m;
      while (k < i)
      {
        m = (int)((k + i) / 2L);
        hL();
        f(m, f);
        bool1 = a(hZ(), paramArrayOfInt, false);
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
      hL();
      f(j, f);
      k(paramArrayOfInt);
      break;
      return;
    }
  }
  
  private GridLayout.b[] p(List<GridLayout.b> paramList)
  {
    paramList = new GridLayout.d.1(this, (GridLayout.b[])paramList.toArray(new GridLayout.b[paramList.size()]));
    int i = 0;
    int j = paramList.afh.length;
    while (i < j)
    {
      paramList.bB(i);
      i += 1;
    }
    if ((!GridLayout.d.1.$assertionsDisabled) && (paramList.afg != -1)) {
      throw new AssertionError();
    }
    return paramList.aff;
  }
  
  private String q(List<GridLayout.b> paramList)
  {
    String str;
    label34:
    label62:
    int j;
    int k;
    int m;
    if (this.aeH)
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
      j = ((GridLayout.b)localObject).aeC.min;
      k = ((GridLayout.b)localObject).aeC.max;
      m = ((GridLayout.b)localObject).aeD.value;
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
      m = paramArrayOfb[i].aeC.min;
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
      j = localb.aeC.min;
      [Landroid.support.v7.widget.GridLayout.b localb; = arrayOfb;[j];
      m = arrayOfInt[j];
      arrayOfInt[j] = (m + 1);
      localb;[m] = localb;
      i += 1;
    }
    return arrayOfb;;
  }
  
  public final void ae(boolean paramBoolean)
  {
    this.afb = paramBoolean;
    hK();
  }
  
  final void ag(boolean paramBoolean)
  {
    int[] arrayOfInt;
    int i;
    label21:
    View localView;
    Object localObject;
    if (paramBoolean)
    {
      arrayOfInt = this.aeQ;
      int k = this.afe.getChildCount();
      i = 0;
      if (i >= k) {
        return;
      }
      localView = this.afe.getChildAt(i);
      if (localView.getVisibility() != 8)
      {
        localObject = GridLayout.be(localView);
        if (!this.aeH) {
          break label126;
        }
        localObject = ((GridLayout.LayoutParams)localObject).afy;
        label68:
        localObject = ((GridLayout.i)localObject).aeC;
        if (!paramBoolean) {
          break label136;
        }
      }
    }
    label136:
    for (int j = ((GridLayout.f)localObject).min;; j = ((GridLayout.f)localObject).max)
    {
      arrayOfInt[j] = Math.max(arrayOfInt[j], this.afe.a(localView, this.aeH, paramBoolean));
      i += 1;
      break label21;
      arrayOfInt = this.aeS;
      break;
      label126:
      localObject = ((GridLayout.LayoutParams)localObject).afx;
      break label68;
    }
  }
  
  public final void bA(int paramInt)
  {
    T(paramInt, paramInt);
    ib();
  }
  
  public final int bz(int paramInt)
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
      paramInt = U(0, 100000);
      return paramInt;
    case 1073741824: 
      return U(paramInt, paramInt);
    }
    return U(0, paramInt);
  }
  
  public final int getCount()
  {
    return Math.max(this.aeI, hS());
  }
  
  public final void hK()
  {
    this.aeJ = -2147483648;
    this.aeK = null;
    this.aeM = null;
    this.aeO = null;
    this.aeQ = null;
    this.aeS = null;
    this.aeU = null;
    this.aeW = null;
    this.afa = null;
    this.aeZ = false;
    hL();
  }
  
  public final void hL()
  {
    this.aeL = false;
    this.aeN = false;
    this.aeP = false;
    this.aeR = false;
    this.aeT = false;
    this.aeV = false;
    this.aeX = false;
  }
  
  public final GridLayout.h<GridLayout.i, GridLayout.e> hV()
  {
    if (this.aeK == null) {
      this.aeK = hT();
    }
    if (!this.aeL)
    {
      hU();
      this.aeL = true;
    }
    return this.aeK;
  }
  
  public final int[] ib()
  {
    if (this.aeW == null) {
      this.aeW = new int[getCount() + 1];
    }
    if (!this.aeX)
    {
      l(this.aeW);
      this.aeX = true;
    }
    return this.aeW;
  }
  
  public final void setCount(int paramInt)
  {
    StringBuilder localStringBuilder;
    if ((paramInt != -2147483648) && (paramInt < hS()))
    {
      localStringBuilder = new StringBuilder();
      if (!this.aeH) {
        break label56;
      }
    }
    label56:
    for (String str = "column";; str = "row")
    {
      GridLayout.R(str + "Count must be greater than or equal to the maximum of all grid indices (and spans) defined in the LayoutParams of each child");
      this.aeI = paramInt;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.v7.widget.GridLayout.d
 * JD-Core Version:    0.7.0.1
 */