package com.tencent.mm.ak;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cvw;
import com.tencent.mm.protocal.protobuf.cwj;
import com.tencent.mm.protocal.protobuf.dfi;
import com.tencent.mm.sdk.platformtools.bu;

public final class b
  extends l
{
  private int funcId;
  public b hQD;
  public c hQE;
  private boolean longPolling;
  private int longPollingTimeout;
  private int newExtFlag;
  public int option;
  private int timeout;
  byte[] transferHeader;
  private String uri;
  
  private b(a parama1, a parama2, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, int paramInt4, int paramInt5, boolean paramBoolean2, int paramInt6)
  {
    AppMethodBeat.i(193551);
    this.hQD = null;
    this.hQE = null;
    this.option = 0;
    if ((paramBoolean1) && ((parama1 instanceof cvw))) {}
    for (boolean bool = true;; bool = false)
    {
      this.hQD = new b(parama1, paramInt1, paramInt2, bool, paramInt5);
      this.hQE = new c(parama2, paramInt3, paramBoolean1);
      this.uri = paramString;
      this.funcId = paramInt1;
      this.timeout = paramInt4;
      this.longPolling = paramBoolean2;
      this.longPollingTimeout = paramInt6;
      this.newExtFlag = 0;
      this.transferHeader = null;
      AppMethodBeat.o(193551);
      return;
    }
  }
  
  public final a aEU()
  {
    return this.hQD.hQJ;
  }
  
  public final a aEV()
  {
    return this.hQE.hQJ;
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
  
  public final void setRsaInfo(ac paramac)
  {
    AppMethodBeat.i(132306);
    this.hQD.setRsaInfo(paramac);
    AppMethodBeat.o(132306);
  }
  
  public static final class a
  {
    public int funcId;
    public a hQF;
    public a hQG;
    public int hQH = 0;
    public boolean hQI = true;
    private boolean longPolling = false;
    private int longPollingTimeout = 0;
    public int newExtFlag = 0;
    public int respCmdId = 0;
    public int routeInfo = 0;
    public int timeout = 0;
    public byte[] transferHeader = null;
    public String uri;
    
    public final void DN(String paramString)
    {
      this.uri = paramString;
    }
    
    public final b aDS()
    {
      boolean bool5 = true;
      AppMethodBeat.i(132301);
      if ((this.hQF == null) || (this.hQG == null) || (bu.isNullOrNil(this.uri)) || (this.funcId <= 0) || (this.hQH == -2147483648) || (this.respCmdId == -2147483648))
      {
        boolean bool1;
        boolean bool2;
        label75:
        boolean bool6;
        boolean bool3;
        label93:
        boolean bool4;
        if (this.hQF == null)
        {
          bool1 = true;
          if (this.hQG != null) {
            break label191;
          }
          bool2 = true;
          bool6 = bu.isNullOrNil(this.uri);
          if (this.funcId > 0) {
            break label196;
          }
          bool3 = true;
          if (this.hQH != -2147483648) {
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
      Object localObject = new b(this.hQF, this.hQG, this.uri, this.funcId, this.hQH, this.respCmdId, this.hQI, this.timeout, this.routeInfo, this.longPolling, this.longPollingTimeout, (byte)0);
      if (this.newExtFlag != 0)
      {
        ((b)localObject).addNewExtFlag(this.newExtFlag);
        ((b)localObject).transferHeader = this.transferHeader;
      }
      AppMethodBeat.o(132301);
      return localObject;
    }
    
    public final void aEW()
    {
      this.longPolling = true;
    }
    
    public final void aEX()
    {
      this.longPollingTimeout = 25000;
    }
    
    public final void c(a parama)
    {
      this.hQF = parama;
    }
    
    public final void d(a parama)
    {
      this.hQG = parama;
    }
    
    public final void oS(int paramInt)
    {
      this.funcId = paramInt;
    }
    
    public final void oT(int paramInt)
    {
      this.timeout = paramInt;
    }
    
    public final void oU(int paramInt)
    {
      this.hQH = paramInt;
    }
    
    public final void oV(int paramInt)
    {
      this.respCmdId = paramInt;
    }
  }
  
  public static final class b
    extends l.d
    implements l.b
  {
    public int cmdId;
    private int funcId;
    public a hQJ;
    private boolean needHeader;
    
    public b(a parama, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
    {
      AppMethodBeat.i(132302);
      this.hQJ = parama;
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
      if ((this.hQJ instanceof cvw)) {
        ((cvw)this.hQJ).setBaseRequest(com.tencent.mm.protocal.l.a(this));
      }
      byte[] arrayOfByte = this.hQJ.toByteArray();
      AppMethodBeat.o(132303);
      return arrayOfByte;
    }
  }
  
  public static final class c
    extends l.e
    implements l.c
  {
    public int cmdId;
    public a hQJ = null;
    private boolean needHeader;
    
    public c(a parama, int paramInt, boolean paramBoolean)
    {
      this.hQJ = parama;
      this.cmdId = paramInt;
      this.needHeader = paramBoolean;
    }
    
    public final int fromProtoBuf(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(132304);
      this.hQJ = this.hQJ.parseFrom(paramArrayOfByte);
      if (!(this.hQJ instanceof dfi))
      {
        com.tencent.mm.protocal.l.a(this, ((cwj)this.hQJ).getBaseResponse());
        i = ((cwj)this.hQJ).getBaseResponse().Ret;
        AppMethodBeat.o(132304);
        return i;
      }
      int i = ((dfi)this.hQJ).getRet();
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
 * Qualified Name:     com.tencent.mm.ak.b
 * JD-Core Version:    0.7.0.1
 */