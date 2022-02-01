package com.tencent.mm.plugin.finder.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.c.a;
import com.tencent.mm.plugin.finder.live.c.b;
import com.tencent.mm.plugin.finder.live.c.c;
import com.tencent.mm.plugin.finder.live.c.d;
import com.tencent.mm.plugin.finder.live.c.e;
import com.tencent.mm.view.recyclerview.g;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/comment/BoxCommentConfig$itemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b$a
  implements g
{
  public final com.tencent.mm.view.recyclerview.f<?> yF(int paramInt)
  {
    AppMethodBeat.i(370975);
    switch (paramInt)
    {
    default: 
      localf = (com.tencent.mm.view.recyclerview.f)new b();
      AppMethodBeat.o(370975);
      return localf;
    case 20057: 
      localf = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.finder.live.c.f();
      AppMethodBeat.o(370975);
      return localf;
    case 20035: 
      localf = (com.tencent.mm.view.recyclerview.f)new c();
      AppMethodBeat.o(370975);
      return localf;
    case 20002: 
      localf = (com.tencent.mm.view.recyclerview.f)new d();
      AppMethodBeat.o(370975);
      return localf;
    case 20032: 
    case 20034: 
      localf = (com.tencent.mm.view.recyclerview.f)new a();
      AppMethodBeat.o(370975);
      return localf;
    }
    com.tencent.mm.view.recyclerview.f localf = (com.tencent.mm.view.recyclerview.f)new e();
    AppMethodBeat.o(370975);
    return localf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.b.b.a
 * JD-Core Version:    0.7.0.1
 */