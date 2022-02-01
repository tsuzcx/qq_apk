package com.tencent.mm.plugin.exdevice.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.exdevice.model.ah;
import com.tencent.mm.plugin.exdevice.ui.e;
import com.tencent.mm.protocal.protobuf.bzo;
import com.tencent.mm.protocal.protobuf.cuy;
import com.tencent.mm.protocal.protobuf.cuz;
import com.tencent.mm.protocal.protobuf.fhc;
import com.tencent.mm.protocal.protobuf.fhw;
import com.tencent.mm.protocal.protobuf.gny;
import com.tencent.mm.protocal.protobuf.gnz;
import com.tencent.mm.protocal.protobuf.tk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class i
  extends com.tencent.mm.plugin.exdevice.b.a<cuy, cuz>
{
  public String appName;
  private Context context;
  public String coverUrl;
  public String source;
  public String svG;
  public String username;
  private final WeakReference<com.tencent.mm.plugin.exdevice.b.b<i>> ypi;
  public String ytX;
  public String ytY;
  public String ytZ;
  public List<fhw> yua;
  public List<gnz> yub;
  public gny yuc;
  public ArrayList<String> yud;
  public List<bzo> yue;
  public List<tk> yuf;
  public boolean yug;
  public int yuh;
  public boolean yui;
  
  public i(Context paramContext, String paramString1, String paramString2, com.tencent.mm.plugin.exdevice.b.b<i> paramb)
  {
    AppMethodBeat.i(274566);
    Log.i("MicroMsg.NetSceneGetProfileDetail", "NetSceneGetProfileDetail, username: %s, appName: %s", new Object[] { paramString1, paramString2 });
    this.context = paramContext;
    this.username = paramString1;
    this.appName = paramString2;
    this.ypi = new WeakReference(paramb);
    AppMethodBeat.o(274566);
  }
  
  public final int getType()
  {
    return 1043;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmbiz-bin/rank/getuserrankdetail";
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23523);
    Log.d("MicroMsg.NetSceneGetProfileDetail", "hy: getdetail scene gy end. errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    cuz localcuz;
    Object localObject1;
    e locale;
    Object localObject4;
    Object localObject3;
    Object localObject2;
    int j;
    int i;
    Object localObject5;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      localcuz = (cuz)cWm();
      localObject1 = k.aeZF;
      locale = (e)k.nq(this.context).q(e.class);
      locale.yEI = localcuz;
      localObject4 = null;
      localObject3 = null;
      localObject1 = null;
      localObject2 = null;
      j = 0;
      i = 0;
      if (localcuz == null) {
        break label1543;
      }
      localObject5 = localcuz.aaAB;
      if (localObject5 == null) {
        break label1543;
      }
      Iterator localIterator = ((Iterable)localObject5).iterator();
      localObject3 = null;
      while (localIterator.hasNext())
      {
        fhc localfhc = (fhc)localIterator.next();
        if (localfhc.abHH == 0)
        {
          if ((localObject4 != null) && (kotlin.g.b.s.p(localObject4, localfhc.appId))) {
            break label1529;
          }
          if (localObject2 != null) {
            if (!((Collection)localObject2).isEmpty())
            {
              j = 1;
              label201:
              if (j != 1) {
                break label365;
              }
              j = 1;
              label210:
              localObject4 = localObject2;
              if (j != 0)
              {
                if (localObject2 != null) {
                  locale.yAO.add(localObject2);
                }
                localObject4 = new LinkedList();
              }
              if (localObject1 == null) {
                break label377;
              }
              if (((Collection)localObject1).isEmpty()) {
                break label371;
              }
              j = 1;
              label265:
              if (j != 1) {
                break label377;
              }
            }
          }
          label365:
          label371:
          label377:
          for (j = 1;; j = 0)
          {
            if (j != 0)
            {
              localObject2 = locale.yAO;
              kotlin.g.b.s.checkNotNull(localObject1);
              ((LinkedList)localObject2).add(localObject1);
            }
            localObject5 = new LinkedList();
            localObject1 = localfhc.appId;
            localObject2 = localObject4;
            localObject4 = localObject1;
            if (localObject5 != null) {
              ((LinkedList)localObject5).add(localfhc);
            }
            if (!kotlin.g.b.s.p(localfhc.appId, "21f9d636b41b25be")) {
              break label1522;
            }
            i = 1;
            localObject1 = localObject5;
            break;
            j = 0;
            break label201;
            j = 0;
            break label210;
            j = 0;
            break label265;
          }
        }
        if (localfhc.abHH == 1)
        {
          if ((localObject3 != null) && (kotlin.g.b.s.p(localObject3, localfhc.appName))) {
            break label1515;
          }
          if (localObject1 != null) {
            if (!((Collection)localObject1).isEmpty())
            {
              j = 1;
              label431:
              if (j != 1) {
                break label571;
              }
              j = 1;
              label440:
              localObject5 = localObject1;
              if (j != 0)
              {
                if (localObject1 != null) {
                  locale.yAO.add(localObject1);
                }
                localObject5 = new LinkedList();
              }
              if (localObject2 == null) {
                break label583;
              }
              if (((Collection)localObject2).isEmpty()) {
                break label577;
              }
              j = 1;
              label495:
              if (j != 1) {
                break label583;
              }
            }
          }
          label545:
          label571:
          label577:
          label583:
          for (j = 1;; j = 0)
          {
            if (j != 0)
            {
              localObject1 = locale.yAO;
              kotlin.g.b.s.checkNotNull(localObject2);
              ((LinkedList)localObject1).add(localObject2);
            }
            localObject2 = new LinkedList();
            localObject3 = localfhc.appName;
            if (localObject2 == null) {
              break label1536;
            }
            ((LinkedList)localObject2).add(localfhc);
            localObject1 = localObject5;
            break;
            j = 0;
            break label431;
            j = 0;
            break label440;
            j = 0;
            break label495;
          }
        }
        if (localfhc.abHH == 2) {
          locale.yEK = localfhc;
        }
        localObject5 = localObject1;
        localObject1 = localObject3;
        label613:
        localObject3 = localObject1;
        localObject1 = localObject5;
      }
    }
    for (;;)
    {
      if (localObject2 != null) {
        if (!((Collection)localObject2).isEmpty())
        {
          j = 1;
          if (j != 1) {
            break label1178;
          }
          j = 1;
          label654:
          if (j != 0)
          {
            localObject3 = locale.yAO;
            kotlin.g.b.s.checkNotNull(localObject2);
            ((LinkedList)localObject3).add(localObject2);
          }
          if (localObject1 == null) {
            break label1190;
          }
          if (((Collection)localObject1).isEmpty()) {
            break label1184;
          }
          j = 1;
          label700:
          if (j != 1) {
            break label1190;
          }
          j = 1;
          label709:
          if (j != 0)
          {
            localObject2 = locale.yAO;
            kotlin.g.b.s.checkNotNull(localObject1);
            ((LinkedList)localObject2).add(localObject1);
          }
          localObject2 = new LinkedList();
          if (i == 0)
          {
            if (localcuz != null) {
              break label1196;
            }
            localObject1 = null;
            label756:
            localObject1 = (Collection)localObject1;
            if ((localObject1 != null) && (!((Collection)localObject1).isEmpty())) {
              break label1206;
            }
            i = 1;
            label781:
            if (i == 0)
            {
              localObject1 = new fhc();
              ((fhc)localObject1).appId = "21f9d636b41b25be";
              ((fhc)localObject1).abHH = 0;
              ((fhc)localObject1).abHD = null;
              ((LinkedList)localObject2).add(localObject1);
              locale.yAO.add(localObject2);
            }
          }
          this.coverUrl = localcuz.aaAt;
          this.ytY = localcuz.ytY;
          this.yub = localcuz.aaAv;
          this.yuc = localcuz.Zqy;
          this.ytZ = localcuz.aaAx;
          this.source = localcuz.source;
          this.svG = localcuz.aaAy;
          this.yua = localcuz.YGC;
          this.yug = localcuz.yug;
          this.yue = localcuz.YFB;
          this.yuf = localcuz.aaAz;
          this.yud = new ArrayList();
          this.yuh = localcuz.yBl;
          this.yui = localcuz.aaAA;
          this.ytX = localcuz.ytX;
          if (localcuz.aaAw != null) {
            this.yud.addAll(localcuz.aaAw);
          }
          this.yua = new LinkedList();
          if (localcuz.YGC != null) {
            this.yua.addAll(localcuz.YGC);
          }
          if ((this.username != null) && (!this.username.equalsIgnoreCase(z.bAM())))
          {
            if (this.yug) {
              break label1212;
            }
            ah.dFT().apD(this.username);
          }
          label1063:
          if (localcuz.YFB == null) {
            break label1371;
          }
          localObject1 = new ArrayList();
          localObject2 = localcuz.YFB.iterator();
        }
      }
      for (;;)
      {
        if (!((Iterator)localObject2).hasNext()) {
          break label1319;
        }
        localObject3 = (bzo)((Iterator)localObject2).next();
        bh.bCz();
        if (com.tencent.mm.model.c.bzA().bxr(((bzo)localObject3).username))
        {
          localObject4 = new com.tencent.mm.plugin.exdevice.g.b.a.c();
          ((com.tencent.mm.plugin.exdevice.g.b.a.c)localObject4).field_username = ((bzo)localObject3).username;
          ((com.tencent.mm.plugin.exdevice.g.b.a.c)localObject4).field_step = ((bzo)localObject3).rBp;
          ((ArrayList)localObject1).add(localObject4);
          continue;
          j = 0;
          break;
          label1178:
          j = 0;
          break label654;
          label1184:
          j = 0;
          break label700;
          label1190:
          j = 0;
          break label709;
          label1196:
          localObject1 = localcuz.ZqB;
          break label756;
          label1206:
          i = 0;
          break label781;
          label1212:
          localObject1 = ah.dFT();
          localObject2 = this.username;
          if (((com.tencent.mm.plugin.exdevice.g.b.b.a)localObject1).a(new com.tencent.mm.plugin.exdevice.g.b.b("hardcode_rank_id", "hardcode_app_name", (String)localObject2)) != null) {
            break label1063;
          }
          localObject3 = new com.tencent.mm.plugin.exdevice.g.b.a.c();
          ((com.tencent.mm.plugin.exdevice.g.b.a.c)localObject3).field_rankID = "hardcode_rank_id";
          ((com.tencent.mm.plugin.exdevice.g.b.a.c)localObject3).field_appusername = "hardcode_app_name";
          ((com.tencent.mm.plugin.exdevice.g.b.a.c)localObject3).field_username = ((String)localObject2);
          ((com.tencent.mm.plugin.exdevice.g.b.a.c)localObject3).field_step = 0;
          ((com.tencent.mm.plugin.exdevice.g.b.b.a)localObject1).insert((IAutoDBItem)localObject3);
          break label1063;
        }
        bh.aZW().a(new h(((bzo)localObject3).username, null), 0);
      }
      label1319:
      Log.d("MicroMsg.NetSceneGetProfileDetail", "follows %d %s", new Object[] { Integer.valueOf(((ArrayList)localObject1).size()), ((ArrayList)localObject1).toString() });
      if (z.bAM().equalsIgnoreCase(this.username)) {
        ah.dFT().fl((List)localObject1);
      }
      label1371:
      this.yuf = new ArrayList();
      if (localcuz.aaAz != null) {
        this.yuf.addAll(localcuz.aaAz);
      }
      this.yug = localcuz.yug;
      localObject1 = new com.tencent.mm.plugin.exdevice.g.b.a.a();
      ((com.tencent.mm.plugin.exdevice.g.b.a.a)localObject1).field_championMotto = this.ytY;
      ((com.tencent.mm.plugin.exdevice.g.b.a.a)localObject1).field_championUrl = this.coverUrl;
      ((com.tencent.mm.plugin.exdevice.g.b.a.a)localObject1).field_username = this.username;
      ah.dFV().a((com.tencent.mm.plugin.exdevice.g.b.a.a)localObject1);
      if (this.ypi != null)
      {
        localObject1 = (com.tencent.mm.plugin.exdevice.b.b)this.ypi.get();
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.exdevice.b.b)localObject1).onNetSceneEndCallback(paramInt2, paramInt3, paramString, this);
        }
      }
      super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, params, paramArrayOfByte);
      AppMethodBeat.o(23523);
      return;
      label1515:
      localObject5 = localObject1;
      break label545;
      label1522:
      localObject1 = localObject3;
      break label613;
      label1529:
      localObject5 = localObject1;
      break;
      label1536:
      localObject1 = localObject3;
      break label613;
      label1543:
      localObject2 = null;
      localObject1 = localObject3;
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.a.i
 * JD-Core Version:    0.7.0.1
 */