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
  static final ThreadLocal<ac> anQ = new ThreadLocal();
  static Comparator<b> anV = new Comparator() {};
  ArrayList<RecyclerView> anR = new ArrayList();
  long anS;
  long anT;
  private ArrayList<b> anU = new ArrayList();
  
  /* Error */
  private static RecyclerView.v a(RecyclerView paramRecyclerView, int paramInt, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 56	android/support/v7/widget/RecyclerView:mChildHelper	Landroid/support/v7/widget/s;
    //   4: invokevirtual 62	android/support/v7/widget/s:jA	()I
    //   7: istore 5
    //   9: iconst_0
    //   10: istore 4
    //   12: iload 4
    //   14: iload 5
    //   16: if_icmpge +53 -> 69
    //   19: aload_0
    //   20: getfield 56	android/support/v7/widget/RecyclerView:mChildHelper	Landroid/support/v7/widget/s;
    //   23: iload 4
    //   25: invokevirtual 66	android/support/v7/widget/s:bM	(I)Landroid/view/View;
    //   28: invokestatic 70	android/support/v7/widget/RecyclerView:bv	(Landroid/view/View;)Landroid/support/v7/widget/RecyclerView$v;
    //   31: astore 6
    //   33: aload 6
    //   35: getfield 76	android/support/v7/widget/RecyclerView$v:mPosition	I
    //   38: iload_1
    //   39: if_icmpne +21 -> 60
    //   42: aload 6
    //   44: invokevirtual 80	android/support/v7/widget/RecyclerView$v:isInvalid	()Z
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
    //   76: getfield 84	android/support/v7/widget/RecyclerView:arV	Landroid/support/v7/widget/RecyclerView$n;
    //   79: astore 6
    //   81: aload_0
    //   82: invokevirtual 87	android/support/v7/widget/RecyclerView:la	()V
    //   85: aload 6
    //   87: iload_1
    //   88: lload_2
    //   89: invokevirtual 93	android/support/v7/widget/RecyclerView$n:e	(IJ)Landroid/support/v7/widget/RecyclerView$v;
    //   92: astore 7
    //   94: aload 7
    //   96: ifnull +29 -> 125
    //   99: aload 7
    //   101: invokevirtual 96	android/support/v7/widget/RecyclerView$v:isBound	()Z
    //   104: ifeq +29 -> 133
    //   107: aload 7
    //   109: invokevirtual 80	android/support/v7/widget/RecyclerView$v:isInvalid	()Z
    //   112: ifne +21 -> 133
    //   115: aload 6
    //   117: aload 7
    //   119: getfield 100	android/support/v7/widget/RecyclerView$v:aus	Landroid/view/View;
    //   122: invokevirtual 104	android/support/v7/widget/RecyclerView$n:bF	(Landroid/view/View;)V
    //   125: aload_0
    //   126: iconst_0
    //   127: invokevirtual 108	android/support/v7/widget/RecyclerView:as	(Z)V
    //   130: aload 7
    //   132: areturn
    //   133: aload 6
    //   135: aload 7
    //   137: iconst_0
    //   138: invokevirtual 111	android/support/v7/widget/RecyclerView$n:a	(Landroid/support/v7/widget/RecyclerView$v;Z)V
    //   141: goto -16 -> 125
    //   144: astore 6
    //   146: aload_0
    //   147: iconst_0
    //   148: invokevirtual 108	android/support/v7/widget/RecyclerView:as	(Z)V
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
  
  final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if ((paramRecyclerView.isAttachedToWindow()) && (this.anS == 0L))
    {
      this.anS = paramRecyclerView.getNanoTime();
      paramRecyclerView.post(this);
    }
    paramRecyclerView = paramRecyclerView.asQ;
    paramRecyclerView.anW = paramInt1;
    paramRecyclerView.anX = paramInt2;
  }
  
  public final void run()
  {
    for (;;)
    {
      int j;
      try
      {
        e.beginSection("RV Prefetch");
        bool = this.anR.isEmpty();
        if (bool) {
          return;
        }
        j = this.anR.size();
        long l1 = 0L;
        int i = 0;
        Object localObject1;
        if (i < j)
        {
          localObject1 = (RecyclerView)this.anR.get(i);
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
        long l2 = TimeUnit.MILLISECONDS.toNanos(l1) + this.anT;
        int m = this.anR.size();
        i = 0;
        j = 0;
        if (j < m)
        {
          localObject1 = (RecyclerView)this.anR.get(j);
          if (((RecyclerView)localObject1).getWindowVisibility() != 0) {
            break label716;
          }
          ((RecyclerView)localObject1).asQ.a((RecyclerView)localObject1, false);
          i = ((RecyclerView)localObject1).asQ.mCount + i;
          break label722;
        }
        this.anU.ensureCapacity(i);
        i = 0;
        j = 0;
        Object localObject4;
        a locala;
        if (j < m)
        {
          localObject4 = (RecyclerView)this.anR.get(j);
          if (((RecyclerView)localObject4).getWindowVisibility() != 0) {
            break label713;
          }
          locala = ((RecyclerView)localObject4).asQ;
          int n = Math.abs(locala.anW) + Math.abs(locala.anX);
          int k = 0;
          if (k >= locala.mCount * 2) {
            break label735;
          }
          if (i >= this.anU.size())
          {
            localObject1 = new b();
            this.anU.add(localObject1);
            int i1 = locala.anY[(k + 1)];
            if (i1 > n) {
              break label729;
            }
            bool = true;
            ((b)localObject1).anZ = bool;
            ((b)localObject1).aoa = n;
            ((b)localObject1).aob = i1;
            ((b)localObject1).aoc = ((RecyclerView)localObject4);
            ((b)localObject1).position = locala.anY[k];
            i += 1;
            k += 2;
            continue;
          }
          localObject1 = (b)this.anU.get(i);
          continue;
        }
        Collections.sort(this.anU, anV);
        i = 0;
        if (i < this.anU.size())
        {
          localObject1 = (b)this.anU.get(i);
          if (((b)localObject1).aoc != null)
          {
            if (((b)localObject1).anZ)
            {
              l1 = 9223372036854775807L;
              localObject4 = a(((b)localObject1).aoc, ((b)localObject1).position, l1);
              if ((localObject4 == null) || (((RecyclerView.v)localObject4).aut == null) || (!((RecyclerView.v)localObject4).isBound()) || (((RecyclerView.v)localObject4).isInvalid())) {
                continue;
              }
              localObject4 = (RecyclerView)((RecyclerView.v)localObject4).aut.get();
              if (localObject4 == null) {
                continue;
              }
              if ((((RecyclerView)localObject4).ast) && (((RecyclerView)localObject4).mChildHelper.jA() != 0)) {
                ((RecyclerView)localObject4).kM();
              }
              locala = ((RecyclerView)localObject4).asQ;
              locala.a((RecyclerView)localObject4, true);
              j = locala.mCount;
              if (j == 0) {
                continue;
              }
            }
            try
            {
              e.beginSection("RV Nested Prefetch");
              RecyclerView.s locals = ((RecyclerView)localObject4).asR;
              RecyclerView.a locala1 = ((RecyclerView)localObject4).adj;
              locals.aub = 1;
              locals.auc = locala1.getItemCount();
              locals.aue = false;
              locals.auf = false;
              locals.aug = false;
              j = 0;
              if (j < locala.mCount * 2)
              {
                a((RecyclerView)localObject4, locala.anY[j], l2);
                j += 2;
                continue;
                l1 = l2;
                continue;
              }
              e.endSection();
              ((b)localObject1).anZ = false;
              ((b)localObject1).aoa = 0;
              ((b)localObject1).aob = 0;
              ((b)localObject1).aoc = null;
              ((b)localObject1).position = 0;
              i += 1;
              continue;
            }
            finally
            {
              e.endSection();
            }
          }
        }
        this.anS = 0L;
      }
      finally
      {
        this.anS = 0L;
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
    implements RecyclerView.LayoutManager.a
  {
    int anW;
    int anX;
    int[] anY;
    int mCount;
    
    public final void S(int paramInt1, int paramInt2)
    {
      if (paramInt1 < 0) {
        throw new IllegalArgumentException("Layout positions must be non-negative");
      }
      if (paramInt2 < 0) {
        throw new IllegalArgumentException("Pixel distance must be non-negative");
      }
      int i = this.mCount * 2;
      if (this.anY == null)
      {
        this.anY = new int[4];
        Arrays.fill(this.anY, -1);
      }
      for (;;)
      {
        this.anY[i] = paramInt1;
        this.anY[(i + 1)] = paramInt2;
        this.mCount += 1;
        return;
        if (i >= this.anY.length)
        {
          int[] arrayOfInt = this.anY;
          this.anY = new int[i * 2];
          System.arraycopy(arrayOfInt, 0, this.anY, 0, arrayOfInt.length);
        }
      }
    }
    
    final void a(RecyclerView paramRecyclerView, boolean paramBoolean)
    {
      this.mCount = 0;
      if (this.anY != null) {
        Arrays.fill(this.anY, -1);
      }
      RecyclerView.LayoutManager localLayoutManager = paramRecyclerView.asc;
      if ((paramRecyclerView.adj != null) && (localLayoutManager != null) && (localLayoutManager.isItemPrefetchEnabled()))
      {
        if (!paramBoolean) {
          break label101;
        }
        if (!paramRecyclerView.arX.jc()) {
          localLayoutManager.collectInitialPrefetchPositions(paramRecyclerView.adj.getItemCount(), this);
        }
      }
      for (;;)
      {
        if (this.mCount > localLayoutManager.mPrefetchMaxCountObserved)
        {
          localLayoutManager.mPrefetchMaxCountObserved = this.mCount;
          localLayoutManager.mPrefetchMaxObservedInInitialPrefetch = paramBoolean;
          paramRecyclerView.arV.lI();
        }
        return;
        label101:
        if (!paramRecyclerView.lt()) {
          localLayoutManager.collectAdjacentPrefetchPositions(this.anW, this.anX, paramRecyclerView.asR, this);
        }
      }
    }
    
    final boolean bP(int paramInt)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      int j;
      int i;
      if (this.anY != null)
      {
        j = this.mCount;
        i = 0;
      }
      for (;;)
      {
        bool1 = bool2;
        if (i < j * 2)
        {
          if (this.anY[i] == paramInt) {
            bool1 = true;
          }
        }
        else {
          return bool1;
        }
        i += 2;
      }
    }
    
    final void jL()
    {
      if (this.anY != null) {
        Arrays.fill(this.anY, -1);
      }
      this.mCount = 0;
    }
  }
  
  static final class b
  {
    public boolean anZ;
    public int aoa;
    public int aob;
    public RecyclerView aoc;
    public int position;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.ac
 * JD-Core Version:    0.7.0.1
 */