package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.h;
import com.tencent.mm.am.n;
import com.tencent.mm.am.p;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.w.a;
import com.tencent.mm.protocal.w.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class l
  extends p
  implements m
{
  private h callback;
  public long oLz = -1L;
  private byte[] oMc;
  private s ouH;
  private int uin = 0;
  
  public l(long paramLong, byte[] paramArrayOfByte)
  {
    this.oLz = paramLong;
    this.oMc = paramArrayOfByte;
  }
  
  public l(long paramLong, byte[] paramArrayOfByte, int paramInt)
  {
    this.oLz = paramLong;
    this.oMc = paramArrayOfByte;
    this.uin = paramInt;
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(132563);
    if (Util.isNullOrNil(this.oMc))
    {
      Log.e("MicroMsg.NetSceneNotifyData", "dkpush %s", new Object[] { "get keyBuf failed" });
      AppMethodBeat.o(132563);
      return -1;
    }
    if (this.uin == 0) {
      this.ouH = new a();
    }
    for (;;)
    {
      Log.i("MicroMsg.NetSceneNotifyData", "doScene now:%d buf:%s", new Object[] { Long.valueOf(this.oLz), Util.dumpHexBuf(this.oMc) });
      ((w.a)this.ouH.getReqObj()).oDh = this.oLz;
      ((w.a)this.ouH.getReqObj()).hIN = this.oMc;
      this.callback = paramh;
      int i = dispatch(paramg, this.ouH, this);
      AppMethodBeat.o(132563);
      return i;
      this.ouH = new b();
      ((b)this.ouH).uin = this.uin;
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
    extends n
  {
    private final w.a oMd;
    private final w.b oMe;
    
    public a()
    {
      AppMethodBeat.i(132560);
      this.oMd = new w.a();
      this.oMe = new w.b();
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
    private final w.a oMd;
    private final w.b oMe;
    int uin;
    
    public b()
    {
      AppMethodBeat.i(132561);
      this.oMd = new w.a();
      this.oMe = new w.b();
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
      this.oMd.setDeviceID(q.aPg());
      this.oMd.setDeviceType(d.nsC);
      this.oMd.setClientVersion(d.Yxh);
      this.oMd.setUin(this.uin);
      w.a locala = this.oMd;
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
 * Qualified Name:     com.tencent.mm.modelmulti.l
 * JD-Core Version:    0.7.0.1
 */