package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aop;
import com.tencent.mm.protocal.protobuf.aoq;
import com.tencent.mm.protocal.protobuf.ayj;
import com.tencent.mm.protocal.protobuf.bei;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.protocal.protobuf.cni;
import com.tencent.mm.protocal.protobuf.cnl;
import com.tencent.mm.protocal.protobuf.cns;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "finderMegaVideo", "Lcom/tencent/mm/protocal/protobuf/FinderMegaVideo;", "(Lcom/tencent/mm/protocal/protobuf/FinderMegaVideo;)V", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "attachFinderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getAttachFinderItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setAttachFinderItem", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "bulletList", "", "Lcom/tencent/mm/protocal/protobuf/MegaVideoBulletCommentInfo;", "getBulletList", "()Ljava/util/List;", "contact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "getContact", "()Lcom/tencent/mm/protocal/protobuf/FinderContact;", "setContact", "(Lcom/tencent/mm/protocal/protobuf/FinderContact;)V", "createTimestamp", "", "getCreateTimestamp", "()J", "setCreateTimestamp", "(J)V", "feedObject", "getFeedObject", "()Lcom/tencent/mm/protocal/protobuf/FinderObject;", "setFeedObject", "getFinderMegaVideo", "()Lcom/tencent/mm/protocal/protobuf/FinderMegaVideo;", "setFinderMegaVideo", "hasAddToHistory", "", "getHasAddToHistory", "()Z", "setHasAddToHistory", "(Z)V", "hasDeleteFromHistory", "getHasDeleteFromHistory", "setHasDeleteFromHistory", "localId", "getLocalId", "setLocalId", "megaVideo", "Lcom/tencent/mm/protocal/protobuf/MegaVideo;", "getMegaVideo", "()Lcom/tencent/mm/protocal/protobuf/MegaVideo;", "setMegaVideo", "(Lcom/tencent/mm/protocal/protobuf/MegaVideo;)V", "value", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "megaVideoMediaList", "getMegaVideoMediaList", "()Ljava/util/LinkedList;", "setMegaVideoMediaList", "(Ljava/util/LinkedList;)V", "timestamps", "getTimestamps", "canShowBullet", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getFinderId", "getFinderNonceId", "", "getItemId", "getItemType", "isLandscapeVideo", "isPrivate", "isSpamForbiddenShare", "isSpamSetPrivate", "mergeBulletList", "", "data", "removeBullet", "", "bulletId", "updateData", "Companion", "plugin-finder_release"})
public final class bm
  implements bo
{
  public static final a uOY;
  public FinderContact contact;
  public FinderObject feedObject;
  public long localId;
  public final long timestamps;
  public cng tuP;
  private ayj uOS;
  public boolean uOT;
  public boolean uOU;
  public long uOV;
  public FinderItem uOW;
  public final List<cni> uOX;
  
  static
  {
    AppMethodBeat.i(248865);
    uOY = new a((byte)0);
    AppMethodBeat.o(248865);
  }
  
  public bm(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(248864);
    this.uOV = cl.aWA();
    this.timestamps = cl.aWA();
    FinderItem localFinderItem = this.uOW;
    long l;
    if (localFinderItem != null)
    {
      l = localFinderItem.getLocalId();
      this.localId = l;
      this.uOX = ((List)new ArrayList());
      this.feedObject = paramFinderObject;
      paramFinderObject = this.feedObject;
      if (paramFinderObject == null) {
        p.btv("feedObject");
      }
      this.contact = paramFinderObject.contact;
      paramFinderObject = this.feedObject;
      if (paramFinderObject == null) {
        p.btv("feedObject");
      }
      paramFinderObject = paramFinderObject.attachmentList;
      if (paramFinderObject == null) {
        break label169;
      }
      paramFinderObject = paramFinderObject.LAM;
      if (paramFinderObject == null) {
        break label169;
      }
      paramFinderObject = (aop)kotlin.a.j.kt((List)paramFinderObject);
      if (paramFinderObject == null) {
        break label169;
      }
      paramFinderObject = paramFinderObject.LAL;
      if (paramFinderObject == null) {
        break label169;
      }
    }
    label169:
    for (paramFinderObject = paramFinderObject.LIA;; paramFinderObject = null)
    {
      this.tuP = paramFinderObject;
      AppMethodBeat.o(248864);
      return;
      l = 0L;
      break;
    }
  }
  
  public bm(ayj paramayj)
  {
    AppMethodBeat.i(248863);
    this.uOV = cl.aWA();
    this.timestamps = cl.aWA();
    FinderItem localFinderItem = this.uOW;
    if (localFinderItem != null) {}
    for (long l = localFinderItem.getLocalId();; l = 0L)
    {
      this.localId = l;
      this.uOX = ((List)new ArrayList());
      this.uOS = paramayj;
      this.contact = paramayj.contact;
      this.tuP = paramayj.LIA;
      AppMethodBeat.o(248863);
      return;
    }
  }
  
  public final int a(i parami)
  {
    int j = 0;
    AppMethodBeat.i(248858);
    p.h(parami, "obj");
    if (!(parami instanceof bm)) {
      parami = null;
    }
    for (;;)
    {
      parami = (bm)parami;
      if (parami != null)
      {
        if ((parami.lT() != 0L) && (lT() != 0L) && (parami.lT() == lT()))
        {
          AppMethodBeat.o(248858);
          return 0;
        }
        parami = parami.tuP;
        if (parami != null) {}
        for (int i = parami.iXu;; i = 0)
        {
          parami = this.tuP;
          if (parami != null) {
            j = parami.iXu;
          }
          if (i <= j) {
            break;
          }
          AppMethodBeat.o(248858);
          return 1;
        }
      }
      AppMethodBeat.o(248858);
      return -1;
    }
  }
  
  public final int cxn()
  {
    AppMethodBeat.i(248857);
    int i = bm.class.hashCode();
    AppMethodBeat.o(248857);
    return i;
  }
  
  public final boolean djo()
  {
    AppMethodBeat.i(248862);
    cjl localcjl = (cjl)kotlin.a.j.kt((List)dkV());
    if (localcjl != null)
    {
      if (localcjl.width > localcjl.height)
      {
        AppMethodBeat.o(248862);
        return true;
      }
      AppMethodBeat.o(248862);
      return false;
    }
    AppMethodBeat.o(248862);
    return false;
  }
  
  public final LinkedList<cjl> dkV()
  {
    AppMethodBeat.i(248854);
    Object localObject = this.tuP;
    if (localObject != null)
    {
      localObject = ((cng)localObject).MtG;
      if (localObject != null)
      {
        localObject = ((cnl)localObject).media;
        if (localObject != null)
        {
          localObject = com.tencent.mm.plugin.finder.storage.data.j.aB((LinkedList)localObject);
          AppMethodBeat.o(248854);
          return localObject;
        }
      }
    }
    localObject = new LinkedList();
    AppMethodBeat.o(248854);
    return localObject;
  }
  
  public final long dkW()
  {
    AppMethodBeat.i(248855);
    if (this.uOS != null)
    {
      localObject = this.tuP;
      if (localObject != null)
      {
        localObject = ((cng)localObject).MtI;
        if (localObject != null)
        {
          l = ((cns)localObject).hFK;
          AppMethodBeat.o(248855);
          return l;
        }
      }
      AppMethodBeat.o(248855);
      return 0L;
    }
    Object localObject = this.feedObject;
    if (localObject == null) {
      p.btv("feedObject");
    }
    long l = ((FinderObject)localObject).id;
    AppMethodBeat.o(248855);
    return l;
  }
  
  public final String dkX()
  {
    AppMethodBeat.i(248856);
    Object localObject2;
    if (this.uOS != null)
    {
      localObject1 = this.tuP;
      if (localObject1 != null)
      {
        localObject1 = ((cng)localObject1).MtI;
        if (localObject1 != null)
        {
          localObject2 = ((cns)localObject1).objectNonceId;
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
        p.btv("feedObject");
      }
      localObject2 = ((FinderObject)localObject1).objectNonceId;
    }
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    AppMethodBeat.o(248856);
    return localObject1;
  }
  
  public final boolean dkY()
  {
    boolean bool = false;
    cng localcng = this.tuP;
    if (localcng != null) {}
    for (int i = localcng.MtH;; i = 0)
    {
      if (i != 0) {
        bool = true;
      }
      return bool;
    }
  }
  
  public final boolean dkZ()
  {
    boolean bool = false;
    cng localcng = this.tuP;
    if (localcng != null) {}
    for (int i = localcng.MtH;; i = 0)
    {
      if (i != 0) {
        bool = true;
      }
      return bool;
    }
  }
  
  public final List<cni> ej(List<? extends cni> paramList)
  {
    AppMethodBeat.i(248859);
    p.h(paramList, "data");
    List localList = (List)new ArrayList();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      cni localcni = (cni)paramList.next();
      Iterator localIterator = this.uOX.iterator();
      int i = 0;
      label68:
      int j;
      if (localIterator.hasNext()) {
        if (((cni)localIterator.next()).id == localcni.id)
        {
          j = 1;
          label102:
          if (j == 0) {
            break label155;
          }
        }
      }
      for (;;)
      {
        if (i < 0) {
          break label167;
        }
        Log.v("MegaVideoFeed", "mergeBulletList: remove exist bullet index = " + i + ", id = " + localcni.id);
        break;
        j = 0;
        break label102;
        label155:
        i += 1;
        break label68;
        i = -1;
      }
      label167:
      localList.add(localcni);
    }
    this.uOX.addAll((Collection)localList);
    Log.i("MegaVideoFeed", "mergeBulletList: bullet list size = " + this.uOX.size() + ", increase size = " + localList.size());
    AppMethodBeat.o(248859);
    return localList;
  }
  
  public final void g(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(248860);
    p.h(paramFinderObject, "data");
    this.feedObject = paramFinderObject;
    paramFinderObject = this.feedObject;
    if (paramFinderObject == null) {
      p.btv("feedObject");
    }
    paramFinderObject = paramFinderObject.attachmentList;
    if (paramFinderObject != null)
    {
      paramFinderObject = paramFinderObject.LAM;
      if (paramFinderObject != null)
      {
        paramFinderObject = (aop)kotlin.a.j.kt((List)paramFinderObject);
        if (paramFinderObject != null)
        {
          paramFinderObject = paramFinderObject.LAL;
          if (paramFinderObject == null) {}
        }
      }
    }
    for (paramFinderObject = paramFinderObject.LIA;; paramFinderObject = null)
    {
      this.tuP = paramFinderObject;
      paramFinderObject = this.feedObject;
      if (paramFinderObject == null) {
        p.btv("feedObject");
      }
      this.contact = paramFinderObject.contact;
      this.uOV = cl.aWA();
      AppMethodBeat.o(248860);
      return;
    }
  }
  
  public final FinderObject getFeedObject()
  {
    AppMethodBeat.i(248853);
    FinderObject localFinderObject = this.feedObject;
    if (localFinderObject == null) {
      p.btv("feedObject");
    }
    AppMethodBeat.o(248853);
    return localFinderObject;
  }
  
  public final boolean isPrivate()
  {
    AppMethodBeat.i(248861);
    FinderObject localFinderObject = this.feedObject;
    if (localFinderObject == null) {
      p.btv("feedObject");
    }
    if ((localFinderObject.privateFlag == 1) || (dkZ()))
    {
      AppMethodBeat.o(248861);
      return true;
    }
    AppMethodBeat.o(248861);
    return false;
  }
  
  public final long lT()
  {
    cng localcng = this.tuP;
    if (localcng != null) {
      return localcng.id;
    }
    return 0L;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.bm
 * JD-Core Version:    0.7.0.1
 */