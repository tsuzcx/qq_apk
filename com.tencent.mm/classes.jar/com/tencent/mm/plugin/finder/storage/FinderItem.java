package com.tencent.mm.plugin.finder.storage;

import android.content.Context;
import android.database.Cursor;
import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.ae.g;
import com.tencent.mm.f.c.ci;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.data.i;
import com.tencent.mm.plugin.finder.storage.data.n;
import com.tencent.mm.plugin.finder.utils.ak;
import com.tencent.mm.plugin.finder.utils.ax;
import com.tencent.mm.plugin.finder.utils.c;
import com.tencent.mm.plugin.finder.utils.h.a;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.aow;
import com.tencent.mm.protocal.protobuf.apw;
import com.tencent.mm.protocal.protobuf.apx;
import com.tencent.mm.protocal.protobuf.arw;
import com.tencent.mm.protocal.protobuf.asl;
import com.tencent.mm.protocal.protobuf.asz;
import com.tencent.mm.protocal.protobuf.ati;
import com.tencent.mm.protocal.protobuf.awh;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bcp;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bkp;
import com.tencent.mm.protocal.protobuf.blj;
import com.tencent.mm.protocal.protobuf.csc;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.protocal.protobuf.csh;
import com.tencent.mm.protocal.protobuf.cso;
import com.tencent.mm.protocal.protobuf.cvy;
import com.tencent.mm.protocal.protobuf.cwc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.a.v;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "Lcom/tencent/mm/autogen/table/BaseFinderFeedItem;", "()V", "_clipListExt", "Ljava/util/LinkedList;", "value", "clipListExt", "getClipListExt", "()Ljava/util/LinkedList;", "setClipListExt", "(Ljava/util/LinkedList;)V", "", "commentCount", "getCommentCount", "()I", "setCommentCount", "(I)V", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "commentList", "getCommentList", "setCommentList", "comment_close", "getComment_close", "setComment_close", "copyObjectDescMedia", "Lcom/tencent/mm/protocal/protobuf/FinderMedia;", "getCopyObjectDescMedia", "createTime", "getCreateTime", "setCreateTime", "Lcom/tencent/mm/protocal/protobuf/FinderCustomFeedData;", "customData", "getCustomData", "()Lcom/tencent/mm/protocal/protobuf/FinderCustomFeedData;", "setCustomData", "(Lcom/tencent/mm/protocal/protobuf/FinderCustomFeedData;)V", "debugDescription", "", "getDebugDescription", "()Ljava/lang/String;", "description", "getDescription", "setDescription", "(Ljava/lang/String;)V", "descriptionFullSpan", "Landroid/text/SpannableString;", "getDescriptionFullSpan", "()Landroid/text/SpannableString;", "setDescriptionFullSpan", "(Landroid/text/SpannableString;)V", "descriptionSpan", "getDescriptionSpan", "setDescriptionSpan", "Lcom/tencent/mm/protocal/protobuf/FinderExtendedReading;", "extReading", "getExtReading", "()Lcom/tencent/mm/protocal/protobuf/FinderExtendedReading;", "setExtReading", "(Lcom/tencent/mm/protocal/protobuf/FinderExtendedReading;)V", "favCount", "getFavCount", "setFavCount", "favFlag", "getFavFlag", "setFavFlag", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "feedObject", "getFeedObject", "()Lcom/tencent/mm/protocal/protobuf/FinderObject;", "setFeedObject", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "foldedFeedList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getFoldedFeedList", "()Ljava/util/List;", "foldedFeeds", "", "foldedLayout", "Lcom/tencent/mm/protocal/protobuf/FinderFoldedLayout;", "getFoldedLayout", "()Lcom/tencent/mm/protocal/protobuf/FinderFoldedLayout;", "setFoldedLayout", "(Lcom/tencent/mm/protocal/protobuf/FinderFoldedLayout;)V", "forwardCount", "getForwardCount", "setForwardCount", "friendLikeCount", "getFriendLikeCount", "setFriendLikeCount", "fromType", "getFromType", "setFromType", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "halfVideoMediaExtList", "getHalfVideoMediaExtList", "setHalfVideoMediaExtList", "isLongVideo", "", "()Z", "isPreview", "setPreview", "(Z)V", "isRelatedItem", "setRelatedItem", "isReplaceLongVideoToNormal", "setReplaceLongVideoToNormal", "likeCount", "getLikeCount", "setLikeCount", "likeFlag", "getLikeFlag", "setLikeFlag", "likeList", "getLikeList", "setLikeList", "liveFinderMedia", "getLiveFinderMedia", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "setLiveFinderMedia", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;)V", "Lcom/tencent/mm/protocal/protobuf/FinderLiveInfo;", "liveInfo", "getLiveInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveInfo;", "setLiveInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveInfo;)V", "liveMediaList", "getLiveMediaList", "", "localId", "getLocalId", "()J", "setLocalId", "(J)V", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "location", "getLocation", "()Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "setLocation", "(Lcom/tencent/mm/protocal/protobuf/FinderLocation;)V", "longVideoMediaExtList", "getLongVideoMediaExtList", "setLongVideoMediaExtList", "longVideoMediaList", "getLongVideoMediaList", "setLongVideoMediaList", "mediaExtList", "getMediaExtList", "setMediaExtList", "mediaList", "getMediaList", "setMediaList", "mediaType", "getMediaType", "setMediaType", "Lcom/tencent/mm/protocal/protobuf/MegaVideo;", "megaVideo", "getMegaVideo", "()Lcom/tencent/mm/protocal/protobuf/MegaVideo;", "setMegaVideo", "(Lcom/tencent/mm/protocal/protobuf/MegaVideo;)V", "mentionListSelected", "getMentionListSelected", "setMentionListSelected", "nickName", "getNickName", "setNickName", "nickNameSpan", "getNickNameSpan", "setNickNameSpan", "objectNonceId", "getObjectNonceId", "setObjectNonceId", "posTriggerConfig", "Lcom/tencent/mm/plugin/finder/utils/FinderEnhanceUtils$PosTriggerConfig;", "getPosTriggerConfig", "()Lcom/tencent/mm/plugin/finder/utils/FinderEnhanceUtils$PosTriggerConfig;", "setPosTriggerConfig", "(Lcom/tencent/mm/plugin/finder/utils/FinderEnhanceUtils$PosTriggerConfig;)V", "private_flag", "getPrivate_flag", "setPrivate_flag", "readCount", "getReadCount", "setReadCount", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "refObjectContact", "getRefObjectContact", "()Lcom/tencent/mm/protocal/protobuf/FinderContact;", "setRefObjectContact", "(Lcom/tencent/mm/protocal/protobuf/FinderContact;)V", "refObjectFlag", "getRefObjectFlag", "setRefObjectFlag", "refObjectId", "getRefObjectId", "setRefObjectId", "relatedFeedId", "getRelatedFeedId", "setRelatedFeedId", "showExtendLink", "getShowExtendLink", "setShowExtendLink", "stickyTime", "getStickyTime", "setStickyTime", "timestamps", "getTimestamps", "topicClickExtra", "Lcom/tencent/mm/plugin/finder/utils/ClickExtra;", "getTopicClickExtra", "()Lcom/tencent/mm/plugin/finder/utils/ClickExtra;", "setTopicClickExtra", "(Lcom/tencent/mm/plugin/finder/utils/ClickExtra;)V", "topicList", "Lcom/tencent/mm/plugin/finder/utils/TopicStringInfo;", "getTopicList", "userName", "getUserName", "setUserName", "convertFrom", "", "cu", "Landroid/database/Cursor;", "createDescriptionFullSpan", "fixMediaType", "obj", "getCropInfo", "index", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getExpectId", "getFinderLive", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShareObject;", "getFinderObject", "getFromAppExtInfo", "getFromAppId", "getId", "getNotShareMsg", "getPostInfo", "Lcom/tencent/mm/protocal/protobuf/LocalFinderPostInfo;", "getUnsignedId", "info", "isCommentClose", "isEventClosed", "isEventExpired", "isLive", "isLiveFeed", "isMvFeed", "isNeedCrop", "isNeedVideoCompositionPlay", "isNotShare", "isOldVersion", "isOnlySelfSee", "isPostFailed", "isPostFailedCanRetry", "isPostFinish", "isPostNoAuth", "isPrivate", "mediaExt", "mediaId", "setEventClosed", "setEventExpired", "setPostFailed", "setPostFailedAndNoAuth", "setPostFailedAndNotRetry", "errCode", "setPostFinish", "setPostInfo", "field_postinfo", "setPostWaiting", "trackPost", "stage", "updateFinderObject", "svrFeed", "Companion", "plugin-finder-base_release"})
public class FinderItem
  extends ci
{
  public static final a Companion;
  private static final String TAG = "Finder.FinderItem";
  private static boolean debugOnlySelfSee;
  private static final IAutoDBItem.MAutoDBInfo info;
  private final LinkedList<FinderItem> _clipListExt;
  private final LinkedList<FinderMedia> copyObjectDescMedia;
  private SpannableString descriptionFullSpan;
  private SpannableString descriptionSpan;
  private FinderObject feedObject;
  private List<BaseFinderFeed> foldedFeeds;
  private asz foldedLayout;
  private int fromType;
  private boolean isPreview;
  private boolean isRelatedItem;
  private boolean isReplaceLongVideoToNormal;
  private csg liveFinderMedia;
  private int mediaType;
  private SpannableString nickNameSpan;
  private h.a posTriggerConfig;
  private long relatedFeedId;
  private boolean showExtendLink;
  private final long timestamps;
  private c topicClickExtra;
  private final List<ax> topicList;
  
  static
  {
    AppMethodBeat.i(167015);
    Companion = new a((byte)0);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = ci.initAutoDBInfo(FinderItem.class);
    p.j(localMAutoDBInfo, "initAutoDBInfo(FinderItem::class.java)");
    info = localMAutoDBInfo;
    TAG = "Finder.FinderItem";
    AppMethodBeat.o(167015);
  }
  
  public FinderItem()
  {
    AppMethodBeat.i(167014);
    FinderObject localFinderObject = new FinderObject();
    localFinderObject.objectDesc = new FinderObjectDesc();
    FinderObjectDesc localFinderObjectDesc = localFinderObject.objectDesc;
    if (localFinderObjectDesc != null) {
      localFinderObjectDesc.location = new bdm();
    }
    this.feedObject = localFinderObject;
    this.topicClickExtra = new c(0L);
    this.posTriggerConfig = new h.a(this.feedObject.posTriggerConfig);
    this.timestamps = cm.bfE();
    this.topicList = ((List)new ArrayList());
    this.copyObjectDescMedia = new LinkedList();
    this._clipListExt = new LinkedList();
    this.foldedFeeds = ((List)new ArrayList());
    AppMethodBeat.o(167014);
  }
  
  private final void fixMediaType(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(166979);
    Object localObject = ak.AGL;
    int i = ak.F(paramFinderObject);
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
        AppMethodBeat.o(166979);
        return;
      }
    }
    AppMethodBeat.o(166979);
  }
  
  public void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(166984);
    p.k(paramCursor, "cu");
    super.convertFrom(paramCursor);
    FinderObject localFinderObject = this.field_finderObject;
    paramCursor = localFinderObject;
    if (localFinderObject == null) {
      paramCursor = new FinderObject();
    }
    setFeedObject(paramCursor);
    this.feedObject.username = z.bdh();
    paramCursor = ak.AGL;
    this.mediaType = ak.F(this.feedObject);
    AppMethodBeat.o(166984);
  }
  
  public final SpannableString createDescriptionFullSpan()
  {
    AppMethodBeat.i(263919);
    Object localObject5 = this.feedObject;
    com.tencent.mm.plugin.b localb = (com.tencent.mm.plugin.b)h.ae(com.tencent.mm.plugin.b.class);
    Object localObject1 = ((FinderObject)localObject5).objectDesc;
    if (localObject1 != null)
    {
      localObject1 = ((FinderObjectDesc)localObject1).topic;
      if (localObject1 == null) {}
    }
    for (localObject1 = ((bkp)localObject1).SVC;; localObject1 = null)
    {
      Object localObject3 = this.descriptionSpan;
      Object localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = new SpannableString((CharSequence)"");
      }
      long l = this.field_id;
      List localList = this.topicList;
      Object localObject4 = ((FinderObject)localObject5).mentionedUserContact;
      localObject3 = localObject4;
      if (localObject4 == null) {
        localObject3 = new LinkedList();
      }
      localObject4 = ((FinderObject)localObject5).objectDesc;
      if (localObject4 != null)
      {
        localObject5 = ((FinderObjectDesc)localObject4).mentionedUser;
        localObject4 = localObject5;
        if (localObject5 != null) {}
      }
      else
      {
        localObject4 = new LinkedList();
      }
      localObject1 = localb.a((String)localObject1, (SpannableString)localObject2, l, localList, (LinkedList)localObject3, (LinkedList)localObject4, (m)new b(this), (kotlin.g.a.b)new c(this));
      AppMethodBeat.o(263919);
      return localObject1;
    }
  }
  
  public final LinkedList<FinderItem> getClipListExt()
  {
    AppMethodBeat.i(263931);
    if ((this._clipListExt.isEmpty()) && (this.field_clipList != null))
    {
      localObject = this.field_clipList.TzN;
      if (localObject != null)
      {
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          awh localawh = (awh)((Iterator)localObject).next();
          LinkedList localLinkedList = this._clipListExt;
          p.j(localawh, "it");
          localLinkedList.add(a.a(localawh, 0L));
        }
      }
    }
    Object localObject = this._clipListExt;
    AppMethodBeat.o(263931);
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
    p.j(localLinkedList, "feedObject.commentList");
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
  
  public final csg getCropInfo(int paramInt)
  {
    AppMethodBeat.i(167007);
    Object localObject = getMediaList();
    if (localObject != null)
    {
      localObject = (csg)j.M((List)localObject, paramInt);
      AppMethodBeat.o(167007);
      return localObject;
    }
    AppMethodBeat.o(167007);
    return null;
  }
  
  public final arw getCustomData()
  {
    return this.field_customData;
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final String getDebugDescription()
  {
    AppMethodBeat.i(263922);
    Object localObject = getDescription();
    int i = Math.min(((String)localObject).length(), 3);
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(263922);
      throw ((Throwable)localObject);
    }
    localObject = ((String)localObject).substring(0, i);
    p.j(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    AppMethodBeat.o(263922);
    return localObject;
  }
  
  public final String getDescription()
  {
    Object localObject = this.feedObject.objectDesc;
    if (localObject != null)
    {
      String str = ((FinderObjectDesc)localObject).description;
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    return localObject;
  }
  
  public final SpannableString getDescriptionFullSpan()
  {
    return this.descriptionFullSpan;
  }
  
  public final SpannableString getDescriptionSpan()
  {
    return this.descriptionSpan;
  }
  
  public final long getExpectId()
  {
    AppMethodBeat.i(263917);
    if (this.field_id == 0L)
    {
      l = getLocalId();
      AppMethodBeat.o(263917);
      return l;
    }
    long l = this.field_id;
    AppMethodBeat.o(263917);
    return l;
  }
  
  public final asl getExtReading()
  {
    AppMethodBeat.i(167000);
    Object localObject = this.feedObject.objectDesc;
    if (localObject != null)
    {
      asl localasl = ((FinderObjectDesc)localObject).extReading;
      localObject = localasl;
      if (localasl != null) {}
    }
    else
    {
      localObject = new asl();
      ((asl)localObject).link = "";
      ((asl)localObject).title = "";
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
  
  public final bcp getFinderLive()
  {
    float f2 = 0.0F;
    AppMethodBeat.i(263950);
    bcp localbcp = new bcp();
    localbcp.feedId = d.Fw(getId());
    Object localObject1 = getLiveInfo();
    long l;
    Object localObject2;
    int i;
    if (localObject1 != null)
    {
      l = ((bac)localObject1).liveId;
      localbcp.kwM = d.Fw(l);
      localbcp.username = this.field_username;
      localbcp.nickName = getNickName();
      localbcp.desc = ((com.tencent.mm.plugin.b)h.ae(com.tencent.mm.plugin.b.class)).aac(getDescription());
      localObject2 = (csg)j.lp((List)getLiveMediaList());
      if (localObject2 != null)
      {
        localObject1 = (CharSequence)((csg)localObject2).coverUrl;
        if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
          break label335;
        }
        i = 1;
        label145:
        if (i == 0) {
          break label340;
        }
        localObject1 = p.I(((csg)localObject2).thumbUrl, Util.nullAsNil(((csg)localObject2).thumb_url_token));
        label167:
        if (localObject1 != null) {
          break label365;
        }
      }
      localObject1 = "";
    }
    label195:
    label335:
    label340:
    label355:
    label360:
    label365:
    for (;;)
    {
      localbcp.coverUrl = ((String)localObject1);
      float f1;
      if (localObject2 != null)
      {
        f1 = ((csg)localObject2).width;
        localbcp.width = f1;
        f1 = f2;
        if (localObject2 != null) {
          f1 = ((csg)localObject2).height;
        }
        localbcp.height = f1;
        localObject1 = this.feedObject.contact;
        if (localObject1 != null)
        {
          localObject2 = ((FinderContact)localObject1).headUrl;
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = "";
        }
        localbcp.headUrl = ((String)localObject1);
        localbcp.objectNonceId = this.feedObject.objectNonceId;
        localObject1 = getLiveInfo();
        if (localObject1 == null) {
          break label355;
        }
        i = ((bac)localObject1).liveStatus;
        localbcp.liveStatus = i;
        localObject1 = getLiveInfo();
        if (localObject1 == null) {
          break label360;
        }
      }
      for (i = ((bac)localObject1).SEl;; i = -1)
      {
        localbcp.sourceType = i;
        AppMethodBeat.o(263950);
        return localbcp;
        l = 0L;
        break;
        i = 0;
        break label145;
        localObject1 = ((csg)localObject2).coverUrl;
        break label167;
        f1 = 0.0F;
        break label195;
        i = 1;
        break label291;
      }
    }
  }
  
  public final FinderObject getFinderObject()
  {
    return this.feedObject;
  }
  
  public final List<BaseFinderFeed> getFoldedFeedList()
  {
    AppMethodBeat.i(263936);
    Object localObject2;
    if (Util.isNullOrNil(this.foldedFeeds))
    {
      localObject1 = getFoldedLayout();
      Object localObject3;
      if (localObject1 != null)
      {
        localObject1 = ((asz)localObject1).SGi;
        if (Util.isNullOrNil((List)localObject1)) {
          break label285;
        }
        localObject1 = getFoldedLayout();
        if (localObject1 != null)
        {
          localObject1 = ((asz)localObject1).SGi;
          if (localObject1 != null)
          {
            localObject1 = (Iterable)localObject1;
            localObject2 = (Collection)new ArrayList();
            localObject3 = ((Iterable)localObject1).iterator();
          }
        }
      }
      else
      {
        label148:
        label151:
        for (;;)
        {
          label82:
          if (!((Iterator)localObject3).hasNext()) {
            break label153;
          }
          Object localObject4 = ((Iterator)localObject3).next();
          localObject1 = (FinderObject)localObject4;
          if (localObject1 != null)
          {
            localObject1 = ((FinderObject)localObject1).objectDesc;
            label116:
            if (localObject1 == null) {
              break label148;
            }
          }
          for (int i = 1;; i = 0)
          {
            if (i == 0) {
              break label151;
            }
            ((Collection)localObject2).add(localObject4);
            break label82;
            localObject1 = null;
            break;
            localObject1 = null;
            break label116;
          }
        }
        label153:
        localObject1 = (List)localObject2;
      }
      while (localObject1 != null)
      {
        localObject2 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (FinderObject)((Iterator)localObject2).next();
            p.j(localObject3, "feed");
            localObject3 = a.b((FinderObject)localObject3, 1);
            ((Collection)localObject1).add(((com.tencent.mm.plugin.b)h.ae(com.tencent.mm.plugin.b.class)).a((FinderItem)localObject3));
            continue;
            localObject1 = null;
            break;
          }
        }
        localObject1 = (List)localObject1;
        localObject2 = this.foldedFeeds;
        if (localObject1 == null) {
          break label303;
        }
      }
    }
    label285:
    label303:
    for (Object localObject1 = (Collection)localObject1;; localObject1 = (Collection)v.aaAd)
    {
      ((List)localObject2).addAll((Collection)localObject1);
      localObject1 = this.foldedFeeds;
      AppMethodBeat.o(263936);
      return localObject1;
      localObject1 = null;
      break;
    }
  }
  
  public final asz getFoldedLayout()
  {
    return this.feedObject.foldedLayout;
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
    AppMethodBeat.i(263952);
    Object localObject = this.feedObject.objectDesc;
    if (localObject != null)
    {
      localObject = ((FinderObjectDesc)localObject).fromApp;
      if (localObject != null)
      {
        String str = ((ati)localObject).MFj;
        localObject = str;
        if (str != null) {
          break label42;
        }
      }
    }
    localObject = "";
    label42:
    p.j(localObject, "feedObject.objectDesc?.fromApp?.ext_info ?: \"\"");
    AppMethodBeat.o(263952);
    return localObject;
  }
  
  public final String getFromAppId()
  {
    AppMethodBeat.i(263951);
    Object localObject = this.feedObject.objectDesc;
    if (localObject != null)
    {
      localObject = ((FinderObjectDesc)localObject).fromApp;
      if (localObject != null)
      {
        String str = ((ati)localObject).appid;
        localObject = str;
        if (str != null) {
          break label42;
        }
      }
    }
    localObject = "";
    label42:
    p.j(localObject, "feedObject.objectDesc?.fromApp?.appid ?: \"\"");
    AppMethodBeat.o(263951);
    return localObject;
  }
  
  public final int getFromType()
  {
    return this.fromType;
  }
  
  public final LinkedList<csg> getHalfVideoMediaExtList()
  {
    AppMethodBeat.i(263929);
    Object localObject = this.field_halfMediaExtList;
    if (localObject != null)
    {
      LinkedList localLinkedList = ((cso)localObject).TAp;
      localObject = localLinkedList;
      if (localLinkedList != null) {}
    }
    else
    {
      localObject = new LinkedList();
    }
    AppMethodBeat.o(263929);
    return localObject;
  }
  
  public final long getId()
  {
    return this.field_id;
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
    p.j(localLinkedList, "feedObject.likeList");
    AppMethodBeat.o(166994);
    return localLinkedList;
  }
  
  public final csg getLiveFinderMedia()
  {
    return this.liveFinderMedia;
  }
  
  public final bac getLiveInfo()
  {
    return this.feedObject.liveInfo;
  }
  
  public final LinkedList<csg> getLiveMediaList()
  {
    AppMethodBeat.i(263923);
    Object localObject = this.feedObject.objectDesc;
    if (localObject != null)
    {
      localObject = ((FinderObjectDesc)localObject).media;
      if (localObject != null)
      {
        localObject = i.aR((LinkedList)localObject);
        AppMethodBeat.o(263923);
        return localObject;
      }
    }
    localObject = new LinkedList();
    AppMethodBeat.o(263923);
    return localObject;
  }
  
  public final long getLocalId()
  {
    return this.field_localId;
  }
  
  public final bdm getLocation()
  {
    AppMethodBeat.i(166998);
    Object localObject = this.feedObject.objectDesc;
    if (localObject != null)
    {
      bdm localbdm = ((FinderObjectDesc)localObject).location;
      localObject = localbdm;
      if (localbdm != null) {}
    }
    else
    {
      localObject = new bdm();
      ((bdm)localObject).city = "";
      ((bdm)localObject).poiName = "";
    }
    AppMethodBeat.o(166998);
    return localObject;
  }
  
  public final LinkedList<csg> getLongVideoMediaExtList()
  {
    AppMethodBeat.i(263927);
    Object localObject = this.field_longVideoMediaExtList;
    if (localObject != null)
    {
      LinkedList localLinkedList = ((cso)localObject).TAp;
      localObject = localLinkedList;
      if (localLinkedList != null) {}
    }
    else
    {
      localObject = new LinkedList();
    }
    AppMethodBeat.o(263927);
    return localObject;
  }
  
  public final LinkedList<csg> getLongVideoMediaList()
  {
    AppMethodBeat.i(263925);
    if (getLongVideoMediaExtList().size() > 0)
    {
      localObject = getLongVideoMediaExtList();
      AppMethodBeat.o(263925);
      return localObject;
    }
    Object localObject = this.feedObject.attachmentList;
    if (localObject != null)
    {
      localObject = ((apx)localObject).SDm;
      if (localObject != null)
      {
        localObject = (apw)j.lp((List)localObject);
        if (localObject != null)
        {
          localObject = ((apw)localObject).SDl;
          if (localObject != null)
          {
            localObject = ((blj)localObject).SPm;
            if (localObject != null)
            {
              localObject = ((cvy)localObject).TEM;
              if (localObject != null)
              {
                localObject = ((cwc)localObject).media;
                if (localObject != null)
                {
                  localObject = i.aS((LinkedList)localObject);
                  AppMethodBeat.o(263925);
                  return localObject;
                }
              }
            }
          }
        }
      }
    }
    localObject = new LinkedList();
    AppMethodBeat.o(263925);
    return localObject;
  }
  
  public final LinkedList<csg> getMediaExtList()
  {
    AppMethodBeat.i(166991);
    Object localObject = this.field_mediaExtList;
    if (localObject != null)
    {
      LinkedList localLinkedList = ((cso)localObject).TAp;
      localObject = localLinkedList;
      if (localLinkedList != null) {}
    }
    else
    {
      localObject = new LinkedList();
    }
    AppMethodBeat.o(166991);
    return localObject;
  }
  
  public final LinkedList<csg> getMediaList()
  {
    AppMethodBeat.i(166989);
    if (this.mediaType == 9)
    {
      if (this.liveFinderMedia == null)
      {
        csg localcsg = new csg();
        localObject1 = this.feedObject;
        if (localObject1 != null)
        {
          localObject1 = ((FinderObject)localObject1).liveInfo;
          if (localObject1 != null)
          {
            localObject2 = ((bac)localObject1).kih;
            localObject1 = localObject2;
            if (localObject2 != null) {
              break label63;
            }
          }
        }
        localObject1 = "";
        label63:
        localcsg.url = ((String)localObject1);
        localcsg.mediaType = 9;
        localcsg.thumbUrl = p.I(((csg)j.lo((List)getLiveMediaList())).thumbUrl, Util.nullAsNil(((csg)j.lo((List)getLiveMediaList())).thumb_url_token));
        localcsg.videoDuration = 0;
        localcsg.mediaId = MD5Util.getMD5String(localcsg.url);
        localcsg.width = 1000.0F;
        localcsg.height = 1167.0F;
        localcsg.md5sum = "";
        localcsg.fileSize = 0;
        localcsg.bitrate = 0;
        this.liveFinderMedia = localcsg;
      }
      localObject1 = new LinkedList();
      Object localObject2 = this.liveFinderMedia;
      if (localObject2 != null) {
        ((LinkedList)localObject1).add(localObject2);
      }
      AppMethodBeat.o(166989);
      return localObject1;
    }
    if (getMediaExtList().size() > 0)
    {
      localObject1 = getMediaExtList();
      AppMethodBeat.o(166989);
      return localObject1;
    }
    Object localObject1 = this.feedObject.objectDesc;
    if (localObject1 != null)
    {
      localObject1 = ((FinderObjectDesc)localObject1).media;
      if (localObject1 != null)
      {
        localObject1 = i.aR((LinkedList)localObject1);
        AppMethodBeat.o(166989);
        return localObject1;
      }
    }
    localObject1 = new LinkedList();
    AppMethodBeat.o(166989);
    return localObject1;
  }
  
  public final int getMediaType()
  {
    return this.mediaType;
  }
  
  public final cvy getMegaVideo()
  {
    AppMethodBeat.i(263920);
    Object localObject = this.feedObject.attachmentList;
    if (localObject != null)
    {
      localObject = ((apx)localObject).SDm;
      if (localObject != null)
      {
        localObject = (apw)j.lp((List)localObject);
        if (localObject != null)
        {
          localObject = ((apw)localObject).SDl;
          if (localObject != null)
          {
            localObject = ((blj)localObject).SPm;
            AppMethodBeat.o(263920);
            return localObject;
          }
        }
      }
    }
    AppMethodBeat.o(263920);
    return null;
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
  
  public final h.a getPosTriggerConfig()
  {
    return this.posTriggerConfig;
  }
  
  public final csh getPostInfo()
  {
    AppMethodBeat.i(167004);
    csh localcsh2 = this.field_postinfo;
    csh localcsh1 = localcsh2;
    if (localcsh2 == null) {
      localcsh1 = new csh();
    }
    AppMethodBeat.o(167004);
    return localcsh1;
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
    FinderContact localFinderContact2 = this.feedObject.refObjectContact;
    FinderContact localFinderContact1 = localFinderContact2;
    if (localFinderContact2 == null) {
      localFinderContact1 = new FinderContact();
    }
    AppMethodBeat.o(167002);
    return localFinderContact1;
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
  
  public final c getTopicClickExtra()
  {
    return this.topicClickExtra;
  }
  
  public final List<ax> getTopicList()
  {
    return this.topicList;
  }
  
  public final String getUnsignedId()
  {
    AppMethodBeat.i(263916);
    String str = d.Fw(getId());
    AppMethodBeat.o(263916);
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
    Object localObject = getDescription();
    if (localObject != null)
    {
      int i = Math.min(((String)localObject).length(), 3);
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(167012);
        throw ((Throwable)localObject);
      }
      localObject = ((String)localObject).substring(0, i);
      p.j(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    }
    for (;;)
    {
      localObject = (String)localObject + " mediaList " + g.bN(getMediaList());
      AppMethodBeat.o(167012);
      return localObject;
      localObject = null;
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
    AppMethodBeat.i(263934);
    if (!((Collection)getLongVideoMediaList()).isEmpty())
    {
      AppMethodBeat.o(263934);
      return true;
    }
    AppMethodBeat.o(263934);
    return false;
  }
  
  public final boolean isMvFeed()
  {
    return this.feedObject.objectType == 2;
  }
  
  public final boolean isNeedCrop(int paramInt)
  {
    AppMethodBeat.i(167008);
    csg localcsg = getCropInfo(paramInt);
    if (localcsg == null)
    {
      AppMethodBeat.o(167008);
      return false;
    }
    if (localcsg.TzU)
    {
      AppMethodBeat.o(167008);
      return true;
    }
    AppMethodBeat.o(167008);
    return false;
  }
  
  public final boolean isNeedVideoCompositionPlay(int paramInt)
  {
    AppMethodBeat.i(263937);
    csg localcsg = getCropInfo(paramInt);
    ak localak = ak.AGL;
    if (!ak.g(localcsg))
    {
      AppMethodBeat.o(263937);
      return true;
    }
    AppMethodBeat.o(263937);
    return false;
  }
  
  public final boolean isNotShare()
  {
    return ((this.feedObject.objectStatus & 0x1) != 0) || ((this.feedObject.objectStatus & 0x2) != 0);
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
  
  public final csg mediaExt(String paramString)
  {
    AppMethodBeat.i(166993);
    p.k(paramString, "mediaId");
    Object localObject = this.field_mediaExtList;
    if (localObject != null)
    {
      localObject = ((cso)localObject).TAp;
      if (localObject != null)
      {
        Iterator localIterator = ((Iterable)localObject).iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = localIterator.next();
        } while (!p.h(((csg)localObject).mediaId, paramString));
        for (paramString = (String)localObject;; paramString = null)
        {
          paramString = (csg)paramString;
          AppMethodBeat.o(166993);
          return paramString;
        }
      }
    }
    AppMethodBeat.o(166993);
    return null;
  }
  
  public final void setClipListExt(LinkedList<FinderItem> paramLinkedList)
  {
    AppMethodBeat.i(263932);
    p.k(paramLinkedList, "value");
    this._clipListExt.clear();
    this._clipListExt.addAll((Collection)paramLinkedList);
    if (this.field_clipList == null) {
      this.field_clipList = new csc();
    }
    Object localObject1 = this.field_clipList;
    if (localObject1 != null)
    {
      localObject1 = ((csc)localObject1).TzN;
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
        localObject2 = ((csc)localObject2).TzN;
        if (localObject2 != null) {
          ((LinkedList)localObject2).add(a.m((FinderItem)localObject1));
        }
      }
    }
    AppMethodBeat.o(263932);
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
    p.k(paramLinkedList, "value");
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
  
  public final void setCustomData(arw paramarw)
  {
    this.field_customData = paramarw;
  }
  
  public final void setDescription(String paramString)
  {
    AppMethodBeat.i(166988);
    p.k(paramString, "value");
    FinderObjectDesc localFinderObjectDesc = this.feedObject.objectDesc;
    if (localFinderObjectDesc != null) {
      localFinderObjectDesc.description = paramString;
    }
    this.descriptionSpan = com.tencent.mm.pluginsdk.ui.span.l.c(MMApplicationContext.getContext(), (CharSequence)paramString);
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
  
  public final void setEventClosed()
  {
    this.field_localFlag |= 0x10;
  }
  
  public final void setEventExpired()
  {
    this.field_localFlag |= 0x20;
  }
  
  public final void setExtReading(asl paramasl)
  {
    AppMethodBeat.i(167001);
    p.k(paramasl, "value");
    FinderObjectDesc localFinderObjectDesc = this.feedObject.objectDesc;
    if (localFinderObjectDesc != null)
    {
      localFinderObjectDesc.extReading = paramasl;
      AppMethodBeat.o(167001);
      return;
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
    p.k(paramFinderObject, "value");
    Object localObject1 = ak.AGL;
    this.mediaType = ak.F(paramFinderObject);
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
    Object localObject3;
    Object localObject4;
    com.tencent.mm.plugin.b localb;
    if (this.fromType == 16)
    {
      localObject3 = MMApplicationContext.getContext();
      localObject4 = (com.tencent.mm.plugin.b)h.ae(com.tencent.mm.plugin.b.class);
      localObject2 = paramFinderObject.nickname;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      this.nickNameSpan = com.tencent.mm.pluginsdk.ui.span.l.d((Context)localObject3, (CharSequence)((com.tencent.mm.plugin.b)localObject4).bZ((String)localObject1, ""), 0.0F);
      localObject3 = MMApplicationContext.getContext();
      localObject4 = (com.tencent.mm.plugin.b)h.ae(com.tencent.mm.plugin.b.class);
      localObject1 = paramFinderObject.objectDesc;
      if (localObject1 != null)
      {
        localObject2 = ((FinderObjectDesc)localObject1).description;
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      this.descriptionSpan = com.tencent.mm.pluginsdk.ui.span.l.b((Context)localObject3, (CharSequence)((com.tencent.mm.plugin.b)localObject4).aac((String)localObject1), 0.0F);
      localb = (com.tencent.mm.plugin.b)h.ae(com.tencent.mm.plugin.b.class);
      localObject1 = paramFinderObject.objectDesc;
      if (localObject1 == null) {
        break label546;
      }
      localObject1 = ((FinderObjectDesc)localObject1).topic;
      if (localObject1 == null) {
        break label546;
      }
    }
    label535:
    label546:
    for (localObject1 = ((bkp)localObject1).SVC;; localObject1 = null)
    {
      localObject3 = this.descriptionSpan;
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = new SpannableString((CharSequence)"");
      }
      long l = this.field_id;
      List localList = this.topicList;
      localObject4 = paramFinderObject.mentionedUserContact;
      localObject3 = localObject4;
      if (localObject4 == null) {
        localObject3 = new LinkedList();
      }
      paramFinderObject = paramFinderObject.objectDesc;
      if (paramFinderObject != null)
      {
        localObject4 = paramFinderObject.mentionedUser;
        paramFinderObject = (FinderObject)localObject4;
        if (localObject4 != null) {}
      }
      else
      {
        paramFinderObject = new LinkedList();
      }
      this.descriptionFullSpan = localb.a((String)localObject1, (SpannableString)localObject2, l, localList, (LinkedList)localObject3, paramFinderObject, (m)new d(this), (kotlin.g.a.b)new e(this));
      if (this.fromType != 16) {
        this.descriptionSpan = com.tencent.mm.pluginsdk.ui.span.l.d(MMApplicationContext.getContext(), (CharSequence)String.valueOf(this.descriptionFullSpan), 0.0F);
      }
      AppMethodBeat.o(166980);
      return;
      localObject2 = MMApplicationContext.getContext();
      localObject1 = paramFinderObject.nickname;
      if (localObject1 != null)
      {
        localObject1 = (CharSequence)localObject1;
        label464:
        this.nickNameSpan = com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject2, (CharSequence)localObject1);
        localObject2 = MMApplicationContext.getContext();
        localObject1 = paramFinderObject.objectDesc;
        if (localObject1 == null) {
          break label535;
        }
        localObject1 = ((FinderObjectDesc)localObject1).description;
        if (localObject1 == null) {
          break label535;
        }
      }
      for (localObject1 = (CharSequence)localObject1;; localObject1 = (CharSequence)"")
      {
        this.descriptionSpan = com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject2, (CharSequence)localObject1);
        break;
        localObject1 = (CharSequence)"";
        break label464;
      }
    }
  }
  
  public final void setFoldedLayout(asz paramasz)
  {
    this.foldedLayout = paramasz;
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
  
  public final void setHalfVideoMediaExtList(LinkedList<csg> paramLinkedList)
  {
    AppMethodBeat.i(263930);
    p.k(paramLinkedList, "value");
    if (this.field_halfMediaExtList == null) {
      this.field_halfMediaExtList = new cso();
    }
    this.field_halfMediaExtList.TAp = paramLinkedList;
    AppMethodBeat.o(263930);
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
    p.k(paramLinkedList, "value");
    this.feedObject.likeList = paramLinkedList;
    AppMethodBeat.o(166995);
  }
  
  public final void setLiveFinderMedia(csg paramcsg)
  {
    this.liveFinderMedia = paramcsg;
  }
  
  public final void setLiveInfo(bac parambac)
  {
    this.feedObject.liveInfo = parambac;
  }
  
  public final void setLocalId(long paramLong)
  {
    this.field_localId = paramLong;
  }
  
  public final void setLocation(bdm parambdm)
  {
    AppMethodBeat.i(166999);
    p.k(parambdm, "value");
    FinderObjectDesc localFinderObjectDesc = this.feedObject.objectDesc;
    if (localFinderObjectDesc != null)
    {
      localFinderObjectDesc.location = parambdm;
      AppMethodBeat.o(166999);
      return;
    }
    AppMethodBeat.o(166999);
  }
  
  public final void setLongVideoMediaExtList(LinkedList<csg> paramLinkedList)
  {
    AppMethodBeat.i(263928);
    p.k(paramLinkedList, "value");
    if (this.field_longVideoMediaExtList == null) {
      this.field_longVideoMediaExtList = new cso();
    }
    this.field_longVideoMediaExtList.TAp = paramLinkedList;
    AppMethodBeat.o(263928);
  }
  
  public final void setLongVideoMediaList(LinkedList<csg> paramLinkedList)
  {
    AppMethodBeat.i(263926);
    p.k(paramLinkedList, "value");
    Object localObject = this.feedObject.attachmentList;
    if (localObject != null)
    {
      localObject = ((apx)localObject).SDm;
      if (localObject != null)
      {
        localObject = (apw)j.lp((List)localObject);
        if (localObject != null)
        {
          localObject = ((apw)localObject).SDl;
          if (localObject != null)
          {
            localObject = ((blj)localObject).SPm;
            if (localObject != null)
            {
              localObject = ((cvy)localObject).TEM;
              if (localObject != null)
              {
                ((cwc)localObject).media = n.aT(paramLinkedList);
                AppMethodBeat.o(263926);
                return;
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(263926);
  }
  
  public final void setMediaExtList(LinkedList<csg> paramLinkedList)
  {
    AppMethodBeat.i(166992);
    p.k(paramLinkedList, "value");
    if (this.field_mediaExtList == null) {
      this.field_mediaExtList = new cso();
    }
    this.field_mediaExtList.TAp = paramLinkedList;
    AppMethodBeat.o(166992);
  }
  
  public final void setMediaList(LinkedList<csg> paramLinkedList)
  {
    AppMethodBeat.i(166990);
    p.k(paramLinkedList, "value");
    FinderObjectDesc localFinderObjectDesc = this.feedObject.objectDesc;
    if (localFinderObjectDesc != null)
    {
      p.k(paramLinkedList, "$this$toServer");
      LinkedList localLinkedList1 = new LinkedList();
      Iterator localIterator = ((Iterable)paramLinkedList).iterator();
      while (localIterator.hasNext())
      {
        csg localcsg = (csg)localIterator.next();
        p.k(localcsg, "$this$toServer");
        FinderMedia localFinderMedia = new FinderMedia();
        localFinderMedia.url = localcsg.url;
        localFinderMedia.thumbUrl = localcsg.thumbUrl;
        localFinderMedia.mediaType = localcsg.mediaType;
        localFinderMedia.videoDuration = localcsg.videoDuration;
        localFinderMedia.width = localcsg.width;
        localFinderMedia.height = localcsg.height;
        localFinderMedia.md5sum = localcsg.md5sum;
        localFinderMedia.fileSize = localcsg.fileSize;
        localFinderMedia.bitrate = localcsg.bitrate;
        LinkedList localLinkedList2 = localFinderMedia.spec;
        localLinkedList2.clear();
        localLinkedList2.addAll((Collection)localcsg.spec);
        localFinderMedia.coverUrl = localcsg.coverUrl;
        localFinderMedia.decodeKey = localcsg.decodeKey;
        localFinderMedia.url_token = localcsg.url_token;
        localFinderMedia.thumb_url_token = localcsg.thumb_url_token;
        localFinderMedia.cover_url_token = localcsg.cover_url_token;
        localFinderMedia.codec_info = localcsg.codec_info;
        localFinderMedia.hot_flag = localcsg.hot_flag;
        localFinderMedia.half_rect = localcsg.TAa;
        localFinderMedia.full_thumb_url = localcsg.TzX;
        localFinderMedia.full_thumb_url_token = localcsg.TzY;
        localFinderMedia.full_url = localcsg.full_url;
        localFinderMedia.full_width = localcsg.full_width;
        localFinderMedia.full_height = localcsg.full_height;
        localFinderMedia.full_md5sum = localcsg.full_md5sum;
        localFinderMedia.full_file_size = localcsg.full_file_size;
        localFinderMedia.full_bitrate = localcsg.full_bitrate;
        localLinkedList1.add(localFinderMedia);
      }
      localFinderObjectDesc.media = localLinkedList1;
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
  
  public final void setMegaVideo(cvy paramcvy)
  {
    AppMethodBeat.i(263921);
    Object localObject = this.feedObject.attachmentList;
    if (localObject != null)
    {
      localObject = ((apx)localObject).SDm;
      if (localObject != null)
      {
        localObject = (apw)j.lp((List)localObject);
        if (localObject != null)
        {
          localObject = ((apw)localObject).SDl;
          if (localObject != null)
          {
            ((blj)localObject).SPm = paramcvy;
            AppMethodBeat.o(263921);
            return;
          }
        }
      }
    }
    AppMethodBeat.o(263921);
  }
  
  public final void setMentionListSelected(int paramInt)
  {
    this.feedObject.mentionedListSelected = paramInt;
  }
  
  public final void setNickName(String paramString)
  {
    AppMethodBeat.i(166985);
    p.k(paramString, "value");
    this.feedObject.nickname = paramString;
    this.nickNameSpan = com.tencent.mm.pluginsdk.ui.span.l.c(MMApplicationContext.getContext(), (CharSequence)paramString);
    AppMethodBeat.o(166985);
  }
  
  public final void setNickNameSpan(SpannableString paramSpannableString)
  {
    this.nickNameSpan = paramSpannableString;
  }
  
  public final void setObjectNonceId(String paramString)
  {
    AppMethodBeat.i(166983);
    p.k(paramString, "value");
    this.feedObject.objectNonceId = paramString;
    AppMethodBeat.o(166983);
  }
  
  public final void setPosTriggerConfig(h.a parama)
  {
    AppMethodBeat.i(263915);
    p.k(parama, "<set-?>");
    this.posTriggerConfig = parama;
    AppMethodBeat.o(263915);
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
    AppMethodBeat.i(263939);
    setPostFailed();
    this.field_localFlag |= 0x4;
    if (paramInt == -4059)
    {
      setEventClosed();
      AppMethodBeat.o(263939);
      return;
    }
    if (paramInt == -4065) {
      setEventExpired();
    }
    AppMethodBeat.o(263939);
  }
  
  public final void setPostFinish()
  {
    this.field_localFlag &= 0xFFFFFFFE;
    this.field_localFlag &= 0xFFFFFFFD;
  }
  
  public final void setPostInfo(csh paramcsh)
  {
    AppMethodBeat.i(167005);
    p.k(paramcsh, "field_postinfo");
    this.field_postinfo = paramcsh;
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
    p.k(paramFinderContact, "value");
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
  
  public final void setTopicClickExtra(c paramc)
  {
    AppMethodBeat.i(263914);
    p.k(paramc, "<set-?>");
    this.topicClickExtra = paramc;
    AppMethodBeat.o(263914);
  }
  
  public final void setUserName(String paramString)
  {
    AppMethodBeat.i(166986);
    p.k(paramString, "value");
    this.feedObject.username = paramString;
    AppMethodBeat.o(166986);
  }
  
  public final void trackPost(String paramString)
  {
    AppMethodBeat.i(167013);
    p.k(paramString, "stage");
    try
    {
      Object localObject1 = this.field_postinfo;
      if (localObject1 != null)
      {
        String str = "localId:" + getLocalId() + ", localFlag:" + this.field_localFlag + ", uploadState:" + ((csh)localObject1).TAg + ", tryCount:" + ((csh)localObject1).kQn + ", utilNow:" + (cm.bfC() - ((csh)localObject1).TAj) + "ms, mediaProcessCost:" + ((csh)localObject1).TAk + "ms, uploadCost:" + ((csh)localObject1).jPg + "ms, doSceneCost:" + ((csh)localObject1).TAl + "ms, totalCost:" + ((csh)localObject1).FEO + "ms";
        localObject1 = "localId:" + getLocalId() + ", mediaList: ";
        Object localObject2 = (Iterable)getMediaExtList();
        int i = 0;
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = ((Iterator)localObject2).next();
          if (i < 0) {
            j.iBO();
          }
          localObject3 = (csg)localObject3;
          localObject1 = (String)localObject1 + "Index" + i + ", fileSize:" + (float)u.bBQ(((csg)localObject3).url) / 1024.0F / 1024.0F + "MB, mediaType:" + ((csg)localObject3).mediaType + "; ";
          i += 1;
        }
        Log.i("Finder.PostLog", "stage:" + paramString + ' ' + str);
        Log.i("Finder.PostLog", "stage:" + paramString + ' ' + (String)localObject1);
        AppMethodBeat.o(167013);
        return;
      }
      Log.i("Finder.PostLog", "stage:" + paramString + " localId:" + getLocalId() + ", postInfo is null");
      AppMethodBeat.o(167013);
      return;
    }
    catch (Throwable paramString)
    {
      Log.i("Finder.PostLog", "exception: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(167013);
    }
  }
  
  public final void updateFinderObject(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(167006);
    p.k(paramFinderObject, "svrFeed");
    this.field_username = paramFinderObject.username;
    this.field_finderObject = paramFinderObject;
    setFeedObject(paramFinderObject);
    this.field_id = paramFinderObject.id;
    this.field_createTime = paramFinderObject.createtime;
    AppMethodBeat.o(167006);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/FinderItem$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "debugOnlySelfSee", "", "getDebugOnlySelfSee", "()Z", "setDebugOnlySelfSee", "(Z)V", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "create", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "feedObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "type", "", "genFinderItem", "finderObject", "feedPostingInfo", "Lcom/tencent/mm/protocal/protobuf/FeedPostingInfo;", "localId", "", "toFinderItem", "Lcom/tencent/mm/protocal/protobuf/FinderItemPb;", "toFinderItemPb", "toPostingInfo", "plugin-finder-base_release"})
  public static final class a
  {
    public static FinderItem a(awh paramawh, long paramLong)
    {
      AppMethodBeat.i(260933);
      p.k(paramawh, "$this$toFinderItem");
      if (paramawh.xcx != null)
      {
        Object localObject2 = paramawh.xcx;
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new FinderObject();
        }
        paramawh = paramawh.SIK;
        p.k(localObject1, "finderObject");
        localObject2 = new FinderItem();
        ((FinderItem)localObject2).setLocalId(paramLong);
        ((FinderItem)localObject2).setFeedObject((FinderObject)localObject1);
        if (paramawh != null)
        {
          ((FinderItem)localObject2).field_localFlag = paramawh.mVu;
          ((FinderItem)localObject2).field_postinfo = paramawh.AAM;
          ((FinderItem)localObject2).field_mediaExtList = paramawh.SBW;
          ((FinderItem)localObject2).field_reportObject = paramawh.SBX;
          ((FinderItem)localObject2).field_postExtraData = paramawh.SBY;
          ((FinderItem)localObject2).field_customData = paramawh.SBZ;
          ((FinderItem)localObject2).field_longVideoMediaExtList = paramawh.SCa;
          ((FinderItem)localObject2).field_halfMediaExtList = paramawh.SCb;
          ((FinderItem)localObject2).field_clipList = paramawh.SCc;
        }
        AppMethodBeat.o(260933);
        return localObject2;
      }
      paramawh = new FinderItem();
      AppMethodBeat.o(260933);
      return paramawh;
    }
    
    public static FinderItem b(FinderObject paramFinderObject, int paramInt)
    {
      AppMethodBeat.i(166977);
      p.k(paramFinderObject, "feedObject");
      FinderItem localFinderItem = new FinderItem();
      localFinderItem.setFromType(paramInt);
      localFinderItem.setFeedObject(paramFinderObject);
      if ((Util.isNullOrNil(localFinderItem.getFeedObject().nickname)) && (localFinderItem.getFeedObject().contact != null))
      {
        paramFinderObject = localFinderItem.getFeedObject().contact;
        if (paramFinderObject == null) {
          break label121;
        }
      }
      label121:
      for (paramFinderObject = paramFinderObject.nickname;; paramFinderObject = null)
      {
        if (!Util.isNullOrNil(paramFinderObject))
        {
          FinderObject localFinderObject = localFinderItem.getFeedObject();
          paramFinderObject = localFinderItem.getFeedObject().contact;
          if (paramFinderObject != null)
          {
            String str = paramFinderObject.nickname;
            paramFinderObject = str;
            if (str != null) {}
          }
          else
          {
            paramFinderObject = "";
          }
          localFinderObject.nickname = paramFinderObject;
        }
        AppMethodBeat.o(166977);
        return localFinderItem;
      }
    }
    
    public static IAutoDBItem.MAutoDBInfo dYE()
    {
      AppMethodBeat.i(260931);
      IAutoDBItem.MAutoDBInfo localMAutoDBInfo = FinderItem.access$getInfo$cp();
      AppMethodBeat.o(260931);
      return localMAutoDBInfo;
    }
    
    public static void dYF()
    {
      AppMethodBeat.i(260939);
      FinderItem.access$setDebugOnlySelfSee$cp(true);
      AppMethodBeat.o(260939);
    }
    
    public static awh m(FinderItem paramFinderItem)
    {
      AppMethodBeat.i(260935);
      p.k(paramFinderItem, "$this$toFinderItemPb");
      awh localawh = new awh();
      localawh.xcx = paramFinderItem.getFeedObject();
      localawh.SIK = n(paramFinderItem);
      AppMethodBeat.o(260935);
      return localawh;
    }
    
    public static aow n(FinderItem paramFinderItem)
    {
      AppMethodBeat.i(260937);
      p.k(paramFinderItem, "$this$toPostingInfo");
      aow localaow = new aow();
      localaow.mVu = paramFinderItem.field_localFlag;
      localaow.AAM = paramFinderItem.field_postinfo;
      localaow.SBW = paramFinderItem.field_mediaExtList;
      localaow.SBX = paramFinderItem.field_reportObject;
      localaow.SBY = paramFinderItem.field_postExtraData;
      localaow.SBZ = paramFinderItem.field_customData;
      localaow.SCa = paramFinderItem.field_longVideoMediaExtList;
      localaow.SCb = paramFinderItem.field_halfMediaExtList;
      localaow.SCc = paramFinderItem.field_clipList;
      AppMethodBeat.o(260937);
      return localaow;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "topic", "", "clickExtra", "Lcom/tencent/mm/plugin/finder/utils/ClickExtra;", "invoke"})
  static final class b
    extends q
    implements m<String, c, x>
  {
    b(FinderItem paramFinderItem)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "username", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.b<String, x>
  {
    c(FinderItem paramFinderItem)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "topic", "", "clickExtra", "Lcom/tencent/mm/plugin/finder/utils/ClickExtra;", "invoke"})
  static final class d
    extends q
    implements m<String, c, x>
  {
    d(FinderItem paramFinderItem)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "username", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.b<String, x>
  {
    e(FinderItem paramFinderItem)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.FinderItem
 * JD-Core Version:    0.7.0.1
 */