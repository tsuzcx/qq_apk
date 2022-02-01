package com.bumptech.glide.c.c;

import com.bumptech.glide.h.f;
import com.bumptech.glide.h.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Queue;

public final class m<A, B>
{
  public final f<a<A>, B> aHE;
  
  public m()
  {
    this(250L);
  }
  
  public m(long paramLong)
  {
    AppMethodBeat.i(77265);
    this.aHE = new f(paramLong) {};
    AppMethodBeat.o(77265);
  }
  
  public final B V(A paramA)
  {
    AppMethodBeat.i(77266);
    paramA = a.W(paramA);
    Object localObject = this.aHE.get(paramA);
    paramA.release();
    AppMethodBeat.o(77266);
    return localObject;
  }
  
  public static final class a<A>
  {
    private static final Queue<a<?>> aHG;
    private A aAv;
    private int height;
    private int width;
    
    static
    {
      AppMethodBeat.i(77264);
      aHG = j.dy(0);
      AppMethodBeat.o(77264);
    }
    
    public static <A> a<A> W(A paramA)
    {
      AppMethodBeat.i(77260);
      synchronized (aHG)
      {
        a locala = (a)aHG.poll();
        ??? = locala;
        if (locala == null) {
          ??? = new a();
        }
        ((a)???).aAv = paramA;
        ((a)???).width = 0;
        ((a)???).height = 0;
        AppMethodBeat.o(77260);
        return ???;
      }
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(77262);
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((this.width == paramObject.width) && (this.height == paramObject.height) && (this.aAv.equals(paramObject.aAv)))
        {
          AppMethodBeat.o(77262);
          return true;
        }
        AppMethodBeat.o(77262);
        return false;
      }
      AppMethodBeat.o(77262);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(77263);
      int i = this.height;
      int j = this.width;
      int k = this.aAv.hashCode();
      AppMethodBeat.o(77263);
      return (i * 31 + j) * 31 + k;
    }
    
    public final void release()
    {
      AppMethodBeat.i(77261);
      synchronized (aHG)
      {
        aHG.offer(this);
        AppMethodBeat.o(77261);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.c.c.m
 * JD-Core Version:    0.7.0.1
 */