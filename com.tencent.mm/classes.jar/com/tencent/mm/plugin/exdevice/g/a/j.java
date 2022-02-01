package com.tencent.mm.plugin.exdevice.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.exdevice.g.b.f;
import com.tencent.mm.plugin.exdevice.model.ah;
import com.tencent.mm.protocal.protobuf.bzo;
import com.tencent.mm.protocal.protobuf.cva;
import com.tencent.mm.protocal.protobuf.cvb;
import com.tencent.mm.protocal.protobuf.gnv;
import com.tencent.mm.protocal.protobuf.gnw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.bx;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class j
  extends com.tencent.mm.plugin.exdevice.b.a<cva, cvb>
{
  public String appName;
  public String svG;
  public String ytZ;
  public boolean yui;
  public boolean yuj;
  public String yuk;
  public String yul;
  public com.tencent.mm.plugin.exdevice.g.b.a.a yum;
  public ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.d> yun;
  public ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.c> yuo;
  public ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.e> yup;
  public ArrayList<String> yuq;
  public String yur;
  public String yus;
  public boolean yut;
  public boolean yuu;
  public String yuv;
  private final WeakReference<com.tencent.mm.plugin.exdevice.b.b<j>> yuw;
  public a yux;
  
  public j(String paramString1, String paramString2, String paramString3, boolean paramBoolean, com.tencent.mm.plugin.exdevice.b.b<j> paramb)
  {
    AppMethodBeat.i(23526);
    this.yuw = new WeakReference(paramb);
    this.yur = paramString1;
    this.yuk = paramString1;
    this.appName = Util.nullAsNil(paramString2);
    this.yuj = paramBoolean;
    this.yul = paramString3;
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23527);
    Log.d("MicroMsg.NetSceneGetRankInfo", "hy: get rank info end. errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    cvb localcvb;
    Object localObject1;
    Object localObject3;
    Object localObject4;
    String str1;
    String str2;
    Object localObject2;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      localcvb = (cvb)cWm();
      localObject1 = "";
      this.yuo = new ArrayList();
      if (localcvb.YFB != null)
      {
        localObject3 = localcvb.YFB.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (bzo)((Iterator)localObject3).next();
          bh.bCz();
          if (com.tencent.mm.model.c.bzA().bxr(((bzo)localObject4).username))
          {
            str1 = localcvb.nRL;
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
              this.yuo.add(localObject2);
              break;
              localObject2 = new com.tencent.mm.plugin.exdevice.g.b.a.c();
              ((com.tencent.mm.plugin.exdevice.g.b.a.c)localObject2).field_rankID = str1;
              ((com.tencent.mm.plugin.exdevice.g.b.a.c)localObject2).field_username = ((bzo)localObject4).username;
              ((com.tencent.mm.plugin.exdevice.g.b.a.c)localObject2).field_step = ((bzo)localObject4).rBp;
              ((com.tencent.mm.plugin.exdevice.g.b.a.c)localObject2).field_appusername = str2;
            }
          }
          else
          {
            label226:
            bh.aZW().a(new h(((bzo)localObject4).username, null), 0);
          }
        }
      }
      this.yun = new ArrayList();
      localObject2 = localObject1;
      if (localcvb.aaAF != null)
      {
        localObject3 = localcvb.aaAF.iterator();
        localObject2 = localObject1;
        if (((Iterator)localObject3).hasNext())
        {
          localObject4 = (gnv)((Iterator)localObject3).next();
          str1 = localcvb.nRL;
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
      this.yun.add(localObject2);
      break;
      localObject2 = new com.tencent.mm.plugin.exdevice.g.b.a.d();
      ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2).field_appusername = str2;
      ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2).field_rankID = str1;
      ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2).field_likecount = ((gnv)localObject4).ZqA;
      ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2).field_ranknum = ((gnv)localObject4).aciM;
      ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2).field_score = ((gnv)localObject4).score;
      ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2).field_selfLikeState = ((gnv)localObject4).aciN;
      ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2).field_username = ((gnv)localObject4).username;
      ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2).field_sportRecord = ((gnv)localObject4).aciO;
      break label347;
      break;
      this.yup = new ArrayList();
      if (localcvb.aaAG != null)
      {
        localObject3 = localcvb.aaAG.iterator();
        label616:
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (gnw)((Iterator)localObject3).next();
          str1 = localcvb.nRL;
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
            this.yup.add(localObject1);
            break;
            localObject1 = new com.tencent.mm.plugin.exdevice.g.b.a.e();
            ((com.tencent.mm.plugin.exdevice.g.b.a.e)localObject1).field_appusername = str2;
            ((com.tencent.mm.plugin.exdevice.g.b.a.e)localObject1).field_rankID = str1;
            ((com.tencent.mm.plugin.exdevice.g.b.a.e)localObject1).field_timestamp = ((gnw)localObject4).fZW;
            ((com.tencent.mm.plugin.exdevice.g.b.a.e)localObject1).field_username = ((gnw)localObject4).username;
          }
        }
      }
      this.yuq = new ArrayList();
      if (localcvb.aaAw != null)
      {
        localObject1 = localcvb.aaAw.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (String)((Iterator)localObject1).next();
          this.yuq.add(localObject3);
        }
      }
      if (!Util.isNullOrNil(this.yul)) {
        localObject2 = this.yul;
      }
      localObject3 = localcvb.aaAH;
      localObject4 = localcvb.aaAI;
      boolean bool;
      int i;
      int j;
      if (Util.isNullOrNil((String)localObject2))
      {
        Log.w("MicroMsg.ExdeviceRankConverter", "hy: param error");
        localObject1 = null;
        this.yum = ((com.tencent.mm.plugin.exdevice.g.b.a.a)localObject1);
        this.yur = localcvb.nRL;
        this.svG = localcvb.aaAy;
        this.ytZ = localcvb.aaAx;
        this.yus = localcvb.aaAJ;
        this.yut = localcvb.yut;
        if (localcvb.aaAM != 1) {
          break label1169;
        }
        bool = true;
        this.yuu = bool;
        this.yuv = localcvb.aaAN;
        this.yui = localcvb.aaAA;
        Log.d("MicroMsg.NetSceneGetRankInfo", "hy: get score info ok.");
        if ((this.yuk == null) || (!this.yuk.equals(this.yur)))
        {
          localObject1 = ah.dFZ().yuG;
          if (localObject1 != null) {
            ((f)localObject1).apB(this.yur);
          }
        }
        if ((this.yux != null) && (this.yuj)) {
          this.yux.a(this);
        }
        if (this.yuj) {
          ah.dFT().fl(this.yuo);
        }
        localObject1 = ah.dFS();
        localObject2 = this.yur;
        if (!Util.isNullOrNil((String)localObject2)) {
          break label1175;
        }
        Log.w("MicroMsg.ExdeviceRankInfoStg", "delete rankInfo by rankId failed, rankId is null or nil.");
        ah.dFS().g(this.yur, this.yun);
        bool = this.yut;
        if (this.yuo == null) {
          break label1227;
        }
        i = this.yuo.size();
        if (this.yun == null) {
          break label1233;
        }
        j = this.yun.size();
        label991:
        if (this.yup == null) {
          break label1239;
        }
      }
      for (int k = this.yup.size();; k = 0)
      {
        Log.i("MicroMsg.NetSceneGetRankInfo", "isCacheExist(%s), RankFollowInfo size(%s), RankInfo size(%d), LikeInfo size(%d).", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
        ah.dFW().a(this.yur, this.appName, this.yup);
        if (this.yum != null) {
          ah.dFV().a(this.yum);
        }
        super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, params, paramArrayOfByte);
        params = (com.tencent.mm.plugin.exdevice.b.b)this.yuw.get();
        if (params != null) {
          params.onNetSceneEndCallback(paramInt2, paramInt3, paramString, this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.a.j
 * JD-Core Version:    0.7.0.1
 */