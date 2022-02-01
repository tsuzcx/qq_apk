package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.protocal.protobuf.cqq;
import com.tencent.mm.protocal.protobuf.cqr;
import com.tencent.mm.protocal.protobuf.cqy;
import com.tencent.mm.protocal.protobuf.cqz;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

public final class h
  extends n
  implements k
{
  private f callback;
  private com.tencent.mm.al.b rr;
  
  public h(com.tencent.mm.plugin.address.d.b paramb)
  {
    AppMethodBeat.i(20786);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new cqy();
    ((b.a)localObject).hNN = new cqz();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/rcptinfoupdate";
    ((b.a)localObject).funcId = 418;
    ((b.a)localObject).hNO = 203;
    ((b.a)localObject).respCmdId = 1000000203;
    this.rr = ((b.a)localObject).aDC();
    localObject = (cqy)this.rr.hNK.hNQ;
    ((cqy)localObject).Hjd = new cqr();
    ((cqy)localObject).Hjd.id = paramb.id;
    ((cqy)localObject).Hjd.Hjk = new cwt().aPy(bt.bI(paramb.jsb, ""));
    ((cqy)localObject).Hjd.Hji = new cwt().aPy(bt.bI(paramb.jrZ, ""));
    ((cqy)localObject).Hjd.Hjn = new cwt().aPy(bt.bI(paramb.jse, ""));
    ((cqy)localObject).Hjd.Hjl = new cwt().aPy(bt.bI(paramb.jsc, ""));
    ((cqy)localObject).Hjd.Hjo = new cwt().aPy(bt.bI(paramb.jsf, ""));
    ((cqy)localObject).Hjd.Hjp = new cwt().aPy(bt.bI(paramb.jsg, ""));
    ((cqy)localObject).Hjd.Hjj = new cwt().aPy(bt.bI(paramb.jsa, ""));
    ((cqy)localObject).Hjd.Hjm = new cwt().aPy(bt.bI(paramb.jsd, ""));
    ((cqy)localObject).Hjd.Hjq = new cwt().aPy(bt.bI(paramb.jsh, ""));
    AppMethodBeat.o(20786);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(20788);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(20788);
    return i;
  }
  
  public final int getType()
  {
    return 418;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20787);
    ad.d("MicroMsg.NetSceneRcptInfoUpdate", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (cqz)((com.tencent.mm.al.b)paramq).hNL.hNQ;
      if (paramq.Hje.Hjh != null)
      {
        ad.d("MicroMsg.NetSceneRcptInfoUpdate", "resp.rImpl.rcptinfolist.rcptinfolist " + paramq.Hje.Hjh.size());
        a.aUR();
        a.aUT().t(paramq.Hje.Hjh);
        a.aUR();
        a.aUT().aUV();
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20787);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.h
 * JD-Core Version:    0.7.0.1
 */