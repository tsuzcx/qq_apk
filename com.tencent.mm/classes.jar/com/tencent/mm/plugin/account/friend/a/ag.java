package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.a;
import com.tencent.mm.al.n.b;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.bix;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;

public final class ag
  extends n
  implements k
{
  f callback;
  public final q hON;
  
  public ag(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(131118);
    this.callback = null;
    this.hON = new a();
    u.a locala = (u.a)this.hON.getReqObj();
    locala.jdX.GDt = paramString1;
    locala.jdX.GDu = paramString2;
    locala.jdX.nEt = paramString3;
    locala.jdX.GDv = paramString4;
    locala.jdX.GDw = paramString5;
    locala.jdX.GDx = paramString6;
    locala.jdX.GDy = paramInt;
    locala.jdX.qei = com.tencent.mm.sdk.platformtools.ac.fks();
    paramString1 = locala.jdX;
    g.ajA();
    paramString1.FzI = a.aiO();
    AppMethodBeat.o(131118);
  }
  
  public final String aKL()
  {
    AppMethodBeat.i(131122);
    String str = ((u.b)this.hON.getRespObj()).jdY.GDw;
    AppMethodBeat.o(131122);
    return str;
  }
  
  public final byte[] aKM()
  {
    AppMethodBeat.i(131121);
    byte[] arrayOfByte = z.a(((u.b)this.hON.getRespObj()).jdY.GDz, new byte[0]);
    AppMethodBeat.o(131121);
    return arrayOfByte;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(131119);
    this.callback = paramf;
    int i = dispatch(parame, this.hON, this);
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
      ad.d("MicroMsg.NetSceneGetSuggestAlias", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[] { Integer.valueOf(paramInt1) });
      g.ajF().ay(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(131116);
          new com.tencent.mm.modelsimple.l().doScene(ag.this.dispatcher(), new f()
          {
            public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, n paramAnonymous2n)
            {
              AppMethodBeat.i(131115);
              ad.d("MicroMsg.NetSceneGetSuggestAlias", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[] { Integer.valueOf(paramAnonymous2n.getType()), Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
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
    return n.b.hOp;
  }
  
  public final void setSecurityCheckError(n.a parama) {}
  
  public static final class a
    extends com.tencent.mm.al.l
  {
    private final u.a jeu;
    private final u.b jev;
    
    public a()
    {
      AppMethodBeat.i(131117);
      this.jeu = new u.a();
      this.jev = new u.b();
      AppMethodBeat.o(131117);
    }
    
    public final int getOptions()
    {
      return 1;
    }
    
    public final l.d getReqObjImp()
    {
      return this.jeu;
    }
    
    public final l.e getRespObj()
    {
      return this.jev;
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