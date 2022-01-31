package com.tencent.mm.aj;

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
import com.tencent.mm.protocal.protobuf.ayr;
import com.tencent.mm.protocal.protobuf.ays;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class w
  extends m
  implements k
{
  private f callback;
  public String fwO;
  public int fwP;
  public b rr;
  public String tag;
  
  public w(String paramString, LinkedList<String> paramLinkedList)
  {
    this(paramString, paramLinkedList, (byte)0);
  }
  
  private w(String paramString, LinkedList<String> paramLinkedList, byte paramByte)
  {
    AppMethodBeat.i(11455);
    this.fwP = 1;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new ayr();
    ((b.a)localObject).fsY = new ays();
    ((b.a)localObject).uri = "/cgi-bin/mmkf-bin/kfgetinfolist";
    ((b.a)localObject).funcId = 675;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (ayr)this.rr.fsV.fta;
    ((ayr)localObject).xok = paramString;
    ((ayr)localObject).xon = paramLinkedList;
    this.fwO = paramString;
    this.fwP = 1;
    AppMethodBeat.o(11455);
  }
  
  public final ays aff()
  {
    if ((this.rr != null) && (this.rr.fsW.fta != null)) {
      return (ays)this.rr.fsW.fta;
    }
    return null;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(11457);
    this.callback = paramf;
    ab.i("MicroMsg.NetSceneKFGetInfoList", "do scene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(11457);
    return i;
  }
  
  public final int getType()
  {
    return 675;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(11456);
    ab.i("MicroMsg.NetSceneKFGetInfoList", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(11456);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.aj.w
 * JD-Core Version:    0.7.0.1
 */