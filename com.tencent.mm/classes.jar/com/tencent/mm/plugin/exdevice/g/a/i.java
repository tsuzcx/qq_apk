package com.tencent.mm.plugin.exdevice.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.protocal.protobuf.amf;
import com.tencent.mm.protocal.protobuf.bca;
import com.tencent.mm.protocal.protobuf.bcb;
import com.tencent.mm.protocal.protobuf.cxr;
import com.tencent.mm.protocal.protobuf.dxc;
import com.tencent.mm.protocal.protobuf.dxd;
import com.tencent.mm.protocal.protobuf.pq;
import com.tencent.mm.storage.bg;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class i
  extends com.tencent.mm.plugin.exdevice.b.a<bca, bcb>
{
  public String appName;
  public String coverUrl;
  private final WeakReference<com.tencent.mm.plugin.exdevice.b.b<i>> oTz;
  public String oXY;
  public String oXZ;
  public String oYa;
  public String oYb;
  public List<cxr> oYc;
  public List<dxd> oYd;
  public dxc oYe;
  public ArrayList<String> oYf;
  public List<amf> oYg;
  public List<pq> oYh;
  public boolean oYi;
  public int oYj;
  public boolean oYk;
  public String source;
  public String username;
  
  public i(String paramString1, String paramString2, com.tencent.mm.plugin.exdevice.b.b<i> paramb)
  {
    AppMethodBeat.i(23522);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetSceneGetProfileDetail", "appusername: %s, username: %s", new Object[] { paramString2, paramString1 });
    this.username = paramString1;
    this.appName = paramString2;
    this.oTz = new WeakReference(paramb);
    AppMethodBeat.o(23522);
  }
  
  public final int getType()
  {
    return 1043;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmbiz-bin/rank/getuserrankdetail";
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23523);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetSceneGetProfileDetail", "hy: getdetail scene gy end. errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (bcb)bxu();
      this.coverUrl = paramq.DzA;
      this.oXZ = paramq.oXZ;
      this.oYd = paramq.DzD;
      this.oYe = paramq.DzB;
      this.oYa = paramq.DzF;
      this.source = paramq.source;
      this.oYb = paramq.DzG;
      this.oYc = paramq.Cyc;
      this.oYi = paramq.oYi;
      this.oYg = paramq.Cxt;
      this.oYh = paramq.DzH;
      this.oYf = new ArrayList();
      this.oYj = paramq.peJ;
      this.oYk = paramq.DzI;
      this.oXY = paramq.oXY;
      if (paramq.DzE != null) {
        this.oYf.addAll(paramq.DzE);
      }
      this.oYc = new LinkedList();
      if (paramq.Cyc != null) {
        this.oYc.addAll(paramq.Cyc);
      }
      Object localObject1;
      if ((this.username != null) && (!this.username.equalsIgnoreCase(u.aqG())))
      {
        if (!this.oYi) {
          com.tencent.mm.plugin.exdevice.model.ad.bZI().UM(this.username);
        }
      }
      else
      {
        if (paramq.Cxt == null) {
          break label564;
        }
        paramArrayOfByte = new ArrayList();
        localObject1 = paramq.Cxt.iterator();
      }
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label512;
        }
        Object localObject2 = (amf)((Iterator)localObject1).next();
        az.arV();
        if (com.tencent.mm.model.c.apM().aHT(((amf)localObject2).username))
        {
          com.tencent.mm.plugin.exdevice.g.b.a.c localc = new com.tencent.mm.plugin.exdevice.g.b.a.c();
          localc.field_username = ((amf)localObject2).username;
          localc.field_step = ((amf)localObject2).jzV;
          paramArrayOfByte.add(localc);
          continue;
          paramArrayOfByte = com.tencent.mm.plugin.exdevice.model.ad.bZI();
          localObject1 = this.username;
          if (paramArrayOfByte.a(new com.tencent.mm.plugin.exdevice.g.b.b("hardcode_rank_id", "hardcode_app_name", (String)localObject1)) != null) {
            break;
          }
          localObject2 = new com.tencent.mm.plugin.exdevice.g.b.a.c();
          ((com.tencent.mm.plugin.exdevice.g.b.a.c)localObject2).field_rankID = "hardcode_rank_id";
          ((com.tencent.mm.plugin.exdevice.g.b.a.c)localObject2).field_appusername = "hardcode_app_name";
          ((com.tencent.mm.plugin.exdevice.g.b.a.c)localObject2).field_username = ((String)localObject1);
          ((com.tencent.mm.plugin.exdevice.g.b.a.c)localObject2).field_step = 0;
          paramArrayOfByte.insert((com.tencent.mm.sdk.e.c)localObject2);
          break;
        }
        az.aeS().a(new h(((amf)localObject2).username, null), 0);
      }
      label512:
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetSceneGetProfileDetail", "follows %d %s", new Object[] { Integer.valueOf(paramArrayOfByte.size()), paramArrayOfByte.toString() });
      if (u.aqG().equalsIgnoreCase(this.username)) {
        com.tencent.mm.plugin.exdevice.model.ad.bZI().cT(paramArrayOfByte);
      }
      label564:
      this.oYh = new ArrayList();
      if (paramq.DzH != null) {
        this.oYh.addAll(paramq.DzH);
      }
      this.oYi = paramq.oYi;
      paramq = new com.tencent.mm.plugin.exdevice.g.b.a.a();
      paramq.field_championMotto = this.oXZ;
      paramq.field_championUrl = this.coverUrl;
      paramq.field_username = this.username;
      com.tencent.mm.plugin.exdevice.model.ad.bZK().a(paramq);
    }
    paramq = (com.tencent.mm.plugin.exdevice.b.b)this.oTz.get();
    if (paramq != null) {
      paramq.a(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(23523);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.a.i
 * JD-Core Version:    0.7.0.1
 */