package com.tencent.mm.live.core.d;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.trtc.TRTCStatistics;
import com.tencent.trtc.TRTCStatistics.TRTCLocalStatistics;
import com.tencent.trtc.TRTCStatistics.TRTCRemoteStatistics;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/core/util/LiveStatisticUtil;", "", "()V", "parseCdnLiveStatistics", "", "params", "Landroid/os/Bundle;", "parseLocalStatistics", "Lorg/json/JSONArray;", "localArray", "Ljava/util/ArrayList;", "Lcom/tencent/trtc/TRTCStatistics$TRTCLocalStatistics;", "parseRemoteStatistics", "remoteArray", "Lcom/tencent/trtc/TRTCStatistics$TRTCRemoteStatistics;", "parseTRTCLiveStatistics", "statistics", "Lcom/tencent/trtc/TRTCStatistics;", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c mWN;
  
  static
  {
    AppMethodBeat.i(247677);
    mWN = new c();
    AppMethodBeat.o(247677);
  }
  
  public static String L(Bundle paramBundle)
  {
    AppMethodBeat.i(247639);
    if (paramBundle != null)
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("width", paramBundle.getInt("VIDEO_WIDTH"));
      localJSONObject.put("height", paramBundle.getInt("VIDEO_HEIGHT"));
      localJSONObject.put("video_fps", paramBundle.getInt("VIDEO_FPS"));
      localJSONObject.put("video_gop", paramBundle.getInt("VIDEO_GOP"));
      localJSONObject.put("video_bitrate", paramBundle.getInt("VIDEO_BITRATE"));
      localJSONObject.put("audio_bitrate", paramBundle.getInt("AUDIO_BITRATE"));
      localJSONObject.put("net_speed", paramBundle.getInt("NET_SPEED"));
      localJSONObject.put("video_cache", paramBundle.getInt("VIDEO_CACHE"));
      localJSONObject.put("audio_cache", paramBundle.getInt("AUDIO_CACHE"));
      localJSONObject.put("video_sum_cache_size", paramBundle.getInt("V_SUM_CACHE_SIZE"));
      localJSONObject.put("audio_video_play_interval", paramBundle.getInt("AV_PLAY_INTERVAL"));
      localJSONObject.put("audio_video_recv_interval", paramBundle.getInt("AV_RECV_INTERVAL"));
      localJSONObject.put("audio_cache_threshold", Float.valueOf(paramBundle.getFloat("AUDIO_CACHE_THRESHOLD")));
      localJSONObject.put("net_jitter", paramBundle.getInt("NET_JITTER"));
      localJSONObject.put("quality_level", paramBundle.getInt("NET_QUALITY_LEVEL"));
      localJSONObject.put("cdn_svr_ip", paramBundle.getString("SERVER_IP"));
      paramBundle = localJSONObject.toString();
      AppMethodBeat.o(247639);
      return paramBundle;
    }
    AppMethodBeat.o(247639);
    return null;
  }
  
  public static String a(TRTCStatistics paramTRTCStatistics)
  {
    AppMethodBeat.i(247647);
    if (paramTRTCStatistics != null)
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("appCpu", paramTRTCStatistics.appCpu);
      localJSONObject.put("systemCpu", paramTRTCStatistics.systemCpu);
      localJSONObject.put("rtt", paramTRTCStatistics.rtt);
      localJSONObject.put("upLoss", paramTRTCStatistics.upLoss);
      localJSONObject.put("downLoss", paramTRTCStatistics.downLoss);
      localJSONObject.put("sendBytes", paramTRTCStatistics.sendBytes);
      localJSONObject.put("receiveBytes", paramTRTCStatistics.receiveBytes);
      localJSONObject.put("LocalStatistics", n(paramTRTCStatistics.localArray));
      localJSONObject.put("remoteStatistics", o(paramTRTCStatistics.remoteArray));
      paramTRTCStatistics = localJSONObject.toString();
      AppMethodBeat.o(247647);
      return paramTRTCStatistics;
    }
    AppMethodBeat.o(247647);
    return null;
  }
  
  private static JSONArray n(ArrayList<TRTCStatistics.TRTCLocalStatistics> paramArrayList)
  {
    AppMethodBeat.i(247659);
    JSONArray localJSONArray = new JSONArray();
    if (paramArrayList != null)
    {
      paramArrayList = ((Iterable)paramArrayList).iterator();
      while (paramArrayList.hasNext())
      {
        TRTCStatistics.TRTCLocalStatistics localTRTCLocalStatistics = (TRTCStatistics.TRTCLocalStatistics)paramArrayList.next();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("width", localTRTCLocalStatistics.width);
        localJSONObject.put("height", localTRTCLocalStatistics.height);
        localJSONObject.put("frameRate", localTRTCLocalStatistics.frameRate);
        localJSONObject.put("videoBitrate", localTRTCLocalStatistics.videoBitrate);
        localJSONObject.put("audioSampleRate", localTRTCLocalStatistics.audioSampleRate);
        localJSONObject.put("audioBitrate", localTRTCLocalStatistics.audioBitrate);
        localJSONObject.put("streamType", localTRTCLocalStatistics.streamType);
        localJSONArray.put(localJSONObject);
      }
    }
    AppMethodBeat.o(247659);
    return localJSONArray;
  }
  
  private static JSONArray o(ArrayList<TRTCStatistics.TRTCRemoteStatistics> paramArrayList)
  {
    AppMethodBeat.i(247667);
    JSONArray localJSONArray = new JSONArray();
    if (paramArrayList != null)
    {
      paramArrayList = ((Iterable)paramArrayList).iterator();
      while (paramArrayList.hasNext())
      {
        TRTCStatistics.TRTCRemoteStatistics localTRTCRemoteStatistics = (TRTCStatistics.TRTCRemoteStatistics)paramArrayList.next();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("userId", localTRTCRemoteStatistics.userId);
        localJSONObject.put("finalLoss", localTRTCRemoteStatistics.finalLoss);
        localJSONObject.put("width", localTRTCRemoteStatistics.width);
        localJSONObject.put("height", localTRTCRemoteStatistics.height);
        localJSONObject.put("frameRate", localTRTCRemoteStatistics.frameRate);
        localJSONObject.put("videoBitrate", localTRTCRemoteStatistics.videoBitrate);
        localJSONObject.put("audioSampleRate", localTRTCRemoteStatistics.audioSampleRate);
        localJSONObject.put("audioBitrate", localTRTCRemoteStatistics.audioBitrate);
        localJSONObject.put("streamType", localTRTCRemoteStatistics.streamType);
        localJSONArray.put(localJSONObject);
      }
    }
    AppMethodBeat.o(247667);
    return localJSONArray;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.core.d.c
 * JD-Core Version:    0.7.0.1
 */