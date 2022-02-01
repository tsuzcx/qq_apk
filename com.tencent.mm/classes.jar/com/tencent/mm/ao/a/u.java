package com.tencent.mm.ao.a;

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
import com.tencent.mm.protocal.protobuf.clx;
import com.tencent.mm.protocal.protobuf.cly;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class u
  extends q
  implements m
{
  Object bnW;
  private i callback;
  public String lGP;
  public d rr;
  
  public u(String paramString1, String paramString2, LinkedList<String> paramLinkedList, Object paramObject)
  {
    AppMethodBeat.i(124316);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new clx();
    ((d.a)localObject).lBV = new cly();
    ((d.a)localObject).uri = "/cgi-bin/mmocbiz-bin/initiatebizchat";
    ((d.a)localObject).funcId = 1389;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (clx)d.b.b(this.rr.lBR);
    ((clx)localObject).SqC = paramString1;
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    ((clx)localObject).TtJ = paramString1;
    ((clx)localObject).TtK = paramLinkedList;
    this.bnW = paramObject;
    AppMethodBeat.o(124316);
  }
  
  public final cly bjU()
  {
    AppMethodBeat.i(206457);
    if ((this.rr != null) && (d.c.b(this.rr.lBS) != null))
    {
      cly localcly = (cly)d.c.b(this.rr.lBS);
      AppMethodBeat.o(206457);
      return localcly;
    }
    AppMethodBeat.o(206457);
    return null;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(124318);
    this.callback = parami;
    Log.i("MicroMsg.NetSceneInitiateBizChat", "do scene");
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(124318);
    return i;
  }
  
  public final int getType()
  {
    return 1389;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124317);
    Log.d("MicroMsg.NetSceneInitiateBizChat", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124317);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ao.a.u
 * JD-Core Version:    0.7.0.1
 */