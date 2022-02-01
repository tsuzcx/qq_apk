package com.tencent.mm.plugin.exdevice.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.exdevice.g.b.f;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.protocal.protobuf.ats;
import com.tencent.mm.protocal.protobuf.bku;
import com.tencent.mm.protocal.protobuf.bkv;
import com.tencent.mm.protocal.protobuf.eko;
import com.tencent.mm.protocal.protobuf.ekp;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bq;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class j
  extends com.tencent.mm.plugin.exdevice.b.a<bku, bkv>
{
  public String appName;
  public boolean qlF;
  public boolean qlG;
  public String qlH;
  public String qlI;
  public com.tencent.mm.plugin.exdevice.g.b.a.a qlJ;
  public ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.d> qlK;
  public ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.c> qlL;
  public ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.e> qlM;
  public ArrayList<String> qlN;
  public String qlO;
  public String qlP;
  public boolean qlQ;
  public boolean qlR;
  public String qlS;
  private final WeakReference<com.tencent.mm.plugin.exdevice.b.b<j>> qlT;
  public a qlU;
  public String qlv;
  public String qlw;
  
  public j(String paramString1, String paramString2, String paramString3, boolean paramBoolean, com.tencent.mm.plugin.exdevice.b.b<j> paramb)
  {
    AppMethodBeat.i(23526);
    this.qlT = new WeakReference(paramb);
    this.qlO = paramString1;
    this.qlH = paramString1;
    this.appName = bu.nullAsNil(paramString2);
    this.qlG = paramBoolean;
    this.qlI = paramString3;
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
    ae.d("MicroMsg.NetSceneGetRankInfo", "hy: get rank info end. errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    bkv localbkv;
    Object localObject1;
    Object localObject3;
    Object localObject4;
    String str1;
    String str2;
    Object localObject2;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      localbkv = (bkv)bJx();
      localObject1 = "";
      this.qlL = new ArrayList();
      if (localbkv.FNC != null)
      {
        localObject3 = localbkv.FNC.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (ats)((Iterator)localObject3).next();
          bc.aCg();
          if (com.tencent.mm.model.c.azF().aUH(((ats)localObject4).username))
          {
            str1 = localbkv.hDm;
            str2 = this.appName;
            if ((bu.isNullOrNil(str1)) || (localObject4 == null))
            {
              ae.w("MicroMsg.ExdeviceRankConverter", "hy: param error");
              localObject2 = null;
            }
            for (;;)
            {
              if (localObject2 == null) {
                break label226;
              }
              this.qlL.add(localObject2);
              break;
              localObject2 = new com.tencent.mm.plugin.exdevice.g.b.a.c();
              ((com.tencent.mm.plugin.exdevice.g.b.a.c)localObject2).field_rankID = str1;
              ((com.tencent.mm.plugin.exdevice.g.b.a.c)localObject2).field_username = ((ats)localObject4).username;
              ((com.tencent.mm.plugin.exdevice.g.b.a.c)localObject2).field_step = ((ats)localObject4).kyd;
              ((com.tencent.mm.plugin.exdevice.g.b.a.c)localObject2).field_appusername = str2;
            }
          }
          else
          {
            label226:
            bc.ajj().a(new h(((ats)localObject4).username, null), 0);
          }
        }
      }
      this.qlK = new ArrayList();
      localObject2 = localObject1;
      if (localbkv.GYh != null)
      {
        localObject3 = localbkv.GYh.iterator();
        localObject2 = localObject1;
        if (((Iterator)localObject3).hasNext())
        {
          localObject4 = (eko)((Iterator)localObject3).next();
          str1 = localbkv.hDm;
          str2 = this.appName;
          if ((bu.isNullOrNil(str1)) || (localObject4 == null))
          {
            ae.w("MicroMsg.ExdeviceRankConverter", "hy: param error");
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
      this.qlK.add(localObject2);
      break;
      localObject2 = new com.tencent.mm.plugin.exdevice.g.b.a.d();
      ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2).field_appusername = str2;
      ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2).field_rankID = str1;
      ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2).field_likecount = ((eko)localObject4).InD;
      ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2).field_ranknum = ((eko)localObject4).InC;
      ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2).field_score = ((eko)localObject4).score;
      ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2).field_selfLikeState = ((eko)localObject4).InE;
      ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2).field_username = ((eko)localObject4).username;
      break label347;
      break;
      this.qlM = new ArrayList();
      if (localbkv.GYi != null)
      {
        localObject3 = localbkv.GYi.iterator();
        label606:
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (ekp)((Iterator)localObject3).next();
          str1 = localbkv.hDm;
          str2 = this.appName;
          if ((bu.isNullOrNil(str1)) || (localObject4 == null))
          {
            ae.w("MicroMsg.ExdeviceRankConverter", "hy: param error");
            localObject1 = null;
          }
          for (;;)
          {
            if (localObject1 == null) {
              break label606;
            }
            this.qlM.add(localObject1);
            break;
            localObject1 = new com.tencent.mm.plugin.exdevice.g.b.a.e();
            ((com.tencent.mm.plugin.exdevice.g.b.a.e)localObject1).field_appusername = str2;
            ((com.tencent.mm.plugin.exdevice.g.b.a.e)localObject1).field_rankID = str1;
            ((com.tencent.mm.plugin.exdevice.g.b.a.e)localObject1).field_timestamp = ((ekp)localObject4).phB;
            ((com.tencent.mm.plugin.exdevice.g.b.a.e)localObject1).field_username = ((ekp)localObject4).username;
          }
        }
      }
      this.qlN = new ArrayList();
      if (localbkv.GYa != null)
      {
        localObject1 = localbkv.GYa.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (String)((Iterator)localObject1).next();
          this.qlN.add(localObject3);
        }
      }
      if (!bu.isNullOrNil(this.qlI)) {
        localObject2 = this.qlI;
      }
      localObject3 = localbkv.GYj;
      localObject4 = localbkv.GYk;
      boolean bool;
      int i;
      int j;
      if (bu.isNullOrNil((String)localObject2))
      {
        ae.w("MicroMsg.ExdeviceRankConverter", "hy: param error");
        localObject1 = null;
        this.qlJ = ((com.tencent.mm.plugin.exdevice.g.b.a.a)localObject1);
        this.qlO = localbkv.hDm;
        this.qlw = localbkv.GYc;
        this.qlv = localbkv.GYb;
        this.qlP = localbkv.GYl;
        this.qlQ = localbkv.qlQ;
        if (localbkv.GYo != 1) {
          break label1159;
        }
        bool = true;
        this.qlR = bool;
        this.qlS = localbkv.GYp;
        this.qlF = localbkv.GYe;
        ae.d("MicroMsg.NetSceneGetRankInfo", "hy: get score info ok.");
        if ((this.qlH == null) || (!this.qlH.equals(this.qlO)))
        {
          localObject1 = ad.cmR().qmb;
          if (localObject1 != null) {
            ((f)localObject1).adt(this.qlO);
          }
        }
        if ((this.qlU != null) && (this.qlG)) {
          this.qlU.a(this);
        }
        if (this.qlG) {
          ad.cmL().cY(this.qlL);
        }
        localObject1 = ad.cmK();
        localObject2 = this.qlO;
        if (!bu.isNullOrNil((String)localObject2)) {
          break label1165;
        }
        ae.w("MicroMsg.ExdeviceRankInfoStg", "delete rankInfo by rankId failed, rankId is null or nil.");
        ad.cmK().f(this.qlO, this.qlK);
        bool = this.qlQ;
        if (this.qlL == null) {
          break label1217;
        }
        i = this.qlL.size();
        if (this.qlK == null) {
          break label1223;
        }
        j = this.qlK.size();
        label981:
        if (this.qlM == null) {
          break label1229;
        }
      }
      for (int k = this.qlM.size();; k = 0)
      {
        ae.i("MicroMsg.NetSceneGetRankInfo", "isCacheExist(%s), RankFollowInfo size(%s), RankInfo size(%d), LikeInfo size(%d).", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
        ad.cmO().b(this.qlO, this.appName, this.qlM);
        if (this.qlJ != null) {
          ad.cmN().a(this.qlJ);
        }
        super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
        paramq = (com.tencent.mm.plugin.exdevice.b.b)this.qlT.get();
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
        ae.i("MicroMsg.ExdeviceRankInfoStg", "delete rankInfo by rankId (%s).(r : %d)", new Object[] { localObject2, Integer.valueOf(((com.tencent.mm.plugin.exdevice.g.b.b.d)localObject1).db.delete("HardDeviceRankInfo", "rankID = ? ", new String[] { localObject2 })) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.a.j
 * JD-Core Version:    0.7.0.1
 */