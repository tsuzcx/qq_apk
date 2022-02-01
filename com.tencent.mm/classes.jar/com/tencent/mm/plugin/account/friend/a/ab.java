package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.l;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.kernel.a;
import com.tencent.mm.model.ba;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.adr;
import com.tencent.mm.protocal.protobuf.cyu;
import com.tencent.mm.protocal.protobuf.dew;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.LinkedList;

public final class ab
  extends n
  implements k
{
  private com.tencent.mm.ak.g callback;
  private int hwd;
  public com.tencent.mm.network.q hwy;
  
  private ab(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(131098);
    this.hwd = 2;
    this.hwy = new a();
    s.a locala = (s.a)this.hwy.getReqObj();
    locala.iKL.DUY = paramInt;
    locala.iKL.DXX = paramString1;
    locala.iKL.pAD = com.tencent.mm.sdk.platformtools.ab.eUO();
    locala.iKL.DYF = bs.aLs(paramString2);
    locala.iKL.Ewr = paramString3;
    paramString1 = locala.iKL;
    com.tencent.mm.kernel.g.agP();
    paramString1.DUo = a.agc();
    locala.iKL.Ews = com.tencent.mm.compatible.deviceinfo.q.getSimCountryIso();
    locala.iKL.Ewt = 1;
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
  
  public final int aHL()
  {
    AppMethodBeat.i(131101);
    Object localObject = ((s.b)this.hwy.getRespObj()).iKM.DTK;
    dew localdew;
    if ((localObject != null) && (((cyu)localObject).FIa != null) && (((cyu)localObject).FIa.size() > 0))
    {
      localObject = ((cyu)localObject).FIa.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localdew = (dew)((Iterator)localObject).next();
      } while (localdew.wTD != 1);
    }
    for (int i = bs.getInt(localdew.FOp, 0);; i = 0)
    {
      AppMethodBeat.o(131101);
      return i;
    }
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(131099);
    this.callback = paramg;
    int i = dispatch(parame, this.hwy, this);
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
    ac.i("MicroMsg.NetSceneEmailReg", "onGYNetEnd  errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    paramq = (s.b)paramq.getRespObj();
    if ((paramInt2 == 4) && (paramInt3 == -301))
    {
      ba.a(true, paramq.iKM.DYH, paramq.iKM.DYI, paramq.iKM.DYG);
      this.hwd -= 1;
      if (this.hwd <= 0)
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
      ac.e("MicroMsg.NetSceneEmailReg", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(131100);
      return;
    }
    ba.a(false, paramq.iKM.DYH, paramq.iKM.DYI, paramq.iKM.DYG);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(131100);
  }
  
  public final int securityLimitCount()
  {
    return 5;
  }
  
  public final n.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    return n.b.hwa;
  }
  
  public static final class a
    extends l
  {
    private s.a iLf;
    private s.b iLg;
    
    public a()
    {
      AppMethodBeat.i(131097);
      this.iLf = new s.a();
      this.iLg = new s.b();
      AppMethodBeat.o(131097);
    }
    
    public final int getOptions()
    {
      return 1;
    }
    
    public final l.d getReqObjImp()
    {
      return this.iLf;
    }
    
    public final l.e getRespObj()
    {
      return this.iLg;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.ab
 * JD-Core Version:    0.7.0.1
 */