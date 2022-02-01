package com.tencent.mm.plugin.exdevice.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.exdevice.g.b.f;
import com.tencent.mm.protocal.protobuf.atc;
import com.tencent.mm.protocal.protobuf.bkc;
import com.tencent.mm.protocal.protobuf.bkd;
import com.tencent.mm.protocal.protobuf.eix;
import com.tencent.mm.protocal.protobuf.eiy;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bp;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class j
  extends com.tencent.mm.plugin.exdevice.b.a<bkc, bkd>
{
  public String appName;
  public String qeQ;
  public String qeR;
  public boolean qfa;
  public boolean qfb;
  public String qfc;
  public String qfd;
  public com.tencent.mm.plugin.exdevice.g.b.a.a qfe;
  public ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.d> qff;
  public ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.c> qfg;
  public ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.e> qfh;
  public ArrayList<String> qfi;
  public String qfj;
  public String qfk;
  public boolean qfl;
  public boolean qfm;
  public String qfn;
  private final WeakReference<com.tencent.mm.plugin.exdevice.b.b<j>> qfo;
  public a qfp;
  
  public j(String paramString1, String paramString2, String paramString3, boolean paramBoolean, com.tencent.mm.plugin.exdevice.b.b<j> paramb)
  {
    AppMethodBeat.i(23526);
    this.qfo = new WeakReference(paramb);
    this.qfj = paramString1;
    this.qfc = paramString1;
    this.appName = bt.nullAsNil(paramString2);
    this.qfb = paramBoolean;
    this.qfd = paramString3;
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
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetSceneGetRankInfo", "hy: get rank info end. errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    bkd localbkd;
    Object localObject1;
    Object localObject3;
    Object localObject4;
    String str1;
    String str2;
    Object localObject2;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      localbkd = (bkd)bIz();
      localObject1 = "";
      this.qfg = new ArrayList();
      if (localbkd.Fve != null)
      {
        localObject3 = localbkd.Fve.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (atc)((Iterator)localObject3).next();
          ba.aBQ();
          if (com.tencent.mm.model.c.azp().aTg(((atc)localObject4).username))
          {
            str1 = localbkd.hAy;
            str2 = this.appName;
            if ((bt.isNullOrNil(str1)) || (localObject4 == null))
            {
              com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.ExdeviceRankConverter", "hy: param error");
              localObject2 = null;
            }
            for (;;)
            {
              if (localObject2 == null) {
                break label226;
              }
              this.qfg.add(localObject2);
              break;
              localObject2 = new com.tencent.mm.plugin.exdevice.g.b.a.c();
              ((com.tencent.mm.plugin.exdevice.g.b.a.c)localObject2).field_rankID = str1;
              ((com.tencent.mm.plugin.exdevice.g.b.a.c)localObject2).field_username = ((atc)localObject4).username;
              ((com.tencent.mm.plugin.exdevice.g.b.a.c)localObject2).field_step = ((atc)localObject4).kuN;
              ((com.tencent.mm.plugin.exdevice.g.b.a.c)localObject2).field_appusername = str2;
            }
          }
          else
          {
            label226:
            ba.aiU().a(new h(((atc)localObject4).username, null), 0);
          }
        }
      }
      this.qff = new ArrayList();
      localObject2 = localObject1;
      if (localbkd.GEE != null)
      {
        localObject3 = localbkd.GEE.iterator();
        localObject2 = localObject1;
        if (((Iterator)localObject3).hasNext())
        {
          localObject4 = (eix)((Iterator)localObject3).next();
          str1 = localbkd.hAy;
          str2 = this.appName;
          if ((bt.isNullOrNil(str1)) || (localObject4 == null))
          {
            com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.ExdeviceRankConverter", "hy: param error");
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
      this.qff.add(localObject2);
      break;
      localObject2 = new com.tencent.mm.plugin.exdevice.g.b.a.d();
      ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2).field_appusername = str2;
      ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2).field_rankID = str1;
      ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2).field_likecount = ((eix)localObject4).HTw;
      ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2).field_ranknum = ((eix)localObject4).HTv;
      ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2).field_score = ((eix)localObject4).score;
      ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2).field_selfLikeState = ((eix)localObject4).HTx;
      ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2).field_username = ((eix)localObject4).username;
      break label347;
      break;
      this.qfh = new ArrayList();
      if (localbkd.GEF != null)
      {
        localObject3 = localbkd.GEF.iterator();
        label606:
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (eiy)((Iterator)localObject3).next();
          str1 = localbkd.hAy;
          str2 = this.appName;
          if ((bt.isNullOrNil(str1)) || (localObject4 == null))
          {
            com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.ExdeviceRankConverter", "hy: param error");
            localObject1 = null;
          }
          for (;;)
          {
            if (localObject1 == null) {
              break label606;
            }
            this.qfh.add(localObject1);
            break;
            localObject1 = new com.tencent.mm.plugin.exdevice.g.b.a.e();
            ((com.tencent.mm.plugin.exdevice.g.b.a.e)localObject1).field_appusername = str2;
            ((com.tencent.mm.plugin.exdevice.g.b.a.e)localObject1).field_rankID = str1;
            ((com.tencent.mm.plugin.exdevice.g.b.a.e)localObject1).field_timestamp = ((eiy)localObject4).paX;
            ((com.tencent.mm.plugin.exdevice.g.b.a.e)localObject1).field_username = ((eiy)localObject4).username;
          }
        }
      }
      this.qfi = new ArrayList();
      if (localbkd.GEx != null)
      {
        localObject1 = localbkd.GEx.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (String)((Iterator)localObject1).next();
          this.qfi.add(localObject3);
        }
      }
      if (!bt.isNullOrNil(this.qfd)) {
        localObject2 = this.qfd;
      }
      localObject3 = localbkd.GEG;
      localObject4 = localbkd.GEH;
      boolean bool;
      int i;
      int j;
      if (bt.isNullOrNil((String)localObject2))
      {
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.ExdeviceRankConverter", "hy: param error");
        localObject1 = null;
        this.qfe = ((com.tencent.mm.plugin.exdevice.g.b.a.a)localObject1);
        this.qfj = localbkd.hAy;
        this.qeR = localbkd.GEz;
        this.qeQ = localbkd.GEy;
        this.qfk = localbkd.GEI;
        this.qfl = localbkd.qfl;
        if (localbkd.GEL != 1) {
          break label1159;
        }
        bool = true;
        this.qfm = bool;
        this.qfn = localbkd.GEM;
        this.qfa = localbkd.GEB;
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetSceneGetRankInfo", "hy: get score info ok.");
        if ((this.qfc == null) || (!this.qfc.equals(this.qfj)))
        {
          localObject1 = com.tencent.mm.plugin.exdevice.model.ad.clB().qfw;
          if (localObject1 != null) {
            ((f)localObject1).acC(this.qfj);
          }
        }
        if ((this.qfp != null) && (this.qfb)) {
          this.qfp.a(this);
        }
        if (this.qfb) {
          com.tencent.mm.plugin.exdevice.model.ad.clv().cV(this.qfg);
        }
        localObject1 = com.tencent.mm.plugin.exdevice.model.ad.clu();
        localObject2 = this.qfj;
        if (!bt.isNullOrNil((String)localObject2)) {
          break label1165;
        }
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.ExdeviceRankInfoStg", "delete rankInfo by rankId failed, rankId is null or nil.");
        com.tencent.mm.plugin.exdevice.model.ad.clu().f(this.qfj, this.qff);
        bool = this.qfl;
        if (this.qfg == null) {
          break label1217;
        }
        i = this.qfg.size();
        if (this.qff == null) {
          break label1223;
        }
        j = this.qff.size();
        label981:
        if (this.qfh == null) {
          break label1229;
        }
      }
      for (int k = this.qfh.size();; k = 0)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneGetRankInfo", "isCacheExist(%s), RankFollowInfo size(%s), RankInfo size(%d), LikeInfo size(%d).", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
        com.tencent.mm.plugin.exdevice.model.ad.cly().b(this.qfj, this.appName, this.qfh);
        if (this.qfe != null) {
          com.tencent.mm.plugin.exdevice.model.ad.clx().a(this.qfe);
        }
        super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
        paramq = (com.tencent.mm.plugin.exdevice.b.b)this.qfo.get();
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
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ExdeviceRankInfoStg", "delete rankInfo by rankId (%s).(r : %d)", new Object[] { localObject2, Integer.valueOf(((com.tencent.mm.plugin.exdevice.g.b.b.d)localObject1).db.delete("HardDeviceRankInfo", "rankID = ? ", new String[] { localObject2 })) });
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