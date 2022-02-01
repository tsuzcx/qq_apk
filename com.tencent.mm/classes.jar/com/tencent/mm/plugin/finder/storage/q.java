package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.logic.d;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.baw;
import com.tencent.mm.protocal.protobuf.bbg;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.protocal.protobuf.bve;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FinderLbsItem;", "", "section", "Lcom/tencent/mm/protocal/protobuf/FinderNearbySection;", "(Lcom/tencent/mm/protocal/protobuf/FinderNearbySection;)V", "feedList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getFeedList", "()Ljava/util/LinkedList;", "iconType", "", "getIconType", "()I", "iconUrlDark", "", "getIconUrlDark", "()Ljava/lang/String;", "iconUrlLight", "getIconUrlLight", "id", "", "getId", "()J", "id$delegate", "Lkotlin/Lazy;", "moreActionType", "getMoreActionType", "relatedResp", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListResp;", "getRelatedResp", "()Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListResp;", "getSection", "()Lcom/tencent/mm/protocal/protobuf/FinderNearbySection;", "sectionDesc", "getSectionDesc", "sectionId", "getSectionId", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "getSectionInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "sectionSubTitle", "getSectionSubTitle", "sectionTitle", "getSectionTitle", "sectionType", "getSectionType", "streamResp", "Lcom/tencent/mm/protocal/protobuf/FinderStreamResponse;", "getStreamResp", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamResponse;", "topicResp", "Lcom/tencent/mm/protocal/protobuf/FinderGetTopicListResponse;", "getTopicResp", "()Lcom/tencent/mm/protocal/protobuf/FinderGetTopicListResponse;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
{
  public static final a FKQ;
  private final j AXa;
  public final bqs FKR;
  public final LinkedList<BaseFinderFeed> FKS;
  
  static
  {
    AppMethodBeat.i(339273);
    FKQ = new a((byte)0);
    AppMethodBeat.o(339273);
  }
  
  public q(bqs parambqs)
  {
    AppMethodBeat.i(339264);
    this.FKR = parambqs;
    this.FKS = new LinkedList();
    LinkedList localLinkedList = this.FKS;
    parambqs = this.FKR.ZIQ;
    if (parambqs == null)
    {
      parambqs = null;
      if (parambqs != null) {
        break label295;
      }
    }
    label150:
    label295:
    for (parambqs = (Collection)ab.aivy;; parambqs = (Collection)parambqs)
    {
      localLinkedList.addAll(parambqs);
      this.AXa = k.cm((a)new b(this));
      AppMethodBeat.o(339264);
      return;
      parambqs = (Iterable)parambqs;
      Object localObject1 = (Collection)new ArrayList();
      Object localObject2 = parambqs.iterator();
      Object localObject3;
      label181:
      label184:
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        parambqs = (FinderObject)localObject3;
        if (parambqs == null)
        {
          parambqs = null;
          if (parambqs == null) {
            break label181;
          }
        }
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label184;
          }
          ((Collection)localObject1).add(localObject3);
          break;
          parambqs = parambqs.objectDesc;
          break label150;
        }
      }
      localObject1 = (Iterable)localObject1;
      parambqs = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (FinderObject)((Iterator)localObject1).next();
        localObject3 = FinderItem.Companion;
        s.s(localObject2, "feed");
        localObject2 = FinderItem.a.e((FinderObject)localObject2, 1);
        localObject3 = d.FND;
        localObject2 = d.a.a((FinderItem)localObject2);
        if (localObject2 != null) {
          parambqs.add(localObject2);
        }
      }
      parambqs = (List)parambqs;
      break;
    }
  }
  
  public final String dnV()
  {
    AppMethodBeat.i(339311);
    String str = eZn().wFL;
    if (str == null)
    {
      AppMethodBeat.o(339311);
      return "";
    }
    AppMethodBeat.o(339311);
    return str;
  }
  
  public final bve eZn()
  {
    AppMethodBeat.i(339293);
    bve localbve = this.FKR.ACr;
    if (localbve == null)
    {
      localbve = new bve();
      localbve.wFL = "";
      localbve.aacF = "";
      localbve.aacG = "";
      localbve.STX = 0;
      localbve.aacH = 0;
      localbve.aacI = "";
      localbve.aacJ = "";
      localbve.PNd = "";
      localbve.qvo = 0;
      AppMethodBeat.o(339293);
      return localbve;
    }
    AppMethodBeat.o(339293);
    return localbve;
  }
  
  public final String eZo()
  {
    AppMethodBeat.i(339301);
    String str = eZn().aacF;
    if (str == null)
    {
      AppMethodBeat.o(339301);
      return "";
    }
    AppMethodBeat.o(339301);
    return str;
  }
  
  public final String eZp()
  {
    AppMethodBeat.i(339322);
    String str = eZn().aacG;
    if (str == null)
    {
      AppMethodBeat.o(339322);
      return "";
    }
    AppMethodBeat.o(339322);
    return str;
  }
  
  public final String eZq()
  {
    AppMethodBeat.i(339330);
    String str = eZn().aacI;
    if (str == null)
    {
      AppMethodBeat.o(339330);
      return "";
    }
    AppMethodBeat.o(339330);
    return str;
  }
  
  public final bbg eZr()
  {
    AppMethodBeat.i(339338);
    bbg localbbg = eZn().aacK;
    if (localbbg == null)
    {
      localbbg = new bbg();
      AppMethodBeat.o(339338);
      return localbbg;
    }
    AppMethodBeat.o(339338);
    return localbbg;
  }
  
  public final baw eZs()
  {
    AppMethodBeat.i(339346);
    baw localbaw = eZn().aacL;
    if (localbaw == null)
    {
      localbaw = new baw();
      AppMethodBeat.o(339346);
      return localbaw;
    }
    AppMethodBeat.o(339346);
    return localbaw;
  }
  
  public final long getId()
  {
    AppMethodBeat.i(339283);
    long l = ((Number)this.AXa.getValue()).longValue();
    AppMethodBeat.o(339283);
    return l;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FinderLbsItem$Companion;", "", "()V", "careSectionType", "", "sectionType", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<Long>
  {
    b(q paramq)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.q
 * JD-Core Version:    0.7.0.1
 */