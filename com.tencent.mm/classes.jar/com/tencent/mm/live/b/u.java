package com.tencent.mm.live.b;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.f.a.mm;
import com.tencent.mm.live.b.h;
import com.tencent.mm.live.core.core.a.b.b;
import com.tencent.mm.live.core.core.c.c;
import com.tencent.mm.live.core.core.c.c.a;
import com.tencent.mm.live.core.core.model.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.aq;
import com.tencent.mm.n.f;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.crq;
import com.tencent.mm.protocal.protobuf.crw;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/model/RoomLiveService;", "", "()V", "TAG", "", "anchorLinkSuccessCountPerShow", "", "getAnchorLinkSuccessCountPerShow", "()I", "setAnchorLinkSuccessCountPerShow", "(I)V", "anchorStatus", "Lcom/tencent/mm/protocal/protobuf/LiveAnchorStatus;", "getAnchorStatus", "()Lcom/tencent/mm/protocal/protobuf/LiveAnchorStatus;", "setAnchorStatus", "(Lcom/tencent/mm/protocal/protobuf/LiveAnchorStatus;)V", "anchorUserName", "getAnchorUserName", "()Ljava/lang/String;", "setAnchorUserName", "(Ljava/lang/String;)V", "value", "audienceCountMax", "getAudienceCountMax", "setAudienceCountMax", "beautyConfig", "Lcom/tencent/mm/live/core/render/BeautyConfig;", "getBeautyConfig", "()Lcom/tencent/mm/live/core/render/BeautyConfig;", "setBeautyConfig", "(Lcom/tencent/mm/live/core/render/BeautyConfig;)V", "callingMicNickname", "getCallingMicNickname", "setCallingMicNickname", "callingMicUsername", "getCallingMicUsername", "setCallingMicUsername", "context", "Landroid/content/Context;", "enterFromScene", "getEnterFromScene", "setEnterFromScene", "filterConfig", "Lcom/tencent/mm/live/core/render/FilterConfig;", "getFilterConfig", "()Lcom/tencent/mm/live/core/render/FilterConfig;", "setFilterConfig", "(Lcom/tencent/mm/live/core/render/FilterConfig;)V", "hasChangeVideoModePerLinkMic", "", "getHasChangeVideoModePerLinkMic", "()Z", "setHasChangeVideoModePerLinkMic", "(Z)V", "isAnchor", "isClickStartLive", "setClickStartLive", "isForeigner", "setForeigner", "isLiveNameChanged", "setLiveNameChanged", "isManualClosed", "setManualClosed", "isStartLiveReport", "setStartLiveReport", "isVerifyChecked", "setVerifyChecked", "isVerifyUiShow", "setVerifyUiShow", "isVisitorReport", "setVisitorReport", "lastOrientation", "getLastOrientation", "setLastOrientation", "linkMicRequestCount", "getLinkMicRequestCount", "setLinkMicRequestCount", "liveCookies", "", "getLiveCookies", "()[B", "setLiveCookies", "([B)V", "liveDynamicConfig", "Lcom/tencent/mm/live/model/RoomLiveService$LiveDynamicConfig;", "getLiveDynamicConfig", "()Lcom/tencent/mm/live/model/RoomLiveService$LiveDynamicConfig;", "setLiveDynamicConfig", "(Lcom/tencent/mm/live/model/RoomLiveService$LiveDynamicConfig;)V", "liveFaceVerifyInfo", "Lcom/tencent/mm/live/model/RoomLiveService$LiveFaceVerifyInfo;", "getLiveFaceVerifyInfo", "()Lcom/tencent/mm/live/model/RoomLiveService$LiveFaceVerifyInfo;", "setLiveFaceVerifyInfo", "(Lcom/tencent/mm/live/model/RoomLiveService$LiveFaceVerifyInfo;)V", "liveInfo", "Lcom/tencent/mm/protocal/protobuf/LiveInfo;", "getLiveInfo", "()Lcom/tencent/mm/protocal/protobuf/LiveInfo;", "setLiveInfo", "(Lcom/tencent/mm/protocal/protobuf/LiveInfo;)V", "liveRoomModel", "Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "getLiveRoomModel", "()Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "setLiveRoomModel", "(Lcom/tencent/mm/live/core/core/model/LiveRoomModel;)V", "liveSdkInfo", "Lcom/tencent/mm/protocal/protobuf/LiveSdkInfo;", "getLiveSdkInfo", "()Lcom/tencent/mm/protocal/protobuf/LiveSdkInfo;", "setLiveSdkInfo", "(Lcom/tencent/mm/protocal/protobuf/LiveSdkInfo;)V", "liveSmallWindowInfo", "Lcom/tencent/mm/live/model/RoomLiveService$LiveSmallWindowInfo;", "getLiveSmallWindowInfo", "()Lcom/tencent/mm/live/model/RoomLiveService$LiveSmallWindowInfo;", "setLiveSmallWindowInfo", "(Lcom/tencent/mm/live/model/RoomLiveService$LiveSmallWindowInfo;)V", "liveStatus", "Lcom/tencent/mm/live/model/RoomLiveService$LiveStatus;", "getLiveStatus", "()Lcom/tencent/mm/live/model/RoomLiveService$LiveStatus;", "setLiveStatus", "(Lcom/tencent/mm/live/model/RoomLiveService$LiveStatus;)V", "mCheckDeviceLsn", "com/tencent/mm/live/model/RoomLiveService$mCheckDeviceLsn$1", "Lcom/tencent/mm/live/model/RoomLiveService$mCheckDeviceLsn$1;", "mLastOrientation", "getMLastOrientation", "setMLastOrientation", "mStartLinkTimes", "", "getMStartLinkTimes", "()J", "setMStartLinkTimes", "(J)V", "micPmkExpire", "getMicPmkExpire", "setMicPmkExpire", "miniWindowClickListener", "Landroid/view/View$OnClickListener;", "getMiniWindowClickListener", "()Landroid/view/View$OnClickListener;", "setMiniWindowClickListener", "(Landroid/view/View$OnClickListener;)V", "msgFilterTime", "getMsgFilterTime", "setMsgFilterTime", "msgList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/view/adapter/CommentData;", "Lkotlin/collections/ArrayList;", "getMsgList", "()Ljava/util/ArrayList;", "setMsgList", "(Ljava/util/ArrayList;)V", "onlineHeadImgList", "getOnlineHeadImgList", "setOnlineHeadImgList", "shareRoomList", "Ljava/util/HashMap;", "Lkotlin/Pair;", "Lkotlin/collections/HashMap;", "getShareRoomList", "()Ljava/util/HashMap;", "setShareRoomList", "(Ljava/util/HashMap;)V", "startAudienceUV", "getStartAudienceUV", "setStartAudienceUV", "sysMsgManager", "Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager;", "getSysMsgManager", "()Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager;", "setSysMsgManager", "(Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager;)V", "thumbUrl", "getThumbUrl", "setThumbUrl", "visitorCommentCount", "getVisitorCommentCount", "setVisitorCommentCount", "visitorConnectCount", "getVisitorConnectCount", "setVisitorConnectCount", "visitorConnectReqCount", "getVisitorConnectReqCount", "setVisitorConnectReqCount", "visitorEnterErrorCode", "getVisitorEnterErrorCode", "setVisitorEnterErrorCode", "visitorEnterMemberCount", "getVisitorEnterMemberCount", "setVisitorEnterMemberCount", "visitorLikeCount", "getVisitorLikeCount", "setVisitorLikeCount", "wechatRoomId", "getWechatRoomId", "setWechatRoomId", "displayLiveName", "displayUsername", "username", "finishCurLive", "", "formatLikeCount", "liveError", "liveFinish", "liveStart", "release", "resetData", "resetLiveFaceVerifyInfo", "setup", "LiveDynamicConfig", "LiveFaceVerifyInfo", "LiveSmallWindowInfo", "LiveStatus", "plugin-logic_release"})
public final class u
{
  private static final String TAG = "MicroMsg.LiveDataManager";
  private static Context context;
  private static boolean fFE;
  private static boolean isManualClosed;
  private static com.tencent.mm.live.core.b.a knC;
  private static com.tencent.mm.live.core.b.b knD;
  private static String ktU;
  private static ArrayList<String> kvK;
  private static HashMap<String, o<ArrayList<String>, Integer>> kvL;
  private static ArrayList<com.tencent.mm.live.view.a.a> kvM;
  private static byte[] kvN;
  private static crq kvO;
  private static crw kvP;
  private static String kvQ;
  private static int kvR;
  private static g kvS;
  private static long kvT;
  private static crm kvU;
  private static String kvV;
  private static String kvW;
  private static boolean kvX;
  private static d kvY;
  private static b kvZ;
  private static a kwa;
  private static c kwb;
  private static boolean kwc;
  private static boolean kwd;
  private static boolean kwe;
  private static boolean kwf;
  private static boolean kwg;
  private static int kwh;
  private static int kwi;
  private static int kwj;
  private static int kwk;
  private static int kwl;
  private static int kwm;
  private static int kwn;
  private static int kwo;
  private static boolean kwp;
  private static int kwq;
  private static int kwr;
  private static int kws;
  private static long kwt;
  private static boolean kwu;
  private static com.tencent.mm.live.b.b.a kwv;
  private static long kww;
  private static final e kwx;
  private static View.OnClickListener kwy;
  public static final u kwz;
  private static int lastOrientation;
  private static String thumbUrl;
  
  static
  {
    AppMethodBeat.i(197402);
    kwz = new u();
    TAG = "MicroMsg.LiveDataManager";
    com.tencent.mm.live.core.b.a locala = new com.tencent.mm.live.core.b.a();
    ((Map)locala.kra).put(Integer.valueOf(0), Integer.valueOf(60));
    ((Map)locala.kra).put(Integer.valueOf(1), Integer.valueOf(-1));
    ((Map)locala.kra).put(Integer.valueOf(4), Integer.valueOf(-1));
    ((Map)locala.kra).put(Integer.valueOf(2), Integer.valueOf(-1));
    ((Map)locala.kra).put(Integer.valueOf(5), Integer.valueOf(-1));
    ((Map)locala.kra).put(Integer.valueOf(3), Integer.valueOf(-1));
    knC = locala;
    ktU = "";
    kvK = new ArrayList();
    kvL = new HashMap();
    kvM = new ArrayList();
    kvO = new crq();
    kvQ = "";
    kvU = new crm();
    lastOrientation = -1;
    kvV = "";
    kvW = "";
    kvY = new d((byte)0);
    kvZ = new b();
    kwa = new a((byte)0);
    kwb = new c();
    kwk = -1;
    kwv = new com.tencent.mm.live.b.b.a();
    kwx = new e();
    kwy = (View.OnClickListener)u.f.kwL;
    kwx.alive();
    AppMethodBeat.o(197402);
  }
  
  public static void FI(long paramLong)
  {
    kvT = paramLong;
  }
  
  public static void FJ(long paramLong)
  {
    kwt = paramLong;
  }
  
  public static void FK(long paramLong)
  {
    kww = paramLong;
  }
  
  public static void Ob(String paramString)
  {
    AppMethodBeat.i(197273);
    p.k(paramString, "<set-?>");
    ktU = paramString;
    AppMethodBeat.o(197273);
  }
  
  public static void Oc(String paramString)
  {
    thumbUrl = paramString;
  }
  
  public static void Od(String paramString)
  {
    AppMethodBeat.i(197289);
    p.k(paramString, "<set-?>");
    kvQ = paramString;
    AppMethodBeat.o(197289);
  }
  
  public static void Oe(String paramString)
  {
    AppMethodBeat.i(197311);
    p.k(paramString, "<set-?>");
    kvV = paramString;
    AppMethodBeat.o(197311);
  }
  
  public static void Of(String paramString)
  {
    AppMethodBeat.i(197314);
    p.k(paramString, "<set-?>");
    kvW = paramString;
    AppMethodBeat.o(197314);
  }
  
  public static String Og(String paramString)
  {
    AppMethodBeat.i(197365);
    if (paramString == null)
    {
      AppMethodBeat.o(197365);
      return "";
    }
    String str = aa.PK(paramString);
    Object localObject = str;
    if (Util.isNullOrNil(str))
    {
      localObject = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class);
      p.j(localObject, "MMKernel.service(IChatroomService::class.java)");
      localObject = ((com.tencent.mm.plugin.chatroom.a.b)localObject).bbV().Rw(ktU);
      if (localObject != null) {
        break label90;
      }
      localObject = aa.PJ(paramString);
    }
    for (;;)
    {
      p.j(localObject, "result");
      AppMethodBeat.o(197365);
      return localObject;
      label90:
      str = ((ah)localObject).PJ(paramString);
      localObject = str;
      if (Util.isNullOrNil(str)) {
        localObject = aa.PJ(paramString);
      }
    }
  }
  
  public static void a(crm paramcrm)
  {
    AppMethodBeat.i(197300);
    p.k(paramcrm, "<set-?>");
    kvU = paramcrm;
    AppMethodBeat.o(197300);
  }
  
  public static void a(crq paramcrq)
  {
    AppMethodBeat.i(197279);
    p.k(paramcrq, "<set-?>");
    kvO = paramcrq;
    AppMethodBeat.o(197279);
  }
  
  public static void a(crw paramcrw)
  {
    kvP = paramcrw;
  }
  
  public static String aOA()
  {
    return kvW;
  }
  
  public static boolean aOB()
  {
    return kvX;
  }
  
  public static void aOC()
  {
    kvX = true;
  }
  
  public static d aOD()
  {
    return kvY;
  }
  
  public static b aOE()
  {
    return kvZ;
  }
  
  public static a aOF()
  {
    return kwa;
  }
  
  public static c aOG()
  {
    return kwb;
  }
  
  public static boolean aOH()
  {
    return kwc;
  }
  
  public static boolean aOI()
  {
    return kwd;
  }
  
  public static boolean aOJ()
  {
    return kwe;
  }
  
  public static boolean aOK()
  {
    return kwf;
  }
  
  public static boolean aOL()
  {
    return kwg;
  }
  
  public static int aOM()
  {
    return kwh;
  }
  
  public static int aON()
  {
    return kwi;
  }
  
  public static int aOO()
  {
    return kwj;
  }
  
  public static int aOP()
  {
    return kwk;
  }
  
  public static int aOQ()
  {
    return kwl;
  }
  
  public static int aOR()
  {
    return kwm;
  }
  
  public static int aOS()
  {
    return kwn;
  }
  
  public static int aOT()
  {
    return kwo;
  }
  
  public static boolean aOU()
  {
    return kwp;
  }
  
  public static int aOV()
  {
    return kwq;
  }
  
  public static int aOW()
  {
    return kwr;
  }
  
  public static int aOX()
  {
    return kws;
  }
  
  public static long aOY()
  {
    return kwt;
  }
  
  public static boolean aOZ()
  {
    return kwu;
  }
  
  public static com.tencent.mm.live.core.b.a aOk()
  {
    return knC;
  }
  
  public static com.tencent.mm.live.core.b.b aOl()
  {
    return knD;
  }
  
  public static String aOm()
  {
    return ktU;
  }
  
  public static ArrayList<String> aOn()
  {
    return kvK;
  }
  
  public static HashMap<String, o<ArrayList<String>, Integer>> aOo()
  {
    return kvL;
  }
  
  public static ArrayList<com.tencent.mm.live.view.a.a> aOp()
  {
    return kvM;
  }
  
  public static byte[] aOq()
  {
    return kvN;
  }
  
  public static crq aOr()
  {
    return kvO;
  }
  
  public static crw aOs()
  {
    return kvP;
  }
  
  public static String aOt()
  {
    return kvQ;
  }
  
  public static int aOu()
  {
    return kvR;
  }
  
  public static g aOv()
  {
    return kvS;
  }
  
  public static long aOw()
  {
    return kvT;
  }
  
  public static crm aOx()
  {
    return kvU;
  }
  
  public static void aOy()
  {
    isManualClosed = true;
  }
  
  public static String aOz()
  {
    return kvV;
  }
  
  public static com.tencent.mm.live.b.b.a aPa()
  {
    return kwv;
  }
  
  public static long aPb()
  {
    return kww;
  }
  
  public static View.OnClickListener aPc()
  {
    return kwy;
  }
  
  public static String aPd()
  {
    AppMethodBeat.i(197359);
    if (kvO.TgX <= 0)
    {
      localObject = MMApplicationContext.getContext();
      p.j(localObject, "MMApplicationContext.getContext()");
      localObject = ((Context)localObject).getResources().getString(b.h.live_like_count_zero);
      p.j(localObject, "MMApplicationContext.get…ing.live_like_count_zero)");
      AppMethodBeat.o(197359);
      return localObject;
    }
    if (kvO.TgX < 10000)
    {
      int i = kvO.TgX;
      AppMethodBeat.o(197359);
      return String.valueOf(i);
    }
    if (kvO.TgX % 10000 >= 1000)
    {
      localObject = af.aaBG;
      localObject = MMApplicationContext.getContext();
      p.j(localObject, "MMApplicationContext.getContext()");
      localObject = ((Context)localObject).getResources().getString(b.h.live_like_count_format);
      p.j(localObject, "MMApplicationContext.get…g.live_like_count_format)");
      localObject = String.format((String)localObject, Arrays.copyOf(new Object[] { Float.valueOf(kvO.TgX / 10000.0F) }, 1));
      p.j(localObject, "java.lang.String.format(format, *args)");
      AppMethodBeat.o(197359);
      return localObject;
    }
    Object localObject = af.aaBG;
    localObject = MMApplicationContext.getContext();
    p.j(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getResources().getString(b.h.live_like_count_int_format);
    p.j(localObject, "MMApplicationContext.get…ve_like_count_int_format)");
    localObject = String.format((String)localObject, Arrays.copyOf(new Object[] { Integer.valueOf(kvO.TgX / 10000) }, 1));
    p.j(localObject, "java.lang.String.format(format, *args)");
    AppMethodBeat.o(197359);
    return localObject;
  }
  
  public static String aPe()
  {
    AppMethodBeat.i(197361);
    String str2;
    String str1;
    if (Util.isNullOrNil(kvO.Srb))
    {
      str2 = kvO.TyI;
      str1 = str2;
      if (str2 == null)
      {
        AppMethodBeat.o(197361);
        return "";
      }
    }
    else
    {
      str2 = kvO.Srb;
      str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
    }
    AppMethodBeat.o(197361);
    return str1;
  }
  
  public static void aPf()
  {
    kvY.kwI = true;
    kvY.kwH = false;
  }
  
  public static void aPg()
  {
    kvY.kwJ = true;
  }
  
  public static void aPh()
  {
    kvY.kwH = true;
    kvY.kwI = false;
  }
  
  public static void aPi()
  {
    AppMethodBeat.i(197391);
    Context localContext = context;
    if (localContext != null)
    {
      Object localObject;
      if ((localContext instanceof Activity))
      {
        if (!fFE) {
          break label51;
        }
        localObject = com.tencent.mm.live.core.core.a.b.klq;
        b.b.aLh().aJz();
      }
      for (;;)
      {
        ((Activity)localContext).finishAndRemoveTask();
        AppMethodBeat.o(197391);
        return;
        label51:
        localObject = c.kqq;
        c.a.aMm().aJz();
      }
    }
    AppMethodBeat.o(197391);
  }
  
  public static void am(byte[] paramArrayOfByte)
  {
    kvN = paramArrayOfByte;
  }
  
  public static void ate()
  {
    AppMethodBeat.i(197379);
    Log.printInfoStack(TAG, "resetData", new Object[0]);
    kvT = 0L;
    ktU = "";
    kvK.clear();
    kvL.clear();
    kvN = null;
    kvO = new crq();
    kvP = null;
    thumbUrl = null;
    com.tencent.mm.live.b.b.a locala = kwv;
    locala.kyg = null;
    locala.kyh = null;
    locala.kyi = null;
    locala.kyj = null;
    locala.kyk = null;
    locala.kyl = null;
    locala.kym = null;
    locala.kyo = null;
    locala.kyn.clear();
    locala.kyp = "";
    locala.kyq = "";
    kvM.clear();
    kvQ = "";
    kvR = 0;
    kvS = null;
    kvU = new crm();
    isManualClosed = false;
    lastOrientation = -1;
    kvV = "";
    kvW = "";
    kwa = new a((byte)0);
    kwb = new c();
    kvX = false;
    kvY = new d((byte)0);
    kvZ = new b();
    context = null;
    fFE = false;
    AppMethodBeat.o(197379);
  }
  
  public static void b(g paramg)
  {
    kvS = paramg;
  }
  
  public static void fn(boolean paramBoolean)
  {
    kwc = paramBoolean;
  }
  
  public static void fo(boolean paramBoolean)
  {
    kwd = paramBoolean;
  }
  
  public static void fp(boolean paramBoolean)
  {
    kwe = paramBoolean;
  }
  
  public static void fq(boolean paramBoolean)
  {
    kwf = paramBoolean;
  }
  
  public static void fr(boolean paramBoolean)
  {
    kwg = paramBoolean;
  }
  
  public static void fs(boolean paramBoolean)
  {
    kwp = paramBoolean;
  }
  
  public static void ft(boolean paramBoolean)
  {
    kwu = paramBoolean;
  }
  
  public static int getLastOrientation()
  {
    return lastOrientation;
  }
  
  public static boolean isManualClosed()
  {
    return isManualClosed;
  }
  
  public static void setLastOrientation(int paramInt)
  {
    lastOrientation = paramInt;
  }
  
  public static void tI(int paramInt)
  {
    kvR = paramInt;
  }
  
  public static void tJ(int paramInt)
  {
    if (kwh < paramInt) {
      kwh = paramInt;
    }
    while (paramInt != -1) {
      return;
    }
    kwh = 0;
  }
  
  public static void tK(int paramInt)
  {
    kwi = paramInt;
  }
  
  public static void tL(int paramInt)
  {
    kwj = paramInt;
  }
  
  public static void tM(int paramInt)
  {
    kwk = paramInt;
  }
  
  public static void tN(int paramInt)
  {
    kwl = paramInt;
  }
  
  public static void tO(int paramInt)
  {
    kwm = paramInt;
  }
  
  public static void tP(int paramInt)
  {
    kwn = paramInt;
  }
  
  public static void tQ(int paramInt)
  {
    kwo = paramInt;
  }
  
  public static void tR(int paramInt)
  {
    kwq = paramInt;
  }
  
  public static void tS(int paramInt)
  {
    kwr = paramInt;
  }
  
  public static void tT(int paramInt)
  {
    kws = paramInt;
  }
  
  public static void x(Context paramContext, boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(197386);
    p.k(paramContext, "context");
    fFE = paramBoolean;
    context = paramContext;
    int i = Util.getInt(com.tencent.mm.n.h.axc().getValue("MMLiveConfigBitSet"), 0);
    paramContext = kwa;
    if (!d.dr(i, 1))
    {
      paramBoolean = true;
      paramContext.kwA = paramBoolean;
      paramContext = kwa;
      if (d.dr(i, 2)) {
        break label126;
      }
      paramBoolean = true;
      label70:
      paramContext.kwB = paramBoolean;
      paramContext = kwa;
      if (d.dr(i, 4)) {
        break label131;
      }
      paramBoolean = true;
      label89:
      paramContext.kwC = paramBoolean;
      paramContext = kwa;
      if (d.dr(i, 8)) {
        break label136;
      }
    }
    label131:
    label136:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      paramContext.kwD = paramBoolean;
      AppMethodBeat.o(197386);
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/model/RoomLiveService$LiveDynamicConfig;", "", "enableLandscape", "", "enableCheckPhoneNum", "enableVisitorPolicyPage", "enableVerifyPage", "(ZZZZ)V", "getEnableCheckPhoneNum", "()Z", "setEnableCheckPhoneNum", "(Z)V", "getEnableLandscape", "setEnableLandscape", "getEnableVerifyPage", "setEnableVerifyPage", "getEnableVisitorPolicyPage", "setEnableVisitorPolicyPage", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "plugin-logic_release"})
  public static final class a
  {
    public boolean kwA = true;
    boolean kwB = true;
    boolean kwC = true;
    boolean kwD = true;
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.kwA != paramObject.kwA) || (this.kwB != paramObject.kwB) || (this.kwC != paramObject.kwC) || (this.kwD != paramObject.kwD)) {}
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
      AppMethodBeat.i(201662);
      String str = "LiveDynamicConfig(enableLandscape=" + this.kwA + ", enableCheckPhoneNum=" + this.kwB + ", enableVisitorPolicyPage=" + this.kwC + ", enableVerifyPage=" + this.kwD + ")";
      AppMethodBeat.o(201662);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/model/RoomLiveService$LiveFaceVerifyInfo;", "", "needFaceVerify", "", "verifyUrl", "", "isFromAnchor", "(ZLjava/lang/String;Z)V", "()Z", "setFromAnchor", "(Z)V", "getNeedFaceVerify", "setNeedFaceVerify", "getVerifyUrl", "()Ljava/lang/String;", "setVerifyUrl", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "plugin-logic_release"})
  public static final class b
  {
    public boolean kwE;
    public String kwF;
    public boolean kwG;
    
    private b(String paramString)
    {
      AppMethodBeat.i(201835);
      this.kwE = false;
      this.kwF = paramString;
      this.kwG = true;
      AppMethodBeat.o(201835);
    }
    
    public final void Oh(String paramString)
    {
      AppMethodBeat.i(201832);
      p.k(paramString, "<set-?>");
      this.kwF = paramString;
      AppMethodBeat.o(201832);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(201847);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((this.kwE != paramObject.kwE) || (!p.h(this.kwF, paramObject.kwF)) || (this.kwG != paramObject.kwG)) {}
        }
      }
      else
      {
        AppMethodBeat.o(201847);
        return true;
      }
      AppMethodBeat.o(201847);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(201842);
      String str = "LiveFaceVerifyInfo(needFaceVerify=" + this.kwE + ", verifyUrl=" + this.kwF + ", isFromAnchor=" + this.kwG + ")";
      AppMethodBeat.o(201842);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/model/RoomLiveService$LiveSmallWindowInfo;", "", "userId", "", "streamType", "", "width", "height", "(Ljava/lang/String;III)V", "getHeight", "()I", "setHeight", "(I)V", "getStreamType", "setStreamType", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "getWidth", "setWidth", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "isLandscape", "toString", "plugin-logic_release"})
  public static final class c
  {
    public int height;
    public int streamType;
    public String userId;
    public int width;
    
    private c(String paramString)
    {
      AppMethodBeat.i(196687);
      this.userId = paramString;
      this.streamType = 0;
      this.width = 0;
      this.height = 0;
      AppMethodBeat.o(196687);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(196698);
      if (this != paramObject)
      {
        if ((paramObject instanceof c))
        {
          paramObject = (c)paramObject;
          if ((!p.h(this.userId, paramObject.userId)) || (this.streamType != paramObject.streamType) || (this.width != paramObject.width) || (this.height != paramObject.height)) {}
        }
      }
      else
      {
        AppMethodBeat.o(196698);
        return true;
      }
      AppMethodBeat.o(196698);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(196694);
      String str = this.userId;
      if (str != null) {}
      for (int i = str.hashCode();; i = 0)
      {
        int j = this.streamType;
        int k = this.width;
        int m = this.height;
        AppMethodBeat.o(196694);
        return ((i * 31 + j) * 31 + k) * 31 + m;
      }
    }
    
    public final boolean isLandscape()
    {
      return this.width > this.height;
    }
    
    public final void setUserId(String paramString)
    {
      AppMethodBeat.i(196684);
      p.k(paramString, "<set-?>");
      this.userId = paramString;
      AppMethodBeat.o(196684);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(196689);
      String str = "LiveSmallWindowInfo(userId=" + this.userId + ", streamType=" + this.streamType + ", width=" + this.width + ", height=" + this.height + ")";
      AppMethodBeat.o(196689);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/model/RoomLiveService$LiveStatus;", "", "liveFinished", "", "liveStarted", "liveHasError", "liveJumpToOtherUI", "(ZZZZ)V", "getLiveFinished", "()Z", "setLiveFinished", "(Z)V", "getLiveHasError", "setLiveHasError", "getLiveJumpToOtherUI", "setLiveJumpToOtherUI", "getLiveStarted", "setLiveStarted", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "plugin-logic_release"})
  public static final class d
  {
    public boolean kwH = false;
    public boolean kwI = false;
    public boolean kwJ = false;
    public boolean kwK = false;
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof d))
        {
          paramObject = (d)paramObject;
          if ((this.kwH != paramObject.kwH) || (this.kwI != paramObject.kwI) || (this.kwJ != paramObject.kwJ) || (this.kwK != paramObject.kwK)) {}
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
      AppMethodBeat.i(198267);
      String str = "LiveStatus(liveFinished=" + this.kwH + ", liveStarted=" + this.kwI + ", liveHasError=" + this.kwJ + ", liveJumpToOtherUI=" + this.kwK + ")";
      AppMethodBeat.o(198267);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/live/model/RoomLiveService$mCheckDeviceLsn$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/LiveStateActionEvent;", "callback", "", "event", "plugin-logic_release"})
  public static final class e
    extends IListener<mm>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.b.u
 * JD-Core Version:    0.7.0.1
 */