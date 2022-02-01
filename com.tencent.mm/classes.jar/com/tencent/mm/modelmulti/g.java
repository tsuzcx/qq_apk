package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.l;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.w.a;
import com.tencent.mm.protocal.w.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class g
  extends n
  implements k
{
  private com.tencent.mm.ak.g callback;
  public long hLz = -1L;
  private byte[] hMd;
  private com.tencent.mm.network.q hwy;
  private int uin = 0;
  
  public g(long paramLong, byte[] paramArrayOfByte)
  {
    this.hLz = paramLong;
    this.hMd = paramArrayOfByte;
  }
  
  public g(long paramLong, byte[] paramArrayOfByte, int paramInt)
  {
    this.hLz = paramLong;
    this.hMd = paramArrayOfByte;
    this.uin = paramInt;
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(132563);
    if (bs.cv(this.hMd))
    {
      ac.e("MicroMsg.NetSceneNotifyData", "dkpush %s", new Object[] { "get keyBuf failed" });
      AppMethodBeat.o(132563);
      return -1;
    }
    if (this.uin == 0) {
      this.hwy = new a();
    }
    for (;;)
    {
      ac.i("MicroMsg.NetSceneNotifyData", "doScene now:%d buf:%s", new Object[] { Long.valueOf(this.hLz), bs.ct(this.hMd) });
      ((w.a)this.hwy.getReqObj()).hDR = this.hLz;
      ((w.a)this.hwy.getReqObj()).dht = this.hMd;
      this.callback = paramg;
      int i = dispatch(parame, this.hwy, this);
      AppMethodBeat.o(132563);
      return i;
      this.hwy = new b();
      ((b)this.hwy).uin = this.uin;
    }
  }
  
  public final int getType()
  {
    return 268369922;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132564);
    ac.i("MicroMsg.NetSceneNotifyData", "onGYNetEnd [%d,%d] %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(132564);
  }
  
  public static final class a
    extends l
  {
    private final w.a hMe;
    private final w.b hMf;
    
    public a()
    {
      AppMethodBeat.i(132560);
      this.hMe = new w.a();
      this.hMf = new w.b();
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
    private final w.a hMe;
    private final w.b hMf;
    int uin;
    
    public b()
    {
      AppMethodBeat.i(132561);
      this.hMe = new w.a();
      this.hMf = new w.b();
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
      this.hMe.setDeviceID(com.tencent.mm.compatible.deviceinfo.q.XX());
      this.hMe.setDeviceType(d.gMK);
      this.hMe.setClientVersion(d.DIc);
      this.hMe.setUin(this.uin);
      w.a locala = this.hMe;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelmulti.g
 * JD-Core Version:    0.7.0.1
 */