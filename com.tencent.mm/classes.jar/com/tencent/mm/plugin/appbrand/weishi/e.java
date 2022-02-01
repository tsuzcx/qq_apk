package com.tencent.mm.plugin.appbrand.weishi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXDynamicVideoMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/weishi/AppBrandWeishiTestLogic;", "", "()V", "CMD", "", "SUB_CMD_DO_SHARE", "SUB_CMD_ENABLE_SHARE", "TAG", "canSkipOpenCheck", "", "isShareEnabled", "Ljava/lang/Boolean;", "wxApi", "Lcom/tencent/mm/opensdk/openapi/IWXAPI;", "kotlin.jvm.PlatformType", "getWxApi", "()Lcom/tencent/mm/opensdk/openapi/IWXAPI;", "wxApi$delegate", "Lkotlin/Lazy;", "checkCanSkipOpenCheck", "isForceEnableShare", "markCanSkipOpenCheck", "", "willExpired", "parseCmdVal", "args", "", "([Ljava/lang/String;)V", "parseSubCmdDoShareVal", "parseSubCmdEnableShareVal", "unsetCanSkipOpenCheck", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final e uvO;
  private static final j uvP;
  private static volatile boolean uvQ;
  private static Boolean uvR;
  
  static
  {
    AppMethodBeat.i(317692);
    uvO = new e();
    uvP = k.cm((a)a.uvS);
    AppMethodBeat.o(317692);
  }
  
  private static final void cOA()
  {
    AppMethodBeat.i(317687);
    Log.i("MicroMsg.AppBrand.AppBrandWeishiTestLogic", "markCanSkipOpenCheck, expired");
    uvQ = false;
    AppMethodBeat.o(317687);
  }
  
  public static final boolean cOx()
  {
    AppMethodBeat.i(317651);
    synchronized (uvO)
    {
      Boolean localBoolean = uvR;
      Log.i("MicroMsg.AppBrand.AppBrandWeishiTestLogic", s.X("isForceEnableShare, isShareEnabled: ", localBoolean));
      boolean bool = s.p(Boolean.TRUE, localBoolean);
      AppMethodBeat.o(317651);
      return bool;
    }
  }
  
  public static final boolean cOy()
  {
    AppMethodBeat.i(317657);
    boolean bool = uvQ;
    Log.i("MicroMsg.AppBrand.AppBrandWeishiTestLogic", s.X("checkCanSkipOpenCheck, canSkipOpenCheck: ", Boolean.valueOf(bool)));
    AppMethodBeat.o(317657);
    return bool;
  }
  
  private static void cOz()
  {
    AppMethodBeat.i(317673);
    Log.i("MicroMsg.AppBrand.AppBrandWeishiTestLogic", "unsetCanSkipOpenCheck");
    uvQ = false;
    AppMethodBeat.o(317673);
  }
  
  private static void lj(boolean paramBoolean)
  {
    AppMethodBeat.i(317665);
    Log.i("MicroMsg.AppBrand.AppBrandWeishiTestLogic", s.X("markCanSkipOpenCheck, willExpired: ", Boolean.valueOf(paramBoolean)));
    uvQ = true;
    if (paramBoolean) {
      h.ahAA.r(e..ExternalSyntheticLambda1.INSTANCE, 20000L);
    }
    AppMethodBeat.o(317665);
  }
  
  private static final void o(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(317685);
    s.u(paramString, "$thumbUrl");
    WXDynamicVideoMiniProgramObject localWXDynamicVideoMiniProgramObject = new WXDynamicVideoMiniProgramObject();
    localWXDynamicVideoMiniProgramObject.videoSource = "http://v.weishi.qq.com/v.weishi.qq.com/gzc_1047_1047_0b53gmamuaaahqaiyvij6fqbomyezisabtsa.f70.mp4?dis_k=ad4a8ccc7315fce2aab011425e58f5d1&dis_t=1632394393&fromtag=0&personid=1574059520255127&pver=8.11.0&stdfrom=wsc2c&wsadapt=1574059520255127_0923185313_2046617805_196469373_0_0_0_999_27_1_2_0_100000_0&qua=V1_WXA_WS_3.0.0_001_IDC_NEW";
    localWXDynamicVideoMiniProgramObject.appThumbUrl = paramString;
    localWXDynamicVideoMiniProgramObject.webpageUrl = "https://www.qq.com";
    localWXDynamicVideoMiniProgramObject.userName = "gh_8c10d2f0f25e";
    localWXDynamicVideoMiniProgramObject.path = "package-c2c/pages/redpacket-c2c/redpacket-c2c?eventid=&v_f0_size=0&wx_cover=https%3A%2F%2Fisee.weishi.qq.com%2F2021c2c%2Fnewwxminiprogram16x9.png&v_height=1280&redPackeType=b2c&v_width=720&vkey_time=1611990847&hb_type=1&pkg=&spid=1568689193225483&chid=139136028&v_use_f0=1&post_time=0&feed_id=7brEtTHt11L5KsmRD&cover=https%3A%2F%2Fshootmedia.qpic.cn%2Fmaterial%2Fc6c2f5c3c75e6bb05381fcd9ef4f5757.png&v_src=http%3A%2F%2Fv.weishi.qq.com%2Fgzc_1047_1047_0b53gmamuaaahqaiyvij6fqbomyezisabtsa.f70.mp4%3Fdis_k%3D4f2af1d02c5a98d28432553779f98f15%26dis_t%3D1611990847%26fromtag%3D0%26personid%3D1568689193225483%26pver%3D%26wsadapt%3D1568689193225483_0130151407_587953602_165291755_1_0_0_25_27_1_2_0_100000_0%26qua%3Dv1_and_weishi_8.11.0_2092_027081004_d_alpha&feed_accesstoken=ZjY3MGEzYTc5MzkzZGZiNmEzOTM5MzcwZmRkZmE3ZjE=&s_img=http%3A%2F%2Fpic.weishi.qq.com%2F99e8a43b30254859af12d35c4a9bcover.jpg&personId=&attach=cp_reserves3_1300830028&b_type=interactive_template_rain_red_packet_c2c&v_wx_src=http%3A%2F%2Fv.weishi.qq.com%2Fgzc_1047_1047_0b53gmamuaaahqaiyvij6fqbomyezisabtsa.f70.mp4%3Fdis_k%3D4f2af1d02c5a98d28432553779f98f15%26dis_t%3D1611990847%26fromtag%3D0%26personid%3D1568689193225483%26pver%3D%26wsadapt%3D1568689193225483_0130151407_587953602_165291755_1_0_0_25_27_1_2_0_100000_0%26qua%3Dv1_and_weishi_8.11.0_2092_027081004_d_alpha&v_duration=0&wxImageUrl=http%3A%2F%2Fpic.weishi.qq.com%2F99e8a43b30254859af12d35c4a9bcover.jpg";
    localWXDynamicVideoMiniProgramObject.withShareTicket = false;
    localWXDynamicVideoMiniProgramObject.miniprogramType = 0;
    localWXDynamicVideoMiniProgramObject.disableforward = 0;
    localWXDynamicVideoMiniProgramObject.isUpdatableMessage = false;
    localWXDynamicVideoMiniProgramObject.isSecretMessage = false;
    paramString = new WXMediaMessage((WXMediaMessage.IMediaObject)localWXDynamicVideoMiniProgramObject);
    paramString.thumbData = paramArrayOfByte;
    paramArrayOfByte = new SendMessageToWX.Req();
    paramArrayOfByte.transaction = null;
    paramArrayOfByte.message = paramString;
    paramArrayOfByte.scene = 0;
    lj(true);
    ((IWXAPI)uvP.getValue()).sendReq((BaseReq)paramArrayOfByte);
    AppMethodBeat.o(317685);
  }
  
  public static final void t(String[] paramArrayOfString)
  {
    AppMethodBeat.i(317640);
    s.u(paramArrayOfString, "args");
    Object localObject = Arrays.toString(paramArrayOfString);
    s.s(localObject, "java.util.Arrays.toString(this)");
    Log.i("MicroMsg.AppBrand.AppBrandWeishiTestLogic", s.X("parseCmdVal, args: ", localObject));
    if (paramArrayOfString.length == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(317640);
      return;
    }
    if ((!s.p("//appbrand_weishi", paramArrayOfString[0])) || (2 > paramArrayOfString.length))
    {
      AppMethodBeat.o(317640);
      return;
    }
    localObject = paramArrayOfString[1];
    if (s.p(localObject, "doShare"))
    {
      paramArrayOfString = Arrays.toString(paramArrayOfString);
      s.s(paramArrayOfString, "java.util.Arrays.toString(this)");
      Log.i("MicroMsg.AppBrand.AppBrandWeishiTestLogic", s.X("parseSubCmdDoShareVal, args: ", paramArrayOfString));
      b.bEY().a("https://isee.weishi.qq.com/2021c2c/newwxminiprogram16x9.png", new e..ExternalSyntheticLambda0("https://isee.weishi.qq.com/2021c2c/newwxminiprogram16x9.png"));
      AppMethodBeat.o(317640);
      return;
    }
    if (s.p(localObject, "enableShare"))
    {
      localObject = uvO;
      String str = Arrays.toString(paramArrayOfString);
      s.s(str, "java.util.Arrays.toString(this)");
      Log.i("MicroMsg.AppBrand.AppBrandWeishiTestLogic", s.X("parseSubCmdEnableShareVal, args: ", str));
      if (3 <= paramArrayOfString.length)
      {
        paramArrayOfString = paramArrayOfString[2];
        try
        {
          if (s.p(paramArrayOfString, "0"))
          {
            cOz();
            paramArrayOfString = Boolean.FALSE;
          }
          for (;;)
          {
            uvR = paramArrayOfString;
            paramArrayOfString = ah.aiuX;
            return;
            if (s.p(paramArrayOfString, "1"))
            {
              lj(false);
              paramArrayOfString = Boolean.TRUE;
            }
            else
            {
              cOz();
              paramArrayOfString = null;
            }
          }
          AppMethodBeat.o(317640);
        }
        finally
        {
          AppMethodBeat.o(317640);
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/opensdk/openapi/IWXAPI;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<IWXAPI>
  {
    public static final a uvS;
    
    static
    {
      AppMethodBeat.i(317620);
      uvS = new a();
      AppMethodBeat.o(317620);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.weishi.e
 * JD-Core Version:    0.7.0.1
 */