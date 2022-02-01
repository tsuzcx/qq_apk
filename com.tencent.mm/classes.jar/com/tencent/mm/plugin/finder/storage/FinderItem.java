package com.tencent.mm.plugin.finder.storage;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.text.SpannableString;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import com.tencent.d.a.a.a.b.b.g;
import com.tencent.d.a.a.a.b.b.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.data.i;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.finder.utils.bo;
import com.tencent.mm.plugin.finder.utils.m.b;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderJumpInfo;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.asp;
import com.tencent.mm.protocal.protobuf.atq;
import com.tencent.mm.protocal.protobuf.atr;
import com.tencent.mm.protocal.protobuf.awf;
import com.tencent.mm.protocal.protobuf.axa;
import com.tencent.mm.protocal.protobuf.axn;
import com.tencent.mm.protocal.protobuf.axw;
import com.tencent.mm.protocal.protobuf.bbo;
import com.tencent.mm.protocal.protobuf.bbq;
import com.tencent.mm.protocal.protobuf.bby;
import com.tencent.mm.protocal.protobuf.bce;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.blf;
import com.tencent.mm.protocal.protobuf.bmr;
import com.tencent.mm.protocal.protobuf.boi;
import com.tencent.mm.protocal.protobuf.brb;
import com.tencent.mm.protocal.protobuf.brs;
import com.tencent.mm.protocal.protobuf.bxs;
import com.tencent.mm.protocal.protobuf.byx;
import com.tencent.mm.protocal.protobuf.dje;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.protocal.protobuf.djj;
import com.tencent.mm.protocal.protobuf.djq;
import com.tencent.mm.protocal.protobuf.dne;
import com.tencent.mm.protocal.protobuf.dnh;
import com.tencent.mm.protocal.protobuf.pu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.w.a.a.a.c;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "Lcom/tencent/mm/autogen/table/BaseFinderFeedItem;", "Ljava/io/Serializable;", "()V", "_clipListExt", "Ljava/util/LinkedList;", "bizInfo", "Lcom/tencent/mm/protocal/protobuf/BizInfoForFinder;", "getBizInfo", "()Lcom/tencent/mm/protocal/protobuf/BizInfoForFinder;", "setBizInfo", "(Lcom/tencent/mm/protocal/protobuf/BizInfoForFinder;)V", "value", "clipListExt", "getClipListExt", "()Ljava/util/LinkedList;", "setClipListExt", "(Ljava/util/LinkedList;)V", "", "commentCount", "getCommentCount", "()I", "setCommentCount", "(I)V", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "commentList", "getCommentList", "setCommentList", "comment_close", "getComment_close", "setComment_close", "copyObjectDescMedia", "Lcom/tencent/mm/protocal/protobuf/FinderMedia;", "getCopyObjectDescMedia", "createTime", "getCreateTime", "setCreateTime", "Lcom/tencent/mm/protocal/protobuf/FinderCustomFeedData;", "customData", "getCustomData", "()Lcom/tencent/mm/protocal/protobuf/FinderCustomFeedData;", "setCustomData", "(Lcom/tencent/mm/protocal/protobuf/FinderCustomFeedData;)V", "debugDescription", "", "getDebugDescription", "()Ljava/lang/String;", "descLayout", "Lcom/tencent/neattextview/textview/layout/ILayout;", "getDescLayout", "()Lcom/tencent/neattextview/textview/layout/ILayout;", "setDescLayout", "(Lcom/tencent/neattextview/textview/layout/ILayout;)V", "description", "getDescription", "setDescription", "(Ljava/lang/String;)V", "descriptionFullSpan", "Landroid/text/SpannableString;", "getDescriptionFullSpan", "()Landroid/text/SpannableString;", "setDescriptionFullSpan", "(Landroid/text/SpannableString;)V", "descriptionSpan", "getDescriptionSpan", "setDescriptionSpan", "ecSource", "getEcSource", "setEcSource", "Lcom/tencent/mm/protocal/protobuf/FinderExtendedReading;", "extReading", "getExtReading", "()Lcom/tencent/mm/protocal/protobuf/FinderExtendedReading;", "setExtReading", "(Lcom/tencent/mm/protocal/protobuf/FinderExtendedReading;)V", "favCount", "getFavCount", "setFavCount", "favFlag", "getFavFlag", "setFavFlag", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "feedObject", "getFeedObject", "()Lcom/tencent/mm/protocal/protobuf/FinderObject;", "setFeedObject", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "foldedFeedList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getFoldedFeedList", "()Ljava/util/List;", "foldedFeeds", "", "foldedLayout", "Lcom/tencent/mm/protocal/protobuf/FinderFoldedLayout;", "getFoldedLayout", "()Lcom/tencent/mm/protocal/protobuf/FinderFoldedLayout;", "setFoldedLayout", "(Lcom/tencent/mm/protocal/protobuf/FinderFoldedLayout;)V", "followCount", "getFollowCount", "setFollowCount", "forwardCount", "getForwardCount", "setForwardCount", "friendLikeCount", "getFriendLikeCount", "setFriendLikeCount", "fromType", "getFromType", "setFromType", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "halfVideoMediaExtList", "getHalfVideoMediaExtList", "setHalfVideoMediaExtList", "isLongVideo", "", "()Z", "isPreview", "setPreview", "(Z)V", "isRelatedItem", "setRelatedItem", "isReplaceLongVideoToNormal", "setReplaceLongVideoToNormal", "likeCount", "getLikeCount", "setLikeCount", "likeFlag", "getLikeFlag", "setLikeFlag", "likeList", "getLikeList", "setLikeList", "liveFinderMedia", "getLiveFinderMedia", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "setLiveFinderMedia", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;)V", "Lcom/tencent/mm/protocal/protobuf/FinderLiveInfo;", "liveInfo", "getLiveInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveInfo;", "setLiveInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveInfo;)V", "liveMediaList", "getLiveMediaList", "", "localId", "getLocalId", "()J", "setLocalId", "(J)V", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "location", "getLocation", "()Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "setLocation", "(Lcom/tencent/mm/protocal/protobuf/FinderLocation;)V", "longVideoMediaExtList", "getLongVideoMediaExtList", "setLongVideoMediaExtList", "longVideoMediaList", "getLongVideoMediaList", "setLongVideoMediaList", "mediaExtList", "getMediaExtList", "setMediaExtList", "mediaList", "getMediaList", "setMediaList", "mediaType", "getMediaType", "setMediaType", "Lcom/tencent/mm/protocal/protobuf/MegaVideo;", "megaVideo", "getMegaVideo", "()Lcom/tencent/mm/protocal/protobuf/MegaVideo;", "setMegaVideo", "(Lcom/tencent/mm/protocal/protobuf/MegaVideo;)V", "mentionListSelected", "getMentionListSelected", "setMentionListSelected", "nickName", "getNickName", "setNickName", "nickNameSpan", "getNickNameSpan", "setNickNameSpan", "objectNonceId", "getObjectNonceId", "setObjectNonceId", "posTriggerConfig", "Lcom/tencent/mm/plugin/finder/utils/FinderEnhanceUtils$PosTriggerConfig;", "getPosTriggerConfig", "()Lcom/tencent/mm/plugin/finder/utils/FinderEnhanceUtils$PosTriggerConfig;", "posTriggerConfig$delegate", "Lkotlin/Lazy;", "private_flag", "getPrivate_flag", "setPrivate_flag", "readCount", "getReadCount", "setReadCount", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "refObjectContact", "getRefObjectContact", "()Lcom/tencent/mm/protocal/protobuf/FinderContact;", "setRefObjectContact", "(Lcom/tencent/mm/protocal/protobuf/FinderContact;)V", "refObjectFlag", "getRefObjectFlag", "setRefObjectFlag", "refObjectId", "getRefObjectId", "setRefObjectId", "relatedFeedId", "getRelatedFeedId", "setRelatedFeedId", "showExtendLink", "getShowExtendLink", "setShowExtendLink", "stickyTime", "getStickyTime", "setStickyTime", "timestamps", "getTimestamps", "topicClickExtra", "Lcom/tencent/mm/plugin/finder/utils/ClickExtra;", "getTopicClickExtra", "()Lcom/tencent/mm/plugin/finder/utils/ClickExtra;", "setTopicClickExtra", "(Lcom/tencent/mm/plugin/finder/utils/ClickExtra;)V", "topicList", "Lcom/tencent/mm/plugin/finder/utils/TopicStringInfo;", "getTopicList", "userName", "getUserName", "setUserName", "convertFrom", "", "cu", "Landroid/database/Cursor;", "createDescSpanWithoutClick", "createDescriptionFullSpan", "createDescriptionFullSpan2", "fixMediaType", "obj", "getBizInfoByObject", "getCropInfo", "index", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getExpectId", "getFinderLive", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShareObject;", "getFinderObject", "getFirstJumpInfo", "Lcom/tencent/mm/protocal/protobuf/FinderJumpInfo;", "getFromAppExtInfo", "getFromAppId", "getId", "getJumpAttachments", "Lcom/tencent/mm/protocal/protobuf/FinderAttachment;", "getNotShareMsg", "getPostInfo", "Lcom/tencent/mm/protocal/protobuf/LocalFinderPostInfo;", "getUnsignedId", "info", "isCommentClose", "isEventClosed", "isEventExpired", "isLive", "isLiveFeed", "isMvFeed", "isNeedCrop", "isNeedVideoCompositionPlay", "isNotShare", "isNotShareConversation", "isNotShareSns", "isOldVersion", "isOnlySelfSee", "isPostFailed", "isPostFailedCanRetry", "isPostFinish", "isPostNoAuth", "isPrivate", "isReplayLiveFeed", "isUrlValid", "mediaExt", "mediaId", "setEventClosed", "setEventExpired", "setPostFailed", "setPostFailedAndNoAuth", "setPostFailedAndNotRetry", "errCode", "setPostFinish", "setPostInfo", "field_postinfo", "setPostWaiting", "trackDraftPost", "stage", "trackPost", "updateFinderObject", "svrFeed", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public class FinderItem
  extends com.tencent.mm.autogen.b.cn
  implements Serializable
{
  public static final a Companion;
  private static final String TAG;
  private static final int _2A;
  private static boolean debugOnlySelfSee;
  private static final IAutoDBItem.MAutoDBInfo info;
  private static final int layoutWidth;
  private static final MMNeat7extView preMeasuredTextView;
  private final LinkedList<FinderItem> _clipListExt;
  private pu bizInfo;
  private final LinkedList<FinderMedia> copyObjectDescMedia;
  private com.tencent.neattextview.textview.layout.a descLayout;
  private SpannableString descriptionFullSpan;
  private SpannableString descriptionSpan;
  private String ecSource;
  public FinderObject feedObject;
  private List<BaseFinderFeed> foldedFeeds;
  private axn foldedLayout;
  private int fromType;
  private boolean isPreview;
  private boolean isRelatedItem;
  private boolean isReplaceLongVideoToNormal;
  private dji liveFinderMedia;
  private int mediaType;
  private SpannableString nickNameSpan;
  private final j posTriggerConfig$delegate;
  private long relatedFeedId;
  private boolean showExtendLink;
  private final long timestamps;
  private com.tencent.mm.plugin.finder.utils.f topicClickExtra;
  private final List<bo> topicList;
  
  static
  {
    AppMethodBeat.i(167015);
    Companion = new a((byte)0);
    Object localObject = com.tencent.mm.autogen.b.cn.initAutoDBInfo(FinderItem.class);
    s.s(localObject, "initAutoDBInfo(FinderItem::class.java)");
    info = (IAutoDBItem.MAutoDBInfo)localObject;
    TAG = "Finder.FinderItem";
    _2A = (int)MMApplicationContext.getContext().getResources().getDimension(a.c.Edge_2A);
    layoutWidth = MMApplicationContext.getContext().getResources().getDisplayMetrics().widthPixels - (int)(2.5F * _2A);
    localObject = new MMNeat7extView(MMApplicationContext.getContext());
    ((MMNeat7extView)localObject).setMaxLines(2);
    ((MMNeat7extView)localObject).setTextSize(1, 15.0F);
    ((MMNeat7extView)localObject).setEllipsize(TextUtils.TruncateAt.END);
    preMeasuredTextView = (MMNeat7extView)localObject;
    AppMethodBeat.o(167015);
  }
  
  public FinderItem()
  {
    AppMethodBeat.i(167014);
    FinderObject localFinderObject = new FinderObject();
    localFinderObject.objectDesc = new FinderObjectDesc();
    Object localObject = localFinderObject.objectDesc;
    if (localObject != null) {
      ((FinderObjectDesc)localObject).location = new boi();
    }
    localObject = ah.aiuX;
    this.feedObject = localFinderObject;
    this.topicClickExtra = new com.tencent.mm.plugin.finder.utils.f(0L, 0, null, null, 14);
    this.posTriggerConfig$delegate = k.cm((kotlin.g.a.a)new f(this));
    this.timestamps = com.tencent.mm.model.cn.bDw();
    this.topicList = ((List)new ArrayList());
    this.copyObjectDescMedia = new LinkedList();
    this._clipListExt = new LinkedList();
    this.foldedFeeds = ((List)new ArrayList());
    AppMethodBeat.o(167014);
  }
  
  private final void fixMediaType(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(166979);
    Object localObject = aw.Gjk;
    int i = aw.G(paramFinderObject);
    paramFinderObject = paramFinderObject.objectDesc;
    if (paramFinderObject != null)
    {
      paramFinderObject = paramFinderObject.media;
      if (paramFinderObject != null)
      {
        paramFinderObject = ((Iterable)paramFinderObject).iterator();
        while (paramFinderObject.hasNext())
        {
          localObject = (FinderMedia)paramFinderObject.next();
          if (((FinderMedia)localObject).mediaType == 0) {
            ((FinderMedia)localObject).mediaType = i;
          }
        }
      }
    }
    AppMethodBeat.o(166979);
  }
  
  private final pu getBizInfoByObject(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(339053);
    paramFinderObject = paramFinderObject.contact;
    if (paramFinderObject == null)
    {
      AppMethodBeat.o(339053);
      return null;
    }
    paramFinderObject = c.b(paramFinderObject);
    AppMethodBeat.o(339053);
    return paramFinderObject;
  }
  
  private static final int getFinderLive$getChargeFlag(bip parambip)
  {
    AppMethodBeat.i(339062);
    if (((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).isReplayLive(parambip))
    {
      AppMethodBeat.o(339062);
      return 6;
    }
    if (((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).isChargeLive(parambip))
    {
      AppMethodBeat.o(339062);
      return 2;
    }
    if (parambip == null)
    {
      AppMethodBeat.o(339062);
      return 0;
    }
    parambip = parambip.ZSc;
    if (parambip == null)
    {
      AppMethodBeat.o(339062);
      return 0;
    }
    int i = parambip.ZGN;
    AppMethodBeat.o(339062);
    return i;
  }
  
  public void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(166984);
    s.u(paramCursor, "cu");
    super.convertFrom(paramCursor);
    FinderObject localFinderObject = this.field_finderObject;
    paramCursor = localFinderObject;
    if (localFinderObject == null) {
      paramCursor = new FinderObject();
    }
    setFeedObject(paramCursor);
    this.feedObject.username = z.bAW();
    paramCursor = aw.Gjk;
    this.mediaType = aw.G(this.feedObject);
    AppMethodBeat.o(166984);
  }
  
  public final SpannableString createDescSpanWithoutClick()
  {
    LinkedList localLinkedList = null;
    AppMethodBeat.i(339207);
    FinderObject localFinderObject = this.feedObject;
    com.tencent.mm.plugin.h localh = (com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
    Object localObject1 = localFinderObject.objectDesc;
    Object localObject3;
    Object localObject2;
    long l;
    List localList;
    Object localObject4;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject3 = this.descriptionSpan;
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = new SpannableString((CharSequence)"");
      }
      l = this.field_id;
      localList = this.topicList;
      localObject4 = localFinderObject.mentionedUserContact;
      localObject3 = localObject4;
      if (localObject4 == null) {
        localObject3 = new LinkedList();
      }
      localObject4 = localFinderObject.objectDesc;
      if (localObject4 != null) {
        break label194;
      }
    }
    for (;;)
    {
      localObject4 = localLinkedList;
      if (localLinkedList == null) {
        localObject4 = new LinkedList();
      }
      localObject1 = localh.a((String)localObject1, (SpannableString)localObject2, l, localList, (LinkedList)localObject3, (LinkedList)localObject4, (kotlin.g.a.m)FinderItem.b.FKL, (kotlin.g.a.b)FinderItem.c.FKM);
      AppMethodBeat.o(339207);
      return localObject1;
      localObject1 = ((FinderObjectDesc)localObject1).topic;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((bxs)localObject1).aagD;
      break;
      label194:
      localLinkedList = ((FinderObjectDesc)localObject4).mentionedUser;
    }
  }
  
  public final SpannableString createDescriptionFullSpan()
  {
    AppMethodBeat.i(339194);
    SpannableString localSpannableString = createDescriptionFullSpan2();
    this.descriptionFullSpan = localSpannableString;
    AppMethodBeat.o(339194);
    return localSpannableString;
  }
  
  public final SpannableString createDescriptionFullSpan2()
  {
    LinkedList localLinkedList = null;
    AppMethodBeat.i(339203);
    FinderObject localFinderObject = this.feedObject;
    com.tencent.mm.plugin.h localh = (com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
    Object localObject1 = localFinderObject.objectDesc;
    Object localObject3;
    Object localObject2;
    long l;
    List localList;
    Object localObject4;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject3 = this.descriptionSpan;
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = new SpannableString((CharSequence)"");
      }
      l = this.field_id;
      localList = this.topicList;
      localObject4 = localFinderObject.mentionedUserContact;
      localObject3 = localObject4;
      if (localObject4 == null) {
        localObject3 = new LinkedList();
      }
      localObject4 = localFinderObject.objectDesc;
      if (localObject4 != null) {
        break label204;
      }
    }
    for (;;)
    {
      localObject4 = localLinkedList;
      if (localLinkedList == null) {
        localObject4 = new LinkedList();
      }
      localObject1 = localh.a((String)localObject1, (SpannableString)localObject2, l, localList, (LinkedList)localObject3, (LinkedList)localObject4, (kotlin.g.a.m)new d(this), (kotlin.g.a.b)new e(this));
      AppMethodBeat.o(339203);
      return localObject1;
      localObject1 = ((FinderObjectDesc)localObject1).topic;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((bxs)localObject1).aagD;
      break;
      label204:
      localLinkedList = ((FinderObjectDesc)localObject4).mentionedUser;
    }
  }
  
  public final pu getBizInfo()
  {
    AppMethodBeat.i(339702);
    Object localObject = this.feedObject.contact;
    if (localObject == null)
    {
      AppMethodBeat.o(339702);
      return null;
    }
    localObject = c.b((FinderContact)localObject);
    AppMethodBeat.o(339702);
    return localObject;
  }
  
  public final LinkedList<FinderItem> getClipListExt()
  {
    AppMethodBeat.i(339542);
    if ((this._clipListExt.isEmpty()) && (this.field_clipList != null))
    {
      localObject = this.field_clipList.aaOX;
      if (localObject != null)
      {
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          bby localbby = (bby)((Iterator)localObject).next();
          LinkedList localLinkedList = this._clipListExt;
          s.s(localbby, "it");
          localLinkedList.add(a.a(localbby, 0L));
        }
      }
    }
    Object localObject = this._clipListExt;
    AppMethodBeat.o(339542);
    return localObject;
  }
  
  public final int getCommentCount()
  {
    return this.feedObject.commentCount;
  }
  
  public final LinkedList<FinderCommentInfo> getCommentList()
  {
    AppMethodBeat.i(166996);
    LinkedList localLinkedList = this.feedObject.commentList;
    s.s(localLinkedList, "feedObject.commentList");
    AppMethodBeat.o(166996);
    return localLinkedList;
  }
  
  public final int getComment_close()
  {
    return this.feedObject.commentClose;
  }
  
  public final LinkedList<FinderMedia> getCopyObjectDescMedia()
  {
    return this.copyObjectDescMedia;
  }
  
  public final int getCreateTime()
  {
    return this.feedObject.createtime;
  }
  
  public final long getCreateTime()
  {
    return this.field_createTime;
  }
  
  public final dji getCropInfo(int paramInt)
  {
    AppMethodBeat.i(167007);
    Object localObject = getMediaList();
    if (localObject == null)
    {
      AppMethodBeat.o(167007);
      return null;
    }
    localObject = (dji)kotlin.a.p.ae((List)localObject, paramInt);
    AppMethodBeat.o(167007);
    return localObject;
  }
  
  public final awf getCustomData()
  {
    return this.field_customData;
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final String getDebugDescription()
  {
    AppMethodBeat.i(339398);
    Object localObject = getDescription();
    int i = Math.min(((String)localObject).length(), 3);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(339398);
      throw ((Throwable)localObject);
    }
    localObject = ((String)localObject).substring(0, i);
    s.s(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    AppMethodBeat.o(339398);
    return localObject;
  }
  
  public final com.tencent.neattextview.textview.layout.a getDescLayout()
  {
    return this.descLayout;
  }
  
  public final String getDescription()
  {
    Object localObject = this.feedObject.objectDesc;
    if (localObject == null) {
      localObject = "";
    }
    String str;
    do
    {
      return localObject;
      str = ((FinderObjectDesc)localObject).description;
      localObject = str;
    } while (str != null);
    return "";
  }
  
  public final SpannableString getDescriptionFullSpan()
  {
    return this.descriptionFullSpan;
  }
  
  public final SpannableString getDescriptionSpan()
  {
    return this.descriptionSpan;
  }
  
  public final String getEcSource()
  {
    return this.ecSource;
  }
  
  public final long getExpectId()
  {
    AppMethodBeat.i(339166);
    if (this.field_id == 0L)
    {
      l = getLocalId();
      AppMethodBeat.o(339166);
      return l;
    }
    long l = this.field_id;
    AppMethodBeat.o(339166);
    return l;
  }
  
  public final axa getExtReading()
  {
    AppMethodBeat.i(167000);
    Object localObject = this.feedObject.objectDesc;
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = ((FinderObjectDesc)localObject).extReading)
    {
      localObject = new axa();
      ((axa)localObject).link = "";
      ((axa)localObject).title = "";
      AppMethodBeat.o(167000);
      return localObject;
    }
    AppMethodBeat.o(167000);
    return localObject;
  }
  
  public final int getFavCount()
  {
    return this.feedObject.favCount;
  }
  
  public final int getFavFlag()
  {
    return this.feedObject.favFlag;
  }
  
  public final FinderObject getFeedObject()
  {
    return this.feedObject;
  }
  
  public final bmr getFinderLive()
  {
    float f2 = 0.0F;
    AppMethodBeat.i(339957);
    bmr localbmr = new bmr();
    localbmr.feedId = d.hF(getId());
    Object localObject1 = getLiveInfo();
    long l;
    dji localdji;
    Object localObject2;
    if (localObject1 == null)
    {
      l = 0L;
      localbmr.liveId = d.hF(l);
      localbmr.username = this.field_username;
      localbmr.nickName = getNickName();
      localbmr.desc = ((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).Sp(getDescription());
      localdji = (dji)kotlin.a.p.oL((List)getLiveMediaList());
      if (localdji != null) {
        break label712;
      }
      localObject1 = null;
      localObject2 = localbmr;
      if (localObject1 != null) {
        break label872;
      }
      localObject1 = "";
    }
    label145:
    label158:
    label183:
    label215:
    label739:
    label872:
    for (;;)
    {
      ((bmr)localObject2).coverUrl = ((String)localObject1);
      float f1;
      int i;
      if (localdji == null)
      {
        f1 = 0.0F;
        localbmr.width = f1;
        if (localdji != null) {
          break label788;
        }
        f1 = f2;
        localbmr.height = f1;
        localObject1 = getFeedObject().contact;
        if (localObject1 != null) {
          break label797;
        }
        localObject1 = "";
        localbmr.headUrl = ((String)localObject1);
        localbmr.objectNonceId = getFeedObject().objectNonceId;
        localObject1 = getLiveInfo();
        if (localObject1 != null) {
          break label821;
        }
        i = 1;
        localbmr.liveStatus = i;
        localObject1 = getLiveInfo();
        if (localObject1 != null) {
          break label830;
        }
        i = -1;
        label234:
        localbmr.sourceType = i;
        localObject2 = getEcSource();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localbmr.ecSource = ((String)localObject1);
        localbmr.ZVl = getFinderLive$getChargeFlag(getLiveInfo());
        localObject1 = ((com.tencent.mm.plugin.findersdk.a.y)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.findersdk.a.y.class)).aAl(localbmr.username);
        if ((localObject1 != null) && ((localObject1 instanceof com.tencent.mm.plugin.finder.api.m)))
        {
          localObject2 = ((com.tencent.mm.plugin.finder.api.m)localObject1).field_authInfo;
          if (localObject2 != null) {
            break label839;
          }
          i = 0;
          localbmr.authIconType = i;
          localObject1 = ((com.tencent.mm.plugin.finder.api.m)localObject1).field_authInfo;
          if (localObject1 != null) {
            break label848;
          }
          localObject1 = "";
        }
      }
      for (;;)
      {
        localbmr.ZVk = ((String)localObject1);
        localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
        localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.emY();
        if (localObject1 != null)
        {
          localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
          if ((localObject1 != null) && (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject1).Ecg))
          {
            localbmr.mIJ = 4;
            localbmr.hUQ = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject1).hUQ;
            localbmr.mIK = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject1).mIK;
          }
        }
        localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
        localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.emY();
        if (localObject1 != null)
        {
          localObject1 = (e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(e.class);
          if (localObject1 != null)
          {
            i = ((e)localObject1).mIY;
            localObject2 = b.g.ahoC;
            if (i == b.g.a.jWh())
            {
              localbmr.ZVn = localbmr.nickName;
              localbmr.ZVo = localbmr.username;
              localbmr.eventId = String.valueOf(((e)localObject1).mIY);
              localbmr.ZVt = String.valueOf(((e)localObject1).mIZ);
              localbmr.ZVu = String.valueOf(((e)localObject1).mJa);
              localbmr.ZVv = String.valueOf(((e)localObject1).mJb);
              localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
              localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.emY();
              if (localObject1 != null)
              {
                localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.n)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.n.class);
                if (localObject1 != null)
                {
                  localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.n)localObject1).Ehf;
                  if (localObject1 != null)
                  {
                    Log.i(TAG, "fireAuthorInfo After Share AuthorId: " + ((brs)localObject1).ZVr + ", AuthorIndex: " + ((brs)localObject1).ZVq + ", byPassInfo: " + ((brs)localObject1).ZVp);
                    localbmr.ZVs = ((brs)localObject1).ZVs;
                    localbmr.ZVp = ((brs)localObject1).ZVp;
                    localbmr.ZVq = ((brs)localObject1).ZVq;
                    localbmr.ZVr = ((brs)localObject1).ZVr;
                  }
                }
              }
            }
          }
        }
        AppMethodBeat.o(339957);
        return localbmr;
        l = ((bip)localObject1).liveId;
        break;
        localObject1 = (CharSequence)localdji.coverUrl;
        if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
        {
          i = 1;
          if (i == 0) {
            break label769;
          }
        }
        for (localObject1 = s.X(localdji.thumbUrl, Util.nullAsNil(localdji.thumb_url_token));; localObject1 = localdji.coverUrl)
        {
          break;
          i = 0;
          break label739;
        }
        f1 = localdji.width;
        break label145;
        f1 = localdji.height;
        break label158;
        localObject2 = ((FinderContact)localObject1).headUrl;
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label183;
        }
        localObject1 = "";
        break label183;
        i = ((bip)localObject1).liveStatus;
        break label215;
        i = ((bip)localObject1).ZFJ;
        break label234;
        i = ((FinderAuthInfo)localObject2).authIconType;
        break label330;
        localObject2 = ((FinderAuthInfo)localObject1).authIconUrl;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
      }
    }
  }
  
  public final FinderObject getFinderObject()
  {
    return this.feedObject;
  }
  
  public final FinderJumpInfo getFirstJumpInfo()
  {
    AppMethodBeat.i(339993);
    Object localObject = (atq)kotlin.a.p.oL((List)getJumpAttachments());
    if (localObject == null)
    {
      AppMethodBeat.o(339993);
      return null;
    }
    localObject = ((atq)localObject).ZEh;
    if (localObject == null)
    {
      AppMethodBeat.o(339993);
      return null;
    }
    localObject = ((bce)localObject).ZNl;
    AppMethodBeat.o(339993);
    return localObject;
  }
  
  public final List<BaseFinderFeed> getFoldedFeedList()
  {
    AppMethodBeat.i(339688);
    label48:
    label54:
    Object localObject2;
    if (Util.isNullOrNil(this.foldedFeeds))
    {
      localObject1 = getFoldedLayout();
      if (localObject1 != null) {
        break label94;
      }
      localObject1 = null;
      if (!Util.isNullOrNil((List)localObject1))
      {
        localObject1 = getFoldedLayout();
        if (localObject1 != null) {
          break label102;
        }
        localObject1 = null;
        if (localObject1 != null) {
          break label214;
        }
        localObject1 = null;
        localObject2 = this.foldedFeeds;
        if (localObject1 != null) {
          break label313;
        }
      }
    }
    label171:
    label313:
    for (Object localObject1 = (Collection)ab.aivy;; localObject1 = (Collection)localObject1)
    {
      ((List)localObject2).addAll((Collection)localObject1);
      localObject1 = this.foldedFeeds;
      AppMethodBeat.o(339688);
      return localObject1;
      label94:
      localObject1 = ((axn)localObject1).ZIQ;
      break;
      label102:
      localObject1 = ((axn)localObject1).ZIQ;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label48;
      }
      localObject1 = (Iterable)localObject1;
      localObject2 = (Collection)new ArrayList();
      Object localObject3 = ((Iterable)localObject1).iterator();
      label201:
      label204:
      while (((Iterator)localObject3).hasNext())
      {
        Object localObject4 = ((Iterator)localObject3).next();
        localObject1 = (FinderObject)localObject4;
        if (localObject1 == null)
        {
          localObject1 = null;
          if (localObject1 == null) {
            break label201;
          }
        }
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label204;
          }
          ((Collection)localObject2).add(localObject4);
          break;
          localObject1 = ((FinderObject)localObject1).objectDesc;
          break label171;
        }
      }
      localObject1 = (List)localObject2;
      break label48;
      label214:
      localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (FinderObject)((Iterator)localObject2).next();
        s.s(localObject3, "feed");
        localObject3 = a.e((FinderObject)localObject3, 1);
        ((Collection)localObject1).add(((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).a((FinderItem)localObject3));
      }
      localObject1 = (List)localObject1;
      break label54;
    }
  }
  
  public final axn getFoldedLayout()
  {
    return this.feedObject.foldedLayout;
  }
  
  public final int getFollowCount()
  {
    return this.feedObject.followCount;
  }
  
  public final int getForwardCount()
  {
    return this.feedObject.forwardCount;
  }
  
  public final int getFriendLikeCount()
  {
    return this.feedObject.friendLikeCount;
  }
  
  public final String getFromAppExtInfo()
  {
    Object localObject = this.feedObject.objectDesc;
    if (localObject == null) {
      localObject = "";
    }
    String str;
    do
    {
      return localObject;
      localObject = ((FinderObjectDesc)localObject).fromApp;
      if (localObject == null) {
        return "";
      }
      str = ((axw)localObject).ext_info;
      localObject = str;
    } while (str != null);
    return "";
  }
  
  public final String getFromAppId()
  {
    Object localObject = this.feedObject.objectDesc;
    if (localObject == null) {
      localObject = "";
    }
    String str;
    do
    {
      return localObject;
      localObject = ((FinderObjectDesc)localObject).fromApp;
      if (localObject == null) {
        return "";
      }
      str = ((axw)localObject).appid;
      localObject = str;
    } while (str != null);
    return "";
  }
  
  public final int getFromType()
  {
    return this.fromType;
  }
  
  public final LinkedList<dji> getHalfVideoMediaExtList()
  {
    AppMethodBeat.i(339524);
    Object localObject = this.field_halfMediaExtList;
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = ((djq)localObject).aaPD)
    {
      localObject = new LinkedList();
      AppMethodBeat.o(339524);
      return localObject;
    }
    AppMethodBeat.o(339524);
    return localObject;
  }
  
  public final long getId()
  {
    return this.field_id;
  }
  
  public final LinkedList<atq> getJumpAttachments()
  {
    AppMethodBeat.i(339985);
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = this.feedObject.attachmentList;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label159;
      }
    }
    label149:
    label159:
    for (localObject1 = (Collection)new LinkedList();; localObject1 = (Collection)localObject1)
    {
      localLinkedList.addAll((Collection)localObject1);
      AppMethodBeat.o(339985);
      return localLinkedList;
      localObject1 = ((atr)localObject1).ZEi;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      Object localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        if (((atq)localObject3).type == 3) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label149;
          }
          ((Collection)localObject1).add(localObject3);
          break;
        }
      }
      localObject1 = (List)localObject1;
      break;
    }
  }
  
  public final int getLikeCount()
  {
    return this.feedObject.likeCount;
  }
  
  public final int getLikeFlag()
  {
    return this.feedObject.likeFlag;
  }
  
  public final LinkedList<FinderCommentInfo> getLikeList()
  {
    AppMethodBeat.i(166994);
    LinkedList localLinkedList = this.feedObject.likeList;
    s.s(localLinkedList, "feedObject.likeList");
    AppMethodBeat.o(166994);
    return localLinkedList;
  }
  
  public final dji getLiveFinderMedia()
  {
    return this.liveFinderMedia;
  }
  
  public final bip getLiveInfo()
  {
    return this.feedObject.liveInfo;
  }
  
  public final LinkedList<dji> getLiveMediaList()
  {
    LinkedList localLinkedList = null;
    AppMethodBeat.i(339443);
    Object localObject = this.feedObject.objectDesc;
    if (localObject == null) {}
    while (localLinkedList == null)
    {
      localLinkedList = new LinkedList();
      AppMethodBeat.o(339443);
      return localLinkedList;
      localObject = ((FinderObjectDesc)localObject).media;
      if (localObject != null) {
        localLinkedList = i.aY((LinkedList)localObject);
      }
    }
    AppMethodBeat.o(339443);
    return localLinkedList;
  }
  
  public final long getLocalId()
  {
    return this.field_localId;
  }
  
  public final boi getLocation()
  {
    AppMethodBeat.i(166998);
    Object localObject = this.feedObject.objectDesc;
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = ((FinderObjectDesc)localObject).location)
    {
      localObject = new boi();
      ((boi)localObject).city = "";
      ((boi)localObject).poiName = "";
      AppMethodBeat.o(166998);
      return localObject;
    }
    AppMethodBeat.o(166998);
    return localObject;
  }
  
  public final LinkedList<dji> getLongVideoMediaExtList()
  {
    AppMethodBeat.i(339510);
    Object localObject = this.field_longVideoMediaExtList;
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = ((djq)localObject).aaPD)
    {
      localObject = new LinkedList();
      AppMethodBeat.o(339510);
      return localObject;
    }
    AppMethodBeat.o(339510);
    return localObject;
  }
  
  public final LinkedList<dji> getLongVideoMediaList()
  {
    AppMethodBeat.i(339499);
    if (getLongVideoMediaExtList().size() > 0)
    {
      localObject = getLongVideoMediaExtList();
      AppMethodBeat.o(339499);
      return localObject;
    }
    Object localObject = this.feedObject.attachmentList;
    if (localObject == null) {
      localObject = null;
    }
    while (localObject == null)
    {
      localObject = new LinkedList();
      AppMethodBeat.o(339499);
      return localObject;
      localObject = ((atr)localObject).ZEi;
      if (localObject == null)
      {
        localObject = null;
      }
      else
      {
        Iterator localIterator = ((Iterable)localObject).iterator();
        label87:
        int i;
        if (localIterator.hasNext())
        {
          localObject = localIterator.next();
          if (((atq)localObject).type == 1)
          {
            i = 1;
            label116:
            if (i == 0) {
              break label137;
            }
          }
        }
        for (;;)
        {
          localObject = (atq)localObject;
          if (localObject != null) {
            break label144;
          }
          localObject = null;
          break;
          i = 0;
          break label116;
          label137:
          break label87;
          localObject = null;
        }
        label144:
        localObject = ((atq)localObject).ZEf;
        if (localObject == null)
        {
          localObject = null;
        }
        else
        {
          localObject = ((byx)localObject).ZXx;
          if (localObject == null)
          {
            localObject = null;
          }
          else
          {
            localObject = ((dne)localObject).aaUt;
            if (localObject == null)
            {
              localObject = null;
            }
            else
            {
              localObject = ((dnh)localObject).media;
              if (localObject == null) {
                localObject = null;
              } else {
                localObject = i.aZ((LinkedList)localObject);
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(339499);
    return localObject;
  }
  
  public final LinkedList<dji> getMediaExtList()
  {
    AppMethodBeat.i(166991);
    Object localObject = this.field_mediaExtList;
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = ((djq)localObject).aaPD)
    {
      localObject = new LinkedList();
      AppMethodBeat.o(166991);
      return localObject;
    }
    AppMethodBeat.o(166991);
    return localObject;
  }
  
  public final LinkedList<dji> getMediaList()
  {
    Object localObject1 = null;
    AppMethodBeat.i(166989);
    if (this.mediaType == 9)
    {
      dji localdji;
      if (this.liveFinderMedia == null)
      {
        localdji = new dji();
        localObject1 = getFeedObject();
        if (localObject1 != null) {
          break label185;
        }
        localObject1 = "";
      }
      for (;;)
      {
        localdji.url = ((String)localObject1);
        localdji.mediaType = 9;
        localdji.thumbUrl = s.X(((dji)kotlin.a.p.oK((List)getLiveMediaList())).thumbUrl, Util.nullAsNil(((dji)kotlin.a.p.oK((List)getLiveMediaList())).thumb_url_token));
        localdji.videoDuration = 0;
        localdji.mediaId = MD5Util.getMD5String(localdji.url);
        localdji.width = 1000.0F;
        localdji.height = 1167.0F;
        localdji.md5sum = "";
        localdji.fileSize = 0;
        localdji.bitrate = 0;
        localObject1 = ah.aiuX;
        this.liveFinderMedia = localdji;
        localObject1 = new LinkedList();
        localObject2 = this.liveFinderMedia;
        if (localObject2 != null) {
          ((LinkedList)localObject1).add(localObject2);
        }
        AppMethodBeat.o(166989);
        return localObject1;
        label185:
        localObject1 = ((FinderObject)localObject1).liveInfo;
        if (localObject1 == null)
        {
          localObject1 = "";
        }
        else
        {
          localObject2 = ((bip)localObject1).mIE;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
        }
      }
    }
    if (getMediaExtList().size() > 0)
    {
      localObject1 = getMediaExtList();
      AppMethodBeat.o(166989);
      return localObject1;
    }
    Object localObject2 = this.feedObject.objectDesc;
    if (localObject2 == null) {}
    while (localObject1 == null)
    {
      localObject1 = new LinkedList();
      AppMethodBeat.o(166989);
      return localObject1;
      localObject2 = ((FinderObjectDesc)localObject2).media;
      if (localObject2 != null) {
        localObject1 = i.aY((LinkedList)localObject2);
      }
    }
    AppMethodBeat.o(166989);
    return localObject1;
  }
  
  public final int getMediaType()
  {
    return this.mediaType;
  }
  
  public final dne getMegaVideo()
  {
    AppMethodBeat.i(339263);
    Object localObject = this.feedObject.attachmentList;
    if (localObject == null)
    {
      AppMethodBeat.o(339263);
      return null;
    }
    localObject = ((atr)localObject).ZEi;
    if (localObject == null)
    {
      AppMethodBeat.o(339263);
      return null;
    }
    Iterator localIterator = ((Iterable)localObject).iterator();
    int i;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (((atq)localObject).type == 1)
      {
        i = 1;
        label82:
        if (i == 0) {
          break label106;
        }
      }
    }
    for (;;)
    {
      localObject = (atq)localObject;
      if (localObject != null) {
        break label113;
      }
      AppMethodBeat.o(339263);
      return null;
      i = 0;
      break label82;
      label106:
      break;
      localObject = null;
    }
    label113:
    localObject = ((atq)localObject).ZEf;
    if (localObject == null)
    {
      AppMethodBeat.o(339263);
      return null;
    }
    localObject = ((byx)localObject).ZXx;
    AppMethodBeat.o(339263);
    return localObject;
  }
  
  public final int getMentionListSelected()
  {
    return this.feedObject.mentionedListSelected;
  }
  
  public final String getNickName()
  {
    String str2 = this.feedObject.nickname;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final SpannableString getNickNameSpan()
  {
    return this.nickNameSpan;
  }
  
  public final String getNotShareMsg()
  {
    String str2 = this.feedObject.sendShareFavWording;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String getObjectNonceId()
  {
    String str2 = this.feedObject.objectNonceId;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final m.b getPosTriggerConfig()
  {
    AppMethodBeat.i(339147);
    m.b localb = (m.b)this.posTriggerConfig$delegate.getValue();
    AppMethodBeat.o(339147);
    return localb;
  }
  
  public final djj getPostInfo()
  {
    AppMethodBeat.i(167004);
    djj localdjj = this.field_postinfo;
    if (localdjj == null)
    {
      localdjj = new djj();
      AppMethodBeat.o(167004);
      return localdjj;
    }
    AppMethodBeat.o(167004);
    return localdjj;
  }
  
  public final int getPrivate_flag()
  {
    return this.feedObject.privateFlag;
  }
  
  public final int getReadCount()
  {
    return this.feedObject.readCount;
  }
  
  public final FinderContact getRefObjectContact()
  {
    AppMethodBeat.i(167002);
    FinderContact localFinderContact = this.feedObject.refObjectContact;
    if (localFinderContact == null)
    {
      localFinderContact = new FinderContact();
      AppMethodBeat.o(167002);
      return localFinderContact;
    }
    AppMethodBeat.o(167002);
    return localFinderContact;
  }
  
  public final long getRefObjectFlag()
  {
    return this.feedObject.refObjectFlag;
  }
  
  public final long getRefObjectId()
  {
    return this.feedObject.refObjectId;
  }
  
  public final long getRelatedFeedId()
  {
    return this.relatedFeedId;
  }
  
  public final boolean getShowExtendLink()
  {
    return this.showExtendLink;
  }
  
  public final int getStickyTime()
  {
    return this.feedObject.stickyTime;
  }
  
  public final long getTimestamps()
  {
    return this.timestamps;
  }
  
  public final com.tencent.mm.plugin.finder.utils.f getTopicClickExtra()
  {
    return this.topicClickExtra;
  }
  
  public final List<bo> getTopicList()
  {
    return this.topicList;
  }
  
  public final String getUnsignedId()
  {
    AppMethodBeat.i(339155);
    String str = d.hF(getId());
    AppMethodBeat.o(339155);
    return str;
  }
  
  public final String getUserName()
  {
    String str2 = this.feedObject.username;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String info()
  {
    AppMethodBeat.i(167012);
    StringBuilder localStringBuilder = new StringBuilder("id:").append(this.field_id).append(" username ").append(this.feedObject.username).append(" mediaType ").append(this.mediaType).append(" localFlag ").append(this.field_localFlag).append(" description ");
    String str = getDescription();
    if (str == null) {
      str = null;
    }
    for (;;)
    {
      str = str + " mediaList " + com.tencent.mm.ae.f.dg(getMediaList());
      AppMethodBeat.o(167012);
      return str;
      str = str.substring(0, Math.min(str.length(), 3));
      s.s(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    }
  }
  
  public final boolean isCommentClose()
  {
    return this.feedObject.commentClose == 1;
  }
  
  public final boolean isEventClosed()
  {
    return (this.field_localFlag & 0x10) != 0;
  }
  
  public final boolean isEventExpired()
  {
    return (this.field_localFlag & 0x20) != 0;
  }
  
  public final boolean isLive()
  {
    return this.mediaType == 9;
  }
  
  public final boolean isLiveFeed()
  {
    return this.mediaType == 9;
  }
  
  public final boolean isLongVideo()
  {
    AppMethodBeat.i(339558);
    if (!((Collection)getLongVideoMediaList()).isEmpty())
    {
      AppMethodBeat.o(339558);
      return true;
    }
    AppMethodBeat.o(339558);
    return false;
  }
  
  public final boolean isMvFeed()
  {
    return this.feedObject.objectType == 2;
  }
  
  public final boolean isNeedCrop(int paramInt)
  {
    AppMethodBeat.i(167008);
    dji localdji = getCropInfo(paramInt);
    if (localdji == null)
    {
      AppMethodBeat.o(167008);
      return false;
    }
    if (localdji.aaPf)
    {
      AppMethodBeat.o(167008);
      return true;
    }
    AppMethodBeat.o(167008);
    return false;
  }
  
  public final boolean isNeedVideoCompositionPlay(int paramInt)
  {
    AppMethodBeat.i(339766);
    dji localdji = getCropInfo(paramInt);
    aw localaw = aw.Gjk;
    if (!aw.i(localdji))
    {
      AppMethodBeat.o(339766);
      return true;
    }
    AppMethodBeat.o(339766);
    return false;
  }
  
  public final boolean isNotShare()
  {
    AppMethodBeat.i(339870);
    if ((isNotShareSns()) && (isNotShareConversation()))
    {
      AppMethodBeat.o(339870);
      return true;
    }
    AppMethodBeat.o(339870);
    return false;
  }
  
  public final boolean isNotShareConversation()
  {
    return ((this.feedObject.objectStatus & 0x1) != 0) || ((this.feedObject.objectStatus & 0x2) != 0) || ((this.feedObject.permissionFlag & 0x80) != 0);
  }
  
  public final boolean isNotShareSns()
  {
    return ((this.feedObject.objectStatus & 0x1) != 0) || ((this.feedObject.objectStatus & 0x2) != 0) || ((this.feedObject.permissionFlag & 0x1) != 0);
  }
  
  public final boolean isOldVersion()
  {
    return this.feedObject.secondaryShowFlag != 1;
  }
  
  public final boolean isOnlySelfSee()
  {
    if (debugOnlySelfSee) {}
    while ((this.feedObject.objectStatus & 0x1) != 0) {
      return true;
    }
    return false;
  }
  
  public final boolean isPostFailed()
  {
    return (this.field_localFlag & 0x2) != 0;
  }
  
  public final boolean isPostFailedCanRetry()
  {
    return (this.field_localFlag & 0x4) == 0;
  }
  
  public final boolean isPostFinish()
  {
    return (this.field_localFlag & 0x3) == 0;
  }
  
  public final boolean isPostNoAuth()
  {
    return (this.field_localFlag & 0x8) != 0;
  }
  
  public final boolean isPreview()
  {
    return this.isPreview;
  }
  
  public final boolean isPrivate()
  {
    return this.feedObject.privateFlag == 1;
  }
  
  public final boolean isRelatedItem()
  {
    return this.isRelatedItem;
  }
  
  public final boolean isReplaceLongVideoToNormal()
  {
    return this.isReplaceLongVideoToNormal;
  }
  
  public final boolean isReplayLiveFeed()
  {
    AppMethodBeat.i(339891);
    if (isLiveFeed())
    {
      Object localObject = this.feedObject.liveInfo;
      if (localObject != null)
      {
        localObject = ((bip)localObject).ZSc;
        if ((localObject == null) || (((blf)localObject).ZGN != 2)) {}
      }
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(339891);
        return true;
      }
    }
    AppMethodBeat.o(339891);
    return false;
  }
  
  public final boolean isUrlValid()
  {
    boolean bool2 = true;
    AppMethodBeat.i(339999);
    brb localbrb = this.feedObject.client_local_buffer;
    long l;
    boolean bool1;
    if (localbrb == null)
    {
      l = 0L;
      if (l != 0L) {
        break label122;
      }
      localbrb = this.feedObject.client_local_buffer;
      bool1 = bool2;
      if (localbrb != null)
      {
        localbrb.ZZf = com.tencent.mm.model.cn.bDw();
        bool1 = bool2;
      }
    }
    for (;;)
    {
      Log.i(TAG, "isUrlValid: isUrlValid = " + bool1 + ", feedRecTime = " + l + ", feedId = " + d.hF(getId()));
      AppMethodBeat.o(339999);
      return bool1;
      l = localbrb.ZZf;
      break;
      label122:
      bool1 = bool2;
      if (this.feedObject.urlValidDuration * 1000L + l <= com.tencent.mm.model.cn.bDw()) {
        bool1 = false;
      }
    }
  }
  
  public final dji mediaExt(String paramString)
  {
    AppMethodBeat.i(166993);
    s.u(paramString, "mediaId");
    Object localObject = this.field_mediaExtList;
    if (localObject == null)
    {
      AppMethodBeat.o(166993);
      return null;
    }
    localObject = ((djq)localObject).aaPD;
    if (localObject == null)
    {
      AppMethodBeat.o(166993);
      return null;
    }
    Iterator localIterator = ((Iterable)localObject).iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
    } while (!s.p(((dji)localObject).mediaId, paramString));
    for (paramString = (String)localObject;; paramString = null)
    {
      paramString = (dji)paramString;
      AppMethodBeat.o(166993);
      return paramString;
    }
  }
  
  public final void setBizInfo(pu parampu)
  {
    this.bizInfo = parampu;
  }
  
  public final void setClipListExt(LinkedList<FinderItem> paramLinkedList)
  {
    AppMethodBeat.i(339550);
    s.u(paramLinkedList, "value");
    this._clipListExt.clear();
    this._clipListExt.addAll((Collection)paramLinkedList);
    if (this.field_clipList == null) {
      this.field_clipList = new dje();
    }
    Object localObject1 = this.field_clipList;
    if (localObject1 != null)
    {
      localObject1 = ((dje)localObject1).aaOX;
      if (localObject1 != null) {
        ((LinkedList)localObject1).clear();
      }
    }
    paramLinkedList = ((Iterable)paramLinkedList).iterator();
    while (paramLinkedList.hasNext())
    {
      localObject1 = (FinderItem)paramLinkedList.next();
      Object localObject2 = this.field_clipList;
      if (localObject2 != null)
      {
        localObject2 = ((dje)localObject2).aaOX;
        if (localObject2 != null) {
          ((LinkedList)localObject2).add(a.r((FinderItem)localObject1));
        }
      }
    }
    AppMethodBeat.o(339550);
  }
  
  public final void setCommentCount(int paramInt)
  {
    AppMethodBeat.i(166987);
    Log.d("Finder.FinderItem", "setCommentCount " + this.feedObject.hashCode() + ", from:" + getCommentCount() + ", to:" + getCommentCount());
    this.feedObject.commentCount = paramInt;
    AppMethodBeat.o(166987);
  }
  
  public final void setCommentList(LinkedList<FinderCommentInfo> paramLinkedList)
  {
    AppMethodBeat.i(166997);
    s.u(paramLinkedList, "value");
    this.feedObject.commentList = paramLinkedList;
    AppMethodBeat.o(166997);
  }
  
  public final void setComment_close(int paramInt)
  {
    this.feedObject.commentClose = paramInt;
  }
  
  public final void setCreateTime(int paramInt)
  {
    this.feedObject.createtime = paramInt;
  }
  
  public final void setCustomData(awf paramawf)
  {
    this.field_customData = paramawf;
  }
  
  public final void setDescLayout(com.tencent.neattextview.textview.layout.a parama)
  {
    this.descLayout = parama;
  }
  
  public final void setDescription(String paramString)
  {
    AppMethodBeat.i(166988);
    s.u(paramString, "value");
    FinderObjectDesc localFinderObjectDesc = this.feedObject.objectDesc;
    if (localFinderObjectDesc != null) {
      localFinderObjectDesc.description = paramString;
    }
    this.descriptionSpan = com.tencent.mm.pluginsdk.ui.span.p.b(MMApplicationContext.getContext(), (CharSequence)paramString);
    this.descriptionFullSpan = this.descriptionSpan;
    Log.w(TAG, "unexpecting write!");
    AppMethodBeat.o(166988);
  }
  
  public final void setDescriptionFullSpan(SpannableString paramSpannableString)
  {
    this.descriptionFullSpan = paramSpannableString;
  }
  
  public final void setDescriptionSpan(SpannableString paramSpannableString)
  {
    this.descriptionSpan = paramSpannableString;
  }
  
  public final void setEcSource(String paramString)
  {
    this.ecSource = paramString;
  }
  
  public final void setEventClosed()
  {
    this.field_localFlag |= 0x10;
  }
  
  public final void setEventExpired()
  {
    this.field_localFlag |= 0x20;
  }
  
  public final void setExtReading(axa paramaxa)
  {
    AppMethodBeat.i(167001);
    s.u(paramaxa, "value");
    FinderObjectDesc localFinderObjectDesc = this.feedObject.objectDesc;
    if (localFinderObjectDesc != null) {
      localFinderObjectDesc.extReading = paramaxa;
    }
    AppMethodBeat.o(167001);
  }
  
  public final void setFavCount(int paramInt)
  {
    this.feedObject.favCount = paramInt;
  }
  
  public final void setFavFlag(int paramInt)
  {
    this.feedObject.favFlag = paramInt;
  }
  
  public final void setFeedObject(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(166980);
    s.u(paramFinderObject, "value");
    Object localObject1 = aw.Gjk;
    this.mediaType = aw.G(paramFinderObject);
    this.field_createTime = paramFinderObject.createtime;
    this.field_id = paramFinderObject.id;
    Object localObject2 = paramFinderObject.username;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.field_username = ((String)localObject1);
    fixMediaType(paramFinderObject);
    this.feedObject = paramFinderObject;
    this.field_finderObject = paramFinderObject;
    localObject1 = getBizInfoByObject(paramFinderObject);
    label101:
    Object localObject3;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label326;
      }
      localObject1 = paramFinderObject.nickname;
      if (this.fromType != 16) {
        break label347;
      }
      localObject3 = MMApplicationContext.getContext();
      localObject2 = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
      s.s(localObject2, "service(IFinderCommonService::class.java)");
      com.tencent.mm.plugin.h localh = (com.tencent.mm.plugin.h)localObject2;
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "";
      }
      this.nickNameSpan = com.tencent.mm.pluginsdk.ui.span.p.d((Context)localObject3, (CharSequence)localh.cm((String)localObject2, ""), 0.0F);
      localObject2 = MMApplicationContext.getContext();
      localObject3 = (com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
      paramFinderObject = paramFinderObject.objectDesc;
      if (paramFinderObject != null) {
        break label329;
      }
      paramFinderObject = "";
    }
    for (;;)
    {
      this.descriptionSpan = com.tencent.mm.pluginsdk.ui.span.p.b((Context)localObject2, (CharSequence)((com.tencent.mm.plugin.h)localObject3).Sp(paramFinderObject), 0.0F);
      this.descriptionFullSpan = createDescriptionFullSpan();
      float f = com.tencent.mm.cd.a.getScaleSize(MMApplicationContext.getContext());
      preMeasuredTextView.setTextSize(1, f * 15.0F);
      preMeasuredTextView.aZ((CharSequence)this.descriptionFullSpan);
      this.descLayout = preMeasuredTextView.pE(layoutWidth, 2147483647);
      if (this.fromType != 16) {
        this.descriptionSpan = com.tencent.mm.pluginsdk.ui.span.p.d(MMApplicationContext.getContext(), (CharSequence)String.valueOf(this.descriptionFullSpan), 0.0F);
      }
      AppMethodBeat.o(166980);
      return;
      localObject1 = ((pu)localObject1).YTl;
      break;
      label326:
      break label101;
      label329:
      localObject1 = paramFinderObject.description;
      paramFinderObject = (FinderObject)localObject1;
      if (localObject1 == null) {
        paramFinderObject = "";
      }
    }
    label347:
    localObject2 = MMApplicationContext.getContext();
    if (localObject1 == null)
    {
      localObject1 = "";
      label360:
      this.nickNameSpan = com.tencent.mm.pluginsdk.ui.span.p.b((Context)localObject2, (CharSequence)localObject1);
      localObject2 = MMApplicationContext.getContext();
      paramFinderObject = paramFinderObject.objectDesc;
      if (paramFinderObject != null) {
        break label410;
      }
      paramFinderObject = "";
    }
    for (;;)
    {
      this.descriptionSpan = com.tencent.mm.pluginsdk.ui.span.p.b((Context)localObject2, (CharSequence)paramFinderObject);
      break;
      break label360;
      label410:
      localObject1 = paramFinderObject.description;
      paramFinderObject = (FinderObject)localObject1;
      if (localObject1 == null) {
        paramFinderObject = "";
      }
    }
  }
  
  public final void setFoldedLayout(axn paramaxn)
  {
    this.foldedLayout = paramaxn;
  }
  
  public final void setFollowCount(int paramInt)
  {
    this.feedObject.followCount = paramInt;
  }
  
  public final void setForwardCount(int paramInt)
  {
    this.feedObject.forwardCount = paramInt;
  }
  
  public final void setFriendLikeCount(int paramInt)
  {
    this.feedObject.friendLikeCount = paramInt;
  }
  
  public final void setFromType(int paramInt)
  {
    this.fromType = paramInt;
  }
  
  public final void setHalfVideoMediaExtList(LinkedList<dji> paramLinkedList)
  {
    AppMethodBeat.i(339532);
    s.u(paramLinkedList, "value");
    if (this.field_halfMediaExtList == null) {
      this.field_halfMediaExtList = new djq();
    }
    this.field_halfMediaExtList.aaPD = paramLinkedList;
    AppMethodBeat.o(339532);
  }
  
  public final void setLikeCount(int paramInt)
  {
    this.feedObject.likeCount = paramInt;
  }
  
  public final void setLikeFlag(int paramInt)
  {
    this.feedObject.likeFlag = paramInt;
  }
  
  public final void setLikeList(LinkedList<FinderCommentInfo> paramLinkedList)
  {
    AppMethodBeat.i(166995);
    s.u(paramLinkedList, "value");
    this.feedObject.likeList = paramLinkedList;
    AppMethodBeat.o(166995);
  }
  
  public final void setLiveFinderMedia(dji paramdji)
  {
    this.liveFinderMedia = paramdji;
  }
  
  public final void setLiveInfo(bip parambip)
  {
    this.feedObject.liveInfo = parambip;
  }
  
  public final void setLocalId(long paramLong)
  {
    this.field_localId = paramLong;
  }
  
  public final void setLocation(boi paramboi)
  {
    AppMethodBeat.i(166999);
    s.u(paramboi, "value");
    FinderObjectDesc localFinderObjectDesc = this.feedObject.objectDesc;
    if (localFinderObjectDesc != null) {
      localFinderObjectDesc.location = paramboi;
    }
    AppMethodBeat.o(166999);
  }
  
  public final void setLongVideoMediaExtList(LinkedList<dji> paramLinkedList)
  {
    AppMethodBeat.i(339518);
    s.u(paramLinkedList, "value");
    if (this.field_longVideoMediaExtList == null) {
      this.field_longVideoMediaExtList = new djq();
    }
    this.field_longVideoMediaExtList.aaPD = paramLinkedList;
    AppMethodBeat.o(339518);
  }
  
  public final void setLongVideoMediaList(LinkedList<dji> paramLinkedList)
  {
    Object localObject2 = null;
    AppMethodBeat.i(339506);
    s.u(paramLinkedList, "value");
    Object localObject1 = this.feedObject.attachmentList;
    if (localObject1 == null) {
      localObject1 = localObject2;
    }
    do
    {
      if (localObject1 != null) {
        ((dnh)localObject1).media = com.tencent.mm.plugin.finder.storage.data.n.ba(paramLinkedList);
      }
      AppMethodBeat.o(339506);
      return;
      localObject3 = ((atr)localObject1).ZEi;
      localObject1 = localObject2;
    } while (localObject3 == null);
    Object localObject3 = ((Iterable)localObject3).iterator();
    label76:
    int i;
    if (((Iterator)localObject3).hasNext())
    {
      localObject1 = ((Iterator)localObject3).next();
      if (((atq)localObject1).type == 1)
      {
        i = 1;
        label107:
        if (i == 0) {
          break label167;
        }
      }
    }
    for (;;)
    {
      localObject3 = (atq)localObject1;
      localObject1 = localObject2;
      if (localObject3 == null) {
        break;
      }
      localObject3 = ((atq)localObject3).ZEf;
      localObject1 = localObject2;
      if (localObject3 == null) {
        break;
      }
      localObject3 = ((byx)localObject3).ZXx;
      localObject1 = localObject2;
      if (localObject3 == null) {
        break;
      }
      localObject1 = ((dne)localObject3).aaUt;
      break;
      i = 0;
      break label107;
      label167:
      break label76;
      localObject1 = null;
    }
  }
  
  public final void setMediaExtList(LinkedList<dji> paramLinkedList)
  {
    AppMethodBeat.i(166992);
    s.u(paramLinkedList, "value");
    if (this.field_mediaExtList == null) {
      this.field_mediaExtList = new djq();
    }
    this.field_mediaExtList.aaPD = paramLinkedList;
    AppMethodBeat.o(166992);
  }
  
  public final void setMediaList(LinkedList<dji> paramLinkedList)
  {
    AppMethodBeat.i(166990);
    s.u(paramLinkedList, "value");
    FinderObjectDesc localFinderObjectDesc = this.feedObject.objectDesc;
    if (localFinderObjectDesc != null)
    {
      s.u(paramLinkedList, "<this>");
      LinkedList localLinkedList = new LinkedList();
      Iterator localIterator = ((Iterable)paramLinkedList).iterator();
      while (localIterator.hasNext())
      {
        Object localObject1 = (dji)localIterator.next();
        s.u(localObject1, "<this>");
        FinderMedia localFinderMedia = new FinderMedia();
        localFinderMedia.url = ((dji)localObject1).url;
        localFinderMedia.thumbUrl = ((dji)localObject1).thumbUrl;
        localFinderMedia.mediaType = ((dji)localObject1).mediaType;
        localFinderMedia.videoDuration = ((dji)localObject1).videoDuration;
        localFinderMedia.width = ((dji)localObject1).width;
        localFinderMedia.height = ((dji)localObject1).height;
        localFinderMedia.md5sum = ((dji)localObject1).md5sum;
        localFinderMedia.fileSize = ((dji)localObject1).fileSize;
        localFinderMedia.bitrate = ((dji)localObject1).bitrate;
        Object localObject2 = localFinderMedia.spec;
        ((LinkedList)localObject2).clear();
        ((LinkedList)localObject2).addAll((Collection)((dji)localObject1).spec);
        localFinderMedia.coverUrl = ((dji)localObject1).coverUrl;
        localFinderMedia.decodeKey = ((dji)localObject1).decodeKey;
        localFinderMedia.url_token = ((dji)localObject1).url_token;
        localFinderMedia.thumb_url_token = ((dji)localObject1).thumb_url_token;
        localFinderMedia.cover_url_token = ((dji)localObject1).cover_url_token;
        localFinderMedia.codec_info = ((dji)localObject1).codec_info;
        localObject2 = new bbq();
        ((bbq)localObject2).ZMj.addAll((Collection)((dji)localObject1).aaPr);
        ah localah = ah.aiuX;
        localFinderMedia.hls_spec = ((bbq)localObject2);
        localFinderMedia.hot_flag = ((dji)localObject1).hot_flag;
        localFinderMedia.half_rect = ((dji)localObject1).aaPl;
        localFinderMedia.full_thumb_url = ((dji)localObject1).aaPi;
        localFinderMedia.full_thumb_url_token = ((dji)localObject1).aaPj;
        localFinderMedia.full_url = ((dji)localObject1).full_url;
        localFinderMedia.full_width = ((dji)localObject1).full_width;
        localFinderMedia.full_height = ((dji)localObject1).full_height;
        localFinderMedia.full_md5sum = ((dji)localObject1).full_md5sum;
        localFinderMedia.full_file_size = ((dji)localObject1).full_file_size;
        localFinderMedia.full_bitrate = ((dji)localObject1).full_bitrate;
        localObject1 = new bbo();
        ((bbo)localObject1).ZMf.addAll((Collection)((bbo)localObject1).ZMf);
        localObject2 = ah.aiuX;
        localFinderMedia.hdr_spec = ((bbo)localObject1);
        localLinkedList.add(localFinderMedia);
      }
      localFinderObjectDesc.media = localLinkedList;
    }
    if (this.feedObject.id == 0L) {
      setMediaExtList(paramLinkedList);
    }
    AppMethodBeat.o(166990);
  }
  
  public final void setMediaType(int paramInt)
  {
    this.mediaType = paramInt;
  }
  
  public final void setMegaVideo(dne paramdne)
  {
    Object localObject2 = null;
    AppMethodBeat.i(339267);
    Object localObject1 = this.feedObject.attachmentList;
    if (localObject1 == null) {
      localObject1 = localObject2;
    }
    do
    {
      if (localObject1 != null) {
        ((byx)localObject1).ZXx = paramdne;
      }
      AppMethodBeat.o(339267);
      return;
      localObject3 = ((atr)localObject1).ZEi;
      localObject1 = localObject2;
    } while (localObject3 == null);
    Object localObject3 = ((Iterable)localObject3).iterator();
    label66:
    int i;
    if (((Iterator)localObject3).hasNext())
    {
      localObject1 = ((Iterator)localObject3).next();
      if (((atq)localObject1).type == 1)
      {
        i = 1;
        label97:
        if (i == 0) {
          break label127;
        }
      }
    }
    for (;;)
    {
      localObject3 = (atq)localObject1;
      localObject1 = localObject2;
      if (localObject3 == null) {
        break;
      }
      localObject1 = ((atq)localObject3).ZEf;
      break;
      i = 0;
      break label97;
      label127:
      break label66;
      localObject1 = null;
    }
  }
  
  public final void setMentionListSelected(int paramInt)
  {
    this.feedObject.mentionedListSelected = paramInt;
  }
  
  public final void setNickName(String paramString)
  {
    AppMethodBeat.i(166985);
    s.u(paramString, "value");
    this.feedObject.nickname = paramString;
    this.nickNameSpan = com.tencent.mm.pluginsdk.ui.span.p.b(MMApplicationContext.getContext(), (CharSequence)paramString);
    AppMethodBeat.o(166985);
  }
  
  public final void setNickNameSpan(SpannableString paramSpannableString)
  {
    this.nickNameSpan = paramSpannableString;
  }
  
  public final void setObjectNonceId(String paramString)
  {
    AppMethodBeat.i(166983);
    s.u(paramString, "value");
    this.feedObject.objectNonceId = paramString;
    AppMethodBeat.o(166983);
  }
  
  public final void setPostFailed()
  {
    this.field_localFlag |= 0x2;
    this.field_localFlag &= 0xFFFFFFFE;
  }
  
  public final void setPostFailedAndNoAuth()
  {
    AppMethodBeat.i(167010);
    setPostFailed();
    this.field_localFlag |= 0x8;
    AppMethodBeat.o(167010);
  }
  
  public final void setPostFailedAndNotRetry(int paramInt)
  {
    AppMethodBeat.i(339786);
    setPostFailed();
    this.field_localFlag |= 0x4;
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(339786);
      return;
      setEventClosed();
      AppMethodBeat.o(339786);
      return;
      setEventExpired();
    }
  }
  
  public final void setPostFinish()
  {
    this.field_localFlag &= 0xFFFFFFFE;
    this.field_localFlag &= 0xFFFFFFFD;
  }
  
  public final void setPostInfo(djj paramdjj)
  {
    AppMethodBeat.i(167005);
    s.u(paramdjj, "field_postinfo");
    this.field_postinfo = paramdjj;
    AppMethodBeat.o(167005);
  }
  
  public final void setPostWaiting()
  {
    this.field_localFlag = 1;
  }
  
  public final void setPreview(boolean paramBoolean)
  {
    this.isPreview = paramBoolean;
  }
  
  public final void setPrivate_flag(int paramInt)
  {
    this.feedObject.privateFlag = paramInt;
  }
  
  public final void setReadCount(int paramInt)
  {
    this.feedObject.readCount = paramInt;
  }
  
  public final void setRefObjectContact(FinderContact paramFinderContact)
  {
    AppMethodBeat.i(167003);
    s.u(paramFinderContact, "value");
    this.feedObject.refObjectContact = paramFinderContact;
    AppMethodBeat.o(167003);
  }
  
  public final void setRefObjectFlag(long paramLong)
  {
    this.feedObject.refObjectFlag = paramLong;
  }
  
  public final void setRefObjectId(long paramLong)
  {
    this.feedObject.refObjectId = paramLong;
  }
  
  public final void setRelatedFeedId(long paramLong)
  {
    this.relatedFeedId = paramLong;
  }
  
  public final void setRelatedItem(boolean paramBoolean)
  {
    this.isRelatedItem = paramBoolean;
  }
  
  public final void setReplaceLongVideoToNormal(boolean paramBoolean)
  {
    this.isReplaceLongVideoToNormal = paramBoolean;
  }
  
  public final void setShowExtendLink(boolean paramBoolean)
  {
    this.showExtendLink = paramBoolean;
  }
  
  public final void setStickyTime(int paramInt)
  {
    this.feedObject.stickyTime = paramInt;
  }
  
  public final void setTopicClickExtra(com.tencent.mm.plugin.finder.utils.f paramf)
  {
    AppMethodBeat.i(339141);
    s.u(paramf, "<set-?>");
    this.topicClickExtra = paramf;
    AppMethodBeat.o(339141);
  }
  
  public final void setUserName(String paramString)
  {
    AppMethodBeat.i(166986);
    s.u(paramString, "value");
    this.feedObject.username = paramString;
    AppMethodBeat.o(166986);
  }
  
  public final void trackDraftPost(String paramString)
  {
    AppMethodBeat.i(339925);
    s.u(paramString, "stage");
    try
    {
      Object localObject1 = this.field_postinfo;
      if (localObject1 == null) {}
      for (localObject1 = null; localObject1 == null; localObject1 = ah.aiuX)
      {
        Log.i("Finder.DraftPostLog", "stage:" + paramString + " localId:" + getLocalId() + ", postInfo is null");
        AppMethodBeat.o(339925);
        return;
        String str = "localId:" + getLocalId() + ", localFlag:" + this.field_localFlag + ", uploadState:" + ((djj)localObject1).aaPu + ", tryCount:" + ((djj)localObject1).nrQ + ", utilNow:" + (com.tencent.mm.model.cn.bDu() - ((djj)localObject1).aaPx) + "ms, mediaProcessCost:" + ((djj)localObject1).aaPy + "ms, uploadCost:" + ((djj)localObject1).mnY + "ms, doSceneCost:" + ((djj)localObject1).aaPz + "ms, totalCost:" + ((djj)localObject1).Frl + "ms";
        localObject1 = "localId:" + getLocalId() + ", mediaList: ";
        Object localObject2 = (Iterable)getMediaExtList();
        int i = 0;
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = ((Iterator)localObject2).next();
          if (i < 0) {
            kotlin.a.p.kkW();
          }
          localObject3 = (dji)localObject3;
          localObject1 = (String)localObject1 + "Index" + i + ", fileSize:" + (float)com.tencent.mm.vfs.y.bEl(((dji)localObject3).url) / 1024.0F / 1024.0F + "MB, mediaType:" + ((dji)localObject3).mediaType + "; ";
          i += 1;
        }
        Log.i("Finder.DraftPostLog", "stage:" + paramString + ' ' + str);
        Log.i("Finder.DraftPostLog", "stage:" + paramString + ' ' + (String)localObject1);
      }
      AppMethodBeat.o(339925);
      return;
    }
    finally
    {
      Log.i("Finder.DraftPostLog", s.X("exception: ", paramString));
      AppMethodBeat.o(339925);
    }
  }
  
  public final void trackPost(String paramString)
  {
    AppMethodBeat.i(167013);
    s.u(paramString, "stage");
    try
    {
      Object localObject1 = this.field_postinfo;
      if (localObject1 == null) {}
      for (localObject1 = null; localObject1 == null; localObject1 = ah.aiuX)
      {
        Log.i("Finder.PostLog", "stage:" + paramString + " localId:" + getLocalId() + ", postInfo is null");
        AppMethodBeat.o(167013);
        return;
        String str = "localId:" + getLocalId() + ", localFlag:" + this.field_localFlag + ", uploadState:" + ((djj)localObject1).aaPu + ", tryCount:" + ((djj)localObject1).nrQ + ", utilNow:" + (com.tencent.mm.model.cn.bDu() - ((djj)localObject1).aaPx) + "ms, mediaProcessCost:" + ((djj)localObject1).aaPy + "ms, uploadCost:" + ((djj)localObject1).mnY + "ms, doSceneCost:" + ((djj)localObject1).aaPz + "ms, totalCost:" + ((djj)localObject1).Frl + "ms";
        localObject1 = "localId:" + getLocalId() + ", mediaList: ";
        Object localObject2 = (Iterable)getMediaExtList();
        int i = 0;
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = ((Iterator)localObject2).next();
          if (i < 0) {
            kotlin.a.p.kkW();
          }
          localObject3 = (dji)localObject3;
          localObject1 = (String)localObject1 + "Index" + i + ", fileSize:" + (float)com.tencent.mm.vfs.y.bEl(((dji)localObject3).url) / 1024.0F / 1024.0F + "MB, mediaType:" + ((dji)localObject3).mediaType + "; ";
          i += 1;
        }
        Log.i("Finder.PostLog", "stage:" + paramString + ' ' + str);
        Log.i("Finder.PostLog", "stage:" + paramString + ' ' + (String)localObject1);
      }
      AppMethodBeat.o(167013);
      return;
    }
    finally
    {
      Log.i("Finder.PostLog", s.X("exception: ", paramString));
      AppMethodBeat.o(167013);
    }
  }
  
  public final void updateFinderObject(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(167006);
    s.u(paramFinderObject, "svrFeed");
    this.field_username = paramFinderObject.username;
    this.field_finderObject = paramFinderObject;
    setFeedObject(paramFinderObject);
    this.field_id = paramFinderObject.id;
    this.field_createTime = paramFinderObject.createtime;
    AppMethodBeat.o(167006);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FinderItem$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "_2A", "", "get_2A", "()I", "debugOnlySelfSee", "", "getDebugOnlySelfSee", "()Z", "setDebugOnlySelfSee", "(Z)V", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "layoutWidth", "getLayoutWidth", "preMeasuredTextView", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "getPreMeasuredTextView", "()Lcom/tencent/mm/ui/widget/MMNeat7extView;", "create", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "feedObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "type", "genFinderItem", "finderObject", "feedPostingInfo", "Lcom/tencent/mm/protocal/protobuf/FeedPostingInfo;", "localId", "", "toFinderItem", "Lcom/tencent/mm/protocal/protobuf/FinderItemPb;", "toFinderItemPb", "toPostingInfo", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static FinderItem a(FinderObject paramFinderObject, asp paramasp, long paramLong)
    {
      AppMethodBeat.i(338865);
      s.u(paramFinderObject, "finderObject");
      FinderItem localFinderItem = new FinderItem();
      localFinderItem.setLocalId(paramLong);
      localFinderItem.setFeedObject(paramFinderObject);
      if (paramasp != null)
      {
        localFinderItem.field_localFlag = paramasp.pSb;
        localFinderItem.field_postinfo = paramasp.Gex;
        localFinderItem.field_mediaExtList = paramasp.ZCO;
        localFinderItem.field_reportObject = paramasp.ZCP;
        localFinderItem.field_postExtraData = paramasp.ZCQ;
        localFinderItem.field_customData = paramasp.ZCR;
        localFinderItem.field_longVideoMediaExtList = paramasp.ZCS;
        localFinderItem.field_halfMediaExtList = paramasp.ZCT;
        localFinderItem.field_clipList = paramasp.ZCU;
      }
      AppMethodBeat.o(338865);
      return localFinderItem;
    }
    
    public static FinderItem a(bby parambby, long paramLong)
    {
      AppMethodBeat.i(338847);
      s.u(parambby, "<this>");
      if (parambby.ABJ != null)
      {
        FinderObject localFinderObject2 = parambby.ABJ;
        FinderObject localFinderObject1 = localFinderObject2;
        if (localFinderObject2 == null) {
          localFinderObject1 = new FinderObject();
        }
        parambby = a(localFinderObject1, parambby.ZMH, paramLong);
        AppMethodBeat.o(338847);
        return parambby;
      }
      parambby = new FinderItem();
      AppMethodBeat.o(338847);
      return parambby;
    }
    
    public static FinderItem e(FinderObject paramFinderObject, int paramInt)
    {
      AppMethodBeat.i(166977);
      s.u(paramFinderObject, "feedObject");
      FinderItem localFinderItem = new FinderItem();
      localFinderItem.setFromType(paramInt);
      localFinderItem.setFeedObject(paramFinderObject);
      FinderObject localFinderObject;
      if ((Util.isNullOrNil(localFinderItem.getFeedObject().nickname)) && (localFinderItem.getFeedObject().contact != null))
      {
        paramFinderObject = localFinderItem.getFeedObject().contact;
        if (paramFinderObject != null) {
          break label107;
        }
        paramFinderObject = null;
        if (!Util.isNullOrNil(paramFinderObject))
        {
          localFinderObject = localFinderItem.getFeedObject();
          paramFinderObject = localFinderItem.getFeedObject().contact;
          if (paramFinderObject != null) {
            break label115;
          }
          paramFinderObject = "";
        }
      }
      for (;;)
      {
        localFinderObject.nickname = paramFinderObject;
        AppMethodBeat.o(166977);
        return localFinderItem;
        label107:
        paramFinderObject = paramFinderObject.nickname;
        break;
        label115:
        String str = paramFinderObject.nickname;
        paramFinderObject = str;
        if (str == null) {
          paramFinderObject = "";
        }
      }
    }
    
    public static IAutoDBItem.MAutoDBInfo eZl()
    {
      AppMethodBeat.i(338828);
      IAutoDBItem.MAutoDBInfo localMAutoDBInfo = FinderItem.access$getInfo$cp();
      AppMethodBeat.o(338828);
      return localMAutoDBInfo;
    }
    
    public static void eZm()
    {
      AppMethodBeat.i(338871);
      FinderItem.access$setDebugOnlySelfSee$cp(true);
      AppMethodBeat.o(338871);
    }
    
    public static bby r(FinderItem paramFinderItem)
    {
      AppMethodBeat.i(338857);
      s.u(paramFinderItem, "<this>");
      bby localbby = new bby();
      localbby.ABJ = paramFinderItem.getFeedObject();
      s.u(paramFinderItem, "<this>");
      asp localasp = new asp();
      localasp.pSb = paramFinderItem.field_localFlag;
      localasp.Gex = paramFinderItem.field_postinfo;
      localasp.ZCO = paramFinderItem.field_mediaExtList;
      localasp.ZCP = paramFinderItem.field_reportObject;
      localasp.ZCQ = paramFinderItem.field_postExtraData;
      localasp.ZCR = paramFinderItem.field_customData;
      localasp.ZCS = paramFinderItem.field_longVideoMediaExtList;
      localasp.ZCT = paramFinderItem.field_halfMediaExtList;
      localasp.ZCU = paramFinderItem.field_clipList;
      localbby.ZMH = localasp;
      AppMethodBeat.o(338857);
      return localbby;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "topic", "", "clickExtra", "Lcom/tencent/mm/plugin/finder/utils/ClickExtra;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.m<String, com.tencent.mm.plugin.finder.utils.f, ah>
  {
    d(FinderItem paramFinderItem)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "username", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.b<String, ah>
  {
    e(FinderItem paramFinderItem)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/utils/FinderEnhanceUtils$PosTriggerConfig;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<m.b>
  {
    f(FinderItem paramFinderItem)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.FinderItem
 * JD-Core Version:    0.7.0.1
 */