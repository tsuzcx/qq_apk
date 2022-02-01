package com.tencent.mm.network;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.g.a.b;

@Metadata(d1={""}, d2={"runUse", "R", "T", "", "target", "asException", "block", "Lkotlin/Function1;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "use", "Lcom/tencent/mm/network/MMHttpUrlConnection;", "(Lcom/tencent/mm/network/MMHttpUrlConnection;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lcom/tencent/mm/network/MMHttpUrlCronetConnection;", "(Lcom/tencent/mm/network/MMHttpUrlCronetConnection;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lcom/tencent/mm/network/MMHttpsUrlConnection;", "(Lcom/tencent/mm/network/MMHttpsUrlConnection;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Ljava/net/URLConnection;", "(Ljava/net/URLConnection;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "mmkernel_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class aj
{
  public static final <T, R> R a(T paramT, b<? super T, ? extends R> paramb)
  {
    AppMethodBeat.i(241108);
    try
    {
      paramb = paramb.invoke(paramT);
    }
    finally
    {
      try
      {
        label29:
        AppMethodBeat.o(241108);
        throw paramb;
      }
      finally
      {
        try
        {
          paramT = ((aa)paramT).getInputStream();
          if (paramT != null) {
            paramT.close();
          }
        }
        finally
        {
          break label61;
        }
        AppMethodBeat.o(241108);
      }
    }
    try
    {
      paramT = ((aa)paramT).getInputStream();
      if (paramT != null) {
        paramT.close();
      }
    }
    finally
    {
      break label29;
    }
    AppMethodBeat.o(241108);
    return paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.network.aj
 * JD-Core Version:    0.7.0.1
 */