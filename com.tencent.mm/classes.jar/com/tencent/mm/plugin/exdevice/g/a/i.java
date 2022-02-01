package com.tencent.mm.plugin.exdevice.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.u;
import com.tencent.mm.protocal.protobuf.atc;
import com.tencent.mm.protocal.protobuf.bka;
import com.tencent.mm.protocal.protobuf.bkb;
import com.tencent.mm.protocal.protobuf.diq;
import com.tencent.mm.protocal.protobuf.eiz;
import com.tencent.mm.protocal.protobuf.eja;
import com.tencent.mm.protocal.protobuf.rc;
import com.tencent.mm.storage.bp;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class i
  extends com.tencent.mm.plugin.exdevice.b.a<bka, bkb>
{
  public String appName;
  public String coverUrl;
  private final WeakReference<com.tencent.mm.plugin.exdevice.b.b<i>> qap;
  public String qeO;
  public String qeP;
  public String qeQ;
  public String qeR;
  public List<diq> qeS;
  public List<eja> qeT;
  public eiz qeU;
  public ArrayList<String> qeV;
  public List<atc> qeW;
  public List<rc> qeX;
  public boolean qeY;
  public int qeZ;
  public boolean qfa;
  public String source;
  public String username;
  
  public i(String paramString1, String paramString2, com.tencent.mm.plugin.exdevice.b.b<i> paramb)
  {
    AppMethodBeat.i(23522);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetSceneGetProfileDetail", "appusername: %s, username: %s", new Object[] { paramString2, paramString1 });
    this.username = paramString1;
    this.appName = paramString2;
    this.qap = new WeakReference(paramb);
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
      paramq = (bkb)bIz();
      this.coverUrl = paramq.GEt;
      this.qeP = paramq.qeP;
      this.qeT = paramq.GEw;
      this.qeU = paramq.GEu;
      this.qeQ = paramq.GEy;
      this.source = paramq.source;
      this.qeR = paramq.GEz;
      this.qeS = paramq.FvN;
      this.qeY = paramq.qeY;
      this.qeW = paramq.Fve;
      this.qeX = paramq.GEA;
      this.qeV = new ArrayList();
      this.qeZ = paramq.qlz;
      this.qfa = paramq.GEB;
      this.qeO = paramq.qeO;
      if (paramq.GEx != null) {
        this.qeV.addAll(paramq.GEx);
      }
      this.qeS = new LinkedList();
      if (paramq.FvN != null) {
        this.qeS.addAll(paramq.FvN);
      }
      Object localObject1;
      if ((this.username != null) && (!this.username.equalsIgnoreCase(u.aAm())))
      {
        if (!this.qeY) {
          com.tencent.mm.plugin.exdevice.model.ad.clv().acE(this.username);
        }
      }
      else
      {
        if (paramq.Fve == null) {
          break label564;
        }
        paramArrayOfByte = new ArrayList();
        localObject1 = paramq.Fve.iterator();
      }
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label512;
        }
        Object localObject2 = (atc)((Iterator)localObject1).next();
        ba.aBQ();
        if (com.tencent.mm.model.c.azp().aTg(((atc)localObject2).username))
        {
          com.tencent.mm.plugin.exdevice.g.b.a.c localc = new com.tencent.mm.plugin.exdevice.g.b.a.c();
          localc.field_username = ((atc)localObject2).username;
          localc.field_step = ((atc)localObject2).kuN;
          paramArrayOfByte.add(localc);
          continue;
          paramArrayOfByte = com.tencent.mm.plugin.exdevice.model.ad.clv();
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
        ba.aiU().a(new h(((atc)localObject2).username, null), 0);
      }
      label512:
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetSceneGetProfileDetail", "follows %d %s", new Object[] { Integer.valueOf(paramArrayOfByte.size()), paramArrayOfByte.toString() });
      if (u.aAm().equalsIgnoreCase(this.username)) {
        com.tencent.mm.plugin.exdevice.model.ad.clv().cV(paramArrayOfByte);
      }
      label564:
      this.qeX = new ArrayList();
      if (paramq.GEA != null) {
        this.qeX.addAll(paramq.GEA);
      }
      this.qeY = paramq.qeY;
      paramq = new com.tencent.mm.plugin.exdevice.g.b.a.a();
      paramq.field_championMotto = this.qeP;
      paramq.field_championUrl = this.coverUrl;
      paramq.field_username = this.username;
      com.tencent.mm.plugin.exdevice.model.ad.clx().a(paramq);
    }
    paramq = (com.tencent.mm.plugin.exdevice.b.b)this.qap.get();
    if (paramq != null) {
      paramq.a(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(23523);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.a.i
 * JD-Core Version:    0.7.0.1
 */