package com.tencent.mm.an;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.protocal.protobuf.eip;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Util;

public class d
  extends o
{
  private int funcId;
  public b lBR;
  public c lBS;
  private boolean lBT;
  private boolean longPolling;
  private int longPollingTimeout;
  private int newExtFlag;
  public int option;
  private int timeout;
  byte[] transferHeader;
  private String uri;
  
  private d(a parama1, a parama2, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, int paramInt4, int paramInt5, boolean paramBoolean2, int paramInt6, boolean paramBoolean3)
  {
    AppMethodBeat.i(195605);
    this.lBR = null;
    this.lBS = null;
    this.option = 0;
    if ((paramBoolean1) && ((parama1 instanceof dyl))) {}
    for (boolean bool = true;; bool = false)
    {
      this.lBR = new b(parama1, paramInt1, paramInt2, bool, paramInt5);
      this.lBS = new c(parama2, paramInt3, paramBoolean1);
      this.uri = paramString;
      this.funcId = paramInt1;
      this.timeout = paramInt4;
      this.longPolling = paramBoolean2;
      this.longPollingTimeout = paramInt6;
      this.newExtFlag = 0;
      this.transferHeader = null;
      this.lBT = paramBoolean3;
      AppMethodBeat.o(195605);
      return;
    }
  }
  
  public final void addNewExtFlag(int paramInt)
  {
    this.newExtFlag |= paramInt;
  }
  
  public final a bhX()
  {
    AppMethodBeat.i(292846);
    a locala = b.b(this.lBR);
    AppMethodBeat.o(292846);
    return locala;
  }
  
  public final a bhY()
  {
    AppMethodBeat.i(292847);
    a locala = c.b(this.lBS);
    AppMethodBeat.o(292847);
    return locala;
  }
  
  public final void bhZ()
  {
    this.option = 1;
  }
  
  public boolean getIsLongPolling()
  {
    return this.longPolling;
  }
  
  public int getLongPollingTimeout()
  {
    return this.longPollingTimeout;
  }
  
  public int getNewExtFlags()
  {
    return this.newExtFlag;
  }
  
  public int getOptions()
  {
    return this.option;
  }
  
  public final int getReqCmdId()
  {
    AppMethodBeat.i(292845);
    int i = b.a(this.lBR);
    AppMethodBeat.o(292845);
    return i;
  }
  
  public int getTimeOut()
  {
    return this.timeout;
  }
  
  public byte[] getTransHeader()
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
  
  public boolean keepAlive()
  {
    return this.lBT;
  }
  
  public final void setRsaInfo(ac paramac)
  {
    AppMethodBeat.i(132306);
    this.lBR.setRsaInfo(paramac);
    AppMethodBeat.o(132306);
  }
  
  public static final class a
  {
    public int funcId;
    private boolean lBT;
    public a lBU;
    public a lBV;
    public int lBW = 0;
    public boolean lBX = true;
    public boolean longPolling = false;
    public int longPollingTimeout = 0;
    public int newExtFlag = 0;
    public int respCmdId = 0;
    public int routeInfo = 0;
    public int timeout = 0;
    public byte[] transferHeader = null;
    public String uri;
    
    public final void TW(String paramString)
    {
      this.uri = paramString;
    }
    
    public final d bgN()
    {
      boolean bool5 = true;
      AppMethodBeat.i(132301);
      if ((this.lBU == null) || (this.lBV == null) || (Util.isNullOrNil(this.uri)) || (this.funcId <= 0) || (this.lBW == -2147483648) || (this.respCmdId == -2147483648))
      {
        boolean bool1;
        boolean bool2;
        label75:
        boolean bool6;
        boolean bool3;
        label93:
        boolean bool4;
        if (this.lBU == null)
        {
          bool1 = true;
          if (this.lBV != null) {
            break label191;
          }
          bool2 = true;
          bool6 = Util.isNullOrNil(this.uri);
          if (this.funcId > 0) {
            break label196;
          }
          bool3 = true;
          if (this.lBW != -2147483648) {
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
      Object localObject = new d(this.lBU, this.lBV, this.uri, this.funcId, this.lBW, this.respCmdId, this.lBX, this.timeout, this.routeInfo, this.longPolling, this.longPollingTimeout, this.lBT, (byte)0);
      if (this.newExtFlag != 0)
      {
        ((d)localObject).addNewExtFlag(this.newExtFlag);
        ((d)localObject).transferHeader = this.transferHeader;
      }
      AppMethodBeat.o(132301);
      return localObject;
    }
    
    public final void bia()
    {
      this.longPolling = true;
    }
    
    public final void bib()
    {
      this.longPollingTimeout = 25000;
    }
    
    public final void c(a parama)
    {
      this.lBU = parama;
    }
    
    public final void d(a parama)
    {
      this.lBV = parama;
    }
    
    public final void setKeepAlive(boolean paramBoolean)
    {
      this.lBT = paramBoolean;
    }
    
    public final void vD(int paramInt)
    {
      this.funcId = paramInt;
    }
    
    public final void vE(int paramInt)
    {
      this.timeout = paramInt;
    }
    
    public final void vF(int paramInt)
    {
      this.lBW = paramInt;
    }
    
    public final void vG(int paramInt)
    {
      this.respCmdId = paramInt;
    }
  }
  
  public static final class b
    extends l.d
    implements l.b
  {
    private int cmdId;
    private int funcId;
    public a lBY;
    private boolean needHeader;
    
    public b(a parama, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
    {
      AppMethodBeat.i(132302);
      this.lBY = parama;
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
      if ((this.lBY instanceof dyl)) {
        ((dyl)this.lBY).setBaseRequest(l.a(this));
      }
      byte[] arrayOfByte = this.lBY.toByteArray();
      AppMethodBeat.o(132303);
      return arrayOfByte;
    }
  }
  
  public static final class c
    extends l.e
    implements l.c
  {
    private int cmdId;
    private a lBY = null;
    private boolean needHeader;
    
    public c(a parama, int paramInt, boolean paramBoolean)
    {
      this.lBY = parama;
      this.cmdId = paramInt;
      this.needHeader = paramBoolean;
    }
    
    public final int fromProtoBuf(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(132304);
      this.lBY = this.lBY.parseFrom(paramArrayOfByte);
      if (!(this.lBY instanceof eip))
      {
        l.a(this, ((dyy)this.lBY).getBaseResponse());
        i = ((dyy)this.lBY).getBaseResponse().CqV;
        AppMethodBeat.o(132304);
        return i;
      }
      int i = ((eip)this.lBY).getRet();
      AppMethodBeat.o(132304);
      return i;
    }
    
    public final int getCmdId()
    {
      return this.cmdId;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.an.d
 * JD-Core Version:    0.7.0.1
 */