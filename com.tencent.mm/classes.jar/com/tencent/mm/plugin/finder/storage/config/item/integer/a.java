package com.tencent.mm.plugin.finder.storage.config.item.integer;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.config.b;
import com.tencent.mm.plugin.finder.storage.config.e;
import kotlin.g.a.m;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/config/item/integer/FinderIntConfig;", "Lcom/tencent/mm/plugin/finder/storage/config/FinderFakeConfig;", "", "defValue", "_title", "", "onClick", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "value", "Landroid/content/Context;", "context", "", "(ILjava/lang/String;Lkotlin/jvm/functions/Function2;)V", "getOnClick", "()Lkotlin/jvm/functions/Function2;", "onItemClick", "index", "plugin-finder_release"})
public class a
  extends b<Integer>
{
  private final m<Integer, Context, x> vFO;
  
  public a(int paramInt, String paramString, m<? super Integer, ? super Context, x> paramm)
  {
    super(Integer.valueOf(paramInt), paramString);
    AppMethodBeat.i(251944);
    this.vFO = paramm;
    AppMethodBeat.o(251944);
  }
  
  public final void Lc(int paramInt)
  {
    AppMethodBeat.i(251943);
    super.Lc(paramInt);
    m localm = this.vFO;
    if (localm != null)
    {
      localm.invoke(value(), this.dKq);
      AppMethodBeat.o(251943);
      return;
    }
    AppMethodBeat.o(251943);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.config.item.integer.a
 * JD-Core Version:    0.7.0.1
 */