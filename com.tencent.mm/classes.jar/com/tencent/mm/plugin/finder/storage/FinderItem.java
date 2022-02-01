package com.tencent.mm.plugin.finder.storage;

import android.content.Context;
import android.database.Cursor;
import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.f;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.search.h;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.plugin.finder.utils.n;
import com.tencent.mm.plugin.finder.utils.o.a;
import com.tencent.mm.plugin.finder.utils.o.c;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.amn;
import com.tencent.mm.protocal.protobuf.amx;
import com.tencent.mm.protocal.protobuf.aoy;
import com.tencent.mm.protocal.protobuf.asf;
import com.tencent.mm.protocal.protobuf.bvf;
import com.tencent.mm.protocal.protobuf.bvg;
import com.tencent.mm.protocal.protobuf.bvl;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import d.a.j;
import d.g.a.m;
import d.g.b.q;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "Lcom/tencent/mm/autogen/table/BaseFinderFeedItem;", "()V", "value", "", "commentCount", "getCommentCount", "()I", "setCommentCount", "(I)V", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "commentList", "getCommentList", "()Ljava/util/LinkedList;", "setCommentList", "(Ljava/util/LinkedList;)V", "comment_close", "getComment_close", "setComment_close", "createTime", "getCreateTime", "setCreateTime", "debugDescription", "", "getDebugDescription", "()Ljava/lang/String;", "description", "getDescription", "setDescription", "(Ljava/lang/String;)V", "descriptionFullSpan", "Landroid/text/SpannableString;", "getDescriptionFullSpan", "()Landroid/text/SpannableString;", "setDescriptionFullSpan", "(Landroid/text/SpannableString;)V", "descriptionSpan", "getDescriptionSpan", "setDescriptionSpan", "Lcom/tencent/mm/protocal/protobuf/FinderExtendedReading;", "extReading", "getExtReading", "()Lcom/tencent/mm/protocal/protobuf/FinderExtendedReading;", "setExtReading", "(Lcom/tencent/mm/protocal/protobuf/FinderExtendedReading;)V", "favCount", "getFavCount", "setFavCount", "favFlag", "getFavFlag", "setFavFlag", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "feedObject", "getFeedObject", "()Lcom/tencent/mm/protocal/protobuf/FinderObject;", "setFeedObject", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "foldedFeedList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getFoldedFeedList", "()Ljava/util/List;", "foldedFeeds", "", "foldedLayout", "Lcom/tencent/mm/protocal/protobuf/FinderFoldedLayout;", "getFoldedLayout", "()Lcom/tencent/mm/protocal/protobuf/FinderFoldedLayout;", "setFoldedLayout", "(Lcom/tencent/mm/protocal/protobuf/FinderFoldedLayout;)V", "forwardCount", "getForwardCount", "setForwardCount", "friendLikeCount", "getFriendLikeCount", "setFriendLikeCount", "fromType", "getFromType", "setFromType", "isRelatedItem", "", "()Z", "setRelatedItem", "(Z)V", "likeCount", "getLikeCount", "setLikeCount", "likeFlag", "getLikeFlag", "setLikeFlag", "likeList", "getLikeList", "setLikeList", "", "localId", "getLocalId", "()J", "setLocalId", "(J)V", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "location", "getLocation", "()Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "setLocation", "(Lcom/tencent/mm/protocal/protobuf/FinderLocation;)V", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "mediaExtList", "getMediaExtList", "setMediaExtList", "mediaList", "getMediaList", "setMediaList", "mediaType", "getMediaType", "setMediaType", "nickName", "getNickName", "setNickName", "nickNameSpan", "getNickNameSpan", "setNickNameSpan", "objectNonceId", "getObjectNonceId", "setObjectNonceId", "posTriggerConfig", "Lcom/tencent/mm/plugin/finder/storage/FinderItem$PosTriggerConfig;", "getPosTriggerConfig", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem$PosTriggerConfig;", "setPosTriggerConfig", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem$PosTriggerConfig;)V", "private_flag", "getPrivate_flag", "setPrivate_flag", "readCount", "getReadCount", "setReadCount", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "refObjectContact", "getRefObjectContact", "()Lcom/tencent/mm/protocal/protobuf/FinderContact;", "setRefObjectContact", "(Lcom/tencent/mm/protocal/protobuf/FinderContact;)V", "refObjectFlag", "getRefObjectFlag", "setRefObjectFlag", "refObjectId", "getRefObjectId", "setRefObjectId", "relatedFeedId", "getRelatedFeedId", "setRelatedFeedId", "timestamps", "getTimestamps", "topicClickExtra", "Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$ClickExtra;", "getTopicClickExtra", "()Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$ClickExtra;", "setTopicClickExtra", "(Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$ClickExtra;)V", "topicList", "Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$TopicStringInfo;", "getTopicList", "userName", "getUserName", "setUserName", "convertFrom", "", "cu", "Landroid/database/Cursor;", "fixMediaType", "obj", "getCropInfo", "index", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getExpectId", "getFinderObject", "getId", "getNotShareMsg", "getPostInfo", "Lcom/tencent/mm/protocal/protobuf/LocalFinderPostInfo;", "info", "isCommentClose", "isNeedCrop", "isNeedVideoCompositionPlay", "isNotShare", "isOldVersion", "isOnlySelfSee", "isPostFailed", "isPostFailedCanRetry", "isPostFinish", "isPostNoAuth", "isPrivate", "isUploadFailed", "mediaExt", "mediaId", "parseJsonOfPosTriggerConfig", "setPostFailed", "setPostFailedAndNoAuth", "setPostFailedAndNotRetry", "setPostFinish", "setPostInfo", "field_postinfo", "setPostWaiting", "trackPost", "stage", "updateFinderObject", "svrFeed", "Companion", "PosTriggerConfig", "plugin-finder_release"})
public class FinderItem
  extends com.tencent.mm.g.c.cf
{
  private static final String TAG = "Finder.FinderItem";
  private static final c.a info;
  private static boolean syj;
  public static final a syk;
  private int ePx;
  private amx foldedLayout;
  private int mediaType;
  private FinderObject rJO;
  private b sxZ;
  private o.a sya;
  private final long syb;
  private boolean syc;
  private long syd;
  private SpannableString sye;
  private SpannableString syf;
  private SpannableString syg;
  private final List<o.c> syh;
  private List<BaseFinderFeed> syi;
  
  static
  {
    AppMethodBeat.i(167015);
    syk = new a((byte)0);
    c.a locala = com.tencent.mm.g.c.cf.initAutoDBInfo(FinderItem.class);
    d.g.b.p.g(locala, "initAutoDBInfo(FinderItem::class.java)");
    info = locala;
    TAG = "Finder.FinderItem";
    AppMethodBeat.o(167015);
  }
  
  public FinderItem()
  {
    AppMethodBeat.i(167014);
    FinderObject localFinderObject = new FinderObject();
    localFinderObject.objectDesc = new FinderObjectDesc();
    localFinderObject.objectDesc.location = new aoy();
    this.rJO = localFinderObject;
    this.sya = new o.a(0L, (byte)0);
    this.syb = com.tencent.mm.model.cf.aCM();
    this.syh = ((List)new ArrayList());
    this.syi = ((List)new ArrayList());
    AppMethodBeat.o(167014);
  }
  
  private final void fixMediaType(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(166979);
    Object localObject = com.tencent.mm.plugin.finder.utils.p.sMo;
    int i = com.tencent.mm.plugin.finder.utils.p.p(paramFinderObject);
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
    d.g.b.p.h(paramCursor, "cu");
    super.convertFrom(paramCursor);
    FinderObject localFinderObject = this.field_finderObject;
    paramCursor = localFinderObject;
    if (localFinderObject == null) {
      paramCursor = new FinderObject();
    }
    setFeedObject(paramCursor);
    this.rJO.username = u.aAu();
    paramCursor = com.tencent.mm.plugin.finder.utils.p.sMo;
    this.mediaType = com.tencent.mm.plugin.finder.utils.p.p(this.rJO);
    AppMethodBeat.o(166984);
  }
  
  public final int getCommentCount()
  {
    return this.rJO.commentCount;
  }
  
  public final LinkedList<FinderCommentInfo> getCommentList()
  {
    AppMethodBeat.i(166996);
    LinkedList localLinkedList = this.rJO.commentList;
    d.g.b.p.g(localLinkedList, "feedObject.commentList");
    AppMethodBeat.o(166996);
    return localLinkedList;
  }
  
  public final int getComment_close()
  {
    return this.rJO.commentClose;
  }
  
  public final int getCreateTime()
  {
    return this.rJO.createtime;
  }
  
  public final long getCreateTime()
  {
    return this.field_createTime;
  }
  
  public final bvf getCropInfo(int paramInt)
  {
    AppMethodBeat.i(167007);
    Object localObject = getMediaList();
    if (localObject != null)
    {
      localObject = (bvf)j.E((List)localObject, paramInt);
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
    AppMethodBeat.i(203680);
    Object localObject = getDescription();
    int i = Math.min(((String)localObject).length(), 3);
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(203680);
      throw ((Throwable)localObject);
    }
    localObject = ((String)localObject).substring(0, i);
    d.g.b.p.g(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    AppMethodBeat.o(203680);
    return localObject;
  }
  
  public final String getDescription()
  {
    String str2 = this.rJO.objectDesc.description;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final SpannableString getDescriptionFullSpan()
  {
    return this.syg;
  }
  
  public final SpannableString getDescriptionSpan()
  {
    return this.syf;
  }
  
  public final long getExpectId()
  {
    AppMethodBeat.i(203679);
    if (this.field_id == 0L)
    {
      l = getLocalId();
      AppMethodBeat.o(203679);
      return l;
    }
    long l = this.field_id;
    AppMethodBeat.o(203679);
    return l;
  }
  
  public final amn getExtReading()
  {
    AppMethodBeat.i(167000);
    amn localamn2 = this.rJO.objectDesc.extReading;
    amn localamn1 = localamn2;
    if (localamn2 == null)
    {
      localamn1 = new amn();
      localamn1.link = "";
      localamn1.title = "";
    }
    AppMethodBeat.o(167000);
    return localamn1;
  }
  
  public final int getFavCount()
  {
    return this.rJO.favCount;
  }
  
  public final int getFavFlag()
  {
    return this.rJO.favFlag;
  }
  
  public final FinderObject getFeedObject()
  {
    return this.rJO;
  }
  
  public final FinderObject getFinderObject()
  {
    return this.rJO;
  }
  
  public final List<BaseFinderFeed> getFoldedFeedList()
  {
    AppMethodBeat.i(203681);
    Object localObject2;
    if (bt.hj(this.syi))
    {
      localObject1 = getFoldedLayout();
      Object localObject3;
      label82:
      Object localObject4;
      if (localObject1 != null)
      {
        localObject1 = ((amx)localObject1).Gmm;
        if (bt.hj((List)localObject1)) {
          break label279;
        }
        localObject1 = getFoldedLayout();
        if (localObject1 != null)
        {
          localObject1 = ((amx)localObject1).Gmm;
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
            d.g.b.p.g(localObject3, "feed");
            localObject3 = a.a((FinderObject)localObject3, 1);
            localObject4 = com.tencent.mm.plugin.finder.storage.logic.b.sAs;
            ((Collection)localObject1).add(b.a.j((FinderItem)localObject3));
            continue;
            localObject1 = null;
            break;
          }
        }
        localObject1 = (List)localObject1;
        localObject2 = this.syi;
        if (localObject1 == null) {
          break label297;
        }
      }
    }
    label279:
    label297:
    for (Object localObject1 = (Collection)localObject1;; localObject1 = (Collection)d.a.v.MKE)
    {
      ((List)localObject2).addAll((Collection)localObject1);
      localObject1 = this.syi;
      AppMethodBeat.o(203681);
      return localObject1;
      localObject1 = null;
      break;
    }
  }
  
  public final amx getFoldedLayout()
  {
    return this.rJO.foldedLayout;
  }
  
  public final int getForwardCount()
  {
    return this.rJO.forwardCount;
  }
  
  public final int getFriendLikeCount()
  {
    return this.rJO.friendLikeCount;
  }
  
  public final int getFromType()
  {
    return this.ePx;
  }
  
  public final long getId()
  {
    return this.field_id;
  }
  
  public final int getLikeCount()
  {
    return this.rJO.likeCount;
  }
  
  public final int getLikeFlag()
  {
    return this.rJO.likeFlag;
  }
  
  public final LinkedList<FinderCommentInfo> getLikeList()
  {
    AppMethodBeat.i(166994);
    LinkedList localLinkedList = this.rJO.likeList;
    d.g.b.p.g(localLinkedList, "feedObject.likeList");
    AppMethodBeat.o(166994);
    return localLinkedList;
  }
  
  public final long getLocalId()
  {
    return this.field_localId;
  }
  
  public final aoy getLocation()
  {
    AppMethodBeat.i(166998);
    aoy localaoy2 = this.rJO.objectDesc.location;
    aoy localaoy1 = localaoy2;
    if (localaoy2 == null)
    {
      localaoy1 = new aoy();
      localaoy1.ePv = "";
      localaoy1.jDf = "";
    }
    AppMethodBeat.o(166998);
    return localaoy1;
  }
  
  public final LinkedList<bvf> getMediaExtList()
  {
    AppMethodBeat.i(166991);
    Object localObject = this.field_mediaExtList;
    if (localObject != null)
    {
      LinkedList localLinkedList = ((bvl)localObject).GPF;
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
  
  public final LinkedList<bvf> getMediaList()
  {
    AppMethodBeat.i(166989);
    if (getMediaExtList().size() > 0)
    {
      localLinkedList = getMediaExtList();
      AppMethodBeat.o(166989);
      return localLinkedList;
    }
    LinkedList localLinkedList = this.rJO.objectDesc.media;
    d.g.b.p.g(localLinkedList, "feedObject.objectDesc.media");
    localLinkedList = com.tencent.mm.plugin.finder.storage.data.i.aj(localLinkedList);
    AppMethodBeat.o(166989);
    return localLinkedList;
  }
  
  public final int getMediaType()
  {
    return this.mediaType;
  }
  
  public final String getNickName()
  {
    String str2 = this.rJO.nickname;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final SpannableString getNickNameSpan()
  {
    return this.sye;
  }
  
  public final String getNotShareMsg()
  {
    String str2 = this.rJO.sendShareFavWording;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String getObjectNonceId()
  {
    String str2 = this.rJO.objectNonceId;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final b getPosTriggerConfig()
  {
    return this.sxZ;
  }
  
  public final bvg getPostInfo()
  {
    AppMethodBeat.i(167004);
    bvg localbvg2 = this.field_postinfo;
    bvg localbvg1 = localbvg2;
    if (localbvg2 == null) {
      localbvg1 = new bvg();
    }
    AppMethodBeat.o(167004);
    return localbvg1;
  }
  
  public final int getPrivate_flag()
  {
    return this.rJO.privateFlag;
  }
  
  public final int getReadCount()
  {
    return this.rJO.readCount;
  }
  
  public final FinderContact getRefObjectContact()
  {
    AppMethodBeat.i(167002);
    FinderContact localFinderContact2 = this.rJO.refObjectContact;
    FinderContact localFinderContact1 = localFinderContact2;
    if (localFinderContact2 == null) {
      localFinderContact1 = new FinderContact();
    }
    AppMethodBeat.o(167002);
    return localFinderContact1;
  }
  
  public final long getRefObjectFlag()
  {
    return this.rJO.refObjectFlag;
  }
  
  public final long getRefObjectId()
  {
    return this.rJO.refObjectId;
  }
  
  public final long getRelatedFeedId()
  {
    return this.syd;
  }
  
  public final long getTimestamps()
  {
    return this.syb;
  }
  
  public final o.a getTopicClickExtra()
  {
    return this.sya;
  }
  
  public final List<o.c> getTopicList()
  {
    return this.syh;
  }
  
  public final String getUserName()
  {
    String str2 = this.rJO.username;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String info()
  {
    AppMethodBeat.i(167012);
    StringBuilder localStringBuilder = new StringBuilder("id:").append(this.field_id).append(" username ").append(this.rJO.username).append(" mediaType ").append(this.mediaType).append(" localFlag ").append(this.field_localFlag).append(" description ");
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
      d.g.b.p.g(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    }
    for (;;)
    {
      localObject = (String)localObject + " mediaList " + f.bF(getMediaList());
      AppMethodBeat.o(167012);
      return localObject;
      localObject = null;
    }
  }
  
  public final boolean isCommentClose()
  {
    return this.rJO.commentClose == 1;
  }
  
  public final boolean isNeedCrop(int paramInt)
  {
    AppMethodBeat.i(167008);
    bvf localbvf = getCropInfo(paramInt);
    if (localbvf == null)
    {
      AppMethodBeat.o(167008);
      return false;
    }
    if (localbvf.GPt)
    {
      AppMethodBeat.o(167008);
      return true;
    }
    AppMethodBeat.o(167008);
    return false;
  }
  
  public final boolean isNeedVideoCompositionPlay(int paramInt)
  {
    AppMethodBeat.i(203682);
    bvf localbvf = getCropInfo(paramInt);
    com.tencent.mm.plugin.finder.utils.p localp = com.tencent.mm.plugin.finder.utils.p.sMo;
    if (!com.tencent.mm.plugin.finder.utils.p.d(localbvf))
    {
      AppMethodBeat.o(203682);
      return true;
    }
    AppMethodBeat.o(203682);
    return false;
  }
  
  public final boolean isNotShare()
  {
    return this.rJO.objectStatus == 2;
  }
  
  public final boolean isOldVersion()
  {
    return this.rJO.secondaryShowFlag != 1;
  }
  
  public final boolean isOnlySelfSee()
  {
    if (syj) {}
    while (this.rJO.objectStatus == 1) {
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
  
  public final boolean isPrivate()
  {
    return this.rJO.privateFlag == 1;
  }
  
  public final boolean isRelatedItem()
  {
    return this.syc;
  }
  
  public final boolean isUploadFailed()
  {
    AppMethodBeat.i(167011);
    if (getPostInfo().GPx == 2)
    {
      AppMethodBeat.o(167011);
      return true;
    }
    AppMethodBeat.o(167011);
    return false;
  }
  
  public final bvf mediaExt(String paramString)
  {
    AppMethodBeat.i(166993);
    d.g.b.p.h(paramString, "mediaId");
    Object localObject = this.field_mediaExtList;
    if (localObject != null)
    {
      localObject = ((bvl)localObject).GPF;
      if (localObject != null)
      {
        Iterator localIterator = ((Iterable)localObject).iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = localIterator.next();
        } while (!d.g.b.p.i(((bvf)localObject).mediaId, paramString));
        for (paramString = (String)localObject;; paramString = null)
        {
          paramString = (bvf)paramString;
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
    AppMethodBeat.i(203678);
    Object localObject1 = new b(5, 0, 4, 0, "0");
    Object localObject2 = new b(10, 80, 8, 64, "||");
    int i;
    if (this.mediaType == 2)
    {
      localObject2 = this.rJO.posTriggerConfig;
      if (localObject2 == null) {
        break label461;
      }
      if (((CharSequence)localObject2).length() <= 0) {
        break label409;
      }
      i = 1;
      label79:
      label83:
      if ((i != 0) && (localObject2 == null)) {
        break label461;
      }
    }
    label409:
    label461:
    label470:
    label477:
    for (;;)
    {
      boolean bool1;
      try
      {
        JSONObject localJSONObject1 = new JSONObject((String)localObject2);
        i = ((b)localObject1).sbY;
        if (localJSONObject1.has("maxUnreadCount")) {
          i = localJSONObject1.getInt("maxUnreadCount");
        }
        JSONObject localJSONObject2 = localJSONObject1.getJSONObject("config");
        int j = ((b)localObject1).syl;
        if (localJSONObject2.has("showTime")) {
          j = localJSONObject2.getInt("showTime");
        }
        int k = ((b)localObject1).sym;
        if (localJSONObject2.has("showPercentage")) {
          k = localJSONObject2.getInt("showPercentage");
        }
        int m = ((b)localObject1).syn;
        if (localJSONObject2.has("preLoadTime")) {
          m = localJSONObject2.getInt("preLoadTime");
        }
        int n = ((b)localObject1).syo;
        if (localJSONObject2.has("preLoadPercentage")) {
          n = localJSONObject2.getInt("preLoadPercentage");
        }
        String str = ((b)localObject1).syp;
        if (localJSONObject2.has("logic"))
        {
          str = localJSONObject2.getString("logic");
          d.g.b.p.g(str, "config.getString(\"logic\")");
        }
        bool2 = ((b)localObject1).syq;
        if (localJSONObject1.has("favRelateListEnable"))
        {
          if (localJSONObject1.optInt("favRelateListEnable") == 1)
          {
            bool1 = true;
            break label470;
          }
        }
        else
        {
          bool1 = ((b)localObject1).syr;
          if (localJSONObject1.has("favRelateListEnableOnClick"))
          {
            if (localJSONObject1.optInt("favRelateListEnableOnClick") != 1) {
              continue;
            }
            bool1 = true;
            break label477;
          }
          localObject2 = new b(i, j, k, m, n, str, bool2, bool1, false, (String)localObject2);
          ad.i(TAG, "[parseJsonOfPosTriggerConfig] config=".concat(String.valueOf(localObject2)));
          AppMethodBeat.o(203678);
          return localObject2;
          localObject1 = localObject2;
          break;
          i = 0;
          break label79;
          localObject2 = null;
          break label83;
        }
        bool1 = false;
        break label470;
        bool1 = false;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace(TAG, (Throwable)localException, "", new Object[0]);
        AppMethodBeat.o(203678);
        return localObject1;
      }
      AppMethodBeat.o(203678);
      return localObject1;
      boolean bool2 = bool1;
    }
  }
  
  public final void setCommentCount(int paramInt)
  {
    AppMethodBeat.i(166987);
    ad.d("Finder.FinderItem", "setCommentCount " + this.rJO.hashCode() + ", from:" + getCommentCount() + ", to:" + getCommentCount());
    this.rJO.commentCount = paramInt;
    AppMethodBeat.o(166987);
  }
  
  public final void setCommentList(LinkedList<FinderCommentInfo> paramLinkedList)
  {
    AppMethodBeat.i(166997);
    d.g.b.p.h(paramLinkedList, "value");
    this.rJO.commentList = paramLinkedList;
    AppMethodBeat.o(166997);
  }
  
  public final void setComment_close(int paramInt)
  {
    this.rJO.commentClose = paramInt;
  }
  
  public final void setCreateTime(int paramInt)
  {
    this.rJO.createtime = paramInt;
  }
  
  public final void setDescription(String paramString)
  {
    AppMethodBeat.i(166988);
    d.g.b.p.h(paramString, "value");
    this.rJO.objectDesc.description = paramString;
    this.syf = k.c(aj.getContext(), (CharSequence)paramString);
    this.syg = this.syf;
    ad.w(TAG, "unexpecting write!");
    AppMethodBeat.o(166988);
  }
  
  public final void setDescriptionFullSpan(SpannableString paramSpannableString)
  {
    this.syg = paramSpannableString;
  }
  
  public final void setDescriptionSpan(SpannableString paramSpannableString)
  {
    this.syf = paramSpannableString;
  }
  
  public final void setExtReading(amn paramamn)
  {
    AppMethodBeat.i(167001);
    d.g.b.p.h(paramamn, "value");
    this.rJO.objectDesc.extReading = paramamn;
    AppMethodBeat.o(167001);
  }
  
  public final void setFavCount(int paramInt)
  {
    this.rJO.favCount = paramInt;
  }
  
  public final void setFavFlag(int paramInt)
  {
    this.rJO.favFlag = paramInt;
  }
  
  public final void setFeedObject(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(166980);
    d.g.b.p.h(paramFinderObject, "value");
    Object localObject1 = com.tencent.mm.plugin.finder.utils.p.sMo;
    this.mediaType = com.tencent.mm.plugin.finder.utils.p.p(paramFinderObject);
    this.field_createTime = paramFinderObject.createtime;
    this.field_id = paramFinderObject.id;
    Object localObject2 = paramFinderObject.username;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.field_username = ((String)localObject1);
    fixMediaType(paramFinderObject);
    this.rJO = paramFinderObject;
    this.field_finderObject = paramFinderObject;
    Object localObject3;
    if (this.ePx == 16)
    {
      localObject3 = aj.getContext();
      localObject1 = h.stT;
      localObject2 = paramFinderObject.nickname;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      this.sye = k.d((Context)localObject3, (CharSequence)h.ahY((String)localObject1), 0.0F);
      localObject3 = aj.getContext();
      localObject1 = h.stT;
      localObject2 = paramFinderObject.objectDesc.description;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      this.syf = k.b((Context)localObject3, (CharSequence)h.ahX((String)localObject1), 0.0F);
      localObject1 = n.sMc;
      localObject1 = paramFinderObject.objectDesc.topic;
      if (localObject1 == null) {
        break label450;
      }
    }
    label439:
    label450:
    for (localObject1 = ((asf)localObject1).Gqu;; localObject1 = null)
    {
      localObject3 = this.syf;
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = new SpannableString((CharSequence)"");
      }
      long l = this.field_id;
      List localList = this.syh;
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
      this.syg = n.a((String)localObject1, (SpannableString)localObject2, l, localList, (LinkedList)localObject3, paramFinderObject, (m)new c(this), (d.g.a.b)new d(this));
      AppMethodBeat.o(166980);
      return;
      localObject2 = aj.getContext();
      localObject1 = paramFinderObject.nickname;
      if (localObject1 != null)
      {
        localObject1 = (CharSequence)localObject1;
        label377:
        this.sye = k.c((Context)localObject2, (CharSequence)localObject1);
        localObject2 = aj.getContext();
        localObject1 = paramFinderObject.objectDesc.description;
        if (localObject1 == null) {
          break label439;
        }
      }
      for (localObject1 = (CharSequence)localObject1;; localObject1 = (CharSequence)"")
      {
        this.syf = k.c((Context)localObject2, (CharSequence)localObject1);
        break;
        localObject1 = (CharSequence)"";
        break label377;
      }
    }
  }
  
  public final void setFoldedLayout(amx paramamx)
  {
    this.foldedLayout = paramamx;
  }
  
  public final void setForwardCount(int paramInt)
  {
    this.rJO.forwardCount = paramInt;
  }
  
  public final void setFriendLikeCount(int paramInt)
  {
    this.rJO.friendLikeCount = paramInt;
  }
  
  public final void setFromType(int paramInt)
  {
    this.ePx = paramInt;
  }
  
  public final void setLikeCount(int paramInt)
  {
    this.rJO.likeCount = paramInt;
  }
  
  public final void setLikeFlag(int paramInt)
  {
    this.rJO.likeFlag = paramInt;
  }
  
  public final void setLikeList(LinkedList<FinderCommentInfo> paramLinkedList)
  {
    AppMethodBeat.i(166995);
    d.g.b.p.h(paramLinkedList, "value");
    this.rJO.likeList = paramLinkedList;
    AppMethodBeat.o(166995);
  }
  
  public final void setLocalId(long paramLong)
  {
    this.field_localId = paramLong;
  }
  
  public final void setLocation(aoy paramaoy)
  {
    AppMethodBeat.i(166999);
    d.g.b.p.h(paramaoy, "value");
    this.rJO.objectDesc.location = paramaoy;
    AppMethodBeat.o(166999);
  }
  
  public final void setMediaExtList(LinkedList<bvf> paramLinkedList)
  {
    AppMethodBeat.i(166992);
    d.g.b.p.h(paramLinkedList, "value");
    if (this.field_mediaExtList == null) {
      this.field_mediaExtList = new bvl();
    }
    this.field_mediaExtList.GPF = paramLinkedList;
    AppMethodBeat.o(166992);
  }
  
  public final void setMediaList(LinkedList<bvf> paramLinkedList)
  {
    AppMethodBeat.i(166990);
    d.g.b.p.h(paramLinkedList, "value");
    FinderObjectDesc localFinderObjectDesc = this.rJO.objectDesc;
    d.g.b.p.h(paramLinkedList, "$this$toServer");
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = ((Iterable)paramLinkedList).iterator();
    while (localIterator.hasNext())
    {
      bvf localbvf = (bvf)localIterator.next();
      d.g.b.p.h(localbvf, "$this$toServer");
      FinderMedia localFinderMedia = new FinderMedia();
      localFinderMedia.url = localbvf.url;
      localFinderMedia.mediaType = localbvf.mediaType;
      localFinderMedia.thumbUrl = localbvf.thumbUrl;
      localFinderMedia.videoDuration = localbvf.videoDuration;
      localFinderMedia.width = localbvf.width;
      localFinderMedia.height = localbvf.height;
      localFinderMedia.md5sum = localbvf.md5sum;
      localFinderMedia.fileSize = localbvf.fileSize;
      localFinderMedia.bitrate = localbvf.bitrate;
      localFinderMedia.coverUrl = localbvf.coverUrl;
      localFinderMedia.codec_info = localbvf.codec_info;
      localLinkedList.add(localFinderMedia);
    }
    localFinderObjectDesc.media = localLinkedList;
    if (this.rJO.id == 0L) {
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
    d.g.b.p.h(paramString, "value");
    this.rJO.nickname = paramString;
    this.sye = k.c(aj.getContext(), (CharSequence)paramString);
    AppMethodBeat.o(166985);
  }
  
  public final void setNickNameSpan(SpannableString paramSpannableString)
  {
    this.sye = paramSpannableString;
  }
  
  public final void setObjectNonceId(String paramString)
  {
    AppMethodBeat.i(166983);
    d.g.b.p.h(paramString, "value");
    this.rJO.objectNonceId = paramString;
    AppMethodBeat.o(166983);
  }
  
  public final void setPosTriggerConfig(b paramb)
  {
    this.sxZ = paramb;
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
  
  public final void setPostInfo(bvg parambvg)
  {
    AppMethodBeat.i(167005);
    d.g.b.p.h(parambvg, "field_postinfo");
    this.field_postinfo = parambvg;
    AppMethodBeat.o(167005);
  }
  
  public final void setPostWaiting()
  {
    this.field_localFlag |= 0x1;
    this.field_localFlag &= 0xFFFFFFFD;
  }
  
  public final void setPrivate_flag(int paramInt)
  {
    this.rJO.privateFlag = paramInt;
  }
  
  public final void setReadCount(int paramInt)
  {
    this.rJO.readCount = paramInt;
  }
  
  public final void setRefObjectContact(FinderContact paramFinderContact)
  {
    AppMethodBeat.i(167003);
    d.g.b.p.h(paramFinderContact, "value");
    this.rJO.refObjectContact = paramFinderContact;
    AppMethodBeat.o(167003);
  }
  
  public final void setRefObjectFlag(long paramLong)
  {
    this.rJO.refObjectFlag = paramLong;
  }
  
  public final void setRefObjectId(long paramLong)
  {
    this.rJO.refObjectId = paramLong;
  }
  
  public final void setRelatedFeedId(long paramLong)
  {
    this.syd = paramLong;
  }
  
  public final void setRelatedItem(boolean paramBoolean)
  {
    this.syc = paramBoolean;
  }
  
  public final void setTopicClickExtra(o.a parama)
  {
    AppMethodBeat.i(166981);
    d.g.b.p.h(parama, "<set-?>");
    this.sya = parama;
    AppMethodBeat.o(166981);
  }
  
  public final void setUserName(String paramString)
  {
    AppMethodBeat.i(166986);
    d.g.b.p.h(paramString, "value");
    this.rJO.username = paramString;
    AppMethodBeat.o(166986);
  }
  
  public final void trackPost(String paramString)
  {
    AppMethodBeat.i(167013);
    d.g.b.p.h(paramString, "stage");
    try
    {
      Object localObject1 = this.field_postinfo;
      if (localObject1 != null)
      {
        String str = "localId:" + getLocalId() + ", localFlag:" + this.field_localFlag + ", uploadState:" + ((bvg)localObject1).GPx + ", tryCount:" + ((bvg)localObject1).hfV + ", utilNow:" + (com.tencent.mm.model.cf.aCK() - ((bvg)localObject1).GPA) + "ms, mediaProcessCost:" + ((bvg)localObject1).GPB + "ms, uploadCost:" + ((bvg)localObject1).gpV + "ms, doSceneCost:" + ((bvg)localObject1).GPC + "ms, totalCost:" + ((bvg)localObject1).whI + "ms";
        localObject1 = "localId:" + getLocalId() + ", mediaList: ";
        Object localObject2 = (Iterable)getMediaExtList();
        int i = 0;
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = ((Iterator)localObject2).next();
          if (i < 0) {
            j.gfB();
          }
          localObject3 = (bvf)localObject3;
          localObject1 = (String)localObject1 + "Index" + i + ", fileSize:" + (float)com.tencent.mm.vfs.i.aYo(((bvf)localObject3).url) / 1024.0F / 1024.0F + "MB, mediaType:" + ((bvf)localObject3).mediaType + "; ";
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
    d.g.b.p.h(paramFinderObject, "svrFeed");
    this.field_username = paramFinderObject.username;
    this.field_finderObject = paramFinderObject;
    setFeedObject(paramFinderObject);
    this.field_id = paramFinderObject.id;
    this.field_createTime = paramFinderObject.createtime;
    AppMethodBeat.o(167006);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/FinderItem$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "debugOnlySelfSee", "", "getDebugOnlySelfSee", "()Z", "setDebugOnlySelfSee", "(Z)V", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "create", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "feedObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "type", "", "plugin-finder_release"})
  public static final class a
  {
    public static FinderItem a(FinderObject paramFinderObject, int paramInt)
    {
      AppMethodBeat.i(166977);
      d.g.b.p.h(paramFinderObject, "feedObject");
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/FinderItem$PosTriggerConfig;", "", "maxUnreadCount", "", "showTime", "showPercentage", "preLoadTime", "preLoadPercentage", "logic", "", "favRelateListEnable", "", "favRelateListEnableOnClick", "isLocalDefault", "jsonStr", "(IIIIILjava/lang/String;ZZZLjava/lang/String;)V", "getFavRelateListEnable", "()Z", "getFavRelateListEnableOnClick", "setLocalDefault", "(Z)V", "getJsonStr", "()Ljava/lang/String;", "setJsonStr", "(Ljava/lang/String;)V", "getLogic", "getMaxUnreadCount", "()I", "getPreLoadPercentage", "getPreLoadTime", "getShowPercentage", "getShowTime", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "plugin-finder_release"})
  public static final class b
  {
    public String kwv;
    public final int sbY;
    private boolean slx;
    public final int syl;
    public final int sym;
    public final int syn;
    public final int syo;
    public final String syp;
    public final boolean syq;
    public final boolean syr;
    
    public b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString2)
    {
      AppMethodBeat.i(203674);
      this.sbY = paramInt1;
      this.syl = paramInt2;
      this.sym = paramInt3;
      this.syn = paramInt4;
      this.syo = paramInt5;
      this.syp = paramString1;
      this.syq = paramBoolean1;
      this.syr = paramBoolean2;
      this.slx = paramBoolean3;
      this.kwv = paramString2;
      AppMethodBeat.o(203674);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(203676);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((this.sbY != paramObject.sbY) || (this.syl != paramObject.syl) || (this.sym != paramObject.sym) || (this.syn != paramObject.syn) || (this.syo != paramObject.syo) || (!d.g.b.p.i(this.syp, paramObject.syp)) || (this.syq != paramObject.syq) || (this.syr != paramObject.syr) || (this.slx != paramObject.slx) || (!d.g.b.p.i(this.kwv, paramObject.kwv))) {}
        }
      }
      else
      {
        AppMethodBeat.o(203676);
        return true;
      }
      AppMethodBeat.o(203676);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(203673);
      String str = "maxUnreadCount=" + this.sbY + ",showTime=" + this.syl + ",showPercentage=" + this.sym + ",preLoadTime=" + this.syn + ',' + "preLoadPercentage=" + this.syo + ",logic=" + this.syp + ",favRelateListEnable=" + this.syq + ",favRelateListEnableOnClick=" + this.syr + ",isLocalDefault=" + this.slx;
      AppMethodBeat.o(203673);
      return str;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "topic", "", "clickExtra", "Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$ClickExtra;", "invoke"})
  static final class c
    extends q
    implements m<String, o.a, z>
  {
    c(FinderItem paramFinderItem)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "username", "", "invoke"})
  static final class d
    extends q
    implements d.g.a.b<String, z>
  {
    d(FinderItem paramFinderItem)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.FinderItem
 * JD-Core Version:    0.7.0.1
 */