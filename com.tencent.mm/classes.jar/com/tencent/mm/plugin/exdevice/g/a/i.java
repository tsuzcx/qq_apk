package com.tencent.mm.plugin.exdevice.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.protocal.protobuf.ats;
import com.tencent.mm.protocal.protobuf.bks;
import com.tencent.mm.protocal.protobuf.bkt;
import com.tencent.mm.protocal.protobuf.djl;
import com.tencent.mm.protocal.protobuf.ekq;
import com.tencent.mm.protocal.protobuf.ekr;
import com.tencent.mm.protocal.protobuf.re;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.bq;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class i
  extends com.tencent.mm.plugin.exdevice.b.a<bks, bkt>
{
  public String appName;
  public String coverUrl;
  private final WeakReference<com.tencent.mm.plugin.exdevice.b.b<i>> qgU;
  public ArrayList<String> qlA;
  public List<ats> qlB;
  public List<re> qlC;
  public boolean qlD;
  public int qlE;
  public boolean qlF;
  public String qlt;
  public String qlu;
  public String qlv;
  public String qlw;
  public List<djl> qlx;
  public List<ekr> qly;
  public ekq qlz;
  public String source;
  public String username;
  
  public i(String paramString1, String paramString2, com.tencent.mm.plugin.exdevice.b.b<i> paramb)
  {
    AppMethodBeat.i(23522);
    ae.d("MicroMsg.NetSceneGetProfileDetail", "appusername: %s, username: %s", new Object[] { paramString2, paramString1 });
    this.username = paramString1;
    this.appName = paramString2;
    this.qgU = new WeakReference(paramb);
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
    ae.d("MicroMsg.NetSceneGetProfileDetail", "hy: getdetail scene gy end. errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (bkt)bJx();
      this.coverUrl = paramq.GXW;
      this.qlu = paramq.qlu;
      this.qly = paramq.GXZ;
      this.qlz = paramq.GXX;
      this.qlv = paramq.GYb;
      this.source = paramq.source;
      this.qlw = paramq.GYc;
      this.qlx = paramq.FOl;
      this.qlD = paramq.qlD;
      this.qlB = paramq.FNC;
      this.qlC = paramq.GYd;
      this.qlA = new ArrayList();
      this.qlE = paramq.qse;
      this.qlF = paramq.GYe;
      this.qlt = paramq.qlt;
      if (paramq.GYa != null) {
        this.qlA.addAll(paramq.GYa);
      }
      this.qlx = new LinkedList();
      if (paramq.FOl != null) {
        this.qlx.addAll(paramq.FOl);
      }
      Object localObject1;
      if ((this.username != null) && (!this.username.equalsIgnoreCase(v.aAC())))
      {
        if (!this.qlD) {
          ad.cmL().adv(this.username);
        }
      }
      else
      {
        if (paramq.FNC == null) {
          break label564;
        }
        paramArrayOfByte = new ArrayList();
        localObject1 = paramq.FNC.iterator();
      }
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label512;
        }
        Object localObject2 = (ats)((Iterator)localObject1).next();
        bc.aCg();
        if (com.tencent.mm.model.c.azF().aUH(((ats)localObject2).username))
        {
          com.tencent.mm.plugin.exdevice.g.b.a.c localc = new com.tencent.mm.plugin.exdevice.g.b.a.c();
          localc.field_username = ((ats)localObject2).username;
          localc.field_step = ((ats)localObject2).kyd;
          paramArrayOfByte.add(localc);
          continue;
          paramArrayOfByte = ad.cmL();
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
        bc.ajj().a(new h(((ats)localObject2).username, null), 0);
      }
      label512:
      ae.d("MicroMsg.NetSceneGetProfileDetail", "follows %d %s", new Object[] { Integer.valueOf(paramArrayOfByte.size()), paramArrayOfByte.toString() });
      if (v.aAC().equalsIgnoreCase(this.username)) {
        ad.cmL().cY(paramArrayOfByte);
      }
      label564:
      this.qlC = new ArrayList();
      if (paramq.GYd != null) {
        this.qlC.addAll(paramq.GYd);
      }
      this.qlD = paramq.qlD;
      paramq = new com.tencent.mm.plugin.exdevice.g.b.a.a();
      paramq.field_championMotto = this.qlu;
      paramq.field_championUrl = this.coverUrl;
      paramq.field_username = this.username;
      ad.cmN().a(paramq);
    }
    paramq = (com.tencent.mm.plugin.exdevice.b.b)this.qgU.get();
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