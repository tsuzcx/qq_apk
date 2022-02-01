package com.tencent.mm.plugin.finder.storage.config.item;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/config/item/RealExptConfig;", "T", "Lcom/tencent/mm/plugin/finder/storage/config/item/ConfigItem;", "defaultValue", "expname", "Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;", "(Ljava/lang/Object;Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;)V", "getExpname", "()Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;", "value", "()Ljava/lang/Object;", "plugin-finder_release"})
public final class d<T>
  extends a<T>
{
  private final b.a szC;
  
  public d(T paramT, b.a parama)
  {
    super(paramT, "SVR");
    AppMethodBeat.i(203775);
    this.szC = parama;
    AppMethodBeat.o(203775);
  }
  
  public final T value()
  {
    AppMethodBeat.i(203774);
    Object localObject1 = this.aFh;
    b.a locala;
    Object localObject2;
    if ((localObject1 instanceof Integer))
    {
      localObject1 = (b)g.ab(b.class);
      locala = this.szC;
      localObject2 = this.aFh;
      if (localObject2 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(203774);
        throw ((Throwable)localObject1);
      }
      int i = ((b)localObject1).a(locala, ((Integer)localObject2).intValue());
      AppMethodBeat.o(203774);
      return Integer.valueOf(i);
    }
    if ((localObject1 instanceof Long))
    {
      localObject1 = (b)g.ab(b.class);
      locala = this.szC;
      localObject2 = this.aFh;
      if (localObject2 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type kotlin.Long");
        AppMethodBeat.o(203774);
        throw ((Throwable)localObject1);
      }
      long l = ((b)localObject1).a(locala, ((Long)localObject2).longValue());
      AppMethodBeat.o(203774);
      return Long.valueOf(l);
    }
    if ((localObject1 instanceof Boolean))
    {
      localObject1 = (b)g.ab(b.class);
      locala = this.szC;
      localObject2 = this.aFh;
      if (localObject2 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type kotlin.Boolean");
        AppMethodBeat.o(203774);
        throw ((Throwable)localObject1);
      }
      boolean bool = ((b)localObject1).a(locala, ((Boolean)localObject2).booleanValue());
      AppMethodBeat.o(203774);
      return Boolean.valueOf(bool);
    }
    if ((localObject1 instanceof String))
    {
      localObject1 = (b)g.ab(b.class);
      locala = this.szC;
      localObject2 = this.aFh;
      if (localObject2 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(203774);
        throw ((Throwable)localObject1);
      }
      localObject1 = ((b)localObject1).a(locala, (String)localObject2);
      AppMethodBeat.o(203774);
      return localObject1;
    }
    if ((localObject1 instanceof Float))
    {
      localObject1 = (b)g.ab(b.class);
      locala = this.szC;
      localObject2 = this.aFh;
      if (localObject2 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(203774);
        throw ((Throwable)localObject1);
      }
      float f = ((b)localObject1).a(locala, ((Float)localObject2).floatValue());
      AppMethodBeat.o(203774);
      return Float.valueOf(f);
    }
    localObject1 = this.aFh;
    AppMethodBeat.o(203774);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.config.item.d
 * JD-Core Version:    0.7.0.1
 */