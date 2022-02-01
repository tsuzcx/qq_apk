package com.tencent.magicbrush.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.l.k;
import kotlin.l.o;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/magicbrush/utils/Alias;", "R", "T", "", "receiver", "backingProperty", "Lkotlin/reflect/KMutableProperty1;", "(Ljava/lang/Object;Lkotlin/reflect/KMutableProperty1;)V", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Lkotlin/reflect/KMutableProperty1;)V", "receiver_field", "receiver_getter", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Lkotlin/reflect/KMutableProperty1;)V", "getReceiver", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setReceiver", "", "(Ljava/lang/Object;)V", "setValue", "value", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "lib-magicbrush-nano_release"}, k=1, mv={1, 1, 16})
public class a<R, T>
{
  private R eLl;
  private kotlin.g.a.a<? extends R> eLm;
  private final k<R, T> eLn;
  
  private a(kotlin.g.a.a<? extends R> parama, k<R, T> paramk)
  {
    AppMethodBeat.i(140286);
    this.eLl = null;
    this.eLm = parama;
    this.eLn = paramk;
    AppMethodBeat.o(140286);
  }
  
  public a(kotlin.g.a.a<? extends R> parama, k<R, T> paramk, byte paramByte)
  {
    this(parama, paramk);
    AppMethodBeat.i(140287);
    AppMethodBeat.o(140287);
  }
  
  private R avT()
  {
    AppMethodBeat.i(140283);
    Object localObject = this.eLl;
    if (localObject != null)
    {
      AppMethodBeat.o(140283);
      return localObject;
    }
    localObject = this.eLm;
    if (localObject == null) {
      s.klw();
    }
    localObject = ((kotlin.g.a.a)localObject).invoke();
    AppMethodBeat.o(140283);
    return localObject;
  }
  
  public final T a(o<?> paramo)
  {
    AppMethodBeat.i(140284);
    s.t(paramo, "property");
    paramo = this.eLn.get(avT());
    AppMethodBeat.o(140284);
    return paramo;
  }
  
  public final void a(o<?> paramo, T paramT)
  {
    AppMethodBeat.i(140285);
    s.t(paramo, "property");
    this.eLn.set(avT(), paramT);
    AppMethodBeat.o(140285);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.magicbrush.utils.a
 * JD-Core Version:    0.7.0.1
 */