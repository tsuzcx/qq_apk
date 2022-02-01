package coil.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import coil.util.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcoil/bitmap/SizeStrategy;", "Lcoil/bitmap/BitmapPoolStrategy;", "()V", "entries", "Lcoil/collection/LinkedMultimap;", "", "Landroid/graphics/Bitmap;", "sizes", "Ljava/util/TreeMap;", "decrementSize", "", "size", "get", "width", "height", "config", "Landroid/graphics/Bitmap$Config;", "put", "bitmap", "removeLast", "stringify", "", "toString", "Companion", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  implements c
{
  public static final i.a cma;
  private final coil.c.a<Integer, Bitmap> clD;
  private final TreeMap<Integer, Integer> cmb;
  
  static
  {
    AppMethodBeat.i(188182);
    cma = new i.a((byte)0);
    AppMethodBeat.o(188182);
  }
  
  public i()
  {
    AppMethodBeat.i(188162);
    this.clD = new coil.c.a();
    this.cmb = new TreeMap();
    AppMethodBeat.o(188162);
  }
  
  private final void gO(int paramInt)
  {
    AppMethodBeat.i(188173);
    int i = ((Number)ak.e((Map)this.cmb, Integer.valueOf(paramInt))).intValue();
    if (i == 1)
    {
      ((Map)this.cmb).remove(Integer.valueOf(paramInt));
      AppMethodBeat.o(188173);
      return;
    }
    ((Map)this.cmb).put(Integer.valueOf(paramInt), Integer.valueOf(i - 1));
    AppMethodBeat.o(188173);
  }
  
  public final Bitmap ME()
  {
    AppMethodBeat.i(188220);
    Bitmap localBitmap = (Bitmap)this.clD.MJ();
    if (localBitmap != null) {
      gO(localBitmap.getAllocationByteCount());
    }
    AppMethodBeat.o(188220);
    return localBitmap;
  }
  
  public final Bitmap b(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    AppMethodBeat.i(188207);
    s.u(paramConfig, "config");
    Object localObject = m.cqA;
    int i = m.f(paramInt1, paramInt2, paramConfig);
    localObject = (Integer)this.cmb.ceilingKey(Integer.valueOf(i));
    if (localObject == null) {}
    for (;;)
    {
      localObject = (Bitmap)this.clD.aU(Integer.valueOf(i));
      if (localObject != null)
      {
        gO(i);
        ((Bitmap)localObject).reconfigure(paramInt1, paramInt2, paramConfig);
      }
      AppMethodBeat.o(188207);
      return localObject;
      int j;
      if (((Number)localObject).intValue() <= i * 4)
      {
        j = 1;
        label108:
        if (j == 0) {
          break label127;
        }
      }
      for (;;)
      {
        if (localObject != null) {
          break label133;
        }
        break;
        j = 0;
        break label108;
        label127:
        localObject = null;
      }
      label133:
      i = ((Integer)localObject).intValue();
    }
  }
  
  public final String c(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    AppMethodBeat.i(188238);
    s.u(paramConfig, "config");
    StringBuilder localStringBuilder = new StringBuilder("[");
    m localm = m.cqA;
    paramConfig = m.f(paramInt1, paramInt2, paramConfig) + ']';
    AppMethodBeat.o(188238);
    return paramConfig;
  }
  
  public final void n(Bitmap paramBitmap)
  {
    AppMethodBeat.i(188196);
    s.u(paramBitmap, "bitmap");
    int j = coil.util.a.t(paramBitmap);
    this.clD.m(Integer.valueOf(j), paramBitmap);
    paramBitmap = (Integer)this.cmb.get(Integer.valueOf(j));
    Map localMap = (Map)this.cmb;
    if (paramBitmap == null) {}
    for (int i = 1;; i = paramBitmap.intValue() + 1)
    {
      localMap.put(Integer.valueOf(j), Integer.valueOf(i));
      AppMethodBeat.o(188196);
      return;
    }
  }
  
  public final String o(Bitmap paramBitmap)
  {
    AppMethodBeat.i(188228);
    s.u(paramBitmap, "bitmap");
    paramBitmap = "[" + coil.util.a.t(paramBitmap) + ']';
    AppMethodBeat.o(188228);
    return paramBitmap;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(188247);
    String str = "SizeStrategy: entries=" + this.clD + ", sizes=" + this.cmb;
    AppMethodBeat.o(188247);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     coil.b.i
 * JD-Core Version:    0.7.0.1
 */