package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.o;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.w.a;
import com.tencent.mm.protocal.w.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class g
  extends com.tencent.mm.ak.q
  implements m
{
  private i callback;
  private s iMO;
  private byte[] jcK;
  public long jcg = -1L;
  private int uin = 0;
  
  public g(long paramLong, byte[] paramArrayOfByte)
  {
    this.jcg = paramLong;
    this.jcK = paramArrayOfByte;
  }
  
  public g(long paramLong, byte[] paramArrayOfByte, int paramInt)
  {
    this.jcg = paramLong;
    this.jcK = paramArrayOfByte;
    this.uin = paramInt;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(132563);
    if (Util.isNullOrNil(this.jcK))
    {
      Log.e("MicroMsg.NetSceneNotifyData", "dkpush %s", new Object[] { "get keyBuf failed" });
      AppMethodBeat.o(132563);
      return -1;
    }
    if (this.uin == 0) {
      this.iMO = new a();
    }
    for (;;)
    {
      Log.i("MicroMsg.NetSceneNotifyData", "doScene now:%d buf:%s", new Object[] { Long.valueOf(this.jcg), Util.dumpHexBuf(this.jcK) });
      ((w.a)this.iMO.getReqObj()).iUm = this.jcg;
      ((w.a)this.iMO.getReqObj()).dLi = this.jcK;
      this.callback = parami;
      int i = dispatch(paramg, this.iMO, this);
      AppMethodBeat.o(132563);
      return i;
      this.iMO = new b();
      ((b)this.iMO).uin = this.uin;
    }
  }
  
  public final int getType()
  {
    return 268369922;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132564);
    Log.i("MicroMsg.NetSceneNotifyData", "onGYNetEnd [%d,%d] %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(132564);
  }
  
  public static final class a
    extends o
  {
    private final w.a jcL;
    private final w.b jcM;
    
    public a()
    {
      AppMethodBeat.i(132560);
      this.jcL = new w.a();
      this.jcM = new w.b();
      AppMethodBeat.o(132560);
    }
    
    public final int getTimeOut()
    {
      return 0;
    }
    
    public final int getType()
    {
      return 268369922;
    }
    
    public final String getUri()
    {
      return null;
    }
  }
  
  public static final class b
    implements s
  {
    private final w.a jcL;
    private final w.b jcM;
    int uin;
    
    public b()
    {
      AppMethodBeat.i(132561);
      this.jcL = new w.a();
      this.jcM = new w.b();
      AppMethodBeat.o(132561);
    }
    
    public final boolean getIsLongPolling()
    {
      return false;
    }
    
    public final boolean getIsUserCmd()
    {
      return false;
    }
    
    public final int getLongPollingTimeout()
    {
      return 0;
    }
    
    public final int getNewExtFlags()
    {
      return 0;
    }
    
    public final int getOptions()
    {
      return 0;
    }
    
    public final l.d getReqObj()
    {
      AppMethodBeat.i(132562);
      this.jcL.setDeviceID(com.tencent.mm.compatible.deviceinfo.q.aoG());
      this.jcL.setDeviceType(d.ics);
      this.jcL.setClientVersion(d.KyO);
      this.jcL.setUin(this.uin);
      w.a locala = this.jcL;
      AppMethodBeat.o(132562);
      return locala;
    }
    
    public final int getTimeOut()
    {
      return 0;
    }
    
    public final byte[] getTransHeader()
    {
      return null;
    }
    
    public final int getType()
    {
      return 268369922;
    }
    
    public final String getUri()
    {
      return null;
    }
    
    public final boolean isSingleSession()
    {
      return true;
    }
    
    public final boolean keepAlive()
    {
      return false;
    }
    
    public final void setConnectionInfo(String paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelmulti.g
 * JD-Core Version:    0.7.0.1
 */