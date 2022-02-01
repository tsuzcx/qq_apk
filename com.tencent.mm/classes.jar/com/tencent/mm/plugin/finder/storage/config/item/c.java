package com.tencent.mm.plugin.finder.storage.config.item;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.e;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/config/item/RealDynaConfig;", "T", "Lcom/tencent/mm/plugin/finder/storage/config/item/ConfigItem;", "defaultValue", "expname", "", "(Ljava/lang/Object;Ljava/lang/String;)V", "getExpname", "()Ljava/lang/String;", "value", "()Ljava/lang/Object;", "plugin-finder_release"})
public final class c<T>
  extends a<T>
{
  private final String szB;
  
  public c(T paramT, String paramString)
  {
    super(paramT, "SVR");
    AppMethodBeat.i(203773);
    this.szB = paramString;
    AppMethodBeat.o(203773);
  }
  
  public final T value()
  {
    AppMethodBeat.i(203772);
    Object localObject1 = this.aFh;
    Object localObject2;
    Object localObject3;
    if ((localObject1 instanceof Integer))
    {
      localObject1 = g.ab(com.tencent.mm.plugin.zero.b.a.class);
      p.g(localObject1, "MMKernel.service<IConfig…onfigService::class.java)");
      localObject1 = ((com.tencent.mm.plugin.zero.b.a)localObject1).acA();
      localObject2 = this.szB;
      localObject3 = this.aFh;
      if (localObject3 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(203772);
        throw ((Throwable)localObject1);
      }
      int i = ((e)localObject1).getInt((String)localObject2, ((Integer)localObject3).intValue());
      AppMethodBeat.o(203772);
      return Integer.valueOf(i);
    }
    if ((localObject1 instanceof Long))
    {
      localObject1 = g.ab(com.tencent.mm.plugin.zero.b.a.class);
      p.g(localObject1, "MMKernel.service<IConfig…onfigService::class.java)");
      localObject1 = ((com.tencent.mm.plugin.zero.b.a)localObject1).acA();
      localObject2 = this.szB;
      localObject3 = this.aFh;
      if (localObject3 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(203772);
        throw ((Throwable)localObject1);
      }
      localObject1 = (Long)Integer.valueOf(((e)localObject1).getInt((String)localObject2, ((Integer)localObject3).intValue()));
      AppMethodBeat.o(203772);
      return localObject1;
    }
    if ((localObject1 instanceof String))
    {
      localObject1 = g.ab(com.tencent.mm.plugin.zero.b.a.class);
      p.g(localObject1, "MMKernel.service<IConfig…onfigService::class.java)");
      localObject1 = ((com.tencent.mm.plugin.zero.b.a)localObject1).acA().getValue(this.szB);
      localObject2 = this.aFh;
      if (localObject2 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(203772);
        throw ((Throwable)localObject1);
      }
      localObject1 = bt.bI((String)localObject1, (String)localObject2);
      AppMethodBeat.o(203772);
      return localObject1;
    }
    localObject1 = this.aFh;
    AppMethodBeat.o(203772);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.config.item.c
 * JD-Core Version:    0.7.0.1
 */