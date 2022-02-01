package coil.e;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import coil.size.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import j.h;
import j.q;
import j.y;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.d.d;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcoil/decode/EmptyDecoder;", "Lcoil/decode/Decoder;", "()V", "result", "Lcoil/decode/DecodeResult;", "sink", "Lokio/Sink;", "decode", "pool", "Lcoil/bitmap/BitmapPool;", "source", "Lokio/BufferedSource;", "size", "Lcoil/size/Size;", "options", "Lcoil/decode/Options;", "(Lcoil/bitmap/BitmapPool;Lokio/BufferedSource;Lcoil/size/Size;Lcoil/decode/Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handles", "", "mimeType", "", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  implements e
{
  public static final g cnl;
  private static final c cnm;
  private static final y cnn;
  
  static
  {
    AppMethodBeat.i(187834);
    cnl = new g();
    cnm = new c((Drawable)new ColorDrawable(), false);
    cnn = q.kIX();
    AppMethodBeat.o(187834);
  }
  
  public final Object a(coil.b.b paramb, h paramh, Size paramSize, i parami, d<? super c> paramd)
  {
    AppMethodBeat.i(187848);
    paramb = (Closeable)paramh;
    try
    {
      ((h)paramb).a(cnn);
      kotlin.f.b.a(paramb, null);
      paramb = cnm;
      AppMethodBeat.o(187848);
      return paramb;
    }
    finally
    {
      try
      {
        AppMethodBeat.o(187848);
        throw paramh;
      }
      finally
      {
        kotlin.f.b.a(paramb, paramh);
        AppMethodBeat.o(187848);
      }
    }
  }
  
  public final boolean a(h paramh)
  {
    AppMethodBeat.i(187839);
    s.u(paramh, "source");
    AppMethodBeat.o(187839);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     coil.e.g
 * JD-Core Version:    0.7.0.1
 */