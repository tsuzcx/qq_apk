package com.tencent.mm.an;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dfh;
import com.tencent.mm.protocal.protobuf.dfi;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class ac
  extends p
  implements m
{
  private h callback;
  public String owR;
  public c rr;
  public String tag;
  
  public ac(String paramString, LinkedList<String> paramLinkedList, LinkedList<Integer> paramLinkedList1)
  {
    AppMethodBeat.i(239427);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new dfh();
    ((c.a)localObject).otF = new dfi();
    ((c.a)localObject).uri = "/cgi-bin/mmkf-bin/kfgetinfolist";
    ((c.a)localObject).funcId = 675;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (dfh)c.b.b(this.rr.otB);
    ((dfh)localObject).aaLa = paramString;
    ((dfh)localObject).aaLd = paramLinkedList;
    ((dfh)localObject).aaLe = paramLinkedList1;
    this.owR = paramString;
    AppMethodBeat.o(239427);
  }
  
  public final dfi bHc()
  {
    AppMethodBeat.i(239435);
    if ((this.rr != null) && (c.c.b(this.rr.otC) != null))
    {
      dfi localdfi = (dfi)c.c.b(this.rr.otC);
      AppMethodBeat.o(239435);
      return localdfi;
    }
    AppMethodBeat.o(239435);
    return null;
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(124142);
    this.callback = paramh;
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
 * Qualified Name:     com.tencent.mm.an.ac
 * JD-Core Version:    0.7.0.1
 */