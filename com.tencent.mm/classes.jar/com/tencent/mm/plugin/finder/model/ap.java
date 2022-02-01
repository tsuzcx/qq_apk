package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.api.d;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.plugin.finder.storage.data.i;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.blf;
import com.tencent.mm.protocal.protobuf.bug;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/model/FinderLiveReplayFeed;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "finderObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "getFinderObj", "()Lcom/tencent/mm/protocal/protobuf/FinderObject;", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getAvatarUrl", "", "getContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "getCoverUrl", "getDesc", "getItemId", "", "getItemType", "getNickName", "getReplayStatus", "getReplayUrl", "isMyReplay", "", "isPurchased", "noReplay", "producingReplay", "purchaseInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLivePurchaseInfo;", "ready", "replayDelete", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ap
  implements cc
{
  public static final a ECZ;
  public final FinderObject EDa;
  
  static
  {
    AppMethodBeat.i(332051);
    ECZ = new a((byte)0);
    AppMethodBeat.o(332051);
  }
  
  public ap(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(332046);
    this.EDa = paramFinderObject;
    AppMethodBeat.o(332046);
  }
  
  public final int a(k paramk)
  {
    Object localObject = null;
    AppMethodBeat.i(332071);
    s.u(paramk, "obj");
    bip localbip;
    long l;
    if ((paramk instanceof ap))
    {
      paramk = (ap)paramk;
      if (paramk == null) {
        break label134;
      }
      localbip = paramk.EDa.liveInfo;
      if (localbip != null) {
        break label101;
      }
      l = 0L;
      label46:
      if (l <= 0L) {
        break label134;
      }
      paramk = paramk.EDa.liveInfo;
      if (paramk != null) {
        break label110;
      }
      paramk = null;
      label66:
      localbip = this.EDa.liveInfo;
      if (localbip != null) {
        break label121;
      }
    }
    for (;;)
    {
      if (!s.p(paramk, localObject)) {
        break label134;
      }
      AppMethodBeat.o(332071);
      return 0;
      paramk = null;
      break;
      label101:
      l = localbip.liveId;
      break label46;
      label110:
      paramk = Long.valueOf(paramk.liveId);
      break label66;
      label121:
      localObject = Long.valueOf(localbip.liveId);
    }
    label134:
    AppMethodBeat.o(332071);
    return -1;
  }
  
  public final long bZA()
  {
    AppMethodBeat.i(332061);
    long l = hashCode();
    AppMethodBeat.o(332061);
    return l;
  }
  
  public final int bZB()
  {
    AppMethodBeat.i(332065);
    int i = ap.class.hashCode();
    AppMethodBeat.o(332065);
    return i;
  }
  
  public final String dUD()
  {
    AppMethodBeat.i(332082);
    Object localObject = this.EDa.objectDesc;
    if (localObject == null) {
      localObject = null;
    }
    while (localObject == null)
    {
      AppMethodBeat.o(332082);
      return "";
      localObject = ((FinderObjectDesc)localObject).media;
      if (localObject == null)
      {
        localObject = null;
      }
      else
      {
        localObject = (FinderMedia)p.oL((List)localObject);
        if (localObject == null) {
          localObject = null;
        } else {
          localObject = i.c((FinderMedia)localObject);
        }
      }
    }
    localObject = s.X(((dji)localObject).thumbUrl, Util.nullAsNil(((dji)localObject).thumb_url_token));
    if (localObject == null)
    {
      AppMethodBeat.o(332082);
      return "";
    }
    AppMethodBeat.o(332082);
    return localObject;
  }
  
  public final int eDq()
  {
    bip localbip = this.EDa.liveInfo;
    if (localbip == null) {
      return 0;
    }
    return localbip.replay_status;
  }
  
  public final String eDr()
  {
    Object localObject = this.EDa.liveInfo;
    if (localObject == null) {
      localObject = "";
    }
    String str;
    do
    {
      return localObject;
      str = ((bip)localObject).ZRm;
      localObject = str;
    } while (str != null);
    return "";
  }
  
  public final blf eDs()
  {
    bip localbip = this.EDa.liveInfo;
    if (localbip == null) {
      return null;
    }
    return localbip.ZSc;
  }
  
  public final boolean eDt()
  {
    AppMethodBeat.i(332124);
    boolean bool = ((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).isReplayLive(this.EDa.liveInfo);
    AppMethodBeat.o(332124);
    return bool;
  }
  
  public final m getContact()
  {
    AppMethodBeat.i(332119);
    Object localObject = d.AwY;
    localObject = d.a.auT(this.EDa.username);
    AppMethodBeat.o(332119);
    return localObject;
  }
  
  public final String getDesc()
  {
    Object localObject = this.EDa.objectDesc;
    if (localObject == null) {
      localObject = "";
    }
    String str;
    do
    {
      return localObject;
      str = ((FinderObjectDesc)localObject).description;
      localObject = str;
    } while (str != null);
    return "";
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/model/FinderLiveReplayFeed$Companion;", "", "()V", "toFinderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "liveInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveInfo;", "objectId", "", "liveId", "anchorUserName", "", "nonceId", "desc", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveInfo;JLjava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/FinderObject;", "toFinderReplayLiveBase", "Lcom/tencent/mm/protocal/protobuf/FinderReplayLiveBase;", "feeds", "", "Lcom/tencent/mm/plugin/finder/model/FinderLiveReplayFeed;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "continueFlag", "", "pos", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static bug a(List<ap> paramList, com.tencent.mm.bx.b paramb, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(331988);
      s.u(paramList, "feeds");
      bug localbug = new bug();
      Object localObject = (Iterable)paramList;
      paramList = (Collection)new ArrayList(p.a((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramList.add(((ap)((Iterator)localObject).next()).EDa);
      }
      localbug.ZIQ = new LinkedList((Collection)paramList);
      localbug.ZEQ = paramb;
      localbug.BeA = paramInt1;
      localbug.aabZ = paramInt2;
      AppMethodBeat.o(331988);
      return localbug;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.ap
 * JD-Core Version:    0.7.0.1
 */