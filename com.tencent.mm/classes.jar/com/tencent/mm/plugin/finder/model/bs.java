package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.i;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.apw;
import com.tencent.mm.protocal.protobuf.apx;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bed;
import com.tencent.mm.protocal.protobuf.blj;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.protocal.protobuf.cvy;
import com.tencent.mm.protocal.protobuf.cwa;
import com.tencent.mm.protocal.protobuf.cwc;
import com.tencent.mm.protocal.protobuf.cwj;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "finderMegaVideo", "Lcom/tencent/mm/protocal/protobuf/FinderMegaVideo;", "(Lcom/tencent/mm/protocal/protobuf/FinderMegaVideo;)V", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "attachFinderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getAttachFinderItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setAttachFinderItem", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "bulletList", "", "Lcom/tencent/mm/protocal/protobuf/MegaVideoBulletCommentInfo;", "getBulletList", "()Ljava/util/List;", "contact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "getContact", "()Lcom/tencent/mm/protocal/protobuf/FinderContact;", "setContact", "(Lcom/tencent/mm/protocal/protobuf/FinderContact;)V", "createTimestamp", "", "getCreateTimestamp", "()J", "setCreateTimestamp", "(J)V", "feedObject", "getFeedObject", "()Lcom/tencent/mm/protocal/protobuf/FinderObject;", "setFeedObject", "getFinderMegaVideo", "()Lcom/tencent/mm/protocal/protobuf/FinderMegaVideo;", "setFinderMegaVideo", "hasAddToHistory", "", "getHasAddToHistory", "()Z", "setHasAddToHistory", "(Z)V", "hasDeleteFromHistory", "getHasDeleteFromHistory", "setHasDeleteFromHistory", "localId", "getLocalId", "setLocalId", "megaVideo", "Lcom/tencent/mm/protocal/protobuf/MegaVideo;", "getMegaVideo", "()Lcom/tencent/mm/protocal/protobuf/MegaVideo;", "setMegaVideo", "(Lcom/tencent/mm/protocal/protobuf/MegaVideo;)V", "value", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "megaVideoMediaList", "getMegaVideoMediaList", "()Ljava/util/LinkedList;", "setMegaVideoMediaList", "(Ljava/util/LinkedList;)V", "timestamps", "getTimestamps", "canShowBullet", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getFinderId", "getFinderNonceId", "", "getItemId", "getItemType", "isLandscapeVideo", "isPrivate", "isSpamForbiddenShare", "isSpamSetPrivate", "mergeBulletList", "", "data", "removeBullet", "", "bulletId", "toFeedItem", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "updateData", "Companion", "plugin-finder_release"})
public final class bs
  implements bu
{
  public static final a zBu;
  public FinderContact contact;
  public FinderObject feedObject;
  public long fhq;
  public long localId;
  private final long timestamps;
  public cvy xcy;
  private bed zBp;
  public boolean zBq;
  public boolean zBr;
  public FinderItem zBs;
  public final List<cwa> zBt;
  
  static
  {
    AppMethodBeat.i(273261);
    zBu = new a((byte)0);
    AppMethodBeat.o(273261);
  }
  
  public bs(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(273260);
    this.fhq = cm.bfE();
    this.timestamps = cm.bfE();
    FinderItem localFinderItem = this.zBs;
    long l;
    if (localFinderItem != null)
    {
      l = localFinderItem.getLocalId();
      this.localId = l;
      this.zBt = ((List)new ArrayList());
      this.feedObject = paramFinderObject;
      paramFinderObject = this.feedObject;
      if (paramFinderObject == null) {
        p.bGy("feedObject");
      }
      this.contact = paramFinderObject.contact;
      paramFinderObject = this.feedObject;
      if (paramFinderObject == null) {
        p.bGy("feedObject");
      }
      paramFinderObject = paramFinderObject.attachmentList;
      if (paramFinderObject == null) {
        break label169;
      }
      paramFinderObject = paramFinderObject.SDm;
      if (paramFinderObject == null) {
        break label169;
      }
      paramFinderObject = (apw)j.lp((List)paramFinderObject);
      if (paramFinderObject == null) {
        break label169;
      }
      paramFinderObject = paramFinderObject.SDl;
      if (paramFinderObject == null) {
        break label169;
      }
    }
    label169:
    for (paramFinderObject = paramFinderObject.SPm;; paramFinderObject = null)
    {
      this.xcy = paramFinderObject;
      AppMethodBeat.o(273260);
      return;
      l = 0L;
      break;
    }
  }
  
  public final int a(k paramk)
  {
    int j = 0;
    AppMethodBeat.i(273252);
    p.k(paramk, "obj");
    if (!(paramk instanceof bs)) {
      paramk = null;
    }
    for (;;)
    {
      paramk = (bs)paramk;
      if (paramk != null)
      {
        if ((paramk.mf() != 0L) && (mf() != 0L) && (paramk.mf() == mf()))
        {
          AppMethodBeat.o(273252);
          return 0;
        }
        paramk = paramk.xcy;
        if (paramk != null) {}
        for (int i = paramk.createTime;; i = 0)
        {
          paramk = this.xcy;
          if (paramk != null) {
            j = paramk.createTime;
          }
          if (i <= j) {
            break;
          }
          AppMethodBeat.o(273252);
          return 1;
        }
      }
      AppMethodBeat.o(273252);
      return -1;
    }
  }
  
  public final int bAQ()
  {
    AppMethodBeat.i(273251);
    int i = bs.class.hashCode();
    AppMethodBeat.o(273251);
    return i;
  }
  
  public final boolean dGR()
  {
    AppMethodBeat.i(273256);
    csg localcsg = (csg)j.lp((List)dKV());
    if (localcsg != null)
    {
      if (localcsg.width > localcsg.height)
      {
        AppMethodBeat.o(273256);
        return true;
      }
      AppMethodBeat.o(273256);
      return false;
    }
    AppMethodBeat.o(273256);
    return false;
  }
  
  public final LinkedList<csg> dKV()
  {
    AppMethodBeat.i(273248);
    Object localObject = this.xcy;
    if (localObject != null)
    {
      localObject = ((cvy)localObject).TEM;
      if (localObject != null)
      {
        localObject = ((cwc)localObject).media;
        if (localObject != null)
        {
          localObject = i.aS((LinkedList)localObject);
          AppMethodBeat.o(273248);
          return localObject;
        }
      }
    }
    localObject = new LinkedList();
    AppMethodBeat.o(273248);
    return localObject;
  }
  
  public final long dKW()
  {
    AppMethodBeat.i(273249);
    if (this.zBp != null)
    {
      localObject = this.xcy;
      if (localObject != null)
      {
        localObject = ((cvy)localObject).TEO;
        if (localObject != null)
        {
          l = ((cwj)localObject).xbk;
          AppMethodBeat.o(273249);
          return l;
        }
      }
      AppMethodBeat.o(273249);
      return 0L;
    }
    Object localObject = this.feedObject;
    if (localObject == null) {
      p.bGy("feedObject");
    }
    long l = ((FinderObject)localObject).id;
    AppMethodBeat.o(273249);
    return l;
  }
  
  public final String dKX()
  {
    AppMethodBeat.i(273250);
    Object localObject2;
    if (this.zBp != null)
    {
      localObject1 = this.xcy;
      if (localObject1 != null)
      {
        localObject1 = ((cvy)localObject1).TEO;
        if (localObject1 != null)
        {
          localObject2 = ((cwj)localObject1).objectNonceId;
          localObject1 = localObject2;
          if (localObject2 != null) {
            break label46;
          }
        }
      }
      localObject1 = "";
      label46:
      localObject2 = localObject1;
      if (localObject1 != null) {}
    }
    else
    {
      localObject1 = this.feedObject;
      if (localObject1 == null) {
        p.bGy("feedObject");
      }
      localObject2 = ((FinderObject)localObject1).objectNonceId;
    }
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    AppMethodBeat.o(273250);
    return localObject1;
  }
  
  public final boolean dKY()
  {
    boolean bool = false;
    cvy localcvy = this.xcy;
    if (localcvy != null) {}
    for (int i = localcvy.TEN;; i = 0)
    {
      if (i != 0) {
        bool = true;
      }
      return bool;
    }
  }
  
  public final boolean dKZ()
  {
    boolean bool = false;
    cvy localcvy = this.xcy;
    if (localcvy != null) {}
    for (int i = localcvy.TEN;; i = 0)
    {
      if (i != 0) {
        bool = true;
      }
      return bool;
    }
  }
  
  public final FeedData dtn()
  {
    long l2 = 0L;
    int j = 0;
    AppMethodBeat.i(273258);
    FeedData localFeedData = new FeedData();
    Object localObject = this.xcy;
    long l1;
    if (localObject != null)
    {
      l1 = ((cvy)localObject).id;
      localFeedData.setFeedId(l1);
      localObject = this.contact;
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
      localObject = this.xcy;
      if (localObject != null)
      {
        str = ((cvy)localObject).sessionBuffer;
        localObject = str;
        if (str != null) {}
      }
      else
      {
        localObject = "";
      }
      localFeedData.setSessionBuffer((String)localObject);
      localObject = this.contact;
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
      localObject = this.xcy;
      if (localObject != null)
      {
        localObject = ((cvy)localObject).TEM;
        if (localObject != null)
        {
          str = ((cwc)localObject).description;
          localObject = str;
          if (str != null) {
            break label204;
          }
        }
      }
      localObject = "";
      label204:
      localFeedData.setDescription((String)localObject);
      localFeedData.setTimestamps(this.timestamps);
      localObject = this.xcy;
      if (localObject == null) {
        break label470;
      }
      i = ((cvy)localObject).urlValidDuration;
      label237:
      localFeedData.setUrlValidDuration(i);
      localFeedData.setMediaList(dKV());
      localFeedData.setMediaType(4);
      localFeedData.setLongVideo(true);
      localObject = this.feedObject;
      if (localObject == null) {
        p.bGy("feedObject");
      }
      localFeedData.setLikeCount(((FinderObject)localObject).likeCount);
      localObject = this.feedObject;
      if (localObject == null) {
        p.bGy("feedObject");
      }
      localFeedData.setCommentCount(((FinderObject)localObject).commentCount);
      localObject = this.feedObject;
      if (localObject == null) {
        p.bGy("feedObject");
      }
      localObject = ((FinderObject)localObject).liveInfo;
      l1 = l2;
      if (localObject != null) {
        l1 = ((bac)localObject).liveId;
      }
      localFeedData.setLiveId(l1);
      localObject = this.feedObject;
      if (localObject == null) {
        p.bGy("feedObject");
      }
      localObject = ((FinderObject)localObject).contact;
      if (localObject == null) {
        break label475;
      }
      localObject = Integer.valueOf(((FinderContact)localObject).liveStatus);
      label397:
      if (localObject == null) {
        break label522;
      }
    }
    label522:
    for (int i = ((Integer)localObject).intValue();; i = 0)
    {
      localFeedData.setLiveStatus(i);
      localObject = this.feedObject;
      if (localObject == null) {
        p.bGy("feedObject");
      }
      localObject = ((FinderObject)localObject).liveInfo;
      i = j;
      if (localObject != null) {
        i = ((bac)localObject).yYz;
      }
      localFeedData.setOnlineNum(i);
      AppMethodBeat.o(273258);
      return localFeedData;
      l1 = 0L;
      break;
      label470:
      i = 0;
      break label237;
      label475:
      localObject = this.feedObject;
      if (localObject == null) {
        p.bGy("feedObject");
      }
      localObject = ((FinderObject)localObject).liveInfo;
      if (localObject != null)
      {
        localObject = Integer.valueOf(((bac)localObject).liveStatus);
        break label397;
      }
      localObject = null;
      break label397;
    }
  }
  
  public final FinderObject getFeedObject()
  {
    AppMethodBeat.i(273246);
    FinderObject localFinderObject = this.feedObject;
    if (localFinderObject == null) {
      p.bGy("feedObject");
    }
    AppMethodBeat.o(273246);
    return localFinderObject;
  }
  
  public final boolean isPrivate()
  {
    AppMethodBeat.i(273255);
    FinderObject localFinderObject = this.feedObject;
    if (localFinderObject == null) {
      p.bGy("feedObject");
    }
    if ((localFinderObject.privateFlag == 1) || (dKZ()))
    {
      AppMethodBeat.o(273255);
      return true;
    }
    AppMethodBeat.o(273255);
    return false;
  }
  
  public final void k(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(273254);
    p.k(paramFinderObject, "data");
    this.feedObject = paramFinderObject;
    paramFinderObject = this.feedObject;
    if (paramFinderObject == null) {
      p.bGy("feedObject");
    }
    paramFinderObject = paramFinderObject.attachmentList;
    if (paramFinderObject != null)
    {
      paramFinderObject = paramFinderObject.SDm;
      if (paramFinderObject != null)
      {
        paramFinderObject = (apw)j.lp((List)paramFinderObject);
        if (paramFinderObject != null)
        {
          paramFinderObject = paramFinderObject.SDl;
          if (paramFinderObject == null) {}
        }
      }
    }
    for (paramFinderObject = paramFinderObject.SPm;; paramFinderObject = null)
    {
      this.xcy = paramFinderObject;
      paramFinderObject = this.feedObject;
      if (paramFinderObject == null) {
        p.bGy("feedObject");
      }
      this.contact = paramFinderObject.contact;
      this.fhq = cm.bfE();
      AppMethodBeat.o(273254);
      return;
    }
  }
  
  public final long mf()
  {
    cvy localcvy = this.xcy;
    if (localcvy != null) {
      return localcvy.id;
    }
    return 0L;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.bs
 * JD-Core Version:    0.7.0.1
 */