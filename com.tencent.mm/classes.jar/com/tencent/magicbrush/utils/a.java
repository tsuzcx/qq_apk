package com.tencent.magicbrush.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.l.h;
import kotlin.l.k;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/magicbrush/utils/Alias;", "R", "T", "", "receiver", "backingProperty", "Lkotlin/reflect/KMutableProperty1;", "(Ljava/lang/Object;Lkotlin/reflect/KMutableProperty1;)V", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Lkotlin/reflect/KMutableProperty1;)V", "receiver_field", "receiver_getter", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Lkotlin/reflect/KMutableProperty1;)V", "getReceiver", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setReceiver", "", "(Ljava/lang/Object;)V", "setValue", "value", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "lib-magicbrush-nano_release"})
public class a<R, T>
{
  private R cPp;
  private kotlin.g.a.a<? extends R> cPq;
  private final h<R, T> cPr;
  
  private a(kotlin.g.a.a<? extends R> parama, h<R, T> paramh)
  {
    AppMethodBeat.i(140286);
    this.cPp = null;
    this.cPq = parama;
    this.cPr = paramh;
    AppMethodBeat.o(140286);
  }
  
  public a(kotlin.g.a.a<? extends R> parama, h<R, T> paramh, byte paramByte)
  {
    this(parama, paramh);
    AppMethodBeat.i(140287);
    AppMethodBeat.o(140287);
  }
  
  private R RD()
  {
    AppMethodBeat.i(140283);
    Object localObject = this.cPp;
    if (localObject != null)
    {
      AppMethodBeat.o(140283);
      return localObject;
    }
    localObject = this.cPq;
    if (localObject == null) {
      p.hyc();
    }
    localObject = ((kotlin.g.a.a)localObject).invoke();
    AppMethodBeat.o(140283);
    return localObject;
  }
  
  public final T a(k<?> paramk)
  {
    AppMethodBeat.i(140284);
    p.h(paramk, "property");
    paramk = this.cPr.get(RD());
    AppMethodBeat.o(140284);
    return paramk;
  }
  
  public final void a(k<?> paramk, T paramT)
  {
    AppMethodBeat.i(140285);
    p.h(paramk, "property");
    this.cPr.set(RD(), paramT);
    AppMethodBeat.o(140285);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.magicbrush.utils.a
 * JD-Core Version:    0.7.0.1
 */