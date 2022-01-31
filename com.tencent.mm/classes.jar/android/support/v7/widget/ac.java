package android.support.v7.widget;

import android.support.v4.os.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

final class ac
  implements Runnable
{
  static final ThreadLocal<ac> adM = new ThreadLocal();
  static Comparator<ac.b> adR = new ac.1();
  ArrayList<RecyclerView> adN = new ArrayList();
  long adO;
  long adP;
  private ArrayList<ac.b> adQ = new ArrayList();
  
  /* Error */
  private static RecyclerView.v a(RecyclerView paramRecyclerView, int paramInt, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 55	android/support/v7/widget/RecyclerView:ahR	Landroid/support/v7/widget/s;
    //   4: invokevirtual 61	android/support/v7/widget/s:hx	()I
    //   7: istore 5
    //   9: iconst_0
    //   10: istore 4
    //   12: iload 4
    //   14: iload 5
    //   16: if_icmpge +53 -> 69
    //   19: aload_0
    //   20: getfield 55	android/support/v7/widget/RecyclerView:ahR	Landroid/support/v7/widget/s;
    //   23: iload 4
    //   25: invokevirtual 65	android/support/v7/widget/s:bt	(I)Landroid/view/View;
    //   28: invokestatic 69	android/support/v7/widget/RecyclerView:bp	(Landroid/view/View;)Landroid/support/v7/widget/RecyclerView$v;
    //   31: astore 6
    //   33: aload 6
    //   35: getfield 75	android/support/v7/widget/RecyclerView$v:mPosition	I
    //   38: iload_1
    //   39: if_icmpne +21 -> 60
    //   42: aload 6
    //   44: invokevirtual 79	android/support/v7/widget/RecyclerView$v:jU	()Z
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
    //   76: getfield 83	android/support/v7/widget/RecyclerView:ahO	Landroid/support/v7/widget/RecyclerView$o;
    //   79: astore 6
    //   81: aload_0
    //   82: invokevirtual 86	android/support/v7/widget/RecyclerView:ja	()V
    //   85: aload 6
    //   87: iload_1
    //   88: lload_2
    //   89: invokevirtual 92	android/support/v7/widget/RecyclerView$o:e	(IJ)Landroid/support/v7/widget/RecyclerView$v;
    //   92: astore 7
    //   94: aload 7
    //   96: ifnull +29 -> 125
    //   99: aload 7
    //   101: invokevirtual 95	android/support/v7/widget/RecyclerView$v:isBound	()Z
    //   104: ifeq +29 -> 133
    //   107: aload 7
    //   109: invokevirtual 79	android/support/v7/widget/RecyclerView$v:jU	()Z
    //   112: ifne +21 -> 133
    //   115: aload 6
    //   117: aload 7
    //   119: getfield 99	android/support/v7/widget/RecyclerView$v:aku	Landroid/view/View;
    //   122: invokevirtual 103	android/support/v7/widget/RecyclerView$o:bK	(Landroid/view/View;)V
    //   125: aload_0
    //   126: iconst_0
    //   127: invokevirtual 107	android/support/v7/widget/RecyclerView:am	(Z)V
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
    //   148: invokevirtual 107	android/support/v7/widget/RecyclerView:am	(Z)V
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
    if ((paramRecyclerView.isAttachedToWindow()) && (this.adO == 0L))
    {
      this.adO = paramRecyclerView.getNanoTime();
      paramRecyclerView.post(this);
    }
    paramRecyclerView = paramRecyclerView.aiJ;
    paramRecyclerView.adS = paramInt1;
    paramRecyclerView.adT = paramInt2;
  }
  
  public final void run()
  {
    for (;;)
    {
      int j;
      try
      {
        e.beginSection("RV Prefetch");
        bool = this.adN.isEmpty();
        if (bool) {
          return;
        }
        j = this.adN.size();
        long l1 = 0L;
        int i = 0;
        Object localObject1;
        if (i < j)
        {
          localObject1 = (RecyclerView)this.adN.get(i);
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
        long l2 = TimeUnit.MILLISECONDS.toNanos(l1) + this.adP;
        int m = this.adN.size();
        i = 0;
        j = 0;
        if (j < m)
        {
          localObject1 = (RecyclerView)this.adN.get(j);
          if (((RecyclerView)localObject1).getWindowVisibility() != 0) {
            break label716;
          }
          ((RecyclerView)localObject1).aiJ.a((RecyclerView)localObject1, false);
          i = ((RecyclerView)localObject1).aiJ.mCount + i;
          break label722;
        }
        this.adQ.ensureCapacity(i);
        i = 0;
        j = 0;
        Object localObject4;
        a locala;
        if (j < m)
        {
          localObject4 = (RecyclerView)this.adN.get(j);
          if (((RecyclerView)localObject4).getWindowVisibility() != 0) {
            break label713;
          }
          locala = ((RecyclerView)localObject4).aiJ;
          int n = Math.abs(locala.adS) + Math.abs(locala.adT);
          int k = 0;
          if (k >= locala.mCount * 2) {
            break label735;
          }
          if (i >= this.adQ.size())
          {
            localObject1 = new ac.b();
            this.adQ.add(localObject1);
            int i1 = locala.adU[(k + 1)];
            if (i1 > n) {
              break label729;
            }
            bool = true;
            ((ac.b)localObject1).adV = bool;
            ((ac.b)localObject1).adW = n;
            ((ac.b)localObject1).adX = i1;
            ((ac.b)localObject1).adY = ((RecyclerView)localObject4);
            ((ac.b)localObject1).position = locala.adU[k];
            i += 1;
            k += 2;
            continue;
          }
          localObject1 = (ac.b)this.adQ.get(i);
          continue;
        }
        Collections.sort(this.adQ, adR);
        i = 0;
        if (i < this.adQ.size())
        {
          localObject1 = (ac.b)this.adQ.get(i);
          if (((ac.b)localObject1).adY != null)
          {
            if (((ac.b)localObject1).adV)
            {
              l1 = 9223372036854775807L;
              localObject4 = a(((ac.b)localObject1).adY, ((ac.b)localObject1).position, l1);
              if ((localObject4 == null) || (((RecyclerView.v)localObject4).akv == null) || (!((RecyclerView.v)localObject4).isBound()) || (((RecyclerView.v)localObject4).jU())) {
                continue;
              }
              localObject4 = (RecyclerView)((RecyclerView.v)localObject4).akv.get();
              if (localObject4 == null) {
                continue;
              }
              if ((((RecyclerView)localObject4).aim) && (((RecyclerView)localObject4).ahR.hx() != 0)) {
                ((RecyclerView)localObject4).iN();
              }
              locala = ((RecyclerView)localObject4).aiJ;
              locala.a((RecyclerView)localObject4, true);
              j = locala.mCount;
              if (j == 0) {
                continue;
              }
            }
            try
            {
              e.beginSection("RV Nested Prefetch");
              RecyclerView.s locals = ((RecyclerView)localObject4).aiK;
              RecyclerView.a locala1 = ((RecyclerView)localObject4).Tg;
              locals.akd = 1;
              locals.ake = locala1.getItemCount();
              locals.akg = false;
              locals.akh = false;
              locals.aki = false;
              j = 0;
              if (j < locala.mCount * 2)
              {
                a((RecyclerView)localObject4, locala.adU[j], l2);
                j += 2;
                continue;
                l1 = l2;
                continue;
              }
              e.endSection();
              ((ac.b)localObject1).adV = false;
              ((ac.b)localObject1).adW = 0;
              ((ac.b)localObject1).adX = 0;
              ((ac.b)localObject1).adY = null;
              ((ac.b)localObject1).position = 0;
              i += 1;
              continue;
            }
            finally
            {
              e.endSection();
            }
          }
        }
        this.adO = 0L;
      }
      finally
      {
        this.adO = 0L;
        e.endSection();
      }
      e.endSection();
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
    int adS;
    int adT;
    int[] adU;
    int mCount;
    
    public final void P(int paramInt1, int paramInt2)
    {
      if (paramInt1 < 0) {
        throw new IllegalArgumentException("Layout positions must be non-negative");
      }
      if (paramInt2 < 0) {
        throw new IllegalArgumentException("Pixel distance must be non-negative");
      }
      int i = this.mCount * 2;
      if (this.adU == null)
      {
        this.adU = new int[4];
        Arrays.fill(this.adU, -1);
      }
      for (;;)
      {
        this.adU[i] = paramInt1;
        this.adU[(i + 1)] = paramInt2;
        this.mCount += 1;
        return;
        if (i >= this.adU.length)
        {
          int[] arrayOfInt = this.adU;
          this.adU = new int[i * 2];
          System.arraycopy(arrayOfInt, 0, this.adU, 0, arrayOfInt.length);
        }
      }
    }
    
    final void a(RecyclerView paramRecyclerView, boolean paramBoolean)
    {
      this.mCount = 0;
      if (this.adU != null) {
        Arrays.fill(this.adU, -1);
      }
      RecyclerView.i locali = paramRecyclerView.ahW;
      if ((paramRecyclerView.Tg != null) && (locali != null) && (locali.ajs))
      {
        if (!paramBoolean) {
          break label101;
        }
        if (!paramRecyclerView.ahQ.gY()) {
          locali.a(paramRecyclerView.Tg.getItemCount(), this);
        }
      }
      for (;;)
      {
        if (this.mCount > locali.ajt)
        {
          locali.ajt = this.mCount;
          locali.aju = paramBoolean;
          paramRecyclerView.ahO.jF();
        }
        return;
        label101:
        if (!paramRecyclerView.js()) {
          locali.a(this.adS, this.adT, paramRecyclerView.aiK, this);
        }
      }
    }
    
    final boolean bx(int paramInt)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      int j;
      int i;
      if (this.adU != null)
      {
        j = this.mCount;
        i = 0;
      }
      for (;;)
      {
        bool1 = bool2;
        if (i < j * 2)
        {
          if (this.adU[i] == paramInt) {
            bool1 = true;
          }
        }
        else {
          return bool1;
        }
        i += 2;
      }
    }
    
    final void hI()
    {
      if (this.adU != null) {
        Arrays.fill(this.adU, -1);
      }
      this.mCount = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.v7.widget.ac
 * JD-Core Version:    0.7.0.1
 */