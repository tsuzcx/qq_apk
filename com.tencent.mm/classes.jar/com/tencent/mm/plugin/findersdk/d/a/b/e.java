package com.tencent.mm.plugin.findersdk.d.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/findersdk/storage/config/item/RealDynaConfig;", "T", "Lcom/tencent/mm/plugin/findersdk/storage/config/item/ConfigItem;", "defaultValue", "expname", "", "onConfigChanged", "Lkotlin/Function0;", "", "(Ljava/lang/Object;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getExpname", "()Ljava/lang/String;", "getExptEveryTime", "", "getGetExptEveryTime", "()I", "getExptEveryTime$delegate", "Lkotlin/Lazy;", "updateValueFromSvr", "value", "()Ljava/lang/Object;", "finder-sdk_release"})
public final class e<T>
  extends a<T>
{
  private final kotlin.f BwE;
  private final String BwF;
  
  public e(T paramT, String paramString, kotlin.g.a.a<x> parama)
  {
    super(paramT, "SVR", parama);
    AppMethodBeat.i(209611);
    this.BwF = paramString;
    this.BwE = g.ar((kotlin.g.a.a)a.BwG);
    enB();
    paramT = com.tencent.mm.plugin.findersdk.d.a.a.d.Bwz;
    com.tencent.mm.plugin.findersdk.d.a.a.d.a(this.BwF, (d)this);
    AppMethodBeat.o(209611);
  }
  
  public final T aSr()
  {
    AppMethodBeat.i(209609);
    if (((Number)this.BwE.getValue()).intValue() == 1) {
      enB();
    }
    Object localObject2 = getValue();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = Hs();
    }
    AppMethodBeat.o(209609);
    return localObject1;
  }
  
  public final void enB()
  {
    AppMethodBeat.i(209610);
    Object localObject1 = Hs();
    Object localObject2;
    Object localObject3;
    if ((localObject1 instanceof Integer))
    {
      localObject1 = h.ae(com.tencent.mm.plugin.zero.b.a.class);
      p.j(localObject1, "MMKernel.service<IConfig…onfigService::class.java)");
      localObject1 = ((com.tencent.mm.plugin.zero.b.a)localObject1).axc();
      localObject2 = this.BwF;
      localObject3 = Hs();
      if (localObject3 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(209610);
        throw ((Throwable)localObject1);
      }
      localObject1 = Integer.valueOf(((com.tencent.mm.n.f)localObject1).getInt((String)localObject2, ((Integer)localObject3).intValue()));
    }
    for (;;)
    {
      setValue(localObject1);
      Log.i("ConfigItem", "[updateValueFromSvr] keyName:" + this.BwF + ", has update to " + getValue());
      AppMethodBeat.o(209610);
      return;
      if ((localObject1 instanceof Long))
      {
        localObject1 = h.ae(com.tencent.mm.plugin.zero.b.a.class);
        p.j(localObject1, "MMKernel.service<IConfig…onfigService::class.java)");
        localObject1 = ((com.tencent.mm.plugin.zero.b.a)localObject1).axc();
        localObject2 = this.BwF;
        localObject3 = Hs();
        if (localObject3 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type kotlin.Int");
          AppMethodBeat.o(209610);
          throw ((Throwable)localObject1);
        }
        localObject1 = (Long)Integer.valueOf(((com.tencent.mm.n.f)localObject1).getInt((String)localObject2, ((Integer)localObject3).intValue()));
      }
      else if ((localObject1 instanceof String))
      {
        localObject1 = h.ae(com.tencent.mm.plugin.zero.b.a.class);
        p.j(localObject1, "MMKernel.service<IConfig…onfigService::class.java)");
        localObject1 = ((com.tencent.mm.plugin.zero.b.a)localObject1).axc().getValue(this.BwF);
        localObject2 = Hs();
        if (localObject2 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(209610);
          throw ((Throwable)localObject1);
        }
        localObject1 = Util.nullAs((String)localObject1, (String)localObject2);
      }
      else
      {
        localObject1 = Hs();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<Integer>
  {
    public static final a BwG;
    
    static
    {
      AppMethodBeat.i(209855);
      BwG = new a();
      AppMethodBeat.o(209855);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.d.a.b.e
 * JD-Core Version:    0.7.0.1
 */