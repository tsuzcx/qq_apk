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
  static final ThreadLocal<ac> akT = new ThreadLocal();
  static Comparator<b> akY = new Comparator() {};
  ArrayList<RecyclerView> akU = new ArrayList();
  long akV;
  long akW;
  private ArrayList<b> akX = new ArrayList();
  
  /* Error */
  private static RecyclerView.v a(RecyclerView paramRecyclerView, int paramInt, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 56	android/support/v7/widget/RecyclerView:aoY	Landroid/support/v7/widget/s;
    //   4: invokevirtual 62	android/support/v7/widget/s:iT	()I
    //   7: istore 5
    //   9: iconst_0
    //   10: istore 4
    //   12: iload 4
    //   14: iload 5
    //   16: if_icmpge +53 -> 69
    //   19: aload_0
    //   20: getfield 56	android/support/v7/widget/RecyclerView:aoY	Landroid/support/v7/widget/s;
    //   23: iload 4
    //   25: invokevirtual 66	android/support/v7/widget/s:bL	(I)Landroid/view/View;
    //   28: invokestatic 70	android/support/v7/widget/RecyclerView:bv	(Landroid/view/View;)Landroid/support/v7/widget/RecyclerView$v;
    //   31: astore 6
    //   33: aload 6
    //   35: getfield 76	android/support/v7/widget/RecyclerView$v:mPosition	I
    //   38: iload_1
    //   39: if_icmpne +21 -> 60
    //   42: aload 6
    //   44: invokevirtual 80	android/support/v7/widget/RecyclerView$v:bc	()Z
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
    //   76: getfield 84	android/support/v7/widget/RecyclerView:aoV	Landroid/support/v7/widget/RecyclerView$o;
    //   79: astore 6
    //   81: aload_0
    //   82: invokevirtual 87	android/support/v7/widget/RecyclerView:kv	()V
    //   85: aload 6
    //   87: iload_1
    //   88: lload_2
    //   89: invokevirtual 93	android/support/v7/widget/RecyclerView$o:e	(IJ)Landroid/support/v7/widget/RecyclerView$v;
    //   92: astore 7
    //   94: aload 7
    //   96: ifnull +29 -> 125
    //   99: aload 7
    //   101: invokevirtual 96	android/support/v7/widget/RecyclerView$v:isBound	()Z
    //   104: ifeq +29 -> 133
    //   107: aload 7
    //   109: invokevirtual 80	android/support/v7/widget/RecyclerView$v:bc	()Z
    //   112: ifne +21 -> 133
    //   115: aload 6
    //   117: aload 7
    //   119: getfield 100	android/support/v7/widget/RecyclerView$v:arI	Landroid/view/View;
    //   122: invokevirtual 104	android/support/v7/widget/RecyclerView$o:bS	(Landroid/view/View;)V
    //   125: aload_0
    //   126: iconst_0
    //   127: invokevirtual 108	android/support/v7/widget/RecyclerView:at	(Z)V
    //   130: aload 7
    //   132: areturn
    //   133: aload 6
    //   135: aload 7
    //   137: iconst_0
    //   138: invokevirtual 111	android/support/v7/widget/RecyclerView$o:a	(Landroid/support/v7/widget/RecyclerView$v;Z)V
    //   141: goto -16 -> 125
    //   144: astore 6
    //   146: aload_0
    //   147: iconst_0
    //   148: invokevirtual 108	android/support/v7/widget/RecyclerView:at	(Z)V
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
    if ((paramRecyclerView.isAttachedToWindow()) && (this.akV == 0L))
    {
      this.akV = paramRecyclerView.getNanoTime();
      paramRecyclerView.post(this);
    }
    paramRecyclerView = paramRecyclerView.apS;
    paramRecyclerView.akZ = paramInt1;
    paramRecyclerView.ala = paramInt2;
  }
  
  public final void run()
  {
    for (;;)
    {
      int j;
      try
      {
        e.beginSection("RV Prefetch");
        bool = this.akU.isEmpty();
        if (bool) {
          return;
        }
        j = this.akU.size();
        long l1 = 0L;
        int i = 0;
        Object localObject1;
        if (i < j)
        {
          localObject1 = (RecyclerView)this.akU.get(i);
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
        long l2 = TimeUnit.MILLISECONDS.toNanos(l1) + this.akW;
        int m = this.akU.size();
        i = 0;
        j = 0;
        if (j < m)
        {
          localObject1 = (RecyclerView)this.akU.get(j);
          if (((RecyclerView)localObject1).getWindowVisibility() != 0) {
            break label716;
          }
          ((RecyclerView)localObject1).apS.a((RecyclerView)localObject1, false);
          i = ((RecyclerView)localObject1).apS.mCount + i;
          break label722;
        }
        this.akX.ensureCapacity(i);
        i = 0;
        j = 0;
        Object localObject4;
        a locala;
        if (j < m)
        {
          localObject4 = (RecyclerView)this.akU.get(j);
          if (((RecyclerView)localObject4).getWindowVisibility() != 0) {
            break label713;
          }
          locala = ((RecyclerView)localObject4).apS;
          int n = Math.abs(locala.akZ) + Math.abs(locala.ala);
          int k = 0;
          if (k >= locala.mCount * 2) {
            break label735;
          }
          if (i >= this.akX.size())
          {
            localObject1 = new b();
            this.akX.add(localObject1);
            int i1 = locala.alb[(k + 1)];
            if (i1 > n) {
              break label729;
            }
            bool = true;
            ((b)localObject1).alc = bool;
            ((b)localObject1).ald = n;
            ((b)localObject1).ale = i1;
            ((b)localObject1).alf = ((RecyclerView)localObject4);
            ((b)localObject1).position = locala.alb[k];
            i += 1;
            k += 2;
            continue;
          }
          localObject1 = (b)this.akX.get(i);
          continue;
        }
        Collections.sort(this.akX, akY);
        i = 0;
        if (i < this.akX.size())
        {
          localObject1 = (b)this.akX.get(i);
          if (((b)localObject1).alf != null)
          {
            if (((b)localObject1).alc)
            {
              l1 = 9223372036854775807L;
              localObject4 = a(((b)localObject1).alf, ((b)localObject1).position, l1);
              if ((localObject4 == null) || (((RecyclerView.v)localObject4).arJ == null) || (!((RecyclerView.v)localObject4).isBound()) || (((RecyclerView.v)localObject4).bc())) {
                continue;
              }
              localObject4 = (RecyclerView)((RecyclerView.v)localObject4).arJ.get();
              if (localObject4 == null) {
                continue;
              }
              if ((((RecyclerView)localObject4).apv) && (((RecyclerView)localObject4).aoY.iT() != 0)) {
                ((RecyclerView)localObject4).ki();
              }
              locala = ((RecyclerView)localObject4).apS;
              locala.a((RecyclerView)localObject4, true);
              j = locala.mCount;
              if (j == 0) {
                continue;
              }
            }
            try
            {
              e.beginSection("RV Nested Prefetch");
              RecyclerView.s locals = ((RecyclerView)localObject4).apT;
              RecyclerView.a locala1 = ((RecyclerView)localObject4).aaj;
              locals.arr = 1;
              locals.ars = locala1.getItemCount();
              locals.aru = false;
              locals.arv = false;
              locals.arw = false;
              j = 0;
              if (j < locala.mCount * 2)
              {
                a((RecyclerView)localObject4, locala.alb[j], l2);
                j += 2;
                continue;
                l1 = l2;
                continue;
              }
              e.endSection();
              ((b)localObject1).alc = false;
              ((b)localObject1).ald = 0;
              ((b)localObject1).ale = 0;
              ((b)localObject1).alf = null;
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
        this.akV = 0L;
      }
      finally
      {
        this.akV = 0L;
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
    int akZ;
    int ala;
    int[] alb;
    int mCount;
    
    public final void R(int paramInt1, int paramInt2)
    {
      if (paramInt1 < 0) {
        throw new IllegalArgumentException("Layout positions must be non-negative");
      }
      if (paramInt2 < 0) {
        throw new IllegalArgumentException("Pixel distance must be non-negative");
      }
      int i = this.mCount * 2;
      if (this.alb == null)
      {
        this.alb = new int[4];
        Arrays.fill(this.alb, -1);
      }
      for (;;)
      {
        this.alb[i] = paramInt1;
        this.alb[(i + 1)] = paramInt2;
        this.mCount += 1;
        return;
        if (i >= this.alb.length)
        {
          int[] arrayOfInt = this.alb;
          this.alb = new int[i * 2];
          System.arraycopy(arrayOfInt, 0, this.alb, 0, arrayOfInt.length);
        }
      }
    }
    
    final void a(RecyclerView paramRecyclerView, boolean paramBoolean)
    {
      this.mCount = 0;
      if (this.alb != null) {
        Arrays.fill(this.alb, -1);
      }
      RecyclerView.i locali = paramRecyclerView.apd;
      if ((paramRecyclerView.aaj != null) && (locali != null) && (locali.aqC))
      {
        if (!paramBoolean) {
          break label101;
        }
        if (!paramRecyclerView.aoX.iv()) {
          locali.a(paramRecyclerView.aaj.getItemCount(), this);
        }
      }
      for (;;)
      {
        if (this.mCount > locali.aqD)
        {
          locali.aqD = this.mCount;
          locali.aqE = paramBoolean;
          paramRecyclerView.aoV.lf();
        }
        return;
        label101:
        if (!paramRecyclerView.kN()) {
          locali.a(this.akZ, this.ala, paramRecyclerView.apT, this);
        }
      }
    }
    
    final boolean bO(int paramInt)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      int j;
      int i;
      if (this.alb != null)
      {
        j = this.mCount;
        i = 0;
      }
      for (;;)
      {
        bool1 = bool2;
        if (i < j * 2)
        {
          if (this.alb[i] == paramInt) {
            bool1 = true;
          }
        }
        else {
          return bool1;
        }
        i += 2;
      }
    }
    
    final void je()
    {
      if (this.alb != null) {
        Arrays.fill(this.alb, -1);
      }
      this.mCount = 0;
    }
  }
  
  static final class b
  {
    public boolean alc;
    public int ald;
    public int ale;
    public RecyclerView alf;
    public int position;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.ac
 * JD-Core Version:    0.7.0.1
 */