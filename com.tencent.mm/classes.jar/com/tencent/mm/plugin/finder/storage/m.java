package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.logic.b;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aok;
import com.tencent.mm.protocal.protobuf.aoo;
import com.tencent.mm.protocal.protobuf.apw;
import com.tencent.mm.protocal.protobuf.arg;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/FinderLbsItem;", "", "section", "Lcom/tencent/mm/protocal/protobuf/FinderNearbySection;", "(Lcom/tencent/mm/protocal/protobuf/FinderNearbySection;)V", "feedList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getFeedList", "()Ljava/util/LinkedList;", "iconType", "", "getIconType", "()I", "iconUrlDark", "", "getIconUrlDark", "()Ljava/lang/String;", "iconUrlLight", "getIconUrlLight", "id", "", "getId", "()J", "id$delegate", "Lkotlin/Lazy;", "moreActionType", "getMoreActionType", "relatedResp", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListResp;", "getRelatedResp", "()Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListResp;", "getSection", "()Lcom/tencent/mm/protocal/protobuf/FinderNearbySection;", "sectionDesc", "getSectionDesc", "sectionId", "getSectionId", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "getSectionInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "sectionSubTitle", "getSectionSubTitle", "sectionTitle", "getSectionTitle", "sectionType", "getSectionType", "streamResp", "Lcom/tencent/mm/protocal/protobuf/FinderStreamResponse;", "getStreamResp", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamResponse;", "topicResp", "Lcom/tencent/mm/protocal/protobuf/FinderGetTopicListResponse;", "getTopicResp", "()Lcom/tencent/mm/protocal/protobuf/FinderGetTopicListResponse;", "Companion", "plugin-finder_release"})
public final class m
{
  public static final a syw;
  public final f rWv;
  public final LinkedList<BaseFinderFeed> syu;
  public final apw syv;
  
  static
  {
    AppMethodBeat.i(203695);
    syw = new a((byte)0);
    AppMethodBeat.o(203695);
  }
  
  public m(apw paramapw)
  {
    AppMethodBeat.i(203694);
    this.syv = paramapw;
    this.syu = new LinkedList();
    LinkedList localLinkedList = this.syu;
    paramapw = this.syv.Gmm;
    if (paramapw != null)
    {
      paramapw = (Iterable)paramapw;
      Object localObject1 = (Collection)new ArrayList();
      Object localObject2 = paramapw.iterator();
      Object localObject3;
      label135:
      label138:
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        paramapw = (FinderObject)localObject3;
        if (paramapw != null)
        {
          paramapw = paramapw.objectDesc;
          label107:
          if (paramapw == null) {
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
          paramapw = null;
          break label107;
        }
      }
      localObject1 = (Iterable)localObject1;
      paramapw = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (FinderObject)((Iterator)localObject1).next();
        localObject3 = FinderItem.syk;
        p.g(localObject2, "feed");
        localObject2 = FinderItem.a.a((FinderObject)localObject2, 1);
        localObject3 = b.sAs;
        paramapw.add(b.a.j((FinderItem)localObject2));
      }
    }
    for (paramapw = (Collection)paramapw;; paramapw = (Collection)v.MKE)
    {
      localLinkedList.addAll(paramapw);
      this.rWv = g.O((a)new b(this));
      AppMethodBeat.o(203694);
      return;
    }
  }
  
  public final String bXX()
  {
    AppMethodBeat.i(203689);
    String str2 = cIu().oLa;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    AppMethodBeat.o(203689);
    return str1;
  }
  
  public final arg cIu()
  {
    AppMethodBeat.i(203687);
    arg localarg2 = this.syv.rJv;
    arg localarg1 = localarg2;
    if (localarg2 == null)
    {
      localarg1 = new arg();
      localarg1.oLa = "";
      localarg1.GoZ = "";
      localarg1.Gpa = "";
      localarg1.Gpb = 0;
      localarg1.Gpc = 0;
      localarg1.Gpd = "";
      localarg1.Gpe = "";
      localarg1.EYP = "";
      localarg1.ilN = 0;
    }
    AppMethodBeat.o(203687);
    return localarg1;
  }
  
  public final String cIv()
  {
    AppMethodBeat.i(203688);
    String str2 = cIu().GoZ;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    AppMethodBeat.o(203688);
    return str1;
  }
  
  public final String cIw()
  {
    AppMethodBeat.i(203690);
    String str2 = cIu().Gpa;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    AppMethodBeat.o(203690);
    return str1;
  }
  
  public final String cIx()
  {
    AppMethodBeat.i(203691);
    String str2 = cIu().Gpd;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    AppMethodBeat.o(203691);
    return str1;
  }
  
  public final aoo cIy()
  {
    AppMethodBeat.i(203692);
    aoo localaoo2 = cIu().Gpf;
    aoo localaoo1 = localaoo2;
    if (localaoo2 == null) {
      localaoo1 = new aoo();
    }
    AppMethodBeat.o(203692);
    return localaoo1;
  }
  
  public final aok cIz()
  {
    AppMethodBeat.i(203693);
    aok localaok2 = cIu().Gpg;
    aok localaok1 = localaok2;
    if (localaok2 == null) {
      localaok1 = new aok();
    }
    AppMethodBeat.o(203693);
    return localaok1;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/FinderLbsItem$Companion;", "", "()V", "careSectionType", "", "sectionType", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
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