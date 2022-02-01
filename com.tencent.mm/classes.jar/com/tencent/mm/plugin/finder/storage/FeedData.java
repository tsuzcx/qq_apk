package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.logic.b;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.csg;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/FeedData;", "", "()V", "anchorStatus", "", "getAnchorStatus", "()I", "setAnchorStatus", "(I)V", "commentCount", "getCommentCount", "setCommentCount", "description", "", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "feedId", "", "getFeedId", "()J", "setFeedId", "(J)V", "hasBgmInfo", "", "getHasBgmInfo", "()Z", "setHasBgmInfo", "(Z)V", "isLongVideo", "setLongVideo", "likeCount", "getLikeCount", "setLikeCount", "liveId", "getLiveId", "setLiveId", "liveStatus", "getLiveStatus", "setLiveStatus", "localId", "getLocalId", "setLocalId", "mediaList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "getMediaList", "()Ljava/util/LinkedList;", "setMediaList", "(Ljava/util/LinkedList;)V", "mediaType", "getMediaType", "setMediaType", "nickName", "getNickName", "setNickName", "nickname", "getNickname", "setNickname", "nonceId", "getNonceId", "setNonceId", "onlineNum", "getOnlineNum", "setOnlineNum", "rvFeedList", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getRvFeedList", "setRvFeedList", "sessionBuffer", "getSessionBuffer", "setSessionBuffer", "timestamps", "getTimestamps", "setTimestamps", "urlValidDuration", "getUrlValidDuration", "setUrlValidDuration", "userName", "getUserName", "setUserName", "getExpectId", "getId", "printSimpleId", "Companion", "plugin-finder-base_release"})
public final class FeedData
{
  public static final a Companion;
  private int anchorStatus;
  private int commentCount;
  private String description;
  private long feedId;
  private boolean hasBgmInfo;
  private boolean isLongVideo;
  private int likeCount;
  private long liveId;
  private int liveStatus;
  private long localId;
  private LinkedList<csg> mediaList;
  private int mediaType;
  private String nickName;
  private String nickname;
  private String nonceId;
  private int onlineNum;
  private LinkedList<BaseFinderFeed> rvFeedList;
  private String sessionBuffer;
  private long timestamps;
  private int urlValidDuration;
  private String userName;
  
  static
  {
    AppMethodBeat.i(262561);
    Companion = new a((byte)0);
    AppMethodBeat.o(262561);
  }
  
  public FeedData()
  {
    AppMethodBeat.i(262560);
    this.userName = "";
    this.sessionBuffer = "";
    this.nickName = "";
    this.description = "";
    this.mediaList = new LinkedList();
    this.rvFeedList = new LinkedList();
    this.nonceId = "";
    this.nickname = "";
    AppMethodBeat.o(262560);
  }
  
  public final int getAnchorStatus()
  {
    return this.anchorStatus;
  }
  
  public final int getCommentCount()
  {
    return this.commentCount;
  }
  
  public final String getDescription()
  {
    return this.description;
  }
  
  public final long getExpectId()
  {
    if (this.feedId == 0L) {
      return this.localId;
    }
    return this.feedId;
  }
  
  public final long getFeedId()
  {
    return this.feedId;
  }
  
  public final boolean getHasBgmInfo()
  {
    return this.hasBgmInfo;
  }
  
  public final long getId()
  {
    return this.feedId;
  }
  
  public final int getLikeCount()
  {
    return this.likeCount;
  }
  
  public final long getLiveId()
  {
    return this.liveId;
  }
  
  public final int getLiveStatus()
  {
    return this.liveStatus;
  }
  
  public final long getLocalId()
  {
    return this.localId;
  }
  
  public final LinkedList<csg> getMediaList()
  {
    return this.mediaList;
  }
  
  public final int getMediaType()
  {
    return this.mediaType;
  }
  
  public final String getNickName()
  {
    return this.nickName;
  }
  
  public final String getNickname()
  {
    return this.nickname;
  }
  
  public final String getNonceId()
  {
    return this.nonceId;
  }
  
  public final int getOnlineNum()
  {
    return this.onlineNum;
  }
  
  public final LinkedList<BaseFinderFeed> getRvFeedList()
  {
    return this.rvFeedList;
  }
  
  public final String getSessionBuffer()
  {
    return this.sessionBuffer;
  }
  
  public final long getTimestamps()
  {
    return this.timestamps;
  }
  
  public final int getUrlValidDuration()
  {
    return this.urlValidDuration;
  }
  
  public final String getUserName()
  {
    return this.userName;
  }
  
  public final boolean isLongVideo()
  {
    return this.isLongVideo;
  }
  
  public final String printSimpleId()
  {
    AppMethodBeat.i(262557);
    Object localObject = String.valueOf(getId());
    int i = Math.min(((String)localObject).length(), 8);
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(262557);
      throw ((Throwable)localObject);
    }
    localObject = ((String)localObject).substring(0, i);
    p.j(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    AppMethodBeat.o(262557);
    return localObject;
  }
  
  public final void setAnchorStatus(int paramInt)
  {
    this.anchorStatus = paramInt;
  }
  
  public final void setCommentCount(int paramInt)
  {
    this.commentCount = paramInt;
  }
  
  public final void setDescription(String paramString)
  {
    AppMethodBeat.i(262509);
    p.k(paramString, "<set-?>");
    this.description = paramString;
    AppMethodBeat.o(262509);
  }
  
  public final void setFeedId(long paramLong)
  {
    this.feedId = paramLong;
  }
  
  public final void setHasBgmInfo(boolean paramBoolean)
  {
    this.hasBgmInfo = paramBoolean;
  }
  
  public final void setLikeCount(int paramInt)
  {
    this.likeCount = paramInt;
  }
  
  public final void setLiveId(long paramLong)
  {
    this.liveId = paramLong;
  }
  
  public final void setLiveStatus(int paramInt)
  {
    this.liveStatus = paramInt;
  }
  
  public final void setLocalId(long paramLong)
  {
    this.localId = paramLong;
  }
  
  public final void setLongVideo(boolean paramBoolean)
  {
    this.isLongVideo = paramBoolean;
  }
  
  public final void setMediaList(LinkedList<csg> paramLinkedList)
  {
    AppMethodBeat.i(262518);
    p.k(paramLinkedList, "<set-?>");
    this.mediaList = paramLinkedList;
    AppMethodBeat.o(262518);
  }
  
  public final void setMediaType(int paramInt)
  {
    this.mediaType = paramInt;
  }
  
  public final void setNickName(String paramString)
  {
    AppMethodBeat.i(262505);
    p.k(paramString, "<set-?>");
    this.nickName = paramString;
    AppMethodBeat.o(262505);
  }
  
  public final void setNickname(String paramString)
  {
    AppMethodBeat.i(262540);
    p.k(paramString, "<set-?>");
    this.nickname = paramString;
    AppMethodBeat.o(262540);
  }
  
  public final void setNonceId(String paramString)
  {
    AppMethodBeat.i(262537);
    p.k(paramString, "<set-?>");
    this.nonceId = paramString;
    AppMethodBeat.o(262537);
  }
  
  public final void setOnlineNum(int paramInt)
  {
    this.onlineNum = paramInt;
  }
  
  public final void setRvFeedList(LinkedList<BaseFinderFeed> paramLinkedList)
  {
    AppMethodBeat.i(262528);
    p.k(paramLinkedList, "<set-?>");
    this.rvFeedList = paramLinkedList;
    AppMethodBeat.o(262528);
  }
  
  public final void setSessionBuffer(String paramString)
  {
    AppMethodBeat.i(262499);
    p.k(paramString, "<set-?>");
    this.sessionBuffer = paramString;
    AppMethodBeat.o(262499);
  }
  
  public final void setTimestamps(long paramLong)
  {
    this.timestamps = paramLong;
  }
  
  public final void setUrlValidDuration(int paramInt)
  {
    this.urlValidDuration = paramInt;
  }
  
  public final void setUserName(String paramString)
  {
    AppMethodBeat.i(262492);
    p.k(paramString, "<set-?>");
    this.userName = paramString;
    AppMethodBeat.o(262492);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/FeedData$Companion;", "", "()V", "clone", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "feedData", "create", "baseFinderFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "plugin-finder-base_release"})
  public static final class a
  {
    public static FeedData j(FinderItem paramFinderItem)
    {
      int j = 0;
      AppMethodBeat.i(258076);
      p.k(paramFinderItem, "finderItem");
      FeedData localFeedData = new FeedData();
      localFeedData.setFeedId(paramFinderItem.getId());
      localFeedData.setUserName(paramFinderItem.getUserName());
      Object localObject2 = paramFinderItem.getFeedObject().sessionBuffer;
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localFeedData.setSessionBuffer((String)localObject1);
      localFeedData.setLocalId(paramFinderItem.getLocalId());
      localFeedData.setNickName(paramFinderItem.getNickName());
      localFeedData.setDescription(paramFinderItem.getDescription());
      localFeedData.setTimestamps(paramFinderItem.getTimestamps());
      localFeedData.setUrlValidDuration(paramFinderItem.getFeedObject().urlValidDuration);
      localObject1 = b.xFr;
      localFeedData.setMediaList(b.c(paramFinderItem));
      localFeedData.setMediaType(paramFinderItem.getMediaType());
      localObject1 = paramFinderItem.getFeedObject().objectDesc;
      boolean bool;
      label168:
      label216:
      long l;
      if (localObject1 != null)
      {
        localObject1 = ((FinderObjectDesc)localObject1).feedBgmInfo;
        if (localObject1 == null) {
          break label434;
        }
        bool = true;
        localFeedData.setHasBgmInfo(bool);
        localFeedData.setLikeCount(paramFinderItem.getLikeCount());
        localFeedData.setCommentCount(paramFinderItem.getCommentCount());
        localObject1 = paramFinderItem.getFeedObject().liveInfo;
        if (localObject1 == null) {
          break label439;
        }
        localObject1 = Long.valueOf(((bac)localObject1).liveId);
        if (localObject1 == null) {
          break label469;
        }
        l = ((Long)localObject1).longValue();
        label228:
        localFeedData.setLiveId(l);
        localObject1 = paramFinderItem.getFeedObject().contact;
        if (localObject1 == null) {
          break label475;
        }
        localObject1 = Integer.valueOf(((FinderContact)localObject1).liveStatus);
        label259:
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject1 = paramFinderItem.getLiveInfo();
          if (localObject1 == null) {
            break label508;
          }
          localObject2 = Integer.valueOf(((bac)localObject1).liveStatus);
        }
        label289:
        if (localObject2 == null) {
          break label514;
        }
        i = ((Integer)localObject2).intValue();
        label300:
        localFeedData.setLiveStatus(i);
        localObject1 = paramFinderItem.getFeedObject().liveInfo;
        if (localObject1 == null) {
          break label519;
        }
        localObject1 = Integer.valueOf(((bac)localObject1).yYz);
        label330:
        if (localObject1 == null) {
          break label549;
        }
      }
      label514:
      label519:
      label549:
      for (int i = ((Integer)localObject1).intValue();; i = 0)
      {
        localFeedData.setOnlineNum(i);
        localObject1 = paramFinderItem.getFeedObject();
        if (localObject1 != null)
        {
          localObject2 = ((FinderObject)localObject1).objectNonceId;
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = "";
        }
        localFeedData.setNonceId((String)localObject1);
        localFeedData.setNickname(paramFinderItem.getNickName());
        paramFinderItem = paramFinderItem.getFeedObject().liveInfo;
        i = j;
        if (paramFinderItem != null) {
          i = (int)paramFinderItem.SEj;
        }
        localFeedData.setAnchorStatus(i);
        AppMethodBeat.o(258076);
        return localFeedData;
        localObject1 = null;
        break;
        label434:
        bool = false;
        break label168;
        label439:
        localObject1 = paramFinderItem.getLiveInfo();
        if (localObject1 != null)
        {
          localObject1 = Long.valueOf(((bac)localObject1).liveId);
          break label216;
        }
        localObject1 = null;
        break label216;
        label469:
        l = 0L;
        break label228;
        label475:
        localObject1 = paramFinderItem.getFeedObject().liveInfo;
        if (localObject1 != null)
        {
          localObject1 = Integer.valueOf(((bac)localObject1).liveStatus);
          break label259;
        }
        localObject1 = null;
        break label259;
        label508:
        localObject2 = null;
        break label289;
        i = 0;
        break label300;
        localObject1 = paramFinderItem.getLiveInfo();
        if (localObject1 != null)
        {
          localObject1 = Integer.valueOf(((bac)localObject1).yYz);
          break label330;
        }
        localObject1 = null;
        break label330;
      }
    }
    
    public static FeedData t(BaseFinderFeed paramBaseFinderFeed)
    {
      AppMethodBeat.i(258075);
      p.k(paramBaseFinderFeed, "baseFinderFeed");
      paramBaseFinderFeed = j(paramBaseFinderFeed.feedObject);
      AppMethodBeat.o(258075);
      return paramBaseFinderFeed;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.FeedData
 * JD-Core Version:    0.7.0.1
 */