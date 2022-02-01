package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.h;
import com.tencent.mm.am.n;
import com.tencent.mm.am.p;
import com.tencent.mm.b.o;
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

public final class l
  extends p
  implements m
{
  private h callback;
  public byte[] hVd;
  public String oSj;
  private s ouH;
  
  public l(l.e parame)
  {
    AppMethodBeat.i(20614);
    this.oSj = "";
    parame = (p.b)parame;
    this.oSj = parame.oSj;
    this.hVd = parame.hVd;
    AppMethodBeat.o(20614);
  }
  
  public l(List<String> paramList, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20613);
    this.oSj = "";
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
    this.ouH = new a();
    paramList = (p.a)this.ouH.getReqObj();
    paramList.hId = 111;
    paramList.eQp = 0;
    paramList.oUj = j;
    if (str != null)
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      paramList.Yyh = str;
      if (paramArrayOfByte == null) {
        break label273;
      }
    }
    label273:
    for (bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      paramList.Yyi = paramArrayOfByte;
      Log.d("MicroMsg.NetSceneDirectSend", "NetSceneDirectSend: cmdId=111 seq=" + j);
      Log.d("MicroMsg.NetSceneDirectSend", "NetSceneDirectSend: lstReceiver=" + str + " status = " + o.t(paramArrayOfByte, 0));
      AppMethodBeat.o(20613);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(20615);
    this.callback = paramh;
    int i = dispatch(paramg, this.ouH, this);
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
    extends n
  {
    private final p.a oSk;
    private final p.b oSl;
    
    public a()
    {
      AppMethodBeat.i(20612);
      this.oSk = new p.a();
      this.oSl = new p.b();
      AppMethodBeat.o(20612);
    }
    
    public final l.d getReqObjImp()
    {
      return this.oSk;
    }
    
    public final l.e getRespObj()
    {
      return this.oSl;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsimple.l
 * JD-Core Version:    0.7.0.1
 */