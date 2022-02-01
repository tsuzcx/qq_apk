package com.tencent.mm.live.b;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.le;
import com.tencent.mm.live.core.core.b.d;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.v;
import com.tencent.mm.n.e;
import com.tencent.mm.protocal.protobuf.buo;
import com.tencent.mm.protocal.protobuf.buq;
import com.tencent.mm.protocal.protobuf.buw;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import d.g.b.p;
import d.l;
import d.o;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/LiveDataManager;", "", "()V", "TAG", "", "anchorLinkSuccessCountPerShow", "", "getAnchorLinkSuccessCountPerShow", "()I", "setAnchorLinkSuccessCountPerShow", "(I)V", "anchorStatus", "Lcom/tencent/mm/protocal/protobuf/LiveAnchorStatus;", "getAnchorStatus", "()Lcom/tencent/mm/protocal/protobuf/LiveAnchorStatus;", "setAnchorStatus", "(Lcom/tencent/mm/protocal/protobuf/LiveAnchorStatus;)V", "anchorUserName", "getAnchorUserName", "()Ljava/lang/String;", "setAnchorUserName", "(Ljava/lang/String;)V", "value", "audienceCountMax", "getAudienceCountMax", "setAudienceCountMax", "callingMicNickname", "getCallingMicNickname", "setCallingMicNickname", "callingMicUsername", "getCallingMicUsername", "setCallingMicUsername", "enterFromScene", "getEnterFromScene", "setEnterFromScene", "hasChangeVideoModePerLinkMic", "", "getHasChangeVideoModePerLinkMic", "()Z", "setHasChangeVideoModePerLinkMic", "(Z)V", "isClickStartLive", "setClickStartLive", "isForeigner", "setForeigner", "isLiveNameChanged", "setLiveNameChanged", "isManualClosed", "setManualClosed", "isStartLiveReport", "setStartLiveReport", "isVerifyChecked", "setVerifyChecked", "isVerifyUiShow", "setVerifyUiShow", "isVisitorReport", "setVisitorReport", "lastOrientation", "getLastOrientation", "setLastOrientation", "linkMicRequestCount", "getLinkMicRequestCount", "setLinkMicRequestCount", "liveCookies", "", "getLiveCookies", "()[B", "setLiveCookies", "([B)V", "liveDynamicConfig", "Lcom/tencent/mm/live/model/LiveDataManager$LiveDynamicConfig;", "getLiveDynamicConfig", "()Lcom/tencent/mm/live/model/LiveDataManager$LiveDynamicConfig;", "setLiveDynamicConfig", "(Lcom/tencent/mm/live/model/LiveDataManager$LiveDynamicConfig;)V", "liveFaceVerifyInfo", "Lcom/tencent/mm/live/model/LiveDataManager$LiveFaceVerifyInfo;", "getLiveFaceVerifyInfo", "()Lcom/tencent/mm/live/model/LiveDataManager$LiveFaceVerifyInfo;", "setLiveFaceVerifyInfo", "(Lcom/tencent/mm/live/model/LiveDataManager$LiveFaceVerifyInfo;)V", "liveInfo", "Lcom/tencent/mm/protocal/protobuf/LiveInfo;", "getLiveInfo", "()Lcom/tencent/mm/protocal/protobuf/LiveInfo;", "setLiveInfo", "(Lcom/tencent/mm/protocal/protobuf/LiveInfo;)V", "liveRoomModel", "Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "getLiveRoomModel", "()Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "setLiveRoomModel", "(Lcom/tencent/mm/live/core/core/model/LiveRoomModel;)V", "liveSdkInfo", "Lcom/tencent/mm/protocal/protobuf/LiveSdkInfo;", "getLiveSdkInfo", "()Lcom/tencent/mm/protocal/protobuf/LiveSdkInfo;", "setLiveSdkInfo", "(Lcom/tencent/mm/protocal/protobuf/LiveSdkInfo;)V", "liveSmallWindowInfo", "Lcom/tencent/mm/live/model/LiveDataManager$LiveSmallWindowInfo;", "getLiveSmallWindowInfo", "()Lcom/tencent/mm/live/model/LiveDataManager$LiveSmallWindowInfo;", "setLiveSmallWindowInfo", "(Lcom/tencent/mm/live/model/LiveDataManager$LiveSmallWindowInfo;)V", "liveStatus", "Lcom/tencent/mm/live/model/LiveDataManager$LiveStatus;", "getLiveStatus", "()Lcom/tencent/mm/live/model/LiveDataManager$LiveStatus;", "setLiveStatus", "(Lcom/tencent/mm/live/model/LiveDataManager$LiveStatus;)V", "mCheckDeviceLsn", "com/tencent/mm/live/model/LiveDataManager$mCheckDeviceLsn$1", "Lcom/tencent/mm/live/model/LiveDataManager$mCheckDeviceLsn$1;", "mLastOrientation", "getMLastOrientation", "setMLastOrientation", "mStartLinkTimes", "", "getMStartLinkTimes", "()J", "setMStartLinkTimes", "(J)V", "micPmkExpire", "getMicPmkExpire", "setMicPmkExpire", "msgFilterTime", "getMsgFilterTime", "setMsgFilterTime", "msgList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/view/adapter/CommentData;", "Lkotlin/collections/ArrayList;", "getMsgList", "()Ljava/util/ArrayList;", "setMsgList", "(Ljava/util/ArrayList;)V", "onlineHeadImgList", "getOnlineHeadImgList", "setOnlineHeadImgList", "shareRoomList", "Ljava/util/HashMap;", "Lkotlin/Pair;", "Lkotlin/collections/HashMap;", "getShareRoomList", "()Ljava/util/HashMap;", "setShareRoomList", "(Ljava/util/HashMap;)V", "sysMsgManager", "Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager;", "getSysMsgManager", "()Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager;", "setSysMsgManager", "(Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager;)V", "thumbUrl", "getThumbUrl", "setThumbUrl", "visitorCommentCount", "getVisitorCommentCount", "setVisitorCommentCount", "visitorConnectCount", "getVisitorConnectCount", "setVisitorConnectCount", "visitorConnectReqCount", "getVisitorConnectReqCount", "setVisitorConnectReqCount", "visitorEnterErrorCode", "getVisitorEnterErrorCode", "setVisitorEnterErrorCode", "visitorEnterMemberCount", "getVisitorEnterMemberCount", "setVisitorEnterMemberCount", "visitorLikeCount", "getVisitorLikeCount", "setVisitorLikeCount", "wechatRoomId", "getWechatRoomId", "setWechatRoomId", "displayLiveName", "displayUsername", "username", "formatAnchorLikeCount", "formatLikeCount", "liveError", "", "liveFinish", "liveStart", "preOnCreate", "release", "resetData", "resetLiveFaceVerifyInfo", "LiveDynamicConfig", "LiveFaceVerifyInfo", "LiveSmallWindowInfo", "LiveStatus", "plugin-logic_release"})
public final class g
{
  private static final String TAG = "MicroMsg.LiveDataManager";
  private static String gME;
  private static ArrayList<String> gNC;
  private static HashMap<String, o<ArrayList<String>, Integer>> gND;
  private static ArrayList<com.tencent.mm.live.view.a.a> gNE;
  private static byte[] gNF;
  private static buq gNG;
  private static buw gNH;
  private static String gNI;
  private static int gNJ;
  private static d gNK;
  private static long gNL;
  private static buo gNM;
  private static boolean gNN;
  private static int gNO;
  private static String gNP;
  private static String gNQ;
  private static boolean gNR;
  private static d gNS;
  private static g.b gNT;
  private static g.a gNU;
  private static c gNV;
  private static boolean gNW;
  private static boolean gNX;
  private static boolean gNY;
  private static boolean gNZ;
  private static boolean gOa;
  private static int gOb;
  private static int gOc;
  private static int gOd;
  private static int gOe;
  private static int gOf;
  private static int gOg;
  private static int gOh;
  private static int gOi;
  private static boolean gOj;
  private static int gOk;
  private static int gOl;
  private static int gOm;
  private static long gOn;
  private static boolean gOo;
  private static com.tencent.mm.live.b.b.a gOp;
  private static final e gOq;
  public static final g gOr;
  private static String thumbUrl;
  
  static
  {
    AppMethodBeat.i(212078);
    gOr = new g();
    TAG = "MicroMsg.LiveDataManager";
    gME = "";
    gNC = new ArrayList();
    gND = new HashMap();
    gNE = new ArrayList();
    gNG = new buq();
    gNI = "";
    gNM = new buo();
    gNO = -1;
    gNP = "";
    gNQ = "";
    gNS = new d((byte)0);
    gNT = new g.b();
    gNU = new g.a((byte)0);
    gNV = new c();
    gOe = -1;
    gOp = new com.tencent.mm.live.b.b.a();
    e locale = new e();
    gOq = locale;
    locale.alive();
    AppMethodBeat.o(212078);
  }
  
  public static void P(byte[] paramArrayOfByte)
  {
    gNF = paramArrayOfByte;
  }
  
  public static void Zh()
  {
    AppMethodBeat.i(212076);
    com.tencent.mm.sdk.platformtools.ad.m(TAG, "resetData", new Object[0]);
    gNL = 0L;
    gME = "";
    gNC.clear();
    gND.clear();
    gNF = null;
    gNG = new buq();
    gNH = null;
    thumbUrl = null;
    com.tencent.mm.live.b.b.a locala = gOp;
    locala.gQH = null;
    locala.gQI = null;
    locala.gQJ = null;
    locala.gQK = null;
    locala.gQL = null;
    locala.gQM = null;
    locala.gQN = null;
    locala.gQP = null;
    locala.gQO.clear();
    locala.gQQ = "";
    locala.gQR = "";
    gNE.clear();
    gNI = "";
    gNJ = 0;
    gNK = null;
    gNM = new buo();
    gNN = false;
    gNO = -1;
    gNP = "";
    gNQ = "";
    gNU = new g.a((byte)0);
    gNV = new c();
    gNR = false;
    gNS = new d((byte)0);
    gNT = new g.b();
    AppMethodBeat.o(212076);
  }
  
  public static void a(buo parambuo)
  {
    AppMethodBeat.i(212068);
    p.h(parambuo, "<set-?>");
    gNM = parambuo;
    AppMethodBeat.o(212068);
  }
  
  public static void a(buq parambuq)
  {
    AppMethodBeat.i(212066);
    p.h(parambuq, "<set-?>");
    gNG = parambuq;
    AppMethodBeat.o(212066);
  }
  
  public static void a(buw parambuw)
  {
    gNH = parambuw;
  }
  
  public static void anA()
  {
    gNN = true;
  }
  
  public static int anB()
  {
    return gNO;
  }
  
  public static String anC()
  {
    return gNP;
  }
  
  public static String anD()
  {
    return gNQ;
  }
  
  public static boolean anE()
  {
    return gNR;
  }
  
  public static void anF()
  {
    gNR = true;
  }
  
  public static d anG()
  {
    return gNS;
  }
  
  public static g.b anH()
  {
    return gNT;
  }
  
  public static g.a anI()
  {
    return gNU;
  }
  
  public static c anJ()
  {
    return gNV;
  }
  
  public static boolean anK()
  {
    return gNW;
  }
  
  public static boolean anL()
  {
    return gNX;
  }
  
  public static boolean anM()
  {
    return gNY;
  }
  
  public static boolean anN()
  {
    return gNZ;
  }
  
  public static boolean anO()
  {
    return gOa;
  }
  
  public static int anP()
  {
    return gOb;
  }
  
  public static int anQ()
  {
    return gOc;
  }
  
  public static int anR()
  {
    return gOd;
  }
  
  public static int anS()
  {
    return gOe;
  }
  
  public static int anT()
  {
    return gOf;
  }
  
  public static int anU()
  {
    return gOg;
  }
  
  public static int anV()
  {
    return gOh;
  }
  
  public static int anW()
  {
    return gOi;
  }
  
  public static boolean anX()
  {
    return gOj;
  }
  
  public static int anY()
  {
    return gOk;
  }
  
  public static int anZ()
  {
    return gOl;
  }
  
  public static String anm()
  {
    return gME;
  }
  
  public static ArrayList<String> ann()
  {
    return gNC;
  }
  
  public static HashMap<String, o<ArrayList<String>, Integer>> ano()
  {
    return gND;
  }
  
  public static ArrayList<com.tencent.mm.live.view.a.a> anp()
  {
    return gNE;
  }
  
  public static byte[] anq()
  {
    return gNF;
  }
  
  public static buq ans()
  {
    return gNG;
  }
  
  public static buw ant()
  {
    return gNH;
  }
  
  public static String anu()
  {
    return gNI;
  }
  
  public static int anv()
  {
    return gNJ;
  }
  
  public static d anw()
  {
    return gNK;
  }
  
  public static long anx()
  {
    return gNL;
  }
  
  public static buo any()
  {
    return gNM;
  }
  
  public static boolean anz()
  {
    return gNN;
  }
  
  public static int aoa()
  {
    return gOm;
  }
  
  public static long aob()
  {
    AppMethodBeat.i(212071);
    long l = (System.currentTimeMillis() - gOn) / 1000L;
    AppMethodBeat.o(212071);
    return l;
  }
  
  public static boolean aoc()
  {
    return gOo;
  }
  
  public static com.tencent.mm.live.b.b.a aod()
  {
    return gOp;
  }
  
  public static String aoe()
  {
    AppMethodBeat.i(212072);
    if (gNG.GzX <= 0)
    {
      localObject = aj.getContext();
      p.g(localObject, "MMApplicationContext.getContext()");
      localObject = ((Context)localObject).getResources().getString(2131766618);
      p.g(localObject, "MMApplicationContext.get…ing.live_like_count_zero)");
      AppMethodBeat.o(212072);
      return localObject;
    }
    if (gNG.GzX < 10000)
    {
      int i = gNG.GzX;
      AppMethodBeat.o(212072);
      return String.valueOf(i);
    }
    if (gNG.GzX % 10000 >= 1000)
    {
      localObject = d.g.b.ad.MLZ;
      localObject = aj.getContext();
      p.g(localObject, "MMApplicationContext.getContext()");
      localObject = ((Context)localObject).getResources().getString(2131766616);
      p.g(localObject, "MMApplicationContext.get…g.live_like_count_format)");
      localObject = String.format((String)localObject, Arrays.copyOf(new Object[] { Float.valueOf(gNG.GzX / 10000.0F) }, 1));
      p.g(localObject, "java.lang.String.format(format, *args)");
      AppMethodBeat.o(212072);
      return localObject;
    }
    Object localObject = d.g.b.ad.MLZ;
    localObject = aj.getContext();
    p.g(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getResources().getString(2131766617);
    p.g(localObject, "MMApplicationContext.get…ve_like_count_int_format)");
    localObject = String.format((String)localObject, Arrays.copyOf(new Object[] { Integer.valueOf(gNG.GzX / 10000) }, 1));
    p.g(localObject, "java.lang.String.format(format, *args)");
    AppMethodBeat.o(212072);
    return localObject;
  }
  
  public static String aof()
  {
    AppMethodBeat.i(212073);
    if (gNG.GzX <= 0)
    {
      AppMethodBeat.o(212073);
      return "0";
    }
    if (gNG.GzX < 10000)
    {
      int i = gNG.GzX;
      AppMethodBeat.o(212073);
      return String.valueOf(i);
    }
    if (gNG.GzX % 10000 >= 1000)
    {
      localObject = d.g.b.ad.MLZ;
      localObject = aj.getContext();
      p.g(localObject, "MMApplicationContext.getContext()");
      localObject = ((Context)localObject).getResources().getString(2131766616);
      p.g(localObject, "MMApplicationContext.get…g.live_like_count_format)");
      localObject = String.format((String)localObject, Arrays.copyOf(new Object[] { Float.valueOf(gNG.GzX / 10000.0F) }, 1));
      p.g(localObject, "java.lang.String.format(format, *args)");
      AppMethodBeat.o(212073);
      return localObject;
    }
    Object localObject = d.g.b.ad.MLZ;
    localObject = aj.getContext();
    p.g(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getResources().getString(2131766617);
    p.g(localObject, "MMApplicationContext.get…ve_like_count_int_format)");
    localObject = String.format((String)localObject, Arrays.copyOf(new Object[] { Integer.valueOf(gNG.GzX / 10000) }, 1));
    p.g(localObject, "java.lang.String.format(format, *args)");
    AppMethodBeat.o(212073);
    return localObject;
  }
  
  public static String aog()
  {
    AppMethodBeat.i(212074);
    String str2;
    String str1;
    if (bt.isNullOrNil(gNG.Gbw))
    {
      str2 = gNG.GOL;
      str1 = str2;
      if (str2 == null)
      {
        AppMethodBeat.o(212074);
        return "";
      }
    }
    else
    {
      str2 = gNG.Gbw;
      str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
    }
    AppMethodBeat.o(212074);
    return str1;
  }
  
  public static void aoh()
  {
    gNS.gOA = true;
    gNS.gOz = false;
  }
  
  public static void aoi()
  {
    gNS.gOB = true;
  }
  
  public static void aoj()
  {
    gNS.gOz = true;
    gNS.gOA = false;
  }
  
  public static void aok()
  {
    boolean bool2 = true;
    AppMethodBeat.i(212077);
    int i = bt.getInt(com.tencent.mm.n.g.acA().getValue("MMLiveConfigBitSet"), 0);
    g.a locala = gNU;
    if (!com.tencent.mm.ad.c.cQ(i, 1))
    {
      bool1 = true;
      locala.gOs = bool1;
      locala = gNU;
      if (com.tencent.mm.ad.c.cQ(i, 2)) {
        break label111;
      }
      bool1 = true;
      label55:
      locala.gOt = bool1;
      locala = gNU;
      if (com.tencent.mm.ad.c.cQ(i, 4)) {
        break label116;
      }
      bool1 = true;
      label74:
      locala.gOu = bool1;
      locala = gNU;
      if (com.tencent.mm.ad.c.cQ(i, 8)) {
        break label121;
      }
    }
    label111:
    label116:
    label121:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      locala.gOv = bool1;
      AppMethodBeat.o(212077);
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
    gNK = paramd;
  }
  
  public static void dK(boolean paramBoolean)
  {
    gNW = paramBoolean;
  }
  
  public static void dL(boolean paramBoolean)
  {
    gNX = paramBoolean;
  }
  
  public static void dM(boolean paramBoolean)
  {
    gNY = paramBoolean;
  }
  
  public static void dN(boolean paramBoolean)
  {
    gNZ = paramBoolean;
  }
  
  public static void dO(boolean paramBoolean)
  {
    gOa = paramBoolean;
  }
  
  public static void dP(boolean paramBoolean)
  {
    gOj = paramBoolean;
  }
  
  public static void dQ(boolean paramBoolean)
  {
    gOo = paramBoolean;
  }
  
  public static void nA(int paramInt)
  {
    gOg = paramInt;
  }
  
  public static void nB(int paramInt)
  {
    gOh = paramInt;
  }
  
  public static void nC(int paramInt)
  {
    gOi = paramInt;
  }
  
  public static void nD(int paramInt)
  {
    gOk = paramInt;
  }
  
  public static void nE(int paramInt)
  {
    gOl = paramInt;
  }
  
  public static void nF(int paramInt)
  {
    gOm = paramInt;
  }
  
  public static void nt(int paramInt)
  {
    gNJ = paramInt;
  }
  
  public static void nu(int paramInt)
  {
    gNO = paramInt;
  }
  
  public static void nv(int paramInt)
  {
    if (gOb < paramInt) {
      gOb = paramInt;
    }
    while (paramInt != -1) {
      return;
    }
    gOb = 0;
  }
  
  public static void nw(int paramInt)
  {
    gOc = paramInt;
  }
  
  public static void nx(int paramInt)
  {
    gOd = paramInt;
  }
  
  public static void ny(int paramInt)
  {
    gOe = paramInt;
  }
  
  public static void nz(int paramInt)
  {
    gOf = paramInt;
  }
  
  public static void rh(long paramLong)
  {
    gNL = paramLong;
  }
  
  public static void ri(long paramLong)
  {
    gOn = paramLong;
  }
  
  public static void xE(String paramString)
  {
    AppMethodBeat.i(212065);
    p.h(paramString, "<set-?>");
    gME = paramString;
    AppMethodBeat.o(212065);
  }
  
  public static void xF(String paramString)
  {
    thumbUrl = paramString;
  }
  
  public static void xG(String paramString)
  {
    AppMethodBeat.i(212067);
    p.h(paramString, "<set-?>");
    gNI = paramString;
    AppMethodBeat.o(212067);
  }
  
  public static void xH(String paramString)
  {
    AppMethodBeat.i(212069);
    p.h(paramString, "<set-?>");
    gNP = paramString;
    AppMethodBeat.o(212069);
  }
  
  public static void xI(String paramString)
  {
    AppMethodBeat.i(212070);
    p.h(paramString, "<set-?>");
    gNQ = paramString;
    AppMethodBeat.o(212070);
  }
  
  public static String xJ(String paramString)
  {
    AppMethodBeat.i(212075);
    if (paramString == null)
    {
      AppMethodBeat.o(212075);
      return "";
    }
    String str = v.zg(paramString);
    Object localObject = str;
    if (bt.isNullOrNil(str))
    {
      localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class);
      p.g(localObject, "MMKernel.service(IChatroomService::class.java)");
      localObject = ((com.tencent.mm.plugin.chatroom.a.c)localObject).azz().AN(gME);
      if (localObject != null) {
        break label90;
      }
      localObject = v.zf(paramString);
    }
    for (;;)
    {
      p.g(localObject, "result");
      AppMethodBeat.o(212075);
      return localObject;
      label90:
      str = ((ab)localObject).zf(paramString);
      localObject = str;
      if (bt.isNullOrNil(str)) {
        localObject = v.zf(paramString);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/LiveDataManager$LiveSmallWindowInfo;", "", "userId", "", "streamType", "", "width", "height", "(Ljava/lang/String;III)V", "getHeight", "()I", "setHeight", "(I)V", "getStreamType", "setStreamType", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "getWidth", "setWidth", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "isLandscape", "toString", "plugin-logic_release"})
  public static final class c
  {
    public int height;
    public int streamType;
    public String userId;
    public int width;
    
    private c(String paramString)
    {
      AppMethodBeat.i(212058);
      this.userId = paramString;
      this.streamType = 0;
      this.width = 0;
      this.height = 0;
      AppMethodBeat.o(212058);
    }
    
    public final boolean aol()
    {
      return this.width > this.height;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(212062);
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
        AppMethodBeat.o(212062);
        return true;
      }
      AppMethodBeat.o(212062);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(212061);
      String str = this.userId;
      if (str != null) {}
      for (int i = str.hashCode();; i = 0)
      {
        int j = this.streamType;
        int k = this.width;
        int m = this.height;
        AppMethodBeat.o(212061);
        return ((i * 31 + j) * 31 + k) * 31 + m;
      }
    }
    
    public final void setUserId(String paramString)
    {
      AppMethodBeat.i(212057);
      p.h(paramString, "<set-?>");
      this.userId = paramString;
      AppMethodBeat.o(212057);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(212060);
      String str = "LiveSmallWindowInfo(userId=" + this.userId + ", streamType=" + this.streamType + ", width=" + this.width + ", height=" + this.height + ")";
      AppMethodBeat.o(212060);
      return str;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/LiveDataManager$LiveStatus;", "", "liveFinished", "", "liveStarted", "liveHasError", "liveJumpToOtherUI", "(ZZZZ)V", "getLiveFinished", "()Z", "setLiveFinished", "(Z)V", "getLiveHasError", "setLiveHasError", "getLiveJumpToOtherUI", "setLiveJumpToOtherUI", "getLiveStarted", "setLiveStarted", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "plugin-logic_release"})
  public static final class d
  {
    public boolean gOA = false;
    public boolean gOB = false;
    public boolean gOC = false;
    public boolean gOz = false;
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof d))
        {
          paramObject = (d)paramObject;
          if ((this.gOz != paramObject.gOz) || (this.gOA != paramObject.gOA) || (this.gOB != paramObject.gOB) || (this.gOC != paramObject.gOC)) {}
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
      AppMethodBeat.i(212063);
      String str = "LiveStatus(liveFinished=" + this.gOz + ", liveStarted=" + this.gOA + ", liveHasError=" + this.gOB + ", liveJumpToOtherUI=" + this.gOC + ")";
      AppMethodBeat.o(212063);
      return str;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/live/model/LiveDataManager$mCheckDeviceLsn$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/LiveStateActionEvent;", "callback", "", "event", "plugin-logic_release"})
  public static final class e
    extends com.tencent.mm.sdk.b.c<le>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.b.g
 * JD-Core Version:    0.7.0.1
 */