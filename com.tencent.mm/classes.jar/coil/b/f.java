package coil.b;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcoil/bitmap/EmptyBitmapReferenceCounter;", "Lcoil/bitmap/BitmapReferenceCounter;", "()V", "decrement", "", "bitmap", "Landroid/graphics/Bitmap;", "increment", "", "setValid", "isValid", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  implements d
{
  public static final f clJ;
  
  static
  {
    AppMethodBeat.i(188165);
    clJ = new f();
    AppMethodBeat.o(188165);
  }
  
  public final void a(Bitmap paramBitmap, boolean paramBoolean)
  {
    AppMethodBeat.i(188199);
    s.u(paramBitmap, "bitmap");
    AppMethodBeat.o(188199);
  }
  
  public final void p(Bitmap paramBitmap)
  {
    AppMethodBeat.i(188175);
    s.u(paramBitmap, "bitmap");
    AppMethodBeat.o(188175);
  }
  
  public final boolean q(Bitmap paramBitmap)
  {
    AppMethodBeat.i(188186);
    s.u(paramBitmap, "bitmap");
    AppMethodBeat.o(188186);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     coil.b.f
 * JD-Core Version:    0.7.0.1
 */