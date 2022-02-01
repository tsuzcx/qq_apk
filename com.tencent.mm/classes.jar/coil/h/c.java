package coil.h;

import android.graphics.Bitmap;
import coil.j.h;
import coil.j.i;
import coil.j.j;
import coil.size.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.d<-Lcoil.j.i;>;

@Metadata(d1={""}, d2={"Lcoil/intercept/RealInterceptorChain;", "Lcoil/intercept/Interceptor$Chain;", "initialRequest", "Lcoil/request/ImageRequest;", "requestType", "", "interceptors", "", "Lcoil/intercept/Interceptor;", "index", "request", "size", "Lcoil/size/Size;", "cached", "Landroid/graphics/Bitmap;", "eventListener", "Lcoil/EventListener;", "(Lcoil/request/ImageRequest;ILjava/util/List;ILcoil/request/ImageRequest;Lcoil/size/Size;Landroid/graphics/Bitmap;Lcoil/EventListener;)V", "getCached", "()Landroid/graphics/Bitmap;", "getEventListener", "()Lcoil/EventListener;", "getIndex", "()I", "getInitialRequest", "()Lcoil/request/ImageRequest;", "getInterceptors", "()Ljava/util/List;", "getRequest", "getRequestType", "getSize", "()Lcoil/size/Size;", "checkRequest", "", "interceptor", "copy", "proceed", "Lcoil/request/ImageResult;", "(Lcoil/request/ImageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withSize", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements b.a
{
  private final h cmE;
  private final h coa;
  private final Size cob;
  final Bitmap coc;
  final coil.c cod;
  private final int index;
  private final List<b> interceptors;
  final int requestType;
  
  public c(h paramh1, int paramInt1, List<? extends b> paramList, int paramInt2, h paramh2, Size paramSize, Bitmap paramBitmap, coil.c paramc)
  {
    AppMethodBeat.i(188080);
    this.coa = paramh1;
    this.requestType = paramInt1;
    this.interceptors = paramList;
    this.index = paramInt2;
    this.cmE = paramh2;
    this.cob = paramSize;
    this.coc = paramBitmap;
    this.cod = paramc;
    AppMethodBeat.o(188080);
  }
  
  private final void a(h paramh, b paramb)
  {
    int j = 1;
    AppMethodBeat.i(188090);
    if (paramh.context == this.coa.context) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramh = (Throwable)new IllegalStateException(("Interceptor '" + paramb + "' cannot modify the request's context.").toString());
      AppMethodBeat.o(188090);
      throw paramh;
    }
    if (paramh.cpt != j.cpN) {}
    for (i = 1; i == 0; i = 0)
    {
      paramh = (Throwable)new IllegalStateException(("Interceptor '" + paramb + "' cannot set the request's data to null.").toString());
      AppMethodBeat.o(188090);
      throw paramh;
    }
    if (paramh.com == this.coa.com) {}
    for (i = 1; i == 0; i = 0)
    {
      paramh = (Throwable)new IllegalStateException(("Interceptor '" + paramb + "' cannot modify the request's target.").toString());
      AppMethodBeat.o(188090);
      throw paramh;
    }
    if (paramh.lifecycle == this.coa.lifecycle) {}
    for (i = 1; i == 0; i = 0)
    {
      paramh = (Throwable)new IllegalStateException(("Interceptor '" + paramb + "' cannot modify the request's lifecycle.").toString());
      AppMethodBeat.o(188090);
      throw paramh;
    }
    if (paramh.cpp == this.coa.cpp) {}
    for (i = j; i == 0; i = 0)
    {
      paramh = (Throwable)new IllegalStateException(("Interceptor '" + paramb + "' cannot modify the request's size resolver. Use `Interceptor.Chain.withSize` instead.").toString());
      AppMethodBeat.o(188090);
      throw paramh;
    }
    AppMethodBeat.o(188090);
  }
  
  public final h MR()
  {
    return this.cmE;
  }
  
  public final Size MS()
  {
    return this.cob;
  }
  
  public final Object b(h paramh, kotlin.d.d<? super i> paramd)
  {
    AppMethodBeat.i(188118);
    if ((paramd instanceof a))
    {
      localObject1 = (a)paramd;
      if ((((a)localObject1).label & 0x80000000) != 0) {
        ((a)localObject1).label += -2147483648;
      }
    }
    a locala;
    for (paramd = (kotlin.d.d<? super i>)localObject1;; paramd = new a(this, paramd))
    {
      localObject1 = paramd.result;
      locala = a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramh = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(188118);
        throw paramh;
      }
    }
    ResultKt.throwOnFailure(localObject1);
    if (this.index > 0) {
      a(paramh, (b)this.interceptors.get(this.index - 1));
    }
    Object localObject2 = (b)this.interceptors.get(this.index);
    int i = this.index;
    Object localObject1 = this.cob;
    paramh = (b.a)new c(this.coa, this.requestType, this.interceptors, i + 1, paramh, (Size)localObject1, this.coc, this.cod);
    paramd.L$0 = this;
    paramd.Uf = localObject2;
    paramd.label = 1;
    Object localObject3 = ((b)localObject2).a(paramh, paramd);
    localObject1 = localObject3;
    paramd = (kotlin.d.d<? super i>)localObject2;
    paramh = this;
    if (localObject3 == locala)
    {
      AppMethodBeat.o(188118);
      return locala;
      paramh = (b)paramd.Uf;
      localObject2 = (c)paramd.L$0;
      ResultKt.throwOnFailure(localObject1);
      paramd = paramh;
      paramh = (h)localObject2;
    }
    localObject1 = (i)localObject1;
    paramh.a(((i)localObject1).MR(), paramd);
    AppMethodBeat.o(188118);
    return localObject1;
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    int label;
    
    a(c paramc, kotlin.d.d<? super a> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(188082);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.coe.b(null, (kotlin.d.d)this);
      AppMethodBeat.o(188082);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     coil.h.c
 * JD-Core Version:    0.7.0.1
 */