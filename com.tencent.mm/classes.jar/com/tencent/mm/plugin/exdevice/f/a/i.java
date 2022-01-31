package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.protocal.c.alu;
import com.tencent.mm.protocal.c.alv;
import com.tencent.mm.protocal.c.bvw;
import com.tencent.mm.protocal.c.cnt;
import com.tencent.mm.protocal.c.cnu;
import com.tencent.mm.protocal.c.kz;
import com.tencent.mm.protocal.c.zh;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bd;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class i
  extends com.tencent.mm.plugin.exdevice.a.a<alu, alv>
{
  public String aWf;
  public String appName;
  private final WeakReference<com.tencent.mm.plugin.exdevice.a.b<i>> jto;
  public String jxO;
  public String jxP;
  public String jxQ;
  public String jxR;
  public String jxS;
  public List<bvw> jxT;
  public List<cnu> jxU;
  public cnt jxV;
  public ArrayList<String> jxW;
  public List<zh> jxX;
  public List<kz> jxY;
  public boolean jxZ;
  public int jya;
  public boolean jyb;
  public String username;
  
  public i(String paramString1, String paramString2, com.tencent.mm.plugin.exdevice.a.b<i> paramb)
  {
    y.d("MicroMsg.NetSceneGetProfileDetail", "appusername: %s, username: %s", new Object[] { paramString2, paramString1 });
    this.username = paramString1;
    this.appName = paramString2;
    this.jto = new WeakReference(paramb);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    super.a(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    y.d("MicroMsg.NetSceneGetProfileDetail", "hy: getdetail scene gy end. errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (alv)auJ();
      this.jxP = paramq.thK;
      this.jxQ = paramq.jxQ;
      this.jxU = paramq.thN;
      this.jxV = paramq.thL;
      this.jxR = paramq.thP;
      this.aWf = paramq.aWf;
      this.jxS = paramq.thQ;
      this.jxT = paramq.swj;
      this.jxZ = paramq.jxZ;
      this.jxX = paramq.svE;
      this.jxY = paramq.thR;
      this.jxW = new ArrayList();
      this.jya = paramq.jEz;
      this.jyb = paramq.thS;
      this.jxO = paramq.jxO;
      if (paramq.thO != null) {
        this.jxW.addAll(paramq.thO);
      }
      this.jxT = new LinkedList();
      if (paramq.swj != null) {
        this.jxT.addAll(paramq.swj);
      }
      Object localObject1;
      if ((this.username != null) && (!this.username.equalsIgnoreCase(com.tencent.mm.model.q.Gj())))
      {
        if (!this.jxZ) {
          ad.aLN().BB(this.username);
        }
      }
      else
      {
        if (paramq.svE == null) {
          break label554;
        }
        paramArrayOfByte = new ArrayList();
        localObject1 = paramq.svE.iterator();
      }
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label502;
        }
        Object localObject2 = (zh)((Iterator)localObject1).next();
        au.Hx();
        if (com.tencent.mm.model.c.Fw().abg(((zh)localObject2).username))
        {
          com.tencent.mm.plugin.exdevice.f.b.a.c localc = new com.tencent.mm.plugin.exdevice.f.b.a.c();
          localc.field_username = ((zh)localObject2).username;
          localc.field_step = ((zh)localObject2).ghE;
          paramArrayOfByte.add(localc);
          continue;
          paramArrayOfByte = ad.aLN();
          localObject1 = this.username;
          if (paramArrayOfByte.a(new com.tencent.mm.plugin.exdevice.f.b.b("hardcode_rank_id", "hardcode_app_name", (String)localObject1)) != null) {
            break;
          }
          localObject2 = new com.tencent.mm.plugin.exdevice.f.b.a.c();
          ((com.tencent.mm.plugin.exdevice.f.b.a.c)localObject2).field_rankID = "hardcode_rank_id";
          ((com.tencent.mm.plugin.exdevice.f.b.a.c)localObject2).field_appusername = "hardcode_app_name";
          ((com.tencent.mm.plugin.exdevice.f.b.a.c)localObject2).field_username = ((String)localObject1);
          ((com.tencent.mm.plugin.exdevice.f.b.a.c)localObject2).field_step = 0;
          paramArrayOfByte.b((com.tencent.mm.sdk.e.c)localObject2);
          break;
        }
        au.Dk().a(new h(((zh)localObject2).username, null), 0);
      }
      label502:
      y.d("MicroMsg.NetSceneGetProfileDetail", "follows %d %s", new Object[] { Integer.valueOf(paramArrayOfByte.size()), paramArrayOfByte.toString() });
      if (com.tencent.mm.model.q.Gj().equalsIgnoreCase(this.username)) {
        ad.aLN().be(paramArrayOfByte);
      }
      label554:
      this.jxY = new ArrayList();
      if (paramq.thR != null) {
        this.jxY.addAll(paramq.thR);
      }
      this.jxZ = paramq.jxZ;
      paramArrayOfByte = new com.tencent.mm.plugin.exdevice.f.b.a.a();
      paramArrayOfByte.field_championMotto = this.jxQ;
      paramArrayOfByte.field_championUrl = this.jxP;
      paramArrayOfByte.field_username = this.username;
      paramq = paramq.swj;
      ad.aLP().a(paramArrayOfByte);
    }
    paramq = (com.tencent.mm.plugin.exdevice.a.b)this.jto.get();
    if (paramq != null) {
      paramq.a(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 1043;
  }
  
  protected final String getUri()
  {
    return "/cgi-bin/mmbiz-bin/rank/getuserrankdetail";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.a.i
 * JD-Core Version:    0.7.0.1
 */