package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.model.u;
import com.tencent.mm.protocal.protobuf.ajs;
import com.tencent.mm.protocal.protobuf.akj;
import com.tencent.mm.protocal.protobuf.akk;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;
import d.v;
import java.util.LinkedList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetFansList;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "(Lcom/tencent/mm/protobuf/ByteString;)V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFansList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;", "getRequestBuffer", "getResponseBuffer", "getType", "hasContinue", "", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class aa
  extends n
  implements com.tencent.mm.network.k
{
  private final String TAG;
  private g callback;
  public com.tencent.mm.ak.b rr;
  
  public aa(com.tencent.mm.bw.b paramb)
  {
    AppMethodBeat.i(165220);
    this.TAG = "Finder.NetSceneFinderGetFansList";
    b.a locala = new b.a();
    locala.op(getType());
    akj localakj = new akj();
    localakj.rfC = u.axE();
    localakj.rmJ = paramb;
    paramb = q.qXH;
    localakj.EDL = q.csi();
    locala.c((a)localakj);
    locala.d((a)new akk());
    locala.Am("/cgi-bin/micromsg-bin/findergetfanslist");
    paramb = locala.aAz();
    d.g.b.k.g(paramb, "builder.buildInstance()");
    this.rr = paramb;
    ac.i(this.TAG, "NetSceneFinderGetFansList");
    AppMethodBeat.o(165220);
  }
  
  public final LinkedList<ajs> csp()
  {
    AppMethodBeat.i(165219);
    Object localObject = this.rr.aBD();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFansListResponse");
      AppMethodBeat.o(165219);
      throw ((Throwable)localObject);
    }
    localObject = ((akk)localObject).EEG;
    AppMethodBeat.o(165219);
    return localObject;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(165217);
    this.callback = paramg;
    int i = dispatch(parame, (com.tencent.mm.network.q)this.rr, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(165217);
    return i;
  }
  
  public final int getType()
  {
    return 3531;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(165218);
    ac.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(1279L, 9L, 1L, false);
    }
    for (;;)
    {
      if (this.callback != null)
      {
        paramq = this.callback;
        if (paramq == null) {
          d.g.b.k.fOy();
        }
        paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      }
      AppMethodBeat.o(165218);
      return;
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(1279L, 10L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.aa
 * JD-Core Version:    0.7.0.1
 */