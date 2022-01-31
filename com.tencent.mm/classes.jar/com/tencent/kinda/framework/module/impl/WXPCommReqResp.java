package com.tencent.kinda.framework.module.impl;

import com.tencent.kinda.gen.KNetworkMockManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k;
import com.tencent.mm.protocal.aa;

public class WXPCommReqResp
  extends k
{
  private int funcId;
  private KNetworkMockManager m_mockMgr;
  private int option;
  private WXPCommReqResp.Req req;
  private WXPCommReqResp.WXPRequestWrapper requestWrapper;
  private WXPCommReqResp.Resp resp;
  private WXPCommReqResp.WXPResponseWrapper responseWrapper;
  private String uri;
  
  public WXPCommReqResp(byte[] paramArrayOfByte, String paramString1, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, int paramInt5, String paramString2, KNetworkMockManager paramKNetworkMockManager)
  {
    AppMethodBeat.i(144574);
    this.req = null;
    this.resp = null;
    this.option = 0;
    this.requestWrapper = new WXPCommReqResp.WXPRequestWrapper(paramArrayOfByte);
    this.responseWrapper = new WXPCommReqResp.WXPResponseWrapper(this);
    this.req = new WXPCommReqResp.Req(this.requestWrapper, paramInt1, paramInt2, paramBoolean, paramInt4, paramInt5, paramString2);
    this.resp = new WXPCommReqResp.Resp(this.responseWrapper, paramInt3, paramBoolean);
    this.uri = paramString1;
    this.funcId = paramInt1;
    this.m_mockMgr = paramKNetworkMockManager;
    AppMethodBeat.o(144574);
  }
  
  public int getOptions()
  {
    return this.option;
  }
  
  public final int getReqCmdId()
  {
    AppMethodBeat.i(144575);
    int i = WXPCommReqResp.Req.access$000(this.req);
    AppMethodBeat.o(144575);
    return i;
  }
  
  protected final WXPCommReqResp.Req getReqObjImp()
  {
    return this.req;
  }
  
  public final WXPCommReqResp.WXPRequestWrapper getRequestProtoBuf()
  {
    AppMethodBeat.i(144577);
    WXPCommReqResp.WXPRequestWrapper localWXPRequestWrapper = WXPCommReqResp.Req.access$200(this.req);
    AppMethodBeat.o(144577);
    return localWXPRequestWrapper;
  }
  
  public final int getRespCmdId()
  {
    AppMethodBeat.i(144576);
    int i = WXPCommReqResp.Resp.access$100(this.resp);
    AppMethodBeat.o(144576);
    return i;
  }
  
  public final WXPCommReqResp.Resp getRespObj()
  {
    return this.resp;
  }
  
  public final WXPCommReqResp.WXPResponseWrapper getResponseProtoBuf()
  {
    AppMethodBeat.i(144578);
    WXPCommReqResp.WXPResponseWrapper localWXPResponseWrapper = WXPCommReqResp.Resp.access$300(this.resp);
    AppMethodBeat.o(144578);
    return localWXPResponseWrapper;
  }
  
  public final int getType()
  {
    return this.funcId;
  }
  
  public final String getUri()
  {
    return this.uri;
  }
  
  public byte[] getWXPReqData()
  {
    AppMethodBeat.i(144580);
    byte[] arrayOfByte = this.requestWrapper.getData();
    AppMethodBeat.o(144580);
    return arrayOfByte;
  }
  
  public byte[] getWXPRespData()
  {
    AppMethodBeat.i(144582);
    byte[] arrayOfByte = this.responseWrapper.getData();
    AppMethodBeat.o(144582);
    return arrayOfByte;
  }
  
  public String getWXPRespNewData()
  {
    AppMethodBeat.i(144584);
    String str = this.responseWrapper.getNewData();
    AppMethodBeat.o(144584);
    return str;
  }
  
  public String resp2Json(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(144586);
    String str = null;
    if (this.m_mockMgr != null) {
      str = this.m_mockMgr.responseDataToJson(paramArrayOfByte);
    }
    AppMethodBeat.o(144586);
    return str;
  }
  
  public void setOptions(int paramInt)
  {
    this.option = paramInt;
  }
  
  public void setRsaInfo(aa paramaa)
  {
    AppMethodBeat.i(144579);
    this.req.setRsaInfo(paramaa);
    AppMethodBeat.o(144579);
  }
  
  public void setWXPReqData(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(144581);
    this.requestWrapper.setData(paramArrayOfByte);
    AppMethodBeat.o(144581);
  }
  
  public void setWXPRespData(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(144583);
    this.responseWrapper.setData(paramArrayOfByte);
    AppMethodBeat.o(144583);
  }
  
  public void setWXPRespNewData(String paramString)
  {
    AppMethodBeat.i(144585);
    this.responseWrapper.setNewData(paramString);
    if (this.m_mockMgr != null) {
      setWXPRespData(this.m_mockMgr.jsonToResponseData(paramString));
    }
    AppMethodBeat.o(144585);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.WXPCommReqResp
 * JD-Core Version:    0.7.0.1
 */