package com.tencent.mm.live.core.core;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.b.a.a;
import com.tencent.mm.live.core.core.c.b.a;
import com.tencent.mm.live.core.core.model.g;
import com.tencent.mm.live.core.core.model.j;
import com.tencent.mm.protocal.protobuf.diw;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.rtmp.TXLivePlayConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.k.k;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/core/core/LiveCdnPlayerManager;", "", "()V", "CACHE_STRATEGY_AUTO", "", "CACHE_STRATEGY_FAST", "CACHE_STRATEGY_SMOOTH", "CACHE_TIME_FAST", "", "CACHE_TIME_SMOOTH", "LAG_QUEUE_MAX_COUNT", "QUALITY_MAX_SWITCH_CNT", "QUALITY_OBSERVE_INTERVAL", "", "TAG", "", "bUseTXLivePlayerCustomRender", "cdnH265BackCfg", "cdnSwitchCnt", "debugEraseLiveDecryptBeforePlay", "", "getDebugEraseLiveDecryptBeforePlay", "()Z", "setDebugEraseLiveDecryptBeforePlay", "(Z)V", "enableP2P", "lagHistoryQueue", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "lastCdnQuality", "lastTime", "lastTimeDown", "lastTimeUp", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "mCacheStrategy", "mCustomRenderInfo", "mPlayConfig", "Lcom/tencent/rtmp/TXLivePlayConfig;", "mReTryBackupUrlCnt", "preLiveIDCdnQuality", "switchStreamCallback", "Lcom/tencent/mm/live/core/core/visitor/ILiveSwitchStreamCallback;", "txLivePlayer", "Lcom/tencent/mm/live/core/core/player/ILivePlayer;", "upTimePenalty", "vcodec2DecSupport", "checkRendererSharpenLocalConfig", "checkStartPlayState", "countLag", "", "curCdnLiveUrlInfo", "Lcom/tencent/mm/live/core/core/model/LiveUrlInfo;", "curCdnUrl", "curLiveRoomInfo", "customerSwitchCdnStream", "liveUrlInfo", "directGetTXLivePlayer", "getCacheStrategy", "getCdnH265BackCfg", "getCdnQualitySvrcfg", "getPreLiveIDStreamQuality", "getRetryCount", "getStreamIDByStreamUrl", "strStreamUrl", "getStreamQuality", "getTXLivePlayer", "context", "Landroid/content/Context;", "playListener", "Lcom/tencent/rtmp/ITXLivePlayListener;", "outterConfig", "vrLive", "getVcodec2DecSupport", "isPlaying", "isPlayingH265", "mute", "onNetStatus", "params", "Landroid/os/Bundle;", "onResetP2pStat", "pausePlay", "resetRetryCount", "resumePlay", "retryPlayBackupUrl", "setCacheStrategy", "cacheStrategy", "setCustomerSwitchCfg", "setMute", "setPlayerView", "glRootView", "Lcom/tencent/rtmp/ui/TXCloudVideoView;", "setPreLiveIDStreamQuality", "streamQuality", "setRenderMode", "mode", "setRenderRotation", "rotation", "setTXLivePlayer", "livePlayer", "setupLiveRoomInfo", "startPlay", "streamType", "playerView", "Lcom/tencent/mm/live/core/view/LiveVideoView;", "playCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "stopPlay", "keepLastFrame", "switchCdnStream", "cdnUrl", "tryPlayHttpsUrl", "tryRestartPlay", "updateLiveRoomInfo", "isChargeLive", "updatePlayerConfig", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public final String TAG;
  private final int mJA;
  private final float mJB;
  private final float mJC;
  public final int mJD;
  private final long mJE;
  private final int mJF;
  public com.tencent.mm.live.core.core.c.b mJG;
  public g mJH;
  private long mJI;
  private int mJJ;
  public int mJK;
  public int mJL;
  public ArrayList<Long> mJM;
  private long mJN;
  private long mJO;
  private long mJP;
  private int mJQ;
  public int mJR;
  public TXLivePlayConfig mJS;
  public int mJT;
  public int mJU;
  public com.tencent.mm.live.core.core.f.b mJV;
  public int mJW;
  public int mJX;
  public boolean mJY;
  private boolean mJZ;
  private final int mJy;
  private final int mJz;
  
  public d()
  {
    AppMethodBeat.i(247899);
    this.TAG = "MicroMsg.LiveCdnPlayerManager";
    this.mJy = 1;
    this.mJz = 2;
    this.mJA = 3;
    e.c localc = e.c.mKi;
    this.mJB = e.c.bcv();
    localc = e.c.mKi;
    this.mJC = e.c.bcw();
    this.mJD = 100;
    this.mJE = 10000L;
    this.mJF = 5;
    this.mJK = a.mJp.value;
    this.mJL = a.mJp.value;
    this.mJM = new ArrayList(this.mJD);
    this.mJP = (this.mJE * 5L);
    this.mJQ = this.mJA;
    this.mJS = new TXLivePlayConfig();
    this.mJZ = true;
    AppMethodBeat.o(247899);
  }
  
  private static final void a(d paramd, diw paramdiw, String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(247924);
    Object localObject = paramd.mJG;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.c.b)localObject).fD(false);
    }
    localObject = paramd.mJG;
    if (localObject != null)
    {
      com.tencent.mm.live.core.d.a locala = com.tencent.mm.live.core.d.a.mWH;
      b.a.a((com.tencent.mm.live.core.core.c.b)localObject, com.tencent.mm.live.core.d.a.a(paramdiw, paramString1));
    }
    paramdiw = paramd.mJG;
    if (paramdiw != null) {
      paramdiw.Y(paramString1, 1);
    }
    paramd.mJK = paramInt;
    localObject = paramd.TAG;
    paramString2 = new StringBuilder("switchCdnStream ").append(paramString2).append(" startPlay done, liveId:");
    paramdiw = paramd.mJH;
    if (paramdiw == null) {}
    for (paramdiw = null;; paramdiw = Long.valueOf(paramdiw.liveId))
    {
      Log.i((String)localObject, paramdiw + ',' + paramd.mJG + ", url:" + paramString1);
      AppMethodBeat.o(247924);
      return;
    }
  }
  
  private static final void a(d paramd, diw paramdiw, String paramString1, String paramString2, int paramInt)
  {
    boolean bool1 = true;
    Object localObject2 = null;
    int j = 0;
    AppMethodBeat.i(247934);
    int i;
    if ((paramdiw != null) && (paramdiw.aaOn > 0))
    {
      localObject1 = (CharSequence)paramdiw.aaOo;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
      {
        i = 1;
        if (i == 0) {
          break label170;
        }
      }
    }
    else
    {
      paramString1 = paramd.TAG;
      paramString2 = new StringBuilder("switchCdnStream don't need to re decrpyt player, mode:");
      if (paramdiw != null) {
        break label145;
      }
      paramd = null;
      label80:
      paramString2 = paramString2.append(paramd).append(", key is null:");
      if (paramdiw != null) {
        break label156;
      }
      paramd = null;
      label98:
      paramd = (CharSequence)paramd;
      if ((paramd != null) && (paramd.length() != 0)) {
        break label164;
      }
    }
    label145:
    label156:
    label164:
    for (bool1 = true;; bool1 = false)
    {
      Log.i(paramString1, bool1);
      AppMethodBeat.o(247934);
      return;
      i = 0;
      break;
      paramd = Integer.valueOf(paramdiw.aaOn);
      break label80;
      paramd = paramdiw.aaOo;
      break label98;
    }
    label170:
    Object localObject1 = com.tencent.mm.live.core.d.a.mWH;
    localObject1 = paramString1;
    if (paramString1 == null) {
      localObject1 = "";
    }
    label221:
    label231:
    boolean bool2;
    if (com.tencent.mm.live.core.d.a.Gd((String)localObject1))
    {
      paramString1 = com.tencent.mm.live.core.d.a.mWH;
      if (!com.tencent.mm.live.core.d.a.Gd(paramString2))
      {
        paramString1 = com.tencent.mm.live.core.core.model.b.mMD;
        paramString1 = paramd.mJG;
        if (paramString1 != null) {
          break label361;
        }
        paramString1 = null;
        if (paramString1 == null) {
          break label371;
        }
        i = paramString1.hashCode();
        bool2 = com.tencent.mm.live.core.core.model.b.sN(i);
        paramString1 = com.tencent.mm.live.core.core.model.b.mMD;
        paramString1 = paramd.mJG;
        if (paramString1 != null) {
          break label377;
        }
      }
    }
    label361:
    label371:
    label377:
    for (paramString1 = localObject2;; paramString1 = paramString1.getPlayer())
    {
      i = j;
      if (paramString1 != null) {
        i = paramString1.hashCode();
      }
      boolean bool3 = com.tencent.mm.live.core.core.model.b.sO(i);
      Log.i(paramd.TAG, "switchCdnStream try to re decrpyt player,forceReDecrypt:" + bool1 + ", playerHaveDecrypted:" + bool2 + ",playerHavePlay:" + bool3);
      if ((bool1) || ((!bool2) && (!bool3))) {
        a(paramd, paramdiw, paramString2, paramInt, "(tryToReDecrypt)");
      }
      AppMethodBeat.o(247934);
      return;
      bool1 = false;
      break;
      paramString1 = paramString1.getPlayer();
      break label221;
      i = 0;
      break label231;
    }
  }
  
  public static String getStreamIDByStreamUrl(String paramString)
  {
    AppMethodBeat.i(247909);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(247909);
      return null;
    }
    s.checkNotNull(paramString);
    i = n.a((CharSequence)paramString, "?", 0, false, 6);
    if (i != -1)
    {
      localObject = paramString.substring(0, i);
      s.s(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    }
    for (;;)
    {
      paramString = (CharSequence)localObject;
      if ((paramString == null) || (paramString.length() == 0)) {}
      for (i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(247909);
        return null;
      }
      s.checkNotNull(localObject);
      i = n.g((CharSequence)localObject, "/");
      int j = ((String)localObject).length();
      paramString = (String)localObject;
      if (i != -1)
      {
        paramString = (String)localObject;
        if (i + 1 <= j)
        {
          paramString = ((String)localObject).substring(i + 1);
          s.s(paramString, "(this as java.lang.String).substring(startIndex)");
        }
      }
      localObject = (CharSequence)paramString;
      if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
      for (i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(247909);
        return null;
      }
      s.checkNotNull(paramString);
      i = n.a((CharSequence)paramString, ".", 0, false, 6);
      localObject = paramString;
      if (i != -1)
      {
        localObject = paramString.substring(0, i);
        s.s(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      }
      paramString = (CharSequence)localObject;
      if ((paramString == null) || (paramString.length() == 0)) {}
      for (i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(247909);
        return null;
      }
      AppMethodBeat.o(247909);
      return localObject;
      localObject = paramString;
    }
  }
  
  public final void FL(String paramString)
  {
    int n = -1;
    Object localObject3 = null;
    Object localObject2 = null;
    int i1 = 1;
    int m = 0;
    int k = 0;
    AppMethodBeat.i(247958);
    Object localObject1 = this.mJH;
    int j;
    label85:
    Object localObject4;
    boolean bool;
    if (localObject1 == null)
    {
      j = 0;
      Log.i(this.TAG, "switchCdnStream to " + paramString + ", indexOfUrl:" + j);
      localObject1 = this.mJH;
      if (localObject1 != null) {
        break label321;
      }
      localObject1 = null;
      if (!Util.isEqual((String)localObject1, paramString)) {
        break label351;
      }
      localObject3 = this.TAG;
      localObject4 = (CharSequence)paramString;
      if ((localObject4 != null) && (((CharSequence)localObject4).length() != 0)) {
        break label335;
      }
      bool = true;
      label124:
      Log.w((String)localObject3, s.X("switchCdnStream fail: curCdnUrl == cdnUrl,cdnUrl is empty:", Boolean.valueOf(bool)));
      localObject3 = (CharSequence)paramString;
      if (localObject3 != null)
      {
        i = k;
        if (((CharSequence)localObject3).length() != 0) {}
      }
      else
      {
        i = 1;
      }
      if (i == 0)
      {
        localObject3 = this.mJH;
        if (localObject3 != null) {
          break label341;
        }
      }
    }
    for (;;)
    {
      a(this, (diw)localObject2, (String)localObject1, paramString, j);
      AppMethodBeat.o(247958);
      return;
      localObject1 = ((g)localObject1).mNt.values();
      s.s(localObject1, "cdnUrlMap.values");
      localObject1 = ((Iterable)localObject1).iterator();
      i = 0;
      label230:
      if (((Iterator)localObject1).hasNext())
      {
        localObject4 = ((Iterator)localObject1).next();
        if (i < 0) {
          p.kkW();
        }
        if (!s.p(((j)localObject4).url, paramString)) {}
      }
      for (;;)
      {
        Log.i("LiveRoomInfo", "indexOfUrl " + paramString + ", index:" + i);
        j = i;
        break;
        i += 1;
        break label230;
        i = -1;
      }
      label321:
      localObject1 = ((g)localObject1).sP(this.mJK);
      break label85;
      label335:
      bool = false;
      break label124;
      label341:
      localObject2 = ((g)localObject3).mNv;
    }
    label351:
    localObject2 = (CharSequence)paramString;
    if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.w(this.TAG, "switchCdnStream fail: cdnUrl is nullornil");
      AppMethodBeat.o(247958);
      return;
    }
    if (this.mJG == null)
    {
      Log.w(this.TAG, "switchCdnStream fail: txLivePlayer == null");
      AppMethodBeat.o(247958);
      return;
    }
    localObject2 = this.mJG;
    Object localObject5;
    if ((localObject2 != null) && (((com.tencent.mm.live.core.core.c.b)localObject2).isPlaying() == true))
    {
      k = 1;
      i = i1;
      if (k != 0)
      {
        localObject4 = getStreamIDByStreamUrl((String)localObject1);
        localObject2 = getStreamIDByStreamUrl(paramString);
        localObject5 = (CharSequence)localObject4;
        if ((localObject5 != null) && (((CharSequence)localObject5).length() != 0)) {
          break label651;
        }
        k = 1;
        label495:
        i = i1;
        if (k == 0)
        {
          localObject5 = (CharSequence)localObject2;
          if ((localObject5 != null) && (((CharSequence)localObject5).length() != 0)) {
            break label657;
          }
          k = 1;
          label528:
          i = i1;
          if (k == 0)
          {
            if (!Util.isEqual((String)localObject2, (String)localObject4)) {
              break label673;
            }
            Log.i(this.TAG, "1.switchCdnStream same streamid, skip switching! old:" + localObject4 + ", new:" + localObject2);
            localObject2 = this.mJH;
            if (localObject2 != null) {
              break label663;
            }
          }
        }
      }
    }
    label651:
    label657:
    label663:
    for (localObject2 = null;; localObject2 = ((g)localObject2).mNv)
    {
      a(this, (diw)localObject2, (String)localObject1, paramString, j);
      i = 0;
      if (i != 0)
      {
        localObject1 = this.mJH;
        if (localObject1 != null) {
          break label1066;
        }
        localObject1 = localObject3;
        label627:
        a(this, (diw)localObject1, paramString, j, "");
      }
      AppMethodBeat.o(247958);
      return;
      k = 0;
      break;
      k = 0;
      break label495;
      k = 0;
      break label528;
    }
    label673:
    if ((n.i((CharSequence)localObject4, (CharSequence)localObject2)) || (n.i((CharSequence)localObject2, (CharSequence)localObject4)))
    {
      Log.i(this.TAG, "2.switchCdnStream streamid substring,directly try switching! old:" + localObject4 + ", new:" + localObject2);
      localObject1 = localObject2;
      i = 1;
    }
    for (;;)
    {
      label747:
      if (i == 0)
      {
        localObject5 = (CharSequence)localObject1;
        if ((localObject5 != null) && (((CharSequence)localObject5).length() != 0)) {
          break label1011;
        }
        k = 1;
        i = i1;
        if (k != 0) {
          break;
        }
        i = i1;
        if (!n.i((CharSequence)localObject4, (CharSequence)localObject1)) {
          break;
        }
      }
      label776:
      localObject5 = this.mJG;
      if (localObject5 != null)
      {
        localObject1 = com.tencent.mm.live.core.d.a.mWH;
        localObject1 = this.mJH;
        if (localObject1 == null)
        {
          localObject1 = null;
          label833:
          b.a.a((com.tencent.mm.live.core.core.c.b)localObject5, com.tencent.mm.live.core.d.a.a((diw)localObject1, paramString));
        }
      }
      else
      {
        localObject1 = this.mJG;
        if (localObject1 != null) {
          break label1027;
        }
        localObject1 = null;
        label858:
        localObject5 = this.mJV;
        if (localObject5 != null)
        {
          if (localObject1 != null) {
            break label1043;
          }
          i = n;
          label877:
          ((com.tencent.mm.live.core.core.f.b)localObject5).ay(paramString, i);
        }
        if (localObject1 != null) {
          break label1052;
        }
      }
      label1027:
      label1043:
      label1052:
      for (;;)
      {
        i = 1;
        label1011:
        do
        {
          this.mJK = j;
          Log.i(this.TAG, "3. switchCdnStream switchStream ret:" + localObject1 + ", streamId change: " + localObject4 + " --> " + localObject2);
          break;
          i = n.g((CharSequence)localObject2, "_");
          if (i == -1) {
            break label1076;
          }
          if (localObject2 == null)
          {
            paramString = new NullPointerException("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(247958);
            throw paramString;
          }
          localObject1 = ((String)localObject2).substring(0, i);
          s.s(localObject1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
          i = 0;
          break label747;
          k = 0;
          break label776;
          localObject1 = ((g)localObject1).mNv;
          break label833;
          localObject1 = Integer.valueOf(((com.tencent.mm.live.core.core.c.b)localObject1).switchStream(paramString));
          break label858;
          i = ((Integer)localObject1).intValue();
          break label877;
          i = m;
        } while (((Integer)localObject1).intValue() == 0);
      }
      label1066:
      localObject1 = ((g)localObject1).mNv;
      break label627;
      label1076:
      localObject1 = localObject2;
      i = 0;
    }
  }
  
  public final void a(g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(247976);
    if (paramg == null)
    {
      Log.i(this.TAG, "updateLiveRoomInfo fail liveRoomInfo is null!");
      AppMethodBeat.o(247976);
      return;
    }
    int i;
    if ((paramg.bel()) && (!paramBoolean))
    {
      i = paramg.sS(paramg.mNs);
      Log.i(this.TAG, "updateLiveRoomInfo isChargeLive:" + paramBoolean + ", use cdnCustomerSwitchCfg:" + paramg.mNs + ",index:" + i);
    }
    for (;;)
    {
      this.mJU = paramg.mJU;
      j = paramg.mNt.size();
      if (i < j) {
        break;
      }
      Log.i(this.TAG, "updateLiveRoomInfo fail,newCdnQuality:" + i + ", cdnUrlSize:" + j + '!');
      AppMethodBeat.o(247976);
      return;
      Log.i(this.TAG, "updateLiveRoomInfo isChargeLive:" + paramBoolean + ", cdnCustomerSwitchCfg:" + paramg.mNs + " invalid");
      paramg.mNs = -1;
      i = paramg.mNr;
    }
    Object localObject2 = paramg.sP(i);
    Object localObject1 = (CharSequence)localObject2;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int j = 1; j != 0; j = 0)
    {
      Log.w(this.TAG, "updateLiveRoomInfo fail: newSwitchUrl is nullornil");
      AppMethodBeat.o(247976);
      return;
    }
    localObject1 = this.mJH;
    com.tencent.mm.live.core.core.b.a locala;
    Context localContext;
    label437:
    label451:
    int k;
    label465:
    int m;
    label479:
    int n;
    label493:
    int i1;
    label507:
    int i2;
    label521:
    int i3;
    label535:
    label551:
    label567:
    Object localObject3;
    if (localObject1 == null)
    {
      localObject1 = null;
      FL((String)localObject2);
      paramg.mNw = this.mJW;
      paramg.mNx = this.mJX;
      this.mJH = paramg;
      this.mJK = i;
      if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.DEBUG)) {
        Log.i(this.TAG, "updateLiveRoomInfo oriSwitchUrl:" + localObject1 + " ,newSwitchUrl:" + localObject2);
      }
      bco();
      localObject1 = com.tencent.mm.live.core.core.b.a.mOr;
      a.a.beC();
      if (com.tencent.mm.live.core.core.b.a.bez())
      {
        localObject1 = com.tencent.mm.live.core.core.b.a.mOr;
        locala = a.a.beC();
        localContext = MMApplicationContext.getContext();
        s.s(localContext, "getContext()");
        localObject1 = paramg.mNv;
        if (localObject1 != null) {
          break label646;
        }
        i = 0;
        localObject1 = paramg.mNv;
        if (localObject1 != null) {
          break label655;
        }
        j = 0;
        localObject1 = paramg.mNv;
        if (localObject1 != null) {
          break label665;
        }
        k = 0;
        localObject1 = paramg.mNv;
        if (localObject1 != null) {
          break label675;
        }
        m = 0;
        localObject1 = paramg.mNv;
        if (localObject1 != null) {
          break label685;
        }
        n = 0;
        localObject1 = paramg.mNv;
        if (localObject1 != null) {
          break label695;
        }
        i1 = 0;
        localObject1 = paramg.mNv;
        if (localObject1 != null) {
          break label705;
        }
        i2 = 0;
        localObject1 = paramg.mNv;
        if (localObject1 != null) {
          break label715;
        }
        i3 = 0;
        localObject1 = paramg.mNv;
        if (localObject1 != null) {
          break label725;
        }
        localObject1 = "";
        localObject2 = paramg.mNv;
        if (localObject2 != null) {
          break label749;
        }
        localObject2 = "";
        localObject3 = paramg.mNv;
        if (localObject3 != null) {
          break label773;
        }
        localObject3 = "";
        label583:
        paramg = paramg.mNv;
        if (paramg != null) {
          break label797;
        }
      }
    }
    label646:
    label655:
    label665:
    label797:
    for (int i4 = 0;; i4 = paramg.aaOk)
    {
      locala.a(localContext, i, j, k, m, n, i1, i2, i3, (String)localObject1, (String)localObject2, (String)localObject3, i4);
      AppMethodBeat.o(247976);
      return;
      localObject1 = ((g)localObject1).sP(this.mJK);
      break;
      i = ((diw)localObject1).aaNY;
      break label437;
      j = ((diw)localObject1).aaNZ;
      break label451;
      k = ((diw)localObject1).aaOa;
      break label465;
      label675:
      m = ((diw)localObject1).aaOb;
      break label479;
      label685:
      n = ((diw)localObject1).aaOc;
      break label493;
      label695:
      i1 = ((diw)localObject1).aaOd;
      break label507;
      label705:
      i2 = ((diw)localObject1).aaOe;
      break label521;
      label715:
      i3 = ((diw)localObject1).aaOf;
      break label535;
      label725:
      localObject2 = ((diw)localObject1).aaOg;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label551;
      }
      localObject1 = "";
      break label551;
      label749:
      localObject3 = ((diw)localObject2).aaOh;
      localObject2 = localObject3;
      if (localObject3 != null) {
        break label567;
      }
      localObject2 = "";
      break label567;
      String str = ((diw)localObject3).aaOi;
      localObject3 = str;
      if (str != null) {
        break label583;
      }
      localObject3 = "";
      break label583;
    }
  }
  
  public final void bck()
  {
    AppMethodBeat.i(247983);
    Log.i(this.TAG, "pausePlay");
    com.tencent.mm.live.core.core.c.b localb = this.mJG;
    if (localb != null) {
      localb.pause();
    }
    AppMethodBeat.o(247983);
  }
  
  public final void bcl()
  {
    AppMethodBeat.i(247989);
    Log.i(this.TAG, "resumePlay");
    com.tencent.mm.live.core.core.c.b localb = this.mJG;
    if (localb != null) {
      localb.resume();
    }
    AppMethodBeat.o(247989);
  }
  
  public final void bcm()
  {
    AppMethodBeat.i(248023);
    Object localObject = this.mJH;
    int i;
    label30:
    label56:
    int j;
    int k;
    long l;
    if (localObject == null)
    {
      localObject = null;
      if (localObject != com.tencent.mm.live.core.core.model.a.mMA) {
        break label156;
      }
      i = 1;
      if (i == 0) {
        break label419;
      }
      localObject = this.mJH;
      if ((localObject == null) || (((g)localObject).bel() != true)) {
        break label161;
      }
      i = 1;
      if (i != 0) {
        break label419;
      }
      j = 0;
      i = 0;
      k = this.mJK;
      l = System.currentTimeMillis();
      if (l - this.mJI <= this.mJE) {
        break label166;
      }
      localObject = ((Iterable)this.mJM).iterator();
      label103:
      j = i;
      if (!((Iterator)localObject).hasNext()) {
        break label166;
      }
      if (l - ((Number)((Iterator)localObject).next()).longValue() > this.mJE) {
        break label607;
      }
      i += 1;
    }
    label156:
    label161:
    label166:
    label319:
    label591:
    label602:
    label607:
    for (;;)
    {
      break label103;
      localObject = ((g)localObject).mNq;
      break;
      i = 0;
      break label30;
      i = 0;
      break label56;
      if ((j == 0) && (l - this.mJI > this.mJE + this.mJP))
      {
        if (this.mJK == a.mJp.value) {
          break label513;
        }
        if ((this.mJK == a.mJq.value) || (this.mJK == a.mJr.value)) {
          i = a.mJp.value;
        }
      }
      for (;;)
      {
        if ((i != this.mJK) && (this.mJJ < this.mJF))
        {
          if (i <= this.mJK) {
            break label521;
          }
          this.mJO = l;
          if ((this.mJO <= this.mJN) || (this.mJO - this.mJN >= this.mJE * 2L)) {
            break label538;
          }
          this.mJP += this.mJE * 6L;
          Log.i(this.TAG, "onNetStatus quality change: %d --> %d, duration:%d, upPenalty:%d, switchCnt:%d", new Object[] { Integer.valueOf(this.mJK), Integer.valueOf(i), Long.valueOf(l - this.mJI), Long.valueOf(this.mJP), Integer.valueOf(this.mJJ) });
          this.mJI = l;
          this.mJJ += 1;
          localObject = this.mJH;
          if (localObject != null) {
            break label591;
          }
        }
        for (localObject = null;; localObject = ((g)localObject).sP(i))
        {
          FL((String)localObject);
          AppMethodBeat.o(248023);
          return;
          if (this.mJK != a.mJs.value) {
            break label602;
          }
          i = a.mJq.value;
          break;
          if (j < 3) {
            break label602;
          }
          if (this.mJK == a.mJp.value)
          {
            i = a.mJq.value;
            break;
          }
          if ((this.mJK == a.mJq.value) || (this.mJK == a.mJr.value))
          {
            i = a.mJs.value;
            break;
          }
          i = this.mJK;
          break;
          if (i >= this.mJK) {
            break label269;
          }
          this.mJN = l;
          break label269;
          if ((this.mJN <= this.mJO) || (this.mJN - this.mJI <= this.mJE * 6L)) {
            break label319;
          }
          this.mJP = k.bR(this.mJP - this.mJE, 0L);
          break label319;
        }
        i = k;
      }
    }
  }
  
  public final void bcn()
  {
    Object localObject2 = null;
    AppMethodBeat.i(248029);
    Object localObject1 = this.mJH;
    if (localObject1 == null) {}
    for (localObject1 = null; localObject1 == null; localObject1 = Integer.valueOf(((g)localObject1).mJU))
    {
      Log.i(this.TAG, "play fail! backup is null");
      AppMethodBeat.o(248029);
      return;
    }
    Log.i(this.TAG, "play fail! try backup url, quality change: %d --> %d, switchCnt:%d", new Object[] { Integer.valueOf(this.mJK), localObject1, Integer.valueOf(this.mJJ) });
    g localg = this.mJH;
    if (localg == null) {}
    for (localObject1 = localObject2;; localObject1 = localg.sP(((Integer)localObject1).intValue()))
    {
      FL((String)localObject1);
      this.mJJ += 1;
      this.mJR += 1;
      AppMethodBeat.o(248029);
      return;
    }
  }
  
  public final void bco()
  {
    Object localObject2 = null;
    AppMethodBeat.i(248039);
    float f3 = this.mJB;
    float f4 = this.mJC;
    Object localObject1 = this.mJH;
    int i;
    float f2;
    float f1;
    if (localObject1 == null)
    {
      i = 0;
      f2 = f4;
      f1 = f3;
      if (i > 0)
      {
        localObject1 = this.mJH;
        if (localObject1 != null) {
          break label327;
        }
        i = 0;
        label58:
        f2 = f4;
        f1 = f3;
        if (i > 0)
        {
          localObject1 = this.mJH;
          if (localObject1 != null) {
            break label355;
          }
          localObject1 = null;
          label82:
          s.checkNotNull(localObject1);
          f1 = ((Integer)localObject1).intValue() / 1000.0F;
          localObject1 = this.mJH;
          if (localObject1 != null) {
            break label386;
          }
          localObject1 = localObject2;
        }
      }
    }
    for (;;)
    {
      s.checkNotNull(localObject1);
      f2 = ((Integer)localObject1).intValue() / 1000.0F;
      Log.i(this.TAG, "get cgi params type:" + this.mJQ + ", minCache:" + f1 + ", maxCache:" + f2);
      Log.i(this.TAG, "updatePlayerConfig type:" + this.mJQ + ", minCache:" + f1 + ", maxCache:" + f2);
      i = this.mJQ;
      if (i != this.mJy) {
        break label415;
      }
      this.mJS.setAutoAdjustCacheTime(true);
      this.mJS.setMaxAutoAdjustCacheTime(f1);
      this.mJS.setMinAutoAdjustCacheTime(f1);
      this.mJS.setCacheTime(f1);
      localObject1 = this.mJG;
      if (localObject1 == null) {
        break label548;
      }
      ((com.tencent.mm.live.core.core.c.b)localObject1).setConfig(this.mJS);
      AppMethodBeat.o(248039);
      return;
      localObject1 = ((g)localObject1).mNv;
      if (localObject1 == null)
      {
        i = 0;
        break;
      }
      i = ((diw)localObject1).aaNT;
      break;
      label327:
      localObject1 = ((g)localObject1).mNv;
      if (localObject1 == null)
      {
        i = 0;
        break label58;
      }
      i = ((diw)localObject1).aaNU;
      break label58;
      label355:
      localObject1 = ((g)localObject1).mNv;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label82;
      }
      localObject1 = Integer.valueOf(((diw)localObject1).aaNT);
      break label82;
      label386:
      diw localdiw = ((g)localObject1).mNv;
      localObject1 = localObject2;
      if (localdiw != null) {
        localObject1 = Integer.valueOf(localdiw.aaNU);
      }
    }
    label415:
    if (i == this.mJz)
    {
      this.mJS.setAutoAdjustCacheTime(false);
      this.mJS.setMaxAutoAdjustCacheTime(f2);
      this.mJS.setMinAutoAdjustCacheTime(f2);
      this.mJS.setCacheTime(f1);
      localObject1 = this.mJG;
      if (localObject1 != null)
      {
        ((com.tencent.mm.live.core.core.c.b)localObject1).setConfig(this.mJS);
        AppMethodBeat.o(248039);
      }
    }
    else if (i == this.mJA)
    {
      this.mJS.setAutoAdjustCacheTime(true);
      this.mJS.setMaxAutoAdjustCacheTime(f2);
      this.mJS.setMinAutoAdjustCacheTime(f1);
      this.mJS.setCacheTime(f1);
      localObject1 = this.mJG;
      if (localObject1 != null) {
        ((com.tencent.mm.live.core.core.c.b)localObject1).setConfig(this.mJS);
      }
    }
    label548:
    AppMethodBeat.o(248039);
  }
  
  public final void bcp()
  {
    AppMethodBeat.i(248045);
    com.tencent.mm.live.core.core.c.b localb = this.mJG;
    if (localb != null) {
      localb.setMute(true);
    }
    AppMethodBeat.o(248045);
  }
  
  public final void fD(boolean paramBoolean)
  {
    AppMethodBeat.i(247996);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("stopPlay liveId:");
    Object localObject = this.mJH;
    if (localObject == null) {}
    for (localObject = null;; localObject = Long.valueOf(((g)localObject).liveId))
    {
      Log.i(str, localObject + ",player:" + this.mJG + ',');
      if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.DEBUG)) {
        Log.i(this.TAG, s.X("stopPlay stack:", Util.getStack()));
      }
      localObject = this.mJG;
      if (localObject != null) {
        ((com.tencent.mm.live.core.core.c.b)localObject).fD(paramBoolean);
      }
      localObject = this.mJG;
      if (localObject != null) {
        ((com.tencent.mm.live.core.core.c.b)localObject).setPlayListener(null);
      }
      this.mJG = null;
      this.mJI = 0L;
      this.mJJ = 0;
      this.mJM.clear();
      this.mJN = 0L;
      this.mJO = 0L;
      this.mJP = (this.mJE * 5L);
      AppMethodBeat.o(247996);
      return;
    }
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(247999);
    com.tencent.mm.live.core.core.c.b localb = this.mJG;
    if (localb == null)
    {
      AppMethodBeat.o(247999);
      return false;
    }
    boolean bool = localb.isPlaying();
    AppMethodBeat.o(247999);
    return bool;
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(248005);
    com.tencent.mm.live.core.core.c.b localb = this.mJG;
    if (localb != null) {
      localb.setMute(paramBoolean);
    }
    AppMethodBeat.o(248005);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.live.core.core.d
 * JD-Core Version:    0.7.0.1
 */