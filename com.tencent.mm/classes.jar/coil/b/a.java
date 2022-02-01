package coil.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcoil/bitmap/AttributeStrategy;", "Lcoil/bitmap/BitmapPoolStrategy;", "()V", "entries", "Lcoil/collection/LinkedMultimap;", "Lcoil/bitmap/AttributeStrategy$Key;", "Landroid/graphics/Bitmap;", "get", "width", "", "height", "config", "Landroid/graphics/Bitmap$Config;", "put", "", "bitmap", "removeLast", "stringify", "", "toString", "Key", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements c
{
  private final coil.c.a<a.a, Bitmap> clD;
  
  public a()
  {
    AppMethodBeat.i(188143);
    this.clD = new coil.c.a();
    AppMethodBeat.o(188143);
  }
  
  public final Bitmap ME()
  {
    AppMethodBeat.i(188166);
    Bitmap localBitmap = (Bitmap)this.clD.MJ();
    AppMethodBeat.o(188166);
    return localBitmap;
  }
  
  public final Bitmap b(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    AppMethodBeat.i(188159);
    s.u(paramConfig, "config");
    paramConfig = (Bitmap)this.clD.aU(new a.a(paramInt1, paramInt2, paramConfig));
    AppMethodBeat.o(188159);
    return paramConfig;
  }
  
  public final String c(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    AppMethodBeat.i(188184);
    s.u(paramConfig, "config");
    paramConfig = "[" + paramInt1 + " x " + paramInt2 + "], " + paramConfig;
    AppMethodBeat.o(188184);
    return paramConfig;
  }
  
  public final void n(Bitmap paramBitmap)
  {
    AppMethodBeat.i(188152);
    s.u(paramBitmap, "bitmap");
    coil.c.a locala = this.clD;
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    Bitmap.Config localConfig = paramBitmap.getConfig();
    s.s(localConfig, "bitmap.config");
    locala.m(new a.a(i, j, localConfig), paramBitmap);
    AppMethodBeat.o(188152);
  }
  
  public final String o(Bitmap paramBitmap)
  {
    AppMethodBeat.i(188174);
    s.u(paramBitmap, "bitmap");
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    paramBitmap = paramBitmap.getConfig();
    s.s(paramBitmap, "bitmap.config");
    paramBitmap = c(i, j, paramBitmap);
    AppMethodBeat.o(188174);
    return paramBitmap;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(188195);
    String str = s.X("AttributeStrategy: entries=", this.clD);
    AppMethodBeat.o(188195);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     coil.b.a
 * JD-Core Version:    0.7.0.1
 */