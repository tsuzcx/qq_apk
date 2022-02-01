package com.tencent.mm.plugin.exdevice.g.a;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.ui.SportProfileUIC;
import com.tencent.mm.protocal.protobuf.bes;
import com.tencent.mm.protocal.protobuf.bxb;
import com.tencent.mm.protocal.protobuf.bxc;
import com.tencent.mm.protocal.protobuf.ecx;
import com.tencent.mm.protocal.protobuf.ffn;
import com.tencent.mm.protocal.protobuf.ffo;
import com.tencent.mm.protocal.protobuf.sg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.bv;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class i
  extends com.tencent.mm.plugin.exdevice.b.a<bxb, bxc>
{
  public String appName;
  private Context context;
  public String coverUrl;
  public String msN;
  public String rCo;
  public String rCp;
  public String rCq;
  public List<ecx> rCr;
  public List<ffo> rCs;
  public ffn rCt;
  public ArrayList<String> rCu;
  public List<bes> rCv;
  public List<sg> rCw;
  public boolean rCx;
  public int rCy;
  public boolean rCz;
  private final WeakReference<com.tencent.mm.plugin.exdevice.b.b<i>> rxQ;
  public String source;
  public String username;
  
  public i(Context paramContext, String paramString1, String paramString2, com.tencent.mm.plugin.exdevice.b.b<i> paramb)
  {
    AppMethodBeat.i(231695);
    Log.i("MicroMsg.NetSceneGetProfileDetail", "NetSceneGetProfileDetail, username: %s, appName: %s", new Object[] { paramString1, paramString2 });
    this.context = paramContext;
    this.username = paramString1;
    this.appName = paramString2;
    this.rxQ = new WeakReference(paramb);
    AppMethodBeat.o(231695);
  }
  
  public final int getType()
  {
    return 1043;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmbiz-bin/rank/getuserrankdetail";
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23523);
    Log.d("MicroMsg.NetSceneGetProfileDetail", "hy: getdetail scene gy end. errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    Object localObject1;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      localObject1 = (bxc)cgq();
      Object localObject2 = com.tencent.mm.ui.component.a.PRN;
      ((SportProfileUIC)com.tencent.mm.ui.component.a.ko(this.context).get(SportProfileUIC.class)).rMR = ((bxc)localObject1);
      this.coverUrl = ((bxc)localObject1).McL;
      this.rCp = ((bxc)localObject1).rCp;
      this.rCs = ((bxc)localObject1).McN;
      this.rCt = ((bxc)localObject1).LpZ;
      this.rCq = ((bxc)localObject1).McP;
      this.source = ((bxc)localObject1).source;
      this.msN = ((bxc)localObject1).McQ;
      this.rCr = ((bxc)localObject1).KHS;
      this.rCx = ((bxc)localObject1).rCx;
      this.rCv = ((bxc)localObject1).KHh;
      this.rCw = ((bxc)localObject1).McR;
      this.rCu = new ArrayList();
      this.rCy = ((bxc)localObject1).rJh;
      this.rCz = ((bxc)localObject1).McS;
      this.rCo = ((bxc)localObject1).rCo;
      if (((bxc)localObject1).McO != null) {
        this.rCu.addAll(((bxc)localObject1).McO);
      }
      this.rCr = new LinkedList();
      if (((bxc)localObject1).KHS != null) {
        this.rCr.addAll(((bxc)localObject1).KHS);
      }
      Object localObject3;
      if ((this.username != null) && (!this.username.equalsIgnoreCase(z.aTY())))
      {
        if (!this.rCx) {
          ad.cKN().anE(this.username);
        }
      }
      else
      {
        if (((bxc)localObject1).KHh == null) {
          break label576;
        }
        localObject2 = new ArrayList();
        localObject3 = ((bxc)localObject1).KHh.iterator();
      }
      for (;;)
      {
        if (!((Iterator)localObject3).hasNext()) {
          break label524;
        }
        Object localObject4 = (bes)((Iterator)localObject3).next();
        bg.aVF();
        if (com.tencent.mm.model.c.aSN().bjG(((bes)localObject4).username))
        {
          com.tencent.mm.plugin.exdevice.g.b.a.c localc = new com.tencent.mm.plugin.exdevice.g.b.a.c();
          localc.field_username = ((bes)localObject4).username;
          localc.field_step = ((bes)localObject4).lCq;
          ((ArrayList)localObject2).add(localc);
          continue;
          localObject2 = ad.cKN();
          localObject3 = this.username;
          if (((com.tencent.mm.plugin.exdevice.g.b.b.a)localObject2).a(new com.tencent.mm.plugin.exdevice.g.b.b("hardcode_rank_id", "hardcode_app_name", (String)localObject3)) != null) {
            break;
          }
          localObject4 = new com.tencent.mm.plugin.exdevice.g.b.a.c();
          ((com.tencent.mm.plugin.exdevice.g.b.a.c)localObject4).field_rankID = "hardcode_rank_id";
          ((com.tencent.mm.plugin.exdevice.g.b.a.c)localObject4).field_appusername = "hardcode_app_name";
          ((com.tencent.mm.plugin.exdevice.g.b.a.c)localObject4).field_username = ((String)localObject3);
          ((com.tencent.mm.plugin.exdevice.g.b.a.c)localObject4).field_step = 0;
          ((com.tencent.mm.plugin.exdevice.g.b.b.a)localObject2).insert((IAutoDBItem)localObject4);
          break;
        }
        bg.azz().a(new h(((bes)localObject4).username, null), 0);
      }
      label524:
      Log.d("MicroMsg.NetSceneGetProfileDetail", "follows %d %s", new Object[] { Integer.valueOf(((ArrayList)localObject2).size()), ((ArrayList)localObject2).toString() });
      if (z.aTY().equalsIgnoreCase(this.username)) {
        ad.cKN().dn((List)localObject2);
      }
      label576:
      this.rCw = new ArrayList();
      if (((bxc)localObject1).McR != null) {
        this.rCw.addAll(((bxc)localObject1).McR);
      }
      this.rCx = ((bxc)localObject1).rCx;
      localObject1 = new com.tencent.mm.plugin.exdevice.g.b.a.a();
      ((com.tencent.mm.plugin.exdevice.g.b.a.a)localObject1).field_championMotto = this.rCp;
      ((com.tencent.mm.plugin.exdevice.g.b.a.a)localObject1).field_championUrl = this.coverUrl;
      ((com.tencent.mm.plugin.exdevice.g.b.a.a)localObject1).field_username = this.username;
      ad.cKP().a((com.tencent.mm.plugin.exdevice.g.b.a.a)localObject1);
    }
    if (this.rxQ != null)
    {
      localObject1 = (com.tencent.mm.plugin.exdevice.b.b)this.rxQ.get();
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.exdevice.b.b)localObject1).a(paramInt2, paramInt3, paramString, this);
      }
    }
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, params, paramArrayOfByte);
    AppMethodBeat.o(23523);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.a.i
 * JD-Core Version:    0.7.0.1
 */