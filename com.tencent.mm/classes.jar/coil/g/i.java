package coil.g;

import coil.size.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import okhttp3.d.a;
import okhttp3.e.a;
import okhttp3.r;

@Metadata(d1={""}, d2={"Lcoil/fetch/HttpFetcher;", "T", "", "Lcoil/fetch/Fetcher;", "callFactory", "Lokhttp3/Call$Factory;", "(Lokhttp3/Call$Factory;)V", "fetch", "Lcoil/fetch/FetchResult;", "pool", "Lcoil/bitmap/BitmapPool;", "data", "size", "Lcoil/size/Size;", "options", "Lcoil/decode/Options;", "(Lcoil/bitmap/BitmapPool;Ljava/lang/Object;Lcoil/size/Size;Lcoil/decode/Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMimeType", "", "Lokhttp3/HttpUrl;", "body", "Lokhttp3/ResponseBody;", "getMimeType$coil_base_release", "toHttpUrl", "(Ljava/lang/Object;)Lokhttp3/HttpUrl;", "Companion", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class i<T>
  implements g<T>
{
  public static final i.a cnJ = new i.a((byte)0);
  private static final okhttp3.d cnK;
  private static final okhttp3.d cnL;
  private final e.a cle;
  
  static
  {
    d.a locala = new d.a();
    locala.ajJz = true;
    locala.ajJA = true;
    cnK = locala.kGC();
    locala = new d.a();
    locala.ajJz = true;
    locala.ajJH = true;
    cnL = locala.kGC();
  }
  
  public i(e.a parama)
  {
    this.cle = parama;
  }
  
  public final Object a(T paramT, Size paramSize, coil.e.i parami, kotlin.d.d<? super f> paramd)
  {
    return a(this, paramT, parami, paramd);
  }
  
  public boolean aV(T paramT)
  {
    return g.a.a(this, paramT);
  }
  
  public abstract r aX(T paramT);
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    Object VC;
    int label;
    
    b(i<T> parami, kotlin.d.d<? super b> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(188386);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = i.a(this.cnM, null, null, (kotlin.d.d)this);
      AppMethodBeat.o(188386);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     coil.g.i
 * JD-Core Version:    0.7.0.1
 */