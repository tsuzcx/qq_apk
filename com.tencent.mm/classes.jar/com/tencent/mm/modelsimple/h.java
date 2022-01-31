package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.o;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.p.a;
import com.tencent.mm.protocal.p.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;
import junit.framework.Assert;

public final class h
  extends m
  implements k
{
  private f callback;
  public byte[] content;
  public String fOJ;
  private q ftU;
  
  public h(l.e parame)
  {
    AppMethodBeat.i(16569);
    this.fOJ = "";
    parame = (p.b)parame;
    this.fOJ = parame.fOJ;
    this.content = parame.content;
    AppMethodBeat.o(16569);
  }
  
  public h(List<String> paramList, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(16568);
    this.fOJ = "";
    if ((paramList.size() > 0) && (paramArrayOfByte != null)) {}
    int j;
    String str;
    for (boolean bool1 = true;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      j = (int)(System.currentTimeMillis() / 1000L);
      str = (String)paramList.get(0);
      int i = 1;
      while (i < paramList.size())
      {
        str = str + "," + ((String)paramList.get(i)).trim();
        i += 1;
      }
    }
    this.ftU = new h.a();
    paramList = (p.a)this.ftU.getReqObj();
    paramList.cut = 111;
    paramList.bsY = 0;
    paramList.fQD = j;
    if (str != null)
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      paramList.wiC = str;
      if (paramArrayOfByte == null) {
        break label269;
      }
    }
    label269:
    for (bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      paramList.wiD = paramArrayOfByte;
      ab.d("MicroMsg.NetSceneDirectSend", "NetSceneDirectSend: cmdId=111 seq=".concat(String.valueOf(j)));
      ab.d("MicroMsg.NetSceneDirectSend", "NetSceneDirectSend: lstReceiver=" + str + " status = " + o.r(paramArrayOfByte, 0));
      AppMethodBeat.o(16568);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(16570);
    this.callback = paramf;
    int i = dispatch(parame, this.ftU, this);
    AppMethodBeat.o(16570);
    return i;
  }
  
  public final int getType()
  {
    return 10;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(16571);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(16571);
  }
  
  public final boolean uniqueInNetsceneQueue()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.h
 * JD-Core Version:    0.7.0.1
 */