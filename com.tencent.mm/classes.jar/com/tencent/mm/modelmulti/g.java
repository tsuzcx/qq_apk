package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.l;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.w.a;
import com.tencent.mm.protocal.w.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class g
  extends n
  implements k
{
  private com.tencent.mm.al.g callback;
  private com.tencent.mm.network.q gVZ;
  public long hkW = -1L;
  private byte[] hlA;
  private int uin = 0;
  
  public g(long paramLong, byte[] paramArrayOfByte)
  {
    this.hkW = paramLong;
    this.hlA = paramArrayOfByte;
  }
  
  public g(long paramLong, byte[] paramArrayOfByte, int paramInt)
  {
    this.hkW = paramLong;
    this.hlA = paramArrayOfByte;
    this.uin = paramInt;
  }
  
  public final int doScene(e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(132563);
    if (bt.cw(this.hlA))
    {
      ad.e("MicroMsg.NetSceneNotifyData", "dkpush %s", new Object[] { "get keyBuf failed" });
      AppMethodBeat.o(132563);
      return -1;
    }
    if (this.uin == 0) {
      this.gVZ = new a();
    }
    for (;;)
    {
      ad.i("MicroMsg.NetSceneNotifyData", "doScene now:%d buf:%s", new Object[] { Long.valueOf(this.hkW), bt.cu(this.hlA) });
      ((w.a)this.gVZ.getReqObj()).hdo = this.hkW;
      ((w.a)this.gVZ.getReqObj()).djY = this.hlA;
      this.callback = paramg;
      int i = dispatch(parame, this.gVZ, this);
      AppMethodBeat.o(132563);
      return i;
      this.gVZ = new b();
      ((b)this.gVZ).uin = this.uin;
    }
  }
  
  public final int getType()
  {
    return 268369922;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132564);
    ad.i("MicroMsg.NetSceneNotifyData", "onGYNetEnd [%d,%d] %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(132564);
  }
  
  public static final class a
    extends l
  {
    private final w.a hlB;
    private final w.b hlC;
    
    public a()
    {
      AppMethodBeat.i(132560);
      this.hlB = new w.a();
      this.hlC = new w.b();
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
    implements com.tencent.mm.network.q
  {
    private final w.a hlB;
    private final w.b hlC;
    int uin;
    
    public b()
    {
      AppMethodBeat.i(132561);
      this.hlB = new w.a();
      this.hlC = new w.b();
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
    
    public final int getOptions()
    {
      return 0;
    }
    
    public final l.d getReqObj()
    {
      AppMethodBeat.i(132562);
      this.hlB.setDeviceID(com.tencent.mm.compatible.deviceinfo.q.Xa());
      this.hlB.setDeviceType(d.glX);
      this.hlB.setClientVersion(d.CpK);
      this.hlB.setUin(this.uin);
      w.a locala = this.hlB;
      AppMethodBeat.o(132562);
      return locala;
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
    
    public final boolean isSingleSession()
    {
      return true;
    }
    
    public final void setConnectionInfo(String paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelmulti.g
 * JD-Core Version:    0.7.0.1
 */