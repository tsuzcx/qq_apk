package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.logic.b;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.protocal.protobuf.cnl;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/FeedData;", "", "()V", "commentCount", "", "getCommentCount", "()I", "setCommentCount", "(I)V", "description", "", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "feedId", "", "getFeedId", "()J", "setFeedId", "(J)V", "hasBgmInfo", "", "getHasBgmInfo", "()Z", "setHasBgmInfo", "(Z)V", "isLongVideo", "setLongVideo", "likeCount", "getLikeCount", "setLikeCount", "liveId", "getLiveId", "setLiveId", "liveStatus", "getLiveStatus", "setLiveStatus", "localId", "getLocalId", "setLocalId", "mediaList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "getMediaList", "()Ljava/util/LinkedList;", "setMediaList", "(Ljava/util/LinkedList;)V", "mediaType", "getMediaType", "setMediaType", "nickName", "getNickName", "setNickName", "onlineNum", "getOnlineNum", "setOnlineNum", "rvFeedList", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getRvFeedList", "setRvFeedList", "sessionBuffer", "getSessionBuffer", "setSessionBuffer", "timestamps", "getTimestamps", "setTimestamps", "urlValidDuration", "getUrlValidDuration", "setUrlValidDuration", "userName", "getUserName", "setUserName", "getExpectId", "getId", "printSimpleId", "Companion", "plugin-finder_release"})
public final class FeedData
{
  public static final a Companion;
  private int commentCount;
  private String description;
  private long feedId;
  private boolean hasBgmInfo;
  private boolean isLongVideo;
  private int likeCount;
  private long liveId;
  private int liveStatus;
  private long localId;
  private LinkedList<cjl> mediaList;
  private int mediaType;
  private String nickName;
  private int onlineNum;
  private LinkedList<BaseFinderFeed> rvFeedList;
  private String sessionBuffer;
  private long timestamps;
  private int urlValidDuration;
  private String userName;
  
  static
  {
    AppMethodBeat.i(251512);
    Companion = new a((byte)0);
    AppMethodBeat.o(251512);
  }
  
  public FeedData()
  {
    AppMethodBeat.i(251511);
    this.userName = "";
    this.sessionBuffer = "";
    this.nickName = "";
    this.description = "";
    this.mediaList = new LinkedList();
    this.rvFeedList = new LinkedList();
    AppMethodBeat.o(251511);
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
  
  public final LinkedList<cjl> getMediaList()
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
    AppMethodBeat.i(251510);
    Object localObject = String.valueOf(getId());
    int i = Math.min(((String)localObject).length(), 8);
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(251510);
      throw ((Throwable)localObject);
    }
    localObject = ((String)localObject).substring(0, i);
    p.g(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    AppMethodBeat.o(251510);
    return localObject;
  }
  
  public final void setCommentCount(int paramInt)
  {
    this.commentCount = paramInt;
  }
  
  public final void setDescription(String paramString)
  {
    AppMethodBeat.i(251507);
    p.h(paramString, "<set-?>");
    this.description = paramString;
    AppMethodBeat.o(251507);
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
  
  public final void setMediaList(LinkedList<cjl> paramLinkedList)
  {
    AppMethodBeat.i(251508);
    p.h(paramLinkedList, "<set-?>");
    this.mediaList = paramLinkedList;
    AppMethodBeat.o(251508);
  }
  
  public final void setMediaType(int paramInt)
  {
    this.mediaType = paramInt;
  }
  
  public final void setNickName(String paramString)
  {
    AppMethodBeat.i(251506);
    p.h(paramString, "<set-?>");
    this.nickName = paramString;
    AppMethodBeat.o(251506);
  }
  
  public final void setOnlineNum(int paramInt)
  {
    this.onlineNum = paramInt;
  }
  
  public final void setRvFeedList(LinkedList<BaseFinderFeed> paramLinkedList)
  {
    AppMethodBeat.i(251509);
    p.h(paramLinkedList, "<set-?>");
    this.rvFeedList = paramLinkedList;
    AppMethodBeat.o(251509);
  }
  
  public final void setSessionBuffer(String paramString)
  {
    AppMethodBeat.i(251505);
    p.h(paramString, "<set-?>");
    this.sessionBuffer = paramString;
    AppMethodBeat.o(251505);
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
    AppMethodBeat.i(251504);
    p.h(paramString, "<set-?>");
    this.userName = paramString;
    AppMethodBeat.o(251504);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/FeedData$Companion;", "", "()V", "create", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "feed", "Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;", "baseFinderFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "megaVideoFeed", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "plugin-finder_release"})
  public static final class a
  {
    public static FeedData a(bm parambm)
    {
      long l2 = 0L;
      int j = 0;
      AppMethodBeat.i(251503);
      p.h(parambm, "megaVideoFeed");
      FeedData localFeedData = new FeedData();
      Object localObject = parambm.tuP;
      long l1;
      if (localObject != null)
      {
        l1 = ((cng)localObject).id;
        localFeedData.setFeedId(l1);
        localObject = parambm.contact;
        String str;
        if (localObject != null)
        {
          str = ((FinderContact)localObject).username;
          localObject = str;
          if (str != null) {}
        }
        else
        {
          localObject = "";
        }
        localFeedData.setUserName((String)localObject);
        localObject = parambm.tuP;
        if (localObject != null)
        {
          str = ((cng)localObject).sessionBuffer;
          localObject = str;
          if (str != null) {}
        }
        else
        {
          localObject = "";
        }
        localFeedData.setSessionBuffer((String)localObject);
        localObject = parambm.contact;
        if (localObject != null)
        {
          str = ((FinderContact)localObject).nickname;
          localObject = str;
          if (str != null) {}
        }
        else
        {
          localObject = "";
        }
        localFeedData.setNickName((String)localObject);
        localObject = parambm.tuP;
        if (localObject != null)
        {
          localObject = ((cng)localObject).MtG;
          if (localObject != null)
          {
            str = ((cnl)localObject).description;
            localObject = str;
            if (str != null) {
              break label205;
            }
          }
        }
        localObject = "";
        label205:
        localFeedData.setDescription((String)localObject);
        localFeedData.setTimestamps(parambm.timestamps);
        localObject = parambm.tuP;
        if (localObject == null) {
          break label397;
        }
        i = ((cng)localObject).urlValidDuration;
        label238:
        localFeedData.setUrlValidDuration(i);
        localFeedData.setMediaList(parambm.dkV());
        localFeedData.setMediaType(4);
        localFeedData.setLongVideo(true);
        localFeedData.setLikeCount(parambm.getFeedObject().likeCount);
        localFeedData.setCommentCount(parambm.getFeedObject().commentCount);
        localObject = parambm.getFeedObject().liveInfo;
        l1 = l2;
        if (localObject != null) {
          l1 = ((awe)localObject).liveId;
        }
        localFeedData.setLiveId(l1);
        localObject = parambm.getFeedObject().contact;
        if (localObject == null) {
          break label402;
        }
        localObject = Integer.valueOf(((FinderContact)localObject).liveStatus);
        label342:
        if (localObject == null) {
          break label435;
        }
      }
      label397:
      label402:
      label435:
      for (int i = ((Integer)localObject).intValue();; i = 0)
      {
        localFeedData.setLiveStatus(i);
        parambm = parambm.getFeedObject().liveInfo;
        i = j;
        if (parambm != null) {
          i = parambm.uBn;
        }
        localFeedData.setOnlineNum(i);
        AppMethodBeat.o(251503);
        return localFeedData;
        l1 = 0L;
        break;
        i = 0;
        break label238;
        localObject = parambm.getFeedObject().liveInfo;
        if (localObject != null)
        {
          localObject = Integer.valueOf(((awe)localObject).liveStatus);
          break label342;
        }
        localObject = null;
        break label342;
      }
    }
    
    public static FeedData i(FinderItem paramFinderItem)
    {
      int j = 0;
      AppMethodBeat.i(251502);
      p.h(paramFinderItem, "finderItem");
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
      localObject1 = b.tUw;
      localFeedData.setMediaList(b.b(paramFinderItem));
      localFeedData.setMediaType(paramFinderItem.getMediaType());
      localObject1 = paramFinderItem.getFeedObject().objectDesc;
      boolean bool;
      label168:
      label216:
      long l;
      label228:
      int i;
      if (localObject1 != null)
      {
        localObject1 = ((FinderObjectDesc)localObject1).feedBgmInfo;
        if (localObject1 == null) {
          break label360;
        }
        bool = true;
        localFeedData.setHasBgmInfo(bool);
        localFeedData.setLikeCount(paramFinderItem.getLikeCount());
        localFeedData.setCommentCount(paramFinderItem.getCommentCount());
        localObject1 = paramFinderItem.getFeedObject().liveInfo;
        if (localObject1 == null) {
          break label365;
        }
        localObject1 = Long.valueOf(((awe)localObject1).liveId);
        if (localObject1 == null) {
          break label395;
        }
        l = ((Long)localObject1).longValue();
        localFeedData.setLiveId(l);
        localObject1 = paramFinderItem.getFeedObject().contact;
        if (localObject1 == null) {
          break label401;
        }
        localObject1 = Integer.valueOf(((FinderContact)localObject1).liveStatus);
        label259:
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject1 = paramFinderItem.getLiveInfo();
          if (localObject1 == null) {
            break label434;
          }
          localObject2 = Integer.valueOf(((awe)localObject1).liveStatus);
        }
        label289:
        if (localObject2 == null) {
          break label440;
        }
        i = ((Integer)localObject2).intValue();
        label300:
        localFeedData.setLiveStatus(i);
        localObject1 = paramFinderItem.getFeedObject().liveInfo;
        if (localObject1 == null) {
          break label445;
        }
        paramFinderItem = Integer.valueOf(((awe)localObject1).uBn);
      }
      for (;;)
      {
        i = j;
        if (paramFinderItem != null) {
          i = paramFinderItem.intValue();
        }
        localFeedData.setOnlineNum(i);
        AppMethodBeat.o(251502);
        return localFeedData;
        localObject1 = null;
        break;
        label360:
        bool = false;
        break label168;
        label365:
        localObject1 = paramFinderItem.getLiveInfo();
        if (localObject1 != null)
        {
          localObject1 = Long.valueOf(((awe)localObject1).liveId);
          break label216;
        }
        localObject1 = null;
        break label216;
        label395:
        l = 0L;
        break label228;
        label401:
        localObject1 = paramFinderItem.getFeedObject().liveInfo;
        if (localObject1 != null)
        {
          localObject1 = Integer.valueOf(((awe)localObject1).liveStatus);
          break label259;
        }
        localObject1 = null;
        break label259;
        label434:
        localObject2 = null;
        break label289;
        label440:
        i = 0;
        break label300;
        label445:
        paramFinderItem = paramFinderItem.getLiveInfo();
        if (paramFinderItem != null) {
          paramFinderItem = Integer.valueOf(paramFinderItem.uBn);
        } else {
          paramFinderItem = null;
        }
      }
    }
    
    public static FeedData s(BaseFinderFeed paramBaseFinderFeed)
    {
      AppMethodBeat.i(251501);
      p.h(paramBaseFinderFeed, "baseFinderFeed");
      paramBaseFinderFeed = i(paramBaseFinderFeed.feedObject);
      AppMethodBeat.o(251501);
      return paramBaseFinderFeed;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.FeedData
 * JD-Core Version:    0.7.0.1
 */