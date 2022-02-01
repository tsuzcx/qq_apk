package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.l;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bb;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.aga;
import com.tencent.mm.protocal.protobuf.deh;
import com.tencent.mm.protocal.protobuf.dkj;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;

public final class ab
  extends n
  implements k
{
  private f callback;
  public com.tencent.mm.network.q hON;
  private int hOs;
  
  private ab(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(131098);
    this.hOs = 2;
    this.hON = new a();
    s.a locala = (s.a)this.hON.getReqObj();
    locala.jdU.FAt = paramInt;
    locala.jdU.FDt = paramString1;
    locala.jdU.qei = ac.fks();
    locala.jdU.FEb = bt.aQY(paramString2);
    locala.jdU.GdV = paramString3;
    paramString1 = locala.jdU;
    g.ajA();
    paramString1.FzI = a.aiO();
    locala.jdU.GdW = com.tencent.mm.compatible.deviceinfo.q.getSimCountryIso();
    locala.jdU.GdX = 1;
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
  
  public final int aKW()
  {
    AppMethodBeat.i(131101);
    Object localObject = ((s.b)this.hON.getRespObj()).jdV.Fze;
    dkj localdkj;
    if ((localObject != null) && (((deh)localObject).HsI != null) && (((deh)localObject).HsI.size() > 0))
    {
      localObject = ((deh)localObject).HsI.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localdkj = (dkj)((Iterator)localObject).next();
      } while (localdkj.yhn != 1);
    }
    for (int i = bt.getInt(localdkj.Hza, 0);; i = 0)
    {
      AppMethodBeat.o(131101);
      return i;
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(131099);
    this.callback = paramf;
    int i = dispatch(parame, this.hON, this);
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
    ad.i("MicroMsg.NetSceneEmailReg", "onGYNetEnd  errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    paramq = (s.b)paramq.getRespObj();
    if ((paramInt2 == 4) && (paramInt3 == -301))
    {
      bb.a(true, paramq.jdV.FEd, paramq.jdV.FEe, paramq.jdV.FEc);
      this.hOs -= 1;
      if (this.hOs <= 0)
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
      ad.e("MicroMsg.NetSceneEmailReg", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(131100);
      return;
    }
    bb.a(false, paramq.jdV.FEd, paramq.jdV.FEe, paramq.jdV.FEc);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(131100);
  }
  
  public final int securityLimitCount()
  {
    return 5;
  }
  
  public final n.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    return n.b.hOp;
  }
  
  public static final class a
    extends l
  {
    private s.a jeo;
    private s.b jep;
    
    public a()
    {
      AppMethodBeat.i(131097);
      this.jeo = new s.a();
      this.jep = new s.b();
      AppMethodBeat.o(131097);
    }
    
    public final int getOptions()
    {
      return 1;
    }
    
    public final l.d getReqObjImp()
    {
      return this.jeo;
    }
    
    public final l.e getRespObj()
    {
      return this.jep;
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