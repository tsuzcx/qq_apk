package com.tencent.mm.plugin.brandservice;

import android.content.Context;
import android.util.Base64;
import android.widget.Toast;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.u;
import com.tencent.mm.storage.y;
import com.tencent.mm.vfs.o;
import d.g.b.p;
import d.l;
import d.n.n;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/BizProcessorCommand;", "Lcom/tencent/mm/pluginsdk/cmd/ProcessorCommand;", "()V", "processCommand", "", "context", "Landroid/content/Context;", "args", "", "", "username", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "Companion", "plugin-brandservice_release"})
public final class a
  implements com.tencent.mm.pluginsdk.cmd.a
{
  private static final String obc = "//biz";
  public static final a obd;
  
  static
  {
    AppMethodBeat.i(6447);
    obd = new a((byte)0);
    obc = "//biz";
    AppMethodBeat.o(6447);
  }
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(6446);
    if ((paramArrayOfString != null) && (p.i(obc, paramArrayOfString[0])))
    {
      if ((p.i("openbiztimeline", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = ay.aRX("brandService");
        paramContext.encode("BizTimeLineOpenStatus", bu.getInt(paramArrayOfString[2], -1));
        paramContext.apply();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.i("showbottomnav", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        ay.aRW("WebViewUIShowBottom").encode("WebViewUIShowBottomNav", bu.getInt(paramArrayOfString[2], -1));
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.i("checkWebviewId", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = ay.aRW("MicroMsg.BizVideoDetailUI");
        paramContext.encode("CheckWebviewId", bu.getInt(paramArrayOfString[2], -1));
        paramContext.apply();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.i("deleteolddata", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = ay.aRX("brandService");
        paramContext.encode("BizTimeLineDeleteOldData", bu.getInt(paramArrayOfString[2], -1));
        paramContext.apply();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.i("addRecCard", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = Base64.decode(paramArrayOfString[2], 2);
        p.g(paramContext, "Base64.decode(args[2], Base64.NO_WRAP)");
        paramContext = new String(paramContext, d.n.d.UTF_8);
        paramArrayOfString = ay.aRX("brandService");
        paramString = new StringBuilder("BizLatestRecommendCardInfo");
        p.g(g.ajP(), "MMKernel.account()");
        paramString = com.tencent.mm.kernel.a.aiF();
        if (paramArrayOfString == null) {
          p.gkB();
        }
        paramArrayOfString.encode(paramString, paramContext);
        AppMethodBeat.o(6446);
        return true;
      }
      int i;
      if ((p.i("addPayAlbum", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = Base64.decode(paramArrayOfString[2], 2);
        p.g(paramContext, "Base64.decode(args[2], Base64.NO_WRAP)");
        paramString = new String(paramContext, d.n.d.UTF_8);
        i = n.a((CharSequence)paramString, "<sysmsg", 0, false, 6);
        if (i != -1)
        {
          paramContext = paramString.substring(i);
          p.g(paramContext, "(this as java.lang.String).substring(startIndex)");
          paramArrayOfString = bx.M(paramContext, "sysmsg");
          paramContext = paramArrayOfString;
          if (paramArrayOfString == null)
          {
            ae.e(obc, "XmlParser values is null, msgContent %s", new Object[] { paramString });
            AppMethodBeat.o(6446);
            return true;
          }
        }
        else
        {
          paramContext = null;
        }
        paramArrayOfString = com.tencent.mm.plugin.biz.b.a.nUu;
        com.tencent.mm.plugin.biz.b.a.f(paramContext, paramString);
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.i("paySuccess", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = Base64.decode(paramArrayOfString[2], 2);
        p.g(paramContext, "Base64.decode(args[2], Base64.NO_WRAP)");
        paramContext = bx.M(new String(paramContext, d.n.d.UTF_8), "sysmsg");
        paramArrayOfString = com.tencent.mm.plugin.brandservice.b.a.obW;
        p.g(paramContext, "values");
        com.tencent.mm.plugin.brandservice.b.a.Y(paramContext);
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.i("profileCrash", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = ay.aRX("ProfileCrashCheck");
        paramContext.encode("testCrash", bu.getInt(paramArrayOfString[2], 1));
        paramContext.apply();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.i("updateAppInfo", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = paramArrayOfString[2];
        if (bu.isNullOrNil(paramContext))
        {
          AppMethodBeat.o(6446);
          return true;
        }
        com.tencent.e.h.MqF.f((Runnable)new b(paramContext), "GetAppInfoASyncThread");
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.i("resortbizmsgcheck", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = ay.aRX("brandService");
        paramContext.encode("BizTimeLineReSortMsgCheck", bu.getInt(paramArrayOfString[2], 1));
        paramContext.apply();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.i("showdigest", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = ay.aRX("brandService");
        paramContext.encode("BizTimeLineShowDigest", bu.getInt(paramArrayOfString[2], -1));
        paramContext.apply();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.i("oftenread", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        if (bu.getInt(paramArrayOfString[2], -1) == 0) {}
        for (bool = true;; bool = false)
        {
          com.tencent.mm.plugin.biz.b.b.jd(bool);
          AppMethodBeat.o(6446);
          return true;
        }
      }
      if ((p.i("videochannel", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        if (bu.getInt(paramArrayOfString[2], -1) == 0) {
          bool = true;
        }
        com.tencent.mm.plugin.biz.b.b.je(bool);
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.i("sl", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = ay.aRW("bizCommand");
        paramContext.encode("sameLayerOpen", bu.getInt(paramArrayOfString[2], -1));
        paramContext.apply();
        a.onSuccess();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.i("resortbizmsgtest", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = u.IIC;
        u.abm(bu.getInt(paramArrayOfString[2], -1));
        a.onSuccess();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.i("adtest", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = ay.aRX("brandService");
        paramContext.encode("BizTimeLineAdTestMode", bu.getInt(paramArrayOfString[2], 0));
        paramContext.apply();
        a.onSuccess();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.i("ad", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = ay.aRX("brandService");
        paramContext.encode("BizTimeLineAdOpen", bu.getInt(paramArrayOfString[2], 0));
        paramContext.apply();
        a.onSuccess();
        AppMethodBeat.o(6446);
        return true;
      }
      if (p.i("clearpkg", paramArrayOfString[1]))
      {
        paramContext = com.tencent.mm.plugin.webcanvas.h.DQL;
        com.tencent.mm.plugin.webcanvas.h.uV(true);
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.i("adpreview", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = ay.aRX("WebCanvasStorage");
        paramContext.encode("BizTimeLineAdPreviewMode", bu.getInt(paramArrayOfString[2], 0));
        paramContext.apply();
        a.onSuccess();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((p.i("test", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = ay.aRX("brandService");
        paramContext.encode("BizTimeLineTestMode", bu.getInt(paramArrayOfString[2], 0));
        paramContext.apply();
        a.onSuccess();
        AppMethodBeat.o(6446);
        return true;
      }
      if (p.i("clearsubscribemsg", paramArrayOfString[1]))
      {
        com.tencent.mm.al.b.b.hVA.aGO();
        AppMethodBeat.o(6446);
        return true;
      }
      if (p.i("clearimg", paramArrayOfString[1]))
      {
        com.tencent.e.h.MqF.aO((Runnable)c.obh);
        AppMethodBeat.o(6446);
        return true;
      }
      if (p.i("timel", paramArrayOfString[1]))
      {
        i = Integer.parseInt(paramArrayOfString[2]);
        paramContext = "中国国家地理" + System.currentTimeMillis() % 10000L;
        if (i == 1001)
        {
          paramContext = "<sysmsg type=\"BizRecommendExpt\">\n<BizRecommendExpt>\n<Title><![CDATA[猜你喜欢]]></Title>\n<Pos>1</Pos>\n<Weight>200</Weight>\n<RecID>1591189349</RecID>\n<RedDotFlag>1</RedDotFlag>\n<BusinessId>0</BusinessId>\n<CardID><![CDATA[card_10086]]></CardID>\n<Data><![CDATA[{\"Title\":\"猜你喜欢\",\"BizAccount\":[{\"Flag\":0,\"UserName\":\"gh_f05ff0331d78\",\"NickName\":\"" + paramContext + "\",\"RecommendReason\":\"\",\"Signature\":\"《深度参考》是中国高端精英读物，是您了解最新、最有深度、最有价值的时事财经资讯窗口，欢迎关注！\",\"BrandIconUrl\":\"http://mmbiz.qpic.cn/mmbiz/3lXPl12icGVZjPnbiaWdLbMQoNpTK6ZicaTFUk5jLfciaRVoukmISPd5DC6YHy5No4a4uy6k3PnIMIH00XJOVw0ibRw/0?wx_fmt=png\",\"AppMsgRecReason\":\"近期更新\",\"AppMsg\":[{\"Flag\":0,\"Title\":\"气温超过50°的极热之地，你敢去吗？\",\"Digest\":\"我是摘要测试测试\",\"ContentUrl\":\"https://mp.weixin.qq.com/s/oKmmWfX9G3Yfbmp5aDeyTQ\",\"CoverImgUrl\":\"http://mmbiz.qpic.cn/mmbiz_jpg/3lXPl12icGVZIyj3SMeiaotBJ8r5qwgAicflnXdjFKicPd2jbfd0ibRpsUFo7m0oAenT7ReBddeeqmoicDBPcOVCaMNw/0?wx_fmt=jpeg\",\"CoverImgUrl_1_1\":\"https://mmbiz.qlogo.cn/mmbiz_jpg/3lXPl12icGVZIyj3SMeiaotBJ8r5qwgAicflnXdjFKicPd2jbfd0ibRpsUFo7m0oAenT7ReBddeeqmoicDBPcOVCaMNw/0?wx_fmt=jpeg\",\"CoverImgUrl_235_1\":\"\",\"ItemShowType\":0,\"VideoId\":\"\",\"VideoWidth\":0,\"VideoHeight\":0,\"VideoDuration\":180,\"CreateTime\":1593296809,\"NegativeFeedbackReason\":[\"内容质量低\",\"不看此公众号\"],\"ShowNegativeFeedbackReason\":0,\"RecommendReason\":\"\",\"VoicePlayUrl\":\"\",\"VoiceDuration\":0,\"RecRk\":1,\"RecInfo\":\"something\",\"AppMsgId\":2698324179,\"ItemIdx\":1,\"AuthorAppUin\":1014597342,\"CanReward\":0,\"CanPaid\":0},{\"Flag\":0,\"Title\":\"深度雄文，西部高原屏障对中华民族战略安全的重大意义！\",\"Digest\":\"深度参考长按右边的二维码关注2013年4月在中国的阿克塞欣的斗拉特别里奥地地区中印两国爆发“帐蓬对峙”，20\",\"ContentUrl\":\"http://mp.weixin.qq.com/s?__biz=MzAwNzY5Mzg1MQ==&mid=2698324092&idx=4&sn=015c49c8d05b56267366a2cce351c2ec&chksm=be5bbb08892c321e990026bce74c09ad13da8ec56896875358f4db0271222b09b146b95739b1#rd\",\"CoverImgUrl\":\"http://mmbiz.qpic.cn/mmbiz_jpg/3lXPl12icGVY34GKxTibsNvqZEtEeIFYTRKFt0yr47GZY0AicB2iaU9Iuf7r374aNic2ZD8M2iaZibGkhXEicDwpViaSbiaA/0?wx_fmt=jpeg\",\"CoverImgUrl_1_1\":\"https://mmbiz.qlogo.cn/mmbiz_jpg/3lXPl12icGVY34GKxTibsNvqZEtEeIFYTRKFt0yr47GZY0AicB2iaU9Iuf7r374aNic2ZD8M2iaZibGkhXEicDwpViaSbiaA/0?wx_fmt=jpeg\",\"CoverImgUrl_235_1\":\"\",\"ItemShowType\":0,\"VideoId\":\"\",\"VideoWidth\":0,\"VideoHeight\":0,\"VideoDuration\":180,\"CreateTime\":1593211927,\"NegativeFeedbackReason\":[\"内容质量低\",\"不看此公众号\"],\"ShowNegativeFeedbackReason\":0,\"RecommendReason\":\"\",\"VoicePlayUrl\":\"\",\"VoiceDuration\":180,\"RecRk\":2,\"RecInfo\":\"great\",\"AppMsgId\":2698324092,\"ItemIdx\":4,\"AuthorAppUin\":1654122144,\"CanReward\":0,\"CanPaid\":0}],\"NegativeFeedbackReason\":[\"不看此公众号\",\"内容低质\",\"内容重复\",\"内容过时\",\"希望减少推荐\"],\"ShowNegativeFeedbackReason\":1,\"BizUin\":3007693851}],\"Pos\":1,\"Weight\":200,\"RecID\":10086,\"Style\":1001,\"Event\":\"hengqing\",\"RedDotFlag\":1,\"RecSummary\":\"深度长文：美“印太战略”注定失败，中国有能力应付美国极端选择！\",\"CardId\":\"cdd97abeab063a0e00cea86f805bb17c\",\"ExpType\":\"tools\"}]]></Data>\n<RecSummary><![CDATA[气温超过50°的极热之地，你敢去吗？]]></RecSummary>\n<AppId><![CDATA[wxf337cbaa27790d8e]]></AppId>\n<ExtraData><![CDATA[{\"type\":1,\"real_data\":\"{\\\"biz_info\\\":[{\\\"username\\\":\\\"gh_49f4cd2ce99b\\\",\\\"nickname\\\":\\\"皮皮浪老师\\\",\\\"appmsg_info\\\":[{\\\"url\\\":\\\"http:\\\\\\/\\\\\\/mp.weixin.qq.com\\\\\\/s?__biz=MzA4OTE5NzQ5MQ==&mid=2247483877&idx=1&sn=e693e539daef056fa051e66374e41b48&chksm=901fdf39a768562fe6aaaeed3dfc9909d781ea8c45862cc335ed527eafcdb51f4aca774f67c3#rd\\\",\\\"title\\\":\\\"皮皮浪的复盘讲解（二十二）——围空不要拆二\\\",\\\"rec_rk\\\":1,\\\"rec_info\\\":\\\"something\\\",\\\"item_show_type\\\":5}]}],\\\"style\\\":1001,\\\"event\\\":\\\"hengqing\\\",\\\"card_id\\\":\\\"33a95e9794780cc0f584220dbb9fcfe2\\\",\\\"exp_type\\\":\\\"tools\\\"}\"}]]></ExtraData>\n<TemplatePath><![CDATA[re.js]]></TemplatePath>\n<TemplatePathType><![CDATA[re]]></TemplatePathType>\n</BizRecommendExpt>\n</sysmsg>";
          i = n.a((CharSequence)paramContext, "<sysmsg", 0, false, 6);
          if (i != -1)
          {
            if (paramContext == null)
            {
              paramContext = new v("null cannot be cast to non-null type java.lang.String");
              AppMethodBeat.o(6446);
              throw paramContext;
            }
            paramArrayOfString = paramContext.substring(i);
            p.g(paramArrayOfString, "(this as java.lang.String).substring(startIndex)");
            paramArrayOfString = bx.M(paramArrayOfString, "sysmsg");
            if (paramArrayOfString != null) {
              break label1401;
            }
            ae.e("MicroMsg.BizTimeLineStorageLogicExKt", "XmlParser values is null, msgContent %s", new Object[] { paramContext });
          }
          for (;;)
          {
            AppMethodBeat.o(6446);
            return true;
            label1401:
            paramContext = aa.bQ(paramArrayOfString);
            if (paramContext == null) {
              p.gkB();
            }
            aa.d(paramContext);
          }
        }
        paramContext = "";
        if (i == 1) {
          paramContext = "<sysmsg type=\"BizRecommendNotify\">\n<BizAccountRecommend>\n<Title><![CDATA[猜你喜欢]]></Title>\n\n<BizAccount>\n<UserName><![CDATA[gh_f05ff0331d78]]></UserName>\n<NickName><![CDATA[深度参考]]></NickName>\n<HeadImgUrl><![CDATA[]]></HeadImgUrl>\n<RecommendReason><![CDATA[]]></RecommendReason>\n<Signature><![CDATA[《深度参考》是中国高端精英读物，是您了解最新、最有深度、最有价值的时事财经资讯窗口，欢迎关注！]]></Signature>\n<BrandIconUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz/3lXPl12icGVZjPnbiaWdLbMQoNpTK6ZicaTFUk5jLfciaRVoukmISPd5DC6YHy5No4a4uy6k3PnIMIH00XJOVw0ibRw/0?wx_fmt=png]]></BrandIconUrl>\n<AppMsgRecReason><![CDATA[]]></AppMsgRecReason>\n\n<AppMsg>\n<Title><![CDATA[深度长文：美“印太战略”注定失败，中国有能力应付美国极端选择！]]></Title>\n<Digest><![CDATA[]]></Digest>\n<ContentUrl><![CDATA[http://mp.weixin.qq.com/s?__biz=MzAwNzY5Mzg1MQ==&mid=2698324179&idx=1&sn=02fb8d7cbd9a4187266280edccc1c303&chksm=be5bbba7892c32b19e13202074ffb143c96ff4d1024939ce4c917cf740905e67444b11604b13#rd]]></ContentUrl>\n<CoverImgUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz_jpg/3lXPl12icGVZIyj3SMeiaotBJ8r5qwgAicflnXdjFKicPd2jbfd0ibRpsUFo7m0oAenT7ReBddeeqmoicDBPcOVCaMNw/0?wx_fmt=jpeg]]></CoverImgUrl>\n<CoverImgUrl_1_1><![CDATA[https://mmbiz.qlogo.cn/mmbiz_jpg/3lXPl12icGVZIyj3SMeiaotBJ8r5qwgAicflnXdjFKicPd2jbfd0ibRpsUFo7m0oAenT7ReBddeeqmoicDBPcOVCaMNw/0?wx_fmt=jpeg]]></CoverImgUrl_1_1>\n<CoverImgUrl_235_1><![CDATA[]]></CoverImgUrl_235_1>\n<ItemShowType>0</ItemShowType>\n<VideoId><![CDATA[]]></VideoId>\n<VideoWidth>0</VideoWidth>\n<VideoHeight>0</VideoHeight>\n<VideoDuration>0</VideoDuration>\n<CreateTime>1593296809</CreateTime>\n\n<NegativeFeedbackReason><![CDATA[内容质量低]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[不看此公众号]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>0</ShowNegativeFeedbackReason>\n<VoicePlayUrl><![CDATA[]]></VoicePlayUrl>\n<VoiceDuration>0</VoiceDuration>\n<RecRk>1</RecRk>\n<RecInfo><![CDATA[something]]></RecInfo>\n</AppMsg>\n\n<AppMsg>\n<Title><![CDATA[深度雄文，西部高原屏障对中华民族战略安全的重大意义！]]></Title>\n<Digest><![CDATA[]]></Digest>\n<ContentUrl><![CDATA[http://mp.weixin.qq.com/s?__biz=MzAwNzY5Mzg1MQ==&mid=2698324092&idx=4&sn=015c49c8d05b56267366a2cce351c2ec&chksm=be5bbb08892c321e990026bce74c09ad13da8ec56896875358f4db0271222b09b146b95739b1#rd]]></ContentUrl>\n<CoverImgUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz_jpg/3lXPl12icGVY34GKxTibsNvqZEtEeIFYTRKFt0yr47GZY0AicB2iaU9Iuf7r374aNic2ZD8M2iaZibGkhXEicDwpViaSbiaA/0?wx_fmt=jpeg]]></CoverImgUrl>\n<CoverImgUrl_1_1><![CDATA[https://mmbiz.qlogo.cn/mmbiz_jpg/3lXPl12icGVY34GKxTibsNvqZEtEeIFYTRKFt0yr47GZY0AicB2iaU9Iuf7r374aNic2ZD8M2iaZibGkhXEicDwpViaSbiaA/0?wx_fmt=jpeg]]></CoverImgUrl_1_1>\n<CoverImgUrl_235_1><![CDATA[]]></CoverImgUrl_235_1>\n<ItemShowType>0</ItemShowType>\n<VideoId><![CDATA[]]></VideoId>\n<VideoWidth>0</VideoWidth>\n<VideoHeight>0</VideoHeight>\n<VideoDuration>0</VideoDuration>\n<CreateTime>1593211927</CreateTime>\n\n<NegativeFeedbackReason><![CDATA[内容质量低]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[不看此公众号]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>0</ShowNegativeFeedbackReason>\n<VoicePlayUrl><![CDATA[]]></VoicePlayUrl>\n<VoiceDuration>0</VoiceDuration>\n<RecRk>2</RecRk>\n<RecInfo><![CDATA[great]]></RecInfo>\n</AppMsg>\n\n\n<NegativeFeedbackReason><![CDATA[不看此公众号]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容低质]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容重复]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容过时]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[希望减少推荐]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>1</ShowNegativeFeedbackReason>\n</BizAccount>\n\n<Pos>1</Pos>\n<Weight>200</Weight>\n<RecID>10086</RecID>\n<Style>102</Style>\n<Event>hengqing</Event>\n<RedDotFlag>1</RedDotFlag>\n<RecSummary><![CDATA[深度长文：美“印太战略”注定失败，中国有能力应付美国极端选择！]]></RecSummary>\n<CardId><![CDATA[cdd97abeab063a0e00cea86f805bb17c]]></CardId>\n<ExpType><![CDATA[tools]]></ExpType>\n</BizAccountRecommend>\n</sysmsg>";
        }
        for (;;)
        {
          y.aUc(paramContext);
          break;
          if (i == 2) {
            paramContext = "<sysmsg type=\"BizRecommendNotify\">\n<BizAccountRecommend>\n<Title><![CDATA[猜你喜欢]]></Title>\n\n<BizAccount>\n<UserName><![CDATA[gh_028c33dfd807]]></UserName>\n<NickName><![CDATA[粤知一二]]></NickName>\n<HeadImgUrl><![CDATA[]]></HeadImgUrl>\n<RecommendReason><![CDATA[]]></RecommendReason>\n<Signature><![CDATA[由广东综艺90后门面担当郭嘉峰主持，是一档有个性有深度，看了会上瘾的粤语脱口秀节目。每晚18：00准时更新。]]></Signature>\n<BrandIconUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz_png/Y7rtYuVxk9TNiaA7iciav0aI5ZNxxxVybPXOoxocjzdu2REcv0bck59HFZ9jJTmHB6spYXlqibCfUia8E9997dLaoHw/0?wx_fmt=png]]></BrandIconUrl>\n<AppMsgRecReason><![CDATA[]]></AppMsgRecReason>\n\n<AppMsg>\n<Title><![CDATA[经常吃港式茶餐厅的你，点餐时一定都听过这些暗号！]]></Title>\n<Digest><![CDATA[]]></Digest>\n<ContentUrl><![CDATA[http://mp.weixin.qq.com/s?__biz=MzI4MDU3Njk4MA==&mid=2247506230&idx=2&sn=80d0ead06f7d4446e42a89d57ee81699&chksm=ebb4cf8ddcc3469b4d62d4324bcec575812c28fea3d68af6e838f0a9a5bb79a8db7320fc7e70#rd]]></ContentUrl>\n<CoverImgUrl><![CDATA[https://vpic.video.qq.com/36675860/i0787zrbitj.png]]></CoverImgUrl>\n<CoverImgUrl_1_1><![CDATA[]]></CoverImgUrl_1_1>\n<CoverImgUrl_235_1><![CDATA[]]></CoverImgUrl_235_1>\n<ItemShowType>5</ItemShowType>\n<VideoId><![CDATA[i0787zrbitj]]></VideoId>\n<VideoWidth>0</VideoWidth>\n<VideoHeight>0</VideoHeight>\n<VideoDuration>245</VideoDuration>\n<CreateTime>1592751453</CreateTime>\n\n<NegativeFeedbackReason><![CDATA[内容质量低]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[不看此公众号]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>0</ShowNegativeFeedbackReason>\n<VoicePlayUrl><![CDATA[]]></VoicePlayUrl>\n<VoiceDuration>0</VoiceDuration>\n<RecRk>1</RecRk>\n<RecInfo><![CDATA[something]]></RecInfo>\n</AppMsg>\n\n<AppMsg>\n<Title><![CDATA[教你一套坐公交车自救秘籍，你想要吗？]]></Title>\n<Digest><![CDATA[]]></Digest>\n<ContentUrl><![CDATA[http://mp.weixin.qq.com/s?__biz=MzI4MDU3Njk4MA==&mid=2247494577&idx=1&sn=b0e489f3f5517b7942526aab7710052c&chksm=ebb4fd0adcc3741cc503f47ca2e1193af82db286d2baa438bb8d6209de9e192d8aaac5281d2a#rd]]></ContentUrl>\n<CoverImgUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz_jpg/Y7rtYuVxk9QHKGicgHASZibRp09iaGwSnnAN4cHzBvfupOIsibv78UfUGAJtcH1wT7wmAOicHib1k8a2FErDx7DFMNpg/0?wx_fmt=jpeg]]></CoverImgUrl>\n<CoverImgUrl_1_1><![CDATA[]]></CoverImgUrl_1_1>\n<CoverImgUrl_235_1><![CDATA[]]></CoverImgUrl_235_1>\n<ItemShowType>5</ItemShowType>\n<VideoId><![CDATA[wxv_543960396546260993]]></VideoId>\n<VideoWidth>0</VideoWidth>\n<VideoHeight>0</VideoHeight>\n<VideoDuration>314</VideoDuration>\n<CreateTime>1542015514</CreateTime>\n\n<NegativeFeedbackReason><![CDATA[内容质量低]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[不看此公众号]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>0</ShowNegativeFeedbackReason>\n<VoicePlayUrl><![CDATA[]]></VoicePlayUrl>\n<VoiceDuration>0</VoiceDuration>\n<RecRk>2</RecRk>\n<RecInfo><![CDATA[great]]></RecInfo>\n</AppMsg>\n\n\n<NegativeFeedbackReason><![CDATA[不看此公众号]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容低质]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容重复]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容过时]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[希望减少推荐]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>1</ShowNegativeFeedbackReason>\n</BizAccount>\n\n<Pos>1</Pos>\n<Weight>200</Weight>\n<RecID>10086</RecID>\n<Style>102</Style>\n<Event>hengqing</Event>\n<RedDotFlag>1</RedDotFlag>\n<RecSummary><![CDATA[经常吃港式茶餐厅的你，点餐时一定都听过这些暗号！]]></RecSummary>\n<CardId><![CDATA[3cefe0c5fdefac11a0e3b666addc4879]]></CardId>\n<ExpType><![CDATA[tools]]></ExpType>\n</BizAccountRecommend>\n</sysmsg>";
          } else if (i == 3) {
            paramContext = "<sysmsg type=\"BizRecommendNotify\">\n<BizAccountRecommend>\n<Title><![CDATA[猜你喜欢]]></Title>\n\n<BizAccount>\n<UserName><![CDATA[gh_028c33dfd807]]></UserName>\n<NickName><![CDATA[粤知一二]]></NickName>\n<HeadImgUrl><![CDATA[]]></HeadImgUrl>\n<RecommendReason><![CDATA[]]></RecommendReason>\n<Signature><![CDATA[由广东综艺90后门面担当郭嘉峰主持，是一档有个性有深度，看了会上瘾的粤语脱口秀节目。每晚18：00准时更新。]]></Signature>\n<BrandIconUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz_png/Y7rtYuVxk9TNiaA7iciav0aI5ZNxxxVybPXOoxocjzdu2REcv0bck59HFZ9jJTmHB6spYXlqibCfUia8E9997dLaoHw/0?wx_fmt=png]]></BrandIconUrl>\n<AppMsgRecReason><![CDATA[]]></AppMsgRecReason>\n\n<AppMsg>\n<Title><![CDATA[经常吃港式茶餐厅的你，点餐时一定都听过这些暗号！]]></Title>\n<Digest><![CDATA[]]></Digest>\n<ContentUrl><![CDATA[http://mp.weixin.qq.com/s?__biz=MzI4MDU3Njk4MA==&mid=2247506230&idx=2&sn=80d0ead06f7d4446e42a89d57ee81699&chksm=ebb4cf8ddcc3469b4d62d4324bcec575812c28fea3d68af6e838f0a9a5bb79a8db7320fc7e70#rd]]></ContentUrl>\n<CoverImgUrl><![CDATA[https://vpic.video.qq.com/36675860/i0787zrbitj.png]]></CoverImgUrl>\n<CoverImgUrl_1_1><![CDATA[]]></CoverImgUrl_1_1>\n<CoverImgUrl_235_1><![CDATA[]]></CoverImgUrl_235_1>\n<ItemShowType>5</ItemShowType>\n<VideoId><![CDATA[i0787zrbitj]]></VideoId>\n<VideoWidth>0</VideoWidth>\n<VideoHeight>0</VideoHeight>\n<VideoDuration>245</VideoDuration>\n<CreateTime>1592751453</CreateTime>\n\n<NegativeFeedbackReason><![CDATA[内容质量低]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[不看此公众号]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>0</ShowNegativeFeedbackReason>\n<VoicePlayUrl><![CDATA[]]></VoicePlayUrl>\n<VoiceDuration>0</VoiceDuration>\n<RecRk>1</RecRk>\n<RecInfo><![CDATA[something]]></RecInfo>\n</AppMsg>\n\n\n<NegativeFeedbackReason><![CDATA[不看此公众号]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容低质]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容重复]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容过时]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[希望减少推荐]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>1</ShowNegativeFeedbackReason>\n</BizAccount>\n\n<Pos>1</Pos>\n<Weight>200</Weight>\n<RecID>10086</RecID>\n<Style>102</Style>\n<Event>hengqing</Event>\n<RedDotFlag>1</RedDotFlag>\n<RecSummary><![CDATA[经常吃港式茶餐厅的你，点餐时一定都听过这些暗号！]]></RecSummary>\n<CardId><![CDATA[3cefe0c5fdefac11a0e3b666addc4879]]></CardId>\n<ExpType><![CDATA[tools]]></ExpType>\n</BizAccountRecommend>\n</sysmsg>";
          } else if (i == 4) {
            paramContext = "<sysmsg type=\"BizRecommendNotify\">\n<BizAccountRecommend>\n<Title><![CDATA[猜你喜欢]]></Title>\n\n<BizAccount>\n<UserName><![CDATA[gh_f05ff0331d78]]></UserName>\n<NickName><![CDATA[深度参考]]></NickName>\n<HeadImgUrl><![CDATA[]]></HeadImgUrl>\n<RecommendReason><![CDATA[]]></RecommendReason>\n<Signature><![CDATA[《深度参考》是中国高端精英读物，是您了解最新、最有深度、最有价值的时事财经资讯窗口，欢迎关注！]]></Signature>\n<BrandIconUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz/3lXPl12icGVZjPnbiaWdLbMQoNpTK6ZicaTFUk5jLfciaRVoukmISPd5DC6YHy5No4a4uy6k3PnIMIH00XJOVw0ibRw/0?wx_fmt=png]]></BrandIconUrl>\n<AppMsgRecReason><![CDATA[]]></AppMsgRecReason>\n\n<AppMsg>\n<Title><![CDATA[深度长文：美“印太战略”注定失败，中国有能力应付美国极端选择！]]></Title>\n<Digest><![CDATA[]]></Digest>\n<ContentUrl><![CDATA[http://mp.weixin.qq.com/s?__biz=MzAwNzY5Mzg1MQ==&mid=2698324179&idx=1&sn=02fb8d7cbd9a4187266280edccc1c303&chksm=be5bbba7892c32b19e13202074ffb143c96ff4d1024939ce4c917cf740905e67444b11604b13#rd]]></ContentUrl>\n<CoverImgUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz_jpg/3lXPl12icGVZIyj3SMeiaotBJ8r5qwgAicflnXdjFKicPd2jbfd0ibRpsUFo7m0oAenT7ReBddeeqmoicDBPcOVCaMNw/0?wx_fmt=jpeg]]></CoverImgUrl>\n<CoverImgUrl_1_1><![CDATA[https://mmbiz.qlogo.cn/mmbiz_jpg/3lXPl12icGVZIyj3SMeiaotBJ8r5qwgAicflnXdjFKicPd2jbfd0ibRpsUFo7m0oAenT7ReBddeeqmoicDBPcOVCaMNw/0?wx_fmt=jpeg]]></CoverImgUrl_1_1>\n<CoverImgUrl_235_1><![CDATA[]]></CoverImgUrl_235_1>\n<ItemShowType>0</ItemShowType>\n<VideoId><![CDATA[]]></VideoId>\n<VideoWidth>0</VideoWidth>\n<VideoHeight>0</VideoHeight>\n<VideoDuration>0</VideoDuration>\n<CreateTime>1593296809</CreateTime>\n\n<NegativeFeedbackReason><![CDATA[内容质量低]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[不看此公众号]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>0</ShowNegativeFeedbackReason>\n<VoicePlayUrl><![CDATA[]]></VoicePlayUrl>\n<VoiceDuration>0</VoiceDuration>\n<RecRk>1</RecRk>\n<RecInfo><![CDATA[something]]></RecInfo>\n</AppMsg>\n\n\n<NegativeFeedbackReason><![CDATA[不看此公众号]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容低质]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容重复]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容过时]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[希望减少推荐]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>1</ShowNegativeFeedbackReason>\n</BizAccount>\n\n<Pos>1</Pos>\n<Weight>200</Weight>\n<RecID>10086</RecID>\n<Style>101</Style>\n<Event>hengqing</Event>\n<RedDotFlag>1</RedDotFlag>\n<RecSummary><![CDATA[深度长文：美“印太战略”注定失败，中国有能力应付美国极端选择！]]></RecSummary>\n<CardId><![CDATA[cdd97abeab063a0e00cea86f805bb17c]]></CardId>\n<ExpType><![CDATA[tools]]></ExpType>\n</BizAccountRecommend>\n</sysmsg>";
          } else if (i == 5) {
            paramContext = "<sysmsg type=\"BizRecommendNotify\">\n<BizAccountRecommend>\n<Title><![CDATA[推荐公众号]]></Title>\n\n<BizAccount>\n<UserName><![CDATA[gh_240fbf8b33e4]]></UserName>\n<NickName><![CDATA[36氪]]></NickName>\n<HeadImgUrl><![CDATA[]]></HeadImgUrl>\n<RecommendReason><![CDATA[36氪是中国领先的新商业媒体，提供新锐深度的商业报道。我们强调趋势与价值，我们的slogan是：让一部分人先看到未来。]]></RecommendReason>\n<Signature><![CDATA[36氪是中国领先的新商业媒体，提供新锐深度的商业报道。我们强调趋势与价值，我们的slogan是：让一部分人先看到未来。]]></Signature>\n<BrandIconUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz_png/QicyPhNHD5vYf0JyXiavcUmicQ7icOk55ygRlyOhCa9r132trMAiaYtqL0QzacfMLPolhsiaXGibWC0JskibLic02W6Mw1g/0?wx_fmt=png]]></BrandIconUrl>\n<AppMsgRecReason><![CDATA[]]></AppMsgRecReason>\n\n<AppMsg>\n<Title><![CDATA[8点1氪：微信回应或遭苹果下架；格力口罩昨日开售：KN95每只5.5元；美股史上第二次触发熔断]]></Title>\n<Digest><![CDATA[]]></Digest>\n<ContentUrl><![CDATA[http://mp.weixin.qq.com/s?__biz=MzI2NDk5NzA0Mw==&mid=2247569208&idx=1&sn=27b7704f80c8271dcad2e52ee63cdf01&chksm=eaa79ee4ddd017f21d63e7a780c1941812f847bf968b40b2d81329b4e9f5a4f70f4e6e814c79#rd]]></ContentUrl>\n<CoverImgUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz_jpg/QicyPhNHD5vbhqC2kPdlU3tQrCiakmhHStEcNCOLwrocic2Vvr0J3qPNiaKYEn2vYIsQbGFBYM5PSAF9NecOalcnFw/0?wx_fmt=jpeg]]></CoverImgUrl>\n<CoverImgUrl_1_1><![CDATA[https://mmbiz.qlogo.cn/mmbiz_jpg/QicyPhNHD5vbhqC2kPdlU3tQrCiakmhHStkWNVPziaEt1aEVBPnYyrzlpAbEXicqQ8zRmNgDBfupiccdibuBpeCHpKeQ/0?wx_fmt=jpeg]]></CoverImgUrl_1_1>\n<CoverImgUrl_235_1><![CDATA[]]></CoverImgUrl_235_1>\n<ItemShowType>0</ItemShowType>\n<VideoId><![CDATA[]]></VideoId>\n<VideoWidth>0</VideoWidth>\n<VideoHeight>0</VideoHeight>\n<VideoDuration>0</VideoDuration>\n<CreateTime>1583799540</CreateTime>\n\n<ShowNegativeFeedbackReason>0</ShowNegativeFeedbackReason>\n</AppMsg>\n\n\n<NegativeFeedbackReason><![CDATA[对A1不感兴趣]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[对A2不感兴趣]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容质量低]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[对此公众号不感兴趣]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[希望减少推荐]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>1</ShowNegativeFeedbackReason>\n</BizAccount>\n\n<BizAccount>\n<UserName><![CDATA[gh_363b924965e9]]></UserName>\n<NickName><![CDATA[人民日报]]></NickName>\n<HeadImgUrl><![CDATA[]]></HeadImgUrl>\n<RecommendReason><![CDATA[参与、沟通、记录时代。]]></RecommendReason>\n<Signature><![CDATA[参与、沟通、记录时代。]]></Signature>\n<BrandIconUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz_png/xrFYciaHL08CtD0lEHt59N8SQicW1gI0WjYKCEpzgRCPFBlJGI1rIfRl4bFSTLoFnI4iaylWmJVqd8semEK1OGylg/0?wx_fmt=png]]></BrandIconUrl>\n<AppMsgRecReason><![CDATA[]]></AppMsgRecReason>\n\n<AppMsg>\n<Title><![CDATA[发请柬啦！我们邀请所有人，共同见证一场盛大的婚礼！]]></Title>\n<Digest><![CDATA[]]></Digest>\n<ContentUrl><![CDATA[http://mp.weixin.qq.com/s?__biz=MjM5MjAxNDM4MA==&mid=2666316160&idx=1&sn=54684fd350167a7f3bed5bde5ce9dc64&chksm=bdb4a8c38ac321d5852e261a2e31f038fd0e98ec66bee2920d88ee4cdf11979bdede1e0c908e#rd]]></ContentUrl>\n<CoverImgUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz_jpg/xrFYciaHL08AD1ynAav39zdY1WvI5bbsyACCQygrAQqFY1EZiaRwHJYMD7v2x2LLBp0YsHwku3In19N5D3aYZx9A/0?wx_fmt=jpeg]]></CoverImgUrl>\n<CoverImgUrl_1_1><![CDATA[https://mmbiz.qlogo.cn/mmbiz_jpg/xrFYciaHL08AD1ynAav39zdY1WvI5bbsy1kWLuqdNxNVFWIUWBC0DTgnyAkt5cAicI2DyfkVZ14Bx5oemgWmiaphg/0?wx_fmt=jpeg]]></CoverImgUrl_1_1>\n<CoverImgUrl_235_1><![CDATA[]]></CoverImgUrl_235_1>\n<ItemShowType>0</ItemShowType>\n<VideoId><![CDATA[]]></VideoId>\n<VideoWidth>0</VideoWidth>\n<VideoHeight>0</VideoHeight>\n<VideoDuration>0</VideoDuration>\n<CreateTime>1589804841</CreateTime>\n\n<ShowNegativeFeedbackReason>0</ShowNegativeFeedbackReason>\n</AppMsg>\n\n\n<NegativeFeedbackReason><![CDATA[对D不感兴趣]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容质量低]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[对此公众号不感兴趣]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[希望减少推荐]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>1</ShowNegativeFeedbackReason>\n</BizAccount>\n\n<Pos>1</Pos>\n<Weight>200</Weight>\n<RecID>1589808970</RecID>\n<Style>103</Style>\n<Event></Event>\n<RecSummary><![CDATA[深度长文：美“印太战略”注定失败，中国有能力应付美国极端选择！]]></RecSummary>\n<CardId><![CDATA[cdd97abeab063a0e00cea86f805bb17a]]></CardId>\n<AggregationUrl><![CDATA[http://wwww.baidu.com]]></AggregationUrl>\n<AggregationTitle><![CDATA[大家都在看的大事件 >]]></AggregationTitle>\n<NegativeFeedbackReason><![CDATA[对A1不感兴趣对A1不感兴趣对A1不感兴趣对A1不感兴趣对A1不感兴趣对A1不感兴趣对A1不感兴趣对A1不感兴趣]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[对A2不感兴趣]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容质量低]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[对此公众号不感兴趣]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[希望减少推荐]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>1</ShowNegativeFeedbackReason>\n</BizAccountRecommend>\n</sysmsg>";
          }
        }
      }
    }
    AppMethodBeat.o(6446);
    return false;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/BizProcessorCommand$Companion;", "", "()V", "COMMAND_BIZ", "", "init", "", "onSuccess", "plugin-brandservice_release"})
  public static final class a
  {
    public static void onSuccess()
    {
      AppMethodBeat.i(208573);
      Toast.makeText(ak.getContext(), (CharSequence)"Success! WeChat will kill self in 1 second...", 1).show();
      com.tencent.e.h.MqF.q((Runnable)a.obe, 1000L);
      AppMethodBeat.o(208573);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      public static final a obe;
      
      static
      {
        AppMethodBeat.i(208572);
        obe = new a();
        AppMethodBeat.o(208572);
      }
      
      public final void run()
      {
        AppMethodBeat.i(208571);
        ((com.tencent.mm.plugin.brandservice.a.a)g.ab(com.tencent.mm.plugin.brandservice.a.a.class)).bgT();
        AppMethodBeat.o(208571);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(6443);
      if (com.tencent.mm.pluginsdk.model.app.h.cC(this.obf, true) != null) {
        ar.f((Runnable)1.obg);
      }
      AppMethodBeat.o(6443);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    public static final c obh;
    
    static
    {
      AppMethodBeat.i(6445);
      obh = new c();
      AppMethodBeat.o(6445);
    }
    
    public final void run()
    {
      AppMethodBeat.i(6444);
      o.deleteDir(com.tencent.mm.plugin.image.d.dfL());
      AppMethodBeat.o(6444);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.a
 * JD-Core Version:    0.7.0.1
 */