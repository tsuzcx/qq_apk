package com.tencent.mm.network;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.l;
import java.io.InputStream;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"runUse", "R", "T", "", "target", "asException", "block", "Lkotlin/Function1;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "use", "Lcom/tencent/mm/network/MMHttpUrlConnection;", "(Lcom/tencent/mm/network/MMHttpUrlConnection;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lcom/tencent/mm/network/MMHttpUrlCronetConnection;", "(Lcom/tencent/mm/network/MMHttpUrlCronetConnection;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lcom/tencent/mm/network/MMHttpsUrlConnection;", "(Lcom/tencent/mm/network/MMHttpsUrlConnection;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Ljava/net/URLConnection;", "(Ljava/net/URLConnection;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "mmkernel_release"})
public final class ag
{
  public static final <T, R> R a(T paramT, b<? super T, ? extends R> paramb)
  {
    AppMethodBeat.i(193521);
    try
    {
      paramb = paramb.invoke(paramT);
    }
    catch (Throwable paramb)
    {
      label29:
      AppMethodBeat.o(193521);
      throw paramb;
    }
    finally
    {
      try
      {
        InputStream localInputStream = ((x)paramT).getInputStream();
        if (localInputStream != null) {
          localInputStream.close();
        }
      }
      catch (Throwable localThrowable1)
      {
        break label68;
      }
      ((x)paramT).disconnect();
      AppMethodBeat.o(193521);
    }
    try
    {
      localInputStream = ((x)paramT).getInputStream();
      if (localInputStream != null) {
        localInputStream.close();
      }
    }
    catch (Throwable localThrowable2)
    {
      break label29;
    }
    ((x)paramT).disconnect();
    AppMethodBeat.o(193521);
    return paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.network.ag
 * JD-Core Version:    0.7.0.1
 */