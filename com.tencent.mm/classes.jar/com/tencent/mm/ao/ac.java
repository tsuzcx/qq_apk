package com.tencent.mm.ao;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.con;
import com.tencent.mm.protocal.protobuf.coo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class ac
  extends q
  implements m
{
  private i callback;
  public String lFl;
  public d rr;
  public String tag;
  
  public ac(String paramString, LinkedList<String> paramLinkedList, LinkedList<Integer> paramLinkedList1)
  {
    AppMethodBeat.i(206340);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new con();
    ((d.a)localObject).lBV = new coo();
    ((d.a)localObject).uri = "/cgi-bin/mmkf-bin/kfgetinfolist";
    ((d.a)localObject).funcId = 675;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (con)d.b.b(this.rr.lBR);
    ((con)localObject).Twt = paramString;
    ((con)localObject).Tww = paramLinkedList;
    ((con)localObject).Twx = paramLinkedList1;
    this.lFl = paramString;
    AppMethodBeat.o(206340);
  }
  
  public final coo bjs()
  {
    AppMethodBeat.i(206342);
    if ((this.rr != null) && (d.c.b(this.rr.lBS) != null))
    {
      coo localcoo = (coo)d.c.b(this.rr.lBS);
      AppMethodBeat.o(206342);
      return localcoo;
    }
    AppMethodBeat.o(206342);
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
 * Qualified Name:     com.tencent.mm.ao.ac
 * JD-Core Version:    0.7.0.1
 */