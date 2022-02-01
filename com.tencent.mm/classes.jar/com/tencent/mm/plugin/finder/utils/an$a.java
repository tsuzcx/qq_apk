package com.tencent.mm.plugin.finder.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Base64;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.dn;
import com.tencent.mm.model.cn;
import com.tencent.mm.modelsns.e;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.cgi.ap;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.event.a.b;
import com.tencent.mm.plugin.finder.live.report.q.c;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.ca;
import com.tencent.mm.plugin.finder.report.ag;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.findersdk.a.bn;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.plugin.findersdk.a.i;
import com.tencent.mm.plugin.findersdk.a.q;
import com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.plugin.textstatus.a.w;
import com.tencent.mm.plugin.textstatus.a.w.a;
import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.asb;
import com.tencent.mm.protocal.protobuf.atg;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bmr;
import com.tencent.mm.protocal.protobuf.boi;
import com.tencent.mm.protocal.protobuf.bth;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bvh;
import com.tencent.mm.protocal.protobuf.bvi;
import com.tencent.mm.protocal.protobuf.bvj;
import com.tencent.mm.protocal.protobuf.bvl;
import com.tencent.mm.protocal.protobuf.bvm;
import com.tencent.mm.protocal.protobuf.bvn;
import com.tencent.mm.protocal.protobuf.bwa;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.protocal.protobuf.dne;
import com.tencent.mm.protocal.protobuf.dob;
import com.tencent.mm.protocal.protobuf.doc;
import com.tencent.mm.protocal.protobuf.dzj;
import com.tencent.mm.protocal.protobuf.emx;
import com.tencent.mm.protocal.protobuf.fei;
import com.tencent.mm.protocal.protobuf.fhp;
import com.tencent.mm.protocal.protobuf.ok;
import com.tencent.mm.protocal.protobuf.pu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ck;
import com.tencent.mm.storage.cl;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.MMFragmentActivity.c;
import com.tencent.mm.ui.base.aa;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.ah.d;
import kotlin.g.b.s;
import kotlin.g.b.u;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/FinderShareUtil$Companion;", "", "()V", "REQUEST_CODE_SHARE_FEED_TO_CHAT", "", "REQUEST_CODE_SHARE_FEED_TO_SNS", "REQUEST_CODE_SHARE_LIVE_INVITE_TO_CHAT", "REQUEST_CODE_SHARE_LIVE_TO_CHAT", "REQUEST_CODE_SHARE_LIVE_TO_SNS", "REQUEST_CODE_SHARE_LIVE_TO_TEXT_STATUS", "REQUEST_CODE_SHARE_NAMECARD_TO_CAHT", "REQUEST_CODE_SHARE_PRODUCT_TO_CHAT", "REQUEST_CODE_SHARE_VIDEO_FILE_TO_CHAT", "TAG", "", "getTAG", "()Ljava/lang/String;", "quickShareCount", "getQuickShareCount", "()I", "setQuickShareCount", "(I)V", "continueShareProduct", "", "context", "Landroid/content/Context;", "shareObject", "Lcom/tencent/mm/protocal/protobuf/FinderProductShareObject;", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "toUsers", "finderObjToJumpInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "genFinderShareAlbum", "Lcom/tencent/mm/protocal/protobuf/FinderShareAlbum;", "card", "Lcom/tencent/mm/protocal/protobuf/FinderStreamCard;", "cardId", "title", "subTitle", "urls", "urlTokens", "cardBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "genFinderSharePoi", "Lcom/tencent/mm/protocal/protobuf/FinderSharePoi;", "location", "Lcom/tencent/mm/protocal/protobuf/SnsLocation;", "poiCategories", "iconUrl", "poiName", "videoCount", "getAppMsgContent", "Lcom/tencent/mm/message/AppMessage$Content;", "feedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "finderShareObject", "Lcom/tencent/mm/protocal/protobuf/FinderShareObject;", "megaObject", "Lcom/tencent/mm/protocal/protobuf/MegaVideoShareObject;", "getFavEventInfo", "Lcom/tencent/mm/autogen/events/DoFavoriteEvent;", "feed", "thumbPath", "getFinderSetStatusParam", "Lcom/tencent/mm/plugin/textstatus/api/SetStatusParam;", "nickName", "itemId", "", "getFinderShareObject", "isShareSns", "", "getFinderTopic", "Lcom/tencent/mm/protocal/protobuf/FinderShareTopic;", "topic", "topicType", "desc", "poiLocation", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "patMusicId", "activityEvent", "Lcom/tencent/mm/protocal/protobuf/FinderActivityEvent;", "getMegaVideoShareObject", "finderMegaVideo", "Lcom/tencent/mm/protocal/protobuf/FinderMegaVideo;", "liveShareStatsReport", "stats", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/Stats;", "quickShareLiveToConversation", "Lcom/tencent/mm/plugin/findersdk/api/AppMSgContentFinderLiveObject;", "Landroidx/appcompat/app/AppCompatActivity;", "quickShareToConversation", "Lcom/tencent/mm/plugin/findersdk/api/AppMsgContentFinderObject;", "param", "Landroid/os/Bundle;", "shareType", "shareAlbumToConversation", "Lcom/tencent/mm/ui/MMActivity;", "objectContent", "Lcom/tencent/mm/plugin/findersdk/api/AppMsgContentFinderAlbum;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "shareAlbumToSnsTimeLine", "snsShare", "Lcom/tencent/mm/modelsns/SnsFinderShareAlbum;", "shareFeedToConversation", "isQuickShare", "finerShareObject", "shareFeedToStatusInternal", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "shareFinderContactToConversation", "contact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "shareInvitingLiveToConversation", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "avatar", "shareLiveToConversation", "shareLiveToConversationImpl", "msgType", "msgRetrType", "shareLiveToSns", "shareLiveToSnsTimeLineInternal", "snsType", "shareLiveToStatusInternal", "shareMegaVideoToConversation", "shareMegaVideoToSnsTimeLine", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "sharePoiFeedToConversation", "sharePoiFeedToSnsTimeLine", "shareProductToConversation", "sharePurchaseLiveToConversation", "sharePurchaseLiveToSns", "shareToConversation", "shareToConvertionStatsReport", "shareToSnsStatsReport", "shareToSnsTimeLine", "postFromSnsType", "shareToSnsTimeLineInternal", "Lcom/tencent/mm/ui/MMFragmentActivity;", "shareToStatusTimeLine", "shareTopicToConversation", "totalCount", "scene", "followId", "shareTopicToSnsTimeLine", "shareWinterOlympicsLiveToStatus", "verifyInfo", "sourceName", "localPicPath", "updateShareInfo", "userNames", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class an$a
{
  private static int GhT;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(167909);
    GhS = new a();
    TAG = "Finder.FinderShareUtil";
    AppMethodBeat.o(167909);
  }
  
  private static com.tencent.mm.message.k.b C(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(333738);
    s.u(paramFinderItem, "feedObject");
    paramFinderItem = a(d(paramFinderItem, false));
    AppMethodBeat.o(333738);
    return paramFinderItem;
  }
  
  public static void E(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(334043);
    s.u(paramFinderItem, "feedObject");
    LinkedList localLinkedList = new LinkedList();
    fhp localfhp = new fhp();
    localfhp.hKN = paramFinderItem.getId();
    localfhp.objectNonceId = paramFinderItem.getObjectNonceId();
    Object localObject1 = new dzj();
    ((dzj)localObject1).abej = 1;
    ((dzj)localObject1).share = 1;
    Object localObject2 = ah.aiuX;
    localfhp.abIj = ((dzj)localObject1);
    localObject1 = paramFinderItem.getFeedObject();
    if (localObject1 == null)
    {
      localObject1 = "";
      localfhp.sessionBuffer = ((String)localObject1);
      localfhp.finderUsername = paramFinderItem.getUserName();
      localfhp.AJo = 65;
      paramFinderItem = paramFinderItem.getLiveInfo();
      if (paramFinderItem != null) {
        break label171;
      }
    }
    label171:
    for (long l = 0L;; l = paramFinderItem.liveId)
    {
      localfhp.mMJ = l;
      localLinkedList.add(localfhp);
      bi(localLinkedList);
      AppMethodBeat.o(334043);
      return;
      localObject2 = ((FinderObject)localObject1).sessionBuffer;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject1 = "";
      break;
    }
  }
  
  public static void TX(int paramInt)
  {
    GhT = paramInt;
  }
  
  public static com.tencent.mm.message.k.b a(bvl parambvl)
  {
    AppMethodBeat.i(333729);
    s.u(parambvl, "finderShareObject");
    com.tencent.mm.message.k.b localb = new com.tencent.mm.message.k.b();
    com.tencent.mm.plugin.findersdk.a.f localf = new com.tencent.mm.plugin.findersdk.a.f();
    localf.c(parambvl);
    localb.a((com.tencent.mm.message.f)localf);
    localb.type = 51;
    localb.title = MMApplicationContext.getContext().getString(e.h.low_version_upgrade_tip);
    localb.url = MMApplicationContext.getContext().getString(e.h.low_version_upgrade_url);
    AppMethodBeat.o(333729);
    return localb;
  }
  
  public static com.tencent.mm.message.k.b a(doc paramdoc)
  {
    AppMethodBeat.i(333753);
    s.u(paramdoc, "megaObject");
    Log.i(TAG, "getFinderShareObject from megaVideo");
    bvl localbvl = new bvl();
    localbvl.objectId = paramdoc.objectId;
    localbvl.objectNonceId = paramdoc.objectNonceId;
    localbvl.nickname = paramdoc.nickname;
    localbvl.username = paramdoc.username;
    localbvl.desc = paramdoc.desc;
    localbvl.avatar = paramdoc.avatar;
    localbvl.aacT = paramdoc.aaVe;
    localbvl.aacU = paramdoc.PMd;
    localbvl.GfT = 11111;
    localbvl.hGP = paramdoc.mediaList.size();
    LinkedList localLinkedList = localbvl.mediaList;
    paramdoc = paramdoc.mediaList;
    s.s(paramdoc, "megaObject.mediaList");
    Object localObject = (Iterable)paramdoc;
    paramdoc = (Collection)new ArrayList(p.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      dob localdob = (dob)((Iterator)localObject).next();
      bvj localbvj = new bvj();
      localbvj.mediaType = 4;
      localbvj.url = localdob.url;
      localbvj.thumbUrl = localdob.thumbUrl;
      localbvj.HaI = localdob.coverUrl;
      localbvj.width = localdob.width;
      localbvj.height = localdob.height;
      localbvj.aacR = localdob.aacR;
      paramdoc.add(localbvj);
    }
    localLinkedList.addAll((Collection)paramdoc);
    paramdoc = a(localbvl);
    AppMethodBeat.o(333753);
    return paramdoc;
  }
  
  public static com.tencent.mm.plugin.findersdk.a.b a(AppCompatActivity paramAppCompatActivity, FinderItem paramFinderItem)
  {
    AppMethodBeat.i(333666);
    s.u(paramAppCompatActivity, "context");
    s.u(paramFinderItem, "feedObject");
    paramAppCompatActivity = new com.tencent.mm.plugin.findersdk.a.b();
    paramAppCompatActivity.b(paramFinderItem.getFinderLive());
    AppMethodBeat.o(333666);
    return paramAppCompatActivity;
  }
  
  public static w a(String paramString1, String paramString2, long paramLong, FinderObject paramFinderObject)
  {
    AppMethodBeat.i(333834);
    s.u(paramFinderObject, "finderObject");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(b(paramFinderObject));
    localArrayList.add(com.tencent.mm.plugin.textstatus.a.a.hFn());
    w.a locala = new w.a();
    CharSequence localCharSequence = (CharSequence)paramFinderObject.wx_status_icon_id;
    int i;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label185;
      }
      locala.bdr("1024");
    }
    for (;;)
    {
      locala.bdx(paramString1);
      locala.bdy(paramString2);
      locala.bdu("finder@inner");
      locala.bdv(com.tencent.mm.ae.d.hF(paramLong));
      locala.bdw(paramFinderObject.verify_info_buf);
      locala.bdy("http://wxapp.tc.qq.com/258/20304/stodownload?m=9823aa7c1879309ff7588e09c22144dd&filekey=30340201010420301e020201020402534804109823aa7c1879309ff7588e09c22144dd020207b8040d00000004627466730000000131&hy=SH&storeid=32303231303331383139353930393030306236313937303030303030303037636638353130393030303030313032&bizid=1023");
      locala.ls((List)localArrayList);
      paramString1 = locala.ThS;
      s.s(paramString1, "Builder().apply {\n      …fo)\n            }.build()");
      AppMethodBeat.o(333834);
      return paramString1;
      i = 0;
      break;
      label185:
      locala.bdr(paramFinderObject.wx_status_icon_id);
    }
  }
  
  private static bvh a(String paramString1, String paramString2, String paramString3, List<String> paramList1, List<String> paramList2, com.tencent.mm.bx.b paramb)
  {
    int i = 0;
    AppMethodBeat.i(333955);
    bvh localbvh = new bvh();
    localbvh.cardId = paramString1;
    localbvh.title = paramString2;
    localbvh.uCW = paramString3;
    paramString1 = ((Iterable)paramList1.subList(0, kotlin.k.k.qv(4, paramList1.size()))).iterator();
    while (paramString1.hasNext())
    {
      paramString2 = paramString1.next();
      if (i < 0) {
        p.kkW();
      }
      paramString2 = (String)paramString2;
      localbvh.aacP.add(paramString2);
      localbvh.aacQ.add(paramList2.get(i));
      i += 1;
    }
    localbvh.AEA = paramb;
    AppMethodBeat.o(333955);
    return localbvh;
  }
  
  private static bvm a(fei paramfei, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(334020);
    s.u(paramfei, "location");
    s.u(paramString1, "poiCategories");
    bvm localbvm = new bvm();
    localbvm.aada = String.valueOf(paramfei.ZaG);
    localbvm.aacZ = String.valueOf(paramfei.ZaH);
    localbvm.ZWG = paramfei.ZWG;
    localbvm.aadb = String.valueOf(paramfei.aaPN);
    localbvm.XOv = paramString2;
    localbvm.oDI = paramfei.ReU;
    if (!Util.isNullOrNil(paramfei.poiName)) {
      paramString3 = paramfei.poiName;
    }
    localbvm.poiName = paramString3;
    paramfei = new StringBuilder();
    paramString2 = r.TQ(paramInt);
    if (Util.isNullOrNil(paramString1)) {
      if (paramInt > 0) {
        paramfei.append(MMApplicationContext.getContext().getString(e.h.finder_poi_feed_share_card_video_count, new Object[] { paramString2 }));
      }
    }
    for (;;)
    {
      localbvm.AXm = paramfei.toString();
      AppMethodBeat.o(334020);
      return localbvm;
      paramfei.append(paramString1);
      if (paramInt > 0) {
        paramfei.append(" | ").append(MMApplicationContext.getContext().getString(e.h.finder_poi_feed_share_card_video_count, new Object[] { paramString2 }));
      }
    }
  }
  
  private static bvn a(String paramString1, int paramInt, String paramString2, String paramString3, boi paramboi, String paramString4, atg paramatg)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(333944);
    bvn localbvn = new bvn();
    localbvn.topic = Util.nullAsNil(paramString1);
    localbvn.Auy = paramInt;
    localbvn.iconUrl = Util.nullAsNil(paramString2);
    localbvn.desc = Util.nullAsNil(paramString3);
    localbvn.aadd = Util.nullAsNil(paramString4);
    paramString2 = new bvi();
    if (paramboi == null)
    {
      paramString1 = null;
      paramString2.ZWG = paramString1;
      if (paramboi != null) {
        break label150;
      }
      f1 = 0.0F;
      label89:
      paramString2.longitude = f1;
      if (paramboi != null) {
        break label160;
      }
    }
    label150:
    label160:
    for (float f1 = f2;; f1 = paramboi.latitude)
    {
      paramString2.latitude = f1;
      paramString1 = ah.aiuX;
      localbvn.aadc = paramString2;
      if (paramatg != null) {
        localbvn.aade = paramatg;
      }
      AppMethodBeat.o(333944);
      return localbvn;
      paramString1 = paramboi.ZWG;
      break;
      f1 = paramboi.longitude;
      break label89;
    }
  }
  
  private static final ah a(LinkedList paramLinkedList, com.tencent.mm.am.b.a parama)
  {
    AppMethodBeat.i(334135);
    s.u(paramLinkedList, "$stats");
    if ((parama.errCode == 0) && (parama.errType == 0)) {
      Log.i(TAG, s.X("liveShareStatsReport successfully! size=", Integer.valueOf(paramLinkedList.size())));
    }
    for (;;)
    {
      paramLinkedList = ah.aiuX;
      AppMethodBeat.o(334135);
      return paramLinkedList;
      Log.w(TAG, s.X("liveShareStatsReport fail to report! size=", Integer.valueOf(paramLinkedList.size())));
    }
  }
  
  private static void a(Context paramContext, bth parambth, kotlin.g.a.b<? super List<String>, ah> paramb)
  {
    AppMethodBeat.i(333722);
    Log.i(TAG, s.X("continueShareProduct ", parambth.productId));
    com.tencent.mm.message.k.b localb = new com.tencent.mm.message.k.b();
    Object localObject = new com.tencent.mm.plugin.findersdk.a.h();
    ((com.tencent.mm.plugin.findersdk.a.h)localObject).b(parambth);
    localb.a((com.tencent.mm.message.f)localObject);
    localb.type = 82;
    localb.title = MMApplicationContext.getContext().getString(e.h.low_version_upgrade_tip);
    localb.url = MMApplicationContext.getContext().getString(e.h.low_version_upgrade_url);
    localObject = new Intent();
    ((Intent)localObject).putExtra("Retr_Msg_Type", 30);
    ((Intent)localObject).putExtra("Multi_Retr", true);
    ((Intent)localObject).putExtra("Retr_Msg_content", com.tencent.mm.message.k.b.a(localb, null, null));
    ((Intent)localObject).putExtra("Retr_go_to_chattingUI", false);
    ((Intent)localObject).putExtra("Retr_show_success_tips", true);
    if ((paramContext instanceof MMFragmentActivity))
    {
      com.tencent.mm.br.c.a((MMFragmentActivity)paramContext, ".ui.transmit.MsgRetransmitUI", (Intent)localObject, 1005, new an.a..ExternalSyntheticLambda8(parambth, paramb));
      AppMethodBeat.o(333722);
      return;
    }
    com.tencent.mm.br.c.g(paramContext, ".ui.transmit.MsgRetransmitUI", (Intent)localObject);
    AppMethodBeat.o(333722);
  }
  
  private static void a(AppCompatActivity paramAppCompatActivity, FinderItem paramFinderItem, Bundle paramBundle, int paramInt1, int paramInt2, kotlin.g.a.b<? super List<String>, ah> paramb)
  {
    AppMethodBeat.i(333697);
    Object localObject1 = av.GiL;
    if (!av.C(paramFinderItem.getFeedObject()))
    {
      paramFinderItem = av.GiL;
      paramFinderItem = (Context)paramAppCompatActivity;
      paramAppCompatActivity = paramAppCompatActivity.getString(e.h.finder_private_ban_share);
      s.s(paramAppCompatActivity, "context.getString(R.stri…finder_private_ban_share)");
      av.aO(paramFinderItem, paramAppCompatActivity);
      AppMethodBeat.o(333697);
      return;
    }
    Object localObject2 = TAG;
    StringBuilder localStringBuilder = new StringBuilder("share live（msgType:").append(paramInt1).append(",msgRetrType:").append(paramInt2).append(65289).append(paramFinderItem.getId()).append(' ');
    localObject1 = paramFinderItem.getFeedObject();
    label150:
    label192:
    boolean bool;
    if (localObject1 == null)
    {
      localObject1 = null;
      localStringBuilder = localStringBuilder.append(localObject1).append(" to conversation,liveId:");
      localObject1 = paramFinderItem.getLiveInfo();
      if (localObject1 != null) {
        break label538;
      }
      localObject1 = null;
      localStringBuilder = localStringBuilder.append(localObject1).append(",desc:").append(paramFinderItem.getDescription()).append(",liveStatus ");
      localObject1 = paramFinderItem.getLiveInfo();
      if (localObject1 != null) {
        break label551;
      }
      localObject1 = null;
      Log.i((String)localObject2, localObject1);
      localObject1 = new com.tencent.mm.message.k.b();
      localObject2 = new com.tencent.mm.plugin.findersdk.a.b();
      ((com.tencent.mm.plugin.findersdk.a.b)localObject2).b(paramFinderItem.getFinderLive());
      ((com.tencent.mm.message.k.b)localObject1).a((com.tencent.mm.message.f)localObject2);
      ((com.tencent.mm.message.k.b)localObject1).type = paramInt1;
      ((com.tencent.mm.message.k.b)localObject1).title = MMApplicationContext.getContext().getString(e.h.low_version_upgrade_tip);
      ((com.tencent.mm.message.k.b)localObject1).url = MMApplicationContext.getContext().getString(e.h.low_version_upgrade_url);
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("Retr_Msg_Type", paramInt2);
      ((Intent)localObject2).putExtra("Multi_Retr", true);
      ((Intent)localObject2).putExtra("Retr_Msg_content", com.tencent.mm.message.k.b.a((com.tencent.mm.message.k.b)localObject1, null, null));
      ((Intent)localObject2).putExtra("Retr_go_to_chattingUI", false);
      if (paramBundle != null) {
        break label564;
      }
      bool = true;
      label341:
      ((Intent)localObject2).putExtra("Retr_show_success_tips", bool);
      if (paramBundle != null) {
        break label577;
      }
      localObject1 = null;
      label359:
      ((Intent)localObject2).putExtra("Select_Conv_Type", (Serializable)localObject1);
      if (paramBundle != null) {
        break label592;
      }
      localObject1 = null;
      label380:
      ((Intent)localObject2).putExtra("search_range", (int[])localObject1);
      localObject1 = com.tencent.mm.plugin.secdata.ui.a.PlI;
      localObject1 = (emx)a.a.c((Context)paramAppCompatActivity, 14, emx.class);
      if (localObject1 != null)
      {
        ((emx)localObject1).scene = 8;
        ((emx)localObject1).lsO = 2;
        ((emx)localObject1).Qmp = ((int)(SystemClock.elapsedRealtime() - ((emx)localObject1).startTime));
        ((emx)localObject1).MFq = "0";
        ((emx)localObject1).abrg = "0";
        ((emx)localObject1).toUser = "";
        if (paramBundle != null) {
          break label604;
        }
      }
    }
    label538:
    label551:
    label564:
    label577:
    label592:
    label604:
    for (paramInt1 = 0;; paramInt1 = paramBundle.getInt("quick_share_item_count", 0))
    {
      ((emx)localObject1).abrf = paramInt1;
      paramBundle = com.tencent.mm.pluginsdk.j.a.XUW;
      com.tencent.mm.pluginsdk.j.a.ly((Context)paramAppCompatActivity);
      com.tencent.mm.br.c.a((MMFragmentActivity)paramAppCompatActivity, ".ui.transmit.MsgRetransmitUI", (Intent)localObject2, 1005, new an.a..ExternalSyntheticLambda7(paramFinderItem, paramb));
      AppMethodBeat.o(333697);
      return;
      localObject1 = Integer.valueOf(((FinderObject)localObject1).forward_style);
      break;
      localObject1 = Long.valueOf(((bip)localObject1).liveId);
      break label150;
      localObject1 = Integer.valueOf(((bip)localObject1).liveStatus);
      break label192;
      bool = paramBundle.getBoolean("Retr_show_success_tips", true);
      break label341;
      localObject1 = Integer.valueOf(paramBundle.getInt("Select_Conv_Type"));
      break label359;
      localObject1 = paramBundle.getIntArray("search_range");
      break label380;
    }
  }
  
  private static void a(AppCompatActivity paramAppCompatActivity, FinderItem paramFinderItem, Bundle paramBundle, kotlin.g.a.b<? super List<String>, ah> paramb)
  {
    AppMethodBeat.i(333673);
    a(paramAppCompatActivity, paramFinderItem, paramBundle, 88, 31, paramb);
    AppMethodBeat.o(333673);
  }
  
  public static void a(AppCompatActivity paramAppCompatActivity, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(333806);
    s.u(paramAppCompatActivity, "context");
    s.u(paramString2, "sourceName");
    s.u(paramString3, "localPicPath");
    ArrayList localArrayList = new ArrayList();
    Object localObject = new TextStatusJumpInfo();
    ((TextStatusJumpInfo)localObject).jumpType = "13";
    ah localah = ah.aiuX;
    localArrayList.add(localObject);
    localArrayList.add(com.tencent.mm.plugin.textstatus.a.a.hFn());
    localObject = new w.a();
    ((w.a)localObject).bdr("2022_hj");
    ((w.a)localObject).bdx(paramString2);
    ((w.a)localObject).bdu("olympic_winter_2022@inner");
    ((w.a)localObject).bdw(paramString1);
    ((w.a)localObject).ls((List)localArrayList);
    ((w.a)localObject).bdt(paramString3);
    ((com.tencent.mm.plugin.textstatus.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.textstatus.a.n.class)).a((Activity)paramAppCompatActivity, 1008, ((w.a)localObject).ThS);
    AppMethodBeat.o(333806);
  }
  
  private static final void a(m paramm, int paramInt1, int paramInt2, int paramInt3, Intent paramIntent)
  {
    AppMethodBeat.i(334099);
    s.u(paramm, "$contact");
    Object localObject;
    label109:
    String str;
    if (paramInt3 == -1)
    {
      if (paramIntent != null) {
        break label177;
      }
      paramIntent = null;
      localObject = paramIntent;
      if (paramIntent == null) {
        localObject = new ArrayList(0);
      }
      Log.i(TAG, "share namecard " + paramm.getNickname() + '(' + paramm.getUsername() + ") to " + localObject);
      if (((Collection)localObject).isEmpty()) {
        break label190;
      }
      paramInt2 = 1;
      if (paramInt2 != 0)
      {
        paramIntent = com.tencent.mm.plugin.finder.report.z.FrZ;
        paramIntent = paramm.getUsername();
        str = Util.listToString((List)localObject, ",");
        s.s(str, "listToString(toUsers, \",\")");
        paramm = paramm.field_authInfo;
        if (paramm != null) {
          break label195;
        }
      }
    }
    label177:
    label190:
    label195:
    for (paramInt2 = 0;; paramInt2 = paramm.authIconType)
    {
      com.tencent.mm.plugin.finder.report.z.l(paramIntent, str, paramInt2, paramInt1);
      aC((ArrayList)localObject);
      AppMethodBeat.o(334099);
      return;
      paramIntent = paramIntent.getStringArrayListExtra("SendMsgUsernames");
      break;
      paramInt2 = 0;
      break label109;
    }
  }
  
  private static final void a(FinderItem paramFinderItem, AppCompatActivity paramAppCompatActivity, ah.d paramd, bui parambui, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(334086);
    s.u(paramFinderItem, "$feedObject");
    s.u(paramAppCompatActivity, "$context");
    s.u(paramd, "$fullScreenShareType");
    s.u(parambui, "$contextObj");
    Object localObject = new ArrayList();
    if (paramInt2 == -1) {
      if (paramIntent == null)
      {
        localObject = null;
        paramIntent = (Intent)localObject;
        if (localObject == null) {
          paramIntent = new ArrayList(0);
        }
        Log.i(TAG, "share finderObject " + paramFinderItem.getId() + " to " + paramIntent);
        if (((Collection)paramIntent).isEmpty()) {
          break label287;
        }
        paramInt1 = 1;
        label129:
        if (paramInt1 != 0)
        {
          localObject = com.tencent.mm.ui.component.k.aeZF;
          paramAppCompatActivity = com.tencent.mm.ui.component.k.d(paramAppCompatActivity).q(as.class);
          s.s(paramAppCompatActivity, "UICProvider.of(context).…rReporterUIC::class.java)");
          paramAppCompatActivity = ((bn)paramAppCompatActivity).foy();
          if (paramAppCompatActivity != null) {
            paramAppCompatActivity.dYj().mU(paramFinderItem.getId());
          }
        }
        aC(paramIntent);
        paramAppCompatActivity = paramIntent;
        label192:
        if (paramInt2 != -1) {
          break label355;
        }
      }
    }
    label287:
    label355:
    for (long l1 = 1L;; l1 = 2L)
    {
      if (paramFinderItem.getFromType() != 32768) {
        break label363;
      }
      paramIntent = com.tencent.mm.plugin.finder.report.z.FrZ;
      paramFinderItem = new ca(paramFinderItem.getFeedObject());
      paramInt1 = paramd.aixb;
      paramd = Util.listToString((List)paramAppCompatActivity, ";");
      s.s(paramd, "listToString(toUsers, \";\")");
      com.tencent.mm.plugin.finder.report.z.a(paramFinderItem, paramInt1, l1, paramd, parambui, paramAppCompatActivity.size());
      AppMethodBeat.o(334086);
      return;
      localObject = paramIntent.getStringArrayListExtra("SendMsgUsernames");
      break;
      paramInt1 = 0;
      break label129;
      paramIntent = com.tencent.mm.ui.component.k.aeZF;
      paramAppCompatActivity = com.tencent.mm.ui.component.k.d(paramAppCompatActivity).q(as.class);
      s.s(paramAppCompatActivity, "UICProvider.of(context).…rReporterUIC::class.java)");
      paramIntent = ((bn)paramAppCompatActivity).foy();
      paramAppCompatActivity = (AppCompatActivity)localObject;
      if (paramIntent == null) {
        break label192;
      }
      paramIntent.dYj().mW(paramFinderItem.getId());
      paramAppCompatActivity = (AppCompatActivity)localObject;
      break label192;
    }
    label363:
    paramIntent = com.tencent.mm.plugin.finder.report.z.FrZ;
    long l2 = paramFinderItem.getId();
    paramInt1 = paramd.aixb;
    paramFinderItem = Util.listToString((List)paramAppCompatActivity, ";");
    s.s(paramFinderItem, "listToString(toUsers, \";\")");
    com.tencent.mm.plugin.finder.report.z.a(l2, paramInt1, l1, paramFinderItem, parambui, paramAppCompatActivity.size(), null, 64);
    AppMethodBeat.o(334086);
  }
  
  private static final void a(FinderItem paramFinderItem, kotlin.g.a.b paramb, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(334057);
    s.u(paramFinderItem, "$feedObject");
    Object localObject1 = new ArrayList();
    if (paramInt2 == -1)
    {
      if (paramIntent == null)
      {
        localObject1 = null;
        paramIntent = (Intent)localObject1;
        if (localObject1 == null) {
          paramIntent = new ArrayList(0);
        }
        Log.i(TAG, "share finderObject " + paramFinderItem.getId() + " to " + paramIntent);
        aC(paramIntent);
        if (((Collection)paramIntent).isEmpty()) {
          break label205;
        }
      }
      JSONObject localJSONObject;
      label205:
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        localObject1 = paramIntent;
        if (paramInt1 == 0) {
          break label327;
        }
        localJSONObject = new JSONObject();
        localObject2 = paramIntent.iterator();
        String str;
        for (localObject1 = ""; ((Iterator)localObject2).hasNext(); localObject1 = (String)localObject1 + str + ';') {
          str = (String)((Iterator)localObject2).next();
        }
        localObject1 = paramIntent.getStringArrayListExtra("SendMsgUsernames");
        break;
      }
      Object localObject2 = localObject1;
      if (kotlin.n.n.rs((String)localObject1, ";"))
      {
        paramInt1 = ((String)localObject1).length();
        if (localObject1 == null)
        {
          paramFinderItem = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(334057);
          throw paramFinderItem;
        }
        localObject2 = ((String)localObject1).substring(0, paramInt1 - 1);
        s.s(localObject2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      }
      localJSONObject.put("type", "1");
      localJSONObject.put("username", localObject2);
      ((ce)com.tencent.mm.kernel.h.ax(ce.class)).a(q.c.Drl, localJSONObject.toString());
      E(paramFinderItem);
      localObject1 = paramIntent;
    }
    for (;;)
    {
      label327:
      if (paramb != null) {
        paramb.invoke(localObject1);
      }
      AppMethodBeat.o(334057);
      return;
      paramFinderItem = new JSONObject();
      paramFinderItem.put("type", "3");
      ((ce)com.tencent.mm.kernel.h.ax(ce.class)).a(q.c.Drl, paramFinderItem.toString());
    }
  }
  
  private static final void a(com.tencent.mm.plugin.findersdk.a.d paramd, bui parambui, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(334118);
    s.u(paramd, "$objectContent");
    if (paramInt2 == -1)
    {
      Object localObject = paramIntent.getStringArrayListExtra("SendMsgUsernames");
      paramIntent = (Intent)localObject;
      if (localObject == null) {
        paramIntent = new ArrayList(0);
      }
      localObject = Util.listToString((List)paramIntent, ";");
      com.tencent.mm.plugin.finder.report.z localz = com.tencent.mm.plugin.finder.report.z.FrZ;
      long l = com.tencent.mm.ae.d.FK(paramd.oUa.cardId);
      s.s(localObject, "users");
      com.tencent.mm.plugin.finder.report.z.a(l, 3, 1L, (String)localObject, paramIntent.size(), parambui);
      Log.i(TAG, "[shareAlbumToChat] " + paramd.oUa.title + " to " + paramIntent);
      aC(paramIntent);
      AppMethodBeat.o(334118);
      return;
    }
    paramIntent = com.tencent.mm.plugin.finder.report.z.FrZ;
    com.tencent.mm.plugin.finder.report.z.a(com.tencent.mm.ae.d.FK(paramd.oUa.cardId), 3, 2L, "", 0L, parambui);
    AppMethodBeat.o(334118);
  }
  
  private static final void a(com.tencent.mm.plugin.findersdk.a.g paramg, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(334129);
    s.u(paramg, "$objectContent");
    new ArrayList();
    if (paramInt2 == -1) {
      if (paramIntent != null) {
        break label98;
      }
    }
    label98:
    for (paramIntent = null;; paramIntent = paramIntent.getStringArrayListExtra("SendMsgUsernames"))
    {
      Object localObject = paramIntent;
      if (paramIntent == null) {
        localObject = new ArrayList(0);
      }
      Log.i(TAG, "share poi " + paramg.oUd + " to " + localObject);
      aC((ArrayList)localObject);
      AppMethodBeat.o(334129);
      return;
    }
  }
  
  private static final void a(final bth parambth, Context paramContext, final kotlin.g.a.b paramb, WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(334063);
    s.u(parambth, "$shareObject");
    s.u(paramContext, "$context");
    Object localObject;
    if (paramWxaAttributes == null)
    {
      localObject = "";
      parambth.aabl = ((String)localObject);
      if (paramWxaAttributes != null) {
        break label133;
      }
      paramWxaAttributes = "";
    }
    for (;;)
    {
      parambth.ESn = paramWxaAttributes;
      Log.i(TAG, "fix shareObject, after: " + parambth.ESn + ", " + parambth.aabl);
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c(paramContext, parambth, paramb));
      AppMethodBeat.o(334063);
      return;
      String str = paramWxaAttributes.field_bigHeadURL;
      localObject = str;
      if (str != null) {
        break;
      }
      localObject = "";
      break;
      label133:
      localObject = paramWxaAttributes.field_nickname;
      paramWxaAttributes = (WxaAttributes)localObject;
      if (localObject == null) {
        paramWxaAttributes = "";
      }
    }
  }
  
  private static final void a(bth parambth, kotlin.g.a.b paramb, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(334069);
    s.u(parambth, "$shareObject");
    Object localObject;
    if (paramIntent == null)
    {
      paramIntent = null;
      localObject = paramIntent;
      if (paramIntent == null) {
        localObject = new ArrayList(0);
      }
      if (paramInt2 != -1) {
        break label115;
      }
      Log.i(TAG, "share finderObject " + parambth.productId + " to " + localObject);
    }
    for (;;)
    {
      if (paramb != null) {
        paramb.invoke(localObject);
      }
      AppMethodBeat.o(334069);
      return;
      paramIntent = paramIntent.getStringArrayListExtra("SendMsgUsernames");
      break;
      label115:
      Log.i(TAG, "share finderObject " + parambth.productId + " cancel");
    }
  }
  
  public static void a(MMActivity paramMMActivity, com.tencent.mm.modelsns.c paramc, bui parambui)
  {
    AppMethodBeat.i(333984);
    s.u(paramMMActivity, "context");
    s.u(paramc, "snsShare");
    Object localObject = com.tencent.mm.plugin.findersdk.d.a.Hdr;
    if (com.tencent.mm.plugin.findersdk.d.a.aDj("share"))
    {
      AppMethodBeat.o(333984);
      return;
    }
    Log.i(TAG, s.X("[shareAlbumToSnsTimeLine] share album to sns. ", paramc.oUa.title));
    localObject = new Intent();
    ((Intent)localObject).putExtra("ksnsupload_finder_album_xml", q.a(paramc.oUa));
    ((Intent)localObject).putExtra("Ksnsupload_type", 20);
    ((Intent)localObject).putExtra("need_result", true);
    com.tencent.mm.br.c.a(paramMMActivity, ".plugin.sns.ui.SnsUploadUI", (Intent)localObject, 1002, new an.a..ExternalSyntheticLambda4(paramMMActivity, paramc, parambui));
    AppMethodBeat.o(333984);
  }
  
  private static final void a(MMActivity paramMMActivity, com.tencent.mm.modelsns.c paramc, bui parambui, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(334126);
    s.u(paramMMActivity, "$context");
    s.u(paramc, "$snsShare");
    if (paramInt2 == -1)
    {
      Object localObject = paramIntent.getStringArrayListExtra("SendMsgUsernames");
      paramIntent = (Intent)localObject;
      if (localObject == null) {
        paramIntent = new ArrayList(0);
      }
      localObject = Util.listToString((List)paramIntent, ";");
      com.tencent.mm.ui.base.k.cZ((Context)paramMMActivity, paramMMActivity.getString(e.h.app_shared));
      paramMMActivity = com.tencent.mm.plugin.finder.report.z.FrZ;
      long l = com.tencent.mm.ae.d.FK(paramc.oUa.cardId);
      s.s(localObject, "users");
      com.tencent.mm.plugin.finder.report.z.a(l, 2, 1L, (String)localObject, paramIntent.size(), parambui);
      Log.i(TAG, "[shareAlbumToSnsTimeLine] " + paramc.oUa.title + " to " + paramIntent);
      AppMethodBeat.o(334126);
      return;
    }
    paramMMActivity = com.tencent.mm.plugin.finder.report.z.FrZ;
    com.tencent.mm.plugin.finder.report.z.a(com.tencent.mm.ae.d.FK(paramc.oUa.cardId), 2, 2L, "", 0L, parambui);
    AppMethodBeat.o(334126);
  }
  
  public static void a(MMActivity paramMMActivity, com.tencent.mm.plugin.findersdk.a.d paramd, bui parambui)
  {
    AppMethodBeat.i(333976);
    s.u(paramMMActivity, "context");
    s.u(paramd, "objectContent");
    Object localObject = com.tencent.mm.plugin.findersdk.d.a.Hdr;
    if (com.tencent.mm.plugin.findersdk.d.a.aDj("share"))
    {
      AppMethodBeat.o(333976);
      return;
    }
    localObject = new com.tencent.mm.message.k.b();
    ((com.tencent.mm.message.k.b)localObject).a((com.tencent.mm.message.f)paramd);
    ((com.tencent.mm.message.k.b)localObject).type = 73;
    ((com.tencent.mm.message.k.b)localObject).title = MMApplicationContext.getContext().getString(e.h.low_version_upgrade_tip);
    ((com.tencent.mm.message.k.b)localObject).url = MMApplicationContext.getContext().getString(e.h.low_version_upgrade_url);
    Intent localIntent = new Intent();
    localIntent.putExtra("Retr_Msg_Type", 22);
    localIntent.putExtra("Multi_Retr", true);
    localIntent.putExtra("Retr_Msg_content", com.tencent.mm.message.k.b.a((com.tencent.mm.message.k.b)localObject, null, null));
    localIntent.putExtra("Retr_go_to_chattingUI", false);
    localIntent.putExtra("Retr_show_success_tips", true);
    com.tencent.mm.br.c.a(paramMMActivity, ".ui.transmit.MsgRetransmitUI", localIntent, 1001, new an.a..ExternalSyntheticLambda2(paramd, parambui));
    AppMethodBeat.o(333976);
  }
  
  public static void a(MMActivity paramMMActivity, fei paramfei, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(333996);
    s.u(paramMMActivity, "context");
    s.u(paramfei, "location");
    s.u(paramString1, "poiCategories");
    Object localObject = com.tencent.mm.plugin.findersdk.d.a.Hdr;
    if (com.tencent.mm.plugin.findersdk.d.a.aDj("share"))
    {
      AppMethodBeat.o(333996);
      return;
    }
    localObject = new com.tencent.mm.message.k.b();
    com.tencent.mm.plugin.findersdk.a.g localg = new com.tencent.mm.plugin.findersdk.a.g();
    paramfei = a(paramfei, paramString1, paramString2, paramString3, paramInt);
    s.u(paramfei, "<set-?>");
    localg.oUd = paramfei;
    ((com.tencent.mm.message.k.b)localObject).a((com.tencent.mm.message.f)localg);
    ((com.tencent.mm.message.k.b)localObject).type = 75;
    ((com.tencent.mm.message.k.b)localObject).nUa = 2;
    ((com.tencent.mm.message.k.b)localObject).title = MMApplicationContext.getContext().getString(e.h.low_version_upgrade_tip);
    ((com.tencent.mm.message.k.b)localObject).url = MMApplicationContext.getContext().getString(e.h.low_version_upgrade_url);
    paramfei = new Intent();
    paramfei.putExtra("Retr_Msg_Type", 28);
    paramfei.putExtra("Multi_Retr", true);
    paramfei.putExtra("Retr_Msg_content", com.tencent.mm.message.k.b.a((com.tencent.mm.message.k.b)localObject, null, null));
    paramfei.putExtra("Retr_go_to_chattingUI", false);
    paramfei.putExtra("Retr_show_success_tips", true);
    com.tencent.mm.br.c.a(paramMMActivity, ".ui.transmit.MsgRetransmitUI", paramfei, 1001, new an.a..ExternalSyntheticLambda3(localg));
    AppMethodBeat.o(333996);
  }
  
  public static void a(MMActivity paramMMActivity, String paramString1, int paramInt1, long paramLong, String paramString2, String paramString3, boi paramboi, int paramInt2, String paramString4, atg paramatg)
  {
    AppMethodBeat.i(333914);
    s.u(paramMMActivity, "context");
    Object localObject1 = com.tencent.mm.plugin.findersdk.d.a.Hdr;
    if (com.tencent.mm.plugin.findersdk.d.a.aDj("share"))
    {
      AppMethodBeat.o(333914);
      return;
    }
    localObject1 = new com.tencent.mm.message.k.b();
    Object localObject2;
    int i;
    if (paramInt1 != 7)
    {
      localObject2 = new i();
      paramString2 = a(paramString1, paramInt1, paramString2, paramString3, paramboi, paramString4, null);
      s.u(paramString2, "<set-?>");
      ((i)localObject2).oTZ = paramString2;
      paramString2 = (com.tencent.mm.message.f)localObject2;
      ((com.tencent.mm.message.k.b)localObject1).a(paramString2);
      switch (paramInt1)
      {
      case 5: 
      case 6: 
      default: 
        i = 59;
        label140:
        ((com.tencent.mm.message.k.b)localObject1).type = i;
        ((com.tencent.mm.message.k.b)localObject1).title = MMApplicationContext.getContext().getString(e.h.low_version_upgrade_tip);
        ((com.tencent.mm.message.k.b)localObject1).url = MMApplicationContext.getContext().getString(e.h.low_version_upgrade_url);
        paramString2 = new Intent();
        switch (paramInt1)
        {
        case 5: 
        case 6: 
        default: 
          i = 21;
        }
        break;
      }
    }
    for (;;)
    {
      paramString2.putExtra("Retr_Msg_Type", i);
      paramString2.putExtra("Multi_Retr", true);
      paramString2.putExtra("Retr_Msg_content", com.tencent.mm.message.k.b.a((com.tencent.mm.message.k.b)localObject1, null, null));
      paramString2.putExtra("Retr_go_to_chattingUI", false);
      paramString2.putExtra("Retr_show_success_tips", true);
      com.tencent.mm.br.c.a(paramMMActivity, ".ui.transmit.MsgRetransmitUI", paramString2, 1001, new an.a..ExternalSyntheticLambda5(paramString1, paramInt1, paramLong, paramatg, paramMMActivity, paramInt2));
      AppMethodBeat.o(333914);
      return;
      ((com.tencent.mm.message.k.b)localObject1).nUa = 3;
      localObject2 = new com.tencent.mm.plugin.findersdk.a.c();
      paramString2 = a(paramString1, paramInt1, paramString2, paramString3, paramboi, paramString4, paramatg);
      s.u(paramString2, "<set-?>");
      ((com.tencent.mm.plugin.findersdk.a.c)localObject2).oTZ = paramString2;
      paramString2 = (com.tencent.mm.message.f)localObject2;
      break;
      i = 72;
      break label140;
      i = 75;
      break label140;
      i = 25;
      continue;
      i = 27;
    }
  }
  
  private static void a(MMFragmentActivity paramMMFragmentActivity, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(333787);
    Object localObject1 = av.GiL;
    if (!av.B(paramBaseFinderFeed.feedObject.getFeedObject()))
    {
      paramBaseFinderFeed = av.GiL;
      paramBaseFinderFeed = (Context)paramMMFragmentActivity;
      paramMMFragmentActivity = paramMMFragmentActivity.getString(e.h.finder_private_ban_share);
      s.s(paramMMFragmentActivity, "context.getString(R.stri…finder_private_ban_share)");
      av.aO(paramBaseFinderFeed, paramMMFragmentActivity);
      AppMethodBeat.o(333787);
      return;
    }
    if (paramBaseFinderFeed.feedObject.isPrivate())
    {
      aa.a((Context)paramMMFragmentActivity, paramMMFragmentActivity.getString(e.h.finder_private_feed_share_click_toast), an.a..ExternalSyntheticLambda10.INSTANCE);
      AppMethodBeat.o(333787);
      return;
    }
    com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1278L, 12L, 1L, false);
    localObject1 = com.tencent.mm.plugin.findersdk.d.a.Hdr;
    if (com.tencent.mm.plugin.findersdk.d.a.aDj("share"))
    {
      AppMethodBeat.o(333787);
      return;
    }
    Object localObject2 = TAG;
    Object localObject3 = new StringBuilder("share finderObject ").append(paramBaseFinderFeed.feedObject.getId()).append(' ');
    localObject1 = paramBaseFinderFeed.feedObject.getFeedObject();
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = Integer.valueOf(((FinderObject)localObject1).forward_style))
    {
      Log.i((String)localObject2, localObject1 + " to sns, pflag:" + paramBaseFinderFeed.feedObject.getFeedObject().permissionFlag);
      localObject1 = com.tencent.mm.ui.component.k.aeZF;
      localObject1 = ((as)com.tencent.mm.ui.component.k.d((AppCompatActivity)paramMMFragmentActivity).q(as.class)).fou();
      localObject2 = new Intent();
      localObject3 = new e();
      ((e)localObject3).oUc = d(paramBaseFinderFeed.feedObject, true);
      ((Intent)localObject2).putExtra("ksnsupload_finder_object_xml", q.d(((e)localObject3).oUc));
      ((Intent)localObject2).putExtra("Ksnsupload_type", 17);
      ((Intent)localObject2).putExtra("need_result", true);
      ((Intent)localObject2).putExtra("finder_post_from_sns_type", paramInt2);
      if (paramInt1 == 5)
      {
        ((Intent)localObject2).putExtra("finder_feed_id", paramBaseFinderFeed.feedObject.getId());
        ((Intent)localObject2).putExtra("ksnsupload_finder_need_report", true);
        localObject3 = ag.Ftp;
        ((bui)localObject1).sessionId = ag.eNy();
      }
      com.tencent.mm.br.c.a(paramMMFragmentActivity, ".plugin.sns.ui.SnsUploadUI", (Intent)localObject2, 1002, (MMFragmentActivity.c)new an.a.d(paramMMFragmentActivity, paramBaseFinderFeed, paramInt1, (bui)localObject1));
      AppMethodBeat.o(333787);
      return;
    }
  }
  
  private static final void a(String paramString, int paramInt1, long paramLong, atg paramatg, MMActivity paramMMActivity, int paramInt2, int paramInt3, int paramInt4, Intent paramIntent)
  {
    AppMethodBeat.i(334109);
    s.u(paramMMActivity, "$context");
    Object localObject = new ArrayList();
    if (paramInt4 == -1)
    {
      if (paramIntent == null)
      {
        paramIntent = null;
        localObject = paramIntent;
        if (paramIntent == null) {
          localObject = new ArrayList(0);
        }
        Log.i(TAG, "share topic " + paramString + " to " + localObject);
        aC((ArrayList)localObject);
      }
    }
    else
    {
      if (paramInt1 != 7) {
        break label212;
      }
      paramString = com.tencent.mm.plugin.finder.report.z.FrZ;
      if (paramInt4 != -1) {
        break label197;
      }
      bool = true;
      label114:
      paramIntent = Util.listToString((List)localObject, ",");
      s.s(paramIntent, "listToString(toUsers, \",\")");
      if (paramatg != null) {
        break label203;
      }
    }
    label197:
    label203:
    for (paramString = null;; paramString = paramatg.ZDJ)
    {
      paramatg = com.tencent.mm.ui.component.k.aeZF;
      com.tencent.mm.plugin.finder.report.z.a(1, bool, paramIntent, paramLong, paramString, ((as)com.tencent.mm.ui.component.k.d((AppCompatActivity)paramMMActivity).q(as.class)).fou());
      AppMethodBeat.o(334109);
      return;
      paramIntent = paramIntent.getStringArrayListExtra("SendMsgUsernames");
      break;
      bool = false;
      break label114;
    }
    label212:
    paramatg = com.tencent.mm.plugin.finder.report.z.FrZ;
    if (paramInt4 == -1) {}
    for (boolean bool = true;; bool = false)
    {
      paramString = Util.nullAsNil(paramString);
      s.s(paramString, "nullAsNil(topic)");
      paramatg = Util.listToString((List)localObject, ",");
      s.s(paramatg, "listToString(toUsers, \",\")");
      com.tencent.mm.plugin.finder.report.z.a(1, bool, paramString, paramInt1, paramLong, paramatg);
      AppMethodBeat.o(334109);
      return;
    }
  }
  
  public static void aC(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(333655);
    s.u(paramArrayList, "userNames");
    com.tencent.mm.storage.c.b localb = ((PluginMessengerFoundation)com.tencent.mm.kernel.h.az(PluginMessengerFoundation.class)).getRecentForwardInfoStorage();
    Object localObject1 = (List)paramArrayList;
    int i;
    if (localObject1 == null)
    {
      paramArrayList = null;
      Log.i("MicroMsg.RecentForwardInfoStorage", s.X("updateForwardInfo :", paramArrayList));
      if (localObject1 == null) {
        break label193;
      }
      if (((Collection)localObject1).isEmpty()) {
        break label188;
      }
      i = 1;
      label68:
      if (i != 1) {
        break label193;
      }
      i = 1;
    }
    label188:
    label193:
    for (;;)
    {
      label75:
      if (i != 0)
      {
        paramArrayList = localb.jdR();
        Object localObject2 = paramArrayList.ZDA;
        s.s(localObject2, "list.info_list");
        Object localObject3 = (Iterable)localObject2;
        localObject2 = (Collection)new ArrayList();
        localObject3 = ((Iterable)localObject3).iterator();
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            Object localObject4 = ((Iterator)localObject3).next();
            if (!((List)localObject1).contains(((ck)localObject4).userName))
            {
              ((Collection)localObject2).add(localObject4);
              continue;
              paramArrayList = Integer.valueOf(((List)localObject1).size());
              break;
              i = 0;
              break label68;
              i = 0;
              break label75;
            }
          }
        }
        paramArrayList.ZDA = new LinkedList((Collection)localObject2);
        localb.admV = paramArrayList;
        paramArrayList = new LinkedList();
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (String)((Iterator)localObject1).next();
          localObject2 = new ck();
          ((ck)localObject2).adlo = cn.bDw();
          ((ck)localObject2).userName = ((String)localObject3);
          ((ck)localObject2).adlp = com.tencent.mm.storage.c.b.a.bzr((String)localObject3);
          localObject3 = ah.aiuX;
          paramArrayList.add(localObject2);
        }
        localb.ni((List)paramArrayList);
      }
    }
    AppMethodBeat.o(333655);
  }
  
  public static dn b(bvl parambvl)
  {
    AppMethodBeat.i(333876);
    s.u(parambvl, "finderShareObject");
    dn localdn = new dn();
    arv localarv = new arv();
    asb localasb = new asb();
    localasb.bto(com.tencent.mm.model.z.bAM());
    localasb.btt(parambvl.objectId);
    localasb.yu(Util.nowMilliSecond());
    localarv.a(localasb);
    localarv.h(parambvl);
    localdn.hDr.title = "";
    localdn.hDr.hDt = localarv;
    localdn.hDr.type = 20;
    AppMethodBeat.o(333876);
    return localdn;
  }
  
  public static TextStatusJumpInfo b(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(333842);
    s.u(paramFinderObject, "finderObject");
    TextStatusJumpInfo localTextStatusJumpInfo = new TextStatusJumpInfo();
    localTextStatusJumpInfo.jumpType = "5";
    Object localObject = paramFinderObject.objectDesc;
    if (localObject != null)
    {
      localObject = ((FinderObjectDesc)localObject).description;
      if (localObject != null)
      {
        FinderObjectDesc localFinderObjectDesc = paramFinderObject.objectDesc;
        if (localFinderObjectDesc != null)
        {
          com.tencent.mm.plugin.finder.search.k localk = com.tencent.mm.plugin.finder.search.k.FxZ;
          localFinderObjectDesc.description = com.tencent.mm.plugin.finder.search.k.Sp((String)localObject);
        }
      }
    }
    localObject = paramFinderObject.toByteArray();
    localTextStatusJumpInfo.busiBuf = Base64.encodeToString((byte[])localObject, 0, localObject.length, 0);
    localObject = new com.tencent.mm.plugin.textstatus.proto.av();
    ((com.tencent.mm.plugin.textstatus.proto.av)localObject).Tqa = paramFinderObject.id;
    ((com.tencent.mm.plugin.textstatus.proto.av)localObject).mdD = paramFinderObject.objectNonceId;
    paramFinderObject = ((com.tencent.mm.plugin.textstatus.proto.av)localObject).toByteArray();
    localTextStatusJumpInfo.keyBusiBuf = Base64.encodeToString(paramFinderObject, 0, paramFinderObject.length, 2);
    AppMethodBeat.o(333842);
    return localTextStatusJumpInfo;
  }
  
  public static bvh b(bwa parambwa)
  {
    AppMethodBeat.i(333964);
    s.u(parambwa, "card");
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    Object localObject = parambwa.object;
    s.s(localObject, "card.`object`");
    localObject = (Iterable)localObject;
    int i = 0;
    Iterator localIterator = ((Iterable)localObject).iterator();
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (i < 0) {
        p.kkW();
      }
      localObject = (FinderObject)localObject;
      if (i < 4)
      {
        localObject = ((FinderObject)localObject).objectDesc;
        if (localObject != null) {
          break label148;
        }
        localObject = null;
      }
      for (;;)
      {
        if (localObject != null)
        {
          String str = ((FinderMedia)localObject).thumbUrl;
          if (str != null) {
            localLinkedList1.add(str);
          }
          localObject = ((FinderMedia)localObject).thumb_url_token;
          if (localObject != null) {
            localLinkedList2.add(localObject);
          }
        }
        i += 1;
        break;
        label148:
        localObject = ((FinderObjectDesc)localObject).media;
        if (localObject == null) {
          localObject = null;
        } else {
          localObject = (FinderMedia)((LinkedList)localObject).getFirst();
        }
      }
    }
    parambwa = a(com.tencent.mm.ae.d.hF(parambwa.id), parambwa.Wqu, parambwa.aadS, (List)localLinkedList1, (List)localLinkedList2, parambwa.AEA);
    AppMethodBeat.o(333964);
    return parambwa;
  }
  
  private static void b(AppCompatActivity paramAppCompatActivity, BaseFinderFeed paramBaseFinderFeed, Bundle paramBundle)
  {
    AppMethodBeat.i(333817);
    s.u(paramAppCompatActivity, "context");
    s.u(paramBaseFinderFeed, "feed");
    Object localObject1 = av.GiL;
    if (av.C(paramBaseFinderFeed.feedObject.getFeedObject()))
    {
      localObject1 = av.GiL;
      if (av.B(paramBaseFinderFeed.feedObject.getFeedObject())) {}
    }
    else
    {
      paramBaseFinderFeed = av.GiL;
      paramBaseFinderFeed = (Context)paramAppCompatActivity;
      paramAppCompatActivity = paramAppCompatActivity.getString(e.h.finder_private_ban_share);
      s.s(paramAppCompatActivity, "context.getString(R.stri…finder_private_ban_share)");
      av.aO(paramBaseFinderFeed, paramAppCompatActivity);
      AppMethodBeat.o(333817);
      return;
    }
    Object localObject2 = TAG;
    Object localObject3 = new StringBuilder("share finderObject ").append(paramBaseFinderFeed.feedObject.getId()).append(' ');
    localObject1 = paramBaseFinderFeed.feedObject.getFeedObject();
    label173:
    label221:
    int i;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject3 = ((StringBuilder)localObject3).append(localObject1).append(" to status,liveId:");
      localObject1 = paramBaseFinderFeed.feedObject.getLiveInfo();
      if (localObject1 != null) {
        break label500;
      }
      localObject1 = null;
      localObject3 = ((StringBuilder)localObject3).append(localObject1).append(",desc:").append(paramBaseFinderFeed.feedObject.getDescription()).append(",liveStatus:");
      localObject1 = paramBaseFinderFeed.feedObject.getLiveInfo();
      if (localObject1 != null) {
        break label513;
      }
      localObject1 = null;
      Log.i((String)localObject2, localObject1);
      localObject1 = new com.tencent.mm.modelsns.d();
      ((com.tencent.mm.modelsns.d)localObject1).a(paramBaseFinderFeed.feedObject.getFinderLive());
      if (paramBundle != null) {
        break label526;
      }
      paramBundle = null;
      label263:
      localObject2 = new ArrayList();
      localObject3 = new TextStatusJumpInfo();
      ((TextStatusJumpInfo)localObject3).jumpType = "2";
      ((TextStatusJumpInfo)localObject3).busiBuf = ((com.tencent.mm.modelsns.d)localObject1).bMC();
      Object localObject4 = ah.aiuX;
      ((ArrayList)localObject2).add(localObject3);
      localObject3 = new w.a();
      localObject4 = (CharSequence)paramBaseFinderFeed.feedObject.getFeedObject().wx_status_icon_id;
      if ((localObject4 != null) && (((CharSequence)localObject4).length() != 0)) {
        break label537;
      }
      i = 1;
      label353:
      if (i == 0) {
        break label542;
      }
      ((w.a)localObject3).bdr("1020");
    }
    for (;;)
    {
      ((w.a)localObject3).bdx(paramAppCompatActivity.getResources().getString(e.h.finder_live_feed_of_user, new Object[] { ((com.tencent.mm.modelsns.d)localObject1).oUb.nickName }));
      ((w.a)localObject3).bdu("live_player@inner");
      localObject1 = ((com.tencent.mm.modelsns.d)localObject1).oUb.liveId;
      paramBaseFinderFeed = (BaseFinderFeed)localObject1;
      if (localObject1 == null) {
        paramBaseFinderFeed = "";
      }
      ((w.a)localObject3).bdv(paramBaseFinderFeed);
      ((w.a)localObject3).bdw(paramBundle);
      ((w.a)localObject3).ls((List)localObject2);
      ((com.tencent.mm.plugin.textstatus.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.textstatus.a.n.class)).a((Activity)paramAppCompatActivity, 1008, ((w.a)localObject3).ThS);
      AppMethodBeat.o(333817);
      return;
      localObject1 = Integer.valueOf(((FinderObject)localObject1).forward_style);
      break;
      label500:
      localObject1 = Long.valueOf(((bip)localObject1).liveId);
      break label173;
      label513:
      localObject1 = Integer.valueOf(((bip)localObject1).liveStatus);
      break label221;
      label526:
      paramBundle = paramBundle.getString("FINDER_LIVE_SHARE_KEY_STATUS_VERIFY");
      break label263;
      label537:
      i = 0;
      break label353;
      label542:
      ((w.a)localObject3).bdr(paramBaseFinderFeed.feedObject.getFeedObject().wx_status_icon_id);
    }
  }
  
  private static void b(AppCompatActivity paramAppCompatActivity, BaseFinderFeed paramBaseFinderFeed, Bundle paramBundle, int paramInt)
  {
    com.tencent.mm.modelsns.d locald = null;
    AppMethodBeat.i(370236);
    Object localObject = av.GiL;
    if (!av.B(paramBaseFinderFeed.feedObject.getFeedObject()))
    {
      paramBaseFinderFeed = av.GiL;
      paramBaseFinderFeed = (Context)paramAppCompatActivity;
      paramAppCompatActivity = paramAppCompatActivity.getString(e.h.finder_private_ban_share);
      s.s(paramAppCompatActivity, "context.getString(R.stri…finder_private_ban_share)");
      av.aO(paramBaseFinderFeed, paramAppCompatActivity);
      AppMethodBeat.o(370236);
      return;
    }
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder("share finderObject snsType:").append(paramInt).append(", ").append(paramBaseFinderFeed.feedObject.getId()).append(' ');
    localObject = paramBaseFinderFeed.feedObject.getFeedObject();
    if (localObject == null)
    {
      localObject = null;
      localStringBuilder = localStringBuilder.append(localObject).append(" to sns,liveId:");
      localObject = paramBaseFinderFeed.feedObject.getLiveInfo();
      if (localObject != null) {
        break label402;
      }
      localObject = null;
      label154:
      localStringBuilder = localStringBuilder.append(localObject).append(",desc:").append(paramBaseFinderFeed.feedObject.getDescription()).append(",liveStatus:");
      localObject = paramBaseFinderFeed.feedObject.getLiveInfo();
      if (localObject != null) {
        break label415;
      }
      localObject = locald;
      label203:
      Log.i(str, localObject);
      localObject = new Intent();
      locald = new com.tencent.mm.modelsns.d();
      locald.a(paramBaseFinderFeed.feedObject.getFinderLive());
      ((Intent)localObject).putExtra("ksnsupload_finder_live_xml", locald.bMC());
      ((Intent)localObject).putExtra("Ksnsupload_type", paramInt);
      ((Intent)localObject).putExtra("need_result", true);
      if (paramBundle != null) {
        break label428;
      }
    }
    label402:
    label415:
    label428:
    for (paramInt = 0;; paramInt = paramBundle.getInt("FinderLiveShareExtraScene"))
    {
      if (paramInt == 1)
      {
        ((Intent)localObject).putExtra("KSnsPostManu", true);
        ((Intent)localObject).putExtra("KTouchCameraTime", Util.nowSecond());
        ((Intent)localObject).putExtra("sns_comment_type", 1);
        ((Intent)localObject).putExtra("Ksnsupload_type", 0);
        ((Intent)localObject).putExtra("is_tiger2022", true);
        ((Intent)localObject).putExtra("is_from_tiger2022_live", true);
      }
      com.tencent.mm.br.c.a((MMFragmentActivity)paramAppCompatActivity, ".plugin.sns.ui.SnsUploadUI", (Intent)localObject, 1006, (MMFragmentActivity.c)new an.a.a(paramAppCompatActivity, paramBaseFinderFeed));
      AppMethodBeat.o(370236);
      return;
      localObject = Integer.valueOf(((FinderObject)localObject).forward_style);
      break;
      localObject = Long.valueOf(((bip)localObject).liveId);
      break label154;
      localObject = Integer.valueOf(((bip)localObject).liveStatus);
      break label203;
    }
  }
  
  private static void b(AppCompatActivity paramAppCompatActivity, FinderItem paramFinderItem, Bundle paramBundle, kotlin.g.a.b<? super List<String>, ah> paramb)
  {
    AppMethodBeat.i(333678);
    a(paramAppCompatActivity, paramFinderItem, paramBundle, 63, 23, paramb);
    AppMethodBeat.o(333678);
  }
  
  public static void b(MMActivity paramMMActivity, fei paramfei, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(334006);
    s.u(paramMMActivity, "context");
    s.u(paramfei, "location");
    s.u(paramString1, "poiCategories");
    Object localObject = com.tencent.mm.plugin.findersdk.d.a.Hdr;
    if (com.tencent.mm.plugin.findersdk.d.a.aDj("share"))
    {
      AppMethodBeat.o(334006);
      return;
    }
    localObject = new Intent();
    com.tencent.mm.modelsns.f localf = new com.tencent.mm.modelsns.f();
    localf.oUd = a(paramfei, paramString1, paramString2, paramString3, paramInt);
    ((Intent)localObject).putExtra("ksnsupload_finder_poi_xml", localf.bMC());
    ((Intent)localObject).putExtra("Ksnsupload_type", 29);
    ((Intent)localObject).putExtra("need_result", true);
    com.tencent.mm.br.c.a(paramMMActivity, ".plugin.sns.ui.SnsUploadUI", (Intent)localObject, 1002, (MMActivity.a)new an.a.b(paramMMActivity));
    AppMethodBeat.o(334006);
  }
  
  public static void b(MMActivity paramMMActivity, final String paramString1, final int paramInt1, final long paramLong, String paramString2, String paramString3, boi paramboi, final int paramInt2, String paramString4, atg paramatg)
  {
    AppMethodBeat.i(333930);
    s.u(paramMMActivity, "context");
    Object localObject1 = com.tencent.mm.plugin.findersdk.d.a.Hdr;
    if (com.tencent.mm.plugin.findersdk.d.a.aDj("share"))
    {
      AppMethodBeat.o(333930);
      return;
    }
    Log.i(TAG, "share topic " + paramString1 + " to sns");
    localObject1 = new Intent();
    Object localObject2;
    int i;
    if (paramInt1 == 7)
    {
      localObject2 = new com.tencent.mm.modelsns.b();
      ((com.tencent.mm.modelsns.b)localObject2).oTZ = a(paramString1, paramInt1, paramString2, paramString3, paramboi, paramString4, paramatg);
      paramString2 = (com.tencent.mm.modelsns.k)localObject2;
      switch (paramInt1)
      {
      case 5: 
      case 6: 
      default: 
        i = 18;
        label148:
        if (paramInt1 == 7) {
          ((Intent)localObject1).putExtra("ksnsupload_finder_activity_xml", paramString2.bMC());
        }
        break;
      }
    }
    for (;;)
    {
      ((Intent)localObject1).putExtra("Ksnsupload_type", i);
      ((Intent)localObject1).putExtra("need_result", true);
      com.tencent.mm.br.c.a(paramMMActivity, ".plugin.sns.ui.SnsUploadUI", (Intent)localObject1, 1002, (MMActivity.a)new e(paramMMActivity, paramInt1, paramLong, paramatg, paramString1, paramInt2));
      AppMethodBeat.o(333930);
      return;
      localObject2 = new com.tencent.mm.modelsns.g();
      ((com.tencent.mm.modelsns.g)localObject2).oTZ = a(paramString1, paramInt1, paramString2, paramString3, paramboi, paramString4, paramatg);
      paramString2 = (com.tencent.mm.modelsns.k)localObject2;
      break;
      i = 22;
      break label148;
      i = 24;
      break label148;
      ((Intent)localObject1).putExtra("ksnsupload_finder_topic_xml", paramString2.bMC());
    }
  }
  
  private static void bi(LinkedList<fhp> paramLinkedList)
  {
    AppMethodBeat.i(334049);
    List localList = (List)paramLinkedList;
    bui localbui = new bui();
    localbui.AJo = 65;
    ah localah = ah.aiuX;
    new ap(localList, localbui).bFJ().j(new an.a..ExternalSyntheticLambda11(paramLinkedList));
    AppMethodBeat.o(334049);
  }
  
  private static void c(AppCompatActivity paramAppCompatActivity, BaseFinderFeed paramBaseFinderFeed, Bundle paramBundle)
  {
    AppMethodBeat.i(370234);
    b(paramAppCompatActivity, paramBaseFinderFeed, paramBundle, 30);
    AppMethodBeat.o(370234);
  }
  
  public static bvl d(FinderItem paramFinderItem, boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(333899);
    s.u(paramFinderItem, "feedObject");
    Object localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
    int i = ((Number)com.tencent.mm.plugin.finder.storage.d.eRY().bmg()).intValue();
    Log.i(TAG, "getFinderShareObject " + i + ' ' + paramFinderItem.getFeedObject().forward_style + ' ' + paramBoolean);
    bvl localbvl;
    Object localObject2;
    label185:
    label208:
    label238:
    Object localObject3;
    label321:
    Collection localCollection;
    label396:
    dji localdji;
    bvj localbvj;
    String str;
    if (paramBoolean) {
      switch (i)
      {
      default: 
        if (com.tencent.mm.ae.d.ee(paramFinderItem.getFeedObject().forward_style, 1))
        {
          localObject1 = "";
          localbvl = new bvl();
          localbvl.objectId = com.tencent.mm.ae.d.hF(paramFinderItem.getId());
          localbvl.objectNonceId = paramFinderItem.getObjectNonceId();
          localbvl.GfT = paramFinderItem.getMediaType();
          localObject2 = paramFinderItem.getFeedObject().contact;
          if (localObject2 != null) {
            break label850;
          }
          localObject2 = "";
          localbvl.avatar = ((String)localObject2);
          localObject2 = paramFinderItem.getBizInfo();
          if (localObject2 != null) {
            break label874;
          }
          localObject2 = "";
          localbvl.aacV = ((String)localObject2);
          localbvl.nickname = ((String)localObject1);
          localObject1 = paramFinderItem.getBizInfo();
          if (localObject1 != null) {
            break label898;
          }
          localObject1 = "";
          localbvl.mIK = ((String)localObject1);
          localbvl.username = paramFinderItem.getUserName();
          localObject1 = com.tencent.mm.plugin.finder.search.k.FxZ;
          localbvl.desc = com.tencent.mm.plugin.finder.search.k.Sp(paramFinderItem.getDescription());
          localObject1 = paramFinderItem.getBizInfo();
          if (localObject1 != null) {
            break label922;
          }
          localObject1 = null;
          if (localObject1 == null)
          {
            localbvl.aacX = 0;
            localbvl.aacY = "";
          }
          localObject1 = paramFinderItem.getFeedObject().contact;
          if (localObject1 != null) {
            break label1007;
          }
          localObject1 = null;
          if (localObject1 == null)
          {
            localbvl.authIconType = 0;
            localbvl.authIconUrl = "";
          }
          localbvl.hGP = paramFinderItem.getMediaList().size();
          localObject3 = localbvl.mediaList;
          localObject1 = (Iterable)paramFinderItem.getMediaList();
          localCollection = (Collection)new ArrayList(p.a((Iterable)localObject1, 10));
          Iterator localIterator = ((Iterable)localObject1).iterator();
          if (!localIterator.hasNext()) {
            break label1091;
          }
          localdji = (dji)localIterator.next();
          localbvj = new bvj();
          localbvj.mediaType = localdji.mediaType;
          str = localdji.url;
          localObject2 = localdji.url_token;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localbvj.url = s.X(str, localObject1);
          if (Util.isNullOrNil(localdji.coverUrl)) {
            break label1048;
          }
          str = localdji.coverUrl;
          localObject2 = localdji.cover_url_token;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
        }
        break;
      }
    }
    for (localbvj.thumbUrl = s.X(str, localObject1);; localbvj.thumbUrl = s.X(str, localObject1))
    {
      if (!Util.isNullOrNil(localdji.aaPi))
      {
        str = localdji.aaPi;
        localObject2 = localdji.aaPj;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localbvj.HaI = s.X(str, localObject1);
      }
      localObject1 = localdji.aaPl;
      if (localObject1 != null) {
        localbvj.aacS = ("[" + ((bbn)localObject1).left + ',' + ((bbn)localObject1).top + ',' + ((bbn)localObject1).right + ',' + ((bbn)localObject1).bottom + ']');
      }
      localbvj.width = localdji.width;
      localbvj.height = localdji.height;
      localbvj.aacR = localdji.videoDuration;
      localCollection.add(localbvj);
      break label396;
      localObject1 = paramFinderItem.getFeedObject().contact;
      if (localObject1 == null)
      {
        localObject1 = "";
        break;
      }
      localObject2 = ((FinderContact)localObject1).nickname;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject1 = "";
      break;
      localObject1 = "";
      break;
      localObject1 = paramFinderItem.getFeedObject().contact;
      if (localObject1 == null)
      {
        localObject1 = "";
        break;
      }
      localObject2 = ((FinderContact)localObject1).nickname;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject1 = "";
      break;
      localObject1 = paramFinderItem.getFeedObject().contact;
      if (localObject1 == null)
      {
        localObject1 = "";
        break;
      }
      localObject2 = ((FinderContact)localObject1).nickname;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject1 = "";
      break;
      label850:
      localObject3 = ((FinderContact)localObject2).headUrl;
      localObject2 = localObject3;
      if (localObject3 != null) {
        break label185;
      }
      localObject2 = "";
      break label185;
      label874:
      localObject3 = ((pu)localObject2).xkY;
      localObject2 = localObject3;
      if (localObject3 != null) {
        break label208;
      }
      localObject2 = "";
      break label208;
      label898:
      localObject2 = ((pu)localObject1).YTl;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label238;
      }
      localObject1 = "";
      break label238;
      label922:
      localObject2 = ((pu)localObject1).YTm;
      if (localObject2 == null)
      {
        i = 0;
        label936:
        localbvl.aacX = i;
        localObject1 = ((pu)localObject1).YTm;
        if (localObject1 != null) {
          break label983;
        }
        localObject1 = "";
      }
      for (;;)
      {
        localbvl.aacY = ((String)localObject1);
        localObject1 = ah.aiuX;
        break;
        i = ((ok)localObject2).auth_icon_type;
        break label936;
        label983:
        localObject2 = ((ok)localObject1).YRv;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
      }
      label1007:
      localObject1 = ((FinderContact)localObject1).authInfo;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label321;
      }
      localbvl.authIconType = ((FinderAuthInfo)localObject1).authIconType;
      localbvl.authIconUrl = ((FinderAuthInfo)localObject1).authIconUrl;
      break label321;
      label1048:
      str = localdji.thumbUrl;
      localObject2 = localdji.thumb_url_token;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
    }
    label1091:
    ((LinkedList)localObject3).addAll((Collection)localCollection);
    long l;
    if (!paramFinderItem.isPostFinish())
    {
      l = paramFinderItem.getLocalId();
      localbvl.localId = l;
      localObject1 = paramFinderItem.getMegaVideo();
      if (localObject1 != null) {
        break label1269;
      }
      l = 0L;
      label1139:
      localbvl.aacT = com.tencent.mm.ae.d.hF(l);
      localObject1 = paramFinderItem.getMegaVideo();
      if (localObject1 != null) {
        break label1279;
      }
      localObject1 = "";
      label1165:
      localbvl.aacU = ((String)localObject1);
      localObject1 = paramFinderItem.getFeedObject().contact;
      i = j;
      if (localObject1 != null)
      {
        i = j;
        if (((FinderContact)localObject1).user_mode == 1) {
          i = 1;
        }
      }
      if (i == 0) {
        break label1303;
      }
      localObject1 = paramFinderItem.getBizInfo();
      if (localObject1 == null) {
        break label1303;
      }
      localObject1 = ((pu)localObject1).ADE;
      if (localObject1 == null) {
        break label1303;
      }
      label1228:
      localbvl.hUQ = ((String)localObject1);
      paramFinderItem = paramFinderItem.getBizInfo();
      if (paramFinderItem != null) {
        break label1311;
      }
      paramFinderItem = "";
    }
    for (;;)
    {
      localbvl.aacW = paramFinderItem;
      AppMethodBeat.o(333899);
      return localbvl;
      l = 0L;
      break;
      label1269:
      l = ((dne)localObject1).id;
      break label1139;
      label1279:
      localObject2 = ((dne)localObject1).aahV;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label1165;
      }
      localObject1 = "";
      break label1165;
      label1303:
      localObject1 = "";
      break label1228;
      label1311:
      localObject1 = paramFinderItem.ADE;
      paramFinderItem = (FinderItem)localObject1;
      if (localObject1 == null) {
        paramFinderItem = "";
      }
    }
  }
  
  private static void d(AppCompatActivity paramAppCompatActivity, BaseFinderFeed paramBaseFinderFeed, Bundle paramBundle)
  {
    AppMethodBeat.i(370235);
    b(paramAppCompatActivity, paramBaseFinderFeed, paramBundle, 21);
    AppMethodBeat.o(370235);
  }
  
  public static int ffy()
  {
    return GhT;
  }
  
  private static final void gQ(View paramView)
  {
    AppMethodBeat.i(334075);
    if (paramView != null)
    {
      paramView = (TextView)paramView.findViewById(e.e.toast_text);
      if (paramView != null) {
        paramView.setTextSize(1, 14.0F);
      }
    }
    AppMethodBeat.o(334075);
  }
  
  private static final void gR(View paramView)
  {
    AppMethodBeat.i(334090);
    if (paramView != null)
    {
      paramView = (TextView)paramView.findViewById(e.e.toast_text);
      if (paramView != null) {
        paramView.setTextSize(1, 14.0F);
      }
    }
    AppMethodBeat.o(334090);
  }
  
  public static String getTAG()
  {
    return TAG;
  }
  
  public static void n(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(334034);
    s.u(paramBaseFinderFeed, "feed");
    LinkedList localLinkedList = new LinkedList();
    fhp localfhp = new fhp();
    localfhp.hKN = paramBaseFinderFeed.feedObject.getId();
    localfhp.objectNonceId = paramBaseFinderFeed.feedObject.getObjectNonceId();
    dzj localdzj = new dzj();
    localdzj.abeu = 1;
    localdzj.share = 1;
    ah localah = ah.aiuX;
    localfhp.abIj = localdzj;
    localfhp.sessionBuffer = paramBaseFinderFeed.getSessionBuffer();
    localfhp.finderUsername = paramBaseFinderFeed.feedObject.getUserName();
    localfhp.AJo = 65;
    paramBaseFinderFeed = paramBaseFinderFeed.feedObject.getLiveInfo();
    if (paramBaseFinderFeed == null) {}
    for (long l = 0L;; l = paramBaseFinderFeed.liveId)
    {
      localfhp.mMJ = l;
      localLinkedList.add(localfhp);
      bi(localLinkedList);
      AppMethodBeat.o(334034);
      return;
    }
  }
  
  public final com.tencent.mm.plugin.findersdk.a.f a(AppCompatActivity paramAppCompatActivity, FinderItem paramFinderItem, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(334244);
    Object localObject1 = av.GiL;
    if (!av.C(paramFinderItem.getFeedObject()))
    {
      paramFinderItem = av.GiL;
      paramFinderItem = (Context)paramAppCompatActivity;
      paramAppCompatActivity = paramAppCompatActivity.getString(e.h.finder_private_ban_share);
      s.s(paramAppCompatActivity, "context.getString(R.stri…finder_private_ban_share)");
      av.aO(paramFinderItem, paramAppCompatActivity);
      AppMethodBeat.o(334244);
      return null;
    }
    Log.i(TAG, "shareToConversation, id:" + paramFinderItem.getId() + ", pflag:" + paramFinderItem.getFeedObject().permissionFlag);
    if (paramFinderItem.getFeedObject().privateFlag == 1)
    {
      aa.a((Context)paramAppCompatActivity, paramAppCompatActivity.getString(e.h.finder_private_feed_share_click_toast), an.a..ExternalSyntheticLambda9.INSTANCE);
      AppMethodBeat.o(334244);
      return null;
    }
    com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1278L, 11L, 1L, false);
    localObject1 = com.tencent.mm.plugin.findersdk.d.a.Hdr;
    if (com.tencent.mm.plugin.findersdk.d.a.aDj("share"))
    {
      AppMethodBeat.o(334244);
      return null;
    }
    localObject1 = com.tencent.mm.ui.component.k.aeZF;
    localObject1 = ((as)com.tencent.mm.ui.component.k.d(paramAppCompatActivity).q(as.class)).fou();
    Object localObject2 = C(paramFinderItem);
    if (paramBoolean)
    {
      paramAppCompatActivity = (com.tencent.mm.plugin.findersdk.a.f)((com.tencent.mm.message.k.b)localObject2).aK(com.tencent.mm.plugin.findersdk.a.f.class);
      AppMethodBeat.o(334244);
      return paramAppCompatActivity;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("Retr_Msg_Type", 18);
    localIntent.putExtra("Multi_Retr", true);
    localIntent.putExtra("Retr_Msg_content", com.tencent.mm.message.k.b.a((com.tencent.mm.message.k.b)localObject2, null, null));
    localIntent.putExtra("Retr_go_to_chattingUI", false);
    localIntent.putExtra("Retr_show_success_tips", true);
    localObject2 = new ah.d();
    ((ah.d)localObject2).aixb = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      Object localObject3 = com.tencent.mm.plugin.secdata.ui.a.PlI;
      localObject3 = (emx)a.a.c((Context)paramAppCompatActivity, 14, emx.class);
      if (localObject3 != null)
      {
        ((emx)localObject3).scene = 1;
        ((emx)localObject3).lsO = 2;
        ((emx)localObject3).Qmp = ((int)(SystemClock.elapsedRealtime() - ((emx)localObject3).startTime));
        ((emx)localObject3).MFq = "0";
        ((emx)localObject3).abrg = "0";
        ((emx)localObject3).toUser = "";
        ((emx)localObject3).abrf = GhT;
        GhT = 0;
      }
      localObject3 = com.tencent.mm.pluginsdk.j.a.XUW;
      com.tencent.mm.pluginsdk.j.a.ly((Context)paramAppCompatActivity);
      com.tencent.mm.br.c.a((MMFragmentActivity)paramAppCompatActivity, ".ui.transmit.MsgRetransmitUI", localIntent, 1001, new an.a..ExternalSyntheticLambda6(paramFinderItem, paramAppCompatActivity, (ah.d)localObject2, (bui)localObject1));
      AppMethodBeat.o(334244);
      return null;
      ((ah.d)localObject2).aixb = 1;
      continue;
      ((ah.d)localObject2).aixb = 4;
    }
  }
  
  public final void a(AppCompatActivity paramAppCompatActivity, BaseFinderFeed paramBaseFinderFeed, Bundle paramBundle)
  {
    AppMethodBeat.i(334261);
    s.u(paramAppCompatActivity, "context");
    s.u(paramBaseFinderFeed, "feed");
    if (paramBaseFinderFeed.feedObject.getMediaType() == 9)
    {
      b(paramAppCompatActivity, paramBaseFinderFeed, paramBundle);
      AppMethodBeat.o(334261);
      return;
    }
    b(paramAppCompatActivity, paramBaseFinderFeed);
    AppMethodBeat.o(334261);
  }
  
  public final void a(AppCompatActivity paramAppCompatActivity, BaseFinderFeed paramBaseFinderFeed, Bundle paramBundle, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(370242);
    s.u(paramAppCompatActivity, "context");
    s.u(paramBaseFinderFeed, "feed");
    if (paramBaseFinderFeed.feedObject.getMediaType() == 9)
    {
      if ((((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).isChargeLive(paramBaseFinderFeed.feedObject.getLiveInfo())) || (((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).isReplayLive(paramBaseFinderFeed.feedObject.getLiveInfo())))
      {
        c(paramAppCompatActivity, paramBaseFinderFeed, paramBundle);
        AppMethodBeat.o(370242);
        return;
      }
      d(paramAppCompatActivity, paramBaseFinderFeed, paramBundle);
      AppMethodBeat.o(370242);
      return;
    }
    a((MMFragmentActivity)paramAppCompatActivity, paramBaseFinderFeed, paramInt1, paramInt2);
    AppMethodBeat.o(370242);
  }
  
  public final void a(AppCompatActivity paramAppCompatActivity, FinderItem paramFinderItem, Bundle paramBundle, int paramInt, kotlin.g.a.b<? super List<String>, ah> paramb)
  {
    AppMethodBeat.i(334228);
    s.u(paramAppCompatActivity, "context");
    s.u(paramFinderItem, "feedObject");
    if (paramFinderItem.getMediaType() == 9)
    {
      if ((((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).isChargeLive(paramFinderItem.getLiveInfo())) || (((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).isReplayLive(paramFinderItem.getLiveInfo())))
      {
        a(paramAppCompatActivity, paramFinderItem, paramBundle, paramb);
        AppMethodBeat.o(334228);
        return;
      }
      b(paramAppCompatActivity, paramFinderItem, paramBundle, paramb);
      AppMethodBeat.o(334228);
      return;
    }
    a(this, paramAppCompatActivity, paramFinderItem, paramInt);
    AppMethodBeat.o(334228);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(Context paramContext, bth parambth, kotlin.g.a.b<? super List<String>, ah> paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/utils/FinderShareUtil$Companion$shareTopicToSnsTimeLine$1", "Lcom/tencent/mm/ui/MMActivity$IMMOnActivityResult;", "mmOnActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements MMActivity.a
  {
    e(MMActivity paramMMActivity, int paramInt1, long paramLong, atg paramatg, String paramString, int paramInt2) {}
    
    public final void mmOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
      boolean bool2 = true;
      boolean bool1 = true;
      AppMethodBeat.i(167902);
      if (paramInt2 == -1) {
        com.tencent.mm.ui.base.k.cZ((Context)this.AXj, this.AXj.getString(e.h.app_shared));
      }
      if (paramInt1 == 7)
      {
        paramIntent = com.tencent.mm.plugin.finder.report.z.FrZ;
        long l;
        if (paramInt2 == -1)
        {
          l = paramLong;
          paramIntent = paramString1;
          if (paramIntent != null) {
            break label121;
          }
        }
        label121:
        for (paramIntent = null;; paramIntent = paramIntent.ZDJ)
        {
          com.tencent.mm.ui.component.k localk = com.tencent.mm.ui.component.k.aeZF;
          com.tencent.mm.plugin.finder.report.z.a(2, bool1, "", l, paramIntent, ((as)com.tencent.mm.ui.component.k.d((AppCompatActivity)this.AXj).q(as.class)).fou());
          AppMethodBeat.o(167902);
          return;
          bool1 = false;
          break;
        }
      }
      paramIntent = com.tencent.mm.plugin.finder.report.z.FrZ;
      if (paramInt2 == -1) {}
      for (bool1 = bool2;; bool1 = false)
      {
        paramIntent = Util.nullAsNil(paramInt2);
        s.s(paramIntent, "nullAsNil(topic)");
        com.tencent.mm.plugin.finder.report.z.a(2, bool1, paramIntent, paramInt1, paramLong, "");
        AppMethodBeat.o(167902);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.an.a
 * JD-Core Version:    0.7.0.1
 */