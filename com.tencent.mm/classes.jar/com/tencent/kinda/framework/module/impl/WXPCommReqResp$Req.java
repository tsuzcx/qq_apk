package com.tencent.kinda.framework.module.impl;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.sdk.platformtools.bo;

public final class WXPCommReqResp$Req
  extends l.d
  implements l.b
{
  private int cmdId;
  private int funcId;
  private boolean needHeader;
  private WXPCommReqResp.WXPRequestWrapper rImpl;
  
  public WXPCommReqResp$Req(WXPCommReqResp.WXPRequestWrapper paramWXPRequestWrapper, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.rImpl = paramWXPRequestWrapper;
    this.funcId = paramInt1;
    this.cmdId = paramInt2;
    this.needHeader = paramBoolean;
  }
  
  public WXPCommReqResp$Req(WXPCommReqResp.WXPRequestWrapper paramWXPRequestWrapper, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4, String paramString)
  {
    AppMethodBeat.i(144571);
    this.rImpl = paramWXPRequestWrapper;
    this.funcId = paramInt1;
    this.cmdId = paramInt2;
    this.needHeader = paramBoolean;
    setRouteInfo(bo.getInt(paramString, 0));
    AppMethodBeat.o(144571);
  }
  
  public final int getCmdId()
  {
    return this.cmdId;
  }
  
  public final int getFuncId()
  {
    return this.funcId;
  }
  
  public final WXPCommReqResp.WXPRequestWrapper getImpl()
  {
    return this.rImpl;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(144572);
    byte[] arrayOfByte = this.rImpl.getData();
    AppMethodBeat.o(144572);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.WXPCommReqResp.Req
 * JD-Core Version:    0.7.0.1
 */