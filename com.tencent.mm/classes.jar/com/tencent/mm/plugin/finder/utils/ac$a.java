package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.modelsns.k;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.z;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.textstatus.a.q;
import com.tencent.mm.plugin.textstatus.a.q.a;
import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.apn;
import com.tencent.mm.protocal.protobuf.awc;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.bja;
import com.tencent.mm.protocal.protobuf.bjb;
import com.tencent.mm.protocal.protobuf.bjc;
import com.tencent.mm.protocal.protobuf.bje;
import com.tencent.mm.protocal.protobuf.bjf;
import com.tencent.mm.protocal.protobuf.bjg;
import com.tencent.mm.protocal.protobuf.bjp;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.protocal.protobuf.cvy;
import com.tencent.mm.protocal.protobuf.eka;
import com.tencent.mm.protocal.protobuf.emr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.component.g.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.k.i;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/utils/FinderShareUtil$Companion;", "", "()V", "REQUEST_CODE_SHARE_FEED_TO_CHAT", "", "REQUEST_CODE_SHARE_FEED_TO_SNS", "REQUEST_CODE_SHARE_LIVE_INVITE_TO_CHAT", "REQUEST_CODE_SHARE_LIVE_TO_CHAT", "REQUEST_CODE_SHARE_LIVE_TO_SNS", "REQUEST_CODE_SHARE_LIVE_TO_TEXT_STATUS", "REQUEST_CODE_SHARE_NAMECARD_TO_CAHT", "REQUEST_CODE_SHARE_VIDEO_FILE_TO_CHAT", "TAG", "", "getTAG", "()Ljava/lang/String;", "finderObjToJumpInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "genFinderShareAlbum", "Lcom/tencent/mm/protocal/protobuf/FinderShareAlbum;", "card", "Lcom/tencent/mm/protocal/protobuf/FinderStreamCard;", "cardId", "title", "subTitle", "urls", "", "urlTokens", "cardBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "genFinderSharePoi", "Lcom/tencent/mm/protocal/protobuf/FinderSharePoi;", "location", "Lcom/tencent/mm/protocal/protobuf/SnsLocation;", "poiCategories", "iconUrl", "poiName", "videoCount", "getFavEventInfo", "Lcom/tencent/mm/autogen/events/DoFavoriteEvent;", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "thumbPath", "getFinderSetStatusParam", "Lcom/tencent/mm/plugin/textstatus/api/SetStatusParam;", "nickName", "itemId", "", "getFinderShareObject", "Lcom/tencent/mm/protocal/protobuf/FinderShareObject;", "feedObject", "isShareSns", "", "getFinderTopic", "Lcom/tencent/mm/protocal/protobuf/FinderShareTopic;", "topic", "topicType", "desc", "poiLocation", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "patMusicId", "activityEvent", "Lcom/tencent/mm/protocal/protobuf/FinderActivityEvent;", "getMegaVideoShareObject", "Lcom/tencent/mm/protocal/protobuf/MegaVideoShareObject;", "finderMegaVideo", "Lcom/tencent/mm/protocal/protobuf/FinderMegaVideo;", "shareAlbumToConversation", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "objectContent", "Lcom/tencent/mm/plugin/findersdk/api/AppMsgContentFinderAlbum;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "shareAlbumToSnsTimeLine", "snsShare", "Lcom/tencent/mm/modelsns/SnsFinderShareAlbum;", "shareFeedToConversation", "Landroidx/appcompat/app/AppCompatActivity;", "param", "Landroid/os/Bundle;", "shareType", "shareFeedToStatusInternal", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "shareFinderContactToConversation", "contact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "shareInvitingLiveToConversation", "callback", "Lkotlin/Function1;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Lkotlin/ParameterName;", "name", "avatar", "shareLiveToConversation", "toUsers", "shareLiveToSnsTimeLineInternal", "shareLiveToStatusInternal", "shareMegaVideoToConversation", "shareMegaVideoToSnsTimeLine", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "sharePoiFeedToConversation", "sharePoiFeedToSnsTimeLine", "shareStatsReport", "stats", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/Stats;", "shareToConversation", "shareToConvertionStatsReport", "shareToSnsStatsReport", "shareToSnsTimeLine", "postFromSnsType", "shareToSnsTimeLineInternal", "Lcom/tencent/mm/ui/MMFragmentActivity;", "shareToStatusTimeLine", "shareTopicToConversation", "totalCount", "scene", "followId", "shareTopicToSnsTimeLine", "plugin-finder_release"})
public final class ac$a
{
  private static final String TAG = "Finder.FinderShareUtil";
  
  static
  {
    AppMethodBeat.i(167909);
    AEK = new a();
    TAG = "Finder.FinderShareUtil";
    AppMethodBeat.o(167909);
  }
  
  public static q a(String paramString1, String paramString2, long paramLong, FinderObject paramFinderObject)
  {
    AppMethodBeat.i(269852);
    p.k(paramFinderObject, "finderObject");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(v(paramFinderObject));
    Object localObject = new TextStatusJumpInfo();
    ((TextStatusJumpInfo)localObject).jumpType = "3";
    ((TextStatusJumpInfo)localObject).busiBuf = "https://support.weixin.qq.com/security/readtemplate?t=w_security_center_website/upgrade&scene=1#wechat_redirect";
    localArrayList.add(localObject);
    localObject = new q.a();
    ((q.a)localObject).bec("1024");
    ((q.a)localObject).bei(paramString1);
    ((q.a)localObject).bej(paramString2);
    ((q.a)localObject).bef("finder@inner");
    ((q.a)localObject).beg(com.tencent.mm.ae.d.Fw(paramLong));
    ((q.a)localObject).beh(paramFinderObject.verify_info_buf);
    ((q.a)localObject).bej("http://wxapp.tc.qq.com/258/20304/stodownload?m=9823aa7c1879309ff7588e09c22144dd&filekey=30340201010420301e020201020402534804109823aa7c1879309ff7588e09c22144dd020207b8040d00000004627466730000000131&hy=SH&storeid=32303231303331383139353930393030306236313937303030303030303037636638353130393030303030313032&bizid=1023");
    ((q.a)localObject).im((List)localArrayList);
    paramString1 = ((q.a)localObject).gkO();
    p.j(paramString1, "SetStatusParam.Builder()…fo)\n            }.build()");
    AppMethodBeat.o(269852);
    return paramString1;
  }
  
  private static bja a(String paramString1, String paramString2, String paramString3, List<String> paramList1, List<String> paramList2, com.tencent.mm.cd.b paramb)
  {
    int i = 0;
    AppMethodBeat.i(269864);
    bja localbja = new bja();
    localbja.cardId = paramString1;
    localbja.title = paramString2;
    localbja.rsw = paramString3;
    paramString1 = ((Iterable)paramList1.subList(0, i.ow(4, paramList1.size()))).iterator();
    while (paramString1.hasNext())
    {
      paramString2 = paramString1.next();
      if (i < 0) {
        kotlin.a.j.iBO();
      }
      paramString2 = (String)paramString2;
      localbja.STk.add(paramString2);
      localbja.STl.add(paramList2.get(i));
      i += 1;
    }
    localbja.xGO = paramb;
    AppMethodBeat.o(269864);
    return localbja;
  }
  
  public static bjf a(eka parameka, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(269871);
    p.k(parameka, "location");
    p.k(paramString1, "poiCategories");
    bjf localbjf = new bjf();
    localbjf.STs = String.valueOf(parameka.ScO);
    localbjf.STr = String.valueOf(parameka.ScP);
    localbjf.SOz = parameka.SOz;
    localbjf.STt = String.valueOf(parameka.TAz);
    localbjf.QSw = paramString2;
    localbjf.lLg = parameka.KFu;
    if (!Util.isNullOrNil(parameka.poiName)) {
      paramString3 = parameka.poiName;
    }
    localbjf.poiName = paramString3;
    parameka = new StringBuilder();
    if (Util.isNullOrNil(paramString1)) {
      if (paramInt > 0) {
        parameka.append(MMApplicationContext.getContext().getString(b.j.finder_poi_feed_share_card_video_count, new Object[] { Integer.valueOf(paramInt) }));
      }
    }
    for (;;)
    {
      localbjf.xzN = parameka.toString();
      AppMethodBeat.o(269871);
      return localbjf;
      parameka.append(paramString1);
      if (paramInt > 0) {
        parameka.append(" | ").append(MMApplicationContext.getContext().getString(b.j.finder_poi_feed_share_card_video_count, new Object[] { Integer.valueOf(paramInt) }));
      }
    }
  }
  
  private static bjg a(String paramString1, int paramInt, String paramString2, String paramString3, bdm parambdm, String paramString4, apn paramapn)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(269863);
    bjg localbjg = new bjg();
    localbjg.topic = Util.nullAsNil(paramString1);
    localbjg.wXA = paramInt;
    localbjg.iconUrl = Util.nullAsNil(paramString2);
    localbjg.desc = Util.nullAsNil(paramString3);
    localbjg.STv = Util.nullAsNil(paramString4);
    paramString2 = new bjb();
    if (parambdm != null)
    {
      paramString1 = parambdm.SOz;
      paramString2.SOz = paramString1;
      if (parambdm == null) {
        break label157;
      }
    }
    label157:
    for (float f1 = parambdm.longitude;; f1 = 0.0F)
    {
      paramString2.longitude = f1;
      f1 = f2;
      if (parambdm != null) {
        f1 = parambdm.latitude;
      }
      paramString2.latitude = f1;
      localbjg.STu = paramString2;
      if (paramapn != null) {
        localbjg.STw = paramapn;
      }
      AppMethodBeat.o(269863);
      return localbjg;
      paramString1 = null;
      break;
    }
  }
  
  public static bja b(bjp parambjp)
  {
    AppMethodBeat.i(269866);
    p.k(parambjp, "card");
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    Object localObject = parambjp.object;
    p.j(localObject, "card.`object`");
    localObject = (Iterable)localObject;
    int i = 0;
    Iterator localIterator = ((Iterable)localObject).iterator();
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      int j = i + 1;
      if (i < 0) {
        kotlin.a.j.iBO();
      }
      localObject = (FinderObject)localObject;
      if (i < 4)
      {
        localObject = ((FinderObject)localObject).objectDesc;
        if (localObject != null)
        {
          localObject = ((FinderObjectDesc)localObject).media;
          if (localObject != null) {
            localObject = (FinderMedia)((LinkedList)localObject).getFirst();
          }
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
            if (localObject != null)
            {
              localLinkedList2.add(localObject);
              i = j;
              break;
              localObject = null;
              continue;
            }
            i = j;
            break;
          }
        }
      }
      i = j;
    }
    parambjp = a(com.tencent.mm.ae.d.Fw(parambjp.id), parambjp.PAf, parambjp.STM, (List)localLinkedList1, (List)localLinkedList2, parambjp.xGO);
    AppMethodBeat.o(269866);
    return parambjp;
  }
  
  public static void b(MMActivity paramMMActivity, final String paramString1, final int paramInt1, final long paramLong, String paramString2, String paramString3, bdm parambdm, final int paramInt2, String paramString4, apn paramapn)
  {
    AppMethodBeat.i(269861);
    p.k(paramMMActivity, "context");
    Object localObject1 = com.tencent.mm.plugin.findersdk.c.a.Bwg;
    if (com.tencent.mm.plugin.findersdk.c.a.aGS("share"))
    {
      AppMethodBeat.o(269861);
      return;
    }
    Log.i(TAG, "share topic " + paramString1 + " to sns");
    localObject1 = new Intent();
    Object localObject2;
    int i;
    if (paramInt1 == 7)
    {
      localObject2 = new com.tencent.mm.modelsns.b();
      ((com.tencent.mm.modelsns.b)localObject2).mbf = a(paramString1, paramInt1, paramString2, paramString3, parambdm, paramString4, paramapn);
      paramString2 = (k)localObject2;
      switch (paramInt1)
      {
      case 5: 
      case 6: 
      default: 
        i = 18;
        label148:
        if (paramInt1 == 7) {
          ((Intent)localObject1).putExtra("ksnsupload_finder_activity_xml", paramString2.boV());
        }
        break;
      }
    }
    for (;;)
    {
      ((Intent)localObject1).putExtra("Ksnsupload_type", i);
      ((Intent)localObject1).putExtra("need_result", true);
      com.tencent.mm.by.c.a(paramMMActivity, ".plugin.sns.ui.SnsUploadUI", (Intent)localObject1, 1002, (MMActivity.a)new n(paramMMActivity, paramInt1, paramLong, paramapn, paramString1, paramInt2));
      AppMethodBeat.o(269861);
      return;
      localObject2 = new com.tencent.mm.modelsns.g();
      ((com.tencent.mm.modelsns.g)localObject2).mbf = a(paramString1, paramInt1, paramString2, paramString3, parambdm, paramString4, paramapn);
      paramString2 = (k)localObject2;
      break;
      i = 22;
      break label148;
      i = 24;
      break label148;
      ((Intent)localObject1).putExtra("ksnsupload_finder_topic_xml", paramString2.boV());
    }
  }
  
  public static bje c(FinderItem paramFinderItem, boolean paramBoolean)
  {
    long l2 = 0L;
    AppMethodBeat.i(269857);
    p.k(paramFinderItem, "feedObject");
    Object localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
    int i = ((Number)com.tencent.mm.plugin.finder.storage.d.dTH().aSr()).intValue();
    Log.i(TAG, "getFinderShareObject " + i + ' ' + paramFinderItem.getFeedObject().forward_style + ' ' + paramBoolean);
    bje localbje;
    Object localObject2;
    Object localObject3;
    Collection localCollection;
    label270:
    csg localcsg;
    bjc localbjc;
    StringBuilder localStringBuilder;
    if ((paramBoolean) && (i != 1)) {
      if (i == 2)
      {
        localObject1 = "";
        localbje = new bje();
        localbje.objectId = com.tencent.mm.ae.d.Fw(paramFinderItem.getId());
        localbje.objectNonceId = paramFinderItem.getObjectNonceId();
        localbje.ACQ = paramFinderItem.getMediaType();
        localObject2 = paramFinderItem.getFeedObject().contact;
        if (localObject2 != null)
        {
          localObject3 = ((FinderContact)localObject2).headUrl;
          localObject2 = localObject3;
          if (localObject3 != null) {}
        }
        else
        {
          localObject2 = "";
        }
        localbje.avatar = ((String)localObject2);
        localbje.nickname = ((String)localObject1);
        localbje.username = paramFinderItem.getUserName();
        localObject1 = com.tencent.mm.plugin.finder.search.j.Acs;
        localbje.desc = com.tencent.mm.plugin.finder.search.j.aac(paramFinderItem.getDescription());
        localbje.fCa = paramFinderItem.getMediaList().size();
        localObject3 = localbje.mediaList;
        localObject1 = (Iterable)paramFinderItem.getMediaList();
        localCollection = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject1, 10));
        Iterator localIterator = ((Iterable)localObject1).iterator();
        if (!localIterator.hasNext()) {
          break label713;
        }
        localcsg = (csg)localIterator.next();
        localbjc = new bjc();
        localbjc.mediaType = localcsg.mediaType;
        localStringBuilder = new StringBuilder().append(localcsg.url);
        localObject2 = localcsg.url_token;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localbjc.url = ((String)localObject1);
        if (Util.isNullOrNil(localcsg.coverUrl)) {
          break label657;
        }
        localStringBuilder = new StringBuilder().append(localcsg.coverUrl);
        localObject2 = localcsg.cover_url_token;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
      }
    }
    for (localbjc.thumbUrl = ((String)localObject1);; localbjc.thumbUrl = ((String)localObject1))
    {
      if (!Util.isNullOrNil(localcsg.TzX))
      {
        localStringBuilder = new StringBuilder().append(localcsg.TzX);
        localObject2 = localcsg.TzY;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localbjc.STn = ((String)localObject1);
      }
      localObject1 = localcsg.TAa;
      if (localObject1 != null) {
        localbjc.STo = ("[" + ((awc)localObject1).left + ',' + ((awc)localObject1).top + ',' + ((awc)localObject1).right + ',' + ((awc)localObject1).bottom + ']');
      }
      localbjc.width = localcsg.width;
      localbjc.height = localcsg.height;
      localbjc.STm = localcsg.videoDuration;
      localCollection.add(localbjc);
      break label270;
      if (com.tencent.mm.ae.d.dr(paramFinderItem.getFeedObject().forward_style, 1))
      {
        localObject1 = "";
        break;
      }
      localObject1 = paramFinderItem.getNickName();
      break;
      localObject1 = paramFinderItem.getNickName();
      break;
      label657:
      localStringBuilder = new StringBuilder().append(localcsg.thumbUrl);
      localObject2 = localcsg.thumb_url_token;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
    }
    label713:
    ((LinkedList)localObject3).addAll((Collection)localCollection);
    if (!paramFinderItem.isPostFinish()) {}
    for (long l1 = paramFinderItem.getLocalId();; l1 = 0L)
    {
      localbje.localId = l1;
      localObject1 = paramFinderItem.getMegaVideo();
      l1 = l2;
      if (localObject1 != null) {
        l1 = ((cvy)localObject1).id;
      }
      localbje.STp = com.tencent.mm.ae.d.Fw(l1);
      paramFinderItem = paramFinderItem.getMegaVideo();
      if (paramFinderItem != null)
      {
        localObject1 = paramFinderItem.SWw;
        paramFinderItem = (FinderItem)localObject1;
        if (localObject1 != null) {}
      }
      else
      {
        paramFinderItem = "";
      }
      localbje.STq = paramFinderItem;
      AppMethodBeat.o(269857);
      return localbje;
    }
  }
  
  public static String getTAG()
  {
    return TAG;
  }
  
  public static TextStatusJumpInfo v(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(269853);
    p.k(paramFinderObject, "finderObject");
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
          com.tencent.mm.plugin.finder.search.j localj = com.tencent.mm.plugin.finder.search.j.Acs;
          p.j(localObject, "it");
          localFinderObjectDesc.description = com.tencent.mm.plugin.finder.search.j.aac((String)localObject);
        }
      }
    }
    paramFinderObject = paramFinderObject.toByteArray();
    localTextStatusJumpInfo.busiBuf = Base64.encodeToString(paramFinderObject, 0, paramFinderObject.length, 0);
    AppMethodBeat.o(269853);
    return localTextStatusJumpInfo;
  }
  
  public final void a(MMActivity paramMMActivity, com.tencent.mm.modelsns.c paramc, bid parambid)
  {
    AppMethodBeat.i(269869);
    p.k(paramMMActivity, "context");
    p.k(paramc, "snsShare");
    Object localObject = com.tencent.mm.plugin.findersdk.c.a.Bwg;
    if (com.tencent.mm.plugin.findersdk.c.a.aGS("share"))
    {
      AppMethodBeat.o(269869);
      return;
    }
    Log.i(TAG, "[shareAlbumToSnsTimeLine] share album to sns. " + paramc.mbg.title);
    localObject = new Intent();
    ((Intent)localObject).putExtra("ksnsupload_finder_album_xml", paramc.boV());
    ((Intent)localObject).putExtra("Ksnsupload_type", 20);
    ((Intent)localObject).putExtra("need_result", true);
    com.tencent.mm.by.c.a(paramMMActivity, ".plugin.sns.ui.SnsUploadUI", (Intent)localObject, 1002, (MMActivity.a)new ac.a.b(this, paramMMActivity, paramc, parambid));
    AppMethodBeat.o(269869);
  }
  
  public final void a(MMActivity paramMMActivity, com.tencent.mm.plugin.findersdk.a.d paramd, bid parambid)
  {
    AppMethodBeat.i(269868);
    p.k(paramMMActivity, "context");
    p.k(paramd, "objectContent");
    Object localObject = com.tencent.mm.plugin.findersdk.c.a.Bwg;
    if (com.tencent.mm.plugin.findersdk.c.a.aGS("share"))
    {
      AppMethodBeat.o(269868);
      return;
    }
    localObject = new k.b();
    ((k.b)localObject).a((com.tencent.mm.aj.f)paramd);
    ((k.b)localObject).type = 73;
    ((k.b)localObject).title = MMApplicationContext.getContext().getString(b.j.low_version_upgrade_tip);
    ((k.b)localObject).url = MMApplicationContext.getContext().getString(b.j.low_version_upgrade_url);
    Intent localIntent = new Intent();
    localIntent.putExtra("Retr_Msg_Type", 22);
    localIntent.putExtra("Multi_Retr", true);
    localIntent.putExtra("Retr_Msg_content", k.b.a((k.b)localObject, null, null));
    localIntent.putExtra("Retr_go_to_chattingUI", false);
    localIntent.putExtra("Retr_show_success_tips", true);
    com.tencent.mm.by.c.a(paramMMActivity, ".ui.transmit.MsgRetransmitUI", localIntent, 1001, (MMActivity.a)new ac.a.a(this, paramd, parambid));
    AppMethodBeat.o(269868);
  }
  
  public final void a(final MMActivity paramMMActivity, final String paramString1, final int paramInt1, final long paramLong, String paramString2, String paramString3, bdm parambdm, final int paramInt2, String paramString4, apn paramapn)
  {
    AppMethodBeat.i(269859);
    p.k(paramMMActivity, "context");
    Object localObject1 = com.tencent.mm.plugin.findersdk.c.a.Bwg;
    if (com.tencent.mm.plugin.findersdk.c.a.aGS("share"))
    {
      AppMethodBeat.o(269859);
      return;
    }
    localObject1 = new k.b();
    Object localObject2;
    int i;
    if (paramInt1 != 7)
    {
      localObject2 = new com.tencent.mm.plugin.findersdk.a.h();
      ((com.tencent.mm.plugin.findersdk.a.h)localObject2).a(a(paramString1, paramInt1, paramString2, paramString3, parambdm, paramString4, null));
      paramString2 = (com.tencent.mm.aj.f)localObject2;
      ((k.b)localObject1).a(paramString2);
      switch (paramInt1)
      {
      case 5: 
      case 6: 
      default: 
        i = 59;
        label128:
        ((k.b)localObject1).type = i;
        ((k.b)localObject1).title = MMApplicationContext.getContext().getString(b.j.low_version_upgrade_tip);
        ((k.b)localObject1).url = MMApplicationContext.getContext().getString(b.j.low_version_upgrade_url);
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
      paramString2.putExtra("Retr_Msg_content", k.b.a((k.b)localObject1, null, null));
      paramString2.putExtra("Retr_go_to_chattingUI", false);
      paramString2.putExtra("Retr_show_success_tips", true);
      com.tencent.mm.by.c.a(paramMMActivity, ".ui.transmit.MsgRetransmitUI", paramString2, 1001, (MMActivity.a)new m(this, paramString1, paramInt1, paramLong, paramapn, paramMMActivity, paramInt2));
      AppMethodBeat.o(269859);
      return;
      ((k.b)localObject1).loX = 3;
      localObject2 = new com.tencent.mm.plugin.findersdk.a.c();
      ((com.tencent.mm.plugin.findersdk.a.c)localObject2).a(a(paramString1, paramInt1, paramString2, paramString3, parambdm, paramString4, paramapn));
      paramString2 = (com.tencent.mm.aj.f)localObject2;
      break;
      i = 72;
      break label128;
      i = 75;
      break label128;
      i = 25;
      continue;
      i = 27;
    }
  }
  
  public final void bb(LinkedList<emr> paramLinkedList)
  {
    AppMethodBeat.i(269872);
    p.k(paramLinkedList, "stats");
    new z((List)paramLinkedList, null).bhW().j((com.tencent.mm.vending.c.a)new ac.a.j(this, paramLinkedList));
    AppMethodBeat.o(269872);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
  static final class m
    implements MMActivity.a
  {
    m(ac.a parama, String paramString, int paramInt1, long paramLong, apn paramapn, MMActivity paramMMActivity, int paramInt2) {}
    
    public final void d(int paramInt1, int paramInt2, Intent paramIntent)
    {
      boolean bool2 = false;
      boolean bool1 = false;
      AppMethodBeat.i(167901);
      Object localObject = new ArrayList();
      if (paramInt2 == -1)
      {
        localObject = paramIntent.getStringArrayListExtra("SendMsgUsernames");
        p.j(localObject, "data.getStringArrayListE…sgRetr.KSendMsgUsernames)");
        Log.i(ac.a.getTAG(), "share topic " + paramString1 + " to " + localObject);
      }
      if (paramInt1 == 7)
      {
        paramIntent = n.zWF;
        if (paramInt2 == -1) {
          bool1 = true;
        }
        localObject = Util.listToString((List)localObject, ",");
        p.j(localObject, "Util.listToString(toUsers, \",\")");
        l = paramLong;
        paramIntent = paramMMActivity;
        if (paramIntent != null) {}
        for (paramIntent = paramIntent.SCQ;; paramIntent = null)
        {
          com.tencent.mm.ui.component.g localg = com.tencent.mm.ui.component.g.Xox;
          n.a(1, bool1, (String)localObject, l, paramIntent, ((aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)paramInt2).i(aj.class)).ekY());
          AppMethodBeat.o(167901);
          return;
        }
      }
      paramIntent = n.zWF;
      bool1 = bool2;
      if (paramInt2 == -1) {
        bool1 = true;
      }
      paramIntent = Util.nullAsNil(paramString1);
      p.j(paramIntent, "Util.nullAsNil(topic)");
      paramInt1 = paramInt1;
      long l = paramLong;
      localObject = Util.listToString((List)localObject, ",");
      p.j(localObject, "Util.listToString(toUsers, \",\")");
      n.a(1, bool1, paramIntent, paramInt1, l, (String)localObject);
      AppMethodBeat.o(167901);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/utils/FinderShareUtil$Companion$shareTopicToSnsTimeLine$1", "Lcom/tencent/mm/ui/MMActivity$IMMOnActivityResult;", "mmOnActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "plugin-finder_release"})
  public static final class n
    implements MMActivity.a
  {
    n(MMActivity paramMMActivity, int paramInt1, long paramLong, apn paramapn, String paramString, int paramInt2) {}
    
    public final void d(int paramInt1, int paramInt2, Intent paramIntent)
    {
      boolean bool2 = true;
      boolean bool1 = true;
      AppMethodBeat.i(167902);
      if (paramInt2 == -1) {
        com.tencent.mm.ui.base.h.cL((Context)this.xzL, this.xzL.getString(b.j.app_shared));
      }
      if (paramInt1 == 7)
      {
        paramIntent = n.zWF;
        long l;
        if (paramInt2 == -1)
        {
          l = paramLong;
          paramIntent = paramString1;
          if (paramIntent == null) {
            break label124;
          }
        }
        label124:
        for (paramIntent = paramIntent.SCQ;; paramIntent = null)
        {
          com.tencent.mm.ui.component.g localg = com.tencent.mm.ui.component.g.Xox;
          n.a(2, bool1, "", l, paramIntent, ((aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)this.xzL).i(aj.class)).ekY());
          AppMethodBeat.o(167902);
          return;
          bool1 = false;
          break;
        }
      }
      paramIntent = n.zWF;
      if (paramInt2 == -1) {}
      for (bool1 = bool2;; bool1 = false)
      {
        paramIntent = Util.nullAsNil(paramInt2);
        p.j(paramIntent, "Util.nullAsNil(topic)");
        n.a(2, bool1, paramIntent, paramInt1, paramLong, "");
        AppMethodBeat.o(167902);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.ac.a
 * JD-Core Version:    0.7.0.1
 */