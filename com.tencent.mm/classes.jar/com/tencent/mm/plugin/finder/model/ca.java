package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.i;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.atq;
import com.tencent.mm.protocal.protobuf.atr;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bpb;
import com.tencent.mm.protocal.protobuf.byx;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.protocal.protobuf.dne;
import com.tencent.mm.protocal.protobuf.dnh;
import com.tencent.mm.protocal.protobuf.dno;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "finderMegaVideo", "Lcom/tencent/mm/protocal/protobuf/FinderMegaVideo;", "(Lcom/tencent/mm/protocal/protobuf/FinderMegaVideo;)V", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "attachFinderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getAttachFinderItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setAttachFinderItem", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "bulletList", "", "Lcom/tencent/mm/protocal/protobuf/MegaVideoBulletCommentInfo;", "getBulletList", "()Ljava/util/List;", "contact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "getContact", "()Lcom/tencent/mm/protocal/protobuf/FinderContact;", "setContact", "(Lcom/tencent/mm/protocal/protobuf/FinderContact;)V", "createTimestamp", "", "getCreateTimestamp", "()J", "setCreateTimestamp", "(J)V", "feedObject", "getFeedObject", "()Lcom/tencent/mm/protocal/protobuf/FinderObject;", "setFeedObject", "getFinderMegaVideo", "()Lcom/tencent/mm/protocal/protobuf/FinderMegaVideo;", "setFinderMegaVideo", "hasAddToHistory", "", "getHasAddToHistory", "()Z", "setHasAddToHistory", "(Z)V", "hasDeleteFromHistory", "getHasDeleteFromHistory", "setHasDeleteFromHistory", "localId", "getLocalId", "setLocalId", "megaVideo", "Lcom/tencent/mm/protocal/protobuf/MegaVideo;", "getMegaVideo", "()Lcom/tencent/mm/protocal/protobuf/MegaVideo;", "setMegaVideo", "(Lcom/tencent/mm/protocal/protobuf/MegaVideo;)V", "value", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "megaVideoMediaList", "getMegaVideoMediaList", "()Ljava/util/LinkedList;", "setMegaVideoMediaList", "(Ljava/util/LinkedList;)V", "timestamps", "getTimestamps", "canShowBullet", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getFinderId", "getFinderNonceId", "", "getItemId", "getItemType", "isLandscapeVideo", "isPrivate", "isSpamForbiddenShare", "isSpamSetPrivate", "mergeBulletList", "", "data", "removeBullet", "", "bulletId", "toFeedItem", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "updateData", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ca
  implements cc
{
  public static final a EDD;
  public dne ABK;
  public boolean ECR;
  private bpb EDE;
  public boolean EDF;
  public FinderItem EDG;
  private final List<Object> EDH;
  public FinderContact contact;
  public FinderObject feedObject;
  public long hlB;
  public long localId;
  private final long timestamps;
  
  static
  {
    AppMethodBeat.i(332037);
    EDD = new a((byte)0);
    AppMethodBeat.o(332037);
  }
  
  public ca(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(332029);
    this.hlB = cn.bDw();
    this.timestamps = cn.bDw();
    Object localObject2 = this.EDG;
    long l;
    if (localObject2 == null)
    {
      l = 0L;
      this.localId = l;
      this.EDH = ((List)new ArrayList());
      setFeedObject(paramFinderObject);
      this.contact = getFeedObject().contact;
      paramFinderObject = getFeedObject().attachmentList;
      if (paramFinderObject != null) {
        break label115;
      }
      paramFinderObject = localObject1;
    }
    label115:
    do
    {
      this.ABK = paramFinderObject;
      AppMethodBeat.o(332029);
      return;
      l = ((FinderItem)localObject2).getLocalId();
      break;
      localObject2 = paramFinderObject.ZEi;
      paramFinderObject = localObject1;
    } while (localObject2 == null);
    localObject2 = ((Iterable)localObject2).iterator();
    atq localatq;
    do
    {
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
      paramFinderObject = ((Iterator)localObject2).next();
      localatq = (atq)paramFinderObject;
      av localav = av.GiL;
      s.s(localatq, "it");
    } while (!av.a(localatq));
    for (;;)
    {
      localObject2 = (atq)paramFinderObject;
      paramFinderObject = localObject1;
      if (localObject2 == null) {
        break;
      }
      localObject2 = ((atq)localObject2).ZEf;
      paramFinderObject = localObject1;
      if (localObject2 == null) {
        break;
      }
      paramFinderObject = ((byx)localObject2).ZXx;
      break;
      paramFinderObject = null;
    }
  }
  
  private void setFeedObject(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(332011);
    s.u(paramFinderObject, "<set-?>");
    this.feedObject = paramFinderObject;
    AppMethodBeat.o(332011);
  }
  
  public final int a(k paramk)
  {
    int j = 0;
    AppMethodBeat.i(332121);
    s.u(paramk, "obj");
    if ((paramk instanceof ca)) {
      paramk = (ca)paramk;
    }
    while (paramk != null) {
      if ((paramk.bZA() != 0L) && (bZA() != 0L) && (paramk.bZA() == bZA()))
      {
        AppMethodBeat.o(332121);
        return 0;
        paramk = null;
      }
      else
      {
        paramk = paramk.ABK;
        int i;
        if (paramk == null)
        {
          i = 0;
          paramk = this.ABK;
          if (paramk != null) {
            break label111;
          }
        }
        for (;;)
        {
          if (i <= j) {
            break label119;
          }
          AppMethodBeat.o(332121);
          return 1;
          i = paramk.createTime;
          break;
          label111:
          j = paramk.createTime;
        }
      }
    }
    label119:
    AppMethodBeat.o(332121);
    return -1;
  }
  
  public final long bZA()
  {
    dne localdne = this.ABK;
    if (localdne == null) {
      return 0L;
    }
    return localdne.id;
  }
  
  public final int bZB()
  {
    AppMethodBeat.i(332109);
    int i = ca.class.hashCode();
    AppMethodBeat.o(332109);
    return i;
  }
  
  public final LinkedList<dji> eDE()
  {
    Object localObject2 = null;
    AppMethodBeat.i(332053);
    Object localObject1 = this.ABK;
    if (localObject1 == null) {
      localObject1 = localObject2;
    }
    while (localObject1 == null)
    {
      localObject1 = new LinkedList();
      AppMethodBeat.o(332053);
      return localObject1;
      Object localObject3 = ((dne)localObject1).aaUt;
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject3 = ((dnh)localObject3).media;
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = i.aZ((LinkedList)localObject3);
        }
      }
    }
    AppMethodBeat.o(332053);
    return localObject1;
  }
  
  public final long eDF()
  {
    long l = 0L;
    AppMethodBeat.i(332081);
    Object localObject;
    if (this.EDE == null)
    {
      localObject = null;
      if (localObject == null)
      {
        l = getFeedObject().id;
        AppMethodBeat.o(332081);
        return l;
      }
    }
    else
    {
      localObject = this.ABK;
      if (localObject == null) {}
      for (;;)
      {
        localObject = Long.valueOf(l);
        break;
        localObject = ((dne)localObject).aaUv;
        if (localObject != null) {
          l = ((dno)localObject).hKN;
        }
      }
    }
    l = ((Long)localObject).longValue();
    AppMethodBeat.o(332081);
    return l;
  }
  
  public final String eDG()
  {
    AppMethodBeat.i(332096);
    Object localObject;
    if (this.EDE == null) {
      localObject = null;
    }
    while (localObject == null)
    {
      localObject = getFeedObject().objectNonceId;
      if (localObject == null)
      {
        AppMethodBeat.o(332096);
        return "";
        localObject = this.ABK;
        if (localObject == null)
        {
          localObject = "";
        }
        else
        {
          localObject = ((dne)localObject).aaUv;
          if (localObject == null)
          {
            localObject = "";
          }
          else
          {
            String str = ((dno)localObject).objectNonceId;
            localObject = str;
            if (str == null) {
              localObject = "";
            }
          }
        }
      }
      else
      {
        AppMethodBeat.o(332096);
        return localObject;
      }
    }
    AppMethodBeat.o(332096);
    return localObject;
  }
  
  public final boolean eDH()
  {
    boolean bool = false;
    dne localdne = this.ABK;
    if (localdne == null) {}
    for (int i = 0;; i = localdne.aaUu)
    {
      if (i != 0) {
        bool = true;
      }
      return bool;
    }
  }
  
  public final boolean eDI()
  {
    boolean bool = false;
    dne localdne = this.ABK;
    if (localdne == null) {}
    for (int i = 0;; i = localdne.aaUu)
    {
      if (i != 0) {
        bool = true;
      }
      return bool;
    }
  }
  
  public final FeedData ecz()
  {
    long l2 = 0L;
    int j = 0;
    AppMethodBeat.i(332198);
    FeedData localFeedData = new FeedData();
    Object localObject = this.ABK;
    long l1;
    if (localObject == null)
    {
      l1 = 0L;
      localFeedData.setFeedId(l1);
      localObject = this.contact;
      if (localObject != null) {
        break label311;
      }
      localObject = "";
      label55:
      localFeedData.setUserName((String)localObject);
      localObject = this.ABK;
      if (localObject != null) {
        break label335;
      }
      localObject = "";
      label78:
      localFeedData.setSessionBuffer((String)localObject);
      localObject = this.contact;
      if (localObject != null) {
        break label359;
      }
      localObject = "";
      label101:
      localFeedData.setNickName((String)localObject);
      localObject = this.ABK;
      if (localObject != null) {
        break label383;
      }
      localObject = "";
      label124:
      localFeedData.setDescription((String)localObject);
      localFeedData.setTimestamps(this.timestamps);
      localObject = this.ABK;
      if (localObject != null) {
        break label427;
      }
      i = 0;
      label153:
      localFeedData.setUrlValidDuration(i);
      localFeedData.setMediaList(eDE());
      localFeedData.setMediaType(4);
      localFeedData.setLongVideo(true);
      localFeedData.setLikeCount(getFeedObject().likeCount);
      localFeedData.setCommentCount(getFeedObject().commentCount);
      localObject = getFeedObject().liveInfo;
      if (localObject != null) {
        break label436;
      }
      l1 = l2;
      label221:
      localFeedData.setLiveId(l1);
      localObject = getFeedObject().contact;
      if (localObject != null) {
        break label445;
      }
      localObject = null;
      label244:
      if (localObject != null) {
        break label467;
      }
      localObject = getFeedObject().liveInfo;
      if (localObject != null) {
        break label458;
      }
      i = 0;
      label265:
      localFeedData.setLiveStatus(i);
      localObject = getFeedObject().liveInfo;
      if (localObject != null) {
        break label476;
      }
    }
    label311:
    label335:
    label467:
    label476:
    for (int i = j;; i = ((bip)localObject).DSe)
    {
      localFeedData.setOnlineNum(i);
      AppMethodBeat.o(332198);
      return localFeedData;
      l1 = ((dne)localObject).id;
      break;
      String str = ((FinderContact)localObject).username;
      localObject = str;
      if (str != null) {
        break label55;
      }
      localObject = "";
      break label55;
      str = ((dne)localObject).sessionBuffer;
      localObject = str;
      if (str != null) {
        break label78;
      }
      localObject = "";
      break label78;
      label359:
      str = ((FinderContact)localObject).nickname;
      localObject = str;
      if (str != null) {
        break label101;
      }
      localObject = "";
      break label101;
      label383:
      localObject = ((dne)localObject).aaUt;
      if (localObject == null)
      {
        localObject = "";
        break label124;
      }
      str = ((dnh)localObject).description;
      localObject = str;
      if (str != null) {
        break label124;
      }
      localObject = "";
      break label124;
      i = ((dne)localObject).urlValidDuration;
      break label153;
      l1 = ((bip)localObject).liveId;
      break label221;
      localObject = Integer.valueOf(((FinderContact)localObject).liveStatus);
      break label244;
      i = ((bip)localObject).liveStatus;
      break label265;
      i = ((Integer)localObject).intValue();
      break label265;
    }
  }
  
  public final boolean ejX()
  {
    AppMethodBeat.i(332157);
    dji localdji = (dji)p.oL((List)eDE());
    if (localdji != null)
    {
      if (localdji.width > localdji.height)
      {
        AppMethodBeat.o(332157);
        return true;
      }
      AppMethodBeat.o(332157);
      return false;
    }
    AppMethodBeat.o(332157);
    return false;
  }
  
  public final FinderObject getFeedObject()
  {
    AppMethodBeat.i(332043);
    FinderObject localFinderObject = this.feedObject;
    if (localFinderObject != null)
    {
      AppMethodBeat.o(332043);
      return localFinderObject;
    }
    s.bIx("feedObject");
    AppMethodBeat.o(332043);
    return null;
  }
  
  public final boolean isPrivate()
  {
    AppMethodBeat.i(332144);
    if ((getFeedObject().privateFlag == 1) || (eDI()))
    {
      AppMethodBeat.o(332144);
      return true;
    }
    AppMethodBeat.o(332144);
    return false;
  }
  
  public final void m(FinderObject paramFinderObject)
  {
    Object localObject = null;
    AppMethodBeat.i(332135);
    s.u(paramFinderObject, "data");
    setFeedObject(paramFinderObject);
    paramFinderObject = getFeedObject().attachmentList;
    if (paramFinderObject == null) {
      paramFinderObject = localObject;
    }
    for (;;)
    {
      this.ABK = paramFinderObject;
      this.contact = getFeedObject().contact;
      this.hlB = cn.bDw();
      AppMethodBeat.o(332135);
      return;
      paramFinderObject = paramFinderObject.ZEi;
      if (paramFinderObject == null)
      {
        paramFinderObject = localObject;
      }
      else
      {
        Iterator localIterator = ((Iterable)paramFinderObject).iterator();
        atq localatq;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          paramFinderObject = localIterator.next();
          localatq = (atq)paramFinderObject;
          av localav = av.GiL;
          s.s(localatq, "it");
        } while (!av.a(localatq));
        for (;;)
        {
          paramFinderObject = (atq)paramFinderObject;
          if (paramFinderObject != null) {
            break label149;
          }
          paramFinderObject = localObject;
          break;
          paramFinderObject = null;
        }
        label149:
        paramFinderObject = paramFinderObject.ZEf;
        if (paramFinderObject == null) {
          paramFinderObject = localObject;
        } else {
          paramFinderObject = paramFinderObject.ZXx;
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.ca
 * JD-Core Version:    0.7.0.1
 */