package com.tencent.mm.am;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bse;
import com.tencent.mm.protocal.protobuf.bsf;
import java.util.LinkedList;

public final class ad
  extends n
  implements k
{
  private f callback;
  public String hQR;
  public b rr;
  public String tag;
  
  public ad(String paramString, LinkedList<String> paramLinkedList, LinkedList<Integer> paramLinkedList1)
  {
    AppMethodBeat.i(207195);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new bse();
    ((b.a)localObject).hNN = new bsf();
    ((b.a)localObject).uri = "/cgi-bin/mmkf-bin/kfgetinfolist";
    ((b.a)localObject).funcId = 675;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (bse)this.rr.hNK.hNQ;
    ((bse)localObject).GMV = paramString;
    ((bse)localObject).GMY = paramLinkedList;
    ((bse)localObject).GMZ = paramLinkedList1;
    this.hQR = paramString;
    AppMethodBeat.o(207195);
  }
  
  public final bsf aFW()
  {
    if ((this.rr != null) && (this.rr.hNL.hNQ != null)) {
      return (bsf)this.rr.hNL.hNQ;
    }
    return null;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(124142);
    this.callback = paramf;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneKFGetInfoList", "do scene");
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
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneKFGetInfoList", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124141);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.am.ad
 * JD-Core Version:    0.7.0.1
 */