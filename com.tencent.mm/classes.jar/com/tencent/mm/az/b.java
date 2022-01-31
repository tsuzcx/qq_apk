package com.tencent.mm.az;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ud;
import com.tencent.mm.protocal.protobuf.ue;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b
  extends m
  implements k
{
  private f callback;
  public b.a fLG;
  public final List<j.b> fLH;
  
  public b(List<j.b> paramList)
  {
    AppMethodBeat.i(59991);
    this.fLH = new ArrayList();
    this.fLH.addAll(paramList);
    this.fLG = new b.a();
    ((b.b)this.fLG.getReqObj()).fLK.xvF = aa(paramList);
    AppMethodBeat.o(59991);
  }
  
  private static ue aa(List<j.b> paramList)
  {
    AppMethodBeat.i(59992);
    ue localue = new ue();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      j.b localb = (j.b)localIterator.next();
      byte[] arrayOfByte = localb.getBuffer();
      ud localud = new ud();
      localud.wMC = localb.getCmdId();
      localud.wMD = new SKBuiltinBuffer_t().setBuffer(arrayOfByte);
      localue.jJv.add(localud);
    }
    localue.jJu = paramList.size();
    ab.d("MicroMsg.NetSceneOplog", "summeroplog oplogs size=" + paramList.size());
    AppMethodBeat.o(59992);
    return localue;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(59993);
    this.callback = paramf;
    int i = dispatch(parame, this.fLG, this);
    AppMethodBeat.o(59993);
    return i;
  }
  
  public final int getType()
  {
    return 681;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(59994);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(59994);
  }
  
  public final int securityLimitCount()
  {
    return 5;
  }
  
  public final m.b securityVerificationChecked(q paramq)
  {
    return m.b.ftu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.az.b
 * JD-Core Version:    0.7.0.1
 */