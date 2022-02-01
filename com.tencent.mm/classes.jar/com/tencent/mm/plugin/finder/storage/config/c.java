package com.tencent.mm.plugin.finder.storage.config;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/config/FinderSimpleClickConfig;", "Lcom/tencent/mm/plugin/finder/storage/config/FinderFakeConfig;", "", "title", "onClick", "Lkotlin/Function1;", "Landroid/app/Activity;", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getOnClick", "()Lkotlin/jvm/functions/Function1;", "onItemClick", "index", "", "reset", "value", "plugin-finder_release"})
public final class c
  extends b<String>
{
  private final kotlin.g.a.b<Activity, x> uzi;
  
  public c(String paramString, kotlin.g.a.b<? super Activity, x> paramb)
  {
    super("", paramString);
    AppMethodBeat.i(251924);
    this.uzi = paramb;
    AppMethodBeat.o(251924);
  }
  
  public final void Lc(int paramInt)
  {
    AppMethodBeat.i(251923);
    this.uzi.invoke(this.dKq);
    AppMethodBeat.o(251923);
  }
  
  public final void reset() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.config.c
 * JD-Core Version:    0.7.0.1
 */