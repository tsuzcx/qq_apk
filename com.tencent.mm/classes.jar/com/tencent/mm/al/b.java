package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cvc;
import com.tencent.mm.protocal.protobuf.cvp;
import com.tencent.mm.protocal.protobuf.deo;
import com.tencent.mm.sdk.platformtools.bt;

public final class b
  extends l
{
  private int funcId;
  public b hNK;
  public c hNL;
  private boolean longPolling;
  private int longPollingTimeout;
  private int newExtFlag;
  public int option;
  private int timeout;
  byte[] transferHeader;
  private String uri;
  
  private b(a parama1, a parama2, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, int paramInt4, int paramInt5, boolean paramBoolean2, int paramInt6)
  {
    AppMethodBeat.i(189833);
    this.hNK = null;
    this.hNL = null;
    this.option = 0;
    if ((paramBoolean1) && ((parama1 instanceof cvc))) {}
    for (boolean bool = true;; bool = false)
    {
      this.hNK = new b(parama1, paramInt1, paramInt2, bool, paramInt5);
      this.hNL = new c(parama2, paramInt3, paramBoolean1);
      this.uri = paramString;
      this.funcId = paramInt1;
      this.timeout = paramInt4;
      this.longPolling = paramBoolean2;
      this.longPollingTimeout = paramInt6;
      this.newExtFlag = 0;
      this.transferHeader = null;
      AppMethodBeat.o(189833);
      return;
    }
  }
  
  public final a aEE()
  {
    return this.hNK.hNQ;
  }
  
  public final a aEF()
  {
    return this.hNL.hNQ;
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
    this.hNK.setRsaInfo(paramac);
    AppMethodBeat.o(132306);
  }
  
  public static final class a
  {
    public int funcId;
    public a hNM;
    public a hNN;
    public int hNO = 0;
    public boolean hNP = true;
    private boolean longPolling = false;
    private int longPollingTimeout = 0;
    public int newExtFlag = 0;
    public int respCmdId = 0;
    public int routeInfo = 0;
    public int timeout = 0;
    public byte[] transferHeader = null;
    public String uri;
    
    public final void Dl(String paramString)
    {
      this.uri = paramString;
    }
    
    public final b aDC()
    {
      boolean bool5 = true;
      AppMethodBeat.i(132301);
      if ((this.hNM == null) || (this.hNN == null) || (bt.isNullOrNil(this.uri)) || (this.funcId <= 0) || (this.hNO == -2147483648) || (this.respCmdId == -2147483648))
      {
        boolean bool1;
        boolean bool2;
        label75:
        boolean bool6;
        boolean bool3;
        label93:
        boolean bool4;
        if (this.hNM == null)
        {
          bool1 = true;
          if (this.hNN != null) {
            break label191;
          }
          bool2 = true;
          bool6 = bt.isNullOrNil(this.uri);
          if (this.funcId > 0) {
            break label196;
          }
          bool3 = true;
          if (this.hNO != -2147483648) {
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
      Object localObject = new b(this.hNM, this.hNN, this.uri, this.funcId, this.hNO, this.respCmdId, this.hNP, this.timeout, this.routeInfo, this.longPolling, this.longPollingTimeout, (byte)0);
      if (this.newExtFlag != 0)
      {
        ((b)localObject).addNewExtFlag(this.newExtFlag);
        ((b)localObject).transferHeader = this.transferHeader;
      }
      AppMethodBeat.o(132301);
      return localObject;
    }
    
    public final void aEG()
    {
      this.longPolling = true;
    }
    
    public final void aEH()
    {
      this.longPollingTimeout = 25000;
    }
    
    public final void c(a parama)
    {
      this.hNM = parama;
    }
    
    public final void d(a parama)
    {
      this.hNN = parama;
    }
    
    public final void oP(int paramInt)
    {
      this.funcId = paramInt;
    }
    
    public final void oQ(int paramInt)
    {
      this.timeout = paramInt;
    }
    
    public final void oR(int paramInt)
    {
      this.hNO = paramInt;
    }
    
    public final void oS(int paramInt)
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
    public a hNQ;
    private boolean needHeader;
    
    public b(a parama, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
    {
      AppMethodBeat.i(132302);
      this.hNQ = parama;
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
      if ((this.hNQ instanceof cvc)) {
        ((cvc)this.hNQ).setBaseRequest(com.tencent.mm.protocal.l.a(this));
      }
      byte[] arrayOfByte = this.hNQ.toByteArray();
      AppMethodBeat.o(132303);
      return arrayOfByte;
    }
  }
  
  public static final class c
    extends l.e
    implements l.c
  {
    public int cmdId;
    public a hNQ = null;
    private boolean needHeader;
    
    public c(a parama, int paramInt, boolean paramBoolean)
    {
      this.hNQ = parama;
      this.cmdId = paramInt;
      this.needHeader = paramBoolean;
    }
    
    public final int fromProtoBuf(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(132304);
      this.hNQ = this.hNQ.parseFrom(paramArrayOfByte);
      if (!(this.hNQ instanceof deo))
      {
        com.tencent.mm.protocal.l.a(this, ((cvp)this.hNQ).getBaseResponse());
        i = ((cvp)this.hNQ).getBaseResponse().Ret;
        AppMethodBeat.o(132304);
        return i;
      }
      int i = ((deo)this.hNQ).getRet();
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