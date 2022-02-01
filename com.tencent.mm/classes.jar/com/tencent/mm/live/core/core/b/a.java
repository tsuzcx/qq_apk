package com.tencent.mm.live.core.core.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.qcloud.qvb.XNet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.eq;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.d;
import com.tencent.mm.network.p;
import com.tencent.mm.network.p.a;
import com.tencent.mm.network.y;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import java.io.InputStream;
import java.util.Scanner;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.n.k;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/core/core/p2p/MMXp2pWrapper;", "", "()V", "MSG_GET_P2P_STAT_START", "", "MSG_GET_P2P_STAT_STOP", "MSG_START_P2P_SERVICE", "MSG_STOP_P2P_SERVICE", "MSG_UPDATE_P2P_SERVICE", "TAG", "", "bStartP2pService", "", "cdnUrl", "finderNickname", "host", "kRandomTokenLength", "lastCdnBytes", "", "lastInvalidPieces", "lastP2pBytes", "lastTagMissedInvalidPieces", "lastTotalPieces", "lastVerifyPieces", "lastXs4xxStatus", "liveId", "lock", "Ljava/lang/Object;", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "mHandlerThread", "Landroid/os/HandlerThread;", "getMHandlerThread", "()Landroid/os/HandlerThread;", "setMHandlerThread", "(Landroid/os/HandlerThread;)V", "mhandler", "Landroid/os/Handler;", "getMhandler", "()Landroid/os/Handler;", "setMhandler", "(Landroid/os/Handler;)V", "needUpdateP2pService", "onNWChange", "Lcom/tencent/mm/network/IOnNetworkChange_AIDL;", "p2pAppid", "p2pAppidOld", "p2pDebugLogSwitch", "p2pDomain", "p2pDownloadMnSwitch", "p2pKey", "p2pKeyOld", "p2pMaxBufferSize", "p2pMaxLoad", "p2pSecret", "p2pSecretOld", "p2pStarted", "p2pStatSwitch", "p2pStremId", "p2pSwitch", "p2pUploadDawangkaSwitch", "p2pUploadSwitch", "p2pVerifyStream", "p2ptoken", "reportTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "xhost", "disableP2P", "", "doReport", "drainStream", "input", "Ljava/io/InputStream;", "initWith", "context", "appId", "key", "secret", "isEnableP2P", "onResetP2pStat", "parseJsonAndReport", "jsonString", "randomStringWithLength", "release", "replacePlaybackUrl", "oldUrl", "streamId", "bHttps", "requestFeature", "url", "requestStatistic", "reset", "startP2pService", "updateP2pService", "updateP2pSwitches", "switch", "upload", "downloadMn", "stat", "debugLog", "maxLoad", "maxBufferSize", "uploadDawangka", "updateReportStat", "(Ljava/lang/Long;Ljava/lang/String;)V", "Companion", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static boolean enableP2p;
  public static final a.a mOr;
  private static a mPg;
  public final String TAG;
  private String host;
  public long liveId;
  private final Object lock;
  Context mContext;
  public HandlerThread mHandlerThread;
  int mOA;
  String mOB;
  String mOC;
  String mOD;
  String mOE;
  String mOF;
  String mOG;
  String mOH;
  private String mOI;
  String mOJ;
  final String mOK;
  private final String mOL;
  boolean mOM;
  private volatile boolean mON;
  private volatile boolean mOO;
  Handler mOP;
  private final int mOQ;
  private final int mOR;
  private final int mOS;
  private final int mOT;
  private final int mOU;
  private final int mOV;
  private long mOW;
  private long mOX;
  private long mOY;
  private long mOZ;
  int mOs;
  int mOt;
  int mOu;
  private int mOv;
  int mOw;
  int mOx;
  int mOy;
  private int mOz;
  private long mPa;
  private long mPb;
  private long mPc;
  public String mPd;
  private final MTimerHandler mPe;
  private final p mPf;
  
  static
  {
    AppMethodBeat.i(248052);
    mOr = new a.a((byte)0);
    AppMethodBeat.o(248052);
  }
  
  public a()
  {
    AppMethodBeat.i(247891);
    this.TAG = "MicroMsg.MMXp2pWrapper";
    this.mOA = 1;
    this.mOB = "";
    this.mOC = "";
    this.mOD = "";
    this.mOE = "";
    this.mOF = "";
    this.mOG = "";
    this.host = "";
    this.mOI = "";
    this.mOJ = "";
    this.mOK = "live.p2p.com";
    this.mOL = "voipfinderp2pliveplay.wxqcloud.qq.com";
    this.mOO = true;
    this.mOQ = 1;
    this.mOR = 2;
    this.mOS = 3;
    this.mOT = 4;
    this.mOU = 5;
    this.mOV = 15;
    this.mPd = "";
    this.lock = new Object();
    this.mPe = new MTimerHandler(this.TAG, new a..ExternalSyntheticLambda0(this), true);
    this.mPf = ((p)new c(this));
    if (((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yHC, 0) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      enableP2p = bool;
      if (bool)
      {
        HandlerThread localHandlerThread = new HandlerThread("xp2p-thread");
        s.u(localHandlerThread, "<set-?>");
        this.mHandlerThread = localHandlerThread;
        bey().start();
        this.mOP = ((Handler)new Handler(bey().getLooper())
        {
          public final void handleMessage(Message paramAnonymousMessage)
          {
            Object localObject1 = null;
            int k = 1;
            AppMethodBeat.i(247889);
            s.u(paramAnonymousMessage, "msg");
            if (paramAnonymousMessage.what == a.e(this.mPh))
            {
              if (!a.f(this.mPh)) {
                break label1140;
              }
              a.a(this.mPh, false);
              paramAnonymousMessage = a.g(this.mPh);
              localObject1 = this.mPh;
              try
              {
                a.a((a)localObject1, ((a)localObject1).mContext, a.m((a)localObject1), a.n((a)localObject1), a.o((a)localObject1));
                a.g((a)localObject1).notifyAll();
                localObject1 = ah.aiuX;
                h.baD().a(a.h(this.mPh));
                Log.i(a.d(this.mPh), "xp2p Wrapper startP2pService end");
                AppMethodBeat.o(247889);
                return;
              }
              finally
              {
                AppMethodBeat.o(247889);
              }
            }
            if (paramAnonymousMessage.what == a.i(this.mPh))
            {
              Log.i(a.d(this.mPh), "xp2p Wrapper prepare stopP2pService");
              XNet.destroy();
              a.a(this.mPh, true);
              h.baD().b(a.h(this.mPh));
              Log.i(a.d(this.mPh), "xp2p Wrapper stopP2pService");
              AppMethodBeat.o(247889);
              return;
            }
            a locala;
            Object localObject3;
            if (paramAnonymousMessage.what == a.c(this.mPh))
            {
              locala = this.mPh;
              if ((!a.enableP2p) || (((locala.mOs == 0) || (locala.mOH == null)) && (!locala.mOM)))
              {
                Log.i(locala.TAG, "xp2p Wrapper updateP2pService warning, " + a.enableP2p + " p2pSwitch:" + locala.mOs + " p2pStremId:" + locala.mOH);
                AppMethodBeat.o(247889);
                return;
              }
              paramAnonymousMessage = XNet.proxyOf(locala.mOK);
              s.s(paramAnonymousMessage, "proxyOf(p2pDomain)");
              if ((s.p(paramAnonymousMessage, locala.mOK)) || (s.p(paramAnonymousMessage, "")))
              {
                Log.i(locala.TAG, s.X("xp2p Wrapper updateP2pService proxy ", paramAnonymousMessage));
                AppMethodBeat.o(247889);
                return;
              }
              localObject3 = MMApplicationContext.getContext().getSystemService("connectivity");
              if (localObject3 == null)
              {
                paramAnonymousMessage = new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
                AppMethodBeat.o(247889);
                throw paramAnonymousMessage;
              }
              localObject3 = ((ConnectivityManager)localObject3).getActiveNetworkInfo();
              if ((localObject3 == null) || (((NetworkInfo)localObject3).getType() != 1)) {
                break label1146;
              }
            }
            label469:
            label475:
            label482:
            label1140:
            label1146:
            for (boolean bool = true;; bool = false)
            {
              int j;
              int i;
              if ((bool) && (locala.mOt != 0))
              {
                j = 1;
                if ((locala.mOu == 0) && (!bool)) {
                  break label940;
                }
                i = 1;
                if (j == 0) {
                  break label945;
                }
                j = 1;
                if (i == 0) {
                  break label950;
                }
                i = k;
                localObject3 = s.X(paramAnonymousMessage, "feature?download=" + i + "&upload=" + j + "&max_load=" + locala.mOx + "&max_buffer_size=" + locala.mOy + "&verifyStream=" + locala.mOA + "&token=" + locala.mOJ);
              }
              for (paramAnonymousMessage = localObject2;; paramAnonymousMessage = localy)
              {
                try
                {
                  localy = d.a((String)localObject3, null);
                  if (localy == null) {
                    break label1041;
                  }
                  paramAnonymousMessage = localy;
                  localy.xx(10000);
                  paramAnonymousMessage = localy;
                  localy.xy(10000);
                  paramAnonymousMessage = localy;
                  localy.connect();
                  paramAnonymousMessage = localy;
                  k = localy.getResponseCode();
                  if (k != 200) {
                    break label955;
                  }
                  paramAnonymousMessage = localy;
                  InputStream localInputStream = localy.getInputStream();
                  paramAnonymousMessage = localy;
                  s.s(localInputStream, "con.getInputStream()");
                  paramAnonymousMessage = localy;
                  String str = a.A(localInputStream);
                  paramAnonymousMessage = localy;
                  localInputStream.close();
                  paramAnonymousMessage = localy;
                  Log.i(locala.TAG, "xp2p Wrapper switch result: " + str + " url: " + (String)localObject3);
                  paramAnonymousMessage = localy;
                }
                catch (Exception localException)
                {
                  for (;;)
                  {
                    y localy;
                    Log.printErrStackTrace(locala.TAG, (Throwable)localException, "", new Object[0]);
                    Log.e(locala.TAG, s.X("xp2p Wrapper switch error ", localObject3));
                    continue;
                    paramAnonymousMessage = localException;
                    Log.i(locala.TAG, s.X("tryReport ERR: genHttpConnection is null url ", localObject3));
                    paramAnonymousMessage = localException;
                    continue;
                    XNet.disableDebug();
                  }
                }
                if (paramAnonymousMessage != null) {
                  paramAnonymousMessage.disconnect();
                }
                if (locala.mOw == 0) {
                  break label1066;
                }
                XNet.enableDebug();
                if ((!s.p(locala.mOB, locala.mOE)) || (!s.p(locala.mOC, locala.mOF)) || (!s.p(locala.mOD, locala.mOG)))
                {
                  Log.i(locala.TAG, "xp2p Wrapper start setInfo");
                  XNet.setInfo(locala.mOB, locala.mOC, locala.mOD);
                  locala.mOE = locala.mOB;
                  locala.mOF = locala.mOC;
                  locala.mOG = locala.mOD;
                }
                Log.i(locala.TAG, "xp2p Wrapper updateP2pService enableUpload:" + j + " enableDownload:" + i + " p2pMaxLoad:" + locala.mOx + " p2pMaxBufferSize:" + locala.mOy + " isOnWifi:" + bool + " debugLog:" + locala.mOw);
                AppMethodBeat.o(247889);
                return;
                j = 0;
                break;
                i = 0;
                break label469;
                j = 0;
                break label475;
                i = 0;
                break label482;
                paramAnonymousMessage = localy;
                Log.i(locala.TAG, "xp2p Wrapper switch error, statusCode: " + k + " url: " + (String)localObject3);
              }
              if (paramAnonymousMessage.what == a.j(this.mPh))
              {
                a.k(this.mPh).stopTimer();
                a.k(this.mPh).startTimer(0L, 20000L);
                AppMethodBeat.o(247889);
                return;
              }
              if (paramAnonymousMessage.what == a.l(this.mPh)) {
                a.k(this.mPh).stopTimer();
              }
              AppMethodBeat.o(247889);
              return;
            }
          }
        });
        dz(MMApplicationContext.getContext());
      }
      Log.i(this.TAG, s.X("xp2p Wrapper init ", Boolean.valueOf(enableP2p)));
      AppMethodBeat.o(247891);
      return;
    }
  }
  
  static String A(InputStream paramInputStream)
  {
    AppMethodBeat.i(247922);
    paramInputStream = new Scanner(paramInputStream, "UTF-8").useDelimiter("\\A");
    if (paramInputStream.hasNext())
    {
      paramInputStream = paramInputStream.next();
      s.s(paramInputStream, "s.next()");
      AppMethodBeat.o(247922);
      return paramInputStream;
    }
    AppMethodBeat.o(247922);
    return "";
  }
  
  private static final boolean a(a parama)
  {
    AppMethodBeat.i(247943);
    s.u(parama, "this$0");
    if ((!enableP2p) || (parama.mOs == 0) || (parama.mOH == null)) {
      Log.i(parama.TAG, "xp2p Wrapper doReport warning! " + enableP2p + " p2pSwitch  " + parama.mOs + " p2pStremId " + parama.mOH);
    }
    for (;;)
    {
      AppMethodBeat.o(247943);
      return true;
      localObject1 = XNet.proxyOf(parama.mOK);
      s.s(localObject1, "proxyOf(p2pDomain)");
      if ((s.p(localObject1, parama.mOK)) || (s.p(localObject1, "")))
      {
        Log.i(parama.TAG, s.X("xp2p Wrapper doReport proxy ", localObject1));
      }
      else
      {
        str1 = s.X((String)localObject1, "stat?xresid=" + parama.mOH + "&token=" + parama.mOJ);
        localObject1 = null;
      }
      for (;;)
      {
        try
        {
          localy = d.a(str1, null);
          if (localy == null) {
            continue;
          }
          localObject1 = localy;
          localy.xx(10000);
          localObject1 = localy;
          localy.xy(10000);
          localObject1 = localy;
          localy.connect();
          localObject1 = localy;
          i = localy.getResponseCode();
          if (i != 200) {
            continue;
          }
          localObject1 = localy;
          localObject2 = localy.getInputStream();
          localObject1 = localy;
          s.s(localObject2, "con.getInputStream()");
          localObject1 = localy;
          str2 = A((InputStream)localObject2);
          localObject1 = localy;
          ((InputStream)localObject2).close();
          localObject1 = localy;
        }
        catch (Exception localException)
        {
          y localy;
          int i;
          Object localObject2;
          String str2;
          Object localObject3;
          long l2;
          long l3;
          long l8;
          long l9;
          long l10;
          long l11;
          long l12;
          String str3;
          String str4;
          String str5;
          long l4;
          long l5;
          long l6;
          long l7;
          long l13;
          String str6;
          String str7;
          String str8;
          String str9;
          long l14;
          long l1;
          Log.printErrStackTrace(parama.TAG, (Throwable)localException, "", new Object[0]);
          Log.e(parama.TAG, s.X("xp2p Wrapper getStat error!!! ", str1));
          continue;
          localObject1 = localException;
          Log.i(parama.TAG, "xp2p Wrapper getStat error, statusCode: " + i + " url: " + str1);
          localObject1 = localException;
          continue;
          localObject1 = localException;
          Log.i(parama.TAG, s.X("xp2p Wrapper getStat error, connection empty! ", str1));
          localObject1 = localException;
          continue;
        }
        try
        {
          localObject3 = new JSONObject(str2).getJSONObject("flow");
          localObject1 = localy;
          l2 = ((JSONObject)localObject3).optLong("p2pBytes", 0L);
          localObject1 = localy;
          l3 = ((JSONObject)localObject3).optLong("cdnBytes", 0L);
          localObject1 = localy;
          localObject2 = ((JSONObject)localObject3).optString("nat_str", "");
          localObject1 = localy;
          l8 = ((JSONObject)localObject3).optLong("p2p_upload_switch", 0L);
          localObject1 = localy;
          l9 = ((JSONObject)localObject3).optLong("p2p_download_switch", 0L);
          localObject1 = localy;
          l10 = ((JSONObject)localObject3).optLong("connected", 0L);
          localObject1 = localy;
          l11 = ((JSONObject)localObject3).optLong("standby_c", 0L);
          localObject1 = localy;
          l12 = ((JSONObject)localObject3).optLong("load", 0L);
          localObject1 = localy;
          str3 = ((JSONObject)localObject3).optString("isp", "");
          localObject1 = localy;
          str4 = ((JSONObject)localObject3).optString("url", "");
          localObject1 = localy;
          str5 = ((JSONObject)localObject3).optString("xs_full_url", "");
          localObject1 = localy;
          l4 = ((JSONObject)localObject3).optLong("xs_4xx_status", 0L);
          localObject1 = localy;
          l5 = ((JSONObject)localObject3).optLong("total_pieces", 0L);
          localObject1 = localy;
          l6 = ((JSONObject)localObject3).optLong("verify_pieces", 0L);
          localObject1 = localy;
          l7 = ((JSONObject)localObject3).optLong("invalid_pieces", 0L);
          localObject1 = localy;
          l13 = ((JSONObject)localObject3).optLong("tag_missed_invalid_pieces", 0L);
          localObject1 = localy;
          str6 = ((JSONObject)localObject3).optString("uuid", "");
          localObject1 = localy;
          str7 = ((JSONObject)localObject3).optString("pieceid", "");
          localObject1 = localy;
          str8 = ((JSONObject)localObject3).optString("send", "");
          localObject1 = localy;
          str9 = ((JSONObject)localObject3).optString("recv", "");
          localObject1 = localy;
          l14 = ((JSONObject)localObject3).optLong("abnormal_ts_count", 0L);
          l1 = 0L;
          localObject1 = localy;
          if (l2 >= parama.mOW)
          {
            localObject1 = localy;
            l1 = l2 - parama.mOW;
            localObject1 = localy;
            parama.mOW = l2;
          }
          l2 = 0L;
          localObject1 = localy;
          if (l3 >= parama.mOX)
          {
            localObject1 = localy;
            l2 = l3 - parama.mOX;
            localObject1 = localy;
            parama.mOX = l3;
          }
          l3 = 0L;
          localObject1 = localy;
          if (l4 >= parama.mOY)
          {
            localObject1 = localy;
            l3 = l4 - parama.mOY;
            localObject1 = localy;
            parama.mOY = l4;
          }
          l4 = 0L;
          localObject1 = localy;
          if (l5 >= parama.mOZ)
          {
            localObject1 = localy;
            l4 = l5 - parama.mOZ;
            localObject1 = localy;
            parama.mOZ = l5;
          }
          l5 = 0L;
          localObject1 = localy;
          if (l6 >= parama.mPa)
          {
            localObject1 = localy;
            l5 = l6 - parama.mPa;
            localObject1 = localy;
            parama.mPa = l6;
          }
          l6 = 0L;
          localObject1 = localy;
          if (l7 >= parama.mPb)
          {
            localObject1 = localy;
            l6 = l7 - parama.mPb;
            localObject1 = localy;
            parama.mPb = l7;
          }
          l7 = 0L;
          localObject1 = localy;
          if (l13 >= parama.mPc)
          {
            localObject1 = localy;
            l7 = l13 - parama.mPc;
            localObject1 = localy;
            parama.mPc = l13;
          }
          localObject1 = localy;
          localObject3 = new eq();
          localObject1 = localy;
          ((eq)localObject3).iDB = parama.liveId;
          localObject1 = localy;
          ((eq)localObject3).iEH = ((eq)localObject3).F("finderNickname", parama.mPd, true);
          localObject1 = localy;
          ((eq)localObject3).iEI = l1;
          localObject1 = localy;
          ((eq)localObject3).iEJ = l2;
          localObject1 = localy;
          ((eq)localObject3).iEK = ((eq)localObject3).F("natType", (String)localObject2, true);
          localObject1 = localy;
          ((eq)localObject3).iEL = l8;
          localObject1 = localy;
          ((eq)localObject3).iEM = l9;
          localObject1 = localy;
          ((eq)localObject3).iEN = l10;
          localObject1 = localy;
          ((eq)localObject3).iEO = l11;
          localObject1 = localy;
          ((eq)localObject3).iEP = l12;
          localObject1 = localy;
          ((eq)localObject3).iEQ = ((eq)localObject3).F("isp", str3, true);
          localObject1 = localy;
          ((eq)localObject3).iER = ((eq)localObject3).F("url", str4, true);
          localObject1 = localy;
          ((eq)localObject3).iES = ((eq)localObject3).F("full_url", str5, true);
          localObject1 = localy;
          ((eq)localObject3).iET = l3;
          localObject1 = localy;
          ((eq)localObject3).iEU = l5;
          localObject1 = localy;
          ((eq)localObject3).iEV = l6;
          localObject1 = localy;
          ((eq)localObject3).iEW = l7;
          localObject1 = localy;
          ((eq)localObject3).iEX = ((eq)localObject3).F("uuid", str6, true);
          localObject1 = localy;
          ((eq)localObject3).iEY = ((eq)localObject3).F("pieceid", str7, true);
          localObject1 = localy;
          ((eq)localObject3).iEZ = ((eq)localObject3).F("send", str8, true);
          localObject1 = localy;
          ((eq)localObject3).iFa = ((eq)localObject3).F("recv", str9, true);
          localObject1 = localy;
          ((eq)localObject3).iFb = l14;
          localObject1 = localy;
          ((eq)localObject3).iFc = l4;
          localObject1 = localy;
          ((eq)localObject3).bMH();
        }
        catch (JSONException localJSONException)
        {
          localObject1 = localy;
          Log.printErrStackTrace(parama.TAG, (Throwable)localJSONException, "", new Object[0]);
          localObject1 = localy;
          Log.e(parama.TAG, "xp2p Wrapper parseJsonAndReport error!");
        }
      }
      localObject1 = localy;
      Log.i(parama.TAG, "xp2p Wrapper getStat dataStr: " + str2 + " url: " + str1);
      localObject1 = localy;
      if (localObject1 != null) {
        ((y)localObject1).disconnect();
      }
    }
  }
  
  private HandlerThread bey()
  {
    AppMethodBeat.i(247897);
    HandlerThread localHandlerThread = this.mHandlerThread;
    if (localHandlerThread != null)
    {
      AppMethodBeat.o(247897);
      return localHandlerThread;
    }
    s.bIx("mHandlerThread");
    AppMethodBeat.o(247897);
    return null;
  }
  
  public static boolean bez()
  {
    return enableP2p;
  }
  
  private void dz(Context arg1)
  {
    AppMethodBeat.i(247912);
    Log.i(this.TAG, "xp2p Wrapper startP2pService begin");
    this.mContext = ???;
    ??? = this.mOP;
    if (??? != null) {
      ???.sendEmptyMessage(this.mOQ);
    }
    if (this.mOO) {
      synchronized (this.lock)
      {
        this.lock.wait(300L);
        Log.i(this.TAG, "xp2p Wrapper startP2pService wait end");
        ah localah = ah.aiuX;
        AppMethodBeat.o(247912);
        return;
      }
    }
    AppMethodBeat.o(247912);
  }
  
  public final void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, String paramString1, String paramString2, String paramString3, int paramInt9)
  {
    AppMethodBeat.i(248100);
    s.u(paramContext, "context");
    s.u(paramString1, "p2pAppid");
    s.u(paramString2, "p2pKey");
    s.u(paramString3, "p2pSecret");
    if (!enableP2p)
    {
      Log.i(this.TAG, s.X("xp2p Wrapper updateP2pSwitches: ", Boolean.valueOf(enableP2p)));
      AppMethodBeat.o(248100);
      return;
    }
    if ((this.mOs != 0) && (this.mOs == 0)) {
      this.mOM = true;
    }
    this.mOs = paramInt1;
    this.mOt = paramInt2;
    this.mOu = paramInt3;
    this.mOv = paramInt4;
    this.mOw = paramInt5;
    this.mOx = paramInt6;
    this.mOy = paramInt7;
    this.mOz = paramInt8;
    this.mOB = paramString1;
    this.mOC = paramString2;
    this.mOD = paramString3;
    this.mOA = paramInt9;
    if ((s.p(paramString1, "")) || (s.p(paramString2, "")) || (s.p(paramString3, "")))
    {
      Log.i(this.TAG, "xp2p Wrapper update p2p params Error: " + paramString1 + ", " + paramString2 + ", " + paramString3);
      AppMethodBeat.o(248100);
      return;
    }
    dz(paramContext);
    if ((this.mOM) || (this.mON))
    {
      paramContext = this.mOP;
      if (paramContext != null) {
        paramContext.sendEmptyMessage(this.mOS);
      }
      this.mOM = false;
    }
    Log.i(this.TAG, "xp2p Wrapper update p2p params: " + this.mOs + ", " + this.mOt + ", " + this.mOu + ", " + this.mOv + ", " + this.mOw + ", " + this.mOx + ", " + this.mOy + ' ' + this.mOz + ' ' + paramInt9);
    AppMethodBeat.o(248100);
  }
  
  public final void beA()
  {
    AppMethodBeat.i(248078);
    if ((!enableP2p) || (this.mOs == 0))
    {
      AppMethodBeat.o(248078);
      return;
    }
    this.mOW = 0L;
    this.mOX = 0L;
    this.mOY = 0L;
    this.mOZ = 0L;
    this.mPa = 0L;
    this.mPb = 0L;
    this.mPc = 0L;
    Log.e(this.TAG, "xp2p Wrapper onResetP2pStat");
    AppMethodBeat.o(248078);
  }
  
  public final String g(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(248091);
    s.u(paramString1, "oldUrl");
    if ((!enableP2p) || (this.mOs == 0))
    {
      AppMethodBeat.o(248091);
      return paramString1;
    }
    String str = XNet.proxyOf(this.mOK);
    s.s(str, "proxyOf(p2pDomain)");
    if ((s.p(str, this.mOK)) || (s.p(str, "")))
    {
      Log.i(this.TAG, s.X("xp2p Wrapper start to p2p play, use old url proxy ", str));
      AppMethodBeat.o(248091);
      return paramString1;
    }
    Object localObject;
    if (paramBoolean)
    {
      localObject = (CharSequence)paramString1;
      localObject = new k("^https?://").e((CharSequence)localObject, str);
    }
    for (this.mOI = ((String)localObject + "&xhost=" + this.mOL + "&xscheme=https");; this.mOI = ((String)localObject + "&xhost=" + this.mOL))
    {
      this.mOH = paramString2;
      paramString2 = this.mOP;
      if (paramString2 != null) {
        paramString2.sendEmptyMessage(this.mOS);
      }
      this.mON = true;
      paramString2 = this.mOP;
      if (paramString2 != null) {
        paramString2.sendEmptyMessage(this.mOT);
      }
      Log.i(this.TAG, "xp2p Wrapper start to p2p play, proxy:" + str + " url:" + this.mOI + " , oldUrl: " + paramString1 + " streamId:" + this.mOH + " bHttps:" + paramBoolean);
      paramString1 = this.mOI;
      AppMethodBeat.o(248091);
      return paramString1;
      localObject = (CharSequence)paramString1;
      localObject = new k("^http?://").e((CharSequence)localObject, str);
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(248071);
    Handler localHandler = this.mOP;
    if (localHandler != null) {
      localHandler.sendEmptyMessage(this.mOU);
    }
    localHandler = this.mOP;
    if (localHandler != null) {
      localHandler.sendEmptyMessage(this.mOR);
    }
    this.mON = false;
    this.mOH = null;
    this.mOs = 0;
    this.mOt = 0;
    this.mOu = 0;
    this.mOv = 0;
    this.mOw = 0;
    this.mOx = 0;
    this.mOy = 0;
    this.mOz = 0;
    this.mOA = 1;
    this.mOM = false;
    this.liveId = 0L;
    this.mPd = "";
    this.mOB = "";
    this.mOC = "";
    this.mOD = "";
    this.mOE = "";
    this.mOF = "";
    this.mOG = "";
    beA();
    Log.i(this.TAG, "xp2p Wrapper destroy");
    AppMethodBeat.o(248071);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/live/core/core/p2p/MMXp2pWrapper$onNWChange$1", "Lcom/tencent/mm/network/IOnNetworkChange_AIDL$Stub;", "onNetworkChange", "", "st", "", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends p.a
  {
    c(a parama) {}
    
    public final void onNetworkChange(int paramInt)
    {
      AppMethodBeat.i(247852);
      Handler localHandler = this.mPh.mOP;
      if (localHandler != null) {
        localHandler.sendEmptyMessage(a.c(this.mPh));
      }
      Log.i(a.d(this.mPh), "xp2p Wrapper onNetworkChange");
      AppMethodBeat.o(247852);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.live.core.core.b.a
 * JD-Core Version:    0.7.0.1
 */