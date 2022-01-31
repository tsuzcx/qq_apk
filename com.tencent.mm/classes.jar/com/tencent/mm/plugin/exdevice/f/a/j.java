package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.f.b.f;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.protocal.protobuf.adu;
import com.tencent.mm.protocal.protobuf.arj;
import com.tencent.mm.protocal.protobuf.ark;
import com.tencent.mm.protocal.protobuf.dbz;
import com.tencent.mm.protocal.protobuf.dca;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bd;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class j
  extends com.tencent.mm.plugin.exdevice.a.a<arj, ark>
{
  public String appName;
  public boolean lHA;
  public boolean lHB;
  public String lHC;
  public String lHD;
  public com.tencent.mm.plugin.exdevice.f.b.a.a lHE;
  public ArrayList<com.tencent.mm.plugin.exdevice.f.b.a.d> lHF;
  public ArrayList<com.tencent.mm.plugin.exdevice.f.b.a.c> lHG;
  public ArrayList<com.tencent.mm.plugin.exdevice.f.b.a.e> lHH;
  public ArrayList<String> lHI;
  public String lHJ;
  public String lHK;
  public boolean lHL;
  public boolean lHM;
  public String lHN;
  private final WeakReference<com.tencent.mm.plugin.exdevice.a.b<j>> lHO;
  public j.a lHP;
  public String lHq;
  public String lHr;
  
  public j(String paramString1, String paramString2, String paramString3, boolean paramBoolean, com.tencent.mm.plugin.exdevice.a.b<j> paramb)
  {
    AppMethodBeat.i(19458);
    this.lHO = new WeakReference(paramb);
    this.lHJ = paramString1;
    this.lHC = paramString1;
    this.appName = bo.nullAsNil(paramString2);
    this.lHB = paramBoolean;
    this.lHD = paramString3;
    AppMethodBeat.o(19458);
  }
  
  public final int getType()
  {
    return 1042;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmbiz-bin/rank/getuserranklike";
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(19459);
    ab.d("MicroMsg.NetSceneGetRankInfo", "hy: get rank info end. errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    ark localark;
    Object localObject1;
    Object localObject3;
    Object localObject4;
    String str1;
    String str2;
    Object localObject2;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      localark = (ark)aUl();
      localObject1 = "";
      this.lHG = new ArrayList();
      if (localark.woL != null)
      {
        localObject3 = localark.woL.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (adu)((Iterator)localObject3).next();
          aw.aaz();
          if (com.tencent.mm.model.c.YA().arr(((adu)localObject4).username))
          {
            str1 = localark.fhi;
            str2 = this.appName;
            if ((bo.isNullOrNil(str1)) || (localObject4 == null))
            {
              ab.w("MicroMsg.ExdeviceRankConverter", "hy: param error");
              localObject2 = null;
            }
            for (;;)
            {
              if (localObject2 == null) {
                break label226;
              }
              this.lHG.add(localObject2);
              break;
              localObject2 = new com.tencent.mm.plugin.exdevice.f.b.a.c();
              ((com.tencent.mm.plugin.exdevice.f.b.a.c)localObject2).field_rankID = str1;
              ((com.tencent.mm.plugin.exdevice.f.b.a.c)localObject2).field_username = ((adu)localObject4).username;
              ((com.tencent.mm.plugin.exdevice.f.b.a.c)localObject2).field_step = ((adu)localObject4).hAu;
              ((com.tencent.mm.plugin.exdevice.f.b.a.c)localObject2).field_appusername = str2;
            }
          }
          else
          {
            label226:
            aw.Rc().a(new h(((adu)localObject4).username, null), 0);
          }
        }
      }
      this.lHF = new ArrayList();
      localObject2 = localObject1;
      if (localark.xgJ != null)
      {
        localObject3 = localark.xgJ.iterator();
        localObject2 = localObject1;
        if (((Iterator)localObject3).hasNext())
        {
          localObject4 = (dbz)((Iterator)localObject3).next();
          str1 = localark.fhi;
          str2 = this.appName;
          if ((bo.isNullOrNil(str1)) || (localObject4 == null))
          {
            ab.w("MicroMsg.ExdeviceRankConverter", "hy: param error");
            localObject2 = null;
            label347:
            if (localObject2 == null) {
              break label455;
            }
            if (((com.tencent.mm.plugin.exdevice.f.b.a.d)localObject2).field_ranknum != 1) {
              break label1235;
            }
            localObject1 = ((com.tencent.mm.plugin.exdevice.f.b.a.d)localObject2).field_username;
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
      this.lHF.add(localObject2);
      break;
      localObject2 = new com.tencent.mm.plugin.exdevice.f.b.a.d();
      ((com.tencent.mm.plugin.exdevice.f.b.a.d)localObject2).field_appusername = str2;
      ((com.tencent.mm.plugin.exdevice.f.b.a.d)localObject2).field_rankID = str1;
      ((com.tencent.mm.plugin.exdevice.f.b.a.d)localObject2).field_likecount = ((dbz)localObject4).yii;
      ((com.tencent.mm.plugin.exdevice.f.b.a.d)localObject2).field_ranknum = ((dbz)localObject4).yih;
      ((com.tencent.mm.plugin.exdevice.f.b.a.d)localObject2).field_score = ((dbz)localObject4).score;
      ((com.tencent.mm.plugin.exdevice.f.b.a.d)localObject2).field_selfLikeState = ((dbz)localObject4).yij;
      ((com.tencent.mm.plugin.exdevice.f.b.a.d)localObject2).field_username = ((dbz)localObject4).username;
      break label347;
      break;
      this.lHH = new ArrayList();
      if (localark.xgK != null)
      {
        localObject3 = localark.xgK.iterator();
        label606:
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (dca)((Iterator)localObject3).next();
          str1 = localark.fhi;
          str2 = this.appName;
          if ((bo.isNullOrNil(str1)) || (localObject4 == null))
          {
            ab.w("MicroMsg.ExdeviceRankConverter", "hy: param error");
            localObject1 = null;
          }
          for (;;)
          {
            if (localObject1 == null) {
              break label606;
            }
            this.lHH.add(localObject1);
            break;
            localObject1 = new com.tencent.mm.plugin.exdevice.f.b.a.e();
            ((com.tencent.mm.plugin.exdevice.f.b.a.e)localObject1).field_appusername = str2;
            ((com.tencent.mm.plugin.exdevice.f.b.a.e)localObject1).field_rankID = str1;
            ((com.tencent.mm.plugin.exdevice.f.b.a.e)localObject1).field_timestamp = ((dca)localObject4).timestamp;
            ((com.tencent.mm.plugin.exdevice.f.b.a.e)localObject1).field_username = ((dca)localObject4).username;
          }
        }
      }
      this.lHI = new ArrayList();
      if (localark.xgC != null)
      {
        localObject1 = localark.xgC.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (String)((Iterator)localObject1).next();
          this.lHI.add(localObject3);
        }
      }
      if (!bo.isNullOrNil(this.lHD)) {
        localObject2 = this.lHD;
      }
      localObject3 = localark.xgL;
      localObject4 = localark.xgM;
      boolean bool;
      int i;
      int j;
      if (bo.isNullOrNil((String)localObject2))
      {
        ab.w("MicroMsg.ExdeviceRankConverter", "hy: param error");
        localObject1 = null;
        this.lHE = ((com.tencent.mm.plugin.exdevice.f.b.a.a)localObject1);
        this.lHJ = localark.fhi;
        this.lHr = localark.xgE;
        this.lHq = localark.xgD;
        this.lHK = localark.xgN;
        this.lHL = localark.lHL;
        if (localark.xgQ != 1) {
          break label1159;
        }
        bool = true;
        this.lHM = bool;
        this.lHN = localark.xgR;
        this.lHA = localark.xgG;
        ab.d("MicroMsg.NetSceneGetRankInfo", "hy: get score info ok.");
        if ((this.lHC == null) || (!this.lHC.equals(this.lHJ)))
        {
          localObject1 = ad.bqg().lHW;
          if (localObject1 != null) {
            ((f)localObject1).LB(this.lHJ);
          }
        }
        if ((this.lHP != null) && (this.lHB)) {
          this.lHP.a(this);
        }
        if (this.lHB) {
          ad.bqa().bv(this.lHG);
        }
        localObject1 = ad.bpZ();
        localObject2 = this.lHJ;
        if (!bo.isNullOrNil((String)localObject2)) {
          break label1165;
        }
        ab.w("MicroMsg.ExdeviceRankInfoStg", "delete rankInfo by rankId failed, rankId is null or nil.");
        ad.bpZ().g(this.lHJ, this.lHF);
        bool = this.lHL;
        if (this.lHG == null) {
          break label1217;
        }
        i = this.lHG.size();
        if (this.lHF == null) {
          break label1223;
        }
        j = this.lHF.size();
        label981:
        if (this.lHH == null) {
          break label1229;
        }
      }
      for (int k = this.lHH.size();; k = 0)
      {
        ab.i("MicroMsg.NetSceneGetRankInfo", "isCacheExist(%s), RankFollowInfo size(%s), RankInfo size(%d), LikeInfo size(%d).", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
        ad.bqd().a(this.lHJ, this.appName, this.lHH);
        if (this.lHE != null) {
          ad.bqc().a(this.lHE);
        }
        super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
        paramq = (com.tencent.mm.plugin.exdevice.a.b)this.lHO.get();
        if (paramq != null) {
          paramq.a(paramInt2, paramInt3, paramString, this);
        }
        AppMethodBeat.o(19459);
        return;
        localObject1 = new com.tencent.mm.plugin.exdevice.f.b.a.a();
        ((com.tencent.mm.plugin.exdevice.f.b.a.a)localObject1).field_username = ((String)localObject2);
        ((com.tencent.mm.plugin.exdevice.f.b.a.a)localObject1).field_championUrl = ((String)localObject3);
        ((com.tencent.mm.plugin.exdevice.f.b.a.a)localObject1).field_championMotto = ((String)localObject4);
        break;
        bool = false;
        break label783;
        ab.i("MicroMsg.ExdeviceRankInfoStg", "delete rankInfo by rankId (%s).(r : %d)", new Object[] { localObject2, Integer.valueOf(((com.tencent.mm.plugin.exdevice.f.b.b.d)localObject1).db.delete("HardDeviceRankInfo", "rankID = ? ", new String[] { localObject2 })) });
        break label929;
        i = 0;
        break label965;
        j = 0;
        break label981;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.a.j
 * JD-Core Version:    0.7.0.1
 */