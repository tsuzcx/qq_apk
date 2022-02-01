package com.tencent.mm.plugin.finder.storage;

import android.content.Context;
import android.database.Cursor;
import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.ac.g;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.search.i;
import com.tencent.mm.plugin.finder.storage.data.o;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.plugin.finder.utils.w.a;
import com.tencent.mm.plugin.finder.utils.w.c;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.anv;
import com.tencent.mm.protocal.protobuf.aop;
import com.tencent.mm.protocal.protobuf.aoq;
import com.tencent.mm.protocal.protobuf.aqg;
import com.tencent.mm.protocal.protobuf.aqp;
import com.tencent.mm.protocal.protobuf.ard;
import com.tencent.mm.protocal.protobuf.aud;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.axt;
import com.tencent.mm.protocal.protobuf.bdq;
import com.tencent.mm.protocal.protobuf.bei;
import com.tencent.mm.protocal.protobuf.cjh;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cjm;
import com.tencent.mm.protocal.protobuf.cjt;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.protocal.protobuf.cnl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.v;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;
import org.json.JSONObject;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "Lcom/tencent/mm/autogen/table/BaseFinderFeedItem;", "()V", "_clipListExt", "Ljava/util/LinkedList;", "value", "clipListExt", "getClipListExt", "()Ljava/util/LinkedList;", "setClipListExt", "(Ljava/util/LinkedList;)V", "", "commentCount", "getCommentCount", "()I", "setCommentCount", "(I)V", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "commentList", "getCommentList", "setCommentList", "comment_close", "getComment_close", "setComment_close", "copyObjectDescMedia", "Lcom/tencent/mm/protocal/protobuf/FinderMedia;", "getCopyObjectDescMedia", "createTime", "getCreateTime", "setCreateTime", "Lcom/tencent/mm/protocal/protobuf/FinderCustomFeedData;", "customData", "getCustomData", "()Lcom/tencent/mm/protocal/protobuf/FinderCustomFeedData;", "setCustomData", "(Lcom/tencent/mm/protocal/protobuf/FinderCustomFeedData;)V", "debugDescription", "", "getDebugDescription", "()Ljava/lang/String;", "description", "getDescription", "setDescription", "(Ljava/lang/String;)V", "descriptionFullSpan", "Landroid/text/SpannableString;", "getDescriptionFullSpan", "()Landroid/text/SpannableString;", "setDescriptionFullSpan", "(Landroid/text/SpannableString;)V", "descriptionSpan", "getDescriptionSpan", "setDescriptionSpan", "Lcom/tencent/mm/protocal/protobuf/FinderExtendedReading;", "extReading", "getExtReading", "()Lcom/tencent/mm/protocal/protobuf/FinderExtendedReading;", "setExtReading", "(Lcom/tencent/mm/protocal/protobuf/FinderExtendedReading;)V", "favCount", "getFavCount", "setFavCount", "favFlag", "getFavFlag", "setFavFlag", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "feedObject", "getFeedObject", "()Lcom/tencent/mm/protocal/protobuf/FinderObject;", "setFeedObject", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "foldedFeedList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getFoldedFeedList", "()Ljava/util/List;", "foldedFeeds", "", "foldedLayout", "Lcom/tencent/mm/protocal/protobuf/FinderFoldedLayout;", "getFoldedLayout", "()Lcom/tencent/mm/protocal/protobuf/FinderFoldedLayout;", "setFoldedLayout", "(Lcom/tencent/mm/protocal/protobuf/FinderFoldedLayout;)V", "forwardCount", "getForwardCount", "setForwardCount", "friendLikeCount", "getFriendLikeCount", "setFriendLikeCount", "fromType", "getFromType", "setFromType", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "halfVideoMediaExtList", "getHalfVideoMediaExtList", "setHalfVideoMediaExtList", "isLongVideo", "", "()Z", "isPreview", "setPreview", "(Z)V", "isRelatedItem", "setRelatedItem", "isReplaceLongVideoToNormal", "setReplaceLongVideoToNormal", "likeCount", "getLikeCount", "setLikeCount", "likeFlag", "getLikeFlag", "setLikeFlag", "likeList", "getLikeList", "setLikeList", "liveFinderMedia", "getLiveFinderMedia", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "setLiveFinderMedia", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;)V", "Lcom/tencent/mm/protocal/protobuf/FinderLiveInfo;", "liveInfo", "getLiveInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveInfo;", "setLiveInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveInfo;)V", "liveMediaList", "getLiveMediaList", "", "localId", "getLocalId", "()J", "setLocalId", "(J)V", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "location", "getLocation", "()Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "setLocation", "(Lcom/tencent/mm/protocal/protobuf/FinderLocation;)V", "longVideoMediaExtList", "getLongVideoMediaExtList", "setLongVideoMediaExtList", "longVideoMediaList", "getLongVideoMediaList", "setLongVideoMediaList", "mediaExtList", "getMediaExtList", "setMediaExtList", "mediaList", "getMediaList", "setMediaList", "mediaType", "getMediaType", "setMediaType", "Lcom/tencent/mm/protocal/protobuf/MegaVideo;", "megaVideo", "getMegaVideo", "()Lcom/tencent/mm/protocal/protobuf/MegaVideo;", "setMegaVideo", "(Lcom/tencent/mm/protocal/protobuf/MegaVideo;)V", "nickName", "getNickName", "setNickName", "nickNameSpan", "getNickNameSpan", "setNickNameSpan", "objectNonceId", "getObjectNonceId", "setObjectNonceId", "posTriggerConfig", "Lcom/tencent/mm/plugin/finder/storage/FinderItem$PosTriggerConfig;", "getPosTriggerConfig", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem$PosTriggerConfig;", "setPosTriggerConfig", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem$PosTriggerConfig;)V", "private_flag", "getPrivate_flag", "setPrivate_flag", "readCount", "getReadCount", "setReadCount", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "refObjectContact", "getRefObjectContact", "()Lcom/tencent/mm/protocal/protobuf/FinderContact;", "setRefObjectContact", "(Lcom/tencent/mm/protocal/protobuf/FinderContact;)V", "refObjectFlag", "getRefObjectFlag", "setRefObjectFlag", "refObjectId", "getRefObjectId", "setRefObjectId", "relatedFeedId", "getRelatedFeedId", "setRelatedFeedId", "stickyTime", "getStickyTime", "setStickyTime", "timestamps", "getTimestamps", "topicClickExtra", "Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$ClickExtra;", "getTopicClickExtra", "()Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$ClickExtra;", "setTopicClickExtra", "(Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$ClickExtra;)V", "topicList", "Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$TopicStringInfo;", "getTopicList", "userName", "getUserName", "setUserName", "convertFrom", "", "cu", "Landroid/database/Cursor;", "createDescriptionFullSpan", "fixMediaType", "obj", "getCropInfo", "index", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getExpectId", "getFinderObject", "getId", "getNotShareMsg", "getPostInfo", "Lcom/tencent/mm/protocal/protobuf/LocalFinderPostInfo;", "getUnsignedId", "info", "isCommentClose", "isEventClosed", "isLive", "isLiveFeed", "isMvFeed", "isNeedCrop", "isNeedVideoCompositionPlay", "isNotShare", "isOldVersion", "isOnlySelfSee", "isPostFailed", "isPostFailedCanRetry", "isPostFinish", "isPostNoAuth", "isPrivate", "mediaExt", "mediaId", "parseJsonOfPosTriggerConfig", "setEventClosed", "setPostFailed", "setPostFailedAndNoAuth", "setPostFailedAndNotRetry", "errCode", "setPostFinish", "setPostInfo", "field_postinfo", "setPostWaiting", "trackPost", "stage", "updateFinderObject", "svrFeed", "Companion", "PosTriggerConfig", "plugin-finder_release"})
public class FinderItem
  extends ch
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
  private ard foldedLayout;
  private int fromType;
  private boolean isPreview;
  private boolean isRelatedItem;
  private boolean isReplaceLongVideoToNormal;
  private cjl liveFinderMedia;
  private int mediaType;
  private SpannableString nickNameSpan;
  private b posTriggerConfig;
  private long relatedFeedId;
  private final long timestamps;
  private w.a topicClickExtra;
  private final List<w.c> topicList;
  
  static
  {
    AppMethodBeat.i(167015);
    Companion = new a((byte)0);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = ch.initAutoDBInfo(FinderItem.class);
    p.g(localMAutoDBInfo, "initAutoDBInfo(FinderItem::class.java)");
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
      localFinderObjectDesc.location = new axt();
    }
    this.feedObject = localFinderObject;
    this.topicClickExtra = new w.a(0L);
    this.timestamps = cl.aWA();
    this.topicList = ((List)new ArrayList());
    this.copyObjectDescMedia = new LinkedList();
    this._clipListExt = new LinkedList();
    this.foldedFeeds = ((List)new ArrayList());
    AppMethodBeat.o(167014);
  }
  
  private final void fixMediaType(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(166979);
    Object localObject = y.vXH;
    int i = y.t(paramFinderObject);
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
    p.h(paramCursor, "cu");
    super.convertFrom(paramCursor);
    FinderObject localFinderObject = this.field_finderObject;
    paramCursor = localFinderObject;
    if (localFinderObject == null) {
      paramCursor = new FinderObject();
    }
    setFeedObject(paramCursor);
    this.feedObject.username = z.aUg();
    paramCursor = y.vXH;
    this.mediaType = y.t(this.feedObject);
    AppMethodBeat.o(166984);
  }
  
  public final SpannableString createDescriptionFullSpan()
  {
    AppMethodBeat.i(251747);
    Object localObject5 = this.feedObject;
    Object localObject1 = com.tencent.mm.plugin.finder.utils.t.vWZ;
    localObject1 = ((FinderObject)localObject5).objectDesc;
    if (localObject1 != null)
    {
      localObject1 = ((FinderObjectDesc)localObject1).topic;
      if (localObject1 == null) {}
    }
    for (localObject1 = ((bdq)localObject1).LNs;; localObject1 = null)
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
      localObject1 = com.tencent.mm.plugin.finder.utils.t.a((String)localObject1, (SpannableString)localObject2, l, localList, (LinkedList)localObject3, (LinkedList)localObject4, (m)new c(this), (b)new d(this));
      AppMethodBeat.o(251747);
      return localObject1;
    }
  }
  
  public final LinkedList<FinderItem> getClipListExt()
  {
    AppMethodBeat.i(251758);
    if ((this._clipListExt.isEmpty()) && (this.field_clipList != null))
    {
      localObject = this.field_clipList.MoH;
      if (localObject != null)
      {
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          aud localaud = (aud)((Iterator)localObject).next();
          LinkedList localLinkedList = this._clipListExt;
          p.g(localaud, "it");
          localLinkedList.add(a.a(localaud, 0L));
        }
      }
    }
    Object localObject = this._clipListExt;
    AppMethodBeat.o(251758);
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
    p.g(localLinkedList, "feedObject.commentList");
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
  
  public final cjl getCropInfo(int paramInt)
  {
    AppMethodBeat.i(167007);
    Object localObject = getMediaList();
    if (localObject != null)
    {
      localObject = (cjl)kotlin.a.j.L((List)localObject, paramInt);
      AppMethodBeat.o(167007);
      return localObject;
    }
    AppMethodBeat.o(167007);
    return null;
  }
  
  public final aqg getCustomData()
  {
    return this.field_customData;
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final String getDebugDescription()
  {
    AppMethodBeat.i(251750);
    Object localObject = getDescription();
    int i = Math.min(((String)localObject).length(), 3);
    if (localObject == null)
    {
      localObject = new kotlin.t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(251750);
      throw ((Throwable)localObject);
    }
    localObject = ((String)localObject).substring(0, i);
    p.g(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    AppMethodBeat.o(251750);
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
    AppMethodBeat.i(251746);
    if (this.field_id == 0L)
    {
      l = getLocalId();
      AppMethodBeat.o(251746);
      return l;
    }
    long l = this.field_id;
    AppMethodBeat.o(251746);
    return l;
  }
  
  public final aqp getExtReading()
  {
    AppMethodBeat.i(167000);
    Object localObject = this.feedObject.objectDesc;
    if (localObject != null)
    {
      aqp localaqp = ((FinderObjectDesc)localObject).extReading;
      localObject = localaqp;
      if (localaqp != null) {}
    }
    else
    {
      localObject = new aqp();
      ((aqp)localObject).link = "";
      ((aqp)localObject).title = "";
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
  
  public final FinderObject getFinderObject()
  {
    return this.feedObject;
  }
  
  public final List<BaseFinderFeed> getFoldedFeedList()
  {
    AppMethodBeat.i(251761);
    Object localObject2;
    if (Util.isNullOrNil(this.foldedFeeds))
    {
      localObject1 = getFoldedLayout();
      Object localObject3;
      label82:
      Object localObject4;
      if (localObject1 != null)
      {
        localObject1 = ((ard)localObject1).LCW;
        if (Util.isNullOrNil((List)localObject1)) {
          break label279;
        }
        localObject1 = getFoldedLayout();
        if (localObject1 != null)
        {
          localObject1 = ((ard)localObject1).LCW;
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
          if (!((Iterator)localObject3).hasNext()) {
            break label153;
          }
          localObject4 = ((Iterator)localObject3).next();
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
        localObject1 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (FinderObject)((Iterator)localObject2).next();
            p.g(localObject3, "feed");
            localObject3 = a.a((FinderObject)localObject3, 1);
            localObject4 = c.vGN;
            ((Collection)localObject1).add(c.a.s((FinderItem)localObject3));
            continue;
            localObject1 = null;
            break;
          }
        }
        localObject1 = (List)localObject1;
        localObject2 = this.foldedFeeds;
        if (localObject1 == null) {
          break label297;
        }
      }
    }
    label279:
    label297:
    for (Object localObject1 = (Collection)localObject1;; localObject1 = (Collection)v.SXr)
    {
      ((List)localObject2).addAll((Collection)localObject1);
      localObject1 = this.foldedFeeds;
      AppMethodBeat.o(251761);
      return localObject1;
      localObject1 = null;
      break;
    }
  }
  
  public final ard getFoldedLayout()
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
  
  public final int getFromType()
  {
    return this.fromType;
  }
  
  public final LinkedList<cjl> getHalfVideoMediaExtList()
  {
    AppMethodBeat.i(251756);
    Object localObject = this.field_halfMediaExtList;
    if (localObject != null)
    {
      LinkedList localLinkedList = ((cjt)localObject).Mpk;
      localObject = localLinkedList;
      if (localLinkedList != null) {}
    }
    else
    {
      localObject = new LinkedList();
    }
    AppMethodBeat.o(251756);
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
    p.g(localLinkedList, "feedObject.likeList");
    AppMethodBeat.o(166994);
    return localLinkedList;
  }
  
  public final cjl getLiveFinderMedia()
  {
    return this.liveFinderMedia;
  }
  
  public final awe getLiveInfo()
  {
    return this.feedObject.liveInfo;
  }
  
  public final LinkedList<cjl> getLiveMediaList()
  {
    AppMethodBeat.i(251751);
    Object localObject = this.feedObject.objectDesc;
    if (localObject != null)
    {
      localObject = ((FinderObjectDesc)localObject).media;
      if (localObject != null)
      {
        localObject = com.tencent.mm.plugin.finder.storage.data.j.aA((LinkedList)localObject);
        AppMethodBeat.o(251751);
        return localObject;
      }
    }
    localObject = new LinkedList();
    AppMethodBeat.o(251751);
    return localObject;
  }
  
  public final long getLocalId()
  {
    return this.field_localId;
  }
  
  public final axt getLocation()
  {
    AppMethodBeat.i(166998);
    Object localObject = this.feedObject.objectDesc;
    if (localObject != null)
    {
      axt localaxt = ((FinderObjectDesc)localObject).location;
      localObject = localaxt;
      if (localaxt != null) {}
    }
    else
    {
      localObject = new axt();
      ((axt)localObject).fuK = "";
      ((axt)localObject).kHV = "";
    }
    AppMethodBeat.o(166998);
    return localObject;
  }
  
  public final LinkedList<cjl> getLongVideoMediaExtList()
  {
    AppMethodBeat.i(251754);
    Object localObject = this.field_longVideoMediaExtList;
    if (localObject != null)
    {
      LinkedList localLinkedList = ((cjt)localObject).Mpk;
      localObject = localLinkedList;
      if (localLinkedList != null) {}
    }
    else
    {
      localObject = new LinkedList();
    }
    AppMethodBeat.o(251754);
    return localObject;
  }
  
  public final LinkedList<cjl> getLongVideoMediaList()
  {
    AppMethodBeat.i(251752);
    if (getLongVideoMediaExtList().size() > 0)
    {
      localObject = getLongVideoMediaExtList();
      AppMethodBeat.o(251752);
      return localObject;
    }
    Object localObject = this.feedObject.attachmentList;
    if (localObject != null)
    {
      localObject = ((aoq)localObject).LAM;
      if (localObject != null)
      {
        localObject = (aop)kotlin.a.j.kt((List)localObject);
        if (localObject != null)
        {
          localObject = ((aop)localObject).LAL;
          if (localObject != null)
          {
            localObject = ((bei)localObject).LIA;
            if (localObject != null)
            {
              localObject = ((cng)localObject).MtG;
              if (localObject != null)
              {
                localObject = ((cnl)localObject).media;
                if (localObject != null)
                {
                  localObject = com.tencent.mm.plugin.finder.storage.data.j.aB((LinkedList)localObject);
                  AppMethodBeat.o(251752);
                  return localObject;
                }
              }
            }
          }
        }
      }
    }
    localObject = new LinkedList();
    AppMethodBeat.o(251752);
    return localObject;
  }
  
  public final LinkedList<cjl> getMediaExtList()
  {
    AppMethodBeat.i(166991);
    Object localObject = this.field_mediaExtList;
    if (localObject != null)
    {
      LinkedList localLinkedList = ((cjt)localObject).Mpk;
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
  
  public final LinkedList<cjl> getMediaList()
  {
    AppMethodBeat.i(166989);
    if (this.mediaType == 9)
    {
      if (this.liveFinderMedia == null)
      {
        cjl localcjl = new cjl();
        localObject1 = this.feedObject;
        if (localObject1 != null)
        {
          localObject1 = ((FinderObject)localObject1).liveInfo;
          if (localObject1 != null)
          {
            localObject2 = ((awe)localObject1).EzJ;
            localObject1 = localObject2;
            if (localObject2 != null) {
              break label63;
            }
          }
        }
        localObject1 = "";
        label63:
        localcjl.url = ((String)localObject1);
        localcjl.mediaType = 9;
        localcjl.thumbUrl = p.I(((cjl)kotlin.a.j.ks((List)getLiveMediaList())).thumbUrl, Util.nullAsNil(((cjl)kotlin.a.j.ks((List)getLiveMediaList())).thumb_url_token));
        localcjl.videoDuration = 0;
        localcjl.mediaId = MD5Util.getMD5String(localcjl.url);
        localcjl.width = 1000.0F;
        localcjl.height = 1167.0F;
        localcjl.md5sum = "";
        localcjl.fileSize = 0;
        localcjl.bitrate = 0;
        this.liveFinderMedia = localcjl;
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
        localObject1 = com.tencent.mm.plugin.finder.storage.data.j.aA((LinkedList)localObject1);
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
  
  public final cng getMegaVideo()
  {
    AppMethodBeat.i(251748);
    Object localObject = this.feedObject.attachmentList;
    if (localObject != null)
    {
      localObject = ((aoq)localObject).LAM;
      if (localObject != null)
      {
        localObject = (aop)kotlin.a.j.kt((List)localObject);
        if (localObject != null)
        {
          localObject = ((aop)localObject).LAL;
          if (localObject != null)
          {
            localObject = ((bei)localObject).LIA;
            AppMethodBeat.o(251748);
            return localObject;
          }
        }
      }
    }
    AppMethodBeat.o(251748);
    return null;
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
  
  public final b getPosTriggerConfig()
  {
    return this.posTriggerConfig;
  }
  
  public final cjm getPostInfo()
  {
    AppMethodBeat.i(167004);
    cjm localcjm2 = this.field_postinfo;
    cjm localcjm1 = localcjm2;
    if (localcjm2 == null) {
      localcjm1 = new cjm();
    }
    AppMethodBeat.o(167004);
    return localcjm1;
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
  
  public final int getStickyTime()
  {
    return this.feedObject.stickyTime;
  }
  
  public final long getTimestamps()
  {
    return this.timestamps;
  }
  
  public final w.a getTopicClickExtra()
  {
    return this.topicClickExtra;
  }
  
  public final List<w.c> getTopicList()
  {
    return this.topicList;
  }
  
  public final String getUnsignedId()
  {
    AppMethodBeat.i(251745);
    String str = d.zs(getId());
    AppMethodBeat.o(251745);
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
        localObject = new kotlin.t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(167012);
        throw ((Throwable)localObject);
      }
      localObject = ((String)localObject).substring(0, i);
      p.g(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
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
    AppMethodBeat.i(251760);
    if (!((Collection)getLongVideoMediaList()).isEmpty())
    {
      AppMethodBeat.o(251760);
      return true;
    }
    AppMethodBeat.o(251760);
    return false;
  }
  
  public final boolean isMvFeed()
  {
    return this.feedObject.objectType == 2;
  }
  
  public final boolean isNeedCrop(int paramInt)
  {
    AppMethodBeat.i(167008);
    cjl localcjl = getCropInfo(paramInt);
    if (localcjl == null)
    {
      AppMethodBeat.o(167008);
      return false;
    }
    if (localcjl.MoO)
    {
      AppMethodBeat.o(167008);
      return true;
    }
    AppMethodBeat.o(167008);
    return false;
  }
  
  public final boolean isNeedVideoCompositionPlay(int paramInt)
  {
    AppMethodBeat.i(251762);
    cjl localcjl = getCropInfo(paramInt);
    y localy = y.vXH;
    if (!y.h(localcjl))
    {
      AppMethodBeat.o(251762);
      return true;
    }
    AppMethodBeat.o(251762);
    return false;
  }
  
  public final boolean isNotShare()
  {
    return this.feedObject.objectStatus == 2;
  }
  
  public final boolean isOldVersion()
  {
    return this.feedObject.secondaryShowFlag != 1;
  }
  
  public final boolean isOnlySelfSee()
  {
    if (debugOnlySelfSee) {}
    while (this.feedObject.objectStatus == 1) {
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
  
  public final cjl mediaExt(String paramString)
  {
    AppMethodBeat.i(166993);
    p.h(paramString, "mediaId");
    Object localObject = this.field_mediaExtList;
    if (localObject != null)
    {
      localObject = ((cjt)localObject).Mpk;
      if (localObject != null)
      {
        Iterator localIterator = ((Iterable)localObject).iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = localIterator.next();
        } while (!p.j(((cjl)localObject).mediaId, paramString));
        for (paramString = (String)localObject;; paramString = null)
        {
          paramString = (cjl)paramString;
          AppMethodBeat.o(166993);
          return paramString;
        }
      }
    }
    AppMethodBeat.o(166993);
    return null;
  }
  
  public final b parseJsonOfPosTriggerConfig()
  {
    AppMethodBeat.i(251744);
    Object localObject1 = new b(5, 0, 4, 0, "0");
    Object localObject2 = new b(10, 80, 8, 64, "||");
    int i;
    if (this.mediaType == 2)
    {
      localObject2 = this.feedObject.posTriggerConfig;
      if (localObject2 == null) {
        break label513;
      }
      p.g(localObject2, "it");
      if (((CharSequence)localObject2).length() <= 0) {
        break label455;
      }
      i = 1;
      label87:
      label91:
      if ((i != 0) && (localObject2 == null)) {
        break label513;
      }
    }
    label513:
    label522:
    label529:
    label536:
    for (;;)
    {
      boolean bool1;
      try
      {
        JSONObject localJSONObject1 = new JSONObject((String)localObject2);
        i = ((b)localObject1).tXx;
        if (localJSONObject1.has("maxUnreadCount")) {
          i = localJSONObject1.getInt("maxUnreadCount");
        }
        JSONObject localJSONObject2 = localJSONObject1.getJSONObject("config");
        int j = ((b)localObject1).vDO;
        if (localJSONObject2.has("showTime")) {
          j = localJSONObject2.getInt("showTime");
        }
        int k = ((b)localObject1).vDP;
        if (localJSONObject2.has("showPercentage")) {
          k = localJSONObject2.getInt("showPercentage");
        }
        int m = ((b)localObject1).vDQ;
        if (localJSONObject2.has("preLoadTime")) {
          m = localJSONObject2.getInt("preLoadTime");
        }
        int n = ((b)localObject1).vDR;
        if (localJSONObject2.has("preLoadPercentage")) {
          n = localJSONObject2.getInt("preLoadPercentage");
        }
        String str = ((b)localObject1).vDS;
        if (localJSONObject2.has("logic"))
        {
          str = localJSONObject2.getString("logic");
          p.g(str, "config.getString(\"logic\")");
        }
        bool2 = ((b)localObject1).vDT;
        if (localJSONObject1.has("favRelateListEnable"))
        {
          if (localJSONObject1.optInt("favRelateListEnable") == 1)
          {
            bool1 = true;
            break label522;
          }
        }
        else
        {
          bool3 = ((b)localObject1).vDU;
          if (localJSONObject1.has("favRelateListEnableOnClick"))
          {
            if (localJSONObject1.optInt("favRelateListEnableOnClick") != 1) {
              continue;
            }
            bool1 = true;
            break label529;
          }
          bool1 = ((b)localObject1).vDV;
          if (localJSONObject1.has("likeRelateListEnable"))
          {
            if (localJSONObject1.optInt("likeRelateListEnable") != 1) {
              continue;
            }
            bool1 = true;
            break label536;
          }
          localObject2 = new b(i, j, k, m, n, str, bool2, bool3, bool1, false, (String)localObject2);
          Log.i(TAG, "[parseJsonOfPosTriggerConfig] config=".concat(String.valueOf(localObject2)));
          AppMethodBeat.o(251744);
          return localObject2;
          localObject1 = localObject2;
          break;
          label455:
          i = 0;
          break label87;
          localObject2 = null;
          break label91;
        }
        bool1 = false;
        break label522;
        bool1 = false;
        break label529;
        bool1 = false;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace(TAG, (Throwable)localException, "", new Object[0]);
        AppMethodBeat.o(251744);
        return localObject1;
      }
      AppMethodBeat.o(251744);
      return localObject1;
      boolean bool2 = bool1;
      continue;
      boolean bool3 = bool1;
    }
  }
  
  public final void setClipListExt(LinkedList<FinderItem> paramLinkedList)
  {
    AppMethodBeat.i(251759);
    p.h(paramLinkedList, "value");
    this._clipListExt.clear();
    this._clipListExt.addAll((Collection)paramLinkedList);
    if (this.field_clipList == null) {
      this.field_clipList = new cjh();
    }
    Object localObject1 = this.field_clipList;
    if (localObject1 != null)
    {
      localObject1 = ((cjh)localObject1).MoH;
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
        localObject2 = ((cjh)localObject2).MoH;
        if (localObject2 != null) {
          ((LinkedList)localObject2).add(a.l((FinderItem)localObject1));
        }
      }
    }
    AppMethodBeat.o(251759);
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
    p.h(paramLinkedList, "value");
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
  
  public final void setCustomData(aqg paramaqg)
  {
    this.field_customData = paramaqg;
  }
  
  public final void setDescription(String paramString)
  {
    AppMethodBeat.i(166988);
    p.h(paramString, "value");
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
  
  public final void setExtReading(aqp paramaqp)
  {
    AppMethodBeat.i(167001);
    p.h(paramaqp, "value");
    FinderObjectDesc localFinderObjectDesc = this.feedObject.objectDesc;
    if (localFinderObjectDesc != null)
    {
      localFinderObjectDesc.extReading = paramaqp;
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
    p.h(paramFinderObject, "value");
    Object localObject1 = y.vXH;
    this.mediaType = y.t(paramFinderObject);
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
    if (this.fromType == 16)
    {
      localObject3 = MMApplicationContext.getContext();
      localObject1 = i.vvu;
      localObject2 = paramFinderObject.nickname;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      this.nickNameSpan = com.tencent.mm.pluginsdk.ui.span.l.d((Context)localObject3, (CharSequence)i.auZ((String)localObject1), 0.0F);
      localObject3 = MMApplicationContext.getContext();
      localObject1 = i.vvu;
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
      this.descriptionSpan = com.tencent.mm.pluginsdk.ui.span.l.b((Context)localObject3, (CharSequence)i.auY((String)localObject1), 0.0F);
      localObject1 = com.tencent.mm.plugin.finder.utils.t.vWZ;
      localObject1 = paramFinderObject.objectDesc;
      if (localObject1 == null) {
        break label513;
      }
      localObject1 = ((FinderObjectDesc)localObject1).topic;
      if (localObject1 == null) {
        break label513;
      }
    }
    label513:
    for (localObject1 = ((bdq)localObject1).LNs;; localObject1 = null)
    {
      localObject3 = this.descriptionSpan;
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = new SpannableString((CharSequence)"");
      }
      long l = this.field_id;
      List localList = this.topicList;
      LinkedList localLinkedList = paramFinderObject.mentionedUserContact;
      localObject3 = localLinkedList;
      if (localLinkedList == null) {
        localObject3 = new LinkedList();
      }
      paramFinderObject = paramFinderObject.objectDesc;
      if (paramFinderObject != null)
      {
        localLinkedList = paramFinderObject.mentionedUser;
        paramFinderObject = localLinkedList;
        if (localLinkedList != null) {}
      }
      else
      {
        paramFinderObject = new LinkedList();
      }
      this.descriptionFullSpan = com.tencent.mm.plugin.finder.utils.t.a((String)localObject1, (SpannableString)localObject2, l, localList, (LinkedList)localObject3, paramFinderObject, (m)new e(this), (b)new f(this));
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
        label431:
        this.nickNameSpan = com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject2, (CharSequence)localObject1);
        localObject2 = MMApplicationContext.getContext();
        localObject1 = paramFinderObject.objectDesc;
        if (localObject1 == null) {
          break label502;
        }
        localObject1 = ((FinderObjectDesc)localObject1).description;
        if (localObject1 == null) {
          break label502;
        }
      }
      label502:
      for (localObject1 = (CharSequence)localObject1;; localObject1 = (CharSequence)"")
      {
        this.descriptionSpan = com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject2, (CharSequence)localObject1);
        break;
        localObject1 = (CharSequence)"";
        break label431;
      }
    }
  }
  
  public final void setFoldedLayout(ard paramard)
  {
    this.foldedLayout = paramard;
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
  
  public final void setHalfVideoMediaExtList(LinkedList<cjl> paramLinkedList)
  {
    AppMethodBeat.i(251757);
    p.h(paramLinkedList, "value");
    if (this.field_halfMediaExtList == null) {
      this.field_halfMediaExtList = new cjt();
    }
    this.field_halfMediaExtList.Mpk = paramLinkedList;
    AppMethodBeat.o(251757);
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
    p.h(paramLinkedList, "value");
    this.feedObject.likeList = paramLinkedList;
    AppMethodBeat.o(166995);
  }
  
  public final void setLiveFinderMedia(cjl paramcjl)
  {
    this.liveFinderMedia = paramcjl;
  }
  
  public final void setLiveInfo(awe paramawe)
  {
    this.feedObject.liveInfo = paramawe;
  }
  
  public final void setLocalId(long paramLong)
  {
    this.field_localId = paramLong;
  }
  
  public final void setLocation(axt paramaxt)
  {
    AppMethodBeat.i(166999);
    p.h(paramaxt, "value");
    FinderObjectDesc localFinderObjectDesc = this.feedObject.objectDesc;
    if (localFinderObjectDesc != null)
    {
      localFinderObjectDesc.location = paramaxt;
      AppMethodBeat.o(166999);
      return;
    }
    AppMethodBeat.o(166999);
  }
  
  public final void setLongVideoMediaExtList(LinkedList<cjl> paramLinkedList)
  {
    AppMethodBeat.i(251755);
    p.h(paramLinkedList, "value");
    if (this.field_longVideoMediaExtList == null) {
      this.field_longVideoMediaExtList = new cjt();
    }
    this.field_longVideoMediaExtList.Mpk = paramLinkedList;
    AppMethodBeat.o(251755);
  }
  
  public final void setLongVideoMediaList(LinkedList<cjl> paramLinkedList)
  {
    AppMethodBeat.i(251753);
    p.h(paramLinkedList, "value");
    Object localObject = this.feedObject.attachmentList;
    if (localObject != null)
    {
      localObject = ((aoq)localObject).LAM;
      if (localObject != null)
      {
        localObject = (aop)kotlin.a.j.kt((List)localObject);
        if (localObject != null)
        {
          localObject = ((aop)localObject).LAL;
          if (localObject != null)
          {
            localObject = ((bei)localObject).LIA;
            if (localObject != null)
            {
              localObject = ((cng)localObject).MtG;
              if (localObject != null)
              {
                ((cnl)localObject).media = o.aC(paramLinkedList);
                AppMethodBeat.o(251753);
                return;
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(251753);
  }
  
  public final void setMediaExtList(LinkedList<cjl> paramLinkedList)
  {
    AppMethodBeat.i(166992);
    p.h(paramLinkedList, "value");
    if (this.field_mediaExtList == null) {
      this.field_mediaExtList = new cjt();
    }
    this.field_mediaExtList.Mpk = paramLinkedList;
    AppMethodBeat.o(166992);
  }
  
  public final void setMediaList(LinkedList<cjl> paramLinkedList)
  {
    AppMethodBeat.i(166990);
    p.h(paramLinkedList, "value");
    FinderObjectDesc localFinderObjectDesc = this.feedObject.objectDesc;
    if (localFinderObjectDesc != null)
    {
      p.h(paramLinkedList, "$this$toServer");
      LinkedList localLinkedList1 = new LinkedList();
      Iterator localIterator = ((Iterable)paramLinkedList).iterator();
      while (localIterator.hasNext())
      {
        cjl localcjl = (cjl)localIterator.next();
        p.h(localcjl, "$this$toServer");
        FinderMedia localFinderMedia = new FinderMedia();
        localFinderMedia.url = localcjl.url;
        localFinderMedia.thumbUrl = localcjl.thumbUrl;
        localFinderMedia.mediaType = localcjl.mediaType;
        localFinderMedia.videoDuration = localcjl.videoDuration;
        localFinderMedia.width = localcjl.width;
        localFinderMedia.height = localcjl.height;
        localFinderMedia.md5sum = localcjl.md5sum;
        localFinderMedia.fileSize = localcjl.fileSize;
        localFinderMedia.bitrate = localcjl.bitrate;
        LinkedList localLinkedList2 = localFinderMedia.spec;
        localLinkedList2.clear();
        localLinkedList2.addAll((Collection)localcjl.spec);
        localFinderMedia.coverUrl = localcjl.coverUrl;
        localFinderMedia.decodeKey = localcjl.decodeKey;
        localFinderMedia.url_token = localcjl.url_token;
        localFinderMedia.thumb_url_token = localcjl.thumb_url_token;
        localFinderMedia.cover_url_token = localcjl.cover_url_token;
        localFinderMedia.codec_info = localcjl.codec_info;
        localFinderMedia.hot_flag = localcjl.hot_flag;
        localFinderMedia.half_rect = localcjl.MoU;
        localFinderMedia.full_thumb_url = localcjl.MoR;
        localFinderMedia.full_thumb_url_token = localcjl.MoS;
        localFinderMedia.full_url = localcjl.full_url;
        localFinderMedia.full_width = localcjl.full_width;
        localFinderMedia.full_height = localcjl.full_height;
        localFinderMedia.full_md5sum = localcjl.full_md5sum;
        localFinderMedia.full_file_size = localcjl.full_file_size;
        localFinderMedia.full_bitrate = localcjl.full_bitrate;
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
  
  public final void setMegaVideo(cng paramcng)
  {
    AppMethodBeat.i(251749);
    Object localObject = this.feedObject.attachmentList;
    if (localObject != null)
    {
      localObject = ((aoq)localObject).LAM;
      if (localObject != null)
      {
        localObject = (aop)kotlin.a.j.kt((List)localObject);
        if (localObject != null)
        {
          localObject = ((aop)localObject).LAL;
          if (localObject != null)
          {
            ((bei)localObject).LIA = paramcng;
            AppMethodBeat.o(251749);
            return;
          }
        }
      }
    }
    AppMethodBeat.o(251749);
  }
  
  public final void setNickName(String paramString)
  {
    AppMethodBeat.i(166985);
    p.h(paramString, "value");
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
    p.h(paramString, "value");
    this.feedObject.objectNonceId = paramString;
    AppMethodBeat.o(166983);
  }
  
  public final void setPosTriggerConfig(b paramb)
  {
    this.posTriggerConfig = paramb;
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
    AppMethodBeat.i(251763);
    setPostFailed();
    this.field_localFlag |= 0x4;
    if (paramInt == -4059) {
      setEventClosed();
    }
    AppMethodBeat.o(251763);
  }
  
  public final void setPostFinish()
  {
    this.field_localFlag &= 0xFFFFFFFE;
    this.field_localFlag &= 0xFFFFFFFD;
  }
  
  public final void setPostInfo(cjm paramcjm)
  {
    AppMethodBeat.i(167005);
    p.h(paramcjm, "field_postinfo");
    this.field_postinfo = paramcjm;
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
    p.h(paramFinderContact, "value");
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
  
  public final void setStickyTime(int paramInt)
  {
    this.feedObject.stickyTime = paramInt;
  }
  
  public final void setTopicClickExtra(w.a parama)
  {
    AppMethodBeat.i(166981);
    p.h(parama, "<set-?>");
    this.topicClickExtra = parama;
    AppMethodBeat.o(166981);
  }
  
  public final void setUserName(String paramString)
  {
    AppMethodBeat.i(166986);
    p.h(paramString, "value");
    this.feedObject.username = paramString;
    AppMethodBeat.o(166986);
  }
  
  public final void trackPost(String paramString)
  {
    AppMethodBeat.i(167013);
    p.h(paramString, "stage");
    try
    {
      Object localObject1 = this.field_postinfo;
      if (localObject1 != null)
      {
        String str = "localId:" + getLocalId() + ", localFlag:" + this.field_localFlag + ", uploadState:" + ((cjm)localObject1).Mpa + ", tryCount:" + ((cjm)localObject1).ibG + ", utilNow:" + (cl.aWy() - ((cjm)localObject1).Mpd) + "ms, mediaProcessCost:" + ((cjm)localObject1).Mpe + "ms, uploadCost:" + ((cjm)localObject1).hdA + "ms, doSceneCost:" + ((cjm)localObject1).Mpf + "ms, totalCost:" + ((cjm)localObject1).zZb + "ms";
        localObject1 = "localId:" + getLocalId() + ", mediaList: ";
        Object localObject2 = (Iterable)getMediaExtList();
        int i = 0;
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = ((Iterator)localObject2).next();
          if (i < 0) {
            kotlin.a.j.hxH();
          }
          localObject3 = (cjl)localObject3;
          localObject1 = (String)localObject1 + "Index" + i + ", fileSize:" + (float)s.boW(((cjl)localObject3).url) / 1024.0F / 1024.0F + "MB, mediaType:" + ((cjl)localObject3).mediaType + "; ";
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
    p.h(paramFinderObject, "svrFeed");
    this.field_username = paramFinderObject.username;
    this.field_finderObject = paramFinderObject;
    setFeedObject(paramFinderObject);
    this.field_id = paramFinderObject.id;
    this.field_createTime = paramFinderObject.createtime;
    AppMethodBeat.o(167006);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/FinderItem$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "debugOnlySelfSee", "", "getDebugOnlySelfSee", "()Z", "setDebugOnlySelfSee", "(Z)V", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "create", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "feedObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "type", "", "genFinderItem", "finderObject", "feedPostingInfo", "Lcom/tencent/mm/protocal/protobuf/FeedPostingInfo;", "localId", "", "toFinderItem", "Lcom/tencent/mm/protocal/protobuf/FinderItemPb;", "toFinderItemPb", "toPostingInfo", "plugin-finder_release"})
  public static final class a
  {
    public static FinderItem a(FinderObject paramFinderObject, int paramInt)
    {
      AppMethodBeat.i(166977);
      p.h(paramFinderObject, "feedObject");
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
    
    private static FinderItem a(FinderObject paramFinderObject, anv paramanv, long paramLong)
    {
      AppMethodBeat.i(251735);
      p.h(paramFinderObject, "finderObject");
      FinderItem localFinderItem = new FinderItem();
      localFinderItem.setLocalId(paramLong);
      localFinderItem.setFeedObject(paramFinderObject);
      if (paramanv != null)
      {
        localFinderItem.field_localFlag = paramanv.kdU;
        localFinderItem.field_postinfo = paramanv.vTj;
        localFinderItem.field_mediaExtList = paramanv.Lzv;
        localFinderItem.field_reportObject = paramanv.Lzw;
        localFinderItem.field_postExtraData = paramanv.Lzx;
        localFinderItem.field_customData = paramanv.Lzy;
        localFinderItem.field_longVideoMediaExtList = paramanv.Lzz;
        localFinderItem.field_halfMediaExtList = paramanv.LzA;
        localFinderItem.field_clipList = paramanv.LzB;
      }
      AppMethodBeat.o(251735);
      return localFinderItem;
    }
    
    public static FinderItem a(aud paramaud, long paramLong)
    {
      AppMethodBeat.i(251733);
      p.h(paramaud, "$this$toFinderItem");
      if (paramaud.tuO != null)
      {
        FinderObject localFinderObject2 = paramaud.tuO;
        FinderObject localFinderObject1 = localFinderObject2;
        if (localFinderObject2 == null) {
          localFinderObject1 = new FinderObject();
        }
        paramaud = a(localFinderObject1, paramaud.LEP, paramLong);
        AppMethodBeat.o(251733);
        return paramaud;
      }
      paramaud = new FinderItem();
      AppMethodBeat.o(251733);
      return paramaud;
    }
    
    public static aud l(FinderItem paramFinderItem)
    {
      AppMethodBeat.i(251734);
      p.h(paramFinderItem, "$this$toFinderItemPb");
      aud localaud = new aud();
      localaud.tuO = paramFinderItem.getFeedObject();
      localaud.LEP = m(paramFinderItem);
      AppMethodBeat.o(251734);
      return localaud;
    }
    
    private static anv m(FinderItem paramFinderItem)
    {
      AppMethodBeat.i(251736);
      p.h(paramFinderItem, "$this$toPostingInfo");
      anv localanv = new anv();
      localanv.kdU = paramFinderItem.field_localFlag;
      localanv.vTj = paramFinderItem.field_postinfo;
      localanv.Lzv = paramFinderItem.field_mediaExtList;
      localanv.Lzw = paramFinderItem.field_reportObject;
      localanv.Lzx = paramFinderItem.field_postExtraData;
      localanv.Lzy = paramFinderItem.field_customData;
      localanv.Lzz = paramFinderItem.field_longVideoMediaExtList;
      localanv.LzA = paramFinderItem.field_halfMediaExtList;
      localanv.LzB = paramFinderItem.field_clipList;
      AppMethodBeat.o(251736);
      return localanv;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/FinderItem$PosTriggerConfig;", "", "maxUnreadCount", "", "showTime", "showPercentage", "preLoadTime", "preLoadPercentage", "logic", "", "favRelateListEnable", "", "favRelateListEnableOnClick", "likeRelateListEnable", "isLocalDefault", "jsonStr", "(IIIIILjava/lang/String;ZZZZLjava/lang/String;)V", "getFavRelateListEnable", "()Z", "getFavRelateListEnableOnClick", "setLocalDefault", "(Z)V", "getJsonStr", "()Ljava/lang/String;", "setJsonStr", "(Ljava/lang/String;)V", "getLikeRelateListEnable", "getLogic", "getMaxUnreadCount", "()I", "getPreLoadPercentage", "getPreLoadTime", "getShowPercentage", "getShowTime", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "plugin-finder_release"})
  public static final class b
  {
    public String lEd;
    public final int tXx;
    private boolean uUJ;
    public final int vDO;
    public final int vDP;
    public final int vDQ;
    public final int vDR;
    public final String vDS;
    public final boolean vDT;
    public final boolean vDU;
    public final boolean vDV;
    
    public b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, String paramString2)
    {
      AppMethodBeat.i(251738);
      this.tXx = paramInt1;
      this.vDO = paramInt2;
      this.vDP = paramInt3;
      this.vDQ = paramInt4;
      this.vDR = paramInt5;
      this.vDS = paramString1;
      this.vDT = paramBoolean1;
      this.vDU = paramBoolean2;
      this.vDV = paramBoolean3;
      this.uUJ = paramBoolean4;
      this.lEd = paramString2;
      AppMethodBeat.o(251738);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(251740);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((this.tXx != paramObject.tXx) || (this.vDO != paramObject.vDO) || (this.vDP != paramObject.vDP) || (this.vDQ != paramObject.vDQ) || (this.vDR != paramObject.vDR) || (!p.j(this.vDS, paramObject.vDS)) || (this.vDT != paramObject.vDT) || (this.vDU != paramObject.vDU) || (this.vDV != paramObject.vDV) || (this.uUJ != paramObject.uUJ) || (!p.j(this.lEd, paramObject.lEd))) {}
        }
      }
      else
      {
        AppMethodBeat.o(251740);
        return true;
      }
      AppMethodBeat.o(251740);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(251737);
      String str = "maxUnreadCount=" + this.tXx + ",showTime=" + this.vDO + ",showPercentage=" + this.vDP + ",preLoadTime=" + this.vDQ + ',' + "preLoadPercentage=" + this.vDR + ",logic=" + this.vDS + ",favRelateListEnable=" + this.vDT + ",favRelateListEnableOnClick=" + this.vDU + ",likeRelateListEnable=" + this.vDV + ",isLocalDefault=" + this.uUJ;
      AppMethodBeat.o(251737);
      return str;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "topic", "", "clickExtra", "Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$ClickExtra;", "invoke"})
  static final class c
    extends q
    implements m<String, w.a, x>
  {
    c(FinderItem paramFinderItem)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "username", "", "invoke"})
  static final class d
    extends q
    implements b<String, x>
  {
    d(FinderItem paramFinderItem)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "topic", "", "clickExtra", "Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$ClickExtra;", "invoke"})
  static final class e
    extends q
    implements m<String, w.a, x>
  {
    e(FinderItem paramFinderItem)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "username", "", "invoke"})
  static final class f
    extends q
    implements b<String, x>
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