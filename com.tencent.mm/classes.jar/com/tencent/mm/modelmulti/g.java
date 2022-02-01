package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.o;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.w.a;
import com.tencent.mm.protocal.w.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class g
  extends com.tencent.mm.an.q
  implements m
{
  private i callback;
  private s lCW;
  public long lSG = -1L;
  private byte[] lTj;
  private int uin = 0;
  
  public g(long paramLong, byte[] paramArrayOfByte)
  {
    this.lSG = paramLong;
    this.lTj = paramArrayOfByte;
  }
  
  public g(long paramLong, byte[] paramArrayOfByte, int paramInt)
  {
    this.lSG = paramLong;
    this.lTj = paramArrayOfByte;
    this.uin = paramInt;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(132563);
    if (Util.isNullOrNil(this.lTj))
    {
      Log.e("MicroMsg.NetSceneNotifyData", "dkpush %s", new Object[] { "get keyBuf failed" });
      AppMethodBeat.o(132563);
      return -1;
    }
    if (this.uin == 0) {
      this.lCW = new a();
    }
    for (;;)
    {
      Log.i("MicroMsg.NetSceneNotifyData", "doScene now:%d buf:%s", new Object[] { Long.valueOf(this.lSG), Util.dumpHexBuf(this.lTj) });
      ((w.a)this.lCW.getReqObj()).lKF = this.lSG;
      ((w.a)this.lCW.getReqObj()).fDX = this.lTj;
      this.callback = parami;
      int i = dispatch(paramg, this.lCW, this);
      AppMethodBeat.o(132563);
      return i;
      this.lCW = new b();
      ((b)this.lCW).uin = this.uin;
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
    private final w.a lTk;
    private final w.b lTl;
    
    public a()
    {
      AppMethodBeat.i(132560);
      this.lTk = new w.a();
      this.lTl = new w.b();
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
    private final w.a lTk;
    private final w.b lTl;
    int uin;
    
    public b()
    {
      AppMethodBeat.i(132561);
      this.lTk = new w.a();
      this.lTl = new w.b();
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
      this.lTk.setDeviceID(com.tencent.mm.compatible.deviceinfo.q.auM());
      this.lTk.setDeviceType(d.kQZ);
      this.lTk.setClientVersion(d.RAD);
      this.lTk.setUin(this.uin);
      w.a locala = this.lTk;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelmulti.g
 * JD-Core Version:    0.7.0.1
 */