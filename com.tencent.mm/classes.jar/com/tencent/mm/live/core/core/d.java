package com.tencent.mm.live.core.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.model.f;
import com.tencent.mm.protocal.protobuf.crv;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.rtmp.TXLivePlayConfig;
import com.tencent.rtmp.TXLivePlayer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.k.i;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/core/core/LiveCdnPlayerManager;", "", "()V", "CACHE_STRATEGY_AUTO", "", "CACHE_STRATEGY_FAST", "CACHE_STRATEGY_SMOOTH", "CACHE_TIME_FAST", "", "CACHE_TIME_SMOOTH", "LAG_QUEUE_MAX_COUNT", "QUALITY_MAX_SWITCH_CNT", "QUALITY_OBSERVE_INTERVAL", "", "TAG", "", "cdnH265BackCfg", "cdnQualitySvrcfg", "cdnSwitchCnt", "lagHistoryQueue", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "lastCdnQuality", "lastTime", "lastTimeDown", "lastTimeUp", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "mCacheStrategy", "mPlayConfig", "Lcom/tencent/rtmp/TXLivePlayConfig;", "mReTryBackupUrlCnt", "preLiveIDCdnQuality", "txLivePlayer", "Lcom/tencent/rtmp/TXLivePlayer;", "upTimePenalty", "vcodec2DecSupport", "countLag", "", "curCdnUrl", "getCacheStrategy", "getCdnH265BackCfg", "getCdnQualitySvrcfg", "getPreLiveIDStreamQuality", "getRetryCount", "getStreamIDByStreamUrl", "strStreamUrl", "getStreamQuality", "getTXLivePlayer", "context", "Landroid/content/Context;", "playListener", "Lcom/tencent/rtmp/ITXLivePlayListener;", "outterConfig", "getVcodec2DecSupport", "isPlaying", "", "isPlayingH265", "onNetStatus", "params", "Landroid/os/Bundle;", "pausePlay", "resetRetryCount", "resumePlay", "retryPlayBackupUrl", "setCacheStrategy", "cacheStrategy", "setPreLiveIDStreamQuality", "streamQuality", "setupLiveRoomInfo", "startPlay", "streamType", "playerView", "Lcom/tencent/mm/live/core/view/LiveVideoView;", "playCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "stopPlay", "keepLastFrame", "switchCdnStream", "cdnUrl", "tryRestartPlay", "updateLiveRoomInfo", "updatePlayerConfig", "plugin-core_release"})
public final class d
{
  public final String TAG;
  private final int kiU;
  private final int kiV;
  private final int kiW;
  private final float kiX;
  private final float kiY;
  public final int kiZ;
  private final long kja;
  private final int kjb;
  public TXLivePlayer kjc;
  public f kjd;
  private long kje;
  private int kjf;
  public int kjg;
  public int kjh;
  public ArrayList<Long> kji;
  private long kjj;
  private long kjk;
  private long kjl;
  private int kjm;
  public int kjn;
  public TXLivePlayConfig kjo;
  public int kjp;
  public int kjq;
  public int kjr;
  
  public d()
  {
    AppMethodBeat.i(199321);
    this.TAG = "MicroMsg.LiveCdnPlayerManager";
    this.kiU = 1;
    this.kiV = 2;
    this.kiW = 3;
    e.c localc = e.c.kjA;
    this.kiX = e.c.aJL();
    localc = e.c.kjA;
    this.kiY = e.c.aJM();
    this.kiZ = 100;
    this.kja = 10000L;
    this.kjb = 5;
    this.kjg = a.kiL.value;
    this.kjh = a.kiL.value;
    this.kji = new ArrayList(this.kiZ);
    this.kjl = (this.kja * 5L);
    this.kjm = this.kiW;
    this.kjo = new TXLivePlayConfig();
    AppMethodBeat.o(199321);
  }
  
  private static String getStreamIDByStreamUrl(String paramString)
  {
    AppMethodBeat.i(199279);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(199279);
      return null;
    }
    if (paramString == null) {
      p.iCn();
    }
    i = n.a((CharSequence)paramString, "?", 0, false, 6);
    if (i != -1)
    {
      localObject = paramString.substring(0, i);
      p.j(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    }
    for (;;)
    {
      paramString = (CharSequence)localObject;
      if ((paramString == null) || (paramString.length() == 0)) {}
      for (i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(199279);
        return null;
      }
      if (localObject == null) {
        p.iCn();
      }
      i = n.g((CharSequence)localObject, "/");
      int j = ((String)localObject).length();
      paramString = (String)localObject;
      if (i != -1)
      {
        paramString = (String)localObject;
        if (i + 1 <= j)
        {
          paramString = ((String)localObject).substring(i + 1);
          p.j(paramString, "(this as java.lang.String).substring(startIndex)");
        }
      }
      localObject = (CharSequence)paramString;
      if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
      for (i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(199279);
        return null;
      }
      if (paramString == null) {
        p.iCn();
      }
      i = n.a((CharSequence)paramString, ".", 0, false, 6);
      localObject = paramString;
      if (i != -1)
      {
        localObject = paramString.substring(0, i);
        p.j(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      }
      paramString = (CharSequence)localObject;
      if ((paramString == null) || (paramString.length() == 0)) {}
      for (i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(199279);
        return null;
      }
      AppMethodBeat.o(199279);
      return localObject;
      localObject = paramString;
    }
  }
  
  public final void Ns(String paramString)
  {
    Object localObject3 = null;
    AppMethodBeat.i(199291);
    Object localObject1 = this.kjd;
    int j;
    if (localObject1 != null)
    {
      localObject1 = ((f)localObject1).kmm.values();
      p.j(localObject1, "cdnUrlMap.values");
      j = j.b((Iterable)localObject1, paramString);
      Log.i("LiveRoomInfo", "indexOfUrl " + paramString + ", index:" + j);
      Log.i(this.TAG, "switchCdnStream to " + paramString + ", indexOfUrl:" + j);
      localObject1 = this.kjd;
      if (localObject1 == null) {
        break label166;
      }
    }
    label166:
    for (localObject1 = ((f)localObject1).sS(this.kjg);; localObject1 = null)
    {
      if (!Util.isEqual((String)localObject1, paramString)) {
        break label172;
      }
      Log.w(this.TAG, "switchCdnStream fail: curCdnUrl == cdnUrl");
      AppMethodBeat.o(199291);
      return;
      j = 0;
      break;
    }
    label172:
    Object localObject2 = (CharSequence)paramString;
    if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.w(this.TAG, "switchCdnStream fail: cdnUrl is nullornil");
      AppMethodBeat.o(199291);
      return;
    }
    if (this.kjc == null)
    {
      Log.w(this.TAG, "switchCdnStream fail: txLivePlayer == null");
      AppMethodBeat.o(199291);
      return;
    }
    localObject2 = this.kjc;
    Object localObject4;
    if (localObject2 != null)
    {
      if (((TXLivePlayer)localObject2).isPlaying() != true) {
        break label818;
      }
      localObject4 = getStreamIDByStreamUrl((String)localObject1);
      localObject2 = getStreamIDByStreamUrl(paramString);
      localObject1 = (CharSequence)localObject4;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label517;
      }
      i = 1;
      if (i != 0) {
        break label818;
      }
      localObject1 = (CharSequence)localObject2;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label522;
      }
      i = 1;
    }
    Object localObject5;
    for (;;)
    {
      if (i == 0)
      {
        if (Util.isEqual((String)localObject2, (String)localObject4))
        {
          Log.i(this.TAG, "1.switchCdnStream same streamid, skip switching! old:" + (String)localObject4 + ", new:" + (String)localObject2);
          for (i = 0;; i = 1)
          {
            if (i != 0)
            {
              localObject1 = this.kjc;
              if (localObject1 != null) {
                ((TXLivePlayer)localObject1).stopPlay(false);
              }
              localObject1 = this.kjc;
              if (localObject1 != null) {
                ((TXLivePlayer)localObject1).startPlay(paramString, 1);
              }
              this.kjg = j;
              localObject2 = this.TAG;
              localObject4 = new StringBuilder("switchCdnStream startPlay done, liveId:");
              localObject5 = this.kjd;
              localObject1 = localObject3;
              if (localObject5 != null) {
                localObject1 = Long.valueOf(((f)localObject5).liveId);
              }
              Log.i((String)localObject2, localObject1 + ',' + this.kjc + ", url:" + paramString);
            }
            AppMethodBeat.o(199291);
            return;
          }
          label517:
          i = 0;
          break;
          label522:
          i = 0;
          continue;
        }
        if ((n.g((CharSequence)localObject4, (CharSequence)localObject2)) || (n.g((CharSequence)localObject2, (CharSequence)localObject4)))
        {
          Log.i(this.TAG, "2.switchCdnStream streamid substring,directly try switching! old:" + (String)localObject4 + ", new:" + (String)localObject2);
          i = 1;
          localObject1 = localObject2;
        }
      }
    }
    for (;;)
    {
      label601:
      if (i == 0)
      {
        localObject5 = (CharSequence)localObject1;
        if ((localObject5 == null) || (((CharSequence)localObject5).length() == 0))
        {
          i = 1;
          label629:
          if ((i != 0) || (!n.g((CharSequence)localObject4, (CharSequence)localObject1))) {
            break label818;
          }
        }
      }
      else
      {
        localObject1 = this.kjc;
        if (localObject1 == null) {
          break label799;
        }
        localObject1 = Integer.valueOf(((TXLivePlayer)localObject1).switchStream(paramString));
        if (localObject1 != null) {
          break label805;
        }
      }
      label671:
      label676:
      for (i = 1;; i = 0)
      {
        this.kjg = j;
        Log.i(this.TAG, "3. switchCdnStream switchStream ret:" + localObject1 + ", streamId change: " + (String)localObject4 + " --> " + (String)localObject2);
        break;
        i = n.g((CharSequence)localObject2, "_");
        if (i == -1) {
          break label823;
        }
        if (localObject2 == null)
        {
          paramString = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(199291);
          throw paramString;
        }
        localObject1 = ((String)localObject2).substring(0, i);
        p.j(localObject1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        i = 0;
        break label601;
        i = 0;
        break label629;
        localObject1 = null;
        break label671;
        label805:
        if (((Integer)localObject1).intValue() != 0) {
          break label676;
        }
      }
      label799:
      label818:
      i = 1;
      break;
      label823:
      i = 0;
      localObject1 = localObject2;
    }
  }
  
  public final void aJD()
  {
    AppMethodBeat.i(199306);
    Object localObject = this.kjd;
    int i;
    label34:
    int j;
    int k;
    long l;
    if (localObject != null)
    {
      localObject = ((f)localObject).kml;
      if (localObject != com.tencent.mm.live.core.core.model.a.klA) {
        break label130;
      }
      i = 1;
      if (i == 0) {
        break label393;
      }
      j = 0;
      i = 0;
      k = this.kjg;
      l = System.currentTimeMillis();
      if (l - this.kje <= this.kja) {
        break label135;
      }
      localObject = ((Iterable)this.kji).iterator();
      label81:
      j = i;
      if (!((Iterator)localObject).hasNext()) {
        break label135;
      }
      if (l - ((Number)((Iterator)localObject).next()).longValue() > this.kja) {
        break label576;
      }
      i += 1;
    }
    label130:
    label135:
    label288:
    label565:
    label571:
    label576:
    for (;;)
    {
      break label81;
      localObject = null;
      break;
      i = 0;
      break label34;
      if ((j == 0) && (l - this.kje > this.kja + this.kjl))
      {
        if (this.kjg == a.kiL.value) {
          break label487;
        }
        if ((this.kjg == a.kiM.value) || (this.kjg == a.kiN.value)) {
          i = a.kiL.value;
        }
      }
      for (;;)
      {
        if ((i != this.kjg) && (this.kjf < this.kjb))
        {
          if (i <= this.kjg) {
            break label495;
          }
          this.kjk = l;
          label238:
          if ((this.kjk <= this.kjj) || (this.kjk - this.kjj >= this.kja * 2L)) {
            break label512;
          }
          this.kjl += this.kja * 6L;
          Log.i(this.TAG, "onNetStatus quality change: %d --> %d, duration:%d, upPenalty:%d, switchCnt:%d", new Object[] { Integer.valueOf(this.kjg), Integer.valueOf(i), Long.valueOf(l - this.kje), Long.valueOf(this.kjl), Integer.valueOf(this.kjf) });
          this.kje = l;
          this.kjf += 1;
          localObject = this.kjd;
          if (localObject == null) {
            break label565;
          }
        }
        for (localObject = ((f)localObject).sS(i);; localObject = null)
        {
          Ns((String)localObject);
          AppMethodBeat.o(199306);
          return;
          if (this.kjg != a.kiO.value) {
            break label571;
          }
          i = a.kiM.value;
          break;
          if (j < 3) {
            break label571;
          }
          if (this.kjg == a.kiL.value)
          {
            i = a.kiM.value;
            break;
          }
          if ((this.kjg == a.kiM.value) || (this.kjg == a.kiN.value))
          {
            i = a.kiO.value;
            break;
          }
          label487:
          i = this.kjg;
          break;
          label495:
          if (i >= this.kjg) {
            break label238;
          }
          this.kjj = l;
          break label238;
          if ((this.kjj <= this.kjk) || (this.kjj - this.kje <= this.kja * 6L)) {
            break label288;
          }
          this.kjl = i.be(this.kjl - this.kja, 0L);
          break label288;
        }
        i = k;
      }
    }
  }
  
  public final void aJE()
  {
    String str = null;
    AppMethodBeat.i(199310);
    Object localObject = this.kjd;
    if (localObject != null) {}
    for (localObject = Integer.valueOf(((f)localObject).kjr); localObject == null; localObject = null)
    {
      Log.i(this.TAG, "play fail! backup is null");
      AppMethodBeat.o(199310);
      return;
    }
    Log.i(this.TAG, "play fail! try backup url, quality change: %d --> %d, switchCnt:%d", new Object[] { Integer.valueOf(this.kjg), localObject, Integer.valueOf(this.kjf) });
    f localf = this.kjd;
    if (localf != null) {
      str = localf.sS(((Integer)localObject).intValue());
    }
    Ns(str);
    this.kjf += 1;
    this.kjn += 1;
    AppMethodBeat.o(199310);
  }
  
  public final void aJF()
  {
    AppMethodBeat.i(199317);
    float f3 = this.kiX;
    float f4 = this.kiY;
    Object localObject = this.kjd;
    int i;
    float f2;
    float f1;
    if (localObject != null)
    {
      localObject = ((f)localObject).kmo;
      if (localObject != null)
      {
        i = ((crv)localObject).Tze;
        f2 = f4;
        f1 = f3;
        if (i > 0)
        {
          localObject = this.kjd;
          if (localObject == null) {
            break label375;
          }
          localObject = ((f)localObject).kmo;
          if (localObject == null) {
            break label375;
          }
          i = ((crv)localObject).Tzf;
          label87:
          f2 = f4;
          f1 = f3;
          if (i > 0)
          {
            localObject = this.kjd;
            if (localObject == null) {
              break label381;
            }
            localObject = ((f)localObject).kmo;
            if (localObject == null) {
              break label381;
            }
            localObject = Integer.valueOf(((crv)localObject).Tze);
            label130:
            if (localObject == null) {
              p.iCn();
            }
            f1 = ((Integer)localObject).intValue() / 1000.0F;
            localObject = this.kjd;
            if (localObject == null) {
              break label387;
            }
            localObject = ((f)localObject).kmo;
            if (localObject == null) {
              break label387;
            }
          }
        }
      }
    }
    label387:
    for (localObject = Integer.valueOf(((crv)localObject).Tzf);; localObject = null)
    {
      if (localObject == null) {
        p.iCn();
      }
      f2 = ((Integer)localObject).intValue() / 1000.0F;
      Log.i(this.TAG, "get cgi params type:" + this.kjm + ", minCache:" + f1 + ", maxCache:" + f2);
      Log.i(this.TAG, "updatePlayerConfig type:" + this.kjm + ", minCache:" + f1 + ", maxCache:" + f2);
      i = this.kjm;
      if (i != this.kiU) {
        break label400;
      }
      this.kjo.setAutoAdjustCacheTime(true);
      this.kjo.setMaxAutoAdjustCacheTime(f1);
      this.kjo.setMinAutoAdjustCacheTime(f1);
      this.kjo.setCacheTime(f1);
      localObject = this.kjc;
      if (localObject == null) {
        break label393;
      }
      ((TXLivePlayer)localObject).setConfig(this.kjo);
      AppMethodBeat.o(199317);
      return;
      i = 0;
      break;
      label375:
      i = 0;
      break label87;
      label381:
      localObject = null;
      break label130;
    }
    label393:
    AppMethodBeat.o(199317);
    return;
    label400:
    if (i == this.kiV)
    {
      this.kjo.setAutoAdjustCacheTime(false);
      this.kjo.setMaxAutoAdjustCacheTime(f2);
      this.kjo.setMinAutoAdjustCacheTime(f2);
      this.kjo.setCacheTime(f1);
      localObject = this.kjc;
      if (localObject != null)
      {
        ((TXLivePlayer)localObject).setConfig(this.kjo);
        AppMethodBeat.o(199317);
        return;
      }
      AppMethodBeat.o(199317);
      return;
    }
    if (i == this.kiW)
    {
      this.kjo.setAutoAdjustCacheTime(true);
      this.kjo.setMaxAutoAdjustCacheTime(f2);
      this.kjo.setMinAutoAdjustCacheTime(f1);
      this.kjo.setCacheTime(f1);
      localObject = this.kjc;
      if (localObject != null)
      {
        ((TXLivePlayer)localObject).setConfig(this.kjo);
        AppMethodBeat.o(199317);
        return;
      }
    }
    AppMethodBeat.o(199317);
  }
  
  public final void eT(boolean paramBoolean)
  {
    AppMethodBeat.i(199294);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("stopPlay liveId:");
    Object localObject = this.kjd;
    if (localObject != null) {}
    for (localObject = Long.valueOf(((f)localObject).liveId);; localObject = null)
    {
      Log.i(str, localObject + ",player:" + this.kjc + ',');
      if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.DEBUG)) {
        Log.i(this.TAG, "stopPlay stack:" + Util.getStack());
      }
      localObject = this.kjc;
      if (localObject != null) {
        ((TXLivePlayer)localObject).stopPlay(paramBoolean);
      }
      localObject = this.kjc;
      if (localObject != null) {
        ((TXLivePlayer)localObject).setPlayListener(null);
      }
      this.kjc = null;
      this.kje = 0L;
      this.kjf = 0;
      this.kji.clear();
      this.kjj = 0L;
      this.kjk = 0L;
      this.kjl = (this.kja * 5L);
      AppMethodBeat.o(199294);
      return;
    }
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(199295);
    TXLivePlayer localTXLivePlayer = this.kjc;
    if (localTXLivePlayer != null)
    {
      boolean bool = localTXLivePlayer.isPlaying();
      AppMethodBeat.o(199295);
      return bool;
    }
    AppMethodBeat.o(199295);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.core.d
 * JD-Core Version:    0.7.0.1
 */