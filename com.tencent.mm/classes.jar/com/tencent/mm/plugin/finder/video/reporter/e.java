package com.tencent.mm.plugin.finder.video.reporter;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.fl;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/reporter/OnStopPlayData;", "", "()V", "firstSecondFps", "", "focusMaxFps", "focusMaxTimeMs", "", "focusMinFps", "focusTotalCount", "focusTotalTimeMs", "fpsList", "Ljava/util/LinkedList;", "getFpsList", "()Ljava/util/LinkedList;", "setFpsList", "(Ljava/util/LinkedList;)V", "lastFocusTimeStampMs", "lastRecordPlayPosMs", "lastSecondFps", "lastSurfaceTextureUpdateCount", "lessVideoFpsCount", "mediaId", "", "playProgressList", "getPlayProgressList", "setPlayProgressList", "playerState", "surfaceTextureUpdateCount", "totalMs", "videoFps", "videoPlayTraceJson", "Lorg/json/JSONObject;", "createClone", "getFinderVideoPlayTraceJSONObject", "getFocusFps", "", "getFocusMaxTimeMs", "getFocusTotalCount", "getFocusTotalTimeMs", "getPlayerState", "getSurfaceTextureUpdateCount", "init", "", "onBlur", "onFocus", "onGetVideoFps", "onPlayerStateChange", "state", "onProgressUpdate", "curPlayPosMs", "onSurfaceTextureUpdate", "putToStruct", "jsonObject", "struct", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderVideoPlayStruct;", "reset", "setFinderVideoPlayTrace", "json", "toString", "Companion", "plugin-finder-base_release"})
public final class e
  implements Cloneable
{
  public static final a AST;
  public int ASC;
  public long ASD;
  public int ASE;
  private int ASF;
  public long ASG;
  public long ASH;
  public long ASI;
  public long ASJ;
  public int ASK;
  public int ASL;
  public int ASM;
  public int ASN;
  public int ASO;
  public int ASP;
  public LinkedList<Integer> ASQ;
  public LinkedList<Integer> ASR;
  public JSONObject ASS;
  public String mediaId;
  public int videoFps;
  
  static
  {
    AppMethodBeat.i(259012);
    AST = new a((byte)0);
    AppMethodBeat.o(259012);
  }
  
  public e()
  {
    AppMethodBeat.i(259010);
    this.mediaId = "";
    this.ASL = -1;
    this.ASM = -1;
    this.ASN = -1;
    this.ASO = -1;
    this.videoFps = -1;
    this.ASQ = new LinkedList();
    this.ASR = new LinkedList();
    AppMethodBeat.o(259010);
  }
  
  public final void a(JSONObject paramJSONObject, fl paramfl)
  {
    AppMethodBeat.i(259004);
    p.k(paramJSONObject, "jsonObject");
    p.k(paramfl, "struct");
    e locale = (e)this;
    paramJSONObject.put("stup", locale.ASC);
    paramJSONObject.put("psta", locale.ASE);
    paramJSONObject.put("fttm", locale.ASD);
    paramJSONObject.put("fttc", locale.ASF);
    paramJSONObject.put("fmtm", locale.ASG);
    paramJSONObject.put("ffps", Float.valueOf(locale.ehT()));
    paramJSONObject.put("maxfps", this.ASN);
    paramJSONObject.put("minfps", this.ASO);
    paramJSONObject.put("fsfps", this.ASL);
    paramJSONObject.put("lsfps", this.ASM);
    paramJSONObject.put("lvfps", this.ASP);
    String str = "";
    Iterator localIterator = ((Iterable)this.ASQ).iterator();
    int i;
    while (localIterator.hasNext())
    {
      i = ((Number)localIterator.next()).intValue();
      str = str + i + ';';
    }
    paramJSONObject.put("pgsl", str);
    str = "";
    localIterator = ((Iterable)this.ASR).iterator();
    while (localIterator.hasNext())
    {
      i = ((Number)localIterator.next()).intValue();
      str = str + i + ';';
    }
    paramJSONObject.put("fpsl", str);
    paramJSONObject = locale.ASS;
    if (paramJSONObject != null)
    {
      paramJSONObject = paramJSONObject.toString();
      p.j(paramJSONObject, "videoPlayTrace.toString()");
      paramfl.uQ(n.l(paramJSONObject, ",", ";", false));
    }
    Log.i("OnStopPlayData", locale.toString());
    AppMethodBeat.o(259004);
  }
  
  public final Object clone()
  {
    AppMethodBeat.i(259014);
    Object localObject = super.clone();
    AppMethodBeat.o(259014);
    return localObject;
  }
  
  public final e ehR()
  {
    AppMethodBeat.i(259002);
    Object localObject = clone();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.video.reporter.OnStopPlayData");
      AppMethodBeat.o(259002);
      throw ((Throwable)localObject);
    }
    localObject = (e)localObject;
    ((e)localObject).ASR = new LinkedList();
    ((e)localObject).ASR.addAll((Collection)this.ASR);
    ((e)localObject).ASQ = new LinkedList();
    ((e)localObject).ASQ.addAll((Collection)this.ASQ);
    JSONObject localJSONObject = this.ASS;
    if (localJSONObject != null) {
      ((e)localObject).ASS = new JSONObject(localJSONObject.toString());
    }
    AppMethodBeat.o(259002);
    return localObject;
  }
  
  public final void ehS()
  {
    AppMethodBeat.i(259003);
    if (this.ASH != 0L)
    {
      AppMethodBeat.o(259003);
      return;
    }
    this.ASH = SystemClock.elapsedRealtime();
    this.ASF += 1;
    Log.i("OnStopPlayData", "onFocus focusTotalCount:" + this.ASF + ' ' + this.mediaId);
    AppMethodBeat.o(259003);
  }
  
  public final float ehT()
  {
    if (this.ASD == 0L) {
      return -1.0F;
    }
    return 1000.0F * this.ASC / (float)this.ASD;
  }
  
  public final void init(String paramString)
  {
    AppMethodBeat.i(259001);
    p.k(paramString, "mediaId");
    this.mediaId = paramString;
    AppMethodBeat.o(259001);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(259006);
    this.ASC = 0;
    this.ASD = 0L;
    this.ASE = 0;
    this.ASF = 0;
    this.ASG = 0L;
    this.ASH = 0L;
    this.ASI = -1L;
    this.ASJ = 0L;
    this.ASK = 0;
    this.ASN = -1;
    this.ASO = -1;
    this.ASL = -1;
    this.ASM = -1;
    this.ASP = 0;
    this.videoFps = 0;
    this.ASQ.clear();
    this.ASR.clear();
    AppMethodBeat.o(259006);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(259008);
    String str = "OnStopPlayData TextureUpdateCount:" + this.ASC + " PlayerState:" + this.ASE + "  FocusTotalTimeMs:" + this.ASD + " FocusTotalCount:" + this.ASF + ' ' + "FocusMaxTimeMs:" + this.ASG + " FocusFps:" + ehT() + ' ' + "lessVideoFpsCount:" + this.ASP + " videoFps:" + this.videoFps + ' ' + "focusMinFps:" + this.ASO + " focusMaxFps:" + this.ASN + ' ' + "firstSecondFps:" + this.ASL + " lastSecondFps:" + this.ASM + ' ' + "progressList:" + this.ASQ + " fpsList:" + this.ASR + " mediaId:" + this.mediaId;
    AppMethodBeat.o(259008);
    return str;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/reporter/OnStopPlayData$Companion;", "", "()V", "TAG", "", "plugin-finder-base_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.reporter.e
 * JD-Core Version:    0.7.0.1
 */