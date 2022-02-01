package com.tencent.mm.plugin.findersdk.storage.config.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.findersdk.storage.config.base.FinderSvrConfigMonitor;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/storage/config/item/RealExptConfig;", "T", "Lcom/tencent/mm/plugin/findersdk/storage/config/item/ConfigItem;", "defaultValue", "expname", "Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;", "onConfigChanged", "Lkotlin/Function0;", "", "(Ljava/lang/Object;Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;Lkotlin/jvm/functions/Function0;)V", "getExpname", "()Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;", "getExptEveryTime", "", "getGetExptEveryTime", "()I", "getExptEveryTime$delegate", "Lkotlin/Lazy;", "updateValueFromSvr", "value", "()Ljava/lang/Object;", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f<T>
  extends a<T>
{
  private final j HdQ;
  private final c.a HdS;
  
  public f(T paramT, c.a parama, kotlin.g.a.a<ah> parama1)
  {
    super(paramT, "SVR", parama1);
    AppMethodBeat.i(273813);
    this.HdS = parama;
    this.HdQ = k.cm((kotlin.g.a.a)a.HdT);
    fsn();
    paramT = FinderSvrConfigMonitor.HdJ;
    FinderSvrConfigMonitor.a(this.HdS.name(), (d)this);
    AppMethodBeat.o(273813);
  }
  
  public final T bmg()
  {
    AppMethodBeat.i(273819);
    if (((Number)this.HdQ.getValue()).intValue() == 1) {
      fsn();
    }
    Object localObject = getValue();
    if (localObject == null)
    {
      localObject = aho();
      AppMethodBeat.o(273819);
      return localObject;
    }
    AppMethodBeat.o(273819);
    return localObject;
  }
  
  public final void fsn()
  {
    AppMethodBeat.i(273830);
    Object localObject1 = aho();
    c.a locala;
    Object localObject2;
    if ((localObject1 instanceof Integer))
    {
      localObject1 = (c)h.ax(c.class);
      locala = this.HdS;
      localObject2 = aho();
      if (localObject2 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(273830);
        throw ((Throwable)localObject1);
      }
      localObject1 = Integer.valueOf(((c)localObject1).a(locala, ((Integer)localObject2).intValue()));
    }
    for (;;)
    {
      setValue(localObject1);
      Log.i("ConfigItem", "[updateValueFromSvr] keyName:" + this.HdS.name() + ", has update to " + getValue());
      AppMethodBeat.o(273830);
      return;
      if ((localObject1 instanceof Long))
      {
        localObject1 = (c)h.ax(c.class);
        locala = this.HdS;
        localObject2 = aho();
        if (localObject2 == null)
        {
          localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.Long");
          AppMethodBeat.o(273830);
          throw ((Throwable)localObject1);
        }
        localObject1 = Long.valueOf(((c)localObject1).a(locala, ((Long)localObject2).longValue()));
      }
      else if ((localObject1 instanceof Boolean))
      {
        localObject1 = (c)h.ax(c.class);
        locala = this.HdS;
        localObject2 = aho();
        if (localObject2 == null)
        {
          localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
          AppMethodBeat.o(273830);
          throw ((Throwable)localObject1);
        }
        localObject1 = Boolean.valueOf(((c)localObject1).a(locala, ((Boolean)localObject2).booleanValue()));
      }
      else if ((localObject1 instanceof String))
      {
        localObject1 = (c)h.ax(c.class);
        locala = this.HdS;
        localObject2 = aho();
        if (localObject2 == null)
        {
          localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(273830);
          throw ((Throwable)localObject1);
        }
        localObject1 = ((c)localObject1).a(locala, (String)localObject2);
      }
      else if ((localObject1 instanceof Float))
      {
        localObject1 = (c)h.ax(c.class);
        locala = this.HdS;
        localObject2 = aho();
        if (localObject2 == null)
        {
          localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
          AppMethodBeat.o(273830);
          throw ((Throwable)localObject1);
        }
        localObject1 = Float.valueOf(((c)localObject1).a(locala, ((Float)localObject2).floatValue()));
      }
      else
      {
        localObject1 = aho();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<Integer>
  {
    public static final a HdT;
    
    static
    {
      AppMethodBeat.i(273801);
      HdT = new a();
      AppMethodBeat.o(273801);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.storage.config.a.f
 * JD-Core Version:    0.7.0.1
 */