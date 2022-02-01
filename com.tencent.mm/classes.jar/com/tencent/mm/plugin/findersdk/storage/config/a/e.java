package com.tencent.mm.plugin.findersdk.storage.config.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.k.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.findersdk.storage.config.base.FinderSvrConfigMonitor;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/storage/config/item/RealDynaConfig;", "T", "Lcom/tencent/mm/plugin/findersdk/storage/config/item/ConfigItem;", "defaultValue", "expname", "", "onConfigChanged", "Lkotlin/Function0;", "", "(Ljava/lang/Object;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getExpname", "()Ljava/lang/String;", "getExptEveryTime", "", "getGetExptEveryTime", "()I", "getExptEveryTime$delegate", "Lkotlin/Lazy;", "updateValueFromSvr", "value", "()Ljava/lang/Object;", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e<T>
  extends a<T>
{
  private final String HdP;
  private final j HdQ;
  
  public e(T paramT, String paramString, kotlin.g.a.a<ah> parama)
  {
    super(paramT, "SVR", parama);
    AppMethodBeat.i(273804);
    this.HdP = paramString;
    this.HdQ = k.cm((kotlin.g.a.a)a.HdR);
    fsn();
    paramT = FinderSvrConfigMonitor.HdJ;
    FinderSvrConfigMonitor.a(this.HdP, (d)this);
    AppMethodBeat.o(273804);
  }
  
  public final T bmg()
  {
    AppMethodBeat.i(273814);
    if (((Number)this.HdQ.getValue()).intValue() == 1) {
      fsn();
    }
    Object localObject = getValue();
    if (localObject == null)
    {
      localObject = aho();
      AppMethodBeat.o(273814);
      return localObject;
    }
    AppMethodBeat.o(273814);
    return localObject;
  }
  
  public final void fsn()
  {
    AppMethodBeat.i(273824);
    if ((h.ax(com.tencent.mm.plugin.zero.b.a.class) == null) || (((com.tencent.mm.plugin.zero.b.a)h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC() == null))
    {
      setValue(aho());
      Log.i("ConfigItem", "[updateValueFromSvr2] keyName:" + this.HdP + ", has update to " + getValue());
      Log.i("ConfigItem", "[updateValueFromSvr] keyName:" + this.HdP + ", has update to " + getValue());
      AppMethodBeat.o(273824);
      return;
    }
    Object localObject1 = aho();
    Object localObject2;
    Object localObject3;
    if ((localObject1 instanceof Integer))
    {
      localObject1 = ((com.tencent.mm.plugin.zero.b.a)h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC();
      localObject2 = this.HdP;
      localObject3 = aho();
      if (localObject3 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(273824);
        throw ((Throwable)localObject1);
      }
      localObject1 = Integer.valueOf(((f)localObject1).getInt((String)localObject2, ((Integer)localObject3).intValue()));
    }
    for (;;)
    {
      setValue(localObject1);
      break;
      if ((localObject1 instanceof Long))
      {
        localObject1 = ((com.tencent.mm.plugin.zero.b.a)h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC();
        localObject2 = this.HdP;
        localObject3 = aho();
        if (localObject3 == null)
        {
          localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
          AppMethodBeat.o(273824);
          throw ((Throwable)localObject1);
        }
        localObject1 = (Long)Integer.valueOf(((f)localObject1).getInt((String)localObject2, ((Integer)localObject3).intValue()));
      }
      else if ((localObject1 instanceof String))
      {
        localObject1 = ((com.tencent.mm.plugin.zero.b.a)h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getValue(this.HdP);
        localObject2 = aho();
        if (localObject2 == null)
        {
          localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(273824);
          throw ((Throwable)localObject1);
        }
        localObject1 = Util.nullAs((String)localObject1, (String)localObject2);
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
    public static final a HdR;
    
    static
    {
      AppMethodBeat.i(273825);
      HdR = new a();
      AppMethodBeat.o(273825);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.storage.config.a.e
 * JD-Core Version:    0.7.0.1
 */