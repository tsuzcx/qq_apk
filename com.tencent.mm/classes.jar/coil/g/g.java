package coil.g;

import coil.e.i;
import coil.size.Size;
import kotlin.Metadata;
import kotlin.d.d;

@Metadata(d1={""}, d2={"Lcoil/fetch/Fetcher;", "T", "", "fetch", "Lcoil/fetch/FetchResult;", "pool", "Lcoil/bitmap/BitmapPool;", "data", "size", "Lcoil/size/Size;", "options", "Lcoil/decode/Options;", "(Lcoil/bitmap/BitmapPool;Ljava/lang/Object;Lcoil/size/Size;Lcoil/decode/Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handles", "", "(Ljava/lang/Object;)Z", "key", "", "(Ljava/lang/Object;)Ljava/lang/String;", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface g<T>
{
  public abstract Object a(T paramT, Size paramSize, i parami, d<? super f> paramd);
  
  public abstract boolean aV(T paramT);
  
  public abstract String aW(T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     coil.g.g
 * JD-Core Version:    0.7.0.1
 */