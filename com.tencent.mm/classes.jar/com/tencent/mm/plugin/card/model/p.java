package com.tencent.mm.plugin.card.model;

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
import com.tencent.mm.protocal.protobuf.ak;
import com.tencent.mm.protocal.protobuf.al;
import com.tencent.mm.protocal.protobuf.ot;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class p
  extends m
  implements k
{
  private f callback;
  public String koi;
  public int koj;
  public String kok;
  private final b rr;
  
  public p(LinkedList<ot> paramLinkedList, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(87860);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new ak();
    ((b.a)localObject).fsY = new al();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/acceptcardlistfromapp";
    ((b.a)localObject).funcId = 687;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (ak)this.rr.fsV.fta;
    ((ak)localObject).wlK = paramLinkedList;
    ((ak)localObject).cHp = paramInt1;
    ((ak)localObject).wlG = paramString1;
    ((ak)localObject).wlF = paramString2;
    ((ak)localObject).wlH = paramInt2;
    AppMethodBeat.o(87860);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(87861);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(87861);
    return i;
  }
  
  public final int getType()
  {
    return 687;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(87862);
    ab.i("MicroMsg.NetSceneGetCardListFromApp", "onGYNetEnd, errType = " + paramInt2 + " errCode = " + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (al)this.rr.fsW.fta;
      this.koi = paramq.koi;
      this.koj = paramq.koj;
      this.kok = paramq.kok;
      ab.e("MicroMsg.NetSceneGetCardListFromApp", "onGYNetEnd, ret_code = " + this.koj + " ret_msg = " + this.kok);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(87862);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.p
 * JD-Core Version:    0.7.0.1
 */