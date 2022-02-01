package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.logic.b;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aji;
import com.tencent.mm.protocal.protobuf.dza;
import com.tencent.mm.protocal.protobuf.dzm;
import com.tencent.mm.protocal.protobuf.dzq;
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

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/storage/FinderLbsItem;", "", "section", "Lcom/tencent/mm/protocal/protobuf/FinderNearbySection;", "(Lcom/tencent/mm/protocal/protobuf/FinderNearbySection;)V", "feedList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getFeedList", "()Ljava/util/LinkedList;", "iconType", "", "getIconType", "()I", "iconUrlDark", "", "getIconUrlDark", "()Ljava/lang/String;", "iconUrlLight", "getIconUrlLight", "id", "", "getId", "()J", "id$delegate", "Lkotlin/Lazy;", "moreActionType", "getMoreActionType", "relatedResp", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListResp;", "getRelatedResp", "()Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListResp;", "getSection", "()Lcom/tencent/mm/protocal/protobuf/FinderNearbySection;", "sectionDesc", "getSectionDesc", "sectionId", "getSectionId", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "getSectionInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "sectionSubTitle", "getSectionSubTitle", "sectionTitle", "getSectionTitle", "sectionType", "getSectionType", "streamResp", "Lcom/tencent/mm/protocal/protobuf/FinderStreamResponse;", "getStreamResp", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamResponse;", "topicResp", "Lcom/tencent/mm/protocal/protobuf/FinderGetTopicListResponse;", "getTopicResp", "()Lcom/tencent/mm/protocal/protobuf/FinderGetTopicListResponse;", "Companion", "plugin-finder_release"})
public final class p
{
  public static final a KWL;
  public final LinkedList<BaseFinderFeed> KWI;
  public final f KWJ;
  public final dzm KWK;
  
  static
  {
    AppMethodBeat.i(198998);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(p.class), "id", "getId()J")) };
    KWL = new a((byte)0);
    AppMethodBeat.o(198998);
  }
  
  public p(dzm paramdzm)
  {
    AppMethodBeat.i(199006);
    this.KWK = paramdzm;
    this.KWI = new LinkedList();
    LinkedList localLinkedList = this.KWI;
    paramdzm = this.KWK.Dlg;
    if (paramdzm != null)
    {
      paramdzm = (Iterable)paramdzm;
      Object localObject1 = (Collection)new ArrayList();
      Object localObject2 = paramdzm.iterator();
      Object localObject3;
      label135:
      label138:
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        paramdzm = (FinderObject)localObject3;
        if (paramdzm != null)
        {
          paramdzm = paramdzm.objectDesc;
          label107:
          if (paramdzm == null) {
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
          paramdzm = null;
          break label107;
        }
      }
      localObject1 = (Iterable)localObject1;
      paramdzm = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (FinderObject)((Iterator)localObject1).next();
        localObject3 = FinderItem.qJU;
        d.g.b.k.g(localObject2, "feed");
        localObject2 = FinderItem.a.a((FinderObject)localObject2, 1);
        localObject3 = b.qKG;
        paramdzm.add(b.a.h((FinderItem)localObject2));
      }
    }
    for (paramdzm = (Collection)paramdzm;; paramdzm = (Collection)v.Jgl)
    {
      localLinkedList.addAll(paramdzm);
      this.KWJ = g.E((a)new b(this));
      AppMethodBeat.o(199006);
      return;
    }
  }
  
  public final String bMf()
  {
    AppMethodBeat.i(199001);
    String str2 = fUQ().nEF;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    AppMethodBeat.o(199001);
    return str1;
  }
  
  public final dzq fUQ()
  {
    AppMethodBeat.i(198999);
    dzq localdzq2 = this.KWK.KJJ;
    dzq localdzq1 = localdzq2;
    if (localdzq2 == null)
    {
      localdzq1 = new dzq();
      localdzq1.nEF = "";
      localdzq1.Lyd = "";
      localdzq1.Lye = "";
      localdzq1.Lyf = 0;
      localdzq1.Lyg = 0;
      localdzq1.Lyh = "";
      localdzq1.Lyi = "";
      localdzq1.Cbs = "";
      localdzq1.hrU = 0;
    }
    AppMethodBeat.o(198999);
    return localdzq1;
  }
  
  public final String fUR()
  {
    AppMethodBeat.i(199000);
    String str2 = fUQ().Lyd;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    AppMethodBeat.o(199000);
    return str1;
  }
  
  public final String fUS()
  {
    AppMethodBeat.i(199002);
    String str2 = fUQ().Lye;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    AppMethodBeat.o(199002);
    return str1;
  }
  
  public final String fUT()
  {
    AppMethodBeat.i(199003);
    String str2 = fUQ().Lyh;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    AppMethodBeat.o(199003);
    return str1;
  }
  
  public final aji fUU()
  {
    AppMethodBeat.i(199004);
    aji localaji2 = fUQ().Lyj;
    aji localaji1 = localaji2;
    if (localaji2 == null) {
      localaji1 = new aji();
    }
    AppMethodBeat.o(199004);
    return localaji1;
  }
  
  public final dza fUV()
  {
    AppMethodBeat.i(199005);
    dza localdza2 = fUQ().Lyl;
    dza localdza1 = localdza2;
    if (localdza2 == null) {
      localdza1 = new dza();
    }
    AppMethodBeat.o(199005);
    return localdza1;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/storage/FinderLbsItem$Companion;", "", "()V", "careSectionType", "", "sectionType", "", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements a<Long>
  {
    b(p paramp)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.p
 * JD-Core Version:    0.7.0.1
 */