package coil;

import android.graphics.Bitmap;
import coil.e.e;
import coil.e.i;
import coil.g.f;
import coil.g.g;
import coil.j.h;
import coil.j.h.b;
import coil.j.i.a;
import coil.size.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcoil/EventListener;", "Lcoil/request/ImageRequest$Listener;", "decodeEnd", "", "request", "Lcoil/request/ImageRequest;", "decoder", "Lcoil/decode/Decoder;", "options", "Lcoil/decode/Options;", "result", "Lcoil/decode/DecodeResult;", "decodeStart", "fetchEnd", "fetcher", "Lcoil/fetch/Fetcher;", "Lcoil/fetch/FetchResult;", "fetchStart", "mapEnd", "output", "", "mapStart", "input", "onCancel", "onError", "throwable", "", "onStart", "onSuccess", "metadata", "Lcoil/request/ImageResult$Metadata;", "resolveSizeEnd", "size", "Lcoil/size/Size;", "resolveSizeStart", "transformEnd", "Landroid/graphics/Bitmap;", "transformStart", "transitionEnd", "transitionStart", "Companion", "Factory", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface c
  extends h.b
{
  public static final c.a ckW = c.a.ckY;
  public static final c ckX = (c)new b();
  
  public abstract void a(h paramh);
  
  public abstract void a(h paramh, Bitmap paramBitmap);
  
  public abstract void a(h paramh, e parame, i parami);
  
  public abstract void a(h paramh, e parame, i parami, coil.e.c paramc);
  
  public abstract void a(h paramh, g<?> paramg, i parami);
  
  public abstract void a(h paramh, g<?> paramg, i parami, f paramf);
  
  public abstract void a(h paramh, i.a parama);
  
  public abstract void a(h paramh, Size paramSize);
  
  public abstract void a(h paramh, Object paramObject);
  
  public abstract void a(h paramh, Throwable paramThrowable);
  
  public abstract void b(h paramh);
  
  public abstract void b(h paramh, Bitmap paramBitmap);
  
  public abstract void b(h paramh, Object paramObject);
  
  public abstract void c(h paramh);
  
  public abstract void d(h paramh);
  
  public abstract void e(h paramh);
  
  @Metadata(d1={""}, d2={"coil/EventListener$Companion$NONE$1", "Lcoil/EventListener;", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements c
  {
    public final void a(h paramh)
    {
      AppMethodBeat.i(187835);
      s.u(this, "this");
      s.u(paramh, "request");
      AppMethodBeat.o(187835);
    }
    
    public final void a(h paramh, Bitmap paramBitmap)
    {
      AppMethodBeat.i(187934);
      s.u(this, "this");
      s.u(paramh, "request");
      s.u(paramBitmap, "input");
      AppMethodBeat.o(187934);
    }
    
    public final void a(h paramh, e parame, i parami)
    {
      AppMethodBeat.i(187895);
      s.u(this, "this");
      s.u(paramh, "request");
      s.u(parame, "decoder");
      s.u(parami, "options");
      AppMethodBeat.o(187895);
    }
    
    public final void a(h paramh, e parame, i parami, coil.e.c paramc)
    {
      AppMethodBeat.i(187888);
      s.u(this, "this");
      s.u(paramh, "request");
      s.u(parame, "decoder");
      s.u(parami, "options");
      s.u(paramc, "result");
      AppMethodBeat.o(187888);
    }
    
    public final void a(h paramh, g<?> paramg, i parami)
    {
      AppMethodBeat.i(187911);
      s.u(this, "this");
      s.u(paramh, "request");
      s.u(paramg, "fetcher");
      s.u(parami, "options");
      AppMethodBeat.o(187911);
    }
    
    public final void a(h paramh, g<?> paramg, i parami, f paramf)
    {
      AppMethodBeat.i(187902);
      s.u(this, "this");
      s.u(paramh, "request");
      s.u(paramg, "fetcher");
      s.u(parami, "options");
      s.u(paramf, "result");
      AppMethodBeat.o(187902);
    }
    
    public final void a(h paramh, i.a parama)
    {
      AppMethodBeat.i(187842);
      s.u(this, "this");
      s.u(paramh, "request");
      s.u(parama, "metadata");
      AppMethodBeat.o(187842);
    }
    
    public final void a(h paramh, Size paramSize)
    {
      AppMethodBeat.i(187849);
      s.u(this, "this");
      s.u(paramh, "request");
      s.u(paramSize, "size");
      AppMethodBeat.o(187849);
    }
    
    public final void a(h paramh, Object paramObject)
    {
      AppMethodBeat.i(187813);
      s.u(this, "this");
      s.u(paramh, "request");
      s.u(paramObject, "input");
      AppMethodBeat.o(187813);
    }
    
    public final void a(h paramh, Throwable paramThrowable)
    {
      AppMethodBeat.i(187828);
      s.u(this, "this");
      s.u(paramh, "request");
      s.u(paramThrowable, "throwable");
      AppMethodBeat.o(187828);
    }
    
    public final void b(h paramh)
    {
      AppMethodBeat.i(187859);
      s.u(this, "this");
      s.u(paramh, "request");
      AppMethodBeat.o(187859);
    }
    
    public final void b(h paramh, Bitmap paramBitmap)
    {
      AppMethodBeat.i(187920);
      s.u(this, "this");
      s.u(paramh, "request");
      s.u(paramBitmap, "output");
      AppMethodBeat.o(187920);
    }
    
    public final void b(h paramh, Object paramObject)
    {
      AppMethodBeat.i(187805);
      s.u(this, "this");
      s.u(paramh, "request");
      s.u(paramObject, "output");
      AppMethodBeat.o(187805);
    }
    
    public final void c(h paramh)
    {
      AppMethodBeat.i(187878);
      s.u(this, "this");
      s.u(paramh, "request");
      AppMethodBeat.o(187878);
    }
    
    public final void d(h paramh)
    {
      AppMethodBeat.i(187868);
      s.u(this, "this");
      s.u(paramh, "request");
      AppMethodBeat.o(187868);
    }
    
    public final void e(h paramh)
    {
      AppMethodBeat.i(187822);
      s.u(this, "this");
      s.u(paramh, "request");
      AppMethodBeat.o(187822);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcoil/EventListener$Factory;", "", "create", "Lcoil/EventListener;", "request", "Lcoil/request/ImageRequest;", "Companion", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface c
  {
    public static final a ckZ = a.clb;
    public static final c cla = a.a(c.ckX);
    
    public abstract c create(h paramh);
    
    @Metadata(d1={""}, d2={"Lcoil/EventListener$Factory$Companion;", "", "()V", "NONE", "Lcoil/EventListener$Factory;", "invoke", "listener", "Lcoil/EventListener;", "create", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
    {
      static
      {
        AppMethodBeat.i(187892);
        clb = new a();
        AppMethodBeat.o(187892);
      }
      
      public static c.c a(c paramc)
      {
        AppMethodBeat.i(187876);
        s.u(paramc, "listener");
        paramc = new c.c.a..ExternalSyntheticLambda0(paramc);
        AppMethodBeat.o(187876);
        return paramc;
      }
      
      private static final c a(c paramc, h paramh)
      {
        AppMethodBeat.i(187886);
        s.u(paramc, "$listener");
        s.u(paramh, "it");
        AppMethodBeat.o(187886);
        return paramc;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     coil.c
 * JD-Core Version:    0.7.0.1
 */