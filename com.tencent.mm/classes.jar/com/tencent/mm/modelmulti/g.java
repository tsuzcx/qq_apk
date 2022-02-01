package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
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
  private f callback;
  private com.tencent.mm.network.q hON;
  private byte[] ieX;
  public long iet = -1L;
  private int uin = 0;
  
  public g(long paramLong, byte[] paramArrayOfByte)
  {
    this.iet = paramLong;
    this.ieX = paramArrayOfByte;
  }
  
  public g(long paramLong, byte[] paramArrayOfByte, int paramInt)
  {
    this.iet = paramLong;
    this.ieX = paramArrayOfByte;
    this.uin = paramInt;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(132563);
    if (bt.cC(this.ieX))
    {
      ad.e("MicroMsg.NetSceneNotifyData", "dkpush %s", new Object[] { "get keyBuf failed" });
      AppMethodBeat.o(132563);
      return -1;
    }
    if (this.uin == 0) {
      this.hON = new a();
    }
    for (;;)
    {
      ad.i("MicroMsg.NetSceneNotifyData", "doScene now:%d buf:%s", new Object[] { Long.valueOf(this.iet), bt.cA(this.ieX) });
      ((w.a)this.hON.getReqObj()).hWw = this.iet;
      ((w.a)this.hON.getReqObj()).dsR = this.ieX;
      this.callback = paramf;
      int i = dispatch(parame, this.hON, this);
      AppMethodBeat.o(132563);
      return i;
      this.hON = new b();
      ((b)this.hON).uin = this.uin;
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
    private final w.a ieY;
    private final w.b ieZ;
    
    public a()
    {
      AppMethodBeat.i(132560);
      this.ieY = new w.a();
      this.ieZ = new w.b();
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
    private final w.a ieY;
    private final w.b ieZ;
    int uin;
    
    public b()
    {
      AppMethodBeat.i(132561);
      this.ieY = new w.a();
      this.ieZ = new w.b();
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
      this.ieY.setDeviceID(com.tencent.mm.compatible.deviceinfo.q.aay());
      this.ieY.setDeviceType(d.hgH);
      this.ieY.setClientVersion(d.Fnj);
      this.ieY.setUin(this.uin);
      w.a locala = this.ieY;
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
    
    public final void setConnectionInfo(String paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelmulti.g
 * JD-Core Version:    0.7.0.1
 */