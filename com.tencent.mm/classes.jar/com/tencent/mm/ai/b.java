package com.tencent.mm.ai;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.a;
import com.tencent.mm.protocal.aa;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.buy;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.protocal.protobuf.ccv;
import com.tencent.mm.sdk.platformtools.bo;

public final class b
  extends k
{
  private int eBM;
  public b fsV;
  public c fsW;
  private int funcId;
  public int option;
  private String uri;
  
  private b(a parama1, a parama2, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(58159);
    this.fsV = null;
    this.fsW = null;
    this.option = 0;
    if ((paramBoolean) && ((parama1 instanceof buy))) {}
    for (boolean bool = true;; bool = false)
    {
      this.fsV = new b(parama1, paramInt1, paramInt2, bool, paramInt5);
      this.fsW = new c(parama2, paramInt3, paramBoolean);
      this.uri = paramString;
      this.funcId = paramInt1;
      this.eBM = paramInt4;
      AppMethodBeat.o(58159);
      return;
    }
  }
  
  public final a adm()
  {
    return this.fsV.fta;
  }
  
  public final a adn()
  {
    return this.fsW.fta;
  }
  
  public final int getOptions()
  {
    return this.option;
  }
  
  public final int getTimeOut()
  {
    return this.eBM;
  }
  
  public final int getType()
  {
    return this.funcId;
  }
  
  public final String getUri()
  {
    return this.uri;
  }
  
  public final void setRsaInfo(aa paramaa)
  {
    AppMethodBeat.i(58160);
    this.fsV.setRsaInfo(paramaa);
    AppMethodBeat.o(58160);
  }
  
  public static final class a
  {
    public int eBM = 0;
    public a fsX;
    public a fsY;
    public boolean fsZ = true;
    public int funcId;
    public int reqCmdId = 0;
    public int respCmdId = 0;
    public int routeInfo = 0;
    public String uri;
    
    public final void a(a parama)
    {
      this.fsX = parama;
    }
    
    public final b ado()
    {
      boolean bool5 = true;
      AppMethodBeat.i(58156);
      if ((this.fsX == null) || (this.fsY == null) || (bo.isNullOrNil(this.uri)) || (this.funcId <= 0) || (this.reqCmdId == -2147483648) || (this.respCmdId == -2147483648))
      {
        boolean bool1;
        boolean bool2;
        label75:
        boolean bool6;
        boolean bool3;
        label93:
        boolean bool4;
        if (this.fsX == null)
        {
          bool1 = true;
          if (this.fsY != null) {
            break label191;
          }
          bool2 = true;
          bool6 = bo.isNullOrNil(this.uri);
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
          AppMethodBeat.o(58156);
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
      Object localObject = new b(this.fsX, this.fsY, this.uri, this.funcId, this.reqCmdId, this.respCmdId, this.fsZ, this.eBM, this.routeInfo, (byte)0);
      AppMethodBeat.o(58156);
      return localObject;
    }
    
    public final void b(a parama)
    {
      this.fsY = parama;
    }
    
    public final void kT(int paramInt)
    {
      this.funcId = paramInt;
    }
    
    public final void kU(int paramInt)
    {
      this.reqCmdId = paramInt;
    }
    
    public final void kV(int paramInt)
    {
      this.respCmdId = paramInt;
    }
    
    public final void rl(String paramString)
    {
      this.uri = paramString;
    }
  }
  
  public static final class b
    extends l.d
    implements l.b
  {
    public int cmdId;
    public a fta;
    private int funcId;
    private boolean needHeader;
    
    public b(a parama, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
    {
      AppMethodBeat.i(146117);
      this.fta = parama;
      this.funcId = paramInt1;
      this.cmdId = paramInt2;
      this.needHeader = paramBoolean;
      setRouteInfo(paramInt3);
      AppMethodBeat.o(146117);
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
      AppMethodBeat.i(58157);
      if ((this.fta instanceof buy)) {
        ((buy)this.fta).setBaseRequest(l.a(this));
      }
      byte[] arrayOfByte = this.fta.toByteArray();
      AppMethodBeat.o(58157);
      return arrayOfByte;
    }
  }
  
  public static final class c
    extends l.e
    implements l.c
  {
    public int cmdId;
    public a fta = null;
    private boolean needHeader;
    
    public c(a parama, int paramInt, boolean paramBoolean)
    {
      this.fta = parama;
      this.cmdId = paramInt;
      this.needHeader = paramBoolean;
    }
    
    public final int fromProtoBuf(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(58158);
      this.fta = this.fta.parseFrom(paramArrayOfByte);
      if (!(this.fta instanceof ccv))
      {
        l.a(this, ((bvk)this.fta).getBaseResponse());
        i = ((bvk)this.fta).getBaseResponse().Ret;
        AppMethodBeat.o(58158);
        return i;
      }
      int i = ((ccv)this.fta).getRet();
      AppMethodBeat.o(58158);
      return i;
    }
    
    public final int getCmdId()
    {
      return this.cmdId;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ai.b
 * JD-Core Version:    0.7.0.1
 */