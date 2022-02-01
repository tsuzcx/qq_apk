package com.tencent.mm.plugin.finder.storage;

import android.content.Context;
import android.database.Cursor;
import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.f;
import com.tencent.mm.g.c.cb;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.plugin.finder.utils.h.a;
import com.tencent.mm.plugin.finder.utils.h.c;
import com.tencent.mm.plugin.finder.utils.r;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.aig;
import com.tencent.mm.protocal.protobuf.ain;
import com.tencent.mm.protocal.protobuf.ajq;
import com.tencent.mm.protocal.protobuf.alo;
import com.tencent.mm.protocal.protobuf.bmd;
import com.tencent.mm.protocal.protobuf.bme;
import com.tencent.mm.protocal.protobuf.bmi;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import d.a.j;
import d.g.a.m;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "Lcom/tencent/mm/autogen/table/BaseFinderFeedItem;", "()V", "value", "", "commentCount", "getCommentCount", "()I", "setCommentCount", "(I)V", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "commentList", "getCommentList", "()Ljava/util/LinkedList;", "setCommentList", "(Ljava/util/LinkedList;)V", "comment_close", "getComment_close", "setComment_close", "createTime", "getCreateTime", "setCreateTime", "", "description", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "descriptionFullSpan", "Landroid/text/SpannableString;", "getDescriptionFullSpan", "()Landroid/text/SpannableString;", "setDescriptionFullSpan", "(Landroid/text/SpannableString;)V", "descriptionSpan", "getDescriptionSpan", "setDescriptionSpan", "Lcom/tencent/mm/protocal/protobuf/FinderExtendedReading;", "extReading", "getExtReading", "()Lcom/tencent/mm/protocal/protobuf/FinderExtendedReading;", "setExtReading", "(Lcom/tencent/mm/protocal/protobuf/FinderExtendedReading;)V", "favCount", "getFavCount", "setFavCount", "favFlag", "getFavFlag", "setFavFlag", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "feedObject", "getFeedObject", "()Lcom/tencent/mm/protocal/protobuf/FinderObject;", "setFeedObject", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "foldedFeedList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getFoldedFeedList", "()Ljava/util/List;", "foldedFeeds", "", "foldedLayout", "Lcom/tencent/mm/protocal/protobuf/FinderFoldedLayout;", "getFoldedLayout", "()Lcom/tencent/mm/protocal/protobuf/FinderFoldedLayout;", "setFoldedLayout", "(Lcom/tencent/mm/protocal/protobuf/FinderFoldedLayout;)V", "forwardCount", "getForwardCount", "setForwardCount", "friendLikeCount", "getFriendLikeCount", "setFriendLikeCount", "fromType", "getFromType", "setFromType", "isRelatedItem", "", "()Z", "setRelatedItem", "(Z)V", "likeCount", "getLikeCount", "setLikeCount", "likeFlag", "getLikeFlag", "setLikeFlag", "likeList", "getLikeList", "setLikeList", "", "localId", "getLocalId", "()J", "setLocalId", "(J)V", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "location", "getLocation", "()Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "setLocation", "(Lcom/tencent/mm/protocal/protobuf/FinderLocation;)V", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "mediaExtList", "getMediaExtList", "setMediaExtList", "mediaList", "getMediaList", "setMediaList", "mediaType", "getMediaType", "setMediaType", "nickName", "getNickName", "setNickName", "nickNameSpan", "getNickNameSpan", "setNickNameSpan", "objectNonceId", "getObjectNonceId", "setObjectNonceId", "readCount", "getReadCount", "setReadCount", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "refObjectContact", "getRefObjectContact", "()Lcom/tencent/mm/protocal/protobuf/FinderContact;", "setRefObjectContact", "(Lcom/tencent/mm/protocal/protobuf/FinderContact;)V", "refObjectFlag", "getRefObjectFlag", "setRefObjectFlag", "refObjectId", "getRefObjectId", "setRefObjectId", "relatedFeedId", "getRelatedFeedId", "setRelatedFeedId", "timestamps", "getTimestamps", "topicClickExtra", "Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$ClickExtra;", "getTopicClickExtra", "()Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$ClickExtra;", "setTopicClickExtra", "(Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$ClickExtra;)V", "topicList", "Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$TopicStringInfo;", "getTopicList", "userName", "getUserName", "setUserName", "convertFrom", "", "cu", "Landroid/database/Cursor;", "fixMediaType", "obj", "getCropInfo", "index", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getExpectId", "getFinderObject", "getId", "getNotShareMsg", "getPostInfo", "Lcom/tencent/mm/protocal/protobuf/LocalFinderPostInfo;", "info", "isCommentClose", "isNeedCrop", "isNeedVideoCompositionPlay", "isNotShare", "isOldVersion", "isOnlySelfSee", "isPostFailed", "isPostFailedCanRetry", "isPostFinish", "isPostNoAuth", "isUploadFailed", "mediaExt", "mediaId", "parseJsonOfPosTriggerConfig", "Lcom/tencent/mm/plugin/finder/storage/FinderItem$PosTriggerConfig;", "setPostFailed", "setPostFailedAndNoAuth", "setPostFailedAndNotRetry", "setPostFinish", "setPostInfo", "field_postinfo", "setPostWaiting", "trackPost", "stage", "updateFinderObject", "svrFeed", "Companion", "PosTriggerConfig", "plugin-finder_release"})
public class FinderItem
  extends cb
{
  private static final String TAG = "Finder.FinderItem";
  private static final c.a info;
  private static boolean qJT;
  public static final a qJU;
  private long KWA;
  private final List<h.c> KWB;
  private List<BaseFinderFeed> KWC;
  private final long KWy;
  private boolean KWz;
  private int evC;
  private ain foldedLayout;
  private int mediaType;
  private h.a qJP;
  private SpannableString qJQ;
  private SpannableString qJR;
  private SpannableString qJS;
  private FinderObject qps;
  
  static
  {
    AppMethodBeat.i(167015);
    qJU = new a((byte)0);
    c.a locala = cb.initAutoDBInfo(FinderItem.class);
    d.g.b.k.g(locala, "initAutoDBInfo(FinderItem::class.java)");
    info = locala;
    TAG = "Finder.FinderItem";
    AppMethodBeat.o(167015);
  }
  
  public FinderItem()
  {
    AppMethodBeat.i(167014);
    FinderObject localFinderObject = new FinderObject();
    localFinderObject.objectDesc = new FinderObjectDesc();
    localFinderObject.objectDesc.location = new ajq();
    this.qps = localFinderObject;
    this.qJP = new h.a(0L, (byte)0);
    this.KWy = ce.asS();
    this.KWB = ((List)new ArrayList());
    this.KWC = ((List)new ArrayList());
    AppMethodBeat.o(167014);
  }
  
  private final void fixMediaType(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(166979);
    Object localObject = com.tencent.mm.plugin.finder.utils.i.qTa;
    int i = com.tencent.mm.plugin.finder.utils.i.g(paramFinderObject);
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
    d.g.b.k.h(paramCursor, "cu");
    super.convertFrom(paramCursor);
    FinderObject localFinderObject = this.field_finderObject;
    paramCursor = localFinderObject;
    if (localFinderObject == null) {
      paramCursor = new FinderObject();
    }
    setFeedObject(paramCursor);
    this.qps.username = u.aqO();
    paramCursor = com.tencent.mm.plugin.finder.utils.i.qTa;
    this.mediaType = com.tencent.mm.plugin.finder.utils.i.g(this.qps);
    AppMethodBeat.o(166984);
  }
  
  public final int getCommentCount()
  {
    return this.qps.commentCount;
  }
  
  public final LinkedList<FinderCommentInfo> getCommentList()
  {
    AppMethodBeat.i(166996);
    LinkedList localLinkedList = this.qps.commentList;
    d.g.b.k.g(localLinkedList, "feedObject.commentList");
    AppMethodBeat.o(166996);
    return localLinkedList;
  }
  
  public final int getComment_close()
  {
    return this.qps.commentClose;
  }
  
  public final int getCreateTime()
  {
    return this.qps.createtime;
  }
  
  public final long getCreateTime()
  {
    return this.field_createTime;
  }
  
  public final bmd getCropInfo(int paramInt)
  {
    AppMethodBeat.i(167007);
    Object localObject = getMediaList();
    if (localObject != null)
    {
      localObject = (bmd)j.C((List)localObject, paramInt);
      AppMethodBeat.o(167007);
      return localObject;
    }
    AppMethodBeat.o(167007);
    return null;
  }
  
  public c.a getDBInfo()
  {
    return info;
  }
  
  public final String getDescription()
  {
    String str2 = this.qps.objectDesc.description;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final SpannableString getDescriptionFullSpan()
  {
    return this.qJS;
  }
  
  public final SpannableString getDescriptionSpan()
  {
    return this.qJR;
  }
  
  public final long getExpectId()
  {
    AppMethodBeat.i(198991);
    if (this.field_id == 0L)
    {
      l = getLocalId();
      AppMethodBeat.o(198991);
      return l;
    }
    long l = this.field_id;
    AppMethodBeat.o(198991);
    return l;
  }
  
  public final aig getExtReading()
  {
    AppMethodBeat.i(167000);
    aig localaig2 = this.qps.objectDesc.extReading;
    aig localaig1 = localaig2;
    if (localaig2 == null)
    {
      localaig1 = new aig();
      localaig1.link = "";
      localaig1.title = "";
    }
    AppMethodBeat.o(167000);
    return localaig1;
  }
  
  public final int getFavCount()
  {
    return this.qps.favCount;
  }
  
  public final int getFavFlag()
  {
    return this.qps.favFlag;
  }
  
  public final FinderObject getFeedObject()
  {
    return this.qps;
  }
  
  public final FinderObject getFinderObject()
  {
    return this.qps;
  }
  
  public final List<BaseFinderFeed> getFoldedFeedList()
  {
    AppMethodBeat.i(198992);
    Object localObject2;
    if (bt.gL(this.KWC))
    {
      localObject1 = getFoldedLayout();
      Object localObject3;
      label82:
      Object localObject4;
      if (localObject1 != null)
      {
        localObject1 = ((ain)localObject1).Dlg;
        if (bt.gL((List)localObject1)) {
          break label279;
        }
        localObject1 = getFoldedLayout();
        if (localObject1 != null)
        {
          localObject1 = ((ain)localObject1).Dlg;
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
        localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (FinderObject)((Iterator)localObject2).next();
            d.g.b.k.g(localObject3, "feed");
            localObject3 = a.a((FinderObject)localObject3, 1);
            localObject4 = com.tencent.mm.plugin.finder.storage.logic.b.qKG;
            ((Collection)localObject1).add(b.a.h((FinderItem)localObject3));
            continue;
            localObject1 = null;
            break;
          }
        }
        localObject1 = (List)localObject1;
        localObject2 = this.KWC;
        if (localObject1 == null) {
          break label297;
        }
      }
    }
    label279:
    label297:
    for (Object localObject1 = (Collection)localObject1;; localObject1 = (Collection)d.a.v.Jgl)
    {
      ((List)localObject2).addAll((Collection)localObject1);
      localObject1 = this.KWC;
      AppMethodBeat.o(198992);
      return localObject1;
      localObject1 = null;
      break;
    }
  }
  
  public final ain getFoldedLayout()
  {
    return this.qps.foldedLayout;
  }
  
  public final int getForwardCount()
  {
    return this.qps.forwardCount;
  }
  
  public final int getFriendLikeCount()
  {
    return this.qps.friendLikeCount;
  }
  
  public final int getFromType()
  {
    return this.evC;
  }
  
  public final long getId()
  {
    return this.field_id;
  }
  
  public final int getLikeCount()
  {
    return this.qps.likeCount;
  }
  
  public final int getLikeFlag()
  {
    return this.qps.likeFlag;
  }
  
  public final LinkedList<FinderCommentInfo> getLikeList()
  {
    AppMethodBeat.i(166994);
    LinkedList localLinkedList = this.qps.likeList;
    d.g.b.k.g(localLinkedList, "feedObject.likeList");
    AppMethodBeat.o(166994);
    return localLinkedList;
  }
  
  public final long getLocalId()
  {
    return this.field_localId;
  }
  
  public final ajq getLocation()
  {
    AppMethodBeat.i(166998);
    ajq localajq2 = this.qps.objectDesc.location;
    ajq localajq1 = localajq2;
    if (localajq2 == null)
    {
      localajq1 = new ajq();
      localajq1.evA = "";
      localajq1.goQ = "";
    }
    AppMethodBeat.o(166998);
    return localajq1;
  }
  
  public final LinkedList<bmd> getMediaExtList()
  {
    AppMethodBeat.i(166991);
    Object localObject = this.field_mediaExtList;
    if (localObject != null)
    {
      LinkedList localLinkedList = ((bmi)localObject).DJO;
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
  
  public final LinkedList<bmd> getMediaList()
  {
    AppMethodBeat.i(166989);
    if (getMediaExtList().size() > 0)
    {
      localLinkedList = getMediaExtList();
      AppMethodBeat.o(166989);
      return localLinkedList;
    }
    LinkedList localLinkedList = this.qps.objectDesc.media;
    d.g.b.k.g(localLinkedList, "feedObject.objectDesc.media");
    localLinkedList = e.ae(localLinkedList);
    AppMethodBeat.o(166989);
    return localLinkedList;
  }
  
  public final int getMediaType()
  {
    return this.mediaType;
  }
  
  public final String getNickName()
  {
    String str2 = this.qps.nickname;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final SpannableString getNickNameSpan()
  {
    return this.qJQ;
  }
  
  public final String getNotShareMsg()
  {
    String str2 = this.qps.sendShareFavWording;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String getObjectNonceId()
  {
    String str2 = this.qps.objectNonceId;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final bme getPostInfo()
  {
    AppMethodBeat.i(167004);
    bme localbme2 = this.field_postinfo;
    bme localbme1 = localbme2;
    if (localbme2 == null) {
      localbme1 = new bme();
    }
    AppMethodBeat.o(167004);
    return localbme1;
  }
  
  public final int getReadCount()
  {
    return this.qps.readCount;
  }
  
  public final FinderContact getRefObjectContact()
  {
    AppMethodBeat.i(167002);
    FinderContact localFinderContact2 = this.qps.refObjectContact;
    FinderContact localFinderContact1 = localFinderContact2;
    if (localFinderContact2 == null) {
      localFinderContact1 = new FinderContact();
    }
    AppMethodBeat.o(167002);
    return localFinderContact1;
  }
  
  public final long getRefObjectFlag()
  {
    return this.qps.refObjectFlag;
  }
  
  public final long getRefObjectId()
  {
    return this.qps.refObjectId;
  }
  
  public final long getRelatedFeedId()
  {
    return this.KWA;
  }
  
  public final long getTimestamps()
  {
    return this.KWy;
  }
  
  public final h.a getTopicClickExtra()
  {
    return this.qJP;
  }
  
  public final List<h.c> getTopicList()
  {
    return this.KWB;
  }
  
  public final String getUserName()
  {
    String str2 = this.qps.username;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String info()
  {
    AppMethodBeat.i(167012);
    StringBuilder localStringBuilder = new StringBuilder("id:").append(this.field_id).append(" username ").append(this.qps.username).append(" mediaType ").append(this.mediaType).append(" localFlag ").append(this.field_localFlag).append(" description ");
    Object localObject = getDescription();
    if (localObject != null)
    {
      int i = Math.min(((String)localObject).length(), 3);
      if (localObject == null)
      {
        localObject = new d.v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(167012);
        throw ((Throwable)localObject);
      }
      localObject = ((String)localObject).substring(0, i);
      d.g.b.k.g(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    }
    for (;;)
    {
      localObject = (String)localObject + " mediaList " + f.bG(getMediaList());
      AppMethodBeat.o(167012);
      return localObject;
      localObject = null;
    }
  }
  
  public final boolean isCommentClose()
  {
    return this.qps.commentClose == 1;
  }
  
  public final boolean isNeedCrop(int paramInt)
  {
    AppMethodBeat.i(167008);
    bmd localbmd = getCropInfo(paramInt);
    if (localbmd == null)
    {
      AppMethodBeat.o(167008);
      return false;
    }
    if (localbmd.DJD)
    {
      AppMethodBeat.o(167008);
      return true;
    }
    AppMethodBeat.o(167008);
    return false;
  }
  
  public final boolean isNeedVideoCompositionPlay(int paramInt)
  {
    AppMethodBeat.i(198993);
    bmd localbmd = getCropInfo(paramInt);
    com.tencent.mm.plugin.finder.utils.i locali = com.tencent.mm.plugin.finder.utils.i.qTa;
    if (!com.tencent.mm.plugin.finder.utils.i.c(localbmd))
    {
      AppMethodBeat.o(198993);
      return true;
    }
    AppMethodBeat.o(198993);
    return false;
  }
  
  public final boolean isNotShare()
  {
    return this.qps.objectStatus == 2;
  }
  
  public final boolean isOldVersion()
  {
    return this.qps.secondaryShowFlag != 1;
  }
  
  public final boolean isOnlySelfSee()
  {
    if (qJT) {}
    while (this.qps.objectStatus == 1) {
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
  
  public final boolean isRelatedItem()
  {
    return this.KWz;
  }
  
  public final boolean isUploadFailed()
  {
    AppMethodBeat.i(167011);
    if (getPostInfo().DJF == 2)
    {
      AppMethodBeat.o(167011);
      return true;
    }
    AppMethodBeat.o(167011);
    return false;
  }
  
  public final bmd mediaExt(String paramString)
  {
    AppMethodBeat.i(166993);
    d.g.b.k.h(paramString, "mediaId");
    Object localObject = this.field_mediaExtList;
    if (localObject != null)
    {
      localObject = ((bmi)localObject).DJO;
      if (localObject != null)
      {
        Iterator localIterator = ((Iterable)localObject).iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = localIterator.next();
        } while (!d.g.b.k.g(((bmd)localObject).mediaId, paramString));
        for (paramString = (String)localObject;; paramString = null)
        {
          paramString = (bmd)paramString;
          AppMethodBeat.o(166993);
          return paramString;
        }
      }
    }
    AppMethodBeat.o(166993);
    return null;
  }
  
  public final FinderItem.c parseJsonOfPosTriggerConfig()
  {
    AppMethodBeat.i(198990);
    Object localObject1 = new FinderItem.c(5, 0, 4, 0, "0");
    Object localObject2 = new FinderItem.c(10, 80, 8, 64, "||");
    int i;
    if (this.mediaType == 2)
    {
      localObject2 = this.qps.posTriggerConfig;
      if (localObject2 == null) {
        break label344;
      }
      if (((CharSequence)localObject2).length() <= 0) {
        break label304;
      }
      i = 1;
      label79:
      if (i == 0) {
        break label309;
      }
    }
    for (;;)
    {
      if (localObject2 == null) {
        break label344;
      }
      try
      {
        JSONObject localJSONObject = new JSONObject((String)localObject2);
        i = ((FinderItem.c)localObject1).KQu;
        if (localJSONObject.has("maxUnreadCount")) {
          i = localJSONObject.getInt("maxUnreadCount");
        }
        int j = ((FinderItem.c)localObject1).FUF;
        if (localJSONObject.has("showTime")) {
          j = localJSONObject.getInt("showTime");
        }
        int k = ((FinderItem.c)localObject1).KWD;
        if (localJSONObject.has("showPercentage")) {
          k = localJSONObject.getInt("showPercentage");
        }
        int m = ((FinderItem.c)localObject1).KWE;
        if (localJSONObject.has("preLoadTime")) {
          m = localJSONObject.getInt("preLoadTime");
        }
        int n = ((FinderItem.c)localObject1).KWF;
        if (localJSONObject.has("preLoadPercentage")) {
          n = localJSONObject.getInt("preLoadPercentage");
        }
        localObject2 = ((FinderItem.c)localObject1).KWG;
        if (localJSONObject.has("logic"))
        {
          localObject2 = localJSONObject.getString("logic");
          d.g.b.k.g(localObject2, "json.getString(\"logic\")");
        }
        localObject2 = new FinderItem.c(i, j, k, m, n, (String)localObject2, false);
        AppMethodBeat.o(198990);
        return localObject2;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace(TAG, (Throwable)localException, "", new Object[0]);
        AppMethodBeat.o(198990);
        return localObject1;
      }
      localObject1 = localObject2;
      break;
      label304:
      i = 0;
      break label79;
      label309:
      localObject2 = null;
    }
    label344:
    AppMethodBeat.o(198990);
    return localObject1;
  }
  
  public final void setCommentCount(int paramInt)
  {
    AppMethodBeat.i(166987);
    ad.d("Finder.FinderItem", "setCommentCount " + this.qps.hashCode() + ", from:" + getCommentCount() + ", to:" + getCommentCount());
    this.qps.commentCount = paramInt;
    AppMethodBeat.o(166987);
  }
  
  public final void setCommentList(LinkedList<FinderCommentInfo> paramLinkedList)
  {
    AppMethodBeat.i(166997);
    d.g.b.k.h(paramLinkedList, "value");
    this.qps.commentList = paramLinkedList;
    AppMethodBeat.o(166997);
  }
  
  public final void setComment_close(int paramInt)
  {
    this.qps.commentClose = paramInt;
  }
  
  public final void setCreateTime(int paramInt)
  {
    this.qps.createtime = paramInt;
  }
  
  public final void setDescription(String paramString)
  {
    AppMethodBeat.i(166988);
    d.g.b.k.h(paramString, "value");
    this.qps.objectDesc.description = paramString;
    this.qJR = com.tencent.mm.pluginsdk.ui.span.k.c(aj.getContext(), (CharSequence)paramString);
    this.qJS = this.qJR;
    ad.w(TAG, "unexpecting write!");
    AppMethodBeat.o(166988);
  }
  
  public final void setDescriptionFullSpan(SpannableString paramSpannableString)
  {
    this.qJS = paramSpannableString;
  }
  
  public final void setDescriptionSpan(SpannableString paramSpannableString)
  {
    this.qJR = paramSpannableString;
  }
  
  public final void setExtReading(aig paramaig)
  {
    AppMethodBeat.i(167001);
    d.g.b.k.h(paramaig, "value");
    this.qps.objectDesc.extReading = paramaig;
    AppMethodBeat.o(167001);
  }
  
  public final void setFavCount(int paramInt)
  {
    this.qps.favCount = paramInt;
  }
  
  public final void setFavFlag(int paramInt)
  {
    this.qps.favFlag = paramInt;
  }
  
  public final void setFeedObject(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(166980);
    d.g.b.k.h(paramFinderObject, "value");
    Object localObject1 = com.tencent.mm.plugin.finder.utils.i.qTa;
    this.mediaType = com.tencent.mm.plugin.finder.utils.i.g(paramFinderObject);
    this.field_createTime = paramFinderObject.createtime;
    this.field_id = paramFinderObject.id;
    Object localObject2 = paramFinderObject.username;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.field_username = ((String)localObject1);
    fixMediaType(paramFinderObject);
    this.qps = paramFinderObject;
    this.field_finderObject = paramFinderObject;
    Object localObject3;
    if (this.evC == 16)
    {
      localObject3 = aj.getContext();
      localObject1 = com.tencent.mm.plugin.finder.search.i.qIB;
      localObject2 = paramFinderObject.nickname;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      this.qJQ = com.tencent.mm.pluginsdk.ui.span.k.d((Context)localObject3, (CharSequence)com.tencent.mm.plugin.finder.search.i.Zr((String)localObject1), 0.0F);
      localObject3 = aj.getContext();
      localObject1 = com.tencent.mm.plugin.finder.search.i.qIB;
      localObject2 = paramFinderObject.objectDesc.description;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      this.qJR = com.tencent.mm.pluginsdk.ui.span.k.b((Context)localObject3, (CharSequence)com.tencent.mm.plugin.finder.search.i.Zq((String)localObject1), 0.0F);
      localObject1 = r.Lbe;
      localObject1 = paramFinderObject.objectDesc.topic;
      if (localObject1 == null) {
        break label450;
      }
    }
    label439:
    label450:
    for (localObject1 = ((alo)localObject1).DmM;; localObject1 = null)
    {
      localObject3 = this.qJR;
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = new SpannableString((CharSequence)"");
      }
      long l = this.field_id;
      List localList = this.KWB;
      LinkedList localLinkedList = paramFinderObject.mentionedUserContact;
      localObject3 = localLinkedList;
      if (localLinkedList == null) {
        localObject3 = new LinkedList();
      }
      localLinkedList = paramFinderObject.objectDesc.mentionedUser;
      paramFinderObject = localLinkedList;
      if (localLinkedList == null) {
        paramFinderObject = new LinkedList();
      }
      this.qJS = r.a((String)localObject1, (SpannableString)localObject2, l, localList, (LinkedList)localObject3, paramFinderObject, (m)new b(this), (d.g.a.b)new FinderItem.d(this));
      AppMethodBeat.o(166980);
      return;
      localObject2 = aj.getContext();
      localObject1 = paramFinderObject.nickname;
      if (localObject1 != null)
      {
        localObject1 = (CharSequence)localObject1;
        label377:
        this.qJQ = com.tencent.mm.pluginsdk.ui.span.k.c((Context)localObject2, (CharSequence)localObject1);
        localObject2 = aj.getContext();
        localObject1 = paramFinderObject.objectDesc.description;
        if (localObject1 == null) {
          break label439;
        }
      }
      for (localObject1 = (CharSequence)localObject1;; localObject1 = (CharSequence)"")
      {
        this.qJR = com.tencent.mm.pluginsdk.ui.span.k.c((Context)localObject2, (CharSequence)localObject1);
        break;
        localObject1 = (CharSequence)"";
        break label377;
      }
    }
  }
  
  public final void setFoldedLayout(ain paramain)
  {
    this.foldedLayout = paramain;
  }
  
  public final void setForwardCount(int paramInt)
  {
    this.qps.forwardCount = paramInt;
  }
  
  public final void setFriendLikeCount(int paramInt)
  {
    this.qps.friendLikeCount = paramInt;
  }
  
  public final void setFromType(int paramInt)
  {
    this.evC = paramInt;
  }
  
  public final void setLikeCount(int paramInt)
  {
    this.qps.likeCount = paramInt;
  }
  
  public final void setLikeFlag(int paramInt)
  {
    this.qps.likeFlag = paramInt;
  }
  
  public final void setLikeList(LinkedList<FinderCommentInfo> paramLinkedList)
  {
    AppMethodBeat.i(166995);
    d.g.b.k.h(paramLinkedList, "value");
    this.qps.likeList = paramLinkedList;
    AppMethodBeat.o(166995);
  }
  
  public final void setLocalId(long paramLong)
  {
    this.field_localId = paramLong;
  }
  
  public final void setLocation(ajq paramajq)
  {
    AppMethodBeat.i(166999);
    d.g.b.k.h(paramajq, "value");
    this.qps.objectDesc.location = paramajq;
    AppMethodBeat.o(166999);
  }
  
  public final void setMediaExtList(LinkedList<bmd> paramLinkedList)
  {
    AppMethodBeat.i(166992);
    d.g.b.k.h(paramLinkedList, "value");
    if (this.field_mediaExtList == null) {
      this.field_mediaExtList = new bmi();
    }
    this.field_mediaExtList.DJO = paramLinkedList;
    AppMethodBeat.o(166992);
  }
  
  public final void setMediaList(LinkedList<bmd> paramLinkedList)
  {
    AppMethodBeat.i(166990);
    d.g.b.k.h(paramLinkedList, "value");
    FinderObjectDesc localFinderObjectDesc = this.qps.objectDesc;
    d.g.b.k.h(paramLinkedList, "$this$toServer");
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = ((Iterable)paramLinkedList).iterator();
    while (localIterator.hasNext())
    {
      bmd localbmd = (bmd)localIterator.next();
      d.g.b.k.h(localbmd, "$this$toServer");
      FinderMedia localFinderMedia = new FinderMedia();
      localFinderMedia.url = localbmd.url;
      localFinderMedia.mediaType = localbmd.mediaType;
      localFinderMedia.thumbUrl = localbmd.thumbUrl;
      localFinderMedia.videoDuration = localbmd.videoDuration;
      localFinderMedia.width = localbmd.width;
      localFinderMedia.height = localbmd.height;
      localFinderMedia.md5sum = localbmd.md5sum;
      localFinderMedia.fileSize = localbmd.fileSize;
      localFinderMedia.bitrate = localbmd.bitrate;
      localFinderMedia.coverUrl = localbmd.coverUrl;
      localLinkedList.add(localFinderMedia);
    }
    localFinderObjectDesc.media = localLinkedList;
    if (this.qps.id == 0L) {
      setMediaExtList(paramLinkedList);
    }
    AppMethodBeat.o(166990);
  }
  
  public final void setMediaType(int paramInt)
  {
    this.mediaType = paramInt;
  }
  
  public final void setNickName(String paramString)
  {
    AppMethodBeat.i(166985);
    d.g.b.k.h(paramString, "value");
    this.qps.nickname = paramString;
    this.qJQ = com.tencent.mm.pluginsdk.ui.span.k.c(aj.getContext(), (CharSequence)paramString);
    AppMethodBeat.o(166985);
  }
  
  public final void setNickNameSpan(SpannableString paramSpannableString)
  {
    this.qJQ = paramSpannableString;
  }
  
  public final void setObjectNonceId(String paramString)
  {
    AppMethodBeat.i(166983);
    d.g.b.k.h(paramString, "value");
    this.qps.objectNonceId = paramString;
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
  
  public final void setPostFailedAndNotRetry()
  {
    AppMethodBeat.i(167009);
    setPostFailed();
    this.field_localFlag |= 0x4;
    AppMethodBeat.o(167009);
  }
  
  public final void setPostFinish()
  {
    this.field_localFlag &= 0xFFFFFFFE;
    this.field_localFlag &= 0xFFFFFFFD;
  }
  
  public final void setPostInfo(bme parambme)
  {
    AppMethodBeat.i(167005);
    d.g.b.k.h(parambme, "field_postinfo");
    this.field_postinfo = parambme;
    AppMethodBeat.o(167005);
  }
  
  public final void setPostWaiting()
  {
    this.field_localFlag |= 0x1;
    this.field_localFlag &= 0xFFFFFFFD;
  }
  
  public final void setReadCount(int paramInt)
  {
    this.qps.readCount = paramInt;
  }
  
  public final void setRefObjectContact(FinderContact paramFinderContact)
  {
    AppMethodBeat.i(167003);
    d.g.b.k.h(paramFinderContact, "value");
    this.qps.refObjectContact = paramFinderContact;
    AppMethodBeat.o(167003);
  }
  
  public final void setRefObjectFlag(long paramLong)
  {
    this.qps.refObjectFlag = paramLong;
  }
  
  public final void setRefObjectId(long paramLong)
  {
    this.qps.refObjectId = paramLong;
  }
  
  public final void setRelatedFeedId(long paramLong)
  {
    this.KWA = paramLong;
  }
  
  public final void setRelatedItem(boolean paramBoolean)
  {
    this.KWz = paramBoolean;
  }
  
  public final void setTopicClickExtra(h.a parama)
  {
    AppMethodBeat.i(166981);
    d.g.b.k.h(parama, "<set-?>");
    this.qJP = parama;
    AppMethodBeat.o(166981);
  }
  
  public final void setUserName(String paramString)
  {
    AppMethodBeat.i(166986);
    d.g.b.k.h(paramString, "value");
    this.qps.username = paramString;
    AppMethodBeat.o(166986);
  }
  
  public final void trackPost(String paramString)
  {
    AppMethodBeat.i(167013);
    d.g.b.k.h(paramString, "stage");
    try
    {
      Object localObject1 = this.field_postinfo;
      if (localObject1 != null)
      {
        String str = "localId:" + getLocalId() + ", localFlag:" + this.field_localFlag + ", uploadState:" + ((bme)localObject1).DJF + ", tryCount:" + ((bme)localObject1).gll + ", utilNow:" + (ce.asQ() - ((bme)localObject1).DJJ) + "ms, mediaProcessCost:" + ((bme)localObject1).DJL + "ms, uploadCost:" + ((bme)localObject1).fSx + "ms, doSceneCost:" + ((bme)localObject1).DJM + "ms, totalCost:" + ((bme)localObject1).DJK + "ms";
        localObject1 = "localId:" + getLocalId() + ", mediaList: ";
        Object localObject2 = (Iterable)getMediaExtList();
        int i = 0;
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = ((Iterator)localObject2).next();
          if (i < 0) {
            j.fvx();
          }
          localObject3 = (bmd)localObject3;
          localObject1 = (String)localObject1 + "Index" + i + ", fileSize:" + (float)com.tencent.mm.vfs.i.aMN(((bmd)localObject3).url) / 1024.0F / 1024.0F + "MB, mediaType:" + ((bmd)localObject3).mediaType + "; ";
          i += 1;
        }
        ad.i("Finder.PostLog", "stage:" + paramString + ' ' + str);
        ad.i("Finder.PostLog", "stage:" + paramString + ' ' + (String)localObject1);
        AppMethodBeat.o(167013);
        return;
      }
      ad.i("Finder.PostLog", "stage:" + paramString + " localId:" + getLocalId() + ", postInfo is null");
      AppMethodBeat.o(167013);
      return;
    }
    catch (Throwable paramString)
    {
      ad.i("Finder.PostLog", "exception: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(167013);
    }
  }
  
  public final void updateFinderObject(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(167006);
    d.g.b.k.h(paramFinderObject, "svrFeed");
    this.field_username = paramFinderObject.username;
    this.field_finderObject = paramFinderObject;
    setFeedObject(paramFinderObject);
    this.field_id = paramFinderObject.id;
    this.field_createTime = paramFinderObject.createtime;
    AppMethodBeat.o(167006);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/storage/FinderItem$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "debugOnlySelfSee", "", "getDebugOnlySelfSee", "()Z", "setDebugOnlySelfSee", "(Z)V", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "create", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "feedObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "type", "", "plugin-finder_release"})
  public static final class a
  {
    public static FinderItem a(FinderObject paramFinderObject, int paramInt)
    {
      AppMethodBeat.i(166977);
      d.g.b.k.h(paramFinderObject, "feedObject");
      FinderItem localFinderItem = new FinderItem();
      localFinderItem.setFromType(paramInt);
      localFinderItem.setFeedObject(paramFinderObject);
      if ((bt.isNullOrNil(localFinderItem.getFeedObject().nickname)) && (localFinderItem.getFeedObject().contact != null) && (!bt.isNullOrNil(localFinderItem.getFeedObject().contact.nickname))) {
        localFinderItem.getFeedObject().nickname = localFinderItem.getFeedObject().contact.nickname;
      }
      AppMethodBeat.o(166977);
      return localFinderItem;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "topic", "", "clickExtra", "Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$ClickExtra;", "invoke"})
  static final class b
    extends d.g.b.l
    implements m<String, h.a, y>
  {
    b(FinderItem paramFinderItem)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.FinderItem
 * JD-Core Version:    0.7.0.1
 */