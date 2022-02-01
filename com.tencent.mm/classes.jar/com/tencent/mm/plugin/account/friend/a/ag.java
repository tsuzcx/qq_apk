package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.o;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.q.a;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.kernel.a;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.bvu;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class ag
  extends q
  implements com.tencent.mm.network.m
{
  i callback;
  public final s iMO;
  
  public ag(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(131118);
    this.callback = null;
    this.iMO = new a();
    u.a locala = (u.a)this.iMO.getReqObj();
    locala.keU.MbG = paramString1;
    locala.keU.MbH = paramString2;
    locala.keU.oUJ = paramString3;
    locala.keU.MbI = paramString4;
    locala.keU.MbJ = paramString5;
    locala.keU.MbK = paramString6;
    locala.keU.LtW = paramInt;
    locala.keU.rBI = LocaleUtil.getApplicationLanguage();
    paramString1 = locala.keU;
    com.tencent.mm.kernel.g.aAf();
    paramString1.KLN = a.azt();
    AppMethodBeat.o(131118);
  }
  
  public final String bfl()
  {
    AppMethodBeat.i(131122);
    String str = ((u.b)this.iMO.getRespObj()).keV.MbJ;
    AppMethodBeat.o(131122);
    return str;
  }
  
  public final byte[] bfm()
  {
    AppMethodBeat.i(131121);
    byte[] arrayOfByte = z.a(((u.b)this.iMO.getRespObj()).keV.MbL, new byte[0]);
    AppMethodBeat.o(131121);
    return arrayOfByte;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(131119);
    this.callback = parami;
    int i = dispatch(paramg, this.iMO, this);
    AppMethodBeat.o(131119);
    return i;
  }
  
  public final int getType()
  {
    return 429;
  }
  
  public final void onGYNetEnd(final int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(131120);
    if ((paramInt2 == 4) && (paramInt3 == -102))
    {
      paramInt1 = params.getReqObj().getRsaInfo().ver;
      Log.d("MicroMsg.NetSceneGetSuggestAlias", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[] { Integer.valueOf(paramInt1) });
      com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(131116);
          new com.tencent.mm.modelsimple.m().doScene(ag.this.dispatcher(), new i()
          {
            public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, q paramAnonymous2q)
            {
              AppMethodBeat.i(131115);
              Log.d("MicroMsg.NetSceneGetSuggestAlias", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[] { Integer.valueOf(paramAnonymous2q.getType()), Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
              if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0))
              {
                ag.this.callback.onSceneEnd(paramAnonymous2Int1, paramAnonymous2Int2, "", ag.this);
                AppMethodBeat.o(131115);
                return;
              }
              ag.this.doScene(ag.this.dispatcher(), ag.this.callback);
              AppMethodBeat.o(131115);
            }
          });
          AppMethodBeat.o(131116);
        }
      });
      AppMethodBeat.o(131120);
      return;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(131120);
  }
  
  public final int securityLimitCount()
  {
    return 3;
  }
  
  public final q.b securityVerificationChecked(s params)
  {
    return q.b.iMq;
  }
  
  public final void setSecurityCheckError(q.a parama) {}
  
  public static final class a
    extends o
  {
    private final u.a kfr;
    private final u.b kfs;
    
    public a()
    {
      AppMethodBeat.i(131117);
      this.kfr = new u.a();
      this.kfs = new u.b();
      AppMethodBeat.o(131117);
    }
    
    public final int getOptions()
    {
      return 1;
    }
    
    public final l.d getReqObjImp()
    {
      return this.kfr;
    }
    
    public final l.e getRespObj()
    {
      return this.kfs;
    }
    
    public final int getType()
    {
      return 429;
    }
    
    public final String getUri()
    {
      return "/cgi-bin/micromsg-bin/getsuggestalias";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.ag
 * JD-Core Version:    0.7.0.1
 */