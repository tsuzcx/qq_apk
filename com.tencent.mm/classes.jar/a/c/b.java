package a.c;

import a.f.a.m;
import a.f.b.j;
import a.f.b.u.c;
import a.l;
import a.v;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/coroutines/CombinedContext;", "Lkotlin/coroutines/CoroutineContext;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "left", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext$Element;)V", "contains", "", "containsAll", "context", "equals", "other", "", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", "E", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "hashCode", "", "minusKey", "size", "toString", "", "writeReplace", "Serialized", "kotlin-stdlib"})
public final class b
  implements e, Serializable
{
  private final e BMF;
  private final e.b BMG;
  
  public b(e parame, e.b paramb)
  {
    AppMethodBeat.i(56401);
    this.BMF = parame;
    this.BMG = paramb;
    AppMethodBeat.o(56401);
  }
  
  private final boolean a(e.b paramb)
  {
    AppMethodBeat.i(56396);
    boolean bool = j.e(get(paramb.getKey()), paramb);
    AppMethodBeat.o(56396);
    return bool;
  }
  
  private final int size()
  {
    Object localObject = (b)this;
    int i = 2;
    for (;;)
    {
      e locale = ((b)localObject).BMF;
      localObject = locale;
      if (!(locale instanceof b)) {
        localObject = null;
      }
      localObject = (b)localObject;
      if (localObject == null) {
        return i;
      }
      i += 1;
    }
  }
  
  private final Object writeReplace()
  {
    AppMethodBeat.i(56400);
    int i = size();
    Object localObject = new e[i];
    u.c localc = new u.c();
    localc.BNp = 0;
    fold(y.BMg, (m)new b.c((e[])localObject, localc));
    if (localc.BNp == i) {}
    for (i = 1; i == 0; i = 0)
    {
      localObject = (Throwable)new IllegalStateException("Check failed.".toString());
      AppMethodBeat.o(56400);
      throw ((Throwable)localObject);
    }
    localObject = new b.a((e[])localObject);
    AppMethodBeat.o(56400);
    return localObject;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(56397);
    b localb;
    if ((b)this != paramObject)
    {
      if ((!(paramObject instanceof b)) || (((b)paramObject).size() != size())) {
        break label118;
      }
      localb = (b)paramObject;
      paramObject = this;
      if (localb.a(paramObject.BMG)) {
        break label65;
      }
    }
    for (boolean bool = false;; bool = localb.a((e.b)paramObject))
    {
      if (!bool) {
        break label118;
      }
      AppMethodBeat.o(56397);
      return true;
      label65:
      paramObject = paramObject.BMF;
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        break;
      }
      if (paramObject == null)
      {
        paramObject = new v("null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
        AppMethodBeat.o(56397);
        throw paramObject;
      }
    }
    label118:
    AppMethodBeat.o(56397);
    return false;
  }
  
  public final <R> R fold(R paramR, m<? super R, ? super e.b, ? extends R> paramm)
  {
    AppMethodBeat.i(56394);
    j.q(paramm, "operation");
    paramR = paramm.h(this.BMF.fold(paramR, paramm), this.BMG);
    AppMethodBeat.o(56394);
    return paramR;
  }
  
  public final <E extends e.b> E get(e.c<E> paramc)
  {
    AppMethodBeat.i(56393);
    j.q(paramc, "key");
    for (Object localObject = (b)this;; localObject = (b)localObject)
    {
      e.b localb = ((b)localObject).BMG.get(paramc);
      if (localb != null)
      {
        AppMethodBeat.o(56393);
        return localb;
      }
      localObject = ((b)localObject).BMF;
      if (!(localObject instanceof b)) {
        break;
      }
    }
    paramc = ((e)localObject).get(paramc);
    AppMethodBeat.o(56393);
    return paramc;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(56398);
    int i = this.BMF.hashCode();
    int j = this.BMG.hashCode();
    AppMethodBeat.o(56398);
    return i + j;
  }
  
  public final e minusKey(e.c<?> paramc)
  {
    AppMethodBeat.i(56395);
    j.q(paramc, "key");
    if (this.BMG.get(paramc) != null)
    {
      paramc = this.BMF;
      AppMethodBeat.o(56395);
      return paramc;
    }
    paramc = this.BMF.minusKey(paramc);
    if (paramc == this.BMF)
    {
      paramc = (e)this;
      AppMethodBeat.o(56395);
      return paramc;
    }
    if (paramc == f.BMO)
    {
      paramc = (e)this.BMG;
      AppMethodBeat.o(56395);
      return paramc;
    }
    paramc = (e)new b(paramc, this.BMG);
    AppMethodBeat.o(56395);
    return paramc;
  }
  
  public final e plus(e parame)
  {
    AppMethodBeat.i(56402);
    j.q(parame, "context");
    parame = e.a.a(this, parame);
    AppMethodBeat.o(56402);
    return parame;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(56399);
    String str = "[" + (String)fold("", (m)b.b.BMJ) + "]";
    AppMethodBeat.o(56399);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.c.b
 * JD-Core Version:    0.7.0.1
 */