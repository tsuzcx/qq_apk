package com.tencent.mm.plugin.finder.model;

import com.tencent.mm.ae.d;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bqj;
import com.tencent.mm.protocal.protobuf.bqz;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.dji;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/plugin/finder/model/IFeedSessionBuffer;", "feedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "attachFavInfo", "Lcom/tencent/mm/plugin/finder/storage/FinderFeedAttachInfoItem;", "getAttachFavInfo", "()Lcom/tencent/mm/plugin/finder/storage/FinderFeedAttachInfoItem;", "setAttachFavInfo", "(Lcom/tencent/mm/plugin/finder/storage/FinderFeedAttachInfoItem;)V", "commentList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "getCommentList", "()Ljava/util/LinkedList;", "setCommentList", "(Ljava/util/LinkedList;)V", "contact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "getContact", "()Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "setContact", "(Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;)V", "currentFocusPos", "", "getCurrentFocusPos", "()I", "setCurrentFocusPos", "(I)V", "currentUsed", "", "getCurrentUsed", "()Z", "setCurrentUsed", "(Z)V", "doingRelReq", "getDoingRelReq", "setDoingRelReq", "getFeedObject", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFeedObject", "footerWording", "", "getFooterWording", "()Ljava/lang/String;", "setFooterWording", "(Ljava/lang/String;)V", "headerWording", "getHeaderWording", "setHeaderWording", "ignoreLongTerm", "getIgnoreLongTerm", "setIgnoreLongTerm", "isContentCollapsed", "setContentCollapsed", "isDeepEnjoy", "setDeepEnjoy", "isFinishPostSoon", "setFinishPostSoon", "isHalfEnjoy", "setHalfEnjoy", "isHasLongVideoTimeBack", "setHasLongVideoTimeBack", "isHasShowGuideHot", "setHasShowGuideHot", "isHistoryFeed", "setHistoryFeed", "isNeedShowUnFollow", "setNeedShowUnFollow", "isOriginFeed", "setOriginFeed", "isPreview", "setPreview", "isShowFooterMask", "setShowFooterMask", "isShowGuideTips", "setShowGuideTips", "isShowHistoryTips", "setShowHistoryTips", "isTenSecEnjoy", "setTenSecEnjoy", "likeBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLikeBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLikeBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "markRead", "getMarkRead", "setMarkRead", "msgEventFriendLikeCount", "getMsgEventFriendLikeCount", "setMsgEventFriendLikeCount", "msgEventIncCount", "getMsgEventIncCount", "setMsgEventIncCount", "msgEventLikeList", "", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "getMsgEventLikeList", "()Ljava/util/List;", "setMsgEventLikeList", "(Ljava/util/List;)V", "musicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "getMusicInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "showCommentEdu", "getShowCommentEdu", "setShowCommentEdu", "showLikeTips", "getShowLikeTips", "setShowLikeTips", "showShareSns", "getShowShareSns", "setShowShareSns", "streamDivider", "Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;", "getStreamDivider", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;", "setStreamDivider", "(Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;)V", "compare", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "equals", "other", "", "getItemId", "", "getItemType", "getSessionBuffer", "hashCode", "onStore", "", "printSimpleId", "toString", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class BaseFinderFeed
  implements cc
{
  public com.tencent.mm.plugin.finder.storage.m attachFavInfo;
  private LinkedList<t> commentList;
  public com.tencent.mm.plugin.finder.api.m contact;
  public int currentFocusPos;
  public boolean currentUsed;
  private boolean doingRelReq;
  public FinderItem feedObject;
  public String footerWording;
  public String headerWording;
  public boolean ignoreLongTerm;
  private boolean isContentCollapsed;
  public boolean isDeepEnjoy;
  public boolean isFinishPostSoon;
  public boolean isHalfEnjoy;
  public boolean isHasLongVideoTimeBack;
  public boolean isHasShowGuideHot;
  public boolean isHistoryFeed;
  private boolean isNeedShowUnFollow;
  public boolean isOriginFeed;
  public boolean isPreview;
  private boolean isShowFooterMask;
  public int isShowGuideTips;
  private int isShowHistoryTips;
  public boolean isTenSecEnjoy;
  public b likeBuffer;
  public boolean markRead;
  public int msgEventFriendLikeCount;
  public int msgEventIncCount;
  public List<? extends FinderCommentInfo> msgEventLikeList;
  public final bqj musicInfo;
  public boolean showCommentEdu;
  public boolean showLikeTips;
  public boolean showShareSns;
  public bwc streamDivider;
  
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
    this.likeBuffer = paramFinderItem.getFeedObject().likeBuffer;
    this.isPreview = paramFinderItem.isPreview();
    paramFinderItem = paramFinderItem.getFeedObject().objectDesc;
    if (paramFinderItem == null) {
      paramFinderItem = null;
    }
    for (;;)
    {
      this.musicInfo = paramFinderItem;
      return;
      paramFinderItem = paramFinderItem.feedBgmInfo;
      if (paramFinderItem == null) {
        paramFinderItem = null;
      } else {
        paramFinderItem = paramFinderItem.musicInfo;
      }
    }
  }
  
  public int a(k paramk)
  {
    s.u(paramk, "obj");
    if ((paramk instanceof BaseFinderFeed))
    {
      paramk = (BaseFinderFeed)paramk;
      if (paramk == null) {
        break label135;
      }
      if ((paramk.feedObject.field_id == 0L) || (this.feedObject.field_id == 0L) || (paramk.feedObject.field_id != this.feedObject.field_id)) {
        break label72;
      }
    }
    label72:
    while ((paramk.feedObject.getLocalId() > 0L) && (this.feedObject.getLocalId() > 0L) && (paramk.feedObject.getLocalId() == this.feedObject.getLocalId()))
    {
      return 0;
      paramk = null;
      break;
    }
    if (this.feedObject.getCreateTime() > paramk.feedObject.getCreateTime()) {
      return 1;
    }
    return -1;
    label135:
    return -1;
  }
  
  public long bZA()
  {
    if (this.feedObject.field_id == 0L) {
      return this.feedObject.getLocalId();
    }
    return this.feedObject.field_id;
  }
  
  public int bZB()
  {
    return this.feedObject.getMediaType();
  }
  
  public final FinderItem eDf()
  {
    return this.feedObject;
  }
  
  public final void eDg()
  {
    this.showLikeTips = false;
    this.showShareSns = false;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof BaseFinderFeed)) {
      return bZA() == ((BaseFinderFeed)paramObject).bZA();
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
    return (int)bZA();
  }
  
  public String toString()
  {
    String str1;
    if ("".length() > 3)
    {
      str1 = "".substring(0, 3);
      s.s(str1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    }
    for (;;)
    {
      int i = this.feedObject.getCreateTime();
      if (this.feedObject.getMediaList().size() > 0) {}
      for (String str2 = ((dji)this.feedObject.getMediaList().get(0)).url;; str2 = "") {
        return "id=[" + this.feedObject.field_id + ',' + d.hF(this.feedObject.field_id) + "] type=" + this.feedObject.getMediaType() + " localId=" + this.feedObject.getLocalId() + " time:" + Integer.valueOf(i) + " url:" + str2 + ' ' + str1;
      }
      str1 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.BaseFinderFeed
 * JD-Core Version:    0.7.0.1
 */