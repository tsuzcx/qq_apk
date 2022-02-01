package com.tencent.mm.plugin.finder.post;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.findersdk.a.bj;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/post/FinderPostCallbackMgr;", "", "()V", "postCallback", "Lcom/tencent/mm/plugin/findersdk/api/IFinderPostCallbackApi;", "getPostCallback", "()Lcom/tencent/mm/plugin/findersdk/api/IFinderPostCallbackApi;", "setPostCallback", "(Lcom/tencent/mm/plugin/findersdk/api/IFinderPostCallbackApi;)V", "doCallback", "", "state", "", "errMsg", "", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a EST;
  private static bj ESU;
  
  static
  {
    AppMethodBeat.i(349422);
    EST = new a();
    AppMethodBeat.o(349422);
  }
  
  public static void a(bj parambj)
  {
    ESU = parambj;
  }
  
  public static void bz(int paramInt, String paramString)
  {
    AppMethodBeat.i(349416);
    s.u(paramString, "errMsg");
    bj localbj = ESU;
    if (localbj != null) {
      localbj.callback(paramInt, paramString);
    }
    ESU = null;
    AppMethodBeat.o(349416);
  }
  
  public static bj eGY()
  {
    return ESU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.post.a
 * JD-Core Version:    0.7.0.1
 */