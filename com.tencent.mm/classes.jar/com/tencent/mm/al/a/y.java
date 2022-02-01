package com.tencent.mm.al.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.elp;
import com.tencent.mm.protocal.protobuf.elq;
import com.tencent.mm.protocal.protobuf.nw;
import com.tencent.mm.sdk.platformtools.Log;

public final class y
  extends q
  implements m
{
  private i callback;
  Object data;
  public d rr;
  
  public y(String paramString1, String paramString2, nw paramnw1, nw paramnw2, Object paramObject)
  {
    AppMethodBeat.i(124328);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new elp();
    ((d.a)localObject).iLO = new elq();
    ((d.a)localObject).uri = "/cgi-bin/mmocbiz-bin/updatebizchatmemberlist";
    ((d.a)localObject).funcId = 1357;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (elp)this.rr.iLK.iLR;
    ((elp)localObject).KTt = paramString1;
    ((elp)localObject).KTl = paramString2;
    ((elp)localObject).NkD = paramnw1;
    ((elp)localObject).NkE = paramnw2;
    this.data = paramObject;
    AppMethodBeat.o(124328);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(124330);
    this.callback = parami;
    Log.i("MicroMsg.brandservice.NetSceneUpdateBizChatMemberList", "do scene");
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(124330);
    return i;
  }
  
  public final int getType()
  {
    return 1357;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124329);
    Log.d("MicroMsg.brandservice.NetSceneUpdateBizChatMemberList", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124329);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.al.a.y
 * JD-Core Version:    0.7.0.1
 */