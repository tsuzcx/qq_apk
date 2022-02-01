package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bnt;
import com.tencent.mm.protocal.protobuf.bnu;
import java.util.LinkedList;

public final class ac
  extends n
  implements k
{
  private g callback;
  public String hyx;
  public b rr;
  public String tag;
  
  public ac(String paramString, LinkedList<String> paramLinkedList, LinkedList<Integer> paramLinkedList1)
  {
    AppMethodBeat.i(209544);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new bnt();
    ((b.a)localObject).hvu = new bnu();
    ((b.a)localObject).uri = "/cgi-bin/mmkf-bin/kfgetinfolist";
    ((b.a)localObject).funcId = 675;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (bnt)this.rr.hvr.hvw;
    ((bnt)localObject).Fds = paramString;
    ((bnt)localObject).Fdv = paramLinkedList;
    ((bnt)localObject).Fdw = paramLinkedList1;
    this.hyx = paramString;
    AppMethodBeat.o(209544);
  }
  
  public final bnu aCT()
  {
    if ((this.rr != null) && (this.rr.hvs.hvw != null)) {
      return (bnu)this.rr.hvs.hvw;
    }
    return null;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(124142);
    this.callback = paramg;
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneKFGetInfoList", "do scene");
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
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneKFGetInfoList", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124141);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.al.ac
 * JD-Core Version:    0.7.0.1
 */