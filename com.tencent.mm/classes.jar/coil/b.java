package coil;

import coil.e.e;
import coil.g.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.r;
import kotlin.v;

@Metadata(d1={""}, d2={"Lcoil/ComponentRegistry;", "", "()V", "interceptors", "", "Lcoil/intercept/Interceptor;", "mappers", "Lkotlin/Pair;", "Lcoil/map/Mapper;", "Ljava/lang/Class;", "Lcoil/util/MultiList;", "fetchers", "Lcoil/fetch/Fetcher;", "decoders", "Lcoil/decode/Decoder;", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getDecoders$coil_base_release", "()Ljava/util/List;", "getFetchers$coil_base_release", "getInterceptors$coil_base_release", "getMappers$coil_base_release", "newBuilder", "Lcoil/ComponentRegistry$Builder;", "Builder", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public final List<r<g<? extends Object>, Class<? extends Object>>> ckU;
  public final List<e> ckV;
  final List<coil.h.b> interceptors;
  public final List<r<coil.i.b<? extends Object, ?>, Class<? extends Object>>> mappers;
  
  public b()
  {
    this((List)ab.aivy, (List)ab.aivy, (List)ab.aivy, (List)ab.aivy);
    AppMethodBeat.i(188058);
    AppMethodBeat.o(188058);
  }
  
  private b(List<? extends coil.h.b> paramList, List<? extends r<? extends coil.i.b<? extends Object, ?>, ? extends Class<? extends Object>>> paramList1, List<? extends r<? extends g<? extends Object>, ? extends Class<? extends Object>>> paramList2, List<? extends e> paramList3)
  {
    this.interceptors = paramList;
    this.mappers = paramList1;
    this.ckU = paramList2;
    this.ckV = paramList3;
  }
  
  @Metadata(d1={""}, d2={"Lcoil/ComponentRegistry$Builder;", "", "()V", "registry", "Lcoil/ComponentRegistry;", "(Lcoil/ComponentRegistry;)V", "decoders", "", "Lcoil/decode/Decoder;", "fetchers", "Lkotlin/Pair;", "Lcoil/fetch/Fetcher;", "Ljava/lang/Class;", "Lcoil/util/MultiMutableList;", "interceptors", "Lcoil/intercept/Interceptor;", "mappers", "Lcoil/map/Mapper;", "add", "decoder", "T", "fetcher", "type", "interceptor", "mapper", "build", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private final List<r<g<? extends Object>, Class<? extends Object>>> ckU;
    private final List<e> ckV;
    private final List<coil.h.b> interceptors;
    private final List<r<coil.i.b<? extends Object, ?>, Class<? extends Object>>> mappers;
    
    public a()
    {
      AppMethodBeat.i(188065);
      this.interceptors = ((List)new ArrayList());
      this.mappers = ((List)new ArrayList());
      this.ckU = ((List)new ArrayList());
      this.ckV = ((List)new ArrayList());
      AppMethodBeat.o(188065);
    }
    
    public a(b paramb)
    {
      AppMethodBeat.i(188076);
      this.interceptors = p.J((Collection)paramb.interceptors);
      this.mappers = p.J((Collection)paramb.mappers);
      this.ckU = p.J((Collection)paramb.ckU);
      this.ckV = p.J((Collection)paramb.ckV);
      AppMethodBeat.o(188076);
    }
    
    public final b MA()
    {
      AppMethodBeat.i(188113);
      b localb = new b(p.p((Iterable)this.interceptors), p.p((Iterable)this.mappers), p.p((Iterable)this.ckU), p.p((Iterable)this.ckV), (byte)0);
      AppMethodBeat.o(188113);
      return localb;
    }
    
    public final a a(e parame)
    {
      AppMethodBeat.i(188103);
      s.u(parame, "decoder");
      ((Collection)((a)this).ckV).add(parame);
      parame = (a)this;
      AppMethodBeat.o(188103);
      return parame;
    }
    
    public final <T> a a(g<T> paramg, Class<T> paramClass)
    {
      AppMethodBeat.i(188093);
      s.u(paramg, "fetcher");
      s.u(paramClass, "type");
      ((Collection)((a)this).ckU).add(v.Y(paramg, paramClass));
      paramg = (a)this;
      AppMethodBeat.o(188093);
      return paramg;
    }
    
    public final <T> a a(coil.i.b<T, ?> paramb, Class<T> paramClass)
    {
      AppMethodBeat.i(188087);
      s.u(paramb, "mapper");
      s.u(paramClass, "type");
      ((Collection)((a)this).mappers).add(v.Y(paramb, paramClass));
      paramb = (a)this;
      AppMethodBeat.o(188087);
      return paramb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     coil.b
 * JD-Core Version:    0.7.0.1
 */