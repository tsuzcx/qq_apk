package com.tencent.mm.network;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import kotlin.g.a.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"runUse", "R", "T", "", "target", "asException", "block", "Lkotlin/Function1;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "use", "Lcom/tencent/mm/network/MMHttpUrlConnection;", "(Lcom/tencent/mm/network/MMHttpUrlConnection;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lcom/tencent/mm/network/MMHttpUrlCronetConnection;", "(Lcom/tencent/mm/network/MMHttpUrlCronetConnection;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lcom/tencent/mm/network/MMHttpsUrlConnection;", "(Lcom/tencent/mm/network/MMHttpsUrlConnection;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Ljava/net/URLConnection;", "(Ljava/net/URLConnection;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "mmkernel_release"})
public final class ai
{
  public static final <T, R> R a(T paramT, b<? super T, ? extends R> paramb)
  {
    AppMethodBeat.i(197251);
    try
    {
      paramb = paramb.invoke(paramT);
    }
    catch (Throwable paramb)
    {
      label29:
      AppMethodBeat.o(197251);
      throw paramb;
    }
    finally
    {
      try
      {
        InputStream localInputStream = ((z)paramT).getInputStream();
        if (localInputStream != null) {
          localInputStream.close();
        }
      }
      catch (Throwable localThrowable1)
      {
        break label68;
      }
      ((z)paramT).disconnect();
      AppMethodBeat.o(197251);
    }
    try
    {
      localInputStream = ((z)paramT).getInputStream();
      if (localInputStream != null) {
        localInputStream.close();
      }
    }
    catch (Throwable localThrowable2)
    {
      break label29;
    }
    ((z)paramT).disconnect();
    AppMethodBeat.o(197251);
    return paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.network.ai
 * JD-Core Version:    0.7.0.1
 */