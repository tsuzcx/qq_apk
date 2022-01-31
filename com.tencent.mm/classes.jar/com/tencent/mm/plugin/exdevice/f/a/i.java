package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.protocal.protobuf.adu;
import com.tencent.mm.protocal.protobuf.arh;
import com.tencent.mm.protocal.protobuf.ari;
import com.tencent.mm.protocal.protobuf.cgp;
import com.tencent.mm.protocal.protobuf.dcb;
import com.tencent.mm.protocal.protobuf.dcc;
import com.tencent.mm.protocal.protobuf.nl;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bd;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class i
  extends com.tencent.mm.plugin.exdevice.a.a<arh, ari>
{
  public String appName;
  private final WeakReference<com.tencent.mm.plugin.exdevice.a.b<i>> lCN;
  public boolean lHA;
  public String lHn;
  public String lHo;
  public String lHp;
  public String lHq;
  public String lHr;
  public List<cgp> lHs;
  public List<dcc> lHt;
  public dcb lHu;
  public ArrayList<String> lHv;
  public List<adu> lHw;
  public List<nl> lHx;
  public boolean lHy;
  public int lHz;
  public String source;
  public String username;
  
  public i(String paramString1, String paramString2, com.tencent.mm.plugin.exdevice.a.b<i> paramb)
  {
    AppMethodBeat.i(19454);
    ab.d("MicroMsg.NetSceneGetProfileDetail", "appusername: %s, username: %s", new Object[] { paramString2, paramString1 });
    this.username = paramString1;
    this.appName = paramString2;
    this.lCN = new WeakReference(paramb);
    AppMethodBeat.o(19454);
  }
  
  public final int getType()
  {
    return 1043;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmbiz-bin/rank/getuserrankdetail";
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(19455);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    ab.d("MicroMsg.NetSceneGetProfileDetail", "hy: getdetail scene gy end. errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (ari)aUl();
      this.lHo = paramq.xgy;
      this.lHp = paramq.lHp;
      this.lHt = paramq.xgB;
      this.lHu = paramq.xgz;
      this.lHq = paramq.xgD;
      this.source = paramq.source;
      this.lHr = paramq.xgE;
      this.lHs = paramq.wpw;
      this.lHy = paramq.lHy;
      this.lHw = paramq.woL;
      this.lHx = paramq.xgF;
      this.lHv = new ArrayList();
      this.lHz = paramq.lNX;
      this.lHA = paramq.xgG;
      this.lHn = paramq.lHn;
      if (paramq.xgC != null) {
        this.lHv.addAll(paramq.xgC);
      }
      this.lHs = new LinkedList();
      if (paramq.wpw != null) {
        this.lHs.addAll(paramq.wpw);
      }
      Object localObject1;
      if ((this.username != null) && (!this.username.equalsIgnoreCase(r.Zn())))
      {
        if (!this.lHy) {
          ad.bqa().LD(this.username);
        }
      }
      else
      {
        if (paramq.woL == null) {
          break label564;
        }
        paramArrayOfByte = new ArrayList();
        localObject1 = paramq.woL.iterator();
      }
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label512;
        }
        Object localObject2 = (adu)((Iterator)localObject1).next();
        aw.aaz();
        if (com.tencent.mm.model.c.YA().arr(((adu)localObject2).username))
        {
          com.tencent.mm.plugin.exdevice.f.b.a.c localc = new com.tencent.mm.plugin.exdevice.f.b.a.c();
          localc.field_username = ((adu)localObject2).username;
          localc.field_step = ((adu)localObject2).hAu;
          paramArrayOfByte.add(localc);
          continue;
          paramArrayOfByte = ad.bqa();
          localObject1 = this.username;
          if (paramArrayOfByte.a(new com.tencent.mm.plugin.exdevice.f.b.b("hardcode_rank_id", "hardcode_app_name", (String)localObject1)) != null) {
            break;
          }
          localObject2 = new com.tencent.mm.plugin.exdevice.f.b.a.c();
          ((com.tencent.mm.plugin.exdevice.f.b.a.c)localObject2).field_rankID = "hardcode_rank_id";
          ((com.tencent.mm.plugin.exdevice.f.b.a.c)localObject2).field_appusername = "hardcode_app_name";
          ((com.tencent.mm.plugin.exdevice.f.b.a.c)localObject2).field_username = ((String)localObject1);
          ((com.tencent.mm.plugin.exdevice.f.b.a.c)localObject2).field_step = 0;
          paramArrayOfByte.insert((com.tencent.mm.sdk.e.c)localObject2);
          break;
        }
        aw.Rc().a(new h(((adu)localObject2).username, null), 0);
      }
      label512:
      ab.d("MicroMsg.NetSceneGetProfileDetail", "follows %d %s", new Object[] { Integer.valueOf(paramArrayOfByte.size()), paramArrayOfByte.toString() });
      if (r.Zn().equalsIgnoreCase(this.username)) {
        ad.bqa().bv(paramArrayOfByte);
      }
      label564:
      this.lHx = new ArrayList();
      if (paramq.xgF != null) {
        this.lHx.addAll(paramq.xgF);
      }
      this.lHy = paramq.lHy;
      paramq = new com.tencent.mm.plugin.exdevice.f.b.a.a();
      paramq.field_championMotto = this.lHp;
      paramq.field_championUrl = this.lHo;
      paramq.field_username = this.username;
      ad.bqc().a(paramq);
    }
    paramq = (com.tencent.mm.plugin.exdevice.a.b)this.lCN.get();
    if (paramq != null) {
      paramq.a(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(19455);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.a.i
 * JD-Core Version:    0.7.0.1
 */