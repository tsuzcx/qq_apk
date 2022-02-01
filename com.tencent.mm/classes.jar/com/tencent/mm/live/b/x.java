package com.tencent.mm.live.b;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.g.a.lv;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.core.core.e.c;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ap;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.protocal.protobuf.ciq;
import com.tencent.mm.protocal.protobuf.civ;
import com.tencent.mm.protocal.protobuf.cjb;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/RoomLiveService;", "", "()V", "TAG", "", "anchorLinkSuccessCountPerShow", "", "getAnchorLinkSuccessCountPerShow", "()I", "setAnchorLinkSuccessCountPerShow", "(I)V", "anchorStatus", "Lcom/tencent/mm/protocal/protobuf/LiveAnchorStatus;", "getAnchorStatus", "()Lcom/tencent/mm/protocal/protobuf/LiveAnchorStatus;", "setAnchorStatus", "(Lcom/tencent/mm/protocal/protobuf/LiveAnchorStatus;)V", "anchorUserName", "getAnchorUserName", "()Ljava/lang/String;", "setAnchorUserName", "(Ljava/lang/String;)V", "value", "audienceCountMax", "getAudienceCountMax", "setAudienceCountMax", "beautyConfig", "Lcom/tencent/mm/live/core/render/BeautyConfig;", "getBeautyConfig", "()Lcom/tencent/mm/live/core/render/BeautyConfig;", "setBeautyConfig", "(Lcom/tencent/mm/live/core/render/BeautyConfig;)V", "callingMicNickname", "getCallingMicNickname", "setCallingMicNickname", "callingMicUsername", "getCallingMicUsername", "setCallingMicUsername", "context", "Landroid/content/Context;", "enterFromScene", "getEnterFromScene", "setEnterFromScene", "filterConfig", "Lcom/tencent/mm/live/core/render/FilterConfig;", "getFilterConfig", "()Lcom/tencent/mm/live/core/render/FilterConfig;", "setFilterConfig", "(Lcom/tencent/mm/live/core/render/FilterConfig;)V", "hasChangeVideoModePerLinkMic", "", "getHasChangeVideoModePerLinkMic", "()Z", "setHasChangeVideoModePerLinkMic", "(Z)V", "isAnchor", "isClickStartLive", "setClickStartLive", "isForeigner", "setForeigner", "isLiveNameChanged", "setLiveNameChanged", "isManualClosed", "setManualClosed", "isStartLiveReport", "setStartLiveReport", "isVerifyChecked", "setVerifyChecked", "isVerifyUiShow", "setVerifyUiShow", "isVisitorReport", "setVisitorReport", "lastOrientation", "getLastOrientation", "setLastOrientation", "linkMicRequestCount", "getLinkMicRequestCount", "setLinkMicRequestCount", "liveCookies", "", "getLiveCookies", "()[B", "setLiveCookies", "([B)V", "liveDynamicConfig", "Lcom/tencent/mm/live/model/RoomLiveService$LiveDynamicConfig;", "getLiveDynamicConfig", "()Lcom/tencent/mm/live/model/RoomLiveService$LiveDynamicConfig;", "setLiveDynamicConfig", "(Lcom/tencent/mm/live/model/RoomLiveService$LiveDynamicConfig;)V", "liveFaceVerifyInfo", "Lcom/tencent/mm/live/model/RoomLiveService$LiveFaceVerifyInfo;", "getLiveFaceVerifyInfo", "()Lcom/tencent/mm/live/model/RoomLiveService$LiveFaceVerifyInfo;", "setLiveFaceVerifyInfo", "(Lcom/tencent/mm/live/model/RoomLiveService$LiveFaceVerifyInfo;)V", "liveInfo", "Lcom/tencent/mm/protocal/protobuf/LiveInfo;", "getLiveInfo", "()Lcom/tencent/mm/protocal/protobuf/LiveInfo;", "setLiveInfo", "(Lcom/tencent/mm/protocal/protobuf/LiveInfo;)V", "liveRoomModel", "Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "getLiveRoomModel", "()Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "setLiveRoomModel", "(Lcom/tencent/mm/live/core/core/model/LiveRoomModel;)V", "liveSdkInfo", "Lcom/tencent/mm/protocal/protobuf/LiveSdkInfo;", "getLiveSdkInfo", "()Lcom/tencent/mm/protocal/protobuf/LiveSdkInfo;", "setLiveSdkInfo", "(Lcom/tencent/mm/protocal/protobuf/LiveSdkInfo;)V", "liveSmallWindowInfo", "Lcom/tencent/mm/live/model/RoomLiveService$LiveSmallWindowInfo;", "getLiveSmallWindowInfo", "()Lcom/tencent/mm/live/model/RoomLiveService$LiveSmallWindowInfo;", "setLiveSmallWindowInfo", "(Lcom/tencent/mm/live/model/RoomLiveService$LiveSmallWindowInfo;)V", "liveStatus", "Lcom/tencent/mm/live/model/RoomLiveService$LiveStatus;", "getLiveStatus", "()Lcom/tencent/mm/live/model/RoomLiveService$LiveStatus;", "setLiveStatus", "(Lcom/tencent/mm/live/model/RoomLiveService$LiveStatus;)V", "mCheckDeviceLsn", "com/tencent/mm/live/model/RoomLiveService$mCheckDeviceLsn$1", "Lcom/tencent/mm/live/model/RoomLiveService$mCheckDeviceLsn$1;", "mLastOrientation", "getMLastOrientation", "setMLastOrientation", "mStartLinkTimes", "", "getMStartLinkTimes", "()J", "setMStartLinkTimes", "(J)V", "micPmkExpire", "getMicPmkExpire", "setMicPmkExpire", "miniWindowClickListener", "Landroid/view/View$OnClickListener;", "getMiniWindowClickListener", "()Landroid/view/View$OnClickListener;", "setMiniWindowClickListener", "(Landroid/view/View$OnClickListener;)V", "msgFilterTime", "getMsgFilterTime", "setMsgFilterTime", "msgList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/view/adapter/CommentData;", "Lkotlin/collections/ArrayList;", "getMsgList", "()Ljava/util/ArrayList;", "setMsgList", "(Ljava/util/ArrayList;)V", "onlineHeadImgList", "getOnlineHeadImgList", "setOnlineHeadImgList", "shareRoomList", "Ljava/util/HashMap;", "Lkotlin/Pair;", "Lkotlin/collections/HashMap;", "getShareRoomList", "()Ljava/util/HashMap;", "setShareRoomList", "(Ljava/util/HashMap;)V", "startAudienceUV", "getStartAudienceUV", "setStartAudienceUV", "sysMsgManager", "Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager;", "getSysMsgManager", "()Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager;", "setSysMsgManager", "(Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager;)V", "thumbUrl", "getThumbUrl", "setThumbUrl", "visitorCommentCount", "getVisitorCommentCount", "setVisitorCommentCount", "visitorConnectCount", "getVisitorConnectCount", "setVisitorConnectCount", "visitorConnectReqCount", "getVisitorConnectReqCount", "setVisitorConnectReqCount", "visitorEnterErrorCode", "getVisitorEnterErrorCode", "setVisitorEnterErrorCode", "visitorEnterMemberCount", "getVisitorEnterMemberCount", "setVisitorEnterMemberCount", "visitorLikeCount", "getVisitorLikeCount", "setVisitorLikeCount", "wechatRoomId", "getWechatRoomId", "setWechatRoomId", "displayLiveName", "displayUsername", "username", "finishCurLive", "", "formatLikeCount", "liveError", "liveFinish", "liveStart", "release", "resetData", "resetLiveFaceVerifyInfo", "setup", "LiveDynamicConfig", "LiveFaceVerifyInfo", "LiveSmallWindowInfo", "LiveStatus", "plugin-logic_release"})
public final class x
{
  private static final String TAG = "MicroMsg.LiveDataManager";
  private static Context context;
  private static boolean dMz;
  private static com.tencent.mm.live.core.b.a hDV;
  private static com.tencent.mm.live.core.b.b hDW;
  private static String hFW;
  private static ciq hIA;
  private static String hIB;
  private static String hIC;
  private static boolean hID;
  private static d hIE;
  private static b hIF;
  private static a hIG;
  private static c hIH;
  private static boolean hII;
  private static boolean hIJ;
  private static boolean hIK;
  private static boolean hIL;
  private static boolean hIM;
  private static int hIN;
  private static int hIO;
  private static int hIP;
  private static int hIQ;
  private static int hIR;
  private static int hIS;
  private static int hIT;
  private static int hIU;
  private static boolean hIV;
  private static int hIW;
  private static int hIX;
  private static int hIY;
  private static long hIZ;
  private static ArrayList<String> hIq;
  private static HashMap<String, o<ArrayList<String>, Integer>> hIr;
  private static ArrayList<com.tencent.mm.live.view.a.a> hIs;
  private static byte[] hIt;
  private static civ hIu;
  private static cjb hIv;
  private static String hIw;
  private static int hIx;
  private static com.tencent.mm.live.core.core.b.f hIy;
  private static long hIz;
  private static boolean hJa;
  private static com.tencent.mm.live.b.b.a hJb;
  private static long hJc;
  private static final e hJd;
  private static View.OnClickListener hJe;
  public static final x hJf;
  private static boolean isManualClosed;
  private static int lastOrientation;
  private static String thumbUrl;
  
  static
  {
    AppMethodBeat.i(207732);
    hJf = new x();
    TAG = "MicroMsg.LiveDataManager";
    com.tencent.mm.live.core.b.a locala = new com.tencent.mm.live.core.b.a();
    Map localMap = (Map)locala.hDh;
    e.c localc = e.c.hxm;
    localMap.put(Integer.valueOf(e.c.aCh()), Integer.valueOf(60));
    localMap = (Map)locala.hDh;
    localc = e.c.hxm;
    localMap.put(Integer.valueOf(e.c.aCi()), Integer.valueOf(-1));
    localMap = (Map)locala.hDh;
    localc = e.c.hxm;
    localMap.put(Integer.valueOf(e.c.aCl()), Integer.valueOf(-1));
    localMap = (Map)locala.hDh;
    localc = e.c.hxm;
    localMap.put(Integer.valueOf(e.c.aCj()), Integer.valueOf(-1));
    localMap = (Map)locala.hDh;
    localc = e.c.hxm;
    localMap.put(Integer.valueOf(e.c.aCm()), Integer.valueOf(-1));
    localMap = (Map)locala.hDh;
    localc = e.c.hxm;
    localMap.put(Integer.valueOf(e.c.aCk()), Integer.valueOf(-1));
    hDV = locala;
    hFW = "";
    hIq = new ArrayList();
    hIr = new HashMap();
    hIs = new ArrayList();
    hIu = new civ();
    hIw = "";
    hIA = new ciq();
    lastOrientation = -1;
    hIB = "";
    hIC = "";
    hIE = new d((byte)0);
    hIF = new b();
    hIG = new a((byte)0);
    hIH = new c();
    hIQ = -1;
    hJb = new com.tencent.mm.live.b.b.a();
    hJd = new e();
    hJe = (View.OnClickListener)x.f.hJr;
    hJd.alive();
    AppMethodBeat.o(207732);
  }
  
  public static void GQ(String paramString)
  {
    AppMethodBeat.i(207720);
    p.h(paramString, "<set-?>");
    hFW = paramString;
    AppMethodBeat.o(207720);
  }
  
  public static void GR(String paramString)
  {
    thumbUrl = paramString;
  }
  
  public static void GS(String paramString)
  {
    AppMethodBeat.i(207722);
    p.h(paramString, "<set-?>");
    hIw = paramString;
    AppMethodBeat.o(207722);
  }
  
  public static void GT(String paramString)
  {
    AppMethodBeat.i(207724);
    p.h(paramString, "<set-?>");
    hIB = paramString;
    AppMethodBeat.o(207724);
  }
  
  public static void GU(String paramString)
  {
    AppMethodBeat.i(207725);
    p.h(paramString, "<set-?>");
    hIC = paramString;
    AppMethodBeat.o(207725);
  }
  
  public static String GV(String paramString)
  {
    AppMethodBeat.i(207728);
    if (paramString == null)
    {
      AppMethodBeat.o(207728);
      return "";
    }
    String str = aa.Is(paramString);
    Object localObject = str;
    if (Util.isNullOrNil(str))
    {
      localObject = g.af(c.class);
      p.g(localObject, "MMKernel.service(IChatroomService::class.java)");
      localObject = ((c)localObject).aSX().Kd(hFW);
      if (localObject != null) {
        break label90;
      }
      localObject = aa.getDisplayName(paramString);
    }
    for (;;)
    {
      p.g(localObject, "result");
      AppMethodBeat.o(207728);
      return localObject;
      label90:
      str = ((ah)localObject).getDisplayName(paramString);
      localObject = str;
      if (Util.isNullOrNil(str)) {
        localObject = aa.getDisplayName(paramString);
      }
    }
  }
  
  public static void a(ciq paramciq)
  {
    AppMethodBeat.i(207723);
    p.h(paramciq, "<set-?>");
    hIA = paramciq;
    AppMethodBeat.o(207723);
  }
  
  public static void a(civ paramciv)
  {
    AppMethodBeat.i(207721);
    p.h(paramciv, "<set-?>");
    hIu = paramciv;
    AppMethodBeat.o(207721);
  }
  
  public static void a(cjb paramcjb)
  {
    hIv = paramcjb;
  }
  
  public static String aGA()
  {
    return hIC;
  }
  
  public static boolean aGB()
  {
    return hID;
  }
  
  public static void aGC()
  {
    hID = true;
  }
  
  public static d aGD()
  {
    return hIE;
  }
  
  public static b aGE()
  {
    return hIF;
  }
  
  public static a aGF()
  {
    return hIG;
  }
  
  public static c aGG()
  {
    return hIH;
  }
  
  public static boolean aGH()
  {
    return hII;
  }
  
  public static boolean aGI()
  {
    return hIJ;
  }
  
  public static boolean aGJ()
  {
    return hIK;
  }
  
  public static boolean aGK()
  {
    return hIL;
  }
  
  public static boolean aGL()
  {
    return hIM;
  }
  
  public static int aGM()
  {
    return hIN;
  }
  
  public static int aGN()
  {
    return hIO;
  }
  
  public static int aGO()
  {
    return hIP;
  }
  
  public static int aGP()
  {
    return hIQ;
  }
  
  public static int aGQ()
  {
    return hIR;
  }
  
  public static int aGR()
  {
    return hIS;
  }
  
  public static int aGS()
  {
    return hIT;
  }
  
  public static int aGT()
  {
    return hIU;
  }
  
  public static boolean aGU()
  {
    return hIV;
  }
  
  public static int aGV()
  {
    return hIW;
  }
  
  public static int aGW()
  {
    return hIX;
  }
  
  public static int aGX()
  {
    return hIY;
  }
  
  public static long aGY()
  {
    return hIZ;
  }
  
  public static boolean aGZ()
  {
    return hJa;
  }
  
  public static com.tencent.mm.live.core.b.a aGk()
  {
    return hDV;
  }
  
  public static com.tencent.mm.live.core.b.b aGl()
  {
    return hDW;
  }
  
  public static String aGm()
  {
    return hFW;
  }
  
  public static ArrayList<String> aGn()
  {
    return hIq;
  }
  
  public static HashMap<String, o<ArrayList<String>, Integer>> aGo()
  {
    return hIr;
  }
  
  public static ArrayList<com.tencent.mm.live.view.a.a> aGp()
  {
    return hIs;
  }
  
  public static byte[] aGq()
  {
    return hIt;
  }
  
  public static civ aGr()
  {
    return hIu;
  }
  
  public static cjb aGs()
  {
    return hIv;
  }
  
  public static String aGt()
  {
    return hIw;
  }
  
  public static int aGu()
  {
    return hIx;
  }
  
  public static com.tencent.mm.live.core.core.b.f aGv()
  {
    return hIy;
  }
  
  public static long aGw()
  {
    return hIz;
  }
  
  public static ciq aGx()
  {
    return hIA;
  }
  
  public static void aGy()
  {
    isManualClosed = true;
  }
  
  public static String aGz()
  {
    return hIB;
  }
  
  public static com.tencent.mm.live.b.b.a aHa()
  {
    return hJb;
  }
  
  public static long aHb()
  {
    return hJc;
  }
  
  public static View.OnClickListener aHc()
  {
    return hJe;
  }
  
  public static String aHd()
  {
    AppMethodBeat.i(207726);
    if (hIu.LXG <= 0)
    {
      localObject = MMApplicationContext.getContext();
      p.g(localObject, "MMApplicationContext.getContext()");
      localObject = ((Context)localObject).getResources().getString(2131762308);
      p.g(localObject, "MMApplicationContext.get…ing.live_like_count_zero)");
      AppMethodBeat.o(207726);
      return localObject;
    }
    if (hIu.LXG < 10000)
    {
      int i = hIu.LXG;
      AppMethodBeat.o(207726);
      return String.valueOf(i);
    }
    if (hIu.LXG % 10000 >= 1000)
    {
      localObject = ae.SYK;
      localObject = MMApplicationContext.getContext();
      p.g(localObject, "MMApplicationContext.getContext()");
      localObject = ((Context)localObject).getResources().getString(2131762306);
      p.g(localObject, "MMApplicationContext.get…g.live_like_count_format)");
      localObject = String.format((String)localObject, Arrays.copyOf(new Object[] { Float.valueOf(hIu.LXG / 10000.0F) }, 1));
      p.g(localObject, "java.lang.String.format(format, *args)");
      AppMethodBeat.o(207726);
      return localObject;
    }
    Object localObject = ae.SYK;
    localObject = MMApplicationContext.getContext();
    p.g(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getResources().getString(2131762307);
    p.g(localObject, "MMApplicationContext.get…ve_like_count_int_format)");
    localObject = String.format((String)localObject, Arrays.copyOf(new Object[] { Integer.valueOf(hIu.LXG / 10000) }, 1));
    p.g(localObject, "java.lang.String.format(format, *args)");
    AppMethodBeat.o(207726);
    return localObject;
  }
  
  public static String aHe()
  {
    AppMethodBeat.i(207727);
    String str2;
    String str1;
    if (Util.isNullOrNil(hIu.LpF))
    {
      str2 = hIu.MnO;
      str1 = str2;
      if (str2 == null)
      {
        AppMethodBeat.o(207727);
        return "";
      }
    }
    else
    {
      str2 = hIu.LpF;
      str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
    }
    AppMethodBeat.o(207727);
    return str1;
  }
  
  public static void aHf()
  {
    hIE.hJo = true;
    hIE.hJn = false;
  }
  
  public static void aHg()
  {
    hIE.hJp = true;
  }
  
  public static void aHh()
  {
    hIE.hJn = true;
    hIE.hJo = false;
  }
  
  public static void aHi()
  {
    AppMethodBeat.i(207731);
    Context localContext = context;
    if (localContext != null)
    {
      Object localObject;
      if ((localContext instanceof Activity))
      {
        if (!dMz) {
          break label51;
        }
        localObject = com.tencent.mm.live.core.core.a.b.hyv;
        com.tencent.mm.live.core.core.a.b.a.aDo().aBU();
      }
      for (;;)
      {
        ((Activity)localContext).finishAndRemoveTask();
        AppMethodBeat.o(207731);
        return;
        label51:
        localObject = com.tencent.mm.live.core.core.d.b.hCo;
        com.tencent.mm.live.core.core.d.b.a.aEf().aBU();
      }
    }
    AppMethodBeat.o(207731);
  }
  
  public static void ad(byte[] paramArrayOfByte)
  {
    hIt = paramArrayOfByte;
  }
  
  public static void and()
  {
    AppMethodBeat.i(207729);
    Log.printInfoStack(TAG, "resetData", new Object[0]);
    hIz = 0L;
    hFW = "";
    hIq.clear();
    hIr.clear();
    hIt = null;
    hIu = new civ();
    hIv = null;
    thumbUrl = null;
    com.tencent.mm.live.b.b.a locala = hJb;
    locala.hKM = null;
    locala.hKN = null;
    locala.hKO = null;
    locala.hKP = null;
    locala.hKQ = null;
    locala.hKR = null;
    locala.hKS = null;
    locala.hKU = null;
    locala.hKT.clear();
    locala.hKV = "";
    locala.hKW = "";
    hIs.clear();
    hIw = "";
    hIx = 0;
    hIy = null;
    hIA = new ciq();
    isManualClosed = false;
    lastOrientation = -1;
    hIB = "";
    hIC = "";
    hIG = new a((byte)0);
    hIH = new c();
    hID = false;
    hIE = new d((byte)0);
    hIF = new b();
    context = null;
    dMz = false;
    AppMethodBeat.o(207729);
  }
  
  public static void b(com.tencent.mm.live.core.core.b.f paramf)
  {
    hIy = paramf;
  }
  
  public static void eH(boolean paramBoolean)
  {
    hII = paramBoolean;
  }
  
  public static void eI(boolean paramBoolean)
  {
    hIJ = paramBoolean;
  }
  
  public static void eJ(boolean paramBoolean)
  {
    hIK = paramBoolean;
  }
  
  public static void eK(boolean paramBoolean)
  {
    hIL = paramBoolean;
  }
  
  public static void eL(boolean paramBoolean)
  {
    hIM = paramBoolean;
  }
  
  public static void eM(boolean paramBoolean)
  {
    hIV = paramBoolean;
  }
  
  public static void eN(boolean paramBoolean)
  {
    hJa = paramBoolean;
  }
  
  public static int getLastOrientation()
  {
    return lastOrientation;
  }
  
  public static boolean isManualClosed()
  {
    return isManualClosed;
  }
  
  public static void qT(int paramInt)
  {
    hIx = paramInt;
  }
  
  public static void qU(int paramInt)
  {
    if (hIN < paramInt) {
      hIN = paramInt;
    }
    while (paramInt != -1) {
      return;
    }
    hIN = 0;
  }
  
  public static void qV(int paramInt)
  {
    hIO = paramInt;
  }
  
  public static void qW(int paramInt)
  {
    hIP = paramInt;
  }
  
  public static void qX(int paramInt)
  {
    hIQ = paramInt;
  }
  
  public static void qY(int paramInt)
  {
    hIR = paramInt;
  }
  
  public static void qZ(int paramInt)
  {
    hIS = paramInt;
  }
  
  public static void ra(int paramInt)
  {
    hIT = paramInt;
  }
  
  public static void rb(int paramInt)
  {
    hIU = paramInt;
  }
  
  public static void rc(int paramInt)
  {
    hIW = paramInt;
  }
  
  public static void rd(int paramInt)
  {
    hIX = paramInt;
  }
  
  public static void re(int paramInt)
  {
    hIY = paramInt;
  }
  
  public static void setLastOrientation(int paramInt)
  {
    lastOrientation = paramInt;
  }
  
  public static void u(Context paramContext, boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(207730);
    p.h(paramContext, "context");
    dMz = paramBoolean;
    context = paramContext;
    int i = Util.getInt(h.aqJ().getValue("MMLiveConfigBitSet"), 0);
    paramContext = hIG;
    if (!d.cW(i, 1))
    {
      paramBoolean = true;
      paramContext.hJg = paramBoolean;
      paramContext = hIG;
      if (d.cW(i, 2)) {
        break label126;
      }
      paramBoolean = true;
      label70:
      paramContext.hJh = paramBoolean;
      paramContext = hIG;
      if (d.cW(i, 4)) {
        break label131;
      }
      paramBoolean = true;
      label89:
      paramContext.hJi = paramBoolean;
      paramContext = hIG;
      if (d.cW(i, 8)) {
        break label136;
      }
    }
    label131:
    label136:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      paramContext.hJj = paramBoolean;
      AppMethodBeat.o(207730);
      return;
      paramBoolean = false;
      break;
      label126:
      paramBoolean = false;
      break label70;
      paramBoolean = false;
      break label89;
    }
  }
  
  public static void zB(long paramLong)
  {
    hIz = paramLong;
  }
  
  public static void zC(long paramLong)
  {
    hIZ = paramLong;
  }
  
  public static void zD(long paramLong)
  {
    hJc = paramLong;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/RoomLiveService$LiveDynamicConfig;", "", "enableLandscape", "", "enableCheckPhoneNum", "enableVisitorPolicyPage", "enableVerifyPage", "(ZZZZ)V", "getEnableCheckPhoneNum", "()Z", "setEnableCheckPhoneNum", "(Z)V", "getEnableLandscape", "setEnableLandscape", "getEnableVerifyPage", "setEnableVerifyPage", "getEnableVisitorPolicyPage", "setEnableVisitorPolicyPage", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "plugin-logic_release"})
  public static final class a
  {
    public boolean hJg = true;
    boolean hJh = true;
    boolean hJi = true;
    boolean hJj = true;
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.hJg != paramObject.hJg) || (this.hJh != paramObject.hJh) || (this.hJi != paramObject.hJi) || (this.hJj != paramObject.hJj)) {}
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
      AppMethodBeat.i(207703);
      String str = "LiveDynamicConfig(enableLandscape=" + this.hJg + ", enableCheckPhoneNum=" + this.hJh + ", enableVisitorPolicyPage=" + this.hJi + ", enableVerifyPage=" + this.hJj + ")";
      AppMethodBeat.o(207703);
      return str;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/RoomLiveService$LiveFaceVerifyInfo;", "", "needFaceVerify", "", "verifyUrl", "", "isFromAnchor", "(ZLjava/lang/String;Z)V", "()Z", "setFromAnchor", "(Z)V", "getNeedFaceVerify", "setNeedFaceVerify", "getVerifyUrl", "()Ljava/lang/String;", "setVerifyUrl", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "plugin-logic_release"})
  public static final class b
  {
    public boolean hJk;
    public String hJl;
    public boolean hJm;
    
    private b(String paramString)
    {
      AppMethodBeat.i(207705);
      this.hJk = false;
      this.hJl = paramString;
      this.hJm = true;
      AppMethodBeat.o(207705);
    }
    
    public final void GW(String paramString)
    {
      AppMethodBeat.i(207704);
      p.h(paramString, "<set-?>");
      this.hJl = paramString;
      AppMethodBeat.o(207704);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(207709);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((this.hJk != paramObject.hJk) || (!p.j(this.hJl, paramObject.hJl)) || (this.hJm != paramObject.hJm)) {}
        }
      }
      else
      {
        AppMethodBeat.o(207709);
        return true;
      }
      AppMethodBeat.o(207709);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(207707);
      String str = "LiveFaceVerifyInfo(needFaceVerify=" + this.hJk + ", verifyUrl=" + this.hJl + ", isFromAnchor=" + this.hJm + ")";
      AppMethodBeat.o(207707);
      return str;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/RoomLiveService$LiveSmallWindowInfo;", "", "userId", "", "streamType", "", "width", "height", "(Ljava/lang/String;III)V", "getHeight", "()I", "setHeight", "(I)V", "getStreamType", "setStreamType", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "getWidth", "setWidth", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "isLandscape", "toString", "plugin-logic_release"})
  public static final class c
  {
    public int height;
    public int streamType;
    public String userId;
    public int width;
    
    private c(String paramString)
    {
      AppMethodBeat.i(207711);
      this.userId = paramString;
      this.streamType = 0;
      this.width = 0;
      this.height = 0;
      AppMethodBeat.o(207711);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(207715);
      if (this != paramObject)
      {
        if ((paramObject instanceof c))
        {
          paramObject = (c)paramObject;
          if ((!p.j(this.userId, paramObject.userId)) || (this.streamType != paramObject.streamType) || (this.width != paramObject.width) || (this.height != paramObject.height)) {}
        }
      }
      else
      {
        AppMethodBeat.o(207715);
        return true;
      }
      AppMethodBeat.o(207715);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(207714);
      String str = this.userId;
      if (str != null) {}
      for (int i = str.hashCode();; i = 0)
      {
        int j = this.streamType;
        int k = this.width;
        int m = this.height;
        AppMethodBeat.o(207714);
        return ((i * 31 + j) * 31 + k) * 31 + m;
      }
    }
    
    public final boolean isLandscape()
    {
      return this.width > this.height;
    }
    
    public final void setUserId(String paramString)
    {
      AppMethodBeat.i(207710);
      p.h(paramString, "<set-?>");
      this.userId = paramString;
      AppMethodBeat.o(207710);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(207713);
      String str = "LiveSmallWindowInfo(userId=" + this.userId + ", streamType=" + this.streamType + ", width=" + this.width + ", height=" + this.height + ")";
      AppMethodBeat.o(207713);
      return str;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/RoomLiveService$LiveStatus;", "", "liveFinished", "", "liveStarted", "liveHasError", "liveJumpToOtherUI", "(ZZZZ)V", "getLiveFinished", "()Z", "setLiveFinished", "(Z)V", "getLiveHasError", "setLiveHasError", "getLiveJumpToOtherUI", "setLiveJumpToOtherUI", "getLiveStarted", "setLiveStarted", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "plugin-logic_release"})
  public static final class d
  {
    public boolean hJn = false;
    public boolean hJo = false;
    public boolean hJp = false;
    public boolean hJq = false;
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof d))
        {
          paramObject = (d)paramObject;
          if ((this.hJn != paramObject.hJn) || (this.hJo != paramObject.hJo) || (this.hJp != paramObject.hJp) || (this.hJq != paramObject.hJq)) {}
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
      AppMethodBeat.i(207716);
      String str = "LiveStatus(liveFinished=" + this.hJn + ", liveStarted=" + this.hJo + ", liveHasError=" + this.hJp + ", liveJumpToOtherUI=" + this.hJq + ")";
      AppMethodBeat.o(207716);
      return str;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/live/model/RoomLiveService$mCheckDeviceLsn$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/LiveStateActionEvent;", "callback", "", "event", "plugin-logic_release"})
  public static final class e
    extends IListener<lv>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.x
 * JD-Core Version:    0.7.0.1
 */