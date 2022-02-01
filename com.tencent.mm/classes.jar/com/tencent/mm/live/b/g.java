package com.tencent.mm.live.b;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.lf;
import com.tencent.mm.live.core.core.b.d;
import com.tencent.mm.model.al;
import com.tencent.mm.model.w;
import com.tencent.mm.n.e;
import com.tencent.mm.protocal.protobuf.bvi;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.protocal.protobuf.bvq;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ac;
import d.g.b.ad;
import d.g.b.p;
import d.l;
import d.o;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/LiveDataManager;", "", "()V", "TAG", "", "anchorLinkSuccessCountPerShow", "", "getAnchorLinkSuccessCountPerShow", "()I", "setAnchorLinkSuccessCountPerShow", "(I)V", "anchorStatus", "Lcom/tencent/mm/protocal/protobuf/LiveAnchorStatus;", "getAnchorStatus", "()Lcom/tencent/mm/protocal/protobuf/LiveAnchorStatus;", "setAnchorStatus", "(Lcom/tencent/mm/protocal/protobuf/LiveAnchorStatus;)V", "anchorUserName", "getAnchorUserName", "()Ljava/lang/String;", "setAnchorUserName", "(Ljava/lang/String;)V", "value", "audienceCountMax", "getAudienceCountMax", "setAudienceCountMax", "callingMicNickname", "getCallingMicNickname", "setCallingMicNickname", "callingMicUsername", "getCallingMicUsername", "setCallingMicUsername", "enterFromScene", "getEnterFromScene", "setEnterFromScene", "hasChangeVideoModePerLinkMic", "", "getHasChangeVideoModePerLinkMic", "()Z", "setHasChangeVideoModePerLinkMic", "(Z)V", "isClickStartLive", "setClickStartLive", "isForeigner", "setForeigner", "isLiveNameChanged", "setLiveNameChanged", "isManualClosed", "setManualClosed", "isStartLiveReport", "setStartLiveReport", "isVerifyChecked", "setVerifyChecked", "isVerifyUiShow", "setVerifyUiShow", "isVisitorReport", "setVisitorReport", "lastOrientation", "getLastOrientation", "setLastOrientation", "linkMicRequestCount", "getLinkMicRequestCount", "setLinkMicRequestCount", "liveCookies", "", "getLiveCookies", "()[B", "setLiveCookies", "([B)V", "liveDynamicConfig", "Lcom/tencent/mm/live/model/LiveDataManager$LiveDynamicConfig;", "getLiveDynamicConfig", "()Lcom/tencent/mm/live/model/LiveDataManager$LiveDynamicConfig;", "setLiveDynamicConfig", "(Lcom/tencent/mm/live/model/LiveDataManager$LiveDynamicConfig;)V", "liveFaceVerifyInfo", "Lcom/tencent/mm/live/model/LiveDataManager$LiveFaceVerifyInfo;", "getLiveFaceVerifyInfo", "()Lcom/tencent/mm/live/model/LiveDataManager$LiveFaceVerifyInfo;", "setLiveFaceVerifyInfo", "(Lcom/tencent/mm/live/model/LiveDataManager$LiveFaceVerifyInfo;)V", "liveInfo", "Lcom/tencent/mm/protocal/protobuf/LiveInfo;", "getLiveInfo", "()Lcom/tencent/mm/protocal/protobuf/LiveInfo;", "setLiveInfo", "(Lcom/tencent/mm/protocal/protobuf/LiveInfo;)V", "liveRoomModel", "Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "getLiveRoomModel", "()Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "setLiveRoomModel", "(Lcom/tencent/mm/live/core/core/model/LiveRoomModel;)V", "liveSdkInfo", "Lcom/tencent/mm/protocal/protobuf/LiveSdkInfo;", "getLiveSdkInfo", "()Lcom/tencent/mm/protocal/protobuf/LiveSdkInfo;", "setLiveSdkInfo", "(Lcom/tencent/mm/protocal/protobuf/LiveSdkInfo;)V", "liveSmallWindowInfo", "Lcom/tencent/mm/live/model/LiveDataManager$LiveSmallWindowInfo;", "getLiveSmallWindowInfo", "()Lcom/tencent/mm/live/model/LiveDataManager$LiveSmallWindowInfo;", "setLiveSmallWindowInfo", "(Lcom/tencent/mm/live/model/LiveDataManager$LiveSmallWindowInfo;)V", "liveStatus", "Lcom/tencent/mm/live/model/LiveDataManager$LiveStatus;", "getLiveStatus", "()Lcom/tencent/mm/live/model/LiveDataManager$LiveStatus;", "setLiveStatus", "(Lcom/tencent/mm/live/model/LiveDataManager$LiveStatus;)V", "mCheckDeviceLsn", "com/tencent/mm/live/model/LiveDataManager$mCheckDeviceLsn$1", "Lcom/tencent/mm/live/model/LiveDataManager$mCheckDeviceLsn$1;", "mLastOrientation", "getMLastOrientation", "setMLastOrientation", "mStartLinkTimes", "", "getMStartLinkTimes", "()J", "setMStartLinkTimes", "(J)V", "micPmkExpire", "getMicPmkExpire", "setMicPmkExpire", "msgFilterTime", "getMsgFilterTime", "setMsgFilterTime", "msgList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/view/adapter/CommentData;", "Lkotlin/collections/ArrayList;", "getMsgList", "()Ljava/util/ArrayList;", "setMsgList", "(Ljava/util/ArrayList;)V", "onlineHeadImgList", "getOnlineHeadImgList", "setOnlineHeadImgList", "shareRoomList", "Ljava/util/HashMap;", "Lkotlin/Pair;", "Lkotlin/collections/HashMap;", "getShareRoomList", "()Ljava/util/HashMap;", "setShareRoomList", "(Ljava/util/HashMap;)V", "sysMsgManager", "Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager;", "getSysMsgManager", "()Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager;", "setSysMsgManager", "(Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager;)V", "thumbUrl", "getThumbUrl", "setThumbUrl", "visitorCommentCount", "getVisitorCommentCount", "setVisitorCommentCount", "visitorConnectCount", "getVisitorConnectCount", "setVisitorConnectCount", "visitorConnectReqCount", "getVisitorConnectReqCount", "setVisitorConnectReqCount", "visitorEnterErrorCode", "getVisitorEnterErrorCode", "setVisitorEnterErrorCode", "visitorEnterMemberCount", "getVisitorEnterMemberCount", "setVisitorEnterMemberCount", "visitorLikeCount", "getVisitorLikeCount", "setVisitorLikeCount", "wechatRoomId", "getWechatRoomId", "setWechatRoomId", "displayLiveName", "displayUsername", "username", "formatAnchorLikeCount", "formatLikeCount", "liveError", "", "liveFinish", "liveStart", "preOnCreate", "release", "resetData", "resetLiveFaceVerifyInfo", "LiveDynamicConfig", "LiveFaceVerifyInfo", "LiveSmallWindowInfo", "LiveStatus", "plugin-logic_release"})
public final class g
{
  private static final String TAG = "MicroMsg.LiveDataManager";
  private static int cpv;
  private static String gPn;
  private static d gQA;
  private static g.b gQB;
  private static g.a gQC;
  private static c gQD;
  private static boolean gQE;
  private static boolean gQF;
  private static boolean gQG;
  private static boolean gQH;
  private static boolean gQI;
  private static int gQJ;
  private static int gQK;
  private static int gQL;
  private static int gQM;
  private static int gQN;
  private static int gQO;
  private static int gQP;
  private static int gQQ;
  private static boolean gQR;
  private static int gQS;
  private static int gQT;
  private static int gQU;
  private static long gQV;
  private static boolean gQW;
  private static com.tencent.mm.live.b.b.a gQX;
  private static final e gQY;
  public static final g gQZ;
  private static ArrayList<String> gQl;
  private static HashMap<String, o<ArrayList<String>, Integer>> gQm;
  private static ArrayList<com.tencent.mm.live.view.a.a> gQn;
  private static byte[] gQo;
  private static bvk gQp;
  private static bvq gQq;
  private static String gQr;
  private static int gQs;
  private static d gQt;
  private static long gQu;
  private static bvi gQv;
  private static boolean gQw;
  private static String gQx;
  private static String gQy;
  private static boolean gQz;
  private static String thumbUrl;
  
  static
  {
    AppMethodBeat.i(215697);
    gQZ = new g();
    TAG = "MicroMsg.LiveDataManager";
    gPn = "";
    gQl = new ArrayList();
    gQm = new HashMap();
    gQn = new ArrayList();
    gQp = new bvk();
    gQr = "";
    gQv = new bvi();
    cpv = -1;
    gQx = "";
    gQy = "";
    gQA = new d((byte)0);
    gQB = new g.b();
    gQC = new g.a((byte)0);
    gQD = new c();
    gQM = -1;
    gQX = new com.tencent.mm.live.b.b.a();
    e locale = new e();
    gQY = locale;
    locale.alive();
    AppMethodBeat.o(215697);
  }
  
  public static void P(byte[] paramArrayOfByte)
  {
    gQo = paramArrayOfByte;
  }
  
  public static void Zq()
  {
    AppMethodBeat.i(215695);
    ae.m(TAG, "resetData", new Object[0]);
    gQu = 0L;
    gPn = "";
    gQl.clear();
    gQm.clear();
    gQo = null;
    gQp = new bvk();
    gQq = null;
    thumbUrl = null;
    com.tencent.mm.live.b.b.a locala = gQX;
    locala.gTp = null;
    locala.gTq = null;
    locala.gTr = null;
    locala.gTs = null;
    locala.gTt = null;
    locala.gTu = null;
    locala.gTv = null;
    locala.gTx = null;
    locala.gTw.clear();
    locala.gTy = "";
    locala.gTz = "";
    gQn.clear();
    gQr = "";
    gQs = 0;
    gQt = null;
    gQv = new bvi();
    gQw = false;
    cpv = -1;
    gQx = "";
    gQy = "";
    gQC = new g.a((byte)0);
    gQD = new c();
    gQz = false;
    gQA = new d((byte)0);
    gQB = new g.b();
    AppMethodBeat.o(215695);
  }
  
  public static void a(bvi parambvi)
  {
    AppMethodBeat.i(215687);
    p.h(parambvi, "<set-?>");
    gQv = parambvi;
    AppMethodBeat.o(215687);
  }
  
  public static void a(bvk parambvk)
  {
    AppMethodBeat.i(215685);
    p.h(parambvk, "<set-?>");
    gQp = parambvk;
    AppMethodBeat.o(215685);
  }
  
  public static void a(bvq parambvq)
  {
    gQq = parambvq;
  }
  
  public static String anC()
  {
    return gPn;
  }
  
  public static ArrayList<String> anD()
  {
    return gQl;
  }
  
  public static HashMap<String, o<ArrayList<String>, Integer>> anE()
  {
    return gQm;
  }
  
  public static ArrayList<com.tencent.mm.live.view.a.a> anF()
  {
    return gQn;
  }
  
  public static byte[] anG()
  {
    return gQo;
  }
  
  public static bvk anH()
  {
    return gQp;
  }
  
  public static bvq anI()
  {
    return gQq;
  }
  
  public static String anJ()
  {
    return gQr;
  }
  
  public static int anK()
  {
    return gQs;
  }
  
  public static d anL()
  {
    return gQt;
  }
  
  public static long anM()
  {
    return gQu;
  }
  
  public static bvi anN()
  {
    return gQv;
  }
  
  public static boolean anO()
  {
    return gQw;
  }
  
  public static void anP()
  {
    gQw = true;
  }
  
  public static int anQ()
  {
    return cpv;
  }
  
  public static String anR()
  {
    return gQx;
  }
  
  public static String anS()
  {
    return gQy;
  }
  
  public static boolean anT()
  {
    return gQz;
  }
  
  public static void anU()
  {
    gQz = true;
  }
  
  public static d anV()
  {
    return gQA;
  }
  
  public static g.b anW()
  {
    return gQB;
  }
  
  public static g.a anX()
  {
    return gQC;
  }
  
  public static c anY()
  {
    return gQD;
  }
  
  public static boolean anZ()
  {
    return gQE;
  }
  
  public static boolean aoa()
  {
    return gQF;
  }
  
  public static boolean aob()
  {
    return gQG;
  }
  
  public static boolean aoc()
  {
    return gQH;
  }
  
  public static boolean aod()
  {
    return gQI;
  }
  
  public static int aoe()
  {
    return gQJ;
  }
  
  public static int aof()
  {
    return gQK;
  }
  
  public static int aog()
  {
    return gQL;
  }
  
  public static int aoh()
  {
    return gQM;
  }
  
  public static int aoi()
  {
    return gQN;
  }
  
  public static int aoj()
  {
    return gQO;
  }
  
  public static int aok()
  {
    return gQP;
  }
  
  public static int aol()
  {
    return gQQ;
  }
  
  public static boolean aom()
  {
    return gQR;
  }
  
  public static int aon()
  {
    return gQS;
  }
  
  public static int aoo()
  {
    return gQT;
  }
  
  public static int aop()
  {
    return gQU;
  }
  
  public static long aoq()
  {
    AppMethodBeat.i(215690);
    long l = (System.currentTimeMillis() - gQV) / 1000L;
    AppMethodBeat.o(215690);
    return l;
  }
  
  public static boolean aor()
  {
    return gQW;
  }
  
  public static com.tencent.mm.live.b.b.a aos()
  {
    return gQX;
  }
  
  public static String aot()
  {
    AppMethodBeat.i(215691);
    if (gQp.GTx <= 0)
    {
      localObject = ak.getContext();
      p.g(localObject, "MMApplicationContext.getContext()");
      localObject = ((Context)localObject).getResources().getString(2131766618);
      p.g(localObject, "MMApplicationContext.get…ing.live_like_count_zero)");
      AppMethodBeat.o(215691);
      return localObject;
    }
    if (gQp.GTx < 10000)
    {
      int i = gQp.GTx;
      AppMethodBeat.o(215691);
      return String.valueOf(i);
    }
    if (gQp.GTx % 10000 >= 1000)
    {
      localObject = ad.Njc;
      localObject = ak.getContext();
      p.g(localObject, "MMApplicationContext.getContext()");
      localObject = ((Context)localObject).getResources().getString(2131766616);
      p.g(localObject, "MMApplicationContext.get…g.live_like_count_format)");
      localObject = String.format((String)localObject, Arrays.copyOf(new Object[] { Float.valueOf(gQp.GTx / 10000.0F) }, 1));
      p.g(localObject, "java.lang.String.format(format, *args)");
      AppMethodBeat.o(215691);
      return localObject;
    }
    Object localObject = ad.Njc;
    localObject = ak.getContext();
    p.g(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getResources().getString(2131766617);
    p.g(localObject, "MMApplicationContext.get…ve_like_count_int_format)");
    localObject = String.format((String)localObject, Arrays.copyOf(new Object[] { Integer.valueOf(gQp.GTx / 10000) }, 1));
    p.g(localObject, "java.lang.String.format(format, *args)");
    AppMethodBeat.o(215691);
    return localObject;
  }
  
  public static String aou()
  {
    AppMethodBeat.i(215692);
    if (gQp.GTx <= 0)
    {
      AppMethodBeat.o(215692);
      return "0";
    }
    if (gQp.GTx < 10000)
    {
      int i = gQp.GTx;
      AppMethodBeat.o(215692);
      return String.valueOf(i);
    }
    if (gQp.GTx % 10000 >= 1000)
    {
      localObject = ad.Njc;
      localObject = ak.getContext();
      p.g(localObject, "MMApplicationContext.getContext()");
      localObject = ((Context)localObject).getResources().getString(2131766616);
      p.g(localObject, "MMApplicationContext.get…g.live_like_count_format)");
      localObject = String.format((String)localObject, Arrays.copyOf(new Object[] { Float.valueOf(gQp.GTx / 10000.0F) }, 1));
      p.g(localObject, "java.lang.String.format(format, *args)");
      AppMethodBeat.o(215692);
      return localObject;
    }
    Object localObject = ad.Njc;
    localObject = ak.getContext();
    p.g(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getResources().getString(2131766617);
    p.g(localObject, "MMApplicationContext.get…ve_like_count_int_format)");
    localObject = String.format((String)localObject, Arrays.copyOf(new Object[] { Integer.valueOf(gQp.GTx / 10000) }, 1));
    p.g(localObject, "java.lang.String.format(format, *args)");
    AppMethodBeat.o(215692);
    return localObject;
  }
  
  public static String aov()
  {
    AppMethodBeat.i(215693);
    String str2;
    String str1;
    if (bu.isNullOrNil(gQp.Gud))
    {
      str2 = gQp.Hil;
      str1 = str2;
      if (str2 == null)
      {
        AppMethodBeat.o(215693);
        return "";
      }
    }
    else
    {
      str2 = gQp.Gud;
      str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
    }
    AppMethodBeat.o(215693);
    return str1;
  }
  
  public static void aow()
  {
    gQA.gRi = true;
    gQA.gRh = false;
  }
  
  public static void aox()
  {
    gQA.gRj = true;
  }
  
  public static void aoy()
  {
    gQA.gRh = true;
    gQA.gRi = false;
  }
  
  public static void aoz()
  {
    boolean bool2 = true;
    AppMethodBeat.i(215696);
    int i = bu.getInt(com.tencent.mm.n.g.acL().getValue("MMLiveConfigBitSet"), 0);
    g.a locala = gQC;
    if (!com.tencent.mm.ac.c.cQ(i, 1))
    {
      bool1 = true;
      locala.gRa = bool1;
      locala = gQC;
      if (com.tencent.mm.ac.c.cQ(i, 2)) {
        break label111;
      }
      bool1 = true;
      label55:
      locala.gRb = bool1;
      locala = gQC;
      if (com.tencent.mm.ac.c.cQ(i, 4)) {
        break label116;
      }
      bool1 = true;
      label74:
      locala.gRc = bool1;
      locala = gQC;
      if (com.tencent.mm.ac.c.cQ(i, 8)) {
        break label121;
      }
    }
    label111:
    label116:
    label121:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      locala.gRd = bool1;
      AppMethodBeat.o(215696);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label55;
      bool1 = false;
      break label74;
    }
  }
  
  public static void b(d paramd)
  {
    gQt = paramd;
  }
  
  public static void dL(boolean paramBoolean)
  {
    gQE = paramBoolean;
  }
  
  public static void dM(boolean paramBoolean)
  {
    gQF = paramBoolean;
  }
  
  public static void dN(boolean paramBoolean)
  {
    gQG = paramBoolean;
  }
  
  public static void dO(boolean paramBoolean)
  {
    gQH = paramBoolean;
  }
  
  public static void dP(boolean paramBoolean)
  {
    gQI = paramBoolean;
  }
  
  public static void dQ(boolean paramBoolean)
  {
    gQR = paramBoolean;
  }
  
  public static void dR(boolean paramBoolean)
  {
    gQW = paramBoolean;
  }
  
  public static void nA(int paramInt)
  {
    gQL = paramInt;
  }
  
  public static void nB(int paramInt)
  {
    gQM = paramInt;
  }
  
  public static void nC(int paramInt)
  {
    gQN = paramInt;
  }
  
  public static void nD(int paramInt)
  {
    gQO = paramInt;
  }
  
  public static void nE(int paramInt)
  {
    gQP = paramInt;
  }
  
  public static void nF(int paramInt)
  {
    gQQ = paramInt;
  }
  
  public static void nG(int paramInt)
  {
    gQS = paramInt;
  }
  
  public static void nH(int paramInt)
  {
    gQT = paramInt;
  }
  
  public static void nI(int paramInt)
  {
    gQU = paramInt;
  }
  
  public static void nw(int paramInt)
  {
    gQs = paramInt;
  }
  
  public static void nx(int paramInt)
  {
    cpv = paramInt;
  }
  
  public static void ny(int paramInt)
  {
    if (gQJ < paramInt) {
      gQJ = paramInt;
    }
    while (paramInt != -1) {
      return;
    }
    gQJ = 0;
  }
  
  public static void nz(int paramInt)
  {
    gQK = paramInt;
  }
  
  public static void ru(long paramLong)
  {
    gQu = paramLong;
  }
  
  public static void rv(long paramLong)
  {
    gQV = paramLong;
  }
  
  public static void yn(String paramString)
  {
    AppMethodBeat.i(215684);
    p.h(paramString, "<set-?>");
    gPn = paramString;
    AppMethodBeat.o(215684);
  }
  
  public static void yo(String paramString)
  {
    thumbUrl = paramString;
  }
  
  public static void yp(String paramString)
  {
    AppMethodBeat.i(215686);
    p.h(paramString, "<set-?>");
    gQr = paramString;
    AppMethodBeat.o(215686);
  }
  
  public static void yq(String paramString)
  {
    AppMethodBeat.i(215688);
    p.h(paramString, "<set-?>");
    gQx = paramString;
    AppMethodBeat.o(215688);
  }
  
  public static void yr(String paramString)
  {
    AppMethodBeat.i(215689);
    p.h(paramString, "<set-?>");
    gQy = paramString;
    AppMethodBeat.o(215689);
  }
  
  public static String ys(String paramString)
  {
    AppMethodBeat.i(215694);
    if (paramString == null)
    {
      AppMethodBeat.o(215694);
      return "";
    }
    String str = w.zQ(paramString);
    Object localObject = str;
    if (bu.isNullOrNil(str))
    {
      localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class);
      p.g(localObject, "MMKernel.service(IChatroomService::class.java)");
      localObject = ((com.tencent.mm.plugin.chatroom.a.c)localObject).azP().Bx(gPn);
      if (localObject != null) {
        break label90;
      }
      localObject = w.zP(paramString);
    }
    for (;;)
    {
      p.g(localObject, "result");
      AppMethodBeat.o(215694);
      return localObject;
      label90:
      str = ((ac)localObject).zP(paramString);
      localObject = str;
      if (bu.isNullOrNil(str)) {
        localObject = w.zP(paramString);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/LiveDataManager$LiveSmallWindowInfo;", "", "userId", "", "streamType", "", "width", "height", "(Ljava/lang/String;III)V", "getHeight", "()I", "setHeight", "(I)V", "getStreamType", "setStreamType", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "getWidth", "setWidth", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "isLandscape", "toString", "plugin-logic_release"})
  public static final class c
  {
    public int height;
    public int streamType;
    public String userId;
    public int width;
    
    private c(String paramString)
    {
      AppMethodBeat.i(215677);
      this.userId = paramString;
      this.streamType = 0;
      this.width = 0;
      this.height = 0;
      AppMethodBeat.o(215677);
    }
    
    public final boolean aoA()
    {
      return this.width > this.height;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(215681);
      if (this != paramObject)
      {
        if ((paramObject instanceof c))
        {
          paramObject = (c)paramObject;
          if ((!p.i(this.userId, paramObject.userId)) || (this.streamType != paramObject.streamType) || (this.width != paramObject.width) || (this.height != paramObject.height)) {}
        }
      }
      else
      {
        AppMethodBeat.o(215681);
        return true;
      }
      AppMethodBeat.o(215681);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(215680);
      String str = this.userId;
      if (str != null) {}
      for (int i = str.hashCode();; i = 0)
      {
        int j = this.streamType;
        int k = this.width;
        int m = this.height;
        AppMethodBeat.o(215680);
        return ((i * 31 + j) * 31 + k) * 31 + m;
      }
    }
    
    public final void setUserId(String paramString)
    {
      AppMethodBeat.i(215676);
      p.h(paramString, "<set-?>");
      this.userId = paramString;
      AppMethodBeat.o(215676);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(215679);
      String str = "LiveSmallWindowInfo(userId=" + this.userId + ", streamType=" + this.streamType + ", width=" + this.width + ", height=" + this.height + ")";
      AppMethodBeat.o(215679);
      return str;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/LiveDataManager$LiveStatus;", "", "liveFinished", "", "liveStarted", "liveHasError", "liveJumpToOtherUI", "(ZZZZ)V", "getLiveFinished", "()Z", "setLiveFinished", "(Z)V", "getLiveHasError", "setLiveHasError", "getLiveJumpToOtherUI", "setLiveJumpToOtherUI", "getLiveStarted", "setLiveStarted", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "plugin-logic_release"})
  public static final class d
  {
    public boolean gRh = false;
    public boolean gRi = false;
    public boolean gRj = false;
    public boolean gRk = false;
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof d))
        {
          paramObject = (d)paramObject;
          if ((this.gRh != paramObject.gRh) || (this.gRi != paramObject.gRi) || (this.gRj != paramObject.gRj) || (this.gRk != paramObject.gRk)) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(215682);
      String str = "LiveStatus(liveFinished=" + this.gRh + ", liveStarted=" + this.gRi + ", liveHasError=" + this.gRj + ", liveJumpToOtherUI=" + this.gRk + ")";
      AppMethodBeat.o(215682);
      return str;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/live/model/LiveDataManager$mCheckDeviceLsn$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/LiveStateActionEvent;", "callback", "", "event", "plugin-logic_release"})
  public static final class e
    extends com.tencent.mm.sdk.b.c<lf>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.b.g
 * JD-Core Version:    0.7.0.1
 */