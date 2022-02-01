package com.tencent.mm.live.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.k.i;
import com.tencent.mm.live.b.h;
import com.tencent.mm.live.core.core.a.b.a;
import com.tencent.mm.live.core.core.f.d.a;
import com.tencent.mm.live.ui.LiveUIA;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ar;
import com.tencent.mm.protocal.protobuf.dih;
import com.tencent.mm.protocal.protobuf.dio;
import com.tencent.mm.protocal.protobuf.dix;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aj;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.am;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/model/RoomLiveService;", "", "()V", "TAG", "", "anchorLinkSuccessCountPerShow", "", "getAnchorLinkSuccessCountPerShow", "()I", "setAnchorLinkSuccessCountPerShow", "(I)V", "anchorStatus", "Lcom/tencent/mm/protocal/protobuf/LiveAnchorStatus;", "getAnchorStatus", "()Lcom/tencent/mm/protocal/protobuf/LiveAnchorStatus;", "setAnchorStatus", "(Lcom/tencent/mm/protocal/protobuf/LiveAnchorStatus;)V", "anchorUserName", "getAnchorUserName", "()Ljava/lang/String;", "setAnchorUserName", "(Ljava/lang/String;)V", "value", "audienceCountMax", "getAudienceCountMax", "setAudienceCountMax", "beautyConfig", "Lcom/tencent/mm/live/core/render/BeautyConfig;", "getBeautyConfig", "()Lcom/tencent/mm/live/core/render/BeautyConfig;", "setBeautyConfig", "(Lcom/tencent/mm/live/core/render/BeautyConfig;)V", "callingMicNickname", "getCallingMicNickname", "setCallingMicNickname", "callingMicUsername", "getCallingMicUsername", "setCallingMicUsername", "context", "Landroid/content/Context;", "enterFromScene", "getEnterFromScene", "setEnterFromScene", "filterConfig", "Lcom/tencent/mm/live/core/render/FilterConfig;", "getFilterConfig", "()Lcom/tencent/mm/live/core/render/FilterConfig;", "setFilterConfig", "(Lcom/tencent/mm/live/core/render/FilterConfig;)V", "hasChangeVideoModePerLinkMic", "", "getHasChangeVideoModePerLinkMic", "()Z", "setHasChangeVideoModePerLinkMic", "(Z)V", "isAnchor", "isClickStartLive", "setClickStartLive", "isForeigner", "setForeigner", "isLiveNameChanged", "setLiveNameChanged", "isManualClosed", "setManualClosed", "isStartLiveReport", "setStartLiveReport", "isVerifyChecked", "setVerifyChecked", "isVerifyUiShow", "setVerifyUiShow", "isVisitorReport", "setVisitorReport", "lastOrientation", "getLastOrientation", "setLastOrientation", "linkMicRequestCount", "getLinkMicRequestCount", "setLinkMicRequestCount", "liveCookies", "", "getLiveCookies", "()[B", "setLiveCookies", "([B)V", "liveDynamicConfig", "Lcom/tencent/mm/live/model/RoomLiveService$LiveDynamicConfig;", "getLiveDynamicConfig", "()Lcom/tencent/mm/live/model/RoomLiveService$LiveDynamicConfig;", "setLiveDynamicConfig", "(Lcom/tencent/mm/live/model/RoomLiveService$LiveDynamicConfig;)V", "liveFaceVerifyInfo", "Lcom/tencent/mm/live/model/RoomLiveService$LiveFaceVerifyInfo;", "getLiveFaceVerifyInfo", "()Lcom/tencent/mm/live/model/RoomLiveService$LiveFaceVerifyInfo;", "setLiveFaceVerifyInfo", "(Lcom/tencent/mm/live/model/RoomLiveService$LiveFaceVerifyInfo;)V", "liveInfo", "Lcom/tencent/mm/protocal/protobuf/LiveInfo;", "getLiveInfo", "()Lcom/tencent/mm/protocal/protobuf/LiveInfo;", "setLiveInfo", "(Lcom/tencent/mm/protocal/protobuf/LiveInfo;)V", "liveRoomModel", "Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "getLiveRoomModel", "()Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "setLiveRoomModel", "(Lcom/tencent/mm/live/core/core/model/LiveRoomModel;)V", "liveSdkInfo", "Lcom/tencent/mm/protocal/protobuf/LiveSdkInfo;", "getLiveSdkInfo", "()Lcom/tencent/mm/protocal/protobuf/LiveSdkInfo;", "setLiveSdkInfo", "(Lcom/tencent/mm/protocal/protobuf/LiveSdkInfo;)V", "liveSmallWindowInfo", "Lcom/tencent/mm/live/model/RoomLiveService$LiveSmallWindowInfo;", "getLiveSmallWindowInfo", "()Lcom/tencent/mm/live/model/RoomLiveService$LiveSmallWindowInfo;", "setLiveSmallWindowInfo", "(Lcom/tencent/mm/live/model/RoomLiveService$LiveSmallWindowInfo;)V", "liveStatus", "Lcom/tencent/mm/live/model/RoomLiveService$LiveStatus;", "getLiveStatus", "()Lcom/tencent/mm/live/model/RoomLiveService$LiveStatus;", "setLiveStatus", "(Lcom/tencent/mm/live/model/RoomLiveService$LiveStatus;)V", "mCheckDeviceLsn", "com/tencent/mm/live/model/RoomLiveService$mCheckDeviceLsn$1", "Lcom/tencent/mm/live/model/RoomLiveService$mCheckDeviceLsn$1;", "mLastOrientation", "getMLastOrientation", "setMLastOrientation", "mStartLinkTimes", "", "getMStartLinkTimes", "()J", "setMStartLinkTimes", "(J)V", "micPmkExpire", "getMicPmkExpire", "setMicPmkExpire", "miniWindowClickListener", "Landroid/view/View$OnClickListener;", "getMiniWindowClickListener", "()Landroid/view/View$OnClickListener;", "setMiniWindowClickListener", "(Landroid/view/View$OnClickListener;)V", "msgFilterTime", "getMsgFilterTime", "setMsgFilterTime", "msgList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/view/adapter/CommentData;", "Lkotlin/collections/ArrayList;", "getMsgList", "()Ljava/util/ArrayList;", "setMsgList", "(Ljava/util/ArrayList;)V", "onlineHeadImgList", "getOnlineHeadImgList", "setOnlineHeadImgList", "shareRoomList", "Ljava/util/HashMap;", "Lkotlin/Pair;", "Lkotlin/collections/HashMap;", "getShareRoomList", "()Ljava/util/HashMap;", "setShareRoomList", "(Ljava/util/HashMap;)V", "startAudienceUV", "getStartAudienceUV", "setStartAudienceUV", "sysMsgManager", "Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager;", "getSysMsgManager", "()Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager;", "setSysMsgManager", "(Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager;)V", "thumbUrl", "getThumbUrl", "setThumbUrl", "visitorCommentCount", "getVisitorCommentCount", "setVisitorCommentCount", "visitorConnectCount", "getVisitorConnectCount", "setVisitorConnectCount", "visitorConnectReqCount", "getVisitorConnectReqCount", "setVisitorConnectReqCount", "visitorEnterErrorCode", "getVisitorEnterErrorCode", "setVisitorEnterErrorCode", "visitorEnterMemberCount", "getVisitorEnterMemberCount", "setVisitorEnterMemberCount", "visitorLikeCount", "getVisitorLikeCount", "setVisitorLikeCount", "wechatRoomId", "getWechatRoomId", "setWechatRoomId", "displayLiveName", "displayUsername", "username", "finishCurLive", "", "formatLikeCount", "liveError", "liveFinish", "liveStart", "release", "resetData", "resetLiveFaceVerifyInfo", "setup", "LiveDynamicConfig", "LiveFaceVerifyInfo", "LiveSmallWindowInfo", "LiveStatus", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class u
{
  private static final String TAG;
  private static Context context;
  private static boolean hKC;
  private static boolean isManualClosed;
  private static int lastOrientation;
  private static com.tencent.mm.live.core.b.a mRD;
  private static com.tencent.mm.live.core.b.b mRE;
  private static String mXO;
  private static u.d mZA;
  private static u.b mZB;
  private static u.a mZC;
  private static c mZD;
  private static boolean mZE;
  private static boolean mZF;
  private static boolean mZG;
  private static boolean mZH;
  private static boolean mZI;
  private static int mZJ;
  private static int mZK;
  private static int mZL;
  private static int mZM;
  private static int mZN;
  private static int mZO;
  private static int mZP;
  private static int mZQ;
  private static boolean mZR;
  private static int mZS;
  private static int mZT;
  private static int mZU;
  private static long mZV;
  private static boolean mZW;
  private static com.tencent.mm.live.model.b.a mZX;
  private static long mZY;
  private static final RoomLiveService.mCheckDeviceLsn.1 mZZ;
  public static final u mZl;
  private static ArrayList<String> mZm;
  private static HashMap<String, r<ArrayList<String>, Integer>> mZn;
  private static ArrayList<com.tencent.mm.live.view.a.a> mZo;
  private static byte[] mZp;
  private static dio mZq;
  private static dix mZr;
  private static String mZs;
  private static int mZt;
  private static com.tencent.mm.live.core.core.model.h mZu;
  private static long mZv;
  private static dih mZw;
  private static String mZx;
  private static String mZy;
  private static boolean mZz;
  private static View.OnClickListener naa;
  private static String thumbUrl;
  
  static
  {
    AppMethodBeat.i(247072);
    mZl = new u();
    TAG = "MicroMsg.LiveDataManager";
    com.tencent.mm.live.core.b.a locala = new com.tencent.mm.live.core.b.a();
    ((Map)locala.mUV).put(Integer.valueOf(0), Integer.valueOf(60));
    ((Map)locala.mUV).put(Integer.valueOf(1), Integer.valueOf(-1));
    ((Map)locala.mUV).put(Integer.valueOf(4), Integer.valueOf(-1));
    ((Map)locala.mUV).put(Integer.valueOf(2), Integer.valueOf(-1));
    ((Map)locala.mUV).put(Integer.valueOf(5), Integer.valueOf(-1));
    ((Map)locala.mUV).put(Integer.valueOf(3), Integer.valueOf(-1));
    mRD = locala;
    mXO = "";
    mZm = new ArrayList();
    mZn = new HashMap();
    mZo = new ArrayList();
    mZq = new dio();
    mZs = "";
    mZw = new dih();
    lastOrientation = -1;
    mZx = "";
    mZy = "";
    mZA = new u.d((byte)0);
    mZB = new u.b();
    mZC = new u.a((byte)0);
    mZD = new c();
    mZM = -1;
    mZX = new com.tencent.mm.live.model.b.a();
    mZZ = new RoomLiveService.mCheckDeviceLsn.1(com.tencent.mm.app.f.hfK);
    naa = u..ExternalSyntheticLambda0.INSTANCE;
    mZZ.alive();
    AppMethodBeat.o(247072);
  }
  
  public static void Go(String paramString)
  {
    AppMethodBeat.i(246611);
    s.u(paramString, "<set-?>");
    mXO = paramString;
    AppMethodBeat.o(246611);
  }
  
  public static void Gp(String paramString)
  {
    thumbUrl = paramString;
  }
  
  public static void Gq(String paramString)
  {
    AppMethodBeat.i(246672);
    s.u(paramString, "<set-?>");
    mZs = paramString;
    AppMethodBeat.o(246672);
  }
  
  public static void Gr(String paramString)
  {
    AppMethodBeat.i(246761);
    s.u(paramString, "<set-?>");
    mZx = paramString;
    AppMethodBeat.o(246761);
  }
  
  public static void Gs(String paramString)
  {
    AppMethodBeat.i(246777);
    s.u(paramString, "<set-?>");
    mZy = paramString;
    AppMethodBeat.o(246777);
  }
  
  public static String Gt(String paramString)
  {
    AppMethodBeat.i(247014);
    if (paramString == null)
    {
      AppMethodBeat.o(247014);
      return "";
    }
    String str = aa.IE(paramString);
    Object localObject = str;
    if (Util.isNullOrNil(str))
    {
      localObject = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(mXO);
      if (localObject != null) {
        break label81;
      }
      localObject = aa.getDisplayName(paramString);
    }
    for (;;)
    {
      s.s(localObject, "{\n            var result…         result\n        }");
      AppMethodBeat.o(247014);
      return localObject;
      label81:
      str = ((aj)localObject).getDisplayName(paramString);
      localObject = str;
      if (Util.isNullOrNil(str)) {
        localObject = aa.getDisplayName(paramString);
      }
    }
  }
  
  public static void a(dih paramdih)
  {
    AppMethodBeat.i(246733);
    s.u(paramdih, "<set-?>");
    mZw = paramdih;
    AppMethodBeat.o(246733);
  }
  
  public static void a(dio paramdio)
  {
    AppMethodBeat.i(246644);
    s.u(paramdio, "<set-?>");
    mZq = paramdio;
    AppMethodBeat.o(246644);
  }
  
  public static void a(dix paramdix)
  {
    mZr = paramdix;
  }
  
  public static void aNm()
  {
    AppMethodBeat.i(247033);
    Log.printInfoStack(TAG, "resetData", new Object[0]);
    mZv = 0L;
    mXO = "";
    mZm.clear();
    mZn.clear();
    mZp = null;
    mZq = new dio();
    mZr = null;
    thumbUrl = null;
    com.tencent.mm.live.model.b.a locala = mZX;
    locala.nbF = null;
    locala.nbG = null;
    locala.nbH = null;
    locala.nbI = null;
    locala.nbJ = null;
    locala.nbK = null;
    locala.nbL = null;
    locala.nbN = null;
    locala.nbM.clear();
    locala.nbO = "";
    locala.nbP = "";
    mZo.clear();
    mZs = "";
    mZt = 0;
    mZu = null;
    mZw = new dih();
    isManualClosed = false;
    lastOrientation = -1;
    mZx = "";
    mZy = "";
    mZC = new u.a((byte)0);
    mZD = new c();
    mZz = false;
    mZA = new u.d((byte)0);
    mZB = new u.b();
    context = null;
    hKC = false;
    AppMethodBeat.o(247033);
  }
  
  public static void am(byte[] paramArrayOfByte)
  {
    mZp = paramArrayOfByte;
  }
  
  public static void b(com.tencent.mm.live.core.core.model.h paramh)
  {
    mZu = paramh;
  }
  
  public static com.tencent.mm.live.core.b.a bhX()
  {
    return mRD;
  }
  
  public static com.tencent.mm.live.core.b.b bhY()
  {
    return mRE;
  }
  
  public static String bhZ()
  {
    return mXO;
  }
  
  public static int biA()
  {
    return mZK;
  }
  
  public static int biB()
  {
    return mZL;
  }
  
  public static int biC()
  {
    return mZM;
  }
  
  public static int biD()
  {
    return mZN;
  }
  
  public static int biE()
  {
    return mZO;
  }
  
  public static int biF()
  {
    return mZP;
  }
  
  public static int biG()
  {
    return mZQ;
  }
  
  public static boolean biH()
  {
    return mZR;
  }
  
  public static int biI()
  {
    return mZS;
  }
  
  public static int biJ()
  {
    return mZT;
  }
  
  public static int biK()
  {
    return mZU;
  }
  
  public static long biL()
  {
    return mZV;
  }
  
  public static boolean biM()
  {
    return mZW;
  }
  
  public static com.tencent.mm.live.model.b.a biN()
  {
    return mZX;
  }
  
  public static long biO()
  {
    return mZY;
  }
  
  public static View.OnClickListener biP()
  {
    return naa;
  }
  
  public static String biQ()
  {
    AppMethodBeat.i(247006);
    if (mZq.aaun <= 0)
    {
      localObject = MMApplicationContext.getContext().getResources().getString(b.h.live_like_count_zero);
      s.s(localObject, "{\n            MMApplicat…ike_count_zero)\n        }");
      AppMethodBeat.o(247006);
      return localObject;
    }
    if (mZq.aaun < 10000)
    {
      int i = mZq.aaun;
      AppMethodBeat.o(247006);
      return String.valueOf(i);
    }
    if (mZq.aaun % 10000 >= 1000)
    {
      localObject = am.aixg;
      localObject = MMApplicationContext.getContext().getResources().getString(b.h.live_like_count_format);
      s.s(localObject, "getContext().resources.g…g.live_like_count_format)");
      localObject = String.format((String)localObject, Arrays.copyOf(new Object[] { Float.valueOf(mZq.aaun / 10000.0F) }, 1));
      s.s(localObject, "java.lang.String.format(format, *args)");
      AppMethodBeat.o(247006);
      return localObject;
    }
    Object localObject = am.aixg;
    localObject = MMApplicationContext.getContext().getResources().getString(b.h.live_like_count_int_format);
    s.s(localObject, "getContext().resources.g…ve_like_count_int_format)");
    localObject = String.format((String)localObject, Arrays.copyOf(new Object[] { Integer.valueOf(mZq.aaun / 10000) }, 1));
    s.s(localObject, "java.lang.String.format(format, *args)");
    AppMethodBeat.o(247006);
    return localObject;
  }
  
  public static String biR()
  {
    AppMethodBeat.i(247011);
    if (Util.isNullOrNil(mZq.Zqd))
    {
      str = mZq.aaNq;
      if (str == null)
      {
        AppMethodBeat.o(247011);
        return "";
      }
      AppMethodBeat.o(247011);
      return str;
    }
    String str = mZq.Zqd;
    if (str == null)
    {
      AppMethodBeat.o(247011);
      return "";
    }
    AppMethodBeat.o(247011);
    return str;
  }
  
  public static void biS()
  {
    mZA.naj = true;
    mZA.nai = false;
  }
  
  public static void biT()
  {
    mZA.nak = true;
  }
  
  public static void biU()
  {
    mZA.nai = true;
    mZA.naj = false;
  }
  
  public static void biV()
  {
    AppMethodBeat.i(247049);
    Context localContext = context;
    Object localObject;
    if ((localContext != null) && ((localContext instanceof Activity)))
    {
      if (!hKC) {
        break label51;
      }
      localObject = com.tencent.mm.live.core.core.a.b.mMo;
      b.a.bej().bcg();
    }
    for (;;)
    {
      ((Activity)localContext).finishAndRemoveTask();
      AppMethodBeat.o(247049);
      return;
      label51:
      localObject = com.tencent.mm.live.core.core.f.d.mUj;
      d.a.bfM().bcg();
    }
  }
  
  public static ArrayList<String> bia()
  {
    return mZm;
  }
  
  public static HashMap<String, r<ArrayList<String>, Integer>> bib()
  {
    return mZn;
  }
  
  public static ArrayList<com.tencent.mm.live.view.a.a> bic()
  {
    return mZo;
  }
  
  public static byte[] bid()
  {
    return mZp;
  }
  
  public static dio bie()
  {
    return mZq;
  }
  
  public static dix bif()
  {
    return mZr;
  }
  
  public static String big()
  {
    return mZs;
  }
  
  public static int bih()
  {
    return mZt;
  }
  
  public static com.tencent.mm.live.core.core.model.h bii()
  {
    return mZu;
  }
  
  public static long bij()
  {
    return mZv;
  }
  
  public static dih bik()
  {
    return mZw;
  }
  
  public static void bil()
  {
    isManualClosed = true;
  }
  
  public static String bim()
  {
    return mZx;
  }
  
  public static String bin()
  {
    return mZy;
  }
  
  public static boolean bio()
  {
    return mZz;
  }
  
  public static void bip()
  {
    mZz = true;
  }
  
  public static u.d biq()
  {
    return mZA;
  }
  
  public static u.b bir()
  {
    return mZB;
  }
  
  public static u.a bis()
  {
    return mZC;
  }
  
  public static c bit()
  {
    return mZD;
  }
  
  public static boolean biu()
  {
    return mZE;
  }
  
  public static boolean biv()
  {
    return mZF;
  }
  
  public static boolean biw()
  {
    return mZG;
  }
  
  public static boolean bix()
  {
    return mZH;
  }
  
  public static boolean biy()
  {
    return mZI;
  }
  
  public static int biz()
  {
    return mZJ;
  }
  
  private static final void dd(View paramView)
  {
    AppMethodBeat.i(247060);
    Object localObject = new Intent(MMApplicationContext.getContext(), LiveUIA.class);
    ((Intent)localObject).putExtra("route_to_maximize", true);
    ((Intent)localObject).addFlags(268435456);
    paramView = MMApplicationContext.getContext();
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/live/model/RoomLiveService", "miniWindowClickListener$lambda-1", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/live/model/RoomLiveService", "miniWindowClickListener$lambda-1", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(247060);
  }
  
  public static void fU(boolean paramBoolean)
  {
    mZE = paramBoolean;
  }
  
  public static void fV(boolean paramBoolean)
  {
    mZF = paramBoolean;
  }
  
  public static void fW(boolean paramBoolean)
  {
    mZG = paramBoolean;
  }
  
  public static void fX(boolean paramBoolean)
  {
    mZH = paramBoolean;
  }
  
  public static void fY(boolean paramBoolean)
  {
    mZI = paramBoolean;
  }
  
  public static void fZ(boolean paramBoolean)
  {
    mZR = paramBoolean;
  }
  
  public static void ga(boolean paramBoolean)
  {
    mZW = paramBoolean;
  }
  
  public static int getLastOrientation()
  {
    return lastOrientation;
  }
  
  public static void hO(long paramLong)
  {
    mZv = paramLong;
  }
  
  public static void hP(long paramLong)
  {
    mZV = paramLong;
  }
  
  public static void hQ(long paramLong)
  {
    mZY = paramLong;
  }
  
  public static boolean isManualClosed()
  {
    return isManualClosed;
  }
  
  public static void setLastOrientation(int paramInt)
  {
    lastOrientation = paramInt;
  }
  
  public static void tC(int paramInt)
  {
    mZt = paramInt;
  }
  
  public static void tD(int paramInt)
  {
    if (mZJ < paramInt) {
      mZJ = paramInt;
    }
    while (paramInt != -1) {
      return;
    }
    mZJ = 0;
  }
  
  public static void tE(int paramInt)
  {
    mZK = paramInt;
  }
  
  public static void tF(int paramInt)
  {
    mZL = paramInt;
  }
  
  public static void tG(int paramInt)
  {
    mZM = paramInt;
  }
  
  public static void tH(int paramInt)
  {
    mZN = paramInt;
  }
  
  public static void tI(int paramInt)
  {
    mZO = paramInt;
  }
  
  public static void tJ(int paramInt)
  {
    mZP = paramInt;
  }
  
  public static void tK(int paramInt)
  {
    mZQ = paramInt;
  }
  
  public static void tL(int paramInt)
  {
    mZS = paramInt;
  }
  
  public static void tM(int paramInt)
  {
    mZT = paramInt;
  }
  
  public static void tN(int paramInt)
  {
    mZU = paramInt;
  }
  
  public static void y(Context paramContext, boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(247042);
    s.u(paramContext, "context");
    hKC = paramBoolean;
    context = paramContext;
    int i = Util.getInt(i.aRC().getValue("MMLiveConfigBitSet"), 0);
    paramContext = mZC;
    if (!com.tencent.mm.ae.d.ee(i, 1))
    {
      paramBoolean = true;
      paramContext.nab = paramBoolean;
      paramContext = mZC;
      if (com.tencent.mm.ae.d.ee(i, 2)) {
        break label126;
      }
      paramBoolean = true;
      label70:
      paramContext.nac = paramBoolean;
      paramContext = mZC;
      if (com.tencent.mm.ae.d.ee(i, 4)) {
        break label131;
      }
      paramBoolean = true;
      label89:
      paramContext.nad = paramBoolean;
      paramContext = mZC;
      if (com.tencent.mm.ae.d.ee(i, 8)) {
        break label136;
      }
    }
    label131:
    label136:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      paramContext.nae = paramBoolean;
      AppMethodBeat.o(247042);
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
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/live/model/RoomLiveService$LiveSmallWindowInfo;", "", "userId", "", "streamType", "", "width", "height", "(Ljava/lang/String;III)V", "getHeight", "()I", "setHeight", "(I)V", "getStreamType", "setStreamType", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "getWidth", "setWidth", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "isLandscape", "toString", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
  {
    public int height;
    public int streamType;
    public String userId;
    public int width;
    
    private c(String paramString)
    {
      AppMethodBeat.i(246674);
      this.userId = paramString;
      this.streamType = 0;
      this.width = 0;
      this.height = 0;
      AppMethodBeat.o(246674);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(246719);
      if (this == paramObject)
      {
        AppMethodBeat.o(246719);
        return true;
      }
      if (!(paramObject instanceof c))
      {
        AppMethodBeat.o(246719);
        return false;
      }
      paramObject = (c)paramObject;
      if (!s.p(this.userId, paramObject.userId))
      {
        AppMethodBeat.o(246719);
        return false;
      }
      if (this.streamType != paramObject.streamType)
      {
        AppMethodBeat.o(246719);
        return false;
      }
      if (this.width != paramObject.width)
      {
        AppMethodBeat.o(246719);
        return false;
      }
      if (this.height != paramObject.height)
      {
        AppMethodBeat.o(246719);
        return false;
      }
      AppMethodBeat.o(246719);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(246712);
      int i = this.userId.hashCode();
      int j = this.streamType;
      int k = this.width;
      int m = this.height;
      AppMethodBeat.o(246712);
      return ((i * 31 + j) * 31 + k) * 31 + m;
    }
    
    public final boolean isLandscape()
    {
      return this.width > this.height;
    }
    
    public final void setUserId(String paramString)
    {
      AppMethodBeat.i(246691);
      s.u(paramString, "<set-?>");
      this.userId = paramString;
      AppMethodBeat.o(246691);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(246706);
      String str = "LiveSmallWindowInfo(userId=" + this.userId + ", streamType=" + this.streamType + ", width=" + this.width + ", height=" + this.height + ')';
      AppMethodBeat.o(246706);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.live.model.u
 * JD-Core Version:    0.7.0.1
 */