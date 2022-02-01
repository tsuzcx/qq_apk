package com.bumptech.glide.c.b;

import android.support.v4.e.l.a;
import com.bumptech.glide.c.j;
import com.bumptech.glide.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class s<Data, ResourceType, Transcode>
{
  private final Class<Data> aFl;
  private final l.a<List<Throwable>> aFo;
  private final String aFp;
  private final List<? extends h<Data, ResourceType, Transcode>> aGk;
  
  public s(Class<Data> paramClass, Class<ResourceType> paramClass1, Class<Transcode> paramClass2, List<h<Data, ResourceType, Transcode>> paramList, l.a<List<Throwable>> parama)
  {
    AppMethodBeat.i(77033);
    this.aFl = paramClass;
    this.aFo = parama;
    this.aGk = ((List)i.b(paramList));
    this.aFp = ("Failed LoadPath{" + paramClass.getSimpleName() + "->" + paramClass1.getSimpleName() + "->" + paramClass2.getSimpleName() + "}");
    AppMethodBeat.o(77033);
  }
  
  private u<Transcode> a(com.bumptech.glide.c.a.e<Data> parame, j paramj, int paramInt1, int paramInt2, h.a<ResourceType> parama, List<Throwable> paramList)
  {
    AppMethodBeat.i(77035);
    Object localObject1 = null;
    int j = this.aGk.size();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label116;
      }
      Object localObject2 = (h)this.aGk.get(i);
      try
      {
        u localu = parama.a(((h)localObject2).a(parame, paramInt1, paramInt2, paramj));
        localObject2 = ((h)localObject2).aFn.a(localu, paramj);
        localObject1 = localObject2;
      }
      catch (p localp)
      {
        for (;;)
        {
          paramList.add(localp);
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
      parame = new p(this.aFp, new ArrayList(paramList));
      AppMethodBeat.o(77035);
      throw parame;
    }
    AppMethodBeat.o(77035);
    return localObject3;
  }
  
  public final u<Transcode> a(com.bumptech.glide.c.a.e<Data> parame, j paramj, int paramInt1, int paramInt2, h.a<ResourceType> parama)
  {
    AppMethodBeat.i(77034);
    List localList = (List)i.checkNotNull(this.aFo.acquire(), "Argument must not be null");
    try
    {
      parame = a(parame, paramj, paramInt1, paramInt2, parama, localList);
      return parame;
    }
    finally
    {
      this.aFo.release(localList);
      AppMethodBeat.o(77034);
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(77036);
    String str = "LoadPath{decodePaths=" + Arrays.toString(this.aGk.toArray()) + '}';
    AppMethodBeat.o(77036);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.b.s
 * JD-Core Version:    0.7.0.1
 */