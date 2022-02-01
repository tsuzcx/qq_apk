package com.tencent.mm.plugin.exdevice.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.exdevice.g.b.f;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.protocal.protobuf.api;
import com.tencent.mm.protocal.protobuf.bfu;
import com.tencent.mm.protocal.protobuf.bfv;
import com.tencent.mm.protocal.protobuf.ecr;
import com.tencent.mm.protocal.protobuf.ecs;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bj;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class j
  extends com.tencent.mm.plugin.exdevice.b.a<bfu, bfv>
{
  public String appName;
  public ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.d> pBA;
  public ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.c> pBB;
  public ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.e> pBC;
  public ArrayList<String> pBD;
  public String pBE;
  public String pBF;
  public boolean pBG;
  public boolean pBH;
  public String pBI;
  private final WeakReference<com.tencent.mm.plugin.exdevice.b.b<j>> pBJ;
  public a pBK;
  public String pBl;
  public String pBm;
  public boolean pBv;
  public boolean pBw;
  public String pBx;
  public String pBy;
  public com.tencent.mm.plugin.exdevice.g.b.a.a pBz;
  
  public j(String paramString1, String paramString2, String paramString3, boolean paramBoolean, com.tencent.mm.plugin.exdevice.b.b<j> paramb)
  {
    AppMethodBeat.i(23526);
    this.pBJ = new WeakReference(paramb);
    this.pBE = paramString1;
    this.pBx = paramString1;
    this.appName = bs.nullAsNil(paramString2);
    this.pBw = paramBoolean;
    this.pBy = paramString3;
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23527);
    ac.d("MicroMsg.NetSceneGetRankInfo", "hy: get rank info end. errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    bfv localbfv;
    Object localObject1;
    Object localObject3;
    Object localObject4;
    String str1;
    String str2;
    Object localObject2;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      localbfv = (bfv)bEq();
      localObject1 = "";
      this.pBB = new ArrayList();
      if (localbfv.DPP != null)
      {
        localObject3 = localbfv.DPP.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (api)((Iterator)localObject3).next();
          az.ayM();
          if (com.tencent.mm.model.c.awB().aNo(((api)localObject4).username))
          {
            str1 = localbfv.hip;
            str2 = this.appName;
            if ((bs.isNullOrNil(str1)) || (localObject4 == null))
            {
              ac.w("MicroMsg.ExdeviceRankConverter", "hy: param error");
              localObject2 = null;
            }
            for (;;)
            {
              if (localObject2 == null) {
                break label226;
              }
              this.pBB.add(localObject2);
              break;
              localObject2 = new com.tencent.mm.plugin.exdevice.g.b.a.c();
              ((com.tencent.mm.plugin.exdevice.g.b.a.c)localObject2).field_rankID = str1;
              ((com.tencent.mm.plugin.exdevice.g.b.a.c)localObject2).field_username = ((api)localObject4).username;
              ((com.tencent.mm.plugin.exdevice.g.b.a.c)localObject2).field_step = ((api)localObject4).kar;
              ((com.tencent.mm.plugin.exdevice.g.b.a.c)localObject2).field_appusername = str2;
            }
          }
          else
          {
            label226:
            az.agi().a(new h(((api)localObject4).username, null), 0);
          }
        }
      }
      this.pBA = new ArrayList();
      localObject2 = localObject1;
      if (localbfv.EVh != null)
      {
        localObject3 = localbfv.EVh.iterator();
        localObject2 = localObject1;
        if (((Iterator)localObject3).hasNext())
        {
          localObject4 = (ecr)((Iterator)localObject3).next();
          str1 = localbfv.hip;
          str2 = this.appName;
          if ((bs.isNullOrNil(str1)) || (localObject4 == null))
          {
            ac.w("MicroMsg.ExdeviceRankConverter", "hy: param error");
            localObject2 = null;
            label347:
            if (localObject2 == null) {
              break label455;
            }
            if (((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2).field_ranknum != 1) {
              break label1235;
            }
            localObject1 = ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2).field_username;
          }
        }
      }
    }
    label455:
    label1223:
    label1229:
    label1235:
    for (;;)
    {
      this.pBA.add(localObject2);
      break;
      localObject2 = new com.tencent.mm.plugin.exdevice.g.b.a.d();
      ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2).field_appusername = str2;
      ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2).field_rankID = str1;
      ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2).field_likecount = ((ecr)localObject4).Gii;
      ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2).field_ranknum = ((ecr)localObject4).Gih;
      ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2).field_score = ((ecr)localObject4).score;
      ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2).field_selfLikeState = ((ecr)localObject4).Gij;
      ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2).field_username = ((ecr)localObject4).username;
      break label347;
      break;
      this.pBC = new ArrayList();
      if (localbfv.EVi != null)
      {
        localObject3 = localbfv.EVi.iterator();
        label606:
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (ecs)((Iterator)localObject3).next();
          str1 = localbfv.hip;
          str2 = this.appName;
          if ((bs.isNullOrNil(str1)) || (localObject4 == null))
          {
            ac.w("MicroMsg.ExdeviceRankConverter", "hy: param error");
            localObject1 = null;
          }
          for (;;)
          {
            if (localObject1 == null) {
              break label606;
            }
            this.pBC.add(localObject1);
            break;
            localObject1 = new com.tencent.mm.plugin.exdevice.g.b.a.e();
            ((com.tencent.mm.plugin.exdevice.g.b.a.e)localObject1).field_appusername = str2;
            ((com.tencent.mm.plugin.exdevice.g.b.a.e)localObject1).field_rankID = str1;
            ((com.tencent.mm.plugin.exdevice.g.b.a.e)localObject1).field_timestamp = ((ecs)localObject4).oxC;
            ((com.tencent.mm.plugin.exdevice.g.b.a.e)localObject1).field_username = ((ecs)localObject4).username;
          }
        }
      }
      this.pBD = new ArrayList();
      if (localbfv.EVa != null)
      {
        localObject1 = localbfv.EVa.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (String)((Iterator)localObject1).next();
          this.pBD.add(localObject3);
        }
      }
      if (!bs.isNullOrNil(this.pBy)) {
        localObject2 = this.pBy;
      }
      localObject3 = localbfv.EVj;
      localObject4 = localbfv.EVk;
      boolean bool;
      int i;
      int j;
      if (bs.isNullOrNil((String)localObject2))
      {
        ac.w("MicroMsg.ExdeviceRankConverter", "hy: param error");
        localObject1 = null;
        this.pBz = ((com.tencent.mm.plugin.exdevice.g.b.a.a)localObject1);
        this.pBE = localbfv.hip;
        this.pBm = localbfv.EVc;
        this.pBl = localbfv.EVb;
        this.pBF = localbfv.EVl;
        this.pBG = localbfv.pBG;
        if (localbfv.EVo != 1) {
          break label1159;
        }
        bool = true;
        this.pBH = bool;
        this.pBI = localbfv.EVp;
        this.pBv = localbfv.EVe;
        ac.d("MicroMsg.NetSceneGetRankInfo", "hy: get score info ok.");
        if ((this.pBx == null) || (!this.pBx.equals(this.pBE)))
        {
          localObject1 = ad.cgX().pBR;
          if (localObject1 != null) {
            ((f)localObject1).YW(this.pBE);
          }
        }
        if ((this.pBK != null) && (this.pBw)) {
          this.pBK.a(this);
        }
        if (this.pBw) {
          ad.cgR().cV(this.pBB);
        }
        localObject1 = ad.cgQ();
        localObject2 = this.pBE;
        if (!bs.isNullOrNil((String)localObject2)) {
          break label1165;
        }
        ac.w("MicroMsg.ExdeviceRankInfoStg", "delete rankInfo by rankId failed, rankId is null or nil.");
        ad.cgQ().f(this.pBE, this.pBA);
        bool = this.pBG;
        if (this.pBB == null) {
          break label1217;
        }
        i = this.pBB.size();
        if (this.pBA == null) {
          break label1223;
        }
        j = this.pBA.size();
        label981:
        if (this.pBC == null) {
          break label1229;
        }
      }
      for (int k = this.pBC.size();; k = 0)
      {
        ac.i("MicroMsg.NetSceneGetRankInfo", "isCacheExist(%s), RankFollowInfo size(%s), RankInfo size(%d), LikeInfo size(%d).", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
        ad.cgU().b(this.pBE, this.appName, this.pBC);
        if (this.pBz != null) {
          ad.cgT().a(this.pBz);
        }
        super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
        paramq = (com.tencent.mm.plugin.exdevice.b.b)this.pBJ.get();
        if (paramq != null) {
          paramq.a(paramInt2, paramInt3, paramString, this);
        }
        AppMethodBeat.o(23527);
        return;
        localObject1 = new com.tencent.mm.plugin.exdevice.g.b.a.a();
        ((com.tencent.mm.plugin.exdevice.g.b.a.a)localObject1).field_username = ((String)localObject2);
        ((com.tencent.mm.plugin.exdevice.g.b.a.a)localObject1).field_championUrl = ((String)localObject3);
        ((com.tencent.mm.plugin.exdevice.g.b.a.a)localObject1).field_championMotto = ((String)localObject4);
        break;
        bool = false;
        break label783;
        ac.i("MicroMsg.ExdeviceRankInfoStg", "delete rankInfo by rankId (%s).(r : %d)", new Object[] { localObject2, Integer.valueOf(((com.tencent.mm.plugin.exdevice.g.b.b.d)localObject1).db.delete("HardDeviceRankInfo", "rankID = ? ", new String[] { localObject2 })) });
        break label929;
        i = 0;
        break label965;
        j = 0;
        break label981;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(j paramj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.a.j
 * JD-Core Version:    0.7.0.1
 */