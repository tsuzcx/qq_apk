package coil.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import coil.util.a;
import coil.util.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.a.d;
import kotlin.a.a.h;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcoil/bitmap/RealBitmapPool;", "Lcoil/bitmap/BitmapPool;", "maxSize", "", "allowedConfigs", "", "Landroid/graphics/Bitmap$Config;", "strategy", "Lcoil/bitmap/BitmapPoolStrategy;", "logger", "Lcoil/util/Logger;", "(ILjava/util/Set;Lcoil/bitmap/BitmapPoolStrategy;Lcoil/util/Logger;)V", "bitmaps", "Ljava/util/HashSet;", "Landroid/graphics/Bitmap;", "Lkotlin/collections/HashSet;", "currentSize", "evictions", "hits", "misses", "puts", "clear", "", "clearMemory", "get", "width", "height", "config", "getDirty", "getDirtyOrNull", "getOrNull", "logStats", "", "normalize", "bitmap", "put", "trimMemory", "level", "trimToSize", "size", "Companion", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  implements b
{
  public static final g.a clK;
  private static final Set<Bitmap.Config> clS;
  private int bgg;
  private final Set<Bitmap.Config> clL;
  private final c clM;
  private final HashSet<Bitmap> clN;
  private int clO;
  private int clP;
  private int clQ;
  private int clR;
  private final k cli;
  private final int maxSize;
  
  static
  {
    AppMethodBeat.i(188215);
    clK = new g.a((byte)0);
    Object localObject = (Set)new h();
    ((Set)localObject).add(Bitmap.Config.ALPHA_8);
    ((Set)localObject).add(Bitmap.Config.RGB_565);
    ((Set)localObject).add(Bitmap.Config.ARGB_4444);
    ((Set)localObject).add(Bitmap.Config.ARGB_8888);
    if (Build.VERSION.SDK_INT >= 26) {
      ((Set)localObject).add(Bitmap.Config.RGBA_F16);
    }
    s.u(localObject, "builder");
    localObject = (h)localObject;
    ((h)localObject).aivT.klb();
    clS = (Set)localObject;
    AppMethodBeat.o(188215);
  }
  
  private g(int paramInt, Set<? extends Bitmap.Config> paramSet, c paramc, k paramk)
  {
    AppMethodBeat.i(188160);
    this.maxSize = paramInt;
    this.clL = paramSet;
    this.clM = paramc;
    this.cli = paramk;
    this.clN = new HashSet();
    if (this.maxSize >= 0) {}
    for (paramInt = 1; paramInt == 0; paramInt = 0)
    {
      paramSet = (Throwable)new IllegalArgumentException("maxSize must be >= 0.".toString());
      AppMethodBeat.o(188160);
      throw paramSet;
    }
    AppMethodBeat.o(188160);
  }
  
  private final String MG()
  {
    AppMethodBeat.i(188203);
    String str = "Hits=" + this.clO + ", misses=" + this.clP + ", puts=" + this.clQ + ", evictions=" + this.clR + ", currentSize=" + this.bgg + ", maxSize=" + this.maxSize + ", strategy=" + this.clM;
    AppMethodBeat.o(188203);
    return str;
  }
  
  private Bitmap e(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    int i = 1;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(188181);
        s.u(paramConfig, "config");
        if (!a.b(paramConfig))
        {
          if (i != 0) {
            break;
          }
          paramConfig = (Throwable)new IllegalArgumentException("Cannot create a mutable hardware bitmap.".toString());
          AppMethodBeat.o(188181);
          throw paramConfig;
        }
      }
      finally {}
      i = 0;
    }
    Bitmap localBitmap = this.clM.b(paramInt1, paramInt2, paramConfig);
    k localk;
    if (localBitmap == null)
    {
      localk = this.cli;
      if ((localk != null) && (localk.getLevel() <= 2)) {
        s.X("Missing bitmap=", this.clM.c(paramInt1, paramInt2, paramConfig));
      }
      this.clP += 1;
    }
    for (;;)
    {
      localk = this.cli;
      if ((localk != null) && (localk.getLevel() <= 2)) {
        new StringBuilder("Get bitmap=").append(this.clM.c(paramInt1, paramInt2, paramConfig)).append('\n').append(MG());
      }
      AppMethodBeat.o(188181);
      return localBitmap;
      ((Collection)this.clN).remove(localBitmap);
      this.bgg -= a.t(localBitmap);
      this.clO += 1;
      localBitmap.setDensity(0);
      localBitmap.setHasAlpha(true);
      if (Build.VERSION.SDK_INT >= 19) {
        localBitmap.setPremultiplied(true);
      }
    }
  }
  
  private final void trimToSize(int paramInt)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(188194);
        if (this.bgg > paramInt)
        {
          Object localObject1 = this.clM.ME();
          if (localObject1 == null)
          {
            localObject1 = this.cli;
            if ((localObject1 != null) && (((k)localObject1).getLevel() <= 5)) {
              s.X("Size mismatch, resetting.\n", MG());
            }
            this.bgg = 0;
            AppMethodBeat.o(188194);
            return;
          }
          ((Collection)this.clN).remove(localObject1);
          this.bgg -= a.t((Bitmap)localObject1);
          this.clR += 1;
          k localk = this.cli;
          if ((localk != null) && (localk.getLevel() <= 2)) {
            new StringBuilder("Evicting bitmap=").append(this.clM.o((Bitmap)localObject1)).append('\n').append(MG());
          }
          ((Bitmap)localObject1).recycle();
        }
        else
        {
          AppMethodBeat.o(188194);
        }
      }
      finally {}
    }
  }
  
  public final Bitmap b(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    AppMethodBeat.i(188241);
    s.u(paramConfig, "config");
    s.u(paramConfig, "config");
    Bitmap localBitmap = e(paramInt1, paramInt2, paramConfig);
    if (localBitmap == null) {
      localBitmap = null;
    }
    while (localBitmap == null)
    {
      paramConfig = Bitmap.createBitmap(paramInt1, paramInt2, paramConfig);
      s.s(paramConfig, "createBitmap(width, height, config)");
      AppMethodBeat.o(188241);
      return paramConfig;
      localBitmap.eraseColor(0);
    }
    AppMethodBeat.o(188241);
    return localBitmap;
  }
  
  public final Bitmap d(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    AppMethodBeat.i(188249);
    s.u(paramConfig, "config");
    Bitmap localBitmap = e(paramInt1, paramInt2, paramConfig);
    if (localBitmap == null)
    {
      paramConfig = Bitmap.createBitmap(paramInt1, paramInt2, paramConfig);
      s.s(paramConfig, "createBitmap(width, height, config)");
      AppMethodBeat.o(188249);
      return paramConfig;
    }
    AppMethodBeat.o(188249);
    return localBitmap;
  }
  
  public final void n(Bitmap paramBitmap)
  {
    for (;;)
    {
      Object localObject;
      int i;
      try
      {
        AppMethodBeat.i(188230);
        s.u(paramBitmap, "bitmap");
        if (paramBitmap.isRecycled())
        {
          localObject = this.cli;
          if ((localObject != null) && (((k)localObject).getLevel() <= 6)) {
            s.X("Rejecting recycled bitmap from pool; bitmap: ", paramBitmap);
          }
          AppMethodBeat.o(188230);
          return;
        }
        i = a.t(paramBitmap);
        if ((paramBitmap.isMutable()) && (i <= this.maxSize) && (this.clL.contains(paramBitmap.getConfig()))) {
          break label226;
        }
        localObject = this.cli;
        if ((localObject != null) && (((k)localObject).getLevel() <= 2))
        {
          localObject = new StringBuilder("Rejecting bitmap from pool; bitmap: ").append(this.clM.o(paramBitmap)).append(", is mutable: ").append(paramBitmap.isMutable()).append(", is greater than max size: ");
          if (i > this.maxSize)
          {
            bool = true;
            ((StringBuilder)localObject).append(bool).append(", is allowed config: ").append(this.clL.contains(paramBitmap.getConfig()));
          }
        }
        else
        {
          paramBitmap.recycle();
          AppMethodBeat.o(188230);
          continue;
        }
        boolean bool = false;
      }
      finally {}
      continue;
      label226:
      if (this.clN.contains(paramBitmap))
      {
        localObject = this.cli;
        if ((localObject != null) && (((k)localObject).getLevel() <= 6)) {
          s.X("Rejecting duplicate bitmap from pool; bitmap: ", this.clM.o(paramBitmap));
        }
        AppMethodBeat.o(188230);
      }
      else
      {
        this.clM.n(paramBitmap);
        ((Collection)this.clN).add(paramBitmap);
        this.bgg += i;
        this.clQ += 1;
        localObject = this.cli;
        if ((localObject != null) && (((k)localObject).getLevel() <= 2)) {
          new StringBuilder("Put bitmap=").append(this.clM.o(paramBitmap)).append('\n').append(MG());
        }
        trimToSize(this.maxSize);
        AppMethodBeat.o(188230);
      }
    }
  }
  
  /* Error */
  public final void trimMemory(int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc_w 366
    //   7: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_0
    //   11: getfield 175	coil/b/g:cli	Lcoil/util/k;
    //   14: astore 4
    //   16: aload 4
    //   18: ifnull +25 -> 43
    //   21: aload 4
    //   23: invokeinterface 255 1 0
    //   28: iconst_2
    //   29: if_icmpgt +14 -> 43
    //   32: ldc_w 368
    //   35: iload_1
    //   36: invokestatic 374	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   39: invokestatic 265	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   42: pop
    //   43: iload_1
    //   44: bipush 40
    //   46: if_icmplt +17 -> 63
    //   49: aload_0
    //   50: iconst_m1
    //   51: invokespecial 365	coil/b/g:trimToSize	(I)V
    //   54: ldc_w 366
    //   57: invokestatic 145	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   60: aload_0
    //   61: monitorexit
    //   62: return
    //   63: iload_3
    //   64: istore_2
    //   65: bipush 10
    //   67: iload_1
    //   68: if_icmpgt +13 -> 81
    //   71: iload_3
    //   72: istore_2
    //   73: iload_1
    //   74: bipush 20
    //   76: if_icmpge +5 -> 81
    //   79: iconst_1
    //   80: istore_2
    //   81: iload_2
    //   82: ifeq +13 -> 95
    //   85: aload_0
    //   86: aload_0
    //   87: getfield 227	coil/b/g:bgg	I
    //   90: iconst_2
    //   91: idiv
    //   92: invokespecial 365	coil/b/g:trimToSize	(I)V
    //   95: ldc_w 366
    //   98: invokestatic 145	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   101: goto -41 -> 60
    //   104: astore 4
    //   106: aload_0
    //   107: monitorexit
    //   108: aload 4
    //   110: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	this	g
    //   0	111	1	paramInt	int
    //   64	18	2	i	int
    //   1	71	3	j	int
    //   14	8	4	localk	k
    //   104	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	16	104	finally
    //   21	43	104	finally
    //   49	60	104	finally
    //   85	95	104	finally
    //   95	101	104	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     coil.b.g
 * JD-Core Version:    0.7.0.1
 */