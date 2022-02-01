package com.tencent.mm.live.b;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.kv;
import com.tencent.mm.live.core.core.b.d;
import com.tencent.mm.m.e;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.v;
import com.tencent.mm.protocal.protobuf.bqb;
import com.tencent.mm.protocal.protobuf.bqd;
import com.tencent.mm.protocal.protobuf.bqj;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.x;
import d.g.b.k;
import d.g.b.z;
import d.l;
import d.o;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/model/LiveDataManager;", "", "()V", "TAG", "", "anchorLinkSuccessCountPerShow", "", "getAnchorLinkSuccessCountPerShow", "()I", "setAnchorLinkSuccessCountPerShow", "(I)V", "anchorStatus", "Lcom/tencent/mm/protocal/protobuf/LiveAnchorStatus;", "getAnchorStatus", "()Lcom/tencent/mm/protocal/protobuf/LiveAnchorStatus;", "setAnchorStatus", "(Lcom/tencent/mm/protocal/protobuf/LiveAnchorStatus;)V", "anchorUserName", "getAnchorUserName", "()Ljava/lang/String;", "setAnchorUserName", "(Ljava/lang/String;)V", "value", "audienceCountMax", "getAudienceCountMax", "setAudienceCountMax", "callingMicNickname", "getCallingMicNickname", "setCallingMicNickname", "callingMicUsername", "getCallingMicUsername", "setCallingMicUsername", "enterFromScene", "getEnterFromScene", "setEnterFromScene", "hasChangeVideoModePerLinkMic", "", "getHasChangeVideoModePerLinkMic", "()Z", "setHasChangeVideoModePerLinkMic", "(Z)V", "isClickStartLive", "setClickStartLive", "isForeigner", "setForeigner", "isLiveNameChanged", "setLiveNameChanged", "isManualClosed", "setManualClosed", "isStartLiveReport", "setStartLiveReport", "isVerifyChecked", "setVerifyChecked", "isVerifyUiShow", "setVerifyUiShow", "isVisitorReport", "setVisitorReport", "lastOrientation", "getLastOrientation", "setLastOrientation", "linkMicRequestCount", "getLinkMicRequestCount", "setLinkMicRequestCount", "liveCookies", "", "getLiveCookies", "()[B", "setLiveCookies", "([B)V", "liveDynamicConfig", "Lcom/tencent/mm/live/model/LiveDataManager$LiveDynamicConfig;", "getLiveDynamicConfig", "()Lcom/tencent/mm/live/model/LiveDataManager$LiveDynamicConfig;", "setLiveDynamicConfig", "(Lcom/tencent/mm/live/model/LiveDataManager$LiveDynamicConfig;)V", "liveFaceVerifyInfo", "Lcom/tencent/mm/live/model/LiveDataManager$LiveFaceVerifyInfo;", "getLiveFaceVerifyInfo", "()Lcom/tencent/mm/live/model/LiveDataManager$LiveFaceVerifyInfo;", "setLiveFaceVerifyInfo", "(Lcom/tencent/mm/live/model/LiveDataManager$LiveFaceVerifyInfo;)V", "liveInfo", "Lcom/tencent/mm/protocal/protobuf/LiveInfo;", "getLiveInfo", "()Lcom/tencent/mm/protocal/protobuf/LiveInfo;", "setLiveInfo", "(Lcom/tencent/mm/protocal/protobuf/LiveInfo;)V", "liveRoomModel", "Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "getLiveRoomModel", "()Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "setLiveRoomModel", "(Lcom/tencent/mm/live/core/core/model/LiveRoomModel;)V", "liveSdkInfo", "Lcom/tencent/mm/protocal/protobuf/LiveSdkInfo;", "getLiveSdkInfo", "()Lcom/tencent/mm/protocal/protobuf/LiveSdkInfo;", "setLiveSdkInfo", "(Lcom/tencent/mm/protocal/protobuf/LiveSdkInfo;)V", "liveSmallWindowInfo", "Lcom/tencent/mm/live/model/LiveDataManager$LiveSmallWindowInfo;", "getLiveSmallWindowInfo", "()Lcom/tencent/mm/live/model/LiveDataManager$LiveSmallWindowInfo;", "setLiveSmallWindowInfo", "(Lcom/tencent/mm/live/model/LiveDataManager$LiveSmallWindowInfo;)V", "liveStatus", "Lcom/tencent/mm/live/model/LiveDataManager$LiveStatus;", "getLiveStatus", "()Lcom/tencent/mm/live/model/LiveDataManager$LiveStatus;", "setLiveStatus", "(Lcom/tencent/mm/live/model/LiveDataManager$LiveStatus;)V", "mCheckDeviceLsn", "com/tencent/mm/live/model/LiveDataManager$mCheckDeviceLsn$1", "Lcom/tencent/mm/live/model/LiveDataManager$mCheckDeviceLsn$1;", "mLastOrientation", "getMLastOrientation", "setMLastOrientation", "mStartLinkTimes", "", "getMStartLinkTimes", "()J", "setMStartLinkTimes", "(J)V", "micPmkExpire", "getMicPmkExpire", "setMicPmkExpire", "msgFilterTime", "getMsgFilterTime", "setMsgFilterTime", "msgList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/view/adapter/CommentData;", "Lkotlin/collections/ArrayList;", "getMsgList", "()Ljava/util/ArrayList;", "setMsgList", "(Ljava/util/ArrayList;)V", "onlineHeadImgList", "getOnlineHeadImgList", "setOnlineHeadImgList", "shareRoomList", "Ljava/util/HashMap;", "Lkotlin/Pair;", "Lkotlin/collections/HashMap;", "getShareRoomList", "()Ljava/util/HashMap;", "setShareRoomList", "(Ljava/util/HashMap;)V", "sysMsgManager", "Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager;", "getSysMsgManager", "()Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager;", "setSysMsgManager", "(Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager;)V", "thumbUrl", "getThumbUrl", "setThumbUrl", "visitorCommentCount", "getVisitorCommentCount", "setVisitorCommentCount", "visitorConnectCount", "getVisitorConnectCount", "setVisitorConnectCount", "visitorConnectReqCount", "getVisitorConnectReqCount", "setVisitorConnectReqCount", "visitorEnterErrorCode", "getVisitorEnterErrorCode", "setVisitorEnterErrorCode", "visitorEnterMemberCount", "getVisitorEnterMemberCount", "setVisitorEnterMemberCount", "visitorLikeCount", "getVisitorLikeCount", "setVisitorLikeCount", "wechatRoomId", "getWechatRoomId", "setWechatRoomId", "displayLiveName", "displayUsername", "username", "formatAnchorLikeCount", "formatLikeCount", "liveError", "", "liveFinish", "liveStart", "preOnCreate", "release", "resetData", "resetLiveFaceVerifyInfo", "LiveDynamicConfig", "LiveFaceVerifyInfo", "LiveSmallWindowInfo", "LiveStatus", "plugin-logic_release"})
public final class g
{
  private static final String TAG = "MicroMsg.LiveDataManager";
  private static String gsT;
  private static ArrayList<String> gtR;
  private static HashMap<String, o<ArrayList<String>, Integer>> gtS;
  private static ArrayList<com.tencent.mm.live.view.a.a> gtT;
  private static byte[] gtU;
  private static bqd gtV;
  private static bqj gtW;
  private static String gtX;
  private static int gtY;
  private static d gtZ;
  private static int guA;
  private static int guB;
  private static long guC;
  private static boolean guD;
  private static com.tencent.mm.live.b.b.a guE;
  private static final e guF;
  public static final g guG;
  private static long gua;
  private static bqb gub;
  private static boolean guc;
  private static int gud;
  private static String gue;
  private static String guf;
  private static boolean gug;
  private static d guh;
  private static b gui;
  private static a guj;
  private static c guk;
  private static boolean gul;
  private static boolean gum;
  private static boolean gun;
  private static boolean guo;
  private static boolean gup;
  private static int guq;
  private static int gur;
  private static int gus;
  private static int gut;
  private static int guu;
  private static int guv;
  private static int guw;
  private static int gux;
  private static boolean guy;
  private static int guz;
  private static String thumbUrl;
  
  static
  {
    AppMethodBeat.i(189792);
    guG = new g();
    TAG = "MicroMsg.LiveDataManager";
    gsT = "";
    gtR = new ArrayList();
    gtS = new HashMap();
    gtT = new ArrayList();
    gtV = new bqd();
    gtX = "";
    gub = new bqb();
    gud = -1;
    gue = "";
    guf = "";
    guh = new d((byte)0);
    gui = new b();
    guj = new a((byte)0);
    guk = new c();
    gut = -1;
    guE = new com.tencent.mm.live.b.b.a();
    e locale = new e();
    guF = locale;
    locale.alive();
    AppMethodBeat.o(189792);
  }
  
  public static void Q(byte[] paramArrayOfByte)
  {
    gtU = paramArrayOfByte;
  }
  
  public static void WN()
  {
    AppMethodBeat.i(189790);
    ac.m(TAG, "resetData", new Object[0]);
    gua = 0L;
    gsT = "";
    gtR.clear();
    gtS.clear();
    gtU = null;
    gtV = new bqd();
    gtW = null;
    thumbUrl = null;
    com.tencent.mm.live.b.b.a locala = guE;
    locala.gwW = null;
    locala.gwX = null;
    locala.gwY = null;
    locala.gwZ = null;
    locala.gxa = null;
    locala.gxb = null;
    locala.gxc = null;
    locala.gxe = null;
    locala.gxd.clear();
    locala.gxf = "";
    locala.gxg = "";
    gtT.clear();
    gtX = "";
    gtY = 0;
    gtZ = null;
    gub = new bqb();
    guc = false;
    gud = -1;
    gue = "";
    guf = "";
    guj = new a((byte)0);
    guk = new c();
    gug = false;
    guh = new d((byte)0);
    gui = new b();
    AppMethodBeat.o(189790);
  }
  
  public static void a(bqb parambqb)
  {
    AppMethodBeat.i(189782);
    k.h(parambqb, "<set-?>");
    gub = parambqb;
    AppMethodBeat.o(189782);
  }
  
  public static void a(bqd parambqd)
  {
    AppMethodBeat.i(189780);
    k.h(parambqd, "<set-?>");
    gtV = parambqd;
    AppMethodBeat.o(189780);
  }
  
  public static void a(bqj parambqj)
  {
    gtW = parambqj;
  }
  
  public static String akA()
  {
    return gsT;
  }
  
  public static ArrayList<String> akB()
  {
    return gtR;
  }
  
  public static HashMap<String, o<ArrayList<String>, Integer>> akC()
  {
    return gtS;
  }
  
  public static ArrayList<com.tencent.mm.live.view.a.a> akD()
  {
    return gtT;
  }
  
  public static byte[] akE()
  {
    return gtU;
  }
  
  public static bqd akF()
  {
    return gtV;
  }
  
  public static bqj akG()
  {
    return gtW;
  }
  
  public static String akH()
  {
    return gtX;
  }
  
  public static int akI()
  {
    return gtY;
  }
  
  public static d akJ()
  {
    return gtZ;
  }
  
  public static long akK()
  {
    return gua;
  }
  
  public static bqb akL()
  {
    return gub;
  }
  
  public static boolean akM()
  {
    return guc;
  }
  
  public static void akN()
  {
    guc = true;
  }
  
  public static int akO()
  {
    return gud;
  }
  
  public static String akP()
  {
    return gue;
  }
  
  public static String akQ()
  {
    return guf;
  }
  
  public static boolean akR()
  {
    return gug;
  }
  
  public static void akS()
  {
    gug = true;
  }
  
  public static d akT()
  {
    return guh;
  }
  
  public static b akU()
  {
    return gui;
  }
  
  public static a akV()
  {
    return guj;
  }
  
  public static c akW()
  {
    return guk;
  }
  
  public static boolean akX()
  {
    return gul;
  }
  
  public static boolean akY()
  {
    return gum;
  }
  
  public static boolean akZ()
  {
    return gun;
  }
  
  public static boolean ala()
  {
    return guo;
  }
  
  public static boolean alb()
  {
    return gup;
  }
  
  public static int alc()
  {
    return guq;
  }
  
  public static int ald()
  {
    return gur;
  }
  
  public static int ale()
  {
    return gus;
  }
  
  public static int alf()
  {
    return gut;
  }
  
  public static int alg()
  {
    return guu;
  }
  
  public static int alh()
  {
    return guv;
  }
  
  public static int ali()
  {
    return guw;
  }
  
  public static int alj()
  {
    return gux;
  }
  
  public static boolean alk()
  {
    return guy;
  }
  
  public static int all()
  {
    return guz;
  }
  
  public static int alm()
  {
    return guA;
  }
  
  public static int aln()
  {
    return guB;
  }
  
  public static long alo()
  {
    AppMethodBeat.i(189785);
    long l = (System.currentTimeMillis() - guC) / 1000L;
    AppMethodBeat.o(189785);
    return l;
  }
  
  public static boolean alp()
  {
    return guD;
  }
  
  public static com.tencent.mm.live.b.b.a alq()
  {
    return guE;
  }
  
  public static String alr()
  {
    AppMethodBeat.i(189786);
    if (gtV.EQG <= 0)
    {
      localObject = ai.getContext();
      k.g(localObject, "MMApplicationContext.getContext()");
      localObject = ((Context)localObject).getResources().getString(2131766618);
      k.g(localObject, "MMApplicationContext.get…ing.live_like_count_zero)");
      AppMethodBeat.o(189786);
      return localObject;
    }
    if (gtV.EQG < 10000)
    {
      int i = gtV.EQG;
      AppMethodBeat.o(189786);
      return String.valueOf(i);
    }
    if (gtV.EQG % 10000 >= 1000)
    {
      localObject = z.KUT;
      localObject = ai.getContext();
      k.g(localObject, "MMApplicationContext.getContext()");
      localObject = ((Context)localObject).getResources().getString(2131766616);
      k.g(localObject, "MMApplicationContext.get…g.live_like_count_format)");
      localObject = String.format((String)localObject, Arrays.copyOf(new Object[] { Float.valueOf(gtV.EQG / 10000.0F) }, 1));
      k.g(localObject, "java.lang.String.format(format, *args)");
      AppMethodBeat.o(189786);
      return localObject;
    }
    Object localObject = z.KUT;
    localObject = ai.getContext();
    k.g(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getResources().getString(2131766617);
    k.g(localObject, "MMApplicationContext.get…ve_like_count_int_format)");
    localObject = String.format((String)localObject, Arrays.copyOf(new Object[] { Integer.valueOf(gtV.EQG / 10000) }, 1));
    k.g(localObject, "java.lang.String.format(format, *args)");
    AppMethodBeat.o(189786);
    return localObject;
  }
  
  public static String als()
  {
    AppMethodBeat.i(189787);
    if (gtV.EQG <= 0)
    {
      AppMethodBeat.o(189787);
      return "0";
    }
    if (gtV.EQG < 10000)
    {
      int i = gtV.EQG;
      AppMethodBeat.o(189787);
      return String.valueOf(i);
    }
    if (gtV.EQG % 10000 >= 1000)
    {
      localObject = z.KUT;
      localObject = ai.getContext();
      k.g(localObject, "MMApplicationContext.getContext()");
      localObject = ((Context)localObject).getResources().getString(2131766616);
      k.g(localObject, "MMApplicationContext.get…g.live_like_count_format)");
      localObject = String.format((String)localObject, Arrays.copyOf(new Object[] { Float.valueOf(gtV.EQG / 10000.0F) }, 1));
      k.g(localObject, "java.lang.String.format(format, *args)");
      AppMethodBeat.o(189787);
      return localObject;
    }
    Object localObject = z.KUT;
    localObject = ai.getContext();
    k.g(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getResources().getString(2131766617);
    k.g(localObject, "MMApplicationContext.get…ve_like_count_int_format)");
    localObject = String.format((String)localObject, Arrays.copyOf(new Object[] { Integer.valueOf(gtV.EQG / 10000) }, 1));
    k.g(localObject, "java.lang.String.format(format, *args)");
    AppMethodBeat.o(189787);
    return localObject;
  }
  
  public static String alt()
  {
    AppMethodBeat.i(189788);
    String str2;
    String str1;
    if (bs.isNullOrNil(gtV.Eud))
    {
      str2 = gtV.Ffh;
      str1 = str2;
      if (str2 == null)
      {
        AppMethodBeat.o(189788);
        return "";
      }
    }
    else
    {
      str2 = gtV.Eud;
      str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
    }
    AppMethodBeat.o(189788);
    return str1;
  }
  
  public static void alu()
  {
    guh.guP = true;
    guh.guO = false;
  }
  
  public static void alv()
  {
    guh.guQ = true;
  }
  
  public static void alw()
  {
    guh.guO = true;
    guh.guP = false;
  }
  
  public static void alx()
  {
    boolean bool2 = true;
    AppMethodBeat.i(189791);
    int i = bs.getInt(com.tencent.mm.m.g.ZY().getValue("MMLiveConfigBitSet"), 0);
    a locala = guj;
    if (!com.tencent.mm.ac.c.cO(i, 1))
    {
      bool1 = true;
      locala.guH = bool1;
      locala = guj;
      if (com.tencent.mm.ac.c.cO(i, 2)) {
        break label111;
      }
      bool1 = true;
      label55:
      locala.guI = bool1;
      locala = guj;
      if (com.tencent.mm.ac.c.cO(i, 4)) {
        break label116;
      }
      bool1 = true;
      label74:
      locala.guJ = bool1;
      locala = guj;
      if (com.tencent.mm.ac.c.cO(i, 8)) {
        break label121;
      }
    }
    label111:
    label116:
    label121:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      locala.guK = bool1;
      AppMethodBeat.o(189791);
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
    gtZ = paramd;
  }
  
  public static void dI(boolean paramBoolean)
  {
    gul = paramBoolean;
  }
  
  public static void dJ(boolean paramBoolean)
  {
    gum = paramBoolean;
  }
  
  public static void dK(boolean paramBoolean)
  {
    gun = paramBoolean;
  }
  
  public static void dL(boolean paramBoolean)
  {
    guo = paramBoolean;
  }
  
  public static void dM(boolean paramBoolean)
  {
    gup = paramBoolean;
  }
  
  public static void dN(boolean paramBoolean)
  {
    guy = paramBoolean;
  }
  
  public static void dO(boolean paramBoolean)
  {
    guD = paramBoolean;
  }
  
  public static void mU(int paramInt)
  {
    gtY = paramInt;
  }
  
  public static void mV(int paramInt)
  {
    gud = paramInt;
  }
  
  public static void mW(int paramInt)
  {
    if (guq < paramInt) {
      guq = paramInt;
    }
    while (paramInt != -1) {
      return;
    }
    guq = 0;
  }
  
  public static void mX(int paramInt)
  {
    gur = paramInt;
  }
  
  public static void mY(int paramInt)
  {
    gus = paramInt;
  }
  
  public static void mZ(int paramInt)
  {
    gut = paramInt;
  }
  
  public static void na(int paramInt)
  {
    guu = paramInt;
  }
  
  public static void nb(int paramInt)
  {
    guv = paramInt;
  }
  
  public static void nc(int paramInt)
  {
    guw = paramInt;
  }
  
  public static void nd(int paramInt)
  {
    gux = paramInt;
  }
  
  public static void ne(int paramInt)
  {
    guz = paramInt;
  }
  
  public static void nf(int paramInt)
  {
    guA = paramInt;
  }
  
  public static void ng(int paramInt)
  {
    guB = paramInt;
  }
  
  public static void pg(long paramLong)
  {
    gua = paramLong;
  }
  
  public static void ph(long paramLong)
  {
    guC = paramLong;
  }
  
  public static void uO(String paramString)
  {
    AppMethodBeat.i(189779);
    k.h(paramString, "<set-?>");
    gsT = paramString;
    AppMethodBeat.o(189779);
  }
  
  public static void uP(String paramString)
  {
    thumbUrl = paramString;
  }
  
  public static void uQ(String paramString)
  {
    AppMethodBeat.i(189781);
    k.h(paramString, "<set-?>");
    gtX = paramString;
    AppMethodBeat.o(189781);
  }
  
  public static void uR(String paramString)
  {
    AppMethodBeat.i(189783);
    k.h(paramString, "<set-?>");
    gue = paramString;
    AppMethodBeat.o(189783);
  }
  
  public static void uS(String paramString)
  {
    AppMethodBeat.i(189784);
    k.h(paramString, "<set-?>");
    guf = paramString;
    AppMethodBeat.o(189784);
  }
  
  public static String uT(String paramString)
  {
    AppMethodBeat.i(189789);
    if (paramString == null)
    {
      AppMethodBeat.o(189789);
      return "";
    }
    String str = v.wl(paramString);
    Object localObject = str;
    if (bs.isNullOrNil(str))
    {
      localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class);
      k.g(localObject, "MMKernel.service(IChatroomService::class.java)");
      localObject = ((com.tencent.mm.plugin.chatroom.a.c)localObject).awK().xN(gsT);
      if (localObject != null) {
        break label90;
      }
      localObject = v.wk(paramString);
    }
    for (;;)
    {
      k.g(localObject, "result");
      AppMethodBeat.o(189789);
      return localObject;
      label90:
      str = ((x)localObject).wk(paramString);
      localObject = str;
      if (bs.isNullOrNil(str)) {
        localObject = v.wk(paramString);
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/model/LiveDataManager$LiveDynamicConfig;", "", "enableLandscape", "", "enableCheckPhoneNum", "enableVisitorPolicyPage", "enableVerifyPage", "(ZZZZ)V", "getEnableCheckPhoneNum", "()Z", "setEnableCheckPhoneNum", "(Z)V", "getEnableLandscape", "setEnableLandscape", "getEnableVerifyPage", "setEnableVerifyPage", "getEnableVisitorPolicyPage", "setEnableVisitorPolicyPage", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "plugin-logic_release"})
  public static final class a
  {
    public boolean guH = true;
    boolean guI = true;
    boolean guJ = true;
    boolean guK = true;
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.guH != paramObject.guH) || (this.guI != paramObject.guI) || (this.guJ != paramObject.guJ) || (this.guK != paramObject.guK)) {}
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
      AppMethodBeat.i(189764);
      String str = "LiveDynamicConfig(enableLandscape=" + this.guH + ", enableCheckPhoneNum=" + this.guI + ", enableVisitorPolicyPage=" + this.guJ + ", enableVerifyPage=" + this.guK + ")";
      AppMethodBeat.o(189764);
      return str;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/model/LiveDataManager$LiveFaceVerifyInfo;", "", "needFaceVerify", "", "verifyUrl", "", "isFromAnchor", "(ZLjava/lang/String;Z)V", "()Z", "setFromAnchor", "(Z)V", "getNeedFaceVerify", "setNeedFaceVerify", "getVerifyUrl", "()Ljava/lang/String;", "setVerifyUrl", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "plugin-logic_release"})
  public static final class b
  {
    public boolean guL;
    public String guM;
    public boolean guN;
    
    private b(String paramString)
    {
      AppMethodBeat.i(189766);
      this.guL = false;
      this.guM = paramString;
      this.guN = true;
      AppMethodBeat.o(189766);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(189770);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((this.guL != paramObject.guL) || (!k.g(this.guM, paramObject.guM)) || (this.guN != paramObject.guN)) {}
        }
      }
      else
      {
        AppMethodBeat.o(189770);
        return true;
      }
      AppMethodBeat.o(189770);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(189768);
      String str = "LiveFaceVerifyInfo(needFaceVerify=" + this.guL + ", verifyUrl=" + this.guM + ", isFromAnchor=" + this.guN + ")";
      AppMethodBeat.o(189768);
      return str;
    }
    
    public final void uU(String paramString)
    {
      AppMethodBeat.i(189765);
      k.h(paramString, "<set-?>");
      this.guM = paramString;
      AppMethodBeat.o(189765);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/model/LiveDataManager$LiveSmallWindowInfo;", "", "userId", "", "streamType", "", "width", "height", "(Ljava/lang/String;III)V", "getHeight", "()I", "setHeight", "(I)V", "getStreamType", "setStreamType", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "getWidth", "setWidth", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "isLandscape", "toString", "plugin-logic_release"})
  public static final class c
  {
    public int height;
    public int streamType;
    public String userId;
    public int width;
    
    private c(String paramString)
    {
      AppMethodBeat.i(189772);
      this.userId = paramString;
      this.streamType = 0;
      this.width = 0;
      this.height = 0;
      AppMethodBeat.o(189772);
    }
    
    public final boolean aly()
    {
      return this.width > this.height;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(189776);
      if (this != paramObject)
      {
        if ((paramObject instanceof c))
        {
          paramObject = (c)paramObject;
          if ((!k.g(this.userId, paramObject.userId)) || (this.streamType != paramObject.streamType) || (this.width != paramObject.width) || (this.height != paramObject.height)) {}
        }
      }
      else
      {
        AppMethodBeat.o(189776);
        return true;
      }
      AppMethodBeat.o(189776);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(189775);
      String str = this.userId;
      if (str != null) {}
      for (int i = str.hashCode();; i = 0)
      {
        int j = this.streamType;
        int k = this.width;
        int m = this.height;
        AppMethodBeat.o(189775);
        return ((i * 31 + j) * 31 + k) * 31 + m;
      }
    }
    
    public final void setUserId(String paramString)
    {
      AppMethodBeat.i(189771);
      k.h(paramString, "<set-?>");
      this.userId = paramString;
      AppMethodBeat.o(189771);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(189774);
      String str = "LiveSmallWindowInfo(userId=" + this.userId + ", streamType=" + this.streamType + ", width=" + this.width + ", height=" + this.height + ")";
      AppMethodBeat.o(189774);
      return str;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/model/LiveDataManager$LiveStatus;", "", "liveFinished", "", "liveStarted", "liveHasError", "liveJumpToOtherUI", "(ZZZZ)V", "getLiveFinished", "()Z", "setLiveFinished", "(Z)V", "getLiveHasError", "setLiveHasError", "getLiveJumpToOtherUI", "setLiveJumpToOtherUI", "getLiveStarted", "setLiveStarted", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "plugin-logic_release"})
  public static final class d
  {
    public boolean guO = false;
    public boolean guP = false;
    public boolean guQ = false;
    public boolean guR = false;
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof d))
        {
          paramObject = (d)paramObject;
          if ((this.guO != paramObject.guO) || (this.guP != paramObject.guP) || (this.guQ != paramObject.guQ) || (this.guR != paramObject.guR)) {}
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
      AppMethodBeat.i(189777);
      String str = "LiveStatus(liveFinished=" + this.guO + ", liveStarted=" + this.guP + ", liveHasError=" + this.guQ + ", liveJumpToOtherUI=" + this.guR + ")";
      AppMethodBeat.o(189777);
      return str;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/live/model/LiveDataManager$mCheckDeviceLsn$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/LiveStateActionEvent;", "callback", "", "event", "plugin-logic_release"})
  public static final class e
    extends com.tencent.mm.sdk.b.c<kv>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.b.g
 * JD-Core Version:    0.7.0.1
 */