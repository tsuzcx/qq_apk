package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.bx;
import com.tencent.mm.plugin.finder.cgi.bx.a;
import com.tencent.mm.plugin.i.a.ai;
import com.tencent.mm.plugin.i.a.r;
import com.tencent.mm.protocal.protobuf.ayu;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModBlockPosterService;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderModBlockPoster;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlockPosterSetting;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "cmdBufItem", "getCmdId", "", "handleUpdateResult", "", "retCode", "modBlockPoster", "finderUserName", "block", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "plugin-finder_release"})
public final class b
  extends k<ayu>
  implements r
{
  private final String TAG = "Finder.FinderModBloclPosterSetting";
  
  public final void a(String paramString, boolean paramBoolean, ai<ayu> paramai)
  {
    AppMethodBeat.i(242643);
    p.h(paramString, "finderUserName");
    ayu localayu = new ayu();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localayu.opType = i;
      localayu.finderUsername = paramString;
      a(localayu, paramai, false);
      AppMethodBeat.o(242643);
      return;
    }
  }
  
  public final int getCmdId()
  {
    AppMethodBeat.i(242641);
    bx.a locala = bx.tvW;
    int i = bx.cYX();
    AppMethodBeat.o(242641);
    return i;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.oplog.b
 * JD-Core Version:    0.7.0.1
 */