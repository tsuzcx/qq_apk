package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bsy;
import com.tencent.mm.protocal.protobuf.bsz;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;

public final class ad
  extends n
  implements k
{
  private f callback;
  public String hTJ;
  public b rr;
  public String tag;
  
  public ad(String paramString, LinkedList<String> paramLinkedList, LinkedList<Integer> paramLinkedList1)
  {
    AppMethodBeat.i(188893);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new bsy();
    ((b.a)localObject).hQG = new bsz();
    ((b.a)localObject).uri = "/cgi-bin/mmkf-bin/kfgetinfolist";
    ((b.a)localObject).funcId = 675;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (bsy)this.rr.hQD.hQJ;
    ((bsy)localObject).Hgv = paramString;
    ((bsy)localObject).Hgy = paramLinkedList;
    ((bsy)localObject).Hgz = paramLinkedList1;
    this.hTJ = paramString;
    AppMethodBeat.o(188893);
  }
  
  public final bsz aGm()
  {
    if ((this.rr != null) && (this.rr.hQE.hQJ != null)) {
      return (bsz)this.rr.hQE.hQJ;
    }
    return null;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(124142);
    this.callback = paramf;
    ae.i("MicroMsg.NetSceneKFGetInfoList", "do scene");
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
    ae.i("MicroMsg.NetSceneKFGetInfoList", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
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