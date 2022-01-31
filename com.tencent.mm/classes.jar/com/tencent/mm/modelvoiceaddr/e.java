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
import com.tencent.mm.protocal.c.caz;
import com.tencent.mm.protocal.c.cba;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.util.Set;

public final class e
  extends a
  implements k
{
  private com.tencent.mm.ah.b dmK;
  f dmL;
  int eBa = 0;
  boolean eJS = false;
  private long eLA = -1L;
  private boolean eLB = false;
  private String[] eLD = new String[0];
  private int eLF = 0;
  am ebj = new am(new am.a()
  {
    public final boolean tC()
    {
      long l = com.tencent.mm.vfs.e.aeQ(e.this.filename);
      y.d("MicroMsg.NetSceneVoiceInput", com.tencent.mm.compatible.util.g.zI() + " onTimerExpired: file:" + e.this.filename + " nowlen:" + l + " oldoff:" + e.this.eBa + " isFin:" + e.this.eJS);
      if ((l - e.this.eBa < 3300L) && (!e.this.eJS)) {
        return true;
      }
      if (e.this.a(e.this.edc, e.this.dmL) == -1)
      {
        e.this.retCode = (com.tencent.mm.compatible.util.g.getLine() + 40000);
        e.this.dmL.onSceneEnd(3, -1, "doScene failed", e.this);
      }
      return false;
    }
  }, true);
  String filename = null;
  int retCode = 0;
  
  public e(String paramString, int paramInt)
  {
    this.filename = paramString;
    this.eLF = paramInt;
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
    this.dmL = paramf;
    int k = (int)com.tencent.mm.vfs.e.aeQ(this.filename);
    y.d("MicroMsg.NetSceneVoiceInput", "read file: %s, filelen: %d, oldoff: %d, isFin: %b", new Object[] { this.filename, Integer.valueOf(k), Integer.valueOf(this.eBa), Boolean.valueOf(this.eJS) });
    if (k <= 0)
    {
      y.e("MicroMsg.NetSceneVoiceInput", "read failed :" + this.filename);
      this.retCode = (com.tencent.mm.compatible.util.g.getLine() + 40000);
      return -1;
    }
    int j = k - this.eBa;
    if (j > 3960) {
      i = 3960;
    }
    for (;;)
    {
      y.d("MicroMsg.NetSceneVoiceInput", "read file: %s, filelen: %d, oldoff: %b, isFin:%b, endFlag: %b", new Object[] { this.filename, Integer.valueOf(k), Boolean.valueOf(this.eJS), Boolean.valueOf(this.eJS), Boolean.valueOf(this.eLB) });
      paramf = com.tencent.mm.vfs.e.c(this.filename, this.eBa, i);
      if (paramf != null) {
        break;
      }
      y.e("MicroMsg.NetSceneVoiceInput", com.tencent.mm.compatible.util.g.zI() + " read failed :" + this.filename + " read:" + i);
      this.retCode = (com.tencent.mm.compatible.util.g.getLine() + 40000);
      return -1;
      if ((j < 3300) && (!this.eJS))
      {
        y.e("MicroMsg.NetSceneVoiceInput", com.tencent.mm.compatible.util.g.zI() + " read failed :" + this.filename + "can read:" + j + " isfinish:" + this.eJS);
        this.retCode = (com.tencent.mm.compatible.util.g.getLine() + 40000);
        return -1;
      }
      i = j;
      if (this.eJS)
      {
        this.eLB = true;
        i = j;
      }
    }
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new caz();
    ((b.a)localObject).ecI = new cba();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/uploadinputvoice";
    ((b.a)localObject).ecG = 349;
    ((b.a)localObject).ecJ = 158;
    ((b.a)localObject).ecK = 1000000158;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (caz)this.dmK.ecE.ecN;
    ((caz)localObject).hPY = ((String)com.tencent.mm.kernel.g.DP().Dz().get(2, ""));
    ((caz)localObject).ndi = new bmk().bs(paramf);
    y.d("MicroMsg.NetSceneVoiceInput", com.tencent.mm.compatible.util.g.zI() + " read file:" + this.filename + " readlen:" + paramf.length + " datalen:" + ((caz)localObject).ndi.tFM.toByteArray().length + " dataiLen:" + ((caz)localObject).ndi.tFK + " md5:" + com.tencent.mm.a.g.o(paramf) + " datamd5:" + com.tencent.mm.a.g.o(((caz)localObject).ndi.tFM.toByteArray()));
    ((caz)localObject).sDT = this.eBa;
    ((caz)localObject).tQb = this.eLA;
    if (this.eLB) {}
    for (int i = 1;; i = 0)
    {
      ((caz)localObject).euw = i;
      ((caz)localObject).tQc = 0;
      ((caz)localObject).sxS = 0;
      ((caz)localObject).tQd = this.eLF;
      ((caz)localObject).sxP = 0;
      y.d("MicroMsg.NetSceneVoiceInput", "clientId " + this.eLA);
      return a(parame, this.dmK, this);
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneVoiceInput", "onGYNetEnd file:" + this.filename + " errtype:" + paramInt2 + " errCode:" + paramInt3);
    paramArrayOfByte = (caz)((com.tencent.mm.ah.b)paramq).ecE.ecN;
    paramq = (cba)((com.tencent.mm.ah.b)paramq).ecF.ecN;
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      y.e("MicroMsg.NetSceneVoiceInput", com.tencent.mm.compatible.util.g.zI() + " onGYNetEnd file:" + this.filename + " errType:" + paramInt2 + " errCode:" + paramInt3);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    y.d("MicroMsg.NetSceneVoiceInput", com.tencent.mm.compatible.util.g.zI() + " onGYNetEnd  file:" + this.filename + " endflag:" + paramq.euw);
    if (paramArrayOfByte.euw == 1)
    {
      if ((paramq.tQe != null) && (paramq.tQe.tFM != null)) {
        this.eLD = new String[] { paramq.tQe.tFM.coM() };
      }
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    paramInt1 = paramArrayOfByte.sDT;
    this.eBa = (paramArrayOfByte.ndi.tFK + paramInt1);
    if (this.eJS) {}
    for (long l = 0L;; l = 500L)
    {
      y.d("MicroMsg.NetSceneVoiceInput", "onGYNetEnd file:" + this.filename + " delay:" + l);
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
    return 349;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.e
 * JD-Core Version:    0.7.0.1
 */