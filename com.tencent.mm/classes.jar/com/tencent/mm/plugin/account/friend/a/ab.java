package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.o;
import com.tencent.mm.an.q.b;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bi;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.ajh;
import com.tencent.mm.protocal.protobuf.eii;
import com.tencent.mm.protocal.protobuf.eos;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class ab
  extends com.tencent.mm.an.q
  implements m
{
  private i callback;
  private int lCA;
  public s lCW;
  
  private ab(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(131098);
    this.lCA = 2;
    this.lCW = new a();
    s.a locala = (s.a)this.lCW.getReqObj();
    locala.mWq.RNt = paramInt;
    locala.mWq.RQx = paramString1;
    locala.mWq.vhq = LocaleUtil.getApplicationLanguage();
    locala.mWq.RRg = Util.getCutPasswordMD5(paramString2);
    locala.mWq.StK = paramString3;
    paramString1 = locala.mWq;
    h.aHE();
    paramString1.RMJ = b.aGR();
    locala.mWq.StL = com.tencent.mm.compatible.deviceinfo.q.auI();
    locala.mWq.StM = 1;
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
  
  public final int boM()
  {
    AppMethodBeat.i(131101);
    Object localObject = ((s.b)this.lCW.getRespObj()).mWr.RMf;
    eos localeos;
    if ((localObject != null) && (((eii)localObject).Ukq != null) && (((eii)localObject).Ukq.size() > 0))
    {
      localObject = ((eii)localObject).Ukq.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localeos = (eos)((Iterator)localObject).next();
      } while (localeos.IyZ != 1);
    }
    for (int i = Util.getInt(localeos.Uro, 0);; i = 0)
    {
      AppMethodBeat.o(131101);
      return i;
    }
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(131099);
    this.callback = parami;
    int i = dispatch(paramg, this.lCW, this);
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
      bi.a(true, params.mWr.RRi, params.mWr.RRj, params.mWr.RRh, true, 0);
      this.lCA -= 1;
      if (this.lCA <= 0)
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
    bi.a(false, params.mWr.RRi, params.mWr.RRj, params.mWr.RRh, false, 0);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(131100);
  }
  
  public final int securityLimitCount()
  {
    return 5;
  }
  
  public final q.b securityVerificationChecked(s params)
  {
    return q.b.lCx;
  }
  
  public static final class a
    extends o
  {
    private s.a mWK;
    private s.b mWL;
    
    public a()
    {
      AppMethodBeat.i(131097);
      this.mWK = new s.a();
      this.mWL = new s.b();
      AppMethodBeat.o(131097);
    }
    
    public final int getOptions()
    {
      return 1;
    }
    
    public final l.d getReqObjImp()
    {
      return this.mWK;
    }
    
    public final l.e getRespObj()
    {
      return this.mWL;
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