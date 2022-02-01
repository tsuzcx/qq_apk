package androidx.recyclerview.widget;

import androidx.core.c.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

final class j
  implements Runnable
{
  static final ThreadLocal<j> bVX;
  static Comparator<b> bWc;
  ArrayList<RecyclerView> bVY;
  long bVZ;
  long bWa;
  private ArrayList<b> bWb;
  
  static
  {
    AppMethodBeat.i(194846);
    bVX = new ThreadLocal();
    bWc = new Comparator() {};
    AppMethodBeat.o(194846);
  }
  
  j()
  {
    AppMethodBeat.i(194827);
    this.bVY = new ArrayList();
    this.bWb = new ArrayList();
    AppMethodBeat.o(194827);
  }
  
  /* Error */
  private static RecyclerView.v a(RecyclerView paramRecyclerView, int paramInt, long paramLong)
  {
    // Byte code:
    //   0: ldc 62
    //   2: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 68	androidx/recyclerview/widget/RecyclerView:mChildHelper	Landroidx/recyclerview/widget/e;
    //   9: invokevirtual 74	androidx/recyclerview/widget/e:IU	()I
    //   12: istore 5
    //   14: iconst_0
    //   15: istore 4
    //   17: iload 4
    //   19: iload 5
    //   21: if_icmpge +58 -> 79
    //   24: aload_0
    //   25: getfield 68	androidx/recyclerview/widget/RecyclerView:mChildHelper	Landroidx/recyclerview/widget/e;
    //   28: iload 4
    //   30: invokevirtual 78	androidx/recyclerview/widget/e:fD	(I)Landroid/view/View;
    //   33: invokestatic 82	androidx/recyclerview/widget/RecyclerView:bz	(Landroid/view/View;)Landroidx/recyclerview/widget/RecyclerView$v;
    //   36: astore 6
    //   38: aload 6
    //   40: getfield 88	androidx/recyclerview/widget/RecyclerView$v:mPosition	I
    //   43: iload_1
    //   44: if_icmpne +26 -> 70
    //   47: aload 6
    //   49: invokevirtual 92	androidx/recyclerview/widget/RecyclerView$v:isInvalid	()Z
    //   52: ifne +18 -> 70
    //   55: iconst_1
    //   56: istore 4
    //   58: iload 4
    //   60: ifeq +25 -> 85
    //   63: ldc 62
    //   65: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   68: aconst_null
    //   69: areturn
    //   70: iload 4
    //   72: iconst_1
    //   73: iadd
    //   74: istore 4
    //   76: goto -59 -> 17
    //   79: iconst_0
    //   80: istore 4
    //   82: goto -24 -> 58
    //   85: aload_0
    //   86: getfield 96	androidx/recyclerview/widget/RecyclerView:bYt	Landroidx/recyclerview/widget/RecyclerView$n;
    //   89: astore 6
    //   91: aload_0
    //   92: invokevirtual 99	androidx/recyclerview/widget/RecyclerView:JY	()V
    //   95: aload 6
    //   97: iload_1
    //   98: lload_2
    //   99: invokevirtual 105	androidx/recyclerview/widget/RecyclerView$n:e	(IJ)Landroidx/recyclerview/widget/RecyclerView$v;
    //   102: astore 7
    //   104: aload 7
    //   106: ifnull +29 -> 135
    //   109: aload 7
    //   111: invokevirtual 108	androidx/recyclerview/widget/RecyclerView$v:isBound	()Z
    //   114: ifeq +34 -> 148
    //   117: aload 7
    //   119: invokevirtual 92	androidx/recyclerview/widget/RecyclerView$v:isInvalid	()Z
    //   122: ifne +26 -> 148
    //   125: aload 6
    //   127: aload 7
    //   129: getfield 112	androidx/recyclerview/widget/RecyclerView$v:caK	Landroid/view/View;
    //   132: invokevirtual 116	androidx/recyclerview/widget/RecyclerView$n:bH	(Landroid/view/View;)V
    //   135: aload_0
    //   136: iconst_0
    //   137: invokevirtual 120	androidx/recyclerview/widget/RecyclerView:bd	(Z)V
    //   140: ldc 62
    //   142: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   145: aload 7
    //   147: areturn
    //   148: aload 6
    //   150: aload 7
    //   152: iconst_0
    //   153: invokevirtual 123	androidx/recyclerview/widget/RecyclerView$n:b	(Landroidx/recyclerview/widget/RecyclerView$v;Z)V
    //   156: goto -21 -> 135
    //   159: astore 6
    //   161: aload_0
    //   162: iconst_0
    //   163: invokevirtual 120	androidx/recyclerview/widget/RecyclerView:bd	(Z)V
    //   166: ldc 62
    //   168: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   171: aload 6
    //   173: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	paramRecyclerView	RecyclerView
    //   0	174	1	paramInt	int
    //   0	174	2	paramLong	long
    //   15	66	4	i	int
    //   12	10	5	j	int
    //   36	113	6	localObject1	Object
    //   159	13	6	localObject2	Object
    //   102	49	7	localv	RecyclerView.v
    // Exception table:
    //   from	to	target	type
    //   91	104	159	finally
    //   109	135	159	finally
    //   148	156	159	finally
  }
  
  final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194853);
    if ((paramRecyclerView.isAttachedToWindow()) && (this.bVZ == 0L))
    {
      this.bVZ = paramRecyclerView.getNanoTime();
      paramRecyclerView.post(this);
    }
    paramRecyclerView = paramRecyclerView.bZm;
    paramRecyclerView.bWd = paramInt1;
    paramRecyclerView.bWe = paramInt2;
    AppMethodBeat.o(194853);
  }
  
  public final void run()
  {
    AppMethodBeat.i(194872);
    for (;;)
    {
      int j;
      try
      {
        g.ax("RV Prefetch");
        bool = this.bVY.isEmpty();
        if (bool) {
          return;
        }
        j = this.bVY.size();
        long l1 = 0L;
        int i = 0;
        Object localObject1;
        if (i < j)
        {
          localObject1 = (RecyclerView)this.bVY.get(i);
          if (((RecyclerView)localObject1).getWindowVisibility() != 0) {
            break label750;
          }
          l1 = Math.max(((RecyclerView)localObject1).getDrawingTime(), l1);
          i += 1;
          continue;
        }
        if (l1 == 0L) {
          return;
        }
        long l2 = TimeUnit.MILLISECONDS.toNanos(l1) + this.bWa;
        int m = this.bVY.size();
        i = 0;
        j = 0;
        if (j < m)
        {
          localObject1 = (RecyclerView)this.bVY.get(j);
          if (((RecyclerView)localObject1).getWindowVisibility() != 0) {
            break label747;
          }
          ((RecyclerView)localObject1).bZm.a((RecyclerView)localObject1, false);
          i = ((RecyclerView)localObject1).bZm.mCount + i;
          break label753;
        }
        this.bWb.ensureCapacity(i);
        i = 0;
        j = 0;
        Object localObject4;
        a locala;
        if (j < m)
        {
          localObject4 = (RecyclerView)this.bVY.get(j);
          if (((RecyclerView)localObject4).getWindowVisibility() != 0) {
            break label744;
          }
          locala = ((RecyclerView)localObject4).bZm;
          int n = Math.abs(locala.bWd) + Math.abs(locala.bWe);
          int k = 0;
          if (k >= locala.mCount * 2) {
            break label766;
          }
          if (i >= this.bWb.size())
          {
            localObject1 = new b();
            this.bWb.add(localObject1);
            int i1 = locala.bWf[(k + 1)];
            if (i1 > n) {
              break label760;
            }
            bool = true;
            ((b)localObject1).bWg = bool;
            ((b)localObject1).bWh = n;
            ((b)localObject1).bWi = i1;
            ((b)localObject1).bWj = ((RecyclerView)localObject4);
            ((b)localObject1).position = locala.bWf[k];
            i += 1;
            k += 2;
            continue;
          }
          localObject1 = (b)this.bWb.get(i);
          continue;
        }
        Collections.sort(this.bWb, bWc);
        i = 0;
        if (i < this.bWb.size())
        {
          localObject1 = (b)this.bWb.get(i);
          if (((b)localObject1).bWj != null)
          {
            if (((b)localObject1).bWg)
            {
              l1 = 9223372036854775807L;
              localObject4 = a(((b)localObject1).bWj, ((b)localObject1).position, l1);
              if ((localObject4 == null) || (((RecyclerView.v)localObject4).caL == null) || (!((RecyclerView.v)localObject4).isBound()) || (((RecyclerView.v)localObject4).isInvalid())) {
                continue;
              }
              localObject4 = (RecyclerView)((RecyclerView.v)localObject4).caL.get();
              if (localObject4 == null) {
                continue;
              }
              if ((((RecyclerView)localObject4).bYQ) && (((RecyclerView)localObject4).mChildHelper.IU() != 0)) {
                ((RecyclerView)localObject4).JK();
              }
              locala = ((RecyclerView)localObject4).bZm;
              locala.a((RecyclerView)localObject4, true);
              j = locala.mCount;
              if (j == 0) {
                continue;
              }
            }
            try
            {
              g.ax("RV Nested Prefetch");
              RecyclerView.s locals = ((RecyclerView)localObject4).bZn;
              RecyclerView.a locala1 = ((RecyclerView)localObject4).bUp;
              locals.cat = 1;
              locals.cau = locala1.getItemCount();
              locals.caw = false;
              locals.cax = false;
              locals.cay = false;
              j = 0;
              if (j < locala.mCount * 2)
              {
                a((RecyclerView)localObject4, locala.bWf[j], l2);
                j += 2;
                continue;
                l1 = l2;
                continue;
              }
              g.DS();
              ((b)localObject1).bWg = false;
              ((b)localObject1).bWh = 0;
              ((b)localObject1).bWi = 0;
              ((b)localObject1).bWj = null;
              ((b)localObject1).position = 0;
              i += 1;
              continue;
            }
            finally
            {
              g.DS();
              AppMethodBeat.o(194872);
            }
          }
        }
        this.bVZ = 0L;
      }
      finally
      {
        this.bVZ = 0L;
        g.DS();
        AppMethodBeat.o(194872);
      }
      g.DS();
      AppMethodBeat.o(194872);
      return;
      label744:
      break label766;
      label747:
      break label753;
      label750:
      continue;
      label753:
      j += 1;
      continue;
      label760:
      boolean bool = false;
      continue;
      label766:
      j += 1;
    }
  }
  
  static final class a
    implements RecyclerView.LayoutManager.a
  {
    int bWd;
    int bWe;
    int[] bWf;
    int mCount;
    
    final void Jc()
    {
      AppMethodBeat.i(195160);
      if (this.bWf != null) {
        Arrays.fill(this.bWf, -1);
      }
      this.mCount = 0;
      AppMethodBeat.o(195160);
    }
    
    final void a(RecyclerView paramRecyclerView, boolean paramBoolean)
    {
      AppMethodBeat.i(195132);
      this.mCount = 0;
      if (this.bWf != null) {
        Arrays.fill(this.bWf, -1);
      }
      RecyclerView.LayoutManager localLayoutManager = paramRecyclerView.bYA;
      if ((paramRecyclerView.bUp != null) && (localLayoutManager != null) && (localLayoutManager.isItemPrefetchEnabled()))
      {
        if (!paramBoolean) {
          break label111;
        }
        if (!paramRecyclerView.bYv.IP()) {
          localLayoutManager.collectInitialPrefetchPositions(paramRecyclerView.bUp.getItemCount(), this);
        }
      }
      for (;;)
      {
        if (this.mCount > localLayoutManager.mPrefetchMaxCountObserved)
        {
          localLayoutManager.mPrefetchMaxCountObserved = this.mCount;
          localLayoutManager.mPrefetchMaxObservedInInitialPrefetch = paramBoolean;
          paramRecyclerView.bYt.KA();
        }
        AppMethodBeat.o(195132);
        return;
        label111:
        if (!paramRecyclerView.Kq()) {
          localLayoutManager.collectAdjacentPrefetchPositions(this.bWd, this.bWe, paramRecyclerView.bZn, this);
        }
      }
    }
    
    public final void bd(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(195142);
      Object localObject;
      if (paramInt1 < 0)
      {
        localObject = new IllegalArgumentException("Layout positions must be non-negative");
        AppMethodBeat.o(195142);
        throw ((Throwable)localObject);
      }
      if (paramInt2 < 0)
      {
        localObject = new IllegalArgumentException("Pixel distance must be non-negative");
        AppMethodBeat.o(195142);
        throw ((Throwable)localObject);
      }
      int i = this.mCount * 2;
      if (this.bWf == null)
      {
        this.bWf = new int[4];
        Arrays.fill(this.bWf, -1);
      }
      for (;;)
      {
        this.bWf[i] = paramInt1;
        this.bWf[(i + 1)] = paramInt2;
        this.mCount += 1;
        AppMethodBeat.o(195142);
        return;
        if (i >= this.bWf.length)
        {
          localObject = this.bWf;
          this.bWf = new int[i * 2];
          System.arraycopy(localObject, 0, this.bWf, 0, localObject.length);
        }
      }
    }
    
    final boolean fG(int paramInt)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      int j;
      int i;
      if (this.bWf != null)
      {
        j = this.mCount;
        i = 0;
      }
      for (;;)
      {
        bool1 = bool2;
        if (i < j * 2)
        {
          if (this.bWf[i] == paramInt) {
            bool1 = true;
          }
        }
        else {
          return bool1;
        }
        i += 2;
      }
    }
  }
  
  static final class b
  {
    public boolean bWg;
    public int bWh;
    public int bWi;
    public RecyclerView bWj;
    public int position;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.recyclerview.widget.j
 * JD-Core Version:    0.7.0.1
 */