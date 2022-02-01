package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.logic.b;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.alf;
import com.tencent.mm.protocal.protobuf.alj;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.anu;
import d.a.v;
import d.f;
import d.g;
import d.g.a.a;
import d.g.b.u;
import d.g.b.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/storage/FinderLbsItem;", "", "section", "Lcom/tencent/mm/protocal/protobuf/FinderNearbySection;", "(Lcom/tencent/mm/protocal/protobuf/FinderNearbySection;)V", "feedList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getFeedList", "()Ljava/util/LinkedList;", "iconType", "", "getIconType", "()I", "iconUrlDark", "", "getIconUrlDark", "()Ljava/lang/String;", "iconUrlLight", "getIconUrlLight", "id", "", "getId", "()J", "id$delegate", "Lkotlin/Lazy;", "moreActionType", "getMoreActionType", "relatedResp", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListResp;", "getRelatedResp", "()Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListResp;", "getSection", "()Lcom/tencent/mm/protocal/protobuf/FinderNearbySection;", "sectionDesc", "getSectionDesc", "sectionId", "getSectionId", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "getSectionInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "sectionSubTitle", "getSectionSubTitle", "sectionTitle", "getSectionTitle", "sectionType", "getSectionType", "streamResp", "Lcom/tencent/mm/protocal/protobuf/FinderStreamResponse;", "getStreamResp", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamResponse;", "topicResp", "Lcom/tencent/mm/protocal/protobuf/FinderGetTopicListResponse;", "getTopicResp", "()Lcom/tencent/mm/protocal/protobuf/FinderGetTopicListResponse;", "Companion", "plugin-finder_release"})
public final class j
{
  public static final j.a rDL;
  public final LinkedList<BaseFinderFeed> rDI;
  public final f rDJ;
  public final aml rDK;
  
  static
  {
    AppMethodBeat.i(202962);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(j.class), "id", "getId()J")) };
    rDL = new j.a((byte)0);
    AppMethodBeat.o(202962);
  }
  
  public j(aml paramaml)
  {
    AppMethodBeat.i(202970);
    this.rDK = paramaml;
    this.rDI = new LinkedList();
    LinkedList localLinkedList = this.rDI;
    paramaml = this.rDK.EEw;
    if (paramaml != null)
    {
      paramaml = (Iterable)paramaml;
      Object localObject1 = (Collection)new ArrayList();
      Object localObject2 = paramaml.iterator();
      Object localObject3;
      label135:
      label138:
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        paramaml = (FinderObject)localObject3;
        if (paramaml != null)
        {
          paramaml = paramaml.objectDesc;
          label107:
          if (paramaml == null) {
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
          paramaml = null;
          break label107;
        }
      }
      localObject1 = (Iterable)localObject1;
      paramaml = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (FinderObject)((Iterator)localObject1).next();
        localObject3 = FinderItem.rDA;
        d.g.b.k.g(localObject2, "feed");
        localObject2 = FinderItem.a.a((FinderObject)localObject2, 1);
        localObject3 = b.rFl;
        paramaml.add(b.a.i((FinderItem)localObject2));
      }
    }
    for (paramaml = (Collection)paramaml;; paramaml = (Collection)v.KTF)
    {
      localLinkedList.addAll(paramaml);
      this.rDJ = g.K((a)new b(this));
      AppMethodBeat.o(202970);
      return;
    }
  }
  
  public final String bTs()
  {
    AppMethodBeat.i(202965);
    String str2 = cAz().ohG;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    AppMethodBeat.o(202965);
    return str1;
  }
  
  public final String cAA()
  {
    AppMethodBeat.i(202964);
    String str2 = cAz().EGB;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    AppMethodBeat.o(202964);
    return str1;
  }
  
  public final String cAB()
  {
    AppMethodBeat.i(202966);
    String str2 = cAz().EGC;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    AppMethodBeat.o(202966);
    return str1;
  }
  
  public final String cAC()
  {
    AppMethodBeat.i(202967);
    String str2 = cAz().EGF;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    AppMethodBeat.o(202967);
    return str1;
  }
  
  public final alj cAD()
  {
    AppMethodBeat.i(202968);
    alj localalj2 = cAz().EGH;
    alj localalj1 = localalj2;
    if (localalj2 == null) {
      localalj1 = new alj();
    }
    AppMethodBeat.o(202968);
    return localalj1;
  }
  
  public final alf cAE()
  {
    AppMethodBeat.i(202969);
    alf localalf2 = cAz().EGI;
    alf localalf1 = localalf2;
    if (localalf2 == null) {
      localalf1 = new alf();
    }
    AppMethodBeat.o(202969);
    return localalf1;
  }
  
  public final anu cAz()
  {
    AppMethodBeat.i(202963);
    anu localanu2 = this.rDK.qYj;
    anu localanu1 = localanu2;
    if (localanu2 == null)
    {
      localanu1 = new anu();
      localanu1.ohG = "";
      localanu1.EGB = "";
      localanu1.EGC = "";
      localanu1.EGD = 0;
      localanu1.EGE = 0;
      localanu1.EGF = "";
      localanu1.EGG = "";
      localanu1.DtK = "";
      localanu1.hSw = 0;
    }
    AppMethodBeat.o(202963);
    return localanu1;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements a<Long>
  {
    b(j paramj)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.j
 * JD-Core Version:    0.7.0.1
 */