package com.tencent.mm.plugin.exdevice.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.model.bh;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.exdevice.g.b.f;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.protocal.protobuf.blw;
import com.tencent.mm.protocal.protobuf.cex;
import com.tencent.mm.protocal.protobuf.cey;
import com.tencent.mm.protocal.protobuf.fqm;
import com.tencent.mm.protocal.protobuf.fqn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.bv;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class j
  extends com.tencent.mm.plugin.exdevice.b.a<cex, cey>
{
  public String appName;
  public String pqW;
  public String vhY;
  public boolean vij;
  public boolean vik;
  public String vil;
  public String vim;
  public com.tencent.mm.plugin.exdevice.g.b.a.a vin;
  public ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.d> vio;
  public ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.c> vip;
  public ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.e> viq;
  public ArrayList<String> vir;
  public String vis;
  public String vit;
  public boolean viu;
  public boolean viv;
  public String viw;
  private final WeakReference<com.tencent.mm.plugin.exdevice.b.b<j>> vix;
  public a viy;
  
  public j(String paramString1, String paramString2, String paramString3, boolean paramBoolean, com.tencent.mm.plugin.exdevice.b.b<j> paramb)
  {
    AppMethodBeat.i(23526);
    this.vix = new WeakReference(paramb);
    this.vis = paramString1;
    this.vil = paramString1;
    this.appName = Util.nullAsNil(paramString2);
    this.vik = paramBoolean;
    this.vim = paramString3;
    AppMethodBeat.o(23526);
  }
  
  public final int getType()
  {
    return 1042;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmbiz-bin/rank/getuserranklike";
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23527);
    Log.d("MicroMsg.NetSceneGetRankInfo", "hy: get rank info end. errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    cey localcey;
    Object localObject1;
    Object localObject3;
    Object localObject4;
    String str1;
    String str2;
    Object localObject2;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      localcey = (cey)ctC();
      localObject1 = "";
      this.vip = new ArrayList();
      if (localcey.RIz != null)
      {
        localObject3 = localcey.RIz.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (blw)((Iterator)localObject3).next();
          bh.beI();
          if (com.tencent.mm.model.c.bbL().bwd(((blw)localObject4).username))
          {
            str1 = localcey.lmG;
            str2 = this.appName;
            if ((Util.isNullOrNil(str1)) || (localObject4 == null))
            {
              Log.w("MicroMsg.ExdeviceRankConverter", "hy: param error");
              localObject2 = null;
            }
            for (;;)
            {
              if (localObject2 == null) {
                break label226;
              }
              this.vip.add(localObject2);
              break;
              localObject2 = new com.tencent.mm.plugin.exdevice.g.b.a.c();
              ((com.tencent.mm.plugin.exdevice.g.b.a.c)localObject2).field_rankID = str1;
              ((com.tencent.mm.plugin.exdevice.g.b.a.c)localObject2).field_username = ((blw)localObject4).username;
              ((com.tencent.mm.plugin.exdevice.g.b.a.c)localObject2).field_step = ((blw)localObject4).oxQ;
              ((com.tencent.mm.plugin.exdevice.g.b.a.c)localObject2).field_appusername = str2;
            }
          }
          else
          {
            label226:
            bh.aGY().a(new h(((blw)localObject4).username, null), 0);
          }
        }
      }
      this.vio = new ArrayList();
      localObject2 = localObject1;
      if (localcey.Tmy != null)
      {
        localObject3 = localcey.Tmy.iterator();
        localObject2 = localObject1;
        if (((Iterator)localObject3).hasNext())
        {
          localObject4 = (fqm)((Iterator)localObject3).next();
          str1 = localcey.lmG;
          str2 = this.appName;
          if ((Util.isNullOrNil(str1)) || (localObject4 == null))
          {
            Log.w("MicroMsg.ExdeviceRankConverter", "hy: param error");
            localObject2 = null;
            label347:
            if (localObject2 == null) {
              break label465;
            }
            if (((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2).field_ranknum != 1) {
              break label1245;
            }
            localObject1 = ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2).field_username;
          }
        }
      }
    }
    label465:
    label1233:
    label1239:
    label1245:
    for (;;)
    {
      this.vio.add(localObject2);
      break;
      localObject2 = new com.tencent.mm.plugin.exdevice.g.b.a.d();
      ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2).field_appusername = str2;
      ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2).field_rankID = str1;
      ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2).field_likecount = ((fqm)localObject4).Sry;
      ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2).field_ranknum = ((fqm)localObject4).UOk;
      ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2).field_score = ((fqm)localObject4).score;
      ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2).field_selfLikeState = ((fqm)localObject4).UOl;
      ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2).field_username = ((fqm)localObject4).username;
      ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2).field_sportRecord = ((fqm)localObject4).UOm;
      break label347;
      break;
      this.viq = new ArrayList();
      if (localcey.Tmz != null)
      {
        localObject3 = localcey.Tmz.iterator();
        label616:
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (fqn)((Iterator)localObject3).next();
          str1 = localcey.lmG;
          str2 = this.appName;
          if ((Util.isNullOrNil(str1)) || (localObject4 == null))
          {
            Log.w("MicroMsg.ExdeviceRankConverter", "hy: param error");
            localObject1 = null;
          }
          for (;;)
          {
            if (localObject1 == null) {
              break label616;
            }
            this.viq.add(localObject1);
            break;
            localObject1 = new com.tencent.mm.plugin.exdevice.g.b.a.e();
            ((com.tencent.mm.plugin.exdevice.g.b.a.e)localObject1).field_appusername = str2;
            ((com.tencent.mm.plugin.exdevice.g.b.a.e)localObject1).field_rankID = str1;
            ((com.tencent.mm.plugin.exdevice.g.b.a.e)localObject1).field_timestamp = ((fqn)localObject4).dXr;
            ((com.tencent.mm.plugin.exdevice.g.b.a.e)localObject1).field_username = ((fqn)localObject4).username;
          }
        }
      }
      this.vir = new ArrayList();
      if (localcey.Tmp != null)
      {
        localObject1 = localcey.Tmp.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (String)((Iterator)localObject1).next();
          this.vir.add(localObject3);
        }
      }
      if (!Util.isNullOrNil(this.vim)) {
        localObject2 = this.vim;
      }
      localObject3 = localcey.TmA;
      localObject4 = localcey.TmB;
      boolean bool;
      int i;
      int j;
      if (Util.isNullOrNil((String)localObject2))
      {
        Log.w("MicroMsg.ExdeviceRankConverter", "hy: param error");
        localObject1 = null;
        this.vin = ((com.tencent.mm.plugin.exdevice.g.b.a.a)localObject1);
        this.vis = localcey.lmG;
        this.pqW = localcey.Tmr;
        this.vhY = localcey.Tmq;
        this.vit = localcey.TmC;
        this.viu = localcey.viu;
        if (localcey.TmF != 1) {
          break label1169;
        }
        bool = true;
        this.viv = bool;
        this.viw = localcey.TmG;
        this.vij = localcey.Tmt;
        Log.d("MicroMsg.NetSceneGetRankInfo", "hy: get score info ok.");
        if ((this.vil == null) || (!this.vil.equals(this.vis)))
        {
          localObject1 = ae.cZG().viH;
          if (localObject1 != null) {
            ((f)localObject1).avB(this.vis);
          }
        }
        if ((this.viy != null) && (this.vik)) {
          this.viy.a(this);
        }
        if (this.vik) {
          ae.cZA().jdMethod_do(this.vip);
        }
        localObject1 = ae.cZz();
        localObject2 = this.vis;
        if (!Util.isNullOrNil((String)localObject2)) {
          break label1175;
        }
        Log.w("MicroMsg.ExdeviceRankInfoStg", "delete rankInfo by rankId failed, rankId is null or nil.");
        ae.cZz().g(this.vis, this.vio);
        bool = this.viu;
        if (this.vip == null) {
          break label1227;
        }
        i = this.vip.size();
        if (this.vio == null) {
          break label1233;
        }
        j = this.vio.size();
        label991:
        if (this.viq == null) {
          break label1239;
        }
      }
      for (int k = this.viq.size();; k = 0)
      {
        Log.i("MicroMsg.NetSceneGetRankInfo", "isCacheExist(%s), RankFollowInfo size(%s), RankInfo size(%d), LikeInfo size(%d).", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
        ae.cZD().a(this.vis, this.appName, this.viq);
        if (this.vin != null) {
          ae.cZC().a(this.vin);
        }
        super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, params, paramArrayOfByte);
        params = (com.tencent.mm.plugin.exdevice.b.b)this.vix.get();
        if (params != null) {
          params.a(paramInt2, paramInt3, paramString, this);
        }
        AppMethodBeat.o(23527);
        return;
        localObject1 = new com.tencent.mm.plugin.exdevice.g.b.a.a();
        ((com.tencent.mm.plugin.exdevice.g.b.a.a)localObject1).field_username = ((String)localObject2);
        ((com.tencent.mm.plugin.exdevice.g.b.a.a)localObject1).field_championUrl = ((String)localObject3);
        ((com.tencent.mm.plugin.exdevice.g.b.a.a)localObject1).field_championMotto = ((String)localObject4);
        break;
        bool = false;
        break label793;
        Log.i("MicroMsg.ExdeviceRankInfoStg", "delete rankInfo by rankId (%s).(r : %d)", new Object[] { localObject2, Integer.valueOf(((com.tencent.mm.plugin.exdevice.g.b.b.d)localObject1).db.delete("HardDeviceRankInfo", "rankID = ? ", new String[] { localObject2 })) });
        break label939;
        i = 0;
        break label975;
        j = 0;
        break label991;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(j paramj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.a.j
 * JD-Core Version:    0.7.0.1
 */