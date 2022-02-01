package com.tencent.mm.plugin.finder.live.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.bas;
import com.tencent.mm.protocal.protobuf.bat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLivePurchaseList;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetPurchasedFeedListResponse;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "(Lcom/tencent/mm/protobuf/ByteString;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "onCgiEnd", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r
  extends c<bat>
{
  private final String TAG;
  
  public r(b paramb)
  {
    AppMethodBeat.i(351140);
    this.TAG = "CgiFinderLivePurchaseList";
    c.a locala = new c.a();
    locala.funcId = 4066;
    bas localbas = new bas();
    localbas.ZEQ = paramb;
    paramb = bi.ABn;
    localbas.YIY = bi.dVu();
    localbas.YIZ = z.bAW();
    locala.otE = ((a)localbas);
    locala.otF = ((a)new bat());
    locala.uri = "/cgi-bin/micromsg-bin/findergetpurchasedfeedlist";
    c(locala.bEF());
    Log.i(this.TAG, s.X("last_buffer:", localbas.ZEQ));
    AppMethodBeat.o(351140);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.cgi.r
 * JD-Core Version:    0.7.0.1
 */