package com.tencent.mm.plugin.exdevice.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.exdevice.g.b.f;
import com.tencent.mm.protocal.protobuf.amf;
import com.tencent.mm.protocal.protobuf.bcc;
import com.tencent.mm.protocal.protobuf.bcd;
import com.tencent.mm.protocal.protobuf.dxa;
import com.tencent.mm.protocal.protobuf.dxb;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bg;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class j
  extends com.tencent.mm.plugin.exdevice.b.a<bcc, bcd>
{
  public String appName;
  public String oYa;
  public String oYb;
  public boolean oYk;
  public boolean oYl;
  public String oYm;
  public String oYn;
  public com.tencent.mm.plugin.exdevice.g.b.a.a oYo;
  public ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.d> oYp;
  public ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.c> oYq;
  public ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.e> oYr;
  public ArrayList<String> oYs;
  public String oYt;
  public String oYu;
  public boolean oYv;
  public boolean oYw;
  public String oYx;
  private final WeakReference<com.tencent.mm.plugin.exdevice.b.b<j>> oYy;
  public a oYz;
  
  public j(String paramString1, String paramString2, String paramString3, boolean paramBoolean, com.tencent.mm.plugin.exdevice.b.b<j> paramb)
  {
    AppMethodBeat.i(23526);
    this.oYy = new WeakReference(paramb);
    this.oYt = paramString1;
    this.oYm = paramString1;
    this.appName = bt.nullAsNil(paramString2);
    this.oYl = paramBoolean;
    this.oYn = paramString3;
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
    bcd localbcd;
    Object localObject1;
    Object localObject3;
    Object localObject4;
    String str1;
    String str2;
    Object localObject2;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      localbcd = (bcd)bxu();
      localObject1 = "";
      this.oYq = new ArrayList();
      if (localbcd.Cxt != null)
      {
        localObject3 = localbcd.Cxt.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (amf)((Iterator)localObject3).next();
          az.arV();
          if (com.tencent.mm.model.c.apM().aHT(((amf)localObject4).username))
          {
            str1 = localbcd.gHO;
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
              this.oYq.add(localObject2);
              break;
              localObject2 = new com.tencent.mm.plugin.exdevice.g.b.a.c();
              ((com.tencent.mm.plugin.exdevice.g.b.a.c)localObject2).field_rankID = str1;
              ((com.tencent.mm.plugin.exdevice.g.b.a.c)localObject2).field_username = ((amf)localObject4).username;
              ((com.tencent.mm.plugin.exdevice.g.b.a.c)localObject2).field_step = ((amf)localObject4).jzV;
              ((com.tencent.mm.plugin.exdevice.g.b.a.c)localObject2).field_appusername = str2;
            }
          }
          else
          {
            label226:
            az.aeS().a(new h(((amf)localObject4).username, null), 0);
          }
        }
      }
      this.oYp = new ArrayList();
      localObject2 = localObject1;
      if (localbcd.DzL != null)
      {
        localObject3 = localbcd.DzL.iterator();
        localObject2 = localObject1;
        if (((Iterator)localObject3).hasNext())
        {
          localObject4 = (dxa)((Iterator)localObject3).next();
          str1 = localbcd.gHO;
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
      this.oYp.add(localObject2);
      break;
      localObject2 = new com.tencent.mm.plugin.exdevice.g.b.a.d();
      ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2).field_appusername = str2;
      ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2).field_rankID = str1;
      ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2).field_likecount = ((dxa)localObject4).EKW;
      ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2).field_ranknum = ((dxa)localObject4).EKV;
      ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2).field_score = ((dxa)localObject4).score;
      ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2).field_selfLikeState = ((dxa)localObject4).EKX;
      ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2).field_username = ((dxa)localObject4).username;
      break label347;
      break;
      this.oYr = new ArrayList();
      if (localbcd.DzM != null)
      {
        localObject3 = localbcd.DzM.iterator();
        label606:
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (dxb)((Iterator)localObject3).next();
          str1 = localbcd.gHO;
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
            this.oYr.add(localObject1);
            break;
            localObject1 = new com.tencent.mm.plugin.exdevice.g.b.a.e();
            ((com.tencent.mm.plugin.exdevice.g.b.a.e)localObject1).field_appusername = str2;
            ((com.tencent.mm.plugin.exdevice.g.b.a.e)localObject1).field_rankID = str1;
            ((com.tencent.mm.plugin.exdevice.g.b.a.e)localObject1).field_timestamp = ((dxb)localObject4).nUh;
            ((com.tencent.mm.plugin.exdevice.g.b.a.e)localObject1).field_username = ((dxb)localObject4).username;
          }
        }
      }
      this.oYs = new ArrayList();
      if (localbcd.DzE != null)
      {
        localObject1 = localbcd.DzE.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (String)((Iterator)localObject1).next();
          this.oYs.add(localObject3);
        }
      }
      if (!bt.isNullOrNil(this.oYn)) {
        localObject2 = this.oYn;
      }
      localObject3 = localbcd.DzN;
      localObject4 = localbcd.DzO;
      boolean bool;
      int i;
      int j;
      if (bt.isNullOrNil((String)localObject2))
      {
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.ExdeviceRankConverter", "hy: param error");
        localObject1 = null;
        this.oYo = ((com.tencent.mm.plugin.exdevice.g.b.a.a)localObject1);
        this.oYt = localbcd.gHO;
        this.oYb = localbcd.DzG;
        this.oYa = localbcd.DzF;
        this.oYu = localbcd.DzP;
        this.oYv = localbcd.oYv;
        if (localbcd.DzS != 1) {
          break label1159;
        }
        bool = true;
        this.oYw = bool;
        this.oYx = localbcd.DzT;
        this.oYk = localbcd.DzI;
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetSceneGetRankInfo", "hy: get score info ok.");
        if ((this.oYm == null) || (!this.oYm.equals(this.oYt)))
        {
          localObject1 = com.tencent.mm.plugin.exdevice.model.ad.bZO().oYG;
          if (localObject1 != null) {
            ((f)localObject1).UK(this.oYt);
          }
        }
        if ((this.oYz != null) && (this.oYl)) {
          this.oYz.a(this);
        }
        if (this.oYl) {
          com.tencent.mm.plugin.exdevice.model.ad.bZI().cT(this.oYq);
        }
        localObject1 = com.tencent.mm.plugin.exdevice.model.ad.bZH();
        localObject2 = this.oYt;
        if (!bt.isNullOrNil((String)localObject2)) {
          break label1165;
        }
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.ExdeviceRankInfoStg", "delete rankInfo by rankId failed, rankId is null or nil.");
        com.tencent.mm.plugin.exdevice.model.ad.bZH().f(this.oYt, this.oYp);
        bool = this.oYv;
        if (this.oYq == null) {
          break label1217;
        }
        i = this.oYq.size();
        if (this.oYp == null) {
          break label1223;
        }
        j = this.oYp.size();
        label981:
        if (this.oYr == null) {
          break label1229;
        }
      }
      for (int k = this.oYr.size();; k = 0)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneGetRankInfo", "isCacheExist(%s), RankFollowInfo size(%s), RankInfo size(%d), LikeInfo size(%d).", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
        com.tencent.mm.plugin.exdevice.model.ad.bZL().b(this.oYt, this.appName, this.oYr);
        if (this.oYo != null) {
          com.tencent.mm.plugin.exdevice.model.ad.bZK().a(this.oYo);
        }
        super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
        paramq = (com.tencent.mm.plugin.exdevice.b.b)this.oYy.get();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.a.j
 * JD-Core Version:    0.7.0.1
 */