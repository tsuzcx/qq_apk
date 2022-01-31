package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ax;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.cco;
import com.tencent.mm.protocal.protobuf.cij;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;

public final class z
  extends m
  implements k
{
  private f callback;
  public com.tencent.mm.network.q ftU;
  private int ftx;
  
  private z(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(108437);
    this.ftx = 2;
    this.ftU = new z.a();
    r.a locala = (r.a)this.ftU.getReqObj();
    locala.gxH.wsW = paramInt;
    locala.gxH.wvs = paramString1;
    locala.gxH.lGH = aa.dsG();
    locala.gxH.wvW = bo.apO(paramString2);
    locala.gxH.wQc = paramString3;
    paramString1 = locala.gxH;
    g.RJ();
    paramString1.wsp = a.QX();
    locala.gxH.wQd = com.tencent.mm.compatible.e.q.getSimCountryIso();
    locala.gxH.wQe = 1;
    AppMethodBeat.o(108437);
  }
  
  public z(String paramString1, String paramString2)
  {
    this(1, paramString1, paramString2, "");
  }
  
  public z(String paramString1, String paramString2, String paramString3)
  {
    this(2, paramString1, paramString2, paramString3);
  }
  
  public final int ajR()
  {
    AppMethodBeat.i(108440);
    Object localObject = ((r.b)this.ftU.getRespObj()).gxI.wrV;
    cij localcij;
    if ((localObject != null) && (((cco)localObject).xNc != null) && (((cco)localObject).xNc.size() > 0))
    {
      localObject = ((cco)localObject).xNc.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localcij = (cij)((Iterator)localObject).next();
      } while (localcij.qsk != 1);
    }
    for (int i = bo.getInt(localcij.xSX, 0);; i = 0)
    {
      AppMethodBeat.o(108440);
      return i;
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(108438);
    this.callback = paramf;
    int i = dispatch(parame, this.ftU, this);
    AppMethodBeat.o(108438);
    return i;
  }
  
  public final int getType()
  {
    return 481;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108439);
    ab.i("MicroMsg.NetSceneEmailReg", "onGYNetEnd  errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    paramq = (r.b)paramq.getRespObj();
    if ((paramInt2 == 4) && (paramInt3 == -301))
    {
      ax.a(true, paramq.gxI.wvY, paramq.gxI.wvZ, paramq.gxI.wvX);
      this.ftx -= 1;
      if (this.ftx <= 0)
      {
        this.callback.onSceneEnd(3, -1, "", this);
        AppMethodBeat.o(108439);
        return;
      }
      doScene(dispatcher(), this.callback);
      AppMethodBeat.o(108439);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ab.e("MicroMsg.NetSceneEmailReg", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108439);
      return;
    }
    ax.a(false, paramq.gxI.wvY, paramq.gxI.wvZ, paramq.gxI.wvX);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(108439);
  }
  
  public final int securityLimitCount()
  {
    return 5;
  }
  
  public final m.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    return m.b.ftu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.z
 * JD-Core Version:    0.7.0.1
 */