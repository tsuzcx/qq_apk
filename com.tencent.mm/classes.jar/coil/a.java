package coil;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcoil/Coil;", "", "()V", "imageLoader", "Lcoil/ImageLoader;", "imageLoaderFactory", "Lcoil/ImageLoaderFactory;", "enqueue", "Lcoil/request/Disposable;", "request", "Lcoil/request/ImageRequest;", "execute", "Lcoil/request/ImageResult;", "(Lcoil/request/ImageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "context", "Landroid/content/Context;", "newImageLoader", "reset", "", "reset$coil_singleton_release", "setImageLoader", "factory", "coil-singleton_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a ckR;
  private static d ckS;
  private static e ckT;
  
  static
  {
    AppMethodBeat.i(187980);
    ckR = new a();
    AppMethodBeat.o(187980);
  }
  
  public static final void a(d paramd)
  {
    try
    {
      AppMethodBeat.i(187964);
      s.u(paramd, "imageLoader");
      ckT = null;
      ckS = paramd;
      AppMethodBeat.o(187964);
      return;
    }
    finally
    {
      paramd = finally;
      throw paramd;
    }
  }
  
  public static final d aw(Context paramContext)
  {
    AppMethodBeat.i(187958);
    s.u(paramContext, "context");
    d locald = ckS;
    if (locald == null)
    {
      paramContext = ckR.ax(paramContext);
      AppMethodBeat.o(187958);
      return paramContext;
    }
    AppMethodBeat.o(187958);
    return locald;
  }
  
  private final d ax(Context paramContext)
  {
    Object localObject;
    d locald;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(187973);
        localObject = ckS;
        if (localObject != null)
        {
          AppMethodBeat.o(187973);
          return localObject;
        }
        localObject = ckT;
        if (localObject == null)
        {
          locald = null;
          localObject = locald;
          if (locald == null)
          {
            localObject = paramContext.getApplicationContext();
            if (!(localObject instanceof e)) {
              break label125;
            }
            localObject = (e)localObject;
            break;
            localObject = locald;
            if (locald == null)
            {
              localObject = d.clc;
              localObject = d.b.ay(paramContext);
            }
          }
          ckT = null;
          ckS = (d)localObject;
          AppMethodBeat.o(187973);
        }
        else
        {
          locald = ((e)localObject).MD();
        }
      }
      finally {}
    }
    label128:
    for (;;)
    {
      locald = ((e)localObject).MD();
      break;
      for (;;)
      {
        if (localObject != null) {
          break label128;
        }
        locald = null;
        break;
        label125:
        localObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     coil.a
 * JD-Core Version:    0.7.0.1
 */