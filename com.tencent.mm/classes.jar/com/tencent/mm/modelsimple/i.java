package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.l;
import com.tencent.mm.al.n;
import com.tencent.mm.b.o;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.p.a;
import com.tencent.mm.protocal.p.b;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.List;
import junit.framework.Assert;

public final class i
  extends n
  implements k
{
  private f callback;
  public byte[] content;
  private q hON;
  public String ild;
  
  public i(l.e parame)
  {
    AppMethodBeat.i(20614);
    this.ild = "";
    parame = (p.b)parame;
    this.ild = parame.ild;
    this.content = parame.content;
    AppMethodBeat.o(20614);
  }
  
  public i(List<String> paramList, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20613);
    this.ild = "";
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
    this.hON = new a();
    paramList = (p.a)this.hON.getReqObj();
    paramList.dsi = 111;
    paramList.dDp = 0;
    paramList.inh = j;
    if (str != null)
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      paramList.Fof = str;
      if (paramArrayOfByte == null) {
        break label269;
      }
    }
    label269:
    for (bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      paramList.Fog = paramArrayOfByte;
      ad.d("MicroMsg.NetSceneDirectSend", "NetSceneDirectSend: cmdId=111 seq=".concat(String.valueOf(j)));
      ad.d("MicroMsg.NetSceneDirectSend", "NetSceneDirectSend: lstReceiver=" + str + " status = " + o.t(paramArrayOfByte, 0));
      AppMethodBeat.o(20613);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(20615);
    this.callback = paramf;
    int i = dispatch(parame, this.hON, this);
    AppMethodBeat.o(20615);
    return i;
  }
  
  public final int getType()
  {
    return 10;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20616);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20616);
  }
  
  public final boolean uniqueInNetsceneQueue()
  {
    return true;
  }
  
  public static final class a
    extends l
  {
    private final p.a ile;
    private final p.b ilf;
    
    public a()
    {
      AppMethodBeat.i(20612);
      this.ile = new p.a();
      this.ilf = new p.b();
      AppMethodBeat.o(20612);
    }
    
    public final l.d getReqObjImp()
    {
      return this.ile;
    }
    
    public final l.e getRespObj()
    {
      return this.ilf;
    }
    
    public final int getType()
    {
      return 10;
    }
    
    public final String getUri()
    {
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelsimple.i
 * JD-Core Version:    0.7.0.1
 */