package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.plugin.finder.cgi.dr;
import com.tencent.mm.plugin.findersdk.a.ck;
import com.tencent.mm.protocal.protobuf.aux;
import com.tencent.mm.protocal.protobuf.bqe;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/cgi/oplog/FinderModifyUserService$modifyUserAvatar$1", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l$a
  implements com.tencent.mm.am.h
{
  l$a(l paraml, ck<bqe> paramck) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(165307);
    Log.i(this.AFn.TAG, "upload head img errType " + paramInt1 + " errCode " + paramInt2 + " errMsg " + paramString);
    com.tencent.mm.kernel.h.aZW().b(3759, (com.tencent.mm.am.h)this);
    paramString = new bqe();
    if (paramp == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderUploadHeadImg");
      AppMethodBeat.o(165307);
      throw paramString;
    }
    paramString.nVs = ((dr)paramp).ADt;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      d.uiThread((a)l.a.a.AFp);
      n.a((n)this.AFn, paramString, this.AFo, false, false, 12);
      AppMethodBeat.o(165307);
      return;
    }
    paramp = this.AFo;
    if (paramp != null)
    {
      aux localaux = new aux();
      localaux.cmdId = 1;
      localaux.retCode = -1;
      ah localah = ah.aiuX;
      paramp.a(paramString, localaux);
    }
    AppMethodBeat.o(165307);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.oplog.l.a
 * JD-Core Version:    0.7.0.1
 */