package coil.h;

import coil.j.h;
import coil.j.i;
import coil.size.Size;
import kotlin.Metadata;
import kotlin.d.d;

@Metadata(d1={""}, d2={"Lcoil/intercept/Interceptor;", "", "intercept", "Lcoil/request/ImageResult;", "chain", "Lcoil/intercept/Interceptor$Chain;", "(Lcoil/intercept/Interceptor$Chain;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Chain", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface b
{
  public abstract Object a(a parama, d<? super i> paramd);
  
  @Metadata(d1={""}, d2={"Lcoil/intercept/Interceptor$Chain;", "", "request", "Lcoil/request/ImageRequest;", "getRequest", "()Lcoil/request/ImageRequest;", "size", "Lcoil/size/Size;", "getSize", "()Lcoil/size/Size;", "proceed", "Lcoil/request/ImageResult;", "(Lcoil/request/ImageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withSize", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract h MR();
    
    public abstract Size MS();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     coil.h.b
 * JD-Core Version:    0.7.0.1
 */