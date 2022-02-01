package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.logic.b;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aox;
import com.tencent.mm.protocal.protobuf.apb;
import com.tencent.mm.protocal.protobuf.aqj;
import com.tencent.mm.protocal.protobuf.arv;
import d.a.v;
import d.f;
import d.g;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/storage/FinderLbsItem;", "", "section", "Lcom/tencent/mm/protocal/protobuf/FinderNearbySection;", "(Lcom/tencent/mm/protocal/protobuf/FinderNearbySection;)V", "feedList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getFeedList", "()Ljava/util/LinkedList;", "iconType", "", "getIconType", "()I", "iconUrlDark", "", "getIconUrlDark", "()Ljava/lang/String;", "iconUrlLight", "getIconUrlLight", "id", "", "getId", "()J", "id$delegate", "Lkotlin/Lazy;", "moreActionType", "getMoreActionType", "relatedResp", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListResp;", "getRelatedResp", "()Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListResp;", "getSection", "()Lcom/tencent/mm/protocal/protobuf/FinderNearbySection;", "sectionDesc", "getSectionDesc", "sectionId", "getSectionId", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "getSectionInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "sectionSubTitle", "getSectionSubTitle", "sectionTitle", "getSectionTitle", "sectionType", "getSectionType", "streamResp", "Lcom/tencent/mm/protocal/protobuf/FinderStreamResponse;", "getStreamResp", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamResponse;", "topicResp", "Lcom/tencent/mm/protocal/protobuf/FinderGetTopicListResponse;", "getTopicResp", "()Lcom/tencent/mm/protocal/protobuf/FinderGetTopicListResponse;", "Companion", "plugin-finder_release"})
public final class m
{
  public static final a sJn;
  public final LinkedList<BaseFinderFeed> sJl;
  public final aqj sJm;
  public final f sfg;
  
  static
  {
    AppMethodBeat.i(204263);
    sJn = new a((byte)0);
    AppMethodBeat.o(204263);
  }
  
  public m(aqj paramaqj)
  {
    AppMethodBeat.i(204262);
    this.sJm = paramaqj;
    this.sJl = new LinkedList();
    LinkedList localLinkedList = this.sJl;
    paramaqj = this.sJm.GFu;
    if (paramaqj != null)
    {
      paramaqj = (Iterable)paramaqj;
      Object localObject1 = (Collection)new ArrayList();
      Object localObject2 = paramaqj.iterator();
      Object localObject3;
      label135:
      label138:
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        paramaqj = (FinderObject)localObject3;
        if (paramaqj != null)
        {
          paramaqj = paramaqj.objectDesc;
          label107:
          if (paramaqj == null) {
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
          paramaqj = null;
          break label107;
        }
      }
      localObject1 = (Iterable)localObject1;
      paramaqj = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (FinderObject)((Iterator)localObject1).next();
        localObject3 = FinderItem.sJb;
        p.g(localObject2, "feed");
        localObject2 = FinderItem.a.a((FinderObject)localObject2, 1);
        localObject3 = b.sLq;
        paramaqj.add(b.a.j((FinderItem)localObject2));
      }
    }
    for (paramaqj = (Collection)paramaqj;; paramaqj = (Collection)v.NhH)
    {
      localLinkedList.addAll(paramaqj);
      this.sfg = g.O((a)new b(this));
      AppMethodBeat.o(204262);
      return;
    }
  }
  
  public final String bZm()
  {
    AppMethodBeat.i(204257);
    String str2 = cKZ().oRC;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    AppMethodBeat.o(204257);
    return str1;
  }
  
  public final arv cKZ()
  {
    AppMethodBeat.i(204255);
    arv localarv2 = this.sJm.rRJ;
    arv localarv1 = localarv2;
    if (localarv2 == null)
    {
      localarv1 = new arv();
      localarv1.oRC = "";
      localarv1.GIp = "";
      localarv1.GIq = "";
      localarv1.GIr = 0;
      localarv1.GIs = 0;
      localarv1.GIt = "";
      localarv1.GIu = "";
      localarv1.Frk = "";
      localarv1.ioG = 0;
    }
    AppMethodBeat.o(204255);
    return localarv1;
  }
  
  public final String cLa()
  {
    AppMethodBeat.i(204256);
    String str2 = cKZ().GIp;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    AppMethodBeat.o(204256);
    return str1;
  }
  
  public final String cLb()
  {
    AppMethodBeat.i(204258);
    String str2 = cKZ().GIq;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    AppMethodBeat.o(204258);
    return str1;
  }
  
  public final String cLc()
  {
    AppMethodBeat.i(204259);
    String str2 = cKZ().GIt;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    AppMethodBeat.o(204259);
    return str1;
  }
  
  public final apb cLd()
  {
    AppMethodBeat.i(204260);
    apb localapb2 = cKZ().GIv;
    apb localapb1 = localapb2;
    if (localapb2 == null) {
      localapb1 = new apb();
    }
    AppMethodBeat.o(204260);
    return localapb1;
  }
  
  public final aox cLe()
  {
    AppMethodBeat.i(204261);
    aox localaox2 = cKZ().GIw;
    aox localaox1 = localaox2;
    if (localaox2 == null) {
      localaox1 = new aox();
    }
    AppMethodBeat.o(204261);
    return localaox1;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/storage/FinderLbsItem$Companion;", "", "()V", "careSectionType", "", "sectionType", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<Long>
  {
    b(m paramm)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.m
 * JD-Core Version:    0.7.0.1
 */