package com.tencent.mm.modelvoiceaddr;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.m.a;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.cdq;
import com.tencent.mm.protocal.c.cdr;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.util.LinkedList;
import java.util.Set;

public final class d
  extends a
  implements k
{
  private com.tencent.mm.ah.b dmK;
  f dmL;
  int eBa = 0;
  boolean eJS = false;
  private long eLA = -1L;
  private boolean eLB = false;
  private int eLC;
  private String[] eLD = new String[0];
  am ebj = new am(new am.a()
  {
    public final boolean tC()
    {
      long l = com.tencent.mm.vfs.e.aeQ(d.this.filename);
      y.d("MicroMsg.NetSceneVoiceAddr", com.tencent.mm.compatible.util.g.zI() + " onTimerExpired: file:" + d.this.filename + " nowlen:" + l + " oldoff:" + d.this.eBa + " isFin:" + d.this.eJS);
      if ((l - d.this.eBa < 3300L) && (!d.this.eJS)) {
        return true;
      }
      if (d.this.a(d.this.edc, d.this.dmL) == -1)
      {
        d.this.retCode = (com.tencent.mm.compatible.util.g.getLine() + 40000);
        d.this.dmL.onSceneEnd(3, -1, "doScene failed", d.this);
      }
      return false;
    }
  }, true);
  String filename = null;
  int retCode = 0;
  
  public d(String paramString, int paramInt)
  {
    this.filename = paramString;
    this.eLC = paramInt;
  }
  
  protected final int Ka()
  {
    return 20;
  }
  
  public final void Tp()
  {
    this.eJS = true;
  }
  
  public final String[] Tq()
  {
    return this.eLD;
  }
  
  public final long Tr()
  {
    return this.eLA;
  }
  
  public final int Ts()
  {
    return this.retCode;
  }
  
  public final Set<String> Tt()
  {
    return null;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    int i = 3960;
    this.dmL = paramf;
    long l = com.tencent.mm.vfs.e.aeQ(this.filename);
    y.d("MicroMsg.NetSceneVoiceAddr", com.tencent.mm.compatible.util.g.zI() + " read file:" + this.filename + " filelen:" + l + " oldoff:" + this.eBa + " isFin:" + this.eJS);
    if (l <= 0L)
    {
      y.e("MicroMsg.NetSceneVoiceAddr", "read failed :" + this.filename);
      this.retCode = (com.tencent.mm.compatible.util.g.getLine() + 40000);
      return -1;
    }
    int j = (int)(l - this.eBa);
    if (j > 3960) {}
    for (;;)
    {
      y.d("MicroMsg.NetSceneVoiceAddr", com.tencent.mm.compatible.util.g.zI() + " read file:" + this.filename + " filelen:" + l + " oldoff:" + this.eBa + " isFin:" + this.eJS + " endFlag:" + this.eLB);
      paramf = com.tencent.mm.vfs.e.c(this.filename, this.eBa, i);
      if (paramf != null) {
        break;
      }
      y.e("MicroMsg.NetSceneVoiceAddr", com.tencent.mm.compatible.util.g.zI() + " read failed :" + this.filename + " read:" + i);
      this.retCode = (com.tencent.mm.compatible.util.g.getLine() + 40000);
      return -1;
      if ((j < 3300) && (!this.eJS))
      {
        y.e("MicroMsg.NetSceneVoiceAddr", com.tencent.mm.compatible.util.g.zI() + " read failed :" + this.filename + "can read:" + j + " isfinish:" + this.eJS);
        this.retCode = (com.tencent.mm.compatible.util.g.getLine() + 40000);
        return -1;
      }
      if (this.eJS) {
        this.eLB = true;
      }
      i = j;
    }
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new cdq();
    ((b.a)localObject).ecI = new cdr();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voiceaddr";
    ((b.a)localObject).ecG = 206;
    ((b.a)localObject).ecJ = 94;
    ((b.a)localObject).ecK = 1000000094;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (cdq)this.dmK.ecE.ecN;
    ((cdq)localObject).ndi = new bmk().bs(paramf);
    y.d("MicroMsg.NetSceneVoiceAddr", com.tencent.mm.compatible.util.g.zI() + " read file:" + this.filename + " readlen:" + paramf.length + " datalen:" + ((cdq)localObject).ndi.tFM.toByteArray().length + " dataiLen:" + ((cdq)localObject).ndi.tFK + " md5:" + com.tencent.mm.a.g.o(paramf) + " datamd5:" + com.tencent.mm.a.g.o(((cdq)localObject).ndi.tFM.toByteArray()));
    ((cdq)localObject).hPY = ((String)com.tencent.mm.kernel.g.DP().Dz().get(2, ""));
    ((cdq)localObject).sDT = this.eBa;
    ((cdq)localObject).tQb = this.eLA;
    if (this.eLB) {}
    for (i = 1;; i = 0)
    {
      ((cdq)localObject).euw = i;
      ((cdq)localObject).tQc = 0;
      ((cdq)localObject).sxS = 0;
      ((cdq)localObject).tQd = 0;
      ((cdq)localObject).sxP = 0;
      ((cdq)localObject).tSo = this.eLC;
      y.d("MicroMsg.NetSceneVoiceAddr", "clientId " + this.eLA);
      return a(parame, this.dmK, this);
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneVoiceAddr", com.tencent.mm.compatible.util.g.zI() + " onGYNetEnd file:" + this.filename + " errtype:" + paramInt2 + " errCode:" + paramInt3);
    paramArrayOfByte = (cdq)((com.tencent.mm.ah.b)paramq).ecE.ecN;
    paramq = (cdr)((com.tencent.mm.ah.b)paramq).ecF.ecN;
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      y.e("MicroMsg.NetSceneVoiceAddr", com.tencent.mm.compatible.util.g.zI() + " onGYNetEnd file:" + this.filename + " errType:" + paramInt2 + " errCode:" + paramInt3);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    y.d("MicroMsg.NetSceneVoiceAddr", com.tencent.mm.compatible.util.g.zI() + " onGYNetEnd  file:" + this.filename + " endflag:" + paramq.euw + " lst:" + paramq.svn);
    if (paramArrayOfByte.euw == 1)
    {
      this.eLD = new String[paramq.svn.size()];
      paramInt1 = 0;
      while (paramInt1 < paramq.svn.size())
      {
        this.eLD[paramInt1] = ((bml)paramq.svn.get(paramInt1)).tFO;
        paramInt1 += 1;
      }
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    paramInt1 = paramArrayOfByte.sDT;
    this.eBa = (paramArrayOfByte.ndi.tFK + paramInt1);
    if (this.eJS) {}
    for (long l = 0L;; l = 500L)
    {
      y.d("MicroMsg.NetSceneVoiceAddr", "onGYNetEnd file:" + this.filename + " delay:" + l);
      this.ebj.S(l, l);
      return;
    }
  }
  
  protected final void a(m.a parama)
  {
    this.dmL.onSceneEnd(3, com.tencent.mm.compatible.util.g.getLine() + 40000, "ecurityCheckError", this);
  }
  
  protected final m.b b(q paramq)
  {
    return m.b.edr;
  }
  
  public final int getType()
  {
    return 206;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.d
 * JD-Core Version:    0.7.0.1
 */