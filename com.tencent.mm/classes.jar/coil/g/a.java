package coil.g;

import android.content.Context;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcoil/fetch/AssetUriFetcher;", "Lcoil/fetch/Fetcher;", "Landroid/net/Uri;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "fetch", "Lcoil/fetch/FetchResult;", "pool", "Lcoil/bitmap/BitmapPool;", "data", "size", "Lcoil/size/Size;", "options", "Lcoil/decode/Options;", "(Lcoil/bitmap/BitmapPool;Landroid/net/Uri;Lcoil/size/Size;Lcoil/decode/Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handles", "", "key", "", "Companion", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements g<Uri>
{
  public static final a.a cnG;
  private final Context context;
  
  static
  {
    AppMethodBeat.i(188364);
    cnG = new a.a((byte)0);
    AppMethodBeat.o(188364);
  }
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(188351);
    this.context = paramContext;
    AppMethodBeat.o(188351);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     coil.g.a
 * JD-Core Version:    0.7.0.1
 */