package com.tencent.mm.plugin.exdevice.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.bg;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.exdevice.g.b.f;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.protocal.protobuf.bes;
import com.tencent.mm.protocal.protobuf.bxd;
import com.tencent.mm.protocal.protobuf.bxe;
import com.tencent.mm.protocal.protobuf.ffl;
import com.tencent.mm.protocal.protobuf.ffm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.bv;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class j
  extends com.tencent.mm.plugin.exdevice.b.a<bxd, bxe>
{
  public String appName;
  public String msN;
  public boolean rCA;
  public String rCB;
  public String rCC;
  public com.tencent.mm.plugin.exdevice.g.b.a.a rCD;
  public ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.d> rCE;
  public ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.c> rCF;
  public ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.e> rCG;
  public ArrayList<String> rCH;
  public String rCI;
  public String rCJ;
  public boolean rCK;
  public boolean rCL;
  public String rCM;
  private final WeakReference<com.tencent.mm.plugin.exdevice.b.b<j>> rCN;
  public a rCO;
  public String rCq;
  public boolean rCz;
  
  public j(String paramString1, String paramString2, String paramString3, boolean paramBoolean, com.tencent.mm.plugin.exdevice.b.b<j> paramb)
  {
    AppMethodBeat.i(23526);
    this.rCN = new WeakReference(paramb);
    this.rCI = paramString1;
    this.rCB = paramString1;
    this.appName = Util.nullAsNil(paramString2);
    this.rCA = paramBoolean;
    this.rCC = paramString3;
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
    bxe localbxe;
    Object localObject1;
    Object localObject3;
    Object localObject4;
    String str1;
    String str2;
    Object localObject2;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      localbxe = (bxe)cgq();
      localObject1 = "";
      this.rCF = new ArrayList();
      if (localbxe.KHh != null)
      {
        localObject3 = localbxe.KHh.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (bes)((Iterator)localObject3).next();
          bg.aVF();
          if (com.tencent.mm.model.c.aSN().bjG(((bes)localObject4).username))
          {
            str1 = localbxe.ixr;
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
              this.rCF.add(localObject2);
              break;
              localObject2 = new com.tencent.mm.plugin.exdevice.g.b.a.c();
              ((com.tencent.mm.plugin.exdevice.g.b.a.c)localObject2).field_rankID = str1;
              ((com.tencent.mm.plugin.exdevice.g.b.a.c)localObject2).field_username = ((bes)localObject4).username;
              ((com.tencent.mm.plugin.exdevice.g.b.a.c)localObject2).field_step = ((bes)localObject4).lCq;
              ((com.tencent.mm.plugin.exdevice.g.b.a.c)localObject2).field_appusername = str2;
            }
          }
          else
          {
            label226:
            bg.azz().a(new h(((bes)localObject4).username, null), 0);
          }
        }
      }
      this.rCE = new ArrayList();
      localObject2 = localObject1;
      if (localbxe.McX != null)
      {
        localObject3 = localbxe.McX.iterator();
        localObject2 = localObject1;
        if (((Iterator)localObject3).hasNext())
        {
          localObject4 = (ffl)((Iterator)localObject3).next();
          str1 = localbxe.ixr;
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
      this.rCE.add(localObject2);
      break;
      localObject2 = new com.tencent.mm.plugin.exdevice.g.b.a.d();
      ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2).field_appusername = str2;
      ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2).field_rankID = str1;
      ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2).field_likecount = ((ffl)localObject4).Lqb;
      ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2).field_ranknum = ((ffl)localObject4).NAI;
      ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2).field_score = ((ffl)localObject4).score;
      ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2).field_selfLikeState = ((ffl)localObject4).NAJ;
      ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2).field_username = ((ffl)localObject4).username;
      ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2).field_sportRecord = ((ffl)localObject4).NAK;
      break label347;
      break;
      this.rCG = new ArrayList();
      if (localbxe.McY != null)
      {
        localObject3 = localbxe.McY.iterator();
        label616:
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (ffm)((Iterator)localObject3).next();
          str1 = localbxe.ixr;
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
            this.rCG.add(localObject1);
            break;
            localObject1 = new com.tencent.mm.plugin.exdevice.g.b.a.e();
            ((com.tencent.mm.plugin.exdevice.g.b.a.e)localObject1).field_appusername = str2;
            ((com.tencent.mm.plugin.exdevice.g.b.a.e)localObject1).field_rankID = str1;
            ((com.tencent.mm.plugin.exdevice.g.b.a.e)localObject1).field_timestamp = ((ffm)localObject4).qwL;
            ((com.tencent.mm.plugin.exdevice.g.b.a.e)localObject1).field_username = ((ffm)localObject4).username;
          }
        }
      }
      this.rCH = new ArrayList();
      if (localbxe.McO != null)
      {
        localObject1 = localbxe.McO.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (String)((Iterator)localObject1).next();
          this.rCH.add(localObject3);
        }
      }
      if (!Util.isNullOrNil(this.rCC)) {
        localObject2 = this.rCC;
      }
      localObject3 = localbxe.McZ;
      localObject4 = localbxe.Mda;
      boolean bool;
      int i;
      int j;
      if (Util.isNullOrNil((String)localObject2))
      {
        Log.w("MicroMsg.ExdeviceRankConverter", "hy: param error");
        localObject1 = null;
        this.rCD = ((com.tencent.mm.plugin.exdevice.g.b.a.a)localObject1);
        this.rCI = localbxe.ixr;
        this.msN = localbxe.McQ;
        this.rCq = localbxe.McP;
        this.rCJ = localbxe.Mdb;
        this.rCK = localbxe.rCK;
        if (localbxe.Mde != 1) {
          break label1169;
        }
        bool = true;
        this.rCL = bool;
        this.rCM = localbxe.Mdf;
        this.rCz = localbxe.McS;
        Log.d("MicroMsg.NetSceneGetRankInfo", "hy: get score info ok.");
        if ((this.rCB == null) || (!this.rCB.equals(this.rCI)))
        {
          localObject1 = ad.cKT().rCX;
          if (localObject1 != null) {
            ((f)localObject1).anC(this.rCI);
          }
        }
        if ((this.rCO != null) && (this.rCA)) {
          this.rCO.a(this);
        }
        if (this.rCA) {
          ad.cKN().dn(this.rCF);
        }
        localObject1 = ad.cKM();
        localObject2 = this.rCI;
        if (!Util.isNullOrNil((String)localObject2)) {
          break label1175;
        }
        Log.w("MicroMsg.ExdeviceRankInfoStg", "delete rankInfo by rankId failed, rankId is null or nil.");
        ad.cKM().g(this.rCI, this.rCE);
        bool = this.rCK;
        if (this.rCF == null) {
          break label1227;
        }
        i = this.rCF.size();
        if (this.rCE == null) {
          break label1233;
        }
        j = this.rCE.size();
        label991:
        if (this.rCG == null) {
          break label1239;
        }
      }
      for (int k = this.rCG.size();; k = 0)
      {
        Log.i("MicroMsg.NetSceneGetRankInfo", "isCacheExist(%s), RankFollowInfo size(%s), RankInfo size(%d), LikeInfo size(%d).", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
        ad.cKQ().b(this.rCI, this.appName, this.rCG);
        if (this.rCD != null) {
          ad.cKP().a(this.rCD);
        }
        super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, params, paramArrayOfByte);
        params = (com.tencent.mm.plugin.exdevice.b.b)this.rCN.get();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.a.j
 * JD-Core Version:    0.7.0.1
 */