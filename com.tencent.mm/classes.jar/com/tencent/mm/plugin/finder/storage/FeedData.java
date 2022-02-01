package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.logic.b;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.dji;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FeedData;", "", "()V", "anchorStatus", "", "getAnchorStatus", "()I", "setAnchorStatus", "(I)V", "commentCount", "getCommentCount", "setCommentCount", "description", "", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "feedId", "", "getFeedId", "()J", "setFeedId", "(J)V", "hasBgmInfo", "", "getHasBgmInfo", "()Z", "setHasBgmInfo", "(Z)V", "ignoreLongTerm", "getIgnoreLongTerm", "setIgnoreLongTerm", "isLongVideo", "setLongVideo", "likeCount", "getLikeCount", "setLikeCount", "liveId", "getLiveId", "setLiveId", "liveInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveInfo;", "getLiveInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveInfo;", "setLiveInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveInfo;)V", "liveStatus", "getLiveStatus", "setLiveStatus", "localId", "getLocalId", "setLocalId", "mediaList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "getMediaList", "()Ljava/util/LinkedList;", "setMediaList", "(Ljava/util/LinkedList;)V", "mediaType", "getMediaType", "setMediaType", "nickName", "getNickName", "setNickName", "nickname", "getNickname", "setNickname", "nonceId", "getNonceId", "setNonceId", "onlineNum", "getOnlineNum", "setOnlineNum", "position", "getPosition", "setPosition", "rvFeedList", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getRvFeedList", "setRvFeedList", "sessionBuffer", "getSessionBuffer", "setSessionBuffer", "timestamps", "getTimestamps", "setTimestamps", "urlValidDuration", "getUrlValidDuration", "setUrlValidDuration", "userName", "getUserName", "setUserName", "vrLive", "getVrLive", "setVrLive", "getExpectId", "getId", "printSimpleId", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FeedData
{
  public static final a Companion;
  private int anchorStatus;
  private int commentCount;
  private String description;
  private long feedId;
  private boolean hasBgmInfo;
  private boolean ignoreLongTerm;
  private boolean isLongVideo;
  private int likeCount;
  private long liveId;
  private bip liveInfo;
  private int liveStatus;
  private long localId;
  private LinkedList<dji> mediaList;
  private int mediaType;
  private String nickName;
  private String nickname;
  private String nonceId;
  private int onlineNum;
  private int position;
  private LinkedList<BaseFinderFeed> rvFeedList;
  private String sessionBuffer;
  private long timestamps;
  private int urlValidDuration;
  private String userName;
  private int vrLive;
  
  static
  {
    AppMethodBeat.i(339143);
    Companion = new a((byte)0);
    AppMethodBeat.o(339143);
  }
  
  public FeedData()
  {
    AppMethodBeat.i(339134);
    this.userName = "";
    this.sessionBuffer = "";
    this.nickName = "";
    this.description = "";
    this.mediaList = new LinkedList();
    this.rvFeedList = new LinkedList();
    this.nonceId = "";
    this.nickname = "";
    AppMethodBeat.o(339134);
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
  
  public final boolean getIgnoreLongTerm()
  {
    return this.ignoreLongTerm;
  }
  
  public final int getLikeCount()
  {
    return this.likeCount;
  }
  
  public final long getLiveId()
  {
    return this.liveId;
  }
  
  public final bip getLiveInfo()
  {
    return this.liveInfo;
  }
  
  public final int getLiveStatus()
  {
    return this.liveStatus;
  }
  
  public final long getLocalId()
  {
    return this.localId;
  }
  
  public final LinkedList<dji> getMediaList()
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
  
  public final int getPosition()
  {
    return this.position;
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
  
  public final int getVrLive()
  {
    return this.vrLive;
  }
  
  public final boolean isLongVideo()
  {
    return this.isLongVideo;
  }
  
  public final String printSimpleId()
  {
    AppMethodBeat.i(339362);
    Object localObject = String.valueOf(getId());
    int i = Math.min(((String)localObject).length(), 8);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(339362);
      throw ((Throwable)localObject);
    }
    localObject = ((String)localObject).substring(0, i);
    s.s(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    AppMethodBeat.o(339362);
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
    AppMethodBeat.i(339201);
    s.u(paramString, "<set-?>");
    this.description = paramString;
    AppMethodBeat.o(339201);
  }
  
  public final void setFeedId(long paramLong)
  {
    this.feedId = paramLong;
  }
  
  public final void setHasBgmInfo(boolean paramBoolean)
  {
    this.hasBgmInfo = paramBoolean;
  }
  
  public final void setIgnoreLongTerm(boolean paramBoolean)
  {
    this.ignoreLongTerm = paramBoolean;
  }
  
  public final void setLikeCount(int paramInt)
  {
    this.likeCount = paramInt;
  }
  
  public final void setLiveId(long paramLong)
  {
    this.liveId = paramLong;
  }
  
  public final void setLiveInfo(bip parambip)
  {
    this.liveInfo = parambip;
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
  
  public final void setMediaList(LinkedList<dji> paramLinkedList)
  {
    AppMethodBeat.i(339224);
    s.u(paramLinkedList, "<set-?>");
    this.mediaList = paramLinkedList;
    AppMethodBeat.o(339224);
  }
  
  public final void setMediaType(int paramInt)
  {
    this.mediaType = paramInt;
  }
  
  public final void setNickName(String paramString)
  {
    AppMethodBeat.i(339193);
    s.u(paramString, "<set-?>");
    this.nickName = paramString;
    AppMethodBeat.o(339193);
  }
  
  public final void setNickname(String paramString)
  {
    AppMethodBeat.i(339292);
    s.u(paramString, "<set-?>");
    this.nickname = paramString;
    AppMethodBeat.o(339292);
  }
  
  public final void setNonceId(String paramString)
  {
    AppMethodBeat.i(339281);
    s.u(paramString, "<set-?>");
    this.nonceId = paramString;
    AppMethodBeat.o(339281);
  }
  
  public final void setOnlineNum(int paramInt)
  {
    this.onlineNum = paramInt;
  }
  
  public final void setPosition(int paramInt)
  {
    this.position = paramInt;
  }
  
  public final void setRvFeedList(LinkedList<BaseFinderFeed> paramLinkedList)
  {
    AppMethodBeat.i(339251);
    s.u(paramLinkedList, "<set-?>");
    this.rvFeedList = paramLinkedList;
    AppMethodBeat.o(339251);
  }
  
  public final void setSessionBuffer(String paramString)
  {
    AppMethodBeat.i(339177);
    s.u(paramString, "<set-?>");
    this.sessionBuffer = paramString;
    AppMethodBeat.o(339177);
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
    AppMethodBeat.i(339172);
    s.u(paramString, "<set-?>");
    this.userName = paramString;
    AppMethodBeat.o(339172);
  }
  
  public final void setVrLive(int paramInt)
  {
    this.vrLive = paramInt;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FeedData$Companion;", "", "()V", "clone", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "feedData", "create", "baseFinderFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static FeedData l(BaseFinderFeed paramBaseFinderFeed)
    {
      AppMethodBeat.i(339383);
      s.u(paramBaseFinderFeed, "baseFinderFeed");
      FeedData localFeedData = n(paramBaseFinderFeed.feedObject);
      localFeedData.setIgnoreLongTerm(paramBaseFinderFeed.ignoreLongTerm);
      AppMethodBeat.o(339383);
      return localFeedData;
    }
    
    public static FeedData n(FinderItem paramFinderItem)
    {
      int j = 0;
      AppMethodBeat.i(339393);
      s.u(paramFinderItem, "finderItem");
      FeedData localFeedData = new FeedData();
      localFeedData.setFeedId(paramFinderItem.getId());
      localFeedData.setUserName(paramFinderItem.getUserName());
      String str = paramFinderItem.getFeedObject().sessionBuffer;
      Object localObject = str;
      if (str == null) {
        localObject = "";
      }
      localFeedData.setSessionBuffer((String)localObject);
      localFeedData.setLocalId(paramFinderItem.getLocalId());
      localFeedData.setNickName(paramFinderItem.getNickName());
      localFeedData.setDescription(paramFinderItem.getDescription());
      localFeedData.setTimestamps(paramFinderItem.getTimestamps());
      localFeedData.setUrlValidDuration(paramFinderItem.getFeedObject().urlValidDuration);
      localObject = b.Beo;
      localFeedData.setMediaList(b.d(paramFinderItem));
      localFeedData.setMediaType(paramFinderItem.getMediaType());
      localObject = paramFinderItem.getFeedObject().objectDesc;
      boolean bool;
      label164:
      label205:
      long l;
      if (localObject == null)
      {
        localObject = null;
        if (localObject == null) {
          break label440;
        }
        bool = true;
        localFeedData.setHasBgmInfo(bool);
        localFeedData.setLikeCount(paramFinderItem.getLikeCount());
        localFeedData.setCommentCount(paramFinderItem.getCommentCount());
        localObject = paramFinderItem.getFeedObject().liveInfo;
        if (localObject != null) {
          break label445;
        }
        localObject = null;
        if (localObject != null) {
          break label468;
        }
        localObject = paramFinderItem.getLiveInfo();
        if (localObject != null) {
          break label458;
        }
        l = 0L;
        label224:
        localFeedData.setLiveId(l);
        localObject = paramFinderItem.getFeedObject().contact;
        if (localObject != null) {
          break label478;
        }
        localObject = null;
        label248:
        if (localObject != null) {
          break label522;
        }
        localObject = paramFinderItem.getFeedObject().liveInfo;
        if (localObject != null) {
          break label491;
        }
        localObject = null;
        label270:
        if (localObject != null) {
          break label513;
        }
        localObject = paramFinderItem.getLiveInfo();
        if (localObject != null) {
          break label504;
        }
        i = 0;
        label288:
        localFeedData.setLiveStatus(i);
        localObject = paramFinderItem.getFeedObject().liveInfo;
        if (localObject != null) {
          break label531;
        }
        localObject = null;
        label311:
        if (localObject != null) {
          break label553;
        }
        localObject = paramFinderItem.getLiveInfo();
        if (localObject != null) {
          break label544;
        }
        i = 0;
        label329:
        localFeedData.setOnlineNum(i);
        localObject = paramFinderItem.getFeedObject();
        if (localObject != null) {
          break label562;
        }
        localObject = "";
        label350:
        localFeedData.setNonceId((String)localObject);
        localFeedData.setNickname(paramFinderItem.getNickName());
        localObject = paramFinderItem.getFeedObject().liveInfo;
        if (localObject != null) {
          break label585;
        }
        i = 0;
        label382:
        localFeedData.setAnchorStatus(i);
        localObject = paramFinderItem.getFeedObject().liveInfo;
        if (localObject != null) {
          break label595;
        }
      }
      label440:
      label445:
      label458:
      label595:
      for (int i = j;; i = ((bip)localObject).ZSl)
      {
        localFeedData.setVrLive(i);
        localFeedData.setLiveInfo(paramFinderItem.getFeedObject().liveInfo);
        AppMethodBeat.o(339393);
        return localFeedData;
        localObject = ((FinderObjectDesc)localObject).feedBgmInfo;
        break;
        bool = false;
        break label164;
        localObject = Long.valueOf(((bip)localObject).liveId);
        break label205;
        l = ((bip)localObject).liveId;
        break label224;
        label468:
        l = ((Long)localObject).longValue();
        break label224;
        label478:
        localObject = Integer.valueOf(((FinderContact)localObject).liveStatus);
        break label248;
        label491:
        localObject = Integer.valueOf(((bip)localObject).liveStatus);
        break label270;
        label504:
        i = ((bip)localObject).liveStatus;
        break label288;
        i = ((Integer)localObject).intValue();
        break label288;
        i = ((Integer)localObject).intValue();
        break label288;
        localObject = Integer.valueOf(((bip)localObject).DSe);
        break label311;
        i = ((bip)localObject).DSe;
        break label329;
        i = ((Integer)localObject).intValue();
        break label329;
        str = ((FinderObject)localObject).objectNonceId;
        localObject = str;
        if (str != null) {
          break label350;
        }
        localObject = "";
        break label350;
        i = (int)((bip)localObject).ZFH;
        break label382;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.FeedData
 * JD-Core Version:    0.7.0.1
 */