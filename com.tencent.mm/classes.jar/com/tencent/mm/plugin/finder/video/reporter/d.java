package com.tencent.mm.plugin.finder.video.reporter;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.hb;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/reporter/OnStopPlayData;", "", "()V", "firstSecondFps", "", "focusMaxFps", "focusMaxTimeMs", "", "focusMinFps", "focusTotalCount", "focusTotalTimeMs", "fpsList", "Ljava/util/LinkedList;", "getFpsList", "()Ljava/util/LinkedList;", "setFpsList", "(Ljava/util/LinkedList;)V", "lastFocusTimeStampMs", "lastRecordPlayPosMs", "lastSecondFps", "lastSurfaceTextureUpdateCount", "lessVideoFpsCount", "mediaId", "", "playProgressList", "getPlayProgressList", "setPlayProgressList", "playerState", "surfaceTextureUpdateCount", "totalMs", "videoFps", "videoPlayTraceJson", "Lorg/json/JSONObject;", "createClone", "getFinderVideoPlayTraceJSONObject", "getFocusFps", "", "getFocusMaxTimeMs", "getFocusTotalCount", "getFocusTotalTimeMs", "getPlayerState", "getSurfaceTextureUpdateCount", "init", "", "onBlur", "onFocus", "onGetVideoFps", "onPlayerStateChange", "state", "onProgressUpdate", "curPlayPosMs", "onSurfaceTextureUpdate", "putToStruct", "jsonObject", "struct", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderVideoPlayStruct;", "reset", "setFinderVideoPlayTrace", "json", "toString", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements Cloneable
{
  public static final a GuB;
  private int GuC;
  private long GuD;
  public int GuE;
  private int GuF;
  private long GuG;
  private long GuH;
  private long GuI;
  private long GuJ;
  private int GuK;
  private int GuL;
  private int GuM;
  private int GuN;
  private int GuO;
  private int GuP;
  private LinkedList<Integer> GuQ;
  private LinkedList<Integer> GuR;
  public JSONObject GuS;
  private String mediaId;
  public int videoFps;
  
  static
  {
    AppMethodBeat.i(335124);
    GuB = new a((byte)0);
    AppMethodBeat.o(335124);
  }
  
  public d()
  {
    AppMethodBeat.i(335113);
    this.mediaId = "";
    this.GuL = -1;
    this.GuM = -1;
    this.GuN = -1;
    this.GuO = -1;
    this.videoFps = -1;
    this.GuQ = new LinkedList();
    this.GuR = new LinkedList();
    AppMethodBeat.o(335113);
  }
  
  private float fjW()
  {
    if (this.GuD == 0L) {
      return -1.0F;
    }
    return 1000.0F * this.GuC / (float)this.GuD;
  }
  
  public final void a(JSONObject paramJSONObject, hb paramhb)
  {
    AppMethodBeat.i(335177);
    s.u(paramJSONObject, "jsonObject");
    s.u(paramhb, "struct");
    d locald = (d)this;
    paramJSONObject.put("stup", locald.GuC);
    paramJSONObject.put("psta", locald.GuE);
    paramJSONObject.put("fttm", locald.GuD);
    paramJSONObject.put("fttc", locald.GuF);
    paramJSONObject.put("fmtm", locald.GuG);
    paramJSONObject.put("ffps", Float.valueOf(locald.fjW()));
    paramJSONObject.put("maxfps", this.GuN);
    paramJSONObject.put("minfps", this.GuO);
    paramJSONObject.put("fsfps", this.GuL);
    paramJSONObject.put("lsfps", this.GuM);
    paramJSONObject.put("lvfps", this.GuP);
    String str = "";
    Iterator localIterator = ((Iterable)this.GuQ).iterator();
    int i;
    while (localIterator.hasNext())
    {
      i = ((Number)localIterator.next()).intValue();
      str = str + i + ';';
    }
    paramJSONObject.put("pgsl", str);
    str = "";
    localIterator = ((Iterable)this.GuR).iterator();
    while (localIterator.hasNext())
    {
      i = ((Number)localIterator.next()).intValue();
      str = str + i + ';';
    }
    paramJSONObject.put("fpsl", str);
    paramJSONObject = locald.GuS;
    if (paramJSONObject != null)
    {
      paramJSONObject = paramJSONObject.toString();
      s.s(paramJSONObject, "videoPlayTrace.toString()");
      paramhb.iMY = paramhb.F("FirstFrameDetail", n.bV(paramJSONObject, ",", ";"), true);
    }
    Log.i("OnStopPlayData", locald.toString());
    AppMethodBeat.o(335177);
  }
  
  public final void aB(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(335149);
    this.GuJ = paramLong2;
    if (paramLong1 - this.GuI > 1000L)
    {
      this.GuQ.add(Integer.valueOf((int)(paramLong1 / 1000L)));
      int i = this.GuC - this.GuK;
      this.GuR.add(Integer.valueOf(i));
      if ((i < this.GuO) || (this.GuO == -1)) {
        this.GuO = i;
      }
      if ((i > this.GuN) || (this.GuN == -1)) {
        this.GuN = i;
      }
      if (this.GuL == -1) {
        this.GuL = i;
      }
      this.GuM = i;
      if (i < this.videoFps) {
        this.GuP += 1;
      }
      this.GuK = this.GuC;
      this.GuI = paramLong1;
    }
    AppMethodBeat.o(335149);
  }
  
  public final Object clone()
  {
    AppMethodBeat.i(335200);
    Object localObject = super.clone();
    AppMethodBeat.o(335200);
    return localObject;
  }
  
  public final d fjS()
  {
    AppMethodBeat.i(335138);
    d locald = (d)clone();
    locald.GuR = new LinkedList();
    locald.GuR.addAll((Collection)this.GuR);
    locald.GuQ = new LinkedList();
    locald.GuQ.addAll((Collection)this.GuQ);
    JSONObject localJSONObject = this.GuS;
    if (localJSONObject != null) {
      locald.GuS = new JSONObject(localJSONObject.toString());
    }
    AppMethodBeat.o(335138);
    return locald;
  }
  
  public final void fjT()
  {
    this.GuC += 1;
  }
  
  public final void fjU()
  {
    AppMethodBeat.i(335159);
    if (this.GuH != 0L)
    {
      AppMethodBeat.o(335159);
      return;
    }
    this.GuH = SystemClock.elapsedRealtime();
    this.GuF += 1;
    Log.i("OnStopPlayData", "onFocus focusTotalCount:" + this.GuF + ' ' + this.mediaId);
    AppMethodBeat.o(335159);
  }
  
  public final void fjV()
  {
    AppMethodBeat.i(335166);
    if ((this.GuH == 0L) || (this.GuD > 0L))
    {
      AppMethodBeat.o(335166);
      return;
    }
    long l = SystemClock.elapsedRealtime() - this.GuH;
    if (l >= 0L) {
      this.GuD += l;
    }
    if (l > this.GuG) {
      this.GuG = l;
    }
    Log.i("OnStopPlayData", "onBlur focusTimeMs:" + l + " focusMaxTimeMs:" + this.GuG + " blurFPS:" + fjW() + ' ' + this.mediaId);
    AppMethodBeat.o(335166);
  }
  
  public final void init(String paramString)
  {
    AppMethodBeat.i(335130);
    s.u(paramString, "mediaId");
    this.mediaId = paramString;
    AppMethodBeat.o(335130);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(335187);
    this.GuC = 0;
    this.GuD = 0L;
    this.GuE = 0;
    this.GuF = 0;
    this.GuG = 0L;
    this.GuH = 0L;
    this.GuI = -1L;
    this.GuJ = 0L;
    this.GuK = 0;
    this.GuN = -1;
    this.GuO = -1;
    this.GuL = -1;
    this.GuM = -1;
    this.GuP = 0;
    this.videoFps = 0;
    this.GuQ.clear();
    this.GuR.clear();
    AppMethodBeat.o(335187);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(335194);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("OnStopPlayData TextureUpdateCount:").append(this.GuC).append(" PlayerState:").append(this.GuE).append("  FocusTotalTimeMs:").append(this.GuD).append(" FocusTotalCount:").append(this.GuF).append(" FocusMaxTimeMs:").append(this.GuG).append(" FocusFps:").append(fjW()).append(" lessVideoFpsCount:").append(this.GuP).append(" videoFps:").append(this.videoFps).append(" focusMinFps:").append(this.GuO).append(" focusMaxFps:").append(this.GuN).append(" firstSecondFps:").append(this.GuL).append(" lastSecondFps:");
    ((StringBuilder)localObject).append(this.GuM).append(" progressList:").append(this.GuQ).append(" fpsList:").append(this.GuR).append(" mediaId:").append(this.mediaId);
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(335194);
    return localObject;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/reporter/OnStopPlayData$Companion;", "", "()V", "TAG", "", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.reporter.d
 * JD-Core Version:    0.7.0.1
 */