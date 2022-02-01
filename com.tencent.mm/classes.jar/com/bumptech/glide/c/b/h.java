package com.bumptech.glide.c.b;

import android.support.v4.e.l.a;
import android.util.Log;
import com.bumptech.glide.c.j;
import com.bumptech.glide.c.k;
import com.bumptech.glide.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class h<DataType, ResourceType, Transcode>
{
  private final Class<DataType> aHc;
  private final List<? extends k<DataType, ResourceType>> aHd;
  final com.bumptech.glide.c.d.f.e<ResourceType, Transcode> aHe;
  private final l.a<List<Throwable>> aHf;
  private final String aHg;
  
  public h(Class<DataType> paramClass, Class<ResourceType> paramClass1, Class<Transcode> paramClass2, List<? extends k<DataType, ResourceType>> paramList, com.bumptech.glide.c.d.f.e<ResourceType, Transcode> parame, l.a<List<Throwable>> parama)
  {
    AppMethodBeat.i(76973);
    this.aHc = paramClass;
    this.aHd = paramList;
    this.aHe = parame;
    this.aHf = parama;
    this.aHg = ("Failed DecodePath{" + paramClass.getSimpleName() + "->" + paramClass1.getSimpleName() + "->" + paramClass2.getSimpleName() + "}");
    AppMethodBeat.o(76973);
  }
  
  private u<ResourceType> a(com.bumptech.glide.c.a.e<DataType> parame, int paramInt1, int paramInt2, j paramj, List<Throwable> paramList)
  {
    AppMethodBeat.i(76975);
    Object localObject1 = null;
    int j = this.aHd.size();
    int i = 0;
    for (;;)
    {
      Object localObject2 = localObject1;
      if (i >= j) {
        break label147;
      }
      localk = (k)this.aHd.get(i);
      try
      {
        if (!localk.a(parame.op(), paramj)) {
          break label198;
        }
        localObject2 = localk.a(parame.op(), paramInt1, paramInt2, paramj);
        localObject1 = localObject2;
      }
      catch (RuntimeException localRuntimeException)
      {
        for (;;)
        {
          if (Log.isLoggable("DecodePath", 2)) {
            new StringBuilder("Failed to decode data for ").append(localk);
          }
          paramList.add(localRuntimeException);
        }
        if (localRuntimeException != null) {
          break label180;
        }
        parame = new p(this.aHg, new ArrayList(paramList));
        AppMethodBeat.o(76975);
        throw parame;
        AppMethodBeat.o(76975);
        return localRuntimeException;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        break;
      }
      catch (IOException localIOException)
      {
        for (;;) {}
      }
      localObject2 = localObject1;
      if (localObject1 != null) {
        break label147;
      }
      i += 1;
    }
  }
  
  final u<ResourceType> a(com.bumptech.glide.c.a.e<DataType> parame, int paramInt1, int paramInt2, j paramj)
  {
    AppMethodBeat.i(76974);
    List localList = (List)i.checkNotNull(this.aHf.acquire(), "Argument must not be null");
    try
    {
      parame = a(parame, paramInt1, paramInt2, paramj, localList);
      return parame;
    }
    finally
    {
      this.aHf.release(localList);
      AppMethodBeat.o(76974);
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(76976);
    String str = "DecodePath{ dataClass=" + this.aHc + ", decoders=" + this.aHd + ", transcoder=" + this.aHe + '}';
    AppMethodBeat.o(76976);
    return str;
  }
  
  static abstract interface a<ResourceType>
  {
    public abstract u<ResourceType> a(u<ResourceType> paramu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.b.h
 * JD-Core Version:    0.7.0.1
 */