package com.tencent.mm.plugin.exdevice.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.protocal.protobuf.api;
import com.tencent.mm.protocal.protobuf.bfs;
import com.tencent.mm.protocal.protobuf.bft;
import com.tencent.mm.protocal.protobuf.ddd;
import com.tencent.mm.protocal.protobuf.ect;
import com.tencent.mm.protocal.protobuf.ecu;
import com.tencent.mm.protocal.protobuf.px;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.bj;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class i
  extends com.tencent.mm.plugin.exdevice.b.a<bfs, bft>
{
  public String appName;
  public String coverUrl;
  public String pBj;
  public String pBk;
  public String pBl;
  public String pBm;
  public List<ddd> pBn;
  public List<ecu> pBo;
  public ect pBp;
  public ArrayList<String> pBq;
  public List<api> pBr;
  public List<px> pBs;
  public boolean pBt;
  public int pBu;
  public boolean pBv;
  private final WeakReference<com.tencent.mm.plugin.exdevice.b.b<i>> pwK;
  public String source;
  public String username;
  
  public i(String paramString1, String paramString2, com.tencent.mm.plugin.exdevice.b.b<i> paramb)
  {
    AppMethodBeat.i(23522);
    ac.d("MicroMsg.NetSceneGetProfileDetail", "appusername: %s, username: %s", new Object[] { paramString2, paramString1 });
    this.username = paramString1;
    this.appName = paramString2;
    this.pwK = new WeakReference(paramb);
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
    ac.d("MicroMsg.NetSceneGetProfileDetail", "hy: getdetail scene gy end. errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (bft)bEq();
      this.coverUrl = paramq.EUW;
      this.pBk = paramq.pBk;
      this.pBo = paramq.EUZ;
      this.pBp = paramq.EUX;
      this.pBl = paramq.EVb;
      this.source = paramq.source;
      this.pBm = paramq.EVc;
      this.pBn = paramq.DQy;
      this.pBt = paramq.pBt;
      this.pBr = paramq.DPP;
      this.pBs = paramq.EVd;
      this.pBq = new ArrayList();
      this.pBu = paramq.pHU;
      this.pBv = paramq.EVe;
      this.pBj = paramq.pBj;
      if (paramq.EVa != null) {
        this.pBq.addAll(paramq.EVa);
      }
      this.pBn = new LinkedList();
      if (paramq.DQy != null) {
        this.pBn.addAll(paramq.DQy);
      }
      Object localObject1;
      if ((this.username != null) && (!this.username.equalsIgnoreCase(u.axw())))
      {
        if (!this.pBt) {
          ad.cgR().YY(this.username);
        }
      }
      else
      {
        if (paramq.DPP == null) {
          break label564;
        }
        paramArrayOfByte = new ArrayList();
        localObject1 = paramq.DPP.iterator();
      }
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label512;
        }
        Object localObject2 = (api)((Iterator)localObject1).next();
        az.ayM();
        if (com.tencent.mm.model.c.awB().aNo(((api)localObject2).username))
        {
          com.tencent.mm.plugin.exdevice.g.b.a.c localc = new com.tencent.mm.plugin.exdevice.g.b.a.c();
          localc.field_username = ((api)localObject2).username;
          localc.field_step = ((api)localObject2).kar;
          paramArrayOfByte.add(localc);
          continue;
          paramArrayOfByte = ad.cgR();
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
        az.agi().a(new h(((api)localObject2).username, null), 0);
      }
      label512:
      ac.d("MicroMsg.NetSceneGetProfileDetail", "follows %d %s", new Object[] { Integer.valueOf(paramArrayOfByte.size()), paramArrayOfByte.toString() });
      if (u.axw().equalsIgnoreCase(this.username)) {
        ad.cgR().cV(paramArrayOfByte);
      }
      label564:
      this.pBs = new ArrayList();
      if (paramq.EVd != null) {
        this.pBs.addAll(paramq.EVd);
      }
      this.pBt = paramq.pBt;
      paramq = new com.tencent.mm.plugin.exdevice.g.b.a.a();
      paramq.field_championMotto = this.pBk;
      paramq.field_championUrl = this.coverUrl;
      paramq.field_username = this.username;
      ad.cgT().a(paramq);
    }
    paramq = (com.tencent.mm.plugin.exdevice.b.b)this.pwK.get();
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