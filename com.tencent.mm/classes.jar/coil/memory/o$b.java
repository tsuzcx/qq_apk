package coil.memory;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcoil/memory/RealStrongMemoryCache$InternalValue;", "Lcoil/memory/RealMemoryCache$Value;", "bitmap", "Landroid/graphics/Bitmap;", "isSampled", "", "size", "", "(Landroid/graphics/Bitmap;ZI)V", "getBitmap", "()Landroid/graphics/Bitmap;", "()Z", "getSize", "()I", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
final class o$b
  implements n.a
{
  final Bitmap bitmap;
  final boolean cmZ;
  final int size;
  
  public o$b(Bitmap paramBitmap, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(188310);
    this.bitmap = paramBitmap;
    this.cmZ = paramBoolean;
    this.size = paramInt;
    AppMethodBeat.o(188310);
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
 * Qualified Name:     coil.memory.o.b
 * JD-Core Version:    0.7.0.1
 */