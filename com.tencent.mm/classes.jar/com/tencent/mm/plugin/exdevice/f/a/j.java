package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.f.b.f;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.protocal.c.alw;
import com.tencent.mm.protocal.c.alx;
import com.tencent.mm.protocal.c.cnr;
import com.tencent.mm.protocal.c.cns;
import com.tencent.mm.protocal.c.zh;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bd;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class j
  extends com.tencent.mm.plugin.exdevice.a.a<alw, alx>
{
  public String appName;
  public String jxR;
  public String jxS;
  public boolean jyb;
  public boolean jyc;
  public String jyd;
  public String jye;
  public com.tencent.mm.plugin.exdevice.f.b.a.a jyf;
  public ArrayList<com.tencent.mm.plugin.exdevice.f.b.a.d> jyg;
  public ArrayList<com.tencent.mm.plugin.exdevice.f.b.a.c> jyh;
  public ArrayList<com.tencent.mm.plugin.exdevice.f.b.a.e> jyi;
  public ArrayList<String> jyj;
  public String jyk;
  public String jyl;
  public boolean jym;
  public boolean jyn;
  public String jyo;
  private final WeakReference<com.tencent.mm.plugin.exdevice.a.b<j>> jyp;
  public a jyq;
  
  public j(String paramString1, String paramString2, String paramString3, boolean paramBoolean, com.tencent.mm.plugin.exdevice.a.b<j> paramb)
  {
    this.jyp = new WeakReference(paramb);
    this.jyk = paramString1;
    this.jyd = paramString1;
    this.appName = bk.pm(paramString2);
    this.jyc = paramBoolean;
    this.jye = paramString3;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneGetRankInfo", "hy: get rank info end. errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    alx localalx;
    Object localObject1;
    Object localObject3;
    Object localObject4;
    String str1;
    String str2;
    Object localObject2;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      localalx = (alx)auJ();
      localObject1 = "";
      this.jyh = new ArrayList();
      if (localalx.svE != null)
      {
        localObject3 = localalx.svE.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (zh)((Iterator)localObject3).next();
          au.Hx();
          if (com.tencent.mm.model.c.Fw().abg(((zh)localObject4).username))
          {
            str1 = localalx.dRj;
            str2 = this.appName;
            if ((bk.bl(str1)) || (localObject4 == null))
            {
              y.w("MicroMsg.ExdeviceRankConverter", "hy: param error");
              localObject2 = null;
            }
            for (;;)
            {
              if (localObject2 == null) {
                break label220;
              }
              this.jyh.add(localObject2);
              break;
              localObject2 = new com.tencent.mm.plugin.exdevice.f.b.a.c();
              ((com.tencent.mm.plugin.exdevice.f.b.a.c)localObject2).field_rankID = str1;
              ((com.tencent.mm.plugin.exdevice.f.b.a.c)localObject2).field_username = ((zh)localObject4).username;
              ((com.tencent.mm.plugin.exdevice.f.b.a.c)localObject2).field_step = ((zh)localObject4).ghE;
              ((com.tencent.mm.plugin.exdevice.f.b.a.c)localObject2).field_appusername = str2;
            }
          }
          else
          {
            label220:
            au.Dk().a(new h(((zh)localObject4).username, null), 0);
          }
        }
      }
      this.jyg = new ArrayList();
      localObject2 = localObject1;
      if (localalx.thV != null)
      {
        localObject3 = localalx.thV.iterator();
        localObject2 = localObject1;
        if (((Iterator)localObject3).hasNext())
        {
          localObject4 = (cnr)((Iterator)localObject3).next();
          str1 = localalx.dRj;
          str2 = this.appName;
          if ((bk.bl(str1)) || (localObject4 == null))
          {
            y.w("MicroMsg.ExdeviceRankConverter", "hy: param error");
            localObject2 = null;
            label341:
            if (localObject2 == null) {
              break label449;
            }
            if (((com.tencent.mm.plugin.exdevice.f.b.a.d)localObject2).field_ranknum != 1) {
              break label1223;
            }
            localObject1 = ((com.tencent.mm.plugin.exdevice.f.b.a.d)localObject2).field_username;
          }
        }
      }
    }
    label449:
    label1217:
    label1223:
    for (;;)
    {
      this.jyg.add(localObject2);
      break;
      localObject2 = new com.tencent.mm.plugin.exdevice.f.b.a.d();
      ((com.tencent.mm.plugin.exdevice.f.b.a.d)localObject2).field_appusername = str2;
      ((com.tencent.mm.plugin.exdevice.f.b.a.d)localObject2).field_rankID = str1;
      ((com.tencent.mm.plugin.exdevice.f.b.a.d)localObject2).field_likecount = ((cnr)localObject4).uap;
      ((com.tencent.mm.plugin.exdevice.f.b.a.d)localObject2).field_ranknum = ((cnr)localObject4).uao;
      ((com.tencent.mm.plugin.exdevice.f.b.a.d)localObject2).field_score = ((cnr)localObject4).score;
      ((com.tencent.mm.plugin.exdevice.f.b.a.d)localObject2).field_selfLikeState = ((cnr)localObject4).uaq;
      ((com.tencent.mm.plugin.exdevice.f.b.a.d)localObject2).field_username = ((cnr)localObject4).username;
      break label341;
      break;
      this.jyi = new ArrayList();
      if (localalx.thW != null)
      {
        localObject3 = localalx.thW.iterator();
        label600:
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (cns)((Iterator)localObject3).next();
          str1 = localalx.dRj;
          str2 = this.appName;
          if ((bk.bl(str1)) || (localObject4 == null))
          {
            y.w("MicroMsg.ExdeviceRankConverter", "hy: param error");
            localObject1 = null;
          }
          for (;;)
          {
            if (localObject1 == null) {
              break label600;
            }
            this.jyi.add(localObject1);
            break;
            localObject1 = new com.tencent.mm.plugin.exdevice.f.b.a.e();
            ((com.tencent.mm.plugin.exdevice.f.b.a.e)localObject1).field_appusername = str2;
            ((com.tencent.mm.plugin.exdevice.f.b.a.e)localObject1).field_rankID = str1;
            ((com.tencent.mm.plugin.exdevice.f.b.a.e)localObject1).field_timestamp = ((cns)localObject4).timestamp;
            ((com.tencent.mm.plugin.exdevice.f.b.a.e)localObject1).field_username = ((cns)localObject4).username;
          }
        }
      }
      this.jyj = new ArrayList();
      if (localalx.thO != null)
      {
        localObject1 = localalx.thO.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (String)((Iterator)localObject1).next();
          this.jyj.add(localObject3);
        }
      }
      if (!bk.bl(this.jye)) {
        localObject2 = this.jye;
      }
      localObject3 = localalx.thX;
      localObject4 = localalx.thY;
      boolean bool;
      int i;
      int j;
      if (bk.bl((String)localObject2))
      {
        y.w("MicroMsg.ExdeviceRankConverter", "hy: param error");
        localObject1 = null;
        this.jyf = ((com.tencent.mm.plugin.exdevice.f.b.a.a)localObject1);
        this.jyk = localalx.dRj;
        this.jxS = localalx.thQ;
        this.jxR = localalx.thP;
        this.jyl = localalx.thZ;
        this.jym = localalx.jym;
        if (localalx.tic != 1) {
          break label1147;
        }
        bool = true;
        this.jyn = bool;
        this.jyo = localalx.tie;
        this.jyb = localalx.thS;
        y.d("MicroMsg.NetSceneGetRankInfo", "hy: get score info ok.");
        if ((this.jyd == null) || (!this.jyd.equals(this.jyk)))
        {
          localObject1 = ad.aLT().jyx;
          if (localObject1 != null) {
            ((f)localObject1).Bz(this.jyk);
          }
        }
        if ((this.jyq != null) && (this.jyc)) {
          this.jyq.a(this);
        }
        if (this.jyc) {
          ad.aLN().be(this.jyh);
        }
        localObject1 = ad.aLM();
        localObject2 = this.jyk;
        if (!bk.bl((String)localObject2)) {
          break label1153;
        }
        y.w("MicroMsg.ExdeviceRankInfoStg", "delete rankInfo by rankId failed, rankId is null or nil.");
        ad.aLM().e(this.jyk, this.jyg);
        bool = this.jym;
        if (this.jyh == null) {
          break label1205;
        }
        i = this.jyh.size();
        if (this.jyg == null) {
          break label1211;
        }
        j = this.jyg.size();
        label975:
        if (this.jyi == null) {
          break label1217;
        }
      }
      for (int k = this.jyi.size();; k = 0)
      {
        y.i("MicroMsg.NetSceneGetRankInfo", "isCacheExist(%s), RankFollowInfo size(%s), RankInfo size(%d), LikeInfo size(%d).", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
        ad.aLQ().a(this.jyk, this.appName, this.jyi);
        if (this.jyf != null) {
          ad.aLP().a(this.jyf);
        }
        super.a(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
        paramq = (com.tencent.mm.plugin.exdevice.a.b)this.jyp.get();
        if (paramq != null) {
          paramq.a(paramInt2, paramInt3, paramString, this);
        }
        return;
        localObject1 = new com.tencent.mm.plugin.exdevice.f.b.a.a();
        ((com.tencent.mm.plugin.exdevice.f.b.a.a)localObject1).field_username = ((String)localObject2);
        ((com.tencent.mm.plugin.exdevice.f.b.a.a)localObject1).field_championUrl = ((String)localObject3);
        ((com.tencent.mm.plugin.exdevice.f.b.a.a)localObject1).field_championMotto = ((String)localObject4);
        break;
        label1147:
        bool = false;
        break label777;
        y.i("MicroMsg.ExdeviceRankInfoStg", "delete rankInfo by rankId (%s).(r : %d)", new Object[] { localObject2, Integer.valueOf(((com.tencent.mm.plugin.exdevice.f.b.b.d)localObject1).dXw.delete("HardDeviceRankInfo", "rankID = ? ", new String[] { localObject2 })) });
        break label923;
        i = 0;
        break label959;
        j = 0;
        break label975;
      }
    }
  }
  
  public final int getType()
  {
    return 1042;
  }
  
  protected final String getUri()
  {
    return "/cgi-bin/mmbiz-bin/rank/getuserranklike";
  }
  
  public static abstract interface a
  {
    public abstract void a(j paramj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.a.j
 * JD-Core Version:    0.7.0.1
 */