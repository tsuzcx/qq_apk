package com.tencent.mm.modelsimple;

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
import com.tencent.mm.protocal.protobuf.ef;
import com.tencent.mm.protocal.protobuf.euu;
import com.tencent.mm.protocal.protobuf.euv;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class ac
  extends q
  implements m
{
  private i callback;
  private final d rr;
  
  public ac(String paramString, int paramInt, LinkedList<ef> paramLinkedList)
  {
    AppMethodBeat.i(150960);
    Log.i("MicroMsg.NetSceneTranslateLink", "ticket link = " + paramString + "; scene = " + paramInt);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new euu();
    ((d.a)localObject).lBV = new euv();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/translatelink";
    ((d.a)localObject).funcId = 1200;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (euu)d.b.b(this.rr.lBR);
    ((euu)localObject).link = paramString;
    ((euu)localObject).scene = paramInt;
    ((euu)localObject).Uwx = paramLinkedList;
    AppMethodBeat.o(150960);
  }
  
  public final String boS()
  {
    AppMethodBeat.i(241996);
    Object localObject = (euv)d.c.b(this.rr.lBS);
    if (localObject == null)
    {
      AppMethodBeat.o(241996);
      return null;
    }
    localObject = ((euv)localObject).Uwy;
    AppMethodBeat.o(241996);
    return localObject;
  }
  
  public final euv boT()
  {
    AppMethodBeat.i(241999);
    if ((this.rr != null) && (d.c.b(this.rr.lBS) != null))
    {
      euv localeuv = (euv)d.c.b(this.rr.lBS);
      AppMethodBeat.o(241999);
      return localeuv;
    }
    AppMethodBeat.o(241999);
    return null;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(150961);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(150961);
    return i;
  }
  
  public final int getType()
  {
    return 1200;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150962);
    Log.d("MicroMsg.NetSceneTranslateLink", "swap deep link with ticket onGYNetEnd:[%d,%d,%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(150962);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelsimple.ac
 * JD-Core Version:    0.7.0.1
 */