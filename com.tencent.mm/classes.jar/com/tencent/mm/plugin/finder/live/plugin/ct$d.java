package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"getAnchorTag", "", "invoke"})
final class ct$d
  extends q
  implements a<String>
{
  public static final d yyq;
  
  static
  {
    AppMethodBeat.i(222789);
    yyq = new d();
    AppMethodBeat.o(222789);
  }
  
  ct$d()
  {
    super(0);
  }
  
  public static String bLp()
  {
    AppMethodBeat.i(222788);
    Object localObject = MMApplicationContext.getContext();
    p.j(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getResources().getString(b.j.finder_live_anchor_tag_txt);
    p.j(localObject, "MMApplicationContext.get…nder_live_anchor_tag_txt)");
    AppMethodBeat.o(222788);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.ct.d
 * JD-Core Version:    0.7.0.1
 */