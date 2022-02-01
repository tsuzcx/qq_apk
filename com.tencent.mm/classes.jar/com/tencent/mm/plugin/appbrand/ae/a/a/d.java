package com.tencent.mm.plugin.appbrand.ae.a.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.thumbplayer.api.ITPPlayer;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPDownLoadProgressInfo;
import com.tencent.thumbplayer.api.TPVideoInfo.Builder;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import java.util.HashMap;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/video/player/thumb/WebViewThumbMediaPlayer;", "Lcom/tencent/mm/plugin/appbrand/video/player/thumb/ThumbMediaPlayer;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "MTAG", "", "setNewData", "", "getSetNewData", "()Z", "setSetNewData", "(Z)V", "hitVideoPreloadReport", "", "extraInfo", "onTTPlayerInfoUpdate", "player", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "what", "", "arg1", "", "arg2", "extraObject", "", "setDataSource", "path", "referrer", "plugin-compat_release"})
public final class d
  extends a
{
  private final String rkn;
  private boolean rko;
  
  public d(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(207716);
    this.rkn = "MicroMsg.WebViewThumbMediaPlayer";
    AppMethodBeat.o(207716);
  }
  
  public final void a(ITPPlayer paramITPPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    AppMethodBeat.i(207715);
    p.k(paramITPPlayer, "player");
    Log.d(this.rkn, "onTTPlayerInfoUpdate：what:" + paramInt + "  arg1: " + paramLong1 + ", arg2: " + paramLong2 + ", extraObject: " + paramObject);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(207715);
      return;
    }
    do
    {
      try
      {
        Log.i(this.rkn, "TP_PLAYER_INFO_LONG1_ADAPTIVE_SWITCH_DEF_END：arg1: " + paramLong1 + ", arg2: " + paramLong2 + ", extraObject: " + paramObject);
        ajn(String.valueOf(paramLong1));
        AppMethodBeat.o(207715);
        return;
      }
      catch (Exception paramITPPlayer)
      {
        Log.printErrStackTrace("MicroMsg.SameLayer.BaseMediaPlayer", (Throwable)paramITPPlayer, "", new Object[0]);
        AppMethodBeat.o(207715);
        return;
      }
    } while ((paramObject == null) || (!(paramObject instanceof TPPlayerMsg.TPDownLoadProgressInfo)));
    paramITPPlayer = ((TPPlayerMsg.TPDownLoadProgressInfo)paramObject).extraInfo;
    for (;;)
    {
      try
      {
        if (this.rko)
        {
          this.rko = false;
          if (paramITPPlayer != null)
          {
            paramITPPlayer = new JSONObject(paramITPPlayer).opt("hitDownloaded");
            if ((paramITPPlayer != null) && ((paramITPPlayer instanceof Integer)))
            {
              if (!p.h(paramITPPlayer, Integer.valueOf(1))) {
                continue;
              }
              iH(true);
            }
          }
        }
      }
      catch (Exception paramITPPlayer)
      {
        Log.printErrStackTrace(this.rkn, (Throwable)paramITPPlayer, "", new Object[0]);
        continue;
      }
      Log.d(this.rkn, "extraObject.extraInfo: " + ((TPPlayerMsg.TPDownLoadProgressInfo)paramObject).extraInfo);
      AppMethodBeat.o(207715);
      return;
      iH(false);
    }
  }
  
  public final void ef(String paramString1, String paramString2)
  {
    AppMethodBeat.i(207713);
    p.k(paramString1, "path");
    ITPPlayer localITPPlayer = this.rjW;
    a locala = (a)this;
    Object localObject = x.aazN;
    if (locala.cmo()) {}
    for (;;)
    {
      try
      {
        Log.d(locala.bqj, "setDataSource");
        localObject = c.rkl;
        localObject = c.anp(paramString1);
        Log.d(this.rkn, "setDataSource, path: " + paramString1 + ", fileId:" + (String)localObject + ' ');
        this.rko = true;
        localITPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(102, 1000L).buildLong(504, 1L));
        localObject = new TPVideoInfo.Builder().fileId((String)localObject);
        TPDownloadParamData localTPDownloadParamData = new TPDownloadParamData(0);
        HashMap localHashMap = new HashMap();
        CharSequence localCharSequence = (CharSequence)paramString2;
        if (localCharSequence == null) {
          break label335;
        }
        if (localCharSequence.length() == 0)
        {
          break label335;
          if (i == 0) {
            localHashMap.put("Referrer", paramString2);
          }
          localTPDownloadParamData.setHeadersList(j.listOf(localHashMap));
          localITPPlayer.setVideoInfo(((TPVideoInfo.Builder)localObject).downloadParam(localTPDownloadParamData).build());
          localITPPlayer.setDataSource(paramString1);
          setState(1);
          paramString1 = x.aazN;
          AppMethodBeat.o(207713);
          return;
        }
        i = 0;
        continue;
        Log.w(locala.bqj, "setDataSource" + ", player is not available");
      }
      catch (Exception paramString1)
      {
        Log.e(locala.bqj, "setDataSource" + ", fail since " + paramString1);
        locala.i(paramString1);
        AppMethodBeat.o(207713);
        return;
      }
      AppMethodBeat.o(207713);
      return;
      label335:
      int i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ae.a.a.d
 * JD-Core Version:    0.7.0.1
 */