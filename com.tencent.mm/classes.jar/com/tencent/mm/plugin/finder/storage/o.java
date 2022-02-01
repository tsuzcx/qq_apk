package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.atp;
import com.tencent.mm.protocal.protobuf.atv;
import com.tencent.mm.protocal.protobuf.azm;
import com.tencent.mm.protocal.protobuf.bcc;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.a.v;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/FinderLbsItem;", "", "section", "Lcom/tencent/mm/protocal/protobuf/FinderNearbySection;", "(Lcom/tencent/mm/protocal/protobuf/FinderNearbySection;)V", "feedList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getFeedList", "()Ljava/util/LinkedList;", "iconType", "", "getIconType", "()I", "iconUrlDark", "", "getIconUrlDark", "()Ljava/lang/String;", "iconUrlLight", "getIconUrlLight", "id", "", "getId", "()J", "id$delegate", "Lkotlin/Lazy;", "moreActionType", "getMoreActionType", "relatedResp", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListResp;", "getRelatedResp", "()Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListResp;", "getSection", "()Lcom/tencent/mm/protocal/protobuf/FinderNearbySection;", "sectionDesc", "getSectionDesc", "sectionId", "getSectionId", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "getSectionInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "sectionSubTitle", "getSectionSubTitle", "sectionTitle", "getSectionTitle", "sectionType", "getSectionType", "streamResp", "Lcom/tencent/mm/protocal/protobuf/FinderStreamResponse;", "getStreamResp", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamResponse;", "topicResp", "Lcom/tencent/mm/protocal/protobuf/FinderGetTopicListResponse;", "getTopicResp", "()Lcom/tencent/mm/protocal/protobuf/FinderGetTopicListResponse;", "Companion", "plugin-finder_release"})
public final class o
{
  public static final a vEb;
  public final f tON;
  public final LinkedList<BaseFinderFeed> vDZ;
  public final azm vEa;
  
  static
  {
    AppMethodBeat.i(251776);
    vEb = new a((byte)0);
    AppMethodBeat.o(251776);
  }
  
  public o(azm paramazm)
  {
    AppMethodBeat.i(251775);
    this.vEa = paramazm;
    this.vDZ = new LinkedList();
    LinkedList localLinkedList = this.vDZ;
    paramazm = this.vEa.LCW;
    if (paramazm != null)
    {
      paramazm = (Iterable)paramazm;
      Object localObject1 = (Collection)new ArrayList();
      Object localObject2 = paramazm.iterator();
      Object localObject3;
      label135:
      label138:
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        paramazm = (FinderObject)localObject3;
        if (paramazm != null)
        {
          paramazm = paramazm.objectDesc;
          label107:
          if (paramazm == null) {
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
          paramazm = null;
          break label107;
        }
      }
      localObject1 = (Iterable)localObject1;
      paramazm = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (FinderObject)((Iterator)localObject1).next();
        localObject3 = FinderItem.Companion;
        p.g(localObject2, "feed");
        localObject2 = FinderItem.a.a((FinderObject)localObject2, 1);
        localObject3 = c.vGN;
        paramazm.add(c.a.s((FinderItem)localObject2));
      }
    }
    for (paramazm = (Collection)paramazm;; paramazm = (Collection)v.SXr)
    {
      localLinkedList.addAll(paramazm);
      this.tON = g.ah((a)new b(this));
      AppMethodBeat.o(251775);
      return;
    }
  }
  
  public final String cxc()
  {
    AppMethodBeat.i(251770);
    String str2 = dxE().qfq;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    AppMethodBeat.o(251770);
    return str1;
  }
  
  public final bcc dxE()
  {
    AppMethodBeat.i(251768);
    bcc localbcc2 = this.vEa.tvs;
    bcc localbcc1 = localbcc2;
    if (localbcc2 == null)
    {
      localbcc1 = new bcc();
      localbcc1.qfq = "";
      localbcc1.LLm = "";
      localbcc1.LLn = "";
      localbcc1.FVr = 0;
      localbcc1.LLo = 0;
      localbcc1.LLp = "";
      localbcc1.LLq = "";
      localbcc1.Kib = "";
      localbcc1.jjN = 0;
    }
    AppMethodBeat.o(251768);
    return localbcc1;
  }
  
  public final String dxF()
  {
    AppMethodBeat.i(251769);
    String str2 = dxE().LLm;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    AppMethodBeat.o(251769);
    return str1;
  }
  
  public final String dxG()
  {
    AppMethodBeat.i(251771);
    String str2 = dxE().LLn;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    AppMethodBeat.o(251771);
    return str1;
  }
  
  public final String dxH()
  {
    AppMethodBeat.i(251772);
    String str2 = dxE().LLp;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    AppMethodBeat.o(251772);
    return str1;
  }
  
  public final atv dxI()
  {
    AppMethodBeat.i(251773);
    atv localatv2 = dxE().LLr;
    atv localatv1 = localatv2;
    if (localatv2 == null) {
      localatv1 = new atv();
    }
    AppMethodBeat.o(251773);
    return localatv1;
  }
  
  public final atp dxJ()
  {
    AppMethodBeat.i(251774);
    atp localatp2 = dxE().LLs;
    atp localatp1 = localatp2;
    if (localatp2 == null) {
      localatp1 = new atp();
    }
    AppMethodBeat.o(251774);
    return localatp1;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/FinderLbsItem$Companion;", "", "()V", "careSectionType", "", "sectionType", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<Long>
  {
    b(o paramo)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.o
 * JD-Core Version:    0.7.0.1
 */