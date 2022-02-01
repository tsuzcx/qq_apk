package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.o;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.kernel.a;
import com.tencent.mm.model.bh;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.ais;
import com.tencent.mm.protocal.protobuf.dyh;
import com.tencent.mm.protocal.protobuf.eer;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class ab
  extends com.tencent.mm.ak.q
  implements m
{
  private i callback;
  public s iMO;
  private int iMt;
  
  private ab(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(131098);
    this.iMt = 2;
    this.iMO = new a();
    s.a locala = (s.a)this.iMO.getReqObj();
    locala.keR.KMz = paramInt;
    locala.keR.KPz = paramString1;
    locala.keR.rBI = LocaleUtil.getApplicationLanguage();
    locala.keR.KQi = Util.getCutPasswordMD5(paramString2);
    locala.keR.Lsi = paramString3;
    paramString1 = locala.keR;
    com.tencent.mm.kernel.g.aAf();
    paramString1.KLN = a.azt();
    locala.keR.Lsj = com.tencent.mm.compatible.deviceinfo.q.getSimCountryIso();
    locala.keR.Lsk = 1;
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
  
  public final int bfw()
  {
    AppMethodBeat.i(131101);
    Object localObject = ((s.b)this.iMO.getRespObj()).keS.KLj;
    eer localeer;
    if ((localObject != null) && (((dyh)localObject).MXV != null) && (((dyh)localObject).MXV.size() > 0))
    {
      localObject = ((dyh)localObject).MXV.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localeer = (eer)((Iterator)localObject).next();
      } while (localeer.Cya != 1);
    }
    for (int i = Util.getInt(localeer.NeO, 0);; i = 0)
    {
      AppMethodBeat.o(131101);
      return i;
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(131099);
    this.callback = parami;
    int i = dispatch(paramg, this.iMO, this);
    AppMethodBeat.o(131099);
    return i;
  }
  
  public final int getType()
  {
    return 481;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(131100);
    Log.i("MicroMsg.NetSceneEmailReg", "onGYNetEnd  errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    params = (s.b)params.getRespObj();
    if ((paramInt2 == 4) && (paramInt3 == -301))
    {
      bh.a(true, params.keS.KQk, params.keS.KQl, params.keS.KQj);
      this.iMt -= 1;
      if (this.iMt <= 0)
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
      Log.e("MicroMsg.NetSceneEmailReg", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(131100);
      return;
    }
    bh.a(false, params.keS.KQk, params.keS.KQl, params.keS.KQj);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(131100);
  }
  
  public final int securityLimitCount()
  {
    return 5;
  }
  
  public final q.b securityVerificationChecked(s params)
  {
    return q.b.iMq;
  }
  
  public static final class a
    extends o
  {
    private s.a kfl;
    private s.b kfm;
    
    public a()
    {
      AppMethodBeat.i(131097);
      this.kfl = new s.a();
      this.kfm = new s.b();
      AppMethodBeat.o(131097);
    }
    
    public final int getOptions()
    {
      return 1;
    }
    
    public final l.d getReqObjImp()
    {
      return this.kfl;
    }
    
    public final l.e getRespObj()
    {
      return this.kfm;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.ab
 * JD-Core Version:    0.7.0.1
 */