package com.tencent.mm.an.a;

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
import com.tencent.mm.protocal.protobuf.dci;
import com.tencent.mm.protocal.protobuf.dcj;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class u
  extends p
  implements m
{
  private h callback;
  Object cpt;
  public String oyw;
  public c rr;
  
  public u(String paramString1, String paramString2, LinkedList<String> paramLinkedList, Object paramObject)
  {
    AppMethodBeat.i(124316);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new dci();
    ((c.a)localObject).otF = new dcj();
    ((c.a)localObject).uri = "/cgi-bin/mmocbiz-bin/initiatebizchat";
    ((c.a)localObject).funcId = 1389;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (dci)c.b.b(this.rr.otB);
    ((dci)localObject).ZpC = paramString1;
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    ((dci)localObject).aaIh = paramString1;
    ((dci)localObject).aaIi = paramLinkedList;
    this.cpt = paramObject;
    AppMethodBeat.o(124316);
  }
  
  public final dcj bHG()
  {
    AppMethodBeat.i(239503);
    if ((this.rr != null) && (c.c.b(this.rr.otC) != null))
    {
      dcj localdcj = (dcj)c.c.b(this.rr.otC);
      AppMethodBeat.o(239503);
      return localdcj;
    }
    AppMethodBeat.o(239503);
    return null;
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(124318);
    this.callback = paramh;
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
 * Qualified Name:     com.tencent.mm.an.a.u
 * JD-Core Version:    0.7.0.1
 */