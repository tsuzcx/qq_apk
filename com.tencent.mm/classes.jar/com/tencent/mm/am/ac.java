package com.tencent.mm.am;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bjz;
import com.tencent.mm.protocal.protobuf.bka;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class ac
  extends n
  implements k
{
  private g callback;
  public String gXY;
  public b rr;
  public String tag;
  
  public ac(String paramString, LinkedList<String> paramLinkedList, LinkedList<Integer> paramLinkedList1)
  {
    AppMethodBeat.i(191068);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new bjz();
    ((b.a)localObject).gUV = new bka();
    ((b.a)localObject).uri = "/cgi-bin/mmkf-bin/kfgetinfolist";
    ((b.a)localObject).funcId = 675;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (bjz)this.rr.gUS.gUX;
    ((bjz)localObject).DHX = paramString;
    ((bjz)localObject).DIa = paramLinkedList;
    ((bjz)localObject).DIb = paramLinkedList1;
    this.gXY = paramString;
    AppMethodBeat.o(191068);
  }
  
  public final bka awb()
  {
    if ((this.rr != null) && (this.rr.gUT.gUX != null)) {
      return (bka)this.rr.gUT.gUX;
    }
    return null;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(124142);
    this.callback = paramg;
    ad.i("MicroMsg.NetSceneKFGetInfoList", "do scene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(124142);
    return i;
  }
  
  public final int getType()
  {
    return 675;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124141);
    ad.i("MicroMsg.NetSceneKFGetInfoList", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124141);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.am.ac
 * JD-Core Version:    0.7.0.1
 */