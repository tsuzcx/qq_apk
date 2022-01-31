package com.tencent.mm.modelmulti;

import android.os.HandlerThread;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.ayx;
import com.tencent.mm.protocal.c.ayy;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.r.a;
import com.tencent.mm.protocal.r.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.util.LinkedList;
import java.util.Queue;
import junit.framework.Assert;

public final class e
  extends m
  implements k
{
  f dmL;
  private final am ebj = new am(com.tencent.mm.kernel.g.DS().mnU.getLooper(), new e.1(this), true);
  final Queue<e.a> emr = new LinkedList();
  com.tencent.mm.ah.g eoM = null;
  int esA = 0;
  int esB = 0;
  boolean esC = false;
  g.a esm;
  private StringBuilder esn = new StringBuilder();
  final ayx esx = new ayx();
  int esy = 0;
  boolean esz = false;
  private int retryCount = 3;
  
  public e(com.tencent.mm.ah.g paramg)
  {
    y.i("MicroMsg.NetSceneInit.dkInit", "NetSceneInit hash:%d stack:%s", new Object[] { Integer.valueOf(hashCode()), bk.csb() });
    this.esn.append("stack:" + bk.csb() + " time:" + bk.UX());
    this.eoM = paramg;
  }
  
  private int a(com.tencent.mm.network.e parame, bmk parambmk1, bmk parambmk2)
  {
    this.esn.append(" lastd:" + this.edd + " dotime:" + bk.UX() + " net:" + aq.getNetType(ae.getContext()));
    e.b localb = new e.b();
    bmk localbmk = parambmk1;
    if (parambmk1 == null)
    {
      com.tencent.mm.kernel.g.DQ();
      localbmk = aa.I(bk.ZM(bk.pm((String)com.tencent.mm.kernel.g.DP().Dz().get(8197, null))));
    }
    parambmk1 = parambmk2;
    if (parambmk2 == null)
    {
      com.tencent.mm.kernel.g.DQ();
      parambmk1 = aa.I(bk.ZM(bk.pm((String)com.tencent.mm.kernel.g.DP().Dz().get(8198, null))));
    }
    com.tencent.mm.kernel.g.DQ();
    if ((bk.g((Integer)com.tencent.mm.kernel.g.DP().Dz().get(16, null)) != 0) && ((localbmk == null) || (localbmk.tFK <= 0))) {
      localb.Kv().spI = 7;
    }
    for (;;)
    {
      this.esx.tuH = localbmk;
      this.esx.tuI = parambmk1;
      ((r.a)localb.Kv()).sqg = this.esx;
      y.i("MicroMsg.NetSceneInit.dkInit", "doScene hash:%d time:%d count:%d user%s lan:%s status:%d cur[%s] max[%s]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.esm.zJ()), Integer.valueOf(this.esy), this.esx.hPY, this.esx.jxi, Integer.valueOf(localb.Kv().spI), bk.bG(aa.a(localbmk)), bk.bG(aa.a(parambmk1)) });
      this.esy += 1;
      return a(parame, localb, this);
      com.tencent.mm.kernel.g.DQ();
      if (bk.pm((String)com.tencent.mm.kernel.g.DP().Dz().get(8195, null)).length() <= 0) {
        localb.Kv().spI = 3;
      } else {
        localb.Kv().spI = 4;
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, String paramString, ayy paramayy)
  {
    e.a locala = new e.a(this);
    locala.esH = paramInt1;
    locala.errCode = paramInt3;
    locala.errType = paramInt2;
    locala.aox = paramString;
    locala.esG = paramayy;
    this.emr.add(locala);
    if (this.ebj.crl()) {
      this.ebj.S(50L, 50L);
    }
  }
  
  protected final int Ka()
  {
    return 500;
  }
  
  public final boolean Kx()
  {
    return true;
  }
  
  public final boolean Ky()
  {
    return super.Ky();
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.esm = new g.a();
    this.dmL = paramf;
    paramf = this.esx;
    com.tencent.mm.kernel.g.DQ();
    paramf.hPY = ((String)com.tencent.mm.kernel.g.DP().Dz().get(2, null));
    if (!bk.bl(this.esx.hPY)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("by DK: req.UserName is null", bool);
      this.esx.jxi = x.cqJ();
      return a(parame, null, null);
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    this.esn.append(" endtime:" + bk.UX());
    y.i("MicroMsg.NetSceneInit.dkInit", "summerinit onGYNetEnd [%d, %d, %s], tid:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(paramInt1) });
    if ((paramInt2 == 4) && (paramInt3 == -100))
    {
      y.e("MicroMsg.NetSceneInit.dkInit", "onGYNetEnd ERROR hash:%d [%d,%d] KICK OUT : %s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
      this.esC = true;
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    label259:
    do
    {
      do
      {
        return;
        if (((paramInt2 == 0) && (paramInt3 == 0)) || ((paramInt2 == 4) && (paramInt3 == -17))) {
          break label259;
        }
        y.e("MicroMsg.NetSceneInit.dkInit", "onGYNetEnd ERROR retry:%d hash:%d [%d,%d] %s", new Object[] { Integer.valueOf(this.retryCount), Integer.valueOf(hashCode()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
        if (this.retryCount <= 0) {
          break;
        }
        this.retryCount -= 1;
      } while (a(this.edc, null, null) != -1);
      this.esC = true;
      this.dmL.onSceneEnd(3, -1, "", this);
      return;
      paramq = ((r.b)paramq.HF()).sqh;
      this.esA += paramq.tuK;
      y.i("MicroMsg.NetSceneInit.dkInit", "onGYNetEnd hash:%d [%d,%d] time:%d cmdSum:%d doscenecount:%d conFlag:%d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(this.esm.zJ()), Integer.valueOf(this.esA), Integer.valueOf(this.esy), Integer.valueOf(paramq.sFD) });
      a(this.esy - 1, paramInt2, paramInt3, paramString, paramq);
      if (((paramq.sFD & 0x7) == 0) || (super.Ky())) {
        break;
      }
    } while (a(this.edc, paramq.tuH, paramq.tuI) != -1);
    y.e("MicroMsg.NetSceneInit.dkInit", "doScene Failed stop init");
    a(2147483647, 3, -1, "", null);
    return;
    y.i("MicroMsg.NetSceneInit.dkInit", "NETWORK FINISH onGYNetEnd hash:%d time:%d netCnt:%d", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.esm.zJ()), Integer.valueOf(this.esy) });
    this.esz = true;
    a(2147483647, 0, 0, "", null);
  }
  
  protected final m.b b(q paramq)
  {
    return m.b.edr;
  }
  
  protected final void cancel()
  {
    y.w("MicroMsg.NetSceneInit.dkInit", "init cancel by :%s", new Object[] { bk.csb() });
    super.cancel();
    this.esC = true;
  }
  
  public final String getInfo()
  {
    return this.esn.toString();
  }
  
  public final int getType()
  {
    return 139;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelmulti.e
 * JD-Core Version:    0.7.0.1
 */