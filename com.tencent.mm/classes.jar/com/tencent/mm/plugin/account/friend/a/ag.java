package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.l;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.a;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.bjp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;

public final class ag
  extends n
  implements k
{
  f callback;
  public final q hRG;
  
  public ag(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(131118);
    this.callback = null;
    this.hRG = new a();
    u.a locala = (u.a)this.hRG.getReqObj();
    locala.jgQ.GWW = paramString1;
    locala.jgQ.GWX = paramString2;
    locala.jgQ.nJO = paramString3;
    locala.jgQ.GWY = paramString4;
    locala.jgQ.GWZ = paramString5;
    locala.jgQ.GXa = paramString6;
    locala.jgQ.GXb = paramInt;
    locala.jgQ.qkN = ad.fom();
    paramString1 = locala.jgQ;
    g.ajP();
    paramString1.FSg = a.ajd();
    AppMethodBeat.o(131118);
  }
  
  public final String aLi()
  {
    AppMethodBeat.i(131122);
    String str = ((u.b)this.hRG.getRespObj()).jgR.GWZ;
    AppMethodBeat.o(131122);
    return str;
  }
  
  public final byte[] aLj()
  {
    AppMethodBeat.i(131121);
    byte[] arrayOfByte = z.a(((u.b)this.hRG.getRespObj()).jgR.GXc, new byte[0]);
    AppMethodBeat.o(131121);
    return arrayOfByte;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(131119);
    this.callback = paramf;
    int i = dispatch(parame, this.hRG, this);
    AppMethodBeat.o(131119);
    return i;
  }
  
  public final int getType()
  {
    return 429;
  }
  
  public final void onGYNetEnd(final int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(131120);
    if ((paramInt2 == 4) && (paramInt3 == -102))
    {
      paramInt1 = paramq.getReqObj().getRsaInfo().ver;
      ae.d("MicroMsg.NetSceneGetSuggestAlias", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[] { Integer.valueOf(paramInt1) });
      g.ajU().aw(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(131116);
          new m().doScene(ag.this.dispatcher(), new f()
          {
            public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, n paramAnonymous2n)
            {
              AppMethodBeat.i(131115);
              ae.d("MicroMsg.NetSceneGetSuggestAlias", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[] { Integer.valueOf(paramAnonymous2n.getType()), Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
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
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.hRi;
  }
  
  public final void setSecurityCheckError(n.a parama) {}
  
  public static final class a
    extends l
  {
    private final u.a jhn;
    private final u.b jho;
    
    public a()
    {
      AppMethodBeat.i(131117);
      this.jhn = new u.a();
      this.jho = new u.b();
      AppMethodBeat.o(131117);
    }
    
    public final int getOptions()
    {
      return 1;
    }
    
    public final l.d getReqObjImp()
    {
      return this.jhn;
    }
    
    public final l.e getRespObj()
    {
      return this.jho;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.ag
 * JD-Core Version:    0.7.0.1
 */