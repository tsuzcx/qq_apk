package com.tencent.kinda.framework.module.impl;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.e;

public final class WXPCommReqResp$Resp
  extends l.e
  implements l.c
{
  private int cmdId;
  private boolean needHeader;
  private WXPCommReqResp.WXPResponseWrapper rImpl = null;
  
  public WXPCommReqResp$Resp(WXPCommReqResp.WXPResponseWrapper paramWXPResponseWrapper, int paramInt, boolean paramBoolean)
  {
    this.rImpl = paramWXPResponseWrapper;
    this.cmdId = paramInt;
    this.needHeader = paramBoolean;
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(144573);
    this.rImpl.setData(paramArrayOfByte);
    AppMethodBeat.o(144573);
    return 0;
  }
  
  public final int getCmdId()
  {
    return this.cmdId;
  }
  
  public final WXPCommReqResp.WXPResponseWrapper getResponseWrapper()
  {
    return this.rImpl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.WXPCommReqResp.Resp
 * JD-Core Version:    0.7.0.1
 */