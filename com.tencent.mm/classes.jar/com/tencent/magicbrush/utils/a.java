package com.tencent.magicbrush.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import d.l.h;
import d.l.k;

@l(gfx={1, 1, 13}, gfy={""}, gfz={"Lcom/tencent/magicbrush/utils/Alias;", "R", "T", "", "receiver", "backingProperty", "Lkotlin/reflect/KMutableProperty1;", "(Ljava/lang/Object;Lkotlin/reflect/KMutableProperty1;)V", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Lkotlin/reflect/KMutableProperty1;)V", "receiver_field", "receiver_getter", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Lkotlin/reflect/KMutableProperty1;)V", "getReceiver", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setReceiver", "", "(Ljava/lang/Object;)V", "setValue", "value", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "lib-magicbrush-nano_release"})
public class a<R, T>
{
  private R cAC;
  private d.g.a.a<? extends R> cAD;
  private final h<R, T> cAE;
  
  private a(d.g.a.a<? extends R> parama, h<R, T> paramh)
  {
    AppMethodBeat.i(140286);
    this.cAC = null;
    this.cAD = parama;
    this.cAE = paramh;
    AppMethodBeat.o(140286);
  }
  
  public a(d.g.a.a<? extends R> parama, h<R, T> paramh, byte paramByte)
  {
    this(parama, paramh);
    AppMethodBeat.i(140287);
    AppMethodBeat.o(140287);
  }
  
  private R HG()
  {
    AppMethodBeat.i(140283);
    Object localObject = this.cAC;
    if (localObject != null)
    {
      AppMethodBeat.o(140283);
      return localObject;
    }
    localObject = this.cAD;
    if (localObject == null) {
      p.gfZ();
    }
    localObject = ((d.g.a.a)localObject).invoke();
    AppMethodBeat.o(140283);
    return localObject;
  }
  
  public final T a(k<?> paramk)
  {
    AppMethodBeat.i(140284);
    p.h(paramk, "property");
    paramk = this.cAE.get(HG());
    AppMethodBeat.o(140284);
    return paramk;
  }
  
  public final void a(k<?> paramk, T paramT)
  {
    AppMethodBeat.i(140285);
    p.h(paramk, "property");
    this.cAE.set(HG(), paramT);
    AppMethodBeat.o(140285);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.utils.a
 * JD-Core Version:    0.7.0.1
 */