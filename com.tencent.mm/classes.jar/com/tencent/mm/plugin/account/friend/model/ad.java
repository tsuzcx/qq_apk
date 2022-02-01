package com.tencent.mm.plugin.account.friend.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.n;
import com.tencent.mm.am.p;
import com.tencent.mm.am.p.a;
import com.tencent.mm.am.p.b;
import com.tencent.mm.kernel.b;
import com.tencent.mm.modelsimple.o;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.ctc;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class ad
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  public final s ouH;
  
  public ad(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(131118);
    this.callback = null;
    this.ouH = new a();
    r.a locala = (r.a)this.ouH.getReqObj();
    locala.pSZ.aayS = paramString1;
    locala.pSZ.aayT = paramString2;
    locala.pSZ.vhX = paramString3;
    locala.pSZ.aayU = paramString4;
    locala.pSZ.aayV = paramString5;
    locala.pSZ.aayW = paramString6;
    locala.pSZ.ZwR = paramInt;
    locala.pSZ.yts = LocaleUtil.getApplicationLanguage();
    paramString1 = locala.pSZ;
    com.tencent.mm.kernel.h.baC();
    paramString1.YJX = b.aZR();
    AppMethodBeat.o(131118);
  }
  
  public final String bMi()
  {
    AppMethodBeat.i(131122);
    String str = ((r.b)this.ouH.getRespObj()).pTa.aayV;
    AppMethodBeat.o(131122);
    return str;
  }
  
  public final byte[] bMj()
  {
    AppMethodBeat.i(131121);
    byte[] arrayOfByte = w.a(((r.b)this.ouH.getRespObj()).pTa.aayX, new byte[0]);
    AppMethodBeat.o(131121);
    return arrayOfByte;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(131119);
    this.callback = paramh;
    int i = dispatch(paramg, this.ouH, this);
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
      com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(131116);
          new o().doScene(ad.a(ad.this), new com.tencent.mm.am.h()
          {
            public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, p paramAnonymous2p)
            {
              AppMethodBeat.i(131115);
              Log.d("MicroMsg.NetSceneGetSuggestAlias", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[] { Integer.valueOf(paramAnonymous2p.getType()), Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
              if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0))
              {
                ad.b(ad.this).onSceneEnd(paramAnonymous2Int1, paramAnonymous2Int2, "", ad.this);
                AppMethodBeat.o(131115);
                return;
              }
              ad.this.doScene(ad.c(ad.this), ad.b(ad.this));
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
  
  public final p.b securityVerificationChecked(s params)
  {
    return p.b.ouh;
  }
  
  public final void setSecurityCheckError(p.a parama) {}
  
  public static final class a
    extends n
  {
    private final r.a pTx;
    private final r.b pTy;
    
    public a()
    {
      AppMethodBeat.i(131117);
      this.pTx = new r.a();
      this.pTy = new r.b();
      AppMethodBeat.o(131117);
    }
    
    public final int getOptions()
    {
      return 1;
    }
    
    public final l.d getReqObjImp()
    {
      return this.pTx;
    }
    
    public final l.e getRespObj()
    {
      return this.pTy;
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
 * Qualified Name:     com.tencent.mm.plugin.account.friend.model.ad
 * JD-Core Version:    0.7.0.1
 */