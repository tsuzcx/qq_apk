package com.tencent.mm.live.core.core;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.b.e;
import com.tencent.mm.live.core.view.LiveVideoView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayConfig;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/core/core/LiveCdnPlayerManager;", "", "()V", "CACHE_STRATEGY_AUTO", "", "CACHE_STRATEGY_FAST", "CACHE_STRATEGY_SMOOTH", "CACHE_TIME_FAST", "", "CACHE_TIME_SMOOTH", "LAG_QUEUE_MAX_COUNT", "QUALITY_MAX_SWITCH_CNT", "QUALITY_OBSERVE_INTERVAL", "", "TAG", "", "cdnSwitchCnt", "lagHistoryQueue", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "lastCdnQuality", "lastTime", "lastTimeDown", "lastTimeUp", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "mCacheStrategy", "txLivePlayer", "Lcom/tencent/rtmp/TXLivePlayer;", "upTimePenalty", "countLag", "", "curCdnUrl", "getCacheStrategy", "getTXLivePlayer", "context", "Landroid/content/Context;", "playListener", "Lcom/tencent/rtmp/ITXLivePlayListener;", "outterConfig", "Lcom/tencent/rtmp/TXLivePlayConfig;", "h265PlayErrProcess", "isPlaying", "", "isPlayingH265", "onNetStatus", "params", "Landroid/os/Bundle;", "setCacheStrategy", "cacheStrategy", "setupLiveRoomInfo", "startPlay", "streamType", "playerView", "Lcom/tencent/mm/live/core/view/LiveVideoView;", "playCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "stopPlay", "keepLastFrame", "switchCdnStream", "cdnUrl", "tryRestartPlay", "plugin-core_release"})
public final class d
{
  private static final String TAG = "MicroMsg.LiveCdnPlayerManager";
  private static final int hwG = 1;
  private static final int hwH = 2;
  private static final int hwI = 3;
  private static final float hwJ = 1.0F;
  private static final float hwK = 5.0F;
  private static final int hwL = 100;
  private static final long hwM = 10000L;
  private static final int hwN = 5;
  private static TXLivePlayer hwO;
  private static e hwP;
  private static long hwQ;
  private static int hwR;
  private static int hwS;
  private static ArrayList<Long> hwT;
  private static long hwU;
  private static long hwV;
  private static long hwW;
  private static int hwX;
  public static final d hwY;
  
  static
  {
    AppMethodBeat.i(196401);
    hwY = new d();
    TAG = "MicroMsg.LiveCdnPlayerManager";
    hwG = 1;
    hwH = 2;
    hwI = 3;
    hwJ = 1.0F;
    hwK = 5.0F;
    hwL = 100;
    hwM = 10000L;
    hwN = 5;
    hwS = a.hwx.value;
    hwT = new ArrayList(hwL);
    hwW = hwM * 5L;
    hwX = hwI;
    AppMethodBeat.o(196401);
  }
  
  public static void Gm(String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(196390);
    Object localObject1 = hwP;
    int i;
    if (localObject1 != null)
    {
      localObject1 = ((e)localObject1).hzs.values();
      p.g(localObject1, "cdnUrlMap.values");
      i = kotlin.a.j.b((Iterable)localObject1, paramString);
      Log.i("LiveRoomInfo", "indexOfUrl " + paramString + ", index:" + i);
      Log.i(TAG, "switchCdnStream to " + paramString + ", indexOfUrl:" + i);
      localObject1 = hwP;
      if (localObject1 == null) {
        break label143;
      }
    }
    label143:
    for (localObject1 = ((e)localObject1).qr(hwS);; localObject1 = null)
    {
      if (!Util.isEqual((String)localObject1, paramString)) {
        break label148;
      }
      Log.w(TAG, "switchCdnStream fail: curCdnUrl == cdnUrl");
      AppMethodBeat.o(196390);
      return;
      i = 0;
      break;
    }
    label148:
    localObject1 = (CharSequence)paramString;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int j = 1; j != 0; j = 0)
    {
      Log.w(TAG, "switchCdnStream fail: cdnUrl is nullornil");
      AppMethodBeat.o(196390);
      return;
    }
    if (hwO == null)
    {
      Log.w(TAG, "switchCdnStream fail: txLivePlayer == null");
      AppMethodBeat.o(196390);
      return;
    }
    hwS = i;
    TXLivePlayer localTXLivePlayer = hwO;
    localObject1 = localObject2;
    if (localTXLivePlayer != null) {
      localObject1 = Integer.valueOf(localTXLivePlayer.switchStream(paramString));
    }
    if (localObject1 == null) {}
    while (((Integer)localObject1).intValue() != 0)
    {
      Log.w(TAG, "switchCdnStream fail: ".concat(String.valueOf(localObject1)));
      localObject1 = hwO;
      if (localObject1 != null) {
        ((TXLivePlayer)localObject1).stopPlay(false);
      }
      localObject1 = hwO;
      if (localObject1 == null) {
        break;
      }
      ((TXLivePlayer)localObject1).startPlay(paramString, 1);
      AppMethodBeat.o(196390);
      return;
    }
    Log.i(TAG, "switchCdnStream ok");
    AppMethodBeat.o(196390);
    return;
    AppMethodBeat.o(196390);
  }
  
  public static TXLivePlayer a(Context paramContext, ITXLivePlayListener paramITXLivePlayListener, TXLivePlayConfig paramTXLivePlayConfig)
  {
    AppMethodBeat.i(196392);
    p.h(paramContext, "context");
    int i;
    if (hwO == null)
    {
      hwO = new TXLivePlayer(paramContext);
      paramContext = paramTXLivePlayConfig;
      if (paramTXLivePlayConfig == null) {
        paramContext = new TXLivePlayConfig();
      }
      i = hwX;
      if (i != hwG) {
        break label146;
      }
      paramContext.setAutoAdjustCacheTime(true);
      paramContext.setMaxAutoAdjustCacheTime(hwJ);
      paramContext.setMinAutoAdjustCacheTime(hwJ);
      paramContext.setCacheTime(hwJ);
    }
    for (;;)
    {
      paramTXLivePlayConfig = hwO;
      if (paramTXLivePlayConfig != null) {
        paramTXLivePlayConfig.setPlayListener(paramITXLivePlayListener);
      }
      paramITXLivePlayListener = hwO;
      if (paramITXLivePlayListener != null) {
        paramITXLivePlayListener.enableHardwareDecode(true);
      }
      paramITXLivePlayListener = hwO;
      if (paramITXLivePlayListener != null) {
        paramITXLivePlayListener.setConfig(paramContext);
      }
      paramContext = hwO;
      if (paramContext != null) {
        paramContext.setRenderMode(1);
      }
      paramContext = hwO;
      AppMethodBeat.o(196392);
      return paramContext;
      label146:
      if (i == hwH)
      {
        paramContext.setAutoAdjustCacheTime(false);
        paramContext.setMaxAutoAdjustCacheTime(hwK);
        paramContext.setMinAutoAdjustCacheTime(hwK);
        paramContext.setCacheTime(hwK);
      }
      else if (i == hwI)
      {
        paramContext.setAutoAdjustCacheTime(true);
        paramContext.setMaxAutoAdjustCacheTime(hwK);
        paramContext.setMinAutoAdjustCacheTime(hwJ);
        paramContext.setCacheTime(hwJ);
      }
    }
  }
  
  public static void a(int paramInt, LiveVideoView paramLiveVideoView, b<? super Boolean, x> paramb)
  {
    AppMethodBeat.i(196393);
    p.h(paramLiveVideoView, "playerView");
    Object localObject = hwP;
    if (localObject != null) {
      localObject = ((e)localObject).qr(hwS);
    }
    while ((localObject != null) && (hwO != null))
    {
      TXLivePlayer localTXLivePlayer = hwO;
      if ((localTXLivePlayer != null) && (!localTXLivePlayer.isPlaying()))
      {
        Log.i(TAG, "startPlay url:".concat(String.valueOf(localObject)));
        localTXLivePlayer = hwO;
        if (localTXLivePlayer != null) {
          localTXLivePlayer.setPlayerView((TXCloudVideoView)paramLiveVideoView);
        }
        paramLiveVideoView = hwO;
        if (paramLiveVideoView != null) {
          paramLiveVideoView.startPlay((String)localObject, paramInt);
        }
        paramb.invoke(Boolean.TRUE);
        AppMethodBeat.o(196393);
        return;
        localObject = null;
      }
      else
      {
        Log.i(TAG, "refresh palyView");
        localObject = hwO;
        if (localObject != null) {
          ((TXLivePlayer)localObject).setPlayerView((TXCloudVideoView)paramLiveVideoView);
        }
        paramb.invoke(Boolean.TRUE);
        AppMethodBeat.o(196393);
        return;
      }
    }
    paramb.invoke(Boolean.FALSE);
    AppMethodBeat.o(196393);
  }
  
  public static void a(e parame)
  {
    AppMethodBeat.i(196391);
    hwP = parame;
    hwS = a.hwx.value;
    if (parame != null) {}
    for (parame = Integer.valueOf(parame.hzq);; parame = null)
    {
      if (parame != null) {
        hwS = parame.intValue();
      }
      AppMethodBeat.o(196391);
      return;
    }
  }
  
  public static void aBZ()
  {
    Object localObject2 = null;
    AppMethodBeat.i(196396);
    Object localObject1 = hwP;
    int i;
    label36:
    int k;
    long l;
    label75:
    int j;
    if (localObject1 != null)
    {
      localObject1 = ((e)localObject1).hzp;
      if (localObject1 != com.tencent.mm.live.core.core.b.a.hyE) {
        break label122;
      }
      i = 1;
      if (i == 0) {
        break label358;
      }
      k = hwS;
      l = System.currentTimeMillis();
      if (l - hwQ <= hwM) {
        break label127;
      }
      localObject1 = ((Iterable)hwT).iterator();
      i = 0;
      j = i;
      if (!((Iterator)localObject1).hasNext()) {
        break label129;
      }
      if (l - ((Number)((Iterator)localObject1).next()).longValue() > hwM) {
        break label519;
      }
      i += 1;
    }
    label129:
    label514:
    label519:
    for (;;)
    {
      break label75;
      localObject1 = null;
      break;
      label122:
      i = 0;
      break label36;
      label127:
      j = 0;
      if ((j == 0) && (l - hwQ > hwM + hwW))
      {
        if (hwS == a.hwx.value) {
          break label448;
        }
        if ((hwS == a.hwy.value) || (hwS == a.hwz.value)) {
          i = a.hwx.value;
        }
      }
      for (;;)
      {
        if ((i != hwS) && (hwR < hwN))
        {
          if (i <= hwS) {
            break label455;
          }
          hwV = l;
          label219:
          if ((hwV <= hwU) || (hwV - hwU >= hwM * 2L)) {
            break label469;
          }
        }
        label448:
        label455:
        label469:
        for (hwW += hwM * 6L;; hwW = kotlin.k.j.aM(hwW - hwM, 0L)) {
          label358:
          do
          {
            Log.i(TAG, "onNetStatus quality change: %d --> %d, duration:%d, upPenalty:%d, switchCnt:%d", new Object[] { Integer.valueOf(hwS), Integer.valueOf(i), Long.valueOf(l - hwQ), Long.valueOf(hwW), Integer.valueOf(hwR) });
            hwQ = l;
            hwR += 1;
            e locale = hwP;
            localObject1 = localObject2;
            if (locale != null) {
              localObject1 = locale.qr(i);
            }
            Gm((String)localObject1);
            AppMethodBeat.o(196396);
            return;
            if (hwS != a.hwA.value) {
              break label514;
            }
            i = a.hwy.value;
            break;
            if (j < 3) {
              break label514;
            }
            if (hwS == a.hwx.value)
            {
              i = a.hwy.value;
              break;
            }
            if ((hwS == a.hwy.value) || (hwS == a.hwz.value))
            {
              i = a.hwA.value;
              break;
            }
            i = hwS;
            break;
            if (i >= hwS) {
              break label219;
            }
            hwU = l;
            break label219;
          } while ((hwU <= hwV) || (hwU - hwQ <= hwM * 6L));
        }
        i = k;
      }
    }
  }
  
  public static void aCa()
  {
    AppMethodBeat.i(196397);
    hwT.add(Long.valueOf(System.currentTimeMillis()));
    if (hwT.size() > hwL) {
      hwT.remove(0);
    }
    AppMethodBeat.o(196397);
  }
  
  public static void aCb()
  {
    String str = null;
    AppMethodBeat.i(196398);
    Object localObject = hwP;
    if (localObject != null) {}
    for (localObject = Integer.valueOf(((e)localObject).hzr); localObject == null; localObject = null)
    {
      Log.i(TAG, "H265 play fail! cdnH265BackCfg is null");
      AppMethodBeat.o(196398);
      return;
    }
    Log.i(TAG, "H265 play fail! quality change: %d --> %d, switchCnt:%d", new Object[] { Integer.valueOf(hwS), localObject, Integer.valueOf(hwR) });
    e locale = hwP;
    if (locale != null) {
      str = locale.qr(((Integer)localObject).intValue());
    }
    Gm(str);
    hwR += 1;
    AppMethodBeat.o(196398);
  }
  
  public static boolean aCc()
  {
    return hwS == a.hwC.value;
  }
  
  public static String aCd()
  {
    AppMethodBeat.i(196400);
    Object localObject = hwP;
    if (localObject != null)
    {
      String str = ((e)localObject).qr(hwS);
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    AppMethodBeat.o(196400);
    return localObject;
  }
  
  public static void ev(boolean paramBoolean)
  {
    AppMethodBeat.i(196394);
    Log.i(TAG, "stopPlay");
    TXLivePlayer localTXLivePlayer = hwO;
    if (localTXLivePlayer != null) {
      localTXLivePlayer.stopPlay(paramBoolean);
    }
    localTXLivePlayer = hwO;
    if (localTXLivePlayer != null) {
      localTXLivePlayer.setPlayListener(null);
    }
    hwO = null;
    hwQ = 0L;
    hwR = 0;
    hwT.clear();
    hwU = 0L;
    hwV = 0L;
    hwW = hwM * 5L;
    AppMethodBeat.o(196394);
  }
  
  public static boolean isPlaying()
  {
    AppMethodBeat.i(196395);
    TXLivePlayer localTXLivePlayer = hwO;
    if (localTXLivePlayer != null)
    {
      boolean bool = localTXLivePlayer.isPlaying();
      AppMethodBeat.o(196395);
      return bool;
    }
    AppMethodBeat.o(196395);
    return false;
  }
  
  public static void qq(int paramInt)
  {
    AppMethodBeat.i(196399);
    Object localObject1 = hwP;
    Object localObject2;
    int i;
    if (localObject1 != null)
    {
      localObject1 = ((e)localObject1).qr(hwS);
      localObject2 = (CharSequence)localObject1;
      if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
        break label87;
      }
      i = 1;
    }
    for (;;)
    {
      if (i == 0)
      {
        localObject2 = hwO;
        if (localObject2 != null) {
          ((TXLivePlayer)localObject2).stopPlay(false);
        }
        localObject2 = hwO;
        if (localObject2 != null)
        {
          ((TXLivePlayer)localObject2).startPlay((String)localObject1, paramInt);
          AppMethodBeat.o(196399);
          return;
          localObject1 = null;
          break;
          label87:
          i = 0;
          continue;
        }
        AppMethodBeat.o(196399);
        return;
      }
    }
    Log.w(TAG, "tryRestartPlay fail: url is nullornil");
    AppMethodBeat.o(196399);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.core.core.d
 * JD-Core Version:    0.7.0.1
 */