package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.l;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.kernel.a;
import com.tencent.mm.model.ba;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.acs;
import com.tencent.mm.protocal.protobuf.ctj;
import com.tencent.mm.protocal.protobuf.czk;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;

public final class ab
  extends n
  implements k
{
  private com.tencent.mm.al.g callback;
  private int gVE;
  public com.tencent.mm.network.q gVZ;
  
  private ab(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(131098);
    this.gVE = 2;
    this.gVZ = new a();
    s.a locala = (s.a)this.gVZ.getReqObj();
    locala.ikE.CCB = paramInt;
    locala.ikE.CFx = paramString1;
    locala.ikE.oXs = ac.eFu();
    locala.ikE.CGf = bt.aGb(paramString2);
    locala.ikE.Ddl = paramString3;
    paramString1 = locala.ikE;
    com.tencent.mm.kernel.g.afz();
    paramString1.CBQ = a.aeM();
    locala.ikE.Ddm = com.tencent.mm.compatible.deviceinfo.q.getSimCountryIso();
    locala.ikE.Ddn = 1;
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
  
  public final int aAV()
  {
    AppMethodBeat.i(131101);
    Object localObject = ((s.b)this.gVZ.getRespObj()).ikF.CBm;
    czk localczk;
    if ((localObject != null) && (((ctj)localObject).Elc != null) && (((ctj)localObject).Elc.size() > 0))
    {
      localObject = ((ctj)localObject).Elc.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localczk = (czk)((Iterator)localObject).next();
      } while (localczk.vJz != 1);
    }
    for (int i = bt.getInt(localczk.Ern, 0);; i = 0)
    {
      AppMethodBeat.o(131101);
      return i;
    }
  }
  
  public final int doScene(e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(131099);
    this.callback = paramg;
    int i = dispatch(parame, this.gVZ, this);
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
      ba.a(true, paramq.ikF.CGh, paramq.ikF.CGi, paramq.ikF.CGg);
      this.gVE -= 1;
      if (this.gVE <= 0)
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
    ba.a(false, paramq.ikF.CGh, paramq.ikF.CGi, paramq.ikF.CGg);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(131100);
  }
  
  public final int securityLimitCount()
  {
    return 5;
  }
  
  public final n.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    return n.b.gVB;
  }
  
  public static final class a
    extends l
  {
    private s.a ikY;
    private s.b ikZ;
    
    public a()
    {
      AppMethodBeat.i(131097);
      this.ikY = new s.a();
      this.ikZ = new s.b();
      AppMethodBeat.o(131097);
    }
    
    public final int getOptions()
    {
      return 1;
    }
    
    public final l.d getReqObjImp()
    {
      return this.ikY;
    }
    
    public final l.e getRespObj()
    {
      return this.ikZ;
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