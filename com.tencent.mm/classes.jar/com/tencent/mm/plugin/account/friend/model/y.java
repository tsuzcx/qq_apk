package com.tencent.mm.plugin.account.friend.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.n;
import com.tencent.mm.am.p;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.bj;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.amm;
import com.tencent.mm.protocal.protobuf.fck;
import com.tencent.mm.protocal.protobuf.fjq;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class y
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  public s ouH;
  private int ouk;
  
  private y(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(131098);
    this.ouk = 2;
    this.ouH = new a();
    p.a locala = (p.a)this.ouH.getReqObj();
    locala.pSW.YKH = paramInt;
    locala.pSW.YNN = paramString1;
    locala.pSW.yts = LocaleUtil.getApplicationLanguage();
    locala.pSW.YOy = Util.getCutPasswordMD5(paramString2);
    locala.pSW.Ztu = paramString3;
    paramString1 = locala.pSW;
    com.tencent.mm.kernel.h.baC();
    paramString1.YJX = b.aZR();
    locala.pSW.Ztv = q.aPc();
    locala.pSW.Ztw = 1;
    AppMethodBeat.o(131098);
  }
  
  public y(String paramString1, String paramString2)
  {
    this(1, paramString1, paramString2, "");
  }
  
  public y(String paramString1, String paramString2, String paramString3)
  {
    this(2, paramString1, paramString2, paramString3);
  }
  
  public final int bMt()
  {
    AppMethodBeat.i(131101);
    Object localObject = ((p.b)this.ouH.getRespObj()).pSX.YJt;
    fjq localfjq;
    if ((localObject != null) && (((fck)localObject).abBZ != null) && (((fck)localObject).abBZ.size() > 0))
    {
      localObject = ((fck)localObject).abBZ.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localfjq = (fjq)((Iterator)localObject).next();
      } while (localfjq.OzG != 1);
    }
    for (int i = Util.getInt(localfjq.abKm, 0);; i = 0)
    {
      AppMethodBeat.o(131101);
      return i;
    }
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(131099);
    this.callback = paramh;
    int i = dispatch(paramg, this.ouH, this);
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
    params = (p.b)params.getRespObj();
    if ((paramInt2 == 4) && (paramInt3 == -301))
    {
      bj.a(true, params.pSX.YOA, params.pSX.YOB, params.pSX.YOz, true, 0);
      this.ouk -= 1;
      if (this.ouk <= 0)
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
    bj.a(false, params.pSX.YOA, params.pSX.YOB, params.pSX.YOz, false, 0);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(131100);
  }
  
  public final int securityLimitCount()
  {
    return 5;
  }
  
  public final com.tencent.mm.am.p.b securityVerificationChecked(s params)
  {
    return com.tencent.mm.am.p.b.ouh;
  }
  
  public static final class a
    extends n
  {
    private p.a pTr;
    private p.b pTs;
    
    public a()
    {
      AppMethodBeat.i(131097);
      this.pTr = new p.a();
      this.pTs = new p.b();
      AppMethodBeat.o(131097);
    }
    
    public final int getOptions()
    {
      return 1;
    }
    
    public final l.d getReqObjImp()
    {
      return this.pTr;
    }
    
    public final l.e getRespObj()
    {
      return this.pTs;
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
 * Qualified Name:     com.tencent.mm.plugin.account.friend.model.y
 * JD-Core Version:    0.7.0.1
 */