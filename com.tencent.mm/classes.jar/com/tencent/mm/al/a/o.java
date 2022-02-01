package com.tencent.mm.al.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.aeb;
import com.tencent.mm.protocal.protobuf.aec;
import com.tencent.mm.protocal.protobuf.bfs;
import com.tencent.mm.sdk.platformtools.Log;

public final class o
  extends q
  implements m
{
  private i callback;
  Object data;
  public d rr;
  
  public o(String paramString, bfs parambfs, Object paramObject)
  {
    AppMethodBeat.i(124298);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new aeb();
    ((d.a)localObject).iLO = new aec();
    ((d.a)localObject).uri = "/cgi-bin/mmocbiz-bin/createbizchatinfo";
    ((d.a)localObject).funcId = 1355;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (aeb)this.rr.iLK.iLR;
    ((aeb)localObject).KTt = paramString;
    ((aeb)localObject).Lpw = parambfs;
    this.data = paramObject;
    AppMethodBeat.o(124298);
  }
  
  public final aec baD()
  {
    if ((this.rr != null) && (this.rr.iLL.iLR != null)) {
      return (aec)this.rr.iLL.iLR;
    }
    return null;
  }
  
  public final aeb baE()
  {
    if ((this.rr != null) && (this.rr.iLK.iLR != null)) {
      return (aeb)this.rr.iLK.iLR;
    }
    return null;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(124300);
    this.callback = parami;
    Log.i("MicroMsg.brandservice.NetSceneCreateBizChatInfo", "do scene");
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(124300);
    return i;
  }
  
  public final int getType()
  {
    return 1355;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124299);
    Log.d("MicroMsg.brandservice.NetSceneCreateBizChatInfo", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124299);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.al.a.o
 * JD-Core Version:    0.7.0.1
 */