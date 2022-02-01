package com.tencent.mm.plugin.findersdk.d.a.b.b;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.findersdk.d.a.a.b;
import java.lang.ref.WeakReference;
import kotlin.g.a.m;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/findersdk/storage/config/item/integer/FinderIntConfig;", "Lcom/tencent/mm/plugin/findersdk/storage/config/base/FinderFakeConfig;", "", "defValue", "_title", "", "onClick", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "value", "Landroid/content/Context;", "context", "", "(ILjava/lang/String;Lkotlin/jvm/functions/Function2;)V", "getOnClick", "()Lkotlin/jvm/functions/Function2;", "onItemClick", "index", "finder-sdk_release"})
public class a
  extends b<Integer>
{
  private final m<Integer, Context, x> BwJ;
  
  public a(int paramInt, String paramString, m<? super Integer, ? super Context, x> paramm)
  {
    super(Integer.valueOf(paramInt), paramString);
    AppMethodBeat.i(207573);
    this.BwJ = paramm;
    AppMethodBeat.o(207573);
  }
  
  public final void Si(int paramInt)
  {
    AppMethodBeat.i(207571);
    super.Si(paramInt);
    m localm = this.BwJ;
    if (localm != null)
    {
      Object localObject2 = aSr();
      Object localObject1 = enA();
      if (localObject1 != null) {}
      for (localObject1 = (Activity)((WeakReference)localObject1).get();; localObject1 = null)
      {
        localm.invoke(localObject2, localObject1);
        AppMethodBeat.o(207571);
        return;
      }
    }
    AppMethodBeat.o(207571);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.d.a.b.b.a
 * JD-Core Version:    0.7.0.1
 */