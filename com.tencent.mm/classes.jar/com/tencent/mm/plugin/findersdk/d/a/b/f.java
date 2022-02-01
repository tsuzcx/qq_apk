package com.tencent.mm.plugin.findersdk.d.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/findersdk/storage/config/item/RealExptConfig;", "T", "Lcom/tencent/mm/plugin/findersdk/storage/config/item/ConfigItem;", "defaultValue", "expname", "Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;", "onConfigChanged", "Lkotlin/Function0;", "", "(Ljava/lang/Object;Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;Lkotlin/jvm/functions/Function0;)V", "getExpname", "()Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;", "getExptEveryTime", "", "getGetExptEveryTime", "()I", "getExptEveryTime$delegate", "Lkotlin/Lazy;", "updateValueFromSvr", "value", "()Ljava/lang/Object;", "finder-sdk_release"})
public final class f<T>
  extends a<T>
{
  private final kotlin.f BwE;
  private final b.a BwH;
  
  public f(T paramT, b.a parama, kotlin.g.a.a<x> parama1)
  {
    super(paramT, "SVR", parama1);
    AppMethodBeat.i(209330);
    this.BwH = parama;
    this.BwE = g.ar((kotlin.g.a.a)a.BwI);
    enB();
    paramT = com.tencent.mm.plugin.findersdk.d.a.a.d.Bwz;
    com.tencent.mm.plugin.findersdk.d.a.a.d.a(this.BwH.name(), (d)this);
    AppMethodBeat.o(209330);
  }
  
  public final T aSr()
  {
    AppMethodBeat.i(209327);
    if (((Number)this.BwE.getValue()).intValue() == 1) {
      enB();
    }
    Object localObject2 = getValue();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = Hs();
    }
    AppMethodBeat.o(209327);
    return localObject1;
  }
  
  public final void enB()
  {
    AppMethodBeat.i(209328);
    Object localObject1 = Hs();
    b.a locala;
    Object localObject2;
    if ((localObject1 instanceof Integer))
    {
      localObject1 = (b)h.ae(b.class);
      locala = this.BwH;
      localObject2 = Hs();
      if (localObject2 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(209328);
        throw ((Throwable)localObject1);
      }
      localObject1 = Integer.valueOf(((b)localObject1).a(locala, ((Integer)localObject2).intValue()));
    }
    for (;;)
    {
      setValue(localObject1);
      Log.i("ConfigItem", "[updateValueFromSvr] keyName:" + this.BwH.name() + ", has update to " + getValue());
      AppMethodBeat.o(209328);
      return;
      if ((localObject1 instanceof Long))
      {
        localObject1 = (b)h.ae(b.class);
        locala = this.BwH;
        localObject2 = Hs();
        if (localObject2 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type kotlin.Long");
          AppMethodBeat.o(209328);
          throw ((Throwable)localObject1);
        }
        localObject1 = Long.valueOf(((b)localObject1).a(locala, ((Long)localObject2).longValue()));
      }
      else if ((localObject1 instanceof Boolean))
      {
        localObject1 = (b)h.ae(b.class);
        locala = this.BwH;
        localObject2 = Hs();
        if (localObject2 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type kotlin.Boolean");
          AppMethodBeat.o(209328);
          throw ((Throwable)localObject1);
        }
        localObject1 = Boolean.valueOf(((b)localObject1).a(locala, ((Boolean)localObject2).booleanValue()));
      }
      else if ((localObject1 instanceof String))
      {
        localObject1 = (b)h.ae(b.class);
        locala = this.BwH;
        localObject2 = Hs();
        if (localObject2 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(209328);
          throw ((Throwable)localObject1);
        }
        localObject1 = ((b)localObject1).a(locala, (String)localObject2);
      }
      else if ((localObject1 instanceof Float))
      {
        localObject1 = (b)h.ae(b.class);
        locala = this.BwH;
        localObject2 = Hs();
        if (localObject2 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type kotlin.Float");
          AppMethodBeat.o(209328);
          throw ((Throwable)localObject1);
        }
        localObject1 = Float.valueOf(((b)localObject1).a(locala, ((Float)localObject2).floatValue()));
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
    public static final a BwI;
    
    static
    {
      AppMethodBeat.i(208814);
      BwI = new a();
      AppMethodBeat.o(208814);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.d.a.b.f
 * JD-Core Version:    0.7.0.1
 */