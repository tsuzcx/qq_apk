package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.ckq;
import com.tencent.mm.protocal.protobuf.cld;
import com.tencent.mm.protocal.protobuf.ctq;
import com.tencent.mm.sdk.platformtools.bt;

public final class b
  extends l
{
  private int funcId;
  public b gUS;
  public c gUT;
  private boolean longPolling;
  private int longPollingTimeout;
  public int option;
  private int timeout;
  private String uri;
  
  private b(a parama1, a parama2, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, int paramInt4, int paramInt5, boolean paramBoolean2, int paramInt6)
  {
    AppMethodBeat.i(202263);
    this.gUS = null;
    this.gUT = null;
    this.option = 0;
    if ((paramBoolean1) && ((parama1 instanceof ckq))) {}
    for (boolean bool = true;; bool = false)
    {
      this.gUS = new b(parama1, paramInt1, paramInt2, bool, paramInt5);
      this.gUT = new c(parama2, paramInt3, paramBoolean1);
      this.uri = paramString;
      this.funcId = paramInt1;
      this.timeout = paramInt4;
      this.longPolling = paramBoolean2;
      this.longPollingTimeout = paramInt6;
      AppMethodBeat.o(202263);
      return;
    }
  }
  
  public final a auL()
  {
    return this.gUS.gUX;
  }
  
  public final a auM()
  {
    return this.gUT.gUX;
  }
  
  public final boolean getIsLongPolling()
  {
    return this.longPolling;
  }
  
  public final int getLongPollingTimeout()
  {
    return this.longPollingTimeout;
  }
  
  public final int getOptions()
  {
    return this.option;
  }
  
  public final int getTimeOut()
  {
    return this.timeout;
  }
  
  public final int getType()
  {
    return this.funcId;
  }
  
  public final String getUri()
  {
    return this.uri;
  }
  
  public final void setRsaInfo(ac paramac)
  {
    AppMethodBeat.i(132306);
    this.gUS.setRsaInfo(paramac);
    AppMethodBeat.o(132306);
  }
  
  public static final class a
  {
    public int funcId;
    public a gUU;
    public a gUV;
    public boolean gUW = true;
    private boolean longPolling = false;
    private int longPollingTimeout = 0;
    public int reqCmdId = 0;
    public int respCmdId = 0;
    public int routeInfo = 0;
    public int timeout = 0;
    public String uri;
    
    public final b atI()
    {
      boolean bool5 = true;
      AppMethodBeat.i(132301);
      if ((this.gUU == null) || (this.gUV == null) || (bt.isNullOrNil(this.uri)) || (this.funcId <= 0) || (this.reqCmdId == -2147483648) || (this.respCmdId == -2147483648))
      {
        boolean bool1;
        boolean bool2;
        label75:
        boolean bool6;
        boolean bool3;
        label93:
        boolean bool4;
        if (this.gUU == null)
        {
          bool1 = true;
          if (this.gUV != null) {
            break label191;
          }
          bool2 = true;
          bool6 = bt.isNullOrNil(this.uri);
          if (this.funcId > 0) {
            break label196;
          }
          bool3 = true;
          if (this.reqCmdId != -2147483648) {
            break label201;
          }
          bool4 = true;
          label105:
          if (this.respCmdId != -2147483648) {
            break label207;
          }
        }
        for (;;)
        {
          localObject = new IllegalArgumentException(String.format("%s %s %s %s %s %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool6), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5) }));
          AppMethodBeat.o(132301);
          throw ((Throwable)localObject);
          bool1 = false;
          break;
          label191:
          bool2 = false;
          break label75;
          label196:
          bool3 = false;
          break label93;
          label201:
          bool4 = false;
          break label105;
          label207:
          bool5 = false;
        }
      }
      Object localObject = new b(this.gUU, this.gUV, this.uri, this.funcId, this.reqCmdId, this.respCmdId, this.gUW, this.timeout, this.routeInfo, this.longPolling, this.longPollingTimeout, (byte)0);
      AppMethodBeat.o(132301);
      return localObject;
    }
    
    public final void c(a parama)
    {
      this.gUU = parama;
    }
    
    public final void d(a parama)
    {
      this.gUV = parama;
    }
    
    public final void fQK()
    {
      this.longPolling = true;
    }
    
    public final void fQL()
    {
      this.longPollingTimeout = 25000;
    }
    
    public final void nB(int paramInt)
    {
      this.funcId = paramInt;
    }
    
    public final void nC(int paramInt)
    {
      this.timeout = paramInt;
    }
    
    public final void nD(int paramInt)
    {
      this.reqCmdId = paramInt;
    }
    
    public final void nE(int paramInt)
    {
      this.respCmdId = paramInt;
    }
    
    public final void wg(String paramString)
    {
      this.uri = paramString;
    }
  }
  
  public static final class b
    extends l.d
    implements l.b
  {
    public int cmdId;
    private int funcId;
    public a gUX;
    private boolean needHeader;
    
    public b(a parama, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
    {
      AppMethodBeat.i(132302);
      this.gUX = parama;
      this.funcId = paramInt1;
      this.cmdId = paramInt2;
      this.needHeader = paramBoolean;
      setRouteInfo(paramInt3);
      AppMethodBeat.o(132302);
    }
    
    public final int getCmdId()
    {
      return this.cmdId;
    }
    
    public final int getFuncId()
    {
      return this.funcId;
    }
    
    public final byte[] toProtoBuf()
    {
      AppMethodBeat.i(132303);
      if ((this.gUX instanceof ckq)) {
        ((ckq)this.gUX).setBaseRequest(com.tencent.mm.protocal.l.a(this));
      }
      byte[] arrayOfByte = this.gUX.toByteArray();
      AppMethodBeat.o(132303);
      return arrayOfByte;
    }
  }
  
  public static final class c
    extends l.e
    implements l.c
  {
    public int cmdId;
    public a gUX = null;
    private boolean needHeader;
    
    public c(a parama, int paramInt, boolean paramBoolean)
    {
      this.gUX = parama;
      this.cmdId = paramInt;
      this.needHeader = paramBoolean;
    }
    
    public final int fromProtoBuf(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(132304);
      this.gUX = this.gUX.parseFrom(paramArrayOfByte);
      if (!(this.gUX instanceof ctq))
      {
        com.tencent.mm.protocal.l.a(this, ((cld)this.gUX).getBaseResponse());
        i = ((cld)this.gUX).getBaseResponse().Ret;
        AppMethodBeat.o(132304);
        return i;
      }
      int i = ((ctq)this.gUX).getRet();
      AppMethodBeat.o(132304);
      return i;
    }
    
    public final int getCmdId()
    {
      return this.cmdId;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.al.b
 * JD-Core Version:    0.7.0.1
 */