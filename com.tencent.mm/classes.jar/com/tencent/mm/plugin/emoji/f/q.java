package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.aiw;
import com.tencent.mm.protocal.c.aix;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class q
  extends m
  implements k
{
  private final b dmK;
  private com.tencent.mm.ah.f dmL;
  private int fzn;
  public byte[] iZW = null;
  private int jah;
  
  public q(int paramInt, byte[] paramArrayOfByte)
  {
    this(paramInt, paramArrayOfByte, (byte)0);
  }
  
  private q(int paramInt, byte[] paramArrayOfByte, byte paramByte)
  {
    b.a locala = new b.a();
    locala.ecH = new aiw();
    locala.ecI = new aix();
    locala.uri = "/cgi-bin/micromsg-bin/mmgetpersonaldesigner";
    locala.ecG = 720;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    this.jah = paramInt;
    this.iZW = paramArrayOfByte;
    this.fzn = 0;
  }
  
  public static com.tencent.mm.plugin.emoji.model.f a(aix paramaix)
  {
    y.d("MicroMsg.emoji.NetSceneGetPersonalDesigner", "getEmotionListModel");
    if (paramaix == null) {
      return null;
    }
    com.tencent.mm.plugin.emoji.model.f localf = new com.tencent.mm.plugin.emoji.model.f();
    if ((paramaix != null) && (paramaix.tda != null))
    {
      localf.iYg = paramaix.tda.size();
      ArrayList localArrayList = new ArrayList();
      paramaix = paramaix.tda.iterator();
      while (paramaix.hasNext())
      {
        vn localvn = (vn)paramaix.next();
        if (localvn.syc != null) {
          localArrayList.add(new com.tencent.mm.plugin.emoji.a.a.f(localvn));
        }
      }
      localf.iYh = localArrayList;
    }
    return localf;
  }
  
  protected final int Ka()
  {
    return 100;
  }
  
  public final int a(e parame, com.tencent.mm.ah.f paramf)
  {
    this.dmL = paramf;
    paramf = (aiw)this.dmK.ecE.ecN;
    paramf.tcH = this.jah;
    if (this.iZW != null)
    {
      paramf.swr = aa.I(this.iZW);
      paramf.pyo = this.fzn;
      if (paramf.swr != null) {
        break label94;
      }
    }
    label94:
    for (paramf = "Buf is NULL";; paramf = paramf.swr.toString())
    {
      y.d("MicroMsg.emoji.NetSceneGetPersonalDesigner", paramf);
      return a(parame, this.dmK, this);
      paramf.swr = new bmk();
      break;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.emoji.NetSceneGetPersonalDesigner", "NetSceneGetPersonalDesigner errType:%d,errcode:%d,errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = (aix)((b)paramq).ecF.ecN;
    if (paramq.swr != null) {
      this.iZW = aa.a(paramq.swr);
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final aix aIl()
  {
    if (this.dmK == null) {
      return null;
    }
    return (aix)this.dmK.ecF.ecN;
  }
  
  protected final m.b b(com.tencent.mm.network.q paramq)
  {
    return m.b.edr;
  }
  
  public final int getType()
  {
    return 720;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.q
 * JD-Core Version:    0.7.0.1
 */