package com.tencent.kinda.framework.module.impl;

import com.tencent.kinda.gen.KNetworkMockManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.l;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.sdk.platformtools.bs;

public class WXPCommReqResp
  extends l
{
  private int funcId;
  private KNetworkMockManager m_mockMgr;
  private int option;
  private Req req;
  private WXPRequestWrapper requestWrapper;
  private Resp resp;
  private WXPResponseWrapper responseWrapper;
  private String uri;
  
  public WXPCommReqResp(byte[] paramArrayOfByte, String paramString1, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, int paramInt5, String paramString2, KNetworkMockManager paramKNetworkMockManager)
  {
    AppMethodBeat.i(18685);
    this.req = null;
    this.resp = null;
    this.option = 0;
    this.requestWrapper = new WXPRequestWrapper(paramArrayOfByte);
    this.responseWrapper = new WXPResponseWrapper();
    this.req = new Req(this.requestWrapper, paramInt1, paramInt2, paramBoolean, paramInt4, paramInt5, paramString2);
    this.resp = new Resp(this.responseWrapper, paramInt3, paramBoolean);
    this.uri = paramString1;
    this.funcId = paramInt1;
    this.m_mockMgr = paramKNetworkMockManager;
    AppMethodBeat.o(18685);
  }
  
  public int getOptions()
  {
    return this.option;
  }
  
  public final int getReqCmdId()
  {
    AppMethodBeat.i(18686);
    int i = this.req.cmdId;
    AppMethodBeat.o(18686);
    return i;
  }
  
  protected final Req getReqObjImp()
  {
    return this.req;
  }
  
  public final WXPRequestWrapper getRequestProtoBuf()
  {
    AppMethodBeat.i(18688);
    WXPRequestWrapper localWXPRequestWrapper = this.req.rImpl;
    AppMethodBeat.o(18688);
    return localWXPRequestWrapper;
  }
  
  public final int getRespCmdId()
  {
    AppMethodBeat.i(18687);
    int i = this.resp.cmdId;
    AppMethodBeat.o(18687);
    return i;
  }
  
  public final Resp getRespObj()
  {
    return this.resp;
  }
  
  public final WXPResponseWrapper getResponseProtoBuf()
  {
    AppMethodBeat.i(18689);
    WXPResponseWrapper localWXPResponseWrapper = this.resp.rImpl;
    AppMethodBeat.o(18689);
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
    AppMethodBeat.i(18691);
    byte[] arrayOfByte = this.requestWrapper.getData();
    AppMethodBeat.o(18691);
    return arrayOfByte;
  }
  
  public byte[] getWXPRespData()
  {
    AppMethodBeat.i(18693);
    byte[] arrayOfByte = this.responseWrapper.getData();
    AppMethodBeat.o(18693);
    return arrayOfByte;
  }
  
  public String getWXPRespNewData()
  {
    AppMethodBeat.i(18695);
    String str = this.responseWrapper.getNewData();
    AppMethodBeat.o(18695);
    return str;
  }
  
  public String resp2Json(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(18697);
    String str = null;
    if (this.m_mockMgr != null) {
      str = this.m_mockMgr.responseDataToJson(paramArrayOfByte);
    }
    AppMethodBeat.o(18697);
    return str;
  }
  
  public void setOptions(int paramInt)
  {
    this.option = paramInt;
  }
  
  public void setRsaInfo(ac paramac)
  {
    AppMethodBeat.i(18690);
    this.req.setRsaInfo(paramac);
    AppMethodBeat.o(18690);
  }
  
  public void setWXPReqData(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(18692);
    this.requestWrapper.setData(paramArrayOfByte);
    AppMethodBeat.o(18692);
  }
  
  public void setWXPRespData(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(18694);
    this.responseWrapper.setData(paramArrayOfByte);
    AppMethodBeat.o(18694);
  }
  
  public void setWXPRespNewData(String paramString)
  {
    AppMethodBeat.i(18696);
    this.responseWrapper.setNewData(paramString);
    if (this.m_mockMgr != null) {
      setWXPRespData(this.m_mockMgr.jsonToResponseData(paramString));
    }
    AppMethodBeat.o(18696);
  }
  
  public static final class Req
    extends l.d
    implements l.b
  {
    private int cmdId;
    private int funcId;
    private boolean needHeader;
    private WXPCommReqResp.WXPRequestWrapper rImpl;
    
    public Req(WXPCommReqResp.WXPRequestWrapper paramWXPRequestWrapper, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      this.rImpl = paramWXPRequestWrapper;
      this.funcId = paramInt1;
      this.cmdId = paramInt2;
      this.needHeader = paramBoolean;
    }
    
    public Req(WXPCommReqResp.WXPRequestWrapper paramWXPRequestWrapper, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4, String paramString)
    {
      AppMethodBeat.i(18682);
      this.rImpl = paramWXPRequestWrapper;
      this.funcId = paramInt1;
      this.cmdId = paramInt2;
      this.needHeader = paramBoolean;
      setRouteInfo(bs.getInt(paramString, 0));
      AppMethodBeat.o(18682);
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
      AppMethodBeat.i(18683);
      byte[] arrayOfByte = this.rImpl.getData();
      AppMethodBeat.o(18683);
      return arrayOfByte;
    }
  }
  
  public static final class Resp
    extends l.e
    implements l.c
  {
    private int cmdId;
    private boolean needHeader;
    private WXPCommReqResp.WXPResponseWrapper rImpl = null;
    
    public Resp(WXPCommReqResp.WXPResponseWrapper paramWXPResponseWrapper, int paramInt, boolean paramBoolean)
    {
      this.rImpl = paramWXPResponseWrapper;
      this.cmdId = paramInt;
      this.needHeader = paramBoolean;
    }
    
    public final int fromProtoBuf(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(18684);
      this.rImpl.setData(paramArrayOfByte);
      AppMethodBeat.o(18684);
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
  
  public static final class WXPRequestWrapper
  {
    private byte[] data;
    
    public WXPRequestWrapper() {}
    
    public WXPRequestWrapper(byte[] paramArrayOfByte)
    {
      this.data = paramArrayOfByte;
    }
    
    public final byte[] getData()
    {
      return this.data;
    }
    
    public final void setData(byte[] paramArrayOfByte)
    {
      this.data = paramArrayOfByte;
    }
  }
  
  public class WXPResponseWrapper
  {
    private byte[] data;
    private String newData = null;
    
    public WXPResponseWrapper() {}
    
    public byte[] getData()
    {
      return this.data;
    }
    
    public String getNewData()
    {
      return this.newData;
    }
    
    public void setData(byte[] paramArrayOfByte)
    {
      this.data = paramArrayOfByte;
    }
    
    public void setNewData(String paramString)
    {
      this.newData = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.WXPCommReqResp
 * JD-Core Version:    0.7.0.1
 */