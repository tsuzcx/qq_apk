package com.tencent.mm.plugin.finder.storage.config.item;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/config/item/RealDynaConfig;", "T", "Lcom/tencent/mm/plugin/finder/storage/config/item/ConfigItem;", "defaultValue", "expname", "", "onConfigChanged", "Lkotlin/Function0;", "", "(Ljava/lang/Object;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getExpname", "()Ljava/lang/String;", "updateValueFromSvr", "value", "()Ljava/lang/Object;", "plugin-finder_release"})
public final class e<T>
  extends a<T>
{
  private final String vFM;
  
  public e(T paramT, String paramString, kotlin.g.a.a<x> parama)
  {
    super(paramT, "SVR", parama);
    AppMethodBeat.i(251937);
    this.vFM = paramString;
    dys();
    paramT = com.tencent.mm.plugin.finder.storage.config.d.vFH;
    com.tencent.mm.plugin.finder.storage.config.d.a(this.vFM, (d)this);
    AppMethodBeat.o(251937);
  }
  
  public final void dys()
  {
    AppMethodBeat.i(251936);
    Object localObject1 = this.aEX;
    Object localObject2;
    Object localObject3;
    if ((localObject1 instanceof Integer))
    {
      localObject1 = g.af(com.tencent.mm.plugin.zero.b.a.class);
      p.g(localObject1, "MMKernel.service<IConfig…onfigService::class.java)");
      localObject1 = ((com.tencent.mm.plugin.zero.b.a)localObject1).aqJ();
      localObject2 = this.vFM;
      localObject3 = this.aEX;
      if (localObject3 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(251936);
        throw ((Throwable)localObject1);
      }
      localObject1 = Integer.valueOf(((f)localObject1).getInt((String)localObject2, ((Integer)localObject3).intValue()));
    }
    for (;;)
    {
      this.value = localObject1;
      Log.i("ConfigItem", "[updateValueFromSvr] keyName:" + this.vFM + ", has update to " + this.value);
      AppMethodBeat.o(251936);
      return;
      if ((localObject1 instanceof Long))
      {
        localObject1 = g.af(com.tencent.mm.plugin.zero.b.a.class);
        p.g(localObject1, "MMKernel.service<IConfig…onfigService::class.java)");
        localObject1 = ((com.tencent.mm.plugin.zero.b.a)localObject1).aqJ();
        localObject2 = this.vFM;
        localObject3 = this.aEX;
        if (localObject3 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type kotlin.Int");
          AppMethodBeat.o(251936);
          throw ((Throwable)localObject1);
        }
        localObject1 = (Long)Integer.valueOf(((f)localObject1).getInt((String)localObject2, ((Integer)localObject3).intValue()));
      }
      else if ((localObject1 instanceof String))
      {
        localObject1 = g.af(com.tencent.mm.plugin.zero.b.a.class);
        p.g(localObject1, "MMKernel.service<IConfig…onfigService::class.java)");
        localObject1 = ((com.tencent.mm.plugin.zero.b.a)localObject1).aqJ().getValue(this.vFM);
        localObject2 = this.aEX;
        if (localObject2 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(251936);
          throw ((Throwable)localObject1);
        }
        localObject1 = Util.nullAs((String)localObject1, (String)localObject2);
      }
      else
      {
        localObject1 = this.aEX;
      }
    }
  }
  
  public final T value()
  {
    AppMethodBeat.i(251935);
    if (((b)g.af(b.class)).a(b.a.snA, 0) == 1) {
      dys();
    }
    Object localObject2 = this.value;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.aEX;
    }
    AppMethodBeat.o(251935);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.config.item.e
 * JD-Core Version:    0.7.0.1
 */