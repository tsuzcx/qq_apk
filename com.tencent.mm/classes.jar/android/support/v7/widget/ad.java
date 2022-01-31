package android.support.v7.widget;

import android.support.v4.os.f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

final class ad
  implements Runnable
{
  static final ThreadLocal<ad> adc = new ThreadLocal();
  static Comparator<ad.b> adi = new ad.1();
  ArrayList<RecyclerView> ade = new ArrayList();
  long adf;
  long adg;
  private ArrayList<ad.b> adh = new ArrayList();
  
  /* Error */
  private static RecyclerView.v a(RecyclerView paramRecyclerView, int paramInt, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 55	android/support/v7/widget/RecyclerView:afB	Landroid/support/v7/widget/u;
    //   4: invokevirtual 61	android/support/v7/widget/u:gx	()I
    //   7: istore 5
    //   9: iconst_0
    //   10: istore 4
    //   12: iload 4
    //   14: iload 5
    //   16: if_icmpge +53 -> 69
    //   19: aload_0
    //   20: getfield 55	android/support/v7/widget/RecyclerView:afB	Landroid/support/v7/widget/u;
    //   23: iload 4
    //   25: invokevirtual 65	android/support/v7/widget/u:bt	(I)Landroid/view/View;
    //   28: invokestatic 69	android/support/v7/widget/RecyclerView:bf	(Landroid/view/View;)Landroid/support/v7/widget/RecyclerView$v;
    //   31: astore 6
    //   33: aload 6
    //   35: getfield 75	android/support/v7/widget/RecyclerView$v:mPosition	I
    //   38: iload_1
    //   39: if_icmpne +21 -> 60
    //   42: aload 6
    //   44: invokevirtual 79	android/support/v7/widget/RecyclerView$v:ij	()Z
    //   47: ifne +13 -> 60
    //   50: iconst_1
    //   51: istore 4
    //   53: iload 4
    //   55: ifeq +20 -> 75
    //   58: aconst_null
    //   59: areturn
    //   60: iload 4
    //   62: iconst_1
    //   63: iadd
    //   64: istore 4
    //   66: goto -54 -> 12
    //   69: iconst_0
    //   70: istore 4
    //   72: goto -19 -> 53
    //   75: aload_0
    //   76: getfield 83	android/support/v7/widget/RecyclerView:afy	Landroid/support/v7/widget/RecyclerView$o;
    //   79: astore 6
    //   81: aload_0
    //   82: invokevirtual 86	android/support/v7/widget/RecyclerView:hy	()V
    //   85: aload 6
    //   87: iload_1
    //   88: lload_2
    //   89: invokevirtual 92	android/support/v7/widget/RecyclerView$o:d	(IJ)Landroid/support/v7/widget/RecyclerView$v;
    //   92: astore 7
    //   94: aload 7
    //   96: ifnull +29 -> 125
    //   99: aload 7
    //   101: invokevirtual 95	android/support/v7/widget/RecyclerView$v:isBound	()Z
    //   104: ifeq +29 -> 133
    //   107: aload 7
    //   109: invokevirtual 79	android/support/v7/widget/RecyclerView$v:ij	()Z
    //   112: ifne +21 -> 133
    //   115: aload 6
    //   117: aload 7
    //   119: getfield 99	android/support/v7/widget/RecyclerView$v:aie	Landroid/view/View;
    //   122: invokevirtual 103	android/support/v7/widget/RecyclerView$o:bv	(Landroid/view/View;)V
    //   125: aload_0
    //   126: iconst_0
    //   127: invokevirtual 107	android/support/v7/widget/RecyclerView:ad	(Z)V
    //   130: aload 7
    //   132: areturn
    //   133: aload 6
    //   135: aload 7
    //   137: iconst_0
    //   138: invokevirtual 110	android/support/v7/widget/RecyclerView$o:a	(Landroid/support/v7/widget/RecyclerView$v;Z)V
    //   141: goto -16 -> 125
    //   144: astore 6
    //   146: aload_0
    //   147: iconst_0
    //   148: invokevirtual 107	android/support/v7/widget/RecyclerView:ad	(Z)V
    //   151: aload 6
    //   153: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	paramRecyclerView	RecyclerView
    //   0	154	1	paramInt	int
    //   0	154	2	paramLong	long
    //   10	61	4	i	int
    //   7	10	5	j	int
    //   31	103	6	localObject1	Object
    //   144	8	6	localObject2	Object
    //   92	44	7	localv	RecyclerView.v
    // Exception table:
    //   from	to	target	type
    //   81	94	144	finally
    //   99	125	144	finally
    //   133	141	144	finally
  }
  
  final void b(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if ((paramRecyclerView.isAttachedToWindow()) && (this.adf == 0L))
    {
      this.adf = paramRecyclerView.getNanoTime();
      paramRecyclerView.post(this);
    }
    paramRecyclerView = paramRecyclerView.agt;
    paramRecyclerView.adj = paramInt1;
    paramRecyclerView.adk = paramInt2;
  }
  
  public final void run()
  {
    for (;;)
    {
      int j;
      try
      {
        f.beginSection("RV Prefetch");
        bool = this.ade.isEmpty();
        if (bool) {
          return;
        }
        j = this.ade.size();
        long l1 = 0L;
        int i = 0;
        Object localObject1;
        if (i < j)
        {
          localObject1 = (RecyclerView)this.ade.get(i);
          if (((RecyclerView)localObject1).getWindowVisibility() != 0) {
            break label719;
          }
          l1 = Math.max(((RecyclerView)localObject1).getDrawingTime(), l1);
          i += 1;
          continue;
        }
        if (l1 == 0L) {
          return;
        }
        long l2 = TimeUnit.MILLISECONDS.toNanos(l1) + this.adg;
        int m = this.ade.size();
        i = 0;
        j = 0;
        if (j < m)
        {
          localObject1 = (RecyclerView)this.ade.get(j);
          if (((RecyclerView)localObject1).getWindowVisibility() != 0) {
            break label716;
          }
          ((RecyclerView)localObject1).agt.a((RecyclerView)localObject1, false);
          i = ((RecyclerView)localObject1).agt.mCount + i;
          break label722;
        }
        this.adh.ensureCapacity(i);
        i = 0;
        j = 0;
        Object localObject4;
        a locala;
        if (j < m)
        {
          localObject4 = (RecyclerView)this.ade.get(j);
          if (((RecyclerView)localObject4).getWindowVisibility() != 0) {
            break label713;
          }
          locala = ((RecyclerView)localObject4).agt;
          int n = Math.abs(locala.adj) + Math.abs(locala.adk);
          int k = 0;
          if (k >= locala.mCount * 2) {
            break label735;
          }
          if (i >= this.adh.size())
          {
            localObject1 = new ad.b();
            this.adh.add(localObject1);
            int i1 = locala.adl[(k + 1)];
            if (i1 > n) {
              break label729;
            }
            bool = true;
            ((ad.b)localObject1).adm = bool;
            ((ad.b)localObject1).adn = n;
            ((ad.b)localObject1).ado = i1;
            ((ad.b)localObject1).adp = ((RecyclerView)localObject4);
            ((ad.b)localObject1).position = locala.adl[k];
            i += 1;
            k += 2;
            continue;
          }
          localObject1 = (ad.b)this.adh.get(i);
          continue;
        }
        Collections.sort(this.adh, adi);
        i = 0;
        if (i < this.adh.size())
        {
          localObject1 = (ad.b)this.adh.get(i);
          if (((ad.b)localObject1).adp != null)
          {
            if (((ad.b)localObject1).adm)
            {
              l1 = 9223372036854775807L;
              localObject4 = a(((ad.b)localObject1).adp, ((ad.b)localObject1).position, l1);
              if ((localObject4 == null) || (((RecyclerView.v)localObject4).aif == null) || (!((RecyclerView.v)localObject4).isBound()) || (((RecyclerView.v)localObject4).ij())) {
                continue;
              }
              localObject4 = (RecyclerView)((RecyclerView.v)localObject4).aif.get();
              if (localObject4 == null) {
                continue;
              }
              if ((((RecyclerView)localObject4).afW) && (((RecyclerView)localObject4).afB.gx() != 0)) {
                ((RecyclerView)localObject4).hm();
              }
              locala = ((RecyclerView)localObject4).agt;
              locala.a((RecyclerView)localObject4, true);
              j = locala.mCount;
              if (j == 0) {
                continue;
              }
            }
            try
            {
              f.beginSection("RV Nested Prefetch");
              RecyclerView.s locals = ((RecyclerView)localObject4).agu;
              RecyclerView.a locala1 = ((RecyclerView)localObject4).Sw;
              locals.ahN = 1;
              locals.ahO = locala1.getItemCount();
              locals.ahQ = false;
              locals.ahR = false;
              locals.ahS = false;
              j = 0;
              if (j < locala.mCount * 2)
              {
                a((RecyclerView)localObject4, locala.adl[j], l2);
                j += 2;
                continue;
                l1 = l2;
                continue;
              }
              f.endSection();
              ((ad.b)localObject1).adm = false;
              ((ad.b)localObject1).adn = 0;
              ((ad.b)localObject1).ado = 0;
              ((ad.b)localObject1).adp = null;
              ((ad.b)localObject1).position = 0;
              i += 1;
              continue;
            }
            finally
            {
              f.endSection();
            }
          }
        }
        this.adf = 0L;
      }
      finally
      {
        this.adf = 0L;
        f.endSection();
      }
      f.endSection();
      return;
      label713:
      break label735;
      label716:
      break label722;
      label719:
      continue;
      label722:
      j += 1;
      continue;
      label729:
      boolean bool = false;
      continue;
      label735:
      j += 1;
    }
  }
  
  static final class a
    implements RecyclerView.i.a
  {
    int adj;
    int adk;
    int[] adl;
    int mCount;
    
    public final void M(int paramInt1, int paramInt2)
    {
      if (paramInt1 < 0) {
        throw new IllegalArgumentException("Layout positions must be non-negative");
      }
      if (paramInt2 < 0) {
        throw new IllegalArgumentException("Pixel distance must be non-negative");
      }
      int i = this.mCount * 2;
      if (this.adl == null)
      {
        this.adl = new int[4];
        Arrays.fill(this.adl, -1);
      }
      for (;;)
      {
        this.adl[i] = paramInt1;
        this.adl[(i + 1)] = paramInt2;
        this.mCount += 1;
        return;
        if (i >= this.adl.length)
        {
          int[] arrayOfInt = this.adl;
          this.adl = new int[i * 2];
          System.arraycopy(arrayOfInt, 0, this.adl, 0, arrayOfInt.length);
        }
      }
    }
    
    final void a(RecyclerView paramRecyclerView, boolean paramBoolean)
    {
      this.mCount = 0;
      if (this.adl != null) {
        Arrays.fill(this.adl, -1);
      }
      RecyclerView.i locali = paramRecyclerView.afG;
      if ((paramRecyclerView.Sw != null) && (locali != null) && (locali.ahc))
      {
        if (!paramBoolean) {
          break label101;
        }
        if (!paramRecyclerView.afA.gb()) {
          locali.a(paramRecyclerView.Sw.getItemCount(), this);
        }
      }
      for (;;)
      {
        if (this.mCount > locali.ahd)
        {
          locali.ahd = this.mCount;
          locali.ahe = paramBoolean;
          paramRecyclerView.afy.hW();
        }
        return;
        label101:
        if (!paramRecyclerView.hM()) {
          locali.a(this.adj, this.adk, paramRecyclerView.agu, this);
        }
      }
    }
    
    final boolean bx(int paramInt)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      int j;
      int i;
      if (this.adl != null)
      {
        j = this.mCount;
        i = 0;
      }
      for (;;)
      {
        bool1 = bool2;
        if (i < j * 2)
        {
          if (this.adl[i] == paramInt) {
            bool1 = true;
          }
        }
        else {
          return bool1;
        }
        i += 2;
      }
    }
    
    final void gH()
    {
      if (this.adl != null) {
        Arrays.fill(this.adl, -1);
      }
      this.mCount = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.v7.widget.ad
 * JD-Core Version:    0.7.0.1
 */