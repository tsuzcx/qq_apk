package com.tencent.mm.ak;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.protocal.protobuf.dyp;
import com.tencent.mm.sdk.platformtools.Util;

public final class d
  extends o
{
  private int funcId;
  public b iLK;
  public c iLL;
  private boolean iLM;
  private boolean longPolling;
  private int longPollingTimeout;
  private int newExtFlag;
  public int option;
  private int timeout;
  byte[] transferHeader;
  private String uri;
  
  private d(a parama1, a parama2, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, int paramInt4, int paramInt5, boolean paramBoolean2, int paramInt6, boolean paramBoolean3)
  {
    AppMethodBeat.i(197060);
    this.iLK = null;
    this.iLL = null;
    this.option = 0;
    if ((paramBoolean1) && ((parama1 instanceof dop))) {}
    for (boolean bool = true;; bool = false)
    {
      this.iLK = new b(parama1, paramInt1, paramInt2, bool, paramInt5);
      this.iLL = new c(parama2, paramInt3, paramBoolean1);
      this.uri = paramString;
      this.funcId = paramInt1;
      this.timeout = paramInt4;
      this.longPolling = paramBoolean2;
      this.longPollingTimeout = paramInt6;
      this.newExtFlag = 0;
      this.transferHeader = null;
      this.iLM = paramBoolean3;
      AppMethodBeat.o(197060);
      return;
    }
  }
  
  public final a aYJ()
  {
    return this.iLK.iLR;
  }
  
  public final a aYK()
  {
    return this.iLL.iLR;
  }
  
  public final void addNewExtFlag(int paramInt)
  {
    this.newExtFlag |= paramInt;
  }
  
  public final boolean getIsLongPolling()
  {
    return this.longPolling;
  }
  
  public final int getLongPollingTimeout()
  {
    return this.longPollingTimeout;
  }
  
  public final int getNewExtFlags()
  {
    return this.newExtFlag;
  }
  
  public final int getOptions()
  {
    return this.option;
  }
  
  public final int getReqCmdId()
  {
    return this.iLK.cmdId;
  }
  
  public final int getTimeOut()
  {
    return this.timeout;
  }
  
  public final byte[] getTransHeader()
  {
    return this.transferHeader;
  }
  
  public final int getType()
  {
    return this.funcId;
  }
  
  public final String getUri()
  {
    return this.uri;
  }
  
  public final boolean keepAlive()
  {
    return this.iLM;
  }
  
  public final void setRsaInfo(ac paramac)
  {
    AppMethodBeat.i(132306);
    this.iLK.setRsaInfo(paramac);
    AppMethodBeat.o(132306);
  }
  
  public static final class a
  {
    public int funcId;
    private boolean iLM;
    public a iLN;
    public a iLO;
    public int iLP = 0;
    public boolean iLQ = true;
    private boolean longPolling = false;
    private int longPollingTimeout = 0;
    public int newExtFlag = 0;
    public int respCmdId = 0;
    public int routeInfo = 0;
    public int timeout = 0;
    public byte[] transferHeader = null;
    public String uri;
    
    public final void MB(String paramString)
    {
      this.uri = paramString;
    }
    
    public final d aXF()
    {
      boolean bool5 = true;
      AppMethodBeat.i(132301);
      if ((this.iLN == null) || (this.iLO == null) || (Util.isNullOrNil(this.uri)) || (this.funcId <= 0) || (this.iLP == -2147483648) || (this.respCmdId == -2147483648))
      {
        boolean bool1;
        boolean bool2;
        label75:
        boolean bool6;
        boolean bool3;
        label93:
        boolean bool4;
        if (this.iLN == null)
        {
          bool1 = true;
          if (this.iLO != null) {
            break label191;
          }
          bool2 = true;
          bool6 = Util.isNullOrNil(this.uri);
          if (this.funcId > 0) {
            break label196;
          }
          bool3 = true;
          if (this.iLP != -2147483648) {
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
      Object localObject = new d(this.iLN, this.iLO, this.uri, this.funcId, this.iLP, this.respCmdId, this.iLQ, this.timeout, this.routeInfo, this.longPolling, this.longPollingTimeout, this.iLM, (byte)0);
      if (this.newExtFlag != 0)
      {
        ((d)localObject).addNewExtFlag(this.newExtFlag);
        ((d)localObject).transferHeader = this.transferHeader;
      }
      AppMethodBeat.o(132301);
      return localObject;
    }
    
    public final void aYL()
    {
      this.longPolling = true;
    }
    
    public final void aYM()
    {
      this.longPollingTimeout = 25000;
    }
    
    public final void c(a parama)
    {
      this.iLN = parama;
    }
    
    public final void d(a parama)
    {
      this.iLO = parama;
    }
    
    public final void sG(int paramInt)
    {
      this.funcId = paramInt;
    }
    
    public final void sH(int paramInt)
    {
      this.timeout = paramInt;
    }
    
    public final void sI(int paramInt)
    {
      this.iLP = paramInt;
    }
    
    public final void sJ(int paramInt)
    {
      this.respCmdId = paramInt;
    }
    
    public final void setKeepAlive(boolean paramBoolean)
    {
      this.iLM = paramBoolean;
    }
  }
  
  public static final class b
    extends l.d
    implements l.b
  {
    public int cmdId;
    private int funcId;
    public a iLR;
    private boolean needHeader;
    
    public b(a parama, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
    {
      AppMethodBeat.i(132302);
      this.iLR = parama;
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
      if ((this.iLR instanceof dop)) {
        ((dop)this.iLR).setBaseRequest(l.a(this));
      }
      byte[] arrayOfByte = this.iLR.toByteArray();
      AppMethodBeat.o(132303);
      return arrayOfByte;
    }
  }
  
  public static final class c
    extends l.e
    implements l.c
  {
    public int cmdId;
    public a iLR = null;
    private boolean needHeader;
    
    public c(a parama, int paramInt, boolean paramBoolean)
    {
      this.iLR = parama;
      this.cmdId = paramInt;
      this.needHeader = paramBoolean;
    }
    
    public final int fromProtoBuf(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(132304);
      this.iLR = this.iLR.parseFrom(paramArrayOfByte);
      if (!(this.iLR instanceof dyp))
      {
        l.a(this, ((dpc)this.iLR).getBaseResponse());
        i = ((dpc)this.iLR).getBaseResponse().Ret;
        AppMethodBeat.o(132304);
        return i;
      }
      int i = ((dyp)this.iLR).getRet();
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
 * Qualified Name:     com.tencent.mm.ak.d
 * JD-Core Version:    0.7.0.1
 */