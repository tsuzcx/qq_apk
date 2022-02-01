package com.tencent.mm.plugin.finder.model;

import com.tencent.mm.ac.d;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.b;
import com.tencent.mm.plugin.finder.storage.k;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.azk;
import com.tencent.mm.protocal.protobuf.azr;
import com.tencent.mm.protocal.protobuf.bcw;
import com.tencent.mm.protocal.protobuf.cjl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/plugin/finder/model/IFeedSessionBuffer;", "feedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "attachFavInfo", "Lcom/tencent/mm/plugin/finder/storage/FinderFeedAttachInfoItem;", "getAttachFavInfo", "()Lcom/tencent/mm/plugin/finder/storage/FinderFeedAttachInfoItem;", "setAttachFavInfo", "(Lcom/tencent/mm/plugin/finder/storage/FinderFeedAttachInfoItem;)V", "commentList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "getCommentList", "()Ljava/util/LinkedList;", "setCommentList", "(Ljava/util/LinkedList;)V", "contact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "getContact", "()Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "setContact", "(Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;)V", "doingRelReq", "", "getDoingRelReq", "()Z", "setDoingRelReq", "(Z)V", "getFeedObject", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFeedObject", "footerWording", "", "getFooterWording", "()Ljava/lang/String;", "setFooterWording", "(Ljava/lang/String;)V", "headerWording", "getHeaderWording", "setHeaderWording", "isContentCollapsed", "setContentCollapsed", "isDeepEnjoy", "setDeepEnjoy", "isFinishPostSoon", "setFinishPostSoon", "isHasLongVideoTimeBack", "setHasLongVideoTimeBack", "isNeedShowUnFollow", "setNeedShowUnFollow", "isOriginFeed", "setOriginFeed", "isPreview", "setPreview", "isShowFooterMask", "setShowFooterMask", "isShowGuideTips", "", "()I", "setShowGuideTips", "(I)V", "isShowHistoryTips", "setShowHistoryTips", "likeBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLikeBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLikeBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "markRead", "getMarkRead", "setMarkRead", "msgEventFriendLikeCount", "getMsgEventFriendLikeCount", "setMsgEventFriendLikeCount", "msgEventIncCount", "getMsgEventIncCount", "setMsgEventIncCount", "msgEventLikeList", "", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "getMsgEventLikeList", "()Ljava/util/List;", "setMsgEventLikeList", "(Ljava/util/List;)V", "musicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "getMusicInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "showCommentEdu", "getShowCommentEdu", "setShowCommentEdu", "showLikeTips", "getShowLikeTips", "setShowLikeTips", "showShareSns", "getShowShareSns", "setShowShareSns", "streamDivider", "Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;", "getStreamDivider", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;", "setStreamDivider", "(Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;)V", "triggerConfig", "Lcom/tencent/mm/plugin/finder/storage/FinderItem$PosTriggerConfig;", "getTriggerConfig", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem$PosTriggerConfig;", "setTriggerConfig", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem$PosTriggerConfig;)V", "compare", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "equals", "other", "", "getItemId", "", "getItemType", "getSessionBuffer", "hashCode", "onStore", "", "printSimpleId", "toString", "plugin-finder_release"})
public abstract class BaseFinderFeed
  implements bo
{
  public k attachFavInfo;
  private LinkedList<s> commentList;
  public g contact;
  public boolean doingRelReq;
  public FinderItem feedObject;
  public String footerWording;
  public String headerWording;
  public boolean isContentCollapsed;
  public boolean isDeepEnjoy;
  public boolean isFinishPostSoon;
  public boolean isHasLongVideoTimeBack;
  private boolean isNeedShowUnFollow;
  public boolean isOriginFeed;
  public boolean isPreview;
  private boolean isShowFooterMask;
  public int isShowGuideTips;
  private int isShowHistoryTips;
  public b likeBuffer;
  public boolean markRead;
  public int msgEventFriendLikeCount;
  public int msgEventIncCount;
  public List<? extends FinderCommentInfo> msgEventLikeList;
  public final azk musicInfo;
  public boolean showCommentEdu;
  public boolean showLikeTips;
  public boolean showShareSns;
  public bcw streamDivider;
  public FinderItem.b triggerConfig;
  
  public BaseFinderFeed(FinderItem paramFinderItem)
  {
    this.feedObject = paramFinderItem;
    this.commentList = new LinkedList();
    this.isContentCollapsed = true;
    this.headerWording = "";
    this.footerWording = "";
    this.msgEventFriendLikeCount = paramFinderItem.getFriendLikeCount();
    this.msgEventIncCount = paramFinderItem.getFeedObject().incFriendLikeCount;
    Object localObject1 = (Iterable)paramFinderItem.getLikeList();
    Collection localCollection = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    label143:
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (((FinderCommentInfo)localObject2).unreadFlag == 1) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label143;
        }
        localCollection.add(localObject2);
        break;
      }
    }
    this.msgEventLikeList = ((List)localCollection);
    this.triggerConfig = paramFinderItem.parseJsonOfPosTriggerConfig();
    this.likeBuffer = paramFinderItem.getFeedObject().likeBuffer;
    this.isPreview = paramFinderItem.isPreview();
    paramFinderItem = paramFinderItem.getFeedObject().objectDesc;
    if (paramFinderItem != null)
    {
      paramFinderItem = paramFinderItem.feedBgmInfo;
      if (paramFinderItem == null) {}
    }
    for (paramFinderItem = paramFinderItem.musicInfo;; paramFinderItem = null)
    {
      this.musicInfo = paramFinderItem;
      return;
    }
  }
  
  public int a(i parami)
  {
    p.h(parami, "obj");
    if (!(parami instanceof BaseFinderFeed)) {
      parami = null;
    }
    for (;;)
    {
      parami = (BaseFinderFeed)parami;
      if (parami != null)
      {
        if ((parami.feedObject.field_id != 0L) && (this.feedObject.field_id != 0L) && (parami.feedObject.field_id == this.feedObject.field_id)) {
          return 0;
        }
        if ((parami.feedObject.getLocalId() > 0L) && (this.feedObject.getLocalId() > 0L) && (parami.feedObject.getLocalId() == this.feedObject.getLocalId())) {
          return 0;
        }
        if (this.feedObject.getCreateTime() > parami.feedObject.getCreateTime()) {
          return 1;
        }
        return -1;
      }
      return -1;
    }
  }
  
  public int cxn()
  {
    return this.feedObject.getMediaType();
  }
  
  public final void dku()
  {
    this.showLikeTips = false;
    this.showShareSns = false;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof BaseFinderFeed)) {
      return lT() == ((BaseFinderFeed)paramObject).lT();
    }
    return super.equals(paramObject);
  }
  
  public final String getSessionBuffer()
  {
    String str2 = this.feedObject.getFeedObject().sessionBuffer;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public int hashCode()
  {
    return (int)lT();
  }
  
  public long lT()
  {
    if (this.feedObject.field_id == 0L) {
      return this.feedObject.getLocalId();
    }
    return this.feedObject.field_id;
  }
  
  public String toString()
  {
    String str1;
    if ("".length() > 3)
    {
      str1 = "".substring(0, 3);
      p.g(str1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    }
    for (;;)
    {
      int i = this.feedObject.getCreateTime();
      if (this.feedObject.getMediaList().size() > 0) {}
      for (String str2 = ((cjl)this.feedObject.getMediaList().get(0)).url;; str2 = "") {
        return "id=[" + this.feedObject.field_id + ',' + d.zs(this.feedObject.field_id) + "] type=" + this.feedObject.getMediaType() + " localId=" + this.feedObject.getLocalId() + " time:" + Integer.valueOf(i) + " url:" + str2 + ' ' + str1;
      }
      str1 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.BaseFinderFeed
 * JD-Core Version:    0.7.0.1
 */