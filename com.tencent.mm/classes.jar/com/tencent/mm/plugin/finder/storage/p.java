package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.avs;
import com.tencent.mm.protocal.protobuf.avy;
import com.tencent.mm.protocal.protobuf.bfl;
import com.tencent.mm.protocal.protobuf.biv;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.a.v;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/FinderLbsItem;", "", "section", "Lcom/tencent/mm/protocal/protobuf/FinderNearbySection;", "(Lcom/tencent/mm/protocal/protobuf/FinderNearbySection;)V", "feedList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getFeedList", "()Ljava/util/LinkedList;", "iconType", "", "getIconType", "()I", "iconUrlDark", "", "getIconUrlDark", "()Ljava/lang/String;", "iconUrlLight", "getIconUrlLight", "id", "", "getId", "()J", "id$delegate", "Lkotlin/Lazy;", "moreActionType", "getMoreActionType", "relatedResp", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListResp;", "getRelatedResp", "()Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListResp;", "getSection", "()Lcom/tencent/mm/protocal/protobuf/FinderNearbySection;", "sectionDesc", "getSectionDesc", "sectionId", "getSectionId", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "getSectionInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "sectionSubTitle", "getSectionSubTitle", "sectionTitle", "getSectionTitle", "sectionType", "getSectionType", "streamResp", "Lcom/tencent/mm/protocal/protobuf/FinderStreamResponse;", "getStreamResp", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamResponse;", "topicResp", "Lcom/tencent/mm/protocal/protobuf/FinderGetTopicListResponse;", "getTopicResp", "()Lcom/tencent/mm/protocal/protobuf/FinderGetTopicListResponse;", "Companion", "plugin-finder_release"})
public final class p
{
  public static final a Alr;
  public final LinkedList<BaseFinderFeed> Alp;
  public final bfl Alq;
  public final f xzz;
  
  static
  {
    AppMethodBeat.i(279882);
    Alr = new a((byte)0);
    AppMethodBeat.o(279882);
  }
  
  public p(bfl parambfl)
  {
    AppMethodBeat.i(279881);
    this.Alq = parambfl;
    this.Alp = new LinkedList();
    LinkedList localLinkedList = this.Alp;
    parambfl = this.Alq.SGi;
    if (parambfl != null)
    {
      parambfl = (Iterable)parambfl;
      Object localObject1 = (Collection)new ArrayList();
      Object localObject2 = parambfl.iterator();
      Object localObject3;
      label135:
      label138:
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        parambfl = (FinderObject)localObject3;
        if (parambfl != null)
        {
          parambfl = parambfl.objectDesc;
          label107:
          if (parambfl == null) {
            break label135;
          }
        }
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label138;
          }
          ((Collection)localObject1).add(localObject3);
          break;
          parambfl = null;
          break label107;
        }
      }
      localObject1 = (Iterable)localObject1;
      parambfl = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (FinderObject)((Iterator)localObject1).next();
        localObject3 = FinderItem.Companion;
        kotlin.g.b.p.j(localObject2, "feed");
        localObject2 = FinderItem.a.b((FinderObject)localObject2, 1);
        localObject3 = c.AnK;
        parambfl.add(c.a.a((FinderItem)localObject2));
      }
    }
    for (parambfl = (Collection)parambfl;; parambfl = (Collection)v.aaAd)
    {
      localLinkedList.addAll(parambfl);
      this.xzz = g.ar((a)new b(this));
      AppMethodBeat.o(279881);
      return;
    }
  }
  
  public final String cKF()
  {
    AppMethodBeat.i(279875);
    String str2 = dYG().tBn;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    AppMethodBeat.o(279875);
    return str1;
  }
  
  public final biv dYG()
  {
    AppMethodBeat.i(279872);
    biv localbiv2 = this.Alq.xcZ;
    biv localbiv1 = localbiv2;
    if (localbiv2 == null)
    {
      localbiv1 = new biv();
      localbiv1.tBn = "";
      localbiv1.STc = "";
      localbiv1.STd = "";
      localbiv1.MqM = 0;
      localbiv1.STe = 0;
      localbiv1.STf = "";
      localbiv1.STg = "";
      localbiv1.RiL = "";
      localbiv1.lZJ = 0;
    }
    AppMethodBeat.o(279872);
    return localbiv1;
  }
  
  public final String dYH()
  {
    AppMethodBeat.i(279873);
    String str2 = dYG().STc;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    AppMethodBeat.o(279873);
    return str1;
  }
  
  public final String dYI()
  {
    AppMethodBeat.i(279876);
    String str2 = dYG().STd;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    AppMethodBeat.o(279876);
    return str1;
  }
  
  public final String dYJ()
  {
    AppMethodBeat.i(279877);
    String str2 = dYG().STf;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    AppMethodBeat.o(279877);
    return str1;
  }
  
  public final avy dYK()
  {
    AppMethodBeat.i(279878);
    avy localavy2 = dYG().STh;
    avy localavy1 = localavy2;
    if (localavy2 == null) {
      localavy1 = new avy();
    }
    AppMethodBeat.o(279878);
    return localavy1;
  }
  
  public final avs dYL()
  {
    AppMethodBeat.i(279880);
    avs localavs2 = dYG().STi;
    avs localavs1 = localavs2;
    if (localavs2 == null) {
      localavs1 = new avs();
    }
    AppMethodBeat.o(279880);
    return localavs1;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/FinderLbsItem$Companion;", "", "()V", "careSectionType", "", "sectionType", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<Long>
  {
    b(p paramp)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.p
 * JD-Core Version:    0.7.0.1
 */