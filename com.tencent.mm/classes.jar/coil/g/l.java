package coil.g;

import android.content.Context;
import android.net.Uri;
import coil.e.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcoil/fetch/ResourceUriFetcher;", "Lcoil/fetch/Fetcher;", "Landroid/net/Uri;", "context", "Landroid/content/Context;", "drawableDecoder", "Lcoil/decode/DrawableDecoderService;", "(Landroid/content/Context;Lcoil/decode/DrawableDecoderService;)V", "fetch", "Lcoil/fetch/FetchResult;", "pool", "Lcoil/bitmap/BitmapPool;", "data", "size", "Lcoil/size/Size;", "options", "Lcoil/decode/Options;", "(Lcoil/bitmap/BitmapPool;Landroid/net/Uri;Lcoil/size/Size;Lcoil/decode/Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handles", "", "key", "", "throwInvalidUriException", "", "Companion", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  implements g<Uri>
{
  public static final l.a cnN;
  private final f clv;
  private final Context context;
  
  static
  {
    AppMethodBeat.i(188353);
    cnN = new l.a((byte)0);
    AppMethodBeat.o(188353);
  }
  
  public l(Context paramContext, f paramf)
  {
    AppMethodBeat.i(188332);
    this.context = paramContext;
    this.clv = paramf;
    AppMethodBeat.o(188332);
  }
  
  private static Void f(Uri paramUri)
  {
    AppMethodBeat.i(188345);
    paramUri = new IllegalStateException(s.X("Invalid android.resource URI: ", paramUri));
    AppMethodBeat.o(188345);
    throw paramUri;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     coil.g.l
 * JD-Core Version:    0.7.0.1
 */