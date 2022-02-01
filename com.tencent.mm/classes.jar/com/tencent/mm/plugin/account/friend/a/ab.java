package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.l;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.agj;
import com.tencent.mm.protocal.protobuf.dfb;
import com.tencent.mm.protocal.protobuf.dle;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.LinkedList;

public final class ab
  extends n
  implements k
{
  private f callback;
  public com.tencent.mm.network.q hRG;
  private int hRl;
  
  private ab(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(131098);
    this.hRl = 2;
    this.hRG = new a();
    s.a locala = (s.a)this.hRG.getReqObj();
    locala.jgN.FSQ = paramInt;
    locala.jgN.FVO = paramString1;
    locala.jgN.qkN = ad.fom();
    locala.jgN.FWw = bu.aSv(paramString2);
    locala.jgN.GwC = paramString3;
    paramString1 = locala.jgN;
    g.ajP();
    paramString1.FSg = a.ajd();
    locala.jgN.GwD = com.tencent.mm.compatible.deviceinfo.q.getSimCountryIso();
    locala.jgN.GwE = 1;
    AppMethodBeat.o(131098);
  }
  
  public ab(String paramString1, String paramString2)
  {
    this(1, paramString1, paramString2, "");
  }
  
  public ab(String paramString1, String paramString2, String paramString3)
  {
    this(2, paramString1, paramString2, paramString3);
  }
  
  public final int aLt()
  {
    AppMethodBeat.i(131101);
    Object localObject = ((s.b)this.hRG.getRespObj()).jgO.FRC;
    dle localdle;
    if ((localObject != null) && (((dfb)localObject).HMl != null) && (((dfb)localObject).HMl.size() > 0))
    {
      localObject = ((dfb)localObject).HMl.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localdle = (dle)((Iterator)localObject).next();
      } while (localdle.yxe != 1);
    }
    for (int i = bu.getInt(localdle.HSL, 0);; i = 0)
    {
      AppMethodBeat.o(131101);
      return i;
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(131099);
    this.callback = paramf;
    int i = dispatch(parame, this.hRG, this);
    AppMethodBeat.o(131099);
    return i;
  }
  
  public final int getType()
  {
    return 481;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(131100);
    ae.i("MicroMsg.NetSceneEmailReg", "onGYNetEnd  errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    paramq = (s.b)paramq.getRespObj();
    if ((paramInt2 == 4) && (paramInt3 == -301))
    {
      bd.a(true, paramq.jgO.FWy, paramq.jgO.FWz, paramq.jgO.FWx);
      this.hRl -= 1;
      if (this.hRl <= 0)
      {
        this.callback.onSceneEnd(3, -1, "", this);
        AppMethodBeat.o(131100);
        return;
      }
      doScene(dispatcher(), this.callback);
      AppMethodBeat.o(131100);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ae.e("MicroMsg.NetSceneEmailReg", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(131100);
      return;
    }
    bd.a(false, paramq.jgO.FWy, paramq.jgO.FWz, paramq.jgO.FWx);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(131100);
  }
  
  public final int securityLimitCount()
  {
    return 5;
  }
  
  public final n.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    return n.b.hRi;
  }
  
  public static final class a
    extends l
  {
    private s.a jhh;
    private s.b jhi;
    
    public a()
    {
      AppMethodBeat.i(131097);
      this.jhh = new s.a();
      this.jhi = new s.b();
      AppMethodBeat.o(131097);
    }
    
    public final int getOptions()
    {
      return 1;
    }
    
    public final l.d getReqObjImp()
    {
      return this.jhh;
    }
    
    public final l.e getRespObj()
    {
      return this.jhi;
    }
    
    public final int getType()
    {
      return 481;
    }
    
    public final String getUri()
    {
      return "/cgi-bin/micromsg-bin/emailreg";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.ab
 * JD-Core Version:    0.7.0.1
 */