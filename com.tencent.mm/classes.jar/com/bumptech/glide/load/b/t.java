package com.bumptech.glide.load.b;

import android.support.v4.e.l.a;
import com.bumptech.glide.g.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class t<Data, ResourceType, Transcode>
{
  private final Class<Data> aGU;
  private final l.a<List<Throwable>> aGX;
  private final String aGY;
  private final List<? extends i<Data, ResourceType, Transcode>> aHV;
  
  public t(Class<Data> paramClass, Class<ResourceType> paramClass1, Class<Transcode> paramClass2, List<i<Data, ResourceType, Transcode>> paramList, l.a<List<Throwable>> parama)
  {
    AppMethodBeat.i(77033);
    this.aGU = paramClass;
    this.aGX = parama;
    this.aHV = ((List)j.b(paramList));
    this.aGY = ("Failed LoadPath{" + paramClass.getSimpleName() + "->" + paramClass1.getSimpleName() + "->" + paramClass2.getSimpleName() + "}");
    AppMethodBeat.o(77033);
  }
  
  private v<Transcode> a(com.bumptech.glide.load.a.e<Data> parame, com.bumptech.glide.load.i parami, int paramInt1, int paramInt2, i.a<ResourceType> parama, List<Throwable> paramList)
  {
    AppMethodBeat.i(77035);
    Object localObject1 = null;
    int j = this.aHV.size();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label116;
      }
      Object localObject2 = (i)this.aHV.get(i);
      try
      {
        v localv = parama.a(((i)localObject2).a(parame, paramInt1, paramInt2, parami));
        localObject2 = ((i)localObject2).aGW.a(localv, parami);
        localObject1 = localObject2;
      }
      catch (q localq)
      {
        for (;;)
        {
          paramList.add(localq);
        }
      }
      localObject2 = localObject1;
      if (localObject1 != null) {
        break label120;
      }
      i += 1;
    }
    label116:
    Object localObject3 = localObject1;
    label120:
    if (localObject3 == null)
    {
      parame = new q(this.aGY, new ArrayList(paramList));
      AppMethodBeat.o(77035);
      throw parame;
    }
    AppMethodBeat.o(77035);
    return localObject3;
  }
  
  public final v<Transcode> a(com.bumptech.glide.load.a.e<Data> parame, com.bumptech.glide.load.i parami, int paramInt1, int paramInt2, i.a<ResourceType> parama)
  {
    AppMethodBeat.i(77034);
    List localList = (List)j.checkNotNull(this.aGX.acquire(), "Argument must not be null");
    try
    {
      parame = a(parame, parami, paramInt1, paramInt2, parama, localList);
      return parame;
    }
    finally
    {
      this.aGX.release(localList);
      AppMethodBeat.o(77034);
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(77036);
    String str = "LoadPath{decodePaths=" + Arrays.toString(this.aHV.toArray()) + '}';
    AppMethodBeat.o(77036);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.b.t
 * JD-Core Version:    0.7.0.1
 */