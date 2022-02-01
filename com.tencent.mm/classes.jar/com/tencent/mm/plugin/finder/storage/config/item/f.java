package com.tencent.mm.plugin.finder.storage.config.item;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/config/item/RealExptConfig;", "T", "Lcom/tencent/mm/plugin/finder/storage/config/item/ConfigItem;", "defaultValue", "expname", "Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;", "onConfigChanged", "Lkotlin/Function0;", "", "(Ljava/lang/Object;Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;Lkotlin/jvm/functions/Function0;)V", "getExpname", "()Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;", "updateValueFromSvr", "value", "()Ljava/lang/Object;", "plugin-finder_release"})
public final class f<T>
  extends a<T>
{
  private final b.a vFN;
  
  public f(T paramT, b.a parama, kotlin.g.a.a<x> parama1)
  {
    super(paramT, "SVR", parama1);
    AppMethodBeat.i(251940);
    this.vFN = parama;
    dys();
    paramT = com.tencent.mm.plugin.finder.storage.config.d.vFH;
    com.tencent.mm.plugin.finder.storage.config.d.a(this.vFN.name(), (d)this);
    AppMethodBeat.o(251940);
  }
  
  public final void dys()
  {
    AppMethodBeat.i(251939);
    Object localObject1 = this.aEX;
    b.a locala;
    Object localObject2;
    if ((localObject1 instanceof Integer))
    {
      localObject1 = (b)g.af(b.class);
      locala = this.vFN;
      localObject2 = this.aEX;
      if (localObject2 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(251939);
        throw ((Throwable)localObject1);
      }
      localObject1 = Integer.valueOf(((b)localObject1).a(locala, ((Integer)localObject2).intValue()));
    }
    for (;;)
    {
      this.value = localObject1;
      Log.i("ConfigItem", "[updateValueFromSvr] keyName:" + this.vFN.name() + ", has update to " + this.value);
      AppMethodBeat.o(251939);
      return;
      if ((localObject1 instanceof Long))
      {
        localObject1 = (b)g.af(b.class);
        locala = this.vFN;
        localObject2 = this.aEX;
        if (localObject2 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type kotlin.Long");
          AppMethodBeat.o(251939);
          throw ((Throwable)localObject1);
        }
        localObject1 = Long.valueOf(((b)localObject1).a(locala, ((Long)localObject2).longValue()));
      }
      else if ((localObject1 instanceof Boolean))
      {
        localObject1 = (b)g.af(b.class);
        locala = this.vFN;
        localObject2 = this.aEX;
        if (localObject2 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type kotlin.Boolean");
          AppMethodBeat.o(251939);
          throw ((Throwable)localObject1);
        }
        localObject1 = Boolean.valueOf(((b)localObject1).a(locala, ((Boolean)localObject2).booleanValue()));
      }
      else if ((localObject1 instanceof String))
      {
        localObject1 = (b)g.af(b.class);
        locala = this.vFN;
        localObject2 = this.aEX;
        if (localObject2 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(251939);
          throw ((Throwable)localObject1);
        }
        localObject1 = ((b)localObject1).a(locala, (String)localObject2);
      }
      else if ((localObject1 instanceof Float))
      {
        localObject1 = (b)g.af(b.class);
        locala = this.vFN;
        localObject2 = this.aEX;
        if (localObject2 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type kotlin.Float");
          AppMethodBeat.o(251939);
          throw ((Throwable)localObject1);
        }
        localObject1 = Float.valueOf(((b)localObject1).a(locala, ((Float)localObject2).floatValue()));
      }
      else
      {
        localObject1 = this.aEX;
      }
    }
  }
  
  public final T value()
  {
    AppMethodBeat.i(251938);
    if (((b)g.af(b.class)).a(b.a.snA, 0) == 1) {
      dys();
    }
    Object localObject2 = this.value;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.aEX;
    }
    AppMethodBeat.o(251938);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.config.item.f
 * JD-Core Version:    0.7.0.1
 */