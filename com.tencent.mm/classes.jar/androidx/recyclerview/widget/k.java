package androidx.recyclerview.widget;

import androidx.core.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

final class k
  implements Runnable
{
  static final ThreadLocal<k> ahr;
  static Comparator<b> ahw;
  ArrayList<RecyclerView> ahs;
  long aht;
  long ahu;
  private ArrayList<b> ahv;
  
  static
  {
    AppMethodBeat.i(261188);
    ahr = new ThreadLocal();
    ahw = new Comparator() {};
    AppMethodBeat.o(261188);
  }
  
  k()
  {
    AppMethodBeat.i(261162);
    this.ahs = new ArrayList();
    this.ahv = new ArrayList();
    AppMethodBeat.o(261162);
  }
  
  /* Error */
  private static RecyclerView.v a(RecyclerView paramRecyclerView, int paramInt, long paramLong)
  {
    // Byte code:
    //   0: ldc 62
    //   2: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 68	androidx/recyclerview/widget/RecyclerView:mChildHelper	Landroidx/recyclerview/widget/f;
    //   9: invokevirtual 74	androidx/recyclerview/widget/f:kj	()I
    //   12: istore 5
    //   14: iconst_0
    //   15: istore 4
    //   17: iload 4
    //   19: iload 5
    //   21: if_icmpge +58 -> 79
    //   24: aload_0
    //   25: getfield 68	androidx/recyclerview/widget/RecyclerView:mChildHelper	Landroidx/recyclerview/widget/f;
    //   28: iload 4
    //   30: invokevirtual 78	androidx/recyclerview/widget/f:cq	(I)Landroid/view/View;
    //   33: invokestatic 82	androidx/recyclerview/widget/RecyclerView:bg	(Landroid/view/View;)Landroidx/recyclerview/widget/RecyclerView$v;
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
    //   86: getfield 96	androidx/recyclerview/widget/RecyclerView:ajQ	Landroidx/recyclerview/widget/RecyclerView$n;
    //   89: astore 6
    //   91: aload_0
    //   92: invokevirtual 99	androidx/recyclerview/widget/RecyclerView:ln	()V
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
    //   129: getfield 112	androidx/recyclerview/widget/RecyclerView$v:amk	Landroid/view/View;
    //   132: invokevirtual 116	androidx/recyclerview/widget/RecyclerView$n:bo	(Landroid/view/View;)V
    //   135: aload_0
    //   136: iconst_0
    //   137: invokevirtual 120	androidx/recyclerview/widget/RecyclerView:au	(Z)V
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
    //   163: invokevirtual 120	androidx/recyclerview/widget/RecyclerView:au	(Z)V
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
    AppMethodBeat.i(261165);
    if ((paramRecyclerView.isAttachedToWindow()) && (this.aht == 0L))
    {
      this.aht = paramRecyclerView.getNanoTime();
      paramRecyclerView.post(this);
    }
    paramRecyclerView = paramRecyclerView.akK;
    paramRecyclerView.ahx = paramInt1;
    paramRecyclerView.ahy = paramInt2;
    AppMethodBeat.o(261165);
  }
  
  public final void run()
  {
    AppMethodBeat.i(261182);
    for (;;)
    {
      int j;
      try
      {
        d.D("RV Prefetch");
        bool = this.ahs.isEmpty();
        if (bool) {
          return;
        }
        j = this.ahs.size();
        long l1 = 0L;
        int i = 0;
        Object localObject1;
        if (i < j)
        {
          localObject1 = (RecyclerView)this.ahs.get(i);
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
        long l2 = TimeUnit.MILLISECONDS.toNanos(l1) + this.ahu;
        int m = this.ahs.size();
        i = 0;
        j = 0;
        if (j < m)
        {
          localObject1 = (RecyclerView)this.ahs.get(j);
          if (((RecyclerView)localObject1).getWindowVisibility() != 0) {
            break label747;
          }
          ((RecyclerView)localObject1).akK.a((RecyclerView)localObject1, false);
          i = ((RecyclerView)localObject1).akK.mCount + i;
          break label753;
        }
        this.ahv.ensureCapacity(i);
        i = 0;
        j = 0;
        Object localObject4;
        a locala;
        if (j < m)
        {
          localObject4 = (RecyclerView)this.ahs.get(j);
          if (((RecyclerView)localObject4).getWindowVisibility() != 0) {
            break label744;
          }
          locala = ((RecyclerView)localObject4).akK;
          int n = Math.abs(locala.ahx) + Math.abs(locala.ahy);
          int k = 0;
          if (k >= locala.mCount * 2) {
            break label766;
          }
          if (i >= this.ahv.size())
          {
            localObject1 = new b();
            this.ahv.add(localObject1);
            int i1 = locala.ahz[(k + 1)];
            if (i1 > n) {
              break label760;
            }
            bool = true;
            ((b)localObject1).ahA = bool;
            ((b)localObject1).ahB = n;
            ((b)localObject1).ahC = i1;
            ((b)localObject1).ahD = ((RecyclerView)localObject4);
            ((b)localObject1).position = locala.ahz[k];
            i += 1;
            k += 2;
            continue;
          }
          localObject1 = (b)this.ahv.get(i);
          continue;
        }
        Collections.sort(this.ahv, ahw);
        i = 0;
        if (i < this.ahv.size())
        {
          localObject1 = (b)this.ahv.get(i);
          if (((b)localObject1).ahD != null)
          {
            if (((b)localObject1).ahA)
            {
              l1 = 9223372036854775807L;
              localObject4 = a(((b)localObject1).ahD, ((b)localObject1).position, l1);
              if ((localObject4 == null) || (((RecyclerView.v)localObject4).aml == null) || (!((RecyclerView.v)localObject4).isBound()) || (((RecyclerView.v)localObject4).isInvalid())) {
                continue;
              }
              localObject4 = (RecyclerView)((RecyclerView.v)localObject4).aml.get();
              if (localObject4 == null) {
                continue;
              }
              if ((((RecyclerView)localObject4).ako) && (((RecyclerView)localObject4).mChildHelper.kj() != 0)) {
                ((RecyclerView)localObject4).kZ();
              }
              locala = ((RecyclerView)localObject4).akK;
              locala.a((RecyclerView)localObject4, true);
              j = locala.mCount;
              if (j == 0) {
                continue;
              }
            }
            try
            {
              d.D("RV Nested Prefetch");
              RecyclerView.s locals = ((RecyclerView)localObject4).akL;
              RecyclerView.a locala1 = ((RecyclerView)localObject4).afJ;
              locals.alT = 1;
              locals.alU = locala1.getItemCount();
              locals.alW = false;
              locals.alX = false;
              locals.alY = false;
              j = 0;
              if (j < locala.mCount * 2)
              {
                a((RecyclerView)localObject4, locala.ahz[j], l2);
                j += 2;
                continue;
                l1 = l2;
                continue;
              }
              d.gH();
              ((b)localObject1).ahA = false;
              ((b)localObject1).ahB = 0;
              ((b)localObject1).ahC = 0;
              ((b)localObject1).ahD = null;
              ((b)localObject1).position = 0;
              i += 1;
              continue;
            }
            finally
            {
              d.gH();
              AppMethodBeat.o(261182);
            }
          }
        }
        this.aht = 0L;
      }
      finally
      {
        this.aht = 0L;
        d.gH();
        AppMethodBeat.o(261182);
      }
      d.gH();
      AppMethodBeat.o(261182);
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
    int ahx;
    int ahy;
    int[] ahz;
    int mCount;
    
    final void a(RecyclerView paramRecyclerView, boolean paramBoolean)
    {
      AppMethodBeat.i(261137);
      this.mCount = 0;
      if (this.ahz != null) {
        Arrays.fill(this.ahz, -1);
      }
      RecyclerView.LayoutManager localLayoutManager = paramRecyclerView.ajX;
      if ((paramRecyclerView.afJ != null) && (localLayoutManager != null) && (localLayoutManager.isItemPrefetchEnabled()))
      {
        if (!paramBoolean) {
          break label111;
        }
        if (!paramRecyclerView.ajS.ke()) {
          localLayoutManager.collectInitialPrefetchPositions(paramRecyclerView.afJ.getItemCount(), this);
        }
      }
      for (;;)
      {
        if (this.mCount > localLayoutManager.mPrefetchMaxCountObserved)
        {
          localLayoutManager.mPrefetchMaxCountObserved = this.mCount;
          localLayoutManager.mPrefetchMaxObservedInInitialPrefetch = paramBoolean;
          paramRecyclerView.ajQ.lU();
        }
        AppMethodBeat.o(261137);
        return;
        label111:
        if (!paramRecyclerView.lG()) {
          localLayoutManager.collectAdjacentPrefetchPositions(this.ahx, this.ahy, paramRecyclerView.akL, this);
        }
      }
    }
    
    public final void ak(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(261143);
      Object localObject;
      if (paramInt1 < 0)
      {
        localObject = new IllegalArgumentException("Layout positions must be non-negative");
        AppMethodBeat.o(261143);
        throw ((Throwable)localObject);
      }
      if (paramInt2 < 0)
      {
        localObject = new IllegalArgumentException("Pixel distance must be non-negative");
        AppMethodBeat.o(261143);
        throw ((Throwable)localObject);
      }
      int i = this.mCount * 2;
      if (this.ahz == null)
      {
        this.ahz = new int[4];
        Arrays.fill(this.ahz, -1);
      }
      for (;;)
      {
        this.ahz[i] = paramInt1;
        this.ahz[(i + 1)] = paramInt2;
        this.mCount += 1;
        AppMethodBeat.o(261143);
        return;
        if (i >= this.ahz.length)
        {
          localObject = this.ahz;
          this.ahz = new int[i * 2];
          System.arraycopy(localObject, 0, this.ahz, 0, localObject.length);
        }
      }
    }
    
    final boolean cu(int paramInt)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      int j;
      int i;
      if (this.ahz != null)
      {
        j = this.mCount;
        i = 0;
      }
      for (;;)
      {
        bool1 = bool2;
        if (i < j * 2)
        {
          if (this.ahz[i] == paramInt) {
            bool1 = true;
          }
        }
        else {
          return bool1;
        }
        i += 2;
      }
    }
    
    final void kr()
    {
      AppMethodBeat.i(261147);
      if (this.ahz != null) {
        Arrays.fill(this.ahz, -1);
      }
      this.mCount = 0;
      AppMethodBeat.o(261147);
    }
  }
  
  static final class b
  {
    public boolean ahA;
    public int ahB;
    public int ahC;
    public RecyclerView ahD;
    public int position;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.recyclerview.widget.k
 * JD-Core Version:    0.7.0.1
 */