package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.apa;
import com.tencent.mm.protocal.protobuf.bqs;
import d.g.b.k;
import java.util.HashSet;
import java.util.LinkedList;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter$ReportData;", "", "()V", "adjustVolume", "", "getAdjustVolume", "()I", "setAdjustVolume", "(I)V", "currentFeedId", "", "getCurrentFeedId", "()J", "setCurrentFeedId", "(J)V", "currentMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "getCurrentMedia", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "setCurrentMedia", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;)V", "currentMediaId", "", "getCurrentMediaId", "()Ljava/lang/String;", "setCurrentMediaId", "(Ljava/lang/String;)V", "currentVideo", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "getCurrentVideo", "()Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "setCurrentVideo", "(Lcom/tencent/mm/plugin/finder/loader/FinderVideo;)V", "currentWaiting", "", "getCurrentWaiting", "()Z", "setCurrentWaiting", "(Z)V", "downloadFinishTime", "getDownloadFinishTime", "setDownloadFinishTime", "downloadPercent", "getDownloadPercent", "setDownloadPercent", "downloadSpeed", "getDownloadSpeed", "setDownloadSpeed", "endVolume", "getEndVolume", "setEndVolume", "fetchTimestamp", "getFetchTimestamp", "setFetchTimestamp", "firstFrameTime", "getFirstFrameTime", "setFirstFrameTime", "firstLoadTime", "getFirstLoadTime", "setFirstLoadTime", "firstPlay", "getFirstPlay", "setFirstPlay", "firstRequestDataOffset", "getFirstRequestDataOffset", "setFirstRequestDataOffset", "frameRate", "getFrameRate", "setFrameRate", "hitPreload", "getHitPreload", "setHitPreload", "hitPreloadPercent", "getHitPreloadPercent", "setHitPreloadPercent", "isPause", "setPause", "isSeek", "setSeek", "isStartDownload", "setStartDownload", "mediaPath", "getMediaPath", "setMediaPath", "moovReadyOffset", "getMoovReadyOffset", "setMoovReadyOffset", "moovReadyTime", "getMoovReadyTime", "setMoovReadyTime", "netType", "getNetType", "setNetType", "netTypeInt", "getNetTypeInt", "setNetTypeInt", "pauseTimestamp", "getPauseTimestamp", "setPauseTimestamp", "pauseTotalTime", "getPauseTotalTime", "setPauseTotalTime", "playAudioBitrate", "getPlayAudioBitrate", "setPlayAudioBitrate", "playCodeFormat", "getPlayCodeFormat", "setPlayCodeFormat", "playFileFormat", "getPlayFileFormat", "setPlayFileFormat", "playPageIndex", "getPlayPageIndex", "setPlayPageIndex", "playPercent", "getPlayPercent", "setPlayPercent", "playPercentSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getPlayPercentSet", "()Ljava/util/HashSet;", "setPlayPercentSet", "(Ljava/util/HashSet;)V", "playPosition", "getPlayPosition", "setPlayPosition", "playStatus", "getPlayStatus", "setPlayStatus", "playTime", "getPlayTime", "setPlayTime", "playVideoBitrate", "getPlayVideoBitrate", "setPlayVideoBitrate", "playWaitingCount", "getPlayWaitingCount", "setPlayWaitingCount", "playerErrCode", "getPlayerErrCode", "setPlayerErrCode", "playing", "getPlaying", "setPlaying", "preloadStrategyId", "getPreloadStrategyId", "setPreloadStrategyId", "realPlayTime", "getRealPlayTime", "setRealPlayTime", "realPlayTimestamp", "getRealPlayTimestamp", "setRealPlayTimestamp", "replayCount", "getReplayCount", "setReplayCount", "reportSceneResult", "Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter$ReportSceneResult;", "getReportSceneResult", "()Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter$ReportSceneResult;", "setReportSceneResult", "(Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter$ReportSceneResult;)V", "reportTaskInfo", "Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter$ReportTaskInfo;", "getReportTaskInfo", "()Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter$ReportTaskInfo;", "setReportTaskInfo", "(Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter$ReportTaskInfo;)V", "sessionId", "getSessionId", "setSessionId", "startTimestamp", "getStartTimestamp", "setStartTimestamp", "startVolume", "getStartVolume", "setStartVolume", "startWaitingTime", "getStartWaitingTime", "setStartWaitingTime", "totalWaitingTime", "getTotalWaitingTime", "setTotalWaitingTime", "videoHeight", "", "getVideoHeight", "()F", "setVideoHeight", "(F)V", "videoWidth", "getVideoWidth", "setVideoWidth", "waitDetails", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderWaitDetail;", "getWaitDetails", "()Ljava/util/LinkedList;", "setWaitDetails", "(Ljava/util/LinkedList;)V", "waitingCount", "getWaitingCount", "setWaitingCount", "plugin-finder_release"})
public final class m$b
{
  boolean aVE;
  int frameRate;
  int hYu;
  int kVI;
  String mediaPath;
  long rxY;
  long rxZ;
  long rya;
  int ryc;
  int ryd;
  int ryg;
  int ryh;
  long rzA;
  long rzB;
  int rzC;
  long rzD;
  long rzE;
  long rzF;
  long rzG;
  m.d rzH;
  m.c rzI;
  boolean rzJ;
  long rzK;
  LinkedList<apa> rzL;
  HashSet<Integer> rzM;
  int rzN;
  String rzO;
  int rzP;
  int rzQ;
  String rzR;
  float rzS;
  float rzT;
  long rze;
  String rzf;
  com.tencent.mm.plugin.finder.loader.l rzg;
  bqs rzh;
  long rzi;
  long rzj;
  int rzk;
  int rzl;
  long rzm;
  int rzn;
  int rzo;
  int rzp;
  long rzq;
  long rzr;
  long rzs;
  String rzt;
  long rzu;
  int rzv;
  int rzw;
  boolean rzx;
  int rzy;
  long rzz;
  String sessionId;
  int uGI;
  
  public m$b()
  {
    AppMethodBeat.i(178402);
    this.sessionId = "";
    this.rzf = "";
    this.mediaPath = "";
    this.rzt = "";
    this.rzL = new LinkedList();
    this.rzM = new HashSet();
    this.rzO = "";
    this.rzR = "";
    AppMethodBeat.o(178402);
  }
  
  public final void adP(String paramString)
  {
    AppMethodBeat.i(202810);
    k.h(paramString, "<set-?>");
    this.rzO = paramString;
    AppMethodBeat.o(202810);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.m.b
 * JD-Core Version:    0.7.0.1
 */