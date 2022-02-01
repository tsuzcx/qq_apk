package com.tencent.mm.plugin.finder.storage;

import android.content.Context;
import android.database.Cursor;
import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.f;
import com.tencent.mm.g.c.cd;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.plugin.finder.utils.m.a;
import com.tencent.mm.plugin.finder.utils.m.c;
import com.tencent.mm.plugin.finder.utils.n;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.ajq;
import com.tencent.mm.protocal.protobuf.ajz;
import com.tencent.mm.protocal.protobuf.alt;
import com.tencent.mm.protocal.protobuf.aoo;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.protocal.protobuf.bqt;
import com.tencent.mm.protocal.protobuf.bqy;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
import d.a.j;
import d.g.a.m;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "Lcom/tencent/mm/autogen/table/BaseFinderFeedItem;", "()V", "value", "", "commentCount", "getCommentCount", "()I", "setCommentCount", "(I)V", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "commentList", "getCommentList", "()Ljava/util/LinkedList;", "setCommentList", "(Ljava/util/LinkedList;)V", "comment_close", "getComment_close", "setComment_close", "createTime", "getCreateTime", "setCreateTime", "debugDescription", "", "getDebugDescription", "()Ljava/lang/String;", "description", "getDescription", "setDescription", "(Ljava/lang/String;)V", "descriptionFullSpan", "Landroid/text/SpannableString;", "getDescriptionFullSpan", "()Landroid/text/SpannableString;", "setDescriptionFullSpan", "(Landroid/text/SpannableString;)V", "descriptionSpan", "getDescriptionSpan", "setDescriptionSpan", "Lcom/tencent/mm/protocal/protobuf/FinderExtendedReading;", "extReading", "getExtReading", "()Lcom/tencent/mm/protocal/protobuf/FinderExtendedReading;", "setExtReading", "(Lcom/tencent/mm/protocal/protobuf/FinderExtendedReading;)V", "favCount", "getFavCount", "setFavCount", "favFlag", "getFavFlag", "setFavFlag", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "feedObject", "getFeedObject", "()Lcom/tencent/mm/protocal/protobuf/FinderObject;", "setFeedObject", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "foldedFeedList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getFoldedFeedList", "()Ljava/util/List;", "foldedFeeds", "", "foldedLayout", "Lcom/tencent/mm/protocal/protobuf/FinderFoldedLayout;", "getFoldedLayout", "()Lcom/tencent/mm/protocal/protobuf/FinderFoldedLayout;", "setFoldedLayout", "(Lcom/tencent/mm/protocal/protobuf/FinderFoldedLayout;)V", "forwardCount", "getForwardCount", "setForwardCount", "friendLikeCount", "getFriendLikeCount", "setFriendLikeCount", "fromType", "getFromType", "setFromType", "isRelatedItem", "", "()Z", "setRelatedItem", "(Z)V", "likeCount", "getLikeCount", "setLikeCount", "likeFlag", "getLikeFlag", "setLikeFlag", "likeList", "getLikeList", "setLikeList", "", "localId", "getLocalId", "()J", "setLocalId", "(J)V", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "location", "getLocation", "()Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "setLocation", "(Lcom/tencent/mm/protocal/protobuf/FinderLocation;)V", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "mediaExtList", "getMediaExtList", "setMediaExtList", "mediaList", "getMediaList", "setMediaList", "mediaType", "getMediaType", "setMediaType", "nickName", "getNickName", "setNickName", "nickNameSpan", "getNickNameSpan", "setNickNameSpan", "objectNonceId", "getObjectNonceId", "setObjectNonceId", "readCount", "getReadCount", "setReadCount", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "refObjectContact", "getRefObjectContact", "()Lcom/tencent/mm/protocal/protobuf/FinderContact;", "setRefObjectContact", "(Lcom/tencent/mm/protocal/protobuf/FinderContact;)V", "refObjectFlag", "getRefObjectFlag", "setRefObjectFlag", "refObjectId", "getRefObjectId", "setRefObjectId", "relatedFeedId", "getRelatedFeedId", "setRelatedFeedId", "timestamps", "getTimestamps", "topicClickExtra", "Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$ClickExtra;", "getTopicClickExtra", "()Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$ClickExtra;", "setTopicClickExtra", "(Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$ClickExtra;)V", "topicList", "Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$TopicStringInfo;", "getTopicList", "userName", "getUserName", "setUserName", "convertFrom", "", "cu", "Landroid/database/Cursor;", "fixMediaType", "obj", "getCropInfo", "index", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getExpectId", "getFinderObject", "getId", "getNotShareMsg", "getPostInfo", "Lcom/tencent/mm/protocal/protobuf/LocalFinderPostInfo;", "info", "isCommentClose", "isNeedCrop", "isNeedVideoCompositionPlay", "isNotShare", "isOldVersion", "isOnlySelfSee", "isPostFailed", "isPostFailedCanRetry", "isPostFinish", "isPostNoAuth", "isUploadFailed", "mediaExt", "mediaId", "parseJsonOfPosTriggerConfig", "Lcom/tencent/mm/plugin/finder/storage/FinderItem$PosTriggerConfig;", "setPostFailed", "setPostFailedAndNoAuth", "setPostFailedAndNotRetry", "setPostFinish", "setPostInfo", "field_postinfo", "setPostWaiting", "trackPost", "stage", "updateFinderObject", "svrFeed", "Companion", "PosTriggerConfig", "plugin-finder_release"})
public class FinderItem
  extends cd
{
  private static final String TAG = "Finder.FinderItem";
  private static final c.a info;
  public static final a rDA;
  private static boolean rDz;
  private int exY;
  private ajz foldedLayout;
  private int mediaType;
  private FinderObject qYy;
  private m.a rDq;
  private final long rDr;
  private boolean rDs;
  private long rDt;
  private SpannableString rDu;
  private SpannableString rDv;
  private SpannableString rDw;
  private final List<m.c> rDx;
  private List<BaseFinderFeed> rDy;
  
  static
  {
    AppMethodBeat.i(167015);
    rDA = new a((byte)0);
    c.a locala = cd.initAutoDBInfo(FinderItem.class);
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
    localFinderObject.objectDesc.location = new alt();
    this.qYy = localFinderObject;
    this.rDq = new m.a(0L, (byte)0);
    this.rDr = ce.azJ();
    this.rDx = ((List)new ArrayList());
    this.rDy = ((List)new ArrayList());
    AppMethodBeat.o(167014);
  }
  
  private final void fixMediaType(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(166979);
    Object localObject = n.rPN;
    int i = n.o(paramFinderObject);
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
    this.qYy.username = u.axE();
    paramCursor = n.rPN;
    this.mediaType = n.o(this.qYy);
    AppMethodBeat.o(166984);
  }
  
  public final int getCommentCount()
  {
    return this.qYy.commentCount;
  }
  
  public final LinkedList<FinderCommentInfo> getCommentList()
  {
    AppMethodBeat.i(166996);
    LinkedList localLinkedList = this.qYy.commentList;
    d.g.b.k.g(localLinkedList, "feedObject.commentList");
    AppMethodBeat.o(166996);
    return localLinkedList;
  }
  
  public final int getComment_close()
  {
    return this.qYy.commentClose;
  }
  
  public final int getCreateTime()
  {
    return this.qYy.createtime;
  }
  
  public final long getCreateTime()
  {
    return this.field_createTime;
  }
  
  public final bqs getCropInfo(int paramInt)
  {
    AppMethodBeat.i(167007);
    Object localObject = getMediaList();
    if (localObject != null)
    {
      localObject = (bqs)j.C((List)localObject, paramInt);
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
  
  public final String getDebugDescription()
  {
    AppMethodBeat.i(202955);
    Object localObject = getDescription();
    int i = Math.min(((String)localObject).length(), 3);
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(202955);
      throw ((Throwable)localObject);
    }
    localObject = ((String)localObject).substring(0, i);
    d.g.b.k.g(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    AppMethodBeat.o(202955);
    return localObject;
  }
  
  public final String getDescription()
  {
    String str2 = this.qYy.objectDesc.description;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final SpannableString getDescriptionFullSpan()
  {
    return this.rDw;
  }
  
  public final SpannableString getDescriptionSpan()
  {
    return this.rDv;
  }
  
  public final long getExpectId()
  {
    AppMethodBeat.i(202954);
    if (this.field_id == 0L)
    {
      l = getLocalId();
      AppMethodBeat.o(202954);
      return l;
    }
    long l = this.field_id;
    AppMethodBeat.o(202954);
    return l;
  }
  
  public final ajq getExtReading()
  {
    AppMethodBeat.i(167000);
    ajq localajq2 = this.qYy.objectDesc.extReading;
    ajq localajq1 = localajq2;
    if (localajq2 == null)
    {
      localajq1 = new ajq();
      localajq1.link = "";
      localajq1.title = "";
    }
    AppMethodBeat.o(167000);
    return localajq1;
  }
  
  public final int getFavCount()
  {
    return this.qYy.favCount;
  }
  
  public final int getFavFlag()
  {
    return this.qYy.favFlag;
  }
  
  public final FinderObject getFeedObject()
  {
    return this.qYy;
  }
  
  public final FinderObject getFinderObject()
  {
    return this.qYy;
  }
  
  public final List<BaseFinderFeed> getFoldedFeedList()
  {
    AppMethodBeat.i(202956);
    Object localObject2;
    if (bs.gY(this.rDy))
    {
      localObject1 = getFoldedLayout();
      Object localObject3;
      label82:
      Object localObject4;
      if (localObject1 != null)
      {
        localObject1 = ((ajz)localObject1).EEw;
        if (bs.gY((List)localObject1)) {
          break label279;
        }
        localObject1 = getFoldedLayout();
        if (localObject1 != null)
        {
          localObject1 = ((ajz)localObject1).EEw;
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
            localObject4 = com.tencent.mm.plugin.finder.storage.logic.b.rFl;
            ((Collection)localObject1).add(b.a.i((FinderItem)localObject3));
            continue;
            localObject1 = null;
            break;
          }
        }
        localObject1 = (List)localObject1;
        localObject2 = this.rDy;
        if (localObject1 == null) {
          break label297;
        }
      }
    }
    label279:
    label297:
    for (Object localObject1 = (Collection)localObject1;; localObject1 = (Collection)d.a.v.KTF)
    {
      ((List)localObject2).addAll((Collection)localObject1);
      localObject1 = this.rDy;
      AppMethodBeat.o(202956);
      return localObject1;
      localObject1 = null;
      break;
    }
  }
  
  public final ajz getFoldedLayout()
  {
    return this.qYy.foldedLayout;
  }
  
  public final int getForwardCount()
  {
    return this.qYy.forwardCount;
  }
  
  public final int getFriendLikeCount()
  {
    return this.qYy.friendLikeCount;
  }
  
  public final int getFromType()
  {
    return this.exY;
  }
  
  public final long getId()
  {
    return this.field_id;
  }
  
  public final int getLikeCount()
  {
    return this.qYy.likeCount;
  }
  
  public final int getLikeFlag()
  {
    return this.qYy.likeFlag;
  }
  
  public final LinkedList<FinderCommentInfo> getLikeList()
  {
    AppMethodBeat.i(166994);
    LinkedList localLinkedList = this.qYy.likeList;
    d.g.b.k.g(localLinkedList, "feedObject.likeList");
    AppMethodBeat.o(166994);
    return localLinkedList;
  }
  
  public final long getLocalId()
  {
    return this.field_localId;
  }
  
  public final alt getLocation()
  {
    AppMethodBeat.i(166998);
    alt localalt2 = this.qYy.objectDesc.location;
    alt localalt1 = localalt2;
    if (localalt2 == null)
    {
      localalt1 = new alt();
      localalt1.exW = "";
      localalt1.gPy = "";
    }
    AppMethodBeat.o(166998);
    return localalt1;
  }
  
  public final LinkedList<bqs> getMediaExtList()
  {
    AppMethodBeat.i(166991);
    Object localObject = this.field_mediaExtList;
    if (localObject != null)
    {
      LinkedList localLinkedList = ((bqy)localObject).Fgd;
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
  
  public final LinkedList<bqs> getMediaList()
  {
    AppMethodBeat.i(166989);
    if (getMediaExtList().size() > 0)
    {
      localLinkedList = getMediaExtList();
      AppMethodBeat.o(166989);
      return localLinkedList;
    }
    LinkedList localLinkedList = this.qYy.objectDesc.media;
    d.g.b.k.g(localLinkedList, "feedObject.objectDesc.media");
    localLinkedList = com.tencent.mm.plugin.finder.storage.data.h.ah(localLinkedList);
    AppMethodBeat.o(166989);
    return localLinkedList;
  }
  
  public final int getMediaType()
  {
    return this.mediaType;
  }
  
  public final String getNickName()
  {
    String str2 = this.qYy.nickname;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final SpannableString getNickNameSpan()
  {
    return this.rDu;
  }
  
  public final String getNotShareMsg()
  {
    String str2 = this.qYy.sendShareFavWording;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String getObjectNonceId()
  {
    String str2 = this.qYy.objectNonceId;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final bqt getPostInfo()
  {
    AppMethodBeat.i(167004);
    bqt localbqt2 = this.field_postinfo;
    bqt localbqt1 = localbqt2;
    if (localbqt2 == null) {
      localbqt1 = new bqt();
    }
    AppMethodBeat.o(167004);
    return localbqt1;
  }
  
  public final int getReadCount()
  {
    return this.qYy.readCount;
  }
  
  public final FinderContact getRefObjectContact()
  {
    AppMethodBeat.i(167002);
    FinderContact localFinderContact2 = this.qYy.refObjectContact;
    FinderContact localFinderContact1 = localFinderContact2;
    if (localFinderContact2 == null) {
      localFinderContact1 = new FinderContact();
    }
    AppMethodBeat.o(167002);
    return localFinderContact1;
  }
  
  public final long getRefObjectFlag()
  {
    return this.qYy.refObjectFlag;
  }
  
  public final long getRefObjectId()
  {
    return this.qYy.refObjectId;
  }
  
  public final long getRelatedFeedId()
  {
    return this.rDt;
  }
  
  public final long getTimestamps()
  {
    return this.rDr;
  }
  
  public final m.a getTopicClickExtra()
  {
    return this.rDq;
  }
  
  public final List<m.c> getTopicList()
  {
    return this.rDx;
  }
  
  public final String getUserName()
  {
    String str2 = this.qYy.username;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String info()
  {
    AppMethodBeat.i(167012);
    StringBuilder localStringBuilder = new StringBuilder("id:").append(this.field_id).append(" username ").append(this.qYy.username).append(" mediaType ").append(this.mediaType).append(" localFlag ").append(this.field_localFlag).append(" description ");
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
      localObject = (String)localObject + " mediaList " + f.bD(getMediaList());
      AppMethodBeat.o(167012);
      return localObject;
      localObject = null;
    }
  }
  
  public final boolean isCommentClose()
  {
    return this.qYy.commentClose == 1;
  }
  
  public final boolean isNeedCrop(int paramInt)
  {
    AppMethodBeat.i(167008);
    bqs localbqs = getCropInfo(paramInt);
    if (localbqs == null)
    {
      AppMethodBeat.o(167008);
      return false;
    }
    if (localbqs.FfP)
    {
      AppMethodBeat.o(167008);
      return true;
    }
    AppMethodBeat.o(167008);
    return false;
  }
  
  public final boolean isNeedVideoCompositionPlay(int paramInt)
  {
    AppMethodBeat.i(202957);
    bqs localbqs = getCropInfo(paramInt);
    n localn = n.rPN;
    if (!n.c(localbqs))
    {
      AppMethodBeat.o(202957);
      return true;
    }
    AppMethodBeat.o(202957);
    return false;
  }
  
  public final boolean isNotShare()
  {
    return this.qYy.objectStatus == 2;
  }
  
  public final boolean isOldVersion()
  {
    return this.qYy.secondaryShowFlag != 1;
  }
  
  public final boolean isOnlySelfSee()
  {
    if (rDz) {}
    while (this.qYy.objectStatus == 1) {
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
    return this.rDs;
  }
  
  public final boolean isUploadFailed()
  {
    AppMethodBeat.i(167011);
    if (getPostInfo().FfT == 2)
    {
      AppMethodBeat.o(167011);
      return true;
    }
    AppMethodBeat.o(167011);
    return false;
  }
  
  public final bqs mediaExt(String paramString)
  {
    AppMethodBeat.i(166993);
    d.g.b.k.h(paramString, "mediaId");
    Object localObject = this.field_mediaExtList;
    if (localObject != null)
    {
      localObject = ((bqy)localObject).Fgd;
      if (localObject != null)
      {
        Iterator localIterator = ((Iterable)localObject).iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = localIterator.next();
        } while (!d.g.b.k.g(((bqs)localObject).mediaId, paramString));
        for (paramString = (String)localObject;; paramString = null)
        {
          paramString = (bqs)paramString;
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
    AppMethodBeat.i(202953);
    Object localObject1 = new b(5, 0, 4, 0, "0");
    Object localObject2 = new b(10, 80, 8, 64, "||");
    int i;
    if (this.mediaType == 2)
    {
      localObject2 = this.qYy.posTriggerConfig;
      if (localObject2 == null) {
        break label373;
      }
      if (((CharSequence)localObject2).length() <= 0) {
        break label333;
      }
      i = 1;
      label79:
      if (i == 0) {
        break label338;
      }
    }
    for (;;)
    {
      if (localObject2 == null) {
        break label373;
      }
      try
      {
        Object localObject3 = new JSONObject((String)localObject2);
        i = ((b)localObject1).rnB;
        if (((JSONObject)localObject3).has("maxUnreadCount")) {
          i = ((JSONObject)localObject3).getInt("maxUnreadCount");
        }
        JSONObject localJSONObject = ((JSONObject)localObject3).getJSONObject("config");
        int j = ((b)localObject1).rDB;
        if (localJSONObject.has("showTime")) {
          j = localJSONObject.getInt("showTime");
        }
        int k = ((b)localObject1).rDC;
        if (localJSONObject.has("showPercentage")) {
          k = localJSONObject.getInt("showPercentage");
        }
        int m = ((b)localObject1).rDD;
        if (localJSONObject.has("preLoadTime")) {
          m = localJSONObject.getInt("preLoadTime");
        }
        int n = ((b)localObject1).rDE;
        if (localJSONObject.has("preLoadPercentage")) {
          n = localJSONObject.getInt("preLoadPercentage");
        }
        localObject3 = ((b)localObject1).rDF;
        if (localJSONObject.has("logic"))
        {
          localObject3 = localJSONObject.getString("logic");
          d.g.b.k.g(localObject3, "config.getString(\"logic\")");
        }
        localObject2 = new b(i, j, k, m, n, (String)localObject3, false, (String)localObject2);
        ac.i(TAG, "[parseJsonOfPosTriggerConfig] config=".concat(String.valueOf(localObject2)));
        AppMethodBeat.o(202953);
        return localObject2;
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace(TAG, (Throwable)localException, "", new Object[0]);
        AppMethodBeat.o(202953);
        return localObject1;
      }
      localObject1 = localObject2;
      break;
      label333:
      i = 0;
      break label79;
      label338:
      localObject2 = null;
    }
    label373:
    AppMethodBeat.o(202953);
    return localObject1;
  }
  
  public final void setCommentCount(int paramInt)
  {
    AppMethodBeat.i(166987);
    ac.d("Finder.FinderItem", "setCommentCount " + this.qYy.hashCode() + ", from:" + getCommentCount() + ", to:" + getCommentCount());
    this.qYy.commentCount = paramInt;
    AppMethodBeat.o(166987);
  }
  
  public final void setCommentList(LinkedList<FinderCommentInfo> paramLinkedList)
  {
    AppMethodBeat.i(166997);
    d.g.b.k.h(paramLinkedList, "value");
    this.qYy.commentList = paramLinkedList;
    AppMethodBeat.o(166997);
  }
  
  public final void setComment_close(int paramInt)
  {
    this.qYy.commentClose = paramInt;
  }
  
  public final void setCreateTime(int paramInt)
  {
    this.qYy.createtime = paramInt;
  }
  
  public final void setDescription(String paramString)
  {
    AppMethodBeat.i(166988);
    d.g.b.k.h(paramString, "value");
    this.qYy.objectDesc.description = paramString;
    this.rDv = com.tencent.mm.pluginsdk.ui.span.k.c(ai.getContext(), (CharSequence)paramString);
    this.rDw = this.rDv;
    ac.w(TAG, "unexpecting write!");
    AppMethodBeat.o(166988);
  }
  
  public final void setDescriptionFullSpan(SpannableString paramSpannableString)
  {
    this.rDw = paramSpannableString;
  }
  
  public final void setDescriptionSpan(SpannableString paramSpannableString)
  {
    this.rDv = paramSpannableString;
  }
  
  public final void setExtReading(ajq paramajq)
  {
    AppMethodBeat.i(167001);
    d.g.b.k.h(paramajq, "value");
    this.qYy.objectDesc.extReading = paramajq;
    AppMethodBeat.o(167001);
  }
  
  public final void setFavCount(int paramInt)
  {
    this.qYy.favCount = paramInt;
  }
  
  public final void setFavFlag(int paramInt)
  {
    this.qYy.favFlag = paramInt;
  }
  
  public final void setFeedObject(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(166980);
    d.g.b.k.h(paramFinderObject, "value");
    Object localObject1 = n.rPN;
    this.mediaType = n.o(paramFinderObject);
    this.field_createTime = paramFinderObject.createtime;
    this.field_id = paramFinderObject.id;
    Object localObject2 = paramFinderObject.username;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.field_username = ((String)localObject1);
    fixMediaType(paramFinderObject);
    this.qYy = paramFinderObject;
    this.field_finderObject = paramFinderObject;
    Object localObject3;
    if (this.exY == 16)
    {
      localObject3 = ai.getContext();
      localObject1 = com.tencent.mm.plugin.finder.search.h.rBC;
      localObject2 = paramFinderObject.nickname;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      this.rDu = com.tencent.mm.pluginsdk.ui.span.k.d((Context)localObject3, (CharSequence)com.tencent.mm.plugin.finder.search.h.adZ((String)localObject1), 0.0F);
      localObject3 = ai.getContext();
      localObject1 = com.tencent.mm.plugin.finder.search.h.rBC;
      localObject2 = paramFinderObject.objectDesc.description;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      this.rDv = com.tencent.mm.pluginsdk.ui.span.k.b((Context)localObject3, (CharSequence)com.tencent.mm.plugin.finder.search.h.adY((String)localObject1), 0.0F);
      localObject1 = com.tencent.mm.plugin.finder.utils.l.rPB;
      localObject1 = paramFinderObject.objectDesc.topic;
      if (localObject1 == null) {
        break label450;
      }
    }
    label439:
    label450:
    for (localObject1 = ((aoo)localObject1).EHF;; localObject1 = null)
    {
      localObject3 = this.rDv;
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = new SpannableString((CharSequence)"");
      }
      long l = this.field_id;
      List localList = this.rDx;
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
      this.rDw = com.tencent.mm.plugin.finder.utils.l.a((String)localObject1, (SpannableString)localObject2, l, localList, (LinkedList)localObject3, paramFinderObject, (m)new c(this), (d.g.a.b)new d(this));
      AppMethodBeat.o(166980);
      return;
      localObject2 = ai.getContext();
      localObject1 = paramFinderObject.nickname;
      if (localObject1 != null)
      {
        localObject1 = (CharSequence)localObject1;
        label377:
        this.rDu = com.tencent.mm.pluginsdk.ui.span.k.c((Context)localObject2, (CharSequence)localObject1);
        localObject2 = ai.getContext();
        localObject1 = paramFinderObject.objectDesc.description;
        if (localObject1 == null) {
          break label439;
        }
      }
      for (localObject1 = (CharSequence)localObject1;; localObject1 = (CharSequence)"")
      {
        this.rDv = com.tencent.mm.pluginsdk.ui.span.k.c((Context)localObject2, (CharSequence)localObject1);
        break;
        localObject1 = (CharSequence)"";
        break label377;
      }
    }
  }
  
  public final void setFoldedLayout(ajz paramajz)
  {
    this.foldedLayout = paramajz;
  }
  
  public final void setForwardCount(int paramInt)
  {
    this.qYy.forwardCount = paramInt;
  }
  
  public final void setFriendLikeCount(int paramInt)
  {
    this.qYy.friendLikeCount = paramInt;
  }
  
  public final void setFromType(int paramInt)
  {
    this.exY = paramInt;
  }
  
  public final void setLikeCount(int paramInt)
  {
    this.qYy.likeCount = paramInt;
  }
  
  public final void setLikeFlag(int paramInt)
  {
    this.qYy.likeFlag = paramInt;
  }
  
  public final void setLikeList(LinkedList<FinderCommentInfo> paramLinkedList)
  {
    AppMethodBeat.i(166995);
    d.g.b.k.h(paramLinkedList, "value");
    this.qYy.likeList = paramLinkedList;
    AppMethodBeat.o(166995);
  }
  
  public final void setLocalId(long paramLong)
  {
    this.field_localId = paramLong;
  }
  
  public final void setLocation(alt paramalt)
  {
    AppMethodBeat.i(166999);
    d.g.b.k.h(paramalt, "value");
    this.qYy.objectDesc.location = paramalt;
    AppMethodBeat.o(166999);
  }
  
  public final void setMediaExtList(LinkedList<bqs> paramLinkedList)
  {
    AppMethodBeat.i(166992);
    d.g.b.k.h(paramLinkedList, "value");
    if (this.field_mediaExtList == null) {
      this.field_mediaExtList = new bqy();
    }
    this.field_mediaExtList.Fgd = paramLinkedList;
    AppMethodBeat.o(166992);
  }
  
  public final void setMediaList(LinkedList<bqs> paramLinkedList)
  {
    AppMethodBeat.i(166990);
    d.g.b.k.h(paramLinkedList, "value");
    FinderObjectDesc localFinderObjectDesc = this.qYy.objectDesc;
    d.g.b.k.h(paramLinkedList, "$this$toServer");
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = ((Iterable)paramLinkedList).iterator();
    while (localIterator.hasNext())
    {
      bqs localbqs = (bqs)localIterator.next();
      d.g.b.k.h(localbqs, "$this$toServer");
      FinderMedia localFinderMedia = new FinderMedia();
      localFinderMedia.url = localbqs.url;
      localFinderMedia.mediaType = localbqs.mediaType;
      localFinderMedia.thumbUrl = localbqs.thumbUrl;
      localFinderMedia.videoDuration = localbqs.videoDuration;
      localFinderMedia.width = localbqs.width;
      localFinderMedia.height = localbqs.height;
      localFinderMedia.md5sum = localbqs.md5sum;
      localFinderMedia.fileSize = localbqs.fileSize;
      localFinderMedia.bitrate = localbqs.bitrate;
      localFinderMedia.coverUrl = localbqs.coverUrl;
      localLinkedList.add(localFinderMedia);
    }
    localFinderObjectDesc.media = localLinkedList;
    if (this.qYy.id == 0L) {
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
    this.qYy.nickname = paramString;
    this.rDu = com.tencent.mm.pluginsdk.ui.span.k.c(ai.getContext(), (CharSequence)paramString);
    AppMethodBeat.o(166985);
  }
  
  public final void setNickNameSpan(SpannableString paramSpannableString)
  {
    this.rDu = paramSpannableString;
  }
  
  public final void setObjectNonceId(String paramString)
  {
    AppMethodBeat.i(166983);
    d.g.b.k.h(paramString, "value");
    this.qYy.objectNonceId = paramString;
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
  
  public final void setPostInfo(bqt parambqt)
  {
    AppMethodBeat.i(167005);
    d.g.b.k.h(parambqt, "field_postinfo");
    this.field_postinfo = parambqt;
    AppMethodBeat.o(167005);
  }
  
  public final void setPostWaiting()
  {
    this.field_localFlag |= 0x1;
    this.field_localFlag &= 0xFFFFFFFD;
  }
  
  public final void setReadCount(int paramInt)
  {
    this.qYy.readCount = paramInt;
  }
  
  public final void setRefObjectContact(FinderContact paramFinderContact)
  {
    AppMethodBeat.i(167003);
    d.g.b.k.h(paramFinderContact, "value");
    this.qYy.refObjectContact = paramFinderContact;
    AppMethodBeat.o(167003);
  }
  
  public final void setRefObjectFlag(long paramLong)
  {
    this.qYy.refObjectFlag = paramLong;
  }
  
  public final void setRefObjectId(long paramLong)
  {
    this.qYy.refObjectId = paramLong;
  }
  
  public final void setRelatedFeedId(long paramLong)
  {
    this.rDt = paramLong;
  }
  
  public final void setRelatedItem(boolean paramBoolean)
  {
    this.rDs = paramBoolean;
  }
  
  public final void setTopicClickExtra(m.a parama)
  {
    AppMethodBeat.i(166981);
    d.g.b.k.h(parama, "<set-?>");
    this.rDq = parama;
    AppMethodBeat.o(166981);
  }
  
  public final void setUserName(String paramString)
  {
    AppMethodBeat.i(166986);
    d.g.b.k.h(paramString, "value");
    this.qYy.username = paramString;
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
        String str = "localId:" + getLocalId() + ", localFlag:" + this.field_localFlag + ", uploadState:" + ((bqt)localObject1).FfT + ", tryCount:" + ((bqt)localObject1).gLY + ", utilNow:" + (ce.azH() - ((bqt)localObject1).FfX) + "ms, mediaProcessCost:" + ((bqt)localObject1).FfZ + "ms, uploadCost:" + ((bqt)localObject1).fWs + "ms, doSceneCost:" + ((bqt)localObject1).Fga + "ms, totalCost:" + ((bqt)localObject1).FfY + "ms";
        localObject1 = "localId:" + getLocalId() + ", mediaList: ";
        Object localObject2 = (Iterable)getMediaExtList();
        int i = 0;
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = ((Iterator)localObject2).next();
          if (i < 0) {
            j.fOc();
          }
          localObject3 = (bqs)localObject3;
          localObject1 = (String)localObject1 + "Index" + i + ", fileSize:" + (float)i.aSp(((bqs)localObject3).url) / 1024.0F / 1024.0F + "MB, mediaType:" + ((bqs)localObject3).mediaType + "; ";
          i += 1;
        }
        ac.i("Finder.PostLog", "stage:" + paramString + ' ' + str);
        ac.i("Finder.PostLog", "stage:" + paramString + ' ' + (String)localObject1);
        AppMethodBeat.o(167013);
        return;
      }
      ac.i("Finder.PostLog", "stage:" + paramString + " localId:" + getLocalId() + ", postInfo is null");
      AppMethodBeat.o(167013);
      return;
    }
    catch (Throwable paramString)
    {
      ac.i("Finder.PostLog", "exception: ".concat(String.valueOf(paramString)));
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
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/storage/FinderItem$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "debugOnlySelfSee", "", "getDebugOnlySelfSee", "()Z", "setDebugOnlySelfSee", "(Z)V", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "create", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "feedObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "type", "", "plugin-finder_release"})
  public static final class a
  {
    public static FinderItem a(FinderObject paramFinderObject, int paramInt)
    {
      AppMethodBeat.i(166977);
      d.g.b.k.h(paramFinderObject, "feedObject");
      FinderItem localFinderItem = new FinderItem();
      localFinderItem.setFromType(paramInt);
      localFinderItem.setFeedObject(paramFinderObject);
      if ((bs.isNullOrNil(localFinderItem.getFeedObject().nickname)) && (localFinderItem.getFeedObject().contact != null) && (!bs.isNullOrNil(localFinderItem.getFeedObject().contact.nickname))) {
        localFinderItem.getFeedObject().nickname = localFinderItem.getFeedObject().contact.nickname;
      }
      AppMethodBeat.o(166977);
      return localFinderItem;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/storage/FinderItem$PosTriggerConfig;", "", "maxUnreadCount", "", "showTime", "showPercentage", "preLoadTime", "preLoadPercentage", "logic", "", "isLocalDefault", "", "jsonStr", "(IIIIILjava/lang/String;ZLjava/lang/String;)V", "()Z", "setLocalDefault", "(Z)V", "getJsonStr", "()Ljava/lang/String;", "setJsonStr", "(Ljava/lang/String;)V", "getLogic", "getMaxUnreadCount", "()I", "getPreLoadPercentage", "getPreLoadTime", "getShowPercentage", "getShowTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "plugin-finder_release"})
  public static final class b
  {
    public String kbW;
    public final int rDB;
    public final int rDC;
    public final int rDD;
    public final int rDE;
    public final String rDF;
    public final int rnB;
    private boolean rvR;
    
    public b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString1, boolean paramBoolean, String paramString2)
    {
      AppMethodBeat.i(202949);
      this.rnB = paramInt1;
      this.rDB = paramInt2;
      this.rDC = paramInt3;
      this.rDD = paramInt4;
      this.rDE = paramInt5;
      this.rDF = paramString1;
      this.rvR = paramBoolean;
      this.kbW = paramString2;
      AppMethodBeat.o(202949);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(202951);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((this.rnB != paramObject.rnB) || (this.rDB != paramObject.rDB) || (this.rDC != paramObject.rDC) || (this.rDD != paramObject.rDD) || (this.rDE != paramObject.rDE) || (!d.g.b.k.g(this.rDF, paramObject.rDF)) || (this.rvR != paramObject.rvR) || (!d.g.b.k.g(this.kbW, paramObject.kbW))) {}
        }
      }
      else
      {
        AppMethodBeat.o(202951);
        return true;
      }
      AppMethodBeat.o(202951);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(202948);
      String str = "maxUnreadCount=" + this.rnB + ",showTime=" + this.rDB + ",showPercentage=" + this.rDC + ",preLoadTime=" + this.rDD + ",preLoadPercentage=" + this.rDE + ",logic=" + this.rDF + ",isLocalDefault=" + this.rvR;
      AppMethodBeat.o(202948);
      return str;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "topic", "", "clickExtra", "Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$ClickExtra;", "invoke"})
  static final class c
    extends d.g.b.l
    implements m<String, m.a, y>
  {
    c(FinderItem paramFinderItem)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "username", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.b<String, y>
  {
    d(FinderItem paramFinderItem)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.FinderItem
 * JD-Core Version:    0.7.0.1
 */