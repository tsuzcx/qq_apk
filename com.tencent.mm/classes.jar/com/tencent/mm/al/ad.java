package com.tencent.mm.al;

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
import com.tencent.mm.protocal.protobuf.cfr;
import com.tencent.mm.protocal.protobuf.cfs;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class ad
  extends q
  implements m
{
  public String brandUsername;
  private i callback;
  public d rr;
  public String tag;
  
  public ad(String paramString, LinkedList<String> paramLinkedList, LinkedList<Integer> paramLinkedList1)
  {
    AppMethodBeat.i(212186);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new cfr();
    ((d.a)localObject).iLO = new cfs();
    ((d.a)localObject).uri = "/cgi-bin/mmkf-bin/kfgetinfolist";
    ((d.a)localObject).funcId = 675;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (cfr)this.rr.iLK.iLR;
    ((cfr)localObject).MlA = paramString;
    ((cfr)localObject).MlD = paramLinkedList;
    ((cfr)localObject).MlE = paramLinkedList1;
    this.brandUsername = paramString;
    AppMethodBeat.o(212186);
  }
  
  public final cfs bae()
  {
    if ((this.rr != null) && (this.rr.iLL.iLR != null)) {
      return (cfs)this.rr.iLL.iLR;
    }
    return null;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(124142);
    this.callback = parami;
    Log.i("MicroMsg.NetSceneKFGetInfoList", "do scene");
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(124142);
    return i;
  }
  
  public final int getType()
  {
    return 675;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124141);
    Log.i("MicroMsg.NetSceneKFGetInfoList", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124141);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.al.ad
 * JD-Core Version:    0.7.0.1
 */