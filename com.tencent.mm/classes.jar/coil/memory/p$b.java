package coil.memory;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcoil/memory/RealWeakMemoryCache$StrongValue;", "Lcoil/memory/RealMemoryCache$Value;", "bitmap", "Landroid/graphics/Bitmap;", "isSampled", "", "(Landroid/graphics/Bitmap;Z)V", "getBitmap", "()Landroid/graphics/Bitmap;", "()Z", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
final class p$b
  implements n.a
{
  private final Bitmap bitmap;
  private final boolean cmZ;
  
  public p$b(Bitmap paramBitmap, boolean paramBoolean)
  {
    AppMethodBeat.i(188251);
    this.bitmap = paramBitmap;
    this.cmZ = paramBoolean;
    AppMethodBeat.o(188251);
  }
  
  public final boolean MU()
  {
    return this.cmZ;
  }
  
  public final Bitmap getBitmap()
  {
    return this.bitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     coil.memory.p.b
 * JD-Core Version:    0.7.0.1
 */