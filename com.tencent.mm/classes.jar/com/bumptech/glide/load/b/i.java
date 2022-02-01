package com.bumptech.glide.load.b;

import android.support.v4.e.l.a;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class i<DataType, ResourceType, Transcode>
{
  private final Class<DataType> aGU;
  private final List<? extends com.bumptech.glide.load.j<DataType, ResourceType>> aGV;
  final com.bumptech.glide.load.d.f.e<ResourceType, Transcode> aGW;
  private final l.a<List<Throwable>> aGX;
  private final String aGY;
  
  public i(Class<DataType> paramClass, Class<ResourceType> paramClass1, Class<Transcode> paramClass2, List<? extends com.bumptech.glide.load.j<DataType, ResourceType>> paramList, com.bumptech.glide.load.d.f.e<ResourceType, Transcode> parame, l.a<List<Throwable>> parama)
  {
    AppMethodBeat.i(76973);
    this.aGU = paramClass;
    this.aGV = paramList;
    this.aGW = parame;
    this.aGX = parama;
    this.aGY = ("Failed DecodePath{" + paramClass.getSimpleName() + "->" + paramClass1.getSimpleName() + "->" + paramClass2.getSimpleName() + "}");
    AppMethodBeat.o(76973);
  }
  
  private v<ResourceType> a(com.bumptech.glide.load.a.e<DataType> parame, int paramInt1, int paramInt2, com.bumptech.glide.load.i parami, List<Throwable> paramList)
  {
    AppMethodBeat.i(76975);
    Object localObject1 = null;
    int j = this.aGV.size();
    int i = 0;
    for (;;)
    {
      Object localObject2 = localObject1;
      if (i >= j) {
        break label147;
      }
      localj = (com.bumptech.glide.load.j)this.aGV.get(i);
      try
      {
        if (!localj.a(parame.ov(), parami)) {
          break label198;
        }
        localObject2 = localj.a(parame.ov(), paramInt1, paramInt2, parami);
        localObject1 = localObject2;
      }
      catch (RuntimeException localRuntimeException)
      {
        for (;;)
        {
          if (Log.isLoggable("DecodePath", 2)) {
            new StringBuilder("Failed to decode data for ").append(localj);
          }
          paramList.add(localRuntimeException);
        }
        if (localRuntimeException != null) {
          break label180;
        }
        parame = new q(this.aGY, new ArrayList(paramList));
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
  
  final v<ResourceType> a(com.bumptech.glide.load.a.e<DataType> parame, int paramInt1, int paramInt2, com.bumptech.glide.load.i parami)
  {
    AppMethodBeat.i(76974);
    List localList = (List)com.bumptech.glide.g.j.checkNotNull(this.aGX.acquire(), "Argument must not be null");
    try
    {
      parame = a(parame, paramInt1, paramInt2, parami, localList);
      return parame;
    }
    finally
    {
      this.aGX.release(localList);
      AppMethodBeat.o(76974);
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(76976);
    String str = "DecodePath{ dataClass=" + this.aGU + ", decoders=" + this.aGV + ", transcoder=" + this.aGW + '}';
    AppMethodBeat.o(76976);
    return str;
  }
  
  static abstract interface a<ResourceType>
  {
    public abstract v<ResourceType> a(v<ResourceType> paramv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.b.i
 * JD-Core Version:    0.7.0.1
 */