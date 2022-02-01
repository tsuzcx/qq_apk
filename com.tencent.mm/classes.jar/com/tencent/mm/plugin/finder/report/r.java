package com.tencent.mm.plugin.finder.report;

import android.os.SystemClock;
import com.tencent.d.a.a.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.er;
import com.tencent.mm.live.core.core.model.g;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.findersdk.storage.config.base.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderLiveReporter;", "", "()V", "FINDER_ACTION_UNKNOWN_TYPE", "", "FINDER_ENTER_FIRST_FRAME_TIME", "FINDER_LIVE_TYPE", "FINDER_SLIDE_FIRST_FRAME_TIME", "FINDER_SWITCH_TAB_FIRST_FRAME_TIME", "FINDER_UNKNOWN_TYPE", "FINDER_VIDEO_TO_TYPE", "TAG", "", "mActionType", "mFinderLiveData", "Lcom/tencent/mm/plugin/finder/report/FinderLiveReporter$Data;", "mFinderType", "mIsFirst", "", "mIsFirstLivePreload", "mIsSlideStart", "mIsSwitchTab", "buildJson", "Lorg/json/JSONObject;", "checkTime", "time", "clearData", "", "clearLiveTime", "genTimeStr", "isPrePlay", "notifyClickEnterTime", "finderType", "notifyConnectSuccessTime", "notifyDecodeStartTime", "notifyFirstFrameTime", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "feedData", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "notifyPlayBeginTime", "notifySlideStartTime", "switchTab", "showFirst", "notifyStartPlayTime", "firstLivePreload", "notifyStartScroll", "report23799", "data", "Data", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r
{
  public static final r Fqi;
  private static long Fqj;
  public static long Fqk;
  public static a Fql;
  private static boolean Fqm;
  private static boolean Fqn;
  public static boolean Fqo;
  private static boolean xBN;
  
  static
  {
    AppMethodBeat.i(331664);
    Fqi = new r();
    xBN = true;
    AppMethodBeat.o(331664);
  }
  
  public static void a(g paramg, FeedData paramFeedData)
  {
    AppMethodBeat.i(331502);
    a locala = Fql;
    if (locala != null) {
      locala.Fqp = SystemClock.elapsedRealtime();
    }
    locala = Fql;
    er localer;
    long l;
    String str;
    label280:
    int i;
    if (locala != null)
    {
      if ((locala.startTime == 0L) || (locala.Fqp == 0L) || (locala.Fqq == 0L) || (locala.Fqs == 0L) || (locala.Fqr == 0L) || (locala.Fqt == 0L))
      {
        Log.i("FinderLiveReporter", "report invalid data, startTime=" + locala.startTime + ", firstFrame=" + locala.Fqp + ", startPlay=" + locala.Fqq + ", decodeStart=" + locala.Fqs + ", connectSuccess=" + locala.Fqr + "playBegin=" + locala.Fqt);
        AppMethodBeat.o(331502);
        return;
      }
      localer = new er();
      localer.iFd = Fqj;
      if (!Fqm) {
        break label421;
      }
      l = 3L;
      localer.iFe = l;
      if ((Fqo) || (Fqk != 2L)) {
        break label428;
      }
      str = eMK().toString();
      s.s(str, "buildJson().toString()");
      localer.pf(n.bV(str, ",", ";"));
      localer.iFf = 0L;
      localer.iFg = 0L;
      localer.iFh = pD(locala.Fqr - locala.Fqq);
      localer.iFi = pD(locala.Fqs - locala.Fqr);
      localer.iFk = pD(locala.Fqp - locala.Fqt);
      if (!Fqn) {
        break label499;
      }
      i = 1;
      label345:
      localer.iFl = i;
      localer.iFm = pD(locala.Fqp - locala.Fqq);
      if (paramg == null) {
        break label504;
      }
      localer.pe(paramg.nickName);
      localer.iFo = paramg.liveId;
    }
    for (;;)
    {
      localer.bMH();
      Log.i("FinderLiveReporter", s.X("report23799 info:", localer.aIF()));
      AppMethodBeat.o(331502);
      return;
      label421:
      l = Fqk;
      break;
      label428:
      str = eMK().toString();
      s.s(str, "buildJson().toString()");
      localer.pf(n.bV(str, ",", ";"));
      localer.iFf = pD(locala.Fqp - locala.startTime);
      localer.iFg = pD(locala.Fqq - locala.startTime);
      break label280;
      label499:
      i = 0;
      break label345;
      label504:
      if (paramFeedData != null)
      {
        localer.pe(paramFeedData.getNickName());
        localer.iFo = paramFeedData.getLiveId();
      }
    }
  }
  
  public static void clearData()
  {
    Fql = null;
    Fqj = 0L;
    Fqk = 0L;
    Fqm = false;
    xBN = true;
  }
  
  public static void eMG()
  {
    AppMethodBeat.i(331564);
    a locala = Fql;
    if (locala != null) {
      locala.Fqr = SystemClock.elapsedRealtime();
    }
    AppMethodBeat.o(331564);
  }
  
  public static void eMH()
  {
    AppMethodBeat.i(331574);
    a locala = Fql;
    if (locala != null) {
      locala.Fqs = SystemClock.elapsedRealtime();
    }
    AppMethodBeat.o(331574);
  }
  
  public static void eMI()
  {
    AppMethodBeat.i(331584);
    a locala = Fql;
    if (locala != null) {
      locala.Fqt = SystemClock.elapsedRealtime();
    }
    AppMethodBeat.o(331584);
  }
  
  public static String eMJ()
  {
    AppMethodBeat.i(331616);
    Object localObject = new StringBuilder("");
    a locala = Fql;
    if (locala != null)
    {
      long l1 = pD(locala.Fqp - locala.startTime);
      long l2 = pD(locala.Fqq - locala.startTime);
      long l3 = pD(locala.Fqp - locala.Fqq);
      ((StringBuilder)localObject).append(s.X("FirstFrameTime:", Long.valueOf(l1))).append("\n").append(s.X("StartPlayTime:", Long.valueOf(l2))).append("\n").append(s.X("StartPlayToFrameTime:", Long.valueOf(l3))).append("\n");
    }
    localObject = ((StringBuilder)localObject).toString();
    s.s(localObject, "timeStr.toString()");
    AppMethodBeat.o(331616);
    return localObject;
  }
  
  private static JSONObject eMK()
  {
    AppMethodBeat.i(331632);
    JSONObject localJSONObject = new JSONObject();
    a locala = Fql;
    if (locala != null)
    {
      if (!eML()) {
        break label64;
      }
      localJSONObject.put("realFirstFrameTime", locala.Fqp - locala.Fqu);
    }
    for (;;)
    {
      localJSONObject.put("isPrePlay", eML());
      AppMethodBeat.o(331632);
      return localJSONObject;
      label64:
      localJSONObject.put("realFirstFrameTime", locala.Fqp - locala.startTime);
    }
  }
  
  public static boolean eML()
  {
    AppMethodBeat.i(331657);
    a locala = a.ahiX;
    if (((Number)a.jUD().bmg()).intValue() == 1)
    {
      AppMethodBeat.o(331657);
      return true;
    }
    AppMethodBeat.o(331657);
    return false;
  }
  
  public static void pC(long paramLong)
  {
    AppMethodBeat.i(331478);
    clearData();
    a locala = new a();
    locala.startTime = SystemClock.elapsedRealtime();
    Fql = locala;
    Fqj = paramLong;
    Fqk = 1L;
    locala = Fql;
    if (locala != null)
    {
      locala.Fqp = 0L;
      locala.Fqq = 0L;
      locala.Fqr = 0L;
      locala.Fqs = 0L;
      locala.Fqt = 0L;
    }
    AppMethodBeat.o(331478);
  }
  
  private static long pD(long paramLong)
  {
    long l = paramLong;
    if (paramLong < 0L) {
      l = 0L;
    }
    return l;
  }
  
  public static void tM(boolean paramBoolean)
  {
    AppMethodBeat.i(331538);
    a locala;
    if ((Fqj == 1L) && (Fqk == 1L)) {
      if (!paramBoolean)
      {
        locala = Fql;
        if (locala != null) {
          locala.Fqq = SystemClock.elapsedRealtime();
        }
        if (!xBN) {
          Fqn = false;
        }
      }
    }
    for (;;)
    {
      locala = Fql;
      if (locala != null) {
        locala.Fqq = SystemClock.elapsedRealtime();
      }
      AppMethodBeat.o(331538);
      return;
      xBN = false;
      continue;
      Fqn = true;
      continue;
      locala = Fql;
      if (locala != null) {
        locala.Fqq = SystemClock.elapsedRealtime();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderLiveReporter$Data;", "", "()V", "firstFrameTime", "", "getFirstFrameTime", "()J", "setFirstFrameTime", "(J)V", "onConnectSuccessTime", "getOnConnectSuccessTime", "setOnConnectSuccessTime", "onDecodeStartTime", "getOnDecodeStartTime", "setOnDecodeStartTime", "onPlayBeginTime", "getOnPlayBeginTime", "setOnPlayBeginTime", "onStartPlayTime", "getOnStartPlayTime", "setOnStartPlayTime", "realStartTime", "getRealStartTime", "setRealStartTime", "startTime", "getStartTime", "setStartTime", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    long Fqp;
    long Fqq;
    long Fqr;
    long Fqs;
    long Fqt;
    public long Fqu;
    long startTime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.r
 * JD-Core Version:    0.7.0.1
 */