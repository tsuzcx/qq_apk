package com.tencent.mm.plugin.exdevice.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.ui.e;
import com.tencent.mm.protocal.protobuf.blw;
import com.tencent.mm.protocal.protobuf.cev;
import com.tencent.mm.protocal.protobuf.cew;
import com.tencent.mm.protocal.protobuf.emy;
import com.tencent.mm.protocal.protobuf.fqo;
import com.tencent.mm.protocal.protobuf.fqp;
import com.tencent.mm.protocal.protobuf.rz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class i
  extends com.tencent.mm.plugin.exdevice.b.a<cev, cew>
{
  public String appName;
  private Context context;
  public String coverUrl;
  public String pqW;
  public String source;
  public String username;
  private final WeakReference<com.tencent.mm.plugin.exdevice.b.b<i>> vdw;
  public String vhW;
  public String vhX;
  public String vhY;
  public List<emy> vhZ;
  public List<fqp> vib;
  public fqo vic;
  public ArrayList<String> vie;
  public List<blw> vif;
  public List<rz> vig;
  public boolean vih;
  public int vii;
  public boolean vij;
  
  public i(Context paramContext, String paramString1, String paramString2, com.tencent.mm.plugin.exdevice.b.b<i> paramb)
  {
    AppMethodBeat.i(278539);
    Log.i("MicroMsg.NetSceneGetProfileDetail", "NetSceneGetProfileDetail, username: %s, appName: %s", new Object[] { paramString1, paramString2 });
    this.context = paramContext;
    this.username = paramString1;
    this.appName = paramString2;
    this.vdw = new WeakReference(paramb);
    AppMethodBeat.o(278539);
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
      localObject1 = (cew)ctC();
      Object localObject2 = g.Xox;
      ((e)g.lm(this.context).i(e.class)).vsB = ((cew)localObject1);
      this.coverUrl = ((cew)localObject1).Tmm;
      this.vhX = ((cew)localObject1).vhX;
      this.vib = ((cew)localObject1).Tmo;
      this.vic = ((cew)localObject1).Srw;
      this.vhY = ((cew)localObject1).Tmq;
      this.source = ((cew)localObject1).source;
      this.pqW = ((cew)localObject1).Tmr;
      this.vhZ = ((cew)localObject1).RJm;
      this.vih = ((cew)localObject1).vih;
      this.vif = ((cew)localObject1).RIz;
      this.vig = ((cew)localObject1).Tms;
      this.vie = new ArrayList();
      this.vii = ((cew)localObject1).voP;
      this.vij = ((cew)localObject1).Tmt;
      this.vhW = ((cew)localObject1).vhW;
      if (((cew)localObject1).Tmp != null) {
        this.vie.addAll(((cew)localObject1).Tmp);
      }
      this.vhZ = new LinkedList();
      if (((cew)localObject1).RJm != null) {
        this.vhZ.addAll(((cew)localObject1).RJm);
      }
      Object localObject3;
      if ((this.username != null) && (!this.username.equalsIgnoreCase(z.bcZ())))
      {
        if (!this.vih) {
          ae.cZA().avD(this.username);
        }
      }
      else
      {
        if (((cew)localObject1).RIz == null) {
          break label576;
        }
        localObject2 = new ArrayList();
        localObject3 = ((cew)localObject1).RIz.iterator();
      }
      for (;;)
      {
        if (!((Iterator)localObject3).hasNext()) {
          break label524;
        }
        Object localObject4 = (blw)((Iterator)localObject3).next();
        bh.beI();
        if (com.tencent.mm.model.c.bbL().bwd(((blw)localObject4).username))
        {
          com.tencent.mm.plugin.exdevice.g.b.a.c localc = new com.tencent.mm.plugin.exdevice.g.b.a.c();
          localc.field_username = ((blw)localObject4).username;
          localc.field_step = ((blw)localObject4).oxQ;
          ((ArrayList)localObject2).add(localc);
          continue;
          localObject2 = ae.cZA();
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
        bh.aGY().a(new h(((blw)localObject4).username, null), 0);
      }
      label524:
      Log.d("MicroMsg.NetSceneGetProfileDetail", "follows %d %s", new Object[] { Integer.valueOf(((ArrayList)localObject2).size()), ((ArrayList)localObject2).toString() });
      if (z.bcZ().equalsIgnoreCase(this.username)) {
        ae.cZA().jdMethod_do((List)localObject2);
      }
      label576:
      this.vig = new ArrayList();
      if (((cew)localObject1).Tms != null) {
        this.vig.addAll(((cew)localObject1).Tms);
      }
      this.vih = ((cew)localObject1).vih;
      localObject1 = new com.tencent.mm.plugin.exdevice.g.b.a.a();
      ((com.tencent.mm.plugin.exdevice.g.b.a.a)localObject1).field_championMotto = this.vhX;
      ((com.tencent.mm.plugin.exdevice.g.b.a.a)localObject1).field_championUrl = this.coverUrl;
      ((com.tencent.mm.plugin.exdevice.g.b.a.a)localObject1).field_username = this.username;
      ae.cZC().a((com.tencent.mm.plugin.exdevice.g.b.a.a)localObject1);
    }
    if (this.vdw != null)
    {
      localObject1 = (com.tencent.mm.plugin.exdevice.b.b)this.vdw.get();
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.exdevice.b.b)localObject1).a(paramInt2, paramInt3, paramString, this);
      }
    }
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, params, paramArrayOfByte);
    AppMethodBeat.o(23523);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.a.i
 * JD-Core Version:    0.7.0.1
 */