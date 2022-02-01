package com.tencent.magicbrush.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.l.j;
import kotlin.l.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/magicbrush/utils/Alias;", "R", "T", "", "receiver", "backingProperty", "Lkotlin/reflect/KMutableProperty1;", "(Ljava/lang/Object;Lkotlin/reflect/KMutableProperty1;)V", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Lkotlin/reflect/KMutableProperty1;)V", "receiver_field", "receiver_getter", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Lkotlin/reflect/KMutableProperty1;)V", "getReceiver", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setReceiver", "", "(Ljava/lang/Object;)V", "setValue", "value", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "lib-magicbrush-nano_release"})
public class a<R, T>
{
  private R cQg;
  private kotlin.g.a.a<? extends R> cQh;
  private final j<R, T> cQi;
  
  private a(kotlin.g.a.a<? extends R> parama, j<R, T> paramj)
  {
    AppMethodBeat.i(140286);
    this.cQg = null;
    this.cQh = parama;
    this.cQi = paramj;
    AppMethodBeat.o(140286);
  }
  
  public a(kotlin.g.a.a<? extends R> parama, j<R, T> paramj, byte paramByte)
  {
    this(parama, paramj);
    AppMethodBeat.i(140287);
    AppMethodBeat.o(140287);
  }
  
  private R Vq()
  {
    AppMethodBeat.i(140283);
    Object localObject = this.cQg;
    if (localObject != null)
    {
      AppMethodBeat.o(140283);
      return localObject;
    }
    localObject = this.cQh;
    if (localObject == null) {
      p.iCn();
    }
    localObject = ((kotlin.g.a.a)localObject).invoke();
    AppMethodBeat.o(140283);
    return localObject;
  }
  
  public final T a(n<?> paramn)
  {
    AppMethodBeat.i(140284);
    p.k(paramn, "property");
    paramn = this.cQi.get(Vq());
    AppMethodBeat.o(140284);
    return paramn;
  }
  
  public final void a(n<?> paramn, T paramT)
  {
    AppMethodBeat.i(140285);
    p.k(paramn, "property");
    this.cQi.set(Vq(), paramT);
    AppMethodBeat.o(140285);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.magicbrush.utils.a
 * JD-Core Version:    0.7.0.1
 */