package com.tencent.mm.am;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.sdk.platformtools.Util;

public class c
  extends n
{
  private int funcId;
  private boolean longPolling;
  private int longPollingTimeout;
  private int newExtFlag;
  public int option;
  public c.b otB;
  public c.c otC;
  private boolean otD;
  private int timeout;
  byte[] transferHeader;
  private String uri;
  
  private c(a parama1, a parama2, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, int paramInt4, int paramInt5, boolean paramBoolean2, int paramInt6, boolean paramBoolean3)
  {
    AppMethodBeat.i(236783);
    this.otB = null;
    this.otC = null;
    this.option = 0;
    if ((paramBoolean1) && ((parama1 instanceof erp))) {}
    for (boolean bool = true;; bool = false)
    {
      this.otB = new c.b(parama1, paramInt1, paramInt2, bool, paramInt5);
      this.otC = new c.c(parama2, paramInt3, paramBoolean1);
      this.uri = paramString;
      this.funcId = paramInt1;
      this.timeout = paramInt4;
      this.longPolling = paramBoolean2;
      this.longPollingTimeout = paramInt6;
      this.newExtFlag = 0;
      this.transferHeader = null;
      this.otD = paramBoolean3;
      AppMethodBeat.o(236783);
      return;
    }
  }
  
  public final void addNewExtFlag(int paramInt)
  {
    this.newExtFlag |= paramInt;
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
    return this.otD;
  }
  
  public final void setRsaInfo(ac paramac)
  {
    AppMethodBeat.i(132306);
    this.otB.setRsaInfo(paramac);
    AppMethodBeat.o(132306);
  }
  
  public static final class a
  {
    public int funcId;
    public boolean longPolling = false;
    public int longPollingTimeout = 0;
    public int newExtFlag = 0;
    public boolean otD;
    public a otE;
    public a otF;
    public int otG = 0;
    public boolean otH = true;
    public int respCmdId = 0;
    public int routeInfo = 0;
    public int timeout = 0;
    public byte[] transferHeader = null;
    public String uri;
    
    public final c bEF()
    {
      boolean bool5 = true;
      AppMethodBeat.i(132301);
      if ((this.otE == null) || (this.otF == null) || (Util.isNullOrNil(this.uri)) || (this.funcId <= 0) || (this.otG == -2147483648) || (this.respCmdId == -2147483648))
      {
        boolean bool1;
        boolean bool2;
        label75:
        boolean bool6;
        boolean bool3;
        label93:
        boolean bool4;
        if (this.otE == null)
        {
          bool1 = true;
          if (this.otF != null) {
            break label191;
          }
          bool2 = true;
          bool6 = Util.isNullOrNil(this.uri);
          if (this.funcId > 0) {
            break label196;
          }
          bool3 = true;
          if (this.otG != -2147483648) {
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
      Object localObject = new c(this.otE, this.otF, this.uri, this.funcId, this.otG, this.respCmdId, this.otH, this.timeout, this.routeInfo, this.longPolling, this.longPollingTimeout, this.otD, (byte)0);
      if (this.newExtFlag != 0)
      {
        ((c)localObject).addNewExtFlag(this.newExtFlag);
        ((c)localObject).transferHeader = this.transferHeader;
      }
      AppMethodBeat.o(132301);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.am.c
 * JD-Core Version:    0.7.0.1
 */