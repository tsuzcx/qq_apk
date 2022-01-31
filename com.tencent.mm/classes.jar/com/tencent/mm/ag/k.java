package com.tencent.mm.ag;

import android.content.ContentValues;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.cf.h;
import com.tencent.mm.protocal.c.agf;
import com.tencent.mm.protocal.c.agg;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import java.io.IOException;
import java.io.OutputStream;

final class k
  extends m
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.ah.f dmL;
  private String ebD;
  private int ebH;
  private String ebJ;
  private int ebZ;
  private OutputStream eca = null;
  private String ecb;
  private String username;
  
  public k(String paramString)
  {
    this.username = paramString;
    if (ad.hd(paramString)) {
      this.username = ad.aaZ(paramString);
    }
    y.i("MicroMsg.NetSceneGetHDHeadImg", "init Headimage in_username:" + paramString + " out_username" + this.username);
    this.ebH = 480;
    this.ebZ = 480;
    this.ebJ = "jpg";
  }
  
  private int B(byte[] paramArrayOfByte)
  {
    try
    {
      if (this.eca == null) {
        this.eca = com.tencent.mm.vfs.e.I(this.ecb, false);
      }
      this.eca.write(paramArrayOfByte);
      return paramArrayOfByte.length;
    }
    catch (IOException paramArrayOfByte)
    {
      y.e("MicroMsg.NetSceneGetHDHeadImg", "exception:%s", new Object[] { bk.j(paramArrayOfByte) });
    }
    return -1;
  }
  
  private void Kb()
  {
    try
    {
      if (this.eca != null)
      {
        this.eca.flush();
        this.eca.close();
        this.eca = null;
      }
      return;
    }
    catch (IOException localIOException)
    {
      y.e("MicroMsg.NetSceneGetHDHeadImg", "exception:%s", new Object[] { bk.j(localIOException) });
    }
  }
  
  public static void aj(String paramString1, String paramString2)
  {
    o.JQ().ai(paramString1, paramString2);
  }
  
  protected final int Ka()
  {
    return 10;
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.ah.f paramf)
  {
    int j = 0;
    this.dmL = paramf;
    if ((this.username == null) || (this.username.length() == 0))
    {
      y.e("MicroMsg.NetSceneGetHDHeadImg", "username is null");
      return -1;
    }
    if (this.username.endsWith("@qqim"))
    {
      y.e("MicroMsg.NetSceneGetHDHeadImg", "never try get qq user hd.");
      return -1;
    }
    Object localObject1 = o.Ki();
    o.JQ();
    this.ebD = d.z(this.username, true);
    if (com.tencent.mm.vfs.e.bK(this.ebD))
    {
      y.i("MicroMsg.NetSceneGetHDHeadImg", "The HDAvatar of " + this.username + " is already exists");
      return 0;
    }
    this.ecb = (this.ebD + ".tmp");
    paramf = ((g)localObject1).kn(this.username);
    Object localObject2;
    if (paramf == null)
    {
      com.tencent.mm.vfs.e.deleteFile(this.ecb);
      paramf = new f();
      paramf.username = this.username;
      paramf.ebJ = this.ebJ;
      paramf.ebH = this.ebH;
      paramf.ebI = this.ebZ;
      paramf.bcw = -1;
      localObject2 = paramf.vf();
      ((g)localObject1).dXo.insert("hdheadimginfo", "username", (ContentValues)localObject2);
      localObject1 = new b.a();
      ((b.a)localObject1).ecH = new agf();
      ((b.a)localObject1).ecI = new agg();
      ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/gethdheadimg";
      ((b.a)localObject1).ecG = 158;
      ((b.a)localObject1).ecJ = 47;
      ((b.a)localObject1).ecK = 1000000047;
      localObject1 = ((b.a)localObject1).Kt();
      localObject2 = (agf)((com.tencent.mm.ah.b)localObject1).ecE.ecN;
      if (ad.hd(this.username)) {
        break label608;
      }
      ((agf)localObject2).hPY = this.username;
      ((agf)localObject2).tdY = 1;
    }
    for (;;)
    {
      y.d("MicroMsg.NetSceneGetHDHeadImg", "inUser:" + this.username + " outUser:" + ((agf)localObject2).hPY + " outType:" + ((agf)localObject2).tdY);
      ((agf)localObject2).tdV = this.ebH;
      ((agf)localObject2).tdW = this.ebZ;
      ((agf)localObject2).tdX = this.ebJ;
      ((agf)localObject2).ndf = paramf.ebK;
      ((agf)localObject2).ndg = paramf.ebL;
      return a(parame, (com.tencent.mm.network.q)localObject1, this);
      localObject2 = this.ecb;
      int i = j;
      if (paramf != null)
      {
        i = j;
        if (localObject2 != null)
        {
          if (((String)localObject2).length() != 0) {
            break label541;
          }
          i = j;
        }
      }
      for (;;)
      {
        if (i == 0)
        {
          com.tencent.mm.vfs.e.deleteFile(this.ecb);
          paramf.reset();
          paramf.username = this.username;
          paramf.ebJ = this.ebJ;
          paramf.ebH = this.ebH;
          paramf.ebI = this.ebZ;
          ((g)localObject1).a(this.username, paramf);
        }
        break;
        label541:
        i = j;
        if (paramf.JV().equals(this.ebJ))
        {
          i = j;
          if (paramf.ebH == this.ebH)
          {
            i = j;
            if (paramf.ebI == this.ebZ)
            {
              i = j;
              if (com.tencent.mm.vfs.e.aeQ((String)localObject2) == paramf.ebL) {
                i = 1;
              }
            }
          }
        }
      }
      label608:
      if (this.username.equals(com.tencent.mm.model.q.Gj() + "@bottle"))
      {
        ((agf)localObject2).hPY = com.tencent.mm.model.q.Gj();
        ((agf)localObject2).tdY = 2;
      }
      else
      {
        ((agf)localObject2).hPY = this.username;
        ((agf)localObject2).tdY = 2;
      }
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    paramArrayOfByte = (agg)((com.tencent.mm.ah.b)paramq).ecF.ecN;
    y.d("MicroMsg.NetSceneGetHDHeadImg", "errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 != 4) && (paramInt3 != 0))
    {
      y.e("MicroMsg.NetSceneGetHDHeadImg", "errType:" + paramInt2 + " errCode:" + paramInt3);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      Kb();
      return;
    }
    if ((paramInt2 == 4) || (paramInt2 == 5))
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      y.e("MicroMsg.NetSceneGetHDHeadImg", "ErrType:" + paramInt2);
      Kb();
      return;
    }
    paramInt1 = paramq.HF().spN;
    if ((paramInt1 == -4) || (paramInt1 == -54) || (paramInt1 == -55)) {
      y.e("MicroMsg.NetSceneGetHDHeadImg", "retcode == " + paramInt1);
    }
    for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
    {
      y.e("MicroMsg.NetSceneGetHDHeadImg", "handleCertainError");
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      Kb();
      return;
    }
    int i = -1;
    paramInt1 = i;
    if (paramArrayOfByte.ndi != null)
    {
      paramInt1 = i;
      if (paramArrayOfByte.ndi.tFM != null) {
        paramInt1 = B(paramArrayOfByte.ndi.tFM.oY);
      }
    }
    if (paramInt1 < 0)
    {
      y.e("MicroMsg.NetSceneGetHDHeadImg", "appendBuf fail");
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      Kb();
      return;
    }
    paramq = o.Ki();
    f localf = paramq.kn(this.username);
    localf.ebL = (paramInt1 + paramArrayOfByte.ndg);
    localf.ebK = paramArrayOfByte.ndf;
    paramq.a(this.username, localf);
    if (localf.ebL >= localf.ebK) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 != 0) {
        break label479;
      }
      y.i("MicroMsg.NetSceneGetHDHeadImg", "%d doScene again info[%s %d %d]", new Object[] { Integer.valueOf(hashCode()), this.username, Integer.valueOf(localf.ebL), Integer.valueOf(localf.ebK) });
      if (a(this.edc, this.dmL) >= 0) {
        break;
      }
      this.dmL.onSceneEnd(3, -1, "", this);
      return;
    }
    label479:
    com.tencent.mm.vfs.e.aA(this.ecb, this.ebD);
    aj(this.ebD, this.username);
    Kb();
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  protected final m.b b(com.tencent.mm.network.q paramq)
  {
    if ((this.username == null) || (this.username.length() == 0)) {
      return m.b.eds;
    }
    return m.b.edr;
  }
  
  protected final void cancel()
  {
    super.cancel();
    Kb();
  }
  
  public final int getType()
  {
    return 158;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ag.k
 * JD-Core Version:    0.7.0.1
 */