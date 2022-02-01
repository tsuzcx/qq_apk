package com.tencent.mm.plugin.finder.storage;

import android.content.Context;
import android.database.Cursor;
import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.ac.f;
import com.tencent.mm.g.c.cf;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.search.h;
import com.tencent.mm.plugin.finder.storage.data.i;
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
import com.tencent.mm.protocal.protobuf.amz;
import com.tencent.mm.protocal.protobuf.ank;
import com.tencent.mm.protocal.protobuf.apl;
import com.tencent.mm.protocal.protobuf.asu;
import com.tencent.mm.protocal.protobuf.bvz;
import com.tencent.mm.protocal.protobuf.bwa;
import com.tencent.mm.protocal.protobuf.bwf;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "Lcom/tencent/mm/autogen/table/BaseFinderFeedItem;", "()V", "value", "", "commentCount", "getCommentCount", "()I", "setCommentCount", "(I)V", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "commentList", "getCommentList", "()Ljava/util/LinkedList;", "setCommentList", "(Ljava/util/LinkedList;)V", "comment_close", "getComment_close", "setComment_close", "createTime", "getCreateTime", "setCreateTime", "debugDescription", "", "getDebugDescription", "()Ljava/lang/String;", "description", "getDescription", "setDescription", "(Ljava/lang/String;)V", "descriptionFullSpan", "Landroid/text/SpannableString;", "getDescriptionFullSpan", "()Landroid/text/SpannableString;", "setDescriptionFullSpan", "(Landroid/text/SpannableString;)V", "descriptionSpan", "getDescriptionSpan", "setDescriptionSpan", "Lcom/tencent/mm/protocal/protobuf/FinderExtendedReading;", "extReading", "getExtReading", "()Lcom/tencent/mm/protocal/protobuf/FinderExtendedReading;", "setExtReading", "(Lcom/tencent/mm/protocal/protobuf/FinderExtendedReading;)V", "favCount", "getFavCount", "setFavCount", "favFlag", "getFavFlag", "setFavFlag", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "feedObject", "getFeedObject", "()Lcom/tencent/mm/protocal/protobuf/FinderObject;", "setFeedObject", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "foldedFeedList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getFoldedFeedList", "()Ljava/util/List;", "foldedFeeds", "", "foldedLayout", "Lcom/tencent/mm/protocal/protobuf/FinderFoldedLayout;", "getFoldedLayout", "()Lcom/tencent/mm/protocal/protobuf/FinderFoldedLayout;", "setFoldedLayout", "(Lcom/tencent/mm/protocal/protobuf/FinderFoldedLayout;)V", "forwardCount", "getForwardCount", "setForwardCount", "friendLikeCount", "getFriendLikeCount", "setFriendLikeCount", "fromType", "getFromType", "setFromType", "isRelatedItem", "", "()Z", "setRelatedItem", "(Z)V", "likeCount", "getLikeCount", "setLikeCount", "likeFlag", "getLikeFlag", "setLikeFlag", "likeList", "getLikeList", "setLikeList", "", "localId", "getLocalId", "()J", "setLocalId", "(J)V", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "location", "getLocation", "()Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "setLocation", "(Lcom/tencent/mm/protocal/protobuf/FinderLocation;)V", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "mediaExtList", "getMediaExtList", "setMediaExtList", "mediaList", "getMediaList", "setMediaList", "mediaType", "getMediaType", "setMediaType", "nickName", "getNickName", "setNickName", "nickNameSpan", "getNickNameSpan", "setNickNameSpan", "objectNonceId", "getObjectNonceId", "setObjectNonceId", "posTriggerConfig", "Lcom/tencent/mm/plugin/finder/storage/FinderItem$PosTriggerConfig;", "getPosTriggerConfig", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem$PosTriggerConfig;", "setPosTriggerConfig", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem$PosTriggerConfig;)V", "private_flag", "getPrivate_flag", "setPrivate_flag", "readCount", "getReadCount", "setReadCount", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "refObjectContact", "getRefObjectContact", "()Lcom/tencent/mm/protocal/protobuf/FinderContact;", "setRefObjectContact", "(Lcom/tencent/mm/protocal/protobuf/FinderContact;)V", "refObjectFlag", "getRefObjectFlag", "setRefObjectFlag", "refObjectId", "getRefObjectId", "setRefObjectId", "relatedFeedId", "getRelatedFeedId", "setRelatedFeedId", "timestamps", "getTimestamps", "topicClickExtra", "Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$ClickExtra;", "getTopicClickExtra", "()Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$ClickExtra;", "setTopicClickExtra", "(Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$ClickExtra;)V", "topicList", "Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$TopicStringInfo;", "getTopicList", "userName", "getUserName", "setUserName", "convertFrom", "", "cu", "Landroid/database/Cursor;", "fixMediaType", "obj", "getCropInfo", "index", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getExpectId", "getFinderObject", "getId", "getNotShareMsg", "getPostInfo", "Lcom/tencent/mm/protocal/protobuf/LocalFinderPostInfo;", "getUnsignedId", "info", "isCommentClose", "isNeedCrop", "isNeedVideoCompositionPlay", "isNotShare", "isOldVersion", "isOnlySelfSee", "isPostFailed", "isPostFailedCanRetry", "isPostFinish", "isPostNoAuth", "isPrivate", "isUploadFailed", "mediaExt", "mediaId", "parseJsonOfPosTriggerConfig", "setPostFailed", "setPostFailedAndNoAuth", "setPostFailedAndNotRetry", "setPostFinish", "setPostInfo", "field_postinfo", "setPostWaiting", "trackPost", "stage", "updateFinderObject", "svrFeed", "Companion", "PosTriggerConfig", "plugin-finder_release"})
public class FinderItem
  extends cf
{
  private static final String TAG = "Finder.FinderItem";
  private static final c.a info;
  private static boolean sJa;
  public static final a sJb;
  private int eRi;
  private ank foldedLayout;
  private int mediaType;
  private FinderObject rSc;
  private b sIQ;
  private o.a sIR;
  private final long sIS;
  private boolean sIT;
  private long sIU;
  private SpannableString sIV;
  private SpannableString sIW;
  private SpannableString sIX;
  private final List<o.c> sIY;
  private List<BaseFinderFeed> sIZ;
  
  static
  {
    AppMethodBeat.i(167015);
    sJb = new a((byte)0);
    c.a locala = cf.initAutoDBInfo(FinderItem.class);
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
    FinderObjectDesc localFinderObjectDesc = localFinderObject.objectDesc;
    if (localFinderObjectDesc != null) {
      localFinderObjectDesc.location = new apl();
    }
    this.rSc = localFinderObject;
    this.sIR = new o.a(0L, (byte)0);
    this.sIS = ch.aDc();
    this.sIY = ((List)new ArrayList());
    this.sIZ = ((List)new ArrayList());
    AppMethodBeat.o(167014);
  }
  
  private final void fixMediaType(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(166979);
    Object localObject = com.tencent.mm.plugin.finder.utils.p.sXz;
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
    this.rSc.username = com.tencent.mm.model.v.aAK();
    paramCursor = com.tencent.mm.plugin.finder.utils.p.sXz;
    this.mediaType = com.tencent.mm.plugin.finder.utils.p.p(this.rSc);
    AppMethodBeat.o(166984);
  }
  
  public final int getCommentCount()
  {
    return this.rSc.commentCount;
  }
  
  public final LinkedList<FinderCommentInfo> getCommentList()
  {
    AppMethodBeat.i(166996);
    LinkedList localLinkedList = this.rSc.commentList;
    d.g.b.p.g(localLinkedList, "feedObject.commentList");
    AppMethodBeat.o(166996);
    return localLinkedList;
  }
  
  public final int getComment_close()
  {
    return this.rSc.commentClose;
  }
  
  public final int getCreateTime()
  {
    return this.rSc.createtime;
  }
  
  public final long getCreateTime()
  {
    return this.field_createTime;
  }
  
  public final bvz getCropInfo(int paramInt)
  {
    AppMethodBeat.i(167007);
    Object localObject = getMediaList();
    if (localObject != null)
    {
      localObject = (bvz)j.F((List)localObject, paramInt);
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
    AppMethodBeat.i(204248);
    Object localObject = getDescription();
    int i = Math.min(((String)localObject).length(), 3);
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(204248);
      throw ((Throwable)localObject);
    }
    localObject = ((String)localObject).substring(0, i);
    d.g.b.p.g(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    AppMethodBeat.o(204248);
    return localObject;
  }
  
  public final String getDescription()
  {
    Object localObject = this.rSc.objectDesc;
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
    return this.sIX;
  }
  
  public final SpannableString getDescriptionSpan()
  {
    return this.sIW;
  }
  
  public final long getExpectId()
  {
    AppMethodBeat.i(204247);
    if (this.field_id == 0L)
    {
      l = getLocalId();
      AppMethodBeat.o(204247);
      return l;
    }
    long l = this.field_id;
    AppMethodBeat.o(204247);
    return l;
  }
  
  public final amz getExtReading()
  {
    AppMethodBeat.i(167000);
    Object localObject = this.rSc.objectDesc;
    if (localObject != null)
    {
      amz localamz = ((FinderObjectDesc)localObject).extReading;
      localObject = localamz;
      if (localamz != null) {}
    }
    else
    {
      localObject = new amz();
      ((amz)localObject).link = "";
      ((amz)localObject).title = "";
    }
    AppMethodBeat.o(167000);
    return localObject;
  }
  
  public final int getFavCount()
  {
    return this.rSc.favCount;
  }
  
  public final int getFavFlag()
  {
    return this.rSc.favFlag;
  }
  
  public final FinderObject getFeedObject()
  {
    return this.rSc;
  }
  
  public final FinderObject getFinderObject()
  {
    return this.rSc;
  }
  
  public final List<BaseFinderFeed> getFoldedFeedList()
  {
    AppMethodBeat.i(204249);
    Object localObject2;
    if (bu.ht(this.sIZ))
    {
      localObject1 = getFoldedLayout();
      Object localObject3;
      label82:
      Object localObject4;
      if (localObject1 != null)
      {
        localObject1 = ((ank)localObject1).GFu;
        if (bu.ht((List)localObject1)) {
          break label279;
        }
        localObject1 = getFoldedLayout();
        if (localObject1 != null)
        {
          localObject1 = ((ank)localObject1).GFu;
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
            localObject4 = com.tencent.mm.plugin.finder.storage.logic.b.sLq;
            ((Collection)localObject1).add(b.a.j((FinderItem)localObject3));
            continue;
            localObject1 = null;
            break;
          }
        }
        localObject1 = (List)localObject1;
        localObject2 = this.sIZ;
        if (localObject1 == null) {
          break label297;
        }
      }
    }
    label279:
    label297:
    for (Object localObject1 = (Collection)localObject1;; localObject1 = (Collection)d.a.v.NhH)
    {
      ((List)localObject2).addAll((Collection)localObject1);
      localObject1 = this.sIZ;
      AppMethodBeat.o(204249);
      return localObject1;
      localObject1 = null;
      break;
    }
  }
  
  public final ank getFoldedLayout()
  {
    return this.rSc.foldedLayout;
  }
  
  public final int getForwardCount()
  {
    return this.rSc.forwardCount;
  }
  
  public final int getFriendLikeCount()
  {
    return this.rSc.friendLikeCount;
  }
  
  public final int getFromType()
  {
    return this.eRi;
  }
  
  public final long getId()
  {
    return this.field_id;
  }
  
  public final int getLikeCount()
  {
    return this.rSc.likeCount;
  }
  
  public final int getLikeFlag()
  {
    return this.rSc.likeFlag;
  }
  
  public final LinkedList<FinderCommentInfo> getLikeList()
  {
    AppMethodBeat.i(166994);
    LinkedList localLinkedList = this.rSc.likeList;
    d.g.b.p.g(localLinkedList, "feedObject.likeList");
    AppMethodBeat.o(166994);
    return localLinkedList;
  }
  
  public final long getLocalId()
  {
    return this.field_localId;
  }
  
  public final apl getLocation()
  {
    AppMethodBeat.i(166998);
    Object localObject = this.rSc.objectDesc;
    if (localObject != null)
    {
      apl localapl = ((FinderObjectDesc)localObject).location;
      localObject = localapl;
      if (localapl != null) {}
    }
    else
    {
      localObject = new apl();
      ((apl)localObject).eRg = "";
      ((apl)localObject).jGd = "";
    }
    AppMethodBeat.o(166998);
    return localObject;
  }
  
  public final LinkedList<bvz> getMediaExtList()
  {
    AppMethodBeat.i(166991);
    Object localObject = this.field_mediaExtList;
    if (localObject != null)
    {
      LinkedList localLinkedList = ((bwf)localObject).Hjh;
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
  
  public final LinkedList<bvz> getMediaList()
  {
    AppMethodBeat.i(166989);
    if (getMediaExtList().size() > 0)
    {
      localObject = getMediaExtList();
      AppMethodBeat.o(166989);
      return localObject;
    }
    Object localObject = this.rSc.objectDesc;
    if (localObject != null)
    {
      localObject = ((FinderObjectDesc)localObject).media;
      if (localObject != null)
      {
        localObject = i.aj((LinkedList)localObject);
        AppMethodBeat.o(166989);
        return localObject;
      }
    }
    localObject = new LinkedList();
    AppMethodBeat.o(166989);
    return localObject;
  }
  
  public final int getMediaType()
  {
    return this.mediaType;
  }
  
  public final String getNickName()
  {
    String str2 = this.rSc.nickname;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final SpannableString getNickNameSpan()
  {
    return this.sIV;
  }
  
  public final String getNotShareMsg()
  {
    String str2 = this.rSc.sendShareFavWording;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String getObjectNonceId()
  {
    String str2 = this.rSc.objectNonceId;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final b getPosTriggerConfig()
  {
    return this.sIQ;
  }
  
  public final bwa getPostInfo()
  {
    AppMethodBeat.i(167004);
    bwa localbwa2 = this.field_postinfo;
    bwa localbwa1 = localbwa2;
    if (localbwa2 == null) {
      localbwa1 = new bwa();
    }
    AppMethodBeat.o(167004);
    return localbwa1;
  }
  
  public final int getPrivate_flag()
  {
    return this.rSc.privateFlag;
  }
  
  public final int getReadCount()
  {
    return this.rSc.readCount;
  }
  
  public final FinderContact getRefObjectContact()
  {
    AppMethodBeat.i(167002);
    FinderContact localFinderContact2 = this.rSc.refObjectContact;
    FinderContact localFinderContact1 = localFinderContact2;
    if (localFinderContact2 == null) {
      localFinderContact1 = new FinderContact();
    }
    AppMethodBeat.o(167002);
    return localFinderContact1;
  }
  
  public final long getRefObjectFlag()
  {
    return this.rSc.refObjectFlag;
  }
  
  public final long getRefObjectId()
  {
    return this.rSc.refObjectId;
  }
  
  public final long getRelatedFeedId()
  {
    return this.sIU;
  }
  
  public final long getTimestamps()
  {
    return this.sIS;
  }
  
  public final o.a getTopicClickExtra()
  {
    return this.sIR;
  }
  
  public final List<o.c> getTopicList()
  {
    return this.sIY;
  }
  
  public final String getUnsignedId()
  {
    AppMethodBeat.i(204246);
    String str = c.rp(getId());
    AppMethodBeat.o(204246);
    return str;
  }
  
  public final String getUserName()
  {
    String str2 = this.rSc.username;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String info()
  {
    AppMethodBeat.i(167012);
    StringBuilder localStringBuilder = new StringBuilder("id:").append(this.field_id).append(" username ").append(this.rSc.username).append(" mediaType ").append(this.mediaType).append(" localFlag ").append(this.field_localFlag).append(" description ");
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
    return this.rSc.commentClose == 1;
  }
  
  public final boolean isNeedCrop(int paramInt)
  {
    AppMethodBeat.i(167008);
    bvz localbvz = getCropInfo(paramInt);
    if (localbvz == null)
    {
      AppMethodBeat.o(167008);
      return false;
    }
    if (localbvz.HiV)
    {
      AppMethodBeat.o(167008);
      return true;
    }
    AppMethodBeat.o(167008);
    return false;
  }
  
  public final boolean isNeedVideoCompositionPlay(int paramInt)
  {
    AppMethodBeat.i(204250);
    bvz localbvz = getCropInfo(paramInt);
    com.tencent.mm.plugin.finder.utils.p localp = com.tencent.mm.plugin.finder.utils.p.sXz;
    if (!com.tencent.mm.plugin.finder.utils.p.d(localbvz))
    {
      AppMethodBeat.o(204250);
      return true;
    }
    AppMethodBeat.o(204250);
    return false;
  }
  
  public final boolean isNotShare()
  {
    return this.rSc.objectStatus == 2;
  }
  
  public final boolean isOldVersion()
  {
    return this.rSc.secondaryShowFlag != 1;
  }
  
  public final boolean isOnlySelfSee()
  {
    if (sJa) {}
    while (this.rSc.objectStatus == 1) {
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
    return this.rSc.privateFlag == 1;
  }
  
  public final boolean isRelatedItem()
  {
    return this.sIT;
  }
  
  public final boolean isUploadFailed()
  {
    AppMethodBeat.i(167011);
    if (getPostInfo().HiZ == 2)
    {
      AppMethodBeat.o(167011);
      return true;
    }
    AppMethodBeat.o(167011);
    return false;
  }
  
  public final bvz mediaExt(String paramString)
  {
    AppMethodBeat.i(166993);
    d.g.b.p.h(paramString, "mediaId");
    Object localObject = this.field_mediaExtList;
    if (localObject != null)
    {
      localObject = ((bwf)localObject).Hjh;
      if (localObject != null)
      {
        Iterator localIterator = ((Iterable)localObject).iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = localIterator.next();
        } while (!d.g.b.p.i(((bvz)localObject).mediaId, paramString));
        for (paramString = (String)localObject;; paramString = null)
        {
          paramString = (bvz)paramString;
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
    AppMethodBeat.i(204245);
    Object localObject1 = new b(5, 0, 4, 0, "0");
    Object localObject2 = new b(10, 80, 8, 64, "||");
    int i;
    if (this.mediaType == 2)
    {
      localObject2 = this.rSc.posTriggerConfig;
      if (localObject2 == null) {
        break label469;
      }
      d.g.b.p.g(localObject2, "it");
      if (((CharSequence)localObject2).length() <= 0) {
        break label417;
      }
      i = 1;
      label87:
      label91:
      if ((i != 0) && (localObject2 == null)) {
        break label469;
      }
    }
    label417:
    label469:
    label478:
    label485:
    for (;;)
    {
      boolean bool1;
      try
      {
        JSONObject localJSONObject1 = new JSONObject((String)localObject2);
        i = ((b)localObject1).skP;
        if (localJSONObject1.has("maxUnreadCount")) {
          i = localJSONObject1.getInt("maxUnreadCount");
        }
        JSONObject localJSONObject2 = localJSONObject1.getJSONObject("config");
        int j = ((b)localObject1).sJc;
        if (localJSONObject2.has("showTime")) {
          j = localJSONObject2.getInt("showTime");
        }
        int k = ((b)localObject1).sJd;
        if (localJSONObject2.has("showPercentage")) {
          k = localJSONObject2.getInt("showPercentage");
        }
        int m = ((b)localObject1).sJe;
        if (localJSONObject2.has("preLoadTime")) {
          m = localJSONObject2.getInt("preLoadTime");
        }
        int n = ((b)localObject1).sJf;
        if (localJSONObject2.has("preLoadPercentage")) {
          n = localJSONObject2.getInt("preLoadPercentage");
        }
        String str = ((b)localObject1).sJg;
        if (localJSONObject2.has("logic"))
        {
          str = localJSONObject2.getString("logic");
          d.g.b.p.g(str, "config.getString(\"logic\")");
        }
        bool2 = ((b)localObject1).sJh;
        if (localJSONObject1.has("favRelateListEnable"))
        {
          if (localJSONObject1.optInt("favRelateListEnable") == 1)
          {
            bool1 = true;
            break label478;
          }
        }
        else
        {
          bool1 = ((b)localObject1).sJi;
          if (localJSONObject1.has("favRelateListEnableOnClick"))
          {
            if (localJSONObject1.optInt("favRelateListEnableOnClick") != 1) {
              continue;
            }
            bool1 = true;
            break label485;
          }
          localObject2 = new b(i, j, k, m, n, str, bool2, bool1, false, (String)localObject2);
          ae.i(TAG, "[parseJsonOfPosTriggerConfig] config=".concat(String.valueOf(localObject2)));
          AppMethodBeat.o(204245);
          return localObject2;
          localObject1 = localObject2;
          break;
          i = 0;
          break label87;
          localObject2 = null;
          break label91;
        }
        bool1 = false;
        break label478;
        bool1 = false;
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace(TAG, (Throwable)localException, "", new Object[0]);
        AppMethodBeat.o(204245);
        return localObject1;
      }
      AppMethodBeat.o(204245);
      return localObject1;
      boolean bool2 = bool1;
    }
  }
  
  public final void setCommentCount(int paramInt)
  {
    AppMethodBeat.i(166987);
    ae.d("Finder.FinderItem", "setCommentCount " + this.rSc.hashCode() + ", from:" + getCommentCount() + ", to:" + getCommentCount());
    this.rSc.commentCount = paramInt;
    AppMethodBeat.o(166987);
  }
  
  public final void setCommentList(LinkedList<FinderCommentInfo> paramLinkedList)
  {
    AppMethodBeat.i(166997);
    d.g.b.p.h(paramLinkedList, "value");
    this.rSc.commentList = paramLinkedList;
    AppMethodBeat.o(166997);
  }
  
  public final void setComment_close(int paramInt)
  {
    this.rSc.commentClose = paramInt;
  }
  
  public final void setCreateTime(int paramInt)
  {
    this.rSc.createtime = paramInt;
  }
  
  public final void setDescription(String paramString)
  {
    AppMethodBeat.i(166988);
    d.g.b.p.h(paramString, "value");
    FinderObjectDesc localFinderObjectDesc = this.rSc.objectDesc;
    if (localFinderObjectDesc != null) {
      localFinderObjectDesc.description = paramString;
    }
    this.sIW = k.c(ak.getContext(), (CharSequence)paramString);
    this.sIX = this.sIW;
    ae.w(TAG, "unexpecting write!");
    AppMethodBeat.o(166988);
  }
  
  public final void setDescriptionFullSpan(SpannableString paramSpannableString)
  {
    this.sIX = paramSpannableString;
  }
  
  public final void setDescriptionSpan(SpannableString paramSpannableString)
  {
    this.sIW = paramSpannableString;
  }
  
  public final void setExtReading(amz paramamz)
  {
    AppMethodBeat.i(167001);
    d.g.b.p.h(paramamz, "value");
    FinderObjectDesc localFinderObjectDesc = this.rSc.objectDesc;
    if (localFinderObjectDesc != null)
    {
      localFinderObjectDesc.extReading = paramamz;
      AppMethodBeat.o(167001);
      return;
    }
    AppMethodBeat.o(167001);
  }
  
  public final void setFavCount(int paramInt)
  {
    this.rSc.favCount = paramInt;
  }
  
  public final void setFavFlag(int paramInt)
  {
    this.rSc.favFlag = paramInt;
  }
  
  public final void setFeedObject(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(166980);
    d.g.b.p.h(paramFinderObject, "value");
    Object localObject1 = com.tencent.mm.plugin.finder.utils.p.sXz;
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
    this.rSc = paramFinderObject;
    this.field_finderObject = paramFinderObject;
    Object localObject3;
    if (this.eRi == 16)
    {
      localObject3 = ak.getContext();
      localObject1 = h.sEe;
      localObject2 = paramFinderObject.nickname;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      this.sIV = k.d((Context)localObject3, (CharSequence)h.aiW((String)localObject1), 0.0F);
      localObject3 = ak.getContext();
      localObject1 = h.sEe;
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
      this.sIW = k.b((Context)localObject3, (CharSequence)h.aiV((String)localObject1), 0.0F);
      localObject1 = n.sXn;
      localObject1 = paramFinderObject.objectDesc;
      if (localObject1 == null) {
        break label483;
      }
      localObject1 = ((FinderObjectDesc)localObject1).topic;
      if (localObject1 == null) {
        break label483;
      }
    }
    label401:
    label472:
    label483:
    for (localObject1 = ((asu)localObject1).GJP;; localObject1 = null)
    {
      localObject3 = this.sIW;
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = new SpannableString((CharSequence)"");
      }
      long l = this.field_id;
      List localList = this.sIY;
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
      this.sIX = n.a((String)localObject1, (SpannableString)localObject2, l, localList, (LinkedList)localObject3, paramFinderObject, (m)new c(this), (d.g.a.b)new d(this));
      AppMethodBeat.o(166980);
      return;
      localObject2 = ak.getContext();
      localObject1 = paramFinderObject.nickname;
      if (localObject1 != null)
      {
        localObject1 = (CharSequence)localObject1;
        this.sIV = k.c((Context)localObject2, (CharSequence)localObject1);
        localObject2 = ak.getContext();
        localObject1 = paramFinderObject.objectDesc;
        if (localObject1 == null) {
          break label472;
        }
        localObject1 = ((FinderObjectDesc)localObject1).description;
        if (localObject1 == null) {
          break label472;
        }
      }
      for (localObject1 = (CharSequence)localObject1;; localObject1 = (CharSequence)"")
      {
        this.sIW = k.c((Context)localObject2, (CharSequence)localObject1);
        break;
        localObject1 = (CharSequence)"";
        break label401;
      }
    }
  }
  
  public final void setFoldedLayout(ank paramank)
  {
    this.foldedLayout = paramank;
  }
  
  public final void setForwardCount(int paramInt)
  {
    this.rSc.forwardCount = paramInt;
  }
  
  public final void setFriendLikeCount(int paramInt)
  {
    this.rSc.friendLikeCount = paramInt;
  }
  
  public final void setFromType(int paramInt)
  {
    this.eRi = paramInt;
  }
  
  public final void setLikeCount(int paramInt)
  {
    this.rSc.likeCount = paramInt;
  }
  
  public final void setLikeFlag(int paramInt)
  {
    this.rSc.likeFlag = paramInt;
  }
  
  public final void setLikeList(LinkedList<FinderCommentInfo> paramLinkedList)
  {
    AppMethodBeat.i(166995);
    d.g.b.p.h(paramLinkedList, "value");
    this.rSc.likeList = paramLinkedList;
    AppMethodBeat.o(166995);
  }
  
  public final void setLocalId(long paramLong)
  {
    this.field_localId = paramLong;
  }
  
  public final void setLocation(apl paramapl)
  {
    AppMethodBeat.i(166999);
    d.g.b.p.h(paramapl, "value");
    FinderObjectDesc localFinderObjectDesc = this.rSc.objectDesc;
    if (localFinderObjectDesc != null)
    {
      localFinderObjectDesc.location = paramapl;
      AppMethodBeat.o(166999);
      return;
    }
    AppMethodBeat.o(166999);
  }
  
  public final void setMediaExtList(LinkedList<bvz> paramLinkedList)
  {
    AppMethodBeat.i(166992);
    d.g.b.p.h(paramLinkedList, "value");
    if (this.field_mediaExtList == null) {
      this.field_mediaExtList = new bwf();
    }
    this.field_mediaExtList.Hjh = paramLinkedList;
    AppMethodBeat.o(166992);
  }
  
  public final void setMediaList(LinkedList<bvz> paramLinkedList)
  {
    AppMethodBeat.i(166990);
    d.g.b.p.h(paramLinkedList, "value");
    FinderObjectDesc localFinderObjectDesc = this.rSc.objectDesc;
    if (localFinderObjectDesc != null)
    {
      d.g.b.p.h(paramLinkedList, "$this$toServer");
      LinkedList localLinkedList = new LinkedList();
      Iterator localIterator = ((Iterable)paramLinkedList).iterator();
      while (localIterator.hasNext())
      {
        bvz localbvz = (bvz)localIterator.next();
        d.g.b.p.h(localbvz, "$this$toServer");
        FinderMedia localFinderMedia = new FinderMedia();
        localFinderMedia.url = localbvz.url;
        localFinderMedia.mediaType = localbvz.mediaType;
        localFinderMedia.thumbUrl = localbvz.thumbUrl;
        localFinderMedia.videoDuration = localbvz.videoDuration;
        localFinderMedia.width = localbvz.width;
        localFinderMedia.height = localbvz.height;
        localFinderMedia.md5sum = localbvz.md5sum;
        localFinderMedia.fileSize = localbvz.fileSize;
        localFinderMedia.bitrate = localbvz.bitrate;
        localFinderMedia.coverUrl = localbvz.coverUrl;
        localFinderMedia.codec_info = localbvz.codec_info;
        localLinkedList.add(localFinderMedia);
      }
      localFinderObjectDesc.media = localLinkedList;
    }
    if (this.rSc.id == 0L) {
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
    this.rSc.nickname = paramString;
    this.sIV = k.c(ak.getContext(), (CharSequence)paramString);
    AppMethodBeat.o(166985);
  }
  
  public final void setNickNameSpan(SpannableString paramSpannableString)
  {
    this.sIV = paramSpannableString;
  }
  
  public final void setObjectNonceId(String paramString)
  {
    AppMethodBeat.i(166983);
    d.g.b.p.h(paramString, "value");
    this.rSc.objectNonceId = paramString;
    AppMethodBeat.o(166983);
  }
  
  public final void setPosTriggerConfig(b paramb)
  {
    this.sIQ = paramb;
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
  
  public final void setPostInfo(bwa parambwa)
  {
    AppMethodBeat.i(167005);
    d.g.b.p.h(parambwa, "field_postinfo");
    this.field_postinfo = parambwa;
    AppMethodBeat.o(167005);
  }
  
  public final void setPostWaiting()
  {
    this.field_localFlag |= 0x1;
    this.field_localFlag &= 0xFFFFFFFD;
  }
  
  public final void setPrivate_flag(int paramInt)
  {
    this.rSc.privateFlag = paramInt;
  }
  
  public final void setReadCount(int paramInt)
  {
    this.rSc.readCount = paramInt;
  }
  
  public final void setRefObjectContact(FinderContact paramFinderContact)
  {
    AppMethodBeat.i(167003);
    d.g.b.p.h(paramFinderContact, "value");
    this.rSc.refObjectContact = paramFinderContact;
    AppMethodBeat.o(167003);
  }
  
  public final void setRefObjectFlag(long paramLong)
  {
    this.rSc.refObjectFlag = paramLong;
  }
  
  public final void setRefObjectId(long paramLong)
  {
    this.rSc.refObjectId = paramLong;
  }
  
  public final void setRelatedFeedId(long paramLong)
  {
    this.sIU = paramLong;
  }
  
  public final void setRelatedItem(boolean paramBoolean)
  {
    this.sIT = paramBoolean;
  }
  
  public final void setTopicClickExtra(o.a parama)
  {
    AppMethodBeat.i(166981);
    d.g.b.p.h(parama, "<set-?>");
    this.sIR = parama;
    AppMethodBeat.o(166981);
  }
  
  public final void setUserName(String paramString)
  {
    AppMethodBeat.i(166986);
    d.g.b.p.h(paramString, "value");
    this.rSc.username = paramString;
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
        String str = "localId:" + getLocalId() + ", localFlag:" + this.field_localFlag + ", uploadState:" + ((bwa)localObject1).HiZ + ", tryCount:" + ((bwa)localObject1).hiJ + ", utilNow:" + (ch.aDa() - ((bwa)localObject1).Hjc) + "ms, mediaProcessCost:" + ((bwa)localObject1).Hjd + "ms, uploadCost:" + ((bwa)localObject1).gsq + "ms, doSceneCost:" + ((bwa)localObject1).Hje + "ms, totalCost:" + ((bwa)localObject1).wxm + "ms";
        localObject1 = "localId:" + getLocalId() + ", mediaList: ";
        Object localObject2 = (Iterable)getMediaExtList();
        int i = 0;
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = ((Iterator)localObject2).next();
          if (i < 0) {
            j.gkd();
          }
          localObject3 = (bvz)localObject3;
          localObject1 = (String)localObject1 + "Index" + i + ", fileSize:" + (float)o.aZR(((bvz)localObject3).url) / 1024.0F / 1024.0F + "MB, mediaType:" + ((bvz)localObject3).mediaType + "; ";
          i += 1;
        }
        ae.i("Finder.PostLog", "stage:" + paramString + ' ' + str);
        ae.i("Finder.PostLog", "stage:" + paramString + ' ' + (String)localObject1);
        AppMethodBeat.o(167013);
        return;
      }
      ae.i("Finder.PostLog", "stage:" + paramString + " localId:" + getLocalId() + ", postInfo is null");
      AppMethodBeat.o(167013);
      return;
    }
    catch (Throwable paramString)
    {
      ae.i("Finder.PostLog", "exception: ".concat(String.valueOf(paramString)));
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/storage/FinderItem$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "debugOnlySelfSee", "", "getDebugOnlySelfSee", "()Z", "setDebugOnlySelfSee", "(Z)V", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "create", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "feedObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "type", "", "plugin-finder_release"})
  public static final class a
  {
    public static FinderItem a(FinderObject paramFinderObject, int paramInt)
    {
      AppMethodBeat.i(166977);
      d.g.b.p.h(paramFinderObject, "feedObject");
      FinderItem localFinderItem = new FinderItem();
      localFinderItem.setFromType(paramInt);
      localFinderItem.setFeedObject(paramFinderObject);
      if ((bu.isNullOrNil(localFinderItem.getFeedObject().nickname)) && (localFinderItem.getFeedObject().contact != null))
      {
        paramFinderObject = localFinderItem.getFeedObject().contact;
        if (paramFinderObject == null) {
          break label121;
        }
      }
      label121:
      for (paramFinderObject = paramFinderObject.nickname;; paramFinderObject = null)
      {
        if (!bu.isNullOrNil(paramFinderObject))
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
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/storage/FinderItem$PosTriggerConfig;", "", "maxUnreadCount", "", "showTime", "showPercentage", "preLoadTime", "preLoadPercentage", "logic", "", "favRelateListEnable", "", "favRelateListEnableOnClick", "isLocalDefault", "jsonStr", "(IIIIILjava/lang/String;ZZZLjava/lang/String;)V", "getFavRelateListEnable", "()Z", "getFavRelateListEnableOnClick", "setLocalDefault", "(Z)V", "getJsonStr", "()Ljava/lang/String;", "setJsonStr", "(Ljava/lang/String;)V", "getLogic", "getMaxUnreadCount", "()I", "getPreLoadPercentage", "getPreLoadTime", "getShowPercentage", "getShowTime", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "plugin-finder_release"})
  public static final class b
  {
    public String kzK;
    public final int sJc;
    public final int sJd;
    public final int sJe;
    public final int sJf;
    public final String sJg;
    public final boolean sJh;
    public final boolean sJi;
    public final int skP;
    private boolean suw;
    
    public b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString2)
    {
      AppMethodBeat.i(204241);
      this.skP = paramInt1;
      this.sJc = paramInt2;
      this.sJd = paramInt3;
      this.sJe = paramInt4;
      this.sJf = paramInt5;
      this.sJg = paramString1;
      this.sJh = paramBoolean1;
      this.sJi = paramBoolean2;
      this.suw = paramBoolean3;
      this.kzK = paramString2;
      AppMethodBeat.o(204241);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(204243);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((this.skP != paramObject.skP) || (this.sJc != paramObject.sJc) || (this.sJd != paramObject.sJd) || (this.sJe != paramObject.sJe) || (this.sJf != paramObject.sJf) || (!d.g.b.p.i(this.sJg, paramObject.sJg)) || (this.sJh != paramObject.sJh) || (this.sJi != paramObject.sJi) || (this.suw != paramObject.suw) || (!d.g.b.p.i(this.kzK, paramObject.kzK))) {}
        }
      }
      else
      {
        AppMethodBeat.o(204243);
        return true;
      }
      AppMethodBeat.o(204243);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(204240);
      String str = "maxUnreadCount=" + this.skP + ",showTime=" + this.sJc + ",showPercentage=" + this.sJd + ",preLoadTime=" + this.sJe + ',' + "preLoadPercentage=" + this.sJf + ",logic=" + this.sJg + ",favRelateListEnable=" + this.sJh + ",favRelateListEnableOnClick=" + this.sJi + ",isLocalDefault=" + this.suw;
      AppMethodBeat.o(204240);
      return str;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "topic", "", "clickExtra", "Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$ClickExtra;", "invoke"})
  static final class c
    extends q
    implements m<String, o.a, z>
  {
    c(FinderItem paramFinderItem)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "username", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.FinderItem
 * JD-Core Version:    0.7.0.1
 */