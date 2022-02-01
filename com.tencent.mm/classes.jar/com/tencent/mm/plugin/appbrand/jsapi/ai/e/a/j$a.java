package com.tencent.mm.plugin.appbrand.jsapi.ai.e.a;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g.b.c;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.Iterator;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.l.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"})
public final class j$a
  extends kotlin.i.b<c>
{
  public j$a(Object paramObject1, Object paramObject2, j paramj)
  {
    super(paramObject2);
  }
  
  public final void a(n<?> paramn, c paramc1, c paramc2)
  {
    AppMethodBeat.i(139787);
    p.k(paramn, "property");
    paramn = (c)paramc2;
    if (((p.h((c)paramc1, paramn) ^ true)) && (paramn.bMJ() != null))
    {
      p.k(paramn, "$this$saveDevice");
      paramc1 = MultiProcessMMKV.getSingleDefault();
      h.ZvG.be((Runnable)new k.a(paramn, paramc1));
      paramc2 = ((Iterable)this.pNU.pNM).iterator();
      e locale;
      label133:
      label187:
      label190:
      while (paramc2.hasNext())
      {
        locale = (e)paramc2.next();
        locale.isSelected = false;
        locale.jYF = false;
        paramn = locale.pMy.bMJ();
        if (paramn != null)
        {
          paramn = paramn.oeD;
          paramc1 = this.pNU.bYJ().bMJ();
          if (paramc1 == null) {
            break label187;
          }
        }
        for (paramc1 = paramc1.oeD;; paramc1 = null)
        {
          if (!p.h(paramn, paramc1)) {
            break label190;
          }
          locale.jYF = true;
          locale.pMx = false;
          locale.isSelected = true;
          break;
          paramn = null;
          break label133;
        }
      }
      paramc2 = ((Iterable)this.pNU.pNN).iterator();
      label258:
      label312:
      label315:
      while (paramc2.hasNext())
      {
        locale = (e)paramc2.next();
        locale.isSelected = false;
        locale.jYF = false;
        paramn = locale.pMy.bMJ();
        if (paramn != null)
        {
          paramn = paramn.oeD;
          paramc1 = this.pNU.bYJ().bMJ();
          if (paramc1 == null) {
            break label312;
          }
        }
        for (paramc1 = paramc1.oeD;; paramc1 = null)
        {
          if (!p.h(paramn, paramc1)) {
            break label315;
          }
          locale.jYF = true;
          locale.pMx = false;
          locale.isSelected = true;
          break;
          paramn = null;
          break label258;
        }
      }
      paramn = this.pNU.pNO;
      if (paramn != null)
      {
        paramn.invoke();
        AppMethodBeat.o(139787);
        return;
      }
    }
    AppMethodBeat.o(139787);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ai.e.a.j.a
 * JD-Core Version:    0.7.0.1
 */