package com.tencent.mm.plugin.findersdk.storage.config.a.b;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.findersdk.storage.config.base.b;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/storage/config/item/integer/FinderIntConfig;", "Lcom/tencent/mm/plugin/findersdk/storage/config/base/FinderFakeConfig;", "", "defValue", "_title", "", "onClick", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "value", "Landroid/content/Context;", "context", "", "(ILjava/lang/String;Lkotlin/jvm/functions/Function2;)V", "getOnClick", "()Lkotlin/jvm/functions/Function2;", "onItemClick", "index", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public class a
  extends b<Integer>
{
  private final m<Integer, Context, ah> HdU;
  
  public a(int paramInt, String paramString, m<? super Integer, ? super Context, ah> paramm)
  {
    super(Integer.valueOf(paramInt), paramString);
    AppMethodBeat.i(273792);
    this.HdU = paramm;
    AppMethodBeat.o(273792);
  }
  
  public final void VB(int paramInt)
  {
    AppMethodBeat.i(273807);
    super.VB(paramInt);
    m localm = this.HdU;
    Object localObject2;
    if (localm != null)
    {
      localObject2 = bmg();
      localObject1 = fsm();
      if (localObject1 != null) {
        break label52;
      }
    }
    label52:
    for (Object localObject1 = null;; localObject1 = (Activity)((WeakReference)localObject1).get())
    {
      localm.invoke(localObject2, localObject1);
      AppMethodBeat.o(273807);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.storage.config.a.b.a
 * JD-Core Version:    0.7.0.1
 */