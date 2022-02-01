package com.tencent.mm.plugin.finder.utils;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.plugin.finder.event.a.b;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.plugin.finder.report.live.s.c;
import com.tencent.mm.plugin.finder.search.i;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.axf;
import com.tencent.mm.protocal.protobuf.axt;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bcf;
import com.tencent.mm.protocal.protobuf.bcg;
import com.tencent.mm.protocal.protobuf.bch;
import com.tencent.mm.protocal.protobuf.bcj;
import com.tencent.mm.protocal.protobuf.bcl;
import com.tencent.mm.protocal.protobuf.bcu;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.MMFragmentActivity.b;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.base.u.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.z.d;
import kotlin.g.b.z.f;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/utils/FinderShareUtil;", "", "Companion", "plugin-finder_release"})
public abstract interface s
{
  public static final a vWt = a.vWu;
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/utils/FinderShareUtil$Companion;", "", "()V", "REQUEST_CODE_SHARE_FEED_TO_CHAT", "", "REQUEST_CODE_SHARE_FEED_TO_SNS", "REQUEST_CODE_SHARE_LIVE_INVITE_TO_CHAT", "REQUEST_CODE_SHARE_LIVE_TO_CHAT", "REQUEST_CODE_SHARE_LIVE_TO_SNS", "REQUEST_CODE_SHARE_NAMECARD_TO_CAHT", "REQUEST_CODE_SHARE_VIDEO_FILE_TO_CHAT", "TAG", "", "getTAG", "()Ljava/lang/String;", "genFinderShareAlbum", "Lcom/tencent/mm/protocal/protobuf/FinderShareAlbum;", "card", "Lcom/tencent/mm/protocal/protobuf/FinderStreamCard;", "cardId", "title", "subTitle", "urls", "", "urlTokens", "cardBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getFavEventInfo", "Lcom/tencent/mm/autogen/events/DoFavoriteEvent;", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "thumbPath", "getFinderLive", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShareObject;", "feedObject", "getFinderShareObject", "Lcom/tencent/mm/protocal/protobuf/FinderShareObject;", "isShareSns", "", "getFinderTopic", "Lcom/tencent/mm/protocal/protobuf/FinderShareTopic;", "topic", "topicType", "iconUrl", "desc", "poiLocation", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "patMusicId", "activityEvent", "Lcom/tencent/mm/protocal/protobuf/FinderActivityEvent;", "getMegaVideoShareObject", "Lcom/tencent/mm/protocal/protobuf/MegaVideoShareObject;", "finderMegaVideo", "Lcom/tencent/mm/protocal/protobuf/FinderMegaVideo;", "shareAlbumToConversation", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "objectContent", "Lcom/tencent/mm/plugin/findersdk/api/AppMsgContentFinderAlbum;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "shareAlbumToSnsTimeLine", "snsShare", "Lcom/tencent/mm/modelsns/SnsFinderShareAlbum;", "shareFeedToConversation", "Landroid/support/v7/app/AppCompatActivity;", "param", "Landroid/os/Bundle;", "shareType", "shareFinderContactToConversation", "contact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "shareInvitingLiveToConversation", "callback", "Lkotlin/Function1;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Lkotlin/ParameterName;", "name", "avatar", "shareLiveToConversation", "shareLiveToSnsTimeLineInternal", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "shareLiveToStatusInternal", "shareMegaVideoToConversation", "shareMegaVideoToSnsTimeLine", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "sharePoiFeedToConversation", "location", "Lcom/tencent/mm/protocal/protobuf/SnsLocation;", "poiCategories", "shareToConversation", "shareToSnsTimeLine", "postFromSnsType", "shareToSnsTimeLineInternal", "Lcom/tencent/mm/ui/MMFragmentActivity;", "shareToStatusInternal", "shareToStatusTimeLine", "shareTopicToConversation", "totalCount", "", "scene", "followId", "shareTopicToSnsTimeLine", "plugin-finder_release"})
  public static final class a
  {
    private static final String TAG = "Finder.FinderShareUtil";
    
    static
    {
      AppMethodBeat.i(167909);
      vWu = new a();
      TAG = "Finder.FinderShareUtil";
      AppMethodBeat.o(167909);
    }
    
    private static bcf a(String paramString1, String paramString2, String paramString3, List<String> paramList1, List<String> paramList2, com.tencent.mm.bw.b paramb)
    {
      int i = 0;
      AppMethodBeat.i(253520);
      bcf localbcf = new bcf();
      localbcf.cardId = paramString1;
      localbcf.title = paramString2;
      localbcf.oqZ = paramString3;
      paramString1 = ((Iterable)paramList1.subList(0, kotlin.k.j.na(4, paramList1.size()))).iterator();
      while (paramString1.hasNext())
      {
        paramString2 = paramString1.next();
        if (i < 0) {
          kotlin.a.j.hxH();
        }
        paramString2 = (String)paramString2;
        localbcf.LLt.add(paramString2);
        localbcf.LLu.add(paramList2.get(i));
        i += 1;
      }
      localbcf.tVe = paramb;
      AppMethodBeat.o(253520);
      return localbcf;
    }
    
    private static bcl a(String paramString1, int paramInt, String paramString2, String paramString3, axt paramaxt, String paramString4, aoi paramaoi)
    {
      float f2 = 0.0F;
      AppMethodBeat.i(253518);
      bcl localbcl = new bcl();
      localbcl.dST = Util.nullAsNil(paramString1);
      localbcl.tvC = paramInt;
      localbcl.iconUrl = Util.nullAsNil(paramString2);
      localbcl.desc = Util.nullAsNil(paramString3);
      localbcl.LLC = Util.nullAsNil(paramString4);
      paramString2 = new bcg();
      if (paramaxt != null)
      {
        paramString1 = paramaxt.LIb;
        paramString2.LIb = paramString1;
        if (paramaxt == null) {
          break label155;
        }
      }
      label155:
      for (float f1 = paramaxt.dTj;; f1 = 0.0F)
      {
        paramString2.dTj = f1;
        f1 = f2;
        if (paramaxt != null) {
          f1 = paramaxt.latitude;
        }
        paramString2.latitude = f1;
        localbcl.LLB = paramString2;
        if (paramaoi != null) {
          localbcl.LLD = paramaoi;
        }
        AppMethodBeat.o(253518);
        return localbcl;
        paramString1 = null;
        break;
      }
    }
    
    private final void a(AppCompatActivity paramAppCompatActivity, final FinderItem paramFinderItem)
    {
      AppMethodBeat.i(253506);
      Object localObject1 = y.vXH;
      if (!y.u(paramFinderItem.getFeedObject()))
      {
        paramFinderItem = y.vXH;
        paramFinderItem = (Context)paramAppCompatActivity;
        paramAppCompatActivity = paramAppCompatActivity.getString(2131760436);
        p.g(paramAppCompatActivity, "context.getString(R.stri…finder_private_ban_share)");
        y.aF(paramFinderItem, paramAppCompatActivity);
        AppMethodBeat.o(253506);
        return;
      }
      Object localObject2 = TAG;
      StringBuilder localStringBuilder = new StringBuilder("share live  ").append(paramFinderItem.getId()).append(' ');
      localObject1 = paramFinderItem.getFeedObject();
      if (localObject1 != null)
      {
        localObject1 = Integer.valueOf(((FinderObject)localObject1).forward_style);
        localStringBuilder = localStringBuilder.append(((Integer)localObject1).intValue()).append(" to conversation,liveId:");
        localObject1 = paramFinderItem.getLiveInfo();
        if (localObject1 == null) {
          break label354;
        }
        localObject1 = Long.valueOf(((awe)localObject1).liveId);
        label136:
        localStringBuilder = localStringBuilder.append(localObject1).append(",desc:").append(paramFinderItem.getDescription()).append(",liveStatus ");
        localObject1 = paramFinderItem.getLiveInfo();
        if (localObject1 == null) {
          break label359;
        }
      }
      label354:
      label359:
      for (localObject1 = Integer.valueOf(((awe)localObject1).liveStatus);; localObject1 = null)
      {
        Log.i((String)localObject2, localObject1);
        localObject1 = new k.b();
        localObject2 = new com.tencent.mm.plugin.i.a.b();
        ((com.tencent.mm.plugin.i.a.b)localObject2).b(y(paramFinderItem));
        ((k.b)localObject1).a((com.tencent.mm.ag.f)localObject2);
        ((k.b)localObject1).type = 63;
        ((k.b)localObject1).title = MMApplicationContext.getContext().getString(2131762562);
        ((k.b)localObject1).url = MMApplicationContext.getContext().getString(2131762563);
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("Retr_Msg_Type", 23);
        ((Intent)localObject2).putExtra("Multi_Retr", true);
        ((Intent)localObject2).putExtra("Retr_Msg_content", k.b.a((k.b)localObject1, null, null));
        ((Intent)localObject2).putExtra("Retr_go_to_chattingUI", false);
        ((Intent)localObject2).putExtra("Retr_show_success_tips", true);
        if (paramAppCompatActivity != null) {
          break label364;
        }
        paramAppCompatActivity = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
        AppMethodBeat.o(253506);
        throw paramAppCompatActivity;
        localObject1 = null;
        break;
        localObject1 = null;
        break label136;
      }
      label364:
      com.tencent.mm.br.c.a((MMFragmentActivity)paramAppCompatActivity, ".ui.transmit.MsgRetransmitUI", (Intent)localObject2, 1005, (MMFragmentActivity.b)new g(this, paramFinderItem));
      AppMethodBeat.o(253506);
    }
    
    public static bcf b(bcu parambcu)
    {
      AppMethodBeat.i(253521);
      p.h(parambcu, "card");
      LinkedList localLinkedList1 = new LinkedList();
      LinkedList localLinkedList2 = new LinkedList();
      Object localObject = parambcu.object;
      p.g(localObject, "card.`object`");
      localObject = (Iterable)localObject;
      int i = 0;
      Iterator localIterator = ((Iterable)localObject).iterator();
      while (localIterator.hasNext())
      {
        localObject = localIterator.next();
        int j = i + 1;
        if (i < 0) {
          kotlin.a.j.hxH();
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
      parambcu = a(com.tencent.mm.ac.d.zs(parambcu.id), parambcu.IFO, parambcu.LLT, (List)localLinkedList1, (List)localLinkedList2, parambcu.tVe);
      AppMethodBeat.o(253521);
      return parambcu;
    }
    
    private final void b(final AppCompatActivity paramAppCompatActivity, final FinderItem paramFinderItem, final int paramInt)
    {
      AppMethodBeat.i(253508);
      Object localObject1 = y.vXH;
      if (!y.u(paramFinderItem.getFeedObject()))
      {
        paramFinderItem = y.vXH;
        paramFinderItem = (Context)paramAppCompatActivity;
        paramAppCompatActivity = paramAppCompatActivity.getString(2131760436);
        p.g(paramAppCompatActivity, "context.getString(R.stri…finder_private_ban_share)");
        y.aF(paramFinderItem, paramAppCompatActivity);
        AppMethodBeat.o(253508);
        return;
      }
      Log.i(TAG, "shareToConversation, id:" + paramFinderItem.getId() + ", pflag:" + paramFinderItem.getFeedObject().permissionFlag);
      if (paramFinderItem.getFeedObject().privateFlag == 1)
      {
        u.a((Context)paramAppCompatActivity, paramAppCompatActivity.getString(2131760442), (u.b)s.a.c.vWy);
        AppMethodBeat.o(253508);
        return;
      }
      e.Cxv.idkeyStat(1278L, 11L, 1L, false);
      localObject1 = com.tencent.mm.plugin.finder.spam.a.vwk;
      if (com.tencent.mm.plugin.finder.spam.a.avp("share"))
      {
        AppMethodBeat.o(253508);
        return;
      }
      localObject1 = new z.f();
      Object localObject2 = com.tencent.mm.ui.component.a.PRN;
      ((z.f)localObject1).SYG = ((FinderReporterUIC)com.tencent.mm.ui.component.a.b(paramAppCompatActivity).get(FinderReporterUIC.class)).dIx();
      localObject2 = new k.b();
      Object localObject3 = new com.tencent.mm.plugin.i.a.f();
      ((com.tencent.mm.plugin.i.a.f)localObject3).a(x(paramFinderItem));
      ((k.b)localObject2).a((com.tencent.mm.ag.f)localObject3);
      ((k.b)localObject2).type = 51;
      ((k.b)localObject2).title = MMApplicationContext.getContext().getString(2131762562);
      ((k.b)localObject2).url = MMApplicationContext.getContext().getString(2131762563);
      localObject3 = new Intent();
      ((Intent)localObject3).putExtra("Retr_Msg_Type", 18);
      ((Intent)localObject3).putExtra("Multi_Retr", true);
      ((Intent)localObject3).putExtra("Retr_Msg_content", k.b.a((k.b)localObject2, null, null));
      ((Intent)localObject3).putExtra("Retr_go_to_chattingUI", false);
      ((Intent)localObject3).putExtra("Retr_show_success_tips", true);
      if (paramAppCompatActivity == null)
      {
        paramAppCompatActivity = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
        AppMethodBeat.o(253508);
        throw paramAppCompatActivity;
      }
      com.tencent.mm.br.c.a((MMFragmentActivity)paramAppCompatActivity, ".ui.transmit.MsgRetransmitUI", (Intent)localObject3, 1001, (MMFragmentActivity.b)new d(this, paramFinderItem, paramAppCompatActivity, paramInt, (z.f)localObject1));
      AppMethodBeat.o(253508);
    }
    
    public static void b(MMActivity paramMMActivity, final String paramString1, final int paramInt1, final long paramLong, String paramString2, String paramString3, axt paramaxt, final int paramInt2, String paramString4, aoi paramaoi)
    {
      AppMethodBeat.i(253516);
      p.h(paramMMActivity, "context");
      Object localObject1 = com.tencent.mm.plugin.finder.spam.a.vwk;
      if (com.tencent.mm.plugin.finder.spam.a.avp("share"))
      {
        AppMethodBeat.o(253516);
        return;
      }
      Log.i(TAG, "share topic %s to sns", new Object[] { paramString1 });
      localObject1 = new Intent();
      Object localObject2;
      int i;
      if (paramInt1 == 7)
      {
        localObject2 = new com.tencent.mm.modelsns.b();
        ((com.tencent.mm.modelsns.b)localObject2).jld = a(paramString1, paramInt1, paramString2, paramString3, paramaxt, paramString4, paramaoi);
        paramString2 = (com.tencent.mm.modelsns.j)localObject2;
        switch (paramInt1)
        {
        case 5: 
        case 6: 
        default: 
          i = 18;
          label136:
          if (paramInt1 == 7) {
            ((Intent)localObject1).putExtra("ksnsupload_finder_activity_xml", paramString2.bfF());
          }
          break;
        }
      }
      for (;;)
      {
        ((Intent)localObject1).putExtra("Ksnsupload_type", i);
        ((Intent)localObject1).putExtra("need_result", true);
        com.tencent.mm.br.c.a(paramMMActivity, ".plugin.sns.ui.SnsUploadUI", (Intent)localObject1, 1002, (MMActivity.a)new m(paramMMActivity, paramInt1, paramLong, paramaoi, paramString1, paramInt2));
        AppMethodBeat.o(253516);
        return;
        localObject2 = new com.tencent.mm.modelsns.f();
        ((com.tencent.mm.modelsns.f)localObject2).jld = a(paramString1, paramInt1, paramString2, paramString3, paramaxt, paramString4, paramaoi);
        paramString2 = (com.tencent.mm.modelsns.j)localObject2;
        break;
        i = 22;
        break label136;
        i = 24;
        break label136;
        ((Intent)localObject1).putExtra("ksnsupload_finder_topic_xml", paramString2.bfF());
      }
    }
    
    public static bcj c(FinderItem paramFinderItem, boolean paramBoolean)
    {
      long l2 = 0L;
      AppMethodBeat.i(253512);
      p.h(paramFinderItem, "feedObject");
      Object localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
      int i = ((Number)com.tencent.mm.plugin.finder.storage.c.dss().value()).intValue();
      Log.i(TAG, "getFinderShareObject " + i + ' ' + paramFinderItem.getFeedObject().forward_style + ' ' + paramBoolean);
      bcj localbcj;
      Object localObject2;
      Object localObject3;
      Collection localCollection;
      label270:
      cjl localcjl;
      bch localbch;
      StringBuilder localStringBuilder;
      if ((paramBoolean) && (i != 1)) {
        if (i == 2)
        {
          localObject1 = "";
          localbcj = new bcj();
          localbcj.objectId = com.tencent.mm.ac.d.zs(paramFinderItem.getId());
          localbcj.objectNonceId = paramFinderItem.getObjectNonceId();
          localbcj.vXJ = paramFinderItem.getMediaType();
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
          localbcj.uNR = ((String)localObject2);
          localbcj.nickname = ((String)localObject1);
          localbcj.username = paramFinderItem.getUserName();
          localObject1 = i.vvu;
          localbcj.desc = i.auY(paramFinderItem.getDescription());
          localbcj.dJl = paramFinderItem.getMediaList().size();
          localObject3 = localbcj.mediaList;
          localObject1 = (Iterable)paramFinderItem.getMediaList();
          localCollection = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject1, 10));
          Iterator localIterator = ((Iterable)localObject1).iterator();
          if (!localIterator.hasNext()) {
            break label567;
          }
          localcjl = (cjl)localIterator.next();
          localbch = new bch();
          localbch.mediaType = localcjl.mediaType;
          localStringBuilder = new StringBuilder().append(localcjl.url);
          localObject2 = localcjl.url_token;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localbch.url = ((String)localObject1);
          if (Util.isNullOrNil(localcjl.coverUrl)) {
            break label511;
          }
          localStringBuilder = new StringBuilder().append(localcjl.coverUrl);
          localObject2 = localcjl.cover_url_token;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
        }
      }
      for (localbch.thumbUrl = ((String)localObject1);; localbch.thumbUrl = ((String)localObject1))
      {
        localbch.width = localcjl.width;
        localbch.height = localcjl.height;
        localbch.LLv = localcjl.videoDuration;
        localCollection.add(localbch);
        break label270;
        if (com.tencent.mm.ac.d.cW(paramFinderItem.getFeedObject().forward_style, 1))
        {
          localObject1 = "";
          break;
        }
        localObject1 = paramFinderItem.getNickName();
        break;
        localObject1 = paramFinderItem.getNickName();
        break;
        label511:
        localStringBuilder = new StringBuilder().append(localcjl.thumbUrl);
        localObject2 = localcjl.thumb_url_token;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
      }
      label567:
      ((LinkedList)localObject3).addAll((Collection)localCollection);
      if (!paramFinderItem.isPostFinish()) {}
      for (long l1 = paramFinderItem.getLocalId();; l1 = 0L)
      {
        localbcj.localId = l1;
        localObject1 = paramFinderItem.getMegaVideo();
        l1 = l2;
        if (localObject1 != null) {
          l1 = ((cng)localObject1).id;
        }
        localbcj.LLw = com.tencent.mm.ac.d.zs(l1);
        paramFinderItem = paramFinderItem.getMegaVideo();
        if (paramFinderItem != null)
        {
          localObject1 = paramFinderItem.LOd;
          paramFinderItem = (FinderItem)localObject1;
          if (localObject1 != null) {}
        }
        else
        {
          paramFinderItem = "";
        }
        localbcj.LLx = paramFinderItem;
        AppMethodBeat.o(253512);
        return localbcj;
      }
    }
    
    public static String getTAG()
    {
      return TAG;
    }
    
    private static axf y(FinderItem paramFinderItem)
    {
      AppMethodBeat.i(253519);
      axf localaxf = new axf();
      localaxf.feedId = com.tencent.mm.ac.d.zs(paramFinderItem.getId());
      Object localObject = paramFinderItem.getLiveInfo();
      long l;
      if (localObject != null)
      {
        l = ((awe)localObject).liveId;
        localaxf.hJs = com.tencent.mm.ac.d.zs(l);
        localaxf.username = paramFinderItem.field_username;
        localaxf.nickName = paramFinderItem.getNickName();
        localObject = i.vvu;
        localaxf.desc = i.auY(paramFinderItem.getDescription());
        localObject = (CharSequence)((cjl)paramFinderItem.getLiveMediaList().getFirst()).coverUrl;
        if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
          break label292;
        }
        i = 1;
        label123:
        if (i == 0) {
          break label297;
        }
        localObject = p.I(((cjl)paramFinderItem.getLiveMediaList().getFirst()).thumbUrl, Util.nullAsNil(((cjl)paramFinderItem.getLiveMediaList().getFirst()).thumb_url_token));
        label161:
        localaxf.coverUrl = ((String)localObject);
        localaxf.width = ((cjl)paramFinderItem.getLiveMediaList().getFirst()).width;
        localaxf.height = ((cjl)paramFinderItem.getLiveMediaList().getFirst()).height;
        localObject = paramFinderItem.getFeedObject().contact;
        if (localObject != null)
        {
          String str = ((FinderContact)localObject).headUrl;
          localObject = str;
          if (str != null) {}
        }
        else
        {
          localObject = "";
        }
        localaxf.headUrl = ((String)localObject);
        localaxf.objectNonceId = paramFinderItem.getFeedObject().objectNonceId;
        paramFinderItem = paramFinderItem.getLiveInfo();
        if (paramFinderItem == null) {
          break label315;
        }
      }
      label292:
      label297:
      label315:
      for (int i = paramFinderItem.liveStatus;; i = 1)
      {
        localaxf.liveStatus = i;
        AppMethodBeat.o(253519);
        return localaxf;
        l = 0L;
        break;
        i = 0;
        break label123;
        localObject = ((cjl)paramFinderItem.getLiveMediaList().getFirst()).coverUrl;
        break label161;
      }
    }
    
    public final void a(AppCompatActivity paramAppCompatActivity, FinderItem paramFinderItem, int paramInt)
    {
      AppMethodBeat.i(253504);
      p.h(paramAppCompatActivity, "context");
      p.h(paramFinderItem, "feedObject");
      switch (paramFinderItem.getMediaType())
      {
      default: 
        ((a)this).b(paramAppCompatActivity, paramFinderItem, paramInt);
        AppMethodBeat.o(253504);
        return;
      }
      ((a)this).a(paramAppCompatActivity, paramFinderItem);
      AppMethodBeat.o(253504);
    }
    
    public final void a(final MMActivity paramMMActivity, final com.tencent.mm.modelsns.c paramc, final bbn parambbn)
    {
      AppMethodBeat.i(253523);
      p.h(paramMMActivity, "context");
      p.h(paramc, "snsShare");
      Object localObject = com.tencent.mm.plugin.finder.spam.a.vwk;
      if (com.tencent.mm.plugin.finder.spam.a.avp("share"))
      {
        AppMethodBeat.o(253523);
        return;
      }
      Log.i(TAG, "[shareAlbumToSnsTimeLine] share album to sns. " + paramc.jle.title);
      localObject = new Intent();
      ((Intent)localObject).putExtra("ksnsupload_finder_album_xml", paramc.bfF());
      ((Intent)localObject).putExtra("Ksnsupload_type", 20);
      ((Intent)localObject).putExtra("need_result", true);
      com.tencent.mm.br.c.a(paramMMActivity, ".plugin.sns.ui.SnsUploadUI", (Intent)localObject, 1002, (MMActivity.a)new b(this, paramMMActivity, paramc, parambbn));
      AppMethodBeat.o(253523);
    }
    
    public final void a(MMActivity paramMMActivity, final com.tencent.mm.plugin.i.a.d paramd, final bbn parambbn)
    {
      AppMethodBeat.i(253522);
      p.h(paramMMActivity, "context");
      p.h(paramd, "objectContent");
      Object localObject = com.tencent.mm.plugin.finder.spam.a.vwk;
      if (com.tencent.mm.plugin.finder.spam.a.avp("share"))
      {
        AppMethodBeat.o(253522);
        return;
      }
      localObject = new k.b();
      ((k.b)localObject).a((com.tencent.mm.ag.f)paramd);
      ((k.b)localObject).type = 73;
      ((k.b)localObject).title = MMApplicationContext.getContext().getString(2131762562);
      ((k.b)localObject).url = MMApplicationContext.getContext().getString(2131762563);
      Intent localIntent = new Intent();
      localIntent.putExtra("Retr_Msg_Type", 22);
      localIntent.putExtra("Multi_Retr", true);
      localIntent.putExtra("Retr_Msg_content", k.b.a((k.b)localObject, null, null));
      localIntent.putExtra("Retr_go_to_chattingUI", false);
      localIntent.putExtra("Retr_show_success_tips", true);
      com.tencent.mm.br.c.a(paramMMActivity, ".ui.transmit.MsgRetransmitUI", localIntent, 1001, (MMActivity.a)new a(this, paramd, parambbn));
      AppMethodBeat.o(253522);
    }
    
    public final void a(final MMActivity paramMMActivity, final String paramString1, final int paramInt1, final long paramLong, String paramString2, String paramString3, axt paramaxt, final int paramInt2, String paramString4, aoi paramaoi)
    {
      AppMethodBeat.i(253514);
      p.h(paramMMActivity, "context");
      Object localObject1 = com.tencent.mm.plugin.finder.spam.a.vwk;
      if (com.tencent.mm.plugin.finder.spam.a.avp("share"))
      {
        AppMethodBeat.o(253514);
        return;
      }
      localObject1 = new k.b();
      Object localObject2;
      int i;
      if (paramInt1 != 7)
      {
        localObject2 = new com.tencent.mm.plugin.i.a.h();
        ((com.tencent.mm.plugin.i.a.h)localObject2).a(a(paramString1, paramInt1, paramString2, paramString3, paramaxt, paramString4, null));
        paramString2 = (com.tencent.mm.ag.f)localObject2;
        ((k.b)localObject1).a(paramString2);
        switch (paramInt1)
        {
        case 5: 
        case 6: 
        default: 
          i = 59;
          label128:
          ((k.b)localObject1).type = i;
          ((k.b)localObject1).title = MMApplicationContext.getContext().getString(2131762562);
          ((k.b)localObject1).url = MMApplicationContext.getContext().getString(2131762563);
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
        com.tencent.mm.br.c.a(paramMMActivity, ".ui.transmit.MsgRetransmitUI", paramString2, 1001, (MMActivity.a)new l(this, paramString1, paramInt1, paramLong, paramaoi, paramMMActivity, paramInt2));
        AppMethodBeat.o(253514);
        return;
        ((k.b)localObject1).izD = 1;
        localObject2 = new com.tencent.mm.plugin.i.a.c();
        ((com.tencent.mm.plugin.i.a.c)localObject2).a(a(paramString1, paramInt1, paramString2, paramString3, paramaxt, paramString4, paramaoi));
        paramString2 = (com.tencent.mm.ag.f)localObject2;
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
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
    static final class a
      implements MMActivity.a
    {
      a(s.a parama, com.tencent.mm.plugin.i.a.d paramd, bbn parambbn) {}
      
      public final void d(int paramInt1, int paramInt2, Intent paramIntent)
      {
        AppMethodBeat.i(253492);
        if (paramInt2 == -1)
        {
          Object localObject = paramIntent.getStringArrayListExtra("SendMsgUsernames");
          paramIntent = (Intent)localObject;
          if (localObject == null) {
            paramIntent = new ArrayList(0);
          }
          localObject = Util.listToString((List)paramIntent, ";");
          com.tencent.mm.plugin.finder.report.k localk = com.tencent.mm.plugin.finder.report.k.vfA;
          long l = com.tencent.mm.ac.d.Ga(paramd.jle.cardId);
          p.g(localObject, "users");
          com.tencent.mm.plugin.finder.report.k.a(l, 3, 1L, (String)localObject, paramIntent.size(), parambbn);
          Log.i(s.a.getTAG(), "[shareAlbumToChat] " + paramd.jle.title + " to " + paramIntent);
          AppMethodBeat.o(253492);
          return;
        }
        paramIntent = com.tencent.mm.plugin.finder.report.k.vfA;
        com.tencent.mm.plugin.finder.report.k.a(com.tencent.mm.ac.d.Ga(paramd.jle.cardId), 3, 2L, "", 0L, parambbn);
        AppMethodBeat.o(253492);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
    static final class b
      implements MMActivity.a
    {
      b(s.a parama, MMActivity paramMMActivity, com.tencent.mm.modelsns.c paramc, bbn parambbn) {}
      
      public final void d(int paramInt1, int paramInt2, Intent paramIntent)
      {
        AppMethodBeat.i(253493);
        if (paramInt2 == -1)
        {
          Object localObject = paramIntent.getStringArrayListExtra("SendMsgUsernames");
          paramIntent = (Intent)localObject;
          if (localObject == null) {
            paramIntent = new ArrayList(0);
          }
          localObject = Util.listToString((List)paramIntent, ";");
          com.tencent.mm.ui.base.h.cA((Context)paramMMActivity, paramMMActivity.getString(2131755986));
          com.tencent.mm.plugin.finder.report.k localk = com.tencent.mm.plugin.finder.report.k.vfA;
          long l = com.tencent.mm.ac.d.Ga(paramc.jle.cardId);
          p.g(localObject, "users");
          com.tencent.mm.plugin.finder.report.k.a(l, 2, 1L, (String)localObject, paramIntent.size(), parambbn);
          Log.i(s.a.getTAG(), "[shareAlbumToSnsTimeLine] " + paramc.jle.title + " to " + paramIntent);
          AppMethodBeat.o(253493);
          return;
        }
        paramIntent = com.tencent.mm.plugin.finder.report.k.vfA;
        com.tencent.mm.plugin.finder.report.k.a(com.tencent.mm.ac.d.Ga(paramc.jle.cardId), 2, 2L, "", 0L, parambbn);
        AppMethodBeat.o(253493);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
    static final class d
      implements MMFragmentActivity.b
    {
      d(s.a parama, FinderItem paramFinderItem, AppCompatActivity paramAppCompatActivity, int paramInt, z.f paramf) {}
      
      public final void d(int paramInt1, int paramInt2, Intent paramIntent)
      {
        AppMethodBeat.i(253496);
        Object localObject = new ArrayList();
        if (paramInt2 == -1)
        {
          paramIntent = paramIntent.getStringArrayListExtra("SendMsgUsernames");
          p.g(paramIntent, "data.getStringArrayListE…sgRetr.KSendMsgUsernames)");
          Log.i(s.a.getTAG(), "share finderObject %d to %s", new Object[] { Long.valueOf(paramFinderItem.getId()), paramIntent });
          if (!((Collection)paramIntent).isEmpty())
          {
            paramInt1 = 1;
            if (paramInt1 == 0) {
              break label363;
            }
            localObject = com.tencent.mm.ui.component.a.PRN;
            localObject = FinderReporterUIC.b((FinderReporterUIC)com.tencent.mm.ui.component.a.b(paramAppCompatActivity).get(FinderReporterUIC.class));
            if (localObject == null) {
              break label226;
            }
            ((com.tencent.mm.plugin.finder.event.a)localObject).cZR().Eh(paramFinderItem.getId());
          }
        }
        label226:
        label363:
        for (;;)
        {
          label126:
          if (paramInt2 == -1) {}
          for (long l1 = 1L;; l1 = 2L)
          {
            if (paramFinderItem.getFromType() != 32768) {
              break label292;
            }
            localObject = com.tencent.mm.plugin.finder.report.k.vfA;
            localObject = new bm(paramFinderItem.getFeedObject());
            paramInt1 = paramInt;
            String str = Util.listToString((List)paramIntent, ";");
            p.g(str, "Util.listToString(toUsers, \";\")");
            com.tencent.mm.plugin.finder.report.k.a((bm)localObject, paramInt1, l1, str, (bbn)this.vWA.SYG, paramIntent.size());
            AppMethodBeat.o(253496);
            return;
            paramInt1 = 0;
            break;
            break label126;
            paramIntent = com.tencent.mm.ui.component.a.PRN;
            paramIntent = FinderReporterUIC.b((FinderReporterUIC)com.tencent.mm.ui.component.a.b(paramAppCompatActivity).get(FinderReporterUIC.class));
            if (paramIntent != null)
            {
              paramIntent.cZR().Ej(paramFinderItem.getId());
              paramIntent = (Intent)localObject;
              break label126;
            }
            paramIntent = (Intent)localObject;
            break label126;
          }
          localObject = com.tencent.mm.plugin.finder.report.k.vfA;
          long l2 = paramFinderItem.getId();
          paramInt1 = paramInt;
          localObject = Util.listToString((List)paramIntent, ";");
          p.g(localObject, "Util.listToString(toUsers, \";\")");
          com.tencent.mm.plugin.finder.report.k.a(l2, paramInt1, l1, (String)localObject, (bbn)this.vWA.SYG, paramIntent.size(), null, 64);
          AppMethodBeat.o(253496);
          return;
        }
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
    static final class e
      implements MMActivity.a
    {
      e(s.a parama, com.tencent.mm.plugin.finder.api.g paramg, z.d paramd) {}
      
      public final void d(int paramInt1, int paramInt2, Intent paramIntent)
      {
        AppMethodBeat.i(167898);
        Object localObject;
        FinderAuthInfo localFinderAuthInfo;
        if (paramInt2 == -1)
        {
          localObject = paramIntent.getStringArrayListExtra("SendMsgUsernames");
          Log.i(s.a.getTAG(), "share namecard %s(%s) to %s", new Object[] { this.tEr.getNickname(), this.tEr.getUsername(), localObject });
          p.g(localObject, "toUsers");
          if (((Collection)localObject).isEmpty()) {
            break label152;
          }
          paramInt1 = 1;
          if (paramInt1 != 0)
          {
            paramIntent = com.tencent.mm.plugin.finder.report.k.vfA;
            paramIntent = this.tEr.getUsername();
            localObject = Util.listToString((List)localObject, ",");
            p.g(localObject, "Util.listToString(toUsers, \",\")");
            localFinderAuthInfo = this.tEr.field_authInfo;
            if (localFinderAuthInfo == null) {
              break label157;
            }
          }
        }
        label152:
        label157:
        for (paramInt1 = localFinderAuthInfo.authIconType;; paramInt1 = 0)
        {
          com.tencent.mm.plugin.finder.report.k.j(paramIntent, (String)localObject, paramInt1, this.tNv.SYE);
          AppMethodBeat.o(167898);
          return;
          paramInt1 = 0;
          break;
        }
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
    static final class f
      implements MMActivity.a
    {
      f(s.a parama, FinderItem paramFinderItem, kotlin.g.a.b paramb) {}
      
      public final void d(int paramInt1, int paramInt2, Intent paramIntent)
      {
        AppMethodBeat.i(253497);
        ArrayList localArrayList = new ArrayList();
        if (paramInt2 == -1)
        {
          localArrayList = paramIntent.getStringArrayListExtra("SendMsgUsernames");
          p.g(localArrayList, "data.getStringArrayListE…sgRetr.KSendMsgUsernames)");
          Log.i(s.a.getTAG(), "share finderObject %d to %s", new Object[] { Long.valueOf(this.vST.getId()), localArrayList });
        }
        paramIntent = this.gWe;
        if (paramIntent != null)
        {
          paramIntent.invoke(localArrayList);
          AppMethodBeat.o(253497);
          return;
        }
        AppMethodBeat.o(253497);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
    static final class g
      implements MMFragmentActivity.b
    {
      g(s.a parama, FinderItem paramFinderItem) {}
      
      public final void d(int paramInt1, int paramInt2, Intent paramIntent)
      {
        AppMethodBeat.i(253498);
        new ArrayList();
        if (paramInt2 == -1)
        {
          paramIntent = paramIntent.getStringArrayListExtra("SendMsgUsernames");
          p.g(paramIntent, "data.getStringArrayListE…sgRetr.KSendMsgUsernames)");
          Log.i(s.a.getTAG(), "share finderObject %d to %s", new Object[] { Long.valueOf(paramFinderItem.getId()), paramIntent });
          if (!((Collection)paramIntent).isEmpty()) {}
          JSONObject localJSONObject;
          for (paramInt1 = 1;; paramInt1 = 0)
          {
            if (paramInt1 == 0) {
              break label270;
            }
            localJSONObject = new JSONObject();
            localObject = paramIntent.iterator();
            String str;
            for (paramIntent = ""; ((Iterator)localObject).hasNext(); paramIntent = paramIntent + str + ';') {
              str = (String)((Iterator)localObject).next();
            }
          }
          localObject = paramIntent;
          if (n.K(paramIntent, ";", false))
          {
            paramInt1 = paramIntent.length();
            if (paramIntent == null)
            {
              paramIntent = new t("null cannot be cast to non-null type java.lang.String");
              AppMethodBeat.o(253498);
              throw paramIntent;
            }
            localObject = paramIntent.substring(0, paramInt1 - 1);
            p.g(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
          }
          localJSONObject.put("1", localObject);
          paramIntent = com.tencent.mm.plugin.finder.report.live.k.vkd;
          com.tencent.mm.plugin.finder.report.live.k.a(s.c.vmT, localJSONObject.toString());
          AppMethodBeat.o(253498);
          return;
        }
        paramIntent = new JSONObject();
        paramIntent.put("3", "");
        Object localObject = com.tencent.mm.plugin.finder.report.live.k.vkd;
        com.tencent.mm.plugin.finder.report.live.k.a(s.c.vmT, paramIntent.toString());
        label270:
        AppMethodBeat.o(253498);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/utils/FinderShareUtil$Companion$shareLiveToSnsTimeLineInternal$1", "Lcom/tencent/mm/ui/MMFragmentActivity$IMMOnFragmentActivityResult;", "mmOnActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "plugin-finder_release"})
    public static final class h
      implements MMFragmentActivity.b
    {
      h(AppCompatActivity paramAppCompatActivity, BaseFinderFeed paramBaseFinderFeed) {}
      
      public final void d(int paramInt1, int paramInt2, Intent paramIntent)
      {
        AppMethodBeat.i(253499);
        if (paramInt2 == -1)
        {
          com.tencent.mm.ui.base.h.cA((Context)this.vao, this.vao.getString(2131755986));
          paramIntent = com.tencent.mm.ui.component.a.PRN;
          paramIntent = FinderReporterUIC.b((FinderReporterUIC)com.tencent.mm.ui.component.a.b(this.vao).get(FinderReporterUIC.class));
          if (paramIntent != null) {
            paramIntent.cZR().Ei(this.tEM.lT());
          }
          paramIntent = new JSONObject();
          paramIntent.put("2", "");
          localk = com.tencent.mm.plugin.finder.report.live.k.vkd;
          com.tencent.mm.plugin.finder.report.live.k.a(s.c.vmT, paramIntent.toString());
          AppMethodBeat.o(253499);
          return;
        }
        paramIntent = com.tencent.mm.ui.component.a.PRN;
        paramIntent = FinderReporterUIC.b((FinderReporterUIC)com.tencent.mm.ui.component.a.b(this.vao).get(FinderReporterUIC.class));
        if (paramIntent != null) {
          paramIntent.cZR().Ek(this.tEM.lT());
        }
        paramIntent = new JSONObject();
        paramIntent.put("4", "");
        com.tencent.mm.plugin.finder.report.live.k localk = com.tencent.mm.plugin.finder.report.live.k.vkd;
        com.tencent.mm.plugin.finder.report.live.k.a(s.c.vmT, paramIntent.toString());
        AppMethodBeat.o(253499);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
    public static final class i
      implements MMActivity.a
    {
      public i(s.a parama, com.tencent.mm.plugin.i.a.g paramg) {}
      
      public final void d(int paramInt1, int paramInt2, Intent paramIntent)
      {
        AppMethodBeat.i(253500);
        new ArrayList();
        if (paramInt2 == -1)
        {
          paramIntent = paramIntent.getStringArrayListExtra("SendMsgUsernames");
          p.g(paramIntent, "data.getStringArrayListE…sgRetr.KSendMsgUsernames)");
          Log.i(s.a.getTAG(), "share poi %s to %s", new Object[] { this.vWB.wDZ, paramIntent });
        }
        AppMethodBeat.o(253500);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/utils/FinderShareUtil$Companion$shareToSnsTimeLineInternal$2", "Lcom/tencent/mm/ui/MMFragmentActivity$IMMOnFragmentActivityResult;", "mmOnActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "plugin-finder_release"})
    public static final class k
      implements MMFragmentActivity.b
    {
      k(MMFragmentActivity paramMMFragmentActivity, BaseFinderFeed paramBaseFinderFeed, int paramInt, z.f paramf) {}
      
      public final void d(int paramInt1, int paramInt2, Intent paramIntent)
      {
        AppMethodBeat.i(253503);
        if (paramInt2 == -1)
        {
          com.tencent.mm.ui.base.h.cA((Context)this.vWD, this.vWD.getString(2131755986));
          paramIntent = com.tencent.mm.ui.component.a.PRN;
          paramIntent = FinderReporterUIC.b((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this.vWD).get(FinderReporterUIC.class));
          if (paramIntent != null) {
            paramIntent.cZR().Ei(this.tEM.lT());
          }
          if (paramInt2 != -1) {
            break label196;
          }
        }
        label196:
        for (long l = 1L;; l = 2L)
        {
          if (this.tEM.feedObject.getFromType() != 32768) {
            break label204;
          }
          paramIntent = com.tencent.mm.plugin.finder.report.k.vfA;
          com.tencent.mm.plugin.finder.report.k.a(new bm(this.tEM.feedObject.getFeedObject()), this.vWz, l, "", (bbn)this.vWA.SYG);
          AppMethodBeat.o(253503);
          return;
          paramIntent = com.tencent.mm.ui.component.a.PRN;
          paramIntent = FinderReporterUIC.b((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this.vWD).get(FinderReporterUIC.class));
          if (paramIntent == null) {
            break;
          }
          paramIntent.cZR().Ek(this.tEM.lT());
          break;
        }
        label204:
        paramIntent = com.tencent.mm.plugin.finder.report.k.vfA;
        com.tencent.mm.plugin.finder.report.k.a(this.tEM.feedObject.getId(), this.vWz, l, "", (bbn)this.vWA.SYG, 0L, this.tEM.feedObject, 32);
        AppMethodBeat.o(253503);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
    static final class l
      implements MMActivity.a
    {
      l(s.a parama, String paramString, int paramInt1, long paramLong, aoi paramaoi, MMActivity paramMMActivity, int paramInt2) {}
      
      public final void d(int paramInt1, int paramInt2, Intent paramIntent)
      {
        boolean bool2 = false;
        boolean bool1 = false;
        AppMethodBeat.i(167901);
        Object localObject = new ArrayList();
        if (paramInt2 == -1)
        {
          localObject = paramIntent.getStringArrayListExtra("SendMsgUsernames");
          p.g(localObject, "data.getStringArrayListE…sgRetr.KSendMsgUsernames)");
          Log.i(s.a.getTAG(), "share topic %s to %s", new Object[] { paramString1, localObject });
        }
        if (paramInt1 == 7)
        {
          paramIntent = com.tencent.mm.plugin.finder.report.k.vfA;
          if (paramInt2 == -1) {
            bool1 = true;
          }
          localObject = Util.listToString((List)localObject, ",");
          p.g(localObject, "Util.listToString(toUsers, \",\")");
          l = paramLong;
          paramIntent = paramMMActivity;
          if (paramIntent != null) {}
          for (paramIntent = paramIntent.LAp;; paramIntent = null)
          {
            com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.PRN;
            com.tencent.mm.plugin.finder.report.k.a(1, bool1, (String)localObject, l, paramIntent, ((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)paramInt2).get(FinderReporterUIC.class)).dIx());
            AppMethodBeat.o(167901);
            return;
          }
        }
        paramIntent = com.tencent.mm.plugin.finder.report.k.vfA;
        bool1 = bool2;
        if (paramInt2 == -1) {
          bool1 = true;
        }
        paramIntent = Util.nullAsNil(paramString1);
        p.g(paramIntent, "Util.nullAsNil(topic)");
        paramInt1 = paramInt1;
        long l = paramLong;
        localObject = Util.listToString((List)localObject, ",");
        p.g(localObject, "Util.listToString(toUsers, \",\")");
        com.tencent.mm.plugin.finder.report.k.a(1, bool1, paramIntent, paramInt1, l, (String)localObject);
        AppMethodBeat.o(167901);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/utils/FinderShareUtil$Companion$shareTopicToSnsTimeLine$1", "Lcom/tencent/mm/ui/MMActivity$IMMOnActivityResult;", "mmOnActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "plugin-finder_release"})
    public static final class m
      implements MMActivity.a
    {
      m(MMActivity paramMMActivity, int paramInt1, long paramLong, aoi paramaoi, String paramString, int paramInt2) {}
      
      public final void d(int paramInt1, int paramInt2, Intent paramIntent)
      {
        boolean bool2 = true;
        boolean bool1 = true;
        AppMethodBeat.i(167902);
        if (paramInt2 == -1) {
          com.tencent.mm.ui.base.h.cA((Context)this.tTu, this.tTu.getString(2131755986));
        }
        if (paramInt1 == 7)
        {
          paramIntent = com.tencent.mm.plugin.finder.report.k.vfA;
          long l;
          if (paramInt2 == -1)
          {
            l = paramLong;
            paramIntent = paramString1;
            if (paramIntent == null) {
              break label123;
            }
          }
          label123:
          for (paramIntent = paramIntent.LAp;; paramIntent = null)
          {
            com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.PRN;
            com.tencent.mm.plugin.finder.report.k.a(2, bool1, "", l, paramIntent, ((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this.tTu).get(FinderReporterUIC.class)).dIx());
            AppMethodBeat.o(167902);
            return;
            bool1 = false;
            break;
          }
        }
        paramIntent = com.tencent.mm.plugin.finder.report.k.vfA;
        if (paramInt2 == -1) {}
        for (bool1 = bool2;; bool1 = false)
        {
          paramIntent = Util.nullAsNil(paramInt2);
          p.g(paramIntent, "Util.nullAsNil(topic)");
          com.tencent.mm.plugin.finder.report.k.a(2, bool1, paramIntent, paramInt1, paramLong, "");
          AppMethodBeat.o(167902);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.s
 * JD-Core Version:    0.7.0.1
 */