package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.p.a;
import com.tencent.mm.protocal.p.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import junit.framework.Assert;

public final class j
  extends q
  implements m
{
  private i callback;
  public byte[] fPk;
  private s lCW;
  public String lZa;
  
  public j(l.e parame)
  {
    AppMethodBeat.i(20614);
    this.lZa = "";
    parame = (p.b)parame;
    this.lZa = parame.lZa;
    this.fPk = parame.fPk;
    AppMethodBeat.o(20614);
  }
  
  public j(List<String> paramList, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20613);
    this.lZa = "";
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
    this.lCW = new a();
    paramList = (p.a)this.lCW.getReqObj();
    paramList.fDn = 111;
    paramList.cUP = 0;
    paramList.mbp = j;
    if (str != null)
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      paramList.RBE = str;
      if (paramArrayOfByte == null) {
        break label276;
      }
    }
    label276:
    for (bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      paramList.RBF = paramArrayOfByte;
      Log.d("MicroMsg.NetSceneDirectSend", "NetSceneDirectSend: cmdId=111 seq=" + j);
      Log.d("MicroMsg.NetSceneDirectSend", "NetSceneDirectSend: lstReceiver=" + str + " status = " + com.tencent.mm.b.o.v(paramArrayOfByte, 0));
      AppMethodBeat.o(20613);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(20615);
    this.callback = parami;
    int i = dispatch(paramg, this.lCW, this);
    AppMethodBeat.o(20615);
    return i;
  }
  
  public final int getType()
  {
    return 10;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
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
    extends com.tencent.mm.an.o
  {
    private final p.a lZb;
    private final p.b lZc;
    
    public a()
    {
      AppMethodBeat.i(20612);
      this.lZb = new p.a();
      this.lZc = new p.b();
      AppMethodBeat.o(20612);
    }
    
    public final l.d getReqObjImp()
    {
      return this.lZb;
    }
    
    public final l.e getRespObj()
    {
      return this.lZc;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.j
 * JD-Core Version:    0.7.0.1
 */