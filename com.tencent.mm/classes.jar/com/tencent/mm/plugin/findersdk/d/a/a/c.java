package com.tencent.mm.plugin.findersdk.d.a.a;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/findersdk/storage/config/base/FinderSimpleClickConfig;", "Lcom/tencent/mm/plugin/findersdk/storage/config/base/FinderFakeConfig;", "", "title", "onClick", "Lkotlin/Function1;", "Landroid/app/Activity;", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getOnClick", "()Lkotlin/jvm/functions/Function1;", "onItemClick", "index", "", "reset", "value", "finder-sdk_release"})
public final class c
  extends b<String>
{
  private final kotlin.g.a.b<Activity, x> yUf;
  
  public c(String paramString, kotlin.g.a.b<? super Activity, x> paramb)
  {
    super("", paramString);
    AppMethodBeat.i(209253);
    this.yUf = paramb;
    AppMethodBeat.o(209253);
  }
  
  public final void Si(int paramInt)
  {
    AppMethodBeat.i(209250);
    kotlin.g.a.b localb = this.yUf;
    Object localObject = enA();
    if (localObject != null) {}
    for (localObject = (Activity)((WeakReference)localObject).get();; localObject = null)
    {
      localb.invoke(localObject);
      AppMethodBeat.o(209250);
      return;
    }
  }
  
  public final void reset() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.d.a.a.c
 * JD-Core Version:    0.7.0.1
 */