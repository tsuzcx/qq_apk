package com.tencent.mm.plugin.findersdk.storage.config.base;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/storage/config/base/FinderSimpleClickConfig;", "Lcom/tencent/mm/plugin/findersdk/storage/config/base/FinderFakeConfig;", "", "title", "onClick", "Lkotlin/Function1;", "Landroid/app/Activity;", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getOnClick", "()Lkotlin/jvm/functions/Function1;", "onItemClick", "index", "", "reset", "value", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends b<String>
{
  private final kotlin.g.a.b<Activity, ah> DMY;
  
  public c(String paramString, kotlin.g.a.b<? super Activity, ah> paramb)
  {
    super("", paramString);
    AppMethodBeat.i(273795);
    this.DMY = paramb;
    AppMethodBeat.o(273795);
  }
  
  public final void VB(int paramInt)
  {
    AppMethodBeat.i(273811);
    kotlin.g.a.b localb = this.DMY;
    Object localObject = fsm();
    if (localObject == null) {}
    for (localObject = null;; localObject = (Activity)((WeakReference)localObject).get())
    {
      localb.invoke(localObject);
      AppMethodBeat.o(273811);
      return;
    }
  }
  
  public final void reset() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.storage.config.base.c
 * JD-Core Version:    0.7.0.1
 */