package com.tencent.mm.plugin.location.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bmx;
import com.tencent.mm.protocal.protobuf.bsy;
import com.tencent.mm.protocal.protobuf.bsz;
import com.tencent.mm.protocal.protobuf.clf;
import com.tencent.mm.protocal.protobuf.cpm;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends m
  implements k
{
  private f callback;
  private Runnable fQa;
  public String hxt;
  public int obD;
  public clf obE;
  public List<cpm> obF;
  public bsz obG;
  public int obH;
  private String obI;
  public final b rr;
  
  public c(String paramString, int paramInt1, cpm paramcpm, int paramInt2, clf paramclf)
  {
    AppMethodBeat.i(113415);
    this.obE = null;
    this.obF = null;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bsy();
    ((b.a)localObject).fsY = new bsz();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/refreshtrackroom";
    ((b.a)localObject).funcId = 492;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (bsy)this.rr.fsV.fta;
    ((bsy)localObject).wQX = paramString;
    ((bsy)localObject).jKs = paramInt1;
    ((bsy)localObject).xGA = paramcpm;
    ((bsy)localObject).nrR = paramInt2;
    ((bsy)localObject).xGB = paramclf;
    this.obI = paramString;
    this.obH = ((bsy)localObject).jKs;
    ab.d("MicroMsg.NetSceneRefreshTrackRoom", "userPosiItem " + paramcpm.Username + " " + paramcpm.xYw.wyP + " " + paramcpm.xYw.wyO + " heading:" + paramcpm.xYw.xBh);
    ab.d("MicroMsg.NetSceneRefreshTrackRoom", "userPoi " + paramclf.wyP + " " + paramclf.wyO + " " + paramclf.Name);
    ab.d("MicroMsg.NetSceneRefreshTrackRoom", "trackRoomId:" + paramString + " uploadStatus:" + paramInt1);
    AppMethodBeat.o(113415);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(113416);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(113416);
    return i;
  }
  
  public final int getType()
  {
    return 492;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(113417);
    this.obG = ((bsz)((b)paramq).fsW.fta);
    if (this.obG != null) {
      this.hxt = this.obG.wuE;
    }
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.obD = this.obG.xor;
      this.obE = this.obG.xGD;
      this.obF = this.obG.xGC;
      paramq = new StringBuffer();
      paramq.append(String.format("[ resp count %d ] ", new Object[] { Integer.valueOf(this.obG.jJu) }));
      if (this.obE != null) {
        paramq.append(String.format("[ roomPoi  %f %f %s] ", new Object[] { Double.valueOf(this.obE.wyP), Double.valueOf(this.obE.wyO), this.obE.Name }));
      }
      ab.d("MicroMsg.NetSceneRefreshTrackRoom", "onGynetEnd " + paramq.toString());
      paramq = new LinkedList();
      paramArrayOfByte = this.obG.xGC.iterator();
      while (paramArrayOfByte.hasNext())
      {
        cpm localcpm = (cpm)paramArrayOfByte.next();
        if (localcpm == null)
        {
          paramq.add(localcpm);
        }
        else
        {
          if (localcpm.xYw == null) {
            paramq.add(localcpm);
          }
          if ((Math.abs(localcpm.xYw.wyO) > 180.0D) || (Math.abs(localcpm.xYw.wyP) > 90.0D))
          {
            ab.w("MicroMsg.NetSceneRefreshTrackRoom", "server lat lng invalid %s %f %f %f", new Object[] { localcpm.Username, Double.valueOf(localcpm.xYw.wyP), Double.valueOf(localcpm.xYw.wyO), Double.valueOf(localcpm.xYw.xBh) });
            paramq.add(localcpm);
          }
        }
      }
      this.obG.jJu = this.obG.xGC.size();
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.fQa != null) {
      this.fQa.run();
    }
    AppMethodBeat.o(113417);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.a.c
 * JD-Core Version:    0.7.0.1
 */