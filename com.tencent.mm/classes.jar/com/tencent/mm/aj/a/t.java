package com.tencent.mm.aj.a;

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
import com.tencent.mm.protocal.protobuf.awl;
import com.tencent.mm.protocal.protobuf.awm;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class t
  extends m
  implements k
{
  private f callback;
  Object data;
  public String fye;
  public b rr;
  
  public t(String paramString1, String paramString2, LinkedList<String> paramLinkedList, Object paramObject)
  {
    AppMethodBeat.i(11630);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new awl();
    ((b.a)localObject).fsY = new awm();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/initiatebizchat";
    ((b.a)localObject).funcId = 1389;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (awl)this.rr.fsV.fta;
    ((awl)localObject).wOf = paramString1;
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    ((awl)localObject).xlW = paramString1;
    ((awl)localObject).xlX = paramLinkedList;
    this.data = paramObject;
    AppMethodBeat.o(11630);
  }
  
  public final awm afF()
  {
    if ((this.rr != null) && (this.rr.fsW.fta != null)) {
      return (awm)this.rr.fsW.fta;
    }
    return null;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(11632);
    this.callback = paramf;
    ab.i("MicroMsg.NetSceneInitiateBizChat", "do scene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(11632);
    return i;
  }
  
  public final int getType()
  {
    return 1389;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(11631);
    ab.d("MicroMsg.NetSceneInitiateBizChat", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(11631);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.aj.a.t
 * JD-Core Version:    0.7.0.1
 */