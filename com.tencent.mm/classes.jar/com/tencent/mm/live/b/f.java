package com.tencent.mm.live.b;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.yr;
import com.tencent.mm.live.core.core.b.d;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.protocal.protobuf.eaq;
import com.tencent.mm.protocal.protobuf.eas;
import com.tencent.mm.protocal.protobuf.eaw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.k;
import d.g.b.z;
import d.l;
import d.o;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/LiveDataManager;", "", "()V", "TAG", "", "anchorLinkSuccessCountPerShow", "", "getAnchorLinkSuccessCountPerShow", "()I", "setAnchorLinkSuccessCountPerShow", "(I)V", "anchorStatus", "Lcom/tencent/mm/protocal/protobuf/LiveAnchorStatus;", "getAnchorStatus", "()Lcom/tencent/mm/protocal/protobuf/LiveAnchorStatus;", "setAnchorStatus", "(Lcom/tencent/mm/protocal/protobuf/LiveAnchorStatus;)V", "anchorUserName", "getAnchorUserName", "()Ljava/lang/String;", "setAnchorUserName", "(Ljava/lang/String;)V", "value", "audienceCountMax", "getAudienceCountMax", "setAudienceCountMax", "callingMicNickname", "getCallingMicNickname", "setCallingMicNickname", "callingMicUsername", "getCallingMicUsername", "setCallingMicUsername", "enterFromScene", "getEnterFromScene", "setEnterFromScene", "hasChangeVideoModePerLinkMic", "", "getHasChangeVideoModePerLinkMic", "()Z", "setHasChangeVideoModePerLinkMic", "(Z)V", "isClickStartLive", "setClickStartLive", "isLiveNameChanged", "setLiveNameChanged", "isManualClosed", "setManualClosed", "isStartLiveReport", "setStartLiveReport", "isVerifyChecked", "setVerifyChecked", "isVerifyUiShow", "setVerifyUiShow", "isVisitorReport", "setVisitorReport", "lastOrientation", "getLastOrientation", "setLastOrientation", "linkMicRequestCount", "getLinkMicRequestCount", "setLinkMicRequestCount", "liveCookies", "", "getLiveCookies", "()[B", "setLiveCookies", "([B)V", "liveDynamicConfig", "Lcom/tencent/mm/live/model/LiveDataManager$LiveDynamicConfig;", "getLiveDynamicConfig", "()Lcom/tencent/mm/live/model/LiveDataManager$LiveDynamicConfig;", "setLiveDynamicConfig", "(Lcom/tencent/mm/live/model/LiveDataManager$LiveDynamicConfig;)V", "liveInfo", "Lcom/tencent/mm/protocal/protobuf/LiveInfo;", "getLiveInfo", "()Lcom/tencent/mm/protocal/protobuf/LiveInfo;", "setLiveInfo", "(Lcom/tencent/mm/protocal/protobuf/LiveInfo;)V", "liveRoomModel", "Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "getLiveRoomModel", "()Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "setLiveRoomModel", "(Lcom/tencent/mm/live/core/core/model/LiveRoomModel;)V", "liveSdkInfo", "Lcom/tencent/mm/protocal/protobuf/LiveSdkInfo;", "getLiveSdkInfo", "()Lcom/tencent/mm/protocal/protobuf/LiveSdkInfo;", "setLiveSdkInfo", "(Lcom/tencent/mm/protocal/protobuf/LiveSdkInfo;)V", "liveSmallWindowInfo", "Lcom/tencent/mm/live/model/LiveDataManager$LiveSmallWindowInfo;", "getLiveSmallWindowInfo", "()Lcom/tencent/mm/live/model/LiveDataManager$LiveSmallWindowInfo;", "setLiveSmallWindowInfo", "(Lcom/tencent/mm/live/model/LiveDataManager$LiveSmallWindowInfo;)V", "mCheckDeviceLsn", "com/tencent/mm/live/model/LiveDataManager$mCheckDeviceLsn$1", "Lcom/tencent/mm/live/model/LiveDataManager$mCheckDeviceLsn$1;", "mStartLinkTimes", "", "getMStartLinkTimes", "()J", "setMStartLinkTimes", "(J)V", "micPmkExpire", "getMicPmkExpire", "setMicPmkExpire", "msgFilterTime", "getMsgFilterTime", "setMsgFilterTime", "msgList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/view/adapter/CommentData;", "Lkotlin/collections/ArrayList;", "getMsgList", "()Ljava/util/ArrayList;", "setMsgList", "(Ljava/util/ArrayList;)V", "onlineHeadImgList", "getOnlineHeadImgList", "setOnlineHeadImgList", "shareRoomList", "Ljava/util/HashMap;", "Lkotlin/Pair;", "Lkotlin/collections/HashMap;", "getShareRoomList", "()Ljava/util/HashMap;", "setShareRoomList", "(Ljava/util/HashMap;)V", "sysMsgManager", "Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager;", "getSysMsgManager", "()Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager;", "setSysMsgManager", "(Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager;)V", "thumbUrl", "getThumbUrl", "setThumbUrl", "visitorCommentCount", "getVisitorCommentCount", "setVisitorCommentCount", "visitorConnectCount", "getVisitorConnectCount", "setVisitorConnectCount", "visitorConnectReqCount", "getVisitorConnectReqCount", "setVisitorConnectReqCount", "visitorEnterErrorCode", "getVisitorEnterErrorCode", "setVisitorEnterErrorCode", "visitorEnterMemberCount", "getVisitorEnterMemberCount", "setVisitorEnterMemberCount", "visitorLikeCount", "getVisitorLikeCount", "setVisitorLikeCount", "wechatRoomId", "getWechatRoomId", "setWechatRoomId", "displayLiveName", "formatLikeCount", "preOnCreate", "", "release", "resetData", "LiveDynamicConfig", "LiveSmallWindowInfo", "plugin-logic_release"})
public final class f
{
  private static final String TAG = "MicroMsg.LiveDataManager";
  private static int iHo;
  private static String qVO;
  private static ArrayList<String> rFL;
  private static HashMap<String, o<ArrayList<String>, Integer>> rFM;
  private static byte[] rFN;
  private static eas rFO;
  private static eaw rFP;
  private static String rFQ;
  private static int rFR;
  private static d rFS;
  private static long rFT;
  private static eaq rFU;
  private static boolean rFW;
  private static String rFX;
  private static String rFZ;
  private static a rGa;
  private static b rGb;
  private static boolean rGc;
  private static boolean rGd;
  private static boolean rGe;
  private static boolean rGf;
  private static boolean rGg;
  private static int rGh;
  private static int rGi;
  private static int rGj;
  private static int rGk;
  private static int rGl;
  private static int rGm;
  private static int rGn;
  private static int rGo;
  private static boolean rGp;
  private static int rGq;
  private static int rGr;
  private static long rGs;
  private static boolean rGt;
  private static com.tencent.mm.live.b.b.a rGu;
  private static final c rGv;
  public static final f rGw;
  private static String thumbUrl;
  private static ArrayList<com.tencent.mm.live.view.a.a> tyE;
  
  static
  {
    AppMethodBeat.i(202608);
    rGw = new f();
    TAG = "MicroMsg.LiveDataManager";
    qVO = "";
    rFL = new ArrayList();
    rFM = new HashMap();
    tyE = new ArrayList();
    rFO = new eas();
    rFQ = "";
    rFU = new eaq();
    rFX = "";
    rFZ = "";
    rGa = new a((byte)0);
    rGb = new b();
    rGu = new com.tencent.mm.live.b.b.a();
    c localc = new c();
    rGv = localc;
    localc.alive();
    AppMethodBeat.o(202608);
  }
  
  public static void Be(long paramLong)
  {
    rFT = paramLong;
  }
  
  public static void Bf(long paramLong)
  {
    rGs = paramLong;
  }
  
  public static void VP()
  {
    AppMethodBeat.i(202606);
    ad.i(TAG, "resetData");
    rFT = 0L;
    qVO = "";
    rFL.clear();
    rFM.clear();
    rFN = null;
    rFO = new eas();
    rFP = null;
    thumbUrl = null;
    com.tencent.mm.live.b.b.a locala = rGu;
    locala.BMq = null;
    locala.BMr = null;
    locala.BMs = null;
    locala.BMt = null;
    locala.BMu = null;
    locala.BMv = null;
    locala.BMw = null;
    locala.BMx = null;
    locala.ytb.clear();
    locala.BMy = "";
    locala.BMz = "";
    tyE.clear();
    rFQ = "";
    rFR = 0;
    rFS = null;
    rFU = new eaq();
    rFW = false;
    iHo = 0;
    rFX = "";
    rFZ = "";
    rGa = new a((byte)0);
    rGb = new b();
    AppMethodBeat.o(202606);
  }
  
  public static void a(eaq parameaq)
  {
    AppMethodBeat.i(202600);
    k.h(parameaq, "<set-?>");
    rFU = parameaq;
    AppMethodBeat.o(202600);
  }
  
  public static void a(eas parameas)
  {
    AppMethodBeat.i(202598);
    k.h(parameas, "<set-?>");
    rFO = parameas;
    AppMethodBeat.o(202598);
  }
  
  public static void a(eaw parameaw)
  {
    rFP = parameaw;
  }
  
  public static void aUk(String paramString)
  {
    AppMethodBeat.i(202597);
    k.h(paramString, "<set-?>");
    qVO = paramString;
    AppMethodBeat.o(202597);
  }
  
  public static void aUl(String paramString)
  {
    thumbUrl = paramString;
  }
  
  public static void aUm(String paramString)
  {
    AppMethodBeat.i(202599);
    k.h(paramString, "<set-?>");
    rFQ = paramString;
    AppMethodBeat.o(202599);
  }
  
  public static void aUn(String paramString)
  {
    AppMethodBeat.i(202601);
    k.h(paramString, "<set-?>");
    rFX = paramString;
    AppMethodBeat.o(202601);
  }
  
  public static void aUo(String paramString)
  {
    AppMethodBeat.i(202602);
    k.h(paramString, "<set-?>");
    rFZ = paramString;
    AppMethodBeat.o(202602);
  }
  
  public static void agA(int paramInt)
  {
    rGj = paramInt;
  }
  
  public static void agB(int paramInt)
  {
    rGk = paramInt;
  }
  
  public static void agC(int paramInt)
  {
    rGl = paramInt;
  }
  
  public static void agD(int paramInt)
  {
    rGm = paramInt;
  }
  
  public static void agE(int paramInt)
  {
    rGn = paramInt;
  }
  
  public static void agF(int paramInt)
  {
    rGo = paramInt;
  }
  
  public static void agG(int paramInt)
  {
    rGq = paramInt;
  }
  
  public static void agH(int paramInt)
  {
    rGr = paramInt;
  }
  
  public static void agw(int paramInt)
  {
    rFR = paramInt;
  }
  
  public static void agx(int paramInt)
  {
    iHo = paramInt;
  }
  
  public static void agy(int paramInt)
  {
    if (rGh < paramInt) {
      rGh = paramInt;
    }
  }
  
  public static void agz(int paramInt)
  {
    rGi = paramInt;
  }
  
  public static void b(d paramd)
  {
    rFS = paramd;
  }
  
  public static void jdMethod_do(byte[] paramArrayOfByte)
  {
    rFN = paramArrayOfByte;
  }
  
  public static String eNB()
  {
    return qVO;
  }
  
  public static ArrayList<String> eNC()
  {
    return rFL;
  }
  
  public static HashMap<String, o<ArrayList<String>, Integer>> eND()
  {
    return rFM;
  }
  
  public static ArrayList<com.tencent.mm.live.view.a.a> eNE()
  {
    return tyE;
  }
  
  public static byte[] eNF()
  {
    return rFN;
  }
  
  public static eas eNG()
  {
    return rFO;
  }
  
  public static eaw eNH()
  {
    return rFP;
  }
  
  public static String eNI()
  {
    return rFQ;
  }
  
  public static int eNJ()
  {
    return rFR;
  }
  
  public static d eNK()
  {
    return rFS;
  }
  
  public static long eNL()
  {
    return rFT;
  }
  
  public static eaq eNM()
  {
    return rFU;
  }
  
  public static int fHk()
  {
    return rGh;
  }
  
  public static String fOA()
  {
    AppMethodBeat.i(202604);
    if (rFO.LyR <= 0)
    {
      localObject = aj.getContext();
      k.g(localObject, "MMApplicationContext.getContext()");
      localObject = ((Context)localObject).getResources().getString(2131766587);
      k.g(localObject, "MMApplicationContext.get…ing.live_like_count_zero)");
      AppMethodBeat.o(202604);
      return localObject;
    }
    if (rFO.LyR < 10000)
    {
      int i = rFO.LyR;
      AppMethodBeat.o(202604);
      return String.valueOf(i);
    }
    if (rFO.LyR % 10000 >= 1000)
    {
      localObject = z.Jhz;
      localObject = aj.getContext();
      k.g(localObject, "MMApplicationContext.getContext()");
      localObject = ((Context)localObject).getResources().getString(2131766585);
      k.g(localObject, "MMApplicationContext.get…g.live_like_count_format)");
      localObject = String.format((String)localObject, Arrays.copyOf(new Object[] { Float.valueOf(rFO.LyR / 10000.0F) }, 1));
      k.g(localObject, "java.lang.String.format(format, *args)");
      AppMethodBeat.o(202604);
      return localObject;
    }
    Object localObject = z.Jhz;
    localObject = aj.getContext();
    k.g(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getResources().getString(2131766586);
    k.g(localObject, "MMApplicationContext.get…ve_like_count_int_format)");
    localObject = String.format((String)localObject, Arrays.copyOf(new Object[] { Integer.valueOf(rFO.LyR / 10000) }, 1));
    k.g(localObject, "java.lang.String.format(format, *args)");
    AppMethodBeat.o(202604);
    return localObject;
  }
  
  public static String fOB()
  {
    AppMethodBeat.i(202605);
    String str2;
    String str1;
    if (bt.isNullOrNil(rFO.LwZ))
    {
      str2 = rFO.Lzh;
      str1 = str2;
      if (str2 == null)
      {
        AppMethodBeat.o(202605);
        return "";
      }
    }
    else
    {
      str2 = rFO.LwZ;
      str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
    }
    AppMethodBeat.o(202605);
    return str1;
  }
  
  public static void fOC()
  {
    boolean bool2 = true;
    AppMethodBeat.i(202607);
    int i = bt.getInt(g.Zd().getValue("MMLiveConfigBitSet"), 0);
    a locala = rGa;
    if (!com.tencent.mm.ad.c.cQ(i, 1))
    {
      bool1 = true;
      locala.rGx = bool1;
      locala = rGa;
      if (com.tencent.mm.ad.c.cQ(i, 2)) {
        break label111;
      }
      bool1 = true;
      label55:
      locala.rGy = bool1;
      locala = rGa;
      if (com.tencent.mm.ad.c.cQ(i, 4)) {
        break label116;
      }
      bool1 = true;
      label74:
      locala.rGz = bool1;
      locala = rGa;
      if (com.tencent.mm.ad.c.cQ(i, 8)) {
        break label121;
      }
    }
    label111:
    label116:
    label121:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      locala.rGA = bool1;
      AppMethodBeat.o(202607);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label55;
      bool1 = false;
      break label74;
    }
  }
  
  public static int fOn()
  {
    return rGi;
  }
  
  public static int fOo()
  {
    return rGj;
  }
  
  public static int fOp()
  {
    return rGk;
  }
  
  public static int fOq()
  {
    return rGl;
  }
  
  public static int fOr()
  {
    return rGm;
  }
  
  public static int fOs()
  {
    return rGn;
  }
  
  public static int fOt()
  {
    return rGo;
  }
  
  public static boolean fOu()
  {
    return rGp;
  }
  
  public static int fOv()
  {
    return rGq;
  }
  
  public static int fOw()
  {
    return rGr;
  }
  
  public static long fOx()
  {
    AppMethodBeat.i(202603);
    long l = (System.currentTimeMillis() - rGs) / 1000L;
    AppMethodBeat.o(202603);
    return l;
  }
  
  public static boolean fOy()
  {
    return rGt;
  }
  
  public static com.tencent.mm.live.b.b.a fOz()
  {
    return rGu;
  }
  
  public static boolean fhE()
  {
    return rFW;
  }
  
  public static void fhF()
  {
    rFW = true;
  }
  
  public static int fhG()
  {
    return iHo;
  }
  
  public static String fhH()
  {
    return rFX;
  }
  
  public static a fhI()
  {
    return rGa;
  }
  
  public static b fhJ()
  {
    return rGb;
  }
  
  public static boolean fhK()
  {
    return rGc;
  }
  
  public static boolean fiE()
  {
    return rGd;
  }
  
  public static boolean fiF()
  {
    return rGe;
  }
  
  public static void fps()
  {
    rGe = true;
  }
  
  public static boolean fuT()
  {
    return rGf;
  }
  
  public static boolean fvH()
  {
    return rGg;
  }
  
  public static void kQ(boolean paramBoolean)
  {
    rGc = paramBoolean;
  }
  
  public static void kW(boolean paramBoolean)
  {
    rGd = paramBoolean;
  }
  
  public static void kX(boolean paramBoolean)
  {
    rGf = paramBoolean;
  }
  
  public static void la(boolean paramBoolean)
  {
    rGg = paramBoolean;
  }
  
  public static void li(boolean paramBoolean)
  {
    rGp = paramBoolean;
  }
  
  public static void lj(boolean paramBoolean)
  {
    rGt = paramBoolean;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/LiveDataManager$LiveDynamicConfig;", "", "enableLandscape", "", "enableCheckPhoneNum", "enableVisitorPolicyPage", "enableVerifyPage", "(ZZZZ)V", "getEnableCheckPhoneNum", "()Z", "setEnableCheckPhoneNum", "(Z)V", "getEnableLandscape", "setEnableLandscape", "getEnableVerifyPage", "setEnableVerifyPage", "getEnableVisitorPolicyPage", "setEnableVisitorPolicyPage", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "plugin-logic_release"})
  public static final class a
  {
    boolean rGA = true;
    public boolean rGx = true;
    boolean rGy = true;
    boolean rGz = true;
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.rGx != paramObject.rGx) || (this.rGy != paramObject.rGy) || (this.rGz != paramObject.rGz) || (this.rGA != paramObject.rGA)) {}
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
      AppMethodBeat.i(202589);
      String str = "LiveDynamicConfig(enableLandscape=" + this.rGx + ", enableCheckPhoneNum=" + this.rGy + ", enableVisitorPolicyPage=" + this.rGz + ", enableVerifyPage=" + this.rGA + ")";
      AppMethodBeat.o(202589);
      return str;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/LiveDataManager$LiveSmallWindowInfo;", "", "userId", "", "streamType", "", "width", "height", "(Ljava/lang/String;III)V", "getHeight", "()I", "setHeight", "(I)V", "getStreamType", "setStreamType", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "getWidth", "setWidth", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "isLandscape", "toString", "plugin-logic_release"})
  public static final class b
  {
    public int height;
    public int streamType;
    public String userId;
    public int width;
    
    private b(String paramString)
    {
      AppMethodBeat.i(202591);
      this.userId = paramString;
      this.streamType = 0;
      this.width = 0;
      this.height = 0;
      AppMethodBeat.o(202591);
    }
    
    public final boolean aov()
    {
      return this.width > this.height;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(202595);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((!k.g(this.userId, paramObject.userId)) || (this.streamType != paramObject.streamType) || (this.width != paramObject.width) || (this.height != paramObject.height)) {}
        }
      }
      else
      {
        AppMethodBeat.o(202595);
        return true;
      }
      AppMethodBeat.o(202595);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(202594);
      String str = this.userId;
      if (str != null) {}
      for (int i = str.hashCode();; i = 0)
      {
        int j = this.streamType;
        int k = this.width;
        int m = this.height;
        AppMethodBeat.o(202594);
        return ((i * 31 + j) * 31 + k) * 31 + m;
      }
    }
    
    public final void setUserId(String paramString)
    {
      AppMethodBeat.i(202590);
      k.h(paramString, "<set-?>");
      this.userId = paramString;
      AppMethodBeat.o(202590);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(202593);
      String str = "LiveSmallWindowInfo(userId=" + this.userId + ", streamType=" + this.streamType + ", width=" + this.width + ", height=" + this.height + ")";
      AppMethodBeat.o(202593);
      return str;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/live/model/LiveDataManager$mCheckDeviceLsn$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/LiveStateActionEvent;", "callback", "", "event", "plugin-logic_release"})
  public static final class c
    extends com.tencent.mm.sdk.b.c<yr>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.b.f
 * JD-Core Version:    0.7.0.1
 */