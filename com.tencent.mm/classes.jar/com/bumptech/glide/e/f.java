package com.bumptech.glide.e;

import com.bumptech.glide.load.g;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  extends a<f>
{
  public f()
  {
    AppMethodBeat.i(77636);
    AppMethodBeat.o(77636);
  }
  
  public static f b(com.bumptech.glide.load.b.j paramj)
  {
    AppMethodBeat.i(77637);
    paramj = (f)new f().a(paramj);
    AppMethodBeat.o(77637);
    return paramj;
  }
  
  public static f g(g paramg)
  {
    AppMethodBeat.i(77638);
    for (Object localObject = new f(); ((a)localObject).aNg; localObject = ((a)localObject).nQ()) {}
    ((a)localObject).aFT = ((g)com.bumptech.glide.g.j.checkNotNull(paramg, "Argument must not be null"));
    ((a)localObject).aMU |= 0x400;
    paramg = (f)((a)localObject).pY();
    AppMethodBeat.o(77638);
    return paramg;
  }
  
  public static f x(Class<?> paramClass)
  {
    AppMethodBeat.i(77639);
    for (Object localObject = new f(); ((a)localObject).aNg; localObject = ((a)localObject).nQ()) {}
    ((a)localObject).aFX = ((Class)com.bumptech.glide.g.j.checkNotNull(paramClass, "Argument must not be null"));
    ((a)localObject).aMU |= 0x1000;
    paramClass = (f)((a)localObject).pY();
    AppMethodBeat.o(77639);
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.e.f
 * JD-Core Version:    0.7.0.1
 */