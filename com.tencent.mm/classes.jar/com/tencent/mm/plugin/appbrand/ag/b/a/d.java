package com.tencent.mm.plugin.appbrand.ag.b.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.thumbplayer.api.ITPPlayer;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPDownLoadProgressInfo;
import com.tencent.thumbplayer.api.TPVideoInfo.Builder;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/video/player/thumb/WebViewThumbMediaPlayer;", "Lcom/tencent/mm/plugin/appbrand/video/player/thumb/ThumbMediaPlayer;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "MTAG", "", "setNewData", "", "getSetNewData", "()Z", "setSetNewData", "(Z)V", "hitVideoPreloadReport", "", "extraInfo", "onTTPlayerInfoUpdate", "player", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "what", "", "arg1", "", "arg2", "extraObject", "", "setDataSource", "path", "referrer", "videoType", "setDataSourceImpl", "Companion", "plugin-compat_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends a
{
  public static final d.a uth;
  private final String uti;
  private boolean utj;
  
  static
  {
    AppMethodBeat.i(318021);
    uth = new d.a((byte)0);
    AppMethodBeat.o(318021);
  }
  
  public d(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(318000);
    this.uti = "MicroMsg.WebViewThumbMediaPlayer";
    AppMethodBeat.o(318000);
  }
  
  private final void O(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(318014);
    int i;
    a locala;
    ITPPlayer localITPPlayer;
    Object localObject;
    if (paramInt == 1)
    {
      i = 1;
      locala = (a)this;
      localITPPlayer = cNU();
      localObject = ah.aiuX;
      if (!locala.cNV()) {
        break label320;
      }
    }
    for (;;)
    {
      try
      {
        Log.d(locala.cNT(), "setDataSource");
        localObject = c.utd;
        localObject = c.agJ(paramString1);
        Log.i(this.uti, "setDataSource, path: " + paramString1 + ", fileId:" + (String)localObject + ", videoType:" + paramInt);
        this.utj = true;
        localITPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(102, 1000L).buildLong(504, 1L));
        localObject = new TPVideoInfo.Builder().fileId((String)localObject);
        TPDownloadParamData localTPDownloadParamData = new TPDownloadParamData(i);
        HashMap localHashMap = new HashMap();
        CharSequence localCharSequence = (CharSequence)paramString2;
        if (localCharSequence == null) {
          break label341;
        }
        if (localCharSequence.length() == 0)
        {
          break label341;
          if (paramInt == 0) {
            localHashMap.put("Referrer", paramString2);
          }
          paramString2 = ah.aiuX;
          localTPDownloadParamData.setHeadersList(p.listOf(localHashMap));
          paramString2 = ah.aiuX;
          localITPPlayer.setVideoInfo(((TPVideoInfo.Builder)localObject).downloadParam(localTPDownloadParamData).build());
          localITPPlayer.setDataSource(paramString1);
          this.sEu = 1;
          paramString1 = ah.aiuX;
          AppMethodBeat.o(318014);
          return;
          i = 0;
          break;
        }
        paramInt = 0;
        continue;
        Log.w(locala.cNT(), s.X("setDataSource", ", player is not available"));
      }
      catch (Exception paramString1)
      {
        Log.e(locala.cNT(), "setDataSource" + ", fail since " + paramString1);
        locala.j(paramString1);
        AppMethodBeat.o(318014);
        return;
      }
      label320:
      AppMethodBeat.o(318014);
      return;
      label341:
      paramInt = 1;
    }
  }
  
  public final void a(ITPPlayer paramITPPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    AppMethodBeat.i(318047);
    s.u(paramITPPlayer, "player");
    Log.d(this.uti, "onTTPlayerInfoUpdate：what:" + paramInt + "  arg1: " + paramLong1 + ", arg2: " + paramLong2 + ", extraObject: " + paramObject);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(318047);
      return;
    }
    do
    {
      try
      {
        Log.i(this.uti, "TP_PLAYER_INFO_LONG1_ADAPTIVE_SWITCH_DEF_END：arg1: " + paramLong1 + ", arg2: " + paramLong2 + ", extraObject: " + paramObject);
        acn(String.valueOf(paramLong1));
        AppMethodBeat.o(318047);
        return;
      }
      catch (Exception paramITPPlayer)
      {
        Log.printErrStackTrace(this.uti, (Throwable)paramITPPlayer, "", new Object[0]);
        AppMethodBeat.o(318047);
        return;
      }
    } while ((paramObject == null) || (!(paramObject instanceof TPPlayerMsg.TPDownLoadProgressInfo)));
    paramITPPlayer = ((TPPlayerMsg.TPDownLoadProgressInfo)paramObject).extraInfo;
    for (;;)
    {
      try
      {
        if (this.utj)
        {
          this.utj = false;
          if (paramITPPlayer != null)
          {
            paramITPPlayer = new JSONObject(paramITPPlayer).opt("hitDownloaded");
            if ((paramITPPlayer != null) && ((paramITPPlayer instanceof Integer)))
            {
              if (!s.p(paramITPPlayer, Integer.valueOf(1))) {
                continue;
              }
              jK(true);
            }
          }
        }
      }
      catch (Exception paramITPPlayer)
      {
        Log.printErrStackTrace(this.uti, (Throwable)paramITPPlayer, "", new Object[0]);
        continue;
      }
      Log.d(this.uti, s.X("extraObject.extraInfo: ", ((TPPlayerMsg.TPDownLoadProgressInfo)paramObject).extraInfo));
      break;
      jK(false);
    }
  }
  
  public final void cM(String paramString, int paramInt)
  {
    AppMethodBeat.i(318034);
    if (paramString == null)
    {
      AppMethodBeat.o(318034);
      return;
    }
    O(paramString, null, paramInt);
    AppMethodBeat.o(318034);
  }
  
  public final void ey(String paramString1, String paramString2)
  {
    AppMethodBeat.i(318027);
    s.u(paramString1, "path");
    O(paramString1, paramString2, 0);
    AppMethodBeat.o(318027);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ag.b.a.d
 * JD-Core Version:    0.7.0.1
 */